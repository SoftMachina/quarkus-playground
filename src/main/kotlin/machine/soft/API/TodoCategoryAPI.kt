package machine.soft.API

import io.smallrye.mutiny.Uni
import machine.soft.dto.TodoCategoryDto
import machine.soft.service.TodoCategoryService
import java.util.*
import javax.ws.rs.*
import javax.ws.rs.core.Response.ok

@Path("/category")
class TodoCategoryAPI(val s: TodoCategoryService) {

    @POST
    fun create(dto: TodoCategoryDto) = s.create(dto)

    @DELETE
    @Path("/{id}")
    fun delete(@PathParam("id") id: UUID) = s.delete(id).onItem().ifNotNull().transform(::ok)

    @GET
    @Path("/{id}")
    fun get(@PathParam("id") id: UUID): Uni<TodoCategoryDto> = s.getById(id)

    @PUT
    @Path("/{id}")
    fun update(@PathParam("id") id: UUID, dto: TodoCategoryDto): Uni<TodoCategoryDto> = s.update(id, dto)

}