
import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    while (true) {
        val line = br.readLine().toInt()
        if (line == 0) break

        if (line.toString() == (line.toString().reversed())) {
            println("yes")
        }else{
            println("no")
        }
    }


}