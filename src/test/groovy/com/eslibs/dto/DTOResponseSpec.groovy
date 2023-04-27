package com.eslibs.dto


import spock.lang.Specification

class DTOResponseSpec extends Specification {

    def "Constructing"() {
        when:
        def body = "body"
        def item = new DTOResponse<String>(body)
        then:
        item.data == body
        item.env == null
    }

    def "Constructing environmental"() {
        when:
        def body = "body"
        def env = "env"
        def item = new DTOEnvironmentalResponse<String, String>(body, env)
        then:
        item.data == body
        item.env == env
    }
}
