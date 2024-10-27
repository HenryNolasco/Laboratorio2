package lab2

import kotlin.system.exitProcess

fun main() {
    val ordenesPendientes = Queue<Orden>()
    val ordenesDespachadas = Stack<Orden>()

    bienvenida(ordenesPendientes, ordenesDespachadas)
}

fun bienvenida(pendientes: Queue<Orden>, despachadas: Stack<Orden>) {
    println("Bienvenido a la Pupuseria \"El Comalito\"")
    println("Seleccione una opcion:")
    println("1. Registrar una nueva orden")
    println("2. Ver ordenes pendientes")
    println("3. Despachar orden")
    println("4. Ver ordenes despachadas")
    println("5. Salir")
    println()

    val seleccion = readLine()

    if (seleccion == "1") {
        registrar(pendientes, despachadas)
    } else if (seleccion == "2") {
        verPendientes(pendientes, despachadas)
    } else if (seleccion == "3") {
        despachar(pendientes, despachadas)
    } else if (seleccion == "4") {
        verDespachadas(pendientes, despachadas)
    } else if (seleccion == "5") {
        exitProcess(0)
    } else {
        throw IllegalArgumentException("Seleccione un numero entre 1 y 5")
    } 
}

fun registrar(pendientes: Queue<Orden>, despachadas: Stack<Orden>) {
    val orden = Orden()

    print("Ingrese el nombre del cliente: ")
    orden.nombre = readLine()!!

    print("Cuantos tipos de pupusas desea ordenar? : ")
    var tipos = readLine()!!.toInt()

    for (i in 1..tipos) {
        print("\nIngrese el tipo de pupusa #${i}: ")
        var tipo = readLine()!!

        print("Ingrese la cantidad de pupusas ${tipo}: ")
        var cantidad = readLine()!!.toInt()

        if (cantidad == 1) {
            orden.añadir("${cantidad} pupusa de ${tipo}")
        } else {
            orden.añadir("${cantidad} pupusas de ${tipo}")
        }
    }

    pendientes.enqueue(orden);
    println("\nOrden registrada para ${orden.toString()} \n")

    bienvenida(pendientes, despachadas)
}

fun verPendientes(pendientes:Queue<Orden>, despachadas: Stack<Orden>) {
    println("Ordenes pendientes:")

    print(pendientes.toString())
    println()
    bienvenida(pendientes, despachadas)
}

fun despachar(pendientes: Queue<Orden>, despachadas: Stack<Orden>) {
    print("Despachado la orden de: ")

    val orden = pendientes.dequeue()
    print("${orden.toString()}.\n")
    println()

    despachadas.push(orden!!)
    bienvenida(pendientes, despachadas)
}

fun verDespachadas(pendientes: Queue<Orden>, despachadas: Stack<Orden>) {
    println("Ordenes despachadas:")

    print(despachadas.toString())
    println()
    bienvenida(pendientes, despachadas)
}