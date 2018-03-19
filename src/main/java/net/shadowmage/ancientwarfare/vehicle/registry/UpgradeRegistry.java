/**
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

package net.shadowmage.ancientwarfare.vehicle.registry;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistry;
import net.shadowmage.ancientwarfare.vehicle.item.ItemUpgrade;
import net.shadowmage.ancientwarfare.vehicle.upgrades.IVehicleUpgradeType;
import net.shadowmage.ancientwarfare.vehicle.upgrades.VehicleUpgradeAim;
import net.shadowmage.ancientwarfare.vehicle.upgrades.VehicleUpgradePitchDown;
import net.shadowmage.ancientwarfare.vehicle.upgrades.VehicleUpgradePitchUp;
import net.shadowmage.ancientwarfare.vehicle.upgrades.VehicleUpgradePower;
import net.shadowmage.ancientwarfare.vehicle.upgrades.VehicleUpgradeReload;
import net.shadowmage.ancientwarfare.vehicle.upgrades.VehicleUpgradeSpeed;
import net.shadowmage.ancientwarfare.vehicle.upgrades.VehicleUpgradeTurretPitch;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UpgradeRegistry {

	public static IVehicleUpgradeType speedUpgrade;
	public static IVehicleUpgradeType aimUpgrade;
	public static IVehicleUpgradeType reloadUpgrade;

	public static IVehicleUpgradeType powerUpgrade;
	public static IVehicleUpgradeType pitchExtUpgrade;
	public static IVehicleUpgradeType pitchUpUpgrade;
	public static IVehicleUpgradeType pitchDownUpgrade;

	private static Map<ResourceLocation, IVehicleUpgradeType> upgradeInstances = new HashMap<>();

	private UpgradeRegistry() {
	}

	public static UpgradeRegistry instance() {
		if (INSTANCE == null) {
			INSTANCE = new UpgradeRegistry();
		}
		return INSTANCE;
	}

	private static UpgradeRegistry INSTANCE;

	public Collection<IVehicleUpgradeType> getUpgradeList() {
		return this.upgradeInstances.values();
	}

	/**
	 * called during init to register upgrade types as items
	 */
	public static void registerUpgrades(IForgeRegistry<Item> registry) {
		speedUpgrade = registerUpgrade(new VehicleUpgradeSpeed(0), registry);
		aimUpgrade = registerUpgrade(new VehicleUpgradeAim(), registry);
		reloadUpgrade = registerUpgrade(new VehicleUpgradeReload(), registry);
		powerUpgrade = registerUpgrade(new VehicleUpgradePower(), registry);
		pitchExtUpgrade = registerUpgrade(new VehicleUpgradeTurretPitch(), registry);
		pitchUpUpgrade = registerUpgrade(new VehicleUpgradePitchUp(), registry);
		pitchDownUpgrade = registerUpgrade(new VehicleUpgradePitchDown(), registry);
	}

	private static IVehicleUpgradeType registerUpgrade(IVehicleUpgradeType upgrade, IForgeRegistry<Item> registry) {
		upgradeInstances.put(upgrade.getRegistryName(), upgrade);
		ItemUpgrade item = new ItemUpgrade(upgrade.getRegistryName());
		registry.register(item);
		return upgrade;
	}

	public static IVehicleUpgradeType getUpgrade(ResourceLocation type) {
		return upgradeInstances.get(type);
	}

	public static IVehicleUpgradeType getUpgrade(ItemStack stack) {
		return upgradeInstances.get(stack.getItem().getRegistryName());
	}
}
