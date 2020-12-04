package org.lafeuille.adventofcode.y2020.d01

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class Day01Part2Spec extends AnyWordSpec with Matchers {

  "My input" should {

    val expected = 18847752
    s"have answer $expected" in {
      Day01Part2.answer(Day01.myExpenses) shouldBe Some(expected)
    }
  }

}
