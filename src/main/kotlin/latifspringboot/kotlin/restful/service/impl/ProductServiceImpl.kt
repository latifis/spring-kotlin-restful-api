package latifspringboot.kotlin.restful.service.impl

import latifspringboot.kotlin.restful.entity.Product
import latifspringboot.kotlin.restful.model.CreateProductRequest
import latifspringboot.kotlin.restful.model.ProductResponse
import latifspringboot.kotlin.restful.repository.ProductRepository
import latifspringboot.kotlin.restful.service.ProductService
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductServiceImpl(val productRepository: ProductRepository) : ProductService {
    override fun create(createProductRequest: CreateProductRequest): ProductResponse {
        val product = Product(
                id = createProductRequest.id,
                name = createProductRequest.name,
                price = createProductRequest.price,
                quantity = createProductRequest.quantity,
                createAt = Date(),
                updateAt = null
        )
        productRepository.save(product)

        return ProductResponse(
                id = product.id,
                name = product.name,
                price = product.price,
                quantity = product.quantity,
                createAt = product.createAt,
                updateAt = product.updateAt
        )
    }
}