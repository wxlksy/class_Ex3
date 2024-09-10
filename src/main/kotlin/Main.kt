import kotlin.math.sqrt

data class Point(val x: Double, val y: Double)
{

    fun dist(other: Point): Double
    {
        val dx = this.x - other.x
        val dy = this.y - other.y
        return sqrt(dx * dx + dy * dy)
    }
}

fun main()
{
    try
    {
        println("Введите кол-во точек:")

        val num = readLine()?.toIntOrNull() ?: throw NumberFormatException()

        if (num <= 2)
        {
            throw IllegalArgumentException("Кол-во больше двух!!!!!!!!!!")
        }

        val p = mutableListOf<Point>()

        for (i in 1..num)
        {
            println("Введите координаты точки $i (x y):")
            p.add(readP())
        }

        val (min, max) = MinMax(p)
        println("Мин: $min")
        println("Макс: $max")
    }

    catch (e: NumberFormatException)
    {
        println("Ошибка ввода")
    }

    catch (e: IllegalArgumentException)
    {
        println(e.message)
    }
}

fun readP(): Point
{
    val s = readLine()?.split(" ") ?: throw NumberFormatException()

    if (s.size != 2)
    {
        throw NumberFormatException()
    }

    val x = s[0].toDouble()
    val y = s[1].toDouble()
    return Point(x, y)
}

fun MinMax(points: List<Point>): Pair<Double, Double>
{
    var minD = Double.MAX_VALUE
    var maxD = Double.MIN_VALUE

    for (i in 0 until points.size)
    {
        for (j in i + 1 until points.size)
        {
            val dist = points[i].dist(points[j])

            if (dist < minD)
            {
                minD = dist
            }

            if (dist > maxD)
            {
                maxD = dist
            }
        }
    }

    return Pair(minD, maxD)
}