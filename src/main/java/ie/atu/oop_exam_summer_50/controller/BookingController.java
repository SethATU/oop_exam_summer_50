/*
Bellow is the controller with each individual data in their own mapping
If the user inputs an incorrect data item they will get a bad request else it will go threw as normal

due to localhost:8080 not working and I don't want to accidentally use Google chromes AI or anything to loos marks, no testing was done
 */

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

    /// id must be greater than 0
    @GetMapping("/id")
    public ResponseEntity<?> reservationId(@RequestParam int id) {
        if(id < 0) {
            return ResponseEntity
                    .badRequest()
                    .body("id cant be a negative number");
        }
        else {
            int identity = bookingService.reservationId(id);
            return ResponseEntity.ok("User id: " + identity);
        }
    }

    ///  tag must be 3 digits long and cant be negative
    @GetMapping("/tag")
    public ResponseEntity<?> reservationTag(@RequestParam int tag) {
        if(tag > 999) {
            return ResponseEntity
                    .badRequest()
                    .body("Tag cant be larger than 3 digits");
        }
        else if(tag < 0) {
            return ResponseEntity
                    .badRequest()
                    .body("Tag cant be negative");
        }
        else {
            int TAG = bookingService.equipmentTag(tag);
            return ResponseEntity.ok("Equipment Tag: " + TAG);
        }
    }

    /// email must contain @atu.ie
    @GetMapping("/email")
    public ResponseEntity<?> studentEmail(@RequestParam String email) {
        if(email.contains("@atu.ie")) {
            String Email = bookingService.studentEmail(email);
            return ResponseEntity.ok("Student Email: " + Email);
        }
        else {
            return ResponseEntity
                    .badRequest()
                    .body("Student Email must end with @atu.ie");
        }
    }

    /// couldnt think of what to do for this one with errors
    @GetMapping("/date")
    public ResponseEntity<?> reservationDate(@RequestParam int date) {
        int DATE = bookingService.reservationDate(date);
        return ResponseEntity.ok("Reservation Date: " + DATE);
    }

    /// the start time must be within a 24 hour clock
    @GetMapping("/start")
    public ResponseEntity<?> startHour(@RequestParam int hour) {
        if(hour < 0 || hour > 23) {
            return ResponseEntity
                    .badRequest()
                    .body("Hour must be between 0 and 23");
        }
        else {
            int HOUR = bookingService.startHour(hour);
            return ResponseEntity.ok("Start Hour: " + HOUR);
        }
    }

    /// you cant stay for longer than 60 days, and it must be greater than 0 days
    @GetMapping("/duration")
    public ResponseEntity<?> durationHour(@RequestParam int duration) {
        if(duration < 0 || duration > 59) {
            int DURATION = bookingService.durationHours(duration);
            return ResponseEntity.ok("Duration: " + DURATION);
        }
        else {
            return ResponseEntity
                    .badRequest()
                    .body("Duration must be between 0 and 59 days");
        }
    }
}
