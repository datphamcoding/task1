package task3.generic.bakerycoffee

import task3.generic.bakerycoffee.foodrink.Beverage
import task3.generic.bakerycoffee.foodrink.Food
import task3.generic.bakerycoffee.foodrink.ComboOrder
import task3.generic.bakerycoffee.serveware.Mug
import task3.generic.bakerycoffee.serveware.Plate

class Waiter {
   fun <T : Beverage> serve(typeOfBeverage: T) = Mug(typeOfBeverage)
   fun <T : Food> serve(typeOfFood: T) = Plate(typeOfFood)
   fun <T : Food, U : Beverage> serveCombo(typeOfFood: T, typeOfBeverage: U) =
       ComboOrder(typeOfFood, typeOfBeverage)
}