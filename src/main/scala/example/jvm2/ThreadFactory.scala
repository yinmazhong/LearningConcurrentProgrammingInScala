package example.jvm2

trait ThreadFactory {
  def thread(body: => Unit):Thread={
    val t = new Thread{
      override def run() = body
    }
    t.start()
    t
  }

  def log(s:String): Unit ={
    println(s"${Thread.currentThread().getName} $s")
  }
}
