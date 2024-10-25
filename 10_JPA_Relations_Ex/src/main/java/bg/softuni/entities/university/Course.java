package bg.softuni.entities.university;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    private String name;

    @Basic
    private String description;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Basic
    private int credits;

    @ManyToOne
    private Teacher teacher;

    @ManyToMany
    @JoinTable(
        name = "mapping_table_name",
        joinColumns = @JoinColumn(name = "course_to_mapping"),
        inverseJoinColumns = @JoinColumn(name = "student_to_mapping")
    )
    private Set<Student> students;

    public Course() {}
}
