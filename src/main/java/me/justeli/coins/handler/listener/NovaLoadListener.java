package me.justeli.coins.handler.listener;


import me.justeli.coins.Coins;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xyz.xenondevs.nova.api.Nova;
import xyz.xenondevs.nova.api.event.NovaLoadDataEvent;
import xyz.xenondevs.nova.api.protection.ProtectionIntegration;

public class NovaLoadListener implements Listener {
    
    private final Coins coins;
    
    public NovaLoadListener(final Coins coins) {
        this.coins = coins;
    }
    
    @EventHandler
    public void onNovaLoadEvent(NovaLoadDataEvent loadEvent) {
        Nova nova = Nova.getNova();
        nova.registerProtectionIntegration(new CoinDropProtection());
    }
    
    class CoinDropProtection implements ProtectionIntegration {
        
        @Override
        public boolean canBreak(@NotNull OfflinePlayer offlinePlayer, @Nullable ItemStack itemStack, @NotNull Location location) {
            return true;
        }
        
        @Override
        public boolean canHurtEntity(@NotNull OfflinePlayer offlinePlayer, @NotNull Entity entity, @Nullable ItemStack itemStack) {
            return true;
        }
        
        @Override
        public boolean canInteractWithEntity(@NotNull OfflinePlayer offlinePlayer, @NotNull Entity entity, @Nullable ItemStack itemStack) {
            if (entity instanceof Item potentialCoin) {
                return !coins.getCoinUtil().isDroppedCoin(potentialCoin.getItemStack());
            }
            return true;
        }
        
        @Override
        public boolean canPlace(@NotNull OfflinePlayer offlinePlayer, @NotNull ItemStack itemStack, @NotNull Location location) {
            return true;
        }
        
        @Override
        public boolean canUseBlock(@NotNull OfflinePlayer offlinePlayer, @Nullable ItemStack itemStack, @NotNull Location location) {
            return true;
        }
        
        @Override
        public boolean canUseItem(@NotNull OfflinePlayer offlinePlayer, @NotNull ItemStack itemStack, @NotNull Location location) {
            return true;
        }
    }
}
