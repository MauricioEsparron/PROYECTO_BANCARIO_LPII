package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tb_tipoempleado database table.
 * 
 */
@Entity
@Table(name="tb_tipoempleado")
@NamedQuery(name="TbTipoempleado.findAll", query="SELECT t FROM TbTipoempleado t")
public class TbTipoempleado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codtb_tipoempleado")
	private int codtbTipoempleado;

	@Column(name="desc_tipoempleado")
	private String descTipoempleado;

	//bi-directional many-to-one association to TbEmpleado
	@OneToMany(mappedBy="tbTipoempleado")
	private List<TbEmpleado> tbEmpleados;

	public TbTipoempleado() {
	}

	public int getCodtbTipoempleado() {
		return this.codtbTipoempleado;
	}

	public void setCodtbTipoempleado(int codtbTipoempleado) {
		this.codtbTipoempleado = codtbTipoempleado;
	}

	public String getDescTipoempleado() {
		return this.descTipoempleado;
	}

	public void setDescTipoempleado(String descTipoempleado) {
		this.descTipoempleado = descTipoempleado;
	}

	public List<TbEmpleado> getTbEmpleados() {
		return this.tbEmpleados;
	}

	public void setTbEmpleados(List<TbEmpleado> tbEmpleados) {
		this.tbEmpleados = tbEmpleados;
	}

	public TbEmpleado addTbEmpleado(TbEmpleado tbEmpleado) {
		getTbEmpleados().add(tbEmpleado);
		tbEmpleado.setTbTipoempleado(this);

		return tbEmpleado;
	}

	public TbEmpleado removeTbEmpleado(TbEmpleado tbEmpleado) {
		getTbEmpleados().remove(tbEmpleado);
		tbEmpleado.setTbTipoempleado(null);

		return tbEmpleado;
	}

}