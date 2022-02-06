package dateapi;

import java.time.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateApi {

    private List<Data> data = new ArrayList<>();

    public static void main (String[] args) {
        new DateApi().addData();
    }

    public void addData () {
        ZoneId defaultTime = ZoneId.of("UTC+4");

        ZoneId sysTime = ZoneId.systemDefault();

        LocalDateTime timeDef = LocalDateTime.now(defaultTime);

        LocalDateTime timeSys = LocalDateTime.now(sysTime);

        Integer hour = timeSys.getHour() - timeDef.getHour();

        Integer minute = timeSys.getMinute() - timeDef.getMinute();

        data.add(new Data(1, "Example-1",
                LocalDateTime.of(2021, Month.JANUARY, 16, 8, 0)));
        data.add(new Data(2, "Example-2",
                LocalDateTime.of(2021, Month.FEBRUARY, 16, 8, 0)));
        data.add(new Data(3, "Example-3",
                LocalDateTime.of(2021, Month.MARCH, 16, 8, 0)));
        data.add(new Data(4, "Example-4",
                LocalDateTime.of(2021, Month.APRIL, 16, 8, 0)));
        data.add(new Data(5, "Example-5",
                LocalDateTime.of(2021, Month.MAY, 16, 8, 0)));
        data.add(new Data(6, "Example-6",
                LocalDateTime.of(2021, Month.JUNE, 16, 8, 0)));
        data.add(new Data(7, "Example-7",
                LocalDateTime.of(2021, Month.JULY, 16, 8, 0)));
        data.add(new Data(8, "Example-8",
                LocalDateTime.of(2021, Month.AUGUST, 16, 8, 0)));
        data.add(new Data(9, "Example-9",
                LocalDateTime.of(2021, Month.SEPTEMBER, 16, 8, 0)));
        data.add(new Data(10, "Example-10",
                LocalDateTime.of(2021, Month.OCTOBER, 16, 8, 0)));
        data.add(new Data(11, "Example-11",
                LocalDateTime.of(2021, Month.NOVEMBER, 16, 8, 0)));
        data.add(new Data(12, "Example-12",
                LocalDateTime.of(2021, Month.DECEMBER, 16, 8, 0)));
        data.add(new Data(13, "Example-13",
                LocalDateTime.of(2022, Month.JANUARY, 16, 8, 0)));
        data.add(new Data(14, "Example-14",
                LocalDateTime.of(2022, Month.FEBRUARY, 16, 8, 0)));

        LocalDateTime t1 = LocalDateTime.now().minusMonths(12);

        LocalDateTime t2 = LocalDateTime.now().minusHours(hour).minusMinutes(minute);

        for (Data d: data) {
            if (d.getDateCreate().isAfter(t1) & d.getDateCreate().isBefore(t2)) {
                System.out.println("ID= " + d.getId() + " Data= " + d.getData() + " Date= " + d.getDateCreate());
            }
        }

    }

}
