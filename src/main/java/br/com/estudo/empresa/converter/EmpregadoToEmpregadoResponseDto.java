package br.com.estudo.empresa.converter;

import br.com.estudo.empresa.domain.Empregado;
import br.com.estudo.empresa.dto.EmpregadoResponseDto;
import org.springframework.core.convert.converter.Converter;

public class EmpregadoToEmpregadoResponseDto implements Converter<Empregado, EmpregadoResponseDto> {

    public EmpregadoResponseDto convert(Empregado empregado) {
        return EmpregadoResponseDto.builder()
                .id(empregado.getId())
                .nome(empregado.getNome())
                .cargo(empregado.getCargo())
                .salario(empregado.getSalario())
                .build();
    }

}
