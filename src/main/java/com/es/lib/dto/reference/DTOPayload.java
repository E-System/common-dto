package com.es.lib.dto.reference;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiObject(name = "Custom payload", description = "Custom payload")
@ApiModel(description = "Custom payload")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DTOPayload implements Serializable {

    public static final String ID = "ID";
    public static final String VALUE = "VALUE";
    public static final String INTERNAL = "INTERNAL";

    @ApiObjectField(description = "Type", order = 0)
    @ApiModelProperty(notes = "Type", position = 0)
    private Type type;
    @ApiObjectField(description = "Name", order = 1)
    @ApiModelProperty(notes = "Name", position = 1)
    private String name;
    @ApiObjectField(description = "Params (main key - VALUE - link or screen name...)", order = 2)
    @ApiModelProperty(notes = "Params (main key - VALUE - link or screen name...)", position = 2)
    private Map<String, String> params;

    public DTOPayload(Type type, String name, Collection<Map.Entry<String, String>> params) {
        this(type, name, params != null ? params.stream().filter(v -> Objects.nonNull(v.getKey()) && Objects.nonNull(v.getValue())).collect(Collectors.toMap(
            Map.Entry::getKey,
            Map.Entry::getValue
        )) : null);
    }

    public enum Type {
        @ApiObjectField(description = "Move to screen or section", order = 0)
        @ApiModelProperty(notes = "Move to screen or section", position = 0)
        SCREEN,
        @ApiObjectField(description = "Link", order = 1)
        @ApiModelProperty(notes = "Link", position = 1)
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