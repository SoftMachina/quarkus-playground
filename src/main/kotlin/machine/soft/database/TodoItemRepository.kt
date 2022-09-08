package machine.soft.database

import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase
import io.quarkus.hibernate.reactive.panache.common.runtime.ReactiveTransactional
import io.smallrye.mutiny.Uni
import machine.soft.dto.TodoItemDto
import machine.soft.entity.TodoItem
import java.util.*
import javax.enterprise.context.Dependent

@Dependent
class TodoItemRepository: PanacheRepositoryBase<TodoItem, UUID> {

    fun create(dto: TodoItemDto): Uni<TodoItem> = TodoItem(dto).persistAndFlush()

    @ReactiveTransactional
    fun update(id: UUID, entity: TodoItem): Uni<TodoItem> = findById(id).onItem().ifNotNull().transformToUni { it ->
        it.apply { update(entity) }.persist()
    }

}