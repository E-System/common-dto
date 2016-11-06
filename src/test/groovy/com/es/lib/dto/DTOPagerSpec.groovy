/*
 * Copyright (c) Extended System - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 * Written by Extended System team (https://ext-system.com), 2015
 */

package com.es.lib.dto

import spock.lang.Specification

/**
 * @author Zuzoev Dmitry <zuzoev.d@ext-system.com>
 * @since 10.04.15
 */
class DTOPagerSpec extends Specification {
	def "First"() {
		when:
		def pager = new DTOPager(1, 2, 1, ["Test"]);
		then:
		pager.numberOfPages == 2
		pager.total == 2
		pager.page == 1
		pager.pageSize == 1
		pager.pages == [1, 2]
		pager.values == ["Test"]
	}
}
