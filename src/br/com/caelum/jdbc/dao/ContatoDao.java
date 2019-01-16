package br.com.caelum.jdbc.dao;

import java.sql.*;
import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.modelo.Contato;



public class ContatoDao {
	
	private Connection conexao;
	
	
	public ContatoDao(){
		 this.conexao = new ConnectionFactory().pegarConnection(); 
	}
	
	public boolean adciona(Contato contato) {
		try {
			String sql = "insert into contatos (nome, email, endereco, dataNascimento) "
					+ "values (?,?,?,?)";
			
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getendereco());
			stmt.setDate(4, new Date (contato.getdataNascimento().getTimeInMillis()));
			
			stmt.execute();
			stmt.close();
			
			System.out.println("Registro cadastrado com sucesso!");
			System.out.println("Conexao fechada");
			
			return true;
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void selectAll() {
		String sql = "Select * from  contatos";
		PreparedStatement stmt = null;
		ResultSet select = null;
		
		try {
			stmt = conexao.prepareStatement(sql);
			if(stmt == null) {
				System.out.println("Nenhm registo encontrado !");
				return;
			}
			select = stmt.executeQuery();
			
			while(select.next()) {
				Long id = select.getLong("id");
				String nome = select.getString("nome");
				String email = select.getString("email");
				String endereco = select.getString("endereco");

				System.out.println("id do contato: " +id);
				System.out.println("Nome do contato: " +nome);
				System.out.println("Email do contato: " +email);
				System.out.println("Endere�o do contato: " +endereco);
				System.out.println("########################################################");
			}
		}catch (Exception e){
			throw new RuntimeException(e);
		}finally {
			try {
			stmt.close();
			select.close();
			conexao.close();
			}catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	
	public void SelectOneUser(Long id) {
		String sql = "Select * from contatos where id = " + id;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conexao.prepareStatement(sql);
			if(stmt == null) {
				System.out.println("Nenhm registo encontrado !");
				return;
			}	
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				String nome = rs.getString("nome");
				String email = rs.getString("email");
				String endereco = rs.getString("endereco");
				
				System.out.println("Nome do contato: " +nome);
				System.out.println("Email do contato: " +email);
				System.out.println("Endere�o do contato: " +endereco);
				System.out.println("########################################################");
				
			}
		}catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			try {
				stmt.close();
				rs.close();
				conexao.close();
			}catch (Exception e) {
				throw new RuntimeException(e);
			}

		}
	}
}
