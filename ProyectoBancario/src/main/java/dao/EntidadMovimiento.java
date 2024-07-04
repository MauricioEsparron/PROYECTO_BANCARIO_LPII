package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import interfaces.IMovimiento;
import model.TbMovimiento;

public class EntidadMovimiento implements IMovimiento{

	@Override
	public void RegistrarMovimiento(TbMovimiento movimiento) {
		EntityManagerFactory em = Persistence.createEntityManagerFactory("ProyectoBancario");
		EntityManager emanager = em.createEntityManager();
		emanager.getTransaction().begin();
		emanager.persist(movimiento);
		System.out.println("Movimiento registrado en la BD");
		emanager.getTransaction().commit();
		emanager.close();	
		
	}

	@Override
	public void ActualizarMovimiento(TbMovimiento movimiento) {
		EntityManagerFactory em = Persistence.createEntityManagerFactory("ProyectoBancario");
		EntityManager emanager = em.createEntityManager();
		emanager.getTransaction().begin();
		emanager.merge(movimiento);
		System.out.println("movimiento actualizado en bd");
		emanager.getTransaction().commit();
		emanager.close();			
	}

	@Override
	public void EliminarMovimiento(TbMovimiento movimiento) {
		EntityManagerFactory em = Persistence.createEntityManagerFactory("ProyectoBancario");
		EntityManager emanager = em.createEntityManager();
		emanager.getTransaction().begin();
		TbMovimiento elim = emanager.merge(movimiento);
		emanager.remove(elim);
		System.out.println("movimiento eliminado de la bd");
		emanager.getTransaction().commit();
		emanager.close();			
	}

	@Override
	public TbMovimiento BuscarMovimiento(TbMovimiento movimiento) {
		EntityManagerFactory em = Persistence.createEntityManagerFactory("ProyectoBancario");
		EntityManager emanager = em.createEntityManager();
		emanager.getTransaction().begin();
		TbMovimiento buscar = emanager.find(TbMovimiento.class,movimiento.getCodtbMovimiento());
		emanager.getTransaction().commit();
		emanager.close();
		return buscar;
	}

	@Override
	public List<TbMovimiento> ListarMovimiento() {
		EntityManagerFactory em = Persistence.createEntityManagerFactory("ProyectoBancario");
		EntityManager emanager = em.createEntityManager();
		emanager.getTransaction().begin();
		List<TbMovimiento> listado = emanager.createQuery("select m from TbMovimiento m", TbMovimiento.class).getResultList();
		emanager.getTransaction().commit();
		emanager.close();
		return listado;
	}

}
