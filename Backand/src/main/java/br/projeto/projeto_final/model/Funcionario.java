package br.projeto.projeto_final.model;



import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotBlank(message = "Campo não  inserido")
    private String nome;

    @Column(unique = true)
    @NotBlank(message = "Campo não  inserido")
    @CPF(message = "CPF invalido")
    private String cpf;

    @Column(unique = true)
    @NotBlank(message = "Campo não  inserido")
    @Email(message = "E-mail invalido")
    private String email;

    @NotBlank(message = "Campo não  inserido")
    private String data_nascimento;

    @NotBlank(message = "Campo não  inserido")
    private String cargo; // vai se tornar uma extenção dessa tabela
    
    @NotBlank(message = "Campo não  inserido")
    private String emAtividade;

    @NotBlank(message = "Campo não  inserido")
    private String atuacao;

    @NotBlank(message = "Campo não  inserido")
    private String formacao;


    private Float renumeracao;
    @NotBlank(message = "Campo não  inserido")
    private String cidade;

    @NotBlank(message = "Campo não  inserido")
    private String bairro;

    @NotBlank(message = "Campo não  inserido")
    private String rua;

    @NotBlank(message = "Campo não  inserido")
    private String casaApartamento;


    public Funcionario(  String nome, String cpf, String email, String data_nascimento, String cargo, String emAtividade, String atuacao, String formacao, Float renumeracao,String cidade, String bairro, String rua, String casaApartamento) {

        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.data_nascimento = data_nascimento;
        this.cargo = cargo;
        this.emAtividade = emAtividade;
        this.atuacao = atuacao;
        this.formacao = formacao;
        this.renumeracao = renumeracao;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.casaApartamento = casaApartamento;
    }
}
