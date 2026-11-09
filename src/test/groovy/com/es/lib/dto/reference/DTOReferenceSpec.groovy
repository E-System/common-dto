package com.es.lib.dto.reference

import org.apache.commons.lang3.tuple.Pair
import spock.lang.Specification

class DTOReferenceSpec extends Specification {

    enum TestEnum {

        VALUE1,
        VALUE2
    }

    def "Create from items"() {
        when:
        def res = DTOReference.create([
                Pair.of(TestEnum.VALUE1, 'VAL1') as Map.Entry<Enum, String>,
                Pair.of(TestEnum.VALUE2, 'VAL2') as Map.Entry<Enum, String>
        ])
        then:
        res.size() == 2
        res[0].id == TestEnum.VALUE1.name()
        res[0].name == 'VAL1'
        res[1].id == TestEnum.VALUE2.name()
        res[1].name == 'VAL2'
    }

    def "Create from items (ofEnum)"() {
        when:
        def res = DTOReference.ofEnum([
                Pair.of(TestEnum.VALUE1, 'VAL1') as Map.Entry<Enum, String>,
                Pair.of(TestEnum.VALUE2, 'VAL2') as Map.Entry<Enum, String>
        ])
        then:
        res.size() == 2
        res[0].id == TestEnum.VALUE1.name()
        res[0].name == 'VAL1'
        res[1].id == TestEnum.VALUE2.name()
        res[1].name == 'VAL2'
    }

    def "Create from items (of)"() {
        when:
        def res = DTOReference.of([
                Pair.of('VALUE1', 'VAL1'),
                Pair.of('VALUE2', 'VAL2')
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

    def "Create (ofEnum)"() {
        when:
        def res = DTOReference.ofEnum(TestEnum.VALUE1, 'VAL1')
        then:
        res.id == TestEnum.VALUE1.name()
        res.name == 'VAL1'
    }

    def "Create (of)"() {
        when:
        def res = DTOReference.of('VALUE1', 'VAL1')
        then:
        res.id == TestEnum.VALUE1.name()
        res.name == 'VAL1'
    }


    def "Create with evaluator (only description)"() {
        when:
        def res = DTOReference.create(TestEnum.VALUE1, 'VAL1', {
            return new DTOReference.EvaluatorResult(it.key.name() + it.value)
        })
        then:
        res.id == TestEnum.VALUE1.name()
        res.name == 'VAL1'
        res.description == TestEnum.VALUE1.name() + 'VAL1'
        res.attrs == null
    }

    def "Create with evaluator (only description) (ofEnum)"() {
        when:
        def res = DTOReference.ofEnum(TestEnum.VALUE1, 'VAL1', {
            return new DTOReference.EvaluatorResult(it.key.name() + it.value)
        })
        then:
        res.id == TestEnum.VALUE1.name()
        res.name == 'VAL1'
        res.description == TestEnum.VALUE1.name() + 'VAL1'
        res.attrs == null
    }

    def "Create with evaluator (only description) (of)"() {
        when:
        def res = DTOReference.of('VALUE1', 'VAL1', {
            return new DTOReference.EvaluatorResult(it.key + it.value)
        })
        then:
        res.id == TestEnum.VALUE1.name()
        res.name == 'VAL1'
        res.description == TestEnum.VALUE1.name() + 'VAL1'
        res.attrs == null
    }

    def "Create with evaluator (description and attrs)"() {
        when:
        def res = DTOReference.create(TestEnum.VALUE1, 'VAL1', {
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

    def "Create with evaluator (description and attrs) (ofEnum)"() {
        when:
        def res = DTOReference.ofEnum(TestEnum.VALUE1, 'VAL1', {
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

    def "Create with evaluator (description and attrs) (of)"() {
        when:
        def res = DTOReference.of('VALUE1', 'VAL1', {
            return new DTOReference.EvaluatorResult(
                    it.key + it.value,
                    ['ATTR': it.key + it.value]
            )
        })
        then:
        res.id == TestEnum.VALUE1.name()
        res.name == 'VAL1'
        res.description == TestEnum.VALUE1.name() + 'VAL1'
        res.attrs['ATTR'] == TestEnum.VALUE1.name() + 'VAL1'
    }
}
