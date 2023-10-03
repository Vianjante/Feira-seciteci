package br.projeto.projeto_final.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cadastro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long  id;

//    private Funcionario funcionario;
//
//    private Disciplina disciplina;
//
//    private Evento evento;
}
