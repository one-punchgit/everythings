package com.zb.thing.basic.collection;

import com.zb.thing.basic.pojo.TsPojo;

import java.util.*;
import java.util.stream.Collectors;

public class ListTest {
    public static void main(String[] args) {

        ArrayList<TsPojo> tsPojos = new ArrayList<>();
        Iterator<TsPojo> iterator = tsPojos.iterator();
        TsPojo build1 = TsPojo.builder().ts(1701532860000L).build();//2023-12-03 00:01:00
        TsPojo build2 = TsPojo.builder().ts(1701532920000L).build();//2023-12-03 00:02:00
        TsPojo build3 = TsPojo.builder().ts(1701536400000L).build();//2023-12-03 01:00:00
        TsPojo build4 = TsPojo.builder().ts(1701536460000L).build();//2023-12-03 01:01:00
        TsPojo build5 = TsPojo.builder().ts(1701619200000L).build();//2023-12-04 00:00:00
        tsPojos.add(build1);
        tsPojos.add(build2);
        tsPojos.add(build3);
        tsPojos.add(build4);
        tsPojos.add(build5);

        // 1701532800000 2023-12-03 00:00:00
        ArrayList<Long> hours = new ArrayList<>();
        Calendar day = Calendar.getInstance();
        day.setTimeInMillis(1701532800000L);
        Calendar endDay = Calendar.getInstance();
        endDay.setTimeInMillis(1701532800000L + 24 * 60 * 60 * 1000);
        while (day.getTimeInMillis() < endDay.getTimeInMillis()) {
            hours.add(day.getTimeInMillis());
            day.add(Calendar.HOUR_OF_DAY, 1);
        }
        for (Long hour : hours) {
            System.out.println(getHour(hour));
            List<TsPojo> collect = tsPojos.stream().filter(x -> x.getTs() > hour && x.getTs() <= hour + (60 * 60 * 1000)).collect(Collectors.toList());
            System.out.println("collect-" + collect.size());
        }
    }

    private static Integer getHour(Long ts) {
        Calendar day = Calendar.getInstance();
        day.setTimeInMillis(ts);
        return day.get(Calendar.HOUR_OF_DAY);
    }
}
