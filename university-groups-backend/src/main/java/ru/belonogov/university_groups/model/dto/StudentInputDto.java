package ru.belonogov.university_groups.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentInputDto {

    @Pattern(
            regexp = "^[А-ЯЁ][а-яё]+ [А-ЯЁ][а-яё]+( [А-ЯЁ][а-яё]+)?$",
            message = "Full name must be in the format 'Last name First name [Patronymic]'"
    )
    @NotBlank(message = "Student fio is required")
    private String fio;

}
