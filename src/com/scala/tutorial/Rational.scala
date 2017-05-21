package com.scala.tutorial

/**
  * Created by kishore on 5/4/17.
  */
class Rational(n: Int, d: Int) {
  require(d != 0)

  private val g = gcd(n.abs, d.abs)
  val numer: Int = n / g
  val denom: Int = d / g

  def this(n: Int) = { this(n, 1) //auxiliary constructor
    println("Auxiliary constructor " + n + "/" + 1)
  }

  override def toString: String = numer + "/" + denom

  def +(that: Rational): Rational = new Rational(numer * that.denom + that.numer * denom, denom * that.denom)

  def +(i: Int): Rational = new Rational(numer + i * denom, denom)

  def -(that: Rational): Rational = new Rational(this.numer * that.denom - that.numer * this.denom, this.denom * that.denom)

  def -(i: Int): Rational = new Rational(numer - i * denom, denom)

  def *(that: Rational): Rational = new Rational(this.numer * that.numer, this.denom * that.denom)

  def *(i: Int): Rational = new Rational(numer * i, denom)

  def /(that: Rational): Rational = new Rational(this.numer * that.denom, this.denom * that.numer)

  def /(i: Int): Rational = new Rational(numer, i * denom)

  def lessThan(that: Rational): Boolean = this.numer * that.denom < this.denom * that.numer

  def equals(that: Rational) = this.numer * that.denom == this.d * that.numer

  def greaterThan(that: Rational) = !lessThan(that) && !equals(that)

  def max(that: Rational) = if (lessThan(that)) that else this

  def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a%b)
}

object Rational {
  def main(args: Array[String]): Unit = {
    val r1 = new Rational(1, 14)
    val r2 = new Rational(1, 3)
    println(r1 + r2)
    println(r1 lessThan r2)
    println(r1 greaterThan r2)
    println(r1 max r2)
    println(r1 * r2)
    new Rational(5)
    println(new Rational(42, 66))
  }


}
