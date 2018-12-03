package br.com.caelum.jdbc.teste;

import java.sql.Connection;
import br.com.caelum.jdbc.ConnectionFactory;

public class TestaConexao {
	public static void main(String args[]) {
		try {
			Connection conexao = new ConnectionFactory().getConnection();
			System.out.println("Conexão aberta !!");
			conexao.close();
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

}
