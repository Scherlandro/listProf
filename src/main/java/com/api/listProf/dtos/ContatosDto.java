package com.api.listProf.dtos;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Bean;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class ContatosDto {

    private Integer id;
    @NotNull
    @NotBlank
    private String nome;
    @NotNull  @NotBlank
    private String contato;
    @NotNull  @NotBlank
    private Date created_date;
	
}
