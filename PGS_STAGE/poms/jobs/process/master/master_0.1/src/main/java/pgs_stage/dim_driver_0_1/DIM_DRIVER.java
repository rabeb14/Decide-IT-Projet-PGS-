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


package pgs_stage.dim_driver_0_1;

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
 * Job: DIM_DRIVER Purpose: <br>
 * Description:  <br>
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status 
 */
public class DIM_DRIVER implements TalendJob {

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
	private final String jobName = "DIM_DRIVER";
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
				DIM_DRIVER.this.exception = e;
			}
		}
		if (!(e instanceof TalendException)) {
		try {
			for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
				if (m.getName().compareTo(currentComponent + "_error") == 0) {
					m.invoke(DIM_DRIVER.this, new Object[] { e , currentComponent, globalMap});
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
    final static byte[] commonByteArrayLock_PGS_STAGE_DIM_DRIVER = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_DIM_DRIVER = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public Integer PK_DRIVER;

				public Integer getPK_DRIVER () {
					return this.PK_DRIVER;
				}
				
			    public Integer RT_LAST_USED_CARRIER;

				public Integer getRT_LAST_USED_CARRIER () {
					return this.RT_LAST_USED_CARRIER;
				}
				
			    public int CARRIER_NUMBER;

				public int getCARRIER_NUMBER () {
					return this.CARRIER_NUMBER;
				}
				
			    public int DRIVER_NUMBER;

				public int getDRIVER_NUMBER () {
					return this.DRIVER_NUMBER;
				}
				
			    public String NAME;

				public String getNAME () {
					return this.NAME;
				}
				
			    public String RT_LAST_USED_TRAILER;

				public String getRT_LAST_USED_TRAILER () {
					return this.RT_LAST_USED_TRAILER;
				}
				
			    public Integer RT_LAST_ORDER_ID;

				public Integer getRT_LAST_ORDER_ID () {
					return this.RT_LAST_ORDER_ID;
				}
				
			    public java.util.Date LAST_MODIFIED;

				public java.util.Date getLAST_MODIFIED () {
					return this.LAST_MODIFIED;
				}
				
			    public Integer RT_HISTORICAL_ORDER_ID;

				public Integer getRT_HISTORICAL_ORDER_ID () {
					return this.RT_HISTORICAL_ORDER_ID;
				}
				
			    public Integer RT_CURRENT_VISIT_ID;

				public Integer getRT_CURRENT_VISIT_ID () {
					return this.RT_CURRENT_VISIT_ID;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.PK_DRIVER == null) ? 0 : this.PK_DRIVER.hashCode());
					
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
		
						if (this.PK_DRIVER == null) {
							if (other.PK_DRIVER != null)
								return false;
						
						} else if (!this.PK_DRIVER.equals(other.PK_DRIVER))
						
							return false;
					

		return true;
    }

	public void copyDataTo(out2Struct other) {

		other.PK_DRIVER = this.PK_DRIVER;
	            other.RT_LAST_USED_CARRIER = this.RT_LAST_USED_CARRIER;
	            other.CARRIER_NUMBER = this.CARRIER_NUMBER;
	            other.DRIVER_NUMBER = this.DRIVER_NUMBER;
	            other.NAME = this.NAME;
	            other.RT_LAST_USED_TRAILER = this.RT_LAST_USED_TRAILER;
	            other.RT_LAST_ORDER_ID = this.RT_LAST_ORDER_ID;
	            other.LAST_MODIFIED = this.LAST_MODIFIED;
	            other.RT_HISTORICAL_ORDER_ID = this.RT_HISTORICAL_ORDER_ID;
	            other.RT_CURRENT_VISIT_ID = this.RT_CURRENT_VISIT_ID;
	            
	}

	public void copyKeysDataTo(out2Struct other) {

		other.PK_DRIVER = this.PK_DRIVER;
	            	
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
			if(length > commonByteArray_PGS_STAGE_DIM_DRIVER.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_DRIVER.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_DRIVER = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_DRIVER = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PGS_STAGE_DIM_DRIVER, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_DRIVER, 0, length, utf8Charset);
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
			if(length > commonByteArray_PGS_STAGE_DIM_DRIVER.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_DRIVER.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_DRIVER = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_DRIVER = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PGS_STAGE_DIM_DRIVER, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_DRIVER, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_DRIVER) {

        	try {

        		int length = 0;
		
						this.PK_DRIVER = readInteger(dis);
					
						this.RT_LAST_USED_CARRIER = readInteger(dis);
					
			        this.CARRIER_NUMBER = dis.readInt();
					
			        this.DRIVER_NUMBER = dis.readInt();
					
					this.NAME = readString(dis);
					
					this.RT_LAST_USED_TRAILER = readString(dis);
					
						this.RT_LAST_ORDER_ID = readInteger(dis);
					
					this.LAST_MODIFIED = readDate(dis);
					
						this.RT_HISTORICAL_ORDER_ID = readInteger(dis);
					
						this.RT_CURRENT_VISIT_ID = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_DRIVER) {

        	try {

        		int length = 0;
		
						this.PK_DRIVER = readInteger(dis);
					
						this.RT_LAST_USED_CARRIER = readInteger(dis);
					
			        this.CARRIER_NUMBER = dis.readInt();
					
			        this.DRIVER_NUMBER = dis.readInt();
					
					this.NAME = readString(dis);
					
					this.RT_LAST_USED_TRAILER = readString(dis);
					
						this.RT_LAST_ORDER_ID = readInteger(dis);
					
					this.LAST_MODIFIED = readDate(dis);
					
						this.RT_HISTORICAL_ORDER_ID = readInteger(dis);
					
						this.RT_CURRENT_VISIT_ID = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// Integer
				
						writeInteger(this.PK_DRIVER,dos);
					
					// Integer
				
						writeInteger(this.RT_LAST_USED_CARRIER,dos);
					
					// int
				
		            	dos.writeInt(this.CARRIER_NUMBER);
					
					// int
				
		            	dos.writeInt(this.DRIVER_NUMBER);
					
					// String
				
						writeString(this.NAME,dos);
					
					// String
				
						writeString(this.RT_LAST_USED_TRAILER,dos);
					
					// Integer
				
						writeInteger(this.RT_LAST_ORDER_ID,dos);
					
					// java.util.Date
				
						writeDate(this.LAST_MODIFIED,dos);
					
					// Integer
				
						writeInteger(this.RT_HISTORICAL_ORDER_ID,dos);
					
					// Integer
				
						writeInteger(this.RT_CURRENT_VISIT_ID,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Integer
				
						writeInteger(this.PK_DRIVER,dos);
					
					// Integer
				
						writeInteger(this.RT_LAST_USED_CARRIER,dos);
					
					// int
				
		            	dos.writeInt(this.CARRIER_NUMBER);
					
					// int
				
		            	dos.writeInt(this.DRIVER_NUMBER);
					
					// String
				
						writeString(this.NAME,dos);
					
					// String
				
						writeString(this.RT_LAST_USED_TRAILER,dos);
					
					// Integer
				
						writeInteger(this.RT_LAST_ORDER_ID,dos);
					
					// java.util.Date
				
						writeDate(this.LAST_MODIFIED,dos);
					
					// Integer
				
						writeInteger(this.RT_HISTORICAL_ORDER_ID,dos);
					
					// Integer
				
						writeInteger(this.RT_CURRENT_VISIT_ID,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("PK_DRIVER="+String.valueOf(PK_DRIVER));
		sb.append(",RT_LAST_USED_CARRIER="+String.valueOf(RT_LAST_USED_CARRIER));
		sb.append(",CARRIER_NUMBER="+String.valueOf(CARRIER_NUMBER));
		sb.append(",DRIVER_NUMBER="+String.valueOf(DRIVER_NUMBER));
		sb.append(",NAME="+NAME);
		sb.append(",RT_LAST_USED_TRAILER="+RT_LAST_USED_TRAILER);
		sb.append(",RT_LAST_ORDER_ID="+String.valueOf(RT_LAST_ORDER_ID));
		sb.append(",LAST_MODIFIED="+String.valueOf(LAST_MODIFIED));
		sb.append(",RT_HISTORICAL_ORDER_ID="+String.valueOf(RT_HISTORICAL_ORDER_ID));
		sb.append(",RT_CURRENT_VISIT_ID="+String.valueOf(RT_CURRENT_VISIT_ID));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(out2Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.PK_DRIVER, other.PK_DRIVER);
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
    final static byte[] commonByteArrayLock_PGS_STAGE_DIM_DRIVER = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_DIM_DRIVER = new byte[0];

	
			    public Integer RT_LAST_USED_CARRIER;

				public Integer getRT_LAST_USED_CARRIER () {
					return this.RT_LAST_USED_CARRIER;
				}
				
			    public int CARRIER_NUMBER;

				public int getCARRIER_NUMBER () {
					return this.CARRIER_NUMBER;
				}
				
			    public int DRIVER_NUMBER;

				public int getDRIVER_NUMBER () {
					return this.DRIVER_NUMBER;
				}
				
			    public String NAME;

				public String getNAME () {
					return this.NAME;
				}
				
			    public String RT_LAST_USED_TRAILER;

				public String getRT_LAST_USED_TRAILER () {
					return this.RT_LAST_USED_TRAILER;
				}
				
			    public String INITIALS;

				public String getINITIALS () {
					return this.INITIALS;
				}
				
			    public int LOCKOUT_LOADING;

				public int getLOCKOUT_LOADING () {
					return this.LOCKOUT_LOADING;
				}
				
			    public String LICENSE_NUMBER;

				public String getLICENSE_NUMBER () {
					return this.LICENSE_NUMBER;
				}
				
			    public String LOCKOUT_LOADING_REASON;

				public String getLOCKOUT_LOADING_REASON () {
					return this.LOCKOUT_LOADING_REASON;
				}
				
			    public int LOCKOUT_ENTRY;

				public int getLOCKOUT_ENTRY () {
					return this.LOCKOUT_ENTRY;
				}
				
			    public String LOCKOUT_ENTRY_REASON;

				public String getLOCKOUT_ENTRY_REASON () {
					return this.LOCKOUT_ENTRY_REASON;
				}
				
			    public int MULTI_PRODUCT_LOADING;

				public int getMULTI_PRODUCT_LOADING () {
					return this.MULTI_PRODUCT_LOADING;
				}
				
			    public String BOL_COMMENT_1;

				public String getBOL_COMMENT_1 () {
					return this.BOL_COMMENT_1;
				}
				
			    public String BOL_COMMENT_2;

				public String getBOL_COMMENT_2 () {
					return this.BOL_COMMENT_2;
				}
				
			    public Integer RT_CURRENT_ORDER_ID;

				public Integer getRT_CURRENT_ORDER_ID () {
					return this.RT_CURRENT_ORDER_ID;
				}
				
			    public Integer RT_LAST_ORDER_ID;

				public Integer getRT_LAST_ORDER_ID () {
					return this.RT_LAST_ORDER_ID;
				}
				
			    public int FUEL_TRACTOR;

				public int getFUEL_TRACTOR () {
					return this.FUEL_TRACTOR;
				}
				
			    public int ENTER_TERMINAL;

				public int getENTER_TERMINAL () {
					return this.ENTER_TERMINAL;
				}
				
			    public Integer RT_BOL_ORDER_ID_1;

				public Integer getRT_BOL_ORDER_ID_1 () {
					return this.RT_BOL_ORDER_ID_1;
				}
				
			    public Integer RT_BOL_ORDER_ID_2;

				public Integer getRT_BOL_ORDER_ID_2 () {
					return this.RT_BOL_ORDER_ID_2;
				}
				
			    public int METER_PROVER;

				public int getMETER_PROVER () {
					return this.METER_PROVER;
				}
				
			    public Integer RT_BOL_ORDER_ID_3;

				public Integer getRT_BOL_ORDER_ID_3 () {
					return this.RT_BOL_ORDER_ID_3;
				}
				
			    public int METER_TOTALIZER;

				public int getMETER_TOTALIZER () {
					return this.METER_TOTALIZER;
				}
				
			    public Integer RT_BOL_ORDER_ID_4;

				public Integer getRT_BOL_ORDER_ID_4 () {
					return this.RT_BOL_ORDER_ID_4;
				}
				
			    public Integer RT_BOL_ORDER_ID_5;

				public Integer getRT_BOL_ORDER_ID_5 () {
					return this.RT_BOL_ORDER_ID_5;
				}
				
			    public Integer RT_BOL_ORDER_ID_6;

				public Integer getRT_BOL_ORDER_ID_6 () {
					return this.RT_BOL_ORDER_ID_6;
				}
				
			    public Integer RT_BOL_ORDER_ID_7;

				public Integer getRT_BOL_ORDER_ID_7 () {
					return this.RT_BOL_ORDER_ID_7;
				}
				
			    public Integer RT_BOL_ORDER_ID_8;

				public Integer getRT_BOL_ORDER_ID_8 () {
					return this.RT_BOL_ORDER_ID_8;
				}
				
			    public Integer RT_BOL_ORDER_ID_9;

				public Integer getRT_BOL_ORDER_ID_9 () {
					return this.RT_BOL_ORDER_ID_9;
				}
				
			    public int RT_CARDED_IN;

				public int getRT_CARDED_IN () {
					return this.RT_CARDED_IN;
				}
				
			    public String LAST_USER_NAME;

				public String getLAST_USER_NAME () {
					return this.LAST_USER_NAME;
				}
				
			    public Integer RT_LAST_USED_TRACTOR_CARRIER;

				public Integer getRT_LAST_USED_TRACTOR_CARRIER () {
					return this.RT_LAST_USED_TRACTOR_CARRIER;
				}
				
			    public java.util.Date LAST_MODIFIED;

				public java.util.Date getLAST_MODIFIED () {
					return this.LAST_MODIFIED;
				}
				
			    public Integer RT_LAST_USED_TRACTOR;

				public Integer getRT_LAST_USED_TRACTOR () {
					return this.RT_LAST_USED_TRACTOR;
				}
				
			    public int NEXT_ORDER_ONLY;

				public int getNEXT_ORDER_ONLY () {
					return this.NEXT_ORDER_ONLY;
				}
				
			    public Integer RT_HISTORICAL_ORDER_ID;

				public Integer getRT_HISTORICAL_ORDER_ID () {
					return this.RT_HISTORICAL_ORDER_ID;
				}
				
			    public int CANCEL_ORDER;

				public int getCANCEL_ORDER () {
					return this.CANCEL_ORDER;
				}
				
			    public String CARD_NUMBER;

				public String getCARD_NUMBER () {
					return this.CARD_NUMBER;
				}
				
			    public int MULTI_LOADING_LIMIT;

				public int getMULTI_LOADING_LIMIT () {
					return this.MULTI_LOADING_LIMIT;
				}
				
			    public int RECENT_CUSTOMER_LIST_ENABLE;

				public int getRECENT_CUSTOMER_LIST_ENABLE () {
					return this.RECENT_CUSTOMER_LIST_ENABLE;
				}
				
			    public int REPEAT_LAST_COMM_INFO;

				public int getREPEAT_LAST_COMM_INFO () {
					return this.REPEAT_LAST_COMM_INFO;
				}
				
			    public int REPEAT_LAST_COMPART_INFO;

				public int getREPEAT_LAST_COMPART_INFO () {
					return this.REPEAT_LAST_COMPART_INFO;
				}
				
			    public int GLOBAL_LOCKOUT;

				public int getGLOBAL_LOCKOUT () {
					return this.GLOBAL_LOCKOUT;
				}
				
			    public String GLOBAL_LOCKOUT_REASON;

				public String getGLOBAL_LOCKOUT_REASON () {
					return this.GLOBAL_LOCKOUT_REASON;
				}
				
			    public String GLOBAL_LOCKOUT_USER;

				public String getGLOBAL_LOCKOUT_USER () {
					return this.GLOBAL_LOCKOUT_USER;
				}
				
			    public int GLOBAL_LOCKOUT_TERMINAL_ID;

				public int getGLOBAL_LOCKOUT_TERMINAL_ID () {
					return this.GLOBAL_LOCKOUT_TERMINAL_ID;
				}
				
			    public int LOCKOUT_DUE_TO_TRAILER_MISUSE;

				public int getLOCKOUT_DUE_TO_TRAILER_MISUSE () {
					return this.LOCKOUT_DUE_TO_TRAILER_MISUSE;
				}
				
			    public int TOLERANCE_ANNUNCIATION_ENABLE;

				public int getTOLERANCE_ANNUNCIATION_ENABLE () {
					return this.TOLERANCE_ANNUNCIATION_ENABLE;
				}
				
			    public int MULTI_TRAILER_ENABLED;

				public int getMULTI_TRAILER_ENABLED () {
					return this.MULTI_TRAILER_ENABLED;
				}
				
			    public Integer RT_CURRENT_VISIT_ID;

				public Integer getRT_CURRENT_VISIT_ID () {
					return this.RT_CURRENT_VISIT_ID;
				}
				
			    public Integer RT_LAST_USED_VEHICLE_CARRIER;

				public Integer getRT_LAST_USED_VEHICLE_CARRIER () {
					return this.RT_LAST_USED_VEHICLE_CARRIER;
				}
				
			    public String RT_LAST_USED_VEHICLE;

				public String getRT_LAST_USED_VEHICLE () {
					return this.RT_LAST_USED_VEHICLE;
				}
				
			    public String PDXR_RACK_DRIVER_ID;

				public String getPDXR_RACK_DRIVER_ID () {
					return this.PDXR_RACK_DRIVER_ID;
				}
				
			    public Integer LANGUAGE;

				public Integer getLANGUAGE () {
					return this.LANGUAGE;
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
			if(length > commonByteArray_PGS_STAGE_DIM_DRIVER.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_DRIVER.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_DRIVER = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_DRIVER = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PGS_STAGE_DIM_DRIVER, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_DRIVER, 0, length, utf8Charset);
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
			if(length > commonByteArray_PGS_STAGE_DIM_DRIVER.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_DRIVER.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_DRIVER = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_DRIVER = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PGS_STAGE_DIM_DRIVER, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_DRIVER, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_DRIVER) {

        	try {

        		int length = 0;
		
						this.RT_LAST_USED_CARRIER = readInteger(dis);
					
			        this.CARRIER_NUMBER = dis.readInt();
					
			        this.DRIVER_NUMBER = dis.readInt();
					
					this.NAME = readString(dis);
					
					this.RT_LAST_USED_TRAILER = readString(dis);
					
					this.INITIALS = readString(dis);
					
			        this.LOCKOUT_LOADING = dis.readInt();
					
					this.LICENSE_NUMBER = readString(dis);
					
					this.LOCKOUT_LOADING_REASON = readString(dis);
					
			        this.LOCKOUT_ENTRY = dis.readInt();
					
					this.LOCKOUT_ENTRY_REASON = readString(dis);
					
			        this.MULTI_PRODUCT_LOADING = dis.readInt();
					
					this.BOL_COMMENT_1 = readString(dis);
					
					this.BOL_COMMENT_2 = readString(dis);
					
						this.RT_CURRENT_ORDER_ID = readInteger(dis);
					
						this.RT_LAST_ORDER_ID = readInteger(dis);
					
			        this.FUEL_TRACTOR = dis.readInt();
					
			        this.ENTER_TERMINAL = dis.readInt();
					
						this.RT_BOL_ORDER_ID_1 = readInteger(dis);
					
						this.RT_BOL_ORDER_ID_2 = readInteger(dis);
					
			        this.METER_PROVER = dis.readInt();
					
						this.RT_BOL_ORDER_ID_3 = readInteger(dis);
					
			        this.METER_TOTALIZER = dis.readInt();
					
						this.RT_BOL_ORDER_ID_4 = readInteger(dis);
					
						this.RT_BOL_ORDER_ID_5 = readInteger(dis);
					
						this.RT_BOL_ORDER_ID_6 = readInteger(dis);
					
						this.RT_BOL_ORDER_ID_7 = readInteger(dis);
					
						this.RT_BOL_ORDER_ID_8 = readInteger(dis);
					
						this.RT_BOL_ORDER_ID_9 = readInteger(dis);
					
			        this.RT_CARDED_IN = dis.readInt();
					
					this.LAST_USER_NAME = readString(dis);
					
						this.RT_LAST_USED_TRACTOR_CARRIER = readInteger(dis);
					
					this.LAST_MODIFIED = readDate(dis);
					
						this.RT_LAST_USED_TRACTOR = readInteger(dis);
					
			        this.NEXT_ORDER_ONLY = dis.readInt();
					
						this.RT_HISTORICAL_ORDER_ID = readInteger(dis);
					
			        this.CANCEL_ORDER = dis.readInt();
					
					this.CARD_NUMBER = readString(dis);
					
			        this.MULTI_LOADING_LIMIT = dis.readInt();
					
			        this.RECENT_CUSTOMER_LIST_ENABLE = dis.readInt();
					
			        this.REPEAT_LAST_COMM_INFO = dis.readInt();
					
			        this.REPEAT_LAST_COMPART_INFO = dis.readInt();
					
			        this.GLOBAL_LOCKOUT = dis.readInt();
					
					this.GLOBAL_LOCKOUT_REASON = readString(dis);
					
					this.GLOBAL_LOCKOUT_USER = readString(dis);
					
			        this.GLOBAL_LOCKOUT_TERMINAL_ID = dis.readInt();
					
			        this.LOCKOUT_DUE_TO_TRAILER_MISUSE = dis.readInt();
					
			        this.TOLERANCE_ANNUNCIATION_ENABLE = dis.readInt();
					
			        this.MULTI_TRAILER_ENABLED = dis.readInt();
					
						this.RT_CURRENT_VISIT_ID = readInteger(dis);
					
						this.RT_LAST_USED_VEHICLE_CARRIER = readInteger(dis);
					
					this.RT_LAST_USED_VEHICLE = readString(dis);
					
					this.PDXR_RACK_DRIVER_ID = readString(dis);
					
						this.LANGUAGE = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_DRIVER) {

        	try {

        		int length = 0;
		
						this.RT_LAST_USED_CARRIER = readInteger(dis);
					
			        this.CARRIER_NUMBER = dis.readInt();
					
			        this.DRIVER_NUMBER = dis.readInt();
					
					this.NAME = readString(dis);
					
					this.RT_LAST_USED_TRAILER = readString(dis);
					
					this.INITIALS = readString(dis);
					
			        this.LOCKOUT_LOADING = dis.readInt();
					
					this.LICENSE_NUMBER = readString(dis);
					
					this.LOCKOUT_LOADING_REASON = readString(dis);
					
			        this.LOCKOUT_ENTRY = dis.readInt();
					
					this.LOCKOUT_ENTRY_REASON = readString(dis);
					
			        this.MULTI_PRODUCT_LOADING = dis.readInt();
					
					this.BOL_COMMENT_1 = readString(dis);
					
					this.BOL_COMMENT_2 = readString(dis);
					
						this.RT_CURRENT_ORDER_ID = readInteger(dis);
					
						this.RT_LAST_ORDER_ID = readInteger(dis);
					
			        this.FUEL_TRACTOR = dis.readInt();
					
			        this.ENTER_TERMINAL = dis.readInt();
					
						this.RT_BOL_ORDER_ID_1 = readInteger(dis);
					
						this.RT_BOL_ORDER_ID_2 = readInteger(dis);
					
			        this.METER_PROVER = dis.readInt();
					
						this.RT_BOL_ORDER_ID_3 = readInteger(dis);
					
			        this.METER_TOTALIZER = dis.readInt();
					
						this.RT_BOL_ORDER_ID_4 = readInteger(dis);
					
						this.RT_BOL_ORDER_ID_5 = readInteger(dis);
					
						this.RT_BOL_ORDER_ID_6 = readInteger(dis);
					
						this.RT_BOL_ORDER_ID_7 = readInteger(dis);
					
						this.RT_BOL_ORDER_ID_8 = readInteger(dis);
					
						this.RT_BOL_ORDER_ID_9 = readInteger(dis);
					
			        this.RT_CARDED_IN = dis.readInt();
					
					this.LAST_USER_NAME = readString(dis);
					
						this.RT_LAST_USED_TRACTOR_CARRIER = readInteger(dis);
					
					this.LAST_MODIFIED = readDate(dis);
					
						this.RT_LAST_USED_TRACTOR = readInteger(dis);
					
			        this.NEXT_ORDER_ONLY = dis.readInt();
					
						this.RT_HISTORICAL_ORDER_ID = readInteger(dis);
					
			        this.CANCEL_ORDER = dis.readInt();
					
					this.CARD_NUMBER = readString(dis);
					
			        this.MULTI_LOADING_LIMIT = dis.readInt();
					
			        this.RECENT_CUSTOMER_LIST_ENABLE = dis.readInt();
					
			        this.REPEAT_LAST_COMM_INFO = dis.readInt();
					
			        this.REPEAT_LAST_COMPART_INFO = dis.readInt();
					
			        this.GLOBAL_LOCKOUT = dis.readInt();
					
					this.GLOBAL_LOCKOUT_REASON = readString(dis);
					
					this.GLOBAL_LOCKOUT_USER = readString(dis);
					
			        this.GLOBAL_LOCKOUT_TERMINAL_ID = dis.readInt();
					
			        this.LOCKOUT_DUE_TO_TRAILER_MISUSE = dis.readInt();
					
			        this.TOLERANCE_ANNUNCIATION_ENABLE = dis.readInt();
					
			        this.MULTI_TRAILER_ENABLED = dis.readInt();
					
						this.RT_CURRENT_VISIT_ID = readInteger(dis);
					
						this.RT_LAST_USED_VEHICLE_CARRIER = readInteger(dis);
					
					this.RT_LAST_USED_VEHICLE = readString(dis);
					
					this.PDXR_RACK_DRIVER_ID = readString(dis);
					
						this.LANGUAGE = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// Integer
				
						writeInteger(this.RT_LAST_USED_CARRIER,dos);
					
					// int
				
		            	dos.writeInt(this.CARRIER_NUMBER);
					
					// int
				
		            	dos.writeInt(this.DRIVER_NUMBER);
					
					// String
				
						writeString(this.NAME,dos);
					
					// String
				
						writeString(this.RT_LAST_USED_TRAILER,dos);
					
					// String
				
						writeString(this.INITIALS,dos);
					
					// int
				
		            	dos.writeInt(this.LOCKOUT_LOADING);
					
					// String
				
						writeString(this.LICENSE_NUMBER,dos);
					
					// String
				
						writeString(this.LOCKOUT_LOADING_REASON,dos);
					
					// int
				
		            	dos.writeInt(this.LOCKOUT_ENTRY);
					
					// String
				
						writeString(this.LOCKOUT_ENTRY_REASON,dos);
					
					// int
				
		            	dos.writeInt(this.MULTI_PRODUCT_LOADING);
					
					// String
				
						writeString(this.BOL_COMMENT_1,dos);
					
					// String
				
						writeString(this.BOL_COMMENT_2,dos);
					
					// Integer
				
						writeInteger(this.RT_CURRENT_ORDER_ID,dos);
					
					// Integer
				
						writeInteger(this.RT_LAST_ORDER_ID,dos);
					
					// int
				
		            	dos.writeInt(this.FUEL_TRACTOR);
					
					// int
				
		            	dos.writeInt(this.ENTER_TERMINAL);
					
					// Integer
				
						writeInteger(this.RT_BOL_ORDER_ID_1,dos);
					
					// Integer
				
						writeInteger(this.RT_BOL_ORDER_ID_2,dos);
					
					// int
				
		            	dos.writeInt(this.METER_PROVER);
					
					// Integer
				
						writeInteger(this.RT_BOL_ORDER_ID_3,dos);
					
					// int
				
		            	dos.writeInt(this.METER_TOTALIZER);
					
					// Integer
				
						writeInteger(this.RT_BOL_ORDER_ID_4,dos);
					
					// Integer
				
						writeInteger(this.RT_BOL_ORDER_ID_5,dos);
					
					// Integer
				
						writeInteger(this.RT_BOL_ORDER_ID_6,dos);
					
					// Integer
				
						writeInteger(this.RT_BOL_ORDER_ID_7,dos);
					
					// Integer
				
						writeInteger(this.RT_BOL_ORDER_ID_8,dos);
					
					// Integer
				
						writeInteger(this.RT_BOL_ORDER_ID_9,dos);
					
					// int
				
		            	dos.writeInt(this.RT_CARDED_IN);
					
					// String
				
						writeString(this.LAST_USER_NAME,dos);
					
					// Integer
				
						writeInteger(this.RT_LAST_USED_TRACTOR_CARRIER,dos);
					
					// java.util.Date
				
						writeDate(this.LAST_MODIFIED,dos);
					
					// Integer
				
						writeInteger(this.RT_LAST_USED_TRACTOR,dos);
					
					// int
				
		            	dos.writeInt(this.NEXT_ORDER_ONLY);
					
					// Integer
				
						writeInteger(this.RT_HISTORICAL_ORDER_ID,dos);
					
					// int
				
		            	dos.writeInt(this.CANCEL_ORDER);
					
					// String
				
						writeString(this.CARD_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.MULTI_LOADING_LIMIT);
					
					// int
				
		            	dos.writeInt(this.RECENT_CUSTOMER_LIST_ENABLE);
					
					// int
				
		            	dos.writeInt(this.REPEAT_LAST_COMM_INFO);
					
					// int
				
		            	dos.writeInt(this.REPEAT_LAST_COMPART_INFO);
					
					// int
				
		            	dos.writeInt(this.GLOBAL_LOCKOUT);
					
					// String
				
						writeString(this.GLOBAL_LOCKOUT_REASON,dos);
					
					// String
				
						writeString(this.GLOBAL_LOCKOUT_USER,dos);
					
					// int
				
		            	dos.writeInt(this.GLOBAL_LOCKOUT_TERMINAL_ID);
					
					// int
				
		            	dos.writeInt(this.LOCKOUT_DUE_TO_TRAILER_MISUSE);
					
					// int
				
		            	dos.writeInt(this.TOLERANCE_ANNUNCIATION_ENABLE);
					
					// int
				
		            	dos.writeInt(this.MULTI_TRAILER_ENABLED);
					
					// Integer
				
						writeInteger(this.RT_CURRENT_VISIT_ID,dos);
					
					// Integer
				
						writeInteger(this.RT_LAST_USED_VEHICLE_CARRIER,dos);
					
					// String
				
						writeString(this.RT_LAST_USED_VEHICLE,dos);
					
					// String
				
						writeString(this.PDXR_RACK_DRIVER_ID,dos);
					
					// Integer
				
						writeInteger(this.LANGUAGE,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Integer
				
						writeInteger(this.RT_LAST_USED_CARRIER,dos);
					
					// int
				
		            	dos.writeInt(this.CARRIER_NUMBER);
					
					// int
				
		            	dos.writeInt(this.DRIVER_NUMBER);
					
					// String
				
						writeString(this.NAME,dos);
					
					// String
				
						writeString(this.RT_LAST_USED_TRAILER,dos);
					
					// String
				
						writeString(this.INITIALS,dos);
					
					// int
				
		            	dos.writeInt(this.LOCKOUT_LOADING);
					
					// String
				
						writeString(this.LICENSE_NUMBER,dos);
					
					// String
				
						writeString(this.LOCKOUT_LOADING_REASON,dos);
					
					// int
				
		            	dos.writeInt(this.LOCKOUT_ENTRY);
					
					// String
				
						writeString(this.LOCKOUT_ENTRY_REASON,dos);
					
					// int
				
		            	dos.writeInt(this.MULTI_PRODUCT_LOADING);
					
					// String
				
						writeString(this.BOL_COMMENT_1,dos);
					
					// String
				
						writeString(this.BOL_COMMENT_2,dos);
					
					// Integer
				
						writeInteger(this.RT_CURRENT_ORDER_ID,dos);
					
					// Integer
				
						writeInteger(this.RT_LAST_ORDER_ID,dos);
					
					// int
				
		            	dos.writeInt(this.FUEL_TRACTOR);
					
					// int
				
		            	dos.writeInt(this.ENTER_TERMINAL);
					
					// Integer
				
						writeInteger(this.RT_BOL_ORDER_ID_1,dos);
					
					// Integer
				
						writeInteger(this.RT_BOL_ORDER_ID_2,dos);
					
					// int
				
		            	dos.writeInt(this.METER_PROVER);
					
					// Integer
				
						writeInteger(this.RT_BOL_ORDER_ID_3,dos);
					
					// int
				
		            	dos.writeInt(this.METER_TOTALIZER);
					
					// Integer
				
						writeInteger(this.RT_BOL_ORDER_ID_4,dos);
					
					// Integer
				
						writeInteger(this.RT_BOL_ORDER_ID_5,dos);
					
					// Integer
				
						writeInteger(this.RT_BOL_ORDER_ID_6,dos);
					
					// Integer
				
						writeInteger(this.RT_BOL_ORDER_ID_7,dos);
					
					// Integer
				
						writeInteger(this.RT_BOL_ORDER_ID_8,dos);
					
					// Integer
				
						writeInteger(this.RT_BOL_ORDER_ID_9,dos);
					
					// int
				
		            	dos.writeInt(this.RT_CARDED_IN);
					
					// String
				
						writeString(this.LAST_USER_NAME,dos);
					
					// Integer
				
						writeInteger(this.RT_LAST_USED_TRACTOR_CARRIER,dos);
					
					// java.util.Date
				
						writeDate(this.LAST_MODIFIED,dos);
					
					// Integer
				
						writeInteger(this.RT_LAST_USED_TRACTOR,dos);
					
					// int
				
		            	dos.writeInt(this.NEXT_ORDER_ONLY);
					
					// Integer
				
						writeInteger(this.RT_HISTORICAL_ORDER_ID,dos);
					
					// int
				
		            	dos.writeInt(this.CANCEL_ORDER);
					
					// String
				
						writeString(this.CARD_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.MULTI_LOADING_LIMIT);
					
					// int
				
		            	dos.writeInt(this.RECENT_CUSTOMER_LIST_ENABLE);
					
					// int
				
		            	dos.writeInt(this.REPEAT_LAST_COMM_INFO);
					
					// int
				
		            	dos.writeInt(this.REPEAT_LAST_COMPART_INFO);
					
					// int
				
		            	dos.writeInt(this.GLOBAL_LOCKOUT);
					
					// String
				
						writeString(this.GLOBAL_LOCKOUT_REASON,dos);
					
					// String
				
						writeString(this.GLOBAL_LOCKOUT_USER,dos);
					
					// int
				
		            	dos.writeInt(this.GLOBAL_LOCKOUT_TERMINAL_ID);
					
					// int
				
		            	dos.writeInt(this.LOCKOUT_DUE_TO_TRAILER_MISUSE);
					
					// int
				
		            	dos.writeInt(this.TOLERANCE_ANNUNCIATION_ENABLE);
					
					// int
				
		            	dos.writeInt(this.MULTI_TRAILER_ENABLED);
					
					// Integer
				
						writeInteger(this.RT_CURRENT_VISIT_ID,dos);
					
					// Integer
				
						writeInteger(this.RT_LAST_USED_VEHICLE_CARRIER,dos);
					
					// String
				
						writeString(this.RT_LAST_USED_VEHICLE,dos);
					
					// String
				
						writeString(this.PDXR_RACK_DRIVER_ID,dos);
					
					// Integer
				
						writeInteger(this.LANGUAGE,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("RT_LAST_USED_CARRIER="+String.valueOf(RT_LAST_USED_CARRIER));
		sb.append(",CARRIER_NUMBER="+String.valueOf(CARRIER_NUMBER));
		sb.append(",DRIVER_NUMBER="+String.valueOf(DRIVER_NUMBER));
		sb.append(",NAME="+NAME);
		sb.append(",RT_LAST_USED_TRAILER="+RT_LAST_USED_TRAILER);
		sb.append(",INITIALS="+INITIALS);
		sb.append(",LOCKOUT_LOADING="+String.valueOf(LOCKOUT_LOADING));
		sb.append(",LICENSE_NUMBER="+LICENSE_NUMBER);
		sb.append(",LOCKOUT_LOADING_REASON="+LOCKOUT_LOADING_REASON);
		sb.append(",LOCKOUT_ENTRY="+String.valueOf(LOCKOUT_ENTRY));
		sb.append(",LOCKOUT_ENTRY_REASON="+LOCKOUT_ENTRY_REASON);
		sb.append(",MULTI_PRODUCT_LOADING="+String.valueOf(MULTI_PRODUCT_LOADING));
		sb.append(",BOL_COMMENT_1="+BOL_COMMENT_1);
		sb.append(",BOL_COMMENT_2="+BOL_COMMENT_2);
		sb.append(",RT_CURRENT_ORDER_ID="+String.valueOf(RT_CURRENT_ORDER_ID));
		sb.append(",RT_LAST_ORDER_ID="+String.valueOf(RT_LAST_ORDER_ID));
		sb.append(",FUEL_TRACTOR="+String.valueOf(FUEL_TRACTOR));
		sb.append(",ENTER_TERMINAL="+String.valueOf(ENTER_TERMINAL));
		sb.append(",RT_BOL_ORDER_ID_1="+String.valueOf(RT_BOL_ORDER_ID_1));
		sb.append(",RT_BOL_ORDER_ID_2="+String.valueOf(RT_BOL_ORDER_ID_2));
		sb.append(",METER_PROVER="+String.valueOf(METER_PROVER));
		sb.append(",RT_BOL_ORDER_ID_3="+String.valueOf(RT_BOL_ORDER_ID_3));
		sb.append(",METER_TOTALIZER="+String.valueOf(METER_TOTALIZER));
		sb.append(",RT_BOL_ORDER_ID_4="+String.valueOf(RT_BOL_ORDER_ID_4));
		sb.append(",RT_BOL_ORDER_ID_5="+String.valueOf(RT_BOL_ORDER_ID_5));
		sb.append(",RT_BOL_ORDER_ID_6="+String.valueOf(RT_BOL_ORDER_ID_6));
		sb.append(",RT_BOL_ORDER_ID_7="+String.valueOf(RT_BOL_ORDER_ID_7));
		sb.append(",RT_BOL_ORDER_ID_8="+String.valueOf(RT_BOL_ORDER_ID_8));
		sb.append(",RT_BOL_ORDER_ID_9="+String.valueOf(RT_BOL_ORDER_ID_9));
		sb.append(",RT_CARDED_IN="+String.valueOf(RT_CARDED_IN));
		sb.append(",LAST_USER_NAME="+LAST_USER_NAME);
		sb.append(",RT_LAST_USED_TRACTOR_CARRIER="+String.valueOf(RT_LAST_USED_TRACTOR_CARRIER));
		sb.append(",LAST_MODIFIED="+String.valueOf(LAST_MODIFIED));
		sb.append(",RT_LAST_USED_TRACTOR="+String.valueOf(RT_LAST_USED_TRACTOR));
		sb.append(",NEXT_ORDER_ONLY="+String.valueOf(NEXT_ORDER_ONLY));
		sb.append(",RT_HISTORICAL_ORDER_ID="+String.valueOf(RT_HISTORICAL_ORDER_ID));
		sb.append(",CANCEL_ORDER="+String.valueOf(CANCEL_ORDER));
		sb.append(",CARD_NUMBER="+CARD_NUMBER);
		sb.append(",MULTI_LOADING_LIMIT="+String.valueOf(MULTI_LOADING_LIMIT));
		sb.append(",RECENT_CUSTOMER_LIST_ENABLE="+String.valueOf(RECENT_CUSTOMER_LIST_ENABLE));
		sb.append(",REPEAT_LAST_COMM_INFO="+String.valueOf(REPEAT_LAST_COMM_INFO));
		sb.append(",REPEAT_LAST_COMPART_INFO="+String.valueOf(REPEAT_LAST_COMPART_INFO));
		sb.append(",GLOBAL_LOCKOUT="+String.valueOf(GLOBAL_LOCKOUT));
		sb.append(",GLOBAL_LOCKOUT_REASON="+GLOBAL_LOCKOUT_REASON);
		sb.append(",GLOBAL_LOCKOUT_USER="+GLOBAL_LOCKOUT_USER);
		sb.append(",GLOBAL_LOCKOUT_TERMINAL_ID="+String.valueOf(GLOBAL_LOCKOUT_TERMINAL_ID));
		sb.append(",LOCKOUT_DUE_TO_TRAILER_MISUSE="+String.valueOf(LOCKOUT_DUE_TO_TRAILER_MISUSE));
		sb.append(",TOLERANCE_ANNUNCIATION_ENABLE="+String.valueOf(TOLERANCE_ANNUNCIATION_ENABLE));
		sb.append(",MULTI_TRAILER_ENABLED="+String.valueOf(MULTI_TRAILER_ENABLED));
		sb.append(",RT_CURRENT_VISIT_ID="+String.valueOf(RT_CURRENT_VISIT_ID));
		sb.append(",RT_LAST_USED_VEHICLE_CARRIER="+String.valueOf(RT_LAST_USED_VEHICLE_CARRIER));
		sb.append(",RT_LAST_USED_VEHICLE="+RT_LAST_USED_VEHICLE);
		sb.append(",PDXR_RACK_DRIVER_ID="+PDXR_RACK_DRIVER_ID);
		sb.append(",LANGUAGE="+String.valueOf(LANGUAGE));
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
    final static byte[] commonByteArrayLock_PGS_STAGE_DIM_DRIVER = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_DIM_DRIVER = new byte[0];

	
			    public Integer RT_LAST_USED_CARRIER;

				public Integer getRT_LAST_USED_CARRIER () {
					return this.RT_LAST_USED_CARRIER;
				}
				
			    public int CARRIER_NUMBER;

				public int getCARRIER_NUMBER () {
					return this.CARRIER_NUMBER;
				}
				
			    public int DRIVER_NUMBER;

				public int getDRIVER_NUMBER () {
					return this.DRIVER_NUMBER;
				}
				
			    public String NAME;

				public String getNAME () {
					return this.NAME;
				}
				
			    public String RT_LAST_USED_TRAILER;

				public String getRT_LAST_USED_TRAILER () {
					return this.RT_LAST_USED_TRAILER;
				}
				
			    public String INITIALS;

				public String getINITIALS () {
					return this.INITIALS;
				}
				
			    public int LOCKOUT_LOADING;

				public int getLOCKOUT_LOADING () {
					return this.LOCKOUT_LOADING;
				}
				
			    public String LICENSE_NUMBER;

				public String getLICENSE_NUMBER () {
					return this.LICENSE_NUMBER;
				}
				
			    public String LOCKOUT_LOADING_REASON;

				public String getLOCKOUT_LOADING_REASON () {
					return this.LOCKOUT_LOADING_REASON;
				}
				
			    public int LOCKOUT_ENTRY;

				public int getLOCKOUT_ENTRY () {
					return this.LOCKOUT_ENTRY;
				}
				
			    public String LOCKOUT_ENTRY_REASON;

				public String getLOCKOUT_ENTRY_REASON () {
					return this.LOCKOUT_ENTRY_REASON;
				}
				
			    public int MULTI_PRODUCT_LOADING;

				public int getMULTI_PRODUCT_LOADING () {
					return this.MULTI_PRODUCT_LOADING;
				}
				
			    public String BOL_COMMENT_1;

				public String getBOL_COMMENT_1 () {
					return this.BOL_COMMENT_1;
				}
				
			    public String BOL_COMMENT_2;

				public String getBOL_COMMENT_2 () {
					return this.BOL_COMMENT_2;
				}
				
			    public Integer RT_CURRENT_ORDER_ID;

				public Integer getRT_CURRENT_ORDER_ID () {
					return this.RT_CURRENT_ORDER_ID;
				}
				
			    public Integer RT_LAST_ORDER_ID;

				public Integer getRT_LAST_ORDER_ID () {
					return this.RT_LAST_ORDER_ID;
				}
				
			    public int FUEL_TRACTOR;

				public int getFUEL_TRACTOR () {
					return this.FUEL_TRACTOR;
				}
				
			    public int ENTER_TERMINAL;

				public int getENTER_TERMINAL () {
					return this.ENTER_TERMINAL;
				}
				
			    public Integer RT_BOL_ORDER_ID_1;

				public Integer getRT_BOL_ORDER_ID_1 () {
					return this.RT_BOL_ORDER_ID_1;
				}
				
			    public Integer RT_BOL_ORDER_ID_2;

				public Integer getRT_BOL_ORDER_ID_2 () {
					return this.RT_BOL_ORDER_ID_2;
				}
				
			    public int METER_PROVER;

				public int getMETER_PROVER () {
					return this.METER_PROVER;
				}
				
			    public Integer RT_BOL_ORDER_ID_3;

				public Integer getRT_BOL_ORDER_ID_3 () {
					return this.RT_BOL_ORDER_ID_3;
				}
				
			    public int METER_TOTALIZER;

				public int getMETER_TOTALIZER () {
					return this.METER_TOTALIZER;
				}
				
			    public Integer RT_BOL_ORDER_ID_4;

				public Integer getRT_BOL_ORDER_ID_4 () {
					return this.RT_BOL_ORDER_ID_4;
				}
				
			    public Integer RT_BOL_ORDER_ID_5;

				public Integer getRT_BOL_ORDER_ID_5 () {
					return this.RT_BOL_ORDER_ID_5;
				}
				
			    public Integer RT_BOL_ORDER_ID_6;

				public Integer getRT_BOL_ORDER_ID_6 () {
					return this.RT_BOL_ORDER_ID_6;
				}
				
			    public Integer RT_BOL_ORDER_ID_7;

				public Integer getRT_BOL_ORDER_ID_7 () {
					return this.RT_BOL_ORDER_ID_7;
				}
				
			    public Integer RT_BOL_ORDER_ID_8;

				public Integer getRT_BOL_ORDER_ID_8 () {
					return this.RT_BOL_ORDER_ID_8;
				}
				
			    public Integer RT_BOL_ORDER_ID_9;

				public Integer getRT_BOL_ORDER_ID_9 () {
					return this.RT_BOL_ORDER_ID_9;
				}
				
			    public int RT_CARDED_IN;

				public int getRT_CARDED_IN () {
					return this.RT_CARDED_IN;
				}
				
			    public String LAST_USER_NAME;

				public String getLAST_USER_NAME () {
					return this.LAST_USER_NAME;
				}
				
			    public Integer RT_LAST_USED_TRACTOR_CARRIER;

				public Integer getRT_LAST_USED_TRACTOR_CARRIER () {
					return this.RT_LAST_USED_TRACTOR_CARRIER;
				}
				
			    public java.util.Date LAST_MODIFIED;

				public java.util.Date getLAST_MODIFIED () {
					return this.LAST_MODIFIED;
				}
				
			    public Integer RT_LAST_USED_TRACTOR;

				public Integer getRT_LAST_USED_TRACTOR () {
					return this.RT_LAST_USED_TRACTOR;
				}
				
			    public int NEXT_ORDER_ONLY;

				public int getNEXT_ORDER_ONLY () {
					return this.NEXT_ORDER_ONLY;
				}
				
			    public Integer RT_HISTORICAL_ORDER_ID;

				public Integer getRT_HISTORICAL_ORDER_ID () {
					return this.RT_HISTORICAL_ORDER_ID;
				}
				
			    public int CANCEL_ORDER;

				public int getCANCEL_ORDER () {
					return this.CANCEL_ORDER;
				}
				
			    public String CARD_NUMBER;

				public String getCARD_NUMBER () {
					return this.CARD_NUMBER;
				}
				
			    public int MULTI_LOADING_LIMIT;

				public int getMULTI_LOADING_LIMIT () {
					return this.MULTI_LOADING_LIMIT;
				}
				
			    public int RECENT_CUSTOMER_LIST_ENABLE;

				public int getRECENT_CUSTOMER_LIST_ENABLE () {
					return this.RECENT_CUSTOMER_LIST_ENABLE;
				}
				
			    public int REPEAT_LAST_COMM_INFO;

				public int getREPEAT_LAST_COMM_INFO () {
					return this.REPEAT_LAST_COMM_INFO;
				}
				
			    public int REPEAT_LAST_COMPART_INFO;

				public int getREPEAT_LAST_COMPART_INFO () {
					return this.REPEAT_LAST_COMPART_INFO;
				}
				
			    public int GLOBAL_LOCKOUT;

				public int getGLOBAL_LOCKOUT () {
					return this.GLOBAL_LOCKOUT;
				}
				
			    public String GLOBAL_LOCKOUT_REASON;

				public String getGLOBAL_LOCKOUT_REASON () {
					return this.GLOBAL_LOCKOUT_REASON;
				}
				
			    public String GLOBAL_LOCKOUT_USER;

				public String getGLOBAL_LOCKOUT_USER () {
					return this.GLOBAL_LOCKOUT_USER;
				}
				
			    public int GLOBAL_LOCKOUT_TERMINAL_ID;

				public int getGLOBAL_LOCKOUT_TERMINAL_ID () {
					return this.GLOBAL_LOCKOUT_TERMINAL_ID;
				}
				
			    public int LOCKOUT_DUE_TO_TRAILER_MISUSE;

				public int getLOCKOUT_DUE_TO_TRAILER_MISUSE () {
					return this.LOCKOUT_DUE_TO_TRAILER_MISUSE;
				}
				
			    public int TOLERANCE_ANNUNCIATION_ENABLE;

				public int getTOLERANCE_ANNUNCIATION_ENABLE () {
					return this.TOLERANCE_ANNUNCIATION_ENABLE;
				}
				
			    public int MULTI_TRAILER_ENABLED;

				public int getMULTI_TRAILER_ENABLED () {
					return this.MULTI_TRAILER_ENABLED;
				}
				
			    public Integer RT_CURRENT_VISIT_ID;

				public Integer getRT_CURRENT_VISIT_ID () {
					return this.RT_CURRENT_VISIT_ID;
				}
				
			    public Integer RT_LAST_USED_VEHICLE_CARRIER;

				public Integer getRT_LAST_USED_VEHICLE_CARRIER () {
					return this.RT_LAST_USED_VEHICLE_CARRIER;
				}
				
			    public String RT_LAST_USED_VEHICLE;

				public String getRT_LAST_USED_VEHICLE () {
					return this.RT_LAST_USED_VEHICLE;
				}
				
			    public String PDXR_RACK_DRIVER_ID;

				public String getPDXR_RACK_DRIVER_ID () {
					return this.PDXR_RACK_DRIVER_ID;
				}
				
			    public Integer LANGUAGE;

				public Integer getLANGUAGE () {
					return this.LANGUAGE;
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
			if(length > commonByteArray_PGS_STAGE_DIM_DRIVER.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_DRIVER.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_DRIVER = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_DRIVER = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PGS_STAGE_DIM_DRIVER, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_DRIVER, 0, length, utf8Charset);
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
			if(length > commonByteArray_PGS_STAGE_DIM_DRIVER.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_DRIVER.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_DRIVER = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_DRIVER = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PGS_STAGE_DIM_DRIVER, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_DRIVER, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_DRIVER) {

        	try {

        		int length = 0;
		
						this.RT_LAST_USED_CARRIER = readInteger(dis);
					
			        this.CARRIER_NUMBER = dis.readInt();
					
			        this.DRIVER_NUMBER = dis.readInt();
					
					this.NAME = readString(dis);
					
					this.RT_LAST_USED_TRAILER = readString(dis);
					
					this.INITIALS = readString(dis);
					
			        this.LOCKOUT_LOADING = dis.readInt();
					
					this.LICENSE_NUMBER = readString(dis);
					
					this.LOCKOUT_LOADING_REASON = readString(dis);
					
			        this.LOCKOUT_ENTRY = dis.readInt();
					
					this.LOCKOUT_ENTRY_REASON = readString(dis);
					
			        this.MULTI_PRODUCT_LOADING = dis.readInt();
					
					this.BOL_COMMENT_1 = readString(dis);
					
					this.BOL_COMMENT_2 = readString(dis);
					
						this.RT_CURRENT_ORDER_ID = readInteger(dis);
					
						this.RT_LAST_ORDER_ID = readInteger(dis);
					
			        this.FUEL_TRACTOR = dis.readInt();
					
			        this.ENTER_TERMINAL = dis.readInt();
					
						this.RT_BOL_ORDER_ID_1 = readInteger(dis);
					
						this.RT_BOL_ORDER_ID_2 = readInteger(dis);
					
			        this.METER_PROVER = dis.readInt();
					
						this.RT_BOL_ORDER_ID_3 = readInteger(dis);
					
			        this.METER_TOTALIZER = dis.readInt();
					
						this.RT_BOL_ORDER_ID_4 = readInteger(dis);
					
						this.RT_BOL_ORDER_ID_5 = readInteger(dis);
					
						this.RT_BOL_ORDER_ID_6 = readInteger(dis);
					
						this.RT_BOL_ORDER_ID_7 = readInteger(dis);
					
						this.RT_BOL_ORDER_ID_8 = readInteger(dis);
					
						this.RT_BOL_ORDER_ID_9 = readInteger(dis);
					
			        this.RT_CARDED_IN = dis.readInt();
					
					this.LAST_USER_NAME = readString(dis);
					
						this.RT_LAST_USED_TRACTOR_CARRIER = readInteger(dis);
					
					this.LAST_MODIFIED = readDate(dis);
					
						this.RT_LAST_USED_TRACTOR = readInteger(dis);
					
			        this.NEXT_ORDER_ONLY = dis.readInt();
					
						this.RT_HISTORICAL_ORDER_ID = readInteger(dis);
					
			        this.CANCEL_ORDER = dis.readInt();
					
					this.CARD_NUMBER = readString(dis);
					
			        this.MULTI_LOADING_LIMIT = dis.readInt();
					
			        this.RECENT_CUSTOMER_LIST_ENABLE = dis.readInt();
					
			        this.REPEAT_LAST_COMM_INFO = dis.readInt();
					
			        this.REPEAT_LAST_COMPART_INFO = dis.readInt();
					
			        this.GLOBAL_LOCKOUT = dis.readInt();
					
					this.GLOBAL_LOCKOUT_REASON = readString(dis);
					
					this.GLOBAL_LOCKOUT_USER = readString(dis);
					
			        this.GLOBAL_LOCKOUT_TERMINAL_ID = dis.readInt();
					
			        this.LOCKOUT_DUE_TO_TRAILER_MISUSE = dis.readInt();
					
			        this.TOLERANCE_ANNUNCIATION_ENABLE = dis.readInt();
					
			        this.MULTI_TRAILER_ENABLED = dis.readInt();
					
						this.RT_CURRENT_VISIT_ID = readInteger(dis);
					
						this.RT_LAST_USED_VEHICLE_CARRIER = readInteger(dis);
					
					this.RT_LAST_USED_VEHICLE = readString(dis);
					
					this.PDXR_RACK_DRIVER_ID = readString(dis);
					
						this.LANGUAGE = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_DRIVER) {

        	try {

        		int length = 0;
		
						this.RT_LAST_USED_CARRIER = readInteger(dis);
					
			        this.CARRIER_NUMBER = dis.readInt();
					
			        this.DRIVER_NUMBER = dis.readInt();
					
					this.NAME = readString(dis);
					
					this.RT_LAST_USED_TRAILER = readString(dis);
					
					this.INITIALS = readString(dis);
					
			        this.LOCKOUT_LOADING = dis.readInt();
					
					this.LICENSE_NUMBER = readString(dis);
					
					this.LOCKOUT_LOADING_REASON = readString(dis);
					
			        this.LOCKOUT_ENTRY = dis.readInt();
					
					this.LOCKOUT_ENTRY_REASON = readString(dis);
					
			        this.MULTI_PRODUCT_LOADING = dis.readInt();
					
					this.BOL_COMMENT_1 = readString(dis);
					
					this.BOL_COMMENT_2 = readString(dis);
					
						this.RT_CURRENT_ORDER_ID = readInteger(dis);
					
						this.RT_LAST_ORDER_ID = readInteger(dis);
					
			        this.FUEL_TRACTOR = dis.readInt();
					
			        this.ENTER_TERMINAL = dis.readInt();
					
						this.RT_BOL_ORDER_ID_1 = readInteger(dis);
					
						this.RT_BOL_ORDER_ID_2 = readInteger(dis);
					
			        this.METER_PROVER = dis.readInt();
					
						this.RT_BOL_ORDER_ID_3 = readInteger(dis);
					
			        this.METER_TOTALIZER = dis.readInt();
					
						this.RT_BOL_ORDER_ID_4 = readInteger(dis);
					
						this.RT_BOL_ORDER_ID_5 = readInteger(dis);
					
						this.RT_BOL_ORDER_ID_6 = readInteger(dis);
					
						this.RT_BOL_ORDER_ID_7 = readInteger(dis);
					
						this.RT_BOL_ORDER_ID_8 = readInteger(dis);
					
						this.RT_BOL_ORDER_ID_9 = readInteger(dis);
					
			        this.RT_CARDED_IN = dis.readInt();
					
					this.LAST_USER_NAME = readString(dis);
					
						this.RT_LAST_USED_TRACTOR_CARRIER = readInteger(dis);
					
					this.LAST_MODIFIED = readDate(dis);
					
						this.RT_LAST_USED_TRACTOR = readInteger(dis);
					
			        this.NEXT_ORDER_ONLY = dis.readInt();
					
						this.RT_HISTORICAL_ORDER_ID = readInteger(dis);
					
			        this.CANCEL_ORDER = dis.readInt();
					
					this.CARD_NUMBER = readString(dis);
					
			        this.MULTI_LOADING_LIMIT = dis.readInt();
					
			        this.RECENT_CUSTOMER_LIST_ENABLE = dis.readInt();
					
			        this.REPEAT_LAST_COMM_INFO = dis.readInt();
					
			        this.REPEAT_LAST_COMPART_INFO = dis.readInt();
					
			        this.GLOBAL_LOCKOUT = dis.readInt();
					
					this.GLOBAL_LOCKOUT_REASON = readString(dis);
					
					this.GLOBAL_LOCKOUT_USER = readString(dis);
					
			        this.GLOBAL_LOCKOUT_TERMINAL_ID = dis.readInt();
					
			        this.LOCKOUT_DUE_TO_TRAILER_MISUSE = dis.readInt();
					
			        this.TOLERANCE_ANNUNCIATION_ENABLE = dis.readInt();
					
			        this.MULTI_TRAILER_ENABLED = dis.readInt();
					
						this.RT_CURRENT_VISIT_ID = readInteger(dis);
					
						this.RT_LAST_USED_VEHICLE_CARRIER = readInteger(dis);
					
					this.RT_LAST_USED_VEHICLE = readString(dis);
					
					this.PDXR_RACK_DRIVER_ID = readString(dis);
					
						this.LANGUAGE = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// Integer
				
						writeInteger(this.RT_LAST_USED_CARRIER,dos);
					
					// int
				
		            	dos.writeInt(this.CARRIER_NUMBER);
					
					// int
				
		            	dos.writeInt(this.DRIVER_NUMBER);
					
					// String
				
						writeString(this.NAME,dos);
					
					// String
				
						writeString(this.RT_LAST_USED_TRAILER,dos);
					
					// String
				
						writeString(this.INITIALS,dos);
					
					// int
				
		            	dos.writeInt(this.LOCKOUT_LOADING);
					
					// String
				
						writeString(this.LICENSE_NUMBER,dos);
					
					// String
				
						writeString(this.LOCKOUT_LOADING_REASON,dos);
					
					// int
				
		            	dos.writeInt(this.LOCKOUT_ENTRY);
					
					// String
				
						writeString(this.LOCKOUT_ENTRY_REASON,dos);
					
					// int
				
		            	dos.writeInt(this.MULTI_PRODUCT_LOADING);
					
					// String
				
						writeString(this.BOL_COMMENT_1,dos);
					
					// String
				
						writeString(this.BOL_COMMENT_2,dos);
					
					// Integer
				
						writeInteger(this.RT_CURRENT_ORDER_ID,dos);
					
					// Integer
				
						writeInteger(this.RT_LAST_ORDER_ID,dos);
					
					// int
				
		            	dos.writeInt(this.FUEL_TRACTOR);
					
					// int
				
		            	dos.writeInt(this.ENTER_TERMINAL);
					
					// Integer
				
						writeInteger(this.RT_BOL_ORDER_ID_1,dos);
					
					// Integer
				
						writeInteger(this.RT_BOL_ORDER_ID_2,dos);
					
					// int
				
		            	dos.writeInt(this.METER_PROVER);
					
					// Integer
				
						writeInteger(this.RT_BOL_ORDER_ID_3,dos);
					
					// int
				
		            	dos.writeInt(this.METER_TOTALIZER);
					
					// Integer
				
						writeInteger(this.RT_BOL_ORDER_ID_4,dos);
					
					// Integer
				
						writeInteger(this.RT_BOL_ORDER_ID_5,dos);
					
					// Integer
				
						writeInteger(this.RT_BOL_ORDER_ID_6,dos);
					
					// Integer
				
						writeInteger(this.RT_BOL_ORDER_ID_7,dos);
					
					// Integer
				
						writeInteger(this.RT_BOL_ORDER_ID_8,dos);
					
					// Integer
				
						writeInteger(this.RT_BOL_ORDER_ID_9,dos);
					
					// int
				
		            	dos.writeInt(this.RT_CARDED_IN);
					
					// String
				
						writeString(this.LAST_USER_NAME,dos);
					
					// Integer
				
						writeInteger(this.RT_LAST_USED_TRACTOR_CARRIER,dos);
					
					// java.util.Date
				
						writeDate(this.LAST_MODIFIED,dos);
					
					// Integer
				
						writeInteger(this.RT_LAST_USED_TRACTOR,dos);
					
					// int
				
		            	dos.writeInt(this.NEXT_ORDER_ONLY);
					
					// Integer
				
						writeInteger(this.RT_HISTORICAL_ORDER_ID,dos);
					
					// int
				
		            	dos.writeInt(this.CANCEL_ORDER);
					
					// String
				
						writeString(this.CARD_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.MULTI_LOADING_LIMIT);
					
					// int
				
		            	dos.writeInt(this.RECENT_CUSTOMER_LIST_ENABLE);
					
					// int
				
		            	dos.writeInt(this.REPEAT_LAST_COMM_INFO);
					
					// int
				
		            	dos.writeInt(this.REPEAT_LAST_COMPART_INFO);
					
					// int
				
		            	dos.writeInt(this.GLOBAL_LOCKOUT);
					
					// String
				
						writeString(this.GLOBAL_LOCKOUT_REASON,dos);
					
					// String
				
						writeString(this.GLOBAL_LOCKOUT_USER,dos);
					
					// int
				
		            	dos.writeInt(this.GLOBAL_LOCKOUT_TERMINAL_ID);
					
					// int
				
		            	dos.writeInt(this.LOCKOUT_DUE_TO_TRAILER_MISUSE);
					
					// int
				
		            	dos.writeInt(this.TOLERANCE_ANNUNCIATION_ENABLE);
					
					// int
				
		            	dos.writeInt(this.MULTI_TRAILER_ENABLED);
					
					// Integer
				
						writeInteger(this.RT_CURRENT_VISIT_ID,dos);
					
					// Integer
				
						writeInteger(this.RT_LAST_USED_VEHICLE_CARRIER,dos);
					
					// String
				
						writeString(this.RT_LAST_USED_VEHICLE,dos);
					
					// String
				
						writeString(this.PDXR_RACK_DRIVER_ID,dos);
					
					// Integer
				
						writeInteger(this.LANGUAGE,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Integer
				
						writeInteger(this.RT_LAST_USED_CARRIER,dos);
					
					// int
				
		            	dos.writeInt(this.CARRIER_NUMBER);
					
					// int
				
		            	dos.writeInt(this.DRIVER_NUMBER);
					
					// String
				
						writeString(this.NAME,dos);
					
					// String
				
						writeString(this.RT_LAST_USED_TRAILER,dos);
					
					// String
				
						writeString(this.INITIALS,dos);
					
					// int
				
		            	dos.writeInt(this.LOCKOUT_LOADING);
					
					// String
				
						writeString(this.LICENSE_NUMBER,dos);
					
					// String
				
						writeString(this.LOCKOUT_LOADING_REASON,dos);
					
					// int
				
		            	dos.writeInt(this.LOCKOUT_ENTRY);
					
					// String
				
						writeString(this.LOCKOUT_ENTRY_REASON,dos);
					
					// int
				
		            	dos.writeInt(this.MULTI_PRODUCT_LOADING);
					
					// String
				
						writeString(this.BOL_COMMENT_1,dos);
					
					// String
				
						writeString(this.BOL_COMMENT_2,dos);
					
					// Integer
				
						writeInteger(this.RT_CURRENT_ORDER_ID,dos);
					
					// Integer
				
						writeInteger(this.RT_LAST_ORDER_ID,dos);
					
					// int
				
		            	dos.writeInt(this.FUEL_TRACTOR);
					
					// int
				
		            	dos.writeInt(this.ENTER_TERMINAL);
					
					// Integer
				
						writeInteger(this.RT_BOL_ORDER_ID_1,dos);
					
					// Integer
				
						writeInteger(this.RT_BOL_ORDER_ID_2,dos);
					
					// int
				
		            	dos.writeInt(this.METER_PROVER);
					
					// Integer
				
						writeInteger(this.RT_BOL_ORDER_ID_3,dos);
					
					// int
				
		            	dos.writeInt(this.METER_TOTALIZER);
					
					// Integer
				
						writeInteger(this.RT_BOL_ORDER_ID_4,dos);
					
					// Integer
				
						writeInteger(this.RT_BOL_ORDER_ID_5,dos);
					
					// Integer
				
						writeInteger(this.RT_BOL_ORDER_ID_6,dos);
					
					// Integer
				
						writeInteger(this.RT_BOL_ORDER_ID_7,dos);
					
					// Integer
				
						writeInteger(this.RT_BOL_ORDER_ID_8,dos);
					
					// Integer
				
						writeInteger(this.RT_BOL_ORDER_ID_9,dos);
					
					// int
				
		            	dos.writeInt(this.RT_CARDED_IN);
					
					// String
				
						writeString(this.LAST_USER_NAME,dos);
					
					// Integer
				
						writeInteger(this.RT_LAST_USED_TRACTOR_CARRIER,dos);
					
					// java.util.Date
				
						writeDate(this.LAST_MODIFIED,dos);
					
					// Integer
				
						writeInteger(this.RT_LAST_USED_TRACTOR,dos);
					
					// int
				
		            	dos.writeInt(this.NEXT_ORDER_ONLY);
					
					// Integer
				
						writeInteger(this.RT_HISTORICAL_ORDER_ID,dos);
					
					// int
				
		            	dos.writeInt(this.CANCEL_ORDER);
					
					// String
				
						writeString(this.CARD_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.MULTI_LOADING_LIMIT);
					
					// int
				
		            	dos.writeInt(this.RECENT_CUSTOMER_LIST_ENABLE);
					
					// int
				
		            	dos.writeInt(this.REPEAT_LAST_COMM_INFO);
					
					// int
				
		            	dos.writeInt(this.REPEAT_LAST_COMPART_INFO);
					
					// int
				
		            	dos.writeInt(this.GLOBAL_LOCKOUT);
					
					// String
				
						writeString(this.GLOBAL_LOCKOUT_REASON,dos);
					
					// String
				
						writeString(this.GLOBAL_LOCKOUT_USER,dos);
					
					// int
				
		            	dos.writeInt(this.GLOBAL_LOCKOUT_TERMINAL_ID);
					
					// int
				
		            	dos.writeInt(this.LOCKOUT_DUE_TO_TRAILER_MISUSE);
					
					// int
				
		            	dos.writeInt(this.TOLERANCE_ANNUNCIATION_ENABLE);
					
					// int
				
		            	dos.writeInt(this.MULTI_TRAILER_ENABLED);
					
					// Integer
				
						writeInteger(this.RT_CURRENT_VISIT_ID,dos);
					
					// Integer
				
						writeInteger(this.RT_LAST_USED_VEHICLE_CARRIER,dos);
					
					// String
				
						writeString(this.RT_LAST_USED_VEHICLE,dos);
					
					// String
				
						writeString(this.PDXR_RACK_DRIVER_ID,dos);
					
					// Integer
				
						writeInteger(this.LANGUAGE,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("RT_LAST_USED_CARRIER="+String.valueOf(RT_LAST_USED_CARRIER));
		sb.append(",CARRIER_NUMBER="+String.valueOf(CARRIER_NUMBER));
		sb.append(",DRIVER_NUMBER="+String.valueOf(DRIVER_NUMBER));
		sb.append(",NAME="+NAME);
		sb.append(",RT_LAST_USED_TRAILER="+RT_LAST_USED_TRAILER);
		sb.append(",INITIALS="+INITIALS);
		sb.append(",LOCKOUT_LOADING="+String.valueOf(LOCKOUT_LOADING));
		sb.append(",LICENSE_NUMBER="+LICENSE_NUMBER);
		sb.append(",LOCKOUT_LOADING_REASON="+LOCKOUT_LOADING_REASON);
		sb.append(",LOCKOUT_ENTRY="+String.valueOf(LOCKOUT_ENTRY));
		sb.append(",LOCKOUT_ENTRY_REASON="+LOCKOUT_ENTRY_REASON);
		sb.append(",MULTI_PRODUCT_LOADING="+String.valueOf(MULTI_PRODUCT_LOADING));
		sb.append(",BOL_COMMENT_1="+BOL_COMMENT_1);
		sb.append(",BOL_COMMENT_2="+BOL_COMMENT_2);
		sb.append(",RT_CURRENT_ORDER_ID="+String.valueOf(RT_CURRENT_ORDER_ID));
		sb.append(",RT_LAST_ORDER_ID="+String.valueOf(RT_LAST_ORDER_ID));
		sb.append(",FUEL_TRACTOR="+String.valueOf(FUEL_TRACTOR));
		sb.append(",ENTER_TERMINAL="+String.valueOf(ENTER_TERMINAL));
		sb.append(",RT_BOL_ORDER_ID_1="+String.valueOf(RT_BOL_ORDER_ID_1));
		sb.append(",RT_BOL_ORDER_ID_2="+String.valueOf(RT_BOL_ORDER_ID_2));
		sb.append(",METER_PROVER="+String.valueOf(METER_PROVER));
		sb.append(",RT_BOL_ORDER_ID_3="+String.valueOf(RT_BOL_ORDER_ID_3));
		sb.append(",METER_TOTALIZER="+String.valueOf(METER_TOTALIZER));
		sb.append(",RT_BOL_ORDER_ID_4="+String.valueOf(RT_BOL_ORDER_ID_4));
		sb.append(",RT_BOL_ORDER_ID_5="+String.valueOf(RT_BOL_ORDER_ID_5));
		sb.append(",RT_BOL_ORDER_ID_6="+String.valueOf(RT_BOL_ORDER_ID_6));
		sb.append(",RT_BOL_ORDER_ID_7="+String.valueOf(RT_BOL_ORDER_ID_7));
		sb.append(",RT_BOL_ORDER_ID_8="+String.valueOf(RT_BOL_ORDER_ID_8));
		sb.append(",RT_BOL_ORDER_ID_9="+String.valueOf(RT_BOL_ORDER_ID_9));
		sb.append(",RT_CARDED_IN="+String.valueOf(RT_CARDED_IN));
		sb.append(",LAST_USER_NAME="+LAST_USER_NAME);
		sb.append(",RT_LAST_USED_TRACTOR_CARRIER="+String.valueOf(RT_LAST_USED_TRACTOR_CARRIER));
		sb.append(",LAST_MODIFIED="+String.valueOf(LAST_MODIFIED));
		sb.append(",RT_LAST_USED_TRACTOR="+String.valueOf(RT_LAST_USED_TRACTOR));
		sb.append(",NEXT_ORDER_ONLY="+String.valueOf(NEXT_ORDER_ONLY));
		sb.append(",RT_HISTORICAL_ORDER_ID="+String.valueOf(RT_HISTORICAL_ORDER_ID));
		sb.append(",CANCEL_ORDER="+String.valueOf(CANCEL_ORDER));
		sb.append(",CARD_NUMBER="+CARD_NUMBER);
		sb.append(",MULTI_LOADING_LIMIT="+String.valueOf(MULTI_LOADING_LIMIT));
		sb.append(",RECENT_CUSTOMER_LIST_ENABLE="+String.valueOf(RECENT_CUSTOMER_LIST_ENABLE));
		sb.append(",REPEAT_LAST_COMM_INFO="+String.valueOf(REPEAT_LAST_COMM_INFO));
		sb.append(",REPEAT_LAST_COMPART_INFO="+String.valueOf(REPEAT_LAST_COMPART_INFO));
		sb.append(",GLOBAL_LOCKOUT="+String.valueOf(GLOBAL_LOCKOUT));
		sb.append(",GLOBAL_LOCKOUT_REASON="+GLOBAL_LOCKOUT_REASON);
		sb.append(",GLOBAL_LOCKOUT_USER="+GLOBAL_LOCKOUT_USER);
		sb.append(",GLOBAL_LOCKOUT_TERMINAL_ID="+String.valueOf(GLOBAL_LOCKOUT_TERMINAL_ID));
		sb.append(",LOCKOUT_DUE_TO_TRAILER_MISUSE="+String.valueOf(LOCKOUT_DUE_TO_TRAILER_MISUSE));
		sb.append(",TOLERANCE_ANNUNCIATION_ENABLE="+String.valueOf(TOLERANCE_ANNUNCIATION_ENABLE));
		sb.append(",MULTI_TRAILER_ENABLED="+String.valueOf(MULTI_TRAILER_ENABLED));
		sb.append(",RT_CURRENT_VISIT_ID="+String.valueOf(RT_CURRENT_VISIT_ID));
		sb.append(",RT_LAST_USED_VEHICLE_CARRIER="+String.valueOf(RT_LAST_USED_VEHICLE_CARRIER));
		sb.append(",RT_LAST_USED_VEHICLE="+RT_LAST_USED_VEHICLE);
		sb.append(",PDXR_RACK_DRIVER_ID="+PDXR_RACK_DRIVER_ID);
		sb.append(",LANGUAGE="+String.valueOf(LANGUAGE));
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
    final static byte[] commonByteArrayLock_PGS_STAGE_DIM_DRIVER = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_DIM_DRIVER = new byte[0];

	
			    public Integer RT_LAST_USED_CARRIER;

				public Integer getRT_LAST_USED_CARRIER () {
					return this.RT_LAST_USED_CARRIER;
				}
				
			    public int CARRIER_NUMBER;

				public int getCARRIER_NUMBER () {
					return this.CARRIER_NUMBER;
				}
				
			    public int DRIVER_NUMBER;

				public int getDRIVER_NUMBER () {
					return this.DRIVER_NUMBER;
				}
				
			    public String NAME;

				public String getNAME () {
					return this.NAME;
				}
				
			    public String RT_LAST_USED_TRAILER;

				public String getRT_LAST_USED_TRAILER () {
					return this.RT_LAST_USED_TRAILER;
				}
				
			    public String INITIALS;

				public String getINITIALS () {
					return this.INITIALS;
				}
				
			    public int LOCKOUT_LOADING;

				public int getLOCKOUT_LOADING () {
					return this.LOCKOUT_LOADING;
				}
				
			    public String LICENSE_NUMBER;

				public String getLICENSE_NUMBER () {
					return this.LICENSE_NUMBER;
				}
				
			    public String LOCKOUT_LOADING_REASON;

				public String getLOCKOUT_LOADING_REASON () {
					return this.LOCKOUT_LOADING_REASON;
				}
				
			    public int LOCKOUT_ENTRY;

				public int getLOCKOUT_ENTRY () {
					return this.LOCKOUT_ENTRY;
				}
				
			    public String LOCKOUT_ENTRY_REASON;

				public String getLOCKOUT_ENTRY_REASON () {
					return this.LOCKOUT_ENTRY_REASON;
				}
				
			    public int MULTI_PRODUCT_LOADING;

				public int getMULTI_PRODUCT_LOADING () {
					return this.MULTI_PRODUCT_LOADING;
				}
				
			    public String BOL_COMMENT_1;

				public String getBOL_COMMENT_1 () {
					return this.BOL_COMMENT_1;
				}
				
			    public String BOL_COMMENT_2;

				public String getBOL_COMMENT_2 () {
					return this.BOL_COMMENT_2;
				}
				
			    public Integer RT_CURRENT_ORDER_ID;

				public Integer getRT_CURRENT_ORDER_ID () {
					return this.RT_CURRENT_ORDER_ID;
				}
				
			    public Integer RT_LAST_ORDER_ID;

				public Integer getRT_LAST_ORDER_ID () {
					return this.RT_LAST_ORDER_ID;
				}
				
			    public int FUEL_TRACTOR;

				public int getFUEL_TRACTOR () {
					return this.FUEL_TRACTOR;
				}
				
			    public int ENTER_TERMINAL;

				public int getENTER_TERMINAL () {
					return this.ENTER_TERMINAL;
				}
				
			    public Integer RT_BOL_ORDER_ID_1;

				public Integer getRT_BOL_ORDER_ID_1 () {
					return this.RT_BOL_ORDER_ID_1;
				}
				
			    public Integer RT_BOL_ORDER_ID_2;

				public Integer getRT_BOL_ORDER_ID_2 () {
					return this.RT_BOL_ORDER_ID_2;
				}
				
			    public int METER_PROVER;

				public int getMETER_PROVER () {
					return this.METER_PROVER;
				}
				
			    public Integer RT_BOL_ORDER_ID_3;

				public Integer getRT_BOL_ORDER_ID_3 () {
					return this.RT_BOL_ORDER_ID_3;
				}
				
			    public int METER_TOTALIZER;

				public int getMETER_TOTALIZER () {
					return this.METER_TOTALIZER;
				}
				
			    public Integer RT_BOL_ORDER_ID_4;

				public Integer getRT_BOL_ORDER_ID_4 () {
					return this.RT_BOL_ORDER_ID_4;
				}
				
			    public Integer RT_BOL_ORDER_ID_5;

				public Integer getRT_BOL_ORDER_ID_5 () {
					return this.RT_BOL_ORDER_ID_5;
				}
				
			    public Integer RT_BOL_ORDER_ID_6;

				public Integer getRT_BOL_ORDER_ID_6 () {
					return this.RT_BOL_ORDER_ID_6;
				}
				
			    public Integer RT_BOL_ORDER_ID_7;

				public Integer getRT_BOL_ORDER_ID_7 () {
					return this.RT_BOL_ORDER_ID_7;
				}
				
			    public Integer RT_BOL_ORDER_ID_8;

				public Integer getRT_BOL_ORDER_ID_8 () {
					return this.RT_BOL_ORDER_ID_8;
				}
				
			    public Integer RT_BOL_ORDER_ID_9;

				public Integer getRT_BOL_ORDER_ID_9 () {
					return this.RT_BOL_ORDER_ID_9;
				}
				
			    public int RT_CARDED_IN;

				public int getRT_CARDED_IN () {
					return this.RT_CARDED_IN;
				}
				
			    public String LAST_USER_NAME;

				public String getLAST_USER_NAME () {
					return this.LAST_USER_NAME;
				}
				
			    public Integer RT_LAST_USED_TRACTOR_CARRIER;

				public Integer getRT_LAST_USED_TRACTOR_CARRIER () {
					return this.RT_LAST_USED_TRACTOR_CARRIER;
				}
				
			    public java.util.Date LAST_MODIFIED;

				public java.util.Date getLAST_MODIFIED () {
					return this.LAST_MODIFIED;
				}
				
			    public Integer RT_LAST_USED_TRACTOR;

				public Integer getRT_LAST_USED_TRACTOR () {
					return this.RT_LAST_USED_TRACTOR;
				}
				
			    public int NEXT_ORDER_ONLY;

				public int getNEXT_ORDER_ONLY () {
					return this.NEXT_ORDER_ONLY;
				}
				
			    public Integer RT_HISTORICAL_ORDER_ID;

				public Integer getRT_HISTORICAL_ORDER_ID () {
					return this.RT_HISTORICAL_ORDER_ID;
				}
				
			    public int CANCEL_ORDER;

				public int getCANCEL_ORDER () {
					return this.CANCEL_ORDER;
				}
				
			    public String CARD_NUMBER;

				public String getCARD_NUMBER () {
					return this.CARD_NUMBER;
				}
				
			    public int MULTI_LOADING_LIMIT;

				public int getMULTI_LOADING_LIMIT () {
					return this.MULTI_LOADING_LIMIT;
				}
				
			    public int RECENT_CUSTOMER_LIST_ENABLE;

				public int getRECENT_CUSTOMER_LIST_ENABLE () {
					return this.RECENT_CUSTOMER_LIST_ENABLE;
				}
				
			    public int REPEAT_LAST_COMM_INFO;

				public int getREPEAT_LAST_COMM_INFO () {
					return this.REPEAT_LAST_COMM_INFO;
				}
				
			    public int REPEAT_LAST_COMPART_INFO;

				public int getREPEAT_LAST_COMPART_INFO () {
					return this.REPEAT_LAST_COMPART_INFO;
				}
				
			    public int GLOBAL_LOCKOUT;

				public int getGLOBAL_LOCKOUT () {
					return this.GLOBAL_LOCKOUT;
				}
				
			    public String GLOBAL_LOCKOUT_REASON;

				public String getGLOBAL_LOCKOUT_REASON () {
					return this.GLOBAL_LOCKOUT_REASON;
				}
				
			    public String GLOBAL_LOCKOUT_USER;

				public String getGLOBAL_LOCKOUT_USER () {
					return this.GLOBAL_LOCKOUT_USER;
				}
				
			    public int GLOBAL_LOCKOUT_TERMINAL_ID;

				public int getGLOBAL_LOCKOUT_TERMINAL_ID () {
					return this.GLOBAL_LOCKOUT_TERMINAL_ID;
				}
				
			    public int LOCKOUT_DUE_TO_TRAILER_MISUSE;

				public int getLOCKOUT_DUE_TO_TRAILER_MISUSE () {
					return this.LOCKOUT_DUE_TO_TRAILER_MISUSE;
				}
				
			    public int TOLERANCE_ANNUNCIATION_ENABLE;

				public int getTOLERANCE_ANNUNCIATION_ENABLE () {
					return this.TOLERANCE_ANNUNCIATION_ENABLE;
				}
				
			    public int MULTI_TRAILER_ENABLED;

				public int getMULTI_TRAILER_ENABLED () {
					return this.MULTI_TRAILER_ENABLED;
				}
				
			    public Integer RT_CURRENT_VISIT_ID;

				public Integer getRT_CURRENT_VISIT_ID () {
					return this.RT_CURRENT_VISIT_ID;
				}
				
			    public Integer RT_LAST_USED_VEHICLE_CARRIER;

				public Integer getRT_LAST_USED_VEHICLE_CARRIER () {
					return this.RT_LAST_USED_VEHICLE_CARRIER;
				}
				
			    public String RT_LAST_USED_VEHICLE;

				public String getRT_LAST_USED_VEHICLE () {
					return this.RT_LAST_USED_VEHICLE;
				}
				
			    public String PDXR_RACK_DRIVER_ID;

				public String getPDXR_RACK_DRIVER_ID () {
					return this.PDXR_RACK_DRIVER_ID;
				}
				
			    public Integer LANGUAGE;

				public Integer getLANGUAGE () {
					return this.LANGUAGE;
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
			if(length > commonByteArray_PGS_STAGE_DIM_DRIVER.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_DRIVER.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_DRIVER = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_DRIVER = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PGS_STAGE_DIM_DRIVER, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_DRIVER, 0, length, utf8Charset);
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
			if(length > commonByteArray_PGS_STAGE_DIM_DRIVER.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_DRIVER.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_DRIVER = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_DRIVER = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PGS_STAGE_DIM_DRIVER, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_DRIVER, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_DRIVER) {

        	try {

        		int length = 0;
		
						this.RT_LAST_USED_CARRIER = readInteger(dis);
					
			        this.CARRIER_NUMBER = dis.readInt();
					
			        this.DRIVER_NUMBER = dis.readInt();
					
					this.NAME = readString(dis);
					
					this.RT_LAST_USED_TRAILER = readString(dis);
					
					this.INITIALS = readString(dis);
					
			        this.LOCKOUT_LOADING = dis.readInt();
					
					this.LICENSE_NUMBER = readString(dis);
					
					this.LOCKOUT_LOADING_REASON = readString(dis);
					
			        this.LOCKOUT_ENTRY = dis.readInt();
					
					this.LOCKOUT_ENTRY_REASON = readString(dis);
					
			        this.MULTI_PRODUCT_LOADING = dis.readInt();
					
					this.BOL_COMMENT_1 = readString(dis);
					
					this.BOL_COMMENT_2 = readString(dis);
					
						this.RT_CURRENT_ORDER_ID = readInteger(dis);
					
						this.RT_LAST_ORDER_ID = readInteger(dis);
					
			        this.FUEL_TRACTOR = dis.readInt();
					
			        this.ENTER_TERMINAL = dis.readInt();
					
						this.RT_BOL_ORDER_ID_1 = readInteger(dis);
					
						this.RT_BOL_ORDER_ID_2 = readInteger(dis);
					
			        this.METER_PROVER = dis.readInt();
					
						this.RT_BOL_ORDER_ID_3 = readInteger(dis);
					
			        this.METER_TOTALIZER = dis.readInt();
					
						this.RT_BOL_ORDER_ID_4 = readInteger(dis);
					
						this.RT_BOL_ORDER_ID_5 = readInteger(dis);
					
						this.RT_BOL_ORDER_ID_6 = readInteger(dis);
					
						this.RT_BOL_ORDER_ID_7 = readInteger(dis);
					
						this.RT_BOL_ORDER_ID_8 = readInteger(dis);
					
						this.RT_BOL_ORDER_ID_9 = readInteger(dis);
					
			        this.RT_CARDED_IN = dis.readInt();
					
					this.LAST_USER_NAME = readString(dis);
					
						this.RT_LAST_USED_TRACTOR_CARRIER = readInteger(dis);
					
					this.LAST_MODIFIED = readDate(dis);
					
						this.RT_LAST_USED_TRACTOR = readInteger(dis);
					
			        this.NEXT_ORDER_ONLY = dis.readInt();
					
						this.RT_HISTORICAL_ORDER_ID = readInteger(dis);
					
			        this.CANCEL_ORDER = dis.readInt();
					
					this.CARD_NUMBER = readString(dis);
					
			        this.MULTI_LOADING_LIMIT = dis.readInt();
					
			        this.RECENT_CUSTOMER_LIST_ENABLE = dis.readInt();
					
			        this.REPEAT_LAST_COMM_INFO = dis.readInt();
					
			        this.REPEAT_LAST_COMPART_INFO = dis.readInt();
					
			        this.GLOBAL_LOCKOUT = dis.readInt();
					
					this.GLOBAL_LOCKOUT_REASON = readString(dis);
					
					this.GLOBAL_LOCKOUT_USER = readString(dis);
					
			        this.GLOBAL_LOCKOUT_TERMINAL_ID = dis.readInt();
					
			        this.LOCKOUT_DUE_TO_TRAILER_MISUSE = dis.readInt();
					
			        this.TOLERANCE_ANNUNCIATION_ENABLE = dis.readInt();
					
			        this.MULTI_TRAILER_ENABLED = dis.readInt();
					
						this.RT_CURRENT_VISIT_ID = readInteger(dis);
					
						this.RT_LAST_USED_VEHICLE_CARRIER = readInteger(dis);
					
					this.RT_LAST_USED_VEHICLE = readString(dis);
					
					this.PDXR_RACK_DRIVER_ID = readString(dis);
					
						this.LANGUAGE = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_DRIVER) {

        	try {

        		int length = 0;
		
						this.RT_LAST_USED_CARRIER = readInteger(dis);
					
			        this.CARRIER_NUMBER = dis.readInt();
					
			        this.DRIVER_NUMBER = dis.readInt();
					
					this.NAME = readString(dis);
					
					this.RT_LAST_USED_TRAILER = readString(dis);
					
					this.INITIALS = readString(dis);
					
			        this.LOCKOUT_LOADING = dis.readInt();
					
					this.LICENSE_NUMBER = readString(dis);
					
					this.LOCKOUT_LOADING_REASON = readString(dis);
					
			        this.LOCKOUT_ENTRY = dis.readInt();
					
					this.LOCKOUT_ENTRY_REASON = readString(dis);
					
			        this.MULTI_PRODUCT_LOADING = dis.readInt();
					
					this.BOL_COMMENT_1 = readString(dis);
					
					this.BOL_COMMENT_2 = readString(dis);
					
						this.RT_CURRENT_ORDER_ID = readInteger(dis);
					
						this.RT_LAST_ORDER_ID = readInteger(dis);
					
			        this.FUEL_TRACTOR = dis.readInt();
					
			        this.ENTER_TERMINAL = dis.readInt();
					
						this.RT_BOL_ORDER_ID_1 = readInteger(dis);
					
						this.RT_BOL_ORDER_ID_2 = readInteger(dis);
					
			        this.METER_PROVER = dis.readInt();
					
						this.RT_BOL_ORDER_ID_3 = readInteger(dis);
					
			        this.METER_TOTALIZER = dis.readInt();
					
						this.RT_BOL_ORDER_ID_4 = readInteger(dis);
					
						this.RT_BOL_ORDER_ID_5 = readInteger(dis);
					
						this.RT_BOL_ORDER_ID_6 = readInteger(dis);
					
						this.RT_BOL_ORDER_ID_7 = readInteger(dis);
					
						this.RT_BOL_ORDER_ID_8 = readInteger(dis);
					
						this.RT_BOL_ORDER_ID_9 = readInteger(dis);
					
			        this.RT_CARDED_IN = dis.readInt();
					
					this.LAST_USER_NAME = readString(dis);
					
						this.RT_LAST_USED_TRACTOR_CARRIER = readInteger(dis);
					
					this.LAST_MODIFIED = readDate(dis);
					
						this.RT_LAST_USED_TRACTOR = readInteger(dis);
					
			        this.NEXT_ORDER_ONLY = dis.readInt();
					
						this.RT_HISTORICAL_ORDER_ID = readInteger(dis);
					
			        this.CANCEL_ORDER = dis.readInt();
					
					this.CARD_NUMBER = readString(dis);
					
			        this.MULTI_LOADING_LIMIT = dis.readInt();
					
			        this.RECENT_CUSTOMER_LIST_ENABLE = dis.readInt();
					
			        this.REPEAT_LAST_COMM_INFO = dis.readInt();
					
			        this.REPEAT_LAST_COMPART_INFO = dis.readInt();
					
			        this.GLOBAL_LOCKOUT = dis.readInt();
					
					this.GLOBAL_LOCKOUT_REASON = readString(dis);
					
					this.GLOBAL_LOCKOUT_USER = readString(dis);
					
			        this.GLOBAL_LOCKOUT_TERMINAL_ID = dis.readInt();
					
			        this.LOCKOUT_DUE_TO_TRAILER_MISUSE = dis.readInt();
					
			        this.TOLERANCE_ANNUNCIATION_ENABLE = dis.readInt();
					
			        this.MULTI_TRAILER_ENABLED = dis.readInt();
					
						this.RT_CURRENT_VISIT_ID = readInteger(dis);
					
						this.RT_LAST_USED_VEHICLE_CARRIER = readInteger(dis);
					
					this.RT_LAST_USED_VEHICLE = readString(dis);
					
					this.PDXR_RACK_DRIVER_ID = readString(dis);
					
						this.LANGUAGE = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// Integer
				
						writeInteger(this.RT_LAST_USED_CARRIER,dos);
					
					// int
				
		            	dos.writeInt(this.CARRIER_NUMBER);
					
					// int
				
		            	dos.writeInt(this.DRIVER_NUMBER);
					
					// String
				
						writeString(this.NAME,dos);
					
					// String
				
						writeString(this.RT_LAST_USED_TRAILER,dos);
					
					// String
				
						writeString(this.INITIALS,dos);
					
					// int
				
		            	dos.writeInt(this.LOCKOUT_LOADING);
					
					// String
				
						writeString(this.LICENSE_NUMBER,dos);
					
					// String
				
						writeString(this.LOCKOUT_LOADING_REASON,dos);
					
					// int
				
		            	dos.writeInt(this.LOCKOUT_ENTRY);
					
					// String
				
						writeString(this.LOCKOUT_ENTRY_REASON,dos);
					
					// int
				
		            	dos.writeInt(this.MULTI_PRODUCT_LOADING);
					
					// String
				
						writeString(this.BOL_COMMENT_1,dos);
					
					// String
				
						writeString(this.BOL_COMMENT_2,dos);
					
					// Integer
				
						writeInteger(this.RT_CURRENT_ORDER_ID,dos);
					
					// Integer
				
						writeInteger(this.RT_LAST_ORDER_ID,dos);
					
					// int
				
		            	dos.writeInt(this.FUEL_TRACTOR);
					
					// int
				
		            	dos.writeInt(this.ENTER_TERMINAL);
					
					// Integer
				
						writeInteger(this.RT_BOL_ORDER_ID_1,dos);
					
					// Integer
				
						writeInteger(this.RT_BOL_ORDER_ID_2,dos);
					
					// int
				
		            	dos.writeInt(this.METER_PROVER);
					
					// Integer
				
						writeInteger(this.RT_BOL_ORDER_ID_3,dos);
					
					// int
				
		            	dos.writeInt(this.METER_TOTALIZER);
					
					// Integer
				
						writeInteger(this.RT_BOL_ORDER_ID_4,dos);
					
					// Integer
				
						writeInteger(this.RT_BOL_ORDER_ID_5,dos);
					
					// Integer
				
						writeInteger(this.RT_BOL_ORDER_ID_6,dos);
					
					// Integer
				
						writeInteger(this.RT_BOL_ORDER_ID_7,dos);
					
					// Integer
				
						writeInteger(this.RT_BOL_ORDER_ID_8,dos);
					
					// Integer
				
						writeInteger(this.RT_BOL_ORDER_ID_9,dos);
					
					// int
				
		            	dos.writeInt(this.RT_CARDED_IN);
					
					// String
				
						writeString(this.LAST_USER_NAME,dos);
					
					// Integer
				
						writeInteger(this.RT_LAST_USED_TRACTOR_CARRIER,dos);
					
					// java.util.Date
				
						writeDate(this.LAST_MODIFIED,dos);
					
					// Integer
				
						writeInteger(this.RT_LAST_USED_TRACTOR,dos);
					
					// int
				
		            	dos.writeInt(this.NEXT_ORDER_ONLY);
					
					// Integer
				
						writeInteger(this.RT_HISTORICAL_ORDER_ID,dos);
					
					// int
				
		            	dos.writeInt(this.CANCEL_ORDER);
					
					// String
				
						writeString(this.CARD_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.MULTI_LOADING_LIMIT);
					
					// int
				
		            	dos.writeInt(this.RECENT_CUSTOMER_LIST_ENABLE);
					
					// int
				
		            	dos.writeInt(this.REPEAT_LAST_COMM_INFO);
					
					// int
				
		            	dos.writeInt(this.REPEAT_LAST_COMPART_INFO);
					
					// int
				
		            	dos.writeInt(this.GLOBAL_LOCKOUT);
					
					// String
				
						writeString(this.GLOBAL_LOCKOUT_REASON,dos);
					
					// String
				
						writeString(this.GLOBAL_LOCKOUT_USER,dos);
					
					// int
				
		            	dos.writeInt(this.GLOBAL_LOCKOUT_TERMINAL_ID);
					
					// int
				
		            	dos.writeInt(this.LOCKOUT_DUE_TO_TRAILER_MISUSE);
					
					// int
				
		            	dos.writeInt(this.TOLERANCE_ANNUNCIATION_ENABLE);
					
					// int
				
		            	dos.writeInt(this.MULTI_TRAILER_ENABLED);
					
					// Integer
				
						writeInteger(this.RT_CURRENT_VISIT_ID,dos);
					
					// Integer
				
						writeInteger(this.RT_LAST_USED_VEHICLE_CARRIER,dos);
					
					// String
				
						writeString(this.RT_LAST_USED_VEHICLE,dos);
					
					// String
				
						writeString(this.PDXR_RACK_DRIVER_ID,dos);
					
					// Integer
				
						writeInteger(this.LANGUAGE,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Integer
				
						writeInteger(this.RT_LAST_USED_CARRIER,dos);
					
					// int
				
		            	dos.writeInt(this.CARRIER_NUMBER);
					
					// int
				
		            	dos.writeInt(this.DRIVER_NUMBER);
					
					// String
				
						writeString(this.NAME,dos);
					
					// String
				
						writeString(this.RT_LAST_USED_TRAILER,dos);
					
					// String
				
						writeString(this.INITIALS,dos);
					
					// int
				
		            	dos.writeInt(this.LOCKOUT_LOADING);
					
					// String
				
						writeString(this.LICENSE_NUMBER,dos);
					
					// String
				
						writeString(this.LOCKOUT_LOADING_REASON,dos);
					
					// int
				
		            	dos.writeInt(this.LOCKOUT_ENTRY);
					
					// String
				
						writeString(this.LOCKOUT_ENTRY_REASON,dos);
					
					// int
				
		            	dos.writeInt(this.MULTI_PRODUCT_LOADING);
					
					// String
				
						writeString(this.BOL_COMMENT_1,dos);
					
					// String
				
						writeString(this.BOL_COMMENT_2,dos);
					
					// Integer
				
						writeInteger(this.RT_CURRENT_ORDER_ID,dos);
					
					// Integer
				
						writeInteger(this.RT_LAST_ORDER_ID,dos);
					
					// int
				
		            	dos.writeInt(this.FUEL_TRACTOR);
					
					// int
				
		            	dos.writeInt(this.ENTER_TERMINAL);
					
					// Integer
				
						writeInteger(this.RT_BOL_ORDER_ID_1,dos);
					
					// Integer
				
						writeInteger(this.RT_BOL_ORDER_ID_2,dos);
					
					// int
				
		            	dos.writeInt(this.METER_PROVER);
					
					// Integer
				
						writeInteger(this.RT_BOL_ORDER_ID_3,dos);
					
					// int
				
		            	dos.writeInt(this.METER_TOTALIZER);
					
					// Integer
				
						writeInteger(this.RT_BOL_ORDER_ID_4,dos);
					
					// Integer
				
						writeInteger(this.RT_BOL_ORDER_ID_5,dos);
					
					// Integer
				
						writeInteger(this.RT_BOL_ORDER_ID_6,dos);
					
					// Integer
				
						writeInteger(this.RT_BOL_ORDER_ID_7,dos);
					
					// Integer
				
						writeInteger(this.RT_BOL_ORDER_ID_8,dos);
					
					// Integer
				
						writeInteger(this.RT_BOL_ORDER_ID_9,dos);
					
					// int
				
		            	dos.writeInt(this.RT_CARDED_IN);
					
					// String
				
						writeString(this.LAST_USER_NAME,dos);
					
					// Integer
				
						writeInteger(this.RT_LAST_USED_TRACTOR_CARRIER,dos);
					
					// java.util.Date
				
						writeDate(this.LAST_MODIFIED,dos);
					
					// Integer
				
						writeInteger(this.RT_LAST_USED_TRACTOR,dos);
					
					// int
				
		            	dos.writeInt(this.NEXT_ORDER_ONLY);
					
					// Integer
				
						writeInteger(this.RT_HISTORICAL_ORDER_ID,dos);
					
					// int
				
		            	dos.writeInt(this.CANCEL_ORDER);
					
					// String
				
						writeString(this.CARD_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.MULTI_LOADING_LIMIT);
					
					// int
				
		            	dos.writeInt(this.RECENT_CUSTOMER_LIST_ENABLE);
					
					// int
				
		            	dos.writeInt(this.REPEAT_LAST_COMM_INFO);
					
					// int
				
		            	dos.writeInt(this.REPEAT_LAST_COMPART_INFO);
					
					// int
				
		            	dos.writeInt(this.GLOBAL_LOCKOUT);
					
					// String
				
						writeString(this.GLOBAL_LOCKOUT_REASON,dos);
					
					// String
				
						writeString(this.GLOBAL_LOCKOUT_USER,dos);
					
					// int
				
		            	dos.writeInt(this.GLOBAL_LOCKOUT_TERMINAL_ID);
					
					// int
				
		            	dos.writeInt(this.LOCKOUT_DUE_TO_TRAILER_MISUSE);
					
					// int
				
		            	dos.writeInt(this.TOLERANCE_ANNUNCIATION_ENABLE);
					
					// int
				
		            	dos.writeInt(this.MULTI_TRAILER_ENABLED);
					
					// Integer
				
						writeInteger(this.RT_CURRENT_VISIT_ID,dos);
					
					// Integer
				
						writeInteger(this.RT_LAST_USED_VEHICLE_CARRIER,dos);
					
					// String
				
						writeString(this.RT_LAST_USED_VEHICLE,dos);
					
					// String
				
						writeString(this.PDXR_RACK_DRIVER_ID,dos);
					
					// Integer
				
						writeInteger(this.LANGUAGE,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("RT_LAST_USED_CARRIER="+String.valueOf(RT_LAST_USED_CARRIER));
		sb.append(",CARRIER_NUMBER="+String.valueOf(CARRIER_NUMBER));
		sb.append(",DRIVER_NUMBER="+String.valueOf(DRIVER_NUMBER));
		sb.append(",NAME="+NAME);
		sb.append(",RT_LAST_USED_TRAILER="+RT_LAST_USED_TRAILER);
		sb.append(",INITIALS="+INITIALS);
		sb.append(",LOCKOUT_LOADING="+String.valueOf(LOCKOUT_LOADING));
		sb.append(",LICENSE_NUMBER="+LICENSE_NUMBER);
		sb.append(",LOCKOUT_LOADING_REASON="+LOCKOUT_LOADING_REASON);
		sb.append(",LOCKOUT_ENTRY="+String.valueOf(LOCKOUT_ENTRY));
		sb.append(",LOCKOUT_ENTRY_REASON="+LOCKOUT_ENTRY_REASON);
		sb.append(",MULTI_PRODUCT_LOADING="+String.valueOf(MULTI_PRODUCT_LOADING));
		sb.append(",BOL_COMMENT_1="+BOL_COMMENT_1);
		sb.append(",BOL_COMMENT_2="+BOL_COMMENT_2);
		sb.append(",RT_CURRENT_ORDER_ID="+String.valueOf(RT_CURRENT_ORDER_ID));
		sb.append(",RT_LAST_ORDER_ID="+String.valueOf(RT_LAST_ORDER_ID));
		sb.append(",FUEL_TRACTOR="+String.valueOf(FUEL_TRACTOR));
		sb.append(",ENTER_TERMINAL="+String.valueOf(ENTER_TERMINAL));
		sb.append(",RT_BOL_ORDER_ID_1="+String.valueOf(RT_BOL_ORDER_ID_1));
		sb.append(",RT_BOL_ORDER_ID_2="+String.valueOf(RT_BOL_ORDER_ID_2));
		sb.append(",METER_PROVER="+String.valueOf(METER_PROVER));
		sb.append(",RT_BOL_ORDER_ID_3="+String.valueOf(RT_BOL_ORDER_ID_3));
		sb.append(",METER_TOTALIZER="+String.valueOf(METER_TOTALIZER));
		sb.append(",RT_BOL_ORDER_ID_4="+String.valueOf(RT_BOL_ORDER_ID_4));
		sb.append(",RT_BOL_ORDER_ID_5="+String.valueOf(RT_BOL_ORDER_ID_5));
		sb.append(",RT_BOL_ORDER_ID_6="+String.valueOf(RT_BOL_ORDER_ID_6));
		sb.append(",RT_BOL_ORDER_ID_7="+String.valueOf(RT_BOL_ORDER_ID_7));
		sb.append(",RT_BOL_ORDER_ID_8="+String.valueOf(RT_BOL_ORDER_ID_8));
		sb.append(",RT_BOL_ORDER_ID_9="+String.valueOf(RT_BOL_ORDER_ID_9));
		sb.append(",RT_CARDED_IN="+String.valueOf(RT_CARDED_IN));
		sb.append(",LAST_USER_NAME="+LAST_USER_NAME);
		sb.append(",RT_LAST_USED_TRACTOR_CARRIER="+String.valueOf(RT_LAST_USED_TRACTOR_CARRIER));
		sb.append(",LAST_MODIFIED="+String.valueOf(LAST_MODIFIED));
		sb.append(",RT_LAST_USED_TRACTOR="+String.valueOf(RT_LAST_USED_TRACTOR));
		sb.append(",NEXT_ORDER_ONLY="+String.valueOf(NEXT_ORDER_ONLY));
		sb.append(",RT_HISTORICAL_ORDER_ID="+String.valueOf(RT_HISTORICAL_ORDER_ID));
		sb.append(",CANCEL_ORDER="+String.valueOf(CANCEL_ORDER));
		sb.append(",CARD_NUMBER="+CARD_NUMBER);
		sb.append(",MULTI_LOADING_LIMIT="+String.valueOf(MULTI_LOADING_LIMIT));
		sb.append(",RECENT_CUSTOMER_LIST_ENABLE="+String.valueOf(RECENT_CUSTOMER_LIST_ENABLE));
		sb.append(",REPEAT_LAST_COMM_INFO="+String.valueOf(REPEAT_LAST_COMM_INFO));
		sb.append(",REPEAT_LAST_COMPART_INFO="+String.valueOf(REPEAT_LAST_COMPART_INFO));
		sb.append(",GLOBAL_LOCKOUT="+String.valueOf(GLOBAL_LOCKOUT));
		sb.append(",GLOBAL_LOCKOUT_REASON="+GLOBAL_LOCKOUT_REASON);
		sb.append(",GLOBAL_LOCKOUT_USER="+GLOBAL_LOCKOUT_USER);
		sb.append(",GLOBAL_LOCKOUT_TERMINAL_ID="+String.valueOf(GLOBAL_LOCKOUT_TERMINAL_ID));
		sb.append(",LOCKOUT_DUE_TO_TRAILER_MISUSE="+String.valueOf(LOCKOUT_DUE_TO_TRAILER_MISUSE));
		sb.append(",TOLERANCE_ANNUNCIATION_ENABLE="+String.valueOf(TOLERANCE_ANNUNCIATION_ENABLE));
		sb.append(",MULTI_TRAILER_ENABLED="+String.valueOf(MULTI_TRAILER_ENABLED));
		sb.append(",RT_CURRENT_VISIT_ID="+String.valueOf(RT_CURRENT_VISIT_ID));
		sb.append(",RT_LAST_USED_VEHICLE_CARRIER="+String.valueOf(RT_LAST_USED_VEHICLE_CARRIER));
		sb.append(",RT_LAST_USED_VEHICLE="+RT_LAST_USED_VEHICLE);
		sb.append(",PDXR_RACK_DRIVER_ID="+PDXR_RACK_DRIVER_ID);
		sb.append(",LANGUAGE="+String.valueOf(LANGUAGE));
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
        } else if (updateKeyCount_tDBOutput_1 == 10 && true) {
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

 
	final String decryptedPassword_tDBOutput_1 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:FwqGCuSs88DWkHNlYWDLQ1WtXyL7GnPyzVWw7yYQwE6ady9IqZU=");

    String dbPwd_tDBOutput_1 = decryptedPassword_tDBOutput_1;	
    conn_tDBOutput_1 = java.sql.DriverManager.getConnection(url_tDBOutput_1,dbUser_tDBOutput_1,dbPwd_tDBOutput_1);
	
		resourceMap.put("conn_tDBOutput_1", conn_tDBOutput_1);
	
        conn_tDBOutput_1.setAutoCommit(false);
        int commitEvery_tDBOutput_1 = 10000;
        int commitCounter_tDBOutput_1 = 0;


if(dbschema_tDBOutput_1 == null || dbschema_tDBOutput_1.trim().length() == 0) {
    tableName_tDBOutput_1 = "DIM_DRIVER";
} else {
    tableName_tDBOutput_1 = dbschema_tDBOutput_1 + "].[" + "DIM_DRIVER";
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
                                        stmtCreate_tDBOutput_1.execute("CREATE TABLE [" + tableName_tDBOutput_1 + "]([PK_DRIVER] INT ,[RT_LAST_USED_CARRIER] INT ,[CARRIER_NUMBER] INT  not null ,[DRIVER_NUMBER] INT  not null ,[NAME] VARCHAR(40)  ,[RT_LAST_USED_TRAILER] VARCHAR(20)  ,[RT_LAST_ORDER_ID] INT ,[LAST_MODIFIED] DATETIME ,[RT_HISTORICAL_ORDER_ID] INT ,[RT_CURRENT_VISIT_ID] INT ,primary key([PK_DRIVER]))");
                                    }
                                }
        java.sql.PreparedStatement pstmt_tDBOutput_1 = conn_tDBOutput_1.prepareStatement("SELECT COUNT(1) FROM [" + tableName_tDBOutput_1 + "] WHERE [PK_DRIVER] = ?");
        resourceMap.put("pstmt_tDBOutput_1", pstmt_tDBOutput_1);
        String insert_tDBOutput_1 = "INSERT INTO [" + tableName_tDBOutput_1 + "] ([PK_DRIVER],[RT_LAST_USED_CARRIER],[CARRIER_NUMBER],[DRIVER_NUMBER],[NAME],[RT_LAST_USED_TRAILER],[RT_LAST_ORDER_ID],[LAST_MODIFIED],[RT_HISTORICAL_ORDER_ID],[RT_CURRENT_VISIT_ID]) VALUES (?,?,?,?,?,?,?,?,?,?)";
        java.sql.PreparedStatement pstmtInsert_tDBOutput_1 = conn_tDBOutput_1.prepareStatement(insert_tDBOutput_1);
        resourceMap.put("pstmtInsert_tDBOutput_1", pstmtInsert_tDBOutput_1);
        String update_tDBOutput_1 = "UPDATE [" + tableName_tDBOutput_1 + "] SET [RT_LAST_USED_CARRIER] = ?,[CARRIER_NUMBER] = ?,[DRIVER_NUMBER] = ?,[NAME] = ?,[RT_LAST_USED_TRAILER] = ?,[RT_LAST_ORDER_ID] = ?,[LAST_MODIFIED] = ?,[RT_HISTORICAL_ORDER_ID] = ?,[RT_CURRENT_VISIT_ID] = ? WHERE [PK_DRIVER] = ?";
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
	int PK_DRIVER;
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
	
	        
					int CARRIER_NUMBER;
					int DRIVER_NUMBER;        
	        
		    @Override
			public int hashCode() {
				if (this.hashCodeDirty) {
					final int prime = PRIME;
					int result = DEFAULT_HASHCODE;
			
									result = prime * result + (int) this.CARRIER_NUMBER;
									
									result = prime * result + (int) this.DRIVER_NUMBER;
									
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
				
									if (this.CARRIER_NUMBER != other.CARRIER_NUMBER) 
										return false;
								
									if (this.DRIVER_NUMBER != other.DRIVER_NUMBER) 
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
				
				 
	final String decryptedPassword_tDBInput_1 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:1Cl4k1LjJHdPfFzuG6FJoEB4263JTumc/izs1sooXwExKL6nFco=");
				
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

		    String dbquery_tDBInput_1 = "SELECT dbo.DRIVER.RT_LAST_USED_CARRIER,\n		dbo.DRIVER.CARRIER_NUMBER,\n		dbo.DRIVER.DRIVER_NUMBER,\n		dbo.DRIVER.NAME,\n		d"
+"bo.DRIVER.RT_LAST_USED_TRAILER,\n		dbo.DRIVER.INITIALS,\n		dbo.DRIVER.LOCKOUT_LOADING,\n		dbo.DRIVER.LICENSE_NUMBER,\n		dbo."
+"DRIVER.LOCKOUT_LOADING_REASON,\n		dbo.DRIVER.LOCKOUT_ENTRY,\n		dbo.DRIVER.LOCKOUT_ENTRY_REASON,\n		dbo.DRIVER.MULTI_PRODUCT"
+"_LOADING,\n		dbo.DRIVER.BOL_COMMENT_1,\n		dbo.DRIVER.BOL_COMMENT_2,\n		dbo.DRIVER.RT_CURRENT_ORDER_ID,\n		dbo.DRIVER.RT_LAST"
+"_ORDER_ID,\n		dbo.DRIVER.FUEL_TRACTOR,\n		dbo.DRIVER.ENTER_TERMINAL,\n		dbo.DRIVER.RT_BOL_ORDER_ID_1,\n		dbo.DRIVER.RT_BOL_O"
+"RDER_ID_2,\n		dbo.DRIVER.METER_PROVER,\n		dbo.DRIVER.RT_BOL_ORDER_ID_3,\n		dbo.DRIVER.METER_TOTALIZER,\n		dbo.DRIVER.RT_BOL_"
+"ORDER_ID_4,\n		dbo.DRIVER.RT_BOL_ORDER_ID_5,\n		dbo.DRIVER.RT_BOL_ORDER_ID_6,\n		dbo.DRIVER.RT_BOL_ORDER_ID_7,\n		dbo.DRIVER"
+".RT_BOL_ORDER_ID_8,\n		dbo.DRIVER.RT_BOL_ORDER_ID_9,\n		dbo.DRIVER.RT_CARDED_IN,\n		dbo.DRIVER.LAST_USER_NAME,\n		dbo.DRIVER"
+".RT_LAST_USED_TRACTOR_CARRIER,\n		dbo.DRIVER.LAST_MODIFIED,\n		dbo.DRIVER.RT_LAST_USED_TRACTOR,\n		dbo.DRIVER.NEXT_ORDER_ON"
+"LY,\n		dbo.DRIVER.RT_HISTORICAL_ORDER_ID,\n		dbo.DRIVER.CANCEL_ORDER,\n		dbo.DRIVER.CARD_NUMBER,\n		dbo.DRIVER.MULTI_LOADING"
+"_LIMIT,\n		dbo.DRIVER.RECENT_CUSTOMER_LIST_ENABLE,\n		dbo.DRIVER.REPEAT_LAST_COMM_INFO,\n		dbo.DRIVER.REPEAT_LAST_COMPART_I"
+"NFO,\n		dbo.DRIVER.GLOBAL_LOCKOUT,\n		dbo.DRIVER.GLOBAL_LOCKOUT_REASON,\n		dbo.DRIVER.GLOBAL_LOCKOUT_USER,\n		dbo.DRIVER.GLO"
+"BAL_LOCKOUT_TERMINAL_ID,\n		dbo.DRIVER.LOCKOUT_DUE_TO_TRAILER_MISUSE,\n		dbo.DRIVER.TOLERANCE_ANNUNCIATION_ENABLE,\n		dbo.D"
+"RIVER.MULTI_TRAILER_ENABLED,\n		dbo.DRIVER.RT_CURRENT_VISIT_ID,\n		dbo.DRIVER.RT_LAST_USED_VEHICLE_CARRIER,\n		dbo.DRIVER.R"
+"T_LAST_USED_VEHICLE,\n		dbo.DRIVER.PDXR_RACK_DRIVER_ID,\n		dbo.DRIVER.LANGUAGE\nFROM	dbo.DRIVER";
		    

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
								row1.RT_LAST_USED_CARRIER = null;
							} else {
		                          
            row1.RT_LAST_USED_CARRIER = rs_tDBInput_1.getInt(1);
            if(rs_tDBInput_1.wasNull()){
                    row1.RT_LAST_USED_CARRIER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 2) {
								row1.CARRIER_NUMBER = 0;
							} else {
		                          
            row1.CARRIER_NUMBER = rs_tDBInput_1.getInt(2);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 3) {
								row1.DRIVER_NUMBER = 0;
							} else {
		                          
            row1.DRIVER_NUMBER = rs_tDBInput_1.getInt(3);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 4) {
								row1.NAME = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(4);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(4).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.NAME = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.NAME = tmpContent_tDBInput_1;
                }
            } else {
                row1.NAME = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 5) {
								row1.RT_LAST_USED_TRAILER = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(5);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(5).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.RT_LAST_USED_TRAILER = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.RT_LAST_USED_TRAILER = tmpContent_tDBInput_1;
                }
            } else {
                row1.RT_LAST_USED_TRAILER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 6) {
								row1.INITIALS = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(6);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(6).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.INITIALS = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.INITIALS = tmpContent_tDBInput_1;
                }
            } else {
                row1.INITIALS = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 7) {
								row1.LOCKOUT_LOADING = 0;
							} else {
		                          
            row1.LOCKOUT_LOADING = rs_tDBInput_1.getInt(7);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 8) {
								row1.LICENSE_NUMBER = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(8);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(8).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.LICENSE_NUMBER = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.LICENSE_NUMBER = tmpContent_tDBInput_1;
                }
            } else {
                row1.LICENSE_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 9) {
								row1.LOCKOUT_LOADING_REASON = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(9);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(9).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.LOCKOUT_LOADING_REASON = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.LOCKOUT_LOADING_REASON = tmpContent_tDBInput_1;
                }
            } else {
                row1.LOCKOUT_LOADING_REASON = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 10) {
								row1.LOCKOUT_ENTRY = 0;
							} else {
		                          
            row1.LOCKOUT_ENTRY = rs_tDBInput_1.getInt(10);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 11) {
								row1.LOCKOUT_ENTRY_REASON = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(11);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(11).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.LOCKOUT_ENTRY_REASON = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.LOCKOUT_ENTRY_REASON = tmpContent_tDBInput_1;
                }
            } else {
                row1.LOCKOUT_ENTRY_REASON = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 12) {
								row1.MULTI_PRODUCT_LOADING = 0;
							} else {
		                          
            row1.MULTI_PRODUCT_LOADING = rs_tDBInput_1.getInt(12);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 13) {
								row1.BOL_COMMENT_1 = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(13);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(13).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.BOL_COMMENT_1 = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.BOL_COMMENT_1 = tmpContent_tDBInput_1;
                }
            } else {
                row1.BOL_COMMENT_1 = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 14) {
								row1.BOL_COMMENT_2 = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(14);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(14).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.BOL_COMMENT_2 = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.BOL_COMMENT_2 = tmpContent_tDBInput_1;
                }
            } else {
                row1.BOL_COMMENT_2 = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 15) {
								row1.RT_CURRENT_ORDER_ID = null;
							} else {
		                          
            row1.RT_CURRENT_ORDER_ID = rs_tDBInput_1.getInt(15);
            if(rs_tDBInput_1.wasNull()){
                    row1.RT_CURRENT_ORDER_ID = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 16) {
								row1.RT_LAST_ORDER_ID = null;
							} else {
		                          
            row1.RT_LAST_ORDER_ID = rs_tDBInput_1.getInt(16);
            if(rs_tDBInput_1.wasNull()){
                    row1.RT_LAST_ORDER_ID = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 17) {
								row1.FUEL_TRACTOR = 0;
							} else {
		                          
            row1.FUEL_TRACTOR = rs_tDBInput_1.getInt(17);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 18) {
								row1.ENTER_TERMINAL = 0;
							} else {
		                          
            row1.ENTER_TERMINAL = rs_tDBInput_1.getInt(18);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 19) {
								row1.RT_BOL_ORDER_ID_1 = null;
							} else {
		                          
            row1.RT_BOL_ORDER_ID_1 = rs_tDBInput_1.getInt(19);
            if(rs_tDBInput_1.wasNull()){
                    row1.RT_BOL_ORDER_ID_1 = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 20) {
								row1.RT_BOL_ORDER_ID_2 = null;
							} else {
		                          
            row1.RT_BOL_ORDER_ID_2 = rs_tDBInput_1.getInt(20);
            if(rs_tDBInput_1.wasNull()){
                    row1.RT_BOL_ORDER_ID_2 = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 21) {
								row1.METER_PROVER = 0;
							} else {
		                          
            row1.METER_PROVER = rs_tDBInput_1.getInt(21);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 22) {
								row1.RT_BOL_ORDER_ID_3 = null;
							} else {
		                          
            row1.RT_BOL_ORDER_ID_3 = rs_tDBInput_1.getInt(22);
            if(rs_tDBInput_1.wasNull()){
                    row1.RT_BOL_ORDER_ID_3 = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 23) {
								row1.METER_TOTALIZER = 0;
							} else {
		                          
            row1.METER_TOTALIZER = rs_tDBInput_1.getInt(23);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 24) {
								row1.RT_BOL_ORDER_ID_4 = null;
							} else {
		                          
            row1.RT_BOL_ORDER_ID_4 = rs_tDBInput_1.getInt(24);
            if(rs_tDBInput_1.wasNull()){
                    row1.RT_BOL_ORDER_ID_4 = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 25) {
								row1.RT_BOL_ORDER_ID_5 = null;
							} else {
		                          
            row1.RT_BOL_ORDER_ID_5 = rs_tDBInput_1.getInt(25);
            if(rs_tDBInput_1.wasNull()){
                    row1.RT_BOL_ORDER_ID_5 = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 26) {
								row1.RT_BOL_ORDER_ID_6 = null;
							} else {
		                          
            row1.RT_BOL_ORDER_ID_6 = rs_tDBInput_1.getInt(26);
            if(rs_tDBInput_1.wasNull()){
                    row1.RT_BOL_ORDER_ID_6 = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 27) {
								row1.RT_BOL_ORDER_ID_7 = null;
							} else {
		                          
            row1.RT_BOL_ORDER_ID_7 = rs_tDBInput_1.getInt(27);
            if(rs_tDBInput_1.wasNull()){
                    row1.RT_BOL_ORDER_ID_7 = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 28) {
								row1.RT_BOL_ORDER_ID_8 = null;
							} else {
		                          
            row1.RT_BOL_ORDER_ID_8 = rs_tDBInput_1.getInt(28);
            if(rs_tDBInput_1.wasNull()){
                    row1.RT_BOL_ORDER_ID_8 = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 29) {
								row1.RT_BOL_ORDER_ID_9 = null;
							} else {
		                          
            row1.RT_BOL_ORDER_ID_9 = rs_tDBInput_1.getInt(29);
            if(rs_tDBInput_1.wasNull()){
                    row1.RT_BOL_ORDER_ID_9 = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 30) {
								row1.RT_CARDED_IN = 0;
							} else {
		                          
            row1.RT_CARDED_IN = rs_tDBInput_1.getInt(30);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 31) {
								row1.LAST_USER_NAME = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(31);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(31).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.LAST_USER_NAME = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.LAST_USER_NAME = tmpContent_tDBInput_1;
                }
            } else {
                row1.LAST_USER_NAME = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 32) {
								row1.RT_LAST_USED_TRACTOR_CARRIER = null;
							} else {
		                          
            row1.RT_LAST_USED_TRACTOR_CARRIER = rs_tDBInput_1.getInt(32);
            if(rs_tDBInput_1.wasNull()){
                    row1.RT_LAST_USED_TRACTOR_CARRIER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 33) {
								row1.LAST_MODIFIED = null;
							} else {
										
			row1.LAST_MODIFIED = mssqlGTU_tDBInput_1.getDate(rsmd_tDBInput_1, rs_tDBInput_1, 33);
			
		                    }
							if(colQtyInRs_tDBInput_1 < 34) {
								row1.RT_LAST_USED_TRACTOR = null;
							} else {
		                          
            row1.RT_LAST_USED_TRACTOR = rs_tDBInput_1.getInt(34);
            if(rs_tDBInput_1.wasNull()){
                    row1.RT_LAST_USED_TRACTOR = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 35) {
								row1.NEXT_ORDER_ONLY = 0;
							} else {
		                          
            row1.NEXT_ORDER_ONLY = rs_tDBInput_1.getInt(35);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 36) {
								row1.RT_HISTORICAL_ORDER_ID = null;
							} else {
		                          
            row1.RT_HISTORICAL_ORDER_ID = rs_tDBInput_1.getInt(36);
            if(rs_tDBInput_1.wasNull()){
                    row1.RT_HISTORICAL_ORDER_ID = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 37) {
								row1.CANCEL_ORDER = 0;
							} else {
		                          
            row1.CANCEL_ORDER = rs_tDBInput_1.getInt(37);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 38) {
								row1.CARD_NUMBER = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(38);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(38).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.CARD_NUMBER = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.CARD_NUMBER = tmpContent_tDBInput_1;
                }
            } else {
                row1.CARD_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 39) {
								row1.MULTI_LOADING_LIMIT = 0;
							} else {
		                          
            row1.MULTI_LOADING_LIMIT = rs_tDBInput_1.getInt(39);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 40) {
								row1.RECENT_CUSTOMER_LIST_ENABLE = 0;
							} else {
		                          
            row1.RECENT_CUSTOMER_LIST_ENABLE = rs_tDBInput_1.getInt(40);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 41) {
								row1.REPEAT_LAST_COMM_INFO = 0;
							} else {
		                          
            row1.REPEAT_LAST_COMM_INFO = rs_tDBInput_1.getInt(41);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 42) {
								row1.REPEAT_LAST_COMPART_INFO = 0;
							} else {
		                          
            row1.REPEAT_LAST_COMPART_INFO = rs_tDBInput_1.getInt(42);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 43) {
								row1.GLOBAL_LOCKOUT = 0;
							} else {
		                          
            row1.GLOBAL_LOCKOUT = rs_tDBInput_1.getInt(43);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 44) {
								row1.GLOBAL_LOCKOUT_REASON = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(44);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(44).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.GLOBAL_LOCKOUT_REASON = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.GLOBAL_LOCKOUT_REASON = tmpContent_tDBInput_1;
                }
            } else {
                row1.GLOBAL_LOCKOUT_REASON = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 45) {
								row1.GLOBAL_LOCKOUT_USER = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(45);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(45).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.GLOBAL_LOCKOUT_USER = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.GLOBAL_LOCKOUT_USER = tmpContent_tDBInput_1;
                }
            } else {
                row1.GLOBAL_LOCKOUT_USER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 46) {
								row1.GLOBAL_LOCKOUT_TERMINAL_ID = 0;
							} else {
		                          
            row1.GLOBAL_LOCKOUT_TERMINAL_ID = rs_tDBInput_1.getInt(46);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 47) {
								row1.LOCKOUT_DUE_TO_TRAILER_MISUSE = 0;
							} else {
		                          
            row1.LOCKOUT_DUE_TO_TRAILER_MISUSE = rs_tDBInput_1.getInt(47);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 48) {
								row1.TOLERANCE_ANNUNCIATION_ENABLE = 0;
							} else {
		                          
            row1.TOLERANCE_ANNUNCIATION_ENABLE = rs_tDBInput_1.getInt(48);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 49) {
								row1.MULTI_TRAILER_ENABLED = 0;
							} else {
		                          
            row1.MULTI_TRAILER_ENABLED = rs_tDBInput_1.getInt(49);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 50) {
								row1.RT_CURRENT_VISIT_ID = null;
							} else {
		                          
            row1.RT_CURRENT_VISIT_ID = rs_tDBInput_1.getInt(50);
            if(rs_tDBInput_1.wasNull()){
                    row1.RT_CURRENT_VISIT_ID = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 51) {
								row1.RT_LAST_USED_VEHICLE_CARRIER = null;
							} else {
		                          
            row1.RT_LAST_USED_VEHICLE_CARRIER = rs_tDBInput_1.getInt(51);
            if(rs_tDBInput_1.wasNull()){
                    row1.RT_LAST_USED_VEHICLE_CARRIER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 52) {
								row1.RT_LAST_USED_VEHICLE = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(52);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(52).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.RT_LAST_USED_VEHICLE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.RT_LAST_USED_VEHICLE = tmpContent_tDBInput_1;
                }
            } else {
                row1.RT_LAST_USED_VEHICLE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 53) {
								row1.PDXR_RACK_DRIVER_ID = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(53);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(53).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.PDXR_RACK_DRIVER_ID = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.PDXR_RACK_DRIVER_ID = tmpContent_tDBInput_1;
                }
            } else {
                row1.PDXR_RACK_DRIVER_ID = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 54) {
								row1.LANGUAGE = null;
							} else {
		                          
            row1.LANGUAGE = rs_tDBInput_1.getInt(54);
            if(rs_tDBInput_1.wasNull()){
                    row1.LANGUAGE = null;
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
finder_tUniqRow_1.CARRIER_NUMBER = row1.CARRIER_NUMBER;
finder_tUniqRow_1.DRIVER_NUMBER = row1.DRIVER_NUMBER;	
finder_tUniqRow_1.hashCodeDirty = true;
if (!keystUniqRow_1.contains(finder_tUniqRow_1)) {
		KeyStruct_tUniqRow_1 new_tUniqRow_1 = new KeyStruct_tUniqRow_1();

		
new_tUniqRow_1.CARRIER_NUMBER = row1.CARRIER_NUMBER;
new_tUniqRow_1.DRIVER_NUMBER = row1.DRIVER_NUMBER;
		
		keystUniqRow_1.add(new_tUniqRow_1);if(row2 == null){ 
	
	row2 = new row2Struct();
}row2.RT_LAST_USED_CARRIER = row1.RT_LAST_USED_CARRIER;			row2.CARRIER_NUMBER = row1.CARRIER_NUMBER;			row2.DRIVER_NUMBER = row1.DRIVER_NUMBER;			row2.NAME = row1.NAME;			row2.RT_LAST_USED_TRAILER = row1.RT_LAST_USED_TRAILER;			row2.INITIALS = row1.INITIALS;			row2.LOCKOUT_LOADING = row1.LOCKOUT_LOADING;			row2.LICENSE_NUMBER = row1.LICENSE_NUMBER;			row2.LOCKOUT_LOADING_REASON = row1.LOCKOUT_LOADING_REASON;			row2.LOCKOUT_ENTRY = row1.LOCKOUT_ENTRY;			row2.LOCKOUT_ENTRY_REASON = row1.LOCKOUT_ENTRY_REASON;			row2.MULTI_PRODUCT_LOADING = row1.MULTI_PRODUCT_LOADING;			row2.BOL_COMMENT_1 = row1.BOL_COMMENT_1;			row2.BOL_COMMENT_2 = row1.BOL_COMMENT_2;			row2.RT_CURRENT_ORDER_ID = row1.RT_CURRENT_ORDER_ID;			row2.RT_LAST_ORDER_ID = row1.RT_LAST_ORDER_ID;			row2.FUEL_TRACTOR = row1.FUEL_TRACTOR;			row2.ENTER_TERMINAL = row1.ENTER_TERMINAL;			row2.RT_BOL_ORDER_ID_1 = row1.RT_BOL_ORDER_ID_1;			row2.RT_BOL_ORDER_ID_2 = row1.RT_BOL_ORDER_ID_2;			row2.METER_PROVER = row1.METER_PROVER;			row2.RT_BOL_ORDER_ID_3 = row1.RT_BOL_ORDER_ID_3;			row2.METER_TOTALIZER = row1.METER_TOTALIZER;			row2.RT_BOL_ORDER_ID_4 = row1.RT_BOL_ORDER_ID_4;			row2.RT_BOL_ORDER_ID_5 = row1.RT_BOL_ORDER_ID_5;			row2.RT_BOL_ORDER_ID_6 = row1.RT_BOL_ORDER_ID_6;			row2.RT_BOL_ORDER_ID_7 = row1.RT_BOL_ORDER_ID_7;			row2.RT_BOL_ORDER_ID_8 = row1.RT_BOL_ORDER_ID_8;			row2.RT_BOL_ORDER_ID_9 = row1.RT_BOL_ORDER_ID_9;			row2.RT_CARDED_IN = row1.RT_CARDED_IN;			row2.LAST_USER_NAME = row1.LAST_USER_NAME;			row2.RT_LAST_USED_TRACTOR_CARRIER = row1.RT_LAST_USED_TRACTOR_CARRIER;			row2.LAST_MODIFIED = row1.LAST_MODIFIED;			row2.RT_LAST_USED_TRACTOR = row1.RT_LAST_USED_TRACTOR;			row2.NEXT_ORDER_ONLY = row1.NEXT_ORDER_ONLY;			row2.RT_HISTORICAL_ORDER_ID = row1.RT_HISTORICAL_ORDER_ID;			row2.CANCEL_ORDER = row1.CANCEL_ORDER;			row2.CARD_NUMBER = row1.CARD_NUMBER;			row2.MULTI_LOADING_LIMIT = row1.MULTI_LOADING_LIMIT;			row2.RECENT_CUSTOMER_LIST_ENABLE = row1.RECENT_CUSTOMER_LIST_ENABLE;			row2.REPEAT_LAST_COMM_INFO = row1.REPEAT_LAST_COMM_INFO;			row2.REPEAT_LAST_COMPART_INFO = row1.REPEAT_LAST_COMPART_INFO;			row2.GLOBAL_LOCKOUT = row1.GLOBAL_LOCKOUT;			row2.GLOBAL_LOCKOUT_REASON = row1.GLOBAL_LOCKOUT_REASON;			row2.GLOBAL_LOCKOUT_USER = row1.GLOBAL_LOCKOUT_USER;			row2.GLOBAL_LOCKOUT_TERMINAL_ID = row1.GLOBAL_LOCKOUT_TERMINAL_ID;			row2.LOCKOUT_DUE_TO_TRAILER_MISUSE = row1.LOCKOUT_DUE_TO_TRAILER_MISUSE;			row2.TOLERANCE_ANNUNCIATION_ENABLE = row1.TOLERANCE_ANNUNCIATION_ENABLE;			row2.MULTI_TRAILER_ENABLED = row1.MULTI_TRAILER_ENABLED;			row2.RT_CURRENT_VISIT_ID = row1.RT_CURRENT_VISIT_ID;			row2.RT_LAST_USED_VEHICLE_CARRIER = row1.RT_LAST_USED_VEHICLE_CARRIER;			row2.RT_LAST_USED_VEHICLE = row1.RT_LAST_USED_VEHICLE;			row2.PDXR_RACK_DRIVER_ID = row1.PDXR_RACK_DRIVER_ID;			row2.LANGUAGE = row1.LANGUAGE;					
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
								
	                        		    	Object exprKeyValue_row3__CARRIER_NUMBER = row2.CARRIER_NUMBER ;
	                        		    	if(exprKeyValue_row3__CARRIER_NUMBER == null) {
	                        		    		hasCasePrimitiveKeyWithNull_tMap_1 = true;
	                        		    	} else {
                        		    			row3HashKey.CARRIER_NUMBER = (int)(Integer) exprKeyValue_row3__CARRIER_NUMBER;
                        		    		}
                        		    		
	                        		    	Object exprKeyValue_row3__DRIVER_NUMBER = row2.DRIVER_NUMBER ;
	                        		    	if(exprKeyValue_row3__DRIVER_NUMBER == null) {
	                        		    		hasCasePrimitiveKeyWithNull_tMap_1 = true;
	                        		    	} else {
                        		    			row3HashKey.DRIVER_NUMBER = (int)(Integer) exprKeyValue_row3__DRIVER_NUMBER;
                        		    		}
                        		    		

								
		                        	row3HashKey.hashCodeDirty = true;
                        		
	  					
	  							
	
		  							if(!hasCasePrimitiveKeyWithNull_tMap_1) { // G_TM_M_091
		  							
			  					
			  					
			  					
	  					
		  							tHash_Lookup_row3.lookup( row3HashKey );

	  							

	  							

			  						} // G_TM_M_091
			  						
			  					

 								
		  				
	  								
						
									
  									  		
 								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_row3 != null && tHash_Lookup_row3.getCount(row3HashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row3' and it contains more one result from keys :  row3.CARRIER_NUMBER = '" + row3HashKey.CARRIER_NUMBER + "', row3.DRIVER_NUMBER = '" + row3HashKey.DRIVER_NUMBER + "'");
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
Var.PK_DRIVER = Numeric.sequence("s16",1,1) ;// ###############################
        // ###############################
        // # Output tables

out2 = null;


// # Output table : 'out2'
out2_tmp.PK_DRIVER = Var.PK_DRIVER ;
out2_tmp.RT_LAST_USED_CARRIER = row2.RT_LAST_USED_CARRIER ;
out2_tmp.CARRIER_NUMBER = row2.CARRIER_NUMBER ;
out2_tmp.DRIVER_NUMBER = row2.DRIVER_NUMBER ;
out2_tmp.NAME = row2.NAME ;
out2_tmp.RT_LAST_USED_TRAILER = row2.RT_LAST_USED_TRAILER ;
out2_tmp.RT_LAST_ORDER_ID = row2.RT_LAST_ORDER_ID ;
out2_tmp.LAST_MODIFIED = row2.LAST_MODIFIED ;
out2_tmp.RT_HISTORICAL_ORDER_ID = row2.RT_HISTORICAL_ORDER_ID ;
out2_tmp.RT_CURRENT_VISIT_ID = row2.RT_CURRENT_VISIT_ID ;
out2 = out2_tmp;
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


                    if(out2.PK_DRIVER == null) {
pstmt_tDBOutput_1.setNull(1, java.sql.Types.INTEGER);
} else {pstmt_tDBOutput_1.setInt(1, out2.PK_DRIVER);
}

            int checkCount_tDBOutput_1 = -1;
            try (java.sql.ResultSet rs_tDBOutput_1 = pstmt_tDBOutput_1.executeQuery()) {
                while(rs_tDBOutput_1.next()) {
                    checkCount_tDBOutput_1 = rs_tDBOutput_1.getInt(1);
                }
            }
            if(checkCount_tDBOutput_1 > 0) {
                        if(out2.RT_LAST_USED_CARRIER == null) {
pstmtUpdate_tDBOutput_1.setNull(1, java.sql.Types.INTEGER);
} else {pstmtUpdate_tDBOutput_1.setInt(1, out2.RT_LAST_USED_CARRIER);
}

                        pstmtUpdate_tDBOutput_1.setInt(2, out2.CARRIER_NUMBER);

                        pstmtUpdate_tDBOutput_1.setInt(3, out2.DRIVER_NUMBER);

                        if(out2.NAME == null) {
pstmtUpdate_tDBOutput_1.setNull(4, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(4, out2.NAME);
}

                        if(out2.RT_LAST_USED_TRAILER == null) {
pstmtUpdate_tDBOutput_1.setNull(5, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(5, out2.RT_LAST_USED_TRAILER);
}

                        if(out2.RT_LAST_ORDER_ID == null) {
pstmtUpdate_tDBOutput_1.setNull(6, java.sql.Types.INTEGER);
} else {pstmtUpdate_tDBOutput_1.setInt(6, out2.RT_LAST_ORDER_ID);
}

                        if(out2.LAST_MODIFIED != null) {
pstmtUpdate_tDBOutput_1.setTimestamp(7, new java.sql.Timestamp(out2.LAST_MODIFIED.getTime()));
} else {
pstmtUpdate_tDBOutput_1.setNull(7, java.sql.Types.TIMESTAMP);
}

                        if(out2.RT_HISTORICAL_ORDER_ID == null) {
pstmtUpdate_tDBOutput_1.setNull(8, java.sql.Types.INTEGER);
} else {pstmtUpdate_tDBOutput_1.setInt(8, out2.RT_HISTORICAL_ORDER_ID);
}

                        if(out2.RT_CURRENT_VISIT_ID == null) {
pstmtUpdate_tDBOutput_1.setNull(9, java.sql.Types.INTEGER);
} else {pstmtUpdate_tDBOutput_1.setInt(9, out2.RT_CURRENT_VISIT_ID);
}


	                    

                        if(out2.PK_DRIVER == null) {
pstmtUpdate_tDBOutput_1.setNull(10 + count_tDBOutput_1, java.sql.Types.INTEGER);
} else {pstmtUpdate_tDBOutput_1.setInt(10 + count_tDBOutput_1, out2.PK_DRIVER);
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
                        if(out2.PK_DRIVER == null) {
pstmtInsert_tDBOutput_1.setNull(1, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_1.setInt(1, out2.PK_DRIVER);
}

                        if(out2.RT_LAST_USED_CARRIER == null) {
pstmtInsert_tDBOutput_1.setNull(2, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_1.setInt(2, out2.RT_LAST_USED_CARRIER);
}

                        pstmtInsert_tDBOutput_1.setInt(3, out2.CARRIER_NUMBER);

                        pstmtInsert_tDBOutput_1.setInt(4, out2.DRIVER_NUMBER);

                        if(out2.NAME == null) {
pstmtInsert_tDBOutput_1.setNull(5, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(5, out2.NAME);
}

                        if(out2.RT_LAST_USED_TRAILER == null) {
pstmtInsert_tDBOutput_1.setNull(6, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(6, out2.RT_LAST_USED_TRAILER);
}

                        if(out2.RT_LAST_ORDER_ID == null) {
pstmtInsert_tDBOutput_1.setNull(7, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_1.setInt(7, out2.RT_LAST_ORDER_ID);
}

                        if(out2.LAST_MODIFIED != null) {
pstmtInsert_tDBOutput_1.setTimestamp(8, new java.sql.Timestamp(out2.LAST_MODIFIED.getTime()));
} else {
pstmtInsert_tDBOutput_1.setNull(8, java.sql.Types.TIMESTAMP);
}

                        if(out2.RT_HISTORICAL_ORDER_ID == null) {
pstmtInsert_tDBOutput_1.setNull(9, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_1.setInt(9, out2.RT_HISTORICAL_ORDER_ID);
}

                        if(out2.RT_CURRENT_VISIT_ID == null) {
pstmtInsert_tDBOutput_1.setNull(10, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_1.setInt(10, out2.RT_CURRENT_VISIT_ID);
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
    final static byte[] commonByteArrayLock_PGS_STAGE_DIM_DRIVER = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_DIM_DRIVER = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public int PK_DRIVER;

				public int getPK_DRIVER () {
					return this.PK_DRIVER;
				}
				
			    public Integer RT_LAST_USED_CARRIER;

				public Integer getRT_LAST_USED_CARRIER () {
					return this.RT_LAST_USED_CARRIER;
				}
				
			    public int CARRIER_NUMBER;

				public int getCARRIER_NUMBER () {
					return this.CARRIER_NUMBER;
				}
				
			    public int DRIVER_NUMBER;

				public int getDRIVER_NUMBER () {
					return this.DRIVER_NUMBER;
				}
				
			    public String NAME;

				public String getNAME () {
					return this.NAME;
				}
				
			    public String RT_LAST_USED_TRAILER;

				public String getRT_LAST_USED_TRAILER () {
					return this.RT_LAST_USED_TRAILER;
				}
				
			    public Integer RT_LAST_ORDER_ID;

				public Integer getRT_LAST_ORDER_ID () {
					return this.RT_LAST_ORDER_ID;
				}
				
			    public java.util.Date LAST_MODIFIED;

				public java.util.Date getLAST_MODIFIED () {
					return this.LAST_MODIFIED;
				}
				
			    public Integer RT_HISTORICAL_ORDER_ID;

				public Integer getRT_HISTORICAL_ORDER_ID () {
					return this.RT_HISTORICAL_ORDER_ID;
				}
				
			    public Integer RT_CURRENT_VISIT_ID;

				public Integer getRT_CURRENT_VISIT_ID () {
					return this.RT_CURRENT_VISIT_ID;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
							result = prime * result + (int) this.CARRIER_NUMBER;
						
							result = prime * result + (int) this.DRIVER_NUMBER;
						
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
		
						if (this.CARRIER_NUMBER != other.CARRIER_NUMBER)
							return false;
					
						if (this.DRIVER_NUMBER != other.DRIVER_NUMBER)
							return false;
					

		return true;
    }

	public void copyDataTo(row3Struct other) {

		other.PK_DRIVER = this.PK_DRIVER;
	            other.RT_LAST_USED_CARRIER = this.RT_LAST_USED_CARRIER;
	            other.CARRIER_NUMBER = this.CARRIER_NUMBER;
	            other.DRIVER_NUMBER = this.DRIVER_NUMBER;
	            other.NAME = this.NAME;
	            other.RT_LAST_USED_TRAILER = this.RT_LAST_USED_TRAILER;
	            other.RT_LAST_ORDER_ID = this.RT_LAST_ORDER_ID;
	            other.LAST_MODIFIED = this.LAST_MODIFIED;
	            other.RT_HISTORICAL_ORDER_ID = this.RT_HISTORICAL_ORDER_ID;
	            other.RT_CURRENT_VISIT_ID = this.RT_CURRENT_VISIT_ID;
	            
	}

	public void copyKeysDataTo(row3Struct other) {

		other.CARRIER_NUMBER = this.CARRIER_NUMBER;
	            	other.DRIVER_NUMBER = this.DRIVER_NUMBER;
	            	
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

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_DRIVER) {

        	try {

        		int length = 0;
		
			        this.CARRIER_NUMBER = dis.readInt();
					
			        this.DRIVER_NUMBER = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_DRIVER) {

        	try {

        		int length = 0;
		
			        this.CARRIER_NUMBER = dis.readInt();
					
			        this.DRIVER_NUMBER = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.CARRIER_NUMBER);
					
					// int
				
		            	dos.writeInt(this.DRIVER_NUMBER);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.CARRIER_NUMBER);
					
					// int
				
		            	dos.writeInt(this.DRIVER_NUMBER);
					
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
		
			            this.PK_DRIVER = dis.readInt();
					
						this.RT_LAST_USED_CARRIER = readInteger(dis,ois);
					
						this.NAME = readString(dis,ois);
					
						this.RT_LAST_USED_TRAILER = readString(dis,ois);
					
						this.RT_LAST_ORDER_ID = readInteger(dis,ois);
					
						this.LAST_MODIFIED = readDate(dis,ois);
					
						this.RT_HISTORICAL_ORDER_ID = readInteger(dis,ois);
					
						this.RT_CURRENT_VISIT_ID = readInteger(dis,ois);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
			            this.PK_DRIVER = objectIn.readInt();
					
						this.RT_LAST_USED_CARRIER = readInteger(dis,objectIn);
					
						this.NAME = readString(dis,objectIn);
					
						this.RT_LAST_USED_TRAILER = readString(dis,objectIn);
					
						this.RT_LAST_ORDER_ID = readInteger(dis,objectIn);
					
						this.LAST_MODIFIED = readDate(dis,objectIn);
					
						this.RT_HISTORICAL_ORDER_ID = readInteger(dis,objectIn);
					
						this.RT_CURRENT_VISIT_ID = readInteger(dis,objectIn);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
		            	dos.writeInt(this.PK_DRIVER);
					
					writeInteger(this.RT_LAST_USED_CARRIER, dos, oos);
					
						writeString(this.NAME, dos, oos);
					
						writeString(this.RT_LAST_USED_TRAILER, dos, oos);
					
					writeInteger(this.RT_LAST_ORDER_ID, dos, oos);
					
						writeDate(this.LAST_MODIFIED, dos, oos);
					
					writeInteger(this.RT_HISTORICAL_ORDER_ID, dos, oos);
					
					writeInteger(this.RT_CURRENT_VISIT_ID, dos, oos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
					objectOut.writeInt(this.PK_DRIVER);
					
					writeInteger(this.RT_LAST_USED_CARRIER, dos, objectOut);
					
						writeString(this.NAME, dos, objectOut);
					
						writeString(this.RT_LAST_USED_TRAILER, dos, objectOut);
					
					writeInteger(this.RT_LAST_ORDER_ID, dos, objectOut);
					
						writeDate(this.LAST_MODIFIED, dos, objectOut);
					
					writeInteger(this.RT_HISTORICAL_ORDER_ID, dos, objectOut);
					
					writeInteger(this.RT_CURRENT_VISIT_ID, dos, objectOut);
					
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
		sb.append("PK_DRIVER="+String.valueOf(PK_DRIVER));
		sb.append(",RT_LAST_USED_CARRIER="+String.valueOf(RT_LAST_USED_CARRIER));
		sb.append(",CARRIER_NUMBER="+String.valueOf(CARRIER_NUMBER));
		sb.append(",DRIVER_NUMBER="+String.valueOf(DRIVER_NUMBER));
		sb.append(",NAME="+NAME);
		sb.append(",RT_LAST_USED_TRAILER="+RT_LAST_USED_TRAILER);
		sb.append(",RT_LAST_ORDER_ID="+String.valueOf(RT_LAST_ORDER_ID));
		sb.append(",LAST_MODIFIED="+String.valueOf(LAST_MODIFIED));
		sb.append(",RT_HISTORICAL_ORDER_ID="+String.valueOf(RT_HISTORICAL_ORDER_ID));
		sb.append(",RT_CURRENT_VISIT_ID="+String.valueOf(RT_CURRENT_VISIT_ID));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row3Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.CARRIER_NUMBER, other.CARRIER_NUMBER);
						if(returnValue != 0) {
							return returnValue;
						}

					
						returnValue = checkNullsAndCompare(this.DRIVER_NUMBER, other.DRIVER_NUMBER);
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
				
				 
	final String decryptedPassword_tDBInput_2 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:tJpr123RdXnGJjPv29QIJ4/hcDzArw3+Nxt+GCKfi7bEPXHAq0E=");
				
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

		    String dbquery_tDBInput_2 = "SELECT dbo.DIM_DRIVER.PK_DRIVER,\n		dbo.DIM_DRIVER.RT_LAST_USED_CARRIER,\n		dbo.DIM_DRIVER.CARRIER_NUMBER,\n		dbo.DIM_DRIV"
+"ER.DRIVER_NUMBER,\n		dbo.DIM_DRIVER.NAME,\n		dbo.DIM_DRIVER.RT_LAST_USED_TRAILER,\n		dbo.DIM_DRIVER.RT_LAST_ORDER_ID,\n		dbo"
+".DIM_DRIVER.LAST_MODIFIED,\n		dbo.DIM_DRIVER.RT_HISTORICAL_ORDER_ID,\n		dbo.DIM_DRIVER.RT_CURRENT_VISIT_ID\nFROM	dbo.DIM_DR"
+"IVER";
		    

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
								row3.PK_DRIVER = 0;
							} else {
		                          
            row3.PK_DRIVER = rs_tDBInput_2.getInt(1);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 2) {
								row3.RT_LAST_USED_CARRIER = null;
							} else {
		                          
            row3.RT_LAST_USED_CARRIER = rs_tDBInput_2.getInt(2);
            if(rs_tDBInput_2.wasNull()){
                    row3.RT_LAST_USED_CARRIER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 3) {
								row3.CARRIER_NUMBER = 0;
							} else {
		                          
            row3.CARRIER_NUMBER = rs_tDBInput_2.getInt(3);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 4) {
								row3.DRIVER_NUMBER = 0;
							} else {
		                          
            row3.DRIVER_NUMBER = rs_tDBInput_2.getInt(4);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 5) {
								row3.NAME = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(5);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(5).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.NAME = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row3.NAME = tmpContent_tDBInput_2;
                }
            } else {
                row3.NAME = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 6) {
								row3.RT_LAST_USED_TRAILER = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(6);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(6).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.RT_LAST_USED_TRAILER = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row3.RT_LAST_USED_TRAILER = tmpContent_tDBInput_2;
                }
            } else {
                row3.RT_LAST_USED_TRAILER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 7) {
								row3.RT_LAST_ORDER_ID = null;
							} else {
		                          
            row3.RT_LAST_ORDER_ID = rs_tDBInput_2.getInt(7);
            if(rs_tDBInput_2.wasNull()){
                    row3.RT_LAST_ORDER_ID = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 8) {
								row3.LAST_MODIFIED = null;
							} else {
										
			row3.LAST_MODIFIED = mssqlGTU_tDBInput_2.getDate(rsmd_tDBInput_2, rs_tDBInput_2, 8);
			
		                    }
							if(colQtyInRs_tDBInput_2 < 9) {
								row3.RT_HISTORICAL_ORDER_ID = null;
							} else {
		                          
            row3.RT_HISTORICAL_ORDER_ID = rs_tDBInput_2.getInt(9);
            if(rs_tDBInput_2.wasNull()){
                    row3.RT_HISTORICAL_ORDER_ID = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 10) {
								row3.RT_CURRENT_VISIT_ID = null;
							} else {
		                          
            row3.RT_CURRENT_VISIT_ID = rs_tDBInput_2.getInt(10);
            if(rs_tDBInput_2.wasNull()){
                    row3.RT_CURRENT_VISIT_ID = null;
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
		   	   	   
				
				row3_HashRow.PK_DRIVER = row3.PK_DRIVER;
				
				row3_HashRow.RT_LAST_USED_CARRIER = row3.RT_LAST_USED_CARRIER;
				
				row3_HashRow.CARRIER_NUMBER = row3.CARRIER_NUMBER;
				
				row3_HashRow.DRIVER_NUMBER = row3.DRIVER_NUMBER;
				
				row3_HashRow.NAME = row3.NAME;
				
				row3_HashRow.RT_LAST_USED_TRAILER = row3.RT_LAST_USED_TRAILER;
				
				row3_HashRow.RT_LAST_ORDER_ID = row3.RT_LAST_ORDER_ID;
				
				row3_HashRow.LAST_MODIFIED = row3.LAST_MODIFIED;
				
				row3_HashRow.RT_HISTORICAL_ORDER_ID = row3.RT_HISTORICAL_ORDER_ID;
				
				row3_HashRow.RT_CURRENT_VISIT_ID = row3.RT_CURRENT_VISIT_ID;
				
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
        final DIM_DRIVER DIM_DRIVERClass = new DIM_DRIVER();

        int exitCode = DIM_DRIVERClass.runJobInTOS(args);

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
            java.io.InputStream inContext = DIM_DRIVER.class.getClassLoader().getResourceAsStream("pgs_stage/dim_driver_0_1/contexts/" + contextStr + ".properties");
            if (inContext == null) {
                inContext = DIM_DRIVER.class.getClassLoader().getResourceAsStream("config/contexts/" + contextStr + ".properties");
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
            System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : DIM_DRIVER");
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
 *     226470 characters generated by Talend Open Studio for Data Integration 
 *     on the 3 août 2024 à 14:42:26 GMT+01:00
 ************************************************************************************************/