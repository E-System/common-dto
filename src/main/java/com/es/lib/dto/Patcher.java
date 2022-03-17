package com.es.lib.dto;

import lombok.RequiredArgsConstructor;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Function;

@RequiredArgsConstructor
public class Patcher<T, R> {

    private final T from;
    private final R to;
    private final Set<String> fields;
    private final Collection<Rule> rules = new ArrayList<>();

    public static <T, R> Patcher<T, R> create(T from, R to) {
        return create(from, to, null);
    }

    public static <T, R> Patcher<T, R> create(T from, R to, Collection<String> fields) {
        return create(from, to, fields != null ? new HashSet<>(fields) : null);
    }

    public static <T, R> Patcher<T, R> create(T from, R to, Set<String> fields) {
        return new Patcher<>(from, to, fields);
    }

    public Patcher(DTOPatchRequest<T> request, R entity) {
        this(request.getData(), entity, request.getFields());
    }

    public Patcher<T, R> rule(String field) {
        return rule(new Rule(field, () -> reflective(from, to, field)));
    }

    public Patcher<T, R> rule(String field, BiConsumer<T, R> consumer) {
        return rule(new Rule(field, () -> consumer.accept(from, to)));
    }

    public <R1> Patcher<T, R> rule(String field, Function<T, R1> getter, BiConsumer<R, R1> setter) {
        return rule(field, getter, setter, v -> v);
    }

    public <R1, R2> Patcher<T, R> rule(String field, Function<T, R1> getter, BiConsumer<R, R2> setter, Function<R1, R2> converter) {
        return rule(new Rule(field, () -> setter.accept(to, converter.apply(getter.apply(from)))));
    }

    private Patcher<T, R> rule(String field, Runnable runnable) {
        return rule(new Rule(field, runnable));
    }

    private Patcher<T, R> rule(Rule rule) {
        rules.add(rule);
        return this;
    }

    public void apply() {
        for (Rule rule : rules) {
            rule.invoke(fields);
        }
    }

    @RequiredArgsConstructor
    private static class Rule {

        private final String field;
        private final Runnable runnable;

        void invoke(Set<String> fields) {
            if (fields == null || fields.contains(field)) {
                runnable.run();
            }
        }
    }

    private static void reflective(Object from, Object to, String field) {
        try {
            Method getter = from.getClass().getMethod("get" + capitalize(field));
            Object value = getter.invoke(from);
            Method setter = to.getClass().getMethod("set" + capitalize(field), getter.getReturnType());
            setter.invoke(to, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String capitalize(String value) {
        if (value == null) return null;
        return value.substring(0, 1).toUpperCase() + value.substring(1);
    }
}
