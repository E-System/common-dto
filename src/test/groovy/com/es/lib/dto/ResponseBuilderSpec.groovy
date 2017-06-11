/*
 * Copyright (c) E-System - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 * Written by E-System team (https://ext-system.com), 2015
 */

package com.es.lib.dto

import spock.lang.Specification

/**
 * @author Zuzoev Dmitry <zuzoev.d@ext-system.com>
 * @since 10.04.15
 */
class ResponseBuilderSpec extends Specification {

	def "По умолчанию код должен быть DTOResult.BAD_REQUEST"() {
		when:
		def response = new ResponseBuilder().build()
		then:
		response.result.code == DTOResult.BAD_REQUEST
	}

	def "По умолчанию результат должен быть ошибочным"() {
		when:
		def response = new ResponseBuilder().build()
		then:
		response.result.error
	}

	def "По умолчанию данные должны быть null"() {
		when:
		def response = new ResponseBuilder().build()
		then:
		response.data == null
	}

	def "При установке message должен быть заполнен result.msg"() {
		when:
		def msg = "Test message"
		def response = new ResponseBuilder().message(msg).build()
		then:
		response.result.msg == msg
	}

	def "При конструировании code должен быть заполнен result.code"() {
		when:
		def response = new ResponseBuilder(DTOResult.OK).build()
		then:
		response.result.code == DTOResult.OK
	}

	def "При установке code должен быть заполнен result.code"() {
		when:
		def response = new ResponseBuilder().code(DTOResult.OK).build()
		then:
		response.result.code == DTOResult.OK
	}

	def "При установке localizedMessage(code) должен быть заполнен result.localizeMessage.code"() {
		when:
		def msgCode = "message.code"
		def response = new ResponseBuilder().localizedMessage(msgCode).build()
		then:
		response.result.localizeMessage.code == msgCode
	}

	def "При установке localizedMessage(code, args) должен быть заполнен result.localizeMessage.code и заполнен 1 аргумент"() {
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

	def "При установке localizedMessage(code, args...) должен быть заполнен result.localizeMessage.code и заполнен 1 аргумент"() {
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

	def "При установке localizedMessage(code, args...) должен быть заполнен result.localizeMessage.code и заполнено 2 аргумента"() {
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

	def "При установке data должен быть установлен data"() {
		when:
		def data = "test-data"
		def response = new ResponseBuilder().data(data).build()
		then:
		response.data == data
	}

	def "Успешный результат с данными"() {
		when:
		def data = "result-data"
		def response = new ResponseBuilder(DTOResult.OK).data(data).build()
		then:
		response.result.code == DTOResult.OK
		response.data == data
	}

	def "Ошибочный ответ без локализации"() {
		when:
		def errorMsg = "error"
		def response = new ResponseBuilder().message(errorMsg).build()
		then:
		response.result.code == DTOResult.BAD_REQUEST
		response.result.msg == errorMsg
	}

	def "Ошибочный ответ с локализацией и 2 аргументами"() {
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
