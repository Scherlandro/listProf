package com.api.listProf.dtos;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class ContatosDto {

    private Integer id;
    @NotNull  @NotBlank
    private String nome;
    @NotNull  @NotBlank
    private String contato;
    @NotNull  @NotBlank
    private Date created_date;
	
}
