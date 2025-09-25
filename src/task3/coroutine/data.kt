package task3.coroutine

import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

val topics = mapOf(
   "sport" to listOf("Soccer", "Basketball", "Volleyball", "Tennis"),
   "music" to listOf("Pop", "Rock", "Hip-Hop", "Jazz"),
   "food" to listOf("Pizza", "Burger", "Salad", "Sandwich")
)

val countriesOfTopics = mapOf(
   "Soccer" to listOf("Brazil", "Germany", "Argentina"),
   "Basketball" to listOf("USA", "Spain", "Lithuania"),
   "Volleyball" to listOf("Brazil", "USA", "Poland"),
   "Tennis" to listOf("Spain", "Switzerland", "USA"),
   "Pop" to listOf("USA", "UK", "South Korea"),
   "Rock" to listOf("USA", "UK", "Germany"),
   "Hip-Hop" to listOf("USA"),
   "Jazz" to listOf("USA", "France"),
   "Pizza" to listOf("Italy", "USA"),
   "Burger" to listOf("USA", "Germany"),
   "Salad" to listOf("Greece", "USA", "France"),
   "Sandwich" to listOf("USA", "UK", "Vietnam")
)

suspend fun loadTopics(topic: String): List<String> {
   delay(1.seconds)
   return topics[topic]!!
}

suspend fun loadCountries(subTopic: String): List<String> {
   delay(1.seconds)
   return countriesOfTopics[subTopic]!!
}