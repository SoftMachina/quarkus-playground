package machine.soft.dto

import machine.soft.entity.TodoCategory

data class TodoCategoryDto(var name: String = "", var description: String?= "") : BaseDto() {
    constructor(entity: TodoCategory) : this(
        name = entity.name,
        description = entity.description
    ) {
        id = entity.id
    }
}