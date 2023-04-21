package com.github.bartgora.notime2play.model

import java.time.LocalTime

class Schedule {

    lateinit var availiblity: Map<Day, Hours>
}

class Hours {
    private constructor()

    lateinit var from: LocalTime
    lateinit var to: LocalTime

    companion object {

        fun create(fromDate: LocalTime, toDate: LocalTime): Hours {
            if (fromDate.isBefore(toDate)) {
                return Hours().apply {
                    to = toDate
                    from = fromDate
                }
            } else throw IllegalStateException("Date to cannot be before date from")
        }
    }
}

enum class Day {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
}