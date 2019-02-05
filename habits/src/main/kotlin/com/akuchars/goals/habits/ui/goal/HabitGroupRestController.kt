package com.akuchars.goals.habits.ui.goal

import com.akuchars.goals.habits.application.habit.command.GroupService
import com.akuchars.goals.habits.rest.dto.goal.HabitGroupRestDto
import com.akuchars.goals.habits.rest.dto.goal.ListOfHabitGroupRestDto
import io.vavr.control.Option
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.HttpStatus.OK
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod.POST
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
@RequestMapping(path = ["/rest/v1/goals"])
class HabitGroupRestController(val service: GroupService) {

    @ResponseStatus(CREATED)
    @RequestMapping(
            path = ["/groups"],
            method = [POST]
    )
    fun createNewGroup(@RequestBody goal: HabitGroupRestDto): ResponseEntity<*> {
        service.save(goal)
        return ResponseEntity.created(URI("/groups")).build<Any>()
    }

    @ResponseStatus(OK)
    @GetMapping(path = ["/groups"])
    fun getAllGroups(): ListOfHabitGroupRestDto {
        return service.getAllGroups()
    }

    @ResponseStatus(OK)
    @GetMapping(path = ["/groups/{id}"])
    fun getGroupById(@PathVariable id: Long): Option<HabitGroupRestDto> {
        return service.getGroupById(id)
    }
}