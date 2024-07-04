package interfaces;

import java.util.List;

import model.TbEstadotarjeta;

public interface IEstadoTarjeta {

	public void RegistrarEstadoTarjeta(TbEstadotarjeta estadoTarjeta);
	public void ActualizarEstadoTarjeta(TbEstadotarjeta estadoTarjeta);
	public void EliminarEstadoTarjeta (TbEstadotarjeta estadoTarjeta);
	public TbEstadotarjeta BuscarEstadoTarjeta (TbEstadotarjeta estadoTarjeta);
	public List<TbEstadotarjeta>ListarEstadoTarjeta();
}
