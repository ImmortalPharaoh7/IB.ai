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

package com.ibdiscord.command.commands.voting.ladder;

import com.ibdiscord.command.CommandContext;
import com.ibdiscord.command.permissions.CommandPermission;
import com.ibdiscord.data.db.entries.voting.VoteLadderData;
import com.ibdiscord.utils.UTime;
import net.dv8tion.jda.api.Permission;

import java.util.Set;

public final class VoteLadderDurationCommand extends VoteLadderDataCommand {

    /**
     * Creates the command.
     */
    VoteLadderDurationCommand() {
        super("voteladder_duration",
                CommandPermission.discord(Permission.MANAGE_SERVER),
                Set.of()
        );
    }

    /**
     * Sets the duration/expiry of the vote ladder.
     * @param context The command context.
     * @param ladderData The ladder data.
     */
    @Override
    protected void handle(CommandContext context, VoteLadderData ladderData) {
        String duration = context.getArguments()[1];
        long time = UTime.parseDuration(duration) - System.currentTimeMillis(); // Adjusts for the current time
        if(time < 0) {
            context.reply(__(context, "error.ladder_format"));
            return;
        }
        ladderData.set(VoteLadderData.TIMEOUT, time);
        context.reply(__(context, "success.ladder_specify"));
    }

}
