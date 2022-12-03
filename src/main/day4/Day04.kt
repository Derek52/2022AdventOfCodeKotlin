package main.day4

import main.readInput

fun main() {
    val input = readInput("day4/day4")


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
    val input = readInput("day4/day4_test")

    if (firstHalf) {
        println(part1(input))
    } else {
        println(part2(input))
    }
}