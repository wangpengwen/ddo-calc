package org.aos.ddo.model.feats

import org.aos.ddo.model.classes.CharacterClass
import org.aos.ddo.support.requisite.{ClassRequisite, FeatRequisiteImpl, FreeFeat}

/** Icon 	Feat 	Type 	Description 	Prerequisites
  * Icon Feat Light Armor Proficiency.png
  * Light Armor Proficiency 	Passive 	You are proficient with light armor, and do not suffer armor penalties to your attack rolls when wearing light armor.
  * You also gain 2 + 1/2 of your base attack bonus in physical resistance when wearing light armor.
  * *
  * None
  * */
protected[feats] trait LightArmorProficiency extends FeatRequisiteImpl with ClassRequisite with Passive with FreeFeat  {
  self: GeneralFeat =>
  override def anyOfClass: Seq[(CharacterClass, Int)] = List((CharacterClass.Barbarian,1))
}
