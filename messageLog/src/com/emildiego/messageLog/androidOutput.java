package com.emildiego.messageLog;

import 	java.lang.StackTraceElement;

/**
 * The androidOutput class will log messages for android devices using 
 * the android.util.Log class.  It's simple and straight forward to us.
 * You can specify the types of messages you want to capture by setting the Log Level.  The different
 * message types are: 
 * LOG_ALL, LOG_DEBUG, LOG_SQL, LOG_MESSAGE, LOG_ERROR.
 * By default the log will only capture LOG_ERROR messages.
 * 
 * @author <A HREF="mailto:emildiego@gmail.com">Emil Diego</A>
 * @copy Copyright 2014
**/
public class androidOutput extends baseLog {
	
	
	/**
	  Default constructor used to initialize the instance of our class.  The class is 
	  created with the specified loge levean and descriptive tag set.
	  
	  @param sTag The tag used to identify the source of the message.
	  @param iLogLevel The level of messages we want to capture in the log.
	**/
	public androidOutput(int iLogLevel, String sTag)
	{
		//* call the parent class constructor
		super(sTag, iLogLevel);
		
	}
	
	//*******************************************************************
	//* METHODS
	//*******************************************************************
	/**
	  Write a Debug message to the log.
	  
	  @param sMessage The message we want to write to the log.
	**/
	@Override public void logDebug(String sMessage)
	{
		if (this.checkLogLevel(LOG_DEBUG))
			android.util.Log.d(this.getTag(), sMessage);
		
	}
	
	/**
	  Write a SQL message to the log.
	  
	  @return void
	  @param sMessage The message we want to write to the log.
	**/
	@Override public void logSQL(String sMessage)
	{
		if (this.checkLogLevel(LOG_SQL))
			android.util.Log.d(this.getTag(), sMessage);
	}
	
	/**
	  Write a Message message to the log.
	  
	  @return void
	  @param sMessage The message we want to write to the log.
	**/
	@Override public void logMessage(String sMessage)
	{
		if (this.checkLogLevel(LOG_MESSAGE))
			android.util.Log.i(this.getTag(), sMessage);
	}
	
	/**
	  Write a Error message to the log.
	  
	  @return void
	  @param sMessage The message we want to write to the log.
	**/
	@Override public void logError(String sMessage)
	{
		if (this.checkLogLevel(LOG_ERROR))
			android.util.Log.e(this.getTag(), sMessage);
	}
	
	/**
	  Write a Stack trace of the current exception to the log.
	  
	  @return void
	  @param aStackTrace The stack trace we want to write to the log.
	**/
	public void logStackTrace(StackTraceElement[] aStackTrace)
	{
		int	iCount;
		
		//* Check to make sure we have a valid pointer
		if (aStackTrace != null)
		{
			iCount = aStackTrace.length;
			for (int iIndex=0; iIndex < iCount; iIndex++)
			{
				this.logError(aStackTrace[iIndex].toString());
			}
		}	
	}
}
