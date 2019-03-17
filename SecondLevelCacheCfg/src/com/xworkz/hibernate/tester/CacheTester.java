package com.xworkz.hibernate.tester;

import com.xworkz.hibernate.dao.RestaurantDAO;
import com.xworkz.hibernate.dto.RestaurantDTO;
import com.xworkz.hibernate.util.HibernateUtil;

public class CacheTester {

	public static void main(String[] args) {
		
		RestaurantDAO dao = new RestaurantDAO();
		dao.getById(5);
		 
		 HibernateUtil.getFactory().close();

	}

}
