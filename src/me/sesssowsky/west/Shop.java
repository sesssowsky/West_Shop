package me.sesssowsky.west;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Shop
  implements CommandExecutor, Listener
{
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    Player p = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("shop")) {
      if (p.hasPermission("westmc.shop"))
      {
        if (args.length == 0) {
          p.sendMessage("§c§lShop §8>> §7Poprawne uzycie§8: /§6shop §8<§6nick§8> §8<§6vip§8,§6svip§8,§6unban");
        }
        if (args.length == 1) {
          p.sendMessage("§c§lShop §8>> §7Poprawne uzycie§8: /§6shop §8<§6nick§8> §8<§6vip§8,§6svip§8,§6unban");
        }
        if (args.length == 2)
        {
          if (args[1].equalsIgnoreCase("vip"))
          {
            Bukkit.broadcastMessage("§8>> §7Gracz §6" + args[0] + " §7zakupil range §6§lVIP");
            Bukkit.broadcastMessage("§8>> §7Dziekujemy za wsparcie serwera!");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + args[0] + " group set VIP");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + args[0] + " group add VIP");
            return true;
          }
          if (args[1].equalsIgnoreCase("svip"))
          {
            Bukkit.broadcastMessage("§8>> §7Gracz §6" + args[0] + " §7zakupil range §b§lS§6§lVIP");
            Bukkit.broadcastMessage("§8>> §7Dziekujemy za wsparcie serwera!");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + args[0] + " group set SVIP");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + args[0] + " group add SVIP");
            return true;
          }
          if (args[1].equalsIgnoreCase("unban"))
          {
            Bukkit.broadcastMessage("§8>> §7Gracz §6" + args[0] + " §7zakupil usluge §c§lUNBAN");
            Bukkit.broadcastMessage("§8>> §7Dziekujemy za wsparcie serwera!");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pardon " + args[0]);
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "unban " + args[0]);
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "unbanip " + args[0]);
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pardonip " + args[0]);
            return true;
          }
        }
      }
      else
      {
        p.sendMessage("§4Error: §7Nie posiadasz permisji westmc.cmd.sklep!");
      }
    }
    return false;
  }
}
