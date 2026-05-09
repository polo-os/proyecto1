import Interfazz.Formulario;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Formulario formulario = new Formulario();

        formulario.setVisible(true);

        formulario.setSize(600,500);

        formulario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
