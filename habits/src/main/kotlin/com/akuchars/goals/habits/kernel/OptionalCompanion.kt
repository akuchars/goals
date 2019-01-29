package com.akuchars.goals.habits.kernel

import java.util.Optional

val <T> Optional<T>.orNull: T?
    get() {
        return this.orElse(null)
    }
