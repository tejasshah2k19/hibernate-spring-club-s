package com;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.bean.BookBean;

public class App {
	public static void main(String[] args) {
		System.out.println("Welcome...");
		Configuration cfg = new Configuration().configure("hibernate.config.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Scanner scr = new Scanner(System.in);
		// how to insert
		// how to list
		while (true) {
			System.out.println("0 for exit");
			System.out.println("1 for insert");
			System.out.println("2 for list");
			System.out.println("Enter your choice");
			int choice = scr.nextInt();
			switch (choice) {
			case 0:
				System.exit(0);
			case 1:
				System.out.println("enter book Name");
				String bookName = scr.next();
				System.out.println("Enter price");
				float price = scr.nextInt();
				System.out.println("Enter qty");
				int qty = scr.nextInt();
				System.out.println("Enter author Name");
				String author = scr.next();
				BookBean book = new BookBean();
				book.setAuthor(author);
				book.setBookName(bookName);
				book.setPrice(price);
				book.setQty(qty);

				Session session = sf.openSession();
				Transaction tx = session.beginTransaction();// insert update delete

				session.save(book);// insert
				tx.commit();
				session.close();
				break;
			case 2:
				session = sf.openSession();
				// sql
				Query q = session.createQuery("From BookBean");// select * from book
				List<BookBean> books = q.getResultList();//
				for (BookBean x : books) {
					System.out.println(x.getBookId() + " " + x.getBookName() + " " + x.getQty());
				}
				session.close();
				break;
			}// switch
		}
	}// main
}// class
