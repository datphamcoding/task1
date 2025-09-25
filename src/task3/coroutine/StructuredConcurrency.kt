package task3.coroutine

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

/**
 * Hàm demo3 sử dụng coroutineScope để tạo một scope mới cho các coroutine con.
 * coroutineScope sẽ đợi tất cả các coroutine con trong scope của nó hoàn thành trước khi nó kết thúc.
 * Điều này đảm bảo rằng các coroutine con được quản lý một cách có cấu trúc và không bị rò rỉ.
 *
 * measureTimeMillis được sử dụng để đo thời gian thực thi của khối lệnh bên trong coroutineScope.
 */
suspend fun demo3() {
   val timeOnParent = measureTimeMillis {
      coroutineScope {
         launch {
            delay(1000)
            println("Coroutine con 1 finish")
         }
         launch {
            delay(2000)
            println("Coroutine con 2 finish")
         }
      }
   }
   println("Chạy các coroutine con và đợi chúng hoàn thành công việc trong $timeOnParent ms")
}


/**
 * Hàm demo4 sử dụng supervisorScope để tạo một scope mới cho các coroutine con.
 * supervisorScope khác với coroutineScope ở chỗ nó không hủy các coroutine con khác khi một coroutine con bị lỗi.
 * Điều này hữu ích khi muốn các coroutine con hoạt động độc lập và không ảnh hưởng lẫn nhau.
 *
 * measureTimeMillis được sử dụng để đo thời gian thực thi của khối lệnh bên trong supervisorScope.
 */
suspend fun demo4() {
   val timeOnParent = measureTimeMillis {
      supervisorScope {
         launch {
            delay(1000)
            println("Coroutine con 1 finish")
            throw RuntimeException("Coroutine con 1 muốn thoát vì đã chạy xong")
         }
         launch {
            delay(2000)
            println("Coroutine con 2 finish")
         }
      }
   }
   println("Chạy các coroutine con và đợi chúng hoàn thành công việc trong $timeOnParent ms")
}

//demo4a xử lí tình trạng muốn thoát của coroutine con khi chúng hoàn thành công việc bằng cách sử dụng CoroutineExceptionHandler.
//Một cách khác là sử dụng try/catch để bắt và xử lý ngoại lệ
suspend fun demo4a() {
   val timeOnParent = measureTimeMillis {
      val handler = CoroutineExceptionHandler { _, throwable ->
         println(throwable.message)
      }
      withContext(handler) {
         supervisorScope {
            launch {
               delay(1000)
               println("Coroutine con 1 finish")
               throw RuntimeException("Coroutine con 1 muốn thoát vì đã chạy xong")
            }
            launch {
               delay(2000)
               println("Coroutine con 2 finish")
               throw RuntimeException("Coroutine con 2 muốn thoát vì đã chạy xong")
            }
         }
      }
   }
   println("Chạy các coroutine con và đợi chúng hoàn thành công việc trong $timeOnParent ms")
}

fun main() {
   runBlocking { demo4a() }
}