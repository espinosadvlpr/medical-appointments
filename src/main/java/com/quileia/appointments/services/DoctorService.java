package com.quileia.appointments.services;

import com.quileia.appointments.interfaceService.DoctorServiceInterface;
import com.quileia.appointments.interfaces.DoctorInterface;
import com.quileia.appointments.models.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService implements DoctorServiceInterface {
    @Autowired
    private DoctorInterface doctorInterface;

    @Override
    public List<Doctor> listDoctors() {
        return (List<Doctor>) doctorInterface.findAll();
    }

    @Override
    public Optional<Doctor> listId(int id) {
        return Optional.empty();
    }

    @Override
    public int saveDoctor(Doctor patient) {
        return 0;
    }

    @Override
    public void deleteDoctor(int id) {

    }
}
