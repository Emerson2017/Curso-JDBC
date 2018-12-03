package br.com.caelum.jdbc.teste;

import java.sql.*;
import br.com.caelum.jdbc.ConnectionFactory;

import java.util.Calendar;
import java.util.Scanner;



public class TestaInsert {
	public static Scanner leia = new Scanner (System.in);
	public static void main(String[] args) {
		

		try(Connection conexao = new ConnectionFactory().getConnection()) {
			String sql = "insert into contatos (nome, email, endereco, dataNascimento) "
					+ "values (?,?,?,?)";
			
			PreparedStatement stmt = conexao.prepareStatement(sql);
			
			System.out.println("#################################");
			System.out.println("CADASTRO DE DADOS PESSOAIS");
			System.out.println("Digite seu nome: ");
			String nome = leia.nextLine();
			System.out.println("Digite seu email: ");
			String email = leia.nextLine();
			System.out.println("Digite seu endereço");
			String endereco = leia.nextLine();
			Date nascimento = new java.sql.Date(
	                Calendar.getInstance().getTimeInMillis());
			
			
			
			
			stmt.setString(1, nome);
			stmt.setString(2, email);
			stmt.setString(3, endereco);
			stmt.setDate(4, nascimento);
			
			stmt.execute();
			stmt.close();
			
			System.out.println("Dados gravados com sucesso !!");
			
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

}
