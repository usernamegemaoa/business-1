/**
 * Copyright (c) 2013-2015 by The SeedStack authors. All rights reserved.
 *
 * This file is part of SeedStack, An enterprise-oriented full development stack.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.seedstack.business.fixtures.domain.discount;

import org.seedstack.business.core.domain.base.BaseFactory;

/**
 *
 * 
 * @author epo.jemba@ext.mpsa.com
 *
 */
public class DiscountFactoryBase  extends BaseFactory<Discount>  implements DiscountFactory {

	@Override
	public Discount createNewActivation(String id, String description) {
		
		Discount discount = new Discount(id);
		
		discount.setDescription(description);
		
		return discount;
	}

}