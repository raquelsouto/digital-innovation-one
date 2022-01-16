package br.com.dio.desafio.dominio;

import java.time.LocalDate;

public class Teste {

    public static void main(String[] args) {

        Curso conteudo = new Curso("Java", "Orientação a Objetos", 360);
        System.out.println("Pegando todas as informações referente ao curso 1..");
        System.out.println(conteudo.toString());

        System.out.println("\nPegando todas as informações referente ao curso 2..");
        Curso conteudo2 = new Curso("JavaScript", "HTML, CSS e JS", 480);
        System.out.println(conteudo2.toString());

        System.out.println("\nCrinado uma Mentoria..");
        Mentoria mentoria = new Mentoria("Backend", "Java", LocalDate.now());
        System.out.println(mentoria.toString());

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Java");
        bootcamp.setDescricao("Java developer");
        bootcamp.getConteudos().add(conteudo);
        bootcamp.getConteudos().add(conteudo2);
        bootcamp.getConteudos().add(mentoria);
        System.out.println("");

        System.out.println("Criando desenvolvedores..");
        System.out.println("\nBootcamps para o desenvolvedor 1");
        Dev dev = new Dev("Raquel");
        dev.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos inscritos: " + dev.getConteudosInscritos().toString());
        dev.progredir();
        System.out.println("Pontuação " + dev.getNome() + " XP = " + dev.calcularXP());

        System.out.println("\nBootcamps para o desenvolvedor 2");
        Dev dev2 = new Dev("João");
        dev2.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos inscritos: " + dev2.getConteudosInscritos().toString());
        dev2.progredir();
        System.out.println("Pontuação " + dev2.getNome() + " XP = " + dev2.calcularXP());

    }
}