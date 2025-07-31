package com;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Test {
	public static void main(String[] args) {
		testOneToOne();
	}

	public static void testEntityState() {


	}
	
	public static void attachedVsDetached() {
		
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Hib4PU");

		EntityManager em = emf.createEntityManager();

		/*
		em.getTransaction().begin();
		Indirizzo i = em.find(Indirizzo.class, 19);
	    System.out.println(i.getCitta());
	    
	    i.setCitta("Roma");//attached
	   	    
		em.getTransaction().commit();

		em.close();
		emf.close();
		
		
		  i.setCitta("Roma");//detached
		*/	
	}
	public static void testOneToOne() {
		
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Hib4PU");

		EntityManager em = emf.createEntityManager();
		
		
		Studente f = em.find(Studente.class, 20);
		
		System.out.println(f.getCognome());
		System.out.println(f.getInd().getCitta());
		

//		em.getTransaction().begin();
//
//		Indirizzo i1 = new Indirizzo();
//		i1.setVia("San Martino");
//		i1.setCitta("Milano");
//		em.persist(i1);
//
//		Studente u = new Studente();
//		u.setCognome("Pagano");
//		u.setNome("Antonio");
//		u.setInd(i1);
//		em.persist(u);

//		em.getTransaction().commit();
//
//		em.close();
//		emf.close();
//		
		
		
	}

	public static void testManyToOne() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Hib4PU");

		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		CorsoDiLaurea c = new CorsoDiLaurea();
		c.setFacolta("Informatica");
		em.persist(c);

		Studente u = new Studente();
		u.setCognome("Rossi");
		u.setNome("Mario");
		u.setCdl(c);
		em.persist(u);

		Studente u1 = new Studente();
		u1.setCognome("Bianchi");
		u1.setNome("Antonio");
		u1.setCdl(c);
		em.persist(u1);

		em.getTransaction().commit();

		em.close();
		emf.close();
	}

	public static void testManyToMany() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Hib4PU");

		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		Materia m = new Materia();
		m.setDescrizione("Informatica");
		em.persist(m);

		Set<Materia> l = new HashSet<Materia>();
		l.add(m);

		Studente u = new Studente();
		u.setCognome("Verdi");
		u.setNome("Giovanni");
		u.setMaterieSostenute(l);
		
		em.persist(u);

		em.getTransaction().commit();

		em.close();
		emf.close();
	}
}
