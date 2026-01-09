package org.skypro.hogwarts.service;

import org.skypro.hogwarts.model.Faculty;
import org.skypro.hogwarts.repository.FacultyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyService {

    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public List<Faculty> getAllFaculties() {
        return facultyRepository.findAll();
    }

    public Faculty saveFaculty(Faculty faculty) {
        if (faculty.getName() == null || faculty.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Название факультета не может быть пустым");
        }
        if (faculty.getColor() == null || faculty.getColor().trim().isEmpty()) {
            throw new IllegalArgumentException("Цвет факультета не может быть пустым");
        }
        return facultyRepository.save(faculty);
    }

    public Faculty getFacultyById(Long id) {
        return facultyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Факультет с ID " + id + " не найден"));
    }
    public void deleteFaculty(Long id) {
        facultyRepository.deleteById(id);
    }

}