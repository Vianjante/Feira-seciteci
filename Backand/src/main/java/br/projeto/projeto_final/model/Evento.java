package br.projeto.projeto_final.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
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
public class Evento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    @NotBlank(message = "Campo não  inserido")
    private String nome;

    @NotBlank(message = "Campo não  inserido")
    private String descricao;

    @NotBlank(message = "Campo não  inserido")
    private String local;

    @NotBlank(message = "Campo não  inserido")
    private String data_inicio;

    @NotBlank(message = "Campo não  inserido")
    private String hora_inicio;

    @NotBlank(message = "Campo não  inserido")
    private Integer duração_prevista;


    public Evento(String nome, String descricao, String local, String data_inicio, Integer duração_prevista) {
        this.nome = nome;
        this.descricao = descricao;
        this.local = local;
        this.data_inicio = data_inicio;
        this.duração_prevista = duração_prevista;
    }
}
