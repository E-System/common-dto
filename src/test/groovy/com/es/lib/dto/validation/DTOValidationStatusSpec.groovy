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

package com.es.lib.dto.validation

import spock.lang.Specification

/**
 * @author Zuzoev Dmitry - zuzoev.d@ext-system.com
 * @since 16.05.15
 */
class DTOValidationStatusSpec extends Specification {

    def "Constructing with two arguments is success"() {
        when:
        def name = "name"
        def msg = "msg"
        def type = DTOValidationStatus.Type.Error
        def fields = [new DTOValidationField(name, msg)]
        def vf = new DTOValidationStatus(type, fields)
        then:
        vf.type == type
        vf.fields == fields
    }
}
