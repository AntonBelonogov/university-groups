package ru.belonogov.university_groups.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class GroupInputDto {

    @Pattern(regexp = "^\\d{2}-\\d{2}$\n", message = "The group number must be in the format '12-34'")
    @NotBlank(message = "Group number is required")
    private String groupName;

}
