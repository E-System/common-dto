package com.es.lib.dto.permission;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Access item group")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DTOGroup {

    @ApiModelProperty(notes = "Code", position = 0)
    private String code;
    @ApiModelProperty(notes = "Name", position = 1)
    private String name;
    @ApiModelProperty(notes = "Access items", position = 2)
    private Collection<DTOTarget> items;
}
