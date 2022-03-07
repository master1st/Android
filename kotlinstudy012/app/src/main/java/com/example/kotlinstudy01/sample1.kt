package com.example.kotlinstudy01

fun main(){
    ignoreNulls("memory")
}

fun helloWorlds() : Unit {
    println("HELLO WORLD")
}

fun add(a : Int, b : Int) :Int {
    return a+b
}

//fun hi(){
//    var a : Int = 10
//    val b  : Int= 10
//
//    a = 10
//    b =100
//    var c : String = "Chicken"
//}
fun practice(){
    val name : String = "Juice"
    val lastName : String = "name"

    println("my name is ${name}I'm years old 23")
    println("my name is ${name + lastName} \$chick")
}

fun checkNum(score:Int){
    when(score){
        0 -> println("when is 0")
        1 -> println("when is 1")
        2,3 -> println("when is 2,3")
        else -> println("when is else")
    }
    var b = when(score){
        1 -> 2
        2 -> 3
        else -> 3
    }
}

fun array(){
    val array: Array<Int> = arrayOf(1,2,3)
    val list: List<Int> = listOf(1,2,3)

    var array2 = arrayOf(1,2,3,"chick",3.4f)
    var list2 = listOf(1,2,3,"chick","\$")

    array[0] = 0
    var result = list.get(0)
    var arrayList = arrayListOf<Int>()
    arrayList.add(100)
    arrayList.add(10)


}

//fun forAndWhile(){
//    val students = arrayListOf("joyce")
//}

fun curront(){
    var index:Int = 0;
    while(index < 10){
        println("current index: ${index}")
        index++

    }
}

fun forAndWhile(){
    val students : ArrayList<String> = arrayListOf("joyce","enchul","seokhy","eungje","jihun")
    for( name in students){
        println("${name}")
    }
}

// 7. Nullable / NonNull

fun nullcheck(){
    //NPE: NULL Pointer Exception

    var name:String = "joyce"

    var Nullname:String? = null

    var nameInUpperCase:String = name.toUpperCase()

    var nullNameInUpperCase= Nullname?.toUpperCase()

// ?:

    val lastName : String? = "chicken"
    val fullName : String = name+" "+(lastName?:"NoN NULL")
    println("${fullName}")
}
//아래와 같은 경우는 컴파일러에게 미리 함수 매개변수가 null 값이들어올리 없어라고해서 !! 를 부팅는것
fun ignoreNulls(str : String?){
    val mNotNull : String = str!!
    val upper :String = mNotNull.toUpperCase()

    val email : String?=null
    email?.let{
        println("my email is ${email}")
    }
}