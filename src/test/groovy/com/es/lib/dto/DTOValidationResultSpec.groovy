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

import com.es.lib.dto.validation.DTOValidationField
import spock.lang.Specification

/**
 * @author Dmitriy Zuzoev - zuzoev.d@ext-system.com
 * @since 25.03.19
 */
class DTOValidationResultSpec extends Specification {

    def "Constructing with two arguments is success"() {
        when:
        def code = "code"
        def message = "message"
        def name = "name"
        def msg = "msg"
        def fields = [new DTOValidationField(name, msg)]
        def vf = new DTOValidationResult(code, message, fields)
        then:
        vf.code == code
        vf.msg == message
        vf.fields == fields
    }
}
