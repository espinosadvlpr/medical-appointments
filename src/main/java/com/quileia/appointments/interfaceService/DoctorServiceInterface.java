package com.quileia.appointments.interfaceService;

import com.quileia.appointments.models.Doctor;
import java.util.List;
import java.util.Optional;

public interface DoctorServiceInterface {
    public List<Doctor> listDoctors();
    public Optional<Doctor> listId(int id);
    public int saveDoctor(Doctor patient);
    public void deleteDoctor(int id);
}