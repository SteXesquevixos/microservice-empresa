package br.com.estudo.empresa.repository;

import br.com.estudo.empresa.domain.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
}
