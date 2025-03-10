package Test.Annotations;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;


public @interface Date {
    //напиши свой код
   int year();
   int month();
   int day();
   int hour();
   int minute();
   int second();
}
