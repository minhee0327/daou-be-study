package chapter07

operator fun Point.times(scale: Double): Point{
    return Point((x * scale).toInt(), (y * scale).toInt())
}