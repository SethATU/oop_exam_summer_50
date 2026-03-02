/*
Service layer for mini microservice
Each item takes in data and should save to Array list however i have forgotten how to make and use array list
 */
package ie.atu.oop_exam_summer_50.service;

import org.springframework.stereotype.Service;

@Service
public class BookingService {
    public int reservationId(int id) { return id; }
    public int equipmentTag(int tag) { return tag; }
    public String studentEmail(String email) { return email; }
    public int reservationDate(int date) { return date; }
    public int startHour(int start) { return start; }
    public int durationHours(int hour) { return hour; }
}
