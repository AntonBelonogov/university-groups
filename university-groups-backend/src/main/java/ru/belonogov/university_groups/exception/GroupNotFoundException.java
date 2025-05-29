package ru.belonogov.university_groups.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GroupNotFoundException extends RuntimeException {

    public GroupNotFoundException(Long id) {
        super("Group " + id + " not found");
        log.error("Group not found");
    }
}
