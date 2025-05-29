package ru.belonogov.university_groups.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StudentNotFoundException extends RuntimeException {

    private static final Logger log = LoggerFactory.getLogger(StudentNotFoundException.class);

    public StudentNotFoundException() {
        super("Student not found");
        log.error("Student not found");
    }
}
