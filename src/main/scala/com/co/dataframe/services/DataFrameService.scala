package com.co.dataframe.services

import com.co.dataframe.model.Person
import org.apache.spark.sql.{DataFrame, SparkSession}

trait DataFrameService {

  def createDF1(
      sparkSession: SparkSession
  ): (Seq[Person], DataFrame)

  def createDF2(
      sparkSession: SparkSession,
      persons: Seq[Person]
  ): DataFrame

  def createDF3(
      sparkSession: SparkSession,
      persons: Seq[Person]
  ): DataFrame

  def createSparkSession: SparkSession

}
