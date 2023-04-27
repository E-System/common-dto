package com.eslibs.dto.compat


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

    def "Constructing with result"() {
        when:
        def body = "body"
        def res = new DTOResultCompat(200)
        def item = new DTOResponseCompat<String>(res)
        then:
        item.data == null
        item.result.code == 200
        item.result.errorCode == null
        item.result.msg == null
        item.env == null
    }
}
