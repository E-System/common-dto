package com.es.lib.dto.reference

import spock.lang.Specification

class DTOReferenceSpec extends Specification {

    enum TestEnum {

        VALUE1,
        VALUE2
    }

    def "Create from items"() {
        when:
        def res = DTOReference.create([
                new AbstractMap.SimpleEntry(TestEnum.VALUE1, 'VAL1'),
                new AbstractMap.SimpleEntry(TestEnum.VALUE2, 'VAL2')
        ])
        then:
        res.size() == 2
        res[0].id == TestEnum.VALUE1.name()
        res[0].name == 'VAL1'
        res[1].id == TestEnum.VALUE2.name()
        res[1].name == 'VAL2'
    }

    def "Create"() {
        when:
        def res = DTOReference.create(TestEnum.VALUE1, 'VAL1')
        then:
        res.id == TestEnum.VALUE1.name()
        res.name == 'VAL1'
    }


    def "Create with evaluator (only description)"() {
        when:
        def res = DTOReference.create(TestEnum.VALUE1, 'VAL1', {
            return new DTOReference.EvaluatorResult(it.key.name() + it.value, null)
        })
        then:
        res.id == TestEnum.VALUE1.name()
        res.name == 'VAL1'
        res.description == TestEnum.VALUE1.name() + 'VAL1'
        res.attrs == null
    }

    def "Create with evaluator (description and attrs)"() {
        when:
        def res = DTOReference.create(TestEnum.VALUE1, 'VAL1',  {
            return new DTOReference.EvaluatorResult(
                    it.key.name() + it.value,
                    ['ATTR': it.key.name() + it.value]
            )
        })
        then:
        res.id == TestEnum.VALUE1.name()
        res.name == 'VAL1'
        res.description == TestEnum.VALUE1.name() + 'VAL1'
        res.attrs['ATTR'] == TestEnum.VALUE1.name() + 'VAL1'
    }
}
