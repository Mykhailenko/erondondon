package task3_5;

import java.io.File;

public class FileDirectoryFilter extends BaseFileFilter{

	@Override
	protected boolean realAccept(File file) {
		return file.isDirectory();
	}

}
