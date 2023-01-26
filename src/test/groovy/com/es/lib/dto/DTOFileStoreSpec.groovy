package com.es.lib.dto

import spock.lang.Specification

class DTOFileStoreSpec extends Specification {

    def "Construct"() {
        when:
        def id = '123'
        def name = 'file_name'
        def ext = 'ext'
        def mime = 'mime'
        def size = 200L
        def p = new DTOFileStore(id, name, ext, mime, size)
        then:
        p.id == id
        p.name == name
        p.ext == ext
        p.mime == mime
        p.size == size
    }

    def "Construct with external identifiers"() {
        when:
        def id = '123'
        def name = 'file_name'
        def ext = 'ext'
        def mime = 'mime'
        def size = 200L
        def extIds = [hello: 'helloValue']
        def p = new DTOFileStore(id, name, ext, mime, size, extIds)
        then:
        p.id == id
        p.name == name
        p.ext == ext
        p.mime == mime
        p.size == size
        p.extIds == extIds
    }

    def "Construct with external url"() {
        when:
        def id = '123'
        def url = 'url'
        def p = new DTOFileStore(id, url)
        then:
        p.id == id
        p.url == url
    }

    def "Get parsed id"(){
        expect:
        new DTOFileStore(null, "").intId == null
        new DTOFileStore(null, "").longId == null
        new DTOFileStore("1", "").longId == 1L
        new DTOFileStore("1", "").intId == 1
    }
}
