package com.ngopitit.crudapp;

import com.ngopitit.crudapp.entity.Person;
import com.ngopitit.crudapp.repository.PersonDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
public class CrudappApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudappApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(PersonDAO dao) {
        return runner -> {
            updateData(dao);
        };
    }

    public void saveData(PersonDAO dao) {
        Person obj1 = new Person("ฐิติพงศ์", "แก้วคำ");
        dao.save(obj1);
        System.out.println("Insert Complete");
    }

    public void deleteData(PersonDAO dao) {
        int[] id = {4, 5, 6, 7};
        for (int i : id) {
            dao.delete(i);
            System.out.printf("Delete %d Complete", i);
        }
    }

    public void getData(PersonDAO dao){
        int id = 1;
        Person person = dao.get(id);
        System.out.println(person);
    }

    public void getAllData(PersonDAO dao){
        List<Person> data = dao.getAll();
        for (Person person: data) {
            System.out.println(person);
        }
    }

    public void updateData(PersonDAO dao){
        int id = 1;
        Person myPerson = dao.get(id);
        myPerson.setFname("Titipong");
        dao.update(myPerson);

        System.out.println("Update Successfully");
    }
}
