package br.com.estudo.empresa.dto;

import br.com.estudo.empresa.domain.Empregado;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartamentoRequestDto {

    private String nome;

    private String sigla;

    private Double valorOrcamento;

}
