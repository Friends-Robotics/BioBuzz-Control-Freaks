package org.firstinspires.ftc.teamcode.friends.commands.FTCSpecificCommands;

import com.pedropathing.follower.Follower;
import com.pedropathing.paths.Path;

import commands.base.Command;
import commands.base.Subsystem;


import java.util.Set;

public class FollowPathCommand implements Command {

    private Follower follower;
    private Path path;

    private Subsystem drive;

    public FollowPathCommand(Follower follower, Path path, Subsystem drive)
    {
        this.follower = follower;
        this.path = path;
        this.drive = drive;
    }


    @Override
    public void initialize() {follower.follow(path);}
    @Override
    public void execute() {follower.update();}
    @Override
    public boolean isFinished() {return !follower.isBusy();}
    @Override
    public void end(boolean interrupted) {follower.idle();}

    @Override
    public Set<Subsystem> getRequirements() {
        return Set.of(drive);
    }


}
