package Interfazz;

import enumm.Ejercicios;
import enumm.GrMuscul;
import modelo_logica.Ejercicio;
import modelo_logica.RegistroLevantamiento;
import modelo_logica.Usuario;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Formulario extends JFrame {
    //Atributos

    private RegistroLevantamiento registroLevantamiento;
    private Ejercicio ejercicio;
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
    private JLabel grMusculJlabelRE;
    private JComboBox grMusculRE;

    //Metodos
    public Formulario() {

        setContentPane(panel1);

        //recibe los valores de la clase enumm
        JComboBox jComboBox = new JComboBox(Ejercicios.values());

        ejercicioRE.setModel(jComboBox.getModel());

        AutoCompleteDecorator.decorate(ejercicioRE);

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
        RegistroPeso.setVisible(true);
    }

    public void inicioBottonin(){
        InicioSesion.setVisible(false);
        paginaPrincipal.setVisible(true);
    }

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


     List<RegistroLevantamiento> listaReg=registroLevantamiento.consultarRegistroBD();

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
        for(int i = 0; i < table1RE.getRowCount(); i++){
            if(table1RE.getValueAt(i,0).toString()
                    .equals(ejercicioRE.getSelectedItem().toString())){
                JOptionPane.showMessageDialog(null,
                        "Ya has insertado ese ejercicio");
                return;
            }
        }

try {
    this.registroLevantamiento.setPesoLevantado(Integer.parseInt(pesoRE.getText()));
    this.registroLevantamiento.setRepeticiones(Integer.parseInt(repeticionesRE.getText()));
    this.ejercicio.setNombreEjercicio(ejercicioRE.getSelectedItem().toString());
    this.ejercicio.setGrupoMuscular(grMusculRE.getSelectedItem().toString());
    this.registroLevantamiento.insertarRegistroBD();
    this.ejercicio.insertarRegistroBD();
    mostrartablaRE();

} catch (Exception e){
    JOptionPane.showMessageDialog(null,"Error al agregar registro \n"+"tipo de error: "+e.getMessage() );
}

}

}

