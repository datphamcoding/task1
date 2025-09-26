package task3.generic.bakerycoffee.foodrink

/**
 * Giao diện đại diện cho đồ uống.
 */
sealed interface Beverage {
   /**
    * Nhiệt độ lý tưởng của đồ uống.
    */
   val idealTemperature: Int

   /**
    * Enum đại diện cho các loại trà khác nhau.
    *
    * @property idealTemperature Nhiệt độ lý tưởng của trà.
    */
   enum class Tea(override val idealTemperature: Int) : Beverage {
      GREEN_TEA(100),
      BLACK_TEA(101),
      RED_TEA(102);
   }
   /**
    * Enum đại diện cho các loại cà phê khác nhau.
    * @property idealTemperature Nhiệt độ lý tưởng của cà phê.
    */
   enum class Coffee(override val idealTemperature: Int) : Beverage {
      LIGHT_ROAST(103),
      MEDIUM_ROAST(104),
      DARK_ROAST(105)
   }
}