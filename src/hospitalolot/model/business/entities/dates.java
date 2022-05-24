/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalolot.model.business.entities;

import java.time.LocalDate;
import static java.time.temporal.TemporalAdjusters.next;
import java.time.DayOfWeek;
import static java.time.DayOfWeek.SUNDAY;

/**
 *
 * @author Bernat
 */
public class dates {

    LocalDate data;

    public void crearGuardies() {
        LocalDate nextSunday = LocalDate.now();
        LocalDate anyQueVe = nextSunday.plusYears(1);
        if (nextSunday.getDayOfWeek() == SUNDAY) {

        } else {
            nextSunday = nextSunday.with(next(SUNDAY));
        }
        boolean arribaAny;
        do {
            if (nextSunday.compareTo(anyQueVe) == -1) {
                arribaAny = false;
            } else {
                arribaAny = true;
                Guardia g = new Guardia();
            }
        } while (arribaAny);
        nextSunday = nextSunday.with(next(SUNDAY));

    }
}
