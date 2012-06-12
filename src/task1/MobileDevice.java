package task1;

import java.text.MessageFormat;

import task2_2.AbstractArticul;

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
	
	public MobileDevice(AbstractArticul articul, String title, String producer,
			String description,	double diagonal, 
			OS os, int batteryCapacity, boolean gPS, 
			double cameraResolution) {
		super(articul, title, producer, description);
		this.diagonal = diagonal;
		this.os = os;
		this.batteryCapacity = batteryCapacity;
		this.setCameraResolution(cameraResolution);
		GPS = gPS;
	}

	@Override
	public String toString() {
		return MessageFormat
				.format("MobileDevice [diagonal={0}, os={1}, batteryCapacity={2}, GPS={3}, getTitle()={4}, getProducer()={5}, getId()={6}, getDescription()={7}]",
						diagonal, os, batteryCapacity, GPS, getTitle(),
						getProducer(), getArticul(), getDescription());
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
