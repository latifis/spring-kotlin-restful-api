package latifspringboot.kotlin.restful.controller

import latifspringboot.kotlin.restful.model.CreateProductRequest
import latifspringboot.kotlin.restful.model.ProductResponse
import latifspringboot.kotlin.restful.model.WebResponse
import latifspringboot.kotlin.restful.service.ProductService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductController (val productService: ProductService){

    @PostMapping(
            value = ["/api/products"],
            produces = ["application/json"],
            consumes = ["application/json"]
    )
    fun createProduct(@RequestBody body: CreateProductRequest): WebResponse<ProductResponse> {
        val productResponse = productService.create(body)

        return  WebResponse(
                code = 200,
                status = "OK",
                data = productResponse
        )
    }

    @GetMapping(
            value = ["/api/products"],
            produces = ["application/json"]
    )
    fun getProductList(): WebResponse<List<ProductResponse>> {
        val productList = productService.getAllProducts()

        return WebResponse(
                code = 200,
                status = "OK",
                data = productList
        )
    }
}