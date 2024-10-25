package bg.softuni;

import bg.softuni.entities.betting.Player;
import bg.softuni.entities.betting.Position;
import bg.softuni.entities.betting.PositionEnum;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class BettingMain {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("jpa-ex");

        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

//        Position p1 = new Position(PositionEnum.GK, "Goal Keeper");
//        Position p2 = new Position(PositionEnum.MF, "Mid");
//        Position p3 = new Position(PositionEnum.FW, "Forward");
//
//        em.persist(p1);
//        em.persist(p2);
//        em.persist(p3);

//        Position p4 = new Position(PositionEnum.CAM, "Central Attacking");
//        em.persist(p4);

//        Position position = em.find(Position.class, PositionEnum.FW);
//
//        System.out.println(position.getDescription());
//
//        Player attack = new Player("Attack", 9, position, false);
//
//        em.persist(attack);

        em.getTransaction().commit();
        em.close();
    }
}
