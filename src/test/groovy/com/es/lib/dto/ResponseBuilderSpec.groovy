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
class ResponseBuilderSpec extends Specification {

    def "Default code is DTOResult.BAD_REQUEST"() {
        when:
        def response = new ResponseBuilder().build()
        then:
        response.result.code == DTOResult.BAD_REQUEST
    }

    def "Default result is error"() {
        when:
        def response = new ResponseBuilder().build()
        then:
        response.result.error
    }

    def "Default data is null"() {
        when:
        def response = new ResponseBuilder().build()
        then:
        response.data == null
    }

    def "Building with message is success"() {
        when:
        def msg = "Test message"
        def response = new ResponseBuilder().message(msg).build()
        then:
        response.result.msg == msg
    }

    def "Building with code is success"() {
        when:
        def response = new ResponseBuilder(DTOResult.OK).build()
        then:
        response.result.code == DTOResult.OK
    }

    def "Building with code in chain is success"() {
        when:
        def response = new ResponseBuilder().code(DTOResult.OK).build()
        then:
        response.result.code == DTOResult.OK
    }

    def "Building with localized message code is success"() {
        when:
        def msgCode = "message.code"
        def response = new ResponseBuilder().localizedMessage(msgCode).build()
        then:
        response.result.localizeMessage.code == msgCode
    }

    def "Building with localized code and two arguments (in array) is success"() {
        when:
        def msgCode = "message.code"
        def argsText = "test"
        def args = [argsText]
        def response = new ResponseBuilder().localizedMessage(msgCode, args).build()
        then:
        response.result.localizeMessage.code == msgCode
        response.result.localizeMessage.args != null
        response.result.localizeMessage.args.size() == 1
        response.result.localizeMessage.args[0] == argsText
    }

    def "Building with localized code and one arguments is success"() {
        when:
        def msgCode = "message.code"
        def argsText = "test"
        def response = new ResponseBuilder().localizedMessage(msgCode, argsText).build()
        then:
        response.result.localizeMessage.code == msgCode
        response.result.localizeMessage.args != null
        response.result.localizeMessage.args.size() == 1
        response.result.localizeMessage.args[0] == argsText
    }

    def "Building with localized code and two arguments is success"() {
        when:
        def msgCode = "message.code"
        def argsText = "test"
        def argsText2 = "test2"
        def response = new ResponseBuilder().localizedMessage(msgCode, argsText, argsText2).build()
        then:
        response.result.localizeMessage.code == msgCode
        response.result.localizeMessage.args != null
        response.result.localizeMessage.args.size() == 2
        response.result.localizeMessage.args[0] == argsText
        response.result.localizeMessage.args[1] == argsText2
    }

    def "Building with data is success"() {
        when:
        def data = "test-data"
        def response = new ResponseBuilder().data(data).build()
        then:
        response.data == data
    }

    def "Success result with data"() {
        when:
        def data = "result-data"
        def response = new ResponseBuilder(DTOResult.OK).data(data).build()
        then:
        response.result.code == DTOResult.OK
        response.data == data
    }

    def "Error answer without localization"() {
        when:
        def errorMsg = "error"
        def response = new ResponseBuilder().message(errorMsg).build()
        then:
        response.result.code == DTOResult.BAD_REQUEST
        response.result.msg == errorMsg
    }

    def "Error answer with localization and two arguments"() {
        when:
        def errorMsg = "error"
        def errorCode = "error-code"
        def arg1 = "arg1"
        def arg2 = "arg2"
        def response = new ResponseBuilder(DTOResult.INTERNAL_SERVER_ERROR).message(errorMsg).localizedMessage(errorCode, arg1, arg2).build()
        then:
        response.result.code == DTOResult.INTERNAL_SERVER_ERROR
        response.result.msg == errorMsg
        response.result.localizeMessage.code == errorCode
        response.result.localizeMessage.args != null
        response.result.localizeMessage.args.size() == 2
        response.result.localizeMessage.args[0] == arg1
        response.result.localizeMessage.args[1] == arg2
    }
}
