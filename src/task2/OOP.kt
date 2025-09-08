package task2

fun classObject() {
   class Car(private val brand: String, private val model: String)

   //Khoi tao doi tuong
   val car = Car(brand = "Toyota", model = "Camry")
}

fun demoConstructor() {
   class Vehicle(private val type: String) { // Primary constructor
      var color: String = "Unknown"

      // Secondary constructor
      constructor(type: String, color: String) : this(type) {
         this.color = color
      }
   }

   val car = Vehicle("Car", "Red")
   val bike = Vehicle("Bike")
   println(car.color)
   println(bike.color)
}

fun demoInheritance() {

   open class Animal(
      protected val name: String
   ) {
      open fun speak() {
         println("$name is speaking.")
      }
   }

   class Dog(name: String) : Animal(name) {
      override fun speak() {
         println("$name is barking.")
      }
   }

   class Vet() {
      fun giveShot(animal: Animal) {
         animal.speak()
      }
   }

   //Tính đa hình
   val dog = Dog("Buddy")
   val vet = Vet()
   vet.giveShot(dog)
}

fun demoInterface() {

   class Person(
      //Ghi đè khai báo của thuộc tính của interface
      override var name: String,
      override var language: String
   ) : Named, Speaker {

      //Triển khai phương thức của interface
      override fun speak() {
         println("$name says hello in $language")
      }

   }

   val person = Person("Alice", "English")
   person.language = "French"
   person.speak()
}

fun demoAbstractClass() {

   abstract class Person(
      override val language: String,
      override val name: String
   ): Named, Speaker {
      override fun speak() {
         println("$name says hello in $language")
      }
   }

   class Vietnamese(
      name: String
   ) : Person("Tiếng Việt", name) {
      override fun speak() {
         println("$name nói xin chào bằng $language")
      }
   }

    open class English(
       name: String
   ) : Person("English", name) {
      override fun speak() {
         println("$name says hello in $language")
      }
   }

   class ForeignLanguageStudent(
      val ngonNguChuyenNganh:String,
      name: String
   ) : English(name) {

      override fun speak() {
         println("$name says hello in $language")
         println("I'm studying $ngonNguChuyenNganh")
      }
   }

   val vietnamese = Vietnamese("Tú")
   vietnamese.speak()

   val english = English("Bob")
   english.speak()

   val foreignLanguageStudent = ForeignLanguageStudent("Spanish", "Alice")
   foreignLanguageStudent.speak()
}

fun dataClass() {
   data class User(val name: String, val age: Int)
   val user = User("Alice", 25)

   //data class tự động ghi đè phương thức toString()
   println(user)
}

fun main() {
   //demoConstructor()
   //demoInterface()
   demoAbstractClass()
}