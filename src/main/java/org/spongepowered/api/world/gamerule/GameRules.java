/*
 * This file is part of SpongeAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered <https://www.spongepowered.org>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.spongepowered.api.world.gamerule;

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.block.entity.CommandBlock;
import org.spongepowered.api.entity.living.Agent;
import org.spongepowered.api.entity.living.Bat;
import org.spongepowered.api.entity.living.animal.Rabbit;
import org.spongepowered.api.entity.living.animal.Sheep;
import org.spongepowered.api.entity.living.golem.SnowGolem;
import org.spongepowered.api.entity.living.monster.Creeper;
import org.spongepowered.api.entity.living.monster.Enderman;
import org.spongepowered.api.entity.living.monster.Ghast;
import org.spongepowered.api.entity.living.monster.Patroller;
import org.spongepowered.api.entity.living.monster.Phantom;
import org.spongepowered.api.entity.living.monster.Silverfish;
import org.spongepowered.api.entity.living.monster.boss.Wither;
import org.spongepowered.api.entity.living.monster.boss.dragon.EnderDragon;
import org.spongepowered.api.entity.living.monster.skeleton.Skeleton;
import org.spongepowered.api.entity.living.monster.zombie.Zombie;
import org.spongepowered.api.entity.living.monster.zombie.ZombifiedPiglin;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.living.player.gamemode.GameModes;
import org.spongepowered.api.entity.living.trader.Villager;
import org.spongepowered.api.entity.living.trader.WanderingTrader;
import org.spongepowered.api.entity.vehicle.Boat;
import org.spongepowered.api.entity.vehicle.minecart.MinecartLike;
import org.spongepowered.api.raid.Raid;
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;
import org.spongepowered.api.registry.RegistryTypes;

/**
 * An enumeration of all the possible game rules in vanilla minecraft.
 */
@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.GAME)
public final class GameRules {

    // @formatter:off

    // SORTFIELDS:ON

    /**
     * If advancements should be announced to the server.
     *
     * <p>This is a boolean game rule, with a default value of {@code true}.</p>
     */
    public static final DefaultedRegistryReference<GameRule<Boolean>> ANNOUNCE_ADVANCEMENTS = GameRules.key(ResourceKey.sponge("announce_advancements"));

    /**
     * Whether {@link CommandBlock}s should notify admins when
     * they perform commands.
     *
     * <p>This is a boolean game rule, with a default value of {@code true}.</p>
     */
    public static final DefaultedRegistryReference<GameRule<Boolean>> COMMAND_BLOCK_OUTPUT = GameRules.key(ResourceKey.sponge("command_block_output"));

    /**
     * Whether the server should skip checking player speed when
     * the player is wearing elytra.
     *
     * <p>This is a boolean game rule, with a default value of
     * {@code false}.</p>
     */
    public static final DefaultedRegistryReference<GameRule<Boolean>> DISABLE_ELYTRA_MOVEMENT_CHECK = GameRules.key(ResourceKey.sponge("disable_elytra_movement_check"));

    /**
     * Whether {@link Raid}s are disabled.
     *
     * <p>If the value of this game rule is {@code true}, all {@link Raid}s will stop.
     *
     * <p>This is a boolean game rule, with a default value of
     * {@code false}.</p>
     */
    public static final DefaultedRegistryReference<GameRule<Boolean>> DISABLE_RAIDS = GameRules.key(ResourceKey.sponge("disable_raids"));

    /**
     * Whether the day-night cycle and moon phases progress.
     *
     * <p>This is a boolean game rule, with a default value of
     * {@code true}.</p>
     */
    public static final DefaultedRegistryReference<GameRule<Boolean>> DO_DAYLIGHT_CYCLE = GameRules.key(ResourceKey.sponge("do_daylight_cycle"));

    /**
     * Whether entities that are not mobs should have drops.
     *
     * <p>This is a boolean game rule, with a default value of
     * {@code true}.</p>
     */
    public static final DefaultedRegistryReference<GameRule<Boolean>> DO_ENTITY_DROPS = GameRules.key(ResourceKey.sponge("do_entity_drops"));

    /**
     * Whether fire should spread and naturally extinguish.
     *
     * <p>This is a boolean game rule, with a default value of
     * {@code true}.</p>
     */
    public static final DefaultedRegistryReference<GameRule<Boolean>> DO_FIRE_TICK = GameRules.key(ResourceKey.sponge("do_fire_tick"));

    /**
     * Whether {@link Phantom}s can spawn in the night-time.
     *
     * <p>This is a boolean game rule, with a default value of
     * {@code true}.</p>
     */
    public static final DefaultedRegistryReference<GameRule<Boolean>> DO_INSOMNIA = GameRules.key(ResourceKey.sponge("do_insomnia"));

    /**
     * Whether {@link Player}s should respawn immediately without showing the death screen.
     *
     * <p>This is a boolean game rule, with a default value of
     * {@code true}.</p>
     */
    public static final DefaultedRegistryReference<GameRule<Boolean>> DO_IMMEDIATE_RESPAWN = GameRules.key(ResourceKey.sponge("do_immediate_respawn"));

    /**
     * Whether {@link Player}s can only craft recipes they have unlocked.
     *
     * <p>This is a boolean game rule, with a default value of
     * {@code false}.</p>
     */
    public static final DefaultedRegistryReference<GameRule<Boolean>> DO_LIMITED_CRAFTING = GameRules.key(ResourceKey.sponge("do_limited_crafting"));

    /**
     * Whether {@link Agent}s should drop items.
     *
     * <p>This is a boolean game rule, with a default value of {@code true}.</p>
     */
    public static final DefaultedRegistryReference<GameRule<Boolean>> DO_MOB_LOOT = GameRules.key(ResourceKey.sponge("do_mob_loot"));

    /**
     * Whether {@link Agent}s should naturally spawn.
     *
     * <p>This is a boolean game rule, with a default value of {@code true}.</p>
     */
    public static final DefaultedRegistryReference<GameRule<Boolean>> DO_MOB_SPAWNING = GameRules.key(ResourceKey.sponge("do_mob_spawning"));

    /**
     * Whether {@link Patroller patrollers} will go out on patrol (typically in a {@link Raid}.
     *
     * <p>This is a boolean game rule, with a default value of {@code true}.</p>
     */
    public static final DefaultedRegistryReference<GameRule<Boolean>> DO_PATROL_SPAWNING = GameRules.key(ResourceKey.sponge("do_patrol_spawning"));

    /**
     * Whether blocks should have drops.
     *
     * <p>This is a boolean game rule, with a default value of {@code true}.</p>
     */
    public static final DefaultedRegistryReference<GameRule<Boolean>> DO_TILE_DROPS = GameRules.key(ResourceKey.sponge("do_tile_drops"));

    /**
     * Whether {@link WanderingTrader traders} will naturally spawn.
     *
     * <p>This is a boolean game rule, with a default value of {@code true}.</p>
     */
    public static final DefaultedRegistryReference<GameRule<Boolean>> DO_TRADER_SPAWNING = GameRules.key(ResourceKey.sponge("do_trader_spawning"));

    /**
     * Whether the weather will change.
     *
     * <p>This is a boolean game rule, with a default value of {@code true}.</p>
     */
    public static final DefaultedRegistryReference<GameRule<Boolean>> DO_WEATHER_CYCLE = GameRules.key(ResourceKey.sponge("do_weather_cycle"));

    /**
     * Whether entities should take drowning damage.
     *
     * <p>This is a boolean game rule, with a default value of
     * {@code true}.</p>
     */
    public static final DefaultedRegistryReference<GameRule<Boolean>> DROWNING_DAMAGE = GameRules.key(ResourceKey.sponge("drowning_damage"));

    /**
     * Whether entities should take fall damage.
     *
     * <p>This is a boolean game rule, with a default value of
     * {@code true}.</p>
     */
    public static final DefaultedRegistryReference<GameRule<Boolean>> FALL_DAMAGE = GameRules.key(ResourceKey.sponge("fall_damage"));

    /**
     * Whether entities should take fire damage.
     *
     * <p>This is a boolean game rule, with a default value of
     * {@code true}.</p>
     */
    public static final DefaultedRegistryReference<GameRule<Boolean>> FIRE_DAMAGE = GameRules.key(ResourceKey.sponge("fire_damage"));

    /**
     * Makes angered neutral mobs stop being angry when the targeted player dies nearby.
     *
     * <p>This is a boolean game rule, with a default value of
     * {@code true}.</p>
     */
    public static final DefaultedRegistryReference<GameRule<Boolean>> FORGIVE_DEAD_PLAYERS = GameRules.key(ResourceKey.sponge("forgive_dead_players"));

    /**
     * Whether {@link Player}s should keep items in their inventory
     * after death.
     *
     * <p>This is a boolean game rule, with a default value of
     * {@code false}.</p>
     */
    public static final DefaultedRegistryReference<GameRule<Boolean>> KEEP_INVENTORY = GameRules.key(ResourceKey.sponge("keep_inventory"));

    /**
     * Whether to log admin commands to server log.
     *
     * <p>This is a boolean game rule, with a default value of
     * {@code true}.</p>
     */
    public static final DefaultedRegistryReference<GameRule<Boolean>> LOG_ADMIN_COMMANDS = GameRules.key(ResourceKey.sponge("log_admin_commands"));

    /**
     * The total number of {@link BlockTypes#CHAIN_COMMAND_BLOCK chain command
     * blocks} that can run during a single tick.
     *
     * <p>This is a numerical game rule, with a default value
     * of {@code 65536}.</p>
     */
    public static final DefaultedRegistryReference<GameRule<Integer>> MAX_COMMAND_CHAIN_LENGTH = GameRules.key(ResourceKey.sponge("max_command_chain_length"));

    /**
     * The maximum number of other pushable entities a mob or player can push,
     * before taking 3 suffocation damage per half-second.
     *
     * <p>Damage affects {@link GameModes#SURVIVAL survival mode} or
     * {@link GameModes#ADVENTURE adventure mode} {@link Player}s, and all
     * mobs but bats. Pushable entities include non-spectator-mode
     * {@link Player}, any mob except {@link Bat}s, as well as
     * {@link Boat}s and {@link MinecartLike}.</p>
     *
     * <p>Setting to {@code 0} disables the rule.</p>
     *
     * <p>This is a numerical game rule, with a default value of {@code 24}.</p>
     */
    public static final DefaultedRegistryReference<GameRule<Integer>> MAX_ENTITY_CRAMMING = GameRules.key(ResourceKey.sponge("max_entity_cramming"));

    /**
     * Whether {@link Agent}s should be able to change blocks, and whether
     * {@link Agent}s can pick up items.
     *
     * <p>In vanilla Minecraft, the following entities can change blocks when
     * this game rule is {@code true}:
     * <ul>
     *     <li>{@link Creeper}</li>
     *     <li>{@link Zombie}</li>
     *     <li>{@link Enderman}</li>
     *     <li>{@link Ghast}</li>
     *     <li>{@link Wither}</li>
     *     <li>{@link EnderDragon}</li>
     *     <li>{@link Rabbit}</li>
     *     <li>{@link Sheep}</li>
     *     <li>{@link Villager}</li>
     *     <li>{@link SnowGolem}</li>
     *     <li>{@link Silverfish}</li>
     * </ul>
     *
     * <p>In vanilla Minecraft, the following entities can pick up items when
     * this game rule is {@code true}:
     * <ul>
     *     <li>{@link Villager}</li>
     *     <li>{@link Zombie}</li>
     *     <li>{@link Skeleton}</li>
     *     <li>{@link ZombifiedPiglin}</li>
     * </ul>
     *
     * <p>This is a boolean game rule, with a default value of {@code true}.</p>
     */
    public static final DefaultedRegistryReference<GameRule<Boolean>> MOB_GRIEFING = GameRules.key(ResourceKey.sponge("mob_griefing"));

    /**
     * Whether {@link Player}s can regenerate health naturally if their
     * hunger is full enough (doesn't affect external healing, such as
     * golden apples, the Regeneration effect, etc.).
     *
     * <p>This is a boolean game rule, with a default value of {@code true}.</p>
     */
    public static final DefaultedRegistryReference<GameRule<Boolean>> NATURAL_REGENERATION = GameRules.key(ResourceKey.sponge("natural_regeneration"));

    /**
     * How often a random block tick occurs (such as plant growth,
     * leaf decay, etc.) per chunk section per game tick.
     *
     * <p>0 will disable random ticks, higher numbers will increase random
     * ticks</p>
     *
     * <p>This is a numerical game rule, with a default value of {@code 3}.</p>
     */
    public static final DefaultedRegistryReference<GameRule<Integer>> RANDOM_TICK_SPEED = GameRules.key(ResourceKey.sponge("random_tick_speed"));

    /**
     * Whether the debug screen shows all or reduced information.
     *
     * <p>This is a boolean game rule, with a default value of
     * {@code false}.</p>
     */
    public static final DefaultedRegistryReference<GameRule<Boolean>> REDUCED_DEBUG_INFO = GameRules.key(ResourceKey.sponge("reduced_debug_info"));

    /**
     * Whether the feedback from commands executed by a {@link Player}
     * should show up in chat.
     *
     * <p>This game rule affects the default behavior of whether
     * {@link CommandBlock}s store their output text.</p>
     *
     * <p>This is a boolean game rule, with a default value of {@code true}.</p>
     */
    public static final DefaultedRegistryReference<GameRule<Boolean>> SEND_COMMAND_FEEDBACK = GameRules.key(ResourceKey.sponge("send_command_feedback"));

    /**
     * Whether a message appears in chat when a {@link Player} dies.
     *
     * <p>This is a boolean game rule, with a default value of {@code true}.</p>
     */
    public static final DefaultedRegistryReference<GameRule<Boolean>> SHOW_DEATH_MESSAGES = GameRules.key(ResourceKey.sponge("show_death_messages"));

    /**
     * The number of blocks outward from the world spawn coordinates
     * that a player will spawn in when first joining a server or when
     * dying without a spawn point.
     *
     * <p>This is a numerical game rule, with a default value of {@code 10}.</p>
     */
    public static final DefaultedRegistryReference<GameRule<Integer>> SPAWN_RADIUS = GameRules.key(ResourceKey.sponge("spawn_radius"));

    /**
     * Whether players in {@link GameModes#SPECTATOR spectator mode} can
     * generate chunks.
     *
     * <p>This is a boolean game rule, with a default value of {@code true}.</p>
     */
    public static final DefaultedRegistryReference<GameRule<Boolean>> SPECTATORS_GENERATE_CHUNKS = GameRules.key(ResourceKey.sponge("spectators_generate_chunks"));

    /**
     * Makes angered neutral mobs attack any nearby player, not just the player that angered them.
     *
     * <p>This is a boolean game rule, with a default value of
     * {@code false}.</p>
     */
    public static final DefaultedRegistryReference<GameRule<Boolean>> UNIVERSAL_ANGER = GameRules.key(ResourceKey.sponge("universal_anger"));

    // SORTFIELDS:OFF

    // @formatter:on

    private GameRules() {
    }

    private static <T> DefaultedRegistryReference<GameRule<T>> key(final ResourceKey location) {
        return RegistryKey.of(RegistryTypes.GAME_RULE, location).asDefaultedReference(Sponge::game);
    }
}
