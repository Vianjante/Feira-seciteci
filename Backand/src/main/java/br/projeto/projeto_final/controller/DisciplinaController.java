package br.projeto.projeto_final.controller;

import br.projeto.projeto_final.model.Disciplina;
import br.projeto.projeto_final.service.DisciplinaService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/disciplina")
public class DisciplinaController {

    @Autowired
    private DisciplinaService sevice;

    @PostMapping
    public ResponseEntity add(@RequestBody @Valid Disciplina disciplina) {
        sevice.adicionar(disciplina);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity listar() {
        sevice.listar();
        return ResponseEntity.ok().build();
    }

    @PutMapping("/atualizar/{id}")
    @Transactional
    public ResponseEntity atulalizar(@PathVariable Long id, @RequestBody Disciplina disciplina) {
        sevice.atualizar(id, disciplina);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deletar/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id) {
        sevice.deletar(id);
        return ResponseEntity.ok().build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> ArgumentoInvalido(MethodArgumentNotValidException argumentoInvalido) {
        Map<String, String> erros = new HashMap<>();

        argumentoInvalido.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldNome = ((FieldError) erros).getField();
            String errorMassage = error.getDefaultMessage();
            erros.put(fieldNome, errorMassage);
        });

        return erros;
    }
}
