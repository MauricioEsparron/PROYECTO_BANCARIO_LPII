package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import interfaces.IEstadoTarjeta;
import model.TbEstadotarjeta;

public class EntidadEstadoTarjeta implements IEstadoTarjeta{

	@Override
	public void RegistrarEstadoTarjeta(TbEstadotarjeta estadoTarjeta) {
		EntityManagerFactory em = Persistence.createEntityManagerFactory("ProyectoBancario");
		EntityManager emanager = em.createEntityManager();
		emanager.getTransaction().begin();
		emanager.persist(estadoTarjeta);
		System.out.println("Estado tarjeta registrado en la BD");
		emanager.getTransaction().commit();
		emanager.close();	
		
	}

	@Override
	public void ActualizarEstadoTarjeta(TbEstadotarjeta estadoTarjeta) {
		EntityManagerFactory em = Persistence.createEntityManagerFactory("ProyectoBancario");
		EntityManager emanager = em.createEntityManager();
		emanager.getTransaction().begin();
		emanager.merge(estadoTarjeta);
		System.out.println("estado tarjeta actualizado en bd");
		emanager.getTransaction().commit();
		emanager.close();			
	}

	@Override
	public void EliminarEstadoTarjeta(TbEstadotarjeta estadoTarjeta) {
		EntityManagerFactory em = Persistence.createEntityManagerFactory("ProyectoBancario");
		EntityManager emanager = em.createEntityManager();
		emanager.getTransaction().begin();
		TbEstadotarjeta elim = emanager.merge(estadoTarjeta);
		emanager.remove(elim);
		System.out.println("estado tarjeta eliminado de la bd");
		emanager.getTransaction().commit();
		emanager.close();			
	}

	@Override
	public TbEstadotarjeta BuscarEstadoTarjeta(TbEstadotarjeta estadoTarjeta) {
		EntityManagerFactory em = Persistence.createEntityManagerFactory("ProyectoBancario");
		EntityManager emanager = em.createEntityManager();
		emanager.getTransaction().begin();
		TbEstadotarjeta buscar = emanager.find(TbEstadotarjeta.class,estadoTarjeta.getCodtbEstadotarjeta());
		emanager.getTransaction().commit();
		emanager.close();
		return buscar;
	}

	@Override
	public List<TbEstadotarjeta> ListarEstadoTarjeta() {
		EntityManagerFactory em = Persistence.createEntityManagerFactory("ProyectoBancario");
		EntityManager emanager = em.createEntityManager();
		emanager.getTransaction().begin();
		List<TbEstadotarjeta> listado = emanager.createQuery("select et from TbEstadotarjeta et", TbEstadotarjeta.class).getResultList();
		emanager.getTransaction().commit();
		emanager.close();
		return listado;
	}

}
