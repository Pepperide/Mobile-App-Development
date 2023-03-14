fun <T> List<T>.customAppend(list: List<T>): List<T> {
    val new:MutableList<T> = mutableListOf();
    new.addAll(this);
    new.addAll(list);
    return new.toList();
}

fun List<Any>.customConcat(): List<Any> {
    val new:MutableList<Any> = mutableListOf();
    this.forEach {
        if(it is List<*>)
            new.addAll((it as List<Any>).customConcat())
        else
            new.add(it)
    }

    return new.toList()
}

fun <T> List<T>.customFilter(predicate: (T) -> Boolean): List<T> {
    val new:MutableList<T> = mutableListOf();
    new.addAll(this.filter(predicate))
    return new.toList();
}

val List<Any>.customSize: Int get() = this.size

fun <T, U> List<T>.customMap(transform: (T) -> U): List<U> {
    val new:MutableList<U> = mutableListOf();
    new.addAll(this.map(transform))
    return new.toList();
}

fun <T, U> List<T>.customFoldLeft(initial: U, f: (U, T) -> U): U {
    if(this.size==0)
        return initial
    else
        return f(this.reduce { acc, t -> f(acc as U,t) as T } as U,initial as T)
}

fun <T, U> List<T>.customFoldRight(initial: U, f: (T, U) -> U): U {
    if(this.size==0)
        return initial
    else
        return f(initial as T,this.reversed().reduce { acc, t -> f(acc,t as U) as T } as U)
}

fun <T> List<T>.customReverse(): List<T> {
    return this.reversed()
}
