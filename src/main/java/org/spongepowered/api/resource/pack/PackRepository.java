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
package org.spongepowered.api.resource.pack;

import org.spongepowered.plugin.PluginContainer;

import java.util.Collection;
import java.util.Optional;

/**
 * The pack list keeps track of all the known {@link Pack}s and their
 * status.
 */
public interface PackRepository {

    /**
     * Gets the collection of all the known {@link Pack}s. The result is
     * immutable.
     *
     * @return All the packs
     */
    Collection<Pack> all();

    /**
     * Gets the collection of {@link Pack}s which are not enabled.
     *
     * @return The disabled packs
     */
    Collection<Pack> disabled();

    /**
     * Gets the collection of {@link Pack}s which are enabled.
     *
     * @return The enabled packs
     */
    Collection<Pack> enabled();

    /**
     * Gets a {@link Pack} with the given name. If none exists,
     * {@link Optional#empty()} is returned.
     *
     * @param name The name of the pack
     * @return The pack
     */
    Optional<Pack> pack(String name);

    /**
     * Retrieves a {@link PluginContainer plugin's} {@link Pack pack}.
     *
     * @param container The container
     * @return The pack
     */
    Pack pack(PluginContainer container);
}
