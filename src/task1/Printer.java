package task1;

import task1.MFU.OpticalResolution;

public class Printer extends OfficeEquipment{
	public Printer() {
		super();
	}
	public Printer(String id, String title, String producer, String description, 
			Format format, PrintingTechnology printingTechnology, boolean colorPrinting,
			boolean wifi, boolean usb2_0, boolean lAN, boolean cardReader,
			OpticalResolution opticalResolution) {
		super(id, title, producer, description, format, printingTechnology, colorPrinting, wifi, usb2_0);
	}
	@Override
	public String toString() {
		return "Printer [getFormat()=" + getFormat()
				+ ", getPrintingTechnology()=" + getPrintingTechnology()
				+ ", isColorPrinting()=" + isColorPrinting() + ", isWifi()="
				+ isWifi() + ", isUsb2_0()=" + isUsb2_0() + ", getTitle()="
				+ getTitle() + ", getProducer()=" + getProducer()
				+ ", getId()=" + getId() + ", getDescription()="
				+ getDescription() + "]";
	}
	
}
