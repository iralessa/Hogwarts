package org.skypro.hogwarts.model;

import jakarta.persistence.*;

@Entity
@Table(name = "faculty_table")
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_faculty")
    private Long id;
    @Column(name = "color_faculty", nullable = false)
    private String color;

    @Column(name = "name_faculty", nullable = false)
    private String name;

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
