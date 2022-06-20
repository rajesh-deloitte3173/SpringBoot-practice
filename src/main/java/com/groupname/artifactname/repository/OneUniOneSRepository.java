package com.groupname.artifactname.repository;

import com.groupname.artifactname.entity.OneUniOneS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OneUniOneSRepository extends JpaRepository<OneUniOneS,Integer> {
}
