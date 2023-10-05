package br.projeto.projeto_final.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class EventoFuncionario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long  id;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;

    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;

}
