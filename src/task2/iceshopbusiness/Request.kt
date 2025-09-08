package task2.iceshopbusiness

import kotlin.random.Random

sealed class Request {
   val id: Int = Random.nextInt()

   class OrderRequest(val size: Size) : Request()
   class RefundRequest(val size: Size, val reason: String) : Request()
   class SupportRequest(val text: String) : Request()
   enum class Size {
      CUP, BUCKET, BAG
   }
}