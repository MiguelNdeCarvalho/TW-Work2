package org.pingu.shop.jpa;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
    private String name, imgPath, desc;
    private Float price;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<Orders> orders;

    protected Product() {}

    public Product(String name, String imgPath, String desc, Float price) {
        this.name = name;
        this.imgPath = imgPath;
        this.desc = desc;
        this.price = price;
    }

    @Override
	public String toString() {
		return String.format(
				"Product[id=%d, name='%s', imgPath='%s', description='%s', price=%f€]",
				id, name, imgPath, desc, price);
	}
    
    public Long getId() {
		return id;
    }
    
    public String getName() {
        return name;
    }

    public String getImgPath() {
        return imgPath;
    }
    
    public String getDesc() {
        return desc;
    }

    public float getPrice() {
        return price;
    }
}