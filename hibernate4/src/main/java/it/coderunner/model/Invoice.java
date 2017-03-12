package it.coderunner.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "INVOICE")
public class Invoice 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int nr;
	@Column(name="invoice")
	private String dok;
	@ManyToOne
	@JoinColumn(name="id1")
	private Person person;
	
	public Person getPerson()
	{
		return person;
	}
	
	public void setPerson(Person person)
	{
		this.person= person;
	}
	
	public int getNr() {
		return nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}

	public String getDok() {
		return dok;
	}

	public void setDok(String dok) {
		this.dok = dok;
	}
	
}
