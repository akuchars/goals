package com.akuchars.goals.habits.kernel

import io.vavr.control.Either
import io.vavr.kotlin.`try`
import org.springframework.data.repository.CrudRepository

fun <DTO, T, ID> CrudRepository<T, ID>.saveWithValidate(
        dto: DTO,
        function: (DTO) -> T,
        validation: (T) -> Boolean
): Either<Throwable, T> {
    return `try` { dto }
            .mapTry { function.invoke(it) }
            .filter{ validation.invoke(it) }
            .mapTry { this.save(it) }
            .toEither()
}