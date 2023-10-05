package br.projeto.projeto_final.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.projeto.projeto_final.model.Evento;
import br.projeto.projeto_final.model.Funcionario;
import java.util.List;


@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {
    Evento findByNome(String nome);
}
