package latifspringboot.kotlin.restful.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.*

@Entity
@Table(name = "carts")
data class Cart(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,

        @Column(name = "id_product")
        val idProduct: String,

        @Column(name = "product_name")
        val productName: String,

//        @Column(name = "id_customer")
//        val idCustomer: String,

        @Column(name = "price")
        val price: Long,

        @Column(name = "quantity")
        val quantity: Int,

        @Column(name = "create_at")
        val createAt: Date,

        @Column(name = "updated_at")
        val updateAt: Date?
)