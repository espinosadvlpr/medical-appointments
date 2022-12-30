package com.quileia.appointments.controller;

import com.quileia.appointments.interfaceService.DoctorServiceInterface;
import com.quileia.appointments.interfaceService.PatientServiceInterface;
import com.quileia.appointments.models.Doctor;
import com.quileia.appointments.models.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class AppController {
    @Autowired
    private PatientServiceInterface patientService;
    @Autowired
    private DoctorServiceInterface doctorService;

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/patientsList")
    public String listPatients(Model model) {
        List<Patient> patientsList = patientService.listPatients();
        model.addAttribute("patientsList", patientsList);
        return "patients";
    }

    @GetMapping("/newPatient")
    public String createPatients(Model model) {
        model.addAttribute("patient", new Patient());
        return "patientsForm";
    }

    @PostMapping("/savePatient")
    public String savePatient(@Validated Patient patient, Model model) {
        patientService.savePatient(patient);
        return "redirect:/patientsList";
    }

    @GetMapping("/editPatient/{id}")
    public String editPatient(@PathVariable int id, Model model) {
        Optional<Patient> patient = patientService.listId(id);
        model.addAttribute("patient", patient);
        return "patientsForm";
    }

    @GetMapping("/deletePatient/{id}")
    public String deletePatient(@PathVariable int id, Model model) {
        patientService.deletePatient(id);
        return "redirect:/patientsList";
    }

    @GetMapping("/doctorsList")
    public String listDoctors(Model model) {
        List<Doctor> doctorsList = doctorService.listDoctors();
        model.addAttribute("doctorsList", doctorsList);
        return "doctors";
    }

    @GetMapping("/newDoctor")
    public String createDoctor(Model model) {
        model.addAttribute("doctor", new Doctor());
        return "doctorsForm";
    }

    @PostMapping("/saveDoctor")
    public String saveDoctor(@Validated Doctor doctor, Model model) {
        doctorService.saveDoctor(doctor);
        return "redirect:/doctorsList";
    }

    @GetMapping("/editDoctor/{id}")
    public String editDoctor(@PathVariable int id, Model model) {
        Optional<Doctor> doctor = doctorService.listId(id);
        model.addAttribute("doctor", doctor);
        return "doctorsForm";
    }

    @GetMapping("/deleteDoctor/{id}")
    public String deleteDoctor(@PathVariable int id, Model model) {
        doctorService.deleteDoctor(id);
        return "redirect:/patientsList";
    }
}