package com.akuchars.goals.habits.rest.dto.goal

enum class ScheduleTypeRestDto(val schedule: String) {
    EVERY_DAY("0/1 0 0 ? * * *");

    companion object {
        fun find(schedule: String): ScheduleTypeRestDto = ScheduleTypeRestDto.values().find { it.name == schedule } ?: EVERY_DAY
    }
}