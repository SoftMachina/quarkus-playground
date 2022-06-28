package machine.soft.entity

import io.quarkus.hibernate.reactive.panache.PanacheEntity
import io.quarkus.hibernate.reactive.panache.PanacheEntityBase
import java.util.UUID
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.MappedSuperclass
import javax.persistence.Version

@MappedSuperclass
abstract class BaseEntity : PanacheEntityBase() {
    @Id
    @GeneratedValue(generator = "UUID")
    val id: UUID? = null
    @Version
    var version: Int = 0

}