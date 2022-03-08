package com.example.kotlinstudy2
//Singleton Pattern
object CarFactory{
    val cars = mutableListOf<Car>() // 자동차 리스트
    fun makeCar(horsePower: Int) : Car { // 자동차 생성 메소드
        val car = Car(horsePower)
        cars.add(car)
        return car  //Car안에 파워를 넣어 객체 생성후, mutableList에 삽입후 리턴

    }
}

data class Car(val horsePower : Int)

fun main() {
    val car = CarFactory.makeCar(10)
    val car2 = CarFactory.makeCar(200)

    println(car)
    println(car2)
    println(CarFactory.cars.size.toString())
}
