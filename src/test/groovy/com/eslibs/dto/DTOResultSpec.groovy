package com.eslibs.dto


import spock.lang.Specification

class DTOResultSpec extends Specification {

    def "Constructing"() {
        when:
        def code = "code"
        def msg = "msg"
        def vf = new DTOResult(code, msg)
        then:
        vf.code == code
        vf.msg == msg
    }
}
