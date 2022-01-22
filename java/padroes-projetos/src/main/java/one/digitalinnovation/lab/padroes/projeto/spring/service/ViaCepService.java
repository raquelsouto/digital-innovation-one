package one.digitalinnovation.lab.padroes.projeto.spring.service;

import one.digitalinnovation.lab.padroes.projeto.spring.model.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

/**
 * @see <a href="https://spring.io/projects/spring-cloud-openfeign"> Spring Cloud OpenFeign</a>
 * @see <a href="https://viacep.com.br">ViaCEP</a>
 *
 * @author Raquel Winkeler
 */

@Service
@FeignClient(name = "viacep", url = "https://viacep.com.br/ws/01001000/json/")
public interface ViaCepService {

        @GetMapping("/{cep}/json/")
        Endereco consultarCep(@PathVariable("cep") String cep);

}
