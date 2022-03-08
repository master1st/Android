package com.example.kotlinstudy2
// 1. Lamda
// 람다식은 우리가 value 처럼 다룰 수 있는 익명함수이다.
// + 내 개인적인 의견은 javascript의 콜백함수와 비슷한느낌
// 1) 메소드의 파라미터로 넘겨줄 수 있다. fun maxBy(a : Int) 이 a라는 것이 익명함수겠지
// 2) return 값으로 사용할 수가 있다.
// 결론적으로 람다식은 익명함수인데 변수처럼 사용이 가능하고, 사용이 용이하다는 것이겠지
// 특징은 익명함수 사용할때 매개변수를 작성해주어야 한다는점 ex)14번줄 보면됨

//람다식 표현방식은 익숙해질때까지 돌려보는 것이 현명할 것 같다.
//문법보다는 그전에 이것을 어떻게 앱만들기에 사용하는지부터 알아야 문법도 쓸모가 있겠지
class K_Study2 {
}
val square = {number : Int-> number*number}
val nameAge = {name : String, age : Int -> "my name is ${name} I'm ${age}"
}
fun main() {
    val lamda : (Double) -> Boolean = { number : Double ->
        number == 4.2474}
    println(invokeLamda(lamda))
    println(invokeLamda({it > 4.2}))

    }


// 확장함수

    val ChickenIsSaid: String.() -> String = { this + "Chicken Is God!" }

fun extendString(name : String, age : Int) : String {
    val introduceMyself : String.(Int) -> String = { "I'm  ${this}  my age + ${it}"}
    return name.introduceMyself(age)
}

// 람다의 Return

val calculateGrade : (Int) -> String = {
    when(it){
        in 0..40 -> "fail"
        in 41..70 -> "pass"
        in 71..100 -> "goodjob"
        else -> "Error"
    }
}

// 람다를 표현하는 여러가지 방법

fun invokeLamda(lamda : (Double) -> Boolean) : Boolean {
    return lamda(4.4474)
}

