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


package pgs_stage.dim_orders_0_1;

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
 * Job: DIM_ORDERS Purpose: <br>
 * Description:  <br>
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status 
 */
public class DIM_ORDERS implements TalendJob {

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
	private final String jobName = "DIM_ORDERS";
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
				DIM_ORDERS.this.exception = e;
			}
		}
		if (!(e instanceof TalendException)) {
		try {
			for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
				if (m.getName().compareTo(currentComponent + "_error") == 0) {
					m.invoke(DIM_ORDERS.this, new Object[] { e , currentComponent, globalMap});
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

			public void tDBInput_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tUniqRow_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMap_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBOutput_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_row3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
	






public static class out1Struct implements routines.system.IPersistableRow<out1Struct> {
    final static byte[] commonByteArrayLock_PGS_STAGE_DIM_ORDERS = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_DIM_ORDERS = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public Integer PK_ORDERS;

				public Integer getPK_ORDERS () {
					return this.PK_ORDERS;
				}
				
			    public int ORDER_ID;

				public int getORDER_ID () {
					return this.ORDER_ID;
				}
				
			    public Integer LOADED_DRIVER_NUMBER;

				public Integer getLOADED_DRIVER_NUMBER () {
					return this.LOADED_DRIVER_NUMBER;
				}
				
			    public int CARRIER_NUMBER;

				public int getCARRIER_NUMBER () {
					return this.CARRIER_NUMBER;
				}
				
			    public Integer LOADED_CARRIER_NUMBER;

				public Integer getLOADED_CARRIER_NUMBER () {
					return this.LOADED_CARRIER_NUMBER;
				}
				
			    public String FOLIO_NUMBER;

				public String getFOLIO_NUMBER () {
					return this.FOLIO_NUMBER;
				}
				
			    public Integer DISPATCH_CARRIER_NUMBER;

				public Integer getDISPATCH_CARRIER_NUMBER () {
					return this.DISPATCH_CARRIER_NUMBER;
				}
				
			    public int SUPPLIER_NUMBER;

				public int getSUPPLIER_NUMBER () {
					return this.SUPPLIER_NUMBER;
				}
				
			    public int CUSTOMER_NUMBER;

				public int getCUSTOMER_NUMBER () {
					return this.CUSTOMER_NUMBER;
				}
				
			    public int DESTINATION_NUMBER;

				public int getDESTINATION_NUMBER () {
					return this.DESTINATION_NUMBER;
				}
				
			    public Integer TRIP_ID;

				public Integer getTRIP_ID () {
					return this.TRIP_ID;
				}
				
			    public int TYPE;

				public int getTYPE () {
					return this.TYPE;
				}
				
			    public int CREATOR;

				public int getCREATOR () {
					return this.CREATOR;
				}
				
			    public int MANUALLY_ENTERED;

				public int getMANUALLY_ENTERED () {
					return this.MANUALLY_ENTERED;
				}
				
			    public int MOVEMENT_NUMBER;

				public int getMOVEMENT_NUMBER () {
					return this.MOVEMENT_NUMBER;
				}
				
			    public int REVISION_NUMBER;

				public int getREVISION_NUMBER () {
					return this.REVISION_NUMBER;
				}
				
			    public int REVISED;

				public int getREVISED () {
					return this.REVISED;
				}
				
			    public int STATUS;

				public int getSTATUS () {
					return this.STATUS;
				}
				
			    public java.util.Date STATUS_DATE;

				public java.util.Date getSTATUS_DATE () {
					return this.STATUS_DATE;
				}
				
			    public java.util.Date START_LOAD_TIME;

				public java.util.Date getSTART_LOAD_TIME () {
					return this.START_LOAD_TIME;
				}
				
			    public java.util.Date END_LOAD_TIME;

				public java.util.Date getEND_LOAD_TIME () {
					return this.END_LOAD_TIME;
				}
				
			    public String LAST_USER_NAME;

				public String getLAST_USER_NAME () {
					return this.LAST_USER_NAME;
				}
				
			    public java.util.Date LAST_MODIFIED;

				public java.util.Date getLAST_MODIFIED () {
					return this.LAST_MODIFIED;
				}
				
			    public int BOL_PRINTED;

				public int getBOL_PRINTED () {
					return this.BOL_PRINTED;
				}
				
			    public java.util.Date ORDER_ENTRY_TIME;

				public java.util.Date getORDER_ENTRY_TIME () {
					return this.ORDER_ENTRY_TIME;
				}
				
			    public int MANUALLY_COMPLETED;

				public int getMANUALLY_COMPLETED () {
					return this.MANUALLY_COMPLETED;
				}
				
			    public int AIC_STATUS;

				public int getAIC_STATUS () {
					return this.AIC_STATUS;
				}
				
			    public int AUTHORIZATION_REQUEST_ID;

				public int getAUTHORIZATION_REQUEST_ID () {
					return this.AUTHORIZATION_REQUEST_ID;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.PK_ORDERS == null) ? 0 : this.PK_ORDERS.hashCode());
					
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final out1Struct other = (out1Struct) obj;
		
						if (this.PK_ORDERS == null) {
							if (other.PK_ORDERS != null)
								return false;
						
						} else if (!this.PK_ORDERS.equals(other.PK_ORDERS))
						
							return false;
					

		return true;
    }

	public void copyDataTo(out1Struct other) {

		other.PK_ORDERS = this.PK_ORDERS;
	            other.ORDER_ID = this.ORDER_ID;
	            other.LOADED_DRIVER_NUMBER = this.LOADED_DRIVER_NUMBER;
	            other.CARRIER_NUMBER = this.CARRIER_NUMBER;
	            other.LOADED_CARRIER_NUMBER = this.LOADED_CARRIER_NUMBER;
	            other.FOLIO_NUMBER = this.FOLIO_NUMBER;
	            other.DISPATCH_CARRIER_NUMBER = this.DISPATCH_CARRIER_NUMBER;
	            other.SUPPLIER_NUMBER = this.SUPPLIER_NUMBER;
	            other.CUSTOMER_NUMBER = this.CUSTOMER_NUMBER;
	            other.DESTINATION_NUMBER = this.DESTINATION_NUMBER;
	            other.TRIP_ID = this.TRIP_ID;
	            other.TYPE = this.TYPE;
	            other.CREATOR = this.CREATOR;
	            other.MANUALLY_ENTERED = this.MANUALLY_ENTERED;
	            other.MOVEMENT_NUMBER = this.MOVEMENT_NUMBER;
	            other.REVISION_NUMBER = this.REVISION_NUMBER;
	            other.REVISED = this.REVISED;
	            other.STATUS = this.STATUS;
	            other.STATUS_DATE = this.STATUS_DATE;
	            other.START_LOAD_TIME = this.START_LOAD_TIME;
	            other.END_LOAD_TIME = this.END_LOAD_TIME;
	            other.LAST_USER_NAME = this.LAST_USER_NAME;
	            other.LAST_MODIFIED = this.LAST_MODIFIED;
	            other.BOL_PRINTED = this.BOL_PRINTED;
	            other.ORDER_ENTRY_TIME = this.ORDER_ENTRY_TIME;
	            other.MANUALLY_COMPLETED = this.MANUALLY_COMPLETED;
	            other.AIC_STATUS = this.AIC_STATUS;
	            other.AUTHORIZATION_REQUEST_ID = this.AUTHORIZATION_REQUEST_ID;
	            
	}

	public void copyKeysDataTo(out1Struct other) {

		other.PK_ORDERS = this.PK_ORDERS;
	            	
	}



	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PGS_STAGE_DIM_ORDERS.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_ORDERS.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_ORDERS = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_ORDERS = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PGS_STAGE_DIM_ORDERS, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_ORDERS, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PGS_STAGE_DIM_ORDERS.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_ORDERS.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_ORDERS = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_ORDERS = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PGS_STAGE_DIM_ORDERS, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_ORDERS, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_ORDERS) {

        	try {

        		int length = 0;
		
						this.PK_ORDERS = readInteger(dis);
					
			        this.ORDER_ID = dis.readInt();
					
						this.LOADED_DRIVER_NUMBER = readInteger(dis);
					
			        this.CARRIER_NUMBER = dis.readInt();
					
						this.LOADED_CARRIER_NUMBER = readInteger(dis);
					
					this.FOLIO_NUMBER = readString(dis);
					
						this.DISPATCH_CARRIER_NUMBER = readInteger(dis);
					
			        this.SUPPLIER_NUMBER = dis.readInt();
					
			        this.CUSTOMER_NUMBER = dis.readInt();
					
			        this.DESTINATION_NUMBER = dis.readInt();
					
						this.TRIP_ID = readInteger(dis);
					
			        this.TYPE = dis.readInt();
					
			        this.CREATOR = dis.readInt();
					
			        this.MANUALLY_ENTERED = dis.readInt();
					
			        this.MOVEMENT_NUMBER = dis.readInt();
					
			        this.REVISION_NUMBER = dis.readInt();
					
			        this.REVISED = dis.readInt();
					
			        this.STATUS = dis.readInt();
					
					this.STATUS_DATE = readDate(dis);
					
					this.START_LOAD_TIME = readDate(dis);
					
					this.END_LOAD_TIME = readDate(dis);
					
					this.LAST_USER_NAME = readString(dis);
					
					this.LAST_MODIFIED = readDate(dis);
					
			        this.BOL_PRINTED = dis.readInt();
					
					this.ORDER_ENTRY_TIME = readDate(dis);
					
			        this.MANUALLY_COMPLETED = dis.readInt();
					
			        this.AIC_STATUS = dis.readInt();
					
			        this.AUTHORIZATION_REQUEST_ID = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_ORDERS) {

        	try {

        		int length = 0;
		
						this.PK_ORDERS = readInteger(dis);
					
			        this.ORDER_ID = dis.readInt();
					
						this.LOADED_DRIVER_NUMBER = readInteger(dis);
					
			        this.CARRIER_NUMBER = dis.readInt();
					
						this.LOADED_CARRIER_NUMBER = readInteger(dis);
					
					this.FOLIO_NUMBER = readString(dis);
					
						this.DISPATCH_CARRIER_NUMBER = readInteger(dis);
					
			        this.SUPPLIER_NUMBER = dis.readInt();
					
			        this.CUSTOMER_NUMBER = dis.readInt();
					
			        this.DESTINATION_NUMBER = dis.readInt();
					
						this.TRIP_ID = readInteger(dis);
					
			        this.TYPE = dis.readInt();
					
			        this.CREATOR = dis.readInt();
					
			        this.MANUALLY_ENTERED = dis.readInt();
					
			        this.MOVEMENT_NUMBER = dis.readInt();
					
			        this.REVISION_NUMBER = dis.readInt();
					
			        this.REVISED = dis.readInt();
					
			        this.STATUS = dis.readInt();
					
					this.STATUS_DATE = readDate(dis);
					
					this.START_LOAD_TIME = readDate(dis);
					
					this.END_LOAD_TIME = readDate(dis);
					
					this.LAST_USER_NAME = readString(dis);
					
					this.LAST_MODIFIED = readDate(dis);
					
			        this.BOL_PRINTED = dis.readInt();
					
					this.ORDER_ENTRY_TIME = readDate(dis);
					
			        this.MANUALLY_COMPLETED = dis.readInt();
					
			        this.AIC_STATUS = dis.readInt();
					
			        this.AUTHORIZATION_REQUEST_ID = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// Integer
				
						writeInteger(this.PK_ORDERS,dos);
					
					// int
				
		            	dos.writeInt(this.ORDER_ID);
					
					// Integer
				
						writeInteger(this.LOADED_DRIVER_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.CARRIER_NUMBER);
					
					// Integer
				
						writeInteger(this.LOADED_CARRIER_NUMBER,dos);
					
					// String
				
						writeString(this.FOLIO_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.DISPATCH_CARRIER_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.SUPPLIER_NUMBER);
					
					// int
				
		            	dos.writeInt(this.CUSTOMER_NUMBER);
					
					// int
				
		            	dos.writeInt(this.DESTINATION_NUMBER);
					
					// Integer
				
						writeInteger(this.TRIP_ID,dos);
					
					// int
				
		            	dos.writeInt(this.TYPE);
					
					// int
				
		            	dos.writeInt(this.CREATOR);
					
					// int
				
		            	dos.writeInt(this.MANUALLY_ENTERED);
					
					// int
				
		            	dos.writeInt(this.MOVEMENT_NUMBER);
					
					// int
				
		            	dos.writeInt(this.REVISION_NUMBER);
					
					// int
				
		            	dos.writeInt(this.REVISED);
					
					// int
				
		            	dos.writeInt(this.STATUS);
					
					// java.util.Date
				
						writeDate(this.STATUS_DATE,dos);
					
					// java.util.Date
				
						writeDate(this.START_LOAD_TIME,dos);
					
					// java.util.Date
				
						writeDate(this.END_LOAD_TIME,dos);
					
					// String
				
						writeString(this.LAST_USER_NAME,dos);
					
					// java.util.Date
				
						writeDate(this.LAST_MODIFIED,dos);
					
					// int
				
		            	dos.writeInt(this.BOL_PRINTED);
					
					// java.util.Date
				
						writeDate(this.ORDER_ENTRY_TIME,dos);
					
					// int
				
		            	dos.writeInt(this.MANUALLY_COMPLETED);
					
					// int
				
		            	dos.writeInt(this.AIC_STATUS);
					
					// int
				
		            	dos.writeInt(this.AUTHORIZATION_REQUEST_ID);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Integer
				
						writeInteger(this.PK_ORDERS,dos);
					
					// int
				
		            	dos.writeInt(this.ORDER_ID);
					
					// Integer
				
						writeInteger(this.LOADED_DRIVER_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.CARRIER_NUMBER);
					
					// Integer
				
						writeInteger(this.LOADED_CARRIER_NUMBER,dos);
					
					// String
				
						writeString(this.FOLIO_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.DISPATCH_CARRIER_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.SUPPLIER_NUMBER);
					
					// int
				
		            	dos.writeInt(this.CUSTOMER_NUMBER);
					
					// int
				
		            	dos.writeInt(this.DESTINATION_NUMBER);
					
					// Integer
				
						writeInteger(this.TRIP_ID,dos);
					
					// int
				
		            	dos.writeInt(this.TYPE);
					
					// int
				
		            	dos.writeInt(this.CREATOR);
					
					// int
				
		            	dos.writeInt(this.MANUALLY_ENTERED);
					
					// int
				
		            	dos.writeInt(this.MOVEMENT_NUMBER);
					
					// int
				
		            	dos.writeInt(this.REVISION_NUMBER);
					
					// int
				
		            	dos.writeInt(this.REVISED);
					
					// int
				
		            	dos.writeInt(this.STATUS);
					
					// java.util.Date
				
						writeDate(this.STATUS_DATE,dos);
					
					// java.util.Date
				
						writeDate(this.START_LOAD_TIME,dos);
					
					// java.util.Date
				
						writeDate(this.END_LOAD_TIME,dos);
					
					// String
				
						writeString(this.LAST_USER_NAME,dos);
					
					// java.util.Date
				
						writeDate(this.LAST_MODIFIED,dos);
					
					// int
				
		            	dos.writeInt(this.BOL_PRINTED);
					
					// java.util.Date
				
						writeDate(this.ORDER_ENTRY_TIME,dos);
					
					// int
				
		            	dos.writeInt(this.MANUALLY_COMPLETED);
					
					// int
				
		            	dos.writeInt(this.AIC_STATUS);
					
					// int
				
		            	dos.writeInt(this.AUTHORIZATION_REQUEST_ID);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("PK_ORDERS="+String.valueOf(PK_ORDERS));
		sb.append(",ORDER_ID="+String.valueOf(ORDER_ID));
		sb.append(",LOADED_DRIVER_NUMBER="+String.valueOf(LOADED_DRIVER_NUMBER));
		sb.append(",CARRIER_NUMBER="+String.valueOf(CARRIER_NUMBER));
		sb.append(",LOADED_CARRIER_NUMBER="+String.valueOf(LOADED_CARRIER_NUMBER));
		sb.append(",FOLIO_NUMBER="+FOLIO_NUMBER);
		sb.append(",DISPATCH_CARRIER_NUMBER="+String.valueOf(DISPATCH_CARRIER_NUMBER));
		sb.append(",SUPPLIER_NUMBER="+String.valueOf(SUPPLIER_NUMBER));
		sb.append(",CUSTOMER_NUMBER="+String.valueOf(CUSTOMER_NUMBER));
		sb.append(",DESTINATION_NUMBER="+String.valueOf(DESTINATION_NUMBER));
		sb.append(",TRIP_ID="+String.valueOf(TRIP_ID));
		sb.append(",TYPE="+String.valueOf(TYPE));
		sb.append(",CREATOR="+String.valueOf(CREATOR));
		sb.append(",MANUALLY_ENTERED="+String.valueOf(MANUALLY_ENTERED));
		sb.append(",MOVEMENT_NUMBER="+String.valueOf(MOVEMENT_NUMBER));
		sb.append(",REVISION_NUMBER="+String.valueOf(REVISION_NUMBER));
		sb.append(",REVISED="+String.valueOf(REVISED));
		sb.append(",STATUS="+String.valueOf(STATUS));
		sb.append(",STATUS_DATE="+String.valueOf(STATUS_DATE));
		sb.append(",START_LOAD_TIME="+String.valueOf(START_LOAD_TIME));
		sb.append(",END_LOAD_TIME="+String.valueOf(END_LOAD_TIME));
		sb.append(",LAST_USER_NAME="+LAST_USER_NAME);
		sb.append(",LAST_MODIFIED="+String.valueOf(LAST_MODIFIED));
		sb.append(",BOL_PRINTED="+String.valueOf(BOL_PRINTED));
		sb.append(",ORDER_ENTRY_TIME="+String.valueOf(ORDER_ENTRY_TIME));
		sb.append(",MANUALLY_COMPLETED="+String.valueOf(MANUALLY_COMPLETED));
		sb.append(",AIC_STATUS="+String.valueOf(AIC_STATUS));
		sb.append(",AUTHORIZATION_REQUEST_ID="+String.valueOf(AUTHORIZATION_REQUEST_ID));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(out1Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.PK_ORDERS, other.PK_ORDERS);
						if(returnValue != 0) {
							return returnValue;
						}

					
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class row2Struct implements routines.system.IPersistableRow<row2Struct> {
    final static byte[] commonByteArrayLock_PGS_STAGE_DIM_ORDERS = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_DIM_ORDERS = new byte[0];

	
			    public int ORDER_ID;

				public int getORDER_ID () {
					return this.ORDER_ID;
				}
				
			    public Integer LOADED_DRIVER_NUMBER;

				public Integer getLOADED_DRIVER_NUMBER () {
					return this.LOADED_DRIVER_NUMBER;
				}
				
			    public String USER_NAME;

				public String getUSER_NAME () {
					return this.USER_NAME;
				}
				
			    public Integer TRAILER_CARRIER_NUMBER;

				public Integer getTRAILER_CARRIER_NUMBER () {
					return this.TRAILER_CARRIER_NUMBER;
				}
				
			    public int CARRIER_NUMBER;

				public int getCARRIER_NUMBER () {
					return this.CARRIER_NUMBER;
				}
				
			    public String TRAILER_CODE;

				public String getTRAILER_CODE () {
					return this.TRAILER_CODE;
				}
				
			    public Integer VEHICLE_CARRIER_NUMBER;

				public Integer getVEHICLE_CARRIER_NUMBER () {
					return this.VEHICLE_CARRIER_NUMBER;
				}
				
			    public String VEHICLE_CODE;

				public String getVEHICLE_CODE () {
					return this.VEHICLE_CODE;
				}
				
			    public Integer TRACTOR_CARRIER_NUMBER;

				public Integer getTRACTOR_CARRIER_NUMBER () {
					return this.TRACTOR_CARRIER_NUMBER;
				}
				
			    public Integer LOADED_CARRIER_NUMBER;

				public Integer getLOADED_CARRIER_NUMBER () {
					return this.LOADED_CARRIER_NUMBER;
				}
				
			    public String FOLIO_NUMBER;

				public String getFOLIO_NUMBER () {
					return this.FOLIO_NUMBER;
				}
				
			    public Integer TRACTOR_NUMBER;

				public Integer getTRACTOR_NUMBER () {
					return this.TRACTOR_NUMBER;
				}
				
			    public Integer DELIVERED_CARRIER_NUMBER;

				public Integer getDELIVERED_CARRIER_NUMBER () {
					return this.DELIVERED_CARRIER_NUMBER;
				}
				
			    public Integer DISPATCH_CARRIER_NUMBER;

				public Integer getDISPATCH_CARRIER_NUMBER () {
					return this.DISPATCH_CARRIER_NUMBER;
				}
				
			    public Integer DELIVERED_DRIVER_NUMBER;

				public Integer getDELIVERED_DRIVER_NUMBER () {
					return this.DELIVERED_DRIVER_NUMBER;
				}
				
			    public int SUPPLIER_NUMBER;

				public int getSUPPLIER_NUMBER () {
					return this.SUPPLIER_NUMBER;
				}
				
			    public int CUSTOMER_NUMBER;

				public int getCUSTOMER_NUMBER () {
					return this.CUSTOMER_NUMBER;
				}
				
			    public String TABS_CARRIER_ID;

				public String getTABS_CARRIER_ID () {
					return this.TABS_CARRIER_ID;
				}
				
			    public int DESTINATION_NUMBER;

				public int getDESTINATION_NUMBER () {
					return this.DESTINATION_NUMBER;
				}
				
			    public Integer TRIP_ID;

				public Integer getTRIP_ID () {
					return this.TRIP_ID;
				}
				
			    public String TABS_TRUCK_NUMBER;

				public String getTABS_TRUCK_NUMBER () {
					return this.TABS_TRUCK_NUMBER;
				}
				
			    public int TYPE;

				public int getTYPE () {
					return this.TYPE;
				}
				
			    public String SHOST_SU_SUPPLIER_NUMBER;

				public String getSHOST_SU_SUPPLIER_NUMBER () {
					return this.SHOST_SU_SUPPLIER_NUMBER;
				}
				
			    public int CREATOR;

				public int getCREATOR () {
					return this.CREATOR;
				}
				
			    public int EXCHANGE_ALLOCATION_ENABLED;

				public int getEXCHANGE_ALLOCATION_ENABLED () {
					return this.EXCHANGE_ALLOCATION_ENABLED;
				}
				
			    public int MANUALLY_ENTERED;

				public int getMANUALLY_ENTERED () {
					return this.MANUALLY_ENTERED;
				}
				
			    public String SHOST_EX_EHOST_THRU_NUMBER;

				public String getSHOST_EX_EHOST_THRU_NUMBER () {
					return this.SHOST_EX_EHOST_THRU_NUMBER;
				}
				
			    public int DEST_ALLOCATION_ENABLED;

				public int getDEST_ALLOCATION_ENABLED () {
					return this.DEST_ALLOCATION_ENABLED;
				}
				
			    public String THOST_TH_SUPPLIER_NUMBER;

				public String getTHOST_TH_SUPPLIER_NUMBER () {
					return this.THOST_TH_SUPPLIER_NUMBER;
				}
				
			    public int CUST_ALLOC_BY_PRODUCT;

				public int getCUST_ALLOC_BY_PRODUCT () {
					return this.CUST_ALLOC_BY_PRODUCT;
				}
				
			    public int CUST_ALLOC_BY_COMPONENT;

				public int getCUST_ALLOC_BY_COMPONENT () {
					return this.CUST_ALLOC_BY_COMPONENT;
				}
				
			    public int CUST_ALLOC_BY_COMP_GROUP;

				public int getCUST_ALLOC_BY_COMP_GROUP () {
					return this.CUST_ALLOC_BY_COMP_GROUP;
				}
				
			    public int CREDIT_ENABLED;

				public int getCREDIT_ENABLED () {
					return this.CREDIT_ENABLED;
				}
				
			    public String THOST_EX_THOST_EXCH_NUMBER;

				public String getTHOST_EX_THOST_EXCH_NUMBER () {
					return this.THOST_EX_THOST_EXCH_NUMBER;
				}
				
			    public int BILLING_TYPE;

				public int getBILLING_TYPE () {
					return this.BILLING_TYPE;
				}
				
			    public int EXCH_ALLOC_BY_PRODUCT;

				public int getEXCH_ALLOC_BY_PRODUCT () {
					return this.EXCH_ALLOC_BY_PRODUCT;
				}
				
			    public int EXCH_ALLOC_BY_PRODUCT_GROUP;

				public int getEXCH_ALLOC_BY_PRODUCT_GROUP () {
					return this.EXCH_ALLOC_BY_PRODUCT_GROUP;
				}
				
			    public int CUSTOMER_ALLOCATION_ENABLED;

				public int getCUSTOMER_ALLOCATION_ENABLED () {
					return this.CUSTOMER_ALLOCATION_ENABLED;
				}
				
			    public String TABS_FINAL_SHIPPER_ID;

				public String getTABS_FINAL_SHIPPER_ID () {
					return this.TABS_FINAL_SHIPPER_ID;
				}
				
			    public int CUST_ALLOC_BY_PRODUCT_GROUP;

				public int getCUST_ALLOC_BY_PRODUCT_GROUP () {
					return this.CUST_ALLOC_BY_PRODUCT_GROUP;
				}
				
			    public int MOVEMENT_NUMBER;

				public int getMOVEMENT_NUMBER () {
					return this.MOVEMENT_NUMBER;
				}
				
			    public int REVISION_NUMBER;

				public int getREVISION_NUMBER () {
					return this.REVISION_NUMBER;
				}
				
			    public String TABS_SELLER_ID;

				public String getTABS_SELLER_ID () {
					return this.TABS_SELLER_ID;
				}
				
			    public int REVISED;

				public int getREVISED () {
					return this.REVISED;
				}
				
			    public String TABS_CONSIGNEE_NUMBER;

				public String getTABS_CONSIGNEE_NUMBER () {
					return this.TABS_CONSIGNEE_NUMBER;
				}
				
			    public int STATUS;

				public int getSTATUS () {
					return this.STATUS;
				}
				
			    public String CHOST_CU_SUPPLIER_NUMBER;

				public String getCHOST_CU_SUPPLIER_NUMBER () {
					return this.CHOST_CU_SUPPLIER_NUMBER;
				}
				
			    public String CHOST_CU_CUSTOMER_NUMBER;

				public String getCHOST_CU_CUSTOMER_NUMBER () {
					return this.CHOST_CU_CUSTOMER_NUMBER;
				}
				
			    public java.util.Date STATUS_DATE;

				public java.util.Date getSTATUS_DATE () {
					return this.STATUS_DATE;
				}
				
			    public String PURCHASE_ORDER_NUMBER;

				public String getPURCHASE_ORDER_NUMBER () {
					return this.PURCHASE_ORDER_NUMBER;
				}
				
			    public String REQUISITION_NUMBER;

				public String getREQUISITION_NUMBER () {
					return this.REQUISITION_NUMBER;
				}
				
			    public String BOL_COMMENT_1;

				public String getBOL_COMMENT_1 () {
					return this.BOL_COMMENT_1;
				}
				
			    public String BOL_COMMENT_2;

				public String getBOL_COMMENT_2 () {
					return this.BOL_COMMENT_2;
				}
				
			    public int INVOICE_REQUIRED;

				public int getINVOICE_REQUIRED () {
					return this.INVOICE_REQUIRED;
				}
				
			    public String INVOICE_COMMENT_1;

				public String getINVOICE_COMMENT_1 () {
					return this.INVOICE_COMMENT_1;
				}
				
			    public String INVOICE_COMMENT_2;

				public String getINVOICE_COMMENT_2 () {
					return this.INVOICE_COMMENT_2;
				}
				
			    public int INVOICE_PRINTED;

				public int getINVOICE_PRINTED () {
					return this.INVOICE_PRINTED;
				}
				
			    public String DESTINATION_COMMENT_1;

				public String getDESTINATION_COMMENT_1 () {
					return this.DESTINATION_COMMENT_1;
				}
				
			    public String DESTINATION_COMMENT_2;

				public String getDESTINATION_COMMENT_2 () {
					return this.DESTINATION_COMMENT_2;
				}
				
			    public int TABS_SUBSCRIBER;

				public int getTABS_SUBSCRIBER () {
					return this.TABS_SUBSCRIBER;
				}
				
			    public String REMARKS;

				public String getREMARKS () {
					return this.REMARKS;
				}
				
			    public java.util.Date START_LOAD_TIME;

				public java.util.Date getSTART_LOAD_TIME () {
					return this.START_LOAD_TIME;
				}
				
			    public java.util.Date END_LOAD_TIME;

				public java.util.Date getEND_LOAD_TIME () {
					return this.END_LOAD_TIME;
				}
				
			    public double DELIVERY_FEE;

				public double getDELIVERY_FEE () {
					return this.DELIVERY_FEE;
				}
				
			    public String TABS_AUTHORIZATION_NUMBER;

				public String getTABS_AUTHORIZATION_NUMBER () {
					return this.TABS_AUTHORIZATION_NUMBER;
				}
				
			    public Integer THRUPUTTER_NUMBER;

				public Integer getTHRUPUTTER_NUMBER () {
					return this.THRUPUTTER_NUMBER;
				}
				
			    public String LAST_USER_NAME;

				public String getLAST_USER_NAME () {
					return this.LAST_USER_NAME;
				}
				
			    public java.util.Date LAST_MODIFIED;

				public java.util.Date getLAST_MODIFIED () {
					return this.LAST_MODIFIED;
				}
				
			    public int BOL_PRINTED;

				public int getBOL_PRINTED () {
					return this.BOL_PRINTED;
				}
				
			    public java.util.Date ORDER_ENTRY_TIME;

				public java.util.Date getORDER_ENTRY_TIME () {
					return this.ORDER_ENTRY_TIME;
				}
				
			    public int BILL_FREIGHT;

				public int getBILL_FREIGHT () {
					return this.BILL_FREIGHT;
				}
				
			    public java.util.Date DELIVERY_DATE;

				public java.util.Date getDELIVERY_DATE () {
					return this.DELIVERY_DATE;
				}
				
			    public int SHIFT;

				public int getSHIFT () {
					return this.SHIFT;
				}
				
			    public int STOP;

				public int getSTOP () {
					return this.STOP;
				}
				
			    public int DELIVERY_CONFIRMED;

				public int getDELIVERY_CONFIRMED () {
					return this.DELIVERY_CONFIRMED;
				}
				
			    public String VALIDATING_NODE_NAME;

				public String getVALIDATING_NODE_NAME () {
					return this.VALIDATING_NODE_NAME;
				}
				
			    public int HOST_PROCESSED;

				public int getHOST_PROCESSED () {
					return this.HOST_PROCESSED;
				}
				
			    public String PETROEX_COMPANY_CODE;

				public String getPETROEX_COMPANY_CODE () {
					return this.PETROEX_COMPANY_CODE;
				}
				
			    public String PETROEX_CONSIGNEE_NUMBER;

				public String getPETROEX_CONSIGNEE_NUMBER () {
					return this.PETROEX_CONSIGNEE_NUMBER;
				}
				
			    public String PETROEX_THIRD_PARTY;

				public String getPETROEX_THIRD_PARTY () {
					return this.PETROEX_THIRD_PARTY;
				}
				
			    public String PETROEX_CARRIER_CODE;

				public String getPETROEX_CARRIER_CODE () {
					return this.PETROEX_CARRIER_CODE;
				}
				
			    public int PETROEX_TRUCK_NUMBER;

				public int getPETROEX_TRUCK_NUMBER () {
					return this.PETROEX_TRUCK_NUMBER;
				}
				
			    public int PETROEX_SUBSCRIBER;

				public int getPETROEX_SUBSCRIBER () {
					return this.PETROEX_SUBSCRIBER;
				}
				
			    public String FAN_COMMENT_1;

				public String getFAN_COMMENT_1 () {
					return this.FAN_COMMENT_1;
				}
				
			    public int PETROEX_CITY_CODE;

				public int getPETROEX_CITY_CODE () {
					return this.PETROEX_CITY_CODE;
				}
				
			    public String FAN_COMMENT_2;

				public String getFAN_COMMENT_2 () {
					return this.FAN_COMMENT_2;
				}
				
			    public int PETROEX_COUNTY_CODE;

				public int getPETROEX_COUNTY_CODE () {
					return this.PETROEX_COUNTY_CODE;
				}
				
			    public int PRELOAD_ORDER;

				public int getPRELOAD_ORDER () {
					return this.PRELOAD_ORDER;
				}
				
			    public int PETROEX_STATE_CODE;

				public int getPETROEX_STATE_CODE () {
					return this.PETROEX_STATE_CODE;
				}
				
			    public int CONTRACT_ALLOCATION_ENABLED;

				public int getCONTRACT_ALLOCATION_ENABLED () {
					return this.CONTRACT_ALLOCATION_ENABLED;
				}
				
			    public String PETROEX_FEIN;

				public String getPETROEX_FEIN () {
					return this.PETROEX_FEIN;
				}
				
			    public int ELVIS_ORDER_NUMBER;

				public int getELVIS_ORDER_NUMBER () {
					return this.ELVIS_ORDER_NUMBER;
				}
				
			    public String PETROEX_SHIPPER_INFO;

				public String getPETROEX_SHIPPER_INFO () {
					return this.PETROEX_SHIPPER_INFO;
				}
				
			    public String ELVIS_LOADSPOT_ID;

				public String getELVIS_LOADSPOT_ID () {
					return this.ELVIS_LOADSPOT_ID;
				}
				
			    public String PETROEX_VEHICLE_TYPE;

				public String getPETROEX_VEHICLE_TYPE () {
					return this.PETROEX_VEHICLE_TYPE;
				}
				
			    public int OVERWEIGHT_TRAILER;

				public int getOVERWEIGHT_TRAILER () {
					return this.OVERWEIGHT_TRAILER;
				}
				
			    public int ELVIS_AUTHORIZED;

				public int getELVIS_AUTHORIZED () {
					return this.ELVIS_AUTHORIZED;
				}
				
			    public int DISPATCHED_WITH_TRAILER;

				public int getDISPATCHED_WITH_TRAILER () {
					return this.DISPATCHED_WITH_TRAILER;
				}
				
			    public int DISPATCHED_WITH_DRIVER;

				public int getDISPATCHED_WITH_DRIVER () {
					return this.DISPATCHED_WITH_DRIVER;
				}
				
			    public double COMMITTED_PRICE;

				public double getCOMMITTED_PRICE () {
					return this.COMMITTED_PRICE;
				}
				
			    public double LOADED_PRICE;

				public double getLOADED_PRICE () {
					return this.LOADED_PRICE;
				}
				
			    public String CONTRACT_NUMBER;

				public String getCONTRACT_NUMBER () {
					return this.CONTRACT_NUMBER;
				}
				
			    public int MANUALLY_COMPLETED;

				public int getMANUALLY_COMPLETED () {
					return this.MANUALLY_COMPLETED;
				}
				
			    public int OVERRIDE_TOLERANCE_CHECKS;

				public int getOVERRIDE_TOLERANCE_CHECKS () {
					return this.OVERRIDE_TOLERANCE_CHECKS;
				}
				
			    public int AIC_STATUS;

				public int getAIC_STATUS () {
					return this.AIC_STATUS;
				}
				
			    public int BLEND_TOLERANCE_STATUS;

				public int getBLEND_TOLERANCE_STATUS () {
					return this.BLEND_TOLERANCE_STATUS;
				}
				
			    public int ADDITIVE_TOLERANCE_STATUS;

				public int getADDITIVE_TOLERANCE_STATUS () {
					return this.ADDITIVE_TOLERANCE_STATUS;
				}
				
			    public int AUTHORIZATION_REQUEST_ID;

				public int getAUTHORIZATION_REQUEST_ID () {
					return this.AUTHORIZATION_REQUEST_ID;
				}
				
			    public int TABS_ORDER_NUMBER;

				public int getTABS_ORDER_NUMBER () {
					return this.TABS_ORDER_NUMBER;
				}
				
			    public int FLAG_VALID_PRICE;

				public int getFLAG_VALID_PRICE () {
					return this.FLAG_VALID_PRICE;
				}
				
			    public int BOL_NUMBER;

				public int getBOL_NUMBER () {
					return this.BOL_NUMBER;
				}
				
			    public int COMPATIBILITY_STATUS;

				public int getCOMPATIBILITY_STATUS () {
					return this.COMPATIBILITY_STATUS;
				}
				
			    public int OVERRIDE_COMPATIBILITY_CHECKS;

				public int getOVERRIDE_COMPATIBILITY_CHECKS () {
					return this.OVERRIDE_COMPATIBILITY_CHECKS;
				}
				
			    public int CANCELLED_FROM_CBS;

				public int getCANCELLED_FROM_CBS () {
					return this.CANCELLED_FROM_CBS;
				}
				
			    public String HOST_REF_ID;

				public String getHOST_REF_ID () {
					return this.HOST_REF_ID;
				}
				
			    public int UNACCOUNTED_LIMIT_EXCEEDED;

				public int getUNACCOUNTED_LIMIT_EXCEEDED () {
					return this.UNACCOUNTED_LIMIT_EXCEEDED;
				}
				
			    public int OVERRIDE_UNACCOUNTED_CHECKS;

				public int getOVERRIDE_UNACCOUNTED_CHECKS () {
					return this.OVERRIDE_UNACCOUNTED_CHECKS;
				}
				
			    public int PENDING_PRINT_COUNT;

				public int getPENDING_PRINT_COUNT () {
					return this.PENDING_PRINT_COUNT;
				}
				
			    public int PENDING_REQUEST_COUNT;

				public int getPENDING_REQUEST_COUNT () {
					return this.PENDING_REQUEST_COUNT;
				}
				
			    public String PDXR_RACK_DRIVER_ID;

				public String getPDXR_RACK_DRIVER_ID () {
					return this.PDXR_RACK_DRIVER_ID;
				}
				
			    public String PDXR_TERMINAL_CONTROL_NUMBER;

				public String getPDXR_TERMINAL_CONTROL_NUMBER () {
					return this.PDXR_TERMINAL_CONTROL_NUMBER;
				}
				
			    public int PDXR_FINAL_SHIPPER_XCTN_SEQ;

				public int getPDXR_FINAL_SHIPPER_XCTN_SEQ () {
					return this.PDXR_FINAL_SHIPPER_XCTN_SEQ;
				}
				
			    public String PDXR_DESTINATION_STATE_CODE;

				public String getPDXR_DESTINATION_STATE_CODE () {
					return this.PDXR_DESTINATION_STATE_CODE;
				}
				
			    public String PDXR_DESTINATION_COUNTY;

				public String getPDXR_DESTINATION_COUNTY () {
					return this.PDXR_DESTINATION_COUNTY;
				}
				
			    public String PDXR_DESTINATION_CITY;

				public String getPDXR_DESTINATION_CITY () {
					return this.PDXR_DESTINATION_CITY;
				}
				
			    public String PDXR_DESTINATION_ZIP_CODE;

				public String getPDXR_DESTINATION_ZIP_CODE () {
					return this.PDXR_DESTINATION_ZIP_CODE;
				}
				
			    public String PDXR_CARRIER_FEIN;

				public String getPDXR_CARRIER_FEIN () {
					return this.PDXR_CARRIER_FEIN;
				}
				
			    public String PDXR_SHIPPER_INFO;

				public String getPDXR_SHIPPER_INFO () {
					return this.PDXR_SHIPPER_INFO;
				}
				
			    public int PDXR_VERSION;

				public int getPDXR_VERSION () {
					return this.PDXR_VERSION;
				}
				
			    public int PDXR_VENDOR;

				public int getPDXR_VENDOR () {
					return this.PDXR_VENDOR;
				}
				
			    public Integer ORIG_ORDER_ID;

				public Integer getORIG_ORDER_ID () {
					return this.ORIG_ORDER_ID;
				}
				
			    public Integer PREV_ORDER_ID;

				public Integer getPREV_ORDER_ID () {
					return this.PREV_ORDER_ID;
				}
				
			    public String SIGNATURE_PATH;

				public String getSIGNATURE_PATH () {
					return this.SIGNATURE_PATH;
				}
				
			    public String SIGNATURE_FILE_NAME;

				public String getSIGNATURE_FILE_NAME () {
					return this.SIGNATURE_FILE_NAME;
				}
				
			    public String PDXR_AUTHORIZING_SYSTEM;

				public String getPDXR_AUTHORIZING_SYSTEM () {
					return this.PDXR_AUTHORIZING_SYSTEM;
				}
				
			    public java.util.Date START_TIMESLOT_DATETIME;

				public java.util.Date getSTART_TIMESLOT_DATETIME () {
					return this.START_TIMESLOT_DATETIME;
				}
				
			    public java.util.Date END_TIMESLOT_DATETIME;

				public java.util.Date getEND_TIMESLOT_DATETIME () {
					return this.END_TIMESLOT_DATETIME;
				}
				
			    public java.util.Date START_PICKUP_DATETIME;

				public java.util.Date getSTART_PICKUP_DATETIME () {
					return this.START_PICKUP_DATETIME;
				}
				
			    public java.util.Date END_PICKUP_DATETIME;

				public java.util.Date getEND_PICKUP_DATETIME () {
					return this.END_PICKUP_DATETIME;
				}
				
			    public int ADMINISTRATIVE_BOOKING;

				public int getADMINISTRATIVE_BOOKING () {
					return this.ADMINISTRATIVE_BOOKING;
				}
				


	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PGS_STAGE_DIM_ORDERS.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_ORDERS.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_ORDERS = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_ORDERS = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PGS_STAGE_DIM_ORDERS, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_ORDERS, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PGS_STAGE_DIM_ORDERS.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_ORDERS.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_ORDERS = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_ORDERS = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PGS_STAGE_DIM_ORDERS, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_ORDERS, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_ORDERS) {

        	try {

        		int length = 0;
		
			        this.ORDER_ID = dis.readInt();
					
						this.LOADED_DRIVER_NUMBER = readInteger(dis);
					
					this.USER_NAME = readString(dis);
					
						this.TRAILER_CARRIER_NUMBER = readInteger(dis);
					
			        this.CARRIER_NUMBER = dis.readInt();
					
					this.TRAILER_CODE = readString(dis);
					
						this.VEHICLE_CARRIER_NUMBER = readInteger(dis);
					
					this.VEHICLE_CODE = readString(dis);
					
						this.TRACTOR_CARRIER_NUMBER = readInteger(dis);
					
						this.LOADED_CARRIER_NUMBER = readInteger(dis);
					
					this.FOLIO_NUMBER = readString(dis);
					
						this.TRACTOR_NUMBER = readInteger(dis);
					
						this.DELIVERED_CARRIER_NUMBER = readInteger(dis);
					
						this.DISPATCH_CARRIER_NUMBER = readInteger(dis);
					
						this.DELIVERED_DRIVER_NUMBER = readInteger(dis);
					
			        this.SUPPLIER_NUMBER = dis.readInt();
					
			        this.CUSTOMER_NUMBER = dis.readInt();
					
					this.TABS_CARRIER_ID = readString(dis);
					
			        this.DESTINATION_NUMBER = dis.readInt();
					
						this.TRIP_ID = readInteger(dis);
					
					this.TABS_TRUCK_NUMBER = readString(dis);
					
			        this.TYPE = dis.readInt();
					
					this.SHOST_SU_SUPPLIER_NUMBER = readString(dis);
					
			        this.CREATOR = dis.readInt();
					
			        this.EXCHANGE_ALLOCATION_ENABLED = dis.readInt();
					
			        this.MANUALLY_ENTERED = dis.readInt();
					
					this.SHOST_EX_EHOST_THRU_NUMBER = readString(dis);
					
			        this.DEST_ALLOCATION_ENABLED = dis.readInt();
					
					this.THOST_TH_SUPPLIER_NUMBER = readString(dis);
					
			        this.CUST_ALLOC_BY_PRODUCT = dis.readInt();
					
			        this.CUST_ALLOC_BY_COMPONENT = dis.readInt();
					
			        this.CUST_ALLOC_BY_COMP_GROUP = dis.readInt();
					
			        this.CREDIT_ENABLED = dis.readInt();
					
					this.THOST_EX_THOST_EXCH_NUMBER = readString(dis);
					
			        this.BILLING_TYPE = dis.readInt();
					
			        this.EXCH_ALLOC_BY_PRODUCT = dis.readInt();
					
			        this.EXCH_ALLOC_BY_PRODUCT_GROUP = dis.readInt();
					
			        this.CUSTOMER_ALLOCATION_ENABLED = dis.readInt();
					
					this.TABS_FINAL_SHIPPER_ID = readString(dis);
					
			        this.CUST_ALLOC_BY_PRODUCT_GROUP = dis.readInt();
					
			        this.MOVEMENT_NUMBER = dis.readInt();
					
			        this.REVISION_NUMBER = dis.readInt();
					
					this.TABS_SELLER_ID = readString(dis);
					
			        this.REVISED = dis.readInt();
					
					this.TABS_CONSIGNEE_NUMBER = readString(dis);
					
			        this.STATUS = dis.readInt();
					
					this.CHOST_CU_SUPPLIER_NUMBER = readString(dis);
					
					this.CHOST_CU_CUSTOMER_NUMBER = readString(dis);
					
					this.STATUS_DATE = readDate(dis);
					
					this.PURCHASE_ORDER_NUMBER = readString(dis);
					
					this.REQUISITION_NUMBER = readString(dis);
					
					this.BOL_COMMENT_1 = readString(dis);
					
					this.BOL_COMMENT_2 = readString(dis);
					
			        this.INVOICE_REQUIRED = dis.readInt();
					
					this.INVOICE_COMMENT_1 = readString(dis);
					
					this.INVOICE_COMMENT_2 = readString(dis);
					
			        this.INVOICE_PRINTED = dis.readInt();
					
					this.DESTINATION_COMMENT_1 = readString(dis);
					
					this.DESTINATION_COMMENT_2 = readString(dis);
					
			        this.TABS_SUBSCRIBER = dis.readInt();
					
					this.REMARKS = readString(dis);
					
					this.START_LOAD_TIME = readDate(dis);
					
					this.END_LOAD_TIME = readDate(dis);
					
			        this.DELIVERY_FEE = dis.readDouble();
					
					this.TABS_AUTHORIZATION_NUMBER = readString(dis);
					
						this.THRUPUTTER_NUMBER = readInteger(dis);
					
					this.LAST_USER_NAME = readString(dis);
					
					this.LAST_MODIFIED = readDate(dis);
					
			        this.BOL_PRINTED = dis.readInt();
					
					this.ORDER_ENTRY_TIME = readDate(dis);
					
			        this.BILL_FREIGHT = dis.readInt();
					
					this.DELIVERY_DATE = readDate(dis);
					
			        this.SHIFT = dis.readInt();
					
			        this.STOP = dis.readInt();
					
			        this.DELIVERY_CONFIRMED = dis.readInt();
					
					this.VALIDATING_NODE_NAME = readString(dis);
					
			        this.HOST_PROCESSED = dis.readInt();
					
					this.PETROEX_COMPANY_CODE = readString(dis);
					
					this.PETROEX_CONSIGNEE_NUMBER = readString(dis);
					
					this.PETROEX_THIRD_PARTY = readString(dis);
					
					this.PETROEX_CARRIER_CODE = readString(dis);
					
			        this.PETROEX_TRUCK_NUMBER = dis.readInt();
					
			        this.PETROEX_SUBSCRIBER = dis.readInt();
					
					this.FAN_COMMENT_1 = readString(dis);
					
			        this.PETROEX_CITY_CODE = dis.readInt();
					
					this.FAN_COMMENT_2 = readString(dis);
					
			        this.PETROEX_COUNTY_CODE = dis.readInt();
					
			        this.PRELOAD_ORDER = dis.readInt();
					
			        this.PETROEX_STATE_CODE = dis.readInt();
					
			        this.CONTRACT_ALLOCATION_ENABLED = dis.readInt();
					
					this.PETROEX_FEIN = readString(dis);
					
			        this.ELVIS_ORDER_NUMBER = dis.readInt();
					
					this.PETROEX_SHIPPER_INFO = readString(dis);
					
					this.ELVIS_LOADSPOT_ID = readString(dis);
					
					this.PETROEX_VEHICLE_TYPE = readString(dis);
					
			        this.OVERWEIGHT_TRAILER = dis.readInt();
					
			        this.ELVIS_AUTHORIZED = dis.readInt();
					
			        this.DISPATCHED_WITH_TRAILER = dis.readInt();
					
			        this.DISPATCHED_WITH_DRIVER = dis.readInt();
					
			        this.COMMITTED_PRICE = dis.readDouble();
					
			        this.LOADED_PRICE = dis.readDouble();
					
					this.CONTRACT_NUMBER = readString(dis);
					
			        this.MANUALLY_COMPLETED = dis.readInt();
					
			        this.OVERRIDE_TOLERANCE_CHECKS = dis.readInt();
					
			        this.AIC_STATUS = dis.readInt();
					
			        this.BLEND_TOLERANCE_STATUS = dis.readInt();
					
			        this.ADDITIVE_TOLERANCE_STATUS = dis.readInt();
					
			        this.AUTHORIZATION_REQUEST_ID = dis.readInt();
					
			        this.TABS_ORDER_NUMBER = dis.readInt();
					
			        this.FLAG_VALID_PRICE = dis.readInt();
					
			        this.BOL_NUMBER = dis.readInt();
					
			        this.COMPATIBILITY_STATUS = dis.readInt();
					
			        this.OVERRIDE_COMPATIBILITY_CHECKS = dis.readInt();
					
			        this.CANCELLED_FROM_CBS = dis.readInt();
					
					this.HOST_REF_ID = readString(dis);
					
			        this.UNACCOUNTED_LIMIT_EXCEEDED = dis.readInt();
					
			        this.OVERRIDE_UNACCOUNTED_CHECKS = dis.readInt();
					
			        this.PENDING_PRINT_COUNT = dis.readInt();
					
			        this.PENDING_REQUEST_COUNT = dis.readInt();
					
					this.PDXR_RACK_DRIVER_ID = readString(dis);
					
					this.PDXR_TERMINAL_CONTROL_NUMBER = readString(dis);
					
			        this.PDXR_FINAL_SHIPPER_XCTN_SEQ = dis.readInt();
					
					this.PDXR_DESTINATION_STATE_CODE = readString(dis);
					
					this.PDXR_DESTINATION_COUNTY = readString(dis);
					
					this.PDXR_DESTINATION_CITY = readString(dis);
					
					this.PDXR_DESTINATION_ZIP_CODE = readString(dis);
					
					this.PDXR_CARRIER_FEIN = readString(dis);
					
					this.PDXR_SHIPPER_INFO = readString(dis);
					
			        this.PDXR_VERSION = dis.readInt();
					
			        this.PDXR_VENDOR = dis.readInt();
					
						this.ORIG_ORDER_ID = readInteger(dis);
					
						this.PREV_ORDER_ID = readInteger(dis);
					
					this.SIGNATURE_PATH = readString(dis);
					
					this.SIGNATURE_FILE_NAME = readString(dis);
					
					this.PDXR_AUTHORIZING_SYSTEM = readString(dis);
					
					this.START_TIMESLOT_DATETIME = readDate(dis);
					
					this.END_TIMESLOT_DATETIME = readDate(dis);
					
					this.START_PICKUP_DATETIME = readDate(dis);
					
					this.END_PICKUP_DATETIME = readDate(dis);
					
			        this.ADMINISTRATIVE_BOOKING = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_ORDERS) {

        	try {

        		int length = 0;
		
			        this.ORDER_ID = dis.readInt();
					
						this.LOADED_DRIVER_NUMBER = readInteger(dis);
					
					this.USER_NAME = readString(dis);
					
						this.TRAILER_CARRIER_NUMBER = readInteger(dis);
					
			        this.CARRIER_NUMBER = dis.readInt();
					
					this.TRAILER_CODE = readString(dis);
					
						this.VEHICLE_CARRIER_NUMBER = readInteger(dis);
					
					this.VEHICLE_CODE = readString(dis);
					
						this.TRACTOR_CARRIER_NUMBER = readInteger(dis);
					
						this.LOADED_CARRIER_NUMBER = readInteger(dis);
					
					this.FOLIO_NUMBER = readString(dis);
					
						this.TRACTOR_NUMBER = readInteger(dis);
					
						this.DELIVERED_CARRIER_NUMBER = readInteger(dis);
					
						this.DISPATCH_CARRIER_NUMBER = readInteger(dis);
					
						this.DELIVERED_DRIVER_NUMBER = readInteger(dis);
					
			        this.SUPPLIER_NUMBER = dis.readInt();
					
			        this.CUSTOMER_NUMBER = dis.readInt();
					
					this.TABS_CARRIER_ID = readString(dis);
					
			        this.DESTINATION_NUMBER = dis.readInt();
					
						this.TRIP_ID = readInteger(dis);
					
					this.TABS_TRUCK_NUMBER = readString(dis);
					
			        this.TYPE = dis.readInt();
					
					this.SHOST_SU_SUPPLIER_NUMBER = readString(dis);
					
			        this.CREATOR = dis.readInt();
					
			        this.EXCHANGE_ALLOCATION_ENABLED = dis.readInt();
					
			        this.MANUALLY_ENTERED = dis.readInt();
					
					this.SHOST_EX_EHOST_THRU_NUMBER = readString(dis);
					
			        this.DEST_ALLOCATION_ENABLED = dis.readInt();
					
					this.THOST_TH_SUPPLIER_NUMBER = readString(dis);
					
			        this.CUST_ALLOC_BY_PRODUCT = dis.readInt();
					
			        this.CUST_ALLOC_BY_COMPONENT = dis.readInt();
					
			        this.CUST_ALLOC_BY_COMP_GROUP = dis.readInt();
					
			        this.CREDIT_ENABLED = dis.readInt();
					
					this.THOST_EX_THOST_EXCH_NUMBER = readString(dis);
					
			        this.BILLING_TYPE = dis.readInt();
					
			        this.EXCH_ALLOC_BY_PRODUCT = dis.readInt();
					
			        this.EXCH_ALLOC_BY_PRODUCT_GROUP = dis.readInt();
					
			        this.CUSTOMER_ALLOCATION_ENABLED = dis.readInt();
					
					this.TABS_FINAL_SHIPPER_ID = readString(dis);
					
			        this.CUST_ALLOC_BY_PRODUCT_GROUP = dis.readInt();
					
			        this.MOVEMENT_NUMBER = dis.readInt();
					
			        this.REVISION_NUMBER = dis.readInt();
					
					this.TABS_SELLER_ID = readString(dis);
					
			        this.REVISED = dis.readInt();
					
					this.TABS_CONSIGNEE_NUMBER = readString(dis);
					
			        this.STATUS = dis.readInt();
					
					this.CHOST_CU_SUPPLIER_NUMBER = readString(dis);
					
					this.CHOST_CU_CUSTOMER_NUMBER = readString(dis);
					
					this.STATUS_DATE = readDate(dis);
					
					this.PURCHASE_ORDER_NUMBER = readString(dis);
					
					this.REQUISITION_NUMBER = readString(dis);
					
					this.BOL_COMMENT_1 = readString(dis);
					
					this.BOL_COMMENT_2 = readString(dis);
					
			        this.INVOICE_REQUIRED = dis.readInt();
					
					this.INVOICE_COMMENT_1 = readString(dis);
					
					this.INVOICE_COMMENT_2 = readString(dis);
					
			        this.INVOICE_PRINTED = dis.readInt();
					
					this.DESTINATION_COMMENT_1 = readString(dis);
					
					this.DESTINATION_COMMENT_2 = readString(dis);
					
			        this.TABS_SUBSCRIBER = dis.readInt();
					
					this.REMARKS = readString(dis);
					
					this.START_LOAD_TIME = readDate(dis);
					
					this.END_LOAD_TIME = readDate(dis);
					
			        this.DELIVERY_FEE = dis.readDouble();
					
					this.TABS_AUTHORIZATION_NUMBER = readString(dis);
					
						this.THRUPUTTER_NUMBER = readInteger(dis);
					
					this.LAST_USER_NAME = readString(dis);
					
					this.LAST_MODIFIED = readDate(dis);
					
			        this.BOL_PRINTED = dis.readInt();
					
					this.ORDER_ENTRY_TIME = readDate(dis);
					
			        this.BILL_FREIGHT = dis.readInt();
					
					this.DELIVERY_DATE = readDate(dis);
					
			        this.SHIFT = dis.readInt();
					
			        this.STOP = dis.readInt();
					
			        this.DELIVERY_CONFIRMED = dis.readInt();
					
					this.VALIDATING_NODE_NAME = readString(dis);
					
			        this.HOST_PROCESSED = dis.readInt();
					
					this.PETROEX_COMPANY_CODE = readString(dis);
					
					this.PETROEX_CONSIGNEE_NUMBER = readString(dis);
					
					this.PETROEX_THIRD_PARTY = readString(dis);
					
					this.PETROEX_CARRIER_CODE = readString(dis);
					
			        this.PETROEX_TRUCK_NUMBER = dis.readInt();
					
			        this.PETROEX_SUBSCRIBER = dis.readInt();
					
					this.FAN_COMMENT_1 = readString(dis);
					
			        this.PETROEX_CITY_CODE = dis.readInt();
					
					this.FAN_COMMENT_2 = readString(dis);
					
			        this.PETROEX_COUNTY_CODE = dis.readInt();
					
			        this.PRELOAD_ORDER = dis.readInt();
					
			        this.PETROEX_STATE_CODE = dis.readInt();
					
			        this.CONTRACT_ALLOCATION_ENABLED = dis.readInt();
					
					this.PETROEX_FEIN = readString(dis);
					
			        this.ELVIS_ORDER_NUMBER = dis.readInt();
					
					this.PETROEX_SHIPPER_INFO = readString(dis);
					
					this.ELVIS_LOADSPOT_ID = readString(dis);
					
					this.PETROEX_VEHICLE_TYPE = readString(dis);
					
			        this.OVERWEIGHT_TRAILER = dis.readInt();
					
			        this.ELVIS_AUTHORIZED = dis.readInt();
					
			        this.DISPATCHED_WITH_TRAILER = dis.readInt();
					
			        this.DISPATCHED_WITH_DRIVER = dis.readInt();
					
			        this.COMMITTED_PRICE = dis.readDouble();
					
			        this.LOADED_PRICE = dis.readDouble();
					
					this.CONTRACT_NUMBER = readString(dis);
					
			        this.MANUALLY_COMPLETED = dis.readInt();
					
			        this.OVERRIDE_TOLERANCE_CHECKS = dis.readInt();
					
			        this.AIC_STATUS = dis.readInt();
					
			        this.BLEND_TOLERANCE_STATUS = dis.readInt();
					
			        this.ADDITIVE_TOLERANCE_STATUS = dis.readInt();
					
			        this.AUTHORIZATION_REQUEST_ID = dis.readInt();
					
			        this.TABS_ORDER_NUMBER = dis.readInt();
					
			        this.FLAG_VALID_PRICE = dis.readInt();
					
			        this.BOL_NUMBER = dis.readInt();
					
			        this.COMPATIBILITY_STATUS = dis.readInt();
					
			        this.OVERRIDE_COMPATIBILITY_CHECKS = dis.readInt();
					
			        this.CANCELLED_FROM_CBS = dis.readInt();
					
					this.HOST_REF_ID = readString(dis);
					
			        this.UNACCOUNTED_LIMIT_EXCEEDED = dis.readInt();
					
			        this.OVERRIDE_UNACCOUNTED_CHECKS = dis.readInt();
					
			        this.PENDING_PRINT_COUNT = dis.readInt();
					
			        this.PENDING_REQUEST_COUNT = dis.readInt();
					
					this.PDXR_RACK_DRIVER_ID = readString(dis);
					
					this.PDXR_TERMINAL_CONTROL_NUMBER = readString(dis);
					
			        this.PDXR_FINAL_SHIPPER_XCTN_SEQ = dis.readInt();
					
					this.PDXR_DESTINATION_STATE_CODE = readString(dis);
					
					this.PDXR_DESTINATION_COUNTY = readString(dis);
					
					this.PDXR_DESTINATION_CITY = readString(dis);
					
					this.PDXR_DESTINATION_ZIP_CODE = readString(dis);
					
					this.PDXR_CARRIER_FEIN = readString(dis);
					
					this.PDXR_SHIPPER_INFO = readString(dis);
					
			        this.PDXR_VERSION = dis.readInt();
					
			        this.PDXR_VENDOR = dis.readInt();
					
						this.ORIG_ORDER_ID = readInteger(dis);
					
						this.PREV_ORDER_ID = readInteger(dis);
					
					this.SIGNATURE_PATH = readString(dis);
					
					this.SIGNATURE_FILE_NAME = readString(dis);
					
					this.PDXR_AUTHORIZING_SYSTEM = readString(dis);
					
					this.START_TIMESLOT_DATETIME = readDate(dis);
					
					this.END_TIMESLOT_DATETIME = readDate(dis);
					
					this.START_PICKUP_DATETIME = readDate(dis);
					
					this.END_PICKUP_DATETIME = readDate(dis);
					
			        this.ADMINISTRATIVE_BOOKING = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.ORDER_ID);
					
					// Integer
				
						writeInteger(this.LOADED_DRIVER_NUMBER,dos);
					
					// String
				
						writeString(this.USER_NAME,dos);
					
					// Integer
				
						writeInteger(this.TRAILER_CARRIER_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.CARRIER_NUMBER);
					
					// String
				
						writeString(this.TRAILER_CODE,dos);
					
					// Integer
				
						writeInteger(this.VEHICLE_CARRIER_NUMBER,dos);
					
					// String
				
						writeString(this.VEHICLE_CODE,dos);
					
					// Integer
				
						writeInteger(this.TRACTOR_CARRIER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.LOADED_CARRIER_NUMBER,dos);
					
					// String
				
						writeString(this.FOLIO_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.TRACTOR_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.DELIVERED_CARRIER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.DISPATCH_CARRIER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.DELIVERED_DRIVER_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.SUPPLIER_NUMBER);
					
					// int
				
		            	dos.writeInt(this.CUSTOMER_NUMBER);
					
					// String
				
						writeString(this.TABS_CARRIER_ID,dos);
					
					// int
				
		            	dos.writeInt(this.DESTINATION_NUMBER);
					
					// Integer
				
						writeInteger(this.TRIP_ID,dos);
					
					// String
				
						writeString(this.TABS_TRUCK_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.TYPE);
					
					// String
				
						writeString(this.SHOST_SU_SUPPLIER_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.CREATOR);
					
					// int
				
		            	dos.writeInt(this.EXCHANGE_ALLOCATION_ENABLED);
					
					// int
				
		            	dos.writeInt(this.MANUALLY_ENTERED);
					
					// String
				
						writeString(this.SHOST_EX_EHOST_THRU_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.DEST_ALLOCATION_ENABLED);
					
					// String
				
						writeString(this.THOST_TH_SUPPLIER_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.CUST_ALLOC_BY_PRODUCT);
					
					// int
				
		            	dos.writeInt(this.CUST_ALLOC_BY_COMPONENT);
					
					// int
				
		            	dos.writeInt(this.CUST_ALLOC_BY_COMP_GROUP);
					
					// int
				
		            	dos.writeInt(this.CREDIT_ENABLED);
					
					// String
				
						writeString(this.THOST_EX_THOST_EXCH_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.BILLING_TYPE);
					
					// int
				
		            	dos.writeInt(this.EXCH_ALLOC_BY_PRODUCT);
					
					// int
				
		            	dos.writeInt(this.EXCH_ALLOC_BY_PRODUCT_GROUP);
					
					// int
				
		            	dos.writeInt(this.CUSTOMER_ALLOCATION_ENABLED);
					
					// String
				
						writeString(this.TABS_FINAL_SHIPPER_ID,dos);
					
					// int
				
		            	dos.writeInt(this.CUST_ALLOC_BY_PRODUCT_GROUP);
					
					// int
				
		            	dos.writeInt(this.MOVEMENT_NUMBER);
					
					// int
				
		            	dos.writeInt(this.REVISION_NUMBER);
					
					// String
				
						writeString(this.TABS_SELLER_ID,dos);
					
					// int
				
		            	dos.writeInt(this.REVISED);
					
					// String
				
						writeString(this.TABS_CONSIGNEE_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.STATUS);
					
					// String
				
						writeString(this.CHOST_CU_SUPPLIER_NUMBER,dos);
					
					// String
				
						writeString(this.CHOST_CU_CUSTOMER_NUMBER,dos);
					
					// java.util.Date
				
						writeDate(this.STATUS_DATE,dos);
					
					// String
				
						writeString(this.PURCHASE_ORDER_NUMBER,dos);
					
					// String
				
						writeString(this.REQUISITION_NUMBER,dos);
					
					// String
				
						writeString(this.BOL_COMMENT_1,dos);
					
					// String
				
						writeString(this.BOL_COMMENT_2,dos);
					
					// int
				
		            	dos.writeInt(this.INVOICE_REQUIRED);
					
					// String
				
						writeString(this.INVOICE_COMMENT_1,dos);
					
					// String
				
						writeString(this.INVOICE_COMMENT_2,dos);
					
					// int
				
		            	dos.writeInt(this.INVOICE_PRINTED);
					
					// String
				
						writeString(this.DESTINATION_COMMENT_1,dos);
					
					// String
				
						writeString(this.DESTINATION_COMMENT_2,dos);
					
					// int
				
		            	dos.writeInt(this.TABS_SUBSCRIBER);
					
					// String
				
						writeString(this.REMARKS,dos);
					
					// java.util.Date
				
						writeDate(this.START_LOAD_TIME,dos);
					
					// java.util.Date
				
						writeDate(this.END_LOAD_TIME,dos);
					
					// double
				
		            	dos.writeDouble(this.DELIVERY_FEE);
					
					// String
				
						writeString(this.TABS_AUTHORIZATION_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.THRUPUTTER_NUMBER,dos);
					
					// String
				
						writeString(this.LAST_USER_NAME,dos);
					
					// java.util.Date
				
						writeDate(this.LAST_MODIFIED,dos);
					
					// int
				
		            	dos.writeInt(this.BOL_PRINTED);
					
					// java.util.Date
				
						writeDate(this.ORDER_ENTRY_TIME,dos);
					
					// int
				
		            	dos.writeInt(this.BILL_FREIGHT);
					
					// java.util.Date
				
						writeDate(this.DELIVERY_DATE,dos);
					
					// int
				
		            	dos.writeInt(this.SHIFT);
					
					// int
				
		            	dos.writeInt(this.STOP);
					
					// int
				
		            	dos.writeInt(this.DELIVERY_CONFIRMED);
					
					// String
				
						writeString(this.VALIDATING_NODE_NAME,dos);
					
					// int
				
		            	dos.writeInt(this.HOST_PROCESSED);
					
					// String
				
						writeString(this.PETROEX_COMPANY_CODE,dos);
					
					// String
				
						writeString(this.PETROEX_CONSIGNEE_NUMBER,dos);
					
					// String
				
						writeString(this.PETROEX_THIRD_PARTY,dos);
					
					// String
				
						writeString(this.PETROEX_CARRIER_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.PETROEX_TRUCK_NUMBER);
					
					// int
				
		            	dos.writeInt(this.PETROEX_SUBSCRIBER);
					
					// String
				
						writeString(this.FAN_COMMENT_1,dos);
					
					// int
				
		            	dos.writeInt(this.PETROEX_CITY_CODE);
					
					// String
				
						writeString(this.FAN_COMMENT_2,dos);
					
					// int
				
		            	dos.writeInt(this.PETROEX_COUNTY_CODE);
					
					// int
				
		            	dos.writeInt(this.PRELOAD_ORDER);
					
					// int
				
		            	dos.writeInt(this.PETROEX_STATE_CODE);
					
					// int
				
		            	dos.writeInt(this.CONTRACT_ALLOCATION_ENABLED);
					
					// String
				
						writeString(this.PETROEX_FEIN,dos);
					
					// int
				
		            	dos.writeInt(this.ELVIS_ORDER_NUMBER);
					
					// String
				
						writeString(this.PETROEX_SHIPPER_INFO,dos);
					
					// String
				
						writeString(this.ELVIS_LOADSPOT_ID,dos);
					
					// String
				
						writeString(this.PETROEX_VEHICLE_TYPE,dos);
					
					// int
				
		            	dos.writeInt(this.OVERWEIGHT_TRAILER);
					
					// int
				
		            	dos.writeInt(this.ELVIS_AUTHORIZED);
					
					// int
				
		            	dos.writeInt(this.DISPATCHED_WITH_TRAILER);
					
					// int
				
		            	dos.writeInt(this.DISPATCHED_WITH_DRIVER);
					
					// double
				
		            	dos.writeDouble(this.COMMITTED_PRICE);
					
					// double
				
		            	dos.writeDouble(this.LOADED_PRICE);
					
					// String
				
						writeString(this.CONTRACT_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.MANUALLY_COMPLETED);
					
					// int
				
		            	dos.writeInt(this.OVERRIDE_TOLERANCE_CHECKS);
					
					// int
				
		            	dos.writeInt(this.AIC_STATUS);
					
					// int
				
		            	dos.writeInt(this.BLEND_TOLERANCE_STATUS);
					
					// int
				
		            	dos.writeInt(this.ADDITIVE_TOLERANCE_STATUS);
					
					// int
				
		            	dos.writeInt(this.AUTHORIZATION_REQUEST_ID);
					
					// int
				
		            	dos.writeInt(this.TABS_ORDER_NUMBER);
					
					// int
				
		            	dos.writeInt(this.FLAG_VALID_PRICE);
					
					// int
				
		            	dos.writeInt(this.BOL_NUMBER);
					
					// int
				
		            	dos.writeInt(this.COMPATIBILITY_STATUS);
					
					// int
				
		            	dos.writeInt(this.OVERRIDE_COMPATIBILITY_CHECKS);
					
					// int
				
		            	dos.writeInt(this.CANCELLED_FROM_CBS);
					
					// String
				
						writeString(this.HOST_REF_ID,dos);
					
					// int
				
		            	dos.writeInt(this.UNACCOUNTED_LIMIT_EXCEEDED);
					
					// int
				
		            	dos.writeInt(this.OVERRIDE_UNACCOUNTED_CHECKS);
					
					// int
				
		            	dos.writeInt(this.PENDING_PRINT_COUNT);
					
					// int
				
		            	dos.writeInt(this.PENDING_REQUEST_COUNT);
					
					// String
				
						writeString(this.PDXR_RACK_DRIVER_ID,dos);
					
					// String
				
						writeString(this.PDXR_TERMINAL_CONTROL_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.PDXR_FINAL_SHIPPER_XCTN_SEQ);
					
					// String
				
						writeString(this.PDXR_DESTINATION_STATE_CODE,dos);
					
					// String
				
						writeString(this.PDXR_DESTINATION_COUNTY,dos);
					
					// String
				
						writeString(this.PDXR_DESTINATION_CITY,dos);
					
					// String
				
						writeString(this.PDXR_DESTINATION_ZIP_CODE,dos);
					
					// String
				
						writeString(this.PDXR_CARRIER_FEIN,dos);
					
					// String
				
						writeString(this.PDXR_SHIPPER_INFO,dos);
					
					// int
				
		            	dos.writeInt(this.PDXR_VERSION);
					
					// int
				
		            	dos.writeInt(this.PDXR_VENDOR);
					
					// Integer
				
						writeInteger(this.ORIG_ORDER_ID,dos);
					
					// Integer
				
						writeInteger(this.PREV_ORDER_ID,dos);
					
					// String
				
						writeString(this.SIGNATURE_PATH,dos);
					
					// String
				
						writeString(this.SIGNATURE_FILE_NAME,dos);
					
					// String
				
						writeString(this.PDXR_AUTHORIZING_SYSTEM,dos);
					
					// java.util.Date
				
						writeDate(this.START_TIMESLOT_DATETIME,dos);
					
					// java.util.Date
				
						writeDate(this.END_TIMESLOT_DATETIME,dos);
					
					// java.util.Date
				
						writeDate(this.START_PICKUP_DATETIME,dos);
					
					// java.util.Date
				
						writeDate(this.END_PICKUP_DATETIME,dos);
					
					// int
				
		            	dos.writeInt(this.ADMINISTRATIVE_BOOKING);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.ORDER_ID);
					
					// Integer
				
						writeInteger(this.LOADED_DRIVER_NUMBER,dos);
					
					// String
				
						writeString(this.USER_NAME,dos);
					
					// Integer
				
						writeInteger(this.TRAILER_CARRIER_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.CARRIER_NUMBER);
					
					// String
				
						writeString(this.TRAILER_CODE,dos);
					
					// Integer
				
						writeInteger(this.VEHICLE_CARRIER_NUMBER,dos);
					
					// String
				
						writeString(this.VEHICLE_CODE,dos);
					
					// Integer
				
						writeInteger(this.TRACTOR_CARRIER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.LOADED_CARRIER_NUMBER,dos);
					
					// String
				
						writeString(this.FOLIO_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.TRACTOR_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.DELIVERED_CARRIER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.DISPATCH_CARRIER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.DELIVERED_DRIVER_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.SUPPLIER_NUMBER);
					
					// int
				
		            	dos.writeInt(this.CUSTOMER_NUMBER);
					
					// String
				
						writeString(this.TABS_CARRIER_ID,dos);
					
					// int
				
		            	dos.writeInt(this.DESTINATION_NUMBER);
					
					// Integer
				
						writeInteger(this.TRIP_ID,dos);
					
					// String
				
						writeString(this.TABS_TRUCK_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.TYPE);
					
					// String
				
						writeString(this.SHOST_SU_SUPPLIER_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.CREATOR);
					
					// int
				
		            	dos.writeInt(this.EXCHANGE_ALLOCATION_ENABLED);
					
					// int
				
		            	dos.writeInt(this.MANUALLY_ENTERED);
					
					// String
				
						writeString(this.SHOST_EX_EHOST_THRU_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.DEST_ALLOCATION_ENABLED);
					
					// String
				
						writeString(this.THOST_TH_SUPPLIER_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.CUST_ALLOC_BY_PRODUCT);
					
					// int
				
		            	dos.writeInt(this.CUST_ALLOC_BY_COMPONENT);
					
					// int
				
		            	dos.writeInt(this.CUST_ALLOC_BY_COMP_GROUP);
					
					// int
				
		            	dos.writeInt(this.CREDIT_ENABLED);
					
					// String
				
						writeString(this.THOST_EX_THOST_EXCH_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.BILLING_TYPE);
					
					// int
				
		            	dos.writeInt(this.EXCH_ALLOC_BY_PRODUCT);
					
					// int
				
		            	dos.writeInt(this.EXCH_ALLOC_BY_PRODUCT_GROUP);
					
					// int
				
		            	dos.writeInt(this.CUSTOMER_ALLOCATION_ENABLED);
					
					// String
				
						writeString(this.TABS_FINAL_SHIPPER_ID,dos);
					
					// int
				
		            	dos.writeInt(this.CUST_ALLOC_BY_PRODUCT_GROUP);
					
					// int
				
		            	dos.writeInt(this.MOVEMENT_NUMBER);
					
					// int
				
		            	dos.writeInt(this.REVISION_NUMBER);
					
					// String
				
						writeString(this.TABS_SELLER_ID,dos);
					
					// int
				
		            	dos.writeInt(this.REVISED);
					
					// String
				
						writeString(this.TABS_CONSIGNEE_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.STATUS);
					
					// String
				
						writeString(this.CHOST_CU_SUPPLIER_NUMBER,dos);
					
					// String
				
						writeString(this.CHOST_CU_CUSTOMER_NUMBER,dos);
					
					// java.util.Date
				
						writeDate(this.STATUS_DATE,dos);
					
					// String
				
						writeString(this.PURCHASE_ORDER_NUMBER,dos);
					
					// String
				
						writeString(this.REQUISITION_NUMBER,dos);
					
					// String
				
						writeString(this.BOL_COMMENT_1,dos);
					
					// String
				
						writeString(this.BOL_COMMENT_2,dos);
					
					// int
				
		            	dos.writeInt(this.INVOICE_REQUIRED);
					
					// String
				
						writeString(this.INVOICE_COMMENT_1,dos);
					
					// String
				
						writeString(this.INVOICE_COMMENT_2,dos);
					
					// int
				
		            	dos.writeInt(this.INVOICE_PRINTED);
					
					// String
				
						writeString(this.DESTINATION_COMMENT_1,dos);
					
					// String
				
						writeString(this.DESTINATION_COMMENT_2,dos);
					
					// int
				
		            	dos.writeInt(this.TABS_SUBSCRIBER);
					
					// String
				
						writeString(this.REMARKS,dos);
					
					// java.util.Date
				
						writeDate(this.START_LOAD_TIME,dos);
					
					// java.util.Date
				
						writeDate(this.END_LOAD_TIME,dos);
					
					// double
				
		            	dos.writeDouble(this.DELIVERY_FEE);
					
					// String
				
						writeString(this.TABS_AUTHORIZATION_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.THRUPUTTER_NUMBER,dos);
					
					// String
				
						writeString(this.LAST_USER_NAME,dos);
					
					// java.util.Date
				
						writeDate(this.LAST_MODIFIED,dos);
					
					// int
				
		            	dos.writeInt(this.BOL_PRINTED);
					
					// java.util.Date
				
						writeDate(this.ORDER_ENTRY_TIME,dos);
					
					// int
				
		            	dos.writeInt(this.BILL_FREIGHT);
					
					// java.util.Date
				
						writeDate(this.DELIVERY_DATE,dos);
					
					// int
				
		            	dos.writeInt(this.SHIFT);
					
					// int
				
		            	dos.writeInt(this.STOP);
					
					// int
				
		            	dos.writeInt(this.DELIVERY_CONFIRMED);
					
					// String
				
						writeString(this.VALIDATING_NODE_NAME,dos);
					
					// int
				
		            	dos.writeInt(this.HOST_PROCESSED);
					
					// String
				
						writeString(this.PETROEX_COMPANY_CODE,dos);
					
					// String
				
						writeString(this.PETROEX_CONSIGNEE_NUMBER,dos);
					
					// String
				
						writeString(this.PETROEX_THIRD_PARTY,dos);
					
					// String
				
						writeString(this.PETROEX_CARRIER_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.PETROEX_TRUCK_NUMBER);
					
					// int
				
		            	dos.writeInt(this.PETROEX_SUBSCRIBER);
					
					// String
				
						writeString(this.FAN_COMMENT_1,dos);
					
					// int
				
		            	dos.writeInt(this.PETROEX_CITY_CODE);
					
					// String
				
						writeString(this.FAN_COMMENT_2,dos);
					
					// int
				
		            	dos.writeInt(this.PETROEX_COUNTY_CODE);
					
					// int
				
		            	dos.writeInt(this.PRELOAD_ORDER);
					
					// int
				
		            	dos.writeInt(this.PETROEX_STATE_CODE);
					
					// int
				
		            	dos.writeInt(this.CONTRACT_ALLOCATION_ENABLED);
					
					// String
				
						writeString(this.PETROEX_FEIN,dos);
					
					// int
				
		            	dos.writeInt(this.ELVIS_ORDER_NUMBER);
					
					// String
				
						writeString(this.PETROEX_SHIPPER_INFO,dos);
					
					// String
				
						writeString(this.ELVIS_LOADSPOT_ID,dos);
					
					// String
				
						writeString(this.PETROEX_VEHICLE_TYPE,dos);
					
					// int
				
		            	dos.writeInt(this.OVERWEIGHT_TRAILER);
					
					// int
				
		            	dos.writeInt(this.ELVIS_AUTHORIZED);
					
					// int
				
		            	dos.writeInt(this.DISPATCHED_WITH_TRAILER);
					
					// int
				
		            	dos.writeInt(this.DISPATCHED_WITH_DRIVER);
					
					// double
				
		            	dos.writeDouble(this.COMMITTED_PRICE);
					
					// double
				
		            	dos.writeDouble(this.LOADED_PRICE);
					
					// String
				
						writeString(this.CONTRACT_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.MANUALLY_COMPLETED);
					
					// int
				
		            	dos.writeInt(this.OVERRIDE_TOLERANCE_CHECKS);
					
					// int
				
		            	dos.writeInt(this.AIC_STATUS);
					
					// int
				
		            	dos.writeInt(this.BLEND_TOLERANCE_STATUS);
					
					// int
				
		            	dos.writeInt(this.ADDITIVE_TOLERANCE_STATUS);
					
					// int
				
		            	dos.writeInt(this.AUTHORIZATION_REQUEST_ID);
					
					// int
				
		            	dos.writeInt(this.TABS_ORDER_NUMBER);
					
					// int
				
		            	dos.writeInt(this.FLAG_VALID_PRICE);
					
					// int
				
		            	dos.writeInt(this.BOL_NUMBER);
					
					// int
				
		            	dos.writeInt(this.COMPATIBILITY_STATUS);
					
					// int
				
		            	dos.writeInt(this.OVERRIDE_COMPATIBILITY_CHECKS);
					
					// int
				
		            	dos.writeInt(this.CANCELLED_FROM_CBS);
					
					// String
				
						writeString(this.HOST_REF_ID,dos);
					
					// int
				
		            	dos.writeInt(this.UNACCOUNTED_LIMIT_EXCEEDED);
					
					// int
				
		            	dos.writeInt(this.OVERRIDE_UNACCOUNTED_CHECKS);
					
					// int
				
		            	dos.writeInt(this.PENDING_PRINT_COUNT);
					
					// int
				
		            	dos.writeInt(this.PENDING_REQUEST_COUNT);
					
					// String
				
						writeString(this.PDXR_RACK_DRIVER_ID,dos);
					
					// String
				
						writeString(this.PDXR_TERMINAL_CONTROL_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.PDXR_FINAL_SHIPPER_XCTN_SEQ);
					
					// String
				
						writeString(this.PDXR_DESTINATION_STATE_CODE,dos);
					
					// String
				
						writeString(this.PDXR_DESTINATION_COUNTY,dos);
					
					// String
				
						writeString(this.PDXR_DESTINATION_CITY,dos);
					
					// String
				
						writeString(this.PDXR_DESTINATION_ZIP_CODE,dos);
					
					// String
				
						writeString(this.PDXR_CARRIER_FEIN,dos);
					
					// String
				
						writeString(this.PDXR_SHIPPER_INFO,dos);
					
					// int
				
		            	dos.writeInt(this.PDXR_VERSION);
					
					// int
				
		            	dos.writeInt(this.PDXR_VENDOR);
					
					// Integer
				
						writeInteger(this.ORIG_ORDER_ID,dos);
					
					// Integer
				
						writeInteger(this.PREV_ORDER_ID,dos);
					
					// String
				
						writeString(this.SIGNATURE_PATH,dos);
					
					// String
				
						writeString(this.SIGNATURE_FILE_NAME,dos);
					
					// String
				
						writeString(this.PDXR_AUTHORIZING_SYSTEM,dos);
					
					// java.util.Date
				
						writeDate(this.START_TIMESLOT_DATETIME,dos);
					
					// java.util.Date
				
						writeDate(this.END_TIMESLOT_DATETIME,dos);
					
					// java.util.Date
				
						writeDate(this.START_PICKUP_DATETIME,dos);
					
					// java.util.Date
				
						writeDate(this.END_PICKUP_DATETIME,dos);
					
					// int
				
		            	dos.writeInt(this.ADMINISTRATIVE_BOOKING);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("ORDER_ID="+String.valueOf(ORDER_ID));
		sb.append(",LOADED_DRIVER_NUMBER="+String.valueOf(LOADED_DRIVER_NUMBER));
		sb.append(",USER_NAME="+USER_NAME);
		sb.append(",TRAILER_CARRIER_NUMBER="+String.valueOf(TRAILER_CARRIER_NUMBER));
		sb.append(",CARRIER_NUMBER="+String.valueOf(CARRIER_NUMBER));
		sb.append(",TRAILER_CODE="+TRAILER_CODE);
		sb.append(",VEHICLE_CARRIER_NUMBER="+String.valueOf(VEHICLE_CARRIER_NUMBER));
		sb.append(",VEHICLE_CODE="+VEHICLE_CODE);
		sb.append(",TRACTOR_CARRIER_NUMBER="+String.valueOf(TRACTOR_CARRIER_NUMBER));
		sb.append(",LOADED_CARRIER_NUMBER="+String.valueOf(LOADED_CARRIER_NUMBER));
		sb.append(",FOLIO_NUMBER="+FOLIO_NUMBER);
		sb.append(",TRACTOR_NUMBER="+String.valueOf(TRACTOR_NUMBER));
		sb.append(",DELIVERED_CARRIER_NUMBER="+String.valueOf(DELIVERED_CARRIER_NUMBER));
		sb.append(",DISPATCH_CARRIER_NUMBER="+String.valueOf(DISPATCH_CARRIER_NUMBER));
		sb.append(",DELIVERED_DRIVER_NUMBER="+String.valueOf(DELIVERED_DRIVER_NUMBER));
		sb.append(",SUPPLIER_NUMBER="+String.valueOf(SUPPLIER_NUMBER));
		sb.append(",CUSTOMER_NUMBER="+String.valueOf(CUSTOMER_NUMBER));
		sb.append(",TABS_CARRIER_ID="+TABS_CARRIER_ID);
		sb.append(",DESTINATION_NUMBER="+String.valueOf(DESTINATION_NUMBER));
		sb.append(",TRIP_ID="+String.valueOf(TRIP_ID));
		sb.append(",TABS_TRUCK_NUMBER="+TABS_TRUCK_NUMBER);
		sb.append(",TYPE="+String.valueOf(TYPE));
		sb.append(",SHOST_SU_SUPPLIER_NUMBER="+SHOST_SU_SUPPLIER_NUMBER);
		sb.append(",CREATOR="+String.valueOf(CREATOR));
		sb.append(",EXCHANGE_ALLOCATION_ENABLED="+String.valueOf(EXCHANGE_ALLOCATION_ENABLED));
		sb.append(",MANUALLY_ENTERED="+String.valueOf(MANUALLY_ENTERED));
		sb.append(",SHOST_EX_EHOST_THRU_NUMBER="+SHOST_EX_EHOST_THRU_NUMBER);
		sb.append(",DEST_ALLOCATION_ENABLED="+String.valueOf(DEST_ALLOCATION_ENABLED));
		sb.append(",THOST_TH_SUPPLIER_NUMBER="+THOST_TH_SUPPLIER_NUMBER);
		sb.append(",CUST_ALLOC_BY_PRODUCT="+String.valueOf(CUST_ALLOC_BY_PRODUCT));
		sb.append(",CUST_ALLOC_BY_COMPONENT="+String.valueOf(CUST_ALLOC_BY_COMPONENT));
		sb.append(",CUST_ALLOC_BY_COMP_GROUP="+String.valueOf(CUST_ALLOC_BY_COMP_GROUP));
		sb.append(",CREDIT_ENABLED="+String.valueOf(CREDIT_ENABLED));
		sb.append(",THOST_EX_THOST_EXCH_NUMBER="+THOST_EX_THOST_EXCH_NUMBER);
		sb.append(",BILLING_TYPE="+String.valueOf(BILLING_TYPE));
		sb.append(",EXCH_ALLOC_BY_PRODUCT="+String.valueOf(EXCH_ALLOC_BY_PRODUCT));
		sb.append(",EXCH_ALLOC_BY_PRODUCT_GROUP="+String.valueOf(EXCH_ALLOC_BY_PRODUCT_GROUP));
		sb.append(",CUSTOMER_ALLOCATION_ENABLED="+String.valueOf(CUSTOMER_ALLOCATION_ENABLED));
		sb.append(",TABS_FINAL_SHIPPER_ID="+TABS_FINAL_SHIPPER_ID);
		sb.append(",CUST_ALLOC_BY_PRODUCT_GROUP="+String.valueOf(CUST_ALLOC_BY_PRODUCT_GROUP));
		sb.append(",MOVEMENT_NUMBER="+String.valueOf(MOVEMENT_NUMBER));
		sb.append(",REVISION_NUMBER="+String.valueOf(REVISION_NUMBER));
		sb.append(",TABS_SELLER_ID="+TABS_SELLER_ID);
		sb.append(",REVISED="+String.valueOf(REVISED));
		sb.append(",TABS_CONSIGNEE_NUMBER="+TABS_CONSIGNEE_NUMBER);
		sb.append(",STATUS="+String.valueOf(STATUS));
		sb.append(",CHOST_CU_SUPPLIER_NUMBER="+CHOST_CU_SUPPLIER_NUMBER);
		sb.append(",CHOST_CU_CUSTOMER_NUMBER="+CHOST_CU_CUSTOMER_NUMBER);
		sb.append(",STATUS_DATE="+String.valueOf(STATUS_DATE));
		sb.append(",PURCHASE_ORDER_NUMBER="+PURCHASE_ORDER_NUMBER);
		sb.append(",REQUISITION_NUMBER="+REQUISITION_NUMBER);
		sb.append(",BOL_COMMENT_1="+BOL_COMMENT_1);
		sb.append(",BOL_COMMENT_2="+BOL_COMMENT_2);
		sb.append(",INVOICE_REQUIRED="+String.valueOf(INVOICE_REQUIRED));
		sb.append(",INVOICE_COMMENT_1="+INVOICE_COMMENT_1);
		sb.append(",INVOICE_COMMENT_2="+INVOICE_COMMENT_2);
		sb.append(",INVOICE_PRINTED="+String.valueOf(INVOICE_PRINTED));
		sb.append(",DESTINATION_COMMENT_1="+DESTINATION_COMMENT_1);
		sb.append(",DESTINATION_COMMENT_2="+DESTINATION_COMMENT_2);
		sb.append(",TABS_SUBSCRIBER="+String.valueOf(TABS_SUBSCRIBER));
		sb.append(",REMARKS="+REMARKS);
		sb.append(",START_LOAD_TIME="+String.valueOf(START_LOAD_TIME));
		sb.append(",END_LOAD_TIME="+String.valueOf(END_LOAD_TIME));
		sb.append(",DELIVERY_FEE="+String.valueOf(DELIVERY_FEE));
		sb.append(",TABS_AUTHORIZATION_NUMBER="+TABS_AUTHORIZATION_NUMBER);
		sb.append(",THRUPUTTER_NUMBER="+String.valueOf(THRUPUTTER_NUMBER));
		sb.append(",LAST_USER_NAME="+LAST_USER_NAME);
		sb.append(",LAST_MODIFIED="+String.valueOf(LAST_MODIFIED));
		sb.append(",BOL_PRINTED="+String.valueOf(BOL_PRINTED));
		sb.append(",ORDER_ENTRY_TIME="+String.valueOf(ORDER_ENTRY_TIME));
		sb.append(",BILL_FREIGHT="+String.valueOf(BILL_FREIGHT));
		sb.append(",DELIVERY_DATE="+String.valueOf(DELIVERY_DATE));
		sb.append(",SHIFT="+String.valueOf(SHIFT));
		sb.append(",STOP="+String.valueOf(STOP));
		sb.append(",DELIVERY_CONFIRMED="+String.valueOf(DELIVERY_CONFIRMED));
		sb.append(",VALIDATING_NODE_NAME="+VALIDATING_NODE_NAME);
		sb.append(",HOST_PROCESSED="+String.valueOf(HOST_PROCESSED));
		sb.append(",PETROEX_COMPANY_CODE="+PETROEX_COMPANY_CODE);
		sb.append(",PETROEX_CONSIGNEE_NUMBER="+PETROEX_CONSIGNEE_NUMBER);
		sb.append(",PETROEX_THIRD_PARTY="+PETROEX_THIRD_PARTY);
		sb.append(",PETROEX_CARRIER_CODE="+PETROEX_CARRIER_CODE);
		sb.append(",PETROEX_TRUCK_NUMBER="+String.valueOf(PETROEX_TRUCK_NUMBER));
		sb.append(",PETROEX_SUBSCRIBER="+String.valueOf(PETROEX_SUBSCRIBER));
		sb.append(",FAN_COMMENT_1="+FAN_COMMENT_1);
		sb.append(",PETROEX_CITY_CODE="+String.valueOf(PETROEX_CITY_CODE));
		sb.append(",FAN_COMMENT_2="+FAN_COMMENT_2);
		sb.append(",PETROEX_COUNTY_CODE="+String.valueOf(PETROEX_COUNTY_CODE));
		sb.append(",PRELOAD_ORDER="+String.valueOf(PRELOAD_ORDER));
		sb.append(",PETROEX_STATE_CODE="+String.valueOf(PETROEX_STATE_CODE));
		sb.append(",CONTRACT_ALLOCATION_ENABLED="+String.valueOf(CONTRACT_ALLOCATION_ENABLED));
		sb.append(",PETROEX_FEIN="+PETROEX_FEIN);
		sb.append(",ELVIS_ORDER_NUMBER="+String.valueOf(ELVIS_ORDER_NUMBER));
		sb.append(",PETROEX_SHIPPER_INFO="+PETROEX_SHIPPER_INFO);
		sb.append(",ELVIS_LOADSPOT_ID="+ELVIS_LOADSPOT_ID);
		sb.append(",PETROEX_VEHICLE_TYPE="+PETROEX_VEHICLE_TYPE);
		sb.append(",OVERWEIGHT_TRAILER="+String.valueOf(OVERWEIGHT_TRAILER));
		sb.append(",ELVIS_AUTHORIZED="+String.valueOf(ELVIS_AUTHORIZED));
		sb.append(",DISPATCHED_WITH_TRAILER="+String.valueOf(DISPATCHED_WITH_TRAILER));
		sb.append(",DISPATCHED_WITH_DRIVER="+String.valueOf(DISPATCHED_WITH_DRIVER));
		sb.append(",COMMITTED_PRICE="+String.valueOf(COMMITTED_PRICE));
		sb.append(",LOADED_PRICE="+String.valueOf(LOADED_PRICE));
		sb.append(",CONTRACT_NUMBER="+CONTRACT_NUMBER);
		sb.append(",MANUALLY_COMPLETED="+String.valueOf(MANUALLY_COMPLETED));
		sb.append(",OVERRIDE_TOLERANCE_CHECKS="+String.valueOf(OVERRIDE_TOLERANCE_CHECKS));
		sb.append(",AIC_STATUS="+String.valueOf(AIC_STATUS));
		sb.append(",BLEND_TOLERANCE_STATUS="+String.valueOf(BLEND_TOLERANCE_STATUS));
		sb.append(",ADDITIVE_TOLERANCE_STATUS="+String.valueOf(ADDITIVE_TOLERANCE_STATUS));
		sb.append(",AUTHORIZATION_REQUEST_ID="+String.valueOf(AUTHORIZATION_REQUEST_ID));
		sb.append(",TABS_ORDER_NUMBER="+String.valueOf(TABS_ORDER_NUMBER));
		sb.append(",FLAG_VALID_PRICE="+String.valueOf(FLAG_VALID_PRICE));
		sb.append(",BOL_NUMBER="+String.valueOf(BOL_NUMBER));
		sb.append(",COMPATIBILITY_STATUS="+String.valueOf(COMPATIBILITY_STATUS));
		sb.append(",OVERRIDE_COMPATIBILITY_CHECKS="+String.valueOf(OVERRIDE_COMPATIBILITY_CHECKS));
		sb.append(",CANCELLED_FROM_CBS="+String.valueOf(CANCELLED_FROM_CBS));
		sb.append(",HOST_REF_ID="+HOST_REF_ID);
		sb.append(",UNACCOUNTED_LIMIT_EXCEEDED="+String.valueOf(UNACCOUNTED_LIMIT_EXCEEDED));
		sb.append(",OVERRIDE_UNACCOUNTED_CHECKS="+String.valueOf(OVERRIDE_UNACCOUNTED_CHECKS));
		sb.append(",PENDING_PRINT_COUNT="+String.valueOf(PENDING_PRINT_COUNT));
		sb.append(",PENDING_REQUEST_COUNT="+String.valueOf(PENDING_REQUEST_COUNT));
		sb.append(",PDXR_RACK_DRIVER_ID="+PDXR_RACK_DRIVER_ID);
		sb.append(",PDXR_TERMINAL_CONTROL_NUMBER="+PDXR_TERMINAL_CONTROL_NUMBER);
		sb.append(",PDXR_FINAL_SHIPPER_XCTN_SEQ="+String.valueOf(PDXR_FINAL_SHIPPER_XCTN_SEQ));
		sb.append(",PDXR_DESTINATION_STATE_CODE="+PDXR_DESTINATION_STATE_CODE);
		sb.append(",PDXR_DESTINATION_COUNTY="+PDXR_DESTINATION_COUNTY);
		sb.append(",PDXR_DESTINATION_CITY="+PDXR_DESTINATION_CITY);
		sb.append(",PDXR_DESTINATION_ZIP_CODE="+PDXR_DESTINATION_ZIP_CODE);
		sb.append(",PDXR_CARRIER_FEIN="+PDXR_CARRIER_FEIN);
		sb.append(",PDXR_SHIPPER_INFO="+PDXR_SHIPPER_INFO);
		sb.append(",PDXR_VERSION="+String.valueOf(PDXR_VERSION));
		sb.append(",PDXR_VENDOR="+String.valueOf(PDXR_VENDOR));
		sb.append(",ORIG_ORDER_ID="+String.valueOf(ORIG_ORDER_ID));
		sb.append(",PREV_ORDER_ID="+String.valueOf(PREV_ORDER_ID));
		sb.append(",SIGNATURE_PATH="+SIGNATURE_PATH);
		sb.append(",SIGNATURE_FILE_NAME="+SIGNATURE_FILE_NAME);
		sb.append(",PDXR_AUTHORIZING_SYSTEM="+PDXR_AUTHORIZING_SYSTEM);
		sb.append(",START_TIMESLOT_DATETIME="+String.valueOf(START_TIMESLOT_DATETIME));
		sb.append(",END_TIMESLOT_DATETIME="+String.valueOf(END_TIMESLOT_DATETIME));
		sb.append(",START_PICKUP_DATETIME="+String.valueOf(START_PICKUP_DATETIME));
		sb.append(",END_PICKUP_DATETIME="+String.valueOf(END_PICKUP_DATETIME));
		sb.append(",ADMINISTRATIVE_BOOKING="+String.valueOf(ADMINISTRATIVE_BOOKING));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row2Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class row1Struct implements routines.system.IPersistableRow<row1Struct> {
    final static byte[] commonByteArrayLock_PGS_STAGE_DIM_ORDERS = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_DIM_ORDERS = new byte[0];

	
			    public int ORDER_ID;

				public int getORDER_ID () {
					return this.ORDER_ID;
				}
				
			    public Integer LOADED_DRIVER_NUMBER;

				public Integer getLOADED_DRIVER_NUMBER () {
					return this.LOADED_DRIVER_NUMBER;
				}
				
			    public String USER_NAME;

				public String getUSER_NAME () {
					return this.USER_NAME;
				}
				
			    public Integer TRAILER_CARRIER_NUMBER;

				public Integer getTRAILER_CARRIER_NUMBER () {
					return this.TRAILER_CARRIER_NUMBER;
				}
				
			    public int CARRIER_NUMBER;

				public int getCARRIER_NUMBER () {
					return this.CARRIER_NUMBER;
				}
				
			    public String TRAILER_CODE;

				public String getTRAILER_CODE () {
					return this.TRAILER_CODE;
				}
				
			    public Integer VEHICLE_CARRIER_NUMBER;

				public Integer getVEHICLE_CARRIER_NUMBER () {
					return this.VEHICLE_CARRIER_NUMBER;
				}
				
			    public String VEHICLE_CODE;

				public String getVEHICLE_CODE () {
					return this.VEHICLE_CODE;
				}
				
			    public Integer TRACTOR_CARRIER_NUMBER;

				public Integer getTRACTOR_CARRIER_NUMBER () {
					return this.TRACTOR_CARRIER_NUMBER;
				}
				
			    public Integer LOADED_CARRIER_NUMBER;

				public Integer getLOADED_CARRIER_NUMBER () {
					return this.LOADED_CARRIER_NUMBER;
				}
				
			    public String FOLIO_NUMBER;

				public String getFOLIO_NUMBER () {
					return this.FOLIO_NUMBER;
				}
				
			    public Integer TRACTOR_NUMBER;

				public Integer getTRACTOR_NUMBER () {
					return this.TRACTOR_NUMBER;
				}
				
			    public Integer DELIVERED_CARRIER_NUMBER;

				public Integer getDELIVERED_CARRIER_NUMBER () {
					return this.DELIVERED_CARRIER_NUMBER;
				}
				
			    public Integer DISPATCH_CARRIER_NUMBER;

				public Integer getDISPATCH_CARRIER_NUMBER () {
					return this.DISPATCH_CARRIER_NUMBER;
				}
				
			    public Integer DELIVERED_DRIVER_NUMBER;

				public Integer getDELIVERED_DRIVER_NUMBER () {
					return this.DELIVERED_DRIVER_NUMBER;
				}
				
			    public int SUPPLIER_NUMBER;

				public int getSUPPLIER_NUMBER () {
					return this.SUPPLIER_NUMBER;
				}
				
			    public int CUSTOMER_NUMBER;

				public int getCUSTOMER_NUMBER () {
					return this.CUSTOMER_NUMBER;
				}
				
			    public String TABS_CARRIER_ID;

				public String getTABS_CARRIER_ID () {
					return this.TABS_CARRIER_ID;
				}
				
			    public int DESTINATION_NUMBER;

				public int getDESTINATION_NUMBER () {
					return this.DESTINATION_NUMBER;
				}
				
			    public Integer TRIP_ID;

				public Integer getTRIP_ID () {
					return this.TRIP_ID;
				}
				
			    public String TABS_TRUCK_NUMBER;

				public String getTABS_TRUCK_NUMBER () {
					return this.TABS_TRUCK_NUMBER;
				}
				
			    public int TYPE;

				public int getTYPE () {
					return this.TYPE;
				}
				
			    public String SHOST_SU_SUPPLIER_NUMBER;

				public String getSHOST_SU_SUPPLIER_NUMBER () {
					return this.SHOST_SU_SUPPLIER_NUMBER;
				}
				
			    public int CREATOR;

				public int getCREATOR () {
					return this.CREATOR;
				}
				
			    public int EXCHANGE_ALLOCATION_ENABLED;

				public int getEXCHANGE_ALLOCATION_ENABLED () {
					return this.EXCHANGE_ALLOCATION_ENABLED;
				}
				
			    public int MANUALLY_ENTERED;

				public int getMANUALLY_ENTERED () {
					return this.MANUALLY_ENTERED;
				}
				
			    public String SHOST_EX_EHOST_THRU_NUMBER;

				public String getSHOST_EX_EHOST_THRU_NUMBER () {
					return this.SHOST_EX_EHOST_THRU_NUMBER;
				}
				
			    public int DEST_ALLOCATION_ENABLED;

				public int getDEST_ALLOCATION_ENABLED () {
					return this.DEST_ALLOCATION_ENABLED;
				}
				
			    public String THOST_TH_SUPPLIER_NUMBER;

				public String getTHOST_TH_SUPPLIER_NUMBER () {
					return this.THOST_TH_SUPPLIER_NUMBER;
				}
				
			    public int CUST_ALLOC_BY_PRODUCT;

				public int getCUST_ALLOC_BY_PRODUCT () {
					return this.CUST_ALLOC_BY_PRODUCT;
				}
				
			    public int CUST_ALLOC_BY_COMPONENT;

				public int getCUST_ALLOC_BY_COMPONENT () {
					return this.CUST_ALLOC_BY_COMPONENT;
				}
				
			    public int CUST_ALLOC_BY_COMP_GROUP;

				public int getCUST_ALLOC_BY_COMP_GROUP () {
					return this.CUST_ALLOC_BY_COMP_GROUP;
				}
				
			    public int CREDIT_ENABLED;

				public int getCREDIT_ENABLED () {
					return this.CREDIT_ENABLED;
				}
				
			    public String THOST_EX_THOST_EXCH_NUMBER;

				public String getTHOST_EX_THOST_EXCH_NUMBER () {
					return this.THOST_EX_THOST_EXCH_NUMBER;
				}
				
			    public int BILLING_TYPE;

				public int getBILLING_TYPE () {
					return this.BILLING_TYPE;
				}
				
			    public int EXCH_ALLOC_BY_PRODUCT;

				public int getEXCH_ALLOC_BY_PRODUCT () {
					return this.EXCH_ALLOC_BY_PRODUCT;
				}
				
			    public int EXCH_ALLOC_BY_PRODUCT_GROUP;

				public int getEXCH_ALLOC_BY_PRODUCT_GROUP () {
					return this.EXCH_ALLOC_BY_PRODUCT_GROUP;
				}
				
			    public int CUSTOMER_ALLOCATION_ENABLED;

				public int getCUSTOMER_ALLOCATION_ENABLED () {
					return this.CUSTOMER_ALLOCATION_ENABLED;
				}
				
			    public String TABS_FINAL_SHIPPER_ID;

				public String getTABS_FINAL_SHIPPER_ID () {
					return this.TABS_FINAL_SHIPPER_ID;
				}
				
			    public int CUST_ALLOC_BY_PRODUCT_GROUP;

				public int getCUST_ALLOC_BY_PRODUCT_GROUP () {
					return this.CUST_ALLOC_BY_PRODUCT_GROUP;
				}
				
			    public int MOVEMENT_NUMBER;

				public int getMOVEMENT_NUMBER () {
					return this.MOVEMENT_NUMBER;
				}
				
			    public int REVISION_NUMBER;

				public int getREVISION_NUMBER () {
					return this.REVISION_NUMBER;
				}
				
			    public String TABS_SELLER_ID;

				public String getTABS_SELLER_ID () {
					return this.TABS_SELLER_ID;
				}
				
			    public int REVISED;

				public int getREVISED () {
					return this.REVISED;
				}
				
			    public String TABS_CONSIGNEE_NUMBER;

				public String getTABS_CONSIGNEE_NUMBER () {
					return this.TABS_CONSIGNEE_NUMBER;
				}
				
			    public int STATUS;

				public int getSTATUS () {
					return this.STATUS;
				}
				
			    public String CHOST_CU_SUPPLIER_NUMBER;

				public String getCHOST_CU_SUPPLIER_NUMBER () {
					return this.CHOST_CU_SUPPLIER_NUMBER;
				}
				
			    public String CHOST_CU_CUSTOMER_NUMBER;

				public String getCHOST_CU_CUSTOMER_NUMBER () {
					return this.CHOST_CU_CUSTOMER_NUMBER;
				}
				
			    public java.util.Date STATUS_DATE;

				public java.util.Date getSTATUS_DATE () {
					return this.STATUS_DATE;
				}
				
			    public String PURCHASE_ORDER_NUMBER;

				public String getPURCHASE_ORDER_NUMBER () {
					return this.PURCHASE_ORDER_NUMBER;
				}
				
			    public String REQUISITION_NUMBER;

				public String getREQUISITION_NUMBER () {
					return this.REQUISITION_NUMBER;
				}
				
			    public String BOL_COMMENT_1;

				public String getBOL_COMMENT_1 () {
					return this.BOL_COMMENT_1;
				}
				
			    public String BOL_COMMENT_2;

				public String getBOL_COMMENT_2 () {
					return this.BOL_COMMENT_2;
				}
				
			    public int INVOICE_REQUIRED;

				public int getINVOICE_REQUIRED () {
					return this.INVOICE_REQUIRED;
				}
				
			    public String INVOICE_COMMENT_1;

				public String getINVOICE_COMMENT_1 () {
					return this.INVOICE_COMMENT_1;
				}
				
			    public String INVOICE_COMMENT_2;

				public String getINVOICE_COMMENT_2 () {
					return this.INVOICE_COMMENT_2;
				}
				
			    public int INVOICE_PRINTED;

				public int getINVOICE_PRINTED () {
					return this.INVOICE_PRINTED;
				}
				
			    public String DESTINATION_COMMENT_1;

				public String getDESTINATION_COMMENT_1 () {
					return this.DESTINATION_COMMENT_1;
				}
				
			    public String DESTINATION_COMMENT_2;

				public String getDESTINATION_COMMENT_2 () {
					return this.DESTINATION_COMMENT_2;
				}
				
			    public int TABS_SUBSCRIBER;

				public int getTABS_SUBSCRIBER () {
					return this.TABS_SUBSCRIBER;
				}
				
			    public String REMARKS;

				public String getREMARKS () {
					return this.REMARKS;
				}
				
			    public java.util.Date START_LOAD_TIME;

				public java.util.Date getSTART_LOAD_TIME () {
					return this.START_LOAD_TIME;
				}
				
			    public java.util.Date END_LOAD_TIME;

				public java.util.Date getEND_LOAD_TIME () {
					return this.END_LOAD_TIME;
				}
				
			    public double DELIVERY_FEE;

				public double getDELIVERY_FEE () {
					return this.DELIVERY_FEE;
				}
				
			    public String TABS_AUTHORIZATION_NUMBER;

				public String getTABS_AUTHORIZATION_NUMBER () {
					return this.TABS_AUTHORIZATION_NUMBER;
				}
				
			    public Integer THRUPUTTER_NUMBER;

				public Integer getTHRUPUTTER_NUMBER () {
					return this.THRUPUTTER_NUMBER;
				}
				
			    public String LAST_USER_NAME;

				public String getLAST_USER_NAME () {
					return this.LAST_USER_NAME;
				}
				
			    public java.util.Date LAST_MODIFIED;

				public java.util.Date getLAST_MODIFIED () {
					return this.LAST_MODIFIED;
				}
				
			    public int BOL_PRINTED;

				public int getBOL_PRINTED () {
					return this.BOL_PRINTED;
				}
				
			    public java.util.Date ORDER_ENTRY_TIME;

				public java.util.Date getORDER_ENTRY_TIME () {
					return this.ORDER_ENTRY_TIME;
				}
				
			    public int BILL_FREIGHT;

				public int getBILL_FREIGHT () {
					return this.BILL_FREIGHT;
				}
				
			    public java.util.Date DELIVERY_DATE;

				public java.util.Date getDELIVERY_DATE () {
					return this.DELIVERY_DATE;
				}
				
			    public int SHIFT;

				public int getSHIFT () {
					return this.SHIFT;
				}
				
			    public int STOP;

				public int getSTOP () {
					return this.STOP;
				}
				
			    public int DELIVERY_CONFIRMED;

				public int getDELIVERY_CONFIRMED () {
					return this.DELIVERY_CONFIRMED;
				}
				
			    public String VALIDATING_NODE_NAME;

				public String getVALIDATING_NODE_NAME () {
					return this.VALIDATING_NODE_NAME;
				}
				
			    public int HOST_PROCESSED;

				public int getHOST_PROCESSED () {
					return this.HOST_PROCESSED;
				}
				
			    public String PETROEX_COMPANY_CODE;

				public String getPETROEX_COMPANY_CODE () {
					return this.PETROEX_COMPANY_CODE;
				}
				
			    public String PETROEX_CONSIGNEE_NUMBER;

				public String getPETROEX_CONSIGNEE_NUMBER () {
					return this.PETROEX_CONSIGNEE_NUMBER;
				}
				
			    public String PETROEX_THIRD_PARTY;

				public String getPETROEX_THIRD_PARTY () {
					return this.PETROEX_THIRD_PARTY;
				}
				
			    public String PETROEX_CARRIER_CODE;

				public String getPETROEX_CARRIER_CODE () {
					return this.PETROEX_CARRIER_CODE;
				}
				
			    public int PETROEX_TRUCK_NUMBER;

				public int getPETROEX_TRUCK_NUMBER () {
					return this.PETROEX_TRUCK_NUMBER;
				}
				
			    public int PETROEX_SUBSCRIBER;

				public int getPETROEX_SUBSCRIBER () {
					return this.PETROEX_SUBSCRIBER;
				}
				
			    public String FAN_COMMENT_1;

				public String getFAN_COMMENT_1 () {
					return this.FAN_COMMENT_1;
				}
				
			    public int PETROEX_CITY_CODE;

				public int getPETROEX_CITY_CODE () {
					return this.PETROEX_CITY_CODE;
				}
				
			    public String FAN_COMMENT_2;

				public String getFAN_COMMENT_2 () {
					return this.FAN_COMMENT_2;
				}
				
			    public int PETROEX_COUNTY_CODE;

				public int getPETROEX_COUNTY_CODE () {
					return this.PETROEX_COUNTY_CODE;
				}
				
			    public int PRELOAD_ORDER;

				public int getPRELOAD_ORDER () {
					return this.PRELOAD_ORDER;
				}
				
			    public int PETROEX_STATE_CODE;

				public int getPETROEX_STATE_CODE () {
					return this.PETROEX_STATE_CODE;
				}
				
			    public int CONTRACT_ALLOCATION_ENABLED;

				public int getCONTRACT_ALLOCATION_ENABLED () {
					return this.CONTRACT_ALLOCATION_ENABLED;
				}
				
			    public String PETROEX_FEIN;

				public String getPETROEX_FEIN () {
					return this.PETROEX_FEIN;
				}
				
			    public int ELVIS_ORDER_NUMBER;

				public int getELVIS_ORDER_NUMBER () {
					return this.ELVIS_ORDER_NUMBER;
				}
				
			    public String PETROEX_SHIPPER_INFO;

				public String getPETROEX_SHIPPER_INFO () {
					return this.PETROEX_SHIPPER_INFO;
				}
				
			    public String ELVIS_LOADSPOT_ID;

				public String getELVIS_LOADSPOT_ID () {
					return this.ELVIS_LOADSPOT_ID;
				}
				
			    public String PETROEX_VEHICLE_TYPE;

				public String getPETROEX_VEHICLE_TYPE () {
					return this.PETROEX_VEHICLE_TYPE;
				}
				
			    public int OVERWEIGHT_TRAILER;

				public int getOVERWEIGHT_TRAILER () {
					return this.OVERWEIGHT_TRAILER;
				}
				
			    public int ELVIS_AUTHORIZED;

				public int getELVIS_AUTHORIZED () {
					return this.ELVIS_AUTHORIZED;
				}
				
			    public int DISPATCHED_WITH_TRAILER;

				public int getDISPATCHED_WITH_TRAILER () {
					return this.DISPATCHED_WITH_TRAILER;
				}
				
			    public int DISPATCHED_WITH_DRIVER;

				public int getDISPATCHED_WITH_DRIVER () {
					return this.DISPATCHED_WITH_DRIVER;
				}
				
			    public double COMMITTED_PRICE;

				public double getCOMMITTED_PRICE () {
					return this.COMMITTED_PRICE;
				}
				
			    public double LOADED_PRICE;

				public double getLOADED_PRICE () {
					return this.LOADED_PRICE;
				}
				
			    public String CONTRACT_NUMBER;

				public String getCONTRACT_NUMBER () {
					return this.CONTRACT_NUMBER;
				}
				
			    public int MANUALLY_COMPLETED;

				public int getMANUALLY_COMPLETED () {
					return this.MANUALLY_COMPLETED;
				}
				
			    public int OVERRIDE_TOLERANCE_CHECKS;

				public int getOVERRIDE_TOLERANCE_CHECKS () {
					return this.OVERRIDE_TOLERANCE_CHECKS;
				}
				
			    public int AIC_STATUS;

				public int getAIC_STATUS () {
					return this.AIC_STATUS;
				}
				
			    public int BLEND_TOLERANCE_STATUS;

				public int getBLEND_TOLERANCE_STATUS () {
					return this.BLEND_TOLERANCE_STATUS;
				}
				
			    public int ADDITIVE_TOLERANCE_STATUS;

				public int getADDITIVE_TOLERANCE_STATUS () {
					return this.ADDITIVE_TOLERANCE_STATUS;
				}
				
			    public int AUTHORIZATION_REQUEST_ID;

				public int getAUTHORIZATION_REQUEST_ID () {
					return this.AUTHORIZATION_REQUEST_ID;
				}
				
			    public int TABS_ORDER_NUMBER;

				public int getTABS_ORDER_NUMBER () {
					return this.TABS_ORDER_NUMBER;
				}
				
			    public int FLAG_VALID_PRICE;

				public int getFLAG_VALID_PRICE () {
					return this.FLAG_VALID_PRICE;
				}
				
			    public int BOL_NUMBER;

				public int getBOL_NUMBER () {
					return this.BOL_NUMBER;
				}
				
			    public int COMPATIBILITY_STATUS;

				public int getCOMPATIBILITY_STATUS () {
					return this.COMPATIBILITY_STATUS;
				}
				
			    public int OVERRIDE_COMPATIBILITY_CHECKS;

				public int getOVERRIDE_COMPATIBILITY_CHECKS () {
					return this.OVERRIDE_COMPATIBILITY_CHECKS;
				}
				
			    public int CANCELLED_FROM_CBS;

				public int getCANCELLED_FROM_CBS () {
					return this.CANCELLED_FROM_CBS;
				}
				
			    public String HOST_REF_ID;

				public String getHOST_REF_ID () {
					return this.HOST_REF_ID;
				}
				
			    public int UNACCOUNTED_LIMIT_EXCEEDED;

				public int getUNACCOUNTED_LIMIT_EXCEEDED () {
					return this.UNACCOUNTED_LIMIT_EXCEEDED;
				}
				
			    public int OVERRIDE_UNACCOUNTED_CHECKS;

				public int getOVERRIDE_UNACCOUNTED_CHECKS () {
					return this.OVERRIDE_UNACCOUNTED_CHECKS;
				}
				
			    public int PENDING_PRINT_COUNT;

				public int getPENDING_PRINT_COUNT () {
					return this.PENDING_PRINT_COUNT;
				}
				
			    public int PENDING_REQUEST_COUNT;

				public int getPENDING_REQUEST_COUNT () {
					return this.PENDING_REQUEST_COUNT;
				}
				
			    public String PDXR_RACK_DRIVER_ID;

				public String getPDXR_RACK_DRIVER_ID () {
					return this.PDXR_RACK_DRIVER_ID;
				}
				
			    public String PDXR_TERMINAL_CONTROL_NUMBER;

				public String getPDXR_TERMINAL_CONTROL_NUMBER () {
					return this.PDXR_TERMINAL_CONTROL_NUMBER;
				}
				
			    public int PDXR_FINAL_SHIPPER_XCTN_SEQ;

				public int getPDXR_FINAL_SHIPPER_XCTN_SEQ () {
					return this.PDXR_FINAL_SHIPPER_XCTN_SEQ;
				}
				
			    public String PDXR_DESTINATION_STATE_CODE;

				public String getPDXR_DESTINATION_STATE_CODE () {
					return this.PDXR_DESTINATION_STATE_CODE;
				}
				
			    public String PDXR_DESTINATION_COUNTY;

				public String getPDXR_DESTINATION_COUNTY () {
					return this.PDXR_DESTINATION_COUNTY;
				}
				
			    public String PDXR_DESTINATION_CITY;

				public String getPDXR_DESTINATION_CITY () {
					return this.PDXR_DESTINATION_CITY;
				}
				
			    public String PDXR_DESTINATION_ZIP_CODE;

				public String getPDXR_DESTINATION_ZIP_CODE () {
					return this.PDXR_DESTINATION_ZIP_CODE;
				}
				
			    public String PDXR_CARRIER_FEIN;

				public String getPDXR_CARRIER_FEIN () {
					return this.PDXR_CARRIER_FEIN;
				}
				
			    public String PDXR_SHIPPER_INFO;

				public String getPDXR_SHIPPER_INFO () {
					return this.PDXR_SHIPPER_INFO;
				}
				
			    public int PDXR_VERSION;

				public int getPDXR_VERSION () {
					return this.PDXR_VERSION;
				}
				
			    public int PDXR_VENDOR;

				public int getPDXR_VENDOR () {
					return this.PDXR_VENDOR;
				}
				
			    public Integer ORIG_ORDER_ID;

				public Integer getORIG_ORDER_ID () {
					return this.ORIG_ORDER_ID;
				}
				
			    public Integer PREV_ORDER_ID;

				public Integer getPREV_ORDER_ID () {
					return this.PREV_ORDER_ID;
				}
				
			    public String SIGNATURE_PATH;

				public String getSIGNATURE_PATH () {
					return this.SIGNATURE_PATH;
				}
				
			    public String SIGNATURE_FILE_NAME;

				public String getSIGNATURE_FILE_NAME () {
					return this.SIGNATURE_FILE_NAME;
				}
				
			    public String PDXR_AUTHORIZING_SYSTEM;

				public String getPDXR_AUTHORIZING_SYSTEM () {
					return this.PDXR_AUTHORIZING_SYSTEM;
				}
				
			    public java.util.Date START_TIMESLOT_DATETIME;

				public java.util.Date getSTART_TIMESLOT_DATETIME () {
					return this.START_TIMESLOT_DATETIME;
				}
				
			    public java.util.Date END_TIMESLOT_DATETIME;

				public java.util.Date getEND_TIMESLOT_DATETIME () {
					return this.END_TIMESLOT_DATETIME;
				}
				
			    public java.util.Date START_PICKUP_DATETIME;

				public java.util.Date getSTART_PICKUP_DATETIME () {
					return this.START_PICKUP_DATETIME;
				}
				
			    public java.util.Date END_PICKUP_DATETIME;

				public java.util.Date getEND_PICKUP_DATETIME () {
					return this.END_PICKUP_DATETIME;
				}
				
			    public int ADMINISTRATIVE_BOOKING;

				public int getADMINISTRATIVE_BOOKING () {
					return this.ADMINISTRATIVE_BOOKING;
				}
				


	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PGS_STAGE_DIM_ORDERS.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_ORDERS.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_ORDERS = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_ORDERS = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PGS_STAGE_DIM_ORDERS, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_ORDERS, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PGS_STAGE_DIM_ORDERS.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_ORDERS.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_ORDERS = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_ORDERS = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PGS_STAGE_DIM_ORDERS, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_ORDERS, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_ORDERS) {

        	try {

        		int length = 0;
		
			        this.ORDER_ID = dis.readInt();
					
						this.LOADED_DRIVER_NUMBER = readInteger(dis);
					
					this.USER_NAME = readString(dis);
					
						this.TRAILER_CARRIER_NUMBER = readInteger(dis);
					
			        this.CARRIER_NUMBER = dis.readInt();
					
					this.TRAILER_CODE = readString(dis);
					
						this.VEHICLE_CARRIER_NUMBER = readInteger(dis);
					
					this.VEHICLE_CODE = readString(dis);
					
						this.TRACTOR_CARRIER_NUMBER = readInteger(dis);
					
						this.LOADED_CARRIER_NUMBER = readInteger(dis);
					
					this.FOLIO_NUMBER = readString(dis);
					
						this.TRACTOR_NUMBER = readInteger(dis);
					
						this.DELIVERED_CARRIER_NUMBER = readInteger(dis);
					
						this.DISPATCH_CARRIER_NUMBER = readInteger(dis);
					
						this.DELIVERED_DRIVER_NUMBER = readInteger(dis);
					
			        this.SUPPLIER_NUMBER = dis.readInt();
					
			        this.CUSTOMER_NUMBER = dis.readInt();
					
					this.TABS_CARRIER_ID = readString(dis);
					
			        this.DESTINATION_NUMBER = dis.readInt();
					
						this.TRIP_ID = readInteger(dis);
					
					this.TABS_TRUCK_NUMBER = readString(dis);
					
			        this.TYPE = dis.readInt();
					
					this.SHOST_SU_SUPPLIER_NUMBER = readString(dis);
					
			        this.CREATOR = dis.readInt();
					
			        this.EXCHANGE_ALLOCATION_ENABLED = dis.readInt();
					
			        this.MANUALLY_ENTERED = dis.readInt();
					
					this.SHOST_EX_EHOST_THRU_NUMBER = readString(dis);
					
			        this.DEST_ALLOCATION_ENABLED = dis.readInt();
					
					this.THOST_TH_SUPPLIER_NUMBER = readString(dis);
					
			        this.CUST_ALLOC_BY_PRODUCT = dis.readInt();
					
			        this.CUST_ALLOC_BY_COMPONENT = dis.readInt();
					
			        this.CUST_ALLOC_BY_COMP_GROUP = dis.readInt();
					
			        this.CREDIT_ENABLED = dis.readInt();
					
					this.THOST_EX_THOST_EXCH_NUMBER = readString(dis);
					
			        this.BILLING_TYPE = dis.readInt();
					
			        this.EXCH_ALLOC_BY_PRODUCT = dis.readInt();
					
			        this.EXCH_ALLOC_BY_PRODUCT_GROUP = dis.readInt();
					
			        this.CUSTOMER_ALLOCATION_ENABLED = dis.readInt();
					
					this.TABS_FINAL_SHIPPER_ID = readString(dis);
					
			        this.CUST_ALLOC_BY_PRODUCT_GROUP = dis.readInt();
					
			        this.MOVEMENT_NUMBER = dis.readInt();
					
			        this.REVISION_NUMBER = dis.readInt();
					
					this.TABS_SELLER_ID = readString(dis);
					
			        this.REVISED = dis.readInt();
					
					this.TABS_CONSIGNEE_NUMBER = readString(dis);
					
			        this.STATUS = dis.readInt();
					
					this.CHOST_CU_SUPPLIER_NUMBER = readString(dis);
					
					this.CHOST_CU_CUSTOMER_NUMBER = readString(dis);
					
					this.STATUS_DATE = readDate(dis);
					
					this.PURCHASE_ORDER_NUMBER = readString(dis);
					
					this.REQUISITION_NUMBER = readString(dis);
					
					this.BOL_COMMENT_1 = readString(dis);
					
					this.BOL_COMMENT_2 = readString(dis);
					
			        this.INVOICE_REQUIRED = dis.readInt();
					
					this.INVOICE_COMMENT_1 = readString(dis);
					
					this.INVOICE_COMMENT_2 = readString(dis);
					
			        this.INVOICE_PRINTED = dis.readInt();
					
					this.DESTINATION_COMMENT_1 = readString(dis);
					
					this.DESTINATION_COMMENT_2 = readString(dis);
					
			        this.TABS_SUBSCRIBER = dis.readInt();
					
					this.REMARKS = readString(dis);
					
					this.START_LOAD_TIME = readDate(dis);
					
					this.END_LOAD_TIME = readDate(dis);
					
			        this.DELIVERY_FEE = dis.readDouble();
					
					this.TABS_AUTHORIZATION_NUMBER = readString(dis);
					
						this.THRUPUTTER_NUMBER = readInteger(dis);
					
					this.LAST_USER_NAME = readString(dis);
					
					this.LAST_MODIFIED = readDate(dis);
					
			        this.BOL_PRINTED = dis.readInt();
					
					this.ORDER_ENTRY_TIME = readDate(dis);
					
			        this.BILL_FREIGHT = dis.readInt();
					
					this.DELIVERY_DATE = readDate(dis);
					
			        this.SHIFT = dis.readInt();
					
			        this.STOP = dis.readInt();
					
			        this.DELIVERY_CONFIRMED = dis.readInt();
					
					this.VALIDATING_NODE_NAME = readString(dis);
					
			        this.HOST_PROCESSED = dis.readInt();
					
					this.PETROEX_COMPANY_CODE = readString(dis);
					
					this.PETROEX_CONSIGNEE_NUMBER = readString(dis);
					
					this.PETROEX_THIRD_PARTY = readString(dis);
					
					this.PETROEX_CARRIER_CODE = readString(dis);
					
			        this.PETROEX_TRUCK_NUMBER = dis.readInt();
					
			        this.PETROEX_SUBSCRIBER = dis.readInt();
					
					this.FAN_COMMENT_1 = readString(dis);
					
			        this.PETROEX_CITY_CODE = dis.readInt();
					
					this.FAN_COMMENT_2 = readString(dis);
					
			        this.PETROEX_COUNTY_CODE = dis.readInt();
					
			        this.PRELOAD_ORDER = dis.readInt();
					
			        this.PETROEX_STATE_CODE = dis.readInt();
					
			        this.CONTRACT_ALLOCATION_ENABLED = dis.readInt();
					
					this.PETROEX_FEIN = readString(dis);
					
			        this.ELVIS_ORDER_NUMBER = dis.readInt();
					
					this.PETROEX_SHIPPER_INFO = readString(dis);
					
					this.ELVIS_LOADSPOT_ID = readString(dis);
					
					this.PETROEX_VEHICLE_TYPE = readString(dis);
					
			        this.OVERWEIGHT_TRAILER = dis.readInt();
					
			        this.ELVIS_AUTHORIZED = dis.readInt();
					
			        this.DISPATCHED_WITH_TRAILER = dis.readInt();
					
			        this.DISPATCHED_WITH_DRIVER = dis.readInt();
					
			        this.COMMITTED_PRICE = dis.readDouble();
					
			        this.LOADED_PRICE = dis.readDouble();
					
					this.CONTRACT_NUMBER = readString(dis);
					
			        this.MANUALLY_COMPLETED = dis.readInt();
					
			        this.OVERRIDE_TOLERANCE_CHECKS = dis.readInt();
					
			        this.AIC_STATUS = dis.readInt();
					
			        this.BLEND_TOLERANCE_STATUS = dis.readInt();
					
			        this.ADDITIVE_TOLERANCE_STATUS = dis.readInt();
					
			        this.AUTHORIZATION_REQUEST_ID = dis.readInt();
					
			        this.TABS_ORDER_NUMBER = dis.readInt();
					
			        this.FLAG_VALID_PRICE = dis.readInt();
					
			        this.BOL_NUMBER = dis.readInt();
					
			        this.COMPATIBILITY_STATUS = dis.readInt();
					
			        this.OVERRIDE_COMPATIBILITY_CHECKS = dis.readInt();
					
			        this.CANCELLED_FROM_CBS = dis.readInt();
					
					this.HOST_REF_ID = readString(dis);
					
			        this.UNACCOUNTED_LIMIT_EXCEEDED = dis.readInt();
					
			        this.OVERRIDE_UNACCOUNTED_CHECKS = dis.readInt();
					
			        this.PENDING_PRINT_COUNT = dis.readInt();
					
			        this.PENDING_REQUEST_COUNT = dis.readInt();
					
					this.PDXR_RACK_DRIVER_ID = readString(dis);
					
					this.PDXR_TERMINAL_CONTROL_NUMBER = readString(dis);
					
			        this.PDXR_FINAL_SHIPPER_XCTN_SEQ = dis.readInt();
					
					this.PDXR_DESTINATION_STATE_CODE = readString(dis);
					
					this.PDXR_DESTINATION_COUNTY = readString(dis);
					
					this.PDXR_DESTINATION_CITY = readString(dis);
					
					this.PDXR_DESTINATION_ZIP_CODE = readString(dis);
					
					this.PDXR_CARRIER_FEIN = readString(dis);
					
					this.PDXR_SHIPPER_INFO = readString(dis);
					
			        this.PDXR_VERSION = dis.readInt();
					
			        this.PDXR_VENDOR = dis.readInt();
					
						this.ORIG_ORDER_ID = readInteger(dis);
					
						this.PREV_ORDER_ID = readInteger(dis);
					
					this.SIGNATURE_PATH = readString(dis);
					
					this.SIGNATURE_FILE_NAME = readString(dis);
					
					this.PDXR_AUTHORIZING_SYSTEM = readString(dis);
					
					this.START_TIMESLOT_DATETIME = readDate(dis);
					
					this.END_TIMESLOT_DATETIME = readDate(dis);
					
					this.START_PICKUP_DATETIME = readDate(dis);
					
					this.END_PICKUP_DATETIME = readDate(dis);
					
			        this.ADMINISTRATIVE_BOOKING = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_ORDERS) {

        	try {

        		int length = 0;
		
			        this.ORDER_ID = dis.readInt();
					
						this.LOADED_DRIVER_NUMBER = readInteger(dis);
					
					this.USER_NAME = readString(dis);
					
						this.TRAILER_CARRIER_NUMBER = readInteger(dis);
					
			        this.CARRIER_NUMBER = dis.readInt();
					
					this.TRAILER_CODE = readString(dis);
					
						this.VEHICLE_CARRIER_NUMBER = readInteger(dis);
					
					this.VEHICLE_CODE = readString(dis);
					
						this.TRACTOR_CARRIER_NUMBER = readInteger(dis);
					
						this.LOADED_CARRIER_NUMBER = readInteger(dis);
					
					this.FOLIO_NUMBER = readString(dis);
					
						this.TRACTOR_NUMBER = readInteger(dis);
					
						this.DELIVERED_CARRIER_NUMBER = readInteger(dis);
					
						this.DISPATCH_CARRIER_NUMBER = readInteger(dis);
					
						this.DELIVERED_DRIVER_NUMBER = readInteger(dis);
					
			        this.SUPPLIER_NUMBER = dis.readInt();
					
			        this.CUSTOMER_NUMBER = dis.readInt();
					
					this.TABS_CARRIER_ID = readString(dis);
					
			        this.DESTINATION_NUMBER = dis.readInt();
					
						this.TRIP_ID = readInteger(dis);
					
					this.TABS_TRUCK_NUMBER = readString(dis);
					
			        this.TYPE = dis.readInt();
					
					this.SHOST_SU_SUPPLIER_NUMBER = readString(dis);
					
			        this.CREATOR = dis.readInt();
					
			        this.EXCHANGE_ALLOCATION_ENABLED = dis.readInt();
					
			        this.MANUALLY_ENTERED = dis.readInt();
					
					this.SHOST_EX_EHOST_THRU_NUMBER = readString(dis);
					
			        this.DEST_ALLOCATION_ENABLED = dis.readInt();
					
					this.THOST_TH_SUPPLIER_NUMBER = readString(dis);
					
			        this.CUST_ALLOC_BY_PRODUCT = dis.readInt();
					
			        this.CUST_ALLOC_BY_COMPONENT = dis.readInt();
					
			        this.CUST_ALLOC_BY_COMP_GROUP = dis.readInt();
					
			        this.CREDIT_ENABLED = dis.readInt();
					
					this.THOST_EX_THOST_EXCH_NUMBER = readString(dis);
					
			        this.BILLING_TYPE = dis.readInt();
					
			        this.EXCH_ALLOC_BY_PRODUCT = dis.readInt();
					
			        this.EXCH_ALLOC_BY_PRODUCT_GROUP = dis.readInt();
					
			        this.CUSTOMER_ALLOCATION_ENABLED = dis.readInt();
					
					this.TABS_FINAL_SHIPPER_ID = readString(dis);
					
			        this.CUST_ALLOC_BY_PRODUCT_GROUP = dis.readInt();
					
			        this.MOVEMENT_NUMBER = dis.readInt();
					
			        this.REVISION_NUMBER = dis.readInt();
					
					this.TABS_SELLER_ID = readString(dis);
					
			        this.REVISED = dis.readInt();
					
					this.TABS_CONSIGNEE_NUMBER = readString(dis);
					
			        this.STATUS = dis.readInt();
					
					this.CHOST_CU_SUPPLIER_NUMBER = readString(dis);
					
					this.CHOST_CU_CUSTOMER_NUMBER = readString(dis);
					
					this.STATUS_DATE = readDate(dis);
					
					this.PURCHASE_ORDER_NUMBER = readString(dis);
					
					this.REQUISITION_NUMBER = readString(dis);
					
					this.BOL_COMMENT_1 = readString(dis);
					
					this.BOL_COMMENT_2 = readString(dis);
					
			        this.INVOICE_REQUIRED = dis.readInt();
					
					this.INVOICE_COMMENT_1 = readString(dis);
					
					this.INVOICE_COMMENT_2 = readString(dis);
					
			        this.INVOICE_PRINTED = dis.readInt();
					
					this.DESTINATION_COMMENT_1 = readString(dis);
					
					this.DESTINATION_COMMENT_2 = readString(dis);
					
			        this.TABS_SUBSCRIBER = dis.readInt();
					
					this.REMARKS = readString(dis);
					
					this.START_LOAD_TIME = readDate(dis);
					
					this.END_LOAD_TIME = readDate(dis);
					
			        this.DELIVERY_FEE = dis.readDouble();
					
					this.TABS_AUTHORIZATION_NUMBER = readString(dis);
					
						this.THRUPUTTER_NUMBER = readInteger(dis);
					
					this.LAST_USER_NAME = readString(dis);
					
					this.LAST_MODIFIED = readDate(dis);
					
			        this.BOL_PRINTED = dis.readInt();
					
					this.ORDER_ENTRY_TIME = readDate(dis);
					
			        this.BILL_FREIGHT = dis.readInt();
					
					this.DELIVERY_DATE = readDate(dis);
					
			        this.SHIFT = dis.readInt();
					
			        this.STOP = dis.readInt();
					
			        this.DELIVERY_CONFIRMED = dis.readInt();
					
					this.VALIDATING_NODE_NAME = readString(dis);
					
			        this.HOST_PROCESSED = dis.readInt();
					
					this.PETROEX_COMPANY_CODE = readString(dis);
					
					this.PETROEX_CONSIGNEE_NUMBER = readString(dis);
					
					this.PETROEX_THIRD_PARTY = readString(dis);
					
					this.PETROEX_CARRIER_CODE = readString(dis);
					
			        this.PETROEX_TRUCK_NUMBER = dis.readInt();
					
			        this.PETROEX_SUBSCRIBER = dis.readInt();
					
					this.FAN_COMMENT_1 = readString(dis);
					
			        this.PETROEX_CITY_CODE = dis.readInt();
					
					this.FAN_COMMENT_2 = readString(dis);
					
			        this.PETROEX_COUNTY_CODE = dis.readInt();
					
			        this.PRELOAD_ORDER = dis.readInt();
					
			        this.PETROEX_STATE_CODE = dis.readInt();
					
			        this.CONTRACT_ALLOCATION_ENABLED = dis.readInt();
					
					this.PETROEX_FEIN = readString(dis);
					
			        this.ELVIS_ORDER_NUMBER = dis.readInt();
					
					this.PETROEX_SHIPPER_INFO = readString(dis);
					
					this.ELVIS_LOADSPOT_ID = readString(dis);
					
					this.PETROEX_VEHICLE_TYPE = readString(dis);
					
			        this.OVERWEIGHT_TRAILER = dis.readInt();
					
			        this.ELVIS_AUTHORIZED = dis.readInt();
					
			        this.DISPATCHED_WITH_TRAILER = dis.readInt();
					
			        this.DISPATCHED_WITH_DRIVER = dis.readInt();
					
			        this.COMMITTED_PRICE = dis.readDouble();
					
			        this.LOADED_PRICE = dis.readDouble();
					
					this.CONTRACT_NUMBER = readString(dis);
					
			        this.MANUALLY_COMPLETED = dis.readInt();
					
			        this.OVERRIDE_TOLERANCE_CHECKS = dis.readInt();
					
			        this.AIC_STATUS = dis.readInt();
					
			        this.BLEND_TOLERANCE_STATUS = dis.readInt();
					
			        this.ADDITIVE_TOLERANCE_STATUS = dis.readInt();
					
			        this.AUTHORIZATION_REQUEST_ID = dis.readInt();
					
			        this.TABS_ORDER_NUMBER = dis.readInt();
					
			        this.FLAG_VALID_PRICE = dis.readInt();
					
			        this.BOL_NUMBER = dis.readInt();
					
			        this.COMPATIBILITY_STATUS = dis.readInt();
					
			        this.OVERRIDE_COMPATIBILITY_CHECKS = dis.readInt();
					
			        this.CANCELLED_FROM_CBS = dis.readInt();
					
					this.HOST_REF_ID = readString(dis);
					
			        this.UNACCOUNTED_LIMIT_EXCEEDED = dis.readInt();
					
			        this.OVERRIDE_UNACCOUNTED_CHECKS = dis.readInt();
					
			        this.PENDING_PRINT_COUNT = dis.readInt();
					
			        this.PENDING_REQUEST_COUNT = dis.readInt();
					
					this.PDXR_RACK_DRIVER_ID = readString(dis);
					
					this.PDXR_TERMINAL_CONTROL_NUMBER = readString(dis);
					
			        this.PDXR_FINAL_SHIPPER_XCTN_SEQ = dis.readInt();
					
					this.PDXR_DESTINATION_STATE_CODE = readString(dis);
					
					this.PDXR_DESTINATION_COUNTY = readString(dis);
					
					this.PDXR_DESTINATION_CITY = readString(dis);
					
					this.PDXR_DESTINATION_ZIP_CODE = readString(dis);
					
					this.PDXR_CARRIER_FEIN = readString(dis);
					
					this.PDXR_SHIPPER_INFO = readString(dis);
					
			        this.PDXR_VERSION = dis.readInt();
					
			        this.PDXR_VENDOR = dis.readInt();
					
						this.ORIG_ORDER_ID = readInteger(dis);
					
						this.PREV_ORDER_ID = readInteger(dis);
					
					this.SIGNATURE_PATH = readString(dis);
					
					this.SIGNATURE_FILE_NAME = readString(dis);
					
					this.PDXR_AUTHORIZING_SYSTEM = readString(dis);
					
					this.START_TIMESLOT_DATETIME = readDate(dis);
					
					this.END_TIMESLOT_DATETIME = readDate(dis);
					
					this.START_PICKUP_DATETIME = readDate(dis);
					
					this.END_PICKUP_DATETIME = readDate(dis);
					
			        this.ADMINISTRATIVE_BOOKING = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.ORDER_ID);
					
					// Integer
				
						writeInteger(this.LOADED_DRIVER_NUMBER,dos);
					
					// String
				
						writeString(this.USER_NAME,dos);
					
					// Integer
				
						writeInteger(this.TRAILER_CARRIER_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.CARRIER_NUMBER);
					
					// String
				
						writeString(this.TRAILER_CODE,dos);
					
					// Integer
				
						writeInteger(this.VEHICLE_CARRIER_NUMBER,dos);
					
					// String
				
						writeString(this.VEHICLE_CODE,dos);
					
					// Integer
				
						writeInteger(this.TRACTOR_CARRIER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.LOADED_CARRIER_NUMBER,dos);
					
					// String
				
						writeString(this.FOLIO_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.TRACTOR_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.DELIVERED_CARRIER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.DISPATCH_CARRIER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.DELIVERED_DRIVER_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.SUPPLIER_NUMBER);
					
					// int
				
		            	dos.writeInt(this.CUSTOMER_NUMBER);
					
					// String
				
						writeString(this.TABS_CARRIER_ID,dos);
					
					// int
				
		            	dos.writeInt(this.DESTINATION_NUMBER);
					
					// Integer
				
						writeInteger(this.TRIP_ID,dos);
					
					// String
				
						writeString(this.TABS_TRUCK_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.TYPE);
					
					// String
				
						writeString(this.SHOST_SU_SUPPLIER_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.CREATOR);
					
					// int
				
		            	dos.writeInt(this.EXCHANGE_ALLOCATION_ENABLED);
					
					// int
				
		            	dos.writeInt(this.MANUALLY_ENTERED);
					
					// String
				
						writeString(this.SHOST_EX_EHOST_THRU_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.DEST_ALLOCATION_ENABLED);
					
					// String
				
						writeString(this.THOST_TH_SUPPLIER_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.CUST_ALLOC_BY_PRODUCT);
					
					// int
				
		            	dos.writeInt(this.CUST_ALLOC_BY_COMPONENT);
					
					// int
				
		            	dos.writeInt(this.CUST_ALLOC_BY_COMP_GROUP);
					
					// int
				
		            	dos.writeInt(this.CREDIT_ENABLED);
					
					// String
				
						writeString(this.THOST_EX_THOST_EXCH_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.BILLING_TYPE);
					
					// int
				
		            	dos.writeInt(this.EXCH_ALLOC_BY_PRODUCT);
					
					// int
				
		            	dos.writeInt(this.EXCH_ALLOC_BY_PRODUCT_GROUP);
					
					// int
				
		            	dos.writeInt(this.CUSTOMER_ALLOCATION_ENABLED);
					
					// String
				
						writeString(this.TABS_FINAL_SHIPPER_ID,dos);
					
					// int
				
		            	dos.writeInt(this.CUST_ALLOC_BY_PRODUCT_GROUP);
					
					// int
				
		            	dos.writeInt(this.MOVEMENT_NUMBER);
					
					// int
				
		            	dos.writeInt(this.REVISION_NUMBER);
					
					// String
				
						writeString(this.TABS_SELLER_ID,dos);
					
					// int
				
		            	dos.writeInt(this.REVISED);
					
					// String
				
						writeString(this.TABS_CONSIGNEE_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.STATUS);
					
					// String
				
						writeString(this.CHOST_CU_SUPPLIER_NUMBER,dos);
					
					// String
				
						writeString(this.CHOST_CU_CUSTOMER_NUMBER,dos);
					
					// java.util.Date
				
						writeDate(this.STATUS_DATE,dos);
					
					// String
				
						writeString(this.PURCHASE_ORDER_NUMBER,dos);
					
					// String
				
						writeString(this.REQUISITION_NUMBER,dos);
					
					// String
				
						writeString(this.BOL_COMMENT_1,dos);
					
					// String
				
						writeString(this.BOL_COMMENT_2,dos);
					
					// int
				
		            	dos.writeInt(this.INVOICE_REQUIRED);
					
					// String
				
						writeString(this.INVOICE_COMMENT_1,dos);
					
					// String
				
						writeString(this.INVOICE_COMMENT_2,dos);
					
					// int
				
		            	dos.writeInt(this.INVOICE_PRINTED);
					
					// String
				
						writeString(this.DESTINATION_COMMENT_1,dos);
					
					// String
				
						writeString(this.DESTINATION_COMMENT_2,dos);
					
					// int
				
		            	dos.writeInt(this.TABS_SUBSCRIBER);
					
					// String
				
						writeString(this.REMARKS,dos);
					
					// java.util.Date
				
						writeDate(this.START_LOAD_TIME,dos);
					
					// java.util.Date
				
						writeDate(this.END_LOAD_TIME,dos);
					
					// double
				
		            	dos.writeDouble(this.DELIVERY_FEE);
					
					// String
				
						writeString(this.TABS_AUTHORIZATION_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.THRUPUTTER_NUMBER,dos);
					
					// String
				
						writeString(this.LAST_USER_NAME,dos);
					
					// java.util.Date
				
						writeDate(this.LAST_MODIFIED,dos);
					
					// int
				
		            	dos.writeInt(this.BOL_PRINTED);
					
					// java.util.Date
				
						writeDate(this.ORDER_ENTRY_TIME,dos);
					
					// int
				
		            	dos.writeInt(this.BILL_FREIGHT);
					
					// java.util.Date
				
						writeDate(this.DELIVERY_DATE,dos);
					
					// int
				
		            	dos.writeInt(this.SHIFT);
					
					// int
				
		            	dos.writeInt(this.STOP);
					
					// int
				
		            	dos.writeInt(this.DELIVERY_CONFIRMED);
					
					// String
				
						writeString(this.VALIDATING_NODE_NAME,dos);
					
					// int
				
		            	dos.writeInt(this.HOST_PROCESSED);
					
					// String
				
						writeString(this.PETROEX_COMPANY_CODE,dos);
					
					// String
				
						writeString(this.PETROEX_CONSIGNEE_NUMBER,dos);
					
					// String
				
						writeString(this.PETROEX_THIRD_PARTY,dos);
					
					// String
				
						writeString(this.PETROEX_CARRIER_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.PETROEX_TRUCK_NUMBER);
					
					// int
				
		            	dos.writeInt(this.PETROEX_SUBSCRIBER);
					
					// String
				
						writeString(this.FAN_COMMENT_1,dos);
					
					// int
				
		            	dos.writeInt(this.PETROEX_CITY_CODE);
					
					// String
				
						writeString(this.FAN_COMMENT_2,dos);
					
					// int
				
		            	dos.writeInt(this.PETROEX_COUNTY_CODE);
					
					// int
				
		            	dos.writeInt(this.PRELOAD_ORDER);
					
					// int
				
		            	dos.writeInt(this.PETROEX_STATE_CODE);
					
					// int
				
		            	dos.writeInt(this.CONTRACT_ALLOCATION_ENABLED);
					
					// String
				
						writeString(this.PETROEX_FEIN,dos);
					
					// int
				
		            	dos.writeInt(this.ELVIS_ORDER_NUMBER);
					
					// String
				
						writeString(this.PETROEX_SHIPPER_INFO,dos);
					
					// String
				
						writeString(this.ELVIS_LOADSPOT_ID,dos);
					
					// String
				
						writeString(this.PETROEX_VEHICLE_TYPE,dos);
					
					// int
				
		            	dos.writeInt(this.OVERWEIGHT_TRAILER);
					
					// int
				
		            	dos.writeInt(this.ELVIS_AUTHORIZED);
					
					// int
				
		            	dos.writeInt(this.DISPATCHED_WITH_TRAILER);
					
					// int
				
		            	dos.writeInt(this.DISPATCHED_WITH_DRIVER);
					
					// double
				
		            	dos.writeDouble(this.COMMITTED_PRICE);
					
					// double
				
		            	dos.writeDouble(this.LOADED_PRICE);
					
					// String
				
						writeString(this.CONTRACT_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.MANUALLY_COMPLETED);
					
					// int
				
		            	dos.writeInt(this.OVERRIDE_TOLERANCE_CHECKS);
					
					// int
				
		            	dos.writeInt(this.AIC_STATUS);
					
					// int
				
		            	dos.writeInt(this.BLEND_TOLERANCE_STATUS);
					
					// int
				
		            	dos.writeInt(this.ADDITIVE_TOLERANCE_STATUS);
					
					// int
				
		            	dos.writeInt(this.AUTHORIZATION_REQUEST_ID);
					
					// int
				
		            	dos.writeInt(this.TABS_ORDER_NUMBER);
					
					// int
				
		            	dos.writeInt(this.FLAG_VALID_PRICE);
					
					// int
				
		            	dos.writeInt(this.BOL_NUMBER);
					
					// int
				
		            	dos.writeInt(this.COMPATIBILITY_STATUS);
					
					// int
				
		            	dos.writeInt(this.OVERRIDE_COMPATIBILITY_CHECKS);
					
					// int
				
		            	dos.writeInt(this.CANCELLED_FROM_CBS);
					
					// String
				
						writeString(this.HOST_REF_ID,dos);
					
					// int
				
		            	dos.writeInt(this.UNACCOUNTED_LIMIT_EXCEEDED);
					
					// int
				
		            	dos.writeInt(this.OVERRIDE_UNACCOUNTED_CHECKS);
					
					// int
				
		            	dos.writeInt(this.PENDING_PRINT_COUNT);
					
					// int
				
		            	dos.writeInt(this.PENDING_REQUEST_COUNT);
					
					// String
				
						writeString(this.PDXR_RACK_DRIVER_ID,dos);
					
					// String
				
						writeString(this.PDXR_TERMINAL_CONTROL_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.PDXR_FINAL_SHIPPER_XCTN_SEQ);
					
					// String
				
						writeString(this.PDXR_DESTINATION_STATE_CODE,dos);
					
					// String
				
						writeString(this.PDXR_DESTINATION_COUNTY,dos);
					
					// String
				
						writeString(this.PDXR_DESTINATION_CITY,dos);
					
					// String
				
						writeString(this.PDXR_DESTINATION_ZIP_CODE,dos);
					
					// String
				
						writeString(this.PDXR_CARRIER_FEIN,dos);
					
					// String
				
						writeString(this.PDXR_SHIPPER_INFO,dos);
					
					// int
				
		            	dos.writeInt(this.PDXR_VERSION);
					
					// int
				
		            	dos.writeInt(this.PDXR_VENDOR);
					
					// Integer
				
						writeInteger(this.ORIG_ORDER_ID,dos);
					
					// Integer
				
						writeInteger(this.PREV_ORDER_ID,dos);
					
					// String
				
						writeString(this.SIGNATURE_PATH,dos);
					
					// String
				
						writeString(this.SIGNATURE_FILE_NAME,dos);
					
					// String
				
						writeString(this.PDXR_AUTHORIZING_SYSTEM,dos);
					
					// java.util.Date
				
						writeDate(this.START_TIMESLOT_DATETIME,dos);
					
					// java.util.Date
				
						writeDate(this.END_TIMESLOT_DATETIME,dos);
					
					// java.util.Date
				
						writeDate(this.START_PICKUP_DATETIME,dos);
					
					// java.util.Date
				
						writeDate(this.END_PICKUP_DATETIME,dos);
					
					// int
				
		            	dos.writeInt(this.ADMINISTRATIVE_BOOKING);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.ORDER_ID);
					
					// Integer
				
						writeInteger(this.LOADED_DRIVER_NUMBER,dos);
					
					// String
				
						writeString(this.USER_NAME,dos);
					
					// Integer
				
						writeInteger(this.TRAILER_CARRIER_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.CARRIER_NUMBER);
					
					// String
				
						writeString(this.TRAILER_CODE,dos);
					
					// Integer
				
						writeInteger(this.VEHICLE_CARRIER_NUMBER,dos);
					
					// String
				
						writeString(this.VEHICLE_CODE,dos);
					
					// Integer
				
						writeInteger(this.TRACTOR_CARRIER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.LOADED_CARRIER_NUMBER,dos);
					
					// String
				
						writeString(this.FOLIO_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.TRACTOR_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.DELIVERED_CARRIER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.DISPATCH_CARRIER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.DELIVERED_DRIVER_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.SUPPLIER_NUMBER);
					
					// int
				
		            	dos.writeInt(this.CUSTOMER_NUMBER);
					
					// String
				
						writeString(this.TABS_CARRIER_ID,dos);
					
					// int
				
		            	dos.writeInt(this.DESTINATION_NUMBER);
					
					// Integer
				
						writeInteger(this.TRIP_ID,dos);
					
					// String
				
						writeString(this.TABS_TRUCK_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.TYPE);
					
					// String
				
						writeString(this.SHOST_SU_SUPPLIER_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.CREATOR);
					
					// int
				
		            	dos.writeInt(this.EXCHANGE_ALLOCATION_ENABLED);
					
					// int
				
		            	dos.writeInt(this.MANUALLY_ENTERED);
					
					// String
				
						writeString(this.SHOST_EX_EHOST_THRU_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.DEST_ALLOCATION_ENABLED);
					
					// String
				
						writeString(this.THOST_TH_SUPPLIER_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.CUST_ALLOC_BY_PRODUCT);
					
					// int
				
		            	dos.writeInt(this.CUST_ALLOC_BY_COMPONENT);
					
					// int
				
		            	dos.writeInt(this.CUST_ALLOC_BY_COMP_GROUP);
					
					// int
				
		            	dos.writeInt(this.CREDIT_ENABLED);
					
					// String
				
						writeString(this.THOST_EX_THOST_EXCH_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.BILLING_TYPE);
					
					// int
				
		            	dos.writeInt(this.EXCH_ALLOC_BY_PRODUCT);
					
					// int
				
		            	dos.writeInt(this.EXCH_ALLOC_BY_PRODUCT_GROUP);
					
					// int
				
		            	dos.writeInt(this.CUSTOMER_ALLOCATION_ENABLED);
					
					// String
				
						writeString(this.TABS_FINAL_SHIPPER_ID,dos);
					
					// int
				
		            	dos.writeInt(this.CUST_ALLOC_BY_PRODUCT_GROUP);
					
					// int
				
		            	dos.writeInt(this.MOVEMENT_NUMBER);
					
					// int
				
		            	dos.writeInt(this.REVISION_NUMBER);
					
					// String
				
						writeString(this.TABS_SELLER_ID,dos);
					
					// int
				
		            	dos.writeInt(this.REVISED);
					
					// String
				
						writeString(this.TABS_CONSIGNEE_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.STATUS);
					
					// String
				
						writeString(this.CHOST_CU_SUPPLIER_NUMBER,dos);
					
					// String
				
						writeString(this.CHOST_CU_CUSTOMER_NUMBER,dos);
					
					// java.util.Date
				
						writeDate(this.STATUS_DATE,dos);
					
					// String
				
						writeString(this.PURCHASE_ORDER_NUMBER,dos);
					
					// String
				
						writeString(this.REQUISITION_NUMBER,dos);
					
					// String
				
						writeString(this.BOL_COMMENT_1,dos);
					
					// String
				
						writeString(this.BOL_COMMENT_2,dos);
					
					// int
				
		            	dos.writeInt(this.INVOICE_REQUIRED);
					
					// String
				
						writeString(this.INVOICE_COMMENT_1,dos);
					
					// String
				
						writeString(this.INVOICE_COMMENT_2,dos);
					
					// int
				
		            	dos.writeInt(this.INVOICE_PRINTED);
					
					// String
				
						writeString(this.DESTINATION_COMMENT_1,dos);
					
					// String
				
						writeString(this.DESTINATION_COMMENT_2,dos);
					
					// int
				
		            	dos.writeInt(this.TABS_SUBSCRIBER);
					
					// String
				
						writeString(this.REMARKS,dos);
					
					// java.util.Date
				
						writeDate(this.START_LOAD_TIME,dos);
					
					// java.util.Date
				
						writeDate(this.END_LOAD_TIME,dos);
					
					// double
				
		            	dos.writeDouble(this.DELIVERY_FEE);
					
					// String
				
						writeString(this.TABS_AUTHORIZATION_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.THRUPUTTER_NUMBER,dos);
					
					// String
				
						writeString(this.LAST_USER_NAME,dos);
					
					// java.util.Date
				
						writeDate(this.LAST_MODIFIED,dos);
					
					// int
				
		            	dos.writeInt(this.BOL_PRINTED);
					
					// java.util.Date
				
						writeDate(this.ORDER_ENTRY_TIME,dos);
					
					// int
				
		            	dos.writeInt(this.BILL_FREIGHT);
					
					// java.util.Date
				
						writeDate(this.DELIVERY_DATE,dos);
					
					// int
				
		            	dos.writeInt(this.SHIFT);
					
					// int
				
		            	dos.writeInt(this.STOP);
					
					// int
				
		            	dos.writeInt(this.DELIVERY_CONFIRMED);
					
					// String
				
						writeString(this.VALIDATING_NODE_NAME,dos);
					
					// int
				
		            	dos.writeInt(this.HOST_PROCESSED);
					
					// String
				
						writeString(this.PETROEX_COMPANY_CODE,dos);
					
					// String
				
						writeString(this.PETROEX_CONSIGNEE_NUMBER,dos);
					
					// String
				
						writeString(this.PETROEX_THIRD_PARTY,dos);
					
					// String
				
						writeString(this.PETROEX_CARRIER_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.PETROEX_TRUCK_NUMBER);
					
					// int
				
		            	dos.writeInt(this.PETROEX_SUBSCRIBER);
					
					// String
				
						writeString(this.FAN_COMMENT_1,dos);
					
					// int
				
		            	dos.writeInt(this.PETROEX_CITY_CODE);
					
					// String
				
						writeString(this.FAN_COMMENT_2,dos);
					
					// int
				
		            	dos.writeInt(this.PETROEX_COUNTY_CODE);
					
					// int
				
		            	dos.writeInt(this.PRELOAD_ORDER);
					
					// int
				
		            	dos.writeInt(this.PETROEX_STATE_CODE);
					
					// int
				
		            	dos.writeInt(this.CONTRACT_ALLOCATION_ENABLED);
					
					// String
				
						writeString(this.PETROEX_FEIN,dos);
					
					// int
				
		            	dos.writeInt(this.ELVIS_ORDER_NUMBER);
					
					// String
				
						writeString(this.PETROEX_SHIPPER_INFO,dos);
					
					// String
				
						writeString(this.ELVIS_LOADSPOT_ID,dos);
					
					// String
				
						writeString(this.PETROEX_VEHICLE_TYPE,dos);
					
					// int
				
		            	dos.writeInt(this.OVERWEIGHT_TRAILER);
					
					// int
				
		            	dos.writeInt(this.ELVIS_AUTHORIZED);
					
					// int
				
		            	dos.writeInt(this.DISPATCHED_WITH_TRAILER);
					
					// int
				
		            	dos.writeInt(this.DISPATCHED_WITH_DRIVER);
					
					// double
				
		            	dos.writeDouble(this.COMMITTED_PRICE);
					
					// double
				
		            	dos.writeDouble(this.LOADED_PRICE);
					
					// String
				
						writeString(this.CONTRACT_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.MANUALLY_COMPLETED);
					
					// int
				
		            	dos.writeInt(this.OVERRIDE_TOLERANCE_CHECKS);
					
					// int
				
		            	dos.writeInt(this.AIC_STATUS);
					
					// int
				
		            	dos.writeInt(this.BLEND_TOLERANCE_STATUS);
					
					// int
				
		            	dos.writeInt(this.ADDITIVE_TOLERANCE_STATUS);
					
					// int
				
		            	dos.writeInt(this.AUTHORIZATION_REQUEST_ID);
					
					// int
				
		            	dos.writeInt(this.TABS_ORDER_NUMBER);
					
					// int
				
		            	dos.writeInt(this.FLAG_VALID_PRICE);
					
					// int
				
		            	dos.writeInt(this.BOL_NUMBER);
					
					// int
				
		            	dos.writeInt(this.COMPATIBILITY_STATUS);
					
					// int
				
		            	dos.writeInt(this.OVERRIDE_COMPATIBILITY_CHECKS);
					
					// int
				
		            	dos.writeInt(this.CANCELLED_FROM_CBS);
					
					// String
				
						writeString(this.HOST_REF_ID,dos);
					
					// int
				
		            	dos.writeInt(this.UNACCOUNTED_LIMIT_EXCEEDED);
					
					// int
				
		            	dos.writeInt(this.OVERRIDE_UNACCOUNTED_CHECKS);
					
					// int
				
		            	dos.writeInt(this.PENDING_PRINT_COUNT);
					
					// int
				
		            	dos.writeInt(this.PENDING_REQUEST_COUNT);
					
					// String
				
						writeString(this.PDXR_RACK_DRIVER_ID,dos);
					
					// String
				
						writeString(this.PDXR_TERMINAL_CONTROL_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.PDXR_FINAL_SHIPPER_XCTN_SEQ);
					
					// String
				
						writeString(this.PDXR_DESTINATION_STATE_CODE,dos);
					
					// String
				
						writeString(this.PDXR_DESTINATION_COUNTY,dos);
					
					// String
				
						writeString(this.PDXR_DESTINATION_CITY,dos);
					
					// String
				
						writeString(this.PDXR_DESTINATION_ZIP_CODE,dos);
					
					// String
				
						writeString(this.PDXR_CARRIER_FEIN,dos);
					
					// String
				
						writeString(this.PDXR_SHIPPER_INFO,dos);
					
					// int
				
		            	dos.writeInt(this.PDXR_VERSION);
					
					// int
				
		            	dos.writeInt(this.PDXR_VENDOR);
					
					// Integer
				
						writeInteger(this.ORIG_ORDER_ID,dos);
					
					// Integer
				
						writeInteger(this.PREV_ORDER_ID,dos);
					
					// String
				
						writeString(this.SIGNATURE_PATH,dos);
					
					// String
				
						writeString(this.SIGNATURE_FILE_NAME,dos);
					
					// String
				
						writeString(this.PDXR_AUTHORIZING_SYSTEM,dos);
					
					// java.util.Date
				
						writeDate(this.START_TIMESLOT_DATETIME,dos);
					
					// java.util.Date
				
						writeDate(this.END_TIMESLOT_DATETIME,dos);
					
					// java.util.Date
				
						writeDate(this.START_PICKUP_DATETIME,dos);
					
					// java.util.Date
				
						writeDate(this.END_PICKUP_DATETIME,dos);
					
					// int
				
		            	dos.writeInt(this.ADMINISTRATIVE_BOOKING);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("ORDER_ID="+String.valueOf(ORDER_ID));
		sb.append(",LOADED_DRIVER_NUMBER="+String.valueOf(LOADED_DRIVER_NUMBER));
		sb.append(",USER_NAME="+USER_NAME);
		sb.append(",TRAILER_CARRIER_NUMBER="+String.valueOf(TRAILER_CARRIER_NUMBER));
		sb.append(",CARRIER_NUMBER="+String.valueOf(CARRIER_NUMBER));
		sb.append(",TRAILER_CODE="+TRAILER_CODE);
		sb.append(",VEHICLE_CARRIER_NUMBER="+String.valueOf(VEHICLE_CARRIER_NUMBER));
		sb.append(",VEHICLE_CODE="+VEHICLE_CODE);
		sb.append(",TRACTOR_CARRIER_NUMBER="+String.valueOf(TRACTOR_CARRIER_NUMBER));
		sb.append(",LOADED_CARRIER_NUMBER="+String.valueOf(LOADED_CARRIER_NUMBER));
		sb.append(",FOLIO_NUMBER="+FOLIO_NUMBER);
		sb.append(",TRACTOR_NUMBER="+String.valueOf(TRACTOR_NUMBER));
		sb.append(",DELIVERED_CARRIER_NUMBER="+String.valueOf(DELIVERED_CARRIER_NUMBER));
		sb.append(",DISPATCH_CARRIER_NUMBER="+String.valueOf(DISPATCH_CARRIER_NUMBER));
		sb.append(",DELIVERED_DRIVER_NUMBER="+String.valueOf(DELIVERED_DRIVER_NUMBER));
		sb.append(",SUPPLIER_NUMBER="+String.valueOf(SUPPLIER_NUMBER));
		sb.append(",CUSTOMER_NUMBER="+String.valueOf(CUSTOMER_NUMBER));
		sb.append(",TABS_CARRIER_ID="+TABS_CARRIER_ID);
		sb.append(",DESTINATION_NUMBER="+String.valueOf(DESTINATION_NUMBER));
		sb.append(",TRIP_ID="+String.valueOf(TRIP_ID));
		sb.append(",TABS_TRUCK_NUMBER="+TABS_TRUCK_NUMBER);
		sb.append(",TYPE="+String.valueOf(TYPE));
		sb.append(",SHOST_SU_SUPPLIER_NUMBER="+SHOST_SU_SUPPLIER_NUMBER);
		sb.append(",CREATOR="+String.valueOf(CREATOR));
		sb.append(",EXCHANGE_ALLOCATION_ENABLED="+String.valueOf(EXCHANGE_ALLOCATION_ENABLED));
		sb.append(",MANUALLY_ENTERED="+String.valueOf(MANUALLY_ENTERED));
		sb.append(",SHOST_EX_EHOST_THRU_NUMBER="+SHOST_EX_EHOST_THRU_NUMBER);
		sb.append(",DEST_ALLOCATION_ENABLED="+String.valueOf(DEST_ALLOCATION_ENABLED));
		sb.append(",THOST_TH_SUPPLIER_NUMBER="+THOST_TH_SUPPLIER_NUMBER);
		sb.append(",CUST_ALLOC_BY_PRODUCT="+String.valueOf(CUST_ALLOC_BY_PRODUCT));
		sb.append(",CUST_ALLOC_BY_COMPONENT="+String.valueOf(CUST_ALLOC_BY_COMPONENT));
		sb.append(",CUST_ALLOC_BY_COMP_GROUP="+String.valueOf(CUST_ALLOC_BY_COMP_GROUP));
		sb.append(",CREDIT_ENABLED="+String.valueOf(CREDIT_ENABLED));
		sb.append(",THOST_EX_THOST_EXCH_NUMBER="+THOST_EX_THOST_EXCH_NUMBER);
		sb.append(",BILLING_TYPE="+String.valueOf(BILLING_TYPE));
		sb.append(",EXCH_ALLOC_BY_PRODUCT="+String.valueOf(EXCH_ALLOC_BY_PRODUCT));
		sb.append(",EXCH_ALLOC_BY_PRODUCT_GROUP="+String.valueOf(EXCH_ALLOC_BY_PRODUCT_GROUP));
		sb.append(",CUSTOMER_ALLOCATION_ENABLED="+String.valueOf(CUSTOMER_ALLOCATION_ENABLED));
		sb.append(",TABS_FINAL_SHIPPER_ID="+TABS_FINAL_SHIPPER_ID);
		sb.append(",CUST_ALLOC_BY_PRODUCT_GROUP="+String.valueOf(CUST_ALLOC_BY_PRODUCT_GROUP));
		sb.append(",MOVEMENT_NUMBER="+String.valueOf(MOVEMENT_NUMBER));
		sb.append(",REVISION_NUMBER="+String.valueOf(REVISION_NUMBER));
		sb.append(",TABS_SELLER_ID="+TABS_SELLER_ID);
		sb.append(",REVISED="+String.valueOf(REVISED));
		sb.append(",TABS_CONSIGNEE_NUMBER="+TABS_CONSIGNEE_NUMBER);
		sb.append(",STATUS="+String.valueOf(STATUS));
		sb.append(",CHOST_CU_SUPPLIER_NUMBER="+CHOST_CU_SUPPLIER_NUMBER);
		sb.append(",CHOST_CU_CUSTOMER_NUMBER="+CHOST_CU_CUSTOMER_NUMBER);
		sb.append(",STATUS_DATE="+String.valueOf(STATUS_DATE));
		sb.append(",PURCHASE_ORDER_NUMBER="+PURCHASE_ORDER_NUMBER);
		sb.append(",REQUISITION_NUMBER="+REQUISITION_NUMBER);
		sb.append(",BOL_COMMENT_1="+BOL_COMMENT_1);
		sb.append(",BOL_COMMENT_2="+BOL_COMMENT_2);
		sb.append(",INVOICE_REQUIRED="+String.valueOf(INVOICE_REQUIRED));
		sb.append(",INVOICE_COMMENT_1="+INVOICE_COMMENT_1);
		sb.append(",INVOICE_COMMENT_2="+INVOICE_COMMENT_2);
		sb.append(",INVOICE_PRINTED="+String.valueOf(INVOICE_PRINTED));
		sb.append(",DESTINATION_COMMENT_1="+DESTINATION_COMMENT_1);
		sb.append(",DESTINATION_COMMENT_2="+DESTINATION_COMMENT_2);
		sb.append(",TABS_SUBSCRIBER="+String.valueOf(TABS_SUBSCRIBER));
		sb.append(",REMARKS="+REMARKS);
		sb.append(",START_LOAD_TIME="+String.valueOf(START_LOAD_TIME));
		sb.append(",END_LOAD_TIME="+String.valueOf(END_LOAD_TIME));
		sb.append(",DELIVERY_FEE="+String.valueOf(DELIVERY_FEE));
		sb.append(",TABS_AUTHORIZATION_NUMBER="+TABS_AUTHORIZATION_NUMBER);
		sb.append(",THRUPUTTER_NUMBER="+String.valueOf(THRUPUTTER_NUMBER));
		sb.append(",LAST_USER_NAME="+LAST_USER_NAME);
		sb.append(",LAST_MODIFIED="+String.valueOf(LAST_MODIFIED));
		sb.append(",BOL_PRINTED="+String.valueOf(BOL_PRINTED));
		sb.append(",ORDER_ENTRY_TIME="+String.valueOf(ORDER_ENTRY_TIME));
		sb.append(",BILL_FREIGHT="+String.valueOf(BILL_FREIGHT));
		sb.append(",DELIVERY_DATE="+String.valueOf(DELIVERY_DATE));
		sb.append(",SHIFT="+String.valueOf(SHIFT));
		sb.append(",STOP="+String.valueOf(STOP));
		sb.append(",DELIVERY_CONFIRMED="+String.valueOf(DELIVERY_CONFIRMED));
		sb.append(",VALIDATING_NODE_NAME="+VALIDATING_NODE_NAME);
		sb.append(",HOST_PROCESSED="+String.valueOf(HOST_PROCESSED));
		sb.append(",PETROEX_COMPANY_CODE="+PETROEX_COMPANY_CODE);
		sb.append(",PETROEX_CONSIGNEE_NUMBER="+PETROEX_CONSIGNEE_NUMBER);
		sb.append(",PETROEX_THIRD_PARTY="+PETROEX_THIRD_PARTY);
		sb.append(",PETROEX_CARRIER_CODE="+PETROEX_CARRIER_CODE);
		sb.append(",PETROEX_TRUCK_NUMBER="+String.valueOf(PETROEX_TRUCK_NUMBER));
		sb.append(",PETROEX_SUBSCRIBER="+String.valueOf(PETROEX_SUBSCRIBER));
		sb.append(",FAN_COMMENT_1="+FAN_COMMENT_1);
		sb.append(",PETROEX_CITY_CODE="+String.valueOf(PETROEX_CITY_CODE));
		sb.append(",FAN_COMMENT_2="+FAN_COMMENT_2);
		sb.append(",PETROEX_COUNTY_CODE="+String.valueOf(PETROEX_COUNTY_CODE));
		sb.append(",PRELOAD_ORDER="+String.valueOf(PRELOAD_ORDER));
		sb.append(",PETROEX_STATE_CODE="+String.valueOf(PETROEX_STATE_CODE));
		sb.append(",CONTRACT_ALLOCATION_ENABLED="+String.valueOf(CONTRACT_ALLOCATION_ENABLED));
		sb.append(",PETROEX_FEIN="+PETROEX_FEIN);
		sb.append(",ELVIS_ORDER_NUMBER="+String.valueOf(ELVIS_ORDER_NUMBER));
		sb.append(",PETROEX_SHIPPER_INFO="+PETROEX_SHIPPER_INFO);
		sb.append(",ELVIS_LOADSPOT_ID="+ELVIS_LOADSPOT_ID);
		sb.append(",PETROEX_VEHICLE_TYPE="+PETROEX_VEHICLE_TYPE);
		sb.append(",OVERWEIGHT_TRAILER="+String.valueOf(OVERWEIGHT_TRAILER));
		sb.append(",ELVIS_AUTHORIZED="+String.valueOf(ELVIS_AUTHORIZED));
		sb.append(",DISPATCHED_WITH_TRAILER="+String.valueOf(DISPATCHED_WITH_TRAILER));
		sb.append(",DISPATCHED_WITH_DRIVER="+String.valueOf(DISPATCHED_WITH_DRIVER));
		sb.append(",COMMITTED_PRICE="+String.valueOf(COMMITTED_PRICE));
		sb.append(",LOADED_PRICE="+String.valueOf(LOADED_PRICE));
		sb.append(",CONTRACT_NUMBER="+CONTRACT_NUMBER);
		sb.append(",MANUALLY_COMPLETED="+String.valueOf(MANUALLY_COMPLETED));
		sb.append(",OVERRIDE_TOLERANCE_CHECKS="+String.valueOf(OVERRIDE_TOLERANCE_CHECKS));
		sb.append(",AIC_STATUS="+String.valueOf(AIC_STATUS));
		sb.append(",BLEND_TOLERANCE_STATUS="+String.valueOf(BLEND_TOLERANCE_STATUS));
		sb.append(",ADDITIVE_TOLERANCE_STATUS="+String.valueOf(ADDITIVE_TOLERANCE_STATUS));
		sb.append(",AUTHORIZATION_REQUEST_ID="+String.valueOf(AUTHORIZATION_REQUEST_ID));
		sb.append(",TABS_ORDER_NUMBER="+String.valueOf(TABS_ORDER_NUMBER));
		sb.append(",FLAG_VALID_PRICE="+String.valueOf(FLAG_VALID_PRICE));
		sb.append(",BOL_NUMBER="+String.valueOf(BOL_NUMBER));
		sb.append(",COMPATIBILITY_STATUS="+String.valueOf(COMPATIBILITY_STATUS));
		sb.append(",OVERRIDE_COMPATIBILITY_CHECKS="+String.valueOf(OVERRIDE_COMPATIBILITY_CHECKS));
		sb.append(",CANCELLED_FROM_CBS="+String.valueOf(CANCELLED_FROM_CBS));
		sb.append(",HOST_REF_ID="+HOST_REF_ID);
		sb.append(",UNACCOUNTED_LIMIT_EXCEEDED="+String.valueOf(UNACCOUNTED_LIMIT_EXCEEDED));
		sb.append(",OVERRIDE_UNACCOUNTED_CHECKS="+String.valueOf(OVERRIDE_UNACCOUNTED_CHECKS));
		sb.append(",PENDING_PRINT_COUNT="+String.valueOf(PENDING_PRINT_COUNT));
		sb.append(",PENDING_REQUEST_COUNT="+String.valueOf(PENDING_REQUEST_COUNT));
		sb.append(",PDXR_RACK_DRIVER_ID="+PDXR_RACK_DRIVER_ID);
		sb.append(",PDXR_TERMINAL_CONTROL_NUMBER="+PDXR_TERMINAL_CONTROL_NUMBER);
		sb.append(",PDXR_FINAL_SHIPPER_XCTN_SEQ="+String.valueOf(PDXR_FINAL_SHIPPER_XCTN_SEQ));
		sb.append(",PDXR_DESTINATION_STATE_CODE="+PDXR_DESTINATION_STATE_CODE);
		sb.append(",PDXR_DESTINATION_COUNTY="+PDXR_DESTINATION_COUNTY);
		sb.append(",PDXR_DESTINATION_CITY="+PDXR_DESTINATION_CITY);
		sb.append(",PDXR_DESTINATION_ZIP_CODE="+PDXR_DESTINATION_ZIP_CODE);
		sb.append(",PDXR_CARRIER_FEIN="+PDXR_CARRIER_FEIN);
		sb.append(",PDXR_SHIPPER_INFO="+PDXR_SHIPPER_INFO);
		sb.append(",PDXR_VERSION="+String.valueOf(PDXR_VERSION));
		sb.append(",PDXR_VENDOR="+String.valueOf(PDXR_VENDOR));
		sb.append(",ORIG_ORDER_ID="+String.valueOf(ORIG_ORDER_ID));
		sb.append(",PREV_ORDER_ID="+String.valueOf(PREV_ORDER_ID));
		sb.append(",SIGNATURE_PATH="+SIGNATURE_PATH);
		sb.append(",SIGNATURE_FILE_NAME="+SIGNATURE_FILE_NAME);
		sb.append(",PDXR_AUTHORIZING_SYSTEM="+PDXR_AUTHORIZING_SYSTEM);
		sb.append(",START_TIMESLOT_DATETIME="+String.valueOf(START_TIMESLOT_DATETIME));
		sb.append(",END_TIMESLOT_DATETIME="+String.valueOf(END_TIMESLOT_DATETIME));
		sb.append(",START_PICKUP_DATETIME="+String.valueOf(START_PICKUP_DATETIME));
		sb.append(",END_PICKUP_DATETIME="+String.valueOf(END_PICKUP_DATETIME));
		sb.append(",ADMINISTRATIVE_BOOKING="+String.valueOf(ADMINISTRATIVE_BOOKING));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row1Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class after_tDBInput_1Struct implements routines.system.IPersistableRow<after_tDBInput_1Struct> {
    final static byte[] commonByteArrayLock_PGS_STAGE_DIM_ORDERS = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_DIM_ORDERS = new byte[0];

	
			    public int ORDER_ID;

				public int getORDER_ID () {
					return this.ORDER_ID;
				}
				
			    public Integer LOADED_DRIVER_NUMBER;

				public Integer getLOADED_DRIVER_NUMBER () {
					return this.LOADED_DRIVER_NUMBER;
				}
				
			    public String USER_NAME;

				public String getUSER_NAME () {
					return this.USER_NAME;
				}
				
			    public Integer TRAILER_CARRIER_NUMBER;

				public Integer getTRAILER_CARRIER_NUMBER () {
					return this.TRAILER_CARRIER_NUMBER;
				}
				
			    public int CARRIER_NUMBER;

				public int getCARRIER_NUMBER () {
					return this.CARRIER_NUMBER;
				}
				
			    public String TRAILER_CODE;

				public String getTRAILER_CODE () {
					return this.TRAILER_CODE;
				}
				
			    public Integer VEHICLE_CARRIER_NUMBER;

				public Integer getVEHICLE_CARRIER_NUMBER () {
					return this.VEHICLE_CARRIER_NUMBER;
				}
				
			    public String VEHICLE_CODE;

				public String getVEHICLE_CODE () {
					return this.VEHICLE_CODE;
				}
				
			    public Integer TRACTOR_CARRIER_NUMBER;

				public Integer getTRACTOR_CARRIER_NUMBER () {
					return this.TRACTOR_CARRIER_NUMBER;
				}
				
			    public Integer LOADED_CARRIER_NUMBER;

				public Integer getLOADED_CARRIER_NUMBER () {
					return this.LOADED_CARRIER_NUMBER;
				}
				
			    public String FOLIO_NUMBER;

				public String getFOLIO_NUMBER () {
					return this.FOLIO_NUMBER;
				}
				
			    public Integer TRACTOR_NUMBER;

				public Integer getTRACTOR_NUMBER () {
					return this.TRACTOR_NUMBER;
				}
				
			    public Integer DELIVERED_CARRIER_NUMBER;

				public Integer getDELIVERED_CARRIER_NUMBER () {
					return this.DELIVERED_CARRIER_NUMBER;
				}
				
			    public Integer DISPATCH_CARRIER_NUMBER;

				public Integer getDISPATCH_CARRIER_NUMBER () {
					return this.DISPATCH_CARRIER_NUMBER;
				}
				
			    public Integer DELIVERED_DRIVER_NUMBER;

				public Integer getDELIVERED_DRIVER_NUMBER () {
					return this.DELIVERED_DRIVER_NUMBER;
				}
				
			    public int SUPPLIER_NUMBER;

				public int getSUPPLIER_NUMBER () {
					return this.SUPPLIER_NUMBER;
				}
				
			    public int CUSTOMER_NUMBER;

				public int getCUSTOMER_NUMBER () {
					return this.CUSTOMER_NUMBER;
				}
				
			    public String TABS_CARRIER_ID;

				public String getTABS_CARRIER_ID () {
					return this.TABS_CARRIER_ID;
				}
				
			    public int DESTINATION_NUMBER;

				public int getDESTINATION_NUMBER () {
					return this.DESTINATION_NUMBER;
				}
				
			    public Integer TRIP_ID;

				public Integer getTRIP_ID () {
					return this.TRIP_ID;
				}
				
			    public String TABS_TRUCK_NUMBER;

				public String getTABS_TRUCK_NUMBER () {
					return this.TABS_TRUCK_NUMBER;
				}
				
			    public int TYPE;

				public int getTYPE () {
					return this.TYPE;
				}
				
			    public String SHOST_SU_SUPPLIER_NUMBER;

				public String getSHOST_SU_SUPPLIER_NUMBER () {
					return this.SHOST_SU_SUPPLIER_NUMBER;
				}
				
			    public int CREATOR;

				public int getCREATOR () {
					return this.CREATOR;
				}
				
			    public int EXCHANGE_ALLOCATION_ENABLED;

				public int getEXCHANGE_ALLOCATION_ENABLED () {
					return this.EXCHANGE_ALLOCATION_ENABLED;
				}
				
			    public int MANUALLY_ENTERED;

				public int getMANUALLY_ENTERED () {
					return this.MANUALLY_ENTERED;
				}
				
			    public String SHOST_EX_EHOST_THRU_NUMBER;

				public String getSHOST_EX_EHOST_THRU_NUMBER () {
					return this.SHOST_EX_EHOST_THRU_NUMBER;
				}
				
			    public int DEST_ALLOCATION_ENABLED;

				public int getDEST_ALLOCATION_ENABLED () {
					return this.DEST_ALLOCATION_ENABLED;
				}
				
			    public String THOST_TH_SUPPLIER_NUMBER;

				public String getTHOST_TH_SUPPLIER_NUMBER () {
					return this.THOST_TH_SUPPLIER_NUMBER;
				}
				
			    public int CUST_ALLOC_BY_PRODUCT;

				public int getCUST_ALLOC_BY_PRODUCT () {
					return this.CUST_ALLOC_BY_PRODUCT;
				}
				
			    public int CUST_ALLOC_BY_COMPONENT;

				public int getCUST_ALLOC_BY_COMPONENT () {
					return this.CUST_ALLOC_BY_COMPONENT;
				}
				
			    public int CUST_ALLOC_BY_COMP_GROUP;

				public int getCUST_ALLOC_BY_COMP_GROUP () {
					return this.CUST_ALLOC_BY_COMP_GROUP;
				}
				
			    public int CREDIT_ENABLED;

				public int getCREDIT_ENABLED () {
					return this.CREDIT_ENABLED;
				}
				
			    public String THOST_EX_THOST_EXCH_NUMBER;

				public String getTHOST_EX_THOST_EXCH_NUMBER () {
					return this.THOST_EX_THOST_EXCH_NUMBER;
				}
				
			    public int BILLING_TYPE;

				public int getBILLING_TYPE () {
					return this.BILLING_TYPE;
				}
				
			    public int EXCH_ALLOC_BY_PRODUCT;

				public int getEXCH_ALLOC_BY_PRODUCT () {
					return this.EXCH_ALLOC_BY_PRODUCT;
				}
				
			    public int EXCH_ALLOC_BY_PRODUCT_GROUP;

				public int getEXCH_ALLOC_BY_PRODUCT_GROUP () {
					return this.EXCH_ALLOC_BY_PRODUCT_GROUP;
				}
				
			    public int CUSTOMER_ALLOCATION_ENABLED;

				public int getCUSTOMER_ALLOCATION_ENABLED () {
					return this.CUSTOMER_ALLOCATION_ENABLED;
				}
				
			    public String TABS_FINAL_SHIPPER_ID;

				public String getTABS_FINAL_SHIPPER_ID () {
					return this.TABS_FINAL_SHIPPER_ID;
				}
				
			    public int CUST_ALLOC_BY_PRODUCT_GROUP;

				public int getCUST_ALLOC_BY_PRODUCT_GROUP () {
					return this.CUST_ALLOC_BY_PRODUCT_GROUP;
				}
				
			    public int MOVEMENT_NUMBER;

				public int getMOVEMENT_NUMBER () {
					return this.MOVEMENT_NUMBER;
				}
				
			    public int REVISION_NUMBER;

				public int getREVISION_NUMBER () {
					return this.REVISION_NUMBER;
				}
				
			    public String TABS_SELLER_ID;

				public String getTABS_SELLER_ID () {
					return this.TABS_SELLER_ID;
				}
				
			    public int REVISED;

				public int getREVISED () {
					return this.REVISED;
				}
				
			    public String TABS_CONSIGNEE_NUMBER;

				public String getTABS_CONSIGNEE_NUMBER () {
					return this.TABS_CONSIGNEE_NUMBER;
				}
				
			    public int STATUS;

				public int getSTATUS () {
					return this.STATUS;
				}
				
			    public String CHOST_CU_SUPPLIER_NUMBER;

				public String getCHOST_CU_SUPPLIER_NUMBER () {
					return this.CHOST_CU_SUPPLIER_NUMBER;
				}
				
			    public String CHOST_CU_CUSTOMER_NUMBER;

				public String getCHOST_CU_CUSTOMER_NUMBER () {
					return this.CHOST_CU_CUSTOMER_NUMBER;
				}
				
			    public java.util.Date STATUS_DATE;

				public java.util.Date getSTATUS_DATE () {
					return this.STATUS_DATE;
				}
				
			    public String PURCHASE_ORDER_NUMBER;

				public String getPURCHASE_ORDER_NUMBER () {
					return this.PURCHASE_ORDER_NUMBER;
				}
				
			    public String REQUISITION_NUMBER;

				public String getREQUISITION_NUMBER () {
					return this.REQUISITION_NUMBER;
				}
				
			    public String BOL_COMMENT_1;

				public String getBOL_COMMENT_1 () {
					return this.BOL_COMMENT_1;
				}
				
			    public String BOL_COMMENT_2;

				public String getBOL_COMMENT_2 () {
					return this.BOL_COMMENT_2;
				}
				
			    public int INVOICE_REQUIRED;

				public int getINVOICE_REQUIRED () {
					return this.INVOICE_REQUIRED;
				}
				
			    public String INVOICE_COMMENT_1;

				public String getINVOICE_COMMENT_1 () {
					return this.INVOICE_COMMENT_1;
				}
				
			    public String INVOICE_COMMENT_2;

				public String getINVOICE_COMMENT_2 () {
					return this.INVOICE_COMMENT_2;
				}
				
			    public int INVOICE_PRINTED;

				public int getINVOICE_PRINTED () {
					return this.INVOICE_PRINTED;
				}
				
			    public String DESTINATION_COMMENT_1;

				public String getDESTINATION_COMMENT_1 () {
					return this.DESTINATION_COMMENT_1;
				}
				
			    public String DESTINATION_COMMENT_2;

				public String getDESTINATION_COMMENT_2 () {
					return this.DESTINATION_COMMENT_2;
				}
				
			    public int TABS_SUBSCRIBER;

				public int getTABS_SUBSCRIBER () {
					return this.TABS_SUBSCRIBER;
				}
				
			    public String REMARKS;

				public String getREMARKS () {
					return this.REMARKS;
				}
				
			    public java.util.Date START_LOAD_TIME;

				public java.util.Date getSTART_LOAD_TIME () {
					return this.START_LOAD_TIME;
				}
				
			    public java.util.Date END_LOAD_TIME;

				public java.util.Date getEND_LOAD_TIME () {
					return this.END_LOAD_TIME;
				}
				
			    public double DELIVERY_FEE;

				public double getDELIVERY_FEE () {
					return this.DELIVERY_FEE;
				}
				
			    public String TABS_AUTHORIZATION_NUMBER;

				public String getTABS_AUTHORIZATION_NUMBER () {
					return this.TABS_AUTHORIZATION_NUMBER;
				}
				
			    public Integer THRUPUTTER_NUMBER;

				public Integer getTHRUPUTTER_NUMBER () {
					return this.THRUPUTTER_NUMBER;
				}
				
			    public String LAST_USER_NAME;

				public String getLAST_USER_NAME () {
					return this.LAST_USER_NAME;
				}
				
			    public java.util.Date LAST_MODIFIED;

				public java.util.Date getLAST_MODIFIED () {
					return this.LAST_MODIFIED;
				}
				
			    public int BOL_PRINTED;

				public int getBOL_PRINTED () {
					return this.BOL_PRINTED;
				}
				
			    public java.util.Date ORDER_ENTRY_TIME;

				public java.util.Date getORDER_ENTRY_TIME () {
					return this.ORDER_ENTRY_TIME;
				}
				
			    public int BILL_FREIGHT;

				public int getBILL_FREIGHT () {
					return this.BILL_FREIGHT;
				}
				
			    public java.util.Date DELIVERY_DATE;

				public java.util.Date getDELIVERY_DATE () {
					return this.DELIVERY_DATE;
				}
				
			    public int SHIFT;

				public int getSHIFT () {
					return this.SHIFT;
				}
				
			    public int STOP;

				public int getSTOP () {
					return this.STOP;
				}
				
			    public int DELIVERY_CONFIRMED;

				public int getDELIVERY_CONFIRMED () {
					return this.DELIVERY_CONFIRMED;
				}
				
			    public String VALIDATING_NODE_NAME;

				public String getVALIDATING_NODE_NAME () {
					return this.VALIDATING_NODE_NAME;
				}
				
			    public int HOST_PROCESSED;

				public int getHOST_PROCESSED () {
					return this.HOST_PROCESSED;
				}
				
			    public String PETROEX_COMPANY_CODE;

				public String getPETROEX_COMPANY_CODE () {
					return this.PETROEX_COMPANY_CODE;
				}
				
			    public String PETROEX_CONSIGNEE_NUMBER;

				public String getPETROEX_CONSIGNEE_NUMBER () {
					return this.PETROEX_CONSIGNEE_NUMBER;
				}
				
			    public String PETROEX_THIRD_PARTY;

				public String getPETROEX_THIRD_PARTY () {
					return this.PETROEX_THIRD_PARTY;
				}
				
			    public String PETROEX_CARRIER_CODE;

				public String getPETROEX_CARRIER_CODE () {
					return this.PETROEX_CARRIER_CODE;
				}
				
			    public int PETROEX_TRUCK_NUMBER;

				public int getPETROEX_TRUCK_NUMBER () {
					return this.PETROEX_TRUCK_NUMBER;
				}
				
			    public int PETROEX_SUBSCRIBER;

				public int getPETROEX_SUBSCRIBER () {
					return this.PETROEX_SUBSCRIBER;
				}
				
			    public String FAN_COMMENT_1;

				public String getFAN_COMMENT_1 () {
					return this.FAN_COMMENT_1;
				}
				
			    public int PETROEX_CITY_CODE;

				public int getPETROEX_CITY_CODE () {
					return this.PETROEX_CITY_CODE;
				}
				
			    public String FAN_COMMENT_2;

				public String getFAN_COMMENT_2 () {
					return this.FAN_COMMENT_2;
				}
				
			    public int PETROEX_COUNTY_CODE;

				public int getPETROEX_COUNTY_CODE () {
					return this.PETROEX_COUNTY_CODE;
				}
				
			    public int PRELOAD_ORDER;

				public int getPRELOAD_ORDER () {
					return this.PRELOAD_ORDER;
				}
				
			    public int PETROEX_STATE_CODE;

				public int getPETROEX_STATE_CODE () {
					return this.PETROEX_STATE_CODE;
				}
				
			    public int CONTRACT_ALLOCATION_ENABLED;

				public int getCONTRACT_ALLOCATION_ENABLED () {
					return this.CONTRACT_ALLOCATION_ENABLED;
				}
				
			    public String PETROEX_FEIN;

				public String getPETROEX_FEIN () {
					return this.PETROEX_FEIN;
				}
				
			    public int ELVIS_ORDER_NUMBER;

				public int getELVIS_ORDER_NUMBER () {
					return this.ELVIS_ORDER_NUMBER;
				}
				
			    public String PETROEX_SHIPPER_INFO;

				public String getPETROEX_SHIPPER_INFO () {
					return this.PETROEX_SHIPPER_INFO;
				}
				
			    public String ELVIS_LOADSPOT_ID;

				public String getELVIS_LOADSPOT_ID () {
					return this.ELVIS_LOADSPOT_ID;
				}
				
			    public String PETROEX_VEHICLE_TYPE;

				public String getPETROEX_VEHICLE_TYPE () {
					return this.PETROEX_VEHICLE_TYPE;
				}
				
			    public int OVERWEIGHT_TRAILER;

				public int getOVERWEIGHT_TRAILER () {
					return this.OVERWEIGHT_TRAILER;
				}
				
			    public int ELVIS_AUTHORIZED;

				public int getELVIS_AUTHORIZED () {
					return this.ELVIS_AUTHORIZED;
				}
				
			    public int DISPATCHED_WITH_TRAILER;

				public int getDISPATCHED_WITH_TRAILER () {
					return this.DISPATCHED_WITH_TRAILER;
				}
				
			    public int DISPATCHED_WITH_DRIVER;

				public int getDISPATCHED_WITH_DRIVER () {
					return this.DISPATCHED_WITH_DRIVER;
				}
				
			    public double COMMITTED_PRICE;

				public double getCOMMITTED_PRICE () {
					return this.COMMITTED_PRICE;
				}
				
			    public double LOADED_PRICE;

				public double getLOADED_PRICE () {
					return this.LOADED_PRICE;
				}
				
			    public String CONTRACT_NUMBER;

				public String getCONTRACT_NUMBER () {
					return this.CONTRACT_NUMBER;
				}
				
			    public int MANUALLY_COMPLETED;

				public int getMANUALLY_COMPLETED () {
					return this.MANUALLY_COMPLETED;
				}
				
			    public int OVERRIDE_TOLERANCE_CHECKS;

				public int getOVERRIDE_TOLERANCE_CHECKS () {
					return this.OVERRIDE_TOLERANCE_CHECKS;
				}
				
			    public int AIC_STATUS;

				public int getAIC_STATUS () {
					return this.AIC_STATUS;
				}
				
			    public int BLEND_TOLERANCE_STATUS;

				public int getBLEND_TOLERANCE_STATUS () {
					return this.BLEND_TOLERANCE_STATUS;
				}
				
			    public int ADDITIVE_TOLERANCE_STATUS;

				public int getADDITIVE_TOLERANCE_STATUS () {
					return this.ADDITIVE_TOLERANCE_STATUS;
				}
				
			    public int AUTHORIZATION_REQUEST_ID;

				public int getAUTHORIZATION_REQUEST_ID () {
					return this.AUTHORIZATION_REQUEST_ID;
				}
				
			    public int TABS_ORDER_NUMBER;

				public int getTABS_ORDER_NUMBER () {
					return this.TABS_ORDER_NUMBER;
				}
				
			    public int FLAG_VALID_PRICE;

				public int getFLAG_VALID_PRICE () {
					return this.FLAG_VALID_PRICE;
				}
				
			    public int BOL_NUMBER;

				public int getBOL_NUMBER () {
					return this.BOL_NUMBER;
				}
				
			    public int COMPATIBILITY_STATUS;

				public int getCOMPATIBILITY_STATUS () {
					return this.COMPATIBILITY_STATUS;
				}
				
			    public int OVERRIDE_COMPATIBILITY_CHECKS;

				public int getOVERRIDE_COMPATIBILITY_CHECKS () {
					return this.OVERRIDE_COMPATIBILITY_CHECKS;
				}
				
			    public int CANCELLED_FROM_CBS;

				public int getCANCELLED_FROM_CBS () {
					return this.CANCELLED_FROM_CBS;
				}
				
			    public String HOST_REF_ID;

				public String getHOST_REF_ID () {
					return this.HOST_REF_ID;
				}
				
			    public int UNACCOUNTED_LIMIT_EXCEEDED;

				public int getUNACCOUNTED_LIMIT_EXCEEDED () {
					return this.UNACCOUNTED_LIMIT_EXCEEDED;
				}
				
			    public int OVERRIDE_UNACCOUNTED_CHECKS;

				public int getOVERRIDE_UNACCOUNTED_CHECKS () {
					return this.OVERRIDE_UNACCOUNTED_CHECKS;
				}
				
			    public int PENDING_PRINT_COUNT;

				public int getPENDING_PRINT_COUNT () {
					return this.PENDING_PRINT_COUNT;
				}
				
			    public int PENDING_REQUEST_COUNT;

				public int getPENDING_REQUEST_COUNT () {
					return this.PENDING_REQUEST_COUNT;
				}
				
			    public String PDXR_RACK_DRIVER_ID;

				public String getPDXR_RACK_DRIVER_ID () {
					return this.PDXR_RACK_DRIVER_ID;
				}
				
			    public String PDXR_TERMINAL_CONTROL_NUMBER;

				public String getPDXR_TERMINAL_CONTROL_NUMBER () {
					return this.PDXR_TERMINAL_CONTROL_NUMBER;
				}
				
			    public int PDXR_FINAL_SHIPPER_XCTN_SEQ;

				public int getPDXR_FINAL_SHIPPER_XCTN_SEQ () {
					return this.PDXR_FINAL_SHIPPER_XCTN_SEQ;
				}
				
			    public String PDXR_DESTINATION_STATE_CODE;

				public String getPDXR_DESTINATION_STATE_CODE () {
					return this.PDXR_DESTINATION_STATE_CODE;
				}
				
			    public String PDXR_DESTINATION_COUNTY;

				public String getPDXR_DESTINATION_COUNTY () {
					return this.PDXR_DESTINATION_COUNTY;
				}
				
			    public String PDXR_DESTINATION_CITY;

				public String getPDXR_DESTINATION_CITY () {
					return this.PDXR_DESTINATION_CITY;
				}
				
			    public String PDXR_DESTINATION_ZIP_CODE;

				public String getPDXR_DESTINATION_ZIP_CODE () {
					return this.PDXR_DESTINATION_ZIP_CODE;
				}
				
			    public String PDXR_CARRIER_FEIN;

				public String getPDXR_CARRIER_FEIN () {
					return this.PDXR_CARRIER_FEIN;
				}
				
			    public String PDXR_SHIPPER_INFO;

				public String getPDXR_SHIPPER_INFO () {
					return this.PDXR_SHIPPER_INFO;
				}
				
			    public int PDXR_VERSION;

				public int getPDXR_VERSION () {
					return this.PDXR_VERSION;
				}
				
			    public int PDXR_VENDOR;

				public int getPDXR_VENDOR () {
					return this.PDXR_VENDOR;
				}
				
			    public Integer ORIG_ORDER_ID;

				public Integer getORIG_ORDER_ID () {
					return this.ORIG_ORDER_ID;
				}
				
			    public Integer PREV_ORDER_ID;

				public Integer getPREV_ORDER_ID () {
					return this.PREV_ORDER_ID;
				}
				
			    public String SIGNATURE_PATH;

				public String getSIGNATURE_PATH () {
					return this.SIGNATURE_PATH;
				}
				
			    public String SIGNATURE_FILE_NAME;

				public String getSIGNATURE_FILE_NAME () {
					return this.SIGNATURE_FILE_NAME;
				}
				
			    public String PDXR_AUTHORIZING_SYSTEM;

				public String getPDXR_AUTHORIZING_SYSTEM () {
					return this.PDXR_AUTHORIZING_SYSTEM;
				}
				
			    public java.util.Date START_TIMESLOT_DATETIME;

				public java.util.Date getSTART_TIMESLOT_DATETIME () {
					return this.START_TIMESLOT_DATETIME;
				}
				
			    public java.util.Date END_TIMESLOT_DATETIME;

				public java.util.Date getEND_TIMESLOT_DATETIME () {
					return this.END_TIMESLOT_DATETIME;
				}
				
			    public java.util.Date START_PICKUP_DATETIME;

				public java.util.Date getSTART_PICKUP_DATETIME () {
					return this.START_PICKUP_DATETIME;
				}
				
			    public java.util.Date END_PICKUP_DATETIME;

				public java.util.Date getEND_PICKUP_DATETIME () {
					return this.END_PICKUP_DATETIME;
				}
				
			    public int ADMINISTRATIVE_BOOKING;

				public int getADMINISTRATIVE_BOOKING () {
					return this.ADMINISTRATIVE_BOOKING;
				}
				


	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PGS_STAGE_DIM_ORDERS.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_ORDERS.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_ORDERS = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_ORDERS = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PGS_STAGE_DIM_ORDERS, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_ORDERS, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PGS_STAGE_DIM_ORDERS.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_ORDERS.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_ORDERS = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_ORDERS = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PGS_STAGE_DIM_ORDERS, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_ORDERS, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_ORDERS) {

        	try {

        		int length = 0;
		
			        this.ORDER_ID = dis.readInt();
					
						this.LOADED_DRIVER_NUMBER = readInteger(dis);
					
					this.USER_NAME = readString(dis);
					
						this.TRAILER_CARRIER_NUMBER = readInteger(dis);
					
			        this.CARRIER_NUMBER = dis.readInt();
					
					this.TRAILER_CODE = readString(dis);
					
						this.VEHICLE_CARRIER_NUMBER = readInteger(dis);
					
					this.VEHICLE_CODE = readString(dis);
					
						this.TRACTOR_CARRIER_NUMBER = readInteger(dis);
					
						this.LOADED_CARRIER_NUMBER = readInteger(dis);
					
					this.FOLIO_NUMBER = readString(dis);
					
						this.TRACTOR_NUMBER = readInteger(dis);
					
						this.DELIVERED_CARRIER_NUMBER = readInteger(dis);
					
						this.DISPATCH_CARRIER_NUMBER = readInteger(dis);
					
						this.DELIVERED_DRIVER_NUMBER = readInteger(dis);
					
			        this.SUPPLIER_NUMBER = dis.readInt();
					
			        this.CUSTOMER_NUMBER = dis.readInt();
					
					this.TABS_CARRIER_ID = readString(dis);
					
			        this.DESTINATION_NUMBER = dis.readInt();
					
						this.TRIP_ID = readInteger(dis);
					
					this.TABS_TRUCK_NUMBER = readString(dis);
					
			        this.TYPE = dis.readInt();
					
					this.SHOST_SU_SUPPLIER_NUMBER = readString(dis);
					
			        this.CREATOR = dis.readInt();
					
			        this.EXCHANGE_ALLOCATION_ENABLED = dis.readInt();
					
			        this.MANUALLY_ENTERED = dis.readInt();
					
					this.SHOST_EX_EHOST_THRU_NUMBER = readString(dis);
					
			        this.DEST_ALLOCATION_ENABLED = dis.readInt();
					
					this.THOST_TH_SUPPLIER_NUMBER = readString(dis);
					
			        this.CUST_ALLOC_BY_PRODUCT = dis.readInt();
					
			        this.CUST_ALLOC_BY_COMPONENT = dis.readInt();
					
			        this.CUST_ALLOC_BY_COMP_GROUP = dis.readInt();
					
			        this.CREDIT_ENABLED = dis.readInt();
					
					this.THOST_EX_THOST_EXCH_NUMBER = readString(dis);
					
			        this.BILLING_TYPE = dis.readInt();
					
			        this.EXCH_ALLOC_BY_PRODUCT = dis.readInt();
					
			        this.EXCH_ALLOC_BY_PRODUCT_GROUP = dis.readInt();
					
			        this.CUSTOMER_ALLOCATION_ENABLED = dis.readInt();
					
					this.TABS_FINAL_SHIPPER_ID = readString(dis);
					
			        this.CUST_ALLOC_BY_PRODUCT_GROUP = dis.readInt();
					
			        this.MOVEMENT_NUMBER = dis.readInt();
					
			        this.REVISION_NUMBER = dis.readInt();
					
					this.TABS_SELLER_ID = readString(dis);
					
			        this.REVISED = dis.readInt();
					
					this.TABS_CONSIGNEE_NUMBER = readString(dis);
					
			        this.STATUS = dis.readInt();
					
					this.CHOST_CU_SUPPLIER_NUMBER = readString(dis);
					
					this.CHOST_CU_CUSTOMER_NUMBER = readString(dis);
					
					this.STATUS_DATE = readDate(dis);
					
					this.PURCHASE_ORDER_NUMBER = readString(dis);
					
					this.REQUISITION_NUMBER = readString(dis);
					
					this.BOL_COMMENT_1 = readString(dis);
					
					this.BOL_COMMENT_2 = readString(dis);
					
			        this.INVOICE_REQUIRED = dis.readInt();
					
					this.INVOICE_COMMENT_1 = readString(dis);
					
					this.INVOICE_COMMENT_2 = readString(dis);
					
			        this.INVOICE_PRINTED = dis.readInt();
					
					this.DESTINATION_COMMENT_1 = readString(dis);
					
					this.DESTINATION_COMMENT_2 = readString(dis);
					
			        this.TABS_SUBSCRIBER = dis.readInt();
					
					this.REMARKS = readString(dis);
					
					this.START_LOAD_TIME = readDate(dis);
					
					this.END_LOAD_TIME = readDate(dis);
					
			        this.DELIVERY_FEE = dis.readDouble();
					
					this.TABS_AUTHORIZATION_NUMBER = readString(dis);
					
						this.THRUPUTTER_NUMBER = readInteger(dis);
					
					this.LAST_USER_NAME = readString(dis);
					
					this.LAST_MODIFIED = readDate(dis);
					
			        this.BOL_PRINTED = dis.readInt();
					
					this.ORDER_ENTRY_TIME = readDate(dis);
					
			        this.BILL_FREIGHT = dis.readInt();
					
					this.DELIVERY_DATE = readDate(dis);
					
			        this.SHIFT = dis.readInt();
					
			        this.STOP = dis.readInt();
					
			        this.DELIVERY_CONFIRMED = dis.readInt();
					
					this.VALIDATING_NODE_NAME = readString(dis);
					
			        this.HOST_PROCESSED = dis.readInt();
					
					this.PETROEX_COMPANY_CODE = readString(dis);
					
					this.PETROEX_CONSIGNEE_NUMBER = readString(dis);
					
					this.PETROEX_THIRD_PARTY = readString(dis);
					
					this.PETROEX_CARRIER_CODE = readString(dis);
					
			        this.PETROEX_TRUCK_NUMBER = dis.readInt();
					
			        this.PETROEX_SUBSCRIBER = dis.readInt();
					
					this.FAN_COMMENT_1 = readString(dis);
					
			        this.PETROEX_CITY_CODE = dis.readInt();
					
					this.FAN_COMMENT_2 = readString(dis);
					
			        this.PETROEX_COUNTY_CODE = dis.readInt();
					
			        this.PRELOAD_ORDER = dis.readInt();
					
			        this.PETROEX_STATE_CODE = dis.readInt();
					
			        this.CONTRACT_ALLOCATION_ENABLED = dis.readInt();
					
					this.PETROEX_FEIN = readString(dis);
					
			        this.ELVIS_ORDER_NUMBER = dis.readInt();
					
					this.PETROEX_SHIPPER_INFO = readString(dis);
					
					this.ELVIS_LOADSPOT_ID = readString(dis);
					
					this.PETROEX_VEHICLE_TYPE = readString(dis);
					
			        this.OVERWEIGHT_TRAILER = dis.readInt();
					
			        this.ELVIS_AUTHORIZED = dis.readInt();
					
			        this.DISPATCHED_WITH_TRAILER = dis.readInt();
					
			        this.DISPATCHED_WITH_DRIVER = dis.readInt();
					
			        this.COMMITTED_PRICE = dis.readDouble();
					
			        this.LOADED_PRICE = dis.readDouble();
					
					this.CONTRACT_NUMBER = readString(dis);
					
			        this.MANUALLY_COMPLETED = dis.readInt();
					
			        this.OVERRIDE_TOLERANCE_CHECKS = dis.readInt();
					
			        this.AIC_STATUS = dis.readInt();
					
			        this.BLEND_TOLERANCE_STATUS = dis.readInt();
					
			        this.ADDITIVE_TOLERANCE_STATUS = dis.readInt();
					
			        this.AUTHORIZATION_REQUEST_ID = dis.readInt();
					
			        this.TABS_ORDER_NUMBER = dis.readInt();
					
			        this.FLAG_VALID_PRICE = dis.readInt();
					
			        this.BOL_NUMBER = dis.readInt();
					
			        this.COMPATIBILITY_STATUS = dis.readInt();
					
			        this.OVERRIDE_COMPATIBILITY_CHECKS = dis.readInt();
					
			        this.CANCELLED_FROM_CBS = dis.readInt();
					
					this.HOST_REF_ID = readString(dis);
					
			        this.UNACCOUNTED_LIMIT_EXCEEDED = dis.readInt();
					
			        this.OVERRIDE_UNACCOUNTED_CHECKS = dis.readInt();
					
			        this.PENDING_PRINT_COUNT = dis.readInt();
					
			        this.PENDING_REQUEST_COUNT = dis.readInt();
					
					this.PDXR_RACK_DRIVER_ID = readString(dis);
					
					this.PDXR_TERMINAL_CONTROL_NUMBER = readString(dis);
					
			        this.PDXR_FINAL_SHIPPER_XCTN_SEQ = dis.readInt();
					
					this.PDXR_DESTINATION_STATE_CODE = readString(dis);
					
					this.PDXR_DESTINATION_COUNTY = readString(dis);
					
					this.PDXR_DESTINATION_CITY = readString(dis);
					
					this.PDXR_DESTINATION_ZIP_CODE = readString(dis);
					
					this.PDXR_CARRIER_FEIN = readString(dis);
					
					this.PDXR_SHIPPER_INFO = readString(dis);
					
			        this.PDXR_VERSION = dis.readInt();
					
			        this.PDXR_VENDOR = dis.readInt();
					
						this.ORIG_ORDER_ID = readInteger(dis);
					
						this.PREV_ORDER_ID = readInteger(dis);
					
					this.SIGNATURE_PATH = readString(dis);
					
					this.SIGNATURE_FILE_NAME = readString(dis);
					
					this.PDXR_AUTHORIZING_SYSTEM = readString(dis);
					
					this.START_TIMESLOT_DATETIME = readDate(dis);
					
					this.END_TIMESLOT_DATETIME = readDate(dis);
					
					this.START_PICKUP_DATETIME = readDate(dis);
					
					this.END_PICKUP_DATETIME = readDate(dis);
					
			        this.ADMINISTRATIVE_BOOKING = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_ORDERS) {

        	try {

        		int length = 0;
		
			        this.ORDER_ID = dis.readInt();
					
						this.LOADED_DRIVER_NUMBER = readInteger(dis);
					
					this.USER_NAME = readString(dis);
					
						this.TRAILER_CARRIER_NUMBER = readInteger(dis);
					
			        this.CARRIER_NUMBER = dis.readInt();
					
					this.TRAILER_CODE = readString(dis);
					
						this.VEHICLE_CARRIER_NUMBER = readInteger(dis);
					
					this.VEHICLE_CODE = readString(dis);
					
						this.TRACTOR_CARRIER_NUMBER = readInteger(dis);
					
						this.LOADED_CARRIER_NUMBER = readInteger(dis);
					
					this.FOLIO_NUMBER = readString(dis);
					
						this.TRACTOR_NUMBER = readInteger(dis);
					
						this.DELIVERED_CARRIER_NUMBER = readInteger(dis);
					
						this.DISPATCH_CARRIER_NUMBER = readInteger(dis);
					
						this.DELIVERED_DRIVER_NUMBER = readInteger(dis);
					
			        this.SUPPLIER_NUMBER = dis.readInt();
					
			        this.CUSTOMER_NUMBER = dis.readInt();
					
					this.TABS_CARRIER_ID = readString(dis);
					
			        this.DESTINATION_NUMBER = dis.readInt();
					
						this.TRIP_ID = readInteger(dis);
					
					this.TABS_TRUCK_NUMBER = readString(dis);
					
			        this.TYPE = dis.readInt();
					
					this.SHOST_SU_SUPPLIER_NUMBER = readString(dis);
					
			        this.CREATOR = dis.readInt();
					
			        this.EXCHANGE_ALLOCATION_ENABLED = dis.readInt();
					
			        this.MANUALLY_ENTERED = dis.readInt();
					
					this.SHOST_EX_EHOST_THRU_NUMBER = readString(dis);
					
			        this.DEST_ALLOCATION_ENABLED = dis.readInt();
					
					this.THOST_TH_SUPPLIER_NUMBER = readString(dis);
					
			        this.CUST_ALLOC_BY_PRODUCT = dis.readInt();
					
			        this.CUST_ALLOC_BY_COMPONENT = dis.readInt();
					
			        this.CUST_ALLOC_BY_COMP_GROUP = dis.readInt();
					
			        this.CREDIT_ENABLED = dis.readInt();
					
					this.THOST_EX_THOST_EXCH_NUMBER = readString(dis);
					
			        this.BILLING_TYPE = dis.readInt();
					
			        this.EXCH_ALLOC_BY_PRODUCT = dis.readInt();
					
			        this.EXCH_ALLOC_BY_PRODUCT_GROUP = dis.readInt();
					
			        this.CUSTOMER_ALLOCATION_ENABLED = dis.readInt();
					
					this.TABS_FINAL_SHIPPER_ID = readString(dis);
					
			        this.CUST_ALLOC_BY_PRODUCT_GROUP = dis.readInt();
					
			        this.MOVEMENT_NUMBER = dis.readInt();
					
			        this.REVISION_NUMBER = dis.readInt();
					
					this.TABS_SELLER_ID = readString(dis);
					
			        this.REVISED = dis.readInt();
					
					this.TABS_CONSIGNEE_NUMBER = readString(dis);
					
			        this.STATUS = dis.readInt();
					
					this.CHOST_CU_SUPPLIER_NUMBER = readString(dis);
					
					this.CHOST_CU_CUSTOMER_NUMBER = readString(dis);
					
					this.STATUS_DATE = readDate(dis);
					
					this.PURCHASE_ORDER_NUMBER = readString(dis);
					
					this.REQUISITION_NUMBER = readString(dis);
					
					this.BOL_COMMENT_1 = readString(dis);
					
					this.BOL_COMMENT_2 = readString(dis);
					
			        this.INVOICE_REQUIRED = dis.readInt();
					
					this.INVOICE_COMMENT_1 = readString(dis);
					
					this.INVOICE_COMMENT_2 = readString(dis);
					
			        this.INVOICE_PRINTED = dis.readInt();
					
					this.DESTINATION_COMMENT_1 = readString(dis);
					
					this.DESTINATION_COMMENT_2 = readString(dis);
					
			        this.TABS_SUBSCRIBER = dis.readInt();
					
					this.REMARKS = readString(dis);
					
					this.START_LOAD_TIME = readDate(dis);
					
					this.END_LOAD_TIME = readDate(dis);
					
			        this.DELIVERY_FEE = dis.readDouble();
					
					this.TABS_AUTHORIZATION_NUMBER = readString(dis);
					
						this.THRUPUTTER_NUMBER = readInteger(dis);
					
					this.LAST_USER_NAME = readString(dis);
					
					this.LAST_MODIFIED = readDate(dis);
					
			        this.BOL_PRINTED = dis.readInt();
					
					this.ORDER_ENTRY_TIME = readDate(dis);
					
			        this.BILL_FREIGHT = dis.readInt();
					
					this.DELIVERY_DATE = readDate(dis);
					
			        this.SHIFT = dis.readInt();
					
			        this.STOP = dis.readInt();
					
			        this.DELIVERY_CONFIRMED = dis.readInt();
					
					this.VALIDATING_NODE_NAME = readString(dis);
					
			        this.HOST_PROCESSED = dis.readInt();
					
					this.PETROEX_COMPANY_CODE = readString(dis);
					
					this.PETROEX_CONSIGNEE_NUMBER = readString(dis);
					
					this.PETROEX_THIRD_PARTY = readString(dis);
					
					this.PETROEX_CARRIER_CODE = readString(dis);
					
			        this.PETROEX_TRUCK_NUMBER = dis.readInt();
					
			        this.PETROEX_SUBSCRIBER = dis.readInt();
					
					this.FAN_COMMENT_1 = readString(dis);
					
			        this.PETROEX_CITY_CODE = dis.readInt();
					
					this.FAN_COMMENT_2 = readString(dis);
					
			        this.PETROEX_COUNTY_CODE = dis.readInt();
					
			        this.PRELOAD_ORDER = dis.readInt();
					
			        this.PETROEX_STATE_CODE = dis.readInt();
					
			        this.CONTRACT_ALLOCATION_ENABLED = dis.readInt();
					
					this.PETROEX_FEIN = readString(dis);
					
			        this.ELVIS_ORDER_NUMBER = dis.readInt();
					
					this.PETROEX_SHIPPER_INFO = readString(dis);
					
					this.ELVIS_LOADSPOT_ID = readString(dis);
					
					this.PETROEX_VEHICLE_TYPE = readString(dis);
					
			        this.OVERWEIGHT_TRAILER = dis.readInt();
					
			        this.ELVIS_AUTHORIZED = dis.readInt();
					
			        this.DISPATCHED_WITH_TRAILER = dis.readInt();
					
			        this.DISPATCHED_WITH_DRIVER = dis.readInt();
					
			        this.COMMITTED_PRICE = dis.readDouble();
					
			        this.LOADED_PRICE = dis.readDouble();
					
					this.CONTRACT_NUMBER = readString(dis);
					
			        this.MANUALLY_COMPLETED = dis.readInt();
					
			        this.OVERRIDE_TOLERANCE_CHECKS = dis.readInt();
					
			        this.AIC_STATUS = dis.readInt();
					
			        this.BLEND_TOLERANCE_STATUS = dis.readInt();
					
			        this.ADDITIVE_TOLERANCE_STATUS = dis.readInt();
					
			        this.AUTHORIZATION_REQUEST_ID = dis.readInt();
					
			        this.TABS_ORDER_NUMBER = dis.readInt();
					
			        this.FLAG_VALID_PRICE = dis.readInt();
					
			        this.BOL_NUMBER = dis.readInt();
					
			        this.COMPATIBILITY_STATUS = dis.readInt();
					
			        this.OVERRIDE_COMPATIBILITY_CHECKS = dis.readInt();
					
			        this.CANCELLED_FROM_CBS = dis.readInt();
					
					this.HOST_REF_ID = readString(dis);
					
			        this.UNACCOUNTED_LIMIT_EXCEEDED = dis.readInt();
					
			        this.OVERRIDE_UNACCOUNTED_CHECKS = dis.readInt();
					
			        this.PENDING_PRINT_COUNT = dis.readInt();
					
			        this.PENDING_REQUEST_COUNT = dis.readInt();
					
					this.PDXR_RACK_DRIVER_ID = readString(dis);
					
					this.PDXR_TERMINAL_CONTROL_NUMBER = readString(dis);
					
			        this.PDXR_FINAL_SHIPPER_XCTN_SEQ = dis.readInt();
					
					this.PDXR_DESTINATION_STATE_CODE = readString(dis);
					
					this.PDXR_DESTINATION_COUNTY = readString(dis);
					
					this.PDXR_DESTINATION_CITY = readString(dis);
					
					this.PDXR_DESTINATION_ZIP_CODE = readString(dis);
					
					this.PDXR_CARRIER_FEIN = readString(dis);
					
					this.PDXR_SHIPPER_INFO = readString(dis);
					
			        this.PDXR_VERSION = dis.readInt();
					
			        this.PDXR_VENDOR = dis.readInt();
					
						this.ORIG_ORDER_ID = readInteger(dis);
					
						this.PREV_ORDER_ID = readInteger(dis);
					
					this.SIGNATURE_PATH = readString(dis);
					
					this.SIGNATURE_FILE_NAME = readString(dis);
					
					this.PDXR_AUTHORIZING_SYSTEM = readString(dis);
					
					this.START_TIMESLOT_DATETIME = readDate(dis);
					
					this.END_TIMESLOT_DATETIME = readDate(dis);
					
					this.START_PICKUP_DATETIME = readDate(dis);
					
					this.END_PICKUP_DATETIME = readDate(dis);
					
			        this.ADMINISTRATIVE_BOOKING = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.ORDER_ID);
					
					// Integer
				
						writeInteger(this.LOADED_DRIVER_NUMBER,dos);
					
					// String
				
						writeString(this.USER_NAME,dos);
					
					// Integer
				
						writeInteger(this.TRAILER_CARRIER_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.CARRIER_NUMBER);
					
					// String
				
						writeString(this.TRAILER_CODE,dos);
					
					// Integer
				
						writeInteger(this.VEHICLE_CARRIER_NUMBER,dos);
					
					// String
				
						writeString(this.VEHICLE_CODE,dos);
					
					// Integer
				
						writeInteger(this.TRACTOR_CARRIER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.LOADED_CARRIER_NUMBER,dos);
					
					// String
				
						writeString(this.FOLIO_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.TRACTOR_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.DELIVERED_CARRIER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.DISPATCH_CARRIER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.DELIVERED_DRIVER_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.SUPPLIER_NUMBER);
					
					// int
				
		            	dos.writeInt(this.CUSTOMER_NUMBER);
					
					// String
				
						writeString(this.TABS_CARRIER_ID,dos);
					
					// int
				
		            	dos.writeInt(this.DESTINATION_NUMBER);
					
					// Integer
				
						writeInteger(this.TRIP_ID,dos);
					
					// String
				
						writeString(this.TABS_TRUCK_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.TYPE);
					
					// String
				
						writeString(this.SHOST_SU_SUPPLIER_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.CREATOR);
					
					// int
				
		            	dos.writeInt(this.EXCHANGE_ALLOCATION_ENABLED);
					
					// int
				
		            	dos.writeInt(this.MANUALLY_ENTERED);
					
					// String
				
						writeString(this.SHOST_EX_EHOST_THRU_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.DEST_ALLOCATION_ENABLED);
					
					// String
				
						writeString(this.THOST_TH_SUPPLIER_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.CUST_ALLOC_BY_PRODUCT);
					
					// int
				
		            	dos.writeInt(this.CUST_ALLOC_BY_COMPONENT);
					
					// int
				
		            	dos.writeInt(this.CUST_ALLOC_BY_COMP_GROUP);
					
					// int
				
		            	dos.writeInt(this.CREDIT_ENABLED);
					
					// String
				
						writeString(this.THOST_EX_THOST_EXCH_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.BILLING_TYPE);
					
					// int
				
		            	dos.writeInt(this.EXCH_ALLOC_BY_PRODUCT);
					
					// int
				
		            	dos.writeInt(this.EXCH_ALLOC_BY_PRODUCT_GROUP);
					
					// int
				
		            	dos.writeInt(this.CUSTOMER_ALLOCATION_ENABLED);
					
					// String
				
						writeString(this.TABS_FINAL_SHIPPER_ID,dos);
					
					// int
				
		            	dos.writeInt(this.CUST_ALLOC_BY_PRODUCT_GROUP);
					
					// int
				
		            	dos.writeInt(this.MOVEMENT_NUMBER);
					
					// int
				
		            	dos.writeInt(this.REVISION_NUMBER);
					
					// String
				
						writeString(this.TABS_SELLER_ID,dos);
					
					// int
				
		            	dos.writeInt(this.REVISED);
					
					// String
				
						writeString(this.TABS_CONSIGNEE_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.STATUS);
					
					// String
				
						writeString(this.CHOST_CU_SUPPLIER_NUMBER,dos);
					
					// String
				
						writeString(this.CHOST_CU_CUSTOMER_NUMBER,dos);
					
					// java.util.Date
				
						writeDate(this.STATUS_DATE,dos);
					
					// String
				
						writeString(this.PURCHASE_ORDER_NUMBER,dos);
					
					// String
				
						writeString(this.REQUISITION_NUMBER,dos);
					
					// String
				
						writeString(this.BOL_COMMENT_1,dos);
					
					// String
				
						writeString(this.BOL_COMMENT_2,dos);
					
					// int
				
		            	dos.writeInt(this.INVOICE_REQUIRED);
					
					// String
				
						writeString(this.INVOICE_COMMENT_1,dos);
					
					// String
				
						writeString(this.INVOICE_COMMENT_2,dos);
					
					// int
				
		            	dos.writeInt(this.INVOICE_PRINTED);
					
					// String
				
						writeString(this.DESTINATION_COMMENT_1,dos);
					
					// String
				
						writeString(this.DESTINATION_COMMENT_2,dos);
					
					// int
				
		            	dos.writeInt(this.TABS_SUBSCRIBER);
					
					// String
				
						writeString(this.REMARKS,dos);
					
					// java.util.Date
				
						writeDate(this.START_LOAD_TIME,dos);
					
					// java.util.Date
				
						writeDate(this.END_LOAD_TIME,dos);
					
					// double
				
		            	dos.writeDouble(this.DELIVERY_FEE);
					
					// String
				
						writeString(this.TABS_AUTHORIZATION_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.THRUPUTTER_NUMBER,dos);
					
					// String
				
						writeString(this.LAST_USER_NAME,dos);
					
					// java.util.Date
				
						writeDate(this.LAST_MODIFIED,dos);
					
					// int
				
		            	dos.writeInt(this.BOL_PRINTED);
					
					// java.util.Date
				
						writeDate(this.ORDER_ENTRY_TIME,dos);
					
					// int
				
		            	dos.writeInt(this.BILL_FREIGHT);
					
					// java.util.Date
				
						writeDate(this.DELIVERY_DATE,dos);
					
					// int
				
		            	dos.writeInt(this.SHIFT);
					
					// int
				
		            	dos.writeInt(this.STOP);
					
					// int
				
		            	dos.writeInt(this.DELIVERY_CONFIRMED);
					
					// String
				
						writeString(this.VALIDATING_NODE_NAME,dos);
					
					// int
				
		            	dos.writeInt(this.HOST_PROCESSED);
					
					// String
				
						writeString(this.PETROEX_COMPANY_CODE,dos);
					
					// String
				
						writeString(this.PETROEX_CONSIGNEE_NUMBER,dos);
					
					// String
				
						writeString(this.PETROEX_THIRD_PARTY,dos);
					
					// String
				
						writeString(this.PETROEX_CARRIER_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.PETROEX_TRUCK_NUMBER);
					
					// int
				
		            	dos.writeInt(this.PETROEX_SUBSCRIBER);
					
					// String
				
						writeString(this.FAN_COMMENT_1,dos);
					
					// int
				
		            	dos.writeInt(this.PETROEX_CITY_CODE);
					
					// String
				
						writeString(this.FAN_COMMENT_2,dos);
					
					// int
				
		            	dos.writeInt(this.PETROEX_COUNTY_CODE);
					
					// int
				
		            	dos.writeInt(this.PRELOAD_ORDER);
					
					// int
				
		            	dos.writeInt(this.PETROEX_STATE_CODE);
					
					// int
				
		            	dos.writeInt(this.CONTRACT_ALLOCATION_ENABLED);
					
					// String
				
						writeString(this.PETROEX_FEIN,dos);
					
					// int
				
		            	dos.writeInt(this.ELVIS_ORDER_NUMBER);
					
					// String
				
						writeString(this.PETROEX_SHIPPER_INFO,dos);
					
					// String
				
						writeString(this.ELVIS_LOADSPOT_ID,dos);
					
					// String
				
						writeString(this.PETROEX_VEHICLE_TYPE,dos);
					
					// int
				
		            	dos.writeInt(this.OVERWEIGHT_TRAILER);
					
					// int
				
		            	dos.writeInt(this.ELVIS_AUTHORIZED);
					
					// int
				
		            	dos.writeInt(this.DISPATCHED_WITH_TRAILER);
					
					// int
				
		            	dos.writeInt(this.DISPATCHED_WITH_DRIVER);
					
					// double
				
		            	dos.writeDouble(this.COMMITTED_PRICE);
					
					// double
				
		            	dos.writeDouble(this.LOADED_PRICE);
					
					// String
				
						writeString(this.CONTRACT_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.MANUALLY_COMPLETED);
					
					// int
				
		            	dos.writeInt(this.OVERRIDE_TOLERANCE_CHECKS);
					
					// int
				
		            	dos.writeInt(this.AIC_STATUS);
					
					// int
				
		            	dos.writeInt(this.BLEND_TOLERANCE_STATUS);
					
					// int
				
		            	dos.writeInt(this.ADDITIVE_TOLERANCE_STATUS);
					
					// int
				
		            	dos.writeInt(this.AUTHORIZATION_REQUEST_ID);
					
					// int
				
		            	dos.writeInt(this.TABS_ORDER_NUMBER);
					
					// int
				
		            	dos.writeInt(this.FLAG_VALID_PRICE);
					
					// int
				
		            	dos.writeInt(this.BOL_NUMBER);
					
					// int
				
		            	dos.writeInt(this.COMPATIBILITY_STATUS);
					
					// int
				
		            	dos.writeInt(this.OVERRIDE_COMPATIBILITY_CHECKS);
					
					// int
				
		            	dos.writeInt(this.CANCELLED_FROM_CBS);
					
					// String
				
						writeString(this.HOST_REF_ID,dos);
					
					// int
				
		            	dos.writeInt(this.UNACCOUNTED_LIMIT_EXCEEDED);
					
					// int
				
		            	dos.writeInt(this.OVERRIDE_UNACCOUNTED_CHECKS);
					
					// int
				
		            	dos.writeInt(this.PENDING_PRINT_COUNT);
					
					// int
				
		            	dos.writeInt(this.PENDING_REQUEST_COUNT);
					
					// String
				
						writeString(this.PDXR_RACK_DRIVER_ID,dos);
					
					// String
				
						writeString(this.PDXR_TERMINAL_CONTROL_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.PDXR_FINAL_SHIPPER_XCTN_SEQ);
					
					// String
				
						writeString(this.PDXR_DESTINATION_STATE_CODE,dos);
					
					// String
				
						writeString(this.PDXR_DESTINATION_COUNTY,dos);
					
					// String
				
						writeString(this.PDXR_DESTINATION_CITY,dos);
					
					// String
				
						writeString(this.PDXR_DESTINATION_ZIP_CODE,dos);
					
					// String
				
						writeString(this.PDXR_CARRIER_FEIN,dos);
					
					// String
				
						writeString(this.PDXR_SHIPPER_INFO,dos);
					
					// int
				
		            	dos.writeInt(this.PDXR_VERSION);
					
					// int
				
		            	dos.writeInt(this.PDXR_VENDOR);
					
					// Integer
				
						writeInteger(this.ORIG_ORDER_ID,dos);
					
					// Integer
				
						writeInteger(this.PREV_ORDER_ID,dos);
					
					// String
				
						writeString(this.SIGNATURE_PATH,dos);
					
					// String
				
						writeString(this.SIGNATURE_FILE_NAME,dos);
					
					// String
				
						writeString(this.PDXR_AUTHORIZING_SYSTEM,dos);
					
					// java.util.Date
				
						writeDate(this.START_TIMESLOT_DATETIME,dos);
					
					// java.util.Date
				
						writeDate(this.END_TIMESLOT_DATETIME,dos);
					
					// java.util.Date
				
						writeDate(this.START_PICKUP_DATETIME,dos);
					
					// java.util.Date
				
						writeDate(this.END_PICKUP_DATETIME,dos);
					
					// int
				
		            	dos.writeInt(this.ADMINISTRATIVE_BOOKING);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.ORDER_ID);
					
					// Integer
				
						writeInteger(this.LOADED_DRIVER_NUMBER,dos);
					
					// String
				
						writeString(this.USER_NAME,dos);
					
					// Integer
				
						writeInteger(this.TRAILER_CARRIER_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.CARRIER_NUMBER);
					
					// String
				
						writeString(this.TRAILER_CODE,dos);
					
					// Integer
				
						writeInteger(this.VEHICLE_CARRIER_NUMBER,dos);
					
					// String
				
						writeString(this.VEHICLE_CODE,dos);
					
					// Integer
				
						writeInteger(this.TRACTOR_CARRIER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.LOADED_CARRIER_NUMBER,dos);
					
					// String
				
						writeString(this.FOLIO_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.TRACTOR_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.DELIVERED_CARRIER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.DISPATCH_CARRIER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.DELIVERED_DRIVER_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.SUPPLIER_NUMBER);
					
					// int
				
		            	dos.writeInt(this.CUSTOMER_NUMBER);
					
					// String
				
						writeString(this.TABS_CARRIER_ID,dos);
					
					// int
				
		            	dos.writeInt(this.DESTINATION_NUMBER);
					
					// Integer
				
						writeInteger(this.TRIP_ID,dos);
					
					// String
				
						writeString(this.TABS_TRUCK_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.TYPE);
					
					// String
				
						writeString(this.SHOST_SU_SUPPLIER_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.CREATOR);
					
					// int
				
		            	dos.writeInt(this.EXCHANGE_ALLOCATION_ENABLED);
					
					// int
				
		            	dos.writeInt(this.MANUALLY_ENTERED);
					
					// String
				
						writeString(this.SHOST_EX_EHOST_THRU_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.DEST_ALLOCATION_ENABLED);
					
					// String
				
						writeString(this.THOST_TH_SUPPLIER_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.CUST_ALLOC_BY_PRODUCT);
					
					// int
				
		            	dos.writeInt(this.CUST_ALLOC_BY_COMPONENT);
					
					// int
				
		            	dos.writeInt(this.CUST_ALLOC_BY_COMP_GROUP);
					
					// int
				
		            	dos.writeInt(this.CREDIT_ENABLED);
					
					// String
				
						writeString(this.THOST_EX_THOST_EXCH_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.BILLING_TYPE);
					
					// int
				
		            	dos.writeInt(this.EXCH_ALLOC_BY_PRODUCT);
					
					// int
				
		            	dos.writeInt(this.EXCH_ALLOC_BY_PRODUCT_GROUP);
					
					// int
				
		            	dos.writeInt(this.CUSTOMER_ALLOCATION_ENABLED);
					
					// String
				
						writeString(this.TABS_FINAL_SHIPPER_ID,dos);
					
					// int
				
		            	dos.writeInt(this.CUST_ALLOC_BY_PRODUCT_GROUP);
					
					// int
				
		            	dos.writeInt(this.MOVEMENT_NUMBER);
					
					// int
				
		            	dos.writeInt(this.REVISION_NUMBER);
					
					// String
				
						writeString(this.TABS_SELLER_ID,dos);
					
					// int
				
		            	dos.writeInt(this.REVISED);
					
					// String
				
						writeString(this.TABS_CONSIGNEE_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.STATUS);
					
					// String
				
						writeString(this.CHOST_CU_SUPPLIER_NUMBER,dos);
					
					// String
				
						writeString(this.CHOST_CU_CUSTOMER_NUMBER,dos);
					
					// java.util.Date
				
						writeDate(this.STATUS_DATE,dos);
					
					// String
				
						writeString(this.PURCHASE_ORDER_NUMBER,dos);
					
					// String
				
						writeString(this.REQUISITION_NUMBER,dos);
					
					// String
				
						writeString(this.BOL_COMMENT_1,dos);
					
					// String
				
						writeString(this.BOL_COMMENT_2,dos);
					
					// int
				
		            	dos.writeInt(this.INVOICE_REQUIRED);
					
					// String
				
						writeString(this.INVOICE_COMMENT_1,dos);
					
					// String
				
						writeString(this.INVOICE_COMMENT_2,dos);
					
					// int
				
		            	dos.writeInt(this.INVOICE_PRINTED);
					
					// String
				
						writeString(this.DESTINATION_COMMENT_1,dos);
					
					// String
				
						writeString(this.DESTINATION_COMMENT_2,dos);
					
					// int
				
		            	dos.writeInt(this.TABS_SUBSCRIBER);
					
					// String
				
						writeString(this.REMARKS,dos);
					
					// java.util.Date
				
						writeDate(this.START_LOAD_TIME,dos);
					
					// java.util.Date
				
						writeDate(this.END_LOAD_TIME,dos);
					
					// double
				
		            	dos.writeDouble(this.DELIVERY_FEE);
					
					// String
				
						writeString(this.TABS_AUTHORIZATION_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.THRUPUTTER_NUMBER,dos);
					
					// String
				
						writeString(this.LAST_USER_NAME,dos);
					
					// java.util.Date
				
						writeDate(this.LAST_MODIFIED,dos);
					
					// int
				
		            	dos.writeInt(this.BOL_PRINTED);
					
					// java.util.Date
				
						writeDate(this.ORDER_ENTRY_TIME,dos);
					
					// int
				
		            	dos.writeInt(this.BILL_FREIGHT);
					
					// java.util.Date
				
						writeDate(this.DELIVERY_DATE,dos);
					
					// int
				
		            	dos.writeInt(this.SHIFT);
					
					// int
				
		            	dos.writeInt(this.STOP);
					
					// int
				
		            	dos.writeInt(this.DELIVERY_CONFIRMED);
					
					// String
				
						writeString(this.VALIDATING_NODE_NAME,dos);
					
					// int
				
		            	dos.writeInt(this.HOST_PROCESSED);
					
					// String
				
						writeString(this.PETROEX_COMPANY_CODE,dos);
					
					// String
				
						writeString(this.PETROEX_CONSIGNEE_NUMBER,dos);
					
					// String
				
						writeString(this.PETROEX_THIRD_PARTY,dos);
					
					// String
				
						writeString(this.PETROEX_CARRIER_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.PETROEX_TRUCK_NUMBER);
					
					// int
				
		            	dos.writeInt(this.PETROEX_SUBSCRIBER);
					
					// String
				
						writeString(this.FAN_COMMENT_1,dos);
					
					// int
				
		            	dos.writeInt(this.PETROEX_CITY_CODE);
					
					// String
				
						writeString(this.FAN_COMMENT_2,dos);
					
					// int
				
		            	dos.writeInt(this.PETROEX_COUNTY_CODE);
					
					// int
				
		            	dos.writeInt(this.PRELOAD_ORDER);
					
					// int
				
		            	dos.writeInt(this.PETROEX_STATE_CODE);
					
					// int
				
		            	dos.writeInt(this.CONTRACT_ALLOCATION_ENABLED);
					
					// String
				
						writeString(this.PETROEX_FEIN,dos);
					
					// int
				
		            	dos.writeInt(this.ELVIS_ORDER_NUMBER);
					
					// String
				
						writeString(this.PETROEX_SHIPPER_INFO,dos);
					
					// String
				
						writeString(this.ELVIS_LOADSPOT_ID,dos);
					
					// String
				
						writeString(this.PETROEX_VEHICLE_TYPE,dos);
					
					// int
				
		            	dos.writeInt(this.OVERWEIGHT_TRAILER);
					
					// int
				
		            	dos.writeInt(this.ELVIS_AUTHORIZED);
					
					// int
				
		            	dos.writeInt(this.DISPATCHED_WITH_TRAILER);
					
					// int
				
		            	dos.writeInt(this.DISPATCHED_WITH_DRIVER);
					
					// double
				
		            	dos.writeDouble(this.COMMITTED_PRICE);
					
					// double
				
		            	dos.writeDouble(this.LOADED_PRICE);
					
					// String
				
						writeString(this.CONTRACT_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.MANUALLY_COMPLETED);
					
					// int
				
		            	dos.writeInt(this.OVERRIDE_TOLERANCE_CHECKS);
					
					// int
				
		            	dos.writeInt(this.AIC_STATUS);
					
					// int
				
		            	dos.writeInt(this.BLEND_TOLERANCE_STATUS);
					
					// int
				
		            	dos.writeInt(this.ADDITIVE_TOLERANCE_STATUS);
					
					// int
				
		            	dos.writeInt(this.AUTHORIZATION_REQUEST_ID);
					
					// int
				
		            	dos.writeInt(this.TABS_ORDER_NUMBER);
					
					// int
				
		            	dos.writeInt(this.FLAG_VALID_PRICE);
					
					// int
				
		            	dos.writeInt(this.BOL_NUMBER);
					
					// int
				
		            	dos.writeInt(this.COMPATIBILITY_STATUS);
					
					// int
				
		            	dos.writeInt(this.OVERRIDE_COMPATIBILITY_CHECKS);
					
					// int
				
		            	dos.writeInt(this.CANCELLED_FROM_CBS);
					
					// String
				
						writeString(this.HOST_REF_ID,dos);
					
					// int
				
		            	dos.writeInt(this.UNACCOUNTED_LIMIT_EXCEEDED);
					
					// int
				
		            	dos.writeInt(this.OVERRIDE_UNACCOUNTED_CHECKS);
					
					// int
				
		            	dos.writeInt(this.PENDING_PRINT_COUNT);
					
					// int
				
		            	dos.writeInt(this.PENDING_REQUEST_COUNT);
					
					// String
				
						writeString(this.PDXR_RACK_DRIVER_ID,dos);
					
					// String
				
						writeString(this.PDXR_TERMINAL_CONTROL_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.PDXR_FINAL_SHIPPER_XCTN_SEQ);
					
					// String
				
						writeString(this.PDXR_DESTINATION_STATE_CODE,dos);
					
					// String
				
						writeString(this.PDXR_DESTINATION_COUNTY,dos);
					
					// String
				
						writeString(this.PDXR_DESTINATION_CITY,dos);
					
					// String
				
						writeString(this.PDXR_DESTINATION_ZIP_CODE,dos);
					
					// String
				
						writeString(this.PDXR_CARRIER_FEIN,dos);
					
					// String
				
						writeString(this.PDXR_SHIPPER_INFO,dos);
					
					// int
				
		            	dos.writeInt(this.PDXR_VERSION);
					
					// int
				
		            	dos.writeInt(this.PDXR_VENDOR);
					
					// Integer
				
						writeInteger(this.ORIG_ORDER_ID,dos);
					
					// Integer
				
						writeInteger(this.PREV_ORDER_ID,dos);
					
					// String
				
						writeString(this.SIGNATURE_PATH,dos);
					
					// String
				
						writeString(this.SIGNATURE_FILE_NAME,dos);
					
					// String
				
						writeString(this.PDXR_AUTHORIZING_SYSTEM,dos);
					
					// java.util.Date
				
						writeDate(this.START_TIMESLOT_DATETIME,dos);
					
					// java.util.Date
				
						writeDate(this.END_TIMESLOT_DATETIME,dos);
					
					// java.util.Date
				
						writeDate(this.START_PICKUP_DATETIME,dos);
					
					// java.util.Date
				
						writeDate(this.END_PICKUP_DATETIME,dos);
					
					// int
				
		            	dos.writeInt(this.ADMINISTRATIVE_BOOKING);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("ORDER_ID="+String.valueOf(ORDER_ID));
		sb.append(",LOADED_DRIVER_NUMBER="+String.valueOf(LOADED_DRIVER_NUMBER));
		sb.append(",USER_NAME="+USER_NAME);
		sb.append(",TRAILER_CARRIER_NUMBER="+String.valueOf(TRAILER_CARRIER_NUMBER));
		sb.append(",CARRIER_NUMBER="+String.valueOf(CARRIER_NUMBER));
		sb.append(",TRAILER_CODE="+TRAILER_CODE);
		sb.append(",VEHICLE_CARRIER_NUMBER="+String.valueOf(VEHICLE_CARRIER_NUMBER));
		sb.append(",VEHICLE_CODE="+VEHICLE_CODE);
		sb.append(",TRACTOR_CARRIER_NUMBER="+String.valueOf(TRACTOR_CARRIER_NUMBER));
		sb.append(",LOADED_CARRIER_NUMBER="+String.valueOf(LOADED_CARRIER_NUMBER));
		sb.append(",FOLIO_NUMBER="+FOLIO_NUMBER);
		sb.append(",TRACTOR_NUMBER="+String.valueOf(TRACTOR_NUMBER));
		sb.append(",DELIVERED_CARRIER_NUMBER="+String.valueOf(DELIVERED_CARRIER_NUMBER));
		sb.append(",DISPATCH_CARRIER_NUMBER="+String.valueOf(DISPATCH_CARRIER_NUMBER));
		sb.append(",DELIVERED_DRIVER_NUMBER="+String.valueOf(DELIVERED_DRIVER_NUMBER));
		sb.append(",SUPPLIER_NUMBER="+String.valueOf(SUPPLIER_NUMBER));
		sb.append(",CUSTOMER_NUMBER="+String.valueOf(CUSTOMER_NUMBER));
		sb.append(",TABS_CARRIER_ID="+TABS_CARRIER_ID);
		sb.append(",DESTINATION_NUMBER="+String.valueOf(DESTINATION_NUMBER));
		sb.append(",TRIP_ID="+String.valueOf(TRIP_ID));
		sb.append(",TABS_TRUCK_NUMBER="+TABS_TRUCK_NUMBER);
		sb.append(",TYPE="+String.valueOf(TYPE));
		sb.append(",SHOST_SU_SUPPLIER_NUMBER="+SHOST_SU_SUPPLIER_NUMBER);
		sb.append(",CREATOR="+String.valueOf(CREATOR));
		sb.append(",EXCHANGE_ALLOCATION_ENABLED="+String.valueOf(EXCHANGE_ALLOCATION_ENABLED));
		sb.append(",MANUALLY_ENTERED="+String.valueOf(MANUALLY_ENTERED));
		sb.append(",SHOST_EX_EHOST_THRU_NUMBER="+SHOST_EX_EHOST_THRU_NUMBER);
		sb.append(",DEST_ALLOCATION_ENABLED="+String.valueOf(DEST_ALLOCATION_ENABLED));
		sb.append(",THOST_TH_SUPPLIER_NUMBER="+THOST_TH_SUPPLIER_NUMBER);
		sb.append(",CUST_ALLOC_BY_PRODUCT="+String.valueOf(CUST_ALLOC_BY_PRODUCT));
		sb.append(",CUST_ALLOC_BY_COMPONENT="+String.valueOf(CUST_ALLOC_BY_COMPONENT));
		sb.append(",CUST_ALLOC_BY_COMP_GROUP="+String.valueOf(CUST_ALLOC_BY_COMP_GROUP));
		sb.append(",CREDIT_ENABLED="+String.valueOf(CREDIT_ENABLED));
		sb.append(",THOST_EX_THOST_EXCH_NUMBER="+THOST_EX_THOST_EXCH_NUMBER);
		sb.append(",BILLING_TYPE="+String.valueOf(BILLING_TYPE));
		sb.append(",EXCH_ALLOC_BY_PRODUCT="+String.valueOf(EXCH_ALLOC_BY_PRODUCT));
		sb.append(",EXCH_ALLOC_BY_PRODUCT_GROUP="+String.valueOf(EXCH_ALLOC_BY_PRODUCT_GROUP));
		sb.append(",CUSTOMER_ALLOCATION_ENABLED="+String.valueOf(CUSTOMER_ALLOCATION_ENABLED));
		sb.append(",TABS_FINAL_SHIPPER_ID="+TABS_FINAL_SHIPPER_ID);
		sb.append(",CUST_ALLOC_BY_PRODUCT_GROUP="+String.valueOf(CUST_ALLOC_BY_PRODUCT_GROUP));
		sb.append(",MOVEMENT_NUMBER="+String.valueOf(MOVEMENT_NUMBER));
		sb.append(",REVISION_NUMBER="+String.valueOf(REVISION_NUMBER));
		sb.append(",TABS_SELLER_ID="+TABS_SELLER_ID);
		sb.append(",REVISED="+String.valueOf(REVISED));
		sb.append(",TABS_CONSIGNEE_NUMBER="+TABS_CONSIGNEE_NUMBER);
		sb.append(",STATUS="+String.valueOf(STATUS));
		sb.append(",CHOST_CU_SUPPLIER_NUMBER="+CHOST_CU_SUPPLIER_NUMBER);
		sb.append(",CHOST_CU_CUSTOMER_NUMBER="+CHOST_CU_CUSTOMER_NUMBER);
		sb.append(",STATUS_DATE="+String.valueOf(STATUS_DATE));
		sb.append(",PURCHASE_ORDER_NUMBER="+PURCHASE_ORDER_NUMBER);
		sb.append(",REQUISITION_NUMBER="+REQUISITION_NUMBER);
		sb.append(",BOL_COMMENT_1="+BOL_COMMENT_1);
		sb.append(",BOL_COMMENT_2="+BOL_COMMENT_2);
		sb.append(",INVOICE_REQUIRED="+String.valueOf(INVOICE_REQUIRED));
		sb.append(",INVOICE_COMMENT_1="+INVOICE_COMMENT_1);
		sb.append(",INVOICE_COMMENT_2="+INVOICE_COMMENT_2);
		sb.append(",INVOICE_PRINTED="+String.valueOf(INVOICE_PRINTED));
		sb.append(",DESTINATION_COMMENT_1="+DESTINATION_COMMENT_1);
		sb.append(",DESTINATION_COMMENT_2="+DESTINATION_COMMENT_2);
		sb.append(",TABS_SUBSCRIBER="+String.valueOf(TABS_SUBSCRIBER));
		sb.append(",REMARKS="+REMARKS);
		sb.append(",START_LOAD_TIME="+String.valueOf(START_LOAD_TIME));
		sb.append(",END_LOAD_TIME="+String.valueOf(END_LOAD_TIME));
		sb.append(",DELIVERY_FEE="+String.valueOf(DELIVERY_FEE));
		sb.append(",TABS_AUTHORIZATION_NUMBER="+TABS_AUTHORIZATION_NUMBER);
		sb.append(",THRUPUTTER_NUMBER="+String.valueOf(THRUPUTTER_NUMBER));
		sb.append(",LAST_USER_NAME="+LAST_USER_NAME);
		sb.append(",LAST_MODIFIED="+String.valueOf(LAST_MODIFIED));
		sb.append(",BOL_PRINTED="+String.valueOf(BOL_PRINTED));
		sb.append(",ORDER_ENTRY_TIME="+String.valueOf(ORDER_ENTRY_TIME));
		sb.append(",BILL_FREIGHT="+String.valueOf(BILL_FREIGHT));
		sb.append(",DELIVERY_DATE="+String.valueOf(DELIVERY_DATE));
		sb.append(",SHIFT="+String.valueOf(SHIFT));
		sb.append(",STOP="+String.valueOf(STOP));
		sb.append(",DELIVERY_CONFIRMED="+String.valueOf(DELIVERY_CONFIRMED));
		sb.append(",VALIDATING_NODE_NAME="+VALIDATING_NODE_NAME);
		sb.append(",HOST_PROCESSED="+String.valueOf(HOST_PROCESSED));
		sb.append(",PETROEX_COMPANY_CODE="+PETROEX_COMPANY_CODE);
		sb.append(",PETROEX_CONSIGNEE_NUMBER="+PETROEX_CONSIGNEE_NUMBER);
		sb.append(",PETROEX_THIRD_PARTY="+PETROEX_THIRD_PARTY);
		sb.append(",PETROEX_CARRIER_CODE="+PETROEX_CARRIER_CODE);
		sb.append(",PETROEX_TRUCK_NUMBER="+String.valueOf(PETROEX_TRUCK_NUMBER));
		sb.append(",PETROEX_SUBSCRIBER="+String.valueOf(PETROEX_SUBSCRIBER));
		sb.append(",FAN_COMMENT_1="+FAN_COMMENT_1);
		sb.append(",PETROEX_CITY_CODE="+String.valueOf(PETROEX_CITY_CODE));
		sb.append(",FAN_COMMENT_2="+FAN_COMMENT_2);
		sb.append(",PETROEX_COUNTY_CODE="+String.valueOf(PETROEX_COUNTY_CODE));
		sb.append(",PRELOAD_ORDER="+String.valueOf(PRELOAD_ORDER));
		sb.append(",PETROEX_STATE_CODE="+String.valueOf(PETROEX_STATE_CODE));
		sb.append(",CONTRACT_ALLOCATION_ENABLED="+String.valueOf(CONTRACT_ALLOCATION_ENABLED));
		sb.append(",PETROEX_FEIN="+PETROEX_FEIN);
		sb.append(",ELVIS_ORDER_NUMBER="+String.valueOf(ELVIS_ORDER_NUMBER));
		sb.append(",PETROEX_SHIPPER_INFO="+PETROEX_SHIPPER_INFO);
		sb.append(",ELVIS_LOADSPOT_ID="+ELVIS_LOADSPOT_ID);
		sb.append(",PETROEX_VEHICLE_TYPE="+PETROEX_VEHICLE_TYPE);
		sb.append(",OVERWEIGHT_TRAILER="+String.valueOf(OVERWEIGHT_TRAILER));
		sb.append(",ELVIS_AUTHORIZED="+String.valueOf(ELVIS_AUTHORIZED));
		sb.append(",DISPATCHED_WITH_TRAILER="+String.valueOf(DISPATCHED_WITH_TRAILER));
		sb.append(",DISPATCHED_WITH_DRIVER="+String.valueOf(DISPATCHED_WITH_DRIVER));
		sb.append(",COMMITTED_PRICE="+String.valueOf(COMMITTED_PRICE));
		sb.append(",LOADED_PRICE="+String.valueOf(LOADED_PRICE));
		sb.append(",CONTRACT_NUMBER="+CONTRACT_NUMBER);
		sb.append(",MANUALLY_COMPLETED="+String.valueOf(MANUALLY_COMPLETED));
		sb.append(",OVERRIDE_TOLERANCE_CHECKS="+String.valueOf(OVERRIDE_TOLERANCE_CHECKS));
		sb.append(",AIC_STATUS="+String.valueOf(AIC_STATUS));
		sb.append(",BLEND_TOLERANCE_STATUS="+String.valueOf(BLEND_TOLERANCE_STATUS));
		sb.append(",ADDITIVE_TOLERANCE_STATUS="+String.valueOf(ADDITIVE_TOLERANCE_STATUS));
		sb.append(",AUTHORIZATION_REQUEST_ID="+String.valueOf(AUTHORIZATION_REQUEST_ID));
		sb.append(",TABS_ORDER_NUMBER="+String.valueOf(TABS_ORDER_NUMBER));
		sb.append(",FLAG_VALID_PRICE="+String.valueOf(FLAG_VALID_PRICE));
		sb.append(",BOL_NUMBER="+String.valueOf(BOL_NUMBER));
		sb.append(",COMPATIBILITY_STATUS="+String.valueOf(COMPATIBILITY_STATUS));
		sb.append(",OVERRIDE_COMPATIBILITY_CHECKS="+String.valueOf(OVERRIDE_COMPATIBILITY_CHECKS));
		sb.append(",CANCELLED_FROM_CBS="+String.valueOf(CANCELLED_FROM_CBS));
		sb.append(",HOST_REF_ID="+HOST_REF_ID);
		sb.append(",UNACCOUNTED_LIMIT_EXCEEDED="+String.valueOf(UNACCOUNTED_LIMIT_EXCEEDED));
		sb.append(",OVERRIDE_UNACCOUNTED_CHECKS="+String.valueOf(OVERRIDE_UNACCOUNTED_CHECKS));
		sb.append(",PENDING_PRINT_COUNT="+String.valueOf(PENDING_PRINT_COUNT));
		sb.append(",PENDING_REQUEST_COUNT="+String.valueOf(PENDING_REQUEST_COUNT));
		sb.append(",PDXR_RACK_DRIVER_ID="+PDXR_RACK_DRIVER_ID);
		sb.append(",PDXR_TERMINAL_CONTROL_NUMBER="+PDXR_TERMINAL_CONTROL_NUMBER);
		sb.append(",PDXR_FINAL_SHIPPER_XCTN_SEQ="+String.valueOf(PDXR_FINAL_SHIPPER_XCTN_SEQ));
		sb.append(",PDXR_DESTINATION_STATE_CODE="+PDXR_DESTINATION_STATE_CODE);
		sb.append(",PDXR_DESTINATION_COUNTY="+PDXR_DESTINATION_COUNTY);
		sb.append(",PDXR_DESTINATION_CITY="+PDXR_DESTINATION_CITY);
		sb.append(",PDXR_DESTINATION_ZIP_CODE="+PDXR_DESTINATION_ZIP_CODE);
		sb.append(",PDXR_CARRIER_FEIN="+PDXR_CARRIER_FEIN);
		sb.append(",PDXR_SHIPPER_INFO="+PDXR_SHIPPER_INFO);
		sb.append(",PDXR_VERSION="+String.valueOf(PDXR_VERSION));
		sb.append(",PDXR_VENDOR="+String.valueOf(PDXR_VENDOR));
		sb.append(",ORIG_ORDER_ID="+String.valueOf(ORIG_ORDER_ID));
		sb.append(",PREV_ORDER_ID="+String.valueOf(PREV_ORDER_ID));
		sb.append(",SIGNATURE_PATH="+SIGNATURE_PATH);
		sb.append(",SIGNATURE_FILE_NAME="+SIGNATURE_FILE_NAME);
		sb.append(",PDXR_AUTHORIZING_SYSTEM="+PDXR_AUTHORIZING_SYSTEM);
		sb.append(",START_TIMESLOT_DATETIME="+String.valueOf(START_TIMESLOT_DATETIME));
		sb.append(",END_TIMESLOT_DATETIME="+String.valueOf(END_TIMESLOT_DATETIME));
		sb.append(",START_PICKUP_DATETIME="+String.valueOf(START_PICKUP_DATETIME));
		sb.append(",END_PICKUP_DATETIME="+String.valueOf(END_PICKUP_DATETIME));
		sb.append(",ADMINISTRATIVE_BOOKING="+String.valueOf(ADMINISTRATIVE_BOOKING));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(after_tDBInput_1Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tDBInput_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBInput_1_SUBPROCESS_STATE", 0);

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


		tDBInput_2Process(globalMap);

		row1Struct row1 = new row1Struct();
row2Struct row2 = new row2Struct();
out1Struct out1 = new out1Struct();






	
	/**
	 * [tDBOutput_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBOutput_1", false);
		start_Hash.put("tDBOutput_1", System.currentTimeMillis());
		
	
	currentComponent="tDBOutput_1";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"out1");
					}
				
		int tos_count_tDBOutput_1 = 0;
		



int nb_line_tDBOutput_1 = 0;
int nb_line_update_tDBOutput_1 = 0;
int nb_line_inserted_tDBOutput_1 = 0;
int nb_line_deleted_tDBOutput_1 = 0;
int nb_line_rejected_tDBOutput_1 = 0;

int deletedCount_tDBOutput_1=0;
int updatedCount_tDBOutput_1=0;
int insertedCount_tDBOutput_1=0;
int rowsToCommitCount_tDBOutput_1=0;
int rejectedCount_tDBOutput_1=0;
String dbschema_tDBOutput_1 = null;
String tableName_tDBOutput_1 = null;
boolean whetherReject_tDBOutput_1 = false;

java.util.Calendar calendar_tDBOutput_1 = java.util.Calendar.getInstance();
long year1_tDBOutput_1 = TalendDate.parseDate("yyyy-MM-dd","0001-01-01").getTime();
long year2_tDBOutput_1 = TalendDate.parseDate("yyyy-MM-dd","1753-01-01").getTime();
long year10000_tDBOutput_1 = TalendDate.parseDate("yyyy-MM-dd HH:mm:ss","9999-12-31 24:00:00").getTime();
long date_tDBOutput_1;

java.util.Calendar calendar_datetimeoffset_tDBOutput_1 = java.util.Calendar.getInstance(java.util.TimeZone.getTimeZone("UTC"));


        int updateKeyCount_tDBOutput_1 = 1;
        if(updateKeyCount_tDBOutput_1 < 1) {
            throw new RuntimeException("For update, Schema must have a key");
        } else if (updateKeyCount_tDBOutput_1 == 28 && true) {
                    System.err.println("For update, every Schema column can not be a key");
        }

	
java.sql.Connection conn_tDBOutput_1 = null;
String dbUser_tDBOutput_1 = null;
    dbschema_tDBOutput_1 = "dbo";
    String driverClass_tDBOutput_1 = "net.sourceforge.jtds.jdbc.Driver";
	
    java.lang.Class.forName(driverClass_tDBOutput_1);
    String port_tDBOutput_1 = "1433";
    String dbname_tDBOutput_1 = "PGS_STAGE_DW" ;
    String url_tDBOutput_1 = "jdbc:jtds:sqlserver://" + "LAPTOP-HED7JE2F" ; 
    if (!"".equals(port_tDBOutput_1)) {
    	url_tDBOutput_1 += ":" + "1433";
    }
    if (!"".equals(dbname_tDBOutput_1)) {
				url_tDBOutput_1 += "//" + "PGS_STAGE_DW"; 
	
    }
    url_tDBOutput_1 += ";appName=" + projectName + ";" + "";
    dbUser_tDBOutput_1 = "sa";

 
	final String decryptedPassword_tDBOutput_1 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:592r+Yh9mxJ6KNSoUOrniNXFl9MZB1e1u3PsTeUwhNUWkznQdoI=");

    String dbPwd_tDBOutput_1 = decryptedPassword_tDBOutput_1;	
    conn_tDBOutput_1 = java.sql.DriverManager.getConnection(url_tDBOutput_1,dbUser_tDBOutput_1,dbPwd_tDBOutput_1);
	
		resourceMap.put("conn_tDBOutput_1", conn_tDBOutput_1);
	
        conn_tDBOutput_1.setAutoCommit(false);
        int commitEvery_tDBOutput_1 = 10000;
        int commitCounter_tDBOutput_1 = 0;


if(dbschema_tDBOutput_1 == null || dbschema_tDBOutput_1.trim().length() == 0) {
    tableName_tDBOutput_1 = "DIM_ORDERS";
} else {
    tableName_tDBOutput_1 = dbschema_tDBOutput_1 + "].[" + "DIM_ORDERS";
}
	int count_tDBOutput_1=0;

                                boolean whetherExist_tDBOutput_1 = false;
                                try (java.sql.Statement isExistStmt_tDBOutput_1 = conn_tDBOutput_1.createStatement()) {
                                    try {
                                        isExistStmt_tDBOutput_1.execute("SELECT TOP 1 1 FROM [" + tableName_tDBOutput_1 + "]" );
                                        whetherExist_tDBOutput_1 = true;
                                    } catch (java.lang.Exception e){
globalMap.put("tDBOutput_1_ERROR_MESSAGE",e.getMessage());
                                        whetherExist_tDBOutput_1 = false;
                                    }
                                }
                                if(whetherExist_tDBOutput_1) {
                                    try (java.sql.Statement stmtDrop_tDBOutput_1 = conn_tDBOutput_1.createStatement()) {
                                        stmtDrop_tDBOutput_1.execute("DROP TABLE [" + tableName_tDBOutput_1 + "]" );
                                    }
                                }
                                try(java.sql.Statement stmtCreate_tDBOutput_1 = conn_tDBOutput_1.createStatement()) {
                                    stmtCreate_tDBOutput_1.execute("CREATE TABLE [" + tableName_tDBOutput_1 + "]([PK_ORDERS] INT ,[ORDER_ID] INT  not null ,[LOADED_DRIVER_NUMBER] INT ,[CARRIER_NUMBER] INT  not null ,[LOADED_CARRIER_NUMBER] INT ,[FOLIO_NUMBER] VARCHAR(8)  ,[DISPATCH_CARRIER_NUMBER] INT ,[SUPPLIER_NUMBER] INT  not null ,[CUSTOMER_NUMBER] INT  not null ,[DESTINATION_NUMBER] INT  not null ,[TRIP_ID] INT ,[TYPE] INT  not null ,[CREATOR] INT  not null ,[MANUALLY_ENTERED] INT  not null ,[MOVEMENT_NUMBER] INT  not null ,[REVISION_NUMBER] INT  not null ,[REVISED] INT  not null ,[STATUS] INT  not null ,[STATUS_DATE] DATETIME ,[START_LOAD_TIME] DATETIME ,[END_LOAD_TIME] DATETIME ,[LAST_USER_NAME] VARCHAR(10)  ,[LAST_MODIFIED] DATETIME ,[BOL_PRINTED] INT  not null ,[ORDER_ENTRY_TIME] DATETIME ,[MANUALLY_COMPLETED] INT  not null ,[AIC_STATUS] INT  not null ,[AUTHORIZATION_REQUEST_ID] INT  not null ,primary key([PK_ORDERS]))");
                                }
        java.sql.PreparedStatement pstmt_tDBOutput_1 = conn_tDBOutput_1.prepareStatement("SELECT COUNT(1) FROM [" + tableName_tDBOutput_1 + "] WHERE [PK_ORDERS] = ?");
        resourceMap.put("pstmt_tDBOutput_1", pstmt_tDBOutput_1);
        String insert_tDBOutput_1 = "INSERT INTO [" + tableName_tDBOutput_1 + "] ([PK_ORDERS],[ORDER_ID],[LOADED_DRIVER_NUMBER],[CARRIER_NUMBER],[LOADED_CARRIER_NUMBER],[FOLIO_NUMBER],[DISPATCH_CARRIER_NUMBER],[SUPPLIER_NUMBER],[CUSTOMER_NUMBER],[DESTINATION_NUMBER],[TRIP_ID],[TYPE],[CREATOR],[MANUALLY_ENTERED],[MOVEMENT_NUMBER],[REVISION_NUMBER],[REVISED],[STATUS],[STATUS_DATE],[START_LOAD_TIME],[END_LOAD_TIME],[LAST_USER_NAME],[LAST_MODIFIED],[BOL_PRINTED],[ORDER_ENTRY_TIME],[MANUALLY_COMPLETED],[AIC_STATUS],[AUTHORIZATION_REQUEST_ID]) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        java.sql.PreparedStatement pstmtInsert_tDBOutput_1 = conn_tDBOutput_1.prepareStatement(insert_tDBOutput_1);
        resourceMap.put("pstmtInsert_tDBOutput_1", pstmtInsert_tDBOutput_1);
        String update_tDBOutput_1 = "UPDATE [" + tableName_tDBOutput_1 + "] SET [ORDER_ID] = ?,[LOADED_DRIVER_NUMBER] = ?,[CARRIER_NUMBER] = ?,[LOADED_CARRIER_NUMBER] = ?,[FOLIO_NUMBER] = ?,[DISPATCH_CARRIER_NUMBER] = ?,[SUPPLIER_NUMBER] = ?,[CUSTOMER_NUMBER] = ?,[DESTINATION_NUMBER] = ?,[TRIP_ID] = ?,[TYPE] = ?,[CREATOR] = ?,[MANUALLY_ENTERED] = ?,[MOVEMENT_NUMBER] = ?,[REVISION_NUMBER] = ?,[REVISED] = ?,[STATUS] = ?,[STATUS_DATE] = ?,[START_LOAD_TIME] = ?,[END_LOAD_TIME] = ?,[LAST_USER_NAME] = ?,[LAST_MODIFIED] = ?,[BOL_PRINTED] = ?,[ORDER_ENTRY_TIME] = ?,[MANUALLY_COMPLETED] = ?,[AIC_STATUS] = ?,[AUTHORIZATION_REQUEST_ID] = ? WHERE [PK_ORDERS] = ?";
        java.sql.PreparedStatement pstmtUpdate_tDBOutput_1 = conn_tDBOutput_1.prepareStatement(update_tDBOutput_1);
        resourceMap.put("pstmtUpdate_tDBOutput_1", pstmtUpdate_tDBOutput_1);

 



/**
 * [tDBOutput_1 begin ] stop
 */



	
	/**
	 * [tMap_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tMap_1", false);
		start_Hash.put("tMap_1", System.currentTimeMillis());
		
	
	currentComponent="tMap_1";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row2");
					}
				
		int tos_count_tMap_1 = 0;
		




// ###############################
// # Lookup's keys initialization
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct> tHash_Lookup_row3 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct>) 
					globalMap.get( "tHash_Lookup_row3" ))
					;					
					
	

row3Struct row3HashKey = new row3Struct();
row3Struct row3Default = new row3Struct();
// ###############################        

// ###############################
// # Vars initialization
class  Var__tMap_1__Struct  {
	int PK_ORDERS;
}
Var__tMap_1__Struct Var__tMap_1 = new Var__tMap_1__Struct();
// ###############################

// ###############################
// # Outputs initialization
out1Struct out1_tmp = new out1Struct();
// ###############################

        
        



        









 



/**
 * [tMap_1 begin ] stop
 */



	
	/**
	 * [tUniqRow_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tUniqRow_1", false);
		start_Hash.put("tUniqRow_1", System.currentTimeMillis());
		
	
	currentComponent="tUniqRow_1";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row1");
					}
				
		int tos_count_tUniqRow_1 = 0;
		

	
		class KeyStruct_tUniqRow_1 {
	
			private static final int DEFAULT_HASHCODE = 1;
		    private static final int PRIME = 31;
		    private int hashCode = DEFAULT_HASHCODE;
		    public boolean hashCodeDirty = true;
	
	        
					int ORDER_ID;        
	        
		    @Override
			public int hashCode() {
				if (this.hashCodeDirty) {
					final int prime = PRIME;
					int result = DEFAULT_HASHCODE;
			
									result = prime * result + (int) this.ORDER_ID;
									
		    		this.hashCode = result;
		    		this.hashCodeDirty = false;		
				}
				return this.hashCode;
			}
			
			@Override
			public boolean equals(Object obj) {
				if (this == obj) return true;
				if (obj == null) return false;
				if (getClass() != obj.getClass()) return false;
				final KeyStruct_tUniqRow_1 other = (KeyStruct_tUniqRow_1) obj;
				
									if (this.ORDER_ID != other.ORDER_ID) 
										return false;
								
				
				return true;
			}
	  
	        
		}

	
int nb_uniques_tUniqRow_1 = 0;
int nb_duplicates_tUniqRow_1 = 0;
KeyStruct_tUniqRow_1 finder_tUniqRow_1 = new KeyStruct_tUniqRow_1();
java.util.Set<KeyStruct_tUniqRow_1> keystUniqRow_1 = new java.util.HashSet<KeyStruct_tUniqRow_1>(); 

 



/**
 * [tUniqRow_1 begin ] stop
 */



	
	/**
	 * [tDBInput_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_1", false);
		start_Hash.put("tDBInput_1", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_1";

	
		int tos_count_tDBInput_1 = 0;
		
	
    
	
			org.talend.designer.components.util.mssql.MSSqlGenerateTimestampUtil mssqlGTU_tDBInput_1 = org.talend.designer.components.util.mssql.MSSqlUtilFactory.getMSSqlGenerateTimestampUtil();
			
			java.util.List<String> talendToDBList_tDBInput_1 = new java.util.ArrayList();
			String[] talendToDBArray_tDBInput_1  = new String[]{"FLOAT","NUMERIC","NUMERIC IDENTITY","DECIMAL","DECIMAL IDENTITY","REAL"}; 
			java.util.Collections.addAll(talendToDBList_tDBInput_1, talendToDBArray_tDBInput_1); 
		    int nb_line_tDBInput_1 = 0;
		    java.sql.Connection conn_tDBInput_1 = null;
				String driverClass_tDBInput_1 = "net.sourceforge.jtds.jdbc.Driver";
			    java.lang.Class jdbcclazz_tDBInput_1 = java.lang.Class.forName(driverClass_tDBInput_1);
				String dbUser_tDBInput_1 = "sa";
				
				 
	final String decryptedPassword_tDBInput_1 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:KKur5wHn0ofDxNaFv9tg3zfyQXp/gMaW08LwJsuzAxPZR7FLFfQ=");
				
				String dbPwd_tDBInput_1 = decryptedPassword_tDBInput_1;
				
		    String port_tDBInput_1 = "1433";
		    String dbname_tDBInput_1 = "FF_TEST" ;
			String url_tDBInput_1 = "jdbc:jtds:sqlserver://" + "LAPTOP-HED7JE2F" ;
		    if (!"".equals(port_tDBInput_1)) {
		    	url_tDBInput_1 += ":" + "1433";
		    }
		    if (!"".equals(dbname_tDBInput_1)) {
				url_tDBInput_1 += "//" + "FF_TEST"; 
		    }
		    url_tDBInput_1 += ";appName=" + projectName + ";" + "";
		    String dbschema_tDBInput_1 = "dbo";
				
				conn_tDBInput_1 = java.sql.DriverManager.getConnection(url_tDBInput_1,dbUser_tDBInput_1,dbPwd_tDBInput_1);
		        
		    
			java.sql.Statement stmt_tDBInput_1 = conn_tDBInput_1.createStatement();

		    String dbquery_tDBInput_1 = "SELECT dbo.ORDERS.ORDER_ID,\n		dbo.ORDERS.LOADED_DRIVER_NUMBER,\n		dbo.ORDERS.\"USER_NAME\",\n		dbo.ORDERS.TRAILER_CARRIER"
+"_NUMBER,\n		dbo.ORDERS.CARRIER_NUMBER,\n		dbo.ORDERS.TRAILER_CODE,\n		dbo.ORDERS.VEHICLE_CARRIER_NUMBER,\n		dbo.ORDERS.VEHIC"
+"LE_CODE,\n		dbo.ORDERS.TRACTOR_CARRIER_NUMBER,\n		dbo.ORDERS.LOADED_CARRIER_NUMBER,\n		dbo.ORDERS.FOLIO_NUMBER,\n		dbo.ORDER"
+"S.TRACTOR_NUMBER,\n		dbo.ORDERS.DELIVERED_CARRIER_NUMBER,\n		dbo.ORDERS.DISPATCH_CARRIER_NUMBER,\n		dbo.ORDERS.DELIVERED_DR"
+"IVER_NUMBER,\n		dbo.ORDERS.SUPPLIER_NUMBER,\n		dbo.ORDERS.CUSTOMER_NUMBER,\n		dbo.ORDERS.TABS_CARRIER_ID,\n		dbo.ORDERS.DEST"
+"INATION_NUMBER,\n		dbo.ORDERS.TRIP_ID,\n		dbo.ORDERS.TABS_TRUCK_NUMBER,\n		dbo.ORDERS.TYPE,\n		dbo.ORDERS.SHOST_SU_SUPPLIER_"
+"NUMBER,\n		dbo.ORDERS.CREATOR,\n		dbo.ORDERS.EXCHANGE_ALLOCATION_ENABLED,\n		dbo.ORDERS.MANUALLY_ENTERED,\n		dbo.ORDERS.SHOS"
+"T_EX_EHOST_THRU_NUMBER,\n		dbo.ORDERS.DEST_ALLOCATION_ENABLED,\n		dbo.ORDERS.THOST_TH_SUPPLIER_NUMBER,\n		dbo.ORDERS.CUST_A"
+"LLOC_BY_PRODUCT,\n		dbo.ORDERS.CUST_ALLOC_BY_COMPONENT,\n		dbo.ORDERS.CUST_ALLOC_BY_COMP_GROUP,\n		dbo.ORDERS.CREDIT_ENABLE"
+"D,\n		dbo.ORDERS.THOST_EX_THOST_EXCH_NUMBER,\n		dbo.ORDERS.BILLING_TYPE,\n		dbo.ORDERS.EXCH_ALLOC_BY_PRODUCT,\n		dbo.ORDERS."
+"EXCH_ALLOC_BY_PRODUCT_GROUP,\n		dbo.ORDERS.CUSTOMER_ALLOCATION_ENABLED,\n		dbo.ORDERS.TABS_FINAL_SHIPPER_ID,\n		dbo.ORDERS."
+"CUST_ALLOC_BY_PRODUCT_GROUP,\n		dbo.ORDERS.MOVEMENT_NUMBER,\n		dbo.ORDERS.REVISION_NUMBER,\n		dbo.ORDERS.TABS_SELLER_ID,\n		"
+"dbo.ORDERS.REVISED,\n		dbo.ORDERS.TABS_CONSIGNEE_NUMBER,\n		dbo.ORDERS.STATUS,\n		dbo.ORDERS.CHOST_CU_SUPPLIER_NUMBER,\n		db"
+"o.ORDERS.CHOST_CU_CUSTOMER_NUMBER,\n		dbo.ORDERS.STATUS_DATE,\n		dbo.ORDERS.PURCHASE_ORDER_NUMBER,\n		dbo.ORDERS.REQUISITIO"
+"N_NUMBER,\n		dbo.ORDERS.BOL_COMMENT_1,\n		dbo.ORDERS.BOL_COMMENT_2,\n		dbo.ORDERS.INVOICE_REQUIRED,\n		dbo.ORDERS.INVOICE_CO"
+"MMENT_1,\n		dbo.ORDERS.INVOICE_COMMENT_2,\n		dbo.ORDERS.INVOICE_PRINTED,\n		dbo.ORDERS.DESTINATION_COMMENT_1,\n		dbo.ORDERS."
+"DESTINATION_COMMENT_2,\n		dbo.ORDERS.TABS_SUBSCRIBER,\n		dbo.ORDERS.REMARKS,\n		dbo.ORDERS.START_LOAD_TIME,\n		dbo.ORDERS.EN"
+"D_LOAD_TIME,\n		dbo.ORDERS.DELIVERY_FEE,\n		dbo.ORDERS.TABS_AUTHORIZATION_NUMBER,\n		dbo.ORDERS.THRUPUTTER_NUMBER,\n		dbo.OR"
+"DERS.LAST_USER_NAME,\n		dbo.ORDERS.LAST_MODIFIED,\n		dbo.ORDERS.BOL_PRINTED,\n		dbo.ORDERS.ORDER_ENTRY_TIME,\n		dbo.ORDERS.B"
+"ILL_FREIGHT,\n		dbo.ORDERS.DELIVERY_DATE,\n		dbo.ORDERS.SHIFT,\n		dbo.ORDERS.STOP,\n		dbo.ORDERS.DELIVERY_CONFIRMED,\n		dbo.O"
+"RDERS.VALIDATING_NODE_NAME,\n		dbo.ORDERS.HOST_PROCESSED,\n		dbo.ORDERS.PETROEX_COMPANY_CODE,\n		dbo.ORDERS.PETROEX_CONSIGN"
+"EE_NUMBER,\n		dbo.ORDERS.PETROEX_THIRD_PARTY,\n		dbo.ORDERS.PETROEX_CARRIER_CODE,\n		dbo.ORDERS.PETROEX_TRUCK_NUMBER,\n		dbo"
+".ORDERS.PETROEX_SUBSCRIBER,\n		dbo.ORDERS.FAN_COMMENT_1,\n		dbo.ORDERS.PETROEX_CITY_CODE,\n		dbo.ORDERS.FAN_COMMENT_2,\n		db"
+"o.ORDERS.PETROEX_COUNTY_CODE,\n		dbo.ORDERS.PRELOAD_ORDER,\n		dbo.ORDERS.PETROEX_STATE_CODE,\n		dbo.ORDERS.CONTRACT_ALLOCAT"
+"ION_ENABLED,\n		dbo.ORDERS.PETROEX_FEIN,\n		dbo.ORDERS.ELVIS_ORDER_NUMBER,\n		dbo.ORDERS.PETROEX_SHIPPER_INFO,\n		dbo.ORDERS"
+".ELVIS_LOADSPOT_ID,\n		dbo.ORDERS.PETROEX_VEHICLE_TYPE,\n		dbo.ORDERS.OVERWEIGHT_TRAILER,\n		dbo.ORDERS.ELVIS_AUTHORIZED,\n	"
+"	dbo.ORDERS.DISPATCHED_WITH_TRAILER,\n		dbo.ORDERS.DISPATCHED_WITH_DRIVER,\n		dbo.ORDERS.COMMITTED_PRICE,\n		dbo.ORDERS.LOA"
+"DED_PRICE,\n		dbo.ORDERS.CONTRACT_NUMBER,\n		dbo.ORDERS.MANUALLY_COMPLETED,\n		dbo.ORDERS.OVERRIDE_TOLERANCE_CHECKS,\n		dbo."
+"ORDERS.AIC_STATUS,\n		dbo.ORDERS.BLEND_TOLERANCE_STATUS,\n		dbo.ORDERS.ADDITIVE_TOLERANCE_STATUS,\n		dbo.ORDERS.AUTHORIZATI"
+"ON_REQUEST_ID,\n		dbo.ORDERS.TABS_ORDER_NUMBER,\n		dbo.ORDERS.FLAG_VALID_PRICE,\n		dbo.ORDERS.BOL_NUMBER,\n		dbo.ORDERS.COMP"
+"ATIBILITY_STATUS,\n		dbo.ORDERS.OVERRIDE_COMPATIBILITY_CHECKS,\n		dbo.ORDERS.CANCELLED_FROM_CBS,\n		dbo.ORDERS.HOST_REF_ID,"
+"\n		dbo.ORDERS.UNACCOUNTED_LIMIT_EXCEEDED,\n		dbo.ORDERS.OVERRIDE_UNACCOUNTED_CHECKS,\n		dbo.ORDERS.PENDING_PRINT_COUNT,\n		"
+"dbo.ORDERS.PENDING_REQUEST_COUNT,\n		dbo.ORDERS.PDXR_RACK_DRIVER_ID,\n		dbo.ORDERS.PDXR_TERMINAL_CONTROL_NUMBER,\n		dbo.ORD"
+"ERS.PDXR_FINAL_SHIPPER_XCTN_SEQ,\n		dbo.ORDERS.PDXR_DESTINATION_STATE_CODE,\n		dbo.ORDERS.PDXR_DESTINATION_COUNTY,\n		dbo.O"
+"RDERS.PDXR_DESTINATION_CITY,\n		dbo.ORDERS.PDXR_DESTINATION_ZIP_CODE,\n		dbo.ORDERS.PDXR_CARRIER_FEIN,\n		dbo.ORDERS.PDXR_S"
+"HIPPER_INFO,\n		dbo.ORDERS.PDXR_VERSION,\n		dbo.ORDERS.PDXR_VENDOR,\n		dbo.ORDERS.ORIG_ORDER_ID,\n		dbo.ORDERS.PREV_ORDER_ID"
+",\n		dbo.ORDERS.SIGNATURE_PATH,\n		dbo.ORDERS.SIGNATURE_FILE_NAME,\n		dbo.ORDERS.PDXR_AUTHORIZING_SYSTEM,\n		dbo.ORDERS.STAR"
+"T_TIMESLOT_DATETIME,\n		dbo.ORDERS.END_TIMESLOT_DATETIME,\n		dbo.ORDERS.START_PICKUP_DATETIME,\n		dbo.ORDERS.END_PICKUP_DAT"
+"ETIME,\n		dbo.ORDERS.ADMINISTRATIVE_BOOKING\nFROM	dbo.ORDERS";
		    

            	globalMap.put("tDBInput_1_QUERY",dbquery_tDBInput_1);
		    java.sql.ResultSet rs_tDBInput_1 = null;

		    try {
		    	rs_tDBInput_1 = stmt_tDBInput_1.executeQuery(dbquery_tDBInput_1);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_1 = rs_tDBInput_1.getMetaData();
		    	int colQtyInRs_tDBInput_1 = rsmd_tDBInput_1.getColumnCount();

		    String tmpContent_tDBInput_1 = null;
		    
		    
		    while (rs_tDBInput_1.next()) {
		        nb_line_tDBInput_1++;
		        
							if(colQtyInRs_tDBInput_1 < 1) {
								row1.ORDER_ID = 0;
							} else {
		                          
            row1.ORDER_ID = rs_tDBInput_1.getInt(1);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 2) {
								row1.LOADED_DRIVER_NUMBER = null;
							} else {
		                          
            row1.LOADED_DRIVER_NUMBER = rs_tDBInput_1.getInt(2);
            if(rs_tDBInput_1.wasNull()){
                    row1.LOADED_DRIVER_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 3) {
								row1.USER_NAME = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(3);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(3).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.USER_NAME = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.USER_NAME = tmpContent_tDBInput_1;
                }
            } else {
                row1.USER_NAME = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 4) {
								row1.TRAILER_CARRIER_NUMBER = null;
							} else {
		                          
            row1.TRAILER_CARRIER_NUMBER = rs_tDBInput_1.getInt(4);
            if(rs_tDBInput_1.wasNull()){
                    row1.TRAILER_CARRIER_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 5) {
								row1.CARRIER_NUMBER = 0;
							} else {
		                          
            row1.CARRIER_NUMBER = rs_tDBInput_1.getInt(5);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 6) {
								row1.TRAILER_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(6);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(6).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.TRAILER_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.TRAILER_CODE = tmpContent_tDBInput_1;
                }
            } else {
                row1.TRAILER_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 7) {
								row1.VEHICLE_CARRIER_NUMBER = null;
							} else {
		                          
            row1.VEHICLE_CARRIER_NUMBER = rs_tDBInput_1.getInt(7);
            if(rs_tDBInput_1.wasNull()){
                    row1.VEHICLE_CARRIER_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 8) {
								row1.VEHICLE_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(8);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(8).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.VEHICLE_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.VEHICLE_CODE = tmpContent_tDBInput_1;
                }
            } else {
                row1.VEHICLE_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 9) {
								row1.TRACTOR_CARRIER_NUMBER = null;
							} else {
		                          
            row1.TRACTOR_CARRIER_NUMBER = rs_tDBInput_1.getInt(9);
            if(rs_tDBInput_1.wasNull()){
                    row1.TRACTOR_CARRIER_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 10) {
								row1.LOADED_CARRIER_NUMBER = null;
							} else {
		                          
            row1.LOADED_CARRIER_NUMBER = rs_tDBInput_1.getInt(10);
            if(rs_tDBInput_1.wasNull()){
                    row1.LOADED_CARRIER_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 11) {
								row1.FOLIO_NUMBER = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(11);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(11).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.FOLIO_NUMBER = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.FOLIO_NUMBER = tmpContent_tDBInput_1;
                }
            } else {
                row1.FOLIO_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 12) {
								row1.TRACTOR_NUMBER = null;
							} else {
		                          
            row1.TRACTOR_NUMBER = rs_tDBInput_1.getInt(12);
            if(rs_tDBInput_1.wasNull()){
                    row1.TRACTOR_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 13) {
								row1.DELIVERED_CARRIER_NUMBER = null;
							} else {
		                          
            row1.DELIVERED_CARRIER_NUMBER = rs_tDBInput_1.getInt(13);
            if(rs_tDBInput_1.wasNull()){
                    row1.DELIVERED_CARRIER_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 14) {
								row1.DISPATCH_CARRIER_NUMBER = null;
							} else {
		                          
            row1.DISPATCH_CARRIER_NUMBER = rs_tDBInput_1.getInt(14);
            if(rs_tDBInput_1.wasNull()){
                    row1.DISPATCH_CARRIER_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 15) {
								row1.DELIVERED_DRIVER_NUMBER = null;
							} else {
		                          
            row1.DELIVERED_DRIVER_NUMBER = rs_tDBInput_1.getInt(15);
            if(rs_tDBInput_1.wasNull()){
                    row1.DELIVERED_DRIVER_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 16) {
								row1.SUPPLIER_NUMBER = 0;
							} else {
		                          
            row1.SUPPLIER_NUMBER = rs_tDBInput_1.getInt(16);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 17) {
								row1.CUSTOMER_NUMBER = 0;
							} else {
		                          
            row1.CUSTOMER_NUMBER = rs_tDBInput_1.getInt(17);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 18) {
								row1.TABS_CARRIER_ID = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(18);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(18).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.TABS_CARRIER_ID = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.TABS_CARRIER_ID = tmpContent_tDBInput_1;
                }
            } else {
                row1.TABS_CARRIER_ID = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 19) {
								row1.DESTINATION_NUMBER = 0;
							} else {
		                          
            row1.DESTINATION_NUMBER = rs_tDBInput_1.getInt(19);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 20) {
								row1.TRIP_ID = null;
							} else {
		                          
            row1.TRIP_ID = rs_tDBInput_1.getInt(20);
            if(rs_tDBInput_1.wasNull()){
                    row1.TRIP_ID = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 21) {
								row1.TABS_TRUCK_NUMBER = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(21);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(21).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.TABS_TRUCK_NUMBER = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.TABS_TRUCK_NUMBER = tmpContent_tDBInput_1;
                }
            } else {
                row1.TABS_TRUCK_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 22) {
								row1.TYPE = 0;
							} else {
		                          
            row1.TYPE = rs_tDBInput_1.getInt(22);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 23) {
								row1.SHOST_SU_SUPPLIER_NUMBER = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(23);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(23).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.SHOST_SU_SUPPLIER_NUMBER = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.SHOST_SU_SUPPLIER_NUMBER = tmpContent_tDBInput_1;
                }
            } else {
                row1.SHOST_SU_SUPPLIER_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 24) {
								row1.CREATOR = 0;
							} else {
		                          
            row1.CREATOR = rs_tDBInput_1.getInt(24);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 25) {
								row1.EXCHANGE_ALLOCATION_ENABLED = 0;
							} else {
		                          
            row1.EXCHANGE_ALLOCATION_ENABLED = rs_tDBInput_1.getInt(25);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 26) {
								row1.MANUALLY_ENTERED = 0;
							} else {
		                          
            row1.MANUALLY_ENTERED = rs_tDBInput_1.getInt(26);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 27) {
								row1.SHOST_EX_EHOST_THRU_NUMBER = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(27);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(27).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.SHOST_EX_EHOST_THRU_NUMBER = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.SHOST_EX_EHOST_THRU_NUMBER = tmpContent_tDBInput_1;
                }
            } else {
                row1.SHOST_EX_EHOST_THRU_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 28) {
								row1.DEST_ALLOCATION_ENABLED = 0;
							} else {
		                          
            row1.DEST_ALLOCATION_ENABLED = rs_tDBInput_1.getInt(28);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 29) {
								row1.THOST_TH_SUPPLIER_NUMBER = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(29);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(29).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.THOST_TH_SUPPLIER_NUMBER = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.THOST_TH_SUPPLIER_NUMBER = tmpContent_tDBInput_1;
                }
            } else {
                row1.THOST_TH_SUPPLIER_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 30) {
								row1.CUST_ALLOC_BY_PRODUCT = 0;
							} else {
		                          
            row1.CUST_ALLOC_BY_PRODUCT = rs_tDBInput_1.getInt(30);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 31) {
								row1.CUST_ALLOC_BY_COMPONENT = 0;
							} else {
		                          
            row1.CUST_ALLOC_BY_COMPONENT = rs_tDBInput_1.getInt(31);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 32) {
								row1.CUST_ALLOC_BY_COMP_GROUP = 0;
							} else {
		                          
            row1.CUST_ALLOC_BY_COMP_GROUP = rs_tDBInput_1.getInt(32);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 33) {
								row1.CREDIT_ENABLED = 0;
							} else {
		                          
            row1.CREDIT_ENABLED = rs_tDBInput_1.getInt(33);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 34) {
								row1.THOST_EX_THOST_EXCH_NUMBER = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(34);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(34).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.THOST_EX_THOST_EXCH_NUMBER = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.THOST_EX_THOST_EXCH_NUMBER = tmpContent_tDBInput_1;
                }
            } else {
                row1.THOST_EX_THOST_EXCH_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 35) {
								row1.BILLING_TYPE = 0;
							} else {
		                          
            row1.BILLING_TYPE = rs_tDBInput_1.getInt(35);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 36) {
								row1.EXCH_ALLOC_BY_PRODUCT = 0;
							} else {
		                          
            row1.EXCH_ALLOC_BY_PRODUCT = rs_tDBInput_1.getInt(36);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 37) {
								row1.EXCH_ALLOC_BY_PRODUCT_GROUP = 0;
							} else {
		                          
            row1.EXCH_ALLOC_BY_PRODUCT_GROUP = rs_tDBInput_1.getInt(37);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 38) {
								row1.CUSTOMER_ALLOCATION_ENABLED = 0;
							} else {
		                          
            row1.CUSTOMER_ALLOCATION_ENABLED = rs_tDBInput_1.getInt(38);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 39) {
								row1.TABS_FINAL_SHIPPER_ID = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(39);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(39).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.TABS_FINAL_SHIPPER_ID = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.TABS_FINAL_SHIPPER_ID = tmpContent_tDBInput_1;
                }
            } else {
                row1.TABS_FINAL_SHIPPER_ID = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 40) {
								row1.CUST_ALLOC_BY_PRODUCT_GROUP = 0;
							} else {
		                          
            row1.CUST_ALLOC_BY_PRODUCT_GROUP = rs_tDBInput_1.getInt(40);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 41) {
								row1.MOVEMENT_NUMBER = 0;
							} else {
		                          
            row1.MOVEMENT_NUMBER = rs_tDBInput_1.getInt(41);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 42) {
								row1.REVISION_NUMBER = 0;
							} else {
		                          
            row1.REVISION_NUMBER = rs_tDBInput_1.getInt(42);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 43) {
								row1.TABS_SELLER_ID = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(43);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(43).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.TABS_SELLER_ID = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.TABS_SELLER_ID = tmpContent_tDBInput_1;
                }
            } else {
                row1.TABS_SELLER_ID = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 44) {
								row1.REVISED = 0;
							} else {
		                          
            row1.REVISED = rs_tDBInput_1.getInt(44);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 45) {
								row1.TABS_CONSIGNEE_NUMBER = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(45);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(45).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.TABS_CONSIGNEE_NUMBER = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.TABS_CONSIGNEE_NUMBER = tmpContent_tDBInput_1;
                }
            } else {
                row1.TABS_CONSIGNEE_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 46) {
								row1.STATUS = 0;
							} else {
		                          
            row1.STATUS = rs_tDBInput_1.getInt(46);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 47) {
								row1.CHOST_CU_SUPPLIER_NUMBER = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(47);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(47).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.CHOST_CU_SUPPLIER_NUMBER = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.CHOST_CU_SUPPLIER_NUMBER = tmpContent_tDBInput_1;
                }
            } else {
                row1.CHOST_CU_SUPPLIER_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 48) {
								row1.CHOST_CU_CUSTOMER_NUMBER = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(48);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(48).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.CHOST_CU_CUSTOMER_NUMBER = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.CHOST_CU_CUSTOMER_NUMBER = tmpContent_tDBInput_1;
                }
            } else {
                row1.CHOST_CU_CUSTOMER_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 49) {
								row1.STATUS_DATE = null;
							} else {
										
			row1.STATUS_DATE = mssqlGTU_tDBInput_1.getDate(rsmd_tDBInput_1, rs_tDBInput_1, 49);
			
		                    }
							if(colQtyInRs_tDBInput_1 < 50) {
								row1.PURCHASE_ORDER_NUMBER = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(50);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(50).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.PURCHASE_ORDER_NUMBER = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.PURCHASE_ORDER_NUMBER = tmpContent_tDBInput_1;
                }
            } else {
                row1.PURCHASE_ORDER_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 51) {
								row1.REQUISITION_NUMBER = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(51);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(51).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.REQUISITION_NUMBER = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.REQUISITION_NUMBER = tmpContent_tDBInput_1;
                }
            } else {
                row1.REQUISITION_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 52) {
								row1.BOL_COMMENT_1 = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(52);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(52).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.BOL_COMMENT_1 = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.BOL_COMMENT_1 = tmpContent_tDBInput_1;
                }
            } else {
                row1.BOL_COMMENT_1 = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 53) {
								row1.BOL_COMMENT_2 = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(53);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(53).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.BOL_COMMENT_2 = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.BOL_COMMENT_2 = tmpContent_tDBInput_1;
                }
            } else {
                row1.BOL_COMMENT_2 = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 54) {
								row1.INVOICE_REQUIRED = 0;
							} else {
		                          
            row1.INVOICE_REQUIRED = rs_tDBInput_1.getInt(54);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 55) {
								row1.INVOICE_COMMENT_1 = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(55);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(55).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.INVOICE_COMMENT_1 = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.INVOICE_COMMENT_1 = tmpContent_tDBInput_1;
                }
            } else {
                row1.INVOICE_COMMENT_1 = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 56) {
								row1.INVOICE_COMMENT_2 = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(56);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(56).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.INVOICE_COMMENT_2 = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.INVOICE_COMMENT_2 = tmpContent_tDBInput_1;
                }
            } else {
                row1.INVOICE_COMMENT_2 = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 57) {
								row1.INVOICE_PRINTED = 0;
							} else {
		                          
            row1.INVOICE_PRINTED = rs_tDBInput_1.getInt(57);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 58) {
								row1.DESTINATION_COMMENT_1 = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(58);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(58).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.DESTINATION_COMMENT_1 = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.DESTINATION_COMMENT_1 = tmpContent_tDBInput_1;
                }
            } else {
                row1.DESTINATION_COMMENT_1 = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 59) {
								row1.DESTINATION_COMMENT_2 = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(59);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(59).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.DESTINATION_COMMENT_2 = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.DESTINATION_COMMENT_2 = tmpContent_tDBInput_1;
                }
            } else {
                row1.DESTINATION_COMMENT_2 = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 60) {
								row1.TABS_SUBSCRIBER = 0;
							} else {
		                          
            row1.TABS_SUBSCRIBER = rs_tDBInput_1.getInt(60);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 61) {
								row1.REMARKS = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(61);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(61).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.REMARKS = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.REMARKS = tmpContent_tDBInput_1;
                }
            } else {
                row1.REMARKS = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 62) {
								row1.START_LOAD_TIME = null;
							} else {
										
			row1.START_LOAD_TIME = mssqlGTU_tDBInput_1.getDate(rsmd_tDBInput_1, rs_tDBInput_1, 62);
			
		                    }
							if(colQtyInRs_tDBInput_1 < 63) {
								row1.END_LOAD_TIME = null;
							} else {
										
			row1.END_LOAD_TIME = mssqlGTU_tDBInput_1.getDate(rsmd_tDBInput_1, rs_tDBInput_1, 63);
			
		                    }
							if(colQtyInRs_tDBInput_1 < 64) {
								row1.DELIVERY_FEE = 0;
							} else {
	                         		
            row1.DELIVERY_FEE = rs_tDBInput_1.getDouble(64);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 65) {
								row1.TABS_AUTHORIZATION_NUMBER = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(65);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(65).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.TABS_AUTHORIZATION_NUMBER = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.TABS_AUTHORIZATION_NUMBER = tmpContent_tDBInput_1;
                }
            } else {
                row1.TABS_AUTHORIZATION_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 66) {
								row1.THRUPUTTER_NUMBER = null;
							} else {
		                          
            row1.THRUPUTTER_NUMBER = rs_tDBInput_1.getInt(66);
            if(rs_tDBInput_1.wasNull()){
                    row1.THRUPUTTER_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 67) {
								row1.LAST_USER_NAME = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(67);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(67).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.LAST_USER_NAME = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.LAST_USER_NAME = tmpContent_tDBInput_1;
                }
            } else {
                row1.LAST_USER_NAME = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 68) {
								row1.LAST_MODIFIED = null;
							} else {
										
			row1.LAST_MODIFIED = mssqlGTU_tDBInput_1.getDate(rsmd_tDBInput_1, rs_tDBInput_1, 68);
			
		                    }
							if(colQtyInRs_tDBInput_1 < 69) {
								row1.BOL_PRINTED = 0;
							} else {
		                          
            row1.BOL_PRINTED = rs_tDBInput_1.getInt(69);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 70) {
								row1.ORDER_ENTRY_TIME = null;
							} else {
										
			row1.ORDER_ENTRY_TIME = mssqlGTU_tDBInput_1.getDate(rsmd_tDBInput_1, rs_tDBInput_1, 70);
			
		                    }
							if(colQtyInRs_tDBInput_1 < 71) {
								row1.BILL_FREIGHT = 0;
							} else {
		                          
            row1.BILL_FREIGHT = rs_tDBInput_1.getInt(71);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 72) {
								row1.DELIVERY_DATE = null;
							} else {
										
			row1.DELIVERY_DATE = mssqlGTU_tDBInput_1.getDate(rsmd_tDBInput_1, rs_tDBInput_1, 72);
			
		                    }
							if(colQtyInRs_tDBInput_1 < 73) {
								row1.SHIFT = 0;
							} else {
		                          
            row1.SHIFT = rs_tDBInput_1.getInt(73);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 74) {
								row1.STOP = 0;
							} else {
		                          
            row1.STOP = rs_tDBInput_1.getInt(74);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 75) {
								row1.DELIVERY_CONFIRMED = 0;
							} else {
		                          
            row1.DELIVERY_CONFIRMED = rs_tDBInput_1.getInt(75);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 76) {
								row1.VALIDATING_NODE_NAME = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(76);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(76).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.VALIDATING_NODE_NAME = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.VALIDATING_NODE_NAME = tmpContent_tDBInput_1;
                }
            } else {
                row1.VALIDATING_NODE_NAME = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 77) {
								row1.HOST_PROCESSED = 0;
							} else {
		                          
            row1.HOST_PROCESSED = rs_tDBInput_1.getInt(77);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 78) {
								row1.PETROEX_COMPANY_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(78);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(78).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.PETROEX_COMPANY_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.PETROEX_COMPANY_CODE = tmpContent_tDBInput_1;
                }
            } else {
                row1.PETROEX_COMPANY_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 79) {
								row1.PETROEX_CONSIGNEE_NUMBER = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(79);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(79).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.PETROEX_CONSIGNEE_NUMBER = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.PETROEX_CONSIGNEE_NUMBER = tmpContent_tDBInput_1;
                }
            } else {
                row1.PETROEX_CONSIGNEE_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 80) {
								row1.PETROEX_THIRD_PARTY = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(80);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(80).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.PETROEX_THIRD_PARTY = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.PETROEX_THIRD_PARTY = tmpContent_tDBInput_1;
                }
            } else {
                row1.PETROEX_THIRD_PARTY = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 81) {
								row1.PETROEX_CARRIER_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(81);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(81).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.PETROEX_CARRIER_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.PETROEX_CARRIER_CODE = tmpContent_tDBInput_1;
                }
            } else {
                row1.PETROEX_CARRIER_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 82) {
								row1.PETROEX_TRUCK_NUMBER = 0;
							} else {
		                          
            row1.PETROEX_TRUCK_NUMBER = rs_tDBInput_1.getInt(82);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 83) {
								row1.PETROEX_SUBSCRIBER = 0;
							} else {
		                          
            row1.PETROEX_SUBSCRIBER = rs_tDBInput_1.getInt(83);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 84) {
								row1.FAN_COMMENT_1 = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(84);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(84).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.FAN_COMMENT_1 = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.FAN_COMMENT_1 = tmpContent_tDBInput_1;
                }
            } else {
                row1.FAN_COMMENT_1 = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 85) {
								row1.PETROEX_CITY_CODE = 0;
							} else {
		                          
            row1.PETROEX_CITY_CODE = rs_tDBInput_1.getInt(85);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 86) {
								row1.FAN_COMMENT_2 = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(86);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(86).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.FAN_COMMENT_2 = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.FAN_COMMENT_2 = tmpContent_tDBInput_1;
                }
            } else {
                row1.FAN_COMMENT_2 = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 87) {
								row1.PETROEX_COUNTY_CODE = 0;
							} else {
		                          
            row1.PETROEX_COUNTY_CODE = rs_tDBInput_1.getInt(87);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 88) {
								row1.PRELOAD_ORDER = 0;
							} else {
		                          
            row1.PRELOAD_ORDER = rs_tDBInput_1.getInt(88);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 89) {
								row1.PETROEX_STATE_CODE = 0;
							} else {
		                          
            row1.PETROEX_STATE_CODE = rs_tDBInput_1.getInt(89);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 90) {
								row1.CONTRACT_ALLOCATION_ENABLED = 0;
							} else {
		                          
            row1.CONTRACT_ALLOCATION_ENABLED = rs_tDBInput_1.getInt(90);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 91) {
								row1.PETROEX_FEIN = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(91);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(91).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.PETROEX_FEIN = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.PETROEX_FEIN = tmpContent_tDBInput_1;
                }
            } else {
                row1.PETROEX_FEIN = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 92) {
								row1.ELVIS_ORDER_NUMBER = 0;
							} else {
		                          
            row1.ELVIS_ORDER_NUMBER = rs_tDBInput_1.getInt(92);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 93) {
								row1.PETROEX_SHIPPER_INFO = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(93);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(93).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.PETROEX_SHIPPER_INFO = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.PETROEX_SHIPPER_INFO = tmpContent_tDBInput_1;
                }
            } else {
                row1.PETROEX_SHIPPER_INFO = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 94) {
								row1.ELVIS_LOADSPOT_ID = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(94);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(94).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.ELVIS_LOADSPOT_ID = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.ELVIS_LOADSPOT_ID = tmpContent_tDBInput_1;
                }
            } else {
                row1.ELVIS_LOADSPOT_ID = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 95) {
								row1.PETROEX_VEHICLE_TYPE = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(95);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(95).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.PETROEX_VEHICLE_TYPE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.PETROEX_VEHICLE_TYPE = tmpContent_tDBInput_1;
                }
            } else {
                row1.PETROEX_VEHICLE_TYPE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 96) {
								row1.OVERWEIGHT_TRAILER = 0;
							} else {
		                          
            row1.OVERWEIGHT_TRAILER = rs_tDBInput_1.getInt(96);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 97) {
								row1.ELVIS_AUTHORIZED = 0;
							} else {
		                          
            row1.ELVIS_AUTHORIZED = rs_tDBInput_1.getInt(97);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 98) {
								row1.DISPATCHED_WITH_TRAILER = 0;
							} else {
		                          
            row1.DISPATCHED_WITH_TRAILER = rs_tDBInput_1.getInt(98);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 99) {
								row1.DISPATCHED_WITH_DRIVER = 0;
							} else {
		                          
            row1.DISPATCHED_WITH_DRIVER = rs_tDBInput_1.getInt(99);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 100) {
								row1.COMMITTED_PRICE = 0;
							} else {
	                         		
            row1.COMMITTED_PRICE = rs_tDBInput_1.getDouble(100);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 101) {
								row1.LOADED_PRICE = 0;
							} else {
	                         		
            row1.LOADED_PRICE = rs_tDBInput_1.getDouble(101);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 102) {
								row1.CONTRACT_NUMBER = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(102);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(102).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.CONTRACT_NUMBER = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.CONTRACT_NUMBER = tmpContent_tDBInput_1;
                }
            } else {
                row1.CONTRACT_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 103) {
								row1.MANUALLY_COMPLETED = 0;
							} else {
		                          
            row1.MANUALLY_COMPLETED = rs_tDBInput_1.getInt(103);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 104) {
								row1.OVERRIDE_TOLERANCE_CHECKS = 0;
							} else {
		                          
            row1.OVERRIDE_TOLERANCE_CHECKS = rs_tDBInput_1.getInt(104);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 105) {
								row1.AIC_STATUS = 0;
							} else {
		                          
            row1.AIC_STATUS = rs_tDBInput_1.getInt(105);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 106) {
								row1.BLEND_TOLERANCE_STATUS = 0;
							} else {
		                          
            row1.BLEND_TOLERANCE_STATUS = rs_tDBInput_1.getInt(106);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 107) {
								row1.ADDITIVE_TOLERANCE_STATUS = 0;
							} else {
		                          
            row1.ADDITIVE_TOLERANCE_STATUS = rs_tDBInput_1.getInt(107);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 108) {
								row1.AUTHORIZATION_REQUEST_ID = 0;
							} else {
		                          
            row1.AUTHORIZATION_REQUEST_ID = rs_tDBInput_1.getInt(108);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 109) {
								row1.TABS_ORDER_NUMBER = 0;
							} else {
		                          
            row1.TABS_ORDER_NUMBER = rs_tDBInput_1.getInt(109);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 110) {
								row1.FLAG_VALID_PRICE = 0;
							} else {
		                          
            row1.FLAG_VALID_PRICE = rs_tDBInput_1.getInt(110);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 111) {
								row1.BOL_NUMBER = 0;
							} else {
		                          
            row1.BOL_NUMBER = rs_tDBInput_1.getInt(111);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 112) {
								row1.COMPATIBILITY_STATUS = 0;
							} else {
		                          
            row1.COMPATIBILITY_STATUS = rs_tDBInput_1.getInt(112);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 113) {
								row1.OVERRIDE_COMPATIBILITY_CHECKS = 0;
							} else {
		                          
            row1.OVERRIDE_COMPATIBILITY_CHECKS = rs_tDBInput_1.getInt(113);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 114) {
								row1.CANCELLED_FROM_CBS = 0;
							} else {
		                          
            row1.CANCELLED_FROM_CBS = rs_tDBInput_1.getInt(114);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 115) {
								row1.HOST_REF_ID = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(115);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(115).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.HOST_REF_ID = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.HOST_REF_ID = tmpContent_tDBInput_1;
                }
            } else {
                row1.HOST_REF_ID = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 116) {
								row1.UNACCOUNTED_LIMIT_EXCEEDED = 0;
							} else {
		                          
            row1.UNACCOUNTED_LIMIT_EXCEEDED = rs_tDBInput_1.getInt(116);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 117) {
								row1.OVERRIDE_UNACCOUNTED_CHECKS = 0;
							} else {
		                          
            row1.OVERRIDE_UNACCOUNTED_CHECKS = rs_tDBInput_1.getInt(117);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 118) {
								row1.PENDING_PRINT_COUNT = 0;
							} else {
		                          
            row1.PENDING_PRINT_COUNT = rs_tDBInput_1.getInt(118);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 119) {
								row1.PENDING_REQUEST_COUNT = 0;
							} else {
		                          
            row1.PENDING_REQUEST_COUNT = rs_tDBInput_1.getInt(119);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 120) {
								row1.PDXR_RACK_DRIVER_ID = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(120);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(120).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.PDXR_RACK_DRIVER_ID = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.PDXR_RACK_DRIVER_ID = tmpContent_tDBInput_1;
                }
            } else {
                row1.PDXR_RACK_DRIVER_ID = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 121) {
								row1.PDXR_TERMINAL_CONTROL_NUMBER = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(121);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(121).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.PDXR_TERMINAL_CONTROL_NUMBER = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.PDXR_TERMINAL_CONTROL_NUMBER = tmpContent_tDBInput_1;
                }
            } else {
                row1.PDXR_TERMINAL_CONTROL_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 122) {
								row1.PDXR_FINAL_SHIPPER_XCTN_SEQ = 0;
							} else {
		                          
            row1.PDXR_FINAL_SHIPPER_XCTN_SEQ = rs_tDBInput_1.getInt(122);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 123) {
								row1.PDXR_DESTINATION_STATE_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(123);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(123).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.PDXR_DESTINATION_STATE_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.PDXR_DESTINATION_STATE_CODE = tmpContent_tDBInput_1;
                }
            } else {
                row1.PDXR_DESTINATION_STATE_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 124) {
								row1.PDXR_DESTINATION_COUNTY = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(124);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(124).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.PDXR_DESTINATION_COUNTY = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.PDXR_DESTINATION_COUNTY = tmpContent_tDBInput_1;
                }
            } else {
                row1.PDXR_DESTINATION_COUNTY = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 125) {
								row1.PDXR_DESTINATION_CITY = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(125);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(125).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.PDXR_DESTINATION_CITY = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.PDXR_DESTINATION_CITY = tmpContent_tDBInput_1;
                }
            } else {
                row1.PDXR_DESTINATION_CITY = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 126) {
								row1.PDXR_DESTINATION_ZIP_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(126);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(126).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.PDXR_DESTINATION_ZIP_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.PDXR_DESTINATION_ZIP_CODE = tmpContent_tDBInput_1;
                }
            } else {
                row1.PDXR_DESTINATION_ZIP_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 127) {
								row1.PDXR_CARRIER_FEIN = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(127);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(127).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.PDXR_CARRIER_FEIN = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.PDXR_CARRIER_FEIN = tmpContent_tDBInput_1;
                }
            } else {
                row1.PDXR_CARRIER_FEIN = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 128) {
								row1.PDXR_SHIPPER_INFO = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(128);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(128).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.PDXR_SHIPPER_INFO = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.PDXR_SHIPPER_INFO = tmpContent_tDBInput_1;
                }
            } else {
                row1.PDXR_SHIPPER_INFO = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 129) {
								row1.PDXR_VERSION = 0;
							} else {
		                          
            row1.PDXR_VERSION = rs_tDBInput_1.getInt(129);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 130) {
								row1.PDXR_VENDOR = 0;
							} else {
		                          
            row1.PDXR_VENDOR = rs_tDBInput_1.getInt(130);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 131) {
								row1.ORIG_ORDER_ID = null;
							} else {
		                          
            row1.ORIG_ORDER_ID = rs_tDBInput_1.getInt(131);
            if(rs_tDBInput_1.wasNull()){
                    row1.ORIG_ORDER_ID = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 132) {
								row1.PREV_ORDER_ID = null;
							} else {
		                          
            row1.PREV_ORDER_ID = rs_tDBInput_1.getInt(132);
            if(rs_tDBInput_1.wasNull()){
                    row1.PREV_ORDER_ID = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 133) {
								row1.SIGNATURE_PATH = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(133);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(133).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.SIGNATURE_PATH = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.SIGNATURE_PATH = tmpContent_tDBInput_1;
                }
            } else {
                row1.SIGNATURE_PATH = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 134) {
								row1.SIGNATURE_FILE_NAME = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(134);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(134).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.SIGNATURE_FILE_NAME = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.SIGNATURE_FILE_NAME = tmpContent_tDBInput_1;
                }
            } else {
                row1.SIGNATURE_FILE_NAME = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 135) {
								row1.PDXR_AUTHORIZING_SYSTEM = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(135);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(135).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.PDXR_AUTHORIZING_SYSTEM = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.PDXR_AUTHORIZING_SYSTEM = tmpContent_tDBInput_1;
                }
            } else {
                row1.PDXR_AUTHORIZING_SYSTEM = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 136) {
								row1.START_TIMESLOT_DATETIME = null;
							} else {
										
			row1.START_TIMESLOT_DATETIME = mssqlGTU_tDBInput_1.getDate(rsmd_tDBInput_1, rs_tDBInput_1, 136);
			
		                    }
							if(colQtyInRs_tDBInput_1 < 137) {
								row1.END_TIMESLOT_DATETIME = null;
							} else {
										
			row1.END_TIMESLOT_DATETIME = mssqlGTU_tDBInput_1.getDate(rsmd_tDBInput_1, rs_tDBInput_1, 137);
			
		                    }
							if(colQtyInRs_tDBInput_1 < 138) {
								row1.START_PICKUP_DATETIME = null;
							} else {
										
			row1.START_PICKUP_DATETIME = mssqlGTU_tDBInput_1.getDate(rsmd_tDBInput_1, rs_tDBInput_1, 138);
			
		                    }
							if(colQtyInRs_tDBInput_1 < 139) {
								row1.END_PICKUP_DATETIME = null;
							} else {
										
			row1.END_PICKUP_DATETIME = mssqlGTU_tDBInput_1.getDate(rsmd_tDBInput_1, rs_tDBInput_1, 139);
			
		                    }
							if(colQtyInRs_tDBInput_1 < 140) {
								row1.ADMINISTRATIVE_BOOKING = 0;
							} else {
		                          
            row1.ADMINISTRATIVE_BOOKING = rs_tDBInput_1.getInt(140);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
					





 



/**
 * [tDBInput_1 begin ] stop
 */
	
	/**
	 * [tDBInput_1 main ] start
	 */

	

	
	
	currentComponent="tDBInput_1";

	

 


	tos_count_tDBInput_1++;

/**
 * [tDBInput_1 main ] stop
 */
	
	/**
	 * [tDBInput_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_1";

	

 



/**
 * [tDBInput_1 process_data_begin ] stop
 */

	
	/**
	 * [tUniqRow_1 main ] start
	 */

	

	
	
	currentComponent="tUniqRow_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row1"
						
						);
					}
					
row2 = null;			
finder_tUniqRow_1.ORDER_ID = row1.ORDER_ID;	
finder_tUniqRow_1.hashCodeDirty = true;
if (!keystUniqRow_1.contains(finder_tUniqRow_1)) {
		KeyStruct_tUniqRow_1 new_tUniqRow_1 = new KeyStruct_tUniqRow_1();

		
new_tUniqRow_1.ORDER_ID = row1.ORDER_ID;
		
		keystUniqRow_1.add(new_tUniqRow_1);if(row2 == null){ 
	
	row2 = new row2Struct();
}row2.ORDER_ID = row1.ORDER_ID;			row2.LOADED_DRIVER_NUMBER = row1.LOADED_DRIVER_NUMBER;			row2.USER_NAME = row1.USER_NAME;			row2.TRAILER_CARRIER_NUMBER = row1.TRAILER_CARRIER_NUMBER;			row2.CARRIER_NUMBER = row1.CARRIER_NUMBER;			row2.TRAILER_CODE = row1.TRAILER_CODE;			row2.VEHICLE_CARRIER_NUMBER = row1.VEHICLE_CARRIER_NUMBER;			row2.VEHICLE_CODE = row1.VEHICLE_CODE;			row2.TRACTOR_CARRIER_NUMBER = row1.TRACTOR_CARRIER_NUMBER;			row2.LOADED_CARRIER_NUMBER = row1.LOADED_CARRIER_NUMBER;			row2.FOLIO_NUMBER = row1.FOLIO_NUMBER;			row2.TRACTOR_NUMBER = row1.TRACTOR_NUMBER;			row2.DELIVERED_CARRIER_NUMBER = row1.DELIVERED_CARRIER_NUMBER;			row2.DISPATCH_CARRIER_NUMBER = row1.DISPATCH_CARRIER_NUMBER;			row2.DELIVERED_DRIVER_NUMBER = row1.DELIVERED_DRIVER_NUMBER;			row2.SUPPLIER_NUMBER = row1.SUPPLIER_NUMBER;			row2.CUSTOMER_NUMBER = row1.CUSTOMER_NUMBER;			row2.TABS_CARRIER_ID = row1.TABS_CARRIER_ID;			row2.DESTINATION_NUMBER = row1.DESTINATION_NUMBER;			row2.TRIP_ID = row1.TRIP_ID;			row2.TABS_TRUCK_NUMBER = row1.TABS_TRUCK_NUMBER;			row2.TYPE = row1.TYPE;			row2.SHOST_SU_SUPPLIER_NUMBER = row1.SHOST_SU_SUPPLIER_NUMBER;			row2.CREATOR = row1.CREATOR;			row2.EXCHANGE_ALLOCATION_ENABLED = row1.EXCHANGE_ALLOCATION_ENABLED;			row2.MANUALLY_ENTERED = row1.MANUALLY_ENTERED;			row2.SHOST_EX_EHOST_THRU_NUMBER = row1.SHOST_EX_EHOST_THRU_NUMBER;			row2.DEST_ALLOCATION_ENABLED = row1.DEST_ALLOCATION_ENABLED;			row2.THOST_TH_SUPPLIER_NUMBER = row1.THOST_TH_SUPPLIER_NUMBER;			row2.CUST_ALLOC_BY_PRODUCT = row1.CUST_ALLOC_BY_PRODUCT;			row2.CUST_ALLOC_BY_COMPONENT = row1.CUST_ALLOC_BY_COMPONENT;			row2.CUST_ALLOC_BY_COMP_GROUP = row1.CUST_ALLOC_BY_COMP_GROUP;			row2.CREDIT_ENABLED = row1.CREDIT_ENABLED;			row2.THOST_EX_THOST_EXCH_NUMBER = row1.THOST_EX_THOST_EXCH_NUMBER;			row2.BILLING_TYPE = row1.BILLING_TYPE;			row2.EXCH_ALLOC_BY_PRODUCT = row1.EXCH_ALLOC_BY_PRODUCT;			row2.EXCH_ALLOC_BY_PRODUCT_GROUP = row1.EXCH_ALLOC_BY_PRODUCT_GROUP;			row2.CUSTOMER_ALLOCATION_ENABLED = row1.CUSTOMER_ALLOCATION_ENABLED;			row2.TABS_FINAL_SHIPPER_ID = row1.TABS_FINAL_SHIPPER_ID;			row2.CUST_ALLOC_BY_PRODUCT_GROUP = row1.CUST_ALLOC_BY_PRODUCT_GROUP;			row2.MOVEMENT_NUMBER = row1.MOVEMENT_NUMBER;			row2.REVISION_NUMBER = row1.REVISION_NUMBER;			row2.TABS_SELLER_ID = row1.TABS_SELLER_ID;			row2.REVISED = row1.REVISED;			row2.TABS_CONSIGNEE_NUMBER = row1.TABS_CONSIGNEE_NUMBER;			row2.STATUS = row1.STATUS;			row2.CHOST_CU_SUPPLIER_NUMBER = row1.CHOST_CU_SUPPLIER_NUMBER;			row2.CHOST_CU_CUSTOMER_NUMBER = row1.CHOST_CU_CUSTOMER_NUMBER;			row2.STATUS_DATE = row1.STATUS_DATE;			row2.PURCHASE_ORDER_NUMBER = row1.PURCHASE_ORDER_NUMBER;			row2.REQUISITION_NUMBER = row1.REQUISITION_NUMBER;			row2.BOL_COMMENT_1 = row1.BOL_COMMENT_1;			row2.BOL_COMMENT_2 = row1.BOL_COMMENT_2;			row2.INVOICE_REQUIRED = row1.INVOICE_REQUIRED;			row2.INVOICE_COMMENT_1 = row1.INVOICE_COMMENT_1;			row2.INVOICE_COMMENT_2 = row1.INVOICE_COMMENT_2;			row2.INVOICE_PRINTED = row1.INVOICE_PRINTED;			row2.DESTINATION_COMMENT_1 = row1.DESTINATION_COMMENT_1;			row2.DESTINATION_COMMENT_2 = row1.DESTINATION_COMMENT_2;			row2.TABS_SUBSCRIBER = row1.TABS_SUBSCRIBER;			row2.REMARKS = row1.REMARKS;			row2.START_LOAD_TIME = row1.START_LOAD_TIME;			row2.END_LOAD_TIME = row1.END_LOAD_TIME;			row2.DELIVERY_FEE = row1.DELIVERY_FEE;			row2.TABS_AUTHORIZATION_NUMBER = row1.TABS_AUTHORIZATION_NUMBER;			row2.THRUPUTTER_NUMBER = row1.THRUPUTTER_NUMBER;			row2.LAST_USER_NAME = row1.LAST_USER_NAME;			row2.LAST_MODIFIED = row1.LAST_MODIFIED;			row2.BOL_PRINTED = row1.BOL_PRINTED;			row2.ORDER_ENTRY_TIME = row1.ORDER_ENTRY_TIME;			row2.BILL_FREIGHT = row1.BILL_FREIGHT;			row2.DELIVERY_DATE = row1.DELIVERY_DATE;			row2.SHIFT = row1.SHIFT;			row2.STOP = row1.STOP;			row2.DELIVERY_CONFIRMED = row1.DELIVERY_CONFIRMED;			row2.VALIDATING_NODE_NAME = row1.VALIDATING_NODE_NAME;			row2.HOST_PROCESSED = row1.HOST_PROCESSED;			row2.PETROEX_COMPANY_CODE = row1.PETROEX_COMPANY_CODE;			row2.PETROEX_CONSIGNEE_NUMBER = row1.PETROEX_CONSIGNEE_NUMBER;			row2.PETROEX_THIRD_PARTY = row1.PETROEX_THIRD_PARTY;			row2.PETROEX_CARRIER_CODE = row1.PETROEX_CARRIER_CODE;			row2.PETROEX_TRUCK_NUMBER = row1.PETROEX_TRUCK_NUMBER;			row2.PETROEX_SUBSCRIBER = row1.PETROEX_SUBSCRIBER;			row2.FAN_COMMENT_1 = row1.FAN_COMMENT_1;			row2.PETROEX_CITY_CODE = row1.PETROEX_CITY_CODE;			row2.FAN_COMMENT_2 = row1.FAN_COMMENT_2;			row2.PETROEX_COUNTY_CODE = row1.PETROEX_COUNTY_CODE;			row2.PRELOAD_ORDER = row1.PRELOAD_ORDER;			row2.PETROEX_STATE_CODE = row1.PETROEX_STATE_CODE;			row2.CONTRACT_ALLOCATION_ENABLED = row1.CONTRACT_ALLOCATION_ENABLED;			row2.PETROEX_FEIN = row1.PETROEX_FEIN;			row2.ELVIS_ORDER_NUMBER = row1.ELVIS_ORDER_NUMBER;			row2.PETROEX_SHIPPER_INFO = row1.PETROEX_SHIPPER_INFO;			row2.ELVIS_LOADSPOT_ID = row1.ELVIS_LOADSPOT_ID;			row2.PETROEX_VEHICLE_TYPE = row1.PETROEX_VEHICLE_TYPE;			row2.OVERWEIGHT_TRAILER = row1.OVERWEIGHT_TRAILER;			row2.ELVIS_AUTHORIZED = row1.ELVIS_AUTHORIZED;			row2.DISPATCHED_WITH_TRAILER = row1.DISPATCHED_WITH_TRAILER;			row2.DISPATCHED_WITH_DRIVER = row1.DISPATCHED_WITH_DRIVER;			row2.COMMITTED_PRICE = row1.COMMITTED_PRICE;			row2.LOADED_PRICE = row1.LOADED_PRICE;			row2.CONTRACT_NUMBER = row1.CONTRACT_NUMBER;			row2.MANUALLY_COMPLETED = row1.MANUALLY_COMPLETED;			row2.OVERRIDE_TOLERANCE_CHECKS = row1.OVERRIDE_TOLERANCE_CHECKS;			row2.AIC_STATUS = row1.AIC_STATUS;			row2.BLEND_TOLERANCE_STATUS = row1.BLEND_TOLERANCE_STATUS;			row2.ADDITIVE_TOLERANCE_STATUS = row1.ADDITIVE_TOLERANCE_STATUS;			row2.AUTHORIZATION_REQUEST_ID = row1.AUTHORIZATION_REQUEST_ID;			row2.TABS_ORDER_NUMBER = row1.TABS_ORDER_NUMBER;			row2.FLAG_VALID_PRICE = row1.FLAG_VALID_PRICE;			row2.BOL_NUMBER = row1.BOL_NUMBER;			row2.COMPATIBILITY_STATUS = row1.COMPATIBILITY_STATUS;			row2.OVERRIDE_COMPATIBILITY_CHECKS = row1.OVERRIDE_COMPATIBILITY_CHECKS;			row2.CANCELLED_FROM_CBS = row1.CANCELLED_FROM_CBS;			row2.HOST_REF_ID = row1.HOST_REF_ID;			row2.UNACCOUNTED_LIMIT_EXCEEDED = row1.UNACCOUNTED_LIMIT_EXCEEDED;			row2.OVERRIDE_UNACCOUNTED_CHECKS = row1.OVERRIDE_UNACCOUNTED_CHECKS;			row2.PENDING_PRINT_COUNT = row1.PENDING_PRINT_COUNT;			row2.PENDING_REQUEST_COUNT = row1.PENDING_REQUEST_COUNT;			row2.PDXR_RACK_DRIVER_ID = row1.PDXR_RACK_DRIVER_ID;			row2.PDXR_TERMINAL_CONTROL_NUMBER = row1.PDXR_TERMINAL_CONTROL_NUMBER;			row2.PDXR_FINAL_SHIPPER_XCTN_SEQ = row1.PDXR_FINAL_SHIPPER_XCTN_SEQ;			row2.PDXR_DESTINATION_STATE_CODE = row1.PDXR_DESTINATION_STATE_CODE;			row2.PDXR_DESTINATION_COUNTY = row1.PDXR_DESTINATION_COUNTY;			row2.PDXR_DESTINATION_CITY = row1.PDXR_DESTINATION_CITY;			row2.PDXR_DESTINATION_ZIP_CODE = row1.PDXR_DESTINATION_ZIP_CODE;			row2.PDXR_CARRIER_FEIN = row1.PDXR_CARRIER_FEIN;			row2.PDXR_SHIPPER_INFO = row1.PDXR_SHIPPER_INFO;			row2.PDXR_VERSION = row1.PDXR_VERSION;			row2.PDXR_VENDOR = row1.PDXR_VENDOR;			row2.ORIG_ORDER_ID = row1.ORIG_ORDER_ID;			row2.PREV_ORDER_ID = row1.PREV_ORDER_ID;			row2.SIGNATURE_PATH = row1.SIGNATURE_PATH;			row2.SIGNATURE_FILE_NAME = row1.SIGNATURE_FILE_NAME;			row2.PDXR_AUTHORIZING_SYSTEM = row1.PDXR_AUTHORIZING_SYSTEM;			row2.START_TIMESLOT_DATETIME = row1.START_TIMESLOT_DATETIME;			row2.END_TIMESLOT_DATETIME = row1.END_TIMESLOT_DATETIME;			row2.START_PICKUP_DATETIME = row1.START_PICKUP_DATETIME;			row2.END_PICKUP_DATETIME = row1.END_PICKUP_DATETIME;			row2.ADMINISTRATIVE_BOOKING = row1.ADMINISTRATIVE_BOOKING;					
		nb_uniques_tUniqRow_1++;
	} else {
	  nb_duplicates_tUniqRow_1++;
	}

 


	tos_count_tUniqRow_1++;

/**
 * [tUniqRow_1 main ] stop
 */
	
	/**
	 * [tUniqRow_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tUniqRow_1";

	

 



/**
 * [tUniqRow_1 process_data_begin ] stop
 */
// Start of branch "row2"
if(row2 != null) { 



	
	/**
	 * [tMap_1 main ] start
	 */

	

	
	
	currentComponent="tMap_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row2"
						
						);
					}
					

		
		
		boolean hasCasePrimitiveKeyWithNull_tMap_1 = false;
		

        // ###############################
        // # Input tables (lookups)
		  boolean rejectedInnerJoin_tMap_1 = false;
		  boolean mainRowRejected_tMap_1 = false;
            				    								  
		

				///////////////////////////////////////////////
				// Starting Lookup Table "row3" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLooprow3 = false;
       		  	    	
       		  	    	
 							row3Struct row3ObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_1) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_1 = false;
								
	                        		    	Object exprKeyValue_row3__ORDER_ID = row2.ORDER_ID ;
	                        		    	if(exprKeyValue_row3__ORDER_ID == null) {
	                        		    		hasCasePrimitiveKeyWithNull_tMap_1 = true;
	                        		    	} else {
                        		    			row3HashKey.ORDER_ID = (int)(Integer) exprKeyValue_row3__ORDER_ID;
                        		    		}
                        		    		

								
		                        	row3HashKey.hashCodeDirty = true;
                        		
	  					
	  							
	
		  							if(!hasCasePrimitiveKeyWithNull_tMap_1) { // G_TM_M_091
		  							
			  					
			  					
			  					
	  					
		  							tHash_Lookup_row3.lookup( row3HashKey );

	  							

	  							

			  						} // G_TM_M_091
			  						
			  					

 								
		  				
	  								
						
									
  									  		
 								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_row3 != null && tHash_Lookup_row3.getCount(row3HashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row3' and it contains more one result from keys :  row3.ORDER_ID = '" + row3HashKey.ORDER_ID + "'");
								} // G 071
							

							row3Struct row3 = null;
                    		  	 
							   
                    		  	 
	       		  	    	row3Struct fromLookup_row3 = null;
							row3 = row3Default;
										 
							
								 
							
							
								if (tHash_Lookup_row3 !=null && tHash_Lookup_row3.hasNext()) { // G 099
								
							
								
								fromLookup_row3 = tHash_Lookup_row3.next();

							
							
								} // G 099
							
							

							if(fromLookup_row3 != null) {
								row3 = fromLookup_row3;
							}
							
							
							
			  							
								
	                    		  	
		                    
	            	
	            	
	            // ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_1__Struct Var = Var__tMap_1;
Var.PK_ORDERS = Numeric.sequence("s12",1,1) ;// ###############################
        // ###############################
        // # Output tables

out1 = null;


// # Output table : 'out1'
out1_tmp.PK_ORDERS = Var.PK_ORDERS ;
out1_tmp.ORDER_ID = row2.ORDER_ID ;
out1_tmp.LOADED_DRIVER_NUMBER = row2.LOADED_DRIVER_NUMBER ;
out1_tmp.CARRIER_NUMBER = row2.CARRIER_NUMBER ;
out1_tmp.LOADED_CARRIER_NUMBER = row2.LOADED_CARRIER_NUMBER ;
out1_tmp.FOLIO_NUMBER = row2.FOLIO_NUMBER ;
out1_tmp.DISPATCH_CARRIER_NUMBER = row2.DISPATCH_CARRIER_NUMBER ;
out1_tmp.SUPPLIER_NUMBER = row2.SUPPLIER_NUMBER ;
out1_tmp.CUSTOMER_NUMBER = row2.CUSTOMER_NUMBER ;
out1_tmp.DESTINATION_NUMBER = row2.DESTINATION_NUMBER ;
out1_tmp.TRIP_ID = row2.TRIP_ID ;
out1_tmp.TYPE = row2.TYPE ;
out1_tmp.CREATOR = row2.CREATOR ;
out1_tmp.MANUALLY_ENTERED = row2.MANUALLY_ENTERED ;
out1_tmp.MOVEMENT_NUMBER = row2.MOVEMENT_NUMBER ;
out1_tmp.REVISION_NUMBER = row2.REVISION_NUMBER ;
out1_tmp.REVISED = row2.REVISED ;
out1_tmp.STATUS = row2.STATUS ;
out1_tmp.STATUS_DATE = row2.STATUS_DATE ;
out1_tmp.START_LOAD_TIME = row2.START_LOAD_TIME ;
out1_tmp.END_LOAD_TIME = row2.END_LOAD_TIME ;
out1_tmp.LAST_USER_NAME = row2.LAST_USER_NAME ;
out1_tmp.LAST_MODIFIED = row2.LAST_MODIFIED ;
out1_tmp.BOL_PRINTED = row2.BOL_PRINTED ;
out1_tmp.ORDER_ENTRY_TIME = row2.ORDER_ENTRY_TIME ;
out1_tmp.MANUALLY_COMPLETED = row2.MANUALLY_COMPLETED ;
out1_tmp.AIC_STATUS = row2.AIC_STATUS ;
out1_tmp.AUTHORIZATION_REQUEST_ID = row2.AUTHORIZATION_REQUEST_ID ;
out1 = out1_tmp;
// ###############################

} // end of Var scope

rejectedInnerJoin_tMap_1 = false;










 


	tos_count_tMap_1++;

/**
 * [tMap_1 main ] stop
 */
	
	/**
	 * [tMap_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMap_1";

	

 



/**
 * [tMap_1 process_data_begin ] stop
 */
// Start of branch "out1"
if(out1 != null) { 



	
	/**
	 * [tDBOutput_1 main ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"out1"
						
						);
					}
					



        whetherReject_tDBOutput_1 = false;


                    if(out1.PK_ORDERS == null) {
pstmt_tDBOutput_1.setNull(1, java.sql.Types.INTEGER);
} else {pstmt_tDBOutput_1.setInt(1, out1.PK_ORDERS);
}

            int checkCount_tDBOutput_1 = -1;
            try (java.sql.ResultSet rs_tDBOutput_1 = pstmt_tDBOutput_1.executeQuery()) {
                while(rs_tDBOutput_1.next()) {
                    checkCount_tDBOutput_1 = rs_tDBOutput_1.getInt(1);
                }
            }
            if(checkCount_tDBOutput_1 > 0) {
                        pstmtUpdate_tDBOutput_1.setInt(1, out1.ORDER_ID);

                        if(out1.LOADED_DRIVER_NUMBER == null) {
pstmtUpdate_tDBOutput_1.setNull(2, java.sql.Types.INTEGER);
} else {pstmtUpdate_tDBOutput_1.setInt(2, out1.LOADED_DRIVER_NUMBER);
}

                        pstmtUpdate_tDBOutput_1.setInt(3, out1.CARRIER_NUMBER);

                        if(out1.LOADED_CARRIER_NUMBER == null) {
pstmtUpdate_tDBOutput_1.setNull(4, java.sql.Types.INTEGER);
} else {pstmtUpdate_tDBOutput_1.setInt(4, out1.LOADED_CARRIER_NUMBER);
}

                        if(out1.FOLIO_NUMBER == null) {
pstmtUpdate_tDBOutput_1.setNull(5, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(5, out1.FOLIO_NUMBER);
}

                        if(out1.DISPATCH_CARRIER_NUMBER == null) {
pstmtUpdate_tDBOutput_1.setNull(6, java.sql.Types.INTEGER);
} else {pstmtUpdate_tDBOutput_1.setInt(6, out1.DISPATCH_CARRIER_NUMBER);
}

                        pstmtUpdate_tDBOutput_1.setInt(7, out1.SUPPLIER_NUMBER);

                        pstmtUpdate_tDBOutput_1.setInt(8, out1.CUSTOMER_NUMBER);

                        pstmtUpdate_tDBOutput_1.setInt(9, out1.DESTINATION_NUMBER);

                        if(out1.TRIP_ID == null) {
pstmtUpdate_tDBOutput_1.setNull(10, java.sql.Types.INTEGER);
} else {pstmtUpdate_tDBOutput_1.setInt(10, out1.TRIP_ID);
}

                        pstmtUpdate_tDBOutput_1.setInt(11, out1.TYPE);

                        pstmtUpdate_tDBOutput_1.setInt(12, out1.CREATOR);

                        pstmtUpdate_tDBOutput_1.setInt(13, out1.MANUALLY_ENTERED);

                        pstmtUpdate_tDBOutput_1.setInt(14, out1.MOVEMENT_NUMBER);

                        pstmtUpdate_tDBOutput_1.setInt(15, out1.REVISION_NUMBER);

                        pstmtUpdate_tDBOutput_1.setInt(16, out1.REVISED);

                        pstmtUpdate_tDBOutput_1.setInt(17, out1.STATUS);

                        if(out1.STATUS_DATE != null) {
pstmtUpdate_tDBOutput_1.setTimestamp(18, new java.sql.Timestamp(out1.STATUS_DATE.getTime()));
} else {
pstmtUpdate_tDBOutput_1.setNull(18, java.sql.Types.TIMESTAMP);
}

                        if(out1.START_LOAD_TIME != null) {
pstmtUpdate_tDBOutput_1.setTimestamp(19, new java.sql.Timestamp(out1.START_LOAD_TIME.getTime()));
} else {
pstmtUpdate_tDBOutput_1.setNull(19, java.sql.Types.TIMESTAMP);
}

                        if(out1.END_LOAD_TIME != null) {
pstmtUpdate_tDBOutput_1.setTimestamp(20, new java.sql.Timestamp(out1.END_LOAD_TIME.getTime()));
} else {
pstmtUpdate_tDBOutput_1.setNull(20, java.sql.Types.TIMESTAMP);
}

                        if(out1.LAST_USER_NAME == null) {
pstmtUpdate_tDBOutput_1.setNull(21, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(21, out1.LAST_USER_NAME);
}

                        if(out1.LAST_MODIFIED != null) {
pstmtUpdate_tDBOutput_1.setTimestamp(22, new java.sql.Timestamp(out1.LAST_MODIFIED.getTime()));
} else {
pstmtUpdate_tDBOutput_1.setNull(22, java.sql.Types.TIMESTAMP);
}

                        pstmtUpdate_tDBOutput_1.setInt(23, out1.BOL_PRINTED);

                        if(out1.ORDER_ENTRY_TIME != null) {
pstmtUpdate_tDBOutput_1.setTimestamp(24, new java.sql.Timestamp(out1.ORDER_ENTRY_TIME.getTime()));
} else {
pstmtUpdate_tDBOutput_1.setNull(24, java.sql.Types.TIMESTAMP);
}

                        pstmtUpdate_tDBOutput_1.setInt(25, out1.MANUALLY_COMPLETED);

                        pstmtUpdate_tDBOutput_1.setInt(26, out1.AIC_STATUS);

                        pstmtUpdate_tDBOutput_1.setInt(27, out1.AUTHORIZATION_REQUEST_ID);


	                    

                        if(out1.PK_ORDERS == null) {
pstmtUpdate_tDBOutput_1.setNull(28 + count_tDBOutput_1, java.sql.Types.INTEGER);
} else {pstmtUpdate_tDBOutput_1.setInt(28 + count_tDBOutput_1, out1.PK_ORDERS);
}

            try {
                    int processedCount_tDBOutput_1 = pstmtUpdate_tDBOutput_1.executeUpdate();
                    updatedCount_tDBOutput_1 += processedCount_tDBOutput_1;
                    rowsToCommitCount_tDBOutput_1 += processedCount_tDBOutput_1;
                    nb_line_tDBOutput_1++;
        			
                } catch(java.lang.Exception e) {
globalMap.put("tDBOutput_1_ERROR_MESSAGE",e.getMessage());
                    whetherReject_tDBOutput_1 = true;
                    	nb_line_tDBOutput_1++;
                    	
                            System.err.println(e.getMessage());
                }
            } else {
                        if(out1.PK_ORDERS == null) {
pstmtInsert_tDBOutput_1.setNull(1, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_1.setInt(1, out1.PK_ORDERS);
}

                        pstmtInsert_tDBOutput_1.setInt(2, out1.ORDER_ID);

                        if(out1.LOADED_DRIVER_NUMBER == null) {
pstmtInsert_tDBOutput_1.setNull(3, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_1.setInt(3, out1.LOADED_DRIVER_NUMBER);
}

                        pstmtInsert_tDBOutput_1.setInt(4, out1.CARRIER_NUMBER);

                        if(out1.LOADED_CARRIER_NUMBER == null) {
pstmtInsert_tDBOutput_1.setNull(5, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_1.setInt(5, out1.LOADED_CARRIER_NUMBER);
}

                        if(out1.FOLIO_NUMBER == null) {
pstmtInsert_tDBOutput_1.setNull(6, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(6, out1.FOLIO_NUMBER);
}

                        if(out1.DISPATCH_CARRIER_NUMBER == null) {
pstmtInsert_tDBOutput_1.setNull(7, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_1.setInt(7, out1.DISPATCH_CARRIER_NUMBER);
}

                        pstmtInsert_tDBOutput_1.setInt(8, out1.SUPPLIER_NUMBER);

                        pstmtInsert_tDBOutput_1.setInt(9, out1.CUSTOMER_NUMBER);

                        pstmtInsert_tDBOutput_1.setInt(10, out1.DESTINATION_NUMBER);

                        if(out1.TRIP_ID == null) {
pstmtInsert_tDBOutput_1.setNull(11, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_1.setInt(11, out1.TRIP_ID);
}

                        pstmtInsert_tDBOutput_1.setInt(12, out1.TYPE);

                        pstmtInsert_tDBOutput_1.setInt(13, out1.CREATOR);

                        pstmtInsert_tDBOutput_1.setInt(14, out1.MANUALLY_ENTERED);

                        pstmtInsert_tDBOutput_1.setInt(15, out1.MOVEMENT_NUMBER);

                        pstmtInsert_tDBOutput_1.setInt(16, out1.REVISION_NUMBER);

                        pstmtInsert_tDBOutput_1.setInt(17, out1.REVISED);

                        pstmtInsert_tDBOutput_1.setInt(18, out1.STATUS);

                        if(out1.STATUS_DATE != null) {
pstmtInsert_tDBOutput_1.setTimestamp(19, new java.sql.Timestamp(out1.STATUS_DATE.getTime()));
} else {
pstmtInsert_tDBOutput_1.setNull(19, java.sql.Types.TIMESTAMP);
}

                        if(out1.START_LOAD_TIME != null) {
pstmtInsert_tDBOutput_1.setTimestamp(20, new java.sql.Timestamp(out1.START_LOAD_TIME.getTime()));
} else {
pstmtInsert_tDBOutput_1.setNull(20, java.sql.Types.TIMESTAMP);
}

                        if(out1.END_LOAD_TIME != null) {
pstmtInsert_tDBOutput_1.setTimestamp(21, new java.sql.Timestamp(out1.END_LOAD_TIME.getTime()));
} else {
pstmtInsert_tDBOutput_1.setNull(21, java.sql.Types.TIMESTAMP);
}

                        if(out1.LAST_USER_NAME == null) {
pstmtInsert_tDBOutput_1.setNull(22, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(22, out1.LAST_USER_NAME);
}

                        if(out1.LAST_MODIFIED != null) {
pstmtInsert_tDBOutput_1.setTimestamp(23, new java.sql.Timestamp(out1.LAST_MODIFIED.getTime()));
} else {
pstmtInsert_tDBOutput_1.setNull(23, java.sql.Types.TIMESTAMP);
}

                        pstmtInsert_tDBOutput_1.setInt(24, out1.BOL_PRINTED);

                        if(out1.ORDER_ENTRY_TIME != null) {
pstmtInsert_tDBOutput_1.setTimestamp(25, new java.sql.Timestamp(out1.ORDER_ENTRY_TIME.getTime()));
} else {
pstmtInsert_tDBOutput_1.setNull(25, java.sql.Types.TIMESTAMP);
}

                        pstmtInsert_tDBOutput_1.setInt(26, out1.MANUALLY_COMPLETED);

                        pstmtInsert_tDBOutput_1.setInt(27, out1.AIC_STATUS);

                        pstmtInsert_tDBOutput_1.setInt(28, out1.AUTHORIZATION_REQUEST_ID);

            try {
                    int processedCount_tDBOutput_1 = pstmtInsert_tDBOutput_1.executeUpdate();
                    insertedCount_tDBOutput_1 += processedCount_tDBOutput_1;
                    rowsToCommitCount_tDBOutput_1 += processedCount_tDBOutput_1;
                    nb_line_tDBOutput_1++;
                } catch(java.lang.Exception e) {
globalMap.put("tDBOutput_1_ERROR_MESSAGE",e.getMessage());
                    whetherReject_tDBOutput_1 = true;
                    	nb_line_tDBOutput_1++;
                    	
                            System.err.println(e.getMessage());
                }
            }
            	//////////batch execute by batch size///////
            	class LimitBytesHelper_tDBOutput_1{
            		public int limitBytePart1(int counter,java.sql.PreparedStatement pstmt_tDBOutput_1) throws Exception {
                try {
						
						for(int countEach_tDBOutput_1: pstmt_tDBOutput_1.executeBatch()) {
							if(countEach_tDBOutput_1 == -2 || countEach_tDBOutput_1 == -3) {
								break;
							}
							counter += countEach_tDBOutput_1;
						}
						
                }catch (java.sql.BatchUpdateException e){
globalMap.put("tDBOutput_1_ERROR_MESSAGE",e.getMessage());
                	
                	int countSum_tDBOutput_1 = 0;
					for(int countEach_tDBOutput_1: e.getUpdateCounts()) {
						counter += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
					}
				
            	    	
                		System.err.println(e.getMessage());
                	
               			 }
    				return counter;
            	}
            	
            	public int limitBytePart2(int counter,java.sql.PreparedStatement pstmt_tDBOutput_1) throws Exception {
                try {
                		
						for(int countEach_tDBOutput_1: pstmt_tDBOutput_1.executeBatch()) {
							if(countEach_tDBOutput_1 == -2 || countEach_tDBOutput_1 == -3) {
								break;
							}
							counter += countEach_tDBOutput_1;
						}
						
                }catch (java.sql.BatchUpdateException e){
globalMap.put("tDBOutput_1_ERROR_MESSAGE",e.getMessage());
                	
                	
					for(int countEach_tDBOutput_1: e.getUpdateCounts()) {
						counter += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
					}
					
            	    	
                        System.err.println(e.getMessage());
                	
                		}	
                	return counter;	
            	}
            }

    	////////////commit every////////////
    			
    		    commitCounter_tDBOutput_1++;
                if(commitEvery_tDBOutput_1 <= commitCounter_tDBOutput_1) {
                if(rowsToCommitCount_tDBOutput_1 != 0){
                	
                }
                conn_tDBOutput_1.commit();
                if(rowsToCommitCount_tDBOutput_1 != 0){
                	
                	rowsToCommitCount_tDBOutput_1 = 0;	
                }
                commitCounter_tDBOutput_1=0;
                }

 


	tos_count_tDBOutput_1++;

/**
 * [tDBOutput_1 main ] stop
 */
	
	/**
	 * [tDBOutput_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	

 



/**
 * [tDBOutput_1 process_data_begin ] stop
 */
	
	/**
	 * [tDBOutput_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	

 



/**
 * [tDBOutput_1 process_data_end ] stop
 */

} // End of branch "out1"




	
	/**
	 * [tMap_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_1";

	

 



/**
 * [tMap_1 process_data_end ] stop
 */

} // End of branch "row2"




	
	/**
	 * [tUniqRow_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tUniqRow_1";

	

 



/**
 * [tUniqRow_1 process_data_end ] stop
 */



	
	/**
	 * [tDBInput_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_1";

	

 



/**
 * [tDBInput_1 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_1 end ] start
	 */

	

	
	
	currentComponent="tDBInput_1";

	

	}
}finally{
	if (rs_tDBInput_1 != null) {
		rs_tDBInput_1.close();
	}
	if (stmt_tDBInput_1 != null) {
		stmt_tDBInput_1.close();
	}
		if(conn_tDBInput_1 != null && !conn_tDBInput_1.isClosed()) {
			
			conn_tDBInput_1.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
		}
}
globalMap.put("tDBInput_1_NB_LINE",nb_line_tDBInput_1);

 

ok_Hash.put("tDBInput_1", true);
end_Hash.put("tDBInput_1", System.currentTimeMillis());




/**
 * [tDBInput_1 end ] stop
 */

	
	/**
	 * [tUniqRow_1 end ] start
	 */

	

	
	
	currentComponent="tUniqRow_1";

	

globalMap.put("tUniqRow_1_NB_UNIQUES",nb_uniques_tUniqRow_1);
globalMap.put("tUniqRow_1_NB_DUPLICATES",nb_duplicates_tUniqRow_1);

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row1");
			  	}
			  	
 

ok_Hash.put("tUniqRow_1", true);
end_Hash.put("tUniqRow_1", System.currentTimeMillis());




/**
 * [tUniqRow_1 end ] stop
 */

	
	/**
	 * [tMap_1 end ] start
	 */

	

	
	
	currentComponent="tMap_1";

	


// ###############################
// # Lookup hashes releasing
					if(tHash_Lookup_row3 != null) {
						tHash_Lookup_row3.endGet();
					}
					globalMap.remove( "tHash_Lookup_row3" );

					
					
				
// ###############################      





				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row2");
			  	}
			  	
 

ok_Hash.put("tMap_1", true);
end_Hash.put("tMap_1", System.currentTimeMillis());




/**
 * [tMap_1 end ] stop
 */

	
	/**
	 * [tDBOutput_1 end ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	



        if(pstmtUpdate_tDBOutput_1 != null){
            pstmtUpdate_tDBOutput_1.close();
            resourceMap.remove("pstmtUpdate_tDBOutput_1");
        }
        if(pstmtInsert_tDBOutput_1 != null){
            pstmtInsert_tDBOutput_1.close();
            resourceMap.remove("pstmtInsert_tDBOutput_1");
        }
        if(pstmt_tDBOutput_1 != null) {
            pstmt_tDBOutput_1.close();
            resourceMap.remove("pstmt_tDBOutput_1");
        }
    resourceMap.put("statementClosed_tDBOutput_1", true);
            if(rowsToCommitCount_tDBOutput_1 != 0){
            	
            }
            conn_tDBOutput_1.commit();
            if(rowsToCommitCount_tDBOutput_1 != 0){
            	
            	rowsToCommitCount_tDBOutput_1 = 0;
            }
            commitCounter_tDBOutput_1 = 0;
        conn_tDBOutput_1 .close();
        resourceMap.put("finish_tDBOutput_1", true);

	nb_line_deleted_tDBOutput_1=nb_line_deleted_tDBOutput_1+ deletedCount_tDBOutput_1;
	nb_line_update_tDBOutput_1=nb_line_update_tDBOutput_1 + updatedCount_tDBOutput_1;
	nb_line_inserted_tDBOutput_1=nb_line_inserted_tDBOutput_1 + insertedCount_tDBOutput_1;
	nb_line_rejected_tDBOutput_1=nb_line_rejected_tDBOutput_1 + rejectedCount_tDBOutput_1;
	
        globalMap.put("tDBOutput_1_NB_LINE",nb_line_tDBOutput_1);
        globalMap.put("tDBOutput_1_NB_LINE_UPDATED",nb_line_update_tDBOutput_1);
        globalMap.put("tDBOutput_1_NB_LINE_INSERTED",nb_line_inserted_tDBOutput_1);
        globalMap.put("tDBOutput_1_NB_LINE_DELETED",nb_line_deleted_tDBOutput_1);
        globalMap.put("tDBOutput_1_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_1);
    

	

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"out1");
			  	}
			  	
 

ok_Hash.put("tDBOutput_1", true);
end_Hash.put("tDBOutput_1", System.currentTimeMillis());




/**
 * [tDBOutput_1 end ] stop
 */









				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
					     			//free memory for "tMap_1"
					     			globalMap.remove("tHash_Lookup_row3"); 
				     			
				try{
					
	
	/**
	 * [tDBInput_1 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_1";

	

 



/**
 * [tDBInput_1 finally ] stop
 */

	
	/**
	 * [tUniqRow_1 finally ] start
	 */

	

	
	
	currentComponent="tUniqRow_1";

	

 



/**
 * [tUniqRow_1 finally ] stop
 */

	
	/**
	 * [tMap_1 finally ] start
	 */

	

	
	
	currentComponent="tMap_1";

	

 



/**
 * [tMap_1 finally ] stop
 */

	
	/**
	 * [tDBOutput_1 finally ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	



    try {
    if (resourceMap.get("statementClosed_tDBOutput_1") == null) {
                java.sql.PreparedStatement pstmtUpdateToClose_tDBOutput_1 = null;
                if ((pstmtUpdateToClose_tDBOutput_1 = (java.sql.PreparedStatement) resourceMap.remove("pstmtUpdate_tDBOutput_1")) != null) {
                    pstmtUpdateToClose_tDBOutput_1.close();
                }
                java.sql.PreparedStatement pstmtInsertToClose_tDBOutput_1 = null;
                if ((pstmtInsertToClose_tDBOutput_1 = (java.sql.PreparedStatement) resourceMap.remove("pstmtInsert_tDBOutput_1")) != null) {
                    pstmtInsertToClose_tDBOutput_1.close();
                }
                java.sql.PreparedStatement pstmtToClose_tDBOutput_1 = null;
                if ((pstmtToClose_tDBOutput_1 = (java.sql.PreparedStatement) resourceMap.remove("pstmt_tDBOutput_1")) != null) {
                    pstmtToClose_tDBOutput_1.close();
                }
    }
    } finally {
        if(resourceMap.get("finish_tDBOutput_1") == null){
            java.sql.Connection ctn_tDBOutput_1 = null;
            if((ctn_tDBOutput_1 = (java.sql.Connection)resourceMap.get("conn_tDBOutput_1")) != null){
                try {
                    ctn_tDBOutput_1.close();
                } catch (java.sql.SQLException sqlEx_tDBOutput_1) {
                    String errorMessage_tDBOutput_1 = "failed to close the connection in tDBOutput_1 :" + sqlEx_tDBOutput_1.getMessage();
                    System.err.println(errorMessage_tDBOutput_1);
                }
            }
        }
    }
 



/**
 * [tDBOutput_1 finally ] stop
 */









				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBInput_1_SUBPROCESS_STATE", 1);
	}
	


public static class row3Struct implements routines.system.IPersistableComparableLookupRow<row3Struct> {
    final static byte[] commonByteArrayLock_PGS_STAGE_DIM_ORDERS = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_DIM_ORDERS = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public int PK_ORDERS;

				public int getPK_ORDERS () {
					return this.PK_ORDERS;
				}
				
			    public int ORDER_ID;

				public int getORDER_ID () {
					return this.ORDER_ID;
				}
				
			    public Integer LOADED_DRIVER_NUMBER;

				public Integer getLOADED_DRIVER_NUMBER () {
					return this.LOADED_DRIVER_NUMBER;
				}
				
			    public int CARRIER_NUMBER;

				public int getCARRIER_NUMBER () {
					return this.CARRIER_NUMBER;
				}
				
			    public Integer LOADED_CARRIER_NUMBER;

				public Integer getLOADED_CARRIER_NUMBER () {
					return this.LOADED_CARRIER_NUMBER;
				}
				
			    public String FOLIO_NUMBER;

				public String getFOLIO_NUMBER () {
					return this.FOLIO_NUMBER;
				}
				
			    public Integer DISPATCH_CARRIER_NUMBER;

				public Integer getDISPATCH_CARRIER_NUMBER () {
					return this.DISPATCH_CARRIER_NUMBER;
				}
				
			    public int SUPPLIER_NUMBER;

				public int getSUPPLIER_NUMBER () {
					return this.SUPPLIER_NUMBER;
				}
				
			    public int CUSTOMER_NUMBER;

				public int getCUSTOMER_NUMBER () {
					return this.CUSTOMER_NUMBER;
				}
				
			    public int DESTINATION_NUMBER;

				public int getDESTINATION_NUMBER () {
					return this.DESTINATION_NUMBER;
				}
				
			    public Integer TRIP_ID;

				public Integer getTRIP_ID () {
					return this.TRIP_ID;
				}
				
			    public int TYPE;

				public int getTYPE () {
					return this.TYPE;
				}
				
			    public int CREATOR;

				public int getCREATOR () {
					return this.CREATOR;
				}
				
			    public int MANUALLY_ENTERED;

				public int getMANUALLY_ENTERED () {
					return this.MANUALLY_ENTERED;
				}
				
			    public int MOVEMENT_NUMBER;

				public int getMOVEMENT_NUMBER () {
					return this.MOVEMENT_NUMBER;
				}
				
			    public int REVISION_NUMBER;

				public int getREVISION_NUMBER () {
					return this.REVISION_NUMBER;
				}
				
			    public int REVISED;

				public int getREVISED () {
					return this.REVISED;
				}
				
			    public int STATUS;

				public int getSTATUS () {
					return this.STATUS;
				}
				
			    public java.util.Date STATUS_DATE;

				public java.util.Date getSTATUS_DATE () {
					return this.STATUS_DATE;
				}
				
			    public java.util.Date START_LOAD_TIME;

				public java.util.Date getSTART_LOAD_TIME () {
					return this.START_LOAD_TIME;
				}
				
			    public java.util.Date END_LOAD_TIME;

				public java.util.Date getEND_LOAD_TIME () {
					return this.END_LOAD_TIME;
				}
				
			    public String LAST_USER_NAME;

				public String getLAST_USER_NAME () {
					return this.LAST_USER_NAME;
				}
				
			    public java.util.Date LAST_MODIFIED;

				public java.util.Date getLAST_MODIFIED () {
					return this.LAST_MODIFIED;
				}
				
			    public int BOL_PRINTED;

				public int getBOL_PRINTED () {
					return this.BOL_PRINTED;
				}
				
			    public java.util.Date ORDER_ENTRY_TIME;

				public java.util.Date getORDER_ENTRY_TIME () {
					return this.ORDER_ENTRY_TIME;
				}
				
			    public int MANUALLY_COMPLETED;

				public int getMANUALLY_COMPLETED () {
					return this.MANUALLY_COMPLETED;
				}
				
			    public int AIC_STATUS;

				public int getAIC_STATUS () {
					return this.AIC_STATUS;
				}
				
			    public int AUTHORIZATION_REQUEST_ID;

				public int getAUTHORIZATION_REQUEST_ID () {
					return this.AUTHORIZATION_REQUEST_ID;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
							result = prime * result + (int) this.ORDER_ID;
						
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final row3Struct other = (row3Struct) obj;
		
						if (this.ORDER_ID != other.ORDER_ID)
							return false;
					

		return true;
    }

	public void copyDataTo(row3Struct other) {

		other.PK_ORDERS = this.PK_ORDERS;
	            other.ORDER_ID = this.ORDER_ID;
	            other.LOADED_DRIVER_NUMBER = this.LOADED_DRIVER_NUMBER;
	            other.CARRIER_NUMBER = this.CARRIER_NUMBER;
	            other.LOADED_CARRIER_NUMBER = this.LOADED_CARRIER_NUMBER;
	            other.FOLIO_NUMBER = this.FOLIO_NUMBER;
	            other.DISPATCH_CARRIER_NUMBER = this.DISPATCH_CARRIER_NUMBER;
	            other.SUPPLIER_NUMBER = this.SUPPLIER_NUMBER;
	            other.CUSTOMER_NUMBER = this.CUSTOMER_NUMBER;
	            other.DESTINATION_NUMBER = this.DESTINATION_NUMBER;
	            other.TRIP_ID = this.TRIP_ID;
	            other.TYPE = this.TYPE;
	            other.CREATOR = this.CREATOR;
	            other.MANUALLY_ENTERED = this.MANUALLY_ENTERED;
	            other.MOVEMENT_NUMBER = this.MOVEMENT_NUMBER;
	            other.REVISION_NUMBER = this.REVISION_NUMBER;
	            other.REVISED = this.REVISED;
	            other.STATUS = this.STATUS;
	            other.STATUS_DATE = this.STATUS_DATE;
	            other.START_LOAD_TIME = this.START_LOAD_TIME;
	            other.END_LOAD_TIME = this.END_LOAD_TIME;
	            other.LAST_USER_NAME = this.LAST_USER_NAME;
	            other.LAST_MODIFIED = this.LAST_MODIFIED;
	            other.BOL_PRINTED = this.BOL_PRINTED;
	            other.ORDER_ENTRY_TIME = this.ORDER_ENTRY_TIME;
	            other.MANUALLY_COMPLETED = this.MANUALLY_COMPLETED;
	            other.AIC_STATUS = this.AIC_STATUS;
	            other.AUTHORIZATION_REQUEST_ID = this.AUTHORIZATION_REQUEST_ID;
	            
	}

	public void copyKeysDataTo(row3Struct other) {

		other.ORDER_ID = this.ORDER_ID;
	            	
	}



	private Integer readInteger(DataInputStream dis, ObjectInputStream ois) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
			intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		Integer intReturn;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
			intReturn = unmarshaller.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, DataOutputStream dos, ObjectOutputStream oos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, DataOutputStream dos,org.jboss.marshalling.Marshaller marshaller ) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}
	
	private String readString(DataInputStream dis, ObjectInputStream ois) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			byte[] byteArray = new byte[length];
			dis.read(byteArray);
			strReturn = new String(byteArray, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			byte[] byteArray = new byte[length];
			unmarshaller.read(byteArray);
			strReturn = new String(byteArray, utf8Charset);
		}
		return strReturn;
	}
	
	private void writeString(String str, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
	}

	private void writeString(String str, DataOutputStream dos, ObjectOutputStream oos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
	}

	private java.util.Date readDate(DataInputStream dis, ObjectInputStream ois) throws IOException{
		java.util.Date dateReturn = null;
		int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller ) throws IOException{
		java.util.Date dateReturn = null;
		int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

	private void writeDate(java.util.Date date1, DataOutputStream dos, ObjectOutputStream oos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
	}
	
	private void writeDate(java.util.Date date1, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
	}

    public void readKeysData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_ORDERS) {

        	try {

        		int length = 0;
		
			        this.ORDER_ID = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_ORDERS) {

        	try {

        		int length = 0;
		
			        this.ORDER_ID = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.ORDER_ID);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.ORDER_ID);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }



    /**
     * Fill Values data by reading ObjectInputStream.
     */
    public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
        try {

			int length = 0;
		
			            this.PK_ORDERS = dis.readInt();
					
						this.LOADED_DRIVER_NUMBER = readInteger(dis,ois);
					
			            this.CARRIER_NUMBER = dis.readInt();
					
						this.LOADED_CARRIER_NUMBER = readInteger(dis,ois);
					
						this.FOLIO_NUMBER = readString(dis,ois);
					
						this.DISPATCH_CARRIER_NUMBER = readInteger(dis,ois);
					
			            this.SUPPLIER_NUMBER = dis.readInt();
					
			            this.CUSTOMER_NUMBER = dis.readInt();
					
			            this.DESTINATION_NUMBER = dis.readInt();
					
						this.TRIP_ID = readInteger(dis,ois);
					
			            this.TYPE = dis.readInt();
					
			            this.CREATOR = dis.readInt();
					
			            this.MANUALLY_ENTERED = dis.readInt();
					
			            this.MOVEMENT_NUMBER = dis.readInt();
					
			            this.REVISION_NUMBER = dis.readInt();
					
			            this.REVISED = dis.readInt();
					
			            this.STATUS = dis.readInt();
					
						this.STATUS_DATE = readDate(dis,ois);
					
						this.START_LOAD_TIME = readDate(dis,ois);
					
						this.END_LOAD_TIME = readDate(dis,ois);
					
						this.LAST_USER_NAME = readString(dis,ois);
					
						this.LAST_MODIFIED = readDate(dis,ois);
					
			            this.BOL_PRINTED = dis.readInt();
					
						this.ORDER_ENTRY_TIME = readDate(dis,ois);
					
			            this.MANUALLY_COMPLETED = dis.readInt();
					
			            this.AIC_STATUS = dis.readInt();
					
			            this.AUTHORIZATION_REQUEST_ID = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
			            this.PK_ORDERS = objectIn.readInt();
					
						this.LOADED_DRIVER_NUMBER = readInteger(dis,objectIn);
					
			            this.CARRIER_NUMBER = objectIn.readInt();
					
						this.LOADED_CARRIER_NUMBER = readInteger(dis,objectIn);
					
						this.FOLIO_NUMBER = readString(dis,objectIn);
					
						this.DISPATCH_CARRIER_NUMBER = readInteger(dis,objectIn);
					
			            this.SUPPLIER_NUMBER = objectIn.readInt();
					
			            this.CUSTOMER_NUMBER = objectIn.readInt();
					
			            this.DESTINATION_NUMBER = objectIn.readInt();
					
						this.TRIP_ID = readInteger(dis,objectIn);
					
			            this.TYPE = objectIn.readInt();
					
			            this.CREATOR = objectIn.readInt();
					
			            this.MANUALLY_ENTERED = objectIn.readInt();
					
			            this.MOVEMENT_NUMBER = objectIn.readInt();
					
			            this.REVISION_NUMBER = objectIn.readInt();
					
			            this.REVISED = objectIn.readInt();
					
			            this.STATUS = objectIn.readInt();
					
						this.STATUS_DATE = readDate(dis,objectIn);
					
						this.START_LOAD_TIME = readDate(dis,objectIn);
					
						this.END_LOAD_TIME = readDate(dis,objectIn);
					
						this.LAST_USER_NAME = readString(dis,objectIn);
					
						this.LAST_MODIFIED = readDate(dis,objectIn);
					
			            this.BOL_PRINTED = objectIn.readInt();
					
						this.ORDER_ENTRY_TIME = readDate(dis,objectIn);
					
			            this.MANUALLY_COMPLETED = objectIn.readInt();
					
			            this.AIC_STATUS = objectIn.readInt();
					
			            this.AUTHORIZATION_REQUEST_ID = objectIn.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
		            	dos.writeInt(this.PK_ORDERS);
					
					writeInteger(this.LOADED_DRIVER_NUMBER, dos, oos);
					
		            	dos.writeInt(this.CARRIER_NUMBER);
					
					writeInteger(this.LOADED_CARRIER_NUMBER, dos, oos);
					
						writeString(this.FOLIO_NUMBER, dos, oos);
					
					writeInteger(this.DISPATCH_CARRIER_NUMBER, dos, oos);
					
		            	dos.writeInt(this.SUPPLIER_NUMBER);
					
		            	dos.writeInt(this.CUSTOMER_NUMBER);
					
		            	dos.writeInt(this.DESTINATION_NUMBER);
					
					writeInteger(this.TRIP_ID, dos, oos);
					
		            	dos.writeInt(this.TYPE);
					
		            	dos.writeInt(this.CREATOR);
					
		            	dos.writeInt(this.MANUALLY_ENTERED);
					
		            	dos.writeInt(this.MOVEMENT_NUMBER);
					
		            	dos.writeInt(this.REVISION_NUMBER);
					
		            	dos.writeInt(this.REVISED);
					
		            	dos.writeInt(this.STATUS);
					
						writeDate(this.STATUS_DATE, dos, oos);
					
						writeDate(this.START_LOAD_TIME, dos, oos);
					
						writeDate(this.END_LOAD_TIME, dos, oos);
					
						writeString(this.LAST_USER_NAME, dos, oos);
					
						writeDate(this.LAST_MODIFIED, dos, oos);
					
		            	dos.writeInt(this.BOL_PRINTED);
					
						writeDate(this.ORDER_ENTRY_TIME, dos, oos);
					
		            	dos.writeInt(this.MANUALLY_COMPLETED);
					
		            	dos.writeInt(this.AIC_STATUS);
					
		            	dos.writeInt(this.AUTHORIZATION_REQUEST_ID);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
					objectOut.writeInt(this.PK_ORDERS);
					
					writeInteger(this.LOADED_DRIVER_NUMBER, dos, objectOut);
					
					objectOut.writeInt(this.CARRIER_NUMBER);
					
					writeInteger(this.LOADED_CARRIER_NUMBER, dos, objectOut);
					
						writeString(this.FOLIO_NUMBER, dos, objectOut);
					
					writeInteger(this.DISPATCH_CARRIER_NUMBER, dos, objectOut);
					
					objectOut.writeInt(this.SUPPLIER_NUMBER);
					
					objectOut.writeInt(this.CUSTOMER_NUMBER);
					
					objectOut.writeInt(this.DESTINATION_NUMBER);
					
					writeInteger(this.TRIP_ID, dos, objectOut);
					
					objectOut.writeInt(this.TYPE);
					
					objectOut.writeInt(this.CREATOR);
					
					objectOut.writeInt(this.MANUALLY_ENTERED);
					
					objectOut.writeInt(this.MOVEMENT_NUMBER);
					
					objectOut.writeInt(this.REVISION_NUMBER);
					
					objectOut.writeInt(this.REVISED);
					
					objectOut.writeInt(this.STATUS);
					
						writeDate(this.STATUS_DATE, dos, objectOut);
					
						writeDate(this.START_LOAD_TIME, dos, objectOut);
					
						writeDate(this.END_LOAD_TIME, dos, objectOut);
					
						writeString(this.LAST_USER_NAME, dos, objectOut);
					
						writeDate(this.LAST_MODIFIED, dos, objectOut);
					
					objectOut.writeInt(this.BOL_PRINTED);
					
						writeDate(this.ORDER_ENTRY_TIME, dos, objectOut);
					
					objectOut.writeInt(this.MANUALLY_COMPLETED);
					
					objectOut.writeInt(this.AIC_STATUS);
					
					objectOut.writeInt(this.AUTHORIZATION_REQUEST_ID);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}
    }


    
    public boolean supportMarshaller(){
        return true;
    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("PK_ORDERS="+String.valueOf(PK_ORDERS));
		sb.append(",ORDER_ID="+String.valueOf(ORDER_ID));
		sb.append(",LOADED_DRIVER_NUMBER="+String.valueOf(LOADED_DRIVER_NUMBER));
		sb.append(",CARRIER_NUMBER="+String.valueOf(CARRIER_NUMBER));
		sb.append(",LOADED_CARRIER_NUMBER="+String.valueOf(LOADED_CARRIER_NUMBER));
		sb.append(",FOLIO_NUMBER="+FOLIO_NUMBER);
		sb.append(",DISPATCH_CARRIER_NUMBER="+String.valueOf(DISPATCH_CARRIER_NUMBER));
		sb.append(",SUPPLIER_NUMBER="+String.valueOf(SUPPLIER_NUMBER));
		sb.append(",CUSTOMER_NUMBER="+String.valueOf(CUSTOMER_NUMBER));
		sb.append(",DESTINATION_NUMBER="+String.valueOf(DESTINATION_NUMBER));
		sb.append(",TRIP_ID="+String.valueOf(TRIP_ID));
		sb.append(",TYPE="+String.valueOf(TYPE));
		sb.append(",CREATOR="+String.valueOf(CREATOR));
		sb.append(",MANUALLY_ENTERED="+String.valueOf(MANUALLY_ENTERED));
		sb.append(",MOVEMENT_NUMBER="+String.valueOf(MOVEMENT_NUMBER));
		sb.append(",REVISION_NUMBER="+String.valueOf(REVISION_NUMBER));
		sb.append(",REVISED="+String.valueOf(REVISED));
		sb.append(",STATUS="+String.valueOf(STATUS));
		sb.append(",STATUS_DATE="+String.valueOf(STATUS_DATE));
		sb.append(",START_LOAD_TIME="+String.valueOf(START_LOAD_TIME));
		sb.append(",END_LOAD_TIME="+String.valueOf(END_LOAD_TIME));
		sb.append(",LAST_USER_NAME="+LAST_USER_NAME);
		sb.append(",LAST_MODIFIED="+String.valueOf(LAST_MODIFIED));
		sb.append(",BOL_PRINTED="+String.valueOf(BOL_PRINTED));
		sb.append(",ORDER_ENTRY_TIME="+String.valueOf(ORDER_ENTRY_TIME));
		sb.append(",MANUALLY_COMPLETED="+String.valueOf(MANUALLY_COMPLETED));
		sb.append(",AIC_STATUS="+String.valueOf(AIC_STATUS));
		sb.append(",AUTHORIZATION_REQUEST_ID="+String.valueOf(AUTHORIZATION_REQUEST_ID));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row3Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.ORDER_ID, other.ORDER_ID);
						if(returnValue != 0) {
							return returnValue;
						}

					
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tDBInput_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBInput_2_SUBPROCESS_STATE", 0);

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



		row3Struct row3 = new row3Struct();




	
	/**
	 * [tAdvancedHash_row3 begin ] start
	 */

	

	
		
		ok_Hash.put("tAdvancedHash_row3", false);
		start_Hash.put("tAdvancedHash_row3", System.currentTimeMillis());
		
	
	currentComponent="tAdvancedHash_row3";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row3");
					}
				
		int tos_count_tAdvancedHash_row3 = 0;
		

			   		// connection name:row3
			   		// source node:tDBInput_2 - inputs:(after_tDBInput_1) outputs:(row3,row3) | target node:tAdvancedHash_row3 - inputs:(row3) outputs:()
			   		// linked node: tMap_1 - inputs:(row2,row3) outputs:(out1)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row3 = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct> tHash_Lookup_row3 =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<row3Struct>getLookup(matchingModeEnum_row3);
	   						   
		   	   	   globalMap.put("tHash_Lookup_row3", tHash_Lookup_row3);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_row3 begin ] stop
 */



	
	/**
	 * [tDBInput_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_2", false);
		start_Hash.put("tDBInput_2", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_2";

	
		int tos_count_tDBInput_2 = 0;
		
	
    
	
			org.talend.designer.components.util.mssql.MSSqlGenerateTimestampUtil mssqlGTU_tDBInput_2 = org.talend.designer.components.util.mssql.MSSqlUtilFactory.getMSSqlGenerateTimestampUtil();
			
			java.util.List<String> talendToDBList_tDBInput_2 = new java.util.ArrayList();
			String[] talendToDBArray_tDBInput_2  = new String[]{"FLOAT","NUMERIC","NUMERIC IDENTITY","DECIMAL","DECIMAL IDENTITY","REAL"}; 
			java.util.Collections.addAll(talendToDBList_tDBInput_2, talendToDBArray_tDBInput_2); 
		    int nb_line_tDBInput_2 = 0;
		    java.sql.Connection conn_tDBInput_2 = null;
				String driverClass_tDBInput_2 = "net.sourceforge.jtds.jdbc.Driver";
			    java.lang.Class jdbcclazz_tDBInput_2 = java.lang.Class.forName(driverClass_tDBInput_2);
				String dbUser_tDBInput_2 = "sa";
				
				 
	final String decryptedPassword_tDBInput_2 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:LMRMjFz1Rd7tSjoCLXJhYKGyWhCgjbBRJvXZf0zYKVye4aGyXK0=");
				
				String dbPwd_tDBInput_2 = decryptedPassword_tDBInput_2;
				
		    String port_tDBInput_2 = "1433";
		    String dbname_tDBInput_2 = "PGS_STAGE_DW" ;
			String url_tDBInput_2 = "jdbc:jtds:sqlserver://" + "LAPTOP-HED7JE2F" ;
		    if (!"".equals(port_tDBInput_2)) {
		    	url_tDBInput_2 += ":" + "1433";
		    }
		    if (!"".equals(dbname_tDBInput_2)) {
				url_tDBInput_2 += "//" + "PGS_STAGE_DW"; 
		    }
		    url_tDBInput_2 += ";appName=" + projectName + ";" + "";
		    String dbschema_tDBInput_2 = "dbo";
				
				conn_tDBInput_2 = java.sql.DriverManager.getConnection(url_tDBInput_2,dbUser_tDBInput_2,dbPwd_tDBInput_2);
		        
		    
			java.sql.Statement stmt_tDBInput_2 = conn_tDBInput_2.createStatement();

		    String dbquery_tDBInput_2 = "SELECT dbo.DIM_ORDERS.PK_ORDERS,\n		dbo.DIM_ORDERS.ORDER_ID,\n		dbo.DIM_ORDERS.LOADED_DRIVER_NUMBER,\n		dbo.DIM_ORDERS.CAR"
+"RIER_NUMBER,\n		dbo.DIM_ORDERS.LOADED_CARRIER_NUMBER,\n		dbo.DIM_ORDERS.FOLIO_NUMBER,\n		dbo.DIM_ORDERS.DISPATCH_CARRIER_NU"
+"MBER,\n		dbo.DIM_ORDERS.SUPPLIER_NUMBER,\n		dbo.DIM_ORDERS.CUSTOMER_NUMBER,\n		dbo.DIM_ORDERS.DESTINATION_NUMBER,\n		dbo.DIM"
+"_ORDERS.TRIP_ID,\n		dbo.DIM_ORDERS.TYPE,\n		dbo.DIM_ORDERS.CREATOR,\n		dbo.DIM_ORDERS.MANUALLY_ENTERED,\n		dbo.DIM_ORDERS.MO"
+"VEMENT_NUMBER,\n		dbo.DIM_ORDERS.REVISION_NUMBER,\n		dbo.DIM_ORDERS.REVISED,\n		dbo.DIM_ORDERS.STATUS,\n		dbo.DIM_ORDERS.STA"
+"TUS_DATE,\n		dbo.DIM_ORDERS.START_LOAD_TIME,\n		dbo.DIM_ORDERS.END_LOAD_TIME,\n		dbo.DIM_ORDERS.LAST_USER_NAME,\n		dbo.DIM_O"
+"RDERS.LAST_MODIFIED,\n		dbo.DIM_ORDERS.BOL_PRINTED,\n		dbo.DIM_ORDERS.ORDER_ENTRY_TIME,\n		dbo.DIM_ORDERS.MANUALLY_COMPLETE"
+"D,\n		dbo.DIM_ORDERS.AIC_STATUS,\n		dbo.DIM_ORDERS.AUTHORIZATION_REQUEST_ID\nFROM	dbo.DIM_ORDERS";
		    

            	globalMap.put("tDBInput_2_QUERY",dbquery_tDBInput_2);
		    java.sql.ResultSet rs_tDBInput_2 = null;

		    try {
		    	rs_tDBInput_2 = stmt_tDBInput_2.executeQuery(dbquery_tDBInput_2);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_2 = rs_tDBInput_2.getMetaData();
		    	int colQtyInRs_tDBInput_2 = rsmd_tDBInput_2.getColumnCount();

		    String tmpContent_tDBInput_2 = null;
		    
		    
		    while (rs_tDBInput_2.next()) {
		        nb_line_tDBInput_2++;
		        
							if(colQtyInRs_tDBInput_2 < 1) {
								row3.PK_ORDERS = 0;
							} else {
		                          
            row3.PK_ORDERS = rs_tDBInput_2.getInt(1);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 2) {
								row3.ORDER_ID = 0;
							} else {
		                          
            row3.ORDER_ID = rs_tDBInput_2.getInt(2);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 3) {
								row3.LOADED_DRIVER_NUMBER = null;
							} else {
		                          
            row3.LOADED_DRIVER_NUMBER = rs_tDBInput_2.getInt(3);
            if(rs_tDBInput_2.wasNull()){
                    row3.LOADED_DRIVER_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 4) {
								row3.CARRIER_NUMBER = 0;
							} else {
		                          
            row3.CARRIER_NUMBER = rs_tDBInput_2.getInt(4);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 5) {
								row3.LOADED_CARRIER_NUMBER = null;
							} else {
		                          
            row3.LOADED_CARRIER_NUMBER = rs_tDBInput_2.getInt(5);
            if(rs_tDBInput_2.wasNull()){
                    row3.LOADED_CARRIER_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 6) {
								row3.FOLIO_NUMBER = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(6);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(6).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.FOLIO_NUMBER = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row3.FOLIO_NUMBER = tmpContent_tDBInput_2;
                }
            } else {
                row3.FOLIO_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 7) {
								row3.DISPATCH_CARRIER_NUMBER = null;
							} else {
		                          
            row3.DISPATCH_CARRIER_NUMBER = rs_tDBInput_2.getInt(7);
            if(rs_tDBInput_2.wasNull()){
                    row3.DISPATCH_CARRIER_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 8) {
								row3.SUPPLIER_NUMBER = 0;
							} else {
		                          
            row3.SUPPLIER_NUMBER = rs_tDBInput_2.getInt(8);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 9) {
								row3.CUSTOMER_NUMBER = 0;
							} else {
		                          
            row3.CUSTOMER_NUMBER = rs_tDBInput_2.getInt(9);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 10) {
								row3.DESTINATION_NUMBER = 0;
							} else {
		                          
            row3.DESTINATION_NUMBER = rs_tDBInput_2.getInt(10);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 11) {
								row3.TRIP_ID = null;
							} else {
		                          
            row3.TRIP_ID = rs_tDBInput_2.getInt(11);
            if(rs_tDBInput_2.wasNull()){
                    row3.TRIP_ID = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 12) {
								row3.TYPE = 0;
							} else {
		                          
            row3.TYPE = rs_tDBInput_2.getInt(12);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 13) {
								row3.CREATOR = 0;
							} else {
		                          
            row3.CREATOR = rs_tDBInput_2.getInt(13);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 14) {
								row3.MANUALLY_ENTERED = 0;
							} else {
		                          
            row3.MANUALLY_ENTERED = rs_tDBInput_2.getInt(14);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 15) {
								row3.MOVEMENT_NUMBER = 0;
							} else {
		                          
            row3.MOVEMENT_NUMBER = rs_tDBInput_2.getInt(15);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 16) {
								row3.REVISION_NUMBER = 0;
							} else {
		                          
            row3.REVISION_NUMBER = rs_tDBInput_2.getInt(16);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 17) {
								row3.REVISED = 0;
							} else {
		                          
            row3.REVISED = rs_tDBInput_2.getInt(17);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 18) {
								row3.STATUS = 0;
							} else {
		                          
            row3.STATUS = rs_tDBInput_2.getInt(18);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 19) {
								row3.STATUS_DATE = null;
							} else {
										
			row3.STATUS_DATE = mssqlGTU_tDBInput_2.getDate(rsmd_tDBInput_2, rs_tDBInput_2, 19);
			
		                    }
							if(colQtyInRs_tDBInput_2 < 20) {
								row3.START_LOAD_TIME = null;
							} else {
										
			row3.START_LOAD_TIME = mssqlGTU_tDBInput_2.getDate(rsmd_tDBInput_2, rs_tDBInput_2, 20);
			
		                    }
							if(colQtyInRs_tDBInput_2 < 21) {
								row3.END_LOAD_TIME = null;
							} else {
										
			row3.END_LOAD_TIME = mssqlGTU_tDBInput_2.getDate(rsmd_tDBInput_2, rs_tDBInput_2, 21);
			
		                    }
							if(colQtyInRs_tDBInput_2 < 22) {
								row3.LAST_USER_NAME = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(22);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(22).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.LAST_USER_NAME = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row3.LAST_USER_NAME = tmpContent_tDBInput_2;
                }
            } else {
                row3.LAST_USER_NAME = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 23) {
								row3.LAST_MODIFIED = null;
							} else {
										
			row3.LAST_MODIFIED = mssqlGTU_tDBInput_2.getDate(rsmd_tDBInput_2, rs_tDBInput_2, 23);
			
		                    }
							if(colQtyInRs_tDBInput_2 < 24) {
								row3.BOL_PRINTED = 0;
							} else {
		                          
            row3.BOL_PRINTED = rs_tDBInput_2.getInt(24);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 25) {
								row3.ORDER_ENTRY_TIME = null;
							} else {
										
			row3.ORDER_ENTRY_TIME = mssqlGTU_tDBInput_2.getDate(rsmd_tDBInput_2, rs_tDBInput_2, 25);
			
		                    }
							if(colQtyInRs_tDBInput_2 < 26) {
								row3.MANUALLY_COMPLETED = 0;
							} else {
		                          
            row3.MANUALLY_COMPLETED = rs_tDBInput_2.getInt(26);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 27) {
								row3.AIC_STATUS = 0;
							} else {
		                          
            row3.AIC_STATUS = rs_tDBInput_2.getInt(27);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 28) {
								row3.AUTHORIZATION_REQUEST_ID = 0;
							} else {
		                          
            row3.AUTHORIZATION_REQUEST_ID = rs_tDBInput_2.getInt(28);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
					





 



/**
 * [tDBInput_2 begin ] stop
 */
	
	/**
	 * [tDBInput_2 main ] start
	 */

	

	
	
	currentComponent="tDBInput_2";

	

 


	tos_count_tDBInput_2++;

/**
 * [tDBInput_2 main ] stop
 */
	
	/**
	 * [tDBInput_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_2";

	

 



/**
 * [tDBInput_2 process_data_begin ] stop
 */

	
	/**
	 * [tAdvancedHash_row3 main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row3";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row3"
						
						);
					}
					


			   
			   

					row3Struct row3_HashRow = new row3Struct();
		   	   	   
				
				row3_HashRow.PK_ORDERS = row3.PK_ORDERS;
				
				row3_HashRow.ORDER_ID = row3.ORDER_ID;
				
				row3_HashRow.LOADED_DRIVER_NUMBER = row3.LOADED_DRIVER_NUMBER;
				
				row3_HashRow.CARRIER_NUMBER = row3.CARRIER_NUMBER;
				
				row3_HashRow.LOADED_CARRIER_NUMBER = row3.LOADED_CARRIER_NUMBER;
				
				row3_HashRow.FOLIO_NUMBER = row3.FOLIO_NUMBER;
				
				row3_HashRow.DISPATCH_CARRIER_NUMBER = row3.DISPATCH_CARRIER_NUMBER;
				
				row3_HashRow.SUPPLIER_NUMBER = row3.SUPPLIER_NUMBER;
				
				row3_HashRow.CUSTOMER_NUMBER = row3.CUSTOMER_NUMBER;
				
				row3_HashRow.DESTINATION_NUMBER = row3.DESTINATION_NUMBER;
				
				row3_HashRow.TRIP_ID = row3.TRIP_ID;
				
				row3_HashRow.TYPE = row3.TYPE;
				
				row3_HashRow.CREATOR = row3.CREATOR;
				
				row3_HashRow.MANUALLY_ENTERED = row3.MANUALLY_ENTERED;
				
				row3_HashRow.MOVEMENT_NUMBER = row3.MOVEMENT_NUMBER;
				
				row3_HashRow.REVISION_NUMBER = row3.REVISION_NUMBER;
				
				row3_HashRow.REVISED = row3.REVISED;
				
				row3_HashRow.STATUS = row3.STATUS;
				
				row3_HashRow.STATUS_DATE = row3.STATUS_DATE;
				
				row3_HashRow.START_LOAD_TIME = row3.START_LOAD_TIME;
				
				row3_HashRow.END_LOAD_TIME = row3.END_LOAD_TIME;
				
				row3_HashRow.LAST_USER_NAME = row3.LAST_USER_NAME;
				
				row3_HashRow.LAST_MODIFIED = row3.LAST_MODIFIED;
				
				row3_HashRow.BOL_PRINTED = row3.BOL_PRINTED;
				
				row3_HashRow.ORDER_ENTRY_TIME = row3.ORDER_ENTRY_TIME;
				
				row3_HashRow.MANUALLY_COMPLETED = row3.MANUALLY_COMPLETED;
				
				row3_HashRow.AIC_STATUS = row3.AIC_STATUS;
				
				row3_HashRow.AUTHORIZATION_REQUEST_ID = row3.AUTHORIZATION_REQUEST_ID;
				
			tHash_Lookup_row3.put(row3_HashRow);
			
            




 


	tos_count_tAdvancedHash_row3++;

/**
 * [tAdvancedHash_row3 main ] stop
 */
	
	/**
	 * [tAdvancedHash_row3 process_data_begin ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row3";

	

 



/**
 * [tAdvancedHash_row3 process_data_begin ] stop
 */
	
	/**
	 * [tAdvancedHash_row3 process_data_end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row3";

	

 



/**
 * [tAdvancedHash_row3 process_data_end ] stop
 */



	
	/**
	 * [tDBInput_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_2";

	

 



/**
 * [tDBInput_2 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_2 end ] start
	 */

	

	
	
	currentComponent="tDBInput_2";

	

	}
}finally{
	if (rs_tDBInput_2 != null) {
		rs_tDBInput_2.close();
	}
	if (stmt_tDBInput_2 != null) {
		stmt_tDBInput_2.close();
	}
		if(conn_tDBInput_2 != null && !conn_tDBInput_2.isClosed()) {
			
			conn_tDBInput_2.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
		}
}
globalMap.put("tDBInput_2_NB_LINE",nb_line_tDBInput_2);

 

ok_Hash.put("tDBInput_2", true);
end_Hash.put("tDBInput_2", System.currentTimeMillis());




/**
 * [tDBInput_2 end ] stop
 */

	
	/**
	 * [tAdvancedHash_row3 end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row3";

	

tHash_Lookup_row3.endPut();

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row3");
			  	}
			  	
 

ok_Hash.put("tAdvancedHash_row3", true);
end_Hash.put("tAdvancedHash_row3", System.currentTimeMillis());




/**
 * [tAdvancedHash_row3 end ] stop
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
	 * [tDBInput_2 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_2";

	

 



/**
 * [tDBInput_2 finally ] stop
 */

	
	/**
	 * [tAdvancedHash_row3 finally ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row3";

	

 



/**
 * [tAdvancedHash_row3 finally ] stop
 */



				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBInput_2_SUBPROCESS_STATE", 1);
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
        final DIM_ORDERS DIM_ORDERSClass = new DIM_ORDERS();

        int exitCode = DIM_ORDERSClass.runJobInTOS(args);

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
            java.io.InputStream inContext = DIM_ORDERS.class.getClassLoader().getResourceAsStream("pgs_stage/dim_orders_0_1/contexts/" + contextStr + ".properties");
            if (inContext == null) {
                inContext = DIM_ORDERS.class.getClassLoader().getResourceAsStream("config/contexts/" + contextStr + ".properties");
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
errorCode = null;tDBInput_1Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tDBInput_1) {
globalMap.put("tDBInput_1_SUBPROCESS_STATE", -1);

e_tDBInput_1.printStackTrace();

}

this.globalResumeTicket = true;//to run tPostJob




        end = System.currentTimeMillis();

        if (watch) {
            System.out.println((end-startTime)+" milliseconds");
        }

        endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        if (false) {
            System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : DIM_ORDERS");
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
 *     430833 characters generated by Talend Open Studio for Data Integration 
 *     on the 3 août 2024 à 14:42:26 GMT+01:00
 ************************************************************************************************/