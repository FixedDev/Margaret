package me.oczi.bukkit.commands;

import app.ashcon.intake.Command;
import app.ashcon.intake.bukkit.parametric.annotation.Sender;
import me.oczi.bukkit.objects.player.MargaretPlayer;
import me.oczi.bukkit.utils.*;
import me.oczi.common.utils.CommonsUtils;
import net.kyori.text.TextComponent;
import net.kyori.text.event.ClickEvent;
import net.kyori.text.format.TextColor;
import net.kyori.text.format.TextDecoration;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;

public class CommandVersion {

  @Command(
      aliases = {"version", "ver"},
      desc = "Plugin version information.")
  public void version(@Sender CommandSender sender,
                      Plugin plugin) {
    PluginDescriptionFile description = plugin.getDescription();
    MessageUtils.compose(sender,
        Messages.MARGARET_INFO,
        true,
        description.getVersion());
    String authors = CommonsUtils.joinCollection(
        description.getAuthors());
    MessageUtils.compose(sender,
        Messages.AUTHORS,
        true,
        authors);
    TextComponent component = composeGithubMessage(description);
    MessageUtils.composeInteractive(sender,
        Messages.GITHUB_URL,
        true,
        component);
    if (sender instanceof Player) {
      MargaretPlayer margaretPlayer = MargaretPlayers.getAsMargaretPlayer(sender);
      SoundUtils.playSound(margaretPlayer, VersionSound.LEVEL_UP);
    }
  }

  private TextComponent composeGithubMessage(PluginDescriptionFile description) {
    String website = description.getWebsite();
    return TextComponent.of(website)
        .color(TextColor.DARK_AQUA)
        .decoration(TextDecoration.UNDERLINED, true)
        .clickEvent(ClickEvent.openUrl(website))
        .hoverEvent(MessageUtils
            .hoverTextOf(Messages.GITHUB_HOVER));
  }
}
