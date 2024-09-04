package com.es.lib.dto

import spock.lang.Specification

class DTOGeoPointSpec extends Specification {

    def "Create from string"(){
        expect:
        DTOGeoPoint.from(null, null) == null
        DTOGeoPoint.from(null, "") == null
        DTOGeoPoint.from(null, "   ") == null
        DTOGeoPoint.from("", null) == null
        DTOGeoPoint.from("   ", null) == null
        DTOGeoPoint.from("123123", null) == null
        DTOGeoPoint.from(null, "123123") == null
        with(DTOGeoPoint.from("12", "11")){
            it.lat == 12.0d
            it.lon == 11.0d
        }
        with(DTOGeoPoint.from("   12", "11    ")){
            it.lat == 12.0d
            it.lon == 11.0d
        }
    }
}
