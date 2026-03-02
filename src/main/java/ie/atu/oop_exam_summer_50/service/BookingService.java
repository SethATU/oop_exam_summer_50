package ie.atu.oop_exam_summer_50.service;

public class BookingService {
    private int reservationId;
    private int equipmentTag;
    private String studentEmail;
    private int reservationDate;
    private int startHour;
    private int durationHours;

    public BookingService(int reservationId, int equipmentTag, String studentEmail, int reservationDate, int startHour, int durationHours ) {
        this.reservationId = reservationId;
        this.equipmentTag = equipmentTag;
        this.studentEmail = studentEmail;
        this.reservationDate = reservationDate;
        this.startHour = startHour;
        this.durationHours = durationHours;
    }

    public int getReservationId() { return reservationId; }
    public int getEquipmentTag() { return equipmentTag; }
    public String getStudentEmail() { return studentEmail; }
    public int getReservationDate() { return reservationDate; }
    public int getStartHour() { return startHour; }
    public int getDurationHours() { return durationHours; }
}
