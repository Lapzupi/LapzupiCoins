import net.minecrell.pluginyml.bukkit.BukkitPluginDescription.Permission.Default;

plugins {
    id("java")
    id("net.minecrell.plugin-yml.bukkit") version "0.5.3"
    id("com.github.johnrengelman.shadow") version "8.1.0"
}

group = "me.justeli.coins"
version = "1.13.1"

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
    compileOnly ("io.papermc.paper:paper-api:1.19.3-R0.1-SNAPSHOT")
    compileOnly ("net.md-5:bungeecord-api:1.19-R0.1-SNAPSHOT")
    compileOnly ("com.github.MilkBowl:VaultAPI:1.7.1")
    compileOnly ("com.github.lokka30.treasury:treasury-api:937ec97a98")
    compileOnly ("com.mojang:authlib:1.5.21")

    compileOnly ("io.lumine.xikage:MythicMobs:4.9.1")
    compileOnly ("io.lumine:Mythic-Dist:5.2.0")

    compileOnly ("com.github.LoneDev6:api-itemsadder:3.2.5")

    implementation ("io.papermc:paperlib:1.0.7")
    implementation ("org.bstats:bstats-bukkit:3.0.1")

    compileOnly ("xyz.xenondevs.nova:nova-api:0.12")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
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
    apiVersion = "1.19"
    
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


