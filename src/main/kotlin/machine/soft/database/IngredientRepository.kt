package machine.soft.database

import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase
import machine.soft.entity.Ingredient
import java.util.*

class IngredientRepository: PanacheRepositoryBase<UUID, Ingredient > {
}