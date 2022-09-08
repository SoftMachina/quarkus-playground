package machine.soft.entity

import machine.soft.dto.TodoItemDto
import javax.persistence.Entity
import javax.persistence.ManyToOne

@Entity
class TodoItem(
    var name: String = "",
    var description: String? = "",
    @ManyToOne(optional = false)
    var category: TodoCategory?
) : BaseEntity() {


    constructor(dto: TodoItemDto, category: TodoCategory? = null) : this(name = dto.name, description = dto.description, category = category)

    fun update(entity: TodoItem): TodoItem {
        this.name = entity.name
        this.description = entity.description

        return this
    }

}
