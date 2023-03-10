package com.es.lib.dto

import spock.lang.Specification

class DTOImageReferenceSpec extends Specification {
    enum TestEnum {
        VALUE1
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
}
