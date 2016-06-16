package com.gerbshert.commercium.commands;

import com.gerbshert.commercium.Bank;
import com.gerbshert.commercium.libraries.Strings;
import com.google.common.collect.Lists;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;

import java.util.List;

/**
 * Created by Gabriel on 15-Jun-16.
 */
public class CommandEconBalance extends CommandBase {
    public CommandEconBalance() {
    }

    @Override
    public String getCommandName() {
        return "econBalance";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/econBalance {playerName}";
    }

    @Override
    public List<String> getCommandAliases() {
        return Lists.newArrayList(new String[]{"econBalance", "economyBalance", "commerceBalance", Strings.MOD_ID + "Balance", "econbalance", "economybalance", "commercebalance", Strings.MOD_ID + "balance"});
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if (sender instanceof EntityPlayer) {
            if (args.length == 1){
                sender.addChatMessage(new TextComponentString("[Commercium]: Your balance is " + Bank.getBalance(args[0])));
            }
            else{
            sender.addChatMessage(new TextComponentString("[Commercium]: Your balance is " + Bank.getBalance(sender.getName())));
            }
        }
    }


    @Override
    public List<String> getTabCompletionOptions(MinecraftServer server, ICommandSender sender, String[] args, BlockPos pos) {
        return null;
    }

    @Override
    public boolean isUsernameIndex(String[] args, int index) {
        return false;
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }

    @Override
    public int compareTo(ICommand o) {
        return 0;
    }
}