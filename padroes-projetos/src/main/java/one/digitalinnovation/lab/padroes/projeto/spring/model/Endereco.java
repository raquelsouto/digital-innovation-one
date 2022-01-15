package one.digitalinnovation.lab.padroes.projeto.spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    @Id
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String cidade;
    private String uf;
    private String ddd;
    private String ibge;
    private String gia;
    private String siafi;

}