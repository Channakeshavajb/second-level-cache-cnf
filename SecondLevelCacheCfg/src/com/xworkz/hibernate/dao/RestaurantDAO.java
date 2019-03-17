package com.xworkz.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.xworkz.hibernate.dto.RestaurantDTO;
import com.xworkz.hibernate.util.HibernateUtil;

public class RestaurantDAO {

	public RestaurantDAO() {
		// TODO Auto-generated constructor stub

		System.out.println("created \t" + this.getClass().getSimpleName());
	}

	public void save(RestaurantDTO dto) {
		System.out.println("saving restaurant \t" + dto);
		SessionFactory factory = HibernateUtil.getFactory();
		System.out.println(factory != null ? "factory found" : "factory not found");
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

		try {
			System.out.println("saving dto with session \t" + dto.getName());
			session.save(dto);
			transaction.commit();
			System.out.println("saving dto was successfully \t" + dto.getName());

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.err.println("exception saving dto \t" + dto.getName());
		} finally {
			session.close();
			System.out.println("closing only session");
		}

	}

	public RestaurantDTO getById(int rid) {
		
		Session session = HibernateUtil.getFactory().openSession();
		
		
		try {
			// session calling second time
			RestaurantDTO dtoFromDb =(RestaurantDTO) session.load(RestaurantDTO.class, rid);
			if(dtoFromDb != null) {
				System.out.println("data found for id::\t"+ rid);
				System.out.println(dtoFromDb);
			}
			else
			{
				System.out.println("dto not found for id:\t" + rid);
			}
			session.close();
			
			//session calling first second time
			
			Session session1 = HibernateUtil.getFactory().openSession();
			RestaurantDTO dtoFromDb1 =(RestaurantDTO) session1.load(RestaurantDTO.class, rid);
			if(dtoFromDb1 != null) {
				System.out.println("data found for id::\t"+ rid);
				System.out.println(dtoFromDb1);
			}
			else
			{
				System.out.println("dto not found for id:\t" + rid);
				
			}
			session1.close();
			
		} 
		catch (Exception e) {
			e.printStackTrace();
			System.err.println("exception fetching data");
		}
		return null;

	}

}
