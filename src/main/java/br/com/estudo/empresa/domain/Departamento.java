package br.com.estudo.empresa.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "departamento")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String sigla;

    private Double valorOrcamento;

    @OneToMany(mappedBy = "departamento", fetch = FetchType.EAGER)
    private List<Empregado> empregados;

}
