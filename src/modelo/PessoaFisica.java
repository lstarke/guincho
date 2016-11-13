package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.google.gson.Gson;

@Entity
@Table(name = "pessoa_fisica")
public class PessoaFisica {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "CODIGO_PESSOA_FISICA")
	private long codigo;
	
	@Column(name = "TELEFONE")
	private String telefone;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "SENHA")
	private String senha;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CODIGO_ENDERECO")
	private Endereco endereco;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_CADASTRO")
	private Date dataCadastro;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "SOBRENOME")
	private String sobrenome;
	
	@Column(name = "RG")
	private String rg;
	
	@Column(name = "CPF")
	private String cpf;	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "CODIGO_PESSOA_FISICA", nullable = false) 
	private List<Veiculo> veiculos = new ArrayList<>();;	
	
	public PessoaFisica() {
		
	}
	
	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
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
	
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	
	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public void setVeiculos(ArrayList<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSobrenome() {
		return sobrenome;
	}
	
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	public String getRg() {
		return rg;
	}
	
	public void setRg(String rg) {
		this.rg = rg;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}	
	
	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public String toJson() {
		return new Gson().toJson(this);
	}

}
