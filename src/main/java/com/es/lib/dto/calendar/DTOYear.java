package com.es.lib.dto.calendar;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Год")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DTOYear<T> implements Serializable {

    @Schema(description = "Номер года")
    private int id;
    @Schema(description = "Месяца")
    private Collection<DTOMonth<T>> items;
}
