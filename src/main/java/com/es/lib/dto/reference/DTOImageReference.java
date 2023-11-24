package com.es.lib.dto.reference;

import com.es.lib.dto.DTOFileStore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Reference with image")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DTOImageReference {

    @Schema(description = "ID")
    private String id;
    @Schema(description = "Name")
    private String name;
    @Schema(description = "Description")
    private String description;
    @Schema(description = "Image")
    private DTOFileStore image;
    @Schema(description = "Attributes")
    private Map<String, Object> attrs;

    public static <T extends Enum<T>> Collection<DTOImageReference> create(Collection<Map.Entry<T, String>> items) {
        return create(items, (Function<Map.Entry<T, String>, Data>) null);
    }

    public static <T extends Enum<T>> Collection<DTOImageReference> create(Collection<Map.Entry<T, String>> items, Function<Map.Entry<T, String>, Data> evaluator) {
        return create(items, null, evaluator);
    }

    public static <T extends Enum<T>> Collection<DTOImageReference> create(Collection<Map.Entry<T, String>> items, String imagePrefix) {
        return create(items, imagePrefix, null, null);
    }

    public static <T extends Enum<T>> Collection<DTOImageReference> create(Collection<Map.Entry<T, String>> items, String imagePrefix, Function<Map.Entry<T, String>, Data> evaluator) {
        return create(items, imagePrefix, null, evaluator);
    }

    public static <T extends Enum<T>> Collection<DTOImageReference> create(Collection<Map.Entry<T, String>> items, String imagePrefix, String ext) {
        return create(items, imagePrefix, ext, null);
    }

    public static <T extends Enum<T>> Collection<DTOImageReference> create(Collection<Map.Entry<T, String>> items, String imagePrefix, String ext, Function<Map.Entry<T, String>, Data> evaluator) {
        return items.stream().map(v -> create(v.getKey(), v.getValue(), imagePrefix, ext, evaluator)).collect(Collectors.toList());
    }

    public static <T extends Enum<T>> DTOImageReference create(T value, String name) {
        return create(value, name, null, null, null);
    }

    public static <T extends Enum<T>> DTOImageReference create(T value, String name, Function<Map.Entry<T, String>, Data> evaluator) {
        return create(value, name, null, null, evaluator);
    }

    public static <T extends Enum<T>> DTOImageReference create(T value, String name, String imagePrefix) {
        return create(value, name, imagePrefix, null, null);
    }

    public static <T extends Enum<T>> DTOImageReference create(T value, String name, String imagePrefix, Function<Map.Entry<T, String>, Data> evaluator) {
        return create(value, name, imagePrefix, null, evaluator);
    }

    public static <T extends Enum<T>> DTOImageReference create(T value, String name, String pathPrefix, String ext) {
        return create(value, name, pathPrefix, ext, null);
    }

    public static <T extends Enum<T>> DTOImageReference create(T value, String name, String pathPrefix, String ext, Function<Map.Entry<T, String>, Data> evaluator) {
        if (ext == null || ext.isEmpty()) {
            ext = "png";
        }
        String path = ((pathPrefix != null && !pathPrefix.isEmpty()) ? (pathPrefix + "/") : "") + value.name() + "." + ext;
        Data evaluatedData = evaluator != null ? evaluator.apply(new AbstractMap.SimpleEntry<>(value, name)) : new Data();
        return new DTOImageReference(
            value.name(),
            name,
            evaluatedData.getDescription(),
            new DTOFileStore(
                path,
                value.name(),
                ext,
                null,
                0
            ),
            evaluatedData.getAttrs()
        );
    }

    @Getter
    @ToString
    @RequiredArgsConstructor
    public static class Data {

        private final String description;
        private final Map<String, Object> attrs;

        public Data() {
            this(null, null);
        }
    }
}
