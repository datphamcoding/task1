package task3.coroutine

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

/**
 * Hàm này là một hàm suspend, được thiết kế để tải dữ liệu không đồng bộ trong một coroutine.
 * Nó mô phỏng việc tải dữ liệu bằng cách sử dụng `delay`.
 *
 * @param topic Chủ đề (String) mà dữ liệu cần được tải. Dữ liệu này được lấy từ một collection map `topics`.
 * @param onResult Một hàm lambda (callback) sẽ được gọi với danh sách các chuỗi (List<String>) là kết quả sau khi dữ liệu được tải.
 *                 Kết quả này là sự tập hợp của các quốc gia liên quan đến chủ đề đã cho, lấy từ collection map `countriesOfTopics`.
 *
 * Hàm này thực hiện các bước sau:
 * 1. In ra tên của luồng hiện tại để theo dõi.
 * 2. Gọi `loadTopics` để lấy danh sách các chủ đề con liên quan đến `topic` đã cho.
 * 3. Đối với mỗi chủ đề con, gọi `loadCountries` để lấy danh sách các quốc gia tương ứng. Các kết quả này được làm phẳng thành một danh sách duy nhất.
 * 4. Gọi hàm `onResult` với danh sách các quốc gia đã được tải. In ra tên của luồng hiện tại trước khi kết thúc.
 */
suspend fun loadDataSuspend(topic: String, onResult: (List<String>) -> Unit) {
   println("Start on ${Thread.currentThread().name}")

   val subTopics: List<String>
   val countries: List<String>

   val time = measureTimeMillis {
      subTopics = loadTopics(topic)

      countries = subTopics.map {
         loadCountries(it)
      }.flatten()
   }

   onResult(countries.also { println("Finish on ${Thread.currentThread().name} on $time ms") })
}

/**
 * Hàm này là một hàm suspend, được thiết kế để tải dữ liệu không đồng bộ bằng cách sử dụng `async` và `awaitAll`
 * Nó mô phỏng việc tải dữ liệu bằng cách sử dụng `delay`.
 *
 * @param topic Chủ đề (String) mà dữ liệu cần được tải. Dữ liệu này được lấy từ một collection map `topics`.
 * @param onResult Một hàm lambda (callback) sẽ được gọi với danh sách các chuỗi (List<String>) là kết quả sau khi dữ liệu được tải.
 *                 Kết quả này là sự tập hợp của các quốc gia liên quan đến chủ đề đã cho, lấy từ collection map `countriesOfTopics`.
 *
 * Hàm này thực hiện các bước sau:
 * 1. Sử dụng `coroutineScope` để tạo một scope cho các coroutine con.
 * 2. In ra tên của luồng hiện tại để theo dõi.
 * 3. Gọi `loadTopics` để lấy danh sách các chủ đề con liên quan đến `topic` đã cho.
 * 4. Đối với mỗi chủ đề con, khởi chạy một coroutine mới bằng `async` để gọi `loadCountries`. Điều này cho phép khởi động việc tải dữ liệu liên tiếp.
 * 5. Sử dụng `awaitAll()` để đợi tất cả các coroutine `async` hoàn thành và thu thập kết quả của chúng.
 * 6. Làm phẳng danh sách các danh sách quốc gia thành một danh sách duy nhất.
 * 7. Gọi hàm `onResult` với danh sách các quốc gia đã được tải. In ra tên của luồng hiện tại trước khi kết thúc.
 */
suspend fun loadDataSuspendWithAsync(
   topic: String,
   onResult: (List<String>) -> Unit,
) =
   coroutineScope {
      println("Start on ${Thread.currentThread().name}")

      val subtopics: List<String>
      val countries: List<String>

      val time = measureTimeMillis {
         subtopics = loadTopics(topic)
         val deferred = subtopics.map {
            async {
               loadCountries(it)
            }
         }
         countries = deferred.awaitAll().flatten()
      }

      onResult(countries.also { println("Finish on ${Thread.currentThread().name} on $time ms") })
   }

/**
 * Hàm này minh họa cách sử dụng `loadDataSuspend` trong một `runBlocking` coroutine.
 * Nó khởi chạy một coroutine mới để tải dữ liệu và sau đó in kết quả.
 *
 * Lưu ý: Việc in `a` ngay sau khi khởi chạy coroutine có thể dẫn đến việc `a` chưa được cập nhật
 * do `loadDataSuspend` là một hàm suspend và chạy không đồng bộ.
 * Để đảm bảo `a` được cập nhật trước khi in, cần sử dụng `join()` hoặc các cơ chế đồng bộ hóa khác.
 */
fun demo() = runBlocking {

   var a = listOf<String>()

   launch {
      loadDataSuspend("sport") { a = it }
   }

   println(a)
}

fun demo1() = runBlocking {
   var a = listOf<String>()

   launch {
      loadDataSuspendWithAsync("sport") { a = it }
   }

   println(a)
}

fun main() {
   demo1()
   demo()
}