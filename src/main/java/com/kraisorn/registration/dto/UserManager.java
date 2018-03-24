/**
 * 
 */
package com.kraisorn.registration.dto;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * @author kraisorn
 *
 */
public class UserManager {
	protected SessionFactory sessionFactory;
	 
    public void setup() {
        // code to load Hibernate Session factory
    	//new Configuration().configure().buildSessionFactory().openSession();
    	final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
    			.configure()
    	        //.configure("/main/resources/hibernate.cfg.xml") // configures settings from hibernate.cfg.xml
    	        .build();
    	try {
    	    sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    	} catch (Exception ex) {
    	    StandardServiceRegistryBuilder.destroy(registry);
    	}
    }
 
    public void exit() {
        // code to close Hibernate Session factory
    	sessionFactory.close();
    }
 
    public void create(User user) {
        // code to save a user
     
        Session session = sessionFactory.openSession();
        session.beginTransaction();
     
        session.save(user);
     
        session.getTransaction().commit();
        session.close();
    }
 
    public User read(int id) {
        // code to get a user
    	Session session = sessionFactory.openSession();
    	 
        User user = session.get(User.class, id);
    
        session.close();
        
        return user;
    }
 
    public void update() {
        // code to modify a book
    }
 
    public void delete() {
        // code to remove a book
    }
 
    public static void main(String[] args) {
        // code to run the program
    }
}
