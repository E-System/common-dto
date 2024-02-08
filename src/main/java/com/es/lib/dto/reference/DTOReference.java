package com.es.lib.dto.reference;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Reference")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DTOReference implements Serializable {

    @Schema(description = "ID")
    private String id;
    @Schema(description = "Name")
    private String name;
    @Schema(description = "Description")
    private String description;
    @Schema(description = "Attributes")
    private Map<String, Object> attrs;

    public DTOReference(String id, String name) {
        this(id, name, null);
    }

    public DTOReference(String id, String name, String description) {
        this(id, name, description, null);
    }

    public static <T extends Enum<T>> Collection<DTOReference> create(Collection<Map.Entry<T, String>> items) {
        return create(items, null);
    }

    public static <T extends Enum<T>> Collection<DTOReference> create(Collection<Map.Entry<T, String>> items, Function<Map.Entry<T, String>, EvaluatorResult> evaluator) {
        return items.stream().map(v -> create(v.getKey(), v.getValue(), evaluator)).collect(Collectors.toList());
    }

    public static <T extends Enum<T>> DTOReference create(T value, String name) {
        return create(value, name, (Function<Map.Entry<T, String>, EvaluatorResult>) null);
    }

    public static <T extends Enum<T>> DTOReference create(T value, String name, String description) {
        return create(value, name, v -> new EvaluatorResult(description, (Map<String, Object>) null));
    }

    public static <T extends Enum<T>> DTOReference create(T value, String name, Function<Map.Entry<T, String>, EvaluatorResult> evaluator) {
        EvaluatorResult evaluatedData = evaluator != null ? evaluator.apply(new AbstractMap.SimpleEntry<>(value, name)) : new EvaluatorResult();
        return new DTOReference(value.name(), name, evaluatedData.getDescription(), evaluatedData.getAttrs());
    }

    @Getter
    @ToString
    @RequiredArgsConstructor
    public static class EvaluatorResult {

        private final String description;
        private final Map<String, Object> attrs;

        public EvaluatorResult() {
            this(null, (Map<String, Object>) null);
        }

        public EvaluatorResult(String description) {
            this(description, (Map<String, Object>) null);
        }

        public EvaluatorResult(Map<String, Object> attrs) {
            this(null, attrs);
        }

        public EvaluatorResult(String description, Collection<Map.Entry<String, Object>> attrs) {
            this(description, attrs != null ? attrs.stream().filter(v -> Objects.nonNull(v.getKey()) && Objects.nonNull(v.getValue())).collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue
            )) : null);
        }

        public EvaluatorResult(Collection<Map.Entry<String, Object>> attrs) {
            this(null, attrs != null ? attrs.stream().filter(v -> Objects.nonNull(v.getKey()) && Objects.nonNull(v.getValue())).collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue
            )) : null);
        }
    }

    public static Collection<DTOReference> getDefaultDayOfWeeks() {
        return DTOReference.create(Arrays.asList(
            new AbstractMap.SimpleEntry<>(DayOfWeek.MONDAY, "Понедельник"),
            new AbstractMap.SimpleEntry<>(DayOfWeek.TUESDAY, "Вторник"),
            new AbstractMap.SimpleEntry<>(DayOfWeek.WEDNESDAY, "Среда"),
            new AbstractMap.SimpleEntry<>(DayOfWeek.THURSDAY, "Четверг"),
            new AbstractMap.SimpleEntry<>(DayOfWeek.FRIDAY, "Пятница"),
            new AbstractMap.SimpleEntry<>(DayOfWeek.SATURDAY, "Суббота"),
            new AbstractMap.SimpleEntry<>(DayOfWeek.SUNDAY, "Воскресенье")
        ));
    }


}
