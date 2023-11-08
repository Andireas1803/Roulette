package me.matsubara.roulette.manager;

import lombok.Getter;
import me.matsubara.roulette.RoulettePlugin;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Getter
public final class PlayerManager {

    private final RoulettePlugin plugin;
    private final Map<UUID, Integer> players;

    public PlayerManager(RoulettePlugin plugin) {
        this.plugin = plugin;
        this.players = new HashMap<>();

    }

    public void addUse(@NotNull UUID uuid) {
        int currentUses = this.players.getOrDefault(uuid, 0);
        this.players.put(uuid, currentUses + 1);
    }

    public void deleteUse(@NotNull UUID uuid) {
        this.players.remove(uuid);
    }

    public int getByUniqueId(UUID uuid) {
        return this.players.getOrDefault(uuid ,0);
    }
}