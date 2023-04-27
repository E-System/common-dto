package com.eslibs.dto.calendar

import com.eslibs.dto.reference.DTOReference
import spock.lang.Specification

class DTOWorkTimeSpec extends Specification {

    def 'GetTitle'() {
        when:
        def dayOfWeeks = DTOReference.defaultDayOfWeeks
        def holidayTitle = 'Выходной'
        def notDefineTitle = 'Не указано'
        then:
        new DTOWorkTime(dayOfWeeks[0], '10:00', '11:00', false).getTitle(holidayTitle, notDefineTitle).key == dayOfWeeks[0].name
        new DTOWorkTime(dayOfWeeks[0], '10:00', '11:00', false).getTitle(holidayTitle, notDefineTitle).value == '10:00 - 11:00'
        new DTOWorkTime(dayOfWeeks[1], '10:00', '11:00', false).getTitle(holidayTitle, notDefineTitle).key == dayOfWeeks[1].name
        new DTOWorkTime(dayOfWeeks[1], '10:00', '11:00', false).getTitle(holidayTitle, notDefineTitle).value == '10:00 - 11:00'
        new DTOWorkTime(dayOfWeeks[2], '10:00', '11:00', false).getTitle(holidayTitle, notDefineTitle).key == dayOfWeeks[2].name
        new DTOWorkTime(dayOfWeeks[2], '10:00', '11:00', false).getTitle(holidayTitle, notDefineTitle).value == '10:00 - 11:00'
        new DTOWorkTime(dayOfWeeks[3], '10:00', '11:00', false).getTitle(holidayTitle, notDefineTitle).key == dayOfWeeks[3].name
        new DTOWorkTime(dayOfWeeks[3], '10:00', '11:00', false).getTitle(holidayTitle, notDefineTitle).value == '10:00 - 11:00'
        new DTOWorkTime(dayOfWeeks[4], '10:00', '11:00', false).getTitle(holidayTitle, notDefineTitle).key == dayOfWeeks[4].name
        new DTOWorkTime(dayOfWeeks[4], '10:00', '11:00', false).getTitle(holidayTitle, notDefineTitle).value == '10:00 - 11:00'
        new DTOWorkTime(dayOfWeeks[5], '10:00', '11:00', false).getTitle(holidayTitle, notDefineTitle).key == dayOfWeeks[5].name
        new DTOWorkTime(dayOfWeeks[5], '10:00', '11:00', false).getTitle(holidayTitle, notDefineTitle).value == '10:00 - 11:00'
        new DTOWorkTime(dayOfWeeks[6], '10:00', '11:00', false).getTitle(holidayTitle, notDefineTitle).key == dayOfWeeks[6].name
        new DTOWorkTime(dayOfWeeks[6], '10:00', '11:00', false).getTitle(holidayTitle, notDefineTitle).value == '10:00 - 11:00'
        new DTOWorkTime(dayOfWeeks[6], '10:00', '11:00', true).getTitle(holidayTitle, notDefineTitle).key == dayOfWeeks[6].name
        new DTOWorkTime(dayOfWeeks[6], '10:00', '11:00', true).getTitle(holidayTitle, notDefineTitle).value == 'Выходной'
        new DTOWorkTime(dayOfWeeks[6], null, '11:00', true).getTitle(holidayTitle, notDefineTitle).key == dayOfWeeks[6].name
        new DTOWorkTime(dayOfWeeks[6], null, '11:00', true).getTitle(holidayTitle, notDefineTitle).value == 'Выходной'
        new DTOWorkTime(dayOfWeeks[6], '10:00', null, true).getTitle(holidayTitle, notDefineTitle).key == dayOfWeeks[6].name
        new DTOWorkTime(dayOfWeeks[6], '10:00', null, true).getTitle(holidayTitle, notDefineTitle).value == 'Выходной'
        new DTOWorkTime(dayOfWeeks[6], null, '11:00', false).getTitle(holidayTitle, notDefineTitle).key == dayOfWeeks[6].name
        new DTOWorkTime(dayOfWeeks[6], null, '11:00', false).getTitle(holidayTitle, notDefineTitle).value == 'Не указано'
        new DTOWorkTime(dayOfWeeks[6], '10:00', null, false).getTitle(holidayTitle, notDefineTitle).key == dayOfWeeks[6].name
        new DTOWorkTime(dayOfWeeks[6], '10:00', null, false).getTitle(holidayTitle, notDefineTitle).value == 'Не указано'
    }
}
