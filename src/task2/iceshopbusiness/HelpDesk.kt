package task2.iceshopbusiness

object HelpDesk {
   fun handle(request: Request.SupportRequest) = println("Help desk is handling #${request.id}")
}