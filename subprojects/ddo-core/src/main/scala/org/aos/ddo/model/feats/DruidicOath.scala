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
import org.aos.ddo.model.classes.CharacterClass.Druid
import org.aos.ddo.support.requisite.{FeatRequisiteImpl, GrantsToClass, RequiresAllOfClass}

/**
  * You gain an additional spell preparation slot per spell level to cast Summon Nature's Ally spell of that level.
  */
protected[feats] trait DruidicOath
  extends FeatRequisiteImpl
    with Active
    with GrantsToClass
    with RequiresAllOfClass  {
  override def allOfClass: Seq[(CharacterClass, Int)] = List((Druid, 1))

  override def grantToClass: Seq[(CharacterClass, Int)] =List((Druid, 1))


}

