package machine.soft.entity

import javax.persistence.*

@Entity
class Recipe(
    @OneToMany(mappedBy = "recipe")
    val ingredients: MutableList<Ingredient> = mutableListOf()
): BaseEntity() {

}