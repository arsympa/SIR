package sir.tp3;

import redis.clients.jedis.Jedis;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	//EXEMPLE 1 
    	//Jedis jedis = new Jedis("localhost");
        //jedis.set("foo", "bar");
        //String value = jedis.get("foo");
        //System.err.println(value);   
        
        
        //EXEMPLE 2
        
        Jedis jedis = new Jedis("localhost");
        System.out.println(jedis.get("counter"));
        jedis.incr("counter");
        System.out.println(jedis.get("counter"));
        
        //EXEMPLE 3 
        
        String cacheKey = "cachekey";
        Jedis jedis3 = new Jedis("localhost");
        // adding a new key
        jedis3.set(cacheKey, "cached value");
        // setting the TTL in seconds
        jedis3.expire(cacheKey, 15);
        // Getting the remaining ttl
        System.out.println("TTL:" + jedis3.ttl(cacheKey));
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        System.out.println("TTL:" + jedis3.ttl(cacheKey));
        // Getting the cache value
        System.out.println("Cached Value:" + jedis.get(cacheKey));
        // Wait for the TTL finishs
        try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // trying to get the expired key
        System.out.println("Expired Key:" + jedis3.get(cacheKey));
        
        
        //EXEMPLE 4 
        
        String cacheKey4 = "languages";
        Jedis jedis4 = new Jedis("localhost");
        // Adding a set as value
        jedis4.sadd(cacheKey4, "Java");
        jedis4.sadd(cacheKey4, "C#");
        jedis4.sadd(cacheKey4, "Python");// SADD
        // Getting all values in the set: SMEMBERS
        System.out.println("Languages: " + jedis4.smembers(cacheKey));
        // Adding new values
        jedis4.sadd(cacheKey, "Java");
        jedis4.sadd(cacheKey, "Ruby");
        // Getting the values... it doesn't allow duplicates
        System.out.println("Languages: " + jedis4.smembers(cacheKey4));

   
    
        
    }
}
