package task1

data class Person(val name: String, val age: Int, val city: String)
data class Task(val name: String, val description: String, val isComplete: Boolean)

val people = listOf(
    Person("Alice", 30, "New York"),
    Person("Bob", 25, "London"),
    Person("Charlie", 35, "New York"),
    Person("David", 25, "Paris"),
    Person("Eve", 40, "London")
)

val tasks = listOf(
    Task("Buy groceries", "Milk, Eggs, Bread", false),
    Task("Pay bills", "Electricity, Internet", true),
    Task("Walk the dog", "Take him to the park", false),
    Task("Clean the house", "Vacuum, Mop, Dust", true)
)

//Tìm tên những người trên 25 tuổi và sắp xếp theo tên
fun demo() {
    val result = people
        .filter { it.age > 25 }
        .sortedBy { it.name }
        .map { it.name }
    println(result)
}

//Tìm tên những người ở NewYork và sắp xếp theo tuổi
fun demo1() {
    val result = people
        .filter { it.city == "New York" }
        .sortedBy { it.age }
        .map { it.name }
    println(result)
}

//Nhóm những ngừời cùng thành phố vào một nhóm
fun demo2() {
    val result = people
        .groupBy { it.city }
        .mapValues { (_, people) -> people.map { it.name } }
    println(result)
}

// Lọc các task chưa hoàn thành, sắp xếp theo tên và chỉ lấy tên task
fun demo3() {
    val incompleteTaskNames = tasks
        .filter { !it.isComplete }
        .sortedBy { it.name }
        .map { it.name }
    println(incompleteTaskNames)
}

// Tìm người trẻ nhất ở London
private fun demo5() {
    val youngestInLondon = people
        .filter { it.city == "London" }
        .minByOrNull { it.age }
    println(youngestInLondon)
}

// Đếm số lượng task đã hoàn thành và chưa hoàn thành
fun demo6() {
    val taskStatusCount = tasks
        .groupBy { it.isComplete }
        .mapKeys { (isComplete, _) -> if (isComplete) "Complete" else "Incomplete" }
        .mapValues { (_, tasks) -> tasks.size }
    println(taskStatusCount)
}

// Lấy danh sách các mô tả task, chuyển thành chữ hoa và loại bỏ các mô tả trùng lặp
fun demo7() {
    val distinctUppercaseDescriptions = tasks
        .map { it.description.uppercase() }
        .distinct()
    println(distinctUppercaseDescriptions)
}

// Tìm tất cả các thành phố và sắp xếp theo thứ tự bảng chữ cái
fun demo8() {
    val distinctCities = people
        .map { it.city }
        .distinct()
        .sorted()
    println(distinctCities)
}

// Lấy tên của tất cả mọi người và nối chúng thành một chuỗi, phân tách bằng dấu phẩy
fun demo9() {
    val allNames = people
        .joinToString(separator = ", ") { it.name }
    println(allNames)
}

//Tính tổng các số chẵn trong danh sách
fun demo10(){
    listOf(1,2,3,4,5,6)
        .filter { it%2==0 }
        .sum()
        .also(::println)
}

fun main() {
//    demo()
//    demo1()
    demo10()
}