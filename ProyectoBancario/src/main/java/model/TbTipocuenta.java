package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tb_tipocuenta database table.
 * 
 */
@Entity
@Table(name="tb_tipocuenta")
@NamedQuery(name="TbTipocuenta.findAll", query="SELECT t FROM TbTipocuenta t")
public class TbTipocuenta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codtb_tipocuenta")
	private int codtbTipocuenta;

	@Column(name="desc_tipocuenta")
	private String descTipocuenta;

	//bi-directional many-to-one association to TbTarjeta
	@OneToMany(mappedBy="tbTipocuenta")
	private List<TbTarjeta> tbTarjetas;

	public TbTipocuenta() {
	}

	public int getCodtbTipocuenta() {
		return this.codtbTipocuenta;
	}

	public void setCodtbTipocuenta(int codtbTipocuenta) {
		this.codtbTipocuenta = codtbTipocuenta;
	}

	public String getDescTipocuenta() {
		return this.descTipocuenta;
	}

	public void setDescTipocuenta(String descTipocuenta) {
		this.descTipocuenta = descTipocuenta;
	}

	public List<TbTarjeta> getTbTarjetas() {
		return this.tbTarjetas;
	}

	public void setTbTarjetas(List<TbTarjeta> tbTarjetas) {
		this.tbTarjetas = tbTarjetas;
	}

	public TbTarjeta addTbTarjeta(TbTarjeta tbTarjeta) {
		getTbTarjetas().add(tbTarjeta);
		tbTarjeta.setTbTipocuenta(this);

		return tbTarjeta;
	}

	public TbTarjeta removeTbTarjeta(TbTarjeta tbTarjeta) {
		getTbTarjetas().remove(tbTarjeta);
		tbTarjeta.setTbTipocuenta(null);

		return tbTarjeta;
	}

}