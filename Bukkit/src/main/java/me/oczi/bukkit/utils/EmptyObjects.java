package me.oczi.bukkit.utils;

import com.github.benmanes.caffeine.cache.Cache;
import me.oczi.bukkit.objects.*;
import me.oczi.bukkit.objects.collections.CacheSet;
import me.oczi.bukkit.objects.collections.HomeList;
import me.oczi.bukkit.objects.collections.PartnerPermissionSet;
import me.oczi.bukkit.objects.partner.Partner;
import me.oczi.bukkit.objects.player.MargaretPlayer;
import me.oczi.bukkit.objects.player.MargaretPlayerMeta;
import me.oczi.bukkit.utils.settings.EnumSettings;
import me.oczi.common.exceptions.NotInstantiatedClassException;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Empty objects created to avoid return null
 * if the object doesn't exist.
 */
public final class EmptyObjects {

  private static final Home EMPTY_HOME = new EmptyHome();

  private static final CacheSet<Proposal> EMPTY_PROPOSALS = new EmptyCacheSet<>();

  private static final Partner EMPTY_PARTNER = new EmptyPartner();

  private static final MargaretPlayer EMPTY_MARGARET_PLAYER = new EmptyMargaretPlayer(EMPTY_PARTNER);

  private EmptyObjects() {
    throw new NotInstantiatedClassException();
  }


  public static MargaretPlayer getEmptyMargaretPlayer() {
    return EMPTY_MARGARET_PLAYER;
  }

  public static Partner getEmptyPartner() {
    return EMPTY_PARTNER;
  }

  public static String getEmptyPartnerId() {
    return EMPTY_PARTNER.getId();
  }

  public static Proposal getEmptyProposal() {
    return EMPTY_MARGARET_PLAYER.getCurrentProposal();
  }

  public static CacheSet<Proposal> getEmptyProposals() {
    return EMPTY_PROPOSALS;
  }

  public static Home getEmptyHome() {
    return EMPTY_HOME;
  }

  private static class EmptyMargaretPlayer implements MargaretPlayer {
    private final Partner EMPTY_PARTNER;
    private final Proposal EMPTY_PROPOSAL = new EmptyProposal();

    private EmptyMargaretPlayer(Partner EMPTY_PARTNER) {
      this.EMPTY_PARTNER = EMPTY_PARTNER;
    }

    @Override
    public void addProposal(Proposal proposal) {}

    @Override
    public void removeProposal(Proposal proposal) {}

    @Override
    public void removeAllProposals() {}

    @Override
    public boolean havePartner() {
      return false;
    }

    @Override
    public void clearPartner() {}

    @Override
    public boolean containsProposalOf(MargaretPlayer margaretPlayerImpl) {
      return false;
    }

    @Override
    public void setPartner(Partner partner) {}

    @Override
    public void setGender(Gender gender) {}

    @Override
    public void setCurrentProposal(Proposal proposal) {}

    @Override
    public void clearCurrentProposal() {}

    @Override
    public void toggleSetting(EnumSettings setting) {}

    @Override
    public void toggleSetting(String setting) {}

    @Override
    public boolean isSetting(EnumSettings setting) {
      return false;
    }

    @Override
    public boolean isSetting(String setting) {
      return false;
    }

    @Override
    public boolean isEmpty() {
      return true;
    }

    @Override
    public CacheSet<Proposal> getProposals() {
      return EMPTY_PROPOSALS;
    }

    @Override
    public Gender getGender() {
      return Genders.getGender("unknown");
    }

    @Override
    public String getName() {
      return "EMPTY_MARGARET_PLAYER";
    }

    @Override
    public UUID getUniqueId() {
      return null;
    }

    @Override
    public Partner getPartner() {
      return EMPTY_PARTNER;
    }

    @Override
    public MargaretPlayerMeta getSettings() {
      return EMPTY_MARGARET_PLAYER.getSettings();
    }

    @Override
    public Proposal getCurrentProposal() {
      return EMPTY_PROPOSAL;
    }
  }

  private static class EmptyPartner implements Partner {
    private final PartnerPermissionSet PERMISSION_SET = new PartnerPermissionSet();

    @Override
    public String getId() {
      return "--------";
    }

    @Override
    public UUID getUuid1() {
      return null;
    }

    @Override
    public UUID getUuid2() {
      return null;
    }

    @Override
    public PartnerPermissionSet getPermissions() {
      return PERMISSION_SET;
    }

    @Override
    public void setRelation(String relation) {}

    @Override
    public boolean hasPermission(PartnerPermission perm) {
      return false;
    }

    @Override
    public boolean isEmpty() {
      return true;
    }

    @Override
    public String getRelation() {
      return "NULL";
    }

    @Override
    public HomeList getHomeList() {
      return null;
    }
  }

  public static class EmptyProposal implements Proposal {

    @Override
    public MargaretPlayer getSender() {
      return getEmptyMargaretPlayer();
    }

    @Override
    public MargaretPlayer getReceiver() {
      return getEmptyMargaretPlayer();
    }

    @Override
    public String getRelation() {
      return "unknown";
    }

    @Override
    public boolean isEmpty() {
      return true;
    }
  }

  public static class EmptyCacheSet<T> implements CacheSet<T> {

    @Override
    public Long getDateOf(Object key) {
      return 0L;
    }

    @Override
    public Long getExpireOf(Object key) {
      return 0L;
    }

    @Override
    public boolean containsAsMap(Object key) {
      return false;
    }

    @Override
    public void addAll(Map<T, Long> toAdd) {}

    @Override
    public void removeAll() {}

    @Override
    public Set<T> values() {
      return Collections.emptySet();
    }

    @Override
    public Set<T> valuesByDate() {
      return Collections.emptySet();
    }

    @Override
    public long mapSize() {
      return 0;
    }

    @Override
    public Cache<T, Long> asCache() {
      return null;
    }

    @Override
    public ConcurrentMap<T, Long> asMap() {
      return new ConcurrentHashMap<>(Collections.emptyMap());
    }

    @Override
    public int size() {
      return 0;
    }

    @Override
    public boolean isEmpty() {
      return true;
    }

    @Override
    public boolean contains(Object o) {
      return false;
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
      return Collections.emptyIterator();
    }

    @NotNull
    @Override
    public Object[] toArray() {
      return new Object[0];
    }

    @NotNull
    @Override
    public <T2> T2[] toArray(@NotNull T2[] ts) {
      return ts;
    }

    @Override
    public boolean remove(Object o) {
      return false;
    }

    @Override
    public boolean containsAll(@NotNull Collection<?> collection) {
      return false;
    }

    @Override
    public boolean addAll(@NotNull Collection<? extends T> collection) {
      return false;
    }

    @Override
    public boolean retainAll(@NotNull Collection<?> collection) {
      return false;
    }

    @Override
    public boolean removeAll(@NotNull Collection<?> collection) {
      return false;
    }

    @Override
    public void clear() {}

    @Override
    public boolean add(Object o) {
      return false;
    }
  }

  public static class EmptyGender implements Gender {

    @Override
    public String getFormalName() {
      return "";
    }

    @Override
    public String getRealName() {
      return "";
    }

    @Override
    public ChatColor getChatColor() {
      return ChatColor.WHITE;
    }

    @Override
    public String getPrefix() {
      return "";
    }

    @Override
    public String getFormalNameColorized() {
      return "";
    }

    @Override
    public String getPrefixColorized() {
      return "";
    }

    @Override
    public boolean isEmpty() {
      return true;
    }
  }

  public static class EmptyHome implements Home {
    private final Location LOCATION = new Location(
        Bukkit.getWorlds().get(0),
        0, 0 , 0);

    @Override
    public void setAlias(String alias) {}

    @Override
    public boolean hasAlias() {
      return false;
    }

    @Override
    public Location getLocation() {
      return LOCATION;
    }

    @Override
    public String getId() {
      return "";
    }

    @Override
    public String getAlias() {
      return "";
    }

    @Override
    public void teleport(Player player) {}

    @Override
    public boolean isEmpty() {
      return true;
    }
  }
}
