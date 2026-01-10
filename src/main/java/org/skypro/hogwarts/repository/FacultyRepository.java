package org.skypro.hogwarts.repository;

import org.skypro.hogwarts.model.Faculty;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    @Override
    List<Faculty> findAll(Sort sort);

    }
