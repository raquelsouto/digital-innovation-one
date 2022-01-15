package one.digitalinnovation.lab.padroes.projeto.spring.repository;

import one.digitalinnovation.lab.padroes.projeto.spring.model.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}

