package com.es.lib.dto.oauth2

import spock.lang.Specification

class DTOTokenSpec extends Specification {

    def "Token store isEmpty"() {
        expect:
        new DTOToken.DefaultStore().empty
        !new DTOToken.DefaultStore(new DTOToken('', '', '')).empty
    }
}
