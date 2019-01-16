package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.modelo.Cliente;

public class ClienteDao {

	private Connection con;	
	
	public ClienteDao() {
		this.con = new ConnectionFactory().pegarConnection();
	}
	
	
	public void adiciona(Cliente cliente) {

		String sql = "INSERT INTO cliente (nome, cpf, vip) value (?,?,?)";
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getCpf());
			stmt.setBoolean(3, cliente.getVip());
			stmt.execute();
			System.out.println("Cliente cadastrado com sucesso!");
		}catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}finally {
			try {
				stmt.close();
			}catch (Exception erro) {
				System.out.println("não foi possível finalizar a PreparedStatement: "+ erro.getMessage());
			}
		}
	}
	
	
	
	
	
	
}
