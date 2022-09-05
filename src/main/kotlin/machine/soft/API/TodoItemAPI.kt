package machine.soft.API

import machine.soft.dto.TodoItemDto
import machine.soft.service.TodoItemService
import java.util.UUID
import javax.ws.rs.DELETE
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.PUT
import javax.ws.rs.Path

@Path("/todo")
class TodoItemAPI( val s: TodoItemService) {

    @POST
    fun create(dto: TodoItemDto) = s.create(dto)

    @DELETE
    fun delete(dto: TodoItemDto) = s.delete(dto)

/*    @PUT
    fun update(dto: TodoItemDto, id: UUID) = s.update(dto,id)

    @GET
    fun get(id: UUID) = s.get(id)
*/
}