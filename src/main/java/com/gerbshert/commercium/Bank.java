package com.gerbshert.commercium;

import net.minecraft.entity.player.EntityPlayer;

/**
 * Created by Gabriel on 19-May-16.
 */
public class Bank {
    public static final String $ = "currency";
    protected static String player$ = "Wait";

    public static Double getBalance(EntityPlayer player) {
        return player.getEntityData().getDouble($);
    }

    public static void setBalance(EntityPlayer player, Double amount) {
        player.getEntityData().setDouble($, amount);
    }

    public static void addBalance(EntityPlayer player, Double amount) {
        Double currentBal = getBalance(player);
        setBalance(player, (currentBal + amount));
    }

    public static void removeBalance(EntityPlayer player, Double amount) {
        Double currentBal = getBalance(player);
        setBalance(player, (currentBal - amount));
    }

    public static void sendBalance(EntityPlayer giver, EntityPlayer getter, Double amount) {
        addBalance(getter, amount);
        removeBalance(giver, amount);
    }

    public static void updateClientPlayerBank(String playerBank) {
        String playerFinal$ = playerBank.substring(0, playerBank.indexOf('.') + 3);
        player$ = playerFinal$;
    }

    public static String getClientPlayerBank(String playerName) {
        return player$;
    }
}
