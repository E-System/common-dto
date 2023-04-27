package com.eslibs.dto


import spock.lang.Specification

class DTOPairSpec extends Specification {

    def "Construct"() {
        when:
        def key = "Key1"
        def value = "Value1"
        def p = DTOPair.of(key, value)
        then:
        p.key == key
        p.value == value
    }

    def "Construct 2"() {
        when:
        def key = 1L
        def value = "Value1"
        def p = DTOPair.of(key, value)
        then:
        p.key == key
        p.value == value
    }
}
