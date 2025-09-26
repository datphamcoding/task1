package task3.generic

import java.time.LocalTime

fun main() {
    printItem("Xin chào")
    printItem(123)
    printItem(true)
    printItem(LocalTime.now())

    printItem(getFirstElement(listOf("A","B","C")))

    printTwoThings("Xin chào", 123)
}

fun <T> printItem(item: T) = println("Giá trị của item là: $item")

fun <T> getFirstElement(list: List<T>) = if (list.isNotEmpty()) list[0] else null

fun <T, U> printTwoThings(first: T, second: U) {
    println("Item 1: $first (Kiểu: ${first!!::class.simpleName})")
    println("Item 2: $second (Kiểu: ${second!!::class.simpleName})")
}