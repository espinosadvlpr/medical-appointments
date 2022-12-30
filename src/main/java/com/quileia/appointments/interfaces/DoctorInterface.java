package com.quileia.appointments.interfaces;

import com.quileia.appointments.models.Doctor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorInterface extends CrudRepository<Doctor, Integer> {
}