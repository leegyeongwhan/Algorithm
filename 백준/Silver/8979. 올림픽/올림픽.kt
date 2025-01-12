import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val input = br.readLine().split(" ")

    val count = input[0].toInt()
    val number = input[1].toInt()

    val countries = mutableListOf<Country>()

    repeat(count) {
        val row = br.readLine().split(" ").map { it.toInt() }
        val country = Country(row[0], row[1], row[2], row[3])
        countries.add(country)
    }

    //금메달 수가 더 많은 나라
    //금메달 수가 같으면, 은메달 수가 더 많은 나라
    //금, 은메달 수가 모두 같으면, 동메달 수가 더 많은 나라
    //금은동 모두 같다면 등수는 같다.
    countries.sortWith(
        compareByDescending<Country> { it.gold }
            .thenByDescending { it.silver }
            .thenByDescending { it.bronze }
    )

    val ranks = IntArray(countries.size)
    ranks[0] = 1
    var rank = 1

    for (i in 1 until countries.size) {
        if (!countries[i].isSameMedal(countries[i - 1])) {
            rank = i + 1
        }
        ranks[i] = rank
    }

        val targetIndex = countries.indexOfFirst { it.id == number }
    println(ranks[targetIndex])
}

data class Country(
    val id: Int,
    val gold: Int,
    val silver: Int,
    val bronze: Int
) {
    fun isSameMedal(other: Country): Boolean {
        return gold == other.gold && silver == other.silver && bronze == other.bronze
    }
}
