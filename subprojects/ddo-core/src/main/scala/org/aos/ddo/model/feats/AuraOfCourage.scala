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

import org.aos.ddo.model.classes.CharacterClass
import org.aos.ddo.model.classes.CharacterClass.Paladin
import org.aos.ddo.support.requisite._

/**
  * [[http://ddowiki.com/page/Aura_of_Courage]]
  * Beginning at 3rd level, a Paladin is immune to fear (magical or otherwise).
  * Each ally within 10 feet of the paladin gains a +4 morale bonus on saving throws against fear effects for 9 seconds.
  * This ability functions while the paladin is conscious, but not if she is unconscious or dead.
  */
protected[feats] trait AuraOfCourage
    extends FeatRequisiteImpl
    with Passive
    with Active
    with GrantsToClass
    with RequiresAllOfClass { self: ClassFeat =>
  override def grantToClass: Seq[(CharacterClass, Int)] = List((Paladin, 3))

  override def anyOfClass: Seq[(CharacterClass, Int)] = List((Paladin, 3))
}
