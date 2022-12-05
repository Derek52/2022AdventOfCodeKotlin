package main.day6

import main.readInput

fun main() {
    val input = readInput("day6/day6")


    val firstHalf = true
    testAlg(firstHalf)

    if (firstHalf) {
        println(main.day2.part1(input))
    } else {
        println(main.day2.part2(input))
    }
}

fun part1(input: List<String>) {

}

fun part2(input: List<String>) {

}

fun testAlg(firstHalf : Boolean) {
    val input = readInput("day6/day6_test")

    if (firstHalf) {
        println(part1(input))
    } else {
        println(part2(input))
    }
}