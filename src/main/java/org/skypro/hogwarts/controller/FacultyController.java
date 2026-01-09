package org.skypro.hogwarts.controller;

import org.skypro.hogwarts.model.Faculty;
import org.skypro.hogwarts.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faculty")
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    // GET: все факультеты
    @GetMapping
    public List<Faculty> getAllFaculties() {
        return facultyService.getAllFaculties();
    }

    // POST: создать факультет
    @PostMapping
    public Faculty createFaculty(@RequestBody Faculty faculty) {
        return facultyService.saveFaculty(faculty);
    }

    // GET: факультет по ID
    @GetMapping("/{id}")
    public Faculty getFacultyById(@PathVariable Long id) {
        return facultyService.getFacultyById(id);
    }

    // PUT: обновить факультет по ID
    @PutMapping("/{id}")
    public Faculty updateFaculty(@PathVariable Long id, @RequestBody Faculty faculty) {
        faculty.setId(id);
        return facultyService.saveFaculty(faculty);
    }

    // DELETE: удалить факультет по ID
    @DeleteMapping("/{id}")
    public void deleteFaculty(@PathVariable Long id) {
        facultyService.deleteFaculty(id);
    }

}