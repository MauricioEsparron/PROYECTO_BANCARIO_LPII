package interfaces;

import java.util.List;

import model.TbTarjeta;

public interface ITarjeta {

	public void RegistrarTarjeta(TbTarjeta tarjeta);
	public void ActualizarTarjeta(TbTarjeta tarjeta);
	public void EliminarTarjeta (TbTarjeta tarjeta);
	public TbTarjeta BuscarTarjeta (TbTarjeta tarjeta);
	public List<TbTarjeta>ListarTarjeta();
}
