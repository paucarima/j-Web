package com.krakedev.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.krakedev.excepciones.KrakeDevException;

public class ConexionBDD {
	public static Connection obtenerConexion() throws KrakeDevException{
		Context ctx = null;// del apache
		DataSource ds = null;// componente bd
		Connection con = null;

		try {
			ctx = new InitialContext();// clase contexto
			// JDNI, buscar elementos
			ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/ConexionPG");
			con = ds.getConnection();
		} catch (NamingException | SQLException e) {

			e.printStackTrace();
			throw new KrakeDevException("Error de Conexion");
		}
		return con;

	}

}
