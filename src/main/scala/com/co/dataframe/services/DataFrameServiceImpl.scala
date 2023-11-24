package com.co.dataframe.services

import com.co.dataframe.model.{ID_DF1, ID_DF2, ID_DF3, Person}
import com.co.dataframe.mothers.PersonMother
import com.typesafe.scalalogging.LazyLogging
import org.apache.spark.sql.{DataFrame, SparkSession}

trait DataFrameServiceImpl extends DataFrameService with LazyLogging {
  override def createDF1(
      sparkSession: SparkSession
  ): (Seq[Person], DataFrame) = {
    import sparkSession.implicits._

    val seqPerson = PersonMother.randomSeq()

    val df1 = seqPerson.toDF(s"$ID_DF1", "name")
    logger.info(s"dataFrame 1 was created, count : ${df1.count()}")
    (seqPerson.take(1000), df1)
  }

  override def createDF2(
      sparkSession: SparkSession,
      persons: Seq[Person]
  ): DataFrame = {
    import sparkSession.implicits._
    val df2 = persons.toDF(s"$ID_DF2", "nombre")
    logger.info(s"dataFrame 2 was created, count : ${df2.count()}")
    df2
  }

  override def createDF3(
      sparkSession: SparkSession,
      persons: Seq[Person]
  ): DataFrame = {
    import sparkSession.implicits._
    val df3 = persons.toDF(s"$ID_DF3", "nombre")
    logger.info(s"dataFrame 3 was created, count : ${df3.count()}")
    df3
  }

  override def createSparkSession: SparkSession = {
    SparkSession
      .builder()
      .appName("Scala Dataframe Example")
      .config("spark.master", "local")
      .config("spark.driver.maxResultSize", "512m")
      .config("spark.driver.memory", "512m")
      .config("spark.executor.memory", "512m")
      .config("spark.logConf", value = true)
      .config(
        "spark.sql.shuffle.partitions",
        6
      ) // TODO: Definir el numero de particiones mas inteligentemente
      .getOrCreate()
  }
}

object DataFrameServiceImpl extends DataFrameServiceImpl
