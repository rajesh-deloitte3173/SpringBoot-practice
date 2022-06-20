package com.groupname.artifactname.repository;

import com.groupname.artifactname.entity.Employ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployRepository extends JpaRepository<Employ, Integer> {
}
