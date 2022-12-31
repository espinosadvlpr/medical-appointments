package com.quileia.appointments.services;

import com.quileia.appointments.interfaceService.AppointmentServiceInterface;
import com.quileia.appointments.interfaces.AppointmentInterface;
import com.quileia.appointments.interfaces.DoctorInterface;
import com.quileia.appointments.models.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        return validateAppointment(appointment);
    }

    private int validateAppointment(Appointment appointment) {
        int response = 0;
        if (hourInRange(appointment) && !hourAvaliable(appointment)) {
            Appointment appointmentSaved = appointmentInterface.save(appointment);
            if (!appointmentSaved.equals(null)) {
                response = 200;
            }
        }
        return response;
    }

    private boolean hourInRange(Appointment appointment) {
        int appointmentHour = getHourFromString(appointment.getAppointmentHour());
        return (appointmentHour >= getHourFromString(appointment.getDoctor().getStartHour())
                && appointmentHour <= getHourFromString(appointment.getDoctor().getEndHour()));
    }

    private boolean hourAvaliable(Appointment appointment) {
        List<Appointment> appointmentList = listAppointments();
        for (Appointment appointmentInList : appointmentList) {
            if (appointmentInList.getDoctor().getId() == appointment.getDoctor().getId()
                    && appointmentInList.getAppointmentDay().equals(appointment.getAppointmentDay())) {
                return (appointmentInList.getAppointmentHour().equals(appointment.getAppointmentHour()));
            }
        }
        return false;
    }

    private int getHourFromString(String hour) {
        return Integer.parseInt(hour.substring(0, 2));
    }
}