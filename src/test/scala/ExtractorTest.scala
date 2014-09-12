import org.scalatest._

class ExtractorTest extends FlatSpec with Matchers {
  // based on Programming In Scala 2ed, chapter 26
  // http://booksites.artima.com/programming_in_scala_2ed/examples/html/ch26.html
  "isEmail" should "return true when passed string is valid email fmt" in {

    def isEmail(email:String): Boolean = {
      email match {
        case Email(user: String, domain:String) => true
        case _ => false
      }
    }

    object Email {
      def unapply(email:String): Option[(String, String)] = {
        val parts = email split "@"

        if (parts.length == 2) Some(parts(0), parts(1)) else None
      }
    }

    // fixtures
    val (email1, result1) = ("user@domain.com", true)
    val (email2, result2) = ("user%domain.com", false)

    assert(isEmail(email1) == result1)
    assert(isEmail(email2) == result2)
    assert(Email.unapply(email1) == Some("user", "domain.com"))
  }

  "Extractors" can "be combined" in {

    object Uppercase {
      def unapply(str: String): Boolean = str.toUpperCase == str
    }

    object Twice {
      def unapply(str: String): Option[String] = {

        val halfLength = str.length / 2
        val halfString = str.substring(halfLength);

        if (halfString == str.substring(0, halfLength)) Some(halfString) else None
      }
    }

    def isTwice(str: String): Boolean = {
      str match {
        case Twice(str) => true
        case _ => false
      }
    };

    object Email {
      def unapply(email:String): Option[(String, String)] = {
        val parts = email split "@"
        if (parts.length == 2) Some(parts(0), parts(1)) else None
      }
    }

    assert(Twice.unapply("TOTO") == Some("TO"));
    assert(isTwice("TOT0") == true)
  }
}
