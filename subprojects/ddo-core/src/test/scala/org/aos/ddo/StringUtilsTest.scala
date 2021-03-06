/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * Copyright 2015-2019 Andre White.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
  * Copyright (C) 2015 Andre White (adarro@gmail.com)
  *
  * Licensed under the Apache License, Version 2.0 (the "License");
  * you may not use this file except in compliance with the License.
  * You may obtain a copy of the License at
  *
  * http://www.apache.org/licenses/LICENSE-2.0
  *
  * Unless required by applicable law or agreed to in writing, software
  * distributed under the License is distributed on an "AS IS" BASIS,
  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  * See the License for the specific language governing permissions and
  * limitations under the License.
  */
package org.aos.ddo

import org.aos.ddo.support.StringUtils.{Extensions, StringImprovements}
import org.scalatest.{FunSpec, Matchers}
import org.scalatest.OptionValues._
import com.typesafe.scalalogging.LazyLogging
import org.aos.ddo.support.matching.{WordMatchStrategies, WordMatchStrategy}
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.prop.PropertyChecks

import scala.collection.immutable.HashSet

@RunWith(classOf[JUnitRunner])
class StringUtilsTest extends FunSpec with PropertyChecks with Matchers with LazyLogging {
  final private val meaningOfLife = 42
  private final val ibm = List("I Believe Mom", "i borrow money", "IBetterMail")
  private final val nullString: String = null
  val strategyResults = Table(("Strategy", "Expected"),
    (WordMatchStrategies.FullUpperCaseWordStrategy, HashSet() ++ List("IBM")),
    (WordMatchStrategies.TitleCaseWordStrategy, HashSet() ++ List("IBM")),
    (WordMatchStrategies.FullLowerCaseWordStrategy, HashSet() ++ List("ibm")),
    (WordMatchStrategies.IgnoreCaseWordStrategy, HashSet() ++ List("IBM", "ibm"))

  )
  private val wordsWithSpaces: String = "I Believe Mom"
  private val wordsWithoutSpaces: String = "IBetterMail"
  private val controlChars: String = "\t\r\r"

  describe("toSanitizeOption") {
    it("should safely filter out non-alphanumeric and spaces") {
      controlChars.toSanitizeOption shouldBe empty
    }
    it("should safely wrap nulls") {
      noException shouldBe thrownBy(nullString.toSanitizeOption)
    }
  }
  describe("wordsToAcronym") {
    it("Should convert words with spaces into an acronym") {
      wordsWithSpaces.wordsToAcronym.value should equal("IBM")
    }

    it("Should convert words without spaces using Case into an acronym") {
      wordsWithoutSpaces.wordsToAcronym.value should equal("IBM")
    }
    it("should gracefully handle non-alpha input") {


      //      val wordList = List("I Believe Mom","i borrow money","IBetterMail","oracle","\t")
      //      val wMap = wordList.map(x => x.wordsToAcronym.value)
      "\t".wordsToAcronym shouldBe empty
    }
    it("should make all acronyms Upper Case when option is supplied") {
      forAll(strategyResults) { (s: WordMatchStrategy, hs: HashSet[String]) =>

        implicit val ws: WordMatchStrategy = s
        logger.info(s"Testing Strategy ${s.stringMatchOption} ${s.getClass.getSimpleName}")
        val bigBlue = ibm.map {
          {
            _.wordsToAcronym.value
          }
        }
        bigBlue should not contain None
        bigBlue.toSet should equal(hs)
      }



      //  bigBlue.toSet should equal(HashSet() ++ List("IBM"))
    }
  }

  describe("StringImprovements") {
    it("implicitly allows safe string to int conversions") {
      import org.aos.ddo.support.StringUtils.StringImprovements // scalastyle:off import.grouping due to implicit scoping
      val love: Option[Int] = "42".toIntOpt
      love should not be empty
      love should be(Some(meaningOfLife))
    }
    it("gracefully handles bad cast attempts") {
      val wilSmyth = "deadShot".toIntOpt
      wilSmyth should be(empty)
    }

  }
}
