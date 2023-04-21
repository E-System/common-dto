package com.es.lib.dto.calendar;

import com.es.lib.dto.reference.DTOReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.AbstractMap;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Рабочее время дня недели")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DTOWorkTime {

    private DTOReference dayOfWeek;
    private String from;
    private String to;
    private boolean holiday;

    @JsonIgnore
    public Map.Entry<String, String> getTitle(String holidayTitle, String notDefinedTitle) {
        String value;
        if (holiday) {
            value = holidayTitle;
        } else if (from == null || to == null) {
            value = notDefinedTitle;
        } else {
            value = from + " - " + to;
        }
        return new AbstractMap.SimpleEntry<>(dayOfWeek.getName(), value);
    }
}
