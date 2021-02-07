package org.pingu.shop.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Orders {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String date;
	

	@ManyToOne
	@JoinColumn(name="userID")
	private User user;
    
    @ManyToOne
    @JoinColumn(name="productID")
    private Product product;

	protected Orders() {}

	public Orders(User user, Product product, String date) {
		this.user = user;
		this.product = product;
        this.date = date;
	}

	@Override
	public String toString() {
		return String.format(
				"Orders[id=%d, userID=%d, productID='%s', date='%s']",
				id, user.getId(), product.getId(), date.toString());
	}
	
	public Long getId() {
		return id;
	}

	public Long getUserID() {
		return user.getId();
	}

	public Long getProductID() {
		return product.getId();
    }

    public String getDate() {
        return date;
    }
}