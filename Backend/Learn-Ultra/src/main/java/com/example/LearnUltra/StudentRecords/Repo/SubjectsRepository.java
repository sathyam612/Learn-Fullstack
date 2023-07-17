package com.example.LearnUltra.StudentRecords.Repo;

import com.example.LearnUltra.StudentRecords.Entity.Subjects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectsRepository extends JpaRepository<Subjects,Long> {
}
