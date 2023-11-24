package com.co.dataframe.mothers

import com.co.dataframe.model.Person

object PersonMother {

  def apply(
      id: Long = IdMother.random(),
      name: String = NamesMother.random(20)
  ): Person = Person(id, name)

  def randomSeq(): Seq[Person] = SeqMother.randomOf(apply())
}
