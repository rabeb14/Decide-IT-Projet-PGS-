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


package pgs_stage.dim_supplier_product_0_1;

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
 * Job: DIM_SUPPLIER_PRODUCT Purpose: <br>
 * Description:  <br>
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status 
 */
public class DIM_SUPPLIER_PRODUCT implements TalendJob {

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
	private final String jobName = "DIM_SUPPLIER_PRODUCT";
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
				DIM_SUPPLIER_PRODUCT.this.exception = e;
			}
		}
		if (!(e instanceof TalendException)) {
		try {
			for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
				if (m.getName().compareTo(currentComponent + "_error") == 0) {
					m.invoke(DIM_SUPPLIER_PRODUCT.this, new Object[] { e , currentComponent, globalMap});
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
    final static byte[] commonByteArrayLock_PGS_STAGE_DIM_SUPPLIER_PRODUCT = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_DIM_SUPPLIER_PRODUCT = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public int PK_PRODUCT_SUPPLIER;

				public int getPK_PRODUCT_SUPPLIER () {
					return this.PK_PRODUCT_SUPPLIER;
				}
				
			    public Integer PRODUCT_COMMENT_SUPPLIER;

				public Integer getPRODUCT_COMMENT_SUPPLIER () {
					return this.PRODUCT_COMMENT_SUPPLIER;
				}
				
			    public int SUPPLIER_NUMBER;

				public int getSUPPLIER_NUMBER () {
					return this.SUPPLIER_NUMBER;
				}
				
			    public int PRODUCT_NUMBER;

				public int getPRODUCT_NUMBER () {
					return this.PRODUCT_NUMBER;
				}
				
			    public String NAME;

				public String getNAME () {
					return this.NAME;
				}
				
			    public String PRODUCT_GROUP_CODE;

				public String getPRODUCT_GROUP_CODE () {
					return this.PRODUCT_GROUP_CODE;
				}
				
			    public int CLEAN_FUEL;

				public int getCLEAN_FUEL () {
					return this.CLEAN_FUEL;
				}
				
			    public int ENABLED;

				public int getENABLED () {
					return this.ENABLED;
				}
				
			    public java.util.Date LAST_MODIFIED;

				public java.util.Date getLAST_MODIFIED () {
					return this.LAST_MODIFIED;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
							result = prime * result + (int) this.PK_PRODUCT_SUPPLIER;
						
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
		
						if (this.PK_PRODUCT_SUPPLIER != other.PK_PRODUCT_SUPPLIER)
							return false;
					

		return true;
    }

	public void copyDataTo(out2Struct other) {

		other.PK_PRODUCT_SUPPLIER = this.PK_PRODUCT_SUPPLIER;
	            other.PRODUCT_COMMENT_SUPPLIER = this.PRODUCT_COMMENT_SUPPLIER;
	            other.SUPPLIER_NUMBER = this.SUPPLIER_NUMBER;
	            other.PRODUCT_NUMBER = this.PRODUCT_NUMBER;
	            other.NAME = this.NAME;
	            other.PRODUCT_GROUP_CODE = this.PRODUCT_GROUP_CODE;
	            other.CLEAN_FUEL = this.CLEAN_FUEL;
	            other.ENABLED = this.ENABLED;
	            other.LAST_MODIFIED = this.LAST_MODIFIED;
	            
	}

	public void copyKeysDataTo(out2Struct other) {

		other.PK_PRODUCT_SUPPLIER = this.PK_PRODUCT_SUPPLIER;
	            	
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
			if(length > commonByteArray_PGS_STAGE_DIM_SUPPLIER_PRODUCT.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_SUPPLIER_PRODUCT.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_SUPPLIER_PRODUCT = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_SUPPLIER_PRODUCT = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PGS_STAGE_DIM_SUPPLIER_PRODUCT, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_SUPPLIER_PRODUCT, 0, length, utf8Charset);
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
			if(length > commonByteArray_PGS_STAGE_DIM_SUPPLIER_PRODUCT.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_SUPPLIER_PRODUCT.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_SUPPLIER_PRODUCT = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_SUPPLIER_PRODUCT = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PGS_STAGE_DIM_SUPPLIER_PRODUCT, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_SUPPLIER_PRODUCT, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_SUPPLIER_PRODUCT) {

        	try {

        		int length = 0;
		
			        this.PK_PRODUCT_SUPPLIER = dis.readInt();
					
						this.PRODUCT_COMMENT_SUPPLIER = readInteger(dis);
					
			        this.SUPPLIER_NUMBER = dis.readInt();
					
			        this.PRODUCT_NUMBER = dis.readInt();
					
					this.NAME = readString(dis);
					
					this.PRODUCT_GROUP_CODE = readString(dis);
					
			        this.CLEAN_FUEL = dis.readInt();
					
			        this.ENABLED = dis.readInt();
					
					this.LAST_MODIFIED = readDate(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_SUPPLIER_PRODUCT) {

        	try {

        		int length = 0;
		
			        this.PK_PRODUCT_SUPPLIER = dis.readInt();
					
						this.PRODUCT_COMMENT_SUPPLIER = readInteger(dis);
					
			        this.SUPPLIER_NUMBER = dis.readInt();
					
			        this.PRODUCT_NUMBER = dis.readInt();
					
					this.NAME = readString(dis);
					
					this.PRODUCT_GROUP_CODE = readString(dis);
					
			        this.CLEAN_FUEL = dis.readInt();
					
			        this.ENABLED = dis.readInt();
					
					this.LAST_MODIFIED = readDate(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.PK_PRODUCT_SUPPLIER);
					
					// Integer
				
						writeInteger(this.PRODUCT_COMMENT_SUPPLIER,dos);
					
					// int
				
		            	dos.writeInt(this.SUPPLIER_NUMBER);
					
					// int
				
		            	dos.writeInt(this.PRODUCT_NUMBER);
					
					// String
				
						writeString(this.NAME,dos);
					
					// String
				
						writeString(this.PRODUCT_GROUP_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.CLEAN_FUEL);
					
					// int
				
		            	dos.writeInt(this.ENABLED);
					
					// java.util.Date
				
						writeDate(this.LAST_MODIFIED,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.PK_PRODUCT_SUPPLIER);
					
					// Integer
				
						writeInteger(this.PRODUCT_COMMENT_SUPPLIER,dos);
					
					// int
				
		            	dos.writeInt(this.SUPPLIER_NUMBER);
					
					// int
				
		            	dos.writeInt(this.PRODUCT_NUMBER);
					
					// String
				
						writeString(this.NAME,dos);
					
					// String
				
						writeString(this.PRODUCT_GROUP_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.CLEAN_FUEL);
					
					// int
				
		            	dos.writeInt(this.ENABLED);
					
					// java.util.Date
				
						writeDate(this.LAST_MODIFIED,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("PK_PRODUCT_SUPPLIER="+String.valueOf(PK_PRODUCT_SUPPLIER));
		sb.append(",PRODUCT_COMMENT_SUPPLIER="+String.valueOf(PRODUCT_COMMENT_SUPPLIER));
		sb.append(",SUPPLIER_NUMBER="+String.valueOf(SUPPLIER_NUMBER));
		sb.append(",PRODUCT_NUMBER="+String.valueOf(PRODUCT_NUMBER));
		sb.append(",NAME="+NAME);
		sb.append(",PRODUCT_GROUP_CODE="+PRODUCT_GROUP_CODE);
		sb.append(",CLEAN_FUEL="+String.valueOf(CLEAN_FUEL));
		sb.append(",ENABLED="+String.valueOf(ENABLED));
		sb.append(",LAST_MODIFIED="+String.valueOf(LAST_MODIFIED));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(out2Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.PK_PRODUCT_SUPPLIER, other.PK_PRODUCT_SUPPLIER);
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
    final static byte[] commonByteArrayLock_PGS_STAGE_DIM_SUPPLIER_PRODUCT = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_DIM_SUPPLIER_PRODUCT = new byte[0];

	
			    public Integer PRODUCT_COMMENT_SUPPLIER;

				public Integer getPRODUCT_COMMENT_SUPPLIER () {
					return this.PRODUCT_COMMENT_SUPPLIER;
				}
				
			    public Integer HAZARD_SUPPLIER_NUMBER;

				public Integer getHAZARD_SUPPLIER_NUMBER () {
					return this.HAZARD_SUPPLIER_NUMBER;
				}
				
			    public int SUPPLIER_NUMBER;

				public int getSUPPLIER_NUMBER () {
					return this.SUPPLIER_NUMBER;
				}
				
			    public int PRODUCT_NUMBER;

				public int getPRODUCT_NUMBER () {
					return this.PRODUCT_NUMBER;
				}
				
			    public String HAZARD_WARNING_CODE;

				public String getHAZARD_WARNING_CODE () {
					return this.HAZARD_WARNING_CODE;
				}
				
			    public String NAME;

				public String getNAME () {
					return this.NAME;
				}
				
			    public String PRODUCT_COMMENT_CODE;

				public String getPRODUCT_COMMENT_CODE () {
					return this.PRODUCT_COMMENT_CODE;
				}
				
			    public String TERMINAL_HAZARD_WARNING;

				public String getTERMINAL_HAZARD_WARNING () {
					return this.TERMINAL_HAZARD_WARNING;
				}
				
			    public String PRODUCT_GROUP_CODE;

				public String getPRODUCT_GROUP_CODE () {
					return this.PRODUCT_GROUP_CODE;
				}
				
			    public String TERMINAL_PRODUCT_COMMENT;

				public String getTERMINAL_PRODUCT_COMMENT () {
					return this.TERMINAL_PRODUCT_COMMENT;
				}
				
			    public String TABS_PRODUCT_CODE;

				public String getTABS_PRODUCT_CODE () {
					return this.TABS_PRODUCT_CODE;
				}
				
			    public int CLEAN_FUEL;

				public int getCLEAN_FUEL () {
					return this.CLEAN_FUEL;
				}
				
			    public Integer TABS_BLEND_INDICATOR;

				public Integer getTABS_BLEND_INDICATOR () {
					return this.TABS_BLEND_INDICATOR;
				}
				
			    public int ON_TRUCK_SEQUENTIAL_ENABLED;

				public int getON_TRUCK_SEQUENTIAL_ENABLED () {
					return this.ON_TRUCK_SEQUENTIAL_ENABLED;
				}
				
			    public String TABS_PRODUCT_IDENTIFIER;

				public String getTABS_PRODUCT_IDENTIFIER () {
					return this.TABS_PRODUCT_IDENTIFIER;
				}
				
			    public int PRESET_SEQUENTIAL_ENABLED;

				public int getPRESET_SEQUENTIAL_ENABLED () {
					return this.PRESET_SEQUENTIAL_ENABLED;
				}
				
			    public int RATIO_BLENDING_ENABLED;

				public int getRATIO_BLENDING_ENABLED () {
					return this.RATIO_BLENDING_ENABLED;
				}
				
			    public int UPSTREAM_BLENDING_ENABLED;

				public int getUPSTREAM_BLENDING_ENABLED () {
					return this.UPSTREAM_BLENDING_ENABLED;
				}
				
			    public int ENABLED;

				public int getENABLED () {
					return this.ENABLED;
				}
				
			    public int REQUIRES_INTERVENTION;

				public int getREQUIRES_INTERVENTION () {
					return this.REQUIRES_INTERVENTION;
				}
				
			    public int BLEND_OUT_OF_TOLERANCE;

				public int getBLEND_OUT_OF_TOLERANCE () {
					return this.BLEND_OUT_OF_TOLERANCE;
				}
				
			    public double PRICE;

				public double getPRICE () {
					return this.PRICE;
				}
				
			    public String LAST_USER_NAME;

				public String getLAST_USER_NAME () {
					return this.LAST_USER_NAME;
				}
				
			    public double OCTANE;

				public double getOCTANE () {
					return this.OCTANE;
				}
				
			    public java.util.Date LAST_MODIFIED;

				public java.util.Date getLAST_MODIFIED () {
					return this.LAST_MODIFIED;
				}
				
			    public String PETROEX_PRODUCT_CODE;

				public String getPETROEX_PRODUCT_CODE () {
					return this.PETROEX_PRODUCT_CODE;
				}
				
			    public int PETROEX_BLEND_INDICATOR;

				public int getPETROEX_BLEND_INDICATOR () {
					return this.PETROEX_BLEND_INDICATOR;
				}
				
			    public int OVERWEIGHT_TRAILER;

				public int getOVERWEIGHT_TRAILER () {
					return this.OVERWEIGHT_TRAILER;
				}
				
			    public int ADDITIVE_OUT_OF_TOLERANCE;

				public int getADDITIVE_OUT_OF_TOLERANCE () {
					return this.ADDITIVE_OUT_OF_TOLERANCE;
				}
				
			    public int REQUIRES_CLEANLINE;

				public int getREQUIRES_CLEANLINE () {
					return this.REQUIRES_CLEANLINE;
				}
				
			    public int FLUSH_ACTION;

				public int getFLUSH_ACTION () {
					return this.FLUSH_ACTION;
				}
				
			    public int RFG_PRODUCT;

				public int getRFG_PRODUCT () {
					return this.RFG_PRODUCT;
				}
				
			    public int LOAD_LIMIT;

				public int getLOAD_LIMIT () {
					return this.LOAD_LIMIT;
				}
				
			    public String ADDITIONAL_NOTES;

				public String getADDITIONAL_NOTES () {
					return this.ADDITIONAL_NOTES;
				}
				
			    public int INCOMPATIBILITY_ACTION;

				public int getINCOMPATIBILITY_ACTION () {
					return this.INCOMPATIBILITY_ACTION;
				}
				
			    public int DISPATCH_QUANTITY_TYPE;

				public int getDISPATCH_QUANTITY_TYPE () {
					return this.DISPATCH_QUANTITY_TYPE;
				}
				
			    public String BOL_NAME;

				public String getBOL_NAME () {
					return this.BOL_NAME;
				}
				
			    public int LOADING_QUANTITY_TYPE;

				public int getLOADING_QUANTITY_TYPE () {
					return this.LOADING_QUANTITY_TYPE;
				}
				
			    public int PRICE_QUANTITY_TYPE;

				public int getPRICE_QUANTITY_TYPE () {
					return this.PRICE_QUANTITY_TYPE;
				}
				
			    public int ETHANOL_EXPANSION;

				public int getETHANOL_EXPANSION () {
					return this.ETHANOL_EXPANSION;
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
			if(length > commonByteArray_PGS_STAGE_DIM_SUPPLIER_PRODUCT.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_SUPPLIER_PRODUCT.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_SUPPLIER_PRODUCT = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_SUPPLIER_PRODUCT = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PGS_STAGE_DIM_SUPPLIER_PRODUCT, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_SUPPLIER_PRODUCT, 0, length, utf8Charset);
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
			if(length > commonByteArray_PGS_STAGE_DIM_SUPPLIER_PRODUCT.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_SUPPLIER_PRODUCT.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_SUPPLIER_PRODUCT = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_SUPPLIER_PRODUCT = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PGS_STAGE_DIM_SUPPLIER_PRODUCT, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_SUPPLIER_PRODUCT, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_SUPPLIER_PRODUCT) {

        	try {

        		int length = 0;
		
						this.PRODUCT_COMMENT_SUPPLIER = readInteger(dis);
					
						this.HAZARD_SUPPLIER_NUMBER = readInteger(dis);
					
			        this.SUPPLIER_NUMBER = dis.readInt();
					
			        this.PRODUCT_NUMBER = dis.readInt();
					
					this.HAZARD_WARNING_CODE = readString(dis);
					
					this.NAME = readString(dis);
					
					this.PRODUCT_COMMENT_CODE = readString(dis);
					
					this.TERMINAL_HAZARD_WARNING = readString(dis);
					
					this.PRODUCT_GROUP_CODE = readString(dis);
					
					this.TERMINAL_PRODUCT_COMMENT = readString(dis);
					
					this.TABS_PRODUCT_CODE = readString(dis);
					
			        this.CLEAN_FUEL = dis.readInt();
					
						this.TABS_BLEND_INDICATOR = readInteger(dis);
					
			        this.ON_TRUCK_SEQUENTIAL_ENABLED = dis.readInt();
					
					this.TABS_PRODUCT_IDENTIFIER = readString(dis);
					
			        this.PRESET_SEQUENTIAL_ENABLED = dis.readInt();
					
			        this.RATIO_BLENDING_ENABLED = dis.readInt();
					
			        this.UPSTREAM_BLENDING_ENABLED = dis.readInt();
					
			        this.ENABLED = dis.readInt();
					
			        this.REQUIRES_INTERVENTION = dis.readInt();
					
			        this.BLEND_OUT_OF_TOLERANCE = dis.readInt();
					
			        this.PRICE = dis.readDouble();
					
					this.LAST_USER_NAME = readString(dis);
					
			        this.OCTANE = dis.readDouble();
					
					this.LAST_MODIFIED = readDate(dis);
					
					this.PETROEX_PRODUCT_CODE = readString(dis);
					
			        this.PETROEX_BLEND_INDICATOR = dis.readInt();
					
			        this.OVERWEIGHT_TRAILER = dis.readInt();
					
			        this.ADDITIVE_OUT_OF_TOLERANCE = dis.readInt();
					
			        this.REQUIRES_CLEANLINE = dis.readInt();
					
			        this.FLUSH_ACTION = dis.readInt();
					
			        this.RFG_PRODUCT = dis.readInt();
					
			        this.LOAD_LIMIT = dis.readInt();
					
					this.ADDITIONAL_NOTES = readString(dis);
					
			        this.INCOMPATIBILITY_ACTION = dis.readInt();
					
			        this.DISPATCH_QUANTITY_TYPE = dis.readInt();
					
					this.BOL_NAME = readString(dis);
					
			        this.LOADING_QUANTITY_TYPE = dis.readInt();
					
			        this.PRICE_QUANTITY_TYPE = dis.readInt();
					
			        this.ETHANOL_EXPANSION = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_SUPPLIER_PRODUCT) {

        	try {

        		int length = 0;
		
						this.PRODUCT_COMMENT_SUPPLIER = readInteger(dis);
					
						this.HAZARD_SUPPLIER_NUMBER = readInteger(dis);
					
			        this.SUPPLIER_NUMBER = dis.readInt();
					
			        this.PRODUCT_NUMBER = dis.readInt();
					
					this.HAZARD_WARNING_CODE = readString(dis);
					
					this.NAME = readString(dis);
					
					this.PRODUCT_COMMENT_CODE = readString(dis);
					
					this.TERMINAL_HAZARD_WARNING = readString(dis);
					
					this.PRODUCT_GROUP_CODE = readString(dis);
					
					this.TERMINAL_PRODUCT_COMMENT = readString(dis);
					
					this.TABS_PRODUCT_CODE = readString(dis);
					
			        this.CLEAN_FUEL = dis.readInt();
					
						this.TABS_BLEND_INDICATOR = readInteger(dis);
					
			        this.ON_TRUCK_SEQUENTIAL_ENABLED = dis.readInt();
					
					this.TABS_PRODUCT_IDENTIFIER = readString(dis);
					
			        this.PRESET_SEQUENTIAL_ENABLED = dis.readInt();
					
			        this.RATIO_BLENDING_ENABLED = dis.readInt();
					
			        this.UPSTREAM_BLENDING_ENABLED = dis.readInt();
					
			        this.ENABLED = dis.readInt();
					
			        this.REQUIRES_INTERVENTION = dis.readInt();
					
			        this.BLEND_OUT_OF_TOLERANCE = dis.readInt();
					
			        this.PRICE = dis.readDouble();
					
					this.LAST_USER_NAME = readString(dis);
					
			        this.OCTANE = dis.readDouble();
					
					this.LAST_MODIFIED = readDate(dis);
					
					this.PETROEX_PRODUCT_CODE = readString(dis);
					
			        this.PETROEX_BLEND_INDICATOR = dis.readInt();
					
			        this.OVERWEIGHT_TRAILER = dis.readInt();
					
			        this.ADDITIVE_OUT_OF_TOLERANCE = dis.readInt();
					
			        this.REQUIRES_CLEANLINE = dis.readInt();
					
			        this.FLUSH_ACTION = dis.readInt();
					
			        this.RFG_PRODUCT = dis.readInt();
					
			        this.LOAD_LIMIT = dis.readInt();
					
					this.ADDITIONAL_NOTES = readString(dis);
					
			        this.INCOMPATIBILITY_ACTION = dis.readInt();
					
			        this.DISPATCH_QUANTITY_TYPE = dis.readInt();
					
					this.BOL_NAME = readString(dis);
					
			        this.LOADING_QUANTITY_TYPE = dis.readInt();
					
			        this.PRICE_QUANTITY_TYPE = dis.readInt();
					
			        this.ETHANOL_EXPANSION = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// Integer
				
						writeInteger(this.PRODUCT_COMMENT_SUPPLIER,dos);
					
					// Integer
				
						writeInteger(this.HAZARD_SUPPLIER_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.SUPPLIER_NUMBER);
					
					// int
				
		            	dos.writeInt(this.PRODUCT_NUMBER);
					
					// String
				
						writeString(this.HAZARD_WARNING_CODE,dos);
					
					// String
				
						writeString(this.NAME,dos);
					
					// String
				
						writeString(this.PRODUCT_COMMENT_CODE,dos);
					
					// String
				
						writeString(this.TERMINAL_HAZARD_WARNING,dos);
					
					// String
				
						writeString(this.PRODUCT_GROUP_CODE,dos);
					
					// String
				
						writeString(this.TERMINAL_PRODUCT_COMMENT,dos);
					
					// String
				
						writeString(this.TABS_PRODUCT_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.CLEAN_FUEL);
					
					// Integer
				
						writeInteger(this.TABS_BLEND_INDICATOR,dos);
					
					// int
				
		            	dos.writeInt(this.ON_TRUCK_SEQUENTIAL_ENABLED);
					
					// String
				
						writeString(this.TABS_PRODUCT_IDENTIFIER,dos);
					
					// int
				
		            	dos.writeInt(this.PRESET_SEQUENTIAL_ENABLED);
					
					// int
				
		            	dos.writeInt(this.RATIO_BLENDING_ENABLED);
					
					// int
				
		            	dos.writeInt(this.UPSTREAM_BLENDING_ENABLED);
					
					// int
				
		            	dos.writeInt(this.ENABLED);
					
					// int
				
		            	dos.writeInt(this.REQUIRES_INTERVENTION);
					
					// int
				
		            	dos.writeInt(this.BLEND_OUT_OF_TOLERANCE);
					
					// double
				
		            	dos.writeDouble(this.PRICE);
					
					// String
				
						writeString(this.LAST_USER_NAME,dos);
					
					// double
				
		            	dos.writeDouble(this.OCTANE);
					
					// java.util.Date
				
						writeDate(this.LAST_MODIFIED,dos);
					
					// String
				
						writeString(this.PETROEX_PRODUCT_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.PETROEX_BLEND_INDICATOR);
					
					// int
				
		            	dos.writeInt(this.OVERWEIGHT_TRAILER);
					
					// int
				
		            	dos.writeInt(this.ADDITIVE_OUT_OF_TOLERANCE);
					
					// int
				
		            	dos.writeInt(this.REQUIRES_CLEANLINE);
					
					// int
				
		            	dos.writeInt(this.FLUSH_ACTION);
					
					// int
				
		            	dos.writeInt(this.RFG_PRODUCT);
					
					// int
				
		            	dos.writeInt(this.LOAD_LIMIT);
					
					// String
				
						writeString(this.ADDITIONAL_NOTES,dos);
					
					// int
				
		            	dos.writeInt(this.INCOMPATIBILITY_ACTION);
					
					// int
				
		            	dos.writeInt(this.DISPATCH_QUANTITY_TYPE);
					
					// String
				
						writeString(this.BOL_NAME,dos);
					
					// int
				
		            	dos.writeInt(this.LOADING_QUANTITY_TYPE);
					
					// int
				
		            	dos.writeInt(this.PRICE_QUANTITY_TYPE);
					
					// int
				
		            	dos.writeInt(this.ETHANOL_EXPANSION);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Integer
				
						writeInteger(this.PRODUCT_COMMENT_SUPPLIER,dos);
					
					// Integer
				
						writeInteger(this.HAZARD_SUPPLIER_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.SUPPLIER_NUMBER);
					
					// int
				
		            	dos.writeInt(this.PRODUCT_NUMBER);
					
					// String
				
						writeString(this.HAZARD_WARNING_CODE,dos);
					
					// String
				
						writeString(this.NAME,dos);
					
					// String
				
						writeString(this.PRODUCT_COMMENT_CODE,dos);
					
					// String
				
						writeString(this.TERMINAL_HAZARD_WARNING,dos);
					
					// String
				
						writeString(this.PRODUCT_GROUP_CODE,dos);
					
					// String
				
						writeString(this.TERMINAL_PRODUCT_COMMENT,dos);
					
					// String
				
						writeString(this.TABS_PRODUCT_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.CLEAN_FUEL);
					
					// Integer
				
						writeInteger(this.TABS_BLEND_INDICATOR,dos);
					
					// int
				
		            	dos.writeInt(this.ON_TRUCK_SEQUENTIAL_ENABLED);
					
					// String
				
						writeString(this.TABS_PRODUCT_IDENTIFIER,dos);
					
					// int
				
		            	dos.writeInt(this.PRESET_SEQUENTIAL_ENABLED);
					
					// int
				
		            	dos.writeInt(this.RATIO_BLENDING_ENABLED);
					
					// int
				
		            	dos.writeInt(this.UPSTREAM_BLENDING_ENABLED);
					
					// int
				
		            	dos.writeInt(this.ENABLED);
					
					// int
				
		            	dos.writeInt(this.REQUIRES_INTERVENTION);
					
					// int
				
		            	dos.writeInt(this.BLEND_OUT_OF_TOLERANCE);
					
					// double
				
		            	dos.writeDouble(this.PRICE);
					
					// String
				
						writeString(this.LAST_USER_NAME,dos);
					
					// double
				
		            	dos.writeDouble(this.OCTANE);
					
					// java.util.Date
				
						writeDate(this.LAST_MODIFIED,dos);
					
					// String
				
						writeString(this.PETROEX_PRODUCT_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.PETROEX_BLEND_INDICATOR);
					
					// int
				
		            	dos.writeInt(this.OVERWEIGHT_TRAILER);
					
					// int
				
		            	dos.writeInt(this.ADDITIVE_OUT_OF_TOLERANCE);
					
					// int
				
		            	dos.writeInt(this.REQUIRES_CLEANLINE);
					
					// int
				
		            	dos.writeInt(this.FLUSH_ACTION);
					
					// int
				
		            	dos.writeInt(this.RFG_PRODUCT);
					
					// int
				
		            	dos.writeInt(this.LOAD_LIMIT);
					
					// String
				
						writeString(this.ADDITIONAL_NOTES,dos);
					
					// int
				
		            	dos.writeInt(this.INCOMPATIBILITY_ACTION);
					
					// int
				
		            	dos.writeInt(this.DISPATCH_QUANTITY_TYPE);
					
					// String
				
						writeString(this.BOL_NAME,dos);
					
					// int
				
		            	dos.writeInt(this.LOADING_QUANTITY_TYPE);
					
					// int
				
		            	dos.writeInt(this.PRICE_QUANTITY_TYPE);
					
					// int
				
		            	dos.writeInt(this.ETHANOL_EXPANSION);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("PRODUCT_COMMENT_SUPPLIER="+String.valueOf(PRODUCT_COMMENT_SUPPLIER));
		sb.append(",HAZARD_SUPPLIER_NUMBER="+String.valueOf(HAZARD_SUPPLIER_NUMBER));
		sb.append(",SUPPLIER_NUMBER="+String.valueOf(SUPPLIER_NUMBER));
		sb.append(",PRODUCT_NUMBER="+String.valueOf(PRODUCT_NUMBER));
		sb.append(",HAZARD_WARNING_CODE="+HAZARD_WARNING_CODE);
		sb.append(",NAME="+NAME);
		sb.append(",PRODUCT_COMMENT_CODE="+PRODUCT_COMMENT_CODE);
		sb.append(",TERMINAL_HAZARD_WARNING="+TERMINAL_HAZARD_WARNING);
		sb.append(",PRODUCT_GROUP_CODE="+PRODUCT_GROUP_CODE);
		sb.append(",TERMINAL_PRODUCT_COMMENT="+TERMINAL_PRODUCT_COMMENT);
		sb.append(",TABS_PRODUCT_CODE="+TABS_PRODUCT_CODE);
		sb.append(",CLEAN_FUEL="+String.valueOf(CLEAN_FUEL));
		sb.append(",TABS_BLEND_INDICATOR="+String.valueOf(TABS_BLEND_INDICATOR));
		sb.append(",ON_TRUCK_SEQUENTIAL_ENABLED="+String.valueOf(ON_TRUCK_SEQUENTIAL_ENABLED));
		sb.append(",TABS_PRODUCT_IDENTIFIER="+TABS_PRODUCT_IDENTIFIER);
		sb.append(",PRESET_SEQUENTIAL_ENABLED="+String.valueOf(PRESET_SEQUENTIAL_ENABLED));
		sb.append(",RATIO_BLENDING_ENABLED="+String.valueOf(RATIO_BLENDING_ENABLED));
		sb.append(",UPSTREAM_BLENDING_ENABLED="+String.valueOf(UPSTREAM_BLENDING_ENABLED));
		sb.append(",ENABLED="+String.valueOf(ENABLED));
		sb.append(",REQUIRES_INTERVENTION="+String.valueOf(REQUIRES_INTERVENTION));
		sb.append(",BLEND_OUT_OF_TOLERANCE="+String.valueOf(BLEND_OUT_OF_TOLERANCE));
		sb.append(",PRICE="+String.valueOf(PRICE));
		sb.append(",LAST_USER_NAME="+LAST_USER_NAME);
		sb.append(",OCTANE="+String.valueOf(OCTANE));
		sb.append(",LAST_MODIFIED="+String.valueOf(LAST_MODIFIED));
		sb.append(",PETROEX_PRODUCT_CODE="+PETROEX_PRODUCT_CODE);
		sb.append(",PETROEX_BLEND_INDICATOR="+String.valueOf(PETROEX_BLEND_INDICATOR));
		sb.append(",OVERWEIGHT_TRAILER="+String.valueOf(OVERWEIGHT_TRAILER));
		sb.append(",ADDITIVE_OUT_OF_TOLERANCE="+String.valueOf(ADDITIVE_OUT_OF_TOLERANCE));
		sb.append(",REQUIRES_CLEANLINE="+String.valueOf(REQUIRES_CLEANLINE));
		sb.append(",FLUSH_ACTION="+String.valueOf(FLUSH_ACTION));
		sb.append(",RFG_PRODUCT="+String.valueOf(RFG_PRODUCT));
		sb.append(",LOAD_LIMIT="+String.valueOf(LOAD_LIMIT));
		sb.append(",ADDITIONAL_NOTES="+ADDITIONAL_NOTES);
		sb.append(",INCOMPATIBILITY_ACTION="+String.valueOf(INCOMPATIBILITY_ACTION));
		sb.append(",DISPATCH_QUANTITY_TYPE="+String.valueOf(DISPATCH_QUANTITY_TYPE));
		sb.append(",BOL_NAME="+BOL_NAME);
		sb.append(",LOADING_QUANTITY_TYPE="+String.valueOf(LOADING_QUANTITY_TYPE));
		sb.append(",PRICE_QUANTITY_TYPE="+String.valueOf(PRICE_QUANTITY_TYPE));
		sb.append(",ETHANOL_EXPANSION="+String.valueOf(ETHANOL_EXPANSION));
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
    final static byte[] commonByteArrayLock_PGS_STAGE_DIM_SUPPLIER_PRODUCT = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_DIM_SUPPLIER_PRODUCT = new byte[0];

	
			    public Integer PRODUCT_COMMENT_SUPPLIER;

				public Integer getPRODUCT_COMMENT_SUPPLIER () {
					return this.PRODUCT_COMMENT_SUPPLIER;
				}
				
			    public Integer HAZARD_SUPPLIER_NUMBER;

				public Integer getHAZARD_SUPPLIER_NUMBER () {
					return this.HAZARD_SUPPLIER_NUMBER;
				}
				
			    public int SUPPLIER_NUMBER;

				public int getSUPPLIER_NUMBER () {
					return this.SUPPLIER_NUMBER;
				}
				
			    public int PRODUCT_NUMBER;

				public int getPRODUCT_NUMBER () {
					return this.PRODUCT_NUMBER;
				}
				
			    public String HAZARD_WARNING_CODE;

				public String getHAZARD_WARNING_CODE () {
					return this.HAZARD_WARNING_CODE;
				}
				
			    public String NAME;

				public String getNAME () {
					return this.NAME;
				}
				
			    public String PRODUCT_COMMENT_CODE;

				public String getPRODUCT_COMMENT_CODE () {
					return this.PRODUCT_COMMENT_CODE;
				}
				
			    public String TERMINAL_HAZARD_WARNING;

				public String getTERMINAL_HAZARD_WARNING () {
					return this.TERMINAL_HAZARD_WARNING;
				}
				
			    public String PRODUCT_GROUP_CODE;

				public String getPRODUCT_GROUP_CODE () {
					return this.PRODUCT_GROUP_CODE;
				}
				
			    public String TERMINAL_PRODUCT_COMMENT;

				public String getTERMINAL_PRODUCT_COMMENT () {
					return this.TERMINAL_PRODUCT_COMMENT;
				}
				
			    public String TABS_PRODUCT_CODE;

				public String getTABS_PRODUCT_CODE () {
					return this.TABS_PRODUCT_CODE;
				}
				
			    public int CLEAN_FUEL;

				public int getCLEAN_FUEL () {
					return this.CLEAN_FUEL;
				}
				
			    public Integer TABS_BLEND_INDICATOR;

				public Integer getTABS_BLEND_INDICATOR () {
					return this.TABS_BLEND_INDICATOR;
				}
				
			    public int ON_TRUCK_SEQUENTIAL_ENABLED;

				public int getON_TRUCK_SEQUENTIAL_ENABLED () {
					return this.ON_TRUCK_SEQUENTIAL_ENABLED;
				}
				
			    public String TABS_PRODUCT_IDENTIFIER;

				public String getTABS_PRODUCT_IDENTIFIER () {
					return this.TABS_PRODUCT_IDENTIFIER;
				}
				
			    public int PRESET_SEQUENTIAL_ENABLED;

				public int getPRESET_SEQUENTIAL_ENABLED () {
					return this.PRESET_SEQUENTIAL_ENABLED;
				}
				
			    public int RATIO_BLENDING_ENABLED;

				public int getRATIO_BLENDING_ENABLED () {
					return this.RATIO_BLENDING_ENABLED;
				}
				
			    public int UPSTREAM_BLENDING_ENABLED;

				public int getUPSTREAM_BLENDING_ENABLED () {
					return this.UPSTREAM_BLENDING_ENABLED;
				}
				
			    public int ENABLED;

				public int getENABLED () {
					return this.ENABLED;
				}
				
			    public int REQUIRES_INTERVENTION;

				public int getREQUIRES_INTERVENTION () {
					return this.REQUIRES_INTERVENTION;
				}
				
			    public int BLEND_OUT_OF_TOLERANCE;

				public int getBLEND_OUT_OF_TOLERANCE () {
					return this.BLEND_OUT_OF_TOLERANCE;
				}
				
			    public double PRICE;

				public double getPRICE () {
					return this.PRICE;
				}
				
			    public String LAST_USER_NAME;

				public String getLAST_USER_NAME () {
					return this.LAST_USER_NAME;
				}
				
			    public double OCTANE;

				public double getOCTANE () {
					return this.OCTANE;
				}
				
			    public java.util.Date LAST_MODIFIED;

				public java.util.Date getLAST_MODIFIED () {
					return this.LAST_MODIFIED;
				}
				
			    public String PETROEX_PRODUCT_CODE;

				public String getPETROEX_PRODUCT_CODE () {
					return this.PETROEX_PRODUCT_CODE;
				}
				
			    public int PETROEX_BLEND_INDICATOR;

				public int getPETROEX_BLEND_INDICATOR () {
					return this.PETROEX_BLEND_INDICATOR;
				}
				
			    public int OVERWEIGHT_TRAILER;

				public int getOVERWEIGHT_TRAILER () {
					return this.OVERWEIGHT_TRAILER;
				}
				
			    public int ADDITIVE_OUT_OF_TOLERANCE;

				public int getADDITIVE_OUT_OF_TOLERANCE () {
					return this.ADDITIVE_OUT_OF_TOLERANCE;
				}
				
			    public int REQUIRES_CLEANLINE;

				public int getREQUIRES_CLEANLINE () {
					return this.REQUIRES_CLEANLINE;
				}
				
			    public int FLUSH_ACTION;

				public int getFLUSH_ACTION () {
					return this.FLUSH_ACTION;
				}
				
			    public int RFG_PRODUCT;

				public int getRFG_PRODUCT () {
					return this.RFG_PRODUCT;
				}
				
			    public int LOAD_LIMIT;

				public int getLOAD_LIMIT () {
					return this.LOAD_LIMIT;
				}
				
			    public String ADDITIONAL_NOTES;

				public String getADDITIONAL_NOTES () {
					return this.ADDITIONAL_NOTES;
				}
				
			    public int INCOMPATIBILITY_ACTION;

				public int getINCOMPATIBILITY_ACTION () {
					return this.INCOMPATIBILITY_ACTION;
				}
				
			    public int DISPATCH_QUANTITY_TYPE;

				public int getDISPATCH_QUANTITY_TYPE () {
					return this.DISPATCH_QUANTITY_TYPE;
				}
				
			    public String BOL_NAME;

				public String getBOL_NAME () {
					return this.BOL_NAME;
				}
				
			    public int LOADING_QUANTITY_TYPE;

				public int getLOADING_QUANTITY_TYPE () {
					return this.LOADING_QUANTITY_TYPE;
				}
				
			    public int PRICE_QUANTITY_TYPE;

				public int getPRICE_QUANTITY_TYPE () {
					return this.PRICE_QUANTITY_TYPE;
				}
				
			    public int ETHANOL_EXPANSION;

				public int getETHANOL_EXPANSION () {
					return this.ETHANOL_EXPANSION;
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
			if(length > commonByteArray_PGS_STAGE_DIM_SUPPLIER_PRODUCT.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_SUPPLIER_PRODUCT.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_SUPPLIER_PRODUCT = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_SUPPLIER_PRODUCT = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PGS_STAGE_DIM_SUPPLIER_PRODUCT, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_SUPPLIER_PRODUCT, 0, length, utf8Charset);
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
			if(length > commonByteArray_PGS_STAGE_DIM_SUPPLIER_PRODUCT.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_SUPPLIER_PRODUCT.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_SUPPLIER_PRODUCT = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_SUPPLIER_PRODUCT = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PGS_STAGE_DIM_SUPPLIER_PRODUCT, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_SUPPLIER_PRODUCT, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_SUPPLIER_PRODUCT) {

        	try {

        		int length = 0;
		
						this.PRODUCT_COMMENT_SUPPLIER = readInteger(dis);
					
						this.HAZARD_SUPPLIER_NUMBER = readInteger(dis);
					
			        this.SUPPLIER_NUMBER = dis.readInt();
					
			        this.PRODUCT_NUMBER = dis.readInt();
					
					this.HAZARD_WARNING_CODE = readString(dis);
					
					this.NAME = readString(dis);
					
					this.PRODUCT_COMMENT_CODE = readString(dis);
					
					this.TERMINAL_HAZARD_WARNING = readString(dis);
					
					this.PRODUCT_GROUP_CODE = readString(dis);
					
					this.TERMINAL_PRODUCT_COMMENT = readString(dis);
					
					this.TABS_PRODUCT_CODE = readString(dis);
					
			        this.CLEAN_FUEL = dis.readInt();
					
						this.TABS_BLEND_INDICATOR = readInteger(dis);
					
			        this.ON_TRUCK_SEQUENTIAL_ENABLED = dis.readInt();
					
					this.TABS_PRODUCT_IDENTIFIER = readString(dis);
					
			        this.PRESET_SEQUENTIAL_ENABLED = dis.readInt();
					
			        this.RATIO_BLENDING_ENABLED = dis.readInt();
					
			        this.UPSTREAM_BLENDING_ENABLED = dis.readInt();
					
			        this.ENABLED = dis.readInt();
					
			        this.REQUIRES_INTERVENTION = dis.readInt();
					
			        this.BLEND_OUT_OF_TOLERANCE = dis.readInt();
					
			        this.PRICE = dis.readDouble();
					
					this.LAST_USER_NAME = readString(dis);
					
			        this.OCTANE = dis.readDouble();
					
					this.LAST_MODIFIED = readDate(dis);
					
					this.PETROEX_PRODUCT_CODE = readString(dis);
					
			        this.PETROEX_BLEND_INDICATOR = dis.readInt();
					
			        this.OVERWEIGHT_TRAILER = dis.readInt();
					
			        this.ADDITIVE_OUT_OF_TOLERANCE = dis.readInt();
					
			        this.REQUIRES_CLEANLINE = dis.readInt();
					
			        this.FLUSH_ACTION = dis.readInt();
					
			        this.RFG_PRODUCT = dis.readInt();
					
			        this.LOAD_LIMIT = dis.readInt();
					
					this.ADDITIONAL_NOTES = readString(dis);
					
			        this.INCOMPATIBILITY_ACTION = dis.readInt();
					
			        this.DISPATCH_QUANTITY_TYPE = dis.readInt();
					
					this.BOL_NAME = readString(dis);
					
			        this.LOADING_QUANTITY_TYPE = dis.readInt();
					
			        this.PRICE_QUANTITY_TYPE = dis.readInt();
					
			        this.ETHANOL_EXPANSION = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_SUPPLIER_PRODUCT) {

        	try {

        		int length = 0;
		
						this.PRODUCT_COMMENT_SUPPLIER = readInteger(dis);
					
						this.HAZARD_SUPPLIER_NUMBER = readInteger(dis);
					
			        this.SUPPLIER_NUMBER = dis.readInt();
					
			        this.PRODUCT_NUMBER = dis.readInt();
					
					this.HAZARD_WARNING_CODE = readString(dis);
					
					this.NAME = readString(dis);
					
					this.PRODUCT_COMMENT_CODE = readString(dis);
					
					this.TERMINAL_HAZARD_WARNING = readString(dis);
					
					this.PRODUCT_GROUP_CODE = readString(dis);
					
					this.TERMINAL_PRODUCT_COMMENT = readString(dis);
					
					this.TABS_PRODUCT_CODE = readString(dis);
					
			        this.CLEAN_FUEL = dis.readInt();
					
						this.TABS_BLEND_INDICATOR = readInteger(dis);
					
			        this.ON_TRUCK_SEQUENTIAL_ENABLED = dis.readInt();
					
					this.TABS_PRODUCT_IDENTIFIER = readString(dis);
					
			        this.PRESET_SEQUENTIAL_ENABLED = dis.readInt();
					
			        this.RATIO_BLENDING_ENABLED = dis.readInt();
					
			        this.UPSTREAM_BLENDING_ENABLED = dis.readInt();
					
			        this.ENABLED = dis.readInt();
					
			        this.REQUIRES_INTERVENTION = dis.readInt();
					
			        this.BLEND_OUT_OF_TOLERANCE = dis.readInt();
					
			        this.PRICE = dis.readDouble();
					
					this.LAST_USER_NAME = readString(dis);
					
			        this.OCTANE = dis.readDouble();
					
					this.LAST_MODIFIED = readDate(dis);
					
					this.PETROEX_PRODUCT_CODE = readString(dis);
					
			        this.PETROEX_BLEND_INDICATOR = dis.readInt();
					
			        this.OVERWEIGHT_TRAILER = dis.readInt();
					
			        this.ADDITIVE_OUT_OF_TOLERANCE = dis.readInt();
					
			        this.REQUIRES_CLEANLINE = dis.readInt();
					
			        this.FLUSH_ACTION = dis.readInt();
					
			        this.RFG_PRODUCT = dis.readInt();
					
			        this.LOAD_LIMIT = dis.readInt();
					
					this.ADDITIONAL_NOTES = readString(dis);
					
			        this.INCOMPATIBILITY_ACTION = dis.readInt();
					
			        this.DISPATCH_QUANTITY_TYPE = dis.readInt();
					
					this.BOL_NAME = readString(dis);
					
			        this.LOADING_QUANTITY_TYPE = dis.readInt();
					
			        this.PRICE_QUANTITY_TYPE = dis.readInt();
					
			        this.ETHANOL_EXPANSION = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// Integer
				
						writeInteger(this.PRODUCT_COMMENT_SUPPLIER,dos);
					
					// Integer
				
						writeInteger(this.HAZARD_SUPPLIER_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.SUPPLIER_NUMBER);
					
					// int
				
		            	dos.writeInt(this.PRODUCT_NUMBER);
					
					// String
				
						writeString(this.HAZARD_WARNING_CODE,dos);
					
					// String
				
						writeString(this.NAME,dos);
					
					// String
				
						writeString(this.PRODUCT_COMMENT_CODE,dos);
					
					// String
				
						writeString(this.TERMINAL_HAZARD_WARNING,dos);
					
					// String
				
						writeString(this.PRODUCT_GROUP_CODE,dos);
					
					// String
				
						writeString(this.TERMINAL_PRODUCT_COMMENT,dos);
					
					// String
				
						writeString(this.TABS_PRODUCT_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.CLEAN_FUEL);
					
					// Integer
				
						writeInteger(this.TABS_BLEND_INDICATOR,dos);
					
					// int
				
		            	dos.writeInt(this.ON_TRUCK_SEQUENTIAL_ENABLED);
					
					// String
				
						writeString(this.TABS_PRODUCT_IDENTIFIER,dos);
					
					// int
				
		            	dos.writeInt(this.PRESET_SEQUENTIAL_ENABLED);
					
					// int
				
		            	dos.writeInt(this.RATIO_BLENDING_ENABLED);
					
					// int
				
		            	dos.writeInt(this.UPSTREAM_BLENDING_ENABLED);
					
					// int
				
		            	dos.writeInt(this.ENABLED);
					
					// int
				
		            	dos.writeInt(this.REQUIRES_INTERVENTION);
					
					// int
				
		            	dos.writeInt(this.BLEND_OUT_OF_TOLERANCE);
					
					// double
				
		            	dos.writeDouble(this.PRICE);
					
					// String
				
						writeString(this.LAST_USER_NAME,dos);
					
					// double
				
		            	dos.writeDouble(this.OCTANE);
					
					// java.util.Date
				
						writeDate(this.LAST_MODIFIED,dos);
					
					// String
				
						writeString(this.PETROEX_PRODUCT_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.PETROEX_BLEND_INDICATOR);
					
					// int
				
		            	dos.writeInt(this.OVERWEIGHT_TRAILER);
					
					// int
				
		            	dos.writeInt(this.ADDITIVE_OUT_OF_TOLERANCE);
					
					// int
				
		            	dos.writeInt(this.REQUIRES_CLEANLINE);
					
					// int
				
		            	dos.writeInt(this.FLUSH_ACTION);
					
					// int
				
		            	dos.writeInt(this.RFG_PRODUCT);
					
					// int
				
		            	dos.writeInt(this.LOAD_LIMIT);
					
					// String
				
						writeString(this.ADDITIONAL_NOTES,dos);
					
					// int
				
		            	dos.writeInt(this.INCOMPATIBILITY_ACTION);
					
					// int
				
		            	dos.writeInt(this.DISPATCH_QUANTITY_TYPE);
					
					// String
				
						writeString(this.BOL_NAME,dos);
					
					// int
				
		            	dos.writeInt(this.LOADING_QUANTITY_TYPE);
					
					// int
				
		            	dos.writeInt(this.PRICE_QUANTITY_TYPE);
					
					// int
				
		            	dos.writeInt(this.ETHANOL_EXPANSION);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Integer
				
						writeInteger(this.PRODUCT_COMMENT_SUPPLIER,dos);
					
					// Integer
				
						writeInteger(this.HAZARD_SUPPLIER_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.SUPPLIER_NUMBER);
					
					// int
				
		            	dos.writeInt(this.PRODUCT_NUMBER);
					
					// String
				
						writeString(this.HAZARD_WARNING_CODE,dos);
					
					// String
				
						writeString(this.NAME,dos);
					
					// String
				
						writeString(this.PRODUCT_COMMENT_CODE,dos);
					
					// String
				
						writeString(this.TERMINAL_HAZARD_WARNING,dos);
					
					// String
				
						writeString(this.PRODUCT_GROUP_CODE,dos);
					
					// String
				
						writeString(this.TERMINAL_PRODUCT_COMMENT,dos);
					
					// String
				
						writeString(this.TABS_PRODUCT_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.CLEAN_FUEL);
					
					// Integer
				
						writeInteger(this.TABS_BLEND_INDICATOR,dos);
					
					// int
				
		            	dos.writeInt(this.ON_TRUCK_SEQUENTIAL_ENABLED);
					
					// String
				
						writeString(this.TABS_PRODUCT_IDENTIFIER,dos);
					
					// int
				
		            	dos.writeInt(this.PRESET_SEQUENTIAL_ENABLED);
					
					// int
				
		            	dos.writeInt(this.RATIO_BLENDING_ENABLED);
					
					// int
				
		            	dos.writeInt(this.UPSTREAM_BLENDING_ENABLED);
					
					// int
				
		            	dos.writeInt(this.ENABLED);
					
					// int
				
		            	dos.writeInt(this.REQUIRES_INTERVENTION);
					
					// int
				
		            	dos.writeInt(this.BLEND_OUT_OF_TOLERANCE);
					
					// double
				
		            	dos.writeDouble(this.PRICE);
					
					// String
				
						writeString(this.LAST_USER_NAME,dos);
					
					// double
				
		            	dos.writeDouble(this.OCTANE);
					
					// java.util.Date
				
						writeDate(this.LAST_MODIFIED,dos);
					
					// String
				
						writeString(this.PETROEX_PRODUCT_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.PETROEX_BLEND_INDICATOR);
					
					// int
				
		            	dos.writeInt(this.OVERWEIGHT_TRAILER);
					
					// int
				
		            	dos.writeInt(this.ADDITIVE_OUT_OF_TOLERANCE);
					
					// int
				
		            	dos.writeInt(this.REQUIRES_CLEANLINE);
					
					// int
				
		            	dos.writeInt(this.FLUSH_ACTION);
					
					// int
				
		            	dos.writeInt(this.RFG_PRODUCT);
					
					// int
				
		            	dos.writeInt(this.LOAD_LIMIT);
					
					// String
				
						writeString(this.ADDITIONAL_NOTES,dos);
					
					// int
				
		            	dos.writeInt(this.INCOMPATIBILITY_ACTION);
					
					// int
				
		            	dos.writeInt(this.DISPATCH_QUANTITY_TYPE);
					
					// String
				
						writeString(this.BOL_NAME,dos);
					
					// int
				
		            	dos.writeInt(this.LOADING_QUANTITY_TYPE);
					
					// int
				
		            	dos.writeInt(this.PRICE_QUANTITY_TYPE);
					
					// int
				
		            	dos.writeInt(this.ETHANOL_EXPANSION);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("PRODUCT_COMMENT_SUPPLIER="+String.valueOf(PRODUCT_COMMENT_SUPPLIER));
		sb.append(",HAZARD_SUPPLIER_NUMBER="+String.valueOf(HAZARD_SUPPLIER_NUMBER));
		sb.append(",SUPPLIER_NUMBER="+String.valueOf(SUPPLIER_NUMBER));
		sb.append(",PRODUCT_NUMBER="+String.valueOf(PRODUCT_NUMBER));
		sb.append(",HAZARD_WARNING_CODE="+HAZARD_WARNING_CODE);
		sb.append(",NAME="+NAME);
		sb.append(",PRODUCT_COMMENT_CODE="+PRODUCT_COMMENT_CODE);
		sb.append(",TERMINAL_HAZARD_WARNING="+TERMINAL_HAZARD_WARNING);
		sb.append(",PRODUCT_GROUP_CODE="+PRODUCT_GROUP_CODE);
		sb.append(",TERMINAL_PRODUCT_COMMENT="+TERMINAL_PRODUCT_COMMENT);
		sb.append(",TABS_PRODUCT_CODE="+TABS_PRODUCT_CODE);
		sb.append(",CLEAN_FUEL="+String.valueOf(CLEAN_FUEL));
		sb.append(",TABS_BLEND_INDICATOR="+String.valueOf(TABS_BLEND_INDICATOR));
		sb.append(",ON_TRUCK_SEQUENTIAL_ENABLED="+String.valueOf(ON_TRUCK_SEQUENTIAL_ENABLED));
		sb.append(",TABS_PRODUCT_IDENTIFIER="+TABS_PRODUCT_IDENTIFIER);
		sb.append(",PRESET_SEQUENTIAL_ENABLED="+String.valueOf(PRESET_SEQUENTIAL_ENABLED));
		sb.append(",RATIO_BLENDING_ENABLED="+String.valueOf(RATIO_BLENDING_ENABLED));
		sb.append(",UPSTREAM_BLENDING_ENABLED="+String.valueOf(UPSTREAM_BLENDING_ENABLED));
		sb.append(",ENABLED="+String.valueOf(ENABLED));
		sb.append(",REQUIRES_INTERVENTION="+String.valueOf(REQUIRES_INTERVENTION));
		sb.append(",BLEND_OUT_OF_TOLERANCE="+String.valueOf(BLEND_OUT_OF_TOLERANCE));
		sb.append(",PRICE="+String.valueOf(PRICE));
		sb.append(",LAST_USER_NAME="+LAST_USER_NAME);
		sb.append(",OCTANE="+String.valueOf(OCTANE));
		sb.append(",LAST_MODIFIED="+String.valueOf(LAST_MODIFIED));
		sb.append(",PETROEX_PRODUCT_CODE="+PETROEX_PRODUCT_CODE);
		sb.append(",PETROEX_BLEND_INDICATOR="+String.valueOf(PETROEX_BLEND_INDICATOR));
		sb.append(",OVERWEIGHT_TRAILER="+String.valueOf(OVERWEIGHT_TRAILER));
		sb.append(",ADDITIVE_OUT_OF_TOLERANCE="+String.valueOf(ADDITIVE_OUT_OF_TOLERANCE));
		sb.append(",REQUIRES_CLEANLINE="+String.valueOf(REQUIRES_CLEANLINE));
		sb.append(",FLUSH_ACTION="+String.valueOf(FLUSH_ACTION));
		sb.append(",RFG_PRODUCT="+String.valueOf(RFG_PRODUCT));
		sb.append(",LOAD_LIMIT="+String.valueOf(LOAD_LIMIT));
		sb.append(",ADDITIONAL_NOTES="+ADDITIONAL_NOTES);
		sb.append(",INCOMPATIBILITY_ACTION="+String.valueOf(INCOMPATIBILITY_ACTION));
		sb.append(",DISPATCH_QUANTITY_TYPE="+String.valueOf(DISPATCH_QUANTITY_TYPE));
		sb.append(",BOL_NAME="+BOL_NAME);
		sb.append(",LOADING_QUANTITY_TYPE="+String.valueOf(LOADING_QUANTITY_TYPE));
		sb.append(",PRICE_QUANTITY_TYPE="+String.valueOf(PRICE_QUANTITY_TYPE));
		sb.append(",ETHANOL_EXPANSION="+String.valueOf(ETHANOL_EXPANSION));
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
    final static byte[] commonByteArrayLock_PGS_STAGE_DIM_SUPPLIER_PRODUCT = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_DIM_SUPPLIER_PRODUCT = new byte[0];

	
			    public Integer PRODUCT_COMMENT_SUPPLIER;

				public Integer getPRODUCT_COMMENT_SUPPLIER () {
					return this.PRODUCT_COMMENT_SUPPLIER;
				}
				
			    public Integer HAZARD_SUPPLIER_NUMBER;

				public Integer getHAZARD_SUPPLIER_NUMBER () {
					return this.HAZARD_SUPPLIER_NUMBER;
				}
				
			    public int SUPPLIER_NUMBER;

				public int getSUPPLIER_NUMBER () {
					return this.SUPPLIER_NUMBER;
				}
				
			    public int PRODUCT_NUMBER;

				public int getPRODUCT_NUMBER () {
					return this.PRODUCT_NUMBER;
				}
				
			    public String HAZARD_WARNING_CODE;

				public String getHAZARD_WARNING_CODE () {
					return this.HAZARD_WARNING_CODE;
				}
				
			    public String NAME;

				public String getNAME () {
					return this.NAME;
				}
				
			    public String PRODUCT_COMMENT_CODE;

				public String getPRODUCT_COMMENT_CODE () {
					return this.PRODUCT_COMMENT_CODE;
				}
				
			    public String TERMINAL_HAZARD_WARNING;

				public String getTERMINAL_HAZARD_WARNING () {
					return this.TERMINAL_HAZARD_WARNING;
				}
				
			    public String PRODUCT_GROUP_CODE;

				public String getPRODUCT_GROUP_CODE () {
					return this.PRODUCT_GROUP_CODE;
				}
				
			    public String TERMINAL_PRODUCT_COMMENT;

				public String getTERMINAL_PRODUCT_COMMENT () {
					return this.TERMINAL_PRODUCT_COMMENT;
				}
				
			    public String TABS_PRODUCT_CODE;

				public String getTABS_PRODUCT_CODE () {
					return this.TABS_PRODUCT_CODE;
				}
				
			    public int CLEAN_FUEL;

				public int getCLEAN_FUEL () {
					return this.CLEAN_FUEL;
				}
				
			    public Integer TABS_BLEND_INDICATOR;

				public Integer getTABS_BLEND_INDICATOR () {
					return this.TABS_BLEND_INDICATOR;
				}
				
			    public int ON_TRUCK_SEQUENTIAL_ENABLED;

				public int getON_TRUCK_SEQUENTIAL_ENABLED () {
					return this.ON_TRUCK_SEQUENTIAL_ENABLED;
				}
				
			    public String TABS_PRODUCT_IDENTIFIER;

				public String getTABS_PRODUCT_IDENTIFIER () {
					return this.TABS_PRODUCT_IDENTIFIER;
				}
				
			    public int PRESET_SEQUENTIAL_ENABLED;

				public int getPRESET_SEQUENTIAL_ENABLED () {
					return this.PRESET_SEQUENTIAL_ENABLED;
				}
				
			    public int RATIO_BLENDING_ENABLED;

				public int getRATIO_BLENDING_ENABLED () {
					return this.RATIO_BLENDING_ENABLED;
				}
				
			    public int UPSTREAM_BLENDING_ENABLED;

				public int getUPSTREAM_BLENDING_ENABLED () {
					return this.UPSTREAM_BLENDING_ENABLED;
				}
				
			    public int ENABLED;

				public int getENABLED () {
					return this.ENABLED;
				}
				
			    public int REQUIRES_INTERVENTION;

				public int getREQUIRES_INTERVENTION () {
					return this.REQUIRES_INTERVENTION;
				}
				
			    public int BLEND_OUT_OF_TOLERANCE;

				public int getBLEND_OUT_OF_TOLERANCE () {
					return this.BLEND_OUT_OF_TOLERANCE;
				}
				
			    public double PRICE;

				public double getPRICE () {
					return this.PRICE;
				}
				
			    public String LAST_USER_NAME;

				public String getLAST_USER_NAME () {
					return this.LAST_USER_NAME;
				}
				
			    public double OCTANE;

				public double getOCTANE () {
					return this.OCTANE;
				}
				
			    public java.util.Date LAST_MODIFIED;

				public java.util.Date getLAST_MODIFIED () {
					return this.LAST_MODIFIED;
				}
				
			    public String PETROEX_PRODUCT_CODE;

				public String getPETROEX_PRODUCT_CODE () {
					return this.PETROEX_PRODUCT_CODE;
				}
				
			    public int PETROEX_BLEND_INDICATOR;

				public int getPETROEX_BLEND_INDICATOR () {
					return this.PETROEX_BLEND_INDICATOR;
				}
				
			    public int OVERWEIGHT_TRAILER;

				public int getOVERWEIGHT_TRAILER () {
					return this.OVERWEIGHT_TRAILER;
				}
				
			    public int ADDITIVE_OUT_OF_TOLERANCE;

				public int getADDITIVE_OUT_OF_TOLERANCE () {
					return this.ADDITIVE_OUT_OF_TOLERANCE;
				}
				
			    public int REQUIRES_CLEANLINE;

				public int getREQUIRES_CLEANLINE () {
					return this.REQUIRES_CLEANLINE;
				}
				
			    public int FLUSH_ACTION;

				public int getFLUSH_ACTION () {
					return this.FLUSH_ACTION;
				}
				
			    public int RFG_PRODUCT;

				public int getRFG_PRODUCT () {
					return this.RFG_PRODUCT;
				}
				
			    public int LOAD_LIMIT;

				public int getLOAD_LIMIT () {
					return this.LOAD_LIMIT;
				}
				
			    public String ADDITIONAL_NOTES;

				public String getADDITIONAL_NOTES () {
					return this.ADDITIONAL_NOTES;
				}
				
			    public int INCOMPATIBILITY_ACTION;

				public int getINCOMPATIBILITY_ACTION () {
					return this.INCOMPATIBILITY_ACTION;
				}
				
			    public int DISPATCH_QUANTITY_TYPE;

				public int getDISPATCH_QUANTITY_TYPE () {
					return this.DISPATCH_QUANTITY_TYPE;
				}
				
			    public String BOL_NAME;

				public String getBOL_NAME () {
					return this.BOL_NAME;
				}
				
			    public int LOADING_QUANTITY_TYPE;

				public int getLOADING_QUANTITY_TYPE () {
					return this.LOADING_QUANTITY_TYPE;
				}
				
			    public int PRICE_QUANTITY_TYPE;

				public int getPRICE_QUANTITY_TYPE () {
					return this.PRICE_QUANTITY_TYPE;
				}
				
			    public int ETHANOL_EXPANSION;

				public int getETHANOL_EXPANSION () {
					return this.ETHANOL_EXPANSION;
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
			if(length > commonByteArray_PGS_STAGE_DIM_SUPPLIER_PRODUCT.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_SUPPLIER_PRODUCT.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_SUPPLIER_PRODUCT = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_SUPPLIER_PRODUCT = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PGS_STAGE_DIM_SUPPLIER_PRODUCT, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_SUPPLIER_PRODUCT, 0, length, utf8Charset);
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
			if(length > commonByteArray_PGS_STAGE_DIM_SUPPLIER_PRODUCT.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_SUPPLIER_PRODUCT.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_SUPPLIER_PRODUCT = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_SUPPLIER_PRODUCT = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PGS_STAGE_DIM_SUPPLIER_PRODUCT, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_SUPPLIER_PRODUCT, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_SUPPLIER_PRODUCT) {

        	try {

        		int length = 0;
		
						this.PRODUCT_COMMENT_SUPPLIER = readInteger(dis);
					
						this.HAZARD_SUPPLIER_NUMBER = readInteger(dis);
					
			        this.SUPPLIER_NUMBER = dis.readInt();
					
			        this.PRODUCT_NUMBER = dis.readInt();
					
					this.HAZARD_WARNING_CODE = readString(dis);
					
					this.NAME = readString(dis);
					
					this.PRODUCT_COMMENT_CODE = readString(dis);
					
					this.TERMINAL_HAZARD_WARNING = readString(dis);
					
					this.PRODUCT_GROUP_CODE = readString(dis);
					
					this.TERMINAL_PRODUCT_COMMENT = readString(dis);
					
					this.TABS_PRODUCT_CODE = readString(dis);
					
			        this.CLEAN_FUEL = dis.readInt();
					
						this.TABS_BLEND_INDICATOR = readInteger(dis);
					
			        this.ON_TRUCK_SEQUENTIAL_ENABLED = dis.readInt();
					
					this.TABS_PRODUCT_IDENTIFIER = readString(dis);
					
			        this.PRESET_SEQUENTIAL_ENABLED = dis.readInt();
					
			        this.RATIO_BLENDING_ENABLED = dis.readInt();
					
			        this.UPSTREAM_BLENDING_ENABLED = dis.readInt();
					
			        this.ENABLED = dis.readInt();
					
			        this.REQUIRES_INTERVENTION = dis.readInt();
					
			        this.BLEND_OUT_OF_TOLERANCE = dis.readInt();
					
			        this.PRICE = dis.readDouble();
					
					this.LAST_USER_NAME = readString(dis);
					
			        this.OCTANE = dis.readDouble();
					
					this.LAST_MODIFIED = readDate(dis);
					
					this.PETROEX_PRODUCT_CODE = readString(dis);
					
			        this.PETROEX_BLEND_INDICATOR = dis.readInt();
					
			        this.OVERWEIGHT_TRAILER = dis.readInt();
					
			        this.ADDITIVE_OUT_OF_TOLERANCE = dis.readInt();
					
			        this.REQUIRES_CLEANLINE = dis.readInt();
					
			        this.FLUSH_ACTION = dis.readInt();
					
			        this.RFG_PRODUCT = dis.readInt();
					
			        this.LOAD_LIMIT = dis.readInt();
					
					this.ADDITIONAL_NOTES = readString(dis);
					
			        this.INCOMPATIBILITY_ACTION = dis.readInt();
					
			        this.DISPATCH_QUANTITY_TYPE = dis.readInt();
					
					this.BOL_NAME = readString(dis);
					
			        this.LOADING_QUANTITY_TYPE = dis.readInt();
					
			        this.PRICE_QUANTITY_TYPE = dis.readInt();
					
			        this.ETHANOL_EXPANSION = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_SUPPLIER_PRODUCT) {

        	try {

        		int length = 0;
		
						this.PRODUCT_COMMENT_SUPPLIER = readInteger(dis);
					
						this.HAZARD_SUPPLIER_NUMBER = readInteger(dis);
					
			        this.SUPPLIER_NUMBER = dis.readInt();
					
			        this.PRODUCT_NUMBER = dis.readInt();
					
					this.HAZARD_WARNING_CODE = readString(dis);
					
					this.NAME = readString(dis);
					
					this.PRODUCT_COMMENT_CODE = readString(dis);
					
					this.TERMINAL_HAZARD_WARNING = readString(dis);
					
					this.PRODUCT_GROUP_CODE = readString(dis);
					
					this.TERMINAL_PRODUCT_COMMENT = readString(dis);
					
					this.TABS_PRODUCT_CODE = readString(dis);
					
			        this.CLEAN_FUEL = dis.readInt();
					
						this.TABS_BLEND_INDICATOR = readInteger(dis);
					
			        this.ON_TRUCK_SEQUENTIAL_ENABLED = dis.readInt();
					
					this.TABS_PRODUCT_IDENTIFIER = readString(dis);
					
			        this.PRESET_SEQUENTIAL_ENABLED = dis.readInt();
					
			        this.RATIO_BLENDING_ENABLED = dis.readInt();
					
			        this.UPSTREAM_BLENDING_ENABLED = dis.readInt();
					
			        this.ENABLED = dis.readInt();
					
			        this.REQUIRES_INTERVENTION = dis.readInt();
					
			        this.BLEND_OUT_OF_TOLERANCE = dis.readInt();
					
			        this.PRICE = dis.readDouble();
					
					this.LAST_USER_NAME = readString(dis);
					
			        this.OCTANE = dis.readDouble();
					
					this.LAST_MODIFIED = readDate(dis);
					
					this.PETROEX_PRODUCT_CODE = readString(dis);
					
			        this.PETROEX_BLEND_INDICATOR = dis.readInt();
					
			        this.OVERWEIGHT_TRAILER = dis.readInt();
					
			        this.ADDITIVE_OUT_OF_TOLERANCE = dis.readInt();
					
			        this.REQUIRES_CLEANLINE = dis.readInt();
					
			        this.FLUSH_ACTION = dis.readInt();
					
			        this.RFG_PRODUCT = dis.readInt();
					
			        this.LOAD_LIMIT = dis.readInt();
					
					this.ADDITIONAL_NOTES = readString(dis);
					
			        this.INCOMPATIBILITY_ACTION = dis.readInt();
					
			        this.DISPATCH_QUANTITY_TYPE = dis.readInt();
					
					this.BOL_NAME = readString(dis);
					
			        this.LOADING_QUANTITY_TYPE = dis.readInt();
					
			        this.PRICE_QUANTITY_TYPE = dis.readInt();
					
			        this.ETHANOL_EXPANSION = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// Integer
				
						writeInteger(this.PRODUCT_COMMENT_SUPPLIER,dos);
					
					// Integer
				
						writeInteger(this.HAZARD_SUPPLIER_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.SUPPLIER_NUMBER);
					
					// int
				
		            	dos.writeInt(this.PRODUCT_NUMBER);
					
					// String
				
						writeString(this.HAZARD_WARNING_CODE,dos);
					
					// String
				
						writeString(this.NAME,dos);
					
					// String
				
						writeString(this.PRODUCT_COMMENT_CODE,dos);
					
					// String
				
						writeString(this.TERMINAL_HAZARD_WARNING,dos);
					
					// String
				
						writeString(this.PRODUCT_GROUP_CODE,dos);
					
					// String
				
						writeString(this.TERMINAL_PRODUCT_COMMENT,dos);
					
					// String
				
						writeString(this.TABS_PRODUCT_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.CLEAN_FUEL);
					
					// Integer
				
						writeInteger(this.TABS_BLEND_INDICATOR,dos);
					
					// int
				
		            	dos.writeInt(this.ON_TRUCK_SEQUENTIAL_ENABLED);
					
					// String
				
						writeString(this.TABS_PRODUCT_IDENTIFIER,dos);
					
					// int
				
		            	dos.writeInt(this.PRESET_SEQUENTIAL_ENABLED);
					
					// int
				
		            	dos.writeInt(this.RATIO_BLENDING_ENABLED);
					
					// int
				
		            	dos.writeInt(this.UPSTREAM_BLENDING_ENABLED);
					
					// int
				
		            	dos.writeInt(this.ENABLED);
					
					// int
				
		            	dos.writeInt(this.REQUIRES_INTERVENTION);
					
					// int
				
		            	dos.writeInt(this.BLEND_OUT_OF_TOLERANCE);
					
					// double
				
		            	dos.writeDouble(this.PRICE);
					
					// String
				
						writeString(this.LAST_USER_NAME,dos);
					
					// double
				
		            	dos.writeDouble(this.OCTANE);
					
					// java.util.Date
				
						writeDate(this.LAST_MODIFIED,dos);
					
					// String
				
						writeString(this.PETROEX_PRODUCT_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.PETROEX_BLEND_INDICATOR);
					
					// int
				
		            	dos.writeInt(this.OVERWEIGHT_TRAILER);
					
					// int
				
		            	dos.writeInt(this.ADDITIVE_OUT_OF_TOLERANCE);
					
					// int
				
		            	dos.writeInt(this.REQUIRES_CLEANLINE);
					
					// int
				
		            	dos.writeInt(this.FLUSH_ACTION);
					
					// int
				
		            	dos.writeInt(this.RFG_PRODUCT);
					
					// int
				
		            	dos.writeInt(this.LOAD_LIMIT);
					
					// String
				
						writeString(this.ADDITIONAL_NOTES,dos);
					
					// int
				
		            	dos.writeInt(this.INCOMPATIBILITY_ACTION);
					
					// int
				
		            	dos.writeInt(this.DISPATCH_QUANTITY_TYPE);
					
					// String
				
						writeString(this.BOL_NAME,dos);
					
					// int
				
		            	dos.writeInt(this.LOADING_QUANTITY_TYPE);
					
					// int
				
		            	dos.writeInt(this.PRICE_QUANTITY_TYPE);
					
					// int
				
		            	dos.writeInt(this.ETHANOL_EXPANSION);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Integer
				
						writeInteger(this.PRODUCT_COMMENT_SUPPLIER,dos);
					
					// Integer
				
						writeInteger(this.HAZARD_SUPPLIER_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.SUPPLIER_NUMBER);
					
					// int
				
		            	dos.writeInt(this.PRODUCT_NUMBER);
					
					// String
				
						writeString(this.HAZARD_WARNING_CODE,dos);
					
					// String
				
						writeString(this.NAME,dos);
					
					// String
				
						writeString(this.PRODUCT_COMMENT_CODE,dos);
					
					// String
				
						writeString(this.TERMINAL_HAZARD_WARNING,dos);
					
					// String
				
						writeString(this.PRODUCT_GROUP_CODE,dos);
					
					// String
				
						writeString(this.TERMINAL_PRODUCT_COMMENT,dos);
					
					// String
				
						writeString(this.TABS_PRODUCT_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.CLEAN_FUEL);
					
					// Integer
				
						writeInteger(this.TABS_BLEND_INDICATOR,dos);
					
					// int
				
		            	dos.writeInt(this.ON_TRUCK_SEQUENTIAL_ENABLED);
					
					// String
				
						writeString(this.TABS_PRODUCT_IDENTIFIER,dos);
					
					// int
				
		            	dos.writeInt(this.PRESET_SEQUENTIAL_ENABLED);
					
					// int
				
		            	dos.writeInt(this.RATIO_BLENDING_ENABLED);
					
					// int
				
		            	dos.writeInt(this.UPSTREAM_BLENDING_ENABLED);
					
					// int
				
		            	dos.writeInt(this.ENABLED);
					
					// int
				
		            	dos.writeInt(this.REQUIRES_INTERVENTION);
					
					// int
				
		            	dos.writeInt(this.BLEND_OUT_OF_TOLERANCE);
					
					// double
				
		            	dos.writeDouble(this.PRICE);
					
					// String
				
						writeString(this.LAST_USER_NAME,dos);
					
					// double
				
		            	dos.writeDouble(this.OCTANE);
					
					// java.util.Date
				
						writeDate(this.LAST_MODIFIED,dos);
					
					// String
				
						writeString(this.PETROEX_PRODUCT_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.PETROEX_BLEND_INDICATOR);
					
					// int
				
		            	dos.writeInt(this.OVERWEIGHT_TRAILER);
					
					// int
				
		            	dos.writeInt(this.ADDITIVE_OUT_OF_TOLERANCE);
					
					// int
				
		            	dos.writeInt(this.REQUIRES_CLEANLINE);
					
					// int
				
		            	dos.writeInt(this.FLUSH_ACTION);
					
					// int
				
		            	dos.writeInt(this.RFG_PRODUCT);
					
					// int
				
		            	dos.writeInt(this.LOAD_LIMIT);
					
					// String
				
						writeString(this.ADDITIONAL_NOTES,dos);
					
					// int
				
		            	dos.writeInt(this.INCOMPATIBILITY_ACTION);
					
					// int
				
		            	dos.writeInt(this.DISPATCH_QUANTITY_TYPE);
					
					// String
				
						writeString(this.BOL_NAME,dos);
					
					// int
				
		            	dos.writeInt(this.LOADING_QUANTITY_TYPE);
					
					// int
				
		            	dos.writeInt(this.PRICE_QUANTITY_TYPE);
					
					// int
				
		            	dos.writeInt(this.ETHANOL_EXPANSION);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("PRODUCT_COMMENT_SUPPLIER="+String.valueOf(PRODUCT_COMMENT_SUPPLIER));
		sb.append(",HAZARD_SUPPLIER_NUMBER="+String.valueOf(HAZARD_SUPPLIER_NUMBER));
		sb.append(",SUPPLIER_NUMBER="+String.valueOf(SUPPLIER_NUMBER));
		sb.append(",PRODUCT_NUMBER="+String.valueOf(PRODUCT_NUMBER));
		sb.append(",HAZARD_WARNING_CODE="+HAZARD_WARNING_CODE);
		sb.append(",NAME="+NAME);
		sb.append(",PRODUCT_COMMENT_CODE="+PRODUCT_COMMENT_CODE);
		sb.append(",TERMINAL_HAZARD_WARNING="+TERMINAL_HAZARD_WARNING);
		sb.append(",PRODUCT_GROUP_CODE="+PRODUCT_GROUP_CODE);
		sb.append(",TERMINAL_PRODUCT_COMMENT="+TERMINAL_PRODUCT_COMMENT);
		sb.append(",TABS_PRODUCT_CODE="+TABS_PRODUCT_CODE);
		sb.append(",CLEAN_FUEL="+String.valueOf(CLEAN_FUEL));
		sb.append(",TABS_BLEND_INDICATOR="+String.valueOf(TABS_BLEND_INDICATOR));
		sb.append(",ON_TRUCK_SEQUENTIAL_ENABLED="+String.valueOf(ON_TRUCK_SEQUENTIAL_ENABLED));
		sb.append(",TABS_PRODUCT_IDENTIFIER="+TABS_PRODUCT_IDENTIFIER);
		sb.append(",PRESET_SEQUENTIAL_ENABLED="+String.valueOf(PRESET_SEQUENTIAL_ENABLED));
		sb.append(",RATIO_BLENDING_ENABLED="+String.valueOf(RATIO_BLENDING_ENABLED));
		sb.append(",UPSTREAM_BLENDING_ENABLED="+String.valueOf(UPSTREAM_BLENDING_ENABLED));
		sb.append(",ENABLED="+String.valueOf(ENABLED));
		sb.append(",REQUIRES_INTERVENTION="+String.valueOf(REQUIRES_INTERVENTION));
		sb.append(",BLEND_OUT_OF_TOLERANCE="+String.valueOf(BLEND_OUT_OF_TOLERANCE));
		sb.append(",PRICE="+String.valueOf(PRICE));
		sb.append(",LAST_USER_NAME="+LAST_USER_NAME);
		sb.append(",OCTANE="+String.valueOf(OCTANE));
		sb.append(",LAST_MODIFIED="+String.valueOf(LAST_MODIFIED));
		sb.append(",PETROEX_PRODUCT_CODE="+PETROEX_PRODUCT_CODE);
		sb.append(",PETROEX_BLEND_INDICATOR="+String.valueOf(PETROEX_BLEND_INDICATOR));
		sb.append(",OVERWEIGHT_TRAILER="+String.valueOf(OVERWEIGHT_TRAILER));
		sb.append(",ADDITIVE_OUT_OF_TOLERANCE="+String.valueOf(ADDITIVE_OUT_OF_TOLERANCE));
		sb.append(",REQUIRES_CLEANLINE="+String.valueOf(REQUIRES_CLEANLINE));
		sb.append(",FLUSH_ACTION="+String.valueOf(FLUSH_ACTION));
		sb.append(",RFG_PRODUCT="+String.valueOf(RFG_PRODUCT));
		sb.append(",LOAD_LIMIT="+String.valueOf(LOAD_LIMIT));
		sb.append(",ADDITIONAL_NOTES="+ADDITIONAL_NOTES);
		sb.append(",INCOMPATIBILITY_ACTION="+String.valueOf(INCOMPATIBILITY_ACTION));
		sb.append(",DISPATCH_QUANTITY_TYPE="+String.valueOf(DISPATCH_QUANTITY_TYPE));
		sb.append(",BOL_NAME="+BOL_NAME);
		sb.append(",LOADING_QUANTITY_TYPE="+String.valueOf(LOADING_QUANTITY_TYPE));
		sb.append(",PRICE_QUANTITY_TYPE="+String.valueOf(PRICE_QUANTITY_TYPE));
		sb.append(",ETHANOL_EXPANSION="+String.valueOf(ETHANOL_EXPANSION));
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
        } else if (updateKeyCount_tDBOutput_1 == 9 && true) {
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

 
	final String decryptedPassword_tDBOutput_1 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:dOZS7t4+xl7che+3ZAd3rBMqI6KoCMsUtXFyzU5veUqCGjMy8lE=");

    String dbPwd_tDBOutput_1 = decryptedPassword_tDBOutput_1;	
    conn_tDBOutput_1 = java.sql.DriverManager.getConnection(url_tDBOutput_1,dbUser_tDBOutput_1,dbPwd_tDBOutput_1);
	
		resourceMap.put("conn_tDBOutput_1", conn_tDBOutput_1);
	
        conn_tDBOutput_1.setAutoCommit(false);
        int commitEvery_tDBOutput_1 = 10000;
        int commitCounter_tDBOutput_1 = 0;


if(dbschema_tDBOutput_1 == null || dbschema_tDBOutput_1.trim().length() == 0) {
    tableName_tDBOutput_1 = "DIM_SUPPLIER_PRODUCTS";
} else {
    tableName_tDBOutput_1 = dbschema_tDBOutput_1 + "].[" + "DIM_SUPPLIER_PRODUCTS";
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
                                        stmtCreate_tDBOutput_1.execute("CREATE TABLE [" + tableName_tDBOutput_1 + "]([PK_PRODUCT_SUPPLIER] INT  not null ,[PRODUCT_COMMENT_SUPPLIER] INT ,[SUPPLIER_NUMBER] INT  not null ,[PRODUCT_NUMBER] INT  not null ,[NAME] VARCHAR(20)  ,[PRODUCT_GROUP_CODE] VARCHAR(6)   not null ,[CLEAN_FUEL] INT  not null ,[ENABLED] INT  not null ,[LAST_MODIFIED] DATETIME ,primary key([PK_PRODUCT_SUPPLIER]))");
                                    }
                                }
        java.sql.PreparedStatement pstmt_tDBOutput_1 = conn_tDBOutput_1.prepareStatement("SELECT COUNT(1) FROM [" + tableName_tDBOutput_1 + "] WHERE [PK_PRODUCT_SUPPLIER] = ?");
        resourceMap.put("pstmt_tDBOutput_1", pstmt_tDBOutput_1);
        String insert_tDBOutput_1 = "INSERT INTO [" + tableName_tDBOutput_1 + "] ([PK_PRODUCT_SUPPLIER],[PRODUCT_COMMENT_SUPPLIER],[SUPPLIER_NUMBER],[PRODUCT_NUMBER],[NAME],[PRODUCT_GROUP_CODE],[CLEAN_FUEL],[ENABLED],[LAST_MODIFIED]) VALUES (?,?,?,?,?,?,?,?,?)";
        java.sql.PreparedStatement pstmtInsert_tDBOutput_1 = conn_tDBOutput_1.prepareStatement(insert_tDBOutput_1);
        resourceMap.put("pstmtInsert_tDBOutput_1", pstmtInsert_tDBOutput_1);
        String update_tDBOutput_1 = "UPDATE [" + tableName_tDBOutput_1 + "] SET [PRODUCT_COMMENT_SUPPLIER] = ?,[SUPPLIER_NUMBER] = ?,[PRODUCT_NUMBER] = ?,[NAME] = ?,[PRODUCT_GROUP_CODE] = ?,[CLEAN_FUEL] = ?,[ENABLED] = ?,[LAST_MODIFIED] = ? WHERE [PK_PRODUCT_SUPPLIER] = ?";
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
	int PK_PRODUCT_SUPPLIER;
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
	
	        
					int PRODUCT_NUMBER;        
	        
		    @Override
			public int hashCode() {
				if (this.hashCodeDirty) {
					final int prime = PRIME;
					int result = DEFAULT_HASHCODE;
			
									result = prime * result + (int) this.PRODUCT_NUMBER;
									
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
				
									if (this.PRODUCT_NUMBER != other.PRODUCT_NUMBER) 
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
				
				 
	final String decryptedPassword_tDBInput_1 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:Ek/LUfkW9R//SUFIhgdiE0rW67+AEN2HuVSwHUzCTtJayOu3BA0=");
				
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

		    String dbquery_tDBInput_1 = "SELECT dbo.SUPPLIER_PRODUCT.PRODUCT_COMMENT_SUPPLIER,\n		dbo.SUPPLIER_PRODUCT.HAZARD_SUPPLIER_NUMBER,\n		dbo.SUPPLIER_PRO"
+"DUCT.SUPPLIER_NUMBER,\n		dbo.SUPPLIER_PRODUCT.PRODUCT_NUMBER,\n		dbo.SUPPLIER_PRODUCT.HAZARD_WARNING_CODE,\n		dbo.SUPPLIER_"
+"PRODUCT.NAME,\n		dbo.SUPPLIER_PRODUCT.PRODUCT_COMMENT_CODE,\n		dbo.SUPPLIER_PRODUCT.TERMINAL_HAZARD_WARNING,\n		dbo.SUPPLIE"
+"R_PRODUCT.PRODUCT_GROUP_CODE,\n		dbo.SUPPLIER_PRODUCT.TERMINAL_PRODUCT_COMMENT,\n		dbo.SUPPLIER_PRODUCT.TABS_PRODUCT_CODE,"
+"\n		dbo.SUPPLIER_PRODUCT.CLEAN_FUEL,\n		dbo.SUPPLIER_PRODUCT.TABS_BLEND_INDICATOR,\n		dbo.SUPPLIER_PRODUCT.ON_TRUCK_SEQUENT"
+"IAL_ENABLED,\n		dbo.SUPPLIER_PRODUCT.TABS_PRODUCT_IDENTIFIER,\n		dbo.SUPPLIER_PRODUCT.PRESET_SEQUENTIAL_ENABLED,\n		dbo.SUP"
+"PLIER_PRODUCT.RATIO_BLENDING_ENABLED,\n		dbo.SUPPLIER_PRODUCT.UPSTREAM_BLENDING_ENABLED,\n		dbo.SUPPLIER_PRODUCT.ENABLED,\n"
+"		dbo.SUPPLIER_PRODUCT.REQUIRES_INTERVENTION,\n		dbo.SUPPLIER_PRODUCT.BLEND_OUT_OF_TOLERANCE,\n		dbo.SUPPLIER_PRODUCT.PRIC"
+"E,\n		dbo.SUPPLIER_PRODUCT.LAST_USER_NAME,\n		dbo.SUPPLIER_PRODUCT.OCTANE,\n		dbo.SUPPLIER_PRODUCT.LAST_MODIFIED,\n		dbo.SUP"
+"PLIER_PRODUCT.PETROEX_PRODUCT_CODE,\n		dbo.SUPPLIER_PRODUCT.PETROEX_BLEND_INDICATOR,\n		dbo.SUPPLIER_PRODUCT.OVERWEIGHT_TR"
+"AILER,\n		dbo.SUPPLIER_PRODUCT.ADDITIVE_OUT_OF_TOLERANCE,\n		dbo.SUPPLIER_PRODUCT.REQUIRES_CLEANLINE,\n		dbo.SUPPLIER_PRODU"
+"CT.FLUSH_ACTION,\n		dbo.SUPPLIER_PRODUCT.RFG_PRODUCT,\n		dbo.SUPPLIER_PRODUCT.LOAD_LIMIT,\n		dbo.SUPPLIER_PRODUCT.ADDITIONA"
+"L_NOTES,\n		dbo.SUPPLIER_PRODUCT.INCOMPATIBILITY_ACTION,\n		dbo.SUPPLIER_PRODUCT.DISPATCH_QUANTITY_TYPE,\n		dbo.SUPPLIER_PR"
+"ODUCT.BOL_NAME,\n		dbo.SUPPLIER_PRODUCT.LOADING_QUANTITY_TYPE,\n		dbo.SUPPLIER_PRODUCT.PRICE_QUANTITY_TYPE,\n		dbo.SUPPLIER"
+"_PRODUCT.ETHANOL_EXPANSION\nFROM	dbo.SUPPLIER_PRODUCT";
		    

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
								row1.PRODUCT_COMMENT_SUPPLIER = null;
							} else {
		                          
            row1.PRODUCT_COMMENT_SUPPLIER = rs_tDBInput_1.getInt(1);
            if(rs_tDBInput_1.wasNull()){
                    row1.PRODUCT_COMMENT_SUPPLIER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 2) {
								row1.HAZARD_SUPPLIER_NUMBER = null;
							} else {
		                          
            row1.HAZARD_SUPPLIER_NUMBER = rs_tDBInput_1.getInt(2);
            if(rs_tDBInput_1.wasNull()){
                    row1.HAZARD_SUPPLIER_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 3) {
								row1.SUPPLIER_NUMBER = 0;
							} else {
		                          
            row1.SUPPLIER_NUMBER = rs_tDBInput_1.getInt(3);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 4) {
								row1.PRODUCT_NUMBER = 0;
							} else {
		                          
            row1.PRODUCT_NUMBER = rs_tDBInput_1.getInt(4);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 5) {
								row1.HAZARD_WARNING_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(5);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(5).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.HAZARD_WARNING_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.HAZARD_WARNING_CODE = tmpContent_tDBInput_1;
                }
            } else {
                row1.HAZARD_WARNING_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 6) {
								row1.NAME = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(6);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(6).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.NAME = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.NAME = tmpContent_tDBInput_1;
                }
            } else {
                row1.NAME = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 7) {
								row1.PRODUCT_COMMENT_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(7);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(7).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.PRODUCT_COMMENT_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.PRODUCT_COMMENT_CODE = tmpContent_tDBInput_1;
                }
            } else {
                row1.PRODUCT_COMMENT_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 8) {
								row1.TERMINAL_HAZARD_WARNING = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(8);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(8).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.TERMINAL_HAZARD_WARNING = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.TERMINAL_HAZARD_WARNING = tmpContent_tDBInput_1;
                }
            } else {
                row1.TERMINAL_HAZARD_WARNING = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 9) {
								row1.PRODUCT_GROUP_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(9);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(9).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.PRODUCT_GROUP_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.PRODUCT_GROUP_CODE = tmpContent_tDBInput_1;
                }
            } else {
                row1.PRODUCT_GROUP_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 10) {
								row1.TERMINAL_PRODUCT_COMMENT = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(10);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(10).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.TERMINAL_PRODUCT_COMMENT = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.TERMINAL_PRODUCT_COMMENT = tmpContent_tDBInput_1;
                }
            } else {
                row1.TERMINAL_PRODUCT_COMMENT = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 11) {
								row1.TABS_PRODUCT_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(11);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(11).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.TABS_PRODUCT_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.TABS_PRODUCT_CODE = tmpContent_tDBInput_1;
                }
            } else {
                row1.TABS_PRODUCT_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 12) {
								row1.CLEAN_FUEL = 0;
							} else {
		                          
            row1.CLEAN_FUEL = rs_tDBInput_1.getInt(12);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 13) {
								row1.TABS_BLEND_INDICATOR = null;
							} else {
		                          
            row1.TABS_BLEND_INDICATOR = rs_tDBInput_1.getInt(13);
            if(rs_tDBInput_1.wasNull()){
                    row1.TABS_BLEND_INDICATOR = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 14) {
								row1.ON_TRUCK_SEQUENTIAL_ENABLED = 0;
							} else {
		                          
            row1.ON_TRUCK_SEQUENTIAL_ENABLED = rs_tDBInput_1.getInt(14);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 15) {
								row1.TABS_PRODUCT_IDENTIFIER = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(15);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(15).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.TABS_PRODUCT_IDENTIFIER = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.TABS_PRODUCT_IDENTIFIER = tmpContent_tDBInput_1;
                }
            } else {
                row1.TABS_PRODUCT_IDENTIFIER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 16) {
								row1.PRESET_SEQUENTIAL_ENABLED = 0;
							} else {
		                          
            row1.PRESET_SEQUENTIAL_ENABLED = rs_tDBInput_1.getInt(16);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 17) {
								row1.RATIO_BLENDING_ENABLED = 0;
							} else {
		                          
            row1.RATIO_BLENDING_ENABLED = rs_tDBInput_1.getInt(17);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 18) {
								row1.UPSTREAM_BLENDING_ENABLED = 0;
							} else {
		                          
            row1.UPSTREAM_BLENDING_ENABLED = rs_tDBInput_1.getInt(18);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 19) {
								row1.ENABLED = 0;
							} else {
		                          
            row1.ENABLED = rs_tDBInput_1.getInt(19);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 20) {
								row1.REQUIRES_INTERVENTION = 0;
							} else {
		                          
            row1.REQUIRES_INTERVENTION = rs_tDBInput_1.getInt(20);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 21) {
								row1.BLEND_OUT_OF_TOLERANCE = 0;
							} else {
		                          
            row1.BLEND_OUT_OF_TOLERANCE = rs_tDBInput_1.getInt(21);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 22) {
								row1.PRICE = 0;
							} else {
	                         		
            row1.PRICE = rs_tDBInput_1.getDouble(22);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 23) {
								row1.LAST_USER_NAME = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(23);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(23).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.LAST_USER_NAME = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.LAST_USER_NAME = tmpContent_tDBInput_1;
                }
            } else {
                row1.LAST_USER_NAME = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 24) {
								row1.OCTANE = 0;
							} else {
	                         		
            row1.OCTANE = rs_tDBInput_1.getDouble(24);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 25) {
								row1.LAST_MODIFIED = null;
							} else {
										
			row1.LAST_MODIFIED = mssqlGTU_tDBInput_1.getDate(rsmd_tDBInput_1, rs_tDBInput_1, 25);
			
		                    }
							if(colQtyInRs_tDBInput_1 < 26) {
								row1.PETROEX_PRODUCT_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(26);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(26).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.PETROEX_PRODUCT_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.PETROEX_PRODUCT_CODE = tmpContent_tDBInput_1;
                }
            } else {
                row1.PETROEX_PRODUCT_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 27) {
								row1.PETROEX_BLEND_INDICATOR = 0;
							} else {
		                          
            row1.PETROEX_BLEND_INDICATOR = rs_tDBInput_1.getInt(27);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 28) {
								row1.OVERWEIGHT_TRAILER = 0;
							} else {
		                          
            row1.OVERWEIGHT_TRAILER = rs_tDBInput_1.getInt(28);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 29) {
								row1.ADDITIVE_OUT_OF_TOLERANCE = 0;
							} else {
		                          
            row1.ADDITIVE_OUT_OF_TOLERANCE = rs_tDBInput_1.getInt(29);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 30) {
								row1.REQUIRES_CLEANLINE = 0;
							} else {
		                          
            row1.REQUIRES_CLEANLINE = rs_tDBInput_1.getInt(30);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 31) {
								row1.FLUSH_ACTION = 0;
							} else {
		                          
            row1.FLUSH_ACTION = rs_tDBInput_1.getInt(31);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 32) {
								row1.RFG_PRODUCT = 0;
							} else {
		                          
            row1.RFG_PRODUCT = rs_tDBInput_1.getInt(32);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 33) {
								row1.LOAD_LIMIT = 0;
							} else {
		                          
            row1.LOAD_LIMIT = rs_tDBInput_1.getInt(33);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 34) {
								row1.ADDITIONAL_NOTES = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(34);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(34).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.ADDITIONAL_NOTES = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.ADDITIONAL_NOTES = tmpContent_tDBInput_1;
                }
            } else {
                row1.ADDITIONAL_NOTES = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 35) {
								row1.INCOMPATIBILITY_ACTION = 0;
							} else {
		                          
            row1.INCOMPATIBILITY_ACTION = rs_tDBInput_1.getInt(35);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 36) {
								row1.DISPATCH_QUANTITY_TYPE = 0;
							} else {
		                          
            row1.DISPATCH_QUANTITY_TYPE = rs_tDBInput_1.getInt(36);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 37) {
								row1.BOL_NAME = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(37);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(37).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.BOL_NAME = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.BOL_NAME = tmpContent_tDBInput_1;
                }
            } else {
                row1.BOL_NAME = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 38) {
								row1.LOADING_QUANTITY_TYPE = 0;
							} else {
		                          
            row1.LOADING_QUANTITY_TYPE = rs_tDBInput_1.getInt(38);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 39) {
								row1.PRICE_QUANTITY_TYPE = 0;
							} else {
		                          
            row1.PRICE_QUANTITY_TYPE = rs_tDBInput_1.getInt(39);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 40) {
								row1.ETHANOL_EXPANSION = 0;
							} else {
		                          
            row1.ETHANOL_EXPANSION = rs_tDBInput_1.getInt(40);
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
finder_tUniqRow_1.PRODUCT_NUMBER = row1.PRODUCT_NUMBER;	
finder_tUniqRow_1.hashCodeDirty = true;
if (!keystUniqRow_1.contains(finder_tUniqRow_1)) {
		KeyStruct_tUniqRow_1 new_tUniqRow_1 = new KeyStruct_tUniqRow_1();

		
new_tUniqRow_1.PRODUCT_NUMBER = row1.PRODUCT_NUMBER;
		
		keystUniqRow_1.add(new_tUniqRow_1);if(row2 == null){ 
	
	row2 = new row2Struct();
}row2.PRODUCT_COMMENT_SUPPLIER = row1.PRODUCT_COMMENT_SUPPLIER;			row2.HAZARD_SUPPLIER_NUMBER = row1.HAZARD_SUPPLIER_NUMBER;			row2.SUPPLIER_NUMBER = row1.SUPPLIER_NUMBER;			row2.PRODUCT_NUMBER = row1.PRODUCT_NUMBER;			row2.HAZARD_WARNING_CODE = row1.HAZARD_WARNING_CODE;			row2.NAME = row1.NAME;			row2.PRODUCT_COMMENT_CODE = row1.PRODUCT_COMMENT_CODE;			row2.TERMINAL_HAZARD_WARNING = row1.TERMINAL_HAZARD_WARNING;			row2.PRODUCT_GROUP_CODE = row1.PRODUCT_GROUP_CODE;			row2.TERMINAL_PRODUCT_COMMENT = row1.TERMINAL_PRODUCT_COMMENT;			row2.TABS_PRODUCT_CODE = row1.TABS_PRODUCT_CODE;			row2.CLEAN_FUEL = row1.CLEAN_FUEL;			row2.TABS_BLEND_INDICATOR = row1.TABS_BLEND_INDICATOR;			row2.ON_TRUCK_SEQUENTIAL_ENABLED = row1.ON_TRUCK_SEQUENTIAL_ENABLED;			row2.TABS_PRODUCT_IDENTIFIER = row1.TABS_PRODUCT_IDENTIFIER;			row2.PRESET_SEQUENTIAL_ENABLED = row1.PRESET_SEQUENTIAL_ENABLED;			row2.RATIO_BLENDING_ENABLED = row1.RATIO_BLENDING_ENABLED;			row2.UPSTREAM_BLENDING_ENABLED = row1.UPSTREAM_BLENDING_ENABLED;			row2.ENABLED = row1.ENABLED;			row2.REQUIRES_INTERVENTION = row1.REQUIRES_INTERVENTION;			row2.BLEND_OUT_OF_TOLERANCE = row1.BLEND_OUT_OF_TOLERANCE;			row2.PRICE = row1.PRICE;			row2.LAST_USER_NAME = row1.LAST_USER_NAME;			row2.OCTANE = row1.OCTANE;			row2.LAST_MODIFIED = row1.LAST_MODIFIED;			row2.PETROEX_PRODUCT_CODE = row1.PETROEX_PRODUCT_CODE;			row2.PETROEX_BLEND_INDICATOR = row1.PETROEX_BLEND_INDICATOR;			row2.OVERWEIGHT_TRAILER = row1.OVERWEIGHT_TRAILER;			row2.ADDITIVE_OUT_OF_TOLERANCE = row1.ADDITIVE_OUT_OF_TOLERANCE;			row2.REQUIRES_CLEANLINE = row1.REQUIRES_CLEANLINE;			row2.FLUSH_ACTION = row1.FLUSH_ACTION;			row2.RFG_PRODUCT = row1.RFG_PRODUCT;			row2.LOAD_LIMIT = row1.LOAD_LIMIT;			row2.ADDITIONAL_NOTES = row1.ADDITIONAL_NOTES;			row2.INCOMPATIBILITY_ACTION = row1.INCOMPATIBILITY_ACTION;			row2.DISPATCH_QUANTITY_TYPE = row1.DISPATCH_QUANTITY_TYPE;			row2.BOL_NAME = row1.BOL_NAME;			row2.LOADING_QUANTITY_TYPE = row1.LOADING_QUANTITY_TYPE;			row2.PRICE_QUANTITY_TYPE = row1.PRICE_QUANTITY_TYPE;			row2.ETHANOL_EXPANSION = row1.ETHANOL_EXPANSION;					
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
								
	                        		    	Object exprKeyValue_row3__PRODUCT_NUMBER = row2.PRODUCT_NUMBER ;
	                        		    	if(exprKeyValue_row3__PRODUCT_NUMBER == null) {
	                        		    		hasCasePrimitiveKeyWithNull_tMap_1 = true;
	                        		    	} else {
                        		    			row3HashKey.PRODUCT_NUMBER = (int)(Integer) exprKeyValue_row3__PRODUCT_NUMBER;
                        		    		}
                        		    		

								
		                        	row3HashKey.hashCodeDirty = true;
                        		
	  					
	  							
	
		  							if(!hasCasePrimitiveKeyWithNull_tMap_1) { // G_TM_M_091
		  							
			  					
			  					
			  					
	  					
		  							tHash_Lookup_row3.lookup( row3HashKey );

	  							

	  							

			  						} // G_TM_M_091
			  						
			  					

 								
		  				
	  								
						
									
  									  		
 								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_row3 != null && tHash_Lookup_row3.getCount(row3HashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row3' and it contains more one result from keys :  row3.PRODUCT_NUMBER = '" + row3HashKey.PRODUCT_NUMBER + "'");
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
Var.PK_PRODUCT_SUPPLIER = Numeric.sequence("s17",1,1) ;// ###############################
        // ###############################
        // # Output tables

out2 = null;

boolean rejected_tMap_1 = true;
// ###### START REJECTS ##### 

// # Output reject table : 'out2'
// # Filter conditions 
if( rejected_tMap_1 ) {
out2_tmp.PK_PRODUCT_SUPPLIER = Var.PK_PRODUCT_SUPPLIER ;
out2_tmp.PRODUCT_COMMENT_SUPPLIER = row2.PRODUCT_COMMENT_SUPPLIER ;
out2_tmp.SUPPLIER_NUMBER = row2.SUPPLIER_NUMBER ;
out2_tmp.PRODUCT_NUMBER = row2.PRODUCT_NUMBER ;
out2_tmp.NAME = row2.NAME ;
out2_tmp.PRODUCT_GROUP_CODE = row2.PRODUCT_GROUP_CODE ;
out2_tmp.CLEAN_FUEL = row2.CLEAN_FUEL ;
out2_tmp.ENABLED = row2.ENABLED ;
out2_tmp.LAST_MODIFIED = row2.LAST_MODIFIED ;
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


                    pstmt_tDBOutput_1.setInt(1, out2.PK_PRODUCT_SUPPLIER);

            int checkCount_tDBOutput_1 = -1;
            try (java.sql.ResultSet rs_tDBOutput_1 = pstmt_tDBOutput_1.executeQuery()) {
                while(rs_tDBOutput_1.next()) {
                    checkCount_tDBOutput_1 = rs_tDBOutput_1.getInt(1);
                }
            }
            if(checkCount_tDBOutput_1 > 0) {
                        if(out2.PRODUCT_COMMENT_SUPPLIER == null) {
pstmtUpdate_tDBOutput_1.setNull(1, java.sql.Types.INTEGER);
} else {pstmtUpdate_tDBOutput_1.setInt(1, out2.PRODUCT_COMMENT_SUPPLIER);
}

                        pstmtUpdate_tDBOutput_1.setInt(2, out2.SUPPLIER_NUMBER);

                        pstmtUpdate_tDBOutput_1.setInt(3, out2.PRODUCT_NUMBER);

                        if(out2.NAME == null) {
pstmtUpdate_tDBOutput_1.setNull(4, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(4, out2.NAME);
}

                        if(out2.PRODUCT_GROUP_CODE == null) {
pstmtUpdate_tDBOutput_1.setNull(5, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(5, out2.PRODUCT_GROUP_CODE);
}

                        pstmtUpdate_tDBOutput_1.setInt(6, out2.CLEAN_FUEL);

                        pstmtUpdate_tDBOutput_1.setInt(7, out2.ENABLED);

                        if(out2.LAST_MODIFIED != null) {
pstmtUpdate_tDBOutput_1.setTimestamp(8, new java.sql.Timestamp(out2.LAST_MODIFIED.getTime()));
} else {
pstmtUpdate_tDBOutput_1.setNull(8, java.sql.Types.TIMESTAMP);
}


	                    

                        pstmtUpdate_tDBOutput_1.setInt(9 + count_tDBOutput_1, out2.PK_PRODUCT_SUPPLIER);

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
                        pstmtInsert_tDBOutput_1.setInt(1, out2.PK_PRODUCT_SUPPLIER);

                        if(out2.PRODUCT_COMMENT_SUPPLIER == null) {
pstmtInsert_tDBOutput_1.setNull(2, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_1.setInt(2, out2.PRODUCT_COMMENT_SUPPLIER);
}

                        pstmtInsert_tDBOutput_1.setInt(3, out2.SUPPLIER_NUMBER);

                        pstmtInsert_tDBOutput_1.setInt(4, out2.PRODUCT_NUMBER);

                        if(out2.NAME == null) {
pstmtInsert_tDBOutput_1.setNull(5, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(5, out2.NAME);
}

                        if(out2.PRODUCT_GROUP_CODE == null) {
pstmtInsert_tDBOutput_1.setNull(6, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(6, out2.PRODUCT_GROUP_CODE);
}

                        pstmtInsert_tDBOutput_1.setInt(7, out2.CLEAN_FUEL);

                        pstmtInsert_tDBOutput_1.setInt(8, out2.ENABLED);

                        if(out2.LAST_MODIFIED != null) {
pstmtInsert_tDBOutput_1.setTimestamp(9, new java.sql.Timestamp(out2.LAST_MODIFIED.getTime()));
} else {
pstmtInsert_tDBOutput_1.setNull(9, java.sql.Types.TIMESTAMP);
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
    final static byte[] commonByteArrayLock_PGS_STAGE_DIM_SUPPLIER_PRODUCT = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_DIM_SUPPLIER_PRODUCT = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public int PK_PRODUCT_SUPPLIER;

				public int getPK_PRODUCT_SUPPLIER () {
					return this.PK_PRODUCT_SUPPLIER;
				}
				
			    public int SUPPLIER_NUMBER;

				public int getSUPPLIER_NUMBER () {
					return this.SUPPLIER_NUMBER;
				}
				
			    public int PRODUCT_NUMBER;

				public int getPRODUCT_NUMBER () {
					return this.PRODUCT_NUMBER;
				}
				
			    public String NAME;

				public String getNAME () {
					return this.NAME;
				}
				
			    public String PRODUCT_GROUP_CODE;

				public String getPRODUCT_GROUP_CODE () {
					return this.PRODUCT_GROUP_CODE;
				}
				
			    public int CLEAN_FUEL;

				public int getCLEAN_FUEL () {
					return this.CLEAN_FUEL;
				}
				
			    public int ENABLED;

				public int getENABLED () {
					return this.ENABLED;
				}
				
			    public java.util.Date LAST_MODIFIED;

				public java.util.Date getLAST_MODIFIED () {
					return this.LAST_MODIFIED;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
							result = prime * result + (int) this.PRODUCT_NUMBER;
						
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
		
						if (this.PRODUCT_NUMBER != other.PRODUCT_NUMBER)
							return false;
					

		return true;
    }

	public void copyDataTo(row3Struct other) {

		other.PK_PRODUCT_SUPPLIER = this.PK_PRODUCT_SUPPLIER;
	            other.SUPPLIER_NUMBER = this.SUPPLIER_NUMBER;
	            other.PRODUCT_NUMBER = this.PRODUCT_NUMBER;
	            other.NAME = this.NAME;
	            other.PRODUCT_GROUP_CODE = this.PRODUCT_GROUP_CODE;
	            other.CLEAN_FUEL = this.CLEAN_FUEL;
	            other.ENABLED = this.ENABLED;
	            other.LAST_MODIFIED = this.LAST_MODIFIED;
	            
	}

	public void copyKeysDataTo(row3Struct other) {

		other.PRODUCT_NUMBER = this.PRODUCT_NUMBER;
	            	
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

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_SUPPLIER_PRODUCT) {

        	try {

        		int length = 0;
		
			        this.PRODUCT_NUMBER = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_SUPPLIER_PRODUCT) {

        	try {

        		int length = 0;
		
			        this.PRODUCT_NUMBER = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.PRODUCT_NUMBER);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.PRODUCT_NUMBER);
					
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
		
			            this.PK_PRODUCT_SUPPLIER = dis.readInt();
					
			            this.SUPPLIER_NUMBER = dis.readInt();
					
						this.NAME = readString(dis,ois);
					
						this.PRODUCT_GROUP_CODE = readString(dis,ois);
					
			            this.CLEAN_FUEL = dis.readInt();
					
			            this.ENABLED = dis.readInt();
					
						this.LAST_MODIFIED = readDate(dis,ois);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
			            this.PK_PRODUCT_SUPPLIER = objectIn.readInt();
					
			            this.SUPPLIER_NUMBER = objectIn.readInt();
					
						this.NAME = readString(dis,objectIn);
					
						this.PRODUCT_GROUP_CODE = readString(dis,objectIn);
					
			            this.CLEAN_FUEL = objectIn.readInt();
					
			            this.ENABLED = objectIn.readInt();
					
						this.LAST_MODIFIED = readDate(dis,objectIn);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
		            	dos.writeInt(this.PK_PRODUCT_SUPPLIER);
					
		            	dos.writeInt(this.SUPPLIER_NUMBER);
					
						writeString(this.NAME, dos, oos);
					
						writeString(this.PRODUCT_GROUP_CODE, dos, oos);
					
		            	dos.writeInt(this.CLEAN_FUEL);
					
		            	dos.writeInt(this.ENABLED);
					
						writeDate(this.LAST_MODIFIED, dos, oos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
					objectOut.writeInt(this.PK_PRODUCT_SUPPLIER);
					
					objectOut.writeInt(this.SUPPLIER_NUMBER);
					
						writeString(this.NAME, dos, objectOut);
					
						writeString(this.PRODUCT_GROUP_CODE, dos, objectOut);
					
					objectOut.writeInt(this.CLEAN_FUEL);
					
					objectOut.writeInt(this.ENABLED);
					
						writeDate(this.LAST_MODIFIED, dos, objectOut);
					
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
		sb.append("PK_PRODUCT_SUPPLIER="+String.valueOf(PK_PRODUCT_SUPPLIER));
		sb.append(",SUPPLIER_NUMBER="+String.valueOf(SUPPLIER_NUMBER));
		sb.append(",PRODUCT_NUMBER="+String.valueOf(PRODUCT_NUMBER));
		sb.append(",NAME="+NAME);
		sb.append(",PRODUCT_GROUP_CODE="+PRODUCT_GROUP_CODE);
		sb.append(",CLEAN_FUEL="+String.valueOf(CLEAN_FUEL));
		sb.append(",ENABLED="+String.valueOf(ENABLED));
		sb.append(",LAST_MODIFIED="+String.valueOf(LAST_MODIFIED));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row3Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.PRODUCT_NUMBER, other.PRODUCT_NUMBER);
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
				
				 
	final String decryptedPassword_tDBInput_2 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:8W82iyxUZ3bqlsJUlPdGcffhTTLB+CwX/HBSe125WiPwXVthnyk=");
				
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

		    String dbquery_tDBInput_2 = "SELECT dbo.DIM_SUPPLIER_PRODUCTS.PK_PRODUCT_SUPPLIER,\n		dbo.DIM_SUPPLIER_PRODUCTS.SUPPLIER_NUMBER,\n		dbo.DIM_SUPPLIER_P"
+"RODUCTS.PRODUCT_NUMBER,\n		dbo.DIM_SUPPLIER_PRODUCTS.NAME,\n		dbo.DIM_SUPPLIER_PRODUCTS.PRODUCT_GROUP_CODE,\n		dbo.DIM_SUPP"
+"LIER_PRODUCTS.CLEAN_FUEL,\n		dbo.DIM_SUPPLIER_PRODUCTS.ENABLED,\n		dbo.DIM_SUPPLIER_PRODUCTS.LAST_MODIFIED\nFROM	dbo.DIM_SU"
+"PPLIER_PRODUCTS";
		    

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
								row3.PK_PRODUCT_SUPPLIER = 0;
							} else {
		                          
            row3.PK_PRODUCT_SUPPLIER = rs_tDBInput_2.getInt(1);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 2) {
								row3.SUPPLIER_NUMBER = 0;
							} else {
		                          
            row3.SUPPLIER_NUMBER = rs_tDBInput_2.getInt(2);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 3) {
								row3.PRODUCT_NUMBER = 0;
							} else {
		                          
            row3.PRODUCT_NUMBER = rs_tDBInput_2.getInt(3);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 4) {
								row3.NAME = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(4);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(4).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.NAME = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row3.NAME = tmpContent_tDBInput_2;
                }
            } else {
                row3.NAME = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 5) {
								row3.PRODUCT_GROUP_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(5);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(5).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.PRODUCT_GROUP_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row3.PRODUCT_GROUP_CODE = tmpContent_tDBInput_2;
                }
            } else {
                row3.PRODUCT_GROUP_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 6) {
								row3.CLEAN_FUEL = 0;
							} else {
		                          
            row3.CLEAN_FUEL = rs_tDBInput_2.getInt(6);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 7) {
								row3.ENABLED = 0;
							} else {
		                          
            row3.ENABLED = rs_tDBInput_2.getInt(7);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 8) {
								row3.LAST_MODIFIED = null;
							} else {
										
			row3.LAST_MODIFIED = mssqlGTU_tDBInput_2.getDate(rsmd_tDBInput_2, rs_tDBInput_2, 8);
			
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
		   	   	   
				
				row3_HashRow.PK_PRODUCT_SUPPLIER = row3.PK_PRODUCT_SUPPLIER;
				
				row3_HashRow.SUPPLIER_NUMBER = row3.SUPPLIER_NUMBER;
				
				row3_HashRow.PRODUCT_NUMBER = row3.PRODUCT_NUMBER;
				
				row3_HashRow.NAME = row3.NAME;
				
				row3_HashRow.PRODUCT_GROUP_CODE = row3.PRODUCT_GROUP_CODE;
				
				row3_HashRow.CLEAN_FUEL = row3.CLEAN_FUEL;
				
				row3_HashRow.ENABLED = row3.ENABLED;
				
				row3_HashRow.LAST_MODIFIED = row3.LAST_MODIFIED;
				
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
        final DIM_SUPPLIER_PRODUCT DIM_SUPPLIER_PRODUCTClass = new DIM_SUPPLIER_PRODUCT();

        int exitCode = DIM_SUPPLIER_PRODUCTClass.runJobInTOS(args);

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
            java.io.InputStream inContext = DIM_SUPPLIER_PRODUCT.class.getClassLoader().getResourceAsStream("pgs_stage/dim_supplier_product_0_1/contexts/" + contextStr + ".properties");
            if (inContext == null) {
                inContext = DIM_SUPPLIER_PRODUCT.class.getClassLoader().getResourceAsStream("config/contexts/" + contextStr + ".properties");
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
            System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : DIM_SUPPLIER_PRODUCT");
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
 *     195022 characters generated by Talend Open Studio for Data Integration 
 *     on the 3 août 2024 à 14:42:26 GMT+01:00
 ************************************************************************************************/