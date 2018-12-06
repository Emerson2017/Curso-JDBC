package br.com.caelum.jdbc.teste;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.caelum.jdbc.dao.ContatoDao;

public class TestaConsult {

	public static void main(String[] args) throws SQLException {
		ContatoDao contatoDB = new ContatoDao();
		
		//contatoDB.selectAll();
		contatoDB.SelectOneUser((long)10);


	}

}
