package it.coderunner.spring.data.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Car implements Serializable {

	
	private static final long serialVersionUID = 5907290236472250915L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String brand;

	@Column(nullable = false)
	private String color;
	
	public Car(String brand, String color){
		this.brand = brand;
		this.color = color;
	}

}