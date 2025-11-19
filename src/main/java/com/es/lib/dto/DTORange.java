package com.es.lib.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiObject(name = "Interval", description = "Interval")
@ApiModel(description = "Interval")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DTORange<T> implements Serializable {

    @ApiObjectField(description = "From", order = 1)
    @ApiModelProperty(notes = "From", position = 1)
    private T from;
    @ApiObjectField(description = "To", order = 2)
    @ApiModelProperty(notes = "To", position = 2)
    private T to;
}