package br.com.estudo.empresa.repository;

import br.com.estudo.empresa.domain.Empregado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpregadoRepository extends JpaRepository<Empregado, Long> {
}
