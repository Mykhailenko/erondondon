package task1;

import java.text.MessageFormat;

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
		return MessageFormat
				.format("MFU [LAN={0}, cardReader={1}, opticalResolution={2}, getFormat()={3}, getPrintingTechnology()={4}, isColorPrinting()={5}, isWifi()={6}, isUsb2_0()={7}, getTitle()={8}, getProducer()={9}, getId()={10}, getDescription()={11}]",
						LAN, cardReader, opticalResolution, getFormat(), getPrintingTechnology(),
						isColorPrinting(), isWifi(), isUsb2_0(), getTitle(), getProducer(),
						getId(), getDescription());
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
