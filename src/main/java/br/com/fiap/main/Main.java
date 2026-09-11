package br.com.fiap.main;

import br.com.fiap.utils.Jopt;

public class Main {
    public static void main(String[] args) {
        String[] test = {"Login", "cadastro"};

        System.out.println(Jopt.showOption(test));
    }
}
