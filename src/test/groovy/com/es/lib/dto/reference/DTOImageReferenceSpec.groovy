package com.es.lib.dto.reference

import spock.lang.Specification

class DTOImageReferenceSpec extends Specification {
    enum TestEnum {
        VALUE1,
        VALUE2
    }

    def "Create from items"() {
        when:
        def ext = 'png'
        def res = DTOImageReference.create([
                new AbstractMap.SimpleEntry(TestEnum.VALUE1, 'VAL1'),
                new AbstractMap.SimpleEntry(TestEnum.VALUE2, 'VAL2')
        ])
        then:
        res.size() == 2
        res[0].id == TestEnum.VALUE1.name()
        res[0].name == 'VAL1'
        res[0].image.id == TestEnum.VALUE1.name() + '.' + ext
        res[0].image.name == TestEnum.VALUE1.name()
        res[0].image.ext == ext
        res[1].id == TestEnum.VALUE2.name()
        res[1].name == 'VAL2'
        res[1].image.id == TestEnum.VALUE2.name() + '.' + ext
        res[1].image.name == TestEnum.VALUE2.name()
        res[1].image.ext == ext
    }

    def "Create"() {
        when:
        def ext = 'png'
        def res = DTOImageReference.create(TestEnum.VALUE1, 'VAL1')
        then:
        res.id == TestEnum.VALUE1.name()
        res.name == 'VAL1'
        res.image.id == TestEnum.VALUE1.name() + '.' + ext
        res.image.name == TestEnum.VALUE1.name()
        res.image.ext == ext
    }

    def "Create with prefix"() {
        when:
        def prefix = 'img'
        def ext = 'png'
        def res = DTOImageReference.create(TestEnum.VALUE1, 'VAL1', prefix)
        then:
        res.id == TestEnum.VALUE1.name()
        res.name == 'VAL1'
        res.image.id == prefix + '/' + TestEnum.VALUE1.name() + '.' + ext
        res.image.name == TestEnum.VALUE1.name()
        res.image.ext == ext
    }

    def "Create with prefix ang ext"() {
        when:
        def prefix = 'img'
        def ext = 'jpg'
        def res = DTOImageReference.create(TestEnum.VALUE1, 'VAL1', prefix, ext)
        then:
        res.id == TestEnum.VALUE1.name()
        res.name == 'VAL1'
        res.image.id == prefix + '/' + TestEnum.VALUE1.name() + '.' + ext
        res.image.name == TestEnum.VALUE1.name()
        res.image.ext == ext
    }

    def "Create with empty prefix ang ext"() {
        when:
        def prefix = null
        def ext = 'jpg'
        def res = DTOImageReference.create(TestEnum.VALUE1, 'VAL1', prefix, ext)
        then:
        res.id == TestEnum.VALUE1.name()
        res.name == 'VAL1'
        res.image.id == TestEnum.VALUE1.name() + '.' + ext
        res.image.name == TestEnum.VALUE1.name()
        res.image.ext == ext
    }

    def "Create with empty prefix ang ext and description evaluator"() {
        when:
        def prefix = null
        def ext = 'jpg'
        def res = DTOImageReference.create(TestEnum.VALUE1, 'VAL1', prefix, ext, {
            return it.key.name() + it.value
        })
        then:
        res.id == TestEnum.VALUE1.name()
        res.name == 'VAL1'
        res.description == TestEnum.VALUE1.name() + 'VAL1'
        res.image.id == TestEnum.VALUE1.name() + '.' + ext
        res.image.name == TestEnum.VALUE1.name()
        res.image.ext == ext
    }
}
