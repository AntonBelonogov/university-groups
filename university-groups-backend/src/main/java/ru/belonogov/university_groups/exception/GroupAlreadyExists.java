package ru.belonogov.university_groups.exception;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GroupAlreadyExists extends RuntimeException {

    public GroupAlreadyExists() {
        super("Group already exists");
        log.error("Group already exists");
    }
}
