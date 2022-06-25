package chapter07

operator fun Point.plus(other: Point): Point{
    return Point(x + other.x, y + other.y)
}