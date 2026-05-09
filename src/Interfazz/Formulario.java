package Interfazz;

import enumm.Ejercicios;
import interfaz.InterfazGrafica;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Formulario extends JFrame {
    //Atributos
    private JPanel panel1;
    private JTextField userin;
    private JTextField passwordin;
    private JButton inicioButtonin;
    private JButton RegistrarseButtonin;
    private JLabel inicioDeSeciónLabelin;
    private JLabel userLabelin;
    private JLabel passwordLabelin;
    private JPanel InicioSesion;

    private JPanel registroUser;
    private JLabel registroLabelRU;
    private JLabel userLabelRU;
    private JLabel pesoKgLabelRU;
    private JLabel edadLabelRU;
    private JButton registrarButtonRU;
    private JButton atrasButtonRU;
    private JTextField userRU;
    private JSpinner kgRU;
    private JTextField altRU;
    private JLabel alturaLabelRU;
    private JSpinner edadRU;
    private JTextField passworconfRU;
    private JLabel passwordLabelRU;
    private JTextField passwordRU;
    private JLabel confPasswordLabelRU;

    private JPanel RegistroRE;
    public JPanel RegistroPeso;
    private JComboBox ejercicioRE;
    private JTextField pesoRE;
    private JTextField repeticionesRE;
    private JButton agregarButtonRE;
    private JButton actualizarButtonRE;
    private JButton continuarButtonRE;
    private JButton eliminarButtonRE;
    private JTable table1RE;
    private JLabel regisEjercicioRE;
    private JLabel ejercicioLabelRE;
    private JLabel pesoKgLabelRE;
    private JLabel numeroRepeticionesRE;

    private JPanel pagPrincipal;
    private JTabbedPane tabbedPane1;
    private JTextField UserPP;
    private JTextField mciPP;
    private JComboBox filtrarcomboBoxPP;
    private JTable table2PP;
    private JLabel paginaPrincipalLabelPP;
    private JLabel userLabelPP;
    private JLabel mciLabelPP;
    private JLabel filPorLabelPP;
    private JButton acPesoButtonPP;
    private JButton filtrarButtonPP;
    private JButton cerrarSesionButtonPP;

    private JPanel ranking;
    private JTable table1;
    private JLabel tablaLabelRK;
    private JPanel paginaPrincipal;
    private JTextField puestoRK;
    private JComboBox filPcomboBox1RK;
    private JButton filtrarButtonRK;
    private JButton actualizarButtonRK;
    private JLabel puestoLabelRK;
    private JLabel filPorLabelRK;

    //Metodos
    public Formulario() {

        setContentPane(panel1);

        //recibe los valores de la clase enumm
        JComboBox jComboBox = new JComboBox(Ejercicios.values());

        ejercicioRE.setModel(jComboBox.getModel());

        AutoCompleteDecorator.decorate(ejercicioRE);


        //registrarse
        RegistrarseButtonin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                irRegistrarButton();
            }
        });
        inicioButtonin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inicioBottonin();
            }
        });
    }


    //Registrar
    public void irRegistrarButton(){
        InicioSesion.setVisible(false);
        RegistroPeso.setVisible(true);
    }

    public void inicioBottonin(){
        InicioSesion.setVisible(false);
        paginaPrincipal.setVisible(true);
    }
}
