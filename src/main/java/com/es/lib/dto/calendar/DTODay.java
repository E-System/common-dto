package com.es.lib.dto.calendar;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "День месяца")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DTODay<T> implements Serializable {

    @Schema(description = "Номер дня в месяце")
    private int id;
    @Schema(description = "День недели (1 - Понедельник, .... 7 - Воскресенье)")
    private int dayOfWeek;
    @Schema(description = "Данные дня недели")
    private T data;
}