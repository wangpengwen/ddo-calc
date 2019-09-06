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
import org.aos.ddo.support.requisite.{FeatRequisiteImpl, RequiresAttribute}

/**
  * Icon 	Feat 	Type 	Description 	Prerequisites
  * Icon Feat Two Handed Fighting.png
  * Two Handed Fighting 	Passive 	Increases the damage of glancing blow attacks when wielding a
  * two-handed weapon by 10% (from a base of 20% normal weapon damage).
  * Also grants a 3% chance for weapon effects to trigger on glancing blows and a +2 Combat Style bonus to Melee Power.
  *
  * Strength 15
  **/
trait TwoHandedFighting extends FeatRequisiteImpl
  with Passive
  with RequiresAttribute
  with FighterBonusFeat
  with MartialArtsFeat
  with ArtificerBonusFeat {
  self: GeneralFeat =>
  override def requiresAttribute: Seq[(Attribute, Int)] = List((Attribute.Strength, 15))
}
