package modelo_logica;

import Conexion_bd.ConexionBD;

public class Usuario {
    private int id_usuario;
    private String nombre;
    private byte edad;
    private float altura;
    private int peso;
    private String password;
    private ConexionBD conexionBD;

    //metodos


    public Usuario() {}

    public Usuario(String nombre, byte edad, float altura, int peso, String password, ConexionBD conexionBD) {
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

    public byte getEdad() {
        return edad;
    }

    public void setEdad(byte edad) {
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

        String sql = "INSERT INT usuario(nombre,edad,altura,peso,contraseña) VALUES('"+this.nombre+"',"+
                this.edad+", "+this.altura+", "+this.peso+", "+this.password+");";

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


}

