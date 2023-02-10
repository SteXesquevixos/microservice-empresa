package br.com.estudo.empresa.dto;

import br.com.estudo.empresa.domain.Departamento;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmpregadoResponseDto {

    private Long id;

    private String nome;

    private String cargo;

    private Double salario;

    private DepartamentoResponseDto departamento;

}
