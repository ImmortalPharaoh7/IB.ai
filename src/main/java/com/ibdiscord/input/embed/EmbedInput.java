/* Copyright 2017-2019 Arraying
 *
 * This file is part of IB.ai.
 *
 * IB.ai is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * IB.ai is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with IB.ai. If not, see http://www.gnu.org/licenses/.
 */

package com.ibdiscord.input.embed;

import com.ibdiscord.command.CommandContext;
import com.ibdiscord.input.Input;
import com.ibdiscord.localisation.ILocalised;
import net.dv8tion.jda.api.EmbedBuilder;

public abstract class EmbedInput implements Input, ILocalised {

    final EmbedBuilder builder;
    Input successor;

    /**
     * Creates the embed input.
     * @param builder The builder.
     */
    EmbedInput(EmbedBuilder builder) {
        this.builder = builder;
    }

    /**
     * Internally offers the input.
     * @param context The context of the input.
     * @return True if the input is accepted, false if it is rejected.
     */
    protected abstract boolean internalOffer(CommandContext context);

    /**
     * Gets the successor.
     * @return The successor.
     */
    @Override
    public final Input getSuccessor() {
        return successor;
    }

    /**
     * Handles the input.
     * @param context The context of the input.
     * @return True if the input is accepted, false if it is rejected.
     */
    @Override
    public final boolean offer(CommandContext context) {
        switch(context.getMessage().getContentRaw().toLowerCase()) {
            case "skip":
                return true;
            case "done":
                successor = new EmbedChannelInput(builder, null);
                return true;
            default:
                return internalOffer(context);
        }
    }

}
