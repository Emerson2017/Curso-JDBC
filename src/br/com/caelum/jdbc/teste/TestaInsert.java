package br.com.caelum.jdbc.teste;

import java.sql.*;
import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.modelo.*;
import br.com.caelum.jdbc.dao.*;
import java.util.Calendar;
import java.util.Scanner;



public class TestaInsert {
	public static Scanner leia = new Scanner (System.in);
	public static void main(String[] args) {
		Contato contato = new Contato();
		ContatoDao contatoBD = new ContatoDao();
		
		System.out.println("Nome do contato: ");
		String nome = leia.nextLine();
		contato.setNome(nome);
		System.out.println("Email do contato: ");
		String email = leia.nextLine();
		contato.setEmail(email);
		System.out.println("Endereço do contato: ");
		String endereco = leia.nextLine();
		contato.setEndereco(endereco);
		System.out.println("Data de nascimento do contato: " + Calendar.getInstance());
		contato.setdataNascimento(Calendar.getInstance());
		
		if(contatoBD.adciona(contato)) {
			System.out.println("Dados gravados com sucesso !!");
		}
		
	}

}
