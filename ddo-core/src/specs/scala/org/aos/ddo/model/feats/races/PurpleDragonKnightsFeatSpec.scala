package org.aos.ddo.model.feats.races

import org.aos.ddo.model.feats.RaceSupport
import org.aos.ddo.model.race.Race
import org.concordion.integration.junit4.ConcordionRunner
import org.junit.runner.RunWith

@RunWith(classOf[ConcordionRunner])
class PurpleDragonKnightsFeatSpec extends RaceSupport{
  override val raceId: Race = Race.PurpleDragonKnight
}