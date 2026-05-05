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


package pgs_stage.dim_bulk_product_0_1;

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
 * Job: DIM_BULK_PRODUCT Purpose: <br>
 * Description:  <br>
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status 
 */
public class DIM_BULK_PRODUCT implements TalendJob {

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
	private final String jobName = "DIM_BULK_PRODUCT";
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
				DIM_BULK_PRODUCT.this.exception = e;
			}
		}
		if (!(e instanceof TalendException)) {
		try {
			for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
				if (m.getName().compareTo(currentComponent + "_error") == 0) {
					m.invoke(DIM_BULK_PRODUCT.this, new Object[] { e , currentComponent, globalMap});
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
    final static byte[] commonByteArrayLock_PGS_STAGE_DIM_BULK_PRODUCT = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_DIM_BULK_PRODUCT = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public Integer PK_BULK_PRODUCT;

				public Integer getPK_BULK_PRODUCT () {
					return this.PK_BULK_PRODUCT;
				}
				
			    public int BULK_MOVEMENT_ID;

				public int getBULK_MOVEMENT_ID () {
					return this.BULK_MOVEMENT_ID;
				}
				
			    public int BULK_PRODUCT_ID;

				public int getBULK_PRODUCT_ID () {
					return this.BULK_PRODUCT_ID;
				}
				
			    public int TERMINAL_PRODUCT_NUMBER;

				public int getTERMINAL_PRODUCT_NUMBER () {
					return this.TERMINAL_PRODUCT_NUMBER;
				}
				
			    public String CONTAINER_CODE;

				public String getCONTAINER_CODE () {
					return this.CONTAINER_CODE;
				}
				
			    public Integer SNAPSHOT_TYPE;

				public Integer getSNAPSHOT_TYPE () {
					return this.SNAPSHOT_TYPE;
				}
				
			    public int FIGURES_TYPE;

				public int getFIGURES_TYPE () {
					return this.FIGURES_TYPE;
				}
				
			    public String LAST_USER_NAME;

				public String getLAST_USER_NAME () {
					return this.LAST_USER_NAME;
				}
				
			    public java.util.Date LAST_MODIFIED;

				public java.util.Date getLAST_MODIFIED () {
					return this.LAST_MODIFIED;
				}
				
			    public java.util.Date START_DATE;

				public java.util.Date getSTART_DATE () {
					return this.START_DATE;
				}
				
			    public java.util.Date END_DATE;

				public java.util.Date getEND_DATE () {
					return this.END_DATE;
				}
				
			    public int INVENTORY_QUANTITY_TYPE;

				public int getINVENTORY_QUANTITY_TYPE () {
					return this.INVENTORY_QUANTITY_TYPE;
				}
				
			    public int DIRECTION;

				public int getDIRECTION () {
					return this.DIRECTION;
				}
				
			    public int MEASURED_QUANTITY_TYPE;

				public int getMEASURED_QUANTITY_TYPE () {
					return this.MEASURED_QUANTITY_TYPE;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.PK_BULK_PRODUCT == null) ? 0 : this.PK_BULK_PRODUCT.hashCode());
					
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
		
						if (this.PK_BULK_PRODUCT == null) {
							if (other.PK_BULK_PRODUCT != null)
								return false;
						
						} else if (!this.PK_BULK_PRODUCT.equals(other.PK_BULK_PRODUCT))
						
							return false;
					

		return true;
    }

	public void copyDataTo(out1Struct other) {

		other.PK_BULK_PRODUCT = this.PK_BULK_PRODUCT;
	            other.BULK_MOVEMENT_ID = this.BULK_MOVEMENT_ID;
	            other.BULK_PRODUCT_ID = this.BULK_PRODUCT_ID;
	            other.TERMINAL_PRODUCT_NUMBER = this.TERMINAL_PRODUCT_NUMBER;
	            other.CONTAINER_CODE = this.CONTAINER_CODE;
	            other.SNAPSHOT_TYPE = this.SNAPSHOT_TYPE;
	            other.FIGURES_TYPE = this.FIGURES_TYPE;
	            other.LAST_USER_NAME = this.LAST_USER_NAME;
	            other.LAST_MODIFIED = this.LAST_MODIFIED;
	            other.START_DATE = this.START_DATE;
	            other.END_DATE = this.END_DATE;
	            other.INVENTORY_QUANTITY_TYPE = this.INVENTORY_QUANTITY_TYPE;
	            other.DIRECTION = this.DIRECTION;
	            other.MEASURED_QUANTITY_TYPE = this.MEASURED_QUANTITY_TYPE;
	            
	}

	public void copyKeysDataTo(out1Struct other) {

		other.PK_BULK_PRODUCT = this.PK_BULK_PRODUCT;
	            	
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
			if(length > commonByteArray_PGS_STAGE_DIM_BULK_PRODUCT.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_BULK_PRODUCT.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_BULK_PRODUCT = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_BULK_PRODUCT = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PGS_STAGE_DIM_BULK_PRODUCT, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_BULK_PRODUCT, 0, length, utf8Charset);
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
			if(length > commonByteArray_PGS_STAGE_DIM_BULK_PRODUCT.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_BULK_PRODUCT.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_BULK_PRODUCT = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_BULK_PRODUCT = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PGS_STAGE_DIM_BULK_PRODUCT, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_BULK_PRODUCT, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_BULK_PRODUCT) {

        	try {

        		int length = 0;
		
						this.PK_BULK_PRODUCT = readInteger(dis);
					
			        this.BULK_MOVEMENT_ID = dis.readInt();
					
			        this.BULK_PRODUCT_ID = dis.readInt();
					
			        this.TERMINAL_PRODUCT_NUMBER = dis.readInt();
					
					this.CONTAINER_CODE = readString(dis);
					
						this.SNAPSHOT_TYPE = readInteger(dis);
					
			        this.FIGURES_TYPE = dis.readInt();
					
					this.LAST_USER_NAME = readString(dis);
					
					this.LAST_MODIFIED = readDate(dis);
					
					this.START_DATE = readDate(dis);
					
					this.END_DATE = readDate(dis);
					
			        this.INVENTORY_QUANTITY_TYPE = dis.readInt();
					
			        this.DIRECTION = dis.readInt();
					
			        this.MEASURED_QUANTITY_TYPE = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_BULK_PRODUCT) {

        	try {

        		int length = 0;
		
						this.PK_BULK_PRODUCT = readInteger(dis);
					
			        this.BULK_MOVEMENT_ID = dis.readInt();
					
			        this.BULK_PRODUCT_ID = dis.readInt();
					
			        this.TERMINAL_PRODUCT_NUMBER = dis.readInt();
					
					this.CONTAINER_CODE = readString(dis);
					
						this.SNAPSHOT_TYPE = readInteger(dis);
					
			        this.FIGURES_TYPE = dis.readInt();
					
					this.LAST_USER_NAME = readString(dis);
					
					this.LAST_MODIFIED = readDate(dis);
					
					this.START_DATE = readDate(dis);
					
					this.END_DATE = readDate(dis);
					
			        this.INVENTORY_QUANTITY_TYPE = dis.readInt();
					
			        this.DIRECTION = dis.readInt();
					
			        this.MEASURED_QUANTITY_TYPE = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// Integer
				
						writeInteger(this.PK_BULK_PRODUCT,dos);
					
					// int
				
		            	dos.writeInt(this.BULK_MOVEMENT_ID);
					
					// int
				
		            	dos.writeInt(this.BULK_PRODUCT_ID);
					
					// int
				
		            	dos.writeInt(this.TERMINAL_PRODUCT_NUMBER);
					
					// String
				
						writeString(this.CONTAINER_CODE,dos);
					
					// Integer
				
						writeInteger(this.SNAPSHOT_TYPE,dos);
					
					// int
				
		            	dos.writeInt(this.FIGURES_TYPE);
					
					// String
				
						writeString(this.LAST_USER_NAME,dos);
					
					// java.util.Date
				
						writeDate(this.LAST_MODIFIED,dos);
					
					// java.util.Date
				
						writeDate(this.START_DATE,dos);
					
					// java.util.Date
				
						writeDate(this.END_DATE,dos);
					
					// int
				
		            	dos.writeInt(this.INVENTORY_QUANTITY_TYPE);
					
					// int
				
		            	dos.writeInt(this.DIRECTION);
					
					// int
				
		            	dos.writeInt(this.MEASURED_QUANTITY_TYPE);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Integer
				
						writeInteger(this.PK_BULK_PRODUCT,dos);
					
					// int
				
		            	dos.writeInt(this.BULK_MOVEMENT_ID);
					
					// int
				
		            	dos.writeInt(this.BULK_PRODUCT_ID);
					
					// int
				
		            	dos.writeInt(this.TERMINAL_PRODUCT_NUMBER);
					
					// String
				
						writeString(this.CONTAINER_CODE,dos);
					
					// Integer
				
						writeInteger(this.SNAPSHOT_TYPE,dos);
					
					// int
				
		            	dos.writeInt(this.FIGURES_TYPE);
					
					// String
				
						writeString(this.LAST_USER_NAME,dos);
					
					// java.util.Date
				
						writeDate(this.LAST_MODIFIED,dos);
					
					// java.util.Date
				
						writeDate(this.START_DATE,dos);
					
					// java.util.Date
				
						writeDate(this.END_DATE,dos);
					
					// int
				
		            	dos.writeInt(this.INVENTORY_QUANTITY_TYPE);
					
					// int
				
		            	dos.writeInt(this.DIRECTION);
					
					// int
				
		            	dos.writeInt(this.MEASURED_QUANTITY_TYPE);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("PK_BULK_PRODUCT="+String.valueOf(PK_BULK_PRODUCT));
		sb.append(",BULK_MOVEMENT_ID="+String.valueOf(BULK_MOVEMENT_ID));
		sb.append(",BULK_PRODUCT_ID="+String.valueOf(BULK_PRODUCT_ID));
		sb.append(",TERMINAL_PRODUCT_NUMBER="+String.valueOf(TERMINAL_PRODUCT_NUMBER));
		sb.append(",CONTAINER_CODE="+CONTAINER_CODE);
		sb.append(",SNAPSHOT_TYPE="+String.valueOf(SNAPSHOT_TYPE));
		sb.append(",FIGURES_TYPE="+String.valueOf(FIGURES_TYPE));
		sb.append(",LAST_USER_NAME="+LAST_USER_NAME);
		sb.append(",LAST_MODIFIED="+String.valueOf(LAST_MODIFIED));
		sb.append(",START_DATE="+String.valueOf(START_DATE));
		sb.append(",END_DATE="+String.valueOf(END_DATE));
		sb.append(",INVENTORY_QUANTITY_TYPE="+String.valueOf(INVENTORY_QUANTITY_TYPE));
		sb.append(",DIRECTION="+String.valueOf(DIRECTION));
		sb.append(",MEASURED_QUANTITY_TYPE="+String.valueOf(MEASURED_QUANTITY_TYPE));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(out1Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.PK_BULK_PRODUCT, other.PK_BULK_PRODUCT);
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
    final static byte[] commonByteArrayLock_PGS_STAGE_DIM_BULK_PRODUCT = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_DIM_BULK_PRODUCT = new byte[0];

	
			    public int BULK_MOVEMENT_ID;

				public int getBULK_MOVEMENT_ID () {
					return this.BULK_MOVEMENT_ID;
				}
				
			    public int BULK_PRODUCT_ID;

				public int getBULK_PRODUCT_ID () {
					return this.BULK_PRODUCT_ID;
				}
				
			    public int TERMINAL_PRODUCT_NUMBER;

				public int getTERMINAL_PRODUCT_NUMBER () {
					return this.TERMINAL_PRODUCT_NUMBER;
				}
				
			    public String MEASUREMENT_DEVICE_PARENT_CODE;

				public String getMEASUREMENT_DEVICE_PARENT_CODE () {
					return this.MEASUREMENT_DEVICE_PARENT_CODE;
				}
				
			    public Integer COMPARTMENT_NUMBER;

				public Integer getCOMPARTMENT_NUMBER () {
					return this.COMPARTMENT_NUMBER;
				}
				
			    public String MEASUREMENT_DEVICE_CODE;

				public String getMEASUREMENT_DEVICE_CODE () {
					return this.MEASUREMENT_DEVICE_CODE;
				}
				
			    public String USER_INTERFACE_CODE;

				public String getUSER_INTERFACE_CODE () {
					return this.USER_INTERFACE_CODE;
				}
				
			    public Integer MEASUREMENT_DEVICE_TYPE;

				public Integer getMEASUREMENT_DEVICE_TYPE () {
					return this.MEASUREMENT_DEVICE_TYPE;
				}
				
			    public String SNAPSHOT_TANK_CODE;

				public String getSNAPSHOT_TANK_CODE () {
					return this.SNAPSHOT_TANK_CODE;
				}
				
			    public String CONTAINER_CODE;

				public String getCONTAINER_CODE () {
					return this.CONTAINER_CODE;
				}
				
			    public Integer CONTAINER_TYPE;

				public Integer getCONTAINER_TYPE () {
					return this.CONTAINER_TYPE;
				}
				
			    public Integer COMPARTMENT_OWNER_ID;

				public Integer getCOMPARTMENT_OWNER_ID () {
					return this.COMPARTMENT_OWNER_ID;
				}
				
			    public String COMPARTMENT_CONTAINER_CODE;

				public String getCOMPARTMENT_CONTAINER_CODE () {
					return this.COMPARTMENT_CONTAINER_CODE;
				}
				
			    public Integer SNAPSHOT_TYPE;

				public Integer getSNAPSHOT_TYPE () {
					return this.SNAPSHOT_TYPE;
				}
				
			    public Integer COMPARTMENT_CONTAINER_TYPE;

				public Integer getCOMPARTMENT_CONTAINER_TYPE () {
					return this.COMPARTMENT_CONTAINER_TYPE;
				}
				
			    public int FIGURES_TYPE;

				public int getFIGURES_TYPE () {
					return this.FIGURES_TYPE;
				}
				
			    public String SNAPSHOT_FOLIO_NUMBER;

				public String getSNAPSHOT_FOLIO_NUMBER () {
					return this.SNAPSHOT_FOLIO_NUMBER;
				}
				
			    public Integer SNAPSHOT_SEQUENCE_NUMBER;

				public Integer getSNAPSHOT_SEQUENCE_NUMBER () {
					return this.SNAPSHOT_SEQUENCE_NUMBER;
				}
				
			    public String FSHOST_SI_PRODUCT_NUMBER;

				public String getFSHOST_SI_PRODUCT_NUMBER () {
					return this.FSHOST_SI_PRODUCT_NUMBER;
				}
				
			    public String TSHOST_SI_PRODUCT_NUMBER;

				public String getTSHOST_SI_PRODUCT_NUMBER () {
					return this.TSHOST_SI_PRODUCT_NUMBER;
				}
				
			    public int GROSS_QUANTITY;

				public int getGROSS_QUANTITY () {
					return this.GROSS_QUANTITY;
				}
				
			    public int NET_QUANTITY;

				public int getNET_QUANTITY () {
					return this.NET_QUANTITY;
				}
				
			    public double DENSITY;

				public double getDENSITY () {
					return this.DENSITY;
				}
				
			    public double TEMPERATURE;

				public double getTEMPERATURE () {
					return this.TEMPERATURE;
				}
				
			    public int WEIGHT;

				public int getWEIGHT () {
					return this.WEIGHT;
				}
				
			    public double OCTANE;

				public double getOCTANE () {
					return this.OCTANE;
				}
				
			    public double RVP;

				public double getRVP () {
					return this.RVP;
				}
				
			    public double COEFFICIENT_EXPANSION;

				public double getCOEFFICIENT_EXPANSION () {
					return this.COEFFICIENT_EXPANSION;
				}
				
			    public double OXYGEN;

				public double getOXYGEN () {
					return this.OXYGEN;
				}
				
			    public double SPECIFIC_GRAVITY;

				public double getSPECIFIC_GRAVITY () {
					return this.SPECIFIC_GRAVITY;
				}
				
			    public String LAST_USER_NAME;

				public String getLAST_USER_NAME () {
					return this.LAST_USER_NAME;
				}
				
			    public java.util.Date LAST_MODIFIED;

				public java.util.Date getLAST_MODIFIED () {
					return this.LAST_MODIFIED;
				}
				
			    public java.util.Date START_DATE;

				public java.util.Date getSTART_DATE () {
					return this.START_DATE;
				}
				
			    public java.util.Date END_DATE;

				public java.util.Date getEND_DATE () {
					return this.END_DATE;
				}
				
			    public double PRESSURE;

				public double getPRESSURE () {
					return this.PRESSURE;
				}
				
			    public double FLOW_RATE;

				public double getFLOW_RATE () {
					return this.FLOW_RATE;
				}
				
			    public double AVERAGE_METER_FACTOR;

				public double getAVERAGE_METER_FACTOR () {
					return this.AVERAGE_METER_FACTOR;
				}
				
			    public double VCF;

				public double getVCF () {
					return this.VCF;
				}
				
			    public double PCF;

				public double getPCF () {
					return this.PCF;
				}
				
			    public double OBSERVED_DENSITY;

				public double getOBSERVED_DENSITY () {
					return this.OBSERVED_DENSITY;
				}
				
			    public int INVENTORY_QUANTITY_TYPE;

				public int getINVENTORY_QUANTITY_TYPE () {
					return this.INVENTORY_QUANTITY_TYPE;
				}
				
			    public double MEASURED_DENSITY;

				public double getMEASURED_DENSITY () {
					return this.MEASURED_DENSITY;
				}
				
			    public double BSW_PERCENT;

				public double getBSW_PERCENT () {
					return this.BSW_PERCENT;
				}
				
			    public int WATER_VOLUME;

				public int getWATER_VOLUME () {
					return this.WATER_VOLUME;
				}
				
			    public int WEIGHT_IN_VAC;

				public int getWEIGHT_IN_VAC () {
					return this.WEIGHT_IN_VAC;
				}
				
			    public int GROSS_FRAC_QUANTITY;

				public int getGROSS_FRAC_QUANTITY () {
					return this.GROSS_FRAC_QUANTITY;
				}
				
			    public int NET_FRAC_QUANTITY;

				public int getNET_FRAC_QUANTITY () {
					return this.NET_FRAC_QUANTITY;
				}
				
			    public int LEVEL_CHANGE;

				public int getLEVEL_CHANGE () {
					return this.LEVEL_CHANGE;
				}
				
			    public int FRAC_WEIGHT;

				public int getFRAC_WEIGHT () {
					return this.FRAC_WEIGHT;
				}
				
			    public int FRAC_WEIGHT_IN_VAC;

				public int getFRAC_WEIGHT_IN_VAC () {
					return this.FRAC_WEIGHT_IN_VAC;
				}
				
			    public int DIRECTION;

				public int getDIRECTION () {
					return this.DIRECTION;
				}
				
			    public int DECLARED_GROSS_QUANTITY;

				public int getDECLARED_GROSS_QUANTITY () {
					return this.DECLARED_GROSS_QUANTITY;
				}
				
			    public int DECLARED_GROSS_FRAC_QUANTITY;

				public int getDECLARED_GROSS_FRAC_QUANTITY () {
					return this.DECLARED_GROSS_FRAC_QUANTITY;
				}
				
			    public int DECLARED_NET_QUANTITY;

				public int getDECLARED_NET_QUANTITY () {
					return this.DECLARED_NET_QUANTITY;
				}
				
			    public int DECLARED_NET_FRAC_QUANTITY;

				public int getDECLARED_NET_FRAC_QUANTITY () {
					return this.DECLARED_NET_FRAC_QUANTITY;
				}
				
			    public int DECLARED_WEIGHT;

				public int getDECLARED_WEIGHT () {
					return this.DECLARED_WEIGHT;
				}
				
			    public int DECLARED_FRAC_WEIGHT;

				public int getDECLARED_FRAC_WEIGHT () {
					return this.DECLARED_FRAC_WEIGHT;
				}
				
			    public int DECLARED_WEIGHT_IN_VAC;

				public int getDECLARED_WEIGHT_IN_VAC () {
					return this.DECLARED_WEIGHT_IN_VAC;
				}
				
			    public int MEASURED_QUANTITY_TYPE;

				public int getMEASURED_QUANTITY_TYPE () {
					return this.MEASURED_QUANTITY_TYPE;
				}
				
			    public int DERIVED_VALUES_DIRECTIVE;

				public int getDERIVED_VALUES_DIRECTIVE () {
					return this.DERIVED_VALUES_DIRECTIVE;
				}
				
			    public int DECLARED_FRAC_WEIGHT_IN_VAC;

				public int getDECLARED_FRAC_WEIGHT_IN_VAC () {
					return this.DECLARED_FRAC_WEIGHT_IN_VAC;
				}
				
			    public int CALCULATE_NET;

				public int getCALCULATE_NET () {
					return this.CALCULATE_NET;
				}
				
			    public Integer CONTAINER_OWNER_ID;

				public Integer getCONTAINER_OWNER_ID () {
					return this.CONTAINER_OWNER_ID;
				}
				
			    public int AFFECT_ACCOUNTING;

				public int getAFFECT_ACCOUNTING () {
					return this.AFFECT_ACCOUNTING;
				}
				
			    public Integer SUPPLIER_PRODUCT_SUPPLIER;

				public Integer getSUPPLIER_PRODUCT_SUPPLIER () {
					return this.SUPPLIER_PRODUCT_SUPPLIER;
				}
				
			    public Integer SUPPLIER_PRODUCT_NUMBER;

				public Integer getSUPPLIER_PRODUCT_NUMBER () {
					return this.SUPPLIER_PRODUCT_NUMBER;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PGS_STAGE_DIM_BULK_PRODUCT.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_BULK_PRODUCT.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_BULK_PRODUCT = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_BULK_PRODUCT = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PGS_STAGE_DIM_BULK_PRODUCT, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_BULK_PRODUCT, 0, length, utf8Charset);
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
			if(length > commonByteArray_PGS_STAGE_DIM_BULK_PRODUCT.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_BULK_PRODUCT.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_BULK_PRODUCT = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_BULK_PRODUCT = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PGS_STAGE_DIM_BULK_PRODUCT, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_BULK_PRODUCT, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_BULK_PRODUCT) {

        	try {

        		int length = 0;
		
			        this.BULK_MOVEMENT_ID = dis.readInt();
					
			        this.BULK_PRODUCT_ID = dis.readInt();
					
			        this.TERMINAL_PRODUCT_NUMBER = dis.readInt();
					
					this.MEASUREMENT_DEVICE_PARENT_CODE = readString(dis);
					
						this.COMPARTMENT_NUMBER = readInteger(dis);
					
					this.MEASUREMENT_DEVICE_CODE = readString(dis);
					
					this.USER_INTERFACE_CODE = readString(dis);
					
						this.MEASUREMENT_DEVICE_TYPE = readInteger(dis);
					
					this.SNAPSHOT_TANK_CODE = readString(dis);
					
					this.CONTAINER_CODE = readString(dis);
					
						this.CONTAINER_TYPE = readInteger(dis);
					
						this.COMPARTMENT_OWNER_ID = readInteger(dis);
					
					this.COMPARTMENT_CONTAINER_CODE = readString(dis);
					
						this.SNAPSHOT_TYPE = readInteger(dis);
					
						this.COMPARTMENT_CONTAINER_TYPE = readInteger(dis);
					
			        this.FIGURES_TYPE = dis.readInt();
					
					this.SNAPSHOT_FOLIO_NUMBER = readString(dis);
					
						this.SNAPSHOT_SEQUENCE_NUMBER = readInteger(dis);
					
					this.FSHOST_SI_PRODUCT_NUMBER = readString(dis);
					
					this.TSHOST_SI_PRODUCT_NUMBER = readString(dis);
					
			        this.GROSS_QUANTITY = dis.readInt();
					
			        this.NET_QUANTITY = dis.readInt();
					
			        this.DENSITY = dis.readDouble();
					
			        this.TEMPERATURE = dis.readDouble();
					
			        this.WEIGHT = dis.readInt();
					
			        this.OCTANE = dis.readDouble();
					
			        this.RVP = dis.readDouble();
					
			        this.COEFFICIENT_EXPANSION = dis.readDouble();
					
			        this.OXYGEN = dis.readDouble();
					
			        this.SPECIFIC_GRAVITY = dis.readDouble();
					
					this.LAST_USER_NAME = readString(dis);
					
					this.LAST_MODIFIED = readDate(dis);
					
					this.START_DATE = readDate(dis);
					
					this.END_DATE = readDate(dis);
					
			        this.PRESSURE = dis.readDouble();
					
			        this.FLOW_RATE = dis.readDouble();
					
			        this.AVERAGE_METER_FACTOR = dis.readDouble();
					
			        this.VCF = dis.readDouble();
					
			        this.PCF = dis.readDouble();
					
			        this.OBSERVED_DENSITY = dis.readDouble();
					
			        this.INVENTORY_QUANTITY_TYPE = dis.readInt();
					
			        this.MEASURED_DENSITY = dis.readDouble();
					
			        this.BSW_PERCENT = dis.readDouble();
					
			        this.WATER_VOLUME = dis.readInt();
					
			        this.WEIGHT_IN_VAC = dis.readInt();
					
			        this.GROSS_FRAC_QUANTITY = dis.readInt();
					
			        this.NET_FRAC_QUANTITY = dis.readInt();
					
			        this.LEVEL_CHANGE = dis.readInt();
					
			        this.FRAC_WEIGHT = dis.readInt();
					
			        this.FRAC_WEIGHT_IN_VAC = dis.readInt();
					
			        this.DIRECTION = dis.readInt();
					
			        this.DECLARED_GROSS_QUANTITY = dis.readInt();
					
			        this.DECLARED_GROSS_FRAC_QUANTITY = dis.readInt();
					
			        this.DECLARED_NET_QUANTITY = dis.readInt();
					
			        this.DECLARED_NET_FRAC_QUANTITY = dis.readInt();
					
			        this.DECLARED_WEIGHT = dis.readInt();
					
			        this.DECLARED_FRAC_WEIGHT = dis.readInt();
					
			        this.DECLARED_WEIGHT_IN_VAC = dis.readInt();
					
			        this.MEASURED_QUANTITY_TYPE = dis.readInt();
					
			        this.DERIVED_VALUES_DIRECTIVE = dis.readInt();
					
			        this.DECLARED_FRAC_WEIGHT_IN_VAC = dis.readInt();
					
			        this.CALCULATE_NET = dis.readInt();
					
						this.CONTAINER_OWNER_ID = readInteger(dis);
					
			        this.AFFECT_ACCOUNTING = dis.readInt();
					
						this.SUPPLIER_PRODUCT_SUPPLIER = readInteger(dis);
					
						this.SUPPLIER_PRODUCT_NUMBER = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_BULK_PRODUCT) {

        	try {

        		int length = 0;
		
			        this.BULK_MOVEMENT_ID = dis.readInt();
					
			        this.BULK_PRODUCT_ID = dis.readInt();
					
			        this.TERMINAL_PRODUCT_NUMBER = dis.readInt();
					
					this.MEASUREMENT_DEVICE_PARENT_CODE = readString(dis);
					
						this.COMPARTMENT_NUMBER = readInteger(dis);
					
					this.MEASUREMENT_DEVICE_CODE = readString(dis);
					
					this.USER_INTERFACE_CODE = readString(dis);
					
						this.MEASUREMENT_DEVICE_TYPE = readInteger(dis);
					
					this.SNAPSHOT_TANK_CODE = readString(dis);
					
					this.CONTAINER_CODE = readString(dis);
					
						this.CONTAINER_TYPE = readInteger(dis);
					
						this.COMPARTMENT_OWNER_ID = readInteger(dis);
					
					this.COMPARTMENT_CONTAINER_CODE = readString(dis);
					
						this.SNAPSHOT_TYPE = readInteger(dis);
					
						this.COMPARTMENT_CONTAINER_TYPE = readInteger(dis);
					
			        this.FIGURES_TYPE = dis.readInt();
					
					this.SNAPSHOT_FOLIO_NUMBER = readString(dis);
					
						this.SNAPSHOT_SEQUENCE_NUMBER = readInteger(dis);
					
					this.FSHOST_SI_PRODUCT_NUMBER = readString(dis);
					
					this.TSHOST_SI_PRODUCT_NUMBER = readString(dis);
					
			        this.GROSS_QUANTITY = dis.readInt();
					
			        this.NET_QUANTITY = dis.readInt();
					
			        this.DENSITY = dis.readDouble();
					
			        this.TEMPERATURE = dis.readDouble();
					
			        this.WEIGHT = dis.readInt();
					
			        this.OCTANE = dis.readDouble();
					
			        this.RVP = dis.readDouble();
					
			        this.COEFFICIENT_EXPANSION = dis.readDouble();
					
			        this.OXYGEN = dis.readDouble();
					
			        this.SPECIFIC_GRAVITY = dis.readDouble();
					
					this.LAST_USER_NAME = readString(dis);
					
					this.LAST_MODIFIED = readDate(dis);
					
					this.START_DATE = readDate(dis);
					
					this.END_DATE = readDate(dis);
					
			        this.PRESSURE = dis.readDouble();
					
			        this.FLOW_RATE = dis.readDouble();
					
			        this.AVERAGE_METER_FACTOR = dis.readDouble();
					
			        this.VCF = dis.readDouble();
					
			        this.PCF = dis.readDouble();
					
			        this.OBSERVED_DENSITY = dis.readDouble();
					
			        this.INVENTORY_QUANTITY_TYPE = dis.readInt();
					
			        this.MEASURED_DENSITY = dis.readDouble();
					
			        this.BSW_PERCENT = dis.readDouble();
					
			        this.WATER_VOLUME = dis.readInt();
					
			        this.WEIGHT_IN_VAC = dis.readInt();
					
			        this.GROSS_FRAC_QUANTITY = dis.readInt();
					
			        this.NET_FRAC_QUANTITY = dis.readInt();
					
			        this.LEVEL_CHANGE = dis.readInt();
					
			        this.FRAC_WEIGHT = dis.readInt();
					
			        this.FRAC_WEIGHT_IN_VAC = dis.readInt();
					
			        this.DIRECTION = dis.readInt();
					
			        this.DECLARED_GROSS_QUANTITY = dis.readInt();
					
			        this.DECLARED_GROSS_FRAC_QUANTITY = dis.readInt();
					
			        this.DECLARED_NET_QUANTITY = dis.readInt();
					
			        this.DECLARED_NET_FRAC_QUANTITY = dis.readInt();
					
			        this.DECLARED_WEIGHT = dis.readInt();
					
			        this.DECLARED_FRAC_WEIGHT = dis.readInt();
					
			        this.DECLARED_WEIGHT_IN_VAC = dis.readInt();
					
			        this.MEASURED_QUANTITY_TYPE = dis.readInt();
					
			        this.DERIVED_VALUES_DIRECTIVE = dis.readInt();
					
			        this.DECLARED_FRAC_WEIGHT_IN_VAC = dis.readInt();
					
			        this.CALCULATE_NET = dis.readInt();
					
						this.CONTAINER_OWNER_ID = readInteger(dis);
					
			        this.AFFECT_ACCOUNTING = dis.readInt();
					
						this.SUPPLIER_PRODUCT_SUPPLIER = readInteger(dis);
					
						this.SUPPLIER_PRODUCT_NUMBER = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.BULK_MOVEMENT_ID);
					
					// int
				
		            	dos.writeInt(this.BULK_PRODUCT_ID);
					
					// int
				
		            	dos.writeInt(this.TERMINAL_PRODUCT_NUMBER);
					
					// String
				
						writeString(this.MEASUREMENT_DEVICE_PARENT_CODE,dos);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_NUMBER,dos);
					
					// String
				
						writeString(this.MEASUREMENT_DEVICE_CODE,dos);
					
					// String
				
						writeString(this.USER_INTERFACE_CODE,dos);
					
					// Integer
				
						writeInteger(this.MEASUREMENT_DEVICE_TYPE,dos);
					
					// String
				
						writeString(this.SNAPSHOT_TANK_CODE,dos);
					
					// String
				
						writeString(this.CONTAINER_CODE,dos);
					
					// Integer
				
						writeInteger(this.CONTAINER_TYPE,dos);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_OWNER_ID,dos);
					
					// String
				
						writeString(this.COMPARTMENT_CONTAINER_CODE,dos);
					
					// Integer
				
						writeInteger(this.SNAPSHOT_TYPE,dos);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_CONTAINER_TYPE,dos);
					
					// int
				
		            	dos.writeInt(this.FIGURES_TYPE);
					
					// String
				
						writeString(this.SNAPSHOT_FOLIO_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.SNAPSHOT_SEQUENCE_NUMBER,dos);
					
					// String
				
						writeString(this.FSHOST_SI_PRODUCT_NUMBER,dos);
					
					// String
				
						writeString(this.TSHOST_SI_PRODUCT_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.GROSS_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.NET_QUANTITY);
					
					// double
				
		            	dos.writeDouble(this.DENSITY);
					
					// double
				
		            	dos.writeDouble(this.TEMPERATURE);
					
					// int
				
		            	dos.writeInt(this.WEIGHT);
					
					// double
				
		            	dos.writeDouble(this.OCTANE);
					
					// double
				
		            	dos.writeDouble(this.RVP);
					
					// double
				
		            	dos.writeDouble(this.COEFFICIENT_EXPANSION);
					
					// double
				
		            	dos.writeDouble(this.OXYGEN);
					
					// double
				
		            	dos.writeDouble(this.SPECIFIC_GRAVITY);
					
					// String
				
						writeString(this.LAST_USER_NAME,dos);
					
					// java.util.Date
				
						writeDate(this.LAST_MODIFIED,dos);
					
					// java.util.Date
				
						writeDate(this.START_DATE,dos);
					
					// java.util.Date
				
						writeDate(this.END_DATE,dos);
					
					// double
				
		            	dos.writeDouble(this.PRESSURE);
					
					// double
				
		            	dos.writeDouble(this.FLOW_RATE);
					
					// double
				
		            	dos.writeDouble(this.AVERAGE_METER_FACTOR);
					
					// double
				
		            	dos.writeDouble(this.VCF);
					
					// double
				
		            	dos.writeDouble(this.PCF);
					
					// double
				
		            	dos.writeDouble(this.OBSERVED_DENSITY);
					
					// int
				
		            	dos.writeInt(this.INVENTORY_QUANTITY_TYPE);
					
					// double
				
		            	dos.writeDouble(this.MEASURED_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.BSW_PERCENT);
					
					// int
				
		            	dos.writeInt(this.WATER_VOLUME);
					
					// int
				
		            	dos.writeInt(this.WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.GROSS_FRAC_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.NET_FRAC_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.LEVEL_CHANGE);
					
					// int
				
		            	dos.writeInt(this.FRAC_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.FRAC_WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.DIRECTION);
					
					// int
				
		            	dos.writeInt(this.DECLARED_GROSS_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.DECLARED_GROSS_FRAC_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.DECLARED_NET_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.DECLARED_NET_FRAC_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.DECLARED_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.DECLARED_FRAC_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.DECLARED_WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.MEASURED_QUANTITY_TYPE);
					
					// int
				
		            	dos.writeInt(this.DERIVED_VALUES_DIRECTIVE);
					
					// int
				
		            	dos.writeInt(this.DECLARED_FRAC_WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.CALCULATE_NET);
					
					// Integer
				
						writeInteger(this.CONTAINER_OWNER_ID,dos);
					
					// int
				
		            	dos.writeInt(this.AFFECT_ACCOUNTING);
					
					// Integer
				
						writeInteger(this.SUPPLIER_PRODUCT_SUPPLIER,dos);
					
					// Integer
				
						writeInteger(this.SUPPLIER_PRODUCT_NUMBER,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.BULK_MOVEMENT_ID);
					
					// int
				
		            	dos.writeInt(this.BULK_PRODUCT_ID);
					
					// int
				
		            	dos.writeInt(this.TERMINAL_PRODUCT_NUMBER);
					
					// String
				
						writeString(this.MEASUREMENT_DEVICE_PARENT_CODE,dos);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_NUMBER,dos);
					
					// String
				
						writeString(this.MEASUREMENT_DEVICE_CODE,dos);
					
					// String
				
						writeString(this.USER_INTERFACE_CODE,dos);
					
					// Integer
				
						writeInteger(this.MEASUREMENT_DEVICE_TYPE,dos);
					
					// String
				
						writeString(this.SNAPSHOT_TANK_CODE,dos);
					
					// String
				
						writeString(this.CONTAINER_CODE,dos);
					
					// Integer
				
						writeInteger(this.CONTAINER_TYPE,dos);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_OWNER_ID,dos);
					
					// String
				
						writeString(this.COMPARTMENT_CONTAINER_CODE,dos);
					
					// Integer
				
						writeInteger(this.SNAPSHOT_TYPE,dos);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_CONTAINER_TYPE,dos);
					
					// int
				
		            	dos.writeInt(this.FIGURES_TYPE);
					
					// String
				
						writeString(this.SNAPSHOT_FOLIO_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.SNAPSHOT_SEQUENCE_NUMBER,dos);
					
					// String
				
						writeString(this.FSHOST_SI_PRODUCT_NUMBER,dos);
					
					// String
				
						writeString(this.TSHOST_SI_PRODUCT_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.GROSS_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.NET_QUANTITY);
					
					// double
				
		            	dos.writeDouble(this.DENSITY);
					
					// double
				
		            	dos.writeDouble(this.TEMPERATURE);
					
					// int
				
		            	dos.writeInt(this.WEIGHT);
					
					// double
				
		            	dos.writeDouble(this.OCTANE);
					
					// double
				
		            	dos.writeDouble(this.RVP);
					
					// double
				
		            	dos.writeDouble(this.COEFFICIENT_EXPANSION);
					
					// double
				
		            	dos.writeDouble(this.OXYGEN);
					
					// double
				
		            	dos.writeDouble(this.SPECIFIC_GRAVITY);
					
					// String
				
						writeString(this.LAST_USER_NAME,dos);
					
					// java.util.Date
				
						writeDate(this.LAST_MODIFIED,dos);
					
					// java.util.Date
				
						writeDate(this.START_DATE,dos);
					
					// java.util.Date
				
						writeDate(this.END_DATE,dos);
					
					// double
				
		            	dos.writeDouble(this.PRESSURE);
					
					// double
				
		            	dos.writeDouble(this.FLOW_RATE);
					
					// double
				
		            	dos.writeDouble(this.AVERAGE_METER_FACTOR);
					
					// double
				
		            	dos.writeDouble(this.VCF);
					
					// double
				
		            	dos.writeDouble(this.PCF);
					
					// double
				
		            	dos.writeDouble(this.OBSERVED_DENSITY);
					
					// int
				
		            	dos.writeInt(this.INVENTORY_QUANTITY_TYPE);
					
					// double
				
		            	dos.writeDouble(this.MEASURED_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.BSW_PERCENT);
					
					// int
				
		            	dos.writeInt(this.WATER_VOLUME);
					
					// int
				
		            	dos.writeInt(this.WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.GROSS_FRAC_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.NET_FRAC_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.LEVEL_CHANGE);
					
					// int
				
		            	dos.writeInt(this.FRAC_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.FRAC_WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.DIRECTION);
					
					// int
				
		            	dos.writeInt(this.DECLARED_GROSS_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.DECLARED_GROSS_FRAC_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.DECLARED_NET_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.DECLARED_NET_FRAC_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.DECLARED_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.DECLARED_FRAC_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.DECLARED_WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.MEASURED_QUANTITY_TYPE);
					
					// int
				
		            	dos.writeInt(this.DERIVED_VALUES_DIRECTIVE);
					
					// int
				
		            	dos.writeInt(this.DECLARED_FRAC_WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.CALCULATE_NET);
					
					// Integer
				
						writeInteger(this.CONTAINER_OWNER_ID,dos);
					
					// int
				
		            	dos.writeInt(this.AFFECT_ACCOUNTING);
					
					// Integer
				
						writeInteger(this.SUPPLIER_PRODUCT_SUPPLIER,dos);
					
					// Integer
				
						writeInteger(this.SUPPLIER_PRODUCT_NUMBER,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("BULK_MOVEMENT_ID="+String.valueOf(BULK_MOVEMENT_ID));
		sb.append(",BULK_PRODUCT_ID="+String.valueOf(BULK_PRODUCT_ID));
		sb.append(",TERMINAL_PRODUCT_NUMBER="+String.valueOf(TERMINAL_PRODUCT_NUMBER));
		sb.append(",MEASUREMENT_DEVICE_PARENT_CODE="+MEASUREMENT_DEVICE_PARENT_CODE);
		sb.append(",COMPARTMENT_NUMBER="+String.valueOf(COMPARTMENT_NUMBER));
		sb.append(",MEASUREMENT_DEVICE_CODE="+MEASUREMENT_DEVICE_CODE);
		sb.append(",USER_INTERFACE_CODE="+USER_INTERFACE_CODE);
		sb.append(",MEASUREMENT_DEVICE_TYPE="+String.valueOf(MEASUREMENT_DEVICE_TYPE));
		sb.append(",SNAPSHOT_TANK_CODE="+SNAPSHOT_TANK_CODE);
		sb.append(",CONTAINER_CODE="+CONTAINER_CODE);
		sb.append(",CONTAINER_TYPE="+String.valueOf(CONTAINER_TYPE));
		sb.append(",COMPARTMENT_OWNER_ID="+String.valueOf(COMPARTMENT_OWNER_ID));
		sb.append(",COMPARTMENT_CONTAINER_CODE="+COMPARTMENT_CONTAINER_CODE);
		sb.append(",SNAPSHOT_TYPE="+String.valueOf(SNAPSHOT_TYPE));
		sb.append(",COMPARTMENT_CONTAINER_TYPE="+String.valueOf(COMPARTMENT_CONTAINER_TYPE));
		sb.append(",FIGURES_TYPE="+String.valueOf(FIGURES_TYPE));
		sb.append(",SNAPSHOT_FOLIO_NUMBER="+SNAPSHOT_FOLIO_NUMBER);
		sb.append(",SNAPSHOT_SEQUENCE_NUMBER="+String.valueOf(SNAPSHOT_SEQUENCE_NUMBER));
		sb.append(",FSHOST_SI_PRODUCT_NUMBER="+FSHOST_SI_PRODUCT_NUMBER);
		sb.append(",TSHOST_SI_PRODUCT_NUMBER="+TSHOST_SI_PRODUCT_NUMBER);
		sb.append(",GROSS_QUANTITY="+String.valueOf(GROSS_QUANTITY));
		sb.append(",NET_QUANTITY="+String.valueOf(NET_QUANTITY));
		sb.append(",DENSITY="+String.valueOf(DENSITY));
		sb.append(",TEMPERATURE="+String.valueOf(TEMPERATURE));
		sb.append(",WEIGHT="+String.valueOf(WEIGHT));
		sb.append(",OCTANE="+String.valueOf(OCTANE));
		sb.append(",RVP="+String.valueOf(RVP));
		sb.append(",COEFFICIENT_EXPANSION="+String.valueOf(COEFFICIENT_EXPANSION));
		sb.append(",OXYGEN="+String.valueOf(OXYGEN));
		sb.append(",SPECIFIC_GRAVITY="+String.valueOf(SPECIFIC_GRAVITY));
		sb.append(",LAST_USER_NAME="+LAST_USER_NAME);
		sb.append(",LAST_MODIFIED="+String.valueOf(LAST_MODIFIED));
		sb.append(",START_DATE="+String.valueOf(START_DATE));
		sb.append(",END_DATE="+String.valueOf(END_DATE));
		sb.append(",PRESSURE="+String.valueOf(PRESSURE));
		sb.append(",FLOW_RATE="+String.valueOf(FLOW_RATE));
		sb.append(",AVERAGE_METER_FACTOR="+String.valueOf(AVERAGE_METER_FACTOR));
		sb.append(",VCF="+String.valueOf(VCF));
		sb.append(",PCF="+String.valueOf(PCF));
		sb.append(",OBSERVED_DENSITY="+String.valueOf(OBSERVED_DENSITY));
		sb.append(",INVENTORY_QUANTITY_TYPE="+String.valueOf(INVENTORY_QUANTITY_TYPE));
		sb.append(",MEASURED_DENSITY="+String.valueOf(MEASURED_DENSITY));
		sb.append(",BSW_PERCENT="+String.valueOf(BSW_PERCENT));
		sb.append(",WATER_VOLUME="+String.valueOf(WATER_VOLUME));
		sb.append(",WEIGHT_IN_VAC="+String.valueOf(WEIGHT_IN_VAC));
		sb.append(",GROSS_FRAC_QUANTITY="+String.valueOf(GROSS_FRAC_QUANTITY));
		sb.append(",NET_FRAC_QUANTITY="+String.valueOf(NET_FRAC_QUANTITY));
		sb.append(",LEVEL_CHANGE="+String.valueOf(LEVEL_CHANGE));
		sb.append(",FRAC_WEIGHT="+String.valueOf(FRAC_WEIGHT));
		sb.append(",FRAC_WEIGHT_IN_VAC="+String.valueOf(FRAC_WEIGHT_IN_VAC));
		sb.append(",DIRECTION="+String.valueOf(DIRECTION));
		sb.append(",DECLARED_GROSS_QUANTITY="+String.valueOf(DECLARED_GROSS_QUANTITY));
		sb.append(",DECLARED_GROSS_FRAC_QUANTITY="+String.valueOf(DECLARED_GROSS_FRAC_QUANTITY));
		sb.append(",DECLARED_NET_QUANTITY="+String.valueOf(DECLARED_NET_QUANTITY));
		sb.append(",DECLARED_NET_FRAC_QUANTITY="+String.valueOf(DECLARED_NET_FRAC_QUANTITY));
		sb.append(",DECLARED_WEIGHT="+String.valueOf(DECLARED_WEIGHT));
		sb.append(",DECLARED_FRAC_WEIGHT="+String.valueOf(DECLARED_FRAC_WEIGHT));
		sb.append(",DECLARED_WEIGHT_IN_VAC="+String.valueOf(DECLARED_WEIGHT_IN_VAC));
		sb.append(",MEASURED_QUANTITY_TYPE="+String.valueOf(MEASURED_QUANTITY_TYPE));
		sb.append(",DERIVED_VALUES_DIRECTIVE="+String.valueOf(DERIVED_VALUES_DIRECTIVE));
		sb.append(",DECLARED_FRAC_WEIGHT_IN_VAC="+String.valueOf(DECLARED_FRAC_WEIGHT_IN_VAC));
		sb.append(",CALCULATE_NET="+String.valueOf(CALCULATE_NET));
		sb.append(",CONTAINER_OWNER_ID="+String.valueOf(CONTAINER_OWNER_ID));
		sb.append(",AFFECT_ACCOUNTING="+String.valueOf(AFFECT_ACCOUNTING));
		sb.append(",SUPPLIER_PRODUCT_SUPPLIER="+String.valueOf(SUPPLIER_PRODUCT_SUPPLIER));
		sb.append(",SUPPLIER_PRODUCT_NUMBER="+String.valueOf(SUPPLIER_PRODUCT_NUMBER));
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
    final static byte[] commonByteArrayLock_PGS_STAGE_DIM_BULK_PRODUCT = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_DIM_BULK_PRODUCT = new byte[0];

	
			    public int BULK_MOVEMENT_ID;

				public int getBULK_MOVEMENT_ID () {
					return this.BULK_MOVEMENT_ID;
				}
				
			    public int BULK_PRODUCT_ID;

				public int getBULK_PRODUCT_ID () {
					return this.BULK_PRODUCT_ID;
				}
				
			    public int TERMINAL_PRODUCT_NUMBER;

				public int getTERMINAL_PRODUCT_NUMBER () {
					return this.TERMINAL_PRODUCT_NUMBER;
				}
				
			    public String MEASUREMENT_DEVICE_PARENT_CODE;

				public String getMEASUREMENT_DEVICE_PARENT_CODE () {
					return this.MEASUREMENT_DEVICE_PARENT_CODE;
				}
				
			    public Integer COMPARTMENT_NUMBER;

				public Integer getCOMPARTMENT_NUMBER () {
					return this.COMPARTMENT_NUMBER;
				}
				
			    public String MEASUREMENT_DEVICE_CODE;

				public String getMEASUREMENT_DEVICE_CODE () {
					return this.MEASUREMENT_DEVICE_CODE;
				}
				
			    public String USER_INTERFACE_CODE;

				public String getUSER_INTERFACE_CODE () {
					return this.USER_INTERFACE_CODE;
				}
				
			    public Integer MEASUREMENT_DEVICE_TYPE;

				public Integer getMEASUREMENT_DEVICE_TYPE () {
					return this.MEASUREMENT_DEVICE_TYPE;
				}
				
			    public String SNAPSHOT_TANK_CODE;

				public String getSNAPSHOT_TANK_CODE () {
					return this.SNAPSHOT_TANK_CODE;
				}
				
			    public String CONTAINER_CODE;

				public String getCONTAINER_CODE () {
					return this.CONTAINER_CODE;
				}
				
			    public Integer CONTAINER_TYPE;

				public Integer getCONTAINER_TYPE () {
					return this.CONTAINER_TYPE;
				}
				
			    public Integer COMPARTMENT_OWNER_ID;

				public Integer getCOMPARTMENT_OWNER_ID () {
					return this.COMPARTMENT_OWNER_ID;
				}
				
			    public String COMPARTMENT_CONTAINER_CODE;

				public String getCOMPARTMENT_CONTAINER_CODE () {
					return this.COMPARTMENT_CONTAINER_CODE;
				}
				
			    public Integer SNAPSHOT_TYPE;

				public Integer getSNAPSHOT_TYPE () {
					return this.SNAPSHOT_TYPE;
				}
				
			    public Integer COMPARTMENT_CONTAINER_TYPE;

				public Integer getCOMPARTMENT_CONTAINER_TYPE () {
					return this.COMPARTMENT_CONTAINER_TYPE;
				}
				
			    public int FIGURES_TYPE;

				public int getFIGURES_TYPE () {
					return this.FIGURES_TYPE;
				}
				
			    public String SNAPSHOT_FOLIO_NUMBER;

				public String getSNAPSHOT_FOLIO_NUMBER () {
					return this.SNAPSHOT_FOLIO_NUMBER;
				}
				
			    public Integer SNAPSHOT_SEQUENCE_NUMBER;

				public Integer getSNAPSHOT_SEQUENCE_NUMBER () {
					return this.SNAPSHOT_SEQUENCE_NUMBER;
				}
				
			    public String FSHOST_SI_PRODUCT_NUMBER;

				public String getFSHOST_SI_PRODUCT_NUMBER () {
					return this.FSHOST_SI_PRODUCT_NUMBER;
				}
				
			    public String TSHOST_SI_PRODUCT_NUMBER;

				public String getTSHOST_SI_PRODUCT_NUMBER () {
					return this.TSHOST_SI_PRODUCT_NUMBER;
				}
				
			    public int GROSS_QUANTITY;

				public int getGROSS_QUANTITY () {
					return this.GROSS_QUANTITY;
				}
				
			    public int NET_QUANTITY;

				public int getNET_QUANTITY () {
					return this.NET_QUANTITY;
				}
				
			    public double DENSITY;

				public double getDENSITY () {
					return this.DENSITY;
				}
				
			    public double TEMPERATURE;

				public double getTEMPERATURE () {
					return this.TEMPERATURE;
				}
				
			    public int WEIGHT;

				public int getWEIGHT () {
					return this.WEIGHT;
				}
				
			    public double OCTANE;

				public double getOCTANE () {
					return this.OCTANE;
				}
				
			    public double RVP;

				public double getRVP () {
					return this.RVP;
				}
				
			    public double COEFFICIENT_EXPANSION;

				public double getCOEFFICIENT_EXPANSION () {
					return this.COEFFICIENT_EXPANSION;
				}
				
			    public double OXYGEN;

				public double getOXYGEN () {
					return this.OXYGEN;
				}
				
			    public double SPECIFIC_GRAVITY;

				public double getSPECIFIC_GRAVITY () {
					return this.SPECIFIC_GRAVITY;
				}
				
			    public String LAST_USER_NAME;

				public String getLAST_USER_NAME () {
					return this.LAST_USER_NAME;
				}
				
			    public java.util.Date LAST_MODIFIED;

				public java.util.Date getLAST_MODIFIED () {
					return this.LAST_MODIFIED;
				}
				
			    public java.util.Date START_DATE;

				public java.util.Date getSTART_DATE () {
					return this.START_DATE;
				}
				
			    public java.util.Date END_DATE;

				public java.util.Date getEND_DATE () {
					return this.END_DATE;
				}
				
			    public double PRESSURE;

				public double getPRESSURE () {
					return this.PRESSURE;
				}
				
			    public double FLOW_RATE;

				public double getFLOW_RATE () {
					return this.FLOW_RATE;
				}
				
			    public double AVERAGE_METER_FACTOR;

				public double getAVERAGE_METER_FACTOR () {
					return this.AVERAGE_METER_FACTOR;
				}
				
			    public double VCF;

				public double getVCF () {
					return this.VCF;
				}
				
			    public double PCF;

				public double getPCF () {
					return this.PCF;
				}
				
			    public double OBSERVED_DENSITY;

				public double getOBSERVED_DENSITY () {
					return this.OBSERVED_DENSITY;
				}
				
			    public int INVENTORY_QUANTITY_TYPE;

				public int getINVENTORY_QUANTITY_TYPE () {
					return this.INVENTORY_QUANTITY_TYPE;
				}
				
			    public double MEASURED_DENSITY;

				public double getMEASURED_DENSITY () {
					return this.MEASURED_DENSITY;
				}
				
			    public double BSW_PERCENT;

				public double getBSW_PERCENT () {
					return this.BSW_PERCENT;
				}
				
			    public int WATER_VOLUME;

				public int getWATER_VOLUME () {
					return this.WATER_VOLUME;
				}
				
			    public int WEIGHT_IN_VAC;

				public int getWEIGHT_IN_VAC () {
					return this.WEIGHT_IN_VAC;
				}
				
			    public int GROSS_FRAC_QUANTITY;

				public int getGROSS_FRAC_QUANTITY () {
					return this.GROSS_FRAC_QUANTITY;
				}
				
			    public int NET_FRAC_QUANTITY;

				public int getNET_FRAC_QUANTITY () {
					return this.NET_FRAC_QUANTITY;
				}
				
			    public int LEVEL_CHANGE;

				public int getLEVEL_CHANGE () {
					return this.LEVEL_CHANGE;
				}
				
			    public int FRAC_WEIGHT;

				public int getFRAC_WEIGHT () {
					return this.FRAC_WEIGHT;
				}
				
			    public int FRAC_WEIGHT_IN_VAC;

				public int getFRAC_WEIGHT_IN_VAC () {
					return this.FRAC_WEIGHT_IN_VAC;
				}
				
			    public int DIRECTION;

				public int getDIRECTION () {
					return this.DIRECTION;
				}
				
			    public int DECLARED_GROSS_QUANTITY;

				public int getDECLARED_GROSS_QUANTITY () {
					return this.DECLARED_GROSS_QUANTITY;
				}
				
			    public int DECLARED_GROSS_FRAC_QUANTITY;

				public int getDECLARED_GROSS_FRAC_QUANTITY () {
					return this.DECLARED_GROSS_FRAC_QUANTITY;
				}
				
			    public int DECLARED_NET_QUANTITY;

				public int getDECLARED_NET_QUANTITY () {
					return this.DECLARED_NET_QUANTITY;
				}
				
			    public int DECLARED_NET_FRAC_QUANTITY;

				public int getDECLARED_NET_FRAC_QUANTITY () {
					return this.DECLARED_NET_FRAC_QUANTITY;
				}
				
			    public int DECLARED_WEIGHT;

				public int getDECLARED_WEIGHT () {
					return this.DECLARED_WEIGHT;
				}
				
			    public int DECLARED_FRAC_WEIGHT;

				public int getDECLARED_FRAC_WEIGHT () {
					return this.DECLARED_FRAC_WEIGHT;
				}
				
			    public int DECLARED_WEIGHT_IN_VAC;

				public int getDECLARED_WEIGHT_IN_VAC () {
					return this.DECLARED_WEIGHT_IN_VAC;
				}
				
			    public int MEASURED_QUANTITY_TYPE;

				public int getMEASURED_QUANTITY_TYPE () {
					return this.MEASURED_QUANTITY_TYPE;
				}
				
			    public int DERIVED_VALUES_DIRECTIVE;

				public int getDERIVED_VALUES_DIRECTIVE () {
					return this.DERIVED_VALUES_DIRECTIVE;
				}
				
			    public int DECLARED_FRAC_WEIGHT_IN_VAC;

				public int getDECLARED_FRAC_WEIGHT_IN_VAC () {
					return this.DECLARED_FRAC_WEIGHT_IN_VAC;
				}
				
			    public int CALCULATE_NET;

				public int getCALCULATE_NET () {
					return this.CALCULATE_NET;
				}
				
			    public Integer CONTAINER_OWNER_ID;

				public Integer getCONTAINER_OWNER_ID () {
					return this.CONTAINER_OWNER_ID;
				}
				
			    public int AFFECT_ACCOUNTING;

				public int getAFFECT_ACCOUNTING () {
					return this.AFFECT_ACCOUNTING;
				}
				
			    public Integer SUPPLIER_PRODUCT_SUPPLIER;

				public Integer getSUPPLIER_PRODUCT_SUPPLIER () {
					return this.SUPPLIER_PRODUCT_SUPPLIER;
				}
				
			    public Integer SUPPLIER_PRODUCT_NUMBER;

				public Integer getSUPPLIER_PRODUCT_NUMBER () {
					return this.SUPPLIER_PRODUCT_NUMBER;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PGS_STAGE_DIM_BULK_PRODUCT.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_BULK_PRODUCT.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_BULK_PRODUCT = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_BULK_PRODUCT = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PGS_STAGE_DIM_BULK_PRODUCT, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_BULK_PRODUCT, 0, length, utf8Charset);
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
			if(length > commonByteArray_PGS_STAGE_DIM_BULK_PRODUCT.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_BULK_PRODUCT.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_BULK_PRODUCT = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_BULK_PRODUCT = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PGS_STAGE_DIM_BULK_PRODUCT, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_BULK_PRODUCT, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_BULK_PRODUCT) {

        	try {

        		int length = 0;
		
			        this.BULK_MOVEMENT_ID = dis.readInt();
					
			        this.BULK_PRODUCT_ID = dis.readInt();
					
			        this.TERMINAL_PRODUCT_NUMBER = dis.readInt();
					
					this.MEASUREMENT_DEVICE_PARENT_CODE = readString(dis);
					
						this.COMPARTMENT_NUMBER = readInteger(dis);
					
					this.MEASUREMENT_DEVICE_CODE = readString(dis);
					
					this.USER_INTERFACE_CODE = readString(dis);
					
						this.MEASUREMENT_DEVICE_TYPE = readInteger(dis);
					
					this.SNAPSHOT_TANK_CODE = readString(dis);
					
					this.CONTAINER_CODE = readString(dis);
					
						this.CONTAINER_TYPE = readInteger(dis);
					
						this.COMPARTMENT_OWNER_ID = readInteger(dis);
					
					this.COMPARTMENT_CONTAINER_CODE = readString(dis);
					
						this.SNAPSHOT_TYPE = readInteger(dis);
					
						this.COMPARTMENT_CONTAINER_TYPE = readInteger(dis);
					
			        this.FIGURES_TYPE = dis.readInt();
					
					this.SNAPSHOT_FOLIO_NUMBER = readString(dis);
					
						this.SNAPSHOT_SEQUENCE_NUMBER = readInteger(dis);
					
					this.FSHOST_SI_PRODUCT_NUMBER = readString(dis);
					
					this.TSHOST_SI_PRODUCT_NUMBER = readString(dis);
					
			        this.GROSS_QUANTITY = dis.readInt();
					
			        this.NET_QUANTITY = dis.readInt();
					
			        this.DENSITY = dis.readDouble();
					
			        this.TEMPERATURE = dis.readDouble();
					
			        this.WEIGHT = dis.readInt();
					
			        this.OCTANE = dis.readDouble();
					
			        this.RVP = dis.readDouble();
					
			        this.COEFFICIENT_EXPANSION = dis.readDouble();
					
			        this.OXYGEN = dis.readDouble();
					
			        this.SPECIFIC_GRAVITY = dis.readDouble();
					
					this.LAST_USER_NAME = readString(dis);
					
					this.LAST_MODIFIED = readDate(dis);
					
					this.START_DATE = readDate(dis);
					
					this.END_DATE = readDate(dis);
					
			        this.PRESSURE = dis.readDouble();
					
			        this.FLOW_RATE = dis.readDouble();
					
			        this.AVERAGE_METER_FACTOR = dis.readDouble();
					
			        this.VCF = dis.readDouble();
					
			        this.PCF = dis.readDouble();
					
			        this.OBSERVED_DENSITY = dis.readDouble();
					
			        this.INVENTORY_QUANTITY_TYPE = dis.readInt();
					
			        this.MEASURED_DENSITY = dis.readDouble();
					
			        this.BSW_PERCENT = dis.readDouble();
					
			        this.WATER_VOLUME = dis.readInt();
					
			        this.WEIGHT_IN_VAC = dis.readInt();
					
			        this.GROSS_FRAC_QUANTITY = dis.readInt();
					
			        this.NET_FRAC_QUANTITY = dis.readInt();
					
			        this.LEVEL_CHANGE = dis.readInt();
					
			        this.FRAC_WEIGHT = dis.readInt();
					
			        this.FRAC_WEIGHT_IN_VAC = dis.readInt();
					
			        this.DIRECTION = dis.readInt();
					
			        this.DECLARED_GROSS_QUANTITY = dis.readInt();
					
			        this.DECLARED_GROSS_FRAC_QUANTITY = dis.readInt();
					
			        this.DECLARED_NET_QUANTITY = dis.readInt();
					
			        this.DECLARED_NET_FRAC_QUANTITY = dis.readInt();
					
			        this.DECLARED_WEIGHT = dis.readInt();
					
			        this.DECLARED_FRAC_WEIGHT = dis.readInt();
					
			        this.DECLARED_WEIGHT_IN_VAC = dis.readInt();
					
			        this.MEASURED_QUANTITY_TYPE = dis.readInt();
					
			        this.DERIVED_VALUES_DIRECTIVE = dis.readInt();
					
			        this.DECLARED_FRAC_WEIGHT_IN_VAC = dis.readInt();
					
			        this.CALCULATE_NET = dis.readInt();
					
						this.CONTAINER_OWNER_ID = readInteger(dis);
					
			        this.AFFECT_ACCOUNTING = dis.readInt();
					
						this.SUPPLIER_PRODUCT_SUPPLIER = readInteger(dis);
					
						this.SUPPLIER_PRODUCT_NUMBER = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_BULK_PRODUCT) {

        	try {

        		int length = 0;
		
			        this.BULK_MOVEMENT_ID = dis.readInt();
					
			        this.BULK_PRODUCT_ID = dis.readInt();
					
			        this.TERMINAL_PRODUCT_NUMBER = dis.readInt();
					
					this.MEASUREMENT_DEVICE_PARENT_CODE = readString(dis);
					
						this.COMPARTMENT_NUMBER = readInteger(dis);
					
					this.MEASUREMENT_DEVICE_CODE = readString(dis);
					
					this.USER_INTERFACE_CODE = readString(dis);
					
						this.MEASUREMENT_DEVICE_TYPE = readInteger(dis);
					
					this.SNAPSHOT_TANK_CODE = readString(dis);
					
					this.CONTAINER_CODE = readString(dis);
					
						this.CONTAINER_TYPE = readInteger(dis);
					
						this.COMPARTMENT_OWNER_ID = readInteger(dis);
					
					this.COMPARTMENT_CONTAINER_CODE = readString(dis);
					
						this.SNAPSHOT_TYPE = readInteger(dis);
					
						this.COMPARTMENT_CONTAINER_TYPE = readInteger(dis);
					
			        this.FIGURES_TYPE = dis.readInt();
					
					this.SNAPSHOT_FOLIO_NUMBER = readString(dis);
					
						this.SNAPSHOT_SEQUENCE_NUMBER = readInteger(dis);
					
					this.FSHOST_SI_PRODUCT_NUMBER = readString(dis);
					
					this.TSHOST_SI_PRODUCT_NUMBER = readString(dis);
					
			        this.GROSS_QUANTITY = dis.readInt();
					
			        this.NET_QUANTITY = dis.readInt();
					
			        this.DENSITY = dis.readDouble();
					
			        this.TEMPERATURE = dis.readDouble();
					
			        this.WEIGHT = dis.readInt();
					
			        this.OCTANE = dis.readDouble();
					
			        this.RVP = dis.readDouble();
					
			        this.COEFFICIENT_EXPANSION = dis.readDouble();
					
			        this.OXYGEN = dis.readDouble();
					
			        this.SPECIFIC_GRAVITY = dis.readDouble();
					
					this.LAST_USER_NAME = readString(dis);
					
					this.LAST_MODIFIED = readDate(dis);
					
					this.START_DATE = readDate(dis);
					
					this.END_DATE = readDate(dis);
					
			        this.PRESSURE = dis.readDouble();
					
			        this.FLOW_RATE = dis.readDouble();
					
			        this.AVERAGE_METER_FACTOR = dis.readDouble();
					
			        this.VCF = dis.readDouble();
					
			        this.PCF = dis.readDouble();
					
			        this.OBSERVED_DENSITY = dis.readDouble();
					
			        this.INVENTORY_QUANTITY_TYPE = dis.readInt();
					
			        this.MEASURED_DENSITY = dis.readDouble();
					
			        this.BSW_PERCENT = dis.readDouble();
					
			        this.WATER_VOLUME = dis.readInt();
					
			        this.WEIGHT_IN_VAC = dis.readInt();
					
			        this.GROSS_FRAC_QUANTITY = dis.readInt();
					
			        this.NET_FRAC_QUANTITY = dis.readInt();
					
			        this.LEVEL_CHANGE = dis.readInt();
					
			        this.FRAC_WEIGHT = dis.readInt();
					
			        this.FRAC_WEIGHT_IN_VAC = dis.readInt();
					
			        this.DIRECTION = dis.readInt();
					
			        this.DECLARED_GROSS_QUANTITY = dis.readInt();
					
			        this.DECLARED_GROSS_FRAC_QUANTITY = dis.readInt();
					
			        this.DECLARED_NET_QUANTITY = dis.readInt();
					
			        this.DECLARED_NET_FRAC_QUANTITY = dis.readInt();
					
			        this.DECLARED_WEIGHT = dis.readInt();
					
			        this.DECLARED_FRAC_WEIGHT = dis.readInt();
					
			        this.DECLARED_WEIGHT_IN_VAC = dis.readInt();
					
			        this.MEASURED_QUANTITY_TYPE = dis.readInt();
					
			        this.DERIVED_VALUES_DIRECTIVE = dis.readInt();
					
			        this.DECLARED_FRAC_WEIGHT_IN_VAC = dis.readInt();
					
			        this.CALCULATE_NET = dis.readInt();
					
						this.CONTAINER_OWNER_ID = readInteger(dis);
					
			        this.AFFECT_ACCOUNTING = dis.readInt();
					
						this.SUPPLIER_PRODUCT_SUPPLIER = readInteger(dis);
					
						this.SUPPLIER_PRODUCT_NUMBER = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.BULK_MOVEMENT_ID);
					
					// int
				
		            	dos.writeInt(this.BULK_PRODUCT_ID);
					
					// int
				
		            	dos.writeInt(this.TERMINAL_PRODUCT_NUMBER);
					
					// String
				
						writeString(this.MEASUREMENT_DEVICE_PARENT_CODE,dos);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_NUMBER,dos);
					
					// String
				
						writeString(this.MEASUREMENT_DEVICE_CODE,dos);
					
					// String
				
						writeString(this.USER_INTERFACE_CODE,dos);
					
					// Integer
				
						writeInteger(this.MEASUREMENT_DEVICE_TYPE,dos);
					
					// String
				
						writeString(this.SNAPSHOT_TANK_CODE,dos);
					
					// String
				
						writeString(this.CONTAINER_CODE,dos);
					
					// Integer
				
						writeInteger(this.CONTAINER_TYPE,dos);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_OWNER_ID,dos);
					
					// String
				
						writeString(this.COMPARTMENT_CONTAINER_CODE,dos);
					
					// Integer
				
						writeInteger(this.SNAPSHOT_TYPE,dos);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_CONTAINER_TYPE,dos);
					
					// int
				
		            	dos.writeInt(this.FIGURES_TYPE);
					
					// String
				
						writeString(this.SNAPSHOT_FOLIO_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.SNAPSHOT_SEQUENCE_NUMBER,dos);
					
					// String
				
						writeString(this.FSHOST_SI_PRODUCT_NUMBER,dos);
					
					// String
				
						writeString(this.TSHOST_SI_PRODUCT_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.GROSS_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.NET_QUANTITY);
					
					// double
				
		            	dos.writeDouble(this.DENSITY);
					
					// double
				
		            	dos.writeDouble(this.TEMPERATURE);
					
					// int
				
		            	dos.writeInt(this.WEIGHT);
					
					// double
				
		            	dos.writeDouble(this.OCTANE);
					
					// double
				
		            	dos.writeDouble(this.RVP);
					
					// double
				
		            	dos.writeDouble(this.COEFFICIENT_EXPANSION);
					
					// double
				
		            	dos.writeDouble(this.OXYGEN);
					
					// double
				
		            	dos.writeDouble(this.SPECIFIC_GRAVITY);
					
					// String
				
						writeString(this.LAST_USER_NAME,dos);
					
					// java.util.Date
				
						writeDate(this.LAST_MODIFIED,dos);
					
					// java.util.Date
				
						writeDate(this.START_DATE,dos);
					
					// java.util.Date
				
						writeDate(this.END_DATE,dos);
					
					// double
				
		            	dos.writeDouble(this.PRESSURE);
					
					// double
				
		            	dos.writeDouble(this.FLOW_RATE);
					
					// double
				
		            	dos.writeDouble(this.AVERAGE_METER_FACTOR);
					
					// double
				
		            	dos.writeDouble(this.VCF);
					
					// double
				
		            	dos.writeDouble(this.PCF);
					
					// double
				
		            	dos.writeDouble(this.OBSERVED_DENSITY);
					
					// int
				
		            	dos.writeInt(this.INVENTORY_QUANTITY_TYPE);
					
					// double
				
		            	dos.writeDouble(this.MEASURED_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.BSW_PERCENT);
					
					// int
				
		            	dos.writeInt(this.WATER_VOLUME);
					
					// int
				
		            	dos.writeInt(this.WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.GROSS_FRAC_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.NET_FRAC_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.LEVEL_CHANGE);
					
					// int
				
		            	dos.writeInt(this.FRAC_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.FRAC_WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.DIRECTION);
					
					// int
				
		            	dos.writeInt(this.DECLARED_GROSS_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.DECLARED_GROSS_FRAC_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.DECLARED_NET_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.DECLARED_NET_FRAC_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.DECLARED_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.DECLARED_FRAC_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.DECLARED_WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.MEASURED_QUANTITY_TYPE);
					
					// int
				
		            	dos.writeInt(this.DERIVED_VALUES_DIRECTIVE);
					
					// int
				
		            	dos.writeInt(this.DECLARED_FRAC_WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.CALCULATE_NET);
					
					// Integer
				
						writeInteger(this.CONTAINER_OWNER_ID,dos);
					
					// int
				
		            	dos.writeInt(this.AFFECT_ACCOUNTING);
					
					// Integer
				
						writeInteger(this.SUPPLIER_PRODUCT_SUPPLIER,dos);
					
					// Integer
				
						writeInteger(this.SUPPLIER_PRODUCT_NUMBER,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.BULK_MOVEMENT_ID);
					
					// int
				
		            	dos.writeInt(this.BULK_PRODUCT_ID);
					
					// int
				
		            	dos.writeInt(this.TERMINAL_PRODUCT_NUMBER);
					
					// String
				
						writeString(this.MEASUREMENT_DEVICE_PARENT_CODE,dos);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_NUMBER,dos);
					
					// String
				
						writeString(this.MEASUREMENT_DEVICE_CODE,dos);
					
					// String
				
						writeString(this.USER_INTERFACE_CODE,dos);
					
					// Integer
				
						writeInteger(this.MEASUREMENT_DEVICE_TYPE,dos);
					
					// String
				
						writeString(this.SNAPSHOT_TANK_CODE,dos);
					
					// String
				
						writeString(this.CONTAINER_CODE,dos);
					
					// Integer
				
						writeInteger(this.CONTAINER_TYPE,dos);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_OWNER_ID,dos);
					
					// String
				
						writeString(this.COMPARTMENT_CONTAINER_CODE,dos);
					
					// Integer
				
						writeInteger(this.SNAPSHOT_TYPE,dos);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_CONTAINER_TYPE,dos);
					
					// int
				
		            	dos.writeInt(this.FIGURES_TYPE);
					
					// String
				
						writeString(this.SNAPSHOT_FOLIO_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.SNAPSHOT_SEQUENCE_NUMBER,dos);
					
					// String
				
						writeString(this.FSHOST_SI_PRODUCT_NUMBER,dos);
					
					// String
				
						writeString(this.TSHOST_SI_PRODUCT_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.GROSS_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.NET_QUANTITY);
					
					// double
				
		            	dos.writeDouble(this.DENSITY);
					
					// double
				
		            	dos.writeDouble(this.TEMPERATURE);
					
					// int
				
		            	dos.writeInt(this.WEIGHT);
					
					// double
				
		            	dos.writeDouble(this.OCTANE);
					
					// double
				
		            	dos.writeDouble(this.RVP);
					
					// double
				
		            	dos.writeDouble(this.COEFFICIENT_EXPANSION);
					
					// double
				
		            	dos.writeDouble(this.OXYGEN);
					
					// double
				
		            	dos.writeDouble(this.SPECIFIC_GRAVITY);
					
					// String
				
						writeString(this.LAST_USER_NAME,dos);
					
					// java.util.Date
				
						writeDate(this.LAST_MODIFIED,dos);
					
					// java.util.Date
				
						writeDate(this.START_DATE,dos);
					
					// java.util.Date
				
						writeDate(this.END_DATE,dos);
					
					// double
				
		            	dos.writeDouble(this.PRESSURE);
					
					// double
				
		            	dos.writeDouble(this.FLOW_RATE);
					
					// double
				
		            	dos.writeDouble(this.AVERAGE_METER_FACTOR);
					
					// double
				
		            	dos.writeDouble(this.VCF);
					
					// double
				
		            	dos.writeDouble(this.PCF);
					
					// double
				
		            	dos.writeDouble(this.OBSERVED_DENSITY);
					
					// int
				
		            	dos.writeInt(this.INVENTORY_QUANTITY_TYPE);
					
					// double
				
		            	dos.writeDouble(this.MEASURED_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.BSW_PERCENT);
					
					// int
				
		            	dos.writeInt(this.WATER_VOLUME);
					
					// int
				
		            	dos.writeInt(this.WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.GROSS_FRAC_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.NET_FRAC_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.LEVEL_CHANGE);
					
					// int
				
		            	dos.writeInt(this.FRAC_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.FRAC_WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.DIRECTION);
					
					// int
				
		            	dos.writeInt(this.DECLARED_GROSS_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.DECLARED_GROSS_FRAC_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.DECLARED_NET_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.DECLARED_NET_FRAC_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.DECLARED_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.DECLARED_FRAC_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.DECLARED_WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.MEASURED_QUANTITY_TYPE);
					
					// int
				
		            	dos.writeInt(this.DERIVED_VALUES_DIRECTIVE);
					
					// int
				
		            	dos.writeInt(this.DECLARED_FRAC_WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.CALCULATE_NET);
					
					// Integer
				
						writeInteger(this.CONTAINER_OWNER_ID,dos);
					
					// int
				
		            	dos.writeInt(this.AFFECT_ACCOUNTING);
					
					// Integer
				
						writeInteger(this.SUPPLIER_PRODUCT_SUPPLIER,dos);
					
					// Integer
				
						writeInteger(this.SUPPLIER_PRODUCT_NUMBER,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("BULK_MOVEMENT_ID="+String.valueOf(BULK_MOVEMENT_ID));
		sb.append(",BULK_PRODUCT_ID="+String.valueOf(BULK_PRODUCT_ID));
		sb.append(",TERMINAL_PRODUCT_NUMBER="+String.valueOf(TERMINAL_PRODUCT_NUMBER));
		sb.append(",MEASUREMENT_DEVICE_PARENT_CODE="+MEASUREMENT_DEVICE_PARENT_CODE);
		sb.append(",COMPARTMENT_NUMBER="+String.valueOf(COMPARTMENT_NUMBER));
		sb.append(",MEASUREMENT_DEVICE_CODE="+MEASUREMENT_DEVICE_CODE);
		sb.append(",USER_INTERFACE_CODE="+USER_INTERFACE_CODE);
		sb.append(",MEASUREMENT_DEVICE_TYPE="+String.valueOf(MEASUREMENT_DEVICE_TYPE));
		sb.append(",SNAPSHOT_TANK_CODE="+SNAPSHOT_TANK_CODE);
		sb.append(",CONTAINER_CODE="+CONTAINER_CODE);
		sb.append(",CONTAINER_TYPE="+String.valueOf(CONTAINER_TYPE));
		sb.append(",COMPARTMENT_OWNER_ID="+String.valueOf(COMPARTMENT_OWNER_ID));
		sb.append(",COMPARTMENT_CONTAINER_CODE="+COMPARTMENT_CONTAINER_CODE);
		sb.append(",SNAPSHOT_TYPE="+String.valueOf(SNAPSHOT_TYPE));
		sb.append(",COMPARTMENT_CONTAINER_TYPE="+String.valueOf(COMPARTMENT_CONTAINER_TYPE));
		sb.append(",FIGURES_TYPE="+String.valueOf(FIGURES_TYPE));
		sb.append(",SNAPSHOT_FOLIO_NUMBER="+SNAPSHOT_FOLIO_NUMBER);
		sb.append(",SNAPSHOT_SEQUENCE_NUMBER="+String.valueOf(SNAPSHOT_SEQUENCE_NUMBER));
		sb.append(",FSHOST_SI_PRODUCT_NUMBER="+FSHOST_SI_PRODUCT_NUMBER);
		sb.append(",TSHOST_SI_PRODUCT_NUMBER="+TSHOST_SI_PRODUCT_NUMBER);
		sb.append(",GROSS_QUANTITY="+String.valueOf(GROSS_QUANTITY));
		sb.append(",NET_QUANTITY="+String.valueOf(NET_QUANTITY));
		sb.append(",DENSITY="+String.valueOf(DENSITY));
		sb.append(",TEMPERATURE="+String.valueOf(TEMPERATURE));
		sb.append(",WEIGHT="+String.valueOf(WEIGHT));
		sb.append(",OCTANE="+String.valueOf(OCTANE));
		sb.append(",RVP="+String.valueOf(RVP));
		sb.append(",COEFFICIENT_EXPANSION="+String.valueOf(COEFFICIENT_EXPANSION));
		sb.append(",OXYGEN="+String.valueOf(OXYGEN));
		sb.append(",SPECIFIC_GRAVITY="+String.valueOf(SPECIFIC_GRAVITY));
		sb.append(",LAST_USER_NAME="+LAST_USER_NAME);
		sb.append(",LAST_MODIFIED="+String.valueOf(LAST_MODIFIED));
		sb.append(",START_DATE="+String.valueOf(START_DATE));
		sb.append(",END_DATE="+String.valueOf(END_DATE));
		sb.append(",PRESSURE="+String.valueOf(PRESSURE));
		sb.append(",FLOW_RATE="+String.valueOf(FLOW_RATE));
		sb.append(",AVERAGE_METER_FACTOR="+String.valueOf(AVERAGE_METER_FACTOR));
		sb.append(",VCF="+String.valueOf(VCF));
		sb.append(",PCF="+String.valueOf(PCF));
		sb.append(",OBSERVED_DENSITY="+String.valueOf(OBSERVED_DENSITY));
		sb.append(",INVENTORY_QUANTITY_TYPE="+String.valueOf(INVENTORY_QUANTITY_TYPE));
		sb.append(",MEASURED_DENSITY="+String.valueOf(MEASURED_DENSITY));
		sb.append(",BSW_PERCENT="+String.valueOf(BSW_PERCENT));
		sb.append(",WATER_VOLUME="+String.valueOf(WATER_VOLUME));
		sb.append(",WEIGHT_IN_VAC="+String.valueOf(WEIGHT_IN_VAC));
		sb.append(",GROSS_FRAC_QUANTITY="+String.valueOf(GROSS_FRAC_QUANTITY));
		sb.append(",NET_FRAC_QUANTITY="+String.valueOf(NET_FRAC_QUANTITY));
		sb.append(",LEVEL_CHANGE="+String.valueOf(LEVEL_CHANGE));
		sb.append(",FRAC_WEIGHT="+String.valueOf(FRAC_WEIGHT));
		sb.append(",FRAC_WEIGHT_IN_VAC="+String.valueOf(FRAC_WEIGHT_IN_VAC));
		sb.append(",DIRECTION="+String.valueOf(DIRECTION));
		sb.append(",DECLARED_GROSS_QUANTITY="+String.valueOf(DECLARED_GROSS_QUANTITY));
		sb.append(",DECLARED_GROSS_FRAC_QUANTITY="+String.valueOf(DECLARED_GROSS_FRAC_QUANTITY));
		sb.append(",DECLARED_NET_QUANTITY="+String.valueOf(DECLARED_NET_QUANTITY));
		sb.append(",DECLARED_NET_FRAC_QUANTITY="+String.valueOf(DECLARED_NET_FRAC_QUANTITY));
		sb.append(",DECLARED_WEIGHT="+String.valueOf(DECLARED_WEIGHT));
		sb.append(",DECLARED_FRAC_WEIGHT="+String.valueOf(DECLARED_FRAC_WEIGHT));
		sb.append(",DECLARED_WEIGHT_IN_VAC="+String.valueOf(DECLARED_WEIGHT_IN_VAC));
		sb.append(",MEASURED_QUANTITY_TYPE="+String.valueOf(MEASURED_QUANTITY_TYPE));
		sb.append(",DERIVED_VALUES_DIRECTIVE="+String.valueOf(DERIVED_VALUES_DIRECTIVE));
		sb.append(",DECLARED_FRAC_WEIGHT_IN_VAC="+String.valueOf(DECLARED_FRAC_WEIGHT_IN_VAC));
		sb.append(",CALCULATE_NET="+String.valueOf(CALCULATE_NET));
		sb.append(",CONTAINER_OWNER_ID="+String.valueOf(CONTAINER_OWNER_ID));
		sb.append(",AFFECT_ACCOUNTING="+String.valueOf(AFFECT_ACCOUNTING));
		sb.append(",SUPPLIER_PRODUCT_SUPPLIER="+String.valueOf(SUPPLIER_PRODUCT_SUPPLIER));
		sb.append(",SUPPLIER_PRODUCT_NUMBER="+String.valueOf(SUPPLIER_PRODUCT_NUMBER));
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
    final static byte[] commonByteArrayLock_PGS_STAGE_DIM_BULK_PRODUCT = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_DIM_BULK_PRODUCT = new byte[0];

	
			    public int BULK_MOVEMENT_ID;

				public int getBULK_MOVEMENT_ID () {
					return this.BULK_MOVEMENT_ID;
				}
				
			    public int BULK_PRODUCT_ID;

				public int getBULK_PRODUCT_ID () {
					return this.BULK_PRODUCT_ID;
				}
				
			    public int TERMINAL_PRODUCT_NUMBER;

				public int getTERMINAL_PRODUCT_NUMBER () {
					return this.TERMINAL_PRODUCT_NUMBER;
				}
				
			    public String MEASUREMENT_DEVICE_PARENT_CODE;

				public String getMEASUREMENT_DEVICE_PARENT_CODE () {
					return this.MEASUREMENT_DEVICE_PARENT_CODE;
				}
				
			    public Integer COMPARTMENT_NUMBER;

				public Integer getCOMPARTMENT_NUMBER () {
					return this.COMPARTMENT_NUMBER;
				}
				
			    public String MEASUREMENT_DEVICE_CODE;

				public String getMEASUREMENT_DEVICE_CODE () {
					return this.MEASUREMENT_DEVICE_CODE;
				}
				
			    public String USER_INTERFACE_CODE;

				public String getUSER_INTERFACE_CODE () {
					return this.USER_INTERFACE_CODE;
				}
				
			    public Integer MEASUREMENT_DEVICE_TYPE;

				public Integer getMEASUREMENT_DEVICE_TYPE () {
					return this.MEASUREMENT_DEVICE_TYPE;
				}
				
			    public String SNAPSHOT_TANK_CODE;

				public String getSNAPSHOT_TANK_CODE () {
					return this.SNAPSHOT_TANK_CODE;
				}
				
			    public String CONTAINER_CODE;

				public String getCONTAINER_CODE () {
					return this.CONTAINER_CODE;
				}
				
			    public Integer CONTAINER_TYPE;

				public Integer getCONTAINER_TYPE () {
					return this.CONTAINER_TYPE;
				}
				
			    public Integer COMPARTMENT_OWNER_ID;

				public Integer getCOMPARTMENT_OWNER_ID () {
					return this.COMPARTMENT_OWNER_ID;
				}
				
			    public String COMPARTMENT_CONTAINER_CODE;

				public String getCOMPARTMENT_CONTAINER_CODE () {
					return this.COMPARTMENT_CONTAINER_CODE;
				}
				
			    public Integer SNAPSHOT_TYPE;

				public Integer getSNAPSHOT_TYPE () {
					return this.SNAPSHOT_TYPE;
				}
				
			    public Integer COMPARTMENT_CONTAINER_TYPE;

				public Integer getCOMPARTMENT_CONTAINER_TYPE () {
					return this.COMPARTMENT_CONTAINER_TYPE;
				}
				
			    public int FIGURES_TYPE;

				public int getFIGURES_TYPE () {
					return this.FIGURES_TYPE;
				}
				
			    public String SNAPSHOT_FOLIO_NUMBER;

				public String getSNAPSHOT_FOLIO_NUMBER () {
					return this.SNAPSHOT_FOLIO_NUMBER;
				}
				
			    public Integer SNAPSHOT_SEQUENCE_NUMBER;

				public Integer getSNAPSHOT_SEQUENCE_NUMBER () {
					return this.SNAPSHOT_SEQUENCE_NUMBER;
				}
				
			    public String FSHOST_SI_PRODUCT_NUMBER;

				public String getFSHOST_SI_PRODUCT_NUMBER () {
					return this.FSHOST_SI_PRODUCT_NUMBER;
				}
				
			    public String TSHOST_SI_PRODUCT_NUMBER;

				public String getTSHOST_SI_PRODUCT_NUMBER () {
					return this.TSHOST_SI_PRODUCT_NUMBER;
				}
				
			    public int GROSS_QUANTITY;

				public int getGROSS_QUANTITY () {
					return this.GROSS_QUANTITY;
				}
				
			    public int NET_QUANTITY;

				public int getNET_QUANTITY () {
					return this.NET_QUANTITY;
				}
				
			    public double DENSITY;

				public double getDENSITY () {
					return this.DENSITY;
				}
				
			    public double TEMPERATURE;

				public double getTEMPERATURE () {
					return this.TEMPERATURE;
				}
				
			    public int WEIGHT;

				public int getWEIGHT () {
					return this.WEIGHT;
				}
				
			    public double OCTANE;

				public double getOCTANE () {
					return this.OCTANE;
				}
				
			    public double RVP;

				public double getRVP () {
					return this.RVP;
				}
				
			    public double COEFFICIENT_EXPANSION;

				public double getCOEFFICIENT_EXPANSION () {
					return this.COEFFICIENT_EXPANSION;
				}
				
			    public double OXYGEN;

				public double getOXYGEN () {
					return this.OXYGEN;
				}
				
			    public double SPECIFIC_GRAVITY;

				public double getSPECIFIC_GRAVITY () {
					return this.SPECIFIC_GRAVITY;
				}
				
			    public String LAST_USER_NAME;

				public String getLAST_USER_NAME () {
					return this.LAST_USER_NAME;
				}
				
			    public java.util.Date LAST_MODIFIED;

				public java.util.Date getLAST_MODIFIED () {
					return this.LAST_MODIFIED;
				}
				
			    public java.util.Date START_DATE;

				public java.util.Date getSTART_DATE () {
					return this.START_DATE;
				}
				
			    public java.util.Date END_DATE;

				public java.util.Date getEND_DATE () {
					return this.END_DATE;
				}
				
			    public double PRESSURE;

				public double getPRESSURE () {
					return this.PRESSURE;
				}
				
			    public double FLOW_RATE;

				public double getFLOW_RATE () {
					return this.FLOW_RATE;
				}
				
			    public double AVERAGE_METER_FACTOR;

				public double getAVERAGE_METER_FACTOR () {
					return this.AVERAGE_METER_FACTOR;
				}
				
			    public double VCF;

				public double getVCF () {
					return this.VCF;
				}
				
			    public double PCF;

				public double getPCF () {
					return this.PCF;
				}
				
			    public double OBSERVED_DENSITY;

				public double getOBSERVED_DENSITY () {
					return this.OBSERVED_DENSITY;
				}
				
			    public int INVENTORY_QUANTITY_TYPE;

				public int getINVENTORY_QUANTITY_TYPE () {
					return this.INVENTORY_QUANTITY_TYPE;
				}
				
			    public double MEASURED_DENSITY;

				public double getMEASURED_DENSITY () {
					return this.MEASURED_DENSITY;
				}
				
			    public double BSW_PERCENT;

				public double getBSW_PERCENT () {
					return this.BSW_PERCENT;
				}
				
			    public int WATER_VOLUME;

				public int getWATER_VOLUME () {
					return this.WATER_VOLUME;
				}
				
			    public int WEIGHT_IN_VAC;

				public int getWEIGHT_IN_VAC () {
					return this.WEIGHT_IN_VAC;
				}
				
			    public int GROSS_FRAC_QUANTITY;

				public int getGROSS_FRAC_QUANTITY () {
					return this.GROSS_FRAC_QUANTITY;
				}
				
			    public int NET_FRAC_QUANTITY;

				public int getNET_FRAC_QUANTITY () {
					return this.NET_FRAC_QUANTITY;
				}
				
			    public int LEVEL_CHANGE;

				public int getLEVEL_CHANGE () {
					return this.LEVEL_CHANGE;
				}
				
			    public int FRAC_WEIGHT;

				public int getFRAC_WEIGHT () {
					return this.FRAC_WEIGHT;
				}
				
			    public int FRAC_WEIGHT_IN_VAC;

				public int getFRAC_WEIGHT_IN_VAC () {
					return this.FRAC_WEIGHT_IN_VAC;
				}
				
			    public int DIRECTION;

				public int getDIRECTION () {
					return this.DIRECTION;
				}
				
			    public int DECLARED_GROSS_QUANTITY;

				public int getDECLARED_GROSS_QUANTITY () {
					return this.DECLARED_GROSS_QUANTITY;
				}
				
			    public int DECLARED_GROSS_FRAC_QUANTITY;

				public int getDECLARED_GROSS_FRAC_QUANTITY () {
					return this.DECLARED_GROSS_FRAC_QUANTITY;
				}
				
			    public int DECLARED_NET_QUANTITY;

				public int getDECLARED_NET_QUANTITY () {
					return this.DECLARED_NET_QUANTITY;
				}
				
			    public int DECLARED_NET_FRAC_QUANTITY;

				public int getDECLARED_NET_FRAC_QUANTITY () {
					return this.DECLARED_NET_FRAC_QUANTITY;
				}
				
			    public int DECLARED_WEIGHT;

				public int getDECLARED_WEIGHT () {
					return this.DECLARED_WEIGHT;
				}
				
			    public int DECLARED_FRAC_WEIGHT;

				public int getDECLARED_FRAC_WEIGHT () {
					return this.DECLARED_FRAC_WEIGHT;
				}
				
			    public int DECLARED_WEIGHT_IN_VAC;

				public int getDECLARED_WEIGHT_IN_VAC () {
					return this.DECLARED_WEIGHT_IN_VAC;
				}
				
			    public int MEASURED_QUANTITY_TYPE;

				public int getMEASURED_QUANTITY_TYPE () {
					return this.MEASURED_QUANTITY_TYPE;
				}
				
			    public int DERIVED_VALUES_DIRECTIVE;

				public int getDERIVED_VALUES_DIRECTIVE () {
					return this.DERIVED_VALUES_DIRECTIVE;
				}
				
			    public int DECLARED_FRAC_WEIGHT_IN_VAC;

				public int getDECLARED_FRAC_WEIGHT_IN_VAC () {
					return this.DECLARED_FRAC_WEIGHT_IN_VAC;
				}
				
			    public int CALCULATE_NET;

				public int getCALCULATE_NET () {
					return this.CALCULATE_NET;
				}
				
			    public Integer CONTAINER_OWNER_ID;

				public Integer getCONTAINER_OWNER_ID () {
					return this.CONTAINER_OWNER_ID;
				}
				
			    public int AFFECT_ACCOUNTING;

				public int getAFFECT_ACCOUNTING () {
					return this.AFFECT_ACCOUNTING;
				}
				
			    public Integer SUPPLIER_PRODUCT_SUPPLIER;

				public Integer getSUPPLIER_PRODUCT_SUPPLIER () {
					return this.SUPPLIER_PRODUCT_SUPPLIER;
				}
				
			    public Integer SUPPLIER_PRODUCT_NUMBER;

				public Integer getSUPPLIER_PRODUCT_NUMBER () {
					return this.SUPPLIER_PRODUCT_NUMBER;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PGS_STAGE_DIM_BULK_PRODUCT.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_BULK_PRODUCT.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_BULK_PRODUCT = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_BULK_PRODUCT = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PGS_STAGE_DIM_BULK_PRODUCT, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_BULK_PRODUCT, 0, length, utf8Charset);
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
			if(length > commonByteArray_PGS_STAGE_DIM_BULK_PRODUCT.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_BULK_PRODUCT.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_BULK_PRODUCT = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_BULK_PRODUCT = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PGS_STAGE_DIM_BULK_PRODUCT, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_BULK_PRODUCT, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_BULK_PRODUCT) {

        	try {

        		int length = 0;
		
			        this.BULK_MOVEMENT_ID = dis.readInt();
					
			        this.BULK_PRODUCT_ID = dis.readInt();
					
			        this.TERMINAL_PRODUCT_NUMBER = dis.readInt();
					
					this.MEASUREMENT_DEVICE_PARENT_CODE = readString(dis);
					
						this.COMPARTMENT_NUMBER = readInteger(dis);
					
					this.MEASUREMENT_DEVICE_CODE = readString(dis);
					
					this.USER_INTERFACE_CODE = readString(dis);
					
						this.MEASUREMENT_DEVICE_TYPE = readInteger(dis);
					
					this.SNAPSHOT_TANK_CODE = readString(dis);
					
					this.CONTAINER_CODE = readString(dis);
					
						this.CONTAINER_TYPE = readInteger(dis);
					
						this.COMPARTMENT_OWNER_ID = readInteger(dis);
					
					this.COMPARTMENT_CONTAINER_CODE = readString(dis);
					
						this.SNAPSHOT_TYPE = readInteger(dis);
					
						this.COMPARTMENT_CONTAINER_TYPE = readInteger(dis);
					
			        this.FIGURES_TYPE = dis.readInt();
					
					this.SNAPSHOT_FOLIO_NUMBER = readString(dis);
					
						this.SNAPSHOT_SEQUENCE_NUMBER = readInteger(dis);
					
					this.FSHOST_SI_PRODUCT_NUMBER = readString(dis);
					
					this.TSHOST_SI_PRODUCT_NUMBER = readString(dis);
					
			        this.GROSS_QUANTITY = dis.readInt();
					
			        this.NET_QUANTITY = dis.readInt();
					
			        this.DENSITY = dis.readDouble();
					
			        this.TEMPERATURE = dis.readDouble();
					
			        this.WEIGHT = dis.readInt();
					
			        this.OCTANE = dis.readDouble();
					
			        this.RVP = dis.readDouble();
					
			        this.COEFFICIENT_EXPANSION = dis.readDouble();
					
			        this.OXYGEN = dis.readDouble();
					
			        this.SPECIFIC_GRAVITY = dis.readDouble();
					
					this.LAST_USER_NAME = readString(dis);
					
					this.LAST_MODIFIED = readDate(dis);
					
					this.START_DATE = readDate(dis);
					
					this.END_DATE = readDate(dis);
					
			        this.PRESSURE = dis.readDouble();
					
			        this.FLOW_RATE = dis.readDouble();
					
			        this.AVERAGE_METER_FACTOR = dis.readDouble();
					
			        this.VCF = dis.readDouble();
					
			        this.PCF = dis.readDouble();
					
			        this.OBSERVED_DENSITY = dis.readDouble();
					
			        this.INVENTORY_QUANTITY_TYPE = dis.readInt();
					
			        this.MEASURED_DENSITY = dis.readDouble();
					
			        this.BSW_PERCENT = dis.readDouble();
					
			        this.WATER_VOLUME = dis.readInt();
					
			        this.WEIGHT_IN_VAC = dis.readInt();
					
			        this.GROSS_FRAC_QUANTITY = dis.readInt();
					
			        this.NET_FRAC_QUANTITY = dis.readInt();
					
			        this.LEVEL_CHANGE = dis.readInt();
					
			        this.FRAC_WEIGHT = dis.readInt();
					
			        this.FRAC_WEIGHT_IN_VAC = dis.readInt();
					
			        this.DIRECTION = dis.readInt();
					
			        this.DECLARED_GROSS_QUANTITY = dis.readInt();
					
			        this.DECLARED_GROSS_FRAC_QUANTITY = dis.readInt();
					
			        this.DECLARED_NET_QUANTITY = dis.readInt();
					
			        this.DECLARED_NET_FRAC_QUANTITY = dis.readInt();
					
			        this.DECLARED_WEIGHT = dis.readInt();
					
			        this.DECLARED_FRAC_WEIGHT = dis.readInt();
					
			        this.DECLARED_WEIGHT_IN_VAC = dis.readInt();
					
			        this.MEASURED_QUANTITY_TYPE = dis.readInt();
					
			        this.DERIVED_VALUES_DIRECTIVE = dis.readInt();
					
			        this.DECLARED_FRAC_WEIGHT_IN_VAC = dis.readInt();
					
			        this.CALCULATE_NET = dis.readInt();
					
						this.CONTAINER_OWNER_ID = readInteger(dis);
					
			        this.AFFECT_ACCOUNTING = dis.readInt();
					
						this.SUPPLIER_PRODUCT_SUPPLIER = readInteger(dis);
					
						this.SUPPLIER_PRODUCT_NUMBER = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_BULK_PRODUCT) {

        	try {

        		int length = 0;
		
			        this.BULK_MOVEMENT_ID = dis.readInt();
					
			        this.BULK_PRODUCT_ID = dis.readInt();
					
			        this.TERMINAL_PRODUCT_NUMBER = dis.readInt();
					
					this.MEASUREMENT_DEVICE_PARENT_CODE = readString(dis);
					
						this.COMPARTMENT_NUMBER = readInteger(dis);
					
					this.MEASUREMENT_DEVICE_CODE = readString(dis);
					
					this.USER_INTERFACE_CODE = readString(dis);
					
						this.MEASUREMENT_DEVICE_TYPE = readInteger(dis);
					
					this.SNAPSHOT_TANK_CODE = readString(dis);
					
					this.CONTAINER_CODE = readString(dis);
					
						this.CONTAINER_TYPE = readInteger(dis);
					
						this.COMPARTMENT_OWNER_ID = readInteger(dis);
					
					this.COMPARTMENT_CONTAINER_CODE = readString(dis);
					
						this.SNAPSHOT_TYPE = readInteger(dis);
					
						this.COMPARTMENT_CONTAINER_TYPE = readInteger(dis);
					
			        this.FIGURES_TYPE = dis.readInt();
					
					this.SNAPSHOT_FOLIO_NUMBER = readString(dis);
					
						this.SNAPSHOT_SEQUENCE_NUMBER = readInteger(dis);
					
					this.FSHOST_SI_PRODUCT_NUMBER = readString(dis);
					
					this.TSHOST_SI_PRODUCT_NUMBER = readString(dis);
					
			        this.GROSS_QUANTITY = dis.readInt();
					
			        this.NET_QUANTITY = dis.readInt();
					
			        this.DENSITY = dis.readDouble();
					
			        this.TEMPERATURE = dis.readDouble();
					
			        this.WEIGHT = dis.readInt();
					
			        this.OCTANE = dis.readDouble();
					
			        this.RVP = dis.readDouble();
					
			        this.COEFFICIENT_EXPANSION = dis.readDouble();
					
			        this.OXYGEN = dis.readDouble();
					
			        this.SPECIFIC_GRAVITY = dis.readDouble();
					
					this.LAST_USER_NAME = readString(dis);
					
					this.LAST_MODIFIED = readDate(dis);
					
					this.START_DATE = readDate(dis);
					
					this.END_DATE = readDate(dis);
					
			        this.PRESSURE = dis.readDouble();
					
			        this.FLOW_RATE = dis.readDouble();
					
			        this.AVERAGE_METER_FACTOR = dis.readDouble();
					
			        this.VCF = dis.readDouble();
					
			        this.PCF = dis.readDouble();
					
			        this.OBSERVED_DENSITY = dis.readDouble();
					
			        this.INVENTORY_QUANTITY_TYPE = dis.readInt();
					
			        this.MEASURED_DENSITY = dis.readDouble();
					
			        this.BSW_PERCENT = dis.readDouble();
					
			        this.WATER_VOLUME = dis.readInt();
					
			        this.WEIGHT_IN_VAC = dis.readInt();
					
			        this.GROSS_FRAC_QUANTITY = dis.readInt();
					
			        this.NET_FRAC_QUANTITY = dis.readInt();
					
			        this.LEVEL_CHANGE = dis.readInt();
					
			        this.FRAC_WEIGHT = dis.readInt();
					
			        this.FRAC_WEIGHT_IN_VAC = dis.readInt();
					
			        this.DIRECTION = dis.readInt();
					
			        this.DECLARED_GROSS_QUANTITY = dis.readInt();
					
			        this.DECLARED_GROSS_FRAC_QUANTITY = dis.readInt();
					
			        this.DECLARED_NET_QUANTITY = dis.readInt();
					
			        this.DECLARED_NET_FRAC_QUANTITY = dis.readInt();
					
			        this.DECLARED_WEIGHT = dis.readInt();
					
			        this.DECLARED_FRAC_WEIGHT = dis.readInt();
					
			        this.DECLARED_WEIGHT_IN_VAC = dis.readInt();
					
			        this.MEASURED_QUANTITY_TYPE = dis.readInt();
					
			        this.DERIVED_VALUES_DIRECTIVE = dis.readInt();
					
			        this.DECLARED_FRAC_WEIGHT_IN_VAC = dis.readInt();
					
			        this.CALCULATE_NET = dis.readInt();
					
						this.CONTAINER_OWNER_ID = readInteger(dis);
					
			        this.AFFECT_ACCOUNTING = dis.readInt();
					
						this.SUPPLIER_PRODUCT_SUPPLIER = readInteger(dis);
					
						this.SUPPLIER_PRODUCT_NUMBER = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.BULK_MOVEMENT_ID);
					
					// int
				
		            	dos.writeInt(this.BULK_PRODUCT_ID);
					
					// int
				
		            	dos.writeInt(this.TERMINAL_PRODUCT_NUMBER);
					
					// String
				
						writeString(this.MEASUREMENT_DEVICE_PARENT_CODE,dos);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_NUMBER,dos);
					
					// String
				
						writeString(this.MEASUREMENT_DEVICE_CODE,dos);
					
					// String
				
						writeString(this.USER_INTERFACE_CODE,dos);
					
					// Integer
				
						writeInteger(this.MEASUREMENT_DEVICE_TYPE,dos);
					
					// String
				
						writeString(this.SNAPSHOT_TANK_CODE,dos);
					
					// String
				
						writeString(this.CONTAINER_CODE,dos);
					
					// Integer
				
						writeInteger(this.CONTAINER_TYPE,dos);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_OWNER_ID,dos);
					
					// String
				
						writeString(this.COMPARTMENT_CONTAINER_CODE,dos);
					
					// Integer
				
						writeInteger(this.SNAPSHOT_TYPE,dos);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_CONTAINER_TYPE,dos);
					
					// int
				
		            	dos.writeInt(this.FIGURES_TYPE);
					
					// String
				
						writeString(this.SNAPSHOT_FOLIO_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.SNAPSHOT_SEQUENCE_NUMBER,dos);
					
					// String
				
						writeString(this.FSHOST_SI_PRODUCT_NUMBER,dos);
					
					// String
				
						writeString(this.TSHOST_SI_PRODUCT_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.GROSS_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.NET_QUANTITY);
					
					// double
				
		            	dos.writeDouble(this.DENSITY);
					
					// double
				
		            	dos.writeDouble(this.TEMPERATURE);
					
					// int
				
		            	dos.writeInt(this.WEIGHT);
					
					// double
				
		            	dos.writeDouble(this.OCTANE);
					
					// double
				
		            	dos.writeDouble(this.RVP);
					
					// double
				
		            	dos.writeDouble(this.COEFFICIENT_EXPANSION);
					
					// double
				
		            	dos.writeDouble(this.OXYGEN);
					
					// double
				
		            	dos.writeDouble(this.SPECIFIC_GRAVITY);
					
					// String
				
						writeString(this.LAST_USER_NAME,dos);
					
					// java.util.Date
				
						writeDate(this.LAST_MODIFIED,dos);
					
					// java.util.Date
				
						writeDate(this.START_DATE,dos);
					
					// java.util.Date
				
						writeDate(this.END_DATE,dos);
					
					// double
				
		            	dos.writeDouble(this.PRESSURE);
					
					// double
				
		            	dos.writeDouble(this.FLOW_RATE);
					
					// double
				
		            	dos.writeDouble(this.AVERAGE_METER_FACTOR);
					
					// double
				
		            	dos.writeDouble(this.VCF);
					
					// double
				
		            	dos.writeDouble(this.PCF);
					
					// double
				
		            	dos.writeDouble(this.OBSERVED_DENSITY);
					
					// int
				
		            	dos.writeInt(this.INVENTORY_QUANTITY_TYPE);
					
					// double
				
		            	dos.writeDouble(this.MEASURED_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.BSW_PERCENT);
					
					// int
				
		            	dos.writeInt(this.WATER_VOLUME);
					
					// int
				
		            	dos.writeInt(this.WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.GROSS_FRAC_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.NET_FRAC_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.LEVEL_CHANGE);
					
					// int
				
		            	dos.writeInt(this.FRAC_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.FRAC_WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.DIRECTION);
					
					// int
				
		            	dos.writeInt(this.DECLARED_GROSS_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.DECLARED_GROSS_FRAC_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.DECLARED_NET_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.DECLARED_NET_FRAC_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.DECLARED_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.DECLARED_FRAC_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.DECLARED_WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.MEASURED_QUANTITY_TYPE);
					
					// int
				
		            	dos.writeInt(this.DERIVED_VALUES_DIRECTIVE);
					
					// int
				
		            	dos.writeInt(this.DECLARED_FRAC_WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.CALCULATE_NET);
					
					// Integer
				
						writeInteger(this.CONTAINER_OWNER_ID,dos);
					
					// int
				
		            	dos.writeInt(this.AFFECT_ACCOUNTING);
					
					// Integer
				
						writeInteger(this.SUPPLIER_PRODUCT_SUPPLIER,dos);
					
					// Integer
				
						writeInteger(this.SUPPLIER_PRODUCT_NUMBER,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.BULK_MOVEMENT_ID);
					
					// int
				
		            	dos.writeInt(this.BULK_PRODUCT_ID);
					
					// int
				
		            	dos.writeInt(this.TERMINAL_PRODUCT_NUMBER);
					
					// String
				
						writeString(this.MEASUREMENT_DEVICE_PARENT_CODE,dos);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_NUMBER,dos);
					
					// String
				
						writeString(this.MEASUREMENT_DEVICE_CODE,dos);
					
					// String
				
						writeString(this.USER_INTERFACE_CODE,dos);
					
					// Integer
				
						writeInteger(this.MEASUREMENT_DEVICE_TYPE,dos);
					
					// String
				
						writeString(this.SNAPSHOT_TANK_CODE,dos);
					
					// String
				
						writeString(this.CONTAINER_CODE,dos);
					
					// Integer
				
						writeInteger(this.CONTAINER_TYPE,dos);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_OWNER_ID,dos);
					
					// String
				
						writeString(this.COMPARTMENT_CONTAINER_CODE,dos);
					
					// Integer
				
						writeInteger(this.SNAPSHOT_TYPE,dos);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_CONTAINER_TYPE,dos);
					
					// int
				
		            	dos.writeInt(this.FIGURES_TYPE);
					
					// String
				
						writeString(this.SNAPSHOT_FOLIO_NUMBER,dos);
					
					// Integer
				
						writeInteger(this.SNAPSHOT_SEQUENCE_NUMBER,dos);
					
					// String
				
						writeString(this.FSHOST_SI_PRODUCT_NUMBER,dos);
					
					// String
				
						writeString(this.TSHOST_SI_PRODUCT_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.GROSS_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.NET_QUANTITY);
					
					// double
				
		            	dos.writeDouble(this.DENSITY);
					
					// double
				
		            	dos.writeDouble(this.TEMPERATURE);
					
					// int
				
		            	dos.writeInt(this.WEIGHT);
					
					// double
				
		            	dos.writeDouble(this.OCTANE);
					
					// double
				
		            	dos.writeDouble(this.RVP);
					
					// double
				
		            	dos.writeDouble(this.COEFFICIENT_EXPANSION);
					
					// double
				
		            	dos.writeDouble(this.OXYGEN);
					
					// double
				
		            	dos.writeDouble(this.SPECIFIC_GRAVITY);
					
					// String
				
						writeString(this.LAST_USER_NAME,dos);
					
					// java.util.Date
				
						writeDate(this.LAST_MODIFIED,dos);
					
					// java.util.Date
				
						writeDate(this.START_DATE,dos);
					
					// java.util.Date
				
						writeDate(this.END_DATE,dos);
					
					// double
				
		            	dos.writeDouble(this.PRESSURE);
					
					// double
				
		            	dos.writeDouble(this.FLOW_RATE);
					
					// double
				
		            	dos.writeDouble(this.AVERAGE_METER_FACTOR);
					
					// double
				
		            	dos.writeDouble(this.VCF);
					
					// double
				
		            	dos.writeDouble(this.PCF);
					
					// double
				
		            	dos.writeDouble(this.OBSERVED_DENSITY);
					
					// int
				
		            	dos.writeInt(this.INVENTORY_QUANTITY_TYPE);
					
					// double
				
		            	dos.writeDouble(this.MEASURED_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.BSW_PERCENT);
					
					// int
				
		            	dos.writeInt(this.WATER_VOLUME);
					
					// int
				
		            	dos.writeInt(this.WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.GROSS_FRAC_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.NET_FRAC_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.LEVEL_CHANGE);
					
					// int
				
		            	dos.writeInt(this.FRAC_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.FRAC_WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.DIRECTION);
					
					// int
				
		            	dos.writeInt(this.DECLARED_GROSS_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.DECLARED_GROSS_FRAC_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.DECLARED_NET_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.DECLARED_NET_FRAC_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.DECLARED_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.DECLARED_FRAC_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.DECLARED_WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.MEASURED_QUANTITY_TYPE);
					
					// int
				
		            	dos.writeInt(this.DERIVED_VALUES_DIRECTIVE);
					
					// int
				
		            	dos.writeInt(this.DECLARED_FRAC_WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.CALCULATE_NET);
					
					// Integer
				
						writeInteger(this.CONTAINER_OWNER_ID,dos);
					
					// int
				
		            	dos.writeInt(this.AFFECT_ACCOUNTING);
					
					// Integer
				
						writeInteger(this.SUPPLIER_PRODUCT_SUPPLIER,dos);
					
					// Integer
				
						writeInteger(this.SUPPLIER_PRODUCT_NUMBER,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("BULK_MOVEMENT_ID="+String.valueOf(BULK_MOVEMENT_ID));
		sb.append(",BULK_PRODUCT_ID="+String.valueOf(BULK_PRODUCT_ID));
		sb.append(",TERMINAL_PRODUCT_NUMBER="+String.valueOf(TERMINAL_PRODUCT_NUMBER));
		sb.append(",MEASUREMENT_DEVICE_PARENT_CODE="+MEASUREMENT_DEVICE_PARENT_CODE);
		sb.append(",COMPARTMENT_NUMBER="+String.valueOf(COMPARTMENT_NUMBER));
		sb.append(",MEASUREMENT_DEVICE_CODE="+MEASUREMENT_DEVICE_CODE);
		sb.append(",USER_INTERFACE_CODE="+USER_INTERFACE_CODE);
		sb.append(",MEASUREMENT_DEVICE_TYPE="+String.valueOf(MEASUREMENT_DEVICE_TYPE));
		sb.append(",SNAPSHOT_TANK_CODE="+SNAPSHOT_TANK_CODE);
		sb.append(",CONTAINER_CODE="+CONTAINER_CODE);
		sb.append(",CONTAINER_TYPE="+String.valueOf(CONTAINER_TYPE));
		sb.append(",COMPARTMENT_OWNER_ID="+String.valueOf(COMPARTMENT_OWNER_ID));
		sb.append(",COMPARTMENT_CONTAINER_CODE="+COMPARTMENT_CONTAINER_CODE);
		sb.append(",SNAPSHOT_TYPE="+String.valueOf(SNAPSHOT_TYPE));
		sb.append(",COMPARTMENT_CONTAINER_TYPE="+String.valueOf(COMPARTMENT_CONTAINER_TYPE));
		sb.append(",FIGURES_TYPE="+String.valueOf(FIGURES_TYPE));
		sb.append(",SNAPSHOT_FOLIO_NUMBER="+SNAPSHOT_FOLIO_NUMBER);
		sb.append(",SNAPSHOT_SEQUENCE_NUMBER="+String.valueOf(SNAPSHOT_SEQUENCE_NUMBER));
		sb.append(",FSHOST_SI_PRODUCT_NUMBER="+FSHOST_SI_PRODUCT_NUMBER);
		sb.append(",TSHOST_SI_PRODUCT_NUMBER="+TSHOST_SI_PRODUCT_NUMBER);
		sb.append(",GROSS_QUANTITY="+String.valueOf(GROSS_QUANTITY));
		sb.append(",NET_QUANTITY="+String.valueOf(NET_QUANTITY));
		sb.append(",DENSITY="+String.valueOf(DENSITY));
		sb.append(",TEMPERATURE="+String.valueOf(TEMPERATURE));
		sb.append(",WEIGHT="+String.valueOf(WEIGHT));
		sb.append(",OCTANE="+String.valueOf(OCTANE));
		sb.append(",RVP="+String.valueOf(RVP));
		sb.append(",COEFFICIENT_EXPANSION="+String.valueOf(COEFFICIENT_EXPANSION));
		sb.append(",OXYGEN="+String.valueOf(OXYGEN));
		sb.append(",SPECIFIC_GRAVITY="+String.valueOf(SPECIFIC_GRAVITY));
		sb.append(",LAST_USER_NAME="+LAST_USER_NAME);
		sb.append(",LAST_MODIFIED="+String.valueOf(LAST_MODIFIED));
		sb.append(",START_DATE="+String.valueOf(START_DATE));
		sb.append(",END_DATE="+String.valueOf(END_DATE));
		sb.append(",PRESSURE="+String.valueOf(PRESSURE));
		sb.append(",FLOW_RATE="+String.valueOf(FLOW_RATE));
		sb.append(",AVERAGE_METER_FACTOR="+String.valueOf(AVERAGE_METER_FACTOR));
		sb.append(",VCF="+String.valueOf(VCF));
		sb.append(",PCF="+String.valueOf(PCF));
		sb.append(",OBSERVED_DENSITY="+String.valueOf(OBSERVED_DENSITY));
		sb.append(",INVENTORY_QUANTITY_TYPE="+String.valueOf(INVENTORY_QUANTITY_TYPE));
		sb.append(",MEASURED_DENSITY="+String.valueOf(MEASURED_DENSITY));
		sb.append(",BSW_PERCENT="+String.valueOf(BSW_PERCENT));
		sb.append(",WATER_VOLUME="+String.valueOf(WATER_VOLUME));
		sb.append(",WEIGHT_IN_VAC="+String.valueOf(WEIGHT_IN_VAC));
		sb.append(",GROSS_FRAC_QUANTITY="+String.valueOf(GROSS_FRAC_QUANTITY));
		sb.append(",NET_FRAC_QUANTITY="+String.valueOf(NET_FRAC_QUANTITY));
		sb.append(",LEVEL_CHANGE="+String.valueOf(LEVEL_CHANGE));
		sb.append(",FRAC_WEIGHT="+String.valueOf(FRAC_WEIGHT));
		sb.append(",FRAC_WEIGHT_IN_VAC="+String.valueOf(FRAC_WEIGHT_IN_VAC));
		sb.append(",DIRECTION="+String.valueOf(DIRECTION));
		sb.append(",DECLARED_GROSS_QUANTITY="+String.valueOf(DECLARED_GROSS_QUANTITY));
		sb.append(",DECLARED_GROSS_FRAC_QUANTITY="+String.valueOf(DECLARED_GROSS_FRAC_QUANTITY));
		sb.append(",DECLARED_NET_QUANTITY="+String.valueOf(DECLARED_NET_QUANTITY));
		sb.append(",DECLARED_NET_FRAC_QUANTITY="+String.valueOf(DECLARED_NET_FRAC_QUANTITY));
		sb.append(",DECLARED_WEIGHT="+String.valueOf(DECLARED_WEIGHT));
		sb.append(",DECLARED_FRAC_WEIGHT="+String.valueOf(DECLARED_FRAC_WEIGHT));
		sb.append(",DECLARED_WEIGHT_IN_VAC="+String.valueOf(DECLARED_WEIGHT_IN_VAC));
		sb.append(",MEASURED_QUANTITY_TYPE="+String.valueOf(MEASURED_QUANTITY_TYPE));
		sb.append(",DERIVED_VALUES_DIRECTIVE="+String.valueOf(DERIVED_VALUES_DIRECTIVE));
		sb.append(",DECLARED_FRAC_WEIGHT_IN_VAC="+String.valueOf(DECLARED_FRAC_WEIGHT_IN_VAC));
		sb.append(",CALCULATE_NET="+String.valueOf(CALCULATE_NET));
		sb.append(",CONTAINER_OWNER_ID="+String.valueOf(CONTAINER_OWNER_ID));
		sb.append(",AFFECT_ACCOUNTING="+String.valueOf(AFFECT_ACCOUNTING));
		sb.append(",SUPPLIER_PRODUCT_SUPPLIER="+String.valueOf(SUPPLIER_PRODUCT_SUPPLIER));
		sb.append(",SUPPLIER_PRODUCT_NUMBER="+String.valueOf(SUPPLIER_PRODUCT_NUMBER));
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
        } else if (updateKeyCount_tDBOutput_1 == 14 && true) {
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

 
	final String decryptedPassword_tDBOutput_1 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:khpo6OnqwlBRKSIT+HyfcTtVcV2hZniZSOrh0lsoJFMZm6ylNxk=");

    String dbPwd_tDBOutput_1 = decryptedPassword_tDBOutput_1;	
    conn_tDBOutput_1 = java.sql.DriverManager.getConnection(url_tDBOutput_1,dbUser_tDBOutput_1,dbPwd_tDBOutput_1);
	
		resourceMap.put("conn_tDBOutput_1", conn_tDBOutput_1);
	
        conn_tDBOutput_1.setAutoCommit(false);
        int commitEvery_tDBOutput_1 = 10000;
        int commitCounter_tDBOutput_1 = 0;


if(dbschema_tDBOutput_1 == null || dbschema_tDBOutput_1.trim().length() == 0) {
    tableName_tDBOutput_1 = "DIM_BULK_PRODUCT";
} else {
    tableName_tDBOutput_1 = dbschema_tDBOutput_1 + "].[" + "DIM_BULK_PRODUCT";
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
                                        stmtCreate_tDBOutput_1.execute("CREATE TABLE [" + tableName_tDBOutput_1 + "]([PK_BULK_PRODUCT] INT ,[BULK_MOVEMENT_ID] INT  not null ,[BULK_PRODUCT_ID] INT  not null ,[TERMINAL_PRODUCT_NUMBER] INT  not null ,[CONTAINER_CODE] VARCHAR(20)  ,[SNAPSHOT_TYPE] INT ,[FIGURES_TYPE] INT  not null ,[LAST_USER_NAME] VARCHAR(10)  ,[LAST_MODIFIED] DATETIME ,[START_DATE] DATETIME ,[END_DATE] DATETIME ,[INVENTORY_QUANTITY_TYPE] INT  not null ,[DIRECTION] INT  not null ,[MEASURED_QUANTITY_TYPE] INT  not null ,primary key([PK_BULK_PRODUCT]))");
                                    }
                                }
        java.sql.PreparedStatement pstmt_tDBOutput_1 = conn_tDBOutput_1.prepareStatement("SELECT COUNT(1) FROM [" + tableName_tDBOutput_1 + "] WHERE [PK_BULK_PRODUCT] = ?");
        resourceMap.put("pstmt_tDBOutput_1", pstmt_tDBOutput_1);
        String insert_tDBOutput_1 = "INSERT INTO [" + tableName_tDBOutput_1 + "] ([PK_BULK_PRODUCT],[BULK_MOVEMENT_ID],[BULK_PRODUCT_ID],[TERMINAL_PRODUCT_NUMBER],[CONTAINER_CODE],[SNAPSHOT_TYPE],[FIGURES_TYPE],[LAST_USER_NAME],[LAST_MODIFIED],[START_DATE],[END_DATE],[INVENTORY_QUANTITY_TYPE],[DIRECTION],[MEASURED_QUANTITY_TYPE]) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        java.sql.PreparedStatement pstmtInsert_tDBOutput_1 = conn_tDBOutput_1.prepareStatement(insert_tDBOutput_1);
        resourceMap.put("pstmtInsert_tDBOutput_1", pstmtInsert_tDBOutput_1);
        String update_tDBOutput_1 = "UPDATE [" + tableName_tDBOutput_1 + "] SET [BULK_MOVEMENT_ID] = ?,[BULK_PRODUCT_ID] = ?,[TERMINAL_PRODUCT_NUMBER] = ?,[CONTAINER_CODE] = ?,[SNAPSHOT_TYPE] = ?,[FIGURES_TYPE] = ?,[LAST_USER_NAME] = ?,[LAST_MODIFIED] = ?,[START_DATE] = ?,[END_DATE] = ?,[INVENTORY_QUANTITY_TYPE] = ?,[DIRECTION] = ?,[MEASURED_QUANTITY_TYPE] = ? WHERE [PK_BULK_PRODUCT] = ?";
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
	int PK_BULK_PRODUCT;
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
	
	        
					int BULK_MOVEMENT_ID;
					int BULK_PRODUCT_ID;
					int TERMINAL_PRODUCT_NUMBER;
					String CONTAINER_CODE;
					int INVENTORY_QUANTITY_TYPE;
					int LEVEL_CHANGE;        
	        
		    @Override
			public int hashCode() {
				if (this.hashCodeDirty) {
					final int prime = PRIME;
					int result = DEFAULT_HASHCODE;
			
									result = prime * result + (int) this.BULK_MOVEMENT_ID;
									
									result = prime * result + (int) this.BULK_PRODUCT_ID;
									
									result = prime * result + (int) this.TERMINAL_PRODUCT_NUMBER;
									
								result = prime * result + ((this.CONTAINER_CODE == null) ? 0 : this.CONTAINER_CODE.hashCode());
								
									result = prime * result + (int) this.INVENTORY_QUANTITY_TYPE;
									
									result = prime * result + (int) this.LEVEL_CHANGE;
									
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
								
									if (this.BULK_PRODUCT_ID != other.BULK_PRODUCT_ID) 
										return false;
								
									if (this.TERMINAL_PRODUCT_NUMBER != other.TERMINAL_PRODUCT_NUMBER) 
										return false;
								
									if (this.CONTAINER_CODE == null) {
										if (other.CONTAINER_CODE != null) 
											return false;
								
									} else if (!this.CONTAINER_CODE.equals(other.CONTAINER_CODE))
								 
										return false;
								
									if (this.INVENTORY_QUANTITY_TYPE != other.INVENTORY_QUANTITY_TYPE) 
										return false;
								
									if (this.LEVEL_CHANGE != other.LEVEL_CHANGE) 
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
				
				 
	final String decryptedPassword_tDBInput_1 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:wYMqG5Npn9x7bW5f7yqrVlhGd5IaCJ8XeMxYE8v5WwYSf574OWU=");
				
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

		    String dbquery_tDBInput_1 = "SELECT dbo.BULK_PRODUCT.BULK_MOVEMENT_ID,\n		dbo.BULK_PRODUCT.BULK_PRODUCT_ID,\n		dbo.BULK_PRODUCT.TERMINAL_PRODUCT_NUMBE"
+"R,\n		dbo.BULK_PRODUCT.MEASUREMENT_DEVICE_PARENT_CODE,\n		dbo.BULK_PRODUCT.COMPARTMENT_NUMBER,\n		dbo.BULK_PRODUCT.MEASUREM"
+"ENT_DEVICE_CODE,\n		dbo.BULK_PRODUCT.USER_INTERFACE_CODE,\n		dbo.BULK_PRODUCT.MEASUREMENT_DEVICE_TYPE,\n		dbo.BULK_PRODUCT."
+"SNAPSHOT_TANK_CODE,\n		dbo.BULK_PRODUCT.CONTAINER_CODE,\n		dbo.BULK_PRODUCT.CONTAINER_TYPE,\n		dbo.BULK_PRODUCT.COMPARTMENT"
+"_OWNER_ID,\n		dbo.BULK_PRODUCT.COMPARTMENT_CONTAINER_CODE,\n		dbo.BULK_PRODUCT.SNAPSHOT_TYPE,\n		dbo.BULK_PRODUCT.COMPARTME"
+"NT_CONTAINER_TYPE,\n		dbo.BULK_PRODUCT.FIGURES_TYPE,\n		dbo.BULK_PRODUCT.SNAPSHOT_FOLIO_NUMBER,\n		dbo.BULK_PRODUCT.SNAPSHO"
+"T_SEQUENCE_NUMBER,\n		dbo.BULK_PRODUCT.FSHOST_SI_PRODUCT_NUMBER,\n		dbo.BULK_PRODUCT.TSHOST_SI_PRODUCT_NUMBER,\n		dbo.BULK_"
+"PRODUCT.GROSS_QUANTITY,\n		dbo.BULK_PRODUCT.NET_QUANTITY,\n		dbo.BULK_PRODUCT.DENSITY,\n		dbo.BULK_PRODUCT.TEMPERATURE,\n		d"
+"bo.BULK_PRODUCT.WEIGHT,\n		dbo.BULK_PRODUCT.OCTANE,\n		dbo.BULK_PRODUCT.RVP,\n		dbo.BULK_PRODUCT.COEFFICIENT_EXPANSION,\n		d"
+"bo.BULK_PRODUCT.OXYGEN,\n		dbo.BULK_PRODUCT.SPECIFIC_GRAVITY,\n		dbo.BULK_PRODUCT.LAST_USER_NAME,\n		dbo.BULK_PRODUCT.LAST_"
+"MODIFIED,\n		dbo.BULK_PRODUCT.START_DATE,\n		dbo.BULK_PRODUCT.END_DATE,\n		dbo.BULK_PRODUCT.PRESSURE,\n		dbo.BULK_PRODUCT.FL"
+"OW_RATE,\n		dbo.BULK_PRODUCT.AVERAGE_METER_FACTOR,\n		dbo.BULK_PRODUCT.VCF,\n		dbo.BULK_PRODUCT.PCF,\n		dbo.BULK_PRODUCT.OBS"
+"ERVED_DENSITY,\n		dbo.BULK_PRODUCT.INVENTORY_QUANTITY_TYPE,\n		dbo.BULK_PRODUCT.MEASURED_DENSITY,\n		dbo.BULK_PRODUCT.BSW_P"
+"ERCENT,\n		dbo.BULK_PRODUCT.WATER_VOLUME,\n		dbo.BULK_PRODUCT.WEIGHT_IN_VAC,\n		dbo.BULK_PRODUCT.GROSS_FRAC_QUANTITY,\n		dbo"
+".BULK_PRODUCT.NET_FRAC_QUANTITY,\n		dbo.BULK_PRODUCT.LEVEL_CHANGE,\n		dbo.BULK_PRODUCT.FRAC_WEIGHT,\n		dbo.BULK_PRODUCT.FRA"
+"C_WEIGHT_IN_VAC,\n		dbo.BULK_PRODUCT.DIRECTION,\n		dbo.BULK_PRODUCT.DECLARED_GROSS_QUANTITY,\n		dbo.BULK_PRODUCT.DECLARED_G"
+"ROSS_FRAC_QUANTITY,\n		dbo.BULK_PRODUCT.DECLARED_NET_QUANTITY,\n		dbo.BULK_PRODUCT.DECLARED_NET_FRAC_QUANTITY,\n		dbo.BULK_"
+"PRODUCT.DECLARED_WEIGHT,\n		dbo.BULK_PRODUCT.DECLARED_FRAC_WEIGHT,\n		dbo.BULK_PRODUCT.DECLARED_WEIGHT_IN_VAC,\n		dbo.BULK_"
+"PRODUCT.MEASURED_QUANTITY_TYPE,\n		dbo.BULK_PRODUCT.DERIVED_VALUES_DIRECTIVE,\n		dbo.BULK_PRODUCT.DECLARED_FRAC_WEIGHT_IN_"
+"VAC,\n		dbo.BULK_PRODUCT.CALCULATE_NET,\n		dbo.BULK_PRODUCT.CONTAINER_OWNER_ID,\n		dbo.BULK_PRODUCT.AFFECT_ACCOUNTING,\n		db"
+"o.BULK_PRODUCT.SUPPLIER_PRODUCT_SUPPLIER,\n		dbo.BULK_PRODUCT.SUPPLIER_PRODUCT_NUMBER\nFROM	dbo.BULK_PRODUCT";
		    

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
								row1.BULK_PRODUCT_ID = 0;
							} else {
		                          
            row1.BULK_PRODUCT_ID = rs_tDBInput_1.getInt(2);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 3) {
								row1.TERMINAL_PRODUCT_NUMBER = 0;
							} else {
		                          
            row1.TERMINAL_PRODUCT_NUMBER = rs_tDBInput_1.getInt(3);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 4) {
								row1.MEASUREMENT_DEVICE_PARENT_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(4);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(4).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.MEASUREMENT_DEVICE_PARENT_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.MEASUREMENT_DEVICE_PARENT_CODE = tmpContent_tDBInput_1;
                }
            } else {
                row1.MEASUREMENT_DEVICE_PARENT_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 5) {
								row1.COMPARTMENT_NUMBER = null;
							} else {
		                          
            row1.COMPARTMENT_NUMBER = rs_tDBInput_1.getInt(5);
            if(rs_tDBInput_1.wasNull()){
                    row1.COMPARTMENT_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 6) {
								row1.MEASUREMENT_DEVICE_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(6);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(6).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.MEASUREMENT_DEVICE_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.MEASUREMENT_DEVICE_CODE = tmpContent_tDBInput_1;
                }
            } else {
                row1.MEASUREMENT_DEVICE_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 7) {
								row1.USER_INTERFACE_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(7);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(7).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.USER_INTERFACE_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.USER_INTERFACE_CODE = tmpContent_tDBInput_1;
                }
            } else {
                row1.USER_INTERFACE_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 8) {
								row1.MEASUREMENT_DEVICE_TYPE = null;
							} else {
		                          
            row1.MEASUREMENT_DEVICE_TYPE = rs_tDBInput_1.getInt(8);
            if(rs_tDBInput_1.wasNull()){
                    row1.MEASUREMENT_DEVICE_TYPE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 9) {
								row1.SNAPSHOT_TANK_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(9);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(9).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.SNAPSHOT_TANK_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.SNAPSHOT_TANK_CODE = tmpContent_tDBInput_1;
                }
            } else {
                row1.SNAPSHOT_TANK_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 10) {
								row1.CONTAINER_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(10);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(10).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.CONTAINER_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.CONTAINER_CODE = tmpContent_tDBInput_1;
                }
            } else {
                row1.CONTAINER_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 11) {
								row1.CONTAINER_TYPE = null;
							} else {
		                          
            row1.CONTAINER_TYPE = rs_tDBInput_1.getInt(11);
            if(rs_tDBInput_1.wasNull()){
                    row1.CONTAINER_TYPE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 12) {
								row1.COMPARTMENT_OWNER_ID = null;
							} else {
		                          
            row1.COMPARTMENT_OWNER_ID = rs_tDBInput_1.getInt(12);
            if(rs_tDBInput_1.wasNull()){
                    row1.COMPARTMENT_OWNER_ID = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 13) {
								row1.COMPARTMENT_CONTAINER_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(13);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(13).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.COMPARTMENT_CONTAINER_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.COMPARTMENT_CONTAINER_CODE = tmpContent_tDBInput_1;
                }
            } else {
                row1.COMPARTMENT_CONTAINER_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 14) {
								row1.SNAPSHOT_TYPE = null;
							} else {
		                          
            row1.SNAPSHOT_TYPE = rs_tDBInput_1.getInt(14);
            if(rs_tDBInput_1.wasNull()){
                    row1.SNAPSHOT_TYPE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 15) {
								row1.COMPARTMENT_CONTAINER_TYPE = null;
							} else {
		                          
            row1.COMPARTMENT_CONTAINER_TYPE = rs_tDBInput_1.getInt(15);
            if(rs_tDBInput_1.wasNull()){
                    row1.COMPARTMENT_CONTAINER_TYPE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 16) {
								row1.FIGURES_TYPE = 0;
							} else {
		                          
            row1.FIGURES_TYPE = rs_tDBInput_1.getInt(16);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 17) {
								row1.SNAPSHOT_FOLIO_NUMBER = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(17);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(17).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.SNAPSHOT_FOLIO_NUMBER = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.SNAPSHOT_FOLIO_NUMBER = tmpContent_tDBInput_1;
                }
            } else {
                row1.SNAPSHOT_FOLIO_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 18) {
								row1.SNAPSHOT_SEQUENCE_NUMBER = null;
							} else {
		                          
            row1.SNAPSHOT_SEQUENCE_NUMBER = rs_tDBInput_1.getInt(18);
            if(rs_tDBInput_1.wasNull()){
                    row1.SNAPSHOT_SEQUENCE_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 19) {
								row1.FSHOST_SI_PRODUCT_NUMBER = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(19);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(19).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.FSHOST_SI_PRODUCT_NUMBER = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.FSHOST_SI_PRODUCT_NUMBER = tmpContent_tDBInput_1;
                }
            } else {
                row1.FSHOST_SI_PRODUCT_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 20) {
								row1.TSHOST_SI_PRODUCT_NUMBER = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(20);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(20).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.TSHOST_SI_PRODUCT_NUMBER = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.TSHOST_SI_PRODUCT_NUMBER = tmpContent_tDBInput_1;
                }
            } else {
                row1.TSHOST_SI_PRODUCT_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 21) {
								row1.GROSS_QUANTITY = 0;
							} else {
		                          
            row1.GROSS_QUANTITY = rs_tDBInput_1.getInt(21);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 22) {
								row1.NET_QUANTITY = 0;
							} else {
		                          
            row1.NET_QUANTITY = rs_tDBInput_1.getInt(22);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 23) {
								row1.DENSITY = 0;
							} else {
	                         		
            row1.DENSITY = rs_tDBInput_1.getDouble(23);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 24) {
								row1.TEMPERATURE = 0;
							} else {
	                         		
            row1.TEMPERATURE = rs_tDBInput_1.getDouble(24);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 25) {
								row1.WEIGHT = 0;
							} else {
		                          
            row1.WEIGHT = rs_tDBInput_1.getInt(25);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 26) {
								row1.OCTANE = 0;
							} else {
	                         		
            row1.OCTANE = rs_tDBInput_1.getDouble(26);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 27) {
								row1.RVP = 0;
							} else {
	                         		
            row1.RVP = rs_tDBInput_1.getDouble(27);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 28) {
								row1.COEFFICIENT_EXPANSION = 0;
							} else {
	                         		
            row1.COEFFICIENT_EXPANSION = rs_tDBInput_1.getDouble(28);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 29) {
								row1.OXYGEN = 0;
							} else {
	                         		
            row1.OXYGEN = rs_tDBInput_1.getDouble(29);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 30) {
								row1.SPECIFIC_GRAVITY = 0;
							} else {
	                         		
            row1.SPECIFIC_GRAVITY = rs_tDBInput_1.getDouble(30);
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
								row1.LAST_MODIFIED = null;
							} else {
										
			row1.LAST_MODIFIED = mssqlGTU_tDBInput_1.getDate(rsmd_tDBInput_1, rs_tDBInput_1, 32);
			
		                    }
							if(colQtyInRs_tDBInput_1 < 33) {
								row1.START_DATE = null;
							} else {
										
			row1.START_DATE = mssqlGTU_tDBInput_1.getDate(rsmd_tDBInput_1, rs_tDBInput_1, 33);
			
		                    }
							if(colQtyInRs_tDBInput_1 < 34) {
								row1.END_DATE = null;
							} else {
										
			row1.END_DATE = mssqlGTU_tDBInput_1.getDate(rsmd_tDBInput_1, rs_tDBInput_1, 34);
			
		                    }
							if(colQtyInRs_tDBInput_1 < 35) {
								row1.PRESSURE = 0;
							} else {
	                         		
            row1.PRESSURE = rs_tDBInput_1.getDouble(35);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 36) {
								row1.FLOW_RATE = 0;
							} else {
	                         		
            row1.FLOW_RATE = rs_tDBInput_1.getDouble(36);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 37) {
								row1.AVERAGE_METER_FACTOR = 0;
							} else {
	                         		
            row1.AVERAGE_METER_FACTOR = rs_tDBInput_1.getDouble(37);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 38) {
								row1.VCF = 0;
							} else {
	                         		
            row1.VCF = rs_tDBInput_1.getDouble(38);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 39) {
								row1.PCF = 0;
							} else {
	                         		
            row1.PCF = rs_tDBInput_1.getDouble(39);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 40) {
								row1.OBSERVED_DENSITY = 0;
							} else {
	                         		
            row1.OBSERVED_DENSITY = rs_tDBInput_1.getDouble(40);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 41) {
								row1.INVENTORY_QUANTITY_TYPE = 0;
							} else {
		                          
            row1.INVENTORY_QUANTITY_TYPE = rs_tDBInput_1.getInt(41);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 42) {
								row1.MEASURED_DENSITY = 0;
							} else {
	                         		
            row1.MEASURED_DENSITY = rs_tDBInput_1.getDouble(42);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 43) {
								row1.BSW_PERCENT = 0;
							} else {
	                         		
            row1.BSW_PERCENT = rs_tDBInput_1.getDouble(43);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 44) {
								row1.WATER_VOLUME = 0;
							} else {
		                          
            row1.WATER_VOLUME = rs_tDBInput_1.getInt(44);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 45) {
								row1.WEIGHT_IN_VAC = 0;
							} else {
		                          
            row1.WEIGHT_IN_VAC = rs_tDBInput_1.getInt(45);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 46) {
								row1.GROSS_FRAC_QUANTITY = 0;
							} else {
		                          
            row1.GROSS_FRAC_QUANTITY = rs_tDBInput_1.getInt(46);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 47) {
								row1.NET_FRAC_QUANTITY = 0;
							} else {
		                          
            row1.NET_FRAC_QUANTITY = rs_tDBInput_1.getInt(47);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 48) {
								row1.LEVEL_CHANGE = 0;
							} else {
		                          
            row1.LEVEL_CHANGE = rs_tDBInput_1.getInt(48);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 49) {
								row1.FRAC_WEIGHT = 0;
							} else {
		                          
            row1.FRAC_WEIGHT = rs_tDBInput_1.getInt(49);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 50) {
								row1.FRAC_WEIGHT_IN_VAC = 0;
							} else {
		                          
            row1.FRAC_WEIGHT_IN_VAC = rs_tDBInput_1.getInt(50);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 51) {
								row1.DIRECTION = 0;
							} else {
		                          
            row1.DIRECTION = rs_tDBInput_1.getInt(51);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 52) {
								row1.DECLARED_GROSS_QUANTITY = 0;
							} else {
		                          
            row1.DECLARED_GROSS_QUANTITY = rs_tDBInput_1.getInt(52);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 53) {
								row1.DECLARED_GROSS_FRAC_QUANTITY = 0;
							} else {
		                          
            row1.DECLARED_GROSS_FRAC_QUANTITY = rs_tDBInput_1.getInt(53);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 54) {
								row1.DECLARED_NET_QUANTITY = 0;
							} else {
		                          
            row1.DECLARED_NET_QUANTITY = rs_tDBInput_1.getInt(54);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 55) {
								row1.DECLARED_NET_FRAC_QUANTITY = 0;
							} else {
		                          
            row1.DECLARED_NET_FRAC_QUANTITY = rs_tDBInput_1.getInt(55);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 56) {
								row1.DECLARED_WEIGHT = 0;
							} else {
		                          
            row1.DECLARED_WEIGHT = rs_tDBInput_1.getInt(56);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 57) {
								row1.DECLARED_FRAC_WEIGHT = 0;
							} else {
		                          
            row1.DECLARED_FRAC_WEIGHT = rs_tDBInput_1.getInt(57);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 58) {
								row1.DECLARED_WEIGHT_IN_VAC = 0;
							} else {
		                          
            row1.DECLARED_WEIGHT_IN_VAC = rs_tDBInput_1.getInt(58);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 59) {
								row1.MEASURED_QUANTITY_TYPE = 0;
							} else {
		                          
            row1.MEASURED_QUANTITY_TYPE = rs_tDBInput_1.getInt(59);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 60) {
								row1.DERIVED_VALUES_DIRECTIVE = 0;
							} else {
		                          
            row1.DERIVED_VALUES_DIRECTIVE = rs_tDBInput_1.getInt(60);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 61) {
								row1.DECLARED_FRAC_WEIGHT_IN_VAC = 0;
							} else {
		                          
            row1.DECLARED_FRAC_WEIGHT_IN_VAC = rs_tDBInput_1.getInt(61);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 62) {
								row1.CALCULATE_NET = 0;
							} else {
		                          
            row1.CALCULATE_NET = rs_tDBInput_1.getInt(62);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 63) {
								row1.CONTAINER_OWNER_ID = null;
							} else {
		                          
            row1.CONTAINER_OWNER_ID = rs_tDBInput_1.getInt(63);
            if(rs_tDBInput_1.wasNull()){
                    row1.CONTAINER_OWNER_ID = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 64) {
								row1.AFFECT_ACCOUNTING = 0;
							} else {
		                          
            row1.AFFECT_ACCOUNTING = rs_tDBInput_1.getInt(64);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 65) {
								row1.SUPPLIER_PRODUCT_SUPPLIER = null;
							} else {
		                          
            row1.SUPPLIER_PRODUCT_SUPPLIER = rs_tDBInput_1.getInt(65);
            if(rs_tDBInput_1.wasNull()){
                    row1.SUPPLIER_PRODUCT_SUPPLIER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 66) {
								row1.SUPPLIER_PRODUCT_NUMBER = null;
							} else {
		                          
            row1.SUPPLIER_PRODUCT_NUMBER = rs_tDBInput_1.getInt(66);
            if(rs_tDBInput_1.wasNull()){
                    row1.SUPPLIER_PRODUCT_NUMBER = null;
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
finder_tUniqRow_1.BULK_PRODUCT_ID = row1.BULK_PRODUCT_ID;
finder_tUniqRow_1.TERMINAL_PRODUCT_NUMBER = row1.TERMINAL_PRODUCT_NUMBER;
if(row1.CONTAINER_CODE == null){
	finder_tUniqRow_1.CONTAINER_CODE = null;
}else{
	finder_tUniqRow_1.CONTAINER_CODE = row1.CONTAINER_CODE.toLowerCase();
}
finder_tUniqRow_1.INVENTORY_QUANTITY_TYPE = row1.INVENTORY_QUANTITY_TYPE;
finder_tUniqRow_1.LEVEL_CHANGE = row1.LEVEL_CHANGE;	
finder_tUniqRow_1.hashCodeDirty = true;
if (!keystUniqRow_1.contains(finder_tUniqRow_1)) {
		KeyStruct_tUniqRow_1 new_tUniqRow_1 = new KeyStruct_tUniqRow_1();

		
new_tUniqRow_1.BULK_MOVEMENT_ID = row1.BULK_MOVEMENT_ID;
new_tUniqRow_1.BULK_PRODUCT_ID = row1.BULK_PRODUCT_ID;
new_tUniqRow_1.TERMINAL_PRODUCT_NUMBER = row1.TERMINAL_PRODUCT_NUMBER;
if(row1.CONTAINER_CODE == null){
	new_tUniqRow_1.CONTAINER_CODE = null;
}else{
	new_tUniqRow_1.CONTAINER_CODE = row1.CONTAINER_CODE.toLowerCase();
}
new_tUniqRow_1.INVENTORY_QUANTITY_TYPE = row1.INVENTORY_QUANTITY_TYPE;
new_tUniqRow_1.LEVEL_CHANGE = row1.LEVEL_CHANGE;
		
		keystUniqRow_1.add(new_tUniqRow_1);if(row2 == null){ 
	
	row2 = new row2Struct();
}row2.BULK_MOVEMENT_ID = row1.BULK_MOVEMENT_ID;			row2.BULK_PRODUCT_ID = row1.BULK_PRODUCT_ID;			row2.TERMINAL_PRODUCT_NUMBER = row1.TERMINAL_PRODUCT_NUMBER;			row2.MEASUREMENT_DEVICE_PARENT_CODE = row1.MEASUREMENT_DEVICE_PARENT_CODE;			row2.COMPARTMENT_NUMBER = row1.COMPARTMENT_NUMBER;			row2.MEASUREMENT_DEVICE_CODE = row1.MEASUREMENT_DEVICE_CODE;			row2.USER_INTERFACE_CODE = row1.USER_INTERFACE_CODE;			row2.MEASUREMENT_DEVICE_TYPE = row1.MEASUREMENT_DEVICE_TYPE;			row2.SNAPSHOT_TANK_CODE = row1.SNAPSHOT_TANK_CODE;			row2.CONTAINER_CODE = row1.CONTAINER_CODE;			row2.CONTAINER_TYPE = row1.CONTAINER_TYPE;			row2.COMPARTMENT_OWNER_ID = row1.COMPARTMENT_OWNER_ID;			row2.COMPARTMENT_CONTAINER_CODE = row1.COMPARTMENT_CONTAINER_CODE;			row2.SNAPSHOT_TYPE = row1.SNAPSHOT_TYPE;			row2.COMPARTMENT_CONTAINER_TYPE = row1.COMPARTMENT_CONTAINER_TYPE;			row2.FIGURES_TYPE = row1.FIGURES_TYPE;			row2.SNAPSHOT_FOLIO_NUMBER = row1.SNAPSHOT_FOLIO_NUMBER;			row2.SNAPSHOT_SEQUENCE_NUMBER = row1.SNAPSHOT_SEQUENCE_NUMBER;			row2.FSHOST_SI_PRODUCT_NUMBER = row1.FSHOST_SI_PRODUCT_NUMBER;			row2.TSHOST_SI_PRODUCT_NUMBER = row1.TSHOST_SI_PRODUCT_NUMBER;			row2.GROSS_QUANTITY = row1.GROSS_QUANTITY;			row2.NET_QUANTITY = row1.NET_QUANTITY;			row2.DENSITY = row1.DENSITY;			row2.TEMPERATURE = row1.TEMPERATURE;			row2.WEIGHT = row1.WEIGHT;			row2.OCTANE = row1.OCTANE;			row2.RVP = row1.RVP;			row2.COEFFICIENT_EXPANSION = row1.COEFFICIENT_EXPANSION;			row2.OXYGEN = row1.OXYGEN;			row2.SPECIFIC_GRAVITY = row1.SPECIFIC_GRAVITY;			row2.LAST_USER_NAME = row1.LAST_USER_NAME;			row2.LAST_MODIFIED = row1.LAST_MODIFIED;			row2.START_DATE = row1.START_DATE;			row2.END_DATE = row1.END_DATE;			row2.PRESSURE = row1.PRESSURE;			row2.FLOW_RATE = row1.FLOW_RATE;			row2.AVERAGE_METER_FACTOR = row1.AVERAGE_METER_FACTOR;			row2.VCF = row1.VCF;			row2.PCF = row1.PCF;			row2.OBSERVED_DENSITY = row1.OBSERVED_DENSITY;			row2.INVENTORY_QUANTITY_TYPE = row1.INVENTORY_QUANTITY_TYPE;			row2.MEASURED_DENSITY = row1.MEASURED_DENSITY;			row2.BSW_PERCENT = row1.BSW_PERCENT;			row2.WATER_VOLUME = row1.WATER_VOLUME;			row2.WEIGHT_IN_VAC = row1.WEIGHT_IN_VAC;			row2.GROSS_FRAC_QUANTITY = row1.GROSS_FRAC_QUANTITY;			row2.NET_FRAC_QUANTITY = row1.NET_FRAC_QUANTITY;			row2.LEVEL_CHANGE = row1.LEVEL_CHANGE;			row2.FRAC_WEIGHT = row1.FRAC_WEIGHT;			row2.FRAC_WEIGHT_IN_VAC = row1.FRAC_WEIGHT_IN_VAC;			row2.DIRECTION = row1.DIRECTION;			row2.DECLARED_GROSS_QUANTITY = row1.DECLARED_GROSS_QUANTITY;			row2.DECLARED_GROSS_FRAC_QUANTITY = row1.DECLARED_GROSS_FRAC_QUANTITY;			row2.DECLARED_NET_QUANTITY = row1.DECLARED_NET_QUANTITY;			row2.DECLARED_NET_FRAC_QUANTITY = row1.DECLARED_NET_FRAC_QUANTITY;			row2.DECLARED_WEIGHT = row1.DECLARED_WEIGHT;			row2.DECLARED_FRAC_WEIGHT = row1.DECLARED_FRAC_WEIGHT;			row2.DECLARED_WEIGHT_IN_VAC = row1.DECLARED_WEIGHT_IN_VAC;			row2.MEASURED_QUANTITY_TYPE = row1.MEASURED_QUANTITY_TYPE;			row2.DERIVED_VALUES_DIRECTIVE = row1.DERIVED_VALUES_DIRECTIVE;			row2.DECLARED_FRAC_WEIGHT_IN_VAC = row1.DECLARED_FRAC_WEIGHT_IN_VAC;			row2.CALCULATE_NET = row1.CALCULATE_NET;			row2.CONTAINER_OWNER_ID = row1.CONTAINER_OWNER_ID;			row2.AFFECT_ACCOUNTING = row1.AFFECT_ACCOUNTING;			row2.SUPPLIER_PRODUCT_SUPPLIER = row1.SUPPLIER_PRODUCT_SUPPLIER;			row2.SUPPLIER_PRODUCT_NUMBER = row1.SUPPLIER_PRODUCT_NUMBER;					
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
								
	                        		    	Object exprKeyValue_row3__BULK_PRODUCT_ID = row2.BULK_PRODUCT_ID ;
	                        		    	if(exprKeyValue_row3__BULK_PRODUCT_ID == null) {
	                        		    		hasCasePrimitiveKeyWithNull_tMap_1 = true;
	                        		    	} else {
                        		    			row3HashKey.BULK_PRODUCT_ID = (int)(Integer) exprKeyValue_row3__BULK_PRODUCT_ID;
                        		    		}
                        		    		

								
		                        	row3HashKey.hashCodeDirty = true;
                        		
	  					
	  							
	
		  							if(!hasCasePrimitiveKeyWithNull_tMap_1) { // G_TM_M_091
		  							
			  					
			  					
			  					
	  					
		  							tHash_Lookup_row3.lookup( row3HashKey );

	  							

	  							

			  						} // G_TM_M_091
			  						
			  					

 								
		  				
	  								
						
									
  									  		
 								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_row3 != null && tHash_Lookup_row3.getCount(row3HashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row3' and it contains more one result from keys :  row3.BULK_PRODUCT_ID = '" + row3HashKey.BULK_PRODUCT_ID + "'");
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
Var.PK_BULK_PRODUCT = Numeric.sequence("s8",1,1) ;// ###############################
        // ###############################
        // # Output tables

out1 = null;

boolean rejected_tMap_1 = true;
// ###### START REJECTS ##### 

// # Output reject table : 'out1'
// # Filter conditions 
if( rejected_tMap_1 ) {
out1_tmp.PK_BULK_PRODUCT = Var.PK_BULK_PRODUCT ;
out1_tmp.BULK_MOVEMENT_ID = row2.BULK_MOVEMENT_ID ;
out1_tmp.BULK_PRODUCT_ID = row2.BULK_PRODUCT_ID ;
out1_tmp.TERMINAL_PRODUCT_NUMBER = row2.TERMINAL_PRODUCT_NUMBER ;
out1_tmp.CONTAINER_CODE = row2.CONTAINER_CODE ;
out1_tmp.SNAPSHOT_TYPE = row2.SNAPSHOT_TYPE ;
out1_tmp.FIGURES_TYPE = row2.FIGURES_TYPE ;
out1_tmp.LAST_USER_NAME = row2.LAST_USER_NAME ;
out1_tmp.LAST_MODIFIED = row2.LAST_MODIFIED ;
out1_tmp.START_DATE = row2.START_DATE ;
out1_tmp.END_DATE = row2.END_DATE ;
out1_tmp.INVENTORY_QUANTITY_TYPE = row2.INVENTORY_QUANTITY_TYPE ;
out1_tmp.DIRECTION = row2.DIRECTION ;
out1_tmp.MEASURED_QUANTITY_TYPE = row2.MEASURED_QUANTITY_TYPE ;
out1 = out1_tmp;
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


                    if(out1.PK_BULK_PRODUCT == null) {
pstmt_tDBOutput_1.setNull(1, java.sql.Types.INTEGER);
} else {pstmt_tDBOutput_1.setInt(1, out1.PK_BULK_PRODUCT);
}

            int checkCount_tDBOutput_1 = -1;
            try (java.sql.ResultSet rs_tDBOutput_1 = pstmt_tDBOutput_1.executeQuery()) {
                while(rs_tDBOutput_1.next()) {
                    checkCount_tDBOutput_1 = rs_tDBOutput_1.getInt(1);
                }
            }
            if(checkCount_tDBOutput_1 > 0) {
                        pstmtUpdate_tDBOutput_1.setInt(1, out1.BULK_MOVEMENT_ID);

                        pstmtUpdate_tDBOutput_1.setInt(2, out1.BULK_PRODUCT_ID);

                        pstmtUpdate_tDBOutput_1.setInt(3, out1.TERMINAL_PRODUCT_NUMBER);

                        if(out1.CONTAINER_CODE == null) {
pstmtUpdate_tDBOutput_1.setNull(4, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(4, out1.CONTAINER_CODE);
}

                        if(out1.SNAPSHOT_TYPE == null) {
pstmtUpdate_tDBOutput_1.setNull(5, java.sql.Types.INTEGER);
} else {pstmtUpdate_tDBOutput_1.setInt(5, out1.SNAPSHOT_TYPE);
}

                        pstmtUpdate_tDBOutput_1.setInt(6, out1.FIGURES_TYPE);

                        if(out1.LAST_USER_NAME == null) {
pstmtUpdate_tDBOutput_1.setNull(7, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(7, out1.LAST_USER_NAME);
}

                        if(out1.LAST_MODIFIED != null) {
pstmtUpdate_tDBOutput_1.setTimestamp(8, new java.sql.Timestamp(out1.LAST_MODIFIED.getTime()));
} else {
pstmtUpdate_tDBOutput_1.setNull(8, java.sql.Types.TIMESTAMP);
}

                        if(out1.START_DATE != null) {
pstmtUpdate_tDBOutput_1.setTimestamp(9, new java.sql.Timestamp(out1.START_DATE.getTime()));
} else {
pstmtUpdate_tDBOutput_1.setNull(9, java.sql.Types.TIMESTAMP);
}

                        if(out1.END_DATE != null) {
pstmtUpdate_tDBOutput_1.setTimestamp(10, new java.sql.Timestamp(out1.END_DATE.getTime()));
} else {
pstmtUpdate_tDBOutput_1.setNull(10, java.sql.Types.TIMESTAMP);
}

                        pstmtUpdate_tDBOutput_1.setInt(11, out1.INVENTORY_QUANTITY_TYPE);

                        pstmtUpdate_tDBOutput_1.setInt(12, out1.DIRECTION);

                        pstmtUpdate_tDBOutput_1.setInt(13, out1.MEASURED_QUANTITY_TYPE);


	                    

                        if(out1.PK_BULK_PRODUCT == null) {
pstmtUpdate_tDBOutput_1.setNull(14 + count_tDBOutput_1, java.sql.Types.INTEGER);
} else {pstmtUpdate_tDBOutput_1.setInt(14 + count_tDBOutput_1, out1.PK_BULK_PRODUCT);
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
                        if(out1.PK_BULK_PRODUCT == null) {
pstmtInsert_tDBOutput_1.setNull(1, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_1.setInt(1, out1.PK_BULK_PRODUCT);
}

                        pstmtInsert_tDBOutput_1.setInt(2, out1.BULK_MOVEMENT_ID);

                        pstmtInsert_tDBOutput_1.setInt(3, out1.BULK_PRODUCT_ID);

                        pstmtInsert_tDBOutput_1.setInt(4, out1.TERMINAL_PRODUCT_NUMBER);

                        if(out1.CONTAINER_CODE == null) {
pstmtInsert_tDBOutput_1.setNull(5, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(5, out1.CONTAINER_CODE);
}

                        if(out1.SNAPSHOT_TYPE == null) {
pstmtInsert_tDBOutput_1.setNull(6, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_1.setInt(6, out1.SNAPSHOT_TYPE);
}

                        pstmtInsert_tDBOutput_1.setInt(7, out1.FIGURES_TYPE);

                        if(out1.LAST_USER_NAME == null) {
pstmtInsert_tDBOutput_1.setNull(8, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(8, out1.LAST_USER_NAME);
}

                        if(out1.LAST_MODIFIED != null) {
pstmtInsert_tDBOutput_1.setTimestamp(9, new java.sql.Timestamp(out1.LAST_MODIFIED.getTime()));
} else {
pstmtInsert_tDBOutput_1.setNull(9, java.sql.Types.TIMESTAMP);
}

                        if(out1.START_DATE != null) {
pstmtInsert_tDBOutput_1.setTimestamp(10, new java.sql.Timestamp(out1.START_DATE.getTime()));
} else {
pstmtInsert_tDBOutput_1.setNull(10, java.sql.Types.TIMESTAMP);
}

                        if(out1.END_DATE != null) {
pstmtInsert_tDBOutput_1.setTimestamp(11, new java.sql.Timestamp(out1.END_DATE.getTime()));
} else {
pstmtInsert_tDBOutput_1.setNull(11, java.sql.Types.TIMESTAMP);
}

                        pstmtInsert_tDBOutput_1.setInt(12, out1.INVENTORY_QUANTITY_TYPE);

                        pstmtInsert_tDBOutput_1.setInt(13, out1.DIRECTION);

                        pstmtInsert_tDBOutput_1.setInt(14, out1.MEASURED_QUANTITY_TYPE);

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
    final static byte[] commonByteArrayLock_PGS_STAGE_DIM_BULK_PRODUCT = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_DIM_BULK_PRODUCT = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public int PK_BULK_PRODUCT;

				public int getPK_BULK_PRODUCT () {
					return this.PK_BULK_PRODUCT;
				}
				
			    public int BULK_MOVEMENT_ID;

				public int getBULK_MOVEMENT_ID () {
					return this.BULK_MOVEMENT_ID;
				}
				
			    public int BULK_PRODUCT_ID;

				public int getBULK_PRODUCT_ID () {
					return this.BULK_PRODUCT_ID;
				}
				
			    public int TERMINAL_PRODUCT_NUMBER;

				public int getTERMINAL_PRODUCT_NUMBER () {
					return this.TERMINAL_PRODUCT_NUMBER;
				}
				
			    public String CONTAINER_CODE;

				public String getCONTAINER_CODE () {
					return this.CONTAINER_CODE;
				}
				
			    public Integer SNAPSHOT_TYPE;

				public Integer getSNAPSHOT_TYPE () {
					return this.SNAPSHOT_TYPE;
				}
				
			    public int FIGURES_TYPE;

				public int getFIGURES_TYPE () {
					return this.FIGURES_TYPE;
				}
				
			    public String LAST_USER_NAME;

				public String getLAST_USER_NAME () {
					return this.LAST_USER_NAME;
				}
				
			    public java.util.Date LAST_MODIFIED;

				public java.util.Date getLAST_MODIFIED () {
					return this.LAST_MODIFIED;
				}
				
			    public java.util.Date START_DATE;

				public java.util.Date getSTART_DATE () {
					return this.START_DATE;
				}
				
			    public java.util.Date END_DATE;

				public java.util.Date getEND_DATE () {
					return this.END_DATE;
				}
				
			    public int INVENTORY_QUANTITY_TYPE;

				public int getINVENTORY_QUANTITY_TYPE () {
					return this.INVENTORY_QUANTITY_TYPE;
				}
				
			    public int DIRECTION;

				public int getDIRECTION () {
					return this.DIRECTION;
				}
				
			    public int MEASURED_QUANTITY_TYPE;

				public int getMEASURED_QUANTITY_TYPE () {
					return this.MEASURED_QUANTITY_TYPE;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
							result = prime * result + (int) this.BULK_PRODUCT_ID;
						
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
		
						if (this.BULK_PRODUCT_ID != other.BULK_PRODUCT_ID)
							return false;
					

		return true;
    }

	public void copyDataTo(row3Struct other) {

		other.PK_BULK_PRODUCT = this.PK_BULK_PRODUCT;
	            other.BULK_MOVEMENT_ID = this.BULK_MOVEMENT_ID;
	            other.BULK_PRODUCT_ID = this.BULK_PRODUCT_ID;
	            other.TERMINAL_PRODUCT_NUMBER = this.TERMINAL_PRODUCT_NUMBER;
	            other.CONTAINER_CODE = this.CONTAINER_CODE;
	            other.SNAPSHOT_TYPE = this.SNAPSHOT_TYPE;
	            other.FIGURES_TYPE = this.FIGURES_TYPE;
	            other.LAST_USER_NAME = this.LAST_USER_NAME;
	            other.LAST_MODIFIED = this.LAST_MODIFIED;
	            other.START_DATE = this.START_DATE;
	            other.END_DATE = this.END_DATE;
	            other.INVENTORY_QUANTITY_TYPE = this.INVENTORY_QUANTITY_TYPE;
	            other.DIRECTION = this.DIRECTION;
	            other.MEASURED_QUANTITY_TYPE = this.MEASURED_QUANTITY_TYPE;
	            
	}

	public void copyKeysDataTo(row3Struct other) {

		other.BULK_PRODUCT_ID = this.BULK_PRODUCT_ID;
	            	
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

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_BULK_PRODUCT) {

        	try {

        		int length = 0;
		
			        this.BULK_PRODUCT_ID = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_BULK_PRODUCT) {

        	try {

        		int length = 0;
		
			        this.BULK_PRODUCT_ID = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.BULK_PRODUCT_ID);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.BULK_PRODUCT_ID);
					
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
		
			            this.PK_BULK_PRODUCT = dis.readInt();
					
			            this.BULK_MOVEMENT_ID = dis.readInt();
					
			            this.TERMINAL_PRODUCT_NUMBER = dis.readInt();
					
						this.CONTAINER_CODE = readString(dis,ois);
					
						this.SNAPSHOT_TYPE = readInteger(dis,ois);
					
			            this.FIGURES_TYPE = dis.readInt();
					
						this.LAST_USER_NAME = readString(dis,ois);
					
						this.LAST_MODIFIED = readDate(dis,ois);
					
						this.START_DATE = readDate(dis,ois);
					
						this.END_DATE = readDate(dis,ois);
					
			            this.INVENTORY_QUANTITY_TYPE = dis.readInt();
					
			            this.DIRECTION = dis.readInt();
					
			            this.MEASURED_QUANTITY_TYPE = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
			            this.PK_BULK_PRODUCT = objectIn.readInt();
					
			            this.BULK_MOVEMENT_ID = objectIn.readInt();
					
			            this.TERMINAL_PRODUCT_NUMBER = objectIn.readInt();
					
						this.CONTAINER_CODE = readString(dis,objectIn);
					
						this.SNAPSHOT_TYPE = readInteger(dis,objectIn);
					
			            this.FIGURES_TYPE = objectIn.readInt();
					
						this.LAST_USER_NAME = readString(dis,objectIn);
					
						this.LAST_MODIFIED = readDate(dis,objectIn);
					
						this.START_DATE = readDate(dis,objectIn);
					
						this.END_DATE = readDate(dis,objectIn);
					
			            this.INVENTORY_QUANTITY_TYPE = objectIn.readInt();
					
			            this.DIRECTION = objectIn.readInt();
					
			            this.MEASURED_QUANTITY_TYPE = objectIn.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
		            	dos.writeInt(this.PK_BULK_PRODUCT);
					
		            	dos.writeInt(this.BULK_MOVEMENT_ID);
					
		            	dos.writeInt(this.TERMINAL_PRODUCT_NUMBER);
					
						writeString(this.CONTAINER_CODE, dos, oos);
					
					writeInteger(this.SNAPSHOT_TYPE, dos, oos);
					
		            	dos.writeInt(this.FIGURES_TYPE);
					
						writeString(this.LAST_USER_NAME, dos, oos);
					
						writeDate(this.LAST_MODIFIED, dos, oos);
					
						writeDate(this.START_DATE, dos, oos);
					
						writeDate(this.END_DATE, dos, oos);
					
		            	dos.writeInt(this.INVENTORY_QUANTITY_TYPE);
					
		            	dos.writeInt(this.DIRECTION);
					
		            	dos.writeInt(this.MEASURED_QUANTITY_TYPE);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
					objectOut.writeInt(this.PK_BULK_PRODUCT);
					
					objectOut.writeInt(this.BULK_MOVEMENT_ID);
					
					objectOut.writeInt(this.TERMINAL_PRODUCT_NUMBER);
					
						writeString(this.CONTAINER_CODE, dos, objectOut);
					
					writeInteger(this.SNAPSHOT_TYPE, dos, objectOut);
					
					objectOut.writeInt(this.FIGURES_TYPE);
					
						writeString(this.LAST_USER_NAME, dos, objectOut);
					
						writeDate(this.LAST_MODIFIED, dos, objectOut);
					
						writeDate(this.START_DATE, dos, objectOut);
					
						writeDate(this.END_DATE, dos, objectOut);
					
					objectOut.writeInt(this.INVENTORY_QUANTITY_TYPE);
					
					objectOut.writeInt(this.DIRECTION);
					
					objectOut.writeInt(this.MEASURED_QUANTITY_TYPE);
					
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
		sb.append("PK_BULK_PRODUCT="+String.valueOf(PK_BULK_PRODUCT));
		sb.append(",BULK_MOVEMENT_ID="+String.valueOf(BULK_MOVEMENT_ID));
		sb.append(",BULK_PRODUCT_ID="+String.valueOf(BULK_PRODUCT_ID));
		sb.append(",TERMINAL_PRODUCT_NUMBER="+String.valueOf(TERMINAL_PRODUCT_NUMBER));
		sb.append(",CONTAINER_CODE="+CONTAINER_CODE);
		sb.append(",SNAPSHOT_TYPE="+String.valueOf(SNAPSHOT_TYPE));
		sb.append(",FIGURES_TYPE="+String.valueOf(FIGURES_TYPE));
		sb.append(",LAST_USER_NAME="+LAST_USER_NAME);
		sb.append(",LAST_MODIFIED="+String.valueOf(LAST_MODIFIED));
		sb.append(",START_DATE="+String.valueOf(START_DATE));
		sb.append(",END_DATE="+String.valueOf(END_DATE));
		sb.append(",INVENTORY_QUANTITY_TYPE="+String.valueOf(INVENTORY_QUANTITY_TYPE));
		sb.append(",DIRECTION="+String.valueOf(DIRECTION));
		sb.append(",MEASURED_QUANTITY_TYPE="+String.valueOf(MEASURED_QUANTITY_TYPE));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row3Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.BULK_PRODUCT_ID, other.BULK_PRODUCT_ID);
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
				
				 
	final String decryptedPassword_tDBInput_2 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:ybBWmLBnNkDfK9Dn/OkOQ5iTlsL+yE/8U/muQMEHDsFsUTII+yo=");
				
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

		    String dbquery_tDBInput_2 = "SELECT dbo.DIM_BULK_PRODUCT.PK_BULK_PRODUCT,\n		dbo.DIM_BULK_PRODUCT.BULK_MOVEMENT_ID,\n		dbo.DIM_BULK_PRODUCT.BULK_PRODU"
+"CT_ID,\n		dbo.DIM_BULK_PRODUCT.TERMINAL_PRODUCT_NUMBER,\n		dbo.DIM_BULK_PRODUCT.CONTAINER_CODE,\n		dbo.DIM_BULK_PRODUCT.SNA"
+"PSHOT_TYPE,\n		dbo.DIM_BULK_PRODUCT.FIGURES_TYPE,\n		dbo.DIM_BULK_PRODUCT.LAST_USER_NAME,\n		dbo.DIM_BULK_PRODUCT.LAST_MODI"
+"FIED,\n		dbo.DIM_BULK_PRODUCT.START_DATE,\n		dbo.DIM_BULK_PRODUCT.END_DATE,\n		dbo.DIM_BULK_PRODUCT.INVENTORY_QUANTITY_TYPE"
+",\n		dbo.DIM_BULK_PRODUCT.DIRECTION,\n		dbo.DIM_BULK_PRODUCT.MEASURED_QUANTITY_TYPE\nFROM	dbo.DIM_BULK_PRODUCT";
		    

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
								row3.PK_BULK_PRODUCT = 0;
							} else {
		                          
            row3.PK_BULK_PRODUCT = rs_tDBInput_2.getInt(1);
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
								row3.BULK_PRODUCT_ID = 0;
							} else {
		                          
            row3.BULK_PRODUCT_ID = rs_tDBInput_2.getInt(3);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 4) {
								row3.TERMINAL_PRODUCT_NUMBER = 0;
							} else {
		                          
            row3.TERMINAL_PRODUCT_NUMBER = rs_tDBInput_2.getInt(4);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 5) {
								row3.CONTAINER_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(5);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(5).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.CONTAINER_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row3.CONTAINER_CODE = tmpContent_tDBInput_2;
                }
            } else {
                row3.CONTAINER_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 6) {
								row3.SNAPSHOT_TYPE = null;
							} else {
		                          
            row3.SNAPSHOT_TYPE = rs_tDBInput_2.getInt(6);
            if(rs_tDBInput_2.wasNull()){
                    row3.SNAPSHOT_TYPE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 7) {
								row3.FIGURES_TYPE = 0;
							} else {
		                          
            row3.FIGURES_TYPE = rs_tDBInput_2.getInt(7);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 8) {
								row3.LAST_USER_NAME = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(8);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(8).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.LAST_USER_NAME = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row3.LAST_USER_NAME = tmpContent_tDBInput_2;
                }
            } else {
                row3.LAST_USER_NAME = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 9) {
								row3.LAST_MODIFIED = null;
							} else {
										
			row3.LAST_MODIFIED = mssqlGTU_tDBInput_2.getDate(rsmd_tDBInput_2, rs_tDBInput_2, 9);
			
		                    }
							if(colQtyInRs_tDBInput_2 < 10) {
								row3.START_DATE = null;
							} else {
										
			row3.START_DATE = mssqlGTU_tDBInput_2.getDate(rsmd_tDBInput_2, rs_tDBInput_2, 10);
			
		                    }
							if(colQtyInRs_tDBInput_2 < 11) {
								row3.END_DATE = null;
							} else {
										
			row3.END_DATE = mssqlGTU_tDBInput_2.getDate(rsmd_tDBInput_2, rs_tDBInput_2, 11);
			
		                    }
							if(colQtyInRs_tDBInput_2 < 12) {
								row3.INVENTORY_QUANTITY_TYPE = 0;
							} else {
		                          
            row3.INVENTORY_QUANTITY_TYPE = rs_tDBInput_2.getInt(12);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 13) {
								row3.DIRECTION = 0;
							} else {
		                          
            row3.DIRECTION = rs_tDBInput_2.getInt(13);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 14) {
								row3.MEASURED_QUANTITY_TYPE = 0;
							} else {
		                          
            row3.MEASURED_QUANTITY_TYPE = rs_tDBInput_2.getInt(14);
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
		   	   	   
				
				row3_HashRow.PK_BULK_PRODUCT = row3.PK_BULK_PRODUCT;
				
				row3_HashRow.BULK_MOVEMENT_ID = row3.BULK_MOVEMENT_ID;
				
				row3_HashRow.BULK_PRODUCT_ID = row3.BULK_PRODUCT_ID;
				
				row3_HashRow.TERMINAL_PRODUCT_NUMBER = row3.TERMINAL_PRODUCT_NUMBER;
				
				row3_HashRow.CONTAINER_CODE = row3.CONTAINER_CODE;
				
				row3_HashRow.SNAPSHOT_TYPE = row3.SNAPSHOT_TYPE;
				
				row3_HashRow.FIGURES_TYPE = row3.FIGURES_TYPE;
				
				row3_HashRow.LAST_USER_NAME = row3.LAST_USER_NAME;
				
				row3_HashRow.LAST_MODIFIED = row3.LAST_MODIFIED;
				
				row3_HashRow.START_DATE = row3.START_DATE;
				
				row3_HashRow.END_DATE = row3.END_DATE;
				
				row3_HashRow.INVENTORY_QUANTITY_TYPE = row3.INVENTORY_QUANTITY_TYPE;
				
				row3_HashRow.DIRECTION = row3.DIRECTION;
				
				row3_HashRow.MEASURED_QUANTITY_TYPE = row3.MEASURED_QUANTITY_TYPE;
				
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
        final DIM_BULK_PRODUCT DIM_BULK_PRODUCTClass = new DIM_BULK_PRODUCT();

        int exitCode = DIM_BULK_PRODUCTClass.runJobInTOS(args);

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
            java.io.InputStream inContext = DIM_BULK_PRODUCT.class.getClassLoader().getResourceAsStream("pgs_stage/dim_bulk_product_0_1/contexts/" + contextStr + ".properties");
            if (inContext == null) {
                inContext = DIM_BULK_PRODUCT.class.getClassLoader().getResourceAsStream("config/contexts/" + contextStr + ".properties");
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
            System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : DIM_BULK_PRODUCT");
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
 *     256568 characters generated by Talend Open Studio for Data Integration 
 *     on the 3 août 2024 à 14:42:25 GMT+01:00
 ************************************************************************************************/