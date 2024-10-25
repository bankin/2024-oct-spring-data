package bg.softuni;

import bg.softuni.entities.gringotts.WizardDeposit;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.Instant;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("jpa-ex");

        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

//        WizardDeposit wizardDeposit =
//                new WizardDeposit(20, "Pesho", (short) 12, "Alabala", Instant.now());
//        em.persist(wizardDeposit);
//
//        WizardDeposit wizardDeposit = em.find(WizardDeposit.class, 1);
//
//        System.out.println(wizardDeposit);



        em.getTransaction().commit();
        em.close();
    }
}