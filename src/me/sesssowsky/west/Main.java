package me.sesssowsky.west;

import java.io.PrintStream;
import org.bukkit.Bukkit;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main
  extends JavaPlugin
{
  public void onEnable()
  {
    System.out.println("[West_Shop] Plugin na sklep zostal zaladowany!");
    Bukkit.getPluginManager().registerEvents(new Shop(), this);
    getCommand("shop").setExecutor(new Shop());
  }
}
