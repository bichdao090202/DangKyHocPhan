package vn.edu.iuh.fit.lichhocservice.services;

import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;

@Service
public class LichHocService {
    public LocalDate getDateStartOfWeek(LocalDate date){
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        while (dayOfWeek.getValue() != 1){
            date = date.minusDays(1);
            dayOfWeek = date.getDayOfWeek();
        }
        return date;
    }
}
