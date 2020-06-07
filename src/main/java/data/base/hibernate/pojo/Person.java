package data.base.hibernate.pojo;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "people")
public class Person {
        @Id
        @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;

        @Column(name="first_name")
        private String firstName;

        @Column(name="last_name")
        private String lastName;

        @Column(name="age")
        private int age;

        @Column(name="gender")
        @Enumerated(EnumType.STRING)
        private Gender gender;

        @Transient
        private transient byte[] image;

        public Person(String firstName, String lastName, int age, Gender gender) {
                this.firstName = firstName;
                this.lastName = lastName;
                this.age = age;
                this.gender = gender;
        }

        public Person() {
        }


        public String getLastName() {
                return lastName;
        }

        public void setLastName(String lastName) {
                this.lastName = lastName;
        }

        public int getAge() {
                return age;
        }

        public void setAge(int age) {
                this.age = age;
        }

        public long getId() {
                return id;
        }

        public void setId(long id) {
                this.id = id;
        }

        public String getFirstName() {
                return firstName;
        }

        public void setFirstName(String firstName) {
                this.firstName = firstName;
        }

        public Gender getGender() {
                return gender;
        }

        public void setGender(Gender gender) {
                this.gender = gender;
        }

        public byte[] getImage() {
                return image;
        }

        public void setImage(byte[] image) {
                this.image = image;
        }

        @Override
        public String toString() {
                return "Person{" +
                        "id=" + id +
                        ", firstName='" + firstName + '\'' +
                        ", lastName='" + lastName + '\'' +
                        ", age=" + age +
                        ", gender=" + gender +
                        ", image=" + Arrays.toString(image) +
                        '}';
        }
}
