import net.minecrell.pluginyml.bukkit.BukkitPluginDescription.Permission.Default;

plugins {
    java
    alias(libs.plugins.shadow)
    alias(libs.plugins.bukkit.yml)
}

group = "me.justeli.coins"
version = "1.13.1-L"

repositories {
    mavenCentral()
    maven ("https://repo.papermc.io/repository/maven-public/")
    maven ("https://oss.sonatype.org/content/groups/public/")
    maven ("https://libraries.minecraft.net/")
    maven ("https://jitpack.io")
    maven ("https://mvn.lumine.io/repository/maven-public/")
    maven ("https://repo.xenondevs.xyz/releases")
}

dependencies {
    compileOnly(libs.paper.api)
    compileOnly(libs.bungeecord.api)
    compileOnly(libs.vault.api)
    compileOnly(libs.treasury)
    compileOnly(libs.authlib)
    compileOnly(libs.mm.api)
    compileOnly(libs.mm.dist)
    compileOnly(libs.itemsadder)
    compileOnly(libs.nova)

    implementation(libs.paper.lib)
    implementation(libs.bstats)
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}


bukkit {
    name = "LapzupiCoins"
    authors = listOf("JustEli", "sarhatabaot")
    main = "me.justeli.coins.Coins"
    version = project.version.toString()
    description = "Coins is a plugin that allows players to collect coins for killing mobs and mining precious blocks. It also comes with the ability to withdraw balance into physical coins."
    website = "https://www.spigotmc.org/resources/coins.33382/"
    softDepend = listOf("Vault", "Treasury", "WorldGuard", "mcMMO", "MythicMobs", "ItemsAdder", "Nova")
    apiVersion = "1.21"
    
    commands {
        register("coins") {
            description = "Command for showing all available commands from Coins. Also used for various admin tools."
            permission = "coins.command"
            usage = "/<command> [reload|settings|drop|remove|language|version|toggle]"
            aliases = listOf("coin")
        }
        register("withdraw") {
            description = "Withdraw money from your balance into physical coins."
            permission = "coins.withdraw"
            usage = "/<command> <worth> [amount]"
        }
    }
    
    permissions {
        register("coins.command") {
            default = Default.TRUE
        }
        
        register("coins.command.reload") {
            default = Default.OP
        }
        register ("coins.command.settings") {
            default = Default.OP
        }
        register ("coins.command.drop") {
            default = Default.OP
        }
        register ("coins.command.remove") {
            default = Default.OP
        }
        
        register ("coins.command.language") {
            default = Default.OP
        }
        
        register ("coins.command.version") {
            default = Default.OP
        }
        
        register("coins.command.toggle") {
            default = Default.OP
        }
        
        register("coins.withdraw") {
            description = "Access to the /withdraw command, and ability to withdraw and deposit coins."
            default = Default.OP
        }
        
        register ("coins.multiplier.n") {
            description = "Permission to give to players who should get multiplied coin drops. Replace /n/ with a number."
            default = Default.OP
        }
        
        register("coins.disable") {
            description = "Permission to give to players to disable coin pickup for them."
            default = Default.FALSE
        }
        
        register("coins.spawner") {
            description = "Permission to give to players who should get coins from killing mobs from spawners."
            default = Default.FALSE
        }
    }
}

tasks {
    build {
        dependsOn(shadowJar)
    }
    
    shadowJar {
        archiveClassifier.set("")
        
        relocate ("io.papermc", "me.justeli.coins.shaded.io.papermc")
        relocate ("org.bstats", "me.justeli.coins.shaded.org.bstats")
    }
}


