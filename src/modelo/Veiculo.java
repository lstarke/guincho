package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "VEICULO")
public class Veiculo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "CODIGO_VEICULO")	
	private long codigo;
	
	@Column(name = "ANO")
	private int ano;
	
	@Column(name = "PLACA")
	private String placa;
	
	@Column(name = "RENAVAM")
	private int renavam;
	
	@Column(name = "FABRICANTE")
	private String fabricante;
	
	@Column(name = "MODELO")
	private String modelo;
	
	@Column(name = "COR")
	private String cor;
	
	public Veiculo() {
		
	}	

	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}	

	public int getRenavam() {
		return renavam;
	}
	public void setRenavam(int renavam) {
		this.renavam = renavam;
	}

	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}


}
