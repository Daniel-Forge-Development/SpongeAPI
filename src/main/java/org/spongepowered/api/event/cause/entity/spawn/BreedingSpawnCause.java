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
package org.spongepowered.api.event.cause.entity.spawn;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.Entity;

/**
 * A {@link SpawnCause} that involves two entities that "mate" to breed a new
 * {@link Entity}.
 */
public interface BreedingSpawnCause extends EntitySpawnCause {

    /**
     * Creates a new {@link Builder builder} for building a
     * {@link BreedingSpawnCause}.
     *
     * @return A new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Gets the secondary {@link Entity} considered to be the "mate"
     * with the {@link #getEntity()}.
     *
     * @return The mate
     */
    Entity getMate();

    interface Builder extends EntitySpawnCauseBuilder<BreedingSpawnCause, Builder> {

        /**
         * Sets the secondary {@link Entity} that is considered the "mate".
         *
         * @param entity The mate entity
         * @return This builder, for chaining
         */
        Builder mate(Entity entity);

    }
}
