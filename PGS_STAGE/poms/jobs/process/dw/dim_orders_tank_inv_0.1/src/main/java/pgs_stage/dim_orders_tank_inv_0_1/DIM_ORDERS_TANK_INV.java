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


package pgs_stage.dim_orders_tank_inv_0_1;

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
 * Job: DIM_ORDERS_TANK_INV Purpose: <br>
 * Description:  <br>
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status 
 */
public class DIM_ORDERS_TANK_INV implements TalendJob {

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
	private final String jobName = "DIM_ORDERS_TANK_INV";
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
				DIM_ORDERS_TANK_INV.this.exception = e;
			}
		}
		if (!(e instanceof TalendException)) {
		try {
			for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
				if (m.getName().compareTo(currentComponent + "_error") == 0) {
					m.invoke(DIM_ORDERS_TANK_INV.this, new Object[] { e , currentComponent, globalMap});
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
    final static byte[] commonByteArrayLock_PGS_STAGE_DIM_ORDERS_TANK_INV = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_DIM_ORDERS_TANK_INV = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public int PK_ORDERS_TANK_INV;

				public int getPK_ORDERS_TANK_INV () {
					return this.PK_ORDERS_TANK_INV;
				}
				
			    public int ORDER_ID;

				public int getORDER_ID () {
					return this.ORDER_ID;
				}
				
			    public String TANK_CODE;

				public String getTANK_CODE () {
					return this.TANK_CODE;
				}
				
			    public int SEQUENCE_NUMBER;

				public int getSEQUENCE_NUMBER () {
					return this.SEQUENCE_NUMBER;
				}
				
			    public int TERMINAL_PRODUCT_NUMBER;

				public int getTERMINAL_PRODUCT_NUMBER () {
					return this.TERMINAL_PRODUCT_NUMBER;
				}
				
			    public int SUPPLIER_NUMBER;

				public int getSUPPLIER_NUMBER () {
					return this.SUPPLIER_NUMBER;
				}
				
			    public int INVENTORY_QUANTITY_TYPE;

				public int getINVENTORY_QUANTITY_TYPE () {
					return this.INVENTORY_QUANTITY_TYPE;
				}
				
			    public int INVENTORY_QTY;

				public int getINVENTORY_QTY () {
					return this.INVENTORY_QTY;
				}
				
			    public int GROSS_QUANTITY;

				public int getGROSS_QUANTITY () {
					return this.GROSS_QUANTITY;
				}
				
			    public int NET_QUANTITY;

				public int getNET_QUANTITY () {
					return this.NET_QUANTITY;
				}
				
			    public int WEIGHT;

				public int getWEIGHT () {
					return this.WEIGHT;
				}
				
			    public int WEIGHT_IN_VAC;

				public int getWEIGHT_IN_VAC () {
					return this.WEIGHT_IN_VAC;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
							result = prime * result + (int) this.PK_ORDERS_TANK_INV;
						
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
		
						if (this.PK_ORDERS_TANK_INV != other.PK_ORDERS_TANK_INV)
							return false;
					

		return true;
    }

	public void copyDataTo(out1Struct other) {

		other.PK_ORDERS_TANK_INV = this.PK_ORDERS_TANK_INV;
	            other.ORDER_ID = this.ORDER_ID;
	            other.TANK_CODE = this.TANK_CODE;
	            other.SEQUENCE_NUMBER = this.SEQUENCE_NUMBER;
	            other.TERMINAL_PRODUCT_NUMBER = this.TERMINAL_PRODUCT_NUMBER;
	            other.SUPPLIER_NUMBER = this.SUPPLIER_NUMBER;
	            other.INVENTORY_QUANTITY_TYPE = this.INVENTORY_QUANTITY_TYPE;
	            other.INVENTORY_QTY = this.INVENTORY_QTY;
	            other.GROSS_QUANTITY = this.GROSS_QUANTITY;
	            other.NET_QUANTITY = this.NET_QUANTITY;
	            other.WEIGHT = this.WEIGHT;
	            other.WEIGHT_IN_VAC = this.WEIGHT_IN_VAC;
	            
	}

	public void copyKeysDataTo(out1Struct other) {

		other.PK_ORDERS_TANK_INV = this.PK_ORDERS_TANK_INV;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PGS_STAGE_DIM_ORDERS_TANK_INV.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_ORDERS_TANK_INV.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_ORDERS_TANK_INV = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_ORDERS_TANK_INV = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PGS_STAGE_DIM_ORDERS_TANK_INV, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_ORDERS_TANK_INV, 0, length, utf8Charset);
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
			if(length > commonByteArray_PGS_STAGE_DIM_ORDERS_TANK_INV.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_ORDERS_TANK_INV.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_ORDERS_TANK_INV = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_ORDERS_TANK_INV = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PGS_STAGE_DIM_ORDERS_TANK_INV, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_ORDERS_TANK_INV, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_ORDERS_TANK_INV) {

        	try {

        		int length = 0;
		
			        this.PK_ORDERS_TANK_INV = dis.readInt();
					
			        this.ORDER_ID = dis.readInt();
					
					this.TANK_CODE = readString(dis);
					
			        this.SEQUENCE_NUMBER = dis.readInt();
					
			        this.TERMINAL_PRODUCT_NUMBER = dis.readInt();
					
			        this.SUPPLIER_NUMBER = dis.readInt();
					
			        this.INVENTORY_QUANTITY_TYPE = dis.readInt();
					
			        this.INVENTORY_QTY = dis.readInt();
					
			        this.GROSS_QUANTITY = dis.readInt();
					
			        this.NET_QUANTITY = dis.readInt();
					
			        this.WEIGHT = dis.readInt();
					
			        this.WEIGHT_IN_VAC = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_ORDERS_TANK_INV) {

        	try {

        		int length = 0;
		
			        this.PK_ORDERS_TANK_INV = dis.readInt();
					
			        this.ORDER_ID = dis.readInt();
					
					this.TANK_CODE = readString(dis);
					
			        this.SEQUENCE_NUMBER = dis.readInt();
					
			        this.TERMINAL_PRODUCT_NUMBER = dis.readInt();
					
			        this.SUPPLIER_NUMBER = dis.readInt();
					
			        this.INVENTORY_QUANTITY_TYPE = dis.readInt();
					
			        this.INVENTORY_QTY = dis.readInt();
					
			        this.GROSS_QUANTITY = dis.readInt();
					
			        this.NET_QUANTITY = dis.readInt();
					
			        this.WEIGHT = dis.readInt();
					
			        this.WEIGHT_IN_VAC = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.PK_ORDERS_TANK_INV);
					
					// int
				
		            	dos.writeInt(this.ORDER_ID);
					
					// String
				
						writeString(this.TANK_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.SEQUENCE_NUMBER);
					
					// int
				
		            	dos.writeInt(this.TERMINAL_PRODUCT_NUMBER);
					
					// int
				
		            	dos.writeInt(this.SUPPLIER_NUMBER);
					
					// int
				
		            	dos.writeInt(this.INVENTORY_QUANTITY_TYPE);
					
					// int
				
		            	dos.writeInt(this.INVENTORY_QTY);
					
					// int
				
		            	dos.writeInt(this.GROSS_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.NET_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.WEIGHT);
					
					// int
				
		            	dos.writeInt(this.WEIGHT_IN_VAC);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.PK_ORDERS_TANK_INV);
					
					// int
				
		            	dos.writeInt(this.ORDER_ID);
					
					// String
				
						writeString(this.TANK_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.SEQUENCE_NUMBER);
					
					// int
				
		            	dos.writeInt(this.TERMINAL_PRODUCT_NUMBER);
					
					// int
				
		            	dos.writeInt(this.SUPPLIER_NUMBER);
					
					// int
				
		            	dos.writeInt(this.INVENTORY_QUANTITY_TYPE);
					
					// int
				
		            	dos.writeInt(this.INVENTORY_QTY);
					
					// int
				
		            	dos.writeInt(this.GROSS_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.NET_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.WEIGHT);
					
					// int
				
		            	dos.writeInt(this.WEIGHT_IN_VAC);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("PK_ORDERS_TANK_INV="+String.valueOf(PK_ORDERS_TANK_INV));
		sb.append(",ORDER_ID="+String.valueOf(ORDER_ID));
		sb.append(",TANK_CODE="+TANK_CODE);
		sb.append(",SEQUENCE_NUMBER="+String.valueOf(SEQUENCE_NUMBER));
		sb.append(",TERMINAL_PRODUCT_NUMBER="+String.valueOf(TERMINAL_PRODUCT_NUMBER));
		sb.append(",SUPPLIER_NUMBER="+String.valueOf(SUPPLIER_NUMBER));
		sb.append(",INVENTORY_QUANTITY_TYPE="+String.valueOf(INVENTORY_QUANTITY_TYPE));
		sb.append(",INVENTORY_QTY="+String.valueOf(INVENTORY_QTY));
		sb.append(",GROSS_QUANTITY="+String.valueOf(GROSS_QUANTITY));
		sb.append(",NET_QUANTITY="+String.valueOf(NET_QUANTITY));
		sb.append(",WEIGHT="+String.valueOf(WEIGHT));
		sb.append(",WEIGHT_IN_VAC="+String.valueOf(WEIGHT_IN_VAC));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(out1Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.PK_ORDERS_TANK_INV, other.PK_ORDERS_TANK_INV);
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
    final static byte[] commonByteArrayLock_PGS_STAGE_DIM_ORDERS_TANK_INV = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_DIM_ORDERS_TANK_INV = new byte[0];

	
			    public int ORDER_ID;

				public int getORDER_ID () {
					return this.ORDER_ID;
				}
				
			    public String TANK_CODE;

				public String getTANK_CODE () {
					return this.TANK_CODE;
				}
				
			    public int SEQUENCE_NUMBER;

				public int getSEQUENCE_NUMBER () {
					return this.SEQUENCE_NUMBER;
				}
				
			    public int TERMINAL_PRODUCT_NUMBER;

				public int getTERMINAL_PRODUCT_NUMBER () {
					return this.TERMINAL_PRODUCT_NUMBER;
				}
				
			    public int SUPPLIER_NUMBER;

				public int getSUPPLIER_NUMBER () {
					return this.SUPPLIER_NUMBER;
				}
				
			    public int MANUALLY_ASSIGNED;

				public int getMANUALLY_ASSIGNED () {
					return this.MANUALLY_ASSIGNED;
				}
				
			    public String PARCEL_CODE;

				public String getPARCEL_CODE () {
					return this.PARCEL_CODE;
				}
				
			    public int INVENTORY_QTY;

				public int getINVENTORY_QTY () {
					return this.INVENTORY_QTY;
				}
				
			    public int FRAC_INVENTORY_QTY;

				public int getFRAC_INVENTORY_QTY () {
					return this.FRAC_INVENTORY_QTY;
				}
				
			    public int INVENTORY_QUANTITY_TYPE;

				public int getINVENTORY_QUANTITY_TYPE () {
					return this.INVENTORY_QUANTITY_TYPE;
				}
				
			    public int GROSS_QUANTITY;

				public int getGROSS_QUANTITY () {
					return this.GROSS_QUANTITY;
				}
				
			    public int GROSS_FRAC_QUANTITY;

				public int getGROSS_FRAC_QUANTITY () {
					return this.GROSS_FRAC_QUANTITY;
				}
				
			    public int NET_QUANTITY;

				public int getNET_QUANTITY () {
					return this.NET_QUANTITY;
				}
				
			    public int NET_FRAC_QUANTITY;

				public int getNET_FRAC_QUANTITY () {
					return this.NET_FRAC_QUANTITY;
				}
				
			    public int WEIGHT;

				public int getWEIGHT () {
					return this.WEIGHT;
				}
				
			    public int FRAC_WEIGHT;

				public int getFRAC_WEIGHT () {
					return this.FRAC_WEIGHT;
				}
				
			    public int WEIGHT_IN_VAC;

				public int getWEIGHT_IN_VAC () {
					return this.WEIGHT_IN_VAC;
				}
				
			    public int FRAC_WEIGHT_IN_VAC;

				public int getFRAC_WEIGHT_IN_VAC () {
					return this.FRAC_WEIGHT_IN_VAC;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PGS_STAGE_DIM_ORDERS_TANK_INV.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_ORDERS_TANK_INV.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_ORDERS_TANK_INV = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_ORDERS_TANK_INV = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PGS_STAGE_DIM_ORDERS_TANK_INV, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_ORDERS_TANK_INV, 0, length, utf8Charset);
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
			if(length > commonByteArray_PGS_STAGE_DIM_ORDERS_TANK_INV.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_ORDERS_TANK_INV.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_ORDERS_TANK_INV = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_ORDERS_TANK_INV = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PGS_STAGE_DIM_ORDERS_TANK_INV, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_ORDERS_TANK_INV, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_ORDERS_TANK_INV) {

        	try {

        		int length = 0;
		
			        this.ORDER_ID = dis.readInt();
					
					this.TANK_CODE = readString(dis);
					
			        this.SEQUENCE_NUMBER = dis.readInt();
					
			        this.TERMINAL_PRODUCT_NUMBER = dis.readInt();
					
			        this.SUPPLIER_NUMBER = dis.readInt();
					
			        this.MANUALLY_ASSIGNED = dis.readInt();
					
					this.PARCEL_CODE = readString(dis);
					
			        this.INVENTORY_QTY = dis.readInt();
					
			        this.FRAC_INVENTORY_QTY = dis.readInt();
					
			        this.INVENTORY_QUANTITY_TYPE = dis.readInt();
					
			        this.GROSS_QUANTITY = dis.readInt();
					
			        this.GROSS_FRAC_QUANTITY = dis.readInt();
					
			        this.NET_QUANTITY = dis.readInt();
					
			        this.NET_FRAC_QUANTITY = dis.readInt();
					
			        this.WEIGHT = dis.readInt();
					
			        this.FRAC_WEIGHT = dis.readInt();
					
			        this.WEIGHT_IN_VAC = dis.readInt();
					
			        this.FRAC_WEIGHT_IN_VAC = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_ORDERS_TANK_INV) {

        	try {

        		int length = 0;
		
			        this.ORDER_ID = dis.readInt();
					
					this.TANK_CODE = readString(dis);
					
			        this.SEQUENCE_NUMBER = dis.readInt();
					
			        this.TERMINAL_PRODUCT_NUMBER = dis.readInt();
					
			        this.SUPPLIER_NUMBER = dis.readInt();
					
			        this.MANUALLY_ASSIGNED = dis.readInt();
					
					this.PARCEL_CODE = readString(dis);
					
			        this.INVENTORY_QTY = dis.readInt();
					
			        this.FRAC_INVENTORY_QTY = dis.readInt();
					
			        this.INVENTORY_QUANTITY_TYPE = dis.readInt();
					
			        this.GROSS_QUANTITY = dis.readInt();
					
			        this.GROSS_FRAC_QUANTITY = dis.readInt();
					
			        this.NET_QUANTITY = dis.readInt();
					
			        this.NET_FRAC_QUANTITY = dis.readInt();
					
			        this.WEIGHT = dis.readInt();
					
			        this.FRAC_WEIGHT = dis.readInt();
					
			        this.WEIGHT_IN_VAC = dis.readInt();
					
			        this.FRAC_WEIGHT_IN_VAC = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.ORDER_ID);
					
					// String
				
						writeString(this.TANK_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.SEQUENCE_NUMBER);
					
					// int
				
		            	dos.writeInt(this.TERMINAL_PRODUCT_NUMBER);
					
					// int
				
		            	dos.writeInt(this.SUPPLIER_NUMBER);
					
					// int
				
		            	dos.writeInt(this.MANUALLY_ASSIGNED);
					
					// String
				
						writeString(this.PARCEL_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.INVENTORY_QTY);
					
					// int
				
		            	dos.writeInt(this.FRAC_INVENTORY_QTY);
					
					// int
				
		            	dos.writeInt(this.INVENTORY_QUANTITY_TYPE);
					
					// int
				
		            	dos.writeInt(this.GROSS_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.GROSS_FRAC_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.NET_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.NET_FRAC_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.WEIGHT);
					
					// int
				
		            	dos.writeInt(this.FRAC_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.FRAC_WEIGHT_IN_VAC);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.ORDER_ID);
					
					// String
				
						writeString(this.TANK_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.SEQUENCE_NUMBER);
					
					// int
				
		            	dos.writeInt(this.TERMINAL_PRODUCT_NUMBER);
					
					// int
				
		            	dos.writeInt(this.SUPPLIER_NUMBER);
					
					// int
				
		            	dos.writeInt(this.MANUALLY_ASSIGNED);
					
					// String
				
						writeString(this.PARCEL_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.INVENTORY_QTY);
					
					// int
				
		            	dos.writeInt(this.FRAC_INVENTORY_QTY);
					
					// int
				
		            	dos.writeInt(this.INVENTORY_QUANTITY_TYPE);
					
					// int
				
		            	dos.writeInt(this.GROSS_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.GROSS_FRAC_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.NET_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.NET_FRAC_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.WEIGHT);
					
					// int
				
		            	dos.writeInt(this.FRAC_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.FRAC_WEIGHT_IN_VAC);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("ORDER_ID="+String.valueOf(ORDER_ID));
		sb.append(",TANK_CODE="+TANK_CODE);
		sb.append(",SEQUENCE_NUMBER="+String.valueOf(SEQUENCE_NUMBER));
		sb.append(",TERMINAL_PRODUCT_NUMBER="+String.valueOf(TERMINAL_PRODUCT_NUMBER));
		sb.append(",SUPPLIER_NUMBER="+String.valueOf(SUPPLIER_NUMBER));
		sb.append(",MANUALLY_ASSIGNED="+String.valueOf(MANUALLY_ASSIGNED));
		sb.append(",PARCEL_CODE="+PARCEL_CODE);
		sb.append(",INVENTORY_QTY="+String.valueOf(INVENTORY_QTY));
		sb.append(",FRAC_INVENTORY_QTY="+String.valueOf(FRAC_INVENTORY_QTY));
		sb.append(",INVENTORY_QUANTITY_TYPE="+String.valueOf(INVENTORY_QUANTITY_TYPE));
		sb.append(",GROSS_QUANTITY="+String.valueOf(GROSS_QUANTITY));
		sb.append(",GROSS_FRAC_QUANTITY="+String.valueOf(GROSS_FRAC_QUANTITY));
		sb.append(",NET_QUANTITY="+String.valueOf(NET_QUANTITY));
		sb.append(",NET_FRAC_QUANTITY="+String.valueOf(NET_FRAC_QUANTITY));
		sb.append(",WEIGHT="+String.valueOf(WEIGHT));
		sb.append(",FRAC_WEIGHT="+String.valueOf(FRAC_WEIGHT));
		sb.append(",WEIGHT_IN_VAC="+String.valueOf(WEIGHT_IN_VAC));
		sb.append(",FRAC_WEIGHT_IN_VAC="+String.valueOf(FRAC_WEIGHT_IN_VAC));
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
    final static byte[] commonByteArrayLock_PGS_STAGE_DIM_ORDERS_TANK_INV = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_DIM_ORDERS_TANK_INV = new byte[0];

	
			    public int ORDER_ID;

				public int getORDER_ID () {
					return this.ORDER_ID;
				}
				
			    public String TANK_CODE;

				public String getTANK_CODE () {
					return this.TANK_CODE;
				}
				
			    public int SEQUENCE_NUMBER;

				public int getSEQUENCE_NUMBER () {
					return this.SEQUENCE_NUMBER;
				}
				
			    public int TERMINAL_PRODUCT_NUMBER;

				public int getTERMINAL_PRODUCT_NUMBER () {
					return this.TERMINAL_PRODUCT_NUMBER;
				}
				
			    public int SUPPLIER_NUMBER;

				public int getSUPPLIER_NUMBER () {
					return this.SUPPLIER_NUMBER;
				}
				
			    public int MANUALLY_ASSIGNED;

				public int getMANUALLY_ASSIGNED () {
					return this.MANUALLY_ASSIGNED;
				}
				
			    public String PARCEL_CODE;

				public String getPARCEL_CODE () {
					return this.PARCEL_CODE;
				}
				
			    public int INVENTORY_QTY;

				public int getINVENTORY_QTY () {
					return this.INVENTORY_QTY;
				}
				
			    public int FRAC_INVENTORY_QTY;

				public int getFRAC_INVENTORY_QTY () {
					return this.FRAC_INVENTORY_QTY;
				}
				
			    public int INVENTORY_QUANTITY_TYPE;

				public int getINVENTORY_QUANTITY_TYPE () {
					return this.INVENTORY_QUANTITY_TYPE;
				}
				
			    public int GROSS_QUANTITY;

				public int getGROSS_QUANTITY () {
					return this.GROSS_QUANTITY;
				}
				
			    public int GROSS_FRAC_QUANTITY;

				public int getGROSS_FRAC_QUANTITY () {
					return this.GROSS_FRAC_QUANTITY;
				}
				
			    public int NET_QUANTITY;

				public int getNET_QUANTITY () {
					return this.NET_QUANTITY;
				}
				
			    public int NET_FRAC_QUANTITY;

				public int getNET_FRAC_QUANTITY () {
					return this.NET_FRAC_QUANTITY;
				}
				
			    public int WEIGHT;

				public int getWEIGHT () {
					return this.WEIGHT;
				}
				
			    public int FRAC_WEIGHT;

				public int getFRAC_WEIGHT () {
					return this.FRAC_WEIGHT;
				}
				
			    public int WEIGHT_IN_VAC;

				public int getWEIGHT_IN_VAC () {
					return this.WEIGHT_IN_VAC;
				}
				
			    public int FRAC_WEIGHT_IN_VAC;

				public int getFRAC_WEIGHT_IN_VAC () {
					return this.FRAC_WEIGHT_IN_VAC;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PGS_STAGE_DIM_ORDERS_TANK_INV.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_ORDERS_TANK_INV.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_ORDERS_TANK_INV = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_ORDERS_TANK_INV = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PGS_STAGE_DIM_ORDERS_TANK_INV, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_ORDERS_TANK_INV, 0, length, utf8Charset);
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
			if(length > commonByteArray_PGS_STAGE_DIM_ORDERS_TANK_INV.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_ORDERS_TANK_INV.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_ORDERS_TANK_INV = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_ORDERS_TANK_INV = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PGS_STAGE_DIM_ORDERS_TANK_INV, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_ORDERS_TANK_INV, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_ORDERS_TANK_INV) {

        	try {

        		int length = 0;
		
			        this.ORDER_ID = dis.readInt();
					
					this.TANK_CODE = readString(dis);
					
			        this.SEQUENCE_NUMBER = dis.readInt();
					
			        this.TERMINAL_PRODUCT_NUMBER = dis.readInt();
					
			        this.SUPPLIER_NUMBER = dis.readInt();
					
			        this.MANUALLY_ASSIGNED = dis.readInt();
					
					this.PARCEL_CODE = readString(dis);
					
			        this.INVENTORY_QTY = dis.readInt();
					
			        this.FRAC_INVENTORY_QTY = dis.readInt();
					
			        this.INVENTORY_QUANTITY_TYPE = dis.readInt();
					
			        this.GROSS_QUANTITY = dis.readInt();
					
			        this.GROSS_FRAC_QUANTITY = dis.readInt();
					
			        this.NET_QUANTITY = dis.readInt();
					
			        this.NET_FRAC_QUANTITY = dis.readInt();
					
			        this.WEIGHT = dis.readInt();
					
			        this.FRAC_WEIGHT = dis.readInt();
					
			        this.WEIGHT_IN_VAC = dis.readInt();
					
			        this.FRAC_WEIGHT_IN_VAC = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_ORDERS_TANK_INV) {

        	try {

        		int length = 0;
		
			        this.ORDER_ID = dis.readInt();
					
					this.TANK_CODE = readString(dis);
					
			        this.SEQUENCE_NUMBER = dis.readInt();
					
			        this.TERMINAL_PRODUCT_NUMBER = dis.readInt();
					
			        this.SUPPLIER_NUMBER = dis.readInt();
					
			        this.MANUALLY_ASSIGNED = dis.readInt();
					
					this.PARCEL_CODE = readString(dis);
					
			        this.INVENTORY_QTY = dis.readInt();
					
			        this.FRAC_INVENTORY_QTY = dis.readInt();
					
			        this.INVENTORY_QUANTITY_TYPE = dis.readInt();
					
			        this.GROSS_QUANTITY = dis.readInt();
					
			        this.GROSS_FRAC_QUANTITY = dis.readInt();
					
			        this.NET_QUANTITY = dis.readInt();
					
			        this.NET_FRAC_QUANTITY = dis.readInt();
					
			        this.WEIGHT = dis.readInt();
					
			        this.FRAC_WEIGHT = dis.readInt();
					
			        this.WEIGHT_IN_VAC = dis.readInt();
					
			        this.FRAC_WEIGHT_IN_VAC = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.ORDER_ID);
					
					// String
				
						writeString(this.TANK_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.SEQUENCE_NUMBER);
					
					// int
				
		            	dos.writeInt(this.TERMINAL_PRODUCT_NUMBER);
					
					// int
				
		            	dos.writeInt(this.SUPPLIER_NUMBER);
					
					// int
				
		            	dos.writeInt(this.MANUALLY_ASSIGNED);
					
					// String
				
						writeString(this.PARCEL_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.INVENTORY_QTY);
					
					// int
				
		            	dos.writeInt(this.FRAC_INVENTORY_QTY);
					
					// int
				
		            	dos.writeInt(this.INVENTORY_QUANTITY_TYPE);
					
					// int
				
		            	dos.writeInt(this.GROSS_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.GROSS_FRAC_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.NET_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.NET_FRAC_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.WEIGHT);
					
					// int
				
		            	dos.writeInt(this.FRAC_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.FRAC_WEIGHT_IN_VAC);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.ORDER_ID);
					
					// String
				
						writeString(this.TANK_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.SEQUENCE_NUMBER);
					
					// int
				
		            	dos.writeInt(this.TERMINAL_PRODUCT_NUMBER);
					
					// int
				
		            	dos.writeInt(this.SUPPLIER_NUMBER);
					
					// int
				
		            	dos.writeInt(this.MANUALLY_ASSIGNED);
					
					// String
				
						writeString(this.PARCEL_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.INVENTORY_QTY);
					
					// int
				
		            	dos.writeInt(this.FRAC_INVENTORY_QTY);
					
					// int
				
		            	dos.writeInt(this.INVENTORY_QUANTITY_TYPE);
					
					// int
				
		            	dos.writeInt(this.GROSS_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.GROSS_FRAC_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.NET_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.NET_FRAC_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.WEIGHT);
					
					// int
				
		            	dos.writeInt(this.FRAC_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.FRAC_WEIGHT_IN_VAC);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("ORDER_ID="+String.valueOf(ORDER_ID));
		sb.append(",TANK_CODE="+TANK_CODE);
		sb.append(",SEQUENCE_NUMBER="+String.valueOf(SEQUENCE_NUMBER));
		sb.append(",TERMINAL_PRODUCT_NUMBER="+String.valueOf(TERMINAL_PRODUCT_NUMBER));
		sb.append(",SUPPLIER_NUMBER="+String.valueOf(SUPPLIER_NUMBER));
		sb.append(",MANUALLY_ASSIGNED="+String.valueOf(MANUALLY_ASSIGNED));
		sb.append(",PARCEL_CODE="+PARCEL_CODE);
		sb.append(",INVENTORY_QTY="+String.valueOf(INVENTORY_QTY));
		sb.append(",FRAC_INVENTORY_QTY="+String.valueOf(FRAC_INVENTORY_QTY));
		sb.append(",INVENTORY_QUANTITY_TYPE="+String.valueOf(INVENTORY_QUANTITY_TYPE));
		sb.append(",GROSS_QUANTITY="+String.valueOf(GROSS_QUANTITY));
		sb.append(",GROSS_FRAC_QUANTITY="+String.valueOf(GROSS_FRAC_QUANTITY));
		sb.append(",NET_QUANTITY="+String.valueOf(NET_QUANTITY));
		sb.append(",NET_FRAC_QUANTITY="+String.valueOf(NET_FRAC_QUANTITY));
		sb.append(",WEIGHT="+String.valueOf(WEIGHT));
		sb.append(",FRAC_WEIGHT="+String.valueOf(FRAC_WEIGHT));
		sb.append(",WEIGHT_IN_VAC="+String.valueOf(WEIGHT_IN_VAC));
		sb.append(",FRAC_WEIGHT_IN_VAC="+String.valueOf(FRAC_WEIGHT_IN_VAC));
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
    final static byte[] commonByteArrayLock_PGS_STAGE_DIM_ORDERS_TANK_INV = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_DIM_ORDERS_TANK_INV = new byte[0];

	
			    public int ORDER_ID;

				public int getORDER_ID () {
					return this.ORDER_ID;
				}
				
			    public String TANK_CODE;

				public String getTANK_CODE () {
					return this.TANK_CODE;
				}
				
			    public int SEQUENCE_NUMBER;

				public int getSEQUENCE_NUMBER () {
					return this.SEQUENCE_NUMBER;
				}
				
			    public int TERMINAL_PRODUCT_NUMBER;

				public int getTERMINAL_PRODUCT_NUMBER () {
					return this.TERMINAL_PRODUCT_NUMBER;
				}
				
			    public int SUPPLIER_NUMBER;

				public int getSUPPLIER_NUMBER () {
					return this.SUPPLIER_NUMBER;
				}
				
			    public int MANUALLY_ASSIGNED;

				public int getMANUALLY_ASSIGNED () {
					return this.MANUALLY_ASSIGNED;
				}
				
			    public String PARCEL_CODE;

				public String getPARCEL_CODE () {
					return this.PARCEL_CODE;
				}
				
			    public int INVENTORY_QTY;

				public int getINVENTORY_QTY () {
					return this.INVENTORY_QTY;
				}
				
			    public int FRAC_INVENTORY_QTY;

				public int getFRAC_INVENTORY_QTY () {
					return this.FRAC_INVENTORY_QTY;
				}
				
			    public int INVENTORY_QUANTITY_TYPE;

				public int getINVENTORY_QUANTITY_TYPE () {
					return this.INVENTORY_QUANTITY_TYPE;
				}
				
			    public int GROSS_QUANTITY;

				public int getGROSS_QUANTITY () {
					return this.GROSS_QUANTITY;
				}
				
			    public int GROSS_FRAC_QUANTITY;

				public int getGROSS_FRAC_QUANTITY () {
					return this.GROSS_FRAC_QUANTITY;
				}
				
			    public int NET_QUANTITY;

				public int getNET_QUANTITY () {
					return this.NET_QUANTITY;
				}
				
			    public int NET_FRAC_QUANTITY;

				public int getNET_FRAC_QUANTITY () {
					return this.NET_FRAC_QUANTITY;
				}
				
			    public int WEIGHT;

				public int getWEIGHT () {
					return this.WEIGHT;
				}
				
			    public int FRAC_WEIGHT;

				public int getFRAC_WEIGHT () {
					return this.FRAC_WEIGHT;
				}
				
			    public int WEIGHT_IN_VAC;

				public int getWEIGHT_IN_VAC () {
					return this.WEIGHT_IN_VAC;
				}
				
			    public int FRAC_WEIGHT_IN_VAC;

				public int getFRAC_WEIGHT_IN_VAC () {
					return this.FRAC_WEIGHT_IN_VAC;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PGS_STAGE_DIM_ORDERS_TANK_INV.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_ORDERS_TANK_INV.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_ORDERS_TANK_INV = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_ORDERS_TANK_INV = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PGS_STAGE_DIM_ORDERS_TANK_INV, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_ORDERS_TANK_INV, 0, length, utf8Charset);
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
			if(length > commonByteArray_PGS_STAGE_DIM_ORDERS_TANK_INV.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_ORDERS_TANK_INV.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_ORDERS_TANK_INV = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_ORDERS_TANK_INV = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PGS_STAGE_DIM_ORDERS_TANK_INV, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_ORDERS_TANK_INV, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_ORDERS_TANK_INV) {

        	try {

        		int length = 0;
		
			        this.ORDER_ID = dis.readInt();
					
					this.TANK_CODE = readString(dis);
					
			        this.SEQUENCE_NUMBER = dis.readInt();
					
			        this.TERMINAL_PRODUCT_NUMBER = dis.readInt();
					
			        this.SUPPLIER_NUMBER = dis.readInt();
					
			        this.MANUALLY_ASSIGNED = dis.readInt();
					
					this.PARCEL_CODE = readString(dis);
					
			        this.INVENTORY_QTY = dis.readInt();
					
			        this.FRAC_INVENTORY_QTY = dis.readInt();
					
			        this.INVENTORY_QUANTITY_TYPE = dis.readInt();
					
			        this.GROSS_QUANTITY = dis.readInt();
					
			        this.GROSS_FRAC_QUANTITY = dis.readInt();
					
			        this.NET_QUANTITY = dis.readInt();
					
			        this.NET_FRAC_QUANTITY = dis.readInt();
					
			        this.WEIGHT = dis.readInt();
					
			        this.FRAC_WEIGHT = dis.readInt();
					
			        this.WEIGHT_IN_VAC = dis.readInt();
					
			        this.FRAC_WEIGHT_IN_VAC = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_ORDERS_TANK_INV) {

        	try {

        		int length = 0;
		
			        this.ORDER_ID = dis.readInt();
					
					this.TANK_CODE = readString(dis);
					
			        this.SEQUENCE_NUMBER = dis.readInt();
					
			        this.TERMINAL_PRODUCT_NUMBER = dis.readInt();
					
			        this.SUPPLIER_NUMBER = dis.readInt();
					
			        this.MANUALLY_ASSIGNED = dis.readInt();
					
					this.PARCEL_CODE = readString(dis);
					
			        this.INVENTORY_QTY = dis.readInt();
					
			        this.FRAC_INVENTORY_QTY = dis.readInt();
					
			        this.INVENTORY_QUANTITY_TYPE = dis.readInt();
					
			        this.GROSS_QUANTITY = dis.readInt();
					
			        this.GROSS_FRAC_QUANTITY = dis.readInt();
					
			        this.NET_QUANTITY = dis.readInt();
					
			        this.NET_FRAC_QUANTITY = dis.readInt();
					
			        this.WEIGHT = dis.readInt();
					
			        this.FRAC_WEIGHT = dis.readInt();
					
			        this.WEIGHT_IN_VAC = dis.readInt();
					
			        this.FRAC_WEIGHT_IN_VAC = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.ORDER_ID);
					
					// String
				
						writeString(this.TANK_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.SEQUENCE_NUMBER);
					
					// int
				
		            	dos.writeInt(this.TERMINAL_PRODUCT_NUMBER);
					
					// int
				
		            	dos.writeInt(this.SUPPLIER_NUMBER);
					
					// int
				
		            	dos.writeInt(this.MANUALLY_ASSIGNED);
					
					// String
				
						writeString(this.PARCEL_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.INVENTORY_QTY);
					
					// int
				
		            	dos.writeInt(this.FRAC_INVENTORY_QTY);
					
					// int
				
		            	dos.writeInt(this.INVENTORY_QUANTITY_TYPE);
					
					// int
				
		            	dos.writeInt(this.GROSS_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.GROSS_FRAC_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.NET_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.NET_FRAC_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.WEIGHT);
					
					// int
				
		            	dos.writeInt(this.FRAC_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.FRAC_WEIGHT_IN_VAC);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.ORDER_ID);
					
					// String
				
						writeString(this.TANK_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.SEQUENCE_NUMBER);
					
					// int
				
		            	dos.writeInt(this.TERMINAL_PRODUCT_NUMBER);
					
					// int
				
		            	dos.writeInt(this.SUPPLIER_NUMBER);
					
					// int
				
		            	dos.writeInt(this.MANUALLY_ASSIGNED);
					
					// String
				
						writeString(this.PARCEL_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.INVENTORY_QTY);
					
					// int
				
		            	dos.writeInt(this.FRAC_INVENTORY_QTY);
					
					// int
				
		            	dos.writeInt(this.INVENTORY_QUANTITY_TYPE);
					
					// int
				
		            	dos.writeInt(this.GROSS_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.GROSS_FRAC_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.NET_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.NET_FRAC_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.WEIGHT);
					
					// int
				
		            	dos.writeInt(this.FRAC_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.FRAC_WEIGHT_IN_VAC);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("ORDER_ID="+String.valueOf(ORDER_ID));
		sb.append(",TANK_CODE="+TANK_CODE);
		sb.append(",SEQUENCE_NUMBER="+String.valueOf(SEQUENCE_NUMBER));
		sb.append(",TERMINAL_PRODUCT_NUMBER="+String.valueOf(TERMINAL_PRODUCT_NUMBER));
		sb.append(",SUPPLIER_NUMBER="+String.valueOf(SUPPLIER_NUMBER));
		sb.append(",MANUALLY_ASSIGNED="+String.valueOf(MANUALLY_ASSIGNED));
		sb.append(",PARCEL_CODE="+PARCEL_CODE);
		sb.append(",INVENTORY_QTY="+String.valueOf(INVENTORY_QTY));
		sb.append(",FRAC_INVENTORY_QTY="+String.valueOf(FRAC_INVENTORY_QTY));
		sb.append(",INVENTORY_QUANTITY_TYPE="+String.valueOf(INVENTORY_QUANTITY_TYPE));
		sb.append(",GROSS_QUANTITY="+String.valueOf(GROSS_QUANTITY));
		sb.append(",GROSS_FRAC_QUANTITY="+String.valueOf(GROSS_FRAC_QUANTITY));
		sb.append(",NET_QUANTITY="+String.valueOf(NET_QUANTITY));
		sb.append(",NET_FRAC_QUANTITY="+String.valueOf(NET_FRAC_QUANTITY));
		sb.append(",WEIGHT="+String.valueOf(WEIGHT));
		sb.append(",FRAC_WEIGHT="+String.valueOf(FRAC_WEIGHT));
		sb.append(",WEIGHT_IN_VAC="+String.valueOf(WEIGHT_IN_VAC));
		sb.append(",FRAC_WEIGHT_IN_VAC="+String.valueOf(FRAC_WEIGHT_IN_VAC));
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
        } else if (updateKeyCount_tDBOutput_1 == 12 && true) {
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

 
	final String decryptedPassword_tDBOutput_1 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:nHSL2QfflBeQcWa8IS7K9YfDtn7BUzAn/FCNfa/U6v4pClOp4cY=");

    String dbPwd_tDBOutput_1 = decryptedPassword_tDBOutput_1;	
    conn_tDBOutput_1 = java.sql.DriverManager.getConnection(url_tDBOutput_1,dbUser_tDBOutput_1,dbPwd_tDBOutput_1);
	
		resourceMap.put("conn_tDBOutput_1", conn_tDBOutput_1);
	
        conn_tDBOutput_1.setAutoCommit(false);
        int commitEvery_tDBOutput_1 = 10000;
        int commitCounter_tDBOutput_1 = 0;


if(dbschema_tDBOutput_1 == null || dbschema_tDBOutput_1.trim().length() == 0) {
    tableName_tDBOutput_1 = "DIM_ORDERS_TANK_INV";
} else {
    tableName_tDBOutput_1 = dbschema_tDBOutput_1 + "].[" + "DIM_ORDERS_TANK_INV";
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
                                        stmtCreate_tDBOutput_1.execute("CREATE TABLE [" + tableName_tDBOutput_1 + "]([PK_ORDERS_TANK_INV] INT  not null ,[ORDER_ID] INT  not null ,[TANK_CODE] VARCHAR(20)  ,[SEQUENCE_NUMBER] INT  not null ,[TERMINAL_PRODUCT_NUMBER] INT  not null ,[SUPPLIER_NUMBER] INT  not null ,[INVENTORY_QUANTITY_TYPE] INT  not null ,[INVENTORY_QTY] INT  not null ,[GROSS_QUANTITY] INT  not null ,[NET_QUANTITY] INT  not null ,[WEIGHT] INT  not null ,[WEIGHT_IN_VAC] INT  not null ,primary key([PK_ORDERS_TANK_INV]))");
                                    }
                                }
        java.sql.PreparedStatement pstmt_tDBOutput_1 = conn_tDBOutput_1.prepareStatement("SELECT COUNT(1) FROM [" + tableName_tDBOutput_1 + "] WHERE [PK_ORDERS_TANK_INV] = ?");
        resourceMap.put("pstmt_tDBOutput_1", pstmt_tDBOutput_1);
        String insert_tDBOutput_1 = "INSERT INTO [" + tableName_tDBOutput_1 + "] ([PK_ORDERS_TANK_INV],[ORDER_ID],[TANK_CODE],[SEQUENCE_NUMBER],[TERMINAL_PRODUCT_NUMBER],[SUPPLIER_NUMBER],[INVENTORY_QUANTITY_TYPE],[INVENTORY_QTY],[GROSS_QUANTITY],[NET_QUANTITY],[WEIGHT],[WEIGHT_IN_VAC]) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        java.sql.PreparedStatement pstmtInsert_tDBOutput_1 = conn_tDBOutput_1.prepareStatement(insert_tDBOutput_1);
        resourceMap.put("pstmtInsert_tDBOutput_1", pstmtInsert_tDBOutput_1);
        String update_tDBOutput_1 = "UPDATE [" + tableName_tDBOutput_1 + "] SET [ORDER_ID] = ?,[TANK_CODE] = ?,[SEQUENCE_NUMBER] = ?,[TERMINAL_PRODUCT_NUMBER] = ?,[SUPPLIER_NUMBER] = ?,[INVENTORY_QUANTITY_TYPE] = ?,[INVENTORY_QTY] = ?,[GROSS_QUANTITY] = ?,[NET_QUANTITY] = ?,[WEIGHT] = ?,[WEIGHT_IN_VAC] = ? WHERE [PK_ORDERS_TANK_INV] = ?";
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
	int PK_ORDERS_TANK_INV;
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
					String TANK_CODE;
					int SEQUENCE_NUMBER;        
	        
		    @Override
			public int hashCode() {
				if (this.hashCodeDirty) {
					final int prime = PRIME;
					int result = DEFAULT_HASHCODE;
			
									result = prime * result + (int) this.ORDER_ID;
									
								result = prime * result + ((this.TANK_CODE == null) ? 0 : this.TANK_CODE.hashCode());
								
									result = prime * result + (int) this.SEQUENCE_NUMBER;
									
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
								
									if (this.TANK_CODE == null) {
										if (other.TANK_CODE != null) 
											return false;
								
									} else if (!this.TANK_CODE.equals(other.TANK_CODE))
								 
										return false;
								
									if (this.SEQUENCE_NUMBER != other.SEQUENCE_NUMBER) 
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
				
				 
	final String decryptedPassword_tDBInput_1 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:5XwUfQzkYFq5JKcxrljFgH1wyc13mRnT+KsM1JEtqAK8XUm2Bkc=");
				
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

		    String dbquery_tDBInput_1 = "SELECT dbo.ORDERS_TANK_INV.ORDER_ID,\n		dbo.ORDERS_TANK_INV.TANK_CODE,\n		dbo.ORDERS_TANK_INV.SEQUENCE_NUMBER,\n		dbo.ORDE"
+"RS_TANK_INV.TERMINAL_PRODUCT_NUMBER,\n		dbo.ORDERS_TANK_INV.SUPPLIER_NUMBER,\n		dbo.ORDERS_TANK_INV.MANUALLY_ASSIGNED,\n		d"
+"bo.ORDERS_TANK_INV.PARCEL_CODE,\n		dbo.ORDERS_TANK_INV.INVENTORY_QTY,\n		dbo.ORDERS_TANK_INV.FRAC_INVENTORY_QTY,\n		dbo.ORD"
+"ERS_TANK_INV.INVENTORY_QUANTITY_TYPE,\n		dbo.ORDERS_TANK_INV.GROSS_QUANTITY,\n		dbo.ORDERS_TANK_INV.GROSS_FRAC_QUANTITY,\n	"
+"	dbo.ORDERS_TANK_INV.NET_QUANTITY,\n		dbo.ORDERS_TANK_INV.NET_FRAC_QUANTITY,\n		dbo.ORDERS_TANK_INV.WEIGHT,\n		dbo.ORDERS_T"
+"ANK_INV.FRAC_WEIGHT,\n		dbo.ORDERS_TANK_INV.WEIGHT_IN_VAC,\n		dbo.ORDERS_TANK_INV.FRAC_WEIGHT_IN_VAC\nFROM	dbo.ORDERS_TANK_"
+"INV";
		    

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
								row1.TANK_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(2);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(2).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.TANK_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.TANK_CODE = tmpContent_tDBInput_1;
                }
            } else {
                row1.TANK_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 3) {
								row1.SEQUENCE_NUMBER = 0;
							} else {
		                          
            row1.SEQUENCE_NUMBER = rs_tDBInput_1.getInt(3);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 4) {
								row1.TERMINAL_PRODUCT_NUMBER = 0;
							} else {
		                          
            row1.TERMINAL_PRODUCT_NUMBER = rs_tDBInput_1.getInt(4);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 5) {
								row1.SUPPLIER_NUMBER = 0;
							} else {
		                          
            row1.SUPPLIER_NUMBER = rs_tDBInput_1.getInt(5);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 6) {
								row1.MANUALLY_ASSIGNED = 0;
							} else {
		                          
            row1.MANUALLY_ASSIGNED = rs_tDBInput_1.getInt(6);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 7) {
								row1.PARCEL_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(7);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(7).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.PARCEL_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.PARCEL_CODE = tmpContent_tDBInput_1;
                }
            } else {
                row1.PARCEL_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 8) {
								row1.INVENTORY_QTY = 0;
							} else {
		                          
            row1.INVENTORY_QTY = rs_tDBInput_1.getInt(8);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 9) {
								row1.FRAC_INVENTORY_QTY = 0;
							} else {
		                          
            row1.FRAC_INVENTORY_QTY = rs_tDBInput_1.getInt(9);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 10) {
								row1.INVENTORY_QUANTITY_TYPE = 0;
							} else {
		                          
            row1.INVENTORY_QUANTITY_TYPE = rs_tDBInput_1.getInt(10);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 11) {
								row1.GROSS_QUANTITY = 0;
							} else {
		                          
            row1.GROSS_QUANTITY = rs_tDBInput_1.getInt(11);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 12) {
								row1.GROSS_FRAC_QUANTITY = 0;
							} else {
		                          
            row1.GROSS_FRAC_QUANTITY = rs_tDBInput_1.getInt(12);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 13) {
								row1.NET_QUANTITY = 0;
							} else {
		                          
            row1.NET_QUANTITY = rs_tDBInput_1.getInt(13);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 14) {
								row1.NET_FRAC_QUANTITY = 0;
							} else {
		                          
            row1.NET_FRAC_QUANTITY = rs_tDBInput_1.getInt(14);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 15) {
								row1.WEIGHT = 0;
							} else {
		                          
            row1.WEIGHT = rs_tDBInput_1.getInt(15);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 16) {
								row1.FRAC_WEIGHT = 0;
							} else {
		                          
            row1.FRAC_WEIGHT = rs_tDBInput_1.getInt(16);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 17) {
								row1.WEIGHT_IN_VAC = 0;
							} else {
		                          
            row1.WEIGHT_IN_VAC = rs_tDBInput_1.getInt(17);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 18) {
								row1.FRAC_WEIGHT_IN_VAC = 0;
							} else {
		                          
            row1.FRAC_WEIGHT_IN_VAC = rs_tDBInput_1.getInt(18);
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
if(row1.TANK_CODE == null){
	finder_tUniqRow_1.TANK_CODE = null;
}else{
	finder_tUniqRow_1.TANK_CODE = row1.TANK_CODE.toLowerCase();
}
finder_tUniqRow_1.SEQUENCE_NUMBER = row1.SEQUENCE_NUMBER;	
finder_tUniqRow_1.hashCodeDirty = true;
if (!keystUniqRow_1.contains(finder_tUniqRow_1)) {
		KeyStruct_tUniqRow_1 new_tUniqRow_1 = new KeyStruct_tUniqRow_1();

		
new_tUniqRow_1.ORDER_ID = row1.ORDER_ID;
if(row1.TANK_CODE == null){
	new_tUniqRow_1.TANK_CODE = null;
}else{
	new_tUniqRow_1.TANK_CODE = row1.TANK_CODE.toLowerCase();
}
new_tUniqRow_1.SEQUENCE_NUMBER = row1.SEQUENCE_NUMBER;
		
		keystUniqRow_1.add(new_tUniqRow_1);if(row2 == null){ 
	
	row2 = new row2Struct();
}row2.ORDER_ID = row1.ORDER_ID;			row2.TANK_CODE = row1.TANK_CODE;			row2.SEQUENCE_NUMBER = row1.SEQUENCE_NUMBER;			row2.TERMINAL_PRODUCT_NUMBER = row1.TERMINAL_PRODUCT_NUMBER;			row2.SUPPLIER_NUMBER = row1.SUPPLIER_NUMBER;			row2.MANUALLY_ASSIGNED = row1.MANUALLY_ASSIGNED;			row2.PARCEL_CODE = row1.PARCEL_CODE;			row2.INVENTORY_QTY = row1.INVENTORY_QTY;			row2.FRAC_INVENTORY_QTY = row1.FRAC_INVENTORY_QTY;			row2.INVENTORY_QUANTITY_TYPE = row1.INVENTORY_QUANTITY_TYPE;			row2.GROSS_QUANTITY = row1.GROSS_QUANTITY;			row2.GROSS_FRAC_QUANTITY = row1.GROSS_FRAC_QUANTITY;			row2.NET_QUANTITY = row1.NET_QUANTITY;			row2.NET_FRAC_QUANTITY = row1.NET_FRAC_QUANTITY;			row2.WEIGHT = row1.WEIGHT;			row2.FRAC_WEIGHT = row1.FRAC_WEIGHT;			row2.WEIGHT_IN_VAC = row1.WEIGHT_IN_VAC;			row2.FRAC_WEIGHT_IN_VAC = row1.FRAC_WEIGHT_IN_VAC;					
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
                        		    		
                        		    		    row3HashKey.TANK_CODE = row2.TANK_CODE ;
                        		    		
	                        		    	Object exprKeyValue_row3__SEQUENCE_NUMBER = row2.SEQUENCE_NUMBER ;
	                        		    	if(exprKeyValue_row3__SEQUENCE_NUMBER == null) {
	                        		    		hasCasePrimitiveKeyWithNull_tMap_1 = true;
	                        		    	} else {
                        		    			row3HashKey.SEQUENCE_NUMBER = (int)(Integer) exprKeyValue_row3__SEQUENCE_NUMBER;
                        		    		}
                        		    		

								
		                        	row3HashKey.hashCodeDirty = true;
                        		
	  					
	  							
	
		  							if(!hasCasePrimitiveKeyWithNull_tMap_1) { // G_TM_M_091
		  							
			  					
			  					
			  					
	  					
		  							tHash_Lookup_row3.lookup( row3HashKey );

	  							

	  							

			  						} // G_TM_M_091
			  						
			  					

 								
		  				
	  								
						
									
  									  		
 								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_row3 != null && tHash_Lookup_row3.getCount(row3HashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row3' and it contains more one result from keys :  row3.ORDER_ID = '" + row3HashKey.ORDER_ID + "', row3.TANK_CODE = '" + row3HashKey.TANK_CODE + "', row3.SEQUENCE_NUMBER = '" + row3HashKey.SEQUENCE_NUMBER + "'");
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
Var.PK_ORDERS_TANK_INV = Numeric.sequence("s4",1,1) ;// ###############################
        // ###############################
        // # Output tables

out1 = null;

boolean rejected_tMap_1 = true;
// ###### START REJECTS ##### 

// # Output reject table : 'out1'
// # Filter conditions 
if( rejected_tMap_1 ) {
out1_tmp.PK_ORDERS_TANK_INV = Var.PK_ORDERS_TANK_INV ;
out1_tmp.ORDER_ID = row2.ORDER_ID ;
out1_tmp.TANK_CODE = row2.TANK_CODE ;
out1_tmp.SEQUENCE_NUMBER = row2.SEQUENCE_NUMBER ;
out1_tmp.TERMINAL_PRODUCT_NUMBER = row2.TERMINAL_PRODUCT_NUMBER ;
out1_tmp.SUPPLIER_NUMBER = row2.SUPPLIER_NUMBER ;
out1_tmp.INVENTORY_QUANTITY_TYPE = row2.INVENTORY_QUANTITY_TYPE ;
out1_tmp.INVENTORY_QTY = row2.INVENTORY_QTY ;
out1_tmp.GROSS_QUANTITY = row2.GROSS_QUANTITY ;
out1_tmp.NET_QUANTITY = row2.NET_QUANTITY ;
out1_tmp.WEIGHT = row2.WEIGHT ;
out1_tmp.WEIGHT_IN_VAC = row2.WEIGHT_IN_VAC ;
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


                    pstmt_tDBOutput_1.setInt(1, out1.PK_ORDERS_TANK_INV);

            int checkCount_tDBOutput_1 = -1;
            try (java.sql.ResultSet rs_tDBOutput_1 = pstmt_tDBOutput_1.executeQuery()) {
                while(rs_tDBOutput_1.next()) {
                    checkCount_tDBOutput_1 = rs_tDBOutput_1.getInt(1);
                }
            }
            if(checkCount_tDBOutput_1 > 0) {
                        pstmtUpdate_tDBOutput_1.setInt(1, out1.ORDER_ID);

                        if(out1.TANK_CODE == null) {
pstmtUpdate_tDBOutput_1.setNull(2, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(2, out1.TANK_CODE);
}

                        pstmtUpdate_tDBOutput_1.setInt(3, out1.SEQUENCE_NUMBER);

                        pstmtUpdate_tDBOutput_1.setInt(4, out1.TERMINAL_PRODUCT_NUMBER);

                        pstmtUpdate_tDBOutput_1.setInt(5, out1.SUPPLIER_NUMBER);

                        pstmtUpdate_tDBOutput_1.setInt(6, out1.INVENTORY_QUANTITY_TYPE);

                        pstmtUpdate_tDBOutput_1.setInt(7, out1.INVENTORY_QTY);

                        pstmtUpdate_tDBOutput_1.setInt(8, out1.GROSS_QUANTITY);

                        pstmtUpdate_tDBOutput_1.setInt(9, out1.NET_QUANTITY);

                        pstmtUpdate_tDBOutput_1.setInt(10, out1.WEIGHT);

                        pstmtUpdate_tDBOutput_1.setInt(11, out1.WEIGHT_IN_VAC);


	                    

                        pstmtUpdate_tDBOutput_1.setInt(12 + count_tDBOutput_1, out1.PK_ORDERS_TANK_INV);

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
                        pstmtInsert_tDBOutput_1.setInt(1, out1.PK_ORDERS_TANK_INV);

                        pstmtInsert_tDBOutput_1.setInt(2, out1.ORDER_ID);

                        if(out1.TANK_CODE == null) {
pstmtInsert_tDBOutput_1.setNull(3, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(3, out1.TANK_CODE);
}

                        pstmtInsert_tDBOutput_1.setInt(4, out1.SEQUENCE_NUMBER);

                        pstmtInsert_tDBOutput_1.setInt(5, out1.TERMINAL_PRODUCT_NUMBER);

                        pstmtInsert_tDBOutput_1.setInt(6, out1.SUPPLIER_NUMBER);

                        pstmtInsert_tDBOutput_1.setInt(7, out1.INVENTORY_QUANTITY_TYPE);

                        pstmtInsert_tDBOutput_1.setInt(8, out1.INVENTORY_QTY);

                        pstmtInsert_tDBOutput_1.setInt(9, out1.GROSS_QUANTITY);

                        pstmtInsert_tDBOutput_1.setInt(10, out1.NET_QUANTITY);

                        pstmtInsert_tDBOutput_1.setInt(11, out1.WEIGHT);

                        pstmtInsert_tDBOutput_1.setInt(12, out1.WEIGHT_IN_VAC);

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
    final static byte[] commonByteArrayLock_PGS_STAGE_DIM_ORDERS_TANK_INV = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_DIM_ORDERS_TANK_INV = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public int PK_ORDERS_TANK_INV;

				public int getPK_ORDERS_TANK_INV () {
					return this.PK_ORDERS_TANK_INV;
				}
				
			    public int ORDER_ID;

				public int getORDER_ID () {
					return this.ORDER_ID;
				}
				
			    public String TANK_CODE;

				public String getTANK_CODE () {
					return this.TANK_CODE;
				}
				
			    public int SEQUENCE_NUMBER;

				public int getSEQUENCE_NUMBER () {
					return this.SEQUENCE_NUMBER;
				}
				
			    public int TERMINAL_PRODUCT_NUMBER;

				public int getTERMINAL_PRODUCT_NUMBER () {
					return this.TERMINAL_PRODUCT_NUMBER;
				}
				
			    public int SUPPLIER_NUMBER;

				public int getSUPPLIER_NUMBER () {
					return this.SUPPLIER_NUMBER;
				}
				
			    public int INVENTORY_QUANTITY_TYPE;

				public int getINVENTORY_QUANTITY_TYPE () {
					return this.INVENTORY_QUANTITY_TYPE;
				}
				
			    public int INVENTORY_QTY;

				public int getINVENTORY_QTY () {
					return this.INVENTORY_QTY;
				}
				
			    public int GROSS_QUANTITY;

				public int getGROSS_QUANTITY () {
					return this.GROSS_QUANTITY;
				}
				
			    public int NET_QUANTITY;

				public int getNET_QUANTITY () {
					return this.NET_QUANTITY;
				}
				
			    public int WEIGHT;

				public int getWEIGHT () {
					return this.WEIGHT;
				}
				
			    public int WEIGHT_IN_VAC;

				public int getWEIGHT_IN_VAC () {
					return this.WEIGHT_IN_VAC;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
							result = prime * result + (int) this.ORDER_ID;
						
						result = prime * result + ((this.TANK_CODE == null) ? 0 : this.TANK_CODE.hashCode());
					
							result = prime * result + (int) this.SEQUENCE_NUMBER;
						
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
					
						if (this.TANK_CODE == null) {
							if (other.TANK_CODE != null)
								return false;
						
						} else if (!this.TANK_CODE.equals(other.TANK_CODE))
						
							return false;
					
						if (this.SEQUENCE_NUMBER != other.SEQUENCE_NUMBER)
							return false;
					

		return true;
    }

	public void copyDataTo(row3Struct other) {

		other.PK_ORDERS_TANK_INV = this.PK_ORDERS_TANK_INV;
	            other.ORDER_ID = this.ORDER_ID;
	            other.TANK_CODE = this.TANK_CODE;
	            other.SEQUENCE_NUMBER = this.SEQUENCE_NUMBER;
	            other.TERMINAL_PRODUCT_NUMBER = this.TERMINAL_PRODUCT_NUMBER;
	            other.SUPPLIER_NUMBER = this.SUPPLIER_NUMBER;
	            other.INVENTORY_QUANTITY_TYPE = this.INVENTORY_QUANTITY_TYPE;
	            other.INVENTORY_QTY = this.INVENTORY_QTY;
	            other.GROSS_QUANTITY = this.GROSS_QUANTITY;
	            other.NET_QUANTITY = this.NET_QUANTITY;
	            other.WEIGHT = this.WEIGHT;
	            other.WEIGHT_IN_VAC = this.WEIGHT_IN_VAC;
	            
	}

	public void copyKeysDataTo(row3Struct other) {

		other.ORDER_ID = this.ORDER_ID;
	            	other.TANK_CODE = this.TANK_CODE;
	            	other.SEQUENCE_NUMBER = this.SEQUENCE_NUMBER;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PGS_STAGE_DIM_ORDERS_TANK_INV.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_ORDERS_TANK_INV.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_ORDERS_TANK_INV = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_ORDERS_TANK_INV = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PGS_STAGE_DIM_ORDERS_TANK_INV, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_ORDERS_TANK_INV, 0, length, utf8Charset);
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
			if(length > commonByteArray_PGS_STAGE_DIM_ORDERS_TANK_INV.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_ORDERS_TANK_INV.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_ORDERS_TANK_INV = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_ORDERS_TANK_INV = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PGS_STAGE_DIM_ORDERS_TANK_INV, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_ORDERS_TANK_INV, 0, length, utf8Charset);
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

    public void readKeysData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_ORDERS_TANK_INV) {

        	try {

        		int length = 0;
		
			        this.ORDER_ID = dis.readInt();
					
					this.TANK_CODE = readString(dis);
					
			        this.SEQUENCE_NUMBER = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_ORDERS_TANK_INV) {

        	try {

        		int length = 0;
		
			        this.ORDER_ID = dis.readInt();
					
					this.TANK_CODE = readString(dis);
					
			        this.SEQUENCE_NUMBER = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.ORDER_ID);
					
					// String
				
						writeString(this.TANK_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.SEQUENCE_NUMBER);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.ORDER_ID);
					
					// String
				
						writeString(this.TANK_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.SEQUENCE_NUMBER);
					
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
		
			            this.PK_ORDERS_TANK_INV = dis.readInt();
					
			            this.TERMINAL_PRODUCT_NUMBER = dis.readInt();
					
			            this.SUPPLIER_NUMBER = dis.readInt();
					
			            this.INVENTORY_QUANTITY_TYPE = dis.readInt();
					
			            this.INVENTORY_QTY = dis.readInt();
					
			            this.GROSS_QUANTITY = dis.readInt();
					
			            this.NET_QUANTITY = dis.readInt();
					
			            this.WEIGHT = dis.readInt();
					
			            this.WEIGHT_IN_VAC = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
			            this.PK_ORDERS_TANK_INV = objectIn.readInt();
					
			            this.TERMINAL_PRODUCT_NUMBER = objectIn.readInt();
					
			            this.SUPPLIER_NUMBER = objectIn.readInt();
					
			            this.INVENTORY_QUANTITY_TYPE = objectIn.readInt();
					
			            this.INVENTORY_QTY = objectIn.readInt();
					
			            this.GROSS_QUANTITY = objectIn.readInt();
					
			            this.NET_QUANTITY = objectIn.readInt();
					
			            this.WEIGHT = objectIn.readInt();
					
			            this.WEIGHT_IN_VAC = objectIn.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
		            	dos.writeInt(this.PK_ORDERS_TANK_INV);
					
		            	dos.writeInt(this.TERMINAL_PRODUCT_NUMBER);
					
		            	dos.writeInt(this.SUPPLIER_NUMBER);
					
		            	dos.writeInt(this.INVENTORY_QUANTITY_TYPE);
					
		            	dos.writeInt(this.INVENTORY_QTY);
					
		            	dos.writeInt(this.GROSS_QUANTITY);
					
		            	dos.writeInt(this.NET_QUANTITY);
					
		            	dos.writeInt(this.WEIGHT);
					
		            	dos.writeInt(this.WEIGHT_IN_VAC);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
					objectOut.writeInt(this.PK_ORDERS_TANK_INV);
					
					objectOut.writeInt(this.TERMINAL_PRODUCT_NUMBER);
					
					objectOut.writeInt(this.SUPPLIER_NUMBER);
					
					objectOut.writeInt(this.INVENTORY_QUANTITY_TYPE);
					
					objectOut.writeInt(this.INVENTORY_QTY);
					
					objectOut.writeInt(this.GROSS_QUANTITY);
					
					objectOut.writeInt(this.NET_QUANTITY);
					
					objectOut.writeInt(this.WEIGHT);
					
					objectOut.writeInt(this.WEIGHT_IN_VAC);
					
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
		sb.append("PK_ORDERS_TANK_INV="+String.valueOf(PK_ORDERS_TANK_INV));
		sb.append(",ORDER_ID="+String.valueOf(ORDER_ID));
		sb.append(",TANK_CODE="+TANK_CODE);
		sb.append(",SEQUENCE_NUMBER="+String.valueOf(SEQUENCE_NUMBER));
		sb.append(",TERMINAL_PRODUCT_NUMBER="+String.valueOf(TERMINAL_PRODUCT_NUMBER));
		sb.append(",SUPPLIER_NUMBER="+String.valueOf(SUPPLIER_NUMBER));
		sb.append(",INVENTORY_QUANTITY_TYPE="+String.valueOf(INVENTORY_QUANTITY_TYPE));
		sb.append(",INVENTORY_QTY="+String.valueOf(INVENTORY_QTY));
		sb.append(",GROSS_QUANTITY="+String.valueOf(GROSS_QUANTITY));
		sb.append(",NET_QUANTITY="+String.valueOf(NET_QUANTITY));
		sb.append(",WEIGHT="+String.valueOf(WEIGHT));
		sb.append(",WEIGHT_IN_VAC="+String.valueOf(WEIGHT_IN_VAC));
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

					
						returnValue = checkNullsAndCompare(this.TANK_CODE, other.TANK_CODE);
						if(returnValue != 0) {
							return returnValue;
						}

					
						returnValue = checkNullsAndCompare(this.SEQUENCE_NUMBER, other.SEQUENCE_NUMBER);
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
				
				 
	final String decryptedPassword_tDBInput_2 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:JYnD04WV9Rgw9Ywtp4VtQjZhGUW5VsmvGQx/qchXeOQ3/MMSbAQ=");
				
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

		    String dbquery_tDBInput_2 = "SELECT dbo.DIM_ORDERS_TANK_INV.PK_ORDERS_TANK_INV,\n		dbo.DIM_ORDERS_TANK_INV.ORDER_ID,\n		dbo.DIM_ORDERS_TANK_INV.TANK_C"
+"ODE,\n		dbo.DIM_ORDERS_TANK_INV.SEQUENCE_NUMBER,\n		dbo.DIM_ORDERS_TANK_INV.TERMINAL_PRODUCT_NUMBER,\n		dbo.DIM_ORDERS_TANK"
+"_INV.SUPPLIER_NUMBER,\n		dbo.DIM_ORDERS_TANK_INV.INVENTORY_QUANTITY_TYPE,\n		dbo.DIM_ORDERS_TANK_INV.INVENTORY_QTY,\n		dbo."
+"DIM_ORDERS_TANK_INV.GROSS_QUANTITY,\n		dbo.DIM_ORDERS_TANK_INV.NET_QUANTITY,\n		dbo.DIM_ORDERS_TANK_INV.WEIGHT,\n		dbo.DIM_"
+"ORDERS_TANK_INV.WEIGHT_IN_VAC\nFROM	dbo.DIM_ORDERS_TANK_INV";
		    

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
								row3.PK_ORDERS_TANK_INV = 0;
							} else {
		                          
            row3.PK_ORDERS_TANK_INV = rs_tDBInput_2.getInt(1);
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
								row3.TANK_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(3);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(3).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.TANK_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row3.TANK_CODE = tmpContent_tDBInput_2;
                }
            } else {
                row3.TANK_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 4) {
								row3.SEQUENCE_NUMBER = 0;
							} else {
		                          
            row3.SEQUENCE_NUMBER = rs_tDBInput_2.getInt(4);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 5) {
								row3.TERMINAL_PRODUCT_NUMBER = 0;
							} else {
		                          
            row3.TERMINAL_PRODUCT_NUMBER = rs_tDBInput_2.getInt(5);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 6) {
								row3.SUPPLIER_NUMBER = 0;
							} else {
		                          
            row3.SUPPLIER_NUMBER = rs_tDBInput_2.getInt(6);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 7) {
								row3.INVENTORY_QUANTITY_TYPE = 0;
							} else {
		                          
            row3.INVENTORY_QUANTITY_TYPE = rs_tDBInput_2.getInt(7);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 8) {
								row3.INVENTORY_QTY = 0;
							} else {
		                          
            row3.INVENTORY_QTY = rs_tDBInput_2.getInt(8);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 9) {
								row3.GROSS_QUANTITY = 0;
							} else {
		                          
            row3.GROSS_QUANTITY = rs_tDBInput_2.getInt(9);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 10) {
								row3.NET_QUANTITY = 0;
							} else {
		                          
            row3.NET_QUANTITY = rs_tDBInput_2.getInt(10);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 11) {
								row3.WEIGHT = 0;
							} else {
		                          
            row3.WEIGHT = rs_tDBInput_2.getInt(11);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 12) {
								row3.WEIGHT_IN_VAC = 0;
							} else {
		                          
            row3.WEIGHT_IN_VAC = rs_tDBInput_2.getInt(12);
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
		   	   	   
				
				row3_HashRow.PK_ORDERS_TANK_INV = row3.PK_ORDERS_TANK_INV;
				
				row3_HashRow.ORDER_ID = row3.ORDER_ID;
				
				row3_HashRow.TANK_CODE = row3.TANK_CODE;
				
				row3_HashRow.SEQUENCE_NUMBER = row3.SEQUENCE_NUMBER;
				
				row3_HashRow.TERMINAL_PRODUCT_NUMBER = row3.TERMINAL_PRODUCT_NUMBER;
				
				row3_HashRow.SUPPLIER_NUMBER = row3.SUPPLIER_NUMBER;
				
				row3_HashRow.INVENTORY_QUANTITY_TYPE = row3.INVENTORY_QUANTITY_TYPE;
				
				row3_HashRow.INVENTORY_QTY = row3.INVENTORY_QTY;
				
				row3_HashRow.GROSS_QUANTITY = row3.GROSS_QUANTITY;
				
				row3_HashRow.NET_QUANTITY = row3.NET_QUANTITY;
				
				row3_HashRow.WEIGHT = row3.WEIGHT;
				
				row3_HashRow.WEIGHT_IN_VAC = row3.WEIGHT_IN_VAC;
				
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
        final DIM_ORDERS_TANK_INV DIM_ORDERS_TANK_INVClass = new DIM_ORDERS_TANK_INV();

        int exitCode = DIM_ORDERS_TANK_INVClass.runJobInTOS(args);

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
            java.io.InputStream inContext = DIM_ORDERS_TANK_INV.class.getClassLoader().getResourceAsStream("pgs_stage/dim_orders_tank_inv_0_1/contexts/" + contextStr + ".properties");
            if (inContext == null) {
                inContext = DIM_ORDERS_TANK_INV.class.getClassLoader().getResourceAsStream("config/contexts/" + contextStr + ".properties");
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
            System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : DIM_ORDERS_TANK_INV");
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
 *     146950 characters generated by Talend Open Studio for Data Integration 
 *     on the 3 août 2024 à 14:42:24 GMT+01:00
 ************************************************************************************************/