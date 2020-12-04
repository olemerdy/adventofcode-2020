package org.lafeuille.adventofcode.y2020.d02

import org.scalatest.matchers.should.Matchers
import org.scalatest.prop.TableDrivenPropertyChecks
import org.scalatest.wordspec.AnyWordSpec

class Day02Part1Spec extends AnyWordSpec with Matchers with TableDrivenPropertyChecks {

  "Sample input" should {

    val table = Table(
      ("Policy", "Password", "Valid"),
      (CountPolicy(1, 3, 'a'), "abcde", true),
      (CountPolicy(1, 3, 'b'), "cdefg", false),
      (CountPolicy(2, 9, 'c'), "ccccccccc", true)
    )

    forAll(table) { (policy, password, valid) =>
      s"password '$password' complies to policy $policy: $valid" in {
        policy.check(password) shouldBe valid
      }
    }
  }

  "My input" should {

    val expected = 550
    s"have $expected valid passwords" in {
      Day02Part1.countValid(Day02.myCountPolicies) shouldBe expected
    }
  }

}
