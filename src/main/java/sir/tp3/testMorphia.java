package sir.tp3;

import java.net.UnknownHostException;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;

public class testMorphia {

	public static void main(String[] args) throws UnknownHostException {
		Morphia morphia = new Morphia();
		MongoClient mongo = new MongoClient();
		morphia.map(Person.class).map(Address.class);
		Datastore ds = morphia.createDatastore(mongo, "my_database");

		Person p = new Person();
//		p.setName("Tintin");
//		Address address = new Address();
//		address.setStreet("123 Some street");
//		address.setCity("Some city");
//		address.setPostCode("123 456");
//		address.setCountry("Some country");
		// set address
		//p.setAddress(address);
		//ds.save(address);
		// Save the POJO
		ds.save(p);
		
		
		/**
		 * Ajout Article
		 */
		
//		Product product = new Product();
//		product.setNameProduct("patte");
//		product.setPriceProduct(200);
		
		//ds.save(product);
		for (Person e : ds.find(Person.class)) {
			System.err.println(e.getName());
		}
		for (Address address : ds.find(Address.class)) {
			System.err.println(address.postCode);
		}
	
		for (Product products : ds.find(Product.class)) {
			System.err.println(products.getNameProduct());
		}
}
}
