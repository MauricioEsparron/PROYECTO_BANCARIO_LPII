package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tb_tipousuario database table.
 * 
 */
@Entity
@Table(name="tb_tipousuario")
@NamedQuery(name="TbTipousuario.findAll", query="SELECT t FROM TbTipousuario t")
public class TbTipousuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codtb_tipousuario")
	private int codtbTipousuario;

	@Column(name="desc_tipousuario")
	private String descTipousuario;

	//bi-directional many-to-one association to TbUsuario
	@OneToMany(mappedBy="tbTipousuario")
	private List<TbUsuario> tbUsuarios;

	public TbTipousuario() {
	}

	public int getCodtbTipousuario() {
		return this.codtbTipousuario;
	}

	public void setCodtbTipousuario(int codtbTipousuario) {
		this.codtbTipousuario = codtbTipousuario;
	}

	public String getDescTipousuario() {
		return this.descTipousuario;
	}

	public void setDescTipousuario(String descTipousuario) {
		this.descTipousuario = descTipousuario;
	}

	public List<TbUsuario> getTbUsuarios() {
		return this.tbUsuarios;
	}

	public void setTbUsuarios(List<TbUsuario> tbUsuarios) {
		this.tbUsuarios = tbUsuarios;
	}

	public TbUsuario addTbUsuario(TbUsuario tbUsuario) {
		getTbUsuarios().add(tbUsuario);
		tbUsuario.setTbTipousuario(this);

		return tbUsuario;
	}

	public TbUsuario removeTbUsuario(TbUsuario tbUsuario) {
		getTbUsuarios().remove(tbUsuario);
		tbUsuario.setTbTipousuario(null);

		return tbUsuario;
	}

}