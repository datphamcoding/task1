package task3.generic.bakerycoffee

import task3.generic.bakerycoffee.serveware.Mug
import task3.generic.bakerycoffee.foodrink.Beverage
import task3.generic.bakerycoffee.foodrink.Food
import task3.generic.bakerycoffee.foodrink.ComboOrder
import task3.generic.bakerycoffee.serveware.Plate

fun main() {

    val customer = Customer()
    val waiter = Waiter()

    val coffeeOrder: Beverage.Coffee = Beverage.Coffee.DARK_ROAST
    val servedMug: Mug<Beverage.Coffee> = waiter.serve(coffeeOrder)
    customer.drink(servedMug.beverage)

    val pastryOrder: Food.Pastry = Food.Pastry.CAKE
    val servedPlate: Plate<Food.Pastry> = waiter.serve(pastryOrder)
    customer.eat(servedPlate.food)

    val teaOrder: Beverage.Tea = Beverage.Tea.GREEN_TEA
    val donutOrder: Food.Donut = Food.Donut.GLAZED
    val servedCombo: ComboOrder<Food.Donut, Beverage.Tea> = waiter.serveCombo(donutOrder, teaOrder)
    customer.drink(servedCombo.beverage)
    customer.eat(servedCombo.food)

}
