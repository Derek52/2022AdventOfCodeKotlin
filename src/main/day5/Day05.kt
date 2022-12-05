package main.day5

import main.readInput
import java.util.Stack

fun main() {
    val input = readInput("day5/day5")

    val stackA = Stack<Char>()
    stackA.push('D')
    stackA.push('T')
    stackA.push('W')
    stackA.push('F')
    stackA.push('J')
    stackA.push('S')
    stackA.push('H')
    stackA.push('N')

    val stackB = Stack<Char>()
    stackB.push('H')
    stackB.push('R')
    stackB.push('P')
    stackB.push('Q')
    stackB.push('T')
    stackB.push('N')
    stackB.push('B')
    stackB.push('G')

    val stackC = Stack<Char>()
    stackC.push('L')
    stackC.push('Q')
    stackC.push('V')

    val stackD = Stack<Char>()
    stackD.push('N')
    stackD.push('B')
    stackD.push('S')
    stackD.push('W')
    stackD.push('R')
    stackD.push('Q')

    val stackE = Stack<Char>()
    stackE.push('N')
    stackE.push('D')
    stackE.push('F')
    stackE.push('T')
    stackE.push('V')
    stackE.push('M')
    stackE.push('B')

    val stackF = Stack<Char>()
    stackF.push('M')
    stackF.push('D')
    stackF.push('B')
    stackF.push('V')
    stackF.push('H')
    stackF.push('T')
    stackF.push('R')

    val stackG = Stack<Char>()
    stackG.push('D')
    stackG.push('B')
    stackG.push('Q')
    stackG.push('J')

    val stackH = Stack<Char>()
    stackH.push('D')
    stackH.push('N')
    stackH.push('J')
    stackH.push('V')
    stackH.push('R')
    stackH.push('Z')
    stackH.push('H')
    stackH.push('Q')

    val stackI = Stack<Char>()
    stackI.push('B')
    stackI.push('N')
    stackI.push('H')
    stackI.push('M')
    stackI.push('S')



    val firstHalf = true
    //testAlg(firstHalf)

    if (firstHalf) {
        println(part1(input, arrayOf(stackA, stackB, stackC, stackD, stackE, stackF, stackG, stackH, stackI)))
    } else {
        println(part2(input))
    }
}

fun part1(input: List<String>, stacks: Array<Stack<Char>>) {
    for (line in input) {
        val commands = line.split(" ")
        val command = Command(commands[1], commands[3], commands[5])
        //println("Command = move: ${command.move}   from: ${command.from}   to: ${command.to}")
        for ( i in 1..command.move) {

            stacks[command.to-1].push(stacks[command.from-1].pop())
        }
    }

    for (stack in stacks) {
        println(stack.peek())
    }
}

data class Command(val move: Int, val from: Int, val to: Int) {
    constructor(moveString: String, fromString: String, toString: String) :
            this(moveString.toInt(), fromString.toInt(), toString.toInt())
}

fun part2(input: List<String>) {

}

fun testAlg(firstHalf : Boolean) {
    val input = readInput("day5/day5_test")

    val stackA = Stack<Char>()
    stackA.push('Z')
    stackA.push('N')

    val stackB = Stack<Char>()
    stackB.push('M')
    stackB.push('C')
    stackB.push('D')

    val stackC = Stack<Char>()
    stackC.push('P')

    if (firstHalf) {
        println(part1(input, arrayOf(stackA, stackB, stackC)))
    } else {
        println(part2(input))
    }
}