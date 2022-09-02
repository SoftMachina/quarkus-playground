package machine.soft.database

import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase
import io.quarkus.hibernate.reactive.panache.common.runtime.ReactiveTransactional
import io.smallrye.mutiny.Uni
import machine.soft.dto.TodoItemDto
import machine.soft.entity.TodoItem
import java.util.UUID
import javax.enterprise.context.Dependent

@Dependent
class TodoItemRepository: PanacheRepositoryBase<UUID, TodoItem> {

    @ReactiveTransactional
    fun create(todoItemDto: TodoItemDto): Uni<TodoItem> = TodoItem(todoItemDto).persistAndFlush()
}