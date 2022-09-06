package machine.soft.service

import io.quarkus.hibernate.reactive.panache.common.runtime.ReactiveTransactional
import io.smallrye.mutiny.Uni
import machine.soft.database.TodoItemRepository
import machine.soft.dto.TodoItemDto
import machine.soft.entity.TodoItem
import java.util.*
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class TodoItemService(val r: TodoItemRepository){
    fun create(dto: TodoItemDto): Uni<TodoItemDto> = r.create(dto).onItem().ifNotNull().transform(::TodoItemDto)

    @ReactiveTransactional
    fun delete(id: UUID): Uni<Boolean> = r.deleteById(id).onItem().ifNotNull().transform { it }

}