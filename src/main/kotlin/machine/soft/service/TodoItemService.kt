package machine.soft.service

import io.quarkus.hibernate.reactive.panache.common.runtime.ReactiveTransactional
import io.smallrye.mutiny.Uni
import machine.soft.database.TodoCategoryRepository
import machine.soft.database.TodoItemRepository
import machine.soft.dto.TodoItemDto
import machine.soft.entity.TodoItem
import java.util.*
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class TodoItemService(val r: TodoItemRepository, val repoTC: TodoCategoryRepository) {
    fun create(dto: TodoItemDto): Uni<TodoItemDto> = r.create(dto)

    @ReactiveTransactional
    fun delete(id: UUID): Uni<Boolean> = r.deleteById(id).onItem().ifNotNull().transform { it }

    fun getById(id: UUID): Uni<TodoItemDto> = r.findById(id).onItem().ifNotNull().transform(::TodoItemDto)

    fun update(id: UUID, dto: TodoItemDto) = repoTC.findById(dto.categoryId).onItem().ifNotNull().transformToUni { it ->
        r.update(id, TodoItem(dto, it)).onItem().ifNotNull().transform(::TodoItemDto)
    }

    fun switchState(id: UUID) = r.switchState(id).onItem().ifNotNull().transform(::TodoItemDto)
}