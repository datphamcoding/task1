package task3.generic.bakerycoffee.serveware

import task3.generic.bakerycoffee.foodrink.Beverage

class Mug<T : Beverage>(val beverage: T) {
   val temperature = beverage.idealTemperature
}

