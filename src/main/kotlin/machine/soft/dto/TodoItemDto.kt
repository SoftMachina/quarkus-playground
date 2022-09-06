package machine.soft.dto

import machine.soft.entity.TodoItem
import java.util.UUID

data class TodoItemDto(var name: String = "", var description: String?= "") : BaseDto() {
    constructor(entity: TodoItem) : this(
        name = entity.name,
        description = entity.description
    ) {
        id = entity.id
    }
}