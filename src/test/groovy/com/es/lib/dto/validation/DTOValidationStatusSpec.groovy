/*
 * Copyright (c) E-System - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 * Written by E-System team (https://ext-system.com), 2015
 */

package com.es.lib.dto.validation

import spock.lang.Specification

/**
 * @author Zuzoev Dmitry - zuzoev.d@ext-system.com
 * @since 16.05.15
 */
class DTOValidationStatusSpec extends Specification {

	def "Конструирование должно устанавливать оба поля"() {
		when:
		def name = "name"
		def msg = "msg"
		def type = DTOValidationStatus.Type.Error
		def fields = [new DTOValidationField(name, msg)]
		def vf = new DTOValidationStatus(type, fields);
		then:
		vf.type == type
		vf.fields == fields
	}
}
