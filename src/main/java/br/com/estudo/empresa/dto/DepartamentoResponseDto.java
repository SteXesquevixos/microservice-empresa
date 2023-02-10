package br.com.estudo.empresa.dto;

import br.com.estudo.empresa.domain.Empregado;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DepartamentoResponseDto {

    private Long id;

    private String nome;

    private String sigla;

    private Double valorOrcamento;

    private List<Empregado> empregados;

}
