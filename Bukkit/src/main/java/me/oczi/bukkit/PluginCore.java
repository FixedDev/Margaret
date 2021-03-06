package me.oczi.bukkit;

import me.oczi.bukkit.internal.CooldownManager;
import me.oczi.bukkit.internal.MemoryManager;
import me.oczi.bukkit.internal.ObjectCycleManager;
import me.oczi.bukkit.internal.commandmanager.CommandManager;
import me.oczi.bukkit.internal.database.DatabaseManager;
import me.oczi.bukkit.internal.database.DbTasks;
import me.oczi.bukkit.objects.partner.Partner;
import me.oczi.bukkit.objects.player.MargaretPlayer;
import me.oczi.bukkit.utils.GenderManager;
import me.oczi.common.dependency.Dependency;
import org.bukkit.event.Event;

import java.io.File;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

/**
 * The plugin's core that collects
 * all the components and initialize them.
 */
public interface PluginCore {

  /**
   * Call a Bukkit Event.
   * @param event Event to call.
   */
  void callEvent(Event event);

  /**
   * Get partner by id.
   * @param id ID of partner.
   * @return Partner, or EmptyPartner if not exists.
   */
  Partner getPartner(String id);

  /**
   * Get MargaretPlayer by UUID.
   * @param uuid UUID of Player.
   * @return MargaretPlayer, or EmptyMargaretPlayer if not exist.
   */
  MargaretPlayer getMargaretPlayer(UUID uuid);

  /**
   * Get logger of plugin.
   * @return Logger.
   */
  Logger getLogger();

  /**
   * Get {@link DatabaseManager} of Plugin.
   * @return Database manager.
   */
  DatabaseManager getDatabaseManager();

  /**
   * Get {@link DbTasks} of {@link DatabaseManager}.
   * @return Database Task.
   */
  DbTasks getDatabaseTask();

  /**
   * {@link MargaretMain#createAndGetFile(String)}
   * with try-and-catch internal.
   * @param filename Filename to get.
   * @return File.
   */
  File createAndGetFile(String filename);

  /**
   * Get {@link CooldownManager} of plugin.
   * @return Cooldown manager.
   */
  CooldownManager getCooldownManager();

  /**
   * Get {@link MemoryManager} of plugin.
   * @return Memory manager.
   */
  MemoryManager getMemoryManager();

  /**
   * Get data folder of plugin.
   * @return folder.
   */
  File getDataFolder();

  /**
   * Get lib folder of plugin
   * @return folder.
   */
  File getLibFolder();

  /**
   * Get loaded dependencies of plugin.
   * @return Dependencies.
   */
  List<Dependency> getLoadedDependencies();

  CommandManager getCommandManager();

  GenderManager getGenderManager();

  ObjectCycleManager getObjectCycleManager();
}
