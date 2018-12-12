fun bresenhamLine(ax: Int, ay: Int, bx: Int, by: Int) {
    var w = bx - ax
    var h = by - ay
    val dx = if (w > 0) 1 else -1
    val dy = if (h > 0) 1 else -1
    val swapXY = Math.abs(h.toFloat() / w.toFloat()) > 1
    w = Math.abs(w)
    h = Math.abs(h)
    val arraySize = Math.max(w, h) + 1
    val x = IntArray(arraySize)
    val y = IntArray(arraySize)
    val f = IntArray(arraySize)
    x[0] = ax
    y[0] = ay
    f[0] = if (swapXY) 2 * w - h else 2 * h - w
    var i = 0
    while (x[i] != bx || y[i] != by) {
        i++
        if (!swapXY) {
            x[i] = x[i - 1] + dx
            if (f[i - 1] < 0) {
                f[i] = f[i - 1] + 2 * h
                y[i] = y[i - 1]
            } else {
                f[i] = f[i - 1] + 2 * (h - w)
                y[i] = y[i - 1] + dy
            }
        } else {
            y[i] = y[i - 1] + dy
            if (f[i - 1] < 0) {
                f[i] = f[i - 1] + 2 * w
                x[i] = x[i - 1]
            } else {
                f[i] = f[i - 1] + 2 * (w - h)
                x[i] = x[i - 1] + dx
            }
        }
    }
    print("x: ")
    for (element in x) print("%6d".format(element))
    print("\ny: ")
    for (element in y) print("%6d".format(element))
    print("\nf: ")
    for (element in f) print("%6d".format(element))
    println()
}

fun main(args: Array<String>) {
    println("Area I")
    bresenhamLine(4, 1, 12, 5)
    println("Area II")
    bresenhamLine(2, 3, 6, 10)
    println("Area III")
    bresenhamLine(-1, 2, -4, 9)
    println("Area IV")
    bresenhamLine(-5, 2, -11, 5)
    println("Area V")
    bresenhamLine(-5, -2, -11, -5)
    println("Area VI")
    bresenhamLine(-1, -2, -4, -9)
    println("Area VII")
    bresenhamLine(2, -3, 6, -10)
    println("Area VIII")
    bresenhamLine(4, -1, 12, -5)
}
