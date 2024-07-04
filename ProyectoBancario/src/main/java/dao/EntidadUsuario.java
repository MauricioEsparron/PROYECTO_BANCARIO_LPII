package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import interfaces.IUsuario;
import model.TbUsuario;


public class EntidadUsuario implements IUsuario{

	@Override
	public void RegistrarUsuario(TbUsuario usuario) {
		EntityManagerFactory em = Persistence.createEntityManagerFactory("ProyectoBancario");
		EntityManager emanager = em.createEntityManager();
		emanager.getTransaction().begin();
		emanager.persist(usuario);
		System.out.println("usuario registrado en la BD");
		emanager.getTransaction().commit();
		emanager.close();			
	}

	@Override
	public void ActualizarUsuario(TbUsuario usuario) {
		EntityManagerFactory em = Persistence.createEntityManagerFactory("ProyectoBancario");
		EntityManager emanager = em.createEntityManager();
		emanager.getTransaction().begin();
		emanager.merge(usuario);
		System.out.println("usuario actualizado en bd");
		emanager.getTransaction().commit();
		emanager.close();			
	}

	@Override
	public void EliminarUsuario(TbUsuario usuario) {
		EntityManagerFactory em = Persistence.createEntityManagerFactory("ProyectoBancario");
		EntityManager emanager = em.createEntityManager();
		emanager.getTransaction().begin();
		TbUsuario elim = emanager.merge(usuario);
		emanager.remove(elim);
		System.out.println("usuario eliminado de la bd");
		emanager.getTransaction().commit();
		emanager.close();		
	}

	@Override
	public TbUsuario BuscarUsuario(TbUsuario usuario) {
		EntityManagerFactory em = Persistence.createEntityManagerFactory("ProyectoBancario");
		EntityManager emanager = em.createEntityManager();
		emanager.getTransaction().begin();
		TbUsuario buscar = emanager.find(TbUsuario.class,usuario.getCodtbUsuario());
		emanager.getTransaction().commit();
		emanager.close();
		return buscar;
	}

	@Override
	public List<TbUsuario> ListarUsuario() {
		EntityManagerFactory em = Persistence.createEntityManagerFactory("ProyectoBancario");
		EntityManager emanager = em.createEntityManager();
		emanager.getTransaction().begin();
		List<TbUsuario> listado = emanager.createQuery("select u from TbUsuario u", TbUsuario.class).getResultList();
		emanager.getTransaction().commit();
		emanager.close();
		return listado;
	}

}
