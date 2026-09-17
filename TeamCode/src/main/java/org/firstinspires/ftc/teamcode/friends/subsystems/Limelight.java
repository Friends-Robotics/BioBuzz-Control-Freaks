package org.firstinspires.ftc.teamcode.friends.subsystems;

import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Limelight {

    private final Limelight3A limelight;

    Limelight(HardwareMap hardwareMap){

        limelight = hardwareMap.get(Limelight3A.class, "limelight");
    }

    public void SetRate(int rate) {limelight.setPollRateHz(rate);}
    public void Switch(int index) {limelight.pipelineSwitch(index);}
    public void Start() {limelight.start();}

    public void Update(double tx, double ty, double ta) {
        LLResult result = limelight.getLatestResult();
        if(result != null && result.isValid()) {
            tx = result.getTx();
            ty = result.getTy();
            ta = result.getTa();
        }
    }

}
