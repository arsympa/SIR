package sir.tp3;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity("article")
public class Product {
	
	@Id
	private ObjectId idProduct;
	
	String nameProduct;
	
	int priceProduct;

	public ObjectId getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(ObjectId idProduct) {
		this.idProduct = idProduct;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public int getPriceProduct() {
		return priceProduct;
	}

	public void setPriceProduct(int priceProduct) {
		this.priceProduct = priceProduct;
	}
	
	
}
