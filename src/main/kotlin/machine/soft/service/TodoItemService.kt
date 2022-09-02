package machine.soft.service

import io.smallrye.mutiny.Uni
import machine.soft.database.TodoItemRepository
import machine.soft.dto.TodoItemDto

class TodoItemService(val r: TodoItemRepository){
    fun create(dto: TodoItemDto): Uni<TodoItemDto> = r.create(dto).onItem().ifNotNull().transform(::TodoItemDto)
}