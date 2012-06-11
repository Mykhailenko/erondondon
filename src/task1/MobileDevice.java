package task1;

public class MobileDevice extends Product{
	public enum OS {
		Android, iOS, Windows_7, Tablet_OS, Bada, MeeGo, Symbian; 
	}
	private double diagonal;
	private OS os;
	private int batteryCapacity;
	private boolean GPS;
	private double cameraResolution;
	
	public MobileDevice() {
		super();
	}
	
	public MobileDevice(String id, String title, String producer,
			String description,	double diagonal, 
			OS os, int batteryCapacity, boolean gPS, 
			double cameraResolution) {
		super(id, title, producer, description);
		this.diagonal = diagonal;
		this.os = os;
		this.batteryCapacity = batteryCapacity;
		this.setCameraResolution(cameraResolution);
		GPS = gPS;
	}

	@Override
	public String toString() {
		return "MobileDevice [diagonal=" + diagonal + ", os=" + os
				+ ", batteryCapacity=" + batteryCapacity + ", GPS=" + GPS
				+ ", getTitle()=" + getTitle() + ", getProducer()="
				+ getProducer() + ", getId()=" + getId()
				+ ", getDescription()=" + getDescription() + "]";
	}

	public double getDiagonal() {
		return diagonal;
	}
	public void setDiagonal(double diagonal) {
		this.diagonal = diagonal;
	}
	public OS getOs() {
		return os;
	}
	public void setOs(OS os) {
		this.os = os;
	}
	public int getBatteryCapacity() {
		return batteryCapacity;
	}
	public void setBatteryCapacity(int batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}
	public boolean isGPS() {
		return GPS;
	}
	public void setGPS(boolean gPS) {
		GPS = gPS;
	}

	public double getCameraResolution() {
		return cameraResolution;
	}

	public void setCameraResolution(double cameraResolution) {
		this.cameraResolution = cameraResolution;
	}
	
}
