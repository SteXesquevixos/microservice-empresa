package br.com.estudo.empresa.converter;

import br.com.estudo.empresa.domain.Empregado;
import br.com.estudo.empresa.dto.DepartamentoResponseDto;
import br.com.estudo.empresa.dto.EmpregadoResponseDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class EmpregadoToEmpregadoResponseDto implements Converter<Empregado, EmpregadoResponseDto> {

    public EmpregadoResponseDto convert(Empregado empregado) {
        return EmpregadoResponseDto.builder()
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
                .build();
    }
}
