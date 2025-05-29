package ru.belonogov.university_groups.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.belonogov.university_groups.model.dto.GroupInputDto;
import ru.belonogov.university_groups.model.dto.GroupOutputDto;
import ru.belonogov.university_groups.model.entity.GroupStudentCount;
import ru.belonogov.university_groups.service.GroupService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/group")
public class GroupController {

    private final GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<GroupStudentCount>> getAllGroups() {
        return ResponseEntity.ok(groupService.getAllGroups());
    }

    @GetMapping("/{groupId}")
    public ResponseEntity<GroupOutputDto> getGroupById(@PathVariable Long groupId) {
        return ResponseEntity.ok(groupService.getGroupById(groupId));
    }

    @PostMapping
    public ResponseEntity<GroupOutputDto> createGroup(@RequestBody @Valid GroupInputDto groupInput) {
        return ResponseEntity.ok(groupService.createGroup(groupInput.getGroupName()));
    }

    @PatchMapping("/{groupId}")
    public ResponseEntity<GroupOutputDto> updateGroup(
            @PathVariable Long groupId,
            @RequestBody @Valid GroupInputDto groupInput
    ) {
        return ResponseEntity.ok(groupService.updateGroupById(groupId, groupInput));
    }

    @DeleteMapping("/{groupId}")
    public ResponseEntity<Boolean> deleteGroup(@PathVariable Long groupId) {
        return ResponseEntity.ok(groupService.deleteGroup(groupId));
    }
}