package main.day2

import main.readInput
fun main() {
    val input = readInput("day2/day2")

    //testAlg()

    val firstHalf = false

    if (firstHalf) {
        println(part1(input))
    } else {
        println(part2(input))
    }

}

fun part1(input: List<String>) : Int {
    var opponent = Throw.ROCK
    var me = Throw.ROCK

    var score = 0
    for (line in input) {
        val opponentThrow = line[0]
        val meThrow = line[2]

        opponent = when (opponentThrow) {
            'A' -> Throw.ROCK
            'B' -> Throw.PAPER
            else -> Throw.SCISSORS
        }

        me = when (meThrow) {
            'X' -> Throw.ROCK
            'Y' -> Throw.PAPER
            else -> Throw.SCISSORS
        }

        if (me == opponent) {
            score += 3
        } else if ((me.value-1 == opponent.value) || (me == Throw.ROCK && opponent == Throw.SCISSORS)) {
            score += 6
        }

        score += when (me) {
            Throw.ROCK -> 1
            Throw.PAPER -> 2
            Throw.SCISSORS -> 3
        }
    }

    return score
}

enum class Throw(val value: Int) {
    ROCK(1), PAPER(2), SCISSORS(3)
}

enum class Strategy(val points: Int) {
    LOSE(0), DRAW(3), WIN(6)
}

fun part2(input: List<String>) : Int {

    var strat = Strategy.LOSE
    var opponentThrow = Throw.ROCK
    var myThrow = Throw.ROCK

    var score = 0
    for (line in input) {
        val opponent = line[0]
        val me = line[2]

        opponentThrow = when (opponent) {
            'A' -> Throw.ROCK
            'B' -> Throw.PAPER
            else -> Throw.SCISSORS
        }

        strat = when (me) {
            'X' -> Strategy.LOSE
            'Y' -> Strategy.DRAW
            else -> Strategy.WIN
        }

        score += strat.points

        when(strat) {
            Strategy.LOSE -> myThrow = getLoser(opponentThrow)
            Strategy.DRAW -> myThrow = opponentThrow
            Strategy.WIN -> myThrow = getWinner(opponentThrow)
        }

        score += myThrow.value
    }

    return score
}

fun getWinner(pick: Throw) : Throw {
    return when (pick) {
        Throw.ROCK -> Throw.PAPER
        Throw.PAPER -> Throw.SCISSORS
        Throw.SCISSORS -> Throw.ROCK
    }
}

fun getLoser(pick: Throw) : Throw {
    return when (pick) {
        Throw.ROCK -> Throw.SCISSORS
        Throw.PAPER -> Throw.ROCK
        Throw.SCISSORS -> Throw.PAPER
    }
}

fun testAlg() {
    //tests part 1.
    val a = listOf<String>("A X")
    val b = listOf<String>("A Y")
    val c = listOf<String>("A Z")

    val d = listOf<String>("B X")
    val e = listOf<String>("B Y")
    val f = listOf<String>("B Z")

    val g = listOf<String>("C X")
    val h = listOf<String>("C Y")
    val i = listOf<String>("C Z")

    println("Part1(${a[0]}) = ${part1(a)} should be 4")
    println("Part1(${b[0]}) = ${part1(b)} should be 8")
    println("Part1(${c[0]}) = ${part1(c)} should be 3")

    println("Part1(${d[0]}) = ${part1(d)} should be 1")
    println("Part1(${e[0]}) = ${part1(e)} should be 3")
    println("Part1(${f[0]}) = ${part1(f)} should be 9")

    println("Part1(${g[0]}) = ${part1(g)} should be 7")
    println("Part1(${h[0]}) = ${part1(h)} should be 2")
    println("Part1(${i[0]}) = ${part1(i)} should be 6")

}