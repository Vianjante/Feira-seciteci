package br.projeto.projeto_final.service;


import java.util.List;

import br.projeto.projeto_final.model.utilidades.FuncionarioNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.projeto.projeto_final.model.Funcionario;
import br.projeto.projeto_final.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

    @Autowired
   private FuncionarioRepository funcionarioRepository;


    public void addFuncionario(Funcionario funcionario){

        funcionarioRepository.save(funcionario);
    }
    public Funcionario listarId(Long id){

        return funcionarioRepository.findById(id).orElse(null);
    }

    public List<Funcionario> lista(){
      return  funcionarioRepository.findAll();
    }

    public Funcionario procurarId(Long id){
      return   funcionarioRepository.findById(id).orElse(null);
    }
    public List<Funcionario> listarPorCpf(String cpf){
      return funcionarioRepository.findByCpf(cpf);
    }

    public Funcionario listarPorEmail(String email){
      return funcionarioRepository.findByEmail(email);
    }

    public Funcionario alterarFuncionario( Long id, Funcionario novoFuncionario) {
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new FuncionarioNotFoundException("Funcionário não encontrado com o ID: " + id));

        funcionario.setId(novoFuncionario.getId());
        funcionario.setNome(novoFuncionario.getNome());
        funcionario.setCpf(novoFuncionario.getCpf());
        funcionario.setCargo(novoFuncionario.getCargo());
        funcionario.setEmail(novoFuncionario.getEmail());
        funcionario.setData_nascimento(novoFuncionario.getData_nascimento());
        funcionario.setAtuacao(novoFuncionario.getAtuacao());
        funcionario.setFormacao(novoFuncionario.getFormacao());
        funcionario.setEmAtividade(novoFuncionario.getEmAtividade());
        funcionario.setRenumeracao(novoFuncionario.getRenumeracao());
        funcionario.setCidade(novoFuncionario.getCidade());
        funcionario.setBairro(novoFuncionario.getBairro());
        funcionario.setRua(novoFuncionario.getRua());
        funcionario.setCasaApartamento(novoFuncionario.getCasaApartamento());

        // Salve o funcionário atualizado no banco de dados
        return funcionarioRepository.save(funcionario);
    }


    public void deletarFuncionario(Long id) {
        funcionarioRepository.findById(id);
        funcionarioRepository.deleteById(id);
    }

}
