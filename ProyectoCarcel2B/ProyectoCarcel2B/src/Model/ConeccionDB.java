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

    //METODOS PARA OBTENER LISTAS DE LA BASE DE DATOS:
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
            this.mensaje = sqlException.getMessage();
        }
        return listaAdministracion;
    }

    //METODOS PARA CONSULTAR EN LA BASE DE DATOS:
    public PPL consultarPPL(String cedula) {
        try {
            setConcDB("jdbc:sqlite:DB/controlCarcelDB.db");
            Statement statement = coneccion.createStatement();
            String strConsultaPPL = String.format("SELECT * FROM PPLdata WHERE Cedula = '%s'", cedula);
            ResultSet resultSet = statement.executeQuery(strConsultaPPL);

            if (resultSet.next()) {
                PPL ppl = new PPL(resultSet.getInt("#PPL"), resultSet.getString("Nombre"),
                        resultSet.getString("Cedula"), resultSet.getInt("Edad"),
                        resultSet.getString("LugarNacimiento"), resultSet.getString("Genero"),
                        resultSet.getString("Alias"), resultSet.getString("Clasificacion"),
                        resultSet.getString("Celda"), resultSet.getString("Pabellon"),
                        resultSet.getString("FechaIngreso"), resultSet.getString("FechaSalida"),
                        resultSet.getInt("Pena"), resultSet.getInt("AniosRestantes"),
                        resultSet.getString("Delito"), resultSet.getInt("Visitas"));
                resultSet.close();
                statement.close();
                return ppl;
            } else {
                resultSet.close();
                statement.close();
                return null;
            }
        } catch (SQLException sqlException) {
            this.mensaje = sqlException.getMessage();
            return null;
        }
    }

    public EmpleadoAdministracion consultarEmpleadoAdministracion(String cedula) {
        try {
            setConcDB("jdbc:sqlite:DB/controlCarcelDB.db");
            Statement statement = coneccion.createStatement();
            String strConsultaEmpleado = String.format("SELECT * FROM AdministracionData WHERE Cedula = '%s'", cedula);
            ResultSet resultSet = statement.executeQuery(strConsultaEmpleado);
            if (resultSet.next()) {
                EmpleadoAdministracion empleado = new EmpleadoAdministracion(
                        resultSet.getInt("#Administracion"),
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
                        resultSet.getString("Genero")
                );
                resultSet.close();
                statement.close();
                return empleado;
            } else {
                resultSet.close();
                statement.close();
                return null;
            }
        } catch (SQLException sqlException) {
            this.mensaje = sqlException.getMessage();
            return null;
        }
    }

    public EmpleadoSeguridad consultarEmpleadoSeguridad(String cedula) {
        try {
            setConcDB("jdbc:sqlite:DB/controlCarcelDB.db");
            Statement statement = coneccion.createStatement();
            String strConsultaEmpleado = String.format("SELECT * FROM SeguridadData WHERE Cedula = '%s'", cedula);
            ResultSet resultSet = statement.executeQuery(strConsultaEmpleado);

            if (resultSet.next()) {
                EmpleadoSeguridad empleado = new EmpleadoSeguridad(
                        resultSet.getInt("#Seguridad"),
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
                        resultSet.getString("Genero")
                );
                resultSet.close();
                statement.close();
                return empleado;
            } else {
                resultSet.close();
                statement.close();
                return null;
            }
        } catch (SQLException sqlException) {
            this.mensaje = sqlException.getMessage();
            return null;
        }
    }

    //METODOS PARA ELIMINAR REGISTROS DE LA BASE DE DATOS:
    public boolean eliminarPPL(String cedula) {
        try {
            setConcDB("jdbc:sqlite:DB/controlCarcelDB.db");
            Statement statement = coneccion.createStatement();
            String strEliminarPPL = String.format("DELETE FROM PPLdata WHERE Cedula = '%s'", cedula);
            int filasAfectadas = statement.executeUpdate(strEliminarPPL);
            statement.close();

            if (filasAfectadas > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException sqlException) {
            this.mensaje = sqlException.getMessage();
            return false;
        }
    }

    public boolean eliminarEmpleadoAdministracion(String cedula) {
        try {
            setConcDB("jdbc:sqlite:DB/controlCarcelDB.db");
            Statement statement = coneccion.createStatement();
            String strEliminarEmpleado = String.format("DELETE FROM AdministracionData WHERE Cedula = '%s'", cedula);
            int filasAfectadas = statement.executeUpdate(strEliminarEmpleado);
            statement.close();
            if (filasAfectadas > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException sqlException) {
            this.mensaje = sqlException.getMessage();
            return false;
        }
    }

    public boolean eliminarEmpleadoSeguridad(String cedula) {
        try {
            setConcDB("jdbc:sqlite:DB/controlCarcelDB.db");
            Statement statement = coneccion.createStatement();
            String strEliminarEmpleado = String.format("DELETE FROM SeguridadData WHERE Cedula = '%s'", cedula);
            int filasAfectadas = statement.executeUpdate(strEliminarEmpleado);
            statement.close();
            if (filasAfectadas > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException sqlException) {
            this.mensaje = sqlException.getMessage();
            System.out.println(this.mensaje);
            return false;
        }
    }

    //METODOS PARA INSERTAR PPL A LA BASE
    public void insertarPPL(PPL ppl) {
        try {
            setConcDB("jdbc:sqlite:DB/controlCarcelDB.db");
            Statement statement = coneccion.createStatement();
            String strInsertEst = String.format("INSERT INTO PPLdata ('#PPL', Nombre, "
                    + "Cedula, Edad, LugarNacimiento, Genero, Alias, Clasificacion, Celda, "
                    + "Pabellon, FechaIngreso, FechaSalida, Pena, AniosRestantes, Delito, Visitas) "
                    + "VALUES (%d, '%s', '%s', %d, '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', %d, %d, '%s', %d)", (int) ppl.numPPL, ppl.nombreCompleto,
                    ppl.cedula, (int) ppl.edad, ppl.lugarNacimiento, ppl.genero,
                    ppl.alias, ppl.clasificacion, ppl.celda, ppl.pabellon,
                    ppl.fechaIngreso, ppl.fechaSalida, (int) ppl.penaAsignada,
                    (int) ppl.aniosRestantes, ppl.delitoCometido, (int) ppl.visitasSemanales);
            statement.executeUpdate(strInsertEst);
            statement.close();
        } catch (SQLException sqlException) {
            this.mensaje = sqlException.getMessage();
        }
    }

    public void insertarEmpleadoAdministracion(EmpleadoAdministracion empleado) {
        try {
            setConcDB("jdbc:sqlite:DB/controlCarcelDB.db");
            Statement statement = coneccion.createStatement();
            String strInsertEmpleado = String.format("INSERT INTO AdministracionData ('#Administracion', NivelAcademico, "
                    + "IdiomasHablados, HabilidadesBlandas, CertificacionesAdicionales, Cargo, HorasTrabajadas, "
                    + "ValorxHora, Contacto, FechaContratacion, AniosTrabajados, Nombre, Cedula, Edad, LugarNacimiento, Genero) "
                    + "VALUES (%d, '%s', '%s', '%s', '%s', '%s', %d, %d, '%s', '%s', %d, '%s', '%s', %d, '%s', '%s')",
                    (int) empleado.numAdministracion, empleado.nivelAcademico, empleado.idiomasHablados,
                    empleado.habilidadesBlandas, empleado.certificadosAdicionales, empleado.cargo,
                    (int) empleado.horasTrabajadas, (int) empleado.valorXHora, empleado.telefonoContacto,
                    empleado.fechaContratacion, (int) empleado.aniosTrabajados, empleado.nombreCompleto,
                    empleado.cedula, (int) empleado.edad, empleado.lugarNacimiento, empleado.genero);
            statement.executeUpdate(strInsertEmpleado);
            statement.close();
        } catch (SQLException sqlException) {
            this.mensaje = sqlException.getMessage();
        }
    }

    public void insertarEmpleadoSeguridad(EmpleadoSeguridad empleado) {
        try {
            setConcDB("jdbc:sqlite:DB/controlCarcelDB.db");
            Statement statement = coneccion.createStatement();
            String strInsertEmpleado = String.format("INSERT INTO SeguridadData ('#Seguridad', Pabellon, TipoArma, "
                    + "NivelEntrenamiento, Limitante, Equipamiento, Cargo, HorasTrabajadas, ValorxHora, Contacto, "
                    + "FechaContratacion, AniosTrabajados, Nombre, Cedula, Edad, LugarNacimiento, Genero) "
                    + "VALUES (%d, '%s', '%s', '%s', '%s', '%s', '%s', %d, %d, '%s', '%s', %d, '%s', '%s', %d, '%s', '%s')",
                    (int) empleado.numSeguridad, empleado.pabellon, empleado.tipoLicenciaArma, empleado.nivelEntrenamiento,
                    empleado.limitanteFisico, empleado.equipoProteccion, empleado.cargo, (int) empleado.horasTrabajadas,
                    (int) empleado.valorXHora, empleado.telefonoContacto, empleado.fechaContratacion,
                    (int) empleado.aniosTrabajados, empleado.nombreCompleto, empleado.cedula,
                    (int) empleado.edad, empleado.lugarNacimiento, empleado.genero);
            statement.executeUpdate(strInsertEmpleado);
            statement.close();
        } catch (SQLException sqlException) {
            this.mensaje = sqlException.getMessage();
        }
    }

}
