package com.eslibs.dto.oauth2

import spock.lang.Specification

class DTOTokenSpec extends Specification {

    def "Token store isEmpty"() {
        expect:
        new DTOToken.DefaultStore().empty
        !new DTOToken.DefaultStore(new DTOToken('', '', '')).empty
    }

    def "Constructors"(){
        when:
        def item = new DTOToken('AT', 'RT', 'TT')
        def item2 = new DTOToken('AT', 'RT', 'TT', 'S')
        then:
        item.accessToken == 'AT'
        item.refreshToken == 'RT'
        item.tokenType == 'TT'
        item.scope == null
        item2.accessToken == 'AT'
        item2.refreshToken == 'RT'
        item2.tokenType == 'TT'
        item2.scope == 'S'
    }
}
