package machine.soft.dto

import machine.soft.entity.TodoItem
import java.util.*

data class TodoItemDto(var name: String = "", var description: String? = "", var categoryId: UUID?, var isDone: Boolean) : BaseDto() {
    constructor(entity: TodoItem) : this(
        name = entity.name,
        description = entity.description,
        categoryId = entity.category.id,
        isDone = entity.isDone
    ) {
        id = entity.id
    }
}