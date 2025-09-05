package task1

//constant
const val PI = 3.14

fun main() {
    //demoAssignmentOperator()
    stringTemplate()
}

fun demoVariable() {
    //immutable variable
    val a: String = ""

    //mutable variable
    var b: String = ""
}

fun demoTypeSystem() {

    val list = listOf(
        1,
        1f,
        true,
        "a",
        'a',
        1L,
        1.0
    )
    list.forEach {
        println(it.javaClass)
    }
}

fun demoArithmeticOperator(){
    val a = 3
    val b = 3
    println(a + b) //6
    println(a - b) //0
    println(a * b) //9
    println(a / b) //1
    println(a % b) //0
}

fun demoAssignmentOperator(){
    var a = 10
    println("a = $a")
    a += 5
    println("a = $a")
    a -= 5
    println("a = $a")
    a *= 5
    println("a = $a")
    a /= 5
    println("a = $a")
}

fun demoUnaryOperator(){
    var a=1
    var b=1
    println(a++)
    println(++b)
    println(a--)
    println(--b)
}

fun demoRelationOperator() {
    val a = 1
    val b = 1
    println(a == b) //true
    println(a != b) //false
    println(a > b) //false
    println(a < b) //false
    println(a >= b) //true
    println(a <= b) //true
}

fun demoLogicalOperation(){
    val a = true
    val b = false
    println(a && b) //false
    println(a || b) //true
    println(!a) //false
}

fun typeCasting(){
    val a = 1
    println(a.toDouble())
    println(a.toFloat())
    println(a.toLong())
    println(a.toChar())
}

fun stringTemplate(){
    val a = 1
    val str = "giá trị của a là"
    println("$str $a")
}