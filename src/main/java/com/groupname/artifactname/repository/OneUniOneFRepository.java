package com.groupname.artifactname.repository;

import com.groupname.artifactname.entity.OneUniOneF;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OneUniOneFRepository extends JpaRepository<OneUniOneF,Integer> {
}
