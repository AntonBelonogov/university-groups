package ru.belonogov.university_groups.model.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class StudentOutputDto {
    private Long id;

    private String fio;

    private Date createdAt;

    private Long groupId;
}
