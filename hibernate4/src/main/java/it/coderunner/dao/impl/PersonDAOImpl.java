package it.coderunner.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import it.coderunner.dao.PersonDAO;
import it.coderunner.model.Person;

@Repository
public class PersonDAOImpl implements PersonDAO {

	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
	public Person save(Person p) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(p);
		tx.commit();
		session.close();
		return p;
	}
	
	public Person update(Person p) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(p);
		tx.commit();
		session.close();
		return p;
	}

	@SuppressWarnings("unchecked")
	public List<Person> list() {
		Session session = this.sessionFactory.openSession();
		List<Person> personList = session.createQuery("from Person").list();
		session.close();
		return personList;
		 
	}
	
	public Person selectById(int id){
		Session session = this.sessionFactory.openSession();
		Person person  = (Person) session.createQuery("from Person where id="+id).uniqueResult();
		session.close();
		return person;
	}

}
