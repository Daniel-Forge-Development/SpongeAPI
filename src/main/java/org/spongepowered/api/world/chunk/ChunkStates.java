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
package org.spongepowered.api.world.chunk;

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.entity.BlockEntity;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;
import org.spongepowered.api.registry.RegistryTypes;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.WorldLike;
import org.spongepowered.api.world.biome.Biome;

@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.GAME)
public final class ChunkStates {

    // @formatter:off
    // SORTFIELDS:ON
    /**
     * A {@link Chunk} that is having its {@link Biome biomes}
     * assigned.
     */
    public static final DefaultedRegistryReference<ChunkState> BIOMES = ChunkStates.key(ResourceKey.minecraft("biomes"));

    /**
     * A {@link Chunk} that is being "carved out" for general terrain
     * features that require things like "caves" or "canyons".
     */
    public static final DefaultedRegistryReference<ChunkState> CARVERS = ChunkStates.key(ResourceKey.minecraft("carvers"));

    /**
     * Identifies a {@link Chunk} that is considered empty. The method
     * {@link Chunk#isEmpty()} would return {@code true}. Identifies the
     * chunk has nothing contained within it, but can be used as a dummy chunk
     * in some regards for world generation.
     */
    public static final DefaultedRegistryReference<ChunkState> EMPTY = ChunkStates.key(ResourceKey.minecraft("empty"));

    /**
     * A {@link Chunk} has been carved out, and is now being decorated with
     * features, such as leaves and tall grass.
     */
    public static final DefaultedRegistryReference<ChunkState> FEATURES = ChunkStates.key(ResourceKey.minecraft("features"));

    /**
     * State for a {@link Chunk} marking it being used by a world, and not
     * in the process of either world generation, or deserialization from
     * storage. Only {@link WorldChunk}s should provide this state, other
     * {@link Chunk}s would be invalid with this state.
     */
    public static final DefaultedRegistryReference<ChunkState> FULL = ChunkStates.key(ResourceKey.minecraft("full"));

    /**
     * A {@link Chunk} state that is "cleaning" up remnant objects of a
     * chunk in process of world generation. Generally, height maps are being
     * calculated at this point as entity spawning can affect block placement.
     */
    public static final DefaultedRegistryReference<ChunkState> HEIGHTMAPS = ChunkStates.key(ResourceKey.minecraft("heightmaps"));

    /**
     * A {@link Chunk} state that has yet been processed with lighting in
     * respects to the {@link WorldLike} that contains it. This is the second
     * to last step in the world generation pipeline for a chunk to be marked
     * as ready for being added to a {@link World}.
     */
    public static final DefaultedRegistryReference<ChunkState> LIGHT = ChunkStates.key(ResourceKey.minecraft("light"));

    /**
     * A {@link Chunk} state that is being "carved" with liquid cave
     * features, such as underwater ravines, underwater caves, etc.
     */
    public static final DefaultedRegistryReference<ChunkState> LIQUID_CARVERS = ChunkStates.key(ResourceKey.minecraft("liquid_carvers"));

    /**
     * A {@link Chunk} where the {@link BlockState block states} are being
     * set and structure locations are set.
     */
    public static final DefaultedRegistryReference<ChunkState> NOISE = ChunkStates.key(ResourceKey.minecraft("noise"));

    /**
     * A {@link Chunk} state that is being used for entity spawning.
     * Generally requires that the neighboring chunks are adequately populated,
     * and requires that this chunk has proper lighting, for mob placement
     * logic.
     */
    public static final DefaultedRegistryReference<ChunkState> SPAWN = ChunkStates.key(ResourceKey.minecraft("spawn"));

    /**
     * A {@link Chunk} where final validity checks are being performed on
     * structures that are primed to be placed in the chunk.
     */
    public static final DefaultedRegistryReference<ChunkState> STRUCTURE_REFERENCES = ChunkStates.key(ResourceKey.minecraft("structure_references"));

    /**
     * A {@link Chunk} where the structures to be placed in the chunk are
     * being determined and primed for placement.
     */
    public static final DefaultedRegistryReference<ChunkState> STRUCTURE_STARTS = ChunkStates.key(ResourceKey.minecraft("structure_starts"));

    /**
     * A {@link Chunk} that is at this state means that it is being
     * generated with a "base" layer of terrain.
     *
     * <p>The chunk should not have any {@link Entity} instances or
     * {@link BlockEntity} instances and may have a valid {@link WorldLike}
     * used for world generation.</p>
     */
    public static final DefaultedRegistryReference<ChunkState> SURFACE = ChunkStates.key(ResourceKey.minecraft("surface"));

    // SORTFIELDS:OFF
    // @formatter:on
    private ChunkStates() {
    }

    private static DefaultedRegistryReference<ChunkState> key(final ResourceKey location) {
        return RegistryKey.of(RegistryTypes.CHUNK_STATE, location).asDefaultedReference(Sponge::game);
    }
}
