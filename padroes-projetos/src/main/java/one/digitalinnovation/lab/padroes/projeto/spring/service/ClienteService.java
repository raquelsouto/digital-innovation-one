package one.digitalinnovation.lab.padroes.projeto.spring.service;

import one.digitalinnovation.lab.padroes.projeto.spring.model.Cliente;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ClienteService {

    public Iterable<Cliente> buscarTodos();

    public Cliente buscarPorId(Long id);

    public void inserir(Cliente cliente);

    public void atualizar(Long id, Cliente cliente);

    public void deletar(Long id);

}
