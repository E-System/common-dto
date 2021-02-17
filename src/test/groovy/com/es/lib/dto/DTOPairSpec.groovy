package com.es.lib.dto

import spock.lang.Specification

class DTOPairSpec extends Specification {

    def "Construct"() {
        when:
        def key = "Key1"
        def value = "Value1"
        def p = new DTOPair(key, value)
        then:
        p.key == key
        p.value == value
    }
}
