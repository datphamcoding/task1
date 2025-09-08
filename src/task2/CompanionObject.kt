package task2

class User private constructor(val id: String, val username: String, var email: String?) {

   // Properties and methods for an instance of User
   fun updateEmail(newEmail: String) {
      if (isValidEmail(newEmail)) {
         this.email = newEmail
         println("Email updated for user $username.")
      } else {
         println("Invalid email format for $newEmail.")
      }
   }

   override fun toString(): String {
      return "User(id='$id', username='$username', email=${email ?: "N/A"})"
   }

   companion object {
      private var nextId = 1 // Example: For generating unique IDs

      const val MIN_USERNAME_LENGTH = 3
      const val DEFAULT_DOMAIN = "example.com"

      fun createUser(username: String, email: String? = null): User {
         if (username.length < MIN_USERNAME_LENGTH) {
            throw IllegalArgumentException("Username must be at least $MIN_USERNAME_LENGTH characters long.")
         }
         val newId = "user_${nextId++}"
         return User(
            newId,
            username,
            if (isValidEmail(email)) email else createDefaultEmailForUsername(username)
               .also {
                  println("Warning: Provided email for $username was invalid. Generated default email: $it")
               }
         )
      }

      fun createGuestUser(): User {
         val guestUsername = "guest_${nextId++}"
         return User("guest_id_${guestUsername}", guestUsername, null)
      }

      fun isValidEmail(email: String?): Boolean {
         if (email == null) return false
         return email.contains("@") && email.contains(".")
      }

      fun createDefaultEmailForUsername(username: String): String {
         return "$username@$DEFAULT_DOMAIN"
      }
   }
}

fun main() {
   val user1 = User.createUser("Alice", "alice@wonderland.com")
   val user2 = User.createUser("Bob")
   val guestUser = User.createGuestUser()

   println(user1)
   println(user2)
   println(guestUser)

   // Trying to create a user with a short username
   try {
      val user3 = User.createUser("Bo")
   } catch (e: IllegalArgumentException) {
      println("Error: ${e.message}")
   }
}