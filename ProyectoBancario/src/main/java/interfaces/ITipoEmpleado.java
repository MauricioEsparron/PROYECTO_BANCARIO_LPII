package interfaces;

import java.util.List;

import model.TbTipoempleado;

public interface ITipoEmpleado {

	public void RegistrarTipoEmpleado(TbTipoempleado tipoEmpleado);
	public void ActualizarTipoEmpleado(TbTipoempleado tipoEmpleado);
	public void EliminarTipoEmpleado(TbTipoempleado tipoEmpleado);
	public TbTipoempleado BuscarTipoEmpleado (TbTipoempleado tipoEmpleado);
	public List<TbTipoempleado>ListarTipoEmpleado();
}
