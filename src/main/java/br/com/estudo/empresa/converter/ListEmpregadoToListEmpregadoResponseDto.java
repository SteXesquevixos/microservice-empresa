package br.com.estudo.empresa.converter;

import br.com.estudo.empresa.domain.Departamento;
import br.com.estudo.empresa.domain.Empregado;
import br.com.estudo.empresa.dto.DepartamentoResponseDto;
import br.com.estudo.empresa.dto.EmpregadoResponseDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ListEmpregadoToListEmpregadoResponseDto implements Converter<List<Empregado>, List<EmpregadoResponseDto>> {

    public List<EmpregadoResponseDto> convert(List<Empregado> empregados) {
        return empregados.stream().map(empregado -> EmpregadoResponseDto.builder()
                        .id(empregado.getId())
                        .nome(empregado.getNome())
                        .cargo(empregado.getCargo())
                        .salario(empregado.getSalario())
                        .departamento(empregado.getDepartamento() != null ?
                                DepartamentoResponseDto.builder()
                                        .id(empregado.getDepartamento().getId())
                                        .nome(empregado.getDepartamento().getNome())
                                        .sigla(empregado.getDepartamento().getSigla())
                                        .valorOrcamento(empregado.getDepartamento().getValorOrcamento())
                                        .build()
                                : null)
                        .build())
                .collect(Collectors.toList());
    }

}
