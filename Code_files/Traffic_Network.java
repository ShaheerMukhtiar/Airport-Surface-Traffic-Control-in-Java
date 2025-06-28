package Airplane;

public class Traffic_Network  {
	private static Runway R1=new Runway (true,false ,"MR1");
	private static Runway R2= new Runway(true, false , "MR2");
	private static Taxiway T1=new Taxiway(true, false , "TR1");
	private static Taxiway T2=new Taxiway(true, false , "TR1");
	public Runway getR1() {
		return R1;
	}
	public  void setR1(Runway r1) {
		R1 = r1;
	}
	public Runway getR2() {
		return R2;
	}
	public  void setR2(Runway r2) {
		R2 = r2;
	}
	public  Taxiway getT1() {
		return T1;
	}
	public  void setT1(Taxiway t1) {
		T1 = t1;
	}
	public  Taxiway getT2() {
		return T2;
	}
	public  void setT2(Taxiway t2) {
		T2 = t2;
	}
}
