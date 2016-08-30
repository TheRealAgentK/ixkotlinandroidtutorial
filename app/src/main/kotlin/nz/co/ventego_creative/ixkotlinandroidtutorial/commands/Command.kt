package nz.co.ventego_creative.ixkotlinandroidtutorial.commands

interface Command<T> {
    fun execute(): T
}