package task3.sealed

import java.time.LocalDate
import java.time.LocalTime

sealed class MyRoutine(
    val date: LocalDate,
    val time: LocalTime,
    val reminder: () -> Unit,
) {
    class Eating(
        val food: String,
        time: LocalTime,
        date: LocalDate,
    ) : MyRoutine(date, time, { println("Ăn $food lúc $time") }){
        override fun toString(): String {
            return "MyRoutine.Eating(food='$food', time=$time, date=$date)"
        }
    }

    class Sleeping(
        val duration: Int,
        time: LocalTime,
        date: LocalDate,
    ) : MyRoutine(date, time, { println("Ngủ khoảng $duration giờ lúc $time") }){
        override fun toString(): String {
            return "MyRoutine.Sleeping(duration=$duration, time=$time, date=$date)"
        }
    }
}