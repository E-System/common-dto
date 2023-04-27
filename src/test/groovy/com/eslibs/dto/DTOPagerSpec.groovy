/*
 * Copyright 2016 E-System LLC
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.eslibs.dto


import com.fasterxml.jackson.databind.ObjectMapper
import spock.lang.Shared
import spock.lang.Specification

/**
 * @author Dmitriy Zuzoev <zuzoev.d@ext-system.com>
 * @since 10.04.15
 */
class DTOPagerSpec extends Specification {

    @Shared
    def mapper = new ObjectMapper()

    def "Constructor must set all fields"() {
        when:
        def pager = new DTOPager(1, 2, 1, ["Test"])
        then:
        pager.numberOfPages == 2
        pager.total == 2
        pager.page == 1
        pager.pageSize == 1
        pager.pages == [1, 2]
        pager.values == ["Test"]
    }

    def "Pages from start"() {
        when:
        def pager = new DTOPager(0, 1000, 10, ["Test"])
        then:
        pager.numberOfPages == 100
        pager.total == 1000
        pager.page == 0
        pager.pageSize == 10
        pager.pages == [1, 2, 3, 4, 5, 6, 7, 8, -1, 100]
        pager.values == ["Test"]
    }

    def "Pages from middle"() {
        when:
        def pager = new DTOPager(10, 1000, 10, ["Test"])
        then:
        pager.numberOfPages == 100
        pager.total == 1000
        pager.page == 10
        pager.pageSize == 10
        pager.pages == [1, -1, 7, 8, 9, 10, 11, 12, 13, 14, -1, 100]
        pager.values == ["Test"]
    }

    def "Pages from end"() {
        when:
        def pager = new DTOPager(98, 1000, 10, ["Test"])
        then:
        pager.numberOfPages == 100
        pager.total == 1000
        pager.page == 98
        pager.pageSize == 10
        pager.pages == [1, -1, 93, 94, 95, 96, 97, 98, 99, 100]
        pager.values == ["Test"]
    }

    def "To json and from json"() {
        when:
        def pager = new DTOPager(1, 2, 1, ["Test"])
        def json = mapper.writeValueAsString(pager)
        def result = mapper.readValue(json, DTOPager.class)
        then:
        pager.numberOfPages == result.numberOfPages
        pager.total == result.total
        pager.page == result.page
        pager.pageSize == result.pageSize
        pager.pages == result.pages
        pager.values == result.values
    }
}
