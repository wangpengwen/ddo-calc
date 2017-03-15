package org.aos.ddo.model.feats

import org.aos.ddo.model.classes.CharacterClass
import org.concordion.api.FullOGNL
import org.concordion.integration.junit4.ConcordionRunner
import org.junit.runner.RunWith

@FullOGNL
@RunWith(classOf[ConcordionRunner])
class ArtificerClassFeatSpec extends ClassDisplayHelper {
  override val enum: E = ClassFeat

  override val cClass: CharacterClass = CharacterClass.Artificer

}
