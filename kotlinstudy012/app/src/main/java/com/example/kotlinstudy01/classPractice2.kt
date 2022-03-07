package com.example.kotlinstudy01

open class classPractice2 (val name:String="mynameis") {
    var cheec = "primarychicken"+name
    val sex :Int = 3
   open fun singASong(){
        println("lalala")
    }

}
class classSuper : classPractice2(){
    override fun singASong(){
        super.singASong()
        println("학교가기싫다ㅏ..")
        println("나의이름 : ${name}")

    }
}
fun main() {
    val structure1 = classPractice2("jejjus")
    println("${structure1.cheec} , ${structure1.sex} ")
    val Students : ArrayList<String> = arrayListOf("seokhyun","go","to","bed")
    for(name in Students){
        println("${name}")
    }
    val superz = classSuper()
    superz.singASong()

}

