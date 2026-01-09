package org.skypro.hogwarts.model;
import jakarta.persistence.*;
@Entity
@Table(name = "student_table")

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "student_name", nullable = false)
    private String studentName;

    @Column(name = "age", nullable = false)
    private Integer age;

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public Integer getAge() {return age;}
    public void setAge(Integer age) {
        this.age = age;
    }
}