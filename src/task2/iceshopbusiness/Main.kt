package task2.iceshopbusiness

fun main() {
    println("--- Singleton Demo ---")

    // Create different types of requests
    val orderRequest = Request.OrderRequest(Request.Size.BUCKET)
    val refundRequest = Request.RefundRequest(Request.Size.CUP, "Melted too quickly")
    val supportRequest = Request.SupportRequest("I need help with my ice cube order.")
    val anotherOrder = Request.OrderRequest(Request.Size.BAG)

    // Process requests through the FrontDesk
    println("\nProcessing Order Request:")
    FrontDesk.receive(orderRequest)

    println("\nProcessing Refund Request:")
    FrontDesk.receive(refundRequest)

    println("\nProcessing Support Request:")
    FrontDesk.receive(supportRequest)

    println("\nProcessing Another Order Request:")
    FrontDesk.receive(anotherOrder)

    println("\n--- End of Singleton Demo ---")
}
