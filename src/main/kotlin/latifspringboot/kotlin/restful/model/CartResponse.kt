package latifspringboot.kotlin.restful.model

import jakarta.persistence.Column
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import java.util.*

class CartResponse(

        val id: Long?,

        val idProduct: String,

        val productName: String,

        val price: Long,

        val quantity: Int,

        val createAt: Date,

        val updateAt: Date?

)