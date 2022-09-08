package machine.soft.database

import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase
import io.quarkus.hibernate.reactive.panache.common.runtime.ReactiveTransactional
import io.smallrye.mutiny.Uni
import machine.soft.dto.TodoItemDto
import machine.soft.entity.TodoItem
import java.util.*
import javax.enterprise.context.Dependent
import javax.inject.Inject

@Dependent
class TodoItemRepository @Inject constructor(val repoTC: TodoCategoryRepository) : PanacheRepositoryBase<TodoItem, UUID> {

    @ReactiveTransactional
    fun create(dto: TodoItemDto): Uni<TodoItemDto> = repoTC.findById(dto.categoryId).onItem().ifNotNull().transformToUni { it ->
        persist(TodoItem(dto, it))
    }.onItem().ifNotNull().transform(::TodoItemDto)

    @ReactiveTransactional
    fun update(id: UUID, entity: TodoItem): Uni<TodoItem> = findById(id).onItem().ifNotNull().transformToUni { it ->
        it.apply { update(entity) }.persist()
    }

}