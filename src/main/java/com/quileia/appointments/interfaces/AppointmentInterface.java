package com.quileia.appointments.interfaces;

import com.quileia.appointments.models.Appointment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentInterface extends CrudRepository<Appointment, Integer> {
}