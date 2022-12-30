package com.quileia.appointments.repository;

import com.quileia.appointments.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "doctors", collectionResourceRel = "doctors")
public interface DoctorsRepository extends JpaRepository<Doctor, Integer> {
}
