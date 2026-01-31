package org.skypro.hogwarts.service;

import org.skypro.hogwarts.model.Student;
import org.skypro.hogwarts.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    // Приватное final-поле (неизменяемое)
    @Autowired
    private final StudentRepository studentRepository;
    // Конструктор для внедрения зависимости (через Spring)
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Создать нового студента
    public Student saveStudent(Student student) {
        // Валидация полей
        if (student.getStudentName() == null || student.getStudentName().trim().isEmpty()) {
            throw new IllegalArgumentException("Имя студента не может быть пустым");
        }
        if (student.getAge() == null || student.getAge() <= 0) {
            throw new IllegalArgumentException("Возраст должен быть положительным числом");
        }
        return studentRepository.save(student);
    }

    // Получить студента по ID
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Студент с ID " + id + " не найден"));
    }

    // Обновить студента по ID
    public Student updateStudent(Long id, Student student) {
        student.setId(id); // Привязываем ID к объекту
        return saveStudent(student); // Используем общую логику сохранения
    }

    // Удалить студента по ID
    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new IllegalArgumentException("Студент с ID " + id + " не найден");
        }
        studentRepository.deleteById(id);
    }

    public List<Student> getStudentsByAgeBetween(int minAge, int maxAge) {
        return studentRepository.findByAgeBetween(minAge, maxAge);
    }

    public List<Student> getStudentsByFacultyId(Long facultyId) {
        return studentRepository.findByFacultyId(facultyId);
    }
}