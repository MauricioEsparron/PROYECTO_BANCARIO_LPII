package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tb_estadotarjeta database table.
 * 
 */
@Entity
@Table(name="tb_estadotarjeta")
@NamedQuery(name="TbEstadotarjeta.findAll", query="SELECT t FROM TbEstadotarjeta t")
public class TbEstadotarjeta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codtb_estadotarjeta")
	private int codtbEstadotarjeta;

	@Column(name="desc_estadotarjeta")
	private String descEstadotarjeta;

	//bi-directional many-to-one association to TbTarjeta
	@OneToMany(mappedBy="tbEstadotarjeta")
	private List<TbTarjeta> tbTarjetas;

	public TbEstadotarjeta() {
	}

	public int getCodtbEstadotarjeta() {
		return this.codtbEstadotarjeta;
	}

	public void setCodtbEstadotarjeta(int codtbEstadotarjeta) {
		this.codtbEstadotarjeta = codtbEstadotarjeta;
	}

	public String getDescEstadotarjeta() {
		return this.descEstadotarjeta;
	}

	public void setDescEstadotarjeta(String descEstadotarjeta) {
		this.descEstadotarjeta = descEstadotarjeta;
	}

	public List<TbTarjeta> getTbTarjetas() {
		return this.tbTarjetas;
	}

	public void setTbTarjetas(List<TbTarjeta> tbTarjetas) {
		this.tbTarjetas = tbTarjetas;
	}

	public TbTarjeta addTbTarjeta(TbTarjeta tbTarjeta) {
		getTbTarjetas().add(tbTarjeta);
		tbTarjeta.setTbEstadotarjeta(this);

		return tbTarjeta;
	}

	public TbTarjeta removeTbTarjeta(TbTarjeta tbTarjeta) {
		getTbTarjetas().remove(tbTarjeta);
		tbTarjeta.setTbEstadotarjeta(null);

		return tbTarjeta;
	}

}