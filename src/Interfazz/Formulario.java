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

    private JPanel RegistroRU;
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
    private JTextField imcPP;
    private JComboBox filtrarcomboBoxPP;
    private JTable table2PP;
    private JLabel paginaPrincipalLabelPP;
    private JLabel userLabelPP;
    private JLabel imcLabel;
    private JLabel filPorLabelPP;
    private JButton acPesoButtonPP;
    private JButton filtrarButtonPP;
    private JButton cerrarSesionButtonPP;

    private JPanel ranking;
    private JTable table1RK;
    private JLabel tablaLabelRK;
    private JPanel paginaPrincipal;
    private JTextField puestoRK;
    private JComboBox filPcomboBox1RK;
    private JButton filtrarButtonRK;
    private JButton actualizarButtonRK;
    private JLabel puestoLabelRK;
    private JLabel filPorLabelRK;
    private JButton seleccionarButton;
    private JPanel Ajustes;
    private JLabel ajustesLabelAJ;
    private JLabel pesoLabelAJ;
    private JLabel alturaLabelAJ;
    private JTextField PesoAJ;
    private JTextField AltAJ;
    private JButton actualizarButtonAJ;
    private JButton datosUsuarioButton;
    private JButton atrasbuttonAJ;



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

        filtrarcomboBoxPP.setModel(jComboBox2.getModel());

        AutoCompleteDecorator.decorate(filtrarcomboBoxPP);


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
        atrasButtonRU.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atrasButtonRU();
            }
        });

        cerrarSesionButtonPP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarSesionButtonPP();
            }
        });
        actualizarButtonRE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarButtonRE();
            }
        });
        eliminarButtonRE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarButtonRE();
            }
        });
        continuarButtonRE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                continuarButtonRE();
            }
        });
        seleccionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seleccionarButton();
            }
        });
        filtrarButtonRK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FiltrarButon();
            }
        });
        actualizarButtonRK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarRk();
            }
        });
        datosUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DatosUser();
            }
        });

        atrasbuttonAJ.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AtrasAj();
            }
        });

        actualizarButtonAJ.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ActualizarAJ();
                calcularmci();
            }
        });
        filtrarButtonPP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtrarButtonPP();
            }
        });
    }








    //Registrar
    public void irRegistrarButton(){
        InicioSesion.setVisible(false);
        RegistroRU.setVisible(true);
        this.userRU.setText("");
        this.edadRU.setValue(0);
        this.altRU.setText("");
        this.kgRu.setText("");
        this.passwordRU.setText("");
        this.passworconfRU.setText("");
    }

    //Iniciar
    public void inicioBottonin(){

        if (usuario.inicioSecion(userin.getText(),passwordin.getText())){
            InicioSesion.setVisible(false);
            pagPrincipal.setVisible(true);
            UserPP.setText(userin.getText());
            mostrartablaPP();
            calcularmci();
            userin.setText("");
            passwordin.setText("");
        }
        else {
            userin.setText("");
            passwordin.setText("");
            JOptionPane.showMessageDialog(null,"Usuario o contraseñas incorrecta\n"+
                    "Porfavor Revisar");
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
                    RegistroRU.setVisible(false);
                    UserPP.setText(userRU.getText());
                    userin.setText("");
                    passwordin.setText("");

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
        actualizarButtonRE.setEnabled(false);
        mostrartablaRE();
        seleccionarButton.setEnabled(true);
        eliminarButtonRE.setEnabled(true);
        continuarButtonRE.setEnabled(true);


    }



    public void atrasButtonRU(){
        InicioSesion.setVisible(true);
        RegistroRU.setVisible(false);

    }


    public void mostrartablaPP(){
        this.registroLevantamiento = new RegistroLevantamiento();
        //Datos de la tabla
        Object[][] filaDatos= new Object[1][5];
        Object[] nombreColumnas={"id","Ejercicio","Grupo Muscular","Peso","Repeticiones"};
        DefaultTableModel modeloTabla =new DefaultTableModel();

        //ASIGNAR MODELO DE LA TABLA A LA INTERFAZ GRAFICA
        modeloTabla.setColumnIdentifiers(nombreColumnas);
        this.table2PP.setModel(modeloTabla);
        table2PP.getColumnModel().getColumn(0).setMinWidth(0);
        table2PP.getColumnModel().getColumn(0).setMaxWidth(0);
        table2PP.getColumnModel().getColumn(0).setPreferredWidth(0);
        //Fuente para el encabezado de la tabla
        JTableHeader tableHeader=this.table1RE.getTableHeader();
        tableHeader.setBackground(Color.ORANGE);
        tableHeader.setForeground(Color.MAGENTA);
        tableHeader.setFont(new Font("Impact", Font.ITALIC,14));


        List<RegistroLevantamiento> listaReg=registroLevantamiento.consultarRegistroBD(this.usuario.getId_usuario());

        for(RegistroLevantamiento registroLevantamiento:listaReg){
            filaDatos[0][0]=registroLevantamiento.getIdRegistro();
            filaDatos[0][1]=registroLevantamiento.getEjercicio().getNombreEjercicio();
            filaDatos[0][2]=registroLevantamiento.getEjercicio().getGrupoMuscular();
            filaDatos[0][3]=registroLevantamiento.getPesoLevantado();
            filaDatos[0][4]=registroLevantamiento.getRepeticiones();
            modeloTabla.addRow(filaDatos[0]);


        }
    }

    public void mostrartablaPPfiltro(List<RegistroLevantamiento> listReg) {

        //Datos de la tabla
        Object[][] filaDatos = new Object[1][5];
        Object[] nombreColumnas = {"id", "Ejercicio", "Grupo Muscular", "Peso", "Repeticiones"};

        DefaultTableModel modeloTabla = new DefaultTableModel();


        //ASIGNAR MODELO DE LA TABLA A LA INTERFAZ GRAFICA
        modeloTabla.setColumnIdentifiers(nombreColumnas);

        this.table2PP.setModel(modeloTabla);
        table2PP.getColumnModel().getColumn(0).setMinWidth(0);
        table2PP.getColumnModel().getColumn(0).setMaxWidth(0);
        table2PP.getColumnModel().getColumn(0).setPreferredWidth(0);

        //Fuente para el encabezado de la tabla

        JTableHeader tableHeader = this.table1RE.getTableHeader();
        tableHeader.setBackground(Color.ORANGE);
        tableHeader.setForeground(Color.MAGENTA);
        tableHeader.setFont(new Font("Impact", Font.ITALIC, 14));

        for (RegistroLevantamiento registroLevantamiento : listReg) {
            filaDatos[0][0] = registroLevantamiento.getIdRegistro();
            filaDatos[0][1] = registroLevantamiento.getEjercicio().getNombreEjercicio();
            filaDatos[0][2] = registroLevantamiento.getEjercicio().getGrupoMuscular();
            filaDatos[0][3] = registroLevantamiento.getPesoLevantado();
            filaDatos[0][4] = registroLevantamiento.getRepeticiones();
            modeloTabla.addRow(filaDatos[0]);


        }
    }


    //mostrar tabla
    public void mostrartablaRE(){
        //Datos de la tabla
        Object[][] filaDatos= new Object[1][5];
        Object[] nombreColumnas={"id","Ejercicio","Grupo Muscular","Peso","Repeticiones"};
        DefaultTableModel modeloTabla =new DefaultTableModel();

        //ASIGNAR MODELO DE LA TABLA A LA INTERFAZ GRAFICA
        modeloTabla.setColumnIdentifiers(nombreColumnas);
        this.table1RE.setModel(modeloTabla);
        table1RE.getColumnModel().getColumn(0).setMinWidth(0);
        table1RE.getColumnModel().getColumn(0).setMaxWidth(0);
        table1RE.getColumnModel().getColumn(0).setPreferredWidth(0);

        //Fuente para el encabezado de la tabla
        JTableHeader tableHeader=this.table1RE.getTableHeader();
        tableHeader.setBackground(Color.ORANGE);
        tableHeader.setForeground(Color.MAGENTA);
        tableHeader.setFont(new Font("Impact", Font.ITALIC,14));


        List<RegistroLevantamiento> listaReg=registroLevantamiento.consultarRegistroBD(this.usuario.getId_usuario());

        for(RegistroLevantamiento registroLevantamiento:listaReg){
            filaDatos[0][0]=registroLevantamiento.getIdRegistro();
            filaDatos[0][1]=registroLevantamiento.getEjercicio().getNombreEjercicio();
            filaDatos[0][2]=registroLevantamiento.getEjercicio().getGrupoMuscular();
            filaDatos[0][3]=registroLevantamiento.getPesoLevantado();
            filaDatos[0][4]=registroLevantamiento.getRepeticiones();
            modeloTabla.addRow(filaDatos[0]);


        }
    }

    public   void seleccionarButton(){
      int filaselect =table1RE.getSelectedRow();
        System.out.println("Fila select: "+filaselect);

        if(filaselect!=-1){
            DefaultTableModel model=(DefaultTableModel)(this.table1RE.getModel());

            ejercicioRE.setSelectedItem(model.getValueAt(filaselect,1).toString());
            grMusculRE.setSelectedItem(model.getValueAt(filaselect,2).toString());
            pesoRE.setText(model.getValueAt(filaselect,3).toString());
            repeticionesRE.setText(model.getValueAt(filaselect,4).toString());
          eliminarButtonRE.setEnabled(false);
          actualizarButtonRE.setEnabled(true);



        } else {
            JOptionPane.showMessageDialog(null,"Seleccione un registro de la tabla ");
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
                    eliminarButtonRE.setEnabled(true);
                    seleccionarButton.setEnabled(true);
                    continuarButtonRE.setEnabled(true);
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


    public void actualizarButtonRE(){
        try{

            this.ejercicio.setNombreEjercicio(ejercicioRE.getSelectedItem().toString());
            this.ejercicio.setGrupoMuscular(grMusculRE.getSelectedItem().toString());
            this.registroLevantamiento.setEjercicio(this.ejercicio);
            this.registroLevantamiento.setRepeticiones(Integer.parseInt(repeticionesRE.getText()));
            this.registroLevantamiento.setPesoLevantado(Integer.parseInt(pesoRE.getText()));
            //Actualizar BD
            if (this.ejercicio.actualizarRegistroBD() && this.registroLevantamiento.actualizarRegistroBD()) {
                JOptionPane.showMessageDialog(null, "\nProducto actualizado correctamente!!!!");
                mostrartablaRE();
                actualizarButtonRE.setEnabled(false);
                eliminarButtonRE.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(null, "ERORRR AL ACTUALIZAR");
            }



        } catch (Exception e){
            JOptionPane.showMessageDialog(null,"Verifique que las cajas de texto correspondan" +
                    "a valores numericos \n tipo de error: "+e.getMessage());
        }


    }

    public   void eliminarButtonRE(){
        int filaSelect = table1RE.getSelectedRow();



        int id = Integer.parseInt(
                table1RE.getValueAt(filaSelect,0).toString()
        );

        boolean conf = JOptionPane.showConfirmDialog(
                null,
                "¿Está seguro que quiere eliminar este registro?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;

        if(conf) {
            this.registroLevantamiento.setIdRegistro(id);
            if (this.registroLevantamiento.eliminarRegistroBD()) {
                JOptionPane.showMessageDialog(
                        null,
                        "Registro eliminado correctamente"
                );
                mostrartablaRE();

            } else {

                JOptionPane.showMessageDialog(
                        null,
                        "Error al eliminar"
                );
            }
        }
    }

    public void continuarButtonRE(){
        pagPrincipal.setVisible(true);
        RegistroPeso.setVisible(false);
        mostrartablaPP();
        calcularmci();
    }

    public void cerrarSesionButtonPP(){
        pagPrincipal.setVisible(false);
        InicioSesion.setVisible(true);
    }

    public void calcularmci(){
       float Imc = (float) (usuario.getPeso()/Math.pow(usuario.getAltura(),2));
       imcPP.setText(String.format("%.2f", Imc));
    }


    public void filtrarButtonPP(){

        this.registroLevantamiento.setUsuario(this.usuario);
        // obtener grupo muscular
        String grmuscul =
                filtrarcomboBoxPP
                        .getSelectedItem()
                        .toString();

        // llamar filtro
        List<RegistroLevantamiento> listReg =
                registroLevantamiento.filtrarGrupoMuscular(grmuscul);

        // mostrar tabla
        mostrartablaPPfiltro(listReg);

    }




    public void mostrarTableRK(List<RegistroLevantamiento> listReg){

        //Datos relacionados a la tabla
        Object[][] filaDatos = new  Object[1][5];
        Object[] nombreColumna = {"Puesto","Usuario","Maquina","Repeticiones","Peso"};

        //asignar el modelo a la tabla
        DefaultTableModel modeloTabla = (DefaultTableModel) (this.table1RK.getModel());
        modeloTabla.setRowCount(0);

        modeloTabla.setColumnIdentifiers(nombreColumna);

        //Fuente para el encabezado de la tabla
        JTableHeader tableHeader=this.table1RK.getTableHeader();
        tableHeader.setBackground(Color.ORANGE);
        tableHeader.setForeground(Color.MAGENTA);
        tableHeader.setFont(new Font("Impact", Font.ITALIC,14));


        int puesto = 1;

        for (RegistroLevantamiento registroLevantamiento1:listReg){
            filaDatos[0][0] = puesto;
            filaDatos[0][1] = registroLevantamiento1.getUsuario().getNombre();
            filaDatos[0][2] =registroLevantamiento1.getEjercicio().getNombreEjercicio();
            filaDatos[0][3] =registroLevantamiento1.getRepeticiones();
            filaDatos[0][4] =registroLevantamiento1.getPesoLevantado();


            modeloTabla.addRow(filaDatos[0]);
            puesto++;
        }


    }
    public void FiltrarButon() {



        //obtener Ejercicio
        String nomEjerccio = filPcomboBox1RK.getSelectedItem().toString();

        //llamar filtro
        List<RegistroLevantamiento> listReg = registroLevantamiento.filtrarEjercicio(nomEjerccio);

        //mostrar tabla
        mostrarTableRK(listReg);

        int puestoUser = 0;

        for (int i = 0; i < listReg.size(); i++) {

            if (listReg.get(i).getUsuario().getId_usuario() == this.usuario.getId_usuario()) {

                puestoUser = i + 1;
                break;
            }
        }


        //mostrar puesto
        puestoRK.setText(String.valueOf(puestoUser));
    }

    public void actualizarRk(){
        FiltrarButon();

    }

    public void DatosUser(){
        PesoAJ.setText(String.valueOf(usuario.getPeso()));
        AltAJ.setText(String.valueOf(usuario.getAltura()));
        Ajustes.setVisible(true);
        pagPrincipal.setVisible(false);
    }

    public void AtrasAj(){
        Ajustes.setVisible(false);
        pagPrincipal.setVisible(true);
    }

    public void ActualizarAJ() {

        try {
            this.usuario.setPeso(Integer.parseInt(PesoAJ.getText()));
            this.usuario.setAltura(Float.parseFloat(AltAJ.getText()));

            if (this.usuario.actualizarRegistroBD()) {
                JOptionPane.showMessageDialog(null, "\nDatos Actualizado correctamente....!!!\n");
            } else {
                JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "\nVerifique las cajas de texto que correspondan a valores numericos....!!!!\n " +
                            "\n Tipo de Error :" + e.getMessage());
        }


    }


}


