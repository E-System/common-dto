package com.es.lib.dto

import spock.lang.Specification

import java.util.function.BiConsumer

class PatcherSpec extends Specification {

    def "Rules all"() {
        when:
        DTO dto = new DTO("NAME", "NAME2", new DTOInternal(1), EntityCode.CODE.name(), true)
        Entity entity = new Entity()
        Patcher.create(dto, entity, Arrays.asList("name", "name2", "role", "code", "valid"))
            .rule("name", DTO::getName, Entity::setName)
            .rule("name2", new BiConsumer<DTO, Entity>() {
                @Override
                void accept(DTO from, Entity to) {
                    to.setName2(from.getName2())
                }
            })
            .rule("role", DTO::getRole, Entity::setRole, v -> new EntityInternal(v.getId()))
            .rule("code", DTO::getCode, Entity::setCode, EntityCode::valueOf)
            .apply()
        then:
        entity.name == dto.name
        entity.name2 == dto.name2
        entity.role.id == dto.role.id
        entity.code.name() == dto.code
    }

    def "Rules all with null fields"() {
        when:
        DTO dto = new DTO("NAME", "NAME2", new DTOInternal(1), EntityCode.CODE.name(), true)
        Entity entity = new Entity()
        Patcher.create(dto, entity)
            .rule("name", DTO::getName, Entity::setName)
            .rule("name2", new BiConsumer<DTO, Entity>() {
                @Override
                void accept(DTO from, Entity to) {
                    to.setName2(from.getName2())
                }
            })
            .rule("role", DTO::getRole, Entity::setRole, v -> new EntityInternal(v.getId()))
            .rule("code", DTO::getCode, Entity::setCode, EntityCode::valueOf)
            .rule("valid", DTO::isValid, Entity::setValid)
            .apply()
        then:
        entity.name == dto.name
        entity.name2 == dto.name2
        entity.role.id == dto.role.id
        entity.code.name() == dto.code
    }

    def "Rules partial"() {
        when:
        DTO dto = new DTO("NAME", "NAME2", new DTOInternal(1), EntityCode.CODE.name(), true)
        Entity entity = new Entity()
        Patcher.create(dto, entity, Arrays.asList("name", "code"))
            .rule("name", DTO::getName, Entity::setName)
            .rule("name2", new BiConsumer<DTO, Entity>() {
                @Override
                void accept(DTO from, Entity to) {
                    to.setName2(from.getName2())
                }
            })
            .rule("role", DTO::getRole, Entity::setRole, v -> new EntityInternal(v.getId()))
            .rule("code", DTO::getCode, Entity::setCode, EntityCode::valueOf)
            .apply()
        then:
        entity.name == dto.name
        entity.name2 == null
        entity.role == null
        entity.code.name() == dto.code
    }

    def "Rules with reflective"() {
        when:
        DTO dto = new DTO("NAME", "NAME2", new DTOInternal(1), EntityCode.CODE.name(), true)
        Entity entity = new Entity()
        Patcher.create(dto, entity, Arrays.asList("name", "name2", "role", "code", "valid"))
            .rule("name")
            .rule("name2")
            .rule("valid")
            .rule("role", DTO::getRole, Entity::setRole, v -> new EntityInternal(v.getId()))
            .rule("code", DTO::getCode, Entity::setCode, EntityCode::valueOf)
            .apply()
        then:
        entity.name == dto.name
        entity.name2 == dto.name2
        entity.role.id == dto.role.id
        entity.code.name() == dto.code
        entity.valid == dto.valid
    }

    def "On change fields"(){
        when:
        DTO dto = new DTO("NAME", "NAME2", new DTOInternal(1), EntityCode.CODE.name(), true)
        Entity entity = new Entity()
        def items = Patcher.create(dto, entity, Arrays.asList("name", "name2", "role", "code", "valid"))
            .rule("name", true)
            .rule("name2", true)
            .rule("valid", true)
            .rule("role", DTO::getRole, Entity::setRole, v -> new EntityInternal(v.getId()))
            .rule("code", DTO::getCode, Entity::setCode, EntityCode::valueOf, Entity::getCode, v->v.toString())
            .apply()
        then:
        !items.empty
        items.size() == 4
        items[0].field == 'name'
        items[0].was == null
        items[0].became == 'NAME'
        items[1].field == 'name2'
        items[1].was == null
        items[1].became == 'NAME2'
        items[2].field == 'valid'
        items[2].was == 'false'
        items[2].became == 'true'
        items[3].field == 'code'
        items[3].was == null
        items[3].became == 'CODE'
    }

    static class DTOInternal {

        Integer id

        DTOInternal(Integer id) {
            this.id = id
        }
    }

    static class DTO {

        String name
        String name2
        DTOInternal role
        String code
        boolean valid

        DTO(String name, String name2, DTOInternal role, String code, boolean valid) {
            this.name = name
            this.name2 = name2
            this.role = role
            this.code = code
            this.valid = valid
        }
    }

    static class EntityInternal {

        Integer id

        EntityInternal(Integer id) {
            this.id = id
        }
    }

    enum EntityCode {
        CODE
    }

    static class Entity {

        String name
        String name2
        EntityInternal role
        EntityCode code
        boolean valid
    }
}
