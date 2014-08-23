
package com.emildiego.messageLog;

import java.lang.String;

/**
 * The baseLog is an abstract class used to build the foundation of all out logging classes.
 * 
 * @author <A HREF="mailto:emildiego@gmail.com">Emil Diego</A>
**/
abstract class baseLog {
   /**
    * Used to specify that we want to capture all level of messages in the log
   **/
	public final static int LOG_ALL		= 0;
	/**
    * Set the importance of a log message as Debug.
   **/
	public final static int LOG_DEBUG	= 1;
	/**
    * Set the importance of a log message as SQL.
   **/
	public final static int LOG_SQL		= 2;
	/**
    * Set the importance of a log message as message.
   **/
	public final static int LOG_MESSAGE = 3;
	/**
    * Set the importance of a log message as Error.
   **/
	public final static int LOG_ERROR	= 4;
	
	/**
    * A descriptive tag used to identify the origin of the message
   **/
	private String m_sTag;
	
	/**
    * The level of messages we want to log.
   **/
	private int m_iLogLevel;
	
	
	/**
	  The default constructor.  Used to initialize our instance.
	  We default m_iLogLevel to only capture error messages and set the tag to "messageLog".
	**/
	protected baseLog()
	{
		//* initilize the settings
		this.m_iLogLevel	= LOG_ERROR;
		this.m_sTag			= "messageLog";
	}
	
	/**
	  Used to initialize our instance with the specified tag and log level.
	  
	  @param sTag The tag used to identify the source of the message.
	  @param iLogLevel The level of messages we want to capture in the log.
	**/
	protected baseLog(String sTag, int iLogLevel)
	{
		this.m_iLogLevel = iLogLevel;
		this.m_sTag = sTag;
		
	}
	
	//*******************************************************************
	//* METHODS
	//*******************************************************************
	/**
	  Get the current level of the messages being logged.
	  
	  @return An integer corresponding to one of the values LOG_ALL, LOG_DEBUG, LOG_SQL, LOG_MESSAGE, LOG_ERROR
	**/
	protected int getLogLevel() { return this.m_iLogLevel; };
	/**
	  Set the current level of the messages being logged.
	  
	  @param iLogLeve The level of messages we want to capture; corresponding to one of the values LOG_ALL, LOG_DEBUG, LOG_SQL, LOG_MESSAGE, LOG_ERROR
	**/
	protected void setLogLevel(int iLogLevel) { this.m_iLogLevel = iLogLevel; };
	
	/**
	  Get the default descriptive tag being used for this log
	  
	  @return A String that contains the value of the descriptive tag.
	**/
	protected String getTag() { return this.m_sTag; };
	/**
	  Set the default descriptive tag being used for this log
	  
	  @param sTag A String that contains the value of the descriptive tag.
	**/
	protected void setTag(String sTag) { this.m_sTag = sTag; };
	

	/**
	  Check the specified log level against the currently set level to see if 
	  we want to capture this message or not.
	  
	  @return True if the specified log level should be captured, false if it shouldn't.
	**/
	protected boolean checkLogLevel(int iLogLevel)
	{
		if (iLogLevel >= this.m_iLogLevel)
		{
			//* We want to log the current message
			return true;
		}
		return false;
	}
	

	//*******************************************************************
	//* ABSTRACT CLASSES
	//*******************************************************************
	/**
	  An abstract class that sends a Debug message to the log.
	  
	  @param sMessage The message we want to send to the log.
	**/
	abstract void logDebug(String sMessage);
	
	/**
	  An abstract class that sends a SQL message to the log.
	  
	  @param sMessage The message we want to send to the log.
	**/
	abstract void logSQL(String sMessage);
	
	/**
	  An abstract class that sends a Message message to the log.
	  
	  @param sMessage The message we want to send to the log.
	**/
	abstract void logMessage(String sMessage);
	
	/**
	  An abstract class that sends a Error message to the log.
	  
	  @param sMessage The message we want to send to the log.
	**/
	abstract void logError(String sMessage);
}
