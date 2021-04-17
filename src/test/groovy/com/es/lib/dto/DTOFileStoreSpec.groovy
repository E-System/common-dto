package com.es.lib.dto

import spock.lang.Specification

class DTOFileStoreSpec extends Specification {

    def "Construct"() {
        when:
        def id = "123"
        def name = "file_name"
        def ext = "ext"
        def mime = "mime"
        def size = 200L
        def p = new DTOFileStore(id, name, ext, mime, size)
        then:
        p.id == id
        p.name == name
        p.ext == ext
        p.mime == mime
        p.size == size
    }
}