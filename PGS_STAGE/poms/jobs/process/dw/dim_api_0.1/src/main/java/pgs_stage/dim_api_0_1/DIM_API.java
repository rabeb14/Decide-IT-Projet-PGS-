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


package pgs_stage.dim_api_0_1;

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
 * Job: DIM_API Purpose: <br>
 * Description:  <br>
 * @author 
 * @version 8.0.1.20211109_1610
 * @status 
 */
public class DIM_API implements TalendJob {

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
	private final String jobName = "DIM_API";
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
				DIM_API.this.exception = e;
			}
		}
		if (!(e instanceof TalendException)) {
		try {
			for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
				if (m.getName().compareTo(currentComponent + "_error") == 0) {
					m.invoke(DIM_API.this, new Object[] { e , currentComponent, globalMap});
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
    final static byte[] commonByteArrayLock_PGS_STAGE_DIM_API = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_DIM_API = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public Integer PK_API;

				public Integer getPK_API () {
					return this.PK_API;
				}
				
			    public String API_CODE;

				public String getAPI_CODE () {
					return this.API_CODE;
				}
				
			    public String DESCRIPTION;

				public String getDESCRIPTION () {
					return this.DESCRIPTION;
				}
				
			    public int USER_DEFINED;

				public int getUSER_DEFINED () {
					return this.USER_DEFINED;
				}
				
			    public int DENSITY_UNITS;

				public int getDENSITY_UNITS () {
					return this.DENSITY_UNITS;
				}
				
			    public int DENSITY_PRECISION;

				public int getDENSITY_PRECISION () {
					return this.DENSITY_PRECISION;
				}
				
			    public int COE_PRECISION;

				public int getCOE_PRECISION () {
					return this.COE_PRECISION;
				}
				
			    public int WEIGHT_IN_AIR_METHOD;

				public int getWEIGHT_IN_AIR_METHOD () {
					return this.WEIGHT_IN_AIR_METHOD;
				}
				
			    public int TEMPERATURE_UNITS;

				public int getTEMPERATURE_UNITS () {
					return this.TEMPERATURE_UNITS;
				}
				
			    public double REFERENCE_TEMPERATURE;

				public double getREFERENCE_TEMPERATURE () {
					return this.REFERENCE_TEMPERATURE;
				}
				
			    public int TEMPERATURE_PRECISION;

				public int getTEMPERATURE_PRECISION () {
					return this.TEMPERATURE_PRECISION;
				}
				
			    public double MAXIMUM_PRESSURE;

				public double getMAXIMUM_PRESSURE () {
					return this.MAXIMUM_PRESSURE;
				}
				
			    public int COMMODITY_GROUP;

				public int getCOMMODITY_GROUP () {
					return this.COMMODITY_GROUP;
				}
				
			    public String DLL;

				public String getDLL () {
					return this.DLL;
				}
				
			    public int VOLUME_CORRECTION_METHOD;

				public int getVOLUME_CORRECTION_METHOD () {
					return this.VOLUME_CORRECTION_METHOD;
				}
				
			    public String VOLUME_CORRECTION_ROUTINE;

				public String getVOLUME_CORRECTION_ROUTINE () {
					return this.VOLUME_CORRECTION_ROUTINE;
				}
				
			    public int DENSITY_CORRECTION_METHOD;

				public int getDENSITY_CORRECTION_METHOD () {
					return this.DENSITY_CORRECTION_METHOD;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.PK_API == null) ? 0 : this.PK_API.hashCode());
					
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
		
						if (this.PK_API == null) {
							if (other.PK_API != null)
								return false;
						
						} else if (!this.PK_API.equals(other.PK_API))
						
							return false;
					

		return true;
    }

	public void copyDataTo(out1Struct other) {

		other.PK_API = this.PK_API;
	            other.API_CODE = this.API_CODE;
	            other.DESCRIPTION = this.DESCRIPTION;
	            other.USER_DEFINED = this.USER_DEFINED;
	            other.DENSITY_UNITS = this.DENSITY_UNITS;
	            other.DENSITY_PRECISION = this.DENSITY_PRECISION;
	            other.COE_PRECISION = this.COE_PRECISION;
	            other.WEIGHT_IN_AIR_METHOD = this.WEIGHT_IN_AIR_METHOD;
	            other.TEMPERATURE_UNITS = this.TEMPERATURE_UNITS;
	            other.REFERENCE_TEMPERATURE = this.REFERENCE_TEMPERATURE;
	            other.TEMPERATURE_PRECISION = this.TEMPERATURE_PRECISION;
	            other.MAXIMUM_PRESSURE = this.MAXIMUM_PRESSURE;
	            other.COMMODITY_GROUP = this.COMMODITY_GROUP;
	            other.DLL = this.DLL;
	            other.VOLUME_CORRECTION_METHOD = this.VOLUME_CORRECTION_METHOD;
	            other.VOLUME_CORRECTION_ROUTINE = this.VOLUME_CORRECTION_ROUTINE;
	            other.DENSITY_CORRECTION_METHOD = this.DENSITY_CORRECTION_METHOD;
	            
	}

	public void copyKeysDataTo(out1Struct other) {

		other.PK_API = this.PK_API;
	            	
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
			if(length > commonByteArray_PGS_STAGE_DIM_API.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_API.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_API = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_API = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PGS_STAGE_DIM_API, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_API, 0, length, utf8Charset);
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
			if(length > commonByteArray_PGS_STAGE_DIM_API.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_API.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_API = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_API = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PGS_STAGE_DIM_API, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_API, 0, length, utf8Charset);
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

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_API) {

        	try {

        		int length = 0;
		
						this.PK_API = readInteger(dis);
					
					this.API_CODE = readString(dis);
					
					this.DESCRIPTION = readString(dis);
					
			        this.USER_DEFINED = dis.readInt();
					
			        this.DENSITY_UNITS = dis.readInt();
					
			        this.DENSITY_PRECISION = dis.readInt();
					
			        this.COE_PRECISION = dis.readInt();
					
			        this.WEIGHT_IN_AIR_METHOD = dis.readInt();
					
			        this.TEMPERATURE_UNITS = dis.readInt();
					
			        this.REFERENCE_TEMPERATURE = dis.readDouble();
					
			        this.TEMPERATURE_PRECISION = dis.readInt();
					
			        this.MAXIMUM_PRESSURE = dis.readDouble();
					
			        this.COMMODITY_GROUP = dis.readInt();
					
					this.DLL = readString(dis);
					
			        this.VOLUME_CORRECTION_METHOD = dis.readInt();
					
					this.VOLUME_CORRECTION_ROUTINE = readString(dis);
					
			        this.DENSITY_CORRECTION_METHOD = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_API) {

        	try {

        		int length = 0;
		
						this.PK_API = readInteger(dis);
					
					this.API_CODE = readString(dis);
					
					this.DESCRIPTION = readString(dis);
					
			        this.USER_DEFINED = dis.readInt();
					
			        this.DENSITY_UNITS = dis.readInt();
					
			        this.DENSITY_PRECISION = dis.readInt();
					
			        this.COE_PRECISION = dis.readInt();
					
			        this.WEIGHT_IN_AIR_METHOD = dis.readInt();
					
			        this.TEMPERATURE_UNITS = dis.readInt();
					
			        this.REFERENCE_TEMPERATURE = dis.readDouble();
					
			        this.TEMPERATURE_PRECISION = dis.readInt();
					
			        this.MAXIMUM_PRESSURE = dis.readDouble();
					
			        this.COMMODITY_GROUP = dis.readInt();
					
					this.DLL = readString(dis);
					
			        this.VOLUME_CORRECTION_METHOD = dis.readInt();
					
					this.VOLUME_CORRECTION_ROUTINE = readString(dis);
					
			        this.DENSITY_CORRECTION_METHOD = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// Integer
				
						writeInteger(this.PK_API,dos);
					
					// String
				
						writeString(this.API_CODE,dos);
					
					// String
				
						writeString(this.DESCRIPTION,dos);
					
					// int
				
		            	dos.writeInt(this.USER_DEFINED);
					
					// int
				
		            	dos.writeInt(this.DENSITY_UNITS);
					
					// int
				
		            	dos.writeInt(this.DENSITY_PRECISION);
					
					// int
				
		            	dos.writeInt(this.COE_PRECISION);
					
					// int
				
		            	dos.writeInt(this.WEIGHT_IN_AIR_METHOD);
					
					// int
				
		            	dos.writeInt(this.TEMPERATURE_UNITS);
					
					// double
				
		            	dos.writeDouble(this.REFERENCE_TEMPERATURE);
					
					// int
				
		            	dos.writeInt(this.TEMPERATURE_PRECISION);
					
					// double
				
		            	dos.writeDouble(this.MAXIMUM_PRESSURE);
					
					// int
				
		            	dos.writeInt(this.COMMODITY_GROUP);
					
					// String
				
						writeString(this.DLL,dos);
					
					// int
				
		            	dos.writeInt(this.VOLUME_CORRECTION_METHOD);
					
					// String
				
						writeString(this.VOLUME_CORRECTION_ROUTINE,dos);
					
					// int
				
		            	dos.writeInt(this.DENSITY_CORRECTION_METHOD);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Integer
				
						writeInteger(this.PK_API,dos);
					
					// String
				
						writeString(this.API_CODE,dos);
					
					// String
				
						writeString(this.DESCRIPTION,dos);
					
					// int
				
		            	dos.writeInt(this.USER_DEFINED);
					
					// int
				
		            	dos.writeInt(this.DENSITY_UNITS);
					
					// int
				
		            	dos.writeInt(this.DENSITY_PRECISION);
					
					// int
				
		            	dos.writeInt(this.COE_PRECISION);
					
					// int
				
		            	dos.writeInt(this.WEIGHT_IN_AIR_METHOD);
					
					// int
				
		            	dos.writeInt(this.TEMPERATURE_UNITS);
					
					// double
				
		            	dos.writeDouble(this.REFERENCE_TEMPERATURE);
					
					// int
				
		            	dos.writeInt(this.TEMPERATURE_PRECISION);
					
					// double
				
		            	dos.writeDouble(this.MAXIMUM_PRESSURE);
					
					// int
				
		            	dos.writeInt(this.COMMODITY_GROUP);
					
					// String
				
						writeString(this.DLL,dos);
					
					// int
				
		            	dos.writeInt(this.VOLUME_CORRECTION_METHOD);
					
					// String
				
						writeString(this.VOLUME_CORRECTION_ROUTINE,dos);
					
					// int
				
		            	dos.writeInt(this.DENSITY_CORRECTION_METHOD);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("PK_API="+String.valueOf(PK_API));
		sb.append(",API_CODE="+API_CODE);
		sb.append(",DESCRIPTION="+DESCRIPTION);
		sb.append(",USER_DEFINED="+String.valueOf(USER_DEFINED));
		sb.append(",DENSITY_UNITS="+String.valueOf(DENSITY_UNITS));
		sb.append(",DENSITY_PRECISION="+String.valueOf(DENSITY_PRECISION));
		sb.append(",COE_PRECISION="+String.valueOf(COE_PRECISION));
		sb.append(",WEIGHT_IN_AIR_METHOD="+String.valueOf(WEIGHT_IN_AIR_METHOD));
		sb.append(",TEMPERATURE_UNITS="+String.valueOf(TEMPERATURE_UNITS));
		sb.append(",REFERENCE_TEMPERATURE="+String.valueOf(REFERENCE_TEMPERATURE));
		sb.append(",TEMPERATURE_PRECISION="+String.valueOf(TEMPERATURE_PRECISION));
		sb.append(",MAXIMUM_PRESSURE="+String.valueOf(MAXIMUM_PRESSURE));
		sb.append(",COMMODITY_GROUP="+String.valueOf(COMMODITY_GROUP));
		sb.append(",DLL="+DLL);
		sb.append(",VOLUME_CORRECTION_METHOD="+String.valueOf(VOLUME_CORRECTION_METHOD));
		sb.append(",VOLUME_CORRECTION_ROUTINE="+VOLUME_CORRECTION_ROUTINE);
		sb.append(",DENSITY_CORRECTION_METHOD="+String.valueOf(DENSITY_CORRECTION_METHOD));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(out1Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.PK_API, other.PK_API);
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
    final static byte[] commonByteArrayLock_PGS_STAGE_DIM_API = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_DIM_API = new byte[0];

	
			    public String API_CODE;

				public String getAPI_CODE () {
					return this.API_CODE;
				}
				
			    public String DESCRIPTION;

				public String getDESCRIPTION () {
					return this.DESCRIPTION;
				}
				
			    public int USER_DEFINED;

				public int getUSER_DEFINED () {
					return this.USER_DEFINED;
				}
				
			    public int DDE_VALUE;

				public int getDDE_VALUE () {
					return this.DDE_VALUE;
				}
				
			    public int DENSITY_UNITS;

				public int getDENSITY_UNITS () {
					return this.DENSITY_UNITS;
				}
				
			    public int PRESSURE_UNITS;

				public int getPRESSURE_UNITS () {
					return this.PRESSURE_UNITS;
				}
				
			    public int DENSITY_PRECISION;

				public int getDENSITY_PRECISION () {
					return this.DENSITY_PRECISION;
				}
				
			    public java.util.Date LAST_MODIFIED;

				public java.util.Date getLAST_MODIFIED () {
					return this.LAST_MODIFIED;
				}
				
			    public int COE_PRECISION;

				public int getCOE_PRECISION () {
					return this.COE_PRECISION;
				}
				
			    public double DENSITY_UNITS_FACTOR;

				public double getDENSITY_UNITS_FACTOR () {
					return this.DENSITY_UNITS_FACTOR;
				}
				
			    public String DENSITY_CORRECTION_ROUTINE;

				public String getDENSITY_CORRECTION_ROUTINE () {
					return this.DENSITY_CORRECTION_ROUTINE;
				}
				
			    public int WEIGHT_IN_AIR_METHOD;

				public int getWEIGHT_IN_AIR_METHOD () {
					return this.WEIGHT_IN_AIR_METHOD;
				}
				
			    public String WEIGHT_IN_AIR_ROUTINE;

				public String getWEIGHT_IN_AIR_ROUTINE () {
					return this.WEIGHT_IN_AIR_ROUTINE;
				}
				
			    public double WEIGHT_IN_AIR_FACTOR;

				public double getWEIGHT_IN_AIR_FACTOR () {
					return this.WEIGHT_IN_AIR_FACTOR;
				}
				
			    public String LAST_USER_NAME;

				public String getLAST_USER_NAME () {
					return this.LAST_USER_NAME;
				}
				
			    public int TEMPERATURE_UNITS;

				public int getTEMPERATURE_UNITS () {
					return this.TEMPERATURE_UNITS;
				}
				
			    public double REFERENCE_TEMPERATURE;

				public double getREFERENCE_TEMPERATURE () {
					return this.REFERENCE_TEMPERATURE;
				}
				
			    public int TEMPERATURE_PRECISION;

				public int getTEMPERATURE_PRECISION () {
					return this.TEMPERATURE_PRECISION;
				}
				
			    public int PRESSURE_PRECISION;

				public int getPRESSURE_PRECISION () {
					return this.PRESSURE_PRECISION;
				}
				
			    public int VCF_PRECISION;

				public int getVCF_PRECISION () {
					return this.VCF_PRECISION;
				}
				
			    public double MINIMUM_TEMPERATURE;

				public double getMINIMUM_TEMPERATURE () {
					return this.MINIMUM_TEMPERATURE;
				}
				
			    public double MAXIMUM_TEMPERATURE;

				public double getMAXIMUM_TEMPERATURE () {
					return this.MAXIMUM_TEMPERATURE;
				}
				
			    public double MINIMUM_PRESSURE;

				public double getMINIMUM_PRESSURE () {
					return this.MINIMUM_PRESSURE;
				}
				
			    public double MAXIMUM_PRESSURE;

				public double getMAXIMUM_PRESSURE () {
					return this.MAXIMUM_PRESSURE;
				}
				
			    public double MINIMUM_BASE_DENSITY;

				public double getMINIMUM_BASE_DENSITY () {
					return this.MINIMUM_BASE_DENSITY;
				}
				
			    public double MAXIMUM_BASE_DENSITY;

				public double getMAXIMUM_BASE_DENSITY () {
					return this.MAXIMUM_BASE_DENSITY;
				}
				
			    public double MINIMUM_OBSERVED_DENSITY;

				public double getMINIMUM_OBSERVED_DENSITY () {
					return this.MINIMUM_OBSERVED_DENSITY;
				}
				
			    public double MAXIMUM_OBSERVED_DENSITY;

				public double getMAXIMUM_OBSERVED_DENSITY () {
					return this.MAXIMUM_OBSERVED_DENSITY;
				}
				
			    public double MINIMUM_COE;

				public double getMINIMUM_COE () {
					return this.MINIMUM_COE;
				}
				
			    public double MAXIMUM_COE;

				public double getMAXIMUM_COE () {
					return this.MAXIMUM_COE;
				}
				
			    public int COMMODITY_GROUP;

				public int getCOMMODITY_GROUP () {
					return this.COMMODITY_GROUP;
				}
				
			    public String DLL;

				public String getDLL () {
					return this.DLL;
				}
				
			    public int VOLUME_CORRECTION_METHOD;

				public int getVOLUME_CORRECTION_METHOD () {
					return this.VOLUME_CORRECTION_METHOD;
				}
				
			    public String VOLUME_CORRECTION_ROUTINE;

				public String getVOLUME_CORRECTION_ROUTINE () {
					return this.VOLUME_CORRECTION_ROUTINE;
				}
				
			    public int DENSITY_CORRECTION_METHOD;

				public int getDENSITY_CORRECTION_METHOD () {
					return this.DENSITY_CORRECTION_METHOD;
				}
				
			    public String DENSITY_CORRECTION_STD_API_COD;

				public String getDENSITY_CORRECTION_STD_API_COD () {
					return this.DENSITY_CORRECTION_STD_API_COD;
				}
				
			    public String DENSITY_UNITS_ROUTINE;

				public String getDENSITY_UNITS_ROUTINE () {
					return this.DENSITY_UNITS_ROUTINE;
				}
				
			    public double INPUT_DENSITY_TEMPERATURE;

				public double getINPUT_DENSITY_TEMPERATURE () {
					return this.INPUT_DENSITY_TEMPERATURE;
				}
				
			    public int WEIGHT_CONVERSION_METHOD;

				public int getWEIGHT_CONVERSION_METHOD () {
					return this.WEIGHT_CONVERSION_METHOD;
				}
				
			    public String WEIGHT_CONVERSION_ROUTINE;

				public String getWEIGHT_CONVERSION_ROUTINE () {
					return this.WEIGHT_CONVERSION_ROUTINE;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PGS_STAGE_DIM_API.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_API.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_API = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_API = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PGS_STAGE_DIM_API, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_API, 0, length, utf8Charset);
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
			if(length > commonByteArray_PGS_STAGE_DIM_API.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_API.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_API = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_API = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PGS_STAGE_DIM_API, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_API, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_API) {

        	try {

        		int length = 0;
		
					this.API_CODE = readString(dis);
					
					this.DESCRIPTION = readString(dis);
					
			        this.USER_DEFINED = dis.readInt();
					
			        this.DDE_VALUE = dis.readInt();
					
			        this.DENSITY_UNITS = dis.readInt();
					
			        this.PRESSURE_UNITS = dis.readInt();
					
			        this.DENSITY_PRECISION = dis.readInt();
					
					this.LAST_MODIFIED = readDate(dis);
					
			        this.COE_PRECISION = dis.readInt();
					
			        this.DENSITY_UNITS_FACTOR = dis.readDouble();
					
					this.DENSITY_CORRECTION_ROUTINE = readString(dis);
					
			        this.WEIGHT_IN_AIR_METHOD = dis.readInt();
					
					this.WEIGHT_IN_AIR_ROUTINE = readString(dis);
					
			        this.WEIGHT_IN_AIR_FACTOR = dis.readDouble();
					
					this.LAST_USER_NAME = readString(dis);
					
			        this.TEMPERATURE_UNITS = dis.readInt();
					
			        this.REFERENCE_TEMPERATURE = dis.readDouble();
					
			        this.TEMPERATURE_PRECISION = dis.readInt();
					
			        this.PRESSURE_PRECISION = dis.readInt();
					
			        this.VCF_PRECISION = dis.readInt();
					
			        this.MINIMUM_TEMPERATURE = dis.readDouble();
					
			        this.MAXIMUM_TEMPERATURE = dis.readDouble();
					
			        this.MINIMUM_PRESSURE = dis.readDouble();
					
			        this.MAXIMUM_PRESSURE = dis.readDouble();
					
			        this.MINIMUM_BASE_DENSITY = dis.readDouble();
					
			        this.MAXIMUM_BASE_DENSITY = dis.readDouble();
					
			        this.MINIMUM_OBSERVED_DENSITY = dis.readDouble();
					
			        this.MAXIMUM_OBSERVED_DENSITY = dis.readDouble();
					
			        this.MINIMUM_COE = dis.readDouble();
					
			        this.MAXIMUM_COE = dis.readDouble();
					
			        this.COMMODITY_GROUP = dis.readInt();
					
					this.DLL = readString(dis);
					
			        this.VOLUME_CORRECTION_METHOD = dis.readInt();
					
					this.VOLUME_CORRECTION_ROUTINE = readString(dis);
					
			        this.DENSITY_CORRECTION_METHOD = dis.readInt();
					
					this.DENSITY_CORRECTION_STD_API_COD = readString(dis);
					
					this.DENSITY_UNITS_ROUTINE = readString(dis);
					
			        this.INPUT_DENSITY_TEMPERATURE = dis.readDouble();
					
			        this.WEIGHT_CONVERSION_METHOD = dis.readInt();
					
					this.WEIGHT_CONVERSION_ROUTINE = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_API) {

        	try {

        		int length = 0;
		
					this.API_CODE = readString(dis);
					
					this.DESCRIPTION = readString(dis);
					
			        this.USER_DEFINED = dis.readInt();
					
			        this.DDE_VALUE = dis.readInt();
					
			        this.DENSITY_UNITS = dis.readInt();
					
			        this.PRESSURE_UNITS = dis.readInt();
					
			        this.DENSITY_PRECISION = dis.readInt();
					
					this.LAST_MODIFIED = readDate(dis);
					
			        this.COE_PRECISION = dis.readInt();
					
			        this.DENSITY_UNITS_FACTOR = dis.readDouble();
					
					this.DENSITY_CORRECTION_ROUTINE = readString(dis);
					
			        this.WEIGHT_IN_AIR_METHOD = dis.readInt();
					
					this.WEIGHT_IN_AIR_ROUTINE = readString(dis);
					
			        this.WEIGHT_IN_AIR_FACTOR = dis.readDouble();
					
					this.LAST_USER_NAME = readString(dis);
					
			        this.TEMPERATURE_UNITS = dis.readInt();
					
			        this.REFERENCE_TEMPERATURE = dis.readDouble();
					
			        this.TEMPERATURE_PRECISION = dis.readInt();
					
			        this.PRESSURE_PRECISION = dis.readInt();
					
			        this.VCF_PRECISION = dis.readInt();
					
			        this.MINIMUM_TEMPERATURE = dis.readDouble();
					
			        this.MAXIMUM_TEMPERATURE = dis.readDouble();
					
			        this.MINIMUM_PRESSURE = dis.readDouble();
					
			        this.MAXIMUM_PRESSURE = dis.readDouble();
					
			        this.MINIMUM_BASE_DENSITY = dis.readDouble();
					
			        this.MAXIMUM_BASE_DENSITY = dis.readDouble();
					
			        this.MINIMUM_OBSERVED_DENSITY = dis.readDouble();
					
			        this.MAXIMUM_OBSERVED_DENSITY = dis.readDouble();
					
			        this.MINIMUM_COE = dis.readDouble();
					
			        this.MAXIMUM_COE = dis.readDouble();
					
			        this.COMMODITY_GROUP = dis.readInt();
					
					this.DLL = readString(dis);
					
			        this.VOLUME_CORRECTION_METHOD = dis.readInt();
					
					this.VOLUME_CORRECTION_ROUTINE = readString(dis);
					
			        this.DENSITY_CORRECTION_METHOD = dis.readInt();
					
					this.DENSITY_CORRECTION_STD_API_COD = readString(dis);
					
					this.DENSITY_UNITS_ROUTINE = readString(dis);
					
			        this.INPUT_DENSITY_TEMPERATURE = dis.readDouble();
					
			        this.WEIGHT_CONVERSION_METHOD = dis.readInt();
					
					this.WEIGHT_CONVERSION_ROUTINE = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.API_CODE,dos);
					
					// String
				
						writeString(this.DESCRIPTION,dos);
					
					// int
				
		            	dos.writeInt(this.USER_DEFINED);
					
					// int
				
		            	dos.writeInt(this.DDE_VALUE);
					
					// int
				
		            	dos.writeInt(this.DENSITY_UNITS);
					
					// int
				
		            	dos.writeInt(this.PRESSURE_UNITS);
					
					// int
				
		            	dos.writeInt(this.DENSITY_PRECISION);
					
					// java.util.Date
				
						writeDate(this.LAST_MODIFIED,dos);
					
					// int
				
		            	dos.writeInt(this.COE_PRECISION);
					
					// double
				
		            	dos.writeDouble(this.DENSITY_UNITS_FACTOR);
					
					// String
				
						writeString(this.DENSITY_CORRECTION_ROUTINE,dos);
					
					// int
				
		            	dos.writeInt(this.WEIGHT_IN_AIR_METHOD);
					
					// String
				
						writeString(this.WEIGHT_IN_AIR_ROUTINE,dos);
					
					// double
				
		            	dos.writeDouble(this.WEIGHT_IN_AIR_FACTOR);
					
					// String
				
						writeString(this.LAST_USER_NAME,dos);
					
					// int
				
		            	dos.writeInt(this.TEMPERATURE_UNITS);
					
					// double
				
		            	dos.writeDouble(this.REFERENCE_TEMPERATURE);
					
					// int
				
		            	dos.writeInt(this.TEMPERATURE_PRECISION);
					
					// int
				
		            	dos.writeInt(this.PRESSURE_PRECISION);
					
					// int
				
		            	dos.writeInt(this.VCF_PRECISION);
					
					// double
				
		            	dos.writeDouble(this.MINIMUM_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.MAXIMUM_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.MINIMUM_PRESSURE);
					
					// double
				
		            	dos.writeDouble(this.MAXIMUM_PRESSURE);
					
					// double
				
		            	dos.writeDouble(this.MINIMUM_BASE_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.MAXIMUM_BASE_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.MINIMUM_OBSERVED_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.MAXIMUM_OBSERVED_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.MINIMUM_COE);
					
					// double
				
		            	dos.writeDouble(this.MAXIMUM_COE);
					
					// int
				
		            	dos.writeInt(this.COMMODITY_GROUP);
					
					// String
				
						writeString(this.DLL,dos);
					
					// int
				
		            	dos.writeInt(this.VOLUME_CORRECTION_METHOD);
					
					// String
				
						writeString(this.VOLUME_CORRECTION_ROUTINE,dos);
					
					// int
				
		            	dos.writeInt(this.DENSITY_CORRECTION_METHOD);
					
					// String
				
						writeString(this.DENSITY_CORRECTION_STD_API_COD,dos);
					
					// String
				
						writeString(this.DENSITY_UNITS_ROUTINE,dos);
					
					// double
				
		            	dos.writeDouble(this.INPUT_DENSITY_TEMPERATURE);
					
					// int
				
		            	dos.writeInt(this.WEIGHT_CONVERSION_METHOD);
					
					// String
				
						writeString(this.WEIGHT_CONVERSION_ROUTINE,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.API_CODE,dos);
					
					// String
				
						writeString(this.DESCRIPTION,dos);
					
					// int
				
		            	dos.writeInt(this.USER_DEFINED);
					
					// int
				
		            	dos.writeInt(this.DDE_VALUE);
					
					// int
				
		            	dos.writeInt(this.DENSITY_UNITS);
					
					// int
				
		            	dos.writeInt(this.PRESSURE_UNITS);
					
					// int
				
		            	dos.writeInt(this.DENSITY_PRECISION);
					
					// java.util.Date
				
						writeDate(this.LAST_MODIFIED,dos);
					
					// int
				
		            	dos.writeInt(this.COE_PRECISION);
					
					// double
				
		            	dos.writeDouble(this.DENSITY_UNITS_FACTOR);
					
					// String
				
						writeString(this.DENSITY_CORRECTION_ROUTINE,dos);
					
					// int
				
		            	dos.writeInt(this.WEIGHT_IN_AIR_METHOD);
					
					// String
				
						writeString(this.WEIGHT_IN_AIR_ROUTINE,dos);
					
					// double
				
		            	dos.writeDouble(this.WEIGHT_IN_AIR_FACTOR);
					
					// String
				
						writeString(this.LAST_USER_NAME,dos);
					
					// int
				
		            	dos.writeInt(this.TEMPERATURE_UNITS);
					
					// double
				
		            	dos.writeDouble(this.REFERENCE_TEMPERATURE);
					
					// int
				
		            	dos.writeInt(this.TEMPERATURE_PRECISION);
					
					// int
				
		            	dos.writeInt(this.PRESSURE_PRECISION);
					
					// int
				
		            	dos.writeInt(this.VCF_PRECISION);
					
					// double
				
		            	dos.writeDouble(this.MINIMUM_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.MAXIMUM_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.MINIMUM_PRESSURE);
					
					// double
				
		            	dos.writeDouble(this.MAXIMUM_PRESSURE);
					
					// double
				
		            	dos.writeDouble(this.MINIMUM_BASE_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.MAXIMUM_BASE_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.MINIMUM_OBSERVED_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.MAXIMUM_OBSERVED_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.MINIMUM_COE);
					
					// double
				
		            	dos.writeDouble(this.MAXIMUM_COE);
					
					// int
				
		            	dos.writeInt(this.COMMODITY_GROUP);
					
					// String
				
						writeString(this.DLL,dos);
					
					// int
				
		            	dos.writeInt(this.VOLUME_CORRECTION_METHOD);
					
					// String
				
						writeString(this.VOLUME_CORRECTION_ROUTINE,dos);
					
					// int
				
		            	dos.writeInt(this.DENSITY_CORRECTION_METHOD);
					
					// String
				
						writeString(this.DENSITY_CORRECTION_STD_API_COD,dos);
					
					// String
				
						writeString(this.DENSITY_UNITS_ROUTINE,dos);
					
					// double
				
		            	dos.writeDouble(this.INPUT_DENSITY_TEMPERATURE);
					
					// int
				
		            	dos.writeInt(this.WEIGHT_CONVERSION_METHOD);
					
					// String
				
						writeString(this.WEIGHT_CONVERSION_ROUTINE,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("API_CODE="+API_CODE);
		sb.append(",DESCRIPTION="+DESCRIPTION);
		sb.append(",USER_DEFINED="+String.valueOf(USER_DEFINED));
		sb.append(",DDE_VALUE="+String.valueOf(DDE_VALUE));
		sb.append(",DENSITY_UNITS="+String.valueOf(DENSITY_UNITS));
		sb.append(",PRESSURE_UNITS="+String.valueOf(PRESSURE_UNITS));
		sb.append(",DENSITY_PRECISION="+String.valueOf(DENSITY_PRECISION));
		sb.append(",LAST_MODIFIED="+String.valueOf(LAST_MODIFIED));
		sb.append(",COE_PRECISION="+String.valueOf(COE_PRECISION));
		sb.append(",DENSITY_UNITS_FACTOR="+String.valueOf(DENSITY_UNITS_FACTOR));
		sb.append(",DENSITY_CORRECTION_ROUTINE="+DENSITY_CORRECTION_ROUTINE);
		sb.append(",WEIGHT_IN_AIR_METHOD="+String.valueOf(WEIGHT_IN_AIR_METHOD));
		sb.append(",WEIGHT_IN_AIR_ROUTINE="+WEIGHT_IN_AIR_ROUTINE);
		sb.append(",WEIGHT_IN_AIR_FACTOR="+String.valueOf(WEIGHT_IN_AIR_FACTOR));
		sb.append(",LAST_USER_NAME="+LAST_USER_NAME);
		sb.append(",TEMPERATURE_UNITS="+String.valueOf(TEMPERATURE_UNITS));
		sb.append(",REFERENCE_TEMPERATURE="+String.valueOf(REFERENCE_TEMPERATURE));
		sb.append(",TEMPERATURE_PRECISION="+String.valueOf(TEMPERATURE_PRECISION));
		sb.append(",PRESSURE_PRECISION="+String.valueOf(PRESSURE_PRECISION));
		sb.append(",VCF_PRECISION="+String.valueOf(VCF_PRECISION));
		sb.append(",MINIMUM_TEMPERATURE="+String.valueOf(MINIMUM_TEMPERATURE));
		sb.append(",MAXIMUM_TEMPERATURE="+String.valueOf(MAXIMUM_TEMPERATURE));
		sb.append(",MINIMUM_PRESSURE="+String.valueOf(MINIMUM_PRESSURE));
		sb.append(",MAXIMUM_PRESSURE="+String.valueOf(MAXIMUM_PRESSURE));
		sb.append(",MINIMUM_BASE_DENSITY="+String.valueOf(MINIMUM_BASE_DENSITY));
		sb.append(",MAXIMUM_BASE_DENSITY="+String.valueOf(MAXIMUM_BASE_DENSITY));
		sb.append(",MINIMUM_OBSERVED_DENSITY="+String.valueOf(MINIMUM_OBSERVED_DENSITY));
		sb.append(",MAXIMUM_OBSERVED_DENSITY="+String.valueOf(MAXIMUM_OBSERVED_DENSITY));
		sb.append(",MINIMUM_COE="+String.valueOf(MINIMUM_COE));
		sb.append(",MAXIMUM_COE="+String.valueOf(MAXIMUM_COE));
		sb.append(",COMMODITY_GROUP="+String.valueOf(COMMODITY_GROUP));
		sb.append(",DLL="+DLL);
		sb.append(",VOLUME_CORRECTION_METHOD="+String.valueOf(VOLUME_CORRECTION_METHOD));
		sb.append(",VOLUME_CORRECTION_ROUTINE="+VOLUME_CORRECTION_ROUTINE);
		sb.append(",DENSITY_CORRECTION_METHOD="+String.valueOf(DENSITY_CORRECTION_METHOD));
		sb.append(",DENSITY_CORRECTION_STD_API_COD="+DENSITY_CORRECTION_STD_API_COD);
		sb.append(",DENSITY_UNITS_ROUTINE="+DENSITY_UNITS_ROUTINE);
		sb.append(",INPUT_DENSITY_TEMPERATURE="+String.valueOf(INPUT_DENSITY_TEMPERATURE));
		sb.append(",WEIGHT_CONVERSION_METHOD="+String.valueOf(WEIGHT_CONVERSION_METHOD));
		sb.append(",WEIGHT_CONVERSION_ROUTINE="+WEIGHT_CONVERSION_ROUTINE);
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
    final static byte[] commonByteArrayLock_PGS_STAGE_DIM_API = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_DIM_API = new byte[0];

	
			    public String API_CODE;

				public String getAPI_CODE () {
					return this.API_CODE;
				}
				
			    public String DESCRIPTION;

				public String getDESCRIPTION () {
					return this.DESCRIPTION;
				}
				
			    public int USER_DEFINED;

				public int getUSER_DEFINED () {
					return this.USER_DEFINED;
				}
				
			    public int DDE_VALUE;

				public int getDDE_VALUE () {
					return this.DDE_VALUE;
				}
				
			    public int DENSITY_UNITS;

				public int getDENSITY_UNITS () {
					return this.DENSITY_UNITS;
				}
				
			    public int PRESSURE_UNITS;

				public int getPRESSURE_UNITS () {
					return this.PRESSURE_UNITS;
				}
				
			    public int DENSITY_PRECISION;

				public int getDENSITY_PRECISION () {
					return this.DENSITY_PRECISION;
				}
				
			    public java.util.Date LAST_MODIFIED;

				public java.util.Date getLAST_MODIFIED () {
					return this.LAST_MODIFIED;
				}
				
			    public int COE_PRECISION;

				public int getCOE_PRECISION () {
					return this.COE_PRECISION;
				}
				
			    public double DENSITY_UNITS_FACTOR;

				public double getDENSITY_UNITS_FACTOR () {
					return this.DENSITY_UNITS_FACTOR;
				}
				
			    public String DENSITY_CORRECTION_ROUTINE;

				public String getDENSITY_CORRECTION_ROUTINE () {
					return this.DENSITY_CORRECTION_ROUTINE;
				}
				
			    public int WEIGHT_IN_AIR_METHOD;

				public int getWEIGHT_IN_AIR_METHOD () {
					return this.WEIGHT_IN_AIR_METHOD;
				}
				
			    public String WEIGHT_IN_AIR_ROUTINE;

				public String getWEIGHT_IN_AIR_ROUTINE () {
					return this.WEIGHT_IN_AIR_ROUTINE;
				}
				
			    public double WEIGHT_IN_AIR_FACTOR;

				public double getWEIGHT_IN_AIR_FACTOR () {
					return this.WEIGHT_IN_AIR_FACTOR;
				}
				
			    public String LAST_USER_NAME;

				public String getLAST_USER_NAME () {
					return this.LAST_USER_NAME;
				}
				
			    public int TEMPERATURE_UNITS;

				public int getTEMPERATURE_UNITS () {
					return this.TEMPERATURE_UNITS;
				}
				
			    public double REFERENCE_TEMPERATURE;

				public double getREFERENCE_TEMPERATURE () {
					return this.REFERENCE_TEMPERATURE;
				}
				
			    public int TEMPERATURE_PRECISION;

				public int getTEMPERATURE_PRECISION () {
					return this.TEMPERATURE_PRECISION;
				}
				
			    public int PRESSURE_PRECISION;

				public int getPRESSURE_PRECISION () {
					return this.PRESSURE_PRECISION;
				}
				
			    public int VCF_PRECISION;

				public int getVCF_PRECISION () {
					return this.VCF_PRECISION;
				}
				
			    public double MINIMUM_TEMPERATURE;

				public double getMINIMUM_TEMPERATURE () {
					return this.MINIMUM_TEMPERATURE;
				}
				
			    public double MAXIMUM_TEMPERATURE;

				public double getMAXIMUM_TEMPERATURE () {
					return this.MAXIMUM_TEMPERATURE;
				}
				
			    public double MINIMUM_PRESSURE;

				public double getMINIMUM_PRESSURE () {
					return this.MINIMUM_PRESSURE;
				}
				
			    public double MAXIMUM_PRESSURE;

				public double getMAXIMUM_PRESSURE () {
					return this.MAXIMUM_PRESSURE;
				}
				
			    public double MINIMUM_BASE_DENSITY;

				public double getMINIMUM_BASE_DENSITY () {
					return this.MINIMUM_BASE_DENSITY;
				}
				
			    public double MAXIMUM_BASE_DENSITY;

				public double getMAXIMUM_BASE_DENSITY () {
					return this.MAXIMUM_BASE_DENSITY;
				}
				
			    public double MINIMUM_OBSERVED_DENSITY;

				public double getMINIMUM_OBSERVED_DENSITY () {
					return this.MINIMUM_OBSERVED_DENSITY;
				}
				
			    public double MAXIMUM_OBSERVED_DENSITY;

				public double getMAXIMUM_OBSERVED_DENSITY () {
					return this.MAXIMUM_OBSERVED_DENSITY;
				}
				
			    public double MINIMUM_COE;

				public double getMINIMUM_COE () {
					return this.MINIMUM_COE;
				}
				
			    public double MAXIMUM_COE;

				public double getMAXIMUM_COE () {
					return this.MAXIMUM_COE;
				}
				
			    public int COMMODITY_GROUP;

				public int getCOMMODITY_GROUP () {
					return this.COMMODITY_GROUP;
				}
				
			    public String DLL;

				public String getDLL () {
					return this.DLL;
				}
				
			    public int VOLUME_CORRECTION_METHOD;

				public int getVOLUME_CORRECTION_METHOD () {
					return this.VOLUME_CORRECTION_METHOD;
				}
				
			    public String VOLUME_CORRECTION_ROUTINE;

				public String getVOLUME_CORRECTION_ROUTINE () {
					return this.VOLUME_CORRECTION_ROUTINE;
				}
				
			    public int DENSITY_CORRECTION_METHOD;

				public int getDENSITY_CORRECTION_METHOD () {
					return this.DENSITY_CORRECTION_METHOD;
				}
				
			    public String DENSITY_CORRECTION_STD_API_COD;

				public String getDENSITY_CORRECTION_STD_API_COD () {
					return this.DENSITY_CORRECTION_STD_API_COD;
				}
				
			    public String DENSITY_UNITS_ROUTINE;

				public String getDENSITY_UNITS_ROUTINE () {
					return this.DENSITY_UNITS_ROUTINE;
				}
				
			    public double INPUT_DENSITY_TEMPERATURE;

				public double getINPUT_DENSITY_TEMPERATURE () {
					return this.INPUT_DENSITY_TEMPERATURE;
				}
				
			    public int WEIGHT_CONVERSION_METHOD;

				public int getWEIGHT_CONVERSION_METHOD () {
					return this.WEIGHT_CONVERSION_METHOD;
				}
				
			    public String WEIGHT_CONVERSION_ROUTINE;

				public String getWEIGHT_CONVERSION_ROUTINE () {
					return this.WEIGHT_CONVERSION_ROUTINE;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PGS_STAGE_DIM_API.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_API.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_API = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_API = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PGS_STAGE_DIM_API, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_API, 0, length, utf8Charset);
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
			if(length > commonByteArray_PGS_STAGE_DIM_API.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_API.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_API = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_API = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PGS_STAGE_DIM_API, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_API, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_API) {

        	try {

        		int length = 0;
		
					this.API_CODE = readString(dis);
					
					this.DESCRIPTION = readString(dis);
					
			        this.USER_DEFINED = dis.readInt();
					
			        this.DDE_VALUE = dis.readInt();
					
			        this.DENSITY_UNITS = dis.readInt();
					
			        this.PRESSURE_UNITS = dis.readInt();
					
			        this.DENSITY_PRECISION = dis.readInt();
					
					this.LAST_MODIFIED = readDate(dis);
					
			        this.COE_PRECISION = dis.readInt();
					
			        this.DENSITY_UNITS_FACTOR = dis.readDouble();
					
					this.DENSITY_CORRECTION_ROUTINE = readString(dis);
					
			        this.WEIGHT_IN_AIR_METHOD = dis.readInt();
					
					this.WEIGHT_IN_AIR_ROUTINE = readString(dis);
					
			        this.WEIGHT_IN_AIR_FACTOR = dis.readDouble();
					
					this.LAST_USER_NAME = readString(dis);
					
			        this.TEMPERATURE_UNITS = dis.readInt();
					
			        this.REFERENCE_TEMPERATURE = dis.readDouble();
					
			        this.TEMPERATURE_PRECISION = dis.readInt();
					
			        this.PRESSURE_PRECISION = dis.readInt();
					
			        this.VCF_PRECISION = dis.readInt();
					
			        this.MINIMUM_TEMPERATURE = dis.readDouble();
					
			        this.MAXIMUM_TEMPERATURE = dis.readDouble();
					
			        this.MINIMUM_PRESSURE = dis.readDouble();
					
			        this.MAXIMUM_PRESSURE = dis.readDouble();
					
			        this.MINIMUM_BASE_DENSITY = dis.readDouble();
					
			        this.MAXIMUM_BASE_DENSITY = dis.readDouble();
					
			        this.MINIMUM_OBSERVED_DENSITY = dis.readDouble();
					
			        this.MAXIMUM_OBSERVED_DENSITY = dis.readDouble();
					
			        this.MINIMUM_COE = dis.readDouble();
					
			        this.MAXIMUM_COE = dis.readDouble();
					
			        this.COMMODITY_GROUP = dis.readInt();
					
					this.DLL = readString(dis);
					
			        this.VOLUME_CORRECTION_METHOD = dis.readInt();
					
					this.VOLUME_CORRECTION_ROUTINE = readString(dis);
					
			        this.DENSITY_CORRECTION_METHOD = dis.readInt();
					
					this.DENSITY_CORRECTION_STD_API_COD = readString(dis);
					
					this.DENSITY_UNITS_ROUTINE = readString(dis);
					
			        this.INPUT_DENSITY_TEMPERATURE = dis.readDouble();
					
			        this.WEIGHT_CONVERSION_METHOD = dis.readInt();
					
					this.WEIGHT_CONVERSION_ROUTINE = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_API) {

        	try {

        		int length = 0;
		
					this.API_CODE = readString(dis);
					
					this.DESCRIPTION = readString(dis);
					
			        this.USER_DEFINED = dis.readInt();
					
			        this.DDE_VALUE = dis.readInt();
					
			        this.DENSITY_UNITS = dis.readInt();
					
			        this.PRESSURE_UNITS = dis.readInt();
					
			        this.DENSITY_PRECISION = dis.readInt();
					
					this.LAST_MODIFIED = readDate(dis);
					
			        this.COE_PRECISION = dis.readInt();
					
			        this.DENSITY_UNITS_FACTOR = dis.readDouble();
					
					this.DENSITY_CORRECTION_ROUTINE = readString(dis);
					
			        this.WEIGHT_IN_AIR_METHOD = dis.readInt();
					
					this.WEIGHT_IN_AIR_ROUTINE = readString(dis);
					
			        this.WEIGHT_IN_AIR_FACTOR = dis.readDouble();
					
					this.LAST_USER_NAME = readString(dis);
					
			        this.TEMPERATURE_UNITS = dis.readInt();
					
			        this.REFERENCE_TEMPERATURE = dis.readDouble();
					
			        this.TEMPERATURE_PRECISION = dis.readInt();
					
			        this.PRESSURE_PRECISION = dis.readInt();
					
			        this.VCF_PRECISION = dis.readInt();
					
			        this.MINIMUM_TEMPERATURE = dis.readDouble();
					
			        this.MAXIMUM_TEMPERATURE = dis.readDouble();
					
			        this.MINIMUM_PRESSURE = dis.readDouble();
					
			        this.MAXIMUM_PRESSURE = dis.readDouble();
					
			        this.MINIMUM_BASE_DENSITY = dis.readDouble();
					
			        this.MAXIMUM_BASE_DENSITY = dis.readDouble();
					
			        this.MINIMUM_OBSERVED_DENSITY = dis.readDouble();
					
			        this.MAXIMUM_OBSERVED_DENSITY = dis.readDouble();
					
			        this.MINIMUM_COE = dis.readDouble();
					
			        this.MAXIMUM_COE = dis.readDouble();
					
			        this.COMMODITY_GROUP = dis.readInt();
					
					this.DLL = readString(dis);
					
			        this.VOLUME_CORRECTION_METHOD = dis.readInt();
					
					this.VOLUME_CORRECTION_ROUTINE = readString(dis);
					
			        this.DENSITY_CORRECTION_METHOD = dis.readInt();
					
					this.DENSITY_CORRECTION_STD_API_COD = readString(dis);
					
					this.DENSITY_UNITS_ROUTINE = readString(dis);
					
			        this.INPUT_DENSITY_TEMPERATURE = dis.readDouble();
					
			        this.WEIGHT_CONVERSION_METHOD = dis.readInt();
					
					this.WEIGHT_CONVERSION_ROUTINE = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.API_CODE,dos);
					
					// String
				
						writeString(this.DESCRIPTION,dos);
					
					// int
				
		            	dos.writeInt(this.USER_DEFINED);
					
					// int
				
		            	dos.writeInt(this.DDE_VALUE);
					
					// int
				
		            	dos.writeInt(this.DENSITY_UNITS);
					
					// int
				
		            	dos.writeInt(this.PRESSURE_UNITS);
					
					// int
				
		            	dos.writeInt(this.DENSITY_PRECISION);
					
					// java.util.Date
				
						writeDate(this.LAST_MODIFIED,dos);
					
					// int
				
		            	dos.writeInt(this.COE_PRECISION);
					
					// double
				
		            	dos.writeDouble(this.DENSITY_UNITS_FACTOR);
					
					// String
				
						writeString(this.DENSITY_CORRECTION_ROUTINE,dos);
					
					// int
				
		            	dos.writeInt(this.WEIGHT_IN_AIR_METHOD);
					
					// String
				
						writeString(this.WEIGHT_IN_AIR_ROUTINE,dos);
					
					// double
				
		            	dos.writeDouble(this.WEIGHT_IN_AIR_FACTOR);
					
					// String
				
						writeString(this.LAST_USER_NAME,dos);
					
					// int
				
		            	dos.writeInt(this.TEMPERATURE_UNITS);
					
					// double
				
		            	dos.writeDouble(this.REFERENCE_TEMPERATURE);
					
					// int
				
		            	dos.writeInt(this.TEMPERATURE_PRECISION);
					
					// int
				
		            	dos.writeInt(this.PRESSURE_PRECISION);
					
					// int
				
		            	dos.writeInt(this.VCF_PRECISION);
					
					// double
				
		            	dos.writeDouble(this.MINIMUM_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.MAXIMUM_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.MINIMUM_PRESSURE);
					
					// double
				
		            	dos.writeDouble(this.MAXIMUM_PRESSURE);
					
					// double
				
		            	dos.writeDouble(this.MINIMUM_BASE_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.MAXIMUM_BASE_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.MINIMUM_OBSERVED_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.MAXIMUM_OBSERVED_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.MINIMUM_COE);
					
					// double
				
		            	dos.writeDouble(this.MAXIMUM_COE);
					
					// int
				
		            	dos.writeInt(this.COMMODITY_GROUP);
					
					// String
				
						writeString(this.DLL,dos);
					
					// int
				
		            	dos.writeInt(this.VOLUME_CORRECTION_METHOD);
					
					// String
				
						writeString(this.VOLUME_CORRECTION_ROUTINE,dos);
					
					// int
				
		            	dos.writeInt(this.DENSITY_CORRECTION_METHOD);
					
					// String
				
						writeString(this.DENSITY_CORRECTION_STD_API_COD,dos);
					
					// String
				
						writeString(this.DENSITY_UNITS_ROUTINE,dos);
					
					// double
				
		            	dos.writeDouble(this.INPUT_DENSITY_TEMPERATURE);
					
					// int
				
		            	dos.writeInt(this.WEIGHT_CONVERSION_METHOD);
					
					// String
				
						writeString(this.WEIGHT_CONVERSION_ROUTINE,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.API_CODE,dos);
					
					// String
				
						writeString(this.DESCRIPTION,dos);
					
					// int
				
		            	dos.writeInt(this.USER_DEFINED);
					
					// int
				
		            	dos.writeInt(this.DDE_VALUE);
					
					// int
				
		            	dos.writeInt(this.DENSITY_UNITS);
					
					// int
				
		            	dos.writeInt(this.PRESSURE_UNITS);
					
					// int
				
		            	dos.writeInt(this.DENSITY_PRECISION);
					
					// java.util.Date
				
						writeDate(this.LAST_MODIFIED,dos);
					
					// int
				
		            	dos.writeInt(this.COE_PRECISION);
					
					// double
				
		            	dos.writeDouble(this.DENSITY_UNITS_FACTOR);
					
					// String
				
						writeString(this.DENSITY_CORRECTION_ROUTINE,dos);
					
					// int
				
		            	dos.writeInt(this.WEIGHT_IN_AIR_METHOD);
					
					// String
				
						writeString(this.WEIGHT_IN_AIR_ROUTINE,dos);
					
					// double
				
		            	dos.writeDouble(this.WEIGHT_IN_AIR_FACTOR);
					
					// String
				
						writeString(this.LAST_USER_NAME,dos);
					
					// int
				
		            	dos.writeInt(this.TEMPERATURE_UNITS);
					
					// double
				
		            	dos.writeDouble(this.REFERENCE_TEMPERATURE);
					
					// int
				
		            	dos.writeInt(this.TEMPERATURE_PRECISION);
					
					// int
				
		            	dos.writeInt(this.PRESSURE_PRECISION);
					
					// int
				
		            	dos.writeInt(this.VCF_PRECISION);
					
					// double
				
		            	dos.writeDouble(this.MINIMUM_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.MAXIMUM_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.MINIMUM_PRESSURE);
					
					// double
				
		            	dos.writeDouble(this.MAXIMUM_PRESSURE);
					
					// double
				
		            	dos.writeDouble(this.MINIMUM_BASE_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.MAXIMUM_BASE_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.MINIMUM_OBSERVED_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.MAXIMUM_OBSERVED_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.MINIMUM_COE);
					
					// double
				
		            	dos.writeDouble(this.MAXIMUM_COE);
					
					// int
				
		            	dos.writeInt(this.COMMODITY_GROUP);
					
					// String
				
						writeString(this.DLL,dos);
					
					// int
				
		            	dos.writeInt(this.VOLUME_CORRECTION_METHOD);
					
					// String
				
						writeString(this.VOLUME_CORRECTION_ROUTINE,dos);
					
					// int
				
		            	dos.writeInt(this.DENSITY_CORRECTION_METHOD);
					
					// String
				
						writeString(this.DENSITY_CORRECTION_STD_API_COD,dos);
					
					// String
				
						writeString(this.DENSITY_UNITS_ROUTINE,dos);
					
					// double
				
		            	dos.writeDouble(this.INPUT_DENSITY_TEMPERATURE);
					
					// int
				
		            	dos.writeInt(this.WEIGHT_CONVERSION_METHOD);
					
					// String
				
						writeString(this.WEIGHT_CONVERSION_ROUTINE,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("API_CODE="+API_CODE);
		sb.append(",DESCRIPTION="+DESCRIPTION);
		sb.append(",USER_DEFINED="+String.valueOf(USER_DEFINED));
		sb.append(",DDE_VALUE="+String.valueOf(DDE_VALUE));
		sb.append(",DENSITY_UNITS="+String.valueOf(DENSITY_UNITS));
		sb.append(",PRESSURE_UNITS="+String.valueOf(PRESSURE_UNITS));
		sb.append(",DENSITY_PRECISION="+String.valueOf(DENSITY_PRECISION));
		sb.append(",LAST_MODIFIED="+String.valueOf(LAST_MODIFIED));
		sb.append(",COE_PRECISION="+String.valueOf(COE_PRECISION));
		sb.append(",DENSITY_UNITS_FACTOR="+String.valueOf(DENSITY_UNITS_FACTOR));
		sb.append(",DENSITY_CORRECTION_ROUTINE="+DENSITY_CORRECTION_ROUTINE);
		sb.append(",WEIGHT_IN_AIR_METHOD="+String.valueOf(WEIGHT_IN_AIR_METHOD));
		sb.append(",WEIGHT_IN_AIR_ROUTINE="+WEIGHT_IN_AIR_ROUTINE);
		sb.append(",WEIGHT_IN_AIR_FACTOR="+String.valueOf(WEIGHT_IN_AIR_FACTOR));
		sb.append(",LAST_USER_NAME="+LAST_USER_NAME);
		sb.append(",TEMPERATURE_UNITS="+String.valueOf(TEMPERATURE_UNITS));
		sb.append(",REFERENCE_TEMPERATURE="+String.valueOf(REFERENCE_TEMPERATURE));
		sb.append(",TEMPERATURE_PRECISION="+String.valueOf(TEMPERATURE_PRECISION));
		sb.append(",PRESSURE_PRECISION="+String.valueOf(PRESSURE_PRECISION));
		sb.append(",VCF_PRECISION="+String.valueOf(VCF_PRECISION));
		sb.append(",MINIMUM_TEMPERATURE="+String.valueOf(MINIMUM_TEMPERATURE));
		sb.append(",MAXIMUM_TEMPERATURE="+String.valueOf(MAXIMUM_TEMPERATURE));
		sb.append(",MINIMUM_PRESSURE="+String.valueOf(MINIMUM_PRESSURE));
		sb.append(",MAXIMUM_PRESSURE="+String.valueOf(MAXIMUM_PRESSURE));
		sb.append(",MINIMUM_BASE_DENSITY="+String.valueOf(MINIMUM_BASE_DENSITY));
		sb.append(",MAXIMUM_BASE_DENSITY="+String.valueOf(MAXIMUM_BASE_DENSITY));
		sb.append(",MINIMUM_OBSERVED_DENSITY="+String.valueOf(MINIMUM_OBSERVED_DENSITY));
		sb.append(",MAXIMUM_OBSERVED_DENSITY="+String.valueOf(MAXIMUM_OBSERVED_DENSITY));
		sb.append(",MINIMUM_COE="+String.valueOf(MINIMUM_COE));
		sb.append(",MAXIMUM_COE="+String.valueOf(MAXIMUM_COE));
		sb.append(",COMMODITY_GROUP="+String.valueOf(COMMODITY_GROUP));
		sb.append(",DLL="+DLL);
		sb.append(",VOLUME_CORRECTION_METHOD="+String.valueOf(VOLUME_CORRECTION_METHOD));
		sb.append(",VOLUME_CORRECTION_ROUTINE="+VOLUME_CORRECTION_ROUTINE);
		sb.append(",DENSITY_CORRECTION_METHOD="+String.valueOf(DENSITY_CORRECTION_METHOD));
		sb.append(",DENSITY_CORRECTION_STD_API_COD="+DENSITY_CORRECTION_STD_API_COD);
		sb.append(",DENSITY_UNITS_ROUTINE="+DENSITY_UNITS_ROUTINE);
		sb.append(",INPUT_DENSITY_TEMPERATURE="+String.valueOf(INPUT_DENSITY_TEMPERATURE));
		sb.append(",WEIGHT_CONVERSION_METHOD="+String.valueOf(WEIGHT_CONVERSION_METHOD));
		sb.append(",WEIGHT_CONVERSION_ROUTINE="+WEIGHT_CONVERSION_ROUTINE);
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
    final static byte[] commonByteArrayLock_PGS_STAGE_DIM_API = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_DIM_API = new byte[0];

	
			    public String API_CODE;

				public String getAPI_CODE () {
					return this.API_CODE;
				}
				
			    public String DESCRIPTION;

				public String getDESCRIPTION () {
					return this.DESCRIPTION;
				}
				
			    public int USER_DEFINED;

				public int getUSER_DEFINED () {
					return this.USER_DEFINED;
				}
				
			    public int DDE_VALUE;

				public int getDDE_VALUE () {
					return this.DDE_VALUE;
				}
				
			    public int DENSITY_UNITS;

				public int getDENSITY_UNITS () {
					return this.DENSITY_UNITS;
				}
				
			    public int PRESSURE_UNITS;

				public int getPRESSURE_UNITS () {
					return this.PRESSURE_UNITS;
				}
				
			    public int DENSITY_PRECISION;

				public int getDENSITY_PRECISION () {
					return this.DENSITY_PRECISION;
				}
				
			    public java.util.Date LAST_MODIFIED;

				public java.util.Date getLAST_MODIFIED () {
					return this.LAST_MODIFIED;
				}
				
			    public int COE_PRECISION;

				public int getCOE_PRECISION () {
					return this.COE_PRECISION;
				}
				
			    public double DENSITY_UNITS_FACTOR;

				public double getDENSITY_UNITS_FACTOR () {
					return this.DENSITY_UNITS_FACTOR;
				}
				
			    public String DENSITY_CORRECTION_ROUTINE;

				public String getDENSITY_CORRECTION_ROUTINE () {
					return this.DENSITY_CORRECTION_ROUTINE;
				}
				
			    public int WEIGHT_IN_AIR_METHOD;

				public int getWEIGHT_IN_AIR_METHOD () {
					return this.WEIGHT_IN_AIR_METHOD;
				}
				
			    public String WEIGHT_IN_AIR_ROUTINE;

				public String getWEIGHT_IN_AIR_ROUTINE () {
					return this.WEIGHT_IN_AIR_ROUTINE;
				}
				
			    public double WEIGHT_IN_AIR_FACTOR;

				public double getWEIGHT_IN_AIR_FACTOR () {
					return this.WEIGHT_IN_AIR_FACTOR;
				}
				
			    public String LAST_USER_NAME;

				public String getLAST_USER_NAME () {
					return this.LAST_USER_NAME;
				}
				
			    public int TEMPERATURE_UNITS;

				public int getTEMPERATURE_UNITS () {
					return this.TEMPERATURE_UNITS;
				}
				
			    public double REFERENCE_TEMPERATURE;

				public double getREFERENCE_TEMPERATURE () {
					return this.REFERENCE_TEMPERATURE;
				}
				
			    public int TEMPERATURE_PRECISION;

				public int getTEMPERATURE_PRECISION () {
					return this.TEMPERATURE_PRECISION;
				}
				
			    public int PRESSURE_PRECISION;

				public int getPRESSURE_PRECISION () {
					return this.PRESSURE_PRECISION;
				}
				
			    public int VCF_PRECISION;

				public int getVCF_PRECISION () {
					return this.VCF_PRECISION;
				}
				
			    public double MINIMUM_TEMPERATURE;

				public double getMINIMUM_TEMPERATURE () {
					return this.MINIMUM_TEMPERATURE;
				}
				
			    public double MAXIMUM_TEMPERATURE;

				public double getMAXIMUM_TEMPERATURE () {
					return this.MAXIMUM_TEMPERATURE;
				}
				
			    public double MINIMUM_PRESSURE;

				public double getMINIMUM_PRESSURE () {
					return this.MINIMUM_PRESSURE;
				}
				
			    public double MAXIMUM_PRESSURE;

				public double getMAXIMUM_PRESSURE () {
					return this.MAXIMUM_PRESSURE;
				}
				
			    public double MINIMUM_BASE_DENSITY;

				public double getMINIMUM_BASE_DENSITY () {
					return this.MINIMUM_BASE_DENSITY;
				}
				
			    public double MAXIMUM_BASE_DENSITY;

				public double getMAXIMUM_BASE_DENSITY () {
					return this.MAXIMUM_BASE_DENSITY;
				}
				
			    public double MINIMUM_OBSERVED_DENSITY;

				public double getMINIMUM_OBSERVED_DENSITY () {
					return this.MINIMUM_OBSERVED_DENSITY;
				}
				
			    public double MAXIMUM_OBSERVED_DENSITY;

				public double getMAXIMUM_OBSERVED_DENSITY () {
					return this.MAXIMUM_OBSERVED_DENSITY;
				}
				
			    public double MINIMUM_COE;

				public double getMINIMUM_COE () {
					return this.MINIMUM_COE;
				}
				
			    public double MAXIMUM_COE;

				public double getMAXIMUM_COE () {
					return this.MAXIMUM_COE;
				}
				
			    public int COMMODITY_GROUP;

				public int getCOMMODITY_GROUP () {
					return this.COMMODITY_GROUP;
				}
				
			    public String DLL;

				public String getDLL () {
					return this.DLL;
				}
				
			    public int VOLUME_CORRECTION_METHOD;

				public int getVOLUME_CORRECTION_METHOD () {
					return this.VOLUME_CORRECTION_METHOD;
				}
				
			    public String VOLUME_CORRECTION_ROUTINE;

				public String getVOLUME_CORRECTION_ROUTINE () {
					return this.VOLUME_CORRECTION_ROUTINE;
				}
				
			    public int DENSITY_CORRECTION_METHOD;

				public int getDENSITY_CORRECTION_METHOD () {
					return this.DENSITY_CORRECTION_METHOD;
				}
				
			    public String DENSITY_CORRECTION_STD_API_COD;

				public String getDENSITY_CORRECTION_STD_API_COD () {
					return this.DENSITY_CORRECTION_STD_API_COD;
				}
				
			    public String DENSITY_UNITS_ROUTINE;

				public String getDENSITY_UNITS_ROUTINE () {
					return this.DENSITY_UNITS_ROUTINE;
				}
				
			    public double INPUT_DENSITY_TEMPERATURE;

				public double getINPUT_DENSITY_TEMPERATURE () {
					return this.INPUT_DENSITY_TEMPERATURE;
				}
				
			    public int WEIGHT_CONVERSION_METHOD;

				public int getWEIGHT_CONVERSION_METHOD () {
					return this.WEIGHT_CONVERSION_METHOD;
				}
				
			    public String WEIGHT_CONVERSION_ROUTINE;

				public String getWEIGHT_CONVERSION_ROUTINE () {
					return this.WEIGHT_CONVERSION_ROUTINE;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PGS_STAGE_DIM_API.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_API.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_API = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_API = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PGS_STAGE_DIM_API, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_API, 0, length, utf8Charset);
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
			if(length > commonByteArray_PGS_STAGE_DIM_API.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_API.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_API = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_API = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PGS_STAGE_DIM_API, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_API, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_API) {

        	try {

        		int length = 0;
		
					this.API_CODE = readString(dis);
					
					this.DESCRIPTION = readString(dis);
					
			        this.USER_DEFINED = dis.readInt();
					
			        this.DDE_VALUE = dis.readInt();
					
			        this.DENSITY_UNITS = dis.readInt();
					
			        this.PRESSURE_UNITS = dis.readInt();
					
			        this.DENSITY_PRECISION = dis.readInt();
					
					this.LAST_MODIFIED = readDate(dis);
					
			        this.COE_PRECISION = dis.readInt();
					
			        this.DENSITY_UNITS_FACTOR = dis.readDouble();
					
					this.DENSITY_CORRECTION_ROUTINE = readString(dis);
					
			        this.WEIGHT_IN_AIR_METHOD = dis.readInt();
					
					this.WEIGHT_IN_AIR_ROUTINE = readString(dis);
					
			        this.WEIGHT_IN_AIR_FACTOR = dis.readDouble();
					
					this.LAST_USER_NAME = readString(dis);
					
			        this.TEMPERATURE_UNITS = dis.readInt();
					
			        this.REFERENCE_TEMPERATURE = dis.readDouble();
					
			        this.TEMPERATURE_PRECISION = dis.readInt();
					
			        this.PRESSURE_PRECISION = dis.readInt();
					
			        this.VCF_PRECISION = dis.readInt();
					
			        this.MINIMUM_TEMPERATURE = dis.readDouble();
					
			        this.MAXIMUM_TEMPERATURE = dis.readDouble();
					
			        this.MINIMUM_PRESSURE = dis.readDouble();
					
			        this.MAXIMUM_PRESSURE = dis.readDouble();
					
			        this.MINIMUM_BASE_DENSITY = dis.readDouble();
					
			        this.MAXIMUM_BASE_DENSITY = dis.readDouble();
					
			        this.MINIMUM_OBSERVED_DENSITY = dis.readDouble();
					
			        this.MAXIMUM_OBSERVED_DENSITY = dis.readDouble();
					
			        this.MINIMUM_COE = dis.readDouble();
					
			        this.MAXIMUM_COE = dis.readDouble();
					
			        this.COMMODITY_GROUP = dis.readInt();
					
					this.DLL = readString(dis);
					
			        this.VOLUME_CORRECTION_METHOD = dis.readInt();
					
					this.VOLUME_CORRECTION_ROUTINE = readString(dis);
					
			        this.DENSITY_CORRECTION_METHOD = dis.readInt();
					
					this.DENSITY_CORRECTION_STD_API_COD = readString(dis);
					
					this.DENSITY_UNITS_ROUTINE = readString(dis);
					
			        this.INPUT_DENSITY_TEMPERATURE = dis.readDouble();
					
			        this.WEIGHT_CONVERSION_METHOD = dis.readInt();
					
					this.WEIGHT_CONVERSION_ROUTINE = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_API) {

        	try {

        		int length = 0;
		
					this.API_CODE = readString(dis);
					
					this.DESCRIPTION = readString(dis);
					
			        this.USER_DEFINED = dis.readInt();
					
			        this.DDE_VALUE = dis.readInt();
					
			        this.DENSITY_UNITS = dis.readInt();
					
			        this.PRESSURE_UNITS = dis.readInt();
					
			        this.DENSITY_PRECISION = dis.readInt();
					
					this.LAST_MODIFIED = readDate(dis);
					
			        this.COE_PRECISION = dis.readInt();
					
			        this.DENSITY_UNITS_FACTOR = dis.readDouble();
					
					this.DENSITY_CORRECTION_ROUTINE = readString(dis);
					
			        this.WEIGHT_IN_AIR_METHOD = dis.readInt();
					
					this.WEIGHT_IN_AIR_ROUTINE = readString(dis);
					
			        this.WEIGHT_IN_AIR_FACTOR = dis.readDouble();
					
					this.LAST_USER_NAME = readString(dis);
					
			        this.TEMPERATURE_UNITS = dis.readInt();
					
			        this.REFERENCE_TEMPERATURE = dis.readDouble();
					
			        this.TEMPERATURE_PRECISION = dis.readInt();
					
			        this.PRESSURE_PRECISION = dis.readInt();
					
			        this.VCF_PRECISION = dis.readInt();
					
			        this.MINIMUM_TEMPERATURE = dis.readDouble();
					
			        this.MAXIMUM_TEMPERATURE = dis.readDouble();
					
			        this.MINIMUM_PRESSURE = dis.readDouble();
					
			        this.MAXIMUM_PRESSURE = dis.readDouble();
					
			        this.MINIMUM_BASE_DENSITY = dis.readDouble();
					
			        this.MAXIMUM_BASE_DENSITY = dis.readDouble();
					
			        this.MINIMUM_OBSERVED_DENSITY = dis.readDouble();
					
			        this.MAXIMUM_OBSERVED_DENSITY = dis.readDouble();
					
			        this.MINIMUM_COE = dis.readDouble();
					
			        this.MAXIMUM_COE = dis.readDouble();
					
			        this.COMMODITY_GROUP = dis.readInt();
					
					this.DLL = readString(dis);
					
			        this.VOLUME_CORRECTION_METHOD = dis.readInt();
					
					this.VOLUME_CORRECTION_ROUTINE = readString(dis);
					
			        this.DENSITY_CORRECTION_METHOD = dis.readInt();
					
					this.DENSITY_CORRECTION_STD_API_COD = readString(dis);
					
					this.DENSITY_UNITS_ROUTINE = readString(dis);
					
			        this.INPUT_DENSITY_TEMPERATURE = dis.readDouble();
					
			        this.WEIGHT_CONVERSION_METHOD = dis.readInt();
					
					this.WEIGHT_CONVERSION_ROUTINE = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.API_CODE,dos);
					
					// String
				
						writeString(this.DESCRIPTION,dos);
					
					// int
				
		            	dos.writeInt(this.USER_DEFINED);
					
					// int
				
		            	dos.writeInt(this.DDE_VALUE);
					
					// int
				
		            	dos.writeInt(this.DENSITY_UNITS);
					
					// int
				
		            	dos.writeInt(this.PRESSURE_UNITS);
					
					// int
				
		            	dos.writeInt(this.DENSITY_PRECISION);
					
					// java.util.Date
				
						writeDate(this.LAST_MODIFIED,dos);
					
					// int
				
		            	dos.writeInt(this.COE_PRECISION);
					
					// double
				
		            	dos.writeDouble(this.DENSITY_UNITS_FACTOR);
					
					// String
				
						writeString(this.DENSITY_CORRECTION_ROUTINE,dos);
					
					// int
				
		            	dos.writeInt(this.WEIGHT_IN_AIR_METHOD);
					
					// String
				
						writeString(this.WEIGHT_IN_AIR_ROUTINE,dos);
					
					// double
				
		            	dos.writeDouble(this.WEIGHT_IN_AIR_FACTOR);
					
					// String
				
						writeString(this.LAST_USER_NAME,dos);
					
					// int
				
		            	dos.writeInt(this.TEMPERATURE_UNITS);
					
					// double
				
		            	dos.writeDouble(this.REFERENCE_TEMPERATURE);
					
					// int
				
		            	dos.writeInt(this.TEMPERATURE_PRECISION);
					
					// int
				
		            	dos.writeInt(this.PRESSURE_PRECISION);
					
					// int
				
		            	dos.writeInt(this.VCF_PRECISION);
					
					// double
				
		            	dos.writeDouble(this.MINIMUM_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.MAXIMUM_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.MINIMUM_PRESSURE);
					
					// double
				
		            	dos.writeDouble(this.MAXIMUM_PRESSURE);
					
					// double
				
		            	dos.writeDouble(this.MINIMUM_BASE_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.MAXIMUM_BASE_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.MINIMUM_OBSERVED_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.MAXIMUM_OBSERVED_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.MINIMUM_COE);
					
					// double
				
		            	dos.writeDouble(this.MAXIMUM_COE);
					
					// int
				
		            	dos.writeInt(this.COMMODITY_GROUP);
					
					// String
				
						writeString(this.DLL,dos);
					
					// int
				
		            	dos.writeInt(this.VOLUME_CORRECTION_METHOD);
					
					// String
				
						writeString(this.VOLUME_CORRECTION_ROUTINE,dos);
					
					// int
				
		            	dos.writeInt(this.DENSITY_CORRECTION_METHOD);
					
					// String
				
						writeString(this.DENSITY_CORRECTION_STD_API_COD,dos);
					
					// String
				
						writeString(this.DENSITY_UNITS_ROUTINE,dos);
					
					// double
				
		            	dos.writeDouble(this.INPUT_DENSITY_TEMPERATURE);
					
					// int
				
		            	dos.writeInt(this.WEIGHT_CONVERSION_METHOD);
					
					// String
				
						writeString(this.WEIGHT_CONVERSION_ROUTINE,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.API_CODE,dos);
					
					// String
				
						writeString(this.DESCRIPTION,dos);
					
					// int
				
		            	dos.writeInt(this.USER_DEFINED);
					
					// int
				
		            	dos.writeInt(this.DDE_VALUE);
					
					// int
				
		            	dos.writeInt(this.DENSITY_UNITS);
					
					// int
				
		            	dos.writeInt(this.PRESSURE_UNITS);
					
					// int
				
		            	dos.writeInt(this.DENSITY_PRECISION);
					
					// java.util.Date
				
						writeDate(this.LAST_MODIFIED,dos);
					
					// int
				
		            	dos.writeInt(this.COE_PRECISION);
					
					// double
				
		            	dos.writeDouble(this.DENSITY_UNITS_FACTOR);
					
					// String
				
						writeString(this.DENSITY_CORRECTION_ROUTINE,dos);
					
					// int
				
		            	dos.writeInt(this.WEIGHT_IN_AIR_METHOD);
					
					// String
				
						writeString(this.WEIGHT_IN_AIR_ROUTINE,dos);
					
					// double
				
		            	dos.writeDouble(this.WEIGHT_IN_AIR_FACTOR);
					
					// String
				
						writeString(this.LAST_USER_NAME,dos);
					
					// int
				
		            	dos.writeInt(this.TEMPERATURE_UNITS);
					
					// double
				
		            	dos.writeDouble(this.REFERENCE_TEMPERATURE);
					
					// int
				
		            	dos.writeInt(this.TEMPERATURE_PRECISION);
					
					// int
				
		            	dos.writeInt(this.PRESSURE_PRECISION);
					
					// int
				
		            	dos.writeInt(this.VCF_PRECISION);
					
					// double
				
		            	dos.writeDouble(this.MINIMUM_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.MAXIMUM_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.MINIMUM_PRESSURE);
					
					// double
				
		            	dos.writeDouble(this.MAXIMUM_PRESSURE);
					
					// double
				
		            	dos.writeDouble(this.MINIMUM_BASE_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.MAXIMUM_BASE_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.MINIMUM_OBSERVED_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.MAXIMUM_OBSERVED_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.MINIMUM_COE);
					
					// double
				
		            	dos.writeDouble(this.MAXIMUM_COE);
					
					// int
				
		            	dos.writeInt(this.COMMODITY_GROUP);
					
					// String
				
						writeString(this.DLL,dos);
					
					// int
				
		            	dos.writeInt(this.VOLUME_CORRECTION_METHOD);
					
					// String
				
						writeString(this.VOLUME_CORRECTION_ROUTINE,dos);
					
					// int
				
		            	dos.writeInt(this.DENSITY_CORRECTION_METHOD);
					
					// String
				
						writeString(this.DENSITY_CORRECTION_STD_API_COD,dos);
					
					// String
				
						writeString(this.DENSITY_UNITS_ROUTINE,dos);
					
					// double
				
		            	dos.writeDouble(this.INPUT_DENSITY_TEMPERATURE);
					
					// int
				
		            	dos.writeInt(this.WEIGHT_CONVERSION_METHOD);
					
					// String
				
						writeString(this.WEIGHT_CONVERSION_ROUTINE,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("API_CODE="+API_CODE);
		sb.append(",DESCRIPTION="+DESCRIPTION);
		sb.append(",USER_DEFINED="+String.valueOf(USER_DEFINED));
		sb.append(",DDE_VALUE="+String.valueOf(DDE_VALUE));
		sb.append(",DENSITY_UNITS="+String.valueOf(DENSITY_UNITS));
		sb.append(",PRESSURE_UNITS="+String.valueOf(PRESSURE_UNITS));
		sb.append(",DENSITY_PRECISION="+String.valueOf(DENSITY_PRECISION));
		sb.append(",LAST_MODIFIED="+String.valueOf(LAST_MODIFIED));
		sb.append(",COE_PRECISION="+String.valueOf(COE_PRECISION));
		sb.append(",DENSITY_UNITS_FACTOR="+String.valueOf(DENSITY_UNITS_FACTOR));
		sb.append(",DENSITY_CORRECTION_ROUTINE="+DENSITY_CORRECTION_ROUTINE);
		sb.append(",WEIGHT_IN_AIR_METHOD="+String.valueOf(WEIGHT_IN_AIR_METHOD));
		sb.append(",WEIGHT_IN_AIR_ROUTINE="+WEIGHT_IN_AIR_ROUTINE);
		sb.append(",WEIGHT_IN_AIR_FACTOR="+String.valueOf(WEIGHT_IN_AIR_FACTOR));
		sb.append(",LAST_USER_NAME="+LAST_USER_NAME);
		sb.append(",TEMPERATURE_UNITS="+String.valueOf(TEMPERATURE_UNITS));
		sb.append(",REFERENCE_TEMPERATURE="+String.valueOf(REFERENCE_TEMPERATURE));
		sb.append(",TEMPERATURE_PRECISION="+String.valueOf(TEMPERATURE_PRECISION));
		sb.append(",PRESSURE_PRECISION="+String.valueOf(PRESSURE_PRECISION));
		sb.append(",VCF_PRECISION="+String.valueOf(VCF_PRECISION));
		sb.append(",MINIMUM_TEMPERATURE="+String.valueOf(MINIMUM_TEMPERATURE));
		sb.append(",MAXIMUM_TEMPERATURE="+String.valueOf(MAXIMUM_TEMPERATURE));
		sb.append(",MINIMUM_PRESSURE="+String.valueOf(MINIMUM_PRESSURE));
		sb.append(",MAXIMUM_PRESSURE="+String.valueOf(MAXIMUM_PRESSURE));
		sb.append(",MINIMUM_BASE_DENSITY="+String.valueOf(MINIMUM_BASE_DENSITY));
		sb.append(",MAXIMUM_BASE_DENSITY="+String.valueOf(MAXIMUM_BASE_DENSITY));
		sb.append(",MINIMUM_OBSERVED_DENSITY="+String.valueOf(MINIMUM_OBSERVED_DENSITY));
		sb.append(",MAXIMUM_OBSERVED_DENSITY="+String.valueOf(MAXIMUM_OBSERVED_DENSITY));
		sb.append(",MINIMUM_COE="+String.valueOf(MINIMUM_COE));
		sb.append(",MAXIMUM_COE="+String.valueOf(MAXIMUM_COE));
		sb.append(",COMMODITY_GROUP="+String.valueOf(COMMODITY_GROUP));
		sb.append(",DLL="+DLL);
		sb.append(",VOLUME_CORRECTION_METHOD="+String.valueOf(VOLUME_CORRECTION_METHOD));
		sb.append(",VOLUME_CORRECTION_ROUTINE="+VOLUME_CORRECTION_ROUTINE);
		sb.append(",DENSITY_CORRECTION_METHOD="+String.valueOf(DENSITY_CORRECTION_METHOD));
		sb.append(",DENSITY_CORRECTION_STD_API_COD="+DENSITY_CORRECTION_STD_API_COD);
		sb.append(",DENSITY_UNITS_ROUTINE="+DENSITY_UNITS_ROUTINE);
		sb.append(",INPUT_DENSITY_TEMPERATURE="+String.valueOf(INPUT_DENSITY_TEMPERATURE));
		sb.append(",WEIGHT_CONVERSION_METHOD="+String.valueOf(WEIGHT_CONVERSION_METHOD));
		sb.append(",WEIGHT_CONVERSION_ROUTINE="+WEIGHT_CONVERSION_ROUTINE);
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
        } else if (updateKeyCount_tDBOutput_1 == 17 && true) {
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

 
	final String decryptedPassword_tDBOutput_1 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:7Pw9x+aiBl8fIgjOar/Q9iR3Nmm+DNUR2MjZE+dNkLgTCDoopBs=");

    String dbPwd_tDBOutput_1 = decryptedPassword_tDBOutput_1;	
    conn_tDBOutput_1 = java.sql.DriverManager.getConnection(url_tDBOutput_1,dbUser_tDBOutput_1,dbPwd_tDBOutput_1);
	
		resourceMap.put("conn_tDBOutput_1", conn_tDBOutput_1);
	
        conn_tDBOutput_1.setAutoCommit(false);
        int commitEvery_tDBOutput_1 = 10000;
        int commitCounter_tDBOutput_1 = 0;


if(dbschema_tDBOutput_1 == null || dbschema_tDBOutput_1.trim().length() == 0) {
    tableName_tDBOutput_1 = "DIM_API";
} else {
    tableName_tDBOutput_1 = dbschema_tDBOutput_1 + "].[" + "DIM_API";
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
                                        stmtCreate_tDBOutput_1.execute("CREATE TABLE [" + tableName_tDBOutput_1 + "]([PK_API] INT ,[API_CODE] VARCHAR(4)   not null ,[DESCRIPTION] VARCHAR(80)  ,[USER_DEFINED] INT  not null ,[DENSITY_UNITS] INT  not null ,[DENSITY_PRECISION] INT  not null ,[COE_PRECISION] INT  not null ,[WEIGHT_IN_AIR_METHOD] INT  not null ,[TEMPERATURE_UNITS] INT  not null ,[REFERENCE_TEMPERATURE] FLOAT(53)   not null ,[TEMPERATURE_PRECISION] INT  not null ,[MAXIMUM_PRESSURE] FLOAT(53)   not null ,[COMMODITY_GROUP] INT  not null ,[DLL] VARCHAR(60)  ,[VOLUME_CORRECTION_METHOD] INT  not null ,[VOLUME_CORRECTION_ROUTINE] VARCHAR(40)  ,[DENSITY_CORRECTION_METHOD] INT  not null ,primary key([PK_API]))");
                                    }
                                }
        java.sql.PreparedStatement pstmt_tDBOutput_1 = conn_tDBOutput_1.prepareStatement("SELECT COUNT(1) FROM [" + tableName_tDBOutput_1 + "] WHERE [PK_API] = ?");
        resourceMap.put("pstmt_tDBOutput_1", pstmt_tDBOutput_1);
        String insert_tDBOutput_1 = "INSERT INTO [" + tableName_tDBOutput_1 + "] ([PK_API],[API_CODE],[DESCRIPTION],[USER_DEFINED],[DENSITY_UNITS],[DENSITY_PRECISION],[COE_PRECISION],[WEIGHT_IN_AIR_METHOD],[TEMPERATURE_UNITS],[REFERENCE_TEMPERATURE],[TEMPERATURE_PRECISION],[MAXIMUM_PRESSURE],[COMMODITY_GROUP],[DLL],[VOLUME_CORRECTION_METHOD],[VOLUME_CORRECTION_ROUTINE],[DENSITY_CORRECTION_METHOD]) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        java.sql.PreparedStatement pstmtInsert_tDBOutput_1 = conn_tDBOutput_1.prepareStatement(insert_tDBOutput_1);
        resourceMap.put("pstmtInsert_tDBOutput_1", pstmtInsert_tDBOutput_1);
        String update_tDBOutput_1 = "UPDATE [" + tableName_tDBOutput_1 + "] SET [API_CODE] = ?,[DESCRIPTION] = ?,[USER_DEFINED] = ?,[DENSITY_UNITS] = ?,[DENSITY_PRECISION] = ?,[COE_PRECISION] = ?,[WEIGHT_IN_AIR_METHOD] = ?,[TEMPERATURE_UNITS] = ?,[REFERENCE_TEMPERATURE] = ?,[TEMPERATURE_PRECISION] = ?,[MAXIMUM_PRESSURE] = ?,[COMMODITY_GROUP] = ?,[DLL] = ?,[VOLUME_CORRECTION_METHOD] = ?,[VOLUME_CORRECTION_ROUTINE] = ?,[DENSITY_CORRECTION_METHOD] = ? WHERE [PK_API] = ?";
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
	int PK_API;
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
	
	        
					String API_CODE;        
	        
		    @Override
			public int hashCode() {
				if (this.hashCodeDirty) {
					final int prime = PRIME;
					int result = DEFAULT_HASHCODE;
			
								result = prime * result + ((this.API_CODE == null) ? 0 : this.API_CODE.hashCode());
								
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
				
									if (this.API_CODE == null) {
										if (other.API_CODE != null) 
											return false;
								
									} else if (!this.API_CODE.equals(other.API_CODE))
								 
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
				
				 
	final String decryptedPassword_tDBInput_1 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:xc3GyIVdKvAMiNwSRUkt49jbb28y3LVLhbw+xsaZBxbIInsWxvE=");
				
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

		    String dbquery_tDBInput_1 = "SELECT dbo.API_TABLE.API_CODE,\n		dbo.API_TABLE.DESCRIPTION,\n		dbo.API_TABLE.USER_DEFINED,\n		dbo.API_TABLE.DDE_VALUE,\n		"
+"dbo.API_TABLE.DENSITY_UNITS,\n		dbo.API_TABLE.PRESSURE_UNITS,\n		dbo.API_TABLE.DENSITY_PRECISION,\n		dbo.API_TABLE.LAST_MOD"
+"IFIED,\n		dbo.API_TABLE.COE_PRECISION,\n		dbo.API_TABLE.DENSITY_UNITS_FACTOR,\n		dbo.API_TABLE.DENSITY_CORRECTION_ROUTINE,\n"
+"		dbo.API_TABLE.WEIGHT_IN_AIR_METHOD,\n		dbo.API_TABLE.WEIGHT_IN_AIR_ROUTINE,\n		dbo.API_TABLE.WEIGHT_IN_AIR_FACTOR,\n		dbo"
+".API_TABLE.LAST_USER_NAME,\n		dbo.API_TABLE.TEMPERATURE_UNITS,\n		dbo.API_TABLE.REFERENCE_TEMPERATURE,\n		dbo.API_TABLE.TEM"
+"PERATURE_PRECISION,\n		dbo.API_TABLE.PRESSURE_PRECISION,\n		dbo.API_TABLE.VCF_PRECISION,\n		dbo.API_TABLE.MINIMUM_TEMPERATU"
+"RE,\n		dbo.API_TABLE.MAXIMUM_TEMPERATURE,\n		dbo.API_TABLE.MINIMUM_PRESSURE,\n		dbo.API_TABLE.MAXIMUM_PRESSURE,\n		dbo.API_T"
+"ABLE.MINIMUM_BASE_DENSITY,\n		dbo.API_TABLE.MAXIMUM_BASE_DENSITY,\n		dbo.API_TABLE.MINIMUM_OBSERVED_DENSITY,\n		dbo.API_TAB"
+"LE.MAXIMUM_OBSERVED_DENSITY,\n		dbo.API_TABLE.MINIMUM_COE,\n		dbo.API_TABLE.MAXIMUM_COE,\n		dbo.API_TABLE.COMMODITY_GROUP,\n"
+"		dbo.API_TABLE.DLL,\n		dbo.API_TABLE.VOLUME_CORRECTION_METHOD,\n		dbo.API_TABLE.VOLUME_CORRECTION_ROUTINE,\n		dbo.API_TABL"
+"E.DENSITY_CORRECTION_METHOD,\n		dbo.API_TABLE.DENSITY_CORRECTION_STD_API_COD,\n		dbo.API_TABLE.DENSITY_UNITS_ROUTINE,\n		db"
+"o.API_TABLE.INPUT_DENSITY_TEMPERATURE,\n		dbo.API_TABLE.WEIGHT_CONVERSION_METHOD,\n		dbo.API_TABLE.WEIGHT_CONVERSION_ROUTI"
+"NE\nFROM	dbo.API_TABLE";
		    

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
								row1.API_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(1);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(1).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.API_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.API_CODE = tmpContent_tDBInput_1;
                }
            } else {
                row1.API_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 2) {
								row1.DESCRIPTION = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(2);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(2).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.DESCRIPTION = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.DESCRIPTION = tmpContent_tDBInput_1;
                }
            } else {
                row1.DESCRIPTION = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 3) {
								row1.USER_DEFINED = 0;
							} else {
		                          
            row1.USER_DEFINED = rs_tDBInput_1.getInt(3);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 4) {
								row1.DDE_VALUE = 0;
							} else {
		                          
            row1.DDE_VALUE = rs_tDBInput_1.getInt(4);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 5) {
								row1.DENSITY_UNITS = 0;
							} else {
		                          
            row1.DENSITY_UNITS = rs_tDBInput_1.getInt(5);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 6) {
								row1.PRESSURE_UNITS = 0;
							} else {
		                          
            row1.PRESSURE_UNITS = rs_tDBInput_1.getInt(6);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 7) {
								row1.DENSITY_PRECISION = 0;
							} else {
		                          
            row1.DENSITY_PRECISION = rs_tDBInput_1.getInt(7);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 8) {
								row1.LAST_MODIFIED = null;
							} else {
										
			row1.LAST_MODIFIED = mssqlGTU_tDBInput_1.getDate(rsmd_tDBInput_1, rs_tDBInput_1, 8);
			
		                    }
							if(colQtyInRs_tDBInput_1 < 9) {
								row1.COE_PRECISION = 0;
							} else {
		                          
            row1.COE_PRECISION = rs_tDBInput_1.getInt(9);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 10) {
								row1.DENSITY_UNITS_FACTOR = 0;
							} else {
	                         		
            row1.DENSITY_UNITS_FACTOR = rs_tDBInput_1.getDouble(10);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 11) {
								row1.DENSITY_CORRECTION_ROUTINE = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(11);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(11).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.DENSITY_CORRECTION_ROUTINE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.DENSITY_CORRECTION_ROUTINE = tmpContent_tDBInput_1;
                }
            } else {
                row1.DENSITY_CORRECTION_ROUTINE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 12) {
								row1.WEIGHT_IN_AIR_METHOD = 0;
							} else {
		                          
            row1.WEIGHT_IN_AIR_METHOD = rs_tDBInput_1.getInt(12);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 13) {
								row1.WEIGHT_IN_AIR_ROUTINE = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(13);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(13).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.WEIGHT_IN_AIR_ROUTINE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.WEIGHT_IN_AIR_ROUTINE = tmpContent_tDBInput_1;
                }
            } else {
                row1.WEIGHT_IN_AIR_ROUTINE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 14) {
								row1.WEIGHT_IN_AIR_FACTOR = 0;
							} else {
	                         		
            row1.WEIGHT_IN_AIR_FACTOR = rs_tDBInput_1.getDouble(14);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 15) {
								row1.LAST_USER_NAME = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(15);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(15).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.LAST_USER_NAME = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.LAST_USER_NAME = tmpContent_tDBInput_1;
                }
            } else {
                row1.LAST_USER_NAME = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 16) {
								row1.TEMPERATURE_UNITS = 0;
							} else {
		                          
            row1.TEMPERATURE_UNITS = rs_tDBInput_1.getInt(16);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 17) {
								row1.REFERENCE_TEMPERATURE = 0;
							} else {
	                         		
            row1.REFERENCE_TEMPERATURE = rs_tDBInput_1.getDouble(17);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 18) {
								row1.TEMPERATURE_PRECISION = 0;
							} else {
		                          
            row1.TEMPERATURE_PRECISION = rs_tDBInput_1.getInt(18);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 19) {
								row1.PRESSURE_PRECISION = 0;
							} else {
		                          
            row1.PRESSURE_PRECISION = rs_tDBInput_1.getInt(19);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 20) {
								row1.VCF_PRECISION = 0;
							} else {
		                          
            row1.VCF_PRECISION = rs_tDBInput_1.getInt(20);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 21) {
								row1.MINIMUM_TEMPERATURE = 0;
							} else {
	                         		
            row1.MINIMUM_TEMPERATURE = rs_tDBInput_1.getDouble(21);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 22) {
								row1.MAXIMUM_TEMPERATURE = 0;
							} else {
	                         		
            row1.MAXIMUM_TEMPERATURE = rs_tDBInput_1.getDouble(22);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 23) {
								row1.MINIMUM_PRESSURE = 0;
							} else {
	                         		
            row1.MINIMUM_PRESSURE = rs_tDBInput_1.getDouble(23);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 24) {
								row1.MAXIMUM_PRESSURE = 0;
							} else {
	                         		
            row1.MAXIMUM_PRESSURE = rs_tDBInput_1.getDouble(24);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 25) {
								row1.MINIMUM_BASE_DENSITY = 0;
							} else {
	                         		
            row1.MINIMUM_BASE_DENSITY = rs_tDBInput_1.getDouble(25);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 26) {
								row1.MAXIMUM_BASE_DENSITY = 0;
							} else {
	                         		
            row1.MAXIMUM_BASE_DENSITY = rs_tDBInput_1.getDouble(26);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 27) {
								row1.MINIMUM_OBSERVED_DENSITY = 0;
							} else {
	                         		
            row1.MINIMUM_OBSERVED_DENSITY = rs_tDBInput_1.getDouble(27);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 28) {
								row1.MAXIMUM_OBSERVED_DENSITY = 0;
							} else {
	                         		
            row1.MAXIMUM_OBSERVED_DENSITY = rs_tDBInput_1.getDouble(28);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 29) {
								row1.MINIMUM_COE = 0;
							} else {
	                         		
            row1.MINIMUM_COE = rs_tDBInput_1.getDouble(29);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 30) {
								row1.MAXIMUM_COE = 0;
							} else {
	                         		
            row1.MAXIMUM_COE = rs_tDBInput_1.getDouble(30);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 31) {
								row1.COMMODITY_GROUP = 0;
							} else {
		                          
            row1.COMMODITY_GROUP = rs_tDBInput_1.getInt(31);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 32) {
								row1.DLL = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(32);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(32).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.DLL = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.DLL = tmpContent_tDBInput_1;
                }
            } else {
                row1.DLL = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 33) {
								row1.VOLUME_CORRECTION_METHOD = 0;
							} else {
		                          
            row1.VOLUME_CORRECTION_METHOD = rs_tDBInput_1.getInt(33);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 34) {
								row1.VOLUME_CORRECTION_ROUTINE = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(34);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(34).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.VOLUME_CORRECTION_ROUTINE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.VOLUME_CORRECTION_ROUTINE = tmpContent_tDBInput_1;
                }
            } else {
                row1.VOLUME_CORRECTION_ROUTINE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 35) {
								row1.DENSITY_CORRECTION_METHOD = 0;
							} else {
		                          
            row1.DENSITY_CORRECTION_METHOD = rs_tDBInput_1.getInt(35);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 36) {
								row1.DENSITY_CORRECTION_STD_API_COD = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(36);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(36).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.DENSITY_CORRECTION_STD_API_COD = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.DENSITY_CORRECTION_STD_API_COD = tmpContent_tDBInput_1;
                }
            } else {
                row1.DENSITY_CORRECTION_STD_API_COD = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 37) {
								row1.DENSITY_UNITS_ROUTINE = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(37);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(37).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.DENSITY_UNITS_ROUTINE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.DENSITY_UNITS_ROUTINE = tmpContent_tDBInput_1;
                }
            } else {
                row1.DENSITY_UNITS_ROUTINE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 38) {
								row1.INPUT_DENSITY_TEMPERATURE = 0;
							} else {
	                         		
            row1.INPUT_DENSITY_TEMPERATURE = rs_tDBInput_1.getDouble(38);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 39) {
								row1.WEIGHT_CONVERSION_METHOD = 0;
							} else {
		                          
            row1.WEIGHT_CONVERSION_METHOD = rs_tDBInput_1.getInt(39);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 40) {
								row1.WEIGHT_CONVERSION_ROUTINE = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(40);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(40).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.WEIGHT_CONVERSION_ROUTINE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.WEIGHT_CONVERSION_ROUTINE = tmpContent_tDBInput_1;
                }
            } else {
                row1.WEIGHT_CONVERSION_ROUTINE = null;
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
if(row1.API_CODE == null){
	finder_tUniqRow_1.API_CODE = null;
}else{
	finder_tUniqRow_1.API_CODE = row1.API_CODE.toLowerCase();
}	
finder_tUniqRow_1.hashCodeDirty = true;
if (!keystUniqRow_1.contains(finder_tUniqRow_1)) {
		KeyStruct_tUniqRow_1 new_tUniqRow_1 = new KeyStruct_tUniqRow_1();

		
if(row1.API_CODE == null){
	new_tUniqRow_1.API_CODE = null;
}else{
	new_tUniqRow_1.API_CODE = row1.API_CODE.toLowerCase();
}
		
		keystUniqRow_1.add(new_tUniqRow_1);if(row2 == null){ 
	
	row2 = new row2Struct();
}row2.API_CODE = row1.API_CODE;			row2.DESCRIPTION = row1.DESCRIPTION;			row2.USER_DEFINED = row1.USER_DEFINED;			row2.DDE_VALUE = row1.DDE_VALUE;			row2.DENSITY_UNITS = row1.DENSITY_UNITS;			row2.PRESSURE_UNITS = row1.PRESSURE_UNITS;			row2.DENSITY_PRECISION = row1.DENSITY_PRECISION;			row2.LAST_MODIFIED = row1.LAST_MODIFIED;			row2.COE_PRECISION = row1.COE_PRECISION;			row2.DENSITY_UNITS_FACTOR = row1.DENSITY_UNITS_FACTOR;			row2.DENSITY_CORRECTION_ROUTINE = row1.DENSITY_CORRECTION_ROUTINE;			row2.WEIGHT_IN_AIR_METHOD = row1.WEIGHT_IN_AIR_METHOD;			row2.WEIGHT_IN_AIR_ROUTINE = row1.WEIGHT_IN_AIR_ROUTINE;			row2.WEIGHT_IN_AIR_FACTOR = row1.WEIGHT_IN_AIR_FACTOR;			row2.LAST_USER_NAME = row1.LAST_USER_NAME;			row2.TEMPERATURE_UNITS = row1.TEMPERATURE_UNITS;			row2.REFERENCE_TEMPERATURE = row1.REFERENCE_TEMPERATURE;			row2.TEMPERATURE_PRECISION = row1.TEMPERATURE_PRECISION;			row2.PRESSURE_PRECISION = row1.PRESSURE_PRECISION;			row2.VCF_PRECISION = row1.VCF_PRECISION;			row2.MINIMUM_TEMPERATURE = row1.MINIMUM_TEMPERATURE;			row2.MAXIMUM_TEMPERATURE = row1.MAXIMUM_TEMPERATURE;			row2.MINIMUM_PRESSURE = row1.MINIMUM_PRESSURE;			row2.MAXIMUM_PRESSURE = row1.MAXIMUM_PRESSURE;			row2.MINIMUM_BASE_DENSITY = row1.MINIMUM_BASE_DENSITY;			row2.MAXIMUM_BASE_DENSITY = row1.MAXIMUM_BASE_DENSITY;			row2.MINIMUM_OBSERVED_DENSITY = row1.MINIMUM_OBSERVED_DENSITY;			row2.MAXIMUM_OBSERVED_DENSITY = row1.MAXIMUM_OBSERVED_DENSITY;			row2.MINIMUM_COE = row1.MINIMUM_COE;			row2.MAXIMUM_COE = row1.MAXIMUM_COE;			row2.COMMODITY_GROUP = row1.COMMODITY_GROUP;			row2.DLL = row1.DLL;			row2.VOLUME_CORRECTION_METHOD = row1.VOLUME_CORRECTION_METHOD;			row2.VOLUME_CORRECTION_ROUTINE = row1.VOLUME_CORRECTION_ROUTINE;			row2.DENSITY_CORRECTION_METHOD = row1.DENSITY_CORRECTION_METHOD;			row2.DENSITY_CORRECTION_STD_API_COD = row1.DENSITY_CORRECTION_STD_API_COD;			row2.DENSITY_UNITS_ROUTINE = row1.DENSITY_UNITS_ROUTINE;			row2.INPUT_DENSITY_TEMPERATURE = row1.INPUT_DENSITY_TEMPERATURE;			row2.WEIGHT_CONVERSION_METHOD = row1.WEIGHT_CONVERSION_METHOD;			row2.WEIGHT_CONVERSION_ROUTINE = row1.WEIGHT_CONVERSION_ROUTINE;					
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
								
                        		    		    row3HashKey.API_CODE = row2.API_CODE;
                        		    		

								
		                        	row3HashKey.hashCodeDirty = true;
                        		
	  					
	  							
			  					
			  					
	  					
		  							tHash_Lookup_row3.lookup( row3HashKey );

	  							

	  							

 								
		  				
	  								
						
									
  									  		
 								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_row3 != null && tHash_Lookup_row3.getCount(row3HashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row3' and it contains more one result from keys :  row3.API_CODE = '" + row3HashKey.API_CODE + "'");
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
Var.PK_API = Numeric.sequence("s14",1,1) ;// ###############################
        // ###############################
        // # Output tables

out1 = null;


// # Output table : 'out1'
out1_tmp.PK_API = Var.PK_API ;
out1_tmp.API_CODE = row2.API_CODE ;
out1_tmp.DESCRIPTION = row2.DESCRIPTION ;
out1_tmp.USER_DEFINED = row2.USER_DEFINED ;
out1_tmp.DENSITY_UNITS = row2.DENSITY_UNITS ;
out1_tmp.DENSITY_PRECISION = row2.DENSITY_PRECISION ;
out1_tmp.COE_PRECISION = row2.COE_PRECISION ;
out1_tmp.WEIGHT_IN_AIR_METHOD = row2.WEIGHT_IN_AIR_METHOD ;
out1_tmp.TEMPERATURE_UNITS = row2.TEMPERATURE_UNITS ;
out1_tmp.REFERENCE_TEMPERATURE = row2.REFERENCE_TEMPERATURE ;
out1_tmp.TEMPERATURE_PRECISION = row2.TEMPERATURE_PRECISION ;
out1_tmp.MAXIMUM_PRESSURE = row2.MAXIMUM_PRESSURE ;
out1_tmp.COMMODITY_GROUP = row2.COMMODITY_GROUP ;
out1_tmp.DLL = row2.DLL ;
out1_tmp.VOLUME_CORRECTION_METHOD = row2.VOLUME_CORRECTION_METHOD ;
out1_tmp.VOLUME_CORRECTION_ROUTINE = row2.VOLUME_CORRECTION_ROUTINE ;
out1_tmp.DENSITY_CORRECTION_METHOD = row2.DENSITY_CORRECTION_METHOD ;
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


                    if(out1.PK_API == null) {
pstmt_tDBOutput_1.setNull(1, java.sql.Types.INTEGER);
} else {pstmt_tDBOutput_1.setInt(1, out1.PK_API);
}

            int checkCount_tDBOutput_1 = -1;
            try (java.sql.ResultSet rs_tDBOutput_1 = pstmt_tDBOutput_1.executeQuery()) {
                while(rs_tDBOutput_1.next()) {
                    checkCount_tDBOutput_1 = rs_tDBOutput_1.getInt(1);
                }
            }
            if(checkCount_tDBOutput_1 > 0) {
                        if(out1.API_CODE == null) {
pstmtUpdate_tDBOutput_1.setNull(1, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(1, out1.API_CODE);
}

                        if(out1.DESCRIPTION == null) {
pstmtUpdate_tDBOutput_1.setNull(2, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(2, out1.DESCRIPTION);
}

                        pstmtUpdate_tDBOutput_1.setInt(3, out1.USER_DEFINED);

                        pstmtUpdate_tDBOutput_1.setInt(4, out1.DENSITY_UNITS);

                        pstmtUpdate_tDBOutput_1.setInt(5, out1.DENSITY_PRECISION);

                        pstmtUpdate_tDBOutput_1.setInt(6, out1.COE_PRECISION);

                        pstmtUpdate_tDBOutput_1.setInt(7, out1.WEIGHT_IN_AIR_METHOD);

                        pstmtUpdate_tDBOutput_1.setInt(8, out1.TEMPERATURE_UNITS);

                        pstmtUpdate_tDBOutput_1.setDouble(9, out1.REFERENCE_TEMPERATURE);

                        pstmtUpdate_tDBOutput_1.setInt(10, out1.TEMPERATURE_PRECISION);

                        pstmtUpdate_tDBOutput_1.setDouble(11, out1.MAXIMUM_PRESSURE);

                        pstmtUpdate_tDBOutput_1.setInt(12, out1.COMMODITY_GROUP);

                        if(out1.DLL == null) {
pstmtUpdate_tDBOutput_1.setNull(13, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(13, out1.DLL);
}

                        pstmtUpdate_tDBOutput_1.setInt(14, out1.VOLUME_CORRECTION_METHOD);

                        if(out1.VOLUME_CORRECTION_ROUTINE == null) {
pstmtUpdate_tDBOutput_1.setNull(15, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(15, out1.VOLUME_CORRECTION_ROUTINE);
}

                        pstmtUpdate_tDBOutput_1.setInt(16, out1.DENSITY_CORRECTION_METHOD);


	                    

                        if(out1.PK_API == null) {
pstmtUpdate_tDBOutput_1.setNull(17 + count_tDBOutput_1, java.sql.Types.INTEGER);
} else {pstmtUpdate_tDBOutput_1.setInt(17 + count_tDBOutput_1, out1.PK_API);
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
                        if(out1.PK_API == null) {
pstmtInsert_tDBOutput_1.setNull(1, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_1.setInt(1, out1.PK_API);
}

                        if(out1.API_CODE == null) {
pstmtInsert_tDBOutput_1.setNull(2, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(2, out1.API_CODE);
}

                        if(out1.DESCRIPTION == null) {
pstmtInsert_tDBOutput_1.setNull(3, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(3, out1.DESCRIPTION);
}

                        pstmtInsert_tDBOutput_1.setInt(4, out1.USER_DEFINED);

                        pstmtInsert_tDBOutput_1.setInt(5, out1.DENSITY_UNITS);

                        pstmtInsert_tDBOutput_1.setInt(6, out1.DENSITY_PRECISION);

                        pstmtInsert_tDBOutput_1.setInt(7, out1.COE_PRECISION);

                        pstmtInsert_tDBOutput_1.setInt(8, out1.WEIGHT_IN_AIR_METHOD);

                        pstmtInsert_tDBOutput_1.setInt(9, out1.TEMPERATURE_UNITS);

                        pstmtInsert_tDBOutput_1.setDouble(10, out1.REFERENCE_TEMPERATURE);

                        pstmtInsert_tDBOutput_1.setInt(11, out1.TEMPERATURE_PRECISION);

                        pstmtInsert_tDBOutput_1.setDouble(12, out1.MAXIMUM_PRESSURE);

                        pstmtInsert_tDBOutput_1.setInt(13, out1.COMMODITY_GROUP);

                        if(out1.DLL == null) {
pstmtInsert_tDBOutput_1.setNull(14, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(14, out1.DLL);
}

                        pstmtInsert_tDBOutput_1.setInt(15, out1.VOLUME_CORRECTION_METHOD);

                        if(out1.VOLUME_CORRECTION_ROUTINE == null) {
pstmtInsert_tDBOutput_1.setNull(16, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(16, out1.VOLUME_CORRECTION_ROUTINE);
}

                        pstmtInsert_tDBOutput_1.setInt(17, out1.DENSITY_CORRECTION_METHOD);

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
    final static byte[] commonByteArrayLock_PGS_STAGE_DIM_API = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_DIM_API = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public int PK_API;

				public int getPK_API () {
					return this.PK_API;
				}
				
			    public String API_CODE;

				public String getAPI_CODE () {
					return this.API_CODE;
				}
				
			    public String DESCRIPTION;

				public String getDESCRIPTION () {
					return this.DESCRIPTION;
				}
				
			    public int USER_DEFINED;

				public int getUSER_DEFINED () {
					return this.USER_DEFINED;
				}
				
			    public int DENSITY_UNITS;

				public int getDENSITY_UNITS () {
					return this.DENSITY_UNITS;
				}
				
			    public int DENSITY_PRECISION;

				public int getDENSITY_PRECISION () {
					return this.DENSITY_PRECISION;
				}
				
			    public int COE_PRECISION;

				public int getCOE_PRECISION () {
					return this.COE_PRECISION;
				}
				
			    public int WEIGHT_IN_AIR_METHOD;

				public int getWEIGHT_IN_AIR_METHOD () {
					return this.WEIGHT_IN_AIR_METHOD;
				}
				
			    public int TEMPERATURE_UNITS;

				public int getTEMPERATURE_UNITS () {
					return this.TEMPERATURE_UNITS;
				}
				
			    public double REFERENCE_TEMPERATURE;

				public double getREFERENCE_TEMPERATURE () {
					return this.REFERENCE_TEMPERATURE;
				}
				
			    public int TEMPERATURE_PRECISION;

				public int getTEMPERATURE_PRECISION () {
					return this.TEMPERATURE_PRECISION;
				}
				
			    public double MAXIMUM_PRESSURE;

				public double getMAXIMUM_PRESSURE () {
					return this.MAXIMUM_PRESSURE;
				}
				
			    public int COMMODITY_GROUP;

				public int getCOMMODITY_GROUP () {
					return this.COMMODITY_GROUP;
				}
				
			    public String DLL;

				public String getDLL () {
					return this.DLL;
				}
				
			    public int VOLUME_CORRECTION_METHOD;

				public int getVOLUME_CORRECTION_METHOD () {
					return this.VOLUME_CORRECTION_METHOD;
				}
				
			    public String VOLUME_CORRECTION_ROUTINE;

				public String getVOLUME_CORRECTION_ROUTINE () {
					return this.VOLUME_CORRECTION_ROUTINE;
				}
				
			    public int DENSITY_CORRECTION_METHOD;

				public int getDENSITY_CORRECTION_METHOD () {
					return this.DENSITY_CORRECTION_METHOD;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.API_CODE == null) ? 0 : this.API_CODE.hashCode());
					
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
		
						if (this.API_CODE == null) {
							if (other.API_CODE != null)
								return false;
						
						} else if (!this.API_CODE.equals(other.API_CODE))
						
							return false;
					

		return true;
    }

	public void copyDataTo(row3Struct other) {

		other.PK_API = this.PK_API;
	            other.API_CODE = this.API_CODE;
	            other.DESCRIPTION = this.DESCRIPTION;
	            other.USER_DEFINED = this.USER_DEFINED;
	            other.DENSITY_UNITS = this.DENSITY_UNITS;
	            other.DENSITY_PRECISION = this.DENSITY_PRECISION;
	            other.COE_PRECISION = this.COE_PRECISION;
	            other.WEIGHT_IN_AIR_METHOD = this.WEIGHT_IN_AIR_METHOD;
	            other.TEMPERATURE_UNITS = this.TEMPERATURE_UNITS;
	            other.REFERENCE_TEMPERATURE = this.REFERENCE_TEMPERATURE;
	            other.TEMPERATURE_PRECISION = this.TEMPERATURE_PRECISION;
	            other.MAXIMUM_PRESSURE = this.MAXIMUM_PRESSURE;
	            other.COMMODITY_GROUP = this.COMMODITY_GROUP;
	            other.DLL = this.DLL;
	            other.VOLUME_CORRECTION_METHOD = this.VOLUME_CORRECTION_METHOD;
	            other.VOLUME_CORRECTION_ROUTINE = this.VOLUME_CORRECTION_ROUTINE;
	            other.DENSITY_CORRECTION_METHOD = this.DENSITY_CORRECTION_METHOD;
	            
	}

	public void copyKeysDataTo(row3Struct other) {

		other.API_CODE = this.API_CODE;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PGS_STAGE_DIM_API.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_API.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_API = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_API = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PGS_STAGE_DIM_API, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_API, 0, length, utf8Charset);
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
			if(length > commonByteArray_PGS_STAGE_DIM_API.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_API.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_API = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_API = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PGS_STAGE_DIM_API, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_API, 0, length, utf8Charset);
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

    public void readKeysData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_API) {

        	try {

        		int length = 0;
		
					this.API_CODE = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_API) {

        	try {

        		int length = 0;
		
					this.API_CODE = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.API_CODE,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.API_CODE,dos);
					
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
		
			            this.PK_API = dis.readInt();
					
						this.DESCRIPTION = readString(dis,ois);
					
			            this.USER_DEFINED = dis.readInt();
					
			            this.DENSITY_UNITS = dis.readInt();
					
			            this.DENSITY_PRECISION = dis.readInt();
					
			            this.COE_PRECISION = dis.readInt();
					
			            this.WEIGHT_IN_AIR_METHOD = dis.readInt();
					
			            this.TEMPERATURE_UNITS = dis.readInt();
					
			            this.REFERENCE_TEMPERATURE = dis.readDouble();
					
			            this.TEMPERATURE_PRECISION = dis.readInt();
					
			            this.MAXIMUM_PRESSURE = dis.readDouble();
					
			            this.COMMODITY_GROUP = dis.readInt();
					
						this.DLL = readString(dis,ois);
					
			            this.VOLUME_CORRECTION_METHOD = dis.readInt();
					
						this.VOLUME_CORRECTION_ROUTINE = readString(dis,ois);
					
			            this.DENSITY_CORRECTION_METHOD = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
			            this.PK_API = objectIn.readInt();
					
						this.DESCRIPTION = readString(dis,objectIn);
					
			            this.USER_DEFINED = objectIn.readInt();
					
			            this.DENSITY_UNITS = objectIn.readInt();
					
			            this.DENSITY_PRECISION = objectIn.readInt();
					
			            this.COE_PRECISION = objectIn.readInt();
					
			            this.WEIGHT_IN_AIR_METHOD = objectIn.readInt();
					
			            this.TEMPERATURE_UNITS = objectIn.readInt();
					
			            this.REFERENCE_TEMPERATURE = objectIn.readDouble();
					
			            this.TEMPERATURE_PRECISION = objectIn.readInt();
					
			            this.MAXIMUM_PRESSURE = objectIn.readDouble();
					
			            this.COMMODITY_GROUP = objectIn.readInt();
					
						this.DLL = readString(dis,objectIn);
					
			            this.VOLUME_CORRECTION_METHOD = objectIn.readInt();
					
						this.VOLUME_CORRECTION_ROUTINE = readString(dis,objectIn);
					
			            this.DENSITY_CORRECTION_METHOD = objectIn.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
		            	dos.writeInt(this.PK_API);
					
						writeString(this.DESCRIPTION, dos, oos);
					
		            	dos.writeInt(this.USER_DEFINED);
					
		            	dos.writeInt(this.DENSITY_UNITS);
					
		            	dos.writeInt(this.DENSITY_PRECISION);
					
		            	dos.writeInt(this.COE_PRECISION);
					
		            	dos.writeInt(this.WEIGHT_IN_AIR_METHOD);
					
		            	dos.writeInt(this.TEMPERATURE_UNITS);
					
		            	dos.writeDouble(this.REFERENCE_TEMPERATURE);
					
		            	dos.writeInt(this.TEMPERATURE_PRECISION);
					
		            	dos.writeDouble(this.MAXIMUM_PRESSURE);
					
		            	dos.writeInt(this.COMMODITY_GROUP);
					
						writeString(this.DLL, dos, oos);
					
		            	dos.writeInt(this.VOLUME_CORRECTION_METHOD);
					
						writeString(this.VOLUME_CORRECTION_ROUTINE, dos, oos);
					
		            	dos.writeInt(this.DENSITY_CORRECTION_METHOD);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
					objectOut.writeInt(this.PK_API);
					
						writeString(this.DESCRIPTION, dos, objectOut);
					
					objectOut.writeInt(this.USER_DEFINED);
					
					objectOut.writeInt(this.DENSITY_UNITS);
					
					objectOut.writeInt(this.DENSITY_PRECISION);
					
					objectOut.writeInt(this.COE_PRECISION);
					
					objectOut.writeInt(this.WEIGHT_IN_AIR_METHOD);
					
					objectOut.writeInt(this.TEMPERATURE_UNITS);
					
					objectOut.writeDouble(this.REFERENCE_TEMPERATURE);
					
					objectOut.writeInt(this.TEMPERATURE_PRECISION);
					
					objectOut.writeDouble(this.MAXIMUM_PRESSURE);
					
					objectOut.writeInt(this.COMMODITY_GROUP);
					
						writeString(this.DLL, dos, objectOut);
					
					objectOut.writeInt(this.VOLUME_CORRECTION_METHOD);
					
						writeString(this.VOLUME_CORRECTION_ROUTINE, dos, objectOut);
					
					objectOut.writeInt(this.DENSITY_CORRECTION_METHOD);
					
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
		sb.append("PK_API="+String.valueOf(PK_API));
		sb.append(",API_CODE="+API_CODE);
		sb.append(",DESCRIPTION="+DESCRIPTION);
		sb.append(",USER_DEFINED="+String.valueOf(USER_DEFINED));
		sb.append(",DENSITY_UNITS="+String.valueOf(DENSITY_UNITS));
		sb.append(",DENSITY_PRECISION="+String.valueOf(DENSITY_PRECISION));
		sb.append(",COE_PRECISION="+String.valueOf(COE_PRECISION));
		sb.append(",WEIGHT_IN_AIR_METHOD="+String.valueOf(WEIGHT_IN_AIR_METHOD));
		sb.append(",TEMPERATURE_UNITS="+String.valueOf(TEMPERATURE_UNITS));
		sb.append(",REFERENCE_TEMPERATURE="+String.valueOf(REFERENCE_TEMPERATURE));
		sb.append(",TEMPERATURE_PRECISION="+String.valueOf(TEMPERATURE_PRECISION));
		sb.append(",MAXIMUM_PRESSURE="+String.valueOf(MAXIMUM_PRESSURE));
		sb.append(",COMMODITY_GROUP="+String.valueOf(COMMODITY_GROUP));
		sb.append(",DLL="+DLL);
		sb.append(",VOLUME_CORRECTION_METHOD="+String.valueOf(VOLUME_CORRECTION_METHOD));
		sb.append(",VOLUME_CORRECTION_ROUTINE="+VOLUME_CORRECTION_ROUTINE);
		sb.append(",DENSITY_CORRECTION_METHOD="+String.valueOf(DENSITY_CORRECTION_METHOD));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row3Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.API_CODE, other.API_CODE);
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
				
				 
	final String decryptedPassword_tDBInput_2 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:n35JJ3Z8OkACKeLUwPGuP1Z5V55gQGaYaH7br8O7MFh+/eKibFw=");
				
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

		    String dbquery_tDBInput_2 = "SELECT dbo.DIM_API.PK_API,\n		dbo.DIM_API.API_CODE,\n		dbo.DIM_API.DESCRIPTION,\n		dbo.DIM_API.USER_DEFINED,\n		dbo.DIM_API"
+".DENSITY_UNITS,\n		dbo.DIM_API.DENSITY_PRECISION,\n		dbo.DIM_API.COE_PRECISION,\n		dbo.DIM_API.WEIGHT_IN_AIR_METHOD,\n		dbo."
+"DIM_API.TEMPERATURE_UNITS,\n		dbo.DIM_API.REFERENCE_TEMPERATURE,\n		dbo.DIM_API.TEMPERATURE_PRECISION,\n		dbo.DIM_API.MAXIM"
+"UM_PRESSURE,\n		dbo.DIM_API.COMMODITY_GROUP,\n		dbo.DIM_API.DLL,\n		dbo.DIM_API.VOLUME_CORRECTION_METHOD,\n		dbo.DIM_API.VOL"
+"UME_CORRECTION_ROUTINE,\n		dbo.DIM_API.DENSITY_CORRECTION_METHOD\nFROM	dbo.DIM_API";
		    

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
								row3.PK_API = 0;
							} else {
		                          
            row3.PK_API = rs_tDBInput_2.getInt(1);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 2) {
								row3.API_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(2);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(2).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.API_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row3.API_CODE = tmpContent_tDBInput_2;
                }
            } else {
                row3.API_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 3) {
								row3.DESCRIPTION = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(3);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(3).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.DESCRIPTION = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row3.DESCRIPTION = tmpContent_tDBInput_2;
                }
            } else {
                row3.DESCRIPTION = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 4) {
								row3.USER_DEFINED = 0;
							} else {
		                          
            row3.USER_DEFINED = rs_tDBInput_2.getInt(4);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 5) {
								row3.DENSITY_UNITS = 0;
							} else {
		                          
            row3.DENSITY_UNITS = rs_tDBInput_2.getInt(5);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 6) {
								row3.DENSITY_PRECISION = 0;
							} else {
		                          
            row3.DENSITY_PRECISION = rs_tDBInput_2.getInt(6);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 7) {
								row3.COE_PRECISION = 0;
							} else {
		                          
            row3.COE_PRECISION = rs_tDBInput_2.getInt(7);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 8) {
								row3.WEIGHT_IN_AIR_METHOD = 0;
							} else {
		                          
            row3.WEIGHT_IN_AIR_METHOD = rs_tDBInput_2.getInt(8);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 9) {
								row3.TEMPERATURE_UNITS = 0;
							} else {
		                          
            row3.TEMPERATURE_UNITS = rs_tDBInput_2.getInt(9);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 10) {
								row3.REFERENCE_TEMPERATURE = 0;
							} else {
	                         		
            row3.REFERENCE_TEMPERATURE = rs_tDBInput_2.getDouble(10);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 11) {
								row3.TEMPERATURE_PRECISION = 0;
							} else {
		                          
            row3.TEMPERATURE_PRECISION = rs_tDBInput_2.getInt(11);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 12) {
								row3.MAXIMUM_PRESSURE = 0;
							} else {
	                         		
            row3.MAXIMUM_PRESSURE = rs_tDBInput_2.getDouble(12);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 13) {
								row3.COMMODITY_GROUP = 0;
							} else {
		                          
            row3.COMMODITY_GROUP = rs_tDBInput_2.getInt(13);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 14) {
								row3.DLL = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(14);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(14).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.DLL = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row3.DLL = tmpContent_tDBInput_2;
                }
            } else {
                row3.DLL = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 15) {
								row3.VOLUME_CORRECTION_METHOD = 0;
							} else {
		                          
            row3.VOLUME_CORRECTION_METHOD = rs_tDBInput_2.getInt(15);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 16) {
								row3.VOLUME_CORRECTION_ROUTINE = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(16);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(16).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.VOLUME_CORRECTION_ROUTINE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row3.VOLUME_CORRECTION_ROUTINE = tmpContent_tDBInput_2;
                }
            } else {
                row3.VOLUME_CORRECTION_ROUTINE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 17) {
								row3.DENSITY_CORRECTION_METHOD = 0;
							} else {
		                          
            row3.DENSITY_CORRECTION_METHOD = rs_tDBInput_2.getInt(17);
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
		   	   	   
				
				row3_HashRow.PK_API = row3.PK_API;
				
				row3_HashRow.API_CODE = row3.API_CODE;
				
				row3_HashRow.DESCRIPTION = row3.DESCRIPTION;
				
				row3_HashRow.USER_DEFINED = row3.USER_DEFINED;
				
				row3_HashRow.DENSITY_UNITS = row3.DENSITY_UNITS;
				
				row3_HashRow.DENSITY_PRECISION = row3.DENSITY_PRECISION;
				
				row3_HashRow.COE_PRECISION = row3.COE_PRECISION;
				
				row3_HashRow.WEIGHT_IN_AIR_METHOD = row3.WEIGHT_IN_AIR_METHOD;
				
				row3_HashRow.TEMPERATURE_UNITS = row3.TEMPERATURE_UNITS;
				
				row3_HashRow.REFERENCE_TEMPERATURE = row3.REFERENCE_TEMPERATURE;
				
				row3_HashRow.TEMPERATURE_PRECISION = row3.TEMPERATURE_PRECISION;
				
				row3_HashRow.MAXIMUM_PRESSURE = row3.MAXIMUM_PRESSURE;
				
				row3_HashRow.COMMODITY_GROUP = row3.COMMODITY_GROUP;
				
				row3_HashRow.DLL = row3.DLL;
				
				row3_HashRow.VOLUME_CORRECTION_METHOD = row3.VOLUME_CORRECTION_METHOD;
				
				row3_HashRow.VOLUME_CORRECTION_ROUTINE = row3.VOLUME_CORRECTION_ROUTINE;
				
				row3_HashRow.DENSITY_CORRECTION_METHOD = row3.DENSITY_CORRECTION_METHOD;
				
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
        final DIM_API DIM_APIClass = new DIM_API();

        int exitCode = DIM_APIClass.runJobInTOS(args);

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
            java.io.InputStream inContext = DIM_API.class.getClassLoader().getResourceAsStream("pgs_stage/dim_api_0_1/contexts/" + contextStr + ".properties");
            if (inContext == null) {
                inContext = DIM_API.class.getClassLoader().getResourceAsStream("config/contexts/" + contextStr + ".properties");
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
            System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : DIM_API");
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
 *     207669 characters generated by Talend Open Studio for Data Integration 
 *     on the 3 août 2024 à 14:42:26 GMT+01:00
 ************************************************************************************************/