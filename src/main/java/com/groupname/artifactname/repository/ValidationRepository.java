package com.groupname.artifactname.repository;

import com.groupname.artifactname.entity.Validations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValidationRepository extends JpaRepository<Validations, Integer> {
}
