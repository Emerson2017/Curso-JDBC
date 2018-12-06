package br.com.caelum.jdbc.dao;
import java.sql.*;
import java.util.Calendar;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.modelo.Contato;

public class ContatoDao {
	
	public ContatoDao(){
		Connection conexao = new ConnectionFactory().getConnection(); 
	}
	
	public boolean adciona(Contato contato) {
		try(Connection conexao = new ConnectionFactory().getConnection()) {
			String sql = "insert into contatos (nome, email, endereco, dataNascimento) "
					+ "values (?,?,?,?)";
			
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getendereco());
			stmt.setDate(4, new Date (contato.getdataNascimento().getTimeInMillis()));
			
			stmt.execute();
			stmt.close();
			
			 return true;
			
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
