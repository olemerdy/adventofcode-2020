package org.lafeuille.adventofcode.y2020.d02

import java.lang.Character.LOWERCASE_LETTER
import scala.io.Source
import scala.io.Source.fromURL
import scala.util.matching.Regex

case class Policy(min: Int, max: Int, letter: Char) {
  require(min >= 0)
  require(max >= 0)
  require(max >= min)
  require(letter.getType == LOWERCASE_LETTER)

  def check(password: String): Boolean = {
    val count = password.count(_ == letter)
    count >= min && count <= max
  }
}

object Day02 {

  private val regex: Regex = "(\\d+)-(\\d+) ([a-z]): ([a-z]+)".r

  def myInput: Source =
    fromURL(getClass.getResource("input.txt"))

  def myPolicies: List[(Policy, String)] =
    myInput.getLines.map {
      case regex(min, max, letter, password) =>
        (Policy(min.toInt, max.toInt, letter.charAt(0)), password)
      case _ => throw new IllegalArgumentException
    }.toList
}

object Day02Part1 extends App {

  def countValid(policies: List[(Policy, String)]): Int =
    policies.count{case (policy, password) => policy.check(password)}

  println(countValid(Day02.myPolicies))

}
