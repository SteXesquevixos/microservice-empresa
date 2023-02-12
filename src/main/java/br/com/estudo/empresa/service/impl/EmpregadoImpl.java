package br.com.estudo.empresa.service.impl;

import br.com.estudo.empresa.converter.EmpregadoToEmpregadoResponseDto;
import br.com.estudo.empresa.converter.ListEmpregadoToListEmpregadoResponseDto;
import br.com.estudo.empresa.domain.Empregado;
import br.com.estudo.empresa.dto.EmpregadoRequestDto;
import br.com.estudo.empresa.dto.EmpregadoResponseDto;
import br.com.estudo.empresa.repository.EmpregadoRepository;
import br.com.estudo.empresa.service.EmpregadoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpregadoImpl implements EmpregadoService {

    @Autowired
    private EmpregadoRepository empregadoRepository;

    @Autowired
    private EmpregadoToEmpregadoResponseDto empregadoToEmpregadoResponseDto;

    @Autowired
    private ListEmpregadoToListEmpregadoResponseDto listEmpregadoToListEmpregadoResponseDto;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<EmpregadoResponseDto> getTodosEmpregados() {
        List<Empregado> empregados = empregadoRepository.findAll();
        return listEmpregadoToListEmpregadoResponseDto.convert(empregados);
    }

    @Override
    public EmpregadoResponseDto getEmpregadoById(Long id) {
        Optional<Empregado> empregado = empregadoRepository.findById(id);
        return empregadoToEmpregadoResponseDto.convert(empregado.get());
    }

    @Override
    public EmpregadoResponseDto addEmpregado(EmpregadoRequestDto empregadoRequestDto) {
        Empregado empregado = modelMapper.map(empregadoRequestDto, Empregado.class);
        Empregado empregadoSaved = empregadoRepository.save(empregado);
        return empregadoToEmpregadoResponseDto.convert(empregadoSaved);
    }

    @Override
    public EmpregadoResponseDto updateEmpregado(Long id, EmpregadoRequestDto empregadoRequestDto) {

        Empregado empregado = empregadoRepository.findById(id).get();

        empregado.setNome(empregadoRequestDto.getNome());
        empregado.setCargo(empregadoRequestDto.getCargo());
        empregado.setSalario(empregadoRequestDto.getSalario());
//        empregado.setDepartamento(empregadoRequestDto.getDepartamento());

        Empregado empregadoSaved = empregadoRepository.save(empregado);

        return empregadoToEmpregadoResponseDto.convert(empregadoSaved);
    }

    @Override
    public void deleteEmpregado(Long id) {
        empregadoRepository.deleteById(id);
    }


}
