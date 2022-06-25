package com.groupname.artifactname.repository;

import com.groupname.artifactname.entity.CurdPractice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurdPracticeRepository extends JpaRepository<CurdPractice, Integer> {
}
