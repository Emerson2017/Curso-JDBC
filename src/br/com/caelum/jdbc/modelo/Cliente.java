package br.com.caelum.jdbc.modelo;

public class Cliente {
	private long id;
	private String nome;
	private String cpf;
	private boolean vip;
	
	public long getId() {
		return this.id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return this.cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public boolean getVip() {
		return this.vip;
	}
	
	public void setVip(boolean vip) {
		this.vip = vip;
	}
	
	

}
