package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tb_cliente database table.
 * 
 */
@Entity
@Table(name="tb_cliente")
@NamedQuery(name="TbCliente.findAll", query="SELECT t FROM TbCliente t")
public class TbCliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codtb_cliente")
	private int codtbCliente;

	@Column(name="ape_mat_cliente")
	private String apeMatCliente;

	@Column(name="ape_pat_cliente")
	private String apePatCliente;

	@Column(name="correo_cliente")
	private String correoCliente;

	@Column(name="dni_cliente")
	private String dniCliente;

	@Temporal(TemporalType.DATE)
	private Date fecNac_cliente;

	@Column(name="nom_cliente")
	private String nomCliente;

	@Column(name="telf_cliente")
	private String telfCliente;

	@Column(name="usuario_cliente")
	private int usuarioCliente;

	//bi-directional many-to-one association to TbMovimiento
	@OneToMany(mappedBy="tbCliente")
	private List<TbMovimiento> tbMovimientos;

	//bi-directional many-to-one association to TbTarjeta
	@OneToMany(mappedBy="tbCliente")
	private List<TbTarjeta> tbTarjetas;

	public TbCliente() {
	}

	public int getCodtbCliente() {
		return this.codtbCliente;
	}

	public void setCodtbCliente(int codtbCliente) {
		this.codtbCliente = codtbCliente;
	}

	public String getApeMatCliente() {
		return this.apeMatCliente;
	}

	public void setApeMatCliente(String apeMatCliente) {
		this.apeMatCliente = apeMatCliente;
	}

	public String getApePatCliente() {
		return this.apePatCliente;
	}

	public void setApePatCliente(String apePatCliente) {
		this.apePatCliente = apePatCliente;
	}

	public String getCorreoCliente() {
		return this.correoCliente;
	}

	public void setCorreoCliente(String correoCliente) {
		this.correoCliente = correoCliente;
	}

	public String getDniCliente() {
		return this.dniCliente;
	}

	public void setDniCliente(String dniCliente) {
		this.dniCliente = dniCliente;
	}

	public Date getFecNac_cliente() {
		return this.fecNac_cliente;
	}

	public void setFecNac_cliente(Date fecNac_cliente) {
		this.fecNac_cliente = fecNac_cliente;
	}

	public String getNomCliente() {
		return this.nomCliente;
	}

	public void setNomCliente(String nomCliente) {
		this.nomCliente = nomCliente;
	}

	public String getTelfCliente() {
		return this.telfCliente;
	}

	public void setTelfCliente(String telfCliente) {
		this.telfCliente = telfCliente;
	}

	public int getUsuarioCliente() {
		return this.usuarioCliente;
	}

	public void setUsuarioCliente(int usuarioCliente) {
		this.usuarioCliente = usuarioCliente;
	}

	public List<TbMovimiento> getTbMovimientos() {
		return this.tbMovimientos;
	}

	public void setTbMovimientos(List<TbMovimiento> tbMovimientos) {
		this.tbMovimientos = tbMovimientos;
	}

	public TbMovimiento addTbMovimiento(TbMovimiento tbMovimiento) {
		getTbMovimientos().add(tbMovimiento);
		tbMovimiento.setTbCliente(this);

		return tbMovimiento;
	}

	public TbMovimiento removeTbMovimiento(TbMovimiento tbMovimiento) {
		getTbMovimientos().remove(tbMovimiento);
		tbMovimiento.setTbCliente(null);

		return tbMovimiento;
	}

	public List<TbTarjeta> getTbTarjetas() {
		return this.tbTarjetas;
	}

	public void setTbTarjetas(List<TbTarjeta> tbTarjetas) {
		this.tbTarjetas = tbTarjetas;
	}

	public TbTarjeta addTbTarjeta(TbTarjeta tbTarjeta) {
		getTbTarjetas().add(tbTarjeta);
		tbTarjeta.setTbCliente(this);

		return tbTarjeta;
	}

	public TbTarjeta removeTbTarjeta(TbTarjeta tbTarjeta) {
		getTbTarjetas().remove(tbTarjeta);
		tbTarjeta.setTbCliente(null);

		return tbTarjeta;
	}

}