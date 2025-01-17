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
package org.spongepowered.api.scoreboard;

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;
import org.spongepowered.api.registry.RegistryTypes;

/**
 * Visibility names which cause nametags or death messages to be displayed
 * differently to players on a team.
 */
@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.GAME)
public final class Visibilities {

    // @formatter:off

    // SORTFIELDS:ON

    /**
     * Death messages or nametags are always visible.
     *
     * <p>This is the default value.</p>
     */
    public static final DefaultedRegistryReference<Visibility> ALWAYS = Visibilities.key(ResourceKey.sponge("always"));

    /**
     * Death messages or nametags for members of other teams will not be
     * visible, but death messages or nametags for members of the same team
     * will be visible.
     */
    public static final DefaultedRegistryReference<Visibility> HIDE_FOR_OTHER_TEAMS = Visibilities.key(ResourceKey.sponge("hide_for_other_teams"));

    /**
     * Death messages or nametags for members of other teams will be
     * visible, but death messages or nametags for members of the same team
     * will not be visible.
     */
    public static final DefaultedRegistryReference<Visibility> HIDE_FOR_OWN_TEAM = Visibilities.key(ResourceKey.sponge("hide_for_own_team"));

    /**
     * Death messages or nametags are never visible.
     */
    public static final DefaultedRegistryReference<Visibility> NEVER = Visibilities.key(ResourceKey.sponge("never"));

    // SORTFIELDS:OFF

    // @formatter:on

    private Visibilities() {
    }

    private static DefaultedRegistryReference<Visibility> key(final ResourceKey location) {
        return RegistryKey.of(RegistryTypes.VISIBILITY, location).asDefaultedReference(Sponge::game);
    }
}
