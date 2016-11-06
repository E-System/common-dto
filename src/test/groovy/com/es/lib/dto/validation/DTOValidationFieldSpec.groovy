/*
 * Copyright (c) Extended System - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 * Written by Extended System team (https://ext-system.com), 2015
 */

package com.es.lib.dto.validation

import spock.lang.Specification

/**
 * @author Zuzoev Dmitry <zuzoev.d@ext-system.com>
 * @since 10.04.15
 */
class DTOValidationFieldSpec extends Specification {

	def "Конструирование должно устанавливать оба поля"() {
		when:
		def name = "name"
		def msg = "msg"
		def vf = new DTOValidationField(name, msg);
		then:
		vf.name == name
		vf.msg == msg
	}
}
