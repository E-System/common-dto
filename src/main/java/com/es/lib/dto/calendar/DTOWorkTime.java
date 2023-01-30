package com.es.lib.dto.calendar;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Рабочее время дня недели")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DTOWorkTime {
    private int dayOfWeek;
    private Long from;
    private Long to;
    private boolean holiday;
}
