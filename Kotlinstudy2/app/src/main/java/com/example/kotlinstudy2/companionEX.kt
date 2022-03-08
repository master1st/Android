package com.example.kotlinstudy2

// Companion Object Example
// 정적메소드를 표현하는 것.
// private constructor 일때 생성자가 private이므로 객체생성에 어려움이있다. 그래서 객체생성 메소드를
// 따로 정의해서 객체를 정적인 메소드를 통해 생성하도록 하고, private를 해야하는 경우는 예외에 대한 예외처리 때문이다.
// 외부로부터 클래스내부 메소드를 거치지않고 무작정 접근할 수 있게 두면 코드의 복잡성이 심해진다.
// 인터페이스의 상속도 가능하다.
data class Book private constructor(val id : Int, val name : String){

    companion object BookFactory : IdProvider{
        override fun getID(): Int {
            return 444
        }
        val mybook : String = "newBook"
        fun create() = Book(getID(),mybook)
    }
}

interface IdProvider {
    fun getID() : Int
}

fun main(){
    val book = Book.create()
    val bookId = Book.BookFactory.getID()
    println(book)
    println(bookId)
}