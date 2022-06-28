package machine.soft.entity

import javax.persistence.*

@Entity
class Recipe: BaseEntity() {

    @OneToMany(mappedBy = "recipe")
    val ingredients: MutableList<Ingredient> = mutableListOf()

}