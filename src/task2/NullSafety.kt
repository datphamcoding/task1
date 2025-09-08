package task2

fun main() {

   elvisOperator()

   //safeCall()

   notNullAssertion()

}

fun nullableType(){
   var nullableString: String? = "Hello"
   nullableString = null
   println("Nullable string: $nullableString")
}

fun nonNullType(){
   var nonNullableString: String = "Hello"
   // nonNullableString = null // Đây sẽ là lỗi biên dịch (Compilation error)
}

fun elvisOperator(){

   var name: String? = null
   //Nếu name là null, Elvis Operator sẽ trả về giá trị sau ?:
   println("Display name (Elvis Operator): ${name ?: "Guest"}")

   name= "Alice"
   println("Display name (Elvis Operator): ${name ?:"Guest"}")
}

fun safeCall(){
   var nullableString: String? = null
   println("Length of nullableString (Safe Call): ${nullableString?.length}")

   nullableString = "Kotlin"
   println("Length of nullableString (Safe Call): ${nullableString?.length}")

   //safe call với scope function
   nullableString?.let {
      println("Length of nullableString (Safe Call with let): ${it.length}")
   }
}

fun notNullAssertion(){
   var nullableString: String? = null

   //not null asserttion (!!) an toàn
   if (nullableString != null) {
      println("Length of nullableString (Not-null Assertion): ${nullableString!!.length}")
   }

   //not null assertion (!!) không an toàn. ném ra ngoại lệ nếu giá trị là null
   nullableString!!
}
