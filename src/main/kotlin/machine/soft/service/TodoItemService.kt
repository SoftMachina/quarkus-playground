package machine.soft.service

import io.smallrye.mutiny.Uni
import machine.soft.database.TodoItemRepository
import machine.soft.dto.TodoItemDto
import machine.soft.entity.TodoItem
import java.util.*
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class TodoItemService(val r: TodoItemRepository){
    fun create(dto: TodoItemDto): Uni<TodoItemDto> = r.create(dto).onItem().ifNotNull().transform(::TodoItemDto)
    fun delete(id: UUID): Uni<Boolean> = r.deleteById(id).onItem().ifNotNull().transform { it }

/*fun update(dto: TodoItemDto, id: UUID) : Uni<TodoItem> =
    r.findById(id).onItem().ifNotNull().transform{
    }

    fun get(id: UUID) {
    }*/
}