package interfaces;

import java.util.List;

import model.TbTipooperacion;

public interface ITipoOperacion {
	public void RegistrarTipoOperacion(TbTipooperacion tipoOperacion);
	public void ActualizarTipoOperacion(TbTipooperacion tipoOperacion);
	public void EliminarTipoOperacion(TbTipooperacion tipoOperacion);
	public TbTipooperacion BuscarTipoOperacion(TbTipooperacion tipoOperacion);
	public List<TbTipooperacion>ListarTipoOperacion();
}
