package machine.soft.entity

import javax.persistence.Entity
import javax.persistence.ManyToOne

@Entity
class Ingredient(
    val description: String = "",
    val name: String = "",
    val quantity: Double = 0.0,
    @ManyToOne
    val recipe: Recipe? = null,
    val unit: String = "",
) : BaseEntity() {



}