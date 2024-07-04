package interfaces;

import java.util.List;

import model.TbCliente;

public interface ICliente {


	public void RegistrarCliente(TbCliente cliente);
	public void ActualizarCliente (TbCliente cliente);
	public void EliminarCliente (TbCliente cliente);
	public TbCliente BuscarCliente (TbCliente cliente);
	public List<TbCliente>ListarCliente();
}
