package task3

class PersonBuilder {
    var name: String = ""
    var age: Int = 0
    var salary: Double = 0.0

    fun build() = Person(name, age, salary)
}

/**
Hàm này là điểm bắt đầu của DSL
1. Nó nhận một tham số là một lambda:`block: PersonBuilder.() -> Unit`
2. `PersonBuilder.()`: Đây là "lambda với receiver". Nó có nghĩa là
bên trong khối lệnh {} của lambda, `this` sẽ là một đối tượng PersonBuilder.
 */
fun buildPerson(block: PersonBuilder.() -> Unit): Person {
    val builder = PersonBuilder()

    builder.block()

    return builder.build()
}

fun main() {
    val newPerson = buildPerson {
        name = "Bob"
        age = 28
        salary = 12000.0
    }

    println(newPerson)
    newPerson.sayHello()
}
