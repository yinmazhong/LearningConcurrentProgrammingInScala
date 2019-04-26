package learning.concurrentprograming.example.jvm2

object ThreadSharedStateAccessRecordering extends App with ThreadFactory {

  for (i <- 0 until 100000000) {
    var a = false
    var b = false
    var x = -1
    var y = -1
    val t1 = thread {
      this.synchronized {
        a = true
        y = if (b) 0 else 1
      }
    }

    val t2 = thread {this.synchronized{
      b = true
      x = if (a) 0 else 1
    }}

    t1.join()
    t2.join()
    assert(!(x == 1 && y == 1), s"x=$x,y=$y")
  }
}
