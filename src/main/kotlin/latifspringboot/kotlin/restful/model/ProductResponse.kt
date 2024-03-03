package latifspringboot.kotlin.restful.model

import java.util.*

class ProductResponse(

        val id: String,

        val name: String,

        val price: Long,

        val quantity: Int,

        val createAt: Date,

        val updateAt: Date?

)