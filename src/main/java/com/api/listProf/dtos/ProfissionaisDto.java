package com.api.listProf.dtos;


import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class ProfissionaisDto {

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
