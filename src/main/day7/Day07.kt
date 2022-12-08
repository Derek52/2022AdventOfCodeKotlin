package main.day7

import main.readInput
import java.util.*
import kotlin.collections.HashSet

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

data class Directory(var name: String, var size: Long = 0,
                     val children: MutableList<Directory> = mutableListOf())

fun part1(input: List<String>) : Long {
    var currentDirectory = Directory("/")
    val directoryList = mutableListOf<Directory>(currentDirectory)
    val rootNode = currentDirectory
    val previousDirectoryStack = Stack<Directory>()
    previousDirectoryStack.push(currentDirectory)
    for (line in input) {
        //println(line)
        val command = line.split(" ")
        if (command[0] == "$") {
            if (command[1] == "cd") {
                if (command[2] == "..") {
                    currentDirectory = previousDirectoryStack.pop()
                } else {
                    currentDirectory = Directory(command[2])
                    directoryList.add(currentDirectory)
                    //println("Current directory: ${currentDirectory.name}  size: ${currentDirectory.size}")
                    previousDirectoryStack.peek().children.add(currentDirectory)
                    previousDirectoryStack.push(currentDirectory)
                }
            } else if(command[1] == "ls") {
            }
        } else if (command[0] == "dir"){
        } else {
            currentDirectory.size += command[0].toLong()
            //println("${currentDirectory.name}.size += ${command[0]}")
            //println("${currentDirectory.size}.size += ${command[0]}")
        }
    }

    val sums = mutableListOf<Long>()

    sumDirectories(rootNode, sums, HashSet())

    println("Root: ${rootNode.name}  size: ${rootNode.size} ")
    for (child in rootNode.children) {
        println("${child.name} is a child")
    }

    var totalSum = 0L


    for (directory in directoryList) {
        if (directory.size <= 100000) {
            totalSum += directory.size
        }
    }

    return totalSum
}

fun sumDirectories(directory: Directory, sums: MutableList<Long>, visit: HashSet<Directory>) : Long {
    if (visit.contains(directory)) {
        return 0
    }
    if (directory.children.isEmpty()) {
        println("${directory.name} has size ${directory.size}")
        return directory.size
    }

    visit.add(directory)
    for (child in directory.children) {
        directory.size += sumDirectories(child, sums,  visit)
    }
    println("${directory.name} has size ${directory.size}")
    return directory.size
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