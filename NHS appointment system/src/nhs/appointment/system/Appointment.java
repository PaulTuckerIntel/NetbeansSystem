package nhs.appointment.system;

import java.time.LocalTime;
import java.util.Date;

public class Appointment {

    protected Integer PatientID;
    protected Date Date;
    protected LocalTime Time;

    public Appointment(Integer PatientID, Date Date, LocalTime Time) {
        this.PatientID = PatientID;
        this.Date = Date;
        this.Time = Time;

    }

    public Integer getPatientID() {
        return PatientID;
    }

    public Date getDate() {
        return Date;
    }

    public LocalTime getTime() {
        return Time;
    }

    public void setPatientID(Integer PatientID) {
        this.PatientID = PatientID;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }

    public void setTime(LocalTime Time) {
        this.Time = Time;
    }

}
