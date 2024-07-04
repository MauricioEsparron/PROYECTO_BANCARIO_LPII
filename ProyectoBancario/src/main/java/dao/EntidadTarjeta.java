package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import interfaces.ITarjeta;
import model.TbTarjeta;

public class EntidadTarjeta implements ITarjeta{

	@Override
	public void RegistrarTarjeta(TbTarjeta tarjeta) {
		EntityManagerFactory em = Persistence.createEntityManagerFactory("ProyectoBancario");
		EntityManager emanager = em.createEntityManager();
		emanager.getTransaction().begin();
		emanager.persist(tarjeta);
		System.out.println("tarjeta registrado en la BD");
		emanager.getTransaction().commit();
		emanager.close();			
	}

	@Override
	public void ActualizarTarjeta(TbTarjeta tarjeta) {
		EntityManagerFactory em = Persistence.createEntityManagerFactory("ProyectoBancario");
		EntityManager emanager = em.createEntityManager();
		emanager.getTransaction().begin();
		emanager.merge(tarjeta);
		System.out.println("tarjeta actualizado en bd");
		emanager.getTransaction().commit();
		emanager.close();			
	}

	@Override
	public void EliminarTarjeta(TbTarjeta tarjeta) {
		EntityManagerFactory em = Persistence.createEntityManagerFactory("ProyectoBancario");
		EntityManager emanager = em.createEntityManager();
		emanager.getTransaction().begin();
		TbTarjeta elim = emanager.merge(tarjeta);
		emanager.remove(elim);
		System.out.println("tarjeta eliminado de la bd");
		emanager.getTransaction().commit();
		emanager.close();			
	}

	@Override
	public TbTarjeta BuscarTarjeta(TbTarjeta tarjeta) {
		EntityManagerFactory em = Persistence.createEntityManagerFactory("ProyectoBancario");
		EntityManager emanager = em.createEntityManager();
		emanager.getTransaction().begin();
		TbTarjeta buscar = emanager.find(TbTarjeta.class,tarjeta.getNumtbTarjeta());
		emanager.getTransaction().commit();
		emanager.close();
		return buscar;
	}

	@Override
	public List<TbTarjeta> ListarTarjeta() {
		EntityManagerFactory em = Persistence.createEntityManagerFactory("ProyectoBancario");
		EntityManager emanager = em.createEntityManager();
		emanager.getTransaction().begin();
		List<TbTarjeta> listado = emanager.createQuery("select t from TbTarjeta t", TbTarjeta.class).getResultList();
		emanager.getTransaction().commit();
		emanager.close();
		return listado;
	}

}
