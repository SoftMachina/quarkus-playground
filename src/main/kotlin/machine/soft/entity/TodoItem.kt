package machine.soft.entity

import machine.soft.dto.TodoItemDto
import javax.persistence.Entity

@Entity
class TodoItem(
    var name: String = "",
    var description: String? = "") : BaseEntity() {

    constructor(dto: TodoItemDto) : this(name = dto.name, description = dto.description) {
    }

    fun update(entity: TodoItem): TodoItem {
        this.name = entity.name
        this.description = entity.description

        return this
    }

}
