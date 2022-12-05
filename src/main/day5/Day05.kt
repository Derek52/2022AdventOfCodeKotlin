package main.day5

import main.readInput
import java.util.Stack

fun main() {
    val input = readInput("day5/day5")

    val stackA = Stack<Char>()
    stackify(stackA, "DTWFJSHN")

    val stackB = Stack<Char>()
    stackify(stackB, "HRPQTNBG")

    val stackC = Stack<Char>()
    stackify(stackC, "LQV")

    val stackD = Stack<Char>()
    stackify(stackD, "NBSWRQ")

    val stackE = Stack<Char>()
    stackify(stackE, "NDFTVMB")

    val stackF = Stack<Char>()
    stackify(stackF, "MDBVHTR")

    val stackG = Stack<Char>()
    stackify(stackG, "DBQJ")

    val stackH = Stack<Char>()
    stackify(stackH, "DNJVRZHQ")

    val stackI = Stack<Char>()
    stackify(stackI, "BNHMS")


    val stacks = arrayOf(stackA, stackB, stackC, stackD, stackE, stackF, stackG, stackH, stackI)

    val firstHalf = false
    //testAlg(firstHalf)

    if (firstHalf) {
        println(part1(input, stacks))
    } else {
        println(part2(input, stacks))
    }
}

fun part1(input: List<String>, stacks: Array<Stack<Char>>) : String {
    for (line in input) {
        val commands = line.split(" ")
        val command = Command(commands[1], commands[3], commands[5])
        for ( i in 1..command.move) {
            stacks[command.to-1].push(stacks[command.from-1].pop())
        }
    }
    return printStackTops(stacks)
}

data class Command(val move: Int, val from: Int, val to: Int) {
    constructor(moveString: String, fromString: String, toString: String) :
            this(moveString.toInt(), fromString.toInt(), toString.toInt())
}

fun part2(input: List<String>, stacks: Array<Stack<Char>>) : String {
    for (line in input) {
        val commands = line.split(" ")
        val command = Command(commands[1], commands[3], commands[5])

        val moveStack = Stack<Char>()
        for ( i in 1..command.move) {
            moveStack.push(stacks[command.from-1].pop())
        }
        while(moveStack.isNotEmpty()) {
            stacks[command.to-1].push(moveStack.pop())
        }
    }
    return printStackTops(stacks)
}

fun stackify(stack: Stack<Char>, items: String) {
    for (char in items) {
        stack.push(char)
    }
}

fun printStackTops(stacks: Array<Stack<Char>>) : String {
    val stringBuilder = StringBuilder()
    for (stack in stacks) {
        stringBuilder.append(stack.peek())
    }
    return stringBuilder.toString()
}
fun testAlg(firstHalf : Boolean) {
    val input = readInput("day5/day5_test")

    val stackA = Stack<Char>()
    stackify(stackA, "ZN")

    val stackB = Stack<Char>()
    stackify(stackB, "MCD")

    val stackC = Stack<Char>()
    stackC.push('P')

    if (firstHalf) {
        println(part1(input, arrayOf(stackA, stackB, stackC)))
    } else {
        println(part2(input, arrayOf(stackA, stackB, stackC)))
    }
}