package task1;

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
	
	public OfficeEquipment(String id, String title, String producer, String description, 
			Format format,	PrintingTechnology printingTechnology, 
			boolean colorPrinting,	boolean wifi, boolean usb2_0) {
		super(id, title, producer, description);
		this.format = format;
		this.printingTechnology = printingTechnology;
		this.colorPrinting = colorPrinting;
		this.wifi = wifi;
		this.usb2_0 = usb2_0;
	}

	
	@Override
	public String toString() {
		return "OfficeEquipment [format=" + format + ", printingTechnology="
				+ printingTechnology + ", colorPrinting=" + colorPrinting
				+ ", wifi=" + wifi + ", usb2_0=" + usb2_0 + ", getTitle()="
				+ getTitle() + ", getProducer()=" + getProducer()
				+ ", getDescription()=" + getDescription() + "]";
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
