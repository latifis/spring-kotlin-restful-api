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

    override fun getAllProducts(): List<ProductResponse> {
        val products = productRepository.findAll()
        return products.map { product ->
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

    private val cart: MutableList<Product> = mutableListOf()

    override fun addToCart(productId: String) {
        val productOptional = productRepository.findById(productId)

        productOptional.ifPresent { product ->
            cart.add(product)
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

    override fun checkout() {
        // Implementasi logika untuk proses checkout
        // Menambahkan logika untuk menghitung total pembayaran, mengurangi stok produk dari database, memproses pembayaran

        // Contoh sederhana untuk proses checkout: mengosongkan keranjang belanja
        cart.clear()

        // Contoh sederhana untuk mengurangi stok produk dari database:
        // for (product in cart) {
        //     val existingProduct = productRepository.findById(product.id)
        //     existingProduct.ifPresent { p ->
        //         p.quantity -= 1
        //         productRepository.save(p)
        //     }
        // }
    }
}