package com.quileia.appointments.controller;

import com.quileia.appointments.interfaceService.PatientServiceInterface;
import com.quileia.appointments.models.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping
public class AppController {
    @Autowired
    private PatientServiceInterface patientService;

    @GetMapping("/patientsList")
    public String listPatients(Model model) {
        List<Patient> patientsList = patientService.listPatients();
        model.addAttribute("patientsList", patientsList);
        return "patients";
    }

    @GetMapping("/newPatient")
    public String createPatients(Model model){
        model.addAttribute("patient",new Patient());
        return "patientsForm";
    }

    @PostMapping("/savePatient")
    public String save(@Validated Patient patient, Model model){
        patientService.savePatient(patient);
        return "redirect:/patientsList";
    }
}