package br.com.caelum.jdbc.teste;

import java.util.Scanner;

import br.com.caelum.jdbc.dao.ClienteDao;
import br.com.caelum.jdbc.modelo.Cliente;



public class TestaInsertCliente {
	static Scanner leia = new Scanner(System.in);
	public static void main(String args[]) {
		Cliente cliente = new Cliente();
		ClienteDao clientedao = new ClienteDao();
		
		System.out.println("Nome do cliente: ");
		String nome = leia.nextLine();
		
		System.out.println("CPF do cliente: ");
		String cpf = leia.nextLine();
		
		System.out.println("O cliente é VIP ?");
		String vip = leia.nextLine();
		
		
		cliente.setNome(nome);
		cliente.setCpf(cpf);
		
		if(vip.equals("sim")) {
			cliente.setVip(true);
		}else {
			cliente.setVip(false);
		}
		
		clientedao.adiciona(cliente);
	
	}
}
