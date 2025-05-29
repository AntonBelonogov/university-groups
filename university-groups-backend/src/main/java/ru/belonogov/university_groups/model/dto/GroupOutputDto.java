package ru.belonogov.university_groups.model.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GroupOutputDto {

    private Long id;

    private String groupName;

    private Integer studentCount;

    private List<StudentOutputDto> students;
}
