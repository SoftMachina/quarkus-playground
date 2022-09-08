package machine.soft.dto

import machine.soft.entity.TodoItem
import java.util.*

data class TodoItemDto(var name: String = "", var description: String? = "", var categoryId: UUID?) : BaseDto() {
    constructor(entity: TodoItem) : this(
        name = entity.name,
        description = entity.description,
        categoryId = entity.category.id,
    ) {
        id = entity.id
    }
}