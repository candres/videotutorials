package com.project.mb;

import javax.faces.bean.ManagedBean;

import org.hibernate.Session;

import com.project.entities.Client;
import com.project.utils.HibernateUtil;

@ManagedBean
public class ClientMB {
	private String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void guardarCliente() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Client cliente = new Client(nombre);
		session.save(cliente);
		session.getTransaction().commit();
		session.close();
	}
}
