package bg.softuni.entities.betting;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic(optional = false)
    private String name;

    @Column(name = "squad_number")
    private int squadNumber;

    @ManyToOne
    private Position position;

    @Column(name = "is_injured", nullable = false)
    private boolean isInjured;

//    private Team team;

    public Player(String name, int squadNumber, Position position, boolean isInjured) {
        this.name = name;
        this.squadNumber = squadNumber;
        this.position = position;
        this.isInjured = isInjured;
    }
}
