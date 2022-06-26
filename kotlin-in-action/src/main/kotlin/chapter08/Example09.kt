package chapter08

import chapter08.OS.WINDOWS

val averageWindowsDuration = log
    .filter { it.os == WINDOWS }
    .map { it.duration }
    .average()