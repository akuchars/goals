package com.akuchars.goals.habits

import com.akuchars.goals.habits.application.goal.command.GroupService
import com.akuchars.goals.habits.rest.dto.goal.GroupRestDto
import com.akuchars.goals.habits.rest.dto.goal.ListOfGroupRestDto
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.HttpStatus.OK
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController("/rest/v1/goals")
class GoalRestController(val service: GroupService) {

    @ResponseStatus(CREATED)
    @PostMapping(path = ["/group/create"], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun createNewGroup(@RequestBody goal: GroupRestDto) {
        service.save(goal)
    }

    @ResponseStatus(OK)
    @GetMapping(path = ["/group"])
    fun getAllGroups(): ListOfGroupRestDto {
        return service.getAllGroups()
    }
}