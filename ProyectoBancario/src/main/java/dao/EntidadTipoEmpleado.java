package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import interfaces.ITipoEmpleado;
import model.TbTipoempleado;

public class EntidadTipoEmpleado implements ITipoEmpleado{

	@Override
	public void RegistrarTipoEmpleado(TbTipoempleado tipoEmpleado) {
		EntityManagerFactory em = Persistence.createEntityManagerFactory("ProyectoBancario");
		EntityManager emanager = em.createEntityManager();
		emanager.getTransaction().begin();
		emanager.persist(tipoEmpleado);
		System.out.println("tipo emnpleado registrado en la BD");
		emanager.getTransaction().commit();
		emanager.close();			
	}

	@Override
	public void ActualizarTipoEmpleado(TbTipoempleado tipoEmpleado) {
		EntityManagerFactory em = Persistence.createEntityManagerFactory("ProyectoBancario");
		EntityManager emanager = em.createEntityManager();
		emanager.getTransaction().begin();
		emanager.merge(tipoEmpleado);
		System.out.println("tipo empleado actualizado en bd");
		emanager.getTransaction().commit();
		emanager.close();			
	}

	@Override
	public void EliminarTipoEmpleado(TbTipoempleado tipoEmpleado) {
		EntityManagerFactory em = Persistence.createEntityManagerFactory("ProyectoBancario");
		EntityManager emanager = em.createEntityManager();
		emanager.getTransaction().begin();
		TbTipoempleado elim = emanager.merge(tipoEmpleado);
		emanager.remove(elim);
		System.out.println("tipo empleado eliminado de la bd");
		emanager.getTransaction().commit();
		emanager.close();			
	}

	@Override
	public TbTipoempleado BuscarTipoEmpleado(TbTipoempleado tipoEmpleado) {
		EntityManagerFactory em = Persistence.createEntityManagerFactory("ProyectoBancario");
		EntityManager emanager = em.createEntityManager();
		emanager.getTransaction().begin();
		TbTipoempleado buscar = emanager.find(TbTipoempleado.class,tipoEmpleado.getCodtbTipoempleado());
		emanager.getTransaction().commit();
		emanager.close();
		return buscar;
	}

	@Override
	public List<TbTipoempleado> ListarTipoEmpleado() {
		EntityManagerFactory em = Persistence.createEntityManagerFactory("ProyectoBancario");
		EntityManager emanager = em.createEntityManager();
		emanager.getTransaction().begin();
		List<TbTipoempleado> listado = emanager.createQuery("select te from TbTipoempleado te", TbTipoempleado.class).getResultList();
		emanager.getTransaction().commit();
		emanager.close();
		return listado;
	}

}
