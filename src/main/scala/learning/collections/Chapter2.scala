package learning.collections

object Chapter2 {

  // 不能简单的new
  //val pet = new Pet()

  val t = List(1,2,3).toTraversable
  t


  val s = Traversable(1,2,3)


  trait Pet{
    def sayHello(name:String): String ={
      s"hello $name"
    }
  }

  object Pet{
    def apply(name:String): Pet = new Pet{

    }
  }


}



