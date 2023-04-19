package com.es.lib.dto.calendar;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Рабочее время дня недели")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DTOWorkTime {

    private int dayOfWeek;
    private String from;
    private String to;
    private boolean holiday;

    @JsonIgnore
    public Map.Entry<String, String> getTitle(List<String> dayOfWeekTitles, String holidayTitle, String notDefinedTitle) {
        String key = dayOfWeekTitles.get(dayOfWeek - 1);
        String value;
        if (holiday) {
            value = holidayTitle;
        } else if (from == null || to == null) {
            value = notDefinedTitle;
        } else {
            value = from + " - " + to;
        }
        return new AbstractMap.SimpleEntry<>(key, value);
    }
}
