package top.dreamertn9527.workstation.framework.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class DateUtils {

    private static final Integer MONTH_LENGTH = 13;

    private static List<String> getEveryDay(int year) {
        int m = 1;
        List<String> list = new ArrayList<>();
        while (m < MONTH_LENGTH) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, m - 1);
            int count = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
            for (int j = 1; j <= count; j++) {
                list.add(year + "-" + m + "-" + j);
            }
            m++;
        }
        return list;
    }
}
