package io.github.rico040.disable_enderman_griefing.mixin;

import net.minecraft.entity.mob.monster.EndermanEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Arrays;

@Mixin(EndermanEntity.class)
public class EndermanMixin {

	@Shadow
	private static boolean[] HOLDABLE_BLOCKS;

	@Inject(method = "<clinit>", at = @At("TAIL"))
	private static void eraseHoldableBlocks(CallbackInfo ci) {
		Arrays.fill(HOLDABLE_BLOCKS, false);
	}
}
