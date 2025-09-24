package task3

/**
Hàm thực hiện một số phép tính đơn giản. Nhận vào một hàm để lấy phép tính, một hàm để lấy hai số nguyên.
Hàm trả về một hàm không tham số trả về kết quả phép tính.
**/
inline fun doSimpleMath(
    getOperator: () -> String,
    getNumber: () -> Pair<Int, Int>
): () -> Int {
    val (a, b) = getNumber()
    val operator = getOperator()
    return {
        when (operator) {
            "+" ->
                a + b

            "-" ->
                a - b


            "*" ->
                a * b


            "/" -> {
                if (b == 0) throw ArithmeticException("Cannot divide by zero")
                a / b
            }

            else -> throw IllegalStateException("Unknown operator: $operator")

        }
    }
}

fun main() {
    while (true) {
        try {
            val result = doSimpleMath(
                ::getOperator,
                ::getNumber
            )
            println("Result: ${result()}")

        } catch (_: NumberFormatException) {
            println("Invalid number format. Please enter a valid integer")
        } catch (e: ArithmeticException) {
            println(e.message)
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
        while (true) {
            print("Do you want to continue? (y/n): ")
            when (readln()) {
                "y" -> break
                "n" -> return
                else -> println("Invalid choice. Please enter 'y' or 'n'.")
            }
        }
    }
}

/**
 * Hàm yêu cầu người dùng nhập hai số nguyên và trả về một Pair chứa hai số đó.
 */
fun getNumber(): Pair<Int, Int> {
    print("Nhap a: ")
    val a = readln().toInt()
    print("Nhap b: ")
    val b = readln().toInt()
    return Pair(a, b)
}

/**
 * Hàm yêu cầu người dùng chọn một phép tính từ danh sách và trả về ký tự đại diện cho phép tính đó.
 */
fun getOperator(): String {
    println("Nhap phep tinh:")
    println("1. +")
    println("2. -")
    println("3. *")
    println("4. /")
    print("Your choice: ")
    val operator: String = when (readln()) {
        "1" -> "+"
        "2" -> "-"
        "3" -> "*"
        "4" -> "/"
        else -> throw IllegalArgumentException("Invalid choice for operator")
    }
    return operator
}