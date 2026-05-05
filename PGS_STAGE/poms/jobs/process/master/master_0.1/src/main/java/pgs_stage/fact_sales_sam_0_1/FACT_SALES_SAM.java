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


package pgs_stage.fact_sales_sam_0_1;

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
 * Job: FACT_SALES_SAM Purpose: <br>
 * Description:  <br>
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status 
 */
public class FACT_SALES_SAM implements TalendJob {

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
	private final String jobName = "FACT_SALES_SAM";
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
				FACT_SALES_SAM.this.exception = e;
			}
		}
		if (!(e instanceof TalendException)) {
		try {
			for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
				if (m.getName().compareTo(currentComponent + "_error") == 0) {
					m.invoke(FACT_SALES_SAM.this, new Object[] { e , currentComponent, globalMap});
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
			
			public void tDBInput_8_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_4_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_9_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_6_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_7_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_5_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_10_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_11_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_row2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_row3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_row4_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_row5_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_row6_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_row10_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_row11_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_row7_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_row8_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_row9_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
	






public static class out1Struct implements routines.system.IPersistableRow<out1Struct> {
    final static byte[] commonByteArrayLock_PGS_STAGE_FACT_SALES_SAM = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_FACT_SALES_SAM = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public int FK_ORDERS;

				public int getFK_ORDERS () {
					return this.FK_ORDERS;
				}
				
			    public int FK_ORDER_RECIPE;

				public int getFK_ORDER_RECIPE () {
					return this.FK_ORDER_RECIPE;
				}
				
			    public int FK_API;

				public int getFK_API () {
					return this.FK_API;
				}
				
			    public int FK_CUSTOMER;

				public int getFK_CUSTOMER () {
					return this.FK_CUSTOMER;
				}
				
			    public int FK_TRAILER;

				public int getFK_TRAILER () {
					return this.FK_TRAILER;
				}
				
			    public int FK_ORDER_TRAILER;

				public int getFK_ORDER_TRAILER () {
					return this.FK_ORDER_TRAILER;
				}
				
			    public int FK_DRIVER;

				public int getFK_DRIVER () {
					return this.FK_DRIVER;
				}
				
			    public int FK_PRODUCT_SUPPLIER;

				public int getFK_PRODUCT_SUPPLIER () {
					return this.FK_PRODUCT_SUPPLIER;
				}
				
			    public double BLEND_PERCENT;

				public double getBLEND_PERCENT () {
					return this.BLEND_PERCENT;
				}
				
			    public int ORDERED_QUANTITY;

				public int getORDERED_QUANTITY () {
					return this.ORDERED_QUANTITY;
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
				
			    public double TEMPERATURE;

				public double getTEMPERATURE () {
					return this.TEMPERATURE;
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
				
			    public double OBSERVED_DENSITY;

				public double getOBSERVED_DENSITY () {
					return this.OBSERVED_DENSITY;
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
				
			    public int COMMITTED_GROSS_QUANTITY;

				public int getCOMMITTED_GROSS_QUANTITY () {
					return this.COMMITTED_GROSS_QUANTITY;
				}
				
			    public int COMMITTED_NET_QUANTITY;

				public int getCOMMITTED_NET_QUANTITY () {
					return this.COMMITTED_NET_QUANTITY;
				}
				
			    public int COMMITTED_WEIGHT_IN_VAC;

				public int getCOMMITTED_WEIGHT_IN_VAC () {
					return this.COMMITTED_WEIGHT_IN_VAC;
				}
				
			    public int COMMITTED_WEIGHT_IN_AIR;

				public int getCOMMITTED_WEIGHT_IN_AIR () {
					return this.COMMITTED_WEIGHT_IN_AIR;
				}
				
			    public double COMMITTED_CONV_TEMPERATURE;

				public double getCOMMITTED_CONV_TEMPERATURE () {
					return this.COMMITTED_CONV_TEMPERATURE;
				}
				
			    public double COMMITTED_CONV_DENSITY;

				public double getCOMMITTED_CONV_DENSITY () {
					return this.COMMITTED_CONV_DENSITY;
				}
				
			    public int NON_RECIPE_WEIGHT_IN_VAC;

				public int getNON_RECIPE_WEIGHT_IN_VAC () {
					return this.NON_RECIPE_WEIGHT_IN_VAC;
				}
				
			    public double MINIMUM_TEMPERATURE;

				public double getMINIMUM_TEMPERATURE () {
					return this.MINIMUM_TEMPERATURE;
				}
				
			    public double MAXIMUM_TEMPERATURE;

				public double getMAXIMUM_TEMPERATURE () {
					return this.MAXIMUM_TEMPERATURE;
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
				
			    public int USABLE_CAPACITY;

				public int getUSABLE_CAPACITY () {
					return this.USABLE_CAPACITY;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
							result = prime * result + (int) this.FK_ORDERS;
						
							result = prime * result + (int) this.FK_ORDER_RECIPE;
						
							result = prime * result + (int) this.FK_API;
						
							result = prime * result + (int) this.FK_CUSTOMER;
						
							result = prime * result + (int) this.FK_TRAILER;
						
							result = prime * result + (int) this.FK_ORDER_TRAILER;
						
							result = prime * result + (int) this.FK_DRIVER;
						
							result = prime * result + (int) this.FK_PRODUCT_SUPPLIER;
						
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
		
						if (this.FK_ORDERS != other.FK_ORDERS)
							return false;
					
						if (this.FK_ORDER_RECIPE != other.FK_ORDER_RECIPE)
							return false;
					
						if (this.FK_API != other.FK_API)
							return false;
					
						if (this.FK_CUSTOMER != other.FK_CUSTOMER)
							return false;
					
						if (this.FK_TRAILER != other.FK_TRAILER)
							return false;
					
						if (this.FK_ORDER_TRAILER != other.FK_ORDER_TRAILER)
							return false;
					
						if (this.FK_DRIVER != other.FK_DRIVER)
							return false;
					
						if (this.FK_PRODUCT_SUPPLIER != other.FK_PRODUCT_SUPPLIER)
							return false;
					

		return true;
    }

	public void copyDataTo(out1Struct other) {

		other.FK_ORDERS = this.FK_ORDERS;
	            other.FK_ORDER_RECIPE = this.FK_ORDER_RECIPE;
	            other.FK_API = this.FK_API;
	            other.FK_CUSTOMER = this.FK_CUSTOMER;
	            other.FK_TRAILER = this.FK_TRAILER;
	            other.FK_ORDER_TRAILER = this.FK_ORDER_TRAILER;
	            other.FK_DRIVER = this.FK_DRIVER;
	            other.FK_PRODUCT_SUPPLIER = this.FK_PRODUCT_SUPPLIER;
	            other.BLEND_PERCENT = this.BLEND_PERCENT;
	            other.ORDERED_QUANTITY = this.ORDERED_QUANTITY;
	            other.GROSS_QUANTITY = this.GROSS_QUANTITY;
	            other.WEIGHT = this.WEIGHT;
	            other.NET_QUANTITY = this.NET_QUANTITY;
	            other.DENSITY = this.DENSITY;
	            other.CUSTOMER_NET_QUANTITY = this.CUSTOMER_NET_QUANTITY;
	            other.TEMPERATURE = this.TEMPERATURE;
	            other.START_GROSS_TOTALIZER = this.START_GROSS_TOTALIZER;
	            other.END_GROSS_TOTALIZER = this.END_GROSS_TOTALIZER;
	            other.START_NET_TOTALIZER = this.START_NET_TOTALIZER;
	            other.END_NET_TOTALIZER = this.END_NET_TOTALIZER;
	            other.OBSERVED_DENSITY = this.OBSERVED_DENSITY;
	            other.NON_RECIPE_GROSS_QUANTITY = this.NON_RECIPE_GROSS_QUANTITY;
	            other.NON_RECIPE_NET_QUANTITY = this.NON_RECIPE_NET_QUANTITY;
	            other.NON_RECIPE_WEIGHT = this.NON_RECIPE_WEIGHT;
	            other.WEIGHT_IN_VAC = this.WEIGHT_IN_VAC;
	            other.COMMITTED_GROSS_QUANTITY = this.COMMITTED_GROSS_QUANTITY;
	            other.COMMITTED_NET_QUANTITY = this.COMMITTED_NET_QUANTITY;
	            other.COMMITTED_WEIGHT_IN_VAC = this.COMMITTED_WEIGHT_IN_VAC;
	            other.COMMITTED_WEIGHT_IN_AIR = this.COMMITTED_WEIGHT_IN_AIR;
	            other.COMMITTED_CONV_TEMPERATURE = this.COMMITTED_CONV_TEMPERATURE;
	            other.COMMITTED_CONV_DENSITY = this.COMMITTED_CONV_DENSITY;
	            other.NON_RECIPE_WEIGHT_IN_VAC = this.NON_RECIPE_WEIGHT_IN_VAC;
	            other.MINIMUM_TEMPERATURE = this.MINIMUM_TEMPERATURE;
	            other.MAXIMUM_TEMPERATURE = this.MAXIMUM_TEMPERATURE;
	            other.MINIMUM_BASE_DENSITY = this.MINIMUM_BASE_DENSITY;
	            other.MAXIMUM_BASE_DENSITY = this.MAXIMUM_BASE_DENSITY;
	            other.MINIMUM_OBSERVED_DENSITY = this.MINIMUM_OBSERVED_DENSITY;
	            other.MAXIMUM_OBSERVED_DENSITY = this.MAXIMUM_OBSERVED_DENSITY;
	            other.MINIMUM_COE = this.MINIMUM_COE;
	            other.MAXIMUM_COE = this.MAXIMUM_COE;
	            other.USABLE_CAPACITY = this.USABLE_CAPACITY;
	            
	}

	public void copyKeysDataTo(out1Struct other) {

		other.FK_ORDERS = this.FK_ORDERS;
	            	other.FK_ORDER_RECIPE = this.FK_ORDER_RECIPE;
	            	other.FK_API = this.FK_API;
	            	other.FK_CUSTOMER = this.FK_CUSTOMER;
	            	other.FK_TRAILER = this.FK_TRAILER;
	            	other.FK_ORDER_TRAILER = this.FK_ORDER_TRAILER;
	            	other.FK_DRIVER = this.FK_DRIVER;
	            	other.FK_PRODUCT_SUPPLIER = this.FK_PRODUCT_SUPPLIER;
	            	
	}




    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_FACT_SALES_SAM) {

        	try {

        		int length = 0;
		
			        this.FK_ORDERS = dis.readInt();
					
			        this.FK_ORDER_RECIPE = dis.readInt();
					
			        this.FK_API = dis.readInt();
					
			        this.FK_CUSTOMER = dis.readInt();
					
			        this.FK_TRAILER = dis.readInt();
					
			        this.FK_ORDER_TRAILER = dis.readInt();
					
			        this.FK_DRIVER = dis.readInt();
					
			        this.FK_PRODUCT_SUPPLIER = dis.readInt();
					
			        this.BLEND_PERCENT = dis.readDouble();
					
			        this.ORDERED_QUANTITY = dis.readInt();
					
			        this.GROSS_QUANTITY = dis.readInt();
					
			        this.WEIGHT = dis.readInt();
					
			        this.NET_QUANTITY = dis.readInt();
					
			        this.DENSITY = dis.readDouble();
					
			        this.CUSTOMER_NET_QUANTITY = dis.readInt();
					
			        this.TEMPERATURE = dis.readDouble();
					
			        this.START_GROSS_TOTALIZER = dis.readInt();
					
			        this.END_GROSS_TOTALIZER = dis.readInt();
					
			        this.START_NET_TOTALIZER = dis.readInt();
					
			        this.END_NET_TOTALIZER = dis.readInt();
					
			        this.OBSERVED_DENSITY = dis.readDouble();
					
			        this.NON_RECIPE_GROSS_QUANTITY = dis.readInt();
					
			        this.NON_RECIPE_NET_QUANTITY = dis.readInt();
					
			        this.NON_RECIPE_WEIGHT = dis.readInt();
					
			        this.WEIGHT_IN_VAC = dis.readInt();
					
			        this.COMMITTED_GROSS_QUANTITY = dis.readInt();
					
			        this.COMMITTED_NET_QUANTITY = dis.readInt();
					
			        this.COMMITTED_WEIGHT_IN_VAC = dis.readInt();
					
			        this.COMMITTED_WEIGHT_IN_AIR = dis.readInt();
					
			        this.COMMITTED_CONV_TEMPERATURE = dis.readDouble();
					
			        this.COMMITTED_CONV_DENSITY = dis.readDouble();
					
			        this.NON_RECIPE_WEIGHT_IN_VAC = dis.readInt();
					
			        this.MINIMUM_TEMPERATURE = dis.readDouble();
					
			        this.MAXIMUM_TEMPERATURE = dis.readDouble();
					
			        this.MINIMUM_BASE_DENSITY = dis.readDouble();
					
			        this.MAXIMUM_BASE_DENSITY = dis.readDouble();
					
			        this.MINIMUM_OBSERVED_DENSITY = dis.readDouble();
					
			        this.MAXIMUM_OBSERVED_DENSITY = dis.readDouble();
					
			        this.MINIMUM_COE = dis.readDouble();
					
			        this.MAXIMUM_COE = dis.readDouble();
					
			        this.USABLE_CAPACITY = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_FACT_SALES_SAM) {

        	try {

        		int length = 0;
		
			        this.FK_ORDERS = dis.readInt();
					
			        this.FK_ORDER_RECIPE = dis.readInt();
					
			        this.FK_API = dis.readInt();
					
			        this.FK_CUSTOMER = dis.readInt();
					
			        this.FK_TRAILER = dis.readInt();
					
			        this.FK_ORDER_TRAILER = dis.readInt();
					
			        this.FK_DRIVER = dis.readInt();
					
			        this.FK_PRODUCT_SUPPLIER = dis.readInt();
					
			        this.BLEND_PERCENT = dis.readDouble();
					
			        this.ORDERED_QUANTITY = dis.readInt();
					
			        this.GROSS_QUANTITY = dis.readInt();
					
			        this.WEIGHT = dis.readInt();
					
			        this.NET_QUANTITY = dis.readInt();
					
			        this.DENSITY = dis.readDouble();
					
			        this.CUSTOMER_NET_QUANTITY = dis.readInt();
					
			        this.TEMPERATURE = dis.readDouble();
					
			        this.START_GROSS_TOTALIZER = dis.readInt();
					
			        this.END_GROSS_TOTALIZER = dis.readInt();
					
			        this.START_NET_TOTALIZER = dis.readInt();
					
			        this.END_NET_TOTALIZER = dis.readInt();
					
			        this.OBSERVED_DENSITY = dis.readDouble();
					
			        this.NON_RECIPE_GROSS_QUANTITY = dis.readInt();
					
			        this.NON_RECIPE_NET_QUANTITY = dis.readInt();
					
			        this.NON_RECIPE_WEIGHT = dis.readInt();
					
			        this.WEIGHT_IN_VAC = dis.readInt();
					
			        this.COMMITTED_GROSS_QUANTITY = dis.readInt();
					
			        this.COMMITTED_NET_QUANTITY = dis.readInt();
					
			        this.COMMITTED_WEIGHT_IN_VAC = dis.readInt();
					
			        this.COMMITTED_WEIGHT_IN_AIR = dis.readInt();
					
			        this.COMMITTED_CONV_TEMPERATURE = dis.readDouble();
					
			        this.COMMITTED_CONV_DENSITY = dis.readDouble();
					
			        this.NON_RECIPE_WEIGHT_IN_VAC = dis.readInt();
					
			        this.MINIMUM_TEMPERATURE = dis.readDouble();
					
			        this.MAXIMUM_TEMPERATURE = dis.readDouble();
					
			        this.MINIMUM_BASE_DENSITY = dis.readDouble();
					
			        this.MAXIMUM_BASE_DENSITY = dis.readDouble();
					
			        this.MINIMUM_OBSERVED_DENSITY = dis.readDouble();
					
			        this.MAXIMUM_OBSERVED_DENSITY = dis.readDouble();
					
			        this.MINIMUM_COE = dis.readDouble();
					
			        this.MAXIMUM_COE = dis.readDouble();
					
			        this.USABLE_CAPACITY = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.FK_ORDERS);
					
					// int
				
		            	dos.writeInt(this.FK_ORDER_RECIPE);
					
					// int
				
		            	dos.writeInt(this.FK_API);
					
					// int
				
		            	dos.writeInt(this.FK_CUSTOMER);
					
					// int
				
		            	dos.writeInt(this.FK_TRAILER);
					
					// int
				
		            	dos.writeInt(this.FK_ORDER_TRAILER);
					
					// int
				
		            	dos.writeInt(this.FK_DRIVER);
					
					// int
				
		            	dos.writeInt(this.FK_PRODUCT_SUPPLIER);
					
					// double
				
		            	dos.writeDouble(this.BLEND_PERCENT);
					
					// int
				
		            	dos.writeInt(this.ORDERED_QUANTITY);
					
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
				
		            	dos.writeDouble(this.TEMPERATURE);
					
					// int
				
		            	dos.writeInt(this.START_GROSS_TOTALIZER);
					
					// int
				
		            	dos.writeInt(this.END_GROSS_TOTALIZER);
					
					// int
				
		            	dos.writeInt(this.START_NET_TOTALIZER);
					
					// int
				
		            	dos.writeInt(this.END_NET_TOTALIZER);
					
					// double
				
		            	dos.writeDouble(this.OBSERVED_DENSITY);
					
					// int
				
		            	dos.writeInt(this.NON_RECIPE_GROSS_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.NON_RECIPE_NET_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.NON_RECIPE_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.COMMITTED_GROSS_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.COMMITTED_NET_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.COMMITTED_WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.COMMITTED_WEIGHT_IN_AIR);
					
					// double
				
		            	dos.writeDouble(this.COMMITTED_CONV_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.COMMITTED_CONV_DENSITY);
					
					// int
				
		            	dos.writeInt(this.NON_RECIPE_WEIGHT_IN_VAC);
					
					// double
				
		            	dos.writeDouble(this.MINIMUM_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.MAXIMUM_TEMPERATURE);
					
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
				
		            	dos.writeInt(this.USABLE_CAPACITY);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.FK_ORDERS);
					
					// int
				
		            	dos.writeInt(this.FK_ORDER_RECIPE);
					
					// int
				
		            	dos.writeInt(this.FK_API);
					
					// int
				
		            	dos.writeInt(this.FK_CUSTOMER);
					
					// int
				
		            	dos.writeInt(this.FK_TRAILER);
					
					// int
				
		            	dos.writeInt(this.FK_ORDER_TRAILER);
					
					// int
				
		            	dos.writeInt(this.FK_DRIVER);
					
					// int
				
		            	dos.writeInt(this.FK_PRODUCT_SUPPLIER);
					
					// double
				
		            	dos.writeDouble(this.BLEND_PERCENT);
					
					// int
				
		            	dos.writeInt(this.ORDERED_QUANTITY);
					
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
				
		            	dos.writeDouble(this.TEMPERATURE);
					
					// int
				
		            	dos.writeInt(this.START_GROSS_TOTALIZER);
					
					// int
				
		            	dos.writeInt(this.END_GROSS_TOTALIZER);
					
					// int
				
		            	dos.writeInt(this.START_NET_TOTALIZER);
					
					// int
				
		            	dos.writeInt(this.END_NET_TOTALIZER);
					
					// double
				
		            	dos.writeDouble(this.OBSERVED_DENSITY);
					
					// int
				
		            	dos.writeInt(this.NON_RECIPE_GROSS_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.NON_RECIPE_NET_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.NON_RECIPE_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.COMMITTED_GROSS_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.COMMITTED_NET_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.COMMITTED_WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.COMMITTED_WEIGHT_IN_AIR);
					
					// double
				
		            	dos.writeDouble(this.COMMITTED_CONV_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.COMMITTED_CONV_DENSITY);
					
					// int
				
		            	dos.writeInt(this.NON_RECIPE_WEIGHT_IN_VAC);
					
					// double
				
		            	dos.writeDouble(this.MINIMUM_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.MAXIMUM_TEMPERATURE);
					
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
				
		            	dos.writeInt(this.USABLE_CAPACITY);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("FK_ORDERS="+String.valueOf(FK_ORDERS));
		sb.append(",FK_ORDER_RECIPE="+String.valueOf(FK_ORDER_RECIPE));
		sb.append(",FK_API="+String.valueOf(FK_API));
		sb.append(",FK_CUSTOMER="+String.valueOf(FK_CUSTOMER));
		sb.append(",FK_TRAILER="+String.valueOf(FK_TRAILER));
		sb.append(",FK_ORDER_TRAILER="+String.valueOf(FK_ORDER_TRAILER));
		sb.append(",FK_DRIVER="+String.valueOf(FK_DRIVER));
		sb.append(",FK_PRODUCT_SUPPLIER="+String.valueOf(FK_PRODUCT_SUPPLIER));
		sb.append(",BLEND_PERCENT="+String.valueOf(BLEND_PERCENT));
		sb.append(",ORDERED_QUANTITY="+String.valueOf(ORDERED_QUANTITY));
		sb.append(",GROSS_QUANTITY="+String.valueOf(GROSS_QUANTITY));
		sb.append(",WEIGHT="+String.valueOf(WEIGHT));
		sb.append(",NET_QUANTITY="+String.valueOf(NET_QUANTITY));
		sb.append(",DENSITY="+String.valueOf(DENSITY));
		sb.append(",CUSTOMER_NET_QUANTITY="+String.valueOf(CUSTOMER_NET_QUANTITY));
		sb.append(",TEMPERATURE="+String.valueOf(TEMPERATURE));
		sb.append(",START_GROSS_TOTALIZER="+String.valueOf(START_GROSS_TOTALIZER));
		sb.append(",END_GROSS_TOTALIZER="+String.valueOf(END_GROSS_TOTALIZER));
		sb.append(",START_NET_TOTALIZER="+String.valueOf(START_NET_TOTALIZER));
		sb.append(",END_NET_TOTALIZER="+String.valueOf(END_NET_TOTALIZER));
		sb.append(",OBSERVED_DENSITY="+String.valueOf(OBSERVED_DENSITY));
		sb.append(",NON_RECIPE_GROSS_QUANTITY="+String.valueOf(NON_RECIPE_GROSS_QUANTITY));
		sb.append(",NON_RECIPE_NET_QUANTITY="+String.valueOf(NON_RECIPE_NET_QUANTITY));
		sb.append(",NON_RECIPE_WEIGHT="+String.valueOf(NON_RECIPE_WEIGHT));
		sb.append(",WEIGHT_IN_VAC="+String.valueOf(WEIGHT_IN_VAC));
		sb.append(",COMMITTED_GROSS_QUANTITY="+String.valueOf(COMMITTED_GROSS_QUANTITY));
		sb.append(",COMMITTED_NET_QUANTITY="+String.valueOf(COMMITTED_NET_QUANTITY));
		sb.append(",COMMITTED_WEIGHT_IN_VAC="+String.valueOf(COMMITTED_WEIGHT_IN_VAC));
		sb.append(",COMMITTED_WEIGHT_IN_AIR="+String.valueOf(COMMITTED_WEIGHT_IN_AIR));
		sb.append(",COMMITTED_CONV_TEMPERATURE="+String.valueOf(COMMITTED_CONV_TEMPERATURE));
		sb.append(",COMMITTED_CONV_DENSITY="+String.valueOf(COMMITTED_CONV_DENSITY));
		sb.append(",NON_RECIPE_WEIGHT_IN_VAC="+String.valueOf(NON_RECIPE_WEIGHT_IN_VAC));
		sb.append(",MINIMUM_TEMPERATURE="+String.valueOf(MINIMUM_TEMPERATURE));
		sb.append(",MAXIMUM_TEMPERATURE="+String.valueOf(MAXIMUM_TEMPERATURE));
		sb.append(",MINIMUM_BASE_DENSITY="+String.valueOf(MINIMUM_BASE_DENSITY));
		sb.append(",MAXIMUM_BASE_DENSITY="+String.valueOf(MAXIMUM_BASE_DENSITY));
		sb.append(",MINIMUM_OBSERVED_DENSITY="+String.valueOf(MINIMUM_OBSERVED_DENSITY));
		sb.append(",MAXIMUM_OBSERVED_DENSITY="+String.valueOf(MAXIMUM_OBSERVED_DENSITY));
		sb.append(",MINIMUM_COE="+String.valueOf(MINIMUM_COE));
		sb.append(",MAXIMUM_COE="+String.valueOf(MAXIMUM_COE));
		sb.append(",USABLE_CAPACITY="+String.valueOf(USABLE_CAPACITY));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(out1Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.FK_ORDERS, other.FK_ORDERS);
						if(returnValue != 0) {
							return returnValue;
						}

					
						returnValue = checkNullsAndCompare(this.FK_ORDER_RECIPE, other.FK_ORDER_RECIPE);
						if(returnValue != 0) {
							return returnValue;
						}

					
						returnValue = checkNullsAndCompare(this.FK_API, other.FK_API);
						if(returnValue != 0) {
							return returnValue;
						}

					
						returnValue = checkNullsAndCompare(this.FK_CUSTOMER, other.FK_CUSTOMER);
						if(returnValue != 0) {
							return returnValue;
						}

					
						returnValue = checkNullsAndCompare(this.FK_TRAILER, other.FK_TRAILER);
						if(returnValue != 0) {
							return returnValue;
						}

					
						returnValue = checkNullsAndCompare(this.FK_ORDER_TRAILER, other.FK_ORDER_TRAILER);
						if(returnValue != 0) {
							return returnValue;
						}

					
						returnValue = checkNullsAndCompare(this.FK_DRIVER, other.FK_DRIVER);
						if(returnValue != 0) {
							return returnValue;
						}

					
						returnValue = checkNullsAndCompare(this.FK_PRODUCT_SUPPLIER, other.FK_PRODUCT_SUPPLIER);
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

public static class row1Struct implements routines.system.IPersistableRow<row1Struct> {
    final static byte[] commonByteArrayLock_PGS_STAGE_FACT_SALES_SAM = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_FACT_SALES_SAM = new byte[0];

	
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
			if(length > commonByteArray_PGS_STAGE_FACT_SALES_SAM.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_FACT_SALES_SAM.length == 0) {
   					commonByteArray_PGS_STAGE_FACT_SALES_SAM = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_FACT_SALES_SAM = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PGS_STAGE_FACT_SALES_SAM, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_FACT_SALES_SAM, 0, length, utf8Charset);
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
			if(length > commonByteArray_PGS_STAGE_FACT_SALES_SAM.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_FACT_SALES_SAM.length == 0) {
   					commonByteArray_PGS_STAGE_FACT_SALES_SAM = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_FACT_SALES_SAM = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PGS_STAGE_FACT_SALES_SAM, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_FACT_SALES_SAM, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PGS_STAGE_FACT_SALES_SAM) {

        	try {

        		int length = 0;
		
			        this.PK_ORDERS = dis.readInt();
					
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

		synchronized(commonByteArrayLock_PGS_STAGE_FACT_SALES_SAM) {

        	try {

        		int length = 0;
		
			        this.PK_ORDERS = dis.readInt();
					
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

		
					// int
				
		            	dos.writeInt(this.PK_ORDERS);
					
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

		
					// int
				
		            	dos.writeInt(this.PK_ORDERS);
					
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
    final static byte[] commonByteArrayLock_PGS_STAGE_FACT_SALES_SAM = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_FACT_SALES_SAM = new byte[0];
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
	
							result = prime * result + (int) this.PK_ORDERS;
						
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
		final after_tDBInput_1Struct other = (after_tDBInput_1Struct) obj;
		
						if (this.PK_ORDERS != other.PK_ORDERS)
							return false;
					

		return true;
    }

	public void copyDataTo(after_tDBInput_1Struct other) {

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

	public void copyKeysDataTo(after_tDBInput_1Struct other) {

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
			if(length > commonByteArray_PGS_STAGE_FACT_SALES_SAM.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_FACT_SALES_SAM.length == 0) {
   					commonByteArray_PGS_STAGE_FACT_SALES_SAM = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_FACT_SALES_SAM = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PGS_STAGE_FACT_SALES_SAM, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_FACT_SALES_SAM, 0, length, utf8Charset);
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
			if(length > commonByteArray_PGS_STAGE_FACT_SALES_SAM.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_FACT_SALES_SAM.length == 0) {
   					commonByteArray_PGS_STAGE_FACT_SALES_SAM = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_FACT_SALES_SAM = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PGS_STAGE_FACT_SALES_SAM, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_FACT_SALES_SAM, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PGS_STAGE_FACT_SALES_SAM) {

        	try {

        		int length = 0;
		
			        this.PK_ORDERS = dis.readInt();
					
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

		synchronized(commonByteArrayLock_PGS_STAGE_FACT_SALES_SAM) {

        	try {

        		int length = 0;
		
			        this.PK_ORDERS = dis.readInt();
					
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

		
					// int
				
		            	dos.writeInt(this.PK_ORDERS);
					
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

		
					// int
				
		            	dos.writeInt(this.PK_ORDERS);
					
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
    public int compareTo(after_tDBInput_1Struct other) {

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
		tDBInput_8Process(globalMap);
		tDBInput_4Process(globalMap);
		tDBInput_9Process(globalMap);
		tDBInput_3Process(globalMap);
		tDBInput_6Process(globalMap);
		tDBInput_7Process(globalMap);
		tDBInput_5Process(globalMap);
		tDBInput_10Process(globalMap);
		tDBInput_11Process(globalMap);

		row1Struct row1 = new row1Struct();
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



        int insertKeyCount_tDBOutput_1 = 8;
        if(insertKeyCount_tDBOutput_1 < 1) {
            throw new RuntimeException("For insert if not exist, Schema must have a key");
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

 
	final String decryptedPassword_tDBOutput_1 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:KWTIjity1Njld8yZ/u7sZkvJmB7/vGUhuSMa5qPP9xldvQTLyQc=");

    String dbPwd_tDBOutput_1 = decryptedPassword_tDBOutput_1;	
    conn_tDBOutput_1 = java.sql.DriverManager.getConnection(url_tDBOutput_1,dbUser_tDBOutput_1,dbPwd_tDBOutput_1);
	
		resourceMap.put("conn_tDBOutput_1", conn_tDBOutput_1);
	
        conn_tDBOutput_1.setAutoCommit(false);
        int commitEvery_tDBOutput_1 = 10000;
        int commitCounter_tDBOutput_1 = 0;


if(dbschema_tDBOutput_1 == null || dbschema_tDBOutput_1.trim().length() == 0) {
    tableName_tDBOutput_1 = "FACT_SALES";
} else {
    tableName_tDBOutput_1 = dbschema_tDBOutput_1 + "].[" + "FACT_SALES";
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
                                        stmtCreate_tDBOutput_1.execute("CREATE TABLE [" + tableName_tDBOutput_1 + "]([FK_ORDERS] INT  not null ,[FK_ORDER_RECIPE] INT  not null ,[FK_API] INT  not null ,[FK_CUSTOMER] INT  not null ,[FK_TRAILER] INT  not null ,[FK_ORDER_TRAILER] INT  not null ,[FK_DRIVER] INT  not null ,[FK_PRODUCT_SUPPLIER] INT  not null ,[BLEND_PERCENT] FLOAT(53)   not null ,[ORDERED_QUANTITY] INT  not null ,[GROSS_QUANTITY] INT  not null ,[WEIGHT] INT  not null ,[NET_QUANTITY] INT  not null ,[DENSITY] FLOAT(53)   not null ,[CUSTOMER_NET_QUANTITY] INT  not null ,[TEMPERATURE] FLOAT(53)   not null ,[START_GROSS_TOTALIZER] INT  not null ,[END_GROSS_TOTALIZER] INT  not null ,[START_NET_TOTALIZER] INT  not null ,[END_NET_TOTALIZER] INT  not null ,[OBSERVED_DENSITY] FLOAT(53)   not null ,[NON_RECIPE_GROSS_QUANTITY] INT  not null ,[NON_RECIPE_NET_QUANTITY] INT  not null ,[NON_RECIPE_WEIGHT] INT  not null ,[WEIGHT_IN_VAC] INT  not null ,[COMMITTED_GROSS_QUANTITY] INT  not null ,[COMMITTED_NET_QUANTITY] INT  not null ,[COMMITTED_WEIGHT_IN_VAC] INT  not null ,[COMMITTED_WEIGHT_IN_AIR] INT  not null ,[COMMITTED_CONV_TEMPERATURE] FLOAT(53)   not null ,[COMMITTED_CONV_DENSITY] FLOAT(53)   not null ,[NON_RECIPE_WEIGHT_IN_VAC] INT  not null ,[MINIMUM_TEMPERATURE] FLOAT(53)   not null ,[MAXIMUM_TEMPERATURE] FLOAT(53)   not null ,[MINIMUM_BASE_DENSITY] FLOAT(53)   not null ,[MAXIMUM_BASE_DENSITY] FLOAT(53)   not null ,[MINIMUM_OBSERVED_DENSITY] FLOAT(53)   not null ,[MAXIMUM_OBSERVED_DENSITY] FLOAT(53)   not null ,[MINIMUM_COE] FLOAT(53)   not null ,[MAXIMUM_COE] FLOAT(53)   not null ,[USABLE_CAPACITY] INT  not null ,primary key([FK_ORDERS],[FK_ORDER_RECIPE],[FK_API],[FK_CUSTOMER],[FK_TRAILER],[FK_ORDER_TRAILER],[FK_DRIVER],[FK_PRODUCT_SUPPLIER]))");
                                    }
                                }
        java.sql.PreparedStatement pstmt_tDBOutput_1 = conn_tDBOutput_1.prepareStatement("SELECT COUNT(1) FROM [" + tableName_tDBOutput_1 + "] WHERE [FK_ORDERS] = ? AND [FK_ORDER_RECIPE] = ? AND [FK_API] = ? AND [FK_CUSTOMER] = ? AND [FK_TRAILER] = ? AND [FK_ORDER_TRAILER] = ? AND [FK_DRIVER] = ? AND [FK_PRODUCT_SUPPLIER] = ?");
        resourceMap.put("pstmt_tDBOutput_1", pstmt_tDBOutput_1);
        String insert_tDBOutput_1 = "INSERT INTO [" + tableName_tDBOutput_1 + "] ([FK_ORDERS],[FK_ORDER_RECIPE],[FK_API],[FK_CUSTOMER],[FK_TRAILER],[FK_ORDER_TRAILER],[FK_DRIVER],[FK_PRODUCT_SUPPLIER],[BLEND_PERCENT],[ORDERED_QUANTITY],[GROSS_QUANTITY],[WEIGHT],[NET_QUANTITY],[DENSITY],[CUSTOMER_NET_QUANTITY],[TEMPERATURE],[START_GROSS_TOTALIZER],[END_GROSS_TOTALIZER],[START_NET_TOTALIZER],[END_NET_TOTALIZER],[OBSERVED_DENSITY],[NON_RECIPE_GROSS_QUANTITY],[NON_RECIPE_NET_QUANTITY],[NON_RECIPE_WEIGHT],[WEIGHT_IN_VAC],[COMMITTED_GROSS_QUANTITY],[COMMITTED_NET_QUANTITY],[COMMITTED_WEIGHT_IN_VAC],[COMMITTED_WEIGHT_IN_AIR],[COMMITTED_CONV_TEMPERATURE],[COMMITTED_CONV_DENSITY],[NON_RECIPE_WEIGHT_IN_VAC],[MINIMUM_TEMPERATURE],[MAXIMUM_TEMPERATURE],[MINIMUM_BASE_DENSITY],[MAXIMUM_BASE_DENSITY],[MINIMUM_OBSERVED_DENSITY],[MAXIMUM_OBSERVED_DENSITY],[MINIMUM_COE],[MAXIMUM_COE],[USABLE_CAPACITY]) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        java.sql.PreparedStatement pstmtInsert_tDBOutput_1 = conn_tDBOutput_1.prepareStatement(insert_tDBOutput_1);
        resourceMap.put("pstmtInsert_tDBOutput_1", pstmtInsert_tDBOutput_1);

 



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
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row1");
					}
				
		int tos_count_tMap_1 = 0;
		




// ###############################
// # Lookup's keys initialization
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct> tHash_Lookup_row2 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct>) 
					globalMap.get( "tHash_Lookup_row2" ))
					;					
					
	

row2Struct row2HashKey = new row2Struct();
row2Struct row2Default = new row2Struct();
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct> tHash_Lookup_row3 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct>) 
					globalMap.get( "tHash_Lookup_row3" ))
					;					
					
	

row3Struct row3HashKey = new row3Struct();
row3Struct row3Default = new row3Struct();
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row4Struct> tHash_Lookup_row4 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row4Struct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row4Struct>) 
					globalMap.get( "tHash_Lookup_row4" ))
					;					
					
	

row4Struct row4HashKey = new row4Struct();
row4Struct row4Default = new row4Struct();
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row5Struct> tHash_Lookup_row5 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row5Struct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row5Struct>) 
					globalMap.get( "tHash_Lookup_row5" ))
					;					
					
	

row5Struct row5HashKey = new row5Struct();
row5Struct row5Default = new row5Struct();
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row6Struct> tHash_Lookup_row6 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row6Struct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row6Struct>) 
					globalMap.get( "tHash_Lookup_row6" ))
					;					
					
	

row6Struct row6HashKey = new row6Struct();
row6Struct row6Default = new row6Struct();
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row10Struct> tHash_Lookup_row10 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row10Struct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row10Struct>) 
					globalMap.get( "tHash_Lookup_row10" ))
					;					
					
	

row10Struct row10HashKey = new row10Struct();
row10Struct row10Default = new row10Struct();
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row11Struct> tHash_Lookup_row11 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row11Struct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row11Struct>) 
					globalMap.get( "tHash_Lookup_row11" ))
					;					
					
	

row11Struct row11HashKey = new row11Struct();
row11Struct row11Default = new row11Struct();
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row7Struct> tHash_Lookup_row7 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row7Struct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row7Struct>) 
					globalMap.get( "tHash_Lookup_row7" ))
					;					
					
	

row7Struct row7HashKey = new row7Struct();
row7Struct row7Default = new row7Struct();
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row8Struct> tHash_Lookup_row8 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row8Struct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row8Struct>) 
					globalMap.get( "tHash_Lookup_row8" ))
					;					
					
	

row8Struct row8HashKey = new row8Struct();
row8Struct row8Default = new row8Struct();
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row9Struct> tHash_Lookup_row9 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row9Struct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row9Struct>) 
					globalMap.get( "tHash_Lookup_row9" ))
					;					
					
	

row9Struct row9HashKey = new row9Struct();
row9Struct row9Default = new row9Struct();
// ###############################        

// ###############################
// # Vars initialization
class  Var__tMap_1__Struct  {
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
				
				 
	final String decryptedPassword_tDBInput_1 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:KVWeEHybzukPTbibcS82FR44xrrlMl+ph5t8gaE7dw4KIkjc0Zo=");
				
				String dbPwd_tDBInput_1 = decryptedPassword_tDBInput_1;
				
		    String port_tDBInput_1 = "1433";
		    String dbname_tDBInput_1 = "PGS_STAGE_DW" ;
			String url_tDBInput_1 = "jdbc:jtds:sqlserver://" + "LAPTOP-HED7JE2F" ;
		    if (!"".equals(port_tDBInput_1)) {
		    	url_tDBInput_1 += ":" + "1433";
		    }
		    if (!"".equals(dbname_tDBInput_1)) {
				url_tDBInput_1 += "//" + "PGS_STAGE_DW"; 
		    }
		    url_tDBInput_1 += ";appName=" + projectName + ";" + "";
		    String dbschema_tDBInput_1 = "dbo";
				
				conn_tDBInput_1 = java.sql.DriverManager.getConnection(url_tDBInput_1,dbUser_tDBInput_1,dbPwd_tDBInput_1);
		        
		    
			java.sql.Statement stmt_tDBInput_1 = conn_tDBInput_1.createStatement();

		    String dbquery_tDBInput_1 = "SELECT dbo.DIM_ORDERS.PK_ORDERS,\n		dbo.DIM_ORDERS.ORDER_ID,\n		dbo.DIM_ORDERS.LOADED_DRIVER_NUMBER,\n		dbo.DIM_ORDERS.CAR"
+"RIER_NUMBER,\n		dbo.DIM_ORDERS.LOADED_CARRIER_NUMBER,\n		dbo.DIM_ORDERS.FOLIO_NUMBER,\n		dbo.DIM_ORDERS.DISPATCH_CARRIER_NU"
+"MBER,\n		dbo.DIM_ORDERS.SUPPLIER_NUMBER,\n		dbo.DIM_ORDERS.CUSTOMER_NUMBER,\n		dbo.DIM_ORDERS.DESTINATION_NUMBER,\n		dbo.DIM"
+"_ORDERS.TRIP_ID,\n		dbo.DIM_ORDERS.TYPE,\n		dbo.DIM_ORDERS.CREATOR,\n		dbo.DIM_ORDERS.MANUALLY_ENTERED,\n		dbo.DIM_ORDERS.MO"
+"VEMENT_NUMBER,\n		dbo.DIM_ORDERS.REVISION_NUMBER,\n		dbo.DIM_ORDERS.REVISED,\n		dbo.DIM_ORDERS.STATUS,\n		dbo.DIM_ORDERS.STA"
+"TUS_DATE,\n		dbo.DIM_ORDERS.START_LOAD_TIME,\n		dbo.DIM_ORDERS.END_LOAD_TIME,\n		dbo.DIM_ORDERS.LAST_USER_NAME,\n		dbo.DIM_O"
+"RDERS.LAST_MODIFIED,\n		dbo.DIM_ORDERS.BOL_PRINTED,\n		dbo.DIM_ORDERS.ORDER_ENTRY_TIME,\n		dbo.DIM_ORDERS.MANUALLY_COMPLETE"
+"D,\n		dbo.DIM_ORDERS.AIC_STATUS,\n		dbo.DIM_ORDERS.AUTHORIZATION_REQUEST_ID\nFROM	dbo.DIM_ORDERS";
		    

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
								row1.PK_ORDERS = 0;
							} else {
		                          
            row1.PK_ORDERS = rs_tDBInput_1.getInt(1);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 2) {
								row1.ORDER_ID = 0;
							} else {
		                          
            row1.ORDER_ID = rs_tDBInput_1.getInt(2);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 3) {
								row1.LOADED_DRIVER_NUMBER = null;
							} else {
		                          
            row1.LOADED_DRIVER_NUMBER = rs_tDBInput_1.getInt(3);
            if(rs_tDBInput_1.wasNull()){
                    row1.LOADED_DRIVER_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 4) {
								row1.CARRIER_NUMBER = 0;
							} else {
		                          
            row1.CARRIER_NUMBER = rs_tDBInput_1.getInt(4);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 5) {
								row1.LOADED_CARRIER_NUMBER = null;
							} else {
		                          
            row1.LOADED_CARRIER_NUMBER = rs_tDBInput_1.getInt(5);
            if(rs_tDBInput_1.wasNull()){
                    row1.LOADED_CARRIER_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 6) {
								row1.FOLIO_NUMBER = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(6);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(6).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.FOLIO_NUMBER = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.FOLIO_NUMBER = tmpContent_tDBInput_1;
                }
            } else {
                row1.FOLIO_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 7) {
								row1.DISPATCH_CARRIER_NUMBER = null;
							} else {
		                          
            row1.DISPATCH_CARRIER_NUMBER = rs_tDBInput_1.getInt(7);
            if(rs_tDBInput_1.wasNull()){
                    row1.DISPATCH_CARRIER_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 8) {
								row1.SUPPLIER_NUMBER = 0;
							} else {
		                          
            row1.SUPPLIER_NUMBER = rs_tDBInput_1.getInt(8);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 9) {
								row1.CUSTOMER_NUMBER = 0;
							} else {
		                          
            row1.CUSTOMER_NUMBER = rs_tDBInput_1.getInt(9);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 10) {
								row1.DESTINATION_NUMBER = 0;
							} else {
		                          
            row1.DESTINATION_NUMBER = rs_tDBInput_1.getInt(10);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 11) {
								row1.TRIP_ID = null;
							} else {
		                          
            row1.TRIP_ID = rs_tDBInput_1.getInt(11);
            if(rs_tDBInput_1.wasNull()){
                    row1.TRIP_ID = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 12) {
								row1.TYPE = 0;
							} else {
		                          
            row1.TYPE = rs_tDBInput_1.getInt(12);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 13) {
								row1.CREATOR = 0;
							} else {
		                          
            row1.CREATOR = rs_tDBInput_1.getInt(13);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 14) {
								row1.MANUALLY_ENTERED = 0;
							} else {
		                          
            row1.MANUALLY_ENTERED = rs_tDBInput_1.getInt(14);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 15) {
								row1.MOVEMENT_NUMBER = 0;
							} else {
		                          
            row1.MOVEMENT_NUMBER = rs_tDBInput_1.getInt(15);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 16) {
								row1.REVISION_NUMBER = 0;
							} else {
		                          
            row1.REVISION_NUMBER = rs_tDBInput_1.getInt(16);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 17) {
								row1.REVISED = 0;
							} else {
		                          
            row1.REVISED = rs_tDBInput_1.getInt(17);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 18) {
								row1.STATUS = 0;
							} else {
		                          
            row1.STATUS = rs_tDBInput_1.getInt(18);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 19) {
								row1.STATUS_DATE = null;
							} else {
										
			row1.STATUS_DATE = mssqlGTU_tDBInput_1.getDate(rsmd_tDBInput_1, rs_tDBInput_1, 19);
			
		                    }
							if(colQtyInRs_tDBInput_1 < 20) {
								row1.START_LOAD_TIME = null;
							} else {
										
			row1.START_LOAD_TIME = mssqlGTU_tDBInput_1.getDate(rsmd_tDBInput_1, rs_tDBInput_1, 20);
			
		                    }
							if(colQtyInRs_tDBInput_1 < 21) {
								row1.END_LOAD_TIME = null;
							} else {
										
			row1.END_LOAD_TIME = mssqlGTU_tDBInput_1.getDate(rsmd_tDBInput_1, rs_tDBInput_1, 21);
			
		                    }
							if(colQtyInRs_tDBInput_1 < 22) {
								row1.LAST_USER_NAME = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(22);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(22).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.LAST_USER_NAME = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.LAST_USER_NAME = tmpContent_tDBInput_1;
                }
            } else {
                row1.LAST_USER_NAME = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 23) {
								row1.LAST_MODIFIED = null;
							} else {
										
			row1.LAST_MODIFIED = mssqlGTU_tDBInput_1.getDate(rsmd_tDBInput_1, rs_tDBInput_1, 23);
			
		                    }
							if(colQtyInRs_tDBInput_1 < 24) {
								row1.BOL_PRINTED = 0;
							} else {
		                          
            row1.BOL_PRINTED = rs_tDBInput_1.getInt(24);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 25) {
								row1.ORDER_ENTRY_TIME = null;
							} else {
										
			row1.ORDER_ENTRY_TIME = mssqlGTU_tDBInput_1.getDate(rsmd_tDBInput_1, rs_tDBInput_1, 25);
			
		                    }
							if(colQtyInRs_tDBInput_1 < 26) {
								row1.MANUALLY_COMPLETED = 0;
							} else {
		                          
            row1.MANUALLY_COMPLETED = rs_tDBInput_1.getInt(26);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 27) {
								row1.AIC_STATUS = 0;
							} else {
		                          
            row1.AIC_STATUS = rs_tDBInput_1.getInt(27);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 28) {
								row1.AUTHORIZATION_REQUEST_ID = 0;
							} else {
		                          
            row1.AUTHORIZATION_REQUEST_ID = rs_tDBInput_1.getInt(28);
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
	 * [tMap_1 main ] start
	 */

	

	
	
	currentComponent="tMap_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row1"
						
						);
					}
					

		
		
		boolean hasCasePrimitiveKeyWithNull_tMap_1 = false;
		

        // ###############################
        // # Input tables (lookups)
		  boolean rejectedInnerJoin_tMap_1 = false;
		  boolean mainRowRejected_tMap_1 = false;
            				    								  
		

				///////////////////////////////////////////////
				// Starting Lookup Table "row2" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLooprow2 = false;
       		  	    	
       		  	    	
 							row2Struct row2ObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_1) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_1 = false;
								
	                        		    	Object exprKeyValue_row2__ORDER_ID = row1.ORDER_ID ;
	                        		    	if(exprKeyValue_row2__ORDER_ID == null) {
	                        		    		hasCasePrimitiveKeyWithNull_tMap_1 = true;
	                        		    	} else {
                        		    			row2HashKey.ORDER_ID = (int)(Integer) exprKeyValue_row2__ORDER_ID;
                        		    		}
                        		    		

								
		                        	row2HashKey.hashCodeDirty = true;
                        		
	  					
	  							
	
		  							if(!hasCasePrimitiveKeyWithNull_tMap_1) { // G_TM_M_091
		  							
			  					
			  					
			  					
	  					
		  							tHash_Lookup_row2.lookup( row2HashKey );

	  							

	  							

			  						} // G_TM_M_091
			  						
			  					

 								
								  
								  if(hasCasePrimitiveKeyWithNull_tMap_1 || !tHash_Lookup_row2.hasNext()) { // G_TM_M_090

  								
		  				
	  								
			  							rejectedInnerJoin_tMap_1 = true;
	  								
						
									
	
		  								forceLooprow2 = true;
	  					
  									
  									  		
 								
								  
								  } // G_TM_M_090

  								



							} // G_TM_M_020
			           		  	  
							
								
								else { // G 20 - G 21
   									forceLooprow2 = true;
			           		  	} // G 21
                    		  	
                    		

							row2Struct row2 = null;
                    		  	 
							

								while ((tHash_Lookup_row2 != null && tHash_Lookup_row2.hasNext()) || forceLooprow2) { // G_TM_M_043

								
									 // CALL close loop of lookup 'row2'
									
                    		  	 
							   
                    		  	 
	       		  	    	row2Struct fromLookup_row2 = null;
							row2 = row2Default;
										 
							
								
								if(!forceLooprow2) { // G 46
								
							
								 
							
								
								fromLookup_row2 = tHash_Lookup_row2.next();

							

							if(fromLookup_row2 != null) {
								row2 = fromLookup_row2;
							}
							
							
							
			  							
								
	                    		  	
		                    
	                    	
	                    		} // G 46
	                    		  	
								forceLooprow2 = false;
									 	
							
	            	
	           	
	            	
	            	
	            

				///////////////////////////////////////////////
				// Starting Lookup Table "row3" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLooprow3 = false;
       		  	    	
       		  	    	
 							row3Struct row3ObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_1) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_1 = false;
								
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
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row3' and it contains more one result from keys :  row3.ORDER_RECIPE_ID = '" + row3HashKey.ORDER_RECIPE_ID + "'");
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
							
							
							
			  							
								
	                    		  	
		                    
	            	
	           	
	            	
	            	
	            

				///////////////////////////////////////////////
				// Starting Lookup Table "row4" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLooprow4 = false;
       		  	    	
       		  	    	
 							row4Struct row4ObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_1) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_1 = false;
								
                        		    		    row4HashKey.API_CODE = row2.API_CODE ;
                        		    		

								
		                        	row4HashKey.hashCodeDirty = true;
                        		
	  					
	  							
			  					
			  					
	  					
		  							tHash_Lookup_row4.lookup( row4HashKey );

	  							

	  							

 								
		  				
	  								
						
									
  									  		
 								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_row4 != null && tHash_Lookup_row4.getCount(row4HashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row4' and it contains more one result from keys :  row4.API_CODE = '" + row4HashKey.API_CODE + "'");
								} // G 071
							

							row4Struct row4 = null;
                    		  	 
							   
                    		  	 
	       		  	    	row4Struct fromLookup_row4 = null;
							row4 = row4Default;
										 
							
								 
							
							
								if (tHash_Lookup_row4 !=null && tHash_Lookup_row4.hasNext()) { // G 099
								
							
								
								fromLookup_row4 = tHash_Lookup_row4.next();

							
							
								} // G 099
							
							

							if(fromLookup_row4 != null) {
								row4 = fromLookup_row4;
							}
							
							
							
			  							
								
	                    		  	
		                    
	            	
	           	
	            	
	            	
	            

				///////////////////////////////////////////////
				// Starting Lookup Table "row5" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLooprow5 = false;
       		  	    	
       		  	    	
 							row5Struct row5ObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_1) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_1 = false;
								
                        		    		    row5HashKey.API_CODE = row4.API_CODE ;
                        		    		

								
		                        	row5HashKey.hashCodeDirty = true;
                        		
	  					
	  							
			  					
			  					
	  					
		  							tHash_Lookup_row5.lookup( row5HashKey );

	  							

	  							

 								
		  				
	  								
						
									
  									  		
 								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_row5 != null && tHash_Lookup_row5.getCount(row5HashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row5' and it contains more one result from keys :  row5.API_CODE = '" + row5HashKey.API_CODE + "'");
								} // G 071
							

							row5Struct row5 = null;
                    		  	 
							   
                    		  	 
	       		  	    	row5Struct fromLookup_row5 = null;
							row5 = row5Default;
										 
							
								 
							
							
								if (tHash_Lookup_row5 !=null && tHash_Lookup_row5.hasNext()) { // G 099
								
							
								
								fromLookup_row5 = tHash_Lookup_row5.next();

							
							
								} // G 099
							
							

							if(fromLookup_row5 != null) {
								row5 = fromLookup_row5;
							}
							
							
							
			  							
								
	                    		  	
		                    
	            	
	           	
	            	
	            	
	            

				///////////////////////////////////////////////
				// Starting Lookup Table "row6" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLooprow6 = false;
       		  	    	
       		  	    	
 							row6Struct row6ObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_1) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_1 = false;
								
	                        		    	Object exprKeyValue_row6__CUSTOMER_NUMBER = row1.CUSTOMER_NUMBER ;
	                        		    	if(exprKeyValue_row6__CUSTOMER_NUMBER == null) {
	                        		    		hasCasePrimitiveKeyWithNull_tMap_1 = true;
	                        		    	} else {
                        		    			row6HashKey.CUSTOMER_NUMBER = (int)(Integer) exprKeyValue_row6__CUSTOMER_NUMBER;
                        		    		}
                        		    		

								
		                        	row6HashKey.hashCodeDirty = true;
                        		
	  					
	  							
	
		  							if(!hasCasePrimitiveKeyWithNull_tMap_1) { // G_TM_M_091
		  							
			  					
			  					
			  					
	  					
		  							tHash_Lookup_row6.lookup( row6HashKey );

	  							

	  							

			  						} // G_TM_M_091
			  						
			  					

 								
		  				
	  								
						
									
  									  		
 								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_row6 != null && tHash_Lookup_row6.getCount(row6HashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row6' and it contains more one result from keys :  row6.CUSTOMER_NUMBER = '" + row6HashKey.CUSTOMER_NUMBER + "'");
								} // G 071
							

							row6Struct row6 = null;
                    		  	 
							   
                    		  	 
	       		  	    	row6Struct fromLookup_row6 = null;
							row6 = row6Default;
										 
							
								 
							
							
								if (tHash_Lookup_row6 !=null && tHash_Lookup_row6.hasNext()) { // G 099
								
							
								
								fromLookup_row6 = tHash_Lookup_row6.next();

							
							
								} // G 099
							
							

							if(fromLookup_row6 != null) {
								row6 = fromLookup_row6;
							}
							
							
							
			  							
								
	                    		  	
		                    
	            	
	           	
	            	
	            	
	            

				///////////////////////////////////////////////
				// Starting Lookup Table "row10" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLooprow10 = false;
       		  	    	
       		  	    	
 							row10Struct row10ObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_1) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_1 = false;
								
	                        		    	Object exprKeyValue_row10__CARRIER_NUMBER = row1.CARRIER_NUMBER ;
	                        		    	if(exprKeyValue_row10__CARRIER_NUMBER == null) {
	                        		    		hasCasePrimitiveKeyWithNull_tMap_1 = true;
	                        		    	} else {
                        		    			row10HashKey.CARRIER_NUMBER = (int)(Integer) exprKeyValue_row10__CARRIER_NUMBER;
                        		    		}
                        		    		
	                        		    	Object exprKeyValue_row10__DRIVER_NUMBER = row1.LOADED_DRIVER_NUMBER ;
	                        		    	if(exprKeyValue_row10__DRIVER_NUMBER == null) {
	                        		    		hasCasePrimitiveKeyWithNull_tMap_1 = true;
	                        		    	} else {
                        		    			row10HashKey.DRIVER_NUMBER = (int)(Integer) exprKeyValue_row10__DRIVER_NUMBER;
                        		    		}
                        		    		

								
		                        	row10HashKey.hashCodeDirty = true;
                        		
	  					
	  							
	
		  							if(!hasCasePrimitiveKeyWithNull_tMap_1) { // G_TM_M_091
		  							
			  					
			  					
			  					
	  					
		  							tHash_Lookup_row10.lookup( row10HashKey );

	  							

	  							

			  						} // G_TM_M_091
			  						
			  					

 								
		  				
	  								
						
									
  									  		
 								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_row10 != null && tHash_Lookup_row10.getCount(row10HashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row10' and it contains more one result from keys :  row10.CARRIER_NUMBER = '" + row10HashKey.CARRIER_NUMBER + "', row10.DRIVER_NUMBER = '" + row10HashKey.DRIVER_NUMBER + "'");
								} // G 071
							

							row10Struct row10 = null;
                    		  	 
							   
                    		  	 
	       		  	    	row10Struct fromLookup_row10 = null;
							row10 = row10Default;
										 
							
								 
							
							
								if (tHash_Lookup_row10 !=null && tHash_Lookup_row10.hasNext()) { // G 099
								
							
								
								fromLookup_row10 = tHash_Lookup_row10.next();

							
							
								} // G 099
							
							

							if(fromLookup_row10 != null) {
								row10 = fromLookup_row10;
							}
							
							
							
			  							
								
	                    		  	
		                    
	            	
	           	
	            	
	            	
	            

				///////////////////////////////////////////////
				// Starting Lookup Table "row11" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLooprow11 = false;
       		  	    	
       		  	    	
 							row11Struct row11ObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_1) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_1 = false;
								
	                        		    	Object exprKeyValue_row11__SUPPLIER_NUMBER = row2.SUPPLIER_NUMBER;
	                        		    	if(exprKeyValue_row11__SUPPLIER_NUMBER == null) {
	                        		    		hasCasePrimitiveKeyWithNull_tMap_1 = true;
	                        		    	} else {
                        		    			row11HashKey.SUPPLIER_NUMBER = (int)(Integer) exprKeyValue_row11__SUPPLIER_NUMBER;
                        		    		}
                        		    		
                        		    		    row11HashKey.PRODUCT_GROUP_CODE = row2.PRODUCT_GROUP_CODE;
                        		    		

								
		                        	row11HashKey.hashCodeDirty = true;
                        		
	  					
	  							
	
		  							if(!hasCasePrimitiveKeyWithNull_tMap_1) { // G_TM_M_091
		  							
			  					
			  					
			  					
	  					
		  							tHash_Lookup_row11.lookup( row11HashKey );

	  							

	  							

			  						} // G_TM_M_091
			  						
			  					

 								
		  				
	  								
						
									
  									  		
 								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_row11 != null && tHash_Lookup_row11.getCount(row11HashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row11' and it contains more one result from keys :  row11.SUPPLIER_NUMBER = '" + row11HashKey.SUPPLIER_NUMBER + "', row11.PRODUCT_GROUP_CODE = '" + row11HashKey.PRODUCT_GROUP_CODE + "'");
								} // G 071
							

							row11Struct row11 = null;
                    		  	 
							   
                    		  	 
	       		  	    	row11Struct fromLookup_row11 = null;
							row11 = row11Default;
										 
							
								 
							
							
								if (tHash_Lookup_row11 !=null && tHash_Lookup_row11.hasNext()) { // G 099
								
							
								
								fromLookup_row11 = tHash_Lookup_row11.next();

							
							
								} // G 099
							
							

							if(fromLookup_row11 != null) {
								row11 = fromLookup_row11;
							}
							
							
							
			  							
								
	                    		  	
		                    
	            	
	           	
	            	
	            	
	            

				///////////////////////////////////////////////
				// Starting Lookup Table "row7" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLooprow7 = false;
       		  	    	
       		  	    	
 							row7Struct row7ObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_1) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_1 = false;
								
	                        		    	Object exprKeyValue_row7__ORDER_ID = row1.ORDER_ID ;
	                        		    	if(exprKeyValue_row7__ORDER_ID == null) {
	                        		    		hasCasePrimitiveKeyWithNull_tMap_1 = true;
	                        		    	} else {
                        		    			row7HashKey.ORDER_ID = (int)(Integer) exprKeyValue_row7__ORDER_ID;
                        		    		}
                        		    		

								
		                        	row7HashKey.hashCodeDirty = true;
                        		
	  					
	  							
	
		  							if(!hasCasePrimitiveKeyWithNull_tMap_1) { // G_TM_M_091
		  							
			  					
			  					
			  					
	  					
		  							tHash_Lookup_row7.lookup( row7HashKey );

	  							

	  							

			  						} // G_TM_M_091
			  						
			  					

 								
		  				
	  								
						
									
  									  		
 								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_row7 != null && tHash_Lookup_row7.getCount(row7HashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row7' and it contains more one result from keys :  row7.ORDER_ID = '" + row7HashKey.ORDER_ID + "'");
								} // G 071
							

							row7Struct row7 = null;
                    		  	 
							   
                    		  	 
	       		  	    	row7Struct fromLookup_row7 = null;
							row7 = row7Default;
										 
							
								 
							
							
								if (tHash_Lookup_row7 !=null && tHash_Lookup_row7.hasNext()) { // G 099
								
							
								
								fromLookup_row7 = tHash_Lookup_row7.next();

							
							
								} // G 099
							
							

							if(fromLookup_row7 != null) {
								row7 = fromLookup_row7;
							}
							
							
							
			  							
								
	                    		  	
		                    
	            	
	           	
	            	
	            	
	            

				///////////////////////////////////////////////
				// Starting Lookup Table "row8" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLooprow8 = false;
       		  	    	
       		  	    	
 							row8Struct row8ObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_1) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_1 = false;
								
	                        		    	Object exprKeyValue_row8__CARRIER_NUMBER = row7.CARRIER_NUMBER ;
	                        		    	if(exprKeyValue_row8__CARRIER_NUMBER == null) {
	                        		    		hasCasePrimitiveKeyWithNull_tMap_1 = true;
	                        		    	} else {
                        		    			row8HashKey.CARRIER_NUMBER = (int)(Integer) exprKeyValue_row8__CARRIER_NUMBER;
                        		    		}
                        		    		
                        		    		    row8HashKey.TRAILER_CODE = row7.TRAILER_CODE;
                        		    		

								
		                        	row8HashKey.hashCodeDirty = true;
                        		
	  					
	  							
	
		  							if(!hasCasePrimitiveKeyWithNull_tMap_1) { // G_TM_M_091
		  							
			  					
			  					
			  					
	  					
		  							tHash_Lookup_row8.lookup( row8HashKey );

	  							

	  							

			  						} // G_TM_M_091
			  						
			  					

 								
		  				
	  								
						
									
  									  		
 								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_row8 != null && tHash_Lookup_row8.getCount(row8HashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row8' and it contains more one result from keys :  row8.CARRIER_NUMBER = '" + row8HashKey.CARRIER_NUMBER + "', row8.TRAILER_CODE = '" + row8HashKey.TRAILER_CODE + "'");
								} // G 071
							

							row8Struct row8 = null;
                    		  	 
							   
                    		  	 
	       		  	    	row8Struct fromLookup_row8 = null;
							row8 = row8Default;
										 
							
								 
							
							
								if (tHash_Lookup_row8 !=null && tHash_Lookup_row8.hasNext()) { // G 099
								
							
								
								fromLookup_row8 = tHash_Lookup_row8.next();

							
							
								} // G 099
							
							

							if(fromLookup_row8 != null) {
								row8 = fromLookup_row8;
							}
							
							
							
			  							
								
	                    		  	
		                    
	            	
	           	
	            	
	            	
	            

				///////////////////////////////////////////////
				// Starting Lookup Table "row9" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLooprow9 = false;
       		  	    	
       		  	    	
 							row9Struct row9ObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_1) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_1 = false;
								
	                        		    	Object exprKeyValue_row9__CARRIER_NUMBER = row8.CARRIER_NUMBER ;
	                        		    	if(exprKeyValue_row9__CARRIER_NUMBER == null) {
	                        		    		hasCasePrimitiveKeyWithNull_tMap_1 = true;
	                        		    	} else {
                        		    			row9HashKey.CARRIER_NUMBER = (int)(Integer) exprKeyValue_row9__CARRIER_NUMBER;
                        		    		}
                        		    		
                        		    		    row9HashKey.TRAILER_CODE = row8.TRAILER_CODE ;
                        		    		

								
		                        	row9HashKey.hashCodeDirty = true;
                        		
	  					
	  							
	
		  							if(!hasCasePrimitiveKeyWithNull_tMap_1) { // G_TM_M_091
		  							
			  					
			  					
			  					
	  					
		  							tHash_Lookup_row9.lookup( row9HashKey );

	  							

	  							

			  						} // G_TM_M_091
			  						
			  					

 								
		  				
	  								
						
									
  									  		
 								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_row9 != null && tHash_Lookup_row9.getCount(row9HashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row9' and it contains more one result from keys :  row9.CARRIER_NUMBER = '" + row9HashKey.CARRIER_NUMBER + "', row9.TRAILER_CODE = '" + row9HashKey.TRAILER_CODE + "'");
								} // G 071
							

							row9Struct row9 = null;
                    		  	 
							   
                    		  	 
	       		  	    	row9Struct fromLookup_row9 = null;
							row9 = row9Default;
										 
							
								 
							
							
								if (tHash_Lookup_row9 !=null && tHash_Lookup_row9.hasNext()) { // G 099
								
							
								
								fromLookup_row9 = tHash_Lookup_row9.next();

							
							
								} // G 099
							
							

							if(fromLookup_row9 != null) {
								row9 = fromLookup_row9;
							}
							
							
							
			  							
								
	                    		  	
		                    
	            	
	            	
	            // ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_1__Struct Var = Var__tMap_1;// ###############################
        // ###############################
        // # Output tables

out1 = null;

if(!rejectedInnerJoin_tMap_1 ) {

// # Output table : 'out1'
out1_tmp.FK_ORDERS = row1.PK_ORDERS ;
out1_tmp.FK_ORDER_RECIPE = row2.PK_ORDER_RECIPE ;
out1_tmp.FK_API = row4.PK_API ;
out1_tmp.FK_CUSTOMER = row6.PK_CUSTOMER ;
out1_tmp.FK_TRAILER = row8.PK_TRAILER ;
out1_tmp.FK_ORDER_TRAILER = row7.PK_ORDER_TRAILER ;
out1_tmp.FK_DRIVER = row10.PK_DRIVER ;
out1_tmp.FK_PRODUCT_SUPPLIER = row11.PK_PRODUCT_SUPPLIER ;
out1_tmp.BLEND_PERCENT = row3.BLEND_PERCENT ;
out1_tmp.ORDERED_QUANTITY = row3.ORDERED_QUANTITY ;
out1_tmp.GROSS_QUANTITY = row3.GROSS_QUANTITY ;
out1_tmp.WEIGHT = row3.WEIGHT ;
out1_tmp.NET_QUANTITY = row3.NET_QUANTITY ;
out1_tmp.DENSITY = row3.DENSITY ;
out1_tmp.CUSTOMER_NET_QUANTITY = row3.CUSTOMER_NET_QUANTITY ;
out1_tmp.TEMPERATURE = row3.TEMPERATURE ;
out1_tmp.START_GROSS_TOTALIZER = row3.START_GROSS_TOTALIZER ;
out1_tmp.END_GROSS_TOTALIZER = row3.END_GROSS_TOTALIZER ;
out1_tmp.START_NET_TOTALIZER = row3.START_NET_TOTALIZER ;
out1_tmp.END_NET_TOTALIZER = row3.END_NET_TOTALIZER ;
out1_tmp.OBSERVED_DENSITY = row3.OBSERVED_DENSITY ;
out1_tmp.NON_RECIPE_GROSS_QUANTITY = row3.NON_RECIPE_GROSS_QUANTITY ;
out1_tmp.NON_RECIPE_NET_QUANTITY = row3.NON_RECIPE_NET_QUANTITY ;
out1_tmp.NON_RECIPE_WEIGHT = row3.NON_RECIPE_WEIGHT ;
out1_tmp.WEIGHT_IN_VAC = row3.WEIGHT_IN_VAC ;
out1_tmp.COMMITTED_GROSS_QUANTITY = row3.COMMITTED_GROSS_QUANTITY ;
out1_tmp.COMMITTED_NET_QUANTITY = row3.COMMITTED_NET_QUANTITY ;
out1_tmp.COMMITTED_WEIGHT_IN_VAC = row3.COMMITTED_WEIGHT_IN_VAC ;
out1_tmp.COMMITTED_WEIGHT_IN_AIR = row3.COMMITTED_WEIGHT_IN_AIR ;
out1_tmp.COMMITTED_CONV_TEMPERATURE = row3.COMMITTED_CONV_TEMPERATURE ;
out1_tmp.COMMITTED_CONV_DENSITY = row3.COMMITTED_CONV_DENSITY ;
out1_tmp.NON_RECIPE_WEIGHT_IN_VAC = row3.NON_RECIPE_WEIGHT_IN_VAC ;
out1_tmp.MINIMUM_TEMPERATURE = row5.MINIMUM_TEMPERATURE ;
out1_tmp.MAXIMUM_TEMPERATURE = row5.MAXIMUM_TEMPERATURE ;
out1_tmp.MINIMUM_BASE_DENSITY = row5.MINIMUM_BASE_DENSITY ;
out1_tmp.MAXIMUM_BASE_DENSITY = row5.MAXIMUM_BASE_DENSITY ;
out1_tmp.MINIMUM_OBSERVED_DENSITY = row5.MINIMUM_OBSERVED_DENSITY ;
out1_tmp.MAXIMUM_OBSERVED_DENSITY = row5.MAXIMUM_OBSERVED_DENSITY ;
out1_tmp.MINIMUM_COE = row5.MINIMUM_COE ;
out1_tmp.MAXIMUM_COE = row5.MAXIMUM_COE ;
out1_tmp.USABLE_CAPACITY = row9.USABLE_CAPACITY ;
out1 = out1_tmp;
}  // closing inner join bracket (2)
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

                pstmt_tDBOutput_1.setInt(1, out1.FK_ORDERS);


                pstmt_tDBOutput_1.setInt(2, out1.FK_ORDER_RECIPE);


                pstmt_tDBOutput_1.setInt(3, out1.FK_API);


                pstmt_tDBOutput_1.setInt(4, out1.FK_CUSTOMER);


                pstmt_tDBOutput_1.setInt(5, out1.FK_TRAILER);


                pstmt_tDBOutput_1.setInt(6, out1.FK_ORDER_TRAILER);


                pstmt_tDBOutput_1.setInt(7, out1.FK_DRIVER);


                pstmt_tDBOutput_1.setInt(8, out1.FK_PRODUCT_SUPPLIER);


        java.sql.ResultSet rs_tDBOutput_1 = pstmt_tDBOutput_1.executeQuery();
        int checkCount_tDBOutput_1 = -1;
        while(rs_tDBOutput_1.next()) {
            checkCount_tDBOutput_1 = rs_tDBOutput_1.getInt(1);
        }

        if (checkCount_tDBOutput_1 < 1) {
                    pstmtInsert_tDBOutput_1.setInt(1, out1.FK_ORDERS);

                    pstmtInsert_tDBOutput_1.setInt(2, out1.FK_ORDER_RECIPE);

                    pstmtInsert_tDBOutput_1.setInt(3, out1.FK_API);

                    pstmtInsert_tDBOutput_1.setInt(4, out1.FK_CUSTOMER);

                    pstmtInsert_tDBOutput_1.setInt(5, out1.FK_TRAILER);

                    pstmtInsert_tDBOutput_1.setInt(6, out1.FK_ORDER_TRAILER);

                    pstmtInsert_tDBOutput_1.setInt(7, out1.FK_DRIVER);

                    pstmtInsert_tDBOutput_1.setInt(8, out1.FK_PRODUCT_SUPPLIER);

                    pstmtInsert_tDBOutput_1.setDouble(9, out1.BLEND_PERCENT);

                    pstmtInsert_tDBOutput_1.setInt(10, out1.ORDERED_QUANTITY);

                    pstmtInsert_tDBOutput_1.setInt(11, out1.GROSS_QUANTITY);

                    pstmtInsert_tDBOutput_1.setInt(12, out1.WEIGHT);

                    pstmtInsert_tDBOutput_1.setInt(13, out1.NET_QUANTITY);

                    pstmtInsert_tDBOutput_1.setDouble(14, out1.DENSITY);

                    pstmtInsert_tDBOutput_1.setInt(15, out1.CUSTOMER_NET_QUANTITY);

                    pstmtInsert_tDBOutput_1.setDouble(16, out1.TEMPERATURE);

                    pstmtInsert_tDBOutput_1.setInt(17, out1.START_GROSS_TOTALIZER);

                    pstmtInsert_tDBOutput_1.setInt(18, out1.END_GROSS_TOTALIZER);

                    pstmtInsert_tDBOutput_1.setInt(19, out1.START_NET_TOTALIZER);

                    pstmtInsert_tDBOutput_1.setInt(20, out1.END_NET_TOTALIZER);

                    pstmtInsert_tDBOutput_1.setDouble(21, out1.OBSERVED_DENSITY);

                    pstmtInsert_tDBOutput_1.setInt(22, out1.NON_RECIPE_GROSS_QUANTITY);

                    pstmtInsert_tDBOutput_1.setInt(23, out1.NON_RECIPE_NET_QUANTITY);

                    pstmtInsert_tDBOutput_1.setInt(24, out1.NON_RECIPE_WEIGHT);

                    pstmtInsert_tDBOutput_1.setInt(25, out1.WEIGHT_IN_VAC);

                    pstmtInsert_tDBOutput_1.setInt(26, out1.COMMITTED_GROSS_QUANTITY);

                    pstmtInsert_tDBOutput_1.setInt(27, out1.COMMITTED_NET_QUANTITY);

                    pstmtInsert_tDBOutput_1.setInt(28, out1.COMMITTED_WEIGHT_IN_VAC);

                    pstmtInsert_tDBOutput_1.setInt(29, out1.COMMITTED_WEIGHT_IN_AIR);

                    pstmtInsert_tDBOutput_1.setDouble(30, out1.COMMITTED_CONV_TEMPERATURE);

                    pstmtInsert_tDBOutput_1.setDouble(31, out1.COMMITTED_CONV_DENSITY);

                    pstmtInsert_tDBOutput_1.setInt(32, out1.NON_RECIPE_WEIGHT_IN_VAC);

                    pstmtInsert_tDBOutput_1.setDouble(33, out1.MINIMUM_TEMPERATURE);

                    pstmtInsert_tDBOutput_1.setDouble(34, out1.MAXIMUM_TEMPERATURE);

                    pstmtInsert_tDBOutput_1.setDouble(35, out1.MINIMUM_BASE_DENSITY);

                    pstmtInsert_tDBOutput_1.setDouble(36, out1.MAXIMUM_BASE_DENSITY);

                    pstmtInsert_tDBOutput_1.setDouble(37, out1.MINIMUM_OBSERVED_DENSITY);

                    pstmtInsert_tDBOutput_1.setDouble(38, out1.MAXIMUM_OBSERVED_DENSITY);

                    pstmtInsert_tDBOutput_1.setDouble(39, out1.MINIMUM_COE);

                    pstmtInsert_tDBOutput_1.setDouble(40, out1.MAXIMUM_COE);

                    pstmtInsert_tDBOutput_1.setInt(41, out1.USABLE_CAPACITY);

            try {
                int processedCount_tDBOutput_1 = pstmtInsert_tDBOutput_1.executeUpdate();
                insertedCount_tDBOutput_1 += processedCount_tDBOutput_1;
                rowsToCommitCount_tDBOutput_1 += processedCount_tDBOutput_1;
                nb_line_tDBOutput_1++;
            } catch(java.lang.Exception e) {
globalMap.put("tDBOutput_1_ERROR_MESSAGE",e.getMessage());
				whetherReject_tDBOutput_1 = true;
            	nb_line_tDBOutput_1++;
            	
                            System.err.print(e.getMessage());
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



	
		} // close loop of lookup 'row2' // G_TM_M_043
	
	
	/**
	 * [tMap_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_1";

	

 



/**
 * [tMap_1 process_data_end ] stop
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
	 * [tMap_1 end ] start
	 */

	

	
	
	currentComponent="tMap_1";

	


// ###############################
// # Lookup hashes releasing
					if(tHash_Lookup_row2 != null) {
						tHash_Lookup_row2.endGet();
					}
					globalMap.remove( "tHash_Lookup_row2" );

					
					
				
					if(tHash_Lookup_row3 != null) {
						tHash_Lookup_row3.endGet();
					}
					globalMap.remove( "tHash_Lookup_row3" );

					
					
				
					if(tHash_Lookup_row4 != null) {
						tHash_Lookup_row4.endGet();
					}
					globalMap.remove( "tHash_Lookup_row4" );

					
					
				
					if(tHash_Lookup_row5 != null) {
						tHash_Lookup_row5.endGet();
					}
					globalMap.remove( "tHash_Lookup_row5" );

					
					
				
					if(tHash_Lookup_row6 != null) {
						tHash_Lookup_row6.endGet();
					}
					globalMap.remove( "tHash_Lookup_row6" );

					
					
				
					if(tHash_Lookup_row10 != null) {
						tHash_Lookup_row10.endGet();
					}
					globalMap.remove( "tHash_Lookup_row10" );

					
					
				
					if(tHash_Lookup_row11 != null) {
						tHash_Lookup_row11.endGet();
					}
					globalMap.remove( "tHash_Lookup_row11" );

					
					
				
					if(tHash_Lookup_row7 != null) {
						tHash_Lookup_row7.endGet();
					}
					globalMap.remove( "tHash_Lookup_row7" );

					
					
				
					if(tHash_Lookup_row8 != null) {
						tHash_Lookup_row8.endGet();
					}
					globalMap.remove( "tHash_Lookup_row8" );

					
					
				
					if(tHash_Lookup_row9 != null) {
						tHash_Lookup_row9.endGet();
					}
					globalMap.remove( "tHash_Lookup_row9" );

					
					
				
// ###############################      





				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row1");
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
					     			globalMap.remove("tHash_Lookup_row2"); 
				     			
					     			//free memory for "tMap_1"
					     			globalMap.remove("tHash_Lookup_row3"); 
				     			
					     			//free memory for "tMap_1"
					     			globalMap.remove("tHash_Lookup_row4"); 
				     			
					     			//free memory for "tMap_1"
					     			globalMap.remove("tHash_Lookup_row5"); 
				     			
					     			//free memory for "tMap_1"
					     			globalMap.remove("tHash_Lookup_row6"); 
				     			
					     			//free memory for "tMap_1"
					     			globalMap.remove("tHash_Lookup_row10"); 
				     			
					     			//free memory for "tMap_1"
					     			globalMap.remove("tHash_Lookup_row11"); 
				     			
					     			//free memory for "tMap_1"
					     			globalMap.remove("tHash_Lookup_row7"); 
				     			
					     			//free memory for "tMap_1"
					     			globalMap.remove("tHash_Lookup_row8"); 
				     			
					     			//free memory for "tMap_1"
					     			globalMap.remove("tHash_Lookup_row9"); 
				     			
				try{
					
	
	/**
	 * [tDBInput_1 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_1";

	

 



/**
 * [tDBInput_1 finally ] stop
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
	


public static class row2Struct implements routines.system.IPersistableComparableLookupRow<row2Struct> {
    final static byte[] commonByteArrayLock_PGS_STAGE_FACT_SALES_SAM = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_FACT_SALES_SAM = new byte[0];
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
		final row2Struct other = (row2Struct) obj;
		
						if (this.ORDER_ID != other.ORDER_ID)
							return false;
					

		return true;
    }

	public void copyDataTo(row2Struct other) {

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

	public void copyKeysDataTo(row2Struct other) {

		other.ORDER_ID = this.ORDER_ID;
	            	
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

		synchronized(commonByteArrayLock_PGS_STAGE_FACT_SALES_SAM) {

        	try {

        		int length = 0;
		
			        this.ORDER_ID = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_FACT_SALES_SAM) {

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
		
			            this.PK_ORDER_RECIPE = dis.readInt();
					
			            this.COMPARTMENT_ID = dis.readInt();
					
			            this.ORDER_RECIPE_ID = dis.readInt();
					
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
					
			            this.ORDER_RECIPE_ID = objectIn.readInt();
					
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
					
		            	dos.writeInt(this.ORDER_RECIPE_ID);
					
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
					
					objectOut.writeInt(this.ORDER_RECIPE_ID);
					
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
    public int compareTo(row2Struct other) {

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



		row2Struct row2 = new row2Struct();




	
	/**
	 * [tAdvancedHash_row2 begin ] start
	 */

	

	
		
		ok_Hash.put("tAdvancedHash_row2", false);
		start_Hash.put("tAdvancedHash_row2", System.currentTimeMillis());
		
	
	currentComponent="tAdvancedHash_row2";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row2");
					}
				
		int tos_count_tAdvancedHash_row2 = 0;
		

			   		// connection name:row2
			   		// source node:tDBInput_2 - inputs:(after_tDBInput_1) outputs:(row2,row2) | target node:tAdvancedHash_row2 - inputs:(row2) outputs:()
			   		// linked node: tMap_1 - inputs:(row1,row2,row3,row4,row5,row6,row10,row11,row7,row8,row9) outputs:(out1)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row2 = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.ALL_MATCHES;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct> tHash_Lookup_row2 =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<row2Struct>getLookup(matchingModeEnum_row2);
	   						   
		   	   	   globalMap.put("tHash_Lookup_row2", tHash_Lookup_row2);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_row2 begin ] stop
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
				
				 
	final String decryptedPassword_tDBInput_2 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:lfMXkfMXFok0SITsBmm46uJsR+bEjbJe2//yjyb7EXRh5ZN4ENI=");
				
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
								row2.PK_ORDER_RECIPE = 0;
							} else {
		                          
            row2.PK_ORDER_RECIPE = rs_tDBInput_2.getInt(1);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 2) {
								row2.ORDER_ID = 0;
							} else {
		                          
            row2.ORDER_ID = rs_tDBInput_2.getInt(2);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 3) {
								row2.COMPARTMENT_ID = 0;
							} else {
		                          
            row2.COMPARTMENT_ID = rs_tDBInput_2.getInt(3);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 4) {
								row2.ORDER_RECIPE_ID = 0;
							} else {
		                          
            row2.ORDER_RECIPE_ID = rs_tDBInput_2.getInt(4);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 5) {
								row2.BAY_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(5);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(5).toUpperCase(java.util.Locale.ENGLISH))) {
            		row2.BAY_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row2.BAY_CODE = tmpContent_tDBInput_2;
                }
            } else {
                row2.BAY_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 6) {
								row2.API_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(6);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(6).toUpperCase(java.util.Locale.ENGLISH))) {
            		row2.API_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row2.API_CODE = tmpContent_tDBInput_2;
                }
            } else {
                row2.API_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 7) {
								row2.TANK_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(7);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(7).toUpperCase(java.util.Locale.ENGLISH))) {
            		row2.TANK_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row2.TANK_CODE = tmpContent_tDBInput_2;
                }
            } else {
                row2.TANK_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 8) {
								row2.PRODUCT_GROUP_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(8);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(8).toUpperCase(java.util.Locale.ENGLISH))) {
            		row2.PRODUCT_GROUP_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row2.PRODUCT_GROUP_CODE = tmpContent_tDBInput_2;
                }
            } else {
                row2.PRODUCT_GROUP_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 9) {
								row2.METER_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(9);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(9).toUpperCase(java.util.Locale.ENGLISH))) {
            		row2.METER_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row2.METER_CODE = tmpContent_tDBInput_2;
                }
            } else {
                row2.METER_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 10) {
								row2.SUPPLIER_NUMBER = null;
							} else {
		                          
            row2.SUPPLIER_NUMBER = rs_tDBInput_2.getInt(10);
            if(rs_tDBInput_2.wasNull()){
                    row2.SUPPLIER_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 11) {
								row2.TERMINAL_PRODUCT_NUMBER = 0;
							} else {
		                          
            row2.TERMINAL_PRODUCT_NUMBER = rs_tDBInput_2.getInt(11);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 12) {
								row2.START_TIME = null;
							} else {
										
			row2.START_TIME = mssqlGTU_tDBInput_2.getDate(rsmd_tDBInput_2, rs_tDBInput_2, 12);
			
		                    }
							if(colQtyInRs_tDBInput_2 < 13) {
								row2.END_TIME = null;
							} else {
										
			row2.END_TIME = mssqlGTU_tDBInput_2.getDate(rsmd_tDBInput_2, rs_tDBInput_2, 13);
			
		                    }
							if(colQtyInRs_tDBInput_2 < 14) {
								row2.COMPONENT_ID = 0;
							} else {
		                          
            row2.COMPONENT_ID = rs_tDBInput_2.getInt(14);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 15) {
								row2.PRODUCT_TOLERANCE_STATUS = 0;
							} else {
		                          
            row2.PRODUCT_TOLERANCE_STATUS = rs_tDBInput_2.getInt(15);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 16) {
								row2.TOTALIZER_UPDATED = 0;
							} else {
		                          
            row2.TOTALIZER_UPDATED = rs_tDBInput_2.getInt(16);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 17) {
								row2.BATCH_NUMBER = 0;
							} else {
		                          
            row2.BATCH_NUMBER = rs_tDBInput_2.getInt(17);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 18) {
								row2.RECIPE_CORRECTION_TYPE = 0;
							} else {
		                          
            row2.RECIPE_CORRECTION_TYPE = rs_tDBInput_2.getInt(18);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 19) {
								row2.INVENTORY_QUANTITY_TYPE = 0;
							} else {
		                          
            row2.INVENTORY_QUANTITY_TYPE = rs_tDBInput_2.getInt(19);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 20) {
								row2.DERIVED_VALUES_DIRECTIVE = 0;
							} else {
		                          
            row2.DERIVED_VALUES_DIRECTIVE = rs_tDBInput_2.getInt(20);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 21) {
								row2.METER_PRESET_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(21);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(21).toUpperCase(java.util.Locale.ENGLISH))) {
            		row2.METER_PRESET_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row2.METER_PRESET_CODE = tmpContent_tDBInput_2;
                }
            } else {
                row2.METER_PRESET_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 22) {
								row2.CALCULATE_NET = 0;
							} else {
		                          
            row2.CALCULATE_NET = rs_tDBInput_2.getInt(22);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 23) {
								row2.COMPARTMENT_OWNER_ID = null;
							} else {
		                          
            row2.COMPARTMENT_OWNER_ID = rs_tDBInput_2.getInt(23);
            if(rs_tDBInput_2.wasNull()){
                    row2.COMPARTMENT_OWNER_ID = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 24) {
								row2.COMPARTMENT_CONTAINER_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(24);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(24).toUpperCase(java.util.Locale.ENGLISH))) {
            		row2.COMPARTMENT_CONTAINER_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row2.COMPARTMENT_CONTAINER_CODE = tmpContent_tDBInput_2;
                }
            } else {
                row2.COMPARTMENT_CONTAINER_CODE = null;
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
	 * [tAdvancedHash_row2 main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row2";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row2"
						
						);
					}
					


			   
			   

					row2Struct row2_HashRow = new row2Struct();
		   	   	   
				
				row2_HashRow.PK_ORDER_RECIPE = row2.PK_ORDER_RECIPE;
				
				row2_HashRow.ORDER_ID = row2.ORDER_ID;
				
				row2_HashRow.COMPARTMENT_ID = row2.COMPARTMENT_ID;
				
				row2_HashRow.ORDER_RECIPE_ID = row2.ORDER_RECIPE_ID;
				
				row2_HashRow.BAY_CODE = row2.BAY_CODE;
				
				row2_HashRow.API_CODE = row2.API_CODE;
				
				row2_HashRow.TANK_CODE = row2.TANK_CODE;
				
				row2_HashRow.PRODUCT_GROUP_CODE = row2.PRODUCT_GROUP_CODE;
				
				row2_HashRow.METER_CODE = row2.METER_CODE;
				
				row2_HashRow.SUPPLIER_NUMBER = row2.SUPPLIER_NUMBER;
				
				row2_HashRow.TERMINAL_PRODUCT_NUMBER = row2.TERMINAL_PRODUCT_NUMBER;
				
				row2_HashRow.START_TIME = row2.START_TIME;
				
				row2_HashRow.END_TIME = row2.END_TIME;
				
				row2_HashRow.COMPONENT_ID = row2.COMPONENT_ID;
				
				row2_HashRow.PRODUCT_TOLERANCE_STATUS = row2.PRODUCT_TOLERANCE_STATUS;
				
				row2_HashRow.TOTALIZER_UPDATED = row2.TOTALIZER_UPDATED;
				
				row2_HashRow.BATCH_NUMBER = row2.BATCH_NUMBER;
				
				row2_HashRow.RECIPE_CORRECTION_TYPE = row2.RECIPE_CORRECTION_TYPE;
				
				row2_HashRow.INVENTORY_QUANTITY_TYPE = row2.INVENTORY_QUANTITY_TYPE;
				
				row2_HashRow.DERIVED_VALUES_DIRECTIVE = row2.DERIVED_VALUES_DIRECTIVE;
				
				row2_HashRow.METER_PRESET_CODE = row2.METER_PRESET_CODE;
				
				row2_HashRow.CALCULATE_NET = row2.CALCULATE_NET;
				
				row2_HashRow.COMPARTMENT_OWNER_ID = row2.COMPARTMENT_OWNER_ID;
				
				row2_HashRow.COMPARTMENT_CONTAINER_CODE = row2.COMPARTMENT_CONTAINER_CODE;
				
			tHash_Lookup_row2.put(row2_HashRow);
			
            




 


	tos_count_tAdvancedHash_row2++;

/**
 * [tAdvancedHash_row2 main ] stop
 */
	
	/**
	 * [tAdvancedHash_row2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row2";

	

 



/**
 * [tAdvancedHash_row2 process_data_begin ] stop
 */
	
	/**
	 * [tAdvancedHash_row2 process_data_end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row2";

	

 



/**
 * [tAdvancedHash_row2 process_data_end ] stop
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
	 * [tAdvancedHash_row2 end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row2";

	

tHash_Lookup_row2.endPut();

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row2");
			  	}
			  	
 

ok_Hash.put("tAdvancedHash_row2", true);
end_Hash.put("tAdvancedHash_row2", System.currentTimeMillis());




/**
 * [tAdvancedHash_row2 end ] stop
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
	 * [tAdvancedHash_row2 finally ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row2";

	

 



/**
 * [tAdvancedHash_row2 finally ] stop
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
	


public static class row3Struct implements routines.system.IPersistableComparableLookupRow<row3Struct> {
    final static byte[] commonByteArrayLock_PGS_STAGE_FACT_SALES_SAM = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_FACT_SALES_SAM = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
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
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
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
		
						if (this.ORDER_RECIPE_ID != other.ORDER_RECIPE_ID)
							return false;
					

		return true;
    }

	public void copyDataTo(row3Struct other) {

		other.ORDER_ID = this.ORDER_ID;
	            other.COMPARTMENT_ID = this.COMPARTMENT_ID;
	            other.ORDER_RECIPE_ID = this.ORDER_RECIPE_ID;
	            other.BAY_CODE = this.BAY_CODE;
	            other.API_CODE = this.API_CODE;
	            other.INJECTOR_PRESET_CODE = this.INJECTOR_PRESET_CODE;
	            other.TARE_SCALE_INTERFACE_CODE = this.TARE_SCALE_INTERFACE_CODE;
	            other.TANK_CODE = this.TANK_CODE;
	            other.PRODUCT_GROUP_CODE = this.PRODUCT_GROUP_CODE;
	            other.INJECTOR_CODE = this.INJECTOR_CODE;
	            other.METER_CODE = this.METER_CODE;
	            other.SUPPLIER_NUMBER = this.SUPPLIER_NUMBER;
	            other.TERMINAL_PRODUCT_NUMBER = this.TERMINAL_PRODUCT_NUMBER;
	            other.TERMINAL_PRODUCT_TYPE = this.TERMINAL_PRODUCT_TYPE;
	            other.SHOST_SI_HOST_PRODUCT_NUMBER = this.SHOST_SI_HOST_PRODUCT_NUMBER;
	            other.BLEND_PERCENT = this.BLEND_PERCENT;
	            other.RATE = this.RATE;
	            other.THOST_TI_HOST_PRODUCT_NUMBER = this.THOST_TI_HOST_PRODUCT_NUMBER;
	            other.ORDERED_QUANTITY = this.ORDERED_QUANTITY;
	            other.OVERRIDE_TEMPERATURE_ENABLE = this.OVERRIDE_TEMPERATURE_ENABLE;
	            other.GROSS_QUANTITY = this.GROSS_QUANTITY;
	            other.WEIGHT = this.WEIGHT;
	            other.NET_QUANTITY = this.NET_QUANTITY;
	            other.DENSITY = this.DENSITY;
	            other.CUSTOMER_NET_QUANTITY = this.CUSTOMER_NET_QUANTITY;
	            other.SPECIFIC_GRAVITY = this.SPECIFIC_GRAVITY;
	            other.COEFFICIENT_EXPANSION = this.COEFFICIENT_EXPANSION;
	            other.TEMPERATURE = this.TEMPERATURE;
	            other.RVP = this.RVP;
	            other.OXYGEN = this.OXYGEN;
	            other.START_GROSS_TOTALIZER = this.START_GROSS_TOTALIZER;
	            other.END_GROSS_TOTALIZER = this.END_GROSS_TOTALIZER;
	            other.START_NET_TOTALIZER = this.START_NET_TOTALIZER;
	            other.END_NET_TOTALIZER = this.END_NET_TOTALIZER;
	            other.START_WEIGHT = this.START_WEIGHT;
	            other.END_WEIGHT = this.END_WEIGHT;
	            other.LAST_USER_NAME = this.LAST_USER_NAME;
	            other.LAST_MODIFIED = this.LAST_MODIFIED;
	            other.START_TIME = this.START_TIME;
	            other.END_TIME = this.END_TIME;
	            other.ADDITIVE_QUANTITY = this.ADDITIVE_QUANTITY;
	            other.PRODUCT_QUANTITY = this.PRODUCT_QUANTITY;
	            other.HOST_PRODUCT_CODE = this.HOST_PRODUCT_CODE;
	            other.HOST_PRODUCT_NAME = this.HOST_PRODUCT_NAME;
	            other.FROM_LEFT_ON_TRUCK = this.FROM_LEFT_ON_TRUCK;
	            other.OBSERVED_DENSITY = this.OBSERVED_DENSITY;
	            other.COMPONENT_ID = this.COMPONENT_ID;
	            other.CALCULATE_SECONDARY_UNITS = this.CALCULATE_SECONDARY_UNITS;
	            other.FINAL_SCALE_INTERFACE_CODE = this.FINAL_SCALE_INTERFACE_CODE;
	            other.FRAC_START_GROSS_TOTALIZER = this.FRAC_START_GROSS_TOTALIZER;
	            other.FRAC_END_GROSS_TOTALIZER = this.FRAC_END_GROSS_TOTALIZER;
	            other.PETROEX_COMPONENT_PRODUCT_CODE = this.PETROEX_COMPONENT_PRODUCT_CODE;
	            other.PRODUCT_TOLERANCE_STATUS = this.PRODUCT_TOLERANCE_STATUS;
	            other.TANK_INVENTORY_UPDATED = this.TANK_INVENTORY_UPDATED;
	            other.TOTALIZER_UPDATED = this.TOTALIZER_UPDATED;
	            other.FLUSH_STATUS = this.FLUSH_STATUS;
	            other.REDUCED_PRODUCT_NUMBER = this.REDUCED_PRODUCT_NUMBER;
	            other.ADDITIVE_WEIGHT = this.ADDITIVE_WEIGHT;
	            other.PRODUCT_WEIGHT = this.PRODUCT_WEIGHT;
	            other.RT_INJECTOR_ALARM_COUNT = this.RT_INJECTOR_ALARM_COUNT;
	            other.BATCH_NUMBER = this.BATCH_NUMBER;
	            other.VRU_CODE = this.VRU_CODE;
	            other.ADDITIVE_MASKING = this.ADDITIVE_MASKING;
	            other.COMPATIBILITY_STATUS = this.COMPATIBILITY_STATUS;
	            other.RECIPE_CORRECTION_TYPE = this.RECIPE_CORRECTION_TYPE;
	            other.NON_RECIPE_GROSS_QUANTITY = this.NON_RECIPE_GROSS_QUANTITY;
	            other.NON_RECIPE_NET_QUANTITY = this.NON_RECIPE_NET_QUANTITY;
	            other.NON_RECIPE_WEIGHT = this.NON_RECIPE_WEIGHT;
	            other.WEIGHT_IN_VAC = this.WEIGHT_IN_VAC;
	            other.ADDITIVE_WEIGHT_IN_VAC = this.ADDITIVE_WEIGHT_IN_VAC;
	            other.COMMITTED_GROSS_QUANTITY = this.COMMITTED_GROSS_QUANTITY;
	            other.PRODUCT_WEIGHT_IN_VAC = this.PRODUCT_WEIGHT_IN_VAC;
	            other.COMMITTED_NET_QUANTITY = this.COMMITTED_NET_QUANTITY;
	            other.PDXR_PRODUCT_CODE = this.PDXR_PRODUCT_CODE;
	            other.PDXR_AUTHORIZATION_UNITS = this.PDXR_AUTHORIZATION_UNITS;
	            other.COMMITTED_WEIGHT_IN_VAC = this.COMMITTED_WEIGHT_IN_VAC;
	            other.COMMITTED_WEIGHT_IN_AIR = this.COMMITTED_WEIGHT_IN_AIR;
	            other.PDXR_ADDITIVE_CODE = this.PDXR_ADDITIVE_CODE;
	            other.COMMITTED_CONV_TEMPERATURE = this.COMMITTED_CONV_TEMPERATURE;
	            other.COMMITTED_CONV_DENSITY = this.COMMITTED_CONV_DENSITY;
	            other.COMMITTED_CONV_COE = this.COMMITTED_CONV_COE;
	            other.COMMITTED_CONV_PRESSURE = this.COMMITTED_CONV_PRESSURE;
	            other.MEASURED_QUANTITY_TYPE = this.MEASURED_QUANTITY_TYPE;
	            other.INVENTORY_QUANTITY_TYPE = this.INVENTORY_QUANTITY_TYPE;
	            other.DERIVED_VALUES_DIRECTIVE = this.DERIVED_VALUES_DIRECTIVE;
	            other.PRESSURE = this.PRESSURE;
	            other.METER_PRESET_CODE = this.METER_PRESET_CODE;
	            other.CALCULATE_NET = this.CALCULATE_NET;
	            other.NON_RECIPE_WEIGHT_IN_VAC = this.NON_RECIPE_WEIGHT_IN_VAC;
	            other.ADJUSTMENT_BATCH = this.ADJUSTMENT_BATCH;
	            other.COMPARTMENT_OWNER_ID = this.COMPARTMENT_OWNER_ID;
	            other.COMPARTMENT_CONTAINER_CODE = this.COMPARTMENT_CONTAINER_CODE;
	            other.COMPARTMENT_CONTAINER_TYPE = this.COMPARTMENT_CONTAINER_TYPE;
	            other.COMPARTMENT_NUMBER = this.COMPARTMENT_NUMBER;
	            other.PDXR_LOADING_REF = this.PDXR_LOADING_REF;
	            other.BLEND_CORRECTION_METHOD = this.BLEND_CORRECTION_METHOD;
	            other.BLEND_CORRECTION_NET_VOLUME = this.BLEND_CORRECTION_NET_VOLUME;
	            other.TOTAL_BATCH_BLEND_NET_VOLUME = this.TOTAL_BATCH_BLEND_NET_VOLUME;
	            other.BLEND_CORRECTION_SOURCE = this.BLEND_CORRECTION_SOURCE;
	            other.COMMODITY_GROUP = this.COMMODITY_GROUP;
	            other.DERIVATION_STATUS = this.DERIVATION_STATUS;
	            other.DERIVED_VALUES_ERROR = this.DERIVED_VALUES_ERROR;
	            
	}

	public void copyKeysDataTo(row3Struct other) {

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

		synchronized(commonByteArrayLock_PGS_STAGE_FACT_SALES_SAM) {

        	try {

        		int length = 0;
		
			        this.ORDER_RECIPE_ID = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_FACT_SALES_SAM) {

        	try {

        		int length = 0;
		
			        this.ORDER_RECIPE_ID = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.ORDER_RECIPE_ID);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
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
		
			            this.ORDER_ID = dis.readInt();
					
			            this.COMPARTMENT_ID = dis.readInt();
					
						this.BAY_CODE = readString(dis,ois);
					
						this.API_CODE = readString(dis,ois);
					
						this.INJECTOR_PRESET_CODE = readString(dis,ois);
					
						this.TARE_SCALE_INTERFACE_CODE = readString(dis,ois);
					
						this.TANK_CODE = readString(dis,ois);
					
						this.PRODUCT_GROUP_CODE = readString(dis,ois);
					
						this.INJECTOR_CODE = readString(dis,ois);
					
						this.METER_CODE = readString(dis,ois);
					
						this.SUPPLIER_NUMBER = readInteger(dis,ois);
					
			            this.TERMINAL_PRODUCT_NUMBER = dis.readInt();
					
			            this.TERMINAL_PRODUCT_TYPE = dis.readInt();
					
						this.SHOST_SI_HOST_PRODUCT_NUMBER = readString(dis,ois);
					
			            this.BLEND_PERCENT = dis.readDouble();
					
			            this.RATE = dis.readInt();
					
						this.THOST_TI_HOST_PRODUCT_NUMBER = readString(dis,ois);
					
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
					
						this.LAST_USER_NAME = readString(dis,ois);
					
						this.LAST_MODIFIED = readDate(dis,ois);
					
						this.START_TIME = readDate(dis,ois);
					
						this.END_TIME = readDate(dis,ois);
					
			            this.ADDITIVE_QUANTITY = dis.readInt();
					
			            this.PRODUCT_QUANTITY = dis.readInt();
					
						this.HOST_PRODUCT_CODE = readString(dis,ois);
					
						this.HOST_PRODUCT_NAME = readString(dis,ois);
					
			            this.FROM_LEFT_ON_TRUCK = dis.readInt();
					
			            this.OBSERVED_DENSITY = dis.readDouble();
					
			            this.COMPONENT_ID = dis.readInt();
					
			            this.CALCULATE_SECONDARY_UNITS = dis.readInt();
					
						this.FINAL_SCALE_INTERFACE_CODE = readString(dis,ois);
					
			            this.FRAC_START_GROSS_TOTALIZER = dis.readInt();
					
			            this.FRAC_END_GROSS_TOTALIZER = dis.readInt();
					
						this.PETROEX_COMPONENT_PRODUCT_CODE = readString(dis,ois);
					
			            this.PRODUCT_TOLERANCE_STATUS = dis.readInt();
					
			            this.TANK_INVENTORY_UPDATED = dis.readInt();
					
			            this.TOTALIZER_UPDATED = dis.readInt();
					
			            this.FLUSH_STATUS = dis.readInt();
					
						this.REDUCED_PRODUCT_NUMBER = readInteger(dis,ois);
					
			            this.ADDITIVE_WEIGHT = dis.readInt();
					
			            this.PRODUCT_WEIGHT = dis.readInt();
					
			            this.RT_INJECTOR_ALARM_COUNT = dis.readInt();
					
			            this.BATCH_NUMBER = dis.readInt();
					
						this.VRU_CODE = readString(dis,ois);
					
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
					
						this.PDXR_PRODUCT_CODE = readString(dis,ois);
					
			            this.PDXR_AUTHORIZATION_UNITS = dis.readInt();
					
			            this.COMMITTED_WEIGHT_IN_VAC = dis.readInt();
					
			            this.COMMITTED_WEIGHT_IN_AIR = dis.readInt();
					
						this.PDXR_ADDITIVE_CODE = readString(dis,ois);
					
			            this.COMMITTED_CONV_TEMPERATURE = dis.readDouble();
					
			            this.COMMITTED_CONV_DENSITY = dis.readDouble();
					
			            this.COMMITTED_CONV_COE = dis.readDouble();
					
			            this.COMMITTED_CONV_PRESSURE = dis.readDouble();
					
			            this.MEASURED_QUANTITY_TYPE = dis.readInt();
					
			            this.INVENTORY_QUANTITY_TYPE = dis.readInt();
					
			            this.DERIVED_VALUES_DIRECTIVE = dis.readInt();
					
			            this.PRESSURE = dis.readDouble();
					
						this.METER_PRESET_CODE = readString(dis,ois);
					
			            this.CALCULATE_NET = dis.readInt();
					
			            this.NON_RECIPE_WEIGHT_IN_VAC = dis.readInt();
					
			            this.ADJUSTMENT_BATCH = dis.readInt();
					
						this.COMPARTMENT_OWNER_ID = readInteger(dis,ois);
					
						this.COMPARTMENT_CONTAINER_CODE = readString(dis,ois);
					
						this.COMPARTMENT_CONTAINER_TYPE = readInteger(dis,ois);
					
						this.COMPARTMENT_NUMBER = readInteger(dis,ois);
					
						this.PDXR_LOADING_REF = readString(dis,ois);
					
			            this.BLEND_CORRECTION_METHOD = dis.readInt();
					
			            this.BLEND_CORRECTION_NET_VOLUME = dis.readDouble();
					
			            this.TOTAL_BATCH_BLEND_NET_VOLUME = dis.readDouble();
					
			            this.BLEND_CORRECTION_SOURCE = dis.readInt();
					
			            this.COMMODITY_GROUP = dis.readInt();
					
			            this.DERIVATION_STATUS = dis.readInt();
					
						this.DERIVED_VALUES_ERROR = readString(dis,ois);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
			            this.ORDER_ID = objectIn.readInt();
					
			            this.COMPARTMENT_ID = objectIn.readInt();
					
						this.BAY_CODE = readString(dis,objectIn);
					
						this.API_CODE = readString(dis,objectIn);
					
						this.INJECTOR_PRESET_CODE = readString(dis,objectIn);
					
						this.TARE_SCALE_INTERFACE_CODE = readString(dis,objectIn);
					
						this.TANK_CODE = readString(dis,objectIn);
					
						this.PRODUCT_GROUP_CODE = readString(dis,objectIn);
					
						this.INJECTOR_CODE = readString(dis,objectIn);
					
						this.METER_CODE = readString(dis,objectIn);
					
						this.SUPPLIER_NUMBER = readInteger(dis,objectIn);
					
			            this.TERMINAL_PRODUCT_NUMBER = objectIn.readInt();
					
			            this.TERMINAL_PRODUCT_TYPE = objectIn.readInt();
					
						this.SHOST_SI_HOST_PRODUCT_NUMBER = readString(dis,objectIn);
					
			            this.BLEND_PERCENT = objectIn.readDouble();
					
			            this.RATE = objectIn.readInt();
					
						this.THOST_TI_HOST_PRODUCT_NUMBER = readString(dis,objectIn);
					
			            this.ORDERED_QUANTITY = objectIn.readInt();
					
			            this.OVERRIDE_TEMPERATURE_ENABLE = objectIn.readInt();
					
			            this.GROSS_QUANTITY = objectIn.readInt();
					
			            this.WEIGHT = objectIn.readInt();
					
			            this.NET_QUANTITY = objectIn.readInt();
					
			            this.DENSITY = objectIn.readDouble();
					
			            this.CUSTOMER_NET_QUANTITY = objectIn.readInt();
					
			            this.SPECIFIC_GRAVITY = objectIn.readDouble();
					
			            this.COEFFICIENT_EXPANSION = objectIn.readDouble();
					
			            this.TEMPERATURE = objectIn.readDouble();
					
			            this.RVP = objectIn.readDouble();
					
			            this.OXYGEN = objectIn.readDouble();
					
			            this.START_GROSS_TOTALIZER = objectIn.readInt();
					
			            this.END_GROSS_TOTALIZER = objectIn.readInt();
					
			            this.START_NET_TOTALIZER = objectIn.readInt();
					
			            this.END_NET_TOTALIZER = objectIn.readInt();
					
			            this.START_WEIGHT = objectIn.readInt();
					
			            this.END_WEIGHT = objectIn.readInt();
					
						this.LAST_USER_NAME = readString(dis,objectIn);
					
						this.LAST_MODIFIED = readDate(dis,objectIn);
					
						this.START_TIME = readDate(dis,objectIn);
					
						this.END_TIME = readDate(dis,objectIn);
					
			            this.ADDITIVE_QUANTITY = objectIn.readInt();
					
			            this.PRODUCT_QUANTITY = objectIn.readInt();
					
						this.HOST_PRODUCT_CODE = readString(dis,objectIn);
					
						this.HOST_PRODUCT_NAME = readString(dis,objectIn);
					
			            this.FROM_LEFT_ON_TRUCK = objectIn.readInt();
					
			            this.OBSERVED_DENSITY = objectIn.readDouble();
					
			            this.COMPONENT_ID = objectIn.readInt();
					
			            this.CALCULATE_SECONDARY_UNITS = objectIn.readInt();
					
						this.FINAL_SCALE_INTERFACE_CODE = readString(dis,objectIn);
					
			            this.FRAC_START_GROSS_TOTALIZER = objectIn.readInt();
					
			            this.FRAC_END_GROSS_TOTALIZER = objectIn.readInt();
					
						this.PETROEX_COMPONENT_PRODUCT_CODE = readString(dis,objectIn);
					
			            this.PRODUCT_TOLERANCE_STATUS = objectIn.readInt();
					
			            this.TANK_INVENTORY_UPDATED = objectIn.readInt();
					
			            this.TOTALIZER_UPDATED = objectIn.readInt();
					
			            this.FLUSH_STATUS = objectIn.readInt();
					
						this.REDUCED_PRODUCT_NUMBER = readInteger(dis,objectIn);
					
			            this.ADDITIVE_WEIGHT = objectIn.readInt();
					
			            this.PRODUCT_WEIGHT = objectIn.readInt();
					
			            this.RT_INJECTOR_ALARM_COUNT = objectIn.readInt();
					
			            this.BATCH_NUMBER = objectIn.readInt();
					
						this.VRU_CODE = readString(dis,objectIn);
					
			            this.ADDITIVE_MASKING = objectIn.readInt();
					
			            this.COMPATIBILITY_STATUS = objectIn.readInt();
					
			            this.RECIPE_CORRECTION_TYPE = objectIn.readInt();
					
			            this.NON_RECIPE_GROSS_QUANTITY = objectIn.readInt();
					
			            this.NON_RECIPE_NET_QUANTITY = objectIn.readInt();
					
			            this.NON_RECIPE_WEIGHT = objectIn.readInt();
					
			            this.WEIGHT_IN_VAC = objectIn.readInt();
					
			            this.ADDITIVE_WEIGHT_IN_VAC = objectIn.readInt();
					
			            this.COMMITTED_GROSS_QUANTITY = objectIn.readInt();
					
			            this.PRODUCT_WEIGHT_IN_VAC = objectIn.readInt();
					
			            this.COMMITTED_NET_QUANTITY = objectIn.readInt();
					
						this.PDXR_PRODUCT_CODE = readString(dis,objectIn);
					
			            this.PDXR_AUTHORIZATION_UNITS = objectIn.readInt();
					
			            this.COMMITTED_WEIGHT_IN_VAC = objectIn.readInt();
					
			            this.COMMITTED_WEIGHT_IN_AIR = objectIn.readInt();
					
						this.PDXR_ADDITIVE_CODE = readString(dis,objectIn);
					
			            this.COMMITTED_CONV_TEMPERATURE = objectIn.readDouble();
					
			            this.COMMITTED_CONV_DENSITY = objectIn.readDouble();
					
			            this.COMMITTED_CONV_COE = objectIn.readDouble();
					
			            this.COMMITTED_CONV_PRESSURE = objectIn.readDouble();
					
			            this.MEASURED_QUANTITY_TYPE = objectIn.readInt();
					
			            this.INVENTORY_QUANTITY_TYPE = objectIn.readInt();
					
			            this.DERIVED_VALUES_DIRECTIVE = objectIn.readInt();
					
			            this.PRESSURE = objectIn.readDouble();
					
						this.METER_PRESET_CODE = readString(dis,objectIn);
					
			            this.CALCULATE_NET = objectIn.readInt();
					
			            this.NON_RECIPE_WEIGHT_IN_VAC = objectIn.readInt();
					
			            this.ADJUSTMENT_BATCH = objectIn.readInt();
					
						this.COMPARTMENT_OWNER_ID = readInteger(dis,objectIn);
					
						this.COMPARTMENT_CONTAINER_CODE = readString(dis,objectIn);
					
						this.COMPARTMENT_CONTAINER_TYPE = readInteger(dis,objectIn);
					
						this.COMPARTMENT_NUMBER = readInteger(dis,objectIn);
					
						this.PDXR_LOADING_REF = readString(dis,objectIn);
					
			            this.BLEND_CORRECTION_METHOD = objectIn.readInt();
					
			            this.BLEND_CORRECTION_NET_VOLUME = objectIn.readDouble();
					
			            this.TOTAL_BATCH_BLEND_NET_VOLUME = objectIn.readDouble();
					
			            this.BLEND_CORRECTION_SOURCE = objectIn.readInt();
					
			            this.COMMODITY_GROUP = objectIn.readInt();
					
			            this.DERIVATION_STATUS = objectIn.readInt();
					
						this.DERIVED_VALUES_ERROR = readString(dis,objectIn);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
		            	dos.writeInt(this.ORDER_ID);
					
		            	dos.writeInt(this.COMPARTMENT_ID);
					
						writeString(this.BAY_CODE, dos, oos);
					
						writeString(this.API_CODE, dos, oos);
					
						writeString(this.INJECTOR_PRESET_CODE, dos, oos);
					
						writeString(this.TARE_SCALE_INTERFACE_CODE, dos, oos);
					
						writeString(this.TANK_CODE, dos, oos);
					
						writeString(this.PRODUCT_GROUP_CODE, dos, oos);
					
						writeString(this.INJECTOR_CODE, dos, oos);
					
						writeString(this.METER_CODE, dos, oos);
					
					writeInteger(this.SUPPLIER_NUMBER, dos, oos);
					
		            	dos.writeInt(this.TERMINAL_PRODUCT_NUMBER);
					
		            	dos.writeInt(this.TERMINAL_PRODUCT_TYPE);
					
						writeString(this.SHOST_SI_HOST_PRODUCT_NUMBER, dos, oos);
					
		            	dos.writeDouble(this.BLEND_PERCENT);
					
		            	dos.writeInt(this.RATE);
					
						writeString(this.THOST_TI_HOST_PRODUCT_NUMBER, dos, oos);
					
		            	dos.writeInt(this.ORDERED_QUANTITY);
					
		            	dos.writeInt(this.OVERRIDE_TEMPERATURE_ENABLE);
					
		            	dos.writeInt(this.GROSS_QUANTITY);
					
		            	dos.writeInt(this.WEIGHT);
					
		            	dos.writeInt(this.NET_QUANTITY);
					
		            	dos.writeDouble(this.DENSITY);
					
		            	dos.writeInt(this.CUSTOMER_NET_QUANTITY);
					
		            	dos.writeDouble(this.SPECIFIC_GRAVITY);
					
		            	dos.writeDouble(this.COEFFICIENT_EXPANSION);
					
		            	dos.writeDouble(this.TEMPERATURE);
					
		            	dos.writeDouble(this.RVP);
					
		            	dos.writeDouble(this.OXYGEN);
					
		            	dos.writeInt(this.START_GROSS_TOTALIZER);
					
		            	dos.writeInt(this.END_GROSS_TOTALIZER);
					
		            	dos.writeInt(this.START_NET_TOTALIZER);
					
		            	dos.writeInt(this.END_NET_TOTALIZER);
					
		            	dos.writeInt(this.START_WEIGHT);
					
		            	dos.writeInt(this.END_WEIGHT);
					
						writeString(this.LAST_USER_NAME, dos, oos);
					
						writeDate(this.LAST_MODIFIED, dos, oos);
					
						writeDate(this.START_TIME, dos, oos);
					
						writeDate(this.END_TIME, dos, oos);
					
		            	dos.writeInt(this.ADDITIVE_QUANTITY);
					
		            	dos.writeInt(this.PRODUCT_QUANTITY);
					
						writeString(this.HOST_PRODUCT_CODE, dos, oos);
					
						writeString(this.HOST_PRODUCT_NAME, dos, oos);
					
		            	dos.writeInt(this.FROM_LEFT_ON_TRUCK);
					
		            	dos.writeDouble(this.OBSERVED_DENSITY);
					
		            	dos.writeInt(this.COMPONENT_ID);
					
		            	dos.writeInt(this.CALCULATE_SECONDARY_UNITS);
					
						writeString(this.FINAL_SCALE_INTERFACE_CODE, dos, oos);
					
		            	dos.writeInt(this.FRAC_START_GROSS_TOTALIZER);
					
		            	dos.writeInt(this.FRAC_END_GROSS_TOTALIZER);
					
						writeString(this.PETROEX_COMPONENT_PRODUCT_CODE, dos, oos);
					
		            	dos.writeInt(this.PRODUCT_TOLERANCE_STATUS);
					
		            	dos.writeInt(this.TANK_INVENTORY_UPDATED);
					
		            	dos.writeInt(this.TOTALIZER_UPDATED);
					
		            	dos.writeInt(this.FLUSH_STATUS);
					
					writeInteger(this.REDUCED_PRODUCT_NUMBER, dos, oos);
					
		            	dos.writeInt(this.ADDITIVE_WEIGHT);
					
		            	dos.writeInt(this.PRODUCT_WEIGHT);
					
		            	dos.writeInt(this.RT_INJECTOR_ALARM_COUNT);
					
		            	dos.writeInt(this.BATCH_NUMBER);
					
						writeString(this.VRU_CODE, dos, oos);
					
		            	dos.writeInt(this.ADDITIVE_MASKING);
					
		            	dos.writeInt(this.COMPATIBILITY_STATUS);
					
		            	dos.writeInt(this.RECIPE_CORRECTION_TYPE);
					
		            	dos.writeInt(this.NON_RECIPE_GROSS_QUANTITY);
					
		            	dos.writeInt(this.NON_RECIPE_NET_QUANTITY);
					
		            	dos.writeInt(this.NON_RECIPE_WEIGHT);
					
		            	dos.writeInt(this.WEIGHT_IN_VAC);
					
		            	dos.writeInt(this.ADDITIVE_WEIGHT_IN_VAC);
					
		            	dos.writeInt(this.COMMITTED_GROSS_QUANTITY);
					
		            	dos.writeInt(this.PRODUCT_WEIGHT_IN_VAC);
					
		            	dos.writeInt(this.COMMITTED_NET_QUANTITY);
					
						writeString(this.PDXR_PRODUCT_CODE, dos, oos);
					
		            	dos.writeInt(this.PDXR_AUTHORIZATION_UNITS);
					
		            	dos.writeInt(this.COMMITTED_WEIGHT_IN_VAC);
					
		            	dos.writeInt(this.COMMITTED_WEIGHT_IN_AIR);
					
						writeString(this.PDXR_ADDITIVE_CODE, dos, oos);
					
		            	dos.writeDouble(this.COMMITTED_CONV_TEMPERATURE);
					
		            	dos.writeDouble(this.COMMITTED_CONV_DENSITY);
					
		            	dos.writeDouble(this.COMMITTED_CONV_COE);
					
		            	dos.writeDouble(this.COMMITTED_CONV_PRESSURE);
					
		            	dos.writeInt(this.MEASURED_QUANTITY_TYPE);
					
		            	dos.writeInt(this.INVENTORY_QUANTITY_TYPE);
					
		            	dos.writeInt(this.DERIVED_VALUES_DIRECTIVE);
					
		            	dos.writeDouble(this.PRESSURE);
					
						writeString(this.METER_PRESET_CODE, dos, oos);
					
		            	dos.writeInt(this.CALCULATE_NET);
					
		            	dos.writeInt(this.NON_RECIPE_WEIGHT_IN_VAC);
					
		            	dos.writeInt(this.ADJUSTMENT_BATCH);
					
					writeInteger(this.COMPARTMENT_OWNER_ID, dos, oos);
					
						writeString(this.COMPARTMENT_CONTAINER_CODE, dos, oos);
					
					writeInteger(this.COMPARTMENT_CONTAINER_TYPE, dos, oos);
					
					writeInteger(this.COMPARTMENT_NUMBER, dos, oos);
					
						writeString(this.PDXR_LOADING_REF, dos, oos);
					
		            	dos.writeInt(this.BLEND_CORRECTION_METHOD);
					
		            	dos.writeDouble(this.BLEND_CORRECTION_NET_VOLUME);
					
		            	dos.writeDouble(this.TOTAL_BATCH_BLEND_NET_VOLUME);
					
		            	dos.writeInt(this.BLEND_CORRECTION_SOURCE);
					
		            	dos.writeInt(this.COMMODITY_GROUP);
					
		            	dos.writeInt(this.DERIVATION_STATUS);
					
						writeString(this.DERIVED_VALUES_ERROR, dos, oos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
					objectOut.writeInt(this.ORDER_ID);
					
					objectOut.writeInt(this.COMPARTMENT_ID);
					
						writeString(this.BAY_CODE, dos, objectOut);
					
						writeString(this.API_CODE, dos, objectOut);
					
						writeString(this.INJECTOR_PRESET_CODE, dos, objectOut);
					
						writeString(this.TARE_SCALE_INTERFACE_CODE, dos, objectOut);
					
						writeString(this.TANK_CODE, dos, objectOut);
					
						writeString(this.PRODUCT_GROUP_CODE, dos, objectOut);
					
						writeString(this.INJECTOR_CODE, dos, objectOut);
					
						writeString(this.METER_CODE, dos, objectOut);
					
					writeInteger(this.SUPPLIER_NUMBER, dos, objectOut);
					
					objectOut.writeInt(this.TERMINAL_PRODUCT_NUMBER);
					
					objectOut.writeInt(this.TERMINAL_PRODUCT_TYPE);
					
						writeString(this.SHOST_SI_HOST_PRODUCT_NUMBER, dos, objectOut);
					
					objectOut.writeDouble(this.BLEND_PERCENT);
					
					objectOut.writeInt(this.RATE);
					
						writeString(this.THOST_TI_HOST_PRODUCT_NUMBER, dos, objectOut);
					
					objectOut.writeInt(this.ORDERED_QUANTITY);
					
					objectOut.writeInt(this.OVERRIDE_TEMPERATURE_ENABLE);
					
					objectOut.writeInt(this.GROSS_QUANTITY);
					
					objectOut.writeInt(this.WEIGHT);
					
					objectOut.writeInt(this.NET_QUANTITY);
					
					objectOut.writeDouble(this.DENSITY);
					
					objectOut.writeInt(this.CUSTOMER_NET_QUANTITY);
					
					objectOut.writeDouble(this.SPECIFIC_GRAVITY);
					
					objectOut.writeDouble(this.COEFFICIENT_EXPANSION);
					
					objectOut.writeDouble(this.TEMPERATURE);
					
					objectOut.writeDouble(this.RVP);
					
					objectOut.writeDouble(this.OXYGEN);
					
					objectOut.writeInt(this.START_GROSS_TOTALIZER);
					
					objectOut.writeInt(this.END_GROSS_TOTALIZER);
					
					objectOut.writeInt(this.START_NET_TOTALIZER);
					
					objectOut.writeInt(this.END_NET_TOTALIZER);
					
					objectOut.writeInt(this.START_WEIGHT);
					
					objectOut.writeInt(this.END_WEIGHT);
					
						writeString(this.LAST_USER_NAME, dos, objectOut);
					
						writeDate(this.LAST_MODIFIED, dos, objectOut);
					
						writeDate(this.START_TIME, dos, objectOut);
					
						writeDate(this.END_TIME, dos, objectOut);
					
					objectOut.writeInt(this.ADDITIVE_QUANTITY);
					
					objectOut.writeInt(this.PRODUCT_QUANTITY);
					
						writeString(this.HOST_PRODUCT_CODE, dos, objectOut);
					
						writeString(this.HOST_PRODUCT_NAME, dos, objectOut);
					
					objectOut.writeInt(this.FROM_LEFT_ON_TRUCK);
					
					objectOut.writeDouble(this.OBSERVED_DENSITY);
					
					objectOut.writeInt(this.COMPONENT_ID);
					
					objectOut.writeInt(this.CALCULATE_SECONDARY_UNITS);
					
						writeString(this.FINAL_SCALE_INTERFACE_CODE, dos, objectOut);
					
					objectOut.writeInt(this.FRAC_START_GROSS_TOTALIZER);
					
					objectOut.writeInt(this.FRAC_END_GROSS_TOTALIZER);
					
						writeString(this.PETROEX_COMPONENT_PRODUCT_CODE, dos, objectOut);
					
					objectOut.writeInt(this.PRODUCT_TOLERANCE_STATUS);
					
					objectOut.writeInt(this.TANK_INVENTORY_UPDATED);
					
					objectOut.writeInt(this.TOTALIZER_UPDATED);
					
					objectOut.writeInt(this.FLUSH_STATUS);
					
					writeInteger(this.REDUCED_PRODUCT_NUMBER, dos, objectOut);
					
					objectOut.writeInt(this.ADDITIVE_WEIGHT);
					
					objectOut.writeInt(this.PRODUCT_WEIGHT);
					
					objectOut.writeInt(this.RT_INJECTOR_ALARM_COUNT);
					
					objectOut.writeInt(this.BATCH_NUMBER);
					
						writeString(this.VRU_CODE, dos, objectOut);
					
					objectOut.writeInt(this.ADDITIVE_MASKING);
					
					objectOut.writeInt(this.COMPATIBILITY_STATUS);
					
					objectOut.writeInt(this.RECIPE_CORRECTION_TYPE);
					
					objectOut.writeInt(this.NON_RECIPE_GROSS_QUANTITY);
					
					objectOut.writeInt(this.NON_RECIPE_NET_QUANTITY);
					
					objectOut.writeInt(this.NON_RECIPE_WEIGHT);
					
					objectOut.writeInt(this.WEIGHT_IN_VAC);
					
					objectOut.writeInt(this.ADDITIVE_WEIGHT_IN_VAC);
					
					objectOut.writeInt(this.COMMITTED_GROSS_QUANTITY);
					
					objectOut.writeInt(this.PRODUCT_WEIGHT_IN_VAC);
					
					objectOut.writeInt(this.COMMITTED_NET_QUANTITY);
					
						writeString(this.PDXR_PRODUCT_CODE, dos, objectOut);
					
					objectOut.writeInt(this.PDXR_AUTHORIZATION_UNITS);
					
					objectOut.writeInt(this.COMMITTED_WEIGHT_IN_VAC);
					
					objectOut.writeInt(this.COMMITTED_WEIGHT_IN_AIR);
					
						writeString(this.PDXR_ADDITIVE_CODE, dos, objectOut);
					
					objectOut.writeDouble(this.COMMITTED_CONV_TEMPERATURE);
					
					objectOut.writeDouble(this.COMMITTED_CONV_DENSITY);
					
					objectOut.writeDouble(this.COMMITTED_CONV_COE);
					
					objectOut.writeDouble(this.COMMITTED_CONV_PRESSURE);
					
					objectOut.writeInt(this.MEASURED_QUANTITY_TYPE);
					
					objectOut.writeInt(this.INVENTORY_QUANTITY_TYPE);
					
					objectOut.writeInt(this.DERIVED_VALUES_DIRECTIVE);
					
					objectOut.writeDouble(this.PRESSURE);
					
						writeString(this.METER_PRESET_CODE, dos, objectOut);
					
					objectOut.writeInt(this.CALCULATE_NET);
					
					objectOut.writeInt(this.NON_RECIPE_WEIGHT_IN_VAC);
					
					objectOut.writeInt(this.ADJUSTMENT_BATCH);
					
					writeInteger(this.COMPARTMENT_OWNER_ID, dos, objectOut);
					
						writeString(this.COMPARTMENT_CONTAINER_CODE, dos, objectOut);
					
					writeInteger(this.COMPARTMENT_CONTAINER_TYPE, dos, objectOut);
					
					writeInteger(this.COMPARTMENT_NUMBER, dos, objectOut);
					
						writeString(this.PDXR_LOADING_REF, dos, objectOut);
					
					objectOut.writeInt(this.BLEND_CORRECTION_METHOD);
					
					objectOut.writeDouble(this.BLEND_CORRECTION_NET_VOLUME);
					
					objectOut.writeDouble(this.TOTAL_BATCH_BLEND_NET_VOLUME);
					
					objectOut.writeInt(this.BLEND_CORRECTION_SOURCE);
					
					objectOut.writeInt(this.COMMODITY_GROUP);
					
					objectOut.writeInt(this.DERIVATION_STATUS);
					
						writeString(this.DERIVED_VALUES_ERROR, dos, objectOut);
					
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
    public int compareTo(row3Struct other) {

		int returnValue = -1;
		
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
public void tDBInput_8Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBInput_8_SUBPROCESS_STATE", 0);

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
			   		// source node:tDBInput_8 - inputs:(after_tDBInput_1) outputs:(row3,row3) | target node:tAdvancedHash_row3 - inputs:(row3) outputs:()
			   		// linked node: tMap_1 - inputs:(row1,row2,row3,row4,row5,row6,row10,row11,row7,row8,row9) outputs:(out1)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row3 = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct> tHash_Lookup_row3 =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<row3Struct>getLookup(matchingModeEnum_row3);
	   						   
		   	   	   globalMap.put("tHash_Lookup_row3", tHash_Lookup_row3);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_row3 begin ] stop
 */



	
	/**
	 * [tDBInput_8 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_8", false);
		start_Hash.put("tDBInput_8", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_8";

	
		int tos_count_tDBInput_8 = 0;
		
	
    
	
			org.talend.designer.components.util.mssql.MSSqlGenerateTimestampUtil mssqlGTU_tDBInput_8 = org.talend.designer.components.util.mssql.MSSqlUtilFactory.getMSSqlGenerateTimestampUtil();
			
			java.util.List<String> talendToDBList_tDBInput_8 = new java.util.ArrayList();
			String[] talendToDBArray_tDBInput_8  = new String[]{"FLOAT","NUMERIC","NUMERIC IDENTITY","DECIMAL","DECIMAL IDENTITY","REAL"}; 
			java.util.Collections.addAll(talendToDBList_tDBInput_8, talendToDBArray_tDBInput_8); 
		    int nb_line_tDBInput_8 = 0;
		    java.sql.Connection conn_tDBInput_8 = null;
				String driverClass_tDBInput_8 = "net.sourceforge.jtds.jdbc.Driver";
			    java.lang.Class jdbcclazz_tDBInput_8 = java.lang.Class.forName(driverClass_tDBInput_8);
				String dbUser_tDBInput_8 = "sa";
				
				 
	final String decryptedPassword_tDBInput_8 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:FDzfDY+Cicr6Xbn0RPjyzLLNxp+SmdMNI2H8Cr2dgYiVs9IT/2g=");
				
				String dbPwd_tDBInput_8 = decryptedPassword_tDBInput_8;
				
		    String port_tDBInput_8 = "1433";
		    String dbname_tDBInput_8 = "FF_TEST" ;
			String url_tDBInput_8 = "jdbc:jtds:sqlserver://" + "LAPTOP-HED7JE2F" ;
		    if (!"".equals(port_tDBInput_8)) {
		    	url_tDBInput_8 += ":" + "1433";
		    }
		    if (!"".equals(dbname_tDBInput_8)) {
				url_tDBInput_8 += "//" + "FF_TEST"; 
		    }
		    url_tDBInput_8 += ";appName=" + projectName + ";" + "";
		    String dbschema_tDBInput_8 = "dbo";
				
				conn_tDBInput_8 = java.sql.DriverManager.getConnection(url_tDBInput_8,dbUser_tDBInput_8,dbPwd_tDBInput_8);
		        
		    
			java.sql.Statement stmt_tDBInput_8 = conn_tDBInput_8.createStatement();

		    String dbquery_tDBInput_8 = "SELECT dbo.ORDER_RECIPE.ORDER_ID,\n		dbo.ORDER_RECIPE.COMPARTMENT_ID,\n		dbo.ORDER_RECIPE.ORDER_RECIPE_ID,\n		dbo.ORDER_RE"
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
		    

            	globalMap.put("tDBInput_8_QUERY",dbquery_tDBInput_8);
		    java.sql.ResultSet rs_tDBInput_8 = null;

		    try {
		    	rs_tDBInput_8 = stmt_tDBInput_8.executeQuery(dbquery_tDBInput_8);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_8 = rs_tDBInput_8.getMetaData();
		    	int colQtyInRs_tDBInput_8 = rsmd_tDBInput_8.getColumnCount();

		    String tmpContent_tDBInput_8 = null;
		    
		    
		    while (rs_tDBInput_8.next()) {
		        nb_line_tDBInput_8++;
		        
							if(colQtyInRs_tDBInput_8 < 1) {
								row3.ORDER_ID = 0;
							} else {
		                          
            row3.ORDER_ID = rs_tDBInput_8.getInt(1);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 2) {
								row3.COMPARTMENT_ID = 0;
							} else {
		                          
            row3.COMPARTMENT_ID = rs_tDBInput_8.getInt(2);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 3) {
								row3.ORDER_RECIPE_ID = 0;
							} else {
		                          
            row3.ORDER_RECIPE_ID = rs_tDBInput_8.getInt(3);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 4) {
								row3.BAY_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_8 = rs_tDBInput_8.getString(4);
            if(tmpContent_tDBInput_8 != null) {
            	if (talendToDBList_tDBInput_8 .contains(rsmd_tDBInput_8.getColumnTypeName(4).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.BAY_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_8);
            	} else {
                	row3.BAY_CODE = tmpContent_tDBInput_8;
                }
            } else {
                row3.BAY_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 5) {
								row3.API_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_8 = rs_tDBInput_8.getString(5);
            if(tmpContent_tDBInput_8 != null) {
            	if (talendToDBList_tDBInput_8 .contains(rsmd_tDBInput_8.getColumnTypeName(5).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.API_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_8);
            	} else {
                	row3.API_CODE = tmpContent_tDBInput_8;
                }
            } else {
                row3.API_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 6) {
								row3.INJECTOR_PRESET_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_8 = rs_tDBInput_8.getString(6);
            if(tmpContent_tDBInput_8 != null) {
            	if (talendToDBList_tDBInput_8 .contains(rsmd_tDBInput_8.getColumnTypeName(6).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.INJECTOR_PRESET_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_8);
            	} else {
                	row3.INJECTOR_PRESET_CODE = tmpContent_tDBInput_8;
                }
            } else {
                row3.INJECTOR_PRESET_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 7) {
								row3.TARE_SCALE_INTERFACE_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_8 = rs_tDBInput_8.getString(7);
            if(tmpContent_tDBInput_8 != null) {
            	if (talendToDBList_tDBInput_8 .contains(rsmd_tDBInput_8.getColumnTypeName(7).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.TARE_SCALE_INTERFACE_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_8);
            	} else {
                	row3.TARE_SCALE_INTERFACE_CODE = tmpContent_tDBInput_8;
                }
            } else {
                row3.TARE_SCALE_INTERFACE_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 8) {
								row3.TANK_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_8 = rs_tDBInput_8.getString(8);
            if(tmpContent_tDBInput_8 != null) {
            	if (talendToDBList_tDBInput_8 .contains(rsmd_tDBInput_8.getColumnTypeName(8).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.TANK_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_8);
            	} else {
                	row3.TANK_CODE = tmpContent_tDBInput_8;
                }
            } else {
                row3.TANK_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 9) {
								row3.PRODUCT_GROUP_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_8 = rs_tDBInput_8.getString(9);
            if(tmpContent_tDBInput_8 != null) {
            	if (talendToDBList_tDBInput_8 .contains(rsmd_tDBInput_8.getColumnTypeName(9).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.PRODUCT_GROUP_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_8);
            	} else {
                	row3.PRODUCT_GROUP_CODE = tmpContent_tDBInput_8;
                }
            } else {
                row3.PRODUCT_GROUP_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 10) {
								row3.INJECTOR_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_8 = rs_tDBInput_8.getString(10);
            if(tmpContent_tDBInput_8 != null) {
            	if (talendToDBList_tDBInput_8 .contains(rsmd_tDBInput_8.getColumnTypeName(10).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.INJECTOR_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_8);
            	} else {
                	row3.INJECTOR_CODE = tmpContent_tDBInput_8;
                }
            } else {
                row3.INJECTOR_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 11) {
								row3.METER_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_8 = rs_tDBInput_8.getString(11);
            if(tmpContent_tDBInput_8 != null) {
            	if (talendToDBList_tDBInput_8 .contains(rsmd_tDBInput_8.getColumnTypeName(11).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.METER_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_8);
            	} else {
                	row3.METER_CODE = tmpContent_tDBInput_8;
                }
            } else {
                row3.METER_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 12) {
								row3.SUPPLIER_NUMBER = null;
							} else {
		                          
            row3.SUPPLIER_NUMBER = rs_tDBInput_8.getInt(12);
            if(rs_tDBInput_8.wasNull()){
                    row3.SUPPLIER_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 13) {
								row3.TERMINAL_PRODUCT_NUMBER = 0;
							} else {
		                          
            row3.TERMINAL_PRODUCT_NUMBER = rs_tDBInput_8.getInt(13);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 14) {
								row3.TERMINAL_PRODUCT_TYPE = 0;
							} else {
		                          
            row3.TERMINAL_PRODUCT_TYPE = rs_tDBInput_8.getInt(14);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 15) {
								row3.SHOST_SI_HOST_PRODUCT_NUMBER = null;
							} else {
	                         		
           		tmpContent_tDBInput_8 = rs_tDBInput_8.getString(15);
            if(tmpContent_tDBInput_8 != null) {
            	if (talendToDBList_tDBInput_8 .contains(rsmd_tDBInput_8.getColumnTypeName(15).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.SHOST_SI_HOST_PRODUCT_NUMBER = FormatterUtils.formatUnwithE(tmpContent_tDBInput_8);
            	} else {
                	row3.SHOST_SI_HOST_PRODUCT_NUMBER = tmpContent_tDBInput_8;
                }
            } else {
                row3.SHOST_SI_HOST_PRODUCT_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 16) {
								row3.BLEND_PERCENT = 0;
							} else {
	                         		
            row3.BLEND_PERCENT = rs_tDBInput_8.getDouble(16);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 17) {
								row3.RATE = 0;
							} else {
		                          
            row3.RATE = rs_tDBInput_8.getInt(17);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 18) {
								row3.THOST_TI_HOST_PRODUCT_NUMBER = null;
							} else {
	                         		
           		tmpContent_tDBInput_8 = rs_tDBInput_8.getString(18);
            if(tmpContent_tDBInput_8 != null) {
            	if (talendToDBList_tDBInput_8 .contains(rsmd_tDBInput_8.getColumnTypeName(18).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.THOST_TI_HOST_PRODUCT_NUMBER = FormatterUtils.formatUnwithE(tmpContent_tDBInput_8);
            	} else {
                	row3.THOST_TI_HOST_PRODUCT_NUMBER = tmpContent_tDBInput_8;
                }
            } else {
                row3.THOST_TI_HOST_PRODUCT_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 19) {
								row3.ORDERED_QUANTITY = 0;
							} else {
		                          
            row3.ORDERED_QUANTITY = rs_tDBInput_8.getInt(19);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 20) {
								row3.OVERRIDE_TEMPERATURE_ENABLE = 0;
							} else {
		                          
            row3.OVERRIDE_TEMPERATURE_ENABLE = rs_tDBInput_8.getInt(20);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 21) {
								row3.GROSS_QUANTITY = 0;
							} else {
		                          
            row3.GROSS_QUANTITY = rs_tDBInput_8.getInt(21);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 22) {
								row3.WEIGHT = 0;
							} else {
		                          
            row3.WEIGHT = rs_tDBInput_8.getInt(22);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 23) {
								row3.NET_QUANTITY = 0;
							} else {
		                          
            row3.NET_QUANTITY = rs_tDBInput_8.getInt(23);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 24) {
								row3.DENSITY = 0;
							} else {
	                         		
            row3.DENSITY = rs_tDBInput_8.getDouble(24);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 25) {
								row3.CUSTOMER_NET_QUANTITY = 0;
							} else {
		                          
            row3.CUSTOMER_NET_QUANTITY = rs_tDBInput_8.getInt(25);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 26) {
								row3.SPECIFIC_GRAVITY = 0;
							} else {
	                         		
            row3.SPECIFIC_GRAVITY = rs_tDBInput_8.getDouble(26);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 27) {
								row3.COEFFICIENT_EXPANSION = 0;
							} else {
	                         		
            row3.COEFFICIENT_EXPANSION = rs_tDBInput_8.getDouble(27);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 28) {
								row3.TEMPERATURE = 0;
							} else {
	                         		
            row3.TEMPERATURE = rs_tDBInput_8.getDouble(28);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 29) {
								row3.RVP = 0;
							} else {
	                         		
            row3.RVP = rs_tDBInput_8.getDouble(29);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 30) {
								row3.OXYGEN = 0;
							} else {
	                         		
            row3.OXYGEN = rs_tDBInput_8.getDouble(30);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 31) {
								row3.START_GROSS_TOTALIZER = 0;
							} else {
		                          
            row3.START_GROSS_TOTALIZER = rs_tDBInput_8.getInt(31);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 32) {
								row3.END_GROSS_TOTALIZER = 0;
							} else {
		                          
            row3.END_GROSS_TOTALIZER = rs_tDBInput_8.getInt(32);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 33) {
								row3.START_NET_TOTALIZER = 0;
							} else {
		                          
            row3.START_NET_TOTALIZER = rs_tDBInput_8.getInt(33);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 34) {
								row3.END_NET_TOTALIZER = 0;
							} else {
		                          
            row3.END_NET_TOTALIZER = rs_tDBInput_8.getInt(34);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 35) {
								row3.START_WEIGHT = 0;
							} else {
		                          
            row3.START_WEIGHT = rs_tDBInput_8.getInt(35);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 36) {
								row3.END_WEIGHT = 0;
							} else {
		                          
            row3.END_WEIGHT = rs_tDBInput_8.getInt(36);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 37) {
								row3.LAST_USER_NAME = null;
							} else {
	                         		
           		tmpContent_tDBInput_8 = rs_tDBInput_8.getString(37);
            if(tmpContent_tDBInput_8 != null) {
            	if (talendToDBList_tDBInput_8 .contains(rsmd_tDBInput_8.getColumnTypeName(37).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.LAST_USER_NAME = FormatterUtils.formatUnwithE(tmpContent_tDBInput_8);
            	} else {
                	row3.LAST_USER_NAME = tmpContent_tDBInput_8;
                }
            } else {
                row3.LAST_USER_NAME = null;
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 38) {
								row3.LAST_MODIFIED = null;
							} else {
										
			row3.LAST_MODIFIED = mssqlGTU_tDBInput_8.getDate(rsmd_tDBInput_8, rs_tDBInput_8, 38);
			
		                    }
							if(colQtyInRs_tDBInput_8 < 39) {
								row3.START_TIME = null;
							} else {
										
			row3.START_TIME = mssqlGTU_tDBInput_8.getDate(rsmd_tDBInput_8, rs_tDBInput_8, 39);
			
		                    }
							if(colQtyInRs_tDBInput_8 < 40) {
								row3.END_TIME = null;
							} else {
										
			row3.END_TIME = mssqlGTU_tDBInput_8.getDate(rsmd_tDBInput_8, rs_tDBInput_8, 40);
			
		                    }
							if(colQtyInRs_tDBInput_8 < 41) {
								row3.ADDITIVE_QUANTITY = 0;
							} else {
		                          
            row3.ADDITIVE_QUANTITY = rs_tDBInput_8.getInt(41);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 42) {
								row3.PRODUCT_QUANTITY = 0;
							} else {
		                          
            row3.PRODUCT_QUANTITY = rs_tDBInput_8.getInt(42);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 43) {
								row3.HOST_PRODUCT_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_8 = rs_tDBInput_8.getString(43);
            if(tmpContent_tDBInput_8 != null) {
            	if (talendToDBList_tDBInput_8 .contains(rsmd_tDBInput_8.getColumnTypeName(43).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.HOST_PRODUCT_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_8);
            	} else {
                	row3.HOST_PRODUCT_CODE = tmpContent_tDBInput_8;
                }
            } else {
                row3.HOST_PRODUCT_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 44) {
								row3.HOST_PRODUCT_NAME = null;
							} else {
	                         		
           		tmpContent_tDBInput_8 = rs_tDBInput_8.getString(44);
            if(tmpContent_tDBInput_8 != null) {
            	if (talendToDBList_tDBInput_8 .contains(rsmd_tDBInput_8.getColumnTypeName(44).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.HOST_PRODUCT_NAME = FormatterUtils.formatUnwithE(tmpContent_tDBInput_8);
            	} else {
                	row3.HOST_PRODUCT_NAME = tmpContent_tDBInput_8;
                }
            } else {
                row3.HOST_PRODUCT_NAME = null;
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 45) {
								row3.FROM_LEFT_ON_TRUCK = 0;
							} else {
		                          
            row3.FROM_LEFT_ON_TRUCK = rs_tDBInput_8.getInt(45);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 46) {
								row3.OBSERVED_DENSITY = 0;
							} else {
	                         		
            row3.OBSERVED_DENSITY = rs_tDBInput_8.getDouble(46);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 47) {
								row3.COMPONENT_ID = 0;
							} else {
		                          
            row3.COMPONENT_ID = rs_tDBInput_8.getInt(47);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 48) {
								row3.CALCULATE_SECONDARY_UNITS = 0;
							} else {
		                          
            row3.CALCULATE_SECONDARY_UNITS = rs_tDBInput_8.getInt(48);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 49) {
								row3.FINAL_SCALE_INTERFACE_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_8 = rs_tDBInput_8.getString(49);
            if(tmpContent_tDBInput_8 != null) {
            	if (talendToDBList_tDBInput_8 .contains(rsmd_tDBInput_8.getColumnTypeName(49).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.FINAL_SCALE_INTERFACE_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_8);
            	} else {
                	row3.FINAL_SCALE_INTERFACE_CODE = tmpContent_tDBInput_8;
                }
            } else {
                row3.FINAL_SCALE_INTERFACE_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 50) {
								row3.FRAC_START_GROSS_TOTALIZER = 0;
							} else {
		                          
            row3.FRAC_START_GROSS_TOTALIZER = rs_tDBInput_8.getInt(50);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 51) {
								row3.FRAC_END_GROSS_TOTALIZER = 0;
							} else {
		                          
            row3.FRAC_END_GROSS_TOTALIZER = rs_tDBInput_8.getInt(51);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 52) {
								row3.PETROEX_COMPONENT_PRODUCT_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_8 = rs_tDBInput_8.getString(52);
            if(tmpContent_tDBInput_8 != null) {
            	if (talendToDBList_tDBInput_8 .contains(rsmd_tDBInput_8.getColumnTypeName(52).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.PETROEX_COMPONENT_PRODUCT_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_8);
            	} else {
                	row3.PETROEX_COMPONENT_PRODUCT_CODE = tmpContent_tDBInput_8;
                }
            } else {
                row3.PETROEX_COMPONENT_PRODUCT_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 53) {
								row3.PRODUCT_TOLERANCE_STATUS = 0;
							} else {
		                          
            row3.PRODUCT_TOLERANCE_STATUS = rs_tDBInput_8.getInt(53);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 54) {
								row3.TANK_INVENTORY_UPDATED = 0;
							} else {
		                          
            row3.TANK_INVENTORY_UPDATED = rs_tDBInput_8.getInt(54);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 55) {
								row3.TOTALIZER_UPDATED = 0;
							} else {
		                          
            row3.TOTALIZER_UPDATED = rs_tDBInput_8.getInt(55);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 56) {
								row3.FLUSH_STATUS = 0;
							} else {
		                          
            row3.FLUSH_STATUS = rs_tDBInput_8.getInt(56);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 57) {
								row3.REDUCED_PRODUCT_NUMBER = null;
							} else {
		                          
            row3.REDUCED_PRODUCT_NUMBER = rs_tDBInput_8.getInt(57);
            if(rs_tDBInput_8.wasNull()){
                    row3.REDUCED_PRODUCT_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 58) {
								row3.ADDITIVE_WEIGHT = 0;
							} else {
		                          
            row3.ADDITIVE_WEIGHT = rs_tDBInput_8.getInt(58);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 59) {
								row3.PRODUCT_WEIGHT = 0;
							} else {
		                          
            row3.PRODUCT_WEIGHT = rs_tDBInput_8.getInt(59);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 60) {
								row3.RT_INJECTOR_ALARM_COUNT = 0;
							} else {
		                          
            row3.RT_INJECTOR_ALARM_COUNT = rs_tDBInput_8.getInt(60);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 61) {
								row3.BATCH_NUMBER = 0;
							} else {
		                          
            row3.BATCH_NUMBER = rs_tDBInput_8.getInt(61);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 62) {
								row3.VRU_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_8 = rs_tDBInput_8.getString(62);
            if(tmpContent_tDBInput_8 != null) {
            	if (talendToDBList_tDBInput_8 .contains(rsmd_tDBInput_8.getColumnTypeName(62).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.VRU_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_8);
            	} else {
                	row3.VRU_CODE = tmpContent_tDBInput_8;
                }
            } else {
                row3.VRU_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 63) {
								row3.ADDITIVE_MASKING = 0;
							} else {
		                          
            row3.ADDITIVE_MASKING = rs_tDBInput_8.getInt(63);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 64) {
								row3.COMPATIBILITY_STATUS = 0;
							} else {
		                          
            row3.COMPATIBILITY_STATUS = rs_tDBInput_8.getInt(64);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 65) {
								row3.RECIPE_CORRECTION_TYPE = 0;
							} else {
		                          
            row3.RECIPE_CORRECTION_TYPE = rs_tDBInput_8.getInt(65);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 66) {
								row3.NON_RECIPE_GROSS_QUANTITY = 0;
							} else {
		                          
            row3.NON_RECIPE_GROSS_QUANTITY = rs_tDBInput_8.getInt(66);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 67) {
								row3.NON_RECIPE_NET_QUANTITY = 0;
							} else {
		                          
            row3.NON_RECIPE_NET_QUANTITY = rs_tDBInput_8.getInt(67);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 68) {
								row3.NON_RECIPE_WEIGHT = 0;
							} else {
		                          
            row3.NON_RECIPE_WEIGHT = rs_tDBInput_8.getInt(68);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 69) {
								row3.WEIGHT_IN_VAC = 0;
							} else {
		                          
            row3.WEIGHT_IN_VAC = rs_tDBInput_8.getInt(69);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 70) {
								row3.ADDITIVE_WEIGHT_IN_VAC = 0;
							} else {
		                          
            row3.ADDITIVE_WEIGHT_IN_VAC = rs_tDBInput_8.getInt(70);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 71) {
								row3.COMMITTED_GROSS_QUANTITY = 0;
							} else {
		                          
            row3.COMMITTED_GROSS_QUANTITY = rs_tDBInput_8.getInt(71);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 72) {
								row3.PRODUCT_WEIGHT_IN_VAC = 0;
							} else {
		                          
            row3.PRODUCT_WEIGHT_IN_VAC = rs_tDBInput_8.getInt(72);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 73) {
								row3.COMMITTED_NET_QUANTITY = 0;
							} else {
		                          
            row3.COMMITTED_NET_QUANTITY = rs_tDBInput_8.getInt(73);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 74) {
								row3.PDXR_PRODUCT_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_8 = rs_tDBInput_8.getString(74);
            if(tmpContent_tDBInput_8 != null) {
            	if (talendToDBList_tDBInput_8 .contains(rsmd_tDBInput_8.getColumnTypeName(74).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.PDXR_PRODUCT_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_8);
            	} else {
                	row3.PDXR_PRODUCT_CODE = tmpContent_tDBInput_8;
                }
            } else {
                row3.PDXR_PRODUCT_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 75) {
								row3.PDXR_AUTHORIZATION_UNITS = 0;
							} else {
		                          
            row3.PDXR_AUTHORIZATION_UNITS = rs_tDBInput_8.getInt(75);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 76) {
								row3.COMMITTED_WEIGHT_IN_VAC = 0;
							} else {
		                          
            row3.COMMITTED_WEIGHT_IN_VAC = rs_tDBInput_8.getInt(76);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 77) {
								row3.COMMITTED_WEIGHT_IN_AIR = 0;
							} else {
		                          
            row3.COMMITTED_WEIGHT_IN_AIR = rs_tDBInput_8.getInt(77);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 78) {
								row3.PDXR_ADDITIVE_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_8 = rs_tDBInput_8.getString(78);
            if(tmpContent_tDBInput_8 != null) {
            	if (talendToDBList_tDBInput_8 .contains(rsmd_tDBInput_8.getColumnTypeName(78).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.PDXR_ADDITIVE_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_8);
            	} else {
                	row3.PDXR_ADDITIVE_CODE = tmpContent_tDBInput_8;
                }
            } else {
                row3.PDXR_ADDITIVE_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 79) {
								row3.COMMITTED_CONV_TEMPERATURE = 0;
							} else {
	                         		
            row3.COMMITTED_CONV_TEMPERATURE = rs_tDBInput_8.getDouble(79);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 80) {
								row3.COMMITTED_CONV_DENSITY = 0;
							} else {
	                         		
            row3.COMMITTED_CONV_DENSITY = rs_tDBInput_8.getDouble(80);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 81) {
								row3.COMMITTED_CONV_COE = 0;
							} else {
	                         		
            row3.COMMITTED_CONV_COE = rs_tDBInput_8.getDouble(81);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 82) {
								row3.COMMITTED_CONV_PRESSURE = 0;
							} else {
	                         		
            row3.COMMITTED_CONV_PRESSURE = rs_tDBInput_8.getDouble(82);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 83) {
								row3.MEASURED_QUANTITY_TYPE = 0;
							} else {
		                          
            row3.MEASURED_QUANTITY_TYPE = rs_tDBInput_8.getInt(83);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 84) {
								row3.INVENTORY_QUANTITY_TYPE = 0;
							} else {
		                          
            row3.INVENTORY_QUANTITY_TYPE = rs_tDBInput_8.getInt(84);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 85) {
								row3.DERIVED_VALUES_DIRECTIVE = 0;
							} else {
		                          
            row3.DERIVED_VALUES_DIRECTIVE = rs_tDBInput_8.getInt(85);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 86) {
								row3.PRESSURE = 0;
							} else {
	                         		
            row3.PRESSURE = rs_tDBInput_8.getDouble(86);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 87) {
								row3.METER_PRESET_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_8 = rs_tDBInput_8.getString(87);
            if(tmpContent_tDBInput_8 != null) {
            	if (talendToDBList_tDBInput_8 .contains(rsmd_tDBInput_8.getColumnTypeName(87).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.METER_PRESET_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_8);
            	} else {
                	row3.METER_PRESET_CODE = tmpContent_tDBInput_8;
                }
            } else {
                row3.METER_PRESET_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 88) {
								row3.CALCULATE_NET = 0;
							} else {
		                          
            row3.CALCULATE_NET = rs_tDBInput_8.getInt(88);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 89) {
								row3.NON_RECIPE_WEIGHT_IN_VAC = 0;
							} else {
		                          
            row3.NON_RECIPE_WEIGHT_IN_VAC = rs_tDBInput_8.getInt(89);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 90) {
								row3.ADJUSTMENT_BATCH = 0;
							} else {
		                          
            row3.ADJUSTMENT_BATCH = rs_tDBInput_8.getInt(90);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 91) {
								row3.COMPARTMENT_OWNER_ID = null;
							} else {
		                          
            row3.COMPARTMENT_OWNER_ID = rs_tDBInput_8.getInt(91);
            if(rs_tDBInput_8.wasNull()){
                    row3.COMPARTMENT_OWNER_ID = null;
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 92) {
								row3.COMPARTMENT_CONTAINER_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_8 = rs_tDBInput_8.getString(92);
            if(tmpContent_tDBInput_8 != null) {
            	if (talendToDBList_tDBInput_8 .contains(rsmd_tDBInput_8.getColumnTypeName(92).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.COMPARTMENT_CONTAINER_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_8);
            	} else {
                	row3.COMPARTMENT_CONTAINER_CODE = tmpContent_tDBInput_8;
                }
            } else {
                row3.COMPARTMENT_CONTAINER_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 93) {
								row3.COMPARTMENT_CONTAINER_TYPE = null;
							} else {
		                          
            row3.COMPARTMENT_CONTAINER_TYPE = rs_tDBInput_8.getInt(93);
            if(rs_tDBInput_8.wasNull()){
                    row3.COMPARTMENT_CONTAINER_TYPE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 94) {
								row3.COMPARTMENT_NUMBER = null;
							} else {
		                          
            row3.COMPARTMENT_NUMBER = rs_tDBInput_8.getInt(94);
            if(rs_tDBInput_8.wasNull()){
                    row3.COMPARTMENT_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 95) {
								row3.PDXR_LOADING_REF = null;
							} else {
	                         		
           		tmpContent_tDBInput_8 = rs_tDBInput_8.getString(95);
            if(tmpContent_tDBInput_8 != null) {
            	if (talendToDBList_tDBInput_8 .contains(rsmd_tDBInput_8.getColumnTypeName(95).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.PDXR_LOADING_REF = FormatterUtils.formatUnwithE(tmpContent_tDBInput_8);
            	} else {
                	row3.PDXR_LOADING_REF = tmpContent_tDBInput_8;
                }
            } else {
                row3.PDXR_LOADING_REF = null;
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 96) {
								row3.BLEND_CORRECTION_METHOD = 0;
							} else {
		                          
            row3.BLEND_CORRECTION_METHOD = rs_tDBInput_8.getInt(96);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 97) {
								row3.BLEND_CORRECTION_NET_VOLUME = 0;
							} else {
	                         		
            row3.BLEND_CORRECTION_NET_VOLUME = rs_tDBInput_8.getDouble(97);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 98) {
								row3.TOTAL_BATCH_BLEND_NET_VOLUME = 0;
							} else {
	                         		
            row3.TOTAL_BATCH_BLEND_NET_VOLUME = rs_tDBInput_8.getDouble(98);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 99) {
								row3.BLEND_CORRECTION_SOURCE = 0;
							} else {
		                          
            row3.BLEND_CORRECTION_SOURCE = rs_tDBInput_8.getInt(99);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 100) {
								row3.COMMODITY_GROUP = 0;
							} else {
		                          
            row3.COMMODITY_GROUP = rs_tDBInput_8.getInt(100);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 101) {
								row3.DERIVATION_STATUS = 0;
							} else {
		                          
            row3.DERIVATION_STATUS = rs_tDBInput_8.getInt(101);
            if(rs_tDBInput_8.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_8 < 102) {
								row3.DERIVED_VALUES_ERROR = null;
							} else {
	                         		
           		tmpContent_tDBInput_8 = rs_tDBInput_8.getString(102);
            if(tmpContent_tDBInput_8 != null) {
            	if (talendToDBList_tDBInput_8 .contains(rsmd_tDBInput_8.getColumnTypeName(102).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.DERIVED_VALUES_ERROR = FormatterUtils.formatUnwithE(tmpContent_tDBInput_8);
            	} else {
                	row3.DERIVED_VALUES_ERROR = tmpContent_tDBInput_8;
                }
            } else {
                row3.DERIVED_VALUES_ERROR = null;
            }
		                    }
					





 



/**
 * [tDBInput_8 begin ] stop
 */
	
	/**
	 * [tDBInput_8 main ] start
	 */

	

	
	
	currentComponent="tDBInput_8";

	

 


	tos_count_tDBInput_8++;

/**
 * [tDBInput_8 main ] stop
 */
	
	/**
	 * [tDBInput_8 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_8";

	

 



/**
 * [tDBInput_8 process_data_begin ] stop
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
		   	   	   
				
				row3_HashRow.ORDER_ID = row3.ORDER_ID;
				
				row3_HashRow.COMPARTMENT_ID = row3.COMPARTMENT_ID;
				
				row3_HashRow.ORDER_RECIPE_ID = row3.ORDER_RECIPE_ID;
				
				row3_HashRow.BAY_CODE = row3.BAY_CODE;
				
				row3_HashRow.API_CODE = row3.API_CODE;
				
				row3_HashRow.INJECTOR_PRESET_CODE = row3.INJECTOR_PRESET_CODE;
				
				row3_HashRow.TARE_SCALE_INTERFACE_CODE = row3.TARE_SCALE_INTERFACE_CODE;
				
				row3_HashRow.TANK_CODE = row3.TANK_CODE;
				
				row3_HashRow.PRODUCT_GROUP_CODE = row3.PRODUCT_GROUP_CODE;
				
				row3_HashRow.INJECTOR_CODE = row3.INJECTOR_CODE;
				
				row3_HashRow.METER_CODE = row3.METER_CODE;
				
				row3_HashRow.SUPPLIER_NUMBER = row3.SUPPLIER_NUMBER;
				
				row3_HashRow.TERMINAL_PRODUCT_NUMBER = row3.TERMINAL_PRODUCT_NUMBER;
				
				row3_HashRow.TERMINAL_PRODUCT_TYPE = row3.TERMINAL_PRODUCT_TYPE;
				
				row3_HashRow.SHOST_SI_HOST_PRODUCT_NUMBER = row3.SHOST_SI_HOST_PRODUCT_NUMBER;
				
				row3_HashRow.BLEND_PERCENT = row3.BLEND_PERCENT;
				
				row3_HashRow.RATE = row3.RATE;
				
				row3_HashRow.THOST_TI_HOST_PRODUCT_NUMBER = row3.THOST_TI_HOST_PRODUCT_NUMBER;
				
				row3_HashRow.ORDERED_QUANTITY = row3.ORDERED_QUANTITY;
				
				row3_HashRow.OVERRIDE_TEMPERATURE_ENABLE = row3.OVERRIDE_TEMPERATURE_ENABLE;
				
				row3_HashRow.GROSS_QUANTITY = row3.GROSS_QUANTITY;
				
				row3_HashRow.WEIGHT = row3.WEIGHT;
				
				row3_HashRow.NET_QUANTITY = row3.NET_QUANTITY;
				
				row3_HashRow.DENSITY = row3.DENSITY;
				
				row3_HashRow.CUSTOMER_NET_QUANTITY = row3.CUSTOMER_NET_QUANTITY;
				
				row3_HashRow.SPECIFIC_GRAVITY = row3.SPECIFIC_GRAVITY;
				
				row3_HashRow.COEFFICIENT_EXPANSION = row3.COEFFICIENT_EXPANSION;
				
				row3_HashRow.TEMPERATURE = row3.TEMPERATURE;
				
				row3_HashRow.RVP = row3.RVP;
				
				row3_HashRow.OXYGEN = row3.OXYGEN;
				
				row3_HashRow.START_GROSS_TOTALIZER = row3.START_GROSS_TOTALIZER;
				
				row3_HashRow.END_GROSS_TOTALIZER = row3.END_GROSS_TOTALIZER;
				
				row3_HashRow.START_NET_TOTALIZER = row3.START_NET_TOTALIZER;
				
				row3_HashRow.END_NET_TOTALIZER = row3.END_NET_TOTALIZER;
				
				row3_HashRow.START_WEIGHT = row3.START_WEIGHT;
				
				row3_HashRow.END_WEIGHT = row3.END_WEIGHT;
				
				row3_HashRow.LAST_USER_NAME = row3.LAST_USER_NAME;
				
				row3_HashRow.LAST_MODIFIED = row3.LAST_MODIFIED;
				
				row3_HashRow.START_TIME = row3.START_TIME;
				
				row3_HashRow.END_TIME = row3.END_TIME;
				
				row3_HashRow.ADDITIVE_QUANTITY = row3.ADDITIVE_QUANTITY;
				
				row3_HashRow.PRODUCT_QUANTITY = row3.PRODUCT_QUANTITY;
				
				row3_HashRow.HOST_PRODUCT_CODE = row3.HOST_PRODUCT_CODE;
				
				row3_HashRow.HOST_PRODUCT_NAME = row3.HOST_PRODUCT_NAME;
				
				row3_HashRow.FROM_LEFT_ON_TRUCK = row3.FROM_LEFT_ON_TRUCK;
				
				row3_HashRow.OBSERVED_DENSITY = row3.OBSERVED_DENSITY;
				
				row3_HashRow.COMPONENT_ID = row3.COMPONENT_ID;
				
				row3_HashRow.CALCULATE_SECONDARY_UNITS = row3.CALCULATE_SECONDARY_UNITS;
				
				row3_HashRow.FINAL_SCALE_INTERFACE_CODE = row3.FINAL_SCALE_INTERFACE_CODE;
				
				row3_HashRow.FRAC_START_GROSS_TOTALIZER = row3.FRAC_START_GROSS_TOTALIZER;
				
				row3_HashRow.FRAC_END_GROSS_TOTALIZER = row3.FRAC_END_GROSS_TOTALIZER;
				
				row3_HashRow.PETROEX_COMPONENT_PRODUCT_CODE = row3.PETROEX_COMPONENT_PRODUCT_CODE;
				
				row3_HashRow.PRODUCT_TOLERANCE_STATUS = row3.PRODUCT_TOLERANCE_STATUS;
				
				row3_HashRow.TANK_INVENTORY_UPDATED = row3.TANK_INVENTORY_UPDATED;
				
				row3_HashRow.TOTALIZER_UPDATED = row3.TOTALIZER_UPDATED;
				
				row3_HashRow.FLUSH_STATUS = row3.FLUSH_STATUS;
				
				row3_HashRow.REDUCED_PRODUCT_NUMBER = row3.REDUCED_PRODUCT_NUMBER;
				
				row3_HashRow.ADDITIVE_WEIGHT = row3.ADDITIVE_WEIGHT;
				
				row3_HashRow.PRODUCT_WEIGHT = row3.PRODUCT_WEIGHT;
				
				row3_HashRow.RT_INJECTOR_ALARM_COUNT = row3.RT_INJECTOR_ALARM_COUNT;
				
				row3_HashRow.BATCH_NUMBER = row3.BATCH_NUMBER;
				
				row3_HashRow.VRU_CODE = row3.VRU_CODE;
				
				row3_HashRow.ADDITIVE_MASKING = row3.ADDITIVE_MASKING;
				
				row3_HashRow.COMPATIBILITY_STATUS = row3.COMPATIBILITY_STATUS;
				
				row3_HashRow.RECIPE_CORRECTION_TYPE = row3.RECIPE_CORRECTION_TYPE;
				
				row3_HashRow.NON_RECIPE_GROSS_QUANTITY = row3.NON_RECIPE_GROSS_QUANTITY;
				
				row3_HashRow.NON_RECIPE_NET_QUANTITY = row3.NON_RECIPE_NET_QUANTITY;
				
				row3_HashRow.NON_RECIPE_WEIGHT = row3.NON_RECIPE_WEIGHT;
				
				row3_HashRow.WEIGHT_IN_VAC = row3.WEIGHT_IN_VAC;
				
				row3_HashRow.ADDITIVE_WEIGHT_IN_VAC = row3.ADDITIVE_WEIGHT_IN_VAC;
				
				row3_HashRow.COMMITTED_GROSS_QUANTITY = row3.COMMITTED_GROSS_QUANTITY;
				
				row3_HashRow.PRODUCT_WEIGHT_IN_VAC = row3.PRODUCT_WEIGHT_IN_VAC;
				
				row3_HashRow.COMMITTED_NET_QUANTITY = row3.COMMITTED_NET_QUANTITY;
				
				row3_HashRow.PDXR_PRODUCT_CODE = row3.PDXR_PRODUCT_CODE;
				
				row3_HashRow.PDXR_AUTHORIZATION_UNITS = row3.PDXR_AUTHORIZATION_UNITS;
				
				row3_HashRow.COMMITTED_WEIGHT_IN_VAC = row3.COMMITTED_WEIGHT_IN_VAC;
				
				row3_HashRow.COMMITTED_WEIGHT_IN_AIR = row3.COMMITTED_WEIGHT_IN_AIR;
				
				row3_HashRow.PDXR_ADDITIVE_CODE = row3.PDXR_ADDITIVE_CODE;
				
				row3_HashRow.COMMITTED_CONV_TEMPERATURE = row3.COMMITTED_CONV_TEMPERATURE;
				
				row3_HashRow.COMMITTED_CONV_DENSITY = row3.COMMITTED_CONV_DENSITY;
				
				row3_HashRow.COMMITTED_CONV_COE = row3.COMMITTED_CONV_COE;
				
				row3_HashRow.COMMITTED_CONV_PRESSURE = row3.COMMITTED_CONV_PRESSURE;
				
				row3_HashRow.MEASURED_QUANTITY_TYPE = row3.MEASURED_QUANTITY_TYPE;
				
				row3_HashRow.INVENTORY_QUANTITY_TYPE = row3.INVENTORY_QUANTITY_TYPE;
				
				row3_HashRow.DERIVED_VALUES_DIRECTIVE = row3.DERIVED_VALUES_DIRECTIVE;
				
				row3_HashRow.PRESSURE = row3.PRESSURE;
				
				row3_HashRow.METER_PRESET_CODE = row3.METER_PRESET_CODE;
				
				row3_HashRow.CALCULATE_NET = row3.CALCULATE_NET;
				
				row3_HashRow.NON_RECIPE_WEIGHT_IN_VAC = row3.NON_RECIPE_WEIGHT_IN_VAC;
				
				row3_HashRow.ADJUSTMENT_BATCH = row3.ADJUSTMENT_BATCH;
				
				row3_HashRow.COMPARTMENT_OWNER_ID = row3.COMPARTMENT_OWNER_ID;
				
				row3_HashRow.COMPARTMENT_CONTAINER_CODE = row3.COMPARTMENT_CONTAINER_CODE;
				
				row3_HashRow.COMPARTMENT_CONTAINER_TYPE = row3.COMPARTMENT_CONTAINER_TYPE;
				
				row3_HashRow.COMPARTMENT_NUMBER = row3.COMPARTMENT_NUMBER;
				
				row3_HashRow.PDXR_LOADING_REF = row3.PDXR_LOADING_REF;
				
				row3_HashRow.BLEND_CORRECTION_METHOD = row3.BLEND_CORRECTION_METHOD;
				
				row3_HashRow.BLEND_CORRECTION_NET_VOLUME = row3.BLEND_CORRECTION_NET_VOLUME;
				
				row3_HashRow.TOTAL_BATCH_BLEND_NET_VOLUME = row3.TOTAL_BATCH_BLEND_NET_VOLUME;
				
				row3_HashRow.BLEND_CORRECTION_SOURCE = row3.BLEND_CORRECTION_SOURCE;
				
				row3_HashRow.COMMODITY_GROUP = row3.COMMODITY_GROUP;
				
				row3_HashRow.DERIVATION_STATUS = row3.DERIVATION_STATUS;
				
				row3_HashRow.DERIVED_VALUES_ERROR = row3.DERIVED_VALUES_ERROR;
				
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
	 * [tDBInput_8 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_8";

	

 



/**
 * [tDBInput_8 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_8 end ] start
	 */

	

	
	
	currentComponent="tDBInput_8";

	

	}
}finally{
	if (rs_tDBInput_8 != null) {
		rs_tDBInput_8.close();
	}
	if (stmt_tDBInput_8 != null) {
		stmt_tDBInput_8.close();
	}
		if(conn_tDBInput_8 != null && !conn_tDBInput_8.isClosed()) {
			
			conn_tDBInput_8.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
		}
}
globalMap.put("tDBInput_8_NB_LINE",nb_line_tDBInput_8);

 

ok_Hash.put("tDBInput_8", true);
end_Hash.put("tDBInput_8", System.currentTimeMillis());




/**
 * [tDBInput_8 end ] stop
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
	 * [tDBInput_8 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_8";

	

 



/**
 * [tDBInput_8 finally ] stop
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
		

		globalMap.put("tDBInput_8_SUBPROCESS_STATE", 1);
	}
	


public static class row4Struct implements routines.system.IPersistableComparableLookupRow<row4Struct> {
    final static byte[] commonByteArrayLock_PGS_STAGE_FACT_SALES_SAM = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_FACT_SALES_SAM = new byte[0];
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
		final row4Struct other = (row4Struct) obj;
		
						if (this.API_CODE == null) {
							if (other.API_CODE != null)
								return false;
						
						} else if (!this.API_CODE.equals(other.API_CODE))
						
							return false;
					

		return true;
    }

	public void copyDataTo(row4Struct other) {

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

	public void copyKeysDataTo(row4Struct other) {

		other.API_CODE = this.API_CODE;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PGS_STAGE_FACT_SALES_SAM.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_FACT_SALES_SAM.length == 0) {
   					commonByteArray_PGS_STAGE_FACT_SALES_SAM = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_FACT_SALES_SAM = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PGS_STAGE_FACT_SALES_SAM, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_FACT_SALES_SAM, 0, length, utf8Charset);
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
			if(length > commonByteArray_PGS_STAGE_FACT_SALES_SAM.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_FACT_SALES_SAM.length == 0) {
   					commonByteArray_PGS_STAGE_FACT_SALES_SAM = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_FACT_SALES_SAM = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PGS_STAGE_FACT_SALES_SAM, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_FACT_SALES_SAM, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PGS_STAGE_FACT_SALES_SAM) {

        	try {

        		int length = 0;
		
					this.API_CODE = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_FACT_SALES_SAM) {

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
    public int compareTo(row4Struct other) {

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
public void tDBInput_4Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBInput_4_SUBPROCESS_STATE", 0);

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



		row4Struct row4 = new row4Struct();




	
	/**
	 * [tAdvancedHash_row4 begin ] start
	 */

	

	
		
		ok_Hash.put("tAdvancedHash_row4", false);
		start_Hash.put("tAdvancedHash_row4", System.currentTimeMillis());
		
	
	currentComponent="tAdvancedHash_row4";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row4");
					}
				
		int tos_count_tAdvancedHash_row4 = 0;
		

			   		// connection name:row4
			   		// source node:tDBInput_4 - inputs:(after_tDBInput_1) outputs:(row4,row4) | target node:tAdvancedHash_row4 - inputs:(row4) outputs:()
			   		// linked node: tMap_1 - inputs:(row1,row2,row3,row4,row5,row6,row10,row11,row7,row8,row9) outputs:(out1)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row4 = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row4Struct> tHash_Lookup_row4 =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<row4Struct>getLookup(matchingModeEnum_row4);
	   						   
		   	   	   globalMap.put("tHash_Lookup_row4", tHash_Lookup_row4);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_row4 begin ] stop
 */



	
	/**
	 * [tDBInput_4 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_4", false);
		start_Hash.put("tDBInput_4", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_4";

	
		int tos_count_tDBInput_4 = 0;
		
	
    
	
			org.talend.designer.components.util.mssql.MSSqlGenerateTimestampUtil mssqlGTU_tDBInput_4 = org.talend.designer.components.util.mssql.MSSqlUtilFactory.getMSSqlGenerateTimestampUtil();
			
			java.util.List<String> talendToDBList_tDBInput_4 = new java.util.ArrayList();
			String[] talendToDBArray_tDBInput_4  = new String[]{"FLOAT","NUMERIC","NUMERIC IDENTITY","DECIMAL","DECIMAL IDENTITY","REAL"}; 
			java.util.Collections.addAll(talendToDBList_tDBInput_4, talendToDBArray_tDBInput_4); 
		    int nb_line_tDBInput_4 = 0;
		    java.sql.Connection conn_tDBInput_4 = null;
				String driverClass_tDBInput_4 = "net.sourceforge.jtds.jdbc.Driver";
			    java.lang.Class jdbcclazz_tDBInput_4 = java.lang.Class.forName(driverClass_tDBInput_4);
				String dbUser_tDBInput_4 = "sa";
				
				 
	final String decryptedPassword_tDBInput_4 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:tkxf9cJdeJQjuXph3LlpweikAK/JZG4ePZ67uXZn4Kw6sXnyZfc=");
				
				String dbPwd_tDBInput_4 = decryptedPassword_tDBInput_4;
				
		    String port_tDBInput_4 = "1433";
		    String dbname_tDBInput_4 = "PGS_STAGE_DW" ;
			String url_tDBInput_4 = "jdbc:jtds:sqlserver://" + "LAPTOP-HED7JE2F" ;
		    if (!"".equals(port_tDBInput_4)) {
		    	url_tDBInput_4 += ":" + "1433";
		    }
		    if (!"".equals(dbname_tDBInput_4)) {
				url_tDBInput_4 += "//" + "PGS_STAGE_DW"; 
		    }
		    url_tDBInput_4 += ";appName=" + projectName + ";" + "";
		    String dbschema_tDBInput_4 = "dbo";
				
				conn_tDBInput_4 = java.sql.DriverManager.getConnection(url_tDBInput_4,dbUser_tDBInput_4,dbPwd_tDBInput_4);
		        
		    
			java.sql.Statement stmt_tDBInput_4 = conn_tDBInput_4.createStatement();

		    String dbquery_tDBInput_4 = "SELECT dbo.DIM_API.PK_API,\n		dbo.DIM_API.API_CODE,\n		dbo.DIM_API.DESCRIPTION,\n		dbo.DIM_API.USER_DEFINED,\n		dbo.DIM_API"
+".DENSITY_UNITS,\n		dbo.DIM_API.DENSITY_PRECISION,\n		dbo.DIM_API.COE_PRECISION,\n		dbo.DIM_API.WEIGHT_IN_AIR_METHOD,\n		dbo."
+"DIM_API.TEMPERATURE_UNITS,\n		dbo.DIM_API.REFERENCE_TEMPERATURE,\n		dbo.DIM_API.TEMPERATURE_PRECISION,\n		dbo.DIM_API.MAXIM"
+"UM_PRESSURE,\n		dbo.DIM_API.COMMODITY_GROUP,\n		dbo.DIM_API.DLL,\n		dbo.DIM_API.VOLUME_CORRECTION_METHOD,\n		dbo.DIM_API.VOL"
+"UME_CORRECTION_ROUTINE,\n		dbo.DIM_API.DENSITY_CORRECTION_METHOD\nFROM	dbo.DIM_API";
		    

            	globalMap.put("tDBInput_4_QUERY",dbquery_tDBInput_4);
		    java.sql.ResultSet rs_tDBInput_4 = null;

		    try {
		    	rs_tDBInput_4 = stmt_tDBInput_4.executeQuery(dbquery_tDBInput_4);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_4 = rs_tDBInput_4.getMetaData();
		    	int colQtyInRs_tDBInput_4 = rsmd_tDBInput_4.getColumnCount();

		    String tmpContent_tDBInput_4 = null;
		    
		    
		    while (rs_tDBInput_4.next()) {
		        nb_line_tDBInput_4++;
		        
							if(colQtyInRs_tDBInput_4 < 1) {
								row4.PK_API = 0;
							} else {
		                          
            row4.PK_API = rs_tDBInput_4.getInt(1);
            if(rs_tDBInput_4.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_4 < 2) {
								row4.API_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_4 = rs_tDBInput_4.getString(2);
            if(tmpContent_tDBInput_4 != null) {
            	if (talendToDBList_tDBInput_4 .contains(rsmd_tDBInput_4.getColumnTypeName(2).toUpperCase(java.util.Locale.ENGLISH))) {
            		row4.API_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_4);
            	} else {
                	row4.API_CODE = tmpContent_tDBInput_4;
                }
            } else {
                row4.API_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_4 < 3) {
								row4.DESCRIPTION = null;
							} else {
	                         		
           		tmpContent_tDBInput_4 = rs_tDBInput_4.getString(3);
            if(tmpContent_tDBInput_4 != null) {
            	if (talendToDBList_tDBInput_4 .contains(rsmd_tDBInput_4.getColumnTypeName(3).toUpperCase(java.util.Locale.ENGLISH))) {
            		row4.DESCRIPTION = FormatterUtils.formatUnwithE(tmpContent_tDBInput_4);
            	} else {
                	row4.DESCRIPTION = tmpContent_tDBInput_4;
                }
            } else {
                row4.DESCRIPTION = null;
            }
		                    }
							if(colQtyInRs_tDBInput_4 < 4) {
								row4.USER_DEFINED = 0;
							} else {
		                          
            row4.USER_DEFINED = rs_tDBInput_4.getInt(4);
            if(rs_tDBInput_4.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_4 < 5) {
								row4.DENSITY_UNITS = 0;
							} else {
		                          
            row4.DENSITY_UNITS = rs_tDBInput_4.getInt(5);
            if(rs_tDBInput_4.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_4 < 6) {
								row4.DENSITY_PRECISION = 0;
							} else {
		                          
            row4.DENSITY_PRECISION = rs_tDBInput_4.getInt(6);
            if(rs_tDBInput_4.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_4 < 7) {
								row4.COE_PRECISION = 0;
							} else {
		                          
            row4.COE_PRECISION = rs_tDBInput_4.getInt(7);
            if(rs_tDBInput_4.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_4 < 8) {
								row4.WEIGHT_IN_AIR_METHOD = 0;
							} else {
		                          
            row4.WEIGHT_IN_AIR_METHOD = rs_tDBInput_4.getInt(8);
            if(rs_tDBInput_4.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_4 < 9) {
								row4.TEMPERATURE_UNITS = 0;
							} else {
		                          
            row4.TEMPERATURE_UNITS = rs_tDBInput_4.getInt(9);
            if(rs_tDBInput_4.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_4 < 10) {
								row4.REFERENCE_TEMPERATURE = 0;
							} else {
	                         		
            row4.REFERENCE_TEMPERATURE = rs_tDBInput_4.getDouble(10);
            if(rs_tDBInput_4.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_4 < 11) {
								row4.TEMPERATURE_PRECISION = 0;
							} else {
		                          
            row4.TEMPERATURE_PRECISION = rs_tDBInput_4.getInt(11);
            if(rs_tDBInput_4.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_4 < 12) {
								row4.MAXIMUM_PRESSURE = 0;
							} else {
	                         		
            row4.MAXIMUM_PRESSURE = rs_tDBInput_4.getDouble(12);
            if(rs_tDBInput_4.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_4 < 13) {
								row4.COMMODITY_GROUP = 0;
							} else {
		                          
            row4.COMMODITY_GROUP = rs_tDBInput_4.getInt(13);
            if(rs_tDBInput_4.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_4 < 14) {
								row4.DLL = null;
							} else {
	                         		
           		tmpContent_tDBInput_4 = rs_tDBInput_4.getString(14);
            if(tmpContent_tDBInput_4 != null) {
            	if (talendToDBList_tDBInput_4 .contains(rsmd_tDBInput_4.getColumnTypeName(14).toUpperCase(java.util.Locale.ENGLISH))) {
            		row4.DLL = FormatterUtils.formatUnwithE(tmpContent_tDBInput_4);
            	} else {
                	row4.DLL = tmpContent_tDBInput_4;
                }
            } else {
                row4.DLL = null;
            }
		                    }
							if(colQtyInRs_tDBInput_4 < 15) {
								row4.VOLUME_CORRECTION_METHOD = 0;
							} else {
		                          
            row4.VOLUME_CORRECTION_METHOD = rs_tDBInput_4.getInt(15);
            if(rs_tDBInput_4.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_4 < 16) {
								row4.VOLUME_CORRECTION_ROUTINE = null;
							} else {
	                         		
           		tmpContent_tDBInput_4 = rs_tDBInput_4.getString(16);
            if(tmpContent_tDBInput_4 != null) {
            	if (talendToDBList_tDBInput_4 .contains(rsmd_tDBInput_4.getColumnTypeName(16).toUpperCase(java.util.Locale.ENGLISH))) {
            		row4.VOLUME_CORRECTION_ROUTINE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_4);
            	} else {
                	row4.VOLUME_CORRECTION_ROUTINE = tmpContent_tDBInput_4;
                }
            } else {
                row4.VOLUME_CORRECTION_ROUTINE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_4 < 17) {
								row4.DENSITY_CORRECTION_METHOD = 0;
							} else {
		                          
            row4.DENSITY_CORRECTION_METHOD = rs_tDBInput_4.getInt(17);
            if(rs_tDBInput_4.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
					





 



/**
 * [tDBInput_4 begin ] stop
 */
	
	/**
	 * [tDBInput_4 main ] start
	 */

	

	
	
	currentComponent="tDBInput_4";

	

 


	tos_count_tDBInput_4++;

/**
 * [tDBInput_4 main ] stop
 */
	
	/**
	 * [tDBInput_4 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_4";

	

 



/**
 * [tDBInput_4 process_data_begin ] stop
 */

	
	/**
	 * [tAdvancedHash_row4 main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row4";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row4"
						
						);
					}
					


			   
			   

					row4Struct row4_HashRow = new row4Struct();
		   	   	   
				
				row4_HashRow.PK_API = row4.PK_API;
				
				row4_HashRow.API_CODE = row4.API_CODE;
				
				row4_HashRow.DESCRIPTION = row4.DESCRIPTION;
				
				row4_HashRow.USER_DEFINED = row4.USER_DEFINED;
				
				row4_HashRow.DENSITY_UNITS = row4.DENSITY_UNITS;
				
				row4_HashRow.DENSITY_PRECISION = row4.DENSITY_PRECISION;
				
				row4_HashRow.COE_PRECISION = row4.COE_PRECISION;
				
				row4_HashRow.WEIGHT_IN_AIR_METHOD = row4.WEIGHT_IN_AIR_METHOD;
				
				row4_HashRow.TEMPERATURE_UNITS = row4.TEMPERATURE_UNITS;
				
				row4_HashRow.REFERENCE_TEMPERATURE = row4.REFERENCE_TEMPERATURE;
				
				row4_HashRow.TEMPERATURE_PRECISION = row4.TEMPERATURE_PRECISION;
				
				row4_HashRow.MAXIMUM_PRESSURE = row4.MAXIMUM_PRESSURE;
				
				row4_HashRow.COMMODITY_GROUP = row4.COMMODITY_GROUP;
				
				row4_HashRow.DLL = row4.DLL;
				
				row4_HashRow.VOLUME_CORRECTION_METHOD = row4.VOLUME_CORRECTION_METHOD;
				
				row4_HashRow.VOLUME_CORRECTION_ROUTINE = row4.VOLUME_CORRECTION_ROUTINE;
				
				row4_HashRow.DENSITY_CORRECTION_METHOD = row4.DENSITY_CORRECTION_METHOD;
				
			tHash_Lookup_row4.put(row4_HashRow);
			
            




 


	tos_count_tAdvancedHash_row4++;

/**
 * [tAdvancedHash_row4 main ] stop
 */
	
	/**
	 * [tAdvancedHash_row4 process_data_begin ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row4";

	

 



/**
 * [tAdvancedHash_row4 process_data_begin ] stop
 */
	
	/**
	 * [tAdvancedHash_row4 process_data_end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row4";

	

 



/**
 * [tAdvancedHash_row4 process_data_end ] stop
 */



	
	/**
	 * [tDBInput_4 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_4";

	

 



/**
 * [tDBInput_4 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_4 end ] start
	 */

	

	
	
	currentComponent="tDBInput_4";

	

	}
}finally{
	if (rs_tDBInput_4 != null) {
		rs_tDBInput_4.close();
	}
	if (stmt_tDBInput_4 != null) {
		stmt_tDBInput_4.close();
	}
		if(conn_tDBInput_4 != null && !conn_tDBInput_4.isClosed()) {
			
			conn_tDBInput_4.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
		}
}
globalMap.put("tDBInput_4_NB_LINE",nb_line_tDBInput_4);

 

ok_Hash.put("tDBInput_4", true);
end_Hash.put("tDBInput_4", System.currentTimeMillis());




/**
 * [tDBInput_4 end ] stop
 */

	
	/**
	 * [tAdvancedHash_row4 end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row4";

	

tHash_Lookup_row4.endPut();

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row4");
			  	}
			  	
 

ok_Hash.put("tAdvancedHash_row4", true);
end_Hash.put("tAdvancedHash_row4", System.currentTimeMillis());




/**
 * [tAdvancedHash_row4 end ] stop
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
	 * [tDBInput_4 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_4";

	

 



/**
 * [tDBInput_4 finally ] stop
 */

	
	/**
	 * [tAdvancedHash_row4 finally ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row4";

	

 



/**
 * [tAdvancedHash_row4 finally ] stop
 */



				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBInput_4_SUBPROCESS_STATE", 1);
	}
	


public static class row5Struct implements routines.system.IPersistableComparableLookupRow<row5Struct> {
    final static byte[] commonByteArrayLock_PGS_STAGE_FACT_SALES_SAM = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_FACT_SALES_SAM = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
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
		final row5Struct other = (row5Struct) obj;
		
						if (this.API_CODE == null) {
							if (other.API_CODE != null)
								return false;
						
						} else if (!this.API_CODE.equals(other.API_CODE))
						
							return false;
					

		return true;
    }

	public void copyDataTo(row5Struct other) {

		other.API_CODE = this.API_CODE;
	            other.DESCRIPTION = this.DESCRIPTION;
	            other.USER_DEFINED = this.USER_DEFINED;
	            other.DDE_VALUE = this.DDE_VALUE;
	            other.DENSITY_UNITS = this.DENSITY_UNITS;
	            other.PRESSURE_UNITS = this.PRESSURE_UNITS;
	            other.DENSITY_PRECISION = this.DENSITY_PRECISION;
	            other.LAST_MODIFIED = this.LAST_MODIFIED;
	            other.COE_PRECISION = this.COE_PRECISION;
	            other.DENSITY_UNITS_FACTOR = this.DENSITY_UNITS_FACTOR;
	            other.DENSITY_CORRECTION_ROUTINE = this.DENSITY_CORRECTION_ROUTINE;
	            other.WEIGHT_IN_AIR_METHOD = this.WEIGHT_IN_AIR_METHOD;
	            other.WEIGHT_IN_AIR_ROUTINE = this.WEIGHT_IN_AIR_ROUTINE;
	            other.WEIGHT_IN_AIR_FACTOR = this.WEIGHT_IN_AIR_FACTOR;
	            other.LAST_USER_NAME = this.LAST_USER_NAME;
	            other.TEMPERATURE_UNITS = this.TEMPERATURE_UNITS;
	            other.REFERENCE_TEMPERATURE = this.REFERENCE_TEMPERATURE;
	            other.TEMPERATURE_PRECISION = this.TEMPERATURE_PRECISION;
	            other.PRESSURE_PRECISION = this.PRESSURE_PRECISION;
	            other.VCF_PRECISION = this.VCF_PRECISION;
	            other.MINIMUM_TEMPERATURE = this.MINIMUM_TEMPERATURE;
	            other.MAXIMUM_TEMPERATURE = this.MAXIMUM_TEMPERATURE;
	            other.MINIMUM_PRESSURE = this.MINIMUM_PRESSURE;
	            other.MAXIMUM_PRESSURE = this.MAXIMUM_PRESSURE;
	            other.MINIMUM_BASE_DENSITY = this.MINIMUM_BASE_DENSITY;
	            other.MAXIMUM_BASE_DENSITY = this.MAXIMUM_BASE_DENSITY;
	            other.MINIMUM_OBSERVED_DENSITY = this.MINIMUM_OBSERVED_DENSITY;
	            other.MAXIMUM_OBSERVED_DENSITY = this.MAXIMUM_OBSERVED_DENSITY;
	            other.MINIMUM_COE = this.MINIMUM_COE;
	            other.MAXIMUM_COE = this.MAXIMUM_COE;
	            other.COMMODITY_GROUP = this.COMMODITY_GROUP;
	            other.DLL = this.DLL;
	            other.VOLUME_CORRECTION_METHOD = this.VOLUME_CORRECTION_METHOD;
	            other.VOLUME_CORRECTION_ROUTINE = this.VOLUME_CORRECTION_ROUTINE;
	            other.DENSITY_CORRECTION_METHOD = this.DENSITY_CORRECTION_METHOD;
	            other.DENSITY_CORRECTION_STD_API_COD = this.DENSITY_CORRECTION_STD_API_COD;
	            other.DENSITY_UNITS_ROUTINE = this.DENSITY_UNITS_ROUTINE;
	            other.INPUT_DENSITY_TEMPERATURE = this.INPUT_DENSITY_TEMPERATURE;
	            other.WEIGHT_CONVERSION_METHOD = this.WEIGHT_CONVERSION_METHOD;
	            other.WEIGHT_CONVERSION_ROUTINE = this.WEIGHT_CONVERSION_ROUTINE;
	            
	}

	public void copyKeysDataTo(row5Struct other) {

		other.API_CODE = this.API_CODE;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PGS_STAGE_FACT_SALES_SAM.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_FACT_SALES_SAM.length == 0) {
   					commonByteArray_PGS_STAGE_FACT_SALES_SAM = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_FACT_SALES_SAM = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PGS_STAGE_FACT_SALES_SAM, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_FACT_SALES_SAM, 0, length, utf8Charset);
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
			if(length > commonByteArray_PGS_STAGE_FACT_SALES_SAM.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_FACT_SALES_SAM.length == 0) {
   					commonByteArray_PGS_STAGE_FACT_SALES_SAM = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_FACT_SALES_SAM = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PGS_STAGE_FACT_SALES_SAM, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_FACT_SALES_SAM, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PGS_STAGE_FACT_SALES_SAM) {

        	try {

        		int length = 0;
		
					this.API_CODE = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_FACT_SALES_SAM) {

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
		
						this.DESCRIPTION = readString(dis,ois);
					
			            this.USER_DEFINED = dis.readInt();
					
			            this.DDE_VALUE = dis.readInt();
					
			            this.DENSITY_UNITS = dis.readInt();
					
			            this.PRESSURE_UNITS = dis.readInt();
					
			            this.DENSITY_PRECISION = dis.readInt();
					
						this.LAST_MODIFIED = readDate(dis,ois);
					
			            this.COE_PRECISION = dis.readInt();
					
			            this.DENSITY_UNITS_FACTOR = dis.readDouble();
					
						this.DENSITY_CORRECTION_ROUTINE = readString(dis,ois);
					
			            this.WEIGHT_IN_AIR_METHOD = dis.readInt();
					
						this.WEIGHT_IN_AIR_ROUTINE = readString(dis,ois);
					
			            this.WEIGHT_IN_AIR_FACTOR = dis.readDouble();
					
						this.LAST_USER_NAME = readString(dis,ois);
					
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
					
						this.DLL = readString(dis,ois);
					
			            this.VOLUME_CORRECTION_METHOD = dis.readInt();
					
						this.VOLUME_CORRECTION_ROUTINE = readString(dis,ois);
					
			            this.DENSITY_CORRECTION_METHOD = dis.readInt();
					
						this.DENSITY_CORRECTION_STD_API_COD = readString(dis,ois);
					
						this.DENSITY_UNITS_ROUTINE = readString(dis,ois);
					
			            this.INPUT_DENSITY_TEMPERATURE = dis.readDouble();
					
			            this.WEIGHT_CONVERSION_METHOD = dis.readInt();
					
						this.WEIGHT_CONVERSION_ROUTINE = readString(dis,ois);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
						this.DESCRIPTION = readString(dis,objectIn);
					
			            this.USER_DEFINED = objectIn.readInt();
					
			            this.DDE_VALUE = objectIn.readInt();
					
			            this.DENSITY_UNITS = objectIn.readInt();
					
			            this.PRESSURE_UNITS = objectIn.readInt();
					
			            this.DENSITY_PRECISION = objectIn.readInt();
					
						this.LAST_MODIFIED = readDate(dis,objectIn);
					
			            this.COE_PRECISION = objectIn.readInt();
					
			            this.DENSITY_UNITS_FACTOR = objectIn.readDouble();
					
						this.DENSITY_CORRECTION_ROUTINE = readString(dis,objectIn);
					
			            this.WEIGHT_IN_AIR_METHOD = objectIn.readInt();
					
						this.WEIGHT_IN_AIR_ROUTINE = readString(dis,objectIn);
					
			            this.WEIGHT_IN_AIR_FACTOR = objectIn.readDouble();
					
						this.LAST_USER_NAME = readString(dis,objectIn);
					
			            this.TEMPERATURE_UNITS = objectIn.readInt();
					
			            this.REFERENCE_TEMPERATURE = objectIn.readDouble();
					
			            this.TEMPERATURE_PRECISION = objectIn.readInt();
					
			            this.PRESSURE_PRECISION = objectIn.readInt();
					
			            this.VCF_PRECISION = objectIn.readInt();
					
			            this.MINIMUM_TEMPERATURE = objectIn.readDouble();
					
			            this.MAXIMUM_TEMPERATURE = objectIn.readDouble();
					
			            this.MINIMUM_PRESSURE = objectIn.readDouble();
					
			            this.MAXIMUM_PRESSURE = objectIn.readDouble();
					
			            this.MINIMUM_BASE_DENSITY = objectIn.readDouble();
					
			            this.MAXIMUM_BASE_DENSITY = objectIn.readDouble();
					
			            this.MINIMUM_OBSERVED_DENSITY = objectIn.readDouble();
					
			            this.MAXIMUM_OBSERVED_DENSITY = objectIn.readDouble();
					
			            this.MINIMUM_COE = objectIn.readDouble();
					
			            this.MAXIMUM_COE = objectIn.readDouble();
					
			            this.COMMODITY_GROUP = objectIn.readInt();
					
						this.DLL = readString(dis,objectIn);
					
			            this.VOLUME_CORRECTION_METHOD = objectIn.readInt();
					
						this.VOLUME_CORRECTION_ROUTINE = readString(dis,objectIn);
					
			            this.DENSITY_CORRECTION_METHOD = objectIn.readInt();
					
						this.DENSITY_CORRECTION_STD_API_COD = readString(dis,objectIn);
					
						this.DENSITY_UNITS_ROUTINE = readString(dis,objectIn);
					
			            this.INPUT_DENSITY_TEMPERATURE = objectIn.readDouble();
					
			            this.WEIGHT_CONVERSION_METHOD = objectIn.readInt();
					
						this.WEIGHT_CONVERSION_ROUTINE = readString(dis,objectIn);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
						writeString(this.DESCRIPTION, dos, oos);
					
		            	dos.writeInt(this.USER_DEFINED);
					
		            	dos.writeInt(this.DDE_VALUE);
					
		            	dos.writeInt(this.DENSITY_UNITS);
					
		            	dos.writeInt(this.PRESSURE_UNITS);
					
		            	dos.writeInt(this.DENSITY_PRECISION);
					
						writeDate(this.LAST_MODIFIED, dos, oos);
					
		            	dos.writeInt(this.COE_PRECISION);
					
		            	dos.writeDouble(this.DENSITY_UNITS_FACTOR);
					
						writeString(this.DENSITY_CORRECTION_ROUTINE, dos, oos);
					
		            	dos.writeInt(this.WEIGHT_IN_AIR_METHOD);
					
						writeString(this.WEIGHT_IN_AIR_ROUTINE, dos, oos);
					
		            	dos.writeDouble(this.WEIGHT_IN_AIR_FACTOR);
					
						writeString(this.LAST_USER_NAME, dos, oos);
					
		            	dos.writeInt(this.TEMPERATURE_UNITS);
					
		            	dos.writeDouble(this.REFERENCE_TEMPERATURE);
					
		            	dos.writeInt(this.TEMPERATURE_PRECISION);
					
		            	dos.writeInt(this.PRESSURE_PRECISION);
					
		            	dos.writeInt(this.VCF_PRECISION);
					
		            	dos.writeDouble(this.MINIMUM_TEMPERATURE);
					
		            	dos.writeDouble(this.MAXIMUM_TEMPERATURE);
					
		            	dos.writeDouble(this.MINIMUM_PRESSURE);
					
		            	dos.writeDouble(this.MAXIMUM_PRESSURE);
					
		            	dos.writeDouble(this.MINIMUM_BASE_DENSITY);
					
		            	dos.writeDouble(this.MAXIMUM_BASE_DENSITY);
					
		            	dos.writeDouble(this.MINIMUM_OBSERVED_DENSITY);
					
		            	dos.writeDouble(this.MAXIMUM_OBSERVED_DENSITY);
					
		            	dos.writeDouble(this.MINIMUM_COE);
					
		            	dos.writeDouble(this.MAXIMUM_COE);
					
		            	dos.writeInt(this.COMMODITY_GROUP);
					
						writeString(this.DLL, dos, oos);
					
		            	dos.writeInt(this.VOLUME_CORRECTION_METHOD);
					
						writeString(this.VOLUME_CORRECTION_ROUTINE, dos, oos);
					
		            	dos.writeInt(this.DENSITY_CORRECTION_METHOD);
					
						writeString(this.DENSITY_CORRECTION_STD_API_COD, dos, oos);
					
						writeString(this.DENSITY_UNITS_ROUTINE, dos, oos);
					
		            	dos.writeDouble(this.INPUT_DENSITY_TEMPERATURE);
					
		            	dos.writeInt(this.WEIGHT_CONVERSION_METHOD);
					
						writeString(this.WEIGHT_CONVERSION_ROUTINE, dos, oos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
						writeString(this.DESCRIPTION, dos, objectOut);
					
					objectOut.writeInt(this.USER_DEFINED);
					
					objectOut.writeInt(this.DDE_VALUE);
					
					objectOut.writeInt(this.DENSITY_UNITS);
					
					objectOut.writeInt(this.PRESSURE_UNITS);
					
					objectOut.writeInt(this.DENSITY_PRECISION);
					
						writeDate(this.LAST_MODIFIED, dos, objectOut);
					
					objectOut.writeInt(this.COE_PRECISION);
					
					objectOut.writeDouble(this.DENSITY_UNITS_FACTOR);
					
						writeString(this.DENSITY_CORRECTION_ROUTINE, dos, objectOut);
					
					objectOut.writeInt(this.WEIGHT_IN_AIR_METHOD);
					
						writeString(this.WEIGHT_IN_AIR_ROUTINE, dos, objectOut);
					
					objectOut.writeDouble(this.WEIGHT_IN_AIR_FACTOR);
					
						writeString(this.LAST_USER_NAME, dos, objectOut);
					
					objectOut.writeInt(this.TEMPERATURE_UNITS);
					
					objectOut.writeDouble(this.REFERENCE_TEMPERATURE);
					
					objectOut.writeInt(this.TEMPERATURE_PRECISION);
					
					objectOut.writeInt(this.PRESSURE_PRECISION);
					
					objectOut.writeInt(this.VCF_PRECISION);
					
					objectOut.writeDouble(this.MINIMUM_TEMPERATURE);
					
					objectOut.writeDouble(this.MAXIMUM_TEMPERATURE);
					
					objectOut.writeDouble(this.MINIMUM_PRESSURE);
					
					objectOut.writeDouble(this.MAXIMUM_PRESSURE);
					
					objectOut.writeDouble(this.MINIMUM_BASE_DENSITY);
					
					objectOut.writeDouble(this.MAXIMUM_BASE_DENSITY);
					
					objectOut.writeDouble(this.MINIMUM_OBSERVED_DENSITY);
					
					objectOut.writeDouble(this.MAXIMUM_OBSERVED_DENSITY);
					
					objectOut.writeDouble(this.MINIMUM_COE);
					
					objectOut.writeDouble(this.MAXIMUM_COE);
					
					objectOut.writeInt(this.COMMODITY_GROUP);
					
						writeString(this.DLL, dos, objectOut);
					
					objectOut.writeInt(this.VOLUME_CORRECTION_METHOD);
					
						writeString(this.VOLUME_CORRECTION_ROUTINE, dos, objectOut);
					
					objectOut.writeInt(this.DENSITY_CORRECTION_METHOD);
					
						writeString(this.DENSITY_CORRECTION_STD_API_COD, dos, objectOut);
					
						writeString(this.DENSITY_UNITS_ROUTINE, dos, objectOut);
					
					objectOut.writeDouble(this.INPUT_DENSITY_TEMPERATURE);
					
					objectOut.writeInt(this.WEIGHT_CONVERSION_METHOD);
					
						writeString(this.WEIGHT_CONVERSION_ROUTINE, dos, objectOut);
					
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
    public int compareTo(row5Struct other) {

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
public void tDBInput_9Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBInput_9_SUBPROCESS_STATE", 0);

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



		row5Struct row5 = new row5Struct();




	
	/**
	 * [tAdvancedHash_row5 begin ] start
	 */

	

	
		
		ok_Hash.put("tAdvancedHash_row5", false);
		start_Hash.put("tAdvancedHash_row5", System.currentTimeMillis());
		
	
	currentComponent="tAdvancedHash_row5";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row5");
					}
				
		int tos_count_tAdvancedHash_row5 = 0;
		

			   		// connection name:row5
			   		// source node:tDBInput_9 - inputs:(after_tDBInput_1) outputs:(row5,row5) | target node:tAdvancedHash_row5 - inputs:(row5) outputs:()
			   		// linked node: tMap_1 - inputs:(row1,row2,row3,row4,row5,row6,row10,row11,row7,row8,row9) outputs:(out1)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row5 = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row5Struct> tHash_Lookup_row5 =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<row5Struct>getLookup(matchingModeEnum_row5);
	   						   
		   	   	   globalMap.put("tHash_Lookup_row5", tHash_Lookup_row5);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_row5 begin ] stop
 */



	
	/**
	 * [tDBInput_9 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_9", false);
		start_Hash.put("tDBInput_9", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_9";

	
		int tos_count_tDBInput_9 = 0;
		
	
    
	
			org.talend.designer.components.util.mssql.MSSqlGenerateTimestampUtil mssqlGTU_tDBInput_9 = org.talend.designer.components.util.mssql.MSSqlUtilFactory.getMSSqlGenerateTimestampUtil();
			
			java.util.List<String> talendToDBList_tDBInput_9 = new java.util.ArrayList();
			String[] talendToDBArray_tDBInput_9  = new String[]{"FLOAT","NUMERIC","NUMERIC IDENTITY","DECIMAL","DECIMAL IDENTITY","REAL"}; 
			java.util.Collections.addAll(talendToDBList_tDBInput_9, talendToDBArray_tDBInput_9); 
		    int nb_line_tDBInput_9 = 0;
		    java.sql.Connection conn_tDBInput_9 = null;
				String driverClass_tDBInput_9 = "net.sourceforge.jtds.jdbc.Driver";
			    java.lang.Class jdbcclazz_tDBInput_9 = java.lang.Class.forName(driverClass_tDBInput_9);
				String dbUser_tDBInput_9 = "sa";
				
				 
	final String decryptedPassword_tDBInput_9 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:IE+HuP9MTh3JgSY9Jrdf2s+MLzwsGYJP6EM/HbFbis2DDToTHJU=");
				
				String dbPwd_tDBInput_9 = decryptedPassword_tDBInput_9;
				
		    String port_tDBInput_9 = "1433";
		    String dbname_tDBInput_9 = "FF_TEST" ;
			String url_tDBInput_9 = "jdbc:jtds:sqlserver://" + "LAPTOP-HED7JE2F" ;
		    if (!"".equals(port_tDBInput_9)) {
		    	url_tDBInput_9 += ":" + "1433";
		    }
		    if (!"".equals(dbname_tDBInput_9)) {
				url_tDBInput_9 += "//" + "FF_TEST"; 
		    }
		    url_tDBInput_9 += ";appName=" + projectName + ";" + "";
		    String dbschema_tDBInput_9 = "dbo";
				
				conn_tDBInput_9 = java.sql.DriverManager.getConnection(url_tDBInput_9,dbUser_tDBInput_9,dbPwd_tDBInput_9);
		        
		    
			java.sql.Statement stmt_tDBInput_9 = conn_tDBInput_9.createStatement();

		    String dbquery_tDBInput_9 = "SELECT dbo.API_TABLE.API_CODE,\n		dbo.API_TABLE.DESCRIPTION,\n		dbo.API_TABLE.USER_DEFINED,\n		dbo.API_TABLE.DDE_VALUE,\n		"
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
		    

            	globalMap.put("tDBInput_9_QUERY",dbquery_tDBInput_9);
		    java.sql.ResultSet rs_tDBInput_9 = null;

		    try {
		    	rs_tDBInput_9 = stmt_tDBInput_9.executeQuery(dbquery_tDBInput_9);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_9 = rs_tDBInput_9.getMetaData();
		    	int colQtyInRs_tDBInput_9 = rsmd_tDBInput_9.getColumnCount();

		    String tmpContent_tDBInput_9 = null;
		    
		    
		    while (rs_tDBInput_9.next()) {
		        nb_line_tDBInput_9++;
		        
							if(colQtyInRs_tDBInput_9 < 1) {
								row5.API_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_9 = rs_tDBInput_9.getString(1);
            if(tmpContent_tDBInput_9 != null) {
            	if (talendToDBList_tDBInput_9 .contains(rsmd_tDBInput_9.getColumnTypeName(1).toUpperCase(java.util.Locale.ENGLISH))) {
            		row5.API_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_9);
            	} else {
                	row5.API_CODE = tmpContent_tDBInput_9;
                }
            } else {
                row5.API_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_9 < 2) {
								row5.DESCRIPTION = null;
							} else {
	                         		
           		tmpContent_tDBInput_9 = rs_tDBInput_9.getString(2);
            if(tmpContent_tDBInput_9 != null) {
            	if (talendToDBList_tDBInput_9 .contains(rsmd_tDBInput_9.getColumnTypeName(2).toUpperCase(java.util.Locale.ENGLISH))) {
            		row5.DESCRIPTION = FormatterUtils.formatUnwithE(tmpContent_tDBInput_9);
            	} else {
                	row5.DESCRIPTION = tmpContent_tDBInput_9;
                }
            } else {
                row5.DESCRIPTION = null;
            }
		                    }
							if(colQtyInRs_tDBInput_9 < 3) {
								row5.USER_DEFINED = 0;
							} else {
		                          
            row5.USER_DEFINED = rs_tDBInput_9.getInt(3);
            if(rs_tDBInput_9.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_9 < 4) {
								row5.DDE_VALUE = 0;
							} else {
		                          
            row5.DDE_VALUE = rs_tDBInput_9.getInt(4);
            if(rs_tDBInput_9.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_9 < 5) {
								row5.DENSITY_UNITS = 0;
							} else {
		                          
            row5.DENSITY_UNITS = rs_tDBInput_9.getInt(5);
            if(rs_tDBInput_9.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_9 < 6) {
								row5.PRESSURE_UNITS = 0;
							} else {
		                          
            row5.PRESSURE_UNITS = rs_tDBInput_9.getInt(6);
            if(rs_tDBInput_9.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_9 < 7) {
								row5.DENSITY_PRECISION = 0;
							} else {
		                          
            row5.DENSITY_PRECISION = rs_tDBInput_9.getInt(7);
            if(rs_tDBInput_9.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_9 < 8) {
								row5.LAST_MODIFIED = null;
							} else {
										
			row5.LAST_MODIFIED = mssqlGTU_tDBInput_9.getDate(rsmd_tDBInput_9, rs_tDBInput_9, 8);
			
		                    }
							if(colQtyInRs_tDBInput_9 < 9) {
								row5.COE_PRECISION = 0;
							} else {
		                          
            row5.COE_PRECISION = rs_tDBInput_9.getInt(9);
            if(rs_tDBInput_9.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_9 < 10) {
								row5.DENSITY_UNITS_FACTOR = 0;
							} else {
	                         		
            row5.DENSITY_UNITS_FACTOR = rs_tDBInput_9.getDouble(10);
            if(rs_tDBInput_9.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_9 < 11) {
								row5.DENSITY_CORRECTION_ROUTINE = null;
							} else {
	                         		
           		tmpContent_tDBInput_9 = rs_tDBInput_9.getString(11);
            if(tmpContent_tDBInput_9 != null) {
            	if (talendToDBList_tDBInput_9 .contains(rsmd_tDBInput_9.getColumnTypeName(11).toUpperCase(java.util.Locale.ENGLISH))) {
            		row5.DENSITY_CORRECTION_ROUTINE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_9);
            	} else {
                	row5.DENSITY_CORRECTION_ROUTINE = tmpContent_tDBInput_9;
                }
            } else {
                row5.DENSITY_CORRECTION_ROUTINE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_9 < 12) {
								row5.WEIGHT_IN_AIR_METHOD = 0;
							} else {
		                          
            row5.WEIGHT_IN_AIR_METHOD = rs_tDBInput_9.getInt(12);
            if(rs_tDBInput_9.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_9 < 13) {
								row5.WEIGHT_IN_AIR_ROUTINE = null;
							} else {
	                         		
           		tmpContent_tDBInput_9 = rs_tDBInput_9.getString(13);
            if(tmpContent_tDBInput_9 != null) {
            	if (talendToDBList_tDBInput_9 .contains(rsmd_tDBInput_9.getColumnTypeName(13).toUpperCase(java.util.Locale.ENGLISH))) {
            		row5.WEIGHT_IN_AIR_ROUTINE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_9);
            	} else {
                	row5.WEIGHT_IN_AIR_ROUTINE = tmpContent_tDBInput_9;
                }
            } else {
                row5.WEIGHT_IN_AIR_ROUTINE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_9 < 14) {
								row5.WEIGHT_IN_AIR_FACTOR = 0;
							} else {
	                         		
            row5.WEIGHT_IN_AIR_FACTOR = rs_tDBInput_9.getDouble(14);
            if(rs_tDBInput_9.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_9 < 15) {
								row5.LAST_USER_NAME = null;
							} else {
	                         		
           		tmpContent_tDBInput_9 = rs_tDBInput_9.getString(15);
            if(tmpContent_tDBInput_9 != null) {
            	if (talendToDBList_tDBInput_9 .contains(rsmd_tDBInput_9.getColumnTypeName(15).toUpperCase(java.util.Locale.ENGLISH))) {
            		row5.LAST_USER_NAME = FormatterUtils.formatUnwithE(tmpContent_tDBInput_9);
            	} else {
                	row5.LAST_USER_NAME = tmpContent_tDBInput_9;
                }
            } else {
                row5.LAST_USER_NAME = null;
            }
		                    }
							if(colQtyInRs_tDBInput_9 < 16) {
								row5.TEMPERATURE_UNITS = 0;
							} else {
		                          
            row5.TEMPERATURE_UNITS = rs_tDBInput_9.getInt(16);
            if(rs_tDBInput_9.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_9 < 17) {
								row5.REFERENCE_TEMPERATURE = 0;
							} else {
	                         		
            row5.REFERENCE_TEMPERATURE = rs_tDBInput_9.getDouble(17);
            if(rs_tDBInput_9.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_9 < 18) {
								row5.TEMPERATURE_PRECISION = 0;
							} else {
		                          
            row5.TEMPERATURE_PRECISION = rs_tDBInput_9.getInt(18);
            if(rs_tDBInput_9.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_9 < 19) {
								row5.PRESSURE_PRECISION = 0;
							} else {
		                          
            row5.PRESSURE_PRECISION = rs_tDBInput_9.getInt(19);
            if(rs_tDBInput_9.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_9 < 20) {
								row5.VCF_PRECISION = 0;
							} else {
		                          
            row5.VCF_PRECISION = rs_tDBInput_9.getInt(20);
            if(rs_tDBInput_9.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_9 < 21) {
								row5.MINIMUM_TEMPERATURE = 0;
							} else {
	                         		
            row5.MINIMUM_TEMPERATURE = rs_tDBInput_9.getDouble(21);
            if(rs_tDBInput_9.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_9 < 22) {
								row5.MAXIMUM_TEMPERATURE = 0;
							} else {
	                         		
            row5.MAXIMUM_TEMPERATURE = rs_tDBInput_9.getDouble(22);
            if(rs_tDBInput_9.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_9 < 23) {
								row5.MINIMUM_PRESSURE = 0;
							} else {
	                         		
            row5.MINIMUM_PRESSURE = rs_tDBInput_9.getDouble(23);
            if(rs_tDBInput_9.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_9 < 24) {
								row5.MAXIMUM_PRESSURE = 0;
							} else {
	                         		
            row5.MAXIMUM_PRESSURE = rs_tDBInput_9.getDouble(24);
            if(rs_tDBInput_9.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_9 < 25) {
								row5.MINIMUM_BASE_DENSITY = 0;
							} else {
	                         		
            row5.MINIMUM_BASE_DENSITY = rs_tDBInput_9.getDouble(25);
            if(rs_tDBInput_9.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_9 < 26) {
								row5.MAXIMUM_BASE_DENSITY = 0;
							} else {
	                         		
            row5.MAXIMUM_BASE_DENSITY = rs_tDBInput_9.getDouble(26);
            if(rs_tDBInput_9.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_9 < 27) {
								row5.MINIMUM_OBSERVED_DENSITY = 0;
							} else {
	                         		
            row5.MINIMUM_OBSERVED_DENSITY = rs_tDBInput_9.getDouble(27);
            if(rs_tDBInput_9.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_9 < 28) {
								row5.MAXIMUM_OBSERVED_DENSITY = 0;
							} else {
	                         		
            row5.MAXIMUM_OBSERVED_DENSITY = rs_tDBInput_9.getDouble(28);
            if(rs_tDBInput_9.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_9 < 29) {
								row5.MINIMUM_COE = 0;
							} else {
	                         		
            row5.MINIMUM_COE = rs_tDBInput_9.getDouble(29);
            if(rs_tDBInput_9.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_9 < 30) {
								row5.MAXIMUM_COE = 0;
							} else {
	                         		
            row5.MAXIMUM_COE = rs_tDBInput_9.getDouble(30);
            if(rs_tDBInput_9.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_9 < 31) {
								row5.COMMODITY_GROUP = 0;
							} else {
		                          
            row5.COMMODITY_GROUP = rs_tDBInput_9.getInt(31);
            if(rs_tDBInput_9.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_9 < 32) {
								row5.DLL = null;
							} else {
	                         		
           		tmpContent_tDBInput_9 = rs_tDBInput_9.getString(32);
            if(tmpContent_tDBInput_9 != null) {
            	if (talendToDBList_tDBInput_9 .contains(rsmd_tDBInput_9.getColumnTypeName(32).toUpperCase(java.util.Locale.ENGLISH))) {
            		row5.DLL = FormatterUtils.formatUnwithE(tmpContent_tDBInput_9);
            	} else {
                	row5.DLL = tmpContent_tDBInput_9;
                }
            } else {
                row5.DLL = null;
            }
		                    }
							if(colQtyInRs_tDBInput_9 < 33) {
								row5.VOLUME_CORRECTION_METHOD = 0;
							} else {
		                          
            row5.VOLUME_CORRECTION_METHOD = rs_tDBInput_9.getInt(33);
            if(rs_tDBInput_9.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_9 < 34) {
								row5.VOLUME_CORRECTION_ROUTINE = null;
							} else {
	                         		
           		tmpContent_tDBInput_9 = rs_tDBInput_9.getString(34);
            if(tmpContent_tDBInput_9 != null) {
            	if (talendToDBList_tDBInput_9 .contains(rsmd_tDBInput_9.getColumnTypeName(34).toUpperCase(java.util.Locale.ENGLISH))) {
            		row5.VOLUME_CORRECTION_ROUTINE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_9);
            	} else {
                	row5.VOLUME_CORRECTION_ROUTINE = tmpContent_tDBInput_9;
                }
            } else {
                row5.VOLUME_CORRECTION_ROUTINE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_9 < 35) {
								row5.DENSITY_CORRECTION_METHOD = 0;
							} else {
		                          
            row5.DENSITY_CORRECTION_METHOD = rs_tDBInput_9.getInt(35);
            if(rs_tDBInput_9.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_9 < 36) {
								row5.DENSITY_CORRECTION_STD_API_COD = null;
							} else {
	                         		
           		tmpContent_tDBInput_9 = rs_tDBInput_9.getString(36);
            if(tmpContent_tDBInput_9 != null) {
            	if (talendToDBList_tDBInput_9 .contains(rsmd_tDBInput_9.getColumnTypeName(36).toUpperCase(java.util.Locale.ENGLISH))) {
            		row5.DENSITY_CORRECTION_STD_API_COD = FormatterUtils.formatUnwithE(tmpContent_tDBInput_9);
            	} else {
                	row5.DENSITY_CORRECTION_STD_API_COD = tmpContent_tDBInput_9;
                }
            } else {
                row5.DENSITY_CORRECTION_STD_API_COD = null;
            }
		                    }
							if(colQtyInRs_tDBInput_9 < 37) {
								row5.DENSITY_UNITS_ROUTINE = null;
							} else {
	                         		
           		tmpContent_tDBInput_9 = rs_tDBInput_9.getString(37);
            if(tmpContent_tDBInput_9 != null) {
            	if (talendToDBList_tDBInput_9 .contains(rsmd_tDBInput_9.getColumnTypeName(37).toUpperCase(java.util.Locale.ENGLISH))) {
            		row5.DENSITY_UNITS_ROUTINE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_9);
            	} else {
                	row5.DENSITY_UNITS_ROUTINE = tmpContent_tDBInput_9;
                }
            } else {
                row5.DENSITY_UNITS_ROUTINE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_9 < 38) {
								row5.INPUT_DENSITY_TEMPERATURE = 0;
							} else {
	                         		
            row5.INPUT_DENSITY_TEMPERATURE = rs_tDBInput_9.getDouble(38);
            if(rs_tDBInput_9.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_9 < 39) {
								row5.WEIGHT_CONVERSION_METHOD = 0;
							} else {
		                          
            row5.WEIGHT_CONVERSION_METHOD = rs_tDBInput_9.getInt(39);
            if(rs_tDBInput_9.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_9 < 40) {
								row5.WEIGHT_CONVERSION_ROUTINE = null;
							} else {
	                         		
           		tmpContent_tDBInput_9 = rs_tDBInput_9.getString(40);
            if(tmpContent_tDBInput_9 != null) {
            	if (talendToDBList_tDBInput_9 .contains(rsmd_tDBInput_9.getColumnTypeName(40).toUpperCase(java.util.Locale.ENGLISH))) {
            		row5.WEIGHT_CONVERSION_ROUTINE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_9);
            	} else {
                	row5.WEIGHT_CONVERSION_ROUTINE = tmpContent_tDBInput_9;
                }
            } else {
                row5.WEIGHT_CONVERSION_ROUTINE = null;
            }
		                    }
					





 



/**
 * [tDBInput_9 begin ] stop
 */
	
	/**
	 * [tDBInput_9 main ] start
	 */

	

	
	
	currentComponent="tDBInput_9";

	

 


	tos_count_tDBInput_9++;

/**
 * [tDBInput_9 main ] stop
 */
	
	/**
	 * [tDBInput_9 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_9";

	

 



/**
 * [tDBInput_9 process_data_begin ] stop
 */

	
	/**
	 * [tAdvancedHash_row5 main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row5";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row5"
						
						);
					}
					


			   
			   

					row5Struct row5_HashRow = new row5Struct();
		   	   	   
				
				row5_HashRow.API_CODE = row5.API_CODE;
				
				row5_HashRow.DESCRIPTION = row5.DESCRIPTION;
				
				row5_HashRow.USER_DEFINED = row5.USER_DEFINED;
				
				row5_HashRow.DDE_VALUE = row5.DDE_VALUE;
				
				row5_HashRow.DENSITY_UNITS = row5.DENSITY_UNITS;
				
				row5_HashRow.PRESSURE_UNITS = row5.PRESSURE_UNITS;
				
				row5_HashRow.DENSITY_PRECISION = row5.DENSITY_PRECISION;
				
				row5_HashRow.LAST_MODIFIED = row5.LAST_MODIFIED;
				
				row5_HashRow.COE_PRECISION = row5.COE_PRECISION;
				
				row5_HashRow.DENSITY_UNITS_FACTOR = row5.DENSITY_UNITS_FACTOR;
				
				row5_HashRow.DENSITY_CORRECTION_ROUTINE = row5.DENSITY_CORRECTION_ROUTINE;
				
				row5_HashRow.WEIGHT_IN_AIR_METHOD = row5.WEIGHT_IN_AIR_METHOD;
				
				row5_HashRow.WEIGHT_IN_AIR_ROUTINE = row5.WEIGHT_IN_AIR_ROUTINE;
				
				row5_HashRow.WEIGHT_IN_AIR_FACTOR = row5.WEIGHT_IN_AIR_FACTOR;
				
				row5_HashRow.LAST_USER_NAME = row5.LAST_USER_NAME;
				
				row5_HashRow.TEMPERATURE_UNITS = row5.TEMPERATURE_UNITS;
				
				row5_HashRow.REFERENCE_TEMPERATURE = row5.REFERENCE_TEMPERATURE;
				
				row5_HashRow.TEMPERATURE_PRECISION = row5.TEMPERATURE_PRECISION;
				
				row5_HashRow.PRESSURE_PRECISION = row5.PRESSURE_PRECISION;
				
				row5_HashRow.VCF_PRECISION = row5.VCF_PRECISION;
				
				row5_HashRow.MINIMUM_TEMPERATURE = row5.MINIMUM_TEMPERATURE;
				
				row5_HashRow.MAXIMUM_TEMPERATURE = row5.MAXIMUM_TEMPERATURE;
				
				row5_HashRow.MINIMUM_PRESSURE = row5.MINIMUM_PRESSURE;
				
				row5_HashRow.MAXIMUM_PRESSURE = row5.MAXIMUM_PRESSURE;
				
				row5_HashRow.MINIMUM_BASE_DENSITY = row5.MINIMUM_BASE_DENSITY;
				
				row5_HashRow.MAXIMUM_BASE_DENSITY = row5.MAXIMUM_BASE_DENSITY;
				
				row5_HashRow.MINIMUM_OBSERVED_DENSITY = row5.MINIMUM_OBSERVED_DENSITY;
				
				row5_HashRow.MAXIMUM_OBSERVED_DENSITY = row5.MAXIMUM_OBSERVED_DENSITY;
				
				row5_HashRow.MINIMUM_COE = row5.MINIMUM_COE;
				
				row5_HashRow.MAXIMUM_COE = row5.MAXIMUM_COE;
				
				row5_HashRow.COMMODITY_GROUP = row5.COMMODITY_GROUP;
				
				row5_HashRow.DLL = row5.DLL;
				
				row5_HashRow.VOLUME_CORRECTION_METHOD = row5.VOLUME_CORRECTION_METHOD;
				
				row5_HashRow.VOLUME_CORRECTION_ROUTINE = row5.VOLUME_CORRECTION_ROUTINE;
				
				row5_HashRow.DENSITY_CORRECTION_METHOD = row5.DENSITY_CORRECTION_METHOD;
				
				row5_HashRow.DENSITY_CORRECTION_STD_API_COD = row5.DENSITY_CORRECTION_STD_API_COD;
				
				row5_HashRow.DENSITY_UNITS_ROUTINE = row5.DENSITY_UNITS_ROUTINE;
				
				row5_HashRow.INPUT_DENSITY_TEMPERATURE = row5.INPUT_DENSITY_TEMPERATURE;
				
				row5_HashRow.WEIGHT_CONVERSION_METHOD = row5.WEIGHT_CONVERSION_METHOD;
				
				row5_HashRow.WEIGHT_CONVERSION_ROUTINE = row5.WEIGHT_CONVERSION_ROUTINE;
				
			tHash_Lookup_row5.put(row5_HashRow);
			
            




 


	tos_count_tAdvancedHash_row5++;

/**
 * [tAdvancedHash_row5 main ] stop
 */
	
	/**
	 * [tAdvancedHash_row5 process_data_begin ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row5";

	

 



/**
 * [tAdvancedHash_row5 process_data_begin ] stop
 */
	
	/**
	 * [tAdvancedHash_row5 process_data_end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row5";

	

 



/**
 * [tAdvancedHash_row5 process_data_end ] stop
 */



	
	/**
	 * [tDBInput_9 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_9";

	

 



/**
 * [tDBInput_9 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_9 end ] start
	 */

	

	
	
	currentComponent="tDBInput_9";

	

	}
}finally{
	if (rs_tDBInput_9 != null) {
		rs_tDBInput_9.close();
	}
	if (stmt_tDBInput_9 != null) {
		stmt_tDBInput_9.close();
	}
		if(conn_tDBInput_9 != null && !conn_tDBInput_9.isClosed()) {
			
			conn_tDBInput_9.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
		}
}
globalMap.put("tDBInput_9_NB_LINE",nb_line_tDBInput_9);

 

ok_Hash.put("tDBInput_9", true);
end_Hash.put("tDBInput_9", System.currentTimeMillis());




/**
 * [tDBInput_9 end ] stop
 */

	
	/**
	 * [tAdvancedHash_row5 end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row5";

	

tHash_Lookup_row5.endPut();

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row5");
			  	}
			  	
 

ok_Hash.put("tAdvancedHash_row5", true);
end_Hash.put("tAdvancedHash_row5", System.currentTimeMillis());




/**
 * [tAdvancedHash_row5 end ] stop
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
	 * [tDBInput_9 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_9";

	

 



/**
 * [tDBInput_9 finally ] stop
 */

	
	/**
	 * [tAdvancedHash_row5 finally ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row5";

	

 



/**
 * [tAdvancedHash_row5 finally ] stop
 */



				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBInput_9_SUBPROCESS_STATE", 1);
	}
	


public static class row6Struct implements routines.system.IPersistableComparableLookupRow<row6Struct> {
    final static byte[] commonByteArrayLock_PGS_STAGE_FACT_SALES_SAM = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_FACT_SALES_SAM = new byte[0];
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
		final row6Struct other = (row6Struct) obj;
		
						if (this.CUSTOMER_NUMBER != other.CUSTOMER_NUMBER)
							return false;
					

		return true;
    }

	public void copyDataTo(row6Struct other) {

		other.PK_CUSTOMER = this.PK_CUSTOMER;
	            other.SUPPLIER_NUMBER = this.SUPPLIER_NUMBER;
	            other.CUSTOMER_NUMBER = this.CUSTOMER_NUMBER;
	            other.BILLING_ADDRESS_1 = this.BILLING_ADDRESS_1;
	            other.DET_CUSTOMER_NUMBER = this.DET_CUSTOMER_NUMBER;
	            other.LAST_USER_NAME = this.LAST_USER_NAME;
	            other.LAST_MODIFIED = this.LAST_MODIFIED;
	            
	}

	public void copyKeysDataTo(row6Struct other) {

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

		synchronized(commonByteArrayLock_PGS_STAGE_FACT_SALES_SAM) {

        	try {

        		int length = 0;
		
			        this.CUSTOMER_NUMBER = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_FACT_SALES_SAM) {

        	try {

        		int length = 0;
		
			        this.CUSTOMER_NUMBER = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.CUSTOMER_NUMBER);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
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
					
			            this.SUPPLIER_NUMBER = dis.readInt();
					
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
					
			            this.SUPPLIER_NUMBER = objectIn.readInt();
					
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
					
		            	dos.writeInt(this.SUPPLIER_NUMBER);
					
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
					
					objectOut.writeInt(this.SUPPLIER_NUMBER);
					
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
    public int compareTo(row6Struct other) {

		int returnValue = -1;
		
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
public void tDBInput_3Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBInput_3_SUBPROCESS_STATE", 0);

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



		row6Struct row6 = new row6Struct();




	
	/**
	 * [tAdvancedHash_row6 begin ] start
	 */

	

	
		
		ok_Hash.put("tAdvancedHash_row6", false);
		start_Hash.put("tAdvancedHash_row6", System.currentTimeMillis());
		
	
	currentComponent="tAdvancedHash_row6";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row6");
					}
				
		int tos_count_tAdvancedHash_row6 = 0;
		

			   		// connection name:row6
			   		// source node:tDBInput_3 - inputs:(after_tDBInput_1) outputs:(row6,row6) | target node:tAdvancedHash_row6 - inputs:(row6) outputs:()
			   		// linked node: tMap_1 - inputs:(row1,row2,row3,row4,row5,row6,row10,row11,row7,row8,row9) outputs:(out1)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row6 = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row6Struct> tHash_Lookup_row6 =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<row6Struct>getLookup(matchingModeEnum_row6);
	   						   
		   	   	   globalMap.put("tHash_Lookup_row6", tHash_Lookup_row6);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_row6 begin ] stop
 */



	
	/**
	 * [tDBInput_3 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_3", false);
		start_Hash.put("tDBInput_3", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_3";

	
		int tos_count_tDBInput_3 = 0;
		
	
    
	
			org.talend.designer.components.util.mssql.MSSqlGenerateTimestampUtil mssqlGTU_tDBInput_3 = org.talend.designer.components.util.mssql.MSSqlUtilFactory.getMSSqlGenerateTimestampUtil();
			
			java.util.List<String> talendToDBList_tDBInput_3 = new java.util.ArrayList();
			String[] talendToDBArray_tDBInput_3  = new String[]{"FLOAT","NUMERIC","NUMERIC IDENTITY","DECIMAL","DECIMAL IDENTITY","REAL"}; 
			java.util.Collections.addAll(talendToDBList_tDBInput_3, talendToDBArray_tDBInput_3); 
		    int nb_line_tDBInput_3 = 0;
		    java.sql.Connection conn_tDBInput_3 = null;
				String driverClass_tDBInput_3 = "net.sourceforge.jtds.jdbc.Driver";
			    java.lang.Class jdbcclazz_tDBInput_3 = java.lang.Class.forName(driverClass_tDBInput_3);
				String dbUser_tDBInput_3 = "sa";
				
				 
	final String decryptedPassword_tDBInput_3 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:DwEphSxrWfbPi56VOhnXVTp9vJJya3MnJoOPPileGPEtuYpo4CU=");
				
				String dbPwd_tDBInput_3 = decryptedPassword_tDBInput_3;
				
		    String port_tDBInput_3 = "1433";
		    String dbname_tDBInput_3 = "PGS_STAGE_DW" ;
			String url_tDBInput_3 = "jdbc:jtds:sqlserver://" + "LAPTOP-HED7JE2F" ;
		    if (!"".equals(port_tDBInput_3)) {
		    	url_tDBInput_3 += ":" + "1433";
		    }
		    if (!"".equals(dbname_tDBInput_3)) {
				url_tDBInput_3 += "//" + "PGS_STAGE_DW"; 
		    }
		    url_tDBInput_3 += ";appName=" + projectName + ";" + "";
		    String dbschema_tDBInput_3 = "dbo";
				
				conn_tDBInput_3 = java.sql.DriverManager.getConnection(url_tDBInput_3,dbUser_tDBInput_3,dbPwd_tDBInput_3);
		        
		    
			java.sql.Statement stmt_tDBInput_3 = conn_tDBInput_3.createStatement();

		    String dbquery_tDBInput_3 = "SELECT dbo.DIM_CUSTOMER.PK_CUSTOMER,\n		dbo.DIM_CUSTOMER.SUPPLIER_NUMBER,\n		dbo.DIM_CUSTOMER.CUSTOMER_NUMBER,\n		dbo.DIM_"
+"CUSTOMER.BILLING_ADDRESS_1,\n		dbo.DIM_CUSTOMER.DET_CUSTOMER_NUMBER,\n		dbo.DIM_CUSTOMER.LAST_USER_NAME,\n		dbo.DIM_CUSTOME"
+"R.LAST_MODIFIED\nFROM	dbo.DIM_CUSTOMER";
		    

            	globalMap.put("tDBInput_3_QUERY",dbquery_tDBInput_3);
		    java.sql.ResultSet rs_tDBInput_3 = null;

		    try {
		    	rs_tDBInput_3 = stmt_tDBInput_3.executeQuery(dbquery_tDBInput_3);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_3 = rs_tDBInput_3.getMetaData();
		    	int colQtyInRs_tDBInput_3 = rsmd_tDBInput_3.getColumnCount();

		    String tmpContent_tDBInput_3 = null;
		    
		    
		    while (rs_tDBInput_3.next()) {
		        nb_line_tDBInput_3++;
		        
							if(colQtyInRs_tDBInput_3 < 1) {
								row6.PK_CUSTOMER = 0;
							} else {
		                          
            row6.PK_CUSTOMER = rs_tDBInput_3.getInt(1);
            if(rs_tDBInput_3.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 2) {
								row6.SUPPLIER_NUMBER = 0;
							} else {
		                          
            row6.SUPPLIER_NUMBER = rs_tDBInput_3.getInt(2);
            if(rs_tDBInput_3.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 3) {
								row6.CUSTOMER_NUMBER = 0;
							} else {
		                          
            row6.CUSTOMER_NUMBER = rs_tDBInput_3.getInt(3);
            if(rs_tDBInput_3.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 4) {
								row6.BILLING_ADDRESS_1 = null;
							} else {
	                         		
           		tmpContent_tDBInput_3 = rs_tDBInput_3.getString(4);
            if(tmpContent_tDBInput_3 != null) {
            	if (talendToDBList_tDBInput_3 .contains(rsmd_tDBInput_3.getColumnTypeName(4).toUpperCase(java.util.Locale.ENGLISH))) {
            		row6.BILLING_ADDRESS_1 = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
            	} else {
                	row6.BILLING_ADDRESS_1 = tmpContent_tDBInput_3;
                }
            } else {
                row6.BILLING_ADDRESS_1 = null;
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 5) {
								row6.DET_CUSTOMER_NUMBER = 0;
							} else {
		                          
            row6.DET_CUSTOMER_NUMBER = rs_tDBInput_3.getInt(5);
            if(rs_tDBInput_3.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 6) {
								row6.LAST_USER_NAME = null;
							} else {
	                         		
           		tmpContent_tDBInput_3 = rs_tDBInput_3.getString(6);
            if(tmpContent_tDBInput_3 != null) {
            	if (talendToDBList_tDBInput_3 .contains(rsmd_tDBInput_3.getColumnTypeName(6).toUpperCase(java.util.Locale.ENGLISH))) {
            		row6.LAST_USER_NAME = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
            	} else {
                	row6.LAST_USER_NAME = tmpContent_tDBInput_3;
                }
            } else {
                row6.LAST_USER_NAME = null;
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 7) {
								row6.LAST_MODIFIED = null;
							} else {
										
			row6.LAST_MODIFIED = mssqlGTU_tDBInput_3.getDate(rsmd_tDBInput_3, rs_tDBInput_3, 7);
			
		                    }
					





 



/**
 * [tDBInput_3 begin ] stop
 */
	
	/**
	 * [tDBInput_3 main ] start
	 */

	

	
	
	currentComponent="tDBInput_3";

	

 


	tos_count_tDBInput_3++;

/**
 * [tDBInput_3 main ] stop
 */
	
	/**
	 * [tDBInput_3 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_3";

	

 



/**
 * [tDBInput_3 process_data_begin ] stop
 */

	
	/**
	 * [tAdvancedHash_row6 main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row6";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row6"
						
						);
					}
					


			   
			   

					row6Struct row6_HashRow = new row6Struct();
		   	   	   
				
				row6_HashRow.PK_CUSTOMER = row6.PK_CUSTOMER;
				
				row6_HashRow.SUPPLIER_NUMBER = row6.SUPPLIER_NUMBER;
				
				row6_HashRow.CUSTOMER_NUMBER = row6.CUSTOMER_NUMBER;
				
				row6_HashRow.BILLING_ADDRESS_1 = row6.BILLING_ADDRESS_1;
				
				row6_HashRow.DET_CUSTOMER_NUMBER = row6.DET_CUSTOMER_NUMBER;
				
				row6_HashRow.LAST_USER_NAME = row6.LAST_USER_NAME;
				
				row6_HashRow.LAST_MODIFIED = row6.LAST_MODIFIED;
				
			tHash_Lookup_row6.put(row6_HashRow);
			
            




 


	tos_count_tAdvancedHash_row6++;

/**
 * [tAdvancedHash_row6 main ] stop
 */
	
	/**
	 * [tAdvancedHash_row6 process_data_begin ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row6";

	

 



/**
 * [tAdvancedHash_row6 process_data_begin ] stop
 */
	
	/**
	 * [tAdvancedHash_row6 process_data_end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row6";

	

 



/**
 * [tAdvancedHash_row6 process_data_end ] stop
 */



	
	/**
	 * [tDBInput_3 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_3";

	

 



/**
 * [tDBInput_3 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_3 end ] start
	 */

	

	
	
	currentComponent="tDBInput_3";

	

	}
}finally{
	if (rs_tDBInput_3 != null) {
		rs_tDBInput_3.close();
	}
	if (stmt_tDBInput_3 != null) {
		stmt_tDBInput_3.close();
	}
		if(conn_tDBInput_3 != null && !conn_tDBInput_3.isClosed()) {
			
			conn_tDBInput_3.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
		}
}
globalMap.put("tDBInput_3_NB_LINE",nb_line_tDBInput_3);

 

ok_Hash.put("tDBInput_3", true);
end_Hash.put("tDBInput_3", System.currentTimeMillis());




/**
 * [tDBInput_3 end ] stop
 */

	
	/**
	 * [tAdvancedHash_row6 end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row6";

	

tHash_Lookup_row6.endPut();

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row6");
			  	}
			  	
 

ok_Hash.put("tAdvancedHash_row6", true);
end_Hash.put("tAdvancedHash_row6", System.currentTimeMillis());




/**
 * [tAdvancedHash_row6 end ] stop
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
	 * [tDBInput_3 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_3";

	

 



/**
 * [tDBInput_3 finally ] stop
 */

	
	/**
	 * [tAdvancedHash_row6 finally ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row6";

	

 



/**
 * [tAdvancedHash_row6 finally ] stop
 */



				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBInput_3_SUBPROCESS_STATE", 1);
	}
	


public static class row10Struct implements routines.system.IPersistableComparableLookupRow<row10Struct> {
    final static byte[] commonByteArrayLock_PGS_STAGE_FACT_SALES_SAM = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_FACT_SALES_SAM = new byte[0];
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
		final row10Struct other = (row10Struct) obj;
		
						if (this.CARRIER_NUMBER != other.CARRIER_NUMBER)
							return false;
					
						if (this.DRIVER_NUMBER != other.DRIVER_NUMBER)
							return false;
					

		return true;
    }

	public void copyDataTo(row10Struct other) {

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

	public void copyKeysDataTo(row10Struct other) {

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

		synchronized(commonByteArrayLock_PGS_STAGE_FACT_SALES_SAM) {

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

		synchronized(commonByteArrayLock_PGS_STAGE_FACT_SALES_SAM) {

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
    public int compareTo(row10Struct other) {

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
public void tDBInput_6Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBInput_6_SUBPROCESS_STATE", 0);

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



		row10Struct row10 = new row10Struct();




	
	/**
	 * [tAdvancedHash_row10 begin ] start
	 */

	

	
		
		ok_Hash.put("tAdvancedHash_row10", false);
		start_Hash.put("tAdvancedHash_row10", System.currentTimeMillis());
		
	
	currentComponent="tAdvancedHash_row10";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row10");
					}
				
		int tos_count_tAdvancedHash_row10 = 0;
		

			   		// connection name:row10
			   		// source node:tDBInput_6 - inputs:(after_tDBInput_1) outputs:(row10,row10) | target node:tAdvancedHash_row10 - inputs:(row10) outputs:()
			   		// linked node: tMap_1 - inputs:(row1,row2,row3,row4,row5,row6,row10,row11,row7,row8,row9) outputs:(out1)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row10 = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row10Struct> tHash_Lookup_row10 =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<row10Struct>getLookup(matchingModeEnum_row10);
	   						   
		   	   	   globalMap.put("tHash_Lookup_row10", tHash_Lookup_row10);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_row10 begin ] stop
 */



	
	/**
	 * [tDBInput_6 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_6", false);
		start_Hash.put("tDBInput_6", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_6";

	
		int tos_count_tDBInput_6 = 0;
		
	
    
	
			org.talend.designer.components.util.mssql.MSSqlGenerateTimestampUtil mssqlGTU_tDBInput_6 = org.talend.designer.components.util.mssql.MSSqlUtilFactory.getMSSqlGenerateTimestampUtil();
			
			java.util.List<String> talendToDBList_tDBInput_6 = new java.util.ArrayList();
			String[] talendToDBArray_tDBInput_6  = new String[]{"FLOAT","NUMERIC","NUMERIC IDENTITY","DECIMAL","DECIMAL IDENTITY","REAL"}; 
			java.util.Collections.addAll(talendToDBList_tDBInput_6, talendToDBArray_tDBInput_6); 
		    int nb_line_tDBInput_6 = 0;
		    java.sql.Connection conn_tDBInput_6 = null;
				String driverClass_tDBInput_6 = "net.sourceforge.jtds.jdbc.Driver";
			    java.lang.Class jdbcclazz_tDBInput_6 = java.lang.Class.forName(driverClass_tDBInput_6);
				String dbUser_tDBInput_6 = "sa";
				
				 
	final String decryptedPassword_tDBInput_6 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:z4kQR95Vp7u14dIu+vaWHGAqJQ7j4kxRrswzN3cuJrJF+tCxR2A=");
				
				String dbPwd_tDBInput_6 = decryptedPassword_tDBInput_6;
				
		    String port_tDBInput_6 = "1433";
		    String dbname_tDBInput_6 = "PGS_STAGE_DW" ;
			String url_tDBInput_6 = "jdbc:jtds:sqlserver://" + "LAPTOP-HED7JE2F" ;
		    if (!"".equals(port_tDBInput_6)) {
		    	url_tDBInput_6 += ":" + "1433";
		    }
		    if (!"".equals(dbname_tDBInput_6)) {
				url_tDBInput_6 += "//" + "PGS_STAGE_DW"; 
		    }
		    url_tDBInput_6 += ";appName=" + projectName + ";" + "";
		    String dbschema_tDBInput_6 = "dbo";
				
				conn_tDBInput_6 = java.sql.DriverManager.getConnection(url_tDBInput_6,dbUser_tDBInput_6,dbPwd_tDBInput_6);
		        
		    
			java.sql.Statement stmt_tDBInput_6 = conn_tDBInput_6.createStatement();

		    String dbquery_tDBInput_6 = "SELECT dbo.DIM_DRIVER.PK_DRIVER,\n		dbo.DIM_DRIVER.RT_LAST_USED_CARRIER,\n		dbo.DIM_DRIVER.CARRIER_NUMBER,\n		dbo.DIM_DRIV"
+"ER.DRIVER_NUMBER,\n		dbo.DIM_DRIVER.NAME,\n		dbo.DIM_DRIVER.RT_LAST_USED_TRAILER,\n		dbo.DIM_DRIVER.RT_LAST_ORDER_ID,\n		dbo"
+".DIM_DRIVER.LAST_MODIFIED,\n		dbo.DIM_DRIVER.RT_HISTORICAL_ORDER_ID,\n		dbo.DIM_DRIVER.RT_CURRENT_VISIT_ID\nFROM	dbo.DIM_DR"
+"IVER";
		    

            	globalMap.put("tDBInput_6_QUERY",dbquery_tDBInput_6);
		    java.sql.ResultSet rs_tDBInput_6 = null;

		    try {
		    	rs_tDBInput_6 = stmt_tDBInput_6.executeQuery(dbquery_tDBInput_6);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_6 = rs_tDBInput_6.getMetaData();
		    	int colQtyInRs_tDBInput_6 = rsmd_tDBInput_6.getColumnCount();

		    String tmpContent_tDBInput_6 = null;
		    
		    
		    while (rs_tDBInput_6.next()) {
		        nb_line_tDBInput_6++;
		        
							if(colQtyInRs_tDBInput_6 < 1) {
								row10.PK_DRIVER = 0;
							} else {
		                          
            row10.PK_DRIVER = rs_tDBInput_6.getInt(1);
            if(rs_tDBInput_6.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_6 < 2) {
								row10.RT_LAST_USED_CARRIER = null;
							} else {
		                          
            row10.RT_LAST_USED_CARRIER = rs_tDBInput_6.getInt(2);
            if(rs_tDBInput_6.wasNull()){
                    row10.RT_LAST_USED_CARRIER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_6 < 3) {
								row10.CARRIER_NUMBER = 0;
							} else {
		                          
            row10.CARRIER_NUMBER = rs_tDBInput_6.getInt(3);
            if(rs_tDBInput_6.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_6 < 4) {
								row10.DRIVER_NUMBER = 0;
							} else {
		                          
            row10.DRIVER_NUMBER = rs_tDBInput_6.getInt(4);
            if(rs_tDBInput_6.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_6 < 5) {
								row10.NAME = null;
							} else {
	                         		
           		tmpContent_tDBInput_6 = rs_tDBInput_6.getString(5);
            if(tmpContent_tDBInput_6 != null) {
            	if (talendToDBList_tDBInput_6 .contains(rsmd_tDBInput_6.getColumnTypeName(5).toUpperCase(java.util.Locale.ENGLISH))) {
            		row10.NAME = FormatterUtils.formatUnwithE(tmpContent_tDBInput_6);
            	} else {
                	row10.NAME = tmpContent_tDBInput_6;
                }
            } else {
                row10.NAME = null;
            }
		                    }
							if(colQtyInRs_tDBInput_6 < 6) {
								row10.RT_LAST_USED_TRAILER = null;
							} else {
	                         		
           		tmpContent_tDBInput_6 = rs_tDBInput_6.getString(6);
            if(tmpContent_tDBInput_6 != null) {
            	if (talendToDBList_tDBInput_6 .contains(rsmd_tDBInput_6.getColumnTypeName(6).toUpperCase(java.util.Locale.ENGLISH))) {
            		row10.RT_LAST_USED_TRAILER = FormatterUtils.formatUnwithE(tmpContent_tDBInput_6);
            	} else {
                	row10.RT_LAST_USED_TRAILER = tmpContent_tDBInput_6;
                }
            } else {
                row10.RT_LAST_USED_TRAILER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_6 < 7) {
								row10.RT_LAST_ORDER_ID = null;
							} else {
		                          
            row10.RT_LAST_ORDER_ID = rs_tDBInput_6.getInt(7);
            if(rs_tDBInput_6.wasNull()){
                    row10.RT_LAST_ORDER_ID = null;
            }
		                    }
							if(colQtyInRs_tDBInput_6 < 8) {
								row10.LAST_MODIFIED = null;
							} else {
										
			row10.LAST_MODIFIED = mssqlGTU_tDBInput_6.getDate(rsmd_tDBInput_6, rs_tDBInput_6, 8);
			
		                    }
							if(colQtyInRs_tDBInput_6 < 9) {
								row10.RT_HISTORICAL_ORDER_ID = null;
							} else {
		                          
            row10.RT_HISTORICAL_ORDER_ID = rs_tDBInput_6.getInt(9);
            if(rs_tDBInput_6.wasNull()){
                    row10.RT_HISTORICAL_ORDER_ID = null;
            }
		                    }
							if(colQtyInRs_tDBInput_6 < 10) {
								row10.RT_CURRENT_VISIT_ID = null;
							} else {
		                          
            row10.RT_CURRENT_VISIT_ID = rs_tDBInput_6.getInt(10);
            if(rs_tDBInput_6.wasNull()){
                    row10.RT_CURRENT_VISIT_ID = null;
            }
		                    }
					





 



/**
 * [tDBInput_6 begin ] stop
 */
	
	/**
	 * [tDBInput_6 main ] start
	 */

	

	
	
	currentComponent="tDBInput_6";

	

 


	tos_count_tDBInput_6++;

/**
 * [tDBInput_6 main ] stop
 */
	
	/**
	 * [tDBInput_6 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_6";

	

 



/**
 * [tDBInput_6 process_data_begin ] stop
 */

	
	/**
	 * [tAdvancedHash_row10 main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row10";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row10"
						
						);
					}
					


			   
			   

					row10Struct row10_HashRow = new row10Struct();
		   	   	   
				
				row10_HashRow.PK_DRIVER = row10.PK_DRIVER;
				
				row10_HashRow.RT_LAST_USED_CARRIER = row10.RT_LAST_USED_CARRIER;
				
				row10_HashRow.CARRIER_NUMBER = row10.CARRIER_NUMBER;
				
				row10_HashRow.DRIVER_NUMBER = row10.DRIVER_NUMBER;
				
				row10_HashRow.NAME = row10.NAME;
				
				row10_HashRow.RT_LAST_USED_TRAILER = row10.RT_LAST_USED_TRAILER;
				
				row10_HashRow.RT_LAST_ORDER_ID = row10.RT_LAST_ORDER_ID;
				
				row10_HashRow.LAST_MODIFIED = row10.LAST_MODIFIED;
				
				row10_HashRow.RT_HISTORICAL_ORDER_ID = row10.RT_HISTORICAL_ORDER_ID;
				
				row10_HashRow.RT_CURRENT_VISIT_ID = row10.RT_CURRENT_VISIT_ID;
				
			tHash_Lookup_row10.put(row10_HashRow);
			
            




 


	tos_count_tAdvancedHash_row10++;

/**
 * [tAdvancedHash_row10 main ] stop
 */
	
	/**
	 * [tAdvancedHash_row10 process_data_begin ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row10";

	

 



/**
 * [tAdvancedHash_row10 process_data_begin ] stop
 */
	
	/**
	 * [tAdvancedHash_row10 process_data_end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row10";

	

 



/**
 * [tAdvancedHash_row10 process_data_end ] stop
 */



	
	/**
	 * [tDBInput_6 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_6";

	

 



/**
 * [tDBInput_6 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_6 end ] start
	 */

	

	
	
	currentComponent="tDBInput_6";

	

	}
}finally{
	if (rs_tDBInput_6 != null) {
		rs_tDBInput_6.close();
	}
	if (stmt_tDBInput_6 != null) {
		stmt_tDBInput_6.close();
	}
		if(conn_tDBInput_6 != null && !conn_tDBInput_6.isClosed()) {
			
			conn_tDBInput_6.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
		}
}
globalMap.put("tDBInput_6_NB_LINE",nb_line_tDBInput_6);

 

ok_Hash.put("tDBInput_6", true);
end_Hash.put("tDBInput_6", System.currentTimeMillis());




/**
 * [tDBInput_6 end ] stop
 */

	
	/**
	 * [tAdvancedHash_row10 end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row10";

	

tHash_Lookup_row10.endPut();

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row10");
			  	}
			  	
 

ok_Hash.put("tAdvancedHash_row10", true);
end_Hash.put("tAdvancedHash_row10", System.currentTimeMillis());




/**
 * [tAdvancedHash_row10 end ] stop
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
	 * [tDBInput_6 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_6";

	

 



/**
 * [tDBInput_6 finally ] stop
 */

	
	/**
	 * [tAdvancedHash_row10 finally ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row10";

	

 



/**
 * [tAdvancedHash_row10 finally ] stop
 */



				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBInput_6_SUBPROCESS_STATE", 1);
	}
	


public static class row11Struct implements routines.system.IPersistableComparableLookupRow<row11Struct> {
    final static byte[] commonByteArrayLock_PGS_STAGE_FACT_SALES_SAM = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_FACT_SALES_SAM = new byte[0];
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
	
							result = prime * result + (int) this.SUPPLIER_NUMBER;
						
						result = prime * result + ((this.PRODUCT_GROUP_CODE == null) ? 0 : this.PRODUCT_GROUP_CODE.hashCode());
					
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
		final row11Struct other = (row11Struct) obj;
		
						if (this.SUPPLIER_NUMBER != other.SUPPLIER_NUMBER)
							return false;
					
						if (this.PRODUCT_GROUP_CODE == null) {
							if (other.PRODUCT_GROUP_CODE != null)
								return false;
						
						} else if (!this.PRODUCT_GROUP_CODE.equals(other.PRODUCT_GROUP_CODE))
						
							return false;
					

		return true;
    }

	public void copyDataTo(row11Struct other) {

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

	public void copyKeysDataTo(row11Struct other) {

		other.SUPPLIER_NUMBER = this.SUPPLIER_NUMBER;
	            	other.PRODUCT_GROUP_CODE = this.PRODUCT_GROUP_CODE;
	            	
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

	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PGS_STAGE_FACT_SALES_SAM.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_FACT_SALES_SAM.length == 0) {
   					commonByteArray_PGS_STAGE_FACT_SALES_SAM = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_FACT_SALES_SAM = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PGS_STAGE_FACT_SALES_SAM, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_FACT_SALES_SAM, 0, length, utf8Charset);
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
			if(length > commonByteArray_PGS_STAGE_FACT_SALES_SAM.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_FACT_SALES_SAM.length == 0) {
   					commonByteArray_PGS_STAGE_FACT_SALES_SAM = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_FACT_SALES_SAM = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PGS_STAGE_FACT_SALES_SAM, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_FACT_SALES_SAM, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PGS_STAGE_FACT_SALES_SAM) {

        	try {

        		int length = 0;
		
			        this.SUPPLIER_NUMBER = dis.readInt();
					
					this.PRODUCT_GROUP_CODE = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_FACT_SALES_SAM) {

        	try {

        		int length = 0;
		
			        this.SUPPLIER_NUMBER = dis.readInt();
					
					this.PRODUCT_GROUP_CODE = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.SUPPLIER_NUMBER);
					
					// String
				
						writeString(this.PRODUCT_GROUP_CODE,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.SUPPLIER_NUMBER);
					
					// String
				
						writeString(this.PRODUCT_GROUP_CODE,dos);
					
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
					
						this.PRODUCT_COMMENT_SUPPLIER = readInteger(dis,ois);
					
			            this.PRODUCT_NUMBER = dis.readInt();
					
						this.NAME = readString(dis,ois);
					
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
					
						this.PRODUCT_COMMENT_SUPPLIER = readInteger(dis,objectIn);
					
			            this.PRODUCT_NUMBER = objectIn.readInt();
					
						this.NAME = readString(dis,objectIn);
					
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
					
					writeInteger(this.PRODUCT_COMMENT_SUPPLIER, dos, oos);
					
		            	dos.writeInt(this.PRODUCT_NUMBER);
					
						writeString(this.NAME, dos, oos);
					
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
					
					writeInteger(this.PRODUCT_COMMENT_SUPPLIER, dos, objectOut);
					
					objectOut.writeInt(this.PRODUCT_NUMBER);
					
						writeString(this.NAME, dos, objectOut);
					
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
    public int compareTo(row11Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.SUPPLIER_NUMBER, other.SUPPLIER_NUMBER);
						if(returnValue != 0) {
							return returnValue;
						}

					
						returnValue = checkNullsAndCompare(this.PRODUCT_GROUP_CODE, other.PRODUCT_GROUP_CODE);
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
public void tDBInput_7Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBInput_7_SUBPROCESS_STATE", 0);

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



		row11Struct row11 = new row11Struct();




	
	/**
	 * [tAdvancedHash_row11 begin ] start
	 */

	

	
		
		ok_Hash.put("tAdvancedHash_row11", false);
		start_Hash.put("tAdvancedHash_row11", System.currentTimeMillis());
		
	
	currentComponent="tAdvancedHash_row11";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row11");
					}
				
		int tos_count_tAdvancedHash_row11 = 0;
		

			   		// connection name:row11
			   		// source node:tDBInput_7 - inputs:(after_tDBInput_1) outputs:(row11,row11) | target node:tAdvancedHash_row11 - inputs:(row11) outputs:()
			   		// linked node: tMap_1 - inputs:(row1,row2,row3,row4,row5,row6,row10,row11,row7,row8,row9) outputs:(out1)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row11 = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row11Struct> tHash_Lookup_row11 =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<row11Struct>getLookup(matchingModeEnum_row11);
	   						   
		   	   	   globalMap.put("tHash_Lookup_row11", tHash_Lookup_row11);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_row11 begin ] stop
 */



	
	/**
	 * [tDBInput_7 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_7", false);
		start_Hash.put("tDBInput_7", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_7";

	
		int tos_count_tDBInput_7 = 0;
		
	
    
	
			org.talend.designer.components.util.mssql.MSSqlGenerateTimestampUtil mssqlGTU_tDBInput_7 = org.talend.designer.components.util.mssql.MSSqlUtilFactory.getMSSqlGenerateTimestampUtil();
			
			java.util.List<String> talendToDBList_tDBInput_7 = new java.util.ArrayList();
			String[] talendToDBArray_tDBInput_7  = new String[]{"FLOAT","NUMERIC","NUMERIC IDENTITY","DECIMAL","DECIMAL IDENTITY","REAL"}; 
			java.util.Collections.addAll(talendToDBList_tDBInput_7, talendToDBArray_tDBInput_7); 
		    int nb_line_tDBInput_7 = 0;
		    java.sql.Connection conn_tDBInput_7 = null;
				String driverClass_tDBInput_7 = "net.sourceforge.jtds.jdbc.Driver";
			    java.lang.Class jdbcclazz_tDBInput_7 = java.lang.Class.forName(driverClass_tDBInput_7);
				String dbUser_tDBInput_7 = "sa";
				
				 
	final String decryptedPassword_tDBInput_7 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:WN4CNEN906HOyCNo7yiiWT/bF5o1POTPLmOrc3BlH4y47Tp0ntY=");
				
				String dbPwd_tDBInput_7 = decryptedPassword_tDBInput_7;
				
		    String port_tDBInput_7 = "1433";
		    String dbname_tDBInput_7 = "PGS_STAGE_DW" ;
			String url_tDBInput_7 = "jdbc:jtds:sqlserver://" + "LAPTOP-HED7JE2F" ;
		    if (!"".equals(port_tDBInput_7)) {
		    	url_tDBInput_7 += ":" + "1433";
		    }
		    if (!"".equals(dbname_tDBInput_7)) {
				url_tDBInput_7 += "//" + "PGS_STAGE_DW"; 
		    }
		    url_tDBInput_7 += ";appName=" + projectName + ";" + "";
		    String dbschema_tDBInput_7 = "dbo";
				
				conn_tDBInput_7 = java.sql.DriverManager.getConnection(url_tDBInput_7,dbUser_tDBInput_7,dbPwd_tDBInput_7);
		        
		    
			java.sql.Statement stmt_tDBInput_7 = conn_tDBInput_7.createStatement();

		    String dbquery_tDBInput_7 = "SELECT dbo.DIM_SUPPLIER_PRODUCTS.PK_PRODUCT_SUPPLIER,\n		dbo.DIM_SUPPLIER_PRODUCTS.PRODUCT_COMMENT_SUPPLIER,\n		dbo.DIM_S"
+"UPPLIER_PRODUCTS.SUPPLIER_NUMBER,\n		dbo.DIM_SUPPLIER_PRODUCTS.PRODUCT_NUMBER,\n		dbo.DIM_SUPPLIER_PRODUCTS.NAME,\n		dbo.DI"
+"M_SUPPLIER_PRODUCTS.PRODUCT_GROUP_CODE,\n		dbo.DIM_SUPPLIER_PRODUCTS.CLEAN_FUEL,\n		dbo.DIM_SUPPLIER_PRODUCTS.ENABLED,\n		d"
+"bo.DIM_SUPPLIER_PRODUCTS.LAST_MODIFIED\nFROM	dbo.DIM_SUPPLIER_PRODUCTS";
		    

            	globalMap.put("tDBInput_7_QUERY",dbquery_tDBInput_7);
		    java.sql.ResultSet rs_tDBInput_7 = null;

		    try {
		    	rs_tDBInput_7 = stmt_tDBInput_7.executeQuery(dbquery_tDBInput_7);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_7 = rs_tDBInput_7.getMetaData();
		    	int colQtyInRs_tDBInput_7 = rsmd_tDBInput_7.getColumnCount();

		    String tmpContent_tDBInput_7 = null;
		    
		    
		    while (rs_tDBInput_7.next()) {
		        nb_line_tDBInput_7++;
		        
							if(colQtyInRs_tDBInput_7 < 1) {
								row11.PK_PRODUCT_SUPPLIER = 0;
							} else {
		                          
            row11.PK_PRODUCT_SUPPLIER = rs_tDBInput_7.getInt(1);
            if(rs_tDBInput_7.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_7 < 2) {
								row11.PRODUCT_COMMENT_SUPPLIER = null;
							} else {
		                          
            row11.PRODUCT_COMMENT_SUPPLIER = rs_tDBInput_7.getInt(2);
            if(rs_tDBInput_7.wasNull()){
                    row11.PRODUCT_COMMENT_SUPPLIER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_7 < 3) {
								row11.SUPPLIER_NUMBER = 0;
							} else {
		                          
            row11.SUPPLIER_NUMBER = rs_tDBInput_7.getInt(3);
            if(rs_tDBInput_7.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_7 < 4) {
								row11.PRODUCT_NUMBER = 0;
							} else {
		                          
            row11.PRODUCT_NUMBER = rs_tDBInput_7.getInt(4);
            if(rs_tDBInput_7.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_7 < 5) {
								row11.NAME = null;
							} else {
	                         		
           		tmpContent_tDBInput_7 = rs_tDBInput_7.getString(5);
            if(tmpContent_tDBInput_7 != null) {
            	if (talendToDBList_tDBInput_7 .contains(rsmd_tDBInput_7.getColumnTypeName(5).toUpperCase(java.util.Locale.ENGLISH))) {
            		row11.NAME = FormatterUtils.formatUnwithE(tmpContent_tDBInput_7);
            	} else {
                	row11.NAME = tmpContent_tDBInput_7;
                }
            } else {
                row11.NAME = null;
            }
		                    }
							if(colQtyInRs_tDBInput_7 < 6) {
								row11.PRODUCT_GROUP_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_7 = rs_tDBInput_7.getString(6);
            if(tmpContent_tDBInput_7 != null) {
            	if (talendToDBList_tDBInput_7 .contains(rsmd_tDBInput_7.getColumnTypeName(6).toUpperCase(java.util.Locale.ENGLISH))) {
            		row11.PRODUCT_GROUP_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_7);
            	} else {
                	row11.PRODUCT_GROUP_CODE = tmpContent_tDBInput_7;
                }
            } else {
                row11.PRODUCT_GROUP_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_7 < 7) {
								row11.CLEAN_FUEL = 0;
							} else {
		                          
            row11.CLEAN_FUEL = rs_tDBInput_7.getInt(7);
            if(rs_tDBInput_7.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_7 < 8) {
								row11.ENABLED = 0;
							} else {
		                          
            row11.ENABLED = rs_tDBInput_7.getInt(8);
            if(rs_tDBInput_7.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_7 < 9) {
								row11.LAST_MODIFIED = null;
							} else {
										
			row11.LAST_MODIFIED = mssqlGTU_tDBInput_7.getDate(rsmd_tDBInput_7, rs_tDBInput_7, 9);
			
		                    }
					





 



/**
 * [tDBInput_7 begin ] stop
 */
	
	/**
	 * [tDBInput_7 main ] start
	 */

	

	
	
	currentComponent="tDBInput_7";

	

 


	tos_count_tDBInput_7++;

/**
 * [tDBInput_7 main ] stop
 */
	
	/**
	 * [tDBInput_7 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_7";

	

 



/**
 * [tDBInput_7 process_data_begin ] stop
 */

	
	/**
	 * [tAdvancedHash_row11 main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row11";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row11"
						
						);
					}
					


			   
			   

					row11Struct row11_HashRow = new row11Struct();
		   	   	   
				
				row11_HashRow.PK_PRODUCT_SUPPLIER = row11.PK_PRODUCT_SUPPLIER;
				
				row11_HashRow.PRODUCT_COMMENT_SUPPLIER = row11.PRODUCT_COMMENT_SUPPLIER;
				
				row11_HashRow.SUPPLIER_NUMBER = row11.SUPPLIER_NUMBER;
				
				row11_HashRow.PRODUCT_NUMBER = row11.PRODUCT_NUMBER;
				
				row11_HashRow.NAME = row11.NAME;
				
				row11_HashRow.PRODUCT_GROUP_CODE = row11.PRODUCT_GROUP_CODE;
				
				row11_HashRow.CLEAN_FUEL = row11.CLEAN_FUEL;
				
				row11_HashRow.ENABLED = row11.ENABLED;
				
				row11_HashRow.LAST_MODIFIED = row11.LAST_MODIFIED;
				
			tHash_Lookup_row11.put(row11_HashRow);
			
            




 


	tos_count_tAdvancedHash_row11++;

/**
 * [tAdvancedHash_row11 main ] stop
 */
	
	/**
	 * [tAdvancedHash_row11 process_data_begin ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row11";

	

 



/**
 * [tAdvancedHash_row11 process_data_begin ] stop
 */
	
	/**
	 * [tAdvancedHash_row11 process_data_end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row11";

	

 



/**
 * [tAdvancedHash_row11 process_data_end ] stop
 */



	
	/**
	 * [tDBInput_7 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_7";

	

 



/**
 * [tDBInput_7 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_7 end ] start
	 */

	

	
	
	currentComponent="tDBInput_7";

	

	}
}finally{
	if (rs_tDBInput_7 != null) {
		rs_tDBInput_7.close();
	}
	if (stmt_tDBInput_7 != null) {
		stmt_tDBInput_7.close();
	}
		if(conn_tDBInput_7 != null && !conn_tDBInput_7.isClosed()) {
			
			conn_tDBInput_7.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
		}
}
globalMap.put("tDBInput_7_NB_LINE",nb_line_tDBInput_7);

 

ok_Hash.put("tDBInput_7", true);
end_Hash.put("tDBInput_7", System.currentTimeMillis());




/**
 * [tDBInput_7 end ] stop
 */

	
	/**
	 * [tAdvancedHash_row11 end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row11";

	

tHash_Lookup_row11.endPut();

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row11");
			  	}
			  	
 

ok_Hash.put("tAdvancedHash_row11", true);
end_Hash.put("tAdvancedHash_row11", System.currentTimeMillis());




/**
 * [tAdvancedHash_row11 end ] stop
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
	 * [tDBInput_7 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_7";

	

 



/**
 * [tDBInput_7 finally ] stop
 */

	
	/**
	 * [tAdvancedHash_row11 finally ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row11";

	

 



/**
 * [tAdvancedHash_row11 finally ] stop
 */



				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBInput_7_SUBPROCESS_STATE", 1);
	}
	


public static class row7Struct implements routines.system.IPersistableComparableLookupRow<row7Struct> {
    final static byte[] commonByteArrayLock_PGS_STAGE_FACT_SALES_SAM = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_FACT_SALES_SAM = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public int PK_ORDER_TRAILER;

				public int getPK_ORDER_TRAILER () {
					return this.PK_ORDER_TRAILER;
				}
				
			    public int ORDER_ID;

				public int getORDER_ID () {
					return this.ORDER_ID;
				}
				
			    public int CARRIER_NUMBER;

				public int getCARRIER_NUMBER () {
					return this.CARRIER_NUMBER;
				}
				
			    public String TRAILER_CODE;

				public String getTRAILER_CODE () {
					return this.TRAILER_CODE;
				}
				
			    public int LOADING_SEQUENCE_NUMBER;

				public int getLOADING_SEQUENCE_NUMBER () {
					return this.LOADING_SEQUENCE_NUMBER;
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
		final row7Struct other = (row7Struct) obj;
		
						if (this.ORDER_ID != other.ORDER_ID)
							return false;
					

		return true;
    }

	public void copyDataTo(row7Struct other) {

		other.PK_ORDER_TRAILER = this.PK_ORDER_TRAILER;
	            other.ORDER_ID = this.ORDER_ID;
	            other.CARRIER_NUMBER = this.CARRIER_NUMBER;
	            other.TRAILER_CODE = this.TRAILER_CODE;
	            other.LOADING_SEQUENCE_NUMBER = this.LOADING_SEQUENCE_NUMBER;
	            
	}

	public void copyKeysDataTo(row7Struct other) {

		other.ORDER_ID = this.ORDER_ID;
	            	
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

		synchronized(commonByteArrayLock_PGS_STAGE_FACT_SALES_SAM) {

        	try {

        		int length = 0;
		
			        this.ORDER_ID = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_FACT_SALES_SAM) {

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
		
			            this.PK_ORDER_TRAILER = dis.readInt();
					
			            this.CARRIER_NUMBER = dis.readInt();
					
						this.TRAILER_CODE = readString(dis,ois);
					
			            this.LOADING_SEQUENCE_NUMBER = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
			            this.PK_ORDER_TRAILER = objectIn.readInt();
					
			            this.CARRIER_NUMBER = objectIn.readInt();
					
						this.TRAILER_CODE = readString(dis,objectIn);
					
			            this.LOADING_SEQUENCE_NUMBER = objectIn.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
		            	dos.writeInt(this.PK_ORDER_TRAILER);
					
		            	dos.writeInt(this.CARRIER_NUMBER);
					
						writeString(this.TRAILER_CODE, dos, oos);
					
		            	dos.writeInt(this.LOADING_SEQUENCE_NUMBER);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
					objectOut.writeInt(this.PK_ORDER_TRAILER);
					
					objectOut.writeInt(this.CARRIER_NUMBER);
					
						writeString(this.TRAILER_CODE, dos, objectOut);
					
					objectOut.writeInt(this.LOADING_SEQUENCE_NUMBER);
					
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
		sb.append("PK_ORDER_TRAILER="+String.valueOf(PK_ORDER_TRAILER));
		sb.append(",ORDER_ID="+String.valueOf(ORDER_ID));
		sb.append(",CARRIER_NUMBER="+String.valueOf(CARRIER_NUMBER));
		sb.append(",TRAILER_CODE="+TRAILER_CODE);
		sb.append(",LOADING_SEQUENCE_NUMBER="+String.valueOf(LOADING_SEQUENCE_NUMBER));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row7Struct other) {

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
public void tDBInput_5Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBInput_5_SUBPROCESS_STATE", 0);

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



		row7Struct row7 = new row7Struct();




	
	/**
	 * [tAdvancedHash_row7 begin ] start
	 */

	

	
		
		ok_Hash.put("tAdvancedHash_row7", false);
		start_Hash.put("tAdvancedHash_row7", System.currentTimeMillis());
		
	
	currentComponent="tAdvancedHash_row7";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row7");
					}
				
		int tos_count_tAdvancedHash_row7 = 0;
		

			   		// connection name:row7
			   		// source node:tDBInput_5 - inputs:(after_tDBInput_1) outputs:(row7,row7) | target node:tAdvancedHash_row7 - inputs:(row7) outputs:()
			   		// linked node: tMap_1 - inputs:(row1,row2,row3,row4,row5,row6,row10,row11,row7,row8,row9) outputs:(out1)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row7 = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row7Struct> tHash_Lookup_row7 =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<row7Struct>getLookup(matchingModeEnum_row7);
	   						   
		   	   	   globalMap.put("tHash_Lookup_row7", tHash_Lookup_row7);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_row7 begin ] stop
 */



	
	/**
	 * [tDBInput_5 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_5", false);
		start_Hash.put("tDBInput_5", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_5";

	
		int tos_count_tDBInput_5 = 0;
		
	
    
	
			org.talend.designer.components.util.mssql.MSSqlGenerateTimestampUtil mssqlGTU_tDBInput_5 = org.talend.designer.components.util.mssql.MSSqlUtilFactory.getMSSqlGenerateTimestampUtil();
			
			java.util.List<String> talendToDBList_tDBInput_5 = new java.util.ArrayList();
			String[] talendToDBArray_tDBInput_5  = new String[]{"FLOAT","NUMERIC","NUMERIC IDENTITY","DECIMAL","DECIMAL IDENTITY","REAL"}; 
			java.util.Collections.addAll(talendToDBList_tDBInput_5, talendToDBArray_tDBInput_5); 
		    int nb_line_tDBInput_5 = 0;
		    java.sql.Connection conn_tDBInput_5 = null;
				String driverClass_tDBInput_5 = "net.sourceforge.jtds.jdbc.Driver";
			    java.lang.Class jdbcclazz_tDBInput_5 = java.lang.Class.forName(driverClass_tDBInput_5);
				String dbUser_tDBInput_5 = "sa";
				
				 
	final String decryptedPassword_tDBInput_5 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:Th7jtKi/08XjNjOZVRS2EfNGT4+JxhS3TdoT0oUlyMT83Wmvct0=");
				
				String dbPwd_tDBInput_5 = decryptedPassword_tDBInput_5;
				
		    String port_tDBInput_5 = "1433";
		    String dbname_tDBInput_5 = "PGS_STAGE_DW" ;
			String url_tDBInput_5 = "jdbc:jtds:sqlserver://" + "LAPTOP-HED7JE2F" ;
		    if (!"".equals(port_tDBInput_5)) {
		    	url_tDBInput_5 += ":" + "1433";
		    }
		    if (!"".equals(dbname_tDBInput_5)) {
				url_tDBInput_5 += "//" + "PGS_STAGE_DW"; 
		    }
		    url_tDBInput_5 += ";appName=" + projectName + ";" + "";
		    String dbschema_tDBInput_5 = "dbo";
				
				conn_tDBInput_5 = java.sql.DriverManager.getConnection(url_tDBInput_5,dbUser_tDBInput_5,dbPwd_tDBInput_5);
		        
		    
			java.sql.Statement stmt_tDBInput_5 = conn_tDBInput_5.createStatement();

		    String dbquery_tDBInput_5 = "SELECT dbo.DIM_ORDER_TRAILER.PK_ORDER_TRAILER,\n		dbo.DIM_ORDER_TRAILER.ORDER_ID,\n		dbo.DIM_ORDER_TRAILER.CARRIER_NUMBER"
+",\n		dbo.DIM_ORDER_TRAILER.TRAILER_CODE,\n		dbo.DIM_ORDER_TRAILER.LOADING_SEQUENCE_NUMBER\nFROM	dbo.DIM_ORDER_TRAILER";
		    

            	globalMap.put("tDBInput_5_QUERY",dbquery_tDBInput_5);
		    java.sql.ResultSet rs_tDBInput_5 = null;

		    try {
		    	rs_tDBInput_5 = stmt_tDBInput_5.executeQuery(dbquery_tDBInput_5);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_5 = rs_tDBInput_5.getMetaData();
		    	int colQtyInRs_tDBInput_5 = rsmd_tDBInput_5.getColumnCount();

		    String tmpContent_tDBInput_5 = null;
		    
		    
		    while (rs_tDBInput_5.next()) {
		        nb_line_tDBInput_5++;
		        
							if(colQtyInRs_tDBInput_5 < 1) {
								row7.PK_ORDER_TRAILER = 0;
							} else {
		                          
            row7.PK_ORDER_TRAILER = rs_tDBInput_5.getInt(1);
            if(rs_tDBInput_5.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_5 < 2) {
								row7.ORDER_ID = 0;
							} else {
		                          
            row7.ORDER_ID = rs_tDBInput_5.getInt(2);
            if(rs_tDBInput_5.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_5 < 3) {
								row7.CARRIER_NUMBER = 0;
							} else {
		                          
            row7.CARRIER_NUMBER = rs_tDBInput_5.getInt(3);
            if(rs_tDBInput_5.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_5 < 4) {
								row7.TRAILER_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_5 = rs_tDBInput_5.getString(4);
            if(tmpContent_tDBInput_5 != null) {
            	if (talendToDBList_tDBInput_5 .contains(rsmd_tDBInput_5.getColumnTypeName(4).toUpperCase(java.util.Locale.ENGLISH))) {
            		row7.TRAILER_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_5);
            	} else {
                	row7.TRAILER_CODE = tmpContent_tDBInput_5;
                }
            } else {
                row7.TRAILER_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_5 < 5) {
								row7.LOADING_SEQUENCE_NUMBER = 0;
							} else {
		                          
            row7.LOADING_SEQUENCE_NUMBER = rs_tDBInput_5.getInt(5);
            if(rs_tDBInput_5.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
					





 



/**
 * [tDBInput_5 begin ] stop
 */
	
	/**
	 * [tDBInput_5 main ] start
	 */

	

	
	
	currentComponent="tDBInput_5";

	

 


	tos_count_tDBInput_5++;

/**
 * [tDBInput_5 main ] stop
 */
	
	/**
	 * [tDBInput_5 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_5";

	

 



/**
 * [tDBInput_5 process_data_begin ] stop
 */

	
	/**
	 * [tAdvancedHash_row7 main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row7";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row7"
						
						);
					}
					


			   
			   

					row7Struct row7_HashRow = new row7Struct();
		   	   	   
				
				row7_HashRow.PK_ORDER_TRAILER = row7.PK_ORDER_TRAILER;
				
				row7_HashRow.ORDER_ID = row7.ORDER_ID;
				
				row7_HashRow.CARRIER_NUMBER = row7.CARRIER_NUMBER;
				
				row7_HashRow.TRAILER_CODE = row7.TRAILER_CODE;
				
				row7_HashRow.LOADING_SEQUENCE_NUMBER = row7.LOADING_SEQUENCE_NUMBER;
				
			tHash_Lookup_row7.put(row7_HashRow);
			
            




 


	tos_count_tAdvancedHash_row7++;

/**
 * [tAdvancedHash_row7 main ] stop
 */
	
	/**
	 * [tAdvancedHash_row7 process_data_begin ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row7";

	

 



/**
 * [tAdvancedHash_row7 process_data_begin ] stop
 */
	
	/**
	 * [tAdvancedHash_row7 process_data_end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row7";

	

 



/**
 * [tAdvancedHash_row7 process_data_end ] stop
 */



	
	/**
	 * [tDBInput_5 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_5";

	

 



/**
 * [tDBInput_5 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_5 end ] start
	 */

	

	
	
	currentComponent="tDBInput_5";

	

	}
}finally{
	if (rs_tDBInput_5 != null) {
		rs_tDBInput_5.close();
	}
	if (stmt_tDBInput_5 != null) {
		stmt_tDBInput_5.close();
	}
		if(conn_tDBInput_5 != null && !conn_tDBInput_5.isClosed()) {
			
			conn_tDBInput_5.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
		}
}
globalMap.put("tDBInput_5_NB_LINE",nb_line_tDBInput_5);

 

ok_Hash.put("tDBInput_5", true);
end_Hash.put("tDBInput_5", System.currentTimeMillis());




/**
 * [tDBInput_5 end ] stop
 */

	
	/**
	 * [tAdvancedHash_row7 end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row7";

	

tHash_Lookup_row7.endPut();

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row7");
			  	}
			  	
 

ok_Hash.put("tAdvancedHash_row7", true);
end_Hash.put("tAdvancedHash_row7", System.currentTimeMillis());




/**
 * [tAdvancedHash_row7 end ] stop
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
	 * [tDBInput_5 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_5";

	

 



/**
 * [tDBInput_5 finally ] stop
 */

	
	/**
	 * [tAdvancedHash_row7 finally ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row7";

	

 



/**
 * [tAdvancedHash_row7 finally ] stop
 */



				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBInput_5_SUBPROCESS_STATE", 1);
	}
	


public static class row8Struct implements routines.system.IPersistableComparableLookupRow<row8Struct> {
    final static byte[] commonByteArrayLock_PGS_STAGE_FACT_SALES_SAM = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_FACT_SALES_SAM = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public int PK_TRAILER;

				public int getPK_TRAILER () {
					return this.PK_TRAILER;
				}
				
			    public int CARRIER_NUMBER;

				public int getCARRIER_NUMBER () {
					return this.CARRIER_NUMBER;
				}
				
			    public String TRAILER_CODE;

				public String getTRAILER_CODE () {
					return this.TRAILER_CODE;
				}
				
			    public String SERIAL_NUMBER;

				public String getSERIAL_NUMBER () {
					return this.SERIAL_NUMBER;
				}
				
			    public Integer RT_LAST_ORDER_ID;

				public Integer getRT_LAST_ORDER_ID () {
					return this.RT_LAST_ORDER_ID;
				}
				
			    public int ENTER_TERMINAL;

				public int getENTER_TERMINAL () {
					return this.ENTER_TERMINAL;
				}
				
			    public java.util.Date LAST_MODIFIED;

				public java.util.Date getLAST_MODIFIED () {
					return this.LAST_MODIFIED;
				}
				
			    public Integer LOADING_TYPE;

				public Integer getLOADING_TYPE () {
					return this.LOADING_TYPE;
				}
				
			    public int REPEAT_ORDER_ID;

				public int getREPEAT_ORDER_ID () {
					return this.REPEAT_ORDER_ID;
				}
				
			    public Integer RT_CURRENT_VISIT_ID;

				public Integer getRT_CURRENT_VISIT_ID () {
					return this.RT_CURRENT_VISIT_ID;
				}
				
			    public int GLOBAL_LOCKOUT_TERMINAL_ID;

				public int getGLOBAL_LOCKOUT_TERMINAL_ID () {
					return this.GLOBAL_LOCKOUT_TERMINAL_ID;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
							result = prime * result + (int) this.CARRIER_NUMBER;
						
						result = prime * result + ((this.TRAILER_CODE == null) ? 0 : this.TRAILER_CODE.hashCode());
					
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
		final row8Struct other = (row8Struct) obj;
		
						if (this.CARRIER_NUMBER != other.CARRIER_NUMBER)
							return false;
					
						if (this.TRAILER_CODE == null) {
							if (other.TRAILER_CODE != null)
								return false;
						
						} else if (!this.TRAILER_CODE.equals(other.TRAILER_CODE))
						
							return false;
					

		return true;
    }

	public void copyDataTo(row8Struct other) {

		other.PK_TRAILER = this.PK_TRAILER;
	            other.CARRIER_NUMBER = this.CARRIER_NUMBER;
	            other.TRAILER_CODE = this.TRAILER_CODE;
	            other.SERIAL_NUMBER = this.SERIAL_NUMBER;
	            other.RT_LAST_ORDER_ID = this.RT_LAST_ORDER_ID;
	            other.ENTER_TERMINAL = this.ENTER_TERMINAL;
	            other.LAST_MODIFIED = this.LAST_MODIFIED;
	            other.LOADING_TYPE = this.LOADING_TYPE;
	            other.REPEAT_ORDER_ID = this.REPEAT_ORDER_ID;
	            other.RT_CURRENT_VISIT_ID = this.RT_CURRENT_VISIT_ID;
	            other.GLOBAL_LOCKOUT_TERMINAL_ID = this.GLOBAL_LOCKOUT_TERMINAL_ID;
	            
	}

	public void copyKeysDataTo(row8Struct other) {

		other.CARRIER_NUMBER = this.CARRIER_NUMBER;
	            	other.TRAILER_CODE = this.TRAILER_CODE;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PGS_STAGE_FACT_SALES_SAM.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_FACT_SALES_SAM.length == 0) {
   					commonByteArray_PGS_STAGE_FACT_SALES_SAM = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_FACT_SALES_SAM = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PGS_STAGE_FACT_SALES_SAM, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_FACT_SALES_SAM, 0, length, utf8Charset);
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
			if(length > commonByteArray_PGS_STAGE_FACT_SALES_SAM.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_FACT_SALES_SAM.length == 0) {
   					commonByteArray_PGS_STAGE_FACT_SALES_SAM = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_FACT_SALES_SAM = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PGS_STAGE_FACT_SALES_SAM, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_FACT_SALES_SAM, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PGS_STAGE_FACT_SALES_SAM) {

        	try {

        		int length = 0;
		
			        this.CARRIER_NUMBER = dis.readInt();
					
					this.TRAILER_CODE = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_FACT_SALES_SAM) {

        	try {

        		int length = 0;
		
			        this.CARRIER_NUMBER = dis.readInt();
					
					this.TRAILER_CODE = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.CARRIER_NUMBER);
					
					// String
				
						writeString(this.TRAILER_CODE,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.CARRIER_NUMBER);
					
					// String
				
						writeString(this.TRAILER_CODE,dos);
					
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
		
			            this.PK_TRAILER = dis.readInt();
					
						this.SERIAL_NUMBER = readString(dis,ois);
					
						this.RT_LAST_ORDER_ID = readInteger(dis,ois);
					
			            this.ENTER_TERMINAL = dis.readInt();
					
						this.LAST_MODIFIED = readDate(dis,ois);
					
						this.LOADING_TYPE = readInteger(dis,ois);
					
			            this.REPEAT_ORDER_ID = dis.readInt();
					
						this.RT_CURRENT_VISIT_ID = readInteger(dis,ois);
					
			            this.GLOBAL_LOCKOUT_TERMINAL_ID = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
			            this.PK_TRAILER = objectIn.readInt();
					
						this.SERIAL_NUMBER = readString(dis,objectIn);
					
						this.RT_LAST_ORDER_ID = readInteger(dis,objectIn);
					
			            this.ENTER_TERMINAL = objectIn.readInt();
					
						this.LAST_MODIFIED = readDate(dis,objectIn);
					
						this.LOADING_TYPE = readInteger(dis,objectIn);
					
			            this.REPEAT_ORDER_ID = objectIn.readInt();
					
						this.RT_CURRENT_VISIT_ID = readInteger(dis,objectIn);
					
			            this.GLOBAL_LOCKOUT_TERMINAL_ID = objectIn.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
		            	dos.writeInt(this.PK_TRAILER);
					
						writeString(this.SERIAL_NUMBER, dos, oos);
					
					writeInteger(this.RT_LAST_ORDER_ID, dos, oos);
					
		            	dos.writeInt(this.ENTER_TERMINAL);
					
						writeDate(this.LAST_MODIFIED, dos, oos);
					
					writeInteger(this.LOADING_TYPE, dos, oos);
					
		            	dos.writeInt(this.REPEAT_ORDER_ID);
					
					writeInteger(this.RT_CURRENT_VISIT_ID, dos, oos);
					
		            	dos.writeInt(this.GLOBAL_LOCKOUT_TERMINAL_ID);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
					objectOut.writeInt(this.PK_TRAILER);
					
						writeString(this.SERIAL_NUMBER, dos, objectOut);
					
					writeInteger(this.RT_LAST_ORDER_ID, dos, objectOut);
					
					objectOut.writeInt(this.ENTER_TERMINAL);
					
						writeDate(this.LAST_MODIFIED, dos, objectOut);
					
					writeInteger(this.LOADING_TYPE, dos, objectOut);
					
					objectOut.writeInt(this.REPEAT_ORDER_ID);
					
					writeInteger(this.RT_CURRENT_VISIT_ID, dos, objectOut);
					
					objectOut.writeInt(this.GLOBAL_LOCKOUT_TERMINAL_ID);
					
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
		sb.append("PK_TRAILER="+String.valueOf(PK_TRAILER));
		sb.append(",CARRIER_NUMBER="+String.valueOf(CARRIER_NUMBER));
		sb.append(",TRAILER_CODE="+TRAILER_CODE);
		sb.append(",SERIAL_NUMBER="+SERIAL_NUMBER);
		sb.append(",RT_LAST_ORDER_ID="+String.valueOf(RT_LAST_ORDER_ID));
		sb.append(",ENTER_TERMINAL="+String.valueOf(ENTER_TERMINAL));
		sb.append(",LAST_MODIFIED="+String.valueOf(LAST_MODIFIED));
		sb.append(",LOADING_TYPE="+String.valueOf(LOADING_TYPE));
		sb.append(",REPEAT_ORDER_ID="+String.valueOf(REPEAT_ORDER_ID));
		sb.append(",RT_CURRENT_VISIT_ID="+String.valueOf(RT_CURRENT_VISIT_ID));
		sb.append(",GLOBAL_LOCKOUT_TERMINAL_ID="+String.valueOf(GLOBAL_LOCKOUT_TERMINAL_ID));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row8Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.CARRIER_NUMBER, other.CARRIER_NUMBER);
						if(returnValue != 0) {
							return returnValue;
						}

					
						returnValue = checkNullsAndCompare(this.TRAILER_CODE, other.TRAILER_CODE);
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
public void tDBInput_10Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBInput_10_SUBPROCESS_STATE", 0);

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



		row8Struct row8 = new row8Struct();




	
	/**
	 * [tAdvancedHash_row8 begin ] start
	 */

	

	
		
		ok_Hash.put("tAdvancedHash_row8", false);
		start_Hash.put("tAdvancedHash_row8", System.currentTimeMillis());
		
	
	currentComponent="tAdvancedHash_row8";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row8");
					}
				
		int tos_count_tAdvancedHash_row8 = 0;
		

			   		// connection name:row8
			   		// source node:tDBInput_10 - inputs:(after_tDBInput_1) outputs:(row8,row8) | target node:tAdvancedHash_row8 - inputs:(row8) outputs:()
			   		// linked node: tMap_1 - inputs:(row1,row2,row3,row4,row5,row6,row10,row11,row7,row8,row9) outputs:(out1)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row8 = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row8Struct> tHash_Lookup_row8 =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<row8Struct>getLookup(matchingModeEnum_row8);
	   						   
		   	   	   globalMap.put("tHash_Lookup_row8", tHash_Lookup_row8);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_row8 begin ] stop
 */



	
	/**
	 * [tDBInput_10 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_10", false);
		start_Hash.put("tDBInput_10", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_10";

	
		int tos_count_tDBInput_10 = 0;
		
	
    
	
			org.talend.designer.components.util.mssql.MSSqlGenerateTimestampUtil mssqlGTU_tDBInput_10 = org.talend.designer.components.util.mssql.MSSqlUtilFactory.getMSSqlGenerateTimestampUtil();
			
			java.util.List<String> talendToDBList_tDBInput_10 = new java.util.ArrayList();
			String[] talendToDBArray_tDBInput_10  = new String[]{"FLOAT","NUMERIC","NUMERIC IDENTITY","DECIMAL","DECIMAL IDENTITY","REAL"}; 
			java.util.Collections.addAll(talendToDBList_tDBInput_10, talendToDBArray_tDBInput_10); 
		    int nb_line_tDBInput_10 = 0;
		    java.sql.Connection conn_tDBInput_10 = null;
				String driverClass_tDBInput_10 = "net.sourceforge.jtds.jdbc.Driver";
			    java.lang.Class jdbcclazz_tDBInput_10 = java.lang.Class.forName(driverClass_tDBInput_10);
				String dbUser_tDBInput_10 = "sa";
				
				 
	final String decryptedPassword_tDBInput_10 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:F3yInCtjjJchJRUD4SZPsNAZdlOImJv7RGsJ9DOCwFbxVD/0T7g=");
				
				String dbPwd_tDBInput_10 = decryptedPassword_tDBInput_10;
				
		    String port_tDBInput_10 = "1433";
		    String dbname_tDBInput_10 = "PGS_STAGE_DW" ;
			String url_tDBInput_10 = "jdbc:jtds:sqlserver://" + "LAPTOP-HED7JE2F" ;
		    if (!"".equals(port_tDBInput_10)) {
		    	url_tDBInput_10 += ":" + "1433";
		    }
		    if (!"".equals(dbname_tDBInput_10)) {
				url_tDBInput_10 += "//" + "PGS_STAGE_DW"; 
		    }
		    url_tDBInput_10 += ";appName=" + projectName + ";" + "";
		    String dbschema_tDBInput_10 = "dbo";
				
				conn_tDBInput_10 = java.sql.DriverManager.getConnection(url_tDBInput_10,dbUser_tDBInput_10,dbPwd_tDBInput_10);
		        
		    
			java.sql.Statement stmt_tDBInput_10 = conn_tDBInput_10.createStatement();

		    String dbquery_tDBInput_10 = "SELECT dbo.DIM_TRAILER.PK_TRAILER,\n		dbo.DIM_TRAILER.CARRIER_NUMBER,\n		dbo.DIM_TRAILER.TRAILER_CODE,\n		dbo.DIM_TRAILER."
+"SERIAL_NUMBER,\n		dbo.DIM_TRAILER.RT_LAST_ORDER_ID,\n		dbo.DIM_TRAILER.ENTER_TERMINAL,\n		dbo.DIM_TRAILER.LAST_MODIFIED,\n		"
+"dbo.DIM_TRAILER.LOADING_TYPE,\n		dbo.DIM_TRAILER.REPEAT_ORDER_ID,\n		dbo.DIM_TRAILER.RT_CURRENT_VISIT_ID,\n		dbo.DIM_TRAILE"
+"R.GLOBAL_LOCKOUT_TERMINAL_ID\nFROM	dbo.DIM_TRAILER";
		    

            	globalMap.put("tDBInput_10_QUERY",dbquery_tDBInput_10);
		    java.sql.ResultSet rs_tDBInput_10 = null;

		    try {
		    	rs_tDBInput_10 = stmt_tDBInput_10.executeQuery(dbquery_tDBInput_10);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_10 = rs_tDBInput_10.getMetaData();
		    	int colQtyInRs_tDBInput_10 = rsmd_tDBInput_10.getColumnCount();

		    String tmpContent_tDBInput_10 = null;
		    
		    
		    while (rs_tDBInput_10.next()) {
		        nb_line_tDBInput_10++;
		        
							if(colQtyInRs_tDBInput_10 < 1) {
								row8.PK_TRAILER = 0;
							} else {
		                          
            row8.PK_TRAILER = rs_tDBInput_10.getInt(1);
            if(rs_tDBInput_10.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_10 < 2) {
								row8.CARRIER_NUMBER = 0;
							} else {
		                          
            row8.CARRIER_NUMBER = rs_tDBInput_10.getInt(2);
            if(rs_tDBInput_10.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_10 < 3) {
								row8.TRAILER_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_10 = rs_tDBInput_10.getString(3);
            if(tmpContent_tDBInput_10 != null) {
            	if (talendToDBList_tDBInput_10 .contains(rsmd_tDBInput_10.getColumnTypeName(3).toUpperCase(java.util.Locale.ENGLISH))) {
            		row8.TRAILER_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_10);
            	} else {
                	row8.TRAILER_CODE = tmpContent_tDBInput_10;
                }
            } else {
                row8.TRAILER_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_10 < 4) {
								row8.SERIAL_NUMBER = null;
							} else {
	                         		
           		tmpContent_tDBInput_10 = rs_tDBInput_10.getString(4);
            if(tmpContent_tDBInput_10 != null) {
            	if (talendToDBList_tDBInput_10 .contains(rsmd_tDBInput_10.getColumnTypeName(4).toUpperCase(java.util.Locale.ENGLISH))) {
            		row8.SERIAL_NUMBER = FormatterUtils.formatUnwithE(tmpContent_tDBInput_10);
            	} else {
                	row8.SERIAL_NUMBER = tmpContent_tDBInput_10;
                }
            } else {
                row8.SERIAL_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_10 < 5) {
								row8.RT_LAST_ORDER_ID = null;
							} else {
		                          
            row8.RT_LAST_ORDER_ID = rs_tDBInput_10.getInt(5);
            if(rs_tDBInput_10.wasNull()){
                    row8.RT_LAST_ORDER_ID = null;
            }
		                    }
							if(colQtyInRs_tDBInput_10 < 6) {
								row8.ENTER_TERMINAL = 0;
							} else {
		                          
            row8.ENTER_TERMINAL = rs_tDBInput_10.getInt(6);
            if(rs_tDBInput_10.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_10 < 7) {
								row8.LAST_MODIFIED = null;
							} else {
										
			row8.LAST_MODIFIED = mssqlGTU_tDBInput_10.getDate(rsmd_tDBInput_10, rs_tDBInput_10, 7);
			
		                    }
							if(colQtyInRs_tDBInput_10 < 8) {
								row8.LOADING_TYPE = null;
							} else {
		                          
            row8.LOADING_TYPE = rs_tDBInput_10.getInt(8);
            if(rs_tDBInput_10.wasNull()){
                    row8.LOADING_TYPE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_10 < 9) {
								row8.REPEAT_ORDER_ID = 0;
							} else {
		                          
            row8.REPEAT_ORDER_ID = rs_tDBInput_10.getInt(9);
            if(rs_tDBInput_10.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_10 < 10) {
								row8.RT_CURRENT_VISIT_ID = null;
							} else {
		                          
            row8.RT_CURRENT_VISIT_ID = rs_tDBInput_10.getInt(10);
            if(rs_tDBInput_10.wasNull()){
                    row8.RT_CURRENT_VISIT_ID = null;
            }
		                    }
							if(colQtyInRs_tDBInput_10 < 11) {
								row8.GLOBAL_LOCKOUT_TERMINAL_ID = 0;
							} else {
		                          
            row8.GLOBAL_LOCKOUT_TERMINAL_ID = rs_tDBInput_10.getInt(11);
            if(rs_tDBInput_10.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
					





 



/**
 * [tDBInput_10 begin ] stop
 */
	
	/**
	 * [tDBInput_10 main ] start
	 */

	

	
	
	currentComponent="tDBInput_10";

	

 


	tos_count_tDBInput_10++;

/**
 * [tDBInput_10 main ] stop
 */
	
	/**
	 * [tDBInput_10 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_10";

	

 



/**
 * [tDBInput_10 process_data_begin ] stop
 */

	
	/**
	 * [tAdvancedHash_row8 main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row8";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row8"
						
						);
					}
					


			   
			   

					row8Struct row8_HashRow = new row8Struct();
		   	   	   
				
				row8_HashRow.PK_TRAILER = row8.PK_TRAILER;
				
				row8_HashRow.CARRIER_NUMBER = row8.CARRIER_NUMBER;
				
				row8_HashRow.TRAILER_CODE = row8.TRAILER_CODE;
				
				row8_HashRow.SERIAL_NUMBER = row8.SERIAL_NUMBER;
				
				row8_HashRow.RT_LAST_ORDER_ID = row8.RT_LAST_ORDER_ID;
				
				row8_HashRow.ENTER_TERMINAL = row8.ENTER_TERMINAL;
				
				row8_HashRow.LAST_MODIFIED = row8.LAST_MODIFIED;
				
				row8_HashRow.LOADING_TYPE = row8.LOADING_TYPE;
				
				row8_HashRow.REPEAT_ORDER_ID = row8.REPEAT_ORDER_ID;
				
				row8_HashRow.RT_CURRENT_VISIT_ID = row8.RT_CURRENT_VISIT_ID;
				
				row8_HashRow.GLOBAL_LOCKOUT_TERMINAL_ID = row8.GLOBAL_LOCKOUT_TERMINAL_ID;
				
			tHash_Lookup_row8.put(row8_HashRow);
			
            




 


	tos_count_tAdvancedHash_row8++;

/**
 * [tAdvancedHash_row8 main ] stop
 */
	
	/**
	 * [tAdvancedHash_row8 process_data_begin ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row8";

	

 



/**
 * [tAdvancedHash_row8 process_data_begin ] stop
 */
	
	/**
	 * [tAdvancedHash_row8 process_data_end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row8";

	

 



/**
 * [tAdvancedHash_row8 process_data_end ] stop
 */



	
	/**
	 * [tDBInput_10 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_10";

	

 



/**
 * [tDBInput_10 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_10 end ] start
	 */

	

	
	
	currentComponent="tDBInput_10";

	

	}
}finally{
	if (rs_tDBInput_10 != null) {
		rs_tDBInput_10.close();
	}
	if (stmt_tDBInput_10 != null) {
		stmt_tDBInput_10.close();
	}
		if(conn_tDBInput_10 != null && !conn_tDBInput_10.isClosed()) {
			
			conn_tDBInput_10.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
		}
}
globalMap.put("tDBInput_10_NB_LINE",nb_line_tDBInput_10);

 

ok_Hash.put("tDBInput_10", true);
end_Hash.put("tDBInput_10", System.currentTimeMillis());




/**
 * [tDBInput_10 end ] stop
 */

	
	/**
	 * [tAdvancedHash_row8 end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row8";

	

tHash_Lookup_row8.endPut();

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row8");
			  	}
			  	
 

ok_Hash.put("tAdvancedHash_row8", true);
end_Hash.put("tAdvancedHash_row8", System.currentTimeMillis());




/**
 * [tAdvancedHash_row8 end ] stop
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
	 * [tDBInput_10 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_10";

	

 



/**
 * [tDBInput_10 finally ] stop
 */

	
	/**
	 * [tAdvancedHash_row8 finally ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row8";

	

 



/**
 * [tAdvancedHash_row8 finally ] stop
 */



				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBInput_10_SUBPROCESS_STATE", 1);
	}
	


public static class row9Struct implements routines.system.IPersistableComparableLookupRow<row9Struct> {
    final static byte[] commonByteArrayLock_PGS_STAGE_FACT_SALES_SAM = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_FACT_SALES_SAM = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public int CARRIER_NUMBER;

				public int getCARRIER_NUMBER () {
					return this.CARRIER_NUMBER;
				}
				
			    public String TRAILER_CODE;

				public String getTRAILER_CODE () {
					return this.TRAILER_CODE;
				}
				
			    public String TABS_TRUCK_NUMBER;

				public String getTABS_TRUCK_NUMBER () {
					return this.TABS_TRUCK_NUMBER;
				}
				
			    public String LICENSE;

				public String getLICENSE () {
					return this.LICENSE;
				}
				
			    public String STATE;

				public String getSTATE () {
					return this.STATE;
				}
				
			    public int RT_CURRENTLY_LOADING;

				public int getRT_CURRENTLY_LOADING () {
					return this.RT_CURRENTLY_LOADING;
				}
				
			    public String SERIAL_NUMBER;

				public String getSERIAL_NUMBER () {
					return this.SERIAL_NUMBER;
				}
				
			    public int LOCKOUT_LOADING;

				public int getLOCKOUT_LOADING () {
					return this.LOCKOUT_LOADING;
				}
				
			    public int REQUIRES_INTERVENTION;

				public int getREQUIRES_INTERVENTION () {
					return this.REQUIRES_INTERVENTION;
				}
				
			    public String LOCKOUT_LOADING_REASON;

				public String getLOCKOUT_LOADING_REASON () {
					return this.LOCKOUT_LOADING_REASON;
				}
				
			    public Integer RT_LAST_ORDER_ID;

				public Integer getRT_LAST_ORDER_ID () {
					return this.RT_LAST_ORDER_ID;
				}
				
			    public int LOCKOUT_ENTRY;

				public int getLOCKOUT_ENTRY () {
					return this.LOCKOUT_ENTRY;
				}
				
			    public String LOCKOUT_ENTRY_REASON;

				public String getLOCKOUT_ENTRY_REASON () {
					return this.LOCKOUT_ENTRY_REASON;
				}
				
			    public int ENTER_TERMINAL;

				public int getENTER_TERMINAL () {
					return this.ENTER_TERMINAL;
				}
				
			    public Integer FUELING_SUPPLIER_NUMBER;

				public Integer getFUELING_SUPPLIER_NUMBER () {
					return this.FUELING_SUPPLIER_NUMBER;
				}
				
			    public Integer FUELING_PRODUCT_NUMBER;

				public Integer getFUELING_PRODUCT_NUMBER () {
					return this.FUELING_PRODUCT_NUMBER;
				}
				
			    public String LAST_USER_NAME;

				public String getLAST_USER_NAME () {
					return this.LAST_USER_NAME;
				}
				
			    public java.util.Date LAST_MODIFIED;

				public java.util.Date getLAST_MODIFIED () {
					return this.LAST_MODIFIED;
				}
				
			    public Integer LOADING_TYPE;

				public Integer getLOADING_TYPE () {
					return this.LOADING_TYPE;
				}
				
			    public String HOST_TRAILER_CODE;

				public String getHOST_TRAILER_CODE () {
					return this.HOST_TRAILER_CODE;
				}
				
			    public String HOST_ALTERNATE_TRAILER_CODE;

				public String getHOST_ALTERNATE_TRAILER_CODE () {
					return this.HOST_ALTERNATE_TRAILER_CODE;
				}
				
			    public int PETROEX_TRUCK_NUMBER;

				public int getPETROEX_TRUCK_NUMBER () {
					return this.PETROEX_TRUCK_NUMBER;
				}
				
			    public int USABLE_CAPACITY;

				public int getUSABLE_CAPACITY () {
					return this.USABLE_CAPACITY;
				}
				
			    public String PETROEX_VEHICLE_TYPE;

				public String getPETROEX_VEHICLE_TYPE () {
					return this.PETROEX_VEHICLE_TYPE;
				}
				
			    public int MULTI_LOADING_LIMIT;

				public int getMULTI_LOADING_LIMIT () {
					return this.MULTI_LOADING_LIMIT;
				}
				
			    public String CARD_NUMBER;

				public String getCARD_NUMBER () {
					return this.CARD_NUMBER;
				}
				
			    public int MAX_TARE_WEIGHT;

				public int getMAX_TARE_WEIGHT () {
					return this.MAX_TARE_WEIGHT;
				}
				
			    public int REQUIRES_RESTRICTED_FLOW;

				public int getREQUIRES_RESTRICTED_FLOW () {
					return this.REQUIRES_RESTRICTED_FLOW;
				}
				
			    public int REPEAT_ORDER_ID;

				public int getREPEAT_ORDER_ID () {
					return this.REPEAT_ORDER_ID;
				}
				
			    public int REQUIRES_RESTRICTED_LOW_FLOW;

				public int getREQUIRES_RESTRICTED_LOW_FLOW () {
					return this.REQUIRES_RESTRICTED_LOW_FLOW;
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
				
			    public Integer RT_CURRENT_VISIT_ID;

				public Integer getRT_CURRENT_VISIT_ID () {
					return this.RT_CURRENT_VISIT_ID;
				}
				
			    public int UNLADEN_WEIGHT;

				public int getUNLADEN_WEIGHT () {
					return this.UNLADEN_WEIGHT;
				}
				
			    public int MAXIMUM_WEIGHT;

				public int getMAXIMUM_WEIGHT () {
					return this.MAXIMUM_WEIGHT;
				}
				
			    public int LOAD_TIME_TRAILER_ID_ENABLE;

				public int getLOAD_TIME_TRAILER_ID_ENABLE () {
					return this.LOAD_TIME_TRAILER_ID_ENABLE;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
							result = prime * result + (int) this.CARRIER_NUMBER;
						
						result = prime * result + ((this.TRAILER_CODE == null) ? 0 : this.TRAILER_CODE.hashCode());
					
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
		final row9Struct other = (row9Struct) obj;
		
						if (this.CARRIER_NUMBER != other.CARRIER_NUMBER)
							return false;
					
						if (this.TRAILER_CODE == null) {
							if (other.TRAILER_CODE != null)
								return false;
						
						} else if (!this.TRAILER_CODE.equals(other.TRAILER_CODE))
						
							return false;
					

		return true;
    }

	public void copyDataTo(row9Struct other) {

		other.CARRIER_NUMBER = this.CARRIER_NUMBER;
	            other.TRAILER_CODE = this.TRAILER_CODE;
	            other.TABS_TRUCK_NUMBER = this.TABS_TRUCK_NUMBER;
	            other.LICENSE = this.LICENSE;
	            other.STATE = this.STATE;
	            other.RT_CURRENTLY_LOADING = this.RT_CURRENTLY_LOADING;
	            other.SERIAL_NUMBER = this.SERIAL_NUMBER;
	            other.LOCKOUT_LOADING = this.LOCKOUT_LOADING;
	            other.REQUIRES_INTERVENTION = this.REQUIRES_INTERVENTION;
	            other.LOCKOUT_LOADING_REASON = this.LOCKOUT_LOADING_REASON;
	            other.RT_LAST_ORDER_ID = this.RT_LAST_ORDER_ID;
	            other.LOCKOUT_ENTRY = this.LOCKOUT_ENTRY;
	            other.LOCKOUT_ENTRY_REASON = this.LOCKOUT_ENTRY_REASON;
	            other.ENTER_TERMINAL = this.ENTER_TERMINAL;
	            other.FUELING_SUPPLIER_NUMBER = this.FUELING_SUPPLIER_NUMBER;
	            other.FUELING_PRODUCT_NUMBER = this.FUELING_PRODUCT_NUMBER;
	            other.LAST_USER_NAME = this.LAST_USER_NAME;
	            other.LAST_MODIFIED = this.LAST_MODIFIED;
	            other.LOADING_TYPE = this.LOADING_TYPE;
	            other.HOST_TRAILER_CODE = this.HOST_TRAILER_CODE;
	            other.HOST_ALTERNATE_TRAILER_CODE = this.HOST_ALTERNATE_TRAILER_CODE;
	            other.PETROEX_TRUCK_NUMBER = this.PETROEX_TRUCK_NUMBER;
	            other.USABLE_CAPACITY = this.USABLE_CAPACITY;
	            other.PETROEX_VEHICLE_TYPE = this.PETROEX_VEHICLE_TYPE;
	            other.MULTI_LOADING_LIMIT = this.MULTI_LOADING_LIMIT;
	            other.CARD_NUMBER = this.CARD_NUMBER;
	            other.MAX_TARE_WEIGHT = this.MAX_TARE_WEIGHT;
	            other.REQUIRES_RESTRICTED_FLOW = this.REQUIRES_RESTRICTED_FLOW;
	            other.REPEAT_ORDER_ID = this.REPEAT_ORDER_ID;
	            other.REQUIRES_RESTRICTED_LOW_FLOW = this.REQUIRES_RESTRICTED_LOW_FLOW;
	            other.GLOBAL_LOCKOUT = this.GLOBAL_LOCKOUT;
	            other.GLOBAL_LOCKOUT_REASON = this.GLOBAL_LOCKOUT_REASON;
	            other.GLOBAL_LOCKOUT_USER = this.GLOBAL_LOCKOUT_USER;
	            other.GLOBAL_LOCKOUT_TERMINAL_ID = this.GLOBAL_LOCKOUT_TERMINAL_ID;
	            other.RT_CURRENT_VISIT_ID = this.RT_CURRENT_VISIT_ID;
	            other.UNLADEN_WEIGHT = this.UNLADEN_WEIGHT;
	            other.MAXIMUM_WEIGHT = this.MAXIMUM_WEIGHT;
	            other.LOAD_TIME_TRAILER_ID_ENABLE = this.LOAD_TIME_TRAILER_ID_ENABLE;
	            
	}

	public void copyKeysDataTo(row9Struct other) {

		other.CARRIER_NUMBER = this.CARRIER_NUMBER;
	            	other.TRAILER_CODE = this.TRAILER_CODE;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PGS_STAGE_FACT_SALES_SAM.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_FACT_SALES_SAM.length == 0) {
   					commonByteArray_PGS_STAGE_FACT_SALES_SAM = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_FACT_SALES_SAM = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PGS_STAGE_FACT_SALES_SAM, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_FACT_SALES_SAM, 0, length, utf8Charset);
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
			if(length > commonByteArray_PGS_STAGE_FACT_SALES_SAM.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_FACT_SALES_SAM.length == 0) {
   					commonByteArray_PGS_STAGE_FACT_SALES_SAM = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_FACT_SALES_SAM = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PGS_STAGE_FACT_SALES_SAM, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_FACT_SALES_SAM, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PGS_STAGE_FACT_SALES_SAM) {

        	try {

        		int length = 0;
		
			        this.CARRIER_NUMBER = dis.readInt();
					
					this.TRAILER_CODE = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_FACT_SALES_SAM) {

        	try {

        		int length = 0;
		
			        this.CARRIER_NUMBER = dis.readInt();
					
					this.TRAILER_CODE = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.CARRIER_NUMBER);
					
					// String
				
						writeString(this.TRAILER_CODE,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.CARRIER_NUMBER);
					
					// String
				
						writeString(this.TRAILER_CODE,dos);
					
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
		
						this.TABS_TRUCK_NUMBER = readString(dis,ois);
					
						this.LICENSE = readString(dis,ois);
					
						this.STATE = readString(dis,ois);
					
			            this.RT_CURRENTLY_LOADING = dis.readInt();
					
						this.SERIAL_NUMBER = readString(dis,ois);
					
			            this.LOCKOUT_LOADING = dis.readInt();
					
			            this.REQUIRES_INTERVENTION = dis.readInt();
					
						this.LOCKOUT_LOADING_REASON = readString(dis,ois);
					
						this.RT_LAST_ORDER_ID = readInteger(dis,ois);
					
			            this.LOCKOUT_ENTRY = dis.readInt();
					
						this.LOCKOUT_ENTRY_REASON = readString(dis,ois);
					
			            this.ENTER_TERMINAL = dis.readInt();
					
						this.FUELING_SUPPLIER_NUMBER = readInteger(dis,ois);
					
						this.FUELING_PRODUCT_NUMBER = readInteger(dis,ois);
					
						this.LAST_USER_NAME = readString(dis,ois);
					
						this.LAST_MODIFIED = readDate(dis,ois);
					
						this.LOADING_TYPE = readInteger(dis,ois);
					
						this.HOST_TRAILER_CODE = readString(dis,ois);
					
						this.HOST_ALTERNATE_TRAILER_CODE = readString(dis,ois);
					
			            this.PETROEX_TRUCK_NUMBER = dis.readInt();
					
			            this.USABLE_CAPACITY = dis.readInt();
					
						this.PETROEX_VEHICLE_TYPE = readString(dis,ois);
					
			            this.MULTI_LOADING_LIMIT = dis.readInt();
					
						this.CARD_NUMBER = readString(dis,ois);
					
			            this.MAX_TARE_WEIGHT = dis.readInt();
					
			            this.REQUIRES_RESTRICTED_FLOW = dis.readInt();
					
			            this.REPEAT_ORDER_ID = dis.readInt();
					
			            this.REQUIRES_RESTRICTED_LOW_FLOW = dis.readInt();
					
			            this.GLOBAL_LOCKOUT = dis.readInt();
					
						this.GLOBAL_LOCKOUT_REASON = readString(dis,ois);
					
						this.GLOBAL_LOCKOUT_USER = readString(dis,ois);
					
			            this.GLOBAL_LOCKOUT_TERMINAL_ID = dis.readInt();
					
						this.RT_CURRENT_VISIT_ID = readInteger(dis,ois);
					
			            this.UNLADEN_WEIGHT = dis.readInt();
					
			            this.MAXIMUM_WEIGHT = dis.readInt();
					
			            this.LOAD_TIME_TRAILER_ID_ENABLE = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
						this.TABS_TRUCK_NUMBER = readString(dis,objectIn);
					
						this.LICENSE = readString(dis,objectIn);
					
						this.STATE = readString(dis,objectIn);
					
			            this.RT_CURRENTLY_LOADING = objectIn.readInt();
					
						this.SERIAL_NUMBER = readString(dis,objectIn);
					
			            this.LOCKOUT_LOADING = objectIn.readInt();
					
			            this.REQUIRES_INTERVENTION = objectIn.readInt();
					
						this.LOCKOUT_LOADING_REASON = readString(dis,objectIn);
					
						this.RT_LAST_ORDER_ID = readInteger(dis,objectIn);
					
			            this.LOCKOUT_ENTRY = objectIn.readInt();
					
						this.LOCKOUT_ENTRY_REASON = readString(dis,objectIn);
					
			            this.ENTER_TERMINAL = objectIn.readInt();
					
						this.FUELING_SUPPLIER_NUMBER = readInteger(dis,objectIn);
					
						this.FUELING_PRODUCT_NUMBER = readInteger(dis,objectIn);
					
						this.LAST_USER_NAME = readString(dis,objectIn);
					
						this.LAST_MODIFIED = readDate(dis,objectIn);
					
						this.LOADING_TYPE = readInteger(dis,objectIn);
					
						this.HOST_TRAILER_CODE = readString(dis,objectIn);
					
						this.HOST_ALTERNATE_TRAILER_CODE = readString(dis,objectIn);
					
			            this.PETROEX_TRUCK_NUMBER = objectIn.readInt();
					
			            this.USABLE_CAPACITY = objectIn.readInt();
					
						this.PETROEX_VEHICLE_TYPE = readString(dis,objectIn);
					
			            this.MULTI_LOADING_LIMIT = objectIn.readInt();
					
						this.CARD_NUMBER = readString(dis,objectIn);
					
			            this.MAX_TARE_WEIGHT = objectIn.readInt();
					
			            this.REQUIRES_RESTRICTED_FLOW = objectIn.readInt();
					
			            this.REPEAT_ORDER_ID = objectIn.readInt();
					
			            this.REQUIRES_RESTRICTED_LOW_FLOW = objectIn.readInt();
					
			            this.GLOBAL_LOCKOUT = objectIn.readInt();
					
						this.GLOBAL_LOCKOUT_REASON = readString(dis,objectIn);
					
						this.GLOBAL_LOCKOUT_USER = readString(dis,objectIn);
					
			            this.GLOBAL_LOCKOUT_TERMINAL_ID = objectIn.readInt();
					
						this.RT_CURRENT_VISIT_ID = readInteger(dis,objectIn);
					
			            this.UNLADEN_WEIGHT = objectIn.readInt();
					
			            this.MAXIMUM_WEIGHT = objectIn.readInt();
					
			            this.LOAD_TIME_TRAILER_ID_ENABLE = objectIn.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
						writeString(this.TABS_TRUCK_NUMBER, dos, oos);
					
						writeString(this.LICENSE, dos, oos);
					
						writeString(this.STATE, dos, oos);
					
		            	dos.writeInt(this.RT_CURRENTLY_LOADING);
					
						writeString(this.SERIAL_NUMBER, dos, oos);
					
		            	dos.writeInt(this.LOCKOUT_LOADING);
					
		            	dos.writeInt(this.REQUIRES_INTERVENTION);
					
						writeString(this.LOCKOUT_LOADING_REASON, dos, oos);
					
					writeInteger(this.RT_LAST_ORDER_ID, dos, oos);
					
		            	dos.writeInt(this.LOCKOUT_ENTRY);
					
						writeString(this.LOCKOUT_ENTRY_REASON, dos, oos);
					
		            	dos.writeInt(this.ENTER_TERMINAL);
					
					writeInteger(this.FUELING_SUPPLIER_NUMBER, dos, oos);
					
					writeInteger(this.FUELING_PRODUCT_NUMBER, dos, oos);
					
						writeString(this.LAST_USER_NAME, dos, oos);
					
						writeDate(this.LAST_MODIFIED, dos, oos);
					
					writeInteger(this.LOADING_TYPE, dos, oos);
					
						writeString(this.HOST_TRAILER_CODE, dos, oos);
					
						writeString(this.HOST_ALTERNATE_TRAILER_CODE, dos, oos);
					
		            	dos.writeInt(this.PETROEX_TRUCK_NUMBER);
					
		            	dos.writeInt(this.USABLE_CAPACITY);
					
						writeString(this.PETROEX_VEHICLE_TYPE, dos, oos);
					
		            	dos.writeInt(this.MULTI_LOADING_LIMIT);
					
						writeString(this.CARD_NUMBER, dos, oos);
					
		            	dos.writeInt(this.MAX_TARE_WEIGHT);
					
		            	dos.writeInt(this.REQUIRES_RESTRICTED_FLOW);
					
		            	dos.writeInt(this.REPEAT_ORDER_ID);
					
		            	dos.writeInt(this.REQUIRES_RESTRICTED_LOW_FLOW);
					
		            	dos.writeInt(this.GLOBAL_LOCKOUT);
					
						writeString(this.GLOBAL_LOCKOUT_REASON, dos, oos);
					
						writeString(this.GLOBAL_LOCKOUT_USER, dos, oos);
					
		            	dos.writeInt(this.GLOBAL_LOCKOUT_TERMINAL_ID);
					
					writeInteger(this.RT_CURRENT_VISIT_ID, dos, oos);
					
		            	dos.writeInt(this.UNLADEN_WEIGHT);
					
		            	dos.writeInt(this.MAXIMUM_WEIGHT);
					
		            	dos.writeInt(this.LOAD_TIME_TRAILER_ID_ENABLE);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
						writeString(this.TABS_TRUCK_NUMBER, dos, objectOut);
					
						writeString(this.LICENSE, dos, objectOut);
					
						writeString(this.STATE, dos, objectOut);
					
					objectOut.writeInt(this.RT_CURRENTLY_LOADING);
					
						writeString(this.SERIAL_NUMBER, dos, objectOut);
					
					objectOut.writeInt(this.LOCKOUT_LOADING);
					
					objectOut.writeInt(this.REQUIRES_INTERVENTION);
					
						writeString(this.LOCKOUT_LOADING_REASON, dos, objectOut);
					
					writeInteger(this.RT_LAST_ORDER_ID, dos, objectOut);
					
					objectOut.writeInt(this.LOCKOUT_ENTRY);
					
						writeString(this.LOCKOUT_ENTRY_REASON, dos, objectOut);
					
					objectOut.writeInt(this.ENTER_TERMINAL);
					
					writeInteger(this.FUELING_SUPPLIER_NUMBER, dos, objectOut);
					
					writeInteger(this.FUELING_PRODUCT_NUMBER, dos, objectOut);
					
						writeString(this.LAST_USER_NAME, dos, objectOut);
					
						writeDate(this.LAST_MODIFIED, dos, objectOut);
					
					writeInteger(this.LOADING_TYPE, dos, objectOut);
					
						writeString(this.HOST_TRAILER_CODE, dos, objectOut);
					
						writeString(this.HOST_ALTERNATE_TRAILER_CODE, dos, objectOut);
					
					objectOut.writeInt(this.PETROEX_TRUCK_NUMBER);
					
					objectOut.writeInt(this.USABLE_CAPACITY);
					
						writeString(this.PETROEX_VEHICLE_TYPE, dos, objectOut);
					
					objectOut.writeInt(this.MULTI_LOADING_LIMIT);
					
						writeString(this.CARD_NUMBER, dos, objectOut);
					
					objectOut.writeInt(this.MAX_TARE_WEIGHT);
					
					objectOut.writeInt(this.REQUIRES_RESTRICTED_FLOW);
					
					objectOut.writeInt(this.REPEAT_ORDER_ID);
					
					objectOut.writeInt(this.REQUIRES_RESTRICTED_LOW_FLOW);
					
					objectOut.writeInt(this.GLOBAL_LOCKOUT);
					
						writeString(this.GLOBAL_LOCKOUT_REASON, dos, objectOut);
					
						writeString(this.GLOBAL_LOCKOUT_USER, dos, objectOut);
					
					objectOut.writeInt(this.GLOBAL_LOCKOUT_TERMINAL_ID);
					
					writeInteger(this.RT_CURRENT_VISIT_ID, dos, objectOut);
					
					objectOut.writeInt(this.UNLADEN_WEIGHT);
					
					objectOut.writeInt(this.MAXIMUM_WEIGHT);
					
					objectOut.writeInt(this.LOAD_TIME_TRAILER_ID_ENABLE);
					
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
		sb.append("CARRIER_NUMBER="+String.valueOf(CARRIER_NUMBER));
		sb.append(",TRAILER_CODE="+TRAILER_CODE);
		sb.append(",TABS_TRUCK_NUMBER="+TABS_TRUCK_NUMBER);
		sb.append(",LICENSE="+LICENSE);
		sb.append(",STATE="+STATE);
		sb.append(",RT_CURRENTLY_LOADING="+String.valueOf(RT_CURRENTLY_LOADING));
		sb.append(",SERIAL_NUMBER="+SERIAL_NUMBER);
		sb.append(",LOCKOUT_LOADING="+String.valueOf(LOCKOUT_LOADING));
		sb.append(",REQUIRES_INTERVENTION="+String.valueOf(REQUIRES_INTERVENTION));
		sb.append(",LOCKOUT_LOADING_REASON="+LOCKOUT_LOADING_REASON);
		sb.append(",RT_LAST_ORDER_ID="+String.valueOf(RT_LAST_ORDER_ID));
		sb.append(",LOCKOUT_ENTRY="+String.valueOf(LOCKOUT_ENTRY));
		sb.append(",LOCKOUT_ENTRY_REASON="+LOCKOUT_ENTRY_REASON);
		sb.append(",ENTER_TERMINAL="+String.valueOf(ENTER_TERMINAL));
		sb.append(",FUELING_SUPPLIER_NUMBER="+String.valueOf(FUELING_SUPPLIER_NUMBER));
		sb.append(",FUELING_PRODUCT_NUMBER="+String.valueOf(FUELING_PRODUCT_NUMBER));
		sb.append(",LAST_USER_NAME="+LAST_USER_NAME);
		sb.append(",LAST_MODIFIED="+String.valueOf(LAST_MODIFIED));
		sb.append(",LOADING_TYPE="+String.valueOf(LOADING_TYPE));
		sb.append(",HOST_TRAILER_CODE="+HOST_TRAILER_CODE);
		sb.append(",HOST_ALTERNATE_TRAILER_CODE="+HOST_ALTERNATE_TRAILER_CODE);
		sb.append(",PETROEX_TRUCK_NUMBER="+String.valueOf(PETROEX_TRUCK_NUMBER));
		sb.append(",USABLE_CAPACITY="+String.valueOf(USABLE_CAPACITY));
		sb.append(",PETROEX_VEHICLE_TYPE="+PETROEX_VEHICLE_TYPE);
		sb.append(",MULTI_LOADING_LIMIT="+String.valueOf(MULTI_LOADING_LIMIT));
		sb.append(",CARD_NUMBER="+CARD_NUMBER);
		sb.append(",MAX_TARE_WEIGHT="+String.valueOf(MAX_TARE_WEIGHT));
		sb.append(",REQUIRES_RESTRICTED_FLOW="+String.valueOf(REQUIRES_RESTRICTED_FLOW));
		sb.append(",REPEAT_ORDER_ID="+String.valueOf(REPEAT_ORDER_ID));
		sb.append(",REQUIRES_RESTRICTED_LOW_FLOW="+String.valueOf(REQUIRES_RESTRICTED_LOW_FLOW));
		sb.append(",GLOBAL_LOCKOUT="+String.valueOf(GLOBAL_LOCKOUT));
		sb.append(",GLOBAL_LOCKOUT_REASON="+GLOBAL_LOCKOUT_REASON);
		sb.append(",GLOBAL_LOCKOUT_USER="+GLOBAL_LOCKOUT_USER);
		sb.append(",GLOBAL_LOCKOUT_TERMINAL_ID="+String.valueOf(GLOBAL_LOCKOUT_TERMINAL_ID));
		sb.append(",RT_CURRENT_VISIT_ID="+String.valueOf(RT_CURRENT_VISIT_ID));
		sb.append(",UNLADEN_WEIGHT="+String.valueOf(UNLADEN_WEIGHT));
		sb.append(",MAXIMUM_WEIGHT="+String.valueOf(MAXIMUM_WEIGHT));
		sb.append(",LOAD_TIME_TRAILER_ID_ENABLE="+String.valueOf(LOAD_TIME_TRAILER_ID_ENABLE));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row9Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.CARRIER_NUMBER, other.CARRIER_NUMBER);
						if(returnValue != 0) {
							return returnValue;
						}

					
						returnValue = checkNullsAndCompare(this.TRAILER_CODE, other.TRAILER_CODE);
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
public void tDBInput_11Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBInput_11_SUBPROCESS_STATE", 0);

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



		row9Struct row9 = new row9Struct();




	
	/**
	 * [tAdvancedHash_row9 begin ] start
	 */

	

	
		
		ok_Hash.put("tAdvancedHash_row9", false);
		start_Hash.put("tAdvancedHash_row9", System.currentTimeMillis());
		
	
	currentComponent="tAdvancedHash_row9";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row9");
					}
				
		int tos_count_tAdvancedHash_row9 = 0;
		

			   		// connection name:row9
			   		// source node:tDBInput_11 - inputs:(after_tDBInput_1) outputs:(row9,row9) | target node:tAdvancedHash_row9 - inputs:(row9) outputs:()
			   		// linked node: tMap_1 - inputs:(row1,row2,row3,row4,row5,row6,row10,row11,row7,row8,row9) outputs:(out1)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row9 = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row9Struct> tHash_Lookup_row9 =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<row9Struct>getLookup(matchingModeEnum_row9);
	   						   
		   	   	   globalMap.put("tHash_Lookup_row9", tHash_Lookup_row9);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_row9 begin ] stop
 */



	
	/**
	 * [tDBInput_11 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_11", false);
		start_Hash.put("tDBInput_11", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_11";

	
		int tos_count_tDBInput_11 = 0;
		
	
    
	
			org.talend.designer.components.util.mssql.MSSqlGenerateTimestampUtil mssqlGTU_tDBInput_11 = org.talend.designer.components.util.mssql.MSSqlUtilFactory.getMSSqlGenerateTimestampUtil();
			
			java.util.List<String> talendToDBList_tDBInput_11 = new java.util.ArrayList();
			String[] talendToDBArray_tDBInput_11  = new String[]{"FLOAT","NUMERIC","NUMERIC IDENTITY","DECIMAL","DECIMAL IDENTITY","REAL"}; 
			java.util.Collections.addAll(talendToDBList_tDBInput_11, talendToDBArray_tDBInput_11); 
		    int nb_line_tDBInput_11 = 0;
		    java.sql.Connection conn_tDBInput_11 = null;
				String driverClass_tDBInput_11 = "net.sourceforge.jtds.jdbc.Driver";
			    java.lang.Class jdbcclazz_tDBInput_11 = java.lang.Class.forName(driverClass_tDBInput_11);
				String dbUser_tDBInput_11 = "sa";
				
				 
	final String decryptedPassword_tDBInput_11 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:60JSXcsDJdUUgEVLGzQGUtYwfp+xPjzG1BY8djOdIeW32bNyFJY=");
				
				String dbPwd_tDBInput_11 = decryptedPassword_tDBInput_11;
				
		    String port_tDBInput_11 = "1433";
		    String dbname_tDBInput_11 = "FF_TEST" ;
			String url_tDBInput_11 = "jdbc:jtds:sqlserver://" + "LAPTOP-HED7JE2F" ;
		    if (!"".equals(port_tDBInput_11)) {
		    	url_tDBInput_11 += ":" + "1433";
		    }
		    if (!"".equals(dbname_tDBInput_11)) {
				url_tDBInput_11 += "//" + "FF_TEST"; 
		    }
		    url_tDBInput_11 += ";appName=" + projectName + ";" + "";
		    String dbschema_tDBInput_11 = "dbo";
				
				conn_tDBInput_11 = java.sql.DriverManager.getConnection(url_tDBInput_11,dbUser_tDBInput_11,dbPwd_tDBInput_11);
		        
		    
			java.sql.Statement stmt_tDBInput_11 = conn_tDBInput_11.createStatement();

		    String dbquery_tDBInput_11 = "SELECT dbo.TRAILER.CARRIER_NUMBER,\n		dbo.TRAILER.TRAILER_CODE,\n		dbo.TRAILER.TABS_TRUCK_NUMBER,\n		dbo.TRAILER.LICENSE,\n"
+"		dbo.TRAILER.STATE,\n		dbo.TRAILER.RT_CURRENTLY_LOADING,\n		dbo.TRAILER.SERIAL_NUMBER,\n		dbo.TRAILER.LOCKOUT_LOADING,\n		d"
+"bo.TRAILER.REQUIRES_INTERVENTION,\n		dbo.TRAILER.LOCKOUT_LOADING_REASON,\n		dbo.TRAILER.RT_LAST_ORDER_ID,\n		dbo.TRAILER.LO"
+"CKOUT_ENTRY,\n		dbo.TRAILER.LOCKOUT_ENTRY_REASON,\n		dbo.TRAILER.ENTER_TERMINAL,\n		dbo.TRAILER.FUELING_SUPPLIER_NUMBER,\n		"
+"dbo.TRAILER.FUELING_PRODUCT_NUMBER,\n		dbo.TRAILER.LAST_USER_NAME,\n		dbo.TRAILER.LAST_MODIFIED,\n		dbo.TRAILER.LOADING_TYP"
+"E,\n		dbo.TRAILER.HOST_TRAILER_CODE,\n		dbo.TRAILER.HOST_ALTERNATE_TRAILER_CODE,\n		dbo.TRAILER.PETROEX_TRUCK_NUMBER,\n		dbo"
+".TRAILER.USABLE_CAPACITY,\n		dbo.TRAILER.PETROEX_VEHICLE_TYPE,\n		dbo.TRAILER.MULTI_LOADING_LIMIT,\n		dbo.TRAILER.CARD_NUMB"
+"ER,\n		dbo.TRAILER.MAX_TARE_WEIGHT,\n		dbo.TRAILER.REQUIRES_RESTRICTED_FLOW,\n		dbo.TRAILER.REPEAT_ORDER_ID,\n		dbo.TRAILER."
+"REQUIRES_RESTRICTED_LOW_FLOW,\n		dbo.TRAILER.GLOBAL_LOCKOUT,\n		dbo.TRAILER.GLOBAL_LOCKOUT_REASON,\n		dbo.TRAILER.GLOBAL_LO"
+"CKOUT_USER,\n		dbo.TRAILER.GLOBAL_LOCKOUT_TERMINAL_ID,\n		dbo.TRAILER.RT_CURRENT_VISIT_ID,\n		dbo.TRAILER.UNLADEN_WEIGHT,\n	"
+"	dbo.TRAILER.MAXIMUM_WEIGHT,\n		dbo.TRAILER.LOAD_TIME_TRAILER_ID_ENABLE\nFROM	dbo.TRAILER";
		    

            	globalMap.put("tDBInput_11_QUERY",dbquery_tDBInput_11);
		    java.sql.ResultSet rs_tDBInput_11 = null;

		    try {
		    	rs_tDBInput_11 = stmt_tDBInput_11.executeQuery(dbquery_tDBInput_11);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_11 = rs_tDBInput_11.getMetaData();
		    	int colQtyInRs_tDBInput_11 = rsmd_tDBInput_11.getColumnCount();

		    String tmpContent_tDBInput_11 = null;
		    
		    
		    while (rs_tDBInput_11.next()) {
		        nb_line_tDBInput_11++;
		        
							if(colQtyInRs_tDBInput_11 < 1) {
								row9.CARRIER_NUMBER = 0;
							} else {
		                          
            row9.CARRIER_NUMBER = rs_tDBInput_11.getInt(1);
            if(rs_tDBInput_11.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_11 < 2) {
								row9.TRAILER_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_11 = rs_tDBInput_11.getString(2);
            if(tmpContent_tDBInput_11 != null) {
            	if (talendToDBList_tDBInput_11 .contains(rsmd_tDBInput_11.getColumnTypeName(2).toUpperCase(java.util.Locale.ENGLISH))) {
            		row9.TRAILER_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_11);
            	} else {
                	row9.TRAILER_CODE = tmpContent_tDBInput_11;
                }
            } else {
                row9.TRAILER_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_11 < 3) {
								row9.TABS_TRUCK_NUMBER = null;
							} else {
	                         		
           		tmpContent_tDBInput_11 = rs_tDBInput_11.getString(3);
            if(tmpContent_tDBInput_11 != null) {
            	if (talendToDBList_tDBInput_11 .contains(rsmd_tDBInput_11.getColumnTypeName(3).toUpperCase(java.util.Locale.ENGLISH))) {
            		row9.TABS_TRUCK_NUMBER = FormatterUtils.formatUnwithE(tmpContent_tDBInput_11);
            	} else {
                	row9.TABS_TRUCK_NUMBER = tmpContent_tDBInput_11;
                }
            } else {
                row9.TABS_TRUCK_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_11 < 4) {
								row9.LICENSE = null;
							} else {
	                         		
           		tmpContent_tDBInput_11 = rs_tDBInput_11.getString(4);
            if(tmpContent_tDBInput_11 != null) {
            	if (talendToDBList_tDBInput_11 .contains(rsmd_tDBInput_11.getColumnTypeName(4).toUpperCase(java.util.Locale.ENGLISH))) {
            		row9.LICENSE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_11);
            	} else {
                	row9.LICENSE = tmpContent_tDBInput_11;
                }
            } else {
                row9.LICENSE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_11 < 5) {
								row9.STATE = null;
							} else {
	                         		
           		tmpContent_tDBInput_11 = rs_tDBInput_11.getString(5);
            if(tmpContent_tDBInput_11 != null) {
            	if (talendToDBList_tDBInput_11 .contains(rsmd_tDBInput_11.getColumnTypeName(5).toUpperCase(java.util.Locale.ENGLISH))) {
            		row9.STATE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_11);
            	} else {
                	row9.STATE = tmpContent_tDBInput_11;
                }
            } else {
                row9.STATE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_11 < 6) {
								row9.RT_CURRENTLY_LOADING = 0;
							} else {
		                          
            row9.RT_CURRENTLY_LOADING = rs_tDBInput_11.getInt(6);
            if(rs_tDBInput_11.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_11 < 7) {
								row9.SERIAL_NUMBER = null;
							} else {
	                         		
           		tmpContent_tDBInput_11 = rs_tDBInput_11.getString(7);
            if(tmpContent_tDBInput_11 != null) {
            	if (talendToDBList_tDBInput_11 .contains(rsmd_tDBInput_11.getColumnTypeName(7).toUpperCase(java.util.Locale.ENGLISH))) {
            		row9.SERIAL_NUMBER = FormatterUtils.formatUnwithE(tmpContent_tDBInput_11);
            	} else {
                	row9.SERIAL_NUMBER = tmpContent_tDBInput_11;
                }
            } else {
                row9.SERIAL_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_11 < 8) {
								row9.LOCKOUT_LOADING = 0;
							} else {
		                          
            row9.LOCKOUT_LOADING = rs_tDBInput_11.getInt(8);
            if(rs_tDBInput_11.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_11 < 9) {
								row9.REQUIRES_INTERVENTION = 0;
							} else {
		                          
            row9.REQUIRES_INTERVENTION = rs_tDBInput_11.getInt(9);
            if(rs_tDBInput_11.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_11 < 10) {
								row9.LOCKOUT_LOADING_REASON = null;
							} else {
	                         		
           		tmpContent_tDBInput_11 = rs_tDBInput_11.getString(10);
            if(tmpContent_tDBInput_11 != null) {
            	if (talendToDBList_tDBInput_11 .contains(rsmd_tDBInput_11.getColumnTypeName(10).toUpperCase(java.util.Locale.ENGLISH))) {
            		row9.LOCKOUT_LOADING_REASON = FormatterUtils.formatUnwithE(tmpContent_tDBInput_11);
            	} else {
                	row9.LOCKOUT_LOADING_REASON = tmpContent_tDBInput_11;
                }
            } else {
                row9.LOCKOUT_LOADING_REASON = null;
            }
		                    }
							if(colQtyInRs_tDBInput_11 < 11) {
								row9.RT_LAST_ORDER_ID = null;
							} else {
		                          
            row9.RT_LAST_ORDER_ID = rs_tDBInput_11.getInt(11);
            if(rs_tDBInput_11.wasNull()){
                    row9.RT_LAST_ORDER_ID = null;
            }
		                    }
							if(colQtyInRs_tDBInput_11 < 12) {
								row9.LOCKOUT_ENTRY = 0;
							} else {
		                          
            row9.LOCKOUT_ENTRY = rs_tDBInput_11.getInt(12);
            if(rs_tDBInput_11.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_11 < 13) {
								row9.LOCKOUT_ENTRY_REASON = null;
							} else {
	                         		
           		tmpContent_tDBInput_11 = rs_tDBInput_11.getString(13);
            if(tmpContent_tDBInput_11 != null) {
            	if (talendToDBList_tDBInput_11 .contains(rsmd_tDBInput_11.getColumnTypeName(13).toUpperCase(java.util.Locale.ENGLISH))) {
            		row9.LOCKOUT_ENTRY_REASON = FormatterUtils.formatUnwithE(tmpContent_tDBInput_11);
            	} else {
                	row9.LOCKOUT_ENTRY_REASON = tmpContent_tDBInput_11;
                }
            } else {
                row9.LOCKOUT_ENTRY_REASON = null;
            }
		                    }
							if(colQtyInRs_tDBInput_11 < 14) {
								row9.ENTER_TERMINAL = 0;
							} else {
		                          
            row9.ENTER_TERMINAL = rs_tDBInput_11.getInt(14);
            if(rs_tDBInput_11.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_11 < 15) {
								row9.FUELING_SUPPLIER_NUMBER = null;
							} else {
		                          
            row9.FUELING_SUPPLIER_NUMBER = rs_tDBInput_11.getInt(15);
            if(rs_tDBInput_11.wasNull()){
                    row9.FUELING_SUPPLIER_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_11 < 16) {
								row9.FUELING_PRODUCT_NUMBER = null;
							} else {
		                          
            row9.FUELING_PRODUCT_NUMBER = rs_tDBInput_11.getInt(16);
            if(rs_tDBInput_11.wasNull()){
                    row9.FUELING_PRODUCT_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_11 < 17) {
								row9.LAST_USER_NAME = null;
							} else {
	                         		
           		tmpContent_tDBInput_11 = rs_tDBInput_11.getString(17);
            if(tmpContent_tDBInput_11 != null) {
            	if (talendToDBList_tDBInput_11 .contains(rsmd_tDBInput_11.getColumnTypeName(17).toUpperCase(java.util.Locale.ENGLISH))) {
            		row9.LAST_USER_NAME = FormatterUtils.formatUnwithE(tmpContent_tDBInput_11);
            	} else {
                	row9.LAST_USER_NAME = tmpContent_tDBInput_11;
                }
            } else {
                row9.LAST_USER_NAME = null;
            }
		                    }
							if(colQtyInRs_tDBInput_11 < 18) {
								row9.LAST_MODIFIED = null;
							} else {
										
			row9.LAST_MODIFIED = mssqlGTU_tDBInput_11.getDate(rsmd_tDBInput_11, rs_tDBInput_11, 18);
			
		                    }
							if(colQtyInRs_tDBInput_11 < 19) {
								row9.LOADING_TYPE = null;
							} else {
		                          
            row9.LOADING_TYPE = rs_tDBInput_11.getInt(19);
            if(rs_tDBInput_11.wasNull()){
                    row9.LOADING_TYPE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_11 < 20) {
								row9.HOST_TRAILER_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_11 = rs_tDBInput_11.getString(20);
            if(tmpContent_tDBInput_11 != null) {
            	if (talendToDBList_tDBInput_11 .contains(rsmd_tDBInput_11.getColumnTypeName(20).toUpperCase(java.util.Locale.ENGLISH))) {
            		row9.HOST_TRAILER_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_11);
            	} else {
                	row9.HOST_TRAILER_CODE = tmpContent_tDBInput_11;
                }
            } else {
                row9.HOST_TRAILER_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_11 < 21) {
								row9.HOST_ALTERNATE_TRAILER_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_11 = rs_tDBInput_11.getString(21);
            if(tmpContent_tDBInput_11 != null) {
            	if (talendToDBList_tDBInput_11 .contains(rsmd_tDBInput_11.getColumnTypeName(21).toUpperCase(java.util.Locale.ENGLISH))) {
            		row9.HOST_ALTERNATE_TRAILER_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_11);
            	} else {
                	row9.HOST_ALTERNATE_TRAILER_CODE = tmpContent_tDBInput_11;
                }
            } else {
                row9.HOST_ALTERNATE_TRAILER_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_11 < 22) {
								row9.PETROEX_TRUCK_NUMBER = 0;
							} else {
		                          
            row9.PETROEX_TRUCK_NUMBER = rs_tDBInput_11.getInt(22);
            if(rs_tDBInput_11.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_11 < 23) {
								row9.USABLE_CAPACITY = 0;
							} else {
		                          
            row9.USABLE_CAPACITY = rs_tDBInput_11.getInt(23);
            if(rs_tDBInput_11.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_11 < 24) {
								row9.PETROEX_VEHICLE_TYPE = null;
							} else {
	                         		
           		tmpContent_tDBInput_11 = rs_tDBInput_11.getString(24);
            if(tmpContent_tDBInput_11 != null) {
            	if (talendToDBList_tDBInput_11 .contains(rsmd_tDBInput_11.getColumnTypeName(24).toUpperCase(java.util.Locale.ENGLISH))) {
            		row9.PETROEX_VEHICLE_TYPE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_11);
            	} else {
                	row9.PETROEX_VEHICLE_TYPE = tmpContent_tDBInput_11;
                }
            } else {
                row9.PETROEX_VEHICLE_TYPE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_11 < 25) {
								row9.MULTI_LOADING_LIMIT = 0;
							} else {
		                          
            row9.MULTI_LOADING_LIMIT = rs_tDBInput_11.getInt(25);
            if(rs_tDBInput_11.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_11 < 26) {
								row9.CARD_NUMBER = null;
							} else {
	                         		
           		tmpContent_tDBInput_11 = rs_tDBInput_11.getString(26);
            if(tmpContent_tDBInput_11 != null) {
            	if (talendToDBList_tDBInput_11 .contains(rsmd_tDBInput_11.getColumnTypeName(26).toUpperCase(java.util.Locale.ENGLISH))) {
            		row9.CARD_NUMBER = FormatterUtils.formatUnwithE(tmpContent_tDBInput_11);
            	} else {
                	row9.CARD_NUMBER = tmpContent_tDBInput_11;
                }
            } else {
                row9.CARD_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_11 < 27) {
								row9.MAX_TARE_WEIGHT = 0;
							} else {
		                          
            row9.MAX_TARE_WEIGHT = rs_tDBInput_11.getInt(27);
            if(rs_tDBInput_11.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_11 < 28) {
								row9.REQUIRES_RESTRICTED_FLOW = 0;
							} else {
		                          
            row9.REQUIRES_RESTRICTED_FLOW = rs_tDBInput_11.getInt(28);
            if(rs_tDBInput_11.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_11 < 29) {
								row9.REPEAT_ORDER_ID = 0;
							} else {
		                          
            row9.REPEAT_ORDER_ID = rs_tDBInput_11.getInt(29);
            if(rs_tDBInput_11.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_11 < 30) {
								row9.REQUIRES_RESTRICTED_LOW_FLOW = 0;
							} else {
		                          
            row9.REQUIRES_RESTRICTED_LOW_FLOW = rs_tDBInput_11.getInt(30);
            if(rs_tDBInput_11.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_11 < 31) {
								row9.GLOBAL_LOCKOUT = 0;
							} else {
		                          
            row9.GLOBAL_LOCKOUT = rs_tDBInput_11.getInt(31);
            if(rs_tDBInput_11.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_11 < 32) {
								row9.GLOBAL_LOCKOUT_REASON = null;
							} else {
	                         		
           		tmpContent_tDBInput_11 = rs_tDBInput_11.getString(32);
            if(tmpContent_tDBInput_11 != null) {
            	if (talendToDBList_tDBInput_11 .contains(rsmd_tDBInput_11.getColumnTypeName(32).toUpperCase(java.util.Locale.ENGLISH))) {
            		row9.GLOBAL_LOCKOUT_REASON = FormatterUtils.formatUnwithE(tmpContent_tDBInput_11);
            	} else {
                	row9.GLOBAL_LOCKOUT_REASON = tmpContent_tDBInput_11;
                }
            } else {
                row9.GLOBAL_LOCKOUT_REASON = null;
            }
		                    }
							if(colQtyInRs_tDBInput_11 < 33) {
								row9.GLOBAL_LOCKOUT_USER = null;
							} else {
	                         		
           		tmpContent_tDBInput_11 = rs_tDBInput_11.getString(33);
            if(tmpContent_tDBInput_11 != null) {
            	if (talendToDBList_tDBInput_11 .contains(rsmd_tDBInput_11.getColumnTypeName(33).toUpperCase(java.util.Locale.ENGLISH))) {
            		row9.GLOBAL_LOCKOUT_USER = FormatterUtils.formatUnwithE(tmpContent_tDBInput_11);
            	} else {
                	row9.GLOBAL_LOCKOUT_USER = tmpContent_tDBInput_11;
                }
            } else {
                row9.GLOBAL_LOCKOUT_USER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_11 < 34) {
								row9.GLOBAL_LOCKOUT_TERMINAL_ID = 0;
							} else {
		                          
            row9.GLOBAL_LOCKOUT_TERMINAL_ID = rs_tDBInput_11.getInt(34);
            if(rs_tDBInput_11.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_11 < 35) {
								row9.RT_CURRENT_VISIT_ID = null;
							} else {
		                          
            row9.RT_CURRENT_VISIT_ID = rs_tDBInput_11.getInt(35);
            if(rs_tDBInput_11.wasNull()){
                    row9.RT_CURRENT_VISIT_ID = null;
            }
		                    }
							if(colQtyInRs_tDBInput_11 < 36) {
								row9.UNLADEN_WEIGHT = 0;
							} else {
		                          
            row9.UNLADEN_WEIGHT = rs_tDBInput_11.getInt(36);
            if(rs_tDBInput_11.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_11 < 37) {
								row9.MAXIMUM_WEIGHT = 0;
							} else {
		                          
            row9.MAXIMUM_WEIGHT = rs_tDBInput_11.getInt(37);
            if(rs_tDBInput_11.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_11 < 38) {
								row9.LOAD_TIME_TRAILER_ID_ENABLE = 0;
							} else {
		                          
            row9.LOAD_TIME_TRAILER_ID_ENABLE = rs_tDBInput_11.getInt(38);
            if(rs_tDBInput_11.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
					





 



/**
 * [tDBInput_11 begin ] stop
 */
	
	/**
	 * [tDBInput_11 main ] start
	 */

	

	
	
	currentComponent="tDBInput_11";

	

 


	tos_count_tDBInput_11++;

/**
 * [tDBInput_11 main ] stop
 */
	
	/**
	 * [tDBInput_11 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_11";

	

 



/**
 * [tDBInput_11 process_data_begin ] stop
 */

	
	/**
	 * [tAdvancedHash_row9 main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row9";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row9"
						
						);
					}
					


			   
			   

					row9Struct row9_HashRow = new row9Struct();
		   	   	   
				
				row9_HashRow.CARRIER_NUMBER = row9.CARRIER_NUMBER;
				
				row9_HashRow.TRAILER_CODE = row9.TRAILER_CODE;
				
				row9_HashRow.TABS_TRUCK_NUMBER = row9.TABS_TRUCK_NUMBER;
				
				row9_HashRow.LICENSE = row9.LICENSE;
				
				row9_HashRow.STATE = row9.STATE;
				
				row9_HashRow.RT_CURRENTLY_LOADING = row9.RT_CURRENTLY_LOADING;
				
				row9_HashRow.SERIAL_NUMBER = row9.SERIAL_NUMBER;
				
				row9_HashRow.LOCKOUT_LOADING = row9.LOCKOUT_LOADING;
				
				row9_HashRow.REQUIRES_INTERVENTION = row9.REQUIRES_INTERVENTION;
				
				row9_HashRow.LOCKOUT_LOADING_REASON = row9.LOCKOUT_LOADING_REASON;
				
				row9_HashRow.RT_LAST_ORDER_ID = row9.RT_LAST_ORDER_ID;
				
				row9_HashRow.LOCKOUT_ENTRY = row9.LOCKOUT_ENTRY;
				
				row9_HashRow.LOCKOUT_ENTRY_REASON = row9.LOCKOUT_ENTRY_REASON;
				
				row9_HashRow.ENTER_TERMINAL = row9.ENTER_TERMINAL;
				
				row9_HashRow.FUELING_SUPPLIER_NUMBER = row9.FUELING_SUPPLIER_NUMBER;
				
				row9_HashRow.FUELING_PRODUCT_NUMBER = row9.FUELING_PRODUCT_NUMBER;
				
				row9_HashRow.LAST_USER_NAME = row9.LAST_USER_NAME;
				
				row9_HashRow.LAST_MODIFIED = row9.LAST_MODIFIED;
				
				row9_HashRow.LOADING_TYPE = row9.LOADING_TYPE;
				
				row9_HashRow.HOST_TRAILER_CODE = row9.HOST_TRAILER_CODE;
				
				row9_HashRow.HOST_ALTERNATE_TRAILER_CODE = row9.HOST_ALTERNATE_TRAILER_CODE;
				
				row9_HashRow.PETROEX_TRUCK_NUMBER = row9.PETROEX_TRUCK_NUMBER;
				
				row9_HashRow.USABLE_CAPACITY = row9.USABLE_CAPACITY;
				
				row9_HashRow.PETROEX_VEHICLE_TYPE = row9.PETROEX_VEHICLE_TYPE;
				
				row9_HashRow.MULTI_LOADING_LIMIT = row9.MULTI_LOADING_LIMIT;
				
				row9_HashRow.CARD_NUMBER = row9.CARD_NUMBER;
				
				row9_HashRow.MAX_TARE_WEIGHT = row9.MAX_TARE_WEIGHT;
				
				row9_HashRow.REQUIRES_RESTRICTED_FLOW = row9.REQUIRES_RESTRICTED_FLOW;
				
				row9_HashRow.REPEAT_ORDER_ID = row9.REPEAT_ORDER_ID;
				
				row9_HashRow.REQUIRES_RESTRICTED_LOW_FLOW = row9.REQUIRES_RESTRICTED_LOW_FLOW;
				
				row9_HashRow.GLOBAL_LOCKOUT = row9.GLOBAL_LOCKOUT;
				
				row9_HashRow.GLOBAL_LOCKOUT_REASON = row9.GLOBAL_LOCKOUT_REASON;
				
				row9_HashRow.GLOBAL_LOCKOUT_USER = row9.GLOBAL_LOCKOUT_USER;
				
				row9_HashRow.GLOBAL_LOCKOUT_TERMINAL_ID = row9.GLOBAL_LOCKOUT_TERMINAL_ID;
				
				row9_HashRow.RT_CURRENT_VISIT_ID = row9.RT_CURRENT_VISIT_ID;
				
				row9_HashRow.UNLADEN_WEIGHT = row9.UNLADEN_WEIGHT;
				
				row9_HashRow.MAXIMUM_WEIGHT = row9.MAXIMUM_WEIGHT;
				
				row9_HashRow.LOAD_TIME_TRAILER_ID_ENABLE = row9.LOAD_TIME_TRAILER_ID_ENABLE;
				
			tHash_Lookup_row9.put(row9_HashRow);
			
            




 


	tos_count_tAdvancedHash_row9++;

/**
 * [tAdvancedHash_row9 main ] stop
 */
	
	/**
	 * [tAdvancedHash_row9 process_data_begin ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row9";

	

 



/**
 * [tAdvancedHash_row9 process_data_begin ] stop
 */
	
	/**
	 * [tAdvancedHash_row9 process_data_end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row9";

	

 



/**
 * [tAdvancedHash_row9 process_data_end ] stop
 */



	
	/**
	 * [tDBInput_11 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_11";

	

 



/**
 * [tDBInput_11 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_11 end ] start
	 */

	

	
	
	currentComponent="tDBInput_11";

	

	}
}finally{
	if (rs_tDBInput_11 != null) {
		rs_tDBInput_11.close();
	}
	if (stmt_tDBInput_11 != null) {
		stmt_tDBInput_11.close();
	}
		if(conn_tDBInput_11 != null && !conn_tDBInput_11.isClosed()) {
			
			conn_tDBInput_11.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
		}
}
globalMap.put("tDBInput_11_NB_LINE",nb_line_tDBInput_11);

 

ok_Hash.put("tDBInput_11", true);
end_Hash.put("tDBInput_11", System.currentTimeMillis());




/**
 * [tDBInput_11 end ] stop
 */

	
	/**
	 * [tAdvancedHash_row9 end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row9";

	

tHash_Lookup_row9.endPut();

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row9");
			  	}
			  	
 

ok_Hash.put("tAdvancedHash_row9", true);
end_Hash.put("tAdvancedHash_row9", System.currentTimeMillis());




/**
 * [tAdvancedHash_row9 end ] stop
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
	 * [tDBInput_11 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_11";

	

 



/**
 * [tDBInput_11 finally ] stop
 */

	
	/**
	 * [tAdvancedHash_row9 finally ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row9";

	

 



/**
 * [tAdvancedHash_row9 finally ] stop
 */



				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBInput_11_SUBPROCESS_STATE", 1);
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
        final FACT_SALES_SAM FACT_SALES_SAMClass = new FACT_SALES_SAM();

        int exitCode = FACT_SALES_SAMClass.runJobInTOS(args);

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
            java.io.InputStream inContext = FACT_SALES_SAM.class.getClassLoader().getResourceAsStream("pgs_stage/fact_sales_sam_0_1/contexts/" + contextStr + ".properties");
            if (inContext == null) {
                inContext = FACT_SALES_SAM.class.getClassLoader().getResourceAsStream("config/contexts/" + contextStr + ".properties");
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
            System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : FACT_SALES_SAM");
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
 *     629008 characters generated by Talend Open Studio for Data Integration 
 *     on the 3 août 2024 à 14:42:27 GMT+01:00
 ************************************************************************************************/