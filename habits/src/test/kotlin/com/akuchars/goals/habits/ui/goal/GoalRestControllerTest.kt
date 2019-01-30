package com.akuchars.goals.habits.ui.goal

import com.akuchars.goals.habits.application.goal.command.GroupService
import com.akuchars.goals.habits.rest.dto.goal.ListOfGroupRestDto
import com.akuchars.goals.habits.companion.andGet
import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.setup.MockMvcBuilders

@ExtendWith(SpringExtension::class)
internal class GoalRestControllerTest {

    private lateinit var service: GroupService


    @Test
    fun `should return properly lists`() {
        //given
        service = mockk<GroupService>().apply {
            every { getAllGroups() } returns ListOfGroupRestDto()
        }
        val mockMvc = MockMvcBuilders
                .standaloneSetup(GoalRestController(service))
                .build()

        //when
        val result = mockMvc.perform(get("http://localhost:1994/rest/v1/goals/group"))
                .andGet(ListOfGroupRestDto::class)

        assertThat(result).isInstanceOf(ListOfGroupRestDto::class.java)
        assertThat(result).isEqualToComparingFieldByField(ListOfGroupRestDto())
    }
}