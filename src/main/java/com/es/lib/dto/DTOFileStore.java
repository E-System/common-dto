package com.es.lib.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Simple file store info
 *
 * @author Dmitriy Zuzoev - zuzoev.d@ext-system.com
 * @since 13.04.2021
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "File store information")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DTOFileStore implements Serializable {

    @ApiModelProperty(notes = "ID", position = 0)
    private long id;
    @ApiModelProperty(notes = "File name", position = 1)
    private String name;
    @ApiModelProperty(notes = "File extension", position = 2)
    private String ext;
    @ApiModelProperty(notes = "File mime type", position = 3)
    private String mime;
    @ApiModelProperty(notes = "File size", position = 4)
    private long size;
}
