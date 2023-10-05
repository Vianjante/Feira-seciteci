package br.projeto.projeto_final.controller;


import java.util.HashMap;
import java.util.Map;

import br.projeto.projeto_final.model.utilidades.FuncionarioNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.projeto.projeto_final.model.Funcionario;
import br.projeto.projeto_final.service.FuncionarioService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/funcionario")
@CrossOrigin(origins = "http://localhost:4200")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping
    public ResponseEntity addFundionario(@RequestBody @Valid Funcionario funcionario){
        funcionarioService.addFuncionario(funcionario);
          return ResponseEntity.ok("Funcionario cadastrado!");
    }

    @GetMapping
    public ResponseEntity lista(){
        return ResponseEntity.ok(funcionarioService.lista());
    }

    @GetMapping("/{id}")
    public ResponseEntity listarId(@PathVariable Long id){

        return ResponseEntity.ok(funcionarioService.listarId(id));
    }

    @GetMapping("/cpf{cpf}")
    public ResponseEntity listarPorCpf(@PathVariable String cpf){
        return ResponseEntity.ok(funcionarioService.listarPorCpf(cpf));
    }

    @GetMapping("/{email}")
    public ResponseEntity listarPorEmail(@PathVariable String email){
        return ResponseEntity.ok(funcionarioService.listarPorEmail(email));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> excluirFuncionario(@PathVariable Long id) {
        try {
            funcionarioService.deletarFuncionario(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao excluir funcionário.");
        }
    }



    @PutMapping("/atualizar{id}")
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody Funcionario funcionario){
        try {
            Funcionario funcionarioAtualizado = funcionarioService.alterarFuncionario(id, funcionario);
            return ResponseEntity.ok(funcionarioAtualizado);
        } catch (FuncionarioNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
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
