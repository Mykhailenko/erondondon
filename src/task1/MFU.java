package task1;

public class MFU extends OfficeEquipment{
	public enum OpticalResolution {
		dpi300x300,
		dpi400x600,
		dpi600x600,
		dpi1200x600,
		dpi1200x1200,
		dpi2400x600,
		dpi2400x1200,
		dpi2400x2400,
		dpi4800x2400,
		dpi4800x4800,
		dpi9600x4800,
		dpi9600x9600;
	}
	private boolean LAN;
	private boolean cardReader;
	private OpticalResolution opticalResolution;
	public MFU() {
		super();
	}
	
	public MFU(String id, String title, String producer, Format format, String description,
			PrintingTechnology printingTechnology, boolean colorPrinting,
			boolean wifi, boolean usb2_0, boolean lAN, boolean cardReader,
			OpticalResolution opticalResolution) {
		super(id, title, producer, description, format, printingTechnology, colorPrinting, wifi, usb2_0);
		LAN = lAN;
		this.cardReader = cardReader;
		this.opticalResolution = opticalResolution;
	}
	
	
	@Override
	public String toString() {
		return "MFU [LAN=" + LAN + ", cardReader=" + cardReader
				+ ", opticalResolution=" + opticalResolution + ", getFormat()="
				+ getFormat() + ", getPrintingTechnology()="
				+ getPrintingTechnology() + ", isColorPrinting()="
				+ isColorPrinting() + ", isWifi()=" + isWifi()
				+ ", isUsb2_0()=" + isUsb2_0() + ", getTitle()=" + getTitle()
				+ ", getProducer()=" + getProducer() + ", getId()=" + getId()
				+ ", getDescription()=" + getDescription() + "]";
	}

	public boolean isLAN() {
		return LAN;
	}
	public void setLAN(boolean lAN) {
		LAN = lAN;
	}
	public boolean isCardReader() {
		return cardReader;
	}
	public void setCardReader(boolean cardReader) {
		this.cardReader = cardReader;
	}
	public OpticalResolution getOpticalResolution() {
		return opticalResolution;
	}
	public void setOpticalResolution(OpticalResolution opticalResolution) {
		this.opticalResolution = opticalResolution;
	}
	
	
}
