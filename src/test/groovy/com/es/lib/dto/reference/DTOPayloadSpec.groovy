package com.es.lib.dto.reference

import spock.lang.Specification

class DTOPayloadSpec extends Specification {

    def "Create"() {
        expect:
        with(DTOPayload.link('name', 'url', false)) {
            it.type == DTOPayload.Type.LINK
            it.params[VALUE] == 'url'
            it.params[INTERNAL] == null
        }
        with(DTOPayload.link('name', 'url', true)) {
            it.type == DTOPayload.Type.LINK
            it.params[VALUE] == 'url'
            it.params[INTERNAL] == 'true'
        }
        with(DTOPayload.screen('name', 'screen')) {
            it.type == DTOPayload.Type.SCREEN
            it.params[VALUE] == 'screen'
        }
        with(DTOPayload.screen('name', 'screen', '123')) {
            it.type == DTOPayload.Type.SCREEN
            it.params[VALUE] == 'screen'
            it.params[ID] == '123'
        }
        with(DTOPayload.action('name', 'action')) {
            it.type == DTOPayload.Type.ACTION
            it.params[VALUE] == 'action'
        }
        with(DTOPayload.action('name', 'action', '123')) {
            it.type == DTOPayload.Type.ACTION
            it.params[VALUE] == 'action'
            it.params[ID] == '123'
        }
    }
}
