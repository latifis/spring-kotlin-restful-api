package latifspringboot.kotlin.restful.service

import latifspringboot.kotlin.restful.model.CreateProductRequest
import latifspringboot.kotlin.restful.model.ProductResponse

interface ProductService {

    fun create(createProductRequest: CreateProductRequest): ProductResponse

    fun getAllProducts(): List<ProductResponse>

    fun addToCart(productId: String)

    fun getCartItems(): List<ProductResponse>

    fun removeFromCart(productId: String)

    fun checkout()

}