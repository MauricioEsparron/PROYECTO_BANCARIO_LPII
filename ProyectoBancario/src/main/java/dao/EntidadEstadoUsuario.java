package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import interfaces.IEstadoUsuario;
import model.TbEstadousuario;

public class EntidadEstadoUsuario implements IEstadoUsuario{

	@Override
	public void RegistrarEstadoUsuario(TbEstadousuario estadoUsuario) {
		EntityManagerFactory em = Persistence.createEntityManagerFactory("ProyectoBancario");
		EntityManager emanager = em.createEntityManager();
		emanager.getTransaction().begin();
		emanager.persist(estadoUsuario);
		System.out.println("Estado usuario registrado en la BD");
		emanager.getTransaction().commit();
		emanager.close();			
	}

	@Override
	public void ActualizarEstadoUsuario(TbEstadousuario estadoUsuario) {
		EntityManagerFactory em = Persistence.createEntityManagerFactory("ProyectoBancario");
		EntityManager emanager = em.createEntityManager();
		emanager.getTransaction().begin();
		emanager.merge(estadoUsuario);
		System.out.println("estado usuario actualizado en bd");
		emanager.getTransaction().commit();
		emanager.close();			
	}

	@Override
	public void EliminarEstadoUsuario(TbEstadousuario estadoUsuario) {
		EntityManagerFactory em = Persistence.createEntityManagerFactory("ProyectoBancario");
		EntityManager emanager = em.createEntityManager();
		emanager.getTransaction().begin();
		TbEstadousuario elim = emanager.merge(estadoUsuario);
		emanager.remove(elim);
		System.out.println("estado usuario eliminado de la bd");
		emanager.getTransaction().commit();
		emanager.close();			
	}

	@Override
	public TbEstadousuario BuscarEstadoUsuario(TbEstadousuario estadoUsuario) {
		EntityManagerFactory em = Persistence.createEntityManagerFactory("ProyectoBancario");
		EntityManager emanager = em.createEntityManager();
		emanager.getTransaction().begin();
		TbEstadousuario buscar = emanager.find(TbEstadousuario.class,estadoUsuario.getCodtbEstadousuario());
		emanager.getTransaction().commit();
		emanager.close();
		return buscar;
	}

	@Override
	public List<TbEstadousuario> ListarEstadoUsuario() {
		EntityManagerFactory em = Persistence.createEntityManagerFactory("ProyectoBancario");
		EntityManager emanager = em.createEntityManager();
		emanager.getTransaction().begin();
		List<TbEstadousuario> listado = emanager.createQuery("select eu from TbEstadousuario eu", TbEstadousuario.class).getResultList();
		emanager.getTransaction().commit();
		emanager.close();
		return listado;
	}

}
