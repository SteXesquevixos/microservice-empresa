package br.com.estudo.empresa.service;

import br.com.estudo.empresa.dto.EmpregadoRequestDto;
import br.com.estudo.empresa.dto.EmpregadoResponseDto;

import java.util.List;

public interface EmpregadoService {

    List<EmpregadoResponseDto> getTodosEmpregados();

    EmpregadoResponseDto getEmpregadoById(Long id);

    EmpregadoResponseDto addEmpregado(EmpregadoRequestDto empregadoRequestDto);

    EmpregadoResponseDto updateEmpregado(Long id, EmpregadoRequestDto empregadoRequestDto);

    void deleteEmpregado(Long id);

}
