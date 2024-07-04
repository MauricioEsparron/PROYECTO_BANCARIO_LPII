package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tb_usuario database table.
 * 
 */
@Entity
@Table(name="tb_usuario")
@NamedQuery(name="TbUsuario.findAll", query="SELECT t FROM TbUsuario t")
public class TbUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codtb_usuario")
	private int codtbUsuario;

	@Column(name="clave_usuario")
	private String claveUsuario;

	@Column(name="nom_usuario")
	private String nomUsuario;

	//bi-directional many-to-one association to TbTipousuario
	@ManyToOne
	@JoinColumn(name="tipo_usuario")
	private TbTipousuario tbTipousuario;

	//bi-directional many-to-one association to TbEstadousuario
	@ManyToOne
	@JoinColumn(name="estado_usuario")
	private TbEstadousuario tbEstadousuario;

	public TbUsuario() {
	}

	public int getCodtbUsuario() {
		return this.codtbUsuario;
	}

	public void setCodtbUsuario(int codtbUsuario) {
		this.codtbUsuario = codtbUsuario;
	}

	public String getClaveUsuario() {
		return this.claveUsuario;
	}

	public void setClaveUsuario(String claveUsuario) {
		this.claveUsuario = claveUsuario;
	}

	public String getNomUsuario() {
		return this.nomUsuario;
	}

	public void setNomUsuario(String nomUsuario) {
		this.nomUsuario = nomUsuario;
	}

	public TbTipousuario getTbTipousuario() {
		return this.tbTipousuario;
	}

	public void setTbTipousuario(TbTipousuario tbTipousuario) {
		this.tbTipousuario = tbTipousuario;
	}

	public TbEstadousuario getTbEstadousuario() {
		return this.tbEstadousuario;
	}

	public void setTbEstadousuario(TbEstadousuario tbEstadousuario) {
		this.tbEstadousuario = tbEstadousuario;
	}

}