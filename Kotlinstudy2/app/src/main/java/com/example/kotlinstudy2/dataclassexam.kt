package com.example.kotlinstudy2

// 1) data class example
// 자바의 객체 생성과는 다른점이 생성자를 별도로 정의하지 않아도되고
// 그다음 body안에 매개변수 정의하고 메소드도 정의하고 바쁘다.
// 그리고 또한 data class는 바로 내부안의 프로퍼티 데이터 정보를 알 수가 있다.
data class Ticket(val companyName : String, val name : String, var date : String, var seatNumber : Int)
class NormalTicket(val companyName : String, val name : String, var date : String, var seatNumber : Int)

fun main(){
    val ticket = Ticket("SHCompany","Yoonseokhyun","2022-03-08",24)
    val Normalticket = NormalTicket("SHCompany","Yoonseokhyun","2022-03-08",24)
    println(ticket)
    println(Normalticket)
}