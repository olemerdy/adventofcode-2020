package org.lafeuille.adventofcode.y2020.d02

import org.scalatest.matchers.should.Matchers
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.wordspec.AnyWordSpec

class Day02Part1Spec extends AnyWordSpec with Matchers with TableDrivenPropertyChecks {

  "Sample input" should {

    val table = Table(
      ("Policy", "Password", "Valid"),
      (Policy(1, 3, 'a'), "abcde", true),
      (Policy(1, 3, 'b'), "cdefg", false),
      (Policy(2, 9, 'c'), "ccccccccc", true)
    )

    forAll(table) { (policy, password, valid) =>
      s"password '$password' complies to policy $policy: $valid" in {
        policy.check(password) shouldBe valid
      }
    }
  }
  "My input" should {

    val expected = 550
    s"have 550 valid passwords $expected" in {
      Day02Part1.countValid(Day02.myPolicies) shouldBe expected
    }
  }

}
