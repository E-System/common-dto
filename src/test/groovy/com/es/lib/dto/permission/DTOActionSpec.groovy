package com.es.lib.dto.permission

import spock.lang.Specification

class DTOActionSpec extends Specification {

    def "Constructor"() {
        expect:
        new DTOAction('CODE', 'Name', true).domain == null
        new DTOAction('CODE', 'Name', true, 'DOMAIN').domain == 'DOMAIN'
    }
}
