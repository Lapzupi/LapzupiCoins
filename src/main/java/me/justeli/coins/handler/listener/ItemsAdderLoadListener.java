package me.justeli.coins.handler.listener;

import dev.lone.itemsadder.api.Events.ItemsAdderLoadDataEvent;
import me.justeli.coins.Coins;
import me.justeli.coins.config.Message;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

/**
 * @author sarhatabaot
 */
public class ItemsAdderLoadListener implements Listener
{
    private final Coins coins;

    public ItemsAdderLoadListener(final Coins coins)
    {
        this.coins = coins;
    }

    @EventHandler
    public void onItemsLoad(ItemsAdderLoadDataEvent event) {
        this.coins.reload();
        int warnings = this.coins.settings().getWarningCount();
        long ms = System.currentTimeMillis();
        this.coins.getLogger().info(() -> Message.RELOAD_SUCCESS.replace(Long.toString(System.currentTimeMillis() - ms)));
        if (warnings != 0)
        {
            this.coins.getLogger().info(Message.MINOR_ISSUES::toString);
        }
        else
        {
            this.coins.getLogger().info(Message.CHECK_SETTINGS::toString);
        }
    }
}
