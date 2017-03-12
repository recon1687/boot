package it.coderunner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import it.coderunner.dao.InvoiceDAO;
import it.coderunner.dao.PersonDAO;
import it.coderunner.model.Invoice;
import it.coderunner.model.Person;

public class SpringHibernateMain {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

		PersonDAO personDAO = context.getBean(PersonDAO.class);

		Person person = new Person();
		person.setName("Michał");
		person.setCountry("Poland");

		System.out.println(personDAO.save(person));

		System.out.println("Person::" + person);
		int i =1;
		personDAO.list().forEach(System.out::println);
		System.out.println(personDAO.selectById(i));
		
		Person update=personDAO.selectById(i);
		update.setName("Paweł");
		personDAO.update(update);
		
		InvoiceDAO invoiceDAO = context.getBean(InvoiceDAO.class);
		Invoice invoice = new Invoice();
		invoice.setDok("Faktura");
		invoice.setPerson(person);
		
		Invoice invoice1 = new Invoice();
		invoice1.setDok("dokument");
		invoice1.setPerson(person);
		
		
		invoiceDAO.save(invoice);
		invoiceDAO.save(invoice1);
		
		System.out.println("Invoice::" + invoice);

		invoiceDAO.list().forEach(System.out::println);

		context.close();
	}

}
