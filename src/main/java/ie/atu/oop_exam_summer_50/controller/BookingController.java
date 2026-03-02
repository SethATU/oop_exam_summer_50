package ie.atu.oop_exam_summer_50.controller;

import ie.atu.oop_exam_summer_50.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class BookingController {
    private final BookingService bookingService;
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/id")
    public ResponseEntity<?> reservationId(@RequestParam int id) {
        int identity = bookingService.reservationId(id);
        return ResponseEntity.ok("User id: " + identity);
    }

    @GetMapping("/tag")
    public ResponseEntity<?> reservationTag(@RequestParam int tag) {
        int TAG = bookingService.equipmentTag(tag);
        return ResponseEntity.ok("Equipment Tag: " + TAG);
    }

    @GetMapping("/email")
    public ResponseEntity<?> studentEmail(@RequestParam String email) {
        String Email = bookingService.studentEmail(email);
        return ResponseEntity.ok("Student Email: " + Email);
    }

    @GetMapping("/date")
    public ResponseEntity<?> reservationDate(@RequestParam int date) {
        int DATE = bookingService.reservationDate(date);
        return ResponseEntity.ok("Reservation Date: " + DATE);
    }
    @GetMapping("/start")
    public ResponseEntity<?> startHour(@RequestParam int hour) {
        int HOUR = bookingService.startHour(hour);
        return ResponseEntity.ok("Start Hour: " + HOUR);
    }

    @GetMapping("/duration")
    public ResponseEntity<?> durationHour(@RequestParam int duration) {
        int DURATION = bookingService.durationHours(duration);
        return ResponseEntity.ok("Duration: " + DURATION);
    }




}
