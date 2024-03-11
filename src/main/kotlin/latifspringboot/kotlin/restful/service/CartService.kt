package latifspringboot.kotlin.restful.service

import latifspringboot.kotlin.restful.model.CreateCartRequest
import latifspringboot.kotlin.restful.model.CreateProductRequest
import latifspringboot.kotlin.restful.model.ProductResponse

interface CartService {

    fun addToCart(productId: String, createCartRequest: CreateCartRequest)

    fun getCartItems(): List<ProductResponse>

    fun removeFromCart(productId: String)

}