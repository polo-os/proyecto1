package Conexion_bd;

import javax.swing.*;
import java.sql.*;

public class ConexionBD {

        //Atributos/Propiedades/Caracteristicas
        private String url; //ruta que realiza la conexion con la DB
        private Connection connection;  // objeto que hace la conexion a la BD
        private Statement statement;  //maneja las sentencias sql
        private ResultSet resultSet; // objeto que obtine los resultados de las consultas

        //metodos

        //establese la conecion con la base d datos
        public ConexionBD() {

            // ruta con respecto a la conexion de la bd
            //ruta = jdbd:mysql://la ruta de a base de datos:puerto/nombre_bd
            String hostBD, userBD, pswBD, portDB, nombreDB;
            hostBD = "b0eirh85g07idujxecwy-mysql.services.clever-cloud.com";
            nombreDB = "b0eirh85g07idujxecwy";
            userBD = "urm2wyajnojuwoft";
            pswBD = "se2YNRI7tkxMU60mKOU8";
            portDB = "3306";

            this.url ="jdbc:mysql://" + hostBD + ":"+portDB+"/"+nombreDB;

            try{
                this.connection = DriverManager.getConnection(url,userBD,pswBD);
                if(this.connection != null){
                    DatabaseMetaData metaData = this.connection.getMetaData();
                    System.out.println("conexion exitosa a la base de datos");
                    System.out.println("Meta Daos: "+ metaData.getDriverName());
                }
            }
            catch (Exception e){
                JOptionPane.showMessageDialog(null," Error en la Conexión "+"a a Base de Dato"+
                        "Tipo de Error: " + e.getMessage());

                System.out.println("\n Error en la Conexión "+"a la Base de Dato"+
                        "\n Tipo de Error: " + e.getMessage());
            }

        }

        public Connection getConnection() {
            return connection;
        }

        //CRUD - Create = insertar registros a la BD
        public boolean insertarBD(String sentenciaSQL){
            boolean conf;

            try {
                //estas 2 lineas son las mas importantes en la sentencia de Sql
                //objeto que gestiona las sentencias sql
                this.statement = this.connection.createStatement();
                this.statement.execute(sentenciaSQL);
                conf = true;

            }
            catch (Exception e){
                conf = false;
                JOptionPane.showMessageDialog(null,"\n Error al Insertar Datos "+"en la Base de Dato"+
                        "\n Tipo de Error: " + e.getMessage());

                System.out.println("\n Error al Insertar Datos "+"en la Base de Dato"+
                        "\n Tipo de Error: " + e.getMessage());
            }
            return conf;
        }

        //CRUD Read = leer o agregar registros a la BD
        public ResultSet consultaBD(String sentenciaSQL){

            try {
                //cambia la segunda linea
                //objeto que gestiona las sentencias sql
                this.statement = this.connection.createStatement(); //crear el gestor de sentencias
                resultSet = this.statement.executeQuery(sentenciaSQL);


            }
            catch (Exception e){

                JOptionPane.showMessageDialog(null,"\n Error al Consultar Datos "+"en la Base de Dato"+
                        "\n Tipo de Error: " + e.getMessage());

                System.out.println("\n Error al Consultar Datos "+"en la Base de Dato"+
                        "\n Tipo de Error: " + e.getMessage());
            }
            return resultSet;
        }

        //CRUD Update = actualizar o modificar registro de la BD

        public boolean actualizarBD(String sentenciaSQL){
            boolean conf;

            try {
                //objeto que gestiona las sentencias sql
                this.statement = this.connection.createStatement();
                this.statement.execute(sentenciaSQL);
                conf = true;

            }
            catch (Exception e){
                conf = false;

                System.out.println("\n Error al Actualizar Datos "+"en la Base de Dato"+
                        "\n Tipo de Error: " + e.getMessage());

                JOptionPane.showMessageDialog(null,"\n Error al Actualizar Datos "+"en la Base de Dato"+
                        "\n Tipo de Error: " + e.getMessage());


            }
            return conf;

        }

        //CRUD DELETE = borrar o eliminar registros de la BD
        public boolean borrarBD(String sentenciaSQL){
            boolean conf;

            try {
                //objeto que gestiona las sentencias sql
                this.statement = this.connection.createStatement();
                this.statement.execute(sentenciaSQL);
                conf = true;

            }
            catch (Exception e){

                System.out.println("\n Error al Eliminar Datos "+"en la Base de Dato"+
                        "\n Tipo de Error: " + e.getMessage());

                JOptionPane.showMessageDialog(null,"\n Error al Eliminar Datos "+"en la Base de Dato"+
                        "\n Tipo de Error: " + e.getMessage());
                conf = false;
            }
            return conf;
        }

        //Funcion para confirmar o negar el autoGuardado de las sentencias ejecutadas en la BD
        // las variables de tipo bandera es boolean

        public boolean setAutoCommitBD(boolean bandera){
            boolean conf;

            try {
                //objeto que gestiona las sentencias sql
                this.connection.setAutoCommit(bandera);
                conf = true;

            }
            catch (Exception e){
                conf = false;

                System.out.println("\n Error al AutoGuardado "+"en la Base de Dato"+
                        "\n Tipo de Error: " + e.getMessage());

                JOptionPane.showMessageDialog(null,"\n Error al AutoGuardado "+"en la Base de Dato"+
                        "\n Tipo de Error: " + e.getMessage());


            }
            return conf;
        }

        //Confirmar el Guardado de la Ejecucion de una Sentencia en la BD
        public boolean commitBD(){
            boolean conf;

            try {
                //objeto que gestiona las sentencias sql
                this.connection.commit();
                conf = true;

            }
            catch (Exception e){
                conf = false;
                System.out.println("\n Error al commit "+"en la Base de Dato"+
                        "\n Tipo de Error: " + e.getMessage());

                JOptionPane.showMessageDialog(null,"\n Error al commit "+"en la Base de Dato"+
                        "\n Tipo de Error: " + e.getMessage());


            }
            return conf;

        }

        //Cerrar la Conexion de la BD Desde un Objeto de la Clase Connection

        public void closeConnetion(Connection connection){

            if (connection != null){
                try {
                    connection.close();
                    System.out.println("Conexion a la BD Cerrada...");
                }
                catch (Exception e){

                    System.out.println("\n Error al Cerrar la Connecion "+"en la Base de Dato"+
                            "\n Tipo de Error: " + e.getMessage());

                    JOptionPane.showMessageDialog(null,"\n Error al Cerrar la Conexion "+"en la Base de Dato"+
                            "\n Tipo de Error: " + e.getMessage());


                }
            }
        }

        //Cierra la Conexion a la BD
        public void cerrarConexion(){
            this.closeConnetion(this.connection);
        }

        // Cancelar la Ejecucion de una Sentencia en la BD
        public boolean rollbackBD(){
            boolean conf;

            try {
                // Cancelar Sentencia
                this.connection.rollback();
                conf = true;

            }
            catch (Exception e){
                conf = false;

                System.out.println("\n Error en el Rollback"+"en la Base de Dato"+
                        "\n Tipo de Error: " + e.getMessage());

                JOptionPane.showMessageDialog(null,"\n Error en el Rollback "+"en la Base de Dato"+
                        "\n Tipo de Error: " + e.getMessage());


            }
            return conf;

        }
}
