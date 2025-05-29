package ru.belonogov.university_groups.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.belonogov.university_groups.exception.GroupNotFoundException;
import ru.belonogov.university_groups.exception.StudentNotFoundException;
import ru.belonogov.university_groups.mapper.StudentMapper;
import ru.belonogov.university_groups.model.dto.StudentInputDto;
import ru.belonogov.university_groups.model.dto.StudentOutputDto;
import ru.belonogov.university_groups.model.entity.Group;
import ru.belonogov.university_groups.model.entity.Student;
import ru.belonogov.university_groups.repository.GroupRepository;
import ru.belonogov.university_groups.repository.StudentRepository;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class StudentService {

    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository, GroupRepository groupRepository) {
        this.studentRepository = studentRepository;
        this.groupRepository = groupRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public List<StudentOutputDto> getStudents(Long groupId) {
        if (groupRepository.findById(groupId).isEmpty()) {
            throw new GroupNotFoundException(groupId);
        }
        return studentRepository.findAllByGroupIdOrderByCreatedAtAsc(groupId).stream()
                .map(StudentMapper::toOutputDto)
                .toList();
    }

    public StudentOutputDto createStudent(Long groupId, StudentInputDto studentInputDto) {
        Group group = groupRepository.findById(groupId).orElseThrow(()
                -> new GroupNotFoundException(groupId)
        );
        Student student = new Student();
        student.setGroup(group);
        student.setFio(studentInputDto.getFio());
        return StudentMapper.toOutputDto(studentRepository.save(student));
    }

    public StudentOutputDto patchStudent(Long groupId, Long studentId, StudentInputDto inputDto) {
        if (groupRepository.findById(groupId).isEmpty()) {
            throw new GroupNotFoundException(groupId);
        }

        Student student = studentRepository.findById(studentId).orElseThrow(StudentNotFoundException::new);
        if (inputDto.getFio() != null) {
            student.setFio(inputDto.getFio());
        }
        student.setCreatedAt(new Date());

        return StudentMapper.toOutputDto(studentRepository.save(student));
    }

    public Boolean deleteStudent(Long groupId, Long studentId) {
        if (groupRepository.findById(groupId).isEmpty()) {
            throw new GroupNotFoundException(groupId);
        }
        if (studentRepository.findById(studentId).isEmpty()) {
            throw new StudentNotFoundException();
        }

        studentRepository.deleteById(studentId);
        return Boolean.TRUE;
    }
}
