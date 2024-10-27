package lab2

data class Node<T>(
    var value: T,
    var next: Node<T>? = null
)