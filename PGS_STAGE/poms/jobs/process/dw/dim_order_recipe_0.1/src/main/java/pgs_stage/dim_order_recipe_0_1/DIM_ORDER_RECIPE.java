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


package pgs_stage.dim_order_recipe_0_1;

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
 * Job: DIM_ORDER_RECIPE Purpose: <br>
 * Description:  <br>
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status 
 */
public class DIM_ORDER_RECIPE implements TalendJob {

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
	private final String jobName = "DIM_ORDER_RECIPE";
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
				DIM_ORDER_RECIPE.this.exception = e;
			}
		}
		if (!(e instanceof TalendException)) {
		try {
			for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
				if (m.getName().compareTo(currentComponent + "_error") == 0) {
					m.invoke(DIM_ORDER_RECIPE.this, new Object[] { e , currentComponent, globalMap});
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
    final static byte[] commonByteArrayLock_PGS_STAGE_DIM_ORDER_RECIPE = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_DIM_ORDER_RECIPE = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public int PK_ORDER_RECIPE;

				public int getPK_ORDER_RECIPE () {
					return this.PK_ORDER_RECIPE;
				}
				
			    public int ORDER_ID;

				public int getORDER_ID () {
					return this.ORDER_ID;
				}
				
			    public int COMPARTMENT_ID;

				public int getCOMPARTMENT_ID () {
					return this.COMPARTMENT_ID;
				}
				
			    public int ORDER_RECIPE_ID;

				public int getORDER_RECIPE_ID () {
					return this.ORDER_RECIPE_ID;
				}
				
			    public String BAY_CODE;

				public String getBAY_CODE () {
					return this.BAY_CODE;
				}
				
			    public String API_CODE;

				public String getAPI_CODE () {
					return this.API_CODE;
				}
				
			    public String TANK_CODE;

				public String getTANK_CODE () {
					return this.TANK_CODE;
				}
				
			    public String PRODUCT_GROUP_CODE;

				public String getPRODUCT_GROUP_CODE () {
					return this.PRODUCT_GROUP_CODE;
				}
				
			    public String METER_CODE;

				public String getMETER_CODE () {
					return this.METER_CODE;
				}
				
			    public Integer SUPPLIER_NUMBER;

				public Integer getSUPPLIER_NUMBER () {
					return this.SUPPLIER_NUMBER;
				}
				
			    public int TERMINAL_PRODUCT_NUMBER;

				public int getTERMINAL_PRODUCT_NUMBER () {
					return this.TERMINAL_PRODUCT_NUMBER;
				}
				
			    public java.util.Date START_TIME;

				public java.util.Date getSTART_TIME () {
					return this.START_TIME;
				}
				
			    public java.util.Date END_TIME;

				public java.util.Date getEND_TIME () {
					return this.END_TIME;
				}
				
			    public int COMPONENT_ID;

				public int getCOMPONENT_ID () {
					return this.COMPONENT_ID;
				}
				
			    public int PRODUCT_TOLERANCE_STATUS;

				public int getPRODUCT_TOLERANCE_STATUS () {
					return this.PRODUCT_TOLERANCE_STATUS;
				}
				
			    public int TOTALIZER_UPDATED;

				public int getTOTALIZER_UPDATED () {
					return this.TOTALIZER_UPDATED;
				}
				
			    public int BATCH_NUMBER;

				public int getBATCH_NUMBER () {
					return this.BATCH_NUMBER;
				}
				
			    public int RECIPE_CORRECTION_TYPE;

				public int getRECIPE_CORRECTION_TYPE () {
					return this.RECIPE_CORRECTION_TYPE;
				}
				
			    public int INVENTORY_QUANTITY_TYPE;

				public int getINVENTORY_QUANTITY_TYPE () {
					return this.INVENTORY_QUANTITY_TYPE;
				}
				
			    public int DERIVED_VALUES_DIRECTIVE;

				public int getDERIVED_VALUES_DIRECTIVE () {
					return this.DERIVED_VALUES_DIRECTIVE;
				}
				
			    public String METER_PRESET_CODE;

				public String getMETER_PRESET_CODE () {
					return this.METER_PRESET_CODE;
				}
				
			    public int CALCULATE_NET;

				public int getCALCULATE_NET () {
					return this.CALCULATE_NET;
				}
				
			    public Integer COMPARTMENT_OWNER_ID;

				public Integer getCOMPARTMENT_OWNER_ID () {
					return this.COMPARTMENT_OWNER_ID;
				}
				
			    public String COMPARTMENT_CONTAINER_CODE;

				public String getCOMPARTMENT_CONTAINER_CODE () {
					return this.COMPARTMENT_CONTAINER_CODE;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
							result = prime * result + (int) this.PK_ORDER_RECIPE;
						
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
		
						if (this.PK_ORDER_RECIPE != other.PK_ORDER_RECIPE)
							return false;
					

		return true;
    }

	public void copyDataTo(out1Struct other) {

		other.PK_ORDER_RECIPE = this.PK_ORDER_RECIPE;
	            other.ORDER_ID = this.ORDER_ID;
	            other.COMPARTMENT_ID = this.COMPARTMENT_ID;
	            other.ORDER_RECIPE_ID = this.ORDER_RECIPE_ID;
	            other.BAY_CODE = this.BAY_CODE;
	            other.API_CODE = this.API_CODE;
	            other.TANK_CODE = this.TANK_CODE;
	            other.PRODUCT_GROUP_CODE = this.PRODUCT_GROUP_CODE;
	            other.METER_CODE = this.METER_CODE;
	            other.SUPPLIER_NUMBER = this.SUPPLIER_NUMBER;
	            other.TERMINAL_PRODUCT_NUMBER = this.TERMINAL_PRODUCT_NUMBER;
	            other.START_TIME = this.START_TIME;
	            other.END_TIME = this.END_TIME;
	            other.COMPONENT_ID = this.COMPONENT_ID;
	            other.PRODUCT_TOLERANCE_STATUS = this.PRODUCT_TOLERANCE_STATUS;
	            other.TOTALIZER_UPDATED = this.TOTALIZER_UPDATED;
	            other.BATCH_NUMBER = this.BATCH_NUMBER;
	            other.RECIPE_CORRECTION_TYPE = this.RECIPE_CORRECTION_TYPE;
	            other.INVENTORY_QUANTITY_TYPE = this.INVENTORY_QUANTITY_TYPE;
	            other.DERIVED_VALUES_DIRECTIVE = this.DERIVED_VALUES_DIRECTIVE;
	            other.METER_PRESET_CODE = this.METER_PRESET_CODE;
	            other.CALCULATE_NET = this.CALCULATE_NET;
	            other.COMPARTMENT_OWNER_ID = this.COMPARTMENT_OWNER_ID;
	            other.COMPARTMENT_CONTAINER_CODE = this.COMPARTMENT_CONTAINER_CODE;
	            
	}

	public void copyKeysDataTo(out1Struct other) {

		other.PK_ORDER_RECIPE = this.PK_ORDER_RECIPE;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PGS_STAGE_DIM_ORDER_RECIPE.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_ORDER_RECIPE.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_ORDER_RECIPE = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_ORDER_RECIPE = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PGS_STAGE_DIM_ORDER_RECIPE, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_ORDER_RECIPE, 0, length, utf8Charset);
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
			if(length > commonByteArray_PGS_STAGE_DIM_ORDER_RECIPE.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_ORDER_RECIPE.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_ORDER_RECIPE = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_ORDER_RECIPE = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PGS_STAGE_DIM_ORDER_RECIPE, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_ORDER_RECIPE, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_ORDER_RECIPE) {

        	try {

        		int length = 0;
		
			        this.PK_ORDER_RECIPE = dis.readInt();
					
			        this.ORDER_ID = dis.readInt();
					
			        this.COMPARTMENT_ID = dis.readInt();
					
			        this.ORDER_RECIPE_ID = dis.readInt();
					
					this.BAY_CODE = readString(dis);
					
					this.API_CODE = readString(dis);
					
					this.TANK_CODE = readString(dis);
					
					this.PRODUCT_GROUP_CODE = readString(dis);
					
					this.METER_CODE = readString(dis);
					
						this.SUPPLIER_NUMBER = readInteger(dis);
					
			        this.TERMINAL_PRODUCT_NUMBER = dis.readInt();
					
					this.START_TIME = readDate(dis);
					
					this.END_TIME = readDate(dis);
					
			        this.COMPONENT_ID = dis.readInt();
					
			        this.PRODUCT_TOLERANCE_STATUS = dis.readInt();
					
			        this.TOTALIZER_UPDATED = dis.readInt();
					
			        this.BATCH_NUMBER = dis.readInt();
					
			        this.RECIPE_CORRECTION_TYPE = dis.readInt();
					
			        this.INVENTORY_QUANTITY_TYPE = dis.readInt();
					
			        this.DERIVED_VALUES_DIRECTIVE = dis.readInt();
					
					this.METER_PRESET_CODE = readString(dis);
					
			        this.CALCULATE_NET = dis.readInt();
					
						this.COMPARTMENT_OWNER_ID = readInteger(dis);
					
					this.COMPARTMENT_CONTAINER_CODE = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_ORDER_RECIPE) {

        	try {

        		int length = 0;
		
			        this.PK_ORDER_RECIPE = dis.readInt();
					
			        this.ORDER_ID = dis.readInt();
					
			        this.COMPARTMENT_ID = dis.readInt();
					
			        this.ORDER_RECIPE_ID = dis.readInt();
					
					this.BAY_CODE = readString(dis);
					
					this.API_CODE = readString(dis);
					
					this.TANK_CODE = readString(dis);
					
					this.PRODUCT_GROUP_CODE = readString(dis);
					
					this.METER_CODE = readString(dis);
					
						this.SUPPLIER_NUMBER = readInteger(dis);
					
			        this.TERMINAL_PRODUCT_NUMBER = dis.readInt();
					
					this.START_TIME = readDate(dis);
					
					this.END_TIME = readDate(dis);
					
			        this.COMPONENT_ID = dis.readInt();
					
			        this.PRODUCT_TOLERANCE_STATUS = dis.readInt();
					
			        this.TOTALIZER_UPDATED = dis.readInt();
					
			        this.BATCH_NUMBER = dis.readInt();
					
			        this.RECIPE_CORRECTION_TYPE = dis.readInt();
					
			        this.INVENTORY_QUANTITY_TYPE = dis.readInt();
					
			        this.DERIVED_VALUES_DIRECTIVE = dis.readInt();
					
					this.METER_PRESET_CODE = readString(dis);
					
			        this.CALCULATE_NET = dis.readInt();
					
						this.COMPARTMENT_OWNER_ID = readInteger(dis);
					
					this.COMPARTMENT_CONTAINER_CODE = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.PK_ORDER_RECIPE);
					
					// int
				
		            	dos.writeInt(this.ORDER_ID);
					
					// int
				
		            	dos.writeInt(this.COMPARTMENT_ID);
					
					// int
				
		            	dos.writeInt(this.ORDER_RECIPE_ID);
					
					// String
				
						writeString(this.BAY_CODE,dos);
					
					// String
				
						writeString(this.API_CODE,dos);
					
					// String
				
						writeString(this.TANK_CODE,dos);
					
					// String
				
						writeString(this.PRODUCT_GROUP_CODE,dos);
					
					// String
				
						writeString(this.METER_CODE,dos);
					
					// Integer
				
						writeInteger(this.SUPPLIER_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.TERMINAL_PRODUCT_NUMBER);
					
					// java.util.Date
				
						writeDate(this.START_TIME,dos);
					
					// java.util.Date
				
						writeDate(this.END_TIME,dos);
					
					// int
				
		            	dos.writeInt(this.COMPONENT_ID);
					
					// int
				
		            	dos.writeInt(this.PRODUCT_TOLERANCE_STATUS);
					
					// int
				
		            	dos.writeInt(this.TOTALIZER_UPDATED);
					
					// int
				
		            	dos.writeInt(this.BATCH_NUMBER);
					
					// int
				
		            	dos.writeInt(this.RECIPE_CORRECTION_TYPE);
					
					// int
				
		            	dos.writeInt(this.INVENTORY_QUANTITY_TYPE);
					
					// int
				
		            	dos.writeInt(this.DERIVED_VALUES_DIRECTIVE);
					
					// String
				
						writeString(this.METER_PRESET_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.CALCULATE_NET);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_OWNER_ID,dos);
					
					// String
				
						writeString(this.COMPARTMENT_CONTAINER_CODE,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.PK_ORDER_RECIPE);
					
					// int
				
		            	dos.writeInt(this.ORDER_ID);
					
					// int
				
		            	dos.writeInt(this.COMPARTMENT_ID);
					
					// int
				
		            	dos.writeInt(this.ORDER_RECIPE_ID);
					
					// String
				
						writeString(this.BAY_CODE,dos);
					
					// String
				
						writeString(this.API_CODE,dos);
					
					// String
				
						writeString(this.TANK_CODE,dos);
					
					// String
				
						writeString(this.PRODUCT_GROUP_CODE,dos);
					
					// String
				
						writeString(this.METER_CODE,dos);
					
					// Integer
				
						writeInteger(this.SUPPLIER_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.TERMINAL_PRODUCT_NUMBER);
					
					// java.util.Date
				
						writeDate(this.START_TIME,dos);
					
					// java.util.Date
				
						writeDate(this.END_TIME,dos);
					
					// int
				
		            	dos.writeInt(this.COMPONENT_ID);
					
					// int
				
		            	dos.writeInt(this.PRODUCT_TOLERANCE_STATUS);
					
					// int
				
		            	dos.writeInt(this.TOTALIZER_UPDATED);
					
					// int
				
		            	dos.writeInt(this.BATCH_NUMBER);
					
					// int
				
		            	dos.writeInt(this.RECIPE_CORRECTION_TYPE);
					
					// int
				
		            	dos.writeInt(this.INVENTORY_QUANTITY_TYPE);
					
					// int
				
		            	dos.writeInt(this.DERIVED_VALUES_DIRECTIVE);
					
					// String
				
						writeString(this.METER_PRESET_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.CALCULATE_NET);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_OWNER_ID,dos);
					
					// String
				
						writeString(this.COMPARTMENT_CONTAINER_CODE,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("PK_ORDER_RECIPE="+String.valueOf(PK_ORDER_RECIPE));
		sb.append(",ORDER_ID="+String.valueOf(ORDER_ID));
		sb.append(",COMPARTMENT_ID="+String.valueOf(COMPARTMENT_ID));
		sb.append(",ORDER_RECIPE_ID="+String.valueOf(ORDER_RECIPE_ID));
		sb.append(",BAY_CODE="+BAY_CODE);
		sb.append(",API_CODE="+API_CODE);
		sb.append(",TANK_CODE="+TANK_CODE);
		sb.append(",PRODUCT_GROUP_CODE="+PRODUCT_GROUP_CODE);
		sb.append(",METER_CODE="+METER_CODE);
		sb.append(",SUPPLIER_NUMBER="+String.valueOf(SUPPLIER_NUMBER));
		sb.append(",TERMINAL_PRODUCT_NUMBER="+String.valueOf(TERMINAL_PRODUCT_NUMBER));
		sb.append(",START_TIME="+String.valueOf(START_TIME));
		sb.append(",END_TIME="+String.valueOf(END_TIME));
		sb.append(",COMPONENT_ID="+String.valueOf(COMPONENT_ID));
		sb.append(",PRODUCT_TOLERANCE_STATUS="+String.valueOf(PRODUCT_TOLERANCE_STATUS));
		sb.append(",TOTALIZER_UPDATED="+String.valueOf(TOTALIZER_UPDATED));
		sb.append(",BATCH_NUMBER="+String.valueOf(BATCH_NUMBER));
		sb.append(",RECIPE_CORRECTION_TYPE="+String.valueOf(RECIPE_CORRECTION_TYPE));
		sb.append(",INVENTORY_QUANTITY_TYPE="+String.valueOf(INVENTORY_QUANTITY_TYPE));
		sb.append(",DERIVED_VALUES_DIRECTIVE="+String.valueOf(DERIVED_VALUES_DIRECTIVE));
		sb.append(",METER_PRESET_CODE="+METER_PRESET_CODE);
		sb.append(",CALCULATE_NET="+String.valueOf(CALCULATE_NET));
		sb.append(",COMPARTMENT_OWNER_ID="+String.valueOf(COMPARTMENT_OWNER_ID));
		sb.append(",COMPARTMENT_CONTAINER_CODE="+COMPARTMENT_CONTAINER_CODE);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(out1Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.PK_ORDER_RECIPE, other.PK_ORDER_RECIPE);
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
    final static byte[] commonByteArrayLock_PGS_STAGE_DIM_ORDER_RECIPE = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_DIM_ORDER_RECIPE = new byte[0];

	
			    public int ORDER_ID;

				public int getORDER_ID () {
					return this.ORDER_ID;
				}
				
			    public int COMPARTMENT_ID;

				public int getCOMPARTMENT_ID () {
					return this.COMPARTMENT_ID;
				}
				
			    public int ORDER_RECIPE_ID;

				public int getORDER_RECIPE_ID () {
					return this.ORDER_RECIPE_ID;
				}
				
			    public String BAY_CODE;

				public String getBAY_CODE () {
					return this.BAY_CODE;
				}
				
			    public String API_CODE;

				public String getAPI_CODE () {
					return this.API_CODE;
				}
				
			    public String INJECTOR_PRESET_CODE;

				public String getINJECTOR_PRESET_CODE () {
					return this.INJECTOR_PRESET_CODE;
				}
				
			    public String TARE_SCALE_INTERFACE_CODE;

				public String getTARE_SCALE_INTERFACE_CODE () {
					return this.TARE_SCALE_INTERFACE_CODE;
				}
				
			    public String TANK_CODE;

				public String getTANK_CODE () {
					return this.TANK_CODE;
				}
				
			    public String PRODUCT_GROUP_CODE;

				public String getPRODUCT_GROUP_CODE () {
					return this.PRODUCT_GROUP_CODE;
				}
				
			    public String INJECTOR_CODE;

				public String getINJECTOR_CODE () {
					return this.INJECTOR_CODE;
				}
				
			    public String METER_CODE;

				public String getMETER_CODE () {
					return this.METER_CODE;
				}
				
			    public Integer SUPPLIER_NUMBER;

				public Integer getSUPPLIER_NUMBER () {
					return this.SUPPLIER_NUMBER;
				}
				
			    public int TERMINAL_PRODUCT_NUMBER;

				public int getTERMINAL_PRODUCT_NUMBER () {
					return this.TERMINAL_PRODUCT_NUMBER;
				}
				
			    public int TERMINAL_PRODUCT_TYPE;

				public int getTERMINAL_PRODUCT_TYPE () {
					return this.TERMINAL_PRODUCT_TYPE;
				}
				
			    public String SHOST_SI_HOST_PRODUCT_NUMBER;

				public String getSHOST_SI_HOST_PRODUCT_NUMBER () {
					return this.SHOST_SI_HOST_PRODUCT_NUMBER;
				}
				
			    public double BLEND_PERCENT;

				public double getBLEND_PERCENT () {
					return this.BLEND_PERCENT;
				}
				
			    public int RATE;

				public int getRATE () {
					return this.RATE;
				}
				
			    public String THOST_TI_HOST_PRODUCT_NUMBER;

				public String getTHOST_TI_HOST_PRODUCT_NUMBER () {
					return this.THOST_TI_HOST_PRODUCT_NUMBER;
				}
				
			    public int ORDERED_QUANTITY;

				public int getORDERED_QUANTITY () {
					return this.ORDERED_QUANTITY;
				}
				
			    public int OVERRIDE_TEMPERATURE_ENABLE;

				public int getOVERRIDE_TEMPERATURE_ENABLE () {
					return this.OVERRIDE_TEMPERATURE_ENABLE;
				}
				
			    public int GROSS_QUANTITY;

				public int getGROSS_QUANTITY () {
					return this.GROSS_QUANTITY;
				}
				
			    public int WEIGHT;

				public int getWEIGHT () {
					return this.WEIGHT;
				}
				
			    public int NET_QUANTITY;

				public int getNET_QUANTITY () {
					return this.NET_QUANTITY;
				}
				
			    public double DENSITY;

				public double getDENSITY () {
					return this.DENSITY;
				}
				
			    public int CUSTOMER_NET_QUANTITY;

				public int getCUSTOMER_NET_QUANTITY () {
					return this.CUSTOMER_NET_QUANTITY;
				}
				
			    public double SPECIFIC_GRAVITY;

				public double getSPECIFIC_GRAVITY () {
					return this.SPECIFIC_GRAVITY;
				}
				
			    public double COEFFICIENT_EXPANSION;

				public double getCOEFFICIENT_EXPANSION () {
					return this.COEFFICIENT_EXPANSION;
				}
				
			    public double TEMPERATURE;

				public double getTEMPERATURE () {
					return this.TEMPERATURE;
				}
				
			    public double RVP;

				public double getRVP () {
					return this.RVP;
				}
				
			    public double OXYGEN;

				public double getOXYGEN () {
					return this.OXYGEN;
				}
				
			    public int START_GROSS_TOTALIZER;

				public int getSTART_GROSS_TOTALIZER () {
					return this.START_GROSS_TOTALIZER;
				}
				
			    public int END_GROSS_TOTALIZER;

				public int getEND_GROSS_TOTALIZER () {
					return this.END_GROSS_TOTALIZER;
				}
				
			    public int START_NET_TOTALIZER;

				public int getSTART_NET_TOTALIZER () {
					return this.START_NET_TOTALIZER;
				}
				
			    public int END_NET_TOTALIZER;

				public int getEND_NET_TOTALIZER () {
					return this.END_NET_TOTALIZER;
				}
				
			    public int START_WEIGHT;

				public int getSTART_WEIGHT () {
					return this.START_WEIGHT;
				}
				
			    public int END_WEIGHT;

				public int getEND_WEIGHT () {
					return this.END_WEIGHT;
				}
				
			    public String LAST_USER_NAME;

				public String getLAST_USER_NAME () {
					return this.LAST_USER_NAME;
				}
				
			    public java.util.Date LAST_MODIFIED;

				public java.util.Date getLAST_MODIFIED () {
					return this.LAST_MODIFIED;
				}
				
			    public java.util.Date START_TIME;

				public java.util.Date getSTART_TIME () {
					return this.START_TIME;
				}
				
			    public java.util.Date END_TIME;

				public java.util.Date getEND_TIME () {
					return this.END_TIME;
				}
				
			    public int ADDITIVE_QUANTITY;

				public int getADDITIVE_QUANTITY () {
					return this.ADDITIVE_QUANTITY;
				}
				
			    public int PRODUCT_QUANTITY;

				public int getPRODUCT_QUANTITY () {
					return this.PRODUCT_QUANTITY;
				}
				
			    public String HOST_PRODUCT_CODE;

				public String getHOST_PRODUCT_CODE () {
					return this.HOST_PRODUCT_CODE;
				}
				
			    public String HOST_PRODUCT_NAME;

				public String getHOST_PRODUCT_NAME () {
					return this.HOST_PRODUCT_NAME;
				}
				
			    public int FROM_LEFT_ON_TRUCK;

				public int getFROM_LEFT_ON_TRUCK () {
					return this.FROM_LEFT_ON_TRUCK;
				}
				
			    public double OBSERVED_DENSITY;

				public double getOBSERVED_DENSITY () {
					return this.OBSERVED_DENSITY;
				}
				
			    public int COMPONENT_ID;

				public int getCOMPONENT_ID () {
					return this.COMPONENT_ID;
				}
				
			    public int CALCULATE_SECONDARY_UNITS;

				public int getCALCULATE_SECONDARY_UNITS () {
					return this.CALCULATE_SECONDARY_UNITS;
				}
				
			    public String FINAL_SCALE_INTERFACE_CODE;

				public String getFINAL_SCALE_INTERFACE_CODE () {
					return this.FINAL_SCALE_INTERFACE_CODE;
				}
				
			    public int FRAC_START_GROSS_TOTALIZER;

				public int getFRAC_START_GROSS_TOTALIZER () {
					return this.FRAC_START_GROSS_TOTALIZER;
				}
				
			    public int FRAC_END_GROSS_TOTALIZER;

				public int getFRAC_END_GROSS_TOTALIZER () {
					return this.FRAC_END_GROSS_TOTALIZER;
				}
				
			    public String PETROEX_COMPONENT_PRODUCT_CODE;

				public String getPETROEX_COMPONENT_PRODUCT_CODE () {
					return this.PETROEX_COMPONENT_PRODUCT_CODE;
				}
				
			    public int PRODUCT_TOLERANCE_STATUS;

				public int getPRODUCT_TOLERANCE_STATUS () {
					return this.PRODUCT_TOLERANCE_STATUS;
				}
				
			    public int TANK_INVENTORY_UPDATED;

				public int getTANK_INVENTORY_UPDATED () {
					return this.TANK_INVENTORY_UPDATED;
				}
				
			    public int TOTALIZER_UPDATED;

				public int getTOTALIZER_UPDATED () {
					return this.TOTALIZER_UPDATED;
				}
				
			    public int FLUSH_STATUS;

				public int getFLUSH_STATUS () {
					return this.FLUSH_STATUS;
				}
				
			    public Integer REDUCED_PRODUCT_NUMBER;

				public Integer getREDUCED_PRODUCT_NUMBER () {
					return this.REDUCED_PRODUCT_NUMBER;
				}
				
			    public int ADDITIVE_WEIGHT;

				public int getADDITIVE_WEIGHT () {
					return this.ADDITIVE_WEIGHT;
				}
				
			    public int PRODUCT_WEIGHT;

				public int getPRODUCT_WEIGHT () {
					return this.PRODUCT_WEIGHT;
				}
				
			    public int RT_INJECTOR_ALARM_COUNT;

				public int getRT_INJECTOR_ALARM_COUNT () {
					return this.RT_INJECTOR_ALARM_COUNT;
				}
				
			    public int BATCH_NUMBER;

				public int getBATCH_NUMBER () {
					return this.BATCH_NUMBER;
				}
				
			    public String VRU_CODE;

				public String getVRU_CODE () {
					return this.VRU_CODE;
				}
				
			    public int ADDITIVE_MASKING;

				public int getADDITIVE_MASKING () {
					return this.ADDITIVE_MASKING;
				}
				
			    public int COMPATIBILITY_STATUS;

				public int getCOMPATIBILITY_STATUS () {
					return this.COMPATIBILITY_STATUS;
				}
				
			    public int RECIPE_CORRECTION_TYPE;

				public int getRECIPE_CORRECTION_TYPE () {
					return this.RECIPE_CORRECTION_TYPE;
				}
				
			    public int NON_RECIPE_GROSS_QUANTITY;

				public int getNON_RECIPE_GROSS_QUANTITY () {
					return this.NON_RECIPE_GROSS_QUANTITY;
				}
				
			    public int NON_RECIPE_NET_QUANTITY;

				public int getNON_RECIPE_NET_QUANTITY () {
					return this.NON_RECIPE_NET_QUANTITY;
				}
				
			    public int NON_RECIPE_WEIGHT;

				public int getNON_RECIPE_WEIGHT () {
					return this.NON_RECIPE_WEIGHT;
				}
				
			    public int WEIGHT_IN_VAC;

				public int getWEIGHT_IN_VAC () {
					return this.WEIGHT_IN_VAC;
				}
				
			    public int ADDITIVE_WEIGHT_IN_VAC;

				public int getADDITIVE_WEIGHT_IN_VAC () {
					return this.ADDITIVE_WEIGHT_IN_VAC;
				}
				
			    public int COMMITTED_GROSS_QUANTITY;

				public int getCOMMITTED_GROSS_QUANTITY () {
					return this.COMMITTED_GROSS_QUANTITY;
				}
				
			    public int PRODUCT_WEIGHT_IN_VAC;

				public int getPRODUCT_WEIGHT_IN_VAC () {
					return this.PRODUCT_WEIGHT_IN_VAC;
				}
				
			    public int COMMITTED_NET_QUANTITY;

				public int getCOMMITTED_NET_QUANTITY () {
					return this.COMMITTED_NET_QUANTITY;
				}
				
			    public String PDXR_PRODUCT_CODE;

				public String getPDXR_PRODUCT_CODE () {
					return this.PDXR_PRODUCT_CODE;
				}
				
			    public int PDXR_AUTHORIZATION_UNITS;

				public int getPDXR_AUTHORIZATION_UNITS () {
					return this.PDXR_AUTHORIZATION_UNITS;
				}
				
			    public int COMMITTED_WEIGHT_IN_VAC;

				public int getCOMMITTED_WEIGHT_IN_VAC () {
					return this.COMMITTED_WEIGHT_IN_VAC;
				}
				
			    public int COMMITTED_WEIGHT_IN_AIR;

				public int getCOMMITTED_WEIGHT_IN_AIR () {
					return this.COMMITTED_WEIGHT_IN_AIR;
				}
				
			    public String PDXR_ADDITIVE_CODE;

				public String getPDXR_ADDITIVE_CODE () {
					return this.PDXR_ADDITIVE_CODE;
				}
				
			    public double COMMITTED_CONV_TEMPERATURE;

				public double getCOMMITTED_CONV_TEMPERATURE () {
					return this.COMMITTED_CONV_TEMPERATURE;
				}
				
			    public double COMMITTED_CONV_DENSITY;

				public double getCOMMITTED_CONV_DENSITY () {
					return this.COMMITTED_CONV_DENSITY;
				}
				
			    public double COMMITTED_CONV_COE;

				public double getCOMMITTED_CONV_COE () {
					return this.COMMITTED_CONV_COE;
				}
				
			    public double COMMITTED_CONV_PRESSURE;

				public double getCOMMITTED_CONV_PRESSURE () {
					return this.COMMITTED_CONV_PRESSURE;
				}
				
			    public int MEASURED_QUANTITY_TYPE;

				public int getMEASURED_QUANTITY_TYPE () {
					return this.MEASURED_QUANTITY_TYPE;
				}
				
			    public int INVENTORY_QUANTITY_TYPE;

				public int getINVENTORY_QUANTITY_TYPE () {
					return this.INVENTORY_QUANTITY_TYPE;
				}
				
			    public int DERIVED_VALUES_DIRECTIVE;

				public int getDERIVED_VALUES_DIRECTIVE () {
					return this.DERIVED_VALUES_DIRECTIVE;
				}
				
			    public double PRESSURE;

				public double getPRESSURE () {
					return this.PRESSURE;
				}
				
			    public String METER_PRESET_CODE;

				public String getMETER_PRESET_CODE () {
					return this.METER_PRESET_CODE;
				}
				
			    public int CALCULATE_NET;

				public int getCALCULATE_NET () {
					return this.CALCULATE_NET;
				}
				
			    public int NON_RECIPE_WEIGHT_IN_VAC;

				public int getNON_RECIPE_WEIGHT_IN_VAC () {
					return this.NON_RECIPE_WEIGHT_IN_VAC;
				}
				
			    public int ADJUSTMENT_BATCH;

				public int getADJUSTMENT_BATCH () {
					return this.ADJUSTMENT_BATCH;
				}
				
			    public Integer COMPARTMENT_OWNER_ID;

				public Integer getCOMPARTMENT_OWNER_ID () {
					return this.COMPARTMENT_OWNER_ID;
				}
				
			    public String COMPARTMENT_CONTAINER_CODE;

				public String getCOMPARTMENT_CONTAINER_CODE () {
					return this.COMPARTMENT_CONTAINER_CODE;
				}
				
			    public Integer COMPARTMENT_CONTAINER_TYPE;

				public Integer getCOMPARTMENT_CONTAINER_TYPE () {
					return this.COMPARTMENT_CONTAINER_TYPE;
				}
				
			    public Integer COMPARTMENT_NUMBER;

				public Integer getCOMPARTMENT_NUMBER () {
					return this.COMPARTMENT_NUMBER;
				}
				
			    public String PDXR_LOADING_REF;

				public String getPDXR_LOADING_REF () {
					return this.PDXR_LOADING_REF;
				}
				
			    public int BLEND_CORRECTION_METHOD;

				public int getBLEND_CORRECTION_METHOD () {
					return this.BLEND_CORRECTION_METHOD;
				}
				
			    public double BLEND_CORRECTION_NET_VOLUME;

				public double getBLEND_CORRECTION_NET_VOLUME () {
					return this.BLEND_CORRECTION_NET_VOLUME;
				}
				
			    public double TOTAL_BATCH_BLEND_NET_VOLUME;

				public double getTOTAL_BATCH_BLEND_NET_VOLUME () {
					return this.TOTAL_BATCH_BLEND_NET_VOLUME;
				}
				
			    public int BLEND_CORRECTION_SOURCE;

				public int getBLEND_CORRECTION_SOURCE () {
					return this.BLEND_CORRECTION_SOURCE;
				}
				
			    public int COMMODITY_GROUP;

				public int getCOMMODITY_GROUP () {
					return this.COMMODITY_GROUP;
				}
				
			    public int DERIVATION_STATUS;

				public int getDERIVATION_STATUS () {
					return this.DERIVATION_STATUS;
				}
				
			    public String DERIVED_VALUES_ERROR;

				public String getDERIVED_VALUES_ERROR () {
					return this.DERIVED_VALUES_ERROR;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PGS_STAGE_DIM_ORDER_RECIPE.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_ORDER_RECIPE.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_ORDER_RECIPE = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_ORDER_RECIPE = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PGS_STAGE_DIM_ORDER_RECIPE, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_ORDER_RECIPE, 0, length, utf8Charset);
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
			if(length > commonByteArray_PGS_STAGE_DIM_ORDER_RECIPE.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_ORDER_RECIPE.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_ORDER_RECIPE = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_ORDER_RECIPE = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PGS_STAGE_DIM_ORDER_RECIPE, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_ORDER_RECIPE, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_ORDER_RECIPE) {

        	try {

        		int length = 0;
		
			        this.ORDER_ID = dis.readInt();
					
			        this.COMPARTMENT_ID = dis.readInt();
					
			        this.ORDER_RECIPE_ID = dis.readInt();
					
					this.BAY_CODE = readString(dis);
					
					this.API_CODE = readString(dis);
					
					this.INJECTOR_PRESET_CODE = readString(dis);
					
					this.TARE_SCALE_INTERFACE_CODE = readString(dis);
					
					this.TANK_CODE = readString(dis);
					
					this.PRODUCT_GROUP_CODE = readString(dis);
					
					this.INJECTOR_CODE = readString(dis);
					
					this.METER_CODE = readString(dis);
					
						this.SUPPLIER_NUMBER = readInteger(dis);
					
			        this.TERMINAL_PRODUCT_NUMBER = dis.readInt();
					
			        this.TERMINAL_PRODUCT_TYPE = dis.readInt();
					
					this.SHOST_SI_HOST_PRODUCT_NUMBER = readString(dis);
					
			        this.BLEND_PERCENT = dis.readDouble();
					
			        this.RATE = dis.readInt();
					
					this.THOST_TI_HOST_PRODUCT_NUMBER = readString(dis);
					
			        this.ORDERED_QUANTITY = dis.readInt();
					
			        this.OVERRIDE_TEMPERATURE_ENABLE = dis.readInt();
					
			        this.GROSS_QUANTITY = dis.readInt();
					
			        this.WEIGHT = dis.readInt();
					
			        this.NET_QUANTITY = dis.readInt();
					
			        this.DENSITY = dis.readDouble();
					
			        this.CUSTOMER_NET_QUANTITY = dis.readInt();
					
			        this.SPECIFIC_GRAVITY = dis.readDouble();
					
			        this.COEFFICIENT_EXPANSION = dis.readDouble();
					
			        this.TEMPERATURE = dis.readDouble();
					
			        this.RVP = dis.readDouble();
					
			        this.OXYGEN = dis.readDouble();
					
			        this.START_GROSS_TOTALIZER = dis.readInt();
					
			        this.END_GROSS_TOTALIZER = dis.readInt();
					
			        this.START_NET_TOTALIZER = dis.readInt();
					
			        this.END_NET_TOTALIZER = dis.readInt();
					
			        this.START_WEIGHT = dis.readInt();
					
			        this.END_WEIGHT = dis.readInt();
					
					this.LAST_USER_NAME = readString(dis);
					
					this.LAST_MODIFIED = readDate(dis);
					
					this.START_TIME = readDate(dis);
					
					this.END_TIME = readDate(dis);
					
			        this.ADDITIVE_QUANTITY = dis.readInt();
					
			        this.PRODUCT_QUANTITY = dis.readInt();
					
					this.HOST_PRODUCT_CODE = readString(dis);
					
					this.HOST_PRODUCT_NAME = readString(dis);
					
			        this.FROM_LEFT_ON_TRUCK = dis.readInt();
					
			        this.OBSERVED_DENSITY = dis.readDouble();
					
			        this.COMPONENT_ID = dis.readInt();
					
			        this.CALCULATE_SECONDARY_UNITS = dis.readInt();
					
					this.FINAL_SCALE_INTERFACE_CODE = readString(dis);
					
			        this.FRAC_START_GROSS_TOTALIZER = dis.readInt();
					
			        this.FRAC_END_GROSS_TOTALIZER = dis.readInt();
					
					this.PETROEX_COMPONENT_PRODUCT_CODE = readString(dis);
					
			        this.PRODUCT_TOLERANCE_STATUS = dis.readInt();
					
			        this.TANK_INVENTORY_UPDATED = dis.readInt();
					
			        this.TOTALIZER_UPDATED = dis.readInt();
					
			        this.FLUSH_STATUS = dis.readInt();
					
						this.REDUCED_PRODUCT_NUMBER = readInteger(dis);
					
			        this.ADDITIVE_WEIGHT = dis.readInt();
					
			        this.PRODUCT_WEIGHT = dis.readInt();
					
			        this.RT_INJECTOR_ALARM_COUNT = dis.readInt();
					
			        this.BATCH_NUMBER = dis.readInt();
					
					this.VRU_CODE = readString(dis);
					
			        this.ADDITIVE_MASKING = dis.readInt();
					
			        this.COMPATIBILITY_STATUS = dis.readInt();
					
			        this.RECIPE_CORRECTION_TYPE = dis.readInt();
					
			        this.NON_RECIPE_GROSS_QUANTITY = dis.readInt();
					
			        this.NON_RECIPE_NET_QUANTITY = dis.readInt();
					
			        this.NON_RECIPE_WEIGHT = dis.readInt();
					
			        this.WEIGHT_IN_VAC = dis.readInt();
					
			        this.ADDITIVE_WEIGHT_IN_VAC = dis.readInt();
					
			        this.COMMITTED_GROSS_QUANTITY = dis.readInt();
					
			        this.PRODUCT_WEIGHT_IN_VAC = dis.readInt();
					
			        this.COMMITTED_NET_QUANTITY = dis.readInt();
					
					this.PDXR_PRODUCT_CODE = readString(dis);
					
			        this.PDXR_AUTHORIZATION_UNITS = dis.readInt();
					
			        this.COMMITTED_WEIGHT_IN_VAC = dis.readInt();
					
			        this.COMMITTED_WEIGHT_IN_AIR = dis.readInt();
					
					this.PDXR_ADDITIVE_CODE = readString(dis);
					
			        this.COMMITTED_CONV_TEMPERATURE = dis.readDouble();
					
			        this.COMMITTED_CONV_DENSITY = dis.readDouble();
					
			        this.COMMITTED_CONV_COE = dis.readDouble();
					
			        this.COMMITTED_CONV_PRESSURE = dis.readDouble();
					
			        this.MEASURED_QUANTITY_TYPE = dis.readInt();
					
			        this.INVENTORY_QUANTITY_TYPE = dis.readInt();
					
			        this.DERIVED_VALUES_DIRECTIVE = dis.readInt();
					
			        this.PRESSURE = dis.readDouble();
					
					this.METER_PRESET_CODE = readString(dis);
					
			        this.CALCULATE_NET = dis.readInt();
					
			        this.NON_RECIPE_WEIGHT_IN_VAC = dis.readInt();
					
			        this.ADJUSTMENT_BATCH = dis.readInt();
					
						this.COMPARTMENT_OWNER_ID = readInteger(dis);
					
					this.COMPARTMENT_CONTAINER_CODE = readString(dis);
					
						this.COMPARTMENT_CONTAINER_TYPE = readInteger(dis);
					
						this.COMPARTMENT_NUMBER = readInteger(dis);
					
					this.PDXR_LOADING_REF = readString(dis);
					
			        this.BLEND_CORRECTION_METHOD = dis.readInt();
					
			        this.BLEND_CORRECTION_NET_VOLUME = dis.readDouble();
					
			        this.TOTAL_BATCH_BLEND_NET_VOLUME = dis.readDouble();
					
			        this.BLEND_CORRECTION_SOURCE = dis.readInt();
					
			        this.COMMODITY_GROUP = dis.readInt();
					
			        this.DERIVATION_STATUS = dis.readInt();
					
					this.DERIVED_VALUES_ERROR = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_ORDER_RECIPE) {

        	try {

        		int length = 0;
		
			        this.ORDER_ID = dis.readInt();
					
			        this.COMPARTMENT_ID = dis.readInt();
					
			        this.ORDER_RECIPE_ID = dis.readInt();
					
					this.BAY_CODE = readString(dis);
					
					this.API_CODE = readString(dis);
					
					this.INJECTOR_PRESET_CODE = readString(dis);
					
					this.TARE_SCALE_INTERFACE_CODE = readString(dis);
					
					this.TANK_CODE = readString(dis);
					
					this.PRODUCT_GROUP_CODE = readString(dis);
					
					this.INJECTOR_CODE = readString(dis);
					
					this.METER_CODE = readString(dis);
					
						this.SUPPLIER_NUMBER = readInteger(dis);
					
			        this.TERMINAL_PRODUCT_NUMBER = dis.readInt();
					
			        this.TERMINAL_PRODUCT_TYPE = dis.readInt();
					
					this.SHOST_SI_HOST_PRODUCT_NUMBER = readString(dis);
					
			        this.BLEND_PERCENT = dis.readDouble();
					
			        this.RATE = dis.readInt();
					
					this.THOST_TI_HOST_PRODUCT_NUMBER = readString(dis);
					
			        this.ORDERED_QUANTITY = dis.readInt();
					
			        this.OVERRIDE_TEMPERATURE_ENABLE = dis.readInt();
					
			        this.GROSS_QUANTITY = dis.readInt();
					
			        this.WEIGHT = dis.readInt();
					
			        this.NET_QUANTITY = dis.readInt();
					
			        this.DENSITY = dis.readDouble();
					
			        this.CUSTOMER_NET_QUANTITY = dis.readInt();
					
			        this.SPECIFIC_GRAVITY = dis.readDouble();
					
			        this.COEFFICIENT_EXPANSION = dis.readDouble();
					
			        this.TEMPERATURE = dis.readDouble();
					
			        this.RVP = dis.readDouble();
					
			        this.OXYGEN = dis.readDouble();
					
			        this.START_GROSS_TOTALIZER = dis.readInt();
					
			        this.END_GROSS_TOTALIZER = dis.readInt();
					
			        this.START_NET_TOTALIZER = dis.readInt();
					
			        this.END_NET_TOTALIZER = dis.readInt();
					
			        this.START_WEIGHT = dis.readInt();
					
			        this.END_WEIGHT = dis.readInt();
					
					this.LAST_USER_NAME = readString(dis);
					
					this.LAST_MODIFIED = readDate(dis);
					
					this.START_TIME = readDate(dis);
					
					this.END_TIME = readDate(dis);
					
			        this.ADDITIVE_QUANTITY = dis.readInt();
					
			        this.PRODUCT_QUANTITY = dis.readInt();
					
					this.HOST_PRODUCT_CODE = readString(dis);
					
					this.HOST_PRODUCT_NAME = readString(dis);
					
			        this.FROM_LEFT_ON_TRUCK = dis.readInt();
					
			        this.OBSERVED_DENSITY = dis.readDouble();
					
			        this.COMPONENT_ID = dis.readInt();
					
			        this.CALCULATE_SECONDARY_UNITS = dis.readInt();
					
					this.FINAL_SCALE_INTERFACE_CODE = readString(dis);
					
			        this.FRAC_START_GROSS_TOTALIZER = dis.readInt();
					
			        this.FRAC_END_GROSS_TOTALIZER = dis.readInt();
					
					this.PETROEX_COMPONENT_PRODUCT_CODE = readString(dis);
					
			        this.PRODUCT_TOLERANCE_STATUS = dis.readInt();
					
			        this.TANK_INVENTORY_UPDATED = dis.readInt();
					
			        this.TOTALIZER_UPDATED = dis.readInt();
					
			        this.FLUSH_STATUS = dis.readInt();
					
						this.REDUCED_PRODUCT_NUMBER = readInteger(dis);
					
			        this.ADDITIVE_WEIGHT = dis.readInt();
					
			        this.PRODUCT_WEIGHT = dis.readInt();
					
			        this.RT_INJECTOR_ALARM_COUNT = dis.readInt();
					
			        this.BATCH_NUMBER = dis.readInt();
					
					this.VRU_CODE = readString(dis);
					
			        this.ADDITIVE_MASKING = dis.readInt();
					
			        this.COMPATIBILITY_STATUS = dis.readInt();
					
			        this.RECIPE_CORRECTION_TYPE = dis.readInt();
					
			        this.NON_RECIPE_GROSS_QUANTITY = dis.readInt();
					
			        this.NON_RECIPE_NET_QUANTITY = dis.readInt();
					
			        this.NON_RECIPE_WEIGHT = dis.readInt();
					
			        this.WEIGHT_IN_VAC = dis.readInt();
					
			        this.ADDITIVE_WEIGHT_IN_VAC = dis.readInt();
					
			        this.COMMITTED_GROSS_QUANTITY = dis.readInt();
					
			        this.PRODUCT_WEIGHT_IN_VAC = dis.readInt();
					
			        this.COMMITTED_NET_QUANTITY = dis.readInt();
					
					this.PDXR_PRODUCT_CODE = readString(dis);
					
			        this.PDXR_AUTHORIZATION_UNITS = dis.readInt();
					
			        this.COMMITTED_WEIGHT_IN_VAC = dis.readInt();
					
			        this.COMMITTED_WEIGHT_IN_AIR = dis.readInt();
					
					this.PDXR_ADDITIVE_CODE = readString(dis);
					
			        this.COMMITTED_CONV_TEMPERATURE = dis.readDouble();
					
			        this.COMMITTED_CONV_DENSITY = dis.readDouble();
					
			        this.COMMITTED_CONV_COE = dis.readDouble();
					
			        this.COMMITTED_CONV_PRESSURE = dis.readDouble();
					
			        this.MEASURED_QUANTITY_TYPE = dis.readInt();
					
			        this.INVENTORY_QUANTITY_TYPE = dis.readInt();
					
			        this.DERIVED_VALUES_DIRECTIVE = dis.readInt();
					
			        this.PRESSURE = dis.readDouble();
					
					this.METER_PRESET_CODE = readString(dis);
					
			        this.CALCULATE_NET = dis.readInt();
					
			        this.NON_RECIPE_WEIGHT_IN_VAC = dis.readInt();
					
			        this.ADJUSTMENT_BATCH = dis.readInt();
					
						this.COMPARTMENT_OWNER_ID = readInteger(dis);
					
					this.COMPARTMENT_CONTAINER_CODE = readString(dis);
					
						this.COMPARTMENT_CONTAINER_TYPE = readInteger(dis);
					
						this.COMPARTMENT_NUMBER = readInteger(dis);
					
					this.PDXR_LOADING_REF = readString(dis);
					
			        this.BLEND_CORRECTION_METHOD = dis.readInt();
					
			        this.BLEND_CORRECTION_NET_VOLUME = dis.readDouble();
					
			        this.TOTAL_BATCH_BLEND_NET_VOLUME = dis.readDouble();
					
			        this.BLEND_CORRECTION_SOURCE = dis.readInt();
					
			        this.COMMODITY_GROUP = dis.readInt();
					
			        this.DERIVATION_STATUS = dis.readInt();
					
					this.DERIVED_VALUES_ERROR = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.ORDER_ID);
					
					// int
				
		            	dos.writeInt(this.COMPARTMENT_ID);
					
					// int
				
		            	dos.writeInt(this.ORDER_RECIPE_ID);
					
					// String
				
						writeString(this.BAY_CODE,dos);
					
					// String
				
						writeString(this.API_CODE,dos);
					
					// String
				
						writeString(this.INJECTOR_PRESET_CODE,dos);
					
					// String
				
						writeString(this.TARE_SCALE_INTERFACE_CODE,dos);
					
					// String
				
						writeString(this.TANK_CODE,dos);
					
					// String
				
						writeString(this.PRODUCT_GROUP_CODE,dos);
					
					// String
				
						writeString(this.INJECTOR_CODE,dos);
					
					// String
				
						writeString(this.METER_CODE,dos);
					
					// Integer
				
						writeInteger(this.SUPPLIER_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.TERMINAL_PRODUCT_NUMBER);
					
					// int
				
		            	dos.writeInt(this.TERMINAL_PRODUCT_TYPE);
					
					// String
				
						writeString(this.SHOST_SI_HOST_PRODUCT_NUMBER,dos);
					
					// double
				
		            	dos.writeDouble(this.BLEND_PERCENT);
					
					// int
				
		            	dos.writeInt(this.RATE);
					
					// String
				
						writeString(this.THOST_TI_HOST_PRODUCT_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.ORDERED_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.OVERRIDE_TEMPERATURE_ENABLE);
					
					// int
				
		            	dos.writeInt(this.GROSS_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.WEIGHT);
					
					// int
				
		            	dos.writeInt(this.NET_QUANTITY);
					
					// double
				
		            	dos.writeDouble(this.DENSITY);
					
					// int
				
		            	dos.writeInt(this.CUSTOMER_NET_QUANTITY);
					
					// double
				
		            	dos.writeDouble(this.SPECIFIC_GRAVITY);
					
					// double
				
		            	dos.writeDouble(this.COEFFICIENT_EXPANSION);
					
					// double
				
		            	dos.writeDouble(this.TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.RVP);
					
					// double
				
		            	dos.writeDouble(this.OXYGEN);
					
					// int
				
		            	dos.writeInt(this.START_GROSS_TOTALIZER);
					
					// int
				
		            	dos.writeInt(this.END_GROSS_TOTALIZER);
					
					// int
				
		            	dos.writeInt(this.START_NET_TOTALIZER);
					
					// int
				
		            	dos.writeInt(this.END_NET_TOTALIZER);
					
					// int
				
		            	dos.writeInt(this.START_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.END_WEIGHT);
					
					// String
				
						writeString(this.LAST_USER_NAME,dos);
					
					// java.util.Date
				
						writeDate(this.LAST_MODIFIED,dos);
					
					// java.util.Date
				
						writeDate(this.START_TIME,dos);
					
					// java.util.Date
				
						writeDate(this.END_TIME,dos);
					
					// int
				
		            	dos.writeInt(this.ADDITIVE_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.PRODUCT_QUANTITY);
					
					// String
				
						writeString(this.HOST_PRODUCT_CODE,dos);
					
					// String
				
						writeString(this.HOST_PRODUCT_NAME,dos);
					
					// int
				
		            	dos.writeInt(this.FROM_LEFT_ON_TRUCK);
					
					// double
				
		            	dos.writeDouble(this.OBSERVED_DENSITY);
					
					// int
				
		            	dos.writeInt(this.COMPONENT_ID);
					
					// int
				
		            	dos.writeInt(this.CALCULATE_SECONDARY_UNITS);
					
					// String
				
						writeString(this.FINAL_SCALE_INTERFACE_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.FRAC_START_GROSS_TOTALIZER);
					
					// int
				
		            	dos.writeInt(this.FRAC_END_GROSS_TOTALIZER);
					
					// String
				
						writeString(this.PETROEX_COMPONENT_PRODUCT_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.PRODUCT_TOLERANCE_STATUS);
					
					// int
				
		            	dos.writeInt(this.TANK_INVENTORY_UPDATED);
					
					// int
				
		            	dos.writeInt(this.TOTALIZER_UPDATED);
					
					// int
				
		            	dos.writeInt(this.FLUSH_STATUS);
					
					// Integer
				
						writeInteger(this.REDUCED_PRODUCT_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.ADDITIVE_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.PRODUCT_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.RT_INJECTOR_ALARM_COUNT);
					
					// int
				
		            	dos.writeInt(this.BATCH_NUMBER);
					
					// String
				
						writeString(this.VRU_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.ADDITIVE_MASKING);
					
					// int
				
		            	dos.writeInt(this.COMPATIBILITY_STATUS);
					
					// int
				
		            	dos.writeInt(this.RECIPE_CORRECTION_TYPE);
					
					// int
				
		            	dos.writeInt(this.NON_RECIPE_GROSS_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.NON_RECIPE_NET_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.NON_RECIPE_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.ADDITIVE_WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.COMMITTED_GROSS_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.PRODUCT_WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.COMMITTED_NET_QUANTITY);
					
					// String
				
						writeString(this.PDXR_PRODUCT_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.PDXR_AUTHORIZATION_UNITS);
					
					// int
				
		            	dos.writeInt(this.COMMITTED_WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.COMMITTED_WEIGHT_IN_AIR);
					
					// String
				
						writeString(this.PDXR_ADDITIVE_CODE,dos);
					
					// double
				
		            	dos.writeDouble(this.COMMITTED_CONV_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.COMMITTED_CONV_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.COMMITTED_CONV_COE);
					
					// double
				
		            	dos.writeDouble(this.COMMITTED_CONV_PRESSURE);
					
					// int
				
		            	dos.writeInt(this.MEASURED_QUANTITY_TYPE);
					
					// int
				
		            	dos.writeInt(this.INVENTORY_QUANTITY_TYPE);
					
					// int
				
		            	dos.writeInt(this.DERIVED_VALUES_DIRECTIVE);
					
					// double
				
		            	dos.writeDouble(this.PRESSURE);
					
					// String
				
						writeString(this.METER_PRESET_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.CALCULATE_NET);
					
					// int
				
		            	dos.writeInt(this.NON_RECIPE_WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.ADJUSTMENT_BATCH);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_OWNER_ID,dos);
					
					// String
				
						writeString(this.COMPARTMENT_CONTAINER_CODE,dos);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_CONTAINER_TYPE,dos);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_NUMBER,dos);
					
					// String
				
						writeString(this.PDXR_LOADING_REF,dos);
					
					// int
				
		            	dos.writeInt(this.BLEND_CORRECTION_METHOD);
					
					// double
				
		            	dos.writeDouble(this.BLEND_CORRECTION_NET_VOLUME);
					
					// double
				
		            	dos.writeDouble(this.TOTAL_BATCH_BLEND_NET_VOLUME);
					
					// int
				
		            	dos.writeInt(this.BLEND_CORRECTION_SOURCE);
					
					// int
				
		            	dos.writeInt(this.COMMODITY_GROUP);
					
					// int
				
		            	dos.writeInt(this.DERIVATION_STATUS);
					
					// String
				
						writeString(this.DERIVED_VALUES_ERROR,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.ORDER_ID);
					
					// int
				
		            	dos.writeInt(this.COMPARTMENT_ID);
					
					// int
				
		            	dos.writeInt(this.ORDER_RECIPE_ID);
					
					// String
				
						writeString(this.BAY_CODE,dos);
					
					// String
				
						writeString(this.API_CODE,dos);
					
					// String
				
						writeString(this.INJECTOR_PRESET_CODE,dos);
					
					// String
				
						writeString(this.TARE_SCALE_INTERFACE_CODE,dos);
					
					// String
				
						writeString(this.TANK_CODE,dos);
					
					// String
				
						writeString(this.PRODUCT_GROUP_CODE,dos);
					
					// String
				
						writeString(this.INJECTOR_CODE,dos);
					
					// String
				
						writeString(this.METER_CODE,dos);
					
					// Integer
				
						writeInteger(this.SUPPLIER_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.TERMINAL_PRODUCT_NUMBER);
					
					// int
				
		            	dos.writeInt(this.TERMINAL_PRODUCT_TYPE);
					
					// String
				
						writeString(this.SHOST_SI_HOST_PRODUCT_NUMBER,dos);
					
					// double
				
		            	dos.writeDouble(this.BLEND_PERCENT);
					
					// int
				
		            	dos.writeInt(this.RATE);
					
					// String
				
						writeString(this.THOST_TI_HOST_PRODUCT_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.ORDERED_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.OVERRIDE_TEMPERATURE_ENABLE);
					
					// int
				
		            	dos.writeInt(this.GROSS_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.WEIGHT);
					
					// int
				
		            	dos.writeInt(this.NET_QUANTITY);
					
					// double
				
		            	dos.writeDouble(this.DENSITY);
					
					// int
				
		            	dos.writeInt(this.CUSTOMER_NET_QUANTITY);
					
					// double
				
		            	dos.writeDouble(this.SPECIFIC_GRAVITY);
					
					// double
				
		            	dos.writeDouble(this.COEFFICIENT_EXPANSION);
					
					// double
				
		            	dos.writeDouble(this.TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.RVP);
					
					// double
				
		            	dos.writeDouble(this.OXYGEN);
					
					// int
				
		            	dos.writeInt(this.START_GROSS_TOTALIZER);
					
					// int
				
		            	dos.writeInt(this.END_GROSS_TOTALIZER);
					
					// int
				
		            	dos.writeInt(this.START_NET_TOTALIZER);
					
					// int
				
		            	dos.writeInt(this.END_NET_TOTALIZER);
					
					// int
				
		            	dos.writeInt(this.START_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.END_WEIGHT);
					
					// String
				
						writeString(this.LAST_USER_NAME,dos);
					
					// java.util.Date
				
						writeDate(this.LAST_MODIFIED,dos);
					
					// java.util.Date
				
						writeDate(this.START_TIME,dos);
					
					// java.util.Date
				
						writeDate(this.END_TIME,dos);
					
					// int
				
		            	dos.writeInt(this.ADDITIVE_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.PRODUCT_QUANTITY);
					
					// String
				
						writeString(this.HOST_PRODUCT_CODE,dos);
					
					// String
				
						writeString(this.HOST_PRODUCT_NAME,dos);
					
					// int
				
		            	dos.writeInt(this.FROM_LEFT_ON_TRUCK);
					
					// double
				
		            	dos.writeDouble(this.OBSERVED_DENSITY);
					
					// int
				
		            	dos.writeInt(this.COMPONENT_ID);
					
					// int
				
		            	dos.writeInt(this.CALCULATE_SECONDARY_UNITS);
					
					// String
				
						writeString(this.FINAL_SCALE_INTERFACE_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.FRAC_START_GROSS_TOTALIZER);
					
					// int
				
		            	dos.writeInt(this.FRAC_END_GROSS_TOTALIZER);
					
					// String
				
						writeString(this.PETROEX_COMPONENT_PRODUCT_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.PRODUCT_TOLERANCE_STATUS);
					
					// int
				
		            	dos.writeInt(this.TANK_INVENTORY_UPDATED);
					
					// int
				
		            	dos.writeInt(this.TOTALIZER_UPDATED);
					
					// int
				
		            	dos.writeInt(this.FLUSH_STATUS);
					
					// Integer
				
						writeInteger(this.REDUCED_PRODUCT_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.ADDITIVE_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.PRODUCT_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.RT_INJECTOR_ALARM_COUNT);
					
					// int
				
		            	dos.writeInt(this.BATCH_NUMBER);
					
					// String
				
						writeString(this.VRU_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.ADDITIVE_MASKING);
					
					// int
				
		            	dos.writeInt(this.COMPATIBILITY_STATUS);
					
					// int
				
		            	dos.writeInt(this.RECIPE_CORRECTION_TYPE);
					
					// int
				
		            	dos.writeInt(this.NON_RECIPE_GROSS_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.NON_RECIPE_NET_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.NON_RECIPE_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.ADDITIVE_WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.COMMITTED_GROSS_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.PRODUCT_WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.COMMITTED_NET_QUANTITY);
					
					// String
				
						writeString(this.PDXR_PRODUCT_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.PDXR_AUTHORIZATION_UNITS);
					
					// int
				
		            	dos.writeInt(this.COMMITTED_WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.COMMITTED_WEIGHT_IN_AIR);
					
					// String
				
						writeString(this.PDXR_ADDITIVE_CODE,dos);
					
					// double
				
		            	dos.writeDouble(this.COMMITTED_CONV_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.COMMITTED_CONV_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.COMMITTED_CONV_COE);
					
					// double
				
		            	dos.writeDouble(this.COMMITTED_CONV_PRESSURE);
					
					// int
				
		            	dos.writeInt(this.MEASURED_QUANTITY_TYPE);
					
					// int
				
		            	dos.writeInt(this.INVENTORY_QUANTITY_TYPE);
					
					// int
				
		            	dos.writeInt(this.DERIVED_VALUES_DIRECTIVE);
					
					// double
				
		            	dos.writeDouble(this.PRESSURE);
					
					// String
				
						writeString(this.METER_PRESET_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.CALCULATE_NET);
					
					// int
				
		            	dos.writeInt(this.NON_RECIPE_WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.ADJUSTMENT_BATCH);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_OWNER_ID,dos);
					
					// String
				
						writeString(this.COMPARTMENT_CONTAINER_CODE,dos);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_CONTAINER_TYPE,dos);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_NUMBER,dos);
					
					// String
				
						writeString(this.PDXR_LOADING_REF,dos);
					
					// int
				
		            	dos.writeInt(this.BLEND_CORRECTION_METHOD);
					
					// double
				
		            	dos.writeDouble(this.BLEND_CORRECTION_NET_VOLUME);
					
					// double
				
		            	dos.writeDouble(this.TOTAL_BATCH_BLEND_NET_VOLUME);
					
					// int
				
		            	dos.writeInt(this.BLEND_CORRECTION_SOURCE);
					
					// int
				
		            	dos.writeInt(this.COMMODITY_GROUP);
					
					// int
				
		            	dos.writeInt(this.DERIVATION_STATUS);
					
					// String
				
						writeString(this.DERIVED_VALUES_ERROR,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("ORDER_ID="+String.valueOf(ORDER_ID));
		sb.append(",COMPARTMENT_ID="+String.valueOf(COMPARTMENT_ID));
		sb.append(",ORDER_RECIPE_ID="+String.valueOf(ORDER_RECIPE_ID));
		sb.append(",BAY_CODE="+BAY_CODE);
		sb.append(",API_CODE="+API_CODE);
		sb.append(",INJECTOR_PRESET_CODE="+INJECTOR_PRESET_CODE);
		sb.append(",TARE_SCALE_INTERFACE_CODE="+TARE_SCALE_INTERFACE_CODE);
		sb.append(",TANK_CODE="+TANK_CODE);
		sb.append(",PRODUCT_GROUP_CODE="+PRODUCT_GROUP_CODE);
		sb.append(",INJECTOR_CODE="+INJECTOR_CODE);
		sb.append(",METER_CODE="+METER_CODE);
		sb.append(",SUPPLIER_NUMBER="+String.valueOf(SUPPLIER_NUMBER));
		sb.append(",TERMINAL_PRODUCT_NUMBER="+String.valueOf(TERMINAL_PRODUCT_NUMBER));
		sb.append(",TERMINAL_PRODUCT_TYPE="+String.valueOf(TERMINAL_PRODUCT_TYPE));
		sb.append(",SHOST_SI_HOST_PRODUCT_NUMBER="+SHOST_SI_HOST_PRODUCT_NUMBER);
		sb.append(",BLEND_PERCENT="+String.valueOf(BLEND_PERCENT));
		sb.append(",RATE="+String.valueOf(RATE));
		sb.append(",THOST_TI_HOST_PRODUCT_NUMBER="+THOST_TI_HOST_PRODUCT_NUMBER);
		sb.append(",ORDERED_QUANTITY="+String.valueOf(ORDERED_QUANTITY));
		sb.append(",OVERRIDE_TEMPERATURE_ENABLE="+String.valueOf(OVERRIDE_TEMPERATURE_ENABLE));
		sb.append(",GROSS_QUANTITY="+String.valueOf(GROSS_QUANTITY));
		sb.append(",WEIGHT="+String.valueOf(WEIGHT));
		sb.append(",NET_QUANTITY="+String.valueOf(NET_QUANTITY));
		sb.append(",DENSITY="+String.valueOf(DENSITY));
		sb.append(",CUSTOMER_NET_QUANTITY="+String.valueOf(CUSTOMER_NET_QUANTITY));
		sb.append(",SPECIFIC_GRAVITY="+String.valueOf(SPECIFIC_GRAVITY));
		sb.append(",COEFFICIENT_EXPANSION="+String.valueOf(COEFFICIENT_EXPANSION));
		sb.append(",TEMPERATURE="+String.valueOf(TEMPERATURE));
		sb.append(",RVP="+String.valueOf(RVP));
		sb.append(",OXYGEN="+String.valueOf(OXYGEN));
		sb.append(",START_GROSS_TOTALIZER="+String.valueOf(START_GROSS_TOTALIZER));
		sb.append(",END_GROSS_TOTALIZER="+String.valueOf(END_GROSS_TOTALIZER));
		sb.append(",START_NET_TOTALIZER="+String.valueOf(START_NET_TOTALIZER));
		sb.append(",END_NET_TOTALIZER="+String.valueOf(END_NET_TOTALIZER));
		sb.append(",START_WEIGHT="+String.valueOf(START_WEIGHT));
		sb.append(",END_WEIGHT="+String.valueOf(END_WEIGHT));
		sb.append(",LAST_USER_NAME="+LAST_USER_NAME);
		sb.append(",LAST_MODIFIED="+String.valueOf(LAST_MODIFIED));
		sb.append(",START_TIME="+String.valueOf(START_TIME));
		sb.append(",END_TIME="+String.valueOf(END_TIME));
		sb.append(",ADDITIVE_QUANTITY="+String.valueOf(ADDITIVE_QUANTITY));
		sb.append(",PRODUCT_QUANTITY="+String.valueOf(PRODUCT_QUANTITY));
		sb.append(",HOST_PRODUCT_CODE="+HOST_PRODUCT_CODE);
		sb.append(",HOST_PRODUCT_NAME="+HOST_PRODUCT_NAME);
		sb.append(",FROM_LEFT_ON_TRUCK="+String.valueOf(FROM_LEFT_ON_TRUCK));
		sb.append(",OBSERVED_DENSITY="+String.valueOf(OBSERVED_DENSITY));
		sb.append(",COMPONENT_ID="+String.valueOf(COMPONENT_ID));
		sb.append(",CALCULATE_SECONDARY_UNITS="+String.valueOf(CALCULATE_SECONDARY_UNITS));
		sb.append(",FINAL_SCALE_INTERFACE_CODE="+FINAL_SCALE_INTERFACE_CODE);
		sb.append(",FRAC_START_GROSS_TOTALIZER="+String.valueOf(FRAC_START_GROSS_TOTALIZER));
		sb.append(",FRAC_END_GROSS_TOTALIZER="+String.valueOf(FRAC_END_GROSS_TOTALIZER));
		sb.append(",PETROEX_COMPONENT_PRODUCT_CODE="+PETROEX_COMPONENT_PRODUCT_CODE);
		sb.append(",PRODUCT_TOLERANCE_STATUS="+String.valueOf(PRODUCT_TOLERANCE_STATUS));
		sb.append(",TANK_INVENTORY_UPDATED="+String.valueOf(TANK_INVENTORY_UPDATED));
		sb.append(",TOTALIZER_UPDATED="+String.valueOf(TOTALIZER_UPDATED));
		sb.append(",FLUSH_STATUS="+String.valueOf(FLUSH_STATUS));
		sb.append(",REDUCED_PRODUCT_NUMBER="+String.valueOf(REDUCED_PRODUCT_NUMBER));
		sb.append(",ADDITIVE_WEIGHT="+String.valueOf(ADDITIVE_WEIGHT));
		sb.append(",PRODUCT_WEIGHT="+String.valueOf(PRODUCT_WEIGHT));
		sb.append(",RT_INJECTOR_ALARM_COUNT="+String.valueOf(RT_INJECTOR_ALARM_COUNT));
		sb.append(",BATCH_NUMBER="+String.valueOf(BATCH_NUMBER));
		sb.append(",VRU_CODE="+VRU_CODE);
		sb.append(",ADDITIVE_MASKING="+String.valueOf(ADDITIVE_MASKING));
		sb.append(",COMPATIBILITY_STATUS="+String.valueOf(COMPATIBILITY_STATUS));
		sb.append(",RECIPE_CORRECTION_TYPE="+String.valueOf(RECIPE_CORRECTION_TYPE));
		sb.append(",NON_RECIPE_GROSS_QUANTITY="+String.valueOf(NON_RECIPE_GROSS_QUANTITY));
		sb.append(",NON_RECIPE_NET_QUANTITY="+String.valueOf(NON_RECIPE_NET_QUANTITY));
		sb.append(",NON_RECIPE_WEIGHT="+String.valueOf(NON_RECIPE_WEIGHT));
		sb.append(",WEIGHT_IN_VAC="+String.valueOf(WEIGHT_IN_VAC));
		sb.append(",ADDITIVE_WEIGHT_IN_VAC="+String.valueOf(ADDITIVE_WEIGHT_IN_VAC));
		sb.append(",COMMITTED_GROSS_QUANTITY="+String.valueOf(COMMITTED_GROSS_QUANTITY));
		sb.append(",PRODUCT_WEIGHT_IN_VAC="+String.valueOf(PRODUCT_WEIGHT_IN_VAC));
		sb.append(",COMMITTED_NET_QUANTITY="+String.valueOf(COMMITTED_NET_QUANTITY));
		sb.append(",PDXR_PRODUCT_CODE="+PDXR_PRODUCT_CODE);
		sb.append(",PDXR_AUTHORIZATION_UNITS="+String.valueOf(PDXR_AUTHORIZATION_UNITS));
		sb.append(",COMMITTED_WEIGHT_IN_VAC="+String.valueOf(COMMITTED_WEIGHT_IN_VAC));
		sb.append(",COMMITTED_WEIGHT_IN_AIR="+String.valueOf(COMMITTED_WEIGHT_IN_AIR));
		sb.append(",PDXR_ADDITIVE_CODE="+PDXR_ADDITIVE_CODE);
		sb.append(",COMMITTED_CONV_TEMPERATURE="+String.valueOf(COMMITTED_CONV_TEMPERATURE));
		sb.append(",COMMITTED_CONV_DENSITY="+String.valueOf(COMMITTED_CONV_DENSITY));
		sb.append(",COMMITTED_CONV_COE="+String.valueOf(COMMITTED_CONV_COE));
		sb.append(",COMMITTED_CONV_PRESSURE="+String.valueOf(COMMITTED_CONV_PRESSURE));
		sb.append(",MEASURED_QUANTITY_TYPE="+String.valueOf(MEASURED_QUANTITY_TYPE));
		sb.append(",INVENTORY_QUANTITY_TYPE="+String.valueOf(INVENTORY_QUANTITY_TYPE));
		sb.append(",DERIVED_VALUES_DIRECTIVE="+String.valueOf(DERIVED_VALUES_DIRECTIVE));
		sb.append(",PRESSURE="+String.valueOf(PRESSURE));
		sb.append(",METER_PRESET_CODE="+METER_PRESET_CODE);
		sb.append(",CALCULATE_NET="+String.valueOf(CALCULATE_NET));
		sb.append(",NON_RECIPE_WEIGHT_IN_VAC="+String.valueOf(NON_RECIPE_WEIGHT_IN_VAC));
		sb.append(",ADJUSTMENT_BATCH="+String.valueOf(ADJUSTMENT_BATCH));
		sb.append(",COMPARTMENT_OWNER_ID="+String.valueOf(COMPARTMENT_OWNER_ID));
		sb.append(",COMPARTMENT_CONTAINER_CODE="+COMPARTMENT_CONTAINER_CODE);
		sb.append(",COMPARTMENT_CONTAINER_TYPE="+String.valueOf(COMPARTMENT_CONTAINER_TYPE));
		sb.append(",COMPARTMENT_NUMBER="+String.valueOf(COMPARTMENT_NUMBER));
		sb.append(",PDXR_LOADING_REF="+PDXR_LOADING_REF);
		sb.append(",BLEND_CORRECTION_METHOD="+String.valueOf(BLEND_CORRECTION_METHOD));
		sb.append(",BLEND_CORRECTION_NET_VOLUME="+String.valueOf(BLEND_CORRECTION_NET_VOLUME));
		sb.append(",TOTAL_BATCH_BLEND_NET_VOLUME="+String.valueOf(TOTAL_BATCH_BLEND_NET_VOLUME));
		sb.append(",BLEND_CORRECTION_SOURCE="+String.valueOf(BLEND_CORRECTION_SOURCE));
		sb.append(",COMMODITY_GROUP="+String.valueOf(COMMODITY_GROUP));
		sb.append(",DERIVATION_STATUS="+String.valueOf(DERIVATION_STATUS));
		sb.append(",DERIVED_VALUES_ERROR="+DERIVED_VALUES_ERROR);
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
    final static byte[] commonByteArrayLock_PGS_STAGE_DIM_ORDER_RECIPE = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_DIM_ORDER_RECIPE = new byte[0];

	
			    public int ORDER_ID;

				public int getORDER_ID () {
					return this.ORDER_ID;
				}
				
			    public int COMPARTMENT_ID;

				public int getCOMPARTMENT_ID () {
					return this.COMPARTMENT_ID;
				}
				
			    public int ORDER_RECIPE_ID;

				public int getORDER_RECIPE_ID () {
					return this.ORDER_RECIPE_ID;
				}
				
			    public String BAY_CODE;

				public String getBAY_CODE () {
					return this.BAY_CODE;
				}
				
			    public String API_CODE;

				public String getAPI_CODE () {
					return this.API_CODE;
				}
				
			    public String INJECTOR_PRESET_CODE;

				public String getINJECTOR_PRESET_CODE () {
					return this.INJECTOR_PRESET_CODE;
				}
				
			    public String TARE_SCALE_INTERFACE_CODE;

				public String getTARE_SCALE_INTERFACE_CODE () {
					return this.TARE_SCALE_INTERFACE_CODE;
				}
				
			    public String TANK_CODE;

				public String getTANK_CODE () {
					return this.TANK_CODE;
				}
				
			    public String PRODUCT_GROUP_CODE;

				public String getPRODUCT_GROUP_CODE () {
					return this.PRODUCT_GROUP_CODE;
				}
				
			    public String INJECTOR_CODE;

				public String getINJECTOR_CODE () {
					return this.INJECTOR_CODE;
				}
				
			    public String METER_CODE;

				public String getMETER_CODE () {
					return this.METER_CODE;
				}
				
			    public Integer SUPPLIER_NUMBER;

				public Integer getSUPPLIER_NUMBER () {
					return this.SUPPLIER_NUMBER;
				}
				
			    public int TERMINAL_PRODUCT_NUMBER;

				public int getTERMINAL_PRODUCT_NUMBER () {
					return this.TERMINAL_PRODUCT_NUMBER;
				}
				
			    public int TERMINAL_PRODUCT_TYPE;

				public int getTERMINAL_PRODUCT_TYPE () {
					return this.TERMINAL_PRODUCT_TYPE;
				}
				
			    public String SHOST_SI_HOST_PRODUCT_NUMBER;

				public String getSHOST_SI_HOST_PRODUCT_NUMBER () {
					return this.SHOST_SI_HOST_PRODUCT_NUMBER;
				}
				
			    public double BLEND_PERCENT;

				public double getBLEND_PERCENT () {
					return this.BLEND_PERCENT;
				}
				
			    public int RATE;

				public int getRATE () {
					return this.RATE;
				}
				
			    public String THOST_TI_HOST_PRODUCT_NUMBER;

				public String getTHOST_TI_HOST_PRODUCT_NUMBER () {
					return this.THOST_TI_HOST_PRODUCT_NUMBER;
				}
				
			    public int ORDERED_QUANTITY;

				public int getORDERED_QUANTITY () {
					return this.ORDERED_QUANTITY;
				}
				
			    public int OVERRIDE_TEMPERATURE_ENABLE;

				public int getOVERRIDE_TEMPERATURE_ENABLE () {
					return this.OVERRIDE_TEMPERATURE_ENABLE;
				}
				
			    public int GROSS_QUANTITY;

				public int getGROSS_QUANTITY () {
					return this.GROSS_QUANTITY;
				}
				
			    public int WEIGHT;

				public int getWEIGHT () {
					return this.WEIGHT;
				}
				
			    public int NET_QUANTITY;

				public int getNET_QUANTITY () {
					return this.NET_QUANTITY;
				}
				
			    public double DENSITY;

				public double getDENSITY () {
					return this.DENSITY;
				}
				
			    public int CUSTOMER_NET_QUANTITY;

				public int getCUSTOMER_NET_QUANTITY () {
					return this.CUSTOMER_NET_QUANTITY;
				}
				
			    public double SPECIFIC_GRAVITY;

				public double getSPECIFIC_GRAVITY () {
					return this.SPECIFIC_GRAVITY;
				}
				
			    public double COEFFICIENT_EXPANSION;

				public double getCOEFFICIENT_EXPANSION () {
					return this.COEFFICIENT_EXPANSION;
				}
				
			    public double TEMPERATURE;

				public double getTEMPERATURE () {
					return this.TEMPERATURE;
				}
				
			    public double RVP;

				public double getRVP () {
					return this.RVP;
				}
				
			    public double OXYGEN;

				public double getOXYGEN () {
					return this.OXYGEN;
				}
				
			    public int START_GROSS_TOTALIZER;

				public int getSTART_GROSS_TOTALIZER () {
					return this.START_GROSS_TOTALIZER;
				}
				
			    public int END_GROSS_TOTALIZER;

				public int getEND_GROSS_TOTALIZER () {
					return this.END_GROSS_TOTALIZER;
				}
				
			    public int START_NET_TOTALIZER;

				public int getSTART_NET_TOTALIZER () {
					return this.START_NET_TOTALIZER;
				}
				
			    public int END_NET_TOTALIZER;

				public int getEND_NET_TOTALIZER () {
					return this.END_NET_TOTALIZER;
				}
				
			    public int START_WEIGHT;

				public int getSTART_WEIGHT () {
					return this.START_WEIGHT;
				}
				
			    public int END_WEIGHT;

				public int getEND_WEIGHT () {
					return this.END_WEIGHT;
				}
				
			    public String LAST_USER_NAME;

				public String getLAST_USER_NAME () {
					return this.LAST_USER_NAME;
				}
				
			    public java.util.Date LAST_MODIFIED;

				public java.util.Date getLAST_MODIFIED () {
					return this.LAST_MODIFIED;
				}
				
			    public java.util.Date START_TIME;

				public java.util.Date getSTART_TIME () {
					return this.START_TIME;
				}
				
			    public java.util.Date END_TIME;

				public java.util.Date getEND_TIME () {
					return this.END_TIME;
				}
				
			    public int ADDITIVE_QUANTITY;

				public int getADDITIVE_QUANTITY () {
					return this.ADDITIVE_QUANTITY;
				}
				
			    public int PRODUCT_QUANTITY;

				public int getPRODUCT_QUANTITY () {
					return this.PRODUCT_QUANTITY;
				}
				
			    public String HOST_PRODUCT_CODE;

				public String getHOST_PRODUCT_CODE () {
					return this.HOST_PRODUCT_CODE;
				}
				
			    public String HOST_PRODUCT_NAME;

				public String getHOST_PRODUCT_NAME () {
					return this.HOST_PRODUCT_NAME;
				}
				
			    public int FROM_LEFT_ON_TRUCK;

				public int getFROM_LEFT_ON_TRUCK () {
					return this.FROM_LEFT_ON_TRUCK;
				}
				
			    public double OBSERVED_DENSITY;

				public double getOBSERVED_DENSITY () {
					return this.OBSERVED_DENSITY;
				}
				
			    public int COMPONENT_ID;

				public int getCOMPONENT_ID () {
					return this.COMPONENT_ID;
				}
				
			    public int CALCULATE_SECONDARY_UNITS;

				public int getCALCULATE_SECONDARY_UNITS () {
					return this.CALCULATE_SECONDARY_UNITS;
				}
				
			    public String FINAL_SCALE_INTERFACE_CODE;

				public String getFINAL_SCALE_INTERFACE_CODE () {
					return this.FINAL_SCALE_INTERFACE_CODE;
				}
				
			    public int FRAC_START_GROSS_TOTALIZER;

				public int getFRAC_START_GROSS_TOTALIZER () {
					return this.FRAC_START_GROSS_TOTALIZER;
				}
				
			    public int FRAC_END_GROSS_TOTALIZER;

				public int getFRAC_END_GROSS_TOTALIZER () {
					return this.FRAC_END_GROSS_TOTALIZER;
				}
				
			    public String PETROEX_COMPONENT_PRODUCT_CODE;

				public String getPETROEX_COMPONENT_PRODUCT_CODE () {
					return this.PETROEX_COMPONENT_PRODUCT_CODE;
				}
				
			    public int PRODUCT_TOLERANCE_STATUS;

				public int getPRODUCT_TOLERANCE_STATUS () {
					return this.PRODUCT_TOLERANCE_STATUS;
				}
				
			    public int TANK_INVENTORY_UPDATED;

				public int getTANK_INVENTORY_UPDATED () {
					return this.TANK_INVENTORY_UPDATED;
				}
				
			    public int TOTALIZER_UPDATED;

				public int getTOTALIZER_UPDATED () {
					return this.TOTALIZER_UPDATED;
				}
				
			    public int FLUSH_STATUS;

				public int getFLUSH_STATUS () {
					return this.FLUSH_STATUS;
				}
				
			    public Integer REDUCED_PRODUCT_NUMBER;

				public Integer getREDUCED_PRODUCT_NUMBER () {
					return this.REDUCED_PRODUCT_NUMBER;
				}
				
			    public int ADDITIVE_WEIGHT;

				public int getADDITIVE_WEIGHT () {
					return this.ADDITIVE_WEIGHT;
				}
				
			    public int PRODUCT_WEIGHT;

				public int getPRODUCT_WEIGHT () {
					return this.PRODUCT_WEIGHT;
				}
				
			    public int RT_INJECTOR_ALARM_COUNT;

				public int getRT_INJECTOR_ALARM_COUNT () {
					return this.RT_INJECTOR_ALARM_COUNT;
				}
				
			    public int BATCH_NUMBER;

				public int getBATCH_NUMBER () {
					return this.BATCH_NUMBER;
				}
				
			    public String VRU_CODE;

				public String getVRU_CODE () {
					return this.VRU_CODE;
				}
				
			    public int ADDITIVE_MASKING;

				public int getADDITIVE_MASKING () {
					return this.ADDITIVE_MASKING;
				}
				
			    public int COMPATIBILITY_STATUS;

				public int getCOMPATIBILITY_STATUS () {
					return this.COMPATIBILITY_STATUS;
				}
				
			    public int RECIPE_CORRECTION_TYPE;

				public int getRECIPE_CORRECTION_TYPE () {
					return this.RECIPE_CORRECTION_TYPE;
				}
				
			    public int NON_RECIPE_GROSS_QUANTITY;

				public int getNON_RECIPE_GROSS_QUANTITY () {
					return this.NON_RECIPE_GROSS_QUANTITY;
				}
				
			    public int NON_RECIPE_NET_QUANTITY;

				public int getNON_RECIPE_NET_QUANTITY () {
					return this.NON_RECIPE_NET_QUANTITY;
				}
				
			    public int NON_RECIPE_WEIGHT;

				public int getNON_RECIPE_WEIGHT () {
					return this.NON_RECIPE_WEIGHT;
				}
				
			    public int WEIGHT_IN_VAC;

				public int getWEIGHT_IN_VAC () {
					return this.WEIGHT_IN_VAC;
				}
				
			    public int ADDITIVE_WEIGHT_IN_VAC;

				public int getADDITIVE_WEIGHT_IN_VAC () {
					return this.ADDITIVE_WEIGHT_IN_VAC;
				}
				
			    public int COMMITTED_GROSS_QUANTITY;

				public int getCOMMITTED_GROSS_QUANTITY () {
					return this.COMMITTED_GROSS_QUANTITY;
				}
				
			    public int PRODUCT_WEIGHT_IN_VAC;

				public int getPRODUCT_WEIGHT_IN_VAC () {
					return this.PRODUCT_WEIGHT_IN_VAC;
				}
				
			    public int COMMITTED_NET_QUANTITY;

				public int getCOMMITTED_NET_QUANTITY () {
					return this.COMMITTED_NET_QUANTITY;
				}
				
			    public String PDXR_PRODUCT_CODE;

				public String getPDXR_PRODUCT_CODE () {
					return this.PDXR_PRODUCT_CODE;
				}
				
			    public int PDXR_AUTHORIZATION_UNITS;

				public int getPDXR_AUTHORIZATION_UNITS () {
					return this.PDXR_AUTHORIZATION_UNITS;
				}
				
			    public int COMMITTED_WEIGHT_IN_VAC;

				public int getCOMMITTED_WEIGHT_IN_VAC () {
					return this.COMMITTED_WEIGHT_IN_VAC;
				}
				
			    public int COMMITTED_WEIGHT_IN_AIR;

				public int getCOMMITTED_WEIGHT_IN_AIR () {
					return this.COMMITTED_WEIGHT_IN_AIR;
				}
				
			    public String PDXR_ADDITIVE_CODE;

				public String getPDXR_ADDITIVE_CODE () {
					return this.PDXR_ADDITIVE_CODE;
				}
				
			    public double COMMITTED_CONV_TEMPERATURE;

				public double getCOMMITTED_CONV_TEMPERATURE () {
					return this.COMMITTED_CONV_TEMPERATURE;
				}
				
			    public double COMMITTED_CONV_DENSITY;

				public double getCOMMITTED_CONV_DENSITY () {
					return this.COMMITTED_CONV_DENSITY;
				}
				
			    public double COMMITTED_CONV_COE;

				public double getCOMMITTED_CONV_COE () {
					return this.COMMITTED_CONV_COE;
				}
				
			    public double COMMITTED_CONV_PRESSURE;

				public double getCOMMITTED_CONV_PRESSURE () {
					return this.COMMITTED_CONV_PRESSURE;
				}
				
			    public int MEASURED_QUANTITY_TYPE;

				public int getMEASURED_QUANTITY_TYPE () {
					return this.MEASURED_QUANTITY_TYPE;
				}
				
			    public int INVENTORY_QUANTITY_TYPE;

				public int getINVENTORY_QUANTITY_TYPE () {
					return this.INVENTORY_QUANTITY_TYPE;
				}
				
			    public int DERIVED_VALUES_DIRECTIVE;

				public int getDERIVED_VALUES_DIRECTIVE () {
					return this.DERIVED_VALUES_DIRECTIVE;
				}
				
			    public double PRESSURE;

				public double getPRESSURE () {
					return this.PRESSURE;
				}
				
			    public String METER_PRESET_CODE;

				public String getMETER_PRESET_CODE () {
					return this.METER_PRESET_CODE;
				}
				
			    public int CALCULATE_NET;

				public int getCALCULATE_NET () {
					return this.CALCULATE_NET;
				}
				
			    public int NON_RECIPE_WEIGHT_IN_VAC;

				public int getNON_RECIPE_WEIGHT_IN_VAC () {
					return this.NON_RECIPE_WEIGHT_IN_VAC;
				}
				
			    public int ADJUSTMENT_BATCH;

				public int getADJUSTMENT_BATCH () {
					return this.ADJUSTMENT_BATCH;
				}
				
			    public Integer COMPARTMENT_OWNER_ID;

				public Integer getCOMPARTMENT_OWNER_ID () {
					return this.COMPARTMENT_OWNER_ID;
				}
				
			    public String COMPARTMENT_CONTAINER_CODE;

				public String getCOMPARTMENT_CONTAINER_CODE () {
					return this.COMPARTMENT_CONTAINER_CODE;
				}
				
			    public Integer COMPARTMENT_CONTAINER_TYPE;

				public Integer getCOMPARTMENT_CONTAINER_TYPE () {
					return this.COMPARTMENT_CONTAINER_TYPE;
				}
				
			    public Integer COMPARTMENT_NUMBER;

				public Integer getCOMPARTMENT_NUMBER () {
					return this.COMPARTMENT_NUMBER;
				}
				
			    public String PDXR_LOADING_REF;

				public String getPDXR_LOADING_REF () {
					return this.PDXR_LOADING_REF;
				}
				
			    public int BLEND_CORRECTION_METHOD;

				public int getBLEND_CORRECTION_METHOD () {
					return this.BLEND_CORRECTION_METHOD;
				}
				
			    public double BLEND_CORRECTION_NET_VOLUME;

				public double getBLEND_CORRECTION_NET_VOLUME () {
					return this.BLEND_CORRECTION_NET_VOLUME;
				}
				
			    public double TOTAL_BATCH_BLEND_NET_VOLUME;

				public double getTOTAL_BATCH_BLEND_NET_VOLUME () {
					return this.TOTAL_BATCH_BLEND_NET_VOLUME;
				}
				
			    public int BLEND_CORRECTION_SOURCE;

				public int getBLEND_CORRECTION_SOURCE () {
					return this.BLEND_CORRECTION_SOURCE;
				}
				
			    public int COMMODITY_GROUP;

				public int getCOMMODITY_GROUP () {
					return this.COMMODITY_GROUP;
				}
				
			    public int DERIVATION_STATUS;

				public int getDERIVATION_STATUS () {
					return this.DERIVATION_STATUS;
				}
				
			    public String DERIVED_VALUES_ERROR;

				public String getDERIVED_VALUES_ERROR () {
					return this.DERIVED_VALUES_ERROR;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PGS_STAGE_DIM_ORDER_RECIPE.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_ORDER_RECIPE.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_ORDER_RECIPE = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_ORDER_RECIPE = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PGS_STAGE_DIM_ORDER_RECIPE, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_ORDER_RECIPE, 0, length, utf8Charset);
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
			if(length > commonByteArray_PGS_STAGE_DIM_ORDER_RECIPE.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_ORDER_RECIPE.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_ORDER_RECIPE = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_ORDER_RECIPE = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PGS_STAGE_DIM_ORDER_RECIPE, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_ORDER_RECIPE, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_ORDER_RECIPE) {

        	try {

        		int length = 0;
		
			        this.ORDER_ID = dis.readInt();
					
			        this.COMPARTMENT_ID = dis.readInt();
					
			        this.ORDER_RECIPE_ID = dis.readInt();
					
					this.BAY_CODE = readString(dis);
					
					this.API_CODE = readString(dis);
					
					this.INJECTOR_PRESET_CODE = readString(dis);
					
					this.TARE_SCALE_INTERFACE_CODE = readString(dis);
					
					this.TANK_CODE = readString(dis);
					
					this.PRODUCT_GROUP_CODE = readString(dis);
					
					this.INJECTOR_CODE = readString(dis);
					
					this.METER_CODE = readString(dis);
					
						this.SUPPLIER_NUMBER = readInteger(dis);
					
			        this.TERMINAL_PRODUCT_NUMBER = dis.readInt();
					
			        this.TERMINAL_PRODUCT_TYPE = dis.readInt();
					
					this.SHOST_SI_HOST_PRODUCT_NUMBER = readString(dis);
					
			        this.BLEND_PERCENT = dis.readDouble();
					
			        this.RATE = dis.readInt();
					
					this.THOST_TI_HOST_PRODUCT_NUMBER = readString(dis);
					
			        this.ORDERED_QUANTITY = dis.readInt();
					
			        this.OVERRIDE_TEMPERATURE_ENABLE = dis.readInt();
					
			        this.GROSS_QUANTITY = dis.readInt();
					
			        this.WEIGHT = dis.readInt();
					
			        this.NET_QUANTITY = dis.readInt();
					
			        this.DENSITY = dis.readDouble();
					
			        this.CUSTOMER_NET_QUANTITY = dis.readInt();
					
			        this.SPECIFIC_GRAVITY = dis.readDouble();
					
			        this.COEFFICIENT_EXPANSION = dis.readDouble();
					
			        this.TEMPERATURE = dis.readDouble();
					
			        this.RVP = dis.readDouble();
					
			        this.OXYGEN = dis.readDouble();
					
			        this.START_GROSS_TOTALIZER = dis.readInt();
					
			        this.END_GROSS_TOTALIZER = dis.readInt();
					
			        this.START_NET_TOTALIZER = dis.readInt();
					
			        this.END_NET_TOTALIZER = dis.readInt();
					
			        this.START_WEIGHT = dis.readInt();
					
			        this.END_WEIGHT = dis.readInt();
					
					this.LAST_USER_NAME = readString(dis);
					
					this.LAST_MODIFIED = readDate(dis);
					
					this.START_TIME = readDate(dis);
					
					this.END_TIME = readDate(dis);
					
			        this.ADDITIVE_QUANTITY = dis.readInt();
					
			        this.PRODUCT_QUANTITY = dis.readInt();
					
					this.HOST_PRODUCT_CODE = readString(dis);
					
					this.HOST_PRODUCT_NAME = readString(dis);
					
			        this.FROM_LEFT_ON_TRUCK = dis.readInt();
					
			        this.OBSERVED_DENSITY = dis.readDouble();
					
			        this.COMPONENT_ID = dis.readInt();
					
			        this.CALCULATE_SECONDARY_UNITS = dis.readInt();
					
					this.FINAL_SCALE_INTERFACE_CODE = readString(dis);
					
			        this.FRAC_START_GROSS_TOTALIZER = dis.readInt();
					
			        this.FRAC_END_GROSS_TOTALIZER = dis.readInt();
					
					this.PETROEX_COMPONENT_PRODUCT_CODE = readString(dis);
					
			        this.PRODUCT_TOLERANCE_STATUS = dis.readInt();
					
			        this.TANK_INVENTORY_UPDATED = dis.readInt();
					
			        this.TOTALIZER_UPDATED = dis.readInt();
					
			        this.FLUSH_STATUS = dis.readInt();
					
						this.REDUCED_PRODUCT_NUMBER = readInteger(dis);
					
			        this.ADDITIVE_WEIGHT = dis.readInt();
					
			        this.PRODUCT_WEIGHT = dis.readInt();
					
			        this.RT_INJECTOR_ALARM_COUNT = dis.readInt();
					
			        this.BATCH_NUMBER = dis.readInt();
					
					this.VRU_CODE = readString(dis);
					
			        this.ADDITIVE_MASKING = dis.readInt();
					
			        this.COMPATIBILITY_STATUS = dis.readInt();
					
			        this.RECIPE_CORRECTION_TYPE = dis.readInt();
					
			        this.NON_RECIPE_GROSS_QUANTITY = dis.readInt();
					
			        this.NON_RECIPE_NET_QUANTITY = dis.readInt();
					
			        this.NON_RECIPE_WEIGHT = dis.readInt();
					
			        this.WEIGHT_IN_VAC = dis.readInt();
					
			        this.ADDITIVE_WEIGHT_IN_VAC = dis.readInt();
					
			        this.COMMITTED_GROSS_QUANTITY = dis.readInt();
					
			        this.PRODUCT_WEIGHT_IN_VAC = dis.readInt();
					
			        this.COMMITTED_NET_QUANTITY = dis.readInt();
					
					this.PDXR_PRODUCT_CODE = readString(dis);
					
			        this.PDXR_AUTHORIZATION_UNITS = dis.readInt();
					
			        this.COMMITTED_WEIGHT_IN_VAC = dis.readInt();
					
			        this.COMMITTED_WEIGHT_IN_AIR = dis.readInt();
					
					this.PDXR_ADDITIVE_CODE = readString(dis);
					
			        this.COMMITTED_CONV_TEMPERATURE = dis.readDouble();
					
			        this.COMMITTED_CONV_DENSITY = dis.readDouble();
					
			        this.COMMITTED_CONV_COE = dis.readDouble();
					
			        this.COMMITTED_CONV_PRESSURE = dis.readDouble();
					
			        this.MEASURED_QUANTITY_TYPE = dis.readInt();
					
			        this.INVENTORY_QUANTITY_TYPE = dis.readInt();
					
			        this.DERIVED_VALUES_DIRECTIVE = dis.readInt();
					
			        this.PRESSURE = dis.readDouble();
					
					this.METER_PRESET_CODE = readString(dis);
					
			        this.CALCULATE_NET = dis.readInt();
					
			        this.NON_RECIPE_WEIGHT_IN_VAC = dis.readInt();
					
			        this.ADJUSTMENT_BATCH = dis.readInt();
					
						this.COMPARTMENT_OWNER_ID = readInteger(dis);
					
					this.COMPARTMENT_CONTAINER_CODE = readString(dis);
					
						this.COMPARTMENT_CONTAINER_TYPE = readInteger(dis);
					
						this.COMPARTMENT_NUMBER = readInteger(dis);
					
					this.PDXR_LOADING_REF = readString(dis);
					
			        this.BLEND_CORRECTION_METHOD = dis.readInt();
					
			        this.BLEND_CORRECTION_NET_VOLUME = dis.readDouble();
					
			        this.TOTAL_BATCH_BLEND_NET_VOLUME = dis.readDouble();
					
			        this.BLEND_CORRECTION_SOURCE = dis.readInt();
					
			        this.COMMODITY_GROUP = dis.readInt();
					
			        this.DERIVATION_STATUS = dis.readInt();
					
					this.DERIVED_VALUES_ERROR = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_ORDER_RECIPE) {

        	try {

        		int length = 0;
		
			        this.ORDER_ID = dis.readInt();
					
			        this.COMPARTMENT_ID = dis.readInt();
					
			        this.ORDER_RECIPE_ID = dis.readInt();
					
					this.BAY_CODE = readString(dis);
					
					this.API_CODE = readString(dis);
					
					this.INJECTOR_PRESET_CODE = readString(dis);
					
					this.TARE_SCALE_INTERFACE_CODE = readString(dis);
					
					this.TANK_CODE = readString(dis);
					
					this.PRODUCT_GROUP_CODE = readString(dis);
					
					this.INJECTOR_CODE = readString(dis);
					
					this.METER_CODE = readString(dis);
					
						this.SUPPLIER_NUMBER = readInteger(dis);
					
			        this.TERMINAL_PRODUCT_NUMBER = dis.readInt();
					
			        this.TERMINAL_PRODUCT_TYPE = dis.readInt();
					
					this.SHOST_SI_HOST_PRODUCT_NUMBER = readString(dis);
					
			        this.BLEND_PERCENT = dis.readDouble();
					
			        this.RATE = dis.readInt();
					
					this.THOST_TI_HOST_PRODUCT_NUMBER = readString(dis);
					
			        this.ORDERED_QUANTITY = dis.readInt();
					
			        this.OVERRIDE_TEMPERATURE_ENABLE = dis.readInt();
					
			        this.GROSS_QUANTITY = dis.readInt();
					
			        this.WEIGHT = dis.readInt();
					
			        this.NET_QUANTITY = dis.readInt();
					
			        this.DENSITY = dis.readDouble();
					
			        this.CUSTOMER_NET_QUANTITY = dis.readInt();
					
			        this.SPECIFIC_GRAVITY = dis.readDouble();
					
			        this.COEFFICIENT_EXPANSION = dis.readDouble();
					
			        this.TEMPERATURE = dis.readDouble();
					
			        this.RVP = dis.readDouble();
					
			        this.OXYGEN = dis.readDouble();
					
			        this.START_GROSS_TOTALIZER = dis.readInt();
					
			        this.END_GROSS_TOTALIZER = dis.readInt();
					
			        this.START_NET_TOTALIZER = dis.readInt();
					
			        this.END_NET_TOTALIZER = dis.readInt();
					
			        this.START_WEIGHT = dis.readInt();
					
			        this.END_WEIGHT = dis.readInt();
					
					this.LAST_USER_NAME = readString(dis);
					
					this.LAST_MODIFIED = readDate(dis);
					
					this.START_TIME = readDate(dis);
					
					this.END_TIME = readDate(dis);
					
			        this.ADDITIVE_QUANTITY = dis.readInt();
					
			        this.PRODUCT_QUANTITY = dis.readInt();
					
					this.HOST_PRODUCT_CODE = readString(dis);
					
					this.HOST_PRODUCT_NAME = readString(dis);
					
			        this.FROM_LEFT_ON_TRUCK = dis.readInt();
					
			        this.OBSERVED_DENSITY = dis.readDouble();
					
			        this.COMPONENT_ID = dis.readInt();
					
			        this.CALCULATE_SECONDARY_UNITS = dis.readInt();
					
					this.FINAL_SCALE_INTERFACE_CODE = readString(dis);
					
			        this.FRAC_START_GROSS_TOTALIZER = dis.readInt();
					
			        this.FRAC_END_GROSS_TOTALIZER = dis.readInt();
					
					this.PETROEX_COMPONENT_PRODUCT_CODE = readString(dis);
					
			        this.PRODUCT_TOLERANCE_STATUS = dis.readInt();
					
			        this.TANK_INVENTORY_UPDATED = dis.readInt();
					
			        this.TOTALIZER_UPDATED = dis.readInt();
					
			        this.FLUSH_STATUS = dis.readInt();
					
						this.REDUCED_PRODUCT_NUMBER = readInteger(dis);
					
			        this.ADDITIVE_WEIGHT = dis.readInt();
					
			        this.PRODUCT_WEIGHT = dis.readInt();
					
			        this.RT_INJECTOR_ALARM_COUNT = dis.readInt();
					
			        this.BATCH_NUMBER = dis.readInt();
					
					this.VRU_CODE = readString(dis);
					
			        this.ADDITIVE_MASKING = dis.readInt();
					
			        this.COMPATIBILITY_STATUS = dis.readInt();
					
			        this.RECIPE_CORRECTION_TYPE = dis.readInt();
					
			        this.NON_RECIPE_GROSS_QUANTITY = dis.readInt();
					
			        this.NON_RECIPE_NET_QUANTITY = dis.readInt();
					
			        this.NON_RECIPE_WEIGHT = dis.readInt();
					
			        this.WEIGHT_IN_VAC = dis.readInt();
					
			        this.ADDITIVE_WEIGHT_IN_VAC = dis.readInt();
					
			        this.COMMITTED_GROSS_QUANTITY = dis.readInt();
					
			        this.PRODUCT_WEIGHT_IN_VAC = dis.readInt();
					
			        this.COMMITTED_NET_QUANTITY = dis.readInt();
					
					this.PDXR_PRODUCT_CODE = readString(dis);
					
			        this.PDXR_AUTHORIZATION_UNITS = dis.readInt();
					
			        this.COMMITTED_WEIGHT_IN_VAC = dis.readInt();
					
			        this.COMMITTED_WEIGHT_IN_AIR = dis.readInt();
					
					this.PDXR_ADDITIVE_CODE = readString(dis);
					
			        this.COMMITTED_CONV_TEMPERATURE = dis.readDouble();
					
			        this.COMMITTED_CONV_DENSITY = dis.readDouble();
					
			        this.COMMITTED_CONV_COE = dis.readDouble();
					
			        this.COMMITTED_CONV_PRESSURE = dis.readDouble();
					
			        this.MEASURED_QUANTITY_TYPE = dis.readInt();
					
			        this.INVENTORY_QUANTITY_TYPE = dis.readInt();
					
			        this.DERIVED_VALUES_DIRECTIVE = dis.readInt();
					
			        this.PRESSURE = dis.readDouble();
					
					this.METER_PRESET_CODE = readString(dis);
					
			        this.CALCULATE_NET = dis.readInt();
					
			        this.NON_RECIPE_WEIGHT_IN_VAC = dis.readInt();
					
			        this.ADJUSTMENT_BATCH = dis.readInt();
					
						this.COMPARTMENT_OWNER_ID = readInteger(dis);
					
					this.COMPARTMENT_CONTAINER_CODE = readString(dis);
					
						this.COMPARTMENT_CONTAINER_TYPE = readInteger(dis);
					
						this.COMPARTMENT_NUMBER = readInteger(dis);
					
					this.PDXR_LOADING_REF = readString(dis);
					
			        this.BLEND_CORRECTION_METHOD = dis.readInt();
					
			        this.BLEND_CORRECTION_NET_VOLUME = dis.readDouble();
					
			        this.TOTAL_BATCH_BLEND_NET_VOLUME = dis.readDouble();
					
			        this.BLEND_CORRECTION_SOURCE = dis.readInt();
					
			        this.COMMODITY_GROUP = dis.readInt();
					
			        this.DERIVATION_STATUS = dis.readInt();
					
					this.DERIVED_VALUES_ERROR = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.ORDER_ID);
					
					// int
				
		            	dos.writeInt(this.COMPARTMENT_ID);
					
					// int
				
		            	dos.writeInt(this.ORDER_RECIPE_ID);
					
					// String
				
						writeString(this.BAY_CODE,dos);
					
					// String
				
						writeString(this.API_CODE,dos);
					
					// String
				
						writeString(this.INJECTOR_PRESET_CODE,dos);
					
					// String
				
						writeString(this.TARE_SCALE_INTERFACE_CODE,dos);
					
					// String
				
						writeString(this.TANK_CODE,dos);
					
					// String
				
						writeString(this.PRODUCT_GROUP_CODE,dos);
					
					// String
				
						writeString(this.INJECTOR_CODE,dos);
					
					// String
				
						writeString(this.METER_CODE,dos);
					
					// Integer
				
						writeInteger(this.SUPPLIER_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.TERMINAL_PRODUCT_NUMBER);
					
					// int
				
		            	dos.writeInt(this.TERMINAL_PRODUCT_TYPE);
					
					// String
				
						writeString(this.SHOST_SI_HOST_PRODUCT_NUMBER,dos);
					
					// double
				
		            	dos.writeDouble(this.BLEND_PERCENT);
					
					// int
				
		            	dos.writeInt(this.RATE);
					
					// String
				
						writeString(this.THOST_TI_HOST_PRODUCT_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.ORDERED_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.OVERRIDE_TEMPERATURE_ENABLE);
					
					// int
				
		            	dos.writeInt(this.GROSS_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.WEIGHT);
					
					// int
				
		            	dos.writeInt(this.NET_QUANTITY);
					
					// double
				
		            	dos.writeDouble(this.DENSITY);
					
					// int
				
		            	dos.writeInt(this.CUSTOMER_NET_QUANTITY);
					
					// double
				
		            	dos.writeDouble(this.SPECIFIC_GRAVITY);
					
					// double
				
		            	dos.writeDouble(this.COEFFICIENT_EXPANSION);
					
					// double
				
		            	dos.writeDouble(this.TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.RVP);
					
					// double
				
		            	dos.writeDouble(this.OXYGEN);
					
					// int
				
		            	dos.writeInt(this.START_GROSS_TOTALIZER);
					
					// int
				
		            	dos.writeInt(this.END_GROSS_TOTALIZER);
					
					// int
				
		            	dos.writeInt(this.START_NET_TOTALIZER);
					
					// int
				
		            	dos.writeInt(this.END_NET_TOTALIZER);
					
					// int
				
		            	dos.writeInt(this.START_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.END_WEIGHT);
					
					// String
				
						writeString(this.LAST_USER_NAME,dos);
					
					// java.util.Date
				
						writeDate(this.LAST_MODIFIED,dos);
					
					// java.util.Date
				
						writeDate(this.START_TIME,dos);
					
					// java.util.Date
				
						writeDate(this.END_TIME,dos);
					
					// int
				
		            	dos.writeInt(this.ADDITIVE_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.PRODUCT_QUANTITY);
					
					// String
				
						writeString(this.HOST_PRODUCT_CODE,dos);
					
					// String
				
						writeString(this.HOST_PRODUCT_NAME,dos);
					
					// int
				
		            	dos.writeInt(this.FROM_LEFT_ON_TRUCK);
					
					// double
				
		            	dos.writeDouble(this.OBSERVED_DENSITY);
					
					// int
				
		            	dos.writeInt(this.COMPONENT_ID);
					
					// int
				
		            	dos.writeInt(this.CALCULATE_SECONDARY_UNITS);
					
					// String
				
						writeString(this.FINAL_SCALE_INTERFACE_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.FRAC_START_GROSS_TOTALIZER);
					
					// int
				
		            	dos.writeInt(this.FRAC_END_GROSS_TOTALIZER);
					
					// String
				
						writeString(this.PETROEX_COMPONENT_PRODUCT_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.PRODUCT_TOLERANCE_STATUS);
					
					// int
				
		            	dos.writeInt(this.TANK_INVENTORY_UPDATED);
					
					// int
				
		            	dos.writeInt(this.TOTALIZER_UPDATED);
					
					// int
				
		            	dos.writeInt(this.FLUSH_STATUS);
					
					// Integer
				
						writeInteger(this.REDUCED_PRODUCT_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.ADDITIVE_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.PRODUCT_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.RT_INJECTOR_ALARM_COUNT);
					
					// int
				
		            	dos.writeInt(this.BATCH_NUMBER);
					
					// String
				
						writeString(this.VRU_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.ADDITIVE_MASKING);
					
					// int
				
		            	dos.writeInt(this.COMPATIBILITY_STATUS);
					
					// int
				
		            	dos.writeInt(this.RECIPE_CORRECTION_TYPE);
					
					// int
				
		            	dos.writeInt(this.NON_RECIPE_GROSS_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.NON_RECIPE_NET_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.NON_RECIPE_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.ADDITIVE_WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.COMMITTED_GROSS_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.PRODUCT_WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.COMMITTED_NET_QUANTITY);
					
					// String
				
						writeString(this.PDXR_PRODUCT_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.PDXR_AUTHORIZATION_UNITS);
					
					// int
				
		            	dos.writeInt(this.COMMITTED_WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.COMMITTED_WEIGHT_IN_AIR);
					
					// String
				
						writeString(this.PDXR_ADDITIVE_CODE,dos);
					
					// double
				
		            	dos.writeDouble(this.COMMITTED_CONV_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.COMMITTED_CONV_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.COMMITTED_CONV_COE);
					
					// double
				
		            	dos.writeDouble(this.COMMITTED_CONV_PRESSURE);
					
					// int
				
		            	dos.writeInt(this.MEASURED_QUANTITY_TYPE);
					
					// int
				
		            	dos.writeInt(this.INVENTORY_QUANTITY_TYPE);
					
					// int
				
		            	dos.writeInt(this.DERIVED_VALUES_DIRECTIVE);
					
					// double
				
		            	dos.writeDouble(this.PRESSURE);
					
					// String
				
						writeString(this.METER_PRESET_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.CALCULATE_NET);
					
					// int
				
		            	dos.writeInt(this.NON_RECIPE_WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.ADJUSTMENT_BATCH);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_OWNER_ID,dos);
					
					// String
				
						writeString(this.COMPARTMENT_CONTAINER_CODE,dos);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_CONTAINER_TYPE,dos);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_NUMBER,dos);
					
					// String
				
						writeString(this.PDXR_LOADING_REF,dos);
					
					// int
				
		            	dos.writeInt(this.BLEND_CORRECTION_METHOD);
					
					// double
				
		            	dos.writeDouble(this.BLEND_CORRECTION_NET_VOLUME);
					
					// double
				
		            	dos.writeDouble(this.TOTAL_BATCH_BLEND_NET_VOLUME);
					
					// int
				
		            	dos.writeInt(this.BLEND_CORRECTION_SOURCE);
					
					// int
				
		            	dos.writeInt(this.COMMODITY_GROUP);
					
					// int
				
		            	dos.writeInt(this.DERIVATION_STATUS);
					
					// String
				
						writeString(this.DERIVED_VALUES_ERROR,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.ORDER_ID);
					
					// int
				
		            	dos.writeInt(this.COMPARTMENT_ID);
					
					// int
				
		            	dos.writeInt(this.ORDER_RECIPE_ID);
					
					// String
				
						writeString(this.BAY_CODE,dos);
					
					// String
				
						writeString(this.API_CODE,dos);
					
					// String
				
						writeString(this.INJECTOR_PRESET_CODE,dos);
					
					// String
				
						writeString(this.TARE_SCALE_INTERFACE_CODE,dos);
					
					// String
				
						writeString(this.TANK_CODE,dos);
					
					// String
				
						writeString(this.PRODUCT_GROUP_CODE,dos);
					
					// String
				
						writeString(this.INJECTOR_CODE,dos);
					
					// String
				
						writeString(this.METER_CODE,dos);
					
					// Integer
				
						writeInteger(this.SUPPLIER_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.TERMINAL_PRODUCT_NUMBER);
					
					// int
				
		            	dos.writeInt(this.TERMINAL_PRODUCT_TYPE);
					
					// String
				
						writeString(this.SHOST_SI_HOST_PRODUCT_NUMBER,dos);
					
					// double
				
		            	dos.writeDouble(this.BLEND_PERCENT);
					
					// int
				
		            	dos.writeInt(this.RATE);
					
					// String
				
						writeString(this.THOST_TI_HOST_PRODUCT_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.ORDERED_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.OVERRIDE_TEMPERATURE_ENABLE);
					
					// int
				
		            	dos.writeInt(this.GROSS_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.WEIGHT);
					
					// int
				
		            	dos.writeInt(this.NET_QUANTITY);
					
					// double
				
		            	dos.writeDouble(this.DENSITY);
					
					// int
				
		            	dos.writeInt(this.CUSTOMER_NET_QUANTITY);
					
					// double
				
		            	dos.writeDouble(this.SPECIFIC_GRAVITY);
					
					// double
				
		            	dos.writeDouble(this.COEFFICIENT_EXPANSION);
					
					// double
				
		            	dos.writeDouble(this.TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.RVP);
					
					// double
				
		            	dos.writeDouble(this.OXYGEN);
					
					// int
				
		            	dos.writeInt(this.START_GROSS_TOTALIZER);
					
					// int
				
		            	dos.writeInt(this.END_GROSS_TOTALIZER);
					
					// int
				
		            	dos.writeInt(this.START_NET_TOTALIZER);
					
					// int
				
		            	dos.writeInt(this.END_NET_TOTALIZER);
					
					// int
				
		            	dos.writeInt(this.START_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.END_WEIGHT);
					
					// String
				
						writeString(this.LAST_USER_NAME,dos);
					
					// java.util.Date
				
						writeDate(this.LAST_MODIFIED,dos);
					
					// java.util.Date
				
						writeDate(this.START_TIME,dos);
					
					// java.util.Date
				
						writeDate(this.END_TIME,dos);
					
					// int
				
		            	dos.writeInt(this.ADDITIVE_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.PRODUCT_QUANTITY);
					
					// String
				
						writeString(this.HOST_PRODUCT_CODE,dos);
					
					// String
				
						writeString(this.HOST_PRODUCT_NAME,dos);
					
					// int
				
		            	dos.writeInt(this.FROM_LEFT_ON_TRUCK);
					
					// double
				
		            	dos.writeDouble(this.OBSERVED_DENSITY);
					
					// int
				
		            	dos.writeInt(this.COMPONENT_ID);
					
					// int
				
		            	dos.writeInt(this.CALCULATE_SECONDARY_UNITS);
					
					// String
				
						writeString(this.FINAL_SCALE_INTERFACE_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.FRAC_START_GROSS_TOTALIZER);
					
					// int
				
		            	dos.writeInt(this.FRAC_END_GROSS_TOTALIZER);
					
					// String
				
						writeString(this.PETROEX_COMPONENT_PRODUCT_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.PRODUCT_TOLERANCE_STATUS);
					
					// int
				
		            	dos.writeInt(this.TANK_INVENTORY_UPDATED);
					
					// int
				
		            	dos.writeInt(this.TOTALIZER_UPDATED);
					
					// int
				
		            	dos.writeInt(this.FLUSH_STATUS);
					
					// Integer
				
						writeInteger(this.REDUCED_PRODUCT_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.ADDITIVE_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.PRODUCT_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.RT_INJECTOR_ALARM_COUNT);
					
					// int
				
		            	dos.writeInt(this.BATCH_NUMBER);
					
					// String
				
						writeString(this.VRU_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.ADDITIVE_MASKING);
					
					// int
				
		            	dos.writeInt(this.COMPATIBILITY_STATUS);
					
					// int
				
		            	dos.writeInt(this.RECIPE_CORRECTION_TYPE);
					
					// int
				
		            	dos.writeInt(this.NON_RECIPE_GROSS_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.NON_RECIPE_NET_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.NON_RECIPE_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.ADDITIVE_WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.COMMITTED_GROSS_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.PRODUCT_WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.COMMITTED_NET_QUANTITY);
					
					// String
				
						writeString(this.PDXR_PRODUCT_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.PDXR_AUTHORIZATION_UNITS);
					
					// int
				
		            	dos.writeInt(this.COMMITTED_WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.COMMITTED_WEIGHT_IN_AIR);
					
					// String
				
						writeString(this.PDXR_ADDITIVE_CODE,dos);
					
					// double
				
		            	dos.writeDouble(this.COMMITTED_CONV_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.COMMITTED_CONV_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.COMMITTED_CONV_COE);
					
					// double
				
		            	dos.writeDouble(this.COMMITTED_CONV_PRESSURE);
					
					// int
				
		            	dos.writeInt(this.MEASURED_QUANTITY_TYPE);
					
					// int
				
		            	dos.writeInt(this.INVENTORY_QUANTITY_TYPE);
					
					// int
				
		            	dos.writeInt(this.DERIVED_VALUES_DIRECTIVE);
					
					// double
				
		            	dos.writeDouble(this.PRESSURE);
					
					// String
				
						writeString(this.METER_PRESET_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.CALCULATE_NET);
					
					// int
				
		            	dos.writeInt(this.NON_RECIPE_WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.ADJUSTMENT_BATCH);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_OWNER_ID,dos);
					
					// String
				
						writeString(this.COMPARTMENT_CONTAINER_CODE,dos);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_CONTAINER_TYPE,dos);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_NUMBER,dos);
					
					// String
				
						writeString(this.PDXR_LOADING_REF,dos);
					
					// int
				
		            	dos.writeInt(this.BLEND_CORRECTION_METHOD);
					
					// double
				
		            	dos.writeDouble(this.BLEND_CORRECTION_NET_VOLUME);
					
					// double
				
		            	dos.writeDouble(this.TOTAL_BATCH_BLEND_NET_VOLUME);
					
					// int
				
		            	dos.writeInt(this.BLEND_CORRECTION_SOURCE);
					
					// int
				
		            	dos.writeInt(this.COMMODITY_GROUP);
					
					// int
				
		            	dos.writeInt(this.DERIVATION_STATUS);
					
					// String
				
						writeString(this.DERIVED_VALUES_ERROR,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("ORDER_ID="+String.valueOf(ORDER_ID));
		sb.append(",COMPARTMENT_ID="+String.valueOf(COMPARTMENT_ID));
		sb.append(",ORDER_RECIPE_ID="+String.valueOf(ORDER_RECIPE_ID));
		sb.append(",BAY_CODE="+BAY_CODE);
		sb.append(",API_CODE="+API_CODE);
		sb.append(",INJECTOR_PRESET_CODE="+INJECTOR_PRESET_CODE);
		sb.append(",TARE_SCALE_INTERFACE_CODE="+TARE_SCALE_INTERFACE_CODE);
		sb.append(",TANK_CODE="+TANK_CODE);
		sb.append(",PRODUCT_GROUP_CODE="+PRODUCT_GROUP_CODE);
		sb.append(",INJECTOR_CODE="+INJECTOR_CODE);
		sb.append(",METER_CODE="+METER_CODE);
		sb.append(",SUPPLIER_NUMBER="+String.valueOf(SUPPLIER_NUMBER));
		sb.append(",TERMINAL_PRODUCT_NUMBER="+String.valueOf(TERMINAL_PRODUCT_NUMBER));
		sb.append(",TERMINAL_PRODUCT_TYPE="+String.valueOf(TERMINAL_PRODUCT_TYPE));
		sb.append(",SHOST_SI_HOST_PRODUCT_NUMBER="+SHOST_SI_HOST_PRODUCT_NUMBER);
		sb.append(",BLEND_PERCENT="+String.valueOf(BLEND_PERCENT));
		sb.append(",RATE="+String.valueOf(RATE));
		sb.append(",THOST_TI_HOST_PRODUCT_NUMBER="+THOST_TI_HOST_PRODUCT_NUMBER);
		sb.append(",ORDERED_QUANTITY="+String.valueOf(ORDERED_QUANTITY));
		sb.append(",OVERRIDE_TEMPERATURE_ENABLE="+String.valueOf(OVERRIDE_TEMPERATURE_ENABLE));
		sb.append(",GROSS_QUANTITY="+String.valueOf(GROSS_QUANTITY));
		sb.append(",WEIGHT="+String.valueOf(WEIGHT));
		sb.append(",NET_QUANTITY="+String.valueOf(NET_QUANTITY));
		sb.append(",DENSITY="+String.valueOf(DENSITY));
		sb.append(",CUSTOMER_NET_QUANTITY="+String.valueOf(CUSTOMER_NET_QUANTITY));
		sb.append(",SPECIFIC_GRAVITY="+String.valueOf(SPECIFIC_GRAVITY));
		sb.append(",COEFFICIENT_EXPANSION="+String.valueOf(COEFFICIENT_EXPANSION));
		sb.append(",TEMPERATURE="+String.valueOf(TEMPERATURE));
		sb.append(",RVP="+String.valueOf(RVP));
		sb.append(",OXYGEN="+String.valueOf(OXYGEN));
		sb.append(",START_GROSS_TOTALIZER="+String.valueOf(START_GROSS_TOTALIZER));
		sb.append(",END_GROSS_TOTALIZER="+String.valueOf(END_GROSS_TOTALIZER));
		sb.append(",START_NET_TOTALIZER="+String.valueOf(START_NET_TOTALIZER));
		sb.append(",END_NET_TOTALIZER="+String.valueOf(END_NET_TOTALIZER));
		sb.append(",START_WEIGHT="+String.valueOf(START_WEIGHT));
		sb.append(",END_WEIGHT="+String.valueOf(END_WEIGHT));
		sb.append(",LAST_USER_NAME="+LAST_USER_NAME);
		sb.append(",LAST_MODIFIED="+String.valueOf(LAST_MODIFIED));
		sb.append(",START_TIME="+String.valueOf(START_TIME));
		sb.append(",END_TIME="+String.valueOf(END_TIME));
		sb.append(",ADDITIVE_QUANTITY="+String.valueOf(ADDITIVE_QUANTITY));
		sb.append(",PRODUCT_QUANTITY="+String.valueOf(PRODUCT_QUANTITY));
		sb.append(",HOST_PRODUCT_CODE="+HOST_PRODUCT_CODE);
		sb.append(",HOST_PRODUCT_NAME="+HOST_PRODUCT_NAME);
		sb.append(",FROM_LEFT_ON_TRUCK="+String.valueOf(FROM_LEFT_ON_TRUCK));
		sb.append(",OBSERVED_DENSITY="+String.valueOf(OBSERVED_DENSITY));
		sb.append(",COMPONENT_ID="+String.valueOf(COMPONENT_ID));
		sb.append(",CALCULATE_SECONDARY_UNITS="+String.valueOf(CALCULATE_SECONDARY_UNITS));
		sb.append(",FINAL_SCALE_INTERFACE_CODE="+FINAL_SCALE_INTERFACE_CODE);
		sb.append(",FRAC_START_GROSS_TOTALIZER="+String.valueOf(FRAC_START_GROSS_TOTALIZER));
		sb.append(",FRAC_END_GROSS_TOTALIZER="+String.valueOf(FRAC_END_GROSS_TOTALIZER));
		sb.append(",PETROEX_COMPONENT_PRODUCT_CODE="+PETROEX_COMPONENT_PRODUCT_CODE);
		sb.append(",PRODUCT_TOLERANCE_STATUS="+String.valueOf(PRODUCT_TOLERANCE_STATUS));
		sb.append(",TANK_INVENTORY_UPDATED="+String.valueOf(TANK_INVENTORY_UPDATED));
		sb.append(",TOTALIZER_UPDATED="+String.valueOf(TOTALIZER_UPDATED));
		sb.append(",FLUSH_STATUS="+String.valueOf(FLUSH_STATUS));
		sb.append(",REDUCED_PRODUCT_NUMBER="+String.valueOf(REDUCED_PRODUCT_NUMBER));
		sb.append(",ADDITIVE_WEIGHT="+String.valueOf(ADDITIVE_WEIGHT));
		sb.append(",PRODUCT_WEIGHT="+String.valueOf(PRODUCT_WEIGHT));
		sb.append(",RT_INJECTOR_ALARM_COUNT="+String.valueOf(RT_INJECTOR_ALARM_COUNT));
		sb.append(",BATCH_NUMBER="+String.valueOf(BATCH_NUMBER));
		sb.append(",VRU_CODE="+VRU_CODE);
		sb.append(",ADDITIVE_MASKING="+String.valueOf(ADDITIVE_MASKING));
		sb.append(",COMPATIBILITY_STATUS="+String.valueOf(COMPATIBILITY_STATUS));
		sb.append(",RECIPE_CORRECTION_TYPE="+String.valueOf(RECIPE_CORRECTION_TYPE));
		sb.append(",NON_RECIPE_GROSS_QUANTITY="+String.valueOf(NON_RECIPE_GROSS_QUANTITY));
		sb.append(",NON_RECIPE_NET_QUANTITY="+String.valueOf(NON_RECIPE_NET_QUANTITY));
		sb.append(",NON_RECIPE_WEIGHT="+String.valueOf(NON_RECIPE_WEIGHT));
		sb.append(",WEIGHT_IN_VAC="+String.valueOf(WEIGHT_IN_VAC));
		sb.append(",ADDITIVE_WEIGHT_IN_VAC="+String.valueOf(ADDITIVE_WEIGHT_IN_VAC));
		sb.append(",COMMITTED_GROSS_QUANTITY="+String.valueOf(COMMITTED_GROSS_QUANTITY));
		sb.append(",PRODUCT_WEIGHT_IN_VAC="+String.valueOf(PRODUCT_WEIGHT_IN_VAC));
		sb.append(",COMMITTED_NET_QUANTITY="+String.valueOf(COMMITTED_NET_QUANTITY));
		sb.append(",PDXR_PRODUCT_CODE="+PDXR_PRODUCT_CODE);
		sb.append(",PDXR_AUTHORIZATION_UNITS="+String.valueOf(PDXR_AUTHORIZATION_UNITS));
		sb.append(",COMMITTED_WEIGHT_IN_VAC="+String.valueOf(COMMITTED_WEIGHT_IN_VAC));
		sb.append(",COMMITTED_WEIGHT_IN_AIR="+String.valueOf(COMMITTED_WEIGHT_IN_AIR));
		sb.append(",PDXR_ADDITIVE_CODE="+PDXR_ADDITIVE_CODE);
		sb.append(",COMMITTED_CONV_TEMPERATURE="+String.valueOf(COMMITTED_CONV_TEMPERATURE));
		sb.append(",COMMITTED_CONV_DENSITY="+String.valueOf(COMMITTED_CONV_DENSITY));
		sb.append(",COMMITTED_CONV_COE="+String.valueOf(COMMITTED_CONV_COE));
		sb.append(",COMMITTED_CONV_PRESSURE="+String.valueOf(COMMITTED_CONV_PRESSURE));
		sb.append(",MEASURED_QUANTITY_TYPE="+String.valueOf(MEASURED_QUANTITY_TYPE));
		sb.append(",INVENTORY_QUANTITY_TYPE="+String.valueOf(INVENTORY_QUANTITY_TYPE));
		sb.append(",DERIVED_VALUES_DIRECTIVE="+String.valueOf(DERIVED_VALUES_DIRECTIVE));
		sb.append(",PRESSURE="+String.valueOf(PRESSURE));
		sb.append(",METER_PRESET_CODE="+METER_PRESET_CODE);
		sb.append(",CALCULATE_NET="+String.valueOf(CALCULATE_NET));
		sb.append(",NON_RECIPE_WEIGHT_IN_VAC="+String.valueOf(NON_RECIPE_WEIGHT_IN_VAC));
		sb.append(",ADJUSTMENT_BATCH="+String.valueOf(ADJUSTMENT_BATCH));
		sb.append(",COMPARTMENT_OWNER_ID="+String.valueOf(COMPARTMENT_OWNER_ID));
		sb.append(",COMPARTMENT_CONTAINER_CODE="+COMPARTMENT_CONTAINER_CODE);
		sb.append(",COMPARTMENT_CONTAINER_TYPE="+String.valueOf(COMPARTMENT_CONTAINER_TYPE));
		sb.append(",COMPARTMENT_NUMBER="+String.valueOf(COMPARTMENT_NUMBER));
		sb.append(",PDXR_LOADING_REF="+PDXR_LOADING_REF);
		sb.append(",BLEND_CORRECTION_METHOD="+String.valueOf(BLEND_CORRECTION_METHOD));
		sb.append(",BLEND_CORRECTION_NET_VOLUME="+String.valueOf(BLEND_CORRECTION_NET_VOLUME));
		sb.append(",TOTAL_BATCH_BLEND_NET_VOLUME="+String.valueOf(TOTAL_BATCH_BLEND_NET_VOLUME));
		sb.append(",BLEND_CORRECTION_SOURCE="+String.valueOf(BLEND_CORRECTION_SOURCE));
		sb.append(",COMMODITY_GROUP="+String.valueOf(COMMODITY_GROUP));
		sb.append(",DERIVATION_STATUS="+String.valueOf(DERIVATION_STATUS));
		sb.append(",DERIVED_VALUES_ERROR="+DERIVED_VALUES_ERROR);
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
    final static byte[] commonByteArrayLock_PGS_STAGE_DIM_ORDER_RECIPE = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_DIM_ORDER_RECIPE = new byte[0];

	
			    public int ORDER_ID;

				public int getORDER_ID () {
					return this.ORDER_ID;
				}
				
			    public int COMPARTMENT_ID;

				public int getCOMPARTMENT_ID () {
					return this.COMPARTMENT_ID;
				}
				
			    public int ORDER_RECIPE_ID;

				public int getORDER_RECIPE_ID () {
					return this.ORDER_RECIPE_ID;
				}
				
			    public String BAY_CODE;

				public String getBAY_CODE () {
					return this.BAY_CODE;
				}
				
			    public String API_CODE;

				public String getAPI_CODE () {
					return this.API_CODE;
				}
				
			    public String INJECTOR_PRESET_CODE;

				public String getINJECTOR_PRESET_CODE () {
					return this.INJECTOR_PRESET_CODE;
				}
				
			    public String TARE_SCALE_INTERFACE_CODE;

				public String getTARE_SCALE_INTERFACE_CODE () {
					return this.TARE_SCALE_INTERFACE_CODE;
				}
				
			    public String TANK_CODE;

				public String getTANK_CODE () {
					return this.TANK_CODE;
				}
				
			    public String PRODUCT_GROUP_CODE;

				public String getPRODUCT_GROUP_CODE () {
					return this.PRODUCT_GROUP_CODE;
				}
				
			    public String INJECTOR_CODE;

				public String getINJECTOR_CODE () {
					return this.INJECTOR_CODE;
				}
				
			    public String METER_CODE;

				public String getMETER_CODE () {
					return this.METER_CODE;
				}
				
			    public Integer SUPPLIER_NUMBER;

				public Integer getSUPPLIER_NUMBER () {
					return this.SUPPLIER_NUMBER;
				}
				
			    public int TERMINAL_PRODUCT_NUMBER;

				public int getTERMINAL_PRODUCT_NUMBER () {
					return this.TERMINAL_PRODUCT_NUMBER;
				}
				
			    public int TERMINAL_PRODUCT_TYPE;

				public int getTERMINAL_PRODUCT_TYPE () {
					return this.TERMINAL_PRODUCT_TYPE;
				}
				
			    public String SHOST_SI_HOST_PRODUCT_NUMBER;

				public String getSHOST_SI_HOST_PRODUCT_NUMBER () {
					return this.SHOST_SI_HOST_PRODUCT_NUMBER;
				}
				
			    public double BLEND_PERCENT;

				public double getBLEND_PERCENT () {
					return this.BLEND_PERCENT;
				}
				
			    public int RATE;

				public int getRATE () {
					return this.RATE;
				}
				
			    public String THOST_TI_HOST_PRODUCT_NUMBER;

				public String getTHOST_TI_HOST_PRODUCT_NUMBER () {
					return this.THOST_TI_HOST_PRODUCT_NUMBER;
				}
				
			    public int ORDERED_QUANTITY;

				public int getORDERED_QUANTITY () {
					return this.ORDERED_QUANTITY;
				}
				
			    public int OVERRIDE_TEMPERATURE_ENABLE;

				public int getOVERRIDE_TEMPERATURE_ENABLE () {
					return this.OVERRIDE_TEMPERATURE_ENABLE;
				}
				
			    public int GROSS_QUANTITY;

				public int getGROSS_QUANTITY () {
					return this.GROSS_QUANTITY;
				}
				
			    public int WEIGHT;

				public int getWEIGHT () {
					return this.WEIGHT;
				}
				
			    public int NET_QUANTITY;

				public int getNET_QUANTITY () {
					return this.NET_QUANTITY;
				}
				
			    public double DENSITY;

				public double getDENSITY () {
					return this.DENSITY;
				}
				
			    public int CUSTOMER_NET_QUANTITY;

				public int getCUSTOMER_NET_QUANTITY () {
					return this.CUSTOMER_NET_QUANTITY;
				}
				
			    public double SPECIFIC_GRAVITY;

				public double getSPECIFIC_GRAVITY () {
					return this.SPECIFIC_GRAVITY;
				}
				
			    public double COEFFICIENT_EXPANSION;

				public double getCOEFFICIENT_EXPANSION () {
					return this.COEFFICIENT_EXPANSION;
				}
				
			    public double TEMPERATURE;

				public double getTEMPERATURE () {
					return this.TEMPERATURE;
				}
				
			    public double RVP;

				public double getRVP () {
					return this.RVP;
				}
				
			    public double OXYGEN;

				public double getOXYGEN () {
					return this.OXYGEN;
				}
				
			    public int START_GROSS_TOTALIZER;

				public int getSTART_GROSS_TOTALIZER () {
					return this.START_GROSS_TOTALIZER;
				}
				
			    public int END_GROSS_TOTALIZER;

				public int getEND_GROSS_TOTALIZER () {
					return this.END_GROSS_TOTALIZER;
				}
				
			    public int START_NET_TOTALIZER;

				public int getSTART_NET_TOTALIZER () {
					return this.START_NET_TOTALIZER;
				}
				
			    public int END_NET_TOTALIZER;

				public int getEND_NET_TOTALIZER () {
					return this.END_NET_TOTALIZER;
				}
				
			    public int START_WEIGHT;

				public int getSTART_WEIGHT () {
					return this.START_WEIGHT;
				}
				
			    public int END_WEIGHT;

				public int getEND_WEIGHT () {
					return this.END_WEIGHT;
				}
				
			    public String LAST_USER_NAME;

				public String getLAST_USER_NAME () {
					return this.LAST_USER_NAME;
				}
				
			    public java.util.Date LAST_MODIFIED;

				public java.util.Date getLAST_MODIFIED () {
					return this.LAST_MODIFIED;
				}
				
			    public java.util.Date START_TIME;

				public java.util.Date getSTART_TIME () {
					return this.START_TIME;
				}
				
			    public java.util.Date END_TIME;

				public java.util.Date getEND_TIME () {
					return this.END_TIME;
				}
				
			    public int ADDITIVE_QUANTITY;

				public int getADDITIVE_QUANTITY () {
					return this.ADDITIVE_QUANTITY;
				}
				
			    public int PRODUCT_QUANTITY;

				public int getPRODUCT_QUANTITY () {
					return this.PRODUCT_QUANTITY;
				}
				
			    public String HOST_PRODUCT_CODE;

				public String getHOST_PRODUCT_CODE () {
					return this.HOST_PRODUCT_CODE;
				}
				
			    public String HOST_PRODUCT_NAME;

				public String getHOST_PRODUCT_NAME () {
					return this.HOST_PRODUCT_NAME;
				}
				
			    public int FROM_LEFT_ON_TRUCK;

				public int getFROM_LEFT_ON_TRUCK () {
					return this.FROM_LEFT_ON_TRUCK;
				}
				
			    public double OBSERVED_DENSITY;

				public double getOBSERVED_DENSITY () {
					return this.OBSERVED_DENSITY;
				}
				
			    public int COMPONENT_ID;

				public int getCOMPONENT_ID () {
					return this.COMPONENT_ID;
				}
				
			    public int CALCULATE_SECONDARY_UNITS;

				public int getCALCULATE_SECONDARY_UNITS () {
					return this.CALCULATE_SECONDARY_UNITS;
				}
				
			    public String FINAL_SCALE_INTERFACE_CODE;

				public String getFINAL_SCALE_INTERFACE_CODE () {
					return this.FINAL_SCALE_INTERFACE_CODE;
				}
				
			    public int FRAC_START_GROSS_TOTALIZER;

				public int getFRAC_START_GROSS_TOTALIZER () {
					return this.FRAC_START_GROSS_TOTALIZER;
				}
				
			    public int FRAC_END_GROSS_TOTALIZER;

				public int getFRAC_END_GROSS_TOTALIZER () {
					return this.FRAC_END_GROSS_TOTALIZER;
				}
				
			    public String PETROEX_COMPONENT_PRODUCT_CODE;

				public String getPETROEX_COMPONENT_PRODUCT_CODE () {
					return this.PETROEX_COMPONENT_PRODUCT_CODE;
				}
				
			    public int PRODUCT_TOLERANCE_STATUS;

				public int getPRODUCT_TOLERANCE_STATUS () {
					return this.PRODUCT_TOLERANCE_STATUS;
				}
				
			    public int TANK_INVENTORY_UPDATED;

				public int getTANK_INVENTORY_UPDATED () {
					return this.TANK_INVENTORY_UPDATED;
				}
				
			    public int TOTALIZER_UPDATED;

				public int getTOTALIZER_UPDATED () {
					return this.TOTALIZER_UPDATED;
				}
				
			    public int FLUSH_STATUS;

				public int getFLUSH_STATUS () {
					return this.FLUSH_STATUS;
				}
				
			    public Integer REDUCED_PRODUCT_NUMBER;

				public Integer getREDUCED_PRODUCT_NUMBER () {
					return this.REDUCED_PRODUCT_NUMBER;
				}
				
			    public int ADDITIVE_WEIGHT;

				public int getADDITIVE_WEIGHT () {
					return this.ADDITIVE_WEIGHT;
				}
				
			    public int PRODUCT_WEIGHT;

				public int getPRODUCT_WEIGHT () {
					return this.PRODUCT_WEIGHT;
				}
				
			    public int RT_INJECTOR_ALARM_COUNT;

				public int getRT_INJECTOR_ALARM_COUNT () {
					return this.RT_INJECTOR_ALARM_COUNT;
				}
				
			    public int BATCH_NUMBER;

				public int getBATCH_NUMBER () {
					return this.BATCH_NUMBER;
				}
				
			    public String VRU_CODE;

				public String getVRU_CODE () {
					return this.VRU_CODE;
				}
				
			    public int ADDITIVE_MASKING;

				public int getADDITIVE_MASKING () {
					return this.ADDITIVE_MASKING;
				}
				
			    public int COMPATIBILITY_STATUS;

				public int getCOMPATIBILITY_STATUS () {
					return this.COMPATIBILITY_STATUS;
				}
				
			    public int RECIPE_CORRECTION_TYPE;

				public int getRECIPE_CORRECTION_TYPE () {
					return this.RECIPE_CORRECTION_TYPE;
				}
				
			    public int NON_RECIPE_GROSS_QUANTITY;

				public int getNON_RECIPE_GROSS_QUANTITY () {
					return this.NON_RECIPE_GROSS_QUANTITY;
				}
				
			    public int NON_RECIPE_NET_QUANTITY;

				public int getNON_RECIPE_NET_QUANTITY () {
					return this.NON_RECIPE_NET_QUANTITY;
				}
				
			    public int NON_RECIPE_WEIGHT;

				public int getNON_RECIPE_WEIGHT () {
					return this.NON_RECIPE_WEIGHT;
				}
				
			    public int WEIGHT_IN_VAC;

				public int getWEIGHT_IN_VAC () {
					return this.WEIGHT_IN_VAC;
				}
				
			    public int ADDITIVE_WEIGHT_IN_VAC;

				public int getADDITIVE_WEIGHT_IN_VAC () {
					return this.ADDITIVE_WEIGHT_IN_VAC;
				}
				
			    public int COMMITTED_GROSS_QUANTITY;

				public int getCOMMITTED_GROSS_QUANTITY () {
					return this.COMMITTED_GROSS_QUANTITY;
				}
				
			    public int PRODUCT_WEIGHT_IN_VAC;

				public int getPRODUCT_WEIGHT_IN_VAC () {
					return this.PRODUCT_WEIGHT_IN_VAC;
				}
				
			    public int COMMITTED_NET_QUANTITY;

				public int getCOMMITTED_NET_QUANTITY () {
					return this.COMMITTED_NET_QUANTITY;
				}
				
			    public String PDXR_PRODUCT_CODE;

				public String getPDXR_PRODUCT_CODE () {
					return this.PDXR_PRODUCT_CODE;
				}
				
			    public int PDXR_AUTHORIZATION_UNITS;

				public int getPDXR_AUTHORIZATION_UNITS () {
					return this.PDXR_AUTHORIZATION_UNITS;
				}
				
			    public int COMMITTED_WEIGHT_IN_VAC;

				public int getCOMMITTED_WEIGHT_IN_VAC () {
					return this.COMMITTED_WEIGHT_IN_VAC;
				}
				
			    public int COMMITTED_WEIGHT_IN_AIR;

				public int getCOMMITTED_WEIGHT_IN_AIR () {
					return this.COMMITTED_WEIGHT_IN_AIR;
				}
				
			    public String PDXR_ADDITIVE_CODE;

				public String getPDXR_ADDITIVE_CODE () {
					return this.PDXR_ADDITIVE_CODE;
				}
				
			    public double COMMITTED_CONV_TEMPERATURE;

				public double getCOMMITTED_CONV_TEMPERATURE () {
					return this.COMMITTED_CONV_TEMPERATURE;
				}
				
			    public double COMMITTED_CONV_DENSITY;

				public double getCOMMITTED_CONV_DENSITY () {
					return this.COMMITTED_CONV_DENSITY;
				}
				
			    public double COMMITTED_CONV_COE;

				public double getCOMMITTED_CONV_COE () {
					return this.COMMITTED_CONV_COE;
				}
				
			    public double COMMITTED_CONV_PRESSURE;

				public double getCOMMITTED_CONV_PRESSURE () {
					return this.COMMITTED_CONV_PRESSURE;
				}
				
			    public int MEASURED_QUANTITY_TYPE;

				public int getMEASURED_QUANTITY_TYPE () {
					return this.MEASURED_QUANTITY_TYPE;
				}
				
			    public int INVENTORY_QUANTITY_TYPE;

				public int getINVENTORY_QUANTITY_TYPE () {
					return this.INVENTORY_QUANTITY_TYPE;
				}
				
			    public int DERIVED_VALUES_DIRECTIVE;

				public int getDERIVED_VALUES_DIRECTIVE () {
					return this.DERIVED_VALUES_DIRECTIVE;
				}
				
			    public double PRESSURE;

				public double getPRESSURE () {
					return this.PRESSURE;
				}
				
			    public String METER_PRESET_CODE;

				public String getMETER_PRESET_CODE () {
					return this.METER_PRESET_CODE;
				}
				
			    public int CALCULATE_NET;

				public int getCALCULATE_NET () {
					return this.CALCULATE_NET;
				}
				
			    public int NON_RECIPE_WEIGHT_IN_VAC;

				public int getNON_RECIPE_WEIGHT_IN_VAC () {
					return this.NON_RECIPE_WEIGHT_IN_VAC;
				}
				
			    public int ADJUSTMENT_BATCH;

				public int getADJUSTMENT_BATCH () {
					return this.ADJUSTMENT_BATCH;
				}
				
			    public Integer COMPARTMENT_OWNER_ID;

				public Integer getCOMPARTMENT_OWNER_ID () {
					return this.COMPARTMENT_OWNER_ID;
				}
				
			    public String COMPARTMENT_CONTAINER_CODE;

				public String getCOMPARTMENT_CONTAINER_CODE () {
					return this.COMPARTMENT_CONTAINER_CODE;
				}
				
			    public Integer COMPARTMENT_CONTAINER_TYPE;

				public Integer getCOMPARTMENT_CONTAINER_TYPE () {
					return this.COMPARTMENT_CONTAINER_TYPE;
				}
				
			    public Integer COMPARTMENT_NUMBER;

				public Integer getCOMPARTMENT_NUMBER () {
					return this.COMPARTMENT_NUMBER;
				}
				
			    public String PDXR_LOADING_REF;

				public String getPDXR_LOADING_REF () {
					return this.PDXR_LOADING_REF;
				}
				
			    public int BLEND_CORRECTION_METHOD;

				public int getBLEND_CORRECTION_METHOD () {
					return this.BLEND_CORRECTION_METHOD;
				}
				
			    public double BLEND_CORRECTION_NET_VOLUME;

				public double getBLEND_CORRECTION_NET_VOLUME () {
					return this.BLEND_CORRECTION_NET_VOLUME;
				}
				
			    public double TOTAL_BATCH_BLEND_NET_VOLUME;

				public double getTOTAL_BATCH_BLEND_NET_VOLUME () {
					return this.TOTAL_BATCH_BLEND_NET_VOLUME;
				}
				
			    public int BLEND_CORRECTION_SOURCE;

				public int getBLEND_CORRECTION_SOURCE () {
					return this.BLEND_CORRECTION_SOURCE;
				}
				
			    public int COMMODITY_GROUP;

				public int getCOMMODITY_GROUP () {
					return this.COMMODITY_GROUP;
				}
				
			    public int DERIVATION_STATUS;

				public int getDERIVATION_STATUS () {
					return this.DERIVATION_STATUS;
				}
				
			    public String DERIVED_VALUES_ERROR;

				public String getDERIVED_VALUES_ERROR () {
					return this.DERIVED_VALUES_ERROR;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PGS_STAGE_DIM_ORDER_RECIPE.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_ORDER_RECIPE.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_ORDER_RECIPE = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_ORDER_RECIPE = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PGS_STAGE_DIM_ORDER_RECIPE, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_ORDER_RECIPE, 0, length, utf8Charset);
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
			if(length > commonByteArray_PGS_STAGE_DIM_ORDER_RECIPE.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_ORDER_RECIPE.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_ORDER_RECIPE = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_ORDER_RECIPE = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PGS_STAGE_DIM_ORDER_RECIPE, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_ORDER_RECIPE, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_ORDER_RECIPE) {

        	try {

        		int length = 0;
		
			        this.ORDER_ID = dis.readInt();
					
			        this.COMPARTMENT_ID = dis.readInt();
					
			        this.ORDER_RECIPE_ID = dis.readInt();
					
					this.BAY_CODE = readString(dis);
					
					this.API_CODE = readString(dis);
					
					this.INJECTOR_PRESET_CODE = readString(dis);
					
					this.TARE_SCALE_INTERFACE_CODE = readString(dis);
					
					this.TANK_CODE = readString(dis);
					
					this.PRODUCT_GROUP_CODE = readString(dis);
					
					this.INJECTOR_CODE = readString(dis);
					
					this.METER_CODE = readString(dis);
					
						this.SUPPLIER_NUMBER = readInteger(dis);
					
			        this.TERMINAL_PRODUCT_NUMBER = dis.readInt();
					
			        this.TERMINAL_PRODUCT_TYPE = dis.readInt();
					
					this.SHOST_SI_HOST_PRODUCT_NUMBER = readString(dis);
					
			        this.BLEND_PERCENT = dis.readDouble();
					
			        this.RATE = dis.readInt();
					
					this.THOST_TI_HOST_PRODUCT_NUMBER = readString(dis);
					
			        this.ORDERED_QUANTITY = dis.readInt();
					
			        this.OVERRIDE_TEMPERATURE_ENABLE = dis.readInt();
					
			        this.GROSS_QUANTITY = dis.readInt();
					
			        this.WEIGHT = dis.readInt();
					
			        this.NET_QUANTITY = dis.readInt();
					
			        this.DENSITY = dis.readDouble();
					
			        this.CUSTOMER_NET_QUANTITY = dis.readInt();
					
			        this.SPECIFIC_GRAVITY = dis.readDouble();
					
			        this.COEFFICIENT_EXPANSION = dis.readDouble();
					
			        this.TEMPERATURE = dis.readDouble();
					
			        this.RVP = dis.readDouble();
					
			        this.OXYGEN = dis.readDouble();
					
			        this.START_GROSS_TOTALIZER = dis.readInt();
					
			        this.END_GROSS_TOTALIZER = dis.readInt();
					
			        this.START_NET_TOTALIZER = dis.readInt();
					
			        this.END_NET_TOTALIZER = dis.readInt();
					
			        this.START_WEIGHT = dis.readInt();
					
			        this.END_WEIGHT = dis.readInt();
					
					this.LAST_USER_NAME = readString(dis);
					
					this.LAST_MODIFIED = readDate(dis);
					
					this.START_TIME = readDate(dis);
					
					this.END_TIME = readDate(dis);
					
			        this.ADDITIVE_QUANTITY = dis.readInt();
					
			        this.PRODUCT_QUANTITY = dis.readInt();
					
					this.HOST_PRODUCT_CODE = readString(dis);
					
					this.HOST_PRODUCT_NAME = readString(dis);
					
			        this.FROM_LEFT_ON_TRUCK = dis.readInt();
					
			        this.OBSERVED_DENSITY = dis.readDouble();
					
			        this.COMPONENT_ID = dis.readInt();
					
			        this.CALCULATE_SECONDARY_UNITS = dis.readInt();
					
					this.FINAL_SCALE_INTERFACE_CODE = readString(dis);
					
			        this.FRAC_START_GROSS_TOTALIZER = dis.readInt();
					
			        this.FRAC_END_GROSS_TOTALIZER = dis.readInt();
					
					this.PETROEX_COMPONENT_PRODUCT_CODE = readString(dis);
					
			        this.PRODUCT_TOLERANCE_STATUS = dis.readInt();
					
			        this.TANK_INVENTORY_UPDATED = dis.readInt();
					
			        this.TOTALIZER_UPDATED = dis.readInt();
					
			        this.FLUSH_STATUS = dis.readInt();
					
						this.REDUCED_PRODUCT_NUMBER = readInteger(dis);
					
			        this.ADDITIVE_WEIGHT = dis.readInt();
					
			        this.PRODUCT_WEIGHT = dis.readInt();
					
			        this.RT_INJECTOR_ALARM_COUNT = dis.readInt();
					
			        this.BATCH_NUMBER = dis.readInt();
					
					this.VRU_CODE = readString(dis);
					
			        this.ADDITIVE_MASKING = dis.readInt();
					
			        this.COMPATIBILITY_STATUS = dis.readInt();
					
			        this.RECIPE_CORRECTION_TYPE = dis.readInt();
					
			        this.NON_RECIPE_GROSS_QUANTITY = dis.readInt();
					
			        this.NON_RECIPE_NET_QUANTITY = dis.readInt();
					
			        this.NON_RECIPE_WEIGHT = dis.readInt();
					
			        this.WEIGHT_IN_VAC = dis.readInt();
					
			        this.ADDITIVE_WEIGHT_IN_VAC = dis.readInt();
					
			        this.COMMITTED_GROSS_QUANTITY = dis.readInt();
					
			        this.PRODUCT_WEIGHT_IN_VAC = dis.readInt();
					
			        this.COMMITTED_NET_QUANTITY = dis.readInt();
					
					this.PDXR_PRODUCT_CODE = readString(dis);
					
			        this.PDXR_AUTHORIZATION_UNITS = dis.readInt();
					
			        this.COMMITTED_WEIGHT_IN_VAC = dis.readInt();
					
			        this.COMMITTED_WEIGHT_IN_AIR = dis.readInt();
					
					this.PDXR_ADDITIVE_CODE = readString(dis);
					
			        this.COMMITTED_CONV_TEMPERATURE = dis.readDouble();
					
			        this.COMMITTED_CONV_DENSITY = dis.readDouble();
					
			        this.COMMITTED_CONV_COE = dis.readDouble();
					
			        this.COMMITTED_CONV_PRESSURE = dis.readDouble();
					
			        this.MEASURED_QUANTITY_TYPE = dis.readInt();
					
			        this.INVENTORY_QUANTITY_TYPE = dis.readInt();
					
			        this.DERIVED_VALUES_DIRECTIVE = dis.readInt();
					
			        this.PRESSURE = dis.readDouble();
					
					this.METER_PRESET_CODE = readString(dis);
					
			        this.CALCULATE_NET = dis.readInt();
					
			        this.NON_RECIPE_WEIGHT_IN_VAC = dis.readInt();
					
			        this.ADJUSTMENT_BATCH = dis.readInt();
					
						this.COMPARTMENT_OWNER_ID = readInteger(dis);
					
					this.COMPARTMENT_CONTAINER_CODE = readString(dis);
					
						this.COMPARTMENT_CONTAINER_TYPE = readInteger(dis);
					
						this.COMPARTMENT_NUMBER = readInteger(dis);
					
					this.PDXR_LOADING_REF = readString(dis);
					
			        this.BLEND_CORRECTION_METHOD = dis.readInt();
					
			        this.BLEND_CORRECTION_NET_VOLUME = dis.readDouble();
					
			        this.TOTAL_BATCH_BLEND_NET_VOLUME = dis.readDouble();
					
			        this.BLEND_CORRECTION_SOURCE = dis.readInt();
					
			        this.COMMODITY_GROUP = dis.readInt();
					
			        this.DERIVATION_STATUS = dis.readInt();
					
					this.DERIVED_VALUES_ERROR = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_ORDER_RECIPE) {

        	try {

        		int length = 0;
		
			        this.ORDER_ID = dis.readInt();
					
			        this.COMPARTMENT_ID = dis.readInt();
					
			        this.ORDER_RECIPE_ID = dis.readInt();
					
					this.BAY_CODE = readString(dis);
					
					this.API_CODE = readString(dis);
					
					this.INJECTOR_PRESET_CODE = readString(dis);
					
					this.TARE_SCALE_INTERFACE_CODE = readString(dis);
					
					this.TANK_CODE = readString(dis);
					
					this.PRODUCT_GROUP_CODE = readString(dis);
					
					this.INJECTOR_CODE = readString(dis);
					
					this.METER_CODE = readString(dis);
					
						this.SUPPLIER_NUMBER = readInteger(dis);
					
			        this.TERMINAL_PRODUCT_NUMBER = dis.readInt();
					
			        this.TERMINAL_PRODUCT_TYPE = dis.readInt();
					
					this.SHOST_SI_HOST_PRODUCT_NUMBER = readString(dis);
					
			        this.BLEND_PERCENT = dis.readDouble();
					
			        this.RATE = dis.readInt();
					
					this.THOST_TI_HOST_PRODUCT_NUMBER = readString(dis);
					
			        this.ORDERED_QUANTITY = dis.readInt();
					
			        this.OVERRIDE_TEMPERATURE_ENABLE = dis.readInt();
					
			        this.GROSS_QUANTITY = dis.readInt();
					
			        this.WEIGHT = dis.readInt();
					
			        this.NET_QUANTITY = dis.readInt();
					
			        this.DENSITY = dis.readDouble();
					
			        this.CUSTOMER_NET_QUANTITY = dis.readInt();
					
			        this.SPECIFIC_GRAVITY = dis.readDouble();
					
			        this.COEFFICIENT_EXPANSION = dis.readDouble();
					
			        this.TEMPERATURE = dis.readDouble();
					
			        this.RVP = dis.readDouble();
					
			        this.OXYGEN = dis.readDouble();
					
			        this.START_GROSS_TOTALIZER = dis.readInt();
					
			        this.END_GROSS_TOTALIZER = dis.readInt();
					
			        this.START_NET_TOTALIZER = dis.readInt();
					
			        this.END_NET_TOTALIZER = dis.readInt();
					
			        this.START_WEIGHT = dis.readInt();
					
			        this.END_WEIGHT = dis.readInt();
					
					this.LAST_USER_NAME = readString(dis);
					
					this.LAST_MODIFIED = readDate(dis);
					
					this.START_TIME = readDate(dis);
					
					this.END_TIME = readDate(dis);
					
			        this.ADDITIVE_QUANTITY = dis.readInt();
					
			        this.PRODUCT_QUANTITY = dis.readInt();
					
					this.HOST_PRODUCT_CODE = readString(dis);
					
					this.HOST_PRODUCT_NAME = readString(dis);
					
			        this.FROM_LEFT_ON_TRUCK = dis.readInt();
					
			        this.OBSERVED_DENSITY = dis.readDouble();
					
			        this.COMPONENT_ID = dis.readInt();
					
			        this.CALCULATE_SECONDARY_UNITS = dis.readInt();
					
					this.FINAL_SCALE_INTERFACE_CODE = readString(dis);
					
			        this.FRAC_START_GROSS_TOTALIZER = dis.readInt();
					
			        this.FRAC_END_GROSS_TOTALIZER = dis.readInt();
					
					this.PETROEX_COMPONENT_PRODUCT_CODE = readString(dis);
					
			        this.PRODUCT_TOLERANCE_STATUS = dis.readInt();
					
			        this.TANK_INVENTORY_UPDATED = dis.readInt();
					
			        this.TOTALIZER_UPDATED = dis.readInt();
					
			        this.FLUSH_STATUS = dis.readInt();
					
						this.REDUCED_PRODUCT_NUMBER = readInteger(dis);
					
			        this.ADDITIVE_WEIGHT = dis.readInt();
					
			        this.PRODUCT_WEIGHT = dis.readInt();
					
			        this.RT_INJECTOR_ALARM_COUNT = dis.readInt();
					
			        this.BATCH_NUMBER = dis.readInt();
					
					this.VRU_CODE = readString(dis);
					
			        this.ADDITIVE_MASKING = dis.readInt();
					
			        this.COMPATIBILITY_STATUS = dis.readInt();
					
			        this.RECIPE_CORRECTION_TYPE = dis.readInt();
					
			        this.NON_RECIPE_GROSS_QUANTITY = dis.readInt();
					
			        this.NON_RECIPE_NET_QUANTITY = dis.readInt();
					
			        this.NON_RECIPE_WEIGHT = dis.readInt();
					
			        this.WEIGHT_IN_VAC = dis.readInt();
					
			        this.ADDITIVE_WEIGHT_IN_VAC = dis.readInt();
					
			        this.COMMITTED_GROSS_QUANTITY = dis.readInt();
					
			        this.PRODUCT_WEIGHT_IN_VAC = dis.readInt();
					
			        this.COMMITTED_NET_QUANTITY = dis.readInt();
					
					this.PDXR_PRODUCT_CODE = readString(dis);
					
			        this.PDXR_AUTHORIZATION_UNITS = dis.readInt();
					
			        this.COMMITTED_WEIGHT_IN_VAC = dis.readInt();
					
			        this.COMMITTED_WEIGHT_IN_AIR = dis.readInt();
					
					this.PDXR_ADDITIVE_CODE = readString(dis);
					
			        this.COMMITTED_CONV_TEMPERATURE = dis.readDouble();
					
			        this.COMMITTED_CONV_DENSITY = dis.readDouble();
					
			        this.COMMITTED_CONV_COE = dis.readDouble();
					
			        this.COMMITTED_CONV_PRESSURE = dis.readDouble();
					
			        this.MEASURED_QUANTITY_TYPE = dis.readInt();
					
			        this.INVENTORY_QUANTITY_TYPE = dis.readInt();
					
			        this.DERIVED_VALUES_DIRECTIVE = dis.readInt();
					
			        this.PRESSURE = dis.readDouble();
					
					this.METER_PRESET_CODE = readString(dis);
					
			        this.CALCULATE_NET = dis.readInt();
					
			        this.NON_RECIPE_WEIGHT_IN_VAC = dis.readInt();
					
			        this.ADJUSTMENT_BATCH = dis.readInt();
					
						this.COMPARTMENT_OWNER_ID = readInteger(dis);
					
					this.COMPARTMENT_CONTAINER_CODE = readString(dis);
					
						this.COMPARTMENT_CONTAINER_TYPE = readInteger(dis);
					
						this.COMPARTMENT_NUMBER = readInteger(dis);
					
					this.PDXR_LOADING_REF = readString(dis);
					
			        this.BLEND_CORRECTION_METHOD = dis.readInt();
					
			        this.BLEND_CORRECTION_NET_VOLUME = dis.readDouble();
					
			        this.TOTAL_BATCH_BLEND_NET_VOLUME = dis.readDouble();
					
			        this.BLEND_CORRECTION_SOURCE = dis.readInt();
					
			        this.COMMODITY_GROUP = dis.readInt();
					
			        this.DERIVATION_STATUS = dis.readInt();
					
					this.DERIVED_VALUES_ERROR = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.ORDER_ID);
					
					// int
				
		            	dos.writeInt(this.COMPARTMENT_ID);
					
					// int
				
		            	dos.writeInt(this.ORDER_RECIPE_ID);
					
					// String
				
						writeString(this.BAY_CODE,dos);
					
					// String
				
						writeString(this.API_CODE,dos);
					
					// String
				
						writeString(this.INJECTOR_PRESET_CODE,dos);
					
					// String
				
						writeString(this.TARE_SCALE_INTERFACE_CODE,dos);
					
					// String
				
						writeString(this.TANK_CODE,dos);
					
					// String
				
						writeString(this.PRODUCT_GROUP_CODE,dos);
					
					// String
				
						writeString(this.INJECTOR_CODE,dos);
					
					// String
				
						writeString(this.METER_CODE,dos);
					
					// Integer
				
						writeInteger(this.SUPPLIER_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.TERMINAL_PRODUCT_NUMBER);
					
					// int
				
		            	dos.writeInt(this.TERMINAL_PRODUCT_TYPE);
					
					// String
				
						writeString(this.SHOST_SI_HOST_PRODUCT_NUMBER,dos);
					
					// double
				
		            	dos.writeDouble(this.BLEND_PERCENT);
					
					// int
				
		            	dos.writeInt(this.RATE);
					
					// String
				
						writeString(this.THOST_TI_HOST_PRODUCT_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.ORDERED_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.OVERRIDE_TEMPERATURE_ENABLE);
					
					// int
				
		            	dos.writeInt(this.GROSS_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.WEIGHT);
					
					// int
				
		            	dos.writeInt(this.NET_QUANTITY);
					
					// double
				
		            	dos.writeDouble(this.DENSITY);
					
					// int
				
		            	dos.writeInt(this.CUSTOMER_NET_QUANTITY);
					
					// double
				
		            	dos.writeDouble(this.SPECIFIC_GRAVITY);
					
					// double
				
		            	dos.writeDouble(this.COEFFICIENT_EXPANSION);
					
					// double
				
		            	dos.writeDouble(this.TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.RVP);
					
					// double
				
		            	dos.writeDouble(this.OXYGEN);
					
					// int
				
		            	dos.writeInt(this.START_GROSS_TOTALIZER);
					
					// int
				
		            	dos.writeInt(this.END_GROSS_TOTALIZER);
					
					// int
				
		            	dos.writeInt(this.START_NET_TOTALIZER);
					
					// int
				
		            	dos.writeInt(this.END_NET_TOTALIZER);
					
					// int
				
		            	dos.writeInt(this.START_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.END_WEIGHT);
					
					// String
				
						writeString(this.LAST_USER_NAME,dos);
					
					// java.util.Date
				
						writeDate(this.LAST_MODIFIED,dos);
					
					// java.util.Date
				
						writeDate(this.START_TIME,dos);
					
					// java.util.Date
				
						writeDate(this.END_TIME,dos);
					
					// int
				
		            	dos.writeInt(this.ADDITIVE_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.PRODUCT_QUANTITY);
					
					// String
				
						writeString(this.HOST_PRODUCT_CODE,dos);
					
					// String
				
						writeString(this.HOST_PRODUCT_NAME,dos);
					
					// int
				
		            	dos.writeInt(this.FROM_LEFT_ON_TRUCK);
					
					// double
				
		            	dos.writeDouble(this.OBSERVED_DENSITY);
					
					// int
				
		            	dos.writeInt(this.COMPONENT_ID);
					
					// int
				
		            	dos.writeInt(this.CALCULATE_SECONDARY_UNITS);
					
					// String
				
						writeString(this.FINAL_SCALE_INTERFACE_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.FRAC_START_GROSS_TOTALIZER);
					
					// int
				
		            	dos.writeInt(this.FRAC_END_GROSS_TOTALIZER);
					
					// String
				
						writeString(this.PETROEX_COMPONENT_PRODUCT_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.PRODUCT_TOLERANCE_STATUS);
					
					// int
				
		            	dos.writeInt(this.TANK_INVENTORY_UPDATED);
					
					// int
				
		            	dos.writeInt(this.TOTALIZER_UPDATED);
					
					// int
				
		            	dos.writeInt(this.FLUSH_STATUS);
					
					// Integer
				
						writeInteger(this.REDUCED_PRODUCT_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.ADDITIVE_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.PRODUCT_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.RT_INJECTOR_ALARM_COUNT);
					
					// int
				
		            	dos.writeInt(this.BATCH_NUMBER);
					
					// String
				
						writeString(this.VRU_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.ADDITIVE_MASKING);
					
					// int
				
		            	dos.writeInt(this.COMPATIBILITY_STATUS);
					
					// int
				
		            	dos.writeInt(this.RECIPE_CORRECTION_TYPE);
					
					// int
				
		            	dos.writeInt(this.NON_RECIPE_GROSS_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.NON_RECIPE_NET_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.NON_RECIPE_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.ADDITIVE_WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.COMMITTED_GROSS_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.PRODUCT_WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.COMMITTED_NET_QUANTITY);
					
					// String
				
						writeString(this.PDXR_PRODUCT_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.PDXR_AUTHORIZATION_UNITS);
					
					// int
				
		            	dos.writeInt(this.COMMITTED_WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.COMMITTED_WEIGHT_IN_AIR);
					
					// String
				
						writeString(this.PDXR_ADDITIVE_CODE,dos);
					
					// double
				
		            	dos.writeDouble(this.COMMITTED_CONV_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.COMMITTED_CONV_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.COMMITTED_CONV_COE);
					
					// double
				
		            	dos.writeDouble(this.COMMITTED_CONV_PRESSURE);
					
					// int
				
		            	dos.writeInt(this.MEASURED_QUANTITY_TYPE);
					
					// int
				
		            	dos.writeInt(this.INVENTORY_QUANTITY_TYPE);
					
					// int
				
		            	dos.writeInt(this.DERIVED_VALUES_DIRECTIVE);
					
					// double
				
		            	dos.writeDouble(this.PRESSURE);
					
					// String
				
						writeString(this.METER_PRESET_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.CALCULATE_NET);
					
					// int
				
		            	dos.writeInt(this.NON_RECIPE_WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.ADJUSTMENT_BATCH);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_OWNER_ID,dos);
					
					// String
				
						writeString(this.COMPARTMENT_CONTAINER_CODE,dos);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_CONTAINER_TYPE,dos);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_NUMBER,dos);
					
					// String
				
						writeString(this.PDXR_LOADING_REF,dos);
					
					// int
				
		            	dos.writeInt(this.BLEND_CORRECTION_METHOD);
					
					// double
				
		            	dos.writeDouble(this.BLEND_CORRECTION_NET_VOLUME);
					
					// double
				
		            	dos.writeDouble(this.TOTAL_BATCH_BLEND_NET_VOLUME);
					
					// int
				
		            	dos.writeInt(this.BLEND_CORRECTION_SOURCE);
					
					// int
				
		            	dos.writeInt(this.COMMODITY_GROUP);
					
					// int
				
		            	dos.writeInt(this.DERIVATION_STATUS);
					
					// String
				
						writeString(this.DERIVED_VALUES_ERROR,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.ORDER_ID);
					
					// int
				
		            	dos.writeInt(this.COMPARTMENT_ID);
					
					// int
				
		            	dos.writeInt(this.ORDER_RECIPE_ID);
					
					// String
				
						writeString(this.BAY_CODE,dos);
					
					// String
				
						writeString(this.API_CODE,dos);
					
					// String
				
						writeString(this.INJECTOR_PRESET_CODE,dos);
					
					// String
				
						writeString(this.TARE_SCALE_INTERFACE_CODE,dos);
					
					// String
				
						writeString(this.TANK_CODE,dos);
					
					// String
				
						writeString(this.PRODUCT_GROUP_CODE,dos);
					
					// String
				
						writeString(this.INJECTOR_CODE,dos);
					
					// String
				
						writeString(this.METER_CODE,dos);
					
					// Integer
				
						writeInteger(this.SUPPLIER_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.TERMINAL_PRODUCT_NUMBER);
					
					// int
				
		            	dos.writeInt(this.TERMINAL_PRODUCT_TYPE);
					
					// String
				
						writeString(this.SHOST_SI_HOST_PRODUCT_NUMBER,dos);
					
					// double
				
		            	dos.writeDouble(this.BLEND_PERCENT);
					
					// int
				
		            	dos.writeInt(this.RATE);
					
					// String
				
						writeString(this.THOST_TI_HOST_PRODUCT_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.ORDERED_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.OVERRIDE_TEMPERATURE_ENABLE);
					
					// int
				
		            	dos.writeInt(this.GROSS_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.WEIGHT);
					
					// int
				
		            	dos.writeInt(this.NET_QUANTITY);
					
					// double
				
		            	dos.writeDouble(this.DENSITY);
					
					// int
				
		            	dos.writeInt(this.CUSTOMER_NET_QUANTITY);
					
					// double
				
		            	dos.writeDouble(this.SPECIFIC_GRAVITY);
					
					// double
				
		            	dos.writeDouble(this.COEFFICIENT_EXPANSION);
					
					// double
				
		            	dos.writeDouble(this.TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.RVP);
					
					// double
				
		            	dos.writeDouble(this.OXYGEN);
					
					// int
				
		            	dos.writeInt(this.START_GROSS_TOTALIZER);
					
					// int
				
		            	dos.writeInt(this.END_GROSS_TOTALIZER);
					
					// int
				
		            	dos.writeInt(this.START_NET_TOTALIZER);
					
					// int
				
		            	dos.writeInt(this.END_NET_TOTALIZER);
					
					// int
				
		            	dos.writeInt(this.START_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.END_WEIGHT);
					
					// String
				
						writeString(this.LAST_USER_NAME,dos);
					
					// java.util.Date
				
						writeDate(this.LAST_MODIFIED,dos);
					
					// java.util.Date
				
						writeDate(this.START_TIME,dos);
					
					// java.util.Date
				
						writeDate(this.END_TIME,dos);
					
					// int
				
		            	dos.writeInt(this.ADDITIVE_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.PRODUCT_QUANTITY);
					
					// String
				
						writeString(this.HOST_PRODUCT_CODE,dos);
					
					// String
				
						writeString(this.HOST_PRODUCT_NAME,dos);
					
					// int
				
		            	dos.writeInt(this.FROM_LEFT_ON_TRUCK);
					
					// double
				
		            	dos.writeDouble(this.OBSERVED_DENSITY);
					
					// int
				
		            	dos.writeInt(this.COMPONENT_ID);
					
					// int
				
		            	dos.writeInt(this.CALCULATE_SECONDARY_UNITS);
					
					// String
				
						writeString(this.FINAL_SCALE_INTERFACE_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.FRAC_START_GROSS_TOTALIZER);
					
					// int
				
		            	dos.writeInt(this.FRAC_END_GROSS_TOTALIZER);
					
					// String
				
						writeString(this.PETROEX_COMPONENT_PRODUCT_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.PRODUCT_TOLERANCE_STATUS);
					
					// int
				
		            	dos.writeInt(this.TANK_INVENTORY_UPDATED);
					
					// int
				
		            	dos.writeInt(this.TOTALIZER_UPDATED);
					
					// int
				
		            	dos.writeInt(this.FLUSH_STATUS);
					
					// Integer
				
						writeInteger(this.REDUCED_PRODUCT_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.ADDITIVE_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.PRODUCT_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.RT_INJECTOR_ALARM_COUNT);
					
					// int
				
		            	dos.writeInt(this.BATCH_NUMBER);
					
					// String
				
						writeString(this.VRU_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.ADDITIVE_MASKING);
					
					// int
				
		            	dos.writeInt(this.COMPATIBILITY_STATUS);
					
					// int
				
		            	dos.writeInt(this.RECIPE_CORRECTION_TYPE);
					
					// int
				
		            	dos.writeInt(this.NON_RECIPE_GROSS_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.NON_RECIPE_NET_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.NON_RECIPE_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.ADDITIVE_WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.COMMITTED_GROSS_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.PRODUCT_WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.COMMITTED_NET_QUANTITY);
					
					// String
				
						writeString(this.PDXR_PRODUCT_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.PDXR_AUTHORIZATION_UNITS);
					
					// int
				
		            	dos.writeInt(this.COMMITTED_WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.COMMITTED_WEIGHT_IN_AIR);
					
					// String
				
						writeString(this.PDXR_ADDITIVE_CODE,dos);
					
					// double
				
		            	dos.writeDouble(this.COMMITTED_CONV_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.COMMITTED_CONV_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.COMMITTED_CONV_COE);
					
					// double
				
		            	dos.writeDouble(this.COMMITTED_CONV_PRESSURE);
					
					// int
				
		            	dos.writeInt(this.MEASURED_QUANTITY_TYPE);
					
					// int
				
		            	dos.writeInt(this.INVENTORY_QUANTITY_TYPE);
					
					// int
				
		            	dos.writeInt(this.DERIVED_VALUES_DIRECTIVE);
					
					// double
				
		            	dos.writeDouble(this.PRESSURE);
					
					// String
				
						writeString(this.METER_PRESET_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.CALCULATE_NET);
					
					// int
				
		            	dos.writeInt(this.NON_RECIPE_WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.ADJUSTMENT_BATCH);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_OWNER_ID,dos);
					
					// String
				
						writeString(this.COMPARTMENT_CONTAINER_CODE,dos);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_CONTAINER_TYPE,dos);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_NUMBER,dos);
					
					// String
				
						writeString(this.PDXR_LOADING_REF,dos);
					
					// int
				
		            	dos.writeInt(this.BLEND_CORRECTION_METHOD);
					
					// double
				
		            	dos.writeDouble(this.BLEND_CORRECTION_NET_VOLUME);
					
					// double
				
		            	dos.writeDouble(this.TOTAL_BATCH_BLEND_NET_VOLUME);
					
					// int
				
		            	dos.writeInt(this.BLEND_CORRECTION_SOURCE);
					
					// int
				
		            	dos.writeInt(this.COMMODITY_GROUP);
					
					// int
				
		            	dos.writeInt(this.DERIVATION_STATUS);
					
					// String
				
						writeString(this.DERIVED_VALUES_ERROR,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("ORDER_ID="+String.valueOf(ORDER_ID));
		sb.append(",COMPARTMENT_ID="+String.valueOf(COMPARTMENT_ID));
		sb.append(",ORDER_RECIPE_ID="+String.valueOf(ORDER_RECIPE_ID));
		sb.append(",BAY_CODE="+BAY_CODE);
		sb.append(",API_CODE="+API_CODE);
		sb.append(",INJECTOR_PRESET_CODE="+INJECTOR_PRESET_CODE);
		sb.append(",TARE_SCALE_INTERFACE_CODE="+TARE_SCALE_INTERFACE_CODE);
		sb.append(",TANK_CODE="+TANK_CODE);
		sb.append(",PRODUCT_GROUP_CODE="+PRODUCT_GROUP_CODE);
		sb.append(",INJECTOR_CODE="+INJECTOR_CODE);
		sb.append(",METER_CODE="+METER_CODE);
		sb.append(",SUPPLIER_NUMBER="+String.valueOf(SUPPLIER_NUMBER));
		sb.append(",TERMINAL_PRODUCT_NUMBER="+String.valueOf(TERMINAL_PRODUCT_NUMBER));
		sb.append(",TERMINAL_PRODUCT_TYPE="+String.valueOf(TERMINAL_PRODUCT_TYPE));
		sb.append(",SHOST_SI_HOST_PRODUCT_NUMBER="+SHOST_SI_HOST_PRODUCT_NUMBER);
		sb.append(",BLEND_PERCENT="+String.valueOf(BLEND_PERCENT));
		sb.append(",RATE="+String.valueOf(RATE));
		sb.append(",THOST_TI_HOST_PRODUCT_NUMBER="+THOST_TI_HOST_PRODUCT_NUMBER);
		sb.append(",ORDERED_QUANTITY="+String.valueOf(ORDERED_QUANTITY));
		sb.append(",OVERRIDE_TEMPERATURE_ENABLE="+String.valueOf(OVERRIDE_TEMPERATURE_ENABLE));
		sb.append(",GROSS_QUANTITY="+String.valueOf(GROSS_QUANTITY));
		sb.append(",WEIGHT="+String.valueOf(WEIGHT));
		sb.append(",NET_QUANTITY="+String.valueOf(NET_QUANTITY));
		sb.append(",DENSITY="+String.valueOf(DENSITY));
		sb.append(",CUSTOMER_NET_QUANTITY="+String.valueOf(CUSTOMER_NET_QUANTITY));
		sb.append(",SPECIFIC_GRAVITY="+String.valueOf(SPECIFIC_GRAVITY));
		sb.append(",COEFFICIENT_EXPANSION="+String.valueOf(COEFFICIENT_EXPANSION));
		sb.append(",TEMPERATURE="+String.valueOf(TEMPERATURE));
		sb.append(",RVP="+String.valueOf(RVP));
		sb.append(",OXYGEN="+String.valueOf(OXYGEN));
		sb.append(",START_GROSS_TOTALIZER="+String.valueOf(START_GROSS_TOTALIZER));
		sb.append(",END_GROSS_TOTALIZER="+String.valueOf(END_GROSS_TOTALIZER));
		sb.append(",START_NET_TOTALIZER="+String.valueOf(START_NET_TOTALIZER));
		sb.append(",END_NET_TOTALIZER="+String.valueOf(END_NET_TOTALIZER));
		sb.append(",START_WEIGHT="+String.valueOf(START_WEIGHT));
		sb.append(",END_WEIGHT="+String.valueOf(END_WEIGHT));
		sb.append(",LAST_USER_NAME="+LAST_USER_NAME);
		sb.append(",LAST_MODIFIED="+String.valueOf(LAST_MODIFIED));
		sb.append(",START_TIME="+String.valueOf(START_TIME));
		sb.append(",END_TIME="+String.valueOf(END_TIME));
		sb.append(",ADDITIVE_QUANTITY="+String.valueOf(ADDITIVE_QUANTITY));
		sb.append(",PRODUCT_QUANTITY="+String.valueOf(PRODUCT_QUANTITY));
		sb.append(",HOST_PRODUCT_CODE="+HOST_PRODUCT_CODE);
		sb.append(",HOST_PRODUCT_NAME="+HOST_PRODUCT_NAME);
		sb.append(",FROM_LEFT_ON_TRUCK="+String.valueOf(FROM_LEFT_ON_TRUCK));
		sb.append(",OBSERVED_DENSITY="+String.valueOf(OBSERVED_DENSITY));
		sb.append(",COMPONENT_ID="+String.valueOf(COMPONENT_ID));
		sb.append(",CALCULATE_SECONDARY_UNITS="+String.valueOf(CALCULATE_SECONDARY_UNITS));
		sb.append(",FINAL_SCALE_INTERFACE_CODE="+FINAL_SCALE_INTERFACE_CODE);
		sb.append(",FRAC_START_GROSS_TOTALIZER="+String.valueOf(FRAC_START_GROSS_TOTALIZER));
		sb.append(",FRAC_END_GROSS_TOTALIZER="+String.valueOf(FRAC_END_GROSS_TOTALIZER));
		sb.append(",PETROEX_COMPONENT_PRODUCT_CODE="+PETROEX_COMPONENT_PRODUCT_CODE);
		sb.append(",PRODUCT_TOLERANCE_STATUS="+String.valueOf(PRODUCT_TOLERANCE_STATUS));
		sb.append(",TANK_INVENTORY_UPDATED="+String.valueOf(TANK_INVENTORY_UPDATED));
		sb.append(",TOTALIZER_UPDATED="+String.valueOf(TOTALIZER_UPDATED));
		sb.append(",FLUSH_STATUS="+String.valueOf(FLUSH_STATUS));
		sb.append(",REDUCED_PRODUCT_NUMBER="+String.valueOf(REDUCED_PRODUCT_NUMBER));
		sb.append(",ADDITIVE_WEIGHT="+String.valueOf(ADDITIVE_WEIGHT));
		sb.append(",PRODUCT_WEIGHT="+String.valueOf(PRODUCT_WEIGHT));
		sb.append(",RT_INJECTOR_ALARM_COUNT="+String.valueOf(RT_INJECTOR_ALARM_COUNT));
		sb.append(",BATCH_NUMBER="+String.valueOf(BATCH_NUMBER));
		sb.append(",VRU_CODE="+VRU_CODE);
		sb.append(",ADDITIVE_MASKING="+String.valueOf(ADDITIVE_MASKING));
		sb.append(",COMPATIBILITY_STATUS="+String.valueOf(COMPATIBILITY_STATUS));
		sb.append(",RECIPE_CORRECTION_TYPE="+String.valueOf(RECIPE_CORRECTION_TYPE));
		sb.append(",NON_RECIPE_GROSS_QUANTITY="+String.valueOf(NON_RECIPE_GROSS_QUANTITY));
		sb.append(",NON_RECIPE_NET_QUANTITY="+String.valueOf(NON_RECIPE_NET_QUANTITY));
		sb.append(",NON_RECIPE_WEIGHT="+String.valueOf(NON_RECIPE_WEIGHT));
		sb.append(",WEIGHT_IN_VAC="+String.valueOf(WEIGHT_IN_VAC));
		sb.append(",ADDITIVE_WEIGHT_IN_VAC="+String.valueOf(ADDITIVE_WEIGHT_IN_VAC));
		sb.append(",COMMITTED_GROSS_QUANTITY="+String.valueOf(COMMITTED_GROSS_QUANTITY));
		sb.append(",PRODUCT_WEIGHT_IN_VAC="+String.valueOf(PRODUCT_WEIGHT_IN_VAC));
		sb.append(",COMMITTED_NET_QUANTITY="+String.valueOf(COMMITTED_NET_QUANTITY));
		sb.append(",PDXR_PRODUCT_CODE="+PDXR_PRODUCT_CODE);
		sb.append(",PDXR_AUTHORIZATION_UNITS="+String.valueOf(PDXR_AUTHORIZATION_UNITS));
		sb.append(",COMMITTED_WEIGHT_IN_VAC="+String.valueOf(COMMITTED_WEIGHT_IN_VAC));
		sb.append(",COMMITTED_WEIGHT_IN_AIR="+String.valueOf(COMMITTED_WEIGHT_IN_AIR));
		sb.append(",PDXR_ADDITIVE_CODE="+PDXR_ADDITIVE_CODE);
		sb.append(",COMMITTED_CONV_TEMPERATURE="+String.valueOf(COMMITTED_CONV_TEMPERATURE));
		sb.append(",COMMITTED_CONV_DENSITY="+String.valueOf(COMMITTED_CONV_DENSITY));
		sb.append(",COMMITTED_CONV_COE="+String.valueOf(COMMITTED_CONV_COE));
		sb.append(",COMMITTED_CONV_PRESSURE="+String.valueOf(COMMITTED_CONV_PRESSURE));
		sb.append(",MEASURED_QUANTITY_TYPE="+String.valueOf(MEASURED_QUANTITY_TYPE));
		sb.append(",INVENTORY_QUANTITY_TYPE="+String.valueOf(INVENTORY_QUANTITY_TYPE));
		sb.append(",DERIVED_VALUES_DIRECTIVE="+String.valueOf(DERIVED_VALUES_DIRECTIVE));
		sb.append(",PRESSURE="+String.valueOf(PRESSURE));
		sb.append(",METER_PRESET_CODE="+METER_PRESET_CODE);
		sb.append(",CALCULATE_NET="+String.valueOf(CALCULATE_NET));
		sb.append(",NON_RECIPE_WEIGHT_IN_VAC="+String.valueOf(NON_RECIPE_WEIGHT_IN_VAC));
		sb.append(",ADJUSTMENT_BATCH="+String.valueOf(ADJUSTMENT_BATCH));
		sb.append(",COMPARTMENT_OWNER_ID="+String.valueOf(COMPARTMENT_OWNER_ID));
		sb.append(",COMPARTMENT_CONTAINER_CODE="+COMPARTMENT_CONTAINER_CODE);
		sb.append(",COMPARTMENT_CONTAINER_TYPE="+String.valueOf(COMPARTMENT_CONTAINER_TYPE));
		sb.append(",COMPARTMENT_NUMBER="+String.valueOf(COMPARTMENT_NUMBER));
		sb.append(",PDXR_LOADING_REF="+PDXR_LOADING_REF);
		sb.append(",BLEND_CORRECTION_METHOD="+String.valueOf(BLEND_CORRECTION_METHOD));
		sb.append(",BLEND_CORRECTION_NET_VOLUME="+String.valueOf(BLEND_CORRECTION_NET_VOLUME));
		sb.append(",TOTAL_BATCH_BLEND_NET_VOLUME="+String.valueOf(TOTAL_BATCH_BLEND_NET_VOLUME));
		sb.append(",BLEND_CORRECTION_SOURCE="+String.valueOf(BLEND_CORRECTION_SOURCE));
		sb.append(",COMMODITY_GROUP="+String.valueOf(COMMODITY_GROUP));
		sb.append(",DERIVATION_STATUS="+String.valueOf(DERIVATION_STATUS));
		sb.append(",DERIVED_VALUES_ERROR="+DERIVED_VALUES_ERROR);
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
        } else if (updateKeyCount_tDBOutput_1 == 24 && true) {
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

 
	final String decryptedPassword_tDBOutput_1 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:3dex6IuRVmeGC/QdbDjfbWeat8ORVA/E7Rla9Ko0W/QHVvdQWQM=");

    String dbPwd_tDBOutput_1 = decryptedPassword_tDBOutput_1;	
    conn_tDBOutput_1 = java.sql.DriverManager.getConnection(url_tDBOutput_1,dbUser_tDBOutput_1,dbPwd_tDBOutput_1);
	
		resourceMap.put("conn_tDBOutput_1", conn_tDBOutput_1);
	
        conn_tDBOutput_1.setAutoCommit(false);
        int commitEvery_tDBOutput_1 = 10000;
        int commitCounter_tDBOutput_1 = 0;


if(dbschema_tDBOutput_1 == null || dbschema_tDBOutput_1.trim().length() == 0) {
    tableName_tDBOutput_1 = "DIM_ORDER_RECIPE";
} else {
    tableName_tDBOutput_1 = dbschema_tDBOutput_1 + "].[" + "DIM_ORDER_RECIPE";
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
                                        stmtCreate_tDBOutput_1.execute("CREATE TABLE [" + tableName_tDBOutput_1 + "]([PK_ORDER_RECIPE] INT  not null ,[ORDER_ID] INT  not null ,[COMPARTMENT_ID] INT  not null ,[ORDER_RECIPE_ID] INT  not null ,[BAY_CODE] VARCHAR(10)  ,[API_CODE] VARCHAR(4)  ,[TANK_CODE] VARCHAR(20)  ,[PRODUCT_GROUP_CODE] VARCHAR(6)   not null ,[METER_CODE] VARCHAR(10)  ,[SUPPLIER_NUMBER] INT ,[TERMINAL_PRODUCT_NUMBER] INT  not null ,[START_TIME] DATETIME ,[END_TIME] DATETIME ,[COMPONENT_ID] INT  not null ,[PRODUCT_TOLERANCE_STATUS] INT  not null ,[TOTALIZER_UPDATED] INT  not null ,[BATCH_NUMBER] INT  not null ,[RECIPE_CORRECTION_TYPE] INT  not null ,[INVENTORY_QUANTITY_TYPE] INT  not null ,[DERIVED_VALUES_DIRECTIVE] INT  not null ,[METER_PRESET_CODE] VARCHAR(10)  ,[CALCULATE_NET] INT  not null ,[COMPARTMENT_OWNER_ID] INT ,[COMPARTMENT_CONTAINER_CODE] VARCHAR(20)  ,primary key([PK_ORDER_RECIPE]))");
                                    }
                                }
        java.sql.PreparedStatement pstmt_tDBOutput_1 = conn_tDBOutput_1.prepareStatement("SELECT COUNT(1) FROM [" + tableName_tDBOutput_1 + "] WHERE [PK_ORDER_RECIPE] = ?");
        resourceMap.put("pstmt_tDBOutput_1", pstmt_tDBOutput_1);
        String insert_tDBOutput_1 = "INSERT INTO [" + tableName_tDBOutput_1 + "] ([PK_ORDER_RECIPE],[ORDER_ID],[COMPARTMENT_ID],[ORDER_RECIPE_ID],[BAY_CODE],[API_CODE],[TANK_CODE],[PRODUCT_GROUP_CODE],[METER_CODE],[SUPPLIER_NUMBER],[TERMINAL_PRODUCT_NUMBER],[START_TIME],[END_TIME],[COMPONENT_ID],[PRODUCT_TOLERANCE_STATUS],[TOTALIZER_UPDATED],[BATCH_NUMBER],[RECIPE_CORRECTION_TYPE],[INVENTORY_QUANTITY_TYPE],[DERIVED_VALUES_DIRECTIVE],[METER_PRESET_CODE],[CALCULATE_NET],[COMPARTMENT_OWNER_ID],[COMPARTMENT_CONTAINER_CODE]) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        java.sql.PreparedStatement pstmtInsert_tDBOutput_1 = conn_tDBOutput_1.prepareStatement(insert_tDBOutput_1);
        resourceMap.put("pstmtInsert_tDBOutput_1", pstmtInsert_tDBOutput_1);
        String update_tDBOutput_1 = "UPDATE [" + tableName_tDBOutput_1 + "] SET [ORDER_ID] = ?,[COMPARTMENT_ID] = ?,[ORDER_RECIPE_ID] = ?,[BAY_CODE] = ?,[API_CODE] = ?,[TANK_CODE] = ?,[PRODUCT_GROUP_CODE] = ?,[METER_CODE] = ?,[SUPPLIER_NUMBER] = ?,[TERMINAL_PRODUCT_NUMBER] = ?,[START_TIME] = ?,[END_TIME] = ?,[COMPONENT_ID] = ?,[PRODUCT_TOLERANCE_STATUS] = ?,[TOTALIZER_UPDATED] = ?,[BATCH_NUMBER] = ?,[RECIPE_CORRECTION_TYPE] = ?,[INVENTORY_QUANTITY_TYPE] = ?,[DERIVED_VALUES_DIRECTIVE] = ?,[METER_PRESET_CODE] = ?,[CALCULATE_NET] = ?,[COMPARTMENT_OWNER_ID] = ?,[COMPARTMENT_CONTAINER_CODE] = ? WHERE [PK_ORDER_RECIPE] = ?";
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
	int PK_ORDER_RECIPE;
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
					int ORDER_RECIPE_ID;        
	        
		    @Override
			public int hashCode() {
				if (this.hashCodeDirty) {
					final int prime = PRIME;
					int result = DEFAULT_HASHCODE;
			
									result = prime * result + (int) this.ORDER_ID;
									
									result = prime * result + (int) this.ORDER_RECIPE_ID;
									
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
								
									if (this.ORDER_RECIPE_ID != other.ORDER_RECIPE_ID) 
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
				
				 
	final String decryptedPassword_tDBInput_1 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:8c1dKuZWh8j7ygJ86YycwCoQjKA+6ZmteNrzIbtN1NBnKarMPUw=");
				
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

		    String dbquery_tDBInput_1 = "SELECT dbo.ORDER_RECIPE.ORDER_ID,\n		dbo.ORDER_RECIPE.COMPARTMENT_ID,\n		dbo.ORDER_RECIPE.ORDER_RECIPE_ID,\n		dbo.ORDER_RE"
+"CIPE.BAY_CODE,\n		dbo.ORDER_RECIPE.API_CODE,\n		dbo.ORDER_RECIPE.INJECTOR_PRESET_CODE,\n		dbo.ORDER_RECIPE.TARE_SCALE_INTER"
+"FACE_CODE,\n		dbo.ORDER_RECIPE.TANK_CODE,\n		dbo.ORDER_RECIPE.PRODUCT_GROUP_CODE,\n		dbo.ORDER_RECIPE.INJECTOR_CODE,\n		dbo."
+"ORDER_RECIPE.METER_CODE,\n		dbo.ORDER_RECIPE.SUPPLIER_NUMBER,\n		dbo.ORDER_RECIPE.TERMINAL_PRODUCT_NUMBER,\n		dbo.ORDER_REC"
+"IPE.TERMINAL_PRODUCT_TYPE,\n		dbo.ORDER_RECIPE.SHOST_SI_HOST_PRODUCT_NUMBER,\n		dbo.ORDER_RECIPE.BLEND_PERCENT,\n		dbo.ORDE"
+"R_RECIPE.RATE,\n		dbo.ORDER_RECIPE.THOST_TI_HOST_PRODUCT_NUMBER,\n		dbo.ORDER_RECIPE.ORDERED_QUANTITY,\n		dbo.ORDER_RECIPE."
+"OVERRIDE_TEMPERATURE_ENABLE,\n		dbo.ORDER_RECIPE.GROSS_QUANTITY,\n		dbo.ORDER_RECIPE.WEIGHT,\n		dbo.ORDER_RECIPE.NET_QUANTI"
+"TY,\n		dbo.ORDER_RECIPE.DENSITY,\n		dbo.ORDER_RECIPE.CUSTOMER_NET_QUANTITY,\n		dbo.ORDER_RECIPE.SPECIFIC_GRAVITY,\n		dbo.ORD"
+"ER_RECIPE.COEFFICIENT_EXPANSION,\n		dbo.ORDER_RECIPE.TEMPERATURE,\n		dbo.ORDER_RECIPE.RVP,\n		dbo.ORDER_RECIPE.OXYGEN,\n		db"
+"o.ORDER_RECIPE.START_GROSS_TOTALIZER,\n		dbo.ORDER_RECIPE.END_GROSS_TOTALIZER,\n		dbo.ORDER_RECIPE.START_NET_TOTALIZER,\n		"
+"dbo.ORDER_RECIPE.END_NET_TOTALIZER,\n		dbo.ORDER_RECIPE.START_WEIGHT,\n		dbo.ORDER_RECIPE.END_WEIGHT,\n		dbo.ORDER_RECIPE.L"
+"AST_USER_NAME,\n		dbo.ORDER_RECIPE.LAST_MODIFIED,\n		dbo.ORDER_RECIPE.START_TIME,\n		dbo.ORDER_RECIPE.END_TIME,\n		dbo.ORDER"
+"_RECIPE.ADDITIVE_QUANTITY,\n		dbo.ORDER_RECIPE.PRODUCT_QUANTITY,\n		dbo.ORDER_RECIPE.HOST_PRODUCT_CODE,\n		dbo.ORDER_RECIPE"
+".HOST_PRODUCT_NAME,\n		dbo.ORDER_RECIPE.FROM_LEFT_ON_TRUCK,\n		dbo.ORDER_RECIPE.OBSERVED_DENSITY,\n		dbo.ORDER_RECIPE.COMPO"
+"NENT_ID,\n		dbo.ORDER_RECIPE.CALCULATE_SECONDARY_UNITS,\n		dbo.ORDER_RECIPE.FINAL_SCALE_INTERFACE_CODE,\n		dbo.ORDER_RECIPE"
+".FRAC_START_GROSS_TOTALIZER,\n		dbo.ORDER_RECIPE.FRAC_END_GROSS_TOTALIZER,\n		dbo.ORDER_RECIPE.PETROEX_COMPONENT_PRODUCT_C"
+"ODE,\n		dbo.ORDER_RECIPE.PRODUCT_TOLERANCE_STATUS,\n		dbo.ORDER_RECIPE.TANK_INVENTORY_UPDATED,\n		dbo.ORDER_RECIPE.TOTALIZE"
+"R_UPDATED,\n		dbo.ORDER_RECIPE.FLUSH_STATUS,\n		dbo.ORDER_RECIPE.REDUCED_PRODUCT_NUMBER,\n		dbo.ORDER_RECIPE.ADDITIVE_WEIGH"
+"T,\n		dbo.ORDER_RECIPE.PRODUCT_WEIGHT,\n		dbo.ORDER_RECIPE.RT_INJECTOR_ALARM_COUNT,\n		dbo.ORDER_RECIPE.BATCH_NUMBER,\n		dbo"
+".ORDER_RECIPE.VRU_CODE,\n		dbo.ORDER_RECIPE.ADDITIVE_MASKING,\n		dbo.ORDER_RECIPE.COMPATIBILITY_STATUS,\n		dbo.ORDER_RECIPE"
+".RECIPE_CORRECTION_TYPE,\n		dbo.ORDER_RECIPE.NON_RECIPE_GROSS_QUANTITY,\n		dbo.ORDER_RECIPE.NON_RECIPE_NET_QUANTITY,\n		dbo"
+".ORDER_RECIPE.NON_RECIPE_WEIGHT,\n		dbo.ORDER_RECIPE.WEIGHT_IN_VAC,\n		dbo.ORDER_RECIPE.ADDITIVE_WEIGHT_IN_VAC,\n		dbo.ORDE"
+"R_RECIPE.COMMITTED_GROSS_QUANTITY,\n		dbo.ORDER_RECIPE.PRODUCT_WEIGHT_IN_VAC,\n		dbo.ORDER_RECIPE.COMMITTED_NET_QUANTITY,\n"
+"		dbo.ORDER_RECIPE.PDXR_PRODUCT_CODE,\n		dbo.ORDER_RECIPE.PDXR_AUTHORIZATION_UNITS,\n		dbo.ORDER_RECIPE.COMMITTED_WEIGHT_I"
+"N_VAC,\n		dbo.ORDER_RECIPE.COMMITTED_WEIGHT_IN_AIR,\n		dbo.ORDER_RECIPE.PDXR_ADDITIVE_CODE,\n		dbo.ORDER_RECIPE.COMMITTED_C"
+"ONV_TEMPERATURE,\n		dbo.ORDER_RECIPE.COMMITTED_CONV_DENSITY,\n		dbo.ORDER_RECIPE.COMMITTED_CONV_COE,\n		dbo.ORDER_RECIPE.CO"
+"MMITTED_CONV_PRESSURE,\n		dbo.ORDER_RECIPE.MEASURED_QUANTITY_TYPE,\n		dbo.ORDER_RECIPE.INVENTORY_QUANTITY_TYPE,\n		dbo.ORDE"
+"R_RECIPE.DERIVED_VALUES_DIRECTIVE,\n		dbo.ORDER_RECIPE.PRESSURE,\n		dbo.ORDER_RECIPE.METER_PRESET_CODE,\n		dbo.ORDER_RECIPE"
+".CALCULATE_NET,\n		dbo.ORDER_RECIPE.NON_RECIPE_WEIGHT_IN_VAC,\n		dbo.ORDER_RECIPE.ADJUSTMENT_BATCH,\n		dbo.ORDER_RECIPE.COM"
+"PARTMENT_OWNER_ID,\n		dbo.ORDER_RECIPE.COMPARTMENT_CONTAINER_CODE,\n		dbo.ORDER_RECIPE.COMPARTMENT_CONTAINER_TYPE,\n		dbo.O"
+"RDER_RECIPE.COMPARTMENT_NUMBER,\n		dbo.ORDER_RECIPE.PDXR_LOADING_REF,\n		dbo.ORDER_RECIPE.BLEND_CORRECTION_METHOD,\n		dbo.O"
+"RDER_RECIPE.BLEND_CORRECTION_NET_VOLUME,\n		dbo.ORDER_RECIPE.TOTAL_BATCH_BLEND_NET_VOLUME,\n		dbo.ORDER_RECIPE.BLEND_CORRE"
+"CTION_SOURCE,\n		dbo.ORDER_RECIPE.COMMODITY_GROUP,\n		dbo.ORDER_RECIPE.DERIVATION_STATUS,\n		dbo.ORDER_RECIPE.DERIVED_VALUE"
+"S_ERROR\nFROM	dbo.ORDER_RECIPE";
		    

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
								row1.COMPARTMENT_ID = 0;
							} else {
		                          
            row1.COMPARTMENT_ID = rs_tDBInput_1.getInt(2);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 3) {
								row1.ORDER_RECIPE_ID = 0;
							} else {
		                          
            row1.ORDER_RECIPE_ID = rs_tDBInput_1.getInt(3);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 4) {
								row1.BAY_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(4);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(4).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.BAY_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.BAY_CODE = tmpContent_tDBInput_1;
                }
            } else {
                row1.BAY_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 5) {
								row1.API_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(5);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(5).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.API_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.API_CODE = tmpContent_tDBInput_1;
                }
            } else {
                row1.API_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 6) {
								row1.INJECTOR_PRESET_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(6);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(6).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.INJECTOR_PRESET_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.INJECTOR_PRESET_CODE = tmpContent_tDBInput_1;
                }
            } else {
                row1.INJECTOR_PRESET_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 7) {
								row1.TARE_SCALE_INTERFACE_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(7);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(7).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.TARE_SCALE_INTERFACE_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.TARE_SCALE_INTERFACE_CODE = tmpContent_tDBInput_1;
                }
            } else {
                row1.TARE_SCALE_INTERFACE_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 8) {
								row1.TANK_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(8);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(8).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.TANK_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.TANK_CODE = tmpContent_tDBInput_1;
                }
            } else {
                row1.TANK_CODE = null;
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
								row1.INJECTOR_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(10);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(10).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.INJECTOR_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.INJECTOR_CODE = tmpContent_tDBInput_1;
                }
            } else {
                row1.INJECTOR_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 11) {
								row1.METER_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(11);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(11).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.METER_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.METER_CODE = tmpContent_tDBInput_1;
                }
            } else {
                row1.METER_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 12) {
								row1.SUPPLIER_NUMBER = null;
							} else {
		                          
            row1.SUPPLIER_NUMBER = rs_tDBInput_1.getInt(12);
            if(rs_tDBInput_1.wasNull()){
                    row1.SUPPLIER_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 13) {
								row1.TERMINAL_PRODUCT_NUMBER = 0;
							} else {
		                          
            row1.TERMINAL_PRODUCT_NUMBER = rs_tDBInput_1.getInt(13);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 14) {
								row1.TERMINAL_PRODUCT_TYPE = 0;
							} else {
		                          
            row1.TERMINAL_PRODUCT_TYPE = rs_tDBInput_1.getInt(14);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 15) {
								row1.SHOST_SI_HOST_PRODUCT_NUMBER = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(15);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(15).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.SHOST_SI_HOST_PRODUCT_NUMBER = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.SHOST_SI_HOST_PRODUCT_NUMBER = tmpContent_tDBInput_1;
                }
            } else {
                row1.SHOST_SI_HOST_PRODUCT_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 16) {
								row1.BLEND_PERCENT = 0;
							} else {
	                         		
            row1.BLEND_PERCENT = rs_tDBInput_1.getDouble(16);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 17) {
								row1.RATE = 0;
							} else {
		                          
            row1.RATE = rs_tDBInput_1.getInt(17);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 18) {
								row1.THOST_TI_HOST_PRODUCT_NUMBER = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(18);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(18).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.THOST_TI_HOST_PRODUCT_NUMBER = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.THOST_TI_HOST_PRODUCT_NUMBER = tmpContent_tDBInput_1;
                }
            } else {
                row1.THOST_TI_HOST_PRODUCT_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 19) {
								row1.ORDERED_QUANTITY = 0;
							} else {
		                          
            row1.ORDERED_QUANTITY = rs_tDBInput_1.getInt(19);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 20) {
								row1.OVERRIDE_TEMPERATURE_ENABLE = 0;
							} else {
		                          
            row1.OVERRIDE_TEMPERATURE_ENABLE = rs_tDBInput_1.getInt(20);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
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
								row1.WEIGHT = 0;
							} else {
		                          
            row1.WEIGHT = rs_tDBInput_1.getInt(22);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 23) {
								row1.NET_QUANTITY = 0;
							} else {
		                          
            row1.NET_QUANTITY = rs_tDBInput_1.getInt(23);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 24) {
								row1.DENSITY = 0;
							} else {
	                         		
            row1.DENSITY = rs_tDBInput_1.getDouble(24);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 25) {
								row1.CUSTOMER_NET_QUANTITY = 0;
							} else {
		                          
            row1.CUSTOMER_NET_QUANTITY = rs_tDBInput_1.getInt(25);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 26) {
								row1.SPECIFIC_GRAVITY = 0;
							} else {
	                         		
            row1.SPECIFIC_GRAVITY = rs_tDBInput_1.getDouble(26);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 27) {
								row1.COEFFICIENT_EXPANSION = 0;
							} else {
	                         		
            row1.COEFFICIENT_EXPANSION = rs_tDBInput_1.getDouble(27);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 28) {
								row1.TEMPERATURE = 0;
							} else {
	                         		
            row1.TEMPERATURE = rs_tDBInput_1.getDouble(28);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 29) {
								row1.RVP = 0;
							} else {
	                         		
            row1.RVP = rs_tDBInput_1.getDouble(29);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 30) {
								row1.OXYGEN = 0;
							} else {
	                         		
            row1.OXYGEN = rs_tDBInput_1.getDouble(30);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 31) {
								row1.START_GROSS_TOTALIZER = 0;
							} else {
		                          
            row1.START_GROSS_TOTALIZER = rs_tDBInput_1.getInt(31);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 32) {
								row1.END_GROSS_TOTALIZER = 0;
							} else {
		                          
            row1.END_GROSS_TOTALIZER = rs_tDBInput_1.getInt(32);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 33) {
								row1.START_NET_TOTALIZER = 0;
							} else {
		                          
            row1.START_NET_TOTALIZER = rs_tDBInput_1.getInt(33);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 34) {
								row1.END_NET_TOTALIZER = 0;
							} else {
		                          
            row1.END_NET_TOTALIZER = rs_tDBInput_1.getInt(34);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 35) {
								row1.START_WEIGHT = 0;
							} else {
		                          
            row1.START_WEIGHT = rs_tDBInput_1.getInt(35);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 36) {
								row1.END_WEIGHT = 0;
							} else {
		                          
            row1.END_WEIGHT = rs_tDBInput_1.getInt(36);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 37) {
								row1.LAST_USER_NAME = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(37);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(37).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.LAST_USER_NAME = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.LAST_USER_NAME = tmpContent_tDBInput_1;
                }
            } else {
                row1.LAST_USER_NAME = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 38) {
								row1.LAST_MODIFIED = null;
							} else {
										
			row1.LAST_MODIFIED = mssqlGTU_tDBInput_1.getDate(rsmd_tDBInput_1, rs_tDBInput_1, 38);
			
		                    }
							if(colQtyInRs_tDBInput_1 < 39) {
								row1.START_TIME = null;
							} else {
										
			row1.START_TIME = mssqlGTU_tDBInput_1.getDate(rsmd_tDBInput_1, rs_tDBInput_1, 39);
			
		                    }
							if(colQtyInRs_tDBInput_1 < 40) {
								row1.END_TIME = null;
							} else {
										
			row1.END_TIME = mssqlGTU_tDBInput_1.getDate(rsmd_tDBInput_1, rs_tDBInput_1, 40);
			
		                    }
							if(colQtyInRs_tDBInput_1 < 41) {
								row1.ADDITIVE_QUANTITY = 0;
							} else {
		                          
            row1.ADDITIVE_QUANTITY = rs_tDBInput_1.getInt(41);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 42) {
								row1.PRODUCT_QUANTITY = 0;
							} else {
		                          
            row1.PRODUCT_QUANTITY = rs_tDBInput_1.getInt(42);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 43) {
								row1.HOST_PRODUCT_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(43);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(43).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.HOST_PRODUCT_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.HOST_PRODUCT_CODE = tmpContent_tDBInput_1;
                }
            } else {
                row1.HOST_PRODUCT_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 44) {
								row1.HOST_PRODUCT_NAME = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(44);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(44).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.HOST_PRODUCT_NAME = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.HOST_PRODUCT_NAME = tmpContent_tDBInput_1;
                }
            } else {
                row1.HOST_PRODUCT_NAME = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 45) {
								row1.FROM_LEFT_ON_TRUCK = 0;
							} else {
		                          
            row1.FROM_LEFT_ON_TRUCK = rs_tDBInput_1.getInt(45);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 46) {
								row1.OBSERVED_DENSITY = 0;
							} else {
	                         		
            row1.OBSERVED_DENSITY = rs_tDBInput_1.getDouble(46);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 47) {
								row1.COMPONENT_ID = 0;
							} else {
		                          
            row1.COMPONENT_ID = rs_tDBInput_1.getInt(47);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 48) {
								row1.CALCULATE_SECONDARY_UNITS = 0;
							} else {
		                          
            row1.CALCULATE_SECONDARY_UNITS = rs_tDBInput_1.getInt(48);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 49) {
								row1.FINAL_SCALE_INTERFACE_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(49);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(49).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.FINAL_SCALE_INTERFACE_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.FINAL_SCALE_INTERFACE_CODE = tmpContent_tDBInput_1;
                }
            } else {
                row1.FINAL_SCALE_INTERFACE_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 50) {
								row1.FRAC_START_GROSS_TOTALIZER = 0;
							} else {
		                          
            row1.FRAC_START_GROSS_TOTALIZER = rs_tDBInput_1.getInt(50);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 51) {
								row1.FRAC_END_GROSS_TOTALIZER = 0;
							} else {
		                          
            row1.FRAC_END_GROSS_TOTALIZER = rs_tDBInput_1.getInt(51);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 52) {
								row1.PETROEX_COMPONENT_PRODUCT_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(52);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(52).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.PETROEX_COMPONENT_PRODUCT_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.PETROEX_COMPONENT_PRODUCT_CODE = tmpContent_tDBInput_1;
                }
            } else {
                row1.PETROEX_COMPONENT_PRODUCT_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 53) {
								row1.PRODUCT_TOLERANCE_STATUS = 0;
							} else {
		                          
            row1.PRODUCT_TOLERANCE_STATUS = rs_tDBInput_1.getInt(53);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 54) {
								row1.TANK_INVENTORY_UPDATED = 0;
							} else {
		                          
            row1.TANK_INVENTORY_UPDATED = rs_tDBInput_1.getInt(54);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 55) {
								row1.TOTALIZER_UPDATED = 0;
							} else {
		                          
            row1.TOTALIZER_UPDATED = rs_tDBInput_1.getInt(55);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 56) {
								row1.FLUSH_STATUS = 0;
							} else {
		                          
            row1.FLUSH_STATUS = rs_tDBInput_1.getInt(56);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 57) {
								row1.REDUCED_PRODUCT_NUMBER = null;
							} else {
		                          
            row1.REDUCED_PRODUCT_NUMBER = rs_tDBInput_1.getInt(57);
            if(rs_tDBInput_1.wasNull()){
                    row1.REDUCED_PRODUCT_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 58) {
								row1.ADDITIVE_WEIGHT = 0;
							} else {
		                          
            row1.ADDITIVE_WEIGHT = rs_tDBInput_1.getInt(58);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 59) {
								row1.PRODUCT_WEIGHT = 0;
							} else {
		                          
            row1.PRODUCT_WEIGHT = rs_tDBInput_1.getInt(59);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 60) {
								row1.RT_INJECTOR_ALARM_COUNT = 0;
							} else {
		                          
            row1.RT_INJECTOR_ALARM_COUNT = rs_tDBInput_1.getInt(60);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 61) {
								row1.BATCH_NUMBER = 0;
							} else {
		                          
            row1.BATCH_NUMBER = rs_tDBInput_1.getInt(61);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 62) {
								row1.VRU_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(62);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(62).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.VRU_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.VRU_CODE = tmpContent_tDBInput_1;
                }
            } else {
                row1.VRU_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 63) {
								row1.ADDITIVE_MASKING = 0;
							} else {
		                          
            row1.ADDITIVE_MASKING = rs_tDBInput_1.getInt(63);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 64) {
								row1.COMPATIBILITY_STATUS = 0;
							} else {
		                          
            row1.COMPATIBILITY_STATUS = rs_tDBInput_1.getInt(64);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 65) {
								row1.RECIPE_CORRECTION_TYPE = 0;
							} else {
		                          
            row1.RECIPE_CORRECTION_TYPE = rs_tDBInput_1.getInt(65);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 66) {
								row1.NON_RECIPE_GROSS_QUANTITY = 0;
							} else {
		                          
            row1.NON_RECIPE_GROSS_QUANTITY = rs_tDBInput_1.getInt(66);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 67) {
								row1.NON_RECIPE_NET_QUANTITY = 0;
							} else {
		                          
            row1.NON_RECIPE_NET_QUANTITY = rs_tDBInput_1.getInt(67);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 68) {
								row1.NON_RECIPE_WEIGHT = 0;
							} else {
		                          
            row1.NON_RECIPE_WEIGHT = rs_tDBInput_1.getInt(68);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 69) {
								row1.WEIGHT_IN_VAC = 0;
							} else {
		                          
            row1.WEIGHT_IN_VAC = rs_tDBInput_1.getInt(69);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 70) {
								row1.ADDITIVE_WEIGHT_IN_VAC = 0;
							} else {
		                          
            row1.ADDITIVE_WEIGHT_IN_VAC = rs_tDBInput_1.getInt(70);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 71) {
								row1.COMMITTED_GROSS_QUANTITY = 0;
							} else {
		                          
            row1.COMMITTED_GROSS_QUANTITY = rs_tDBInput_1.getInt(71);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 72) {
								row1.PRODUCT_WEIGHT_IN_VAC = 0;
							} else {
		                          
            row1.PRODUCT_WEIGHT_IN_VAC = rs_tDBInput_1.getInt(72);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 73) {
								row1.COMMITTED_NET_QUANTITY = 0;
							} else {
		                          
            row1.COMMITTED_NET_QUANTITY = rs_tDBInput_1.getInt(73);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 74) {
								row1.PDXR_PRODUCT_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(74);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(74).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.PDXR_PRODUCT_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.PDXR_PRODUCT_CODE = tmpContent_tDBInput_1;
                }
            } else {
                row1.PDXR_PRODUCT_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 75) {
								row1.PDXR_AUTHORIZATION_UNITS = 0;
							} else {
		                          
            row1.PDXR_AUTHORIZATION_UNITS = rs_tDBInput_1.getInt(75);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 76) {
								row1.COMMITTED_WEIGHT_IN_VAC = 0;
							} else {
		                          
            row1.COMMITTED_WEIGHT_IN_VAC = rs_tDBInput_1.getInt(76);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 77) {
								row1.COMMITTED_WEIGHT_IN_AIR = 0;
							} else {
		                          
            row1.COMMITTED_WEIGHT_IN_AIR = rs_tDBInput_1.getInt(77);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 78) {
								row1.PDXR_ADDITIVE_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(78);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(78).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.PDXR_ADDITIVE_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.PDXR_ADDITIVE_CODE = tmpContent_tDBInput_1;
                }
            } else {
                row1.PDXR_ADDITIVE_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 79) {
								row1.COMMITTED_CONV_TEMPERATURE = 0;
							} else {
	                         		
            row1.COMMITTED_CONV_TEMPERATURE = rs_tDBInput_1.getDouble(79);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 80) {
								row1.COMMITTED_CONV_DENSITY = 0;
							} else {
	                         		
            row1.COMMITTED_CONV_DENSITY = rs_tDBInput_1.getDouble(80);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 81) {
								row1.COMMITTED_CONV_COE = 0;
							} else {
	                         		
            row1.COMMITTED_CONV_COE = rs_tDBInput_1.getDouble(81);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 82) {
								row1.COMMITTED_CONV_PRESSURE = 0;
							} else {
	                         		
            row1.COMMITTED_CONV_PRESSURE = rs_tDBInput_1.getDouble(82);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 83) {
								row1.MEASURED_QUANTITY_TYPE = 0;
							} else {
		                          
            row1.MEASURED_QUANTITY_TYPE = rs_tDBInput_1.getInt(83);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 84) {
								row1.INVENTORY_QUANTITY_TYPE = 0;
							} else {
		                          
            row1.INVENTORY_QUANTITY_TYPE = rs_tDBInput_1.getInt(84);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 85) {
								row1.DERIVED_VALUES_DIRECTIVE = 0;
							} else {
		                          
            row1.DERIVED_VALUES_DIRECTIVE = rs_tDBInput_1.getInt(85);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 86) {
								row1.PRESSURE = 0;
							} else {
	                         		
            row1.PRESSURE = rs_tDBInput_1.getDouble(86);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 87) {
								row1.METER_PRESET_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(87);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(87).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.METER_PRESET_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.METER_PRESET_CODE = tmpContent_tDBInput_1;
                }
            } else {
                row1.METER_PRESET_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 88) {
								row1.CALCULATE_NET = 0;
							} else {
		                          
            row1.CALCULATE_NET = rs_tDBInput_1.getInt(88);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 89) {
								row1.NON_RECIPE_WEIGHT_IN_VAC = 0;
							} else {
		                          
            row1.NON_RECIPE_WEIGHT_IN_VAC = rs_tDBInput_1.getInt(89);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 90) {
								row1.ADJUSTMENT_BATCH = 0;
							} else {
		                          
            row1.ADJUSTMENT_BATCH = rs_tDBInput_1.getInt(90);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 91) {
								row1.COMPARTMENT_OWNER_ID = null;
							} else {
		                          
            row1.COMPARTMENT_OWNER_ID = rs_tDBInput_1.getInt(91);
            if(rs_tDBInput_1.wasNull()){
                    row1.COMPARTMENT_OWNER_ID = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 92) {
								row1.COMPARTMENT_CONTAINER_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(92);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(92).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.COMPARTMENT_CONTAINER_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.COMPARTMENT_CONTAINER_CODE = tmpContent_tDBInput_1;
                }
            } else {
                row1.COMPARTMENT_CONTAINER_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 93) {
								row1.COMPARTMENT_CONTAINER_TYPE = null;
							} else {
		                          
            row1.COMPARTMENT_CONTAINER_TYPE = rs_tDBInput_1.getInt(93);
            if(rs_tDBInput_1.wasNull()){
                    row1.COMPARTMENT_CONTAINER_TYPE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 94) {
								row1.COMPARTMENT_NUMBER = null;
							} else {
		                          
            row1.COMPARTMENT_NUMBER = rs_tDBInput_1.getInt(94);
            if(rs_tDBInput_1.wasNull()){
                    row1.COMPARTMENT_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 95) {
								row1.PDXR_LOADING_REF = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(95);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(95).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.PDXR_LOADING_REF = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.PDXR_LOADING_REF = tmpContent_tDBInput_1;
                }
            } else {
                row1.PDXR_LOADING_REF = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 96) {
								row1.BLEND_CORRECTION_METHOD = 0;
							} else {
		                          
            row1.BLEND_CORRECTION_METHOD = rs_tDBInput_1.getInt(96);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 97) {
								row1.BLEND_CORRECTION_NET_VOLUME = 0;
							} else {
	                         		
            row1.BLEND_CORRECTION_NET_VOLUME = rs_tDBInput_1.getDouble(97);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 98) {
								row1.TOTAL_BATCH_BLEND_NET_VOLUME = 0;
							} else {
	                         		
            row1.TOTAL_BATCH_BLEND_NET_VOLUME = rs_tDBInput_1.getDouble(98);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 99) {
								row1.BLEND_CORRECTION_SOURCE = 0;
							} else {
		                          
            row1.BLEND_CORRECTION_SOURCE = rs_tDBInput_1.getInt(99);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 100) {
								row1.COMMODITY_GROUP = 0;
							} else {
		                          
            row1.COMMODITY_GROUP = rs_tDBInput_1.getInt(100);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 101) {
								row1.DERIVATION_STATUS = 0;
							} else {
		                          
            row1.DERIVATION_STATUS = rs_tDBInput_1.getInt(101);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 102) {
								row1.DERIVED_VALUES_ERROR = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(102);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(102).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.DERIVED_VALUES_ERROR = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.DERIVED_VALUES_ERROR = tmpContent_tDBInput_1;
                }
            } else {
                row1.DERIVED_VALUES_ERROR = null;
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
finder_tUniqRow_1.ORDER_RECIPE_ID = row1.ORDER_RECIPE_ID;	
finder_tUniqRow_1.hashCodeDirty = true;
if (!keystUniqRow_1.contains(finder_tUniqRow_1)) {
		KeyStruct_tUniqRow_1 new_tUniqRow_1 = new KeyStruct_tUniqRow_1();

		
new_tUniqRow_1.ORDER_ID = row1.ORDER_ID;
new_tUniqRow_1.ORDER_RECIPE_ID = row1.ORDER_RECIPE_ID;
		
		keystUniqRow_1.add(new_tUniqRow_1);if(row2 == null){ 
	
	row2 = new row2Struct();
}row2.ORDER_ID = row1.ORDER_ID;			row2.COMPARTMENT_ID = row1.COMPARTMENT_ID;			row2.ORDER_RECIPE_ID = row1.ORDER_RECIPE_ID;			row2.BAY_CODE = row1.BAY_CODE;			row2.API_CODE = row1.API_CODE;			row2.INJECTOR_PRESET_CODE = row1.INJECTOR_PRESET_CODE;			row2.TARE_SCALE_INTERFACE_CODE = row1.TARE_SCALE_INTERFACE_CODE;			row2.TANK_CODE = row1.TANK_CODE;			row2.PRODUCT_GROUP_CODE = row1.PRODUCT_GROUP_CODE;			row2.INJECTOR_CODE = row1.INJECTOR_CODE;			row2.METER_CODE = row1.METER_CODE;			row2.SUPPLIER_NUMBER = row1.SUPPLIER_NUMBER;			row2.TERMINAL_PRODUCT_NUMBER = row1.TERMINAL_PRODUCT_NUMBER;			row2.TERMINAL_PRODUCT_TYPE = row1.TERMINAL_PRODUCT_TYPE;			row2.SHOST_SI_HOST_PRODUCT_NUMBER = row1.SHOST_SI_HOST_PRODUCT_NUMBER;			row2.BLEND_PERCENT = row1.BLEND_PERCENT;			row2.RATE = row1.RATE;			row2.THOST_TI_HOST_PRODUCT_NUMBER = row1.THOST_TI_HOST_PRODUCT_NUMBER;			row2.ORDERED_QUANTITY = row1.ORDERED_QUANTITY;			row2.OVERRIDE_TEMPERATURE_ENABLE = row1.OVERRIDE_TEMPERATURE_ENABLE;			row2.GROSS_QUANTITY = row1.GROSS_QUANTITY;			row2.WEIGHT = row1.WEIGHT;			row2.NET_QUANTITY = row1.NET_QUANTITY;			row2.DENSITY = row1.DENSITY;			row2.CUSTOMER_NET_QUANTITY = row1.CUSTOMER_NET_QUANTITY;			row2.SPECIFIC_GRAVITY = row1.SPECIFIC_GRAVITY;			row2.COEFFICIENT_EXPANSION = row1.COEFFICIENT_EXPANSION;			row2.TEMPERATURE = row1.TEMPERATURE;			row2.RVP = row1.RVP;			row2.OXYGEN = row1.OXYGEN;			row2.START_GROSS_TOTALIZER = row1.START_GROSS_TOTALIZER;			row2.END_GROSS_TOTALIZER = row1.END_GROSS_TOTALIZER;			row2.START_NET_TOTALIZER = row1.START_NET_TOTALIZER;			row2.END_NET_TOTALIZER = row1.END_NET_TOTALIZER;			row2.START_WEIGHT = row1.START_WEIGHT;			row2.END_WEIGHT = row1.END_WEIGHT;			row2.LAST_USER_NAME = row1.LAST_USER_NAME;			row2.LAST_MODIFIED = row1.LAST_MODIFIED;			row2.START_TIME = row1.START_TIME;			row2.END_TIME = row1.END_TIME;			row2.ADDITIVE_QUANTITY = row1.ADDITIVE_QUANTITY;			row2.PRODUCT_QUANTITY = row1.PRODUCT_QUANTITY;			row2.HOST_PRODUCT_CODE = row1.HOST_PRODUCT_CODE;			row2.HOST_PRODUCT_NAME = row1.HOST_PRODUCT_NAME;			row2.FROM_LEFT_ON_TRUCK = row1.FROM_LEFT_ON_TRUCK;			row2.OBSERVED_DENSITY = row1.OBSERVED_DENSITY;			row2.COMPONENT_ID = row1.COMPONENT_ID;			row2.CALCULATE_SECONDARY_UNITS = row1.CALCULATE_SECONDARY_UNITS;			row2.FINAL_SCALE_INTERFACE_CODE = row1.FINAL_SCALE_INTERFACE_CODE;			row2.FRAC_START_GROSS_TOTALIZER = row1.FRAC_START_GROSS_TOTALIZER;			row2.FRAC_END_GROSS_TOTALIZER = row1.FRAC_END_GROSS_TOTALIZER;			row2.PETROEX_COMPONENT_PRODUCT_CODE = row1.PETROEX_COMPONENT_PRODUCT_CODE;			row2.PRODUCT_TOLERANCE_STATUS = row1.PRODUCT_TOLERANCE_STATUS;			row2.TANK_INVENTORY_UPDATED = row1.TANK_INVENTORY_UPDATED;			row2.TOTALIZER_UPDATED = row1.TOTALIZER_UPDATED;			row2.FLUSH_STATUS = row1.FLUSH_STATUS;			row2.REDUCED_PRODUCT_NUMBER = row1.REDUCED_PRODUCT_NUMBER;			row2.ADDITIVE_WEIGHT = row1.ADDITIVE_WEIGHT;			row2.PRODUCT_WEIGHT = row1.PRODUCT_WEIGHT;			row2.RT_INJECTOR_ALARM_COUNT = row1.RT_INJECTOR_ALARM_COUNT;			row2.BATCH_NUMBER = row1.BATCH_NUMBER;			row2.VRU_CODE = row1.VRU_CODE;			row2.ADDITIVE_MASKING = row1.ADDITIVE_MASKING;			row2.COMPATIBILITY_STATUS = row1.COMPATIBILITY_STATUS;			row2.RECIPE_CORRECTION_TYPE = row1.RECIPE_CORRECTION_TYPE;			row2.NON_RECIPE_GROSS_QUANTITY = row1.NON_RECIPE_GROSS_QUANTITY;			row2.NON_RECIPE_NET_QUANTITY = row1.NON_RECIPE_NET_QUANTITY;			row2.NON_RECIPE_WEIGHT = row1.NON_RECIPE_WEIGHT;			row2.WEIGHT_IN_VAC = row1.WEIGHT_IN_VAC;			row2.ADDITIVE_WEIGHT_IN_VAC = row1.ADDITIVE_WEIGHT_IN_VAC;			row2.COMMITTED_GROSS_QUANTITY = row1.COMMITTED_GROSS_QUANTITY;			row2.PRODUCT_WEIGHT_IN_VAC = row1.PRODUCT_WEIGHT_IN_VAC;			row2.COMMITTED_NET_QUANTITY = row1.COMMITTED_NET_QUANTITY;			row2.PDXR_PRODUCT_CODE = row1.PDXR_PRODUCT_CODE;			row2.PDXR_AUTHORIZATION_UNITS = row1.PDXR_AUTHORIZATION_UNITS;			row2.COMMITTED_WEIGHT_IN_VAC = row1.COMMITTED_WEIGHT_IN_VAC;			row2.COMMITTED_WEIGHT_IN_AIR = row1.COMMITTED_WEIGHT_IN_AIR;			row2.PDXR_ADDITIVE_CODE = row1.PDXR_ADDITIVE_CODE;			row2.COMMITTED_CONV_TEMPERATURE = row1.COMMITTED_CONV_TEMPERATURE;			row2.COMMITTED_CONV_DENSITY = row1.COMMITTED_CONV_DENSITY;			row2.COMMITTED_CONV_COE = row1.COMMITTED_CONV_COE;			row2.COMMITTED_CONV_PRESSURE = row1.COMMITTED_CONV_PRESSURE;			row2.MEASURED_QUANTITY_TYPE = row1.MEASURED_QUANTITY_TYPE;			row2.INVENTORY_QUANTITY_TYPE = row1.INVENTORY_QUANTITY_TYPE;			row2.DERIVED_VALUES_DIRECTIVE = row1.DERIVED_VALUES_DIRECTIVE;			row2.PRESSURE = row1.PRESSURE;			row2.METER_PRESET_CODE = row1.METER_PRESET_CODE;			row2.CALCULATE_NET = row1.CALCULATE_NET;			row2.NON_RECIPE_WEIGHT_IN_VAC = row1.NON_RECIPE_WEIGHT_IN_VAC;			row2.ADJUSTMENT_BATCH = row1.ADJUSTMENT_BATCH;			row2.COMPARTMENT_OWNER_ID = row1.COMPARTMENT_OWNER_ID;			row2.COMPARTMENT_CONTAINER_CODE = row1.COMPARTMENT_CONTAINER_CODE;			row2.COMPARTMENT_CONTAINER_TYPE = row1.COMPARTMENT_CONTAINER_TYPE;			row2.COMPARTMENT_NUMBER = row1.COMPARTMENT_NUMBER;			row2.PDXR_LOADING_REF = row1.PDXR_LOADING_REF;			row2.BLEND_CORRECTION_METHOD = row1.BLEND_CORRECTION_METHOD;			row2.BLEND_CORRECTION_NET_VOLUME = row1.BLEND_CORRECTION_NET_VOLUME;			row2.TOTAL_BATCH_BLEND_NET_VOLUME = row1.TOTAL_BATCH_BLEND_NET_VOLUME;			row2.BLEND_CORRECTION_SOURCE = row1.BLEND_CORRECTION_SOURCE;			row2.COMMODITY_GROUP = row1.COMMODITY_GROUP;			row2.DERIVATION_STATUS = row1.DERIVATION_STATUS;			row2.DERIVED_VALUES_ERROR = row1.DERIVED_VALUES_ERROR;					
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
                        		    		
	                        		    	Object exprKeyValue_row3__ORDER_RECIPE_ID = row2.ORDER_RECIPE_ID ;
	                        		    	if(exprKeyValue_row3__ORDER_RECIPE_ID == null) {
	                        		    		hasCasePrimitiveKeyWithNull_tMap_1 = true;
	                        		    	} else {
                        		    			row3HashKey.ORDER_RECIPE_ID = (int)(Integer) exprKeyValue_row3__ORDER_RECIPE_ID;
                        		    		}
                        		    		

								
		                        	row3HashKey.hashCodeDirty = true;
                        		
	  					
	  							
	
		  							if(!hasCasePrimitiveKeyWithNull_tMap_1) { // G_TM_M_091
		  							
			  					
			  					
			  					
	  					
		  							tHash_Lookup_row3.lookup( row3HashKey );

	  							

	  							

			  						} // G_TM_M_091
			  						
			  					

 								
		  				
	  								
						
									
  									  		
 								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_row3 != null && tHash_Lookup_row3.getCount(row3HashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row3' and it contains more one result from keys :  row3.ORDER_ID = '" + row3HashKey.ORDER_ID + "', row3.ORDER_RECIPE_ID = '" + row3HashKey.ORDER_RECIPE_ID + "'");
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
Var.PK_ORDER_RECIPE = Numeric.sequence("s13",1,1) ;// ###############################
        // ###############################
        // # Output tables

out1 = null;

boolean rejected_tMap_1 = true;
// ###### START REJECTS ##### 

// # Output reject table : 'out1'
// # Filter conditions 
if( rejected_tMap_1 ) {
out1_tmp.PK_ORDER_RECIPE = Var.PK_ORDER_RECIPE ;
out1_tmp.ORDER_ID = row2.ORDER_ID ;
out1_tmp.COMPARTMENT_ID = row2.COMPARTMENT_ID ;
out1_tmp.ORDER_RECIPE_ID = row2.ORDER_RECIPE_ID ;
out1_tmp.BAY_CODE = row2.BAY_CODE ;
out1_tmp.API_CODE = row2.API_CODE ;
out1_tmp.TANK_CODE = row2.TANK_CODE ;
out1_tmp.PRODUCT_GROUP_CODE = row2.PRODUCT_GROUP_CODE ;
out1_tmp.METER_CODE = row2.METER_CODE ;
out1_tmp.SUPPLIER_NUMBER = row2.SUPPLIER_NUMBER ;
out1_tmp.TERMINAL_PRODUCT_NUMBER = row2.TERMINAL_PRODUCT_NUMBER ;
out1_tmp.START_TIME = row2.START_TIME ;
out1_tmp.END_TIME = row2.END_TIME ;
out1_tmp.COMPONENT_ID = row2.COMPONENT_ID ;
out1_tmp.PRODUCT_TOLERANCE_STATUS = row2.PRODUCT_TOLERANCE_STATUS ;
out1_tmp.TOTALIZER_UPDATED = row2.TOTALIZER_UPDATED ;
out1_tmp.BATCH_NUMBER = row2.BATCH_NUMBER ;
out1_tmp.RECIPE_CORRECTION_TYPE = row2.RECIPE_CORRECTION_TYPE ;
out1_tmp.INVENTORY_QUANTITY_TYPE = row2.INVENTORY_QUANTITY_TYPE ;
out1_tmp.DERIVED_VALUES_DIRECTIVE = row2.DERIVED_VALUES_DIRECTIVE ;
out1_tmp.METER_PRESET_CODE = row2.METER_PRESET_CODE ;
out1_tmp.CALCULATE_NET = row2.CALCULATE_NET ;
out1_tmp.COMPARTMENT_OWNER_ID = row2.COMPARTMENT_OWNER_ID ;
out1_tmp.COMPARTMENT_CONTAINER_CODE = row2.COMPARTMENT_CONTAINER_CODE ;
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


                    pstmt_tDBOutput_1.setInt(1, out1.PK_ORDER_RECIPE);

            int checkCount_tDBOutput_1 = -1;
            try (java.sql.ResultSet rs_tDBOutput_1 = pstmt_tDBOutput_1.executeQuery()) {
                while(rs_tDBOutput_1.next()) {
                    checkCount_tDBOutput_1 = rs_tDBOutput_1.getInt(1);
                }
            }
            if(checkCount_tDBOutput_1 > 0) {
                        pstmtUpdate_tDBOutput_1.setInt(1, out1.ORDER_ID);

                        pstmtUpdate_tDBOutput_1.setInt(2, out1.COMPARTMENT_ID);

                        pstmtUpdate_tDBOutput_1.setInt(3, out1.ORDER_RECIPE_ID);

                        if(out1.BAY_CODE == null) {
pstmtUpdate_tDBOutput_1.setNull(4, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(4, out1.BAY_CODE);
}

                        if(out1.API_CODE == null) {
pstmtUpdate_tDBOutput_1.setNull(5, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(5, out1.API_CODE);
}

                        if(out1.TANK_CODE == null) {
pstmtUpdate_tDBOutput_1.setNull(6, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(6, out1.TANK_CODE);
}

                        if(out1.PRODUCT_GROUP_CODE == null) {
pstmtUpdate_tDBOutput_1.setNull(7, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(7, out1.PRODUCT_GROUP_CODE);
}

                        if(out1.METER_CODE == null) {
pstmtUpdate_tDBOutput_1.setNull(8, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(8, out1.METER_CODE);
}

                        if(out1.SUPPLIER_NUMBER == null) {
pstmtUpdate_tDBOutput_1.setNull(9, java.sql.Types.INTEGER);
} else {pstmtUpdate_tDBOutput_1.setInt(9, out1.SUPPLIER_NUMBER);
}

                        pstmtUpdate_tDBOutput_1.setInt(10, out1.TERMINAL_PRODUCT_NUMBER);

                        if(out1.START_TIME != null) {
pstmtUpdate_tDBOutput_1.setTimestamp(11, new java.sql.Timestamp(out1.START_TIME.getTime()));
} else {
pstmtUpdate_tDBOutput_1.setNull(11, java.sql.Types.TIMESTAMP);
}

                        if(out1.END_TIME != null) {
pstmtUpdate_tDBOutput_1.setTimestamp(12, new java.sql.Timestamp(out1.END_TIME.getTime()));
} else {
pstmtUpdate_tDBOutput_1.setNull(12, java.sql.Types.TIMESTAMP);
}

                        pstmtUpdate_tDBOutput_1.setInt(13, out1.COMPONENT_ID);

                        pstmtUpdate_tDBOutput_1.setInt(14, out1.PRODUCT_TOLERANCE_STATUS);

                        pstmtUpdate_tDBOutput_1.setInt(15, out1.TOTALIZER_UPDATED);

                        pstmtUpdate_tDBOutput_1.setInt(16, out1.BATCH_NUMBER);

                        pstmtUpdate_tDBOutput_1.setInt(17, out1.RECIPE_CORRECTION_TYPE);

                        pstmtUpdate_tDBOutput_1.setInt(18, out1.INVENTORY_QUANTITY_TYPE);

                        pstmtUpdate_tDBOutput_1.setInt(19, out1.DERIVED_VALUES_DIRECTIVE);

                        if(out1.METER_PRESET_CODE == null) {
pstmtUpdate_tDBOutput_1.setNull(20, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(20, out1.METER_PRESET_CODE);
}

                        pstmtUpdate_tDBOutput_1.setInt(21, out1.CALCULATE_NET);

                        if(out1.COMPARTMENT_OWNER_ID == null) {
pstmtUpdate_tDBOutput_1.setNull(22, java.sql.Types.INTEGER);
} else {pstmtUpdate_tDBOutput_1.setInt(22, out1.COMPARTMENT_OWNER_ID);
}

                        if(out1.COMPARTMENT_CONTAINER_CODE == null) {
pstmtUpdate_tDBOutput_1.setNull(23, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(23, out1.COMPARTMENT_CONTAINER_CODE);
}


	                    

                        pstmtUpdate_tDBOutput_1.setInt(24 + count_tDBOutput_1, out1.PK_ORDER_RECIPE);

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
                        pstmtInsert_tDBOutput_1.setInt(1, out1.PK_ORDER_RECIPE);

                        pstmtInsert_tDBOutput_1.setInt(2, out1.ORDER_ID);

                        pstmtInsert_tDBOutput_1.setInt(3, out1.COMPARTMENT_ID);

                        pstmtInsert_tDBOutput_1.setInt(4, out1.ORDER_RECIPE_ID);

                        if(out1.BAY_CODE == null) {
pstmtInsert_tDBOutput_1.setNull(5, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(5, out1.BAY_CODE);
}

                        if(out1.API_CODE == null) {
pstmtInsert_tDBOutput_1.setNull(6, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(6, out1.API_CODE);
}

                        if(out1.TANK_CODE == null) {
pstmtInsert_tDBOutput_1.setNull(7, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(7, out1.TANK_CODE);
}

                        if(out1.PRODUCT_GROUP_CODE == null) {
pstmtInsert_tDBOutput_1.setNull(8, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(8, out1.PRODUCT_GROUP_CODE);
}

                        if(out1.METER_CODE == null) {
pstmtInsert_tDBOutput_1.setNull(9, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(9, out1.METER_CODE);
}

                        if(out1.SUPPLIER_NUMBER == null) {
pstmtInsert_tDBOutput_1.setNull(10, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_1.setInt(10, out1.SUPPLIER_NUMBER);
}

                        pstmtInsert_tDBOutput_1.setInt(11, out1.TERMINAL_PRODUCT_NUMBER);

                        if(out1.START_TIME != null) {
pstmtInsert_tDBOutput_1.setTimestamp(12, new java.sql.Timestamp(out1.START_TIME.getTime()));
} else {
pstmtInsert_tDBOutput_1.setNull(12, java.sql.Types.TIMESTAMP);
}

                        if(out1.END_TIME != null) {
pstmtInsert_tDBOutput_1.setTimestamp(13, new java.sql.Timestamp(out1.END_TIME.getTime()));
} else {
pstmtInsert_tDBOutput_1.setNull(13, java.sql.Types.TIMESTAMP);
}

                        pstmtInsert_tDBOutput_1.setInt(14, out1.COMPONENT_ID);

                        pstmtInsert_tDBOutput_1.setInt(15, out1.PRODUCT_TOLERANCE_STATUS);

                        pstmtInsert_tDBOutput_1.setInt(16, out1.TOTALIZER_UPDATED);

                        pstmtInsert_tDBOutput_1.setInt(17, out1.BATCH_NUMBER);

                        pstmtInsert_tDBOutput_1.setInt(18, out1.RECIPE_CORRECTION_TYPE);

                        pstmtInsert_tDBOutput_1.setInt(19, out1.INVENTORY_QUANTITY_TYPE);

                        pstmtInsert_tDBOutput_1.setInt(20, out1.DERIVED_VALUES_DIRECTIVE);

                        if(out1.METER_PRESET_CODE == null) {
pstmtInsert_tDBOutput_1.setNull(21, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(21, out1.METER_PRESET_CODE);
}

                        pstmtInsert_tDBOutput_1.setInt(22, out1.CALCULATE_NET);

                        if(out1.COMPARTMENT_OWNER_ID == null) {
pstmtInsert_tDBOutput_1.setNull(23, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_1.setInt(23, out1.COMPARTMENT_OWNER_ID);
}

                        if(out1.COMPARTMENT_CONTAINER_CODE == null) {
pstmtInsert_tDBOutput_1.setNull(24, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(24, out1.COMPARTMENT_CONTAINER_CODE);
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
    final static byte[] commonByteArrayLock_PGS_STAGE_DIM_ORDER_RECIPE = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_DIM_ORDER_RECIPE = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public int PK_ORDER_RECIPE;

				public int getPK_ORDER_RECIPE () {
					return this.PK_ORDER_RECIPE;
				}
				
			    public int ORDER_ID;

				public int getORDER_ID () {
					return this.ORDER_ID;
				}
				
			    public int COMPARTMENT_ID;

				public int getCOMPARTMENT_ID () {
					return this.COMPARTMENT_ID;
				}
				
			    public int ORDER_RECIPE_ID;

				public int getORDER_RECIPE_ID () {
					return this.ORDER_RECIPE_ID;
				}
				
			    public String BAY_CODE;

				public String getBAY_CODE () {
					return this.BAY_CODE;
				}
				
			    public String API_CODE;

				public String getAPI_CODE () {
					return this.API_CODE;
				}
				
			    public String TANK_CODE;

				public String getTANK_CODE () {
					return this.TANK_CODE;
				}
				
			    public String PRODUCT_GROUP_CODE;

				public String getPRODUCT_GROUP_CODE () {
					return this.PRODUCT_GROUP_CODE;
				}
				
			    public String METER_CODE;

				public String getMETER_CODE () {
					return this.METER_CODE;
				}
				
			    public Integer SUPPLIER_NUMBER;

				public Integer getSUPPLIER_NUMBER () {
					return this.SUPPLIER_NUMBER;
				}
				
			    public int TERMINAL_PRODUCT_NUMBER;

				public int getTERMINAL_PRODUCT_NUMBER () {
					return this.TERMINAL_PRODUCT_NUMBER;
				}
				
			    public java.util.Date START_TIME;

				public java.util.Date getSTART_TIME () {
					return this.START_TIME;
				}
				
			    public java.util.Date END_TIME;

				public java.util.Date getEND_TIME () {
					return this.END_TIME;
				}
				
			    public int COMPONENT_ID;

				public int getCOMPONENT_ID () {
					return this.COMPONENT_ID;
				}
				
			    public int PRODUCT_TOLERANCE_STATUS;

				public int getPRODUCT_TOLERANCE_STATUS () {
					return this.PRODUCT_TOLERANCE_STATUS;
				}
				
			    public int TOTALIZER_UPDATED;

				public int getTOTALIZER_UPDATED () {
					return this.TOTALIZER_UPDATED;
				}
				
			    public int BATCH_NUMBER;

				public int getBATCH_NUMBER () {
					return this.BATCH_NUMBER;
				}
				
			    public int RECIPE_CORRECTION_TYPE;

				public int getRECIPE_CORRECTION_TYPE () {
					return this.RECIPE_CORRECTION_TYPE;
				}
				
			    public int INVENTORY_QUANTITY_TYPE;

				public int getINVENTORY_QUANTITY_TYPE () {
					return this.INVENTORY_QUANTITY_TYPE;
				}
				
			    public int DERIVED_VALUES_DIRECTIVE;

				public int getDERIVED_VALUES_DIRECTIVE () {
					return this.DERIVED_VALUES_DIRECTIVE;
				}
				
			    public String METER_PRESET_CODE;

				public String getMETER_PRESET_CODE () {
					return this.METER_PRESET_CODE;
				}
				
			    public int CALCULATE_NET;

				public int getCALCULATE_NET () {
					return this.CALCULATE_NET;
				}
				
			    public Integer COMPARTMENT_OWNER_ID;

				public Integer getCOMPARTMENT_OWNER_ID () {
					return this.COMPARTMENT_OWNER_ID;
				}
				
			    public String COMPARTMENT_CONTAINER_CODE;

				public String getCOMPARTMENT_CONTAINER_CODE () {
					return this.COMPARTMENT_CONTAINER_CODE;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
							result = prime * result + (int) this.ORDER_ID;
						
							result = prime * result + (int) this.ORDER_RECIPE_ID;
						
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
					
						if (this.ORDER_RECIPE_ID != other.ORDER_RECIPE_ID)
							return false;
					

		return true;
    }

	public void copyDataTo(row3Struct other) {

		other.PK_ORDER_RECIPE = this.PK_ORDER_RECIPE;
	            other.ORDER_ID = this.ORDER_ID;
	            other.COMPARTMENT_ID = this.COMPARTMENT_ID;
	            other.ORDER_RECIPE_ID = this.ORDER_RECIPE_ID;
	            other.BAY_CODE = this.BAY_CODE;
	            other.API_CODE = this.API_CODE;
	            other.TANK_CODE = this.TANK_CODE;
	            other.PRODUCT_GROUP_CODE = this.PRODUCT_GROUP_CODE;
	            other.METER_CODE = this.METER_CODE;
	            other.SUPPLIER_NUMBER = this.SUPPLIER_NUMBER;
	            other.TERMINAL_PRODUCT_NUMBER = this.TERMINAL_PRODUCT_NUMBER;
	            other.START_TIME = this.START_TIME;
	            other.END_TIME = this.END_TIME;
	            other.COMPONENT_ID = this.COMPONENT_ID;
	            other.PRODUCT_TOLERANCE_STATUS = this.PRODUCT_TOLERANCE_STATUS;
	            other.TOTALIZER_UPDATED = this.TOTALIZER_UPDATED;
	            other.BATCH_NUMBER = this.BATCH_NUMBER;
	            other.RECIPE_CORRECTION_TYPE = this.RECIPE_CORRECTION_TYPE;
	            other.INVENTORY_QUANTITY_TYPE = this.INVENTORY_QUANTITY_TYPE;
	            other.DERIVED_VALUES_DIRECTIVE = this.DERIVED_VALUES_DIRECTIVE;
	            other.METER_PRESET_CODE = this.METER_PRESET_CODE;
	            other.CALCULATE_NET = this.CALCULATE_NET;
	            other.COMPARTMENT_OWNER_ID = this.COMPARTMENT_OWNER_ID;
	            other.COMPARTMENT_CONTAINER_CODE = this.COMPARTMENT_CONTAINER_CODE;
	            
	}

	public void copyKeysDataTo(row3Struct other) {

		other.ORDER_ID = this.ORDER_ID;
	            	other.ORDER_RECIPE_ID = this.ORDER_RECIPE_ID;
	            	
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

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_ORDER_RECIPE) {

        	try {

        		int length = 0;
		
			        this.ORDER_ID = dis.readInt();
					
			        this.ORDER_RECIPE_ID = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_ORDER_RECIPE) {

        	try {

        		int length = 0;
		
			        this.ORDER_ID = dis.readInt();
					
			        this.ORDER_RECIPE_ID = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.ORDER_ID);
					
					// int
				
		            	dos.writeInt(this.ORDER_RECIPE_ID);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.ORDER_ID);
					
					// int
				
		            	dos.writeInt(this.ORDER_RECIPE_ID);
					
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
		
			            this.PK_ORDER_RECIPE = dis.readInt();
					
			            this.COMPARTMENT_ID = dis.readInt();
					
						this.BAY_CODE = readString(dis,ois);
					
						this.API_CODE = readString(dis,ois);
					
						this.TANK_CODE = readString(dis,ois);
					
						this.PRODUCT_GROUP_CODE = readString(dis,ois);
					
						this.METER_CODE = readString(dis,ois);
					
						this.SUPPLIER_NUMBER = readInteger(dis,ois);
					
			            this.TERMINAL_PRODUCT_NUMBER = dis.readInt();
					
						this.START_TIME = readDate(dis,ois);
					
						this.END_TIME = readDate(dis,ois);
					
			            this.COMPONENT_ID = dis.readInt();
					
			            this.PRODUCT_TOLERANCE_STATUS = dis.readInt();
					
			            this.TOTALIZER_UPDATED = dis.readInt();
					
			            this.BATCH_NUMBER = dis.readInt();
					
			            this.RECIPE_CORRECTION_TYPE = dis.readInt();
					
			            this.INVENTORY_QUANTITY_TYPE = dis.readInt();
					
			            this.DERIVED_VALUES_DIRECTIVE = dis.readInt();
					
						this.METER_PRESET_CODE = readString(dis,ois);
					
			            this.CALCULATE_NET = dis.readInt();
					
						this.COMPARTMENT_OWNER_ID = readInteger(dis,ois);
					
						this.COMPARTMENT_CONTAINER_CODE = readString(dis,ois);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
			            this.PK_ORDER_RECIPE = objectIn.readInt();
					
			            this.COMPARTMENT_ID = objectIn.readInt();
					
						this.BAY_CODE = readString(dis,objectIn);
					
						this.API_CODE = readString(dis,objectIn);
					
						this.TANK_CODE = readString(dis,objectIn);
					
						this.PRODUCT_GROUP_CODE = readString(dis,objectIn);
					
						this.METER_CODE = readString(dis,objectIn);
					
						this.SUPPLIER_NUMBER = readInteger(dis,objectIn);
					
			            this.TERMINAL_PRODUCT_NUMBER = objectIn.readInt();
					
						this.START_TIME = readDate(dis,objectIn);
					
						this.END_TIME = readDate(dis,objectIn);
					
			            this.COMPONENT_ID = objectIn.readInt();
					
			            this.PRODUCT_TOLERANCE_STATUS = objectIn.readInt();
					
			            this.TOTALIZER_UPDATED = objectIn.readInt();
					
			            this.BATCH_NUMBER = objectIn.readInt();
					
			            this.RECIPE_CORRECTION_TYPE = objectIn.readInt();
					
			            this.INVENTORY_QUANTITY_TYPE = objectIn.readInt();
					
			            this.DERIVED_VALUES_DIRECTIVE = objectIn.readInt();
					
						this.METER_PRESET_CODE = readString(dis,objectIn);
					
			            this.CALCULATE_NET = objectIn.readInt();
					
						this.COMPARTMENT_OWNER_ID = readInteger(dis,objectIn);
					
						this.COMPARTMENT_CONTAINER_CODE = readString(dis,objectIn);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
		            	dos.writeInt(this.PK_ORDER_RECIPE);
					
		            	dos.writeInt(this.COMPARTMENT_ID);
					
						writeString(this.BAY_CODE, dos, oos);
					
						writeString(this.API_CODE, dos, oos);
					
						writeString(this.TANK_CODE, dos, oos);
					
						writeString(this.PRODUCT_GROUP_CODE, dos, oos);
					
						writeString(this.METER_CODE, dos, oos);
					
					writeInteger(this.SUPPLIER_NUMBER, dos, oos);
					
		            	dos.writeInt(this.TERMINAL_PRODUCT_NUMBER);
					
						writeDate(this.START_TIME, dos, oos);
					
						writeDate(this.END_TIME, dos, oos);
					
		            	dos.writeInt(this.COMPONENT_ID);
					
		            	dos.writeInt(this.PRODUCT_TOLERANCE_STATUS);
					
		            	dos.writeInt(this.TOTALIZER_UPDATED);
					
		            	dos.writeInt(this.BATCH_NUMBER);
					
		            	dos.writeInt(this.RECIPE_CORRECTION_TYPE);
					
		            	dos.writeInt(this.INVENTORY_QUANTITY_TYPE);
					
		            	dos.writeInt(this.DERIVED_VALUES_DIRECTIVE);
					
						writeString(this.METER_PRESET_CODE, dos, oos);
					
		            	dos.writeInt(this.CALCULATE_NET);
					
					writeInteger(this.COMPARTMENT_OWNER_ID, dos, oos);
					
						writeString(this.COMPARTMENT_CONTAINER_CODE, dos, oos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
					objectOut.writeInt(this.PK_ORDER_RECIPE);
					
					objectOut.writeInt(this.COMPARTMENT_ID);
					
						writeString(this.BAY_CODE, dos, objectOut);
					
						writeString(this.API_CODE, dos, objectOut);
					
						writeString(this.TANK_CODE, dos, objectOut);
					
						writeString(this.PRODUCT_GROUP_CODE, dos, objectOut);
					
						writeString(this.METER_CODE, dos, objectOut);
					
					writeInteger(this.SUPPLIER_NUMBER, dos, objectOut);
					
					objectOut.writeInt(this.TERMINAL_PRODUCT_NUMBER);
					
						writeDate(this.START_TIME, dos, objectOut);
					
						writeDate(this.END_TIME, dos, objectOut);
					
					objectOut.writeInt(this.COMPONENT_ID);
					
					objectOut.writeInt(this.PRODUCT_TOLERANCE_STATUS);
					
					objectOut.writeInt(this.TOTALIZER_UPDATED);
					
					objectOut.writeInt(this.BATCH_NUMBER);
					
					objectOut.writeInt(this.RECIPE_CORRECTION_TYPE);
					
					objectOut.writeInt(this.INVENTORY_QUANTITY_TYPE);
					
					objectOut.writeInt(this.DERIVED_VALUES_DIRECTIVE);
					
						writeString(this.METER_PRESET_CODE, dos, objectOut);
					
					objectOut.writeInt(this.CALCULATE_NET);
					
					writeInteger(this.COMPARTMENT_OWNER_ID, dos, objectOut);
					
						writeString(this.COMPARTMENT_CONTAINER_CODE, dos, objectOut);
					
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
		sb.append("PK_ORDER_RECIPE="+String.valueOf(PK_ORDER_RECIPE));
		sb.append(",ORDER_ID="+String.valueOf(ORDER_ID));
		sb.append(",COMPARTMENT_ID="+String.valueOf(COMPARTMENT_ID));
		sb.append(",ORDER_RECIPE_ID="+String.valueOf(ORDER_RECIPE_ID));
		sb.append(",BAY_CODE="+BAY_CODE);
		sb.append(",API_CODE="+API_CODE);
		sb.append(",TANK_CODE="+TANK_CODE);
		sb.append(",PRODUCT_GROUP_CODE="+PRODUCT_GROUP_CODE);
		sb.append(",METER_CODE="+METER_CODE);
		sb.append(",SUPPLIER_NUMBER="+String.valueOf(SUPPLIER_NUMBER));
		sb.append(",TERMINAL_PRODUCT_NUMBER="+String.valueOf(TERMINAL_PRODUCT_NUMBER));
		sb.append(",START_TIME="+String.valueOf(START_TIME));
		sb.append(",END_TIME="+String.valueOf(END_TIME));
		sb.append(",COMPONENT_ID="+String.valueOf(COMPONENT_ID));
		sb.append(",PRODUCT_TOLERANCE_STATUS="+String.valueOf(PRODUCT_TOLERANCE_STATUS));
		sb.append(",TOTALIZER_UPDATED="+String.valueOf(TOTALIZER_UPDATED));
		sb.append(",BATCH_NUMBER="+String.valueOf(BATCH_NUMBER));
		sb.append(",RECIPE_CORRECTION_TYPE="+String.valueOf(RECIPE_CORRECTION_TYPE));
		sb.append(",INVENTORY_QUANTITY_TYPE="+String.valueOf(INVENTORY_QUANTITY_TYPE));
		sb.append(",DERIVED_VALUES_DIRECTIVE="+String.valueOf(DERIVED_VALUES_DIRECTIVE));
		sb.append(",METER_PRESET_CODE="+METER_PRESET_CODE);
		sb.append(",CALCULATE_NET="+String.valueOf(CALCULATE_NET));
		sb.append(",COMPARTMENT_OWNER_ID="+String.valueOf(COMPARTMENT_OWNER_ID));
		sb.append(",COMPARTMENT_CONTAINER_CODE="+COMPARTMENT_CONTAINER_CODE);
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

					
						returnValue = checkNullsAndCompare(this.ORDER_RECIPE_ID, other.ORDER_RECIPE_ID);
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
				
				 
	final String decryptedPassword_tDBInput_2 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:MfTVWHmQGXOxAD3sfgxiTGnch5wGlKAMMwBpfKNFsdbNFMtyTl8=");
				
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

		    String dbquery_tDBInput_2 = "SELECT dbo.DIM_ORDER_RECIPE.PK_ORDER_RECIPE,\n		dbo.DIM_ORDER_RECIPE.ORDER_ID,\n		dbo.DIM_ORDER_RECIPE.COMPARTMENT_ID,\n		"
+"dbo.DIM_ORDER_RECIPE.ORDER_RECIPE_ID,\n		dbo.DIM_ORDER_RECIPE.BAY_CODE,\n		dbo.DIM_ORDER_RECIPE.API_CODE,\n		dbo.DIM_ORDER_"
+"RECIPE.TANK_CODE,\n		dbo.DIM_ORDER_RECIPE.PRODUCT_GROUP_CODE,\n		dbo.DIM_ORDER_RECIPE.METER_CODE,\n		dbo.DIM_ORDER_RECIPE.S"
+"UPPLIER_NUMBER,\n		dbo.DIM_ORDER_RECIPE.TERMINAL_PRODUCT_NUMBER,\n		dbo.DIM_ORDER_RECIPE.START_TIME,\n		dbo.DIM_ORDER_RECIP"
+"E.END_TIME,\n		dbo.DIM_ORDER_RECIPE.COMPONENT_ID,\n		dbo.DIM_ORDER_RECIPE.PRODUCT_TOLERANCE_STATUS,\n		dbo.DIM_ORDER_RECIPE"
+".TOTALIZER_UPDATED,\n		dbo.DIM_ORDER_RECIPE.BATCH_NUMBER,\n		dbo.DIM_ORDER_RECIPE.RECIPE_CORRECTION_TYPE,\n		dbo.DIM_ORDER_"
+"RECIPE.INVENTORY_QUANTITY_TYPE,\n		dbo.DIM_ORDER_RECIPE.DERIVED_VALUES_DIRECTIVE,\n		dbo.DIM_ORDER_RECIPE.METER_PRESET_COD"
+"E,\n		dbo.DIM_ORDER_RECIPE.CALCULATE_NET,\n		dbo.DIM_ORDER_RECIPE.COMPARTMENT_OWNER_ID,\n		dbo.DIM_ORDER_RECIPE.COMPARTMENT"
+"_CONTAINER_CODE\nFROM	dbo.DIM_ORDER_RECIPE";
		    

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
								row3.PK_ORDER_RECIPE = 0;
							} else {
		                          
            row3.PK_ORDER_RECIPE = rs_tDBInput_2.getInt(1);
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
								row3.COMPARTMENT_ID = 0;
							} else {
		                          
            row3.COMPARTMENT_ID = rs_tDBInput_2.getInt(3);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 4) {
								row3.ORDER_RECIPE_ID = 0;
							} else {
		                          
            row3.ORDER_RECIPE_ID = rs_tDBInput_2.getInt(4);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 5) {
								row3.BAY_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(5);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(5).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.BAY_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row3.BAY_CODE = tmpContent_tDBInput_2;
                }
            } else {
                row3.BAY_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 6) {
								row3.API_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(6);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(6).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.API_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row3.API_CODE = tmpContent_tDBInput_2;
                }
            } else {
                row3.API_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 7) {
								row3.TANK_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(7);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(7).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.TANK_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row3.TANK_CODE = tmpContent_tDBInput_2;
                }
            } else {
                row3.TANK_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 8) {
								row3.PRODUCT_GROUP_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(8);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(8).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.PRODUCT_GROUP_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row3.PRODUCT_GROUP_CODE = tmpContent_tDBInput_2;
                }
            } else {
                row3.PRODUCT_GROUP_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 9) {
								row3.METER_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(9);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(9).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.METER_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row3.METER_CODE = tmpContent_tDBInput_2;
                }
            } else {
                row3.METER_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 10) {
								row3.SUPPLIER_NUMBER = null;
							} else {
		                          
            row3.SUPPLIER_NUMBER = rs_tDBInput_2.getInt(10);
            if(rs_tDBInput_2.wasNull()){
                    row3.SUPPLIER_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 11) {
								row3.TERMINAL_PRODUCT_NUMBER = 0;
							} else {
		                          
            row3.TERMINAL_PRODUCT_NUMBER = rs_tDBInput_2.getInt(11);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 12) {
								row3.START_TIME = null;
							} else {
										
			row3.START_TIME = mssqlGTU_tDBInput_2.getDate(rsmd_tDBInput_2, rs_tDBInput_2, 12);
			
		                    }
							if(colQtyInRs_tDBInput_2 < 13) {
								row3.END_TIME = null;
							} else {
										
			row3.END_TIME = mssqlGTU_tDBInput_2.getDate(rsmd_tDBInput_2, rs_tDBInput_2, 13);
			
		                    }
							if(colQtyInRs_tDBInput_2 < 14) {
								row3.COMPONENT_ID = 0;
							} else {
		                          
            row3.COMPONENT_ID = rs_tDBInput_2.getInt(14);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 15) {
								row3.PRODUCT_TOLERANCE_STATUS = 0;
							} else {
		                          
            row3.PRODUCT_TOLERANCE_STATUS = rs_tDBInput_2.getInt(15);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 16) {
								row3.TOTALIZER_UPDATED = 0;
							} else {
		                          
            row3.TOTALIZER_UPDATED = rs_tDBInput_2.getInt(16);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 17) {
								row3.BATCH_NUMBER = 0;
							} else {
		                          
            row3.BATCH_NUMBER = rs_tDBInput_2.getInt(17);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 18) {
								row3.RECIPE_CORRECTION_TYPE = 0;
							} else {
		                          
            row3.RECIPE_CORRECTION_TYPE = rs_tDBInput_2.getInt(18);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 19) {
								row3.INVENTORY_QUANTITY_TYPE = 0;
							} else {
		                          
            row3.INVENTORY_QUANTITY_TYPE = rs_tDBInput_2.getInt(19);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 20) {
								row3.DERIVED_VALUES_DIRECTIVE = 0;
							} else {
		                          
            row3.DERIVED_VALUES_DIRECTIVE = rs_tDBInput_2.getInt(20);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 21) {
								row3.METER_PRESET_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(21);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(21).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.METER_PRESET_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row3.METER_PRESET_CODE = tmpContent_tDBInput_2;
                }
            } else {
                row3.METER_PRESET_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 22) {
								row3.CALCULATE_NET = 0;
							} else {
		                          
            row3.CALCULATE_NET = rs_tDBInput_2.getInt(22);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 23) {
								row3.COMPARTMENT_OWNER_ID = null;
							} else {
		                          
            row3.COMPARTMENT_OWNER_ID = rs_tDBInput_2.getInt(23);
            if(rs_tDBInput_2.wasNull()){
                    row3.COMPARTMENT_OWNER_ID = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 24) {
								row3.COMPARTMENT_CONTAINER_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(24);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(24).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.COMPARTMENT_CONTAINER_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row3.COMPARTMENT_CONTAINER_CODE = tmpContent_tDBInput_2;
                }
            } else {
                row3.COMPARTMENT_CONTAINER_CODE = null;
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
		   	   	   
				
				row3_HashRow.PK_ORDER_RECIPE = row3.PK_ORDER_RECIPE;
				
				row3_HashRow.ORDER_ID = row3.ORDER_ID;
				
				row3_HashRow.COMPARTMENT_ID = row3.COMPARTMENT_ID;
				
				row3_HashRow.ORDER_RECIPE_ID = row3.ORDER_RECIPE_ID;
				
				row3_HashRow.BAY_CODE = row3.BAY_CODE;
				
				row3_HashRow.API_CODE = row3.API_CODE;
				
				row3_HashRow.TANK_CODE = row3.TANK_CODE;
				
				row3_HashRow.PRODUCT_GROUP_CODE = row3.PRODUCT_GROUP_CODE;
				
				row3_HashRow.METER_CODE = row3.METER_CODE;
				
				row3_HashRow.SUPPLIER_NUMBER = row3.SUPPLIER_NUMBER;
				
				row3_HashRow.TERMINAL_PRODUCT_NUMBER = row3.TERMINAL_PRODUCT_NUMBER;
				
				row3_HashRow.START_TIME = row3.START_TIME;
				
				row3_HashRow.END_TIME = row3.END_TIME;
				
				row3_HashRow.COMPONENT_ID = row3.COMPONENT_ID;
				
				row3_HashRow.PRODUCT_TOLERANCE_STATUS = row3.PRODUCT_TOLERANCE_STATUS;
				
				row3_HashRow.TOTALIZER_UPDATED = row3.TOTALIZER_UPDATED;
				
				row3_HashRow.BATCH_NUMBER = row3.BATCH_NUMBER;
				
				row3_HashRow.RECIPE_CORRECTION_TYPE = row3.RECIPE_CORRECTION_TYPE;
				
				row3_HashRow.INVENTORY_QUANTITY_TYPE = row3.INVENTORY_QUANTITY_TYPE;
				
				row3_HashRow.DERIVED_VALUES_DIRECTIVE = row3.DERIVED_VALUES_DIRECTIVE;
				
				row3_HashRow.METER_PRESET_CODE = row3.METER_PRESET_CODE;
				
				row3_HashRow.CALCULATE_NET = row3.CALCULATE_NET;
				
				row3_HashRow.COMPARTMENT_OWNER_ID = row3.COMPARTMENT_OWNER_ID;
				
				row3_HashRow.COMPARTMENT_CONTAINER_CODE = row3.COMPARTMENT_CONTAINER_CODE;
				
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
        final DIM_ORDER_RECIPE DIM_ORDER_RECIPEClass = new DIM_ORDER_RECIPE();

        int exitCode = DIM_ORDER_RECIPEClass.runJobInTOS(args);

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
            java.io.InputStream inContext = DIM_ORDER_RECIPE.class.getClassLoader().getResourceAsStream("pgs_stage/dim_order_recipe_0_1/contexts/" + contextStr + ".properties");
            if (inContext == null) {
                inContext = DIM_ORDER_RECIPE.class.getClassLoader().getResourceAsStream("config/contexts/" + contextStr + ".properties");
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
            System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : DIM_ORDER_RECIPE");
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
 *     350837 characters generated by Talend Open Studio for Data Integration 
 *     on the 3 août 2024 à 14:42:26 GMT+01:00
 ************************************************************************************************/