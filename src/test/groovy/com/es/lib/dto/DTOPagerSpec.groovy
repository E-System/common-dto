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

package com.es.lib.dto

import spock.lang.Specification

/**
 * @author Zuzoev Dmitry <zuzoev.d@ext-system.com>
 * @since 10.04.15
 */
class DTOPagerSpec extends Specification {

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
}
