package net.frayon.esn.block.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.stream.Stream;

public class SaguaroBlock extends Block{
    public SaguaroBlock(Properties p_54120_) {
        super(p_54120_);
    }
    public static final VoxelShape SHAPE = Stream.of(
            Block.box(8, 9, 10, 10, 10, 11),
            Block.box(6, -1, 7, 9, 31, 10),
            Block.box(7, 31, 8, 8, 32, 9),
            Block.box(1, 10, 7, 5, 18, 11),
            Block.box(9, 10, 11, 11, 25, 13),
            Block.box(7, 10, 4, 10, 29, 6),
            Block.box(10, 18, 12, 12, 20, 16),
            Block.box(10, 20, 15, 13, 31, 17),
            Block.box(8, 19, 0, 10, 21, 4),
            Block.box(7, 21, -1, 10, 32, 1),
            Block.box(-3, 13, 8, 1, 15, 10),
            Block.box(-4, 15, 8, -2, 19, 11),
            Block.box(7, 10, 6, 10, 11, 7),
            Block.box(5, 10, 7, 6, 11, 10)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    @Override
    public VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_) {
        return SHAPE;
    }


}
