package org.lafeuille.adventofcode.y2020.d01

import scala.io.Source
import scala.io.Source.fromURL

object Day01 {

  def myInput: Source =
    fromURL(getClass.getResource("input.txt"))

  def myExpenses: List[Int] =
    myInput.getLines.map(_.toInt).toList

}

object Day01Part1 extends App {

  def answer(expenses: List[Int]) =
    expenses
      .combinations(2)
      .withFilter(_.sum == 2020)
      .collectFirst(_.product)

  println(answer(Day01.myExpenses))
}