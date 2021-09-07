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

import net.kyori.adventure.text.Component;
import org.spongepowered.api.Engine;
import org.spongepowered.api.util.Nameable;

/**
 * The physical representation of that are loaded
 * on an {@link Engine}.
 *
 * @see <a href=http://minecraft.gamepedia.com/Resource_pack#Contents>
 * Minecraft Wiki/Resource Packs
 * </a>
 */
public interface Pack extends Nameable, AutoCloseable {

    /**
     * @return The {@link PackType type}
     */
    PackType type();

    /**
     * @return The {@link PackContentsContainer contents}
     */
    PackContentsContainer contents();

    /**
     * @return The {@link Component title}
     */
    Component title();

    /**
     * @return The {@link Component description}
     * @see PackContentsMetadata#description()
     */
    Component description();

    /**
     * @return The {@link PackVersion version}
     */
    PackVersion version();

    /**
     * @return The {@link PackOrder order}
     */
    PackOrder order();

    /**
     * @return True if this pack will always be enabled, false otherwise
     */
    boolean isForced();

    /**
     * @return True if this pack will always have the same {@link PackOrder order}, false otherwise
     * @see #order()
     */
    boolean isLocked();
}
