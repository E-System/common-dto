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
@Schema(description = "Месяц")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DTOMonth<T> implements Serializable {

    @Schema(description = "Номер месяца")
    private int id;
    @Schema(description = "День недели начала месяца (1 - Понедельник, .... 7 - Воскресенье)")
    private int startDayOfWeek;
    @Schema(description = "Дни месяца")
    private Collection<DTODay<T>> items;
}
