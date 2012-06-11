package task1;

import java.text.MessageFormat;

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
		return MessageFormat
				.format("Printer [getFormat()={0}, getPrintingTechnology()={1}, isColorPrinting()={2}, isWifi()={3}, isUsb2_0()={4}, getTitle()={5}, getProducer()={6}, getId()={7}, getDescription()={8}]",
						getFormat(), getPrintingTechnology(), isColorPrinting(), isWifi(), isUsb2_0(),
						getTitle(), getProducer(), getId(), getDescription());
	}
	
}
