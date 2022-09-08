package machine.soft.service

import io.quarkus.hibernate.reactive.panache.common.runtime.ReactiveTransactional
import io.smallrye.mutiny.Uni
import machine.soft.database.TodoCategoryRepository
import machine.soft.dto.TodoCategoryDto
import machine.soft.entity.TodoCategory
import java.util.*
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class TodoCategoryService(val r: TodoCategoryRepository) {
    fun create(dto: TodoCategoryDto): Uni<TodoCategoryDto> = r.create(dto).onItem().ifNotNull().transform(::TodoCategoryDto)

    @ReactiveTransactional
    fun delete(id: UUID): Uni<Boolean> = r.deleteById(id).onItem().ifNotNull().transform { it }

    fun getById(id: UUID): Uni<TodoCategoryDto> = r.findById(id).onItem().ifNotNull().transform(::TodoCategoryDto)

    fun update(id: UUID, dto: TodoCategoryDto) = r.update(id, TodoCategory(dto)).onItem().ifNotNull().transform(::TodoCategoryDto)
}