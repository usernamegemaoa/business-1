/**
 * Copyright (c) 2013-2015 by The SeedStack authors. All rights reserved.
 *
 * This file is part of SeedStack, An enterprise-oriented full development stack.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.seedstack.business.api;

import com.google.common.collect.Lists;
import com.google.inject.util.Types;
import org.assertj.core.api.Assertions;
import org.javatuples.*;
import org.junit.Test;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Tests the helper class {@link org.seedstack.business.api.Tuples}.
 *
 * @author Pierre Thirouin <pierre.thirouin@ext.mpsa.com>
 */
public class TuplesTest {

    @Test
    public void testCreateTupleFromVarArgs() {

        Pair<Integer, String> pair = Tuples.create(10, "foo");
        Assertions.assertThat((Iterable<?>) pair).isEqualTo(new Pair<Integer, String>(10, "foo"));

        Tuple tuple = Tuples.create(String.class, Long.class);
        Assertions.assertThat((Iterable<?>) tuple).isInstanceOf(Pair.class);
        Assertions.assertThat(tuple.containsAll(String.class, Long.class)).isTrue();
        Assertions.assertThat(tuple.getSize()).isEqualTo(2);

        tuple = Tuples.create(String.class, Long.class, Float.class);
        Assertions.assertThat((Iterable<?>) tuple).isInstanceOf(Triplet.class);
    }

    @Test
    public void testCreateTupleFromList() {
        List<?> classes = Lists.<Class<?>>newArrayList(String.class, Long.class);
        Tuple tuple = Tuples.create(classes);

        Assertions.assertThat((Iterable<?>) tuple).isInstanceOf(Pair.class);
        Assertions.assertThat(tuple.containsAll(String.class, Long.class)).isTrue();
        Assertions.assertThat(tuple.getSize()).isEqualTo(2);
    }

    @Test
    public void testClassOfTupleFromList() {
        List<Class<?>> classes = new ArrayList<Class<?>>();
        classes.add(String.class);
        classes.add(Long.class);

        Class<?> type = Tuples.classOfTuple(classes);
        Assertions.assertThat(type).isEqualTo(Pair.class);
    }

    @Test
    public void testClassOfTuple() {
        Class<?> type = Tuples.classOfTuple(String.class);
        Assertions.assertThat(type).isEqualTo(Unit.class);

        type = Tuples.classOfTuple(String.class, Integer.class);
        Assertions.assertThat(type).isEqualTo(Pair.class);

        type = Tuples.classOfTuple(String.class, Integer.class, Long.class);
        Assertions.assertThat(type).isEqualTo(Triplet.class);

        type = Tuples.classOfTuple(String.class, Integer.class, Long.class, Float.class);
        Assertions.assertThat(type).isEqualTo(Quartet.class);

        type = Tuples.classOfTuple(String.class, Integer.class, Long.class, Float.class, Boolean.class);
        Assertions.assertThat(type).isEqualTo(Quintet.class);

        type = Tuples.classOfTuple(String.class, Integer.class, Long.class, Float.class, Boolean.class, Byte.class);
        Assertions.assertThat(type).isEqualTo(Sextet.class);

        type = Tuples.classOfTuple(String.class, Integer.class, Long.class, Float.class, Boolean.class, Byte.class, Short.class);
        Assertions.assertThat(type).isEqualTo(Septet.class);

        type = Tuples.classOfTuple(String.class, Integer.class, Long.class, Float.class, Boolean.class, Byte.class, Short.class, Double.class);
        Assertions.assertThat(type).isEqualTo(Octet.class);

        type = Tuples.classOfTuple(String.class, Integer.class, Long.class, Float.class, Boolean.class, Byte.class, Short.class, Double.class, Number.class);
        Assertions.assertThat(type).isEqualTo(Ennead.class);

        type = Tuples.classOfTuple(String.class, Integer.class, Long.class, Float.class, Boolean.class, Byte.class, Short.class, Double.class, Number.class, Character.class);
        Assertions.assertThat(type).isEqualTo(Decade.class);
    }

    @Test
    public void testTypeOfTuple() {
        Type type = Tuples.typeOfTuple(String.class, Long.class);
        Assertions.assertThat(type).isEqualTo(Types.newParameterizedType(Pair.class, String.class, Long.class));
    }
}