package org.lafeuille.adventofcode.y2020.d02

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class Day02Part2Spec extends AnyWordSpec with Matchers {

  "My input" should {

    val expected = 634
    s"have $expected valid passwords" in {
      Day02Part2.countValid(Day02.myPositionsPolicy) shouldBe expected
    }
  }

}
