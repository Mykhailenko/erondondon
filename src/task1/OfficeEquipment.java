package task1;

import java.text.MessageFormat;

import task2_2.AbstractArticul;

public class OfficeEquipment extends Product {
	public enum Format {
		A5, A4, A3;
	}
	public enum PrintingTechnology {
		LED, Fluid, Laser, Martix, Tverdochernilnaya;
	}
	
	private Format format;
	private PrintingTechnology printingTechnology;
	private boolean colorPrinting;
	private boolean wifi;
	private boolean usb2_0;
	
	public OfficeEquipment() {
		super();
	}
	
	public OfficeEquipment(AbstractArticul articul, String title, String producer, String description, 
			Format format,	PrintingTechnology printingTechnology, 
			boolean colorPrinting,	boolean wifi, boolean usb2_0) {
		super(articul, title, producer, description);
		this.format = format;
		this.printingTechnology = printingTechnology;
		this.colorPrinting = colorPrinting;
		this.wifi = wifi;
		this.usb2_0 = usb2_0;
	}

	
	@Override
	public String toString() {
		return MessageFormat
				.format("OfficeEquipment [format={0}, printingTechnology={1}, colorPrinting={2}, wifi={3}, usb2_0={4}, getTitle()={5}, getProducer()={6}, getArticul()={7}, getDescription()={8}]",
						format, printingTechnology, colorPrinting, wifi, usb2_0, getTitle(),
						getProducer(), getArticul(), getDescription());
	}

	public Format getFormat() {
		return format;
	}
	public void setFormat(Format format) {
		this.format = format;
	}
	public PrintingTechnology getPrintingTechnology() {
		return printingTechnology;
	}
	public void setPrintingTechnology(PrintingTechnology printingTechnology) {
		this.printingTechnology = printingTechnology;
	}
	public boolean isColorPrinting() {
		return colorPrinting;
	}
	public void setColorPrinting(boolean colorPrinting) {
		this.colorPrinting = colorPrinting;
	}
	public boolean isWifi() {
		return wifi;
	}
	public void setWifi(boolean wifi) {
		this.wifi = wifi;
	}
	public boolean isUsb2_0() {
		return usb2_0;
	}
	public void setUsb2_0(boolean usb2_0) {
		this.usb2_0 = usb2_0;
	}
}
