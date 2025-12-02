package com.es.lib.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import java.io.Serializable;
import java.util.Map;

/**
 * Simple file store info
 *
 * @author Dmitriy Zuzoev - zuzoev.d@ext-system.com
 * @since 13.04.2021
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiObject(name = "DTOFileStore", description = "File store information")
@ApiModel(description = "File store information")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DTOFileStore implements Serializable {

    @ApiObjectField(description = "ID", order = 0)
    @ApiModelProperty(notes = "ID", position = 0)
    private String id;
    @ApiObjectField(description = "File name", order = 1)
    @ApiModelProperty(notes = "File name", position = 1)
    private String name;
    @ApiObjectField(description = "File extension", order = 2)
    @ApiModelProperty(notes = "File extension", position = 2)
    private String ext;
    @ApiObjectField(description = "File mime type", order = 3)
    @ApiModelProperty(notes = "File mime type", position = 3)
    private String mime;
    @ApiObjectField(description = "File size", order = 4)
    @ApiModelProperty(notes = "File size", position = 4)
    private long size;
    @ApiObjectField(description = "External identifiers", order = 5)
    @ApiModelProperty(notes = "External identifiers", position = 5)
    private Map<String, String> extIds;
    @ApiObjectField(description = "External url", order = 6)
    @ApiModelProperty(notes = "External url", position = 6)
    private String url;
    @ApiObjectField(description = "Attrs", order = 7)
    @ApiModelProperty(notes = "Attrs", position = 7)
    private Map<String, String> attrs;

    public DTOFileStore(String id, String name, String ext, String mime, long size) {
        this(id, name, ext, mime, size, null, null, null);
    }

    public DTOFileStore(String id, String name, String ext, String mime, long size, Map<String, String> extIds) {
        this(id, name, ext, mime, size, extIds, null, null);
    }

    public DTOFileStore(String id, String url) {
        this(id, null, null, null, 0, null, url);
    }

    public DTOFileStore(String id, String name, String ext, String mime, long size, Map<String, String> extIds, String url) {
        this(id, name, ext, mime, size, extIds, url, null);
    }

    @JsonIgnore
    public Long getLongId() {
        return id != null ? Long.parseLong(id) : null;
    }

    @JsonIgnore
    public Integer getIntId() {
        return id != null ? Integer.parseInt(id) : null;
    }
}