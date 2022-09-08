package machine.soft.entity

import machine.soft.dto.TodoCategoryDto
import javax.persistence.Entity

@Entity
class TodoCategory(
    var name: String = "",
    var description: String? = ""
) : BaseEntity() {
    constructor(dto: TodoCategoryDto) : this(name = dto.name, description = dto.description) {
    }

    fun update(entity: TodoCategory): TodoCategory {
        this.name = entity.name
        this.description = entity.description

        return this
    }
}