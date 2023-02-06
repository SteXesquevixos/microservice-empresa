package br.com.estudo.empresa.repository;

import br.com.estudo.empresa.domain.Departamento;
import br.com.estudo.empresa.domain.Empregado;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class EmpregadoRepositoryTest {

    @Autowired
    public EmpregadoRepository empregadoRepository;

    @Autowired
    public DepartamentoRepository departamentoRepository;


    @Test
    public void testObterEmpregadoById() {

        // GIVEN id do empregado
        Long empregadoId = 5L;

        // WHEN executar consulta do empregado, trazer todos os dados dele
        Empregado empregado = empregadoRepository.findById(empregadoId).get();

        // THEN obter dados
        Assert.isTrue(empregado.getId() != null,  "Erro ao encontrar empregado");
    }

    @Test
    public void testObterTodosEmpregados() {

        // WHEN executar consulta ao DB, trazer uma lista de todos os empregados
        List<Empregado> empregado = empregadoRepository.findAll();

        // THEN obter lista
        Assert.isTrue(empregado.size() > 0, "Erro ao obter lista de empregados");

    }

    // ERRO AO SALVAR! (SEM ID)
    @Test
    public void testIncluirNovoEmpregadoComDepartamentoInexistente() {
        // GIVEN objeto Empregado com um novo departamento (sem Id) e dados corretos
        Departamento departamento = Departamento.builder()
                .nome("Tecnologia")
                .sigla("TI")
                .valorOrcamento(15000.0)
                .build();

        Empregado empregado = Empregado.builder()
                .nome("Wanderson")
                .cargo("Desenvolvedor")
                .salario(10000.0)
                .departamento(departamento)
                .build();

        // WHEN executar inserção no banco
        Empregado empregadoSalvaBD = empregadoRepository.save(empregado);

        // THEN deve incluir empregado e departamento
        Assert.isTrue(empregadoSalvaBD.getId() != null, "Erro ao incluir empregado");
    }

    @Test
    public void testIncluirNovoEmpregadoComDepartamentoExistente() {
        // GIVEN objeto Empregado com departamento existente (com Id)
        Optional<Departamento> departamento = departamentoRepository.findById(3L);

        Empregado empregado = Empregado.builder()
                .nome("Wanderson")
                .cargo("Desenvolvedor")
                .salario(15300.0)
                .departamento(departamento.get())
                .build();

        // WHEN incluir empregado
        Empregado empregadoSalvaBD = empregadoRepository.save(empregado);

        // THEN empregado deve ter sido registrado
        Assert.isTrue(empregadoSalvaBD.getId() != null, "Erro ao incluir empregado");
    }

    @Test
    public void testAtualizarEmpregadoComDepartamentoExistente() {

        // GIVEN id do empregado
        Long empregadoId = 5L;
        Optional<Empregado> empregado = empregadoRepository.findById(empregadoId);

        // WHEN executar a atualização no banco com dado alterado
        Double salarioAlterado = 4500d;
        empregado.get().setSalario(salarioAlterado);
        Empregado empregadoSalvaBD = empregadoRepository.save(empregado.get());

        // THEN empregado deve ser atualizado com sucesso no banco
        Assert.isTrue(empregadoSalvaBD.getSalario().equals(salarioAlterado), "Erro ao alterar salário do empregado");

    }

    @Test
    public void testDeletarEmpregadoSemDeletarDepartamento() {

        Optional<Empregado> empregado = empregadoRepository.findById(6L);

        empregadoRepository.delete(empregado.get());

        empregado = empregadoRepository.findById(6L);
        Assert.isTrue(empregado.isPresent() == false, "Erro ao deletar empregado");


    }

    @Test
    public void testDeletarEmpregadoTambemDepartamento() {

        Optional<Empregado> empregado = empregadoRepository.findById(7L);
        Optional<Departamento> departamento = departamentoRepository.findById(3L);

        empregadoRepository.delete(empregado.get());
        departamentoRepository.delete(departamento.get());

        empregado = empregadoRepository.findById(7L);
        departamento = departamentoRepository.findById(3L);

        Assert.isTrue(empregado.isPresent() == false && departamento.isPresent() == false, "Erro ao deletar empregado e departamento");


    }

}
