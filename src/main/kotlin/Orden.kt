package lab2

class Orden {
    var nombre: String = ""
    var pupusas = CustomList<String>()

    fun añadir(tipo: String) {
        pupusas.add(tipo)
    }

    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("${nombre}: ")
        sb.append(pupusas.toString())

        return sb.toString()
    }  
}