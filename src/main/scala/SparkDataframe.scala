import java.util.UUID

import com.co.dataframe.model.{ID_DF1, ID_DF2, ID_DF3}
import com.co.dataframe.services.{DataFrameService, DataFrameServiceImpl}
import com.typesafe.scalalogging.LazyLogging

import scala.util.{Failure, Success, Try}

object SparkDataframe extends LazyLogging {

  def main(args: Array[String]): Unit = {

    logger.info("Start DataFrame Process")
    val idExecution = UUID.randomUUID().toString

    Try {
      val dataFrameService: DataFrameService = DataFrameServiceImpl

      val sparkSession = dataFrameService.createSparkSession
      logger.info(s"sparkSession was created with idExecutio : $idExecution")

      val (persons, df1) = dataFrameService.createDF1(sparkSession)

      val df2 = dataFrameService.createDF2(sparkSession, persons)
      val queryDF1WithDF2 = df1(s"$ID_DF1") === df2(s"$ID_DF2")

      val df3 = dataFrameService.createDF3(sparkSession, persons.take(10))
      val df4 = df1.join(df2, queryDF1WithDF2, "left")
      logger.info(s"dataframe 4: ${df4.count()}")

      val queryDF4WithDF3 = df4(s"$ID_DF1") === df3(s"$ID_DF3")

      val df5 = df4.join(df3, queryDF4WithDF3)
      logger.info(s"dataframe 5: ${df5.count()}")

      val report =
        df5.select(s"$ID_DF1", "name").withColumnRenamed(s"$ID_DF1", "id")

      logger.info(s"dataframe 5: ${report.show}")

      report.write
        .format("json")
        .save(
          s"/home/jairo/proyecto-cencoScotiabank/proyectos-oapi/java/spark-dataframe-example/tmp/$idExecution"
        )
      report
    }
  } match {
    case Failure(exception) =>
      logger.error(s"Ha ocurrio un error ${exception.getMessage}")
    case Success(_) =>
      logger.info("ejecucion correcta")
  }

}
