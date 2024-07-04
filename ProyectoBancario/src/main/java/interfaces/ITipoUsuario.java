package interfaces;

import java.util.List;

import model.TbTipousuario;

public interface ITipoUsuario {

	public void RegistrarTipoUsuario(TbTipousuario tipoUsuario);
	public void ActualizarTipoUsuario (TbTipousuario tipoUsuario);
	public void EliminarTipoUsuario (TbTipousuario tipoUsuario);
	public TbTipousuario BuscarTipoUsuario (TbTipousuario tipoUsuario);
	public List<TbTipousuario>ListarTipoUsuario();
}