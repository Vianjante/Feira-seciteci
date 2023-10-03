package br.projeto.projeto_final.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.projeto.projeto_final.model.Funcionario;
import java.util.List;
import java.util.Optional;


@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    List<Funcionario> findByNome(String nome);
    List<Funcionario> findByCpf(String cpf);
    List<Funcionario> findByEmail(String email);
    void  deleteByEmail(String email);
    List<Funcionario> findByCidade(String cidade);

    List<Funcionario> findByRua(String rua);

    List<Funcionario> findByBairro(String bairro);
    Optional<Funcionario> findByCidadeAndBairroAndRuaAndCasaApartamento(String cidade, String Bairro, String rua, String casaApartamento);


}
