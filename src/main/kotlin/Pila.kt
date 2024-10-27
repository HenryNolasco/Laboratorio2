package lab2

class Stack<T> {
    private var top: Node<T>? = null
    var size: Int = 0

    fun push(value: T ) {
        val newNode = Node(value, top)
        top = newNode
        size++
    }

    fun peek(): T? {
        return top?.value
    }

    fun isEmpty(): Boolean {
        return size == 0
    }

    fun pop(): T? {
        if (isEmpty()) return null

        val poppedValue = top?.value
        top = top?.next
        size--

        return poppedValue
    }

    override fun toString(): String {
        if (isEmpty()) return "[]"
        var counter = 1
        val sd = StringBuilder("")
        var pivot = top

        while (pivot != null) {
            sd.append("${counter}. ${pivot.value}\n")
            pivot = pivot.next

            if (pivot != null) counter++
        }

        return sd. toString()
    }
} 