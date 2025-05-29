package ru.belonogov.university_groups.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.belonogov.university_groups.model.entity.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAllByGroupIdOrderByCreatedAtAsc(Long groupId);
}
