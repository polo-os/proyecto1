package Interfazz;

import enumm.Ejercicios;
import modelo_logica.Usuario;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Formulario extends JFrame {

    //Compocicion
    private Usuario usuario;
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
    private JTextField altRU;
    private JLabel alturaLabelRU;
    private JSpinner edadRU;
    private JTextField passworconfRU;
    private JLabel passwordLabelRU;
    private JTextField passwordRU;
    private JLabel confPasswordLabelRU;
    private JTextField kgRu;

    private JPanel RegistroRE;
    private JPanel RegistroPeso;
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

        this.usuario = new Usuario();


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
        registrarButtonRU.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            registrarButtonRU();
            }
        });

        acPesoButtonPP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                acPesoButtonPP();
            }
        });
    }


    //Registrar
    public void irRegistrarButton(){
        InicioSesion.setVisible(false);
        RegistroRE.setVisible(true);
    }

    //Iniciar
    public void inicioBottonin(){

        if (usuario.inicioSecion(userin.getText(),passwordin.getText())){
            InicioSesion.setVisible(false);
            pagPrincipal.setVisible(true);
            UserPP.setText(userin.getText());

        }
        else {
            userin.setText("");
            passwordin.setText("");
            JOptionPane.showMessageDialog(null,"Usuario o contraseñas incorrecta\n"+
                    "Profavor Revisar");
        }
    }

    //Registrar Usuario
    public void registrarButtonRU(){

        //Validar Datos dell Formulario
        try{
            //Agregar valores
            this.usuario.setNombre(userRU.getText());
            this.usuario.setEdad(Integer.parseInt(edadRU.getValue().toString()));
            this.usuario.setPeso(Integer.parseInt(kgRu.getText()));
            this.usuario.setAltura(Float.parseFloat(altRU.getText()));
            this.usuario.setPassword(passwordRU.getText());

            if(passworconfRU.getText().equals(this.usuario.getPassword())) {
                if (this.usuario.insertarRegistroBD()) {
                    JOptionPane.showMessageDialog(null, "Se Creo el Usuario Correctamente.. ");
                    RegistroPeso.setVisible(true);
                    RegistroRE.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, " Error al Crear el Usuario" + "\n Posible Error en la conexion");
                }
            }
            else {
                JOptionPane.showMessageDialog(null,"Error contraseña diferente a la ingresada anterirormente");
            }
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error al registrar el Usuario:\n "+
                    "Tipo de Error: "+e.getMessage()+
                    "\n\nValiar Cajas de Texto");
        }
    }

    public void acPesoButtonPP(){
        pagPrincipal.setVisible(false);
        RegistroPeso.setVisible(true);
    }
}
