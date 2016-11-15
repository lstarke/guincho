package modelo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;

import com.google.gson.Gson;

@Entity
@Table(name = "ordem_servico")
public class OrdemServico {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "CODIGO_ORDEM_SERVICO")
	private long codigo;
	
	@Column(name = "FINALIZADA")
	private boolean finalizada;
	@Column(name = "EM_ANDAMENTO")
	private boolean emAndamento;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CODIGO_PESSOA_FISICA")
	private PessoaFisica pessoaFisica;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CODIGO_PESSOA_JURIDICA")
	private PessoaJuridica pessoaJuridica;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_INICIO")
	private Date dataInicio;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_FIM")
	private Date dataFim;
	
	@Column(name = "DESCRICAO")
	private String descricao;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CODIGO_LOCALIZACAO_CLIENTE")
	private LocalizacaoCliente localizacaoCliente;	
	
	public boolean isEmAndamento() {
		return emAndamento;
	}

	public void setEmAndamento(boolean emAndamento) {
		this.emAndamento = emAndamento;
	}

	public OrdemServico() {
		this.finalizada = false;
		this.emAndamento = false;
	}
	
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public boolean isFinalizada() {
		return finalizada;
	}
	public void setFinalizada(boolean finalizada) {
		this.finalizada = finalizada;
	}
	public PessoaFisica getPessoaFisica() {
		return pessoaFisica;
	}
	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}
	public PessoaJuridica getPessoaJuridica() {
		return pessoaJuridica;
	}
	public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Date getDataFim() {
		return dataFim;
	}
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public LocalizacaoCliente getLocalizacaoCliente() {
		return localizacaoCliente;
	}
	public void setLocalizacaoCliente(LocalizacaoCliente localizacaoCliente) {
		this.localizacaoCliente = localizacaoCliente;
	}
	
	public String toJson() {
		return new Gson().toJson(this);
	}

}
