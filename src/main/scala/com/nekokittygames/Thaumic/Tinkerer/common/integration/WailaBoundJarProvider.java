package com.nekokittygames.Thaumic.Tinkerer.common.integration;

import com.nekokittygames.Thaumic.Tinkerer.common.tiles.TileBoundJar;
import mcp.mobius.waila.api.*;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by Katrina on 01/06/2015.
 */
public class WailaBoundJarProvider implements IWailaDataProvider {


    @Override
    public ItemStack getWailaStack(IWailaDataAccessor accessor, IWailaConfigHandler config) {
        return null;
    }

    @Override
    public List<String> getWailaHead(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
        return currenttip;
    }

    @Override
    public List<String> getWailaBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
        if(!(accessor.getTileEntity() instanceof TileBoundJar))
            return currenttip;

        TileBoundJar jar=(TileBoundJar)accessor.getTileEntity();
        String network=jar.network();
        String colour= EnumDyeColor.byDyeDamage(jar.jarColor()).getUnlocalizedName();
        currenttip.add(Waila.lang.format("boundJar.network",network));
        currenttip.add(Waila.lang.format("boundJar.colour", StatCollector.translateToLocal(colour)));
        return currenttip;
    }

    @Override
    public List<String> getWailaTail(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
        return currenttip;
    }

    @Override
    public NBTTagCompound getNBTData(EntityPlayerMP player, TileEntity te, NBTTagCompound tag, World world, BlockPos pos) {
        return tag;
    }
}
