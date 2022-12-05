package main.day7

import main.readInput

fun main() {
    val input = readInput("day7/day7")


    val firstHalf = true
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
    val input = readInput("day7/day7_test")

    if (firstHalf) {
        println(part1(input))
    } else {
        println(part2(input))
    }
}