package learning.concurrentprograming.example.jvm2

object ThreadCreation extends App {

  val t = new MyThread
  t.start()
  t.join()
  println("New thread joined. ")



  class MyThread extends Thread{
    override def run()={
      println(Thread.currentThread().getName)
      println("New thread running.")
    }
  }
}
