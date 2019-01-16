package br.com.caelum.jdbc;

import java.sql.DriverManager;
import java.sql.Connection;

public class ConnectionFactory{
	public Connection pegarConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost/fj21", "root", "1q2w3e4r");
		}catch (Exception erro) {
			throw new RuntimeException(erro.getMessage());
		}
	}
}