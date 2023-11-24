package com.co.dataframe.mothers

import scala.util.Random

object StringMother {
  val defaultChars = 25

  def random(numChars: Int = defaultChars): String =
    alpha take numChars mkString ""

  def alpha: LazyList[Char] = {
    def nextAlpha: Char = {
      val chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
      chars charAt (Random nextInt chars.length)
    }

    LazyList continually nextAlpha
  }
}
