package main.day6

import main.readInput

fun main() {
    val input = readInput("day6/day6")


    val firstHalf = false
    //testAlg(firstHalf)

    if (firstHalf) {
        println(part1(input))
    } else {
        println(part2(input))
    }
}

fun part1(input: List<String>) : Int {
    val message = input[0]
    for (i in 3 until message.length) {
        val letters = listOf(message[i], message[i-1], message[i-2], message[i-3])
        if (areUnique(letters)) {
            println("${letters.forEach { it }} are unique")
            return i+1
        }
    }
    return -1
}

//TODO: Make this more efficient. Making the list on every loop is bad.
fun part2(input: List<String>) : Int {
    val message = input[0]
    for (i in 13 until message.length) {
        val letters = mutableListOf<Char>()
        for (j in i downTo i-13){
            letters.add(message[j])
        }
        if (areUnique(letters)) {
            return i+1
        }
    }
    return -1
}

fun areUnique(letters: List<Char>): Boolean {
    val hashSet = HashSet<Char>()
    for (letter in letters) {
        if (hashSet.contains(letter)) {
            return false
        } else {
            hashSet.add(letter)
        }
    }
    return true
}

fun testAlg(firstHalf : Boolean) {
    val input = readInput("day6/day6_test")

    if (firstHalf) {
        println(part1(input))
    } else {
        println(part2(input))
    }
}