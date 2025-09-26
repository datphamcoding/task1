package task3.generic.bakerycoffee.foodrink

/**
 * Đại diện cho một món ăn trong tiệm bánh hoặc quán cà phê.
 */
sealed interface Food {
   /**
    * Đại diện cho một loại bánh donut.
    */
   enum class Donut : Food {
      GLAZED, CHOCOLATE
   }

   /** Đại diện cho một loại bánh ngọt. */
   enum class Pastry : Food {
      CAKE, MUFFIN
   }
}