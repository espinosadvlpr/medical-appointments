package com.quileia.appointments.interfaceService;

import com.quileia.appointments.models.Appointment;
import java.util.List;

public interface AppointmentServiceInterface {
    public List<Appointment> listAppointments();
    public int saveAppointment(Appointment appointment);
}