package com.quileia.appointments.interfaces;

import com.quileia.appointments.models.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientInterface extends CrudRepository<Patient, Integer> {
}