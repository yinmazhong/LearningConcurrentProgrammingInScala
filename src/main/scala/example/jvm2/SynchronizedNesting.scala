package example.jvm2

object SynchronizedNesting extends App with ThreadFactory {


  private val transfers = collection.mutable.ArrayBuffer[String]()

  def logTransfer(name: String, n: Int) = transfers.synchronized {
    transfers += s"transfer to account '$name' = $n"
  }

  class Acount(val name: String, var money: Int)

  def add(account: Acount, n: Int) = account.synchronized {
    account.money += n
    if (n > 10) logTransfer(account.name, n)
  }
  val jane = new Acount("Jane",100)
  val john = new Acount("John",500)

  val t1 = thread{
    add(jane,5)
  }
  val t2 = thread{
    add(john,10)
  }
  val t3 = thread{
    add(jane,70)
  }
  t1.join()
  t2.join()
  t3.join()


  log(s"--- tansfers --- \n ${transfers.mkString(",")}")
}

