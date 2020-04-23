package de.supaadev.particles.commands;

import de.supaadev.particles.Particles;
import de.supaadev.particles.effect.ParticleEffect;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StartCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
        if(!(cs instanceof Player)) return true;

        Player player = (Player) cs;

        if(cmd.getName().equalsIgnoreCase("start")) {
            if(args.length == 0) {
                spawnParticles(player.getLocation());
                player.sendMessage("§6Partikel §8» §7Du hast die Partikel §aerfolgreich §7gespawnt.");
            }
        }

        return false;
    }

    private void spawnParticles(Location location) {
        Bukkit.getScheduler().runTaskTimer(Particles.getInstance(), new Runnable() {

            @Override
            public void run() {
                for(int i = 0; i < 360; i+=360/20) {
                    double angle = (i*Math.PI / 180);
                    double x = 0.5 * Math.cos(angle);
                    double z = 0.5 * Math.sin(angle);
                    Location particleLoc = location.add(x, 0, z);
                    ParticleEffect.SPELL_MOB.display(1,1,1, 1, 0, particleLoc, 100);
                    ParticleEffect.SPELL_MOB.display(1,1,1, 1, 0, particleLoc, 100);
                    ParticleEffect.SPELL_MOB.display(1,1,1, 1, 0, particleLoc, 100);
                }
            }
        }, 20, 20);
    }
}
