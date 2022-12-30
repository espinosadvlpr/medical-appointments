package com.quileia.appointments.services;

import com.quileia.appointments.interfaceService.PatientServiceInterface;
import com.quileia.appointments.interfaces.PatientInterface;
import com.quileia.appointments.models.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService implements PatientServiceInterface {
    @Autowired
    private PatientInterface patientInterface;

    @Override
    public List<Patient> listPatients() {
        return (List<Patient>) patientInterface.findAll();
    }

    @Override
    public Optional<Patient> listId(int id) {
        return patientInterface.findById(id);
    }

    @Override
    public int savePatient(Patient patient) {
        int response=0;
        Patient patientSaved = patientInterface.save(patient);
        if (!patientSaved.equals(null)){
            response=1;
        }
        return response;
    }

    @Override
    public void deletePatient(int id) {
        patientInterface.deleteById(id);
    }
}