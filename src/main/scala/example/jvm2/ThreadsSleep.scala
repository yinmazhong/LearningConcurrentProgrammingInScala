package example.jvm2

object ThreadsSleep extends App {

  val t = thread{
    Thread.sleep(1000)
    println(s"New thread:${Thread.currentThread().getName} running")
    Thread.sleep(1000)
    println(s"thread ${Thread.currentThread().getName} still running")
    Thread.sleep(1000)
    println(s"thread ${Thread.currentThread().getName} complete")
  }

  t.join()
  println(s"thread ${t.getName} joined")

  def thread(body: => Unit):Thread={
    val t = new Thread{
      override def run() = body
    }
    t.start()
    t
  }
}
