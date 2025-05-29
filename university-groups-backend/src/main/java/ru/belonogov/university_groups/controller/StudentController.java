package ru.belonogov.university_groups.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.belonogov.university_groups.model.dto.StudentInputDto;
import ru.belonogov.university_groups.model.dto.StudentOutputDto;
import ru.belonogov.university_groups.model.entity.Student;
import ru.belonogov.university_groups.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/group/students/all")
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/group/{groupId}/students")
    public ResponseEntity<List<StudentOutputDto>> getStudents(@PathVariable Long groupId) {
        return ResponseEntity.ok(studentService.getStudents(groupId));
    }

    @PostMapping("/group/{groupId}/students")
    public ResponseEntity<StudentOutputDto> createStudent(
            @PathVariable Long groupId,
            @RequestBody @Valid StudentInputDto studentInputDto
    ) {
        return ResponseEntity.ok(studentService.createStudent(groupId, studentInputDto));
    }

    @PatchMapping("/group/{groupId}/students/{studentId}")
    public ResponseEntity<StudentOutputDto> patchStudent(
            @PathVariable Long groupId,
            @PathVariable Long studentId,
            @RequestBody @Valid StudentInputDto inputDto
    ) {
        return ResponseEntity.ok(studentService.patchStudent(groupId, studentId, inputDto));
    }

    @DeleteMapping("/group/{groupId}/students/{studentId}")
    public ResponseEntity<Boolean> deleteStudent(
            @PathVariable Long groupId,
            @PathVariable Long studentId
    ) {
        return ResponseEntity.ok(studentService.deleteStudent(groupId, studentId));
    }
}
