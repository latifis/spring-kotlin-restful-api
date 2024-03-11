package latifspringboot.kotlin.restful.service.impl

import latifspringboot.kotlin.restful.entity.Cart
import latifspringboot.kotlin.restful.entity.Product
import latifspringboot.kotlin.restful.model.CreateCartRequest
import latifspringboot.kotlin.restful.model.CreateProductRequest
import latifspringboot.kotlin.restful.model.ProductResponse
import latifspringboot.kotlin.restful.repository.CartRepository
import latifspringboot.kotlin.restful.repository.ProductRepository
import latifspringboot.kotlin.restful.service.CartService
import latifspringboot.kotlin.restful.service.ProductService
import org.springframework.stereotype.Service
import java.util.*

@Service
class CartServiceImpl(val cartRepository: CartRepository, val productRepository: ProductRepository) : CartService {

    private val cart: MutableList<Product> = mutableListOf()

    override fun addToCart(productId: String, createCartRequest: CreateCartRequest) {
        val productOptional = productRepository.findById(productId)

        if (productOptional.isPresent) {
            val product = productOptional.get()

            val cart = Cart(
                    idProduct = product.id,
                    productName = product.name,
                    price = product.price,
                    quantity = createCartRequest.quantity,
                    createAt = Date(),
                    updateAt = null
            )

            cartRepository.save(cart)
        }
    }

    override fun getCartItems(): List<ProductResponse> {
        return cart.map { product ->
            ProductResponse(
                    id = product.id,
                    name = product.name,
                    price = product.price,
                    quantity = product.quantity,
                    createAt = product.createAt,
                    updateAt = product.updateAt
            )
        }
    }

    override fun removeFromCart(productId: String) {
        val index = cart.indexOfFirst { product -> product.id == productId }

        if (index != -1) {
            cart.removeAt(index)
        }
    }

}