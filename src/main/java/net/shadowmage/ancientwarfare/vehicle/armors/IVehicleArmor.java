/*
 * Copyright 2012 John Cummens (aka Shadowmage, Shadowmage4513)
 * This software is distributed under the terms of the GNU General Public License.
 * Please see COPYING for precise license information.
 * <p>
 * This file is part of Ancient Warfare.
 * <p>
 * Ancient Warfare is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * Ancient Warfare is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with Ancient Warfare.  If not, see <http://www.gnu.org/licenses/>.
 */

package net.shadowmage.ancientwarfare.vehicle.armors;

import net.minecraft.item.ItemStack;

import java.util.Set;

public interface IVehicleArmor {

	int getGlobalArmorType();

	String getDisplayName();

	String getDisplayTooltip();

	String getIconTexture();

	float getGeneralDamageReduction();

	float getExplosiveDamageReduction();

	float getFireDamageReduction();

	float getArmorWeight();

	ItemStack getArmorStack(int qty);

	Set<Integer> getNeededResearch();
}