package org.firstinspires.ftc.teamcode.Commands.DriveCommands;

import com.pedropathing.follower.Follower;
import com.pedropathing.paths.PathChain;

import org.firstinspires.ftc.teamcode.Commands.Command;

public class FollowPathComand implements Command {

    private Follower follower;
    private PathChain path;

    public FollowPathComand(Follower follower, PathChain path)
    {
        this.follower = follower;
        this.path = path;
    }


    @Override
    public void initialize() {follower.followPath(path);}
    @Override
    public void execute() {follower.update();}
    @Override
    public boolean isFinished() {return !follower.isBusy();}
    @Override
    public void end() {follower.breakFollowing();}

}
