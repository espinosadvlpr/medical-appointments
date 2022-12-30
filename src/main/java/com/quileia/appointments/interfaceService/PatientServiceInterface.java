package com.quileia.appointments.interfaceService;

import com.quileia.appointments.models.Patient;
import java.util.List;
import java.util.Optional;

public interface PatientServiceInterface {
    public List<Patient> listPatients();
    public Optional<Patient> listId(int id);
    public int savePatient(Patient patient);
    public void deletePatient(int id);
}