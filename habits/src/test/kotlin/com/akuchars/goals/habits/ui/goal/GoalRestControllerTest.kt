package com.akuchars.goals.habits.ui.goal

import com.akuchars.goals.habits.application.goal.command.GroupService
import com.akuchars.goals.habits.rest.dto.goal.ListOfGroupRestDto
import com.akuchars.goals.habits.companion.andGet
import com.akuchars.goals.habits.domain.goal.model.Group
import com.akuchars.goals.habits.kernel.toJson
import com.akuchars.goals.habits.rest.dto.goal.ColorRestDto.BLACK
import com.akuchars.goals.habits.rest.dto.goal.GroupRestDto
import io.mockk.every
import io.mockk.mockk
import io.vavr.control.Either
import io.vavr.control.Option
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.http.MediaType
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders

@ExtendWith(SpringExtension::class)
internal class GoalRestControllerTest {

    private lateinit var service: GroupService
    private lateinit var mockMvc: MockMvc

    @BeforeEach
    internal fun setUp() {
        //given
        service = mockk<GroupService>(relaxed = true).apply {
            every { getAllGroups() } returns ListOfGroupRestDto()
        }
        mockMvc = MockMvcBuilders
                .standaloneSetup(GoalRestController(service))
                .build()
    }

    @Test
    fun `should properly save group rest dto`() {
        val result = mockMvc.perform(post("http://localhost:1994/rest/v1/goals/groups")
                .contentType(MediaType.APPLICATION_JSON)
                .content((GroupRestDto(1L, "", BLACK, setOf())).toJson())
        )

        result.andExpect(status().isCreated)
    }


    @Test
    fun `should return properly lists`() {
        //when
        val result = mockMvc.perform(get("http://localhost:1994/rest/v1/goals/groups"))
                .andGet(ListOfGroupRestDto::class)

        assertThat(result).isInstanceOf(ListOfGroupRestDto::class.java)
        assertThat(result).isEqualToComparingFieldByField(ListOfGroupRestDto())
    }
}