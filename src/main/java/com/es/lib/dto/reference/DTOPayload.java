package com.es.lib.dto.reference;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Custom payload")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DTOPayload implements Serializable {

    @Schema(description = "Type")
    private Type type;
    @Schema(description = "Name")
    private String name;
    @Schema(description = "Params (main key - VALUE - link or screen name...)")
    private Map<String, String> params;

    public DTOPayload(Type type, String name, Collection<Map.Entry<String, String>> params) {
        this(type, name, params != null ? params.stream().filter(v -> Objects.nonNull(v.getKey()) && Objects.nonNull(v.getValue())).collect(Collectors.toMap(
            Map.Entry::getKey,
            Map.Entry::getValue
        )) : null);
    }

    public enum Type {
        @Schema(description = "Move to screen or section")
        SCREEN,
        @Schema(description = "Link")
        LINK
    }
}