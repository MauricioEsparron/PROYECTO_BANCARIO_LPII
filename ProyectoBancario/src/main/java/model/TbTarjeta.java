package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tb_tarjeta database table.
 * 
 */
@Entity
@Table(name="tb_tarjeta")
@NamedQuery(name="TbTarjeta.findAll", query="SELECT t FROM TbTarjeta t")
public class TbTarjeta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="numtb_tarjeta")
	private int numtbTarjeta;

	@Column(name="cvr_tarjeta")
	private String cvrTarjeta;

	@Temporal(TemporalType.DATE)
	private Date fecActivacion_tarjeta;

	@Temporal(TemporalType.DATE)
	private Date fecCaducidad_tarjeta;

	private String numCuenta_tarjeta;

	@Column(name="saldo_tarjeta")
	private BigDecimal saldoTarjeta;

	//bi-directional many-to-one association to TbMovimiento
	@OneToMany(mappedBy="tbTarjeta")
	private List<TbMovimiento> tbMovimientos;

	//bi-directional many-to-one association to TbCliente
	@ManyToOne
	@JoinColumn(name="duenio_tarjeta")
	private TbCliente tbCliente;

	//bi-directional many-to-one association to TbTipocuenta
	@ManyToOne
	@JoinColumn(name="tipocuenta_tarjeta")
	private TbTipocuenta tbTipocuenta;

	//bi-directional many-to-one association to TbEstadotarjeta
	@ManyToOne
	@JoinColumn(name="estaco_tarjeta")
	private TbEstadotarjeta tbEstadotarjeta;

	public TbTarjeta() {
	}

	public int getNumtbTarjeta() {
		return this.numtbTarjeta;
	}

	public void setNumtbTarjeta(int numtbTarjeta) {
		this.numtbTarjeta = numtbTarjeta;
	}

	public String getCvrTarjeta() {
		return this.cvrTarjeta;
	}

	public void setCvrTarjeta(String cvrTarjeta) {
		this.cvrTarjeta = cvrTarjeta;
	}

	public Date getFecActivacion_tarjeta() {
		return this.fecActivacion_tarjeta;
	}

	public void setFecActivacion_tarjeta(Date fecActivacion_tarjeta) {
		this.fecActivacion_tarjeta = fecActivacion_tarjeta;
	}

	public Date getFecCaducidad_tarjeta() {
		return this.fecCaducidad_tarjeta;
	}

	public void setFecCaducidad_tarjeta(Date fecCaducidad_tarjeta) {
		this.fecCaducidad_tarjeta = fecCaducidad_tarjeta;
	}

	public String getNumCuenta_tarjeta() {
		return this.numCuenta_tarjeta;
	}

	public void setNumCuenta_tarjeta(String numCuenta_tarjeta) {
		this.numCuenta_tarjeta = numCuenta_tarjeta;
	}

	public BigDecimal getSaldoTarjeta() {
		return this.saldoTarjeta;
	}

	public void setSaldoTarjeta(BigDecimal saldoTarjeta) {
		this.saldoTarjeta = saldoTarjeta;
	}

	public List<TbMovimiento> getTbMovimientos() {
		return this.tbMovimientos;
	}

	public void setTbMovimientos(List<TbMovimiento> tbMovimientos) {
		this.tbMovimientos = tbMovimientos;
	}

	public TbMovimiento addTbMovimiento(TbMovimiento tbMovimiento) {
		getTbMovimientos().add(tbMovimiento);
		tbMovimiento.setTbTarjeta(this);

		return tbMovimiento;
	}

	public TbMovimiento removeTbMovimiento(TbMovimiento tbMovimiento) {
		getTbMovimientos().remove(tbMovimiento);
		tbMovimiento.setTbTarjeta(null);

		return tbMovimiento;
	}

	public TbCliente getTbCliente() {
		return this.tbCliente;
	}

	public void setTbCliente(TbCliente tbCliente) {
		this.tbCliente = tbCliente;
	}

	public TbTipocuenta getTbTipocuenta() {
		return this.tbTipocuenta;
	}

	public void setTbTipocuenta(TbTipocuenta tbTipocuenta) {
		this.tbTipocuenta = tbTipocuenta;
	}

	public TbEstadotarjeta getTbEstadotarjeta() {
		return this.tbEstadotarjeta;
	}

	public void setTbEstadotarjeta(TbEstadotarjeta tbEstadotarjeta) {
		this.tbEstadotarjeta = tbEstadotarjeta;
	}

}