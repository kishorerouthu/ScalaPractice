package com.scala.tutorial

/**
  * Created by kishore on 26/2/17.
  */

abstract class Notification

/**
  * Scala supports the notion of case classes. Case classes are just regular classes that are:
  *
  * Immutable by default
  * Decomposable through the Pattern Matching
  * Compared by structural equality instead of by reference
  * Succinct to instantiate and operate on
  */
case class Email(sourceEmail: String, title:  String, body: String) extends Notification
case class SMS(sourceNumber: String, message: String) extends Notification
case class VoiceRecording(contactName: String, link: String) extends Notification

object CaseClasstTest extends App {

  def showNotification(notification: Notification) : String = {
      notification match {
        case Email(email, title, _) => "You got an email from " + email + "with title: " + title
        case SMS(number, message) => "You got SMS from " + number + "! Message :" + message
        case VoiceRecording(name, link) => "You received a Voice Recording from " + name + "! Click  the link to hear it: " + link
      }
  }

  val someSms = SMS("12345", "Are you there?") //No need to use new keyword for case classes
  val somVoiceRecording = VoiceRecording("Tom", "voicerecording.org/id/123")

  println(showNotification(someSms))
  println(showNotification(somVoiceRecording))

  def showNotification(notification: Notification, specialEmail: String, specialNumber: String): String = {
      notification match {
        case Email(email, _, _) if email == specialEmail => "You got an email from special someone!" // if guards, the pattern match branch will fail if the condition in the guard return false.
        case SMS(number, _) if number == specialNumber => "You got SMS from special someone!"
        case other => showNotification(other) //nothing special delegate to original showNotification fucntion
      }
  }

  val SPECIAL_NUMBER = "55555"
  val SPECIAL_EMAIL = "kishore.routhu5@gmail.com"

  val someSMS = SMS("12345", "Are u there?")
  val someVoiceRecording = VoiceRecording("Tom", "voicerecording.org/id/123")

  val specialEmail = Email("kishore.routhu5@gmail.com", "Drinks tonight?", "I am free after 5!")
  val specialSMS = SMS("55555", "I am here! Where are you!")

  println(showNotification(someSms, SPECIAL_EMAIL, SPECIAL_NUMBER))
  println(showNotification(someVoiceRecording, SPECIAL_EMAIL, SPECIAL_NUMBER))

  println(showNotification(specialEmail, SPECIAL_EMAIL, SPECIAL_NUMBER))
  println(showNotification(specialSMS, SPECIAL_EMAIL, SPECIAL_NUMBER))


}
