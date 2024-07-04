package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tb_tipooperacion database table.
 * 
 */
@Entity
@Table(name="tb_tipooperacion")
@NamedQuery(name="TbTipooperacion.findAll", query="SELECT t FROM TbTipooperacion t")
public class TbTipooperacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codtb_tipooperacion")
	private int codtbTipooperacion;

	@Column(name="desc_tipooperacion")
	private String descTipooperacion;

	//bi-directional many-to-one association to TbMovimiento
	@OneToMany(mappedBy="tbTipooperacion")
	private List<TbMovimiento> tbMovimientos;

	public TbTipooperacion() {
	}

	public int getCodtbTipooperacion() {
		return this.codtbTipooperacion;
	}

	public void setCodtbTipooperacion(int codtbTipooperacion) {
		this.codtbTipooperacion = codtbTipooperacion;
	}

	public String getDescTipooperacion() {
		return this.descTipooperacion;
	}

	public void setDescTipooperacion(String descTipooperacion) {
		this.descTipooperacion = descTipooperacion;
	}

	public List<TbMovimiento> getTbMovimientos() {
		return this.tbMovimientos;
	}

	public void setTbMovimientos(List<TbMovimiento> tbMovimientos) {
		this.tbMovimientos = tbMovimientos;
	}

	public TbMovimiento addTbMovimiento(TbMovimiento tbMovimiento) {
		getTbMovimientos().add(tbMovimiento);
		tbMovimiento.setTbTipooperacion(this);

		return tbMovimiento;
	}

	public TbMovimiento removeTbMovimiento(TbMovimiento tbMovimiento) {
		getTbMovimientos().remove(tbMovimiento);
		tbMovimiento.setTbTipooperacion(null);

		return tbMovimiento;
	}

}