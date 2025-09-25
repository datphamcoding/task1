package task3.sealed

import java.time.LocalDate
import java.time.LocalTime

/**
 * Lớp ứng dụng Thời khóa biểu đơn giản.
 * Nó quản lý một danh sách các hoạt động (MyRoutine) và thực thi chúng.
 */
class TimeTableApp {
    val dailyRoutines = mutableListOf<MyRoutine>()
    val dailyReminders = mutableMapOf<LocalTime, MutableList<MyRoutine>>()

    /**
     * Thêm một hoạt động mới vào thời khóa biểu.
     */
    fun addRoutine(routine: MyRoutine) {
        dailyRoutines.add(routine)
        dailyReminders.getOrPut(routine.time.minusMinutes(15)) { mutableListOf() }.add(routine)
    }

    /**
     * Nhắc nhở hoạt động tiếp theo nếu thời gian hiện tại khớp với thời gian nhắc nhở của hoạt động.
     */
    fun remindNextRoutine(currentTime: LocalTime) {
        val remindersForCurrentTime = dailyReminders.filterKeys { it == currentTime }

        if (remindersForCurrentTime.isNotEmpty()) {
            remindersForCurrentTime.forEach {
                it.value.forEach { routine ->
                    routine.reminder()
                }
            }
        } else {
            //
        }
    }

}

fun main() {
    val app = TimeTableApp()
    val today = LocalDate.now()

    app.addRoutine(MyRoutine.Eating("Bánh mì", LocalTime.of(10, 0), today))
    app.addRoutine(MyRoutine.Sleeping(8, LocalTime.of(10, 0), today))

    app.remindNextRoutine(LocalTime.of(9, 45))
}
