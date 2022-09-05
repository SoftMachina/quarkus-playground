package machine.soft.database

import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase
import io.smallrye.mutiny.Uni
import machine.soft.dto.TodoItemDto
import machine.soft.entity.TodoItem
import java.util.UUID
import javax.enterprise.context.Dependent

@Dependent
class TodoItemRepository: PanacheRepositoryBase<TodoItem, UUID> {

    fun create(dto: TodoItemDto): Uni<TodoItem> = TodoItem(dto).persistAndFlush()

    fun update(id: UUID, dto: TodoItemDto): Uni<TodoItem> = findById(id).onItem().transform {
        it.apply { persistAndFlush(update(dto.name,dto.description)) }
    }
}