package com.uncledavecode;

import com.uncledavecode.config.MyPersistenceUnitInfo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import com.uncledavecode.entities.Student;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<String, String> properties = new HashMap<>();
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql", "true");

        try (EntityManagerFactory entityManagerFactory
                     = new HibernatePersistenceProvider().createContainerEntityManagerFactory(new MyPersistenceUnitInfo(), properties)) {

            /* EntityManager -> Persistence Context */
            EntityManager em = entityManagerFactory.createEntityManager();

            em.getTransaction().begin();

//            Student student1 = new Student();
//            student1.setId(1L);
//            student1.setName("Uncle Dave Code");
//
//            em.persist(student1);

            Student student1 = em.find(Student.class, 1L);
            student1.setName("Test NAME");

            Student student2 = em.find(Student.class, 1L);

            System.out.println(student1 == student2);


            em.getTransaction().commit();

//            em.persist();
//            em.merge();
//            em.remove();
//            em.find();
//            em.refresh();
//            em.detach();
//            em.clear();
//            em.getReference();
//            em.flush();


        }
    }
}