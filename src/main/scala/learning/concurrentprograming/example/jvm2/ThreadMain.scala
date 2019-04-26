package learning.concurrentprograming.example.jvm2

object ThreadMain extends App {
val t:Thread = Thread.currentThread()
  val name = t.getName
  println(s"I am the thread $name")
}
