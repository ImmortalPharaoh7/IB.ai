package com.ibdiscord.data.db.entries.cassowary;

import de.arraying.gravity.data.types.TypeList;
import lombok.AllArgsConstructor;

/**
 * Copyright 2017-2019 Jarred Vardy
 * <p>
 * This file is part of IB.ai.
 * <p>
 * IB.ai is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * IB.ai is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with IB.ai. If not, see http://www.gnu.org/licenses/.
 */
public @AllArgsConstructor final class CassowaryData extends TypeList {

    private final String label;

    @Override
    protected String getUniqueIdentifier() {
        return "cassowary_" + label;
    }

}
