package ru.belonogov.university_groups.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.belonogov.university_groups.exception.GroupAlreadyExists;
import ru.belonogov.university_groups.exception.GroupNotFoundException;
import ru.belonogov.university_groups.mapper.GroupMapper;
import ru.belonogov.university_groups.model.dto.GroupInputDto;
import ru.belonogov.university_groups.model.dto.GroupOutputDto;
import ru.belonogov.university_groups.model.entity.Group;
import ru.belonogov.university_groups.model.entity.GroupStudentCount;
import ru.belonogov.university_groups.repository.GroupRepository;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class GroupService {

    private final GroupRepository groupRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public List<GroupStudentCount> getAllGroups() {
        return groupRepository.getGroupsWithStudentCounts();
    }

    public GroupOutputDto getGroupById(Long id) {
        return GroupMapper.groupToOutputDto(groupRepository.findById(id).orElseThrow(()
                -> new GroupNotFoundException(id)));
    }

    public GroupOutputDto createGroup(String groupName) {
        if (groupRepository.findByGroupName(groupName).isPresent()) {
            throw new GroupAlreadyExists();
        }
        Group group = new Group();
        group.setGroupName(groupName);
        return GroupMapper.groupToOutputDto(groupRepository.save(group));
    }

    public GroupOutputDto updateGroupById(Long groupId, GroupInputDto groupInput) {
        Optional<Group> groupOptional = groupRepository.findById(groupId);
        if (groupOptional.isEmpty()) {
            throw new GroupNotFoundException(groupId);
        }

        Group group = groupOptional.get();
        group.setGroupName(groupInput.getGroupName());
        return GroupMapper.groupToOutputDto(groupRepository.save(group));
    }

    public Boolean deleteGroup(Long groupId) {
        Optional<Group> group = groupRepository.findById(groupId);
        if (group.isEmpty()) {
            throw new GroupNotFoundException(groupId);
        }
        groupRepository.delete(group.get());
        return Boolean.TRUE;
    }

}
