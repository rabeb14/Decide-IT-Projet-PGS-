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


package pgs_stage.dim_customer_0_1;

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
 * Job: DIM_CUSTOMER Purpose: <br>
 * Description:  <br>
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status 
 */
public class DIM_CUSTOMER implements TalendJob {

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
	private final String jobName = "DIM_CUSTOMER";
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
				DIM_CUSTOMER.this.exception = e;
			}
		}
		if (!(e instanceof TalendException)) {
		try {
			for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
				if (m.getName().compareTo(currentComponent + "_error") == 0) {
					m.invoke(DIM_CUSTOMER.this, new Object[] { e , currentComponent, globalMap});
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
    final static byte[] commonByteArrayLock_PGS_STAGE_DIM_CUSTOMER = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_DIM_CUSTOMER = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public int PK_CUSTOMER;

				public int getPK_CUSTOMER () {
					return this.PK_CUSTOMER;
				}
				
			    public int SUPPLIER_NUMBER;

				public int getSUPPLIER_NUMBER () {
					return this.SUPPLIER_NUMBER;
				}
				
			    public int CUSTOMER_NUMBER;

				public int getCUSTOMER_NUMBER () {
					return this.CUSTOMER_NUMBER;
				}
				
			    public String BILLING_ADDRESS_1;

				public String getBILLING_ADDRESS_1 () {
					return this.BILLING_ADDRESS_1;
				}
				
			    public int DET_CUSTOMER_NUMBER;

				public int getDET_CUSTOMER_NUMBER () {
					return this.DET_CUSTOMER_NUMBER;
				}
				
			    public String LAST_USER_NAME;

				public String getLAST_USER_NAME () {
					return this.LAST_USER_NAME;
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
	
							result = prime * result + (int) this.PK_CUSTOMER;
						
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
		
						if (this.PK_CUSTOMER != other.PK_CUSTOMER)
							return false;
					

		return true;
    }

	public void copyDataTo(out1Struct other) {

		other.PK_CUSTOMER = this.PK_CUSTOMER;
	            other.SUPPLIER_NUMBER = this.SUPPLIER_NUMBER;
	            other.CUSTOMER_NUMBER = this.CUSTOMER_NUMBER;
	            other.BILLING_ADDRESS_1 = this.BILLING_ADDRESS_1;
	            other.DET_CUSTOMER_NUMBER = this.DET_CUSTOMER_NUMBER;
	            other.LAST_USER_NAME = this.LAST_USER_NAME;
	            other.LAST_MODIFIED = this.LAST_MODIFIED;
	            
	}

	public void copyKeysDataTo(out1Struct other) {

		other.PK_CUSTOMER = this.PK_CUSTOMER;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PGS_STAGE_DIM_CUSTOMER.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_CUSTOMER.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_CUSTOMER = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_CUSTOMER = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PGS_STAGE_DIM_CUSTOMER, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_CUSTOMER, 0, length, utf8Charset);
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
			if(length > commonByteArray_PGS_STAGE_DIM_CUSTOMER.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_CUSTOMER.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_CUSTOMER = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_CUSTOMER = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PGS_STAGE_DIM_CUSTOMER, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_CUSTOMER, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_CUSTOMER) {

        	try {

        		int length = 0;
		
			        this.PK_CUSTOMER = dis.readInt();
					
			        this.SUPPLIER_NUMBER = dis.readInt();
					
			        this.CUSTOMER_NUMBER = dis.readInt();
					
					this.BILLING_ADDRESS_1 = readString(dis);
					
			        this.DET_CUSTOMER_NUMBER = dis.readInt();
					
					this.LAST_USER_NAME = readString(dis);
					
					this.LAST_MODIFIED = readDate(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_CUSTOMER) {

        	try {

        		int length = 0;
		
			        this.PK_CUSTOMER = dis.readInt();
					
			        this.SUPPLIER_NUMBER = dis.readInt();
					
			        this.CUSTOMER_NUMBER = dis.readInt();
					
					this.BILLING_ADDRESS_1 = readString(dis);
					
			        this.DET_CUSTOMER_NUMBER = dis.readInt();
					
					this.LAST_USER_NAME = readString(dis);
					
					this.LAST_MODIFIED = readDate(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.PK_CUSTOMER);
					
					// int
				
		            	dos.writeInt(this.SUPPLIER_NUMBER);
					
					// int
				
		            	dos.writeInt(this.CUSTOMER_NUMBER);
					
					// String
				
						writeString(this.BILLING_ADDRESS_1,dos);
					
					// int
				
		            	dos.writeInt(this.DET_CUSTOMER_NUMBER);
					
					// String
				
						writeString(this.LAST_USER_NAME,dos);
					
					// java.util.Date
				
						writeDate(this.LAST_MODIFIED,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.PK_CUSTOMER);
					
					// int
				
		            	dos.writeInt(this.SUPPLIER_NUMBER);
					
					// int
				
		            	dos.writeInt(this.CUSTOMER_NUMBER);
					
					// String
				
						writeString(this.BILLING_ADDRESS_1,dos);
					
					// int
				
		            	dos.writeInt(this.DET_CUSTOMER_NUMBER);
					
					// String
				
						writeString(this.LAST_USER_NAME,dos);
					
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
		sb.append("PK_CUSTOMER="+String.valueOf(PK_CUSTOMER));
		sb.append(",SUPPLIER_NUMBER="+String.valueOf(SUPPLIER_NUMBER));
		sb.append(",CUSTOMER_NUMBER="+String.valueOf(CUSTOMER_NUMBER));
		sb.append(",BILLING_ADDRESS_1="+BILLING_ADDRESS_1);
		sb.append(",DET_CUSTOMER_NUMBER="+String.valueOf(DET_CUSTOMER_NUMBER));
		sb.append(",LAST_USER_NAME="+LAST_USER_NAME);
		sb.append(",LAST_MODIFIED="+String.valueOf(LAST_MODIFIED));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(out1Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.PK_CUSTOMER, other.PK_CUSTOMER);
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
    final static byte[] commonByteArrayLock_PGS_STAGE_DIM_CUSTOMER = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_DIM_CUSTOMER = new byte[0];

	
			    public int SUPPLIER_NUMBER;

				public int getSUPPLIER_NUMBER () {
					return this.SUPPLIER_NUMBER;
				}
				
			    public int CUSTOMER_NUMBER;

				public int getCUSTOMER_NUMBER () {
					return this.CUSTOMER_NUMBER;
				}
				
			    public String API_CODE;

				public String getAPI_CODE () {
					return this.API_CODE;
				}
				
			    public String BILLING_ADDRESS_1;

				public String getBILLING_ADDRESS_1 () {
					return this.BILLING_ADDRESS_1;
				}
				
			    public String DET_NAME2;

				public String getDET_NAME2 () {
					return this.DET_NAME2;
				}
				
			    public int DET_CUSTOMER_NUMBER;

				public int getDET_CUSTOMER_NUMBER () {
					return this.DET_CUSTOMER_NUMBER;
				}
				
			    public String BILLING_ADDRESS_2;

				public String getBILLING_ADDRESS_2 () {
					return this.BILLING_ADDRESS_2;
				}
				
			    public String BILLING_ADDRESS_3;

				public String getBILLING_ADDRESS_3 () {
					return this.BILLING_ADDRESS_3;
				}
				
			    public String BILLING_ADDRESS_4;

				public String getBILLING_ADDRESS_4 () {
					return this.BILLING_ADDRESS_4;
				}
				
			    public int LOCKOUT_LOADING;

				public int getLOCKOUT_LOADING () {
					return this.LOCKOUT_LOADING;
				}
				
			    public String LOCKOUT_LOADING_REASON;

				public String getLOCKOUT_LOADING_REASON () {
					return this.LOCKOUT_LOADING_REASON;
				}
				
			    public int BILLING_TYPE;

				public int getBILLING_TYPE () {
					return this.BILLING_TYPE;
				}
				
			    public String PHONE_NUMBER;

				public String getPHONE_NUMBER () {
					return this.PHONE_NUMBER;
				}
				
			    public String PURCHASE_ORDER_NUMBER;

				public String getPURCHASE_ORDER_NUMBER () {
					return this.PURCHASE_ORDER_NUMBER;
				}
				
			    public String REQUISITION_NUMBER;

				public String getREQUISITION_NUMBER () {
					return this.REQUISITION_NUMBER;
				}
				
			    public int PROMPT_PO_NUMBER;

				public int getPROMPT_PO_NUMBER () {
					return this.PROMPT_PO_NUMBER;
				}
				
			    public int PROMPT_R_NUMBER;

				public int getPROMPT_R_NUMBER () {
					return this.PROMPT_R_NUMBER;
				}
				
			    public String BOL_COMMENT_1;

				public String getBOL_COMMENT_1 () {
					return this.BOL_COMMENT_1;
				}
				
			    public int NUMERIC_PO_R_NUMBERS;

				public int getNUMERIC_PO_R_NUMBERS () {
					return this.NUMERIC_PO_R_NUMBERS;
				}
				
			    public String HOST_SUPPLIER_NUMBER;

				public String getHOST_SUPPLIER_NUMBER () {
					return this.HOST_SUPPLIER_NUMBER;
				}
				
			    public String BOL_COMMENT_2;

				public String getBOL_COMMENT_2 () {
					return this.BOL_COMMENT_2;
				}
				
			    public String HOST_CUSTOMER_NUMBER;

				public String getHOST_CUSTOMER_NUMBER () {
					return this.HOST_CUSTOMER_NUMBER;
				}
				
			    public String TABS_CONSIGNEE_NUMBER;

				public String getTABS_CONSIGNEE_NUMBER () {
					return this.TABS_CONSIGNEE_NUMBER;
				}
				
			    public int TABS_SUBSCRIBER;

				public int getTABS_SUBSCRIBER () {
					return this.TABS_SUBSCRIBER;
				}
				
			    public int ENABLED;

				public int getENABLED () {
					return this.ENABLED;
				}
				
			    public int ALLOCATION_ENABLED;

				public int getALLOCATION_ENABLED () {
					return this.ALLOCATION_ENABLED;
				}
				
			    public int TABS_OFFLINE_DIRECTIVE;

				public int getTABS_OFFLINE_DIRECTIVE () {
					return this.TABS_OFFLINE_DIRECTIVE;
				}
				
			    public int CREDIT_ENABLED;

				public int getCREDIT_ENABLED () {
					return this.CREDIT_ENABLED;
				}
				
			    public int DEST_ALLOCATION_ENABLED;

				public int getDEST_ALLOCATION_ENABLED () {
					return this.DEST_ALLOCATION_ENABLED;
				}
				
			    public int INVOICE_REQUIRED;

				public int getINVOICE_REQUIRED () {
					return this.INVOICE_REQUIRED;
				}
				
			    public String ACCESS_CLASS;

				public String getACCESS_CLASS () {
					return this.ACCESS_CLASS;
				}
				
			    public double CREDIT_LIMIT;

				public double getCREDIT_LIMIT () {
					return this.CREDIT_LIMIT;
				}
				
			    public double RT_CREDIT_BALANCE;

				public double getRT_CREDIT_BALANCE () {
					return this.RT_CREDIT_BALANCE;
				}
				
			    public double RT_CREDIT_COMMITTED;

				public double getRT_CREDIT_COMMITTED () {
					return this.RT_CREDIT_COMMITTED;
				}
				
			    public double RT_CREDIT_USED;

				public double getRT_CREDIT_USED () {
					return this.RT_CREDIT_USED;
				}
				
			    public String LAST_USER_NAME;

				public String getLAST_USER_NAME () {
					return this.LAST_USER_NAME;
				}
				
			    public String PETROEX_NUMBER;

				public String getPETROEX_NUMBER () {
					return this.PETROEX_NUMBER;
				}
				
			    public java.util.Date LAST_MODIFIED;

				public java.util.Date getLAST_MODIFIED () {
					return this.LAST_MODIFIED;
				}
				
			    public int PRINT_NET_ON_BOL;

				public int getPRINT_NET_ON_BOL () {
					return this.PRINT_NET_ON_BOL;
				}
				
			    public String PETROEX_CONSIGNEE_NUMBER;

				public String getPETROEX_CONSIGNEE_NUMBER () {
					return this.PETROEX_CONSIGNEE_NUMBER;
				}
				
			    public int PETROEX_SUBSCRIBER;

				public int getPETROEX_SUBSCRIBER () {
					return this.PETROEX_SUBSCRIBER;
				}
				
			    public int ELVIS_OFFLINE_DIRECTIVE;

				public int getELVIS_OFFLINE_DIRECTIVE () {
					return this.ELVIS_OFFLINE_DIRECTIVE;
				}
				
			    public int ORDER_ALLOCATION_REQUIRED;

				public int getORDER_ALLOCATION_REQUIRED () {
					return this.ORDER_ALLOCATION_REQUIRED;
				}
				
			    public int ALLOCATION_REQUIRED_TO_LOAD;

				public int getALLOCATION_REQUIRED_TO_LOAD () {
					return this.ALLOCATION_REQUIRED_TO_LOAD;
				}
				
			    public int TABS_ORDERS;

				public int getTABS_ORDERS () {
					return this.TABS_ORDERS;
				}
				
			    public String TABS_SELLER_ID;

				public String getTABS_SELLER_ID () {
					return this.TABS_SELLER_ID;
				}
				
			    public String TABS_HOST_INTERFACE_CODE;

				public String getTABS_HOST_INTERFACE_CODE () {
					return this.TABS_HOST_INTERFACE_CODE;
				}
				
			    public int DESTINATION_STATION_ENABLE;

				public int getDESTINATION_STATION_ENABLE () {
					return this.DESTINATION_STATION_ENABLE;
				}
				
			    public int STATION_NUMBER;

				public int getSTATION_NUMBER () {
					return this.STATION_NUMBER;
				}
				
			    public String EXCISE_NUMBER;

				public String getEXCISE_NUMBER () {
					return this.EXCISE_NUMBER;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PGS_STAGE_DIM_CUSTOMER.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_CUSTOMER.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_CUSTOMER = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_CUSTOMER = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PGS_STAGE_DIM_CUSTOMER, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_CUSTOMER, 0, length, utf8Charset);
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
			if(length > commonByteArray_PGS_STAGE_DIM_CUSTOMER.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_CUSTOMER.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_CUSTOMER = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_CUSTOMER = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PGS_STAGE_DIM_CUSTOMER, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_CUSTOMER, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_CUSTOMER) {

        	try {

        		int length = 0;
		
			        this.SUPPLIER_NUMBER = dis.readInt();
					
			        this.CUSTOMER_NUMBER = dis.readInt();
					
					this.API_CODE = readString(dis);
					
					this.BILLING_ADDRESS_1 = readString(dis);
					
					this.DET_NAME2 = readString(dis);
					
			        this.DET_CUSTOMER_NUMBER = dis.readInt();
					
					this.BILLING_ADDRESS_2 = readString(dis);
					
					this.BILLING_ADDRESS_3 = readString(dis);
					
					this.BILLING_ADDRESS_4 = readString(dis);
					
			        this.LOCKOUT_LOADING = dis.readInt();
					
					this.LOCKOUT_LOADING_REASON = readString(dis);
					
			        this.BILLING_TYPE = dis.readInt();
					
					this.PHONE_NUMBER = readString(dis);
					
					this.PURCHASE_ORDER_NUMBER = readString(dis);
					
					this.REQUISITION_NUMBER = readString(dis);
					
			        this.PROMPT_PO_NUMBER = dis.readInt();
					
			        this.PROMPT_R_NUMBER = dis.readInt();
					
					this.BOL_COMMENT_1 = readString(dis);
					
			        this.NUMERIC_PO_R_NUMBERS = dis.readInt();
					
					this.HOST_SUPPLIER_NUMBER = readString(dis);
					
					this.BOL_COMMENT_2 = readString(dis);
					
					this.HOST_CUSTOMER_NUMBER = readString(dis);
					
					this.TABS_CONSIGNEE_NUMBER = readString(dis);
					
			        this.TABS_SUBSCRIBER = dis.readInt();
					
			        this.ENABLED = dis.readInt();
					
			        this.ALLOCATION_ENABLED = dis.readInt();
					
			        this.TABS_OFFLINE_DIRECTIVE = dis.readInt();
					
			        this.CREDIT_ENABLED = dis.readInt();
					
			        this.DEST_ALLOCATION_ENABLED = dis.readInt();
					
			        this.INVOICE_REQUIRED = dis.readInt();
					
					this.ACCESS_CLASS = readString(dis);
					
			        this.CREDIT_LIMIT = dis.readDouble();
					
			        this.RT_CREDIT_BALANCE = dis.readDouble();
					
			        this.RT_CREDIT_COMMITTED = dis.readDouble();
					
			        this.RT_CREDIT_USED = dis.readDouble();
					
					this.LAST_USER_NAME = readString(dis);
					
					this.PETROEX_NUMBER = readString(dis);
					
					this.LAST_MODIFIED = readDate(dis);
					
			        this.PRINT_NET_ON_BOL = dis.readInt();
					
					this.PETROEX_CONSIGNEE_NUMBER = readString(dis);
					
			        this.PETROEX_SUBSCRIBER = dis.readInt();
					
			        this.ELVIS_OFFLINE_DIRECTIVE = dis.readInt();
					
			        this.ORDER_ALLOCATION_REQUIRED = dis.readInt();
					
			        this.ALLOCATION_REQUIRED_TO_LOAD = dis.readInt();
					
			        this.TABS_ORDERS = dis.readInt();
					
					this.TABS_SELLER_ID = readString(dis);
					
					this.TABS_HOST_INTERFACE_CODE = readString(dis);
					
			        this.DESTINATION_STATION_ENABLE = dis.readInt();
					
			        this.STATION_NUMBER = dis.readInt();
					
					this.EXCISE_NUMBER = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_CUSTOMER) {

        	try {

        		int length = 0;
		
			        this.SUPPLIER_NUMBER = dis.readInt();
					
			        this.CUSTOMER_NUMBER = dis.readInt();
					
					this.API_CODE = readString(dis);
					
					this.BILLING_ADDRESS_1 = readString(dis);
					
					this.DET_NAME2 = readString(dis);
					
			        this.DET_CUSTOMER_NUMBER = dis.readInt();
					
					this.BILLING_ADDRESS_2 = readString(dis);
					
					this.BILLING_ADDRESS_3 = readString(dis);
					
					this.BILLING_ADDRESS_4 = readString(dis);
					
			        this.LOCKOUT_LOADING = dis.readInt();
					
					this.LOCKOUT_LOADING_REASON = readString(dis);
					
			        this.BILLING_TYPE = dis.readInt();
					
					this.PHONE_NUMBER = readString(dis);
					
					this.PURCHASE_ORDER_NUMBER = readString(dis);
					
					this.REQUISITION_NUMBER = readString(dis);
					
			        this.PROMPT_PO_NUMBER = dis.readInt();
					
			        this.PROMPT_R_NUMBER = dis.readInt();
					
					this.BOL_COMMENT_1 = readString(dis);
					
			        this.NUMERIC_PO_R_NUMBERS = dis.readInt();
					
					this.HOST_SUPPLIER_NUMBER = readString(dis);
					
					this.BOL_COMMENT_2 = readString(dis);
					
					this.HOST_CUSTOMER_NUMBER = readString(dis);
					
					this.TABS_CONSIGNEE_NUMBER = readString(dis);
					
			        this.TABS_SUBSCRIBER = dis.readInt();
					
			        this.ENABLED = dis.readInt();
					
			        this.ALLOCATION_ENABLED = dis.readInt();
					
			        this.TABS_OFFLINE_DIRECTIVE = dis.readInt();
					
			        this.CREDIT_ENABLED = dis.readInt();
					
			        this.DEST_ALLOCATION_ENABLED = dis.readInt();
					
			        this.INVOICE_REQUIRED = dis.readInt();
					
					this.ACCESS_CLASS = readString(dis);
					
			        this.CREDIT_LIMIT = dis.readDouble();
					
			        this.RT_CREDIT_BALANCE = dis.readDouble();
					
			        this.RT_CREDIT_COMMITTED = dis.readDouble();
					
			        this.RT_CREDIT_USED = dis.readDouble();
					
					this.LAST_USER_NAME = readString(dis);
					
					this.PETROEX_NUMBER = readString(dis);
					
					this.LAST_MODIFIED = readDate(dis);
					
			        this.PRINT_NET_ON_BOL = dis.readInt();
					
					this.PETROEX_CONSIGNEE_NUMBER = readString(dis);
					
			        this.PETROEX_SUBSCRIBER = dis.readInt();
					
			        this.ELVIS_OFFLINE_DIRECTIVE = dis.readInt();
					
			        this.ORDER_ALLOCATION_REQUIRED = dis.readInt();
					
			        this.ALLOCATION_REQUIRED_TO_LOAD = dis.readInt();
					
			        this.TABS_ORDERS = dis.readInt();
					
					this.TABS_SELLER_ID = readString(dis);
					
					this.TABS_HOST_INTERFACE_CODE = readString(dis);
					
			        this.DESTINATION_STATION_ENABLE = dis.readInt();
					
			        this.STATION_NUMBER = dis.readInt();
					
					this.EXCISE_NUMBER = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.SUPPLIER_NUMBER);
					
					// int
				
		            	dos.writeInt(this.CUSTOMER_NUMBER);
					
					// String
				
						writeString(this.API_CODE,dos);
					
					// String
				
						writeString(this.BILLING_ADDRESS_1,dos);
					
					// String
				
						writeString(this.DET_NAME2,dos);
					
					// int
				
		            	dos.writeInt(this.DET_CUSTOMER_NUMBER);
					
					// String
				
						writeString(this.BILLING_ADDRESS_2,dos);
					
					// String
				
						writeString(this.BILLING_ADDRESS_3,dos);
					
					// String
				
						writeString(this.BILLING_ADDRESS_4,dos);
					
					// int
				
		            	dos.writeInt(this.LOCKOUT_LOADING);
					
					// String
				
						writeString(this.LOCKOUT_LOADING_REASON,dos);
					
					// int
				
		            	dos.writeInt(this.BILLING_TYPE);
					
					// String
				
						writeString(this.PHONE_NUMBER,dos);
					
					// String
				
						writeString(this.PURCHASE_ORDER_NUMBER,dos);
					
					// String
				
						writeString(this.REQUISITION_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.PROMPT_PO_NUMBER);
					
					// int
				
		            	dos.writeInt(this.PROMPT_R_NUMBER);
					
					// String
				
						writeString(this.BOL_COMMENT_1,dos);
					
					// int
				
		            	dos.writeInt(this.NUMERIC_PO_R_NUMBERS);
					
					// String
				
						writeString(this.HOST_SUPPLIER_NUMBER,dos);
					
					// String
				
						writeString(this.BOL_COMMENT_2,dos);
					
					// String
				
						writeString(this.HOST_CUSTOMER_NUMBER,dos);
					
					// String
				
						writeString(this.TABS_CONSIGNEE_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.TABS_SUBSCRIBER);
					
					// int
				
		            	dos.writeInt(this.ENABLED);
					
					// int
				
		            	dos.writeInt(this.ALLOCATION_ENABLED);
					
					// int
				
		            	dos.writeInt(this.TABS_OFFLINE_DIRECTIVE);
					
					// int
				
		            	dos.writeInt(this.CREDIT_ENABLED);
					
					// int
				
		            	dos.writeInt(this.DEST_ALLOCATION_ENABLED);
					
					// int
				
		            	dos.writeInt(this.INVOICE_REQUIRED);
					
					// String
				
						writeString(this.ACCESS_CLASS,dos);
					
					// double
				
		            	dos.writeDouble(this.CREDIT_LIMIT);
					
					// double
				
		            	dos.writeDouble(this.RT_CREDIT_BALANCE);
					
					// double
				
		            	dos.writeDouble(this.RT_CREDIT_COMMITTED);
					
					// double
				
		            	dos.writeDouble(this.RT_CREDIT_USED);
					
					// String
				
						writeString(this.LAST_USER_NAME,dos);
					
					// String
				
						writeString(this.PETROEX_NUMBER,dos);
					
					// java.util.Date
				
						writeDate(this.LAST_MODIFIED,dos);
					
					// int
				
		            	dos.writeInt(this.PRINT_NET_ON_BOL);
					
					// String
				
						writeString(this.PETROEX_CONSIGNEE_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.PETROEX_SUBSCRIBER);
					
					// int
				
		            	dos.writeInt(this.ELVIS_OFFLINE_DIRECTIVE);
					
					// int
				
		            	dos.writeInt(this.ORDER_ALLOCATION_REQUIRED);
					
					// int
				
		            	dos.writeInt(this.ALLOCATION_REQUIRED_TO_LOAD);
					
					// int
				
		            	dos.writeInt(this.TABS_ORDERS);
					
					// String
				
						writeString(this.TABS_SELLER_ID,dos);
					
					// String
				
						writeString(this.TABS_HOST_INTERFACE_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.DESTINATION_STATION_ENABLE);
					
					// int
				
		            	dos.writeInt(this.STATION_NUMBER);
					
					// String
				
						writeString(this.EXCISE_NUMBER,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.SUPPLIER_NUMBER);
					
					// int
				
		            	dos.writeInt(this.CUSTOMER_NUMBER);
					
					// String
				
						writeString(this.API_CODE,dos);
					
					// String
				
						writeString(this.BILLING_ADDRESS_1,dos);
					
					// String
				
						writeString(this.DET_NAME2,dos);
					
					// int
				
		            	dos.writeInt(this.DET_CUSTOMER_NUMBER);
					
					// String
				
						writeString(this.BILLING_ADDRESS_2,dos);
					
					// String
				
						writeString(this.BILLING_ADDRESS_3,dos);
					
					// String
				
						writeString(this.BILLING_ADDRESS_4,dos);
					
					// int
				
		            	dos.writeInt(this.LOCKOUT_LOADING);
					
					// String
				
						writeString(this.LOCKOUT_LOADING_REASON,dos);
					
					// int
				
		            	dos.writeInt(this.BILLING_TYPE);
					
					// String
				
						writeString(this.PHONE_NUMBER,dos);
					
					// String
				
						writeString(this.PURCHASE_ORDER_NUMBER,dos);
					
					// String
				
						writeString(this.REQUISITION_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.PROMPT_PO_NUMBER);
					
					// int
				
		            	dos.writeInt(this.PROMPT_R_NUMBER);
					
					// String
				
						writeString(this.BOL_COMMENT_1,dos);
					
					// int
				
		            	dos.writeInt(this.NUMERIC_PO_R_NUMBERS);
					
					// String
				
						writeString(this.HOST_SUPPLIER_NUMBER,dos);
					
					// String
				
						writeString(this.BOL_COMMENT_2,dos);
					
					// String
				
						writeString(this.HOST_CUSTOMER_NUMBER,dos);
					
					// String
				
						writeString(this.TABS_CONSIGNEE_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.TABS_SUBSCRIBER);
					
					// int
				
		            	dos.writeInt(this.ENABLED);
					
					// int
				
		            	dos.writeInt(this.ALLOCATION_ENABLED);
					
					// int
				
		            	dos.writeInt(this.TABS_OFFLINE_DIRECTIVE);
					
					// int
				
		            	dos.writeInt(this.CREDIT_ENABLED);
					
					// int
				
		            	dos.writeInt(this.DEST_ALLOCATION_ENABLED);
					
					// int
				
		            	dos.writeInt(this.INVOICE_REQUIRED);
					
					// String
				
						writeString(this.ACCESS_CLASS,dos);
					
					// double
				
		            	dos.writeDouble(this.CREDIT_LIMIT);
					
					// double
				
		            	dos.writeDouble(this.RT_CREDIT_BALANCE);
					
					// double
				
		            	dos.writeDouble(this.RT_CREDIT_COMMITTED);
					
					// double
				
		            	dos.writeDouble(this.RT_CREDIT_USED);
					
					// String
				
						writeString(this.LAST_USER_NAME,dos);
					
					// String
				
						writeString(this.PETROEX_NUMBER,dos);
					
					// java.util.Date
				
						writeDate(this.LAST_MODIFIED,dos);
					
					// int
				
		            	dos.writeInt(this.PRINT_NET_ON_BOL);
					
					// String
				
						writeString(this.PETROEX_CONSIGNEE_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.PETROEX_SUBSCRIBER);
					
					// int
				
		            	dos.writeInt(this.ELVIS_OFFLINE_DIRECTIVE);
					
					// int
				
		            	dos.writeInt(this.ORDER_ALLOCATION_REQUIRED);
					
					// int
				
		            	dos.writeInt(this.ALLOCATION_REQUIRED_TO_LOAD);
					
					// int
				
		            	dos.writeInt(this.TABS_ORDERS);
					
					// String
				
						writeString(this.TABS_SELLER_ID,dos);
					
					// String
				
						writeString(this.TABS_HOST_INTERFACE_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.DESTINATION_STATION_ENABLE);
					
					// int
				
		            	dos.writeInt(this.STATION_NUMBER);
					
					// String
				
						writeString(this.EXCISE_NUMBER,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("SUPPLIER_NUMBER="+String.valueOf(SUPPLIER_NUMBER));
		sb.append(",CUSTOMER_NUMBER="+String.valueOf(CUSTOMER_NUMBER));
		sb.append(",API_CODE="+API_CODE);
		sb.append(",BILLING_ADDRESS_1="+BILLING_ADDRESS_1);
		sb.append(",DET_NAME2="+DET_NAME2);
		sb.append(",DET_CUSTOMER_NUMBER="+String.valueOf(DET_CUSTOMER_NUMBER));
		sb.append(",BILLING_ADDRESS_2="+BILLING_ADDRESS_2);
		sb.append(",BILLING_ADDRESS_3="+BILLING_ADDRESS_3);
		sb.append(",BILLING_ADDRESS_4="+BILLING_ADDRESS_4);
		sb.append(",LOCKOUT_LOADING="+String.valueOf(LOCKOUT_LOADING));
		sb.append(",LOCKOUT_LOADING_REASON="+LOCKOUT_LOADING_REASON);
		sb.append(",BILLING_TYPE="+String.valueOf(BILLING_TYPE));
		sb.append(",PHONE_NUMBER="+PHONE_NUMBER);
		sb.append(",PURCHASE_ORDER_NUMBER="+PURCHASE_ORDER_NUMBER);
		sb.append(",REQUISITION_NUMBER="+REQUISITION_NUMBER);
		sb.append(",PROMPT_PO_NUMBER="+String.valueOf(PROMPT_PO_NUMBER));
		sb.append(",PROMPT_R_NUMBER="+String.valueOf(PROMPT_R_NUMBER));
		sb.append(",BOL_COMMENT_1="+BOL_COMMENT_1);
		sb.append(",NUMERIC_PO_R_NUMBERS="+String.valueOf(NUMERIC_PO_R_NUMBERS));
		sb.append(",HOST_SUPPLIER_NUMBER="+HOST_SUPPLIER_NUMBER);
		sb.append(",BOL_COMMENT_2="+BOL_COMMENT_2);
		sb.append(",HOST_CUSTOMER_NUMBER="+HOST_CUSTOMER_NUMBER);
		sb.append(",TABS_CONSIGNEE_NUMBER="+TABS_CONSIGNEE_NUMBER);
		sb.append(",TABS_SUBSCRIBER="+String.valueOf(TABS_SUBSCRIBER));
		sb.append(",ENABLED="+String.valueOf(ENABLED));
		sb.append(",ALLOCATION_ENABLED="+String.valueOf(ALLOCATION_ENABLED));
		sb.append(",TABS_OFFLINE_DIRECTIVE="+String.valueOf(TABS_OFFLINE_DIRECTIVE));
		sb.append(",CREDIT_ENABLED="+String.valueOf(CREDIT_ENABLED));
		sb.append(",DEST_ALLOCATION_ENABLED="+String.valueOf(DEST_ALLOCATION_ENABLED));
		sb.append(",INVOICE_REQUIRED="+String.valueOf(INVOICE_REQUIRED));
		sb.append(",ACCESS_CLASS="+ACCESS_CLASS);
		sb.append(",CREDIT_LIMIT="+String.valueOf(CREDIT_LIMIT));
		sb.append(",RT_CREDIT_BALANCE="+String.valueOf(RT_CREDIT_BALANCE));
		sb.append(",RT_CREDIT_COMMITTED="+String.valueOf(RT_CREDIT_COMMITTED));
		sb.append(",RT_CREDIT_USED="+String.valueOf(RT_CREDIT_USED));
		sb.append(",LAST_USER_NAME="+LAST_USER_NAME);
		sb.append(",PETROEX_NUMBER="+PETROEX_NUMBER);
		sb.append(",LAST_MODIFIED="+String.valueOf(LAST_MODIFIED));
		sb.append(",PRINT_NET_ON_BOL="+String.valueOf(PRINT_NET_ON_BOL));
		sb.append(",PETROEX_CONSIGNEE_NUMBER="+PETROEX_CONSIGNEE_NUMBER);
		sb.append(",PETROEX_SUBSCRIBER="+String.valueOf(PETROEX_SUBSCRIBER));
		sb.append(",ELVIS_OFFLINE_DIRECTIVE="+String.valueOf(ELVIS_OFFLINE_DIRECTIVE));
		sb.append(",ORDER_ALLOCATION_REQUIRED="+String.valueOf(ORDER_ALLOCATION_REQUIRED));
		sb.append(",ALLOCATION_REQUIRED_TO_LOAD="+String.valueOf(ALLOCATION_REQUIRED_TO_LOAD));
		sb.append(",TABS_ORDERS="+String.valueOf(TABS_ORDERS));
		sb.append(",TABS_SELLER_ID="+TABS_SELLER_ID);
		sb.append(",TABS_HOST_INTERFACE_CODE="+TABS_HOST_INTERFACE_CODE);
		sb.append(",DESTINATION_STATION_ENABLE="+String.valueOf(DESTINATION_STATION_ENABLE));
		sb.append(",STATION_NUMBER="+String.valueOf(STATION_NUMBER));
		sb.append(",EXCISE_NUMBER="+EXCISE_NUMBER);
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
    final static byte[] commonByteArrayLock_PGS_STAGE_DIM_CUSTOMER = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_DIM_CUSTOMER = new byte[0];

	
			    public int SUPPLIER_NUMBER;

				public int getSUPPLIER_NUMBER () {
					return this.SUPPLIER_NUMBER;
				}
				
			    public int CUSTOMER_NUMBER;

				public int getCUSTOMER_NUMBER () {
					return this.CUSTOMER_NUMBER;
				}
				
			    public String API_CODE;

				public String getAPI_CODE () {
					return this.API_CODE;
				}
				
			    public String BILLING_ADDRESS_1;

				public String getBILLING_ADDRESS_1 () {
					return this.BILLING_ADDRESS_1;
				}
				
			    public String DET_NAME2;

				public String getDET_NAME2 () {
					return this.DET_NAME2;
				}
				
			    public int DET_CUSTOMER_NUMBER;

				public int getDET_CUSTOMER_NUMBER () {
					return this.DET_CUSTOMER_NUMBER;
				}
				
			    public String BILLING_ADDRESS_2;

				public String getBILLING_ADDRESS_2 () {
					return this.BILLING_ADDRESS_2;
				}
				
			    public String BILLING_ADDRESS_3;

				public String getBILLING_ADDRESS_3 () {
					return this.BILLING_ADDRESS_3;
				}
				
			    public String BILLING_ADDRESS_4;

				public String getBILLING_ADDRESS_4 () {
					return this.BILLING_ADDRESS_4;
				}
				
			    public int LOCKOUT_LOADING;

				public int getLOCKOUT_LOADING () {
					return this.LOCKOUT_LOADING;
				}
				
			    public String LOCKOUT_LOADING_REASON;

				public String getLOCKOUT_LOADING_REASON () {
					return this.LOCKOUT_LOADING_REASON;
				}
				
			    public int BILLING_TYPE;

				public int getBILLING_TYPE () {
					return this.BILLING_TYPE;
				}
				
			    public String PHONE_NUMBER;

				public String getPHONE_NUMBER () {
					return this.PHONE_NUMBER;
				}
				
			    public String PURCHASE_ORDER_NUMBER;

				public String getPURCHASE_ORDER_NUMBER () {
					return this.PURCHASE_ORDER_NUMBER;
				}
				
			    public String REQUISITION_NUMBER;

				public String getREQUISITION_NUMBER () {
					return this.REQUISITION_NUMBER;
				}
				
			    public int PROMPT_PO_NUMBER;

				public int getPROMPT_PO_NUMBER () {
					return this.PROMPT_PO_NUMBER;
				}
				
			    public int PROMPT_R_NUMBER;

				public int getPROMPT_R_NUMBER () {
					return this.PROMPT_R_NUMBER;
				}
				
			    public String BOL_COMMENT_1;

				public String getBOL_COMMENT_1 () {
					return this.BOL_COMMENT_1;
				}
				
			    public int NUMERIC_PO_R_NUMBERS;

				public int getNUMERIC_PO_R_NUMBERS () {
					return this.NUMERIC_PO_R_NUMBERS;
				}
				
			    public String HOST_SUPPLIER_NUMBER;

				public String getHOST_SUPPLIER_NUMBER () {
					return this.HOST_SUPPLIER_NUMBER;
				}
				
			    public String BOL_COMMENT_2;

				public String getBOL_COMMENT_2 () {
					return this.BOL_COMMENT_2;
				}
				
			    public String HOST_CUSTOMER_NUMBER;

				public String getHOST_CUSTOMER_NUMBER () {
					return this.HOST_CUSTOMER_NUMBER;
				}
				
			    public String TABS_CONSIGNEE_NUMBER;

				public String getTABS_CONSIGNEE_NUMBER () {
					return this.TABS_CONSIGNEE_NUMBER;
				}
				
			    public int TABS_SUBSCRIBER;

				public int getTABS_SUBSCRIBER () {
					return this.TABS_SUBSCRIBER;
				}
				
			    public int ENABLED;

				public int getENABLED () {
					return this.ENABLED;
				}
				
			    public int ALLOCATION_ENABLED;

				public int getALLOCATION_ENABLED () {
					return this.ALLOCATION_ENABLED;
				}
				
			    public int TABS_OFFLINE_DIRECTIVE;

				public int getTABS_OFFLINE_DIRECTIVE () {
					return this.TABS_OFFLINE_DIRECTIVE;
				}
				
			    public int CREDIT_ENABLED;

				public int getCREDIT_ENABLED () {
					return this.CREDIT_ENABLED;
				}
				
			    public int DEST_ALLOCATION_ENABLED;

				public int getDEST_ALLOCATION_ENABLED () {
					return this.DEST_ALLOCATION_ENABLED;
				}
				
			    public int INVOICE_REQUIRED;

				public int getINVOICE_REQUIRED () {
					return this.INVOICE_REQUIRED;
				}
				
			    public String ACCESS_CLASS;

				public String getACCESS_CLASS () {
					return this.ACCESS_CLASS;
				}
				
			    public double CREDIT_LIMIT;

				public double getCREDIT_LIMIT () {
					return this.CREDIT_LIMIT;
				}
				
			    public double RT_CREDIT_BALANCE;

				public double getRT_CREDIT_BALANCE () {
					return this.RT_CREDIT_BALANCE;
				}
				
			    public double RT_CREDIT_COMMITTED;

				public double getRT_CREDIT_COMMITTED () {
					return this.RT_CREDIT_COMMITTED;
				}
				
			    public double RT_CREDIT_USED;

				public double getRT_CREDIT_USED () {
					return this.RT_CREDIT_USED;
				}
				
			    public String LAST_USER_NAME;

				public String getLAST_USER_NAME () {
					return this.LAST_USER_NAME;
				}
				
			    public String PETROEX_NUMBER;

				public String getPETROEX_NUMBER () {
					return this.PETROEX_NUMBER;
				}
				
			    public java.util.Date LAST_MODIFIED;

				public java.util.Date getLAST_MODIFIED () {
					return this.LAST_MODIFIED;
				}
				
			    public int PRINT_NET_ON_BOL;

				public int getPRINT_NET_ON_BOL () {
					return this.PRINT_NET_ON_BOL;
				}
				
			    public String PETROEX_CONSIGNEE_NUMBER;

				public String getPETROEX_CONSIGNEE_NUMBER () {
					return this.PETROEX_CONSIGNEE_NUMBER;
				}
				
			    public int PETROEX_SUBSCRIBER;

				public int getPETROEX_SUBSCRIBER () {
					return this.PETROEX_SUBSCRIBER;
				}
				
			    public int ELVIS_OFFLINE_DIRECTIVE;

				public int getELVIS_OFFLINE_DIRECTIVE () {
					return this.ELVIS_OFFLINE_DIRECTIVE;
				}
				
			    public int ORDER_ALLOCATION_REQUIRED;

				public int getORDER_ALLOCATION_REQUIRED () {
					return this.ORDER_ALLOCATION_REQUIRED;
				}
				
			    public int ALLOCATION_REQUIRED_TO_LOAD;

				public int getALLOCATION_REQUIRED_TO_LOAD () {
					return this.ALLOCATION_REQUIRED_TO_LOAD;
				}
				
			    public int TABS_ORDERS;

				public int getTABS_ORDERS () {
					return this.TABS_ORDERS;
				}
				
			    public String TABS_SELLER_ID;

				public String getTABS_SELLER_ID () {
					return this.TABS_SELLER_ID;
				}
				
			    public String TABS_HOST_INTERFACE_CODE;

				public String getTABS_HOST_INTERFACE_CODE () {
					return this.TABS_HOST_INTERFACE_CODE;
				}
				
			    public int DESTINATION_STATION_ENABLE;

				public int getDESTINATION_STATION_ENABLE () {
					return this.DESTINATION_STATION_ENABLE;
				}
				
			    public int STATION_NUMBER;

				public int getSTATION_NUMBER () {
					return this.STATION_NUMBER;
				}
				
			    public String EXCISE_NUMBER;

				public String getEXCISE_NUMBER () {
					return this.EXCISE_NUMBER;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PGS_STAGE_DIM_CUSTOMER.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_CUSTOMER.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_CUSTOMER = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_CUSTOMER = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PGS_STAGE_DIM_CUSTOMER, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_CUSTOMER, 0, length, utf8Charset);
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
			if(length > commonByteArray_PGS_STAGE_DIM_CUSTOMER.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_CUSTOMER.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_CUSTOMER = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_CUSTOMER = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PGS_STAGE_DIM_CUSTOMER, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_CUSTOMER, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_CUSTOMER) {

        	try {

        		int length = 0;
		
			        this.SUPPLIER_NUMBER = dis.readInt();
					
			        this.CUSTOMER_NUMBER = dis.readInt();
					
					this.API_CODE = readString(dis);
					
					this.BILLING_ADDRESS_1 = readString(dis);
					
					this.DET_NAME2 = readString(dis);
					
			        this.DET_CUSTOMER_NUMBER = dis.readInt();
					
					this.BILLING_ADDRESS_2 = readString(dis);
					
					this.BILLING_ADDRESS_3 = readString(dis);
					
					this.BILLING_ADDRESS_4 = readString(dis);
					
			        this.LOCKOUT_LOADING = dis.readInt();
					
					this.LOCKOUT_LOADING_REASON = readString(dis);
					
			        this.BILLING_TYPE = dis.readInt();
					
					this.PHONE_NUMBER = readString(dis);
					
					this.PURCHASE_ORDER_NUMBER = readString(dis);
					
					this.REQUISITION_NUMBER = readString(dis);
					
			        this.PROMPT_PO_NUMBER = dis.readInt();
					
			        this.PROMPT_R_NUMBER = dis.readInt();
					
					this.BOL_COMMENT_1 = readString(dis);
					
			        this.NUMERIC_PO_R_NUMBERS = dis.readInt();
					
					this.HOST_SUPPLIER_NUMBER = readString(dis);
					
					this.BOL_COMMENT_2 = readString(dis);
					
					this.HOST_CUSTOMER_NUMBER = readString(dis);
					
					this.TABS_CONSIGNEE_NUMBER = readString(dis);
					
			        this.TABS_SUBSCRIBER = dis.readInt();
					
			        this.ENABLED = dis.readInt();
					
			        this.ALLOCATION_ENABLED = dis.readInt();
					
			        this.TABS_OFFLINE_DIRECTIVE = dis.readInt();
					
			        this.CREDIT_ENABLED = dis.readInt();
					
			        this.DEST_ALLOCATION_ENABLED = dis.readInt();
					
			        this.INVOICE_REQUIRED = dis.readInt();
					
					this.ACCESS_CLASS = readString(dis);
					
			        this.CREDIT_LIMIT = dis.readDouble();
					
			        this.RT_CREDIT_BALANCE = dis.readDouble();
					
			        this.RT_CREDIT_COMMITTED = dis.readDouble();
					
			        this.RT_CREDIT_USED = dis.readDouble();
					
					this.LAST_USER_NAME = readString(dis);
					
					this.PETROEX_NUMBER = readString(dis);
					
					this.LAST_MODIFIED = readDate(dis);
					
			        this.PRINT_NET_ON_BOL = dis.readInt();
					
					this.PETROEX_CONSIGNEE_NUMBER = readString(dis);
					
			        this.PETROEX_SUBSCRIBER = dis.readInt();
					
			        this.ELVIS_OFFLINE_DIRECTIVE = dis.readInt();
					
			        this.ORDER_ALLOCATION_REQUIRED = dis.readInt();
					
			        this.ALLOCATION_REQUIRED_TO_LOAD = dis.readInt();
					
			        this.TABS_ORDERS = dis.readInt();
					
					this.TABS_SELLER_ID = readString(dis);
					
					this.TABS_HOST_INTERFACE_CODE = readString(dis);
					
			        this.DESTINATION_STATION_ENABLE = dis.readInt();
					
			        this.STATION_NUMBER = dis.readInt();
					
					this.EXCISE_NUMBER = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_CUSTOMER) {

        	try {

        		int length = 0;
		
			        this.SUPPLIER_NUMBER = dis.readInt();
					
			        this.CUSTOMER_NUMBER = dis.readInt();
					
					this.API_CODE = readString(dis);
					
					this.BILLING_ADDRESS_1 = readString(dis);
					
					this.DET_NAME2 = readString(dis);
					
			        this.DET_CUSTOMER_NUMBER = dis.readInt();
					
					this.BILLING_ADDRESS_2 = readString(dis);
					
					this.BILLING_ADDRESS_3 = readString(dis);
					
					this.BILLING_ADDRESS_4 = readString(dis);
					
			        this.LOCKOUT_LOADING = dis.readInt();
					
					this.LOCKOUT_LOADING_REASON = readString(dis);
					
			        this.BILLING_TYPE = dis.readInt();
					
					this.PHONE_NUMBER = readString(dis);
					
					this.PURCHASE_ORDER_NUMBER = readString(dis);
					
					this.REQUISITION_NUMBER = readString(dis);
					
			        this.PROMPT_PO_NUMBER = dis.readInt();
					
			        this.PROMPT_R_NUMBER = dis.readInt();
					
					this.BOL_COMMENT_1 = readString(dis);
					
			        this.NUMERIC_PO_R_NUMBERS = dis.readInt();
					
					this.HOST_SUPPLIER_NUMBER = readString(dis);
					
					this.BOL_COMMENT_2 = readString(dis);
					
					this.HOST_CUSTOMER_NUMBER = readString(dis);
					
					this.TABS_CONSIGNEE_NUMBER = readString(dis);
					
			        this.TABS_SUBSCRIBER = dis.readInt();
					
			        this.ENABLED = dis.readInt();
					
			        this.ALLOCATION_ENABLED = dis.readInt();
					
			        this.TABS_OFFLINE_DIRECTIVE = dis.readInt();
					
			        this.CREDIT_ENABLED = dis.readInt();
					
			        this.DEST_ALLOCATION_ENABLED = dis.readInt();
					
			        this.INVOICE_REQUIRED = dis.readInt();
					
					this.ACCESS_CLASS = readString(dis);
					
			        this.CREDIT_LIMIT = dis.readDouble();
					
			        this.RT_CREDIT_BALANCE = dis.readDouble();
					
			        this.RT_CREDIT_COMMITTED = dis.readDouble();
					
			        this.RT_CREDIT_USED = dis.readDouble();
					
					this.LAST_USER_NAME = readString(dis);
					
					this.PETROEX_NUMBER = readString(dis);
					
					this.LAST_MODIFIED = readDate(dis);
					
			        this.PRINT_NET_ON_BOL = dis.readInt();
					
					this.PETROEX_CONSIGNEE_NUMBER = readString(dis);
					
			        this.PETROEX_SUBSCRIBER = dis.readInt();
					
			        this.ELVIS_OFFLINE_DIRECTIVE = dis.readInt();
					
			        this.ORDER_ALLOCATION_REQUIRED = dis.readInt();
					
			        this.ALLOCATION_REQUIRED_TO_LOAD = dis.readInt();
					
			        this.TABS_ORDERS = dis.readInt();
					
					this.TABS_SELLER_ID = readString(dis);
					
					this.TABS_HOST_INTERFACE_CODE = readString(dis);
					
			        this.DESTINATION_STATION_ENABLE = dis.readInt();
					
			        this.STATION_NUMBER = dis.readInt();
					
					this.EXCISE_NUMBER = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.SUPPLIER_NUMBER);
					
					// int
				
		            	dos.writeInt(this.CUSTOMER_NUMBER);
					
					// String
				
						writeString(this.API_CODE,dos);
					
					// String
				
						writeString(this.BILLING_ADDRESS_1,dos);
					
					// String
				
						writeString(this.DET_NAME2,dos);
					
					// int
				
		            	dos.writeInt(this.DET_CUSTOMER_NUMBER);
					
					// String
				
						writeString(this.BILLING_ADDRESS_2,dos);
					
					// String
				
						writeString(this.BILLING_ADDRESS_3,dos);
					
					// String
				
						writeString(this.BILLING_ADDRESS_4,dos);
					
					// int
				
		            	dos.writeInt(this.LOCKOUT_LOADING);
					
					// String
				
						writeString(this.LOCKOUT_LOADING_REASON,dos);
					
					// int
				
		            	dos.writeInt(this.BILLING_TYPE);
					
					// String
				
						writeString(this.PHONE_NUMBER,dos);
					
					// String
				
						writeString(this.PURCHASE_ORDER_NUMBER,dos);
					
					// String
				
						writeString(this.REQUISITION_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.PROMPT_PO_NUMBER);
					
					// int
				
		            	dos.writeInt(this.PROMPT_R_NUMBER);
					
					// String
				
						writeString(this.BOL_COMMENT_1,dos);
					
					// int
				
		            	dos.writeInt(this.NUMERIC_PO_R_NUMBERS);
					
					// String
				
						writeString(this.HOST_SUPPLIER_NUMBER,dos);
					
					// String
				
						writeString(this.BOL_COMMENT_2,dos);
					
					// String
				
						writeString(this.HOST_CUSTOMER_NUMBER,dos);
					
					// String
				
						writeString(this.TABS_CONSIGNEE_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.TABS_SUBSCRIBER);
					
					// int
				
		            	dos.writeInt(this.ENABLED);
					
					// int
				
		            	dos.writeInt(this.ALLOCATION_ENABLED);
					
					// int
				
		            	dos.writeInt(this.TABS_OFFLINE_DIRECTIVE);
					
					// int
				
		            	dos.writeInt(this.CREDIT_ENABLED);
					
					// int
				
		            	dos.writeInt(this.DEST_ALLOCATION_ENABLED);
					
					// int
				
		            	dos.writeInt(this.INVOICE_REQUIRED);
					
					// String
				
						writeString(this.ACCESS_CLASS,dos);
					
					// double
				
		            	dos.writeDouble(this.CREDIT_LIMIT);
					
					// double
				
		            	dos.writeDouble(this.RT_CREDIT_BALANCE);
					
					// double
				
		            	dos.writeDouble(this.RT_CREDIT_COMMITTED);
					
					// double
				
		            	dos.writeDouble(this.RT_CREDIT_USED);
					
					// String
				
						writeString(this.LAST_USER_NAME,dos);
					
					// String
				
						writeString(this.PETROEX_NUMBER,dos);
					
					// java.util.Date
				
						writeDate(this.LAST_MODIFIED,dos);
					
					// int
				
		            	dos.writeInt(this.PRINT_NET_ON_BOL);
					
					// String
				
						writeString(this.PETROEX_CONSIGNEE_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.PETROEX_SUBSCRIBER);
					
					// int
				
		            	dos.writeInt(this.ELVIS_OFFLINE_DIRECTIVE);
					
					// int
				
		            	dos.writeInt(this.ORDER_ALLOCATION_REQUIRED);
					
					// int
				
		            	dos.writeInt(this.ALLOCATION_REQUIRED_TO_LOAD);
					
					// int
				
		            	dos.writeInt(this.TABS_ORDERS);
					
					// String
				
						writeString(this.TABS_SELLER_ID,dos);
					
					// String
				
						writeString(this.TABS_HOST_INTERFACE_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.DESTINATION_STATION_ENABLE);
					
					// int
				
		            	dos.writeInt(this.STATION_NUMBER);
					
					// String
				
						writeString(this.EXCISE_NUMBER,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.SUPPLIER_NUMBER);
					
					// int
				
		            	dos.writeInt(this.CUSTOMER_NUMBER);
					
					// String
				
						writeString(this.API_CODE,dos);
					
					// String
				
						writeString(this.BILLING_ADDRESS_1,dos);
					
					// String
				
						writeString(this.DET_NAME2,dos);
					
					// int
				
		            	dos.writeInt(this.DET_CUSTOMER_NUMBER);
					
					// String
				
						writeString(this.BILLING_ADDRESS_2,dos);
					
					// String
				
						writeString(this.BILLING_ADDRESS_3,dos);
					
					// String
				
						writeString(this.BILLING_ADDRESS_4,dos);
					
					// int
				
		            	dos.writeInt(this.LOCKOUT_LOADING);
					
					// String
				
						writeString(this.LOCKOUT_LOADING_REASON,dos);
					
					// int
				
		            	dos.writeInt(this.BILLING_TYPE);
					
					// String
				
						writeString(this.PHONE_NUMBER,dos);
					
					// String
				
						writeString(this.PURCHASE_ORDER_NUMBER,dos);
					
					// String
				
						writeString(this.REQUISITION_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.PROMPT_PO_NUMBER);
					
					// int
				
		            	dos.writeInt(this.PROMPT_R_NUMBER);
					
					// String
				
						writeString(this.BOL_COMMENT_1,dos);
					
					// int
				
		            	dos.writeInt(this.NUMERIC_PO_R_NUMBERS);
					
					// String
				
						writeString(this.HOST_SUPPLIER_NUMBER,dos);
					
					// String
				
						writeString(this.BOL_COMMENT_2,dos);
					
					// String
				
						writeString(this.HOST_CUSTOMER_NUMBER,dos);
					
					// String
				
						writeString(this.TABS_CONSIGNEE_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.TABS_SUBSCRIBER);
					
					// int
				
		            	dos.writeInt(this.ENABLED);
					
					// int
				
		            	dos.writeInt(this.ALLOCATION_ENABLED);
					
					// int
				
		            	dos.writeInt(this.TABS_OFFLINE_DIRECTIVE);
					
					// int
				
		            	dos.writeInt(this.CREDIT_ENABLED);
					
					// int
				
		            	dos.writeInt(this.DEST_ALLOCATION_ENABLED);
					
					// int
				
		            	dos.writeInt(this.INVOICE_REQUIRED);
					
					// String
				
						writeString(this.ACCESS_CLASS,dos);
					
					// double
				
		            	dos.writeDouble(this.CREDIT_LIMIT);
					
					// double
				
		            	dos.writeDouble(this.RT_CREDIT_BALANCE);
					
					// double
				
		            	dos.writeDouble(this.RT_CREDIT_COMMITTED);
					
					// double
				
		            	dos.writeDouble(this.RT_CREDIT_USED);
					
					// String
				
						writeString(this.LAST_USER_NAME,dos);
					
					// String
				
						writeString(this.PETROEX_NUMBER,dos);
					
					// java.util.Date
				
						writeDate(this.LAST_MODIFIED,dos);
					
					// int
				
		            	dos.writeInt(this.PRINT_NET_ON_BOL);
					
					// String
				
						writeString(this.PETROEX_CONSIGNEE_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.PETROEX_SUBSCRIBER);
					
					// int
				
		            	dos.writeInt(this.ELVIS_OFFLINE_DIRECTIVE);
					
					// int
				
		            	dos.writeInt(this.ORDER_ALLOCATION_REQUIRED);
					
					// int
				
		            	dos.writeInt(this.ALLOCATION_REQUIRED_TO_LOAD);
					
					// int
				
		            	dos.writeInt(this.TABS_ORDERS);
					
					// String
				
						writeString(this.TABS_SELLER_ID,dos);
					
					// String
				
						writeString(this.TABS_HOST_INTERFACE_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.DESTINATION_STATION_ENABLE);
					
					// int
				
		            	dos.writeInt(this.STATION_NUMBER);
					
					// String
				
						writeString(this.EXCISE_NUMBER,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("SUPPLIER_NUMBER="+String.valueOf(SUPPLIER_NUMBER));
		sb.append(",CUSTOMER_NUMBER="+String.valueOf(CUSTOMER_NUMBER));
		sb.append(",API_CODE="+API_CODE);
		sb.append(",BILLING_ADDRESS_1="+BILLING_ADDRESS_1);
		sb.append(",DET_NAME2="+DET_NAME2);
		sb.append(",DET_CUSTOMER_NUMBER="+String.valueOf(DET_CUSTOMER_NUMBER));
		sb.append(",BILLING_ADDRESS_2="+BILLING_ADDRESS_2);
		sb.append(",BILLING_ADDRESS_3="+BILLING_ADDRESS_3);
		sb.append(",BILLING_ADDRESS_4="+BILLING_ADDRESS_4);
		sb.append(",LOCKOUT_LOADING="+String.valueOf(LOCKOUT_LOADING));
		sb.append(",LOCKOUT_LOADING_REASON="+LOCKOUT_LOADING_REASON);
		sb.append(",BILLING_TYPE="+String.valueOf(BILLING_TYPE));
		sb.append(",PHONE_NUMBER="+PHONE_NUMBER);
		sb.append(",PURCHASE_ORDER_NUMBER="+PURCHASE_ORDER_NUMBER);
		sb.append(",REQUISITION_NUMBER="+REQUISITION_NUMBER);
		sb.append(",PROMPT_PO_NUMBER="+String.valueOf(PROMPT_PO_NUMBER));
		sb.append(",PROMPT_R_NUMBER="+String.valueOf(PROMPT_R_NUMBER));
		sb.append(",BOL_COMMENT_1="+BOL_COMMENT_1);
		sb.append(",NUMERIC_PO_R_NUMBERS="+String.valueOf(NUMERIC_PO_R_NUMBERS));
		sb.append(",HOST_SUPPLIER_NUMBER="+HOST_SUPPLIER_NUMBER);
		sb.append(",BOL_COMMENT_2="+BOL_COMMENT_2);
		sb.append(",HOST_CUSTOMER_NUMBER="+HOST_CUSTOMER_NUMBER);
		sb.append(",TABS_CONSIGNEE_NUMBER="+TABS_CONSIGNEE_NUMBER);
		sb.append(",TABS_SUBSCRIBER="+String.valueOf(TABS_SUBSCRIBER));
		sb.append(",ENABLED="+String.valueOf(ENABLED));
		sb.append(",ALLOCATION_ENABLED="+String.valueOf(ALLOCATION_ENABLED));
		sb.append(",TABS_OFFLINE_DIRECTIVE="+String.valueOf(TABS_OFFLINE_DIRECTIVE));
		sb.append(",CREDIT_ENABLED="+String.valueOf(CREDIT_ENABLED));
		sb.append(",DEST_ALLOCATION_ENABLED="+String.valueOf(DEST_ALLOCATION_ENABLED));
		sb.append(",INVOICE_REQUIRED="+String.valueOf(INVOICE_REQUIRED));
		sb.append(",ACCESS_CLASS="+ACCESS_CLASS);
		sb.append(",CREDIT_LIMIT="+String.valueOf(CREDIT_LIMIT));
		sb.append(",RT_CREDIT_BALANCE="+String.valueOf(RT_CREDIT_BALANCE));
		sb.append(",RT_CREDIT_COMMITTED="+String.valueOf(RT_CREDIT_COMMITTED));
		sb.append(",RT_CREDIT_USED="+String.valueOf(RT_CREDIT_USED));
		sb.append(",LAST_USER_NAME="+LAST_USER_NAME);
		sb.append(",PETROEX_NUMBER="+PETROEX_NUMBER);
		sb.append(",LAST_MODIFIED="+String.valueOf(LAST_MODIFIED));
		sb.append(",PRINT_NET_ON_BOL="+String.valueOf(PRINT_NET_ON_BOL));
		sb.append(",PETROEX_CONSIGNEE_NUMBER="+PETROEX_CONSIGNEE_NUMBER);
		sb.append(",PETROEX_SUBSCRIBER="+String.valueOf(PETROEX_SUBSCRIBER));
		sb.append(",ELVIS_OFFLINE_DIRECTIVE="+String.valueOf(ELVIS_OFFLINE_DIRECTIVE));
		sb.append(",ORDER_ALLOCATION_REQUIRED="+String.valueOf(ORDER_ALLOCATION_REQUIRED));
		sb.append(",ALLOCATION_REQUIRED_TO_LOAD="+String.valueOf(ALLOCATION_REQUIRED_TO_LOAD));
		sb.append(",TABS_ORDERS="+String.valueOf(TABS_ORDERS));
		sb.append(",TABS_SELLER_ID="+TABS_SELLER_ID);
		sb.append(",TABS_HOST_INTERFACE_CODE="+TABS_HOST_INTERFACE_CODE);
		sb.append(",DESTINATION_STATION_ENABLE="+String.valueOf(DESTINATION_STATION_ENABLE));
		sb.append(",STATION_NUMBER="+String.valueOf(STATION_NUMBER));
		sb.append(",EXCISE_NUMBER="+EXCISE_NUMBER);
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
    final static byte[] commonByteArrayLock_PGS_STAGE_DIM_CUSTOMER = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_DIM_CUSTOMER = new byte[0];

	
			    public int SUPPLIER_NUMBER;

				public int getSUPPLIER_NUMBER () {
					return this.SUPPLIER_NUMBER;
				}
				
			    public int CUSTOMER_NUMBER;

				public int getCUSTOMER_NUMBER () {
					return this.CUSTOMER_NUMBER;
				}
				
			    public String API_CODE;

				public String getAPI_CODE () {
					return this.API_CODE;
				}
				
			    public String BILLING_ADDRESS_1;

				public String getBILLING_ADDRESS_1 () {
					return this.BILLING_ADDRESS_1;
				}
				
			    public String DET_NAME2;

				public String getDET_NAME2 () {
					return this.DET_NAME2;
				}
				
			    public int DET_CUSTOMER_NUMBER;

				public int getDET_CUSTOMER_NUMBER () {
					return this.DET_CUSTOMER_NUMBER;
				}
				
			    public String BILLING_ADDRESS_2;

				public String getBILLING_ADDRESS_2 () {
					return this.BILLING_ADDRESS_2;
				}
				
			    public String BILLING_ADDRESS_3;

				public String getBILLING_ADDRESS_3 () {
					return this.BILLING_ADDRESS_3;
				}
				
			    public String BILLING_ADDRESS_4;

				public String getBILLING_ADDRESS_4 () {
					return this.BILLING_ADDRESS_4;
				}
				
			    public int LOCKOUT_LOADING;

				public int getLOCKOUT_LOADING () {
					return this.LOCKOUT_LOADING;
				}
				
			    public String LOCKOUT_LOADING_REASON;

				public String getLOCKOUT_LOADING_REASON () {
					return this.LOCKOUT_LOADING_REASON;
				}
				
			    public int BILLING_TYPE;

				public int getBILLING_TYPE () {
					return this.BILLING_TYPE;
				}
				
			    public String PHONE_NUMBER;

				public String getPHONE_NUMBER () {
					return this.PHONE_NUMBER;
				}
				
			    public String PURCHASE_ORDER_NUMBER;

				public String getPURCHASE_ORDER_NUMBER () {
					return this.PURCHASE_ORDER_NUMBER;
				}
				
			    public String REQUISITION_NUMBER;

				public String getREQUISITION_NUMBER () {
					return this.REQUISITION_NUMBER;
				}
				
			    public int PROMPT_PO_NUMBER;

				public int getPROMPT_PO_NUMBER () {
					return this.PROMPT_PO_NUMBER;
				}
				
			    public int PROMPT_R_NUMBER;

				public int getPROMPT_R_NUMBER () {
					return this.PROMPT_R_NUMBER;
				}
				
			    public String BOL_COMMENT_1;

				public String getBOL_COMMENT_1 () {
					return this.BOL_COMMENT_1;
				}
				
			    public int NUMERIC_PO_R_NUMBERS;

				public int getNUMERIC_PO_R_NUMBERS () {
					return this.NUMERIC_PO_R_NUMBERS;
				}
				
			    public String HOST_SUPPLIER_NUMBER;

				public String getHOST_SUPPLIER_NUMBER () {
					return this.HOST_SUPPLIER_NUMBER;
				}
				
			    public String BOL_COMMENT_2;

				public String getBOL_COMMENT_2 () {
					return this.BOL_COMMENT_2;
				}
				
			    public String HOST_CUSTOMER_NUMBER;

				public String getHOST_CUSTOMER_NUMBER () {
					return this.HOST_CUSTOMER_NUMBER;
				}
				
			    public String TABS_CONSIGNEE_NUMBER;

				public String getTABS_CONSIGNEE_NUMBER () {
					return this.TABS_CONSIGNEE_NUMBER;
				}
				
			    public int TABS_SUBSCRIBER;

				public int getTABS_SUBSCRIBER () {
					return this.TABS_SUBSCRIBER;
				}
				
			    public int ENABLED;

				public int getENABLED () {
					return this.ENABLED;
				}
				
			    public int ALLOCATION_ENABLED;

				public int getALLOCATION_ENABLED () {
					return this.ALLOCATION_ENABLED;
				}
				
			    public int TABS_OFFLINE_DIRECTIVE;

				public int getTABS_OFFLINE_DIRECTIVE () {
					return this.TABS_OFFLINE_DIRECTIVE;
				}
				
			    public int CREDIT_ENABLED;

				public int getCREDIT_ENABLED () {
					return this.CREDIT_ENABLED;
				}
				
			    public int DEST_ALLOCATION_ENABLED;

				public int getDEST_ALLOCATION_ENABLED () {
					return this.DEST_ALLOCATION_ENABLED;
				}
				
			    public int INVOICE_REQUIRED;

				public int getINVOICE_REQUIRED () {
					return this.INVOICE_REQUIRED;
				}
				
			    public String ACCESS_CLASS;

				public String getACCESS_CLASS () {
					return this.ACCESS_CLASS;
				}
				
			    public double CREDIT_LIMIT;

				public double getCREDIT_LIMIT () {
					return this.CREDIT_LIMIT;
				}
				
			    public double RT_CREDIT_BALANCE;

				public double getRT_CREDIT_BALANCE () {
					return this.RT_CREDIT_BALANCE;
				}
				
			    public double RT_CREDIT_COMMITTED;

				public double getRT_CREDIT_COMMITTED () {
					return this.RT_CREDIT_COMMITTED;
				}
				
			    public double RT_CREDIT_USED;

				public double getRT_CREDIT_USED () {
					return this.RT_CREDIT_USED;
				}
				
			    public String LAST_USER_NAME;

				public String getLAST_USER_NAME () {
					return this.LAST_USER_NAME;
				}
				
			    public String PETROEX_NUMBER;

				public String getPETROEX_NUMBER () {
					return this.PETROEX_NUMBER;
				}
				
			    public java.util.Date LAST_MODIFIED;

				public java.util.Date getLAST_MODIFIED () {
					return this.LAST_MODIFIED;
				}
				
			    public int PRINT_NET_ON_BOL;

				public int getPRINT_NET_ON_BOL () {
					return this.PRINT_NET_ON_BOL;
				}
				
			    public String PETROEX_CONSIGNEE_NUMBER;

				public String getPETROEX_CONSIGNEE_NUMBER () {
					return this.PETROEX_CONSIGNEE_NUMBER;
				}
				
			    public int PETROEX_SUBSCRIBER;

				public int getPETROEX_SUBSCRIBER () {
					return this.PETROEX_SUBSCRIBER;
				}
				
			    public int ELVIS_OFFLINE_DIRECTIVE;

				public int getELVIS_OFFLINE_DIRECTIVE () {
					return this.ELVIS_OFFLINE_DIRECTIVE;
				}
				
			    public int ORDER_ALLOCATION_REQUIRED;

				public int getORDER_ALLOCATION_REQUIRED () {
					return this.ORDER_ALLOCATION_REQUIRED;
				}
				
			    public int ALLOCATION_REQUIRED_TO_LOAD;

				public int getALLOCATION_REQUIRED_TO_LOAD () {
					return this.ALLOCATION_REQUIRED_TO_LOAD;
				}
				
			    public int TABS_ORDERS;

				public int getTABS_ORDERS () {
					return this.TABS_ORDERS;
				}
				
			    public String TABS_SELLER_ID;

				public String getTABS_SELLER_ID () {
					return this.TABS_SELLER_ID;
				}
				
			    public String TABS_HOST_INTERFACE_CODE;

				public String getTABS_HOST_INTERFACE_CODE () {
					return this.TABS_HOST_INTERFACE_CODE;
				}
				
			    public int DESTINATION_STATION_ENABLE;

				public int getDESTINATION_STATION_ENABLE () {
					return this.DESTINATION_STATION_ENABLE;
				}
				
			    public int STATION_NUMBER;

				public int getSTATION_NUMBER () {
					return this.STATION_NUMBER;
				}
				
			    public String EXCISE_NUMBER;

				public String getEXCISE_NUMBER () {
					return this.EXCISE_NUMBER;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PGS_STAGE_DIM_CUSTOMER.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_CUSTOMER.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_CUSTOMER = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_CUSTOMER = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PGS_STAGE_DIM_CUSTOMER, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_CUSTOMER, 0, length, utf8Charset);
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
			if(length > commonByteArray_PGS_STAGE_DIM_CUSTOMER.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_CUSTOMER.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_CUSTOMER = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_CUSTOMER = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PGS_STAGE_DIM_CUSTOMER, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_CUSTOMER, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_CUSTOMER) {

        	try {

        		int length = 0;
		
			        this.SUPPLIER_NUMBER = dis.readInt();
					
			        this.CUSTOMER_NUMBER = dis.readInt();
					
					this.API_CODE = readString(dis);
					
					this.BILLING_ADDRESS_1 = readString(dis);
					
					this.DET_NAME2 = readString(dis);
					
			        this.DET_CUSTOMER_NUMBER = dis.readInt();
					
					this.BILLING_ADDRESS_2 = readString(dis);
					
					this.BILLING_ADDRESS_3 = readString(dis);
					
					this.BILLING_ADDRESS_4 = readString(dis);
					
			        this.LOCKOUT_LOADING = dis.readInt();
					
					this.LOCKOUT_LOADING_REASON = readString(dis);
					
			        this.BILLING_TYPE = dis.readInt();
					
					this.PHONE_NUMBER = readString(dis);
					
					this.PURCHASE_ORDER_NUMBER = readString(dis);
					
					this.REQUISITION_NUMBER = readString(dis);
					
			        this.PROMPT_PO_NUMBER = dis.readInt();
					
			        this.PROMPT_R_NUMBER = dis.readInt();
					
					this.BOL_COMMENT_1 = readString(dis);
					
			        this.NUMERIC_PO_R_NUMBERS = dis.readInt();
					
					this.HOST_SUPPLIER_NUMBER = readString(dis);
					
					this.BOL_COMMENT_2 = readString(dis);
					
					this.HOST_CUSTOMER_NUMBER = readString(dis);
					
					this.TABS_CONSIGNEE_NUMBER = readString(dis);
					
			        this.TABS_SUBSCRIBER = dis.readInt();
					
			        this.ENABLED = dis.readInt();
					
			        this.ALLOCATION_ENABLED = dis.readInt();
					
			        this.TABS_OFFLINE_DIRECTIVE = dis.readInt();
					
			        this.CREDIT_ENABLED = dis.readInt();
					
			        this.DEST_ALLOCATION_ENABLED = dis.readInt();
					
			        this.INVOICE_REQUIRED = dis.readInt();
					
					this.ACCESS_CLASS = readString(dis);
					
			        this.CREDIT_LIMIT = dis.readDouble();
					
			        this.RT_CREDIT_BALANCE = dis.readDouble();
					
			        this.RT_CREDIT_COMMITTED = dis.readDouble();
					
			        this.RT_CREDIT_USED = dis.readDouble();
					
					this.LAST_USER_NAME = readString(dis);
					
					this.PETROEX_NUMBER = readString(dis);
					
					this.LAST_MODIFIED = readDate(dis);
					
			        this.PRINT_NET_ON_BOL = dis.readInt();
					
					this.PETROEX_CONSIGNEE_NUMBER = readString(dis);
					
			        this.PETROEX_SUBSCRIBER = dis.readInt();
					
			        this.ELVIS_OFFLINE_DIRECTIVE = dis.readInt();
					
			        this.ORDER_ALLOCATION_REQUIRED = dis.readInt();
					
			        this.ALLOCATION_REQUIRED_TO_LOAD = dis.readInt();
					
			        this.TABS_ORDERS = dis.readInt();
					
					this.TABS_SELLER_ID = readString(dis);
					
					this.TABS_HOST_INTERFACE_CODE = readString(dis);
					
			        this.DESTINATION_STATION_ENABLE = dis.readInt();
					
			        this.STATION_NUMBER = dis.readInt();
					
					this.EXCISE_NUMBER = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_CUSTOMER) {

        	try {

        		int length = 0;
		
			        this.SUPPLIER_NUMBER = dis.readInt();
					
			        this.CUSTOMER_NUMBER = dis.readInt();
					
					this.API_CODE = readString(dis);
					
					this.BILLING_ADDRESS_1 = readString(dis);
					
					this.DET_NAME2 = readString(dis);
					
			        this.DET_CUSTOMER_NUMBER = dis.readInt();
					
					this.BILLING_ADDRESS_2 = readString(dis);
					
					this.BILLING_ADDRESS_3 = readString(dis);
					
					this.BILLING_ADDRESS_4 = readString(dis);
					
			        this.LOCKOUT_LOADING = dis.readInt();
					
					this.LOCKOUT_LOADING_REASON = readString(dis);
					
			        this.BILLING_TYPE = dis.readInt();
					
					this.PHONE_NUMBER = readString(dis);
					
					this.PURCHASE_ORDER_NUMBER = readString(dis);
					
					this.REQUISITION_NUMBER = readString(dis);
					
			        this.PROMPT_PO_NUMBER = dis.readInt();
					
			        this.PROMPT_R_NUMBER = dis.readInt();
					
					this.BOL_COMMENT_1 = readString(dis);
					
			        this.NUMERIC_PO_R_NUMBERS = dis.readInt();
					
					this.HOST_SUPPLIER_NUMBER = readString(dis);
					
					this.BOL_COMMENT_2 = readString(dis);
					
					this.HOST_CUSTOMER_NUMBER = readString(dis);
					
					this.TABS_CONSIGNEE_NUMBER = readString(dis);
					
			        this.TABS_SUBSCRIBER = dis.readInt();
					
			        this.ENABLED = dis.readInt();
					
			        this.ALLOCATION_ENABLED = dis.readInt();
					
			        this.TABS_OFFLINE_DIRECTIVE = dis.readInt();
					
			        this.CREDIT_ENABLED = dis.readInt();
					
			        this.DEST_ALLOCATION_ENABLED = dis.readInt();
					
			        this.INVOICE_REQUIRED = dis.readInt();
					
					this.ACCESS_CLASS = readString(dis);
					
			        this.CREDIT_LIMIT = dis.readDouble();
					
			        this.RT_CREDIT_BALANCE = dis.readDouble();
					
			        this.RT_CREDIT_COMMITTED = dis.readDouble();
					
			        this.RT_CREDIT_USED = dis.readDouble();
					
					this.LAST_USER_NAME = readString(dis);
					
					this.PETROEX_NUMBER = readString(dis);
					
					this.LAST_MODIFIED = readDate(dis);
					
			        this.PRINT_NET_ON_BOL = dis.readInt();
					
					this.PETROEX_CONSIGNEE_NUMBER = readString(dis);
					
			        this.PETROEX_SUBSCRIBER = dis.readInt();
					
			        this.ELVIS_OFFLINE_DIRECTIVE = dis.readInt();
					
			        this.ORDER_ALLOCATION_REQUIRED = dis.readInt();
					
			        this.ALLOCATION_REQUIRED_TO_LOAD = dis.readInt();
					
			        this.TABS_ORDERS = dis.readInt();
					
					this.TABS_SELLER_ID = readString(dis);
					
					this.TABS_HOST_INTERFACE_CODE = readString(dis);
					
			        this.DESTINATION_STATION_ENABLE = dis.readInt();
					
			        this.STATION_NUMBER = dis.readInt();
					
					this.EXCISE_NUMBER = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.SUPPLIER_NUMBER);
					
					// int
				
		            	dos.writeInt(this.CUSTOMER_NUMBER);
					
					// String
				
						writeString(this.API_CODE,dos);
					
					// String
				
						writeString(this.BILLING_ADDRESS_1,dos);
					
					// String
				
						writeString(this.DET_NAME2,dos);
					
					// int
				
		            	dos.writeInt(this.DET_CUSTOMER_NUMBER);
					
					// String
				
						writeString(this.BILLING_ADDRESS_2,dos);
					
					// String
				
						writeString(this.BILLING_ADDRESS_3,dos);
					
					// String
				
						writeString(this.BILLING_ADDRESS_4,dos);
					
					// int
				
		            	dos.writeInt(this.LOCKOUT_LOADING);
					
					// String
				
						writeString(this.LOCKOUT_LOADING_REASON,dos);
					
					// int
				
		            	dos.writeInt(this.BILLING_TYPE);
					
					// String
				
						writeString(this.PHONE_NUMBER,dos);
					
					// String
				
						writeString(this.PURCHASE_ORDER_NUMBER,dos);
					
					// String
				
						writeString(this.REQUISITION_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.PROMPT_PO_NUMBER);
					
					// int
				
		            	dos.writeInt(this.PROMPT_R_NUMBER);
					
					// String
				
						writeString(this.BOL_COMMENT_1,dos);
					
					// int
				
		            	dos.writeInt(this.NUMERIC_PO_R_NUMBERS);
					
					// String
				
						writeString(this.HOST_SUPPLIER_NUMBER,dos);
					
					// String
				
						writeString(this.BOL_COMMENT_2,dos);
					
					// String
				
						writeString(this.HOST_CUSTOMER_NUMBER,dos);
					
					// String
				
						writeString(this.TABS_CONSIGNEE_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.TABS_SUBSCRIBER);
					
					// int
				
		            	dos.writeInt(this.ENABLED);
					
					// int
				
		            	dos.writeInt(this.ALLOCATION_ENABLED);
					
					// int
				
		            	dos.writeInt(this.TABS_OFFLINE_DIRECTIVE);
					
					// int
				
		            	dos.writeInt(this.CREDIT_ENABLED);
					
					// int
				
		            	dos.writeInt(this.DEST_ALLOCATION_ENABLED);
					
					// int
				
		            	dos.writeInt(this.INVOICE_REQUIRED);
					
					// String
				
						writeString(this.ACCESS_CLASS,dos);
					
					// double
				
		            	dos.writeDouble(this.CREDIT_LIMIT);
					
					// double
				
		            	dos.writeDouble(this.RT_CREDIT_BALANCE);
					
					// double
				
		            	dos.writeDouble(this.RT_CREDIT_COMMITTED);
					
					// double
				
		            	dos.writeDouble(this.RT_CREDIT_USED);
					
					// String
				
						writeString(this.LAST_USER_NAME,dos);
					
					// String
				
						writeString(this.PETROEX_NUMBER,dos);
					
					// java.util.Date
				
						writeDate(this.LAST_MODIFIED,dos);
					
					// int
				
		            	dos.writeInt(this.PRINT_NET_ON_BOL);
					
					// String
				
						writeString(this.PETROEX_CONSIGNEE_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.PETROEX_SUBSCRIBER);
					
					// int
				
		            	dos.writeInt(this.ELVIS_OFFLINE_DIRECTIVE);
					
					// int
				
		            	dos.writeInt(this.ORDER_ALLOCATION_REQUIRED);
					
					// int
				
		            	dos.writeInt(this.ALLOCATION_REQUIRED_TO_LOAD);
					
					// int
				
		            	dos.writeInt(this.TABS_ORDERS);
					
					// String
				
						writeString(this.TABS_SELLER_ID,dos);
					
					// String
				
						writeString(this.TABS_HOST_INTERFACE_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.DESTINATION_STATION_ENABLE);
					
					// int
				
		            	dos.writeInt(this.STATION_NUMBER);
					
					// String
				
						writeString(this.EXCISE_NUMBER,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.SUPPLIER_NUMBER);
					
					// int
				
		            	dos.writeInt(this.CUSTOMER_NUMBER);
					
					// String
				
						writeString(this.API_CODE,dos);
					
					// String
				
						writeString(this.BILLING_ADDRESS_1,dos);
					
					// String
				
						writeString(this.DET_NAME2,dos);
					
					// int
				
		            	dos.writeInt(this.DET_CUSTOMER_NUMBER);
					
					// String
				
						writeString(this.BILLING_ADDRESS_2,dos);
					
					// String
				
						writeString(this.BILLING_ADDRESS_3,dos);
					
					// String
				
						writeString(this.BILLING_ADDRESS_4,dos);
					
					// int
				
		            	dos.writeInt(this.LOCKOUT_LOADING);
					
					// String
				
						writeString(this.LOCKOUT_LOADING_REASON,dos);
					
					// int
				
		            	dos.writeInt(this.BILLING_TYPE);
					
					// String
				
						writeString(this.PHONE_NUMBER,dos);
					
					// String
				
						writeString(this.PURCHASE_ORDER_NUMBER,dos);
					
					// String
				
						writeString(this.REQUISITION_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.PROMPT_PO_NUMBER);
					
					// int
				
		            	dos.writeInt(this.PROMPT_R_NUMBER);
					
					// String
				
						writeString(this.BOL_COMMENT_1,dos);
					
					// int
				
		            	dos.writeInt(this.NUMERIC_PO_R_NUMBERS);
					
					// String
				
						writeString(this.HOST_SUPPLIER_NUMBER,dos);
					
					// String
				
						writeString(this.BOL_COMMENT_2,dos);
					
					// String
				
						writeString(this.HOST_CUSTOMER_NUMBER,dos);
					
					// String
				
						writeString(this.TABS_CONSIGNEE_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.TABS_SUBSCRIBER);
					
					// int
				
		            	dos.writeInt(this.ENABLED);
					
					// int
				
		            	dos.writeInt(this.ALLOCATION_ENABLED);
					
					// int
				
		            	dos.writeInt(this.TABS_OFFLINE_DIRECTIVE);
					
					// int
				
		            	dos.writeInt(this.CREDIT_ENABLED);
					
					// int
				
		            	dos.writeInt(this.DEST_ALLOCATION_ENABLED);
					
					// int
				
		            	dos.writeInt(this.INVOICE_REQUIRED);
					
					// String
				
						writeString(this.ACCESS_CLASS,dos);
					
					// double
				
		            	dos.writeDouble(this.CREDIT_LIMIT);
					
					// double
				
		            	dos.writeDouble(this.RT_CREDIT_BALANCE);
					
					// double
				
		            	dos.writeDouble(this.RT_CREDIT_COMMITTED);
					
					// double
				
		            	dos.writeDouble(this.RT_CREDIT_USED);
					
					// String
				
						writeString(this.LAST_USER_NAME,dos);
					
					// String
				
						writeString(this.PETROEX_NUMBER,dos);
					
					// java.util.Date
				
						writeDate(this.LAST_MODIFIED,dos);
					
					// int
				
		            	dos.writeInt(this.PRINT_NET_ON_BOL);
					
					// String
				
						writeString(this.PETROEX_CONSIGNEE_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.PETROEX_SUBSCRIBER);
					
					// int
				
		            	dos.writeInt(this.ELVIS_OFFLINE_DIRECTIVE);
					
					// int
				
		            	dos.writeInt(this.ORDER_ALLOCATION_REQUIRED);
					
					// int
				
		            	dos.writeInt(this.ALLOCATION_REQUIRED_TO_LOAD);
					
					// int
				
		            	dos.writeInt(this.TABS_ORDERS);
					
					// String
				
						writeString(this.TABS_SELLER_ID,dos);
					
					// String
				
						writeString(this.TABS_HOST_INTERFACE_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.DESTINATION_STATION_ENABLE);
					
					// int
				
		            	dos.writeInt(this.STATION_NUMBER);
					
					// String
				
						writeString(this.EXCISE_NUMBER,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("SUPPLIER_NUMBER="+String.valueOf(SUPPLIER_NUMBER));
		sb.append(",CUSTOMER_NUMBER="+String.valueOf(CUSTOMER_NUMBER));
		sb.append(",API_CODE="+API_CODE);
		sb.append(",BILLING_ADDRESS_1="+BILLING_ADDRESS_1);
		sb.append(",DET_NAME2="+DET_NAME2);
		sb.append(",DET_CUSTOMER_NUMBER="+String.valueOf(DET_CUSTOMER_NUMBER));
		sb.append(",BILLING_ADDRESS_2="+BILLING_ADDRESS_2);
		sb.append(",BILLING_ADDRESS_3="+BILLING_ADDRESS_3);
		sb.append(",BILLING_ADDRESS_4="+BILLING_ADDRESS_4);
		sb.append(",LOCKOUT_LOADING="+String.valueOf(LOCKOUT_LOADING));
		sb.append(",LOCKOUT_LOADING_REASON="+LOCKOUT_LOADING_REASON);
		sb.append(",BILLING_TYPE="+String.valueOf(BILLING_TYPE));
		sb.append(",PHONE_NUMBER="+PHONE_NUMBER);
		sb.append(",PURCHASE_ORDER_NUMBER="+PURCHASE_ORDER_NUMBER);
		sb.append(",REQUISITION_NUMBER="+REQUISITION_NUMBER);
		sb.append(",PROMPT_PO_NUMBER="+String.valueOf(PROMPT_PO_NUMBER));
		sb.append(",PROMPT_R_NUMBER="+String.valueOf(PROMPT_R_NUMBER));
		sb.append(",BOL_COMMENT_1="+BOL_COMMENT_1);
		sb.append(",NUMERIC_PO_R_NUMBERS="+String.valueOf(NUMERIC_PO_R_NUMBERS));
		sb.append(",HOST_SUPPLIER_NUMBER="+HOST_SUPPLIER_NUMBER);
		sb.append(",BOL_COMMENT_2="+BOL_COMMENT_2);
		sb.append(",HOST_CUSTOMER_NUMBER="+HOST_CUSTOMER_NUMBER);
		sb.append(",TABS_CONSIGNEE_NUMBER="+TABS_CONSIGNEE_NUMBER);
		sb.append(",TABS_SUBSCRIBER="+String.valueOf(TABS_SUBSCRIBER));
		sb.append(",ENABLED="+String.valueOf(ENABLED));
		sb.append(",ALLOCATION_ENABLED="+String.valueOf(ALLOCATION_ENABLED));
		sb.append(",TABS_OFFLINE_DIRECTIVE="+String.valueOf(TABS_OFFLINE_DIRECTIVE));
		sb.append(",CREDIT_ENABLED="+String.valueOf(CREDIT_ENABLED));
		sb.append(",DEST_ALLOCATION_ENABLED="+String.valueOf(DEST_ALLOCATION_ENABLED));
		sb.append(",INVOICE_REQUIRED="+String.valueOf(INVOICE_REQUIRED));
		sb.append(",ACCESS_CLASS="+ACCESS_CLASS);
		sb.append(",CREDIT_LIMIT="+String.valueOf(CREDIT_LIMIT));
		sb.append(",RT_CREDIT_BALANCE="+String.valueOf(RT_CREDIT_BALANCE));
		sb.append(",RT_CREDIT_COMMITTED="+String.valueOf(RT_CREDIT_COMMITTED));
		sb.append(",RT_CREDIT_USED="+String.valueOf(RT_CREDIT_USED));
		sb.append(",LAST_USER_NAME="+LAST_USER_NAME);
		sb.append(",PETROEX_NUMBER="+PETROEX_NUMBER);
		sb.append(",LAST_MODIFIED="+String.valueOf(LAST_MODIFIED));
		sb.append(",PRINT_NET_ON_BOL="+String.valueOf(PRINT_NET_ON_BOL));
		sb.append(",PETROEX_CONSIGNEE_NUMBER="+PETROEX_CONSIGNEE_NUMBER);
		sb.append(",PETROEX_SUBSCRIBER="+String.valueOf(PETROEX_SUBSCRIBER));
		sb.append(",ELVIS_OFFLINE_DIRECTIVE="+String.valueOf(ELVIS_OFFLINE_DIRECTIVE));
		sb.append(",ORDER_ALLOCATION_REQUIRED="+String.valueOf(ORDER_ALLOCATION_REQUIRED));
		sb.append(",ALLOCATION_REQUIRED_TO_LOAD="+String.valueOf(ALLOCATION_REQUIRED_TO_LOAD));
		sb.append(",TABS_ORDERS="+String.valueOf(TABS_ORDERS));
		sb.append(",TABS_SELLER_ID="+TABS_SELLER_ID);
		sb.append(",TABS_HOST_INTERFACE_CODE="+TABS_HOST_INTERFACE_CODE);
		sb.append(",DESTINATION_STATION_ENABLE="+String.valueOf(DESTINATION_STATION_ENABLE));
		sb.append(",STATION_NUMBER="+String.valueOf(STATION_NUMBER));
		sb.append(",EXCISE_NUMBER="+EXCISE_NUMBER);
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
        } else if (updateKeyCount_tDBOutput_1 == 7 && true) {
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

 
	final String decryptedPassword_tDBOutput_1 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:SMSqjiotP41Ycpy/dAyA0wsu6GuDPq5WHyT6AEfs9VVHz5Ta1f4=");

    String dbPwd_tDBOutput_1 = decryptedPassword_tDBOutput_1;	
    conn_tDBOutput_1 = java.sql.DriverManager.getConnection(url_tDBOutput_1,dbUser_tDBOutput_1,dbPwd_tDBOutput_1);
	
		resourceMap.put("conn_tDBOutput_1", conn_tDBOutput_1);
	
        conn_tDBOutput_1.setAutoCommit(false);
        int commitEvery_tDBOutput_1 = 10000;
        int commitCounter_tDBOutput_1 = 0;


if(dbschema_tDBOutput_1 == null || dbschema_tDBOutput_1.trim().length() == 0) {
    tableName_tDBOutput_1 = "DIM_CUSTOMER";
} else {
    tableName_tDBOutput_1 = dbschema_tDBOutput_1 + "].[" + "DIM_CUSTOMER";
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
                                        stmtCreate_tDBOutput_1.execute("CREATE TABLE [" + tableName_tDBOutput_1 + "]([PK_CUSTOMER] INT  not null ,[SUPPLIER_NUMBER] INT  not null ,[CUSTOMER_NUMBER] INT  not null ,[BILLING_ADDRESS_1] VARCHAR(40)  ,[DET_CUSTOMER_NUMBER] INT  not null ,[LAST_USER_NAME] VARCHAR(10)  ,[LAST_MODIFIED] DATETIME ,primary key([PK_CUSTOMER]))");
                                    }
                                }
        java.sql.PreparedStatement pstmt_tDBOutput_1 = conn_tDBOutput_1.prepareStatement("SELECT COUNT(1) FROM [" + tableName_tDBOutput_1 + "] WHERE [PK_CUSTOMER] = ?");
        resourceMap.put("pstmt_tDBOutput_1", pstmt_tDBOutput_1);
        String insert_tDBOutput_1 = "INSERT INTO [" + tableName_tDBOutput_1 + "] ([PK_CUSTOMER],[SUPPLIER_NUMBER],[CUSTOMER_NUMBER],[BILLING_ADDRESS_1],[DET_CUSTOMER_NUMBER],[LAST_USER_NAME],[LAST_MODIFIED]) VALUES (?,?,?,?,?,?,?)";
        java.sql.PreparedStatement pstmtInsert_tDBOutput_1 = conn_tDBOutput_1.prepareStatement(insert_tDBOutput_1);
        resourceMap.put("pstmtInsert_tDBOutput_1", pstmtInsert_tDBOutput_1);
        String update_tDBOutput_1 = "UPDATE [" + tableName_tDBOutput_1 + "] SET [SUPPLIER_NUMBER] = ?,[CUSTOMER_NUMBER] = ?,[BILLING_ADDRESS_1] = ?,[DET_CUSTOMER_NUMBER] = ?,[LAST_USER_NAME] = ?,[LAST_MODIFIED] = ? WHERE [PK_CUSTOMER] = ?";
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
	int PK_CUSTOMER;
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
	
	        
					int SUPPLIER_NUMBER;
					int CUSTOMER_NUMBER;        
	        
		    @Override
			public int hashCode() {
				if (this.hashCodeDirty) {
					final int prime = PRIME;
					int result = DEFAULT_HASHCODE;
			
									result = prime * result + (int) this.SUPPLIER_NUMBER;
									
									result = prime * result + (int) this.CUSTOMER_NUMBER;
									
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
				
									if (this.SUPPLIER_NUMBER != other.SUPPLIER_NUMBER) 
										return false;
								
									if (this.CUSTOMER_NUMBER != other.CUSTOMER_NUMBER) 
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
				
				 
	final String decryptedPassword_tDBInput_1 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:GLR6PcdXmUkhNnYfjllE42j+kyGVI5gKQb5QYCZ3LzAnoE/v0/E=");
				
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

		    String dbquery_tDBInput_1 = "SELECT dbo.CUSTOMER.SUPPLIER_NUMBER,\n		dbo.CUSTOMER.CUSTOMER_NUMBER,\n		dbo.CUSTOMER.API_CODE,\n		dbo.CUSTOMER.BILLING_AD"
+"DRESS_1,\n		dbo.CUSTOMER.DET_NAME2,\n		dbo.CUSTOMER.DET_CUSTOMER_NUMBER,\n		dbo.CUSTOMER.BILLING_ADDRESS_2,\n		dbo.CUSTOMER."
+"BILLING_ADDRESS_3,\n		dbo.CUSTOMER.BILLING_ADDRESS_4,\n		dbo.CUSTOMER.LOCKOUT_LOADING,\n		dbo.CUSTOMER.LOCKOUT_LOADING_REAS"
+"ON,\n		dbo.CUSTOMER.BILLING_TYPE,\n		dbo.CUSTOMER.PHONE_NUMBER,\n		dbo.CUSTOMER.PURCHASE_ORDER_NUMBER,\n		dbo.CUSTOMER.REQUI"
+"SITION_NUMBER,\n		dbo.CUSTOMER.PROMPT_PO_NUMBER,\n		dbo.CUSTOMER.PROMPT_R_NUMBER,\n		dbo.CUSTOMER.BOL_COMMENT_1,\n		dbo.CUST"
+"OMER.NUMERIC_PO_R_NUMBERS,\n		dbo.CUSTOMER.HOST_SUPPLIER_NUMBER,\n		dbo.CUSTOMER.BOL_COMMENT_2,\n		dbo.CUSTOMER.HOST_CUSTOM"
+"ER_NUMBER,\n		dbo.CUSTOMER.TABS_CONSIGNEE_NUMBER,\n		dbo.CUSTOMER.TABS_SUBSCRIBER,\n		dbo.CUSTOMER.ENABLED,\n		dbo.CUSTOMER."
+"ALLOCATION_ENABLED,\n		dbo.CUSTOMER.TABS_OFFLINE_DIRECTIVE,\n		dbo.CUSTOMER.CREDIT_ENABLED,\n		dbo.CUSTOMER.DEST_ALLOCATION"
+"_ENABLED,\n		dbo.CUSTOMER.INVOICE_REQUIRED,\n		dbo.CUSTOMER.ACCESS_CLASS,\n		dbo.CUSTOMER.CREDIT_LIMIT,\n		dbo.CUSTOMER.RT_C"
+"REDIT_BALANCE,\n		dbo.CUSTOMER.RT_CREDIT_COMMITTED,\n		dbo.CUSTOMER.RT_CREDIT_USED,\n		dbo.CUSTOMER.LAST_USER_NAME,\n		dbo.C"
+"USTOMER.PETROEX_NUMBER,\n		dbo.CUSTOMER.LAST_MODIFIED,\n		dbo.CUSTOMER.PRINT_NET_ON_BOL,\n		dbo.CUSTOMER.PETROEX_CONSIGNEE_"
+"NUMBER,\n		dbo.CUSTOMER.PETROEX_SUBSCRIBER,\n		dbo.CUSTOMER.ELVIS_OFFLINE_DIRECTIVE,\n		dbo.CUSTOMER.ORDER_ALLOCATION_REQUI"
+"RED,\n		dbo.CUSTOMER.ALLOCATION_REQUIRED_TO_LOAD,\n		dbo.CUSTOMER.TABS_ORDERS,\n		dbo.CUSTOMER.TABS_SELLER_ID,\n		dbo.CUSTOM"
+"ER.TABS_HOST_INTERFACE_CODE,\n		dbo.CUSTOMER.DESTINATION_STATION_ENABLE,\n		dbo.CUSTOMER.STATION_NUMBER,\n		dbo.CUSTOMER.EX"
+"CISE_NUMBER\nFROM	dbo.CUSTOMER";
		    

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
								row1.SUPPLIER_NUMBER = 0;
							} else {
		                          
            row1.SUPPLIER_NUMBER = rs_tDBInput_1.getInt(1);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 2) {
								row1.CUSTOMER_NUMBER = 0;
							} else {
		                          
            row1.CUSTOMER_NUMBER = rs_tDBInput_1.getInt(2);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 3) {
								row1.API_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(3);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(3).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.API_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.API_CODE = tmpContent_tDBInput_1;
                }
            } else {
                row1.API_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 4) {
								row1.BILLING_ADDRESS_1 = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(4);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(4).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.BILLING_ADDRESS_1 = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.BILLING_ADDRESS_1 = tmpContent_tDBInput_1;
                }
            } else {
                row1.BILLING_ADDRESS_1 = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 5) {
								row1.DET_NAME2 = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(5);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(5).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.DET_NAME2 = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.DET_NAME2 = tmpContent_tDBInput_1;
                }
            } else {
                row1.DET_NAME2 = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 6) {
								row1.DET_CUSTOMER_NUMBER = 0;
							} else {
		                          
            row1.DET_CUSTOMER_NUMBER = rs_tDBInput_1.getInt(6);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 7) {
								row1.BILLING_ADDRESS_2 = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(7);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(7).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.BILLING_ADDRESS_2 = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.BILLING_ADDRESS_2 = tmpContent_tDBInput_1;
                }
            } else {
                row1.BILLING_ADDRESS_2 = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 8) {
								row1.BILLING_ADDRESS_3 = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(8);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(8).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.BILLING_ADDRESS_3 = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.BILLING_ADDRESS_3 = tmpContent_tDBInput_1;
                }
            } else {
                row1.BILLING_ADDRESS_3 = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 9) {
								row1.BILLING_ADDRESS_4 = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(9);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(9).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.BILLING_ADDRESS_4 = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.BILLING_ADDRESS_4 = tmpContent_tDBInput_1;
                }
            } else {
                row1.BILLING_ADDRESS_4 = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 10) {
								row1.LOCKOUT_LOADING = 0;
							} else {
		                          
            row1.LOCKOUT_LOADING = rs_tDBInput_1.getInt(10);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 11) {
								row1.LOCKOUT_LOADING_REASON = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(11);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(11).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.LOCKOUT_LOADING_REASON = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.LOCKOUT_LOADING_REASON = tmpContent_tDBInput_1;
                }
            } else {
                row1.LOCKOUT_LOADING_REASON = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 12) {
								row1.BILLING_TYPE = 0;
							} else {
		                          
            row1.BILLING_TYPE = rs_tDBInput_1.getInt(12);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 13) {
								row1.PHONE_NUMBER = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(13);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(13).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.PHONE_NUMBER = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.PHONE_NUMBER = tmpContent_tDBInput_1;
                }
            } else {
                row1.PHONE_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 14) {
								row1.PURCHASE_ORDER_NUMBER = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(14);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(14).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.PURCHASE_ORDER_NUMBER = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.PURCHASE_ORDER_NUMBER = tmpContent_tDBInput_1;
                }
            } else {
                row1.PURCHASE_ORDER_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 15) {
								row1.REQUISITION_NUMBER = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(15);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(15).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.REQUISITION_NUMBER = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.REQUISITION_NUMBER = tmpContent_tDBInput_1;
                }
            } else {
                row1.REQUISITION_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 16) {
								row1.PROMPT_PO_NUMBER = 0;
							} else {
		                          
            row1.PROMPT_PO_NUMBER = rs_tDBInput_1.getInt(16);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 17) {
								row1.PROMPT_R_NUMBER = 0;
							} else {
		                          
            row1.PROMPT_R_NUMBER = rs_tDBInput_1.getInt(17);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 18) {
								row1.BOL_COMMENT_1 = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(18);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(18).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.BOL_COMMENT_1 = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.BOL_COMMENT_1 = tmpContent_tDBInput_1;
                }
            } else {
                row1.BOL_COMMENT_1 = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 19) {
								row1.NUMERIC_PO_R_NUMBERS = 0;
							} else {
		                          
            row1.NUMERIC_PO_R_NUMBERS = rs_tDBInput_1.getInt(19);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 20) {
								row1.HOST_SUPPLIER_NUMBER = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(20);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(20).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.HOST_SUPPLIER_NUMBER = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.HOST_SUPPLIER_NUMBER = tmpContent_tDBInput_1;
                }
            } else {
                row1.HOST_SUPPLIER_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 21) {
								row1.BOL_COMMENT_2 = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(21);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(21).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.BOL_COMMENT_2 = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.BOL_COMMENT_2 = tmpContent_tDBInput_1;
                }
            } else {
                row1.BOL_COMMENT_2 = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 22) {
								row1.HOST_CUSTOMER_NUMBER = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(22);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(22).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.HOST_CUSTOMER_NUMBER = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.HOST_CUSTOMER_NUMBER = tmpContent_tDBInput_1;
                }
            } else {
                row1.HOST_CUSTOMER_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 23) {
								row1.TABS_CONSIGNEE_NUMBER = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(23);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(23).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.TABS_CONSIGNEE_NUMBER = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.TABS_CONSIGNEE_NUMBER = tmpContent_tDBInput_1;
                }
            } else {
                row1.TABS_CONSIGNEE_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 24) {
								row1.TABS_SUBSCRIBER = 0;
							} else {
		                          
            row1.TABS_SUBSCRIBER = rs_tDBInput_1.getInt(24);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 25) {
								row1.ENABLED = 0;
							} else {
		                          
            row1.ENABLED = rs_tDBInput_1.getInt(25);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 26) {
								row1.ALLOCATION_ENABLED = 0;
							} else {
		                          
            row1.ALLOCATION_ENABLED = rs_tDBInput_1.getInt(26);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 27) {
								row1.TABS_OFFLINE_DIRECTIVE = 0;
							} else {
		                          
            row1.TABS_OFFLINE_DIRECTIVE = rs_tDBInput_1.getInt(27);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 28) {
								row1.CREDIT_ENABLED = 0;
							} else {
		                          
            row1.CREDIT_ENABLED = rs_tDBInput_1.getInt(28);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 29) {
								row1.DEST_ALLOCATION_ENABLED = 0;
							} else {
		                          
            row1.DEST_ALLOCATION_ENABLED = rs_tDBInput_1.getInt(29);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 30) {
								row1.INVOICE_REQUIRED = 0;
							} else {
		                          
            row1.INVOICE_REQUIRED = rs_tDBInput_1.getInt(30);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 31) {
								row1.ACCESS_CLASS = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(31);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(31).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.ACCESS_CLASS = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.ACCESS_CLASS = tmpContent_tDBInput_1;
                }
            } else {
                row1.ACCESS_CLASS = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 32) {
								row1.CREDIT_LIMIT = 0;
							} else {
	                         		
            row1.CREDIT_LIMIT = rs_tDBInput_1.getDouble(32);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 33) {
								row1.RT_CREDIT_BALANCE = 0;
							} else {
	                         		
            row1.RT_CREDIT_BALANCE = rs_tDBInput_1.getDouble(33);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 34) {
								row1.RT_CREDIT_COMMITTED = 0;
							} else {
	                         		
            row1.RT_CREDIT_COMMITTED = rs_tDBInput_1.getDouble(34);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 35) {
								row1.RT_CREDIT_USED = 0;
							} else {
	                         		
            row1.RT_CREDIT_USED = rs_tDBInput_1.getDouble(35);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 36) {
								row1.LAST_USER_NAME = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(36);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(36).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.LAST_USER_NAME = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.LAST_USER_NAME = tmpContent_tDBInput_1;
                }
            } else {
                row1.LAST_USER_NAME = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 37) {
								row1.PETROEX_NUMBER = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(37);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(37).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.PETROEX_NUMBER = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.PETROEX_NUMBER = tmpContent_tDBInput_1;
                }
            } else {
                row1.PETROEX_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 38) {
								row1.LAST_MODIFIED = null;
							} else {
										
			row1.LAST_MODIFIED = mssqlGTU_tDBInput_1.getDate(rsmd_tDBInput_1, rs_tDBInput_1, 38);
			
		                    }
							if(colQtyInRs_tDBInput_1 < 39) {
								row1.PRINT_NET_ON_BOL = 0;
							} else {
		                          
            row1.PRINT_NET_ON_BOL = rs_tDBInput_1.getInt(39);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 40) {
								row1.PETROEX_CONSIGNEE_NUMBER = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(40);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(40).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.PETROEX_CONSIGNEE_NUMBER = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.PETROEX_CONSIGNEE_NUMBER = tmpContent_tDBInput_1;
                }
            } else {
                row1.PETROEX_CONSIGNEE_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 41) {
								row1.PETROEX_SUBSCRIBER = 0;
							} else {
		                          
            row1.PETROEX_SUBSCRIBER = rs_tDBInput_1.getInt(41);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 42) {
								row1.ELVIS_OFFLINE_DIRECTIVE = 0;
							} else {
		                          
            row1.ELVIS_OFFLINE_DIRECTIVE = rs_tDBInput_1.getInt(42);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 43) {
								row1.ORDER_ALLOCATION_REQUIRED = 0;
							} else {
		                          
            row1.ORDER_ALLOCATION_REQUIRED = rs_tDBInput_1.getInt(43);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 44) {
								row1.ALLOCATION_REQUIRED_TO_LOAD = 0;
							} else {
		                          
            row1.ALLOCATION_REQUIRED_TO_LOAD = rs_tDBInput_1.getInt(44);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 45) {
								row1.TABS_ORDERS = 0;
							} else {
		                          
            row1.TABS_ORDERS = rs_tDBInput_1.getInt(45);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 46) {
								row1.TABS_SELLER_ID = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(46);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(46).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.TABS_SELLER_ID = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.TABS_SELLER_ID = tmpContent_tDBInput_1;
                }
            } else {
                row1.TABS_SELLER_ID = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 47) {
								row1.TABS_HOST_INTERFACE_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(47);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(47).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.TABS_HOST_INTERFACE_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.TABS_HOST_INTERFACE_CODE = tmpContent_tDBInput_1;
                }
            } else {
                row1.TABS_HOST_INTERFACE_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 48) {
								row1.DESTINATION_STATION_ENABLE = 0;
							} else {
		                          
            row1.DESTINATION_STATION_ENABLE = rs_tDBInput_1.getInt(48);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 49) {
								row1.STATION_NUMBER = 0;
							} else {
		                          
            row1.STATION_NUMBER = rs_tDBInput_1.getInt(49);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 50) {
								row1.EXCISE_NUMBER = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(50);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(50).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.EXCISE_NUMBER = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.EXCISE_NUMBER = tmpContent_tDBInput_1;
                }
            } else {
                row1.EXCISE_NUMBER = null;
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
finder_tUniqRow_1.SUPPLIER_NUMBER = row1.SUPPLIER_NUMBER;
finder_tUniqRow_1.CUSTOMER_NUMBER = row1.CUSTOMER_NUMBER;	
finder_tUniqRow_1.hashCodeDirty = true;
if (!keystUniqRow_1.contains(finder_tUniqRow_1)) {
		KeyStruct_tUniqRow_1 new_tUniqRow_1 = new KeyStruct_tUniqRow_1();

		
new_tUniqRow_1.SUPPLIER_NUMBER = row1.SUPPLIER_NUMBER;
new_tUniqRow_1.CUSTOMER_NUMBER = row1.CUSTOMER_NUMBER;
		
		keystUniqRow_1.add(new_tUniqRow_1);if(row2 == null){ 
	
	row2 = new row2Struct();
}row2.SUPPLIER_NUMBER = row1.SUPPLIER_NUMBER;			row2.CUSTOMER_NUMBER = row1.CUSTOMER_NUMBER;			row2.API_CODE = row1.API_CODE;			row2.BILLING_ADDRESS_1 = row1.BILLING_ADDRESS_1;			row2.DET_NAME2 = row1.DET_NAME2;			row2.DET_CUSTOMER_NUMBER = row1.DET_CUSTOMER_NUMBER;			row2.BILLING_ADDRESS_2 = row1.BILLING_ADDRESS_2;			row2.BILLING_ADDRESS_3 = row1.BILLING_ADDRESS_3;			row2.BILLING_ADDRESS_4 = row1.BILLING_ADDRESS_4;			row2.LOCKOUT_LOADING = row1.LOCKOUT_LOADING;			row2.LOCKOUT_LOADING_REASON = row1.LOCKOUT_LOADING_REASON;			row2.BILLING_TYPE = row1.BILLING_TYPE;			row2.PHONE_NUMBER = row1.PHONE_NUMBER;			row2.PURCHASE_ORDER_NUMBER = row1.PURCHASE_ORDER_NUMBER;			row2.REQUISITION_NUMBER = row1.REQUISITION_NUMBER;			row2.PROMPT_PO_NUMBER = row1.PROMPT_PO_NUMBER;			row2.PROMPT_R_NUMBER = row1.PROMPT_R_NUMBER;			row2.BOL_COMMENT_1 = row1.BOL_COMMENT_1;			row2.NUMERIC_PO_R_NUMBERS = row1.NUMERIC_PO_R_NUMBERS;			row2.HOST_SUPPLIER_NUMBER = row1.HOST_SUPPLIER_NUMBER;			row2.BOL_COMMENT_2 = row1.BOL_COMMENT_2;			row2.HOST_CUSTOMER_NUMBER = row1.HOST_CUSTOMER_NUMBER;			row2.TABS_CONSIGNEE_NUMBER = row1.TABS_CONSIGNEE_NUMBER;			row2.TABS_SUBSCRIBER = row1.TABS_SUBSCRIBER;			row2.ENABLED = row1.ENABLED;			row2.ALLOCATION_ENABLED = row1.ALLOCATION_ENABLED;			row2.TABS_OFFLINE_DIRECTIVE = row1.TABS_OFFLINE_DIRECTIVE;			row2.CREDIT_ENABLED = row1.CREDIT_ENABLED;			row2.DEST_ALLOCATION_ENABLED = row1.DEST_ALLOCATION_ENABLED;			row2.INVOICE_REQUIRED = row1.INVOICE_REQUIRED;			row2.ACCESS_CLASS = row1.ACCESS_CLASS;			row2.CREDIT_LIMIT = row1.CREDIT_LIMIT;			row2.RT_CREDIT_BALANCE = row1.RT_CREDIT_BALANCE;			row2.RT_CREDIT_COMMITTED = row1.RT_CREDIT_COMMITTED;			row2.RT_CREDIT_USED = row1.RT_CREDIT_USED;			row2.LAST_USER_NAME = row1.LAST_USER_NAME;			row2.PETROEX_NUMBER = row1.PETROEX_NUMBER;			row2.LAST_MODIFIED = row1.LAST_MODIFIED;			row2.PRINT_NET_ON_BOL = row1.PRINT_NET_ON_BOL;			row2.PETROEX_CONSIGNEE_NUMBER = row1.PETROEX_CONSIGNEE_NUMBER;			row2.PETROEX_SUBSCRIBER = row1.PETROEX_SUBSCRIBER;			row2.ELVIS_OFFLINE_DIRECTIVE = row1.ELVIS_OFFLINE_DIRECTIVE;			row2.ORDER_ALLOCATION_REQUIRED = row1.ORDER_ALLOCATION_REQUIRED;			row2.ALLOCATION_REQUIRED_TO_LOAD = row1.ALLOCATION_REQUIRED_TO_LOAD;			row2.TABS_ORDERS = row1.TABS_ORDERS;			row2.TABS_SELLER_ID = row1.TABS_SELLER_ID;			row2.TABS_HOST_INTERFACE_CODE = row1.TABS_HOST_INTERFACE_CODE;			row2.DESTINATION_STATION_ENABLE = row1.DESTINATION_STATION_ENABLE;			row2.STATION_NUMBER = row1.STATION_NUMBER;			row2.EXCISE_NUMBER = row1.EXCISE_NUMBER;					
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
								
	                        		    	Object exprKeyValue_row3__SUPPLIER_NUMBER = row2.SUPPLIER_NUMBER ;
	                        		    	if(exprKeyValue_row3__SUPPLIER_NUMBER == null) {
	                        		    		hasCasePrimitiveKeyWithNull_tMap_1 = true;
	                        		    	} else {
                        		    			row3HashKey.SUPPLIER_NUMBER = (int)(Integer) exprKeyValue_row3__SUPPLIER_NUMBER;
                        		    		}
                        		    		
	                        		    	Object exprKeyValue_row3__CUSTOMER_NUMBER = row2.CUSTOMER_NUMBER ;
	                        		    	if(exprKeyValue_row3__CUSTOMER_NUMBER == null) {
	                        		    		hasCasePrimitiveKeyWithNull_tMap_1 = true;
	                        		    	} else {
                        		    			row3HashKey.CUSTOMER_NUMBER = (int)(Integer) exprKeyValue_row3__CUSTOMER_NUMBER;
                        		    		}
                        		    		

								
		                        	row3HashKey.hashCodeDirty = true;
                        		
	  					
	  							
	
		  							if(!hasCasePrimitiveKeyWithNull_tMap_1) { // G_TM_M_091
		  							
			  					
			  					
			  					
	  					
		  							tHash_Lookup_row3.lookup( row3HashKey );

	  							

	  							

			  						} // G_TM_M_091
			  						
			  					

 								
		  				
	  								
						
									
  									  		
 								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_row3 != null && tHash_Lookup_row3.getCount(row3HashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row3' and it contains more one result from keys :  row3.SUPPLIER_NUMBER = '" + row3HashKey.SUPPLIER_NUMBER + "', row3.CUSTOMER_NUMBER = '" + row3HashKey.CUSTOMER_NUMBER + "'");
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
Var.PK_CUSTOMER = Numeric.sequence("s15",1,1) ;// ###############################
        // ###############################
        // # Output tables

out1 = null;

boolean rejected_tMap_1 = true;
// ###### START REJECTS ##### 

// # Output reject table : 'out1'
// # Filter conditions 
if( rejected_tMap_1 ) {
out1_tmp.PK_CUSTOMER = Var.PK_CUSTOMER ;
out1_tmp.SUPPLIER_NUMBER = row2.SUPPLIER_NUMBER ;
out1_tmp.CUSTOMER_NUMBER = row2.CUSTOMER_NUMBER ;
out1_tmp.BILLING_ADDRESS_1 = row2.BILLING_ADDRESS_1 ;
out1_tmp.DET_CUSTOMER_NUMBER = row2.DET_CUSTOMER_NUMBER ;
out1_tmp.LAST_USER_NAME = row2.LAST_USER_NAME ;
out1_tmp.LAST_MODIFIED = row2.LAST_MODIFIED ;
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


                    pstmt_tDBOutput_1.setInt(1, out1.PK_CUSTOMER);

            int checkCount_tDBOutput_1 = -1;
            try (java.sql.ResultSet rs_tDBOutput_1 = pstmt_tDBOutput_1.executeQuery()) {
                while(rs_tDBOutput_1.next()) {
                    checkCount_tDBOutput_1 = rs_tDBOutput_1.getInt(1);
                }
            }
            if(checkCount_tDBOutput_1 > 0) {
                        pstmtUpdate_tDBOutput_1.setInt(1, out1.SUPPLIER_NUMBER);

                        pstmtUpdate_tDBOutput_1.setInt(2, out1.CUSTOMER_NUMBER);

                        if(out1.BILLING_ADDRESS_1 == null) {
pstmtUpdate_tDBOutput_1.setNull(3, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(3, out1.BILLING_ADDRESS_1);
}

                        pstmtUpdate_tDBOutput_1.setInt(4, out1.DET_CUSTOMER_NUMBER);

                        if(out1.LAST_USER_NAME == null) {
pstmtUpdate_tDBOutput_1.setNull(5, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(5, out1.LAST_USER_NAME);
}

                        if(out1.LAST_MODIFIED != null) {
pstmtUpdate_tDBOutput_1.setTimestamp(6, new java.sql.Timestamp(out1.LAST_MODIFIED.getTime()));
} else {
pstmtUpdate_tDBOutput_1.setNull(6, java.sql.Types.TIMESTAMP);
}


	                    

                        pstmtUpdate_tDBOutput_1.setInt(7 + count_tDBOutput_1, out1.PK_CUSTOMER);

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
                        pstmtInsert_tDBOutput_1.setInt(1, out1.PK_CUSTOMER);

                        pstmtInsert_tDBOutput_1.setInt(2, out1.SUPPLIER_NUMBER);

                        pstmtInsert_tDBOutput_1.setInt(3, out1.CUSTOMER_NUMBER);

                        if(out1.BILLING_ADDRESS_1 == null) {
pstmtInsert_tDBOutput_1.setNull(4, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(4, out1.BILLING_ADDRESS_1);
}

                        pstmtInsert_tDBOutput_1.setInt(5, out1.DET_CUSTOMER_NUMBER);

                        if(out1.LAST_USER_NAME == null) {
pstmtInsert_tDBOutput_1.setNull(6, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(6, out1.LAST_USER_NAME);
}

                        if(out1.LAST_MODIFIED != null) {
pstmtInsert_tDBOutput_1.setTimestamp(7, new java.sql.Timestamp(out1.LAST_MODIFIED.getTime()));
} else {
pstmtInsert_tDBOutput_1.setNull(7, java.sql.Types.TIMESTAMP);
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
    final static byte[] commonByteArrayLock_PGS_STAGE_DIM_CUSTOMER = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_DIM_CUSTOMER = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public int PK_CUSTOMER;

				public int getPK_CUSTOMER () {
					return this.PK_CUSTOMER;
				}
				
			    public int SUPPLIER_NUMBER;

				public int getSUPPLIER_NUMBER () {
					return this.SUPPLIER_NUMBER;
				}
				
			    public int CUSTOMER_NUMBER;

				public int getCUSTOMER_NUMBER () {
					return this.CUSTOMER_NUMBER;
				}
				
			    public String BILLING_ADDRESS_1;

				public String getBILLING_ADDRESS_1 () {
					return this.BILLING_ADDRESS_1;
				}
				
			    public int DET_CUSTOMER_NUMBER;

				public int getDET_CUSTOMER_NUMBER () {
					return this.DET_CUSTOMER_NUMBER;
				}
				
			    public String LAST_USER_NAME;

				public String getLAST_USER_NAME () {
					return this.LAST_USER_NAME;
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
	
							result = prime * result + (int) this.SUPPLIER_NUMBER;
						
							result = prime * result + (int) this.CUSTOMER_NUMBER;
						
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
		
						if (this.SUPPLIER_NUMBER != other.SUPPLIER_NUMBER)
							return false;
					
						if (this.CUSTOMER_NUMBER != other.CUSTOMER_NUMBER)
							return false;
					

		return true;
    }

	public void copyDataTo(row3Struct other) {

		other.PK_CUSTOMER = this.PK_CUSTOMER;
	            other.SUPPLIER_NUMBER = this.SUPPLIER_NUMBER;
	            other.CUSTOMER_NUMBER = this.CUSTOMER_NUMBER;
	            other.BILLING_ADDRESS_1 = this.BILLING_ADDRESS_1;
	            other.DET_CUSTOMER_NUMBER = this.DET_CUSTOMER_NUMBER;
	            other.LAST_USER_NAME = this.LAST_USER_NAME;
	            other.LAST_MODIFIED = this.LAST_MODIFIED;
	            
	}

	public void copyKeysDataTo(row3Struct other) {

		other.SUPPLIER_NUMBER = this.SUPPLIER_NUMBER;
	            	other.CUSTOMER_NUMBER = this.CUSTOMER_NUMBER;
	            	
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

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_CUSTOMER) {

        	try {

        		int length = 0;
		
			        this.SUPPLIER_NUMBER = dis.readInt();
					
			        this.CUSTOMER_NUMBER = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_CUSTOMER) {

        	try {

        		int length = 0;
		
			        this.SUPPLIER_NUMBER = dis.readInt();
					
			        this.CUSTOMER_NUMBER = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.SUPPLIER_NUMBER);
					
					// int
				
		            	dos.writeInt(this.CUSTOMER_NUMBER);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.SUPPLIER_NUMBER);
					
					// int
				
		            	dos.writeInt(this.CUSTOMER_NUMBER);
					
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
		
			            this.PK_CUSTOMER = dis.readInt();
					
						this.BILLING_ADDRESS_1 = readString(dis,ois);
					
			            this.DET_CUSTOMER_NUMBER = dis.readInt();
					
						this.LAST_USER_NAME = readString(dis,ois);
					
						this.LAST_MODIFIED = readDate(dis,ois);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
			            this.PK_CUSTOMER = objectIn.readInt();
					
						this.BILLING_ADDRESS_1 = readString(dis,objectIn);
					
			            this.DET_CUSTOMER_NUMBER = objectIn.readInt();
					
						this.LAST_USER_NAME = readString(dis,objectIn);
					
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

		
		            	dos.writeInt(this.PK_CUSTOMER);
					
						writeString(this.BILLING_ADDRESS_1, dos, oos);
					
		            	dos.writeInt(this.DET_CUSTOMER_NUMBER);
					
						writeString(this.LAST_USER_NAME, dos, oos);
					
						writeDate(this.LAST_MODIFIED, dos, oos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
					objectOut.writeInt(this.PK_CUSTOMER);
					
						writeString(this.BILLING_ADDRESS_1, dos, objectOut);
					
					objectOut.writeInt(this.DET_CUSTOMER_NUMBER);
					
						writeString(this.LAST_USER_NAME, dos, objectOut);
					
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
		sb.append("PK_CUSTOMER="+String.valueOf(PK_CUSTOMER));
		sb.append(",SUPPLIER_NUMBER="+String.valueOf(SUPPLIER_NUMBER));
		sb.append(",CUSTOMER_NUMBER="+String.valueOf(CUSTOMER_NUMBER));
		sb.append(",BILLING_ADDRESS_1="+BILLING_ADDRESS_1);
		sb.append(",DET_CUSTOMER_NUMBER="+String.valueOf(DET_CUSTOMER_NUMBER));
		sb.append(",LAST_USER_NAME="+LAST_USER_NAME);
		sb.append(",LAST_MODIFIED="+String.valueOf(LAST_MODIFIED));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row3Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.SUPPLIER_NUMBER, other.SUPPLIER_NUMBER);
						if(returnValue != 0) {
							return returnValue;
						}

					
						returnValue = checkNullsAndCompare(this.CUSTOMER_NUMBER, other.CUSTOMER_NUMBER);
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
				
				 
	final String decryptedPassword_tDBInput_2 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:+pXy6wRqZnET/5NFPQ2gaFYb2F40IOovcDSqyELTGilIz2lpang=");
				
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

		    String dbquery_tDBInput_2 = "SELECT dbo.DIM_CUSTOMER.PK_CUSTOMER,\n		dbo.DIM_CUSTOMER.SUPPLIER_NUMBER,\n		dbo.DIM_CUSTOMER.CUSTOMER_NUMBER,\n		dbo.DIM_"
+"CUSTOMER.BILLING_ADDRESS_1,\n		dbo.DIM_CUSTOMER.DET_CUSTOMER_NUMBER,\n		dbo.DIM_CUSTOMER.LAST_USER_NAME,\n		dbo.DIM_CUSTOME"
+"R.LAST_MODIFIED\nFROM	dbo.DIM_CUSTOMER";
		    

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
								row3.PK_CUSTOMER = 0;
							} else {
		                          
            row3.PK_CUSTOMER = rs_tDBInput_2.getInt(1);
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
								row3.CUSTOMER_NUMBER = 0;
							} else {
		                          
            row3.CUSTOMER_NUMBER = rs_tDBInput_2.getInt(3);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 4) {
								row3.BILLING_ADDRESS_1 = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(4);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(4).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.BILLING_ADDRESS_1 = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row3.BILLING_ADDRESS_1 = tmpContent_tDBInput_2;
                }
            } else {
                row3.BILLING_ADDRESS_1 = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 5) {
								row3.DET_CUSTOMER_NUMBER = 0;
							} else {
		                          
            row3.DET_CUSTOMER_NUMBER = rs_tDBInput_2.getInt(5);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 6) {
								row3.LAST_USER_NAME = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(6);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(6).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.LAST_USER_NAME = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row3.LAST_USER_NAME = tmpContent_tDBInput_2;
                }
            } else {
                row3.LAST_USER_NAME = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 7) {
								row3.LAST_MODIFIED = null;
							} else {
										
			row3.LAST_MODIFIED = mssqlGTU_tDBInput_2.getDate(rsmd_tDBInput_2, rs_tDBInput_2, 7);
			
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
		   	   	   
				
				row3_HashRow.PK_CUSTOMER = row3.PK_CUSTOMER;
				
				row3_HashRow.SUPPLIER_NUMBER = row3.SUPPLIER_NUMBER;
				
				row3_HashRow.CUSTOMER_NUMBER = row3.CUSTOMER_NUMBER;
				
				row3_HashRow.BILLING_ADDRESS_1 = row3.BILLING_ADDRESS_1;
				
				row3_HashRow.DET_CUSTOMER_NUMBER = row3.DET_CUSTOMER_NUMBER;
				
				row3_HashRow.LAST_USER_NAME = row3.LAST_USER_NAME;
				
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
        final DIM_CUSTOMER DIM_CUSTOMERClass = new DIM_CUSTOMER();

        int exitCode = DIM_CUSTOMERClass.runJobInTOS(args);

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
            java.io.InputStream inContext = DIM_CUSTOMER.class.getClassLoader().getResourceAsStream("pgs_stage/dim_customer_0_1/contexts/" + contextStr + ".properties");
            if (inContext == null) {
                inContext = DIM_CUSTOMER.class.getClassLoader().getResourceAsStream("config/contexts/" + contextStr + ".properties");
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
            System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : DIM_CUSTOMER");
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
 *     209185 characters generated by Talend Open Studio for Data Integration 
 *     on the 3 août 2024 à 14:42:26 GMT+01:00
 ************************************************************************************************/