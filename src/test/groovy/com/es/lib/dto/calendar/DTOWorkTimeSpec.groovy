package com.es.lib.dto.calendar

import spock.lang.Specification

class DTOWorkTimeSpec extends Specification {

    def 'GetTitle'() {
        when:
        def dofTitles = ['Понедельник', 'Вторник', 'Среда', 'Четверг', 'Пятница', 'Суббота', 'Воскресенье']
        def holidayTitle = 'Выходной'
        def notDefineTitle = 'Не указано'
        then:
        new DTOWorkTime(1, '10:00', '11:00', false).getTitle(dofTitles, holidayTitle, notDefineTitle).key == dofTitles[0]
        new DTOWorkTime(1, '10:00', '11:00', false).getTitle(dofTitles, holidayTitle, notDefineTitle).value == '10:00 - 11:00'
        new DTOWorkTime(2, '10:00', '11:00', false).getTitle(dofTitles, holidayTitle, notDefineTitle).key == dofTitles[1]
        new DTOWorkTime(2, '10:00', '11:00', false).getTitle(dofTitles, holidayTitle, notDefineTitle).value == '10:00 - 11:00'
        new DTOWorkTime(3, '10:00', '11:00', false).getTitle(dofTitles, holidayTitle, notDefineTitle).key == dofTitles[2]
        new DTOWorkTime(3, '10:00', '11:00', false).getTitle(dofTitles, holidayTitle, notDefineTitle).value == '10:00 - 11:00'
        new DTOWorkTime(4, '10:00', '11:00', false).getTitle(dofTitles, holidayTitle, notDefineTitle).key == dofTitles[3]
        new DTOWorkTime(4, '10:00', '11:00', false).getTitle(dofTitles, holidayTitle, notDefineTitle).value == '10:00 - 11:00'
        new DTOWorkTime(5, '10:00', '11:00', false).getTitle(dofTitles, holidayTitle, notDefineTitle).key == dofTitles[4]
        new DTOWorkTime(5, '10:00', '11:00', false).getTitle(dofTitles, holidayTitle, notDefineTitle).value == '10:00 - 11:00'
        new DTOWorkTime(6, '10:00', '11:00', false).getTitle(dofTitles, holidayTitle, notDefineTitle).key == dofTitles[5]
        new DTOWorkTime(6, '10:00', '11:00', false).getTitle(dofTitles, holidayTitle, notDefineTitle).value == '10:00 - 11:00'
        new DTOWorkTime(7, '10:00', '11:00', false).getTitle(dofTitles, holidayTitle, notDefineTitle).key == dofTitles[6]
        new DTOWorkTime(7, '10:00', '11:00', false).getTitle(dofTitles, holidayTitle, notDefineTitle).value == '10:00 - 11:00'
        new DTOWorkTime(7, '10:00', '11:00', true).getTitle(dofTitles, holidayTitle, notDefineTitle).key == dofTitles[6]
        new DTOWorkTime(7, '10:00', '11:00', true).getTitle(dofTitles, holidayTitle, notDefineTitle).value == 'Выходной'
        new DTOWorkTime(7, null, '11:00', true).getTitle(dofTitles, holidayTitle, notDefineTitle).key == dofTitles[6]
        new DTOWorkTime(7, null, '11:00', true).getTitle(dofTitles, holidayTitle, notDefineTitle).value == 'Выходной'
        new DTOWorkTime(7, '10:00', null, true).getTitle(dofTitles, holidayTitle, notDefineTitle).key == dofTitles[6]
        new DTOWorkTime(7, '10:00', null, true).getTitle(dofTitles, holidayTitle, notDefineTitle).value == 'Выходной'
        new DTOWorkTime(7, null, '11:00', false).getTitle(dofTitles, holidayTitle, notDefineTitle).key == dofTitles[6]
        new DTOWorkTime(7, null, '11:00', false).getTitle(dofTitles, holidayTitle, notDefineTitle).value == 'Не указано'
        new DTOWorkTime(7, '10:00', null, false).getTitle(dofTitles, holidayTitle, notDefineTitle).key == dofTitles[6]
        new DTOWorkTime(7, '10:00', null, false).getTitle(dofTitles, holidayTitle, notDefineTitle).value == 'Не указано'
    }
}
