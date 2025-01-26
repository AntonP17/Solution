package Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataTimeExapmle {


}

class LocalDataExample {

    public static void main(String[] args) {

        // сегодня в Росии дата
        LocalDate today = LocalDate.now();
        System.out.println("Сегодня в России - " + today);

        // сегодня в шанхае дата
        ZoneId timezone = ZoneId.of("Asia/Shanghai");
        LocalDate shanghai = LocalDate.now(timezone);
        System.out.println("Сегодня в Шанхае - " + shanghai);

        // будущая дата , день года на примере 2025 год 134 день
        LocalDate future = LocalDate.ofYearDay(2025,134);
        System.out.println("Будущее - " + future);
        System.out.println();

        // анализ сегодняшней даты получение дня недели, номерр месяца, день года , год
        LocalDate now = LocalDate.now();
        System.out.println("Сегодня - " + now.getDayOfWeek());
        System.out.println(now.getDayOfMonth());
        System.out.println(now.getMonthValue());
        System.out.println(now.getDayOfYear());
        System.out.println(now.getYear());
        System.out.println();

        // мой ДР прошедший , следующий , самый первый
        LocalDate birthday = LocalDate.of(2024,7,17);
        LocalDate nextBirthday = birthday.plusYears(1);
        LocalDate firstBirthday = birthday.minusYears(27);
        System.out.println("Мой ДР прошедший - " + birthday + ", День недели - " + birthday.getDayOfWeek() + "\n"
                + "Мой ДР в след году - " + nextBirthday + ", День недели - " + nextBirthday.getDayOfWeek() + "\n"
                + "Мой др самый первый - " + firstBirthday + ", День недели - " + firstBirthday.getDayOfWeek());
        System.out.println();


        // вывод информации с  методов ниже
        System.out.println(nowExample());
        System.out.println(ofExample());
        System.out.println(ofYearDayExample());
        System.out.println(ofEpochDayExample());
        System.out.println();



    }


    // дата сегодня
    static LocalDate nowExample() {
        //напишите тут ваш код
        LocalDate today = LocalDate.now();

        return today;
    }

    // получение даты 12.9.2020
    static LocalDate ofExample() {
        //напишите тут ваш код
        LocalDate pastDate = LocalDate.of(2020, 9, 12);

        return pastDate;
    }


    // получение день года по счету даты 12.09.2020
    static LocalDate ofYearDayExample() {
        //напишите тут ваш код
        LocalDate pastDate2 = LocalDate.ofYearDay(2020, ofExample().getDayOfYear());

        return pastDate2;
    }

    // получение дней Unix от даты 12.09.2020
    static LocalDate ofEpochDayExample() {
        //напишите тут ваш код
        LocalDate pastDate3 = LocalDate.ofEpochDay(ofExample().toEpochDay());
        return pastDate3;
    }
}


class LocalTimeWxample {
    public static void main(String[] args) {

        // время сейчас
        LocalTime noday = LocalTime.now();
        System.out.println(noday);
        System.out.println();

        // определенное время
        LocalTime time = LocalTime.of(12, 15);
        System.out.println(time);
        System.out.println();

        // 1000 секунда
        LocalTime time1 = LocalTime.ofSecondOfDay(1000);
        System.out.println(time1);
        System.out.println();

        // получение данных времени час, минута, секунда
        System.out.println(noday.getHour());
        System.out.println(noday.getMinute());
        System.out.println(noday.getSecond());
        System.out.println();

        //добавление времени
        LocalTime now = LocalTime.now();
        LocalTime now2 = now.plusHours(2);
        LocalTime now3 = now.minusMinutes(40);
        LocalTime now4 = now.plusSeconds(3600);

        System.out.println("Сейчас - " + now);
        System.out.println("Прибавляем 2 часа - " + now2);
        System.out.println("Вычитаем 40 мин - " + now3);
        System.out.println("Прибавляем 3600 сек - " + now4);
        System.out.println();


        // все временные зоны для ZoneId
        for(String s : ZoneId.getAvailableZoneIds()){
            System.out.println(s);
        }
        System.out.println();

        ZoneId zone1 = ZoneId.of("Asia/Shanghai");
        ZonedDateTime zone2 = ZonedDateTime.now(zone1);
        System.out.println(zone2);
        System.out.println();





    }
}

class DateTimeFormatterExample {

    static LocalDateTime localDateTime = LocalDateTime.now();
    static ZonedDateTime zonedDateTime = ZonedDateTime.now();

    public static void main(String[] args) {
        // формат текущей даты
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyyг. Hч.mмин.");
        String text = dtf.format(localDateTime);
        System.out.println(text);
        System.out.println();

        //формат даты времени и зоны
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("c d.M.yy HH:mm:ss.n VV");
        String text2 = dtf2.format(zonedDateTime);
        System.out.println(text2);
        System.out.println();

        // парсинг строки в дату
        DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("MMMM-dd-yyyy", Locale.ENGLISH);
        LocalDate date = LocalDate.parse("February-23-2019", dtf3);
        System.out.println(date);

        //парсинг строки во время
        DateTimeFormatter dtf4 = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime time = LocalTime.parse("23:59:59", dtf4);
        System.out.println(time);
        System.out.println();

        //еще создание шаблона и форматирование
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("H:m:s dd/MM/yyyy");
        String timeString = "13:30:45 23/02/2019";
        LocalDateTime dateTime = LocalDateTime.parse(timeString, dateTimeFormatter);
        System.out.println(dateTime);
    }
}