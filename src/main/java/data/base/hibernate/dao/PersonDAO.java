package data.base.hibernate.dao;

import data.base.hibernate.pojo.Person;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class PersonDAO {

    public static void addPerson(Person person) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.save(person);

        transaction.commit();
        session.close();
    }
    public static Person getPeople(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query query = session.createQuery("select p from Person p where p.id=:id");
        query.setParameter("id", id);
        Person people = (Person) query.getSingleResult();
        session.close();
        return people;
    }

    public static List<Person> getPeoples() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Person> people = session.createQuery("select p from Person p").list();

        session.close();
        return people;
    }

}
