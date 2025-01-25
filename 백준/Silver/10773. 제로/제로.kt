import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val stack = Stack<Int>()

    repeat(br.readLine().toInt() ) {
        val num = br.readLine().toInt();
        if (num != 0) {
            stack.add(num)
        } else {
            stack.pop()
        }
    }

    var count = 0;
    repeat(stack.size ) {
        count += stack.pop()
    }

    println(count)
}