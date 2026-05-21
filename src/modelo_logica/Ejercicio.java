package modelo_logica;

import Conexion_bd.ConexionBD;

import javax.swing.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio {

    private int idEjercicio;
    private String nombreEjercicio,grupoMuscular;
    private ConexionBD conexionBD;

    //Metodos

    public Ejercicio() {}

    public Ejercicio(String nombreEjercicio, String grupoMuscular, ConexionBD conexionBD) {
        this.nombreEjercicio = nombreEjercicio;
        this.grupoMuscular = grupoMuscular;
        this.conexionBD = conexionBD;
    }

    public Ejercicio(int idEjercicio, String nombreEjercicio, String grupoMuscular, ConexionBD conexionBD) {
        this.idEjercicio = idEjercicio;
        this.nombreEjercicio = nombreEjercicio;
        this.grupoMuscular = grupoMuscular;
        this.conexionBD = conexionBD;
    }

    public int getIdEjercicio() {
        return idEjercicio;
    }

    public void setIdEjercicio(int idEjercicio) {
        this.idEjercicio = idEjercicio;
    }

    public String getNombreEjercicio() {
        return nombreEjercicio;
    }

    public void setNombreEjercicio(String nombreEjercicio) {
        this.nombreEjercicio = nombreEjercicio;
    }

    public String getGrupoMuscular() {
        return grupoMuscular;
    }

    public void setGrupoMuscular(String grupoMuscular) {
        this.grupoMuscular = grupoMuscular;
    }

    public ConexionBD getConexionBD() {
        return conexionBD;
    }

    public void setConexionBD(ConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    //CRUD Create
    public boolean insertarRegistroBD(){
        boolean conf;

        this.conexionBD = new ConexionBD();

        String sql = "INSERT INTO Ejercicio(nombre_ejercicio,grupo_muscular) VALUES('"+this.nombreEjercicio+"','"+
                this.grupoMuscular+"');";
        if(this.conexionBD.setAutoCommitBD(false)){
            if(this.conexionBD.insertarBD(sql)){
                this.conexionBD.commitBD();
                this.conexionBD.cerrarConexion();
                conf = true;
            }
            else {
                this.conexionBD.rollbackBD();
                this.conexionBD.cerrarConexion();
                conf = false;
            }
        }
        else {
            this.conexionBD.cerrarConexion();
            conf = false;
        }
        return conf;

    }

    //CRUD READ
    public List<Ejercicio> consultarRegistroBD(){
        List<Ejercicio> ejercicioList =new ArrayList<>();

        this.conexionBD = new ConexionBD();

        String sql = "SELECT * FROM Ejercicio; ";

        try{
            ResultSet rs = this.conexionBD.consultaBD(sql);
            Ejercicio ejer;

            while(rs.next()){
                ejer = new Ejercicio();

                ejer.setIdEjercicio(rs.getInt("id_ejercicio"));
                ejer.setNombreEjercicio(rs.getString("nombre_ejercicio"));
                ejer.setGrupoMuscular(rs.getString("grupo_muscular"));
                ejercicioList.add(ejer);

            }
        }
        catch (Exception e){
            System.out.println("Error al Consultar "+
                    "Ejercicios de la clase Ejercico.....:"+e+
                    "\nTipo de Error: "+ e.getMessage());
        }
        finally {
            this.conexionBD.cerrarConexion();
        }
        System.out.println("Lista de Ejercicio :"+ejercicioList);
        return ejercicioList;
    }

    public boolean actualizarRegistroBD(){
        boolean conf;

        this.conexionBD = new ConexionBD();

        String sql = "UPDATE Ejercicio SET nombre_ejercicio ='"+this.nombreEjercicio+"', grupo_muscular = '"+
                this.grupoMuscular+";";

        if(this.conexionBD.setAutoCommitBD(false)){
            if(this.conexionBD.insertarBD(sql)){
                this.conexionBD.commitBD();
                this.conexionBD.cerrarConexion();
                conf = true;
            }
            else {
                this.conexionBD.rollbackBD();
                this.conexionBD.cerrarConexion();
                conf = false;
            }
        }
        else {
            this.conexionBD.cerrarConexion();
            conf = false;
        }
        return conf;

    }

    public boolean borrarRegistroBD() {
        boolean conf;

        this.conexionBD = new ConexionBD();

        String sql = "DELETE FROM Ejercicio WHERE id_ejercicio= " +
                this.idEjercicio + ";";

        if(this.conexionBD.setAutoCommitBD(false)){
            if(this.conexionBD.insertarBD(sql)){
                this.conexionBD.commitBD();
                this.conexionBD.cerrarConexion();
                conf = true;
            }
            else {
                this.conexionBD.rollbackBD();
                this.conexionBD.cerrarConexion();
                conf = false;
            }
        }
        else {
            this.conexionBD.cerrarConexion();
            conf = false;
        }
        return conf;

    }

    public boolean busEjercico(){

        boolean ent = false;

        this.conexionBD = new ConexionBD();

        String sql = "SELECT * FROM Ejercicio "+
                "Where nombre_ejercicio = '"+this.nombreEjercicio+"';";


        try{
            ResultSet rs = this.conexionBD.consultaBD(sql);

            if(rs.next()){
                this.idEjercicio = rs.getInt("id_ejercicio");
                this.nombreEjercicio = rs.getString("nombre_ejercicio");
                this.grupoMuscular = rs.getString("grupo_muscular");
                ent = true;
            }
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error al buscar ejercicio\n"+
                    "Tipo de Error:\n" + e.getMessage());
        }
        finally {
            this.conexionBD.cerrarConexion();
        }
        return ent;
    }
}

