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

data class Range(val x:Int, val y:Int)

fun rangeInRange(left: Range, right: Range) : Boolean {
    return (left.x <= right.x && left.y >= right.y) || (right.x <= left.x && right.y >= left.y)
}
fun rangeOverlapsRange(left: Range, right: Range) : Boolean{
    return (right.x >= left.x && right.x <= left.y) || (right.y >= left.x && right.y <= left.y) ||
            (left.x >= right.x && left.x <= right.y) || (left.y >= right.x && left.y <= right.y)
}

fun part1(input: List<String>) : Int{
    var overlapCount = 0
    for (line in input) {
        val assignments = line.split(',')
        val elf1 = Assignment(assignments[0])
        val elf2 = Assignment(assignments[1])


        var overlap = if (elf1.range.x <= elf2.range.x) {
            rangeInRange(elf1.range, elf2.range)
        } else {
            rangeInRange(elf2.range, elf1.range)
        }

        if (overlap) {
            overlapCount++
        }
    }
    return overlapCount
}

fun part2(input: List<String>) : Int {
    var overlapCount = 0
    for (line in input) {
        val assignments = line.split(',')
        val elf1 = Assignment(assignments[0])
        val elf2 = Assignment(assignments[1])


        if (rangeOverlapsRange(elf1.range, elf2.range)) {
            overlapCount++
        }
    }
    return overlapCount
}

data class Assignment(val assignment: String) {
    var a: Int = 0
    var b: Int = 0
    var range = Range(0, 0)
    init {
        val boundaries = assignment.split("-")
        a = boundaries[0].toInt()
        b = boundaries[1].toInt()
        range = Range(a, b)
    }
}

fun testAlg(firstHalf : Boolean) {
    val input = readInput("day4/day4_test")

    if (firstHalf) {
        println(part1(input))
    } else {
        println(part2(input))
    }
}