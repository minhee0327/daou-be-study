package chapter08

enum class Delivery { STANDARD, EXPEDITED }

class Order(val itemCount: Int)

fun getShippingCostCalculator(
    delivery: Delivery
): (Order) -> Double { //반환 타입 : 함수
    if(delivery === Delivery.EXPEDITED){
        return {order ->  6 + 2.1 * order.itemCount} //람다 반환
    }
    return {order ->  1.2 * order.itemCount}//람다 반환
}

fun main(){
    val calculator = getShippingCostCalculator(Delivery.EXPEDITED)
    println("Shipping costs ${calculator(Order(3))}")
}