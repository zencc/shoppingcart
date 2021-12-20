package com.mbis.shoppingcart.beans;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="CATEGORY")
public class Category {

	@Id
	@GeneratedValue
	private long id;
	
	private String name;
	private String superCategory;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy = "category")
	private Set<Product> products;
	
	public Category() {
	}

	public Category(long id, String name, String superCategory) {
		super();
		this.id = id;
		this.name = name;
		this.superCategory = superCategory;
		
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCategory() {
		return superCategory;
	}
}