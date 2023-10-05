package br.projeto.projeto_final.repository;

import br.projeto.projeto_final.model.Disciplina;
import br.projeto.projeto_final.model.EventoFuncionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoFuncionarioRepository extends JpaRepository<EventoFuncionario, Long> {
}
