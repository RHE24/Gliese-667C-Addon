package mattparks.mods.gliese.vesta.network;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

import micdoodle8.mods.galacticraft.core.entities.GCCoreEntityLander;
import micdoodle8.mods.galacticraft.core.entities.player.GCCorePlayerMP;
import micdoodle8.mods.galacticraft.core.network.GCCorePacketLanderUpdate;
import micdoodle8.mods.galacticraft.core.util.PacketUtil;
import micdoodle8.mods.galacticraft.core.util.PlayerUtil;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class GCVestaPacketHandlerServer implements IPacketHandler
{
    @Override
    public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player p)
    {
        if (packet == null)
        {
            FMLLog.severe("Packet received as null!");
            return;
        }

        if (packet.data == null)
        {
            FMLLog.severe("Packet data received as null! ID " + packet.getPacketId());
            return;
        }

        final DataInputStream data = new DataInputStream(new ByteArrayInputStream(packet.data));

        final int packetType = PacketUtil.readPacketID(data);

        final EntityPlayerMP player = (EntityPlayerMP) p;

        GCCorePlayerMP gcPlayer = PlayerUtil.getPlayerBaseServerFromPlayer(player);

        if (packetType == 0)
        {
            Class<?>[] decodeAs = { Integer.class, Integer.class, String.class };
            Object[] packetReadout = PacketUtil.readPacketData(data, decodeAs);

            Entity entity = player.worldObj.getEntityByID((Integer) packetReadout[0]);

            {

                int subType = (Integer) packetReadout[1];

                switch (subType)
                {
                case 0:
                    {
                    }
                    break;
                case 1:
                    {
                    }
                    break;
                case 2:
                    {
                    }
                    break;
                case 3:
                    {
                    }
                    break;
                case 4:
                    {
                    }
                    break;
                case 5:
                    {
                    }
                    break;
                case 6:
                    {
                    }
                    break;
                }
            }
        }
        else if (packetType == 1)
        {
            FMLLog.severe("Starcraft Vesta: Received bad packet!");
        }
        else if (packetType == 2)
        {
            FMLLog.severe("Starcraft Vesta: Received bad packet!");
        }
        else if (packetType == 3)
        {
            gcPlayer.wakeUpPlayer(false, true, true, true);
        }
        else if (packetType == 4)
        {
            final Class<?>[] decodeAs = { Integer.class };
            final Object[] packetReadout = PacketUtil.readPacketData(data, decodeAs);
            Entity e = player.worldObj.getEntityByID((Integer) packetReadout[0]);

            if (e != null && e instanceof GCCoreEntityLander)
            {
                player.playerNetServerHandler.sendPacketToPlayer(GCCorePacketLanderUpdate.buildKeyPacket(e));
            }
        }
        else if (packetType == 5)
        {
            Class<?>[] decodeAs = { Integer.class, Integer.class, Integer.class, Integer.class, Integer.class };
            Object[] packetReadout = PacketUtil.readPacketData(data, decodeAs);

            TileEntity tile = player.worldObj.getBlockTileEntity((Integer) packetReadout[1], (Integer) packetReadout[2], (Integer) packetReadout[3]);

            switch ((Integer) packetReadout[0])
            {

            default:
                break;
            }
        }
        else if (packetType == 6)
        {
            Class<?>[] decodeAs = { Integer.class, Integer.class };
            Object[] packetReadout = PacketUtil.readPacketData(data, decodeAs);

            Entity entity = player.worldObj.getEntityByID((Integer) packetReadout[0]);

                int subType = (Integer) packetReadout[1];
                
                switch (subType)
                {
                default:
                    break;
                }
        }
	}
}

