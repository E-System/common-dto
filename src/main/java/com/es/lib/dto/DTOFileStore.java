package com.es.lib.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Map;

/**
 * Simple file store info
 *
 * @author Dmitriy Zuzoev - zuzoev.d@ext-system.com
 * @since 13.04.2021
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "File store information")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DTOFileStore implements Serializable {

    @Schema(description = "ID")
    private String id;
    @Schema(description = "File name")
    private String name;
    @Schema(description = "File extension")
    private String ext;
    @Schema(description = "File mime type")
    private String mime;
    @Schema(description = "File size")
    private long size;
    @Schema(description = "External identifiers")
    private Map<String, String> extIds;

    public DTOFileStore(String id, String name, String ext, String mime, long size) {
        this(id, name, ext, mime, size, null);
    }
}
