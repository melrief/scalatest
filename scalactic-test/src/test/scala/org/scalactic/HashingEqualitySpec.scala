/*
 * Copyright 2001-2014 Artima, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.scalactic

import org.scalatest._
import scala.collection.GenSeq
import scala.collection.GenMap
import scala.collection.GenSet
import scala.collection.GenIterable
import scala.collection.GenTraversable
import scala.collection.GenTraversableOnce

class HashingEqualitySpec extends FunSpec with MustMatchers {
  describe("A Normalization") {
    it("can be converted to a HashingEquality via toHashingEquality") {
      val hashEq = StringNormalizations.lowerCased.toHashingEquality
      hashEq.hashCodeFor("HI") mustEqual hashEq.hashCodeFor("hi")
      hashEq.hashCodeFor("happy") mustEqual hashEq.hashCodeFor("happy")
      hashEq.hashCodeFor("CamelCase") mustEqual hashEq.hashCodeFor("cAmElCaSe")
    }
  }
  describe("HashingEquality") {
    it("must offer an implicit default HashingEquality that treats Arrays structurally") {
      val hashEq = implicitly[HashingEquality[Array[Int]]]
      hashEq.areEqual(Array(1, 2, 3), Array(1, 2, 3)) mustBe true
    }
  }
}
