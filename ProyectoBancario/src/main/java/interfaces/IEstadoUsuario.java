package interfaces;

import java.util.List;

import model.TbEstadousuario;

public interface IEstadoUsuario {

	public void RegistrarEstadoUsuario(TbEstadousuario estadoUsuario);
	public void ActualizarEstadoUsuario(TbEstadousuario estadoUsuario);
	public void EliminarEstadoUsuario(TbEstadousuario estadoUsuario);
	public TbEstadousuario BuscarEstadoUsuario(TbEstadousuario estadoUsuario);
	public List<TbEstadousuario>ListarEstadoUsuario();
}
