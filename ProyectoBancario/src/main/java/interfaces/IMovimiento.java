package interfaces;

import java.util.List;

import model.TbMovimiento;

public interface IMovimiento {

	public void RegistrarMovimiento(TbMovimiento movimiento);
	public void ActualizarMovimiento(TbMovimiento movimiento);
	public void EliminarMovimiento(TbMovimiento movimiento);
	public TbMovimiento BuscarMovimiento (TbMovimiento movimiento);
	public List<TbMovimiento>ListarMovimiento();
}
