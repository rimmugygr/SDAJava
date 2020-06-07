package data.base.hibernate;


import data.base.hibernate.dao.PersonDAO;
import data.base.hibernate.pojo.Gender;
import data.base.hibernate.pojo.Person;

public class Test {
    public static void main(String[] args) {
        PersonDAO.getPeoples().forEach(System.out::println);
        PersonDAO.addPerson(new Person("xxxx","yyyy",999, Gender.M));
        PersonDAO.getPeoples().forEach(System.out::println);
        System.out.println(PersonDAO.getPeople(7L).toString());
    }
}
