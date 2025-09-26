package task3.generic.bakerycoffee.foodrink

class ComboOrder<T : Food, U : Beverage>(val food: T, val beverage: U)