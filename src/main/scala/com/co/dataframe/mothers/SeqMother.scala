package com.co.dataframe.mothers

object SeqMother {
  val maximumElements = 4000

  def randomOf[T](apply: => T): Seq[T] =
    (1 to maximumElements).map(_ => apply)
}
