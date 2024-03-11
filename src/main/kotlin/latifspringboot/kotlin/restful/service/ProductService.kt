package latifspringboot.kotlin.restful.service

import latifspringboot.kotlin.restful.model.CreateProductRequest
import latifspringboot.kotlin.restful.model.ProductResponse

interface ProductService {

    fun create(createProductRequest: CreateProductRequest): ProductResponse

    fun getAllProducts(): List<ProductResponse>

    fun checkout()

}