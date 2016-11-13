package modelo;

import com.google.gson.Gson;

public class Credencial {
	
	private String email;
	private String senha;
	
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
	
	public String toJson() {
		return new Gson().toJson(this);
	}

}
