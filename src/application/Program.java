package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class Program {

	public static void main(String[] args) {
		// Abrir o banco
		Connection conn = null;
		// preparar uma consulta
		Statement st = null;
		// Resultado da consulta quarda na variavel rs
		ResultSet rs = null;

		try {
			conn = DB.getConnection();
			st = conn.createStatement();

			rs = st.executeQuery("select * from department");
			// enquanto existir um proximo
			while (rs.next()) {
				// Nome da coluna com o valor atribuido de acordo com o banco de dados
				System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
			}

		} catch (SQLException e) {

			e.printStackTrace();
			// TODO: handle exception
		}

		finally {
			DB.closeResult(rs);
			DB.closeStatement(st);
			DB.closeConnection();
		}

	}

}
