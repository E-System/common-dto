package com.eslibs.dto


import spock.lang.Specification

class DTOPagerResponseSpec extends Specification {

    def "Constructing without totals"() {
        when:
        def items = ["Test"]
        def pager = new DTOPager(1, 2, 1, items)
        def item = new DTOPagerResponse(pager)
        then:
        item.pager.numberOfPages == 2
        item.pager.total == 2
        item.pager.page == 1
        item.pager.pageSize == 1
        item.pager.pages == [1, 2]
        item.pager.values == null
        item.data == items
        item.totals == null
    }

    def "Constructing with totals"() {
        when:
        def items = ["Test"]
        def pager = new DTOPager(1, 2, 1, items)
        def totals = "Totals"
        def item = new DTOPagerResponse(pager, totals)
        then:
        item.pager.numberOfPages == 2
        item.pager.total == 2
        item.pager.page == 1
        item.pager.pageSize == 1
        item.pager.pages == [1, 2]
        item.pager.values == null
        item.data == items
        item.totals == totals
    }
}
