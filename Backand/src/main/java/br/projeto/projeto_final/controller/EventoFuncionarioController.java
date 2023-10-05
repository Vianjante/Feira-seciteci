package br.projeto.projeto_final.controller;

import br.projeto.projeto_final.model.EventoFuncionario;
import br.projeto.projeto_final.model.Funcionario;
import br.projeto.projeto_final.model.utilidades.FuncionarioNotFoundException;
import br.projeto.projeto_final.service.EventoFuncionarioService;
import br.projeto.projeto_final.service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

public class EventoFuncionarioController {
    @Autowired
    private EventoFuncionarioService funcionarioService;

    @PostMapping
    public ResponseEntity addEventoFundionario(@RequestBody @Valid EventoFuncionario funcionario){
        funcionarioService.add(funcionario);
        return ResponseEntity.ok("Funcionario cadastrado!");
    }

    @GetMapping
    public ResponseEntity lista(){
        return ResponseEntity.ok(funcionarioService.listar());
    }


//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<?> excluirFuncionario(@PathVariable Long id) {
//        try {
//            funcionarioService.deletarFuncionario(id);
//            return ResponseEntity.noContent().build();
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao excluir funcionário.");
//        }
//    }



//    @PutMapping("/atualizar{id}")
//    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody Funcionario funcionario){
//        try {
//            Funcionario funcionarioAtualizado = funcionarioService.alterarFuncionario(id, funcionario);
//            return ResponseEntity.ok(funcionarioAtualizado);
//        } catch (FuncionarioNotFoundException e) {
//            return ResponseEntity.notFound().build();
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
    @PutMapping("/atualizar/cpf{cpf}")
    public ResponseEntity atualizarCpf(@PathVariable String Cpf, @RequestBody Funcionario funcionario){

        return ResponseEntity.ok().build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> ArgumentoInvalido(MethodArgumentNotValidException argumentoInvalido){
        Map<String, String> erros = new HashMap<>();

        argumentoInvalido.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldNome = ((FieldError) erros).getField();
            String errorMassage = error.getDefaultMessage();
            erros.put(fieldNome, errorMassage);
        });

        return erros;
    }

}
