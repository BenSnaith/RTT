package net.riusab.rtt;

import net.fabricmc.api.ModInitializer;

import net.riusab.rtt.block.ModBlocks;
import net.riusab.rtt.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RiusabsTimeTravel implements ModInitializer {
	public static final String MOD_ID = "riusabs-time-travel";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}