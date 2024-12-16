
import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val count = br.readLine().toInt()
    val data = Array(count) { Array(2) { 0 } }

    for (i in 0 until count) {
        val line = br.readLine()
        val arr = line.split(" ")
        data[i][0] = arr[0].toInt() // 모무게를 저장
        data[i][1] = arr[1].toInt() // 키를 저장
    }

    val ranks = IntArray(count) { 1 }

    for (i in 0 until count) {
        for (j in 0 until count) {
            if (data[i][0] < data[j][0] && data[i][1] < data[j][1]) {
                ranks[i]++
            }
        }
    }
    for (i in 0 until count) {
        print(ranks[i].toString() + " ")
    }
}