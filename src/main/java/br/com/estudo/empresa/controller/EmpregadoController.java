package br.com.estudo.empresa.controller;

import br.com.estudo.empresa.dto.EmpregadoRequestDto;
import br.com.estudo.empresa.dto.EmpregadoResponseDto;
import br.com.estudo.empresa.service.EmpregadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpregadoController {

    @Autowired
    private EmpregadoService empregadoService;

    @RequestMapping(value = "/empregados", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmpregadoResponseDto>> getTodosEmpregados() {
        return ResponseEntity.ok(empregadoService.getTodosEmpregados());
    }

    @RequestMapping(value = "/empregado/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmpregadoResponseDto> getEmpregadoById(@PathVariable(name = "id") Long id) {
        EmpregadoResponseDto empregadoResponseDto = empregadoService.getEmpregadoById(id);
        return new ResponseEntity(empregadoResponseDto, HttpStatus.OK);
    }

    @RequestMapping(value = "/empregados", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmpregadoResponseDto> addEmpregado(@RequestBody EmpregadoRequestDto empregadoRequestDto) {
        EmpregadoResponseDto empregadoResponseDto = empregadoService.addEmpregado(empregadoRequestDto);
        return new ResponseEntity<>(empregadoResponseDto, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/empregado/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmpregadoResponseDto> updateEmpregado(@PathVariable(name = "id") Long id,
                                                                @RequestBody EmpregadoRequestDto empregadoRequestDto) {
        EmpregadoResponseDto empregadoResponseDto = empregadoService.updateEmpregado(id, empregadoRequestDto);
        return new ResponseEntity<>(empregadoResponseDto, HttpStatus.OK);
    }

    @RequestMapping(value = "/empregado/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteEmpregado(@PathVariable(name = "id") Long id) {
        empregadoService.deleteEmpregado(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
