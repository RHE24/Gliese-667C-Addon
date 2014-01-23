package mattparks.mods.gliese.GlieseE.dimension;

import java.util.Random;

import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.api.world.ITeleportType;
import micdoodle8.mods.galacticraft.core.GCCoreConfigManager;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.core.entities.GCCoreEntityLander;
import micdoodle8.mods.galacticraft.core.entities.player.GCCorePlayerMP;
import micdoodle8.mods.galacticraft.core.network.GCCorePacketHandlerClient.EnumPacketClient;
import micdoodle8.mods.galacticraft.core.util.PacketUtil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class GCGlieseETeleportType implements ITeleportType
{
    @Override
    public Vector3 getEntitySpawnLocation(WorldServer world, Entity entity)
    {
        return new Vector3(entity.posX, GCCoreConfigManager.disableLander ? 250.0 : 900.0, entity.posZ);
    }

    @Override
    public Vector3 getParaChestSpawnLocation(WorldServer world, EntityPlayerMP player, Random rand)
    {
        return null;
    }

    @Override
    public Vector3 getPlayerSpawnLocation(WorldServer world, EntityPlayerMP player)
    {
        if (player instanceof GCCorePlayerMP)
        {
            return new Vector3(((GCCorePlayerMP) player).getCoordsTeleportedFromX(), GCCoreConfigManager.disableLander ? 250.0 : 900.0, ((GCCorePlayerMP) player).getCoordsTeleportedFromZ());
        }

        return null;
    }

    @Override
    public void onSpaceDimensionChanged(World newWorld, EntityPlayerMP player, boolean ridingAutoRocket)
    {
        if (!ridingAutoRocket && player instanceof GCCorePlayerMP && ((GCCorePlayerMP) player).getTeleportCooldown() <= 0)
        {
            final GCCorePlayerMP gcPlayer = (GCCorePlayerMP) player;

            if (gcPlayer.capabilities.isFlying)
            {
                gcPlayer.capabilities.isFlying = false;
            }

            GCCoreEntityLander lander = new GCCoreEntityLander(gcPlayer);
            lander.setPositionAndRotation(player.posX, player.posY, player.posZ, 0, 0);

            if (!newWorld.isRemote)
            {
                newWorld.spawnEntityInWorld(lander);
            }

            final Object[] toSend2 = { 1 };
            gcPlayer.playerNetServerHandler.sendPacketToPlayer(PacketUtil.createPacket(GalacticraftCore.CHANNEL, EnumPacketClient.ZOOM_CAMERA, toSend2));

            gcPlayer.setTeleportCooldown(10);
        }
    }

    @Override
    public boolean useParachute()
    {
        return false;
    }
}