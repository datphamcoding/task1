package task1

fun main(){
    demoWhile()
    demoDoWhile()
}

fun demoIfelse(){
    val a=1
    val b=1
    if (a>b) println("a>b") else if (a<b) println("a<b") else println("a=b")
}

fun demoIfelseExpression(){
    val a=1
    val b=1
    val max = if (a>b) a else b
    println(max)
}

fun demoWhen() {
    val a = 1
    when (a) {
        1 -> println("a=1")
        2 -> println("a=2")
        else -> println("a!=1 && a!=2")
    }
}

fun demoFor() {
    for (i in 1..10) {
        println(i)
    }

    for (i in 10 downTo 1) {
        println(i)
    }

    for (i in 1..10 step 2) {
        println(i)
    }

    for (i in 1 until 10 ) {
        println(i)
    }

    for (i in 'a'..'z') {
        println(i)
    }

    val list = listOf(1, 2, 3, 4, 5)
    for (i in list) {
        println(i)
    }

    for(i in list.indices){
        println(list[i])
    }

}

fun demoWhile() {
    var i = 0
    while (i < 10) {
        println(i)
        i++
    }
}

fun demoDoWhile() {
    var i = 0
    do {
        println(i)
        i++
    } while (i < 10)
}