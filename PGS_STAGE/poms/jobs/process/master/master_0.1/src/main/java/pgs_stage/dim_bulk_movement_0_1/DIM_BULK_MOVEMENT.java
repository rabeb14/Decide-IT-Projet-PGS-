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


package pgs_stage.dim_bulk_movement_0_1;

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
 * Job: DIM_BULK_MOVEMENT Purpose: <br>
 * Description:  <br>
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status 
 */
public class DIM_BULK_MOVEMENT implements TalendJob {

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
	private final String jobName = "DIM_BULK_MOVEMENT";
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
				DIM_BULK_MOVEMENT.this.exception = e;
			}
		}
		if (!(e instanceof TalendException)) {
		try {
			for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
				if (m.getName().compareTo(currentComponent + "_error") == 0) {
					m.invoke(DIM_BULK_MOVEMENT.this, new Object[] { e , currentComponent, globalMap});
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
	






public static class out2Struct implements routines.system.IPersistableRow<out2Struct> {
    final static byte[] commonByteArrayLock_PGS_STAGE_DIM_BULK_MOVEMENT = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_DIM_BULK_MOVEMENT = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public Integer PK_BULK_MOVEMENT;

				public Integer getPK_BULK_MOVEMENT () {
					return this.PK_BULK_MOVEMENT;
				}
				
			    public int BULK_MOVEMENT_ID;

				public int getBULK_MOVEMENT_ID () {
					return this.BULK_MOVEMENT_ID;
				}
				
			    public String FOLIO_NUMBER;

				public String getFOLIO_NUMBER () {
					return this.FOLIO_NUMBER;
				}
				
			    public java.util.Date DATE;

				public java.util.Date getDATE () {
					return this.DATE;
				}
				
			    public Integer FROM_SUPPLIER_NUMBER;

				public Integer getFROM_SUPPLIER_NUMBER () {
					return this.FROM_SUPPLIER_NUMBER;
				}
				
			    public int TYPE;

				public int getTYPE () {
					return this.TYPE;
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
				
			    public String REMARKS;

				public String getREMARKS () {
					return this.REMARKS;
				}
				
			    public java.util.Date MOVEMENT_DATE;

				public java.util.Date getMOVEMENT_DATE () {
					return this.MOVEMENT_DATE;
				}
				
			    public String LAST_USER_NAME;

				public String getLAST_USER_NAME () {
					return this.LAST_USER_NAME;
				}
				
			    public java.util.Date LAST_MODIFIED;

				public java.util.Date getLAST_MODIFIED () {
					return this.LAST_MODIFIED;
				}
				
			    public int AIC_STATUS;

				public int getAIC_STATUS () {
					return this.AIC_STATUS;
				}
				
			    public Integer ORIG_BULK_MOVEMENT_ID;

				public Integer getORIG_BULK_MOVEMENT_ID () {
					return this.ORIG_BULK_MOVEMENT_ID;
				}
				
			    public Integer PREV_BULK_MOVEMENT_ID;

				public Integer getPREV_BULK_MOVEMENT_ID () {
					return this.PREV_BULK_MOVEMENT_ID;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.PK_BULK_MOVEMENT == null) ? 0 : this.PK_BULK_MOVEMENT.hashCode());
					
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
		final out2Struct other = (out2Struct) obj;
		
						if (this.PK_BULK_MOVEMENT == null) {
							if (other.PK_BULK_MOVEMENT != null)
								return false;
						
						} else if (!this.PK_BULK_MOVEMENT.equals(other.PK_BULK_MOVEMENT))
						
							return false;
					

		return true;
    }

	public void copyDataTo(out2Struct other) {

		other.PK_BULK_MOVEMENT = this.PK_BULK_MOVEMENT;
	            other.BULK_MOVEMENT_ID = this.BULK_MOVEMENT_ID;
	            other.FOLIO_NUMBER = this.FOLIO_NUMBER;
	            other.DATE = this.DATE;
	            other.FROM_SUPPLIER_NUMBER = this.FROM_SUPPLIER_NUMBER;
	            other.TYPE = this.TYPE;
	            other.MOVEMENT_NUMBER = this.MOVEMENT_NUMBER;
	            other.REVISION_NUMBER = this.REVISION_NUMBER;
	            other.REVISED = this.REVISED;
	            other.STATUS = this.STATUS;
	            other.STATUS_DATE = this.STATUS_DATE;
	            other.REMARKS = this.REMARKS;
	            other.MOVEMENT_DATE = this.MOVEMENT_DATE;
	            other.LAST_USER_NAME = this.LAST_USER_NAME;
	            other.LAST_MODIFIED = this.LAST_MODIFIED;
	            other.AIC_STATUS = this.AIC_STATUS;
	            other.ORIG_BULK_MOVEMENT_ID = this.ORIG_BULK_MOVEMENT_ID;
	            other.PREV_BULK_MOVEMENT_ID = this.PREV_BULK_MOVEMENT_ID;
	            
	}

	public void copyKeysDataTo(out2Struct other) {

		other.PK_BULK_MOVEMENT = this.PK_BULK_MOVEMENT;
	            	
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
			if(length > commonByteArray_PGS_STAGE_DIM_BULK_MOVEMENT.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_BULK_MOVEMENT.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_BULK_MOVEMENT = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_BULK_MOVEMENT = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PGS_STAGE_DIM_BULK_MOVEMENT, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_BULK_MOVEMENT, 0, length, utf8Charset);
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
			if(length > commonByteArray_PGS_STAGE_DIM_BULK_MOVEMENT.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_BULK_MOVEMENT.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_BULK_MOVEMENT = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_BULK_MOVEMENT = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PGS_STAGE_DIM_BULK_MOVEMENT, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_BULK_MOVEMENT, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_BULK_MOVEMENT) {

        	try {

        		int length = 0;
		
						this.PK_BULK_MOVEMENT = readInteger(dis);
					
			        this.BULK_MOVEMENT_ID = dis.readInt();
					
					this.FOLIO_NUMBER = readString(dis);
					
					this.DATE = readDate(dis);
					
						this.FROM_SUPPLIER_NUMBER = readInteger(dis);
					
			        this.TYPE = dis.readInt();
					
			        this.MOVEMENT_NUMBER = dis.readInt();
					
			        this.REVISION_NUMBER = dis.readInt();
					
			        this.REVISED = dis.readInt();
					
			        this.STATUS = dis.readInt();
					
					this.STATUS_DATE = readDate(dis);
					
					this.REMARKS = readString(dis);
					
					this.MOVEMENT_DATE = readDate(dis);
					
					this.LAST_USER_NAME = readString(dis);
					
					this.LAST_MODIFIED = readDate(dis);
					
			        this.AIC_STATUS = dis.readInt();
					
						this.ORIG_BULK_MOVEMENT_ID = readInteger(dis);
					
						this.PREV_BULK_MOVEMENT_ID = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_BULK_MOVEMENT) {

        	try {

        		int length = 0;
		
						this.PK_BULK_MOVEMENT = readInteger(dis);
					
			        this.BULK_MOVEMENT_ID = dis.readInt();
					
					this.FOLIO_NUMBER = readString(dis);
					
					this.DATE = readDate(dis);
					
						this.FROM_SUPPLIER_NUMBER = readInteger(dis);
					
			        this.TYPE = dis.readInt();
					
			        this.MOVEMENT_NUMBER = dis.readInt();
					
			        this.REVISION_NUMBER = dis.readInt();
					
			        this.REVISED = dis.readInt();
					
			        this.STATUS = dis.readInt();
					
					this.STATUS_DATE = readDate(dis);
					
					this.REMARKS = readString(dis);
					
					this.MOVEMENT_DATE = readDate(dis);
					
					this.LAST_USER_NAME = readString(dis);
					
					this.LAST_MODIFIED = readDate(dis);
					
			        this.AIC_STATUS = dis.readInt();
					
						this.ORIG_BULK_MOVEMENT_ID = readInteger(dis);
					
						this.PREV_BULK_MOVEMENT_ID = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// Integer
				
						writeInteger(this.PK_BULK_MOVEMENT,dos);
					
					// int
				
		            	dos.writeInt(this.BULK_MOVEMENT_ID);
					
					// String
				
						writeString(this.FOLIO_NUMBER,dos);
					
					// java.util.Date
				
						writeDate(this.DATE,dos);
					
					// Integer
				
						writeInteger(this.FROM_SUPPLIER_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.TYPE);
					
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
					
					// String
				
						writeString(this.REMARKS,dos);
					
					// java.util.Date
				
						writeDate(this.MOVEMENT_DATE,dos);
					
					// String
				
						writeString(this.LAST_USER_NAME,dos);
					
					// java.util.Date
				
						writeDate(this.LAST_MODIFIED,dos);
					
					// int
				
		            	dos.writeInt(this.AIC_STATUS);
					
					// Integer
				
						writeInteger(this.ORIG_BULK_MOVEMENT_ID,dos);
					
					// Integer
				
						writeInteger(this.PREV_BULK_MOVEMENT_ID,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Integer
				
						writeInteger(this.PK_BULK_MOVEMENT,dos);
					
					// int
				
		            	dos.writeInt(this.BULK_MOVEMENT_ID);
					
					// String
				
						writeString(this.FOLIO_NUMBER,dos);
					
					// java.util.Date
				
						writeDate(this.DATE,dos);
					
					// Integer
				
						writeInteger(this.FROM_SUPPLIER_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.TYPE);
					
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
					
					// String
				
						writeString(this.REMARKS,dos);
					
					// java.util.Date
				
						writeDate(this.MOVEMENT_DATE,dos);
					
					// String
				
						writeString(this.LAST_USER_NAME,dos);
					
					// java.util.Date
				
						writeDate(this.LAST_MODIFIED,dos);
					
					// int
				
		            	dos.writeInt(this.AIC_STATUS);
					
					// Integer
				
						writeInteger(this.ORIG_BULK_MOVEMENT_ID,dos);
					
					// Integer
				
						writeInteger(this.PREV_BULK_MOVEMENT_ID,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("PK_BULK_MOVEMENT="+String.valueOf(PK_BULK_MOVEMENT));
		sb.append(",BULK_MOVEMENT_ID="+String.valueOf(BULK_MOVEMENT_ID));
		sb.append(",FOLIO_NUMBER="+FOLIO_NUMBER);
		sb.append(",DATE="+String.valueOf(DATE));
		sb.append(",FROM_SUPPLIER_NUMBER="+String.valueOf(FROM_SUPPLIER_NUMBER));
		sb.append(",TYPE="+String.valueOf(TYPE));
		sb.append(",MOVEMENT_NUMBER="+String.valueOf(MOVEMENT_NUMBER));
		sb.append(",REVISION_NUMBER="+String.valueOf(REVISION_NUMBER));
		sb.append(",REVISED="+String.valueOf(REVISED));
		sb.append(",STATUS="+String.valueOf(STATUS));
		sb.append(",STATUS_DATE="+String.valueOf(STATUS_DATE));
		sb.append(",REMARKS="+REMARKS);
		sb.append(",MOVEMENT_DATE="+String.valueOf(MOVEMENT_DATE));
		sb.append(",LAST_USER_NAME="+LAST_USER_NAME);
		sb.append(",LAST_MODIFIED="+String.valueOf(LAST_MODIFIED));
		sb.append(",AIC_STATUS="+String.valueOf(AIC_STATUS));
		sb.append(",ORIG_BULK_MOVEMENT_ID="+String.valueOf(ORIG_BULK_MOVEMENT_ID));
		sb.append(",PREV_BULK_MOVEMENT_ID="+String.valueOf(PREV_BULK_MOVEMENT_ID));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(out2Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.PK_BULK_MOVEMENT, other.PK_BULK_MOVEMENT);
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
    final static byte[] commonByteArrayLock_PGS_STAGE_DIM_BULK_MOVEMENT = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_DIM_BULK_MOVEMENT = new byte[0];

	
			    public int BULK_MOVEMENT_ID;

				public int getBULK_MOVEMENT_ID () {
					return this.BULK_MOVEMENT_ID;
				}
				
			    public Integer TO_DESTINATION_SUPPLIER_NUMBER;

				public Integer getTO_DESTINATION_SUPPLIER_NUMBER () {
					return this.TO_DESTINATION_SUPPLIER_NUMBER;
				}
				
			    public Integer TO_TRACTOR_NUMBER;

				public Integer getTO_TRACTOR_NUMBER () {
					return this.TO_TRACTOR_NUMBER;
				}
				
			    public String FOLIO_NUMBER;

				public String getFOLIO_NUMBER () {
					return this.FOLIO_NUMBER;
				}
				
			    public Integer FROM_TRACTOR_CARRIER_NUMBER;

				public Integer getFROM_TRACTOR_CARRIER_NUMBER () {
					return this.FROM_TRACTOR_CARRIER_NUMBER;
				}
				
			    public Integer TO_DESTINATION_CUSTOMER_NUMBER;

				public Integer getTO_DESTINATION_CUSTOMER_NUMBER () {
					return this.TO_DESTINATION_CUSTOMER_NUMBER;
				}
				
			    public Integer FROM_TRACTOR_NUMBER;

				public Integer getFROM_TRACTOR_NUMBER () {
					return this.FROM_TRACTOR_NUMBER;
				}
				
			    public Integer TO_DESTINATION_NUMBER;

				public Integer getTO_DESTINATION_NUMBER () {
					return this.TO_DESTINATION_NUMBER;
				}
				
			    public Integer TO_DRIVER_NUMBER;

				public Integer getTO_DRIVER_NUMBER () {
					return this.TO_DRIVER_NUMBER;
				}
				
			    public Integer FROM_DRIVER_CARRIER_NUMBER;

				public Integer getFROM_DRIVER_CARRIER_NUMBER () {
					return this.FROM_DRIVER_CARRIER_NUMBER;
				}
				
			    public Integer FROM_SUPPLIER_NUMBER;

				public Integer getFROM_SUPPLIER_NUMBER () {
					return this.FROM_SUPPLIER_NUMBER;
				}
				
			    public String FSHOST_SU_SUPPLIER_NUMBER;

				public String getFSHOST_SU_SUPPLIER_NUMBER () {
					return this.FSHOST_SU_SUPPLIER_NUMBER;
				}
				
			    public Integer FROM_DRIVER_NUMBER;

				public Integer getFROM_DRIVER_NUMBER () {
					return this.FROM_DRIVER_NUMBER;
				}
				
			    public Integer TO_SUPPLIER_NUMBER;

				public Integer getTO_SUPPLIER_NUMBER () {
					return this.TO_SUPPLIER_NUMBER;
				}
				
			    public Integer FROM_CARRIER_NUMBER;

				public Integer getFROM_CARRIER_NUMBER () {
					return this.FROM_CARRIER_NUMBER;
				}
				
			    public String FSHOST_EX_THOST_EXCH_NUMBER;

				public String getFSHOST_EX_THOST_EXCH_NUMBER () {
					return this.FSHOST_EX_THOST_EXCH_NUMBER;
				}
				
			    public Integer TRANSACTION_SUBTYPE;

				public Integer getTRANSACTION_SUBTYPE () {
					return this.TRANSACTION_SUBTYPE;
				}
				
			    public int TYPE;

				public int getTYPE () {
					return this.TYPE;
				}
				
			    public String TSHOST_SU_SUPPLIER_NUMBER;

				public String getTSHOST_SU_SUPPLIER_NUMBER () {
					return this.TSHOST_SU_SUPPLIER_NUMBER;
				}
				
			    public String TSHOST_EX_EHOST_THRU_NUMBER;

				public String getTSHOST_EX_EHOST_THRU_NUMBER () {
					return this.TSHOST_EX_EHOST_THRU_NUMBER;
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
				
			    public String REFERENCE_NUMBER;

				public String getREFERENCE_NUMBER () {
					return this.REFERENCE_NUMBER;
				}
				
			    public int STATUS;

				public int getSTATUS () {
					return this.STATUS;
				}
				
			    public java.util.Date STATUS_DATE;

				public java.util.Date getSTATUS_DATE () {
					return this.STATUS_DATE;
				}
				
			    public String REMARKS;

				public String getREMARKS () {
					return this.REMARKS;
				}
				
			    public java.util.Date MOVEMENT_DATE;

				public java.util.Date getMOVEMENT_DATE () {
					return this.MOVEMENT_DATE;
				}
				
			    public String VESSEL;

				public String getVESSEL () {
					return this.VESSEL;
				}
				
			    public String DOC_OPERATOR_CODE;

				public String getDOC_OPERATOR_CODE () {
					return this.DOC_OPERATOR_CODE;
				}
				
			    public String BATCH_VOYAGE_NUMBER;

				public String getBATCH_VOYAGE_NUMBER () {
					return this.BATCH_VOYAGE_NUMBER;
				}
				
			    public String LAST_USER_NAME;

				public String getLAST_USER_NAME () {
					return this.LAST_USER_NAME;
				}
				
			    public java.util.Date LAST_MODIFIED;

				public java.util.Date getLAST_MODIFIED () {
					return this.LAST_MODIFIED;
				}
				
			    public int HOST_PROCESSED;

				public int getHOST_PROCESSED () {
					return this.HOST_PROCESSED;
				}
				
			    public int AIC_STATUS;

				public int getAIC_STATUS () {
					return this.AIC_STATUS;
				}
				
			    public int FLAG_APPLY_SUPPLIER_INV;

				public int getFLAG_APPLY_SUPPLIER_INV () {
					return this.FLAG_APPLY_SUPPLIER_INV;
				}
				
			    public int FLAG_APPLY_SUPPLIER_TANK_INV;

				public int getFLAG_APPLY_SUPPLIER_TANK_INV () {
					return this.FLAG_APPLY_SUPPLIER_TANK_INV;
				}
				
			    public int FLAG_APPLY_PARCEL_INV;

				public int getFLAG_APPLY_PARCEL_INV () {
					return this.FLAG_APPLY_PARCEL_INV;
				}
				
			    public int FLAG_APPLY_TANK_INV;

				public int getFLAG_APPLY_TANK_INV () {
					return this.FLAG_APPLY_TANK_INV;
				}
				
			    public int CANCELLED_FROM_CBS;

				public int getCANCELLED_FROM_CBS () {
					return this.CANCELLED_FROM_CBS;
				}
				
			    public String HOST_REF_ID;

				public String getHOST_REF_ID () {
					return this.HOST_REF_ID;
				}
				
			    public int PENDING_PRINT_COUNT;

				public int getPENDING_PRINT_COUNT () {
					return this.PENDING_PRINT_COUNT;
				}
				
			    public int GAIN_LOSS_XCTN;

				public int getGAIN_LOSS_XCTN () {
					return this.GAIN_LOSS_XCTN;
				}
				
			    public int PENDING_REQUEST_COUNT;

				public int getPENDING_REQUEST_COUNT () {
					return this.PENDING_REQUEST_COUNT;
				}
				
			    public Integer ORIG_BULK_MOVEMENT_ID;

				public Integer getORIG_BULK_MOVEMENT_ID () {
					return this.ORIG_BULK_MOVEMENT_ID;
				}
				
			    public Integer PREV_BULK_MOVEMENT_ID;

				public Integer getPREV_BULK_MOVEMENT_ID () {
					return this.PREV_BULK_MOVEMENT_ID;
				}
				
			    public String AGENT;

				public String getAGENT () {
					return this.AGENT;
				}
				
			    public String SURVEYOR_1;

				public String getSURVEYOR_1 () {
					return this.SURVEYOR_1;
				}
				
			    public String SURVEYOR_2;

				public String getSURVEYOR_2 () {
					return this.SURVEYOR_2;
				}
				
			    public Integer TO_CARRIER_NUMBER;

				public Integer getTO_CARRIER_NUMBER () {
					return this.TO_CARRIER_NUMBER;
				}
				
			    public Integer TO_DRIVER_CARRIER_NUMBER;

				public Integer getTO_DRIVER_CARRIER_NUMBER () {
					return this.TO_DRIVER_CARRIER_NUMBER;
				}
				
			    public Integer TO_TRACTOR_CARRIER_NUMBER;

				public Integer getTO_TRACTOR_CARRIER_NUMBER () {
					return this.TO_TRACTOR_CARRIER_NUMBER;
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
			if(length > commonByteArray_PGS_STAGE_DIM_BULK_MOVEMENT.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_BULK_MOVEMENT.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_BULK_MOVEMENT = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_BULK_MOVEMENT = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PGS_STAGE_DIM_BULK_MOVEMENT, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_BULK_MOVEMENT, 0, length, utf8Charset);
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
			if(length > commonByteArray_PGS_STAGE_DIM_BULK_MOVEMENT.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_BULK_MOVEMENT.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_BULK_MOVEMENT = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_BULK_MOVEMENT = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PGS_STAGE_DIM_BULK_MOVEMENT, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_BULK_MOVEMENT, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_BULK_MOVEMENT) {

        	try {

        		int length = 0;
		
			        this.BULK_MOVEMENT_ID = dis.readInt();
					
						this.TO_DESTINATION_SUPPLIER_NUMBER = readInteger(dis);
					
						this.TO_TRACTOR_NUMBER = readInteger(dis);
					
					this.FOLIO_NUMBER = readString(dis);
					
						this.FROM_TRACTOR_CARRIER_NUMBER = readInteger(dis);
					
						this.TO_DESTINATION_CUSTOMER_NUMBER = readInteger(dis);
					
						this.FROM_TRACTOR_NUMBER = readInteger(dis);
					
						this.TO_DESTINATION_NUMBER = readInteger(dis);
					
						this.TO_DRIVER_NUMBER = readInteger(dis);
					
						this.FROM_DRIVER_CARRIER_NUMBER = readInteger(dis);
					
						this.FROM_SUPPLIER_NUMBER = readInteger(dis);
					
					this.FSHOST_SU_SUPPLIER_NUMBER = readString(dis);
					
						this.FROM_DRIVER_NUMBER = readInteger(dis);
					
						this.TO_SUPPLIER_NUMBER = readInteger(dis);
					
						this.FROM_CARRIER_NUMBER = readInteger(dis);
					
					this.FSHOST_EX_THOST_EXCH_NUMBER = readString(dis);
					
						this.TRANSACTION_SUBTYPE = readInteger(dis);
					
			        this.TYPE = dis.readInt();
					
					this.TSHOST_SU_SUPPLIER_NUMBER = readString(dis);
					
					this.TSHOST_EX_EHOST_THRU_NUMBER = readString(dis);
					
			        this.MOVEMENT_NUMBER = dis.readInt();
					
			        this.REVISION_NUMBER = dis.readInt();
					
			        this.REVISED = dis.readInt();
					
					this.REFERENCE_NUMBER = readString(dis);
					
			        this.STATUS = dis.readInt();
					
					this.STATUS_DATE = readDate(dis);
					
					this.REMARKS = readString(dis);
					
					this.MOVEMENT_DATE = readDate(dis);
					
					this.VESSEL = readString(dis);
					
					this.DOC_OPERATOR_CODE = readString(dis);
					
					this.BATCH_VOYAGE_NUMBER = readString(dis);
					
					this.LAST_USER_NAME = readString(dis);
					
					this.LAST_MODIFIED = readDate(dis);
					
			        this.HOST_PROCESSED = dis.readInt();
					
			        this.AIC_STATUS = dis.readInt();
					
			        this.FLAG_APPLY_SUPPLIER_INV = dis.readInt();
					
			        this.FLAG_APPLY_SUPPLIER_TANK_INV = dis.readInt();
					
			        this.FLAG_APPLY_PARCEL_INV = dis.readInt();
					
			        this.FLAG_APPLY_TANK_INV = dis.readInt();
					
			        this.CANCELLED_FROM_CBS = dis.readInt();
					
					this.HOST_REF_ID = readString(dis);
					
			        this.PENDING_PRINT_COUNT = dis.readInt();
					
			        this.GAIN_LOSS_XCTN = dis.readInt();
					
			        this.PENDING_REQUEST_COUNT = dis.readInt();
					
						this.ORIG_BULK_MOVEMENT_ID = readInteger(dis);
					
						this.PREV_BULK_MOVEMENT_ID = readInteger(dis);
					
					this.AGENT = readString(dis);
					
					this.SURVEYOR_1 = readString(dis);
					
					this.SURVEYOR_2 = readString(dis);
					
						this.TO_CARRIER_NUMBER = readInteger(dis);
					
						this.TO_DRIVER_CARRIER_NUMBER = readInteger(dis);
					
						this.TO_TRACTOR_CARRIER_NUMBER = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_BULK_MOVEMENT) {

        	try {

        		int length = 0;
		
			        this.BULK_MOVEMENT_ID = dis.readInt();
					
						this.TO_DESTINATION_SUPPLIER_NUMBER = readInteger(dis);
					
						this.TO_TRACTOR_NUMBER = readInteger(dis);
					
					this.FOLIO_NUMBER = readString(dis);
					
						this.FROM_TRACTOR_CARRIER_NUMBER = readInteger(dis);
					
						this.TO_DESTINATION_CUSTOMER_NUMBER = readInteger(dis);
					
						this.FROM_TRACTOR_NUMBER = readInteger(dis);
					
						this.TO_DESTINATION_NUMBER = readInteger(dis);
					
						this.TO_DRIVER_NUMBER = readInteger(dis);
					
						this.FROM_DRIVER_CARRIER_NUMBER = readInteger(dis);
					
						this.FROM_SUPPLIER_NUMBER = readInteger(dis);
					
					this.FSHOST_SU_SUPPLIER_NUMBER = readString(dis);
					
						this.FROM_DRIVER_NUMBER = readInteger(dis);
					
						this.TO_SUPPLIER_NUMBER = readInteger(dis);
					
						this.FROM_CARRIER_NUMBER = readInteger(dis);
					
					this.FSHOST_EX_THOST_EXCH_NUMBER = readString(dis);
					
						this.TRANSACTION_SUBTYPE = readInteger(dis);
					
			        this.TYPE = dis.readInt();
					
					this.TSHOST_SU_SUPPLIER_NUMBER = readString(dis);
					
					this.TSHOST_EX_EHOST_THRU_NUMBER = readString(dis);
					
			        this.MOVEMENT_NUMBER = dis.readInt();
					
			        this.REVISION_NUMBER = dis.readInt();
					
			        this.REVISED = dis.readInt();
					
					this.REFERENCE_NUMBER = readString(dis);
					
			        this.STATUS = dis.readInt();
					
					this.STATUS_DATE = readDate(dis);
					
					this.REMARKS = readString(dis);
					
					this.MOVEMENT_DATE = readDate(dis);
					
					this.VESSEL = readString(dis);
					
					this.DOC_OPERATOR_CODE = readString(dis);
					
					this.BATCH_VOYAGE_NUMBER = readString(dis);
					
					this.LAST_USER_NAME = readString(dis);
					
					this.LAST_MODIFIED = readDate(dis);
					
			        this.HOST_PROCESSED = dis.readInt();
					
			        this.AIC_STATUS = dis.readInt();
					
			        this.FLAG_APPLY_SUPPLIER_INV = dis.readInt();
					
			        this.FLAG_APPLY_SUPPLIER_TANK_INV = dis.readInt();
					
			        this.FLAG_APPLY_PARCEL_INV = dis.readInt();
					
			        this.FLAG_APPLY_TANK_INV = dis.readInt();
					
			        this.CANCELLED_FROM_CBS = dis.readInt();
					
					this.HOST_REF_ID = readString(dis);
					
			        this.PENDING_PRINT_COUNT = dis.readInt();
					
			        this.GAIN_LOSS_XCTN = dis.readInt();
					
			        this.PENDING_REQUEST_COUNT = dis.readInt();
					
						this.ORIG_BULK_MOVEMENT_ID = readInteger(dis);
					
						this.PREV_BULK_MOVEMENT_ID = readInteger(dis);
					
					this.AGENT = readString(dis);
					
					this.SURVEYOR_1 = readString(dis);
					
					this.SURVEYOR_2 = readString(dis);
					
						this.TO_CARRIER_NUMBER = readInteger(dis);
					
						this.TO_DRIVER_CARRIER_NUMBER = readInteger(dis);
					
						this.TO_TRACTOR_CARRIER_NUMBER = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.BULK_MOVEMENT_ID);
					
					// Integer
				
						writeInteger(this.TO_DESTINATION_SUPPLIER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.TO_TRACTOR_NUMBER,dos);
					
					// String
				
						writeString(this.FOLIO_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.FROM_TRACTOR_CARRIER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.TO_DESTINATION_CUSTOMER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.FROM_TRACTOR_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.TO_DESTINATION_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.TO_DRIVER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.FROM_DRIVER_CARRIER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.FROM_SUPPLIER_NUMBER,dos);
					
					// String
				
						writeString(this.FSHOST_SU_SUPPLIER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.FROM_DRIVER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.TO_SUPPLIER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.FROM_CARRIER_NUMBER,dos);
					
					// String
				
						writeString(this.FSHOST_EX_THOST_EXCH_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.TRANSACTION_SUBTYPE,dos);
					
					// int
				
		            	dos.writeInt(this.TYPE);
					
					// String
				
						writeString(this.TSHOST_SU_SUPPLIER_NUMBER,dos);
					
					// String
				
						writeString(this.TSHOST_EX_EHOST_THRU_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.MOVEMENT_NUMBER);
					
					// int
				
		            	dos.writeInt(this.REVISION_NUMBER);
					
					// int
				
		            	dos.writeInt(this.REVISED);
					
					// String
				
						writeString(this.REFERENCE_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.STATUS);
					
					// java.util.Date
				
						writeDate(this.STATUS_DATE,dos);
					
					// String
				
						writeString(this.REMARKS,dos);
					
					// java.util.Date
				
						writeDate(this.MOVEMENT_DATE,dos);
					
					// String
				
						writeString(this.VESSEL,dos);
					
					// String
				
						writeString(this.DOC_OPERATOR_CODE,dos);
					
					// String
				
						writeString(this.BATCH_VOYAGE_NUMBER,dos);
					
					// String
				
						writeString(this.LAST_USER_NAME,dos);
					
					// java.util.Date
				
						writeDate(this.LAST_MODIFIED,dos);
					
					// int
				
		            	dos.writeInt(this.HOST_PROCESSED);
					
					// int
				
		            	dos.writeInt(this.AIC_STATUS);
					
					// int
				
		            	dos.writeInt(this.FLAG_APPLY_SUPPLIER_INV);
					
					// int
				
		            	dos.writeInt(this.FLAG_APPLY_SUPPLIER_TANK_INV);
					
					// int
				
		            	dos.writeInt(this.FLAG_APPLY_PARCEL_INV);
					
					// int
				
		            	dos.writeInt(this.FLAG_APPLY_TANK_INV);
					
					// int
				
		            	dos.writeInt(this.CANCELLED_FROM_CBS);
					
					// String
				
						writeString(this.HOST_REF_ID,dos);
					
					// int
				
		            	dos.writeInt(this.PENDING_PRINT_COUNT);
					
					// int
				
		            	dos.writeInt(this.GAIN_LOSS_XCTN);
					
					// int
				
		            	dos.writeInt(this.PENDING_REQUEST_COUNT);
					
					// Integer
				
						writeInteger(this.ORIG_BULK_MOVEMENT_ID,dos);
					
					// Integer
				
						writeInteger(this.PREV_BULK_MOVEMENT_ID,dos);
					
					// String
				
						writeString(this.AGENT,dos);
					
					// String
				
						writeString(this.SURVEYOR_1,dos);
					
					// String
				
						writeString(this.SURVEYOR_2,dos);
					
					// Integer
				
						writeInteger(this.TO_CARRIER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.TO_DRIVER_CARRIER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.TO_TRACTOR_CARRIER_NUMBER,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.BULK_MOVEMENT_ID);
					
					// Integer
				
						writeInteger(this.TO_DESTINATION_SUPPLIER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.TO_TRACTOR_NUMBER,dos);
					
					// String
				
						writeString(this.FOLIO_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.FROM_TRACTOR_CARRIER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.TO_DESTINATION_CUSTOMER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.FROM_TRACTOR_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.TO_DESTINATION_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.TO_DRIVER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.FROM_DRIVER_CARRIER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.FROM_SUPPLIER_NUMBER,dos);
					
					// String
				
						writeString(this.FSHOST_SU_SUPPLIER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.FROM_DRIVER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.TO_SUPPLIER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.FROM_CARRIER_NUMBER,dos);
					
					// String
				
						writeString(this.FSHOST_EX_THOST_EXCH_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.TRANSACTION_SUBTYPE,dos);
					
					// int
				
		            	dos.writeInt(this.TYPE);
					
					// String
				
						writeString(this.TSHOST_SU_SUPPLIER_NUMBER,dos);
					
					// String
				
						writeString(this.TSHOST_EX_EHOST_THRU_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.MOVEMENT_NUMBER);
					
					// int
				
		            	dos.writeInt(this.REVISION_NUMBER);
					
					// int
				
		            	dos.writeInt(this.REVISED);
					
					// String
				
						writeString(this.REFERENCE_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.STATUS);
					
					// java.util.Date
				
						writeDate(this.STATUS_DATE,dos);
					
					// String
				
						writeString(this.REMARKS,dos);
					
					// java.util.Date
				
						writeDate(this.MOVEMENT_DATE,dos);
					
					// String
				
						writeString(this.VESSEL,dos);
					
					// String
				
						writeString(this.DOC_OPERATOR_CODE,dos);
					
					// String
				
						writeString(this.BATCH_VOYAGE_NUMBER,dos);
					
					// String
				
						writeString(this.LAST_USER_NAME,dos);
					
					// java.util.Date
				
						writeDate(this.LAST_MODIFIED,dos);
					
					// int
				
		            	dos.writeInt(this.HOST_PROCESSED);
					
					// int
				
		            	dos.writeInt(this.AIC_STATUS);
					
					// int
				
		            	dos.writeInt(this.FLAG_APPLY_SUPPLIER_INV);
					
					// int
				
		            	dos.writeInt(this.FLAG_APPLY_SUPPLIER_TANK_INV);
					
					// int
				
		            	dos.writeInt(this.FLAG_APPLY_PARCEL_INV);
					
					// int
				
		            	dos.writeInt(this.FLAG_APPLY_TANK_INV);
					
					// int
				
		            	dos.writeInt(this.CANCELLED_FROM_CBS);
					
					// String
				
						writeString(this.HOST_REF_ID,dos);
					
					// int
				
		            	dos.writeInt(this.PENDING_PRINT_COUNT);
					
					// int
				
		            	dos.writeInt(this.GAIN_LOSS_XCTN);
					
					// int
				
		            	dos.writeInt(this.PENDING_REQUEST_COUNT);
					
					// Integer
				
						writeInteger(this.ORIG_BULK_MOVEMENT_ID,dos);
					
					// Integer
				
						writeInteger(this.PREV_BULK_MOVEMENT_ID,dos);
					
					// String
				
						writeString(this.AGENT,dos);
					
					// String
				
						writeString(this.SURVEYOR_1,dos);
					
					// String
				
						writeString(this.SURVEYOR_2,dos);
					
					// Integer
				
						writeInteger(this.TO_CARRIER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.TO_DRIVER_CARRIER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.TO_TRACTOR_CARRIER_NUMBER,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("BULK_MOVEMENT_ID="+String.valueOf(BULK_MOVEMENT_ID));
		sb.append(",TO_DESTINATION_SUPPLIER_NUMBER="+String.valueOf(TO_DESTINATION_SUPPLIER_NUMBER));
		sb.append(",TO_TRACTOR_NUMBER="+String.valueOf(TO_TRACTOR_NUMBER));
		sb.append(",FOLIO_NUMBER="+FOLIO_NUMBER);
		sb.append(",FROM_TRACTOR_CARRIER_NUMBER="+String.valueOf(FROM_TRACTOR_CARRIER_NUMBER));
		sb.append(",TO_DESTINATION_CUSTOMER_NUMBER="+String.valueOf(TO_DESTINATION_CUSTOMER_NUMBER));
		sb.append(",FROM_TRACTOR_NUMBER="+String.valueOf(FROM_TRACTOR_NUMBER));
		sb.append(",TO_DESTINATION_NUMBER="+String.valueOf(TO_DESTINATION_NUMBER));
		sb.append(",TO_DRIVER_NUMBER="+String.valueOf(TO_DRIVER_NUMBER));
		sb.append(",FROM_DRIVER_CARRIER_NUMBER="+String.valueOf(FROM_DRIVER_CARRIER_NUMBER));
		sb.append(",FROM_SUPPLIER_NUMBER="+String.valueOf(FROM_SUPPLIER_NUMBER));
		sb.append(",FSHOST_SU_SUPPLIER_NUMBER="+FSHOST_SU_SUPPLIER_NUMBER);
		sb.append(",FROM_DRIVER_NUMBER="+String.valueOf(FROM_DRIVER_NUMBER));
		sb.append(",TO_SUPPLIER_NUMBER="+String.valueOf(TO_SUPPLIER_NUMBER));
		sb.append(",FROM_CARRIER_NUMBER="+String.valueOf(FROM_CARRIER_NUMBER));
		sb.append(",FSHOST_EX_THOST_EXCH_NUMBER="+FSHOST_EX_THOST_EXCH_NUMBER);
		sb.append(",TRANSACTION_SUBTYPE="+String.valueOf(TRANSACTION_SUBTYPE));
		sb.append(",TYPE="+String.valueOf(TYPE));
		sb.append(",TSHOST_SU_SUPPLIER_NUMBER="+TSHOST_SU_SUPPLIER_NUMBER);
		sb.append(",TSHOST_EX_EHOST_THRU_NUMBER="+TSHOST_EX_EHOST_THRU_NUMBER);
		sb.append(",MOVEMENT_NUMBER="+String.valueOf(MOVEMENT_NUMBER));
		sb.append(",REVISION_NUMBER="+String.valueOf(REVISION_NUMBER));
		sb.append(",REVISED="+String.valueOf(REVISED));
		sb.append(",REFERENCE_NUMBER="+REFERENCE_NUMBER);
		sb.append(",STATUS="+String.valueOf(STATUS));
		sb.append(",STATUS_DATE="+String.valueOf(STATUS_DATE));
		sb.append(",REMARKS="+REMARKS);
		sb.append(",MOVEMENT_DATE="+String.valueOf(MOVEMENT_DATE));
		sb.append(",VESSEL="+VESSEL);
		sb.append(",DOC_OPERATOR_CODE="+DOC_OPERATOR_CODE);
		sb.append(",BATCH_VOYAGE_NUMBER="+BATCH_VOYAGE_NUMBER);
		sb.append(",LAST_USER_NAME="+LAST_USER_NAME);
		sb.append(",LAST_MODIFIED="+String.valueOf(LAST_MODIFIED));
		sb.append(",HOST_PROCESSED="+String.valueOf(HOST_PROCESSED));
		sb.append(",AIC_STATUS="+String.valueOf(AIC_STATUS));
		sb.append(",FLAG_APPLY_SUPPLIER_INV="+String.valueOf(FLAG_APPLY_SUPPLIER_INV));
		sb.append(",FLAG_APPLY_SUPPLIER_TANK_INV="+String.valueOf(FLAG_APPLY_SUPPLIER_TANK_INV));
		sb.append(",FLAG_APPLY_PARCEL_INV="+String.valueOf(FLAG_APPLY_PARCEL_INV));
		sb.append(",FLAG_APPLY_TANK_INV="+String.valueOf(FLAG_APPLY_TANK_INV));
		sb.append(",CANCELLED_FROM_CBS="+String.valueOf(CANCELLED_FROM_CBS));
		sb.append(",HOST_REF_ID="+HOST_REF_ID);
		sb.append(",PENDING_PRINT_COUNT="+String.valueOf(PENDING_PRINT_COUNT));
		sb.append(",GAIN_LOSS_XCTN="+String.valueOf(GAIN_LOSS_XCTN));
		sb.append(",PENDING_REQUEST_COUNT="+String.valueOf(PENDING_REQUEST_COUNT));
		sb.append(",ORIG_BULK_MOVEMENT_ID="+String.valueOf(ORIG_BULK_MOVEMENT_ID));
		sb.append(",PREV_BULK_MOVEMENT_ID="+String.valueOf(PREV_BULK_MOVEMENT_ID));
		sb.append(",AGENT="+AGENT);
		sb.append(",SURVEYOR_1="+SURVEYOR_1);
		sb.append(",SURVEYOR_2="+SURVEYOR_2);
		sb.append(",TO_CARRIER_NUMBER="+String.valueOf(TO_CARRIER_NUMBER));
		sb.append(",TO_DRIVER_CARRIER_NUMBER="+String.valueOf(TO_DRIVER_CARRIER_NUMBER));
		sb.append(",TO_TRACTOR_CARRIER_NUMBER="+String.valueOf(TO_TRACTOR_CARRIER_NUMBER));
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
    final static byte[] commonByteArrayLock_PGS_STAGE_DIM_BULK_MOVEMENT = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_DIM_BULK_MOVEMENT = new byte[0];

	
			    public int BULK_MOVEMENT_ID;

				public int getBULK_MOVEMENT_ID () {
					return this.BULK_MOVEMENT_ID;
				}
				
			    public Integer TO_DESTINATION_SUPPLIER_NUMBER;

				public Integer getTO_DESTINATION_SUPPLIER_NUMBER () {
					return this.TO_DESTINATION_SUPPLIER_NUMBER;
				}
				
			    public Integer TO_TRACTOR_NUMBER;

				public Integer getTO_TRACTOR_NUMBER () {
					return this.TO_TRACTOR_NUMBER;
				}
				
			    public String FOLIO_NUMBER;

				public String getFOLIO_NUMBER () {
					return this.FOLIO_NUMBER;
				}
				
			    public Integer FROM_TRACTOR_CARRIER_NUMBER;

				public Integer getFROM_TRACTOR_CARRIER_NUMBER () {
					return this.FROM_TRACTOR_CARRIER_NUMBER;
				}
				
			    public Integer TO_DESTINATION_CUSTOMER_NUMBER;

				public Integer getTO_DESTINATION_CUSTOMER_NUMBER () {
					return this.TO_DESTINATION_CUSTOMER_NUMBER;
				}
				
			    public Integer FROM_TRACTOR_NUMBER;

				public Integer getFROM_TRACTOR_NUMBER () {
					return this.FROM_TRACTOR_NUMBER;
				}
				
			    public Integer TO_DESTINATION_NUMBER;

				public Integer getTO_DESTINATION_NUMBER () {
					return this.TO_DESTINATION_NUMBER;
				}
				
			    public Integer TO_DRIVER_NUMBER;

				public Integer getTO_DRIVER_NUMBER () {
					return this.TO_DRIVER_NUMBER;
				}
				
			    public Integer FROM_DRIVER_CARRIER_NUMBER;

				public Integer getFROM_DRIVER_CARRIER_NUMBER () {
					return this.FROM_DRIVER_CARRIER_NUMBER;
				}
				
			    public Integer FROM_SUPPLIER_NUMBER;

				public Integer getFROM_SUPPLIER_NUMBER () {
					return this.FROM_SUPPLIER_NUMBER;
				}
				
			    public String FSHOST_SU_SUPPLIER_NUMBER;

				public String getFSHOST_SU_SUPPLIER_NUMBER () {
					return this.FSHOST_SU_SUPPLIER_NUMBER;
				}
				
			    public Integer FROM_DRIVER_NUMBER;

				public Integer getFROM_DRIVER_NUMBER () {
					return this.FROM_DRIVER_NUMBER;
				}
				
			    public Integer TO_SUPPLIER_NUMBER;

				public Integer getTO_SUPPLIER_NUMBER () {
					return this.TO_SUPPLIER_NUMBER;
				}
				
			    public Integer FROM_CARRIER_NUMBER;

				public Integer getFROM_CARRIER_NUMBER () {
					return this.FROM_CARRIER_NUMBER;
				}
				
			    public String FSHOST_EX_THOST_EXCH_NUMBER;

				public String getFSHOST_EX_THOST_EXCH_NUMBER () {
					return this.FSHOST_EX_THOST_EXCH_NUMBER;
				}
				
			    public Integer TRANSACTION_SUBTYPE;

				public Integer getTRANSACTION_SUBTYPE () {
					return this.TRANSACTION_SUBTYPE;
				}
				
			    public int TYPE;

				public int getTYPE () {
					return this.TYPE;
				}
				
			    public String TSHOST_SU_SUPPLIER_NUMBER;

				public String getTSHOST_SU_SUPPLIER_NUMBER () {
					return this.TSHOST_SU_SUPPLIER_NUMBER;
				}
				
			    public String TSHOST_EX_EHOST_THRU_NUMBER;

				public String getTSHOST_EX_EHOST_THRU_NUMBER () {
					return this.TSHOST_EX_EHOST_THRU_NUMBER;
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
				
			    public String REFERENCE_NUMBER;

				public String getREFERENCE_NUMBER () {
					return this.REFERENCE_NUMBER;
				}
				
			    public int STATUS;

				public int getSTATUS () {
					return this.STATUS;
				}
				
			    public java.util.Date STATUS_DATE;

				public java.util.Date getSTATUS_DATE () {
					return this.STATUS_DATE;
				}
				
			    public String REMARKS;

				public String getREMARKS () {
					return this.REMARKS;
				}
				
			    public java.util.Date MOVEMENT_DATE;

				public java.util.Date getMOVEMENT_DATE () {
					return this.MOVEMENT_DATE;
				}
				
			    public String VESSEL;

				public String getVESSEL () {
					return this.VESSEL;
				}
				
			    public String DOC_OPERATOR_CODE;

				public String getDOC_OPERATOR_CODE () {
					return this.DOC_OPERATOR_CODE;
				}
				
			    public String BATCH_VOYAGE_NUMBER;

				public String getBATCH_VOYAGE_NUMBER () {
					return this.BATCH_VOYAGE_NUMBER;
				}
				
			    public String LAST_USER_NAME;

				public String getLAST_USER_NAME () {
					return this.LAST_USER_NAME;
				}
				
			    public java.util.Date LAST_MODIFIED;

				public java.util.Date getLAST_MODIFIED () {
					return this.LAST_MODIFIED;
				}
				
			    public int HOST_PROCESSED;

				public int getHOST_PROCESSED () {
					return this.HOST_PROCESSED;
				}
				
			    public int AIC_STATUS;

				public int getAIC_STATUS () {
					return this.AIC_STATUS;
				}
				
			    public int FLAG_APPLY_SUPPLIER_INV;

				public int getFLAG_APPLY_SUPPLIER_INV () {
					return this.FLAG_APPLY_SUPPLIER_INV;
				}
				
			    public int FLAG_APPLY_SUPPLIER_TANK_INV;

				public int getFLAG_APPLY_SUPPLIER_TANK_INV () {
					return this.FLAG_APPLY_SUPPLIER_TANK_INV;
				}
				
			    public int FLAG_APPLY_PARCEL_INV;

				public int getFLAG_APPLY_PARCEL_INV () {
					return this.FLAG_APPLY_PARCEL_INV;
				}
				
			    public int FLAG_APPLY_TANK_INV;

				public int getFLAG_APPLY_TANK_INV () {
					return this.FLAG_APPLY_TANK_INV;
				}
				
			    public int CANCELLED_FROM_CBS;

				public int getCANCELLED_FROM_CBS () {
					return this.CANCELLED_FROM_CBS;
				}
				
			    public String HOST_REF_ID;

				public String getHOST_REF_ID () {
					return this.HOST_REF_ID;
				}
				
			    public int PENDING_PRINT_COUNT;

				public int getPENDING_PRINT_COUNT () {
					return this.PENDING_PRINT_COUNT;
				}
				
			    public int GAIN_LOSS_XCTN;

				public int getGAIN_LOSS_XCTN () {
					return this.GAIN_LOSS_XCTN;
				}
				
			    public int PENDING_REQUEST_COUNT;

				public int getPENDING_REQUEST_COUNT () {
					return this.PENDING_REQUEST_COUNT;
				}
				
			    public Integer ORIG_BULK_MOVEMENT_ID;

				public Integer getORIG_BULK_MOVEMENT_ID () {
					return this.ORIG_BULK_MOVEMENT_ID;
				}
				
			    public Integer PREV_BULK_MOVEMENT_ID;

				public Integer getPREV_BULK_MOVEMENT_ID () {
					return this.PREV_BULK_MOVEMENT_ID;
				}
				
			    public String AGENT;

				public String getAGENT () {
					return this.AGENT;
				}
				
			    public String SURVEYOR_1;

				public String getSURVEYOR_1 () {
					return this.SURVEYOR_1;
				}
				
			    public String SURVEYOR_2;

				public String getSURVEYOR_2 () {
					return this.SURVEYOR_2;
				}
				
			    public Integer TO_CARRIER_NUMBER;

				public Integer getTO_CARRIER_NUMBER () {
					return this.TO_CARRIER_NUMBER;
				}
				
			    public Integer TO_DRIVER_CARRIER_NUMBER;

				public Integer getTO_DRIVER_CARRIER_NUMBER () {
					return this.TO_DRIVER_CARRIER_NUMBER;
				}
				
			    public Integer TO_TRACTOR_CARRIER_NUMBER;

				public Integer getTO_TRACTOR_CARRIER_NUMBER () {
					return this.TO_TRACTOR_CARRIER_NUMBER;
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
			if(length > commonByteArray_PGS_STAGE_DIM_BULK_MOVEMENT.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_BULK_MOVEMENT.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_BULK_MOVEMENT = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_BULK_MOVEMENT = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PGS_STAGE_DIM_BULK_MOVEMENT, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_BULK_MOVEMENT, 0, length, utf8Charset);
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
			if(length > commonByteArray_PGS_STAGE_DIM_BULK_MOVEMENT.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_BULK_MOVEMENT.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_BULK_MOVEMENT = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_BULK_MOVEMENT = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PGS_STAGE_DIM_BULK_MOVEMENT, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_BULK_MOVEMENT, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_BULK_MOVEMENT) {

        	try {

        		int length = 0;
		
			        this.BULK_MOVEMENT_ID = dis.readInt();
					
						this.TO_DESTINATION_SUPPLIER_NUMBER = readInteger(dis);
					
						this.TO_TRACTOR_NUMBER = readInteger(dis);
					
					this.FOLIO_NUMBER = readString(dis);
					
						this.FROM_TRACTOR_CARRIER_NUMBER = readInteger(dis);
					
						this.TO_DESTINATION_CUSTOMER_NUMBER = readInteger(dis);
					
						this.FROM_TRACTOR_NUMBER = readInteger(dis);
					
						this.TO_DESTINATION_NUMBER = readInteger(dis);
					
						this.TO_DRIVER_NUMBER = readInteger(dis);
					
						this.FROM_DRIVER_CARRIER_NUMBER = readInteger(dis);
					
						this.FROM_SUPPLIER_NUMBER = readInteger(dis);
					
					this.FSHOST_SU_SUPPLIER_NUMBER = readString(dis);
					
						this.FROM_DRIVER_NUMBER = readInteger(dis);
					
						this.TO_SUPPLIER_NUMBER = readInteger(dis);
					
						this.FROM_CARRIER_NUMBER = readInteger(dis);
					
					this.FSHOST_EX_THOST_EXCH_NUMBER = readString(dis);
					
						this.TRANSACTION_SUBTYPE = readInteger(dis);
					
			        this.TYPE = dis.readInt();
					
					this.TSHOST_SU_SUPPLIER_NUMBER = readString(dis);
					
					this.TSHOST_EX_EHOST_THRU_NUMBER = readString(dis);
					
			        this.MOVEMENT_NUMBER = dis.readInt();
					
			        this.REVISION_NUMBER = dis.readInt();
					
			        this.REVISED = dis.readInt();
					
					this.REFERENCE_NUMBER = readString(dis);
					
			        this.STATUS = dis.readInt();
					
					this.STATUS_DATE = readDate(dis);
					
					this.REMARKS = readString(dis);
					
					this.MOVEMENT_DATE = readDate(dis);
					
					this.VESSEL = readString(dis);
					
					this.DOC_OPERATOR_CODE = readString(dis);
					
					this.BATCH_VOYAGE_NUMBER = readString(dis);
					
					this.LAST_USER_NAME = readString(dis);
					
					this.LAST_MODIFIED = readDate(dis);
					
			        this.HOST_PROCESSED = dis.readInt();
					
			        this.AIC_STATUS = dis.readInt();
					
			        this.FLAG_APPLY_SUPPLIER_INV = dis.readInt();
					
			        this.FLAG_APPLY_SUPPLIER_TANK_INV = dis.readInt();
					
			        this.FLAG_APPLY_PARCEL_INV = dis.readInt();
					
			        this.FLAG_APPLY_TANK_INV = dis.readInt();
					
			        this.CANCELLED_FROM_CBS = dis.readInt();
					
					this.HOST_REF_ID = readString(dis);
					
			        this.PENDING_PRINT_COUNT = dis.readInt();
					
			        this.GAIN_LOSS_XCTN = dis.readInt();
					
			        this.PENDING_REQUEST_COUNT = dis.readInt();
					
						this.ORIG_BULK_MOVEMENT_ID = readInteger(dis);
					
						this.PREV_BULK_MOVEMENT_ID = readInteger(dis);
					
					this.AGENT = readString(dis);
					
					this.SURVEYOR_1 = readString(dis);
					
					this.SURVEYOR_2 = readString(dis);
					
						this.TO_CARRIER_NUMBER = readInteger(dis);
					
						this.TO_DRIVER_CARRIER_NUMBER = readInteger(dis);
					
						this.TO_TRACTOR_CARRIER_NUMBER = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_BULK_MOVEMENT) {

        	try {

        		int length = 0;
		
			        this.BULK_MOVEMENT_ID = dis.readInt();
					
						this.TO_DESTINATION_SUPPLIER_NUMBER = readInteger(dis);
					
						this.TO_TRACTOR_NUMBER = readInteger(dis);
					
					this.FOLIO_NUMBER = readString(dis);
					
						this.FROM_TRACTOR_CARRIER_NUMBER = readInteger(dis);
					
						this.TO_DESTINATION_CUSTOMER_NUMBER = readInteger(dis);
					
						this.FROM_TRACTOR_NUMBER = readInteger(dis);
					
						this.TO_DESTINATION_NUMBER = readInteger(dis);
					
						this.TO_DRIVER_NUMBER = readInteger(dis);
					
						this.FROM_DRIVER_CARRIER_NUMBER = readInteger(dis);
					
						this.FROM_SUPPLIER_NUMBER = readInteger(dis);
					
					this.FSHOST_SU_SUPPLIER_NUMBER = readString(dis);
					
						this.FROM_DRIVER_NUMBER = readInteger(dis);
					
						this.TO_SUPPLIER_NUMBER = readInteger(dis);
					
						this.FROM_CARRIER_NUMBER = readInteger(dis);
					
					this.FSHOST_EX_THOST_EXCH_NUMBER = readString(dis);
					
						this.TRANSACTION_SUBTYPE = readInteger(dis);
					
			        this.TYPE = dis.readInt();
					
					this.TSHOST_SU_SUPPLIER_NUMBER = readString(dis);
					
					this.TSHOST_EX_EHOST_THRU_NUMBER = readString(dis);
					
			        this.MOVEMENT_NUMBER = dis.readInt();
					
			        this.REVISION_NUMBER = dis.readInt();
					
			        this.REVISED = dis.readInt();
					
					this.REFERENCE_NUMBER = readString(dis);
					
			        this.STATUS = dis.readInt();
					
					this.STATUS_DATE = readDate(dis);
					
					this.REMARKS = readString(dis);
					
					this.MOVEMENT_DATE = readDate(dis);
					
					this.VESSEL = readString(dis);
					
					this.DOC_OPERATOR_CODE = readString(dis);
					
					this.BATCH_VOYAGE_NUMBER = readString(dis);
					
					this.LAST_USER_NAME = readString(dis);
					
					this.LAST_MODIFIED = readDate(dis);
					
			        this.HOST_PROCESSED = dis.readInt();
					
			        this.AIC_STATUS = dis.readInt();
					
			        this.FLAG_APPLY_SUPPLIER_INV = dis.readInt();
					
			        this.FLAG_APPLY_SUPPLIER_TANK_INV = dis.readInt();
					
			        this.FLAG_APPLY_PARCEL_INV = dis.readInt();
					
			        this.FLAG_APPLY_TANK_INV = dis.readInt();
					
			        this.CANCELLED_FROM_CBS = dis.readInt();
					
					this.HOST_REF_ID = readString(dis);
					
			        this.PENDING_PRINT_COUNT = dis.readInt();
					
			        this.GAIN_LOSS_XCTN = dis.readInt();
					
			        this.PENDING_REQUEST_COUNT = dis.readInt();
					
						this.ORIG_BULK_MOVEMENT_ID = readInteger(dis);
					
						this.PREV_BULK_MOVEMENT_ID = readInteger(dis);
					
					this.AGENT = readString(dis);
					
					this.SURVEYOR_1 = readString(dis);
					
					this.SURVEYOR_2 = readString(dis);
					
						this.TO_CARRIER_NUMBER = readInteger(dis);
					
						this.TO_DRIVER_CARRIER_NUMBER = readInteger(dis);
					
						this.TO_TRACTOR_CARRIER_NUMBER = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.BULK_MOVEMENT_ID);
					
					// Integer
				
						writeInteger(this.TO_DESTINATION_SUPPLIER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.TO_TRACTOR_NUMBER,dos);
					
					// String
				
						writeString(this.FOLIO_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.FROM_TRACTOR_CARRIER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.TO_DESTINATION_CUSTOMER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.FROM_TRACTOR_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.TO_DESTINATION_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.TO_DRIVER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.FROM_DRIVER_CARRIER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.FROM_SUPPLIER_NUMBER,dos);
					
					// String
				
						writeString(this.FSHOST_SU_SUPPLIER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.FROM_DRIVER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.TO_SUPPLIER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.FROM_CARRIER_NUMBER,dos);
					
					// String
				
						writeString(this.FSHOST_EX_THOST_EXCH_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.TRANSACTION_SUBTYPE,dos);
					
					// int
				
		            	dos.writeInt(this.TYPE);
					
					// String
				
						writeString(this.TSHOST_SU_SUPPLIER_NUMBER,dos);
					
					// String
				
						writeString(this.TSHOST_EX_EHOST_THRU_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.MOVEMENT_NUMBER);
					
					// int
				
		            	dos.writeInt(this.REVISION_NUMBER);
					
					// int
				
		            	dos.writeInt(this.REVISED);
					
					// String
				
						writeString(this.REFERENCE_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.STATUS);
					
					// java.util.Date
				
						writeDate(this.STATUS_DATE,dos);
					
					// String
				
						writeString(this.REMARKS,dos);
					
					// java.util.Date
				
						writeDate(this.MOVEMENT_DATE,dos);
					
					// String
				
						writeString(this.VESSEL,dos);
					
					// String
				
						writeString(this.DOC_OPERATOR_CODE,dos);
					
					// String
				
						writeString(this.BATCH_VOYAGE_NUMBER,dos);
					
					// String
				
						writeString(this.LAST_USER_NAME,dos);
					
					// java.util.Date
				
						writeDate(this.LAST_MODIFIED,dos);
					
					// int
				
		            	dos.writeInt(this.HOST_PROCESSED);
					
					// int
				
		            	dos.writeInt(this.AIC_STATUS);
					
					// int
				
		            	dos.writeInt(this.FLAG_APPLY_SUPPLIER_INV);
					
					// int
				
		            	dos.writeInt(this.FLAG_APPLY_SUPPLIER_TANK_INV);
					
					// int
				
		            	dos.writeInt(this.FLAG_APPLY_PARCEL_INV);
					
					// int
				
		            	dos.writeInt(this.FLAG_APPLY_TANK_INV);
					
					// int
				
		            	dos.writeInt(this.CANCELLED_FROM_CBS);
					
					// String
				
						writeString(this.HOST_REF_ID,dos);
					
					// int
				
		            	dos.writeInt(this.PENDING_PRINT_COUNT);
					
					// int
				
		            	dos.writeInt(this.GAIN_LOSS_XCTN);
					
					// int
				
		            	dos.writeInt(this.PENDING_REQUEST_COUNT);
					
					// Integer
				
						writeInteger(this.ORIG_BULK_MOVEMENT_ID,dos);
					
					// Integer
				
						writeInteger(this.PREV_BULK_MOVEMENT_ID,dos);
					
					// String
				
						writeString(this.AGENT,dos);
					
					// String
				
						writeString(this.SURVEYOR_1,dos);
					
					// String
				
						writeString(this.SURVEYOR_2,dos);
					
					// Integer
				
						writeInteger(this.TO_CARRIER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.TO_DRIVER_CARRIER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.TO_TRACTOR_CARRIER_NUMBER,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.BULK_MOVEMENT_ID);
					
					// Integer
				
						writeInteger(this.TO_DESTINATION_SUPPLIER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.TO_TRACTOR_NUMBER,dos);
					
					// String
				
						writeString(this.FOLIO_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.FROM_TRACTOR_CARRIER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.TO_DESTINATION_CUSTOMER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.FROM_TRACTOR_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.TO_DESTINATION_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.TO_DRIVER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.FROM_DRIVER_CARRIER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.FROM_SUPPLIER_NUMBER,dos);
					
					// String
				
						writeString(this.FSHOST_SU_SUPPLIER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.FROM_DRIVER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.TO_SUPPLIER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.FROM_CARRIER_NUMBER,dos);
					
					// String
				
						writeString(this.FSHOST_EX_THOST_EXCH_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.TRANSACTION_SUBTYPE,dos);
					
					// int
				
		            	dos.writeInt(this.TYPE);
					
					// String
				
						writeString(this.TSHOST_SU_SUPPLIER_NUMBER,dos);
					
					// String
				
						writeString(this.TSHOST_EX_EHOST_THRU_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.MOVEMENT_NUMBER);
					
					// int
				
		            	dos.writeInt(this.REVISION_NUMBER);
					
					// int
				
		            	dos.writeInt(this.REVISED);
					
					// String
				
						writeString(this.REFERENCE_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.STATUS);
					
					// java.util.Date
				
						writeDate(this.STATUS_DATE,dos);
					
					// String
				
						writeString(this.REMARKS,dos);
					
					// java.util.Date
				
						writeDate(this.MOVEMENT_DATE,dos);
					
					// String
				
						writeString(this.VESSEL,dos);
					
					// String
				
						writeString(this.DOC_OPERATOR_CODE,dos);
					
					// String
				
						writeString(this.BATCH_VOYAGE_NUMBER,dos);
					
					// String
				
						writeString(this.LAST_USER_NAME,dos);
					
					// java.util.Date
				
						writeDate(this.LAST_MODIFIED,dos);
					
					// int
				
		            	dos.writeInt(this.HOST_PROCESSED);
					
					// int
				
		            	dos.writeInt(this.AIC_STATUS);
					
					// int
				
		            	dos.writeInt(this.FLAG_APPLY_SUPPLIER_INV);
					
					// int
				
		            	dos.writeInt(this.FLAG_APPLY_SUPPLIER_TANK_INV);
					
					// int
				
		            	dos.writeInt(this.FLAG_APPLY_PARCEL_INV);
					
					// int
				
		            	dos.writeInt(this.FLAG_APPLY_TANK_INV);
					
					// int
				
		            	dos.writeInt(this.CANCELLED_FROM_CBS);
					
					// String
				
						writeString(this.HOST_REF_ID,dos);
					
					// int
				
		            	dos.writeInt(this.PENDING_PRINT_COUNT);
					
					// int
				
		            	dos.writeInt(this.GAIN_LOSS_XCTN);
					
					// int
				
		            	dos.writeInt(this.PENDING_REQUEST_COUNT);
					
					// Integer
				
						writeInteger(this.ORIG_BULK_MOVEMENT_ID,dos);
					
					// Integer
				
						writeInteger(this.PREV_BULK_MOVEMENT_ID,dos);
					
					// String
				
						writeString(this.AGENT,dos);
					
					// String
				
						writeString(this.SURVEYOR_1,dos);
					
					// String
				
						writeString(this.SURVEYOR_2,dos);
					
					// Integer
				
						writeInteger(this.TO_CARRIER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.TO_DRIVER_CARRIER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.TO_TRACTOR_CARRIER_NUMBER,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("BULK_MOVEMENT_ID="+String.valueOf(BULK_MOVEMENT_ID));
		sb.append(",TO_DESTINATION_SUPPLIER_NUMBER="+String.valueOf(TO_DESTINATION_SUPPLIER_NUMBER));
		sb.append(",TO_TRACTOR_NUMBER="+String.valueOf(TO_TRACTOR_NUMBER));
		sb.append(",FOLIO_NUMBER="+FOLIO_NUMBER);
		sb.append(",FROM_TRACTOR_CARRIER_NUMBER="+String.valueOf(FROM_TRACTOR_CARRIER_NUMBER));
		sb.append(",TO_DESTINATION_CUSTOMER_NUMBER="+String.valueOf(TO_DESTINATION_CUSTOMER_NUMBER));
		sb.append(",FROM_TRACTOR_NUMBER="+String.valueOf(FROM_TRACTOR_NUMBER));
		sb.append(",TO_DESTINATION_NUMBER="+String.valueOf(TO_DESTINATION_NUMBER));
		sb.append(",TO_DRIVER_NUMBER="+String.valueOf(TO_DRIVER_NUMBER));
		sb.append(",FROM_DRIVER_CARRIER_NUMBER="+String.valueOf(FROM_DRIVER_CARRIER_NUMBER));
		sb.append(",FROM_SUPPLIER_NUMBER="+String.valueOf(FROM_SUPPLIER_NUMBER));
		sb.append(",FSHOST_SU_SUPPLIER_NUMBER="+FSHOST_SU_SUPPLIER_NUMBER);
		sb.append(",FROM_DRIVER_NUMBER="+String.valueOf(FROM_DRIVER_NUMBER));
		sb.append(",TO_SUPPLIER_NUMBER="+String.valueOf(TO_SUPPLIER_NUMBER));
		sb.append(",FROM_CARRIER_NUMBER="+String.valueOf(FROM_CARRIER_NUMBER));
		sb.append(",FSHOST_EX_THOST_EXCH_NUMBER="+FSHOST_EX_THOST_EXCH_NUMBER);
		sb.append(",TRANSACTION_SUBTYPE="+String.valueOf(TRANSACTION_SUBTYPE));
		sb.append(",TYPE="+String.valueOf(TYPE));
		sb.append(",TSHOST_SU_SUPPLIER_NUMBER="+TSHOST_SU_SUPPLIER_NUMBER);
		sb.append(",TSHOST_EX_EHOST_THRU_NUMBER="+TSHOST_EX_EHOST_THRU_NUMBER);
		sb.append(",MOVEMENT_NUMBER="+String.valueOf(MOVEMENT_NUMBER));
		sb.append(",REVISION_NUMBER="+String.valueOf(REVISION_NUMBER));
		sb.append(",REVISED="+String.valueOf(REVISED));
		sb.append(",REFERENCE_NUMBER="+REFERENCE_NUMBER);
		sb.append(",STATUS="+String.valueOf(STATUS));
		sb.append(",STATUS_DATE="+String.valueOf(STATUS_DATE));
		sb.append(",REMARKS="+REMARKS);
		sb.append(",MOVEMENT_DATE="+String.valueOf(MOVEMENT_DATE));
		sb.append(",VESSEL="+VESSEL);
		sb.append(",DOC_OPERATOR_CODE="+DOC_OPERATOR_CODE);
		sb.append(",BATCH_VOYAGE_NUMBER="+BATCH_VOYAGE_NUMBER);
		sb.append(",LAST_USER_NAME="+LAST_USER_NAME);
		sb.append(",LAST_MODIFIED="+String.valueOf(LAST_MODIFIED));
		sb.append(",HOST_PROCESSED="+String.valueOf(HOST_PROCESSED));
		sb.append(",AIC_STATUS="+String.valueOf(AIC_STATUS));
		sb.append(",FLAG_APPLY_SUPPLIER_INV="+String.valueOf(FLAG_APPLY_SUPPLIER_INV));
		sb.append(",FLAG_APPLY_SUPPLIER_TANK_INV="+String.valueOf(FLAG_APPLY_SUPPLIER_TANK_INV));
		sb.append(",FLAG_APPLY_PARCEL_INV="+String.valueOf(FLAG_APPLY_PARCEL_INV));
		sb.append(",FLAG_APPLY_TANK_INV="+String.valueOf(FLAG_APPLY_TANK_INV));
		sb.append(",CANCELLED_FROM_CBS="+String.valueOf(CANCELLED_FROM_CBS));
		sb.append(",HOST_REF_ID="+HOST_REF_ID);
		sb.append(",PENDING_PRINT_COUNT="+String.valueOf(PENDING_PRINT_COUNT));
		sb.append(",GAIN_LOSS_XCTN="+String.valueOf(GAIN_LOSS_XCTN));
		sb.append(",PENDING_REQUEST_COUNT="+String.valueOf(PENDING_REQUEST_COUNT));
		sb.append(",ORIG_BULK_MOVEMENT_ID="+String.valueOf(ORIG_BULK_MOVEMENT_ID));
		sb.append(",PREV_BULK_MOVEMENT_ID="+String.valueOf(PREV_BULK_MOVEMENT_ID));
		sb.append(",AGENT="+AGENT);
		sb.append(",SURVEYOR_1="+SURVEYOR_1);
		sb.append(",SURVEYOR_2="+SURVEYOR_2);
		sb.append(",TO_CARRIER_NUMBER="+String.valueOf(TO_CARRIER_NUMBER));
		sb.append(",TO_DRIVER_CARRIER_NUMBER="+String.valueOf(TO_DRIVER_CARRIER_NUMBER));
		sb.append(",TO_TRACTOR_CARRIER_NUMBER="+String.valueOf(TO_TRACTOR_CARRIER_NUMBER));
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
    final static byte[] commonByteArrayLock_PGS_STAGE_DIM_BULK_MOVEMENT = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_DIM_BULK_MOVEMENT = new byte[0];

	
			    public int BULK_MOVEMENT_ID;

				public int getBULK_MOVEMENT_ID () {
					return this.BULK_MOVEMENT_ID;
				}
				
			    public Integer TO_DESTINATION_SUPPLIER_NUMBER;

				public Integer getTO_DESTINATION_SUPPLIER_NUMBER () {
					return this.TO_DESTINATION_SUPPLIER_NUMBER;
				}
				
			    public Integer TO_TRACTOR_NUMBER;

				public Integer getTO_TRACTOR_NUMBER () {
					return this.TO_TRACTOR_NUMBER;
				}
				
			    public String FOLIO_NUMBER;

				public String getFOLIO_NUMBER () {
					return this.FOLIO_NUMBER;
				}
				
			    public Integer FROM_TRACTOR_CARRIER_NUMBER;

				public Integer getFROM_TRACTOR_CARRIER_NUMBER () {
					return this.FROM_TRACTOR_CARRIER_NUMBER;
				}
				
			    public Integer TO_DESTINATION_CUSTOMER_NUMBER;

				public Integer getTO_DESTINATION_CUSTOMER_NUMBER () {
					return this.TO_DESTINATION_CUSTOMER_NUMBER;
				}
				
			    public Integer FROM_TRACTOR_NUMBER;

				public Integer getFROM_TRACTOR_NUMBER () {
					return this.FROM_TRACTOR_NUMBER;
				}
				
			    public Integer TO_DESTINATION_NUMBER;

				public Integer getTO_DESTINATION_NUMBER () {
					return this.TO_DESTINATION_NUMBER;
				}
				
			    public Integer TO_DRIVER_NUMBER;

				public Integer getTO_DRIVER_NUMBER () {
					return this.TO_DRIVER_NUMBER;
				}
				
			    public Integer FROM_DRIVER_CARRIER_NUMBER;

				public Integer getFROM_DRIVER_CARRIER_NUMBER () {
					return this.FROM_DRIVER_CARRIER_NUMBER;
				}
				
			    public Integer FROM_SUPPLIER_NUMBER;

				public Integer getFROM_SUPPLIER_NUMBER () {
					return this.FROM_SUPPLIER_NUMBER;
				}
				
			    public String FSHOST_SU_SUPPLIER_NUMBER;

				public String getFSHOST_SU_SUPPLIER_NUMBER () {
					return this.FSHOST_SU_SUPPLIER_NUMBER;
				}
				
			    public Integer FROM_DRIVER_NUMBER;

				public Integer getFROM_DRIVER_NUMBER () {
					return this.FROM_DRIVER_NUMBER;
				}
				
			    public Integer TO_SUPPLIER_NUMBER;

				public Integer getTO_SUPPLIER_NUMBER () {
					return this.TO_SUPPLIER_NUMBER;
				}
				
			    public Integer FROM_CARRIER_NUMBER;

				public Integer getFROM_CARRIER_NUMBER () {
					return this.FROM_CARRIER_NUMBER;
				}
				
			    public String FSHOST_EX_THOST_EXCH_NUMBER;

				public String getFSHOST_EX_THOST_EXCH_NUMBER () {
					return this.FSHOST_EX_THOST_EXCH_NUMBER;
				}
				
			    public Integer TRANSACTION_SUBTYPE;

				public Integer getTRANSACTION_SUBTYPE () {
					return this.TRANSACTION_SUBTYPE;
				}
				
			    public int TYPE;

				public int getTYPE () {
					return this.TYPE;
				}
				
			    public String TSHOST_SU_SUPPLIER_NUMBER;

				public String getTSHOST_SU_SUPPLIER_NUMBER () {
					return this.TSHOST_SU_SUPPLIER_NUMBER;
				}
				
			    public String TSHOST_EX_EHOST_THRU_NUMBER;

				public String getTSHOST_EX_EHOST_THRU_NUMBER () {
					return this.TSHOST_EX_EHOST_THRU_NUMBER;
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
				
			    public String REFERENCE_NUMBER;

				public String getREFERENCE_NUMBER () {
					return this.REFERENCE_NUMBER;
				}
				
			    public int STATUS;

				public int getSTATUS () {
					return this.STATUS;
				}
				
			    public java.util.Date STATUS_DATE;

				public java.util.Date getSTATUS_DATE () {
					return this.STATUS_DATE;
				}
				
			    public String REMARKS;

				public String getREMARKS () {
					return this.REMARKS;
				}
				
			    public java.util.Date MOVEMENT_DATE;

				public java.util.Date getMOVEMENT_DATE () {
					return this.MOVEMENT_DATE;
				}
				
			    public String VESSEL;

				public String getVESSEL () {
					return this.VESSEL;
				}
				
			    public String DOC_OPERATOR_CODE;

				public String getDOC_OPERATOR_CODE () {
					return this.DOC_OPERATOR_CODE;
				}
				
			    public String BATCH_VOYAGE_NUMBER;

				public String getBATCH_VOYAGE_NUMBER () {
					return this.BATCH_VOYAGE_NUMBER;
				}
				
			    public String LAST_USER_NAME;

				public String getLAST_USER_NAME () {
					return this.LAST_USER_NAME;
				}
				
			    public java.util.Date LAST_MODIFIED;

				public java.util.Date getLAST_MODIFIED () {
					return this.LAST_MODIFIED;
				}
				
			    public int HOST_PROCESSED;

				public int getHOST_PROCESSED () {
					return this.HOST_PROCESSED;
				}
				
			    public int AIC_STATUS;

				public int getAIC_STATUS () {
					return this.AIC_STATUS;
				}
				
			    public int FLAG_APPLY_SUPPLIER_INV;

				public int getFLAG_APPLY_SUPPLIER_INV () {
					return this.FLAG_APPLY_SUPPLIER_INV;
				}
				
			    public int FLAG_APPLY_SUPPLIER_TANK_INV;

				public int getFLAG_APPLY_SUPPLIER_TANK_INV () {
					return this.FLAG_APPLY_SUPPLIER_TANK_INV;
				}
				
			    public int FLAG_APPLY_PARCEL_INV;

				public int getFLAG_APPLY_PARCEL_INV () {
					return this.FLAG_APPLY_PARCEL_INV;
				}
				
			    public int FLAG_APPLY_TANK_INV;

				public int getFLAG_APPLY_TANK_INV () {
					return this.FLAG_APPLY_TANK_INV;
				}
				
			    public int CANCELLED_FROM_CBS;

				public int getCANCELLED_FROM_CBS () {
					return this.CANCELLED_FROM_CBS;
				}
				
			    public String HOST_REF_ID;

				public String getHOST_REF_ID () {
					return this.HOST_REF_ID;
				}
				
			    public int PENDING_PRINT_COUNT;

				public int getPENDING_PRINT_COUNT () {
					return this.PENDING_PRINT_COUNT;
				}
				
			    public int GAIN_LOSS_XCTN;

				public int getGAIN_LOSS_XCTN () {
					return this.GAIN_LOSS_XCTN;
				}
				
			    public int PENDING_REQUEST_COUNT;

				public int getPENDING_REQUEST_COUNT () {
					return this.PENDING_REQUEST_COUNT;
				}
				
			    public Integer ORIG_BULK_MOVEMENT_ID;

				public Integer getORIG_BULK_MOVEMENT_ID () {
					return this.ORIG_BULK_MOVEMENT_ID;
				}
				
			    public Integer PREV_BULK_MOVEMENT_ID;

				public Integer getPREV_BULK_MOVEMENT_ID () {
					return this.PREV_BULK_MOVEMENT_ID;
				}
				
			    public String AGENT;

				public String getAGENT () {
					return this.AGENT;
				}
				
			    public String SURVEYOR_1;

				public String getSURVEYOR_1 () {
					return this.SURVEYOR_1;
				}
				
			    public String SURVEYOR_2;

				public String getSURVEYOR_2 () {
					return this.SURVEYOR_2;
				}
				
			    public Integer TO_CARRIER_NUMBER;

				public Integer getTO_CARRIER_NUMBER () {
					return this.TO_CARRIER_NUMBER;
				}
				
			    public Integer TO_DRIVER_CARRIER_NUMBER;

				public Integer getTO_DRIVER_CARRIER_NUMBER () {
					return this.TO_DRIVER_CARRIER_NUMBER;
				}
				
			    public Integer TO_TRACTOR_CARRIER_NUMBER;

				public Integer getTO_TRACTOR_CARRIER_NUMBER () {
					return this.TO_TRACTOR_CARRIER_NUMBER;
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
			if(length > commonByteArray_PGS_STAGE_DIM_BULK_MOVEMENT.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_BULK_MOVEMENT.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_BULK_MOVEMENT = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_BULK_MOVEMENT = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PGS_STAGE_DIM_BULK_MOVEMENT, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_BULK_MOVEMENT, 0, length, utf8Charset);
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
			if(length > commonByteArray_PGS_STAGE_DIM_BULK_MOVEMENT.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_BULK_MOVEMENT.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_BULK_MOVEMENT = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_BULK_MOVEMENT = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PGS_STAGE_DIM_BULK_MOVEMENT, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_BULK_MOVEMENT, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_BULK_MOVEMENT) {

        	try {

        		int length = 0;
		
			        this.BULK_MOVEMENT_ID = dis.readInt();
					
						this.TO_DESTINATION_SUPPLIER_NUMBER = readInteger(dis);
					
						this.TO_TRACTOR_NUMBER = readInteger(dis);
					
					this.FOLIO_NUMBER = readString(dis);
					
						this.FROM_TRACTOR_CARRIER_NUMBER = readInteger(dis);
					
						this.TO_DESTINATION_CUSTOMER_NUMBER = readInteger(dis);
					
						this.FROM_TRACTOR_NUMBER = readInteger(dis);
					
						this.TO_DESTINATION_NUMBER = readInteger(dis);
					
						this.TO_DRIVER_NUMBER = readInteger(dis);
					
						this.FROM_DRIVER_CARRIER_NUMBER = readInteger(dis);
					
						this.FROM_SUPPLIER_NUMBER = readInteger(dis);
					
					this.FSHOST_SU_SUPPLIER_NUMBER = readString(dis);
					
						this.FROM_DRIVER_NUMBER = readInteger(dis);
					
						this.TO_SUPPLIER_NUMBER = readInteger(dis);
					
						this.FROM_CARRIER_NUMBER = readInteger(dis);
					
					this.FSHOST_EX_THOST_EXCH_NUMBER = readString(dis);
					
						this.TRANSACTION_SUBTYPE = readInteger(dis);
					
			        this.TYPE = dis.readInt();
					
					this.TSHOST_SU_SUPPLIER_NUMBER = readString(dis);
					
					this.TSHOST_EX_EHOST_THRU_NUMBER = readString(dis);
					
			        this.MOVEMENT_NUMBER = dis.readInt();
					
			        this.REVISION_NUMBER = dis.readInt();
					
			        this.REVISED = dis.readInt();
					
					this.REFERENCE_NUMBER = readString(dis);
					
			        this.STATUS = dis.readInt();
					
					this.STATUS_DATE = readDate(dis);
					
					this.REMARKS = readString(dis);
					
					this.MOVEMENT_DATE = readDate(dis);
					
					this.VESSEL = readString(dis);
					
					this.DOC_OPERATOR_CODE = readString(dis);
					
					this.BATCH_VOYAGE_NUMBER = readString(dis);
					
					this.LAST_USER_NAME = readString(dis);
					
					this.LAST_MODIFIED = readDate(dis);
					
			        this.HOST_PROCESSED = dis.readInt();
					
			        this.AIC_STATUS = dis.readInt();
					
			        this.FLAG_APPLY_SUPPLIER_INV = dis.readInt();
					
			        this.FLAG_APPLY_SUPPLIER_TANK_INV = dis.readInt();
					
			        this.FLAG_APPLY_PARCEL_INV = dis.readInt();
					
			        this.FLAG_APPLY_TANK_INV = dis.readInt();
					
			        this.CANCELLED_FROM_CBS = dis.readInt();
					
					this.HOST_REF_ID = readString(dis);
					
			        this.PENDING_PRINT_COUNT = dis.readInt();
					
			        this.GAIN_LOSS_XCTN = dis.readInt();
					
			        this.PENDING_REQUEST_COUNT = dis.readInt();
					
						this.ORIG_BULK_MOVEMENT_ID = readInteger(dis);
					
						this.PREV_BULK_MOVEMENT_ID = readInteger(dis);
					
					this.AGENT = readString(dis);
					
					this.SURVEYOR_1 = readString(dis);
					
					this.SURVEYOR_2 = readString(dis);
					
						this.TO_CARRIER_NUMBER = readInteger(dis);
					
						this.TO_DRIVER_CARRIER_NUMBER = readInteger(dis);
					
						this.TO_TRACTOR_CARRIER_NUMBER = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_BULK_MOVEMENT) {

        	try {

        		int length = 0;
		
			        this.BULK_MOVEMENT_ID = dis.readInt();
					
						this.TO_DESTINATION_SUPPLIER_NUMBER = readInteger(dis);
					
						this.TO_TRACTOR_NUMBER = readInteger(dis);
					
					this.FOLIO_NUMBER = readString(dis);
					
						this.FROM_TRACTOR_CARRIER_NUMBER = readInteger(dis);
					
						this.TO_DESTINATION_CUSTOMER_NUMBER = readInteger(dis);
					
						this.FROM_TRACTOR_NUMBER = readInteger(dis);
					
						this.TO_DESTINATION_NUMBER = readInteger(dis);
					
						this.TO_DRIVER_NUMBER = readInteger(dis);
					
						this.FROM_DRIVER_CARRIER_NUMBER = readInteger(dis);
					
						this.FROM_SUPPLIER_NUMBER = readInteger(dis);
					
					this.FSHOST_SU_SUPPLIER_NUMBER = readString(dis);
					
						this.FROM_DRIVER_NUMBER = readInteger(dis);
					
						this.TO_SUPPLIER_NUMBER = readInteger(dis);
					
						this.FROM_CARRIER_NUMBER = readInteger(dis);
					
					this.FSHOST_EX_THOST_EXCH_NUMBER = readString(dis);
					
						this.TRANSACTION_SUBTYPE = readInteger(dis);
					
			        this.TYPE = dis.readInt();
					
					this.TSHOST_SU_SUPPLIER_NUMBER = readString(dis);
					
					this.TSHOST_EX_EHOST_THRU_NUMBER = readString(dis);
					
			        this.MOVEMENT_NUMBER = dis.readInt();
					
			        this.REVISION_NUMBER = dis.readInt();
					
			        this.REVISED = dis.readInt();
					
					this.REFERENCE_NUMBER = readString(dis);
					
			        this.STATUS = dis.readInt();
					
					this.STATUS_DATE = readDate(dis);
					
					this.REMARKS = readString(dis);
					
					this.MOVEMENT_DATE = readDate(dis);
					
					this.VESSEL = readString(dis);
					
					this.DOC_OPERATOR_CODE = readString(dis);
					
					this.BATCH_VOYAGE_NUMBER = readString(dis);
					
					this.LAST_USER_NAME = readString(dis);
					
					this.LAST_MODIFIED = readDate(dis);
					
			        this.HOST_PROCESSED = dis.readInt();
					
			        this.AIC_STATUS = dis.readInt();
					
			        this.FLAG_APPLY_SUPPLIER_INV = dis.readInt();
					
			        this.FLAG_APPLY_SUPPLIER_TANK_INV = dis.readInt();
					
			        this.FLAG_APPLY_PARCEL_INV = dis.readInt();
					
			        this.FLAG_APPLY_TANK_INV = dis.readInt();
					
			        this.CANCELLED_FROM_CBS = dis.readInt();
					
					this.HOST_REF_ID = readString(dis);
					
			        this.PENDING_PRINT_COUNT = dis.readInt();
					
			        this.GAIN_LOSS_XCTN = dis.readInt();
					
			        this.PENDING_REQUEST_COUNT = dis.readInt();
					
						this.ORIG_BULK_MOVEMENT_ID = readInteger(dis);
					
						this.PREV_BULK_MOVEMENT_ID = readInteger(dis);
					
					this.AGENT = readString(dis);
					
					this.SURVEYOR_1 = readString(dis);
					
					this.SURVEYOR_2 = readString(dis);
					
						this.TO_CARRIER_NUMBER = readInteger(dis);
					
						this.TO_DRIVER_CARRIER_NUMBER = readInteger(dis);
					
						this.TO_TRACTOR_CARRIER_NUMBER = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.BULK_MOVEMENT_ID);
					
					// Integer
				
						writeInteger(this.TO_DESTINATION_SUPPLIER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.TO_TRACTOR_NUMBER,dos);
					
					// String
				
						writeString(this.FOLIO_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.FROM_TRACTOR_CARRIER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.TO_DESTINATION_CUSTOMER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.FROM_TRACTOR_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.TO_DESTINATION_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.TO_DRIVER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.FROM_DRIVER_CARRIER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.FROM_SUPPLIER_NUMBER,dos);
					
					// String
				
						writeString(this.FSHOST_SU_SUPPLIER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.FROM_DRIVER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.TO_SUPPLIER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.FROM_CARRIER_NUMBER,dos);
					
					// String
				
						writeString(this.FSHOST_EX_THOST_EXCH_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.TRANSACTION_SUBTYPE,dos);
					
					// int
				
		            	dos.writeInt(this.TYPE);
					
					// String
				
						writeString(this.TSHOST_SU_SUPPLIER_NUMBER,dos);
					
					// String
				
						writeString(this.TSHOST_EX_EHOST_THRU_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.MOVEMENT_NUMBER);
					
					// int
				
		            	dos.writeInt(this.REVISION_NUMBER);
					
					// int
				
		            	dos.writeInt(this.REVISED);
					
					// String
				
						writeString(this.REFERENCE_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.STATUS);
					
					// java.util.Date
				
						writeDate(this.STATUS_DATE,dos);
					
					// String
				
						writeString(this.REMARKS,dos);
					
					// java.util.Date
				
						writeDate(this.MOVEMENT_DATE,dos);
					
					// String
				
						writeString(this.VESSEL,dos);
					
					// String
				
						writeString(this.DOC_OPERATOR_CODE,dos);
					
					// String
				
						writeString(this.BATCH_VOYAGE_NUMBER,dos);
					
					// String
				
						writeString(this.LAST_USER_NAME,dos);
					
					// java.util.Date
				
						writeDate(this.LAST_MODIFIED,dos);
					
					// int
				
		            	dos.writeInt(this.HOST_PROCESSED);
					
					// int
				
		            	dos.writeInt(this.AIC_STATUS);
					
					// int
				
		            	dos.writeInt(this.FLAG_APPLY_SUPPLIER_INV);
					
					// int
				
		            	dos.writeInt(this.FLAG_APPLY_SUPPLIER_TANK_INV);
					
					// int
				
		            	dos.writeInt(this.FLAG_APPLY_PARCEL_INV);
					
					// int
				
		            	dos.writeInt(this.FLAG_APPLY_TANK_INV);
					
					// int
				
		            	dos.writeInt(this.CANCELLED_FROM_CBS);
					
					// String
				
						writeString(this.HOST_REF_ID,dos);
					
					// int
				
		            	dos.writeInt(this.PENDING_PRINT_COUNT);
					
					// int
				
		            	dos.writeInt(this.GAIN_LOSS_XCTN);
					
					// int
				
		            	dos.writeInt(this.PENDING_REQUEST_COUNT);
					
					// Integer
				
						writeInteger(this.ORIG_BULK_MOVEMENT_ID,dos);
					
					// Integer
				
						writeInteger(this.PREV_BULK_MOVEMENT_ID,dos);
					
					// String
				
						writeString(this.AGENT,dos);
					
					// String
				
						writeString(this.SURVEYOR_1,dos);
					
					// String
				
						writeString(this.SURVEYOR_2,dos);
					
					// Integer
				
						writeInteger(this.TO_CARRIER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.TO_DRIVER_CARRIER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.TO_TRACTOR_CARRIER_NUMBER,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.BULK_MOVEMENT_ID);
					
					// Integer
				
						writeInteger(this.TO_DESTINATION_SUPPLIER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.TO_TRACTOR_NUMBER,dos);
					
					// String
				
						writeString(this.FOLIO_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.FROM_TRACTOR_CARRIER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.TO_DESTINATION_CUSTOMER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.FROM_TRACTOR_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.TO_DESTINATION_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.TO_DRIVER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.FROM_DRIVER_CARRIER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.FROM_SUPPLIER_NUMBER,dos);
					
					// String
				
						writeString(this.FSHOST_SU_SUPPLIER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.FROM_DRIVER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.TO_SUPPLIER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.FROM_CARRIER_NUMBER,dos);
					
					// String
				
						writeString(this.FSHOST_EX_THOST_EXCH_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.TRANSACTION_SUBTYPE,dos);
					
					// int
				
		            	dos.writeInt(this.TYPE);
					
					// String
				
						writeString(this.TSHOST_SU_SUPPLIER_NUMBER,dos);
					
					// String
				
						writeString(this.TSHOST_EX_EHOST_THRU_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.MOVEMENT_NUMBER);
					
					// int
				
		            	dos.writeInt(this.REVISION_NUMBER);
					
					// int
				
		            	dos.writeInt(this.REVISED);
					
					// String
				
						writeString(this.REFERENCE_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.STATUS);
					
					// java.util.Date
				
						writeDate(this.STATUS_DATE,dos);
					
					// String
				
						writeString(this.REMARKS,dos);
					
					// java.util.Date
				
						writeDate(this.MOVEMENT_DATE,dos);
					
					// String
				
						writeString(this.VESSEL,dos);
					
					// String
				
						writeString(this.DOC_OPERATOR_CODE,dos);
					
					// String
				
						writeString(this.BATCH_VOYAGE_NUMBER,dos);
					
					// String
				
						writeString(this.LAST_USER_NAME,dos);
					
					// java.util.Date
				
						writeDate(this.LAST_MODIFIED,dos);
					
					// int
				
		            	dos.writeInt(this.HOST_PROCESSED);
					
					// int
				
		            	dos.writeInt(this.AIC_STATUS);
					
					// int
				
		            	dos.writeInt(this.FLAG_APPLY_SUPPLIER_INV);
					
					// int
				
		            	dos.writeInt(this.FLAG_APPLY_SUPPLIER_TANK_INV);
					
					// int
				
		            	dos.writeInt(this.FLAG_APPLY_PARCEL_INV);
					
					// int
				
		            	dos.writeInt(this.FLAG_APPLY_TANK_INV);
					
					// int
				
		            	dos.writeInt(this.CANCELLED_FROM_CBS);
					
					// String
				
						writeString(this.HOST_REF_ID,dos);
					
					// int
				
		            	dos.writeInt(this.PENDING_PRINT_COUNT);
					
					// int
				
		            	dos.writeInt(this.GAIN_LOSS_XCTN);
					
					// int
				
		            	dos.writeInt(this.PENDING_REQUEST_COUNT);
					
					// Integer
				
						writeInteger(this.ORIG_BULK_MOVEMENT_ID,dos);
					
					// Integer
				
						writeInteger(this.PREV_BULK_MOVEMENT_ID,dos);
					
					// String
				
						writeString(this.AGENT,dos);
					
					// String
				
						writeString(this.SURVEYOR_1,dos);
					
					// String
				
						writeString(this.SURVEYOR_2,dos);
					
					// Integer
				
						writeInteger(this.TO_CARRIER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.TO_DRIVER_CARRIER_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.TO_TRACTOR_CARRIER_NUMBER,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("BULK_MOVEMENT_ID="+String.valueOf(BULK_MOVEMENT_ID));
		sb.append(",TO_DESTINATION_SUPPLIER_NUMBER="+String.valueOf(TO_DESTINATION_SUPPLIER_NUMBER));
		sb.append(",TO_TRACTOR_NUMBER="+String.valueOf(TO_TRACTOR_NUMBER));
		sb.append(",FOLIO_NUMBER="+FOLIO_NUMBER);
		sb.append(",FROM_TRACTOR_CARRIER_NUMBER="+String.valueOf(FROM_TRACTOR_CARRIER_NUMBER));
		sb.append(",TO_DESTINATION_CUSTOMER_NUMBER="+String.valueOf(TO_DESTINATION_CUSTOMER_NUMBER));
		sb.append(",FROM_TRACTOR_NUMBER="+String.valueOf(FROM_TRACTOR_NUMBER));
		sb.append(",TO_DESTINATION_NUMBER="+String.valueOf(TO_DESTINATION_NUMBER));
		sb.append(",TO_DRIVER_NUMBER="+String.valueOf(TO_DRIVER_NUMBER));
		sb.append(",FROM_DRIVER_CARRIER_NUMBER="+String.valueOf(FROM_DRIVER_CARRIER_NUMBER));
		sb.append(",FROM_SUPPLIER_NUMBER="+String.valueOf(FROM_SUPPLIER_NUMBER));
		sb.append(",FSHOST_SU_SUPPLIER_NUMBER="+FSHOST_SU_SUPPLIER_NUMBER);
		sb.append(",FROM_DRIVER_NUMBER="+String.valueOf(FROM_DRIVER_NUMBER));
		sb.append(",TO_SUPPLIER_NUMBER="+String.valueOf(TO_SUPPLIER_NUMBER));
		sb.append(",FROM_CARRIER_NUMBER="+String.valueOf(FROM_CARRIER_NUMBER));
		sb.append(",FSHOST_EX_THOST_EXCH_NUMBER="+FSHOST_EX_THOST_EXCH_NUMBER);
		sb.append(",TRANSACTION_SUBTYPE="+String.valueOf(TRANSACTION_SUBTYPE));
		sb.append(",TYPE="+String.valueOf(TYPE));
		sb.append(",TSHOST_SU_SUPPLIER_NUMBER="+TSHOST_SU_SUPPLIER_NUMBER);
		sb.append(",TSHOST_EX_EHOST_THRU_NUMBER="+TSHOST_EX_EHOST_THRU_NUMBER);
		sb.append(",MOVEMENT_NUMBER="+String.valueOf(MOVEMENT_NUMBER));
		sb.append(",REVISION_NUMBER="+String.valueOf(REVISION_NUMBER));
		sb.append(",REVISED="+String.valueOf(REVISED));
		sb.append(",REFERENCE_NUMBER="+REFERENCE_NUMBER);
		sb.append(",STATUS="+String.valueOf(STATUS));
		sb.append(",STATUS_DATE="+String.valueOf(STATUS_DATE));
		sb.append(",REMARKS="+REMARKS);
		sb.append(",MOVEMENT_DATE="+String.valueOf(MOVEMENT_DATE));
		sb.append(",VESSEL="+VESSEL);
		sb.append(",DOC_OPERATOR_CODE="+DOC_OPERATOR_CODE);
		sb.append(",BATCH_VOYAGE_NUMBER="+BATCH_VOYAGE_NUMBER);
		sb.append(",LAST_USER_NAME="+LAST_USER_NAME);
		sb.append(",LAST_MODIFIED="+String.valueOf(LAST_MODIFIED));
		sb.append(",HOST_PROCESSED="+String.valueOf(HOST_PROCESSED));
		sb.append(",AIC_STATUS="+String.valueOf(AIC_STATUS));
		sb.append(",FLAG_APPLY_SUPPLIER_INV="+String.valueOf(FLAG_APPLY_SUPPLIER_INV));
		sb.append(",FLAG_APPLY_SUPPLIER_TANK_INV="+String.valueOf(FLAG_APPLY_SUPPLIER_TANK_INV));
		sb.append(",FLAG_APPLY_PARCEL_INV="+String.valueOf(FLAG_APPLY_PARCEL_INV));
		sb.append(",FLAG_APPLY_TANK_INV="+String.valueOf(FLAG_APPLY_TANK_INV));
		sb.append(",CANCELLED_FROM_CBS="+String.valueOf(CANCELLED_FROM_CBS));
		sb.append(",HOST_REF_ID="+HOST_REF_ID);
		sb.append(",PENDING_PRINT_COUNT="+String.valueOf(PENDING_PRINT_COUNT));
		sb.append(",GAIN_LOSS_XCTN="+String.valueOf(GAIN_LOSS_XCTN));
		sb.append(",PENDING_REQUEST_COUNT="+String.valueOf(PENDING_REQUEST_COUNT));
		sb.append(",ORIG_BULK_MOVEMENT_ID="+String.valueOf(ORIG_BULK_MOVEMENT_ID));
		sb.append(",PREV_BULK_MOVEMENT_ID="+String.valueOf(PREV_BULK_MOVEMENT_ID));
		sb.append(",AGENT="+AGENT);
		sb.append(",SURVEYOR_1="+SURVEYOR_1);
		sb.append(",SURVEYOR_2="+SURVEYOR_2);
		sb.append(",TO_CARRIER_NUMBER="+String.valueOf(TO_CARRIER_NUMBER));
		sb.append(",TO_DRIVER_CARRIER_NUMBER="+String.valueOf(TO_DRIVER_CARRIER_NUMBER));
		sb.append(",TO_TRACTOR_CARRIER_NUMBER="+String.valueOf(TO_TRACTOR_CARRIER_NUMBER));
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
out2Struct out2 = new out2Struct();






	
	/**
	 * [tDBOutput_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBOutput_1", false);
		start_Hash.put("tDBOutput_1", System.currentTimeMillis());
		
	
	currentComponent="tDBOutput_1";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"out2");
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
        } else if (updateKeyCount_tDBOutput_1 == 18 && true) {
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

 
	final String decryptedPassword_tDBOutput_1 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:nI3W6D7nrVrQ4LPcHDKbWzY3zGSBw2HOrorbX+Nvu2DdBZZrOqs=");

    String dbPwd_tDBOutput_1 = decryptedPassword_tDBOutput_1;	
    conn_tDBOutput_1 = java.sql.DriverManager.getConnection(url_tDBOutput_1,dbUser_tDBOutput_1,dbPwd_tDBOutput_1);
	
		resourceMap.put("conn_tDBOutput_1", conn_tDBOutput_1);
	
        conn_tDBOutput_1.setAutoCommit(false);
        int commitEvery_tDBOutput_1 = 10000;
        int commitCounter_tDBOutput_1 = 0;


if(dbschema_tDBOutput_1 == null || dbschema_tDBOutput_1.trim().length() == 0) {
    tableName_tDBOutput_1 = "DIM_BULK_MOVEMENT";
} else {
    tableName_tDBOutput_1 = dbschema_tDBOutput_1 + "].[" + "DIM_BULK_MOVEMENT";
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
                                if(!whetherExist_tDBOutput_1) {
                                    try (java.sql.Statement stmtCreate_tDBOutput_1 = conn_tDBOutput_1.createStatement()) {
                                        stmtCreate_tDBOutput_1.execute("CREATE TABLE [" + tableName_tDBOutput_1 + "]([PK_BULK_MOVEMENT] INT ,[BULK_MOVEMENT_ID] INT  not null ,[FOLIO_NUMBER] VARCHAR(8)  ,[DATE] DATETIME ,[FROM_SUPPLIER_NUMBER] INT ,[TYPE] INT  not null ,[MOVEMENT_NUMBER] INT  not null ,[REVISION_NUMBER] INT  not null ,[REVISED] INT  not null ,[STATUS] INT  not null ,[STATUS_DATE] DATETIME ,[REMARKS] VARCHAR(80)  ,[MOVEMENT_DATE] DATETIME ,[LAST_USER_NAME] VARCHAR(10)  ,[LAST_MODIFIED] DATETIME ,[AIC_STATUS] INT  not null ,[ORIG_BULK_MOVEMENT_ID] INT ,[PREV_BULK_MOVEMENT_ID] INT ,primary key([PK_BULK_MOVEMENT]))");
                                    }
                                }
        java.sql.PreparedStatement pstmt_tDBOutput_1 = conn_tDBOutput_1.prepareStatement("SELECT COUNT(1) FROM [" + tableName_tDBOutput_1 + "] WHERE [PK_BULK_MOVEMENT] = ?");
        resourceMap.put("pstmt_tDBOutput_1", pstmt_tDBOutput_1);
        String insert_tDBOutput_1 = "INSERT INTO [" + tableName_tDBOutput_1 + "] ([PK_BULK_MOVEMENT],[BULK_MOVEMENT_ID],[FOLIO_NUMBER],[DATE],[FROM_SUPPLIER_NUMBER],[TYPE],[MOVEMENT_NUMBER],[REVISION_NUMBER],[REVISED],[STATUS],[STATUS_DATE],[REMARKS],[MOVEMENT_DATE],[LAST_USER_NAME],[LAST_MODIFIED],[AIC_STATUS],[ORIG_BULK_MOVEMENT_ID],[PREV_BULK_MOVEMENT_ID]) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        java.sql.PreparedStatement pstmtInsert_tDBOutput_1 = conn_tDBOutput_1.prepareStatement(insert_tDBOutput_1);
        resourceMap.put("pstmtInsert_tDBOutput_1", pstmtInsert_tDBOutput_1);
        String update_tDBOutput_1 = "UPDATE [" + tableName_tDBOutput_1 + "] SET [BULK_MOVEMENT_ID] = ?,[FOLIO_NUMBER] = ?,[DATE] = ?,[FROM_SUPPLIER_NUMBER] = ?,[TYPE] = ?,[MOVEMENT_NUMBER] = ?,[REVISION_NUMBER] = ?,[REVISED] = ?,[STATUS] = ?,[STATUS_DATE] = ?,[REMARKS] = ?,[MOVEMENT_DATE] = ?,[LAST_USER_NAME] = ?,[LAST_MODIFIED] = ?,[AIC_STATUS] = ?,[ORIG_BULK_MOVEMENT_ID] = ?,[PREV_BULK_MOVEMENT_ID] = ? WHERE [PK_BULK_MOVEMENT] = ?";
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
	int PK_BULK_MOVEMENT;
}
Var__tMap_1__Struct Var__tMap_1 = new Var__tMap_1__Struct();
// ###############################

// ###############################
// # Outputs initialization
out2Struct out2_tmp = new out2Struct();
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
	
	        
					int BULK_MOVEMENT_ID;
					String FOLIO_NUMBER;        
	        
		    @Override
			public int hashCode() {
				if (this.hashCodeDirty) {
					final int prime = PRIME;
					int result = DEFAULT_HASHCODE;
			
									result = prime * result + (int) this.BULK_MOVEMENT_ID;
									
								result = prime * result + ((this.FOLIO_NUMBER == null) ? 0 : this.FOLIO_NUMBER.hashCode());
								
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
				
									if (this.BULK_MOVEMENT_ID != other.BULK_MOVEMENT_ID) 
										return false;
								
									if (this.FOLIO_NUMBER == null) {
										if (other.FOLIO_NUMBER != null) 
											return false;
								
									} else if (!this.FOLIO_NUMBER.equals(other.FOLIO_NUMBER))
								 
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
				
				 
	final String decryptedPassword_tDBInput_1 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:BjX9hjPbiey2ACqCulekYCKAbHXbqWt+ofQhZrMYcQ60oI22/t8=");
				
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

		    String dbquery_tDBInput_1 = "SELECT dbo.BULK_MOVEMENT.BULK_MOVEMENT_ID,\n		dbo.BULK_MOVEMENT.TO_DESTINATION_SUPPLIER_NUMBER,\n		dbo.BULK_MOVEMENT.TO_T"
+"RACTOR_NUMBER,\n		dbo.BULK_MOVEMENT.FOLIO_NUMBER,\n		dbo.BULK_MOVEMENT.FROM_TRACTOR_CARRIER_NUMBER,\n		dbo.BULK_MOVEMENT.TO"
+"_DESTINATION_CUSTOMER_NUMBER,\n		dbo.BULK_MOVEMENT.FROM_TRACTOR_NUMBER,\n		dbo.BULK_MOVEMENT.TO_DESTINATION_NUMBER,\n		dbo."
+"BULK_MOVEMENT.TO_DRIVER_NUMBER,\n		dbo.BULK_MOVEMENT.FROM_DRIVER_CARRIER_NUMBER,\n		dbo.BULK_MOVEMENT.FROM_SUPPLIER_NUMBER"
+",\n		dbo.BULK_MOVEMENT.FSHOST_SU_SUPPLIER_NUMBER,\n		dbo.BULK_MOVEMENT.FROM_DRIVER_NUMBER,\n		dbo.BULK_MOVEMENT.TO_SUPPLIER"
+"_NUMBER,\n		dbo.BULK_MOVEMENT.FROM_CARRIER_NUMBER,\n		dbo.BULK_MOVEMENT.FSHOST_EX_THOST_EXCH_NUMBER,\n		dbo.BULK_MOVEMENT.T"
+"RANSACTION_SUBTYPE,\n		dbo.BULK_MOVEMENT.TYPE,\n		dbo.BULK_MOVEMENT.TSHOST_SU_SUPPLIER_NUMBER,\n		dbo.BULK_MOVEMENT.TSHOST_"
+"EX_EHOST_THRU_NUMBER,\n		dbo.BULK_MOVEMENT.MOVEMENT_NUMBER,\n		dbo.BULK_MOVEMENT.REVISION_NUMBER,\n		dbo.BULK_MOVEMENT.REVI"
+"SED,\n		dbo.BULK_MOVEMENT.REFERENCE_NUMBER,\n		dbo.BULK_MOVEMENT.STATUS,\n		dbo.BULK_MOVEMENT.STATUS_DATE,\n		dbo.BULK_MOVEM"
+"ENT.REMARKS,\n		dbo.BULK_MOVEMENT.MOVEMENT_DATE,\n		dbo.BULK_MOVEMENT.VESSEL,\n		dbo.BULK_MOVEMENT.DOC_OPERATOR_CODE,\n		dbo"
+".BULK_MOVEMENT.BATCH_VOYAGE_NUMBER,\n		dbo.BULK_MOVEMENT.LAST_USER_NAME,\n		dbo.BULK_MOVEMENT.LAST_MODIFIED,\n		dbo.BULK_MO"
+"VEMENT.HOST_PROCESSED,\n		dbo.BULK_MOVEMENT.AIC_STATUS,\n		dbo.BULK_MOVEMENT.FLAG_APPLY_SUPPLIER_INV,\n		dbo.BULK_MOVEMENT."
+"FLAG_APPLY_SUPPLIER_TANK_INV,\n		dbo.BULK_MOVEMENT.FLAG_APPLY_PARCEL_INV,\n		dbo.BULK_MOVEMENT.FLAG_APPLY_TANK_INV,\n		dbo."
+"BULK_MOVEMENT.CANCELLED_FROM_CBS,\n		dbo.BULK_MOVEMENT.HOST_REF_ID,\n		dbo.BULK_MOVEMENT.PENDING_PRINT_COUNT,\n		dbo.BULK_M"
+"OVEMENT.GAIN_LOSS_XCTN,\n		dbo.BULK_MOVEMENT.PENDING_REQUEST_COUNT,\n		dbo.BULK_MOVEMENT.ORIG_BULK_MOVEMENT_ID,\n		dbo.BULK"
+"_MOVEMENT.PREV_BULK_MOVEMENT_ID,\n		dbo.BULK_MOVEMENT.AGENT,\n		dbo.BULK_MOVEMENT.SURVEYOR_1,\n		dbo.BULK_MOVEMENT.SURVEYOR"
+"_2,\n		dbo.BULK_MOVEMENT.TO_CARRIER_NUMBER,\n		dbo.BULK_MOVEMENT.TO_DRIVER_CARRIER_NUMBER,\n		dbo.BULK_MOVEMENT.TO_TRACTOR_"
+"CARRIER_NUMBER\nFROM	dbo.BULK_MOVEMENT";
		    

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
								row1.BULK_MOVEMENT_ID = 0;
							} else {
		                          
            row1.BULK_MOVEMENT_ID = rs_tDBInput_1.getInt(1);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 2) {
								row1.TO_DESTINATION_SUPPLIER_NUMBER = null;
							} else {
		                          
            row1.TO_DESTINATION_SUPPLIER_NUMBER = rs_tDBInput_1.getInt(2);
            if(rs_tDBInput_1.wasNull()){
                    row1.TO_DESTINATION_SUPPLIER_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 3) {
								row1.TO_TRACTOR_NUMBER = null;
							} else {
		                          
            row1.TO_TRACTOR_NUMBER = rs_tDBInput_1.getInt(3);
            if(rs_tDBInput_1.wasNull()){
                    row1.TO_TRACTOR_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 4) {
								row1.FOLIO_NUMBER = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(4);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(4).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.FOLIO_NUMBER = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.FOLIO_NUMBER = tmpContent_tDBInput_1;
                }
            } else {
                row1.FOLIO_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 5) {
								row1.FROM_TRACTOR_CARRIER_NUMBER = null;
							} else {
		                          
            row1.FROM_TRACTOR_CARRIER_NUMBER = rs_tDBInput_1.getInt(5);
            if(rs_tDBInput_1.wasNull()){
                    row1.FROM_TRACTOR_CARRIER_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 6) {
								row1.TO_DESTINATION_CUSTOMER_NUMBER = null;
							} else {
		                          
            row1.TO_DESTINATION_CUSTOMER_NUMBER = rs_tDBInput_1.getInt(6);
            if(rs_tDBInput_1.wasNull()){
                    row1.TO_DESTINATION_CUSTOMER_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 7) {
								row1.FROM_TRACTOR_NUMBER = null;
							} else {
		                          
            row1.FROM_TRACTOR_NUMBER = rs_tDBInput_1.getInt(7);
            if(rs_tDBInput_1.wasNull()){
                    row1.FROM_TRACTOR_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 8) {
								row1.TO_DESTINATION_NUMBER = null;
							} else {
		                          
            row1.TO_DESTINATION_NUMBER = rs_tDBInput_1.getInt(8);
            if(rs_tDBInput_1.wasNull()){
                    row1.TO_DESTINATION_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 9) {
								row1.TO_DRIVER_NUMBER = null;
							} else {
		                          
            row1.TO_DRIVER_NUMBER = rs_tDBInput_1.getInt(9);
            if(rs_tDBInput_1.wasNull()){
                    row1.TO_DRIVER_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 10) {
								row1.FROM_DRIVER_CARRIER_NUMBER = null;
							} else {
		                          
            row1.FROM_DRIVER_CARRIER_NUMBER = rs_tDBInput_1.getInt(10);
            if(rs_tDBInput_1.wasNull()){
                    row1.FROM_DRIVER_CARRIER_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 11) {
								row1.FROM_SUPPLIER_NUMBER = null;
							} else {
		                          
            row1.FROM_SUPPLIER_NUMBER = rs_tDBInput_1.getInt(11);
            if(rs_tDBInput_1.wasNull()){
                    row1.FROM_SUPPLIER_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 12) {
								row1.FSHOST_SU_SUPPLIER_NUMBER = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(12);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(12).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.FSHOST_SU_SUPPLIER_NUMBER = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.FSHOST_SU_SUPPLIER_NUMBER = tmpContent_tDBInput_1;
                }
            } else {
                row1.FSHOST_SU_SUPPLIER_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 13) {
								row1.FROM_DRIVER_NUMBER = null;
							} else {
		                          
            row1.FROM_DRIVER_NUMBER = rs_tDBInput_1.getInt(13);
            if(rs_tDBInput_1.wasNull()){
                    row1.FROM_DRIVER_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 14) {
								row1.TO_SUPPLIER_NUMBER = null;
							} else {
		                          
            row1.TO_SUPPLIER_NUMBER = rs_tDBInput_1.getInt(14);
            if(rs_tDBInput_1.wasNull()){
                    row1.TO_SUPPLIER_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 15) {
								row1.FROM_CARRIER_NUMBER = null;
							} else {
		                          
            row1.FROM_CARRIER_NUMBER = rs_tDBInput_1.getInt(15);
            if(rs_tDBInput_1.wasNull()){
                    row1.FROM_CARRIER_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 16) {
								row1.FSHOST_EX_THOST_EXCH_NUMBER = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(16);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(16).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.FSHOST_EX_THOST_EXCH_NUMBER = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.FSHOST_EX_THOST_EXCH_NUMBER = tmpContent_tDBInput_1;
                }
            } else {
                row1.FSHOST_EX_THOST_EXCH_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 17) {
								row1.TRANSACTION_SUBTYPE = null;
							} else {
		                          
            row1.TRANSACTION_SUBTYPE = rs_tDBInput_1.getInt(17);
            if(rs_tDBInput_1.wasNull()){
                    row1.TRANSACTION_SUBTYPE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 18) {
								row1.TYPE = 0;
							} else {
		                          
            row1.TYPE = rs_tDBInput_1.getInt(18);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 19) {
								row1.TSHOST_SU_SUPPLIER_NUMBER = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(19);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(19).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.TSHOST_SU_SUPPLIER_NUMBER = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.TSHOST_SU_SUPPLIER_NUMBER = tmpContent_tDBInput_1;
                }
            } else {
                row1.TSHOST_SU_SUPPLIER_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 20) {
								row1.TSHOST_EX_EHOST_THRU_NUMBER = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(20);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(20).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.TSHOST_EX_EHOST_THRU_NUMBER = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.TSHOST_EX_EHOST_THRU_NUMBER = tmpContent_tDBInput_1;
                }
            } else {
                row1.TSHOST_EX_EHOST_THRU_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 21) {
								row1.MOVEMENT_NUMBER = 0;
							} else {
		                          
            row1.MOVEMENT_NUMBER = rs_tDBInput_1.getInt(21);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 22) {
								row1.REVISION_NUMBER = 0;
							} else {
		                          
            row1.REVISION_NUMBER = rs_tDBInput_1.getInt(22);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 23) {
								row1.REVISED = 0;
							} else {
		                          
            row1.REVISED = rs_tDBInput_1.getInt(23);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 24) {
								row1.REFERENCE_NUMBER = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(24);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(24).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.REFERENCE_NUMBER = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.REFERENCE_NUMBER = tmpContent_tDBInput_1;
                }
            } else {
                row1.REFERENCE_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 25) {
								row1.STATUS = 0;
							} else {
		                          
            row1.STATUS = rs_tDBInput_1.getInt(25);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 26) {
								row1.STATUS_DATE = null;
							} else {
										
			row1.STATUS_DATE = mssqlGTU_tDBInput_1.getDate(rsmd_tDBInput_1, rs_tDBInput_1, 26);
			
		                    }
							if(colQtyInRs_tDBInput_1 < 27) {
								row1.REMARKS = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(27);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(27).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.REMARKS = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.REMARKS = tmpContent_tDBInput_1;
                }
            } else {
                row1.REMARKS = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 28) {
								row1.MOVEMENT_DATE = null;
							} else {
										
			row1.MOVEMENT_DATE = mssqlGTU_tDBInput_1.getDate(rsmd_tDBInput_1, rs_tDBInput_1, 28);
			
		                    }
							if(colQtyInRs_tDBInput_1 < 29) {
								row1.VESSEL = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(29);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(29).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.VESSEL = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.VESSEL = tmpContent_tDBInput_1;
                }
            } else {
                row1.VESSEL = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 30) {
								row1.DOC_OPERATOR_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(30);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(30).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.DOC_OPERATOR_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.DOC_OPERATOR_CODE = tmpContent_tDBInput_1;
                }
            } else {
                row1.DOC_OPERATOR_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 31) {
								row1.BATCH_VOYAGE_NUMBER = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(31);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(31).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.BATCH_VOYAGE_NUMBER = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.BATCH_VOYAGE_NUMBER = tmpContent_tDBInput_1;
                }
            } else {
                row1.BATCH_VOYAGE_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 32) {
								row1.LAST_USER_NAME = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(32);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(32).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.LAST_USER_NAME = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.LAST_USER_NAME = tmpContent_tDBInput_1;
                }
            } else {
                row1.LAST_USER_NAME = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 33) {
								row1.LAST_MODIFIED = null;
							} else {
										
			row1.LAST_MODIFIED = mssqlGTU_tDBInput_1.getDate(rsmd_tDBInput_1, rs_tDBInput_1, 33);
			
		                    }
							if(colQtyInRs_tDBInput_1 < 34) {
								row1.HOST_PROCESSED = 0;
							} else {
		                          
            row1.HOST_PROCESSED = rs_tDBInput_1.getInt(34);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 35) {
								row1.AIC_STATUS = 0;
							} else {
		                          
            row1.AIC_STATUS = rs_tDBInput_1.getInt(35);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 36) {
								row1.FLAG_APPLY_SUPPLIER_INV = 0;
							} else {
		                          
            row1.FLAG_APPLY_SUPPLIER_INV = rs_tDBInput_1.getInt(36);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 37) {
								row1.FLAG_APPLY_SUPPLIER_TANK_INV = 0;
							} else {
		                          
            row1.FLAG_APPLY_SUPPLIER_TANK_INV = rs_tDBInput_1.getInt(37);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 38) {
								row1.FLAG_APPLY_PARCEL_INV = 0;
							} else {
		                          
            row1.FLAG_APPLY_PARCEL_INV = rs_tDBInput_1.getInt(38);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 39) {
								row1.FLAG_APPLY_TANK_INV = 0;
							} else {
		                          
            row1.FLAG_APPLY_TANK_INV = rs_tDBInput_1.getInt(39);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 40) {
								row1.CANCELLED_FROM_CBS = 0;
							} else {
		                          
            row1.CANCELLED_FROM_CBS = rs_tDBInput_1.getInt(40);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 41) {
								row1.HOST_REF_ID = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(41);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(41).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.HOST_REF_ID = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.HOST_REF_ID = tmpContent_tDBInput_1;
                }
            } else {
                row1.HOST_REF_ID = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 42) {
								row1.PENDING_PRINT_COUNT = 0;
							} else {
		                          
            row1.PENDING_PRINT_COUNT = rs_tDBInput_1.getInt(42);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 43) {
								row1.GAIN_LOSS_XCTN = 0;
							} else {
		                          
            row1.GAIN_LOSS_XCTN = rs_tDBInput_1.getInt(43);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 44) {
								row1.PENDING_REQUEST_COUNT = 0;
							} else {
		                          
            row1.PENDING_REQUEST_COUNT = rs_tDBInput_1.getInt(44);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 45) {
								row1.ORIG_BULK_MOVEMENT_ID = null;
							} else {
		                          
            row1.ORIG_BULK_MOVEMENT_ID = rs_tDBInput_1.getInt(45);
            if(rs_tDBInput_1.wasNull()){
                    row1.ORIG_BULK_MOVEMENT_ID = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 46) {
								row1.PREV_BULK_MOVEMENT_ID = null;
							} else {
		                          
            row1.PREV_BULK_MOVEMENT_ID = rs_tDBInput_1.getInt(46);
            if(rs_tDBInput_1.wasNull()){
                    row1.PREV_BULK_MOVEMENT_ID = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 47) {
								row1.AGENT = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(47);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(47).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.AGENT = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.AGENT = tmpContent_tDBInput_1;
                }
            } else {
                row1.AGENT = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 48) {
								row1.SURVEYOR_1 = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(48);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(48).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.SURVEYOR_1 = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.SURVEYOR_1 = tmpContent_tDBInput_1;
                }
            } else {
                row1.SURVEYOR_1 = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 49) {
								row1.SURVEYOR_2 = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(49);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(49).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.SURVEYOR_2 = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.SURVEYOR_2 = tmpContent_tDBInput_1;
                }
            } else {
                row1.SURVEYOR_2 = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 50) {
								row1.TO_CARRIER_NUMBER = null;
							} else {
		                          
            row1.TO_CARRIER_NUMBER = rs_tDBInput_1.getInt(50);
            if(rs_tDBInput_1.wasNull()){
                    row1.TO_CARRIER_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 51) {
								row1.TO_DRIVER_CARRIER_NUMBER = null;
							} else {
		                          
            row1.TO_DRIVER_CARRIER_NUMBER = rs_tDBInput_1.getInt(51);
            if(rs_tDBInput_1.wasNull()){
                    row1.TO_DRIVER_CARRIER_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 52) {
								row1.TO_TRACTOR_CARRIER_NUMBER = null;
							} else {
		                          
            row1.TO_TRACTOR_CARRIER_NUMBER = rs_tDBInput_1.getInt(52);
            if(rs_tDBInput_1.wasNull()){
                    row1.TO_TRACTOR_CARRIER_NUMBER = null;
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
finder_tUniqRow_1.BULK_MOVEMENT_ID = row1.BULK_MOVEMENT_ID;
if(row1.FOLIO_NUMBER == null){
	finder_tUniqRow_1.FOLIO_NUMBER = null;
}else{
	finder_tUniqRow_1.FOLIO_NUMBER = row1.FOLIO_NUMBER.toLowerCase();
}	
finder_tUniqRow_1.hashCodeDirty = true;
if (!keystUniqRow_1.contains(finder_tUniqRow_1)) {
		KeyStruct_tUniqRow_1 new_tUniqRow_1 = new KeyStruct_tUniqRow_1();

		
new_tUniqRow_1.BULK_MOVEMENT_ID = row1.BULK_MOVEMENT_ID;
if(row1.FOLIO_NUMBER == null){
	new_tUniqRow_1.FOLIO_NUMBER = null;
}else{
	new_tUniqRow_1.FOLIO_NUMBER = row1.FOLIO_NUMBER.toLowerCase();
}
		
		keystUniqRow_1.add(new_tUniqRow_1);if(row2 == null){ 
	
	row2 = new row2Struct();
}row2.BULK_MOVEMENT_ID = row1.BULK_MOVEMENT_ID;			row2.TO_DESTINATION_SUPPLIER_NUMBER = row1.TO_DESTINATION_SUPPLIER_NUMBER;			row2.TO_TRACTOR_NUMBER = row1.TO_TRACTOR_NUMBER;			row2.FOLIO_NUMBER = row1.FOLIO_NUMBER;			row2.FROM_TRACTOR_CARRIER_NUMBER = row1.FROM_TRACTOR_CARRIER_NUMBER;			row2.TO_DESTINATION_CUSTOMER_NUMBER = row1.TO_DESTINATION_CUSTOMER_NUMBER;			row2.FROM_TRACTOR_NUMBER = row1.FROM_TRACTOR_NUMBER;			row2.TO_DESTINATION_NUMBER = row1.TO_DESTINATION_NUMBER;			row2.TO_DRIVER_NUMBER = row1.TO_DRIVER_NUMBER;			row2.FROM_DRIVER_CARRIER_NUMBER = row1.FROM_DRIVER_CARRIER_NUMBER;			row2.FROM_SUPPLIER_NUMBER = row1.FROM_SUPPLIER_NUMBER;			row2.FSHOST_SU_SUPPLIER_NUMBER = row1.FSHOST_SU_SUPPLIER_NUMBER;			row2.FROM_DRIVER_NUMBER = row1.FROM_DRIVER_NUMBER;			row2.TO_SUPPLIER_NUMBER = row1.TO_SUPPLIER_NUMBER;			row2.FROM_CARRIER_NUMBER = row1.FROM_CARRIER_NUMBER;			row2.FSHOST_EX_THOST_EXCH_NUMBER = row1.FSHOST_EX_THOST_EXCH_NUMBER;			row2.TRANSACTION_SUBTYPE = row1.TRANSACTION_SUBTYPE;			row2.TYPE = row1.TYPE;			row2.TSHOST_SU_SUPPLIER_NUMBER = row1.TSHOST_SU_SUPPLIER_NUMBER;			row2.TSHOST_EX_EHOST_THRU_NUMBER = row1.TSHOST_EX_EHOST_THRU_NUMBER;			row2.MOVEMENT_NUMBER = row1.MOVEMENT_NUMBER;			row2.REVISION_NUMBER = row1.REVISION_NUMBER;			row2.REVISED = row1.REVISED;			row2.REFERENCE_NUMBER = row1.REFERENCE_NUMBER;			row2.STATUS = row1.STATUS;			row2.STATUS_DATE = row1.STATUS_DATE;			row2.REMARKS = row1.REMARKS;			row2.MOVEMENT_DATE = row1.MOVEMENT_DATE;			row2.VESSEL = row1.VESSEL;			row2.DOC_OPERATOR_CODE = row1.DOC_OPERATOR_CODE;			row2.BATCH_VOYAGE_NUMBER = row1.BATCH_VOYAGE_NUMBER;			row2.LAST_USER_NAME = row1.LAST_USER_NAME;			row2.LAST_MODIFIED = row1.LAST_MODIFIED;			row2.HOST_PROCESSED = row1.HOST_PROCESSED;			row2.AIC_STATUS = row1.AIC_STATUS;			row2.FLAG_APPLY_SUPPLIER_INV = row1.FLAG_APPLY_SUPPLIER_INV;			row2.FLAG_APPLY_SUPPLIER_TANK_INV = row1.FLAG_APPLY_SUPPLIER_TANK_INV;			row2.FLAG_APPLY_PARCEL_INV = row1.FLAG_APPLY_PARCEL_INV;			row2.FLAG_APPLY_TANK_INV = row1.FLAG_APPLY_TANK_INV;			row2.CANCELLED_FROM_CBS = row1.CANCELLED_FROM_CBS;			row2.HOST_REF_ID = row1.HOST_REF_ID;			row2.PENDING_PRINT_COUNT = row1.PENDING_PRINT_COUNT;			row2.GAIN_LOSS_XCTN = row1.GAIN_LOSS_XCTN;			row2.PENDING_REQUEST_COUNT = row1.PENDING_REQUEST_COUNT;			row2.ORIG_BULK_MOVEMENT_ID = row1.ORIG_BULK_MOVEMENT_ID;			row2.PREV_BULK_MOVEMENT_ID = row1.PREV_BULK_MOVEMENT_ID;			row2.AGENT = row1.AGENT;			row2.SURVEYOR_1 = row1.SURVEYOR_1;			row2.SURVEYOR_2 = row1.SURVEYOR_2;			row2.TO_CARRIER_NUMBER = row1.TO_CARRIER_NUMBER;			row2.TO_DRIVER_CARRIER_NUMBER = row1.TO_DRIVER_CARRIER_NUMBER;			row2.TO_TRACTOR_CARRIER_NUMBER = row1.TO_TRACTOR_CARRIER_NUMBER;					
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
								
	                        		    	Object exprKeyValue_row3__BULK_MOVEMENT_ID = row2.BULK_MOVEMENT_ID ;
	                        		    	if(exprKeyValue_row3__BULK_MOVEMENT_ID == null) {
	                        		    		hasCasePrimitiveKeyWithNull_tMap_1 = true;
	                        		    	} else {
                        		    			row3HashKey.BULK_MOVEMENT_ID = (int)(Integer) exprKeyValue_row3__BULK_MOVEMENT_ID;
                        		    		}
                        		    		

								
		                        	row3HashKey.hashCodeDirty = true;
                        		
	  					
	  							
	
		  							if(!hasCasePrimitiveKeyWithNull_tMap_1) { // G_TM_M_091
		  							
			  					
			  					
			  					
	  					
		  							tHash_Lookup_row3.lookup( row3HashKey );

	  							

	  							

			  						} // G_TM_M_091
			  						
			  					

 								
		  				
	  								
						
									
  									  		
 								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_row3 != null && tHash_Lookup_row3.getCount(row3HashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row3' and it contains more one result from keys :  row3.BULK_MOVEMENT_ID = '" + row3HashKey.BULK_MOVEMENT_ID + "'");
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
Var.PK_BULK_MOVEMENT = Numeric.sequence("s7",1,1) ;// ###############################
        // ###############################
        // # Output tables

out2 = null;

boolean rejected_tMap_1 = true;
// ###### START REJECTS ##### 

// # Output reject table : 'out2'
// # Filter conditions 
if( rejected_tMap_1 ) {
out2_tmp.PK_BULK_MOVEMENT = Var.PK_BULK_MOVEMENT ;
out2_tmp.BULK_MOVEMENT_ID = row2.BULK_MOVEMENT_ID ;
out2_tmp.FOLIO_NUMBER = row2.FOLIO_NUMBER ;
out2_tmp.DATE = row2.FOLIO_NUMBER != null ? TalendDate.parseDate("yyyyMMdd", row2.FOLIO_NUMBER) : null;
out2_tmp.FROM_SUPPLIER_NUMBER = row2.FROM_SUPPLIER_NUMBER ;
out2_tmp.TYPE = row2.TYPE ;
out2_tmp.MOVEMENT_NUMBER = row2.MOVEMENT_NUMBER ;
out2_tmp.REVISION_NUMBER = row2.REVISION_NUMBER ;
out2_tmp.REVISED = row2.REVISED ;
out2_tmp.STATUS = row2.STATUS ;
out2_tmp.STATUS_DATE = row2.STATUS_DATE ;
out2_tmp.REMARKS = row2.REMARKS ;
out2_tmp.MOVEMENT_DATE = row2.MOVEMENT_DATE ;
out2_tmp.LAST_USER_NAME = row2.LAST_USER_NAME ;
out2_tmp.LAST_MODIFIED = row2.LAST_MODIFIED ;
out2_tmp.AIC_STATUS = row2.AIC_STATUS ;
out2_tmp.ORIG_BULK_MOVEMENT_ID = row2.ORIG_BULK_MOVEMENT_ID ;
out2_tmp.PREV_BULK_MOVEMENT_ID = row2.PREV_BULK_MOVEMENT_ID ;
out2 = out2_tmp;
} // closing filter/reject
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
// Start of branch "out2"
if(out2 != null) { 



	
	/**
	 * [tDBOutput_1 main ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"out2"
						
						);
					}
					



        whetherReject_tDBOutput_1 = false;


                    if(out2.PK_BULK_MOVEMENT == null) {
pstmt_tDBOutput_1.setNull(1, java.sql.Types.INTEGER);
} else {pstmt_tDBOutput_1.setInt(1, out2.PK_BULK_MOVEMENT);
}

            int checkCount_tDBOutput_1 = -1;
            try (java.sql.ResultSet rs_tDBOutput_1 = pstmt_tDBOutput_1.executeQuery()) {
                while(rs_tDBOutput_1.next()) {
                    checkCount_tDBOutput_1 = rs_tDBOutput_1.getInt(1);
                }
            }
            if(checkCount_tDBOutput_1 > 0) {
                        pstmtUpdate_tDBOutput_1.setInt(1, out2.BULK_MOVEMENT_ID);

                        if(out2.FOLIO_NUMBER == null) {
pstmtUpdate_tDBOutput_1.setNull(2, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(2, out2.FOLIO_NUMBER);
}

                        if(out2.DATE != null) {
pstmtUpdate_tDBOutput_1.setTimestamp(3, new java.sql.Timestamp(out2.DATE.getTime()));
} else {
pstmtUpdate_tDBOutput_1.setNull(3, java.sql.Types.TIMESTAMP);
}

                        if(out2.FROM_SUPPLIER_NUMBER == null) {
pstmtUpdate_tDBOutput_1.setNull(4, java.sql.Types.INTEGER);
} else {pstmtUpdate_tDBOutput_1.setInt(4, out2.FROM_SUPPLIER_NUMBER);
}

                        pstmtUpdate_tDBOutput_1.setInt(5, out2.TYPE);

                        pstmtUpdate_tDBOutput_1.setInt(6, out2.MOVEMENT_NUMBER);

                        pstmtUpdate_tDBOutput_1.setInt(7, out2.REVISION_NUMBER);

                        pstmtUpdate_tDBOutput_1.setInt(8, out2.REVISED);

                        pstmtUpdate_tDBOutput_1.setInt(9, out2.STATUS);

                        if(out2.STATUS_DATE != null) {
pstmtUpdate_tDBOutput_1.setTimestamp(10, new java.sql.Timestamp(out2.STATUS_DATE.getTime()));
} else {
pstmtUpdate_tDBOutput_1.setNull(10, java.sql.Types.TIMESTAMP);
}

                        if(out2.REMARKS == null) {
pstmtUpdate_tDBOutput_1.setNull(11, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(11, out2.REMARKS);
}

                        if(out2.MOVEMENT_DATE != null) {
pstmtUpdate_tDBOutput_1.setTimestamp(12, new java.sql.Timestamp(out2.MOVEMENT_DATE.getTime()));
} else {
pstmtUpdate_tDBOutput_1.setNull(12, java.sql.Types.TIMESTAMP);
}

                        if(out2.LAST_USER_NAME == null) {
pstmtUpdate_tDBOutput_1.setNull(13, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(13, out2.LAST_USER_NAME);
}

                        if(out2.LAST_MODIFIED != null) {
pstmtUpdate_tDBOutput_1.setTimestamp(14, new java.sql.Timestamp(out2.LAST_MODIFIED.getTime()));
} else {
pstmtUpdate_tDBOutput_1.setNull(14, java.sql.Types.TIMESTAMP);
}

                        pstmtUpdate_tDBOutput_1.setInt(15, out2.AIC_STATUS);

                        if(out2.ORIG_BULK_MOVEMENT_ID == null) {
pstmtUpdate_tDBOutput_1.setNull(16, java.sql.Types.INTEGER);
} else {pstmtUpdate_tDBOutput_1.setInt(16, out2.ORIG_BULK_MOVEMENT_ID);
}

                        if(out2.PREV_BULK_MOVEMENT_ID == null) {
pstmtUpdate_tDBOutput_1.setNull(17, java.sql.Types.INTEGER);
} else {pstmtUpdate_tDBOutput_1.setInt(17, out2.PREV_BULK_MOVEMENT_ID);
}


	                    

                        if(out2.PK_BULK_MOVEMENT == null) {
pstmtUpdate_tDBOutput_1.setNull(18 + count_tDBOutput_1, java.sql.Types.INTEGER);
} else {pstmtUpdate_tDBOutput_1.setInt(18 + count_tDBOutput_1, out2.PK_BULK_MOVEMENT);
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
                        if(out2.PK_BULK_MOVEMENT == null) {
pstmtInsert_tDBOutput_1.setNull(1, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_1.setInt(1, out2.PK_BULK_MOVEMENT);
}

                        pstmtInsert_tDBOutput_1.setInt(2, out2.BULK_MOVEMENT_ID);

                        if(out2.FOLIO_NUMBER == null) {
pstmtInsert_tDBOutput_1.setNull(3, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(3, out2.FOLIO_NUMBER);
}

                        if(out2.DATE != null) {
pstmtInsert_tDBOutput_1.setTimestamp(4, new java.sql.Timestamp(out2.DATE.getTime()));
} else {
pstmtInsert_tDBOutput_1.setNull(4, java.sql.Types.TIMESTAMP);
}

                        if(out2.FROM_SUPPLIER_NUMBER == null) {
pstmtInsert_tDBOutput_1.setNull(5, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_1.setInt(5, out2.FROM_SUPPLIER_NUMBER);
}

                        pstmtInsert_tDBOutput_1.setInt(6, out2.TYPE);

                        pstmtInsert_tDBOutput_1.setInt(7, out2.MOVEMENT_NUMBER);

                        pstmtInsert_tDBOutput_1.setInt(8, out2.REVISION_NUMBER);

                        pstmtInsert_tDBOutput_1.setInt(9, out2.REVISED);

                        pstmtInsert_tDBOutput_1.setInt(10, out2.STATUS);

                        if(out2.STATUS_DATE != null) {
pstmtInsert_tDBOutput_1.setTimestamp(11, new java.sql.Timestamp(out2.STATUS_DATE.getTime()));
} else {
pstmtInsert_tDBOutput_1.setNull(11, java.sql.Types.TIMESTAMP);
}

                        if(out2.REMARKS == null) {
pstmtInsert_tDBOutput_1.setNull(12, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(12, out2.REMARKS);
}

                        if(out2.MOVEMENT_DATE != null) {
pstmtInsert_tDBOutput_1.setTimestamp(13, new java.sql.Timestamp(out2.MOVEMENT_DATE.getTime()));
} else {
pstmtInsert_tDBOutput_1.setNull(13, java.sql.Types.TIMESTAMP);
}

                        if(out2.LAST_USER_NAME == null) {
pstmtInsert_tDBOutput_1.setNull(14, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(14, out2.LAST_USER_NAME);
}

                        if(out2.LAST_MODIFIED != null) {
pstmtInsert_tDBOutput_1.setTimestamp(15, new java.sql.Timestamp(out2.LAST_MODIFIED.getTime()));
} else {
pstmtInsert_tDBOutput_1.setNull(15, java.sql.Types.TIMESTAMP);
}

                        pstmtInsert_tDBOutput_1.setInt(16, out2.AIC_STATUS);

                        if(out2.ORIG_BULK_MOVEMENT_ID == null) {
pstmtInsert_tDBOutput_1.setNull(17, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_1.setInt(17, out2.ORIG_BULK_MOVEMENT_ID);
}

                        if(out2.PREV_BULK_MOVEMENT_ID == null) {
pstmtInsert_tDBOutput_1.setNull(18, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_1.setInt(18, out2.PREV_BULK_MOVEMENT_ID);
}

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

} // End of branch "out2"




	
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
			  		runStat.updateStat(resourceMap,iterateId,2,0,"out2");
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
    final static byte[] commonByteArrayLock_PGS_STAGE_DIM_BULK_MOVEMENT = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_DIM_BULK_MOVEMENT = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public int PK_BULK_MOVEMENT;

				public int getPK_BULK_MOVEMENT () {
					return this.PK_BULK_MOVEMENT;
				}
				
			    public int BULK_MOVEMENT_ID;

				public int getBULK_MOVEMENT_ID () {
					return this.BULK_MOVEMENT_ID;
				}
				
			    public String FOLIO_NUMBER;

				public String getFOLIO_NUMBER () {
					return this.FOLIO_NUMBER;
				}
				
			    public java.util.Date DATE;

				public java.util.Date getDATE () {
					return this.DATE;
				}
				
			    public Integer FROM_SUPPLIER_NUMBER;

				public Integer getFROM_SUPPLIER_NUMBER () {
					return this.FROM_SUPPLIER_NUMBER;
				}
				
			    public int TYPE;

				public int getTYPE () {
					return this.TYPE;
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
				
			    public String REMARKS;

				public String getREMARKS () {
					return this.REMARKS;
				}
				
			    public java.util.Date MOVEMENT_DATE;

				public java.util.Date getMOVEMENT_DATE () {
					return this.MOVEMENT_DATE;
				}
				
			    public String LAST_USER_NAME;

				public String getLAST_USER_NAME () {
					return this.LAST_USER_NAME;
				}
				
			    public java.util.Date LAST_MODIFIED;

				public java.util.Date getLAST_MODIFIED () {
					return this.LAST_MODIFIED;
				}
				
			    public int AIC_STATUS;

				public int getAIC_STATUS () {
					return this.AIC_STATUS;
				}
				
			    public Integer ORIG_BULK_MOVEMENT_ID;

				public Integer getORIG_BULK_MOVEMENT_ID () {
					return this.ORIG_BULK_MOVEMENT_ID;
				}
				
			    public Integer PREV_BULK_MOVEMENT_ID;

				public Integer getPREV_BULK_MOVEMENT_ID () {
					return this.PREV_BULK_MOVEMENT_ID;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
							result = prime * result + (int) this.BULK_MOVEMENT_ID;
						
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
		
						if (this.BULK_MOVEMENT_ID != other.BULK_MOVEMENT_ID)
							return false;
					

		return true;
    }

	public void copyDataTo(row3Struct other) {

		other.PK_BULK_MOVEMENT = this.PK_BULK_MOVEMENT;
	            other.BULK_MOVEMENT_ID = this.BULK_MOVEMENT_ID;
	            other.FOLIO_NUMBER = this.FOLIO_NUMBER;
	            other.DATE = this.DATE;
	            other.FROM_SUPPLIER_NUMBER = this.FROM_SUPPLIER_NUMBER;
	            other.TYPE = this.TYPE;
	            other.MOVEMENT_NUMBER = this.MOVEMENT_NUMBER;
	            other.REVISION_NUMBER = this.REVISION_NUMBER;
	            other.REVISED = this.REVISED;
	            other.STATUS = this.STATUS;
	            other.STATUS_DATE = this.STATUS_DATE;
	            other.REMARKS = this.REMARKS;
	            other.MOVEMENT_DATE = this.MOVEMENT_DATE;
	            other.LAST_USER_NAME = this.LAST_USER_NAME;
	            other.LAST_MODIFIED = this.LAST_MODIFIED;
	            other.AIC_STATUS = this.AIC_STATUS;
	            other.ORIG_BULK_MOVEMENT_ID = this.ORIG_BULK_MOVEMENT_ID;
	            other.PREV_BULK_MOVEMENT_ID = this.PREV_BULK_MOVEMENT_ID;
	            
	}

	public void copyKeysDataTo(row3Struct other) {

		other.BULK_MOVEMENT_ID = this.BULK_MOVEMENT_ID;
	            	
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

    public void readKeysData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_BULK_MOVEMENT) {

        	try {

        		int length = 0;
		
			        this.BULK_MOVEMENT_ID = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_BULK_MOVEMENT) {

        	try {

        		int length = 0;
		
			        this.BULK_MOVEMENT_ID = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.BULK_MOVEMENT_ID);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.BULK_MOVEMENT_ID);
					
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
		
			            this.PK_BULK_MOVEMENT = dis.readInt();
					
						this.FOLIO_NUMBER = readString(dis,ois);
					
						this.DATE = readDate(dis,ois);
					
						this.FROM_SUPPLIER_NUMBER = readInteger(dis,ois);
					
			            this.TYPE = dis.readInt();
					
			            this.MOVEMENT_NUMBER = dis.readInt();
					
			            this.REVISION_NUMBER = dis.readInt();
					
			            this.REVISED = dis.readInt();
					
			            this.STATUS = dis.readInt();
					
						this.STATUS_DATE = readDate(dis,ois);
					
						this.REMARKS = readString(dis,ois);
					
						this.MOVEMENT_DATE = readDate(dis,ois);
					
						this.LAST_USER_NAME = readString(dis,ois);
					
						this.LAST_MODIFIED = readDate(dis,ois);
					
			            this.AIC_STATUS = dis.readInt();
					
						this.ORIG_BULK_MOVEMENT_ID = readInteger(dis,ois);
					
						this.PREV_BULK_MOVEMENT_ID = readInteger(dis,ois);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
			            this.PK_BULK_MOVEMENT = objectIn.readInt();
					
						this.FOLIO_NUMBER = readString(dis,objectIn);
					
						this.DATE = readDate(dis,objectIn);
					
						this.FROM_SUPPLIER_NUMBER = readInteger(dis,objectIn);
					
			            this.TYPE = objectIn.readInt();
					
			            this.MOVEMENT_NUMBER = objectIn.readInt();
					
			            this.REVISION_NUMBER = objectIn.readInt();
					
			            this.REVISED = objectIn.readInt();
					
			            this.STATUS = objectIn.readInt();
					
						this.STATUS_DATE = readDate(dis,objectIn);
					
						this.REMARKS = readString(dis,objectIn);
					
						this.MOVEMENT_DATE = readDate(dis,objectIn);
					
						this.LAST_USER_NAME = readString(dis,objectIn);
					
						this.LAST_MODIFIED = readDate(dis,objectIn);
					
			            this.AIC_STATUS = objectIn.readInt();
					
						this.ORIG_BULK_MOVEMENT_ID = readInteger(dis,objectIn);
					
						this.PREV_BULK_MOVEMENT_ID = readInteger(dis,objectIn);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
		            	dos.writeInt(this.PK_BULK_MOVEMENT);
					
						writeString(this.FOLIO_NUMBER, dos, oos);
					
						writeDate(this.DATE, dos, oos);
					
					writeInteger(this.FROM_SUPPLIER_NUMBER, dos, oos);
					
		            	dos.writeInt(this.TYPE);
					
		            	dos.writeInt(this.MOVEMENT_NUMBER);
					
		            	dos.writeInt(this.REVISION_NUMBER);
					
		            	dos.writeInt(this.REVISED);
					
		            	dos.writeInt(this.STATUS);
					
						writeDate(this.STATUS_DATE, dos, oos);
					
						writeString(this.REMARKS, dos, oos);
					
						writeDate(this.MOVEMENT_DATE, dos, oos);
					
						writeString(this.LAST_USER_NAME, dos, oos);
					
						writeDate(this.LAST_MODIFIED, dos, oos);
					
		            	dos.writeInt(this.AIC_STATUS);
					
					writeInteger(this.ORIG_BULK_MOVEMENT_ID, dos, oos);
					
					writeInteger(this.PREV_BULK_MOVEMENT_ID, dos, oos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
					objectOut.writeInt(this.PK_BULK_MOVEMENT);
					
						writeString(this.FOLIO_NUMBER, dos, objectOut);
					
						writeDate(this.DATE, dos, objectOut);
					
					writeInteger(this.FROM_SUPPLIER_NUMBER, dos, objectOut);
					
					objectOut.writeInt(this.TYPE);
					
					objectOut.writeInt(this.MOVEMENT_NUMBER);
					
					objectOut.writeInt(this.REVISION_NUMBER);
					
					objectOut.writeInt(this.REVISED);
					
					objectOut.writeInt(this.STATUS);
					
						writeDate(this.STATUS_DATE, dos, objectOut);
					
						writeString(this.REMARKS, dos, objectOut);
					
						writeDate(this.MOVEMENT_DATE, dos, objectOut);
					
						writeString(this.LAST_USER_NAME, dos, objectOut);
					
						writeDate(this.LAST_MODIFIED, dos, objectOut);
					
					objectOut.writeInt(this.AIC_STATUS);
					
					writeInteger(this.ORIG_BULK_MOVEMENT_ID, dos, objectOut);
					
					writeInteger(this.PREV_BULK_MOVEMENT_ID, dos, objectOut);
					
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
		sb.append("PK_BULK_MOVEMENT="+String.valueOf(PK_BULK_MOVEMENT));
		sb.append(",BULK_MOVEMENT_ID="+String.valueOf(BULK_MOVEMENT_ID));
		sb.append(",FOLIO_NUMBER="+FOLIO_NUMBER);
		sb.append(",DATE="+String.valueOf(DATE));
		sb.append(",FROM_SUPPLIER_NUMBER="+String.valueOf(FROM_SUPPLIER_NUMBER));
		sb.append(",TYPE="+String.valueOf(TYPE));
		sb.append(",MOVEMENT_NUMBER="+String.valueOf(MOVEMENT_NUMBER));
		sb.append(",REVISION_NUMBER="+String.valueOf(REVISION_NUMBER));
		sb.append(",REVISED="+String.valueOf(REVISED));
		sb.append(",STATUS="+String.valueOf(STATUS));
		sb.append(",STATUS_DATE="+String.valueOf(STATUS_DATE));
		sb.append(",REMARKS="+REMARKS);
		sb.append(",MOVEMENT_DATE="+String.valueOf(MOVEMENT_DATE));
		sb.append(",LAST_USER_NAME="+LAST_USER_NAME);
		sb.append(",LAST_MODIFIED="+String.valueOf(LAST_MODIFIED));
		sb.append(",AIC_STATUS="+String.valueOf(AIC_STATUS));
		sb.append(",ORIG_BULK_MOVEMENT_ID="+String.valueOf(ORIG_BULK_MOVEMENT_ID));
		sb.append(",PREV_BULK_MOVEMENT_ID="+String.valueOf(PREV_BULK_MOVEMENT_ID));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row3Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.BULK_MOVEMENT_ID, other.BULK_MOVEMENT_ID);
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
			   		// linked node: tMap_1 - inputs:(row2,row3) outputs:(out2)
			   
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
				
				 
	final String decryptedPassword_tDBInput_2 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:NEiCIrOaKzeL6gbwsLJPpDsHjooigBICm0MQW3FolKjVit5Cw2w=");
				
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

		    String dbquery_tDBInput_2 = "SELECT dbo.DIM_BULK_MOVEMENT.PK_BULK_MOVEMENT,\n		dbo.DIM_BULK_MOVEMENT.BULK_MOVEMENT_ID,\n		dbo.DIM_BULK_MOVEMENT.FOLIO_"
+"NUMBER,\n		dbo.DIM_BULK_MOVEMENT.DATE,\n		dbo.DIM_BULK_MOVEMENT.FROM_SUPPLIER_NUMBER,\n		dbo.DIM_BULK_MOVEMENT.TYPE,\n		dbo."
+"DIM_BULK_MOVEMENT.MOVEMENT_NUMBER,\n		dbo.DIM_BULK_MOVEMENT.REVISION_NUMBER,\n		dbo.DIM_BULK_MOVEMENT.REVISED,\n		dbo.DIM_B"
+"ULK_MOVEMENT.STATUS,\n		dbo.DIM_BULK_MOVEMENT.STATUS_DATE,\n		dbo.DIM_BULK_MOVEMENT.REMARKS,\n		dbo.DIM_BULK_MOVEMENT.MOVEM"
+"ENT_DATE,\n		dbo.DIM_BULK_MOVEMENT.LAST_USER_NAME,\n		dbo.DIM_BULK_MOVEMENT.LAST_MODIFIED,\n		dbo.DIM_BULK_MOVEMENT.AIC_STA"
+"TUS,\n		dbo.DIM_BULK_MOVEMENT.ORIG_BULK_MOVEMENT_ID,\n		dbo.DIM_BULK_MOVEMENT.PREV_BULK_MOVEMENT_ID\nFROM	dbo.DIM_BULK_MOVE"
+"MENT";
		    

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
								row3.PK_BULK_MOVEMENT = 0;
							} else {
		                          
            row3.PK_BULK_MOVEMENT = rs_tDBInput_2.getInt(1);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 2) {
								row3.BULK_MOVEMENT_ID = 0;
							} else {
		                          
            row3.BULK_MOVEMENT_ID = rs_tDBInput_2.getInt(2);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 3) {
								row3.FOLIO_NUMBER = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(3);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(3).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.FOLIO_NUMBER = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row3.FOLIO_NUMBER = tmpContent_tDBInput_2;
                }
            } else {
                row3.FOLIO_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 4) {
								row3.DATE = null;
							} else {
										
			row3.DATE = mssqlGTU_tDBInput_2.getDate(rsmd_tDBInput_2, rs_tDBInput_2, 4);
			
		                    }
							if(colQtyInRs_tDBInput_2 < 5) {
								row3.FROM_SUPPLIER_NUMBER = null;
							} else {
		                          
            row3.FROM_SUPPLIER_NUMBER = rs_tDBInput_2.getInt(5);
            if(rs_tDBInput_2.wasNull()){
                    row3.FROM_SUPPLIER_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 6) {
								row3.TYPE = 0;
							} else {
		                          
            row3.TYPE = rs_tDBInput_2.getInt(6);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 7) {
								row3.MOVEMENT_NUMBER = 0;
							} else {
		                          
            row3.MOVEMENT_NUMBER = rs_tDBInput_2.getInt(7);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 8) {
								row3.REVISION_NUMBER = 0;
							} else {
		                          
            row3.REVISION_NUMBER = rs_tDBInput_2.getInt(8);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 9) {
								row3.REVISED = 0;
							} else {
		                          
            row3.REVISED = rs_tDBInput_2.getInt(9);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 10) {
								row3.STATUS = 0;
							} else {
		                          
            row3.STATUS = rs_tDBInput_2.getInt(10);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 11) {
								row3.STATUS_DATE = null;
							} else {
										
			row3.STATUS_DATE = mssqlGTU_tDBInput_2.getDate(rsmd_tDBInput_2, rs_tDBInput_2, 11);
			
		                    }
							if(colQtyInRs_tDBInput_2 < 12) {
								row3.REMARKS = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(12);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(12).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.REMARKS = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row3.REMARKS = tmpContent_tDBInput_2;
                }
            } else {
                row3.REMARKS = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 13) {
								row3.MOVEMENT_DATE = null;
							} else {
										
			row3.MOVEMENT_DATE = mssqlGTU_tDBInput_2.getDate(rsmd_tDBInput_2, rs_tDBInput_2, 13);
			
		                    }
							if(colQtyInRs_tDBInput_2 < 14) {
								row3.LAST_USER_NAME = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(14);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(14).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.LAST_USER_NAME = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row3.LAST_USER_NAME = tmpContent_tDBInput_2;
                }
            } else {
                row3.LAST_USER_NAME = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 15) {
								row3.LAST_MODIFIED = null;
							} else {
										
			row3.LAST_MODIFIED = mssqlGTU_tDBInput_2.getDate(rsmd_tDBInput_2, rs_tDBInput_2, 15);
			
		                    }
							if(colQtyInRs_tDBInput_2 < 16) {
								row3.AIC_STATUS = 0;
							} else {
		                          
            row3.AIC_STATUS = rs_tDBInput_2.getInt(16);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 17) {
								row3.ORIG_BULK_MOVEMENT_ID = null;
							} else {
		                          
            row3.ORIG_BULK_MOVEMENT_ID = rs_tDBInput_2.getInt(17);
            if(rs_tDBInput_2.wasNull()){
                    row3.ORIG_BULK_MOVEMENT_ID = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 18) {
								row3.PREV_BULK_MOVEMENT_ID = null;
							} else {
		                          
            row3.PREV_BULK_MOVEMENT_ID = rs_tDBInput_2.getInt(18);
            if(rs_tDBInput_2.wasNull()){
                    row3.PREV_BULK_MOVEMENT_ID = null;
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
		   	   	   
				
				row3_HashRow.PK_BULK_MOVEMENT = row3.PK_BULK_MOVEMENT;
				
				row3_HashRow.BULK_MOVEMENT_ID = row3.BULK_MOVEMENT_ID;
				
				row3_HashRow.FOLIO_NUMBER = row3.FOLIO_NUMBER;
				
				row3_HashRow.DATE = row3.DATE;
				
				row3_HashRow.FROM_SUPPLIER_NUMBER = row3.FROM_SUPPLIER_NUMBER;
				
				row3_HashRow.TYPE = row3.TYPE;
				
				row3_HashRow.MOVEMENT_NUMBER = row3.MOVEMENT_NUMBER;
				
				row3_HashRow.REVISION_NUMBER = row3.REVISION_NUMBER;
				
				row3_HashRow.REVISED = row3.REVISED;
				
				row3_HashRow.STATUS = row3.STATUS;
				
				row3_HashRow.STATUS_DATE = row3.STATUS_DATE;
				
				row3_HashRow.REMARKS = row3.REMARKS;
				
				row3_HashRow.MOVEMENT_DATE = row3.MOVEMENT_DATE;
				
				row3_HashRow.LAST_USER_NAME = row3.LAST_USER_NAME;
				
				row3_HashRow.LAST_MODIFIED = row3.LAST_MODIFIED;
				
				row3_HashRow.AIC_STATUS = row3.AIC_STATUS;
				
				row3_HashRow.ORIG_BULK_MOVEMENT_ID = row3.ORIG_BULK_MOVEMENT_ID;
				
				row3_HashRow.PREV_BULK_MOVEMENT_ID = row3.PREV_BULK_MOVEMENT_ID;
				
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
        final DIM_BULK_MOVEMENT DIM_BULK_MOVEMENTClass = new DIM_BULK_MOVEMENT();

        int exitCode = DIM_BULK_MOVEMENTClass.runJobInTOS(args);

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
            java.io.InputStream inContext = DIM_BULK_MOVEMENT.class.getClassLoader().getResourceAsStream("pgs_stage/dim_bulk_movement_0_1/contexts/" + contextStr + ".properties");
            if (inContext == null) {
                inContext = DIM_BULK_MOVEMENT.class.getClassLoader().getResourceAsStream("config/contexts/" + contextStr + ".properties");
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
            System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : DIM_BULK_MOVEMENT");
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
 *     237247 characters generated by Talend Open Studio for Data Integration 
 *     on the 3 août 2024 à 14:42:25 GMT+01:00
 ************************************************************************************************/