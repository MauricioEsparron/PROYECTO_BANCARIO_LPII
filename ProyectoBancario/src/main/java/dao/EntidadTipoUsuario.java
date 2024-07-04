package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import interfaces.ITipoUsuario;
import model.TbTipousuario;

public class EntidadTipoUsuario implements ITipoUsuario{

	@Override
	public void RegistrarTipoUsuario(TbTipousuario tipoUsuario) {
		EntityManagerFactory em = Persistence.createEntityManagerFactory("ProyectoBancario");
		EntityManager emanager = em.createEntityManager();
		emanager.getTransaction().begin();
		emanager.persist(tipoUsuario);
		System.out.println("tipo usuario registrado en la BD");
		emanager.getTransaction().commit();
		emanager.close();			
	}

	@Override
	public void ActualizarTipoUsuario(TbTipousuario tipoUsuario) {
		EntityManagerFactory em = Persistence.createEntityManagerFactory("ProyectoBancario");
		EntityManager emanager = em.createEntityManager();
		emanager.getTransaction().begin();
		emanager.merge(tipoUsuario);
		System.out.println("tipo usuario actualizado en bd");
		emanager.getTransaction().commit();
		emanager.close();			
	}

	@Override
	public void EliminarTipoUsuario(TbTipousuario tipoUsuario) {
		EntityManagerFactory em = Persistence.createEntityManagerFactory("ProyectoBancario");
		EntityManager emanager = em.createEntityManager();
		emanager.getTransaction().begin();
		TbTipousuario elim = emanager.merge(tipoUsuario);
		emanager.remove(elim);
		System.out.println("tipo usuario eliminado de la bd");
		emanager.getTransaction().commit();
		emanager.close();			
	}

	@Override
	public TbTipousuario BuscarTipoUsuario(TbTipousuario tipoUsuario) {
		EntityManagerFactory em = Persistence.createEntityManagerFactory("ProyectoBancario");
		EntityManager emanager = em.createEntityManager();
		emanager.getTransaction().begin();
		TbTipousuario buscar = emanager.find(TbTipousuario.class,tipoUsuario.getCodtbTipousuario());
		emanager.getTransaction().commit();
		emanager.close();
		return buscar;
	}

	@Override
	public List<TbTipousuario> ListarTipoUsuario() {
		EntityManagerFactory em = Persistence.createEntityManagerFactory("ProyectoBancario");
		EntityManager emanager = em.createEntityManager();
		emanager.getTransaction().begin();
		List<TbTipousuario> listado = emanager.createQuery("select tu from TbTipoUsuario tu", TbTipousuario.class).getResultList();
		emanager.getTransaction().commit();
		emanager.close();
		return listado;
	}

}
