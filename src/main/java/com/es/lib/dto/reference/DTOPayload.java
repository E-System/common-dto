package com.es.lib.dto.reference;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Custom payload")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DTOPayload implements Serializable {

    public static final String ID = "ID";
    public static final String VALUE = "VALUE";
    public static final String INTERNAL = "INTERNAL";

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


    public static DTOPayload link(String name, String url) {
        return link(name, url, false);
    }

    public static DTOPayload link(String name, String url, boolean internal) {
        if (url == null || url.isEmpty()) {
            return null;
        }
        Map<String, String> params = new HashMap<>();
        params.put(VALUE, url);
        if (internal) {
            params.put(INTERNAL, String.valueOf(true));
        }
        return new DTOPayload(DTOPayload.Type.LINK, name, params);
    }

    public static DTOPayload screen(String name, String screen) {
        return screen(name, screen, null);
    }

    public static DTOPayload screen(String name, String screen, Object id) {
        if (screen == null || screen.isEmpty()) {
            return null;
        }
        Map<String, String> params = new HashMap<>();
        params.put(VALUE, screen);
        if (id != null) {
            params.put(ID, id.toString());
        }
        return new DTOPayload(Type.SCREEN, name, params);
    }

}