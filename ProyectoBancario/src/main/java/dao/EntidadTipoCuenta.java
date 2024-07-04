package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import interfaces.ITipoCuenta;
import model.TbTipocuenta;

public class EntidadTipoCuenta implements ITipoCuenta{

	@Override
	public void RegistrarTipoCuenta(TbTipocuenta tipoCuenta) {
		EntityManagerFactory em = Persistence.createEntityManagerFactory("ProyectoBancario");
		EntityManager emanager = em.createEntityManager();
		emanager.getTransaction().begin();
		emanager.persist(tipoCuenta);
		System.out.println("Tipo cuenta registrado en la BD");
		emanager.getTransaction().commit();
		emanager.close();			
	}

	@Override
	public void ActualizarTipoCuenta(TbTipocuenta tipoCuenta) {
		EntityManagerFactory em = Persistence.createEntityManagerFactory("ProyectoBancario");
		EntityManager emanager = em.createEntityManager();
		emanager.getTransaction().begin();
		emanager.merge(tipoCuenta);
		System.out.println("Tipo cuenta actualizado en bd");
		emanager.getTransaction().commit();
		emanager.close();			
	}

	@Override
	public void EliminarTipoCuenta(TbTipocuenta tipoCuenta) {
		EntityManagerFactory em = Persistence.createEntityManagerFactory("ProyectoBancario");
		EntityManager emanager = em.createEntityManager();
		emanager.getTransaction().begin();
		TbTipocuenta elim = emanager.merge(tipoCuenta);
		emanager.remove(elim);
		System.out.println("tipo cuenta eliminado de la bd");
		emanager.getTransaction().commit();
		emanager.close();			
	}

	@Override
	public TbTipocuenta BuscarTipoCuenta(TbTipocuenta tipoCuenta) {
		EntityManagerFactory em = Persistence.createEntityManagerFactory("ProyectoBancario");
		EntityManager emanager = em.createEntityManager();
		emanager.getTransaction().begin();
		TbTipocuenta buscar = emanager.find(TbTipocuenta.class,tipoCuenta.getCodtbTipocuenta());
		emanager.getTransaction().commit();
		emanager.close();
		return buscar;
	}

	@Override
	public List<TbTipocuenta> ListarTipoCuenta() {
		EntityManagerFactory em = Persistence.createEntityManagerFactory("ProyectoBancario");
		EntityManager emanager = em.createEntityManager();
		emanager.getTransaction().begin();
		List<TbTipocuenta> listado = emanager.createQuery("select tc from TbTipoCuenta tc", TbTipocuenta.class).getResultList();
		emanager.getTransaction().commit();
		emanager.close();
		return listado;
	}

}
