package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import interfaces.IEmpleado;
import model.TbEmpleado;

public class EntidadEmpleado implements IEmpleado{

	@Override
	public void RegistrarEmpleado(TbEmpleado empleado) {
		EntityManagerFactory em = Persistence.createEntityManagerFactory("ProyectoBancario");
		EntityManager emanager = em.createEntityManager();
		emanager.getTransaction().begin();
		emanager.persist(empleado);
		System.out.println("empleado registrado en la BD");
		emanager.getTransaction().commit();
		emanager.close();	
		
	}

	@Override
	public void ActualizarEmpleado(TbEmpleado empleado) {
		EntityManagerFactory em = Persistence.createEntityManagerFactory("ProyectoBancario");
		EntityManager emanager = em.createEntityManager();
		emanager.getTransaction().begin();
		emanager.merge(empleado);
		System.out.println("empleado actualizado en bd");
		emanager.getTransaction().commit();
		emanager.close();	
		
	}

	@Override
	public void EliminarEmpleado(TbEmpleado empleado) {
		EntityManagerFactory em = Persistence.createEntityManagerFactory("ProyectoBancario");
		EntityManager emanager = em.createEntityManager();
		emanager.getTransaction().begin();
		TbEmpleado elim = emanager.merge(empleado);
		emanager.remove(elim);
		System.out.println("empleado eliminado de la bd");
		emanager.getTransaction().commit();
		emanager.close();			
	}

	@Override
	public TbEmpleado BuscarEmpleado(TbEmpleado empleado) {
		EntityManagerFactory em = Persistence.createEntityManagerFactory("ProyectoBancario");
		EntityManager emanager = em.createEntityManager();
		emanager.getTransaction().begin();
		TbEmpleado buscar = emanager.find(TbEmpleado.class,empleado.getCodtbEmpleado());
		emanager.getTransaction().commit();
		emanager.close();
		return buscar;
	}

	@Override
	public List<TbEmpleado> ListarEmpleado() {
		EntityManagerFactory em = Persistence.createEntityManagerFactory("ProyectoBancario");
		EntityManager emanager = em.createEntityManager();
		emanager.getTransaction().begin();
		List<TbEmpleado> listado = emanager.createQuery("select e from TbEmpleado e", TbEmpleado.class).getResultList();
		emanager.getTransaction().commit();
		emanager.close();
		return listado;
	}

}
