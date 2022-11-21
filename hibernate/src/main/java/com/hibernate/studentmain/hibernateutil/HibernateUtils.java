package com.hibernate.studentmain.hibernateutil;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {
	
	private static SessionFactory sessionFactoryObj = null;
	
	static {
        try{
            loadSessionFactory();
        }catch(Exception e){
            System.err.println("Exception while initializing hibernate util.. ");
            e.printStackTrace();
        }
    }
	
	public static void loadSessionFactory(){
		 
		Configuration config = new Configuration();
		config.addAnnotatedClass(com.hibernate.studentmain.entity.StudentEntity.class);
		config.addResource("hibernate.hbm.xml"); 
    	config.configure("hibernate.cfg.xml");
        ServiceRegistry srvcReg = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        sessionFactoryObj = config.buildSessionFactory(srvcReg);
    }
	
	 public static Session getSession() throws HibernateException {
		 
		 Session sessionObj=null;
	            try {
	            	sessionObj=sessionFactoryObj.openSession();
	            }catch(Throwable t){
	            System.err.println("Exception while getting session.. ");
	            t.printStackTrace();
	            }
	            if(sessionObj == null) {
	                System.err.println("session is discovered null");
	            }
	 
	            return sessionObj;
	    }

}
