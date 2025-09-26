package task3.generic.bakerycoffee

import task3.generic.bakerycoffee.foodrink.Beverage
import task3.generic.bakerycoffee.foodrink.Food

class Customer {
   fun drink(beverage: Beverage) {
      when (beverage) {
         is Beverage.Coffee -> println("Drinking coffee: ${beverage.name.util()}")
         is Beverage.Tea    -> println("Drinking tea: ${beverage.name.util()}")
      }
   }

   fun eat(food: Food) {
      when (food) {
         is Food.Donut  -> println("Eating donut: ${food.name.util()}")
         is Food.Pastry -> println("Eating pastry: ${food.name.util()}")
      }
   }

}

fun String.util()= this.lowercase().replaceFirstChar { it.uppercase() }

