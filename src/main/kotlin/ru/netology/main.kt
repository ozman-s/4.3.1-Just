package ru.netology

fun main() {
    val seconds = 186401// в секундах (от 0 до 60, от 61 до 60*60 (один час), от 60*60+1 до 24*60*60 и т.д.

    val minutes = seconds / 60
    val hours = seconds / 3600

    val minutesString = calculateMinutes(seconds = seconds)
    val hoursString = calculateHours(seconds = seconds)

    val result = when (seconds) {
        in 0..60 -> "Был в сети только что"
        in 61..3_600 -> "Был в сети $minutes $minutesString назад"
        in 3_601..86_400 -> "Был в сети $hours $hoursString назад"
        in 86_401..172_800 -> "Был в сети сегодня"
        in 172_801..259_200 -> "Был в сети вчера"
        else -> "Был в сети давно"
    }
    println(result)
}

fun calculateMinutes(seconds: Int): String =
    when (seconds / 60) {
        1, 21, 31, 41, 51 -> "минуту"
        in 2..4, in 22..24, in 32..34, in 42..44, in 52..54 -> "минуты"
        else -> "минут"
    }

fun calculateHours(seconds: Int): String =
    when (seconds / 3600) {
        1, 21 -> "час"
        in 2..4, in 22..24 -> "часа"
        else -> "часов"
    }