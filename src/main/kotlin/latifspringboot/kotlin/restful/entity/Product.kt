package latifspringboot.kotlin.restful.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.*

@Entity
@Table(name = "products")
data class Product(

        @Id
        val id: String,

        @Column(name = "name")
        val name: String,

        @Column(name = "price")
        val price: Long,

        @Column(name = "quantity")
        val quantity: Int,

        @Column(name = "create_at")
        val createAt: Date,

        @Column(name = "updated_at")
        val updateAt: Date?
)