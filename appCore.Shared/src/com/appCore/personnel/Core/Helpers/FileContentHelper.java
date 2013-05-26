package com.appCore.personnel.Core.Helpers;


public class FileContentHelper {
	
	
	public static String getFileExtByContent(String contentType)
	{
		if (contentType.equals(CoreConstants.ContentTypeGIF))
			return CoreConstants.extensionGIF;
		else if (contentType.equals(CoreConstants.ContentTypeJpg))
			return CoreConstants.extensionJPG;
		else if (contentType.equals(CoreConstants.ContentTypePNG))
			return CoreConstants.ContentTypePNG;
		else if (contentType.equals(CoreConstants.ContentTypeJpeg))
			return CoreConstants.extensionJPG;
	
		return CoreConstants.StringEmpty;
	}
}
