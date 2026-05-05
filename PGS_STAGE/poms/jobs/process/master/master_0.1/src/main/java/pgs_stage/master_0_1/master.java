// ============================================================================
//
// Copyright (c) 2006-2015, Talend SA
//
// Ce code source a été automatiquement généré par_Talend Open Studio for Data Integration
// / Soumis à la Licence Apache, Version 2.0 (la "Licence") ;
// votre utilisation de ce fichier doit respecter les termes de la Licence.
// Vous pouvez obtenir une copie de la Licence sur
// http://www.apache.org/licenses/LICENSE-2.0
// 
// Sauf lorsqu'explicitement prévu par la loi en vigueur ou accepté par écrit, le logiciel
// distribué sous la Licence est distribué "TEL QUEL",
// SANS GARANTIE OU CONDITION D'AUCUNE SORTE, expresse ou implicite.
// Consultez la Licence pour connaître la terminologie spécifique régissant les autorisations et
// les limites prévues par la Licence.


package pgs_stage.master_0_1;

import routines.Numeric;
import routines.DataOperation;
import routines.TalendDataGenerator;
import routines.TalendStringUtil;
import routines.TalendString;
import routines.StringHandling;
import routines.Relational;
import routines.TalendDate;
import routines.Mathematical;
import routines.system.*;
import routines.system.api.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.Comparator;
 





@SuppressWarnings("unused")

/**
 * Job: master Purpose: <br>
 * Description:  <br>
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status 
 */
public class master implements TalendJob {

protected static void logIgnoredError(String message, Throwable cause) {
       System.err.println(message);
       if (cause != null) {
               cause.printStackTrace();
       }

}


	public final Object obj = new Object();

	// for transmiting parameters purpose
	private Object valueObject = null;

	public Object getValueObject() {
		return this.valueObject;
	}

	public void setValueObject(Object valueObject) {
		this.valueObject = valueObject;
	}
	
	private final static String defaultCharset = java.nio.charset.Charset.defaultCharset().name();

	
	private final static String utf8Charset = "UTF-8";
	//contains type for every context property
	public class PropertiesWithType extends java.util.Properties {
		private static final long serialVersionUID = 1L;
		private java.util.Map<String,String> propertyTypes = new java.util.HashMap<>();
		
		public PropertiesWithType(java.util.Properties properties){
			super(properties);
		}
		public PropertiesWithType(){
			super();
		}
		
		public void setContextType(String key, String type) {
			propertyTypes.put(key,type);
		}
	
		public String getContextType(String key) {
			return propertyTypes.get(key);
		}
	}
	
	// create and load default properties
	private java.util.Properties defaultProps = new java.util.Properties();
	// create application properties with default
	public class ContextProperties extends PropertiesWithType {

		private static final long serialVersionUID = 1L;

		public ContextProperties(java.util.Properties properties){
			super(properties);
		}
		public ContextProperties(){
			super();
		}

		public void synchronizeContext(){
			
		}
		
		//if the stored or passed value is "<TALEND_NULL>" string, it mean null
		public String getStringValue(String key) {
			String origin_value = this.getProperty(key);
			if(NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY.equals(origin_value)) {
				return null;
			}
			return origin_value;
		}

	}
	protected ContextProperties context = new ContextProperties(); // will be instanciated by MS.
	public ContextProperties getContext() {
		return this.context;
	}
	private final String jobVersion = "0.1";
	private final String jobName = "master";
	private final String projectName = "PGS_STAGE";
	public Integer errorCode = null;
	private String currentComponent = "";
	
		private final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();
        private final static java.util.Map<String, Object> junitGlobalMap = new java.util.HashMap<String, Object>();
	
		private final java.util.Map<String, Long> start_Hash = new java.util.HashMap<String, Long>();
		private final java.util.Map<String, Long> end_Hash = new java.util.HashMap<String, Long>();
		private final java.util.Map<String, Boolean> ok_Hash = new java.util.HashMap<String, Boolean>();
		public  final java.util.List<String[]> globalBuffer = new java.util.ArrayList<String[]>();
	

private RunStat runStat = new RunStat();

	// OSGi DataSource
	private final static String KEY_DB_DATASOURCES = "KEY_DB_DATASOURCES";
	
	private final static String KEY_DB_DATASOURCES_RAW = "KEY_DB_DATASOURCES_RAW";

	public void setDataSources(java.util.Map<String, javax.sql.DataSource> dataSources) {
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		for (java.util.Map.Entry<String, javax.sql.DataSource> dataSourceEntry : dataSources.entrySet()) {
			talendDataSources.put(dataSourceEntry.getKey(), new routines.system.TalendDataSource(dataSourceEntry.getValue()));
		}
		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}
	
	public void setDataSourceReferences(List serviceReferences) throws Exception{
		
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		java.util.Map<String, javax.sql.DataSource> dataSources = new java.util.HashMap<String, javax.sql.DataSource>();
		
		for (java.util.Map.Entry<String, javax.sql.DataSource> entry : BundleUtils.getServices(serviceReferences,  javax.sql.DataSource.class).entrySet()) {
                    dataSources.put(entry.getKey(), entry.getValue());
                    talendDataSources.put(entry.getKey(), new routines.system.TalendDataSource(entry.getValue()));
		}

		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}


private final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
private final java.io.PrintStream errorMessagePS = new java.io.PrintStream(new java.io.BufferedOutputStream(baos));

public String getExceptionStackTrace() {
	if ("failure".equals(this.getStatus())) {
		errorMessagePS.flush();
		return baos.toString();
	}
	return null;
}

private Exception exception;

public Exception getException() {
	if ("failure".equals(this.getStatus())) {
		return this.exception;
	}
	return null;
}

private class TalendException extends Exception {

	private static final long serialVersionUID = 1L;

	private java.util.Map<String, Object> globalMap = null;
	private Exception e = null;
	private String currentComponent = null;
	private String virtualComponentName = null;
	
	public void setVirtualComponentName (String virtualComponentName){
		this.virtualComponentName = virtualComponentName;
	}

	private TalendException(Exception e, String errorComponent, final java.util.Map<String, Object> globalMap) {
		this.currentComponent= errorComponent;
		this.globalMap = globalMap;
		this.e = e;
	}

	public Exception getException() {
		return this.e;
	}

	public String getCurrentComponent() {
		return this.currentComponent;
	}

	
    public String getExceptionCauseMessage(Exception e){
        Throwable cause = e;
        String message = null;
        int i = 10;
        while (null != cause && 0 < i--) {
            message = cause.getMessage();
            if (null == message) {
                cause = cause.getCause();
            } else {
                break;          
            }
        }
        if (null == message) {
            message = e.getClass().getName();
        }   
        return message;
    }

	@Override
	public void printStackTrace() {
		if (!(e instanceof TalendException || e instanceof TDieException)) {
			if(virtualComponentName!=null && currentComponent.indexOf(virtualComponentName+"_")==0){
				globalMap.put(virtualComponentName+"_ERROR_MESSAGE",getExceptionCauseMessage(e));
			}
			globalMap.put(currentComponent+"_ERROR_MESSAGE",getExceptionCauseMessage(e));
			System.err.println("Exception in component " + currentComponent + " (" + jobName + ")");
		}
		if (!(e instanceof TDieException)) {
			if(e instanceof TalendException){
				e.printStackTrace();
			} else {
				e.printStackTrace();
				e.printStackTrace(errorMessagePS);
				master.this.exception = e;
			}
		}
		if (!(e instanceof TalendException)) {
		try {
			for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
				if (m.getName().compareTo(currentComponent + "_error") == 0) {
					m.invoke(master.this, new Object[] { e , currentComponent, globalMap});
					break;
				}
			}

			if(!(e instanceof TDieException)){
			}
		} catch (Exception e) {
			this.e.printStackTrace();
		}
		}
	}
}

			public void tRunJob_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
					tRunJob_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tRunJob_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
					tRunJob_2_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tRunJob_3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
					tRunJob_3_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tRunJob_4_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
					tRunJob_4_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tRunJob_5_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
					tRunJob_5_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tRunJob_6_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
					tRunJob_6_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tRunJob_7_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
					tRunJob_7_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tRunJob_8_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
					tRunJob_8_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tSendMail_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tSendMail_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tSendMail_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tSendMail_2_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tSendMail_3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tSendMail_3_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tSendMail_4_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tSendMail_4_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tSendMail_5_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tSendMail_5_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tSendMail_6_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tSendMail_6_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tSendMail_7_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tSendMail_7_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tSendMail_8_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tSendMail_8_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tSendMail_9_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tSendMail_9_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tRunJob_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "ERROR", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

				try {
					
						if(this.execStat){
							runStat.updateStatOnConnection("OnSubjobError8", 0, "error");
						}
					
					errorCode = null;
					tSendMail_9Process(globalMap);
					if (!"failure".equals(status)) {
						status = "end";
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			public void tRunJob_2_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "ERROR", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

				try {
					
						if(this.execStat){
							runStat.updateStatOnConnection("OnSubjobError7", 0, "error");
						}
					
					errorCode = null;
					tSendMail_8Process(globalMap);
					if (!"failure".equals(status)) {
						status = "end";
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			public void tRunJob_3_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "ERROR", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

				try {
					
						if(this.execStat){
							runStat.updateStatOnConnection("OnSubjobError6", 0, "error");
						}
					
					errorCode = null;
					tSendMail_7Process(globalMap);
					if (!"failure".equals(status)) {
						status = "end";
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			public void tRunJob_4_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "ERROR", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

				try {
					
						if(this.execStat){
							runStat.updateStatOnConnection("OnSubjobError5", 0, "error");
						}
					
					errorCode = null;
					tSendMail_6Process(globalMap);
					if (!"failure".equals(status)) {
						status = "end";
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			public void tRunJob_5_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "ERROR", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

				try {
					
						if(this.execStat){
							runStat.updateStatOnConnection("OnSubjobError4", 0, "error");
						}
					
					errorCode = null;
					tSendMail_5Process(globalMap);
					if (!"failure".equals(status)) {
						status = "end";
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			public void tRunJob_6_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "ERROR", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

				try {
					
						if(this.execStat){
							runStat.updateStatOnConnection("OnSubjobError3", 0, "error");
						}
					
					errorCode = null;
					tSendMail_4Process(globalMap);
					if (!"failure".equals(status)) {
						status = "end";
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			public void tRunJob_7_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "ERROR", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

				try {
					
						if(this.execStat){
							runStat.updateStatOnConnection("OnSubjobError2", 0, "error");
						}
					
					errorCode = null;
					tSendMail_3Process(globalMap);
					if (!"failure".equals(status)) {
						status = "end";
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			public void tRunJob_8_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "ERROR", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

				try {
					
						if(this.execStat){
							runStat.updateStatOnConnection("OnSubjobError1", 0, "error");
						}
					
					errorCode = null;
					tSendMail_2Process(globalMap);
					if (!"failure".equals(status)) {
						status = "end";
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			public void tSendMail_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tSendMail_2_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tSendMail_3_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tSendMail_4_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tSendMail_5_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tSendMail_6_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tSendMail_7_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tSendMail_8_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tSendMail_9_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
	





public void tRunJob_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tRunJob_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		


	
	/**
	 * [tRunJob_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tRunJob_1", false);
		start_Hash.put("tRunJob_1", System.currentTimeMillis());
		
	
	currentComponent="tRunJob_1";

	
		int tos_count_tRunJob_1 = 0;
		


 



/**
 * [tRunJob_1 begin ] stop
 */
	
	/**
	 * [tRunJob_1 main ] start
	 */

	

	
	
	currentComponent="tRunJob_1";

	
	java.util.List<String> paraList_tRunJob_1 = new java.util.ArrayList<String>();
	
	        				paraList_tRunJob_1.add("--father_pid="+pid);
	      			
	        				paraList_tRunJob_1.add("--root_pid="+rootPid);
	      			
	        				paraList_tRunJob_1.add("--father_node=tRunJob_1");
	      			
	        				paraList_tRunJob_1.add("--context=Default");
	      			
		if(enableLogStash){
			paraList_tRunJob_1.add("--audit.enabled="+enableLogStash);
		}
		
	//for feature:10589
	
		paraList_tRunJob_1.add("--stat_port=" + portStats);
	

	if(resuming_logs_dir_path != null){
		paraList_tRunJob_1.add("--resuming_logs_dir_path=" + resuming_logs_dir_path);
	}
	String childResumePath_tRunJob_1 = ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path);
	String tRunJobName_tRunJob_1 = ResumeUtil.getRighttRunJob(resuming_checkpoint_path);
	if("tRunJob_1".equals(tRunJobName_tRunJob_1) && childResumePath_tRunJob_1 != null){
		paraList_tRunJob_1.add("--resuming_checkpoint_path=" + ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path));
	}
	paraList_tRunJob_1.add("--parent_part_launcher=JOB:" + jobName + "/NODE:tRunJob_1");
	
	java.util.Map<String, Object> parentContextMap_tRunJob_1 = new java.util.HashMap<String, Object>();

	

	Object obj_tRunJob_1 = null;

	
	
		pgs_stage.dim_book_inventory_history_0_1.DIM_BOOK_INVENTORY_HISTORY childJob_tRunJob_1 = new pgs_stage.dim_book_inventory_history_0_1.DIM_BOOK_INVENTORY_HISTORY();
	    // pass DataSources
	    java.util.Map<String, routines.system.TalendDataSource> talendDataSources_tRunJob_1 = (java.util.Map<String, routines.system.TalendDataSource>) globalMap
	            .get(KEY_DB_DATASOURCES);
	    if (null != talendDataSources_tRunJob_1) {
	        java.util.Map<String, javax.sql.DataSource> dataSources_tRunJob_1 = new java.util.HashMap<String, javax.sql.DataSource>();
	        for (java.util.Map.Entry<String, routines.system.TalendDataSource> talendDataSourceEntry_tRunJob_1 : talendDataSources_tRunJob_1
			        .entrySet()) {
	            dataSources_tRunJob_1.put(talendDataSourceEntry_tRunJob_1.getKey(),
	                    talendDataSourceEntry_tRunJob_1.getValue().getRawDataSource());
	        }
	        childJob_tRunJob_1.setDataSources(dataSources_tRunJob_1);
	    }
		  
			childJob_tRunJob_1.parentContextMap = parentContextMap_tRunJob_1;
		  
		
		String[][] childReturn_tRunJob_1 = childJob_tRunJob_1.runJob((String[]) paraList_tRunJob_1.toArray(new String[paraList_tRunJob_1.size()]));
		
            if(childJob_tRunJob_1.getErrorCode() == null){
                globalMap.put("tRunJob_1_CHILD_RETURN_CODE", childJob_tRunJob_1.getStatus() != null && ("failure").equals(childJob_tRunJob_1.getStatus()) ? 1 : 0);
            }else{
                globalMap.put("tRunJob_1_CHILD_RETURN_CODE", childJob_tRunJob_1.getErrorCode());
            }
            if (childJob_tRunJob_1.getExceptionStackTrace() != null) {
                globalMap.put("tRunJob_1_CHILD_EXCEPTION_STACKTRACE", childJob_tRunJob_1.getExceptionStackTrace());
            }
                    errorCode = childJob_tRunJob_1.getErrorCode();
                if (childJob_tRunJob_1.getErrorCode() != null || ("failure").equals(childJob_tRunJob_1.getStatus())) {
                    java.lang.Exception ce_tRunJob_1 = childJob_tRunJob_1.getException();
                    throw new RuntimeException("Child job running failed.\n" + ((ce_tRunJob_1!=null) ? (ce_tRunJob_1.getClass().getName() + ": " + ce_tRunJob_1.getMessage()) : ""));
                }

 


	tos_count_tRunJob_1++;

/**
 * [tRunJob_1 main ] stop
 */
	
	/**
	 * [tRunJob_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tRunJob_1";

	

 



/**
 * [tRunJob_1 process_data_begin ] stop
 */
	
	/**
	 * [tRunJob_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tRunJob_1";

	

 



/**
 * [tRunJob_1 process_data_end ] stop
 */
	
	/**
	 * [tRunJob_1 end ] start
	 */

	

	
	
	currentComponent="tRunJob_1";

	

 

ok_Hash.put("tRunJob_1", true);
end_Hash.put("tRunJob_1", System.currentTimeMillis());




/**
 * [tRunJob_1 end ] stop
 */
				}//end the resume

				
				    			if(resumeEntryMethodName == null || globalResumeTicket){
				    				resumeUtil.addLog("CHECKPOINT", "CONNECTION:SUBJOB_OK:tRunJob_1:OnSubjobOk", "", Thread.currentThread().getId() + "", "", "", "", "", "");
								}	    				    			
					    	
								if(execStat){    	
									runStat.updateStatOnConnection("OnSubjobOk1", 0, "ok");
								} 
							
							tRunJob_2Process(globalMap); 
						



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tRunJob_1 finally ] start
	 */

	

	
	
	currentComponent="tRunJob_1";

	

 



/**
 * [tRunJob_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tRunJob_1_SUBPROCESS_STATE", 1);
	}
	

public void tRunJob_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tRunJob_2_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		


	
	/**
	 * [tRunJob_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tRunJob_2", false);
		start_Hash.put("tRunJob_2", System.currentTimeMillis());
		
	
	currentComponent="tRunJob_2";

	
		int tos_count_tRunJob_2 = 0;
		


 



/**
 * [tRunJob_2 begin ] stop
 */
	
	/**
	 * [tRunJob_2 main ] start
	 */

	

	
	
	currentComponent="tRunJob_2";

	
	java.util.List<String> paraList_tRunJob_2 = new java.util.ArrayList<String>();
	
	        				paraList_tRunJob_2.add("--father_pid="+pid);
	      			
	        				paraList_tRunJob_2.add("--root_pid="+rootPid);
	      			
	        				paraList_tRunJob_2.add("--father_node=tRunJob_2");
	      			
	        				paraList_tRunJob_2.add("--context=Default");
	      			
		if(enableLogStash){
			paraList_tRunJob_2.add("--audit.enabled="+enableLogStash);
		}
		
	//for feature:10589
	
		paraList_tRunJob_2.add("--stat_port=" + portStats);
	

	if(resuming_logs_dir_path != null){
		paraList_tRunJob_2.add("--resuming_logs_dir_path=" + resuming_logs_dir_path);
	}
	String childResumePath_tRunJob_2 = ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path);
	String tRunJobName_tRunJob_2 = ResumeUtil.getRighttRunJob(resuming_checkpoint_path);
	if("tRunJob_2".equals(tRunJobName_tRunJob_2) && childResumePath_tRunJob_2 != null){
		paraList_tRunJob_2.add("--resuming_checkpoint_path=" + ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path));
	}
	paraList_tRunJob_2.add("--parent_part_launcher=JOB:" + jobName + "/NODE:tRunJob_2");
	
	java.util.Map<String, Object> parentContextMap_tRunJob_2 = new java.util.HashMap<String, Object>();

	

	Object obj_tRunJob_2 = null;

	
	
		pgs_stage.dim_gain_loss_history_0_1.DIM_GAIN_LOSS_HISTORY childJob_tRunJob_2 = new pgs_stage.dim_gain_loss_history_0_1.DIM_GAIN_LOSS_HISTORY();
	    // pass DataSources
	    java.util.Map<String, routines.system.TalendDataSource> talendDataSources_tRunJob_2 = (java.util.Map<String, routines.system.TalendDataSource>) globalMap
	            .get(KEY_DB_DATASOURCES);
	    if (null != talendDataSources_tRunJob_2) {
	        java.util.Map<String, javax.sql.DataSource> dataSources_tRunJob_2 = new java.util.HashMap<String, javax.sql.DataSource>();
	        for (java.util.Map.Entry<String, routines.system.TalendDataSource> talendDataSourceEntry_tRunJob_2 : talendDataSources_tRunJob_2
			        .entrySet()) {
	            dataSources_tRunJob_2.put(talendDataSourceEntry_tRunJob_2.getKey(),
	                    talendDataSourceEntry_tRunJob_2.getValue().getRawDataSource());
	        }
	        childJob_tRunJob_2.setDataSources(dataSources_tRunJob_2);
	    }
		  
			childJob_tRunJob_2.parentContextMap = parentContextMap_tRunJob_2;
		  
		
		String[][] childReturn_tRunJob_2 = childJob_tRunJob_2.runJob((String[]) paraList_tRunJob_2.toArray(new String[paraList_tRunJob_2.size()]));
		
            if(childJob_tRunJob_2.getErrorCode() == null){
                globalMap.put("tRunJob_2_CHILD_RETURN_CODE", childJob_tRunJob_2.getStatus() != null && ("failure").equals(childJob_tRunJob_2.getStatus()) ? 1 : 0);
            }else{
                globalMap.put("tRunJob_2_CHILD_RETURN_CODE", childJob_tRunJob_2.getErrorCode());
            }
            if (childJob_tRunJob_2.getExceptionStackTrace() != null) {
                globalMap.put("tRunJob_2_CHILD_EXCEPTION_STACKTRACE", childJob_tRunJob_2.getExceptionStackTrace());
            }
                    errorCode = childJob_tRunJob_2.getErrorCode();
                if (childJob_tRunJob_2.getErrorCode() != null || ("failure").equals(childJob_tRunJob_2.getStatus())) {
                    java.lang.Exception ce_tRunJob_2 = childJob_tRunJob_2.getException();
                    throw new RuntimeException("Child job running failed.\n" + ((ce_tRunJob_2!=null) ? (ce_tRunJob_2.getClass().getName() + ": " + ce_tRunJob_2.getMessage()) : ""));
                }

 


	tos_count_tRunJob_2++;

/**
 * [tRunJob_2 main ] stop
 */
	
	/**
	 * [tRunJob_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tRunJob_2";

	

 



/**
 * [tRunJob_2 process_data_begin ] stop
 */
	
	/**
	 * [tRunJob_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tRunJob_2";

	

 



/**
 * [tRunJob_2 process_data_end ] stop
 */
	
	/**
	 * [tRunJob_2 end ] start
	 */

	

	
	
	currentComponent="tRunJob_2";

	

 

ok_Hash.put("tRunJob_2", true);
end_Hash.put("tRunJob_2", System.currentTimeMillis());




/**
 * [tRunJob_2 end ] stop
 */
				}//end the resume

				
				    			if(resumeEntryMethodName == null || globalResumeTicket){
				    				resumeUtil.addLog("CHECKPOINT", "CONNECTION:SUBJOB_OK:tRunJob_2:OnSubjobOk", "", Thread.currentThread().getId() + "", "", "", "", "", "");
								}	    				    			
					    	
								if(execStat){    	
									runStat.updateStatOnConnection("OnSubjobOk2", 0, "ok");
								} 
							
							tRunJob_3Process(globalMap); 
						



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tRunJob_2 finally ] start
	 */

	

	
	
	currentComponent="tRunJob_2";

	

 



/**
 * [tRunJob_2 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tRunJob_2_SUBPROCESS_STATE", 1);
	}
	

public void tRunJob_3Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tRunJob_3_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		


	
	/**
	 * [tRunJob_3 begin ] start
	 */

	

	
		
		ok_Hash.put("tRunJob_3", false);
		start_Hash.put("tRunJob_3", System.currentTimeMillis());
		
	
	currentComponent="tRunJob_3";

	
		int tos_count_tRunJob_3 = 0;
		


 



/**
 * [tRunJob_3 begin ] stop
 */
	
	/**
	 * [tRunJob_3 main ] start
	 */

	

	
	
	currentComponent="tRunJob_3";

	
	java.util.List<String> paraList_tRunJob_3 = new java.util.ArrayList<String>();
	
	        				paraList_tRunJob_3.add("--father_pid="+pid);
	      			
	        				paraList_tRunJob_3.add("--root_pid="+rootPid);
	      			
	        				paraList_tRunJob_3.add("--father_node=tRunJob_3");
	      			
	        				paraList_tRunJob_3.add("--context=Default");
	      			
		if(enableLogStash){
			paraList_tRunJob_3.add("--audit.enabled="+enableLogStash);
		}
		
	//for feature:10589
	
		paraList_tRunJob_3.add("--stat_port=" + portStats);
	

	if(resuming_logs_dir_path != null){
		paraList_tRunJob_3.add("--resuming_logs_dir_path=" + resuming_logs_dir_path);
	}
	String childResumePath_tRunJob_3 = ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path);
	String tRunJobName_tRunJob_3 = ResumeUtil.getRighttRunJob(resuming_checkpoint_path);
	if("tRunJob_3".equals(tRunJobName_tRunJob_3) && childResumePath_tRunJob_3 != null){
		paraList_tRunJob_3.add("--resuming_checkpoint_path=" + ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path));
	}
	paraList_tRunJob_3.add("--parent_part_launcher=JOB:" + jobName + "/NODE:tRunJob_3");
	
	java.util.Map<String, Object> parentContextMap_tRunJob_3 = new java.util.HashMap<String, Object>();

	

	Object obj_tRunJob_3 = null;

	
	
		pgs_stage.dim_meter_history_0_1.DIM_METER_HISTORY childJob_tRunJob_3 = new pgs_stage.dim_meter_history_0_1.DIM_METER_HISTORY();
	    // pass DataSources
	    java.util.Map<String, routines.system.TalendDataSource> talendDataSources_tRunJob_3 = (java.util.Map<String, routines.system.TalendDataSource>) globalMap
	            .get(KEY_DB_DATASOURCES);
	    if (null != talendDataSources_tRunJob_3) {
	        java.util.Map<String, javax.sql.DataSource> dataSources_tRunJob_3 = new java.util.HashMap<String, javax.sql.DataSource>();
	        for (java.util.Map.Entry<String, routines.system.TalendDataSource> talendDataSourceEntry_tRunJob_3 : talendDataSources_tRunJob_3
			        .entrySet()) {
	            dataSources_tRunJob_3.put(talendDataSourceEntry_tRunJob_3.getKey(),
	                    talendDataSourceEntry_tRunJob_3.getValue().getRawDataSource());
	        }
	        childJob_tRunJob_3.setDataSources(dataSources_tRunJob_3);
	    }
		  
			childJob_tRunJob_3.parentContextMap = parentContextMap_tRunJob_3;
		  
		
		String[][] childReturn_tRunJob_3 = childJob_tRunJob_3.runJob((String[]) paraList_tRunJob_3.toArray(new String[paraList_tRunJob_3.size()]));
		
            if(childJob_tRunJob_3.getErrorCode() == null){
                globalMap.put("tRunJob_3_CHILD_RETURN_CODE", childJob_tRunJob_3.getStatus() != null && ("failure").equals(childJob_tRunJob_3.getStatus()) ? 1 : 0);
            }else{
                globalMap.put("tRunJob_3_CHILD_RETURN_CODE", childJob_tRunJob_3.getErrorCode());
            }
            if (childJob_tRunJob_3.getExceptionStackTrace() != null) {
                globalMap.put("tRunJob_3_CHILD_EXCEPTION_STACKTRACE", childJob_tRunJob_3.getExceptionStackTrace());
            }
                    errorCode = childJob_tRunJob_3.getErrorCode();
                if (childJob_tRunJob_3.getErrorCode() != null || ("failure").equals(childJob_tRunJob_3.getStatus())) {
                    java.lang.Exception ce_tRunJob_3 = childJob_tRunJob_3.getException();
                    throw new RuntimeException("Child job running failed.\n" + ((ce_tRunJob_3!=null) ? (ce_tRunJob_3.getClass().getName() + ": " + ce_tRunJob_3.getMessage()) : ""));
                }

 


	tos_count_tRunJob_3++;

/**
 * [tRunJob_3 main ] stop
 */
	
	/**
	 * [tRunJob_3 process_data_begin ] start
	 */

	

	
	
	currentComponent="tRunJob_3";

	

 



/**
 * [tRunJob_3 process_data_begin ] stop
 */
	
	/**
	 * [tRunJob_3 process_data_end ] start
	 */

	

	
	
	currentComponent="tRunJob_3";

	

 



/**
 * [tRunJob_3 process_data_end ] stop
 */
	
	/**
	 * [tRunJob_3 end ] start
	 */

	

	
	
	currentComponent="tRunJob_3";

	

 

ok_Hash.put("tRunJob_3", true);
end_Hash.put("tRunJob_3", System.currentTimeMillis());




/**
 * [tRunJob_3 end ] stop
 */
				}//end the resume

				
				    			if(resumeEntryMethodName == null || globalResumeTicket){
				    				resumeUtil.addLog("CHECKPOINT", "CONNECTION:SUBJOB_OK:tRunJob_3:OnSubjobOk", "", Thread.currentThread().getId() + "", "", "", "", "", "");
								}	    				    			
					    	
								if(execStat){    	
									runStat.updateStatOnConnection("OnSubjobOk3", 0, "ok");
								} 
							
							tRunJob_4Process(globalMap); 
						



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tRunJob_3 finally ] start
	 */

	

	
	
	currentComponent="tRunJob_3";

	

 



/**
 * [tRunJob_3 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tRunJob_3_SUBPROCESS_STATE", 1);
	}
	

public void tRunJob_4Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tRunJob_4_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		


	
	/**
	 * [tRunJob_4 begin ] start
	 */

	

	
		
		ok_Hash.put("tRunJob_4", false);
		start_Hash.put("tRunJob_4", System.currentTimeMillis());
		
	
	currentComponent="tRunJob_4";

	
		int tos_count_tRunJob_4 = 0;
		


 



/**
 * [tRunJob_4 begin ] stop
 */
	
	/**
	 * [tRunJob_4 main ] start
	 */

	

	
	
	currentComponent="tRunJob_4";

	
	java.util.List<String> paraList_tRunJob_4 = new java.util.ArrayList<String>();
	
	        				paraList_tRunJob_4.add("--father_pid="+pid);
	      			
	        				paraList_tRunJob_4.add("--root_pid="+rootPid);
	      			
	        				paraList_tRunJob_4.add("--father_node=tRunJob_4");
	      			
	        				paraList_tRunJob_4.add("--context=Default");
	      			
		if(enableLogStash){
			paraList_tRunJob_4.add("--audit.enabled="+enableLogStash);
		}
		
	//for feature:10589
	
		paraList_tRunJob_4.add("--stat_port=" + portStats);
	

	if(resuming_logs_dir_path != null){
		paraList_tRunJob_4.add("--resuming_logs_dir_path=" + resuming_logs_dir_path);
	}
	String childResumePath_tRunJob_4 = ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path);
	String tRunJobName_tRunJob_4 = ResumeUtil.getRighttRunJob(resuming_checkpoint_path);
	if("tRunJob_4".equals(tRunJobName_tRunJob_4) && childResumePath_tRunJob_4 != null){
		paraList_tRunJob_4.add("--resuming_checkpoint_path=" + ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path));
	}
	paraList_tRunJob_4.add("--parent_part_launcher=JOB:" + jobName + "/NODE:tRunJob_4");
	
	java.util.Map<String, Object> parentContextMap_tRunJob_4 = new java.util.HashMap<String, Object>();

	

	Object obj_tRunJob_4 = null;

	
	
		pgs_stage.dim_orders_tank_inv_0_1.DIM_ORDERS_TANK_INV childJob_tRunJob_4 = new pgs_stage.dim_orders_tank_inv_0_1.DIM_ORDERS_TANK_INV();
	    // pass DataSources
	    java.util.Map<String, routines.system.TalendDataSource> talendDataSources_tRunJob_4 = (java.util.Map<String, routines.system.TalendDataSource>) globalMap
	            .get(KEY_DB_DATASOURCES);
	    if (null != talendDataSources_tRunJob_4) {
	        java.util.Map<String, javax.sql.DataSource> dataSources_tRunJob_4 = new java.util.HashMap<String, javax.sql.DataSource>();
	        for (java.util.Map.Entry<String, routines.system.TalendDataSource> talendDataSourceEntry_tRunJob_4 : talendDataSources_tRunJob_4
			        .entrySet()) {
	            dataSources_tRunJob_4.put(talendDataSourceEntry_tRunJob_4.getKey(),
	                    talendDataSourceEntry_tRunJob_4.getValue().getRawDataSource());
	        }
	        childJob_tRunJob_4.setDataSources(dataSources_tRunJob_4);
	    }
		  
			childJob_tRunJob_4.parentContextMap = parentContextMap_tRunJob_4;
		  
		
		String[][] childReturn_tRunJob_4 = childJob_tRunJob_4.runJob((String[]) paraList_tRunJob_4.toArray(new String[paraList_tRunJob_4.size()]));
		
            if(childJob_tRunJob_4.getErrorCode() == null){
                globalMap.put("tRunJob_4_CHILD_RETURN_CODE", childJob_tRunJob_4.getStatus() != null && ("failure").equals(childJob_tRunJob_4.getStatus()) ? 1 : 0);
            }else{
                globalMap.put("tRunJob_4_CHILD_RETURN_CODE", childJob_tRunJob_4.getErrorCode());
            }
            if (childJob_tRunJob_4.getExceptionStackTrace() != null) {
                globalMap.put("tRunJob_4_CHILD_EXCEPTION_STACKTRACE", childJob_tRunJob_4.getExceptionStackTrace());
            }
                    errorCode = childJob_tRunJob_4.getErrorCode();
                if (childJob_tRunJob_4.getErrorCode() != null || ("failure").equals(childJob_tRunJob_4.getStatus())) {
                    java.lang.Exception ce_tRunJob_4 = childJob_tRunJob_4.getException();
                    throw new RuntimeException("Child job running failed.\n" + ((ce_tRunJob_4!=null) ? (ce_tRunJob_4.getClass().getName() + ": " + ce_tRunJob_4.getMessage()) : ""));
                }

 


	tos_count_tRunJob_4++;

/**
 * [tRunJob_4 main ] stop
 */
	
	/**
	 * [tRunJob_4 process_data_begin ] start
	 */

	

	
	
	currentComponent="tRunJob_4";

	

 



/**
 * [tRunJob_4 process_data_begin ] stop
 */
	
	/**
	 * [tRunJob_4 process_data_end ] start
	 */

	

	
	
	currentComponent="tRunJob_4";

	

 



/**
 * [tRunJob_4 process_data_end ] stop
 */
	
	/**
	 * [tRunJob_4 end ] start
	 */

	

	
	
	currentComponent="tRunJob_4";

	

 

ok_Hash.put("tRunJob_4", true);
end_Hash.put("tRunJob_4", System.currentTimeMillis());




/**
 * [tRunJob_4 end ] stop
 */
				}//end the resume

				
				    			if(resumeEntryMethodName == null || globalResumeTicket){
				    				resumeUtil.addLog("CHECKPOINT", "CONNECTION:SUBJOB_OK:tRunJob_4:OnSubjobOk", "", Thread.currentThread().getId() + "", "", "", "", "", "");
								}	    				    			
					    	
								if(execStat){    	
									runStat.updateStatOnConnection("OnSubjobOk4", 0, "ok");
								} 
							
							tRunJob_5Process(globalMap); 
						



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tRunJob_4 finally ] start
	 */

	

	
	
	currentComponent="tRunJob_4";

	

 



/**
 * [tRunJob_4 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tRunJob_4_SUBPROCESS_STATE", 1);
	}
	

public void tRunJob_5Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tRunJob_5_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		


	
	/**
	 * [tRunJob_5 begin ] start
	 */

	

	
		
		ok_Hash.put("tRunJob_5", false);
		start_Hash.put("tRunJob_5", System.currentTimeMillis());
		
	
	currentComponent="tRunJob_5";

	
		int tos_count_tRunJob_5 = 0;
		


 



/**
 * [tRunJob_5 begin ] stop
 */
	
	/**
	 * [tRunJob_5 main ] start
	 */

	

	
	
	currentComponent="tRunJob_5";

	
	java.util.List<String> paraList_tRunJob_5 = new java.util.ArrayList<String>();
	
	        				paraList_tRunJob_5.add("--father_pid="+pid);
	      			
	        				paraList_tRunJob_5.add("--root_pid="+rootPid);
	      			
	        				paraList_tRunJob_5.add("--father_node=tRunJob_5");
	      			
	        				paraList_tRunJob_5.add("--context=Default");
	      			
		if(enableLogStash){
			paraList_tRunJob_5.add("--audit.enabled="+enableLogStash);
		}
		
	//for feature:10589
	
		paraList_tRunJob_5.add("--stat_port=" + portStats);
	

	if(resuming_logs_dir_path != null){
		paraList_tRunJob_5.add("--resuming_logs_dir_path=" + resuming_logs_dir_path);
	}
	String childResumePath_tRunJob_5 = ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path);
	String tRunJobName_tRunJob_5 = ResumeUtil.getRighttRunJob(resuming_checkpoint_path);
	if("tRunJob_5".equals(tRunJobName_tRunJob_5) && childResumePath_tRunJob_5 != null){
		paraList_tRunJob_5.add("--resuming_checkpoint_path=" + ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path));
	}
	paraList_tRunJob_5.add("--parent_part_launcher=JOB:" + jobName + "/NODE:tRunJob_5");
	
	java.util.Map<String, Object> parentContextMap_tRunJob_5 = new java.util.HashMap<String, Object>();

	

	Object obj_tRunJob_5 = null;

	
	
		pgs_stage.dim_compartment_strapping_0_1.DIM_COMPARTMENT_STRAPPING childJob_tRunJob_5 = new pgs_stage.dim_compartment_strapping_0_1.DIM_COMPARTMENT_STRAPPING();
	    // pass DataSources
	    java.util.Map<String, routines.system.TalendDataSource> talendDataSources_tRunJob_5 = (java.util.Map<String, routines.system.TalendDataSource>) globalMap
	            .get(KEY_DB_DATASOURCES);
	    if (null != talendDataSources_tRunJob_5) {
	        java.util.Map<String, javax.sql.DataSource> dataSources_tRunJob_5 = new java.util.HashMap<String, javax.sql.DataSource>();
	        for (java.util.Map.Entry<String, routines.system.TalendDataSource> talendDataSourceEntry_tRunJob_5 : talendDataSources_tRunJob_5
			        .entrySet()) {
	            dataSources_tRunJob_5.put(talendDataSourceEntry_tRunJob_5.getKey(),
	                    talendDataSourceEntry_tRunJob_5.getValue().getRawDataSource());
	        }
	        childJob_tRunJob_5.setDataSources(dataSources_tRunJob_5);
	    }
		  
			childJob_tRunJob_5.parentContextMap = parentContextMap_tRunJob_5;
		  
		
		String[][] childReturn_tRunJob_5 = childJob_tRunJob_5.runJob((String[]) paraList_tRunJob_5.toArray(new String[paraList_tRunJob_5.size()]));
		
            if(childJob_tRunJob_5.getErrorCode() == null){
                globalMap.put("tRunJob_5_CHILD_RETURN_CODE", childJob_tRunJob_5.getStatus() != null && ("failure").equals(childJob_tRunJob_5.getStatus()) ? 1 : 0);
            }else{
                globalMap.put("tRunJob_5_CHILD_RETURN_CODE", childJob_tRunJob_5.getErrorCode());
            }
            if (childJob_tRunJob_5.getExceptionStackTrace() != null) {
                globalMap.put("tRunJob_5_CHILD_EXCEPTION_STACKTRACE", childJob_tRunJob_5.getExceptionStackTrace());
            }
                    errorCode = childJob_tRunJob_5.getErrorCode();
                if (childJob_tRunJob_5.getErrorCode() != null || ("failure").equals(childJob_tRunJob_5.getStatus())) {
                    java.lang.Exception ce_tRunJob_5 = childJob_tRunJob_5.getException();
                    throw new RuntimeException("Child job running failed.\n" + ((ce_tRunJob_5!=null) ? (ce_tRunJob_5.getClass().getName() + ": " + ce_tRunJob_5.getMessage()) : ""));
                }

 


	tos_count_tRunJob_5++;

/**
 * [tRunJob_5 main ] stop
 */
	
	/**
	 * [tRunJob_5 process_data_begin ] start
	 */

	

	
	
	currentComponent="tRunJob_5";

	

 



/**
 * [tRunJob_5 process_data_begin ] stop
 */
	
	/**
	 * [tRunJob_5 process_data_end ] start
	 */

	

	
	
	currentComponent="tRunJob_5";

	

 



/**
 * [tRunJob_5 process_data_end ] stop
 */
	
	/**
	 * [tRunJob_5 end ] start
	 */

	

	
	
	currentComponent="tRunJob_5";

	

 

ok_Hash.put("tRunJob_5", true);
end_Hash.put("tRunJob_5", System.currentTimeMillis());




/**
 * [tRunJob_5 end ] stop
 */
				}//end the resume

				
				    			if(resumeEntryMethodName == null || globalResumeTicket){
				    				resumeUtil.addLog("CHECKPOINT", "CONNECTION:SUBJOB_OK:tRunJob_5:OnSubjobOk", "", Thread.currentThread().getId() + "", "", "", "", "", "");
								}	    				    			
					    	
								if(execStat){    	
									runStat.updateStatOnConnection("OnSubjobOk5", 0, "ok");
								} 
							
							tRunJob_6Process(globalMap); 
						



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tRunJob_5 finally ] start
	 */

	

	
	
	currentComponent="tRunJob_5";

	

 



/**
 * [tRunJob_5 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tRunJob_5_SUBPROCESS_STATE", 1);
	}
	

public void tRunJob_6Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tRunJob_6_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		


	
	/**
	 * [tRunJob_6 begin ] start
	 */

	

	
		
		ok_Hash.put("tRunJob_6", false);
		start_Hash.put("tRunJob_6", System.currentTimeMillis());
		
	
	currentComponent="tRunJob_6";

	
		int tos_count_tRunJob_6 = 0;
		


 



/**
 * [tRunJob_6 begin ] stop
 */
	
	/**
	 * [tRunJob_6 main ] start
	 */

	

	
	
	currentComponent="tRunJob_6";

	
	java.util.List<String> paraList_tRunJob_6 = new java.util.ArrayList<String>();
	
	        				paraList_tRunJob_6.add("--father_pid="+pid);
	      			
	        				paraList_tRunJob_6.add("--root_pid="+rootPid);
	      			
	        				paraList_tRunJob_6.add("--father_node=tRunJob_6");
	      			
	        				paraList_tRunJob_6.add("--context=Default");
	      			
		if(enableLogStash){
			paraList_tRunJob_6.add("--audit.enabled="+enableLogStash);
		}
		
	//for feature:10589
	
		paraList_tRunJob_6.add("--stat_port=" + portStats);
	

	if(resuming_logs_dir_path != null){
		paraList_tRunJob_6.add("--resuming_logs_dir_path=" + resuming_logs_dir_path);
	}
	String childResumePath_tRunJob_6 = ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path);
	String tRunJobName_tRunJob_6 = ResumeUtil.getRighttRunJob(resuming_checkpoint_path);
	if("tRunJob_6".equals(tRunJobName_tRunJob_6) && childResumePath_tRunJob_6 != null){
		paraList_tRunJob_6.add("--resuming_checkpoint_path=" + ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path));
	}
	paraList_tRunJob_6.add("--parent_part_launcher=JOB:" + jobName + "/NODE:tRunJob_6");
	
	java.util.Map<String, Object> parentContextMap_tRunJob_6 = new java.util.HashMap<String, Object>();

	

	Object obj_tRunJob_6 = null;

	
	
		pgs_stage.dim_tank_0_1.DIM_TANK childJob_tRunJob_6 = new pgs_stage.dim_tank_0_1.DIM_TANK();
	    // pass DataSources
	    java.util.Map<String, routines.system.TalendDataSource> talendDataSources_tRunJob_6 = (java.util.Map<String, routines.system.TalendDataSource>) globalMap
	            .get(KEY_DB_DATASOURCES);
	    if (null != talendDataSources_tRunJob_6) {
	        java.util.Map<String, javax.sql.DataSource> dataSources_tRunJob_6 = new java.util.HashMap<String, javax.sql.DataSource>();
	        for (java.util.Map.Entry<String, routines.system.TalendDataSource> talendDataSourceEntry_tRunJob_6 : talendDataSources_tRunJob_6
			        .entrySet()) {
	            dataSources_tRunJob_6.put(talendDataSourceEntry_tRunJob_6.getKey(),
	                    talendDataSourceEntry_tRunJob_6.getValue().getRawDataSource());
	        }
	        childJob_tRunJob_6.setDataSources(dataSources_tRunJob_6);
	    }
		  
			childJob_tRunJob_6.parentContextMap = parentContextMap_tRunJob_6;
		  
		
		String[][] childReturn_tRunJob_6 = childJob_tRunJob_6.runJob((String[]) paraList_tRunJob_6.toArray(new String[paraList_tRunJob_6.size()]));
		
            if(childJob_tRunJob_6.getErrorCode() == null){
                globalMap.put("tRunJob_6_CHILD_RETURN_CODE", childJob_tRunJob_6.getStatus() != null && ("failure").equals(childJob_tRunJob_6.getStatus()) ? 1 : 0);
            }else{
                globalMap.put("tRunJob_6_CHILD_RETURN_CODE", childJob_tRunJob_6.getErrorCode());
            }
            if (childJob_tRunJob_6.getExceptionStackTrace() != null) {
                globalMap.put("tRunJob_6_CHILD_EXCEPTION_STACKTRACE", childJob_tRunJob_6.getExceptionStackTrace());
            }
                    errorCode = childJob_tRunJob_6.getErrorCode();
                if (childJob_tRunJob_6.getErrorCode() != null || ("failure").equals(childJob_tRunJob_6.getStatus())) {
                    java.lang.Exception ce_tRunJob_6 = childJob_tRunJob_6.getException();
                    throw new RuntimeException("Child job running failed.\n" + ((ce_tRunJob_6!=null) ? (ce_tRunJob_6.getClass().getName() + ": " + ce_tRunJob_6.getMessage()) : ""));
                }

 


	tos_count_tRunJob_6++;

/**
 * [tRunJob_6 main ] stop
 */
	
	/**
	 * [tRunJob_6 process_data_begin ] start
	 */

	

	
	
	currentComponent="tRunJob_6";

	

 



/**
 * [tRunJob_6 process_data_begin ] stop
 */
	
	/**
	 * [tRunJob_6 process_data_end ] start
	 */

	

	
	
	currentComponent="tRunJob_6";

	

 



/**
 * [tRunJob_6 process_data_end ] stop
 */
	
	/**
	 * [tRunJob_6 end ] start
	 */

	

	
	
	currentComponent="tRunJob_6";

	

 

ok_Hash.put("tRunJob_6", true);
end_Hash.put("tRunJob_6", System.currentTimeMillis());




/**
 * [tRunJob_6 end ] stop
 */
				}//end the resume

				
				    			if(resumeEntryMethodName == null || globalResumeTicket){
				    				resumeUtil.addLog("CHECKPOINT", "CONNECTION:SUBJOB_OK:tRunJob_6:OnSubjobOk", "", Thread.currentThread().getId() + "", "", "", "", "", "");
								}	    				    			
					    	
								if(execStat){    	
									runStat.updateStatOnConnection("OnSubjobOk6", 0, "ok");
								} 
							
							tRunJob_7Process(globalMap); 
						



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tRunJob_6 finally ] start
	 */

	

	
	
	currentComponent="tRunJob_6";

	

 



/**
 * [tRunJob_6 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tRunJob_6_SUBPROCESS_STATE", 1);
	}
	

public void tRunJob_7Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tRunJob_7_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		


	
	/**
	 * [tRunJob_7 begin ] start
	 */

	

	
		
		ok_Hash.put("tRunJob_7", false);
		start_Hash.put("tRunJob_7", System.currentTimeMillis());
		
	
	currentComponent="tRunJob_7";

	
		int tos_count_tRunJob_7 = 0;
		


 



/**
 * [tRunJob_7 begin ] stop
 */
	
	/**
	 * [tRunJob_7 main ] start
	 */

	

	
	
	currentComponent="tRunJob_7";

	
	java.util.List<String> paraList_tRunJob_7 = new java.util.ArrayList<String>();
	
	        				paraList_tRunJob_7.add("--father_pid="+pid);
	      			
	        				paraList_tRunJob_7.add("--root_pid="+rootPid);
	      			
	        				paraList_tRunJob_7.add("--father_node=tRunJob_7");
	      			
	        				paraList_tRunJob_7.add("--context=Default");
	      			
		if(enableLogStash){
			paraList_tRunJob_7.add("--audit.enabled="+enableLogStash);
		}
		
	//for feature:10589
	
		paraList_tRunJob_7.add("--stat_port=" + portStats);
	

	if(resuming_logs_dir_path != null){
		paraList_tRunJob_7.add("--resuming_logs_dir_path=" + resuming_logs_dir_path);
	}
	String childResumePath_tRunJob_7 = ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path);
	String tRunJobName_tRunJob_7 = ResumeUtil.getRighttRunJob(resuming_checkpoint_path);
	if("tRunJob_7".equals(tRunJobName_tRunJob_7) && childResumePath_tRunJob_7 != null){
		paraList_tRunJob_7.add("--resuming_checkpoint_path=" + ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path));
	}
	paraList_tRunJob_7.add("--parent_part_launcher=JOB:" + jobName + "/NODE:tRunJob_7");
	
	java.util.Map<String, Object> parentContextMap_tRunJob_7 = new java.util.HashMap<String, Object>();

	

	Object obj_tRunJob_7 = null;

	
	
		pgs_stage.master_ressources_0_1.master_ressources childJob_tRunJob_7 = new pgs_stage.master_ressources_0_1.master_ressources();
	    // pass DataSources
	    java.util.Map<String, routines.system.TalendDataSource> talendDataSources_tRunJob_7 = (java.util.Map<String, routines.system.TalendDataSource>) globalMap
	            .get(KEY_DB_DATASOURCES);
	    if (null != talendDataSources_tRunJob_7) {
	        java.util.Map<String, javax.sql.DataSource> dataSources_tRunJob_7 = new java.util.HashMap<String, javax.sql.DataSource>();
	        for (java.util.Map.Entry<String, routines.system.TalendDataSource> talendDataSourceEntry_tRunJob_7 : talendDataSources_tRunJob_7
			        .entrySet()) {
	            dataSources_tRunJob_7.put(talendDataSourceEntry_tRunJob_7.getKey(),
	                    talendDataSourceEntry_tRunJob_7.getValue().getRawDataSource());
	        }
	        childJob_tRunJob_7.setDataSources(dataSources_tRunJob_7);
	    }
		  
			childJob_tRunJob_7.parentContextMap = parentContextMap_tRunJob_7;
		  
		
		String[][] childReturn_tRunJob_7 = childJob_tRunJob_7.runJob((String[]) paraList_tRunJob_7.toArray(new String[paraList_tRunJob_7.size()]));
		
            if(childJob_tRunJob_7.getErrorCode() == null){
                globalMap.put("tRunJob_7_CHILD_RETURN_CODE", childJob_tRunJob_7.getStatus() != null && ("failure").equals(childJob_tRunJob_7.getStatus()) ? 1 : 0);
            }else{
                globalMap.put("tRunJob_7_CHILD_RETURN_CODE", childJob_tRunJob_7.getErrorCode());
            }
            if (childJob_tRunJob_7.getExceptionStackTrace() != null) {
                globalMap.put("tRunJob_7_CHILD_EXCEPTION_STACKTRACE", childJob_tRunJob_7.getExceptionStackTrace());
            }
                    errorCode = childJob_tRunJob_7.getErrorCode();
                if (childJob_tRunJob_7.getErrorCode() != null || ("failure").equals(childJob_tRunJob_7.getStatus())) {
                    java.lang.Exception ce_tRunJob_7 = childJob_tRunJob_7.getException();
                    throw new RuntimeException("Child job running failed.\n" + ((ce_tRunJob_7!=null) ? (ce_tRunJob_7.getClass().getName() + ": " + ce_tRunJob_7.getMessage()) : ""));
                }

 


	tos_count_tRunJob_7++;

/**
 * [tRunJob_7 main ] stop
 */
	
	/**
	 * [tRunJob_7 process_data_begin ] start
	 */

	

	
	
	currentComponent="tRunJob_7";

	

 



/**
 * [tRunJob_7 process_data_begin ] stop
 */
	
	/**
	 * [tRunJob_7 process_data_end ] start
	 */

	

	
	
	currentComponent="tRunJob_7";

	

 



/**
 * [tRunJob_7 process_data_end ] stop
 */
	
	/**
	 * [tRunJob_7 end ] start
	 */

	

	
	
	currentComponent="tRunJob_7";

	

 

ok_Hash.put("tRunJob_7", true);
end_Hash.put("tRunJob_7", System.currentTimeMillis());




/**
 * [tRunJob_7 end ] stop
 */
				}//end the resume

				
				    			if(resumeEntryMethodName == null || globalResumeTicket){
				    				resumeUtil.addLog("CHECKPOINT", "CONNECTION:SUBJOB_OK:tRunJob_7:OnSubjobOk", "", Thread.currentThread().getId() + "", "", "", "", "", "");
								}	    				    			
					    	
								if(execStat){    	
									runStat.updateStatOnConnection("OnSubjobOk7", 0, "ok");
								} 
							
							tRunJob_8Process(globalMap); 
						



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tRunJob_7 finally ] start
	 */

	

	
	
	currentComponent="tRunJob_7";

	

 



/**
 * [tRunJob_7 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tRunJob_7_SUBPROCESS_STATE", 1);
	}
	

public void tRunJob_8Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tRunJob_8_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		


	
	/**
	 * [tRunJob_8 begin ] start
	 */

	

	
		
		ok_Hash.put("tRunJob_8", false);
		start_Hash.put("tRunJob_8", System.currentTimeMillis());
		
	
	currentComponent="tRunJob_8";

	
		int tos_count_tRunJob_8 = 0;
		


 



/**
 * [tRunJob_8 begin ] stop
 */
	
	/**
	 * [tRunJob_8 main ] start
	 */

	

	
	
	currentComponent="tRunJob_8";

	
	java.util.List<String> paraList_tRunJob_8 = new java.util.ArrayList<String>();
	
	        				paraList_tRunJob_8.add("--father_pid="+pid);
	      			
	        				paraList_tRunJob_8.add("--root_pid="+rootPid);
	      			
	        				paraList_tRunJob_8.add("--father_node=tRunJob_8");
	      			
	        				paraList_tRunJob_8.add("--context=Default");
	      			
		if(enableLogStash){
			paraList_tRunJob_8.add("--audit.enabled="+enableLogStash);
		}
		
	//for feature:10589
	
		paraList_tRunJob_8.add("--stat_port=" + portStats);
	

	if(resuming_logs_dir_path != null){
		paraList_tRunJob_8.add("--resuming_logs_dir_path=" + resuming_logs_dir_path);
	}
	String childResumePath_tRunJob_8 = ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path);
	String tRunJobName_tRunJob_8 = ResumeUtil.getRighttRunJob(resuming_checkpoint_path);
	if("tRunJob_8".equals(tRunJobName_tRunJob_8) && childResumePath_tRunJob_8 != null){
		paraList_tRunJob_8.add("--resuming_checkpoint_path=" + ResumeUtil.getChildJobCheckPointPath(resuming_checkpoint_path));
	}
	paraList_tRunJob_8.add("--parent_part_launcher=JOB:" + jobName + "/NODE:tRunJob_8");
	
	java.util.Map<String, Object> parentContextMap_tRunJob_8 = new java.util.HashMap<String, Object>();

	

	Object obj_tRunJob_8 = null;

	
	
		pgs_stage.master_sales_0_1.master_sales childJob_tRunJob_8 = new pgs_stage.master_sales_0_1.master_sales();
	    // pass DataSources
	    java.util.Map<String, routines.system.TalendDataSource> talendDataSources_tRunJob_8 = (java.util.Map<String, routines.system.TalendDataSource>) globalMap
	            .get(KEY_DB_DATASOURCES);
	    if (null != talendDataSources_tRunJob_8) {
	        java.util.Map<String, javax.sql.DataSource> dataSources_tRunJob_8 = new java.util.HashMap<String, javax.sql.DataSource>();
	        for (java.util.Map.Entry<String, routines.system.TalendDataSource> talendDataSourceEntry_tRunJob_8 : talendDataSources_tRunJob_8
			        .entrySet()) {
	            dataSources_tRunJob_8.put(talendDataSourceEntry_tRunJob_8.getKey(),
	                    talendDataSourceEntry_tRunJob_8.getValue().getRawDataSource());
	        }
	        childJob_tRunJob_8.setDataSources(dataSources_tRunJob_8);
	    }
		  
			childJob_tRunJob_8.parentContextMap = parentContextMap_tRunJob_8;
		  
		
		String[][] childReturn_tRunJob_8 = childJob_tRunJob_8.runJob((String[]) paraList_tRunJob_8.toArray(new String[paraList_tRunJob_8.size()]));
		
            if(childJob_tRunJob_8.getErrorCode() == null){
                globalMap.put("tRunJob_8_CHILD_RETURN_CODE", childJob_tRunJob_8.getStatus() != null && ("failure").equals(childJob_tRunJob_8.getStatus()) ? 1 : 0);
            }else{
                globalMap.put("tRunJob_8_CHILD_RETURN_CODE", childJob_tRunJob_8.getErrorCode());
            }
            if (childJob_tRunJob_8.getExceptionStackTrace() != null) {
                globalMap.put("tRunJob_8_CHILD_EXCEPTION_STACKTRACE", childJob_tRunJob_8.getExceptionStackTrace());
            }
                    errorCode = childJob_tRunJob_8.getErrorCode();
                if (childJob_tRunJob_8.getErrorCode() != null || ("failure").equals(childJob_tRunJob_8.getStatus())) {
                    java.lang.Exception ce_tRunJob_8 = childJob_tRunJob_8.getException();
                    throw new RuntimeException("Child job running failed.\n" + ((ce_tRunJob_8!=null) ? (ce_tRunJob_8.getClass().getName() + ": " + ce_tRunJob_8.getMessage()) : ""));
                }

 


	tos_count_tRunJob_8++;

/**
 * [tRunJob_8 main ] stop
 */
	
	/**
	 * [tRunJob_8 process_data_begin ] start
	 */

	

	
	
	currentComponent="tRunJob_8";

	

 



/**
 * [tRunJob_8 process_data_begin ] stop
 */
	
	/**
	 * [tRunJob_8 process_data_end ] start
	 */

	

	
	
	currentComponent="tRunJob_8";

	

 



/**
 * [tRunJob_8 process_data_end ] stop
 */
	
	/**
	 * [tRunJob_8 end ] start
	 */

	

	
	
	currentComponent="tRunJob_8";

	

 

ok_Hash.put("tRunJob_8", true);
end_Hash.put("tRunJob_8", System.currentTimeMillis());




/**
 * [tRunJob_8 end ] stop
 */
				}//end the resume

				
				    			if(resumeEntryMethodName == null || globalResumeTicket){
				    				resumeUtil.addLog("CHECKPOINT", "CONNECTION:SUBJOB_OK:tRunJob_8:OnSubjobOk", "", Thread.currentThread().getId() + "", "", "", "", "", "");
								}	    				    			
					    	
								if(execStat){    	
									runStat.updateStatOnConnection("OnSubjobOk8", 0, "ok");
								} 
							
							tSendMail_1Process(globalMap); 
						



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tRunJob_8 finally ] start
	 */

	

	
	
	currentComponent="tRunJob_8";

	

 



/**
 * [tRunJob_8 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tRunJob_8_SUBPROCESS_STATE", 1);
	}
	

public void tSendMail_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tSendMail_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;





	
	/**
	 * [tSendMail_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tSendMail_1", false);
		start_Hash.put("tSendMail_1", System.currentTimeMillis());
		
	
	currentComponent="tSendMail_1";

	
		int tos_count_tSendMail_1 = 0;
		

 



/**
 * [tSendMail_1 begin ] stop
 */
	
	/**
	 * [tSendMail_1 main ] start
	 */

	

	
	
	currentComponent="tSendMail_1";

	

 

	String smtpHost_tSendMail_1 = "smtp.gmail.com";
        String smtpPort_tSendMail_1 = "465";
	String from_tSendMail_1 = ("dhiaajmi7@gmail.com");
    String to_tSendMail_1 = ("mohameddhia.ajmi@esprit.tn").replace(";",",");
    String cc_tSendMail_1 = (("")==null || "".equals(""))?null:("").replace(";",",");
    String bcc_tSendMail_1 = (("")==null || "".equals(""))?null:("").replace(";",",");
    String subject_tSendMail_1 = ("Job executied successfuly");
    
	java.util.List<java.util.Map<String, String>> headers_tSendMail_1 = new java.util.ArrayList<java.util.Map<String,String>>();
	java.util.List<String> attachments_tSendMail_1 = new java.util.ArrayList<String>();
	java.util.List<String> contentTransferEncoding_tSendMail_1 = new java.util.ArrayList<String>();

	String message_tSendMail_1 = (("ok") == null || "".equals("ok")) ? "\"\"" : ("ok") ;
	java.util.Properties props_tSendMail_1 = System.getProperties();     
	props_tSendMail_1.put("mail.smtp.host", smtpHost_tSendMail_1);
	props_tSendMail_1.put("mail.smtp.port", smtpPort_tSendMail_1);
		props_tSendMail_1.put("mail.mime.encodefilename", "true");  
		props_tSendMail_1.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props_tSendMail_1.put("mail.smtp.socketFactory.fallback", "false");
		props_tSendMail_1.put("mail.smtp.socketFactory.port", smtpPort_tSendMail_1);     
	try {
		
		
			props_tSendMail_1.put("mail.smtp.auth", "true");
			javax.mail.Session session_tSendMail_1 = javax.mail.Session.getInstance(props_tSendMail_1, new javax.mail.Authenticator(){         
				protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				
                 
	final String decryptedPassword_tSendMail_1 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:c7+bmKWzOMxrSyMF8pp0BQXczoBwODOtjGVf8Ut4LnibaT5hvsbTZANx9cHRDKY=");
				
				
				return new javax.mail.PasswordAuthentication("dhiaajmi7@gmail.com", decryptedPassword_tSendMail_1); 
				}         
			});   
		
		
		javax.mail.Message msg_tSendMail_1 = new javax.mail.internet.MimeMessage(session_tSendMail_1);
		msg_tSendMail_1.setFrom(new javax.mail.internet.InternetAddress(from_tSendMail_1, "Admin talend"));
		msg_tSendMail_1.setRecipients(javax.mail.Message.RecipientType.TO,javax.mail.internet.InternetAddress.parse(to_tSendMail_1, false));
		if (cc_tSendMail_1 != null) msg_tSendMail_1.setRecipients(javax.mail.Message.RecipientType.CC, javax.mail.internet.InternetAddress.parse(cc_tSendMail_1, false));
		if (bcc_tSendMail_1 != null) msg_tSendMail_1.setRecipients(javax.mail.Message.RecipientType.BCC, javax.mail.internet.InternetAddress.parse(bcc_tSendMail_1, false));
		msg_tSendMail_1.setSubject(subject_tSendMail_1);

		for (int i_tSendMail_1 = 0; i_tSendMail_1 < headers_tSendMail_1.size(); i_tSendMail_1++) {
			java.util.Map<String, String> header_tSendMail_1 = headers_tSendMail_1.get(i_tSendMail_1);
			msg_tSendMail_1.setHeader(header_tSendMail_1.get("KEY"), header_tSendMail_1.get("VALUE"));    
		}  
		msg_tSendMail_1.setSentDate(new Date());
		msg_tSendMail_1.setHeader("X-Priority", "3"); //High->1 Normal->3 Low->5
		javax.mail.Multipart mp_tSendMail_1 = new javax.mail.internet.MimeMultipart();
		javax.mail.internet.MimeBodyPart mbpText_tSendMail_1 = new javax.mail.internet.MimeBodyPart();
		mbpText_tSendMail_1.setText(message_tSendMail_1,"ISO-8859-15", "plain");
		mp_tSendMail_1.addBodyPart(mbpText_tSendMail_1);
  
		javax.mail.internet.MimeBodyPart mbpFile_tSendMail_1 = null;

		for (int i_tSendMail_1 = 0; i_tSendMail_1 < attachments_tSendMail_1.size(); i_tSendMail_1++){
			String filename_tSendMail_1 = attachments_tSendMail_1.get(i_tSendMail_1);
			javax.activation.FileDataSource fds_tSendMail_1 = null;
			java.io.File file_tSendMail_1 = new java.io.File(filename_tSendMail_1);
			
    		if (file_tSendMail_1.isDirectory()){
				java.io.File[] subFiles_tSendMail_1 = file_tSendMail_1.listFiles();
				for(java.io.File subFile_tSendMail_1 : subFiles_tSendMail_1){
					if (subFile_tSendMail_1.isFile()){
						fds_tSendMail_1 = new javax.activation.FileDataSource(subFile_tSendMail_1.getAbsolutePath());
						mbpFile_tSendMail_1 = new javax.mail.internet.MimeBodyPart();
						mbpFile_tSendMail_1.setDataHandler(new javax.activation.DataHandler(fds_tSendMail_1));
						mbpFile_tSendMail_1.setFileName(javax.mail.internet.MimeUtility.encodeText(fds_tSendMail_1.getName()));
						if(contentTransferEncoding_tSendMail_1.get(i_tSendMail_1).equalsIgnoreCase("base64")){
							mbpFile_tSendMail_1.setHeader("Content-Transfer-Encoding", "base64");
						}
						mp_tSendMail_1.addBodyPart(mbpFile_tSendMail_1);
					}
				}
    		}else{
				mbpFile_tSendMail_1 = new javax.mail.internet.MimeBodyPart();
				fds_tSendMail_1 = new javax.activation.FileDataSource(filename_tSendMail_1);
				mbpFile_tSendMail_1.setDataHandler(new javax.activation.DataHandler(fds_tSendMail_1)); 
				mbpFile_tSendMail_1.setFileName(javax.mail.internet.MimeUtility.encodeText(fds_tSendMail_1.getName()));
				if(contentTransferEncoding_tSendMail_1.get(i_tSendMail_1).equalsIgnoreCase("base64")){
					mbpFile_tSendMail_1.setHeader("Content-Transfer-Encoding", "base64");
				}
				mp_tSendMail_1.addBodyPart(mbpFile_tSendMail_1);
			}
		}
		// -- set the content --
		msg_tSendMail_1.setContent(mp_tSendMail_1);
		// add handlers for main MIME types
		javax.activation.MailcapCommandMap mc_tSendMail_1 = ( javax.activation.MailcapCommandMap)javax.activation.CommandMap.getDefaultCommandMap();
		mc_tSendMail_1.addMailcap("text/html;; x-java-content-handler=com.sun.mail.handlers.text_html");
		mc_tSendMail_1.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml");
		mc_tSendMail_1.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain");
		mc_tSendMail_1.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed");
		mc_tSendMail_1.addMailcap("message/rfc822;; x-java-content-handler=com.sun.mail.handlers.message_rfc822");
		javax.activation.CommandMap.setDefaultCommandMap(mc_tSendMail_1);
		// add com.sun.mail.handlers to job imports / depenencies (TESB-27110)
		com.sun.mail.handlers.text_plain text_plain_h_tSendMail_1 = null;
		// -- Send the message --
		javax.mail.Transport.send(msg_tSendMail_1);
	} catch(java.lang.Exception e){
globalMap.put("tSendMail_1_ERROR_MESSAGE",e.getMessage());
  		
			throw(e);
		
	}finally{
		props_tSendMail_1.remove("mail.smtp.host");
		props_tSendMail_1.remove("mail.smtp.port");
		
		props_tSendMail_1.remove("mail.mime.encodefilename");
		  
			props_tSendMail_1.remove("mail.smtp.socketFactory.class");
			props_tSendMail_1.remove("mail.smtp.socketFactory.fallback");
			props_tSendMail_1.remove("mail.smtp.socketFactory.port");
		
		props_tSendMail_1.remove("mail.smtp.auth");     
	}

 


	tos_count_tSendMail_1++;

/**
 * [tSendMail_1 main ] stop
 */
	
	/**
	 * [tSendMail_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tSendMail_1";

	

 



/**
 * [tSendMail_1 process_data_begin ] stop
 */
	
	/**
	 * [tSendMail_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tSendMail_1";

	

 



/**
 * [tSendMail_1 process_data_end ] stop
 */
	
	/**
	 * [tSendMail_1 end ] start
	 */

	

	
	
	currentComponent="tSendMail_1";

	

 

ok_Hash.put("tSendMail_1", true);
end_Hash.put("tSendMail_1", System.currentTimeMillis());




/**
 * [tSendMail_1 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tSendMail_1 finally ] start
	 */

	

	
	
	currentComponent="tSendMail_1";

	

 



/**
 * [tSendMail_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tSendMail_1_SUBPROCESS_STATE", 1);
	}
	

public void tSendMail_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tSendMail_2_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;





	
	/**
	 * [tSendMail_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tSendMail_2", false);
		start_Hash.put("tSendMail_2", System.currentTimeMillis());
		
	
	currentComponent="tSendMail_2";

	
		int tos_count_tSendMail_2 = 0;
		

 



/**
 * [tSendMail_2 begin ] stop
 */
	
	/**
	 * [tSendMail_2 main ] start
	 */

	

	
	
	currentComponent="tSendMail_2";

	

 

	String smtpHost_tSendMail_2 = "smtp.gmail.com";
        String smtpPort_tSendMail_2 = "465";
	String from_tSendMail_2 = ("dhiaajmi7@gmail.com");
    String to_tSendMail_2 = ("mohameddhia.ajmi@esprit.tn").replace(";",",");
    String cc_tSendMail_2 = (("")==null || "".equals(""))?null:("").replace(";",",");
    String bcc_tSendMail_2 = (("")==null || "".equals(""))?null:("").replace(";",",");
    String subject_tSendMail_2 = ("Job execution failed");
    
	java.util.List<java.util.Map<String, String>> headers_tSendMail_2 = new java.util.ArrayList<java.util.Map<String,String>>();
	java.util.List<String> attachments_tSendMail_2 = new java.util.ArrayList<String>();
	java.util.List<String> contentTransferEncoding_tSendMail_2 = new java.util.ArrayList<String>();

	String message_tSendMail_2 = (("ok") == null || "".equals("ok")) ? "\"\"" : ("ok") ;
	java.util.Properties props_tSendMail_2 = System.getProperties();     
	props_tSendMail_2.put("mail.smtp.host", smtpHost_tSendMail_2);
	props_tSendMail_2.put("mail.smtp.port", smtpPort_tSendMail_2);
		props_tSendMail_2.put("mail.mime.encodefilename", "true");  
		props_tSendMail_2.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props_tSendMail_2.put("mail.smtp.socketFactory.fallback", "false");
		props_tSendMail_2.put("mail.smtp.socketFactory.port", smtpPort_tSendMail_2);     
	try {
		
		
			props_tSendMail_2.put("mail.smtp.auth", "true");
			javax.mail.Session session_tSendMail_2 = javax.mail.Session.getInstance(props_tSendMail_2, new javax.mail.Authenticator(){         
				protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				
                 
	final String decryptedPassword_tSendMail_2 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:8xLz3Q7HNTN07YPJO/mL57ExJMrJAgDiRbNCtVpSzw0FE1FrQtYVNTvpsUSYVj0=");
				
				
				return new javax.mail.PasswordAuthentication("dhiaajmi7@gmail.com", decryptedPassword_tSendMail_2); 
				}         
			});   
		
		
		javax.mail.Message msg_tSendMail_2 = new javax.mail.internet.MimeMessage(session_tSendMail_2);
		msg_tSendMail_2.setFrom(new javax.mail.internet.InternetAddress(from_tSendMail_2, "Admin talend"));
		msg_tSendMail_2.setRecipients(javax.mail.Message.RecipientType.TO,javax.mail.internet.InternetAddress.parse(to_tSendMail_2, false));
		if (cc_tSendMail_2 != null) msg_tSendMail_2.setRecipients(javax.mail.Message.RecipientType.CC, javax.mail.internet.InternetAddress.parse(cc_tSendMail_2, false));
		if (bcc_tSendMail_2 != null) msg_tSendMail_2.setRecipients(javax.mail.Message.RecipientType.BCC, javax.mail.internet.InternetAddress.parse(bcc_tSendMail_2, false));
		msg_tSendMail_2.setSubject(subject_tSendMail_2);

		for (int i_tSendMail_2 = 0; i_tSendMail_2 < headers_tSendMail_2.size(); i_tSendMail_2++) {
			java.util.Map<String, String> header_tSendMail_2 = headers_tSendMail_2.get(i_tSendMail_2);
			msg_tSendMail_2.setHeader(header_tSendMail_2.get("KEY"), header_tSendMail_2.get("VALUE"));    
		}  
		msg_tSendMail_2.setSentDate(new Date());
		msg_tSendMail_2.setHeader("X-Priority", "3"); //High->1 Normal->3 Low->5
		javax.mail.Multipart mp_tSendMail_2 = new javax.mail.internet.MimeMultipart();
		javax.mail.internet.MimeBodyPart mbpText_tSendMail_2 = new javax.mail.internet.MimeBodyPart();
		mbpText_tSendMail_2.setText(message_tSendMail_2,"ISO-8859-15", "plain");
		mp_tSendMail_2.addBodyPart(mbpText_tSendMail_2);
  
		javax.mail.internet.MimeBodyPart mbpFile_tSendMail_2 = null;

		for (int i_tSendMail_2 = 0; i_tSendMail_2 < attachments_tSendMail_2.size(); i_tSendMail_2++){
			String filename_tSendMail_2 = attachments_tSendMail_2.get(i_tSendMail_2);
			javax.activation.FileDataSource fds_tSendMail_2 = null;
			java.io.File file_tSendMail_2 = new java.io.File(filename_tSendMail_2);
			
    		if (file_tSendMail_2.isDirectory()){
				java.io.File[] subFiles_tSendMail_2 = file_tSendMail_2.listFiles();
				for(java.io.File subFile_tSendMail_2 : subFiles_tSendMail_2){
					if (subFile_tSendMail_2.isFile()){
						fds_tSendMail_2 = new javax.activation.FileDataSource(subFile_tSendMail_2.getAbsolutePath());
						mbpFile_tSendMail_2 = new javax.mail.internet.MimeBodyPart();
						mbpFile_tSendMail_2.setDataHandler(new javax.activation.DataHandler(fds_tSendMail_2));
						mbpFile_tSendMail_2.setFileName(javax.mail.internet.MimeUtility.encodeText(fds_tSendMail_2.getName()));
						if(contentTransferEncoding_tSendMail_2.get(i_tSendMail_2).equalsIgnoreCase("base64")){
							mbpFile_tSendMail_2.setHeader("Content-Transfer-Encoding", "base64");
						}
						mp_tSendMail_2.addBodyPart(mbpFile_tSendMail_2);
					}
				}
    		}else{
				mbpFile_tSendMail_2 = new javax.mail.internet.MimeBodyPart();
				fds_tSendMail_2 = new javax.activation.FileDataSource(filename_tSendMail_2);
				mbpFile_tSendMail_2.setDataHandler(new javax.activation.DataHandler(fds_tSendMail_2)); 
				mbpFile_tSendMail_2.setFileName(javax.mail.internet.MimeUtility.encodeText(fds_tSendMail_2.getName()));
				if(contentTransferEncoding_tSendMail_2.get(i_tSendMail_2).equalsIgnoreCase("base64")){
					mbpFile_tSendMail_2.setHeader("Content-Transfer-Encoding", "base64");
				}
				mp_tSendMail_2.addBodyPart(mbpFile_tSendMail_2);
			}
		}
		// -- set the content --
		msg_tSendMail_2.setContent(mp_tSendMail_2);
		// add handlers for main MIME types
		javax.activation.MailcapCommandMap mc_tSendMail_2 = ( javax.activation.MailcapCommandMap)javax.activation.CommandMap.getDefaultCommandMap();
		mc_tSendMail_2.addMailcap("text/html;; x-java-content-handler=com.sun.mail.handlers.text_html");
		mc_tSendMail_2.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml");
		mc_tSendMail_2.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain");
		mc_tSendMail_2.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed");
		mc_tSendMail_2.addMailcap("message/rfc822;; x-java-content-handler=com.sun.mail.handlers.message_rfc822");
		javax.activation.CommandMap.setDefaultCommandMap(mc_tSendMail_2);
		// add com.sun.mail.handlers to job imports / depenencies (TESB-27110)
		com.sun.mail.handlers.text_plain text_plain_h_tSendMail_2 = null;
		// -- Send the message --
		javax.mail.Transport.send(msg_tSendMail_2);
	} catch(java.lang.Exception e){
globalMap.put("tSendMail_2_ERROR_MESSAGE",e.getMessage());
  		
			throw(e);
		
	}finally{
		props_tSendMail_2.remove("mail.smtp.host");
		props_tSendMail_2.remove("mail.smtp.port");
		
		props_tSendMail_2.remove("mail.mime.encodefilename");
		  
			props_tSendMail_2.remove("mail.smtp.socketFactory.class");
			props_tSendMail_2.remove("mail.smtp.socketFactory.fallback");
			props_tSendMail_2.remove("mail.smtp.socketFactory.port");
		
		props_tSendMail_2.remove("mail.smtp.auth");     
	}

 


	tos_count_tSendMail_2++;

/**
 * [tSendMail_2 main ] stop
 */
	
	/**
	 * [tSendMail_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tSendMail_2";

	

 



/**
 * [tSendMail_2 process_data_begin ] stop
 */
	
	/**
	 * [tSendMail_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tSendMail_2";

	

 



/**
 * [tSendMail_2 process_data_end ] stop
 */
	
	/**
	 * [tSendMail_2 end ] start
	 */

	

	
	
	currentComponent="tSendMail_2";

	

 

ok_Hash.put("tSendMail_2", true);
end_Hash.put("tSendMail_2", System.currentTimeMillis());




/**
 * [tSendMail_2 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tSendMail_2 finally ] start
	 */

	

	
	
	currentComponent="tSendMail_2";

	

 



/**
 * [tSendMail_2 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tSendMail_2_SUBPROCESS_STATE", 1);
	}
	

public void tSendMail_3Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tSendMail_3_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;





	
	/**
	 * [tSendMail_3 begin ] start
	 */

	

	
		
		ok_Hash.put("tSendMail_3", false);
		start_Hash.put("tSendMail_3", System.currentTimeMillis());
		
	
	currentComponent="tSendMail_3";

	
		int tos_count_tSendMail_3 = 0;
		

 



/**
 * [tSendMail_3 begin ] stop
 */
	
	/**
	 * [tSendMail_3 main ] start
	 */

	

	
	
	currentComponent="tSendMail_3";

	

 

	String smtpHost_tSendMail_3 = "smtp.gmail.com";
        String smtpPort_tSendMail_3 = "465";
	String from_tSendMail_3 = ("dhiaajmi7@gmail.com");
    String to_tSendMail_3 = ("mohameddhia.ajmi@esprit.tn").replace(";",",");
    String cc_tSendMail_3 = (("")==null || "".equals(""))?null:("").replace(";",",");
    String bcc_tSendMail_3 = (("")==null || "".equals(""))?null:("").replace(";",",");
    String subject_tSendMail_3 = ("Job execution failed");
    
	java.util.List<java.util.Map<String, String>> headers_tSendMail_3 = new java.util.ArrayList<java.util.Map<String,String>>();
	java.util.List<String> attachments_tSendMail_3 = new java.util.ArrayList<String>();
	java.util.List<String> contentTransferEncoding_tSendMail_3 = new java.util.ArrayList<String>();

	String message_tSendMail_3 = (("ok") == null || "".equals("ok")) ? "\"\"" : ("ok") ;
	java.util.Properties props_tSendMail_3 = System.getProperties();     
	props_tSendMail_3.put("mail.smtp.host", smtpHost_tSendMail_3);
	props_tSendMail_3.put("mail.smtp.port", smtpPort_tSendMail_3);
		props_tSendMail_3.put("mail.mime.encodefilename", "true");  
		props_tSendMail_3.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props_tSendMail_3.put("mail.smtp.socketFactory.fallback", "false");
		props_tSendMail_3.put("mail.smtp.socketFactory.port", smtpPort_tSendMail_3);     
	try {
		
		
			props_tSendMail_3.put("mail.smtp.auth", "true");
			javax.mail.Session session_tSendMail_3 = javax.mail.Session.getInstance(props_tSendMail_3, new javax.mail.Authenticator(){         
				protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				
                 
	final String decryptedPassword_tSendMail_3 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:GcBTWZGTlVgEg+VsGwDIcx8Uy6hiYIxbLg3iQpKzsOnJLMd0QxJPfnx9fV7MiKw=");
				
				
				return new javax.mail.PasswordAuthentication("dhiaajmi7@gmail.com", decryptedPassword_tSendMail_3); 
				}         
			});   
		
		
		javax.mail.Message msg_tSendMail_3 = new javax.mail.internet.MimeMessage(session_tSendMail_3);
		msg_tSendMail_3.setFrom(new javax.mail.internet.InternetAddress(from_tSendMail_3, "Admin talend"));
		msg_tSendMail_3.setRecipients(javax.mail.Message.RecipientType.TO,javax.mail.internet.InternetAddress.parse(to_tSendMail_3, false));
		if (cc_tSendMail_3 != null) msg_tSendMail_3.setRecipients(javax.mail.Message.RecipientType.CC, javax.mail.internet.InternetAddress.parse(cc_tSendMail_3, false));
		if (bcc_tSendMail_3 != null) msg_tSendMail_3.setRecipients(javax.mail.Message.RecipientType.BCC, javax.mail.internet.InternetAddress.parse(bcc_tSendMail_3, false));
		msg_tSendMail_3.setSubject(subject_tSendMail_3);

		for (int i_tSendMail_3 = 0; i_tSendMail_3 < headers_tSendMail_3.size(); i_tSendMail_3++) {
			java.util.Map<String, String> header_tSendMail_3 = headers_tSendMail_3.get(i_tSendMail_3);
			msg_tSendMail_3.setHeader(header_tSendMail_3.get("KEY"), header_tSendMail_3.get("VALUE"));    
		}  
		msg_tSendMail_3.setSentDate(new Date());
		msg_tSendMail_3.setHeader("X-Priority", "3"); //High->1 Normal->3 Low->5
		javax.mail.Multipart mp_tSendMail_3 = new javax.mail.internet.MimeMultipart();
		javax.mail.internet.MimeBodyPart mbpText_tSendMail_3 = new javax.mail.internet.MimeBodyPart();
		mbpText_tSendMail_3.setText(message_tSendMail_3,"ISO-8859-15", "plain");
		mp_tSendMail_3.addBodyPart(mbpText_tSendMail_3);
  
		javax.mail.internet.MimeBodyPart mbpFile_tSendMail_3 = null;

		for (int i_tSendMail_3 = 0; i_tSendMail_3 < attachments_tSendMail_3.size(); i_tSendMail_3++){
			String filename_tSendMail_3 = attachments_tSendMail_3.get(i_tSendMail_3);
			javax.activation.FileDataSource fds_tSendMail_3 = null;
			java.io.File file_tSendMail_3 = new java.io.File(filename_tSendMail_3);
			
    		if (file_tSendMail_3.isDirectory()){
				java.io.File[] subFiles_tSendMail_3 = file_tSendMail_3.listFiles();
				for(java.io.File subFile_tSendMail_3 : subFiles_tSendMail_3){
					if (subFile_tSendMail_3.isFile()){
						fds_tSendMail_3 = new javax.activation.FileDataSource(subFile_tSendMail_3.getAbsolutePath());
						mbpFile_tSendMail_3 = new javax.mail.internet.MimeBodyPart();
						mbpFile_tSendMail_3.setDataHandler(new javax.activation.DataHandler(fds_tSendMail_3));
						mbpFile_tSendMail_3.setFileName(javax.mail.internet.MimeUtility.encodeText(fds_tSendMail_3.getName()));
						if(contentTransferEncoding_tSendMail_3.get(i_tSendMail_3).equalsIgnoreCase("base64")){
							mbpFile_tSendMail_3.setHeader("Content-Transfer-Encoding", "base64");
						}
						mp_tSendMail_3.addBodyPart(mbpFile_tSendMail_3);
					}
				}
    		}else{
				mbpFile_tSendMail_3 = new javax.mail.internet.MimeBodyPart();
				fds_tSendMail_3 = new javax.activation.FileDataSource(filename_tSendMail_3);
				mbpFile_tSendMail_3.setDataHandler(new javax.activation.DataHandler(fds_tSendMail_3)); 
				mbpFile_tSendMail_3.setFileName(javax.mail.internet.MimeUtility.encodeText(fds_tSendMail_3.getName()));
				if(contentTransferEncoding_tSendMail_3.get(i_tSendMail_3).equalsIgnoreCase("base64")){
					mbpFile_tSendMail_3.setHeader("Content-Transfer-Encoding", "base64");
				}
				mp_tSendMail_3.addBodyPart(mbpFile_tSendMail_3);
			}
		}
		// -- set the content --
		msg_tSendMail_3.setContent(mp_tSendMail_3);
		// add handlers for main MIME types
		javax.activation.MailcapCommandMap mc_tSendMail_3 = ( javax.activation.MailcapCommandMap)javax.activation.CommandMap.getDefaultCommandMap();
		mc_tSendMail_3.addMailcap("text/html;; x-java-content-handler=com.sun.mail.handlers.text_html");
		mc_tSendMail_3.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml");
		mc_tSendMail_3.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain");
		mc_tSendMail_3.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed");
		mc_tSendMail_3.addMailcap("message/rfc822;; x-java-content-handler=com.sun.mail.handlers.message_rfc822");
		javax.activation.CommandMap.setDefaultCommandMap(mc_tSendMail_3);
		// add com.sun.mail.handlers to job imports / depenencies (TESB-27110)
		com.sun.mail.handlers.text_plain text_plain_h_tSendMail_3 = null;
		// -- Send the message --
		javax.mail.Transport.send(msg_tSendMail_3);
	} catch(java.lang.Exception e){
globalMap.put("tSendMail_3_ERROR_MESSAGE",e.getMessage());
  		
			throw(e);
		
	}finally{
		props_tSendMail_3.remove("mail.smtp.host");
		props_tSendMail_3.remove("mail.smtp.port");
		
		props_tSendMail_3.remove("mail.mime.encodefilename");
		  
			props_tSendMail_3.remove("mail.smtp.socketFactory.class");
			props_tSendMail_3.remove("mail.smtp.socketFactory.fallback");
			props_tSendMail_3.remove("mail.smtp.socketFactory.port");
		
		props_tSendMail_3.remove("mail.smtp.auth");     
	}

 


	tos_count_tSendMail_3++;

/**
 * [tSendMail_3 main ] stop
 */
	
	/**
	 * [tSendMail_3 process_data_begin ] start
	 */

	

	
	
	currentComponent="tSendMail_3";

	

 



/**
 * [tSendMail_3 process_data_begin ] stop
 */
	
	/**
	 * [tSendMail_3 process_data_end ] start
	 */

	

	
	
	currentComponent="tSendMail_3";

	

 



/**
 * [tSendMail_3 process_data_end ] stop
 */
	
	/**
	 * [tSendMail_3 end ] start
	 */

	

	
	
	currentComponent="tSendMail_3";

	

 

ok_Hash.put("tSendMail_3", true);
end_Hash.put("tSendMail_3", System.currentTimeMillis());




/**
 * [tSendMail_3 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tSendMail_3 finally ] start
	 */

	

	
	
	currentComponent="tSendMail_3";

	

 



/**
 * [tSendMail_3 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tSendMail_3_SUBPROCESS_STATE", 1);
	}
	

public void tSendMail_4Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tSendMail_4_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;





	
	/**
	 * [tSendMail_4 begin ] start
	 */

	

	
		
		ok_Hash.put("tSendMail_4", false);
		start_Hash.put("tSendMail_4", System.currentTimeMillis());
		
	
	currentComponent="tSendMail_4";

	
		int tos_count_tSendMail_4 = 0;
		

 



/**
 * [tSendMail_4 begin ] stop
 */
	
	/**
	 * [tSendMail_4 main ] start
	 */

	

	
	
	currentComponent="tSendMail_4";

	

 

	String smtpHost_tSendMail_4 = "smtp.gmail.com";
        String smtpPort_tSendMail_4 = "465";
	String from_tSendMail_4 = ("dhiaajmi7@gmail.com");
    String to_tSendMail_4 = ("mohameddhia.ajmi@esprit.tn").replace(";",",");
    String cc_tSendMail_4 = (("")==null || "".equals(""))?null:("").replace(";",",");
    String bcc_tSendMail_4 = (("")==null || "".equals(""))?null:("").replace(";",",");
    String subject_tSendMail_4 = ("Job execution failed");
    
	java.util.List<java.util.Map<String, String>> headers_tSendMail_4 = new java.util.ArrayList<java.util.Map<String,String>>();
	java.util.List<String> attachments_tSendMail_4 = new java.util.ArrayList<String>();
	java.util.List<String> contentTransferEncoding_tSendMail_4 = new java.util.ArrayList<String>();

	String message_tSendMail_4 = (("ok") == null || "".equals("ok")) ? "\"\"" : ("ok") ;
	java.util.Properties props_tSendMail_4 = System.getProperties();     
	props_tSendMail_4.put("mail.smtp.host", smtpHost_tSendMail_4);
	props_tSendMail_4.put("mail.smtp.port", smtpPort_tSendMail_4);
		props_tSendMail_4.put("mail.mime.encodefilename", "true");  
		props_tSendMail_4.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props_tSendMail_4.put("mail.smtp.socketFactory.fallback", "false");
		props_tSendMail_4.put("mail.smtp.socketFactory.port", smtpPort_tSendMail_4);     
	try {
		
		
			props_tSendMail_4.put("mail.smtp.auth", "true");
			javax.mail.Session session_tSendMail_4 = javax.mail.Session.getInstance(props_tSendMail_4, new javax.mail.Authenticator(){         
				protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				
                 
	final String decryptedPassword_tSendMail_4 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:UkmSEU2x07nxDPVKlWRY2Gm4znMZlxiGzrfiTOG9GInAgcYMCrNtawO9RX39VMQ=");
				
				
				return new javax.mail.PasswordAuthentication("dhiaajmi7@gmail.com", decryptedPassword_tSendMail_4); 
				}         
			});   
		
		
		javax.mail.Message msg_tSendMail_4 = new javax.mail.internet.MimeMessage(session_tSendMail_4);
		msg_tSendMail_4.setFrom(new javax.mail.internet.InternetAddress(from_tSendMail_4, "Admin talend"));
		msg_tSendMail_4.setRecipients(javax.mail.Message.RecipientType.TO,javax.mail.internet.InternetAddress.parse(to_tSendMail_4, false));
		if (cc_tSendMail_4 != null) msg_tSendMail_4.setRecipients(javax.mail.Message.RecipientType.CC, javax.mail.internet.InternetAddress.parse(cc_tSendMail_4, false));
		if (bcc_tSendMail_4 != null) msg_tSendMail_4.setRecipients(javax.mail.Message.RecipientType.BCC, javax.mail.internet.InternetAddress.parse(bcc_tSendMail_4, false));
		msg_tSendMail_4.setSubject(subject_tSendMail_4);

		for (int i_tSendMail_4 = 0; i_tSendMail_4 < headers_tSendMail_4.size(); i_tSendMail_4++) {
			java.util.Map<String, String> header_tSendMail_4 = headers_tSendMail_4.get(i_tSendMail_4);
			msg_tSendMail_4.setHeader(header_tSendMail_4.get("KEY"), header_tSendMail_4.get("VALUE"));    
		}  
		msg_tSendMail_4.setSentDate(new Date());
		msg_tSendMail_4.setHeader("X-Priority", "3"); //High->1 Normal->3 Low->5
		javax.mail.Multipart mp_tSendMail_4 = new javax.mail.internet.MimeMultipart();
		javax.mail.internet.MimeBodyPart mbpText_tSendMail_4 = new javax.mail.internet.MimeBodyPart();
		mbpText_tSendMail_4.setText(message_tSendMail_4,"ISO-8859-15", "plain");
		mp_tSendMail_4.addBodyPart(mbpText_tSendMail_4);
  
		javax.mail.internet.MimeBodyPart mbpFile_tSendMail_4 = null;

		for (int i_tSendMail_4 = 0; i_tSendMail_4 < attachments_tSendMail_4.size(); i_tSendMail_4++){
			String filename_tSendMail_4 = attachments_tSendMail_4.get(i_tSendMail_4);
			javax.activation.FileDataSource fds_tSendMail_4 = null;
			java.io.File file_tSendMail_4 = new java.io.File(filename_tSendMail_4);
			
    		if (file_tSendMail_4.isDirectory()){
				java.io.File[] subFiles_tSendMail_4 = file_tSendMail_4.listFiles();
				for(java.io.File subFile_tSendMail_4 : subFiles_tSendMail_4){
					if (subFile_tSendMail_4.isFile()){
						fds_tSendMail_4 = new javax.activation.FileDataSource(subFile_tSendMail_4.getAbsolutePath());
						mbpFile_tSendMail_4 = new javax.mail.internet.MimeBodyPart();
						mbpFile_tSendMail_4.setDataHandler(new javax.activation.DataHandler(fds_tSendMail_4));
						mbpFile_tSendMail_4.setFileName(javax.mail.internet.MimeUtility.encodeText(fds_tSendMail_4.getName()));
						if(contentTransferEncoding_tSendMail_4.get(i_tSendMail_4).equalsIgnoreCase("base64")){
							mbpFile_tSendMail_4.setHeader("Content-Transfer-Encoding", "base64");
						}
						mp_tSendMail_4.addBodyPart(mbpFile_tSendMail_4);
					}
				}
    		}else{
				mbpFile_tSendMail_4 = new javax.mail.internet.MimeBodyPart();
				fds_tSendMail_4 = new javax.activation.FileDataSource(filename_tSendMail_4);
				mbpFile_tSendMail_4.setDataHandler(new javax.activation.DataHandler(fds_tSendMail_4)); 
				mbpFile_tSendMail_4.setFileName(javax.mail.internet.MimeUtility.encodeText(fds_tSendMail_4.getName()));
				if(contentTransferEncoding_tSendMail_4.get(i_tSendMail_4).equalsIgnoreCase("base64")){
					mbpFile_tSendMail_4.setHeader("Content-Transfer-Encoding", "base64");
				}
				mp_tSendMail_4.addBodyPart(mbpFile_tSendMail_4);
			}
		}
		// -- set the content --
		msg_tSendMail_4.setContent(mp_tSendMail_4);
		// add handlers for main MIME types
		javax.activation.MailcapCommandMap mc_tSendMail_4 = ( javax.activation.MailcapCommandMap)javax.activation.CommandMap.getDefaultCommandMap();
		mc_tSendMail_4.addMailcap("text/html;; x-java-content-handler=com.sun.mail.handlers.text_html");
		mc_tSendMail_4.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml");
		mc_tSendMail_4.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain");
		mc_tSendMail_4.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed");
		mc_tSendMail_4.addMailcap("message/rfc822;; x-java-content-handler=com.sun.mail.handlers.message_rfc822");
		javax.activation.CommandMap.setDefaultCommandMap(mc_tSendMail_4);
		// add com.sun.mail.handlers to job imports / depenencies (TESB-27110)
		com.sun.mail.handlers.text_plain text_plain_h_tSendMail_4 = null;
		// -- Send the message --
		javax.mail.Transport.send(msg_tSendMail_4);
	} catch(java.lang.Exception e){
globalMap.put("tSendMail_4_ERROR_MESSAGE",e.getMessage());
  		
			throw(e);
		
	}finally{
		props_tSendMail_4.remove("mail.smtp.host");
		props_tSendMail_4.remove("mail.smtp.port");
		
		props_tSendMail_4.remove("mail.mime.encodefilename");
		  
			props_tSendMail_4.remove("mail.smtp.socketFactory.class");
			props_tSendMail_4.remove("mail.smtp.socketFactory.fallback");
			props_tSendMail_4.remove("mail.smtp.socketFactory.port");
		
		props_tSendMail_4.remove("mail.smtp.auth");     
	}

 


	tos_count_tSendMail_4++;

/**
 * [tSendMail_4 main ] stop
 */
	
	/**
	 * [tSendMail_4 process_data_begin ] start
	 */

	

	
	
	currentComponent="tSendMail_4";

	

 



/**
 * [tSendMail_4 process_data_begin ] stop
 */
	
	/**
	 * [tSendMail_4 process_data_end ] start
	 */

	

	
	
	currentComponent="tSendMail_4";

	

 



/**
 * [tSendMail_4 process_data_end ] stop
 */
	
	/**
	 * [tSendMail_4 end ] start
	 */

	

	
	
	currentComponent="tSendMail_4";

	

 

ok_Hash.put("tSendMail_4", true);
end_Hash.put("tSendMail_4", System.currentTimeMillis());




/**
 * [tSendMail_4 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tSendMail_4 finally ] start
	 */

	

	
	
	currentComponent="tSendMail_4";

	

 



/**
 * [tSendMail_4 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tSendMail_4_SUBPROCESS_STATE", 1);
	}
	

public void tSendMail_5Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tSendMail_5_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;





	
	/**
	 * [tSendMail_5 begin ] start
	 */

	

	
		
		ok_Hash.put("tSendMail_5", false);
		start_Hash.put("tSendMail_5", System.currentTimeMillis());
		
	
	currentComponent="tSendMail_5";

	
		int tos_count_tSendMail_5 = 0;
		

 



/**
 * [tSendMail_5 begin ] stop
 */
	
	/**
	 * [tSendMail_5 main ] start
	 */

	

	
	
	currentComponent="tSendMail_5";

	

 

	String smtpHost_tSendMail_5 = "smtp.gmail.com";
        String smtpPort_tSendMail_5 = "465";
	String from_tSendMail_5 = ("dhiaajmi7@gmail.com");
    String to_tSendMail_5 = ("mohameddhia.ajmi@esprit.tn").replace(";",",");
    String cc_tSendMail_5 = (("")==null || "".equals(""))?null:("").replace(";",",");
    String bcc_tSendMail_5 = (("")==null || "".equals(""))?null:("").replace(";",",");
    String subject_tSendMail_5 = ("Job execution failed");
    
	java.util.List<java.util.Map<String, String>> headers_tSendMail_5 = new java.util.ArrayList<java.util.Map<String,String>>();
	java.util.List<String> attachments_tSendMail_5 = new java.util.ArrayList<String>();
	java.util.List<String> contentTransferEncoding_tSendMail_5 = new java.util.ArrayList<String>();

	String message_tSendMail_5 = (("ok") == null || "".equals("ok")) ? "\"\"" : ("ok") ;
	java.util.Properties props_tSendMail_5 = System.getProperties();     
	props_tSendMail_5.put("mail.smtp.host", smtpHost_tSendMail_5);
	props_tSendMail_5.put("mail.smtp.port", smtpPort_tSendMail_5);
		props_tSendMail_5.put("mail.mime.encodefilename", "true");  
		props_tSendMail_5.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props_tSendMail_5.put("mail.smtp.socketFactory.fallback", "false");
		props_tSendMail_5.put("mail.smtp.socketFactory.port", smtpPort_tSendMail_5);     
	try {
		
		
			props_tSendMail_5.put("mail.smtp.auth", "true");
			javax.mail.Session session_tSendMail_5 = javax.mail.Session.getInstance(props_tSendMail_5, new javax.mail.Authenticator(){         
				protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				
                 
	final String decryptedPassword_tSendMail_5 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:c89VNr+9+kIhAPJ1AKpRVnjt8Z4oSx+lCsNqNKsJRACLZNspOOGsIVuO+mQcI/M=");
				
				
				return new javax.mail.PasswordAuthentication("dhiaajmi7@gmail.com", decryptedPassword_tSendMail_5); 
				}         
			});   
		
		
		javax.mail.Message msg_tSendMail_5 = new javax.mail.internet.MimeMessage(session_tSendMail_5);
		msg_tSendMail_5.setFrom(new javax.mail.internet.InternetAddress(from_tSendMail_5, "Admin talend"));
		msg_tSendMail_5.setRecipients(javax.mail.Message.RecipientType.TO,javax.mail.internet.InternetAddress.parse(to_tSendMail_5, false));
		if (cc_tSendMail_5 != null) msg_tSendMail_5.setRecipients(javax.mail.Message.RecipientType.CC, javax.mail.internet.InternetAddress.parse(cc_tSendMail_5, false));
		if (bcc_tSendMail_5 != null) msg_tSendMail_5.setRecipients(javax.mail.Message.RecipientType.BCC, javax.mail.internet.InternetAddress.parse(bcc_tSendMail_5, false));
		msg_tSendMail_5.setSubject(subject_tSendMail_5);

		for (int i_tSendMail_5 = 0; i_tSendMail_5 < headers_tSendMail_5.size(); i_tSendMail_5++) {
			java.util.Map<String, String> header_tSendMail_5 = headers_tSendMail_5.get(i_tSendMail_5);
			msg_tSendMail_5.setHeader(header_tSendMail_5.get("KEY"), header_tSendMail_5.get("VALUE"));    
		}  
		msg_tSendMail_5.setSentDate(new Date());
		msg_tSendMail_5.setHeader("X-Priority", "3"); //High->1 Normal->3 Low->5
		javax.mail.Multipart mp_tSendMail_5 = new javax.mail.internet.MimeMultipart();
		javax.mail.internet.MimeBodyPart mbpText_tSendMail_5 = new javax.mail.internet.MimeBodyPart();
		mbpText_tSendMail_5.setText(message_tSendMail_5,"ISO-8859-15", "plain");
		mp_tSendMail_5.addBodyPart(mbpText_tSendMail_5);
  
		javax.mail.internet.MimeBodyPart mbpFile_tSendMail_5 = null;

		for (int i_tSendMail_5 = 0; i_tSendMail_5 < attachments_tSendMail_5.size(); i_tSendMail_5++){
			String filename_tSendMail_5 = attachments_tSendMail_5.get(i_tSendMail_5);
			javax.activation.FileDataSource fds_tSendMail_5 = null;
			java.io.File file_tSendMail_5 = new java.io.File(filename_tSendMail_5);
			
    		if (file_tSendMail_5.isDirectory()){
				java.io.File[] subFiles_tSendMail_5 = file_tSendMail_5.listFiles();
				for(java.io.File subFile_tSendMail_5 : subFiles_tSendMail_5){
					if (subFile_tSendMail_5.isFile()){
						fds_tSendMail_5 = new javax.activation.FileDataSource(subFile_tSendMail_5.getAbsolutePath());
						mbpFile_tSendMail_5 = new javax.mail.internet.MimeBodyPart();
						mbpFile_tSendMail_5.setDataHandler(new javax.activation.DataHandler(fds_tSendMail_5));
						mbpFile_tSendMail_5.setFileName(javax.mail.internet.MimeUtility.encodeText(fds_tSendMail_5.getName()));
						if(contentTransferEncoding_tSendMail_5.get(i_tSendMail_5).equalsIgnoreCase("base64")){
							mbpFile_tSendMail_5.setHeader("Content-Transfer-Encoding", "base64");
						}
						mp_tSendMail_5.addBodyPart(mbpFile_tSendMail_5);
					}
				}
    		}else{
				mbpFile_tSendMail_5 = new javax.mail.internet.MimeBodyPart();
				fds_tSendMail_5 = new javax.activation.FileDataSource(filename_tSendMail_5);
				mbpFile_tSendMail_5.setDataHandler(new javax.activation.DataHandler(fds_tSendMail_5)); 
				mbpFile_tSendMail_5.setFileName(javax.mail.internet.MimeUtility.encodeText(fds_tSendMail_5.getName()));
				if(contentTransferEncoding_tSendMail_5.get(i_tSendMail_5).equalsIgnoreCase("base64")){
					mbpFile_tSendMail_5.setHeader("Content-Transfer-Encoding", "base64");
				}
				mp_tSendMail_5.addBodyPart(mbpFile_tSendMail_5);
			}
		}
		// -- set the content --
		msg_tSendMail_5.setContent(mp_tSendMail_5);
		// add handlers for main MIME types
		javax.activation.MailcapCommandMap mc_tSendMail_5 = ( javax.activation.MailcapCommandMap)javax.activation.CommandMap.getDefaultCommandMap();
		mc_tSendMail_5.addMailcap("text/html;; x-java-content-handler=com.sun.mail.handlers.text_html");
		mc_tSendMail_5.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml");
		mc_tSendMail_5.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain");
		mc_tSendMail_5.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed");
		mc_tSendMail_5.addMailcap("message/rfc822;; x-java-content-handler=com.sun.mail.handlers.message_rfc822");
		javax.activation.CommandMap.setDefaultCommandMap(mc_tSendMail_5);
		// add com.sun.mail.handlers to job imports / depenencies (TESB-27110)
		com.sun.mail.handlers.text_plain text_plain_h_tSendMail_5 = null;
		// -- Send the message --
		javax.mail.Transport.send(msg_tSendMail_5);
	} catch(java.lang.Exception e){
globalMap.put("tSendMail_5_ERROR_MESSAGE",e.getMessage());
  		
			throw(e);
		
	}finally{
		props_tSendMail_5.remove("mail.smtp.host");
		props_tSendMail_5.remove("mail.smtp.port");
		
		props_tSendMail_5.remove("mail.mime.encodefilename");
		  
			props_tSendMail_5.remove("mail.smtp.socketFactory.class");
			props_tSendMail_5.remove("mail.smtp.socketFactory.fallback");
			props_tSendMail_5.remove("mail.smtp.socketFactory.port");
		
		props_tSendMail_5.remove("mail.smtp.auth");     
	}

 


	tos_count_tSendMail_5++;

/**
 * [tSendMail_5 main ] stop
 */
	
	/**
	 * [tSendMail_5 process_data_begin ] start
	 */

	

	
	
	currentComponent="tSendMail_5";

	

 



/**
 * [tSendMail_5 process_data_begin ] stop
 */
	
	/**
	 * [tSendMail_5 process_data_end ] start
	 */

	

	
	
	currentComponent="tSendMail_5";

	

 



/**
 * [tSendMail_5 process_data_end ] stop
 */
	
	/**
	 * [tSendMail_5 end ] start
	 */

	

	
	
	currentComponent="tSendMail_5";

	

 

ok_Hash.put("tSendMail_5", true);
end_Hash.put("tSendMail_5", System.currentTimeMillis());




/**
 * [tSendMail_5 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tSendMail_5 finally ] start
	 */

	

	
	
	currentComponent="tSendMail_5";

	

 



/**
 * [tSendMail_5 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tSendMail_5_SUBPROCESS_STATE", 1);
	}
	

public void tSendMail_6Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tSendMail_6_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;





	
	/**
	 * [tSendMail_6 begin ] start
	 */

	

	
		
		ok_Hash.put("tSendMail_6", false);
		start_Hash.put("tSendMail_6", System.currentTimeMillis());
		
	
	currentComponent="tSendMail_6";

	
		int tos_count_tSendMail_6 = 0;
		

 



/**
 * [tSendMail_6 begin ] stop
 */
	
	/**
	 * [tSendMail_6 main ] start
	 */

	

	
	
	currentComponent="tSendMail_6";

	

 

	String smtpHost_tSendMail_6 = "smtp.gmail.com";
        String smtpPort_tSendMail_6 = "465";
	String from_tSendMail_6 = ("dhiaajmi7@gmail.com");
    String to_tSendMail_6 = ("mohameddhia.ajmi@esprit.tn").replace(";",",");
    String cc_tSendMail_6 = (("")==null || "".equals(""))?null:("").replace(";",",");
    String bcc_tSendMail_6 = (("")==null || "".equals(""))?null:("").replace(";",",");
    String subject_tSendMail_6 = ("Job execution failed");
    
	java.util.List<java.util.Map<String, String>> headers_tSendMail_6 = new java.util.ArrayList<java.util.Map<String,String>>();
	java.util.List<String> attachments_tSendMail_6 = new java.util.ArrayList<String>();
	java.util.List<String> contentTransferEncoding_tSendMail_6 = new java.util.ArrayList<String>();

	String message_tSendMail_6 = (("ok") == null || "".equals("ok")) ? "\"\"" : ("ok") ;
	java.util.Properties props_tSendMail_6 = System.getProperties();     
	props_tSendMail_6.put("mail.smtp.host", smtpHost_tSendMail_6);
	props_tSendMail_6.put("mail.smtp.port", smtpPort_tSendMail_6);
		props_tSendMail_6.put("mail.mime.encodefilename", "true");  
		props_tSendMail_6.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props_tSendMail_6.put("mail.smtp.socketFactory.fallback", "false");
		props_tSendMail_6.put("mail.smtp.socketFactory.port", smtpPort_tSendMail_6);     
	try {
		
		
			props_tSendMail_6.put("mail.smtp.auth", "true");
			javax.mail.Session session_tSendMail_6 = javax.mail.Session.getInstance(props_tSendMail_6, new javax.mail.Authenticator(){         
				protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				
                 
	final String decryptedPassword_tSendMail_6 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:yZCEIFtq1APFzfpjgZzCP7hk26pDaJpSD2DXnZmq9s0Aw+EL7r6meG50blNn8fU=");
				
				
				return new javax.mail.PasswordAuthentication("dhiaajmi7@gmail.com", decryptedPassword_tSendMail_6); 
				}         
			});   
		
		
		javax.mail.Message msg_tSendMail_6 = new javax.mail.internet.MimeMessage(session_tSendMail_6);
		msg_tSendMail_6.setFrom(new javax.mail.internet.InternetAddress(from_tSendMail_6, "Admin talend"));
		msg_tSendMail_6.setRecipients(javax.mail.Message.RecipientType.TO,javax.mail.internet.InternetAddress.parse(to_tSendMail_6, false));
		if (cc_tSendMail_6 != null) msg_tSendMail_6.setRecipients(javax.mail.Message.RecipientType.CC, javax.mail.internet.InternetAddress.parse(cc_tSendMail_6, false));
		if (bcc_tSendMail_6 != null) msg_tSendMail_6.setRecipients(javax.mail.Message.RecipientType.BCC, javax.mail.internet.InternetAddress.parse(bcc_tSendMail_6, false));
		msg_tSendMail_6.setSubject(subject_tSendMail_6);

		for (int i_tSendMail_6 = 0; i_tSendMail_6 < headers_tSendMail_6.size(); i_tSendMail_6++) {
			java.util.Map<String, String> header_tSendMail_6 = headers_tSendMail_6.get(i_tSendMail_6);
			msg_tSendMail_6.setHeader(header_tSendMail_6.get("KEY"), header_tSendMail_6.get("VALUE"));    
		}  
		msg_tSendMail_6.setSentDate(new Date());
		msg_tSendMail_6.setHeader("X-Priority", "3"); //High->1 Normal->3 Low->5
		javax.mail.Multipart mp_tSendMail_6 = new javax.mail.internet.MimeMultipart();
		javax.mail.internet.MimeBodyPart mbpText_tSendMail_6 = new javax.mail.internet.MimeBodyPart();
		mbpText_tSendMail_6.setText(message_tSendMail_6,"ISO-8859-15", "plain");
		mp_tSendMail_6.addBodyPart(mbpText_tSendMail_6);
  
		javax.mail.internet.MimeBodyPart mbpFile_tSendMail_6 = null;

		for (int i_tSendMail_6 = 0; i_tSendMail_6 < attachments_tSendMail_6.size(); i_tSendMail_6++){
			String filename_tSendMail_6 = attachments_tSendMail_6.get(i_tSendMail_6);
			javax.activation.FileDataSource fds_tSendMail_6 = null;
			java.io.File file_tSendMail_6 = new java.io.File(filename_tSendMail_6);
			
    		if (file_tSendMail_6.isDirectory()){
				java.io.File[] subFiles_tSendMail_6 = file_tSendMail_6.listFiles();
				for(java.io.File subFile_tSendMail_6 : subFiles_tSendMail_6){
					if (subFile_tSendMail_6.isFile()){
						fds_tSendMail_6 = new javax.activation.FileDataSource(subFile_tSendMail_6.getAbsolutePath());
						mbpFile_tSendMail_6 = new javax.mail.internet.MimeBodyPart();
						mbpFile_tSendMail_6.setDataHandler(new javax.activation.DataHandler(fds_tSendMail_6));
						mbpFile_tSendMail_6.setFileName(javax.mail.internet.MimeUtility.encodeText(fds_tSendMail_6.getName()));
						if(contentTransferEncoding_tSendMail_6.get(i_tSendMail_6).equalsIgnoreCase("base64")){
							mbpFile_tSendMail_6.setHeader("Content-Transfer-Encoding", "base64");
						}
						mp_tSendMail_6.addBodyPart(mbpFile_tSendMail_6);
					}
				}
    		}else{
				mbpFile_tSendMail_6 = new javax.mail.internet.MimeBodyPart();
				fds_tSendMail_6 = new javax.activation.FileDataSource(filename_tSendMail_6);
				mbpFile_tSendMail_6.setDataHandler(new javax.activation.DataHandler(fds_tSendMail_6)); 
				mbpFile_tSendMail_6.setFileName(javax.mail.internet.MimeUtility.encodeText(fds_tSendMail_6.getName()));
				if(contentTransferEncoding_tSendMail_6.get(i_tSendMail_6).equalsIgnoreCase("base64")){
					mbpFile_tSendMail_6.setHeader("Content-Transfer-Encoding", "base64");
				}
				mp_tSendMail_6.addBodyPart(mbpFile_tSendMail_6);
			}
		}
		// -- set the content --
		msg_tSendMail_6.setContent(mp_tSendMail_6);
		// add handlers for main MIME types
		javax.activation.MailcapCommandMap mc_tSendMail_6 = ( javax.activation.MailcapCommandMap)javax.activation.CommandMap.getDefaultCommandMap();
		mc_tSendMail_6.addMailcap("text/html;; x-java-content-handler=com.sun.mail.handlers.text_html");
		mc_tSendMail_6.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml");
		mc_tSendMail_6.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain");
		mc_tSendMail_6.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed");
		mc_tSendMail_6.addMailcap("message/rfc822;; x-java-content-handler=com.sun.mail.handlers.message_rfc822");
		javax.activation.CommandMap.setDefaultCommandMap(mc_tSendMail_6);
		// add com.sun.mail.handlers to job imports / depenencies (TESB-27110)
		com.sun.mail.handlers.text_plain text_plain_h_tSendMail_6 = null;
		// -- Send the message --
		javax.mail.Transport.send(msg_tSendMail_6);
	} catch(java.lang.Exception e){
globalMap.put("tSendMail_6_ERROR_MESSAGE",e.getMessage());
  		
			throw(e);
		
	}finally{
		props_tSendMail_6.remove("mail.smtp.host");
		props_tSendMail_6.remove("mail.smtp.port");
		
		props_tSendMail_6.remove("mail.mime.encodefilename");
		  
			props_tSendMail_6.remove("mail.smtp.socketFactory.class");
			props_tSendMail_6.remove("mail.smtp.socketFactory.fallback");
			props_tSendMail_6.remove("mail.smtp.socketFactory.port");
		
		props_tSendMail_6.remove("mail.smtp.auth");     
	}

 


	tos_count_tSendMail_6++;

/**
 * [tSendMail_6 main ] stop
 */
	
	/**
	 * [tSendMail_6 process_data_begin ] start
	 */

	

	
	
	currentComponent="tSendMail_6";

	

 



/**
 * [tSendMail_6 process_data_begin ] stop
 */
	
	/**
	 * [tSendMail_6 process_data_end ] start
	 */

	

	
	
	currentComponent="tSendMail_6";

	

 



/**
 * [tSendMail_6 process_data_end ] stop
 */
	
	/**
	 * [tSendMail_6 end ] start
	 */

	

	
	
	currentComponent="tSendMail_6";

	

 

ok_Hash.put("tSendMail_6", true);
end_Hash.put("tSendMail_6", System.currentTimeMillis());




/**
 * [tSendMail_6 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tSendMail_6 finally ] start
	 */

	

	
	
	currentComponent="tSendMail_6";

	

 



/**
 * [tSendMail_6 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tSendMail_6_SUBPROCESS_STATE", 1);
	}
	

public void tSendMail_7Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tSendMail_7_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;





	
	/**
	 * [tSendMail_7 begin ] start
	 */

	

	
		
		ok_Hash.put("tSendMail_7", false);
		start_Hash.put("tSendMail_7", System.currentTimeMillis());
		
	
	currentComponent="tSendMail_7";

	
		int tos_count_tSendMail_7 = 0;
		

 



/**
 * [tSendMail_7 begin ] stop
 */
	
	/**
	 * [tSendMail_7 main ] start
	 */

	

	
	
	currentComponent="tSendMail_7";

	

 

	String smtpHost_tSendMail_7 = "smtp.gmail.com";
        String smtpPort_tSendMail_7 = "465";
	String from_tSendMail_7 = ("dhiaajmi7@gmail.com");
    String to_tSendMail_7 = ("mohameddhia.ajmi@esprit.tn").replace(";",",");
    String cc_tSendMail_7 = (("")==null || "".equals(""))?null:("").replace(";",",");
    String bcc_tSendMail_7 = (("")==null || "".equals(""))?null:("").replace(";",",");
    String subject_tSendMail_7 = ("Job execution failed");
    
	java.util.List<java.util.Map<String, String>> headers_tSendMail_7 = new java.util.ArrayList<java.util.Map<String,String>>();
	java.util.List<String> attachments_tSendMail_7 = new java.util.ArrayList<String>();
	java.util.List<String> contentTransferEncoding_tSendMail_7 = new java.util.ArrayList<String>();

	String message_tSendMail_7 = (("ok") == null || "".equals("ok")) ? "\"\"" : ("ok") ;
	java.util.Properties props_tSendMail_7 = System.getProperties();     
	props_tSendMail_7.put("mail.smtp.host", smtpHost_tSendMail_7);
	props_tSendMail_7.put("mail.smtp.port", smtpPort_tSendMail_7);
		props_tSendMail_7.put("mail.mime.encodefilename", "true");  
		props_tSendMail_7.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props_tSendMail_7.put("mail.smtp.socketFactory.fallback", "false");
		props_tSendMail_7.put("mail.smtp.socketFactory.port", smtpPort_tSendMail_7);     
	try {
		
		
			props_tSendMail_7.put("mail.smtp.auth", "true");
			javax.mail.Session session_tSendMail_7 = javax.mail.Session.getInstance(props_tSendMail_7, new javax.mail.Authenticator(){         
				protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				
                 
	final String decryptedPassword_tSendMail_7 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:lSH9p+pomoIa4BqgkzfH7Kx9L0lQw+AjFF3X2wwd6MbECn5FDj83UGkBwKZJS2c=");
				
				
				return new javax.mail.PasswordAuthentication("dhiaajmi7@gmail.com", decryptedPassword_tSendMail_7); 
				}         
			});   
		
		
		javax.mail.Message msg_tSendMail_7 = new javax.mail.internet.MimeMessage(session_tSendMail_7);
		msg_tSendMail_7.setFrom(new javax.mail.internet.InternetAddress(from_tSendMail_7, "Admin talend"));
		msg_tSendMail_7.setRecipients(javax.mail.Message.RecipientType.TO,javax.mail.internet.InternetAddress.parse(to_tSendMail_7, false));
		if (cc_tSendMail_7 != null) msg_tSendMail_7.setRecipients(javax.mail.Message.RecipientType.CC, javax.mail.internet.InternetAddress.parse(cc_tSendMail_7, false));
		if (bcc_tSendMail_7 != null) msg_tSendMail_7.setRecipients(javax.mail.Message.RecipientType.BCC, javax.mail.internet.InternetAddress.parse(bcc_tSendMail_7, false));
		msg_tSendMail_7.setSubject(subject_tSendMail_7);

		for (int i_tSendMail_7 = 0; i_tSendMail_7 < headers_tSendMail_7.size(); i_tSendMail_7++) {
			java.util.Map<String, String> header_tSendMail_7 = headers_tSendMail_7.get(i_tSendMail_7);
			msg_tSendMail_7.setHeader(header_tSendMail_7.get("KEY"), header_tSendMail_7.get("VALUE"));    
		}  
		msg_tSendMail_7.setSentDate(new Date());
		msg_tSendMail_7.setHeader("X-Priority", "3"); //High->1 Normal->3 Low->5
		javax.mail.Multipart mp_tSendMail_7 = new javax.mail.internet.MimeMultipart();
		javax.mail.internet.MimeBodyPart mbpText_tSendMail_7 = new javax.mail.internet.MimeBodyPart();
		mbpText_tSendMail_7.setText(message_tSendMail_7,"ISO-8859-15", "plain");
		mp_tSendMail_7.addBodyPart(mbpText_tSendMail_7);
  
		javax.mail.internet.MimeBodyPart mbpFile_tSendMail_7 = null;

		for (int i_tSendMail_7 = 0; i_tSendMail_7 < attachments_tSendMail_7.size(); i_tSendMail_7++){
			String filename_tSendMail_7 = attachments_tSendMail_7.get(i_tSendMail_7);
			javax.activation.FileDataSource fds_tSendMail_7 = null;
			java.io.File file_tSendMail_7 = new java.io.File(filename_tSendMail_7);
			
    		if (file_tSendMail_7.isDirectory()){
				java.io.File[] subFiles_tSendMail_7 = file_tSendMail_7.listFiles();
				for(java.io.File subFile_tSendMail_7 : subFiles_tSendMail_7){
					if (subFile_tSendMail_7.isFile()){
						fds_tSendMail_7 = new javax.activation.FileDataSource(subFile_tSendMail_7.getAbsolutePath());
						mbpFile_tSendMail_7 = new javax.mail.internet.MimeBodyPart();
						mbpFile_tSendMail_7.setDataHandler(new javax.activation.DataHandler(fds_tSendMail_7));
						mbpFile_tSendMail_7.setFileName(javax.mail.internet.MimeUtility.encodeText(fds_tSendMail_7.getName()));
						if(contentTransferEncoding_tSendMail_7.get(i_tSendMail_7).equalsIgnoreCase("base64")){
							mbpFile_tSendMail_7.setHeader("Content-Transfer-Encoding", "base64");
						}
						mp_tSendMail_7.addBodyPart(mbpFile_tSendMail_7);
					}
				}
    		}else{
				mbpFile_tSendMail_7 = new javax.mail.internet.MimeBodyPart();
				fds_tSendMail_7 = new javax.activation.FileDataSource(filename_tSendMail_7);
				mbpFile_tSendMail_7.setDataHandler(new javax.activation.DataHandler(fds_tSendMail_7)); 
				mbpFile_tSendMail_7.setFileName(javax.mail.internet.MimeUtility.encodeText(fds_tSendMail_7.getName()));
				if(contentTransferEncoding_tSendMail_7.get(i_tSendMail_7).equalsIgnoreCase("base64")){
					mbpFile_tSendMail_7.setHeader("Content-Transfer-Encoding", "base64");
				}
				mp_tSendMail_7.addBodyPart(mbpFile_tSendMail_7);
			}
		}
		// -- set the content --
		msg_tSendMail_7.setContent(mp_tSendMail_7);
		// add handlers for main MIME types
		javax.activation.MailcapCommandMap mc_tSendMail_7 = ( javax.activation.MailcapCommandMap)javax.activation.CommandMap.getDefaultCommandMap();
		mc_tSendMail_7.addMailcap("text/html;; x-java-content-handler=com.sun.mail.handlers.text_html");
		mc_tSendMail_7.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml");
		mc_tSendMail_7.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain");
		mc_tSendMail_7.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed");
		mc_tSendMail_7.addMailcap("message/rfc822;; x-java-content-handler=com.sun.mail.handlers.message_rfc822");
		javax.activation.CommandMap.setDefaultCommandMap(mc_tSendMail_7);
		// add com.sun.mail.handlers to job imports / depenencies (TESB-27110)
		com.sun.mail.handlers.text_plain text_plain_h_tSendMail_7 = null;
		// -- Send the message --
		javax.mail.Transport.send(msg_tSendMail_7);
	} catch(java.lang.Exception e){
globalMap.put("tSendMail_7_ERROR_MESSAGE",e.getMessage());
  		
			throw(e);
		
	}finally{
		props_tSendMail_7.remove("mail.smtp.host");
		props_tSendMail_7.remove("mail.smtp.port");
		
		props_tSendMail_7.remove("mail.mime.encodefilename");
		  
			props_tSendMail_7.remove("mail.smtp.socketFactory.class");
			props_tSendMail_7.remove("mail.smtp.socketFactory.fallback");
			props_tSendMail_7.remove("mail.smtp.socketFactory.port");
		
		props_tSendMail_7.remove("mail.smtp.auth");     
	}

 


	tos_count_tSendMail_7++;

/**
 * [tSendMail_7 main ] stop
 */
	
	/**
	 * [tSendMail_7 process_data_begin ] start
	 */

	

	
	
	currentComponent="tSendMail_7";

	

 



/**
 * [tSendMail_7 process_data_begin ] stop
 */
	
	/**
	 * [tSendMail_7 process_data_end ] start
	 */

	

	
	
	currentComponent="tSendMail_7";

	

 



/**
 * [tSendMail_7 process_data_end ] stop
 */
	
	/**
	 * [tSendMail_7 end ] start
	 */

	

	
	
	currentComponent="tSendMail_7";

	

 

ok_Hash.put("tSendMail_7", true);
end_Hash.put("tSendMail_7", System.currentTimeMillis());




/**
 * [tSendMail_7 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tSendMail_7 finally ] start
	 */

	

	
	
	currentComponent="tSendMail_7";

	

 



/**
 * [tSendMail_7 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tSendMail_7_SUBPROCESS_STATE", 1);
	}
	

public void tSendMail_8Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tSendMail_8_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;





	
	/**
	 * [tSendMail_8 begin ] start
	 */

	

	
		
		ok_Hash.put("tSendMail_8", false);
		start_Hash.put("tSendMail_8", System.currentTimeMillis());
		
	
	currentComponent="tSendMail_8";

	
		int tos_count_tSendMail_8 = 0;
		

 



/**
 * [tSendMail_8 begin ] stop
 */
	
	/**
	 * [tSendMail_8 main ] start
	 */

	

	
	
	currentComponent="tSendMail_8";

	

 

	String smtpHost_tSendMail_8 = "smtp.gmail.com";
        String smtpPort_tSendMail_8 = "465";
	String from_tSendMail_8 = ("dhiaajmi7@gmail.com");
    String to_tSendMail_8 = ("mohameddhia.ajmi@esprit.tn").replace(";",",");
    String cc_tSendMail_8 = (("")==null || "".equals(""))?null:("").replace(";",",");
    String bcc_tSendMail_8 = (("")==null || "".equals(""))?null:("").replace(";",",");
    String subject_tSendMail_8 = ("Job execution failed");
    
	java.util.List<java.util.Map<String, String>> headers_tSendMail_8 = new java.util.ArrayList<java.util.Map<String,String>>();
	java.util.List<String> attachments_tSendMail_8 = new java.util.ArrayList<String>();
	java.util.List<String> contentTransferEncoding_tSendMail_8 = new java.util.ArrayList<String>();

	String message_tSendMail_8 = (("ok") == null || "".equals("ok")) ? "\"\"" : ("ok") ;
	java.util.Properties props_tSendMail_8 = System.getProperties();     
	props_tSendMail_8.put("mail.smtp.host", smtpHost_tSendMail_8);
	props_tSendMail_8.put("mail.smtp.port", smtpPort_tSendMail_8);
		props_tSendMail_8.put("mail.mime.encodefilename", "true");  
		props_tSendMail_8.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props_tSendMail_8.put("mail.smtp.socketFactory.fallback", "false");
		props_tSendMail_8.put("mail.smtp.socketFactory.port", smtpPort_tSendMail_8);     
	try {
		
		
			props_tSendMail_8.put("mail.smtp.auth", "true");
			javax.mail.Session session_tSendMail_8 = javax.mail.Session.getInstance(props_tSendMail_8, new javax.mail.Authenticator(){         
				protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				
                 
	final String decryptedPassword_tSendMail_8 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:wdsWEptibgB7GwsZHNaFATPxF7DslZIcvUzM0kDuzAjZHvnBf6UUxPBzPoV/dvE=");
				
				
				return new javax.mail.PasswordAuthentication("dhiaajmi7@gmail.com", decryptedPassword_tSendMail_8); 
				}         
			});   
		
		
		javax.mail.Message msg_tSendMail_8 = new javax.mail.internet.MimeMessage(session_tSendMail_8);
		msg_tSendMail_8.setFrom(new javax.mail.internet.InternetAddress(from_tSendMail_8, "Admin talend"));
		msg_tSendMail_8.setRecipients(javax.mail.Message.RecipientType.TO,javax.mail.internet.InternetAddress.parse(to_tSendMail_8, false));
		if (cc_tSendMail_8 != null) msg_tSendMail_8.setRecipients(javax.mail.Message.RecipientType.CC, javax.mail.internet.InternetAddress.parse(cc_tSendMail_8, false));
		if (bcc_tSendMail_8 != null) msg_tSendMail_8.setRecipients(javax.mail.Message.RecipientType.BCC, javax.mail.internet.InternetAddress.parse(bcc_tSendMail_8, false));
		msg_tSendMail_8.setSubject(subject_tSendMail_8);

		for (int i_tSendMail_8 = 0; i_tSendMail_8 < headers_tSendMail_8.size(); i_tSendMail_8++) {
			java.util.Map<String, String> header_tSendMail_8 = headers_tSendMail_8.get(i_tSendMail_8);
			msg_tSendMail_8.setHeader(header_tSendMail_8.get("KEY"), header_tSendMail_8.get("VALUE"));    
		}  
		msg_tSendMail_8.setSentDate(new Date());
		msg_tSendMail_8.setHeader("X-Priority", "3"); //High->1 Normal->3 Low->5
		javax.mail.Multipart mp_tSendMail_8 = new javax.mail.internet.MimeMultipart();
		javax.mail.internet.MimeBodyPart mbpText_tSendMail_8 = new javax.mail.internet.MimeBodyPart();
		mbpText_tSendMail_8.setText(message_tSendMail_8,"ISO-8859-15", "plain");
		mp_tSendMail_8.addBodyPart(mbpText_tSendMail_8);
  
		javax.mail.internet.MimeBodyPart mbpFile_tSendMail_8 = null;

		for (int i_tSendMail_8 = 0; i_tSendMail_8 < attachments_tSendMail_8.size(); i_tSendMail_8++){
			String filename_tSendMail_8 = attachments_tSendMail_8.get(i_tSendMail_8);
			javax.activation.FileDataSource fds_tSendMail_8 = null;
			java.io.File file_tSendMail_8 = new java.io.File(filename_tSendMail_8);
			
    		if (file_tSendMail_8.isDirectory()){
				java.io.File[] subFiles_tSendMail_8 = file_tSendMail_8.listFiles();
				for(java.io.File subFile_tSendMail_8 : subFiles_tSendMail_8){
					if (subFile_tSendMail_8.isFile()){
						fds_tSendMail_8 = new javax.activation.FileDataSource(subFile_tSendMail_8.getAbsolutePath());
						mbpFile_tSendMail_8 = new javax.mail.internet.MimeBodyPart();
						mbpFile_tSendMail_8.setDataHandler(new javax.activation.DataHandler(fds_tSendMail_8));
						mbpFile_tSendMail_8.setFileName(javax.mail.internet.MimeUtility.encodeText(fds_tSendMail_8.getName()));
						if(contentTransferEncoding_tSendMail_8.get(i_tSendMail_8).equalsIgnoreCase("base64")){
							mbpFile_tSendMail_8.setHeader("Content-Transfer-Encoding", "base64");
						}
						mp_tSendMail_8.addBodyPart(mbpFile_tSendMail_8);
					}
				}
    		}else{
				mbpFile_tSendMail_8 = new javax.mail.internet.MimeBodyPart();
				fds_tSendMail_8 = new javax.activation.FileDataSource(filename_tSendMail_8);
				mbpFile_tSendMail_8.setDataHandler(new javax.activation.DataHandler(fds_tSendMail_8)); 
				mbpFile_tSendMail_8.setFileName(javax.mail.internet.MimeUtility.encodeText(fds_tSendMail_8.getName()));
				if(contentTransferEncoding_tSendMail_8.get(i_tSendMail_8).equalsIgnoreCase("base64")){
					mbpFile_tSendMail_8.setHeader("Content-Transfer-Encoding", "base64");
				}
				mp_tSendMail_8.addBodyPart(mbpFile_tSendMail_8);
			}
		}
		// -- set the content --
		msg_tSendMail_8.setContent(mp_tSendMail_8);
		// add handlers for main MIME types
		javax.activation.MailcapCommandMap mc_tSendMail_8 = ( javax.activation.MailcapCommandMap)javax.activation.CommandMap.getDefaultCommandMap();
		mc_tSendMail_8.addMailcap("text/html;; x-java-content-handler=com.sun.mail.handlers.text_html");
		mc_tSendMail_8.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml");
		mc_tSendMail_8.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain");
		mc_tSendMail_8.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed");
		mc_tSendMail_8.addMailcap("message/rfc822;; x-java-content-handler=com.sun.mail.handlers.message_rfc822");
		javax.activation.CommandMap.setDefaultCommandMap(mc_tSendMail_8);
		// add com.sun.mail.handlers to job imports / depenencies (TESB-27110)
		com.sun.mail.handlers.text_plain text_plain_h_tSendMail_8 = null;
		// -- Send the message --
		javax.mail.Transport.send(msg_tSendMail_8);
	} catch(java.lang.Exception e){
globalMap.put("tSendMail_8_ERROR_MESSAGE",e.getMessage());
  		
			throw(e);
		
	}finally{
		props_tSendMail_8.remove("mail.smtp.host");
		props_tSendMail_8.remove("mail.smtp.port");
		
		props_tSendMail_8.remove("mail.mime.encodefilename");
		  
			props_tSendMail_8.remove("mail.smtp.socketFactory.class");
			props_tSendMail_8.remove("mail.smtp.socketFactory.fallback");
			props_tSendMail_8.remove("mail.smtp.socketFactory.port");
		
		props_tSendMail_8.remove("mail.smtp.auth");     
	}

 


	tos_count_tSendMail_8++;

/**
 * [tSendMail_8 main ] stop
 */
	
	/**
	 * [tSendMail_8 process_data_begin ] start
	 */

	

	
	
	currentComponent="tSendMail_8";

	

 



/**
 * [tSendMail_8 process_data_begin ] stop
 */
	
	/**
	 * [tSendMail_8 process_data_end ] start
	 */

	

	
	
	currentComponent="tSendMail_8";

	

 



/**
 * [tSendMail_8 process_data_end ] stop
 */
	
	/**
	 * [tSendMail_8 end ] start
	 */

	

	
	
	currentComponent="tSendMail_8";

	

 

ok_Hash.put("tSendMail_8", true);
end_Hash.put("tSendMail_8", System.currentTimeMillis());




/**
 * [tSendMail_8 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tSendMail_8 finally ] start
	 */

	

	
	
	currentComponent="tSendMail_8";

	

 



/**
 * [tSendMail_8 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tSendMail_8_SUBPROCESS_STATE", 1);
	}
	

public void tSendMail_9Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tSendMail_9_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;





	
	/**
	 * [tSendMail_9 begin ] start
	 */

	

	
		
		ok_Hash.put("tSendMail_9", false);
		start_Hash.put("tSendMail_9", System.currentTimeMillis());
		
	
	currentComponent="tSendMail_9";

	
		int tos_count_tSendMail_9 = 0;
		

 



/**
 * [tSendMail_9 begin ] stop
 */
	
	/**
	 * [tSendMail_9 main ] start
	 */

	

	
	
	currentComponent="tSendMail_9";

	

 

	String smtpHost_tSendMail_9 = "smtp.gmail.com";
        String smtpPort_tSendMail_9 = "465";
	String from_tSendMail_9 = ("dhiaajmi7@gmail.com");
    String to_tSendMail_9 = ("mohameddhia.ajmi@esprit.tn").replace(";",",");
    String cc_tSendMail_9 = (("")==null || "".equals(""))?null:("").replace(";",",");
    String bcc_tSendMail_9 = (("")==null || "".equals(""))?null:("").replace(";",",");
    String subject_tSendMail_9 = ("Job execution failed");
    
	java.util.List<java.util.Map<String, String>> headers_tSendMail_9 = new java.util.ArrayList<java.util.Map<String,String>>();
	java.util.List<String> attachments_tSendMail_9 = new java.util.ArrayList<String>();
	java.util.List<String> contentTransferEncoding_tSendMail_9 = new java.util.ArrayList<String>();

	String message_tSendMail_9 = (("ok") == null || "".equals("ok")) ? "\"\"" : ("ok") ;
	java.util.Properties props_tSendMail_9 = System.getProperties();     
	props_tSendMail_9.put("mail.smtp.host", smtpHost_tSendMail_9);
	props_tSendMail_9.put("mail.smtp.port", smtpPort_tSendMail_9);
		props_tSendMail_9.put("mail.mime.encodefilename", "true");  
		props_tSendMail_9.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props_tSendMail_9.put("mail.smtp.socketFactory.fallback", "false");
		props_tSendMail_9.put("mail.smtp.socketFactory.port", smtpPort_tSendMail_9);     
	try {
		
		
			props_tSendMail_9.put("mail.smtp.auth", "true");
			javax.mail.Session session_tSendMail_9 = javax.mail.Session.getInstance(props_tSendMail_9, new javax.mail.Authenticator(){         
				protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				
                 
	final String decryptedPassword_tSendMail_9 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:FIGjPC/FIShGkAohYyOiN5PN6eo68oxYzwTWJhgR56j6RUpBGLAAZ6XYy+0GXQ0=");
				
				
				return new javax.mail.PasswordAuthentication("dhiaajmi7@gmail.com", decryptedPassword_tSendMail_9); 
				}         
			});   
		
		
		javax.mail.Message msg_tSendMail_9 = new javax.mail.internet.MimeMessage(session_tSendMail_9);
		msg_tSendMail_9.setFrom(new javax.mail.internet.InternetAddress(from_tSendMail_9, "Admin talend"));
		msg_tSendMail_9.setRecipients(javax.mail.Message.RecipientType.TO,javax.mail.internet.InternetAddress.parse(to_tSendMail_9, false));
		if (cc_tSendMail_9 != null) msg_tSendMail_9.setRecipients(javax.mail.Message.RecipientType.CC, javax.mail.internet.InternetAddress.parse(cc_tSendMail_9, false));
		if (bcc_tSendMail_9 != null) msg_tSendMail_9.setRecipients(javax.mail.Message.RecipientType.BCC, javax.mail.internet.InternetAddress.parse(bcc_tSendMail_9, false));
		msg_tSendMail_9.setSubject(subject_tSendMail_9);

		for (int i_tSendMail_9 = 0; i_tSendMail_9 < headers_tSendMail_9.size(); i_tSendMail_9++) {
			java.util.Map<String, String> header_tSendMail_9 = headers_tSendMail_9.get(i_tSendMail_9);
			msg_tSendMail_9.setHeader(header_tSendMail_9.get("KEY"), header_tSendMail_9.get("VALUE"));    
		}  
		msg_tSendMail_9.setSentDate(new Date());
		msg_tSendMail_9.setHeader("X-Priority", "3"); //High->1 Normal->3 Low->5
		javax.mail.Multipart mp_tSendMail_9 = new javax.mail.internet.MimeMultipart();
		javax.mail.internet.MimeBodyPart mbpText_tSendMail_9 = new javax.mail.internet.MimeBodyPart();
		mbpText_tSendMail_9.setText(message_tSendMail_9,"ISO-8859-15", "plain");
		mp_tSendMail_9.addBodyPart(mbpText_tSendMail_9);
  
		javax.mail.internet.MimeBodyPart mbpFile_tSendMail_9 = null;

		for (int i_tSendMail_9 = 0; i_tSendMail_9 < attachments_tSendMail_9.size(); i_tSendMail_9++){
			String filename_tSendMail_9 = attachments_tSendMail_9.get(i_tSendMail_9);
			javax.activation.FileDataSource fds_tSendMail_9 = null;
			java.io.File file_tSendMail_9 = new java.io.File(filename_tSendMail_9);
			
    		if (file_tSendMail_9.isDirectory()){
				java.io.File[] subFiles_tSendMail_9 = file_tSendMail_9.listFiles();
				for(java.io.File subFile_tSendMail_9 : subFiles_tSendMail_9){
					if (subFile_tSendMail_9.isFile()){
						fds_tSendMail_9 = new javax.activation.FileDataSource(subFile_tSendMail_9.getAbsolutePath());
						mbpFile_tSendMail_9 = new javax.mail.internet.MimeBodyPart();
						mbpFile_tSendMail_9.setDataHandler(new javax.activation.DataHandler(fds_tSendMail_9));
						mbpFile_tSendMail_9.setFileName(javax.mail.internet.MimeUtility.encodeText(fds_tSendMail_9.getName()));
						if(contentTransferEncoding_tSendMail_9.get(i_tSendMail_9).equalsIgnoreCase("base64")){
							mbpFile_tSendMail_9.setHeader("Content-Transfer-Encoding", "base64");
						}
						mp_tSendMail_9.addBodyPart(mbpFile_tSendMail_9);
					}
				}
    		}else{
				mbpFile_tSendMail_9 = new javax.mail.internet.MimeBodyPart();
				fds_tSendMail_9 = new javax.activation.FileDataSource(filename_tSendMail_9);
				mbpFile_tSendMail_9.setDataHandler(new javax.activation.DataHandler(fds_tSendMail_9)); 
				mbpFile_tSendMail_9.setFileName(javax.mail.internet.MimeUtility.encodeText(fds_tSendMail_9.getName()));
				if(contentTransferEncoding_tSendMail_9.get(i_tSendMail_9).equalsIgnoreCase("base64")){
					mbpFile_tSendMail_9.setHeader("Content-Transfer-Encoding", "base64");
				}
				mp_tSendMail_9.addBodyPart(mbpFile_tSendMail_9);
			}
		}
		// -- set the content --
		msg_tSendMail_9.setContent(mp_tSendMail_9);
		// add handlers for main MIME types
		javax.activation.MailcapCommandMap mc_tSendMail_9 = ( javax.activation.MailcapCommandMap)javax.activation.CommandMap.getDefaultCommandMap();
		mc_tSendMail_9.addMailcap("text/html;; x-java-content-handler=com.sun.mail.handlers.text_html");
		mc_tSendMail_9.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml");
		mc_tSendMail_9.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain");
		mc_tSendMail_9.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed");
		mc_tSendMail_9.addMailcap("message/rfc822;; x-java-content-handler=com.sun.mail.handlers.message_rfc822");
		javax.activation.CommandMap.setDefaultCommandMap(mc_tSendMail_9);
		// add com.sun.mail.handlers to job imports / depenencies (TESB-27110)
		com.sun.mail.handlers.text_plain text_plain_h_tSendMail_9 = null;
		// -- Send the message --
		javax.mail.Transport.send(msg_tSendMail_9);
	} catch(java.lang.Exception e){
globalMap.put("tSendMail_9_ERROR_MESSAGE",e.getMessage());
  		
			throw(e);
		
	}finally{
		props_tSendMail_9.remove("mail.smtp.host");
		props_tSendMail_9.remove("mail.smtp.port");
		
		props_tSendMail_9.remove("mail.mime.encodefilename");
		  
			props_tSendMail_9.remove("mail.smtp.socketFactory.class");
			props_tSendMail_9.remove("mail.smtp.socketFactory.fallback");
			props_tSendMail_9.remove("mail.smtp.socketFactory.port");
		
		props_tSendMail_9.remove("mail.smtp.auth");     
	}

 


	tos_count_tSendMail_9++;

/**
 * [tSendMail_9 main ] stop
 */
	
	/**
	 * [tSendMail_9 process_data_begin ] start
	 */

	

	
	
	currentComponent="tSendMail_9";

	

 



/**
 * [tSendMail_9 process_data_begin ] stop
 */
	
	/**
	 * [tSendMail_9 process_data_end ] start
	 */

	

	
	
	currentComponent="tSendMail_9";

	

 



/**
 * [tSendMail_9 process_data_end ] stop
 */
	
	/**
	 * [tSendMail_9 end ] start
	 */

	

	
	
	currentComponent="tSendMail_9";

	

 

ok_Hash.put("tSendMail_9", true);
end_Hash.put("tSendMail_9", System.currentTimeMillis());




/**
 * [tSendMail_9 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tSendMail_9 finally ] start
	 */

	

	
	
	currentComponent="tSendMail_9";

	

 



/**
 * [tSendMail_9 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tSendMail_9_SUBPROCESS_STATE", 1);
	}
	
    public String resuming_logs_dir_path = null;
    public String resuming_checkpoint_path = null;
    public String parent_part_launcher = null;
    private String resumeEntryMethodName = null;
    private boolean globalResumeTicket = false;

    public boolean watch = false;
    // portStats is null, it means don't execute the statistics
    public Integer portStats = null;
    public int portTraces = 4334;
    public String clientHost;
    public String defaultClientHost = "localhost";
    public String contextStr = "Default";
    public boolean isDefaultContext = true;
    public String pid = "0";
    public String rootPid = null;
    public String fatherPid = null;
    public String fatherNode = null;
    public long startTime = 0;
    public boolean isChildJob = false;
    public String log4jLevel = "";
    
    private boolean enableLogStash;

    private boolean execStat = true;

    private ThreadLocal<java.util.Map<String, String>> threadLocal = new ThreadLocal<java.util.Map<String, String>>() {
        protected java.util.Map<String, String> initialValue() {
            java.util.Map<String,String> threadRunResultMap = new java.util.HashMap<String, String>();
            threadRunResultMap.put("errorCode", null);
            threadRunResultMap.put("status", "");
            return threadRunResultMap;
        };
    };


    protected PropertiesWithType context_param = new PropertiesWithType();
    public java.util.Map<String, Object> parentContextMap = new java.util.HashMap<String, Object>();

    public String status= "";
    

    public static void main(String[] args){
        final master masterClass = new master();

        int exitCode = masterClass.runJobInTOS(args);

        System.exit(exitCode);
    }


    public String[][] runJob(String[] args) {

        int exitCode = runJobInTOS(args);
        String[][] bufferValue = new String[][] { { Integer.toString(exitCode) } };

        return bufferValue;
    }

    public boolean hastBufferOutputComponent() {
		boolean hastBufferOutput = false;
    	
        return hastBufferOutput;
    }

    public int runJobInTOS(String[] args) {
	   	// reset status
	   	status = "";
	   	
        String lastStr = "";
        for (String arg : args) {
            if (arg.equalsIgnoreCase("--context_param")) {
                lastStr = arg;
            } else if (lastStr.equals("")) {
                evalParam(arg);
            } else {
                evalParam(lastStr + " " + arg);
                lastStr = "";
            }
        }
        enableLogStash = "true".equalsIgnoreCase(System.getProperty("audit.enabled"));

    	
    	

        if(clientHost == null) {
            clientHost = defaultClientHost;
        }

        if(pid == null || "0".equals(pid)) {
            pid = TalendString.getAsciiRandomString(6);
        }

        if (rootPid==null) {
            rootPid = pid;
        }
        if (fatherPid==null) {
            fatherPid = pid;
        }else{
            isChildJob = true;
        }

        if (portStats != null) {
            // portStats = -1; //for testing
            if (portStats < 0 || portStats > 65535) {
                // issue:10869, the portStats is invalid, so this client socket can't open
                System.err.println("The statistics socket port " + portStats + " is invalid.");
                execStat = false;
            }
        } else {
            execStat = false;
        }
        boolean inOSGi = routines.system.BundleUtils.inOSGi();

        if (inOSGi) {
            java.util.Dictionary<String, Object> jobProperties = routines.system.BundleUtils.getJobProperties(jobName);

            if (jobProperties != null && jobProperties.get("context") != null) {
                contextStr = (String)jobProperties.get("context");
            }
        }

        try {
            //call job/subjob with an existing context, like: --context=production. if without this parameter, there will use the default context instead.
            java.io.InputStream inContext = master.class.getClassLoader().getResourceAsStream("pgs_stage/master_0_1/contexts/" + contextStr + ".properties");
            if (inContext == null) {
                inContext = master.class.getClassLoader().getResourceAsStream("config/contexts/" + contextStr + ".properties");
            }
            if (inContext != null) {
                try {
                    //defaultProps is in order to keep the original context value
                    if(context != null && context.isEmpty()) {
	                defaultProps.load(inContext);
	                context = new ContextProperties(defaultProps);
                    }
                } finally {
                    inContext.close();
                }
            } else if (!isDefaultContext) {
                //print info and job continue to run, for case: context_param is not empty.
                System.err.println("Could not find the context " + contextStr);
            }

            if(!context_param.isEmpty()) {
                context.putAll(context_param);
				//set types for params from parentJobs
				for (Object key: context_param.keySet()){
					String context_key = key.toString();
					String context_type = context_param.getContextType(context_key);
					context.setContextType(context_key, context_type);

				}
            }
            class ContextProcessing {
                private void processContext_0() {
                } 
                public void processAllContext() {
                        processContext_0();
                }
            }

            new ContextProcessing().processAllContext();
        } catch (java.io.IOException ie) {
            System.err.println("Could not load context "+contextStr);
            ie.printStackTrace();
        }

        // get context value from parent directly
        if (parentContextMap != null && !parentContextMap.isEmpty()) {
        }

        //Resume: init the resumeUtil
        resumeEntryMethodName = ResumeUtil.getResumeEntryMethodName(resuming_checkpoint_path);
        resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
        resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName, jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
        //Resume: jobStart
        resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "","","","",resumeUtil.convertToJsonText(context,parametersToEncrypt));

if(execStat) {
    try {
        runStat.openSocket(!isChildJob);
        runStat.setAllPID(rootPid, fatherPid, pid, jobName);
        runStat.startThreadStat(clientHost, portStats);
        runStat.updateStatOnJob(RunStat.JOBSTART, fatherNode);
    } catch (java.io.IOException ioException) {
        ioException.printStackTrace();
    }
}



	
	    java.util.concurrent.ConcurrentHashMap<Object, Object> concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<Object, Object>();
	    globalMap.put("concurrentHashMap", concurrentHashMap);
	

    long startUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    long endUsedMemory = 0;
    long end = 0;

    startTime = System.currentTimeMillis();


this.globalResumeTicket = true;//to run tPreJob





this.globalResumeTicket = false;//to run others jobs

try {
errorCode = null;tRunJob_1Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tRunJob_1) {
globalMap.put("tRunJob_1_SUBPROCESS_STATE", -1);

e_tRunJob_1.printStackTrace();

}

this.globalResumeTicket = true;//to run tPostJob




        end = System.currentTimeMillis();

        if (watch) {
            System.out.println((end-startTime)+" milliseconds");
        }

        endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        if (false) {
            System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : master");
        }



if (execStat) {
    runStat.updateStatOnJob(RunStat.JOBEND, fatherNode);
    runStat.stopThreadStat();
}
    int returnCode = 0;


    if(errorCode == null) {
         returnCode = status != null && status.equals("failure") ? 1 : 0;
    } else {
         returnCode = errorCode.intValue();
    }
    resumeUtil.addLog("JOB_ENDED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "","" + returnCode,"","","");

    return returnCode;

  }

    // only for OSGi env
    public void destroy() {


    }














    private java.util.Map<String, Object> getSharedConnections4REST() {
        java.util.Map<String, Object> connections = new java.util.HashMap<String, Object>();






        return connections;
    }

    private void evalParam(String arg) {
        if (arg.startsWith("--resuming_logs_dir_path")) {
            resuming_logs_dir_path = arg.substring(25);
        } else if (arg.startsWith("--resuming_checkpoint_path")) {
            resuming_checkpoint_path = arg.substring(27);
        } else if (arg.startsWith("--parent_part_launcher")) {
            parent_part_launcher = arg.substring(23);
        } else if (arg.startsWith("--watch")) {
            watch = true;
        } else if (arg.startsWith("--stat_port=")) {
            String portStatsStr = arg.substring(12);
            if (portStatsStr != null && !portStatsStr.equals("null")) {
                portStats = Integer.parseInt(portStatsStr);
            }
        } else if (arg.startsWith("--trace_port=")) {
            portTraces = Integer.parseInt(arg.substring(13));
        } else if (arg.startsWith("--client_host=")) {
            clientHost = arg.substring(14);
        } else if (arg.startsWith("--context=")) {
            contextStr = arg.substring(10);
            isDefaultContext = false;
        } else if (arg.startsWith("--father_pid=")) {
            fatherPid = arg.substring(13);
        } else if (arg.startsWith("--root_pid=")) {
            rootPid = arg.substring(11);
        } else if (arg.startsWith("--father_node=")) {
            fatherNode = arg.substring(14);
        } else if (arg.startsWith("--pid=")) {
            pid = arg.substring(6);
        } else if (arg.startsWith("--context_type")) {
            String keyValue = arg.substring(15);
			int index = -1;
            if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
                if (fatherPid==null) {
                    context_param.setContextType(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
                } else { // the subjob won't escape the especial chars
                    context_param.setContextType(keyValue.substring(0, index), keyValue.substring(index + 1) );
                }

            }

		} else if (arg.startsWith("--context_param")) {
            String keyValue = arg.substring(16);
            int index = -1;
            if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
                if (fatherPid==null) {
                    context_param.put(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
                } else { // the subjob won't escape the especial chars
                    context_param.put(keyValue.substring(0, index), keyValue.substring(index + 1) );
                }
            }
        } else if (arg.startsWith("--log4jLevel=")) {
            log4jLevel = arg.substring(13);
		} else if (arg.startsWith("--audit.enabled") && arg.contains("=")) {//for trunjob call
		    final int equal = arg.indexOf('=');
			final String key = arg.substring("--".length(), equal);
			System.setProperty(key, arg.substring(equal + 1));
		}
    }
    
    private static final String NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY = "<TALEND_NULL>";

    private final String[][] escapeChars = {
        {"\\\\","\\"},{"\\n","\n"},{"\\'","\'"},{"\\r","\r"},
        {"\\f","\f"},{"\\b","\b"},{"\\t","\t"}
        };
    private String replaceEscapeChars (String keyValue) {

		if (keyValue == null || ("").equals(keyValue.trim())) {
			return keyValue;
		}

		StringBuilder result = new StringBuilder();
		int currIndex = 0;
		while (currIndex < keyValue.length()) {
			int index = -1;
			// judege if the left string includes escape chars
			for (String[] strArray : escapeChars) {
				index = keyValue.indexOf(strArray[0],currIndex);
				if (index>=0) {

					result.append(keyValue.substring(currIndex, index + strArray[0].length()).replace(strArray[0], strArray[1]));
					currIndex = index + strArray[0].length();
					break;
				}
			}
			// if the left string doesn't include escape chars, append the left into the result
			if (index < 0) {
				result.append(keyValue.substring(currIndex));
				currIndex = currIndex + keyValue.length();
			}
		}

		return result.toString();
    }

    public Integer getErrorCode() {
        return errorCode;
    }


    public String getStatus() {
        return status;
    }

    ResumeUtil resumeUtil = null;
}
/************************************************************************************************
 *     174001 characters generated by Talend Open Studio for Data Integration 
 *     on the 3 août 2024 à 14:42:27 GMT+01:00
 ************************************************************************************************/