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
package org.spongepowered.api.resource;

import org.spongepowered.api.data.persistence.DataFormat;
import org.spongepowered.api.data.persistence.DataFormats;
import org.spongepowered.api.data.persistence.DataView;
import org.spongepowered.api.resource.metadata.MetadataSection;
import org.spongepowered.api.resource.pack.Pack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * A resource can represent any kind of loaded data. It can be a file on the
 * filesystem, a network location, or even generated at runtime. Use
 * {@link #inputStream()} to load the data held by a resource.
 */
public interface Resource extends AutoCloseable {

    /**
     * @return The {@link Pack pack}
     */
    Pack pack();

    /**
     * @return The {@link ResourcePath path}
     */
    ResourcePath path();

    /**
     * Returns the {@link InputStream} of this resource. Multiple calls to this
     * method will not return a new object. To get a new object, get a new
     * resource.
     *
     * @return The input stream
     */
    InputStream inputStream();

    /**
     * Gets the specified metadata section for this resource or
     * {@link Optional#empty()} if it has no metadata.
     *
     * @param section The section serializer
     * @return The metadata or empty if it doesn't exist
     */
    <T> Optional<T> metadata(MetadataSection<T> section);

    /**
     * Creates a new {@link BufferedReader} from this resource's
     * {@link InputStream}.
     *
     * @param charset The charset to use, usually {@link StandardCharsets#UTF_8 utf-8}
     * @return The BufferedReader
     */
    BufferedReader newReader(Charset charset);

    /**
     * Reads the resource as text.
     *
     * @param charset The charset of the text, usually {@link StandardCharsets#UTF_8 utf-8}
     * @return The text of the resource
     * @throws IOException If an I/O error occurs
     * @see StandardCharsets
     */
    String readString(Charset charset) throws IOException;

    /**
     * Reads all the bytes from this resource and returns them in a byte array.
     *
     * @return The toBytes of the resource
     * @throws IOException If an I/O error occurs
     */
    byte[] readBytes() throws IOException;

    /**
     * Reads the resource and returns a {@link DataView} which corresponds to
     * the appropriate {@link DataFormat}.
     *
     * @param format The data format to use
     * @return The data view
     * @throws IOException If an I/O error occurs
     * @see DataFormats
     */
    DataView readDataView(DataFormat format) throws IOException;

    /**
     * Reads the resource as text and returns a stream of lines.
     *
     * <p>Just like {@link BufferedReader#lines()}, the stream will wrap any
     * {@link IOException} thrown in an {@link java.io.UncheckedIOException}.
     * </p>
     *
     * @param charset The charset of the text, usually {@link StandardCharsets#UTF_8 utf-8}
     * @return A stream of readLines of the resource
     * @see StandardCharsets
     * @see BufferedReader#lines()
     */
    Stream<String> lines(Charset charset);

}
