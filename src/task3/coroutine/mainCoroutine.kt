package task3.coroutine

import kotlinx.coroutines.*
import kotlin.time.Duration.Companion.seconds

/**
 * Hàm này là một hàm mở rộng (extension function) cho CoroutineScope, được thiết kế để tải dữ liệu không đồng bộ.
 * Nó mô phỏng việc tải dữ liệu bằng cách sử dụng delay.
 *
 * @param topic Chủ đề (String) mà dữ liệu cần được tải. Dữ liệu này được lấy từ một collection map `topics`.
 * @param onResult Một hàm lambda (callback) sẽ được gọi với danh sách các chuỗi (List<String>) là kết quả sau khi dữ liệu được tải.
 *                 Kết quả này là sự tập hợp của các quốc gia liên quan đến chủ đề đã cho, lấy từ collection map `countriesOfTopics`.
 *
 * Hàm này sử dụng `launch` để tạo một coroutine mới, cho phép các hoạt động bên trong (như `delay`) khiến coroutine bị treo (suspend) mà
 * không ảnh hưởng luồng khởi động nó.
 */

fun CoroutineScope.loadDataSusend(topic: String, onResult: (List<String>) -> Unit) {
   launch {
      println("Start on ${Thread.currentThread().name}")

      val topics = loadTopics(topic)

      val result = topics.map {
         loadCountries(it)
      }.flatten()

      onResult(result.also { println("Finish on ${Thread.currentThread().name}") })
   }
}


/**
 * Hàm này là một hàm mở rộng (extension function) cho CoroutineScope, được thiết kế để tải dữ liệu không đồng bộ
 * và song song bằng cách sử dụng `async` và `awaitAll`.
 * Nó mô phỏng việc tải dữ liệu bằng cách sử dụng `delay`.
 *
 * @param topic Chủ đề (String) mà dữ liệu cần được tải. Dữ liệu này được lấy từ một collection map `topics`.
 * @param onResult Một hàm lambda (callback) sẽ được gọi với danh sách các chuỗi (List<String>) là kết quả sau khi dữ liệu được tải.
 *                 Kết quả này là sự tập hợp của các quốc gia liên quan đến chủ đề đã cho, lấy từ collection map `countriesOfTopics`.
 *
 * Hàm này sử dụng `launch` để tạo một coroutine mới. Bên trong coroutine này:
 * - `loadTopics` được gọi để lấy danh sách các chủ đề con.
 * - Đối với mỗi chủ đề con, một coroutine con mới được khởi chạy bằng `async` để tải danh sách các quốc gia tương ứng (`loadCountries`).
 *   `async` trả về một đối tượng `Deferred`, đại diện cho một kết quả sẽ có trong tương lai.
 * - `awaitAll()` được gọi trên danh sách các `Deferred` để đợi tất cả các coroutine con hoàn thành và trả về kết quả của chúng.
 * - Kết quả cuối cùng (danh sách các quốc gia đã được làm phẳng) được truyền cho hàm `onResult`.
 * Việc sử dụng `async` cho phép các hoạt động `loadCountries` chạy song song, có khả năng cải thiện hiệu suất so với việc thực hiện tuần tự.
 */
fun CoroutineScope.loadDataSusendWithAsync(topic: String, onResult: (List<String>) -> Unit) {
   launch {
      println("Start on ${Thread.currentThread().name}")

      val topics = loadTopics(topic)

      val deferred = topics.map {
         async {
            loadCountries(it)
         }
      }

      val result = deferred.awaitAll().flatten()

      onResult(result.also { println("Finish on ${Thread.currentThread().name}") })
   }
}

suspend fun loadTopics(topic: String): List<String> {
   delay(1.seconds)
   return topics[topic]!!
}

suspend fun loadCountries(topic: String): List<String> {
   delay(1.seconds)
   return countriesOfTopics[topic]!!
}

fun demo() = runBlocking {
   var a = listOf<String>()
   loadDataSusend("sport", { a = it })

   //In ra trước khi loadDataSuspend trả về kết quả
   println(a)
}

fun demo1()=runBlocking {
   var a = listOf<String>()

   withContext(Dispatchers.IO){
      loadDataSusendWithAsync("sport", { a = it })
   }

   println(a)
}

fun main() {
   demo1()
}