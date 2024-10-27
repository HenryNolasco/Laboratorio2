package lab2

class Queue<T> {
    private var front: Node<T>? = null
    private var rear: Node<T>? = null
    private var size = 0

    fun enqueue(value: T) {
        val newNode = Node(value)
        if (rear != null) {
            rear?.next = newNode
        }
        rear = newNode
        if (front == null) {
            front = rear
        }
        size++
    }

    fun dequeue(): T? {
        if (isEmpty()) {
            println("Queue is empty.")
            return null
        }
        val dequeueValue = front?. value
        front = front?.next
        if (front == null) {
            rear = null
        }
        size--
        return dequeueValue
    }

    fun peek(): T? {
        return front?.value
    }

    fun isEmpty(): Boolean {
        return front == null
    }

    fun size(): Int {
        return size
    }

    override fun toString(): String {
        if (isEmpty()) return ""
        var counter = 1
        var result = StringBuilder("")
        var current = front
        while (current != null) {
            result.append("${counter}. ${current.value} \n")
            if (current. next != null) {
                counter++
            }
            current = current.next
        }
        return result. toString()
    }
}