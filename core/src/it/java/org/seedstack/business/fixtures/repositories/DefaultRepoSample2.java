/**
 * Copyright (c) 2013-2016, The SeedStack authors <http://seedstack.org>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.seedstack.business.fixtures.repositories;

import com.google.inject.assistedinject.Assisted;
import org.seedstack.business.domain.AggregateRoot;
import org.seedstack.business.domain.BaseRepository;
import org.seedstack.business.spi.GenericImplementation;

import javax.inject.Inject;
import javax.inject.Named;


@GenericImplementation
@Named("mock")
public class DefaultRepoSample2<A extends AggregateRoot<K>, K> extends BaseRepository<A, K> {

    @Inject
    public DefaultRepoSample2(@Assisted Object[] genericClasses) {
        super((Class) genericClasses[0], (Class) genericClasses[1]);
    }

    @Override
    public A load(K id) {
        return null;
    }

    @Override
    public boolean exists(K id) {
        return false;
    }

    @Override
    public long count() {
        return 0L;
    }

    @Override
    public void clear() {
    }

    @Override
    public void delete(K id) {
    }

    @Override
    public void delete(A a) {
    }

    @Override
    public void persist(A a) {
    }

    @Override
    public A save(A a) {
        return null;
    }
}
