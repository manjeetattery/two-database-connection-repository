package com.javatpoint.repository1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.javatpoint.model1.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
