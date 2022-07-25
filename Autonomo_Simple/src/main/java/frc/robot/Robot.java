
package frc.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Talon;

public class Robot extends TimedRobot {
  
  //Constantes 
  int KMTIZ1 = 1;
  int KMTIZ2 = 2;
  int KMTIZ3 = 3;
  int KMTDR1 = 4;
  int KMTDR2 = 5;
  int KMTDR3 = 6;
  int KSINTD1 = 7;
  int KSINTD2 = 8;
  int KSINTI1 = 9;
  int KSINTI2 = 10;
  int KMINTI = 11;
  int KMINTD = 12;

  //Instancia de motores 
  Talon motizq1 = new Talon (KMTIZ1); 
  Talon motizq2 = new Talon (KMTIZ2);
  Talon motizq3 = new Talon (KMTIZ3);
  Talon motder1 = new Talon (KMTDR1);
  Talon motder2 = new Talon (KMTDR2);
  Talon motder3 = new Talon (KMTDR3);
  Talon motintder = new Talon(KMINTD);
  Talon motintizq = new Talon(KMINTI);

  //DriveTrain e Intake
  MotorControllerGroup tanqueizq = new MotorControllerGroup(motizq1, motizq2, motizq3);
  MotorControllerGroup tanqueder = new MotorControllerGroup(motder1, motder2, motder3);
  DifferentialDrive chassis = new DifferentialDrive (tanqueizq, tanqueder);
  MotorControllerGroup motintake = new MotorControllerGroup(motintder, motintizq);

  /*Neumática 
  DoubleSolenoid pistonder = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, KSINTD1, KSINTD2);
  DoubleSolenoid pistonizq = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, KSINTI1, KSINTI2);
  Compressor compresor = new Compressor(PneumaticsModuleType.CTREPCM);*/

  Timer temporizador = new Timer();

  @Override
  public void robotInit() {
    
    //compresor.disable();
    motintder.setInverted(true);
    tanqueder.setInverted(false);
    tanqueizq.setInverted(true);

  }

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {
  }

  @Override
  public void autonomousPeriodic() {

    if (Timer.getMatchTime() <=15 && Timer.getMatchTime() >=12){
      ChassisAdelante();
    }

    if (Timer.getMatchTime() <=11 && Timer.getMatchTime() >=9){
      ChassisVueltaDerecha();
    }

    if (Timer.getMatchTime() <=8 && Timer.getMatchTime() >=6) {
      ChassisAdelante();
    }

    if (Timer.getMatchTime() <=5 && Timer.getMatchTime() >= 3) {
      ChassisVueltaIzquierda();;
    }

    if (Timer.getMatchTime() <=2 ) {
      ChassisAtras();;
    }

  }

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {}

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}

  //Metodos

  /*public void AccionarIntake (){
    //Motores
    motintake.set(.5);
    //Pistones
    pistonder.set(Value.kForward);
    pistonizq.set(Value.kForward);
  }*/

  /*public void RegresarIntake (){
    //Motores
    motintake.disable();
    //Pistones
    pistonder.set(Value.kReverse);
    pistonizq.set(Value.kReverse);
  }*/

  public void ChassisAdelante (){
    chassis.tankDrive(.5, .5);
  }

  public void ChassisAtras (){
    chassis.tankDrive(-.5, -.5);
  }

  public void ChassisVueltaIzquierda (){
    chassis.tankDrive(-.5, .5);
  }

  public void ChassisVueltaDerecha (){
    chassis.tankDrive(.5, -.5);
  }

}
