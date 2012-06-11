package task1;

import java.awt.Color;
import java.text.MessageFormat;

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
		return MessageFormat
				.format("CellPhoN [shellType={0}, sensor={1}, numberOfSims={2}, bluetooth={3}, wifi={4}, color={5}, getDiagonal()={6}, getOs()={7}, getBatteryCapacity()={8}, isGPS()={9}, getTitle()={10}, getProducer()={11}, getId()={12}, getDescription()={13}]",
						shellType, sensor, numberOfSims, bluetooth, wifi, color,
						getDiagonal(), getOs(), getBatteryCapacity(), isGPS(), getTitle(),
						getProducer(), getId(), getDescription());
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
