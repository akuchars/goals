package com.akuchars.goals.habits.ui.goal

import com.akuchars.goals.habits.application.habit.command.HabitService
import com.akuchars.goals.habits.rest.dto.goal.HabitTemplateRestDto
import com.akuchars.goals.habits.rest.dto.goal.ListOfHabitTemplateRestDto
import io.vavr.control.Option
import org.springframework.http.HttpStatus.OK
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/rest/v1/goals"])
class HabitTemplateRestController(private val goalService: HabitService) {

    @ResponseStatus(OK)
    @GetMapping(path = ["/templates"])
    fun getAllTemplates(@RequestParam("groupId", required = false) groupId: Long?): ListOfHabitTemplateRestDto {
        return goalService.getAllTemplatesBy(groupId)
    }

    @ResponseStatus(OK)
    @GetMapping(path = ["/templates/{id}"])
    fun getTemplate(@PathVariable id: Long): Option<HabitTemplateRestDto> {
        return goalService.getTemplateById(id)
    }

    @RequestMapping(path = ["/templates"], method = [RequestMethod.POST])
    fun createNewHabit(@RequestBody dto: HabitTemplateRestDto) {
        goalService.createTemplate(dto)
    }
}