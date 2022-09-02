package machine.soft.service

import io.smallrye.mutiny.Uni
import machine.soft.database.TodoItemRepository
import machine.soft.dto.TodoItemDto
import machine.soft.entity.TodoItem
import java.util.*

class TodoItemService(val r: TodoItemRepository){
    fun create(dto: TodoItemDto): Uni<TodoItemDto> = r.create(dto).onItem().ifNotNull().transform(::TodoItemDto)
    fun delete(dto: TodoItemDto): Uni<Boolean> = r.deleteById(TodoItem(dto)).onItem().ifNotNull().transform { if(it) it else false }

    fun update(dto: TodoItemDto, id: UUID) {
        TODO("implement")
    }
    fun get(id: UUID) {
        TODO("implement")
    }
}