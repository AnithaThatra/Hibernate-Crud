package com.hibernate.studentmain.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Service;

import com.hibernate.model.StudentRequest;
import com.hibernate.model.StudentResponse;
import com.hibernate.studentmain.entity.StudentEntity;
import com.hibernate.studentmain.hibernateutil.HibernateUtils;


@Service
public class StudentDataServiceImpl implements StudentDataService{
	static Session sessionObj;
    static SessionFactory sessionFactoryObj;
    

	@Override
	public StudentResponse addDetails(StudentRequest request) {
		Configuration config = new Configuration();
		config.addAnnotatedClass(com.hibernate.studentmain.entity.StudentEntity.class);
		config.addResource("hibernate.hbm.xml"); 
    	config.configure("hibernate.cfg.xml");
    	ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build(); 
    	sessionFactoryObj = config.buildSessionFactory(registry);
		StudentEntity studentDetails = null;
		StudentResponse studentResponse = new StudentResponse();
		try {
			sessionObj = sessionFactoryObj.openSession();
            sessionObj.beginTransaction();
            studentDetails = new StudentEntity();
            studentDetails.setId(request.getId());
            studentDetails.setStdname(request.getStdname());
            studentDetails.setStddept(request.getStddept());
            studentDetails.setStdrollno(request.getStdrollno());
            sessionObj.save(studentDetails);
            sessionObj.getTransaction().commit();
            studentResponse.setMessage("Successfully Inserted");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
            try {if(sessionObj != null) sessionObj.close();} catch(Exception e) {}
        }
		return studentResponse;
	}


	
	@SuppressWarnings("unchecked")
	@Override
	public List<StudentEntity> getAllDetails(){
		Configuration config = new Configuration();
		config.addAnnotatedClass(com.hibernate.studentmain.entity.StudentEntity.class);
		config.addResource("hibernate.hbm.xml"); 
    	config.configure("hibernate.cfg.xml");
    	ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build(); 
    	sessionFactoryObj = config.buildSessionFactory(registry);
		List<StudentEntity> studentList=null;
		
		try {
			sessionObj = sessionFactoryObj.openSession();
            sessionObj.beginTransaction();
            Query query = sessionObj.createQuery("from StudentEntity");
            studentList = query.list();
            for(StudentEntity studentEntity : studentList) {
            	System.out.println("StudentName:"+studentEntity.getStdname());
            }
            		
            sessionObj.getTransaction().commit();
            
			
		} catch (Exception e) {
			
		}
		
		return  studentList;
		 
        
    }


	@Override
	public StudentResponse updateDetails(StudentRequest studentRequest) {
		Configuration config = new Configuration();
		config.addAnnotatedClass(com.hibernate.studentmain.entity.StudentEntity.class);
		config.addResource("hibernate.hbm.xml"); 
    	config.configure("hibernate.cfg.xml");
    	ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build(); 
    	sessionFactoryObj = config.buildSessionFactory(registry);
		StudentEntity studentDetails = null;
		StudentResponse studentResponse = new StudentResponse();
		try {
			sessionObj = sessionFactoryObj.openSession();
            sessionObj.beginTransaction();
            studentDetails = new StudentEntity();
            if(studentDetails!=null) {
            studentDetails.setStdname(studentRequest.getStdname());
            studentDetails.setStddept(studentRequest.getStddept());
            studentDetails.setStdrollno(studentRequest.getStdrollno());
            sessionObj.update(studentDetails);
            sessionObj.getTransaction().commit();
            studentResponse.setMessage("Successfully Updated");
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
		 finally {
	            try {if(sessionObj != null) sessionObj.close();} catch(Exception e) {}
	        }
		
		return studentResponse;
	}


	@Override
	public StudentResponse deleteDetails(StudentRequest studentRequest) {
		Configuration config = new Configuration();
		config.addAnnotatedClass(com.hibernate.studentmain.entity.StudentEntity.class);
		config.addResource("hibernate.hbm.xml"); 
    	config.configure("hibernate.cfg.xml");
    	ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build(); 
    	sessionFactoryObj = config.buildSessionFactory(registry);
		
		StudentResponse studentResponse = new StudentResponse();
		try {
			sessionObj = sessionFactoryObj.openSession();
            sessionObj.beginTransaction();
            Query query = sessionObj.createQuery("Delete from StudentEntity where id="+studentRequest.getId());
			/* query.setInteger("id", studentRequest.getId()); */
            System.out.println(query.executeUpdate());
           sessionObj.getTransaction().commit();
           studentResponse.setMessage("Successfully Deleted");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
            try {if(sessionObj != null) sessionObj.close();} catch(Exception e) {}
        }
		return studentResponse;
	}



	@Override
	public StudentEntity getOneRecord(StudentRequest studentRequest) {
		Configuration config = new Configuration();
		config.addAnnotatedClass(com.hibernate.studentmain.entity.StudentEntity.class);
		config.addResource("hibernate.hbm.xml"); 
    	config.configure("hibernate.cfg.xml");
    	ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build(); 
    	sessionFactoryObj = config.buildSessionFactory(registry);
    	StudentEntity entity =null;
    	
    	try {
    		sessionObj = sessionFactoryObj.openSession();
            sessionObj.beginTransaction();
            
            entity = (StudentEntity) sessionObj.get(StudentEntity.class,studentRequest.getId());
            if(entity!=null) {
            	System.out.println("Student name: "+entity.getStdname()+""+"Student Dept:"+entity.getStddept()+""+"Student RollNo:"+entity.getStdrollno());
            }
            sessionObj.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(sessionObj!=null)
					sessionObj.close();
				
			} catch (Exception e) {
				
			}
		}
		
		return entity;
	}
	
	
}
