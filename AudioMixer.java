import javax.sound.sampled.*;
import java.util.*;


public class AudioMixer {
	private Mixer.Info[] mInfo;
	private Mixer[] mixers;
	private Line.Info[] lInfo;
	private Line[] SourceLine;
	private Line[] TargetLine;
	private DataLine.Info dInfo;
	private Port.Info[] pInfo;
	static ArrayList<String> PortNames;
	
	
	
	public AudioMixer() {
		// Put Mixer into an Array thats manipulatable
		this.mInfo = AudioSystem.getMixerInfo();
		PortNames = new ArrayList<String>();
	}
	
	//Create methods that get mixers, get port numbers, attach port position with PortName elements
	public Mixer.Info[] getmInfo() {
		return mInfo;
	}

	public void setmInfo(Mixer.Info[] mInfo) {
		this.mInfo = mInfo;
	}

	public Line.Info[] getlInfo() {
		return lInfo;
	}

	public void setlInfo(Line.Info[] lInfo) {
		this.lInfo = lInfo;
	}

	public DataLine.Info getdInfo() {
		return dInfo;
	}

	public void setdInfo(DataLine.Info dInfo) {
		this.dInfo = dInfo;
	}

	public Port.Info[] getpInfo() {
		return pInfo;
	}

	public void setpInfo(Port.Info[] pInfo) {
		this.pInfo = pInfo;
	}

	public static String removePortName(String portname) {	
		for(int i = 0; i < PortNames.size(); i++) {
			if(portname == PortNames.get(i)) {
				PortNames.remove(i);
				return "Port Name Removed";
			}
		}
		return "No value Found with that name.";
	}

	public static void addPortName(String portName) {
		PortNames.add(portName);
	}
	
	public void showPortNameList() {
		//Loop through the portNames array list to find the argument given to the method.
		for(int i = 0; i < PortNames.size(); i++) {
			System.out.println("Port " + i + ": " + PortNames.get(i));
		}
	}

	public void showSystemMixers() {
		//Display Mixer Array Content using a loop
		int i = 1;
		for(Mixer.Info mixer : mInfo) {
			System.out.println("Mixer #" + i + ":");
			System.out.println(mixer.getName());
			System.out.println(mixer.getVendor());
			System.out.println(mixer.getVersion());
			System.out.println(mixer.getDescription());
			i++;
		}
	}
	
	public void assignPorts() {
		//Get source and target info from mixers
		
		//assign source and target lines
		
	}

	public static void main(String[] arg) {
		
		
	}
}
