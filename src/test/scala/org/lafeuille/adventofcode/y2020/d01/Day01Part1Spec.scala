package org.lafeuille.adventofcode.y2020.d01

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
;

class Day01Part1Spec extends AnyWordSpec with Matchers {

  "My input" should {

    val expected = 1007104
    s"have answer $expected" in {
      Day01Part1.answer(Day01.myExpenses) shouldBe Some(expected)
    }
  }

}