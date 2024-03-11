package latifspringboot.kotlin.restful.repository

import latifspringboot.kotlin.restful.entity.Cart
import latifspringboot.kotlin.restful.entity.Product
import org.springframework.data.jpa.repository.JpaRepository

interface CartRepository : JpaRepository <Cart, String>{

}