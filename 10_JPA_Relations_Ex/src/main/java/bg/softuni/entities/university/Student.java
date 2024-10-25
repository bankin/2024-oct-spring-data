package bg.softuni.entities.university;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "students")
public class Student extends Person {
    @Column(name = "average_grade")
    private double averageGrade;

    @Basic
    private int attendance;

    @ManyToMany(mappedBy = "students")
    private List<Course> courses;

    public Student() {
        super();
    }

}
