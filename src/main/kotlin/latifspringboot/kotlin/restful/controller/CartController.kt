package latifspringboot.kotlin.restful.controller

import latifspringboot.kotlin.restful.model.CartResponse
import latifspringboot.kotlin.restful.model.CreateCartRequest
import latifspringboot.kotlin.restful.model.ProductResponse
import latifspringboot.kotlin.restful.model.WebResponse
import latifspringboot.kotlin.restful.service.CartService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class CartController (val cartService: CartService){

    @PostMapping(
            value = ["/api/cart/{idProduct}"],
            produces = ["application/json"]
    )
    fun addToCart(
            @PathVariable("idProduct") productId: String,
            @RequestBody createCartRequest: CreateCartRequest
    ): WebResponse<String> {
        cartService.addToCart(productId, createCartRequest)

        return WebResponse(
                code = 200,
                status = "OK",
                data = "Product with ID $productId added to cart successfully"
        )
    }

    @GetMapping(
            value = ["/api/cart"],
            produces = ["application/json"]
    )
    fun getCartItems(): WebResponse<List<CartResponse>> {
        val cartItems = cartService.getCartItems()

        return WebResponse(
                code = 200,
                status = "OK",
                data = cartItems
        )
    }
}