package org.pingu.shop.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.time.*; 

@Entity
public class Orders {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
    private int quantity;
    private Float price;
	private LocalDateTime date;
	

	@ManyToOne
	@JoinColumn(name="userID")
	private User user;
    
    @ManyToOne
    @JoinColumn(name="productID")
    private Product product;
    

	protected Orders() {}

	public Orders(User user, Product product, int quantity, Float price, LocalDateTime date) {
		this.user = user;
		this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.date = date;
	}

	@Override
	public String toString() {
		return String.format(
				"Orders[id=%d, userID=%d, productID='%s', quantity=%d, price=%f, date='%s']",
				id, user.getId(), product.getId(), quantity, price ,date.toString());
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

    public int getQuantity() {
        return quantity;
    }

    public Float getPrice() {
        return price;
    }

    public LocalDateTime getDate() {
        return date;
    }
}