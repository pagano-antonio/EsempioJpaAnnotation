package com;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Studente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int matricola;

	private String nome;
	private String cognome;
		
	
	//private int id_indirizzo;
	
	
//	select * 
//	from studente, indirizzo
//	where
//	studente.idIndirizzo = indirizzo.id and
	//studente.matricola = 3
	
	
	@OneToOne
	@JoinColumn(name = "id_indirizzo")
	private Indirizzo ind;
	
	
	
	

	@ManyToOne
	@JoinColumn(name = "id_corso_laurea")
	private CorsoDiLaurea cdl;

	
	
	
	
	
	
	
	@ManyToMany
	@JoinTable(name = "MATERIE_SOSTENUTE", 
	joinColumns = @JoinColumn(name = "id_studente"), 
	inverseJoinColumns = @JoinColumn(name = "id_materia"))
	private Set<Materia> materieSostenute;
	
	
//	//bi-directional many-to-one association to MaterieSostenute
//	@OneToMany(mappedBy="studente")
//	private List<MaterieSostenute> materieSostenutes;


	public int getMatricola() {
		return matricola;
	}

	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}



	public Indirizzo getInd() {
		return ind;
	}

	public void setInd(Indirizzo ind) {
		this.ind = ind;
	}



	public CorsoDiLaurea getCdl() {
		return cdl;
	}

	public void setCdl(CorsoDiLaurea cdl) {
		this.cdl = cdl;
	}

	public Set<Materia> getMaterieSostenute() {
		return materieSostenute;
	}

	public void setMaterieSostenute(Set<Materia> materieSostenute) {
		this.materieSostenute = materieSostenute;
	}

}
