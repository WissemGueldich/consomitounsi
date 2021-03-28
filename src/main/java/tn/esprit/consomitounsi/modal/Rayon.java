package tn.esprit.consomitounsi.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rayons")
public class Rayon {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "rayon_number")
	private int RayonNumber;
	@Column(name = "rayon_name")
	private String RayonName;
	@Column(name = "category")
	private String Category;
	
	
	
	public Rayon() {
		super();
	}
	public Rayon(long id, int rayonNumber, String rayonName, String category) {
		super();
		this.id = id;
		RayonNumber = rayonNumber;
		RayonName = rayonName;
		this.Category = category;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getRayonNumber() {
		return RayonNumber;
	}
	public void setRayonNumber(int rayonNumber) {
		RayonNumber = rayonNumber;
	}
	public String getRayonName() {
		return RayonName;
	}
	public void setRayonName(String rayonName) {
		RayonName = rayonName;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		this.Category = category;
	}
	

}
