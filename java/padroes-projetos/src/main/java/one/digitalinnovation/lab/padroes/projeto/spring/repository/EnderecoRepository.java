package one.digitalinnovation.lab.padroes.projeto.spring.repository;

import one.digitalinnovation.lab.padroes.projeto.spring.model.Endereco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, String> {


}