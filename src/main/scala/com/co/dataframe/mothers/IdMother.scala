package com.co.dataframe.mothers

import scala.util.Random

object IdMother {

  def randomBetween(min: Int, max: Long): Long =
    Random.nextLong((max - min) + 1)

  def random(max: Long = Long.MaxValue - 1): Long =
    randomBetween(min = 1, max = max)
}
