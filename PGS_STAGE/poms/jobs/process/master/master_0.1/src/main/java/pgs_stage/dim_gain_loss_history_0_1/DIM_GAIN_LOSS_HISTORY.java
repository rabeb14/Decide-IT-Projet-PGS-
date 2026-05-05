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


package pgs_stage.dim_gain_loss_history_0_1;

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
 * Job: DIM_GAIN_LOSS_HISTORY Purpose: <br>
 * Description:  <br>
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status 
 */
public class DIM_GAIN_LOSS_HISTORY implements TalendJob {

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
	private final String jobName = "DIM_GAIN_LOSS_HISTORY";
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
				DIM_GAIN_LOSS_HISTORY.this.exception = e;
			}
		}
		if (!(e instanceof TalendException)) {
		try {
			for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
				if (m.getName().compareTo(currentComponent + "_error") == 0) {
					m.invoke(DIM_GAIN_LOSS_HISTORY.this, new Object[] { e , currentComponent, globalMap});
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
    final static byte[] commonByteArrayLock_PGS_STAGE_DIM_GAIN_LOSS_HISTORY = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_DIM_GAIN_LOSS_HISTORY = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public Integer PK_GAIN_LOSS_HISTORY;

				public Integer getPK_GAIN_LOSS_HISTORY () {
					return this.PK_GAIN_LOSS_HISTORY;
				}
				
			    public int TERMINAL_PRODUCT_NUMBER;

				public int getTERMINAL_PRODUCT_NUMBER () {
					return this.TERMINAL_PRODUCT_NUMBER;
				}
				
			    public java.util.Date DATE;

				public java.util.Date getDATE () {
					return this.DATE;
				}
				
			    public String FOLIO_NUMBER;

				public String getFOLIO_NUMBER () {
					return this.FOLIO_NUMBER;
				}
				
			    public String TANK_CODE;

				public String getTANK_CODE () {
					return this.TANK_CODE;
				}
				
			    public int GAIN_LOSS_ID;

				public int getGAIN_LOSS_ID () {
					return this.GAIN_LOSS_ID;
				}
				
			    public String PRODUCT_GROUP_CODE;

				public String getPRODUCT_GROUP_CODE () {
					return this.PRODUCT_GROUP_CODE;
				}
				
			    public int OPENING_PHYSICAL;

				public int getOPENING_PHYSICAL () {
					return this.OPENING_PHYSICAL;
				}
				
			    public int BULK_RECEIPTS;

				public int getBULK_RECEIPTS () {
					return this.BULK_RECEIPTS;
				}
				
			    public int BULK_TRANSFERS_IN;

				public int getBULK_TRANSFERS_IN () {
					return this.BULK_TRANSFERS_IN;
				}
				
			    public int BULK_TRANSFERS_OUT;

				public int getBULK_TRANSFERS_OUT () {
					return this.BULK_TRANSFERS_OUT;
				}
				
			    public int RACK_DISPOSALS;

				public int getRACK_DISPOSALS () {
					return this.RACK_DISPOSALS;
				}
				
			    public int CLOSING_PHYSICAL;

				public int getCLOSING_PHYSICAL () {
					return this.CLOSING_PHYSICAL;
				}
				
			    public int GAIN_LOSS;

				public int getGAIN_LOSS () {
					return this.GAIN_LOSS;
				}
				
			    public int OPENING_PHYSICAL_GROSS_QTY;

				public int getOPENING_PHYSICAL_GROSS_QTY () {
					return this.OPENING_PHYSICAL_GROSS_QTY;
				}
				
			    public int CLOSING_PHYSICAL_GROSS_QTY;

				public int getCLOSING_PHYSICAL_GROSS_QTY () {
					return this.CLOSING_PHYSICAL_GROSS_QTY;
				}
				
			    public double OPENING_TEMPERATURE;

				public double getOPENING_TEMPERATURE () {
					return this.OPENING_TEMPERATURE;
				}
				
			    public double CLOSING_TEMPERATURE;

				public double getCLOSING_TEMPERATURE () {
					return this.CLOSING_TEMPERATURE;
				}
				
			    public double OPENING_DENSITY;

				public double getOPENING_DENSITY () {
					return this.OPENING_DENSITY;
				}
				
			    public double CLOSING_DENSITY;

				public double getCLOSING_DENSITY () {
					return this.CLOSING_DENSITY;
				}
				
			    public int OPENING_BSW_QTY;

				public int getOPENING_BSW_QTY () {
					return this.OPENING_BSW_QTY;
				}
				
			    public int CLOSING_BSW_QTY;

				public int getCLOSING_BSW_QTY () {
					return this.CLOSING_BSW_QTY;
				}
				
			    public String OPENING_LEVEL;

				public String getOPENING_LEVEL () {
					return this.OPENING_LEVEL;
				}
				
			    public String CLOSING_LEVEL;

				public String getCLOSING_LEVEL () {
					return this.CLOSING_LEVEL;
				}
				
			    public double OPENING_OBSERVED_DENSITY;

				public double getOPENING_OBSERVED_DENSITY () {
					return this.OPENING_OBSERVED_DENSITY;
				}
				
			    public double CLOSING_OBSERVED_DENSITY;

				public double getCLOSING_OBSERVED_DENSITY () {
					return this.CLOSING_OBSERVED_DENSITY;
				}
				
			    public String OPENING_BSW_LEVEL;

				public String getOPENING_BSW_LEVEL () {
					return this.OPENING_BSW_LEVEL;
				}
				
			    public String CLOSING_BSW_LEVEL;

				public String getCLOSING_BSW_LEVEL () {
					return this.CLOSING_BSW_LEVEL;
				}
				
			    public int OPENING_TOV;

				public int getOPENING_TOV () {
					return this.OPENING_TOV;
				}
				
			    public int CLOSING_TOV;

				public int getCLOSING_TOV () {
					return this.CLOSING_TOV;
				}
				
			    public int OPENING_GOV;

				public int getOPENING_GOV () {
					return this.OPENING_GOV;
				}
				
			    public int CLOSING_GOV;

				public int getCLOSING_GOV () {
					return this.CLOSING_GOV;
				}
				
			    public int OPENING_GSV;

				public int getOPENING_GSV () {
					return this.OPENING_GSV;
				}
				
			    public int CLOSING_GSV;

				public int getCLOSING_GSV () {
					return this.CLOSING_GSV;
				}
				
			    public int OPENING_TCV;

				public int getOPENING_TCV () {
					return this.OPENING_TCV;
				}
				
			    public int CLOSING_TCV;

				public int getCLOSING_TCV () {
					return this.CLOSING_TCV;
				}
				
			    public double OPENING_CTL;

				public double getOPENING_CTL () {
					return this.OPENING_CTL;
				}
				
			    public double CLOSING_CTL;

				public double getCLOSING_CTL () {
					return this.CLOSING_CTL;
				}
				
			    public double OPENING_AMBIENT_TEMPERATURE;

				public double getOPENING_AMBIENT_TEMPERATURE () {
					return this.OPENING_AMBIENT_TEMPERATURE;
				}
				
			    public double CLOSING_AMBIENT_TEMPERATURE;

				public double getCLOSING_AMBIENT_TEMPERATURE () {
					return this.CLOSING_AMBIENT_TEMPERATURE;
				}
				
			    public int OPENING_GSW;

				public int getOPENING_GSW () {
					return this.OPENING_GSW;
				}
				
			    public int CLOSING_GSW;

				public int getCLOSING_GSW () {
					return this.CLOSING_GSW;
				}
				
			    public int OPENING_NSW;

				public int getOPENING_NSW () {
					return this.OPENING_NSW;
				}
				
			    public int CLOSING_NSW;

				public int getCLOSING_NSW () {
					return this.CLOSING_NSW;
				}
				
			    public double OPENING_WCF;

				public double getOPENING_WCF () {
					return this.OPENING_WCF;
				}
				
			    public double CLOSING_WCF;

				public double getCLOSING_WCF () {
					return this.CLOSING_WCF;
				}
				
			    public int OPENING_NSV;

				public int getOPENING_NSV () {
					return this.OPENING_NSV;
				}
				
			    public int CLOSING_NSV;

				public int getCLOSING_NSV () {
					return this.CLOSING_NSV;
				}
				
			    public int OPENING_XCTN_GROSS_QTY;

				public int getOPENING_XCTN_GROSS_QTY () {
					return this.OPENING_XCTN_GROSS_QTY;
				}
				
			    public int CLOSING_XCTN_GROSS_QTY;

				public int getCLOSING_XCTN_GROSS_QTY () {
					return this.CLOSING_XCTN_GROSS_QTY;
				}
				
			    public int OPENING_XCTN_NET_QTY;

				public int getOPENING_XCTN_NET_QTY () {
					return this.OPENING_XCTN_NET_QTY;
				}
				
			    public int CLOSING_XCTN_NET_QTY;

				public int getCLOSING_XCTN_NET_QTY () {
					return this.CLOSING_XCTN_NET_QTY;
				}
				
			    public int OPENING_WEIGHT_IN_AIR;

				public int getOPENING_WEIGHT_IN_AIR () {
					return this.OPENING_WEIGHT_IN_AIR;
				}
				
			    public int CLOSING_WEIGHT_IN_AIR;

				public int getCLOSING_WEIGHT_IN_AIR () {
					return this.CLOSING_WEIGHT_IN_AIR;
				}
				
			    public int OPENING_XCTN_WEIGHT;

				public int getOPENING_XCTN_WEIGHT () {
					return this.OPENING_XCTN_WEIGHT;
				}
				
			    public int CLOSING_XCTN_WEIGHT;

				public int getCLOSING_XCTN_WEIGHT () {
					return this.CLOSING_XCTN_WEIGHT;
				}
				
			    public int OPENING_CALCULATION_POINT;

				public int getOPENING_CALCULATION_POINT () {
					return this.OPENING_CALCULATION_POINT;
				}
				
			    public int CLOSING_CALCULATION_POINT;

				public int getCLOSING_CALCULATION_POINT () {
					return this.CLOSING_CALCULATION_POINT;
				}
				
			    public int OPENING_PRODUCT_STRAP_TYPE;

				public int getOPENING_PRODUCT_STRAP_TYPE () {
					return this.OPENING_PRODUCT_STRAP_TYPE;
				}
				
			    public String OPENING_API_CODE;

				public String getOPENING_API_CODE () {
					return this.OPENING_API_CODE;
				}
				
			    public int CLOSING_PRODUCT_STRAP_TYPE;

				public int getCLOSING_PRODUCT_STRAP_TYPE () {
					return this.CLOSING_PRODUCT_STRAP_TYPE;
				}
				
			    public String CLOSING_API_CODE;

				public String getCLOSING_API_CODE () {
					return this.CLOSING_API_CODE;
				}
				
			    public int OPENING_TEMPERATURE_ORIGIN;

				public int getOPENING_TEMPERATURE_ORIGIN () {
					return this.OPENING_TEMPERATURE_ORIGIN;
				}
				
			    public int CLOSING_TEMPERATURE_ORIGIN;

				public int getCLOSING_TEMPERATURE_ORIGIN () {
					return this.CLOSING_TEMPERATURE_ORIGIN;
				}
				
			    public int INVENTORY_QUANTITY_TYPE;

				public int getINVENTORY_QUANTITY_TYPE () {
					return this.INVENTORY_QUANTITY_TYPE;
				}
				
			    public int COMPARTMENT_VISIT_NUMBER;

				public int getCOMPARTMENT_VISIT_NUMBER () {
					return this.COMPARTMENT_VISIT_NUMBER;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.PK_GAIN_LOSS_HISTORY == null) ? 0 : this.PK_GAIN_LOSS_HISTORY.hashCode());
					
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
		
						if (this.PK_GAIN_LOSS_HISTORY == null) {
							if (other.PK_GAIN_LOSS_HISTORY != null)
								return false;
						
						} else if (!this.PK_GAIN_LOSS_HISTORY.equals(other.PK_GAIN_LOSS_HISTORY))
						
							return false;
					

		return true;
    }

	public void copyDataTo(out1Struct other) {

		other.PK_GAIN_LOSS_HISTORY = this.PK_GAIN_LOSS_HISTORY;
	            other.TERMINAL_PRODUCT_NUMBER = this.TERMINAL_PRODUCT_NUMBER;
	            other.DATE = this.DATE;
	            other.FOLIO_NUMBER = this.FOLIO_NUMBER;
	            other.TANK_CODE = this.TANK_CODE;
	            other.GAIN_LOSS_ID = this.GAIN_LOSS_ID;
	            other.PRODUCT_GROUP_CODE = this.PRODUCT_GROUP_CODE;
	            other.OPENING_PHYSICAL = this.OPENING_PHYSICAL;
	            other.BULK_RECEIPTS = this.BULK_RECEIPTS;
	            other.BULK_TRANSFERS_IN = this.BULK_TRANSFERS_IN;
	            other.BULK_TRANSFERS_OUT = this.BULK_TRANSFERS_OUT;
	            other.RACK_DISPOSALS = this.RACK_DISPOSALS;
	            other.CLOSING_PHYSICAL = this.CLOSING_PHYSICAL;
	            other.GAIN_LOSS = this.GAIN_LOSS;
	            other.OPENING_PHYSICAL_GROSS_QTY = this.OPENING_PHYSICAL_GROSS_QTY;
	            other.CLOSING_PHYSICAL_GROSS_QTY = this.CLOSING_PHYSICAL_GROSS_QTY;
	            other.OPENING_TEMPERATURE = this.OPENING_TEMPERATURE;
	            other.CLOSING_TEMPERATURE = this.CLOSING_TEMPERATURE;
	            other.OPENING_DENSITY = this.OPENING_DENSITY;
	            other.CLOSING_DENSITY = this.CLOSING_DENSITY;
	            other.OPENING_BSW_QTY = this.OPENING_BSW_QTY;
	            other.CLOSING_BSW_QTY = this.CLOSING_BSW_QTY;
	            other.OPENING_LEVEL = this.OPENING_LEVEL;
	            other.CLOSING_LEVEL = this.CLOSING_LEVEL;
	            other.OPENING_OBSERVED_DENSITY = this.OPENING_OBSERVED_DENSITY;
	            other.CLOSING_OBSERVED_DENSITY = this.CLOSING_OBSERVED_DENSITY;
	            other.OPENING_BSW_LEVEL = this.OPENING_BSW_LEVEL;
	            other.CLOSING_BSW_LEVEL = this.CLOSING_BSW_LEVEL;
	            other.OPENING_TOV = this.OPENING_TOV;
	            other.CLOSING_TOV = this.CLOSING_TOV;
	            other.OPENING_GOV = this.OPENING_GOV;
	            other.CLOSING_GOV = this.CLOSING_GOV;
	            other.OPENING_GSV = this.OPENING_GSV;
	            other.CLOSING_GSV = this.CLOSING_GSV;
	            other.OPENING_TCV = this.OPENING_TCV;
	            other.CLOSING_TCV = this.CLOSING_TCV;
	            other.OPENING_CTL = this.OPENING_CTL;
	            other.CLOSING_CTL = this.CLOSING_CTL;
	            other.OPENING_AMBIENT_TEMPERATURE = this.OPENING_AMBIENT_TEMPERATURE;
	            other.CLOSING_AMBIENT_TEMPERATURE = this.CLOSING_AMBIENT_TEMPERATURE;
	            other.OPENING_GSW = this.OPENING_GSW;
	            other.CLOSING_GSW = this.CLOSING_GSW;
	            other.OPENING_NSW = this.OPENING_NSW;
	            other.CLOSING_NSW = this.CLOSING_NSW;
	            other.OPENING_WCF = this.OPENING_WCF;
	            other.CLOSING_WCF = this.CLOSING_WCF;
	            other.OPENING_NSV = this.OPENING_NSV;
	            other.CLOSING_NSV = this.CLOSING_NSV;
	            other.OPENING_XCTN_GROSS_QTY = this.OPENING_XCTN_GROSS_QTY;
	            other.CLOSING_XCTN_GROSS_QTY = this.CLOSING_XCTN_GROSS_QTY;
	            other.OPENING_XCTN_NET_QTY = this.OPENING_XCTN_NET_QTY;
	            other.CLOSING_XCTN_NET_QTY = this.CLOSING_XCTN_NET_QTY;
	            other.OPENING_WEIGHT_IN_AIR = this.OPENING_WEIGHT_IN_AIR;
	            other.CLOSING_WEIGHT_IN_AIR = this.CLOSING_WEIGHT_IN_AIR;
	            other.OPENING_XCTN_WEIGHT = this.OPENING_XCTN_WEIGHT;
	            other.CLOSING_XCTN_WEIGHT = this.CLOSING_XCTN_WEIGHT;
	            other.OPENING_CALCULATION_POINT = this.OPENING_CALCULATION_POINT;
	            other.CLOSING_CALCULATION_POINT = this.CLOSING_CALCULATION_POINT;
	            other.OPENING_PRODUCT_STRAP_TYPE = this.OPENING_PRODUCT_STRAP_TYPE;
	            other.OPENING_API_CODE = this.OPENING_API_CODE;
	            other.CLOSING_PRODUCT_STRAP_TYPE = this.CLOSING_PRODUCT_STRAP_TYPE;
	            other.CLOSING_API_CODE = this.CLOSING_API_CODE;
	            other.OPENING_TEMPERATURE_ORIGIN = this.OPENING_TEMPERATURE_ORIGIN;
	            other.CLOSING_TEMPERATURE_ORIGIN = this.CLOSING_TEMPERATURE_ORIGIN;
	            other.INVENTORY_QUANTITY_TYPE = this.INVENTORY_QUANTITY_TYPE;
	            other.COMPARTMENT_VISIT_NUMBER = this.COMPARTMENT_VISIT_NUMBER;
	            
	}

	public void copyKeysDataTo(out1Struct other) {

		other.PK_GAIN_LOSS_HISTORY = this.PK_GAIN_LOSS_HISTORY;
	            	
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

	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PGS_STAGE_DIM_GAIN_LOSS_HISTORY.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_GAIN_LOSS_HISTORY.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_GAIN_LOSS_HISTORY = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_GAIN_LOSS_HISTORY = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PGS_STAGE_DIM_GAIN_LOSS_HISTORY, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_GAIN_LOSS_HISTORY, 0, length, utf8Charset);
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
			if(length > commonByteArray_PGS_STAGE_DIM_GAIN_LOSS_HISTORY.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_GAIN_LOSS_HISTORY.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_GAIN_LOSS_HISTORY = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_GAIN_LOSS_HISTORY = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PGS_STAGE_DIM_GAIN_LOSS_HISTORY, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_GAIN_LOSS_HISTORY, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_GAIN_LOSS_HISTORY) {

        	try {

        		int length = 0;
		
						this.PK_GAIN_LOSS_HISTORY = readInteger(dis);
					
			        this.TERMINAL_PRODUCT_NUMBER = dis.readInt();
					
					this.DATE = readDate(dis);
					
					this.FOLIO_NUMBER = readString(dis);
					
					this.TANK_CODE = readString(dis);
					
			        this.GAIN_LOSS_ID = dis.readInt();
					
					this.PRODUCT_GROUP_CODE = readString(dis);
					
			        this.OPENING_PHYSICAL = dis.readInt();
					
			        this.BULK_RECEIPTS = dis.readInt();
					
			        this.BULK_TRANSFERS_IN = dis.readInt();
					
			        this.BULK_TRANSFERS_OUT = dis.readInt();
					
			        this.RACK_DISPOSALS = dis.readInt();
					
			        this.CLOSING_PHYSICAL = dis.readInt();
					
			        this.GAIN_LOSS = dis.readInt();
					
			        this.OPENING_PHYSICAL_GROSS_QTY = dis.readInt();
					
			        this.CLOSING_PHYSICAL_GROSS_QTY = dis.readInt();
					
			        this.OPENING_TEMPERATURE = dis.readDouble();
					
			        this.CLOSING_TEMPERATURE = dis.readDouble();
					
			        this.OPENING_DENSITY = dis.readDouble();
					
			        this.CLOSING_DENSITY = dis.readDouble();
					
			        this.OPENING_BSW_QTY = dis.readInt();
					
			        this.CLOSING_BSW_QTY = dis.readInt();
					
					this.OPENING_LEVEL = readString(dis);
					
					this.CLOSING_LEVEL = readString(dis);
					
			        this.OPENING_OBSERVED_DENSITY = dis.readDouble();
					
			        this.CLOSING_OBSERVED_DENSITY = dis.readDouble();
					
					this.OPENING_BSW_LEVEL = readString(dis);
					
					this.CLOSING_BSW_LEVEL = readString(dis);
					
			        this.OPENING_TOV = dis.readInt();
					
			        this.CLOSING_TOV = dis.readInt();
					
			        this.OPENING_GOV = dis.readInt();
					
			        this.CLOSING_GOV = dis.readInt();
					
			        this.OPENING_GSV = dis.readInt();
					
			        this.CLOSING_GSV = dis.readInt();
					
			        this.OPENING_TCV = dis.readInt();
					
			        this.CLOSING_TCV = dis.readInt();
					
			        this.OPENING_CTL = dis.readDouble();
					
			        this.CLOSING_CTL = dis.readDouble();
					
			        this.OPENING_AMBIENT_TEMPERATURE = dis.readDouble();
					
			        this.CLOSING_AMBIENT_TEMPERATURE = dis.readDouble();
					
			        this.OPENING_GSW = dis.readInt();
					
			        this.CLOSING_GSW = dis.readInt();
					
			        this.OPENING_NSW = dis.readInt();
					
			        this.CLOSING_NSW = dis.readInt();
					
			        this.OPENING_WCF = dis.readDouble();
					
			        this.CLOSING_WCF = dis.readDouble();
					
			        this.OPENING_NSV = dis.readInt();
					
			        this.CLOSING_NSV = dis.readInt();
					
			        this.OPENING_XCTN_GROSS_QTY = dis.readInt();
					
			        this.CLOSING_XCTN_GROSS_QTY = dis.readInt();
					
			        this.OPENING_XCTN_NET_QTY = dis.readInt();
					
			        this.CLOSING_XCTN_NET_QTY = dis.readInt();
					
			        this.OPENING_WEIGHT_IN_AIR = dis.readInt();
					
			        this.CLOSING_WEIGHT_IN_AIR = dis.readInt();
					
			        this.OPENING_XCTN_WEIGHT = dis.readInt();
					
			        this.CLOSING_XCTN_WEIGHT = dis.readInt();
					
			        this.OPENING_CALCULATION_POINT = dis.readInt();
					
			        this.CLOSING_CALCULATION_POINT = dis.readInt();
					
			        this.OPENING_PRODUCT_STRAP_TYPE = dis.readInt();
					
					this.OPENING_API_CODE = readString(dis);
					
			        this.CLOSING_PRODUCT_STRAP_TYPE = dis.readInt();
					
					this.CLOSING_API_CODE = readString(dis);
					
			        this.OPENING_TEMPERATURE_ORIGIN = dis.readInt();
					
			        this.CLOSING_TEMPERATURE_ORIGIN = dis.readInt();
					
			        this.INVENTORY_QUANTITY_TYPE = dis.readInt();
					
			        this.COMPARTMENT_VISIT_NUMBER = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_GAIN_LOSS_HISTORY) {

        	try {

        		int length = 0;
		
						this.PK_GAIN_LOSS_HISTORY = readInteger(dis);
					
			        this.TERMINAL_PRODUCT_NUMBER = dis.readInt();
					
					this.DATE = readDate(dis);
					
					this.FOLIO_NUMBER = readString(dis);
					
					this.TANK_CODE = readString(dis);
					
			        this.GAIN_LOSS_ID = dis.readInt();
					
					this.PRODUCT_GROUP_CODE = readString(dis);
					
			        this.OPENING_PHYSICAL = dis.readInt();
					
			        this.BULK_RECEIPTS = dis.readInt();
					
			        this.BULK_TRANSFERS_IN = dis.readInt();
					
			        this.BULK_TRANSFERS_OUT = dis.readInt();
					
			        this.RACK_DISPOSALS = dis.readInt();
					
			        this.CLOSING_PHYSICAL = dis.readInt();
					
			        this.GAIN_LOSS = dis.readInt();
					
			        this.OPENING_PHYSICAL_GROSS_QTY = dis.readInt();
					
			        this.CLOSING_PHYSICAL_GROSS_QTY = dis.readInt();
					
			        this.OPENING_TEMPERATURE = dis.readDouble();
					
			        this.CLOSING_TEMPERATURE = dis.readDouble();
					
			        this.OPENING_DENSITY = dis.readDouble();
					
			        this.CLOSING_DENSITY = dis.readDouble();
					
			        this.OPENING_BSW_QTY = dis.readInt();
					
			        this.CLOSING_BSW_QTY = dis.readInt();
					
					this.OPENING_LEVEL = readString(dis);
					
					this.CLOSING_LEVEL = readString(dis);
					
			        this.OPENING_OBSERVED_DENSITY = dis.readDouble();
					
			        this.CLOSING_OBSERVED_DENSITY = dis.readDouble();
					
					this.OPENING_BSW_LEVEL = readString(dis);
					
					this.CLOSING_BSW_LEVEL = readString(dis);
					
			        this.OPENING_TOV = dis.readInt();
					
			        this.CLOSING_TOV = dis.readInt();
					
			        this.OPENING_GOV = dis.readInt();
					
			        this.CLOSING_GOV = dis.readInt();
					
			        this.OPENING_GSV = dis.readInt();
					
			        this.CLOSING_GSV = dis.readInt();
					
			        this.OPENING_TCV = dis.readInt();
					
			        this.CLOSING_TCV = dis.readInt();
					
			        this.OPENING_CTL = dis.readDouble();
					
			        this.CLOSING_CTL = dis.readDouble();
					
			        this.OPENING_AMBIENT_TEMPERATURE = dis.readDouble();
					
			        this.CLOSING_AMBIENT_TEMPERATURE = dis.readDouble();
					
			        this.OPENING_GSW = dis.readInt();
					
			        this.CLOSING_GSW = dis.readInt();
					
			        this.OPENING_NSW = dis.readInt();
					
			        this.CLOSING_NSW = dis.readInt();
					
			        this.OPENING_WCF = dis.readDouble();
					
			        this.CLOSING_WCF = dis.readDouble();
					
			        this.OPENING_NSV = dis.readInt();
					
			        this.CLOSING_NSV = dis.readInt();
					
			        this.OPENING_XCTN_GROSS_QTY = dis.readInt();
					
			        this.CLOSING_XCTN_GROSS_QTY = dis.readInt();
					
			        this.OPENING_XCTN_NET_QTY = dis.readInt();
					
			        this.CLOSING_XCTN_NET_QTY = dis.readInt();
					
			        this.OPENING_WEIGHT_IN_AIR = dis.readInt();
					
			        this.CLOSING_WEIGHT_IN_AIR = dis.readInt();
					
			        this.OPENING_XCTN_WEIGHT = dis.readInt();
					
			        this.CLOSING_XCTN_WEIGHT = dis.readInt();
					
			        this.OPENING_CALCULATION_POINT = dis.readInt();
					
			        this.CLOSING_CALCULATION_POINT = dis.readInt();
					
			        this.OPENING_PRODUCT_STRAP_TYPE = dis.readInt();
					
					this.OPENING_API_CODE = readString(dis);
					
			        this.CLOSING_PRODUCT_STRAP_TYPE = dis.readInt();
					
					this.CLOSING_API_CODE = readString(dis);
					
			        this.OPENING_TEMPERATURE_ORIGIN = dis.readInt();
					
			        this.CLOSING_TEMPERATURE_ORIGIN = dis.readInt();
					
			        this.INVENTORY_QUANTITY_TYPE = dis.readInt();
					
			        this.COMPARTMENT_VISIT_NUMBER = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// Integer
				
						writeInteger(this.PK_GAIN_LOSS_HISTORY,dos);
					
					// int
				
		            	dos.writeInt(this.TERMINAL_PRODUCT_NUMBER);
					
					// java.util.Date
				
						writeDate(this.DATE,dos);
					
					// String
				
						writeString(this.FOLIO_NUMBER,dos);
					
					// String
				
						writeString(this.TANK_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.GAIN_LOSS_ID);
					
					// String
				
						writeString(this.PRODUCT_GROUP_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.OPENING_PHYSICAL);
					
					// int
				
		            	dos.writeInt(this.BULK_RECEIPTS);
					
					// int
				
		            	dos.writeInt(this.BULK_TRANSFERS_IN);
					
					// int
				
		            	dos.writeInt(this.BULK_TRANSFERS_OUT);
					
					// int
				
		            	dos.writeInt(this.RACK_DISPOSALS);
					
					// int
				
		            	dos.writeInt(this.CLOSING_PHYSICAL);
					
					// int
				
		            	dos.writeInt(this.GAIN_LOSS);
					
					// int
				
		            	dos.writeInt(this.OPENING_PHYSICAL_GROSS_QTY);
					
					// int
				
		            	dos.writeInt(this.CLOSING_PHYSICAL_GROSS_QTY);
					
					// double
				
		            	dos.writeDouble(this.OPENING_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.OPENING_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_DENSITY);
					
					// int
				
		            	dos.writeInt(this.OPENING_BSW_QTY);
					
					// int
				
		            	dos.writeInt(this.CLOSING_BSW_QTY);
					
					// String
				
						writeString(this.OPENING_LEVEL,dos);
					
					// String
				
						writeString(this.CLOSING_LEVEL,dos);
					
					// double
				
		            	dos.writeDouble(this.OPENING_OBSERVED_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_OBSERVED_DENSITY);
					
					// String
				
						writeString(this.OPENING_BSW_LEVEL,dos);
					
					// String
				
						writeString(this.CLOSING_BSW_LEVEL,dos);
					
					// int
				
		            	dos.writeInt(this.OPENING_TOV);
					
					// int
				
		            	dos.writeInt(this.CLOSING_TOV);
					
					// int
				
		            	dos.writeInt(this.OPENING_GOV);
					
					// int
				
		            	dos.writeInt(this.CLOSING_GOV);
					
					// int
				
		            	dos.writeInt(this.OPENING_GSV);
					
					// int
				
		            	dos.writeInt(this.CLOSING_GSV);
					
					// int
				
		            	dos.writeInt(this.OPENING_TCV);
					
					// int
				
		            	dos.writeInt(this.CLOSING_TCV);
					
					// double
				
		            	dos.writeDouble(this.OPENING_CTL);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_CTL);
					
					// double
				
		            	dos.writeDouble(this.OPENING_AMBIENT_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_AMBIENT_TEMPERATURE);
					
					// int
				
		            	dos.writeInt(this.OPENING_GSW);
					
					// int
				
		            	dos.writeInt(this.CLOSING_GSW);
					
					// int
				
		            	dos.writeInt(this.OPENING_NSW);
					
					// int
				
		            	dos.writeInt(this.CLOSING_NSW);
					
					// double
				
		            	dos.writeDouble(this.OPENING_WCF);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_WCF);
					
					// int
				
		            	dos.writeInt(this.OPENING_NSV);
					
					// int
				
		            	dos.writeInt(this.CLOSING_NSV);
					
					// int
				
		            	dos.writeInt(this.OPENING_XCTN_GROSS_QTY);
					
					// int
				
		            	dos.writeInt(this.CLOSING_XCTN_GROSS_QTY);
					
					// int
				
		            	dos.writeInt(this.OPENING_XCTN_NET_QTY);
					
					// int
				
		            	dos.writeInt(this.CLOSING_XCTN_NET_QTY);
					
					// int
				
		            	dos.writeInt(this.OPENING_WEIGHT_IN_AIR);
					
					// int
				
		            	dos.writeInt(this.CLOSING_WEIGHT_IN_AIR);
					
					// int
				
		            	dos.writeInt(this.OPENING_XCTN_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.CLOSING_XCTN_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.OPENING_CALCULATION_POINT);
					
					// int
				
		            	dos.writeInt(this.CLOSING_CALCULATION_POINT);
					
					// int
				
		            	dos.writeInt(this.OPENING_PRODUCT_STRAP_TYPE);
					
					// String
				
						writeString(this.OPENING_API_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.CLOSING_PRODUCT_STRAP_TYPE);
					
					// String
				
						writeString(this.CLOSING_API_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.OPENING_TEMPERATURE_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.CLOSING_TEMPERATURE_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.INVENTORY_QUANTITY_TYPE);
					
					// int
				
		            	dos.writeInt(this.COMPARTMENT_VISIT_NUMBER);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Integer
				
						writeInteger(this.PK_GAIN_LOSS_HISTORY,dos);
					
					// int
				
		            	dos.writeInt(this.TERMINAL_PRODUCT_NUMBER);
					
					// java.util.Date
				
						writeDate(this.DATE,dos);
					
					// String
				
						writeString(this.FOLIO_NUMBER,dos);
					
					// String
				
						writeString(this.TANK_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.GAIN_LOSS_ID);
					
					// String
				
						writeString(this.PRODUCT_GROUP_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.OPENING_PHYSICAL);
					
					// int
				
		            	dos.writeInt(this.BULK_RECEIPTS);
					
					// int
				
		            	dos.writeInt(this.BULK_TRANSFERS_IN);
					
					// int
				
		            	dos.writeInt(this.BULK_TRANSFERS_OUT);
					
					// int
				
		            	dos.writeInt(this.RACK_DISPOSALS);
					
					// int
				
		            	dos.writeInt(this.CLOSING_PHYSICAL);
					
					// int
				
		            	dos.writeInt(this.GAIN_LOSS);
					
					// int
				
		            	dos.writeInt(this.OPENING_PHYSICAL_GROSS_QTY);
					
					// int
				
		            	dos.writeInt(this.CLOSING_PHYSICAL_GROSS_QTY);
					
					// double
				
		            	dos.writeDouble(this.OPENING_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.OPENING_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_DENSITY);
					
					// int
				
		            	dos.writeInt(this.OPENING_BSW_QTY);
					
					// int
				
		            	dos.writeInt(this.CLOSING_BSW_QTY);
					
					// String
				
						writeString(this.OPENING_LEVEL,dos);
					
					// String
				
						writeString(this.CLOSING_LEVEL,dos);
					
					// double
				
		            	dos.writeDouble(this.OPENING_OBSERVED_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_OBSERVED_DENSITY);
					
					// String
				
						writeString(this.OPENING_BSW_LEVEL,dos);
					
					// String
				
						writeString(this.CLOSING_BSW_LEVEL,dos);
					
					// int
				
		            	dos.writeInt(this.OPENING_TOV);
					
					// int
				
		            	dos.writeInt(this.CLOSING_TOV);
					
					// int
				
		            	dos.writeInt(this.OPENING_GOV);
					
					// int
				
		            	dos.writeInt(this.CLOSING_GOV);
					
					// int
				
		            	dos.writeInt(this.OPENING_GSV);
					
					// int
				
		            	dos.writeInt(this.CLOSING_GSV);
					
					// int
				
		            	dos.writeInt(this.OPENING_TCV);
					
					// int
				
		            	dos.writeInt(this.CLOSING_TCV);
					
					// double
				
		            	dos.writeDouble(this.OPENING_CTL);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_CTL);
					
					// double
				
		            	dos.writeDouble(this.OPENING_AMBIENT_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_AMBIENT_TEMPERATURE);
					
					// int
				
		            	dos.writeInt(this.OPENING_GSW);
					
					// int
				
		            	dos.writeInt(this.CLOSING_GSW);
					
					// int
				
		            	dos.writeInt(this.OPENING_NSW);
					
					// int
				
		            	dos.writeInt(this.CLOSING_NSW);
					
					// double
				
		            	dos.writeDouble(this.OPENING_WCF);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_WCF);
					
					// int
				
		            	dos.writeInt(this.OPENING_NSV);
					
					// int
				
		            	dos.writeInt(this.CLOSING_NSV);
					
					// int
				
		            	dos.writeInt(this.OPENING_XCTN_GROSS_QTY);
					
					// int
				
		            	dos.writeInt(this.CLOSING_XCTN_GROSS_QTY);
					
					// int
				
		            	dos.writeInt(this.OPENING_XCTN_NET_QTY);
					
					// int
				
		            	dos.writeInt(this.CLOSING_XCTN_NET_QTY);
					
					// int
				
		            	dos.writeInt(this.OPENING_WEIGHT_IN_AIR);
					
					// int
				
		            	dos.writeInt(this.CLOSING_WEIGHT_IN_AIR);
					
					// int
				
		            	dos.writeInt(this.OPENING_XCTN_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.CLOSING_XCTN_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.OPENING_CALCULATION_POINT);
					
					// int
				
		            	dos.writeInt(this.CLOSING_CALCULATION_POINT);
					
					// int
				
		            	dos.writeInt(this.OPENING_PRODUCT_STRAP_TYPE);
					
					// String
				
						writeString(this.OPENING_API_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.CLOSING_PRODUCT_STRAP_TYPE);
					
					// String
				
						writeString(this.CLOSING_API_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.OPENING_TEMPERATURE_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.CLOSING_TEMPERATURE_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.INVENTORY_QUANTITY_TYPE);
					
					// int
				
		            	dos.writeInt(this.COMPARTMENT_VISIT_NUMBER);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("PK_GAIN_LOSS_HISTORY="+String.valueOf(PK_GAIN_LOSS_HISTORY));
		sb.append(",TERMINAL_PRODUCT_NUMBER="+String.valueOf(TERMINAL_PRODUCT_NUMBER));
		sb.append(",DATE="+String.valueOf(DATE));
		sb.append(",FOLIO_NUMBER="+FOLIO_NUMBER);
		sb.append(",TANK_CODE="+TANK_CODE);
		sb.append(",GAIN_LOSS_ID="+String.valueOf(GAIN_LOSS_ID));
		sb.append(",PRODUCT_GROUP_CODE="+PRODUCT_GROUP_CODE);
		sb.append(",OPENING_PHYSICAL="+String.valueOf(OPENING_PHYSICAL));
		sb.append(",BULK_RECEIPTS="+String.valueOf(BULK_RECEIPTS));
		sb.append(",BULK_TRANSFERS_IN="+String.valueOf(BULK_TRANSFERS_IN));
		sb.append(",BULK_TRANSFERS_OUT="+String.valueOf(BULK_TRANSFERS_OUT));
		sb.append(",RACK_DISPOSALS="+String.valueOf(RACK_DISPOSALS));
		sb.append(",CLOSING_PHYSICAL="+String.valueOf(CLOSING_PHYSICAL));
		sb.append(",GAIN_LOSS="+String.valueOf(GAIN_LOSS));
		sb.append(",OPENING_PHYSICAL_GROSS_QTY="+String.valueOf(OPENING_PHYSICAL_GROSS_QTY));
		sb.append(",CLOSING_PHYSICAL_GROSS_QTY="+String.valueOf(CLOSING_PHYSICAL_GROSS_QTY));
		sb.append(",OPENING_TEMPERATURE="+String.valueOf(OPENING_TEMPERATURE));
		sb.append(",CLOSING_TEMPERATURE="+String.valueOf(CLOSING_TEMPERATURE));
		sb.append(",OPENING_DENSITY="+String.valueOf(OPENING_DENSITY));
		sb.append(",CLOSING_DENSITY="+String.valueOf(CLOSING_DENSITY));
		sb.append(",OPENING_BSW_QTY="+String.valueOf(OPENING_BSW_QTY));
		sb.append(",CLOSING_BSW_QTY="+String.valueOf(CLOSING_BSW_QTY));
		sb.append(",OPENING_LEVEL="+OPENING_LEVEL);
		sb.append(",CLOSING_LEVEL="+CLOSING_LEVEL);
		sb.append(",OPENING_OBSERVED_DENSITY="+String.valueOf(OPENING_OBSERVED_DENSITY));
		sb.append(",CLOSING_OBSERVED_DENSITY="+String.valueOf(CLOSING_OBSERVED_DENSITY));
		sb.append(",OPENING_BSW_LEVEL="+OPENING_BSW_LEVEL);
		sb.append(",CLOSING_BSW_LEVEL="+CLOSING_BSW_LEVEL);
		sb.append(",OPENING_TOV="+String.valueOf(OPENING_TOV));
		sb.append(",CLOSING_TOV="+String.valueOf(CLOSING_TOV));
		sb.append(",OPENING_GOV="+String.valueOf(OPENING_GOV));
		sb.append(",CLOSING_GOV="+String.valueOf(CLOSING_GOV));
		sb.append(",OPENING_GSV="+String.valueOf(OPENING_GSV));
		sb.append(",CLOSING_GSV="+String.valueOf(CLOSING_GSV));
		sb.append(",OPENING_TCV="+String.valueOf(OPENING_TCV));
		sb.append(",CLOSING_TCV="+String.valueOf(CLOSING_TCV));
		sb.append(",OPENING_CTL="+String.valueOf(OPENING_CTL));
		sb.append(",CLOSING_CTL="+String.valueOf(CLOSING_CTL));
		sb.append(",OPENING_AMBIENT_TEMPERATURE="+String.valueOf(OPENING_AMBIENT_TEMPERATURE));
		sb.append(",CLOSING_AMBIENT_TEMPERATURE="+String.valueOf(CLOSING_AMBIENT_TEMPERATURE));
		sb.append(",OPENING_GSW="+String.valueOf(OPENING_GSW));
		sb.append(",CLOSING_GSW="+String.valueOf(CLOSING_GSW));
		sb.append(",OPENING_NSW="+String.valueOf(OPENING_NSW));
		sb.append(",CLOSING_NSW="+String.valueOf(CLOSING_NSW));
		sb.append(",OPENING_WCF="+String.valueOf(OPENING_WCF));
		sb.append(",CLOSING_WCF="+String.valueOf(CLOSING_WCF));
		sb.append(",OPENING_NSV="+String.valueOf(OPENING_NSV));
		sb.append(",CLOSING_NSV="+String.valueOf(CLOSING_NSV));
		sb.append(",OPENING_XCTN_GROSS_QTY="+String.valueOf(OPENING_XCTN_GROSS_QTY));
		sb.append(",CLOSING_XCTN_GROSS_QTY="+String.valueOf(CLOSING_XCTN_GROSS_QTY));
		sb.append(",OPENING_XCTN_NET_QTY="+String.valueOf(OPENING_XCTN_NET_QTY));
		sb.append(",CLOSING_XCTN_NET_QTY="+String.valueOf(CLOSING_XCTN_NET_QTY));
		sb.append(",OPENING_WEIGHT_IN_AIR="+String.valueOf(OPENING_WEIGHT_IN_AIR));
		sb.append(",CLOSING_WEIGHT_IN_AIR="+String.valueOf(CLOSING_WEIGHT_IN_AIR));
		sb.append(",OPENING_XCTN_WEIGHT="+String.valueOf(OPENING_XCTN_WEIGHT));
		sb.append(",CLOSING_XCTN_WEIGHT="+String.valueOf(CLOSING_XCTN_WEIGHT));
		sb.append(",OPENING_CALCULATION_POINT="+String.valueOf(OPENING_CALCULATION_POINT));
		sb.append(",CLOSING_CALCULATION_POINT="+String.valueOf(CLOSING_CALCULATION_POINT));
		sb.append(",OPENING_PRODUCT_STRAP_TYPE="+String.valueOf(OPENING_PRODUCT_STRAP_TYPE));
		sb.append(",OPENING_API_CODE="+OPENING_API_CODE);
		sb.append(",CLOSING_PRODUCT_STRAP_TYPE="+String.valueOf(CLOSING_PRODUCT_STRAP_TYPE));
		sb.append(",CLOSING_API_CODE="+CLOSING_API_CODE);
		sb.append(",OPENING_TEMPERATURE_ORIGIN="+String.valueOf(OPENING_TEMPERATURE_ORIGIN));
		sb.append(",CLOSING_TEMPERATURE_ORIGIN="+String.valueOf(CLOSING_TEMPERATURE_ORIGIN));
		sb.append(",INVENTORY_QUANTITY_TYPE="+String.valueOf(INVENTORY_QUANTITY_TYPE));
		sb.append(",COMPARTMENT_VISIT_NUMBER="+String.valueOf(COMPARTMENT_VISIT_NUMBER));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(out1Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.PK_GAIN_LOSS_HISTORY, other.PK_GAIN_LOSS_HISTORY);
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
    final static byte[] commonByteArrayLock_PGS_STAGE_DIM_GAIN_LOSS_HISTORY = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_DIM_GAIN_LOSS_HISTORY = new byte[0];

	
			    public int TERMINAL_PRODUCT_NUMBER;

				public int getTERMINAL_PRODUCT_NUMBER () {
					return this.TERMINAL_PRODUCT_NUMBER;
				}
				
			    public String FOLIO_NUMBER;

				public String getFOLIO_NUMBER () {
					return this.FOLIO_NUMBER;
				}
				
			    public String TANK_CODE;

				public String getTANK_CODE () {
					return this.TANK_CODE;
				}
				
			    public int GAIN_LOSS_ID;

				public int getGAIN_LOSS_ID () {
					return this.GAIN_LOSS_ID;
				}
				
			    public String TANK_GROUP;

				public String getTANK_GROUP () {
					return this.TANK_GROUP;
				}
				
			    public String PRODUCT_GROUP_CODE;

				public String getPRODUCT_GROUP_CODE () {
					return this.PRODUCT_GROUP_CODE;
				}
				
			    public int OPENING_PHYSICAL;

				public int getOPENING_PHYSICAL () {
					return this.OPENING_PHYSICAL;
				}
				
			    public int BULK_RECEIPTS;

				public int getBULK_RECEIPTS () {
					return this.BULK_RECEIPTS;
				}
				
			    public int BULK_TRANSFERS_IN;

				public int getBULK_TRANSFERS_IN () {
					return this.BULK_TRANSFERS_IN;
				}
				
			    public int BULK_DISPOSALS;

				public int getBULK_DISPOSALS () {
					return this.BULK_DISPOSALS;
				}
				
			    public int BULK_TRANSFERS_OUT;

				public int getBULK_TRANSFERS_OUT () {
					return this.BULK_TRANSFERS_OUT;
				}
				
			    public int RACK_RECEIPTS;

				public int getRACK_RECEIPTS () {
					return this.RACK_RECEIPTS;
				}
				
			    public int RACK_DISPOSALS;

				public int getRACK_DISPOSALS () {
					return this.RACK_DISPOSALS;
				}
				
			    public int CLOSING_PHYSICAL;

				public int getCLOSING_PHYSICAL () {
					return this.CLOSING_PHYSICAL;
				}
				
			    public int MANUAL_CLOSING_PHYSICAL;

				public int getMANUAL_CLOSING_PHYSICAL () {
					return this.MANUAL_CLOSING_PHYSICAL;
				}
				
			    public int GAIN_LOSS;

				public int getGAIN_LOSS () {
					return this.GAIN_LOSS;
				}
				
			    public int RACK_FRAC_RECEIPTS;

				public int getRACK_FRAC_RECEIPTS () {
					return this.RACK_FRAC_RECEIPTS;
				}
				
			    public int RACK_FRAC_DISPOSALS;

				public int getRACK_FRAC_DISPOSALS () {
					return this.RACK_FRAC_DISPOSALS;
				}
				
			    public int BULK_FRAC_TRANSFERS_IN;

				public int getBULK_FRAC_TRANSFERS_IN () {
					return this.BULK_FRAC_TRANSFERS_IN;
				}
				
			    public int BULK_FRAC_TRANSFERS_OUT;

				public int getBULK_FRAC_TRANSFERS_OUT () {
					return this.BULK_FRAC_TRANSFERS_OUT;
				}
				
			    public int ADD_BULK_RECEIPTS;

				public int getADD_BULK_RECEIPTS () {
					return this.ADD_BULK_RECEIPTS;
				}
				
			    public int ADD_RACK_RECEIPTS;

				public int getADD_RACK_RECEIPTS () {
					return this.ADD_RACK_RECEIPTS;
				}
				
			    public int ADD_TRANSFERS_IN;

				public int getADD_TRANSFERS_IN () {
					return this.ADD_TRANSFERS_IN;
				}
				
			    public int ADD_BULK_DISPOSALS;

				public int getADD_BULK_DISPOSALS () {
					return this.ADD_BULK_DISPOSALS;
				}
				
			    public int ADD_RACK_DISPOSALS;

				public int getADD_RACK_DISPOSALS () {
					return this.ADD_RACK_DISPOSALS;
				}
				
			    public int ADD_TRANSFERS_OUT;

				public int getADD_TRANSFERS_OUT () {
					return this.ADD_TRANSFERS_OUT;
				}
				
			    public int ADD_GAIN_LOSS;

				public int getADD_GAIN_LOSS () {
					return this.ADD_GAIN_LOSS;
				}
				
			    public int PIPE_FILL;

				public int getPIPE_FILL () {
					return this.PIPE_FILL;
				}
				
			    public int OPENING_PHYSICAL_GROSS_QTY;

				public int getOPENING_PHYSICAL_GROSS_QTY () {
					return this.OPENING_PHYSICAL_GROSS_QTY;
				}
				
			    public int CLOSING_PHYSICAL_GROSS_QTY;

				public int getCLOSING_PHYSICAL_GROSS_QTY () {
					return this.CLOSING_PHYSICAL_GROSS_QTY;
				}
				
			    public double OPENING_TEMPERATURE;

				public double getOPENING_TEMPERATURE () {
					return this.OPENING_TEMPERATURE;
				}
				
			    public double CLOSING_TEMPERATURE;

				public double getCLOSING_TEMPERATURE () {
					return this.CLOSING_TEMPERATURE;
				}
				
			    public double OPENING_DENSITY;

				public double getOPENING_DENSITY () {
					return this.OPENING_DENSITY;
				}
				
			    public double CLOSING_DENSITY;

				public double getCLOSING_DENSITY () {
					return this.CLOSING_DENSITY;
				}
				
			    public int OPENING_BSW_QTY;

				public int getOPENING_BSW_QTY () {
					return this.OPENING_BSW_QTY;
				}
				
			    public int CLOSING_BSW_QTY;

				public int getCLOSING_BSW_QTY () {
					return this.CLOSING_BSW_QTY;
				}
				
			    public String OPENING_LEVEL;

				public String getOPENING_LEVEL () {
					return this.OPENING_LEVEL;
				}
				
			    public String CLOSING_LEVEL;

				public String getCLOSING_LEVEL () {
					return this.CLOSING_LEVEL;
				}
				
			    public double OPENING_OBSERVED_DENSITY;

				public double getOPENING_OBSERVED_DENSITY () {
					return this.OPENING_OBSERVED_DENSITY;
				}
				
			    public double CLOSING_OBSERVED_DENSITY;

				public double getCLOSING_OBSERVED_DENSITY () {
					return this.CLOSING_OBSERVED_DENSITY;
				}
				
			    public String OPENING_BSW_LEVEL;

				public String getOPENING_BSW_LEVEL () {
					return this.OPENING_BSW_LEVEL;
				}
				
			    public String CLOSING_BSW_LEVEL;

				public String getCLOSING_BSW_LEVEL () {
					return this.CLOSING_BSW_LEVEL;
				}
				
			    public int BULK_FRAC_DISPOSALS;

				public int getBULK_FRAC_DISPOSALS () {
					return this.BULK_FRAC_DISPOSALS;
				}
				
			    public int BULK_FRAC_RECEIPTS;

				public int getBULK_FRAC_RECEIPTS () {
					return this.BULK_FRAC_RECEIPTS;
				}
				
			    public int VIRTUAL_TANK;

				public int getVIRTUAL_TANK () {
					return this.VIRTUAL_TANK;
				}
				
			    public double OPENING_COE;

				public double getOPENING_COE () {
					return this.OPENING_COE;
				}
				
			    public double CLOSING_COE;

				public double getCLOSING_COE () {
					return this.CLOSING_COE;
				}
				
			    public int OPENING_LINE_SEGMENT_NSV;

				public int getOPENING_LINE_SEGMENT_NSV () {
					return this.OPENING_LINE_SEGMENT_NSV;
				}
				
			    public int CLOSING_LINE_SEGMENT_NSV;

				public int getCLOSING_LINE_SEGMENT_NSV () {
					return this.CLOSING_LINE_SEGMENT_NSV;
				}
				
			    public int OPENING_TOV;

				public int getOPENING_TOV () {
					return this.OPENING_TOV;
				}
				
			    public int CLOSING_TOV;

				public int getCLOSING_TOV () {
					return this.CLOSING_TOV;
				}
				
			    public int OPENING_GOV;

				public int getOPENING_GOV () {
					return this.OPENING_GOV;
				}
				
			    public int CLOSING_GOV;

				public int getCLOSING_GOV () {
					return this.CLOSING_GOV;
				}
				
			    public int OPENING_GSV;

				public int getOPENING_GSV () {
					return this.OPENING_GSV;
				}
				
			    public int CLOSING_GSV;

				public int getCLOSING_GSV () {
					return this.CLOSING_GSV;
				}
				
			    public int OPENING_TCV;

				public int getOPENING_TCV () {
					return this.OPENING_TCV;
				}
				
			    public int CLOSING_TCV;

				public int getCLOSING_TCV () {
					return this.CLOSING_TCV;
				}
				
			    public double OPENING_CTL;

				public double getOPENING_CTL () {
					return this.OPENING_CTL;
				}
				
			    public double CLOSING_CTL;

				public double getCLOSING_CTL () {
					return this.CLOSING_CTL;
				}
				
			    public double OPENING_SHELL_CORRECTION_FACTO;

				public double getOPENING_SHELL_CORRECTION_FACTO () {
					return this.OPENING_SHELL_CORRECTION_FACTO;
				}
				
			    public double CLOSING_SHELL_CORRECTION_FACTO;

				public double getCLOSING_SHELL_CORRECTION_FACTO () {
					return this.CLOSING_SHELL_CORRECTION_FACTO;
				}
				
			    public int OPENING_FLOATING_ROOF_ADJUSTME;

				public int getOPENING_FLOATING_ROOF_ADJUSTME () {
					return this.OPENING_FLOATING_ROOF_ADJUSTME;
				}
				
			    public int CLOSING_FLOATING_ROOF_ADJUSTME;

				public int getCLOSING_FLOATING_ROOF_ADJUSTME () {
					return this.CLOSING_FLOATING_ROOF_ADJUSTME;
				}
				
			    public double OPENING_AMBIENT_TEMPERATURE;

				public double getOPENING_AMBIENT_TEMPERATURE () {
					return this.OPENING_AMBIENT_TEMPERATURE;
				}
				
			    public double CLOSING_AMBIENT_TEMPERATURE;

				public double getCLOSING_AMBIENT_TEMPERATURE () {
					return this.CLOSING_AMBIENT_TEMPERATURE;
				}
				
			    public double OPENING_SUSPENDED_BSW_PERCENT;

				public double getOPENING_SUSPENDED_BSW_PERCENT () {
					return this.OPENING_SUSPENDED_BSW_PERCENT;
				}
				
			    public double CLOSING_SUSPENDED_BSW_PERCENT;

				public double getCLOSING_SUSPENDED_BSW_PERCENT () {
					return this.CLOSING_SUSPENDED_BSW_PERCENT;
				}
				
			    public String OPENING_GAUGER_INITIALS;

				public String getOPENING_GAUGER_INITIALS () {
					return this.OPENING_GAUGER_INITIALS;
				}
				
			    public String CLOSING_GAUGER_INITIALS;

				public String getCLOSING_GAUGER_INITIALS () {
					return this.CLOSING_GAUGER_INITIALS;
				}
				
			    public java.util.Date OPENING_GAUGE_TIMESTAMP;

				public java.util.Date getOPENING_GAUGE_TIMESTAMP () {
					return this.OPENING_GAUGE_TIMESTAMP;
				}
				
			    public java.util.Date CLOSING_GAUGE_TIMESTAMP;

				public java.util.Date getCLOSING_GAUGE_TIMESTAMP () {
					return this.CLOSING_GAUGE_TIMESTAMP;
				}
				
			    public int OPENING_PRODUCT_STRAP_TYPE;

				public int getOPENING_PRODUCT_STRAP_TYPE () {
					return this.OPENING_PRODUCT_STRAP_TYPE;
				}
				
			    public int CLOSING_PRODUCT_STRAP_TYPE;

				public int getCLOSING_PRODUCT_STRAP_TYPE () {
					return this.CLOSING_PRODUCT_STRAP_TYPE;
				}
				
			    public int OPENING_BSW_STRAP_TYPE;

				public int getOPENING_BSW_STRAP_TYPE () {
					return this.OPENING_BSW_STRAP_TYPE;
				}
				
			    public int CLOSING_BSW_STRAP_TYPE;

				public int getCLOSING_BSW_STRAP_TYPE () {
					return this.CLOSING_BSW_STRAP_TYPE;
				}
				
			    public int OPENING_GSW;

				public int getOPENING_GSW () {
					return this.OPENING_GSW;
				}
				
			    public int CLOSING_GSW;

				public int getCLOSING_GSW () {
					return this.CLOSING_GSW;
				}
				
			    public int OPENING_NSW;

				public int getOPENING_NSW () {
					return this.OPENING_NSW;
				}
				
			    public int CLOSING_NSW;

				public int getCLOSING_NSW () {
					return this.CLOSING_NSW;
				}
				
			    public double OPENING_WCF;

				public double getOPENING_WCF () {
					return this.OPENING_WCF;
				}
				
			    public double CLOSING_WCF;

				public double getCLOSING_WCF () {
					return this.CLOSING_WCF;
				}
				
			    public int OPENING_LINE_SEGMENT_NSW;

				public int getOPENING_LINE_SEGMENT_NSW () {
					return this.OPENING_LINE_SEGMENT_NSW;
				}
				
			    public int CLOSING_LINE_SEGMENT_NSW;

				public int getCLOSING_LINE_SEGMENT_NSW () {
					return this.CLOSING_LINE_SEGMENT_NSW;
				}
				
			    public int OPENING_NSV;

				public int getOPENING_NSV () {
					return this.OPENING_NSV;
				}
				
			    public int CLOSING_NSV;

				public int getCLOSING_NSV () {
					return this.CLOSING_NSV;
				}
				
			    public int OPENING_XCTN_GROSS_QTY;

				public int getOPENING_XCTN_GROSS_QTY () {
					return this.OPENING_XCTN_GROSS_QTY;
				}
				
			    public int CLOSING_XCTN_GROSS_QTY;

				public int getCLOSING_XCTN_GROSS_QTY () {
					return this.CLOSING_XCTN_GROSS_QTY;
				}
				
			    public int OPENING_XCTN_FRAC_GROSS_QTY;

				public int getOPENING_XCTN_FRAC_GROSS_QTY () {
					return this.OPENING_XCTN_FRAC_GROSS_QTY;
				}
				
			    public int CLOSING_XCTN_FRAC_GROSS_QTY;

				public int getCLOSING_XCTN_FRAC_GROSS_QTY () {
					return this.CLOSING_XCTN_FRAC_GROSS_QTY;
				}
				
			    public int OPENING_XCTN_NET_QTY;

				public int getOPENING_XCTN_NET_QTY () {
					return this.OPENING_XCTN_NET_QTY;
				}
				
			    public int CLOSING_XCTN_NET_QTY;

				public int getCLOSING_XCTN_NET_QTY () {
					return this.CLOSING_XCTN_NET_QTY;
				}
				
			    public int OPENING_XCTN_FRAC_NET_QTY;

				public int getOPENING_XCTN_FRAC_NET_QTY () {
					return this.OPENING_XCTN_FRAC_NET_QTY;
				}
				
			    public int CLOSING_XCTN_FRAC_NET_QTY;

				public int getCLOSING_XCTN_FRAC_NET_QTY () {
					return this.CLOSING_XCTN_FRAC_NET_QTY;
				}
				
			    public int OPENING_CALCULATION_POINT;

				public int getOPENING_CALCULATION_POINT () {
					return this.OPENING_CALCULATION_POINT;
				}
				
			    public int CLOSING_CALCULATION_POINT;

				public int getCLOSING_CALCULATION_POINT () {
					return this.CLOSING_CALCULATION_POINT;
				}
				
			    public int MANUAL_OPENING_PHYSICAL;

				public int getMANUAL_OPENING_PHYSICAL () {
					return this.MANUAL_OPENING_PHYSICAL;
				}
				
			    public String OPENING_API_CODE;

				public String getOPENING_API_CODE () {
					return this.OPENING_API_CODE;
				}
				
			    public String CLOSING_API_CODE;

				public String getCLOSING_API_CODE () {
					return this.CLOSING_API_CODE;
				}
				
			    public int OPENING_WEIGHT_IN_AIR;

				public int getOPENING_WEIGHT_IN_AIR () {
					return this.OPENING_WEIGHT_IN_AIR;
				}
				
			    public int CLOSING_WEIGHT_IN_AIR;

				public int getCLOSING_WEIGHT_IN_AIR () {
					return this.CLOSING_WEIGHT_IN_AIR;
				}
				
			    public int OPENING_XCTN_WEIGHT;

				public int getOPENING_XCTN_WEIGHT () {
					return this.OPENING_XCTN_WEIGHT;
				}
				
			    public int OPENING_XCTN_FRAC_WEIGHT;

				public int getOPENING_XCTN_FRAC_WEIGHT () {
					return this.OPENING_XCTN_FRAC_WEIGHT;
				}
				
			    public int CLOSING_XCTN_WEIGHT;

				public int getCLOSING_XCTN_WEIGHT () {
					return this.CLOSING_XCTN_WEIGHT;
				}
				
			    public int CLOSING_XCTN_FRAC_WEIGHT;

				public int getCLOSING_XCTN_FRAC_WEIGHT () {
					return this.CLOSING_XCTN_FRAC_WEIGHT;
				}
				
			    public int OPENING_VAPOR_CORRECT_METHOD;

				public int getOPENING_VAPOR_CORRECT_METHOD () {
					return this.OPENING_VAPOR_CORRECT_METHOD;
				}
				
			    public int CLOSING_VAPOR_CORRECT_METHOD;

				public int getCLOSING_VAPOR_CORRECT_METHOD () {
					return this.CLOSING_VAPOR_CORRECT_METHOD;
				}
				
			    public double OPENING_VAPOR_TEMPERATURE;

				public double getOPENING_VAPOR_TEMPERATURE () {
					return this.OPENING_VAPOR_TEMPERATURE;
				}
				
			    public double CLOSING_VAPOR_TEMPERATURE;

				public double getCLOSING_VAPOR_TEMPERATURE () {
					return this.CLOSING_VAPOR_TEMPERATURE;
				}
				
			    public double OPENING_VAPOR_LIQUID_VOL_RATIO;

				public double getOPENING_VAPOR_LIQUID_VOL_RATIO () {
					return this.OPENING_VAPOR_LIQUID_VOL_RATIO;
				}
				
			    public double CLOSING_VAPOR_LIQUID_VOL_RATIO;

				public double getCLOSING_VAPOR_LIQUID_VOL_RATIO () {
					return this.CLOSING_VAPOR_LIQUID_VOL_RATIO;
				}
				
			    public int INVENTORY_QUANTITY_TYPE;

				public int getINVENTORY_QUANTITY_TYPE () {
					return this.INVENTORY_QUANTITY_TYPE;
				}
				
			    public double OPENING_PRESSURE;

				public double getOPENING_PRESSURE () {
					return this.OPENING_PRESSURE;
				}
				
			    public double CLOSING_PRESSURE;

				public double getCLOSING_PRESSURE () {
					return this.CLOSING_PRESSURE;
				}
				
			    public int OPENING_XCTN_WEIGHT_IN_VAC;

				public int getOPENING_XCTN_WEIGHT_IN_VAC () {
					return this.OPENING_XCTN_WEIGHT_IN_VAC;
				}
				
			    public int OPENING_XCTN_FRAC_WGT_IN_VAC;

				public int getOPENING_XCTN_FRAC_WGT_IN_VAC () {
					return this.OPENING_XCTN_FRAC_WGT_IN_VAC;
				}
				
			    public int CLOSING_XCTN_WEIGHT_IN_VAC;

				public int getCLOSING_XCTN_WEIGHT_IN_VAC () {
					return this.CLOSING_XCTN_WEIGHT_IN_VAC;
				}
				
			    public int CLOSING_XCTN_FRAC_WGT_IN_VAC;

				public int getCLOSING_XCTN_FRAC_WGT_IN_VAC () {
					return this.CLOSING_XCTN_FRAC_WGT_IN_VAC;
				}
				
			    public Integer MAJORITY_SHAREHOLDER;

				public Integer getMAJORITY_SHAREHOLDER () {
					return this.MAJORITY_SHAREHOLDER;
				}
				
			    public int OPENING_INVENTORY_ENABLE;

				public int getOPENING_INVENTORY_ENABLE () {
					return this.OPENING_INVENTORY_ENABLE;
				}
				
			    public int CLOSING_INVENTORY_ENABLE;

				public int getCLOSING_INVENTORY_ENABLE () {
					return this.CLOSING_INVENTORY_ENABLE;
				}
				
			    public int OPENING_LEVEL_ORIGIN;

				public int getOPENING_LEVEL_ORIGIN () {
					return this.OPENING_LEVEL_ORIGIN;
				}
				
			    public int CLOSING_LEVEL_ORIGIN;

				public int getCLOSING_LEVEL_ORIGIN () {
					return this.CLOSING_LEVEL_ORIGIN;
				}
				
			    public int OPENING_TOV_ORIGIN;

				public int getOPENING_TOV_ORIGIN () {
					return this.OPENING_TOV_ORIGIN;
				}
				
			    public int CLOSING_TOV_ORIGIN;

				public int getCLOSING_TOV_ORIGIN () {
					return this.CLOSING_TOV_ORIGIN;
				}
				
			    public int OPENING_TEMPERATURE_ORIGIN;

				public int getOPENING_TEMPERATURE_ORIGIN () {
					return this.OPENING_TEMPERATURE_ORIGIN;
				}
				
			    public int CLOSING_TEMPERATURE_ORIGIN;

				public int getCLOSING_TEMPERATURE_ORIGIN () {
					return this.CLOSING_TEMPERATURE_ORIGIN;
				}
				
			    public int OPENING_DENSITY_ORIGIN;

				public int getOPENING_DENSITY_ORIGIN () {
					return this.OPENING_DENSITY_ORIGIN;
				}
				
			    public int CLOSING_DENSITY_ORIGIN;

				public int getCLOSING_DENSITY_ORIGIN () {
					return this.CLOSING_DENSITY_ORIGIN;
				}
				
			    public int OPENING_NSV_ORIGIN;

				public int getOPENING_NSV_ORIGIN () {
					return this.OPENING_NSV_ORIGIN;
				}
				
			    public int CLOSING_NSV_ORIGIN;

				public int getCLOSING_NSV_ORIGIN () {
					return this.CLOSING_NSV_ORIGIN;
				}
				
			    public int OPENING_VAPOR_TEMP_ORIGIN;

				public int getOPENING_VAPOR_TEMP_ORIGIN () {
					return this.OPENING_VAPOR_TEMP_ORIGIN;
				}
				
			    public int CLOSING_VAPOR_TEMP_ORIGIN;

				public int getCLOSING_VAPOR_TEMP_ORIGIN () {
					return this.CLOSING_VAPOR_TEMP_ORIGIN;
				}
				
			    public int OPENING_PRESSURE_ORIGIN;

				public int getOPENING_PRESSURE_ORIGIN () {
					return this.OPENING_PRESSURE_ORIGIN;
				}
				
			    public int CLOSING_PRESSURE_ORIGIN;

				public int getCLOSING_PRESSURE_ORIGIN () {
					return this.CLOSING_PRESSURE_ORIGIN;
				}
				
			    public int OPENING_FREE_WATER_LVL_ORIGIN;

				public int getOPENING_FREE_WATER_LVL_ORIGIN () {
					return this.OPENING_FREE_WATER_LVL_ORIGIN;
				}
				
			    public int CLOSING_FREE_WATER_LVL_ORIGIN;

				public int getCLOSING_FREE_WATER_LVL_ORIGIN () {
					return this.CLOSING_FREE_WATER_LVL_ORIGIN;
				}
				
			    public int OPENING_WATER_QTY_ORIGIN;

				public int getOPENING_WATER_QTY_ORIGIN () {
					return this.OPENING_WATER_QTY_ORIGIN;
				}
				
			    public int CLOSING_WATER_QTY_ORIGIN;

				public int getCLOSING_WATER_QTY_ORIGIN () {
					return this.CLOSING_WATER_QTY_ORIGIN;
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
				
			    public int COMPARTMENT_VISIT_NUMBER;

				public int getCOMPARTMENT_VISIT_NUMBER () {
					return this.COMPARTMENT_VISIT_NUMBER;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PGS_STAGE_DIM_GAIN_LOSS_HISTORY.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_GAIN_LOSS_HISTORY.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_GAIN_LOSS_HISTORY = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_GAIN_LOSS_HISTORY = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PGS_STAGE_DIM_GAIN_LOSS_HISTORY, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_GAIN_LOSS_HISTORY, 0, length, utf8Charset);
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
			if(length > commonByteArray_PGS_STAGE_DIM_GAIN_LOSS_HISTORY.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_GAIN_LOSS_HISTORY.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_GAIN_LOSS_HISTORY = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_GAIN_LOSS_HISTORY = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PGS_STAGE_DIM_GAIN_LOSS_HISTORY, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_GAIN_LOSS_HISTORY, 0, length, utf8Charset);
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

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_GAIN_LOSS_HISTORY) {

        	try {

        		int length = 0;
		
			        this.TERMINAL_PRODUCT_NUMBER = dis.readInt();
					
					this.FOLIO_NUMBER = readString(dis);
					
					this.TANK_CODE = readString(dis);
					
			        this.GAIN_LOSS_ID = dis.readInt();
					
					this.TANK_GROUP = readString(dis);
					
					this.PRODUCT_GROUP_CODE = readString(dis);
					
			        this.OPENING_PHYSICAL = dis.readInt();
					
			        this.BULK_RECEIPTS = dis.readInt();
					
			        this.BULK_TRANSFERS_IN = dis.readInt();
					
			        this.BULK_DISPOSALS = dis.readInt();
					
			        this.BULK_TRANSFERS_OUT = dis.readInt();
					
			        this.RACK_RECEIPTS = dis.readInt();
					
			        this.RACK_DISPOSALS = dis.readInt();
					
			        this.CLOSING_PHYSICAL = dis.readInt();
					
			        this.MANUAL_CLOSING_PHYSICAL = dis.readInt();
					
			        this.GAIN_LOSS = dis.readInt();
					
			        this.RACK_FRAC_RECEIPTS = dis.readInt();
					
			        this.RACK_FRAC_DISPOSALS = dis.readInt();
					
			        this.BULK_FRAC_TRANSFERS_IN = dis.readInt();
					
			        this.BULK_FRAC_TRANSFERS_OUT = dis.readInt();
					
			        this.ADD_BULK_RECEIPTS = dis.readInt();
					
			        this.ADD_RACK_RECEIPTS = dis.readInt();
					
			        this.ADD_TRANSFERS_IN = dis.readInt();
					
			        this.ADD_BULK_DISPOSALS = dis.readInt();
					
			        this.ADD_RACK_DISPOSALS = dis.readInt();
					
			        this.ADD_TRANSFERS_OUT = dis.readInt();
					
			        this.ADD_GAIN_LOSS = dis.readInt();
					
			        this.PIPE_FILL = dis.readInt();
					
			        this.OPENING_PHYSICAL_GROSS_QTY = dis.readInt();
					
			        this.CLOSING_PHYSICAL_GROSS_QTY = dis.readInt();
					
			        this.OPENING_TEMPERATURE = dis.readDouble();
					
			        this.CLOSING_TEMPERATURE = dis.readDouble();
					
			        this.OPENING_DENSITY = dis.readDouble();
					
			        this.CLOSING_DENSITY = dis.readDouble();
					
			        this.OPENING_BSW_QTY = dis.readInt();
					
			        this.CLOSING_BSW_QTY = dis.readInt();
					
					this.OPENING_LEVEL = readString(dis);
					
					this.CLOSING_LEVEL = readString(dis);
					
			        this.OPENING_OBSERVED_DENSITY = dis.readDouble();
					
			        this.CLOSING_OBSERVED_DENSITY = dis.readDouble();
					
					this.OPENING_BSW_LEVEL = readString(dis);
					
					this.CLOSING_BSW_LEVEL = readString(dis);
					
			        this.BULK_FRAC_DISPOSALS = dis.readInt();
					
			        this.BULK_FRAC_RECEIPTS = dis.readInt();
					
			        this.VIRTUAL_TANK = dis.readInt();
					
			        this.OPENING_COE = dis.readDouble();
					
			        this.CLOSING_COE = dis.readDouble();
					
			        this.OPENING_LINE_SEGMENT_NSV = dis.readInt();
					
			        this.CLOSING_LINE_SEGMENT_NSV = dis.readInt();
					
			        this.OPENING_TOV = dis.readInt();
					
			        this.CLOSING_TOV = dis.readInt();
					
			        this.OPENING_GOV = dis.readInt();
					
			        this.CLOSING_GOV = dis.readInt();
					
			        this.OPENING_GSV = dis.readInt();
					
			        this.CLOSING_GSV = dis.readInt();
					
			        this.OPENING_TCV = dis.readInt();
					
			        this.CLOSING_TCV = dis.readInt();
					
			        this.OPENING_CTL = dis.readDouble();
					
			        this.CLOSING_CTL = dis.readDouble();
					
			        this.OPENING_SHELL_CORRECTION_FACTO = dis.readDouble();
					
			        this.CLOSING_SHELL_CORRECTION_FACTO = dis.readDouble();
					
			        this.OPENING_FLOATING_ROOF_ADJUSTME = dis.readInt();
					
			        this.CLOSING_FLOATING_ROOF_ADJUSTME = dis.readInt();
					
			        this.OPENING_AMBIENT_TEMPERATURE = dis.readDouble();
					
			        this.CLOSING_AMBIENT_TEMPERATURE = dis.readDouble();
					
			        this.OPENING_SUSPENDED_BSW_PERCENT = dis.readDouble();
					
			        this.CLOSING_SUSPENDED_BSW_PERCENT = dis.readDouble();
					
					this.OPENING_GAUGER_INITIALS = readString(dis);
					
					this.CLOSING_GAUGER_INITIALS = readString(dis);
					
					this.OPENING_GAUGE_TIMESTAMP = readDate(dis);
					
					this.CLOSING_GAUGE_TIMESTAMP = readDate(dis);
					
			        this.OPENING_PRODUCT_STRAP_TYPE = dis.readInt();
					
			        this.CLOSING_PRODUCT_STRAP_TYPE = dis.readInt();
					
			        this.OPENING_BSW_STRAP_TYPE = dis.readInt();
					
			        this.CLOSING_BSW_STRAP_TYPE = dis.readInt();
					
			        this.OPENING_GSW = dis.readInt();
					
			        this.CLOSING_GSW = dis.readInt();
					
			        this.OPENING_NSW = dis.readInt();
					
			        this.CLOSING_NSW = dis.readInt();
					
			        this.OPENING_WCF = dis.readDouble();
					
			        this.CLOSING_WCF = dis.readDouble();
					
			        this.OPENING_LINE_SEGMENT_NSW = dis.readInt();
					
			        this.CLOSING_LINE_SEGMENT_NSW = dis.readInt();
					
			        this.OPENING_NSV = dis.readInt();
					
			        this.CLOSING_NSV = dis.readInt();
					
			        this.OPENING_XCTN_GROSS_QTY = dis.readInt();
					
			        this.CLOSING_XCTN_GROSS_QTY = dis.readInt();
					
			        this.OPENING_XCTN_FRAC_GROSS_QTY = dis.readInt();
					
			        this.CLOSING_XCTN_FRAC_GROSS_QTY = dis.readInt();
					
			        this.OPENING_XCTN_NET_QTY = dis.readInt();
					
			        this.CLOSING_XCTN_NET_QTY = dis.readInt();
					
			        this.OPENING_XCTN_FRAC_NET_QTY = dis.readInt();
					
			        this.CLOSING_XCTN_FRAC_NET_QTY = dis.readInt();
					
			        this.OPENING_CALCULATION_POINT = dis.readInt();
					
			        this.CLOSING_CALCULATION_POINT = dis.readInt();
					
			        this.MANUAL_OPENING_PHYSICAL = dis.readInt();
					
					this.OPENING_API_CODE = readString(dis);
					
					this.CLOSING_API_CODE = readString(dis);
					
			        this.OPENING_WEIGHT_IN_AIR = dis.readInt();
					
			        this.CLOSING_WEIGHT_IN_AIR = dis.readInt();
					
			        this.OPENING_XCTN_WEIGHT = dis.readInt();
					
			        this.OPENING_XCTN_FRAC_WEIGHT = dis.readInt();
					
			        this.CLOSING_XCTN_WEIGHT = dis.readInt();
					
			        this.CLOSING_XCTN_FRAC_WEIGHT = dis.readInt();
					
			        this.OPENING_VAPOR_CORRECT_METHOD = dis.readInt();
					
			        this.CLOSING_VAPOR_CORRECT_METHOD = dis.readInt();
					
			        this.OPENING_VAPOR_TEMPERATURE = dis.readDouble();
					
			        this.CLOSING_VAPOR_TEMPERATURE = dis.readDouble();
					
			        this.OPENING_VAPOR_LIQUID_VOL_RATIO = dis.readDouble();
					
			        this.CLOSING_VAPOR_LIQUID_VOL_RATIO = dis.readDouble();
					
			        this.INVENTORY_QUANTITY_TYPE = dis.readInt();
					
			        this.OPENING_PRESSURE = dis.readDouble();
					
			        this.CLOSING_PRESSURE = dis.readDouble();
					
			        this.OPENING_XCTN_WEIGHT_IN_VAC = dis.readInt();
					
			        this.OPENING_XCTN_FRAC_WGT_IN_VAC = dis.readInt();
					
			        this.CLOSING_XCTN_WEIGHT_IN_VAC = dis.readInt();
					
			        this.CLOSING_XCTN_FRAC_WGT_IN_VAC = dis.readInt();
					
						this.MAJORITY_SHAREHOLDER = readInteger(dis);
					
			        this.OPENING_INVENTORY_ENABLE = dis.readInt();
					
			        this.CLOSING_INVENTORY_ENABLE = dis.readInt();
					
			        this.OPENING_LEVEL_ORIGIN = dis.readInt();
					
			        this.CLOSING_LEVEL_ORIGIN = dis.readInt();
					
			        this.OPENING_TOV_ORIGIN = dis.readInt();
					
			        this.CLOSING_TOV_ORIGIN = dis.readInt();
					
			        this.OPENING_TEMPERATURE_ORIGIN = dis.readInt();
					
			        this.CLOSING_TEMPERATURE_ORIGIN = dis.readInt();
					
			        this.OPENING_DENSITY_ORIGIN = dis.readInt();
					
			        this.CLOSING_DENSITY_ORIGIN = dis.readInt();
					
			        this.OPENING_NSV_ORIGIN = dis.readInt();
					
			        this.CLOSING_NSV_ORIGIN = dis.readInt();
					
			        this.OPENING_VAPOR_TEMP_ORIGIN = dis.readInt();
					
			        this.CLOSING_VAPOR_TEMP_ORIGIN = dis.readInt();
					
			        this.OPENING_PRESSURE_ORIGIN = dis.readInt();
					
			        this.CLOSING_PRESSURE_ORIGIN = dis.readInt();
					
			        this.OPENING_FREE_WATER_LVL_ORIGIN = dis.readInt();
					
			        this.CLOSING_FREE_WATER_LVL_ORIGIN = dis.readInt();
					
			        this.OPENING_WATER_QTY_ORIGIN = dis.readInt();
					
			        this.CLOSING_WATER_QTY_ORIGIN = dis.readInt();
					
						this.COMPARTMENT_OWNER_ID = readInteger(dis);
					
					this.COMPARTMENT_CONTAINER_CODE = readString(dis);
					
						this.COMPARTMENT_CONTAINER_TYPE = readInteger(dis);
					
						this.COMPARTMENT_NUMBER = readInteger(dis);
					
			        this.COMPARTMENT_VISIT_NUMBER = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_GAIN_LOSS_HISTORY) {

        	try {

        		int length = 0;
		
			        this.TERMINAL_PRODUCT_NUMBER = dis.readInt();
					
					this.FOLIO_NUMBER = readString(dis);
					
					this.TANK_CODE = readString(dis);
					
			        this.GAIN_LOSS_ID = dis.readInt();
					
					this.TANK_GROUP = readString(dis);
					
					this.PRODUCT_GROUP_CODE = readString(dis);
					
			        this.OPENING_PHYSICAL = dis.readInt();
					
			        this.BULK_RECEIPTS = dis.readInt();
					
			        this.BULK_TRANSFERS_IN = dis.readInt();
					
			        this.BULK_DISPOSALS = dis.readInt();
					
			        this.BULK_TRANSFERS_OUT = dis.readInt();
					
			        this.RACK_RECEIPTS = dis.readInt();
					
			        this.RACK_DISPOSALS = dis.readInt();
					
			        this.CLOSING_PHYSICAL = dis.readInt();
					
			        this.MANUAL_CLOSING_PHYSICAL = dis.readInt();
					
			        this.GAIN_LOSS = dis.readInt();
					
			        this.RACK_FRAC_RECEIPTS = dis.readInt();
					
			        this.RACK_FRAC_DISPOSALS = dis.readInt();
					
			        this.BULK_FRAC_TRANSFERS_IN = dis.readInt();
					
			        this.BULK_FRAC_TRANSFERS_OUT = dis.readInt();
					
			        this.ADD_BULK_RECEIPTS = dis.readInt();
					
			        this.ADD_RACK_RECEIPTS = dis.readInt();
					
			        this.ADD_TRANSFERS_IN = dis.readInt();
					
			        this.ADD_BULK_DISPOSALS = dis.readInt();
					
			        this.ADD_RACK_DISPOSALS = dis.readInt();
					
			        this.ADD_TRANSFERS_OUT = dis.readInt();
					
			        this.ADD_GAIN_LOSS = dis.readInt();
					
			        this.PIPE_FILL = dis.readInt();
					
			        this.OPENING_PHYSICAL_GROSS_QTY = dis.readInt();
					
			        this.CLOSING_PHYSICAL_GROSS_QTY = dis.readInt();
					
			        this.OPENING_TEMPERATURE = dis.readDouble();
					
			        this.CLOSING_TEMPERATURE = dis.readDouble();
					
			        this.OPENING_DENSITY = dis.readDouble();
					
			        this.CLOSING_DENSITY = dis.readDouble();
					
			        this.OPENING_BSW_QTY = dis.readInt();
					
			        this.CLOSING_BSW_QTY = dis.readInt();
					
					this.OPENING_LEVEL = readString(dis);
					
					this.CLOSING_LEVEL = readString(dis);
					
			        this.OPENING_OBSERVED_DENSITY = dis.readDouble();
					
			        this.CLOSING_OBSERVED_DENSITY = dis.readDouble();
					
					this.OPENING_BSW_LEVEL = readString(dis);
					
					this.CLOSING_BSW_LEVEL = readString(dis);
					
			        this.BULK_FRAC_DISPOSALS = dis.readInt();
					
			        this.BULK_FRAC_RECEIPTS = dis.readInt();
					
			        this.VIRTUAL_TANK = dis.readInt();
					
			        this.OPENING_COE = dis.readDouble();
					
			        this.CLOSING_COE = dis.readDouble();
					
			        this.OPENING_LINE_SEGMENT_NSV = dis.readInt();
					
			        this.CLOSING_LINE_SEGMENT_NSV = dis.readInt();
					
			        this.OPENING_TOV = dis.readInt();
					
			        this.CLOSING_TOV = dis.readInt();
					
			        this.OPENING_GOV = dis.readInt();
					
			        this.CLOSING_GOV = dis.readInt();
					
			        this.OPENING_GSV = dis.readInt();
					
			        this.CLOSING_GSV = dis.readInt();
					
			        this.OPENING_TCV = dis.readInt();
					
			        this.CLOSING_TCV = dis.readInt();
					
			        this.OPENING_CTL = dis.readDouble();
					
			        this.CLOSING_CTL = dis.readDouble();
					
			        this.OPENING_SHELL_CORRECTION_FACTO = dis.readDouble();
					
			        this.CLOSING_SHELL_CORRECTION_FACTO = dis.readDouble();
					
			        this.OPENING_FLOATING_ROOF_ADJUSTME = dis.readInt();
					
			        this.CLOSING_FLOATING_ROOF_ADJUSTME = dis.readInt();
					
			        this.OPENING_AMBIENT_TEMPERATURE = dis.readDouble();
					
			        this.CLOSING_AMBIENT_TEMPERATURE = dis.readDouble();
					
			        this.OPENING_SUSPENDED_BSW_PERCENT = dis.readDouble();
					
			        this.CLOSING_SUSPENDED_BSW_PERCENT = dis.readDouble();
					
					this.OPENING_GAUGER_INITIALS = readString(dis);
					
					this.CLOSING_GAUGER_INITIALS = readString(dis);
					
					this.OPENING_GAUGE_TIMESTAMP = readDate(dis);
					
					this.CLOSING_GAUGE_TIMESTAMP = readDate(dis);
					
			        this.OPENING_PRODUCT_STRAP_TYPE = dis.readInt();
					
			        this.CLOSING_PRODUCT_STRAP_TYPE = dis.readInt();
					
			        this.OPENING_BSW_STRAP_TYPE = dis.readInt();
					
			        this.CLOSING_BSW_STRAP_TYPE = dis.readInt();
					
			        this.OPENING_GSW = dis.readInt();
					
			        this.CLOSING_GSW = dis.readInt();
					
			        this.OPENING_NSW = dis.readInt();
					
			        this.CLOSING_NSW = dis.readInt();
					
			        this.OPENING_WCF = dis.readDouble();
					
			        this.CLOSING_WCF = dis.readDouble();
					
			        this.OPENING_LINE_SEGMENT_NSW = dis.readInt();
					
			        this.CLOSING_LINE_SEGMENT_NSW = dis.readInt();
					
			        this.OPENING_NSV = dis.readInt();
					
			        this.CLOSING_NSV = dis.readInt();
					
			        this.OPENING_XCTN_GROSS_QTY = dis.readInt();
					
			        this.CLOSING_XCTN_GROSS_QTY = dis.readInt();
					
			        this.OPENING_XCTN_FRAC_GROSS_QTY = dis.readInt();
					
			        this.CLOSING_XCTN_FRAC_GROSS_QTY = dis.readInt();
					
			        this.OPENING_XCTN_NET_QTY = dis.readInt();
					
			        this.CLOSING_XCTN_NET_QTY = dis.readInt();
					
			        this.OPENING_XCTN_FRAC_NET_QTY = dis.readInt();
					
			        this.CLOSING_XCTN_FRAC_NET_QTY = dis.readInt();
					
			        this.OPENING_CALCULATION_POINT = dis.readInt();
					
			        this.CLOSING_CALCULATION_POINT = dis.readInt();
					
			        this.MANUAL_OPENING_PHYSICAL = dis.readInt();
					
					this.OPENING_API_CODE = readString(dis);
					
					this.CLOSING_API_CODE = readString(dis);
					
			        this.OPENING_WEIGHT_IN_AIR = dis.readInt();
					
			        this.CLOSING_WEIGHT_IN_AIR = dis.readInt();
					
			        this.OPENING_XCTN_WEIGHT = dis.readInt();
					
			        this.OPENING_XCTN_FRAC_WEIGHT = dis.readInt();
					
			        this.CLOSING_XCTN_WEIGHT = dis.readInt();
					
			        this.CLOSING_XCTN_FRAC_WEIGHT = dis.readInt();
					
			        this.OPENING_VAPOR_CORRECT_METHOD = dis.readInt();
					
			        this.CLOSING_VAPOR_CORRECT_METHOD = dis.readInt();
					
			        this.OPENING_VAPOR_TEMPERATURE = dis.readDouble();
					
			        this.CLOSING_VAPOR_TEMPERATURE = dis.readDouble();
					
			        this.OPENING_VAPOR_LIQUID_VOL_RATIO = dis.readDouble();
					
			        this.CLOSING_VAPOR_LIQUID_VOL_RATIO = dis.readDouble();
					
			        this.INVENTORY_QUANTITY_TYPE = dis.readInt();
					
			        this.OPENING_PRESSURE = dis.readDouble();
					
			        this.CLOSING_PRESSURE = dis.readDouble();
					
			        this.OPENING_XCTN_WEIGHT_IN_VAC = dis.readInt();
					
			        this.OPENING_XCTN_FRAC_WGT_IN_VAC = dis.readInt();
					
			        this.CLOSING_XCTN_WEIGHT_IN_VAC = dis.readInt();
					
			        this.CLOSING_XCTN_FRAC_WGT_IN_VAC = dis.readInt();
					
						this.MAJORITY_SHAREHOLDER = readInteger(dis);
					
			        this.OPENING_INVENTORY_ENABLE = dis.readInt();
					
			        this.CLOSING_INVENTORY_ENABLE = dis.readInt();
					
			        this.OPENING_LEVEL_ORIGIN = dis.readInt();
					
			        this.CLOSING_LEVEL_ORIGIN = dis.readInt();
					
			        this.OPENING_TOV_ORIGIN = dis.readInt();
					
			        this.CLOSING_TOV_ORIGIN = dis.readInt();
					
			        this.OPENING_TEMPERATURE_ORIGIN = dis.readInt();
					
			        this.CLOSING_TEMPERATURE_ORIGIN = dis.readInt();
					
			        this.OPENING_DENSITY_ORIGIN = dis.readInt();
					
			        this.CLOSING_DENSITY_ORIGIN = dis.readInt();
					
			        this.OPENING_NSV_ORIGIN = dis.readInt();
					
			        this.CLOSING_NSV_ORIGIN = dis.readInt();
					
			        this.OPENING_VAPOR_TEMP_ORIGIN = dis.readInt();
					
			        this.CLOSING_VAPOR_TEMP_ORIGIN = dis.readInt();
					
			        this.OPENING_PRESSURE_ORIGIN = dis.readInt();
					
			        this.CLOSING_PRESSURE_ORIGIN = dis.readInt();
					
			        this.OPENING_FREE_WATER_LVL_ORIGIN = dis.readInt();
					
			        this.CLOSING_FREE_WATER_LVL_ORIGIN = dis.readInt();
					
			        this.OPENING_WATER_QTY_ORIGIN = dis.readInt();
					
			        this.CLOSING_WATER_QTY_ORIGIN = dis.readInt();
					
						this.COMPARTMENT_OWNER_ID = readInteger(dis);
					
					this.COMPARTMENT_CONTAINER_CODE = readString(dis);
					
						this.COMPARTMENT_CONTAINER_TYPE = readInteger(dis);
					
						this.COMPARTMENT_NUMBER = readInteger(dis);
					
			        this.COMPARTMENT_VISIT_NUMBER = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.TERMINAL_PRODUCT_NUMBER);
					
					// String
				
						writeString(this.FOLIO_NUMBER,dos);
					
					// String
				
						writeString(this.TANK_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.GAIN_LOSS_ID);
					
					// String
				
						writeString(this.TANK_GROUP,dos);
					
					// String
				
						writeString(this.PRODUCT_GROUP_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.OPENING_PHYSICAL);
					
					// int
				
		            	dos.writeInt(this.BULK_RECEIPTS);
					
					// int
				
		            	dos.writeInt(this.BULK_TRANSFERS_IN);
					
					// int
				
		            	dos.writeInt(this.BULK_DISPOSALS);
					
					// int
				
		            	dos.writeInt(this.BULK_TRANSFERS_OUT);
					
					// int
				
		            	dos.writeInt(this.RACK_RECEIPTS);
					
					// int
				
		            	dos.writeInt(this.RACK_DISPOSALS);
					
					// int
				
		            	dos.writeInt(this.CLOSING_PHYSICAL);
					
					// int
				
		            	dos.writeInt(this.MANUAL_CLOSING_PHYSICAL);
					
					// int
				
		            	dos.writeInt(this.GAIN_LOSS);
					
					// int
				
		            	dos.writeInt(this.RACK_FRAC_RECEIPTS);
					
					// int
				
		            	dos.writeInt(this.RACK_FRAC_DISPOSALS);
					
					// int
				
		            	dos.writeInt(this.BULK_FRAC_TRANSFERS_IN);
					
					// int
				
		            	dos.writeInt(this.BULK_FRAC_TRANSFERS_OUT);
					
					// int
				
		            	dos.writeInt(this.ADD_BULK_RECEIPTS);
					
					// int
				
		            	dos.writeInt(this.ADD_RACK_RECEIPTS);
					
					// int
				
		            	dos.writeInt(this.ADD_TRANSFERS_IN);
					
					// int
				
		            	dos.writeInt(this.ADD_BULK_DISPOSALS);
					
					// int
				
		            	dos.writeInt(this.ADD_RACK_DISPOSALS);
					
					// int
				
		            	dos.writeInt(this.ADD_TRANSFERS_OUT);
					
					// int
				
		            	dos.writeInt(this.ADD_GAIN_LOSS);
					
					// int
				
		            	dos.writeInt(this.PIPE_FILL);
					
					// int
				
		            	dos.writeInt(this.OPENING_PHYSICAL_GROSS_QTY);
					
					// int
				
		            	dos.writeInt(this.CLOSING_PHYSICAL_GROSS_QTY);
					
					// double
				
		            	dos.writeDouble(this.OPENING_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.OPENING_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_DENSITY);
					
					// int
				
		            	dos.writeInt(this.OPENING_BSW_QTY);
					
					// int
				
		            	dos.writeInt(this.CLOSING_BSW_QTY);
					
					// String
				
						writeString(this.OPENING_LEVEL,dos);
					
					// String
				
						writeString(this.CLOSING_LEVEL,dos);
					
					// double
				
		            	dos.writeDouble(this.OPENING_OBSERVED_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_OBSERVED_DENSITY);
					
					// String
				
						writeString(this.OPENING_BSW_LEVEL,dos);
					
					// String
				
						writeString(this.CLOSING_BSW_LEVEL,dos);
					
					// int
				
		            	dos.writeInt(this.BULK_FRAC_DISPOSALS);
					
					// int
				
		            	dos.writeInt(this.BULK_FRAC_RECEIPTS);
					
					// int
				
		            	dos.writeInt(this.VIRTUAL_TANK);
					
					// double
				
		            	dos.writeDouble(this.OPENING_COE);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_COE);
					
					// int
				
		            	dos.writeInt(this.OPENING_LINE_SEGMENT_NSV);
					
					// int
				
		            	dos.writeInt(this.CLOSING_LINE_SEGMENT_NSV);
					
					// int
				
		            	dos.writeInt(this.OPENING_TOV);
					
					// int
				
		            	dos.writeInt(this.CLOSING_TOV);
					
					// int
				
		            	dos.writeInt(this.OPENING_GOV);
					
					// int
				
		            	dos.writeInt(this.CLOSING_GOV);
					
					// int
				
		            	dos.writeInt(this.OPENING_GSV);
					
					// int
				
		            	dos.writeInt(this.CLOSING_GSV);
					
					// int
				
		            	dos.writeInt(this.OPENING_TCV);
					
					// int
				
		            	dos.writeInt(this.CLOSING_TCV);
					
					// double
				
		            	dos.writeDouble(this.OPENING_CTL);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_CTL);
					
					// double
				
		            	dos.writeDouble(this.OPENING_SHELL_CORRECTION_FACTO);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_SHELL_CORRECTION_FACTO);
					
					// int
				
		            	dos.writeInt(this.OPENING_FLOATING_ROOF_ADJUSTME);
					
					// int
				
		            	dos.writeInt(this.CLOSING_FLOATING_ROOF_ADJUSTME);
					
					// double
				
		            	dos.writeDouble(this.OPENING_AMBIENT_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_AMBIENT_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.OPENING_SUSPENDED_BSW_PERCENT);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_SUSPENDED_BSW_PERCENT);
					
					// String
				
						writeString(this.OPENING_GAUGER_INITIALS,dos);
					
					// String
				
						writeString(this.CLOSING_GAUGER_INITIALS,dos);
					
					// java.util.Date
				
						writeDate(this.OPENING_GAUGE_TIMESTAMP,dos);
					
					// java.util.Date
				
						writeDate(this.CLOSING_GAUGE_TIMESTAMP,dos);
					
					// int
				
		            	dos.writeInt(this.OPENING_PRODUCT_STRAP_TYPE);
					
					// int
				
		            	dos.writeInt(this.CLOSING_PRODUCT_STRAP_TYPE);
					
					// int
				
		            	dos.writeInt(this.OPENING_BSW_STRAP_TYPE);
					
					// int
				
		            	dos.writeInt(this.CLOSING_BSW_STRAP_TYPE);
					
					// int
				
		            	dos.writeInt(this.OPENING_GSW);
					
					// int
				
		            	dos.writeInt(this.CLOSING_GSW);
					
					// int
				
		            	dos.writeInt(this.OPENING_NSW);
					
					// int
				
		            	dos.writeInt(this.CLOSING_NSW);
					
					// double
				
		            	dos.writeDouble(this.OPENING_WCF);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_WCF);
					
					// int
				
		            	dos.writeInt(this.OPENING_LINE_SEGMENT_NSW);
					
					// int
				
		            	dos.writeInt(this.CLOSING_LINE_SEGMENT_NSW);
					
					// int
				
		            	dos.writeInt(this.OPENING_NSV);
					
					// int
				
		            	dos.writeInt(this.CLOSING_NSV);
					
					// int
				
		            	dos.writeInt(this.OPENING_XCTN_GROSS_QTY);
					
					// int
				
		            	dos.writeInt(this.CLOSING_XCTN_GROSS_QTY);
					
					// int
				
		            	dos.writeInt(this.OPENING_XCTN_FRAC_GROSS_QTY);
					
					// int
				
		            	dos.writeInt(this.CLOSING_XCTN_FRAC_GROSS_QTY);
					
					// int
				
		            	dos.writeInt(this.OPENING_XCTN_NET_QTY);
					
					// int
				
		            	dos.writeInt(this.CLOSING_XCTN_NET_QTY);
					
					// int
				
		            	dos.writeInt(this.OPENING_XCTN_FRAC_NET_QTY);
					
					// int
				
		            	dos.writeInt(this.CLOSING_XCTN_FRAC_NET_QTY);
					
					// int
				
		            	dos.writeInt(this.OPENING_CALCULATION_POINT);
					
					// int
				
		            	dos.writeInt(this.CLOSING_CALCULATION_POINT);
					
					// int
				
		            	dos.writeInt(this.MANUAL_OPENING_PHYSICAL);
					
					// String
				
						writeString(this.OPENING_API_CODE,dos);
					
					// String
				
						writeString(this.CLOSING_API_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.OPENING_WEIGHT_IN_AIR);
					
					// int
				
		            	dos.writeInt(this.CLOSING_WEIGHT_IN_AIR);
					
					// int
				
		            	dos.writeInt(this.OPENING_XCTN_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.OPENING_XCTN_FRAC_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.CLOSING_XCTN_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.CLOSING_XCTN_FRAC_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.OPENING_VAPOR_CORRECT_METHOD);
					
					// int
				
		            	dos.writeInt(this.CLOSING_VAPOR_CORRECT_METHOD);
					
					// double
				
		            	dos.writeDouble(this.OPENING_VAPOR_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_VAPOR_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.OPENING_VAPOR_LIQUID_VOL_RATIO);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_VAPOR_LIQUID_VOL_RATIO);
					
					// int
				
		            	dos.writeInt(this.INVENTORY_QUANTITY_TYPE);
					
					// double
				
		            	dos.writeDouble(this.OPENING_PRESSURE);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_PRESSURE);
					
					// int
				
		            	dos.writeInt(this.OPENING_XCTN_WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.OPENING_XCTN_FRAC_WGT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.CLOSING_XCTN_WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.CLOSING_XCTN_FRAC_WGT_IN_VAC);
					
					// Integer
				
						writeInteger(this.MAJORITY_SHAREHOLDER,dos);
					
					// int
				
		            	dos.writeInt(this.OPENING_INVENTORY_ENABLE);
					
					// int
				
		            	dos.writeInt(this.CLOSING_INVENTORY_ENABLE);
					
					// int
				
		            	dos.writeInt(this.OPENING_LEVEL_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.CLOSING_LEVEL_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.OPENING_TOV_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.CLOSING_TOV_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.OPENING_TEMPERATURE_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.CLOSING_TEMPERATURE_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.OPENING_DENSITY_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.CLOSING_DENSITY_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.OPENING_NSV_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.CLOSING_NSV_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.OPENING_VAPOR_TEMP_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.CLOSING_VAPOR_TEMP_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.OPENING_PRESSURE_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.CLOSING_PRESSURE_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.OPENING_FREE_WATER_LVL_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.CLOSING_FREE_WATER_LVL_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.OPENING_WATER_QTY_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.CLOSING_WATER_QTY_ORIGIN);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_OWNER_ID,dos);
					
					// String
				
						writeString(this.COMPARTMENT_CONTAINER_CODE,dos);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_CONTAINER_TYPE,dos);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.COMPARTMENT_VISIT_NUMBER);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.TERMINAL_PRODUCT_NUMBER);
					
					// String
				
						writeString(this.FOLIO_NUMBER,dos);
					
					// String
				
						writeString(this.TANK_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.GAIN_LOSS_ID);
					
					// String
				
						writeString(this.TANK_GROUP,dos);
					
					// String
				
						writeString(this.PRODUCT_GROUP_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.OPENING_PHYSICAL);
					
					// int
				
		            	dos.writeInt(this.BULK_RECEIPTS);
					
					// int
				
		            	dos.writeInt(this.BULK_TRANSFERS_IN);
					
					// int
				
		            	dos.writeInt(this.BULK_DISPOSALS);
					
					// int
				
		            	dos.writeInt(this.BULK_TRANSFERS_OUT);
					
					// int
				
		            	dos.writeInt(this.RACK_RECEIPTS);
					
					// int
				
		            	dos.writeInt(this.RACK_DISPOSALS);
					
					// int
				
		            	dos.writeInt(this.CLOSING_PHYSICAL);
					
					// int
				
		            	dos.writeInt(this.MANUAL_CLOSING_PHYSICAL);
					
					// int
				
		            	dos.writeInt(this.GAIN_LOSS);
					
					// int
				
		            	dos.writeInt(this.RACK_FRAC_RECEIPTS);
					
					// int
				
		            	dos.writeInt(this.RACK_FRAC_DISPOSALS);
					
					// int
				
		            	dos.writeInt(this.BULK_FRAC_TRANSFERS_IN);
					
					// int
				
		            	dos.writeInt(this.BULK_FRAC_TRANSFERS_OUT);
					
					// int
				
		            	dos.writeInt(this.ADD_BULK_RECEIPTS);
					
					// int
				
		            	dos.writeInt(this.ADD_RACK_RECEIPTS);
					
					// int
				
		            	dos.writeInt(this.ADD_TRANSFERS_IN);
					
					// int
				
		            	dos.writeInt(this.ADD_BULK_DISPOSALS);
					
					// int
				
		            	dos.writeInt(this.ADD_RACK_DISPOSALS);
					
					// int
				
		            	dos.writeInt(this.ADD_TRANSFERS_OUT);
					
					// int
				
		            	dos.writeInt(this.ADD_GAIN_LOSS);
					
					// int
				
		            	dos.writeInt(this.PIPE_FILL);
					
					// int
				
		            	dos.writeInt(this.OPENING_PHYSICAL_GROSS_QTY);
					
					// int
				
		            	dos.writeInt(this.CLOSING_PHYSICAL_GROSS_QTY);
					
					// double
				
		            	dos.writeDouble(this.OPENING_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.OPENING_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_DENSITY);
					
					// int
				
		            	dos.writeInt(this.OPENING_BSW_QTY);
					
					// int
				
		            	dos.writeInt(this.CLOSING_BSW_QTY);
					
					// String
				
						writeString(this.OPENING_LEVEL,dos);
					
					// String
				
						writeString(this.CLOSING_LEVEL,dos);
					
					// double
				
		            	dos.writeDouble(this.OPENING_OBSERVED_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_OBSERVED_DENSITY);
					
					// String
				
						writeString(this.OPENING_BSW_LEVEL,dos);
					
					// String
				
						writeString(this.CLOSING_BSW_LEVEL,dos);
					
					// int
				
		            	dos.writeInt(this.BULK_FRAC_DISPOSALS);
					
					// int
				
		            	dos.writeInt(this.BULK_FRAC_RECEIPTS);
					
					// int
				
		            	dos.writeInt(this.VIRTUAL_TANK);
					
					// double
				
		            	dos.writeDouble(this.OPENING_COE);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_COE);
					
					// int
				
		            	dos.writeInt(this.OPENING_LINE_SEGMENT_NSV);
					
					// int
				
		            	dos.writeInt(this.CLOSING_LINE_SEGMENT_NSV);
					
					// int
				
		            	dos.writeInt(this.OPENING_TOV);
					
					// int
				
		            	dos.writeInt(this.CLOSING_TOV);
					
					// int
				
		            	dos.writeInt(this.OPENING_GOV);
					
					// int
				
		            	dos.writeInt(this.CLOSING_GOV);
					
					// int
				
		            	dos.writeInt(this.OPENING_GSV);
					
					// int
				
		            	dos.writeInt(this.CLOSING_GSV);
					
					// int
				
		            	dos.writeInt(this.OPENING_TCV);
					
					// int
				
		            	dos.writeInt(this.CLOSING_TCV);
					
					// double
				
		            	dos.writeDouble(this.OPENING_CTL);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_CTL);
					
					// double
				
		            	dos.writeDouble(this.OPENING_SHELL_CORRECTION_FACTO);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_SHELL_CORRECTION_FACTO);
					
					// int
				
		            	dos.writeInt(this.OPENING_FLOATING_ROOF_ADJUSTME);
					
					// int
				
		            	dos.writeInt(this.CLOSING_FLOATING_ROOF_ADJUSTME);
					
					// double
				
		            	dos.writeDouble(this.OPENING_AMBIENT_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_AMBIENT_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.OPENING_SUSPENDED_BSW_PERCENT);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_SUSPENDED_BSW_PERCENT);
					
					// String
				
						writeString(this.OPENING_GAUGER_INITIALS,dos);
					
					// String
				
						writeString(this.CLOSING_GAUGER_INITIALS,dos);
					
					// java.util.Date
				
						writeDate(this.OPENING_GAUGE_TIMESTAMP,dos);
					
					// java.util.Date
				
						writeDate(this.CLOSING_GAUGE_TIMESTAMP,dos);
					
					// int
				
		            	dos.writeInt(this.OPENING_PRODUCT_STRAP_TYPE);
					
					// int
				
		            	dos.writeInt(this.CLOSING_PRODUCT_STRAP_TYPE);
					
					// int
				
		            	dos.writeInt(this.OPENING_BSW_STRAP_TYPE);
					
					// int
				
		            	dos.writeInt(this.CLOSING_BSW_STRAP_TYPE);
					
					// int
				
		            	dos.writeInt(this.OPENING_GSW);
					
					// int
				
		            	dos.writeInt(this.CLOSING_GSW);
					
					// int
				
		            	dos.writeInt(this.OPENING_NSW);
					
					// int
				
		            	dos.writeInt(this.CLOSING_NSW);
					
					// double
				
		            	dos.writeDouble(this.OPENING_WCF);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_WCF);
					
					// int
				
		            	dos.writeInt(this.OPENING_LINE_SEGMENT_NSW);
					
					// int
				
		            	dos.writeInt(this.CLOSING_LINE_SEGMENT_NSW);
					
					// int
				
		            	dos.writeInt(this.OPENING_NSV);
					
					// int
				
		            	dos.writeInt(this.CLOSING_NSV);
					
					// int
				
		            	dos.writeInt(this.OPENING_XCTN_GROSS_QTY);
					
					// int
				
		            	dos.writeInt(this.CLOSING_XCTN_GROSS_QTY);
					
					// int
				
		            	dos.writeInt(this.OPENING_XCTN_FRAC_GROSS_QTY);
					
					// int
				
		            	dos.writeInt(this.CLOSING_XCTN_FRAC_GROSS_QTY);
					
					// int
				
		            	dos.writeInt(this.OPENING_XCTN_NET_QTY);
					
					// int
				
		            	dos.writeInt(this.CLOSING_XCTN_NET_QTY);
					
					// int
				
		            	dos.writeInt(this.OPENING_XCTN_FRAC_NET_QTY);
					
					// int
				
		            	dos.writeInt(this.CLOSING_XCTN_FRAC_NET_QTY);
					
					// int
				
		            	dos.writeInt(this.OPENING_CALCULATION_POINT);
					
					// int
				
		            	dos.writeInt(this.CLOSING_CALCULATION_POINT);
					
					// int
				
		            	dos.writeInt(this.MANUAL_OPENING_PHYSICAL);
					
					// String
				
						writeString(this.OPENING_API_CODE,dos);
					
					// String
				
						writeString(this.CLOSING_API_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.OPENING_WEIGHT_IN_AIR);
					
					// int
				
		            	dos.writeInt(this.CLOSING_WEIGHT_IN_AIR);
					
					// int
				
		            	dos.writeInt(this.OPENING_XCTN_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.OPENING_XCTN_FRAC_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.CLOSING_XCTN_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.CLOSING_XCTN_FRAC_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.OPENING_VAPOR_CORRECT_METHOD);
					
					// int
				
		            	dos.writeInt(this.CLOSING_VAPOR_CORRECT_METHOD);
					
					// double
				
		            	dos.writeDouble(this.OPENING_VAPOR_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_VAPOR_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.OPENING_VAPOR_LIQUID_VOL_RATIO);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_VAPOR_LIQUID_VOL_RATIO);
					
					// int
				
		            	dos.writeInt(this.INVENTORY_QUANTITY_TYPE);
					
					// double
				
		            	dos.writeDouble(this.OPENING_PRESSURE);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_PRESSURE);
					
					// int
				
		            	dos.writeInt(this.OPENING_XCTN_WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.OPENING_XCTN_FRAC_WGT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.CLOSING_XCTN_WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.CLOSING_XCTN_FRAC_WGT_IN_VAC);
					
					// Integer
				
						writeInteger(this.MAJORITY_SHAREHOLDER,dos);
					
					// int
				
		            	dos.writeInt(this.OPENING_INVENTORY_ENABLE);
					
					// int
				
		            	dos.writeInt(this.CLOSING_INVENTORY_ENABLE);
					
					// int
				
		            	dos.writeInt(this.OPENING_LEVEL_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.CLOSING_LEVEL_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.OPENING_TOV_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.CLOSING_TOV_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.OPENING_TEMPERATURE_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.CLOSING_TEMPERATURE_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.OPENING_DENSITY_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.CLOSING_DENSITY_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.OPENING_NSV_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.CLOSING_NSV_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.OPENING_VAPOR_TEMP_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.CLOSING_VAPOR_TEMP_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.OPENING_PRESSURE_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.CLOSING_PRESSURE_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.OPENING_FREE_WATER_LVL_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.CLOSING_FREE_WATER_LVL_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.OPENING_WATER_QTY_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.CLOSING_WATER_QTY_ORIGIN);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_OWNER_ID,dos);
					
					// String
				
						writeString(this.COMPARTMENT_CONTAINER_CODE,dos);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_CONTAINER_TYPE,dos);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.COMPARTMENT_VISIT_NUMBER);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("TERMINAL_PRODUCT_NUMBER="+String.valueOf(TERMINAL_PRODUCT_NUMBER));
		sb.append(",FOLIO_NUMBER="+FOLIO_NUMBER);
		sb.append(",TANK_CODE="+TANK_CODE);
		sb.append(",GAIN_LOSS_ID="+String.valueOf(GAIN_LOSS_ID));
		sb.append(",TANK_GROUP="+TANK_GROUP);
		sb.append(",PRODUCT_GROUP_CODE="+PRODUCT_GROUP_CODE);
		sb.append(",OPENING_PHYSICAL="+String.valueOf(OPENING_PHYSICAL));
		sb.append(",BULK_RECEIPTS="+String.valueOf(BULK_RECEIPTS));
		sb.append(",BULK_TRANSFERS_IN="+String.valueOf(BULK_TRANSFERS_IN));
		sb.append(",BULK_DISPOSALS="+String.valueOf(BULK_DISPOSALS));
		sb.append(",BULK_TRANSFERS_OUT="+String.valueOf(BULK_TRANSFERS_OUT));
		sb.append(",RACK_RECEIPTS="+String.valueOf(RACK_RECEIPTS));
		sb.append(",RACK_DISPOSALS="+String.valueOf(RACK_DISPOSALS));
		sb.append(",CLOSING_PHYSICAL="+String.valueOf(CLOSING_PHYSICAL));
		sb.append(",MANUAL_CLOSING_PHYSICAL="+String.valueOf(MANUAL_CLOSING_PHYSICAL));
		sb.append(",GAIN_LOSS="+String.valueOf(GAIN_LOSS));
		sb.append(",RACK_FRAC_RECEIPTS="+String.valueOf(RACK_FRAC_RECEIPTS));
		sb.append(",RACK_FRAC_DISPOSALS="+String.valueOf(RACK_FRAC_DISPOSALS));
		sb.append(",BULK_FRAC_TRANSFERS_IN="+String.valueOf(BULK_FRAC_TRANSFERS_IN));
		sb.append(",BULK_FRAC_TRANSFERS_OUT="+String.valueOf(BULK_FRAC_TRANSFERS_OUT));
		sb.append(",ADD_BULK_RECEIPTS="+String.valueOf(ADD_BULK_RECEIPTS));
		sb.append(",ADD_RACK_RECEIPTS="+String.valueOf(ADD_RACK_RECEIPTS));
		sb.append(",ADD_TRANSFERS_IN="+String.valueOf(ADD_TRANSFERS_IN));
		sb.append(",ADD_BULK_DISPOSALS="+String.valueOf(ADD_BULK_DISPOSALS));
		sb.append(",ADD_RACK_DISPOSALS="+String.valueOf(ADD_RACK_DISPOSALS));
		sb.append(",ADD_TRANSFERS_OUT="+String.valueOf(ADD_TRANSFERS_OUT));
		sb.append(",ADD_GAIN_LOSS="+String.valueOf(ADD_GAIN_LOSS));
		sb.append(",PIPE_FILL="+String.valueOf(PIPE_FILL));
		sb.append(",OPENING_PHYSICAL_GROSS_QTY="+String.valueOf(OPENING_PHYSICAL_GROSS_QTY));
		sb.append(",CLOSING_PHYSICAL_GROSS_QTY="+String.valueOf(CLOSING_PHYSICAL_GROSS_QTY));
		sb.append(",OPENING_TEMPERATURE="+String.valueOf(OPENING_TEMPERATURE));
		sb.append(",CLOSING_TEMPERATURE="+String.valueOf(CLOSING_TEMPERATURE));
		sb.append(",OPENING_DENSITY="+String.valueOf(OPENING_DENSITY));
		sb.append(",CLOSING_DENSITY="+String.valueOf(CLOSING_DENSITY));
		sb.append(",OPENING_BSW_QTY="+String.valueOf(OPENING_BSW_QTY));
		sb.append(",CLOSING_BSW_QTY="+String.valueOf(CLOSING_BSW_QTY));
		sb.append(",OPENING_LEVEL="+OPENING_LEVEL);
		sb.append(",CLOSING_LEVEL="+CLOSING_LEVEL);
		sb.append(",OPENING_OBSERVED_DENSITY="+String.valueOf(OPENING_OBSERVED_DENSITY));
		sb.append(",CLOSING_OBSERVED_DENSITY="+String.valueOf(CLOSING_OBSERVED_DENSITY));
		sb.append(",OPENING_BSW_LEVEL="+OPENING_BSW_LEVEL);
		sb.append(",CLOSING_BSW_LEVEL="+CLOSING_BSW_LEVEL);
		sb.append(",BULK_FRAC_DISPOSALS="+String.valueOf(BULK_FRAC_DISPOSALS));
		sb.append(",BULK_FRAC_RECEIPTS="+String.valueOf(BULK_FRAC_RECEIPTS));
		sb.append(",VIRTUAL_TANK="+String.valueOf(VIRTUAL_TANK));
		sb.append(",OPENING_COE="+String.valueOf(OPENING_COE));
		sb.append(",CLOSING_COE="+String.valueOf(CLOSING_COE));
		sb.append(",OPENING_LINE_SEGMENT_NSV="+String.valueOf(OPENING_LINE_SEGMENT_NSV));
		sb.append(",CLOSING_LINE_SEGMENT_NSV="+String.valueOf(CLOSING_LINE_SEGMENT_NSV));
		sb.append(",OPENING_TOV="+String.valueOf(OPENING_TOV));
		sb.append(",CLOSING_TOV="+String.valueOf(CLOSING_TOV));
		sb.append(",OPENING_GOV="+String.valueOf(OPENING_GOV));
		sb.append(",CLOSING_GOV="+String.valueOf(CLOSING_GOV));
		sb.append(",OPENING_GSV="+String.valueOf(OPENING_GSV));
		sb.append(",CLOSING_GSV="+String.valueOf(CLOSING_GSV));
		sb.append(",OPENING_TCV="+String.valueOf(OPENING_TCV));
		sb.append(",CLOSING_TCV="+String.valueOf(CLOSING_TCV));
		sb.append(",OPENING_CTL="+String.valueOf(OPENING_CTL));
		sb.append(",CLOSING_CTL="+String.valueOf(CLOSING_CTL));
		sb.append(",OPENING_SHELL_CORRECTION_FACTO="+String.valueOf(OPENING_SHELL_CORRECTION_FACTO));
		sb.append(",CLOSING_SHELL_CORRECTION_FACTO="+String.valueOf(CLOSING_SHELL_CORRECTION_FACTO));
		sb.append(",OPENING_FLOATING_ROOF_ADJUSTME="+String.valueOf(OPENING_FLOATING_ROOF_ADJUSTME));
		sb.append(",CLOSING_FLOATING_ROOF_ADJUSTME="+String.valueOf(CLOSING_FLOATING_ROOF_ADJUSTME));
		sb.append(",OPENING_AMBIENT_TEMPERATURE="+String.valueOf(OPENING_AMBIENT_TEMPERATURE));
		sb.append(",CLOSING_AMBIENT_TEMPERATURE="+String.valueOf(CLOSING_AMBIENT_TEMPERATURE));
		sb.append(",OPENING_SUSPENDED_BSW_PERCENT="+String.valueOf(OPENING_SUSPENDED_BSW_PERCENT));
		sb.append(",CLOSING_SUSPENDED_BSW_PERCENT="+String.valueOf(CLOSING_SUSPENDED_BSW_PERCENT));
		sb.append(",OPENING_GAUGER_INITIALS="+OPENING_GAUGER_INITIALS);
		sb.append(",CLOSING_GAUGER_INITIALS="+CLOSING_GAUGER_INITIALS);
		sb.append(",OPENING_GAUGE_TIMESTAMP="+String.valueOf(OPENING_GAUGE_TIMESTAMP));
		sb.append(",CLOSING_GAUGE_TIMESTAMP="+String.valueOf(CLOSING_GAUGE_TIMESTAMP));
		sb.append(",OPENING_PRODUCT_STRAP_TYPE="+String.valueOf(OPENING_PRODUCT_STRAP_TYPE));
		sb.append(",CLOSING_PRODUCT_STRAP_TYPE="+String.valueOf(CLOSING_PRODUCT_STRAP_TYPE));
		sb.append(",OPENING_BSW_STRAP_TYPE="+String.valueOf(OPENING_BSW_STRAP_TYPE));
		sb.append(",CLOSING_BSW_STRAP_TYPE="+String.valueOf(CLOSING_BSW_STRAP_TYPE));
		sb.append(",OPENING_GSW="+String.valueOf(OPENING_GSW));
		sb.append(",CLOSING_GSW="+String.valueOf(CLOSING_GSW));
		sb.append(",OPENING_NSW="+String.valueOf(OPENING_NSW));
		sb.append(",CLOSING_NSW="+String.valueOf(CLOSING_NSW));
		sb.append(",OPENING_WCF="+String.valueOf(OPENING_WCF));
		sb.append(",CLOSING_WCF="+String.valueOf(CLOSING_WCF));
		sb.append(",OPENING_LINE_SEGMENT_NSW="+String.valueOf(OPENING_LINE_SEGMENT_NSW));
		sb.append(",CLOSING_LINE_SEGMENT_NSW="+String.valueOf(CLOSING_LINE_SEGMENT_NSW));
		sb.append(",OPENING_NSV="+String.valueOf(OPENING_NSV));
		sb.append(",CLOSING_NSV="+String.valueOf(CLOSING_NSV));
		sb.append(",OPENING_XCTN_GROSS_QTY="+String.valueOf(OPENING_XCTN_GROSS_QTY));
		sb.append(",CLOSING_XCTN_GROSS_QTY="+String.valueOf(CLOSING_XCTN_GROSS_QTY));
		sb.append(",OPENING_XCTN_FRAC_GROSS_QTY="+String.valueOf(OPENING_XCTN_FRAC_GROSS_QTY));
		sb.append(",CLOSING_XCTN_FRAC_GROSS_QTY="+String.valueOf(CLOSING_XCTN_FRAC_GROSS_QTY));
		sb.append(",OPENING_XCTN_NET_QTY="+String.valueOf(OPENING_XCTN_NET_QTY));
		sb.append(",CLOSING_XCTN_NET_QTY="+String.valueOf(CLOSING_XCTN_NET_QTY));
		sb.append(",OPENING_XCTN_FRAC_NET_QTY="+String.valueOf(OPENING_XCTN_FRAC_NET_QTY));
		sb.append(",CLOSING_XCTN_FRAC_NET_QTY="+String.valueOf(CLOSING_XCTN_FRAC_NET_QTY));
		sb.append(",OPENING_CALCULATION_POINT="+String.valueOf(OPENING_CALCULATION_POINT));
		sb.append(",CLOSING_CALCULATION_POINT="+String.valueOf(CLOSING_CALCULATION_POINT));
		sb.append(",MANUAL_OPENING_PHYSICAL="+String.valueOf(MANUAL_OPENING_PHYSICAL));
		sb.append(",OPENING_API_CODE="+OPENING_API_CODE);
		sb.append(",CLOSING_API_CODE="+CLOSING_API_CODE);
		sb.append(",OPENING_WEIGHT_IN_AIR="+String.valueOf(OPENING_WEIGHT_IN_AIR));
		sb.append(",CLOSING_WEIGHT_IN_AIR="+String.valueOf(CLOSING_WEIGHT_IN_AIR));
		sb.append(",OPENING_XCTN_WEIGHT="+String.valueOf(OPENING_XCTN_WEIGHT));
		sb.append(",OPENING_XCTN_FRAC_WEIGHT="+String.valueOf(OPENING_XCTN_FRAC_WEIGHT));
		sb.append(",CLOSING_XCTN_WEIGHT="+String.valueOf(CLOSING_XCTN_WEIGHT));
		sb.append(",CLOSING_XCTN_FRAC_WEIGHT="+String.valueOf(CLOSING_XCTN_FRAC_WEIGHT));
		sb.append(",OPENING_VAPOR_CORRECT_METHOD="+String.valueOf(OPENING_VAPOR_CORRECT_METHOD));
		sb.append(",CLOSING_VAPOR_CORRECT_METHOD="+String.valueOf(CLOSING_VAPOR_CORRECT_METHOD));
		sb.append(",OPENING_VAPOR_TEMPERATURE="+String.valueOf(OPENING_VAPOR_TEMPERATURE));
		sb.append(",CLOSING_VAPOR_TEMPERATURE="+String.valueOf(CLOSING_VAPOR_TEMPERATURE));
		sb.append(",OPENING_VAPOR_LIQUID_VOL_RATIO="+String.valueOf(OPENING_VAPOR_LIQUID_VOL_RATIO));
		sb.append(",CLOSING_VAPOR_LIQUID_VOL_RATIO="+String.valueOf(CLOSING_VAPOR_LIQUID_VOL_RATIO));
		sb.append(",INVENTORY_QUANTITY_TYPE="+String.valueOf(INVENTORY_QUANTITY_TYPE));
		sb.append(",OPENING_PRESSURE="+String.valueOf(OPENING_PRESSURE));
		sb.append(",CLOSING_PRESSURE="+String.valueOf(CLOSING_PRESSURE));
		sb.append(",OPENING_XCTN_WEIGHT_IN_VAC="+String.valueOf(OPENING_XCTN_WEIGHT_IN_VAC));
		sb.append(",OPENING_XCTN_FRAC_WGT_IN_VAC="+String.valueOf(OPENING_XCTN_FRAC_WGT_IN_VAC));
		sb.append(",CLOSING_XCTN_WEIGHT_IN_VAC="+String.valueOf(CLOSING_XCTN_WEIGHT_IN_VAC));
		sb.append(",CLOSING_XCTN_FRAC_WGT_IN_VAC="+String.valueOf(CLOSING_XCTN_FRAC_WGT_IN_VAC));
		sb.append(",MAJORITY_SHAREHOLDER="+String.valueOf(MAJORITY_SHAREHOLDER));
		sb.append(",OPENING_INVENTORY_ENABLE="+String.valueOf(OPENING_INVENTORY_ENABLE));
		sb.append(",CLOSING_INVENTORY_ENABLE="+String.valueOf(CLOSING_INVENTORY_ENABLE));
		sb.append(",OPENING_LEVEL_ORIGIN="+String.valueOf(OPENING_LEVEL_ORIGIN));
		sb.append(",CLOSING_LEVEL_ORIGIN="+String.valueOf(CLOSING_LEVEL_ORIGIN));
		sb.append(",OPENING_TOV_ORIGIN="+String.valueOf(OPENING_TOV_ORIGIN));
		sb.append(",CLOSING_TOV_ORIGIN="+String.valueOf(CLOSING_TOV_ORIGIN));
		sb.append(",OPENING_TEMPERATURE_ORIGIN="+String.valueOf(OPENING_TEMPERATURE_ORIGIN));
		sb.append(",CLOSING_TEMPERATURE_ORIGIN="+String.valueOf(CLOSING_TEMPERATURE_ORIGIN));
		sb.append(",OPENING_DENSITY_ORIGIN="+String.valueOf(OPENING_DENSITY_ORIGIN));
		sb.append(",CLOSING_DENSITY_ORIGIN="+String.valueOf(CLOSING_DENSITY_ORIGIN));
		sb.append(",OPENING_NSV_ORIGIN="+String.valueOf(OPENING_NSV_ORIGIN));
		sb.append(",CLOSING_NSV_ORIGIN="+String.valueOf(CLOSING_NSV_ORIGIN));
		sb.append(",OPENING_VAPOR_TEMP_ORIGIN="+String.valueOf(OPENING_VAPOR_TEMP_ORIGIN));
		sb.append(",CLOSING_VAPOR_TEMP_ORIGIN="+String.valueOf(CLOSING_VAPOR_TEMP_ORIGIN));
		sb.append(",OPENING_PRESSURE_ORIGIN="+String.valueOf(OPENING_PRESSURE_ORIGIN));
		sb.append(",CLOSING_PRESSURE_ORIGIN="+String.valueOf(CLOSING_PRESSURE_ORIGIN));
		sb.append(",OPENING_FREE_WATER_LVL_ORIGIN="+String.valueOf(OPENING_FREE_WATER_LVL_ORIGIN));
		sb.append(",CLOSING_FREE_WATER_LVL_ORIGIN="+String.valueOf(CLOSING_FREE_WATER_LVL_ORIGIN));
		sb.append(",OPENING_WATER_QTY_ORIGIN="+String.valueOf(OPENING_WATER_QTY_ORIGIN));
		sb.append(",CLOSING_WATER_QTY_ORIGIN="+String.valueOf(CLOSING_WATER_QTY_ORIGIN));
		sb.append(",COMPARTMENT_OWNER_ID="+String.valueOf(COMPARTMENT_OWNER_ID));
		sb.append(",COMPARTMENT_CONTAINER_CODE="+COMPARTMENT_CONTAINER_CODE);
		sb.append(",COMPARTMENT_CONTAINER_TYPE="+String.valueOf(COMPARTMENT_CONTAINER_TYPE));
		sb.append(",COMPARTMENT_NUMBER="+String.valueOf(COMPARTMENT_NUMBER));
		sb.append(",COMPARTMENT_VISIT_NUMBER="+String.valueOf(COMPARTMENT_VISIT_NUMBER));
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
    final static byte[] commonByteArrayLock_PGS_STAGE_DIM_GAIN_LOSS_HISTORY = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_DIM_GAIN_LOSS_HISTORY = new byte[0];

	
			    public int TERMINAL_PRODUCT_NUMBER;

				public int getTERMINAL_PRODUCT_NUMBER () {
					return this.TERMINAL_PRODUCT_NUMBER;
				}
				
			    public String FOLIO_NUMBER;

				public String getFOLIO_NUMBER () {
					return this.FOLIO_NUMBER;
				}
				
			    public String TANK_CODE;

				public String getTANK_CODE () {
					return this.TANK_CODE;
				}
				
			    public int GAIN_LOSS_ID;

				public int getGAIN_LOSS_ID () {
					return this.GAIN_LOSS_ID;
				}
				
			    public String TANK_GROUP;

				public String getTANK_GROUP () {
					return this.TANK_GROUP;
				}
				
			    public String PRODUCT_GROUP_CODE;

				public String getPRODUCT_GROUP_CODE () {
					return this.PRODUCT_GROUP_CODE;
				}
				
			    public int OPENING_PHYSICAL;

				public int getOPENING_PHYSICAL () {
					return this.OPENING_PHYSICAL;
				}
				
			    public int BULK_RECEIPTS;

				public int getBULK_RECEIPTS () {
					return this.BULK_RECEIPTS;
				}
				
			    public int BULK_TRANSFERS_IN;

				public int getBULK_TRANSFERS_IN () {
					return this.BULK_TRANSFERS_IN;
				}
				
			    public int BULK_DISPOSALS;

				public int getBULK_DISPOSALS () {
					return this.BULK_DISPOSALS;
				}
				
			    public int BULK_TRANSFERS_OUT;

				public int getBULK_TRANSFERS_OUT () {
					return this.BULK_TRANSFERS_OUT;
				}
				
			    public int RACK_RECEIPTS;

				public int getRACK_RECEIPTS () {
					return this.RACK_RECEIPTS;
				}
				
			    public int RACK_DISPOSALS;

				public int getRACK_DISPOSALS () {
					return this.RACK_DISPOSALS;
				}
				
			    public int CLOSING_PHYSICAL;

				public int getCLOSING_PHYSICAL () {
					return this.CLOSING_PHYSICAL;
				}
				
			    public int MANUAL_CLOSING_PHYSICAL;

				public int getMANUAL_CLOSING_PHYSICAL () {
					return this.MANUAL_CLOSING_PHYSICAL;
				}
				
			    public int GAIN_LOSS;

				public int getGAIN_LOSS () {
					return this.GAIN_LOSS;
				}
				
			    public int RACK_FRAC_RECEIPTS;

				public int getRACK_FRAC_RECEIPTS () {
					return this.RACK_FRAC_RECEIPTS;
				}
				
			    public int RACK_FRAC_DISPOSALS;

				public int getRACK_FRAC_DISPOSALS () {
					return this.RACK_FRAC_DISPOSALS;
				}
				
			    public int BULK_FRAC_TRANSFERS_IN;

				public int getBULK_FRAC_TRANSFERS_IN () {
					return this.BULK_FRAC_TRANSFERS_IN;
				}
				
			    public int BULK_FRAC_TRANSFERS_OUT;

				public int getBULK_FRAC_TRANSFERS_OUT () {
					return this.BULK_FRAC_TRANSFERS_OUT;
				}
				
			    public int ADD_BULK_RECEIPTS;

				public int getADD_BULK_RECEIPTS () {
					return this.ADD_BULK_RECEIPTS;
				}
				
			    public int ADD_RACK_RECEIPTS;

				public int getADD_RACK_RECEIPTS () {
					return this.ADD_RACK_RECEIPTS;
				}
				
			    public int ADD_TRANSFERS_IN;

				public int getADD_TRANSFERS_IN () {
					return this.ADD_TRANSFERS_IN;
				}
				
			    public int ADD_BULK_DISPOSALS;

				public int getADD_BULK_DISPOSALS () {
					return this.ADD_BULK_DISPOSALS;
				}
				
			    public int ADD_RACK_DISPOSALS;

				public int getADD_RACK_DISPOSALS () {
					return this.ADD_RACK_DISPOSALS;
				}
				
			    public int ADD_TRANSFERS_OUT;

				public int getADD_TRANSFERS_OUT () {
					return this.ADD_TRANSFERS_OUT;
				}
				
			    public int ADD_GAIN_LOSS;

				public int getADD_GAIN_LOSS () {
					return this.ADD_GAIN_LOSS;
				}
				
			    public int PIPE_FILL;

				public int getPIPE_FILL () {
					return this.PIPE_FILL;
				}
				
			    public int OPENING_PHYSICAL_GROSS_QTY;

				public int getOPENING_PHYSICAL_GROSS_QTY () {
					return this.OPENING_PHYSICAL_GROSS_QTY;
				}
				
			    public int CLOSING_PHYSICAL_GROSS_QTY;

				public int getCLOSING_PHYSICAL_GROSS_QTY () {
					return this.CLOSING_PHYSICAL_GROSS_QTY;
				}
				
			    public double OPENING_TEMPERATURE;

				public double getOPENING_TEMPERATURE () {
					return this.OPENING_TEMPERATURE;
				}
				
			    public double CLOSING_TEMPERATURE;

				public double getCLOSING_TEMPERATURE () {
					return this.CLOSING_TEMPERATURE;
				}
				
			    public double OPENING_DENSITY;

				public double getOPENING_DENSITY () {
					return this.OPENING_DENSITY;
				}
				
			    public double CLOSING_DENSITY;

				public double getCLOSING_DENSITY () {
					return this.CLOSING_DENSITY;
				}
				
			    public int OPENING_BSW_QTY;

				public int getOPENING_BSW_QTY () {
					return this.OPENING_BSW_QTY;
				}
				
			    public int CLOSING_BSW_QTY;

				public int getCLOSING_BSW_QTY () {
					return this.CLOSING_BSW_QTY;
				}
				
			    public String OPENING_LEVEL;

				public String getOPENING_LEVEL () {
					return this.OPENING_LEVEL;
				}
				
			    public String CLOSING_LEVEL;

				public String getCLOSING_LEVEL () {
					return this.CLOSING_LEVEL;
				}
				
			    public double OPENING_OBSERVED_DENSITY;

				public double getOPENING_OBSERVED_DENSITY () {
					return this.OPENING_OBSERVED_DENSITY;
				}
				
			    public double CLOSING_OBSERVED_DENSITY;

				public double getCLOSING_OBSERVED_DENSITY () {
					return this.CLOSING_OBSERVED_DENSITY;
				}
				
			    public String OPENING_BSW_LEVEL;

				public String getOPENING_BSW_LEVEL () {
					return this.OPENING_BSW_LEVEL;
				}
				
			    public String CLOSING_BSW_LEVEL;

				public String getCLOSING_BSW_LEVEL () {
					return this.CLOSING_BSW_LEVEL;
				}
				
			    public int BULK_FRAC_DISPOSALS;

				public int getBULK_FRAC_DISPOSALS () {
					return this.BULK_FRAC_DISPOSALS;
				}
				
			    public int BULK_FRAC_RECEIPTS;

				public int getBULK_FRAC_RECEIPTS () {
					return this.BULK_FRAC_RECEIPTS;
				}
				
			    public int VIRTUAL_TANK;

				public int getVIRTUAL_TANK () {
					return this.VIRTUAL_TANK;
				}
				
			    public double OPENING_COE;

				public double getOPENING_COE () {
					return this.OPENING_COE;
				}
				
			    public double CLOSING_COE;

				public double getCLOSING_COE () {
					return this.CLOSING_COE;
				}
				
			    public int OPENING_LINE_SEGMENT_NSV;

				public int getOPENING_LINE_SEGMENT_NSV () {
					return this.OPENING_LINE_SEGMENT_NSV;
				}
				
			    public int CLOSING_LINE_SEGMENT_NSV;

				public int getCLOSING_LINE_SEGMENT_NSV () {
					return this.CLOSING_LINE_SEGMENT_NSV;
				}
				
			    public int OPENING_TOV;

				public int getOPENING_TOV () {
					return this.OPENING_TOV;
				}
				
			    public int CLOSING_TOV;

				public int getCLOSING_TOV () {
					return this.CLOSING_TOV;
				}
				
			    public int OPENING_GOV;

				public int getOPENING_GOV () {
					return this.OPENING_GOV;
				}
				
			    public int CLOSING_GOV;

				public int getCLOSING_GOV () {
					return this.CLOSING_GOV;
				}
				
			    public int OPENING_GSV;

				public int getOPENING_GSV () {
					return this.OPENING_GSV;
				}
				
			    public int CLOSING_GSV;

				public int getCLOSING_GSV () {
					return this.CLOSING_GSV;
				}
				
			    public int OPENING_TCV;

				public int getOPENING_TCV () {
					return this.OPENING_TCV;
				}
				
			    public int CLOSING_TCV;

				public int getCLOSING_TCV () {
					return this.CLOSING_TCV;
				}
				
			    public double OPENING_CTL;

				public double getOPENING_CTL () {
					return this.OPENING_CTL;
				}
				
			    public double CLOSING_CTL;

				public double getCLOSING_CTL () {
					return this.CLOSING_CTL;
				}
				
			    public double OPENING_SHELL_CORRECTION_FACTO;

				public double getOPENING_SHELL_CORRECTION_FACTO () {
					return this.OPENING_SHELL_CORRECTION_FACTO;
				}
				
			    public double CLOSING_SHELL_CORRECTION_FACTO;

				public double getCLOSING_SHELL_CORRECTION_FACTO () {
					return this.CLOSING_SHELL_CORRECTION_FACTO;
				}
				
			    public int OPENING_FLOATING_ROOF_ADJUSTME;

				public int getOPENING_FLOATING_ROOF_ADJUSTME () {
					return this.OPENING_FLOATING_ROOF_ADJUSTME;
				}
				
			    public int CLOSING_FLOATING_ROOF_ADJUSTME;

				public int getCLOSING_FLOATING_ROOF_ADJUSTME () {
					return this.CLOSING_FLOATING_ROOF_ADJUSTME;
				}
				
			    public double OPENING_AMBIENT_TEMPERATURE;

				public double getOPENING_AMBIENT_TEMPERATURE () {
					return this.OPENING_AMBIENT_TEMPERATURE;
				}
				
			    public double CLOSING_AMBIENT_TEMPERATURE;

				public double getCLOSING_AMBIENT_TEMPERATURE () {
					return this.CLOSING_AMBIENT_TEMPERATURE;
				}
				
			    public double OPENING_SUSPENDED_BSW_PERCENT;

				public double getOPENING_SUSPENDED_BSW_PERCENT () {
					return this.OPENING_SUSPENDED_BSW_PERCENT;
				}
				
			    public double CLOSING_SUSPENDED_BSW_PERCENT;

				public double getCLOSING_SUSPENDED_BSW_PERCENT () {
					return this.CLOSING_SUSPENDED_BSW_PERCENT;
				}
				
			    public String OPENING_GAUGER_INITIALS;

				public String getOPENING_GAUGER_INITIALS () {
					return this.OPENING_GAUGER_INITIALS;
				}
				
			    public String CLOSING_GAUGER_INITIALS;

				public String getCLOSING_GAUGER_INITIALS () {
					return this.CLOSING_GAUGER_INITIALS;
				}
				
			    public java.util.Date OPENING_GAUGE_TIMESTAMP;

				public java.util.Date getOPENING_GAUGE_TIMESTAMP () {
					return this.OPENING_GAUGE_TIMESTAMP;
				}
				
			    public java.util.Date CLOSING_GAUGE_TIMESTAMP;

				public java.util.Date getCLOSING_GAUGE_TIMESTAMP () {
					return this.CLOSING_GAUGE_TIMESTAMP;
				}
				
			    public int OPENING_PRODUCT_STRAP_TYPE;

				public int getOPENING_PRODUCT_STRAP_TYPE () {
					return this.OPENING_PRODUCT_STRAP_TYPE;
				}
				
			    public int CLOSING_PRODUCT_STRAP_TYPE;

				public int getCLOSING_PRODUCT_STRAP_TYPE () {
					return this.CLOSING_PRODUCT_STRAP_TYPE;
				}
				
			    public int OPENING_BSW_STRAP_TYPE;

				public int getOPENING_BSW_STRAP_TYPE () {
					return this.OPENING_BSW_STRAP_TYPE;
				}
				
			    public int CLOSING_BSW_STRAP_TYPE;

				public int getCLOSING_BSW_STRAP_TYPE () {
					return this.CLOSING_BSW_STRAP_TYPE;
				}
				
			    public int OPENING_GSW;

				public int getOPENING_GSW () {
					return this.OPENING_GSW;
				}
				
			    public int CLOSING_GSW;

				public int getCLOSING_GSW () {
					return this.CLOSING_GSW;
				}
				
			    public int OPENING_NSW;

				public int getOPENING_NSW () {
					return this.OPENING_NSW;
				}
				
			    public int CLOSING_NSW;

				public int getCLOSING_NSW () {
					return this.CLOSING_NSW;
				}
				
			    public double OPENING_WCF;

				public double getOPENING_WCF () {
					return this.OPENING_WCF;
				}
				
			    public double CLOSING_WCF;

				public double getCLOSING_WCF () {
					return this.CLOSING_WCF;
				}
				
			    public int OPENING_LINE_SEGMENT_NSW;

				public int getOPENING_LINE_SEGMENT_NSW () {
					return this.OPENING_LINE_SEGMENT_NSW;
				}
				
			    public int CLOSING_LINE_SEGMENT_NSW;

				public int getCLOSING_LINE_SEGMENT_NSW () {
					return this.CLOSING_LINE_SEGMENT_NSW;
				}
				
			    public int OPENING_NSV;

				public int getOPENING_NSV () {
					return this.OPENING_NSV;
				}
				
			    public int CLOSING_NSV;

				public int getCLOSING_NSV () {
					return this.CLOSING_NSV;
				}
				
			    public int OPENING_XCTN_GROSS_QTY;

				public int getOPENING_XCTN_GROSS_QTY () {
					return this.OPENING_XCTN_GROSS_QTY;
				}
				
			    public int CLOSING_XCTN_GROSS_QTY;

				public int getCLOSING_XCTN_GROSS_QTY () {
					return this.CLOSING_XCTN_GROSS_QTY;
				}
				
			    public int OPENING_XCTN_FRAC_GROSS_QTY;

				public int getOPENING_XCTN_FRAC_GROSS_QTY () {
					return this.OPENING_XCTN_FRAC_GROSS_QTY;
				}
				
			    public int CLOSING_XCTN_FRAC_GROSS_QTY;

				public int getCLOSING_XCTN_FRAC_GROSS_QTY () {
					return this.CLOSING_XCTN_FRAC_GROSS_QTY;
				}
				
			    public int OPENING_XCTN_NET_QTY;

				public int getOPENING_XCTN_NET_QTY () {
					return this.OPENING_XCTN_NET_QTY;
				}
				
			    public int CLOSING_XCTN_NET_QTY;

				public int getCLOSING_XCTN_NET_QTY () {
					return this.CLOSING_XCTN_NET_QTY;
				}
				
			    public int OPENING_XCTN_FRAC_NET_QTY;

				public int getOPENING_XCTN_FRAC_NET_QTY () {
					return this.OPENING_XCTN_FRAC_NET_QTY;
				}
				
			    public int CLOSING_XCTN_FRAC_NET_QTY;

				public int getCLOSING_XCTN_FRAC_NET_QTY () {
					return this.CLOSING_XCTN_FRAC_NET_QTY;
				}
				
			    public int OPENING_CALCULATION_POINT;

				public int getOPENING_CALCULATION_POINT () {
					return this.OPENING_CALCULATION_POINT;
				}
				
			    public int CLOSING_CALCULATION_POINT;

				public int getCLOSING_CALCULATION_POINT () {
					return this.CLOSING_CALCULATION_POINT;
				}
				
			    public int MANUAL_OPENING_PHYSICAL;

				public int getMANUAL_OPENING_PHYSICAL () {
					return this.MANUAL_OPENING_PHYSICAL;
				}
				
			    public String OPENING_API_CODE;

				public String getOPENING_API_CODE () {
					return this.OPENING_API_CODE;
				}
				
			    public String CLOSING_API_CODE;

				public String getCLOSING_API_CODE () {
					return this.CLOSING_API_CODE;
				}
				
			    public int OPENING_WEIGHT_IN_AIR;

				public int getOPENING_WEIGHT_IN_AIR () {
					return this.OPENING_WEIGHT_IN_AIR;
				}
				
			    public int CLOSING_WEIGHT_IN_AIR;

				public int getCLOSING_WEIGHT_IN_AIR () {
					return this.CLOSING_WEIGHT_IN_AIR;
				}
				
			    public int OPENING_XCTN_WEIGHT;

				public int getOPENING_XCTN_WEIGHT () {
					return this.OPENING_XCTN_WEIGHT;
				}
				
			    public int OPENING_XCTN_FRAC_WEIGHT;

				public int getOPENING_XCTN_FRAC_WEIGHT () {
					return this.OPENING_XCTN_FRAC_WEIGHT;
				}
				
			    public int CLOSING_XCTN_WEIGHT;

				public int getCLOSING_XCTN_WEIGHT () {
					return this.CLOSING_XCTN_WEIGHT;
				}
				
			    public int CLOSING_XCTN_FRAC_WEIGHT;

				public int getCLOSING_XCTN_FRAC_WEIGHT () {
					return this.CLOSING_XCTN_FRAC_WEIGHT;
				}
				
			    public int OPENING_VAPOR_CORRECT_METHOD;

				public int getOPENING_VAPOR_CORRECT_METHOD () {
					return this.OPENING_VAPOR_CORRECT_METHOD;
				}
				
			    public int CLOSING_VAPOR_CORRECT_METHOD;

				public int getCLOSING_VAPOR_CORRECT_METHOD () {
					return this.CLOSING_VAPOR_CORRECT_METHOD;
				}
				
			    public double OPENING_VAPOR_TEMPERATURE;

				public double getOPENING_VAPOR_TEMPERATURE () {
					return this.OPENING_VAPOR_TEMPERATURE;
				}
				
			    public double CLOSING_VAPOR_TEMPERATURE;

				public double getCLOSING_VAPOR_TEMPERATURE () {
					return this.CLOSING_VAPOR_TEMPERATURE;
				}
				
			    public double OPENING_VAPOR_LIQUID_VOL_RATIO;

				public double getOPENING_VAPOR_LIQUID_VOL_RATIO () {
					return this.OPENING_VAPOR_LIQUID_VOL_RATIO;
				}
				
			    public double CLOSING_VAPOR_LIQUID_VOL_RATIO;

				public double getCLOSING_VAPOR_LIQUID_VOL_RATIO () {
					return this.CLOSING_VAPOR_LIQUID_VOL_RATIO;
				}
				
			    public int INVENTORY_QUANTITY_TYPE;

				public int getINVENTORY_QUANTITY_TYPE () {
					return this.INVENTORY_QUANTITY_TYPE;
				}
				
			    public double OPENING_PRESSURE;

				public double getOPENING_PRESSURE () {
					return this.OPENING_PRESSURE;
				}
				
			    public double CLOSING_PRESSURE;

				public double getCLOSING_PRESSURE () {
					return this.CLOSING_PRESSURE;
				}
				
			    public int OPENING_XCTN_WEIGHT_IN_VAC;

				public int getOPENING_XCTN_WEIGHT_IN_VAC () {
					return this.OPENING_XCTN_WEIGHT_IN_VAC;
				}
				
			    public int OPENING_XCTN_FRAC_WGT_IN_VAC;

				public int getOPENING_XCTN_FRAC_WGT_IN_VAC () {
					return this.OPENING_XCTN_FRAC_WGT_IN_VAC;
				}
				
			    public int CLOSING_XCTN_WEIGHT_IN_VAC;

				public int getCLOSING_XCTN_WEIGHT_IN_VAC () {
					return this.CLOSING_XCTN_WEIGHT_IN_VAC;
				}
				
			    public int CLOSING_XCTN_FRAC_WGT_IN_VAC;

				public int getCLOSING_XCTN_FRAC_WGT_IN_VAC () {
					return this.CLOSING_XCTN_FRAC_WGT_IN_VAC;
				}
				
			    public Integer MAJORITY_SHAREHOLDER;

				public Integer getMAJORITY_SHAREHOLDER () {
					return this.MAJORITY_SHAREHOLDER;
				}
				
			    public int OPENING_INVENTORY_ENABLE;

				public int getOPENING_INVENTORY_ENABLE () {
					return this.OPENING_INVENTORY_ENABLE;
				}
				
			    public int CLOSING_INVENTORY_ENABLE;

				public int getCLOSING_INVENTORY_ENABLE () {
					return this.CLOSING_INVENTORY_ENABLE;
				}
				
			    public int OPENING_LEVEL_ORIGIN;

				public int getOPENING_LEVEL_ORIGIN () {
					return this.OPENING_LEVEL_ORIGIN;
				}
				
			    public int CLOSING_LEVEL_ORIGIN;

				public int getCLOSING_LEVEL_ORIGIN () {
					return this.CLOSING_LEVEL_ORIGIN;
				}
				
			    public int OPENING_TOV_ORIGIN;

				public int getOPENING_TOV_ORIGIN () {
					return this.OPENING_TOV_ORIGIN;
				}
				
			    public int CLOSING_TOV_ORIGIN;

				public int getCLOSING_TOV_ORIGIN () {
					return this.CLOSING_TOV_ORIGIN;
				}
				
			    public int OPENING_TEMPERATURE_ORIGIN;

				public int getOPENING_TEMPERATURE_ORIGIN () {
					return this.OPENING_TEMPERATURE_ORIGIN;
				}
				
			    public int CLOSING_TEMPERATURE_ORIGIN;

				public int getCLOSING_TEMPERATURE_ORIGIN () {
					return this.CLOSING_TEMPERATURE_ORIGIN;
				}
				
			    public int OPENING_DENSITY_ORIGIN;

				public int getOPENING_DENSITY_ORIGIN () {
					return this.OPENING_DENSITY_ORIGIN;
				}
				
			    public int CLOSING_DENSITY_ORIGIN;

				public int getCLOSING_DENSITY_ORIGIN () {
					return this.CLOSING_DENSITY_ORIGIN;
				}
				
			    public int OPENING_NSV_ORIGIN;

				public int getOPENING_NSV_ORIGIN () {
					return this.OPENING_NSV_ORIGIN;
				}
				
			    public int CLOSING_NSV_ORIGIN;

				public int getCLOSING_NSV_ORIGIN () {
					return this.CLOSING_NSV_ORIGIN;
				}
				
			    public int OPENING_VAPOR_TEMP_ORIGIN;

				public int getOPENING_VAPOR_TEMP_ORIGIN () {
					return this.OPENING_VAPOR_TEMP_ORIGIN;
				}
				
			    public int CLOSING_VAPOR_TEMP_ORIGIN;

				public int getCLOSING_VAPOR_TEMP_ORIGIN () {
					return this.CLOSING_VAPOR_TEMP_ORIGIN;
				}
				
			    public int OPENING_PRESSURE_ORIGIN;

				public int getOPENING_PRESSURE_ORIGIN () {
					return this.OPENING_PRESSURE_ORIGIN;
				}
				
			    public int CLOSING_PRESSURE_ORIGIN;

				public int getCLOSING_PRESSURE_ORIGIN () {
					return this.CLOSING_PRESSURE_ORIGIN;
				}
				
			    public int OPENING_FREE_WATER_LVL_ORIGIN;

				public int getOPENING_FREE_WATER_LVL_ORIGIN () {
					return this.OPENING_FREE_WATER_LVL_ORIGIN;
				}
				
			    public int CLOSING_FREE_WATER_LVL_ORIGIN;

				public int getCLOSING_FREE_WATER_LVL_ORIGIN () {
					return this.CLOSING_FREE_WATER_LVL_ORIGIN;
				}
				
			    public int OPENING_WATER_QTY_ORIGIN;

				public int getOPENING_WATER_QTY_ORIGIN () {
					return this.OPENING_WATER_QTY_ORIGIN;
				}
				
			    public int CLOSING_WATER_QTY_ORIGIN;

				public int getCLOSING_WATER_QTY_ORIGIN () {
					return this.CLOSING_WATER_QTY_ORIGIN;
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
				
			    public int COMPARTMENT_VISIT_NUMBER;

				public int getCOMPARTMENT_VISIT_NUMBER () {
					return this.COMPARTMENT_VISIT_NUMBER;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PGS_STAGE_DIM_GAIN_LOSS_HISTORY.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_GAIN_LOSS_HISTORY.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_GAIN_LOSS_HISTORY = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_GAIN_LOSS_HISTORY = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PGS_STAGE_DIM_GAIN_LOSS_HISTORY, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_GAIN_LOSS_HISTORY, 0, length, utf8Charset);
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
			if(length > commonByteArray_PGS_STAGE_DIM_GAIN_LOSS_HISTORY.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_GAIN_LOSS_HISTORY.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_GAIN_LOSS_HISTORY = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_GAIN_LOSS_HISTORY = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PGS_STAGE_DIM_GAIN_LOSS_HISTORY, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_GAIN_LOSS_HISTORY, 0, length, utf8Charset);
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

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_GAIN_LOSS_HISTORY) {

        	try {

        		int length = 0;
		
			        this.TERMINAL_PRODUCT_NUMBER = dis.readInt();
					
					this.FOLIO_NUMBER = readString(dis);
					
					this.TANK_CODE = readString(dis);
					
			        this.GAIN_LOSS_ID = dis.readInt();
					
					this.TANK_GROUP = readString(dis);
					
					this.PRODUCT_GROUP_CODE = readString(dis);
					
			        this.OPENING_PHYSICAL = dis.readInt();
					
			        this.BULK_RECEIPTS = dis.readInt();
					
			        this.BULK_TRANSFERS_IN = dis.readInt();
					
			        this.BULK_DISPOSALS = dis.readInt();
					
			        this.BULK_TRANSFERS_OUT = dis.readInt();
					
			        this.RACK_RECEIPTS = dis.readInt();
					
			        this.RACK_DISPOSALS = dis.readInt();
					
			        this.CLOSING_PHYSICAL = dis.readInt();
					
			        this.MANUAL_CLOSING_PHYSICAL = dis.readInt();
					
			        this.GAIN_LOSS = dis.readInt();
					
			        this.RACK_FRAC_RECEIPTS = dis.readInt();
					
			        this.RACK_FRAC_DISPOSALS = dis.readInt();
					
			        this.BULK_FRAC_TRANSFERS_IN = dis.readInt();
					
			        this.BULK_FRAC_TRANSFERS_OUT = dis.readInt();
					
			        this.ADD_BULK_RECEIPTS = dis.readInt();
					
			        this.ADD_RACK_RECEIPTS = dis.readInt();
					
			        this.ADD_TRANSFERS_IN = dis.readInt();
					
			        this.ADD_BULK_DISPOSALS = dis.readInt();
					
			        this.ADD_RACK_DISPOSALS = dis.readInt();
					
			        this.ADD_TRANSFERS_OUT = dis.readInt();
					
			        this.ADD_GAIN_LOSS = dis.readInt();
					
			        this.PIPE_FILL = dis.readInt();
					
			        this.OPENING_PHYSICAL_GROSS_QTY = dis.readInt();
					
			        this.CLOSING_PHYSICAL_GROSS_QTY = dis.readInt();
					
			        this.OPENING_TEMPERATURE = dis.readDouble();
					
			        this.CLOSING_TEMPERATURE = dis.readDouble();
					
			        this.OPENING_DENSITY = dis.readDouble();
					
			        this.CLOSING_DENSITY = dis.readDouble();
					
			        this.OPENING_BSW_QTY = dis.readInt();
					
			        this.CLOSING_BSW_QTY = dis.readInt();
					
					this.OPENING_LEVEL = readString(dis);
					
					this.CLOSING_LEVEL = readString(dis);
					
			        this.OPENING_OBSERVED_DENSITY = dis.readDouble();
					
			        this.CLOSING_OBSERVED_DENSITY = dis.readDouble();
					
					this.OPENING_BSW_LEVEL = readString(dis);
					
					this.CLOSING_BSW_LEVEL = readString(dis);
					
			        this.BULK_FRAC_DISPOSALS = dis.readInt();
					
			        this.BULK_FRAC_RECEIPTS = dis.readInt();
					
			        this.VIRTUAL_TANK = dis.readInt();
					
			        this.OPENING_COE = dis.readDouble();
					
			        this.CLOSING_COE = dis.readDouble();
					
			        this.OPENING_LINE_SEGMENT_NSV = dis.readInt();
					
			        this.CLOSING_LINE_SEGMENT_NSV = dis.readInt();
					
			        this.OPENING_TOV = dis.readInt();
					
			        this.CLOSING_TOV = dis.readInt();
					
			        this.OPENING_GOV = dis.readInt();
					
			        this.CLOSING_GOV = dis.readInt();
					
			        this.OPENING_GSV = dis.readInt();
					
			        this.CLOSING_GSV = dis.readInt();
					
			        this.OPENING_TCV = dis.readInt();
					
			        this.CLOSING_TCV = dis.readInt();
					
			        this.OPENING_CTL = dis.readDouble();
					
			        this.CLOSING_CTL = dis.readDouble();
					
			        this.OPENING_SHELL_CORRECTION_FACTO = dis.readDouble();
					
			        this.CLOSING_SHELL_CORRECTION_FACTO = dis.readDouble();
					
			        this.OPENING_FLOATING_ROOF_ADJUSTME = dis.readInt();
					
			        this.CLOSING_FLOATING_ROOF_ADJUSTME = dis.readInt();
					
			        this.OPENING_AMBIENT_TEMPERATURE = dis.readDouble();
					
			        this.CLOSING_AMBIENT_TEMPERATURE = dis.readDouble();
					
			        this.OPENING_SUSPENDED_BSW_PERCENT = dis.readDouble();
					
			        this.CLOSING_SUSPENDED_BSW_PERCENT = dis.readDouble();
					
					this.OPENING_GAUGER_INITIALS = readString(dis);
					
					this.CLOSING_GAUGER_INITIALS = readString(dis);
					
					this.OPENING_GAUGE_TIMESTAMP = readDate(dis);
					
					this.CLOSING_GAUGE_TIMESTAMP = readDate(dis);
					
			        this.OPENING_PRODUCT_STRAP_TYPE = dis.readInt();
					
			        this.CLOSING_PRODUCT_STRAP_TYPE = dis.readInt();
					
			        this.OPENING_BSW_STRAP_TYPE = dis.readInt();
					
			        this.CLOSING_BSW_STRAP_TYPE = dis.readInt();
					
			        this.OPENING_GSW = dis.readInt();
					
			        this.CLOSING_GSW = dis.readInt();
					
			        this.OPENING_NSW = dis.readInt();
					
			        this.CLOSING_NSW = dis.readInt();
					
			        this.OPENING_WCF = dis.readDouble();
					
			        this.CLOSING_WCF = dis.readDouble();
					
			        this.OPENING_LINE_SEGMENT_NSW = dis.readInt();
					
			        this.CLOSING_LINE_SEGMENT_NSW = dis.readInt();
					
			        this.OPENING_NSV = dis.readInt();
					
			        this.CLOSING_NSV = dis.readInt();
					
			        this.OPENING_XCTN_GROSS_QTY = dis.readInt();
					
			        this.CLOSING_XCTN_GROSS_QTY = dis.readInt();
					
			        this.OPENING_XCTN_FRAC_GROSS_QTY = dis.readInt();
					
			        this.CLOSING_XCTN_FRAC_GROSS_QTY = dis.readInt();
					
			        this.OPENING_XCTN_NET_QTY = dis.readInt();
					
			        this.CLOSING_XCTN_NET_QTY = dis.readInt();
					
			        this.OPENING_XCTN_FRAC_NET_QTY = dis.readInt();
					
			        this.CLOSING_XCTN_FRAC_NET_QTY = dis.readInt();
					
			        this.OPENING_CALCULATION_POINT = dis.readInt();
					
			        this.CLOSING_CALCULATION_POINT = dis.readInt();
					
			        this.MANUAL_OPENING_PHYSICAL = dis.readInt();
					
					this.OPENING_API_CODE = readString(dis);
					
					this.CLOSING_API_CODE = readString(dis);
					
			        this.OPENING_WEIGHT_IN_AIR = dis.readInt();
					
			        this.CLOSING_WEIGHT_IN_AIR = dis.readInt();
					
			        this.OPENING_XCTN_WEIGHT = dis.readInt();
					
			        this.OPENING_XCTN_FRAC_WEIGHT = dis.readInt();
					
			        this.CLOSING_XCTN_WEIGHT = dis.readInt();
					
			        this.CLOSING_XCTN_FRAC_WEIGHT = dis.readInt();
					
			        this.OPENING_VAPOR_CORRECT_METHOD = dis.readInt();
					
			        this.CLOSING_VAPOR_CORRECT_METHOD = dis.readInt();
					
			        this.OPENING_VAPOR_TEMPERATURE = dis.readDouble();
					
			        this.CLOSING_VAPOR_TEMPERATURE = dis.readDouble();
					
			        this.OPENING_VAPOR_LIQUID_VOL_RATIO = dis.readDouble();
					
			        this.CLOSING_VAPOR_LIQUID_VOL_RATIO = dis.readDouble();
					
			        this.INVENTORY_QUANTITY_TYPE = dis.readInt();
					
			        this.OPENING_PRESSURE = dis.readDouble();
					
			        this.CLOSING_PRESSURE = dis.readDouble();
					
			        this.OPENING_XCTN_WEIGHT_IN_VAC = dis.readInt();
					
			        this.OPENING_XCTN_FRAC_WGT_IN_VAC = dis.readInt();
					
			        this.CLOSING_XCTN_WEIGHT_IN_VAC = dis.readInt();
					
			        this.CLOSING_XCTN_FRAC_WGT_IN_VAC = dis.readInt();
					
						this.MAJORITY_SHAREHOLDER = readInteger(dis);
					
			        this.OPENING_INVENTORY_ENABLE = dis.readInt();
					
			        this.CLOSING_INVENTORY_ENABLE = dis.readInt();
					
			        this.OPENING_LEVEL_ORIGIN = dis.readInt();
					
			        this.CLOSING_LEVEL_ORIGIN = dis.readInt();
					
			        this.OPENING_TOV_ORIGIN = dis.readInt();
					
			        this.CLOSING_TOV_ORIGIN = dis.readInt();
					
			        this.OPENING_TEMPERATURE_ORIGIN = dis.readInt();
					
			        this.CLOSING_TEMPERATURE_ORIGIN = dis.readInt();
					
			        this.OPENING_DENSITY_ORIGIN = dis.readInt();
					
			        this.CLOSING_DENSITY_ORIGIN = dis.readInt();
					
			        this.OPENING_NSV_ORIGIN = dis.readInt();
					
			        this.CLOSING_NSV_ORIGIN = dis.readInt();
					
			        this.OPENING_VAPOR_TEMP_ORIGIN = dis.readInt();
					
			        this.CLOSING_VAPOR_TEMP_ORIGIN = dis.readInt();
					
			        this.OPENING_PRESSURE_ORIGIN = dis.readInt();
					
			        this.CLOSING_PRESSURE_ORIGIN = dis.readInt();
					
			        this.OPENING_FREE_WATER_LVL_ORIGIN = dis.readInt();
					
			        this.CLOSING_FREE_WATER_LVL_ORIGIN = dis.readInt();
					
			        this.OPENING_WATER_QTY_ORIGIN = dis.readInt();
					
			        this.CLOSING_WATER_QTY_ORIGIN = dis.readInt();
					
						this.COMPARTMENT_OWNER_ID = readInteger(dis);
					
					this.COMPARTMENT_CONTAINER_CODE = readString(dis);
					
						this.COMPARTMENT_CONTAINER_TYPE = readInteger(dis);
					
						this.COMPARTMENT_NUMBER = readInteger(dis);
					
			        this.COMPARTMENT_VISIT_NUMBER = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_GAIN_LOSS_HISTORY) {

        	try {

        		int length = 0;
		
			        this.TERMINAL_PRODUCT_NUMBER = dis.readInt();
					
					this.FOLIO_NUMBER = readString(dis);
					
					this.TANK_CODE = readString(dis);
					
			        this.GAIN_LOSS_ID = dis.readInt();
					
					this.TANK_GROUP = readString(dis);
					
					this.PRODUCT_GROUP_CODE = readString(dis);
					
			        this.OPENING_PHYSICAL = dis.readInt();
					
			        this.BULK_RECEIPTS = dis.readInt();
					
			        this.BULK_TRANSFERS_IN = dis.readInt();
					
			        this.BULK_DISPOSALS = dis.readInt();
					
			        this.BULK_TRANSFERS_OUT = dis.readInt();
					
			        this.RACK_RECEIPTS = dis.readInt();
					
			        this.RACK_DISPOSALS = dis.readInt();
					
			        this.CLOSING_PHYSICAL = dis.readInt();
					
			        this.MANUAL_CLOSING_PHYSICAL = dis.readInt();
					
			        this.GAIN_LOSS = dis.readInt();
					
			        this.RACK_FRAC_RECEIPTS = dis.readInt();
					
			        this.RACK_FRAC_DISPOSALS = dis.readInt();
					
			        this.BULK_FRAC_TRANSFERS_IN = dis.readInt();
					
			        this.BULK_FRAC_TRANSFERS_OUT = dis.readInt();
					
			        this.ADD_BULK_RECEIPTS = dis.readInt();
					
			        this.ADD_RACK_RECEIPTS = dis.readInt();
					
			        this.ADD_TRANSFERS_IN = dis.readInt();
					
			        this.ADD_BULK_DISPOSALS = dis.readInt();
					
			        this.ADD_RACK_DISPOSALS = dis.readInt();
					
			        this.ADD_TRANSFERS_OUT = dis.readInt();
					
			        this.ADD_GAIN_LOSS = dis.readInt();
					
			        this.PIPE_FILL = dis.readInt();
					
			        this.OPENING_PHYSICAL_GROSS_QTY = dis.readInt();
					
			        this.CLOSING_PHYSICAL_GROSS_QTY = dis.readInt();
					
			        this.OPENING_TEMPERATURE = dis.readDouble();
					
			        this.CLOSING_TEMPERATURE = dis.readDouble();
					
			        this.OPENING_DENSITY = dis.readDouble();
					
			        this.CLOSING_DENSITY = dis.readDouble();
					
			        this.OPENING_BSW_QTY = dis.readInt();
					
			        this.CLOSING_BSW_QTY = dis.readInt();
					
					this.OPENING_LEVEL = readString(dis);
					
					this.CLOSING_LEVEL = readString(dis);
					
			        this.OPENING_OBSERVED_DENSITY = dis.readDouble();
					
			        this.CLOSING_OBSERVED_DENSITY = dis.readDouble();
					
					this.OPENING_BSW_LEVEL = readString(dis);
					
					this.CLOSING_BSW_LEVEL = readString(dis);
					
			        this.BULK_FRAC_DISPOSALS = dis.readInt();
					
			        this.BULK_FRAC_RECEIPTS = dis.readInt();
					
			        this.VIRTUAL_TANK = dis.readInt();
					
			        this.OPENING_COE = dis.readDouble();
					
			        this.CLOSING_COE = dis.readDouble();
					
			        this.OPENING_LINE_SEGMENT_NSV = dis.readInt();
					
			        this.CLOSING_LINE_SEGMENT_NSV = dis.readInt();
					
			        this.OPENING_TOV = dis.readInt();
					
			        this.CLOSING_TOV = dis.readInt();
					
			        this.OPENING_GOV = dis.readInt();
					
			        this.CLOSING_GOV = dis.readInt();
					
			        this.OPENING_GSV = dis.readInt();
					
			        this.CLOSING_GSV = dis.readInt();
					
			        this.OPENING_TCV = dis.readInt();
					
			        this.CLOSING_TCV = dis.readInt();
					
			        this.OPENING_CTL = dis.readDouble();
					
			        this.CLOSING_CTL = dis.readDouble();
					
			        this.OPENING_SHELL_CORRECTION_FACTO = dis.readDouble();
					
			        this.CLOSING_SHELL_CORRECTION_FACTO = dis.readDouble();
					
			        this.OPENING_FLOATING_ROOF_ADJUSTME = dis.readInt();
					
			        this.CLOSING_FLOATING_ROOF_ADJUSTME = dis.readInt();
					
			        this.OPENING_AMBIENT_TEMPERATURE = dis.readDouble();
					
			        this.CLOSING_AMBIENT_TEMPERATURE = dis.readDouble();
					
			        this.OPENING_SUSPENDED_BSW_PERCENT = dis.readDouble();
					
			        this.CLOSING_SUSPENDED_BSW_PERCENT = dis.readDouble();
					
					this.OPENING_GAUGER_INITIALS = readString(dis);
					
					this.CLOSING_GAUGER_INITIALS = readString(dis);
					
					this.OPENING_GAUGE_TIMESTAMP = readDate(dis);
					
					this.CLOSING_GAUGE_TIMESTAMP = readDate(dis);
					
			        this.OPENING_PRODUCT_STRAP_TYPE = dis.readInt();
					
			        this.CLOSING_PRODUCT_STRAP_TYPE = dis.readInt();
					
			        this.OPENING_BSW_STRAP_TYPE = dis.readInt();
					
			        this.CLOSING_BSW_STRAP_TYPE = dis.readInt();
					
			        this.OPENING_GSW = dis.readInt();
					
			        this.CLOSING_GSW = dis.readInt();
					
			        this.OPENING_NSW = dis.readInt();
					
			        this.CLOSING_NSW = dis.readInt();
					
			        this.OPENING_WCF = dis.readDouble();
					
			        this.CLOSING_WCF = dis.readDouble();
					
			        this.OPENING_LINE_SEGMENT_NSW = dis.readInt();
					
			        this.CLOSING_LINE_SEGMENT_NSW = dis.readInt();
					
			        this.OPENING_NSV = dis.readInt();
					
			        this.CLOSING_NSV = dis.readInt();
					
			        this.OPENING_XCTN_GROSS_QTY = dis.readInt();
					
			        this.CLOSING_XCTN_GROSS_QTY = dis.readInt();
					
			        this.OPENING_XCTN_FRAC_GROSS_QTY = dis.readInt();
					
			        this.CLOSING_XCTN_FRAC_GROSS_QTY = dis.readInt();
					
			        this.OPENING_XCTN_NET_QTY = dis.readInt();
					
			        this.CLOSING_XCTN_NET_QTY = dis.readInt();
					
			        this.OPENING_XCTN_FRAC_NET_QTY = dis.readInt();
					
			        this.CLOSING_XCTN_FRAC_NET_QTY = dis.readInt();
					
			        this.OPENING_CALCULATION_POINT = dis.readInt();
					
			        this.CLOSING_CALCULATION_POINT = dis.readInt();
					
			        this.MANUAL_OPENING_PHYSICAL = dis.readInt();
					
					this.OPENING_API_CODE = readString(dis);
					
					this.CLOSING_API_CODE = readString(dis);
					
			        this.OPENING_WEIGHT_IN_AIR = dis.readInt();
					
			        this.CLOSING_WEIGHT_IN_AIR = dis.readInt();
					
			        this.OPENING_XCTN_WEIGHT = dis.readInt();
					
			        this.OPENING_XCTN_FRAC_WEIGHT = dis.readInt();
					
			        this.CLOSING_XCTN_WEIGHT = dis.readInt();
					
			        this.CLOSING_XCTN_FRAC_WEIGHT = dis.readInt();
					
			        this.OPENING_VAPOR_CORRECT_METHOD = dis.readInt();
					
			        this.CLOSING_VAPOR_CORRECT_METHOD = dis.readInt();
					
			        this.OPENING_VAPOR_TEMPERATURE = dis.readDouble();
					
			        this.CLOSING_VAPOR_TEMPERATURE = dis.readDouble();
					
			        this.OPENING_VAPOR_LIQUID_VOL_RATIO = dis.readDouble();
					
			        this.CLOSING_VAPOR_LIQUID_VOL_RATIO = dis.readDouble();
					
			        this.INVENTORY_QUANTITY_TYPE = dis.readInt();
					
			        this.OPENING_PRESSURE = dis.readDouble();
					
			        this.CLOSING_PRESSURE = dis.readDouble();
					
			        this.OPENING_XCTN_WEIGHT_IN_VAC = dis.readInt();
					
			        this.OPENING_XCTN_FRAC_WGT_IN_VAC = dis.readInt();
					
			        this.CLOSING_XCTN_WEIGHT_IN_VAC = dis.readInt();
					
			        this.CLOSING_XCTN_FRAC_WGT_IN_VAC = dis.readInt();
					
						this.MAJORITY_SHAREHOLDER = readInteger(dis);
					
			        this.OPENING_INVENTORY_ENABLE = dis.readInt();
					
			        this.CLOSING_INVENTORY_ENABLE = dis.readInt();
					
			        this.OPENING_LEVEL_ORIGIN = dis.readInt();
					
			        this.CLOSING_LEVEL_ORIGIN = dis.readInt();
					
			        this.OPENING_TOV_ORIGIN = dis.readInt();
					
			        this.CLOSING_TOV_ORIGIN = dis.readInt();
					
			        this.OPENING_TEMPERATURE_ORIGIN = dis.readInt();
					
			        this.CLOSING_TEMPERATURE_ORIGIN = dis.readInt();
					
			        this.OPENING_DENSITY_ORIGIN = dis.readInt();
					
			        this.CLOSING_DENSITY_ORIGIN = dis.readInt();
					
			        this.OPENING_NSV_ORIGIN = dis.readInt();
					
			        this.CLOSING_NSV_ORIGIN = dis.readInt();
					
			        this.OPENING_VAPOR_TEMP_ORIGIN = dis.readInt();
					
			        this.CLOSING_VAPOR_TEMP_ORIGIN = dis.readInt();
					
			        this.OPENING_PRESSURE_ORIGIN = dis.readInt();
					
			        this.CLOSING_PRESSURE_ORIGIN = dis.readInt();
					
			        this.OPENING_FREE_WATER_LVL_ORIGIN = dis.readInt();
					
			        this.CLOSING_FREE_WATER_LVL_ORIGIN = dis.readInt();
					
			        this.OPENING_WATER_QTY_ORIGIN = dis.readInt();
					
			        this.CLOSING_WATER_QTY_ORIGIN = dis.readInt();
					
						this.COMPARTMENT_OWNER_ID = readInteger(dis);
					
					this.COMPARTMENT_CONTAINER_CODE = readString(dis);
					
						this.COMPARTMENT_CONTAINER_TYPE = readInteger(dis);
					
						this.COMPARTMENT_NUMBER = readInteger(dis);
					
			        this.COMPARTMENT_VISIT_NUMBER = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.TERMINAL_PRODUCT_NUMBER);
					
					// String
				
						writeString(this.FOLIO_NUMBER,dos);
					
					// String
				
						writeString(this.TANK_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.GAIN_LOSS_ID);
					
					// String
				
						writeString(this.TANK_GROUP,dos);
					
					// String
				
						writeString(this.PRODUCT_GROUP_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.OPENING_PHYSICAL);
					
					// int
				
		            	dos.writeInt(this.BULK_RECEIPTS);
					
					// int
				
		            	dos.writeInt(this.BULK_TRANSFERS_IN);
					
					// int
				
		            	dos.writeInt(this.BULK_DISPOSALS);
					
					// int
				
		            	dos.writeInt(this.BULK_TRANSFERS_OUT);
					
					// int
				
		            	dos.writeInt(this.RACK_RECEIPTS);
					
					// int
				
		            	dos.writeInt(this.RACK_DISPOSALS);
					
					// int
				
		            	dos.writeInt(this.CLOSING_PHYSICAL);
					
					// int
				
		            	dos.writeInt(this.MANUAL_CLOSING_PHYSICAL);
					
					// int
				
		            	dos.writeInt(this.GAIN_LOSS);
					
					// int
				
		            	dos.writeInt(this.RACK_FRAC_RECEIPTS);
					
					// int
				
		            	dos.writeInt(this.RACK_FRAC_DISPOSALS);
					
					// int
				
		            	dos.writeInt(this.BULK_FRAC_TRANSFERS_IN);
					
					// int
				
		            	dos.writeInt(this.BULK_FRAC_TRANSFERS_OUT);
					
					// int
				
		            	dos.writeInt(this.ADD_BULK_RECEIPTS);
					
					// int
				
		            	dos.writeInt(this.ADD_RACK_RECEIPTS);
					
					// int
				
		            	dos.writeInt(this.ADD_TRANSFERS_IN);
					
					// int
				
		            	dos.writeInt(this.ADD_BULK_DISPOSALS);
					
					// int
				
		            	dos.writeInt(this.ADD_RACK_DISPOSALS);
					
					// int
				
		            	dos.writeInt(this.ADD_TRANSFERS_OUT);
					
					// int
				
		            	dos.writeInt(this.ADD_GAIN_LOSS);
					
					// int
				
		            	dos.writeInt(this.PIPE_FILL);
					
					// int
				
		            	dos.writeInt(this.OPENING_PHYSICAL_GROSS_QTY);
					
					// int
				
		            	dos.writeInt(this.CLOSING_PHYSICAL_GROSS_QTY);
					
					// double
				
		            	dos.writeDouble(this.OPENING_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.OPENING_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_DENSITY);
					
					// int
				
		            	dos.writeInt(this.OPENING_BSW_QTY);
					
					// int
				
		            	dos.writeInt(this.CLOSING_BSW_QTY);
					
					// String
				
						writeString(this.OPENING_LEVEL,dos);
					
					// String
				
						writeString(this.CLOSING_LEVEL,dos);
					
					// double
				
		            	dos.writeDouble(this.OPENING_OBSERVED_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_OBSERVED_DENSITY);
					
					// String
				
						writeString(this.OPENING_BSW_LEVEL,dos);
					
					// String
				
						writeString(this.CLOSING_BSW_LEVEL,dos);
					
					// int
				
		            	dos.writeInt(this.BULK_FRAC_DISPOSALS);
					
					// int
				
		            	dos.writeInt(this.BULK_FRAC_RECEIPTS);
					
					// int
				
		            	dos.writeInt(this.VIRTUAL_TANK);
					
					// double
				
		            	dos.writeDouble(this.OPENING_COE);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_COE);
					
					// int
				
		            	dos.writeInt(this.OPENING_LINE_SEGMENT_NSV);
					
					// int
				
		            	dos.writeInt(this.CLOSING_LINE_SEGMENT_NSV);
					
					// int
				
		            	dos.writeInt(this.OPENING_TOV);
					
					// int
				
		            	dos.writeInt(this.CLOSING_TOV);
					
					// int
				
		            	dos.writeInt(this.OPENING_GOV);
					
					// int
				
		            	dos.writeInt(this.CLOSING_GOV);
					
					// int
				
		            	dos.writeInt(this.OPENING_GSV);
					
					// int
				
		            	dos.writeInt(this.CLOSING_GSV);
					
					// int
				
		            	dos.writeInt(this.OPENING_TCV);
					
					// int
				
		            	dos.writeInt(this.CLOSING_TCV);
					
					// double
				
		            	dos.writeDouble(this.OPENING_CTL);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_CTL);
					
					// double
				
		            	dos.writeDouble(this.OPENING_SHELL_CORRECTION_FACTO);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_SHELL_CORRECTION_FACTO);
					
					// int
				
		            	dos.writeInt(this.OPENING_FLOATING_ROOF_ADJUSTME);
					
					// int
				
		            	dos.writeInt(this.CLOSING_FLOATING_ROOF_ADJUSTME);
					
					// double
				
		            	dos.writeDouble(this.OPENING_AMBIENT_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_AMBIENT_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.OPENING_SUSPENDED_BSW_PERCENT);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_SUSPENDED_BSW_PERCENT);
					
					// String
				
						writeString(this.OPENING_GAUGER_INITIALS,dos);
					
					// String
				
						writeString(this.CLOSING_GAUGER_INITIALS,dos);
					
					// java.util.Date
				
						writeDate(this.OPENING_GAUGE_TIMESTAMP,dos);
					
					// java.util.Date
				
						writeDate(this.CLOSING_GAUGE_TIMESTAMP,dos);
					
					// int
				
		            	dos.writeInt(this.OPENING_PRODUCT_STRAP_TYPE);
					
					// int
				
		            	dos.writeInt(this.CLOSING_PRODUCT_STRAP_TYPE);
					
					// int
				
		            	dos.writeInt(this.OPENING_BSW_STRAP_TYPE);
					
					// int
				
		            	dos.writeInt(this.CLOSING_BSW_STRAP_TYPE);
					
					// int
				
		            	dos.writeInt(this.OPENING_GSW);
					
					// int
				
		            	dos.writeInt(this.CLOSING_GSW);
					
					// int
				
		            	dos.writeInt(this.OPENING_NSW);
					
					// int
				
		            	dos.writeInt(this.CLOSING_NSW);
					
					// double
				
		            	dos.writeDouble(this.OPENING_WCF);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_WCF);
					
					// int
				
		            	dos.writeInt(this.OPENING_LINE_SEGMENT_NSW);
					
					// int
				
		            	dos.writeInt(this.CLOSING_LINE_SEGMENT_NSW);
					
					// int
				
		            	dos.writeInt(this.OPENING_NSV);
					
					// int
				
		            	dos.writeInt(this.CLOSING_NSV);
					
					// int
				
		            	dos.writeInt(this.OPENING_XCTN_GROSS_QTY);
					
					// int
				
		            	dos.writeInt(this.CLOSING_XCTN_GROSS_QTY);
					
					// int
				
		            	dos.writeInt(this.OPENING_XCTN_FRAC_GROSS_QTY);
					
					// int
				
		            	dos.writeInt(this.CLOSING_XCTN_FRAC_GROSS_QTY);
					
					// int
				
		            	dos.writeInt(this.OPENING_XCTN_NET_QTY);
					
					// int
				
		            	dos.writeInt(this.CLOSING_XCTN_NET_QTY);
					
					// int
				
		            	dos.writeInt(this.OPENING_XCTN_FRAC_NET_QTY);
					
					// int
				
		            	dos.writeInt(this.CLOSING_XCTN_FRAC_NET_QTY);
					
					// int
				
		            	dos.writeInt(this.OPENING_CALCULATION_POINT);
					
					// int
				
		            	dos.writeInt(this.CLOSING_CALCULATION_POINT);
					
					// int
				
		            	dos.writeInt(this.MANUAL_OPENING_PHYSICAL);
					
					// String
				
						writeString(this.OPENING_API_CODE,dos);
					
					// String
				
						writeString(this.CLOSING_API_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.OPENING_WEIGHT_IN_AIR);
					
					// int
				
		            	dos.writeInt(this.CLOSING_WEIGHT_IN_AIR);
					
					// int
				
		            	dos.writeInt(this.OPENING_XCTN_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.OPENING_XCTN_FRAC_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.CLOSING_XCTN_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.CLOSING_XCTN_FRAC_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.OPENING_VAPOR_CORRECT_METHOD);
					
					// int
				
		            	dos.writeInt(this.CLOSING_VAPOR_CORRECT_METHOD);
					
					// double
				
		            	dos.writeDouble(this.OPENING_VAPOR_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_VAPOR_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.OPENING_VAPOR_LIQUID_VOL_RATIO);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_VAPOR_LIQUID_VOL_RATIO);
					
					// int
				
		            	dos.writeInt(this.INVENTORY_QUANTITY_TYPE);
					
					// double
				
		            	dos.writeDouble(this.OPENING_PRESSURE);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_PRESSURE);
					
					// int
				
		            	dos.writeInt(this.OPENING_XCTN_WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.OPENING_XCTN_FRAC_WGT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.CLOSING_XCTN_WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.CLOSING_XCTN_FRAC_WGT_IN_VAC);
					
					// Integer
				
						writeInteger(this.MAJORITY_SHAREHOLDER,dos);
					
					// int
				
		            	dos.writeInt(this.OPENING_INVENTORY_ENABLE);
					
					// int
				
		            	dos.writeInt(this.CLOSING_INVENTORY_ENABLE);
					
					// int
				
		            	dos.writeInt(this.OPENING_LEVEL_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.CLOSING_LEVEL_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.OPENING_TOV_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.CLOSING_TOV_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.OPENING_TEMPERATURE_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.CLOSING_TEMPERATURE_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.OPENING_DENSITY_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.CLOSING_DENSITY_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.OPENING_NSV_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.CLOSING_NSV_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.OPENING_VAPOR_TEMP_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.CLOSING_VAPOR_TEMP_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.OPENING_PRESSURE_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.CLOSING_PRESSURE_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.OPENING_FREE_WATER_LVL_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.CLOSING_FREE_WATER_LVL_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.OPENING_WATER_QTY_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.CLOSING_WATER_QTY_ORIGIN);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_OWNER_ID,dos);
					
					// String
				
						writeString(this.COMPARTMENT_CONTAINER_CODE,dos);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_CONTAINER_TYPE,dos);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.COMPARTMENT_VISIT_NUMBER);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.TERMINAL_PRODUCT_NUMBER);
					
					// String
				
						writeString(this.FOLIO_NUMBER,dos);
					
					// String
				
						writeString(this.TANK_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.GAIN_LOSS_ID);
					
					// String
				
						writeString(this.TANK_GROUP,dos);
					
					// String
				
						writeString(this.PRODUCT_GROUP_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.OPENING_PHYSICAL);
					
					// int
				
		            	dos.writeInt(this.BULK_RECEIPTS);
					
					// int
				
		            	dos.writeInt(this.BULK_TRANSFERS_IN);
					
					// int
				
		            	dos.writeInt(this.BULK_DISPOSALS);
					
					// int
				
		            	dos.writeInt(this.BULK_TRANSFERS_OUT);
					
					// int
				
		            	dos.writeInt(this.RACK_RECEIPTS);
					
					// int
				
		            	dos.writeInt(this.RACK_DISPOSALS);
					
					// int
				
		            	dos.writeInt(this.CLOSING_PHYSICAL);
					
					// int
				
		            	dos.writeInt(this.MANUAL_CLOSING_PHYSICAL);
					
					// int
				
		            	dos.writeInt(this.GAIN_LOSS);
					
					// int
				
		            	dos.writeInt(this.RACK_FRAC_RECEIPTS);
					
					// int
				
		            	dos.writeInt(this.RACK_FRAC_DISPOSALS);
					
					// int
				
		            	dos.writeInt(this.BULK_FRAC_TRANSFERS_IN);
					
					// int
				
		            	dos.writeInt(this.BULK_FRAC_TRANSFERS_OUT);
					
					// int
				
		            	dos.writeInt(this.ADD_BULK_RECEIPTS);
					
					// int
				
		            	dos.writeInt(this.ADD_RACK_RECEIPTS);
					
					// int
				
		            	dos.writeInt(this.ADD_TRANSFERS_IN);
					
					// int
				
		            	dos.writeInt(this.ADD_BULK_DISPOSALS);
					
					// int
				
		            	dos.writeInt(this.ADD_RACK_DISPOSALS);
					
					// int
				
		            	dos.writeInt(this.ADD_TRANSFERS_OUT);
					
					// int
				
		            	dos.writeInt(this.ADD_GAIN_LOSS);
					
					// int
				
		            	dos.writeInt(this.PIPE_FILL);
					
					// int
				
		            	dos.writeInt(this.OPENING_PHYSICAL_GROSS_QTY);
					
					// int
				
		            	dos.writeInt(this.CLOSING_PHYSICAL_GROSS_QTY);
					
					// double
				
		            	dos.writeDouble(this.OPENING_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.OPENING_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_DENSITY);
					
					// int
				
		            	dos.writeInt(this.OPENING_BSW_QTY);
					
					// int
				
		            	dos.writeInt(this.CLOSING_BSW_QTY);
					
					// String
				
						writeString(this.OPENING_LEVEL,dos);
					
					// String
				
						writeString(this.CLOSING_LEVEL,dos);
					
					// double
				
		            	dos.writeDouble(this.OPENING_OBSERVED_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_OBSERVED_DENSITY);
					
					// String
				
						writeString(this.OPENING_BSW_LEVEL,dos);
					
					// String
				
						writeString(this.CLOSING_BSW_LEVEL,dos);
					
					// int
				
		            	dos.writeInt(this.BULK_FRAC_DISPOSALS);
					
					// int
				
		            	dos.writeInt(this.BULK_FRAC_RECEIPTS);
					
					// int
				
		            	dos.writeInt(this.VIRTUAL_TANK);
					
					// double
				
		            	dos.writeDouble(this.OPENING_COE);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_COE);
					
					// int
				
		            	dos.writeInt(this.OPENING_LINE_SEGMENT_NSV);
					
					// int
				
		            	dos.writeInt(this.CLOSING_LINE_SEGMENT_NSV);
					
					// int
				
		            	dos.writeInt(this.OPENING_TOV);
					
					// int
				
		            	dos.writeInt(this.CLOSING_TOV);
					
					// int
				
		            	dos.writeInt(this.OPENING_GOV);
					
					// int
				
		            	dos.writeInt(this.CLOSING_GOV);
					
					// int
				
		            	dos.writeInt(this.OPENING_GSV);
					
					// int
				
		            	dos.writeInt(this.CLOSING_GSV);
					
					// int
				
		            	dos.writeInt(this.OPENING_TCV);
					
					// int
				
		            	dos.writeInt(this.CLOSING_TCV);
					
					// double
				
		            	dos.writeDouble(this.OPENING_CTL);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_CTL);
					
					// double
				
		            	dos.writeDouble(this.OPENING_SHELL_CORRECTION_FACTO);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_SHELL_CORRECTION_FACTO);
					
					// int
				
		            	dos.writeInt(this.OPENING_FLOATING_ROOF_ADJUSTME);
					
					// int
				
		            	dos.writeInt(this.CLOSING_FLOATING_ROOF_ADJUSTME);
					
					// double
				
		            	dos.writeDouble(this.OPENING_AMBIENT_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_AMBIENT_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.OPENING_SUSPENDED_BSW_PERCENT);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_SUSPENDED_BSW_PERCENT);
					
					// String
				
						writeString(this.OPENING_GAUGER_INITIALS,dos);
					
					// String
				
						writeString(this.CLOSING_GAUGER_INITIALS,dos);
					
					// java.util.Date
				
						writeDate(this.OPENING_GAUGE_TIMESTAMP,dos);
					
					// java.util.Date
				
						writeDate(this.CLOSING_GAUGE_TIMESTAMP,dos);
					
					// int
				
		            	dos.writeInt(this.OPENING_PRODUCT_STRAP_TYPE);
					
					// int
				
		            	dos.writeInt(this.CLOSING_PRODUCT_STRAP_TYPE);
					
					// int
				
		            	dos.writeInt(this.OPENING_BSW_STRAP_TYPE);
					
					// int
				
		            	dos.writeInt(this.CLOSING_BSW_STRAP_TYPE);
					
					// int
				
		            	dos.writeInt(this.OPENING_GSW);
					
					// int
				
		            	dos.writeInt(this.CLOSING_GSW);
					
					// int
				
		            	dos.writeInt(this.OPENING_NSW);
					
					// int
				
		            	dos.writeInt(this.CLOSING_NSW);
					
					// double
				
		            	dos.writeDouble(this.OPENING_WCF);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_WCF);
					
					// int
				
		            	dos.writeInt(this.OPENING_LINE_SEGMENT_NSW);
					
					// int
				
		            	dos.writeInt(this.CLOSING_LINE_SEGMENT_NSW);
					
					// int
				
		            	dos.writeInt(this.OPENING_NSV);
					
					// int
				
		            	dos.writeInt(this.CLOSING_NSV);
					
					// int
				
		            	dos.writeInt(this.OPENING_XCTN_GROSS_QTY);
					
					// int
				
		            	dos.writeInt(this.CLOSING_XCTN_GROSS_QTY);
					
					// int
				
		            	dos.writeInt(this.OPENING_XCTN_FRAC_GROSS_QTY);
					
					// int
				
		            	dos.writeInt(this.CLOSING_XCTN_FRAC_GROSS_QTY);
					
					// int
				
		            	dos.writeInt(this.OPENING_XCTN_NET_QTY);
					
					// int
				
		            	dos.writeInt(this.CLOSING_XCTN_NET_QTY);
					
					// int
				
		            	dos.writeInt(this.OPENING_XCTN_FRAC_NET_QTY);
					
					// int
				
		            	dos.writeInt(this.CLOSING_XCTN_FRAC_NET_QTY);
					
					// int
				
		            	dos.writeInt(this.OPENING_CALCULATION_POINT);
					
					// int
				
		            	dos.writeInt(this.CLOSING_CALCULATION_POINT);
					
					// int
				
		            	dos.writeInt(this.MANUAL_OPENING_PHYSICAL);
					
					// String
				
						writeString(this.OPENING_API_CODE,dos);
					
					// String
				
						writeString(this.CLOSING_API_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.OPENING_WEIGHT_IN_AIR);
					
					// int
				
		            	dos.writeInt(this.CLOSING_WEIGHT_IN_AIR);
					
					// int
				
		            	dos.writeInt(this.OPENING_XCTN_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.OPENING_XCTN_FRAC_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.CLOSING_XCTN_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.CLOSING_XCTN_FRAC_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.OPENING_VAPOR_CORRECT_METHOD);
					
					// int
				
		            	dos.writeInt(this.CLOSING_VAPOR_CORRECT_METHOD);
					
					// double
				
		            	dos.writeDouble(this.OPENING_VAPOR_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_VAPOR_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.OPENING_VAPOR_LIQUID_VOL_RATIO);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_VAPOR_LIQUID_VOL_RATIO);
					
					// int
				
		            	dos.writeInt(this.INVENTORY_QUANTITY_TYPE);
					
					// double
				
		            	dos.writeDouble(this.OPENING_PRESSURE);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_PRESSURE);
					
					// int
				
		            	dos.writeInt(this.OPENING_XCTN_WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.OPENING_XCTN_FRAC_WGT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.CLOSING_XCTN_WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.CLOSING_XCTN_FRAC_WGT_IN_VAC);
					
					// Integer
				
						writeInteger(this.MAJORITY_SHAREHOLDER,dos);
					
					// int
				
		            	dos.writeInt(this.OPENING_INVENTORY_ENABLE);
					
					// int
				
		            	dos.writeInt(this.CLOSING_INVENTORY_ENABLE);
					
					// int
				
		            	dos.writeInt(this.OPENING_LEVEL_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.CLOSING_LEVEL_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.OPENING_TOV_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.CLOSING_TOV_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.OPENING_TEMPERATURE_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.CLOSING_TEMPERATURE_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.OPENING_DENSITY_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.CLOSING_DENSITY_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.OPENING_NSV_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.CLOSING_NSV_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.OPENING_VAPOR_TEMP_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.CLOSING_VAPOR_TEMP_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.OPENING_PRESSURE_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.CLOSING_PRESSURE_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.OPENING_FREE_WATER_LVL_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.CLOSING_FREE_WATER_LVL_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.OPENING_WATER_QTY_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.CLOSING_WATER_QTY_ORIGIN);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_OWNER_ID,dos);
					
					// String
				
						writeString(this.COMPARTMENT_CONTAINER_CODE,dos);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_CONTAINER_TYPE,dos);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.COMPARTMENT_VISIT_NUMBER);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("TERMINAL_PRODUCT_NUMBER="+String.valueOf(TERMINAL_PRODUCT_NUMBER));
		sb.append(",FOLIO_NUMBER="+FOLIO_NUMBER);
		sb.append(",TANK_CODE="+TANK_CODE);
		sb.append(",GAIN_LOSS_ID="+String.valueOf(GAIN_LOSS_ID));
		sb.append(",TANK_GROUP="+TANK_GROUP);
		sb.append(",PRODUCT_GROUP_CODE="+PRODUCT_GROUP_CODE);
		sb.append(",OPENING_PHYSICAL="+String.valueOf(OPENING_PHYSICAL));
		sb.append(",BULK_RECEIPTS="+String.valueOf(BULK_RECEIPTS));
		sb.append(",BULK_TRANSFERS_IN="+String.valueOf(BULK_TRANSFERS_IN));
		sb.append(",BULK_DISPOSALS="+String.valueOf(BULK_DISPOSALS));
		sb.append(",BULK_TRANSFERS_OUT="+String.valueOf(BULK_TRANSFERS_OUT));
		sb.append(",RACK_RECEIPTS="+String.valueOf(RACK_RECEIPTS));
		sb.append(",RACK_DISPOSALS="+String.valueOf(RACK_DISPOSALS));
		sb.append(",CLOSING_PHYSICAL="+String.valueOf(CLOSING_PHYSICAL));
		sb.append(",MANUAL_CLOSING_PHYSICAL="+String.valueOf(MANUAL_CLOSING_PHYSICAL));
		sb.append(",GAIN_LOSS="+String.valueOf(GAIN_LOSS));
		sb.append(",RACK_FRAC_RECEIPTS="+String.valueOf(RACK_FRAC_RECEIPTS));
		sb.append(",RACK_FRAC_DISPOSALS="+String.valueOf(RACK_FRAC_DISPOSALS));
		sb.append(",BULK_FRAC_TRANSFERS_IN="+String.valueOf(BULK_FRAC_TRANSFERS_IN));
		sb.append(",BULK_FRAC_TRANSFERS_OUT="+String.valueOf(BULK_FRAC_TRANSFERS_OUT));
		sb.append(",ADD_BULK_RECEIPTS="+String.valueOf(ADD_BULK_RECEIPTS));
		sb.append(",ADD_RACK_RECEIPTS="+String.valueOf(ADD_RACK_RECEIPTS));
		sb.append(",ADD_TRANSFERS_IN="+String.valueOf(ADD_TRANSFERS_IN));
		sb.append(",ADD_BULK_DISPOSALS="+String.valueOf(ADD_BULK_DISPOSALS));
		sb.append(",ADD_RACK_DISPOSALS="+String.valueOf(ADD_RACK_DISPOSALS));
		sb.append(",ADD_TRANSFERS_OUT="+String.valueOf(ADD_TRANSFERS_OUT));
		sb.append(",ADD_GAIN_LOSS="+String.valueOf(ADD_GAIN_LOSS));
		sb.append(",PIPE_FILL="+String.valueOf(PIPE_FILL));
		sb.append(",OPENING_PHYSICAL_GROSS_QTY="+String.valueOf(OPENING_PHYSICAL_GROSS_QTY));
		sb.append(",CLOSING_PHYSICAL_GROSS_QTY="+String.valueOf(CLOSING_PHYSICAL_GROSS_QTY));
		sb.append(",OPENING_TEMPERATURE="+String.valueOf(OPENING_TEMPERATURE));
		sb.append(",CLOSING_TEMPERATURE="+String.valueOf(CLOSING_TEMPERATURE));
		sb.append(",OPENING_DENSITY="+String.valueOf(OPENING_DENSITY));
		sb.append(",CLOSING_DENSITY="+String.valueOf(CLOSING_DENSITY));
		sb.append(",OPENING_BSW_QTY="+String.valueOf(OPENING_BSW_QTY));
		sb.append(",CLOSING_BSW_QTY="+String.valueOf(CLOSING_BSW_QTY));
		sb.append(",OPENING_LEVEL="+OPENING_LEVEL);
		sb.append(",CLOSING_LEVEL="+CLOSING_LEVEL);
		sb.append(",OPENING_OBSERVED_DENSITY="+String.valueOf(OPENING_OBSERVED_DENSITY));
		sb.append(",CLOSING_OBSERVED_DENSITY="+String.valueOf(CLOSING_OBSERVED_DENSITY));
		sb.append(",OPENING_BSW_LEVEL="+OPENING_BSW_LEVEL);
		sb.append(",CLOSING_BSW_LEVEL="+CLOSING_BSW_LEVEL);
		sb.append(",BULK_FRAC_DISPOSALS="+String.valueOf(BULK_FRAC_DISPOSALS));
		sb.append(",BULK_FRAC_RECEIPTS="+String.valueOf(BULK_FRAC_RECEIPTS));
		sb.append(",VIRTUAL_TANK="+String.valueOf(VIRTUAL_TANK));
		sb.append(",OPENING_COE="+String.valueOf(OPENING_COE));
		sb.append(",CLOSING_COE="+String.valueOf(CLOSING_COE));
		sb.append(",OPENING_LINE_SEGMENT_NSV="+String.valueOf(OPENING_LINE_SEGMENT_NSV));
		sb.append(",CLOSING_LINE_SEGMENT_NSV="+String.valueOf(CLOSING_LINE_SEGMENT_NSV));
		sb.append(",OPENING_TOV="+String.valueOf(OPENING_TOV));
		sb.append(",CLOSING_TOV="+String.valueOf(CLOSING_TOV));
		sb.append(",OPENING_GOV="+String.valueOf(OPENING_GOV));
		sb.append(",CLOSING_GOV="+String.valueOf(CLOSING_GOV));
		sb.append(",OPENING_GSV="+String.valueOf(OPENING_GSV));
		sb.append(",CLOSING_GSV="+String.valueOf(CLOSING_GSV));
		sb.append(",OPENING_TCV="+String.valueOf(OPENING_TCV));
		sb.append(",CLOSING_TCV="+String.valueOf(CLOSING_TCV));
		sb.append(",OPENING_CTL="+String.valueOf(OPENING_CTL));
		sb.append(",CLOSING_CTL="+String.valueOf(CLOSING_CTL));
		sb.append(",OPENING_SHELL_CORRECTION_FACTO="+String.valueOf(OPENING_SHELL_CORRECTION_FACTO));
		sb.append(",CLOSING_SHELL_CORRECTION_FACTO="+String.valueOf(CLOSING_SHELL_CORRECTION_FACTO));
		sb.append(",OPENING_FLOATING_ROOF_ADJUSTME="+String.valueOf(OPENING_FLOATING_ROOF_ADJUSTME));
		sb.append(",CLOSING_FLOATING_ROOF_ADJUSTME="+String.valueOf(CLOSING_FLOATING_ROOF_ADJUSTME));
		sb.append(",OPENING_AMBIENT_TEMPERATURE="+String.valueOf(OPENING_AMBIENT_TEMPERATURE));
		sb.append(",CLOSING_AMBIENT_TEMPERATURE="+String.valueOf(CLOSING_AMBIENT_TEMPERATURE));
		sb.append(",OPENING_SUSPENDED_BSW_PERCENT="+String.valueOf(OPENING_SUSPENDED_BSW_PERCENT));
		sb.append(",CLOSING_SUSPENDED_BSW_PERCENT="+String.valueOf(CLOSING_SUSPENDED_BSW_PERCENT));
		sb.append(",OPENING_GAUGER_INITIALS="+OPENING_GAUGER_INITIALS);
		sb.append(",CLOSING_GAUGER_INITIALS="+CLOSING_GAUGER_INITIALS);
		sb.append(",OPENING_GAUGE_TIMESTAMP="+String.valueOf(OPENING_GAUGE_TIMESTAMP));
		sb.append(",CLOSING_GAUGE_TIMESTAMP="+String.valueOf(CLOSING_GAUGE_TIMESTAMP));
		sb.append(",OPENING_PRODUCT_STRAP_TYPE="+String.valueOf(OPENING_PRODUCT_STRAP_TYPE));
		sb.append(",CLOSING_PRODUCT_STRAP_TYPE="+String.valueOf(CLOSING_PRODUCT_STRAP_TYPE));
		sb.append(",OPENING_BSW_STRAP_TYPE="+String.valueOf(OPENING_BSW_STRAP_TYPE));
		sb.append(",CLOSING_BSW_STRAP_TYPE="+String.valueOf(CLOSING_BSW_STRAP_TYPE));
		sb.append(",OPENING_GSW="+String.valueOf(OPENING_GSW));
		sb.append(",CLOSING_GSW="+String.valueOf(CLOSING_GSW));
		sb.append(",OPENING_NSW="+String.valueOf(OPENING_NSW));
		sb.append(",CLOSING_NSW="+String.valueOf(CLOSING_NSW));
		sb.append(",OPENING_WCF="+String.valueOf(OPENING_WCF));
		sb.append(",CLOSING_WCF="+String.valueOf(CLOSING_WCF));
		sb.append(",OPENING_LINE_SEGMENT_NSW="+String.valueOf(OPENING_LINE_SEGMENT_NSW));
		sb.append(",CLOSING_LINE_SEGMENT_NSW="+String.valueOf(CLOSING_LINE_SEGMENT_NSW));
		sb.append(",OPENING_NSV="+String.valueOf(OPENING_NSV));
		sb.append(",CLOSING_NSV="+String.valueOf(CLOSING_NSV));
		sb.append(",OPENING_XCTN_GROSS_QTY="+String.valueOf(OPENING_XCTN_GROSS_QTY));
		sb.append(",CLOSING_XCTN_GROSS_QTY="+String.valueOf(CLOSING_XCTN_GROSS_QTY));
		sb.append(",OPENING_XCTN_FRAC_GROSS_QTY="+String.valueOf(OPENING_XCTN_FRAC_GROSS_QTY));
		sb.append(",CLOSING_XCTN_FRAC_GROSS_QTY="+String.valueOf(CLOSING_XCTN_FRAC_GROSS_QTY));
		sb.append(",OPENING_XCTN_NET_QTY="+String.valueOf(OPENING_XCTN_NET_QTY));
		sb.append(",CLOSING_XCTN_NET_QTY="+String.valueOf(CLOSING_XCTN_NET_QTY));
		sb.append(",OPENING_XCTN_FRAC_NET_QTY="+String.valueOf(OPENING_XCTN_FRAC_NET_QTY));
		sb.append(",CLOSING_XCTN_FRAC_NET_QTY="+String.valueOf(CLOSING_XCTN_FRAC_NET_QTY));
		sb.append(",OPENING_CALCULATION_POINT="+String.valueOf(OPENING_CALCULATION_POINT));
		sb.append(",CLOSING_CALCULATION_POINT="+String.valueOf(CLOSING_CALCULATION_POINT));
		sb.append(",MANUAL_OPENING_PHYSICAL="+String.valueOf(MANUAL_OPENING_PHYSICAL));
		sb.append(",OPENING_API_CODE="+OPENING_API_CODE);
		sb.append(",CLOSING_API_CODE="+CLOSING_API_CODE);
		sb.append(",OPENING_WEIGHT_IN_AIR="+String.valueOf(OPENING_WEIGHT_IN_AIR));
		sb.append(",CLOSING_WEIGHT_IN_AIR="+String.valueOf(CLOSING_WEIGHT_IN_AIR));
		sb.append(",OPENING_XCTN_WEIGHT="+String.valueOf(OPENING_XCTN_WEIGHT));
		sb.append(",OPENING_XCTN_FRAC_WEIGHT="+String.valueOf(OPENING_XCTN_FRAC_WEIGHT));
		sb.append(",CLOSING_XCTN_WEIGHT="+String.valueOf(CLOSING_XCTN_WEIGHT));
		sb.append(",CLOSING_XCTN_FRAC_WEIGHT="+String.valueOf(CLOSING_XCTN_FRAC_WEIGHT));
		sb.append(",OPENING_VAPOR_CORRECT_METHOD="+String.valueOf(OPENING_VAPOR_CORRECT_METHOD));
		sb.append(",CLOSING_VAPOR_CORRECT_METHOD="+String.valueOf(CLOSING_VAPOR_CORRECT_METHOD));
		sb.append(",OPENING_VAPOR_TEMPERATURE="+String.valueOf(OPENING_VAPOR_TEMPERATURE));
		sb.append(",CLOSING_VAPOR_TEMPERATURE="+String.valueOf(CLOSING_VAPOR_TEMPERATURE));
		sb.append(",OPENING_VAPOR_LIQUID_VOL_RATIO="+String.valueOf(OPENING_VAPOR_LIQUID_VOL_RATIO));
		sb.append(",CLOSING_VAPOR_LIQUID_VOL_RATIO="+String.valueOf(CLOSING_VAPOR_LIQUID_VOL_RATIO));
		sb.append(",INVENTORY_QUANTITY_TYPE="+String.valueOf(INVENTORY_QUANTITY_TYPE));
		sb.append(",OPENING_PRESSURE="+String.valueOf(OPENING_PRESSURE));
		sb.append(",CLOSING_PRESSURE="+String.valueOf(CLOSING_PRESSURE));
		sb.append(",OPENING_XCTN_WEIGHT_IN_VAC="+String.valueOf(OPENING_XCTN_WEIGHT_IN_VAC));
		sb.append(",OPENING_XCTN_FRAC_WGT_IN_VAC="+String.valueOf(OPENING_XCTN_FRAC_WGT_IN_VAC));
		sb.append(",CLOSING_XCTN_WEIGHT_IN_VAC="+String.valueOf(CLOSING_XCTN_WEIGHT_IN_VAC));
		sb.append(",CLOSING_XCTN_FRAC_WGT_IN_VAC="+String.valueOf(CLOSING_XCTN_FRAC_WGT_IN_VAC));
		sb.append(",MAJORITY_SHAREHOLDER="+String.valueOf(MAJORITY_SHAREHOLDER));
		sb.append(",OPENING_INVENTORY_ENABLE="+String.valueOf(OPENING_INVENTORY_ENABLE));
		sb.append(",CLOSING_INVENTORY_ENABLE="+String.valueOf(CLOSING_INVENTORY_ENABLE));
		sb.append(",OPENING_LEVEL_ORIGIN="+String.valueOf(OPENING_LEVEL_ORIGIN));
		sb.append(",CLOSING_LEVEL_ORIGIN="+String.valueOf(CLOSING_LEVEL_ORIGIN));
		sb.append(",OPENING_TOV_ORIGIN="+String.valueOf(OPENING_TOV_ORIGIN));
		sb.append(",CLOSING_TOV_ORIGIN="+String.valueOf(CLOSING_TOV_ORIGIN));
		sb.append(",OPENING_TEMPERATURE_ORIGIN="+String.valueOf(OPENING_TEMPERATURE_ORIGIN));
		sb.append(",CLOSING_TEMPERATURE_ORIGIN="+String.valueOf(CLOSING_TEMPERATURE_ORIGIN));
		sb.append(",OPENING_DENSITY_ORIGIN="+String.valueOf(OPENING_DENSITY_ORIGIN));
		sb.append(",CLOSING_DENSITY_ORIGIN="+String.valueOf(CLOSING_DENSITY_ORIGIN));
		sb.append(",OPENING_NSV_ORIGIN="+String.valueOf(OPENING_NSV_ORIGIN));
		sb.append(",CLOSING_NSV_ORIGIN="+String.valueOf(CLOSING_NSV_ORIGIN));
		sb.append(",OPENING_VAPOR_TEMP_ORIGIN="+String.valueOf(OPENING_VAPOR_TEMP_ORIGIN));
		sb.append(",CLOSING_VAPOR_TEMP_ORIGIN="+String.valueOf(CLOSING_VAPOR_TEMP_ORIGIN));
		sb.append(",OPENING_PRESSURE_ORIGIN="+String.valueOf(OPENING_PRESSURE_ORIGIN));
		sb.append(",CLOSING_PRESSURE_ORIGIN="+String.valueOf(CLOSING_PRESSURE_ORIGIN));
		sb.append(",OPENING_FREE_WATER_LVL_ORIGIN="+String.valueOf(OPENING_FREE_WATER_LVL_ORIGIN));
		sb.append(",CLOSING_FREE_WATER_LVL_ORIGIN="+String.valueOf(CLOSING_FREE_WATER_LVL_ORIGIN));
		sb.append(",OPENING_WATER_QTY_ORIGIN="+String.valueOf(OPENING_WATER_QTY_ORIGIN));
		sb.append(",CLOSING_WATER_QTY_ORIGIN="+String.valueOf(CLOSING_WATER_QTY_ORIGIN));
		sb.append(",COMPARTMENT_OWNER_ID="+String.valueOf(COMPARTMENT_OWNER_ID));
		sb.append(",COMPARTMENT_CONTAINER_CODE="+COMPARTMENT_CONTAINER_CODE);
		sb.append(",COMPARTMENT_CONTAINER_TYPE="+String.valueOf(COMPARTMENT_CONTAINER_TYPE));
		sb.append(",COMPARTMENT_NUMBER="+String.valueOf(COMPARTMENT_NUMBER));
		sb.append(",COMPARTMENT_VISIT_NUMBER="+String.valueOf(COMPARTMENT_VISIT_NUMBER));
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
    final static byte[] commonByteArrayLock_PGS_STAGE_DIM_GAIN_LOSS_HISTORY = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_DIM_GAIN_LOSS_HISTORY = new byte[0];

	
			    public int TERMINAL_PRODUCT_NUMBER;

				public int getTERMINAL_PRODUCT_NUMBER () {
					return this.TERMINAL_PRODUCT_NUMBER;
				}
				
			    public String FOLIO_NUMBER;

				public String getFOLIO_NUMBER () {
					return this.FOLIO_NUMBER;
				}
				
			    public String TANK_CODE;

				public String getTANK_CODE () {
					return this.TANK_CODE;
				}
				
			    public int GAIN_LOSS_ID;

				public int getGAIN_LOSS_ID () {
					return this.GAIN_LOSS_ID;
				}
				
			    public String TANK_GROUP;

				public String getTANK_GROUP () {
					return this.TANK_GROUP;
				}
				
			    public String PRODUCT_GROUP_CODE;

				public String getPRODUCT_GROUP_CODE () {
					return this.PRODUCT_GROUP_CODE;
				}
				
			    public int OPENING_PHYSICAL;

				public int getOPENING_PHYSICAL () {
					return this.OPENING_PHYSICAL;
				}
				
			    public int BULK_RECEIPTS;

				public int getBULK_RECEIPTS () {
					return this.BULK_RECEIPTS;
				}
				
			    public int BULK_TRANSFERS_IN;

				public int getBULK_TRANSFERS_IN () {
					return this.BULK_TRANSFERS_IN;
				}
				
			    public int BULK_DISPOSALS;

				public int getBULK_DISPOSALS () {
					return this.BULK_DISPOSALS;
				}
				
			    public int BULK_TRANSFERS_OUT;

				public int getBULK_TRANSFERS_OUT () {
					return this.BULK_TRANSFERS_OUT;
				}
				
			    public int RACK_RECEIPTS;

				public int getRACK_RECEIPTS () {
					return this.RACK_RECEIPTS;
				}
				
			    public int RACK_DISPOSALS;

				public int getRACK_DISPOSALS () {
					return this.RACK_DISPOSALS;
				}
				
			    public int CLOSING_PHYSICAL;

				public int getCLOSING_PHYSICAL () {
					return this.CLOSING_PHYSICAL;
				}
				
			    public int MANUAL_CLOSING_PHYSICAL;

				public int getMANUAL_CLOSING_PHYSICAL () {
					return this.MANUAL_CLOSING_PHYSICAL;
				}
				
			    public int GAIN_LOSS;

				public int getGAIN_LOSS () {
					return this.GAIN_LOSS;
				}
				
			    public int RACK_FRAC_RECEIPTS;

				public int getRACK_FRAC_RECEIPTS () {
					return this.RACK_FRAC_RECEIPTS;
				}
				
			    public int RACK_FRAC_DISPOSALS;

				public int getRACK_FRAC_DISPOSALS () {
					return this.RACK_FRAC_DISPOSALS;
				}
				
			    public int BULK_FRAC_TRANSFERS_IN;

				public int getBULK_FRAC_TRANSFERS_IN () {
					return this.BULK_FRAC_TRANSFERS_IN;
				}
				
			    public int BULK_FRAC_TRANSFERS_OUT;

				public int getBULK_FRAC_TRANSFERS_OUT () {
					return this.BULK_FRAC_TRANSFERS_OUT;
				}
				
			    public int ADD_BULK_RECEIPTS;

				public int getADD_BULK_RECEIPTS () {
					return this.ADD_BULK_RECEIPTS;
				}
				
			    public int ADD_RACK_RECEIPTS;

				public int getADD_RACK_RECEIPTS () {
					return this.ADD_RACK_RECEIPTS;
				}
				
			    public int ADD_TRANSFERS_IN;

				public int getADD_TRANSFERS_IN () {
					return this.ADD_TRANSFERS_IN;
				}
				
			    public int ADD_BULK_DISPOSALS;

				public int getADD_BULK_DISPOSALS () {
					return this.ADD_BULK_DISPOSALS;
				}
				
			    public int ADD_RACK_DISPOSALS;

				public int getADD_RACK_DISPOSALS () {
					return this.ADD_RACK_DISPOSALS;
				}
				
			    public int ADD_TRANSFERS_OUT;

				public int getADD_TRANSFERS_OUT () {
					return this.ADD_TRANSFERS_OUT;
				}
				
			    public int ADD_GAIN_LOSS;

				public int getADD_GAIN_LOSS () {
					return this.ADD_GAIN_LOSS;
				}
				
			    public int PIPE_FILL;

				public int getPIPE_FILL () {
					return this.PIPE_FILL;
				}
				
			    public int OPENING_PHYSICAL_GROSS_QTY;

				public int getOPENING_PHYSICAL_GROSS_QTY () {
					return this.OPENING_PHYSICAL_GROSS_QTY;
				}
				
			    public int CLOSING_PHYSICAL_GROSS_QTY;

				public int getCLOSING_PHYSICAL_GROSS_QTY () {
					return this.CLOSING_PHYSICAL_GROSS_QTY;
				}
				
			    public double OPENING_TEMPERATURE;

				public double getOPENING_TEMPERATURE () {
					return this.OPENING_TEMPERATURE;
				}
				
			    public double CLOSING_TEMPERATURE;

				public double getCLOSING_TEMPERATURE () {
					return this.CLOSING_TEMPERATURE;
				}
				
			    public double OPENING_DENSITY;

				public double getOPENING_DENSITY () {
					return this.OPENING_DENSITY;
				}
				
			    public double CLOSING_DENSITY;

				public double getCLOSING_DENSITY () {
					return this.CLOSING_DENSITY;
				}
				
			    public int OPENING_BSW_QTY;

				public int getOPENING_BSW_QTY () {
					return this.OPENING_BSW_QTY;
				}
				
			    public int CLOSING_BSW_QTY;

				public int getCLOSING_BSW_QTY () {
					return this.CLOSING_BSW_QTY;
				}
				
			    public String OPENING_LEVEL;

				public String getOPENING_LEVEL () {
					return this.OPENING_LEVEL;
				}
				
			    public String CLOSING_LEVEL;

				public String getCLOSING_LEVEL () {
					return this.CLOSING_LEVEL;
				}
				
			    public double OPENING_OBSERVED_DENSITY;

				public double getOPENING_OBSERVED_DENSITY () {
					return this.OPENING_OBSERVED_DENSITY;
				}
				
			    public double CLOSING_OBSERVED_DENSITY;

				public double getCLOSING_OBSERVED_DENSITY () {
					return this.CLOSING_OBSERVED_DENSITY;
				}
				
			    public String OPENING_BSW_LEVEL;

				public String getOPENING_BSW_LEVEL () {
					return this.OPENING_BSW_LEVEL;
				}
				
			    public String CLOSING_BSW_LEVEL;

				public String getCLOSING_BSW_LEVEL () {
					return this.CLOSING_BSW_LEVEL;
				}
				
			    public int BULK_FRAC_DISPOSALS;

				public int getBULK_FRAC_DISPOSALS () {
					return this.BULK_FRAC_DISPOSALS;
				}
				
			    public int BULK_FRAC_RECEIPTS;

				public int getBULK_FRAC_RECEIPTS () {
					return this.BULK_FRAC_RECEIPTS;
				}
				
			    public int VIRTUAL_TANK;

				public int getVIRTUAL_TANK () {
					return this.VIRTUAL_TANK;
				}
				
			    public double OPENING_COE;

				public double getOPENING_COE () {
					return this.OPENING_COE;
				}
				
			    public double CLOSING_COE;

				public double getCLOSING_COE () {
					return this.CLOSING_COE;
				}
				
			    public int OPENING_LINE_SEGMENT_NSV;

				public int getOPENING_LINE_SEGMENT_NSV () {
					return this.OPENING_LINE_SEGMENT_NSV;
				}
				
			    public int CLOSING_LINE_SEGMENT_NSV;

				public int getCLOSING_LINE_SEGMENT_NSV () {
					return this.CLOSING_LINE_SEGMENT_NSV;
				}
				
			    public int OPENING_TOV;

				public int getOPENING_TOV () {
					return this.OPENING_TOV;
				}
				
			    public int CLOSING_TOV;

				public int getCLOSING_TOV () {
					return this.CLOSING_TOV;
				}
				
			    public int OPENING_GOV;

				public int getOPENING_GOV () {
					return this.OPENING_GOV;
				}
				
			    public int CLOSING_GOV;

				public int getCLOSING_GOV () {
					return this.CLOSING_GOV;
				}
				
			    public int OPENING_GSV;

				public int getOPENING_GSV () {
					return this.OPENING_GSV;
				}
				
			    public int CLOSING_GSV;

				public int getCLOSING_GSV () {
					return this.CLOSING_GSV;
				}
				
			    public int OPENING_TCV;

				public int getOPENING_TCV () {
					return this.OPENING_TCV;
				}
				
			    public int CLOSING_TCV;

				public int getCLOSING_TCV () {
					return this.CLOSING_TCV;
				}
				
			    public double OPENING_CTL;

				public double getOPENING_CTL () {
					return this.OPENING_CTL;
				}
				
			    public double CLOSING_CTL;

				public double getCLOSING_CTL () {
					return this.CLOSING_CTL;
				}
				
			    public double OPENING_SHELL_CORRECTION_FACTO;

				public double getOPENING_SHELL_CORRECTION_FACTO () {
					return this.OPENING_SHELL_CORRECTION_FACTO;
				}
				
			    public double CLOSING_SHELL_CORRECTION_FACTO;

				public double getCLOSING_SHELL_CORRECTION_FACTO () {
					return this.CLOSING_SHELL_CORRECTION_FACTO;
				}
				
			    public int OPENING_FLOATING_ROOF_ADJUSTME;

				public int getOPENING_FLOATING_ROOF_ADJUSTME () {
					return this.OPENING_FLOATING_ROOF_ADJUSTME;
				}
				
			    public int CLOSING_FLOATING_ROOF_ADJUSTME;

				public int getCLOSING_FLOATING_ROOF_ADJUSTME () {
					return this.CLOSING_FLOATING_ROOF_ADJUSTME;
				}
				
			    public double OPENING_AMBIENT_TEMPERATURE;

				public double getOPENING_AMBIENT_TEMPERATURE () {
					return this.OPENING_AMBIENT_TEMPERATURE;
				}
				
			    public double CLOSING_AMBIENT_TEMPERATURE;

				public double getCLOSING_AMBIENT_TEMPERATURE () {
					return this.CLOSING_AMBIENT_TEMPERATURE;
				}
				
			    public double OPENING_SUSPENDED_BSW_PERCENT;

				public double getOPENING_SUSPENDED_BSW_PERCENT () {
					return this.OPENING_SUSPENDED_BSW_PERCENT;
				}
				
			    public double CLOSING_SUSPENDED_BSW_PERCENT;

				public double getCLOSING_SUSPENDED_BSW_PERCENT () {
					return this.CLOSING_SUSPENDED_BSW_PERCENT;
				}
				
			    public String OPENING_GAUGER_INITIALS;

				public String getOPENING_GAUGER_INITIALS () {
					return this.OPENING_GAUGER_INITIALS;
				}
				
			    public String CLOSING_GAUGER_INITIALS;

				public String getCLOSING_GAUGER_INITIALS () {
					return this.CLOSING_GAUGER_INITIALS;
				}
				
			    public java.util.Date OPENING_GAUGE_TIMESTAMP;

				public java.util.Date getOPENING_GAUGE_TIMESTAMP () {
					return this.OPENING_GAUGE_TIMESTAMP;
				}
				
			    public java.util.Date CLOSING_GAUGE_TIMESTAMP;

				public java.util.Date getCLOSING_GAUGE_TIMESTAMP () {
					return this.CLOSING_GAUGE_TIMESTAMP;
				}
				
			    public int OPENING_PRODUCT_STRAP_TYPE;

				public int getOPENING_PRODUCT_STRAP_TYPE () {
					return this.OPENING_PRODUCT_STRAP_TYPE;
				}
				
			    public int CLOSING_PRODUCT_STRAP_TYPE;

				public int getCLOSING_PRODUCT_STRAP_TYPE () {
					return this.CLOSING_PRODUCT_STRAP_TYPE;
				}
				
			    public int OPENING_BSW_STRAP_TYPE;

				public int getOPENING_BSW_STRAP_TYPE () {
					return this.OPENING_BSW_STRAP_TYPE;
				}
				
			    public int CLOSING_BSW_STRAP_TYPE;

				public int getCLOSING_BSW_STRAP_TYPE () {
					return this.CLOSING_BSW_STRAP_TYPE;
				}
				
			    public int OPENING_GSW;

				public int getOPENING_GSW () {
					return this.OPENING_GSW;
				}
				
			    public int CLOSING_GSW;

				public int getCLOSING_GSW () {
					return this.CLOSING_GSW;
				}
				
			    public int OPENING_NSW;

				public int getOPENING_NSW () {
					return this.OPENING_NSW;
				}
				
			    public int CLOSING_NSW;

				public int getCLOSING_NSW () {
					return this.CLOSING_NSW;
				}
				
			    public double OPENING_WCF;

				public double getOPENING_WCF () {
					return this.OPENING_WCF;
				}
				
			    public double CLOSING_WCF;

				public double getCLOSING_WCF () {
					return this.CLOSING_WCF;
				}
				
			    public int OPENING_LINE_SEGMENT_NSW;

				public int getOPENING_LINE_SEGMENT_NSW () {
					return this.OPENING_LINE_SEGMENT_NSW;
				}
				
			    public int CLOSING_LINE_SEGMENT_NSW;

				public int getCLOSING_LINE_SEGMENT_NSW () {
					return this.CLOSING_LINE_SEGMENT_NSW;
				}
				
			    public int OPENING_NSV;

				public int getOPENING_NSV () {
					return this.OPENING_NSV;
				}
				
			    public int CLOSING_NSV;

				public int getCLOSING_NSV () {
					return this.CLOSING_NSV;
				}
				
			    public int OPENING_XCTN_GROSS_QTY;

				public int getOPENING_XCTN_GROSS_QTY () {
					return this.OPENING_XCTN_GROSS_QTY;
				}
				
			    public int CLOSING_XCTN_GROSS_QTY;

				public int getCLOSING_XCTN_GROSS_QTY () {
					return this.CLOSING_XCTN_GROSS_QTY;
				}
				
			    public int OPENING_XCTN_FRAC_GROSS_QTY;

				public int getOPENING_XCTN_FRAC_GROSS_QTY () {
					return this.OPENING_XCTN_FRAC_GROSS_QTY;
				}
				
			    public int CLOSING_XCTN_FRAC_GROSS_QTY;

				public int getCLOSING_XCTN_FRAC_GROSS_QTY () {
					return this.CLOSING_XCTN_FRAC_GROSS_QTY;
				}
				
			    public int OPENING_XCTN_NET_QTY;

				public int getOPENING_XCTN_NET_QTY () {
					return this.OPENING_XCTN_NET_QTY;
				}
				
			    public int CLOSING_XCTN_NET_QTY;

				public int getCLOSING_XCTN_NET_QTY () {
					return this.CLOSING_XCTN_NET_QTY;
				}
				
			    public int OPENING_XCTN_FRAC_NET_QTY;

				public int getOPENING_XCTN_FRAC_NET_QTY () {
					return this.OPENING_XCTN_FRAC_NET_QTY;
				}
				
			    public int CLOSING_XCTN_FRAC_NET_QTY;

				public int getCLOSING_XCTN_FRAC_NET_QTY () {
					return this.CLOSING_XCTN_FRAC_NET_QTY;
				}
				
			    public int OPENING_CALCULATION_POINT;

				public int getOPENING_CALCULATION_POINT () {
					return this.OPENING_CALCULATION_POINT;
				}
				
			    public int CLOSING_CALCULATION_POINT;

				public int getCLOSING_CALCULATION_POINT () {
					return this.CLOSING_CALCULATION_POINT;
				}
				
			    public int MANUAL_OPENING_PHYSICAL;

				public int getMANUAL_OPENING_PHYSICAL () {
					return this.MANUAL_OPENING_PHYSICAL;
				}
				
			    public String OPENING_API_CODE;

				public String getOPENING_API_CODE () {
					return this.OPENING_API_CODE;
				}
				
			    public String CLOSING_API_CODE;

				public String getCLOSING_API_CODE () {
					return this.CLOSING_API_CODE;
				}
				
			    public int OPENING_WEIGHT_IN_AIR;

				public int getOPENING_WEIGHT_IN_AIR () {
					return this.OPENING_WEIGHT_IN_AIR;
				}
				
			    public int CLOSING_WEIGHT_IN_AIR;

				public int getCLOSING_WEIGHT_IN_AIR () {
					return this.CLOSING_WEIGHT_IN_AIR;
				}
				
			    public int OPENING_XCTN_WEIGHT;

				public int getOPENING_XCTN_WEIGHT () {
					return this.OPENING_XCTN_WEIGHT;
				}
				
			    public int OPENING_XCTN_FRAC_WEIGHT;

				public int getOPENING_XCTN_FRAC_WEIGHT () {
					return this.OPENING_XCTN_FRAC_WEIGHT;
				}
				
			    public int CLOSING_XCTN_WEIGHT;

				public int getCLOSING_XCTN_WEIGHT () {
					return this.CLOSING_XCTN_WEIGHT;
				}
				
			    public int CLOSING_XCTN_FRAC_WEIGHT;

				public int getCLOSING_XCTN_FRAC_WEIGHT () {
					return this.CLOSING_XCTN_FRAC_WEIGHT;
				}
				
			    public int OPENING_VAPOR_CORRECT_METHOD;

				public int getOPENING_VAPOR_CORRECT_METHOD () {
					return this.OPENING_VAPOR_CORRECT_METHOD;
				}
				
			    public int CLOSING_VAPOR_CORRECT_METHOD;

				public int getCLOSING_VAPOR_CORRECT_METHOD () {
					return this.CLOSING_VAPOR_CORRECT_METHOD;
				}
				
			    public double OPENING_VAPOR_TEMPERATURE;

				public double getOPENING_VAPOR_TEMPERATURE () {
					return this.OPENING_VAPOR_TEMPERATURE;
				}
				
			    public double CLOSING_VAPOR_TEMPERATURE;

				public double getCLOSING_VAPOR_TEMPERATURE () {
					return this.CLOSING_VAPOR_TEMPERATURE;
				}
				
			    public double OPENING_VAPOR_LIQUID_VOL_RATIO;

				public double getOPENING_VAPOR_LIQUID_VOL_RATIO () {
					return this.OPENING_VAPOR_LIQUID_VOL_RATIO;
				}
				
			    public double CLOSING_VAPOR_LIQUID_VOL_RATIO;

				public double getCLOSING_VAPOR_LIQUID_VOL_RATIO () {
					return this.CLOSING_VAPOR_LIQUID_VOL_RATIO;
				}
				
			    public int INVENTORY_QUANTITY_TYPE;

				public int getINVENTORY_QUANTITY_TYPE () {
					return this.INVENTORY_QUANTITY_TYPE;
				}
				
			    public double OPENING_PRESSURE;

				public double getOPENING_PRESSURE () {
					return this.OPENING_PRESSURE;
				}
				
			    public double CLOSING_PRESSURE;

				public double getCLOSING_PRESSURE () {
					return this.CLOSING_PRESSURE;
				}
				
			    public int OPENING_XCTN_WEIGHT_IN_VAC;

				public int getOPENING_XCTN_WEIGHT_IN_VAC () {
					return this.OPENING_XCTN_WEIGHT_IN_VAC;
				}
				
			    public int OPENING_XCTN_FRAC_WGT_IN_VAC;

				public int getOPENING_XCTN_FRAC_WGT_IN_VAC () {
					return this.OPENING_XCTN_FRAC_WGT_IN_VAC;
				}
				
			    public int CLOSING_XCTN_WEIGHT_IN_VAC;

				public int getCLOSING_XCTN_WEIGHT_IN_VAC () {
					return this.CLOSING_XCTN_WEIGHT_IN_VAC;
				}
				
			    public int CLOSING_XCTN_FRAC_WGT_IN_VAC;

				public int getCLOSING_XCTN_FRAC_WGT_IN_VAC () {
					return this.CLOSING_XCTN_FRAC_WGT_IN_VAC;
				}
				
			    public Integer MAJORITY_SHAREHOLDER;

				public Integer getMAJORITY_SHAREHOLDER () {
					return this.MAJORITY_SHAREHOLDER;
				}
				
			    public int OPENING_INVENTORY_ENABLE;

				public int getOPENING_INVENTORY_ENABLE () {
					return this.OPENING_INVENTORY_ENABLE;
				}
				
			    public int CLOSING_INVENTORY_ENABLE;

				public int getCLOSING_INVENTORY_ENABLE () {
					return this.CLOSING_INVENTORY_ENABLE;
				}
				
			    public int OPENING_LEVEL_ORIGIN;

				public int getOPENING_LEVEL_ORIGIN () {
					return this.OPENING_LEVEL_ORIGIN;
				}
				
			    public int CLOSING_LEVEL_ORIGIN;

				public int getCLOSING_LEVEL_ORIGIN () {
					return this.CLOSING_LEVEL_ORIGIN;
				}
				
			    public int OPENING_TOV_ORIGIN;

				public int getOPENING_TOV_ORIGIN () {
					return this.OPENING_TOV_ORIGIN;
				}
				
			    public int CLOSING_TOV_ORIGIN;

				public int getCLOSING_TOV_ORIGIN () {
					return this.CLOSING_TOV_ORIGIN;
				}
				
			    public int OPENING_TEMPERATURE_ORIGIN;

				public int getOPENING_TEMPERATURE_ORIGIN () {
					return this.OPENING_TEMPERATURE_ORIGIN;
				}
				
			    public int CLOSING_TEMPERATURE_ORIGIN;

				public int getCLOSING_TEMPERATURE_ORIGIN () {
					return this.CLOSING_TEMPERATURE_ORIGIN;
				}
				
			    public int OPENING_DENSITY_ORIGIN;

				public int getOPENING_DENSITY_ORIGIN () {
					return this.OPENING_DENSITY_ORIGIN;
				}
				
			    public int CLOSING_DENSITY_ORIGIN;

				public int getCLOSING_DENSITY_ORIGIN () {
					return this.CLOSING_DENSITY_ORIGIN;
				}
				
			    public int OPENING_NSV_ORIGIN;

				public int getOPENING_NSV_ORIGIN () {
					return this.OPENING_NSV_ORIGIN;
				}
				
			    public int CLOSING_NSV_ORIGIN;

				public int getCLOSING_NSV_ORIGIN () {
					return this.CLOSING_NSV_ORIGIN;
				}
				
			    public int OPENING_VAPOR_TEMP_ORIGIN;

				public int getOPENING_VAPOR_TEMP_ORIGIN () {
					return this.OPENING_VAPOR_TEMP_ORIGIN;
				}
				
			    public int CLOSING_VAPOR_TEMP_ORIGIN;

				public int getCLOSING_VAPOR_TEMP_ORIGIN () {
					return this.CLOSING_VAPOR_TEMP_ORIGIN;
				}
				
			    public int OPENING_PRESSURE_ORIGIN;

				public int getOPENING_PRESSURE_ORIGIN () {
					return this.OPENING_PRESSURE_ORIGIN;
				}
				
			    public int CLOSING_PRESSURE_ORIGIN;

				public int getCLOSING_PRESSURE_ORIGIN () {
					return this.CLOSING_PRESSURE_ORIGIN;
				}
				
			    public int OPENING_FREE_WATER_LVL_ORIGIN;

				public int getOPENING_FREE_WATER_LVL_ORIGIN () {
					return this.OPENING_FREE_WATER_LVL_ORIGIN;
				}
				
			    public int CLOSING_FREE_WATER_LVL_ORIGIN;

				public int getCLOSING_FREE_WATER_LVL_ORIGIN () {
					return this.CLOSING_FREE_WATER_LVL_ORIGIN;
				}
				
			    public int OPENING_WATER_QTY_ORIGIN;

				public int getOPENING_WATER_QTY_ORIGIN () {
					return this.OPENING_WATER_QTY_ORIGIN;
				}
				
			    public int CLOSING_WATER_QTY_ORIGIN;

				public int getCLOSING_WATER_QTY_ORIGIN () {
					return this.CLOSING_WATER_QTY_ORIGIN;
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
				
			    public int COMPARTMENT_VISIT_NUMBER;

				public int getCOMPARTMENT_VISIT_NUMBER () {
					return this.COMPARTMENT_VISIT_NUMBER;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PGS_STAGE_DIM_GAIN_LOSS_HISTORY.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_GAIN_LOSS_HISTORY.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_GAIN_LOSS_HISTORY = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_GAIN_LOSS_HISTORY = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PGS_STAGE_DIM_GAIN_LOSS_HISTORY, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_GAIN_LOSS_HISTORY, 0, length, utf8Charset);
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
			if(length > commonByteArray_PGS_STAGE_DIM_GAIN_LOSS_HISTORY.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_GAIN_LOSS_HISTORY.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_GAIN_LOSS_HISTORY = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_GAIN_LOSS_HISTORY = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PGS_STAGE_DIM_GAIN_LOSS_HISTORY, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_GAIN_LOSS_HISTORY, 0, length, utf8Charset);
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

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_GAIN_LOSS_HISTORY) {

        	try {

        		int length = 0;
		
			        this.TERMINAL_PRODUCT_NUMBER = dis.readInt();
					
					this.FOLIO_NUMBER = readString(dis);
					
					this.TANK_CODE = readString(dis);
					
			        this.GAIN_LOSS_ID = dis.readInt();
					
					this.TANK_GROUP = readString(dis);
					
					this.PRODUCT_GROUP_CODE = readString(dis);
					
			        this.OPENING_PHYSICAL = dis.readInt();
					
			        this.BULK_RECEIPTS = dis.readInt();
					
			        this.BULK_TRANSFERS_IN = dis.readInt();
					
			        this.BULK_DISPOSALS = dis.readInt();
					
			        this.BULK_TRANSFERS_OUT = dis.readInt();
					
			        this.RACK_RECEIPTS = dis.readInt();
					
			        this.RACK_DISPOSALS = dis.readInt();
					
			        this.CLOSING_PHYSICAL = dis.readInt();
					
			        this.MANUAL_CLOSING_PHYSICAL = dis.readInt();
					
			        this.GAIN_LOSS = dis.readInt();
					
			        this.RACK_FRAC_RECEIPTS = dis.readInt();
					
			        this.RACK_FRAC_DISPOSALS = dis.readInt();
					
			        this.BULK_FRAC_TRANSFERS_IN = dis.readInt();
					
			        this.BULK_FRAC_TRANSFERS_OUT = dis.readInt();
					
			        this.ADD_BULK_RECEIPTS = dis.readInt();
					
			        this.ADD_RACK_RECEIPTS = dis.readInt();
					
			        this.ADD_TRANSFERS_IN = dis.readInt();
					
			        this.ADD_BULK_DISPOSALS = dis.readInt();
					
			        this.ADD_RACK_DISPOSALS = dis.readInt();
					
			        this.ADD_TRANSFERS_OUT = dis.readInt();
					
			        this.ADD_GAIN_LOSS = dis.readInt();
					
			        this.PIPE_FILL = dis.readInt();
					
			        this.OPENING_PHYSICAL_GROSS_QTY = dis.readInt();
					
			        this.CLOSING_PHYSICAL_GROSS_QTY = dis.readInt();
					
			        this.OPENING_TEMPERATURE = dis.readDouble();
					
			        this.CLOSING_TEMPERATURE = dis.readDouble();
					
			        this.OPENING_DENSITY = dis.readDouble();
					
			        this.CLOSING_DENSITY = dis.readDouble();
					
			        this.OPENING_BSW_QTY = dis.readInt();
					
			        this.CLOSING_BSW_QTY = dis.readInt();
					
					this.OPENING_LEVEL = readString(dis);
					
					this.CLOSING_LEVEL = readString(dis);
					
			        this.OPENING_OBSERVED_DENSITY = dis.readDouble();
					
			        this.CLOSING_OBSERVED_DENSITY = dis.readDouble();
					
					this.OPENING_BSW_LEVEL = readString(dis);
					
					this.CLOSING_BSW_LEVEL = readString(dis);
					
			        this.BULK_FRAC_DISPOSALS = dis.readInt();
					
			        this.BULK_FRAC_RECEIPTS = dis.readInt();
					
			        this.VIRTUAL_TANK = dis.readInt();
					
			        this.OPENING_COE = dis.readDouble();
					
			        this.CLOSING_COE = dis.readDouble();
					
			        this.OPENING_LINE_SEGMENT_NSV = dis.readInt();
					
			        this.CLOSING_LINE_SEGMENT_NSV = dis.readInt();
					
			        this.OPENING_TOV = dis.readInt();
					
			        this.CLOSING_TOV = dis.readInt();
					
			        this.OPENING_GOV = dis.readInt();
					
			        this.CLOSING_GOV = dis.readInt();
					
			        this.OPENING_GSV = dis.readInt();
					
			        this.CLOSING_GSV = dis.readInt();
					
			        this.OPENING_TCV = dis.readInt();
					
			        this.CLOSING_TCV = dis.readInt();
					
			        this.OPENING_CTL = dis.readDouble();
					
			        this.CLOSING_CTL = dis.readDouble();
					
			        this.OPENING_SHELL_CORRECTION_FACTO = dis.readDouble();
					
			        this.CLOSING_SHELL_CORRECTION_FACTO = dis.readDouble();
					
			        this.OPENING_FLOATING_ROOF_ADJUSTME = dis.readInt();
					
			        this.CLOSING_FLOATING_ROOF_ADJUSTME = dis.readInt();
					
			        this.OPENING_AMBIENT_TEMPERATURE = dis.readDouble();
					
			        this.CLOSING_AMBIENT_TEMPERATURE = dis.readDouble();
					
			        this.OPENING_SUSPENDED_BSW_PERCENT = dis.readDouble();
					
			        this.CLOSING_SUSPENDED_BSW_PERCENT = dis.readDouble();
					
					this.OPENING_GAUGER_INITIALS = readString(dis);
					
					this.CLOSING_GAUGER_INITIALS = readString(dis);
					
					this.OPENING_GAUGE_TIMESTAMP = readDate(dis);
					
					this.CLOSING_GAUGE_TIMESTAMP = readDate(dis);
					
			        this.OPENING_PRODUCT_STRAP_TYPE = dis.readInt();
					
			        this.CLOSING_PRODUCT_STRAP_TYPE = dis.readInt();
					
			        this.OPENING_BSW_STRAP_TYPE = dis.readInt();
					
			        this.CLOSING_BSW_STRAP_TYPE = dis.readInt();
					
			        this.OPENING_GSW = dis.readInt();
					
			        this.CLOSING_GSW = dis.readInt();
					
			        this.OPENING_NSW = dis.readInt();
					
			        this.CLOSING_NSW = dis.readInt();
					
			        this.OPENING_WCF = dis.readDouble();
					
			        this.CLOSING_WCF = dis.readDouble();
					
			        this.OPENING_LINE_SEGMENT_NSW = dis.readInt();
					
			        this.CLOSING_LINE_SEGMENT_NSW = dis.readInt();
					
			        this.OPENING_NSV = dis.readInt();
					
			        this.CLOSING_NSV = dis.readInt();
					
			        this.OPENING_XCTN_GROSS_QTY = dis.readInt();
					
			        this.CLOSING_XCTN_GROSS_QTY = dis.readInt();
					
			        this.OPENING_XCTN_FRAC_GROSS_QTY = dis.readInt();
					
			        this.CLOSING_XCTN_FRAC_GROSS_QTY = dis.readInt();
					
			        this.OPENING_XCTN_NET_QTY = dis.readInt();
					
			        this.CLOSING_XCTN_NET_QTY = dis.readInt();
					
			        this.OPENING_XCTN_FRAC_NET_QTY = dis.readInt();
					
			        this.CLOSING_XCTN_FRAC_NET_QTY = dis.readInt();
					
			        this.OPENING_CALCULATION_POINT = dis.readInt();
					
			        this.CLOSING_CALCULATION_POINT = dis.readInt();
					
			        this.MANUAL_OPENING_PHYSICAL = dis.readInt();
					
					this.OPENING_API_CODE = readString(dis);
					
					this.CLOSING_API_CODE = readString(dis);
					
			        this.OPENING_WEIGHT_IN_AIR = dis.readInt();
					
			        this.CLOSING_WEIGHT_IN_AIR = dis.readInt();
					
			        this.OPENING_XCTN_WEIGHT = dis.readInt();
					
			        this.OPENING_XCTN_FRAC_WEIGHT = dis.readInt();
					
			        this.CLOSING_XCTN_WEIGHT = dis.readInt();
					
			        this.CLOSING_XCTN_FRAC_WEIGHT = dis.readInt();
					
			        this.OPENING_VAPOR_CORRECT_METHOD = dis.readInt();
					
			        this.CLOSING_VAPOR_CORRECT_METHOD = dis.readInt();
					
			        this.OPENING_VAPOR_TEMPERATURE = dis.readDouble();
					
			        this.CLOSING_VAPOR_TEMPERATURE = dis.readDouble();
					
			        this.OPENING_VAPOR_LIQUID_VOL_RATIO = dis.readDouble();
					
			        this.CLOSING_VAPOR_LIQUID_VOL_RATIO = dis.readDouble();
					
			        this.INVENTORY_QUANTITY_TYPE = dis.readInt();
					
			        this.OPENING_PRESSURE = dis.readDouble();
					
			        this.CLOSING_PRESSURE = dis.readDouble();
					
			        this.OPENING_XCTN_WEIGHT_IN_VAC = dis.readInt();
					
			        this.OPENING_XCTN_FRAC_WGT_IN_VAC = dis.readInt();
					
			        this.CLOSING_XCTN_WEIGHT_IN_VAC = dis.readInt();
					
			        this.CLOSING_XCTN_FRAC_WGT_IN_VAC = dis.readInt();
					
						this.MAJORITY_SHAREHOLDER = readInteger(dis);
					
			        this.OPENING_INVENTORY_ENABLE = dis.readInt();
					
			        this.CLOSING_INVENTORY_ENABLE = dis.readInt();
					
			        this.OPENING_LEVEL_ORIGIN = dis.readInt();
					
			        this.CLOSING_LEVEL_ORIGIN = dis.readInt();
					
			        this.OPENING_TOV_ORIGIN = dis.readInt();
					
			        this.CLOSING_TOV_ORIGIN = dis.readInt();
					
			        this.OPENING_TEMPERATURE_ORIGIN = dis.readInt();
					
			        this.CLOSING_TEMPERATURE_ORIGIN = dis.readInt();
					
			        this.OPENING_DENSITY_ORIGIN = dis.readInt();
					
			        this.CLOSING_DENSITY_ORIGIN = dis.readInt();
					
			        this.OPENING_NSV_ORIGIN = dis.readInt();
					
			        this.CLOSING_NSV_ORIGIN = dis.readInt();
					
			        this.OPENING_VAPOR_TEMP_ORIGIN = dis.readInt();
					
			        this.CLOSING_VAPOR_TEMP_ORIGIN = dis.readInt();
					
			        this.OPENING_PRESSURE_ORIGIN = dis.readInt();
					
			        this.CLOSING_PRESSURE_ORIGIN = dis.readInt();
					
			        this.OPENING_FREE_WATER_LVL_ORIGIN = dis.readInt();
					
			        this.CLOSING_FREE_WATER_LVL_ORIGIN = dis.readInt();
					
			        this.OPENING_WATER_QTY_ORIGIN = dis.readInt();
					
			        this.CLOSING_WATER_QTY_ORIGIN = dis.readInt();
					
						this.COMPARTMENT_OWNER_ID = readInteger(dis);
					
					this.COMPARTMENT_CONTAINER_CODE = readString(dis);
					
						this.COMPARTMENT_CONTAINER_TYPE = readInteger(dis);
					
						this.COMPARTMENT_NUMBER = readInteger(dis);
					
			        this.COMPARTMENT_VISIT_NUMBER = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_GAIN_LOSS_HISTORY) {

        	try {

        		int length = 0;
		
			        this.TERMINAL_PRODUCT_NUMBER = dis.readInt();
					
					this.FOLIO_NUMBER = readString(dis);
					
					this.TANK_CODE = readString(dis);
					
			        this.GAIN_LOSS_ID = dis.readInt();
					
					this.TANK_GROUP = readString(dis);
					
					this.PRODUCT_GROUP_CODE = readString(dis);
					
			        this.OPENING_PHYSICAL = dis.readInt();
					
			        this.BULK_RECEIPTS = dis.readInt();
					
			        this.BULK_TRANSFERS_IN = dis.readInt();
					
			        this.BULK_DISPOSALS = dis.readInt();
					
			        this.BULK_TRANSFERS_OUT = dis.readInt();
					
			        this.RACK_RECEIPTS = dis.readInt();
					
			        this.RACK_DISPOSALS = dis.readInt();
					
			        this.CLOSING_PHYSICAL = dis.readInt();
					
			        this.MANUAL_CLOSING_PHYSICAL = dis.readInt();
					
			        this.GAIN_LOSS = dis.readInt();
					
			        this.RACK_FRAC_RECEIPTS = dis.readInt();
					
			        this.RACK_FRAC_DISPOSALS = dis.readInt();
					
			        this.BULK_FRAC_TRANSFERS_IN = dis.readInt();
					
			        this.BULK_FRAC_TRANSFERS_OUT = dis.readInt();
					
			        this.ADD_BULK_RECEIPTS = dis.readInt();
					
			        this.ADD_RACK_RECEIPTS = dis.readInt();
					
			        this.ADD_TRANSFERS_IN = dis.readInt();
					
			        this.ADD_BULK_DISPOSALS = dis.readInt();
					
			        this.ADD_RACK_DISPOSALS = dis.readInt();
					
			        this.ADD_TRANSFERS_OUT = dis.readInt();
					
			        this.ADD_GAIN_LOSS = dis.readInt();
					
			        this.PIPE_FILL = dis.readInt();
					
			        this.OPENING_PHYSICAL_GROSS_QTY = dis.readInt();
					
			        this.CLOSING_PHYSICAL_GROSS_QTY = dis.readInt();
					
			        this.OPENING_TEMPERATURE = dis.readDouble();
					
			        this.CLOSING_TEMPERATURE = dis.readDouble();
					
			        this.OPENING_DENSITY = dis.readDouble();
					
			        this.CLOSING_DENSITY = dis.readDouble();
					
			        this.OPENING_BSW_QTY = dis.readInt();
					
			        this.CLOSING_BSW_QTY = dis.readInt();
					
					this.OPENING_LEVEL = readString(dis);
					
					this.CLOSING_LEVEL = readString(dis);
					
			        this.OPENING_OBSERVED_DENSITY = dis.readDouble();
					
			        this.CLOSING_OBSERVED_DENSITY = dis.readDouble();
					
					this.OPENING_BSW_LEVEL = readString(dis);
					
					this.CLOSING_BSW_LEVEL = readString(dis);
					
			        this.BULK_FRAC_DISPOSALS = dis.readInt();
					
			        this.BULK_FRAC_RECEIPTS = dis.readInt();
					
			        this.VIRTUAL_TANK = dis.readInt();
					
			        this.OPENING_COE = dis.readDouble();
					
			        this.CLOSING_COE = dis.readDouble();
					
			        this.OPENING_LINE_SEGMENT_NSV = dis.readInt();
					
			        this.CLOSING_LINE_SEGMENT_NSV = dis.readInt();
					
			        this.OPENING_TOV = dis.readInt();
					
			        this.CLOSING_TOV = dis.readInt();
					
			        this.OPENING_GOV = dis.readInt();
					
			        this.CLOSING_GOV = dis.readInt();
					
			        this.OPENING_GSV = dis.readInt();
					
			        this.CLOSING_GSV = dis.readInt();
					
			        this.OPENING_TCV = dis.readInt();
					
			        this.CLOSING_TCV = dis.readInt();
					
			        this.OPENING_CTL = dis.readDouble();
					
			        this.CLOSING_CTL = dis.readDouble();
					
			        this.OPENING_SHELL_CORRECTION_FACTO = dis.readDouble();
					
			        this.CLOSING_SHELL_CORRECTION_FACTO = dis.readDouble();
					
			        this.OPENING_FLOATING_ROOF_ADJUSTME = dis.readInt();
					
			        this.CLOSING_FLOATING_ROOF_ADJUSTME = dis.readInt();
					
			        this.OPENING_AMBIENT_TEMPERATURE = dis.readDouble();
					
			        this.CLOSING_AMBIENT_TEMPERATURE = dis.readDouble();
					
			        this.OPENING_SUSPENDED_BSW_PERCENT = dis.readDouble();
					
			        this.CLOSING_SUSPENDED_BSW_PERCENT = dis.readDouble();
					
					this.OPENING_GAUGER_INITIALS = readString(dis);
					
					this.CLOSING_GAUGER_INITIALS = readString(dis);
					
					this.OPENING_GAUGE_TIMESTAMP = readDate(dis);
					
					this.CLOSING_GAUGE_TIMESTAMP = readDate(dis);
					
			        this.OPENING_PRODUCT_STRAP_TYPE = dis.readInt();
					
			        this.CLOSING_PRODUCT_STRAP_TYPE = dis.readInt();
					
			        this.OPENING_BSW_STRAP_TYPE = dis.readInt();
					
			        this.CLOSING_BSW_STRAP_TYPE = dis.readInt();
					
			        this.OPENING_GSW = dis.readInt();
					
			        this.CLOSING_GSW = dis.readInt();
					
			        this.OPENING_NSW = dis.readInt();
					
			        this.CLOSING_NSW = dis.readInt();
					
			        this.OPENING_WCF = dis.readDouble();
					
			        this.CLOSING_WCF = dis.readDouble();
					
			        this.OPENING_LINE_SEGMENT_NSW = dis.readInt();
					
			        this.CLOSING_LINE_SEGMENT_NSW = dis.readInt();
					
			        this.OPENING_NSV = dis.readInt();
					
			        this.CLOSING_NSV = dis.readInt();
					
			        this.OPENING_XCTN_GROSS_QTY = dis.readInt();
					
			        this.CLOSING_XCTN_GROSS_QTY = dis.readInt();
					
			        this.OPENING_XCTN_FRAC_GROSS_QTY = dis.readInt();
					
			        this.CLOSING_XCTN_FRAC_GROSS_QTY = dis.readInt();
					
			        this.OPENING_XCTN_NET_QTY = dis.readInt();
					
			        this.CLOSING_XCTN_NET_QTY = dis.readInt();
					
			        this.OPENING_XCTN_FRAC_NET_QTY = dis.readInt();
					
			        this.CLOSING_XCTN_FRAC_NET_QTY = dis.readInt();
					
			        this.OPENING_CALCULATION_POINT = dis.readInt();
					
			        this.CLOSING_CALCULATION_POINT = dis.readInt();
					
			        this.MANUAL_OPENING_PHYSICAL = dis.readInt();
					
					this.OPENING_API_CODE = readString(dis);
					
					this.CLOSING_API_CODE = readString(dis);
					
			        this.OPENING_WEIGHT_IN_AIR = dis.readInt();
					
			        this.CLOSING_WEIGHT_IN_AIR = dis.readInt();
					
			        this.OPENING_XCTN_WEIGHT = dis.readInt();
					
			        this.OPENING_XCTN_FRAC_WEIGHT = dis.readInt();
					
			        this.CLOSING_XCTN_WEIGHT = dis.readInt();
					
			        this.CLOSING_XCTN_FRAC_WEIGHT = dis.readInt();
					
			        this.OPENING_VAPOR_CORRECT_METHOD = dis.readInt();
					
			        this.CLOSING_VAPOR_CORRECT_METHOD = dis.readInt();
					
			        this.OPENING_VAPOR_TEMPERATURE = dis.readDouble();
					
			        this.CLOSING_VAPOR_TEMPERATURE = dis.readDouble();
					
			        this.OPENING_VAPOR_LIQUID_VOL_RATIO = dis.readDouble();
					
			        this.CLOSING_VAPOR_LIQUID_VOL_RATIO = dis.readDouble();
					
			        this.INVENTORY_QUANTITY_TYPE = dis.readInt();
					
			        this.OPENING_PRESSURE = dis.readDouble();
					
			        this.CLOSING_PRESSURE = dis.readDouble();
					
			        this.OPENING_XCTN_WEIGHT_IN_VAC = dis.readInt();
					
			        this.OPENING_XCTN_FRAC_WGT_IN_VAC = dis.readInt();
					
			        this.CLOSING_XCTN_WEIGHT_IN_VAC = dis.readInt();
					
			        this.CLOSING_XCTN_FRAC_WGT_IN_VAC = dis.readInt();
					
						this.MAJORITY_SHAREHOLDER = readInteger(dis);
					
			        this.OPENING_INVENTORY_ENABLE = dis.readInt();
					
			        this.CLOSING_INVENTORY_ENABLE = dis.readInt();
					
			        this.OPENING_LEVEL_ORIGIN = dis.readInt();
					
			        this.CLOSING_LEVEL_ORIGIN = dis.readInt();
					
			        this.OPENING_TOV_ORIGIN = dis.readInt();
					
			        this.CLOSING_TOV_ORIGIN = dis.readInt();
					
			        this.OPENING_TEMPERATURE_ORIGIN = dis.readInt();
					
			        this.CLOSING_TEMPERATURE_ORIGIN = dis.readInt();
					
			        this.OPENING_DENSITY_ORIGIN = dis.readInt();
					
			        this.CLOSING_DENSITY_ORIGIN = dis.readInt();
					
			        this.OPENING_NSV_ORIGIN = dis.readInt();
					
			        this.CLOSING_NSV_ORIGIN = dis.readInt();
					
			        this.OPENING_VAPOR_TEMP_ORIGIN = dis.readInt();
					
			        this.CLOSING_VAPOR_TEMP_ORIGIN = dis.readInt();
					
			        this.OPENING_PRESSURE_ORIGIN = dis.readInt();
					
			        this.CLOSING_PRESSURE_ORIGIN = dis.readInt();
					
			        this.OPENING_FREE_WATER_LVL_ORIGIN = dis.readInt();
					
			        this.CLOSING_FREE_WATER_LVL_ORIGIN = dis.readInt();
					
			        this.OPENING_WATER_QTY_ORIGIN = dis.readInt();
					
			        this.CLOSING_WATER_QTY_ORIGIN = dis.readInt();
					
						this.COMPARTMENT_OWNER_ID = readInteger(dis);
					
					this.COMPARTMENT_CONTAINER_CODE = readString(dis);
					
						this.COMPARTMENT_CONTAINER_TYPE = readInteger(dis);
					
						this.COMPARTMENT_NUMBER = readInteger(dis);
					
			        this.COMPARTMENT_VISIT_NUMBER = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.TERMINAL_PRODUCT_NUMBER);
					
					// String
				
						writeString(this.FOLIO_NUMBER,dos);
					
					// String
				
						writeString(this.TANK_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.GAIN_LOSS_ID);
					
					// String
				
						writeString(this.TANK_GROUP,dos);
					
					// String
				
						writeString(this.PRODUCT_GROUP_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.OPENING_PHYSICAL);
					
					// int
				
		            	dos.writeInt(this.BULK_RECEIPTS);
					
					// int
				
		            	dos.writeInt(this.BULK_TRANSFERS_IN);
					
					// int
				
		            	dos.writeInt(this.BULK_DISPOSALS);
					
					// int
				
		            	dos.writeInt(this.BULK_TRANSFERS_OUT);
					
					// int
				
		            	dos.writeInt(this.RACK_RECEIPTS);
					
					// int
				
		            	dos.writeInt(this.RACK_DISPOSALS);
					
					// int
				
		            	dos.writeInt(this.CLOSING_PHYSICAL);
					
					// int
				
		            	dos.writeInt(this.MANUAL_CLOSING_PHYSICAL);
					
					// int
				
		            	dos.writeInt(this.GAIN_LOSS);
					
					// int
				
		            	dos.writeInt(this.RACK_FRAC_RECEIPTS);
					
					// int
				
		            	dos.writeInt(this.RACK_FRAC_DISPOSALS);
					
					// int
				
		            	dos.writeInt(this.BULK_FRAC_TRANSFERS_IN);
					
					// int
				
		            	dos.writeInt(this.BULK_FRAC_TRANSFERS_OUT);
					
					// int
				
		            	dos.writeInt(this.ADD_BULK_RECEIPTS);
					
					// int
				
		            	dos.writeInt(this.ADD_RACK_RECEIPTS);
					
					// int
				
		            	dos.writeInt(this.ADD_TRANSFERS_IN);
					
					// int
				
		            	dos.writeInt(this.ADD_BULK_DISPOSALS);
					
					// int
				
		            	dos.writeInt(this.ADD_RACK_DISPOSALS);
					
					// int
				
		            	dos.writeInt(this.ADD_TRANSFERS_OUT);
					
					// int
				
		            	dos.writeInt(this.ADD_GAIN_LOSS);
					
					// int
				
		            	dos.writeInt(this.PIPE_FILL);
					
					// int
				
		            	dos.writeInt(this.OPENING_PHYSICAL_GROSS_QTY);
					
					// int
				
		            	dos.writeInt(this.CLOSING_PHYSICAL_GROSS_QTY);
					
					// double
				
		            	dos.writeDouble(this.OPENING_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.OPENING_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_DENSITY);
					
					// int
				
		            	dos.writeInt(this.OPENING_BSW_QTY);
					
					// int
				
		            	dos.writeInt(this.CLOSING_BSW_QTY);
					
					// String
				
						writeString(this.OPENING_LEVEL,dos);
					
					// String
				
						writeString(this.CLOSING_LEVEL,dos);
					
					// double
				
		            	dos.writeDouble(this.OPENING_OBSERVED_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_OBSERVED_DENSITY);
					
					// String
				
						writeString(this.OPENING_BSW_LEVEL,dos);
					
					// String
				
						writeString(this.CLOSING_BSW_LEVEL,dos);
					
					// int
				
		            	dos.writeInt(this.BULK_FRAC_DISPOSALS);
					
					// int
				
		            	dos.writeInt(this.BULK_FRAC_RECEIPTS);
					
					// int
				
		            	dos.writeInt(this.VIRTUAL_TANK);
					
					// double
				
		            	dos.writeDouble(this.OPENING_COE);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_COE);
					
					// int
				
		            	dos.writeInt(this.OPENING_LINE_SEGMENT_NSV);
					
					// int
				
		            	dos.writeInt(this.CLOSING_LINE_SEGMENT_NSV);
					
					// int
				
		            	dos.writeInt(this.OPENING_TOV);
					
					// int
				
		            	dos.writeInt(this.CLOSING_TOV);
					
					// int
				
		            	dos.writeInt(this.OPENING_GOV);
					
					// int
				
		            	dos.writeInt(this.CLOSING_GOV);
					
					// int
				
		            	dos.writeInt(this.OPENING_GSV);
					
					// int
				
		            	dos.writeInt(this.CLOSING_GSV);
					
					// int
				
		            	dos.writeInt(this.OPENING_TCV);
					
					// int
				
		            	dos.writeInt(this.CLOSING_TCV);
					
					// double
				
		            	dos.writeDouble(this.OPENING_CTL);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_CTL);
					
					// double
				
		            	dos.writeDouble(this.OPENING_SHELL_CORRECTION_FACTO);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_SHELL_CORRECTION_FACTO);
					
					// int
				
		            	dos.writeInt(this.OPENING_FLOATING_ROOF_ADJUSTME);
					
					// int
				
		            	dos.writeInt(this.CLOSING_FLOATING_ROOF_ADJUSTME);
					
					// double
				
		            	dos.writeDouble(this.OPENING_AMBIENT_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_AMBIENT_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.OPENING_SUSPENDED_BSW_PERCENT);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_SUSPENDED_BSW_PERCENT);
					
					// String
				
						writeString(this.OPENING_GAUGER_INITIALS,dos);
					
					// String
				
						writeString(this.CLOSING_GAUGER_INITIALS,dos);
					
					// java.util.Date
				
						writeDate(this.OPENING_GAUGE_TIMESTAMP,dos);
					
					// java.util.Date
				
						writeDate(this.CLOSING_GAUGE_TIMESTAMP,dos);
					
					// int
				
		            	dos.writeInt(this.OPENING_PRODUCT_STRAP_TYPE);
					
					// int
				
		            	dos.writeInt(this.CLOSING_PRODUCT_STRAP_TYPE);
					
					// int
				
		            	dos.writeInt(this.OPENING_BSW_STRAP_TYPE);
					
					// int
				
		            	dos.writeInt(this.CLOSING_BSW_STRAP_TYPE);
					
					// int
				
		            	dos.writeInt(this.OPENING_GSW);
					
					// int
				
		            	dos.writeInt(this.CLOSING_GSW);
					
					// int
				
		            	dos.writeInt(this.OPENING_NSW);
					
					// int
				
		            	dos.writeInt(this.CLOSING_NSW);
					
					// double
				
		            	dos.writeDouble(this.OPENING_WCF);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_WCF);
					
					// int
				
		            	dos.writeInt(this.OPENING_LINE_SEGMENT_NSW);
					
					// int
				
		            	dos.writeInt(this.CLOSING_LINE_SEGMENT_NSW);
					
					// int
				
		            	dos.writeInt(this.OPENING_NSV);
					
					// int
				
		            	dos.writeInt(this.CLOSING_NSV);
					
					// int
				
		            	dos.writeInt(this.OPENING_XCTN_GROSS_QTY);
					
					// int
				
		            	dos.writeInt(this.CLOSING_XCTN_GROSS_QTY);
					
					// int
				
		            	dos.writeInt(this.OPENING_XCTN_FRAC_GROSS_QTY);
					
					// int
				
		            	dos.writeInt(this.CLOSING_XCTN_FRAC_GROSS_QTY);
					
					// int
				
		            	dos.writeInt(this.OPENING_XCTN_NET_QTY);
					
					// int
				
		            	dos.writeInt(this.CLOSING_XCTN_NET_QTY);
					
					// int
				
		            	dos.writeInt(this.OPENING_XCTN_FRAC_NET_QTY);
					
					// int
				
		            	dos.writeInt(this.CLOSING_XCTN_FRAC_NET_QTY);
					
					// int
				
		            	dos.writeInt(this.OPENING_CALCULATION_POINT);
					
					// int
				
		            	dos.writeInt(this.CLOSING_CALCULATION_POINT);
					
					// int
				
		            	dos.writeInt(this.MANUAL_OPENING_PHYSICAL);
					
					// String
				
						writeString(this.OPENING_API_CODE,dos);
					
					// String
				
						writeString(this.CLOSING_API_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.OPENING_WEIGHT_IN_AIR);
					
					// int
				
		            	dos.writeInt(this.CLOSING_WEIGHT_IN_AIR);
					
					// int
				
		            	dos.writeInt(this.OPENING_XCTN_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.OPENING_XCTN_FRAC_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.CLOSING_XCTN_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.CLOSING_XCTN_FRAC_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.OPENING_VAPOR_CORRECT_METHOD);
					
					// int
				
		            	dos.writeInt(this.CLOSING_VAPOR_CORRECT_METHOD);
					
					// double
				
		            	dos.writeDouble(this.OPENING_VAPOR_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_VAPOR_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.OPENING_VAPOR_LIQUID_VOL_RATIO);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_VAPOR_LIQUID_VOL_RATIO);
					
					// int
				
		            	dos.writeInt(this.INVENTORY_QUANTITY_TYPE);
					
					// double
				
		            	dos.writeDouble(this.OPENING_PRESSURE);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_PRESSURE);
					
					// int
				
		            	dos.writeInt(this.OPENING_XCTN_WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.OPENING_XCTN_FRAC_WGT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.CLOSING_XCTN_WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.CLOSING_XCTN_FRAC_WGT_IN_VAC);
					
					// Integer
				
						writeInteger(this.MAJORITY_SHAREHOLDER,dos);
					
					// int
				
		            	dos.writeInt(this.OPENING_INVENTORY_ENABLE);
					
					// int
				
		            	dos.writeInt(this.CLOSING_INVENTORY_ENABLE);
					
					// int
				
		            	dos.writeInt(this.OPENING_LEVEL_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.CLOSING_LEVEL_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.OPENING_TOV_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.CLOSING_TOV_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.OPENING_TEMPERATURE_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.CLOSING_TEMPERATURE_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.OPENING_DENSITY_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.CLOSING_DENSITY_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.OPENING_NSV_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.CLOSING_NSV_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.OPENING_VAPOR_TEMP_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.CLOSING_VAPOR_TEMP_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.OPENING_PRESSURE_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.CLOSING_PRESSURE_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.OPENING_FREE_WATER_LVL_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.CLOSING_FREE_WATER_LVL_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.OPENING_WATER_QTY_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.CLOSING_WATER_QTY_ORIGIN);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_OWNER_ID,dos);
					
					// String
				
						writeString(this.COMPARTMENT_CONTAINER_CODE,dos);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_CONTAINER_TYPE,dos);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.COMPARTMENT_VISIT_NUMBER);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.TERMINAL_PRODUCT_NUMBER);
					
					// String
				
						writeString(this.FOLIO_NUMBER,dos);
					
					// String
				
						writeString(this.TANK_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.GAIN_LOSS_ID);
					
					// String
				
						writeString(this.TANK_GROUP,dos);
					
					// String
				
						writeString(this.PRODUCT_GROUP_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.OPENING_PHYSICAL);
					
					// int
				
		            	dos.writeInt(this.BULK_RECEIPTS);
					
					// int
				
		            	dos.writeInt(this.BULK_TRANSFERS_IN);
					
					// int
				
		            	dos.writeInt(this.BULK_DISPOSALS);
					
					// int
				
		            	dos.writeInt(this.BULK_TRANSFERS_OUT);
					
					// int
				
		            	dos.writeInt(this.RACK_RECEIPTS);
					
					// int
				
		            	dos.writeInt(this.RACK_DISPOSALS);
					
					// int
				
		            	dos.writeInt(this.CLOSING_PHYSICAL);
					
					// int
				
		            	dos.writeInt(this.MANUAL_CLOSING_PHYSICAL);
					
					// int
				
		            	dos.writeInt(this.GAIN_LOSS);
					
					// int
				
		            	dos.writeInt(this.RACK_FRAC_RECEIPTS);
					
					// int
				
		            	dos.writeInt(this.RACK_FRAC_DISPOSALS);
					
					// int
				
		            	dos.writeInt(this.BULK_FRAC_TRANSFERS_IN);
					
					// int
				
		            	dos.writeInt(this.BULK_FRAC_TRANSFERS_OUT);
					
					// int
				
		            	dos.writeInt(this.ADD_BULK_RECEIPTS);
					
					// int
				
		            	dos.writeInt(this.ADD_RACK_RECEIPTS);
					
					// int
				
		            	dos.writeInt(this.ADD_TRANSFERS_IN);
					
					// int
				
		            	dos.writeInt(this.ADD_BULK_DISPOSALS);
					
					// int
				
		            	dos.writeInt(this.ADD_RACK_DISPOSALS);
					
					// int
				
		            	dos.writeInt(this.ADD_TRANSFERS_OUT);
					
					// int
				
		            	dos.writeInt(this.ADD_GAIN_LOSS);
					
					// int
				
		            	dos.writeInt(this.PIPE_FILL);
					
					// int
				
		            	dos.writeInt(this.OPENING_PHYSICAL_GROSS_QTY);
					
					// int
				
		            	dos.writeInt(this.CLOSING_PHYSICAL_GROSS_QTY);
					
					// double
				
		            	dos.writeDouble(this.OPENING_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.OPENING_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_DENSITY);
					
					// int
				
		            	dos.writeInt(this.OPENING_BSW_QTY);
					
					// int
				
		            	dos.writeInt(this.CLOSING_BSW_QTY);
					
					// String
				
						writeString(this.OPENING_LEVEL,dos);
					
					// String
				
						writeString(this.CLOSING_LEVEL,dos);
					
					// double
				
		            	dos.writeDouble(this.OPENING_OBSERVED_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_OBSERVED_DENSITY);
					
					// String
				
						writeString(this.OPENING_BSW_LEVEL,dos);
					
					// String
				
						writeString(this.CLOSING_BSW_LEVEL,dos);
					
					// int
				
		            	dos.writeInt(this.BULK_FRAC_DISPOSALS);
					
					// int
				
		            	dos.writeInt(this.BULK_FRAC_RECEIPTS);
					
					// int
				
		            	dos.writeInt(this.VIRTUAL_TANK);
					
					// double
				
		            	dos.writeDouble(this.OPENING_COE);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_COE);
					
					// int
				
		            	dos.writeInt(this.OPENING_LINE_SEGMENT_NSV);
					
					// int
				
		            	dos.writeInt(this.CLOSING_LINE_SEGMENT_NSV);
					
					// int
				
		            	dos.writeInt(this.OPENING_TOV);
					
					// int
				
		            	dos.writeInt(this.CLOSING_TOV);
					
					// int
				
		            	dos.writeInt(this.OPENING_GOV);
					
					// int
				
		            	dos.writeInt(this.CLOSING_GOV);
					
					// int
				
		            	dos.writeInt(this.OPENING_GSV);
					
					// int
				
		            	dos.writeInt(this.CLOSING_GSV);
					
					// int
				
		            	dos.writeInt(this.OPENING_TCV);
					
					// int
				
		            	dos.writeInt(this.CLOSING_TCV);
					
					// double
				
		            	dos.writeDouble(this.OPENING_CTL);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_CTL);
					
					// double
				
		            	dos.writeDouble(this.OPENING_SHELL_CORRECTION_FACTO);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_SHELL_CORRECTION_FACTO);
					
					// int
				
		            	dos.writeInt(this.OPENING_FLOATING_ROOF_ADJUSTME);
					
					// int
				
		            	dos.writeInt(this.CLOSING_FLOATING_ROOF_ADJUSTME);
					
					// double
				
		            	dos.writeDouble(this.OPENING_AMBIENT_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_AMBIENT_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.OPENING_SUSPENDED_BSW_PERCENT);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_SUSPENDED_BSW_PERCENT);
					
					// String
				
						writeString(this.OPENING_GAUGER_INITIALS,dos);
					
					// String
				
						writeString(this.CLOSING_GAUGER_INITIALS,dos);
					
					// java.util.Date
				
						writeDate(this.OPENING_GAUGE_TIMESTAMP,dos);
					
					// java.util.Date
				
						writeDate(this.CLOSING_GAUGE_TIMESTAMP,dos);
					
					// int
				
		            	dos.writeInt(this.OPENING_PRODUCT_STRAP_TYPE);
					
					// int
				
		            	dos.writeInt(this.CLOSING_PRODUCT_STRAP_TYPE);
					
					// int
				
		            	dos.writeInt(this.OPENING_BSW_STRAP_TYPE);
					
					// int
				
		            	dos.writeInt(this.CLOSING_BSW_STRAP_TYPE);
					
					// int
				
		            	dos.writeInt(this.OPENING_GSW);
					
					// int
				
		            	dos.writeInt(this.CLOSING_GSW);
					
					// int
				
		            	dos.writeInt(this.OPENING_NSW);
					
					// int
				
		            	dos.writeInt(this.CLOSING_NSW);
					
					// double
				
		            	dos.writeDouble(this.OPENING_WCF);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_WCF);
					
					// int
				
		            	dos.writeInt(this.OPENING_LINE_SEGMENT_NSW);
					
					// int
				
		            	dos.writeInt(this.CLOSING_LINE_SEGMENT_NSW);
					
					// int
				
		            	dos.writeInt(this.OPENING_NSV);
					
					// int
				
		            	dos.writeInt(this.CLOSING_NSV);
					
					// int
				
		            	dos.writeInt(this.OPENING_XCTN_GROSS_QTY);
					
					// int
				
		            	dos.writeInt(this.CLOSING_XCTN_GROSS_QTY);
					
					// int
				
		            	dos.writeInt(this.OPENING_XCTN_FRAC_GROSS_QTY);
					
					// int
				
		            	dos.writeInt(this.CLOSING_XCTN_FRAC_GROSS_QTY);
					
					// int
				
		            	dos.writeInt(this.OPENING_XCTN_NET_QTY);
					
					// int
				
		            	dos.writeInt(this.CLOSING_XCTN_NET_QTY);
					
					// int
				
		            	dos.writeInt(this.OPENING_XCTN_FRAC_NET_QTY);
					
					// int
				
		            	dos.writeInt(this.CLOSING_XCTN_FRAC_NET_QTY);
					
					// int
				
		            	dos.writeInt(this.OPENING_CALCULATION_POINT);
					
					// int
				
		            	dos.writeInt(this.CLOSING_CALCULATION_POINT);
					
					// int
				
		            	dos.writeInt(this.MANUAL_OPENING_PHYSICAL);
					
					// String
				
						writeString(this.OPENING_API_CODE,dos);
					
					// String
				
						writeString(this.CLOSING_API_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.OPENING_WEIGHT_IN_AIR);
					
					// int
				
		            	dos.writeInt(this.CLOSING_WEIGHT_IN_AIR);
					
					// int
				
		            	dos.writeInt(this.OPENING_XCTN_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.OPENING_XCTN_FRAC_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.CLOSING_XCTN_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.CLOSING_XCTN_FRAC_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.OPENING_VAPOR_CORRECT_METHOD);
					
					// int
				
		            	dos.writeInt(this.CLOSING_VAPOR_CORRECT_METHOD);
					
					// double
				
		            	dos.writeDouble(this.OPENING_VAPOR_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_VAPOR_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.OPENING_VAPOR_LIQUID_VOL_RATIO);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_VAPOR_LIQUID_VOL_RATIO);
					
					// int
				
		            	dos.writeInt(this.INVENTORY_QUANTITY_TYPE);
					
					// double
				
		            	dos.writeDouble(this.OPENING_PRESSURE);
					
					// double
				
		            	dos.writeDouble(this.CLOSING_PRESSURE);
					
					// int
				
		            	dos.writeInt(this.OPENING_XCTN_WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.OPENING_XCTN_FRAC_WGT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.CLOSING_XCTN_WEIGHT_IN_VAC);
					
					// int
				
		            	dos.writeInt(this.CLOSING_XCTN_FRAC_WGT_IN_VAC);
					
					// Integer
				
						writeInteger(this.MAJORITY_SHAREHOLDER,dos);
					
					// int
				
		            	dos.writeInt(this.OPENING_INVENTORY_ENABLE);
					
					// int
				
		            	dos.writeInt(this.CLOSING_INVENTORY_ENABLE);
					
					// int
				
		            	dos.writeInt(this.OPENING_LEVEL_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.CLOSING_LEVEL_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.OPENING_TOV_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.CLOSING_TOV_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.OPENING_TEMPERATURE_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.CLOSING_TEMPERATURE_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.OPENING_DENSITY_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.CLOSING_DENSITY_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.OPENING_NSV_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.CLOSING_NSV_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.OPENING_VAPOR_TEMP_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.CLOSING_VAPOR_TEMP_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.OPENING_PRESSURE_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.CLOSING_PRESSURE_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.OPENING_FREE_WATER_LVL_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.CLOSING_FREE_WATER_LVL_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.OPENING_WATER_QTY_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.CLOSING_WATER_QTY_ORIGIN);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_OWNER_ID,dos);
					
					// String
				
						writeString(this.COMPARTMENT_CONTAINER_CODE,dos);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_CONTAINER_TYPE,dos);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.COMPARTMENT_VISIT_NUMBER);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("TERMINAL_PRODUCT_NUMBER="+String.valueOf(TERMINAL_PRODUCT_NUMBER));
		sb.append(",FOLIO_NUMBER="+FOLIO_NUMBER);
		sb.append(",TANK_CODE="+TANK_CODE);
		sb.append(",GAIN_LOSS_ID="+String.valueOf(GAIN_LOSS_ID));
		sb.append(",TANK_GROUP="+TANK_GROUP);
		sb.append(",PRODUCT_GROUP_CODE="+PRODUCT_GROUP_CODE);
		sb.append(",OPENING_PHYSICAL="+String.valueOf(OPENING_PHYSICAL));
		sb.append(",BULK_RECEIPTS="+String.valueOf(BULK_RECEIPTS));
		sb.append(",BULK_TRANSFERS_IN="+String.valueOf(BULK_TRANSFERS_IN));
		sb.append(",BULK_DISPOSALS="+String.valueOf(BULK_DISPOSALS));
		sb.append(",BULK_TRANSFERS_OUT="+String.valueOf(BULK_TRANSFERS_OUT));
		sb.append(",RACK_RECEIPTS="+String.valueOf(RACK_RECEIPTS));
		sb.append(",RACK_DISPOSALS="+String.valueOf(RACK_DISPOSALS));
		sb.append(",CLOSING_PHYSICAL="+String.valueOf(CLOSING_PHYSICAL));
		sb.append(",MANUAL_CLOSING_PHYSICAL="+String.valueOf(MANUAL_CLOSING_PHYSICAL));
		sb.append(",GAIN_LOSS="+String.valueOf(GAIN_LOSS));
		sb.append(",RACK_FRAC_RECEIPTS="+String.valueOf(RACK_FRAC_RECEIPTS));
		sb.append(",RACK_FRAC_DISPOSALS="+String.valueOf(RACK_FRAC_DISPOSALS));
		sb.append(",BULK_FRAC_TRANSFERS_IN="+String.valueOf(BULK_FRAC_TRANSFERS_IN));
		sb.append(",BULK_FRAC_TRANSFERS_OUT="+String.valueOf(BULK_FRAC_TRANSFERS_OUT));
		sb.append(",ADD_BULK_RECEIPTS="+String.valueOf(ADD_BULK_RECEIPTS));
		sb.append(",ADD_RACK_RECEIPTS="+String.valueOf(ADD_RACK_RECEIPTS));
		sb.append(",ADD_TRANSFERS_IN="+String.valueOf(ADD_TRANSFERS_IN));
		sb.append(",ADD_BULK_DISPOSALS="+String.valueOf(ADD_BULK_DISPOSALS));
		sb.append(",ADD_RACK_DISPOSALS="+String.valueOf(ADD_RACK_DISPOSALS));
		sb.append(",ADD_TRANSFERS_OUT="+String.valueOf(ADD_TRANSFERS_OUT));
		sb.append(",ADD_GAIN_LOSS="+String.valueOf(ADD_GAIN_LOSS));
		sb.append(",PIPE_FILL="+String.valueOf(PIPE_FILL));
		sb.append(",OPENING_PHYSICAL_GROSS_QTY="+String.valueOf(OPENING_PHYSICAL_GROSS_QTY));
		sb.append(",CLOSING_PHYSICAL_GROSS_QTY="+String.valueOf(CLOSING_PHYSICAL_GROSS_QTY));
		sb.append(",OPENING_TEMPERATURE="+String.valueOf(OPENING_TEMPERATURE));
		sb.append(",CLOSING_TEMPERATURE="+String.valueOf(CLOSING_TEMPERATURE));
		sb.append(",OPENING_DENSITY="+String.valueOf(OPENING_DENSITY));
		sb.append(",CLOSING_DENSITY="+String.valueOf(CLOSING_DENSITY));
		sb.append(",OPENING_BSW_QTY="+String.valueOf(OPENING_BSW_QTY));
		sb.append(",CLOSING_BSW_QTY="+String.valueOf(CLOSING_BSW_QTY));
		sb.append(",OPENING_LEVEL="+OPENING_LEVEL);
		sb.append(",CLOSING_LEVEL="+CLOSING_LEVEL);
		sb.append(",OPENING_OBSERVED_DENSITY="+String.valueOf(OPENING_OBSERVED_DENSITY));
		sb.append(",CLOSING_OBSERVED_DENSITY="+String.valueOf(CLOSING_OBSERVED_DENSITY));
		sb.append(",OPENING_BSW_LEVEL="+OPENING_BSW_LEVEL);
		sb.append(",CLOSING_BSW_LEVEL="+CLOSING_BSW_LEVEL);
		sb.append(",BULK_FRAC_DISPOSALS="+String.valueOf(BULK_FRAC_DISPOSALS));
		sb.append(",BULK_FRAC_RECEIPTS="+String.valueOf(BULK_FRAC_RECEIPTS));
		sb.append(",VIRTUAL_TANK="+String.valueOf(VIRTUAL_TANK));
		sb.append(",OPENING_COE="+String.valueOf(OPENING_COE));
		sb.append(",CLOSING_COE="+String.valueOf(CLOSING_COE));
		sb.append(",OPENING_LINE_SEGMENT_NSV="+String.valueOf(OPENING_LINE_SEGMENT_NSV));
		sb.append(",CLOSING_LINE_SEGMENT_NSV="+String.valueOf(CLOSING_LINE_SEGMENT_NSV));
		sb.append(",OPENING_TOV="+String.valueOf(OPENING_TOV));
		sb.append(",CLOSING_TOV="+String.valueOf(CLOSING_TOV));
		sb.append(",OPENING_GOV="+String.valueOf(OPENING_GOV));
		sb.append(",CLOSING_GOV="+String.valueOf(CLOSING_GOV));
		sb.append(",OPENING_GSV="+String.valueOf(OPENING_GSV));
		sb.append(",CLOSING_GSV="+String.valueOf(CLOSING_GSV));
		sb.append(",OPENING_TCV="+String.valueOf(OPENING_TCV));
		sb.append(",CLOSING_TCV="+String.valueOf(CLOSING_TCV));
		sb.append(",OPENING_CTL="+String.valueOf(OPENING_CTL));
		sb.append(",CLOSING_CTL="+String.valueOf(CLOSING_CTL));
		sb.append(",OPENING_SHELL_CORRECTION_FACTO="+String.valueOf(OPENING_SHELL_CORRECTION_FACTO));
		sb.append(",CLOSING_SHELL_CORRECTION_FACTO="+String.valueOf(CLOSING_SHELL_CORRECTION_FACTO));
		sb.append(",OPENING_FLOATING_ROOF_ADJUSTME="+String.valueOf(OPENING_FLOATING_ROOF_ADJUSTME));
		sb.append(",CLOSING_FLOATING_ROOF_ADJUSTME="+String.valueOf(CLOSING_FLOATING_ROOF_ADJUSTME));
		sb.append(",OPENING_AMBIENT_TEMPERATURE="+String.valueOf(OPENING_AMBIENT_TEMPERATURE));
		sb.append(",CLOSING_AMBIENT_TEMPERATURE="+String.valueOf(CLOSING_AMBIENT_TEMPERATURE));
		sb.append(",OPENING_SUSPENDED_BSW_PERCENT="+String.valueOf(OPENING_SUSPENDED_BSW_PERCENT));
		sb.append(",CLOSING_SUSPENDED_BSW_PERCENT="+String.valueOf(CLOSING_SUSPENDED_BSW_PERCENT));
		sb.append(",OPENING_GAUGER_INITIALS="+OPENING_GAUGER_INITIALS);
		sb.append(",CLOSING_GAUGER_INITIALS="+CLOSING_GAUGER_INITIALS);
		sb.append(",OPENING_GAUGE_TIMESTAMP="+String.valueOf(OPENING_GAUGE_TIMESTAMP));
		sb.append(",CLOSING_GAUGE_TIMESTAMP="+String.valueOf(CLOSING_GAUGE_TIMESTAMP));
		sb.append(",OPENING_PRODUCT_STRAP_TYPE="+String.valueOf(OPENING_PRODUCT_STRAP_TYPE));
		sb.append(",CLOSING_PRODUCT_STRAP_TYPE="+String.valueOf(CLOSING_PRODUCT_STRAP_TYPE));
		sb.append(",OPENING_BSW_STRAP_TYPE="+String.valueOf(OPENING_BSW_STRAP_TYPE));
		sb.append(",CLOSING_BSW_STRAP_TYPE="+String.valueOf(CLOSING_BSW_STRAP_TYPE));
		sb.append(",OPENING_GSW="+String.valueOf(OPENING_GSW));
		sb.append(",CLOSING_GSW="+String.valueOf(CLOSING_GSW));
		sb.append(",OPENING_NSW="+String.valueOf(OPENING_NSW));
		sb.append(",CLOSING_NSW="+String.valueOf(CLOSING_NSW));
		sb.append(",OPENING_WCF="+String.valueOf(OPENING_WCF));
		sb.append(",CLOSING_WCF="+String.valueOf(CLOSING_WCF));
		sb.append(",OPENING_LINE_SEGMENT_NSW="+String.valueOf(OPENING_LINE_SEGMENT_NSW));
		sb.append(",CLOSING_LINE_SEGMENT_NSW="+String.valueOf(CLOSING_LINE_SEGMENT_NSW));
		sb.append(",OPENING_NSV="+String.valueOf(OPENING_NSV));
		sb.append(",CLOSING_NSV="+String.valueOf(CLOSING_NSV));
		sb.append(",OPENING_XCTN_GROSS_QTY="+String.valueOf(OPENING_XCTN_GROSS_QTY));
		sb.append(",CLOSING_XCTN_GROSS_QTY="+String.valueOf(CLOSING_XCTN_GROSS_QTY));
		sb.append(",OPENING_XCTN_FRAC_GROSS_QTY="+String.valueOf(OPENING_XCTN_FRAC_GROSS_QTY));
		sb.append(",CLOSING_XCTN_FRAC_GROSS_QTY="+String.valueOf(CLOSING_XCTN_FRAC_GROSS_QTY));
		sb.append(",OPENING_XCTN_NET_QTY="+String.valueOf(OPENING_XCTN_NET_QTY));
		sb.append(",CLOSING_XCTN_NET_QTY="+String.valueOf(CLOSING_XCTN_NET_QTY));
		sb.append(",OPENING_XCTN_FRAC_NET_QTY="+String.valueOf(OPENING_XCTN_FRAC_NET_QTY));
		sb.append(",CLOSING_XCTN_FRAC_NET_QTY="+String.valueOf(CLOSING_XCTN_FRAC_NET_QTY));
		sb.append(",OPENING_CALCULATION_POINT="+String.valueOf(OPENING_CALCULATION_POINT));
		sb.append(",CLOSING_CALCULATION_POINT="+String.valueOf(CLOSING_CALCULATION_POINT));
		sb.append(",MANUAL_OPENING_PHYSICAL="+String.valueOf(MANUAL_OPENING_PHYSICAL));
		sb.append(",OPENING_API_CODE="+OPENING_API_CODE);
		sb.append(",CLOSING_API_CODE="+CLOSING_API_CODE);
		sb.append(",OPENING_WEIGHT_IN_AIR="+String.valueOf(OPENING_WEIGHT_IN_AIR));
		sb.append(",CLOSING_WEIGHT_IN_AIR="+String.valueOf(CLOSING_WEIGHT_IN_AIR));
		sb.append(",OPENING_XCTN_WEIGHT="+String.valueOf(OPENING_XCTN_WEIGHT));
		sb.append(",OPENING_XCTN_FRAC_WEIGHT="+String.valueOf(OPENING_XCTN_FRAC_WEIGHT));
		sb.append(",CLOSING_XCTN_WEIGHT="+String.valueOf(CLOSING_XCTN_WEIGHT));
		sb.append(",CLOSING_XCTN_FRAC_WEIGHT="+String.valueOf(CLOSING_XCTN_FRAC_WEIGHT));
		sb.append(",OPENING_VAPOR_CORRECT_METHOD="+String.valueOf(OPENING_VAPOR_CORRECT_METHOD));
		sb.append(",CLOSING_VAPOR_CORRECT_METHOD="+String.valueOf(CLOSING_VAPOR_CORRECT_METHOD));
		sb.append(",OPENING_VAPOR_TEMPERATURE="+String.valueOf(OPENING_VAPOR_TEMPERATURE));
		sb.append(",CLOSING_VAPOR_TEMPERATURE="+String.valueOf(CLOSING_VAPOR_TEMPERATURE));
		sb.append(",OPENING_VAPOR_LIQUID_VOL_RATIO="+String.valueOf(OPENING_VAPOR_LIQUID_VOL_RATIO));
		sb.append(",CLOSING_VAPOR_LIQUID_VOL_RATIO="+String.valueOf(CLOSING_VAPOR_LIQUID_VOL_RATIO));
		sb.append(",INVENTORY_QUANTITY_TYPE="+String.valueOf(INVENTORY_QUANTITY_TYPE));
		sb.append(",OPENING_PRESSURE="+String.valueOf(OPENING_PRESSURE));
		sb.append(",CLOSING_PRESSURE="+String.valueOf(CLOSING_PRESSURE));
		sb.append(",OPENING_XCTN_WEIGHT_IN_VAC="+String.valueOf(OPENING_XCTN_WEIGHT_IN_VAC));
		sb.append(",OPENING_XCTN_FRAC_WGT_IN_VAC="+String.valueOf(OPENING_XCTN_FRAC_WGT_IN_VAC));
		sb.append(",CLOSING_XCTN_WEIGHT_IN_VAC="+String.valueOf(CLOSING_XCTN_WEIGHT_IN_VAC));
		sb.append(",CLOSING_XCTN_FRAC_WGT_IN_VAC="+String.valueOf(CLOSING_XCTN_FRAC_WGT_IN_VAC));
		sb.append(",MAJORITY_SHAREHOLDER="+String.valueOf(MAJORITY_SHAREHOLDER));
		sb.append(",OPENING_INVENTORY_ENABLE="+String.valueOf(OPENING_INVENTORY_ENABLE));
		sb.append(",CLOSING_INVENTORY_ENABLE="+String.valueOf(CLOSING_INVENTORY_ENABLE));
		sb.append(",OPENING_LEVEL_ORIGIN="+String.valueOf(OPENING_LEVEL_ORIGIN));
		sb.append(",CLOSING_LEVEL_ORIGIN="+String.valueOf(CLOSING_LEVEL_ORIGIN));
		sb.append(",OPENING_TOV_ORIGIN="+String.valueOf(OPENING_TOV_ORIGIN));
		sb.append(",CLOSING_TOV_ORIGIN="+String.valueOf(CLOSING_TOV_ORIGIN));
		sb.append(",OPENING_TEMPERATURE_ORIGIN="+String.valueOf(OPENING_TEMPERATURE_ORIGIN));
		sb.append(",CLOSING_TEMPERATURE_ORIGIN="+String.valueOf(CLOSING_TEMPERATURE_ORIGIN));
		sb.append(",OPENING_DENSITY_ORIGIN="+String.valueOf(OPENING_DENSITY_ORIGIN));
		sb.append(",CLOSING_DENSITY_ORIGIN="+String.valueOf(CLOSING_DENSITY_ORIGIN));
		sb.append(",OPENING_NSV_ORIGIN="+String.valueOf(OPENING_NSV_ORIGIN));
		sb.append(",CLOSING_NSV_ORIGIN="+String.valueOf(CLOSING_NSV_ORIGIN));
		sb.append(",OPENING_VAPOR_TEMP_ORIGIN="+String.valueOf(OPENING_VAPOR_TEMP_ORIGIN));
		sb.append(",CLOSING_VAPOR_TEMP_ORIGIN="+String.valueOf(CLOSING_VAPOR_TEMP_ORIGIN));
		sb.append(",OPENING_PRESSURE_ORIGIN="+String.valueOf(OPENING_PRESSURE_ORIGIN));
		sb.append(",CLOSING_PRESSURE_ORIGIN="+String.valueOf(CLOSING_PRESSURE_ORIGIN));
		sb.append(",OPENING_FREE_WATER_LVL_ORIGIN="+String.valueOf(OPENING_FREE_WATER_LVL_ORIGIN));
		sb.append(",CLOSING_FREE_WATER_LVL_ORIGIN="+String.valueOf(CLOSING_FREE_WATER_LVL_ORIGIN));
		sb.append(",OPENING_WATER_QTY_ORIGIN="+String.valueOf(OPENING_WATER_QTY_ORIGIN));
		sb.append(",CLOSING_WATER_QTY_ORIGIN="+String.valueOf(CLOSING_WATER_QTY_ORIGIN));
		sb.append(",COMPARTMENT_OWNER_ID="+String.valueOf(COMPARTMENT_OWNER_ID));
		sb.append(",COMPARTMENT_CONTAINER_CODE="+COMPARTMENT_CONTAINER_CODE);
		sb.append(",COMPARTMENT_CONTAINER_TYPE="+String.valueOf(COMPARTMENT_CONTAINER_TYPE));
		sb.append(",COMPARTMENT_NUMBER="+String.valueOf(COMPARTMENT_NUMBER));
		sb.append(",COMPARTMENT_VISIT_NUMBER="+String.valueOf(COMPARTMENT_VISIT_NUMBER));
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
        } else if (updateKeyCount_tDBOutput_1 == 66 && true) {
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

 
	final String decryptedPassword_tDBOutput_1 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:Iu7yEmdfLplmPia7vRNPe0Ias0T68ecfls1jrIhY4XjFP0oheJc=");

    String dbPwd_tDBOutput_1 = decryptedPassword_tDBOutput_1;	
    conn_tDBOutput_1 = java.sql.DriverManager.getConnection(url_tDBOutput_1,dbUser_tDBOutput_1,dbPwd_tDBOutput_1);
	
		resourceMap.put("conn_tDBOutput_1", conn_tDBOutput_1);
	
        conn_tDBOutput_1.setAutoCommit(false);
        int commitEvery_tDBOutput_1 = 10000;
        int commitCounter_tDBOutput_1 = 0;


if(dbschema_tDBOutput_1 == null || dbschema_tDBOutput_1.trim().length() == 0) {
    tableName_tDBOutput_1 = "DIM_GAIN_LOSS_HISTORY";
} else {
    tableName_tDBOutput_1 = dbschema_tDBOutput_1 + "].[" + "DIM_GAIN_LOSS_HISTORY";
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
                                        stmtCreate_tDBOutput_1.execute("CREATE TABLE [" + tableName_tDBOutput_1 + "]([PK_GAIN_LOSS_HISTORY] INT ,[TERMINAL_PRODUCT_NUMBER] INT  not null ,[DATE] DATETIME  not null ,[FOLIO_NUMBER] VARCHAR(8)   not null ,[TANK_CODE] VARCHAR(20)   not null ,[GAIN_LOSS_ID] INT  not null ,[PRODUCT_GROUP_CODE] VARCHAR(6)   not null ,[OPENING_PHYSICAL] INT  not null ,[BULK_RECEIPTS] INT  not null ,[BULK_TRANSFERS_IN] INT  not null ,[BULK_TRANSFERS_OUT] INT  not null ,[RACK_DISPOSALS] INT  not null ,[CLOSING_PHYSICAL] INT  not null ,[GAIN_LOSS] INT  not null ,[OPENING_PHYSICAL_GROSS_QTY] INT  not null ,[CLOSING_PHYSICAL_GROSS_QTY] INT  not null ,[OPENING_TEMPERATURE] FLOAT(53)   not null ,[CLOSING_TEMPERATURE] FLOAT(53)   not null ,[OPENING_DENSITY] FLOAT(53)   not null ,[CLOSING_DENSITY] FLOAT(53)   not null ,[OPENING_BSW_QTY] INT  not null ,[CLOSING_BSW_QTY] INT  not null ,[OPENING_LEVEL] VARCHAR(7)   not null ,[CLOSING_LEVEL] VARCHAR(7)   not null ,[OPENING_OBSERVED_DENSITY] FLOAT(53)   not null ,[CLOSING_OBSERVED_DENSITY] FLOAT(53)   not null ,[OPENING_BSW_LEVEL] VARCHAR(7)   not null ,[CLOSING_BSW_LEVEL] VARCHAR(7)   not null ,[OPENING_TOV] INT  not null ,[CLOSING_TOV] INT  not null ,[OPENING_GOV] INT  not null ,[CLOSING_GOV] INT  not null ,[OPENING_GSV] INT  not null ,[CLOSING_GSV] INT  not null ,[OPENING_TCV] INT  not null ,[CLOSING_TCV] INT  not null ,[OPENING_CTL] FLOAT(53)   not null ,[CLOSING_CTL] FLOAT(53)   not null ,[OPENING_AMBIENT_TEMPERATURE] FLOAT(53)   not null ,[CLOSING_AMBIENT_TEMPERATURE] FLOAT(53)   not null ,[OPENING_GSW] INT  not null ,[CLOSING_GSW] INT  not null ,[OPENING_NSW] INT  not null ,[CLOSING_NSW] INT  not null ,[OPENING_WCF] FLOAT(53)   not null ,[CLOSING_WCF] FLOAT(53)   not null ,[OPENING_NSV] INT  not null ,[CLOSING_NSV] INT  not null ,[OPENING_XCTN_GROSS_QTY] INT  not null ,[CLOSING_XCTN_GROSS_QTY] INT  not null ,[OPENING_XCTN_NET_QTY] INT  not null ,[CLOSING_XCTN_NET_QTY] INT  not null ,[OPENING_WEIGHT_IN_AIR] INT  not null ,[CLOSING_WEIGHT_IN_AIR] INT  not null ,[OPENING_XCTN_WEIGHT] INT  not null ,[CLOSING_XCTN_WEIGHT] INT  not null ,[OPENING_CALCULATION_POINT] INT  not null ,[CLOSING_CALCULATION_POINT] INT  not null ,[OPENING_PRODUCT_STRAP_TYPE] INT  not null ,[OPENING_API_CODE] VARCHAR(4)  ,[CLOSING_PRODUCT_STRAP_TYPE] INT  not null ,[CLOSING_API_CODE] VARCHAR(4)  ,[OPENING_TEMPERATURE_ORIGIN] INT  not null ,[CLOSING_TEMPERATURE_ORIGIN] INT  not null ,[INVENTORY_QUANTITY_TYPE] INT  not null ,[COMPARTMENT_VISIT_NUMBER] INT  not null ,primary key([PK_GAIN_LOSS_HISTORY]))");
                                    }
                                }
        java.sql.PreparedStatement pstmt_tDBOutput_1 = conn_tDBOutput_1.prepareStatement("SELECT COUNT(1) FROM [" + tableName_tDBOutput_1 + "] WHERE [PK_GAIN_LOSS_HISTORY] = ?");
        resourceMap.put("pstmt_tDBOutput_1", pstmt_tDBOutput_1);
        String insert_tDBOutput_1 = "INSERT INTO [" + tableName_tDBOutput_1 + "] ([PK_GAIN_LOSS_HISTORY],[TERMINAL_PRODUCT_NUMBER],[DATE],[FOLIO_NUMBER],[TANK_CODE],[GAIN_LOSS_ID],[PRODUCT_GROUP_CODE],[OPENING_PHYSICAL],[BULK_RECEIPTS],[BULK_TRANSFERS_IN],[BULK_TRANSFERS_OUT],[RACK_DISPOSALS],[CLOSING_PHYSICAL],[GAIN_LOSS],[OPENING_PHYSICAL_GROSS_QTY],[CLOSING_PHYSICAL_GROSS_QTY],[OPENING_TEMPERATURE],[CLOSING_TEMPERATURE],[OPENING_DENSITY],[CLOSING_DENSITY],[OPENING_BSW_QTY],[CLOSING_BSW_QTY],[OPENING_LEVEL],[CLOSING_LEVEL],[OPENING_OBSERVED_DENSITY],[CLOSING_OBSERVED_DENSITY],[OPENING_BSW_LEVEL],[CLOSING_BSW_LEVEL],[OPENING_TOV],[CLOSING_TOV],[OPENING_GOV],[CLOSING_GOV],[OPENING_GSV],[CLOSING_GSV],[OPENING_TCV],[CLOSING_TCV],[OPENING_CTL],[CLOSING_CTL],[OPENING_AMBIENT_TEMPERATURE],[CLOSING_AMBIENT_TEMPERATURE],[OPENING_GSW],[CLOSING_GSW],[OPENING_NSW],[CLOSING_NSW],[OPENING_WCF],[CLOSING_WCF],[OPENING_NSV],[CLOSING_NSV],[OPENING_XCTN_GROSS_QTY],[CLOSING_XCTN_GROSS_QTY],[OPENING_XCTN_NET_QTY],[CLOSING_XCTN_NET_QTY],[OPENING_WEIGHT_IN_AIR],[CLOSING_WEIGHT_IN_AIR],[OPENING_XCTN_WEIGHT],[CLOSING_XCTN_WEIGHT],[OPENING_CALCULATION_POINT],[CLOSING_CALCULATION_POINT],[OPENING_PRODUCT_STRAP_TYPE],[OPENING_API_CODE],[CLOSING_PRODUCT_STRAP_TYPE],[CLOSING_API_CODE],[OPENING_TEMPERATURE_ORIGIN],[CLOSING_TEMPERATURE_ORIGIN],[INVENTORY_QUANTITY_TYPE],[COMPARTMENT_VISIT_NUMBER]) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        java.sql.PreparedStatement pstmtInsert_tDBOutput_1 = conn_tDBOutput_1.prepareStatement(insert_tDBOutput_1);
        resourceMap.put("pstmtInsert_tDBOutput_1", pstmtInsert_tDBOutput_1);
        String update_tDBOutput_1 = "UPDATE [" + tableName_tDBOutput_1 + "] SET [TERMINAL_PRODUCT_NUMBER] = ?,[DATE] = ?,[FOLIO_NUMBER] = ?,[TANK_CODE] = ?,[GAIN_LOSS_ID] = ?,[PRODUCT_GROUP_CODE] = ?,[OPENING_PHYSICAL] = ?,[BULK_RECEIPTS] = ?,[BULK_TRANSFERS_IN] = ?,[BULK_TRANSFERS_OUT] = ?,[RACK_DISPOSALS] = ?,[CLOSING_PHYSICAL] = ?,[GAIN_LOSS] = ?,[OPENING_PHYSICAL_GROSS_QTY] = ?,[CLOSING_PHYSICAL_GROSS_QTY] = ?,[OPENING_TEMPERATURE] = ?,[CLOSING_TEMPERATURE] = ?,[OPENING_DENSITY] = ?,[CLOSING_DENSITY] = ?,[OPENING_BSW_QTY] = ?,[CLOSING_BSW_QTY] = ?,[OPENING_LEVEL] = ?,[CLOSING_LEVEL] = ?,[OPENING_OBSERVED_DENSITY] = ?,[CLOSING_OBSERVED_DENSITY] = ?,[OPENING_BSW_LEVEL] = ?,[CLOSING_BSW_LEVEL] = ?,[OPENING_TOV] = ?,[CLOSING_TOV] = ?,[OPENING_GOV] = ?,[CLOSING_GOV] = ?,[OPENING_GSV] = ?,[CLOSING_GSV] = ?,[OPENING_TCV] = ?,[CLOSING_TCV] = ?,[OPENING_CTL] = ?,[CLOSING_CTL] = ?,[OPENING_AMBIENT_TEMPERATURE] = ?,[CLOSING_AMBIENT_TEMPERATURE] = ?,[OPENING_GSW] = ?,[CLOSING_GSW] = ?,[OPENING_NSW] = ?,[CLOSING_NSW] = ?,[OPENING_WCF] = ?,[CLOSING_WCF] = ?,[OPENING_NSV] = ?,[CLOSING_NSV] = ?,[OPENING_XCTN_GROSS_QTY] = ?,[CLOSING_XCTN_GROSS_QTY] = ?,[OPENING_XCTN_NET_QTY] = ?,[CLOSING_XCTN_NET_QTY] = ?,[OPENING_WEIGHT_IN_AIR] = ?,[CLOSING_WEIGHT_IN_AIR] = ?,[OPENING_XCTN_WEIGHT] = ?,[CLOSING_XCTN_WEIGHT] = ?,[OPENING_CALCULATION_POINT] = ?,[CLOSING_CALCULATION_POINT] = ?,[OPENING_PRODUCT_STRAP_TYPE] = ?,[OPENING_API_CODE] = ?,[CLOSING_PRODUCT_STRAP_TYPE] = ?,[CLOSING_API_CODE] = ?,[OPENING_TEMPERATURE_ORIGIN] = ?,[CLOSING_TEMPERATURE_ORIGIN] = ?,[INVENTORY_QUANTITY_TYPE] = ?,[COMPARTMENT_VISIT_NUMBER] = ? WHERE [PK_GAIN_LOSS_HISTORY] = ?";
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
	int PK_GAIN_LOSS_HIS;
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
	
	        
					int TERMINAL_PRODUCT_NUMBER;
					String FOLIO_NUMBER;
					String TANK_CODE;        
	        
		    @Override
			public int hashCode() {
				if (this.hashCodeDirty) {
					final int prime = PRIME;
					int result = DEFAULT_HASHCODE;
			
									result = prime * result + (int) this.TERMINAL_PRODUCT_NUMBER;
									
								result = prime * result + ((this.FOLIO_NUMBER == null) ? 0 : this.FOLIO_NUMBER.hashCode());
								
								result = prime * result + ((this.TANK_CODE == null) ? 0 : this.TANK_CODE.hashCode());
								
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
				
									if (this.TERMINAL_PRODUCT_NUMBER != other.TERMINAL_PRODUCT_NUMBER) 
										return false;
								
									if (this.FOLIO_NUMBER == null) {
										if (other.FOLIO_NUMBER != null) 
											return false;
								
									} else if (!this.FOLIO_NUMBER.equals(other.FOLIO_NUMBER))
								 
										return false;
								
									if (this.TANK_CODE == null) {
										if (other.TANK_CODE != null) 
											return false;
								
									} else if (!this.TANK_CODE.equals(other.TANK_CODE))
								 
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
				
				 
	final String decryptedPassword_tDBInput_1 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:DmPqvFYAg5kZfaiKSWPerWVuJkhDECQtN8Cdw69azVob7pZGluc=");
				
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

		    String dbquery_tDBInput_1 = "SELECT dbo.GAIN_LOSS_HISTORY.TERMINAL_PRODUCT_NUMBER,\n		dbo.GAIN_LOSS_HISTORY.FOLIO_NUMBER,\n		dbo.GAIN_LOSS_HISTORY.TAN"
+"K_CODE,\n		dbo.GAIN_LOSS_HISTORY.GAIN_LOSS_ID,\n		dbo.GAIN_LOSS_HISTORY.TANK_GROUP,\n		dbo.GAIN_LOSS_HISTORY.PRODUCT_GROUP_"
+"CODE,\n		dbo.GAIN_LOSS_HISTORY.OPENING_PHYSICAL,\n		dbo.GAIN_LOSS_HISTORY.BULK_RECEIPTS,\n		dbo.GAIN_LOSS_HISTORY.BULK_TRAN"
+"SFERS_IN,\n		dbo.GAIN_LOSS_HISTORY.BULK_DISPOSALS,\n		dbo.GAIN_LOSS_HISTORY.BULK_TRANSFERS_OUT,\n		dbo.GAIN_LOSS_HISTORY.RA"
+"CK_RECEIPTS,\n		dbo.GAIN_LOSS_HISTORY.RACK_DISPOSALS,\n		dbo.GAIN_LOSS_HISTORY.CLOSING_PHYSICAL,\n		dbo.GAIN_LOSS_HISTORY.M"
+"ANUAL_CLOSING_PHYSICAL,\n		dbo.GAIN_LOSS_HISTORY.GAIN_LOSS,\n		dbo.GAIN_LOSS_HISTORY.RACK_FRAC_RECEIPTS,\n		dbo.GAIN_LOSS_H"
+"ISTORY.RACK_FRAC_DISPOSALS,\n		dbo.GAIN_LOSS_HISTORY.BULK_FRAC_TRANSFERS_IN,\n		dbo.GAIN_LOSS_HISTORY.BULK_FRAC_TRANSFERS_"
+"OUT,\n		dbo.GAIN_LOSS_HISTORY.ADD_BULK_RECEIPTS,\n		dbo.GAIN_LOSS_HISTORY.ADD_RACK_RECEIPTS,\n		dbo.GAIN_LOSS_HISTORY.ADD_T"
+"RANSFERS_IN,\n		dbo.GAIN_LOSS_HISTORY.ADD_BULK_DISPOSALS,\n		dbo.GAIN_LOSS_HISTORY.ADD_RACK_DISPOSALS,\n		dbo.GAIN_LOSS_HIS"
+"TORY.ADD_TRANSFERS_OUT,\n		dbo.GAIN_LOSS_HISTORY.ADD_GAIN_LOSS,\n		dbo.GAIN_LOSS_HISTORY.PIPE_FILL,\n		dbo.GAIN_LOSS_HISTOR"
+"Y.OPENING_PHYSICAL_GROSS_QTY,\n		dbo.GAIN_LOSS_HISTORY.CLOSING_PHYSICAL_GROSS_QTY,\n		dbo.GAIN_LOSS_HISTORY.OPENING_TEMPER"
+"ATURE,\n		dbo.GAIN_LOSS_HISTORY.CLOSING_TEMPERATURE,\n		dbo.GAIN_LOSS_HISTORY.OPENING_DENSITY,\n		dbo.GAIN_LOSS_HISTORY.CLO"
+"SING_DENSITY,\n		dbo.GAIN_LOSS_HISTORY.OPENING_BSW_QTY,\n		dbo.GAIN_LOSS_HISTORY.CLOSING_BSW_QTY,\n		dbo.GAIN_LOSS_HISTORY."
+"OPENING_LEVEL,\n		dbo.GAIN_LOSS_HISTORY.CLOSING_LEVEL,\n		dbo.GAIN_LOSS_HISTORY.OPENING_OBSERVED_DENSITY,\n		dbo.GAIN_LOSS_"
+"HISTORY.CLOSING_OBSERVED_DENSITY,\n		dbo.GAIN_LOSS_HISTORY.OPENING_BSW_LEVEL,\n		dbo.GAIN_LOSS_HISTORY.CLOSING_BSW_LEVEL,\n"
+"		dbo.GAIN_LOSS_HISTORY.BULK_FRAC_DISPOSALS,\n		dbo.GAIN_LOSS_HISTORY.BULK_FRAC_RECEIPTS,\n		dbo.GAIN_LOSS_HISTORY.VIRTUAL"
+"_TANK,\n		dbo.GAIN_LOSS_HISTORY.OPENING_COE,\n		dbo.GAIN_LOSS_HISTORY.CLOSING_COE,\n		dbo.GAIN_LOSS_HISTORY.OPENING_LINE_SE"
+"GMENT_NSV,\n		dbo.GAIN_LOSS_HISTORY.CLOSING_LINE_SEGMENT_NSV,\n		dbo.GAIN_LOSS_HISTORY.OPENING_TOV,\n		dbo.GAIN_LOSS_HISTOR"
+"Y.CLOSING_TOV,\n		dbo.GAIN_LOSS_HISTORY.OPENING_GOV,\n		dbo.GAIN_LOSS_HISTORY.CLOSING_GOV,\n		dbo.GAIN_LOSS_HISTORY.OPENING"
+"_GSV,\n		dbo.GAIN_LOSS_HISTORY.CLOSING_GSV,\n		dbo.GAIN_LOSS_HISTORY.OPENING_TCV,\n		dbo.GAIN_LOSS_HISTORY.CLOSING_TCV,\n		d"
+"bo.GAIN_LOSS_HISTORY.OPENING_CTL,\n		dbo.GAIN_LOSS_HISTORY.CLOSING_CTL,\n		dbo.GAIN_LOSS_HISTORY.OPENING_SHELL_CORRECTION_"
+"FACTO,\n		dbo.GAIN_LOSS_HISTORY.CLOSING_SHELL_CORRECTION_FACTO,\n		dbo.GAIN_LOSS_HISTORY.OPENING_FLOATING_ROOF_ADJUSTME,\n	"
+"	dbo.GAIN_LOSS_HISTORY.CLOSING_FLOATING_ROOF_ADJUSTME,\n		dbo.GAIN_LOSS_HISTORY.OPENING_AMBIENT_TEMPERATURE,\n		dbo.GAIN_L"
+"OSS_HISTORY.CLOSING_AMBIENT_TEMPERATURE,\n		dbo.GAIN_LOSS_HISTORY.OPENING_SUSPENDED_BSW_PERCENT,\n		dbo.GAIN_LOSS_HISTORY."
+"CLOSING_SUSPENDED_BSW_PERCENT,\n		dbo.GAIN_LOSS_HISTORY.OPENING_GAUGER_INITIALS,\n		dbo.GAIN_LOSS_HISTORY.CLOSING_GAUGER_I"
+"NITIALS,\n		dbo.GAIN_LOSS_HISTORY.OPENING_GAUGE_TIMESTAMP,\n		dbo.GAIN_LOSS_HISTORY.CLOSING_GAUGE_TIMESTAMP,\n		dbo.GAIN_LO"
+"SS_HISTORY.OPENING_PRODUCT_STRAP_TYPE,\n		dbo.GAIN_LOSS_HISTORY.CLOSING_PRODUCT_STRAP_TYPE,\n		dbo.GAIN_LOSS_HISTORY.OPENI"
+"NG_BSW_STRAP_TYPE,\n		dbo.GAIN_LOSS_HISTORY.CLOSING_BSW_STRAP_TYPE,\n		dbo.GAIN_LOSS_HISTORY.OPENING_GSW,\n		dbo.GAIN_LOSS_"
+"HISTORY.CLOSING_GSW,\n		dbo.GAIN_LOSS_HISTORY.OPENING_NSW,\n		dbo.GAIN_LOSS_HISTORY.CLOSING_NSW,\n		dbo.GAIN_LOSS_HISTORY.O"
+"PENING_WCF,\n		dbo.GAIN_LOSS_HISTORY.CLOSING_WCF,\n		dbo.GAIN_LOSS_HISTORY.OPENING_LINE_SEGMENT_NSW,\n		dbo.GAIN_LOSS_HISTO"
+"RY.CLOSING_LINE_SEGMENT_NSW,\n		dbo.GAIN_LOSS_HISTORY.OPENING_NSV,\n		dbo.GAIN_LOSS_HISTORY.CLOSING_NSV,\n		dbo.GAIN_LOSS_H"
+"ISTORY.OPENING_XCTN_GROSS_QTY,\n		dbo.GAIN_LOSS_HISTORY.CLOSING_XCTN_GROSS_QTY,\n		dbo.GAIN_LOSS_HISTORY.OPENING_XCTN_FRAC"
+"_GROSS_QTY,\n		dbo.GAIN_LOSS_HISTORY.CLOSING_XCTN_FRAC_GROSS_QTY,\n		dbo.GAIN_LOSS_HISTORY.OPENING_XCTN_NET_QTY,\n		dbo.GAI"
+"N_LOSS_HISTORY.CLOSING_XCTN_NET_QTY,\n		dbo.GAIN_LOSS_HISTORY.OPENING_XCTN_FRAC_NET_QTY,\n		dbo.GAIN_LOSS_HISTORY.CLOSING_"
+"XCTN_FRAC_NET_QTY,\n		dbo.GAIN_LOSS_HISTORY.OPENING_CALCULATION_POINT,\n		dbo.GAIN_LOSS_HISTORY.CLOSING_CALCULATION_POINT,"
+"\n		dbo.GAIN_LOSS_HISTORY.MANUAL_OPENING_PHYSICAL,\n		dbo.GAIN_LOSS_HISTORY.OPENING_API_CODE,\n		dbo.GAIN_LOSS_HISTORY.CLOS"
+"ING_API_CODE,\n		dbo.GAIN_LOSS_HISTORY.OPENING_WEIGHT_IN_AIR,\n		dbo.GAIN_LOSS_HISTORY.CLOSING_WEIGHT_IN_AIR,\n		dbo.GAIN_L"
+"OSS_HISTORY.OPENING_XCTN_WEIGHT,\n		dbo.GAIN_LOSS_HISTORY.OPENING_XCTN_FRAC_WEIGHT,\n		dbo.GAIN_LOSS_HISTORY.CLOSING_XCTN_"
+"WEIGHT,\n		dbo.GAIN_LOSS_HISTORY.CLOSING_XCTN_FRAC_WEIGHT,\n		dbo.GAIN_LOSS_HISTORY.OPENING_VAPOR_CORRECT_METHOD,\n		dbo.GA"
+"IN_LOSS_HISTORY.CLOSING_VAPOR_CORRECT_METHOD,\n		dbo.GAIN_LOSS_HISTORY.OPENING_VAPOR_TEMPERATURE,\n		dbo.GAIN_LOSS_HISTORY"
+".CLOSING_VAPOR_TEMPERATURE,\n		dbo.GAIN_LOSS_HISTORY.OPENING_VAPOR_LIQUID_VOL_RATIO,\n		dbo.GAIN_LOSS_HISTORY.CLOSING_VAPO"
+"R_LIQUID_VOL_RATIO,\n		dbo.GAIN_LOSS_HISTORY.INVENTORY_QUANTITY_TYPE,\n		dbo.GAIN_LOSS_HISTORY.OPENING_PRESSURE,\n		dbo.GAI"
+"N_LOSS_HISTORY.CLOSING_PRESSURE,\n		dbo.GAIN_LOSS_HISTORY.OPENING_XCTN_WEIGHT_IN_VAC,\n		dbo.GAIN_LOSS_HISTORY.OPENING_XCT"
+"N_FRAC_WGT_IN_VAC,\n		dbo.GAIN_LOSS_HISTORY.CLOSING_XCTN_WEIGHT_IN_VAC,\n		dbo.GAIN_LOSS_HISTORY.CLOSING_XCTN_FRAC_WGT_IN_"
+"VAC,\n		dbo.GAIN_LOSS_HISTORY.MAJORITY_SHAREHOLDER,\n		dbo.GAIN_LOSS_HISTORY.OPENING_INVENTORY_ENABLE,\n		dbo.GAIN_LOSS_HIS"
+"TORY.CLOSING_INVENTORY_ENABLE,\n		dbo.GAIN_LOSS_HISTORY.OPENING_LEVEL_ORIGIN,\n		dbo.GAIN_LOSS_HISTORY.CLOSING_LEVEL_ORIGI"
+"N,\n		dbo.GAIN_LOSS_HISTORY.OPENING_TOV_ORIGIN,\n		dbo.GAIN_LOSS_HISTORY.CLOSING_TOV_ORIGIN,\n		dbo.GAIN_LOSS_HISTORY.OPENI"
+"NG_TEMPERATURE_ORIGIN,\n		dbo.GAIN_LOSS_HISTORY.CLOSING_TEMPERATURE_ORIGIN,\n		dbo.GAIN_LOSS_HISTORY.OPENING_DENSITY_ORIGI"
+"N,\n		dbo.GAIN_LOSS_HISTORY.CLOSING_DENSITY_ORIGIN,\n		dbo.GAIN_LOSS_HISTORY.OPENING_NSV_ORIGIN,\n		dbo.GAIN_LOSS_HISTORY.C"
+"LOSING_NSV_ORIGIN,\n		dbo.GAIN_LOSS_HISTORY.OPENING_VAPOR_TEMP_ORIGIN,\n		dbo.GAIN_LOSS_HISTORY.CLOSING_VAPOR_TEMP_ORIGIN,"
+"\n		dbo.GAIN_LOSS_HISTORY.OPENING_PRESSURE_ORIGIN,\n		dbo.GAIN_LOSS_HISTORY.CLOSING_PRESSURE_ORIGIN,\n		dbo.GAIN_LOSS_HISTO"
+"RY.OPENING_FREE_WATER_LVL_ORIGIN,\n		dbo.GAIN_LOSS_HISTORY.CLOSING_FREE_WATER_LVL_ORIGIN,\n		dbo.GAIN_LOSS_HISTORY.OPENING"
+"_WATER_QTY_ORIGIN,\n		dbo.GAIN_LOSS_HISTORY.CLOSING_WATER_QTY_ORIGIN,\n		dbo.GAIN_LOSS_HISTORY.COMPARTMENT_OWNER_ID,\n		dbo"
+".GAIN_LOSS_HISTORY.COMPARTMENT_CONTAINER_CODE,\n		dbo.GAIN_LOSS_HISTORY.COMPARTMENT_CONTAINER_TYPE,\n		dbo.GAIN_LOSS_HISTO"
+"RY.COMPARTMENT_NUMBER,\n		dbo.GAIN_LOSS_HISTORY.COMPARTMENT_VISIT_NUMBER\nFROM	dbo.GAIN_LOSS_HISTORY";
		    

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
								row1.TERMINAL_PRODUCT_NUMBER = 0;
							} else {
		                          
            row1.TERMINAL_PRODUCT_NUMBER = rs_tDBInput_1.getInt(1);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 2) {
								row1.FOLIO_NUMBER = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(2);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(2).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.FOLIO_NUMBER = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.FOLIO_NUMBER = tmpContent_tDBInput_1;
                }
            } else {
                row1.FOLIO_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 3) {
								row1.TANK_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(3);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(3).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.TANK_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.TANK_CODE = tmpContent_tDBInput_1;
                }
            } else {
                row1.TANK_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 4) {
								row1.GAIN_LOSS_ID = 0;
							} else {
		                          
            row1.GAIN_LOSS_ID = rs_tDBInput_1.getInt(4);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 5) {
								row1.TANK_GROUP = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(5);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(5).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.TANK_GROUP = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.TANK_GROUP = tmpContent_tDBInput_1;
                }
            } else {
                row1.TANK_GROUP = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 6) {
								row1.PRODUCT_GROUP_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(6);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(6).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.PRODUCT_GROUP_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.PRODUCT_GROUP_CODE = tmpContent_tDBInput_1;
                }
            } else {
                row1.PRODUCT_GROUP_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 7) {
								row1.OPENING_PHYSICAL = 0;
							} else {
		                          
            row1.OPENING_PHYSICAL = rs_tDBInput_1.getInt(7);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 8) {
								row1.BULK_RECEIPTS = 0;
							} else {
		                          
            row1.BULK_RECEIPTS = rs_tDBInput_1.getInt(8);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 9) {
								row1.BULK_TRANSFERS_IN = 0;
							} else {
		                          
            row1.BULK_TRANSFERS_IN = rs_tDBInput_1.getInt(9);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 10) {
								row1.BULK_DISPOSALS = 0;
							} else {
		                          
            row1.BULK_DISPOSALS = rs_tDBInput_1.getInt(10);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 11) {
								row1.BULK_TRANSFERS_OUT = 0;
							} else {
		                          
            row1.BULK_TRANSFERS_OUT = rs_tDBInput_1.getInt(11);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 12) {
								row1.RACK_RECEIPTS = 0;
							} else {
		                          
            row1.RACK_RECEIPTS = rs_tDBInput_1.getInt(12);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 13) {
								row1.RACK_DISPOSALS = 0;
							} else {
		                          
            row1.RACK_DISPOSALS = rs_tDBInput_1.getInt(13);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 14) {
								row1.CLOSING_PHYSICAL = 0;
							} else {
		                          
            row1.CLOSING_PHYSICAL = rs_tDBInput_1.getInt(14);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 15) {
								row1.MANUAL_CLOSING_PHYSICAL = 0;
							} else {
		                          
            row1.MANUAL_CLOSING_PHYSICAL = rs_tDBInput_1.getInt(15);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 16) {
								row1.GAIN_LOSS = 0;
							} else {
		                          
            row1.GAIN_LOSS = rs_tDBInput_1.getInt(16);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 17) {
								row1.RACK_FRAC_RECEIPTS = 0;
							} else {
		                          
            row1.RACK_FRAC_RECEIPTS = rs_tDBInput_1.getInt(17);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 18) {
								row1.RACK_FRAC_DISPOSALS = 0;
							} else {
		                          
            row1.RACK_FRAC_DISPOSALS = rs_tDBInput_1.getInt(18);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 19) {
								row1.BULK_FRAC_TRANSFERS_IN = 0;
							} else {
		                          
            row1.BULK_FRAC_TRANSFERS_IN = rs_tDBInput_1.getInt(19);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 20) {
								row1.BULK_FRAC_TRANSFERS_OUT = 0;
							} else {
		                          
            row1.BULK_FRAC_TRANSFERS_OUT = rs_tDBInput_1.getInt(20);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 21) {
								row1.ADD_BULK_RECEIPTS = 0;
							} else {
		                          
            row1.ADD_BULK_RECEIPTS = rs_tDBInput_1.getInt(21);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 22) {
								row1.ADD_RACK_RECEIPTS = 0;
							} else {
		                          
            row1.ADD_RACK_RECEIPTS = rs_tDBInput_1.getInt(22);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 23) {
								row1.ADD_TRANSFERS_IN = 0;
							} else {
		                          
            row1.ADD_TRANSFERS_IN = rs_tDBInput_1.getInt(23);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 24) {
								row1.ADD_BULK_DISPOSALS = 0;
							} else {
		                          
            row1.ADD_BULK_DISPOSALS = rs_tDBInput_1.getInt(24);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 25) {
								row1.ADD_RACK_DISPOSALS = 0;
							} else {
		                          
            row1.ADD_RACK_DISPOSALS = rs_tDBInput_1.getInt(25);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 26) {
								row1.ADD_TRANSFERS_OUT = 0;
							} else {
		                          
            row1.ADD_TRANSFERS_OUT = rs_tDBInput_1.getInt(26);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 27) {
								row1.ADD_GAIN_LOSS = 0;
							} else {
		                          
            row1.ADD_GAIN_LOSS = rs_tDBInput_1.getInt(27);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 28) {
								row1.PIPE_FILL = 0;
							} else {
		                          
            row1.PIPE_FILL = rs_tDBInput_1.getInt(28);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 29) {
								row1.OPENING_PHYSICAL_GROSS_QTY = 0;
							} else {
		                          
            row1.OPENING_PHYSICAL_GROSS_QTY = rs_tDBInput_1.getInt(29);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 30) {
								row1.CLOSING_PHYSICAL_GROSS_QTY = 0;
							} else {
		                          
            row1.CLOSING_PHYSICAL_GROSS_QTY = rs_tDBInput_1.getInt(30);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 31) {
								row1.OPENING_TEMPERATURE = 0;
							} else {
	                         		
            row1.OPENING_TEMPERATURE = rs_tDBInput_1.getDouble(31);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 32) {
								row1.CLOSING_TEMPERATURE = 0;
							} else {
	                         		
            row1.CLOSING_TEMPERATURE = rs_tDBInput_1.getDouble(32);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 33) {
								row1.OPENING_DENSITY = 0;
							} else {
	                         		
            row1.OPENING_DENSITY = rs_tDBInput_1.getDouble(33);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 34) {
								row1.CLOSING_DENSITY = 0;
							} else {
	                         		
            row1.CLOSING_DENSITY = rs_tDBInput_1.getDouble(34);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 35) {
								row1.OPENING_BSW_QTY = 0;
							} else {
		                          
            row1.OPENING_BSW_QTY = rs_tDBInput_1.getInt(35);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 36) {
								row1.CLOSING_BSW_QTY = 0;
							} else {
		                          
            row1.CLOSING_BSW_QTY = rs_tDBInput_1.getInt(36);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 37) {
								row1.OPENING_LEVEL = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(37);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(37).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.OPENING_LEVEL = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.OPENING_LEVEL = tmpContent_tDBInput_1;
                }
            } else {
                row1.OPENING_LEVEL = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 38) {
								row1.CLOSING_LEVEL = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(38);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(38).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.CLOSING_LEVEL = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.CLOSING_LEVEL = tmpContent_tDBInput_1;
                }
            } else {
                row1.CLOSING_LEVEL = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 39) {
								row1.OPENING_OBSERVED_DENSITY = 0;
							} else {
	                         		
            row1.OPENING_OBSERVED_DENSITY = rs_tDBInput_1.getDouble(39);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 40) {
								row1.CLOSING_OBSERVED_DENSITY = 0;
							} else {
	                         		
            row1.CLOSING_OBSERVED_DENSITY = rs_tDBInput_1.getDouble(40);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 41) {
								row1.OPENING_BSW_LEVEL = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(41);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(41).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.OPENING_BSW_LEVEL = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.OPENING_BSW_LEVEL = tmpContent_tDBInput_1;
                }
            } else {
                row1.OPENING_BSW_LEVEL = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 42) {
								row1.CLOSING_BSW_LEVEL = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(42);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(42).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.CLOSING_BSW_LEVEL = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.CLOSING_BSW_LEVEL = tmpContent_tDBInput_1;
                }
            } else {
                row1.CLOSING_BSW_LEVEL = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 43) {
								row1.BULK_FRAC_DISPOSALS = 0;
							} else {
		                          
            row1.BULK_FRAC_DISPOSALS = rs_tDBInput_1.getInt(43);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 44) {
								row1.BULK_FRAC_RECEIPTS = 0;
							} else {
		                          
            row1.BULK_FRAC_RECEIPTS = rs_tDBInput_1.getInt(44);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 45) {
								row1.VIRTUAL_TANK = 0;
							} else {
		                          
            row1.VIRTUAL_TANK = rs_tDBInput_1.getInt(45);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 46) {
								row1.OPENING_COE = 0;
							} else {
	                         		
            row1.OPENING_COE = rs_tDBInput_1.getDouble(46);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 47) {
								row1.CLOSING_COE = 0;
							} else {
	                         		
            row1.CLOSING_COE = rs_tDBInput_1.getDouble(47);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 48) {
								row1.OPENING_LINE_SEGMENT_NSV = 0;
							} else {
		                          
            row1.OPENING_LINE_SEGMENT_NSV = rs_tDBInput_1.getInt(48);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 49) {
								row1.CLOSING_LINE_SEGMENT_NSV = 0;
							} else {
		                          
            row1.CLOSING_LINE_SEGMENT_NSV = rs_tDBInput_1.getInt(49);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 50) {
								row1.OPENING_TOV = 0;
							} else {
		                          
            row1.OPENING_TOV = rs_tDBInput_1.getInt(50);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 51) {
								row1.CLOSING_TOV = 0;
							} else {
		                          
            row1.CLOSING_TOV = rs_tDBInput_1.getInt(51);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 52) {
								row1.OPENING_GOV = 0;
							} else {
		                          
            row1.OPENING_GOV = rs_tDBInput_1.getInt(52);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 53) {
								row1.CLOSING_GOV = 0;
							} else {
		                          
            row1.CLOSING_GOV = rs_tDBInput_1.getInt(53);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 54) {
								row1.OPENING_GSV = 0;
							} else {
		                          
            row1.OPENING_GSV = rs_tDBInput_1.getInt(54);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 55) {
								row1.CLOSING_GSV = 0;
							} else {
		                          
            row1.CLOSING_GSV = rs_tDBInput_1.getInt(55);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 56) {
								row1.OPENING_TCV = 0;
							} else {
		                          
            row1.OPENING_TCV = rs_tDBInput_1.getInt(56);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 57) {
								row1.CLOSING_TCV = 0;
							} else {
		                          
            row1.CLOSING_TCV = rs_tDBInput_1.getInt(57);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 58) {
								row1.OPENING_CTL = 0;
							} else {
	                         		
            row1.OPENING_CTL = rs_tDBInput_1.getDouble(58);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 59) {
								row1.CLOSING_CTL = 0;
							} else {
	                         		
            row1.CLOSING_CTL = rs_tDBInput_1.getDouble(59);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 60) {
								row1.OPENING_SHELL_CORRECTION_FACTO = 0;
							} else {
	                         		
            row1.OPENING_SHELL_CORRECTION_FACTO = rs_tDBInput_1.getDouble(60);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 61) {
								row1.CLOSING_SHELL_CORRECTION_FACTO = 0;
							} else {
	                         		
            row1.CLOSING_SHELL_CORRECTION_FACTO = rs_tDBInput_1.getDouble(61);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 62) {
								row1.OPENING_FLOATING_ROOF_ADJUSTME = 0;
							} else {
		                          
            row1.OPENING_FLOATING_ROOF_ADJUSTME = rs_tDBInput_1.getInt(62);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 63) {
								row1.CLOSING_FLOATING_ROOF_ADJUSTME = 0;
							} else {
		                          
            row1.CLOSING_FLOATING_ROOF_ADJUSTME = rs_tDBInput_1.getInt(63);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 64) {
								row1.OPENING_AMBIENT_TEMPERATURE = 0;
							} else {
	                         		
            row1.OPENING_AMBIENT_TEMPERATURE = rs_tDBInput_1.getDouble(64);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 65) {
								row1.CLOSING_AMBIENT_TEMPERATURE = 0;
							} else {
	                         		
            row1.CLOSING_AMBIENT_TEMPERATURE = rs_tDBInput_1.getDouble(65);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 66) {
								row1.OPENING_SUSPENDED_BSW_PERCENT = 0;
							} else {
	                         		
            row1.OPENING_SUSPENDED_BSW_PERCENT = rs_tDBInput_1.getDouble(66);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 67) {
								row1.CLOSING_SUSPENDED_BSW_PERCENT = 0;
							} else {
	                         		
            row1.CLOSING_SUSPENDED_BSW_PERCENT = rs_tDBInput_1.getDouble(67);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 68) {
								row1.OPENING_GAUGER_INITIALS = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(68);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(68).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.OPENING_GAUGER_INITIALS = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.OPENING_GAUGER_INITIALS = tmpContent_tDBInput_1;
                }
            } else {
                row1.OPENING_GAUGER_INITIALS = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 69) {
								row1.CLOSING_GAUGER_INITIALS = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(69);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(69).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.CLOSING_GAUGER_INITIALS = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.CLOSING_GAUGER_INITIALS = tmpContent_tDBInput_1;
                }
            } else {
                row1.CLOSING_GAUGER_INITIALS = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 70) {
								row1.OPENING_GAUGE_TIMESTAMP = null;
							} else {
										
			row1.OPENING_GAUGE_TIMESTAMP = mssqlGTU_tDBInput_1.getDate(rsmd_tDBInput_1, rs_tDBInput_1, 70);
			
		                    }
							if(colQtyInRs_tDBInput_1 < 71) {
								row1.CLOSING_GAUGE_TIMESTAMP = null;
							} else {
										
			row1.CLOSING_GAUGE_TIMESTAMP = mssqlGTU_tDBInput_1.getDate(rsmd_tDBInput_1, rs_tDBInput_1, 71);
			
		                    }
							if(colQtyInRs_tDBInput_1 < 72) {
								row1.OPENING_PRODUCT_STRAP_TYPE = 0;
							} else {
		                          
            row1.OPENING_PRODUCT_STRAP_TYPE = rs_tDBInput_1.getInt(72);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 73) {
								row1.CLOSING_PRODUCT_STRAP_TYPE = 0;
							} else {
		                          
            row1.CLOSING_PRODUCT_STRAP_TYPE = rs_tDBInput_1.getInt(73);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 74) {
								row1.OPENING_BSW_STRAP_TYPE = 0;
							} else {
		                          
            row1.OPENING_BSW_STRAP_TYPE = rs_tDBInput_1.getInt(74);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 75) {
								row1.CLOSING_BSW_STRAP_TYPE = 0;
							} else {
		                          
            row1.CLOSING_BSW_STRAP_TYPE = rs_tDBInput_1.getInt(75);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 76) {
								row1.OPENING_GSW = 0;
							} else {
		                          
            row1.OPENING_GSW = rs_tDBInput_1.getInt(76);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 77) {
								row1.CLOSING_GSW = 0;
							} else {
		                          
            row1.CLOSING_GSW = rs_tDBInput_1.getInt(77);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 78) {
								row1.OPENING_NSW = 0;
							} else {
		                          
            row1.OPENING_NSW = rs_tDBInput_1.getInt(78);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 79) {
								row1.CLOSING_NSW = 0;
							} else {
		                          
            row1.CLOSING_NSW = rs_tDBInput_1.getInt(79);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 80) {
								row1.OPENING_WCF = 0;
							} else {
	                         		
            row1.OPENING_WCF = rs_tDBInput_1.getDouble(80);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 81) {
								row1.CLOSING_WCF = 0;
							} else {
	                         		
            row1.CLOSING_WCF = rs_tDBInput_1.getDouble(81);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 82) {
								row1.OPENING_LINE_SEGMENT_NSW = 0;
							} else {
		                          
            row1.OPENING_LINE_SEGMENT_NSW = rs_tDBInput_1.getInt(82);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 83) {
								row1.CLOSING_LINE_SEGMENT_NSW = 0;
							} else {
		                          
            row1.CLOSING_LINE_SEGMENT_NSW = rs_tDBInput_1.getInt(83);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 84) {
								row1.OPENING_NSV = 0;
							} else {
		                          
            row1.OPENING_NSV = rs_tDBInput_1.getInt(84);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 85) {
								row1.CLOSING_NSV = 0;
							} else {
		                          
            row1.CLOSING_NSV = rs_tDBInput_1.getInt(85);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 86) {
								row1.OPENING_XCTN_GROSS_QTY = 0;
							} else {
		                          
            row1.OPENING_XCTN_GROSS_QTY = rs_tDBInput_1.getInt(86);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 87) {
								row1.CLOSING_XCTN_GROSS_QTY = 0;
							} else {
		                          
            row1.CLOSING_XCTN_GROSS_QTY = rs_tDBInput_1.getInt(87);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 88) {
								row1.OPENING_XCTN_FRAC_GROSS_QTY = 0;
							} else {
		                          
            row1.OPENING_XCTN_FRAC_GROSS_QTY = rs_tDBInput_1.getInt(88);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 89) {
								row1.CLOSING_XCTN_FRAC_GROSS_QTY = 0;
							} else {
		                          
            row1.CLOSING_XCTN_FRAC_GROSS_QTY = rs_tDBInput_1.getInt(89);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 90) {
								row1.OPENING_XCTN_NET_QTY = 0;
							} else {
		                          
            row1.OPENING_XCTN_NET_QTY = rs_tDBInput_1.getInt(90);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 91) {
								row1.CLOSING_XCTN_NET_QTY = 0;
							} else {
		                          
            row1.CLOSING_XCTN_NET_QTY = rs_tDBInput_1.getInt(91);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 92) {
								row1.OPENING_XCTN_FRAC_NET_QTY = 0;
							} else {
		                          
            row1.OPENING_XCTN_FRAC_NET_QTY = rs_tDBInput_1.getInt(92);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 93) {
								row1.CLOSING_XCTN_FRAC_NET_QTY = 0;
							} else {
		                          
            row1.CLOSING_XCTN_FRAC_NET_QTY = rs_tDBInput_1.getInt(93);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 94) {
								row1.OPENING_CALCULATION_POINT = 0;
							} else {
		                          
            row1.OPENING_CALCULATION_POINT = rs_tDBInput_1.getInt(94);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 95) {
								row1.CLOSING_CALCULATION_POINT = 0;
							} else {
		                          
            row1.CLOSING_CALCULATION_POINT = rs_tDBInput_1.getInt(95);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 96) {
								row1.MANUAL_OPENING_PHYSICAL = 0;
							} else {
		                          
            row1.MANUAL_OPENING_PHYSICAL = rs_tDBInput_1.getInt(96);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 97) {
								row1.OPENING_API_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(97);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(97).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.OPENING_API_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.OPENING_API_CODE = tmpContent_tDBInput_1;
                }
            } else {
                row1.OPENING_API_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 98) {
								row1.CLOSING_API_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(98);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(98).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.CLOSING_API_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.CLOSING_API_CODE = tmpContent_tDBInput_1;
                }
            } else {
                row1.CLOSING_API_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 99) {
								row1.OPENING_WEIGHT_IN_AIR = 0;
							} else {
		                          
            row1.OPENING_WEIGHT_IN_AIR = rs_tDBInput_1.getInt(99);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 100) {
								row1.CLOSING_WEIGHT_IN_AIR = 0;
							} else {
		                          
            row1.CLOSING_WEIGHT_IN_AIR = rs_tDBInput_1.getInt(100);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 101) {
								row1.OPENING_XCTN_WEIGHT = 0;
							} else {
		                          
            row1.OPENING_XCTN_WEIGHT = rs_tDBInput_1.getInt(101);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 102) {
								row1.OPENING_XCTN_FRAC_WEIGHT = 0;
							} else {
		                          
            row1.OPENING_XCTN_FRAC_WEIGHT = rs_tDBInput_1.getInt(102);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 103) {
								row1.CLOSING_XCTN_WEIGHT = 0;
							} else {
		                          
            row1.CLOSING_XCTN_WEIGHT = rs_tDBInput_1.getInt(103);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 104) {
								row1.CLOSING_XCTN_FRAC_WEIGHT = 0;
							} else {
		                          
            row1.CLOSING_XCTN_FRAC_WEIGHT = rs_tDBInput_1.getInt(104);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 105) {
								row1.OPENING_VAPOR_CORRECT_METHOD = 0;
							} else {
		                          
            row1.OPENING_VAPOR_CORRECT_METHOD = rs_tDBInput_1.getInt(105);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 106) {
								row1.CLOSING_VAPOR_CORRECT_METHOD = 0;
							} else {
		                          
            row1.CLOSING_VAPOR_CORRECT_METHOD = rs_tDBInput_1.getInt(106);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 107) {
								row1.OPENING_VAPOR_TEMPERATURE = 0;
							} else {
	                         		
            row1.OPENING_VAPOR_TEMPERATURE = rs_tDBInput_1.getDouble(107);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 108) {
								row1.CLOSING_VAPOR_TEMPERATURE = 0;
							} else {
	                         		
            row1.CLOSING_VAPOR_TEMPERATURE = rs_tDBInput_1.getDouble(108);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 109) {
								row1.OPENING_VAPOR_LIQUID_VOL_RATIO = 0;
							} else {
	                         		
            row1.OPENING_VAPOR_LIQUID_VOL_RATIO = rs_tDBInput_1.getDouble(109);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 110) {
								row1.CLOSING_VAPOR_LIQUID_VOL_RATIO = 0;
							} else {
	                         		
            row1.CLOSING_VAPOR_LIQUID_VOL_RATIO = rs_tDBInput_1.getDouble(110);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 111) {
								row1.INVENTORY_QUANTITY_TYPE = 0;
							} else {
		                          
            row1.INVENTORY_QUANTITY_TYPE = rs_tDBInput_1.getInt(111);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 112) {
								row1.OPENING_PRESSURE = 0;
							} else {
	                         		
            row1.OPENING_PRESSURE = rs_tDBInput_1.getDouble(112);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 113) {
								row1.CLOSING_PRESSURE = 0;
							} else {
	                         		
            row1.CLOSING_PRESSURE = rs_tDBInput_1.getDouble(113);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 114) {
								row1.OPENING_XCTN_WEIGHT_IN_VAC = 0;
							} else {
		                          
            row1.OPENING_XCTN_WEIGHT_IN_VAC = rs_tDBInput_1.getInt(114);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 115) {
								row1.OPENING_XCTN_FRAC_WGT_IN_VAC = 0;
							} else {
		                          
            row1.OPENING_XCTN_FRAC_WGT_IN_VAC = rs_tDBInput_1.getInt(115);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 116) {
								row1.CLOSING_XCTN_WEIGHT_IN_VAC = 0;
							} else {
		                          
            row1.CLOSING_XCTN_WEIGHT_IN_VAC = rs_tDBInput_1.getInt(116);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 117) {
								row1.CLOSING_XCTN_FRAC_WGT_IN_VAC = 0;
							} else {
		                          
            row1.CLOSING_XCTN_FRAC_WGT_IN_VAC = rs_tDBInput_1.getInt(117);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 118) {
								row1.MAJORITY_SHAREHOLDER = null;
							} else {
		                          
            row1.MAJORITY_SHAREHOLDER = rs_tDBInput_1.getInt(118);
            if(rs_tDBInput_1.wasNull()){
                    row1.MAJORITY_SHAREHOLDER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 119) {
								row1.OPENING_INVENTORY_ENABLE = 0;
							} else {
		                          
            row1.OPENING_INVENTORY_ENABLE = rs_tDBInput_1.getInt(119);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 120) {
								row1.CLOSING_INVENTORY_ENABLE = 0;
							} else {
		                          
            row1.CLOSING_INVENTORY_ENABLE = rs_tDBInput_1.getInt(120);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 121) {
								row1.OPENING_LEVEL_ORIGIN = 0;
							} else {
		                          
            row1.OPENING_LEVEL_ORIGIN = rs_tDBInput_1.getInt(121);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 122) {
								row1.CLOSING_LEVEL_ORIGIN = 0;
							} else {
		                          
            row1.CLOSING_LEVEL_ORIGIN = rs_tDBInput_1.getInt(122);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 123) {
								row1.OPENING_TOV_ORIGIN = 0;
							} else {
		                          
            row1.OPENING_TOV_ORIGIN = rs_tDBInput_1.getInt(123);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 124) {
								row1.CLOSING_TOV_ORIGIN = 0;
							} else {
		                          
            row1.CLOSING_TOV_ORIGIN = rs_tDBInput_1.getInt(124);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 125) {
								row1.OPENING_TEMPERATURE_ORIGIN = 0;
							} else {
		                          
            row1.OPENING_TEMPERATURE_ORIGIN = rs_tDBInput_1.getInt(125);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 126) {
								row1.CLOSING_TEMPERATURE_ORIGIN = 0;
							} else {
		                          
            row1.CLOSING_TEMPERATURE_ORIGIN = rs_tDBInput_1.getInt(126);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 127) {
								row1.OPENING_DENSITY_ORIGIN = 0;
							} else {
		                          
            row1.OPENING_DENSITY_ORIGIN = rs_tDBInput_1.getInt(127);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 128) {
								row1.CLOSING_DENSITY_ORIGIN = 0;
							} else {
		                          
            row1.CLOSING_DENSITY_ORIGIN = rs_tDBInput_1.getInt(128);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 129) {
								row1.OPENING_NSV_ORIGIN = 0;
							} else {
		                          
            row1.OPENING_NSV_ORIGIN = rs_tDBInput_1.getInt(129);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 130) {
								row1.CLOSING_NSV_ORIGIN = 0;
							} else {
		                          
            row1.CLOSING_NSV_ORIGIN = rs_tDBInput_1.getInt(130);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 131) {
								row1.OPENING_VAPOR_TEMP_ORIGIN = 0;
							} else {
		                          
            row1.OPENING_VAPOR_TEMP_ORIGIN = rs_tDBInput_1.getInt(131);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 132) {
								row1.CLOSING_VAPOR_TEMP_ORIGIN = 0;
							} else {
		                          
            row1.CLOSING_VAPOR_TEMP_ORIGIN = rs_tDBInput_1.getInt(132);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 133) {
								row1.OPENING_PRESSURE_ORIGIN = 0;
							} else {
		                          
            row1.OPENING_PRESSURE_ORIGIN = rs_tDBInput_1.getInt(133);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 134) {
								row1.CLOSING_PRESSURE_ORIGIN = 0;
							} else {
		                          
            row1.CLOSING_PRESSURE_ORIGIN = rs_tDBInput_1.getInt(134);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 135) {
								row1.OPENING_FREE_WATER_LVL_ORIGIN = 0;
							} else {
		                          
            row1.OPENING_FREE_WATER_LVL_ORIGIN = rs_tDBInput_1.getInt(135);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 136) {
								row1.CLOSING_FREE_WATER_LVL_ORIGIN = 0;
							} else {
		                          
            row1.CLOSING_FREE_WATER_LVL_ORIGIN = rs_tDBInput_1.getInt(136);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 137) {
								row1.OPENING_WATER_QTY_ORIGIN = 0;
							} else {
		                          
            row1.OPENING_WATER_QTY_ORIGIN = rs_tDBInput_1.getInt(137);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 138) {
								row1.CLOSING_WATER_QTY_ORIGIN = 0;
							} else {
		                          
            row1.CLOSING_WATER_QTY_ORIGIN = rs_tDBInput_1.getInt(138);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 139) {
								row1.COMPARTMENT_OWNER_ID = null;
							} else {
		                          
            row1.COMPARTMENT_OWNER_ID = rs_tDBInput_1.getInt(139);
            if(rs_tDBInput_1.wasNull()){
                    row1.COMPARTMENT_OWNER_ID = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 140) {
								row1.COMPARTMENT_CONTAINER_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(140);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(140).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.COMPARTMENT_CONTAINER_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.COMPARTMENT_CONTAINER_CODE = tmpContent_tDBInput_1;
                }
            } else {
                row1.COMPARTMENT_CONTAINER_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 141) {
								row1.COMPARTMENT_CONTAINER_TYPE = null;
							} else {
		                          
            row1.COMPARTMENT_CONTAINER_TYPE = rs_tDBInput_1.getInt(141);
            if(rs_tDBInput_1.wasNull()){
                    row1.COMPARTMENT_CONTAINER_TYPE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 142) {
								row1.COMPARTMENT_NUMBER = null;
							} else {
		                          
            row1.COMPARTMENT_NUMBER = rs_tDBInput_1.getInt(142);
            if(rs_tDBInput_1.wasNull()){
                    row1.COMPARTMENT_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 143) {
								row1.COMPARTMENT_VISIT_NUMBER = 0;
							} else {
		                          
            row1.COMPARTMENT_VISIT_NUMBER = rs_tDBInput_1.getInt(143);
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
finder_tUniqRow_1.TERMINAL_PRODUCT_NUMBER = row1.TERMINAL_PRODUCT_NUMBER;
if(row1.FOLIO_NUMBER == null){
	finder_tUniqRow_1.FOLIO_NUMBER = null;
}else{
	finder_tUniqRow_1.FOLIO_NUMBER = row1.FOLIO_NUMBER.toLowerCase();
}
if(row1.TANK_CODE == null){
	finder_tUniqRow_1.TANK_CODE = null;
}else{
	finder_tUniqRow_1.TANK_CODE = row1.TANK_CODE.toLowerCase();
}	
finder_tUniqRow_1.hashCodeDirty = true;
if (!keystUniqRow_1.contains(finder_tUniqRow_1)) {
		KeyStruct_tUniqRow_1 new_tUniqRow_1 = new KeyStruct_tUniqRow_1();

		
new_tUniqRow_1.TERMINAL_PRODUCT_NUMBER = row1.TERMINAL_PRODUCT_NUMBER;
if(row1.FOLIO_NUMBER == null){
	new_tUniqRow_1.FOLIO_NUMBER = null;
}else{
	new_tUniqRow_1.FOLIO_NUMBER = row1.FOLIO_NUMBER.toLowerCase();
}
if(row1.TANK_CODE == null){
	new_tUniqRow_1.TANK_CODE = null;
}else{
	new_tUniqRow_1.TANK_CODE = row1.TANK_CODE.toLowerCase();
}
		
		keystUniqRow_1.add(new_tUniqRow_1);if(row2 == null){ 
	
	row2 = new row2Struct();
}row2.TERMINAL_PRODUCT_NUMBER = row1.TERMINAL_PRODUCT_NUMBER;			row2.FOLIO_NUMBER = row1.FOLIO_NUMBER;			row2.TANK_CODE = row1.TANK_CODE;			row2.GAIN_LOSS_ID = row1.GAIN_LOSS_ID;			row2.TANK_GROUP = row1.TANK_GROUP;			row2.PRODUCT_GROUP_CODE = row1.PRODUCT_GROUP_CODE;			row2.OPENING_PHYSICAL = row1.OPENING_PHYSICAL;			row2.BULK_RECEIPTS = row1.BULK_RECEIPTS;			row2.BULK_TRANSFERS_IN = row1.BULK_TRANSFERS_IN;			row2.BULK_DISPOSALS = row1.BULK_DISPOSALS;			row2.BULK_TRANSFERS_OUT = row1.BULK_TRANSFERS_OUT;			row2.RACK_RECEIPTS = row1.RACK_RECEIPTS;			row2.RACK_DISPOSALS = row1.RACK_DISPOSALS;			row2.CLOSING_PHYSICAL = row1.CLOSING_PHYSICAL;			row2.MANUAL_CLOSING_PHYSICAL = row1.MANUAL_CLOSING_PHYSICAL;			row2.GAIN_LOSS = row1.GAIN_LOSS;			row2.RACK_FRAC_RECEIPTS = row1.RACK_FRAC_RECEIPTS;			row2.RACK_FRAC_DISPOSALS = row1.RACK_FRAC_DISPOSALS;			row2.BULK_FRAC_TRANSFERS_IN = row1.BULK_FRAC_TRANSFERS_IN;			row2.BULK_FRAC_TRANSFERS_OUT = row1.BULK_FRAC_TRANSFERS_OUT;			row2.ADD_BULK_RECEIPTS = row1.ADD_BULK_RECEIPTS;			row2.ADD_RACK_RECEIPTS = row1.ADD_RACK_RECEIPTS;			row2.ADD_TRANSFERS_IN = row1.ADD_TRANSFERS_IN;			row2.ADD_BULK_DISPOSALS = row1.ADD_BULK_DISPOSALS;			row2.ADD_RACK_DISPOSALS = row1.ADD_RACK_DISPOSALS;			row2.ADD_TRANSFERS_OUT = row1.ADD_TRANSFERS_OUT;			row2.ADD_GAIN_LOSS = row1.ADD_GAIN_LOSS;			row2.PIPE_FILL = row1.PIPE_FILL;			row2.OPENING_PHYSICAL_GROSS_QTY = row1.OPENING_PHYSICAL_GROSS_QTY;			row2.CLOSING_PHYSICAL_GROSS_QTY = row1.CLOSING_PHYSICAL_GROSS_QTY;			row2.OPENING_TEMPERATURE = row1.OPENING_TEMPERATURE;			row2.CLOSING_TEMPERATURE = row1.CLOSING_TEMPERATURE;			row2.OPENING_DENSITY = row1.OPENING_DENSITY;			row2.CLOSING_DENSITY = row1.CLOSING_DENSITY;			row2.OPENING_BSW_QTY = row1.OPENING_BSW_QTY;			row2.CLOSING_BSW_QTY = row1.CLOSING_BSW_QTY;			row2.OPENING_LEVEL = row1.OPENING_LEVEL;			row2.CLOSING_LEVEL = row1.CLOSING_LEVEL;			row2.OPENING_OBSERVED_DENSITY = row1.OPENING_OBSERVED_DENSITY;			row2.CLOSING_OBSERVED_DENSITY = row1.CLOSING_OBSERVED_DENSITY;			row2.OPENING_BSW_LEVEL = row1.OPENING_BSW_LEVEL;			row2.CLOSING_BSW_LEVEL = row1.CLOSING_BSW_LEVEL;			row2.BULK_FRAC_DISPOSALS = row1.BULK_FRAC_DISPOSALS;			row2.BULK_FRAC_RECEIPTS = row1.BULK_FRAC_RECEIPTS;			row2.VIRTUAL_TANK = row1.VIRTUAL_TANK;			row2.OPENING_COE = row1.OPENING_COE;			row2.CLOSING_COE = row1.CLOSING_COE;			row2.OPENING_LINE_SEGMENT_NSV = row1.OPENING_LINE_SEGMENT_NSV;			row2.CLOSING_LINE_SEGMENT_NSV = row1.CLOSING_LINE_SEGMENT_NSV;			row2.OPENING_TOV = row1.OPENING_TOV;			row2.CLOSING_TOV = row1.CLOSING_TOV;			row2.OPENING_GOV = row1.OPENING_GOV;			row2.CLOSING_GOV = row1.CLOSING_GOV;			row2.OPENING_GSV = row1.OPENING_GSV;			row2.CLOSING_GSV = row1.CLOSING_GSV;			row2.OPENING_TCV = row1.OPENING_TCV;			row2.CLOSING_TCV = row1.CLOSING_TCV;			row2.OPENING_CTL = row1.OPENING_CTL;			row2.CLOSING_CTL = row1.CLOSING_CTL;			row2.OPENING_SHELL_CORRECTION_FACTO = row1.OPENING_SHELL_CORRECTION_FACTO;			row2.CLOSING_SHELL_CORRECTION_FACTO = row1.CLOSING_SHELL_CORRECTION_FACTO;			row2.OPENING_FLOATING_ROOF_ADJUSTME = row1.OPENING_FLOATING_ROOF_ADJUSTME;			row2.CLOSING_FLOATING_ROOF_ADJUSTME = row1.CLOSING_FLOATING_ROOF_ADJUSTME;			row2.OPENING_AMBIENT_TEMPERATURE = row1.OPENING_AMBIENT_TEMPERATURE;			row2.CLOSING_AMBIENT_TEMPERATURE = row1.CLOSING_AMBIENT_TEMPERATURE;			row2.OPENING_SUSPENDED_BSW_PERCENT = row1.OPENING_SUSPENDED_BSW_PERCENT;			row2.CLOSING_SUSPENDED_BSW_PERCENT = row1.CLOSING_SUSPENDED_BSW_PERCENT;			row2.OPENING_GAUGER_INITIALS = row1.OPENING_GAUGER_INITIALS;			row2.CLOSING_GAUGER_INITIALS = row1.CLOSING_GAUGER_INITIALS;			row2.OPENING_GAUGE_TIMESTAMP = row1.OPENING_GAUGE_TIMESTAMP;			row2.CLOSING_GAUGE_TIMESTAMP = row1.CLOSING_GAUGE_TIMESTAMP;			row2.OPENING_PRODUCT_STRAP_TYPE = row1.OPENING_PRODUCT_STRAP_TYPE;			row2.CLOSING_PRODUCT_STRAP_TYPE = row1.CLOSING_PRODUCT_STRAP_TYPE;			row2.OPENING_BSW_STRAP_TYPE = row1.OPENING_BSW_STRAP_TYPE;			row2.CLOSING_BSW_STRAP_TYPE = row1.CLOSING_BSW_STRAP_TYPE;			row2.OPENING_GSW = row1.OPENING_GSW;			row2.CLOSING_GSW = row1.CLOSING_GSW;			row2.OPENING_NSW = row1.OPENING_NSW;			row2.CLOSING_NSW = row1.CLOSING_NSW;			row2.OPENING_WCF = row1.OPENING_WCF;			row2.CLOSING_WCF = row1.CLOSING_WCF;			row2.OPENING_LINE_SEGMENT_NSW = row1.OPENING_LINE_SEGMENT_NSW;			row2.CLOSING_LINE_SEGMENT_NSW = row1.CLOSING_LINE_SEGMENT_NSW;			row2.OPENING_NSV = row1.OPENING_NSV;			row2.CLOSING_NSV = row1.CLOSING_NSV;			row2.OPENING_XCTN_GROSS_QTY = row1.OPENING_XCTN_GROSS_QTY;			row2.CLOSING_XCTN_GROSS_QTY = row1.CLOSING_XCTN_GROSS_QTY;			row2.OPENING_XCTN_FRAC_GROSS_QTY = row1.OPENING_XCTN_FRAC_GROSS_QTY;			row2.CLOSING_XCTN_FRAC_GROSS_QTY = row1.CLOSING_XCTN_FRAC_GROSS_QTY;			row2.OPENING_XCTN_NET_QTY = row1.OPENING_XCTN_NET_QTY;			row2.CLOSING_XCTN_NET_QTY = row1.CLOSING_XCTN_NET_QTY;			row2.OPENING_XCTN_FRAC_NET_QTY = row1.OPENING_XCTN_FRAC_NET_QTY;			row2.CLOSING_XCTN_FRAC_NET_QTY = row1.CLOSING_XCTN_FRAC_NET_QTY;			row2.OPENING_CALCULATION_POINT = row1.OPENING_CALCULATION_POINT;			row2.CLOSING_CALCULATION_POINT = row1.CLOSING_CALCULATION_POINT;			row2.MANUAL_OPENING_PHYSICAL = row1.MANUAL_OPENING_PHYSICAL;			row2.OPENING_API_CODE = row1.OPENING_API_CODE;			row2.CLOSING_API_CODE = row1.CLOSING_API_CODE;			row2.OPENING_WEIGHT_IN_AIR = row1.OPENING_WEIGHT_IN_AIR;			row2.CLOSING_WEIGHT_IN_AIR = row1.CLOSING_WEIGHT_IN_AIR;			row2.OPENING_XCTN_WEIGHT = row1.OPENING_XCTN_WEIGHT;			row2.OPENING_XCTN_FRAC_WEIGHT = row1.OPENING_XCTN_FRAC_WEIGHT;			row2.CLOSING_XCTN_WEIGHT = row1.CLOSING_XCTN_WEIGHT;			row2.CLOSING_XCTN_FRAC_WEIGHT = row1.CLOSING_XCTN_FRAC_WEIGHT;			row2.OPENING_VAPOR_CORRECT_METHOD = row1.OPENING_VAPOR_CORRECT_METHOD;			row2.CLOSING_VAPOR_CORRECT_METHOD = row1.CLOSING_VAPOR_CORRECT_METHOD;			row2.OPENING_VAPOR_TEMPERATURE = row1.OPENING_VAPOR_TEMPERATURE;			row2.CLOSING_VAPOR_TEMPERATURE = row1.CLOSING_VAPOR_TEMPERATURE;			row2.OPENING_VAPOR_LIQUID_VOL_RATIO = row1.OPENING_VAPOR_LIQUID_VOL_RATIO;			row2.CLOSING_VAPOR_LIQUID_VOL_RATIO = row1.CLOSING_VAPOR_LIQUID_VOL_RATIO;			row2.INVENTORY_QUANTITY_TYPE = row1.INVENTORY_QUANTITY_TYPE;			row2.OPENING_PRESSURE = row1.OPENING_PRESSURE;			row2.CLOSING_PRESSURE = row1.CLOSING_PRESSURE;			row2.OPENING_XCTN_WEIGHT_IN_VAC = row1.OPENING_XCTN_WEIGHT_IN_VAC;			row2.OPENING_XCTN_FRAC_WGT_IN_VAC = row1.OPENING_XCTN_FRAC_WGT_IN_VAC;			row2.CLOSING_XCTN_WEIGHT_IN_VAC = row1.CLOSING_XCTN_WEIGHT_IN_VAC;			row2.CLOSING_XCTN_FRAC_WGT_IN_VAC = row1.CLOSING_XCTN_FRAC_WGT_IN_VAC;			row2.MAJORITY_SHAREHOLDER = row1.MAJORITY_SHAREHOLDER;			row2.OPENING_INVENTORY_ENABLE = row1.OPENING_INVENTORY_ENABLE;			row2.CLOSING_INVENTORY_ENABLE = row1.CLOSING_INVENTORY_ENABLE;			row2.OPENING_LEVEL_ORIGIN = row1.OPENING_LEVEL_ORIGIN;			row2.CLOSING_LEVEL_ORIGIN = row1.CLOSING_LEVEL_ORIGIN;			row2.OPENING_TOV_ORIGIN = row1.OPENING_TOV_ORIGIN;			row2.CLOSING_TOV_ORIGIN = row1.CLOSING_TOV_ORIGIN;			row2.OPENING_TEMPERATURE_ORIGIN = row1.OPENING_TEMPERATURE_ORIGIN;			row2.CLOSING_TEMPERATURE_ORIGIN = row1.CLOSING_TEMPERATURE_ORIGIN;			row2.OPENING_DENSITY_ORIGIN = row1.OPENING_DENSITY_ORIGIN;			row2.CLOSING_DENSITY_ORIGIN = row1.CLOSING_DENSITY_ORIGIN;			row2.OPENING_NSV_ORIGIN = row1.OPENING_NSV_ORIGIN;			row2.CLOSING_NSV_ORIGIN = row1.CLOSING_NSV_ORIGIN;			row2.OPENING_VAPOR_TEMP_ORIGIN = row1.OPENING_VAPOR_TEMP_ORIGIN;			row2.CLOSING_VAPOR_TEMP_ORIGIN = row1.CLOSING_VAPOR_TEMP_ORIGIN;			row2.OPENING_PRESSURE_ORIGIN = row1.OPENING_PRESSURE_ORIGIN;			row2.CLOSING_PRESSURE_ORIGIN = row1.CLOSING_PRESSURE_ORIGIN;			row2.OPENING_FREE_WATER_LVL_ORIGIN = row1.OPENING_FREE_WATER_LVL_ORIGIN;			row2.CLOSING_FREE_WATER_LVL_ORIGIN = row1.CLOSING_FREE_WATER_LVL_ORIGIN;			row2.OPENING_WATER_QTY_ORIGIN = row1.OPENING_WATER_QTY_ORIGIN;			row2.CLOSING_WATER_QTY_ORIGIN = row1.CLOSING_WATER_QTY_ORIGIN;			row2.COMPARTMENT_OWNER_ID = row1.COMPARTMENT_OWNER_ID;			row2.COMPARTMENT_CONTAINER_CODE = row1.COMPARTMENT_CONTAINER_CODE;			row2.COMPARTMENT_CONTAINER_TYPE = row1.COMPARTMENT_CONTAINER_TYPE;			row2.COMPARTMENT_NUMBER = row1.COMPARTMENT_NUMBER;			row2.COMPARTMENT_VISIT_NUMBER = row1.COMPARTMENT_VISIT_NUMBER;					
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
								
	                        		    	Object exprKeyValue_row3__TERMINAL_PRODUCT_NUMBER = row2.TERMINAL_PRODUCT_NUMBER ;
	                        		    	if(exprKeyValue_row3__TERMINAL_PRODUCT_NUMBER == null) {
	                        		    		hasCasePrimitiveKeyWithNull_tMap_1 = true;
	                        		    	} else {
                        		    			row3HashKey.TERMINAL_PRODUCT_NUMBER = (int)(Integer) exprKeyValue_row3__TERMINAL_PRODUCT_NUMBER;
                        		    		}
                        		    		
                        		    		    row3HashKey.FOLIO_NUMBER = row2.FOLIO_NUMBER ;
                        		    		
                        		    		    row3HashKey.TANK_CODE = row2.TANK_CODE ;
                        		    		

								
		                        	row3HashKey.hashCodeDirty = true;
                        		
	  					
	  							
	
		  							if(!hasCasePrimitiveKeyWithNull_tMap_1) { // G_TM_M_091
		  							
			  					
			  					
			  					
	  					
		  							tHash_Lookup_row3.lookup( row3HashKey );

	  							

	  							

			  						} // G_TM_M_091
			  						
			  					

 								
		  				
	  								
						
									
  									  		
 								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_row3 != null && tHash_Lookup_row3.getCount(row3HashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row3' and it contains more one result from keys :  row3.TERMINAL_PRODUCT_NUMBER = '" + row3HashKey.TERMINAL_PRODUCT_NUMBER + "', row3.FOLIO_NUMBER = '" + row3HashKey.FOLIO_NUMBER + "', row3.TANK_CODE = '" + row3HashKey.TANK_CODE + "'");
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
Var.PK_GAIN_LOSS_HIS = Numeric.sequence("s2",1,1) ;// ###############################
        // ###############################
        // # Output tables

out1 = null;

boolean rejected_tMap_1 = true;
// ###### START REJECTS ##### 

// # Output reject table : 'out1'
// # Filter conditions 
if( rejected_tMap_1 ) {
out1_tmp.PK_GAIN_LOSS_HISTORY = Var.PK_GAIN_LOSS_HIS ;
out1_tmp.TERMINAL_PRODUCT_NUMBER = row2.TERMINAL_PRODUCT_NUMBER ;
out1_tmp.DATE = row2.FOLIO_NUMBER != null && TalendDate.isDateStrict(row2.FOLIO_NUMBER, "yyyyMMdd") ?
    TalendDate.parseDate("yyyyMMdd", row2.FOLIO_NUMBER) :  TalendDate.parseDate("yyyyMMdd", String.valueOf(Integer.parseInt(row2.FOLIO_NUMBER) - 1)) ;
out1_tmp.FOLIO_NUMBER = row2.FOLIO_NUMBER ;
out1_tmp.TANK_CODE = row2.TANK_CODE ;
out1_tmp.GAIN_LOSS_ID = row2.GAIN_LOSS_ID ;
out1_tmp.PRODUCT_GROUP_CODE = row2.PRODUCT_GROUP_CODE ;
out1_tmp.OPENING_PHYSICAL = row2.OPENING_PHYSICAL ;
out1_tmp.BULK_RECEIPTS = row2.BULK_RECEIPTS ;
out1_tmp.BULK_TRANSFERS_IN = row2.BULK_TRANSFERS_IN ;
out1_tmp.BULK_TRANSFERS_OUT = row2.BULK_TRANSFERS_OUT ;
out1_tmp.RACK_DISPOSALS = row2.RACK_DISPOSALS ;
out1_tmp.CLOSING_PHYSICAL = row2.CLOSING_PHYSICAL ;
out1_tmp.GAIN_LOSS = row2.GAIN_LOSS ;
out1_tmp.OPENING_PHYSICAL_GROSS_QTY = row2.OPENING_PHYSICAL_GROSS_QTY ;
out1_tmp.CLOSING_PHYSICAL_GROSS_QTY = row2.CLOSING_PHYSICAL_GROSS_QTY ;
out1_tmp.OPENING_TEMPERATURE = row2.OPENING_TEMPERATURE ;
out1_tmp.CLOSING_TEMPERATURE = row2.CLOSING_TEMPERATURE ;
out1_tmp.OPENING_DENSITY = row2.OPENING_DENSITY ;
out1_tmp.CLOSING_DENSITY = row2.CLOSING_DENSITY ;
out1_tmp.OPENING_BSW_QTY = row2.OPENING_BSW_QTY ;
out1_tmp.CLOSING_BSW_QTY = row2.CLOSING_BSW_QTY ;
out1_tmp.OPENING_LEVEL = row2.OPENING_LEVEL ;
out1_tmp.CLOSING_LEVEL = row2.CLOSING_LEVEL ;
out1_tmp.OPENING_OBSERVED_DENSITY = row2.OPENING_OBSERVED_DENSITY ;
out1_tmp.CLOSING_OBSERVED_DENSITY = row2.CLOSING_OBSERVED_DENSITY ;
out1_tmp.OPENING_BSW_LEVEL = row2.OPENING_BSW_LEVEL ;
out1_tmp.CLOSING_BSW_LEVEL = row2.CLOSING_BSW_LEVEL ;
out1_tmp.OPENING_TOV = row2.OPENING_TOV ;
out1_tmp.CLOSING_TOV = row2.CLOSING_TOV ;
out1_tmp.OPENING_GOV = row2.OPENING_GOV ;
out1_tmp.CLOSING_GOV = row2.CLOSING_GOV ;
out1_tmp.OPENING_GSV = row2.OPENING_GSV ;
out1_tmp.CLOSING_GSV = row2.CLOSING_GSV ;
out1_tmp.OPENING_TCV = row2.OPENING_TCV ;
out1_tmp.CLOSING_TCV = row2.CLOSING_TCV ;
out1_tmp.OPENING_CTL = row2.OPENING_CTL ;
out1_tmp.CLOSING_CTL = row2.CLOSING_CTL ;
out1_tmp.OPENING_AMBIENT_TEMPERATURE = row2.OPENING_AMBIENT_TEMPERATURE ;
out1_tmp.CLOSING_AMBIENT_TEMPERATURE = row2.CLOSING_AMBIENT_TEMPERATURE ;
out1_tmp.OPENING_GSW = row2.OPENING_GSW ;
out1_tmp.CLOSING_GSW = row2.CLOSING_GSW ;
out1_tmp.OPENING_NSW = row2.OPENING_NSW ;
out1_tmp.CLOSING_NSW = row2.CLOSING_NSW ;
out1_tmp.OPENING_WCF = row2.OPENING_WCF ;
out1_tmp.CLOSING_WCF = row2.CLOSING_WCF ;
out1_tmp.OPENING_NSV = row2.OPENING_NSV ;
out1_tmp.CLOSING_NSV = row2.CLOSING_NSV ;
out1_tmp.OPENING_XCTN_GROSS_QTY = row2.OPENING_XCTN_GROSS_QTY ;
out1_tmp.CLOSING_XCTN_GROSS_QTY = row2.CLOSING_XCTN_GROSS_QTY ;
out1_tmp.OPENING_XCTN_NET_QTY = row2.OPENING_XCTN_NET_QTY ;
out1_tmp.CLOSING_XCTN_NET_QTY = row2.CLOSING_XCTN_NET_QTY ;
out1_tmp.OPENING_WEIGHT_IN_AIR = row2.OPENING_WEIGHT_IN_AIR ;
out1_tmp.CLOSING_WEIGHT_IN_AIR = row2.CLOSING_WEIGHT_IN_AIR ;
out1_tmp.OPENING_XCTN_WEIGHT = row2.OPENING_XCTN_WEIGHT ;
out1_tmp.CLOSING_XCTN_WEIGHT = row2.CLOSING_XCTN_WEIGHT ;
out1_tmp.OPENING_CALCULATION_POINT = row2.OPENING_CALCULATION_POINT ;
out1_tmp.CLOSING_CALCULATION_POINT = row2.CLOSING_CALCULATION_POINT ;
out1_tmp.OPENING_PRODUCT_STRAP_TYPE = row2.OPENING_PRODUCT_STRAP_TYPE ;
out1_tmp.OPENING_API_CODE = row2.OPENING_API_CODE ;
out1_tmp.CLOSING_PRODUCT_STRAP_TYPE = row2.CLOSING_PRODUCT_STRAP_TYPE ;
out1_tmp.CLOSING_API_CODE = row2.CLOSING_API_CODE ;
out1_tmp.OPENING_TEMPERATURE_ORIGIN = row2.OPENING_TEMPERATURE_ORIGIN ;
out1_tmp.CLOSING_TEMPERATURE_ORIGIN = row2.CLOSING_TEMPERATURE_ORIGIN ;
out1_tmp.INVENTORY_QUANTITY_TYPE = row2.INVENTORY_QUANTITY_TYPE ;
out1_tmp.COMPARTMENT_VISIT_NUMBER = row2.COMPARTMENT_VISIT_NUMBER ;
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


                    if(out1.PK_GAIN_LOSS_HISTORY == null) {
pstmt_tDBOutput_1.setNull(1, java.sql.Types.INTEGER);
} else {pstmt_tDBOutput_1.setInt(1, out1.PK_GAIN_LOSS_HISTORY);
}

            int checkCount_tDBOutput_1 = -1;
            try (java.sql.ResultSet rs_tDBOutput_1 = pstmt_tDBOutput_1.executeQuery()) {
                while(rs_tDBOutput_1.next()) {
                    checkCount_tDBOutput_1 = rs_tDBOutput_1.getInt(1);
                }
            }
            if(checkCount_tDBOutput_1 > 0) {
                        pstmtUpdate_tDBOutput_1.setInt(1, out1.TERMINAL_PRODUCT_NUMBER);

                        if(out1.DATE != null) {
pstmtUpdate_tDBOutput_1.setTimestamp(2, new java.sql.Timestamp(out1.DATE.getTime()));
} else {
pstmtUpdate_tDBOutput_1.setNull(2, java.sql.Types.TIMESTAMP);
}

                        if(out1.FOLIO_NUMBER == null) {
pstmtUpdate_tDBOutput_1.setNull(3, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(3, out1.FOLIO_NUMBER);
}

                        if(out1.TANK_CODE == null) {
pstmtUpdate_tDBOutput_1.setNull(4, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(4, out1.TANK_CODE);
}

                        pstmtUpdate_tDBOutput_1.setInt(5, out1.GAIN_LOSS_ID);

                        if(out1.PRODUCT_GROUP_CODE == null) {
pstmtUpdate_tDBOutput_1.setNull(6, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(6, out1.PRODUCT_GROUP_CODE);
}

                        pstmtUpdate_tDBOutput_1.setInt(7, out1.OPENING_PHYSICAL);

                        pstmtUpdate_tDBOutput_1.setInt(8, out1.BULK_RECEIPTS);

                        pstmtUpdate_tDBOutput_1.setInt(9, out1.BULK_TRANSFERS_IN);

                        pstmtUpdate_tDBOutput_1.setInt(10, out1.BULK_TRANSFERS_OUT);

                        pstmtUpdate_tDBOutput_1.setInt(11, out1.RACK_DISPOSALS);

                        pstmtUpdate_tDBOutput_1.setInt(12, out1.CLOSING_PHYSICAL);

                        pstmtUpdate_tDBOutput_1.setInt(13, out1.GAIN_LOSS);

                        pstmtUpdate_tDBOutput_1.setInt(14, out1.OPENING_PHYSICAL_GROSS_QTY);

                        pstmtUpdate_tDBOutput_1.setInt(15, out1.CLOSING_PHYSICAL_GROSS_QTY);

                        pstmtUpdate_tDBOutput_1.setDouble(16, out1.OPENING_TEMPERATURE);

                        pstmtUpdate_tDBOutput_1.setDouble(17, out1.CLOSING_TEMPERATURE);

                        pstmtUpdate_tDBOutput_1.setDouble(18, out1.OPENING_DENSITY);

                        pstmtUpdate_tDBOutput_1.setDouble(19, out1.CLOSING_DENSITY);

                        pstmtUpdate_tDBOutput_1.setInt(20, out1.OPENING_BSW_QTY);

                        pstmtUpdate_tDBOutput_1.setInt(21, out1.CLOSING_BSW_QTY);

                        if(out1.OPENING_LEVEL == null) {
pstmtUpdate_tDBOutput_1.setNull(22, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(22, out1.OPENING_LEVEL);
}

                        if(out1.CLOSING_LEVEL == null) {
pstmtUpdate_tDBOutput_1.setNull(23, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(23, out1.CLOSING_LEVEL);
}

                        pstmtUpdate_tDBOutput_1.setDouble(24, out1.OPENING_OBSERVED_DENSITY);

                        pstmtUpdate_tDBOutput_1.setDouble(25, out1.CLOSING_OBSERVED_DENSITY);

                        if(out1.OPENING_BSW_LEVEL == null) {
pstmtUpdate_tDBOutput_1.setNull(26, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(26, out1.OPENING_BSW_LEVEL);
}

                        if(out1.CLOSING_BSW_LEVEL == null) {
pstmtUpdate_tDBOutput_1.setNull(27, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(27, out1.CLOSING_BSW_LEVEL);
}

                        pstmtUpdate_tDBOutput_1.setInt(28, out1.OPENING_TOV);

                        pstmtUpdate_tDBOutput_1.setInt(29, out1.CLOSING_TOV);

                        pstmtUpdate_tDBOutput_1.setInt(30, out1.OPENING_GOV);

                        pstmtUpdate_tDBOutput_1.setInt(31, out1.CLOSING_GOV);

                        pstmtUpdate_tDBOutput_1.setInt(32, out1.OPENING_GSV);

                        pstmtUpdate_tDBOutput_1.setInt(33, out1.CLOSING_GSV);

                        pstmtUpdate_tDBOutput_1.setInt(34, out1.OPENING_TCV);

                        pstmtUpdate_tDBOutput_1.setInt(35, out1.CLOSING_TCV);

                        pstmtUpdate_tDBOutput_1.setDouble(36, out1.OPENING_CTL);

                        pstmtUpdate_tDBOutput_1.setDouble(37, out1.CLOSING_CTL);

                        pstmtUpdate_tDBOutput_1.setDouble(38, out1.OPENING_AMBIENT_TEMPERATURE);

                        pstmtUpdate_tDBOutput_1.setDouble(39, out1.CLOSING_AMBIENT_TEMPERATURE);

                        pstmtUpdate_tDBOutput_1.setInt(40, out1.OPENING_GSW);

                        pstmtUpdate_tDBOutput_1.setInt(41, out1.CLOSING_GSW);

                        pstmtUpdate_tDBOutput_1.setInt(42, out1.OPENING_NSW);

                        pstmtUpdate_tDBOutput_1.setInt(43, out1.CLOSING_NSW);

                        pstmtUpdate_tDBOutput_1.setDouble(44, out1.OPENING_WCF);

                        pstmtUpdate_tDBOutput_1.setDouble(45, out1.CLOSING_WCF);

                        pstmtUpdate_tDBOutput_1.setInt(46, out1.OPENING_NSV);

                        pstmtUpdate_tDBOutput_1.setInt(47, out1.CLOSING_NSV);

                        pstmtUpdate_tDBOutput_1.setInt(48, out1.OPENING_XCTN_GROSS_QTY);

                        pstmtUpdate_tDBOutput_1.setInt(49, out1.CLOSING_XCTN_GROSS_QTY);

                        pstmtUpdate_tDBOutput_1.setInt(50, out1.OPENING_XCTN_NET_QTY);

                        pstmtUpdate_tDBOutput_1.setInt(51, out1.CLOSING_XCTN_NET_QTY);

                        pstmtUpdate_tDBOutput_1.setInt(52, out1.OPENING_WEIGHT_IN_AIR);

                        pstmtUpdate_tDBOutput_1.setInt(53, out1.CLOSING_WEIGHT_IN_AIR);

                        pstmtUpdate_tDBOutput_1.setInt(54, out1.OPENING_XCTN_WEIGHT);

                        pstmtUpdate_tDBOutput_1.setInt(55, out1.CLOSING_XCTN_WEIGHT);

                        pstmtUpdate_tDBOutput_1.setInt(56, out1.OPENING_CALCULATION_POINT);

                        pstmtUpdate_tDBOutput_1.setInt(57, out1.CLOSING_CALCULATION_POINT);

                        pstmtUpdate_tDBOutput_1.setInt(58, out1.OPENING_PRODUCT_STRAP_TYPE);

                        if(out1.OPENING_API_CODE == null) {
pstmtUpdate_tDBOutput_1.setNull(59, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(59, out1.OPENING_API_CODE);
}

                        pstmtUpdate_tDBOutput_1.setInt(60, out1.CLOSING_PRODUCT_STRAP_TYPE);

                        if(out1.CLOSING_API_CODE == null) {
pstmtUpdate_tDBOutput_1.setNull(61, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(61, out1.CLOSING_API_CODE);
}

                        pstmtUpdate_tDBOutput_1.setInt(62, out1.OPENING_TEMPERATURE_ORIGIN);

                        pstmtUpdate_tDBOutput_1.setInt(63, out1.CLOSING_TEMPERATURE_ORIGIN);

                        pstmtUpdate_tDBOutput_1.setInt(64, out1.INVENTORY_QUANTITY_TYPE);

                        pstmtUpdate_tDBOutput_1.setInt(65, out1.COMPARTMENT_VISIT_NUMBER);


	                    

                        if(out1.PK_GAIN_LOSS_HISTORY == null) {
pstmtUpdate_tDBOutput_1.setNull(66 + count_tDBOutput_1, java.sql.Types.INTEGER);
} else {pstmtUpdate_tDBOutput_1.setInt(66 + count_tDBOutput_1, out1.PK_GAIN_LOSS_HISTORY);
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
                        if(out1.PK_GAIN_LOSS_HISTORY == null) {
pstmtInsert_tDBOutput_1.setNull(1, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_1.setInt(1, out1.PK_GAIN_LOSS_HISTORY);
}

                        pstmtInsert_tDBOutput_1.setInt(2, out1.TERMINAL_PRODUCT_NUMBER);

                        if(out1.DATE != null) {
pstmtInsert_tDBOutput_1.setTimestamp(3, new java.sql.Timestamp(out1.DATE.getTime()));
} else {
pstmtInsert_tDBOutput_1.setNull(3, java.sql.Types.TIMESTAMP);
}

                        if(out1.FOLIO_NUMBER == null) {
pstmtInsert_tDBOutput_1.setNull(4, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(4, out1.FOLIO_NUMBER);
}

                        if(out1.TANK_CODE == null) {
pstmtInsert_tDBOutput_1.setNull(5, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(5, out1.TANK_CODE);
}

                        pstmtInsert_tDBOutput_1.setInt(6, out1.GAIN_LOSS_ID);

                        if(out1.PRODUCT_GROUP_CODE == null) {
pstmtInsert_tDBOutput_1.setNull(7, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(7, out1.PRODUCT_GROUP_CODE);
}

                        pstmtInsert_tDBOutput_1.setInt(8, out1.OPENING_PHYSICAL);

                        pstmtInsert_tDBOutput_1.setInt(9, out1.BULK_RECEIPTS);

                        pstmtInsert_tDBOutput_1.setInt(10, out1.BULK_TRANSFERS_IN);

                        pstmtInsert_tDBOutput_1.setInt(11, out1.BULK_TRANSFERS_OUT);

                        pstmtInsert_tDBOutput_1.setInt(12, out1.RACK_DISPOSALS);

                        pstmtInsert_tDBOutput_1.setInt(13, out1.CLOSING_PHYSICAL);

                        pstmtInsert_tDBOutput_1.setInt(14, out1.GAIN_LOSS);

                        pstmtInsert_tDBOutput_1.setInt(15, out1.OPENING_PHYSICAL_GROSS_QTY);

                        pstmtInsert_tDBOutput_1.setInt(16, out1.CLOSING_PHYSICAL_GROSS_QTY);

                        pstmtInsert_tDBOutput_1.setDouble(17, out1.OPENING_TEMPERATURE);

                        pstmtInsert_tDBOutput_1.setDouble(18, out1.CLOSING_TEMPERATURE);

                        pstmtInsert_tDBOutput_1.setDouble(19, out1.OPENING_DENSITY);

                        pstmtInsert_tDBOutput_1.setDouble(20, out1.CLOSING_DENSITY);

                        pstmtInsert_tDBOutput_1.setInt(21, out1.OPENING_BSW_QTY);

                        pstmtInsert_tDBOutput_1.setInt(22, out1.CLOSING_BSW_QTY);

                        if(out1.OPENING_LEVEL == null) {
pstmtInsert_tDBOutput_1.setNull(23, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(23, out1.OPENING_LEVEL);
}

                        if(out1.CLOSING_LEVEL == null) {
pstmtInsert_tDBOutput_1.setNull(24, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(24, out1.CLOSING_LEVEL);
}

                        pstmtInsert_tDBOutput_1.setDouble(25, out1.OPENING_OBSERVED_DENSITY);

                        pstmtInsert_tDBOutput_1.setDouble(26, out1.CLOSING_OBSERVED_DENSITY);

                        if(out1.OPENING_BSW_LEVEL == null) {
pstmtInsert_tDBOutput_1.setNull(27, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(27, out1.OPENING_BSW_LEVEL);
}

                        if(out1.CLOSING_BSW_LEVEL == null) {
pstmtInsert_tDBOutput_1.setNull(28, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(28, out1.CLOSING_BSW_LEVEL);
}

                        pstmtInsert_tDBOutput_1.setInt(29, out1.OPENING_TOV);

                        pstmtInsert_tDBOutput_1.setInt(30, out1.CLOSING_TOV);

                        pstmtInsert_tDBOutput_1.setInt(31, out1.OPENING_GOV);

                        pstmtInsert_tDBOutput_1.setInt(32, out1.CLOSING_GOV);

                        pstmtInsert_tDBOutput_1.setInt(33, out1.OPENING_GSV);

                        pstmtInsert_tDBOutput_1.setInt(34, out1.CLOSING_GSV);

                        pstmtInsert_tDBOutput_1.setInt(35, out1.OPENING_TCV);

                        pstmtInsert_tDBOutput_1.setInt(36, out1.CLOSING_TCV);

                        pstmtInsert_tDBOutput_1.setDouble(37, out1.OPENING_CTL);

                        pstmtInsert_tDBOutput_1.setDouble(38, out1.CLOSING_CTL);

                        pstmtInsert_tDBOutput_1.setDouble(39, out1.OPENING_AMBIENT_TEMPERATURE);

                        pstmtInsert_tDBOutput_1.setDouble(40, out1.CLOSING_AMBIENT_TEMPERATURE);

                        pstmtInsert_tDBOutput_1.setInt(41, out1.OPENING_GSW);

                        pstmtInsert_tDBOutput_1.setInt(42, out1.CLOSING_GSW);

                        pstmtInsert_tDBOutput_1.setInt(43, out1.OPENING_NSW);

                        pstmtInsert_tDBOutput_1.setInt(44, out1.CLOSING_NSW);

                        pstmtInsert_tDBOutput_1.setDouble(45, out1.OPENING_WCF);

                        pstmtInsert_tDBOutput_1.setDouble(46, out1.CLOSING_WCF);

                        pstmtInsert_tDBOutput_1.setInt(47, out1.OPENING_NSV);

                        pstmtInsert_tDBOutput_1.setInt(48, out1.CLOSING_NSV);

                        pstmtInsert_tDBOutput_1.setInt(49, out1.OPENING_XCTN_GROSS_QTY);

                        pstmtInsert_tDBOutput_1.setInt(50, out1.CLOSING_XCTN_GROSS_QTY);

                        pstmtInsert_tDBOutput_1.setInt(51, out1.OPENING_XCTN_NET_QTY);

                        pstmtInsert_tDBOutput_1.setInt(52, out1.CLOSING_XCTN_NET_QTY);

                        pstmtInsert_tDBOutput_1.setInt(53, out1.OPENING_WEIGHT_IN_AIR);

                        pstmtInsert_tDBOutput_1.setInt(54, out1.CLOSING_WEIGHT_IN_AIR);

                        pstmtInsert_tDBOutput_1.setInt(55, out1.OPENING_XCTN_WEIGHT);

                        pstmtInsert_tDBOutput_1.setInt(56, out1.CLOSING_XCTN_WEIGHT);

                        pstmtInsert_tDBOutput_1.setInt(57, out1.OPENING_CALCULATION_POINT);

                        pstmtInsert_tDBOutput_1.setInt(58, out1.CLOSING_CALCULATION_POINT);

                        pstmtInsert_tDBOutput_1.setInt(59, out1.OPENING_PRODUCT_STRAP_TYPE);

                        if(out1.OPENING_API_CODE == null) {
pstmtInsert_tDBOutput_1.setNull(60, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(60, out1.OPENING_API_CODE);
}

                        pstmtInsert_tDBOutput_1.setInt(61, out1.CLOSING_PRODUCT_STRAP_TYPE);

                        if(out1.CLOSING_API_CODE == null) {
pstmtInsert_tDBOutput_1.setNull(62, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(62, out1.CLOSING_API_CODE);
}

                        pstmtInsert_tDBOutput_1.setInt(63, out1.OPENING_TEMPERATURE_ORIGIN);

                        pstmtInsert_tDBOutput_1.setInt(64, out1.CLOSING_TEMPERATURE_ORIGIN);

                        pstmtInsert_tDBOutput_1.setInt(65, out1.INVENTORY_QUANTITY_TYPE);

                        pstmtInsert_tDBOutput_1.setInt(66, out1.COMPARTMENT_VISIT_NUMBER);

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
    final static byte[] commonByteArrayLock_PGS_STAGE_DIM_GAIN_LOSS_HISTORY = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_DIM_GAIN_LOSS_HISTORY = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public int PK_GAIN_LOSS_HISTORY;

				public int getPK_GAIN_LOSS_HISTORY () {
					return this.PK_GAIN_LOSS_HISTORY;
				}
				
			    public int TERMINAL_PRODUCT_NUMBER;

				public int getTERMINAL_PRODUCT_NUMBER () {
					return this.TERMINAL_PRODUCT_NUMBER;
				}
				
			    public java.util.Date DATE;

				public java.util.Date getDATE () {
					return this.DATE;
				}
				
			    public String FOLIO_NUMBER;

				public String getFOLIO_NUMBER () {
					return this.FOLIO_NUMBER;
				}
				
			    public String TANK_CODE;

				public String getTANK_CODE () {
					return this.TANK_CODE;
				}
				
			    public int GAIN_LOSS_ID;

				public int getGAIN_LOSS_ID () {
					return this.GAIN_LOSS_ID;
				}
				
			    public String PRODUCT_GROUP_CODE;

				public String getPRODUCT_GROUP_CODE () {
					return this.PRODUCT_GROUP_CODE;
				}
				
			    public int OPENING_PHYSICAL;

				public int getOPENING_PHYSICAL () {
					return this.OPENING_PHYSICAL;
				}
				
			    public int BULK_RECEIPTS;

				public int getBULK_RECEIPTS () {
					return this.BULK_RECEIPTS;
				}
				
			    public int BULK_TRANSFERS_IN;

				public int getBULK_TRANSFERS_IN () {
					return this.BULK_TRANSFERS_IN;
				}
				
			    public int BULK_TRANSFERS_OUT;

				public int getBULK_TRANSFERS_OUT () {
					return this.BULK_TRANSFERS_OUT;
				}
				
			    public int RACK_DISPOSALS;

				public int getRACK_DISPOSALS () {
					return this.RACK_DISPOSALS;
				}
				
			    public int CLOSING_PHYSICAL;

				public int getCLOSING_PHYSICAL () {
					return this.CLOSING_PHYSICAL;
				}
				
			    public int GAIN_LOSS;

				public int getGAIN_LOSS () {
					return this.GAIN_LOSS;
				}
				
			    public int OPENING_PHYSICAL_GROSS_QTY;

				public int getOPENING_PHYSICAL_GROSS_QTY () {
					return this.OPENING_PHYSICAL_GROSS_QTY;
				}
				
			    public int CLOSING_PHYSICAL_GROSS_QTY;

				public int getCLOSING_PHYSICAL_GROSS_QTY () {
					return this.CLOSING_PHYSICAL_GROSS_QTY;
				}
				
			    public double OPENING_TEMPERATURE;

				public double getOPENING_TEMPERATURE () {
					return this.OPENING_TEMPERATURE;
				}
				
			    public double CLOSING_TEMPERATURE;

				public double getCLOSING_TEMPERATURE () {
					return this.CLOSING_TEMPERATURE;
				}
				
			    public double OPENING_DENSITY;

				public double getOPENING_DENSITY () {
					return this.OPENING_DENSITY;
				}
				
			    public double CLOSING_DENSITY;

				public double getCLOSING_DENSITY () {
					return this.CLOSING_DENSITY;
				}
				
			    public int OPENING_BSW_QTY;

				public int getOPENING_BSW_QTY () {
					return this.OPENING_BSW_QTY;
				}
				
			    public int CLOSING_BSW_QTY;

				public int getCLOSING_BSW_QTY () {
					return this.CLOSING_BSW_QTY;
				}
				
			    public String OPENING_LEVEL;

				public String getOPENING_LEVEL () {
					return this.OPENING_LEVEL;
				}
				
			    public String CLOSING_LEVEL;

				public String getCLOSING_LEVEL () {
					return this.CLOSING_LEVEL;
				}
				
			    public double OPENING_OBSERVED_DENSITY;

				public double getOPENING_OBSERVED_DENSITY () {
					return this.OPENING_OBSERVED_DENSITY;
				}
				
			    public double CLOSING_OBSERVED_DENSITY;

				public double getCLOSING_OBSERVED_DENSITY () {
					return this.CLOSING_OBSERVED_DENSITY;
				}
				
			    public String OPENING_BSW_LEVEL;

				public String getOPENING_BSW_LEVEL () {
					return this.OPENING_BSW_LEVEL;
				}
				
			    public String CLOSING_BSW_LEVEL;

				public String getCLOSING_BSW_LEVEL () {
					return this.CLOSING_BSW_LEVEL;
				}
				
			    public int OPENING_TOV;

				public int getOPENING_TOV () {
					return this.OPENING_TOV;
				}
				
			    public int CLOSING_TOV;

				public int getCLOSING_TOV () {
					return this.CLOSING_TOV;
				}
				
			    public int OPENING_GOV;

				public int getOPENING_GOV () {
					return this.OPENING_GOV;
				}
				
			    public int CLOSING_GOV;

				public int getCLOSING_GOV () {
					return this.CLOSING_GOV;
				}
				
			    public int OPENING_GSV;

				public int getOPENING_GSV () {
					return this.OPENING_GSV;
				}
				
			    public int CLOSING_GSV;

				public int getCLOSING_GSV () {
					return this.CLOSING_GSV;
				}
				
			    public int OPENING_TCV;

				public int getOPENING_TCV () {
					return this.OPENING_TCV;
				}
				
			    public int CLOSING_TCV;

				public int getCLOSING_TCV () {
					return this.CLOSING_TCV;
				}
				
			    public double OPENING_CTL;

				public double getOPENING_CTL () {
					return this.OPENING_CTL;
				}
				
			    public double CLOSING_CTL;

				public double getCLOSING_CTL () {
					return this.CLOSING_CTL;
				}
				
			    public double OPENING_AMBIENT_TEMPERATURE;

				public double getOPENING_AMBIENT_TEMPERATURE () {
					return this.OPENING_AMBIENT_TEMPERATURE;
				}
				
			    public double CLOSING_AMBIENT_TEMPERATURE;

				public double getCLOSING_AMBIENT_TEMPERATURE () {
					return this.CLOSING_AMBIENT_TEMPERATURE;
				}
				
			    public int OPENING_GSW;

				public int getOPENING_GSW () {
					return this.OPENING_GSW;
				}
				
			    public int CLOSING_GSW;

				public int getCLOSING_GSW () {
					return this.CLOSING_GSW;
				}
				
			    public int OPENING_NSW;

				public int getOPENING_NSW () {
					return this.OPENING_NSW;
				}
				
			    public int CLOSING_NSW;

				public int getCLOSING_NSW () {
					return this.CLOSING_NSW;
				}
				
			    public double OPENING_WCF;

				public double getOPENING_WCF () {
					return this.OPENING_WCF;
				}
				
			    public double CLOSING_WCF;

				public double getCLOSING_WCF () {
					return this.CLOSING_WCF;
				}
				
			    public int OPENING_NSV;

				public int getOPENING_NSV () {
					return this.OPENING_NSV;
				}
				
			    public int CLOSING_NSV;

				public int getCLOSING_NSV () {
					return this.CLOSING_NSV;
				}
				
			    public int OPENING_XCTN_GROSS_QTY;

				public int getOPENING_XCTN_GROSS_QTY () {
					return this.OPENING_XCTN_GROSS_QTY;
				}
				
			    public int CLOSING_XCTN_GROSS_QTY;

				public int getCLOSING_XCTN_GROSS_QTY () {
					return this.CLOSING_XCTN_GROSS_QTY;
				}
				
			    public int OPENING_XCTN_NET_QTY;

				public int getOPENING_XCTN_NET_QTY () {
					return this.OPENING_XCTN_NET_QTY;
				}
				
			    public int CLOSING_XCTN_NET_QTY;

				public int getCLOSING_XCTN_NET_QTY () {
					return this.CLOSING_XCTN_NET_QTY;
				}
				
			    public int OPENING_WEIGHT_IN_AIR;

				public int getOPENING_WEIGHT_IN_AIR () {
					return this.OPENING_WEIGHT_IN_AIR;
				}
				
			    public int CLOSING_WEIGHT_IN_AIR;

				public int getCLOSING_WEIGHT_IN_AIR () {
					return this.CLOSING_WEIGHT_IN_AIR;
				}
				
			    public int OPENING_XCTN_WEIGHT;

				public int getOPENING_XCTN_WEIGHT () {
					return this.OPENING_XCTN_WEIGHT;
				}
				
			    public int CLOSING_XCTN_WEIGHT;

				public int getCLOSING_XCTN_WEIGHT () {
					return this.CLOSING_XCTN_WEIGHT;
				}
				
			    public int OPENING_CALCULATION_POINT;

				public int getOPENING_CALCULATION_POINT () {
					return this.OPENING_CALCULATION_POINT;
				}
				
			    public int CLOSING_CALCULATION_POINT;

				public int getCLOSING_CALCULATION_POINT () {
					return this.CLOSING_CALCULATION_POINT;
				}
				
			    public int OPENING_PRODUCT_STRAP_TYPE;

				public int getOPENING_PRODUCT_STRAP_TYPE () {
					return this.OPENING_PRODUCT_STRAP_TYPE;
				}
				
			    public String OPENING_API_CODE;

				public String getOPENING_API_CODE () {
					return this.OPENING_API_CODE;
				}
				
			    public int CLOSING_PRODUCT_STRAP_TYPE;

				public int getCLOSING_PRODUCT_STRAP_TYPE () {
					return this.CLOSING_PRODUCT_STRAP_TYPE;
				}
				
			    public String CLOSING_API_CODE;

				public String getCLOSING_API_CODE () {
					return this.CLOSING_API_CODE;
				}
				
			    public int OPENING_TEMPERATURE_ORIGIN;

				public int getOPENING_TEMPERATURE_ORIGIN () {
					return this.OPENING_TEMPERATURE_ORIGIN;
				}
				
			    public int CLOSING_TEMPERATURE_ORIGIN;

				public int getCLOSING_TEMPERATURE_ORIGIN () {
					return this.CLOSING_TEMPERATURE_ORIGIN;
				}
				
			    public int INVENTORY_QUANTITY_TYPE;

				public int getINVENTORY_QUANTITY_TYPE () {
					return this.INVENTORY_QUANTITY_TYPE;
				}
				
			    public int COMPARTMENT_VISIT_NUMBER;

				public int getCOMPARTMENT_VISIT_NUMBER () {
					return this.COMPARTMENT_VISIT_NUMBER;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
							result = prime * result + (int) this.TERMINAL_PRODUCT_NUMBER;
						
						result = prime * result + ((this.FOLIO_NUMBER == null) ? 0 : this.FOLIO_NUMBER.hashCode());
					
						result = prime * result + ((this.TANK_CODE == null) ? 0 : this.TANK_CODE.hashCode());
					
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
		
						if (this.TERMINAL_PRODUCT_NUMBER != other.TERMINAL_PRODUCT_NUMBER)
							return false;
					
						if (this.FOLIO_NUMBER == null) {
							if (other.FOLIO_NUMBER != null)
								return false;
						
						} else if (!this.FOLIO_NUMBER.equals(other.FOLIO_NUMBER))
						
							return false;
					
						if (this.TANK_CODE == null) {
							if (other.TANK_CODE != null)
								return false;
						
						} else if (!this.TANK_CODE.equals(other.TANK_CODE))
						
							return false;
					

		return true;
    }

	public void copyDataTo(row3Struct other) {

		other.PK_GAIN_LOSS_HISTORY = this.PK_GAIN_LOSS_HISTORY;
	            other.TERMINAL_PRODUCT_NUMBER = this.TERMINAL_PRODUCT_NUMBER;
	            other.DATE = this.DATE;
	            other.FOLIO_NUMBER = this.FOLIO_NUMBER;
	            other.TANK_CODE = this.TANK_CODE;
	            other.GAIN_LOSS_ID = this.GAIN_LOSS_ID;
	            other.PRODUCT_GROUP_CODE = this.PRODUCT_GROUP_CODE;
	            other.OPENING_PHYSICAL = this.OPENING_PHYSICAL;
	            other.BULK_RECEIPTS = this.BULK_RECEIPTS;
	            other.BULK_TRANSFERS_IN = this.BULK_TRANSFERS_IN;
	            other.BULK_TRANSFERS_OUT = this.BULK_TRANSFERS_OUT;
	            other.RACK_DISPOSALS = this.RACK_DISPOSALS;
	            other.CLOSING_PHYSICAL = this.CLOSING_PHYSICAL;
	            other.GAIN_LOSS = this.GAIN_LOSS;
	            other.OPENING_PHYSICAL_GROSS_QTY = this.OPENING_PHYSICAL_GROSS_QTY;
	            other.CLOSING_PHYSICAL_GROSS_QTY = this.CLOSING_PHYSICAL_GROSS_QTY;
	            other.OPENING_TEMPERATURE = this.OPENING_TEMPERATURE;
	            other.CLOSING_TEMPERATURE = this.CLOSING_TEMPERATURE;
	            other.OPENING_DENSITY = this.OPENING_DENSITY;
	            other.CLOSING_DENSITY = this.CLOSING_DENSITY;
	            other.OPENING_BSW_QTY = this.OPENING_BSW_QTY;
	            other.CLOSING_BSW_QTY = this.CLOSING_BSW_QTY;
	            other.OPENING_LEVEL = this.OPENING_LEVEL;
	            other.CLOSING_LEVEL = this.CLOSING_LEVEL;
	            other.OPENING_OBSERVED_DENSITY = this.OPENING_OBSERVED_DENSITY;
	            other.CLOSING_OBSERVED_DENSITY = this.CLOSING_OBSERVED_DENSITY;
	            other.OPENING_BSW_LEVEL = this.OPENING_BSW_LEVEL;
	            other.CLOSING_BSW_LEVEL = this.CLOSING_BSW_LEVEL;
	            other.OPENING_TOV = this.OPENING_TOV;
	            other.CLOSING_TOV = this.CLOSING_TOV;
	            other.OPENING_GOV = this.OPENING_GOV;
	            other.CLOSING_GOV = this.CLOSING_GOV;
	            other.OPENING_GSV = this.OPENING_GSV;
	            other.CLOSING_GSV = this.CLOSING_GSV;
	            other.OPENING_TCV = this.OPENING_TCV;
	            other.CLOSING_TCV = this.CLOSING_TCV;
	            other.OPENING_CTL = this.OPENING_CTL;
	            other.CLOSING_CTL = this.CLOSING_CTL;
	            other.OPENING_AMBIENT_TEMPERATURE = this.OPENING_AMBIENT_TEMPERATURE;
	            other.CLOSING_AMBIENT_TEMPERATURE = this.CLOSING_AMBIENT_TEMPERATURE;
	            other.OPENING_GSW = this.OPENING_GSW;
	            other.CLOSING_GSW = this.CLOSING_GSW;
	            other.OPENING_NSW = this.OPENING_NSW;
	            other.CLOSING_NSW = this.CLOSING_NSW;
	            other.OPENING_WCF = this.OPENING_WCF;
	            other.CLOSING_WCF = this.CLOSING_WCF;
	            other.OPENING_NSV = this.OPENING_NSV;
	            other.CLOSING_NSV = this.CLOSING_NSV;
	            other.OPENING_XCTN_GROSS_QTY = this.OPENING_XCTN_GROSS_QTY;
	            other.CLOSING_XCTN_GROSS_QTY = this.CLOSING_XCTN_GROSS_QTY;
	            other.OPENING_XCTN_NET_QTY = this.OPENING_XCTN_NET_QTY;
	            other.CLOSING_XCTN_NET_QTY = this.CLOSING_XCTN_NET_QTY;
	            other.OPENING_WEIGHT_IN_AIR = this.OPENING_WEIGHT_IN_AIR;
	            other.CLOSING_WEIGHT_IN_AIR = this.CLOSING_WEIGHT_IN_AIR;
	            other.OPENING_XCTN_WEIGHT = this.OPENING_XCTN_WEIGHT;
	            other.CLOSING_XCTN_WEIGHT = this.CLOSING_XCTN_WEIGHT;
	            other.OPENING_CALCULATION_POINT = this.OPENING_CALCULATION_POINT;
	            other.CLOSING_CALCULATION_POINT = this.CLOSING_CALCULATION_POINT;
	            other.OPENING_PRODUCT_STRAP_TYPE = this.OPENING_PRODUCT_STRAP_TYPE;
	            other.OPENING_API_CODE = this.OPENING_API_CODE;
	            other.CLOSING_PRODUCT_STRAP_TYPE = this.CLOSING_PRODUCT_STRAP_TYPE;
	            other.CLOSING_API_CODE = this.CLOSING_API_CODE;
	            other.OPENING_TEMPERATURE_ORIGIN = this.OPENING_TEMPERATURE_ORIGIN;
	            other.CLOSING_TEMPERATURE_ORIGIN = this.CLOSING_TEMPERATURE_ORIGIN;
	            other.INVENTORY_QUANTITY_TYPE = this.INVENTORY_QUANTITY_TYPE;
	            other.COMPARTMENT_VISIT_NUMBER = this.COMPARTMENT_VISIT_NUMBER;
	            
	}

	public void copyKeysDataTo(row3Struct other) {

		other.TERMINAL_PRODUCT_NUMBER = this.TERMINAL_PRODUCT_NUMBER;
	            	other.FOLIO_NUMBER = this.FOLIO_NUMBER;
	            	other.TANK_CODE = this.TANK_CODE;
	            	
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

	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PGS_STAGE_DIM_GAIN_LOSS_HISTORY.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_GAIN_LOSS_HISTORY.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_GAIN_LOSS_HISTORY = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_GAIN_LOSS_HISTORY = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PGS_STAGE_DIM_GAIN_LOSS_HISTORY, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_GAIN_LOSS_HISTORY, 0, length, utf8Charset);
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
			if(length > commonByteArray_PGS_STAGE_DIM_GAIN_LOSS_HISTORY.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_GAIN_LOSS_HISTORY.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_GAIN_LOSS_HISTORY = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_GAIN_LOSS_HISTORY = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PGS_STAGE_DIM_GAIN_LOSS_HISTORY, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_GAIN_LOSS_HISTORY, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_GAIN_LOSS_HISTORY) {

        	try {

        		int length = 0;
		
			        this.TERMINAL_PRODUCT_NUMBER = dis.readInt();
					
					this.FOLIO_NUMBER = readString(dis);
					
					this.TANK_CODE = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_GAIN_LOSS_HISTORY) {

        	try {

        		int length = 0;
		
			        this.TERMINAL_PRODUCT_NUMBER = dis.readInt();
					
					this.FOLIO_NUMBER = readString(dis);
					
					this.TANK_CODE = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.TERMINAL_PRODUCT_NUMBER);
					
					// String
				
						writeString(this.FOLIO_NUMBER,dos);
					
					// String
				
						writeString(this.TANK_CODE,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.TERMINAL_PRODUCT_NUMBER);
					
					// String
				
						writeString(this.FOLIO_NUMBER,dos);
					
					// String
				
						writeString(this.TANK_CODE,dos);
					
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
		
			            this.PK_GAIN_LOSS_HISTORY = dis.readInt();
					
						this.DATE = readDate(dis,ois);
					
			            this.GAIN_LOSS_ID = dis.readInt();
					
						this.PRODUCT_GROUP_CODE = readString(dis,ois);
					
			            this.OPENING_PHYSICAL = dis.readInt();
					
			            this.BULK_RECEIPTS = dis.readInt();
					
			            this.BULK_TRANSFERS_IN = dis.readInt();
					
			            this.BULK_TRANSFERS_OUT = dis.readInt();
					
			            this.RACK_DISPOSALS = dis.readInt();
					
			            this.CLOSING_PHYSICAL = dis.readInt();
					
			            this.GAIN_LOSS = dis.readInt();
					
			            this.OPENING_PHYSICAL_GROSS_QTY = dis.readInt();
					
			            this.CLOSING_PHYSICAL_GROSS_QTY = dis.readInt();
					
			            this.OPENING_TEMPERATURE = dis.readDouble();
					
			            this.CLOSING_TEMPERATURE = dis.readDouble();
					
			            this.OPENING_DENSITY = dis.readDouble();
					
			            this.CLOSING_DENSITY = dis.readDouble();
					
			            this.OPENING_BSW_QTY = dis.readInt();
					
			            this.CLOSING_BSW_QTY = dis.readInt();
					
						this.OPENING_LEVEL = readString(dis,ois);
					
						this.CLOSING_LEVEL = readString(dis,ois);
					
			            this.OPENING_OBSERVED_DENSITY = dis.readDouble();
					
			            this.CLOSING_OBSERVED_DENSITY = dis.readDouble();
					
						this.OPENING_BSW_LEVEL = readString(dis,ois);
					
						this.CLOSING_BSW_LEVEL = readString(dis,ois);
					
			            this.OPENING_TOV = dis.readInt();
					
			            this.CLOSING_TOV = dis.readInt();
					
			            this.OPENING_GOV = dis.readInt();
					
			            this.CLOSING_GOV = dis.readInt();
					
			            this.OPENING_GSV = dis.readInt();
					
			            this.CLOSING_GSV = dis.readInt();
					
			            this.OPENING_TCV = dis.readInt();
					
			            this.CLOSING_TCV = dis.readInt();
					
			            this.OPENING_CTL = dis.readDouble();
					
			            this.CLOSING_CTL = dis.readDouble();
					
			            this.OPENING_AMBIENT_TEMPERATURE = dis.readDouble();
					
			            this.CLOSING_AMBIENT_TEMPERATURE = dis.readDouble();
					
			            this.OPENING_GSW = dis.readInt();
					
			            this.CLOSING_GSW = dis.readInt();
					
			            this.OPENING_NSW = dis.readInt();
					
			            this.CLOSING_NSW = dis.readInt();
					
			            this.OPENING_WCF = dis.readDouble();
					
			            this.CLOSING_WCF = dis.readDouble();
					
			            this.OPENING_NSV = dis.readInt();
					
			            this.CLOSING_NSV = dis.readInt();
					
			            this.OPENING_XCTN_GROSS_QTY = dis.readInt();
					
			            this.CLOSING_XCTN_GROSS_QTY = dis.readInt();
					
			            this.OPENING_XCTN_NET_QTY = dis.readInt();
					
			            this.CLOSING_XCTN_NET_QTY = dis.readInt();
					
			            this.OPENING_WEIGHT_IN_AIR = dis.readInt();
					
			            this.CLOSING_WEIGHT_IN_AIR = dis.readInt();
					
			            this.OPENING_XCTN_WEIGHT = dis.readInt();
					
			            this.CLOSING_XCTN_WEIGHT = dis.readInt();
					
			            this.OPENING_CALCULATION_POINT = dis.readInt();
					
			            this.CLOSING_CALCULATION_POINT = dis.readInt();
					
			            this.OPENING_PRODUCT_STRAP_TYPE = dis.readInt();
					
						this.OPENING_API_CODE = readString(dis,ois);
					
			            this.CLOSING_PRODUCT_STRAP_TYPE = dis.readInt();
					
						this.CLOSING_API_CODE = readString(dis,ois);
					
			            this.OPENING_TEMPERATURE_ORIGIN = dis.readInt();
					
			            this.CLOSING_TEMPERATURE_ORIGIN = dis.readInt();
					
			            this.INVENTORY_QUANTITY_TYPE = dis.readInt();
					
			            this.COMPARTMENT_VISIT_NUMBER = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
			            this.PK_GAIN_LOSS_HISTORY = objectIn.readInt();
					
						this.DATE = readDate(dis,objectIn);
					
			            this.GAIN_LOSS_ID = objectIn.readInt();
					
						this.PRODUCT_GROUP_CODE = readString(dis,objectIn);
					
			            this.OPENING_PHYSICAL = objectIn.readInt();
					
			            this.BULK_RECEIPTS = objectIn.readInt();
					
			            this.BULK_TRANSFERS_IN = objectIn.readInt();
					
			            this.BULK_TRANSFERS_OUT = objectIn.readInt();
					
			            this.RACK_DISPOSALS = objectIn.readInt();
					
			            this.CLOSING_PHYSICAL = objectIn.readInt();
					
			            this.GAIN_LOSS = objectIn.readInt();
					
			            this.OPENING_PHYSICAL_GROSS_QTY = objectIn.readInt();
					
			            this.CLOSING_PHYSICAL_GROSS_QTY = objectIn.readInt();
					
			            this.OPENING_TEMPERATURE = objectIn.readDouble();
					
			            this.CLOSING_TEMPERATURE = objectIn.readDouble();
					
			            this.OPENING_DENSITY = objectIn.readDouble();
					
			            this.CLOSING_DENSITY = objectIn.readDouble();
					
			            this.OPENING_BSW_QTY = objectIn.readInt();
					
			            this.CLOSING_BSW_QTY = objectIn.readInt();
					
						this.OPENING_LEVEL = readString(dis,objectIn);
					
						this.CLOSING_LEVEL = readString(dis,objectIn);
					
			            this.OPENING_OBSERVED_DENSITY = objectIn.readDouble();
					
			            this.CLOSING_OBSERVED_DENSITY = objectIn.readDouble();
					
						this.OPENING_BSW_LEVEL = readString(dis,objectIn);
					
						this.CLOSING_BSW_LEVEL = readString(dis,objectIn);
					
			            this.OPENING_TOV = objectIn.readInt();
					
			            this.CLOSING_TOV = objectIn.readInt();
					
			            this.OPENING_GOV = objectIn.readInt();
					
			            this.CLOSING_GOV = objectIn.readInt();
					
			            this.OPENING_GSV = objectIn.readInt();
					
			            this.CLOSING_GSV = objectIn.readInt();
					
			            this.OPENING_TCV = objectIn.readInt();
					
			            this.CLOSING_TCV = objectIn.readInt();
					
			            this.OPENING_CTL = objectIn.readDouble();
					
			            this.CLOSING_CTL = objectIn.readDouble();
					
			            this.OPENING_AMBIENT_TEMPERATURE = objectIn.readDouble();
					
			            this.CLOSING_AMBIENT_TEMPERATURE = objectIn.readDouble();
					
			            this.OPENING_GSW = objectIn.readInt();
					
			            this.CLOSING_GSW = objectIn.readInt();
					
			            this.OPENING_NSW = objectIn.readInt();
					
			            this.CLOSING_NSW = objectIn.readInt();
					
			            this.OPENING_WCF = objectIn.readDouble();
					
			            this.CLOSING_WCF = objectIn.readDouble();
					
			            this.OPENING_NSV = objectIn.readInt();
					
			            this.CLOSING_NSV = objectIn.readInt();
					
			            this.OPENING_XCTN_GROSS_QTY = objectIn.readInt();
					
			            this.CLOSING_XCTN_GROSS_QTY = objectIn.readInt();
					
			            this.OPENING_XCTN_NET_QTY = objectIn.readInt();
					
			            this.CLOSING_XCTN_NET_QTY = objectIn.readInt();
					
			            this.OPENING_WEIGHT_IN_AIR = objectIn.readInt();
					
			            this.CLOSING_WEIGHT_IN_AIR = objectIn.readInt();
					
			            this.OPENING_XCTN_WEIGHT = objectIn.readInt();
					
			            this.CLOSING_XCTN_WEIGHT = objectIn.readInt();
					
			            this.OPENING_CALCULATION_POINT = objectIn.readInt();
					
			            this.CLOSING_CALCULATION_POINT = objectIn.readInt();
					
			            this.OPENING_PRODUCT_STRAP_TYPE = objectIn.readInt();
					
						this.OPENING_API_CODE = readString(dis,objectIn);
					
			            this.CLOSING_PRODUCT_STRAP_TYPE = objectIn.readInt();
					
						this.CLOSING_API_CODE = readString(dis,objectIn);
					
			            this.OPENING_TEMPERATURE_ORIGIN = objectIn.readInt();
					
			            this.CLOSING_TEMPERATURE_ORIGIN = objectIn.readInt();
					
			            this.INVENTORY_QUANTITY_TYPE = objectIn.readInt();
					
			            this.COMPARTMENT_VISIT_NUMBER = objectIn.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
		            	dos.writeInt(this.PK_GAIN_LOSS_HISTORY);
					
						writeDate(this.DATE, dos, oos);
					
		            	dos.writeInt(this.GAIN_LOSS_ID);
					
						writeString(this.PRODUCT_GROUP_CODE, dos, oos);
					
		            	dos.writeInt(this.OPENING_PHYSICAL);
					
		            	dos.writeInt(this.BULK_RECEIPTS);
					
		            	dos.writeInt(this.BULK_TRANSFERS_IN);
					
		            	dos.writeInt(this.BULK_TRANSFERS_OUT);
					
		            	dos.writeInt(this.RACK_DISPOSALS);
					
		            	dos.writeInt(this.CLOSING_PHYSICAL);
					
		            	dos.writeInt(this.GAIN_LOSS);
					
		            	dos.writeInt(this.OPENING_PHYSICAL_GROSS_QTY);
					
		            	dos.writeInt(this.CLOSING_PHYSICAL_GROSS_QTY);
					
		            	dos.writeDouble(this.OPENING_TEMPERATURE);
					
		            	dos.writeDouble(this.CLOSING_TEMPERATURE);
					
		            	dos.writeDouble(this.OPENING_DENSITY);
					
		            	dos.writeDouble(this.CLOSING_DENSITY);
					
		            	dos.writeInt(this.OPENING_BSW_QTY);
					
		            	dos.writeInt(this.CLOSING_BSW_QTY);
					
						writeString(this.OPENING_LEVEL, dos, oos);
					
						writeString(this.CLOSING_LEVEL, dos, oos);
					
		            	dos.writeDouble(this.OPENING_OBSERVED_DENSITY);
					
		            	dos.writeDouble(this.CLOSING_OBSERVED_DENSITY);
					
						writeString(this.OPENING_BSW_LEVEL, dos, oos);
					
						writeString(this.CLOSING_BSW_LEVEL, dos, oos);
					
		            	dos.writeInt(this.OPENING_TOV);
					
		            	dos.writeInt(this.CLOSING_TOV);
					
		            	dos.writeInt(this.OPENING_GOV);
					
		            	dos.writeInt(this.CLOSING_GOV);
					
		            	dos.writeInt(this.OPENING_GSV);
					
		            	dos.writeInt(this.CLOSING_GSV);
					
		            	dos.writeInt(this.OPENING_TCV);
					
		            	dos.writeInt(this.CLOSING_TCV);
					
		            	dos.writeDouble(this.OPENING_CTL);
					
		            	dos.writeDouble(this.CLOSING_CTL);
					
		            	dos.writeDouble(this.OPENING_AMBIENT_TEMPERATURE);
					
		            	dos.writeDouble(this.CLOSING_AMBIENT_TEMPERATURE);
					
		            	dos.writeInt(this.OPENING_GSW);
					
		            	dos.writeInt(this.CLOSING_GSW);
					
		            	dos.writeInt(this.OPENING_NSW);
					
		            	dos.writeInt(this.CLOSING_NSW);
					
		            	dos.writeDouble(this.OPENING_WCF);
					
		            	dos.writeDouble(this.CLOSING_WCF);
					
		            	dos.writeInt(this.OPENING_NSV);
					
		            	dos.writeInt(this.CLOSING_NSV);
					
		            	dos.writeInt(this.OPENING_XCTN_GROSS_QTY);
					
		            	dos.writeInt(this.CLOSING_XCTN_GROSS_QTY);
					
		            	dos.writeInt(this.OPENING_XCTN_NET_QTY);
					
		            	dos.writeInt(this.CLOSING_XCTN_NET_QTY);
					
		            	dos.writeInt(this.OPENING_WEIGHT_IN_AIR);
					
		            	dos.writeInt(this.CLOSING_WEIGHT_IN_AIR);
					
		            	dos.writeInt(this.OPENING_XCTN_WEIGHT);
					
		            	dos.writeInt(this.CLOSING_XCTN_WEIGHT);
					
		            	dos.writeInt(this.OPENING_CALCULATION_POINT);
					
		            	dos.writeInt(this.CLOSING_CALCULATION_POINT);
					
		            	dos.writeInt(this.OPENING_PRODUCT_STRAP_TYPE);
					
						writeString(this.OPENING_API_CODE, dos, oos);
					
		            	dos.writeInt(this.CLOSING_PRODUCT_STRAP_TYPE);
					
						writeString(this.CLOSING_API_CODE, dos, oos);
					
		            	dos.writeInt(this.OPENING_TEMPERATURE_ORIGIN);
					
		            	dos.writeInt(this.CLOSING_TEMPERATURE_ORIGIN);
					
		            	dos.writeInt(this.INVENTORY_QUANTITY_TYPE);
					
		            	dos.writeInt(this.COMPARTMENT_VISIT_NUMBER);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
					objectOut.writeInt(this.PK_GAIN_LOSS_HISTORY);
					
						writeDate(this.DATE, dos, objectOut);
					
					objectOut.writeInt(this.GAIN_LOSS_ID);
					
						writeString(this.PRODUCT_GROUP_CODE, dos, objectOut);
					
					objectOut.writeInt(this.OPENING_PHYSICAL);
					
					objectOut.writeInt(this.BULK_RECEIPTS);
					
					objectOut.writeInt(this.BULK_TRANSFERS_IN);
					
					objectOut.writeInt(this.BULK_TRANSFERS_OUT);
					
					objectOut.writeInt(this.RACK_DISPOSALS);
					
					objectOut.writeInt(this.CLOSING_PHYSICAL);
					
					objectOut.writeInt(this.GAIN_LOSS);
					
					objectOut.writeInt(this.OPENING_PHYSICAL_GROSS_QTY);
					
					objectOut.writeInt(this.CLOSING_PHYSICAL_GROSS_QTY);
					
					objectOut.writeDouble(this.OPENING_TEMPERATURE);
					
					objectOut.writeDouble(this.CLOSING_TEMPERATURE);
					
					objectOut.writeDouble(this.OPENING_DENSITY);
					
					objectOut.writeDouble(this.CLOSING_DENSITY);
					
					objectOut.writeInt(this.OPENING_BSW_QTY);
					
					objectOut.writeInt(this.CLOSING_BSW_QTY);
					
						writeString(this.OPENING_LEVEL, dos, objectOut);
					
						writeString(this.CLOSING_LEVEL, dos, objectOut);
					
					objectOut.writeDouble(this.OPENING_OBSERVED_DENSITY);
					
					objectOut.writeDouble(this.CLOSING_OBSERVED_DENSITY);
					
						writeString(this.OPENING_BSW_LEVEL, dos, objectOut);
					
						writeString(this.CLOSING_BSW_LEVEL, dos, objectOut);
					
					objectOut.writeInt(this.OPENING_TOV);
					
					objectOut.writeInt(this.CLOSING_TOV);
					
					objectOut.writeInt(this.OPENING_GOV);
					
					objectOut.writeInt(this.CLOSING_GOV);
					
					objectOut.writeInt(this.OPENING_GSV);
					
					objectOut.writeInt(this.CLOSING_GSV);
					
					objectOut.writeInt(this.OPENING_TCV);
					
					objectOut.writeInt(this.CLOSING_TCV);
					
					objectOut.writeDouble(this.OPENING_CTL);
					
					objectOut.writeDouble(this.CLOSING_CTL);
					
					objectOut.writeDouble(this.OPENING_AMBIENT_TEMPERATURE);
					
					objectOut.writeDouble(this.CLOSING_AMBIENT_TEMPERATURE);
					
					objectOut.writeInt(this.OPENING_GSW);
					
					objectOut.writeInt(this.CLOSING_GSW);
					
					objectOut.writeInt(this.OPENING_NSW);
					
					objectOut.writeInt(this.CLOSING_NSW);
					
					objectOut.writeDouble(this.OPENING_WCF);
					
					objectOut.writeDouble(this.CLOSING_WCF);
					
					objectOut.writeInt(this.OPENING_NSV);
					
					objectOut.writeInt(this.CLOSING_NSV);
					
					objectOut.writeInt(this.OPENING_XCTN_GROSS_QTY);
					
					objectOut.writeInt(this.CLOSING_XCTN_GROSS_QTY);
					
					objectOut.writeInt(this.OPENING_XCTN_NET_QTY);
					
					objectOut.writeInt(this.CLOSING_XCTN_NET_QTY);
					
					objectOut.writeInt(this.OPENING_WEIGHT_IN_AIR);
					
					objectOut.writeInt(this.CLOSING_WEIGHT_IN_AIR);
					
					objectOut.writeInt(this.OPENING_XCTN_WEIGHT);
					
					objectOut.writeInt(this.CLOSING_XCTN_WEIGHT);
					
					objectOut.writeInt(this.OPENING_CALCULATION_POINT);
					
					objectOut.writeInt(this.CLOSING_CALCULATION_POINT);
					
					objectOut.writeInt(this.OPENING_PRODUCT_STRAP_TYPE);
					
						writeString(this.OPENING_API_CODE, dos, objectOut);
					
					objectOut.writeInt(this.CLOSING_PRODUCT_STRAP_TYPE);
					
						writeString(this.CLOSING_API_CODE, dos, objectOut);
					
					objectOut.writeInt(this.OPENING_TEMPERATURE_ORIGIN);
					
					objectOut.writeInt(this.CLOSING_TEMPERATURE_ORIGIN);
					
					objectOut.writeInt(this.INVENTORY_QUANTITY_TYPE);
					
					objectOut.writeInt(this.COMPARTMENT_VISIT_NUMBER);
					
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
		sb.append("PK_GAIN_LOSS_HISTORY="+String.valueOf(PK_GAIN_LOSS_HISTORY));
		sb.append(",TERMINAL_PRODUCT_NUMBER="+String.valueOf(TERMINAL_PRODUCT_NUMBER));
		sb.append(",DATE="+String.valueOf(DATE));
		sb.append(",FOLIO_NUMBER="+FOLIO_NUMBER);
		sb.append(",TANK_CODE="+TANK_CODE);
		sb.append(",GAIN_LOSS_ID="+String.valueOf(GAIN_LOSS_ID));
		sb.append(",PRODUCT_GROUP_CODE="+PRODUCT_GROUP_CODE);
		sb.append(",OPENING_PHYSICAL="+String.valueOf(OPENING_PHYSICAL));
		sb.append(",BULK_RECEIPTS="+String.valueOf(BULK_RECEIPTS));
		sb.append(",BULK_TRANSFERS_IN="+String.valueOf(BULK_TRANSFERS_IN));
		sb.append(",BULK_TRANSFERS_OUT="+String.valueOf(BULK_TRANSFERS_OUT));
		sb.append(",RACK_DISPOSALS="+String.valueOf(RACK_DISPOSALS));
		sb.append(",CLOSING_PHYSICAL="+String.valueOf(CLOSING_PHYSICAL));
		sb.append(",GAIN_LOSS="+String.valueOf(GAIN_LOSS));
		sb.append(",OPENING_PHYSICAL_GROSS_QTY="+String.valueOf(OPENING_PHYSICAL_GROSS_QTY));
		sb.append(",CLOSING_PHYSICAL_GROSS_QTY="+String.valueOf(CLOSING_PHYSICAL_GROSS_QTY));
		sb.append(",OPENING_TEMPERATURE="+String.valueOf(OPENING_TEMPERATURE));
		sb.append(",CLOSING_TEMPERATURE="+String.valueOf(CLOSING_TEMPERATURE));
		sb.append(",OPENING_DENSITY="+String.valueOf(OPENING_DENSITY));
		sb.append(",CLOSING_DENSITY="+String.valueOf(CLOSING_DENSITY));
		sb.append(",OPENING_BSW_QTY="+String.valueOf(OPENING_BSW_QTY));
		sb.append(",CLOSING_BSW_QTY="+String.valueOf(CLOSING_BSW_QTY));
		sb.append(",OPENING_LEVEL="+OPENING_LEVEL);
		sb.append(",CLOSING_LEVEL="+CLOSING_LEVEL);
		sb.append(",OPENING_OBSERVED_DENSITY="+String.valueOf(OPENING_OBSERVED_DENSITY));
		sb.append(",CLOSING_OBSERVED_DENSITY="+String.valueOf(CLOSING_OBSERVED_DENSITY));
		sb.append(",OPENING_BSW_LEVEL="+OPENING_BSW_LEVEL);
		sb.append(",CLOSING_BSW_LEVEL="+CLOSING_BSW_LEVEL);
		sb.append(",OPENING_TOV="+String.valueOf(OPENING_TOV));
		sb.append(",CLOSING_TOV="+String.valueOf(CLOSING_TOV));
		sb.append(",OPENING_GOV="+String.valueOf(OPENING_GOV));
		sb.append(",CLOSING_GOV="+String.valueOf(CLOSING_GOV));
		sb.append(",OPENING_GSV="+String.valueOf(OPENING_GSV));
		sb.append(",CLOSING_GSV="+String.valueOf(CLOSING_GSV));
		sb.append(",OPENING_TCV="+String.valueOf(OPENING_TCV));
		sb.append(",CLOSING_TCV="+String.valueOf(CLOSING_TCV));
		sb.append(",OPENING_CTL="+String.valueOf(OPENING_CTL));
		sb.append(",CLOSING_CTL="+String.valueOf(CLOSING_CTL));
		sb.append(",OPENING_AMBIENT_TEMPERATURE="+String.valueOf(OPENING_AMBIENT_TEMPERATURE));
		sb.append(",CLOSING_AMBIENT_TEMPERATURE="+String.valueOf(CLOSING_AMBIENT_TEMPERATURE));
		sb.append(",OPENING_GSW="+String.valueOf(OPENING_GSW));
		sb.append(",CLOSING_GSW="+String.valueOf(CLOSING_GSW));
		sb.append(",OPENING_NSW="+String.valueOf(OPENING_NSW));
		sb.append(",CLOSING_NSW="+String.valueOf(CLOSING_NSW));
		sb.append(",OPENING_WCF="+String.valueOf(OPENING_WCF));
		sb.append(",CLOSING_WCF="+String.valueOf(CLOSING_WCF));
		sb.append(",OPENING_NSV="+String.valueOf(OPENING_NSV));
		sb.append(",CLOSING_NSV="+String.valueOf(CLOSING_NSV));
		sb.append(",OPENING_XCTN_GROSS_QTY="+String.valueOf(OPENING_XCTN_GROSS_QTY));
		sb.append(",CLOSING_XCTN_GROSS_QTY="+String.valueOf(CLOSING_XCTN_GROSS_QTY));
		sb.append(",OPENING_XCTN_NET_QTY="+String.valueOf(OPENING_XCTN_NET_QTY));
		sb.append(",CLOSING_XCTN_NET_QTY="+String.valueOf(CLOSING_XCTN_NET_QTY));
		sb.append(",OPENING_WEIGHT_IN_AIR="+String.valueOf(OPENING_WEIGHT_IN_AIR));
		sb.append(",CLOSING_WEIGHT_IN_AIR="+String.valueOf(CLOSING_WEIGHT_IN_AIR));
		sb.append(",OPENING_XCTN_WEIGHT="+String.valueOf(OPENING_XCTN_WEIGHT));
		sb.append(",CLOSING_XCTN_WEIGHT="+String.valueOf(CLOSING_XCTN_WEIGHT));
		sb.append(",OPENING_CALCULATION_POINT="+String.valueOf(OPENING_CALCULATION_POINT));
		sb.append(",CLOSING_CALCULATION_POINT="+String.valueOf(CLOSING_CALCULATION_POINT));
		sb.append(",OPENING_PRODUCT_STRAP_TYPE="+String.valueOf(OPENING_PRODUCT_STRAP_TYPE));
		sb.append(",OPENING_API_CODE="+OPENING_API_CODE);
		sb.append(",CLOSING_PRODUCT_STRAP_TYPE="+String.valueOf(CLOSING_PRODUCT_STRAP_TYPE));
		sb.append(",CLOSING_API_CODE="+CLOSING_API_CODE);
		sb.append(",OPENING_TEMPERATURE_ORIGIN="+String.valueOf(OPENING_TEMPERATURE_ORIGIN));
		sb.append(",CLOSING_TEMPERATURE_ORIGIN="+String.valueOf(CLOSING_TEMPERATURE_ORIGIN));
		sb.append(",INVENTORY_QUANTITY_TYPE="+String.valueOf(INVENTORY_QUANTITY_TYPE));
		sb.append(",COMPARTMENT_VISIT_NUMBER="+String.valueOf(COMPARTMENT_VISIT_NUMBER));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row3Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.TERMINAL_PRODUCT_NUMBER, other.TERMINAL_PRODUCT_NUMBER);
						if(returnValue != 0) {
							return returnValue;
						}

					
						returnValue = checkNullsAndCompare(this.FOLIO_NUMBER, other.FOLIO_NUMBER);
						if(returnValue != 0) {
							return returnValue;
						}

					
						returnValue = checkNullsAndCompare(this.TANK_CODE, other.TANK_CODE);
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
				
				 
	final String decryptedPassword_tDBInput_2 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:nOKG2TX2kVT+fFk3hxdqVTSOmE0LSddBfzheirrL6pXdjiEHzkM=");
				
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

		    String dbquery_tDBInput_2 = "SELECT dbo.DIM_GAIN_LOSS_HISTORY.PK_GAIN_LOSS_HISTORY,\n		dbo.DIM_GAIN_LOSS_HISTORY.TERMINAL_PRODUCT_NUMBER,\n		dbo.DIM_G"
+"AIN_LOSS_HISTORY.DATE,\n		dbo.DIM_GAIN_LOSS_HISTORY.FOLIO_NUMBER,\n		dbo.DIM_GAIN_LOSS_HISTORY.TANK_CODE,\n		dbo.DIM_GAIN_L"
+"OSS_HISTORY.GAIN_LOSS_ID,\n		dbo.DIM_GAIN_LOSS_HISTORY.PRODUCT_GROUP_CODE,\n		dbo.DIM_GAIN_LOSS_HISTORY.OPENING_PHYSICAL,\n"
+"		dbo.DIM_GAIN_LOSS_HISTORY.BULK_RECEIPTS,\n		dbo.DIM_GAIN_LOSS_HISTORY.BULK_TRANSFERS_IN,\n		dbo.DIM_GAIN_LOSS_HISTORY.BU"
+"LK_TRANSFERS_OUT,\n		dbo.DIM_GAIN_LOSS_HISTORY.RACK_DISPOSALS,\n		dbo.DIM_GAIN_LOSS_HISTORY.CLOSING_PHYSICAL,\n		dbo.DIM_GA"
+"IN_LOSS_HISTORY.GAIN_LOSS,\n		dbo.DIM_GAIN_LOSS_HISTORY.OPENING_PHYSICAL_GROSS_QTY,\n		dbo.DIM_GAIN_LOSS_HISTORY.CLOSING_P"
+"HYSICAL_GROSS_QTY,\n		dbo.DIM_GAIN_LOSS_HISTORY.OPENING_TEMPERATURE,\n		dbo.DIM_GAIN_LOSS_HISTORY.CLOSING_TEMPERATURE,\n		d"
+"bo.DIM_GAIN_LOSS_HISTORY.OPENING_DENSITY,\n		dbo.DIM_GAIN_LOSS_HISTORY.CLOSING_DENSITY,\n		dbo.DIM_GAIN_LOSS_HISTORY.OPENI"
+"NG_BSW_QTY,\n		dbo.DIM_GAIN_LOSS_HISTORY.CLOSING_BSW_QTY,\n		dbo.DIM_GAIN_LOSS_HISTORY.OPENING_LEVEL,\n		dbo.DIM_GAIN_LOSS_"
+"HISTORY.CLOSING_LEVEL,\n		dbo.DIM_GAIN_LOSS_HISTORY.OPENING_OBSERVED_DENSITY,\n		dbo.DIM_GAIN_LOSS_HISTORY.CLOSING_OBSERVE"
+"D_DENSITY,\n		dbo.DIM_GAIN_LOSS_HISTORY.OPENING_BSW_LEVEL,\n		dbo.DIM_GAIN_LOSS_HISTORY.CLOSING_BSW_LEVEL,\n		dbo.DIM_GAIN_"
+"LOSS_HISTORY.OPENING_TOV,\n		dbo.DIM_GAIN_LOSS_HISTORY.CLOSING_TOV,\n		dbo.DIM_GAIN_LOSS_HISTORY.OPENING_GOV,\n		dbo.DIM_GA"
+"IN_LOSS_HISTORY.CLOSING_GOV,\n		dbo.DIM_GAIN_LOSS_HISTORY.OPENING_GSV,\n		dbo.DIM_GAIN_LOSS_HISTORY.CLOSING_GSV,\n		dbo.DIM"
+"_GAIN_LOSS_HISTORY.OPENING_TCV,\n		dbo.DIM_GAIN_LOSS_HISTORY.CLOSING_TCV,\n		dbo.DIM_GAIN_LOSS_HISTORY.OPENING_CTL,\n		dbo."
+"DIM_GAIN_LOSS_HISTORY.CLOSING_CTL,\n		dbo.DIM_GAIN_LOSS_HISTORY.OPENING_AMBIENT_TEMPERATURE,\n		dbo.DIM_GAIN_LOSS_HISTORY."
+"CLOSING_AMBIENT_TEMPERATURE,\n		dbo.DIM_GAIN_LOSS_HISTORY.OPENING_GSW,\n		dbo.DIM_GAIN_LOSS_HISTORY.CLOSING_GSW,\n		dbo.DIM"
+"_GAIN_LOSS_HISTORY.OPENING_NSW,\n		dbo.DIM_GAIN_LOSS_HISTORY.CLOSING_NSW,\n		dbo.DIM_GAIN_LOSS_HISTORY.OPENING_WCF,\n		dbo."
+"DIM_GAIN_LOSS_HISTORY.CLOSING_WCF,\n		dbo.DIM_GAIN_LOSS_HISTORY.OPENING_NSV,\n		dbo.DIM_GAIN_LOSS_HISTORY.CLOSING_NSV,\n		d"
+"bo.DIM_GAIN_LOSS_HISTORY.OPENING_XCTN_GROSS_QTY,\n		dbo.DIM_GAIN_LOSS_HISTORY.CLOSING_XCTN_GROSS_QTY,\n		dbo.DIM_GAIN_LOSS"
+"_HISTORY.OPENING_XCTN_NET_QTY,\n		dbo.DIM_GAIN_LOSS_HISTORY.CLOSING_XCTN_NET_QTY,\n		dbo.DIM_GAIN_LOSS_HISTORY.OPENING_WEI"
+"GHT_IN_AIR,\n		dbo.DIM_GAIN_LOSS_HISTORY.CLOSING_WEIGHT_IN_AIR,\n		dbo.DIM_GAIN_LOSS_HISTORY.OPENING_XCTN_WEIGHT,\n		dbo.DI"
+"M_GAIN_LOSS_HISTORY.CLOSING_XCTN_WEIGHT,\n		dbo.DIM_GAIN_LOSS_HISTORY.OPENING_CALCULATION_POINT,\n		dbo.DIM_GAIN_LOSS_HIST"
+"ORY.CLOSING_CALCULATION_POINT,\n		dbo.DIM_GAIN_LOSS_HISTORY.OPENING_PRODUCT_STRAP_TYPE,\n		dbo.DIM_GAIN_LOSS_HISTORY.OPENI"
+"NG_API_CODE,\n		dbo.DIM_GAIN_LOSS_HISTORY.CLOSING_PRODUCT_STRAP_TYPE,\n		dbo.DIM_GAIN_LOSS_HISTORY.CLOSING_API_CODE,\n		dbo"
+".DIM_GAIN_LOSS_HISTORY.OPENING_TEMPERATURE_ORIGIN,\n		dbo.DIM_GAIN_LOSS_HISTORY.CLOSING_TEMPERATURE_ORIGIN,\n		dbo.DIM_GAI"
+"N_LOSS_HISTORY.INVENTORY_QUANTITY_TYPE,\n		dbo.DIM_GAIN_LOSS_HISTORY.COMPARTMENT_VISIT_NUMBER\nFROM	dbo.DIM_GAIN_LOSS_HIST"
+"ORY";
		    

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
								row3.PK_GAIN_LOSS_HISTORY = 0;
							} else {
		                          
            row3.PK_GAIN_LOSS_HISTORY = rs_tDBInput_2.getInt(1);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 2) {
								row3.TERMINAL_PRODUCT_NUMBER = 0;
							} else {
		                          
            row3.TERMINAL_PRODUCT_NUMBER = rs_tDBInput_2.getInt(2);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 3) {
								row3.DATE = null;
							} else {
										
			row3.DATE = mssqlGTU_tDBInput_2.getDate(rsmd_tDBInput_2, rs_tDBInput_2, 3);
			
		                    }
							if(colQtyInRs_tDBInput_2 < 4) {
								row3.FOLIO_NUMBER = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(4);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(4).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.FOLIO_NUMBER = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row3.FOLIO_NUMBER = tmpContent_tDBInput_2;
                }
            } else {
                row3.FOLIO_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 5) {
								row3.TANK_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(5);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(5).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.TANK_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row3.TANK_CODE = tmpContent_tDBInput_2;
                }
            } else {
                row3.TANK_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 6) {
								row3.GAIN_LOSS_ID = 0;
							} else {
		                          
            row3.GAIN_LOSS_ID = rs_tDBInput_2.getInt(6);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 7) {
								row3.PRODUCT_GROUP_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(7);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(7).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.PRODUCT_GROUP_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row3.PRODUCT_GROUP_CODE = tmpContent_tDBInput_2;
                }
            } else {
                row3.PRODUCT_GROUP_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 8) {
								row3.OPENING_PHYSICAL = 0;
							} else {
		                          
            row3.OPENING_PHYSICAL = rs_tDBInput_2.getInt(8);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 9) {
								row3.BULK_RECEIPTS = 0;
							} else {
		                          
            row3.BULK_RECEIPTS = rs_tDBInput_2.getInt(9);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 10) {
								row3.BULK_TRANSFERS_IN = 0;
							} else {
		                          
            row3.BULK_TRANSFERS_IN = rs_tDBInput_2.getInt(10);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 11) {
								row3.BULK_TRANSFERS_OUT = 0;
							} else {
		                          
            row3.BULK_TRANSFERS_OUT = rs_tDBInput_2.getInt(11);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 12) {
								row3.RACK_DISPOSALS = 0;
							} else {
		                          
            row3.RACK_DISPOSALS = rs_tDBInput_2.getInt(12);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 13) {
								row3.CLOSING_PHYSICAL = 0;
							} else {
		                          
            row3.CLOSING_PHYSICAL = rs_tDBInput_2.getInt(13);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 14) {
								row3.GAIN_LOSS = 0;
							} else {
		                          
            row3.GAIN_LOSS = rs_tDBInput_2.getInt(14);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 15) {
								row3.OPENING_PHYSICAL_GROSS_QTY = 0;
							} else {
		                          
            row3.OPENING_PHYSICAL_GROSS_QTY = rs_tDBInput_2.getInt(15);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 16) {
								row3.CLOSING_PHYSICAL_GROSS_QTY = 0;
							} else {
		                          
            row3.CLOSING_PHYSICAL_GROSS_QTY = rs_tDBInput_2.getInt(16);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 17) {
								row3.OPENING_TEMPERATURE = 0;
							} else {
	                         		
            row3.OPENING_TEMPERATURE = rs_tDBInput_2.getDouble(17);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 18) {
								row3.CLOSING_TEMPERATURE = 0;
							} else {
	                         		
            row3.CLOSING_TEMPERATURE = rs_tDBInput_2.getDouble(18);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 19) {
								row3.OPENING_DENSITY = 0;
							} else {
	                         		
            row3.OPENING_DENSITY = rs_tDBInput_2.getDouble(19);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 20) {
								row3.CLOSING_DENSITY = 0;
							} else {
	                         		
            row3.CLOSING_DENSITY = rs_tDBInput_2.getDouble(20);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 21) {
								row3.OPENING_BSW_QTY = 0;
							} else {
		                          
            row3.OPENING_BSW_QTY = rs_tDBInput_2.getInt(21);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 22) {
								row3.CLOSING_BSW_QTY = 0;
							} else {
		                          
            row3.CLOSING_BSW_QTY = rs_tDBInput_2.getInt(22);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 23) {
								row3.OPENING_LEVEL = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(23);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(23).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.OPENING_LEVEL = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row3.OPENING_LEVEL = tmpContent_tDBInput_2;
                }
            } else {
                row3.OPENING_LEVEL = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 24) {
								row3.CLOSING_LEVEL = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(24);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(24).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.CLOSING_LEVEL = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row3.CLOSING_LEVEL = tmpContent_tDBInput_2;
                }
            } else {
                row3.CLOSING_LEVEL = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 25) {
								row3.OPENING_OBSERVED_DENSITY = 0;
							} else {
	                         		
            row3.OPENING_OBSERVED_DENSITY = rs_tDBInput_2.getDouble(25);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 26) {
								row3.CLOSING_OBSERVED_DENSITY = 0;
							} else {
	                         		
            row3.CLOSING_OBSERVED_DENSITY = rs_tDBInput_2.getDouble(26);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 27) {
								row3.OPENING_BSW_LEVEL = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(27);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(27).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.OPENING_BSW_LEVEL = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row3.OPENING_BSW_LEVEL = tmpContent_tDBInput_2;
                }
            } else {
                row3.OPENING_BSW_LEVEL = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 28) {
								row3.CLOSING_BSW_LEVEL = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(28);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(28).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.CLOSING_BSW_LEVEL = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row3.CLOSING_BSW_LEVEL = tmpContent_tDBInput_2;
                }
            } else {
                row3.CLOSING_BSW_LEVEL = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 29) {
								row3.OPENING_TOV = 0;
							} else {
		                          
            row3.OPENING_TOV = rs_tDBInput_2.getInt(29);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 30) {
								row3.CLOSING_TOV = 0;
							} else {
		                          
            row3.CLOSING_TOV = rs_tDBInput_2.getInt(30);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 31) {
								row3.OPENING_GOV = 0;
							} else {
		                          
            row3.OPENING_GOV = rs_tDBInput_2.getInt(31);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 32) {
								row3.CLOSING_GOV = 0;
							} else {
		                          
            row3.CLOSING_GOV = rs_tDBInput_2.getInt(32);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 33) {
								row3.OPENING_GSV = 0;
							} else {
		                          
            row3.OPENING_GSV = rs_tDBInput_2.getInt(33);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 34) {
								row3.CLOSING_GSV = 0;
							} else {
		                          
            row3.CLOSING_GSV = rs_tDBInput_2.getInt(34);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 35) {
								row3.OPENING_TCV = 0;
							} else {
		                          
            row3.OPENING_TCV = rs_tDBInput_2.getInt(35);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 36) {
								row3.CLOSING_TCV = 0;
							} else {
		                          
            row3.CLOSING_TCV = rs_tDBInput_2.getInt(36);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 37) {
								row3.OPENING_CTL = 0;
							} else {
	                         		
            row3.OPENING_CTL = rs_tDBInput_2.getDouble(37);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 38) {
								row3.CLOSING_CTL = 0;
							} else {
	                         		
            row3.CLOSING_CTL = rs_tDBInput_2.getDouble(38);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 39) {
								row3.OPENING_AMBIENT_TEMPERATURE = 0;
							} else {
	                         		
            row3.OPENING_AMBIENT_TEMPERATURE = rs_tDBInput_2.getDouble(39);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 40) {
								row3.CLOSING_AMBIENT_TEMPERATURE = 0;
							} else {
	                         		
            row3.CLOSING_AMBIENT_TEMPERATURE = rs_tDBInput_2.getDouble(40);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 41) {
								row3.OPENING_GSW = 0;
							} else {
		                          
            row3.OPENING_GSW = rs_tDBInput_2.getInt(41);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 42) {
								row3.CLOSING_GSW = 0;
							} else {
		                          
            row3.CLOSING_GSW = rs_tDBInput_2.getInt(42);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 43) {
								row3.OPENING_NSW = 0;
							} else {
		                          
            row3.OPENING_NSW = rs_tDBInput_2.getInt(43);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 44) {
								row3.CLOSING_NSW = 0;
							} else {
		                          
            row3.CLOSING_NSW = rs_tDBInput_2.getInt(44);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 45) {
								row3.OPENING_WCF = 0;
							} else {
	                         		
            row3.OPENING_WCF = rs_tDBInput_2.getDouble(45);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 46) {
								row3.CLOSING_WCF = 0;
							} else {
	                         		
            row3.CLOSING_WCF = rs_tDBInput_2.getDouble(46);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 47) {
								row3.OPENING_NSV = 0;
							} else {
		                          
            row3.OPENING_NSV = rs_tDBInput_2.getInt(47);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 48) {
								row3.CLOSING_NSV = 0;
							} else {
		                          
            row3.CLOSING_NSV = rs_tDBInput_2.getInt(48);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 49) {
								row3.OPENING_XCTN_GROSS_QTY = 0;
							} else {
		                          
            row3.OPENING_XCTN_GROSS_QTY = rs_tDBInput_2.getInt(49);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 50) {
								row3.CLOSING_XCTN_GROSS_QTY = 0;
							} else {
		                          
            row3.CLOSING_XCTN_GROSS_QTY = rs_tDBInput_2.getInt(50);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 51) {
								row3.OPENING_XCTN_NET_QTY = 0;
							} else {
		                          
            row3.OPENING_XCTN_NET_QTY = rs_tDBInput_2.getInt(51);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 52) {
								row3.CLOSING_XCTN_NET_QTY = 0;
							} else {
		                          
            row3.CLOSING_XCTN_NET_QTY = rs_tDBInput_2.getInt(52);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 53) {
								row3.OPENING_WEIGHT_IN_AIR = 0;
							} else {
		                          
            row3.OPENING_WEIGHT_IN_AIR = rs_tDBInput_2.getInt(53);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 54) {
								row3.CLOSING_WEIGHT_IN_AIR = 0;
							} else {
		                          
            row3.CLOSING_WEIGHT_IN_AIR = rs_tDBInput_2.getInt(54);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 55) {
								row3.OPENING_XCTN_WEIGHT = 0;
							} else {
		                          
            row3.OPENING_XCTN_WEIGHT = rs_tDBInput_2.getInt(55);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 56) {
								row3.CLOSING_XCTN_WEIGHT = 0;
							} else {
		                          
            row3.CLOSING_XCTN_WEIGHT = rs_tDBInput_2.getInt(56);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 57) {
								row3.OPENING_CALCULATION_POINT = 0;
							} else {
		                          
            row3.OPENING_CALCULATION_POINT = rs_tDBInput_2.getInt(57);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 58) {
								row3.CLOSING_CALCULATION_POINT = 0;
							} else {
		                          
            row3.CLOSING_CALCULATION_POINT = rs_tDBInput_2.getInt(58);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 59) {
								row3.OPENING_PRODUCT_STRAP_TYPE = 0;
							} else {
		                          
            row3.OPENING_PRODUCT_STRAP_TYPE = rs_tDBInput_2.getInt(59);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 60) {
								row3.OPENING_API_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(60);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(60).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.OPENING_API_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row3.OPENING_API_CODE = tmpContent_tDBInput_2;
                }
            } else {
                row3.OPENING_API_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 61) {
								row3.CLOSING_PRODUCT_STRAP_TYPE = 0;
							} else {
		                          
            row3.CLOSING_PRODUCT_STRAP_TYPE = rs_tDBInput_2.getInt(61);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 62) {
								row3.CLOSING_API_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(62);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(62).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.CLOSING_API_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row3.CLOSING_API_CODE = tmpContent_tDBInput_2;
                }
            } else {
                row3.CLOSING_API_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 63) {
								row3.OPENING_TEMPERATURE_ORIGIN = 0;
							} else {
		                          
            row3.OPENING_TEMPERATURE_ORIGIN = rs_tDBInput_2.getInt(63);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 64) {
								row3.CLOSING_TEMPERATURE_ORIGIN = 0;
							} else {
		                          
            row3.CLOSING_TEMPERATURE_ORIGIN = rs_tDBInput_2.getInt(64);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 65) {
								row3.INVENTORY_QUANTITY_TYPE = 0;
							} else {
		                          
            row3.INVENTORY_QUANTITY_TYPE = rs_tDBInput_2.getInt(65);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 66) {
								row3.COMPARTMENT_VISIT_NUMBER = 0;
							} else {
		                          
            row3.COMPARTMENT_VISIT_NUMBER = rs_tDBInput_2.getInt(66);
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
		   	   	   
				
				row3_HashRow.PK_GAIN_LOSS_HISTORY = row3.PK_GAIN_LOSS_HISTORY;
				
				row3_HashRow.TERMINAL_PRODUCT_NUMBER = row3.TERMINAL_PRODUCT_NUMBER;
				
				row3_HashRow.DATE = row3.DATE;
				
				row3_HashRow.FOLIO_NUMBER = row3.FOLIO_NUMBER;
				
				row3_HashRow.TANK_CODE = row3.TANK_CODE;
				
				row3_HashRow.GAIN_LOSS_ID = row3.GAIN_LOSS_ID;
				
				row3_HashRow.PRODUCT_GROUP_CODE = row3.PRODUCT_GROUP_CODE;
				
				row3_HashRow.OPENING_PHYSICAL = row3.OPENING_PHYSICAL;
				
				row3_HashRow.BULK_RECEIPTS = row3.BULK_RECEIPTS;
				
				row3_HashRow.BULK_TRANSFERS_IN = row3.BULK_TRANSFERS_IN;
				
				row3_HashRow.BULK_TRANSFERS_OUT = row3.BULK_TRANSFERS_OUT;
				
				row3_HashRow.RACK_DISPOSALS = row3.RACK_DISPOSALS;
				
				row3_HashRow.CLOSING_PHYSICAL = row3.CLOSING_PHYSICAL;
				
				row3_HashRow.GAIN_LOSS = row3.GAIN_LOSS;
				
				row3_HashRow.OPENING_PHYSICAL_GROSS_QTY = row3.OPENING_PHYSICAL_GROSS_QTY;
				
				row3_HashRow.CLOSING_PHYSICAL_GROSS_QTY = row3.CLOSING_PHYSICAL_GROSS_QTY;
				
				row3_HashRow.OPENING_TEMPERATURE = row3.OPENING_TEMPERATURE;
				
				row3_HashRow.CLOSING_TEMPERATURE = row3.CLOSING_TEMPERATURE;
				
				row3_HashRow.OPENING_DENSITY = row3.OPENING_DENSITY;
				
				row3_HashRow.CLOSING_DENSITY = row3.CLOSING_DENSITY;
				
				row3_HashRow.OPENING_BSW_QTY = row3.OPENING_BSW_QTY;
				
				row3_HashRow.CLOSING_BSW_QTY = row3.CLOSING_BSW_QTY;
				
				row3_HashRow.OPENING_LEVEL = row3.OPENING_LEVEL;
				
				row3_HashRow.CLOSING_LEVEL = row3.CLOSING_LEVEL;
				
				row3_HashRow.OPENING_OBSERVED_DENSITY = row3.OPENING_OBSERVED_DENSITY;
				
				row3_HashRow.CLOSING_OBSERVED_DENSITY = row3.CLOSING_OBSERVED_DENSITY;
				
				row3_HashRow.OPENING_BSW_LEVEL = row3.OPENING_BSW_LEVEL;
				
				row3_HashRow.CLOSING_BSW_LEVEL = row3.CLOSING_BSW_LEVEL;
				
				row3_HashRow.OPENING_TOV = row3.OPENING_TOV;
				
				row3_HashRow.CLOSING_TOV = row3.CLOSING_TOV;
				
				row3_HashRow.OPENING_GOV = row3.OPENING_GOV;
				
				row3_HashRow.CLOSING_GOV = row3.CLOSING_GOV;
				
				row3_HashRow.OPENING_GSV = row3.OPENING_GSV;
				
				row3_HashRow.CLOSING_GSV = row3.CLOSING_GSV;
				
				row3_HashRow.OPENING_TCV = row3.OPENING_TCV;
				
				row3_HashRow.CLOSING_TCV = row3.CLOSING_TCV;
				
				row3_HashRow.OPENING_CTL = row3.OPENING_CTL;
				
				row3_HashRow.CLOSING_CTL = row3.CLOSING_CTL;
				
				row3_HashRow.OPENING_AMBIENT_TEMPERATURE = row3.OPENING_AMBIENT_TEMPERATURE;
				
				row3_HashRow.CLOSING_AMBIENT_TEMPERATURE = row3.CLOSING_AMBIENT_TEMPERATURE;
				
				row3_HashRow.OPENING_GSW = row3.OPENING_GSW;
				
				row3_HashRow.CLOSING_GSW = row3.CLOSING_GSW;
				
				row3_HashRow.OPENING_NSW = row3.OPENING_NSW;
				
				row3_HashRow.CLOSING_NSW = row3.CLOSING_NSW;
				
				row3_HashRow.OPENING_WCF = row3.OPENING_WCF;
				
				row3_HashRow.CLOSING_WCF = row3.CLOSING_WCF;
				
				row3_HashRow.OPENING_NSV = row3.OPENING_NSV;
				
				row3_HashRow.CLOSING_NSV = row3.CLOSING_NSV;
				
				row3_HashRow.OPENING_XCTN_GROSS_QTY = row3.OPENING_XCTN_GROSS_QTY;
				
				row3_HashRow.CLOSING_XCTN_GROSS_QTY = row3.CLOSING_XCTN_GROSS_QTY;
				
				row3_HashRow.OPENING_XCTN_NET_QTY = row3.OPENING_XCTN_NET_QTY;
				
				row3_HashRow.CLOSING_XCTN_NET_QTY = row3.CLOSING_XCTN_NET_QTY;
				
				row3_HashRow.OPENING_WEIGHT_IN_AIR = row3.OPENING_WEIGHT_IN_AIR;
				
				row3_HashRow.CLOSING_WEIGHT_IN_AIR = row3.CLOSING_WEIGHT_IN_AIR;
				
				row3_HashRow.OPENING_XCTN_WEIGHT = row3.OPENING_XCTN_WEIGHT;
				
				row3_HashRow.CLOSING_XCTN_WEIGHT = row3.CLOSING_XCTN_WEIGHT;
				
				row3_HashRow.OPENING_CALCULATION_POINT = row3.OPENING_CALCULATION_POINT;
				
				row3_HashRow.CLOSING_CALCULATION_POINT = row3.CLOSING_CALCULATION_POINT;
				
				row3_HashRow.OPENING_PRODUCT_STRAP_TYPE = row3.OPENING_PRODUCT_STRAP_TYPE;
				
				row3_HashRow.OPENING_API_CODE = row3.OPENING_API_CODE;
				
				row3_HashRow.CLOSING_PRODUCT_STRAP_TYPE = row3.CLOSING_PRODUCT_STRAP_TYPE;
				
				row3_HashRow.CLOSING_API_CODE = row3.CLOSING_API_CODE;
				
				row3_HashRow.OPENING_TEMPERATURE_ORIGIN = row3.OPENING_TEMPERATURE_ORIGIN;
				
				row3_HashRow.CLOSING_TEMPERATURE_ORIGIN = row3.CLOSING_TEMPERATURE_ORIGIN;
				
				row3_HashRow.INVENTORY_QUANTITY_TYPE = row3.INVENTORY_QUANTITY_TYPE;
				
				row3_HashRow.COMPARTMENT_VISIT_NUMBER = row3.COMPARTMENT_VISIT_NUMBER;
				
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
        final DIM_GAIN_LOSS_HISTORY DIM_GAIN_LOSS_HISTORYClass = new DIM_GAIN_LOSS_HISTORY();

        int exitCode = DIM_GAIN_LOSS_HISTORYClass.runJobInTOS(args);

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
            java.io.InputStream inContext = DIM_GAIN_LOSS_HISTORY.class.getClassLoader().getResourceAsStream("pgs_stage/dim_gain_loss_history_0_1/contexts/" + contextStr + ".properties");
            if (inContext == null) {
                inContext = DIM_GAIN_LOSS_HISTORY.class.getClassLoader().getResourceAsStream("config/contexts/" + contextStr + ".properties");
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
            System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : DIM_GAIN_LOSS_HISTORY");
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
 *     521203 characters generated by Talend Open Studio for Data Integration 
 *     on the 3 août 2024 à 14:42:24 GMT+01:00
 ************************************************************************************************/