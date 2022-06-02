package order.com.br.service.impl

import order.com.br.model.Items
import order.com.br.model.Order
import order.com.br.plugins.OrderException
import java.time.LocalDateTime

class OrderServiceImpl {

    val entries: MutableList<Order> = ArrayList()

    init {
        val item: MutableList<Items> = ArrayList()
        item.add(Items("23", "Monitor", 165.8))
        item.add(Items("153", "Teclado", 165.8))
        entries.add(Order("123", "2022-05-27 16:34", 63.5, "marinho", item))
    }

    fun list(limit: Int, size: Int): MutableList<Order> {
        println("\n\n\n\n service $limit, $size")
        println("\n\n\n\n entries $entries")
        return entries
    }

    fun get(orderId: String): Order {
        val order = entries.filter { it.id == orderId }
        return if (order.isNotEmpty()) order[0] else throw OrderException("ID not found")
    }

    fun save(order: Order): Order {
        entries.add(order)
        return order
    }

    fun put(orderId: String, order: Order) {
        val removeIf = entries.removeIf { it.id == orderId }
        if (!removeIf) {
            throw OrderException("ID not found")
        }
        entries.add(order)

    }

    fun delete(orderId: String) {
        val removeIf = entries.removeIf { it.id == orderId }
        if (!removeIf) {
            throw OrderException("ID not found")
        }
    }
}












