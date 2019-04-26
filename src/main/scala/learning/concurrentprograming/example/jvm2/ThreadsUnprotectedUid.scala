package learning.concurrentprograming.example.jvm2

object ThreadsUnprotectedUid extends App with ThreadFactory {

  val t = thread{printUniqueIds(5)}
  printUniqueIds(5)
  t.join()

  def printUniqueIds(n:Int): Unit ={
    val uids = for (i <- 0 until n) yield getUniqueId()
    log(uids.toString())
  }
  var uidCount = 0L

  def getUniqueId() = this.synchronized{
    val freshUid = uidCount + 1
    uidCount = freshUid
    freshUid
  }
}
