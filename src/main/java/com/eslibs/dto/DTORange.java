package com.eslibs.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Interval")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DTORange<T> implements Serializable {
    @Schema(description = "From")
    private T from;
    @Schema(description = "To")
    private T to;
}
