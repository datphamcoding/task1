package task2.iceshopbusiness

object IceCubeFactory {
   fun fulfillOrder(order: Request.OrderRequest) = println("Fulfilling order #${order.id}")
   fun fulfillRefund(refund: Request.RefundRequest) = println("Fulfilling refund #${refund.id}")
}