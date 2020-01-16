package com.es.lib.dto.permission;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Access action")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DTOAction {

    @ApiModelProperty(notes = "Code", position = 0)
    private String code;
    @ApiModelProperty(notes = "Name", position = 1)
    private String name;
    @ApiModelProperty(notes = "Active for current configuration", position = 2)
    private boolean enabled;
}
