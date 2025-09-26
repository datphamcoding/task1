package task3.generic.bakerycoffee

import kotlin.reflect.full.memberFunctions
import kotlin.reflect.full.memberProperties
import kotlin.reflect.full.primaryConstructor

data class Person(
    val name: String,
    val age: Int,
    private val salary: Double
) {

    fun sayHello() {
        println("Xin chào, tôi là $name, năm nay tôi $age tuổi.")
    }
}

fun main() {
    // --- PHẦN 1: KHÁM PHÁ CẤU TRÚC CỦA CLASS ---
    println("--- 1. Khám phá cấu trúc của class Person ---")

    // Lấy đối tượng KClass đại diện cho class Person.
    val personClass = Person::class
    println("Tên đầy đủ của class: ${personClass.simpleName}")

    println("\n* Các thuộc tính (properties) của class:")
    personClass.memberProperties.forEach { property ->
        println("  - ${property.name} (kiểu: ${property.returnType})")
    }

    println("\n* Các hàm (functions) của class:")
    personClass.memberFunctions.forEach { function ->
        println("  - ${function.name}")
    }

    println("\n* Constructor chính của class:")
    val primaryConstructor = personClass.primaryConstructor
    if (primaryConstructor != null) {
        print("  - Các tham số: ")
        primaryConstructor.parameters.forEach { parameter ->
            print("${parameter.name} (${parameter.type}), ")
        }
        println()
    }

    // --- PHẦN 2: TẠO ĐỐI TƯỢNG VÀ TƯƠNG TÁC BẰNG REFLECTION ---
    println("\n--- 2. Tương tác với đối tượng bằng Reflection ---")

    // 1. Tạo một đối tượng Person mà không cần gọi `Person(...)` trực tiếp.
    val constructor = personClass.primaryConstructor!!
    val personInstance = constructor.call("Alice", 25,10_000_000.0)

    println("Đã tạo đối tượng: $personInstance")

    // 2. Lấy giá trị của một thuộc tính bằng tên của nó (dưới dạng chuỗi).
    val nameProperty = personClass.memberProperties.first { it.name == "name" }
    val nameValue = nameProperty(personInstance)
    println("Lấy giá trị thuộc tính 'name': $nameValue")

    // 3. Gọi một hàm bằng tên của nó (dưới dạng chuỗi).
    val sayHelloFunction = personClass.memberFunctions.first { it.name == "sayHello" }
    sayHelloFunction.call(personInstance)
}
