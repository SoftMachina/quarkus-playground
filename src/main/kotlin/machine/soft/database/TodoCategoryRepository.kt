package machine.soft.database

import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase
import io.quarkus.hibernate.reactive.panache.common.runtime.ReactiveTransactional
import io.smallrye.mutiny.Uni
import machine.soft.dto.TodoCategoryDto
import machine.soft.dto.TodoItemDto
import machine.soft.entity.TodoCategory
import machine.soft.entity.TodoItem
import java.util.UUID
import javax.enterprise.context.Dependent

@Dependent
class TodoCategoryRepository: PanacheRepositoryBase<TodoCategory, UUID> {

    fun create(dto: TodoCategoryDto): Uni<TodoCategory> = TodoCategory(dto).persistAndFlush()

    @ReactiveTransactional
    fun update(id: UUID, entity: TodoCategory): Uni<TodoCategory> = findById(id).onItem().ifNotNull().transformToUni {
        it -> it.apply { update(entity) }.persist()
    }

}