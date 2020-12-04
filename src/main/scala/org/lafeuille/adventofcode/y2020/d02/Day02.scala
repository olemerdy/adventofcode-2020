package org.lafeuille.adventofcode.y2020.d02

import java.lang.Character.LOWERCASE_LETTER
import scala.io.Source
import scala.io.Source.fromURL
import scala.util.matching.Regex

case class CountPolicy(min: Int, max: Int, letter: Char) {
  require(min >= 0)
  require(max >= 0)
  require(max >= min)
  require(letter.getType == LOWERCASE_LETTER)

  def check(password: String): Boolean = {
    val count = password.count(_ == letter)
    count >= min && count <= max
  }
}

case class PositionPolicy(pos1: Int, pos2: Int, letter: Char) {
  require(pos1 >= 1)
  require(pos2 >= 1)
  require(letter.getType == LOWERCASE_LETTER)

  private def same(pos: Int, password: String): Boolean =
    password.charAt(pos - 1) == letter

  private def xor(bool1: Boolean, bool2: Boolean): Boolean =
    (bool1 || bool2) && !(bool1 && bool2)

  def check(password: String): Boolean =
    xor(same(pos1, password), same(pos2, password))

}

object Day02 {

  private val regex: Regex = "(\\d+)-(\\d+) ([a-z]): ([a-z]+)".r

  def myInput: Source =
    fromURL(getClass.getResource("input.txt"))

  def myCountPolicies: List[(CountPolicy, String)] =
    myInput.getLines.map {
      case regex(min, max, letter, password) =>
        (CountPolicy(min.toInt, max.toInt, letter.charAt(0)), password)
      case _ => throw new IllegalArgumentException
    }.toList

  def myPositionsPolicy: List[(PositionPolicy, String)] =
    myInput.getLines.map {
      case regex(pos1, pos2, letter, password) =>
        (PositionPolicy(pos1.toInt, pos2.toInt, letter.charAt(0)), password)
      case _ => throw new IllegalArgumentException
    }.toList
}

object Day02Part1 extends App {

  def countValid(policies: List[(CountPolicy, String)]): Int =
    policies.count { case (policy, password) => policy.check(password) }

  println(countValid(Day02.myCountPolicies))

}

object Day02Part2 extends App {

  def countValid(policies: List[(PositionPolicy, String)]): Int =
    policies.count { case (policy, password) => policy.check(password) }

  println(countValid(Day02.myPositionsPolicy))

}
