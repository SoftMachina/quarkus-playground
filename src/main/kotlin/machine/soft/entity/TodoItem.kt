package machine.soft.entity

import machine.soft.dto.TodoItemDto
import javax.persistence.Entity

@Entity
class TodoItem(
    var name: String,
    var description: String) : BaseEntity() {

    constructor(dto: TodoItemDto) : this(name = dto.name, description = dto.description) {
    }

    fun update(name: String, description: String): TodoItem {
        this.name = name
        this.description = description

        return this
    }

}
