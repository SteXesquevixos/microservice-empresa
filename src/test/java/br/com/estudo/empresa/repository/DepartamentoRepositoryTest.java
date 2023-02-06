package br.com.estudo.empresa.repository;

import br.com.estudo.empresa.domain.Departamento;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DepartamentoRepositoryTest {

    @Autowired
    public EmpregadoRepository empregadoRepository;

    @Autowired
    public DepartamentoRepository departamentoRepository;


    @Test
    public void testObterDepartamentoById() {

        // GIVEN id do departamento
        Long departamentoId = 1L;

        // WHEN executar, buscar departamento no BD
        Departamento departamento = departamentoRepository.findById(departamentoId).get();

        // THEN obter dados
        Assert.isTrue(departamento.getId() != null, "Erro ao encontrar departamento");

    }

    @Test
    public void testObterTodosDepartamentos() {

        List<Departamento> departamento = departamentoRepository.findAll();
        Assert.isTrue(departamento.size() > 0, "Erro ao encontrar dados dos departamentos");

    }

    @Test
    public void testIncluirNovoDepartamento() {

        Departamento departamento = Departamento.builder()
                .nome("Departamento de Química")
                .sigla("DQ")
                .valorOrcamento(12000.0)
                .build();

        Departamento departamentoSalvaBD = departamentoRepository.save(departamento);

        Assert.isTrue(departamentoSalvaBD.getId() != null, "Erro ao incluir novo departamento");

    }

    @Test
    public void testAtualizarDepartamento() {

        Optional<Departamento> departamento = departamentoRepository.findById(2L);

        String nomeAlterado = "Departamento de Computação e Matemática";
        String siglaAlterada = "DCM";

        departamento.get().setNome(nomeAlterado);
        departamento.get().setSigla(siglaAlterada);

        Departamento departamentoSalvaBD = departamentoRepository.save(departamento.get());

        Assert.isTrue(departamentoSalvaBD.getNome().equals(nomeAlterado) &&
                departamentoSalvaBD.getSigla().equals(siglaAlterada), "Erro na atualização dos dados do departamento");

    }

    @Test
    public void testDeletarDepartamento() {

        Optional<Departamento> departamento = departamentoRepository.findById(4L);

        departamentoRepository.delete(departamento.get());

        departamento = departamentoRepository.findById(4L);

        Assert.isTrue(departamento.isPresent() == false, "Erro ao deletar departamento");

    }

}
