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
@ApiModel(description = "Permission configuration")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DTOPermission {

    @ApiModelProperty(notes = "All available actions", position = 0)
    private Collection<DTOAction> actions;
    @ApiModelProperty(notes = "Access item groups", position = 1)
    private Collection<DTOGroup> items;
}
