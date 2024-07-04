package interfaces;

import java.util.List;

import model.TbTipocuenta;

public interface ITipoCuenta {

	public void RegistrarTipoCuenta(TbTipocuenta tipoCuenta);
	public void ActualizarTipoCuenta(TbTipocuenta tipoCuenta);
	public void EliminarTipoCuenta(TbTipocuenta tipoCuenta);
	public TbTipocuenta BuscarTipoCuenta(TbTipocuenta tipoCuenta);
	public List<TbTipocuenta>ListarTipoCuenta();
}
