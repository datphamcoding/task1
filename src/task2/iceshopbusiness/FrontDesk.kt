package task2.iceshopbusiness

object FrontDesk {
   fun receive(request: Request) {
      println("Handling request #${request.id}")
      when (request) {
         is Request.OrderRequest   -> IceCubeFactory.fulfillOrder(request)
         is Request.RefundRequest  -> IceCubeFactory.fulfillRefund(request)
         is Request.SupportRequest -> HelpDesk.handle(request)
      }
   }
}