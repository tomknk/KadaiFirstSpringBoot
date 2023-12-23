package com.techacademy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
public class KadaiFirstController {

    //■仕様１：指定日の曜日を算定する
    // http://localhost:8080/dayofweek/yyyymmdd で曜日を取得する
    @GetMapping("/dayofweek/{date}")
    public String dispDayOfWeek(@PathVariable String date) {
            LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyyMMdd"));
            DayOfWeek dayOfWeek = localDate.getDayOfWeek();
            String displayName = dayOfWeek.toString();

            // 先頭のみ大文字に変換
            displayName = displayName.substring(0, 1) + displayName.substring(1).toLowerCase();
            return "実行結果：" + displayName;
        }

    // ■仕様2：四則演算を行なう
    // 足し算
    @GetMapping("/plus/{val1}/{val2}")
    public String addNumbers(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 + val2;
        return "実行結果：" + res;
    }

    // 引き算
    @GetMapping("/minus/{val1}/{val2}")
    public String calcMinus(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 - val2;
        return "実行結果：" + res;
    }

    // 掛け算
    @GetMapping("/times/{val1}/{val2}")
    public String calcTimes(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 * val2;
        return "実行結果：" + res;
    }

    // 割り算
    @GetMapping("/divide/{val1}/{val2}")
    public String calcDivide(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 / val2;
        return "実行結果：" + res;
    }
}