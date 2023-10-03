package br.projeto.projeto_final.service;


import java.util.List;


import br.projeto.projeto_final.model.Disciplina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.projeto.projeto_final.repository.DisciplinaRepository;

@Service
public class DisciplinaService {
    
    @Autowired
    private DisciplinaRepository repository;

    public void adicionar(Disciplina disciplina){
       repository.save(disciplina);
    }

    public List<Disciplina> listar(){
        return repository.findAll();
    }

    public void deletar(Long id){
        repository.findById(id);
        repository.deleteById(id);
    }

    public void atualizar(Long id, Disciplina disciplina){
        Disciplina novaDisciplina = repository.findById(id).orElse(null);

        novaDisciplina.setNome(disciplina.getNome());
        novaDisciplina.setCghSemanal(disciplina.getCghSemanal());
        novaDisciplina.setId(disciplina.getId());
        repository.save(novaDisciplina);
    }
}
