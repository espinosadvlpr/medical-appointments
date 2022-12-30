package com.quileia.appointments.services;

import com.quileia.appointments.interfaceService.AppointmentServiceInterface;
import com.quileia.appointments.interfaces.AppointmentInterface;
import com.quileia.appointments.interfaces.DoctorInterface;
import com.quileia.appointments.models.Appointment;
import com.quileia.appointments.models.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService implements AppointmentServiceInterface {
    @Autowired
    private AppointmentInterface appointmentInterface;
    @Autowired
    private DoctorInterface doctorInterface;

    @Override
    public List<Appointment> listAppointments() {
        return (List<Appointment>) appointmentInterface.findAll();
    }

    @Override
    public int saveAppointment(Appointment appointment) {
        int response = 0;
        Optional<Doctor> doctorOptional = doctorInterface.findById(appointment.getDoctor().getId());
        if (doctorOptional.isPresent()) {
            Doctor doctor = doctorOptional.get();
            int startHour = Integer.parseInt(doctor.getStartHour().substring(0, 2));
            int endHour = Integer.parseInt(doctor.getEndHour().substring(0, 2));
            int appointmentHour = Integer.parseInt(appointment.getAppointmentHour().substring(0, 2));
            if (appointmentHour >= startHour && appointmentHour <= endHour) {
                Appointment appointmentSaved = appointmentInterface.save(appointment);
                if (!appointmentSaved.equals(null)) {
                    response = 1;
                }
            }
        }
        return response;
    }
}