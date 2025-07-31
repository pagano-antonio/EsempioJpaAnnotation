package com;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Materia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;
	private String descrizione;

	// se serve il eager
	//@ManyToOne(fetch = FetchType.EAGER)
    
	
    @ManyToMany
   @JoinTable(
           name="MATERIE_SOSTENUTE",
        		   joinColumns = @JoinColumn(name = "id_materia"), 
        		   inverseJoinColumns = @JoinColumn(name = "id_studente"))	
    private Set<Studente> studenti;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Set<Studente> getStudenti() {
		return studenti;
	}

	public void setStudenti(Set<Studente> studenti) {
		this.studenti = studenti;
	}

}
