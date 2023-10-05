package br.projeto.projeto_final.service;

import br.projeto.projeto_final.model.Evento;
import br.projeto.projeto_final.model.EventoFuncionario;
import br.projeto.projeto_final.model.Funcionario;
import br.projeto.projeto_final.repository.EventoFuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoFuncionarioService {
    @Autowired
    EventoFuncionarioRepository eventoFuncionarioRepository;
    @Autowired
    FuncionarioService funcionarioService;
    @Autowired
    EventoService eventoService;

    public EventoFuncionario add(EventoFuncionario eventoFuncionario) {
        eventoFuncionario.setFuncionario(funcionarioService.listarPorEmail(eventoFuncionario.getFuncionario().getEmail()));
        eventoFuncionario.setEvento(eventoService.EventoNome(eventoFuncionario.getEvento().getNome()));

        return eventoFuncionarioRepository.save(eventoFuncionario);
    }

    public List<EventoFuncionario> listar() {
        return eventoFuncionarioRepository.findAll();
    }

}



