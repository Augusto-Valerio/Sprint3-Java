package br.com.fiap.utils;

import javax.swing.*;

public class Jopt {

    public static void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public static void showError(String message) {
        JOptionPane.showMessageDialog(null, message, "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public static String input(String message) {
        String value = JOptionPane.showInputDialog(null, message);

        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Campo obrigatorio não informado.");
        }

        return value.trim();
    }

    public static int showOption(String[] options) {
        return JOptionPane.showOptionDialog(
                null,
                "O que deseja realizar?",
                "Sistema TOTVS",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
                );
    }



}
