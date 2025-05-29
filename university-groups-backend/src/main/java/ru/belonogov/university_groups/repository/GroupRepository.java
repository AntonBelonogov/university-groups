package ru.belonogov.university_groups.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.belonogov.university_groups.model.entity.Group;
import ru.belonogov.university_groups.model.entity.GroupStudentCount;

import java.util.List;
import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

    Optional<Group> findByGroupName(String groupName);

    @Query("""
           SELECT g.id AS groupId, g.groupName AS groupName, COUNT(s.id) AS studentCount
           FROM Group g
           LEFT JOIN Student s ON s.group.id = g.id
           GROUP BY g.id, g.groupName
           ORDER BY g.groupName ASC
           """)
    List<GroupStudentCount> getGroupsWithStudentCounts();
}
