/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * Copyright 2015-2019 Andre White.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.aos.ddo.model.feats

import org.aos.ddo.model.attribute.Attribute
import org.aos.ddo.model.classes.CharacterClass
import org.aos.ddo.model.classes.CharacterClass.Ranger
import org.aos.ddo.support.requisite._

/**
  * Icon Feat Rapid Shot.png
  * Rapid Shot 	Passive 	You can make ranged attacks about 20% faster and reload faster when using a ranged weapon.
  * *
  * Point Blank Shot
  * Dexterity 13,
  *
  * @todo Should we move this to a Class Feat due to the Auto grant to Rangers
  */
protected[feats] trait RapidShot
  extends FeatRequisiteImpl
    with ClassRequisiteImpl
    with Passive
    with RequiresAllOfFeat
    with RequiresAttribute
    with GrantsToClass
    with ArtificerBonusFeat {
  self: GeneralFeat =>
  override def grantToClass: Seq[(CharacterClass, Int)] = List((Ranger, 2))

  override def requiresAttribute: Seq[(Attribute, Int)] =
    List((Attribute.Dexterity, 13))

  override def allOfFeats: Seq[GeneralFeat] = List(GeneralFeat.PointBlankShot)
}
