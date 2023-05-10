enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val idUsuario: Int, var nome: String) {
    override fun equals(other: Any?) =
            other is Usuario && other.idUsuario == this.idUsuario

    override fun toString(): String {
        return "${idUsuario}-${nome}"
    }
}

data class ConteudoEducacional(var nome: String, var duracao: Int = 120) {
    override fun toString(): String {
        return "${nome} - duração: ${duracao} \n"
    }
}

data class Formacao(val nome: String,
                    val nivel: Nivel,
                    var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }

    fun matricular(usuarios: List<Usuario>) {
        for (usuario in usuarios) {
            matricular(usuario)
        }
    }

    override fun toString(): String {
        return "Formacao ${nome} - Nível ${nivel} \n" +
               "Conteúdos: \n" +
               "${conteudos} \n" +
               "Lista matriculados: ${inscritos}"
    }
}

fun main() {
    val conhecendoKotlin = ConteudoEducacional("Conhecendo o Kotlin e Sua Documentação Oficial", 60)
    val introducaoKotlin = ConteudoEducacional("Introdução Prática à Linguagem de Programação Kotlin")
    val controleFluxo = ConteudoEducacional("Estruturas de Controle de Fluxo e Coleções em Kotlin")
    val orientacaoObjtos = ConteudoEducacional("Orientação a Objetos e Tipos de Classes na Prática com Kotlin")
    val conteudos = listOf<ConteudoEducacional>(conhecendoKotlin, introducaoKotlin, controleFluxo, orientacaoObjtos)

    var formacaoKotlinBasico = Formacao("Dominando a linguagem de Programação Kotlin", Nivel.BASICO, conteudos)

    val usuario1 = Usuario(1, "Maria")
    formacaoKotlinBasico.matricular(usuario1)
    val usuario2 = Usuario(2, "Pedro")

    formacaoKotlinBasico.matricular(usuario2)

    val usuario3 = Usuario(3, "Andre")
    val usuario4 = Usuario(4, "Thiago")
    val usuario5 = Usuario(5, "João")
    val usuarios = listOf<Usuario>(usuario3, usuario4, usuario5)
    formacaoKotlinBasico.matricular(usuarios)

    println(formacaoKotlinBasico)

    val conteudosIntermediario = listOf<ConteudoEducacional>(
            ConteudoEducacional("Desafio Data por extenso", 60),
            ConteudoEducacional("Desafio calculadora salarial", 60),
            ConteudoEducacional("Desafio Taxa de Crescimento", 60))
    var formacaoKotlinIntermediario = Formacao("Refinando Técnicas", Nivel.INTERMEDIARIO, conteudosIntermediario)
    formacaoKotlinIntermediario.matricular(usuarios)

    println(formacaoKotlinIntermediario)
}