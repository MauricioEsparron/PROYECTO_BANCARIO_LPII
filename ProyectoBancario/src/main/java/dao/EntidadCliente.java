package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import interfaces.ICliente;
import model.TbCliente;

public class EntidadCliente implements ICliente{

	@Override
	public void RegistrarCliente(TbCliente cliente) {
		EntityManagerFactory em = Persistence.createEntityManagerFactory("ProyectoBancario");
		EntityManager emanager = em.createEntityManager();
		emanager.getTransaction().begin();
		emanager.persist(cliente);
		System.out.println("cliente registrado en la BD");
		emanager.getTransaction().commit();
		emanager.close();		
	}

	@Override
	public void ActualizarCliente(TbCliente cliente) {
		EntityManagerFactory em = Persistence.createEntityManagerFactory("ProyectoBancario");
		EntityManager emanager = em.createEntityManager();
		emanager.getTransaction().begin();
		emanager.merge(cliente);
		System.out.println("cliente actualizado en bd");
		emanager.getTransaction().commit();
		emanager.close();			
	}

	@Override
	public void EliminarCliente(TbCliente cliente) {
		EntityManagerFactory em = Persistence.createEntityManagerFactory("ProyectoBancario");
		EntityManager emanager = em.createEntityManager();
		emanager.getTransaction().begin();
		TbCliente elim = emanager.merge(cliente);
		emanager.remove(elim);
		System.out.println("cliente eliminado de la bd");
		emanager.getTransaction().commit();
		emanager.close();			
	}

	@Override
	public TbCliente BuscarCliente(TbCliente cliente) {
		EntityManagerFactory em = Persistence.createEntityManagerFactory("ProyectoBancario");
		EntityManager emanager = em.createEntityManager();
		emanager.getTransaction().begin();
		TbCliente buscar = emanager.find(TbCliente.class,cliente.getCodtbCliente());
		emanager.getTransaction().commit();
		emanager.close();
		return buscar;
	}

	@Override
	public List<TbCliente> ListarCliente() {
		EntityManagerFactory em = Persistence.createEntityManagerFactory("ProyectoBancario");
		EntityManager emanager = em.createEntityManager();
		emanager.getTransaction().begin();
		List<TbCliente> listado = emanager.createQuery("select c from TbCliente c", TbCliente.class).getResultList();
		emanager.getTransaction().commit();
		emanager.close();
		return listado;
	}

}
