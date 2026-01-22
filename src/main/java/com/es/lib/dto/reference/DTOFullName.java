package com.es.lib.dto.reference;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jsondoc.core.annotation.ApiObject;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiObject(name = "FIO", description = "FIO")
@ApiModel(description = "Custom payload")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DTOFullName implements Serializable {

    private String surname;
    private String name;
    private String patronymic;
}
