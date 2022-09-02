package machine.soft.API

import machine.soft.database.TodoItemRepository
import machine.soft.dto.TodoItemDto
import javax.ws.rs.POST
import javax.ws.rs.Path

@Path("/todo")
class TodoItemAPI( val repo: TodoItemRepository) {

    @POST
    fun create(dto: TodoItemDto) = repo.create(dto)
}