fun main() {
    fun part1(input: List<String>): Long {
        var sum = 0L
        input.forEach {
            val digits = getDigits(it)
            val number = "${digits.first()}${digits.last()}"
            val result = number.toLong()
            sum += result
        }
        return sum
    }

    fun part2(input: List<String>): Long {
        var sum = 0L
        input.forEach {
            val newString = findAndReplace(it)
            val digits = getDigits(newString)
            val number = "${digits.first()}${digits.last()}"
            val result = number.toLong()
            sum += result
        }
        return sum
    }

    val input = readInput("Day01")
    println("Part 1: ${part1(input)}")
    println("Part 2: ${part2(input)}")
}

fun getDigits(line: String) = line.filter {
    it.isDigit()
}

fun findAndReplace(line: String) = line
    .replace("one", "one1one", true)
    .replace("two", "two2two", true)
    .replace("three", "three3three", true)
    .replace("four", "four4four", true)
    .replace("five", "five5five", true)
    .replace("six", "six6six", true)
    .replace("seven", "seven7seven", true)
    .replace("eight", "eight8eight", true)
    .replace("nine", "nine9nine", true)
