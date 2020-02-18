package com.es.lib.dto.compat


import spock.lang.Specification

class DTOResponseCompatSpec extends Specification {

    def "Constructing"() {
        when:
        def body = "body"
        def item = new DTOResponseCompat<String>(body)
        then:
        item.data == body
        item.result.code == 200
        item.result.errorCode == null
        item.result.msg == null
        item.env == null
    }
}
