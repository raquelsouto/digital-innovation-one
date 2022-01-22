package br.com.dio.desafio.dominio;

import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Bootcamp {

    private String nome;
    private String descricao;
    private LocalDate dataInicial = LocalDate.now();
    private LocalDate dataFinal = dataInicial.plusDays(45);
    private Set<Dev> devInscritos = new HashSet<>();
    private Set<Conteudo> conteudos = new LinkedHashSet<>();

    public Bootcamp(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String toString() {
        String out = "";
        for (int i = 0; i < conteudos.size(); i++) {
            out += "Nome: " + nome + " | Descrição: " + descricao + " | Conteúdo:" + getConteudos();
        }
        return out;
    }

}



