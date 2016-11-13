package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "localizacao")
public class LocalizacaoCliente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "CODIGO_LOCALIZACAO_CLIENTE")
	private long codigo;
	
	@Column(name = "LAT")
	private double lat;
	
	@Column(name = "LNG")
	private double lng;
	
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}	

}

