package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tb_estadousuario database table.
 * 
 */
@Entity
@Table(name="tb_estadousuario")
@NamedQuery(name="TbEstadousuario.findAll", query="SELECT t FROM TbEstadousuario t")
public class TbEstadousuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codtb_estadousuario")
	private int codtbEstadousuario;

	@Column(name="desc_estadousuario")
	private String descEstadousuario;

	//bi-directional many-to-one association to TbUsuario
	@OneToMany(mappedBy="tbEstadousuario")
	private List<TbUsuario> tbUsuarios;

	public TbEstadousuario() {
	}

	public int getCodtbEstadousuario() {
		return this.codtbEstadousuario;
	}

	public void setCodtbEstadousuario(int codtbEstadousuario) {
		this.codtbEstadousuario = codtbEstadousuario;
	}

	public String getDescEstadousuario() {
		return this.descEstadousuario;
	}

	public void setDescEstadousuario(String descEstadousuario) {
		this.descEstadousuario = descEstadousuario;
	}

	public List<TbUsuario> getTbUsuarios() {
		return this.tbUsuarios;
	}

	public void setTbUsuarios(List<TbUsuario> tbUsuarios) {
		this.tbUsuarios = tbUsuarios;
	}

	public TbUsuario addTbUsuario(TbUsuario tbUsuario) {
		getTbUsuarios().add(tbUsuario);
		tbUsuario.setTbEstadousuario(this);

		return tbUsuario;
	}

	public TbUsuario removeTbUsuario(TbUsuario tbUsuario) {
		getTbUsuarios().remove(tbUsuario);
		tbUsuario.setTbEstadousuario(null);

		return tbUsuario;
	}

}