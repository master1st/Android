package com.example.kotlinstudy01

class Human (val name:String = "Anonymou"){
    constructor(name:String, age:Int):this(name){
        println("my name is ${name}, ${age}years old")
        val name = name
    }
    fun eatingCake() {
        println("This is so YUMMYYY~~~~~")
    }
}


fun main(){
    val human = Human("seokhyun")
    val lemon = Human()
    human.eatingCake()

    val mom = Human("Kuri",52)
    println("This human's name is ${lemon.name}")
}

//자바와 코틀린간의 차이점은 생성자의 위치다.
//자바는 생성자를 클래스명이랑 동일하게해서 클래스 밑에다가 선언했다면
// 코틀린 같은 경우는 클래스 옆에 constructor() 이런식으로 바로 생성해준다.