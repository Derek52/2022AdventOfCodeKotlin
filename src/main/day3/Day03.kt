package main.day3

import main.readInput

val priorityMap = HashMap<Char, Int>()

fun main() {
    val input = readInput("day3/day3")

    var count = 1

    val alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"

    for (letter in alphabet) {
        priorityMap[letter] = count
        count++
    }


    val firstHalf = false
    //testAlg(firstHalf)

    if (firstHalf) {
        println((part1(input)))
    } else {
        println((part2(input)))
    }

}

fun part1(input: List<String>) : Int {
    var prioritySum = 0
    for (line in input) {
        val hashSet = HashSet<Char>()
        val a = line.substring(0, line.length/2)
        val b = line.substring(line.length/2)

        for (letter in a) {
            hashSet.add(letter)
        }

        for (letter in b) {
            if (hashSet.contains(letter)) {
                prioritySum += priorityMap[letter]!!
                continue
            }
        }
    }
    return prioritySum
}

fun part2(input: List<String>) : Int {
    var prioritySum = 0

    for (i in input.indices step 3) {
        val hashMap = HashMap<Char, Int>()

        for (letter in input[i]) {
            if (!hashMap.contains(letter)) {//if hashmap does not contain letter already
                hashMap[letter] = 1
            }
        }

        for (letter in input[i+1]) {
            if (hashMap.contains(letter)) {
                hashMap[letter] = 2
            }
        }

        for (letter in input[i+2]) {
            if (hashMap.contains(letter)) {
                if (hashMap[letter] == 2) {
                    //println("Shared letter is ${letter}")
                    prioritySum += priorityMap[letter]!!
                    break
                }
            }
        }
    }

    return prioritySum
}

fun testAlg(firstHalf: Boolean) {
    val input = readInput("day3/test_day3")

    if (firstHalf) {
        println(part1(input))
    } else {
        println(part2(input))
    }
}