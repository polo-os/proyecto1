package Interfazz;

import enumm.Ejercicios;
import enumm.GrMuscul;
import modelo_logica.Ejercicio;
import modelo_logica.RegistroLevantamiento;
import modelo_logica.SesionEntrenamiento;
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
    private SesionEntrenamiento sesionEntr;

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
    private JButton EliminarButtonSE;
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
    private JTextField edadAJ;
    private JTextField UserAJ;
    private JTextField PasswordAJ;
    private JLabel UserLabelAJ;
    private JLabel edadLabelAJ;
    private JLabel PasswordLabelAJ;
    private JButton borrarCuentaButtonAJ;
    private JPanel Ejercicio;
    private JTable table1SE;
    private JButton actualizarButtonSE;
    private JButton agregarButtonSE;
    private JButton seleccionarButtonSE;
    private JTextField FechaSE;
    private JTextField DuracionSE;
    private JTextArea textArea1SE;
    private JLabel sesionesDeEntrenamientoLabelSE;
    private JLabel fechaLabelSE;
    private JLabel totalSesionesLabelSE;
    private JLabel mesLabelSE;
    private JLabel mesSE;
    private JLabel promedioLabelSE;
    private JLabel promedioSE;
    private JLabel nuevaSesionLabelSE;
    private JLabel duracionMinutosLabelSE;
    private JLabel notasLabelSE;
    private JLabel SesionSE;


    //Metodos
    public Formulario() {

        setContentPane(panel1);

        this.usuario = new Usuario();
        this.registroLevantamiento = new RegistroLevantamiento();
        this.ejercicio = new Ejercicio();
        this.sesionEntr = new SesionEntrenamiento();


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
                mostrartablaRE();
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
        borrarCuentaButtonAJ.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BorrarCuentaAJ();
            }
        });

        agregarButtonSE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarSesionSE();
            }
        });
        seleccionarButtonSE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seleccionarSesionSE();
            }
        });
        actualizarButtonSE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarSesionSE();
            }
        });
        EliminarButtonSE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarSesionSE();
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

        if (usuario.inicioSesion(userin.getText(),passwordin.getText())){
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

                // Verificar si el nombre ya existe ANTES de intentar insertar
                if (this.usuario.busUser()) {
                    JOptionPane.showMessageDialog(null,
                            "El nombre de usuario '" + userRU.getText() +
                                    "' ya está en uso.\nPor favor elige otro nombre.");
                    return; // detiene el registro
                }
                if (this.usuario.insertarBD()) {

                    // iniciar sesión automáticamente
                    this.usuario.inicioSesion(
                            userRU.getText(),
                            passwordRU.getText()

                    );

                    RegistroPeso.setVisible(true);
                    RegistroRU.setVisible(false);
                    UserPP.setText(userRU.getText());
                    userin.setText("");
                    passwordin.setText("");
                    pesoRE.setText("");
                    repeticionesRE.setText("");

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
        userin.setText("");
        passwordin.setText("");
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
        JTableHeader tableHeader=this.table2PP.getTableHeader();
        tableHeader.setBackground(Color.ORANGE);
        tableHeader.setForeground(Color.MAGENTA);
        tableHeader.setFont(new Font("Impact", Font.ITALIC,14));


        List<RegistroLevantamiento> listaReg=registroLevantamiento.consultarBD(this.usuario.getId_usuario());

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


        List<RegistroLevantamiento> listaReg=registroLevantamiento.consultarBD(this.usuario.getId_usuario());

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
          agregarButtonRE.setEnabled(false);



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

                this.ejercicio.insertarBD();

                this.ejercicio.busEjercico();
            }

            //conectar con Usuario y ejercicio
            this.registroLevantamiento.setUsuario(this.usuario);
            this.registroLevantamiento.setEjercicio(this.ejercicio);

            //agregar el registro

            if(this.registroLevantamiento.busRegistro()){
                JOptionPane.showMessageDialog(null,
                        "Ya tienes registrado " +
                                this.ejercicio.getNombreEjercicio() +
                                " con grupo muscular " +
                                this.ejercicio.getGrupoMuscular());
            }
            else{
                if(this.registroLevantamiento.insertarBD()){
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


    public void actualizarButtonRE() {

            try {
                // Obtener fila seleccionada
                int filaSelect = table1RE.getSelectedRow();

                if (filaSelect == -1) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Seleccione un registro"
                    );
                    return;
                }

                // Obtener id de la tabla
                int idRegistro = Integer.parseInt(table1RE.getValueAt(filaSelect, 0).toString());

                String nombreNuevo  = ejercicioRE.getSelectedItem().toString();
                String grupoNuevo   = grMusculRE.getSelectedItem().toString();

                this.ejercicio = new Ejercicio();
                this.ejercicio.setNombreEjercicio(nombreNuevo);
                this.ejercicio.setGrupoMuscular(grupoNuevo);

                // Buscar si ese ejercicio+grupo ya existe en BD
                // Si no existe, crearlo
                if (!this.ejercicio.busEjercico()) {
                    this.ejercicio.insertarBD();
                    this.ejercicio.busEjercico(); // cargar el id recién creado
                }

                // Asignar datos nuevos
                this.registroLevantamiento.setIdRegistro(idRegistro);
                this.registroLevantamiento.setEjercicio(this.ejercicio);
                this.registroLevantamiento.setPesoLevantado(Integer.parseInt(pesoRE.getText()));
                this.registroLevantamiento.setRepeticiones(Integer.parseInt(repeticionesRE.getText()));

                // Actualizar BD
                if (this.registroLevantamiento.actualizarBD()) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Registro actualizado correctamente"
                    );
                    mostrartablaRE();
                    actualizarButtonRE.setEnabled(false);
                    eliminarButtonRE.setEnabled(true);
                    agregarButtonRE.setEnabled(true);

                } else {
                    JOptionPane.showMessageDialog(
                            null,
                            "Error al actualizar"
                    );
                }
            } catch (Exception e) {

                JOptionPane.showMessageDialog(
                        null,
                        "Error:\n" + e.getMessage()
                );
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
            if (this.registroLevantamiento.borrarBD()) {
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
        String grmuscul = filtrarcomboBoxPP.getSelectedItem().toString();

        // llamar filtro
        List<RegistroLevantamiento> listReg = registroLevantamiento.filtrarGrupoMuscular(grmuscul);

        // mostrar tabla
        mostrartablaPPfiltro(listReg);

    }




    public void mostrarTableRK(List<RegistroLevantamiento> listReg) {

        List<Usuario> listaUsuarios = this.usuario.consultarBD();

        Object[] nombreColumna = {"Puesto", "Usuario", "Edad", "Maquina", "Repeticiones", "Peso"};

        DefaultTableModel modeloTabla = (DefaultTableModel)(this.table1RK.getModel());
        modeloTabla.setRowCount(0);
        modeloTabla.setColumnIdentifiers(nombreColumna);

        JTableHeader tableHeader = this.table1RK.getTableHeader();
        tableHeader.setBackground(Color.ORANGE);
        tableHeader.setForeground(Color.MAGENTA);
        tableHeader.setFont(new Font("Impact", Font.ITALIC, 14));

        int puesto = 1;

        // el nombre de la variable del for ahora es reg
        // y dentro usamos reg, no registroLevantamiento
        for (RegistroLevantamiento reg : listReg) {

            if (reg.getUsuario() == null) continue;

            String edadUsuario = "—";
            for (Usuario u : listaUsuarios) {
                // reg.getUsuario() en lugar de registroLevantamiento.getUsuario()
                if (u.getId_usuario() == reg.getUsuario().getId_usuario()) {
                    edadUsuario = String.valueOf(u.getEdad());
                    break;
                }
            }

            modeloTabla.addRow(new Object[]{
                    puesto,
                    reg.getUsuario().getNombre(),   // reg, no registroLevantamiento
                    edadUsuario,
                    reg.getEjercicio().getNombreEjercicio(),
                    reg.getRepeticiones(),
                    reg.getPesoLevantado()
            });
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

    //Mostrar en ajustes
    public void DatosUser(){
        PesoAJ.setText(String.valueOf(usuario.getPeso()));
        AltAJ.setText(String.valueOf(usuario.getAltura()));
        UserAJ.setText(String.valueOf(usuario.getNombre()));
        edadAJ.setText(String.valueOf(usuario.getEdad()));
        PasswordAJ.setText(usuario.getPassword());
        Ajustes.setVisible(true);
        pagPrincipal.setVisible(false);
    }

    public void AtrasAj(){
        Ajustes.setVisible(false);
        pagPrincipal.setVisible(true);
        UserPP.setText(UserAJ.getText());
    }

    public void ActualizarAJ() {

        try {
            this.usuario.setPeso(Integer.parseInt(PesoAJ.getText()));
            this.usuario.setAltura(Float.parseFloat(AltAJ.getText()));
            this.usuario.setNombre(UserAJ.getText());
            this.usuario.setEdad(Integer.parseInt(edadAJ.getText()));
            this.usuario.setPassword(PasswordAJ.getText());

            if (this.usuario.actualizarBD()) {
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

    public void BorrarCuentaAJ(){

        int id = this.usuario.getId_usuario();

        boolean conf = JOptionPane.showConfirmDialog(
                null,
                "¿Está seguro que quiere eliminar el usuario?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;

        if(conf) {
            this.usuario.setId_usuario(id);
            if (this.usuario.borrarBD()) {
                JOptionPane.showMessageDialog(
                        null,
                        "Usuario eliminado correctamente"
                );
                InicioSesion.setVisible(true);
                Ajustes.setVisible(false);

            } else {

                JOptionPane.showMessageDialog(
                        null,
                        "Error al eliminar"
                );
            }
        }
    }

    public void mostrarTablaSE() {
        Object[] columnas = {"id", "Fecha", "Duración (min)", "Notas"};
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(columnas);

        // Aquí va el nombre exacto de tu JTable del JScrollPane
        // Revisa el diseñador y ponle field name: tablaSE
        table1SE.setModel(modelo);

        // Ocultar columna id
        table1SE.getColumnModel().getColumn(0).setMinWidth(0);
        table1SE.getColumnModel().getColumn(0).setMaxWidth(0);
        table1SE.getColumnModel().getColumn(0).setPreferredWidth(0);

        // Colores del header igual que el resto de tu app
        JTableHeader header = table1SE.getTableHeader();
        header.setBackground(Color.ORANGE);
        header.setForeground(Color.MAGENTA);
        header.setFont(new Font("Impact", Font.ITALIC, 14));

        // Consultar BD
        List<SesionEntrenamiento> lista =
                sesionEntr.consultarBD(this.usuario.getId_usuario());

        for (SesionEntrenamiento s : lista) {
            modelo.addRow(new Object[]{
                    s.getIdSesion(),
                    s.getFecha(),
                    s.getDuracionMin(),
                    s.getNotas()
            });
        }
    }

    public void agregarSesionSE() {
        try {
            sesionEntr = new SesionEntrenamiento();
            sesionEntr.setFecha(FechaSE.getText()); // nombre de tu JTextField fecha
            sesionEntr.setDuracionMin(Integer.parseInt(DuracionSE.getText())); // JTextField duracion
            sesionEntr.setNotas(textArea1SE.getText());
            sesionEntr.setUsuario(this.usuario);

            if (sesionEntr.insertarBD()) {
                JOptionPane.showMessageDialog(null, "Sesión agregada correctamente");
                mostrarTablaSE();
                limpiarCamposSE();
            } else {
                JOptionPane.showMessageDialog(null, "Error al agregar la sesión");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Error al agregar sesión\nTipo de error: " + e.getMessage());
        }
    }

    public void seleccionarSesionSE() {
        int fila = table1SE.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un registro de la tabla");
            return;
        }

        DefaultTableModel modelo = (DefaultTableModel) table1SE.getModel();

        FechaSE.setText(modelo.getValueAt(fila, 1).toString());
        DuracionSE.setText(modelo.getValueAt(fila, 2).toString());
        textArea1SE.setText(modelo.getValueAt(fila, 3).toString());

        // Habilitar actualizar y eliminar, deshabilitar agregar
        actualizarButtonSE.setEnabled(true);
        EliminarButtonSE.setEnabled(true);
        agregarButtonSE.setEnabled(false);
    }

    public void actualizarSesionSE() {
        int fila = table1SE.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un registro");
            return;
        }

        try {
            DefaultTableModel modelo = (DefaultTableModel) table1SE.getModel();
            int idSesion = Integer.parseInt(modelo.getValueAt(fila, 0).toString());

            sesionEntr.setIdSesion(idSesion);
            sesionEntr.setFecha(FechaSE.getText());
            sesionEntr.setDuracionMin(Integer.parseInt(DuracionSE.getText()));
            sesionEntr.setNotas(textArea1SE.getText());

            if (sesionEntr.actualizarBD()) {
                JOptionPane.showMessageDialog(null, "Sesión actualizada correctamente");
                mostrarTablaSE();
                limpiarCamposSE();
                actualizarButtonSE.setEnabled(false);
                EliminarButtonSE.setEnabled(false);
                agregarButtonSE.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Error:\n" + e.getMessage());
        }
    }

    public void eliminarSesionSE() {
        int fila = table1SE.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un registro");
            return;
        }

        boolean conf = JOptionPane.showConfirmDialog(
                null,
                "¿Está seguro que quiere eliminar esta sesión?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;

        if (conf) {
            DefaultTableModel modelo = (DefaultTableModel) table1SE.getModel();
            int idSesion = Integer.parseInt(modelo.getValueAt(fila, 0).toString());

            sesionEntr.setIdSesion(idSesion);

            if (sesionEntr.borrarBD()) {
                JOptionPane.showMessageDialog(null, "Sesión eliminada correctamente");
                mostrarTablaSE();
                limpiarCamposSE();
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar");
            }
        }
    }

    public void limpiarCamposSE() {
        FechaSE.setText("");
        DuracionSE.setText("");
        textArea1SE.setText("");
        actualizarButtonSE.setEnabled(false);
        EliminarButtonSE.setEnabled(false);
        agregarButtonSE.setEnabled(true);
    }

}


