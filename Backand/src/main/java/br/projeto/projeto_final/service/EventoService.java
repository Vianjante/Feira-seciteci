package br.projeto.projeto_final.service;



import br.projeto.projeto_final.model.Evento;
import br.projeto.projeto_final.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService {

    @Autowired
    private EventoRepository repository;

    public void adicionar(Evento evento){
       repository.save(evento); }

    public List<Evento> listar(){
        return repository.findAll();
    }

    public Evento EventoNome(String nome){
       return repository.findByNome(nome);
    }

    public void deletar(Long id){
        repository.findById(id);
        repository.deleteById(id);
    }

    public void atualizar(Long id, Evento evento){
        Evento novoEvento = repository.findById(id).orElse(null);
        novoEvento.setId(evento.getId());
        novoEvento.setNome(evento.getNome());
        novoEvento.setDescricao(evento.getDescricao());

        repository.save(novoEvento);
    }
}
