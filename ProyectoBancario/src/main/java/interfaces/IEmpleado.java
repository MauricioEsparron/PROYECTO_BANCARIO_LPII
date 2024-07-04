package interfaces;

import java.util.List;

import model.TbEmpleado;

public interface IEmpleado {

	public void RegistrarEmpleado(TbEmpleado empleado);
	public void ActualizarEmpleado (TbEmpleado empleado);
	public void EliminarEmpleado(TbEmpleado empleado);
	public TbEmpleado BuscarEmpleado(TbEmpleado empleado);
	public List<TbEmpleado>ListarEmpleado();
}
