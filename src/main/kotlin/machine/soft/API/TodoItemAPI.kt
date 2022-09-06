package machine.soft.API

import machine.soft.dto.TodoItemDto
import machine.soft.service.TodoItemService
import java.util.UUID
import javax.ws.rs.*

@Path("/todo")
class TodoItemAPI( val s: TodoItemService) {

    @POST
    fun create(dto: TodoItemDto) = s.create(dto)

    @DELETE
    @Path("/{id}")
    fun delete(@PathParam("id") id: UUID ) = s.delete(id)

/*    @PUT
    fun update(dto: TodoItemDto, id: UUID) = s.update(dto,id)

    @GET
    fun get(id: UUID) = s.get(id)
*/
}