package machine.soft.entity

import javax.persistence.Entity
import javax.persistence.ManyToOne

@Entity
class Ingredient: BaseEntity() {

    val description: String = ""
    val name: String = ""
    @ManyToOne
    val recipe: Recipe? = null
}