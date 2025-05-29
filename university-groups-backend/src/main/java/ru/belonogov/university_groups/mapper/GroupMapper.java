package ru.belonogov.university_groups.mapper;

import ru.belonogov.university_groups.model.dto.GroupOutputDto;
import ru.belonogov.university_groups.model.dto.StudentOutputDto;
import ru.belonogov.university_groups.model.entity.Group;

import java.util.List;

public class GroupMapper {

    public static GroupOutputDto groupToOutputDto(Group group) {
        List<StudentOutputDto> studentOutputDtoList = group.getStudentList().stream()
                .map(StudentMapper::toOutputDto)
                .toList();

        return GroupOutputDto.builder()
                .id(group.getId())
                .groupName(group.getGroupName())
                .studentCount(studentOutputDtoList.size())
                .students(studentOutputDtoList)
                .build();
    }
}
