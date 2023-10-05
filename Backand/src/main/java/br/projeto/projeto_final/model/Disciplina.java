package br.projeto.projeto_final.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Disciplina {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigoDisciplina;

    @NotBlank(message = "Campo não  inserido")
    private String nome;

    @NotBlank(message = "Campo não  inserido")
    private Float cghSemanal;

    private String turma;

    private String escola;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Funcionario professor;

    public Disciplina(Long codigoDisciplina, String nome, Float cghSemanal, String turma, String escola, Funcionario professor) {
        this.codigoDisciplina = codigoDisciplina;
        this.nome = nome;
        this.cghSemanal = cghSemanal;
        this.turma = turma;
        this.escola = escola;
        this.professor = professor;
    }
}
