import javax.sound.sampled.*;
import java.util.*;

public class SourceAudio {
	static Mixer.Info[] mInfo;
	static ArrayList<Mixer> mixers;
	private Line.Info[] SInfo;
	private Line.Info[] TInfo;
	private Line[] SourceLine;
	private Line[] TargetLine;
	private DataLine.Info dInfo;
	private Port.Info[] pInfo;
	static ArrayList<String> PortNames;
	
	
	
	
	public SourceAudio() {
		// Put Mixer into an Array thats manipulatable
		mInfo = AudioSystem.getMixerInfo();
		PortNames = new ArrayList<String>();
		mixers = new ArrayList<Mixer>();		
		SourceAudio.showSystemMixerInfo();
	}
	
	//Create methods that get mixers, get port numbers, attach port position with PortName elements
	
	public Mixer.Info[] getmInfo() {
		return mInfo;
	}

	public Line[] getSourceLine() {
		return SourceLine;
	}

	public Line[] getTargetLine() {
		return TargetLine;
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

	public static void showSystemMixerInfo() throws NullPointerException{
		//Display mInfo Array Content using a loop
		int i = 0;
		for(Mixer.Info mixer : mInfo) {
			System.out.println("Mixer #" + i + ":");
			System.out.println("Name: " + mixer.getName());
			System.out.println("Vendor: " + mixer.getVendor());
			System.out.println("Version: " + mixer.getVersion());
			System.out.println("Description: " + mixer.getDescription() +"\n");	
			i++;
		}	
	}
		
	
	public static void setMixersToArrayList() {
		try {
			//Add Mixers from mInfo into the mixers ArrayList
			for(int i = 0; i < mInfo.length; i++) {
				mixers.add(AudioSystem.getMixer(mInfo[i]));
			}
		}catch (IndexOutOfBoundsException IOOBE) {
			System.out.println("Exception Error: Index Out of Bounds");
		}
	}	
	
	public void fillMixerLineArrays(int mixer) {		
		//Get source and target info from mixers
		this.SInfo = mixers.get(mixer).getSourceLineInfo();
		this.TInfo = mixers.get(mixer).getTargetLineInfo();
			
		//Display Source and Target Lines Info
		for(int i = 0; i < SInfo.length; i++) {
			System.out.println("Source Line " + i + ": " + SInfo[i].getLineClass());
		}
		
		for(int i = 0; i < TInfo.length; i++) {
			System.out.println("Target Line " + i + ": " + TInfo[i].getLineClass());
		}							
	}
	
	public void fillSrcTgtLines(int mixer) {
		//assign this mixer instances source and target lines to an array to use.
		SourceLine = mixers.get(mixer).getSourceLines();
		TargetLine = mixers.get(mixer).getTargetLines();
	}
	
	public void toggleSourceLineState(int source) {
		try {
			if(SourceLine[source] != null) {
				if(!SourceLine[source].isOpen()) {
					SourceLine[source].open();
					System.out.println("Toggled On");
				}else {
					SourceLine[source].close();
					System.out.println("Toggled Off");
				}
			}
		} catch (LineUnavailableException LUE){
			System.out.println("Exception Error: Source Line State");
		}
	}
	
	public void toggleTargetLineState(int Target) {
		try {
			if(TargetLine[Target] != null) {
				if(!TargetLine[Target].isOpen()) {
					TargetLine[Target].open();
					System.out.println("Toggled On");
				}else {
					TargetLine[Target].close();
					System.out.println("Toggled Off");
				}
			}
		}catch (LineUnavailableException LUE) {
			System.out.println("Exception Error: Target Line State");
		}
	}

	public static void main(String[] arg) throws NullPointerException{
		Scanner keysIn = new Scanner(System.in);
		SourceAudio test = new SourceAudio();
		int mixNum;

		System.out.println("Which mixer would you like to use?");
		mixNum = keysIn.nextInt();
		SourceAudio.setMixersToArrayList();
		test.fillMixerLineArrays(mixNum);
		test.fillSrcTgtLines(mixNum);
		
		if(test.getSourceLine() != null) {
			System.out.println("Which Source line will you turn on?");
			mixNum = keysIn.nextInt();
			test.toggleSourceLineState(mixNum);
		}
		
		if(test.getTargetLine() != null) {
			System.out.println("Which Target line will you turn on?");
			mixNum = keysIn.nextInt();
			test.toggleTargetLineState(mixNum);
		}
		
		test.toggleSourceLineState(mixNum);
		test.toggleTargetLineState(mixNum);
		keysIn.close();
		
		
		
		
		
		
	
	}
}
