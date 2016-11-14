package modelo;

import com.google.gson.Gson;

public class Credencial {
	
	private String email;
	private String senha;
	private TipoPessoaEnum tipoPessoa;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}	
	public TipoPessoaEnum getTipoPessoa() {
		return tipoPessoa;
	}
	public void setTipoPessoa(TipoPessoaEnum tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
	public String toJson() {
		return new Gson().toJson(this);
	}

}
