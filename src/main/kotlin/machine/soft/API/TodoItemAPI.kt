package machine.soft.API

import machine.soft.dto.TodoItemDto
import machine.soft.service.TodoItemService
import javax.ws.rs.POST
import javax.ws.rs.Path

@Path("/todo")
class TodoItemAPI( val s: TodoItemService) {

    @POST
    fun create(dto: TodoItemDto) = s.create(dto)
}