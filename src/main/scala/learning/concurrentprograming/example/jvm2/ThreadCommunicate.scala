package learning.concurrentprograming.example.jvm2

object ThreadCommunicate extends App with ThreadFactory {
  var result:String = null

  val t = thread{
    result = s"new res"
  }
  t.join()
  println(s"$result")
  println(6650/6*7/2500)

}
