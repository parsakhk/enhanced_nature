package net.frayon.esn.block.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class LimestoneBlock extends Block {
    public LimestoneBlock(Properties p_49795_) {
        super(p_49795_);
    }

    @Override
    public void stepOn(Level p_152431_, BlockPos p_152432_, BlockState p_152433_, Entity p_152434_) {

        if(!p_152431_.isClientSide()) {
            if(p_152434_ instanceof LivingEntity) {
                LivingEntity livingEntity = (LivingEntity) p_152434_;


                p_152431_.destroyBlock(p_152432_, false);

            }
        }

        super.stepOn(p_152431_, p_152432_, p_152433_, p_152434_);
    }
}
