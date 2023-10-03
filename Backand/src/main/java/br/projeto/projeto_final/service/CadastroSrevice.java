package br.projeto.projeto_final.service;

import br.projeto.projeto_final.model.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroSrevice {

    @Autowired
    private FuncionarioService funcionarioService;

    public Funcionario cadastro(Funcionario funcionario){

        return funcionario;
    }
}
