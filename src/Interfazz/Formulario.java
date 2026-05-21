package Interfazz;

import enumm.Ejercicios;
import enumm.GrMuscul;
import modelo_logica.Ejercicio;
import modelo_logica.RegistroLevantamiento;
import modelo_logica.Usuario;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class Formulario extends JFrame {

    //Compocicion
    private Usuario usuario;
    private RegistroLevantamiento registroLevantamiento;
    private Ejercicio ejercicio;

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
    private JLabel grMusculJlabelRE;
    private JComboBox grMusculRE;

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
        this.registroLevantamiento = new RegistroLevantamiento();
        this.ejercicio = new Ejercicio();


        //recibe los valores de la clase enumm
        JComboBox jComboBox = new JComboBox(Ejercicios.values());

        ejercicioRE.setModel(jComboBox.getModel());
        filPcomboBox1RK.setModel(jComboBox.getModel());

        AutoCompleteDecorator.decorate(ejercicioRE);
        AutoCompleteDecorator.decorate(filPcomboBox1RK);

        JComboBox jComboBox2 = new JComboBox(GrMuscul.values());

        grMusculRE.setModel(jComboBox2.getModel());

        AutoCompleteDecorator.decorate(grMusculRE);


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
        agregarButtonRE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarButtonRE();
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
        try {
            //Agregar valores
            this.usuario.setNombre(userRU.getText());
            this.usuario.setEdad(Integer.parseInt(edadRU.getValue().toString()));
            this.usuario.setPeso(Integer.parseInt(kgRu.getText()));
            this.usuario.setAltura(Float.parseFloat(altRU.getText()));
            this.usuario.setPassword(passwordRU.getText());

            if (passworconfRU.getText().equals(this.usuario.getPassword())) {
                if (this.usuario.insertarRegistroBD()) {

                    // iniciar sesión automáticamente
                    this.usuario.inicioSecion(
                            userRU.getText(),
                            passwordRU.getText()
                    );

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

    //ir a actualizar
    public void acPesoButtonPP(){
        pagPrincipal.setVisible(false);
        RegistroPeso.setVisible(true);
    }

    //mostrar tabla
    public void mostrartablaRE(){
        //Datos de la tabla
        Object[][] filaDatos= new Object[1][4];
        Object[] nombreColumnas={"Ejercicio","Grupo Muscular","Peso","Repeticiones"};
        DefaultTableModel modeloTabla =new DefaultTableModel();

        //ASIGNAR MODELO DE LA TABLA A LA INTERFAZ GRAFICA
        modeloTabla.setColumnIdentifiers(nombreColumnas);
        this.table1RE.setModel(modeloTabla);

        //Fuente para el encabezado de la tabla
        JTableHeader tableHeader=this.table1RE.getTableHeader();
        tableHeader.setBackground(Color.ORANGE);
        tableHeader.setForeground(Color.MAGENTA);
        tableHeader.setFont(new Font("Impact", Font.ITALIC,14));


        List<RegistroLevantamiento> listaReg=registroLevantamiento.consultarRegistroBD(this.usuario.getId_usuario());

        for(RegistroLevantamiento registroLevantamiento:listaReg){
            filaDatos[0][0]=registroLevantamiento.getEjercicio().getNombreEjercicio();
            filaDatos[0][1]=registroLevantamiento.getEjercicio().getGrupoMuscular();
            filaDatos[0][2]=registroLevantamiento.getPesoLevantado();
            filaDatos[0][3]=registroLevantamiento.getRepeticiones();
            modeloTabla.addRow(filaDatos[0]);

            actualizarButtonRE.setEnabled(true);
            eliminarButtonRE.setEnabled(true);
        }
    }

    //Agregar Peso
    public void agregarButtonRE(){
        this.registroLevantamiento=new RegistroLevantamiento();
        this.ejercicio = new Ejercicio();

        try {
            this.registroLevantamiento.setPesoLevantado(Integer.parseInt(pesoRE.getText()));
            this.registroLevantamiento.setRepeticiones(Integer.parseInt(repeticionesRE.getText()));
            this.ejercicio.setNombreEjercicio(ejercicioRE.getSelectedItem().toString());
            this.ejercicio.setGrupoMuscular(grMusculRE.getSelectedItem().toString());


            //ver si hay un ejercicio Repetido en caso de que no crearlo
            if(!this.ejercicio.busEjercico()){

                this.ejercicio.insertarRegistroBD();

                this.ejercicio.busEjercico();
            }

            //conectar con Usuario y ejercicio
            this.registroLevantamiento.setUsuario(this.usuario);
            this.registroLevantamiento.setEjercicio(this.ejercicio);

            //agregar el registro

            if(this.registroLevantamiento.busRegistro()){
                JOptionPane.showMessageDialog(null,
                        "Ya tienes registrado este ejercicio");
            }
            else{
                if(this.registroLevantamiento.insertarRegistroBD()){
                    mostrartablaRE();
                }
                else {
                    JOptionPane.showMessageDialog(null,
                            "No se pudo agregar el registro");
                }
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error al agregar registro \n"+"tipo de error: "+e.getMessage() );
        }

    }

    public void mostrarTableFil(){

        //Datos relacionados a la tabla
        Object[][] filaDatos = new  Object[1][5];
        Object[] nombreColumna = {"Puesto","Nombre","Maquina","Repeticiones","Peso"};


    }
    public void FiltrarButon(){

    }
}


