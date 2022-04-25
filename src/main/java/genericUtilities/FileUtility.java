package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * 
 * @author SanjayBabu
 *
 */

public class FileUtility {
	/**
	 * 
	 * @param args
	 * @throws IOException 
	 */

	public String getPropertyKeyValue(String key) throws IOException
	{
		
		// TODO Auto-generated method stub
		FileInputStream fs=new FileInputStream(IPathConstants.filePath);
		Properties prj=new Properties();
		prj.load(fs);
		prj.getProperty(key);
		return prj.getProperty(key);
	}

}
