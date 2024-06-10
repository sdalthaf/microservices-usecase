package com.codevthme.HospitalsOnPanel.repository;
import com.codevthme.HospitalsOnPanel.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long> {
}

