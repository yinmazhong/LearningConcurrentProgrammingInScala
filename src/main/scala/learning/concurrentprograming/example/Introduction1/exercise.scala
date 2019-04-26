package learning.concurrentprograming.example.Introduction1

object exercise {
  def main(args: Array[String]): Unit = {
    val res = Pair[Int,String](1,"a") match {
      case Pair(a,b) => Some(a,b)
      case _ => None
    }

    //val res = check(1 until 10)(40 / _ > 0)

    //val res = fuse(Some(1, 2), None)
    println(res.get)
  }

  //1
  def compose[A, B, C](g: B => C, f: A => B): A => C = {
    val h: A => C = (x: A) => g(f(x))
    h
  }

  //2

  def fuse[A, B](a: Option[A], b: Option[B]): Option[(A, B)] = {

    for (ai <- a; bi <- b) yield (ai, bi)
  }

  //3
  def check[T](xs: Seq[T])(pred: T => Boolean): Boolean = {
    xs.map(pred).reduce(_ & _)
  }

  //4
  case class Pair[P,Q](first:P,second:Q)
  //5

  //这个题目出的有问题
  /*def permutations(x:String):Seq[String]={

    val char = s"a,b,c,d,e,f"

  }*/
  //6

}
