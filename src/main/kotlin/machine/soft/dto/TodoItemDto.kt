package machine.soft.dto

import machine.soft.entity.TodoItem

data class TodoItemDto(var name: String, var description: String) : BaseDto() {
    constructor(entity: TodoItem) : this(
        name = entity.name,
        description = entity.description
    ) {
        id = entity.id
    }
}