package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tb_empleado database table.
 * 
 */
@Entity
@Table(name="tb_empleado")
@NamedQuery(name="TbEmpleado.findAll", query="SELECT t FROM TbEmpleado t")
public class TbEmpleado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codtb_empleado")
	private int codtbEmpleado;

	@Column(name="ape_mat_empleado")
	private String apeMatEmpleado;

	@Column(name="ape_pat_empleado")
	private String apePatEmpleado;

	@Column(name="correo_empleado")
	private String correoEmpleado;

	@Column(name="dir_empleado")
	private String dirEmpleado;

	@Column(name="dni_empleado")
	private String dniEmpleado;

	@Temporal(TemporalType.DATE)
	private Date fecNac_empleado;

	@Column(name="nom_empleado")
	private String nomEmpleado;

	@Column(name="telf_empleado")
	private String telfEmpleado;

	//bi-directional many-to-one association to TbTipoempleado
	@ManyToOne
	@JoinColumn(name="tipo_empleado")
	private TbTipoempleado tbTipoempleado;

	public TbEmpleado() {
	}

	public int getCodtbEmpleado() {
		return this.codtbEmpleado;
	}

	public void setCodtbEmpleado(int codtbEmpleado) {
		this.codtbEmpleado = codtbEmpleado;
	}

	public String getApeMatEmpleado() {
		return this.apeMatEmpleado;
	}

	public void setApeMatEmpleado(String apeMatEmpleado) {
		this.apeMatEmpleado = apeMatEmpleado;
	}

	public String getApePatEmpleado() {
		return this.apePatEmpleado;
	}

	public void setApePatEmpleado(String apePatEmpleado) {
		this.apePatEmpleado = apePatEmpleado;
	}

	public String getCorreoEmpleado() {
		return this.correoEmpleado;
	}

	public void setCorreoEmpleado(String correoEmpleado) {
		this.correoEmpleado = correoEmpleado;
	}

	public String getDirEmpleado() {
		return this.dirEmpleado;
	}

	public void setDirEmpleado(String dirEmpleado) {
		this.dirEmpleado = dirEmpleado;
	}

	public String getDniEmpleado() {
		return this.dniEmpleado;
	}

	public void setDniEmpleado(String dniEmpleado) {
		this.dniEmpleado = dniEmpleado;
	}

	public Date getFecNac_empleado() {
		return this.fecNac_empleado;
	}

	public void setFecNac_empleado(Date fecNac_empleado) {
		this.fecNac_empleado = fecNac_empleado;
	}

	public String getNomEmpleado() {
		return this.nomEmpleado;
	}

	public void setNomEmpleado(String nomEmpleado) {
		this.nomEmpleado = nomEmpleado;
	}

	public String getTelfEmpleado() {
		return this.telfEmpleado;
	}

	public void setTelfEmpleado(String telfEmpleado) {
		this.telfEmpleado = telfEmpleado;
	}

	public TbTipoempleado getTbTipoempleado() {
		return this.tbTipoempleado;
	}

	public void setTbTipoempleado(TbTipoempleado tbTipoempleado) {
		this.tbTipoempleado = tbTipoempleado;
	}

}