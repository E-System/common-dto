package com.es.lib.dto.compat


import spock.lang.Specification

class DTOResultCompatSpec extends Specification {

    def "Constructing"() {
        when:
        def code = 500
        def errorCode = "errorCode"
        def msg = "msg"
        def vf = new DTOResultCompat(code, errorCode, msg)
        then:
        vf.code == code
        vf.errorCode == errorCode
        vf.msg == msg
    }
}
