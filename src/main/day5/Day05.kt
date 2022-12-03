package main.day5

import main.readInput

fun main() {
    val input = readInput("day5/day5")


    val firstHalf = false
    testAlg(firstHalf)

    if (firstHalf) {
        println(part1(input))
    } else {
        println(part2(input))
    }
}

fun part1(input: List<String>) {

}

fun part2(input: List<String>) {

}

fun testAlg(firstHalf : Boolean) {
    val input = readInput("day5/day5_test")

    if (firstHalf) {
        println(part1(input))
    } else {
        println(part2(input))
    }
}