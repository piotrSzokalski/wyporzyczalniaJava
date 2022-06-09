package com.company;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class Borrowing implements Serializable
{
    Book _book;
    User _user;
    LocalDateTime _borrowDateTime;
    LocalDateTime _suposedReturnDateTime;
    boolean returned;
    LocalDateTime _returnDateTime;

    public Borrowing(User user, Book book)
    {
        _user = user;
        _book = book;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        _borrowDateTime = LocalDateTime.now();

        _suposedReturnDateTime = LocalDateTime.now().with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        returned = false;
    }
    public int changeStateToReturned()
    {
        returned = true;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        _returnDateTime = LocalDateTime.now();
        int penalty = 0;
        while (_suposedReturnDateTime.isAfter(_returnDateTime))
        {
            _suposedReturnDateTime.minusMinutes(10);
            penalty++;
        }
        return penalty;
    }

    @Override
    public String toString()
    {
        return _book.toString() + "  |  " + _user._name;
    }
}
