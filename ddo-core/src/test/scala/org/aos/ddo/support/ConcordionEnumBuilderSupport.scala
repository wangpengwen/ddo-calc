package org.aos.ddo.support

import java.lang.Iterable

import scala.collection.JavaConverters.asJavaIterableConverter
import scala.util.Try

/**
  * Created by adarr on 1/25/2017.
  */
trait ConcordionEnumBuilderSupport {
  implicit protected[this] val myStringOrdering: Ordering[String] = Ordering.fromLessThan[String](_ > _)

  def actual: Seq[String]

  def listValues(heading: String): String = {
    val data = actual.map { a => s"<tr><td>$a</td></tr>" }.mkString
    val header = s"<table><tr><th>$heading</th></tr>"
    val footer = "</table>"
    s"$header$data$footer"
  }

  /**
    * Needed for Concordion / Java compatibility as it does not recognize optional parameters.
    *
    * @return
    */
  def listValues(): String = {
    listValues("Expected Values")
  }

  def getValidSingleValue: String =
    actual.headOption.getOrElse("Please specify at least one value for this enum")

  protected def strToBool(s: String): Boolean = Try(s.toBoolean).getOrElse(false)

  protected[this] def resultCount(searchString: String, ignoreCase: Boolean): Int = {
    withNames(searchString, ignoreCase = ignoreCase).size
  }

  def resultCount(searchString: String, ignoreCase: String): Int = {
    resultCount(searchString, strToBool(ignoreCase))
  }

   def withNames(searchString: String, ignoreCase: Boolean): Seq[String] = {
    val ss = searchString.split(',').toSet.toSeq
    if (ignoreCase) {
      for {a <- actual
           s <- ss
           if a.equalsIgnoreCase(s.trim)} yield s
    }
    else {
      ss.intersect(actual)
    }
  }


  def withNames(searchString: String, ignoreCase: String): Iterable[String] = {
    withNames(searchString, strToBool(ignoreCase))
  }.sortWith(_ < _).asJava
}