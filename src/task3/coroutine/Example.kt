package task3.coroutine

import kotlinx.coroutines.*
import kotlin.time.Duration.Companion.seconds

//suspend fun CoroutineScope.loadDataSusend(topic: String, onResult: (List<String>) -> Unit){
//   launch {
//      println("Start on ${Thread.currentThread().name}")
//
//      delay(4.seconds)
//      val result = topics[topic]!!
//
//      delay(2.seconds)
//      onResult(result.flatMap {
//         countriesOfTopics[it]!!
//      }.also { println("Finish on ${Thread.currentThread().name}") })
//   }
//}