package br.projeto.projeto_final.model.utilidades;

public class FuncionarioNotFoundException extends RuntimeException {

    public FuncionarioNotFoundException(String message) {
        super(message);
    }

    public FuncionarioNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}