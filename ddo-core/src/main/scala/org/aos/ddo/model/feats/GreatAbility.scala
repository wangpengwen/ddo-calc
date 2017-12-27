package org.aos.ddo.model.feats

import org.aos.ddo.support.requisite.RequiresCharacterLevel

/**
  * Epic Feat that can be taken at level 21 or 24.
  */
protected[feats] trait GreatAbility extends Passive with RequiresCharacterLevel {
  self: EpicFeat =>
  override val characterLevel: Int = 21
}