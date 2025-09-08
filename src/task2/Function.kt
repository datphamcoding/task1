package task2

// Hàm thông thường (Regular function)
fun sum(a: Int, b: Int): Int {
    return a + b
}

// Hàm một dòng (Single-expression function)
fun multiply(a: Int, b: Int): Int = a * b

// Default Parameter & Named Argument
fun greet(name: String, greeting: String = "Hello") {
    println("$greeting, $name!")
}

// Extension Function
fun String.addExclamation(): String = "$this!"

fun main() {
    // Regular function example
    println("Sum: ${sum(5, 3)}") // Output: Sum: 8

    // Single-expression function example
    println("Multiply: ${multiply(5, 3)}") // Output: Multiply: 15

    // Default Parameter & Named Argument examples
    greet("World") // Output: Hello, World!
    greet("Alice", "Hi") // Output: Hi, Alice!
    greet(greeting = "Good morning", name = "Bob") // Output: Good morning, Bob!

    // Extension Function example
    val myString = "Kotlin"
    println(myString.addExclamation()) // Output: Kotlin!
}