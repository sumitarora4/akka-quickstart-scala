package com.akkademy

import akka.actor.ActorSystem
import akka.testkit.TestActorRef
import org.scalatest.{BeforeAndAfterEach}
import org.scalatest.funspec.AnyFunSpecLike
import org.scalatest.matchers.must.Matchers
import com.akkademy.message.SetRequest
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

class AkkademyDbSpec extends AnyFunSpecLike with Matchers with BeforeAndAfterEach{

  implicit  val system = ActorSystem()

  describe("akkademyDb"){
    describe("given SetRequest"){
      it("shoud place key/value in map"){
        val actorRef = TestActorRef(new AkkademyDb)

        actorRef ! SetRequest("key", "value")

        val akkademyDb = actorRef.underlyingActor
        akkademyDb.map.get("key") should equal(Some("value"))
      }
    }
  }

}
