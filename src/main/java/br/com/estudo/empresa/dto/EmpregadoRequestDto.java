package br.com.estudo.empresa.dto;

import br.com.estudo.empresa.domain.Departamento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpregadoRequestDto {

    private String nome;

    private String cargo;

    private Double salario;

    private Departamento departamento;

}
