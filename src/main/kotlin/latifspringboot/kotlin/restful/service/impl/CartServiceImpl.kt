package latifspringboot.kotlin.restful.service.impl

import latifspringboot.kotlin.restful.entity.Cart
import latifspringboot.kotlin.restful.entity.Product
import latifspringboot.kotlin.restful.model.CartResponse
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

    override fun getCartItems(): List<CartResponse> {

        val carts = cartRepository.findAll()
        return carts.map { cart ->
            CartResponse(
                    id = cart.id,
                    idProduct = cart.idProduct,
                    productName = cart.productName,
                    price = cart.price,
                    quantity = cart.quantity,
                    createAt = cart.createAt,
                    updateAt = cart.updateAt
            )
        }
    }

    override fun removeFromCart(productId: String) {
        val cartOptional = cartRepository.findById(productId)

        if (cartOptional.isPresent) {
            val cart = cartOptional.get()
            cartRepository.delete(cart)
        }
    }

}