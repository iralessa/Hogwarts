package org.skypro.hogwarts.controller;

import org.skypro.hogwarts.model.Student;
import org.skypro.hogwarts.repository.StudentRepository;
import org.skypro.hogwarts.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }
    // GET: студент по ID
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }


    // PUT: обновить студента по ID
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    // DELETE: удалить студента по ID
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    @GetMapping("/age")
    public List<Student> getStudentsByAge(
            @RequestParam int min,
            @RequestParam int max) {
        return studentService.getStudentsByAgeBetween(min, max);
    }

    // Получить всех студентов факультета по ID факультета
    @GetMapping("/facultyId/{facultyId}")
    public List<Student> getStudentsByFaculty(@PathVariable Long facultyId) {
        return studentService.getStudentsByFacultyId(facultyId);
    }
}
