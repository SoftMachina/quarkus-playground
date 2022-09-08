package machine.soft.dto

import machine.soft.entity.TodoItem

data class TodoItemDto(var name: String = "", var description: String? = "", var category: TodoCategoryDto) : BaseDto() {
    constructor(entity: TodoItem) : this(
        name = entity.name,
        description = entity.description,
        category = TodoCategoryDto(entity.category)
    ) {
        id = entity.id
    }
}