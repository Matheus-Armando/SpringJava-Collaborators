package com.rhconnect.collaborators.repository;

import com.rhconnect.collaborators.model.Occupation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface OccupationRepository extends JpaRepository<Occupation, Long> {
    Optional<Object> findById(UUID occupationId);
}