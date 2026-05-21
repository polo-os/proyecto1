package modelo_logica;

import Conexion_bd.ConexionBD;

import javax.swing.*;
import java.sql.ClientInfoStatus;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private int id_usuario;
    private String nombre;
    private int edad;
    private float altura;
    private int peso;
    private String password;
    private ConexionBD conexionBD;

    //metodos


    public Usuario() {}

    public Usuario(String nombre, int edad, float altura, int peso, String password, ConexionBD conexionBD) {
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
        this.peso = peso;
        this.password = password;
        this.conexionBD = conexionBD;
    }

    public Usuario(int id_usuario, String nombre, byte edad, float altura, int peso, String password, ConexionBD conexionBD) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
        this.peso = peso;
        this.password = password;
        this.conexionBD = conexionBD;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

        String sql = "INSERT INTO Usuario(nombre,edad,altura,peso,contraseña) VALUES('"+this.nombre+"',"+
                this.edad+", "+this.altura+", "+this.peso+", '"+this.password+"');";

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
    public List<Usuario> consultarRegistroBD(){
        List<Usuario> usuarioList = new ArrayList<>();

        this.conexionBD = new ConexionBD();

        String sql = "SELECT * FROM Usuario; ";

        try{
            ResultSet rs = this.conexionBD.consultaBD(sql);
            Usuario user;

            while(rs.next()){
                user = new Usuario();

                user.setId_usuario(rs.getInt("id_usuario"));
                user.setNombre(rs.getString("nombre"));
                user.setEdad(rs.getByte("edad"));
                user.setAltura(rs.getFloat("altura"));
                user.setPeso(rs.getInt("peso"));
                user.setPassword(rs.getString("contraseña"));
                usuarioList.add(user);

            }
        }
        catch (Exception e){
            System.out.println("Error al Consultar "+
                    "el usuario de la clase usuario.....:"+e+
                    "\nTipo de Error: "+ e.getMessage());
        }
        finally {
            this.conexionBD.cerrarConexion();
        }
        System.out.println("Lista de Usuario :"+usuarioList);
        return usuarioList;
    }

    public boolean actualizarRegistroBD(){
        boolean conf;

        this.conexionBD = new ConexionBD();

        String sql = "UPDATE Usuario SET nombre ='"+this.nombre+"', edad = "+
                this.edad+", altura = "+this.altura+", peso ="+this.peso+", password = "+this.password+";";

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

        String sql = "DELETE FROM Usuario WHERE id = " +
                this.id_usuario + ";";

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

    public boolean inicioSecion(String nombre,String passwordd){
        boolean conf;

        try{

            this.conexionBD = new ConexionBD();

            String sql =
                    "SELECT * FROM Usuario " +
                            "WHERE nombre = ? " +
                            "AND BINARY contraseña = ?";

            PreparedStatement ps =
                    conexionBD.getConnection().prepareStatement(sql);
            ps.setString(1, nombre);

            ps.setString(2, passwordd);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                this.id_usuario = rs.getInt("id_usuario");
                this.nombre = rs.getString("nombre");
                conf = true;
            }
            else {
             conf = false;
            }

        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error al iniciar secion"+
                    "\n Tipo de Error"+e.getMessage());
            conf = false;
        }
        finally{
            this.conexionBD.cerrarConexion();
        }
        return  conf;

    }

}

