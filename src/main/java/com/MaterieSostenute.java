package com;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class MaterieSostenute {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;
	private int idStudente;
	private int idMateria;
	
	//nel caso mi servano ad oggetti
//	//bi-directional many-to-one association to Materia
//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name="id_materia")
//	private Materia materia;
//
//	//bi-directional many-to-one association to Studente
//	@ManyToOne
//	@JoinColumn(name="id_studente")
//	private Studente st;
	
	
	private int voto;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdStudente() {
		return idStudente;
	}
	public void setIdStudente(int idStudente) {
		this.idStudente = idStudente;
	}
	public int getIdMateria() {
		return idMateria;
	}
	public void setIdMateria(int idMateria) {
		this.idMateria = idMateria;
	}
	public int getVoto() {
		return voto;
	}
	public void setVoto(int voto) {
		this.voto = voto;
	}
	
	

}
