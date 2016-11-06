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
 * @author Zuzoev Dmitry - zuzoev.d@ext-system.com
 * @since 16.05.15
 */
class DTOLocalizeMessageSpec extends Specification {
    def "Конструирование должно устанавливать оба поля"() {
        when:
        def code = "code"
        def args = ["arg1", "arg2"]
        def vf = new DTOLocalizeMessage(code, args)
        then:
        vf.code == code
        vf.args == args
    }
}
