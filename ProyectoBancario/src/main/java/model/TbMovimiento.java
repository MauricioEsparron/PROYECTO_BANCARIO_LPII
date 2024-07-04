package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the tb_movimiento database table.
 * 
 */
@Entity
@Table(name="tb_movimiento")
@NamedQuery(name="TbMovimiento.findAll", query="SELECT t FROM TbMovimiento t")
public class TbMovimiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codtb_movimiento")
	private int codtbMovimiento;

	@Temporal(TemporalType.DATE)
	@Column(name="fec_movimiento")
	private Date fecMovimiento;

	private BigDecimal monto;

	@Column(name="numcuenta_cliente")
	private String numcuentaCliente;

	//bi-directional many-to-one association to TbTarjeta
	@ManyToOne
	@JoinColumn(name="numtarjeta_cliente")
	private TbTarjeta tbTarjeta;

	//bi-directional many-to-one association to TbCliente
	@ManyToOne
	@JoinColumn(name="cod_cliente")
	private TbCliente tbCliente;

	//bi-directional many-to-one association to TbTipooperacion
	@ManyToOne
	@JoinColumn(name="cod_operacion")
	private TbTipooperacion tbTipooperacion;

	public TbMovimiento() {
	}

	public int getCodtbMovimiento() {
		return this.codtbMovimiento;
	}

	public void setCodtbMovimiento(int codtbMovimiento) {
		this.codtbMovimiento = codtbMovimiento;
	}

	public Date getFecMovimiento() {
		return this.fecMovimiento;
	}

	public void setFecMovimiento(Date fecMovimiento) {
		this.fecMovimiento = fecMovimiento;
	}

	public BigDecimal getMonto() {
		return this.monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public String getNumcuentaCliente() {
		return this.numcuentaCliente;
	}

	public void setNumcuentaCliente(String numcuentaCliente) {
		this.numcuentaCliente = numcuentaCliente;
	}

	public TbTarjeta getTbTarjeta() {
		return this.tbTarjeta;
	}

	public void setTbTarjeta(TbTarjeta tbTarjeta) {
		this.tbTarjeta = tbTarjeta;
	}

	public TbCliente getTbCliente() {
		return this.tbCliente;
	}

	public void setTbCliente(TbCliente tbCliente) {
		this.tbCliente = tbCliente;
	}

	public TbTipooperacion getTbTipooperacion() {
		return this.tbTipooperacion;
	}

	public void setTbTipooperacion(TbTipooperacion tbTipooperacion) {
		this.tbTipooperacion = tbTipooperacion;
	}

}