package br.projeto.projeto_final.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
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
    private Integer duração_prevista;

    @NotBlank(message = "Campo não  inserido")
    private String local;

    @NotBlank(message = "Campo não  inserido")
    private String data_inicio;

    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<EventoFuncionario> eventos;

    public Evento(Long id, String nome, String descricao, Integer duração_prevista, String local, String data_inicio, String hora_inicio) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.duração_prevista = duração_prevista;
        this.local = local;
        this.data_inicio = data_inicio;
    }
}
