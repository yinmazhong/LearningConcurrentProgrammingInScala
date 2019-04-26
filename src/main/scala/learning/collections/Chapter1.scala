package learning.collections

object Chapter1 {
  def main(args: Array[String]): Unit = {

    /*　
    * scala 集合大致分为三种，Seq,Set,Map;不同的类别的集合即使所包含的元素相同，他们的相等性比较也是false
    * */
    assert(Seq(1,2,3) == Set(1,2,3))


  }


}
