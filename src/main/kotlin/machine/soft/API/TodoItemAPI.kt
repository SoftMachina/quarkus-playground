package machine.soft.API

import io.smallrye.mutiny.Uni
import machine.soft.dto.TodoItemDto
import machine.soft.service.TodoItemService
import java.util.*
import javax.ws.rs.*
import javax.ws.rs.core.Response.ok

@Path("/todo")
class TodoItemAPI( val s: TodoItemService) {

    @POST
    fun create(dto: TodoItemDto) = s.create(dto)

    @DELETE
    @Path("/{id}")
    fun delete(@PathParam("id") id: UUID) = s.delete(id).onItem().ifNotNull().transform(::ok)

    @GET
    @Path("/{id}")
    fun get(@PathParam("id") id: UUID): Uni<TodoItemDto> = s.getById(id)

    @PUT
    @Path("/{id}")
    fun update(@PathParam("id") id: UUID, dto: TodoItemDto): Uni<TodoItemDto> = s.update(id, dto)

    @PUT
    @Path("/{id}/switch")
    fun switchState(@PathParam("id") id: UUID): Uni<TodoItemDto> = s.switchState(id)

}