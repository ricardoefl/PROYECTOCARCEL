package Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConeccionDB {
    public Connection coneccion;
    public ArrayList<PPL> listaPPL;
    public ArrayList<EmpleadoSeguridad> listaSeguridad;
    public ArrayList<EmpleadoAdministracion> listaAdministracion;
    public String mensaje;
    
    public void setConcDB(String url) {
        try {
            this.coneccion = DriverManager.getConnection(url);
        } catch (SQLException sqlException) {
            this.mensaje = sqlException.getMessage();
        }
    }
    public ArrayList<PPL> getListaPPL() {
        listaPPL = new ArrayList<PPL>();
        try { 
            setConcDB("jdbc:sqlite:DB/controlCarcelDB.db");
            Statement statement = coneccion.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from PPLdata");
            while (resultSet.next()) { 
                listaPPL.add(new PPL(resultSet.getInt("#PPL"),
                                                  resultSet.getString("Nombre"),
                                                  resultSet.getString("Cedula"),
                                                  resultSet.getInt("Edad"),
                                                  resultSet.getString("LugarNacimiento"), 
                                                  resultSet.getString("Genero"), 
                                                  resultSet.getString("Alias"), 
                                                  resultSet.getString("Clasificacion"), 
                                                  resultSet.getString("Celda"), 
                                                  resultSet.getString("Pabellon"), 
                                                  resultSet.getString("FechaIngreso"), 
                                                  resultSet.getString("FechaSalida"), 
                                                  resultSet.getInt("Pena"), 
                                                  resultSet.getInt("AniosRestantes"), 
                                                  resultSet.getString("Delito"), 
                                                  resultSet.getInt("Visitas")));
            }
            statement.close();
        } catch (SQLException sqlException) {
            this.mensaje = sqlException.getMessage();
        }
        return listaPPL;
    }
    public ArrayList<EmpleadoSeguridad> getListaEmpleadosSeguridad() {
        listaSeguridad = new ArrayList<EmpleadoSeguridad>();
        try { 
            setConcDB("jdbc:sqlite:DB/controlCarcelDB.db");
            Statement statement = coneccion.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from SeguridadData");
            while (resultSet.next()) { 
                listaSeguridad.add(new EmpleadoSeguridad(resultSet.getInt("#Seguridad"),
                        resultSet.getString("Pabellon"), 
                        resultSet.getString("TipoArma"), 
                        resultSet.getString("NivelEntrenamiento"), 
                        resultSet.getString("Limitante"), 
                        resultSet.getString("Equipamiento"), 
                        resultSet.getString("Cargo"), 
                        resultSet.getInt("HorasTrabajadas"), 
                        resultSet.getInt("ValorxHora"), 
                        resultSet.getString("Contacto"), 
                        resultSet.getString("FechaContratacion"), 
                        resultSet.getInt("AniosTrabajados"), 
                        resultSet.getString("Nombre"), 
                        resultSet.getString("Cedula"), 
                        resultSet.getInt("Edad"), 
                        resultSet.getString("LugarNacimiento"), 
                        resultSet.getString("Genero")));
            }
            statement.close();
        } catch (SQLException sqlException) {
            this.mensaje = sqlException.getMessage();
        }
        return listaSeguridad;
    }
    public ArrayList<EmpleadoAdministracion> getListaEmpleadosAdministracion() {
        listaAdministracion = new ArrayList<EmpleadoAdministracion>();
        try { 
            setConcDB("jdbc:sqlite:DB/controlCarcelDB.db");
            Statement statement = coneccion.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from AdministracionData");
            while (resultSet.next()) { 
                listaAdministracion.add(new EmpleadoAdministracion(resultSet.getInt("#Administracion"), 
                        resultSet.getString("NivelAcademico"), 
                        resultSet.getString("IdiomasHablados"), 
                        resultSet.getString("HabilidadesBlandas"), 
                        resultSet.getString("CertificacionesAdicionales"), 
                        resultSet.getString("Cargo"), 
                        resultSet.getInt("HorasTrabajadas"), 
                        resultSet.getInt("ValorxHora"), 
                        resultSet.getString("Contacto"), 
                        resultSet.getString("FechaContratacion"), 
                        resultSet.getInt("AniosTrabajados"), 
                        resultSet.getString("Nombre"), 
                        resultSet.getString("Cedula"), 
                        resultSet.getInt("Edad"), 
                        resultSet.getString("LugarNacimiento"), 
                        resultSet.getString("Genero")));
            }
            statement.close();
        } catch (SQLException sqlException) {
            System.out.println("ERRORRRR");
            this.mensaje = sqlException.getMessage();
        }
        return listaAdministracion;
    }
    /*
    public void insertarEstudiante(Persona persona) {
        try {
            setConcDB("jdbc:sqlite:DB/gestionCarcelaria.db");
            Statement statement = coneccion.createStatement();
            String strInsertEst = String.format("insert into Estudiante(nombreEst, nota1, nota2, promedio, estado) "
                                               + "values('%s', %d, %d, %d, '%s')", estudiante.nombreEst, (int) estudiante.nota1,
                                                    (int) estudiante.nota2, (int) estudiante.promedio,estudiante.estado);
            statement.executeUpdate(strInsertEst);
            statement.close();
        } catch (SQLException sqlException) {
            this.mensaje = sqlException.getMessage();
        }
    }*/
}