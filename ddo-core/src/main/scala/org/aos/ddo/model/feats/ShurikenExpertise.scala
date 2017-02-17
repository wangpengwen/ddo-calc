package org.aos.ddo.model.feats

import org.aos.ddo.model.attribute.Attribute
import org.aos.ddo.model.feats.GeneralFeat.ExoticWeaponProficiency
import org.aos.ddo.model.item.weapon.WeaponCategory
import org.aos.ddo.support.requisite.{FeatRequisiteImpl, RequiresAnyOfFeat, RequiresAttribute}

/** Shuriken Expertise.PNG
  * Shuriken Expertise 	Passive 	You are skilled with the use of the shuriken, and have a chance to throw an additional one per throw. (Percent chance to throw an additional shuriken is equal to your Dexterity.) This is also a racial feat given to all Drow Elf at level 1, regardless of class.
  * *
  * Dexterity 13
  * MustContainAtLeastOne of: Proficiency: Shuriken or
  * Half-Elf Dilettante: Monk
  * */
protected[feats] trait ShurikenExpertise extends FeatRequisiteImpl with Passive with RequiresAttribute with RequiresAnyOfFeat {
  self: GeneralFeat =>
  override def requiresAttribute: Seq[(Attribute, Int)] = List((Attribute.Dexterity, 13))

 // Feat.exoticWeaponProficiencies.filter { x => x.weapon.forall { y => y.enumEntry == WeaponCategory.Shuriken } }

  private def exotic = GeneralFeat.exoticWeaponProficiencies collect { case x: ExoticWeaponProficiency if x.weapon.head == WeaponCategory.Shuriken => x }

  override def anyOfFeats: Seq[Feat] = exotic :+ RacialFeat.HalfElfDilettanteMonk
}