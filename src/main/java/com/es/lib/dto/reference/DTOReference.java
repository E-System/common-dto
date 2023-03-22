package com.es.lib.dto.reference;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
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

    public static Collection<DTOReference> create(Collection<Map.Entry<Enum<?>, String>> items) {
        return items.stream().map(v -> create(v.getKey(), v.getValue())).collect(Collectors.toList());
    }
    public static DTOReference create(Enum<?> item, String name) {
        return create(item, name, null);
    }

    public static DTOReference create(Enum<?> item, String name, String description) {
        return new DTOReference(item.name(), name, description);
    }
}
