package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		System.out.println("Welcome...");
		Configuration cfg = new Configuration().configure("hibernate.config.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		//
	}
}
