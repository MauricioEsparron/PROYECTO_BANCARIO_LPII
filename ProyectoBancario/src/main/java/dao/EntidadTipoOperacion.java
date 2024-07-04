package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import interfaces.ITipoOperacion;
import model.TbTipooperacion;

public class EntidadTipoOperacion implements ITipoOperacion{

	@Override
	public void RegistrarTipoOperacion(TbTipooperacion tipoOperacion) {
		EntityManagerFactory em = Persistence.createEntityManagerFactory("ProyectoBancario");
		EntityManager emanager = em.createEntityManager();
		emanager.getTransaction().begin();
		emanager.persist(tipoOperacion);
		System.out.println("tipo operacion registrado en la BD");
		emanager.getTransaction().commit();
		emanager.close();			
	}

	@Override
	public void ActualizarTipoOperacion(TbTipooperacion tipoOperacion) {
		EntityManagerFactory em = Persistence.createEntityManagerFactory("ProyectoBancario");
		EntityManager emanager = em.createEntityManager();
		emanager.getTransaction().begin();
		emanager.merge(tipoOperacion);
		System.out.println("tipo operacion actualizado en bd");
		emanager.getTransaction().commit();
		emanager.close();			
	}

	@Override
	public void EliminarTipoOperacion(TbTipooperacion tipoOperacion) {
		EntityManagerFactory em = Persistence.createEntityManagerFactory("ProyectoBancario");
		EntityManager emanager = em.createEntityManager();
		emanager.getTransaction().begin();
		TbTipooperacion elim = emanager.merge(tipoOperacion);
		emanager.remove(elim);
		System.out.println("tipo operacion eliminado de la bd");
		emanager.getTransaction().commit();
		emanager.close();			
	}

	@Override
	public TbTipooperacion BuscarTipoOperacion(TbTipooperacion tipoOperacion) {
		EntityManagerFactory em = Persistence.createEntityManagerFactory("ProyectoBancario");
		EntityManager emanager = em.createEntityManager();
		emanager.getTransaction().begin();
		TbTipooperacion buscar = emanager.find(TbTipooperacion.class,tipoOperacion.getCodtbTipooperacion());
		emanager.getTransaction().commit();
		emanager.close();
		return buscar;
	}

	@Override
	public List<TbTipooperacion> ListarTipoOperacion() {
		EntityManagerFactory em = Persistence.createEntityManagerFactory("ProyectoBancario");
		EntityManager emanager = em.createEntityManager();
		emanager.getTransaction().begin();
		List<TbTipooperacion> listado = emanager.createQuery("select to from TbTipooperacion to", TbTipooperacion.class).getResultList();
		emanager.getTransaction().commit();
		emanager.close();
		return listado;
	}

}
