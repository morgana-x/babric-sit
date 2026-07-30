package net.morgana.sit;

import net.minecraft.entity.Entity;
import net.minecraft.entity.mob.SlimeEntity;
import net.minecraft.entity.player.PlayerEntity;

import java.util.*;

public class SitMod {

    public static boolean CustomCommandSystem;

    public static boolean Server;

    static Map<PlayerEntity, Entity> seats =  new HashMap<PlayerEntity, Entity>();

    static Entity getSeat(PlayerEntity p)
    {
        return seats.getOrDefault(p, null);
    }

    public static boolean seated(PlayerEntity p)
    {
        return getSeat(p) != null;
    }

    public static void mountSeat(PlayerEntity p)
    {
        if (p == null)
            return;

        if (getSeat(p) != null)
            unMountSeat(p);

        if (p.vehicle != null)
            return;


        if (!p.isAlive() || p.isInsideWall() || p.isSleeping() || !p.onGround)
            return;

        SlimeEntity e = new SlimeEntity(p.world);

        e.setSize(0);
        e.height = 0.025f;
        e.setPosition(p.x, p.y + 0.025, p.z);

        e.passenger = p;

        p.world.spawnEntity(e);

        p.setVehicle(e);

        seats.put(p, e);
    }

    public static void unMountSeat(PlayerEntity p)
    {
        if (p == null)
            return;

        Entity seat = getSeat(p);


        if (p.vehicle != null && p.vehicle == seat) {
            Entity v = p.vehicle;
            p.setVehicle(null);
        }

        if (seat != null && seat.world.entities.contains(seat))
            seat.markDead();


        seats.remove(p);
    }


    public static void toggleSit(PlayerEntity p)
    {
        if (p == null)
            return;


        if (getSeat(p) != null)
            unMountSeat(p);
        else
            mountSeat(p);
    }

    public static void OnEntityRemoved(Entity e)
    {
        if (e == null)
            return;

        if (e instanceof PlayerEntity pl) {
            unMountSeat(pl);
            return;
        }

        for (PlayerEntity p: seats.keySet()) {
            if (getSeat(p) == e)
            {
                unMountSeat(p);
                break;
            }
        }
    }

    public static void Cleanup()
    {
        for (PlayerEntity e: seats.keySet()) {
           unMountSeat(e);
        }

        System.out.println("Cleaned up seat entities!");
    }

    public static void Init(boolean server, boolean customCommandSystem)
    {
        Server = server;

        CustomCommandSystem = customCommandSystem;

        System.out.println("Initialising Sit... (CustomCommandSystem = " + CustomCommandSystem + ")");
    }

}
