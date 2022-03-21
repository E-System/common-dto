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
            this.valid = valid;
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
