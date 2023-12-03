fun main() {
    fun part1(input: List<String>): Int {
        var sum = 0
        input.forEach{
            sum += checkValidGame(it)
        }
        println("sum: $sum")
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}

fun checkValidGame(line: String): Int {
    val gameId = line.substringBefore(":").replace("Game ", "")

    val outcome = line.substringAfter(": ").split(";")

    return if (checkSet(outcome) == 0) {
        gameId.toInt()
    } else 0
}

fun checkSet(list: List<String>): Int {
    var sum = 0
    list.forEach{ set ->
        sum += extracted(set)
    }
    return sum
}

private fun extracted(set: String): Int {
    var sumFalse = 0
    set.split(",").forEach { item ->
        sumFalse += checkRed(item)
        sumFalse += checkGreen(item)
        sumFalse += checkBlue(item)
    }
    return sumFalse
}

fun checkRed(line: String): Int {
    return if (line.contains("red")) {
        val number = line.filter {
            it.isDigit()
        }.toInt()
        if (number > 12) {
            1
        } else 0
    } else 0
}

fun checkGreen(line: String): Int {
    return if (line.contains("green")) {
        val number = line.filter {
            it.isDigit()
        }.toInt()
        if (number > 13) {
            1
        } else 0
    } else 0
}

fun checkBlue(line: String): Int {
    return if (line.contains("blue")) {
        val number = line.filter {
            it.isDigit()
        }.toInt()
        if (number > 14) {
            1
        } else 0
    } else 0
}
