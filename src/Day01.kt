fun main() {
    val input = readInput("day1_part1")

    println(part1(input))
    println(part2(input))
}

fun part1(input: List<String>): Int {
    var highestCalorieCount = 0
    var currentCalorieCount = 0

    for (line in input) {
        if (line == "") {
            if (currentCalorieCount > highestCalorieCount) {
                println("$currentCalorieCount is higher than highest: $highestCalorieCount")
                highestCalorieCount = currentCalorieCount
            }
            currentCalorieCount = 0
        } else {
            currentCalorieCount += line.toInt()
        }
    }
    return highestCalorieCount
}

fun part2(input: List<String>): Int {
    var currentCalorieCount = 0
    val highestTotalList = MutableList<Int>(3) { 0 }

    for (line in input) {
        if (line == "") {
            if (currentCalorieCount > highestTotalList[0]) {
                highestTotalList[0] = currentCalorieCount
                bubbleSort(highestTotalList)
            }
            currentCalorieCount = 0
        } else {
            currentCalorieCount += line.toInt()
        }
    }

    return sumList(highestTotalList)
}

fun bubbleSort(list: MutableList<Int>) {
    var highestValue = 0
    var indexOfHighest = 0
    for (i in list.size - 1 downTo 2) {
        for (j in 0 until i) {
            val a = list[j]
            val b = list[j+1]
            if (a > b) {
                list[j] = b
                list[j+1] = a
            }
        }
    }
}

fun sumList(list: List<Int>) : Int {
    var currentSum = 0
    list.forEach {
        currentSum += it
    }
    return currentSum
}