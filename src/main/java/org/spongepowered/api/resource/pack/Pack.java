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

import org.spongepowered.api.resource.Resource;
import org.spongepowered.api.resource.ResourcePath;
import org.spongepowered.api.resource.metadata.MetadataParseException;
import org.spongepowered.api.resource.metadata.MetadataSection;
import org.spongepowered.api.util.Nameable;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

/**
 * A resource pack or data pack can contain several {@link Resource resources}.
 * A pack can contain both assets and data.
 *
 * @see <a href=http://minecraft.gamepedia.com/Resource_pack#Contents>
 * Minecraft Wiki/Resource Packs
 * </a>
 */
public interface Pack extends Nameable, Closeable {

    /**
     * Gets the {@link PackInformation information}.
     *
     * @return The information
     */
    PackInformation information();

    /**
     * Gets a resource from this pack if it exists.
     *
     * @param path The domain named path
     * @return The resource
     * @see PackType
     */
    InputStream newInputStream(ResourcePath path) throws IOException;

    /**
     * Finds all the {@link ResourcePath}s in this pack matching the
     * prefix and filter, and within the given depth.
     *
     * @param namespace The namespace to search
     * @param prefix    The prefix of the path
     * @param depth     The depth to search
     * @param filter    The filter every path must match
     * @return A collection of matching paths
     * @see PackType
     */
    Collection<ResourcePath> find(String namespace, String prefix, int depth, Predicate<String> filter);

    /**
     * Tests if this pack contains an entry at the given {@link ResourcePath}.
     *
     * @param path The resource path
     * @return True if it exists, false if it does not
     * @see PackType
     */
    boolean exists(ResourcePath path);

    /**
     * Gets the namespaces known by this pack.
     *
     * @return The set of namespaces
     */
    Set<String> namespaces();

    /**
     * Gets the metadata of this pack. The {@link MetadataSection} deserializes a
     * section of the pack.mcmeta file in the pack root. If the pack.mcmeta
     * does not contain the query defined in the section,
     * {@link Optional#empty()} is returned.
     *
     * @param section The name metadata section type
     * @return The metadata if it exists
     * @throws IOException        If the data could not be read
     * @throws MetadataParseException If the metadata could not be parsed
     */
    <T> Optional<T> metadata(MetadataSection<T> section) throws IOException;
}
