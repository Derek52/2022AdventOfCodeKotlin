package main.day8

import main.readInput

fun main() {
    val input = readInput("day8/day8")


    val firstHalf = true
    testAlg(firstHalf)

    if (firstHalf) {
        //println(part1(input))
    } else {
        println(part2(input))
    }
}

enum class Direction {
    LEFT, RIGHT, UP, DOWN, ALL
}

data class Vertex(val x: Int, val y:Int)

data class ElfTree(val height: Int, var visible: Boolean = true, var visited: Boolean = false)

fun part1(input: List<String>) : Int {
    val matrix = Array(input.size) { Array(input[0].length) { ElfTree(0)} }

    for (i in input.indices) {
        for (j in input[i].indices) {
            if (i == 0 || i == input.size - 1 || j == 0 || j == input.size - 1) {
                matrix[i][j] = ElfTree(input[i][j].digitToInt(), true)
            } else matrix[i][j] = ElfTree(input[i][j].digitToInt())
        }
    }

    val visited = HashMap<Direction, HashSet<Vertex>>()
    for (direction in Direction.values()) {
        visited[direction] = HashSet<Vertex>()
    }
    for (i in matrix.indices) {
        for (j in 0 until matrix[i].size) {
            dfs(Vertex(i, j), matrix, Direction.ALL, 10, visited)
        }
    }

    var visibleCount = 0
    for (i in matrix.indices) {
        for (j in 0 until matrix[i].size) {
            if (matrix[i][j].visible) {
                print("${matrix[i][j].height} ")
                visibleCount++
            } else {
                print("X ")
            }
        }
        println()
    }
    return visibleCount
}

fun dfs(vertex: Vertex, graph: Array<Array<ElfTree>>, direction: Direction, prevHeight: Int, visited: HashMap<Direction, HashSet<Vertex>>) {
    if(isOutOfBounds(vertex, graph.size -1) || visited[direction]!!.contains(vertex)
        ) {
        return
    }

    if (graph[vertex.x][vertex.y].height < prevHeight) {
        graph[vertex.x][vertex.y].visible = false
    }

    visited[direction]!!.add(vertex)
    //graph[vertex.x][vertex.y].visited = true
    //graph[vertex.x][vertex.y].visib
    // le = true
    val height = graph[vertex.x][vertex.y].height
    println("Checking $height")
    when(direction) {
        Direction.ALL -> {
            dfs(Vertex(vertex.x-1, vertex.y), graph, Direction.LEFT, height, visited)
            dfs(Vertex(vertex.x+1, vertex.y), graph, Direction.RIGHT, height, visited)
            dfs(Vertex(vertex.x, vertex.y+1), graph, Direction.UP, height, visited)
            dfs(Vertex(vertex.x, vertex.y-1), graph, Direction.DOWN, height, visited)
        }
        Direction.LEFT -> {
            dfs(Vertex(vertex.x-1, vertex.y), graph, Direction.LEFT, height, visited)
        }
        Direction.RIGHT -> {
            dfs(Vertex(vertex.x+1, vertex.y), graph, Direction.RIGHT, height, visited)
        }
        Direction.UP -> {
            dfs(Vertex(vertex.x, vertex.y+1), graph, Direction.UP, height, visited)
        }
        Direction.DOWN -> {
            dfs(Vertex(vertex.x, vertex.y-1), graph, Direction.DOWN, height, visited)
        }
    }

}

fun isOutOfBounds(vertex: Vertex, bounds: Int) : Boolean {
    //println("isOutOfBounds")
    return vertex.x == 0 || vertex.x == bounds || vertex.y == 0 || vertex.y == bounds
}
fun part2(input: List<String>) {

}

fun testAlg(firstHalf : Boolean) {
    val input = readInput("day8/day8_test")

    if (firstHalf) {
        println(part1(input))
    } else {
        println(part2(input))
    }
}