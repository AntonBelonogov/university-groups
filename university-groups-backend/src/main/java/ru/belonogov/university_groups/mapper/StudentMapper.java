package ru.belonogov.university_groups.mapper;

import ru.belonogov.university_groups.model.dto.StudentOutputDto;
import ru.belonogov.university_groups.model.entity.Student;

public class StudentMapper {

    public static StudentOutputDto toOutputDto(Student student) {
        return StudentOutputDto.builder()
                .id(student.getId())
                .fio(student.getFio())
                .createdAt(student.getCreatedAt())
                .groupId(student.getGroup().getId() != null ? student.getGroup().getId() : null)
                .build();
    }
}
