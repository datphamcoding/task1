package task3

import kotlin.reflect.KProperty1

// Biểu thức lambda nhận hai số nguyên và trả về tổng của chúng
val sum = { a: Int, b: Int -> a + b }

// Biểu thức lambda nhận một chuỗi và trả về độ dài của nó
val stringLength = { s: String -> s.length }

// Biểu thức lambda không có tham số trả về một Chuỗi
val greeting = { "Hello!" }

val numbers = listOf(1, 2, 3, 4, 5, 6)
val isEven: (Int) -> Boolean = { num: Int -> num % 2 == 0 }

//Ham truyền vào biểu thức lambda
fun isEven(number: Int) = number % 2 == 0

//Truyền biểu thức lambda làm đối số cho hàm `filter`
val evenNumbers = numbers.filter(isEven)

//Tham chieu den hàm
val evenNumbers1 = numbers.filter(::isEven)

/**
Thuộc tính mở rộng có giá trị là một biểu thức lambda. Thuộc tính này kiểm tra xem chuỗi có chứa nguyên âm không
**/
val String.hasVowels
   get() = {
      val vowels = "aeiou"
      this.lowercase().any { it in vowels }
   }


fun checkString(
   hasVowels: (String) -> Boolean,
   str: String,
) =hasVowels(str)

fun demo1(){

   //gọi biểu thức lambda
   "Hello".hasVowels()

   //gán biểu thức lambda cho biến
   val hasVowels = "a".hasVowels

   val hasVowelsLambda: KProperty1<String, () -> Boolean> = String::hasVowels

   println(hasVowelsLambda("b")())
}


