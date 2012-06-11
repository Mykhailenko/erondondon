package task1;

import java.text.MessageFormat;

public class Tablet extends MobileDevice{
	public enum DisplayResolution {
		px320x240, px400x240, px800x480,
		px800x600, px1024x600, px1024x768,
		px1280x800, px2048x1536;
	}
	private enum ProccessorProducer {
		AMD, Apple, Cortex, Intel, NVIDIA, 
		Qualcomm;
	}
	private DisplayResolution displayResolution;
	private double coreFrequency;
	private ProccessorProducer proccessorProducer;
	private int ramVolume;//in MB
	private int hddVolume;// in MB
	private int numberOfUSB;
	private boolean HDMI;
	public Tablet() {
		super();
	}
	
	public Tablet(String id, String title, String producer,
			String description,	double diagonal, 
			OS os, int batteryCapacity, boolean gPS, 
			double cameraResolution,
			DisplayResolution displayResolution, double coreFrequency,
			ProccessorProducer proccessorProducer, int ramVolume,
			int hddVolume, int numberOfUSB, boolean hDMI) {
		super(id, title, producer, description, diagonal,
				os, batteryCapacity, gPS, cameraResolution);
		this.displayResolution = displayResolution;
		this.coreFrequency = coreFrequency;
		this.proccessorProducer = proccessorProducer;
		this.ramVolume = ramVolume;
		this.hddVolume = hddVolume;
		this.numberOfUSB = numberOfUSB;
		HDMI = hDMI;
	}
	
	

	@Override
	public String toString() {
		return MessageFormat
				.format("Tablet [displayResolution={0}, coreFrequency={1}, proccessorProducer={2}, ramVolume={3}, hddVolume={4}, numberOfUSB={5}, HDMI={6}, getDiagonal()={7}, getOs()={8}, getBatteryCapacity()={9}, isGPS()={10}, getCameraResolution()={11}, getTitle()={12}, getProducer()={13}, getId()={14}, getDescription()={15}]",
						displayResolution, coreFrequency, proccessorProducer, ramVolume, hddVolume, numberOfUSB,
						HDMI, getDiagonal(), getOs(), getBatteryCapacity(), isGPS(),
						getCameraResolution(), getTitle(), getProducer(), getId(), getDescription());
	}



	public DisplayResolution getDisplayResolution() {
		return displayResolution;
	}
	public void setDisplayResolution(DisplayResolution displayResolution) {
		this.displayResolution = displayResolution;
	}
	public double getCoreFrequency() {
		return coreFrequency;
	}
	public void setCoreFrequency(double coreFrequency) {
		this.coreFrequency = coreFrequency;
	}
	public ProccessorProducer getProccessorProducer() {
		return proccessorProducer;
	}
	public void setProccessorProducer(ProccessorProducer proccessorProducer) {
		this.proccessorProducer = proccessorProducer;
	}
	public int getRamVolume() {
		return ramVolume;
	}
	public void setRamVolume(int ramVolume) {
		this.ramVolume = ramVolume;
	}
	public int getHddVolume() {
		return hddVolume;
	}
	public void setHddVolume(int hddVolume) {
		this.hddVolume = hddVolume;
	}
	public int getNumberOfUSB() {
		return numberOfUSB;
	}
	public void setNumberOfUSB(int numberOfUSB) {
		this.numberOfUSB = numberOfUSB;
	}
	public boolean isHDMI() {
		return HDMI;
	}
	public void setHDMI(boolean hDMI) {
		HDMI = hDMI;
	}
	
	
}
