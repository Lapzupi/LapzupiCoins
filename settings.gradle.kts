rootProject.name = "LapzupiCoins"

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        maven ("https://repo.papermc.io/repository/maven-public/")
        maven ("https://oss.sonatype.org/content/groups/public/")
        maven ("https://libraries.minecraft.net/")
        maven ("https://jitpack.io")
        maven ("https://mvn.lumine.io/repository/maven-public/")
        maven ("https://repo.xenondevs.xyz/releases")
    }
    versionCatalogs {
        create("libs") {
            library ("paper-api","io.papermc.paper:paper-api:1.19.4-R0.1-SNAPSHOT")
            library ("bungeecord-api","net.md-5:bungeecord-api:1.19-R0.1-SNAPSHOT")
            library ("vault-api","com.github.MilkBowl:VaultAPI:1.7.1")
            library ("treasury","com.github.lokka30.treasury:treasury-api:937ec97a98")
            library ("authlib","com.mojang:authlib:1.5.21")

            library ("mm-api","io.lumine.xikage:MythicMobs:4.9.1")
            library ("mm-dist","io.lumine:Mythic-Dist:5.2.0")

            library ("itemsadder","com.github.LoneDev6:api-itemsadder:3.6.3-beta-14")

            library ("paper-lib","io.papermc:paperlib:1.0.7")
            library ("bstats","org.bstats:bstats-bukkit:3.0.2")

            library ("nova","xyz.xenondevs.nova:nova-api:0.14")

            plugin("shadow", "com.gradleup.shadow").version("8.3.5")
            plugin("bukkit-yml", "net.minecrell.plugin-yml.bukkit").version("0.6.0")
        }
    }
}
