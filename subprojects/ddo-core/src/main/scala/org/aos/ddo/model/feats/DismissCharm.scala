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
import org.aos.ddo.support.requisite.{
  ClassRequisiteImpl,
  FeatRequisiteImpl,
  FreeFeat,
  GrantsToClass
}

/**
  * Activate this short-ranged ability while targeting a charmed, commanded, controlled,
  * or dominated enemy that is under your control to dispel the controlling effect.
  *
  * @note As of Update 26 all classes now receive this feat at level 1
  */
protected[feats] trait DismissCharm
    extends FeatRequisiteImpl
    with Active
    with FreeFeat
    with ClassRequisiteImpl
    with GrantsToClass { self: GeneralFeat =>

  override def grantToClass: Seq[(CharacterClass, Int)] =
    CharacterClass.values.map((_, 1))
}
