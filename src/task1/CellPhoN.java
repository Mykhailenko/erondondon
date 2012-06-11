package task1;

import java.awt.Color;

public class CellPhoN extends MobileDevice {
	public enum ShellType {
		MONOBLOCK, FOLDING, SLIDER;
	}
	
	private ShellType shellType;
	private boolean sensor;
	private int numberOfSims;
	private boolean bluetooth;
	private boolean wifi;
	private Color color;
	
	public CellPhoN() {
		super();
	}

	public CellPhoN(String id, String title, String producer, String description,
			double diagonal, OS os, int batteryCapacity, boolean gPS,
			double cameraResolution,ShellType shellType, boolean sensor, int numberOfSims,
			 boolean bluetooth, boolean wifi,	Color color) {
		super(id, title, producer, description, diagonal, os, batteryCapacity, gPS, cameraResolution);
		this.shellType = shellType;
		this.sensor = sensor;
		this.numberOfSims = numberOfSims;
		this.bluetooth = bluetooth;
		this.wifi = wifi;
		this.color = color;
	}

	

	@Override
	public String toString() {
		return "CellPhoN [shellType=" + shellType + ", sensor=" + sensor
				+ ", numberOfSims=" + numberOfSims + ", bluetooth=" + bluetooth
				+ ", wifi=" + wifi + ", color=" + color + ", getDiagonal()="
				+ getDiagonal() + ", getOs()=" + getOs()
				+ ", getBatteryCapacity()=" + getBatteryCapacity()
				+ ", isGPS()=" + isGPS() + ", getTitle()=" + getTitle()
				+ ", getProducer()=" + getProducer() + ", getId()=" + getId()
				+ ", getDescription()=" + getDescription() + "]";
	}

	public ShellType getShellType() {
		return shellType;
	}
	public void setShellType(ShellType shellType) {
		this.shellType = shellType;
	}
	public boolean isSensor() {
		return sensor;
	}
	public void setSensor(boolean sensor) {
		this.sensor = sensor;
	}
	public int getNumberOfSims() {
		return numberOfSims;
	}
	public void setNumberOfSims(int numberOfSims) {
		this.numberOfSims = numberOfSims;
	}
	public boolean isBluetooth() {
		return bluetooth;
	}
	public void setBluetooth(boolean bluetooth) {
		this.bluetooth = bluetooth;
	}
	public boolean isWifi() {
		return wifi;
	}
	public void setWifi(boolean wifi) {
		this.wifi = wifi;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	
}
