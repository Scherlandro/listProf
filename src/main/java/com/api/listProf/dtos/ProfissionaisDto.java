package com.api.listProf.dtos;


import com.api.listProf.util.Conversores;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class ProfissionaisDto {

    @Autowired
    final private Conversores conversores;

    private Integer id_prof;
    @NotNull
    @NotBlank
    private String nome;
    @NotNull  @NotBlank
    private String cargo;
    @NotNull  @NotBlank

    private String nascimnento;
    @NotNull  @NotBlank
    private Date created_date;
	
}
