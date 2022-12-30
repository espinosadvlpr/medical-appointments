package com.quileia.appointments.services;

import com.quileia.appointments.interfaceService.AppointmentServiceInterface;
import com.quileia.appointments.interfaces.AppointmentInterface;
import com.quileia.appointments.models.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AppointmentService implements AppointmentServiceInterface {

    @Autowired
    private AppointmentInterface appointmentInterface;

    @Override
    public List<Appointment> listAppointments() {
        return (List<Appointment>) appointmentInterface.findAll();
    }

    @Override
    public int saveAppointment(Appointment appointment) {
        int response = 0;
        Appointment appointmentSaved = appointmentInterface.save(appointment);
        if (!appointmentSaved.equals(null)) {
            response = 1;
        }
        return response;
    }
}