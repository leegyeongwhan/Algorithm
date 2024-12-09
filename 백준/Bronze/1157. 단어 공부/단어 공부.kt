package spring_study

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val line = br.readLine().uppercase()

    val arr = IntArray(26)

    for (char in line) {
        if (char in 'A'..'Z') {
            arr[char - 'A']++
        }
    }

    val max = arr.maxOrNull()!!

    if(arr.count(){ it == max } > 1){
        println("?")
    }else{
        val maxIndex = arr.indexOf(max)
        println(('A' + maxIndex))
    }
}