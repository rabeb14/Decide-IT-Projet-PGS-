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


package pgs_stage.dim_tank_0_1;

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
 * Job: DIM_TANK Purpose: <br>
 * Description:  <br>
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status 
 */
public class DIM_TANK implements TalendJob {

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
	private final String jobName = "DIM_TANK";
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
				DIM_TANK.this.exception = e;
			}
		}
		if (!(e instanceof TalendException)) {
		try {
			for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
				if (m.getName().compareTo(currentComponent + "_error") == 0) {
					m.invoke(DIM_TANK.this, new Object[] { e , currentComponent, globalMap});
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
    final static byte[] commonByteArrayLock_PGS_STAGE_DIM_TANK = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_DIM_TANK = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public Integer PK_TANK;

				public Integer getPK_TANK () {
					return this.PK_TANK;
				}
				
			    public String TANK_CODE;

				public String getTANK_CODE () {
					return this.TANK_CODE;
				}
				
			    public String NAME;

				public String getNAME () {
					return this.NAME;
				}
				
			    public int RT_GROSS_QUANTITY;

				public int getRT_GROSS_QUANTITY () {
					return this.RT_GROSS_QUANTITY;
				}
				
			    public int TERMINAL_PRODUCT_NUMBER;

				public int getTERMINAL_PRODUCT_NUMBER () {
					return this.TERMINAL_PRODUCT_NUMBER;
				}
				
			    public int RT_NET_QUANTITY;

				public int getRT_NET_QUANTITY () {
					return this.RT_NET_QUANTITY;
				}
				
			    public double RT_TEMPERATURE;

				public double getRT_TEMPERATURE () {
					return this.RT_TEMPERATURE;
				}
				
			    public double RT_DENSITY;

				public double getRT_DENSITY () {
					return this.RT_DENSITY;
				}
				
			    public int SHELL_CAPACITY;

				public int getSHELL_CAPACITY () {
					return this.SHELL_CAPACITY;
				}
				
			    public int WORK_CAPACITY;

				public int getWORK_CAPACITY () {
					return this.WORK_CAPACITY;
				}
				
			    public String DEPTH;

				public String getDEPTH () {
					return this.DEPTH;
				}
				
			    public int AUTO_ENABLE;

				public int getAUTO_ENABLE () {
					return this.AUTO_ENABLE;
				}
				
			    public int AUTO_LEVEL_ENABLE;

				public int getAUTO_LEVEL_ENABLE () {
					return this.AUTO_LEVEL_ENABLE;
				}
				
			    public int AUTO_TEMPERATURE_ENABLE;

				public int getAUTO_TEMPERATURE_ENABLE () {
					return this.AUTO_TEMPERATURE_ENABLE;
				}
				
			    public String DDE_LEVEL_ITEM;

				public String getDDE_LEVEL_ITEM () {
					return this.DDE_LEVEL_ITEM;
				}
				
			    public String MANUAL_LEVEL;

				public String getMANUAL_LEVEL () {
					return this.MANUAL_LEVEL;
				}
				
			    public String RT_AUTO_LEVEL;

				public String getRT_AUTO_LEVEL () {
					return this.RT_AUTO_LEVEL;
				}
				
			    public double MANUAL_TEMPERATURE;

				public double getMANUAL_TEMPERATURE () {
					return this.MANUAL_TEMPERATURE;
				}
				
			    public double MANUAL_DENSITY;

				public double getMANUAL_DENSITY () {
					return this.MANUAL_DENSITY;
				}
				
			    public int PROTOCOL_TYPE;

				public int getPROTOCOL_TYPE () {
					return this.PROTOCOL_TYPE;
				}
				
			    public double RT_AUTO_TEMPERATURE;

				public double getRT_AUTO_TEMPERATURE () {
					return this.RT_AUTO_TEMPERATURE;
				}
				
			    public String PORT_NAME;

				public String getPORT_NAME () {
					return this.PORT_NAME;
				}
				
			    public String RT_LEVEL;

				public String getRT_LEVEL () {
					return this.RT_LEVEL;
				}
				
			    public int RT_EOD_OPENING_PHYSICAL;

				public int getRT_EOD_OPENING_PHYSICAL () {
					return this.RT_EOD_OPENING_PHYSICAL;
				}
				
			    public int RT_AVAILABLE_QUANTITY;

				public int getRT_AVAILABLE_QUANTITY () {
					return this.RT_AVAILABLE_QUANTITY;
				}
				
			    public String LAST_USER_NAME;

				public String getLAST_USER_NAME () {
					return this.LAST_USER_NAME;
				}
				
			    public java.util.Date LAST_MODIFIED;

				public java.util.Date getLAST_MODIFIED () {
					return this.LAST_MODIFIED;
				}
				
			    public int RT_EOD_BOOK_INVENTORY;

				public int getRT_EOD_BOOK_INVENTORY () {
					return this.RT_EOD_BOOK_INVENTORY;
				}
				
			    public String USER_DLL;

				public String getUSER_DLL () {
					return this.USER_DLL;
				}
				
			    public String USER_ROUTINE;

				public String getUSER_ROUTINE () {
					return this.USER_ROUTINE;
				}
				
			    public int MANUAL_GROSS_QUANTITY;

				public int getMANUAL_GROSS_QUANTITY () {
					return this.MANUAL_GROSS_QUANTITY;
				}
				
			    public double MANUAL_OBSERVED_DENSITY;

				public double getMANUAL_OBSERVED_DENSITY () {
					return this.MANUAL_OBSERVED_DENSITY;
				}
				
			    public double RT_OBSERVED_DENSITY;

				public double getRT_OBSERVED_DENSITY () {
					return this.RT_OBSERVED_DENSITY;
				}
				
			    public int AUTO_BSW_LEVEL_ENABLE;

				public int getAUTO_BSW_LEVEL_ENABLE () {
					return this.AUTO_BSW_LEVEL_ENABLE;
				}
				
			    public String DDE_BSW_LEVEL_ITEM;

				public String getDDE_BSW_LEVEL_ITEM () {
					return this.DDE_BSW_LEVEL_ITEM;
				}
				
			    public double RT_EOD_OPEN_DENSITY;

				public double getRT_EOD_OPEN_DENSITY () {
					return this.RT_EOD_OPEN_DENSITY;
				}
				
			    public double RT_EOD_OPEN_TEMPERATURE;

				public double getRT_EOD_OPEN_TEMPERATURE () {
					return this.RT_EOD_OPEN_TEMPERATURE;
				}
				
			    public String RT_EOD_OPEN_LEVEL;

				public String getRT_EOD_OPEN_LEVEL () {
					return this.RT_EOD_OPEN_LEVEL;
				}
				
			    public double RT_EOD_OPEN_OBSERVED_DENSITY;

				public double getRT_EOD_OPEN_OBSERVED_DENSITY () {
					return this.RT_EOD_OPEN_OBSERVED_DENSITY;
				}
				
			    public int RT_EOD_OPEN_PHYS_GROSS_QTY;

				public int getRT_EOD_OPEN_PHYS_GROSS_QTY () {
					return this.RT_EOD_OPEN_PHYS_GROSS_QTY;
				}
				
			    public int RT_GOV;

				public int getRT_GOV () {
					return this.RT_GOV;
				}
				
			    public int RT_GSV;

				public int getRT_GSV () {
					return this.RT_GSV;
				}
				
			    public int RT_TCV;

				public int getRT_TCV () {
					return this.RT_TCV;
				}
				
			    public double RT_CTL;

				public double getRT_CTL () {
					return this.RT_CTL;
				}
				
			    public int MANUAL_STRAP_TYPE;

				public int getMANUAL_STRAP_TYPE () {
					return this.MANUAL_STRAP_TYPE;
				}
				
			    public int RT_CALCULATION_POINT;

				public int getRT_CALCULATION_POINT () {
					return this.RT_CALCULATION_POINT;
				}
				
			    public int RT_NSV;

				public int getRT_NSV () {
					return this.RT_NSV;
				}
				
			    public int RT_GSW;

				public int getRT_GSW () {
					return this.RT_GSW;
				}
				
			    public int RT_NSW;

				public int getRT_NSW () {
					return this.RT_NSW;
				}
				
			    public double RT_WCF;

				public double getRT_WCF () {
					return this.RT_WCF;
				}
				
			    public int WEIGHT_IN_AIR;

				public int getWEIGHT_IN_AIR () {
					return this.WEIGHT_IN_AIR;
				}
				
			    public int SHAPE;

				public int getSHAPE () {
					return this.SHAPE;
				}
				
			    public int RT_LEVEL_ORIGIN;

				public int getRT_LEVEL_ORIGIN () {
					return this.RT_LEVEL_ORIGIN;
				}
				
			    public int RT_TOV_ORIGIN;

				public int getRT_TOV_ORIGIN () {
					return this.RT_TOV_ORIGIN;
				}
				
			    public int RT_TEMPERATURE_ORIGIN;

				public int getRT_TEMPERATURE_ORIGIN () {
					return this.RT_TEMPERATURE_ORIGIN;
				}
				
			    public int RT_FREE_WATER_LEVEL_ORIGIN;

				public int getRT_FREE_WATER_LEVEL_ORIGIN () {
					return this.RT_FREE_WATER_LEVEL_ORIGIN;
				}
				
			    public int RT_WATER_QUANTITY_ORIGIN;

				public int getRT_WATER_QUANTITY_ORIGIN () {
					return this.RT_WATER_QUANTITY_ORIGIN;
				}
				
			    public int RT_TOV;

				public int getRT_TOV () {
					return this.RT_TOV;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.PK_TANK == null) ? 0 : this.PK_TANK.hashCode());
					
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
		
						if (this.PK_TANK == null) {
							if (other.PK_TANK != null)
								return false;
						
						} else if (!this.PK_TANK.equals(other.PK_TANK))
						
							return false;
					

		return true;
    }

	public void copyDataTo(out1Struct other) {

		other.PK_TANK = this.PK_TANK;
	            other.TANK_CODE = this.TANK_CODE;
	            other.NAME = this.NAME;
	            other.RT_GROSS_QUANTITY = this.RT_GROSS_QUANTITY;
	            other.TERMINAL_PRODUCT_NUMBER = this.TERMINAL_PRODUCT_NUMBER;
	            other.RT_NET_QUANTITY = this.RT_NET_QUANTITY;
	            other.RT_TEMPERATURE = this.RT_TEMPERATURE;
	            other.RT_DENSITY = this.RT_DENSITY;
	            other.SHELL_CAPACITY = this.SHELL_CAPACITY;
	            other.WORK_CAPACITY = this.WORK_CAPACITY;
	            other.DEPTH = this.DEPTH;
	            other.AUTO_ENABLE = this.AUTO_ENABLE;
	            other.AUTO_LEVEL_ENABLE = this.AUTO_LEVEL_ENABLE;
	            other.AUTO_TEMPERATURE_ENABLE = this.AUTO_TEMPERATURE_ENABLE;
	            other.DDE_LEVEL_ITEM = this.DDE_LEVEL_ITEM;
	            other.MANUAL_LEVEL = this.MANUAL_LEVEL;
	            other.RT_AUTO_LEVEL = this.RT_AUTO_LEVEL;
	            other.MANUAL_TEMPERATURE = this.MANUAL_TEMPERATURE;
	            other.MANUAL_DENSITY = this.MANUAL_DENSITY;
	            other.PROTOCOL_TYPE = this.PROTOCOL_TYPE;
	            other.RT_AUTO_TEMPERATURE = this.RT_AUTO_TEMPERATURE;
	            other.PORT_NAME = this.PORT_NAME;
	            other.RT_LEVEL = this.RT_LEVEL;
	            other.RT_EOD_OPENING_PHYSICAL = this.RT_EOD_OPENING_PHYSICAL;
	            other.RT_AVAILABLE_QUANTITY = this.RT_AVAILABLE_QUANTITY;
	            other.LAST_USER_NAME = this.LAST_USER_NAME;
	            other.LAST_MODIFIED = this.LAST_MODIFIED;
	            other.RT_EOD_BOOK_INVENTORY = this.RT_EOD_BOOK_INVENTORY;
	            other.USER_DLL = this.USER_DLL;
	            other.USER_ROUTINE = this.USER_ROUTINE;
	            other.MANUAL_GROSS_QUANTITY = this.MANUAL_GROSS_QUANTITY;
	            other.MANUAL_OBSERVED_DENSITY = this.MANUAL_OBSERVED_DENSITY;
	            other.RT_OBSERVED_DENSITY = this.RT_OBSERVED_DENSITY;
	            other.AUTO_BSW_LEVEL_ENABLE = this.AUTO_BSW_LEVEL_ENABLE;
	            other.DDE_BSW_LEVEL_ITEM = this.DDE_BSW_LEVEL_ITEM;
	            other.RT_EOD_OPEN_DENSITY = this.RT_EOD_OPEN_DENSITY;
	            other.RT_EOD_OPEN_TEMPERATURE = this.RT_EOD_OPEN_TEMPERATURE;
	            other.RT_EOD_OPEN_LEVEL = this.RT_EOD_OPEN_LEVEL;
	            other.RT_EOD_OPEN_OBSERVED_DENSITY = this.RT_EOD_OPEN_OBSERVED_DENSITY;
	            other.RT_EOD_OPEN_PHYS_GROSS_QTY = this.RT_EOD_OPEN_PHYS_GROSS_QTY;
	            other.RT_GOV = this.RT_GOV;
	            other.RT_GSV = this.RT_GSV;
	            other.RT_TCV = this.RT_TCV;
	            other.RT_CTL = this.RT_CTL;
	            other.MANUAL_STRAP_TYPE = this.MANUAL_STRAP_TYPE;
	            other.RT_CALCULATION_POINT = this.RT_CALCULATION_POINT;
	            other.RT_NSV = this.RT_NSV;
	            other.RT_GSW = this.RT_GSW;
	            other.RT_NSW = this.RT_NSW;
	            other.RT_WCF = this.RT_WCF;
	            other.WEIGHT_IN_AIR = this.WEIGHT_IN_AIR;
	            other.SHAPE = this.SHAPE;
	            other.RT_LEVEL_ORIGIN = this.RT_LEVEL_ORIGIN;
	            other.RT_TOV_ORIGIN = this.RT_TOV_ORIGIN;
	            other.RT_TEMPERATURE_ORIGIN = this.RT_TEMPERATURE_ORIGIN;
	            other.RT_FREE_WATER_LEVEL_ORIGIN = this.RT_FREE_WATER_LEVEL_ORIGIN;
	            other.RT_WATER_QUANTITY_ORIGIN = this.RT_WATER_QUANTITY_ORIGIN;
	            other.RT_TOV = this.RT_TOV;
	            
	}

	public void copyKeysDataTo(out1Struct other) {

		other.PK_TANK = this.PK_TANK;
	            	
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
			if(length > commonByteArray_PGS_STAGE_DIM_TANK.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_TANK.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_TANK = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_TANK = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PGS_STAGE_DIM_TANK, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_TANK, 0, length, utf8Charset);
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
			if(length > commonByteArray_PGS_STAGE_DIM_TANK.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_TANK.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_TANK = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_TANK = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PGS_STAGE_DIM_TANK, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_TANK, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_TANK) {

        	try {

        		int length = 0;
		
						this.PK_TANK = readInteger(dis);
					
					this.TANK_CODE = readString(dis);
					
					this.NAME = readString(dis);
					
			        this.RT_GROSS_QUANTITY = dis.readInt();
					
			        this.TERMINAL_PRODUCT_NUMBER = dis.readInt();
					
			        this.RT_NET_QUANTITY = dis.readInt();
					
			        this.RT_TEMPERATURE = dis.readDouble();
					
			        this.RT_DENSITY = dis.readDouble();
					
			        this.SHELL_CAPACITY = dis.readInt();
					
			        this.WORK_CAPACITY = dis.readInt();
					
					this.DEPTH = readString(dis);
					
			        this.AUTO_ENABLE = dis.readInt();
					
			        this.AUTO_LEVEL_ENABLE = dis.readInt();
					
			        this.AUTO_TEMPERATURE_ENABLE = dis.readInt();
					
					this.DDE_LEVEL_ITEM = readString(dis);
					
					this.MANUAL_LEVEL = readString(dis);
					
					this.RT_AUTO_LEVEL = readString(dis);
					
			        this.MANUAL_TEMPERATURE = dis.readDouble();
					
			        this.MANUAL_DENSITY = dis.readDouble();
					
			        this.PROTOCOL_TYPE = dis.readInt();
					
			        this.RT_AUTO_TEMPERATURE = dis.readDouble();
					
					this.PORT_NAME = readString(dis);
					
					this.RT_LEVEL = readString(dis);
					
			        this.RT_EOD_OPENING_PHYSICAL = dis.readInt();
					
			        this.RT_AVAILABLE_QUANTITY = dis.readInt();
					
					this.LAST_USER_NAME = readString(dis);
					
					this.LAST_MODIFIED = readDate(dis);
					
			        this.RT_EOD_BOOK_INVENTORY = dis.readInt();
					
					this.USER_DLL = readString(dis);
					
					this.USER_ROUTINE = readString(dis);
					
			        this.MANUAL_GROSS_QUANTITY = dis.readInt();
					
			        this.MANUAL_OBSERVED_DENSITY = dis.readDouble();
					
			        this.RT_OBSERVED_DENSITY = dis.readDouble();
					
			        this.AUTO_BSW_LEVEL_ENABLE = dis.readInt();
					
					this.DDE_BSW_LEVEL_ITEM = readString(dis);
					
			        this.RT_EOD_OPEN_DENSITY = dis.readDouble();
					
			        this.RT_EOD_OPEN_TEMPERATURE = dis.readDouble();
					
					this.RT_EOD_OPEN_LEVEL = readString(dis);
					
			        this.RT_EOD_OPEN_OBSERVED_DENSITY = dis.readDouble();
					
			        this.RT_EOD_OPEN_PHYS_GROSS_QTY = dis.readInt();
					
			        this.RT_GOV = dis.readInt();
					
			        this.RT_GSV = dis.readInt();
					
			        this.RT_TCV = dis.readInt();
					
			        this.RT_CTL = dis.readDouble();
					
			        this.MANUAL_STRAP_TYPE = dis.readInt();
					
			        this.RT_CALCULATION_POINT = dis.readInt();
					
			        this.RT_NSV = dis.readInt();
					
			        this.RT_GSW = dis.readInt();
					
			        this.RT_NSW = dis.readInt();
					
			        this.RT_WCF = dis.readDouble();
					
			        this.WEIGHT_IN_AIR = dis.readInt();
					
			        this.SHAPE = dis.readInt();
					
			        this.RT_LEVEL_ORIGIN = dis.readInt();
					
			        this.RT_TOV_ORIGIN = dis.readInt();
					
			        this.RT_TEMPERATURE_ORIGIN = dis.readInt();
					
			        this.RT_FREE_WATER_LEVEL_ORIGIN = dis.readInt();
					
			        this.RT_WATER_QUANTITY_ORIGIN = dis.readInt();
					
			        this.RT_TOV = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_TANK) {

        	try {

        		int length = 0;
		
						this.PK_TANK = readInteger(dis);
					
					this.TANK_CODE = readString(dis);
					
					this.NAME = readString(dis);
					
			        this.RT_GROSS_QUANTITY = dis.readInt();
					
			        this.TERMINAL_PRODUCT_NUMBER = dis.readInt();
					
			        this.RT_NET_QUANTITY = dis.readInt();
					
			        this.RT_TEMPERATURE = dis.readDouble();
					
			        this.RT_DENSITY = dis.readDouble();
					
			        this.SHELL_CAPACITY = dis.readInt();
					
			        this.WORK_CAPACITY = dis.readInt();
					
					this.DEPTH = readString(dis);
					
			        this.AUTO_ENABLE = dis.readInt();
					
			        this.AUTO_LEVEL_ENABLE = dis.readInt();
					
			        this.AUTO_TEMPERATURE_ENABLE = dis.readInt();
					
					this.DDE_LEVEL_ITEM = readString(dis);
					
					this.MANUAL_LEVEL = readString(dis);
					
					this.RT_AUTO_LEVEL = readString(dis);
					
			        this.MANUAL_TEMPERATURE = dis.readDouble();
					
			        this.MANUAL_DENSITY = dis.readDouble();
					
			        this.PROTOCOL_TYPE = dis.readInt();
					
			        this.RT_AUTO_TEMPERATURE = dis.readDouble();
					
					this.PORT_NAME = readString(dis);
					
					this.RT_LEVEL = readString(dis);
					
			        this.RT_EOD_OPENING_PHYSICAL = dis.readInt();
					
			        this.RT_AVAILABLE_QUANTITY = dis.readInt();
					
					this.LAST_USER_NAME = readString(dis);
					
					this.LAST_MODIFIED = readDate(dis);
					
			        this.RT_EOD_BOOK_INVENTORY = dis.readInt();
					
					this.USER_DLL = readString(dis);
					
					this.USER_ROUTINE = readString(dis);
					
			        this.MANUAL_GROSS_QUANTITY = dis.readInt();
					
			        this.MANUAL_OBSERVED_DENSITY = dis.readDouble();
					
			        this.RT_OBSERVED_DENSITY = dis.readDouble();
					
			        this.AUTO_BSW_LEVEL_ENABLE = dis.readInt();
					
					this.DDE_BSW_LEVEL_ITEM = readString(dis);
					
			        this.RT_EOD_OPEN_DENSITY = dis.readDouble();
					
			        this.RT_EOD_OPEN_TEMPERATURE = dis.readDouble();
					
					this.RT_EOD_OPEN_LEVEL = readString(dis);
					
			        this.RT_EOD_OPEN_OBSERVED_DENSITY = dis.readDouble();
					
			        this.RT_EOD_OPEN_PHYS_GROSS_QTY = dis.readInt();
					
			        this.RT_GOV = dis.readInt();
					
			        this.RT_GSV = dis.readInt();
					
			        this.RT_TCV = dis.readInt();
					
			        this.RT_CTL = dis.readDouble();
					
			        this.MANUAL_STRAP_TYPE = dis.readInt();
					
			        this.RT_CALCULATION_POINT = dis.readInt();
					
			        this.RT_NSV = dis.readInt();
					
			        this.RT_GSW = dis.readInt();
					
			        this.RT_NSW = dis.readInt();
					
			        this.RT_WCF = dis.readDouble();
					
			        this.WEIGHT_IN_AIR = dis.readInt();
					
			        this.SHAPE = dis.readInt();
					
			        this.RT_LEVEL_ORIGIN = dis.readInt();
					
			        this.RT_TOV_ORIGIN = dis.readInt();
					
			        this.RT_TEMPERATURE_ORIGIN = dis.readInt();
					
			        this.RT_FREE_WATER_LEVEL_ORIGIN = dis.readInt();
					
			        this.RT_WATER_QUANTITY_ORIGIN = dis.readInt();
					
			        this.RT_TOV = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// Integer
				
						writeInteger(this.PK_TANK,dos);
					
					// String
				
						writeString(this.TANK_CODE,dos);
					
					// String
				
						writeString(this.NAME,dos);
					
					// int
				
		            	dos.writeInt(this.RT_GROSS_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.TERMINAL_PRODUCT_NUMBER);
					
					// int
				
		            	dos.writeInt(this.RT_NET_QUANTITY);
					
					// double
				
		            	dos.writeDouble(this.RT_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.RT_DENSITY);
					
					// int
				
		            	dos.writeInt(this.SHELL_CAPACITY);
					
					// int
				
		            	dos.writeInt(this.WORK_CAPACITY);
					
					// String
				
						writeString(this.DEPTH,dos);
					
					// int
				
		            	dos.writeInt(this.AUTO_ENABLE);
					
					// int
				
		            	dos.writeInt(this.AUTO_LEVEL_ENABLE);
					
					// int
				
		            	dos.writeInt(this.AUTO_TEMPERATURE_ENABLE);
					
					// String
				
						writeString(this.DDE_LEVEL_ITEM,dos);
					
					// String
				
						writeString(this.MANUAL_LEVEL,dos);
					
					// String
				
						writeString(this.RT_AUTO_LEVEL,dos);
					
					// double
				
		            	dos.writeDouble(this.MANUAL_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.MANUAL_DENSITY);
					
					// int
				
		            	dos.writeInt(this.PROTOCOL_TYPE);
					
					// double
				
		            	dos.writeDouble(this.RT_AUTO_TEMPERATURE);
					
					// String
				
						writeString(this.PORT_NAME,dos);
					
					// String
				
						writeString(this.RT_LEVEL,dos);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_OPENING_PHYSICAL);
					
					// int
				
		            	dos.writeInt(this.RT_AVAILABLE_QUANTITY);
					
					// String
				
						writeString(this.LAST_USER_NAME,dos);
					
					// java.util.Date
				
						writeDate(this.LAST_MODIFIED,dos);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_BOOK_INVENTORY);
					
					// String
				
						writeString(this.USER_DLL,dos);
					
					// String
				
						writeString(this.USER_ROUTINE,dos);
					
					// int
				
		            	dos.writeInt(this.MANUAL_GROSS_QUANTITY);
					
					// double
				
		            	dos.writeDouble(this.MANUAL_OBSERVED_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.RT_OBSERVED_DENSITY);
					
					// int
				
		            	dos.writeInt(this.AUTO_BSW_LEVEL_ENABLE);
					
					// String
				
						writeString(this.DDE_BSW_LEVEL_ITEM,dos);
					
					// double
				
		            	dos.writeDouble(this.RT_EOD_OPEN_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.RT_EOD_OPEN_TEMPERATURE);
					
					// String
				
						writeString(this.RT_EOD_OPEN_LEVEL,dos);
					
					// double
				
		            	dos.writeDouble(this.RT_EOD_OPEN_OBSERVED_DENSITY);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_OPEN_PHYS_GROSS_QTY);
					
					// int
				
		            	dos.writeInt(this.RT_GOV);
					
					// int
				
		            	dos.writeInt(this.RT_GSV);
					
					// int
				
		            	dos.writeInt(this.RT_TCV);
					
					// double
				
		            	dos.writeDouble(this.RT_CTL);
					
					// int
				
		            	dos.writeInt(this.MANUAL_STRAP_TYPE);
					
					// int
				
		            	dos.writeInt(this.RT_CALCULATION_POINT);
					
					// int
				
		            	dos.writeInt(this.RT_NSV);
					
					// int
				
		            	dos.writeInt(this.RT_GSW);
					
					// int
				
		            	dos.writeInt(this.RT_NSW);
					
					// double
				
		            	dos.writeDouble(this.RT_WCF);
					
					// int
				
		            	dos.writeInt(this.WEIGHT_IN_AIR);
					
					// int
				
		            	dos.writeInt(this.SHAPE);
					
					// int
				
		            	dos.writeInt(this.RT_LEVEL_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.RT_TOV_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.RT_TEMPERATURE_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.RT_FREE_WATER_LEVEL_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.RT_WATER_QUANTITY_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.RT_TOV);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Integer
				
						writeInteger(this.PK_TANK,dos);
					
					// String
				
						writeString(this.TANK_CODE,dos);
					
					// String
				
						writeString(this.NAME,dos);
					
					// int
				
		            	dos.writeInt(this.RT_GROSS_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.TERMINAL_PRODUCT_NUMBER);
					
					// int
				
		            	dos.writeInt(this.RT_NET_QUANTITY);
					
					// double
				
		            	dos.writeDouble(this.RT_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.RT_DENSITY);
					
					// int
				
		            	dos.writeInt(this.SHELL_CAPACITY);
					
					// int
				
		            	dos.writeInt(this.WORK_CAPACITY);
					
					// String
				
						writeString(this.DEPTH,dos);
					
					// int
				
		            	dos.writeInt(this.AUTO_ENABLE);
					
					// int
				
		            	dos.writeInt(this.AUTO_LEVEL_ENABLE);
					
					// int
				
		            	dos.writeInt(this.AUTO_TEMPERATURE_ENABLE);
					
					// String
				
						writeString(this.DDE_LEVEL_ITEM,dos);
					
					// String
				
						writeString(this.MANUAL_LEVEL,dos);
					
					// String
				
						writeString(this.RT_AUTO_LEVEL,dos);
					
					// double
				
		            	dos.writeDouble(this.MANUAL_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.MANUAL_DENSITY);
					
					// int
				
		            	dos.writeInt(this.PROTOCOL_TYPE);
					
					// double
				
		            	dos.writeDouble(this.RT_AUTO_TEMPERATURE);
					
					// String
				
						writeString(this.PORT_NAME,dos);
					
					// String
				
						writeString(this.RT_LEVEL,dos);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_OPENING_PHYSICAL);
					
					// int
				
		            	dos.writeInt(this.RT_AVAILABLE_QUANTITY);
					
					// String
				
						writeString(this.LAST_USER_NAME,dos);
					
					// java.util.Date
				
						writeDate(this.LAST_MODIFIED,dos);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_BOOK_INVENTORY);
					
					// String
				
						writeString(this.USER_DLL,dos);
					
					// String
				
						writeString(this.USER_ROUTINE,dos);
					
					// int
				
		            	dos.writeInt(this.MANUAL_GROSS_QUANTITY);
					
					// double
				
		            	dos.writeDouble(this.MANUAL_OBSERVED_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.RT_OBSERVED_DENSITY);
					
					// int
				
		            	dos.writeInt(this.AUTO_BSW_LEVEL_ENABLE);
					
					// String
				
						writeString(this.DDE_BSW_LEVEL_ITEM,dos);
					
					// double
				
		            	dos.writeDouble(this.RT_EOD_OPEN_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.RT_EOD_OPEN_TEMPERATURE);
					
					// String
				
						writeString(this.RT_EOD_OPEN_LEVEL,dos);
					
					// double
				
		            	dos.writeDouble(this.RT_EOD_OPEN_OBSERVED_DENSITY);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_OPEN_PHYS_GROSS_QTY);
					
					// int
				
		            	dos.writeInt(this.RT_GOV);
					
					// int
				
		            	dos.writeInt(this.RT_GSV);
					
					// int
				
		            	dos.writeInt(this.RT_TCV);
					
					// double
				
		            	dos.writeDouble(this.RT_CTL);
					
					// int
				
		            	dos.writeInt(this.MANUAL_STRAP_TYPE);
					
					// int
				
		            	dos.writeInt(this.RT_CALCULATION_POINT);
					
					// int
				
		            	dos.writeInt(this.RT_NSV);
					
					// int
				
		            	dos.writeInt(this.RT_GSW);
					
					// int
				
		            	dos.writeInt(this.RT_NSW);
					
					// double
				
		            	dos.writeDouble(this.RT_WCF);
					
					// int
				
		            	dos.writeInt(this.WEIGHT_IN_AIR);
					
					// int
				
		            	dos.writeInt(this.SHAPE);
					
					// int
				
		            	dos.writeInt(this.RT_LEVEL_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.RT_TOV_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.RT_TEMPERATURE_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.RT_FREE_WATER_LEVEL_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.RT_WATER_QUANTITY_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.RT_TOV);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("PK_TANK="+String.valueOf(PK_TANK));
		sb.append(",TANK_CODE="+TANK_CODE);
		sb.append(",NAME="+NAME);
		sb.append(",RT_GROSS_QUANTITY="+String.valueOf(RT_GROSS_QUANTITY));
		sb.append(",TERMINAL_PRODUCT_NUMBER="+String.valueOf(TERMINAL_PRODUCT_NUMBER));
		sb.append(",RT_NET_QUANTITY="+String.valueOf(RT_NET_QUANTITY));
		sb.append(",RT_TEMPERATURE="+String.valueOf(RT_TEMPERATURE));
		sb.append(",RT_DENSITY="+String.valueOf(RT_DENSITY));
		sb.append(",SHELL_CAPACITY="+String.valueOf(SHELL_CAPACITY));
		sb.append(",WORK_CAPACITY="+String.valueOf(WORK_CAPACITY));
		sb.append(",DEPTH="+DEPTH);
		sb.append(",AUTO_ENABLE="+String.valueOf(AUTO_ENABLE));
		sb.append(",AUTO_LEVEL_ENABLE="+String.valueOf(AUTO_LEVEL_ENABLE));
		sb.append(",AUTO_TEMPERATURE_ENABLE="+String.valueOf(AUTO_TEMPERATURE_ENABLE));
		sb.append(",DDE_LEVEL_ITEM="+DDE_LEVEL_ITEM);
		sb.append(",MANUAL_LEVEL="+MANUAL_LEVEL);
		sb.append(",RT_AUTO_LEVEL="+RT_AUTO_LEVEL);
		sb.append(",MANUAL_TEMPERATURE="+String.valueOf(MANUAL_TEMPERATURE));
		sb.append(",MANUAL_DENSITY="+String.valueOf(MANUAL_DENSITY));
		sb.append(",PROTOCOL_TYPE="+String.valueOf(PROTOCOL_TYPE));
		sb.append(",RT_AUTO_TEMPERATURE="+String.valueOf(RT_AUTO_TEMPERATURE));
		sb.append(",PORT_NAME="+PORT_NAME);
		sb.append(",RT_LEVEL="+RT_LEVEL);
		sb.append(",RT_EOD_OPENING_PHYSICAL="+String.valueOf(RT_EOD_OPENING_PHYSICAL));
		sb.append(",RT_AVAILABLE_QUANTITY="+String.valueOf(RT_AVAILABLE_QUANTITY));
		sb.append(",LAST_USER_NAME="+LAST_USER_NAME);
		sb.append(",LAST_MODIFIED="+String.valueOf(LAST_MODIFIED));
		sb.append(",RT_EOD_BOOK_INVENTORY="+String.valueOf(RT_EOD_BOOK_INVENTORY));
		sb.append(",USER_DLL="+USER_DLL);
		sb.append(",USER_ROUTINE="+USER_ROUTINE);
		sb.append(",MANUAL_GROSS_QUANTITY="+String.valueOf(MANUAL_GROSS_QUANTITY));
		sb.append(",MANUAL_OBSERVED_DENSITY="+String.valueOf(MANUAL_OBSERVED_DENSITY));
		sb.append(",RT_OBSERVED_DENSITY="+String.valueOf(RT_OBSERVED_DENSITY));
		sb.append(",AUTO_BSW_LEVEL_ENABLE="+String.valueOf(AUTO_BSW_LEVEL_ENABLE));
		sb.append(",DDE_BSW_LEVEL_ITEM="+DDE_BSW_LEVEL_ITEM);
		sb.append(",RT_EOD_OPEN_DENSITY="+String.valueOf(RT_EOD_OPEN_DENSITY));
		sb.append(",RT_EOD_OPEN_TEMPERATURE="+String.valueOf(RT_EOD_OPEN_TEMPERATURE));
		sb.append(",RT_EOD_OPEN_LEVEL="+RT_EOD_OPEN_LEVEL);
		sb.append(",RT_EOD_OPEN_OBSERVED_DENSITY="+String.valueOf(RT_EOD_OPEN_OBSERVED_DENSITY));
		sb.append(",RT_EOD_OPEN_PHYS_GROSS_QTY="+String.valueOf(RT_EOD_OPEN_PHYS_GROSS_QTY));
		sb.append(",RT_GOV="+String.valueOf(RT_GOV));
		sb.append(",RT_GSV="+String.valueOf(RT_GSV));
		sb.append(",RT_TCV="+String.valueOf(RT_TCV));
		sb.append(",RT_CTL="+String.valueOf(RT_CTL));
		sb.append(",MANUAL_STRAP_TYPE="+String.valueOf(MANUAL_STRAP_TYPE));
		sb.append(",RT_CALCULATION_POINT="+String.valueOf(RT_CALCULATION_POINT));
		sb.append(",RT_NSV="+String.valueOf(RT_NSV));
		sb.append(",RT_GSW="+String.valueOf(RT_GSW));
		sb.append(",RT_NSW="+String.valueOf(RT_NSW));
		sb.append(",RT_WCF="+String.valueOf(RT_WCF));
		sb.append(",WEIGHT_IN_AIR="+String.valueOf(WEIGHT_IN_AIR));
		sb.append(",SHAPE="+String.valueOf(SHAPE));
		sb.append(",RT_LEVEL_ORIGIN="+String.valueOf(RT_LEVEL_ORIGIN));
		sb.append(",RT_TOV_ORIGIN="+String.valueOf(RT_TOV_ORIGIN));
		sb.append(",RT_TEMPERATURE_ORIGIN="+String.valueOf(RT_TEMPERATURE_ORIGIN));
		sb.append(",RT_FREE_WATER_LEVEL_ORIGIN="+String.valueOf(RT_FREE_WATER_LEVEL_ORIGIN));
		sb.append(",RT_WATER_QUANTITY_ORIGIN="+String.valueOf(RT_WATER_QUANTITY_ORIGIN));
		sb.append(",RT_TOV="+String.valueOf(RT_TOV));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(out1Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.PK_TANK, other.PK_TANK);
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
    final static byte[] commonByteArrayLock_PGS_STAGE_DIM_TANK = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_DIM_TANK = new byte[0];

	
			    public String TANK_CODE;

				public String getTANK_CODE () {
					return this.TANK_CODE;
				}
				
			    public String NAME;

				public String getNAME () {
					return this.NAME;
				}
				
			    public Integer COMPARTMENT_OWNER_ID;

				public Integer getCOMPARTMENT_OWNER_ID () {
					return this.COMPARTMENT_OWNER_ID;
				}
				
			    public Integer MAJORITY_SHAREHOLDER;

				public Integer getMAJORITY_SHAREHOLDER () {
					return this.MAJORITY_SHAREHOLDER;
				}
				
			    public String COMPARTMENT_CONTAINER_CODE;

				public String getCOMPARTMENT_CONTAINER_CODE () {
					return this.COMPARTMENT_CONTAINER_CODE;
				}
				
			    public int RT_GROSS_QUANTITY;

				public int getRT_GROSS_QUANTITY () {
					return this.RT_GROSS_QUANTITY;
				}
				
			    public Integer COMPARTMENT_CONTAINER_TYPE;

				public Integer getCOMPARTMENT_CONTAINER_TYPE () {
					return this.COMPARTMENT_CONTAINER_TYPE;
				}
				
			    public int TERMINAL_PRODUCT_NUMBER;

				public int getTERMINAL_PRODUCT_NUMBER () {
					return this.TERMINAL_PRODUCT_NUMBER;
				}
				
			    public Integer COMPARTMENT_NUMBER;

				public Integer getCOMPARTMENT_NUMBER () {
					return this.COMPARTMENT_NUMBER;
				}
				
			    public int RT_NET_QUANTITY;

				public int getRT_NET_QUANTITY () {
					return this.RT_NET_QUANTITY;
				}
				
			    public int ENABLE;

				public int getENABLE () {
					return this.ENABLE;
				}
				
			    public Integer SCHED_PROD_CHANGE_PRODUCT;

				public Integer getSCHED_PROD_CHANGE_PRODUCT () {
					return this.SCHED_PROD_CHANGE_PRODUCT;
				}
				
			    public double RVP;

				public double getRVP () {
					return this.RVP;
				}
				
			    public double OXYGEN;

				public double getOXYGEN () {
					return this.OXYGEN;
				}
				
			    public double RT_TEMPERATURE;

				public double getRT_TEMPERATURE () {
					return this.RT_TEMPERATURE;
				}
				
			    public double RT_DENSITY;

				public double getRT_DENSITY () {
					return this.RT_DENSITY;
				}
				
			    public int SHELL_CAPACITY;

				public int getSHELL_CAPACITY () {
					return this.SHELL_CAPACITY;
				}
				
			    public int WORK_CAPACITY;

				public int getWORK_CAPACITY () {
					return this.WORK_CAPACITY;
				}
				
			    public String DEPTH;

				public String getDEPTH () {
					return this.DEPTH;
				}
				
			    public String LOW_LOW_SETPOINT;

				public String getLOW_LOW_SETPOINT () {
					return this.LOW_LOW_SETPOINT;
				}
				
			    public String LOW_SETPOINT;

				public String getLOW_SETPOINT () {
					return this.LOW_SETPOINT;
				}
				
			    public String GENERAL_SETPOINT;

				public String getGENERAL_SETPOINT () {
					return this.GENERAL_SETPOINT;
				}
				
			    public String CUTOFF_SETPOINT;

				public String getCUTOFF_SETPOINT () {
					return this.CUTOFF_SETPOINT;
				}
				
			    public int AUTO_ENABLE;

				public int getAUTO_ENABLE () {
					return this.AUTO_ENABLE;
				}
				
			    public String HIGH_SETPOINT;

				public String getHIGH_SETPOINT () {
					return this.HIGH_SETPOINT;
				}
				
			    public String HIGH_HIGH_SETPOINT;

				public String getHIGH_HIGH_SETPOINT () {
					return this.HIGH_HIGH_SETPOINT;
				}
				
			    public int DEADBAND;

				public int getDEADBAND () {
					return this.DEADBAND;
				}
				
			    public int AUTO_LEVEL_ENABLE;

				public int getAUTO_LEVEL_ENABLE () {
					return this.AUTO_LEVEL_ENABLE;
				}
				
			    public String DDE_LEVEL_DSN;

				public String getDDE_LEVEL_DSN () {
					return this.DDE_LEVEL_DSN;
				}
				
			    public int AUTO_DENSITY_ENABLE;

				public int getAUTO_DENSITY_ENABLE () {
					return this.AUTO_DENSITY_ENABLE;
				}
				
			    public int AUTO_TEMPERATURE_ENABLE;

				public int getAUTO_TEMPERATURE_ENABLE () {
					return this.AUTO_TEMPERATURE_ENABLE;
				}
				
			    public String DDE_LEVEL_ITEM;

				public String getDDE_LEVEL_ITEM () {
					return this.DDE_LEVEL_ITEM;
				}
				
			    public int AUTO_QUANTITY_ENABLE;

				public int getAUTO_QUANTITY_ENABLE () {
					return this.AUTO_QUANTITY_ENABLE;
				}
				
			    public String DDE_DENSITY_DSN;

				public String getDDE_DENSITY_DSN () {
					return this.DDE_DENSITY_DSN;
				}
				
			    public int ACTIVITY_STATUS;

				public int getACTIVITY_STATUS () {
					return this.ACTIVITY_STATUS;
				}
				
			    public String DDE_DENSITY_ITEM;

				public String getDDE_DENSITY_ITEM () {
					return this.DDE_DENSITY_ITEM;
				}
				
			    public String DDE_TEMPERATURE_DSN;

				public String getDDE_TEMPERATURE_DSN () {
					return this.DDE_TEMPERATURE_DSN;
				}
				
			    public int RECEIPT_INDICATOR;

				public int getRECEIPT_INDICATOR () {
					return this.RECEIPT_INDICATOR;
				}
				
			    public String DDE_TEMPERATURE_ITEM;

				public String getDDE_TEMPERATURE_ITEM () {
					return this.DDE_TEMPERATURE_ITEM;
				}
				
			    public java.util.Date LAST_RECEIPT_DATE;

				public java.util.Date getLAST_RECEIPT_DATE () {
					return this.LAST_RECEIPT_DATE;
				}
				
			    public String DDE_QUANTITY_DSN;

				public String getDDE_QUANTITY_DSN () {
					return this.DDE_QUANTITY_DSN;
				}
				
			    public String DDE_QUANTITY_ITEM;

				public String getDDE_QUANTITY_ITEM () {
					return this.DDE_QUANTITY_ITEM;
				}
				
			    public int SEND_TO_HOST_AT_EOD;

				public int getSEND_TO_HOST_AT_EOD () {
					return this.SEND_TO_HOST_AT_EOD;
				}
				
			    public String MANUAL_LEVEL;

				public String getMANUAL_LEVEL () {
					return this.MANUAL_LEVEL;
				}
				
			    public String RT_AUTO_LEVEL;

				public String getRT_AUTO_LEVEL () {
					return this.RT_AUTO_LEVEL;
				}
				
			    public String EOM_MANUAL_LEVEL;

				public String getEOM_MANUAL_LEVEL () {
					return this.EOM_MANUAL_LEVEL;
				}
				
			    public int RT_EOM_GROSS_QUANTITY;

				public int getRT_EOM_GROSS_QUANTITY () {
					return this.RT_EOM_GROSS_QUANTITY;
				}
				
			    public double RT_AUTO_DENSITY;

				public double getRT_AUTO_DENSITY () {
					return this.RT_AUTO_DENSITY;
				}
				
			    public double EOM_MANUAL_TEMPERATURE;

				public double getEOM_MANUAL_TEMPERATURE () {
					return this.EOM_MANUAL_TEMPERATURE;
				}
				
			    public double EOM_MANUAL_DENSITY;

				public double getEOM_MANUAL_DENSITY () {
					return this.EOM_MANUAL_DENSITY;
				}
				
			    public int EOM_MANUAL_BSW_QUANTITY;

				public int getEOM_MANUAL_BSW_QUANTITY () {
					return this.EOM_MANUAL_BSW_QUANTITY;
				}
				
			    public String EOM_MANUAL_BSW_LEVEL;

				public String getEOM_MANUAL_BSW_LEVEL () {
					return this.EOM_MANUAL_BSW_LEVEL;
				}
				
			    public double MANUAL_TEMPERATURE;

				public double getMANUAL_TEMPERATURE () {
					return this.MANUAL_TEMPERATURE;
				}
				
			    public int RT_EOM_NET_QUANTITY;

				public int getRT_EOM_NET_QUANTITY () {
					return this.RT_EOM_NET_QUANTITY;
				}
				
			    public double EOM_MANUAL_COE;

				public double getEOM_MANUAL_COE () {
					return this.EOM_MANUAL_COE;
				}
				
			    public int RT_EOM_BSW_QUANTITY;

				public int getRT_EOM_BSW_QUANTITY () {
					return this.RT_EOM_BSW_QUANTITY;
				}
				
			    public java.util.Date MANUAL_DATE;

				public java.util.Date getMANUAL_DATE () {
					return this.MANUAL_DATE;
				}
				
			    public String BASE_SEDIMENT_WATER_LEVEL;

				public String getBASE_SEDIMENT_WATER_LEVEL () {
					return this.BASE_SEDIMENT_WATER_LEVEL;
				}
				
			    public double MANUAL_DENSITY;

				public double getMANUAL_DENSITY () {
					return this.MANUAL_DENSITY;
				}
				
			    public int RT_BSW_QUANTITY;

				public int getRT_BSW_QUANTITY () {
					return this.RT_BSW_QUANTITY;
				}
				
			    public double MANUAL_SPECIFIC_GRAVITY;

				public double getMANUAL_SPECIFIC_GRAVITY () {
					return this.MANUAL_SPECIFIC_GRAVITY;
				}
				
			    public int PIPE_FILL;

				public int getPIPE_FILL () {
					return this.PIPE_FILL;
				}
				
			    public double MANUAL_COEFFICIENT_EXPANSION;

				public double getMANUAL_COEFFICIENT_EXPANSION () {
					return this.MANUAL_COEFFICIENT_EXPANSION;
				}
				
			    public int PROTOCOL_TYPE;

				public int getPROTOCOL_TYPE () {
					return this.PROTOCOL_TYPE;
				}
				
			    public double RT_AUTO_TEMPERATURE;

				public double getRT_AUTO_TEMPERATURE () {
					return this.RT_AUTO_TEMPERATURE;
				}
				
			    public String PORT_NAME;

				public String getPORT_NAME () {
					return this.PORT_NAME;
				}
				
			    public int RT_AUTO_QUANTITY;

				public int getRT_AUTO_QUANTITY () {
					return this.RT_AUTO_QUANTITY;
				}
				
			    public int ADDRESS;

				public int getADDRESS () {
					return this.ADDRESS;
				}
				
			    public String REMARKS;

				public String getREMARKS () {
					return this.REMARKS;
				}
				
			    public int FAST_SCAN;

				public int getFAST_SCAN () {
					return this.FAST_SCAN;
				}
				
			    public String RT_LEVEL;

				public String getRT_LEVEL () {
					return this.RT_LEVEL;
				}
				
			    public int RT_METER_COUNT;

				public int getRT_METER_COUNT () {
					return this.RT_METER_COUNT;
				}
				
			    public int RT_GROSS_SNAPSHOT;

				public int getRT_GROSS_SNAPSHOT () {
					return this.RT_GROSS_SNAPSHOT;
				}
				
			    public int RT_SNAPSHOT_ACTIVE;

				public int getRT_SNAPSHOT_ACTIVE () {
					return this.RT_SNAPSHOT_ACTIVE;
				}
				
			    public String RT_LEVEL_SNAPSHOT;

				public String getRT_LEVEL_SNAPSHOT () {
					return this.RT_LEVEL_SNAPSHOT;
				}
				
			    public int RT_NET_SNAPSHOT;

				public int getRT_NET_SNAPSHOT () {
					return this.RT_NET_SNAPSHOT;
				}
				
			    public java.util.Date RT_SNAPSHOT_DATE;

				public java.util.Date getRT_SNAPSHOT_DATE () {
					return this.RT_SNAPSHOT_DATE;
				}
				
			    public int RT_GROSS_SNAPSHOT_DELTA;

				public int getRT_GROSS_SNAPSHOT_DELTA () {
					return this.RT_GROSS_SNAPSHOT_DELTA;
				}
				
			    public int RT_NET_SNAPSHOT_DELTA;

				public int getRT_NET_SNAPSHOT_DELTA () {
					return this.RT_NET_SNAPSHOT_DELTA;
				}
				
			    public int RT_EOD_MANUAL_DELTA;

				public int getRT_EOD_MANUAL_DELTA () {
					return this.RT_EOD_MANUAL_DELTA;
				}
				
			    public String RT_END_LEVEL_SNAPSHOT;

				public String getRT_END_LEVEL_SNAPSHOT () {
					return this.RT_END_LEVEL_SNAPSHOT;
				}
				
			    public int RT_EOD_OPENING_PHYSICAL;

				public int getRT_EOD_OPENING_PHYSICAL () {
					return this.RT_EOD_OPENING_PHYSICAL;
				}
				
			    public int RT_EOD_BULK_RECEIPTS;

				public int getRT_EOD_BULK_RECEIPTS () {
					return this.RT_EOD_BULK_RECEIPTS;
				}
				
			    public int RT_END_GROSS_SNAPSHOT;

				public int getRT_END_GROSS_SNAPSHOT () {
					return this.RT_END_GROSS_SNAPSHOT;
				}
				
			    public int RT_AVAILABLE_QUANTITY;

				public int getRT_AVAILABLE_QUANTITY () {
					return this.RT_AVAILABLE_QUANTITY;
				}
				
			    public int RT_END_NET_SNAPSHOT;

				public int getRT_END_NET_SNAPSHOT () {
					return this.RT_END_NET_SNAPSHOT;
				}
				
			    public int RT_EOD_BULK_DISPOSALS;

				public int getRT_EOD_BULK_DISPOSALS () {
					return this.RT_EOD_BULK_DISPOSALS;
				}
				
			    public java.util.Date RT_END_SNAPSHOT_DATE;

				public java.util.Date getRT_END_SNAPSHOT_DATE () {
					return this.RT_END_SNAPSHOT_DATE;
				}
				
			    public int RT_EOD_TRANSFERS_IN;

				public int getRT_EOD_TRANSFERS_IN () {
					return this.RT_EOD_TRANSFERS_IN;
				}
				
			    public int RT_EOD_RACK_RECEIPTS;

				public int getRT_EOD_RACK_RECEIPTS () {
					return this.RT_EOD_RACK_RECEIPTS;
				}
				
			    public int RT_EOD_TRANSFERS_OUT;

				public int getRT_EOD_TRANSFERS_OUT () {
					return this.RT_EOD_TRANSFERS_OUT;
				}
				
			    public int RT_EOD_RACK_DISPOSALS;

				public int getRT_EOD_RACK_DISPOSALS () {
					return this.RT_EOD_RACK_DISPOSALS;
				}
				
			    public String LAST_USER_NAME;

				public String getLAST_USER_NAME () {
					return this.LAST_USER_NAME;
				}
				
			    public java.util.Date LAST_MODIFIED;

				public java.util.Date getLAST_MODIFIED () {
					return this.LAST_MODIFIED;
				}
				
			    public int RT_EOD_BOOK_INVENTORY;

				public int getRT_EOD_BOOK_INVENTORY () {
					return this.RT_EOD_BOOK_INVENTORY;
				}
				
			    public String USER_DLL;

				public String getUSER_DLL () {
					return this.USER_DLL;
				}
				
			    public String USER_ROUTINE;

				public String getUSER_ROUTINE () {
					return this.USER_ROUTINE;
				}
				
			    public int ROOF_CORRECTION_TYPE;

				public int getROOF_CORRECTION_TYPE () {
					return this.ROOF_CORRECTION_TYPE;
				}
				
			    public String ROOF_TAKE_OFF_LEVEL;

				public String getROOF_TAKE_OFF_LEVEL () {
					return this.ROOF_TAKE_OFF_LEVEL;
				}
				
			    public String ROOF_SUPPORT_LEVEL;

				public String getROOF_SUPPORT_LEVEL () {
					return this.ROOF_SUPPORT_LEVEL;
				}
				
			    public double ROOF_REFERENCE_DENSITY;

				public double getROOF_REFERENCE_DENSITY () {
					return this.ROOF_REFERENCE_DENSITY;
				}
				
			    public double ROOF_ABOVE_ADJUSTMENT;

				public double getROOF_ABOVE_ADJUSTMENT () {
					return this.ROOF_ABOVE_ADJUSTMENT;
				}
				
			    public int RT_EOD_MANUAL_CLOSING_ENABLE;

				public int getRT_EOD_MANUAL_CLOSING_ENABLE () {
					return this.RT_EOD_MANUAL_CLOSING_ENABLE;
				}
				
			    public double ROOF_BELOW_ADJUSTMENT;

				public double getROOF_BELOW_ADJUSTMENT () {
					return this.ROOF_BELOW_ADJUSTMENT;
				}
				
			    public String RT_EOD_MANUAL_LEVEL;

				public String getRT_EOD_MANUAL_LEVEL () {
					return this.RT_EOD_MANUAL_LEVEL;
				}
				
			    public int STRAPPING_INVERTED;

				public int getSTRAPPING_INVERTED () {
					return this.STRAPPING_INVERTED;
				}
				
			    public int RT_EOD_MANUAL_GROSS_QUANTITY;

				public int getRT_EOD_MANUAL_GROSS_QUANTITY () {
					return this.RT_EOD_MANUAL_GROSS_QUANTITY;
				}
				
			    public int RT_EOD_MANUAL_NET_QUANTITY;

				public int getRT_EOD_MANUAL_NET_QUANTITY () {
					return this.RT_EOD_MANUAL_NET_QUANTITY;
				}
				
			    public int RT_EOD_RACK_FRAC_DISPOSALS;

				public int getRT_EOD_RACK_FRAC_DISPOSALS () {
					return this.RT_EOD_RACK_FRAC_DISPOSALS;
				}
				
			    public int RT_EOD_RACK_FRAC_RECEIPTS;

				public int getRT_EOD_RACK_FRAC_RECEIPTS () {
					return this.RT_EOD_RACK_FRAC_RECEIPTS;
				}
				
			    public String DDE_HIGH_ALARM_DSN;

				public String getDDE_HIGH_ALARM_DSN () {
					return this.DDE_HIGH_ALARM_DSN;
				}
				
			    public String DDE_HIGH_ALARM_ITEM;

				public String getDDE_HIGH_ALARM_ITEM () {
					return this.DDE_HIGH_ALARM_ITEM;
				}
				
			    public String DDE_HIGH_HIGH_ALARM_DSN;

				public String getDDE_HIGH_HIGH_ALARM_DSN () {
					return this.DDE_HIGH_HIGH_ALARM_DSN;
				}
				
			    public String DDE_HIGH_HIGH_ALARM_ITEM;

				public String getDDE_HIGH_HIGH_ALARM_ITEM () {
					return this.DDE_HIGH_HIGH_ALARM_ITEM;
				}
				
			    public String DDE_LOW_ALARM_DSN;

				public String getDDE_LOW_ALARM_DSN () {
					return this.DDE_LOW_ALARM_DSN;
				}
				
			    public String DDE_LOW_ALARM_ITEM;

				public String getDDE_LOW_ALARM_ITEM () {
					return this.DDE_LOW_ALARM_ITEM;
				}
				
			    public String DDE_LOW_LOW_ALARM_DSN;

				public String getDDE_LOW_LOW_ALARM_DSN () {
					return this.DDE_LOW_LOW_ALARM_DSN;
				}
				
			    public String DDE_LOW_LOW_ALARM_ITEM;

				public String getDDE_LOW_LOW_ALARM_ITEM () {
					return this.DDE_LOW_LOW_ALARM_ITEM;
				}
				
			    public String DDE_CUTOFF_ALARM_DSN;

				public String getDDE_CUTOFF_ALARM_DSN () {
					return this.DDE_CUTOFF_ALARM_DSN;
				}
				
			    public String DDE_CUTOFF_ALARM_ITEM;

				public String getDDE_CUTOFF_ALARM_ITEM () {
					return this.DDE_CUTOFF_ALARM_ITEM;
				}
				
			    public String DDE_STATUS_DSN;

				public String getDDE_STATUS_DSN () {
					return this.DDE_STATUS_DSN;
				}
				
			    public String DDE_STATUS_ITEM;

				public String getDDE_STATUS_ITEM () {
					return this.DDE_STATUS_ITEM;
				}
				
			    public double RT_AUTO_PRESSURE;

				public double getRT_AUTO_PRESSURE () {
					return this.RT_AUTO_PRESSURE;
				}
				
			    public int RT_AUTO_MASS;

				public int getRT_AUTO_MASS () {
					return this.RT_AUTO_MASS;
				}
				
			    public double MANUAL_PRESSURE;

				public double getMANUAL_PRESSURE () {
					return this.MANUAL_PRESSURE;
				}
				
			    public int MANUAL_MASS;

				public int getMANUAL_MASS () {
					return this.MANUAL_MASS;
				}
				
			    public double RT_PRESSURE;

				public double getRT_PRESSURE () {
					return this.RT_PRESSURE;
				}
				
			    public int RT_MASS;

				public int getRT_MASS () {
					return this.RT_MASS;
				}
				
			    public int AUTO_PRESSURE_ENABLE;

				public int getAUTO_PRESSURE_ENABLE () {
					return this.AUTO_PRESSURE_ENABLE;
				}
				
			    public int AUTO_MASS_ENABLE;

				public int getAUTO_MASS_ENABLE () {
					return this.AUTO_MASS_ENABLE;
				}
				
			    public int DOWNLOAD_ENABLE;

				public int getDOWNLOAD_ENABLE () {
					return this.DOWNLOAD_ENABLE;
				}
				
			    public int DOWNLOAD_LEVEL_ENABLE;

				public int getDOWNLOAD_LEVEL_ENABLE () {
					return this.DOWNLOAD_LEVEL_ENABLE;
				}
				
			    public int DOWNLOAD_QUANTITY_ENABLE;

				public int getDOWNLOAD_QUANTITY_ENABLE () {
					return this.DOWNLOAD_QUANTITY_ENABLE;
				}
				
			    public int DOWNLOAD_TEMPERATURE_ENABLE;

				public int getDOWNLOAD_TEMPERATURE_ENABLE () {
					return this.DOWNLOAD_TEMPERATURE_ENABLE;
				}
				
			    public int DOWNLOAD_PRESSURE_ENABLE;

				public int getDOWNLOAD_PRESSURE_ENABLE () {
					return this.DOWNLOAD_PRESSURE_ENABLE;
				}
				
			    public int DOWNLOAD_MASS_ENABLE;

				public int getDOWNLOAD_MASS_ENABLE () {
					return this.DOWNLOAD_MASS_ENABLE;
				}
				
			    public int RT_USER_QUEUE_ENABLE;

				public int getRT_USER_QUEUE_ENABLE () {
					return this.RT_USER_QUEUE_ENABLE;
				}
				
			    public int RT_USER_CONTEXT_VALUE;

				public int getRT_USER_CONTEXT_VALUE () {
					return this.RT_USER_CONTEXT_VALUE;
				}
				
			    public int RT_FRAC_GROSS_SNAPSHOT_DELTA;

				public int getRT_FRAC_GROSS_SNAPSHOT_DELTA () {
					return this.RT_FRAC_GROSS_SNAPSHOT_DELTA;
				}
				
			    public int RT_FRAC_NET_SNAPSHOT_DELTA;

				public int getRT_FRAC_NET_SNAPSHOT_DELTA () {
					return this.RT_FRAC_NET_SNAPSHOT_DELTA;
				}
				
			    public int RT_FRAC_EOD_MANUAL_DELTA;

				public int getRT_FRAC_EOD_MANUAL_DELTA () {
					return this.RT_FRAC_EOD_MANUAL_DELTA;
				}
				
			    public double RT_TEMPERATURE_SNAPSHOT;

				public double getRT_TEMPERATURE_SNAPSHOT () {
					return this.RT_TEMPERATURE_SNAPSHOT;
				}
				
			    public double RT_DENSITY_SNAPSHOT;

				public double getRT_DENSITY_SNAPSHOT () {
					return this.RT_DENSITY_SNAPSHOT;
				}
				
			    public double RT_END_TEMPERATURE_SNAPSHOT;

				public double getRT_END_TEMPERATURE_SNAPSHOT () {
					return this.RT_END_TEMPERATURE_SNAPSHOT;
				}
				
			    public double RT_END_DENSITY_SNAPSHOT;

				public double getRT_END_DENSITY_SNAPSHOT () {
					return this.RT_END_DENSITY_SNAPSHOT;
				}
				
			    public int RT_FRAC_EOD_TRANSFERS_IN;

				public int getRT_FRAC_EOD_TRANSFERS_IN () {
					return this.RT_FRAC_EOD_TRANSFERS_IN;
				}
				
			    public int RT_FRAC_EOD_TRANSFERS_OUT;

				public int getRT_FRAC_EOD_TRANSFERS_OUT () {
					return this.RT_FRAC_EOD_TRANSFERS_OUT;
				}
				
			    public int MANUAL_QUANTITY_ENABLE;

				public int getMANUAL_QUANTITY_ENABLE () {
					return this.MANUAL_QUANTITY_ENABLE;
				}
				
			    public int MANUAL_BSW_QUANTITY;

				public int getMANUAL_BSW_QUANTITY () {
					return this.MANUAL_BSW_QUANTITY;
				}
				
			    public int EOM_MANUAL_QUANTITY;

				public int getEOM_MANUAL_QUANTITY () {
					return this.EOM_MANUAL_QUANTITY;
				}
				
			    public int MANUAL_GROSS_QUANTITY;

				public int getMANUAL_GROSS_QUANTITY () {
					return this.MANUAL_GROSS_QUANTITY;
				}
				
			    public int MANUAL_LOW_LOW_QUANTITY;

				public int getMANUAL_LOW_LOW_QUANTITY () {
					return this.MANUAL_LOW_LOW_QUANTITY;
				}
				
			    public int MANUAL_LOW_QUANTITY;

				public int getMANUAL_LOW_QUANTITY () {
					return this.MANUAL_LOW_QUANTITY;
				}
				
			    public int MANUAL_GENERAL_QUANTITY;

				public int getMANUAL_GENERAL_QUANTITY () {
					return this.MANUAL_GENERAL_QUANTITY;
				}
				
			    public int MANUAL_CUTOFF_QUANTITY;

				public int getMANUAL_CUTOFF_QUANTITY () {
					return this.MANUAL_CUTOFF_QUANTITY;
				}
				
			    public int MANUAL_HIGH_QUANTITY;

				public int getMANUAL_HIGH_QUANTITY () {
					return this.MANUAL_HIGH_QUANTITY;
				}
				
			    public int MANUAL_HIGH_HIGH_QUANTITY;

				public int getMANUAL_HIGH_HIGH_QUANTITY () {
					return this.MANUAL_HIGH_HIGH_QUANTITY;
				}
				
			    public double MANUAL_OBSERVED_DENSITY;

				public double getMANUAL_OBSERVED_DENSITY () {
					return this.MANUAL_OBSERVED_DENSITY;
				}
				
			    public double RT_OBSERVED_DENSITY;

				public double getRT_OBSERVED_DENSITY () {
					return this.RT_OBSERVED_DENSITY;
				}
				
			    public double RT_OBS_DENSITY_SNAPSHOT;

				public double getRT_OBS_DENSITY_SNAPSHOT () {
					return this.RT_OBS_DENSITY_SNAPSHOT;
				}
				
			    public double RT_END_OBS_DENSITY_SNAPSHOT;

				public double getRT_END_OBS_DENSITY_SNAPSHOT () {
					return this.RT_END_OBS_DENSITY_SNAPSHOT;
				}
				
			    public int AUTO_BSW_LEVEL_ENABLE;

				public int getAUTO_BSW_LEVEL_ENABLE () {
					return this.AUTO_BSW_LEVEL_ENABLE;
				}
				
			    public int AUTO_BSW_QUANTITY_ENABLE;

				public int getAUTO_BSW_QUANTITY_ENABLE () {
					return this.AUTO_BSW_QUANTITY_ENABLE;
				}
				
			    public String RT_AUTO_BSW_LEVEL;

				public String getRT_AUTO_BSW_LEVEL () {
					return this.RT_AUTO_BSW_LEVEL;
				}
				
			    public int RT_AUTO_BSW_QUANTITY;

				public int getRT_AUTO_BSW_QUANTITY () {
					return this.RT_AUTO_BSW_QUANTITY;
				}
				
			    public String RT_BSW_LEVEL;

				public String getRT_BSW_LEVEL () {
					return this.RT_BSW_LEVEL;
				}
				
			    public String DDE_BSW_LEVEL_DSN;

				public String getDDE_BSW_LEVEL_DSN () {
					return this.DDE_BSW_LEVEL_DSN;
				}
				
			    public String DDE_BSW_LEVEL_ITEM;

				public String getDDE_BSW_LEVEL_ITEM () {
					return this.DDE_BSW_LEVEL_ITEM;
				}
				
			    public String DDE_BSW_QUANTITY_DSN;

				public String getDDE_BSW_QUANTITY_DSN () {
					return this.DDE_BSW_QUANTITY_DSN;
				}
				
			    public String DDE_BSW_QUANTITY_ITEM;

				public String getDDE_BSW_QUANTITY_ITEM () {
					return this.DDE_BSW_QUANTITY_ITEM;
				}
				
			    public int DOWNLOAD_DENSITY_ENABLE;

				public int getDOWNLOAD_DENSITY_ENABLE () {
					return this.DOWNLOAD_DENSITY_ENABLE;
				}
				
			    public int RT_EOD_ADD_MANUAL_DELTA;

				public int getRT_EOD_ADD_MANUAL_DELTA () {
					return this.RT_EOD_ADD_MANUAL_DELTA;
				}
				
			    public int RT_EOD_ADD_BULK_RECEIPTS;

				public int getRT_EOD_ADD_BULK_RECEIPTS () {
					return this.RT_EOD_ADD_BULK_RECEIPTS;
				}
				
			    public int RT_EOD_ADD_RACK_RECEIPTS;

				public int getRT_EOD_ADD_RACK_RECEIPTS () {
					return this.RT_EOD_ADD_RACK_RECEIPTS;
				}
				
			    public int RT_EOD_ADD_TRANSFERS_IN;

				public int getRT_EOD_ADD_TRANSFERS_IN () {
					return this.RT_EOD_ADD_TRANSFERS_IN;
				}
				
			    public int RT_EOD_ADD_BULK_DISPOSALS;

				public int getRT_EOD_ADD_BULK_DISPOSALS () {
					return this.RT_EOD_ADD_BULK_DISPOSALS;
				}
				
			    public int RT_EOD_ADD_RACK_DISPOSALS;

				public int getRT_EOD_ADD_RACK_DISPOSALS () {
					return this.RT_EOD_ADD_RACK_DISPOSALS;
				}
				
			    public int RT_EOD_ADD_TRANSFERS_OUT;

				public int getRT_EOD_ADD_TRANSFERS_OUT () {
					return this.RT_EOD_ADD_TRANSFERS_OUT;
				}
				
			    public int RT_EOD_ADD_BOOK_INVENTORY;

				public int getRT_EOD_ADD_BOOK_INVENTORY () {
					return this.RT_EOD_ADD_BOOK_INVENTORY;
				}
				
			    public int RT_IN_SERVICE;

				public int getRT_IN_SERVICE () {
					return this.RT_IN_SERVICE;
				}
				
			    public int VIRTUAL_TANK;

				public int getVIRTUAL_TANK () {
					return this.VIRTUAL_TANK;
				}
				
			    public String DDE_IN_SERVICE_ITEM;

				public String getDDE_IN_SERVICE_ITEM () {
					return this.DDE_IN_SERVICE_ITEM;
				}
				
			    public String TANK_GROUP;

				public String getTANK_GROUP () {
					return this.TANK_GROUP;
				}
				
			    public String DDE_IN_SERVICE_DSN;

				public String getDDE_IN_SERVICE_DSN () {
					return this.DDE_IN_SERVICE_DSN;
				}
				
			    public int RT_CUTOFF_QUANTITY;

				public int getRT_CUTOFF_QUANTITY () {
					return this.RT_CUTOFF_QUANTITY;
				}
				
			    public int AUTO_NET_QUANTITY_ENABLE;

				public int getAUTO_NET_QUANTITY_ENABLE () {
					return this.AUTO_NET_QUANTITY_ENABLE;
				}
				
			    public String DDE_NET_QUANTITY_ITEM;

				public String getDDE_NET_QUANTITY_ITEM () {
					return this.DDE_NET_QUANTITY_ITEM;
				}
				
			    public int RT_AUTO_NET_QUANTITY;

				public int getRT_AUTO_NET_QUANTITY () {
					return this.RT_AUTO_NET_QUANTITY;
				}
				
			    public String DDE_NET_QUANTITY_DSN;

				public String getDDE_NET_QUANTITY_DSN () {
					return this.DDE_NET_QUANTITY_DSN;
				}
				
			    public int MANUAL_NET_QUANTITY_ENABLE;

				public int getMANUAL_NET_QUANTITY_ENABLE () {
					return this.MANUAL_NET_QUANTITY_ENABLE;
				}
				
			    public int MANUAL_NET_QUANTITY;

				public int getMANUAL_NET_QUANTITY () {
					return this.MANUAL_NET_QUANTITY;
				}
				
			    public String HIGH_BSW_SETPOINT;

				public String getHIGH_BSW_SETPOINT () {
					return this.HIGH_BSW_SETPOINT;
				}
				
			    public int HIGH_BSW_QUANTITY;

				public int getHIGH_BSW_QUANTITY () {
					return this.HIGH_BSW_QUANTITY;
				}
				
			    public String DDE_BSW_HIGH_ALARM_DSN;

				public String getDDE_BSW_HIGH_ALARM_DSN () {
					return this.DDE_BSW_HIGH_ALARM_DSN;
				}
				
			    public String DDE_BSW_HIGH_ALARM_ITEM;

				public String getDDE_BSW_HIGH_ALARM_ITEM () {
					return this.DDE_BSW_HIGH_ALARM_ITEM;
				}
				
			    public int RT_EOD_BULK_FRAC_DISPOSALS;

				public int getRT_EOD_BULK_FRAC_DISPOSALS () {
					return this.RT_EOD_BULK_FRAC_DISPOSALS;
				}
				
			    public int RT_EOD_BULK_FRAC_RECEIPTS;

				public int getRT_EOD_BULK_FRAC_RECEIPTS () {
					return this.RT_EOD_BULK_FRAC_RECEIPTS;
				}
				
			    public String RT_EOD_OPEN_BSW_LEVEL;

				public String getRT_EOD_OPEN_BSW_LEVEL () {
					return this.RT_EOD_OPEN_BSW_LEVEL;
				}
				
			    public double RT_EOD_OPEN_DENSITY;

				public double getRT_EOD_OPEN_DENSITY () {
					return this.RT_EOD_OPEN_DENSITY;
				}
				
			    public double RT_EOD_OPEN_TEMPERATURE;

				public double getRT_EOD_OPEN_TEMPERATURE () {
					return this.RT_EOD_OPEN_TEMPERATURE;
				}
				
			    public int RT_EOD_OPEN_BSW_QUANTITY;

				public int getRT_EOD_OPEN_BSW_QUANTITY () {
					return this.RT_EOD_OPEN_BSW_QUANTITY;
				}
				
			    public String RT_EOD_OPEN_LEVEL;

				public String getRT_EOD_OPEN_LEVEL () {
					return this.RT_EOD_OPEN_LEVEL;
				}
				
			    public double RT_EOD_OPEN_OBSERVED_DENSITY;

				public double getRT_EOD_OPEN_OBSERVED_DENSITY () {
					return this.RT_EOD_OPEN_OBSERVED_DENSITY;
				}
				
			    public int RT_EOD_OPEN_PHYS_GROSS_QTY;

				public int getRT_EOD_OPEN_PHYS_GROSS_QTY () {
					return this.RT_EOD_OPEN_PHYS_GROSS_QTY;
				}
				
			    public String PREV_EOD_LEVEL;

				public String getPREV_EOD_LEVEL () {
					return this.PREV_EOD_LEVEL;
				}
				
			    public int PREV_EOD_GROSS_QUANTITY;

				public int getPREV_EOD_GROSS_QUANTITY () {
					return this.PREV_EOD_GROSS_QUANTITY;
				}
				
			    public double PREV_EOD_TEMPERATURE;

				public double getPREV_EOD_TEMPERATURE () {
					return this.PREV_EOD_TEMPERATURE;
				}
				
			    public double PREV_EOD_DENSITY;

				public double getPREV_EOD_DENSITY () {
					return this.PREV_EOD_DENSITY;
				}
				
			    public int PREV_EOD_BSW_QUANTITY;

				public int getPREV_EOD_BSW_QUANTITY () {
					return this.PREV_EOD_BSW_QUANTITY;
				}
				
			    public String PREV_EOD_BSW_LEVEL;

				public String getPREV_EOD_BSW_LEVEL () {
					return this.PREV_EOD_BSW_LEVEL;
				}
				
			    public int RT_PREV_EOD_NET_QUANTITY;

				public int getRT_PREV_EOD_NET_QUANTITY () {
					return this.RT_PREV_EOD_NET_QUANTITY;
				}
				
			    public double PREV_EOD_COE;

				public double getPREV_EOD_COE () {
					return this.PREV_EOD_COE;
				}
				
			    public int RT_PREV_EOD_BSW_QUANTITY;

				public int getRT_PREV_EOD_BSW_QUANTITY () {
					return this.RT_PREV_EOD_BSW_QUANTITY;
				}
				
			    public int PREV_EOD_QUANTITY;

				public int getPREV_EOD_QUANTITY () {
					return this.PREV_EOD_QUANTITY;
				}
				
			    public double OPENING_COE;

				public double getOPENING_COE () {
					return this.OPENING_COE;
				}
				
			    public int RT_TOV;

				public int getRT_TOV () {
					return this.RT_TOV;
				}
				
			    public int RT_GOV;

				public int getRT_GOV () {
					return this.RT_GOV;
				}
				
			    public int RT_GSV;

				public int getRT_GSV () {
					return this.RT_GSV;
				}
				
			    public int RT_TCV;

				public int getRT_TCV () {
					return this.RT_TCV;
				}
				
			    public double RT_SHELL_CORRECTION_FACTOR;

				public double getRT_SHELL_CORRECTION_FACTOR () {
					return this.RT_SHELL_CORRECTION_FACTOR;
				}
				
			    public int RT_FLOATING_ROOF_ADJUSTMENT;

				public int getRT_FLOATING_ROOF_ADJUSTMENT () {
					return this.RT_FLOATING_ROOF_ADJUSTMENT;
				}
				
			    public double RT_CTL;

				public double getRT_CTL () {
					return this.RT_CTL;
				}
				
			    public double SUSPENDED_BSW_PERCENT;

				public double getSUSPENDED_BSW_PERCENT () {
					return this.SUSPENDED_BSW_PERCENT;
				}
				
			    public int MANUAL_STRAP_TYPE;

				public int getMANUAL_STRAP_TYPE () {
					return this.MANUAL_STRAP_TYPE;
				}
				
			    public int ROOF_TAKE_OFF_STRAP_TYPE;

				public int getROOF_TAKE_OFF_STRAP_TYPE () {
					return this.ROOF_TAKE_OFF_STRAP_TYPE;
				}
				
			    public int ROOF_SUPPORT_STRAP_TYPE;

				public int getROOF_SUPPORT_STRAP_TYPE () {
					return this.ROOF_SUPPORT_STRAP_TYPE;
				}
				
			    public int HIGH_BSW_STRAP_TYPE;

				public int getHIGH_BSW_STRAP_TYPE () {
					return this.HIGH_BSW_STRAP_TYPE;
				}
				
			    public int BASE_SEDIMENT_WATER_STRAP_TYPE;

				public int getBASE_SEDIMENT_WATER_STRAP_TYPE () {
					return this.BASE_SEDIMENT_WATER_STRAP_TYPE;
				}
				
			    public String GAUGER_INITIALS;

				public String getGAUGER_INITIALS () {
					return this.GAUGER_INITIALS;
				}
				
			    public java.util.Date GAUGE_TIMESTAMP;

				public java.util.Date getGAUGE_TIMESTAMP () {
					return this.GAUGE_TIMESTAMP;
				}
				
			    public int LEVEL_UNITS;

				public int getLEVEL_UNITS () {
					return this.LEVEL_UNITS;
				}
				
			    public double SHELL_BASE_TEMPERATURE;

				public double getSHELL_BASE_TEMPERATURE () {
					return this.SHELL_BASE_TEMPERATURE;
				}
				
			    public int SHELL_MATERIAL_TYPE;

				public int getSHELL_MATERIAL_TYPE () {
					return this.SHELL_MATERIAL_TYPE;
				}
				
			    public double MANUAL_AMBIENT_TEMPERATURE;

				public double getMANUAL_AMBIENT_TEMPERATURE () {
					return this.MANUAL_AMBIENT_TEMPERATURE;
				}
				
			    public int INSULATED;

				public int getINSULATED () {
					return this.INSULATED;
				}
				
			    public int LINE_SEGMENT_NSV;

				public int getLINE_SEGMENT_NSV () {
					return this.LINE_SEGMENT_NSV;
				}
				
			    public int RT_CALCULATION_POINT;

				public int getRT_CALCULATION_POINT () {
					return this.RT_CALCULATION_POINT;
				}
				
			    public int ROOF_TAKE_OFF_TOV;

				public int getROOF_TAKE_OFF_TOV () {
					return this.ROOF_TAKE_OFF_TOV;
				}
				
			    public int RT_NSV;

				public int getRT_NSV () {
					return this.RT_NSV;
				}
				
			    public int RT_GSW;

				public int getRT_GSW () {
					return this.RT_GSW;
				}
				
			    public int RT_NSW;

				public int getRT_NSW () {
					return this.RT_NSW;
				}
				
			    public double RT_WCF;

				public double getRT_WCF () {
					return this.RT_WCF;
				}
				
			    public int LINE_SEGMENT_NSW;

				public int getLINE_SEGMENT_NSW () {
					return this.LINE_SEGMENT_NSW;
				}
				
			    public double ROOF_WEIGHT;

				public double getROOF_WEIGHT () {
					return this.ROOF_WEIGHT;
				}
				
			    public int VOL_IN_ALARM;

				public int getVOL_IN_ALARM () {
					return this.VOL_IN_ALARM;
				}
				
			    public int INACTIVITY_QUANTITY;

				public int getINACTIVITY_QUANTITY () {
					return this.INACTIVITY_QUANTITY;
				}
				
			    public int INACTIVITY_ALARM_STATE;

				public int getINACTIVITY_ALARM_STATE () {
					return this.INACTIVITY_ALARM_STATE;
				}
				
			    public int USER_LEVEL;

				public int getUSER_LEVEL () {
					return this.USER_LEVEL;
				}
				
			    public java.util.Date SCHED_PROD_CHANGE_DATE_TIME;

				public java.util.Date getSCHED_PROD_CHANGE_DATE_TIME () {
					return this.SCHED_PROD_CHANGE_DATE_TIME;
				}
				
			    public int SCHED_PROD_CHANGE_TIMEOUT;

				public int getSCHED_PROD_CHANGE_TIMEOUT () {
					return this.SCHED_PROD_CHANGE_TIMEOUT;
				}
				
			    public String SCHED_PROD_CHANGE_EMAIL;

				public String getSCHED_PROD_CHANGE_EMAIL () {
					return this.SCHED_PROD_CHANGE_EMAIL;
				}
				
			    public int SETPOINT_QUANTITY_ENABLE;

				public int getSETPOINT_QUANTITY_ENABLE () {
					return this.SETPOINT_QUANTITY_ENABLE;
				}
				
			    public double MANUAL_MEASURED_DENSITY;

				public double getMANUAL_MEASURED_DENSITY () {
					return this.MANUAL_MEASURED_DENSITY;
				}
				
			    public int WEIGHT_IN_AIR;

				public int getWEIGHT_IN_AIR () {
					return this.WEIGHT_IN_AIR;
				}
				
			    public int TOPS_MONITORING_ACTIVE;

				public int getTOPS_MONITORING_ACTIVE () {
					return this.TOPS_MONITORING_ACTIVE;
				}
				
			    public int SHAPE;

				public int getSHAPE () {
					return this.SHAPE;
				}
				
			    public int ACTUAL_FLOW_RATE_PERIOD;

				public int getACTUAL_FLOW_RATE_PERIOD () {
					return this.ACTUAL_FLOW_RATE_PERIOD;
				}
				
			    public int CALCULATED_FLOW_RATE_PERIOD;

				public int getCALCULATED_FLOW_RATE_PERIOD () {
					return this.CALCULATED_FLOW_RATE_PERIOD;
				}
				
			    public int FLOW_RATE_CLAMPING_PERIOD;

				public int getFLOW_RATE_CLAMPING_PERIOD () {
					return this.FLOW_RATE_CLAMPING_PERIOD;
				}
				
			    public java.util.Date RT_CLAMPING_PERIOD_START;

				public java.util.Date getRT_CLAMPING_PERIOD_START () {
					return this.RT_CLAMPING_PERIOD_START;
				}
				
			    public int VAPOR_CORRECTION_METHOD;

				public int getVAPOR_CORRECTION_METHOD () {
					return this.VAPOR_CORRECTION_METHOD;
				}
				
			    public double VAPOR_TEMPERATURE;

				public double getVAPOR_TEMPERATURE () {
					return this.VAPOR_TEMPERATURE;
				}
				
			    public double VAPOR_LIQUID_VOLUME_RATIO;

				public double getVAPOR_LIQUID_VOLUME_RATIO () {
					return this.VAPOR_LIQUID_VOLUME_RATIO;
				}
				
			    public int TARGET_LEVEL;

				public int getTARGET_LEVEL () {
					return this.TARGET_LEVEL;
				}
				
			    public int ORIGINAL_STARTING_LEVEL;

				public int getORIGINAL_STARTING_LEVEL () {
					return this.ORIGINAL_STARTING_LEVEL;
				}
				
			    public int TIME_TO_TARGET_LEVEL;

				public int getTIME_TO_TARGET_LEVEL () {
					return this.TIME_TO_TARGET_LEVEL;
				}
				
			    public int AUTO_VAPOR_TEMPERATURE_ENABLE;

				public int getAUTO_VAPOR_TEMPERATURE_ENABLE () {
					return this.AUTO_VAPOR_TEMPERATURE_ENABLE;
				}
				
			    public String DDE_PRESSURE_DSN;

				public String getDDE_PRESSURE_DSN () {
					return this.DDE_PRESSURE_DSN;
				}
				
			    public String DDE_PRESSURE_ITEM;

				public String getDDE_PRESSURE_ITEM () {
					return this.DDE_PRESSURE_ITEM;
				}
				
			    public String DDE_VAPOR_TEMPERATURE_DSN;

				public String getDDE_VAPOR_TEMPERATURE_DSN () {
					return this.DDE_VAPOR_TEMPERATURE_DSN;
				}
				
			    public String DDE_VAPOR_TEMPERATURE_ITEM;

				public String getDDE_VAPOR_TEMPERATURE_ITEM () {
					return this.DDE_VAPOR_TEMPERATURE_ITEM;
				}
				
			    public double RT_AUTO_VAPOR_TEMPERATURE;

				public double getRT_AUTO_VAPOR_TEMPERATURE () {
					return this.RT_AUTO_VAPOR_TEMPERATURE;
				}
				
			    public double RT_VAPOR_TEMPERATURE;

				public double getRT_VAPOR_TEMPERATURE () {
					return this.RT_VAPOR_TEMPERATURE;
				}
				
			    public int INVENTORY_ENABLE;

				public int getINVENTORY_ENABLE () {
					return this.INVENTORY_ENABLE;
				}
				
			    public int MANUAL_TO_AUTO_FOLIO_LIMIT;

				public int getMANUAL_TO_AUTO_FOLIO_LIMIT () {
					return this.MANUAL_TO_AUTO_FOLIO_LIMIT;
				}
				
			    public int RT_MANUAL_TO_AUTO_FOLIO_COUNT;

				public int getRT_MANUAL_TO_AUTO_FOLIO_COUNT () {
					return this.RT_MANUAL_TO_AUTO_FOLIO_COUNT;
				}
				
			    public int RT_LEVEL_ORIGIN;

				public int getRT_LEVEL_ORIGIN () {
					return this.RT_LEVEL_ORIGIN;
				}
				
			    public int RT_TOV_ORIGIN;

				public int getRT_TOV_ORIGIN () {
					return this.RT_TOV_ORIGIN;
				}
				
			    public int RT_TEMPERATURE_ORIGIN;

				public int getRT_TEMPERATURE_ORIGIN () {
					return this.RT_TEMPERATURE_ORIGIN;
				}
				
			    public int RT_DENSITY_ORIGIN;

				public int getRT_DENSITY_ORIGIN () {
					return this.RT_DENSITY_ORIGIN;
				}
				
			    public int RT_NSV_ORIGIN;

				public int getRT_NSV_ORIGIN () {
					return this.RT_NSV_ORIGIN;
				}
				
			    public int RT_VAPOR_TEMPERATURE_ORIGIN;

				public int getRT_VAPOR_TEMPERATURE_ORIGIN () {
					return this.RT_VAPOR_TEMPERATURE_ORIGIN;
				}
				
			    public int RT_PRESSURE_ORIGIN;

				public int getRT_PRESSURE_ORIGIN () {
					return this.RT_PRESSURE_ORIGIN;
				}
				
			    public int RT_FREE_WATER_LEVEL_ORIGIN;

				public int getRT_FREE_WATER_LEVEL_ORIGIN () {
					return this.RT_FREE_WATER_LEVEL_ORIGIN;
				}
				
			    public int RT_WATER_QUANTITY_ORIGIN;

				public int getRT_WATER_QUANTITY_ORIGIN () {
					return this.RT_WATER_QUANTITY_ORIGIN;
				}
				
			    public String DDE_SNAPSHOT_REQ_DSN;

				public String getDDE_SNAPSHOT_REQ_DSN () {
					return this.DDE_SNAPSHOT_REQ_DSN;
				}
				
			    public String DDE_SNAPSHOT_REQ_ITEM;

				public String getDDE_SNAPSHOT_REQ_ITEM () {
					return this.DDE_SNAPSHOT_REQ_ITEM;
				}
				
			    public String DDE_SNAPSHOT_RSP_DSN;

				public String getDDE_SNAPSHOT_RSP_DSN () {
					return this.DDE_SNAPSHOT_RSP_DSN;
				}
				
			    public String DDE_SNAPSHOT_RSP_ITEM;

				public String getDDE_SNAPSHOT_RSP_ITEM () {
					return this.DDE_SNAPSHOT_RSP_ITEM;
				}
				
			    public int AUTO_PRODUCT_LEVEL_UNIT;

				public int getAUTO_PRODUCT_LEVEL_UNIT () {
					return this.AUTO_PRODUCT_LEVEL_UNIT;
				}
				
			    public int AUTO_FREE_WATER_LEVEL_UNIT;

				public int getAUTO_FREE_WATER_LEVEL_UNIT () {
					return this.AUTO_FREE_WATER_LEVEL_UNIT;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PGS_STAGE_DIM_TANK.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_TANK.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_TANK = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_TANK = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PGS_STAGE_DIM_TANK, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_TANK, 0, length, utf8Charset);
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
			if(length > commonByteArray_PGS_STAGE_DIM_TANK.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_TANK.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_TANK = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_TANK = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PGS_STAGE_DIM_TANK, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_TANK, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_TANK) {

        	try {

        		int length = 0;
		
					this.TANK_CODE = readString(dis);
					
					this.NAME = readString(dis);
					
						this.COMPARTMENT_OWNER_ID = readInteger(dis);
					
						this.MAJORITY_SHAREHOLDER = readInteger(dis);
					
					this.COMPARTMENT_CONTAINER_CODE = readString(dis);
					
			        this.RT_GROSS_QUANTITY = dis.readInt();
					
						this.COMPARTMENT_CONTAINER_TYPE = readInteger(dis);
					
			        this.TERMINAL_PRODUCT_NUMBER = dis.readInt();
					
						this.COMPARTMENT_NUMBER = readInteger(dis);
					
			        this.RT_NET_QUANTITY = dis.readInt();
					
			        this.ENABLE = dis.readInt();
					
						this.SCHED_PROD_CHANGE_PRODUCT = readInteger(dis);
					
			        this.RVP = dis.readDouble();
					
			        this.OXYGEN = dis.readDouble();
					
			        this.RT_TEMPERATURE = dis.readDouble();
					
			        this.RT_DENSITY = dis.readDouble();
					
			        this.SHELL_CAPACITY = dis.readInt();
					
			        this.WORK_CAPACITY = dis.readInt();
					
					this.DEPTH = readString(dis);
					
					this.LOW_LOW_SETPOINT = readString(dis);
					
					this.LOW_SETPOINT = readString(dis);
					
					this.GENERAL_SETPOINT = readString(dis);
					
					this.CUTOFF_SETPOINT = readString(dis);
					
			        this.AUTO_ENABLE = dis.readInt();
					
					this.HIGH_SETPOINT = readString(dis);
					
					this.HIGH_HIGH_SETPOINT = readString(dis);
					
			        this.DEADBAND = dis.readInt();
					
			        this.AUTO_LEVEL_ENABLE = dis.readInt();
					
					this.DDE_LEVEL_DSN = readString(dis);
					
			        this.AUTO_DENSITY_ENABLE = dis.readInt();
					
			        this.AUTO_TEMPERATURE_ENABLE = dis.readInt();
					
					this.DDE_LEVEL_ITEM = readString(dis);
					
			        this.AUTO_QUANTITY_ENABLE = dis.readInt();
					
					this.DDE_DENSITY_DSN = readString(dis);
					
			        this.ACTIVITY_STATUS = dis.readInt();
					
					this.DDE_DENSITY_ITEM = readString(dis);
					
					this.DDE_TEMPERATURE_DSN = readString(dis);
					
			        this.RECEIPT_INDICATOR = dis.readInt();
					
					this.DDE_TEMPERATURE_ITEM = readString(dis);
					
					this.LAST_RECEIPT_DATE = readDate(dis);
					
					this.DDE_QUANTITY_DSN = readString(dis);
					
					this.DDE_QUANTITY_ITEM = readString(dis);
					
			        this.SEND_TO_HOST_AT_EOD = dis.readInt();
					
					this.MANUAL_LEVEL = readString(dis);
					
					this.RT_AUTO_LEVEL = readString(dis);
					
					this.EOM_MANUAL_LEVEL = readString(dis);
					
			        this.RT_EOM_GROSS_QUANTITY = dis.readInt();
					
			        this.RT_AUTO_DENSITY = dis.readDouble();
					
			        this.EOM_MANUAL_TEMPERATURE = dis.readDouble();
					
			        this.EOM_MANUAL_DENSITY = dis.readDouble();
					
			        this.EOM_MANUAL_BSW_QUANTITY = dis.readInt();
					
					this.EOM_MANUAL_BSW_LEVEL = readString(dis);
					
			        this.MANUAL_TEMPERATURE = dis.readDouble();
					
			        this.RT_EOM_NET_QUANTITY = dis.readInt();
					
			        this.EOM_MANUAL_COE = dis.readDouble();
					
			        this.RT_EOM_BSW_QUANTITY = dis.readInt();
					
					this.MANUAL_DATE = readDate(dis);
					
					this.BASE_SEDIMENT_WATER_LEVEL = readString(dis);
					
			        this.MANUAL_DENSITY = dis.readDouble();
					
			        this.RT_BSW_QUANTITY = dis.readInt();
					
			        this.MANUAL_SPECIFIC_GRAVITY = dis.readDouble();
					
			        this.PIPE_FILL = dis.readInt();
					
			        this.MANUAL_COEFFICIENT_EXPANSION = dis.readDouble();
					
			        this.PROTOCOL_TYPE = dis.readInt();
					
			        this.RT_AUTO_TEMPERATURE = dis.readDouble();
					
					this.PORT_NAME = readString(dis);
					
			        this.RT_AUTO_QUANTITY = dis.readInt();
					
			        this.ADDRESS = dis.readInt();
					
					this.REMARKS = readString(dis);
					
			        this.FAST_SCAN = dis.readInt();
					
					this.RT_LEVEL = readString(dis);
					
			        this.RT_METER_COUNT = dis.readInt();
					
			        this.RT_GROSS_SNAPSHOT = dis.readInt();
					
			        this.RT_SNAPSHOT_ACTIVE = dis.readInt();
					
					this.RT_LEVEL_SNAPSHOT = readString(dis);
					
			        this.RT_NET_SNAPSHOT = dis.readInt();
					
					this.RT_SNAPSHOT_DATE = readDate(dis);
					
			        this.RT_GROSS_SNAPSHOT_DELTA = dis.readInt();
					
			        this.RT_NET_SNAPSHOT_DELTA = dis.readInt();
					
			        this.RT_EOD_MANUAL_DELTA = dis.readInt();
					
					this.RT_END_LEVEL_SNAPSHOT = readString(dis);
					
			        this.RT_EOD_OPENING_PHYSICAL = dis.readInt();
					
			        this.RT_EOD_BULK_RECEIPTS = dis.readInt();
					
			        this.RT_END_GROSS_SNAPSHOT = dis.readInt();
					
			        this.RT_AVAILABLE_QUANTITY = dis.readInt();
					
			        this.RT_END_NET_SNAPSHOT = dis.readInt();
					
			        this.RT_EOD_BULK_DISPOSALS = dis.readInt();
					
					this.RT_END_SNAPSHOT_DATE = readDate(dis);
					
			        this.RT_EOD_TRANSFERS_IN = dis.readInt();
					
			        this.RT_EOD_RACK_RECEIPTS = dis.readInt();
					
			        this.RT_EOD_TRANSFERS_OUT = dis.readInt();
					
			        this.RT_EOD_RACK_DISPOSALS = dis.readInt();
					
					this.LAST_USER_NAME = readString(dis);
					
					this.LAST_MODIFIED = readDate(dis);
					
			        this.RT_EOD_BOOK_INVENTORY = dis.readInt();
					
					this.USER_DLL = readString(dis);
					
					this.USER_ROUTINE = readString(dis);
					
			        this.ROOF_CORRECTION_TYPE = dis.readInt();
					
					this.ROOF_TAKE_OFF_LEVEL = readString(dis);
					
					this.ROOF_SUPPORT_LEVEL = readString(dis);
					
			        this.ROOF_REFERENCE_DENSITY = dis.readDouble();
					
			        this.ROOF_ABOVE_ADJUSTMENT = dis.readDouble();
					
			        this.RT_EOD_MANUAL_CLOSING_ENABLE = dis.readInt();
					
			        this.ROOF_BELOW_ADJUSTMENT = dis.readDouble();
					
					this.RT_EOD_MANUAL_LEVEL = readString(dis);
					
			        this.STRAPPING_INVERTED = dis.readInt();
					
			        this.RT_EOD_MANUAL_GROSS_QUANTITY = dis.readInt();
					
			        this.RT_EOD_MANUAL_NET_QUANTITY = dis.readInt();
					
			        this.RT_EOD_RACK_FRAC_DISPOSALS = dis.readInt();
					
			        this.RT_EOD_RACK_FRAC_RECEIPTS = dis.readInt();
					
					this.DDE_HIGH_ALARM_DSN = readString(dis);
					
					this.DDE_HIGH_ALARM_ITEM = readString(dis);
					
					this.DDE_HIGH_HIGH_ALARM_DSN = readString(dis);
					
					this.DDE_HIGH_HIGH_ALARM_ITEM = readString(dis);
					
					this.DDE_LOW_ALARM_DSN = readString(dis);
					
					this.DDE_LOW_ALARM_ITEM = readString(dis);
					
					this.DDE_LOW_LOW_ALARM_DSN = readString(dis);
					
					this.DDE_LOW_LOW_ALARM_ITEM = readString(dis);
					
					this.DDE_CUTOFF_ALARM_DSN = readString(dis);
					
					this.DDE_CUTOFF_ALARM_ITEM = readString(dis);
					
					this.DDE_STATUS_DSN = readString(dis);
					
					this.DDE_STATUS_ITEM = readString(dis);
					
			        this.RT_AUTO_PRESSURE = dis.readDouble();
					
			        this.RT_AUTO_MASS = dis.readInt();
					
			        this.MANUAL_PRESSURE = dis.readDouble();
					
			        this.MANUAL_MASS = dis.readInt();
					
			        this.RT_PRESSURE = dis.readDouble();
					
			        this.RT_MASS = dis.readInt();
					
			        this.AUTO_PRESSURE_ENABLE = dis.readInt();
					
			        this.AUTO_MASS_ENABLE = dis.readInt();
					
			        this.DOWNLOAD_ENABLE = dis.readInt();
					
			        this.DOWNLOAD_LEVEL_ENABLE = dis.readInt();
					
			        this.DOWNLOAD_QUANTITY_ENABLE = dis.readInt();
					
			        this.DOWNLOAD_TEMPERATURE_ENABLE = dis.readInt();
					
			        this.DOWNLOAD_PRESSURE_ENABLE = dis.readInt();
					
			        this.DOWNLOAD_MASS_ENABLE = dis.readInt();
					
			        this.RT_USER_QUEUE_ENABLE = dis.readInt();
					
			        this.RT_USER_CONTEXT_VALUE = dis.readInt();
					
			        this.RT_FRAC_GROSS_SNAPSHOT_DELTA = dis.readInt();
					
			        this.RT_FRAC_NET_SNAPSHOT_DELTA = dis.readInt();
					
			        this.RT_FRAC_EOD_MANUAL_DELTA = dis.readInt();
					
			        this.RT_TEMPERATURE_SNAPSHOT = dis.readDouble();
					
			        this.RT_DENSITY_SNAPSHOT = dis.readDouble();
					
			        this.RT_END_TEMPERATURE_SNAPSHOT = dis.readDouble();
					
			        this.RT_END_DENSITY_SNAPSHOT = dis.readDouble();
					
			        this.RT_FRAC_EOD_TRANSFERS_IN = dis.readInt();
					
			        this.RT_FRAC_EOD_TRANSFERS_OUT = dis.readInt();
					
			        this.MANUAL_QUANTITY_ENABLE = dis.readInt();
					
			        this.MANUAL_BSW_QUANTITY = dis.readInt();
					
			        this.EOM_MANUAL_QUANTITY = dis.readInt();
					
			        this.MANUAL_GROSS_QUANTITY = dis.readInt();
					
			        this.MANUAL_LOW_LOW_QUANTITY = dis.readInt();
					
			        this.MANUAL_LOW_QUANTITY = dis.readInt();
					
			        this.MANUAL_GENERAL_QUANTITY = dis.readInt();
					
			        this.MANUAL_CUTOFF_QUANTITY = dis.readInt();
					
			        this.MANUAL_HIGH_QUANTITY = dis.readInt();
					
			        this.MANUAL_HIGH_HIGH_QUANTITY = dis.readInt();
					
			        this.MANUAL_OBSERVED_DENSITY = dis.readDouble();
					
			        this.RT_OBSERVED_DENSITY = dis.readDouble();
					
			        this.RT_OBS_DENSITY_SNAPSHOT = dis.readDouble();
					
			        this.RT_END_OBS_DENSITY_SNAPSHOT = dis.readDouble();
					
			        this.AUTO_BSW_LEVEL_ENABLE = dis.readInt();
					
			        this.AUTO_BSW_QUANTITY_ENABLE = dis.readInt();
					
					this.RT_AUTO_BSW_LEVEL = readString(dis);
					
			        this.RT_AUTO_BSW_QUANTITY = dis.readInt();
					
					this.RT_BSW_LEVEL = readString(dis);
					
					this.DDE_BSW_LEVEL_DSN = readString(dis);
					
					this.DDE_BSW_LEVEL_ITEM = readString(dis);
					
					this.DDE_BSW_QUANTITY_DSN = readString(dis);
					
					this.DDE_BSW_QUANTITY_ITEM = readString(dis);
					
			        this.DOWNLOAD_DENSITY_ENABLE = dis.readInt();
					
			        this.RT_EOD_ADD_MANUAL_DELTA = dis.readInt();
					
			        this.RT_EOD_ADD_BULK_RECEIPTS = dis.readInt();
					
			        this.RT_EOD_ADD_RACK_RECEIPTS = dis.readInt();
					
			        this.RT_EOD_ADD_TRANSFERS_IN = dis.readInt();
					
			        this.RT_EOD_ADD_BULK_DISPOSALS = dis.readInt();
					
			        this.RT_EOD_ADD_RACK_DISPOSALS = dis.readInt();
					
			        this.RT_EOD_ADD_TRANSFERS_OUT = dis.readInt();
					
			        this.RT_EOD_ADD_BOOK_INVENTORY = dis.readInt();
					
			        this.RT_IN_SERVICE = dis.readInt();
					
			        this.VIRTUAL_TANK = dis.readInt();
					
					this.DDE_IN_SERVICE_ITEM = readString(dis);
					
					this.TANK_GROUP = readString(dis);
					
					this.DDE_IN_SERVICE_DSN = readString(dis);
					
			        this.RT_CUTOFF_QUANTITY = dis.readInt();
					
			        this.AUTO_NET_QUANTITY_ENABLE = dis.readInt();
					
					this.DDE_NET_QUANTITY_ITEM = readString(dis);
					
			        this.RT_AUTO_NET_QUANTITY = dis.readInt();
					
					this.DDE_NET_QUANTITY_DSN = readString(dis);
					
			        this.MANUAL_NET_QUANTITY_ENABLE = dis.readInt();
					
			        this.MANUAL_NET_QUANTITY = dis.readInt();
					
					this.HIGH_BSW_SETPOINT = readString(dis);
					
			        this.HIGH_BSW_QUANTITY = dis.readInt();
					
					this.DDE_BSW_HIGH_ALARM_DSN = readString(dis);
					
					this.DDE_BSW_HIGH_ALARM_ITEM = readString(dis);
					
			        this.RT_EOD_BULK_FRAC_DISPOSALS = dis.readInt();
					
			        this.RT_EOD_BULK_FRAC_RECEIPTS = dis.readInt();
					
					this.RT_EOD_OPEN_BSW_LEVEL = readString(dis);
					
			        this.RT_EOD_OPEN_DENSITY = dis.readDouble();
					
			        this.RT_EOD_OPEN_TEMPERATURE = dis.readDouble();
					
			        this.RT_EOD_OPEN_BSW_QUANTITY = dis.readInt();
					
					this.RT_EOD_OPEN_LEVEL = readString(dis);
					
			        this.RT_EOD_OPEN_OBSERVED_DENSITY = dis.readDouble();
					
			        this.RT_EOD_OPEN_PHYS_GROSS_QTY = dis.readInt();
					
					this.PREV_EOD_LEVEL = readString(dis);
					
			        this.PREV_EOD_GROSS_QUANTITY = dis.readInt();
					
			        this.PREV_EOD_TEMPERATURE = dis.readDouble();
					
			        this.PREV_EOD_DENSITY = dis.readDouble();
					
			        this.PREV_EOD_BSW_QUANTITY = dis.readInt();
					
					this.PREV_EOD_BSW_LEVEL = readString(dis);
					
			        this.RT_PREV_EOD_NET_QUANTITY = dis.readInt();
					
			        this.PREV_EOD_COE = dis.readDouble();
					
			        this.RT_PREV_EOD_BSW_QUANTITY = dis.readInt();
					
			        this.PREV_EOD_QUANTITY = dis.readInt();
					
			        this.OPENING_COE = dis.readDouble();
					
			        this.RT_TOV = dis.readInt();
					
			        this.RT_GOV = dis.readInt();
					
			        this.RT_GSV = dis.readInt();
					
			        this.RT_TCV = dis.readInt();
					
			        this.RT_SHELL_CORRECTION_FACTOR = dis.readDouble();
					
			        this.RT_FLOATING_ROOF_ADJUSTMENT = dis.readInt();
					
			        this.RT_CTL = dis.readDouble();
					
			        this.SUSPENDED_BSW_PERCENT = dis.readDouble();
					
			        this.MANUAL_STRAP_TYPE = dis.readInt();
					
			        this.ROOF_TAKE_OFF_STRAP_TYPE = dis.readInt();
					
			        this.ROOF_SUPPORT_STRAP_TYPE = dis.readInt();
					
			        this.HIGH_BSW_STRAP_TYPE = dis.readInt();
					
			        this.BASE_SEDIMENT_WATER_STRAP_TYPE = dis.readInt();
					
					this.GAUGER_INITIALS = readString(dis);
					
					this.GAUGE_TIMESTAMP = readDate(dis);
					
			        this.LEVEL_UNITS = dis.readInt();
					
			        this.SHELL_BASE_TEMPERATURE = dis.readDouble();
					
			        this.SHELL_MATERIAL_TYPE = dis.readInt();
					
			        this.MANUAL_AMBIENT_TEMPERATURE = dis.readDouble();
					
			        this.INSULATED = dis.readInt();
					
			        this.LINE_SEGMENT_NSV = dis.readInt();
					
			        this.RT_CALCULATION_POINT = dis.readInt();
					
			        this.ROOF_TAKE_OFF_TOV = dis.readInt();
					
			        this.RT_NSV = dis.readInt();
					
			        this.RT_GSW = dis.readInt();
					
			        this.RT_NSW = dis.readInt();
					
			        this.RT_WCF = dis.readDouble();
					
			        this.LINE_SEGMENT_NSW = dis.readInt();
					
			        this.ROOF_WEIGHT = dis.readDouble();
					
			        this.VOL_IN_ALARM = dis.readInt();
					
			        this.INACTIVITY_QUANTITY = dis.readInt();
					
			        this.INACTIVITY_ALARM_STATE = dis.readInt();
					
			        this.USER_LEVEL = dis.readInt();
					
					this.SCHED_PROD_CHANGE_DATE_TIME = readDate(dis);
					
			        this.SCHED_PROD_CHANGE_TIMEOUT = dis.readInt();
					
					this.SCHED_PROD_CHANGE_EMAIL = readString(dis);
					
			        this.SETPOINT_QUANTITY_ENABLE = dis.readInt();
					
			        this.MANUAL_MEASURED_DENSITY = dis.readDouble();
					
			        this.WEIGHT_IN_AIR = dis.readInt();
					
			        this.TOPS_MONITORING_ACTIVE = dis.readInt();
					
			        this.SHAPE = dis.readInt();
					
			        this.ACTUAL_FLOW_RATE_PERIOD = dis.readInt();
					
			        this.CALCULATED_FLOW_RATE_PERIOD = dis.readInt();
					
			        this.FLOW_RATE_CLAMPING_PERIOD = dis.readInt();
					
					this.RT_CLAMPING_PERIOD_START = readDate(dis);
					
			        this.VAPOR_CORRECTION_METHOD = dis.readInt();
					
			        this.VAPOR_TEMPERATURE = dis.readDouble();
					
			        this.VAPOR_LIQUID_VOLUME_RATIO = dis.readDouble();
					
			        this.TARGET_LEVEL = dis.readInt();
					
			        this.ORIGINAL_STARTING_LEVEL = dis.readInt();
					
			        this.TIME_TO_TARGET_LEVEL = dis.readInt();
					
			        this.AUTO_VAPOR_TEMPERATURE_ENABLE = dis.readInt();
					
					this.DDE_PRESSURE_DSN = readString(dis);
					
					this.DDE_PRESSURE_ITEM = readString(dis);
					
					this.DDE_VAPOR_TEMPERATURE_DSN = readString(dis);
					
					this.DDE_VAPOR_TEMPERATURE_ITEM = readString(dis);
					
			        this.RT_AUTO_VAPOR_TEMPERATURE = dis.readDouble();
					
			        this.RT_VAPOR_TEMPERATURE = dis.readDouble();
					
			        this.INVENTORY_ENABLE = dis.readInt();
					
			        this.MANUAL_TO_AUTO_FOLIO_LIMIT = dis.readInt();
					
			        this.RT_MANUAL_TO_AUTO_FOLIO_COUNT = dis.readInt();
					
			        this.RT_LEVEL_ORIGIN = dis.readInt();
					
			        this.RT_TOV_ORIGIN = dis.readInt();
					
			        this.RT_TEMPERATURE_ORIGIN = dis.readInt();
					
			        this.RT_DENSITY_ORIGIN = dis.readInt();
					
			        this.RT_NSV_ORIGIN = dis.readInt();
					
			        this.RT_VAPOR_TEMPERATURE_ORIGIN = dis.readInt();
					
			        this.RT_PRESSURE_ORIGIN = dis.readInt();
					
			        this.RT_FREE_WATER_LEVEL_ORIGIN = dis.readInt();
					
			        this.RT_WATER_QUANTITY_ORIGIN = dis.readInt();
					
					this.DDE_SNAPSHOT_REQ_DSN = readString(dis);
					
					this.DDE_SNAPSHOT_REQ_ITEM = readString(dis);
					
					this.DDE_SNAPSHOT_RSP_DSN = readString(dis);
					
					this.DDE_SNAPSHOT_RSP_ITEM = readString(dis);
					
			        this.AUTO_PRODUCT_LEVEL_UNIT = dis.readInt();
					
			        this.AUTO_FREE_WATER_LEVEL_UNIT = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_TANK) {

        	try {

        		int length = 0;
		
					this.TANK_CODE = readString(dis);
					
					this.NAME = readString(dis);
					
						this.COMPARTMENT_OWNER_ID = readInteger(dis);
					
						this.MAJORITY_SHAREHOLDER = readInteger(dis);
					
					this.COMPARTMENT_CONTAINER_CODE = readString(dis);
					
			        this.RT_GROSS_QUANTITY = dis.readInt();
					
						this.COMPARTMENT_CONTAINER_TYPE = readInteger(dis);
					
			        this.TERMINAL_PRODUCT_NUMBER = dis.readInt();
					
						this.COMPARTMENT_NUMBER = readInteger(dis);
					
			        this.RT_NET_QUANTITY = dis.readInt();
					
			        this.ENABLE = dis.readInt();
					
						this.SCHED_PROD_CHANGE_PRODUCT = readInteger(dis);
					
			        this.RVP = dis.readDouble();
					
			        this.OXYGEN = dis.readDouble();
					
			        this.RT_TEMPERATURE = dis.readDouble();
					
			        this.RT_DENSITY = dis.readDouble();
					
			        this.SHELL_CAPACITY = dis.readInt();
					
			        this.WORK_CAPACITY = dis.readInt();
					
					this.DEPTH = readString(dis);
					
					this.LOW_LOW_SETPOINT = readString(dis);
					
					this.LOW_SETPOINT = readString(dis);
					
					this.GENERAL_SETPOINT = readString(dis);
					
					this.CUTOFF_SETPOINT = readString(dis);
					
			        this.AUTO_ENABLE = dis.readInt();
					
					this.HIGH_SETPOINT = readString(dis);
					
					this.HIGH_HIGH_SETPOINT = readString(dis);
					
			        this.DEADBAND = dis.readInt();
					
			        this.AUTO_LEVEL_ENABLE = dis.readInt();
					
					this.DDE_LEVEL_DSN = readString(dis);
					
			        this.AUTO_DENSITY_ENABLE = dis.readInt();
					
			        this.AUTO_TEMPERATURE_ENABLE = dis.readInt();
					
					this.DDE_LEVEL_ITEM = readString(dis);
					
			        this.AUTO_QUANTITY_ENABLE = dis.readInt();
					
					this.DDE_DENSITY_DSN = readString(dis);
					
			        this.ACTIVITY_STATUS = dis.readInt();
					
					this.DDE_DENSITY_ITEM = readString(dis);
					
					this.DDE_TEMPERATURE_DSN = readString(dis);
					
			        this.RECEIPT_INDICATOR = dis.readInt();
					
					this.DDE_TEMPERATURE_ITEM = readString(dis);
					
					this.LAST_RECEIPT_DATE = readDate(dis);
					
					this.DDE_QUANTITY_DSN = readString(dis);
					
					this.DDE_QUANTITY_ITEM = readString(dis);
					
			        this.SEND_TO_HOST_AT_EOD = dis.readInt();
					
					this.MANUAL_LEVEL = readString(dis);
					
					this.RT_AUTO_LEVEL = readString(dis);
					
					this.EOM_MANUAL_LEVEL = readString(dis);
					
			        this.RT_EOM_GROSS_QUANTITY = dis.readInt();
					
			        this.RT_AUTO_DENSITY = dis.readDouble();
					
			        this.EOM_MANUAL_TEMPERATURE = dis.readDouble();
					
			        this.EOM_MANUAL_DENSITY = dis.readDouble();
					
			        this.EOM_MANUAL_BSW_QUANTITY = dis.readInt();
					
					this.EOM_MANUAL_BSW_LEVEL = readString(dis);
					
			        this.MANUAL_TEMPERATURE = dis.readDouble();
					
			        this.RT_EOM_NET_QUANTITY = dis.readInt();
					
			        this.EOM_MANUAL_COE = dis.readDouble();
					
			        this.RT_EOM_BSW_QUANTITY = dis.readInt();
					
					this.MANUAL_DATE = readDate(dis);
					
					this.BASE_SEDIMENT_WATER_LEVEL = readString(dis);
					
			        this.MANUAL_DENSITY = dis.readDouble();
					
			        this.RT_BSW_QUANTITY = dis.readInt();
					
			        this.MANUAL_SPECIFIC_GRAVITY = dis.readDouble();
					
			        this.PIPE_FILL = dis.readInt();
					
			        this.MANUAL_COEFFICIENT_EXPANSION = dis.readDouble();
					
			        this.PROTOCOL_TYPE = dis.readInt();
					
			        this.RT_AUTO_TEMPERATURE = dis.readDouble();
					
					this.PORT_NAME = readString(dis);
					
			        this.RT_AUTO_QUANTITY = dis.readInt();
					
			        this.ADDRESS = dis.readInt();
					
					this.REMARKS = readString(dis);
					
			        this.FAST_SCAN = dis.readInt();
					
					this.RT_LEVEL = readString(dis);
					
			        this.RT_METER_COUNT = dis.readInt();
					
			        this.RT_GROSS_SNAPSHOT = dis.readInt();
					
			        this.RT_SNAPSHOT_ACTIVE = dis.readInt();
					
					this.RT_LEVEL_SNAPSHOT = readString(dis);
					
			        this.RT_NET_SNAPSHOT = dis.readInt();
					
					this.RT_SNAPSHOT_DATE = readDate(dis);
					
			        this.RT_GROSS_SNAPSHOT_DELTA = dis.readInt();
					
			        this.RT_NET_SNAPSHOT_DELTA = dis.readInt();
					
			        this.RT_EOD_MANUAL_DELTA = dis.readInt();
					
					this.RT_END_LEVEL_SNAPSHOT = readString(dis);
					
			        this.RT_EOD_OPENING_PHYSICAL = dis.readInt();
					
			        this.RT_EOD_BULK_RECEIPTS = dis.readInt();
					
			        this.RT_END_GROSS_SNAPSHOT = dis.readInt();
					
			        this.RT_AVAILABLE_QUANTITY = dis.readInt();
					
			        this.RT_END_NET_SNAPSHOT = dis.readInt();
					
			        this.RT_EOD_BULK_DISPOSALS = dis.readInt();
					
					this.RT_END_SNAPSHOT_DATE = readDate(dis);
					
			        this.RT_EOD_TRANSFERS_IN = dis.readInt();
					
			        this.RT_EOD_RACK_RECEIPTS = dis.readInt();
					
			        this.RT_EOD_TRANSFERS_OUT = dis.readInt();
					
			        this.RT_EOD_RACK_DISPOSALS = dis.readInt();
					
					this.LAST_USER_NAME = readString(dis);
					
					this.LAST_MODIFIED = readDate(dis);
					
			        this.RT_EOD_BOOK_INVENTORY = dis.readInt();
					
					this.USER_DLL = readString(dis);
					
					this.USER_ROUTINE = readString(dis);
					
			        this.ROOF_CORRECTION_TYPE = dis.readInt();
					
					this.ROOF_TAKE_OFF_LEVEL = readString(dis);
					
					this.ROOF_SUPPORT_LEVEL = readString(dis);
					
			        this.ROOF_REFERENCE_DENSITY = dis.readDouble();
					
			        this.ROOF_ABOVE_ADJUSTMENT = dis.readDouble();
					
			        this.RT_EOD_MANUAL_CLOSING_ENABLE = dis.readInt();
					
			        this.ROOF_BELOW_ADJUSTMENT = dis.readDouble();
					
					this.RT_EOD_MANUAL_LEVEL = readString(dis);
					
			        this.STRAPPING_INVERTED = dis.readInt();
					
			        this.RT_EOD_MANUAL_GROSS_QUANTITY = dis.readInt();
					
			        this.RT_EOD_MANUAL_NET_QUANTITY = dis.readInt();
					
			        this.RT_EOD_RACK_FRAC_DISPOSALS = dis.readInt();
					
			        this.RT_EOD_RACK_FRAC_RECEIPTS = dis.readInt();
					
					this.DDE_HIGH_ALARM_DSN = readString(dis);
					
					this.DDE_HIGH_ALARM_ITEM = readString(dis);
					
					this.DDE_HIGH_HIGH_ALARM_DSN = readString(dis);
					
					this.DDE_HIGH_HIGH_ALARM_ITEM = readString(dis);
					
					this.DDE_LOW_ALARM_DSN = readString(dis);
					
					this.DDE_LOW_ALARM_ITEM = readString(dis);
					
					this.DDE_LOW_LOW_ALARM_DSN = readString(dis);
					
					this.DDE_LOW_LOW_ALARM_ITEM = readString(dis);
					
					this.DDE_CUTOFF_ALARM_DSN = readString(dis);
					
					this.DDE_CUTOFF_ALARM_ITEM = readString(dis);
					
					this.DDE_STATUS_DSN = readString(dis);
					
					this.DDE_STATUS_ITEM = readString(dis);
					
			        this.RT_AUTO_PRESSURE = dis.readDouble();
					
			        this.RT_AUTO_MASS = dis.readInt();
					
			        this.MANUAL_PRESSURE = dis.readDouble();
					
			        this.MANUAL_MASS = dis.readInt();
					
			        this.RT_PRESSURE = dis.readDouble();
					
			        this.RT_MASS = dis.readInt();
					
			        this.AUTO_PRESSURE_ENABLE = dis.readInt();
					
			        this.AUTO_MASS_ENABLE = dis.readInt();
					
			        this.DOWNLOAD_ENABLE = dis.readInt();
					
			        this.DOWNLOAD_LEVEL_ENABLE = dis.readInt();
					
			        this.DOWNLOAD_QUANTITY_ENABLE = dis.readInt();
					
			        this.DOWNLOAD_TEMPERATURE_ENABLE = dis.readInt();
					
			        this.DOWNLOAD_PRESSURE_ENABLE = dis.readInt();
					
			        this.DOWNLOAD_MASS_ENABLE = dis.readInt();
					
			        this.RT_USER_QUEUE_ENABLE = dis.readInt();
					
			        this.RT_USER_CONTEXT_VALUE = dis.readInt();
					
			        this.RT_FRAC_GROSS_SNAPSHOT_DELTA = dis.readInt();
					
			        this.RT_FRAC_NET_SNAPSHOT_DELTA = dis.readInt();
					
			        this.RT_FRAC_EOD_MANUAL_DELTA = dis.readInt();
					
			        this.RT_TEMPERATURE_SNAPSHOT = dis.readDouble();
					
			        this.RT_DENSITY_SNAPSHOT = dis.readDouble();
					
			        this.RT_END_TEMPERATURE_SNAPSHOT = dis.readDouble();
					
			        this.RT_END_DENSITY_SNAPSHOT = dis.readDouble();
					
			        this.RT_FRAC_EOD_TRANSFERS_IN = dis.readInt();
					
			        this.RT_FRAC_EOD_TRANSFERS_OUT = dis.readInt();
					
			        this.MANUAL_QUANTITY_ENABLE = dis.readInt();
					
			        this.MANUAL_BSW_QUANTITY = dis.readInt();
					
			        this.EOM_MANUAL_QUANTITY = dis.readInt();
					
			        this.MANUAL_GROSS_QUANTITY = dis.readInt();
					
			        this.MANUAL_LOW_LOW_QUANTITY = dis.readInt();
					
			        this.MANUAL_LOW_QUANTITY = dis.readInt();
					
			        this.MANUAL_GENERAL_QUANTITY = dis.readInt();
					
			        this.MANUAL_CUTOFF_QUANTITY = dis.readInt();
					
			        this.MANUAL_HIGH_QUANTITY = dis.readInt();
					
			        this.MANUAL_HIGH_HIGH_QUANTITY = dis.readInt();
					
			        this.MANUAL_OBSERVED_DENSITY = dis.readDouble();
					
			        this.RT_OBSERVED_DENSITY = dis.readDouble();
					
			        this.RT_OBS_DENSITY_SNAPSHOT = dis.readDouble();
					
			        this.RT_END_OBS_DENSITY_SNAPSHOT = dis.readDouble();
					
			        this.AUTO_BSW_LEVEL_ENABLE = dis.readInt();
					
			        this.AUTO_BSW_QUANTITY_ENABLE = dis.readInt();
					
					this.RT_AUTO_BSW_LEVEL = readString(dis);
					
			        this.RT_AUTO_BSW_QUANTITY = dis.readInt();
					
					this.RT_BSW_LEVEL = readString(dis);
					
					this.DDE_BSW_LEVEL_DSN = readString(dis);
					
					this.DDE_BSW_LEVEL_ITEM = readString(dis);
					
					this.DDE_BSW_QUANTITY_DSN = readString(dis);
					
					this.DDE_BSW_QUANTITY_ITEM = readString(dis);
					
			        this.DOWNLOAD_DENSITY_ENABLE = dis.readInt();
					
			        this.RT_EOD_ADD_MANUAL_DELTA = dis.readInt();
					
			        this.RT_EOD_ADD_BULK_RECEIPTS = dis.readInt();
					
			        this.RT_EOD_ADD_RACK_RECEIPTS = dis.readInt();
					
			        this.RT_EOD_ADD_TRANSFERS_IN = dis.readInt();
					
			        this.RT_EOD_ADD_BULK_DISPOSALS = dis.readInt();
					
			        this.RT_EOD_ADD_RACK_DISPOSALS = dis.readInt();
					
			        this.RT_EOD_ADD_TRANSFERS_OUT = dis.readInt();
					
			        this.RT_EOD_ADD_BOOK_INVENTORY = dis.readInt();
					
			        this.RT_IN_SERVICE = dis.readInt();
					
			        this.VIRTUAL_TANK = dis.readInt();
					
					this.DDE_IN_SERVICE_ITEM = readString(dis);
					
					this.TANK_GROUP = readString(dis);
					
					this.DDE_IN_SERVICE_DSN = readString(dis);
					
			        this.RT_CUTOFF_QUANTITY = dis.readInt();
					
			        this.AUTO_NET_QUANTITY_ENABLE = dis.readInt();
					
					this.DDE_NET_QUANTITY_ITEM = readString(dis);
					
			        this.RT_AUTO_NET_QUANTITY = dis.readInt();
					
					this.DDE_NET_QUANTITY_DSN = readString(dis);
					
			        this.MANUAL_NET_QUANTITY_ENABLE = dis.readInt();
					
			        this.MANUAL_NET_QUANTITY = dis.readInt();
					
					this.HIGH_BSW_SETPOINT = readString(dis);
					
			        this.HIGH_BSW_QUANTITY = dis.readInt();
					
					this.DDE_BSW_HIGH_ALARM_DSN = readString(dis);
					
					this.DDE_BSW_HIGH_ALARM_ITEM = readString(dis);
					
			        this.RT_EOD_BULK_FRAC_DISPOSALS = dis.readInt();
					
			        this.RT_EOD_BULK_FRAC_RECEIPTS = dis.readInt();
					
					this.RT_EOD_OPEN_BSW_LEVEL = readString(dis);
					
			        this.RT_EOD_OPEN_DENSITY = dis.readDouble();
					
			        this.RT_EOD_OPEN_TEMPERATURE = dis.readDouble();
					
			        this.RT_EOD_OPEN_BSW_QUANTITY = dis.readInt();
					
					this.RT_EOD_OPEN_LEVEL = readString(dis);
					
			        this.RT_EOD_OPEN_OBSERVED_DENSITY = dis.readDouble();
					
			        this.RT_EOD_OPEN_PHYS_GROSS_QTY = dis.readInt();
					
					this.PREV_EOD_LEVEL = readString(dis);
					
			        this.PREV_EOD_GROSS_QUANTITY = dis.readInt();
					
			        this.PREV_EOD_TEMPERATURE = dis.readDouble();
					
			        this.PREV_EOD_DENSITY = dis.readDouble();
					
			        this.PREV_EOD_BSW_QUANTITY = dis.readInt();
					
					this.PREV_EOD_BSW_LEVEL = readString(dis);
					
			        this.RT_PREV_EOD_NET_QUANTITY = dis.readInt();
					
			        this.PREV_EOD_COE = dis.readDouble();
					
			        this.RT_PREV_EOD_BSW_QUANTITY = dis.readInt();
					
			        this.PREV_EOD_QUANTITY = dis.readInt();
					
			        this.OPENING_COE = dis.readDouble();
					
			        this.RT_TOV = dis.readInt();
					
			        this.RT_GOV = dis.readInt();
					
			        this.RT_GSV = dis.readInt();
					
			        this.RT_TCV = dis.readInt();
					
			        this.RT_SHELL_CORRECTION_FACTOR = dis.readDouble();
					
			        this.RT_FLOATING_ROOF_ADJUSTMENT = dis.readInt();
					
			        this.RT_CTL = dis.readDouble();
					
			        this.SUSPENDED_BSW_PERCENT = dis.readDouble();
					
			        this.MANUAL_STRAP_TYPE = dis.readInt();
					
			        this.ROOF_TAKE_OFF_STRAP_TYPE = dis.readInt();
					
			        this.ROOF_SUPPORT_STRAP_TYPE = dis.readInt();
					
			        this.HIGH_BSW_STRAP_TYPE = dis.readInt();
					
			        this.BASE_SEDIMENT_WATER_STRAP_TYPE = dis.readInt();
					
					this.GAUGER_INITIALS = readString(dis);
					
					this.GAUGE_TIMESTAMP = readDate(dis);
					
			        this.LEVEL_UNITS = dis.readInt();
					
			        this.SHELL_BASE_TEMPERATURE = dis.readDouble();
					
			        this.SHELL_MATERIAL_TYPE = dis.readInt();
					
			        this.MANUAL_AMBIENT_TEMPERATURE = dis.readDouble();
					
			        this.INSULATED = dis.readInt();
					
			        this.LINE_SEGMENT_NSV = dis.readInt();
					
			        this.RT_CALCULATION_POINT = dis.readInt();
					
			        this.ROOF_TAKE_OFF_TOV = dis.readInt();
					
			        this.RT_NSV = dis.readInt();
					
			        this.RT_GSW = dis.readInt();
					
			        this.RT_NSW = dis.readInt();
					
			        this.RT_WCF = dis.readDouble();
					
			        this.LINE_SEGMENT_NSW = dis.readInt();
					
			        this.ROOF_WEIGHT = dis.readDouble();
					
			        this.VOL_IN_ALARM = dis.readInt();
					
			        this.INACTIVITY_QUANTITY = dis.readInt();
					
			        this.INACTIVITY_ALARM_STATE = dis.readInt();
					
			        this.USER_LEVEL = dis.readInt();
					
					this.SCHED_PROD_CHANGE_DATE_TIME = readDate(dis);
					
			        this.SCHED_PROD_CHANGE_TIMEOUT = dis.readInt();
					
					this.SCHED_PROD_CHANGE_EMAIL = readString(dis);
					
			        this.SETPOINT_QUANTITY_ENABLE = dis.readInt();
					
			        this.MANUAL_MEASURED_DENSITY = dis.readDouble();
					
			        this.WEIGHT_IN_AIR = dis.readInt();
					
			        this.TOPS_MONITORING_ACTIVE = dis.readInt();
					
			        this.SHAPE = dis.readInt();
					
			        this.ACTUAL_FLOW_RATE_PERIOD = dis.readInt();
					
			        this.CALCULATED_FLOW_RATE_PERIOD = dis.readInt();
					
			        this.FLOW_RATE_CLAMPING_PERIOD = dis.readInt();
					
					this.RT_CLAMPING_PERIOD_START = readDate(dis);
					
			        this.VAPOR_CORRECTION_METHOD = dis.readInt();
					
			        this.VAPOR_TEMPERATURE = dis.readDouble();
					
			        this.VAPOR_LIQUID_VOLUME_RATIO = dis.readDouble();
					
			        this.TARGET_LEVEL = dis.readInt();
					
			        this.ORIGINAL_STARTING_LEVEL = dis.readInt();
					
			        this.TIME_TO_TARGET_LEVEL = dis.readInt();
					
			        this.AUTO_VAPOR_TEMPERATURE_ENABLE = dis.readInt();
					
					this.DDE_PRESSURE_DSN = readString(dis);
					
					this.DDE_PRESSURE_ITEM = readString(dis);
					
					this.DDE_VAPOR_TEMPERATURE_DSN = readString(dis);
					
					this.DDE_VAPOR_TEMPERATURE_ITEM = readString(dis);
					
			        this.RT_AUTO_VAPOR_TEMPERATURE = dis.readDouble();
					
			        this.RT_VAPOR_TEMPERATURE = dis.readDouble();
					
			        this.INVENTORY_ENABLE = dis.readInt();
					
			        this.MANUAL_TO_AUTO_FOLIO_LIMIT = dis.readInt();
					
			        this.RT_MANUAL_TO_AUTO_FOLIO_COUNT = dis.readInt();
					
			        this.RT_LEVEL_ORIGIN = dis.readInt();
					
			        this.RT_TOV_ORIGIN = dis.readInt();
					
			        this.RT_TEMPERATURE_ORIGIN = dis.readInt();
					
			        this.RT_DENSITY_ORIGIN = dis.readInt();
					
			        this.RT_NSV_ORIGIN = dis.readInt();
					
			        this.RT_VAPOR_TEMPERATURE_ORIGIN = dis.readInt();
					
			        this.RT_PRESSURE_ORIGIN = dis.readInt();
					
			        this.RT_FREE_WATER_LEVEL_ORIGIN = dis.readInt();
					
			        this.RT_WATER_QUANTITY_ORIGIN = dis.readInt();
					
					this.DDE_SNAPSHOT_REQ_DSN = readString(dis);
					
					this.DDE_SNAPSHOT_REQ_ITEM = readString(dis);
					
					this.DDE_SNAPSHOT_RSP_DSN = readString(dis);
					
					this.DDE_SNAPSHOT_RSP_ITEM = readString(dis);
					
			        this.AUTO_PRODUCT_LEVEL_UNIT = dis.readInt();
					
			        this.AUTO_FREE_WATER_LEVEL_UNIT = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.TANK_CODE,dos);
					
					// String
				
						writeString(this.NAME,dos);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_OWNER_ID,dos);
					
					// Integer
				
						writeInteger(this.MAJORITY_SHAREHOLDER,dos);
					
					// String
				
						writeString(this.COMPARTMENT_CONTAINER_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.RT_GROSS_QUANTITY);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_CONTAINER_TYPE,dos);
					
					// int
				
		            	dos.writeInt(this.TERMINAL_PRODUCT_NUMBER);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.RT_NET_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.ENABLE);
					
					// Integer
				
						writeInteger(this.SCHED_PROD_CHANGE_PRODUCT,dos);
					
					// double
				
		            	dos.writeDouble(this.RVP);
					
					// double
				
		            	dos.writeDouble(this.OXYGEN);
					
					// double
				
		            	dos.writeDouble(this.RT_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.RT_DENSITY);
					
					// int
				
		            	dos.writeInt(this.SHELL_CAPACITY);
					
					// int
				
		            	dos.writeInt(this.WORK_CAPACITY);
					
					// String
				
						writeString(this.DEPTH,dos);
					
					// String
				
						writeString(this.LOW_LOW_SETPOINT,dos);
					
					// String
				
						writeString(this.LOW_SETPOINT,dos);
					
					// String
				
						writeString(this.GENERAL_SETPOINT,dos);
					
					// String
				
						writeString(this.CUTOFF_SETPOINT,dos);
					
					// int
				
		            	dos.writeInt(this.AUTO_ENABLE);
					
					// String
				
						writeString(this.HIGH_SETPOINT,dos);
					
					// String
				
						writeString(this.HIGH_HIGH_SETPOINT,dos);
					
					// int
				
		            	dos.writeInt(this.DEADBAND);
					
					// int
				
		            	dos.writeInt(this.AUTO_LEVEL_ENABLE);
					
					// String
				
						writeString(this.DDE_LEVEL_DSN,dos);
					
					// int
				
		            	dos.writeInt(this.AUTO_DENSITY_ENABLE);
					
					// int
				
		            	dos.writeInt(this.AUTO_TEMPERATURE_ENABLE);
					
					// String
				
						writeString(this.DDE_LEVEL_ITEM,dos);
					
					// int
				
		            	dos.writeInt(this.AUTO_QUANTITY_ENABLE);
					
					// String
				
						writeString(this.DDE_DENSITY_DSN,dos);
					
					// int
				
		            	dos.writeInt(this.ACTIVITY_STATUS);
					
					// String
				
						writeString(this.DDE_DENSITY_ITEM,dos);
					
					// String
				
						writeString(this.DDE_TEMPERATURE_DSN,dos);
					
					// int
				
		            	dos.writeInt(this.RECEIPT_INDICATOR);
					
					// String
				
						writeString(this.DDE_TEMPERATURE_ITEM,dos);
					
					// java.util.Date
				
						writeDate(this.LAST_RECEIPT_DATE,dos);
					
					// String
				
						writeString(this.DDE_QUANTITY_DSN,dos);
					
					// String
				
						writeString(this.DDE_QUANTITY_ITEM,dos);
					
					// int
				
		            	dos.writeInt(this.SEND_TO_HOST_AT_EOD);
					
					// String
				
						writeString(this.MANUAL_LEVEL,dos);
					
					// String
				
						writeString(this.RT_AUTO_LEVEL,dos);
					
					// String
				
						writeString(this.EOM_MANUAL_LEVEL,dos);
					
					// int
				
		            	dos.writeInt(this.RT_EOM_GROSS_QUANTITY);
					
					// double
				
		            	dos.writeDouble(this.RT_AUTO_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.EOM_MANUAL_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.EOM_MANUAL_DENSITY);
					
					// int
				
		            	dos.writeInt(this.EOM_MANUAL_BSW_QUANTITY);
					
					// String
				
						writeString(this.EOM_MANUAL_BSW_LEVEL,dos);
					
					// double
				
		            	dos.writeDouble(this.MANUAL_TEMPERATURE);
					
					// int
				
		            	dos.writeInt(this.RT_EOM_NET_QUANTITY);
					
					// double
				
		            	dos.writeDouble(this.EOM_MANUAL_COE);
					
					// int
				
		            	dos.writeInt(this.RT_EOM_BSW_QUANTITY);
					
					// java.util.Date
				
						writeDate(this.MANUAL_DATE,dos);
					
					// String
				
						writeString(this.BASE_SEDIMENT_WATER_LEVEL,dos);
					
					// double
				
		            	dos.writeDouble(this.MANUAL_DENSITY);
					
					// int
				
		            	dos.writeInt(this.RT_BSW_QUANTITY);
					
					// double
				
		            	dos.writeDouble(this.MANUAL_SPECIFIC_GRAVITY);
					
					// int
				
		            	dos.writeInt(this.PIPE_FILL);
					
					// double
				
		            	dos.writeDouble(this.MANUAL_COEFFICIENT_EXPANSION);
					
					// int
				
		            	dos.writeInt(this.PROTOCOL_TYPE);
					
					// double
				
		            	dos.writeDouble(this.RT_AUTO_TEMPERATURE);
					
					// String
				
						writeString(this.PORT_NAME,dos);
					
					// int
				
		            	dos.writeInt(this.RT_AUTO_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.ADDRESS);
					
					// String
				
						writeString(this.REMARKS,dos);
					
					// int
				
		            	dos.writeInt(this.FAST_SCAN);
					
					// String
				
						writeString(this.RT_LEVEL,dos);
					
					// int
				
		            	dos.writeInt(this.RT_METER_COUNT);
					
					// int
				
		            	dos.writeInt(this.RT_GROSS_SNAPSHOT);
					
					// int
				
		            	dos.writeInt(this.RT_SNAPSHOT_ACTIVE);
					
					// String
				
						writeString(this.RT_LEVEL_SNAPSHOT,dos);
					
					// int
				
		            	dos.writeInt(this.RT_NET_SNAPSHOT);
					
					// java.util.Date
				
						writeDate(this.RT_SNAPSHOT_DATE,dos);
					
					// int
				
		            	dos.writeInt(this.RT_GROSS_SNAPSHOT_DELTA);
					
					// int
				
		            	dos.writeInt(this.RT_NET_SNAPSHOT_DELTA);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_MANUAL_DELTA);
					
					// String
				
						writeString(this.RT_END_LEVEL_SNAPSHOT,dos);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_OPENING_PHYSICAL);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_BULK_RECEIPTS);
					
					// int
				
		            	dos.writeInt(this.RT_END_GROSS_SNAPSHOT);
					
					// int
				
		            	dos.writeInt(this.RT_AVAILABLE_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.RT_END_NET_SNAPSHOT);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_BULK_DISPOSALS);
					
					// java.util.Date
				
						writeDate(this.RT_END_SNAPSHOT_DATE,dos);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_TRANSFERS_IN);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_RACK_RECEIPTS);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_TRANSFERS_OUT);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_RACK_DISPOSALS);
					
					// String
				
						writeString(this.LAST_USER_NAME,dos);
					
					// java.util.Date
				
						writeDate(this.LAST_MODIFIED,dos);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_BOOK_INVENTORY);
					
					// String
				
						writeString(this.USER_DLL,dos);
					
					// String
				
						writeString(this.USER_ROUTINE,dos);
					
					// int
				
		            	dos.writeInt(this.ROOF_CORRECTION_TYPE);
					
					// String
				
						writeString(this.ROOF_TAKE_OFF_LEVEL,dos);
					
					// String
				
						writeString(this.ROOF_SUPPORT_LEVEL,dos);
					
					// double
				
		            	dos.writeDouble(this.ROOF_REFERENCE_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.ROOF_ABOVE_ADJUSTMENT);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_MANUAL_CLOSING_ENABLE);
					
					// double
				
		            	dos.writeDouble(this.ROOF_BELOW_ADJUSTMENT);
					
					// String
				
						writeString(this.RT_EOD_MANUAL_LEVEL,dos);
					
					// int
				
		            	dos.writeInt(this.STRAPPING_INVERTED);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_MANUAL_GROSS_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_MANUAL_NET_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_RACK_FRAC_DISPOSALS);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_RACK_FRAC_RECEIPTS);
					
					// String
				
						writeString(this.DDE_HIGH_ALARM_DSN,dos);
					
					// String
				
						writeString(this.DDE_HIGH_ALARM_ITEM,dos);
					
					// String
				
						writeString(this.DDE_HIGH_HIGH_ALARM_DSN,dos);
					
					// String
				
						writeString(this.DDE_HIGH_HIGH_ALARM_ITEM,dos);
					
					// String
				
						writeString(this.DDE_LOW_ALARM_DSN,dos);
					
					// String
				
						writeString(this.DDE_LOW_ALARM_ITEM,dos);
					
					// String
				
						writeString(this.DDE_LOW_LOW_ALARM_DSN,dos);
					
					// String
				
						writeString(this.DDE_LOW_LOW_ALARM_ITEM,dos);
					
					// String
				
						writeString(this.DDE_CUTOFF_ALARM_DSN,dos);
					
					// String
				
						writeString(this.DDE_CUTOFF_ALARM_ITEM,dos);
					
					// String
				
						writeString(this.DDE_STATUS_DSN,dos);
					
					// String
				
						writeString(this.DDE_STATUS_ITEM,dos);
					
					// double
				
		            	dos.writeDouble(this.RT_AUTO_PRESSURE);
					
					// int
				
		            	dos.writeInt(this.RT_AUTO_MASS);
					
					// double
				
		            	dos.writeDouble(this.MANUAL_PRESSURE);
					
					// int
				
		            	dos.writeInt(this.MANUAL_MASS);
					
					// double
				
		            	dos.writeDouble(this.RT_PRESSURE);
					
					// int
				
		            	dos.writeInt(this.RT_MASS);
					
					// int
				
		            	dos.writeInt(this.AUTO_PRESSURE_ENABLE);
					
					// int
				
		            	dos.writeInt(this.AUTO_MASS_ENABLE);
					
					// int
				
		            	dos.writeInt(this.DOWNLOAD_ENABLE);
					
					// int
				
		            	dos.writeInt(this.DOWNLOAD_LEVEL_ENABLE);
					
					// int
				
		            	dos.writeInt(this.DOWNLOAD_QUANTITY_ENABLE);
					
					// int
				
		            	dos.writeInt(this.DOWNLOAD_TEMPERATURE_ENABLE);
					
					// int
				
		            	dos.writeInt(this.DOWNLOAD_PRESSURE_ENABLE);
					
					// int
				
		            	dos.writeInt(this.DOWNLOAD_MASS_ENABLE);
					
					// int
				
		            	dos.writeInt(this.RT_USER_QUEUE_ENABLE);
					
					// int
				
		            	dos.writeInt(this.RT_USER_CONTEXT_VALUE);
					
					// int
				
		            	dos.writeInt(this.RT_FRAC_GROSS_SNAPSHOT_DELTA);
					
					// int
				
		            	dos.writeInt(this.RT_FRAC_NET_SNAPSHOT_DELTA);
					
					// int
				
		            	dos.writeInt(this.RT_FRAC_EOD_MANUAL_DELTA);
					
					// double
				
		            	dos.writeDouble(this.RT_TEMPERATURE_SNAPSHOT);
					
					// double
				
		            	dos.writeDouble(this.RT_DENSITY_SNAPSHOT);
					
					// double
				
		            	dos.writeDouble(this.RT_END_TEMPERATURE_SNAPSHOT);
					
					// double
				
		            	dos.writeDouble(this.RT_END_DENSITY_SNAPSHOT);
					
					// int
				
		            	dos.writeInt(this.RT_FRAC_EOD_TRANSFERS_IN);
					
					// int
				
		            	dos.writeInt(this.RT_FRAC_EOD_TRANSFERS_OUT);
					
					// int
				
		            	dos.writeInt(this.MANUAL_QUANTITY_ENABLE);
					
					// int
				
		            	dos.writeInt(this.MANUAL_BSW_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.EOM_MANUAL_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.MANUAL_GROSS_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.MANUAL_LOW_LOW_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.MANUAL_LOW_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.MANUAL_GENERAL_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.MANUAL_CUTOFF_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.MANUAL_HIGH_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.MANUAL_HIGH_HIGH_QUANTITY);
					
					// double
				
		            	dos.writeDouble(this.MANUAL_OBSERVED_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.RT_OBSERVED_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.RT_OBS_DENSITY_SNAPSHOT);
					
					// double
				
		            	dos.writeDouble(this.RT_END_OBS_DENSITY_SNAPSHOT);
					
					// int
				
		            	dos.writeInt(this.AUTO_BSW_LEVEL_ENABLE);
					
					// int
				
		            	dos.writeInt(this.AUTO_BSW_QUANTITY_ENABLE);
					
					// String
				
						writeString(this.RT_AUTO_BSW_LEVEL,dos);
					
					// int
				
		            	dos.writeInt(this.RT_AUTO_BSW_QUANTITY);
					
					// String
				
						writeString(this.RT_BSW_LEVEL,dos);
					
					// String
				
						writeString(this.DDE_BSW_LEVEL_DSN,dos);
					
					// String
				
						writeString(this.DDE_BSW_LEVEL_ITEM,dos);
					
					// String
				
						writeString(this.DDE_BSW_QUANTITY_DSN,dos);
					
					// String
				
						writeString(this.DDE_BSW_QUANTITY_ITEM,dos);
					
					// int
				
		            	dos.writeInt(this.DOWNLOAD_DENSITY_ENABLE);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_ADD_MANUAL_DELTA);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_ADD_BULK_RECEIPTS);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_ADD_RACK_RECEIPTS);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_ADD_TRANSFERS_IN);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_ADD_BULK_DISPOSALS);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_ADD_RACK_DISPOSALS);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_ADD_TRANSFERS_OUT);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_ADD_BOOK_INVENTORY);
					
					// int
				
		            	dos.writeInt(this.RT_IN_SERVICE);
					
					// int
				
		            	dos.writeInt(this.VIRTUAL_TANK);
					
					// String
				
						writeString(this.DDE_IN_SERVICE_ITEM,dos);
					
					// String
				
						writeString(this.TANK_GROUP,dos);
					
					// String
				
						writeString(this.DDE_IN_SERVICE_DSN,dos);
					
					// int
				
		            	dos.writeInt(this.RT_CUTOFF_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.AUTO_NET_QUANTITY_ENABLE);
					
					// String
				
						writeString(this.DDE_NET_QUANTITY_ITEM,dos);
					
					// int
				
		            	dos.writeInt(this.RT_AUTO_NET_QUANTITY);
					
					// String
				
						writeString(this.DDE_NET_QUANTITY_DSN,dos);
					
					// int
				
		            	dos.writeInt(this.MANUAL_NET_QUANTITY_ENABLE);
					
					// int
				
		            	dos.writeInt(this.MANUAL_NET_QUANTITY);
					
					// String
				
						writeString(this.HIGH_BSW_SETPOINT,dos);
					
					// int
				
		            	dos.writeInt(this.HIGH_BSW_QUANTITY);
					
					// String
				
						writeString(this.DDE_BSW_HIGH_ALARM_DSN,dos);
					
					// String
				
						writeString(this.DDE_BSW_HIGH_ALARM_ITEM,dos);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_BULK_FRAC_DISPOSALS);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_BULK_FRAC_RECEIPTS);
					
					// String
				
						writeString(this.RT_EOD_OPEN_BSW_LEVEL,dos);
					
					// double
				
		            	dos.writeDouble(this.RT_EOD_OPEN_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.RT_EOD_OPEN_TEMPERATURE);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_OPEN_BSW_QUANTITY);
					
					// String
				
						writeString(this.RT_EOD_OPEN_LEVEL,dos);
					
					// double
				
		            	dos.writeDouble(this.RT_EOD_OPEN_OBSERVED_DENSITY);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_OPEN_PHYS_GROSS_QTY);
					
					// String
				
						writeString(this.PREV_EOD_LEVEL,dos);
					
					// int
				
		            	dos.writeInt(this.PREV_EOD_GROSS_QUANTITY);
					
					// double
				
		            	dos.writeDouble(this.PREV_EOD_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.PREV_EOD_DENSITY);
					
					// int
				
		            	dos.writeInt(this.PREV_EOD_BSW_QUANTITY);
					
					// String
				
						writeString(this.PREV_EOD_BSW_LEVEL,dos);
					
					// int
				
		            	dos.writeInt(this.RT_PREV_EOD_NET_QUANTITY);
					
					// double
				
		            	dos.writeDouble(this.PREV_EOD_COE);
					
					// int
				
		            	dos.writeInt(this.RT_PREV_EOD_BSW_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.PREV_EOD_QUANTITY);
					
					// double
				
		            	dos.writeDouble(this.OPENING_COE);
					
					// int
				
		            	dos.writeInt(this.RT_TOV);
					
					// int
				
		            	dos.writeInt(this.RT_GOV);
					
					// int
				
		            	dos.writeInt(this.RT_GSV);
					
					// int
				
		            	dos.writeInt(this.RT_TCV);
					
					// double
				
		            	dos.writeDouble(this.RT_SHELL_CORRECTION_FACTOR);
					
					// int
				
		            	dos.writeInt(this.RT_FLOATING_ROOF_ADJUSTMENT);
					
					// double
				
		            	dos.writeDouble(this.RT_CTL);
					
					// double
				
		            	dos.writeDouble(this.SUSPENDED_BSW_PERCENT);
					
					// int
				
		            	dos.writeInt(this.MANUAL_STRAP_TYPE);
					
					// int
				
		            	dos.writeInt(this.ROOF_TAKE_OFF_STRAP_TYPE);
					
					// int
				
		            	dos.writeInt(this.ROOF_SUPPORT_STRAP_TYPE);
					
					// int
				
		            	dos.writeInt(this.HIGH_BSW_STRAP_TYPE);
					
					// int
				
		            	dos.writeInt(this.BASE_SEDIMENT_WATER_STRAP_TYPE);
					
					// String
				
						writeString(this.GAUGER_INITIALS,dos);
					
					// java.util.Date
				
						writeDate(this.GAUGE_TIMESTAMP,dos);
					
					// int
				
		            	dos.writeInt(this.LEVEL_UNITS);
					
					// double
				
		            	dos.writeDouble(this.SHELL_BASE_TEMPERATURE);
					
					// int
				
		            	dos.writeInt(this.SHELL_MATERIAL_TYPE);
					
					// double
				
		            	dos.writeDouble(this.MANUAL_AMBIENT_TEMPERATURE);
					
					// int
				
		            	dos.writeInt(this.INSULATED);
					
					// int
				
		            	dos.writeInt(this.LINE_SEGMENT_NSV);
					
					// int
				
		            	dos.writeInt(this.RT_CALCULATION_POINT);
					
					// int
				
		            	dos.writeInt(this.ROOF_TAKE_OFF_TOV);
					
					// int
				
		            	dos.writeInt(this.RT_NSV);
					
					// int
				
		            	dos.writeInt(this.RT_GSW);
					
					// int
				
		            	dos.writeInt(this.RT_NSW);
					
					// double
				
		            	dos.writeDouble(this.RT_WCF);
					
					// int
				
		            	dos.writeInt(this.LINE_SEGMENT_NSW);
					
					// double
				
		            	dos.writeDouble(this.ROOF_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.VOL_IN_ALARM);
					
					// int
				
		            	dos.writeInt(this.INACTIVITY_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.INACTIVITY_ALARM_STATE);
					
					// int
				
		            	dos.writeInt(this.USER_LEVEL);
					
					// java.util.Date
				
						writeDate(this.SCHED_PROD_CHANGE_DATE_TIME,dos);
					
					// int
				
		            	dos.writeInt(this.SCHED_PROD_CHANGE_TIMEOUT);
					
					// String
				
						writeString(this.SCHED_PROD_CHANGE_EMAIL,dos);
					
					// int
				
		            	dos.writeInt(this.SETPOINT_QUANTITY_ENABLE);
					
					// double
				
		            	dos.writeDouble(this.MANUAL_MEASURED_DENSITY);
					
					// int
				
		            	dos.writeInt(this.WEIGHT_IN_AIR);
					
					// int
				
		            	dos.writeInt(this.TOPS_MONITORING_ACTIVE);
					
					// int
				
		            	dos.writeInt(this.SHAPE);
					
					// int
				
		            	dos.writeInt(this.ACTUAL_FLOW_RATE_PERIOD);
					
					// int
				
		            	dos.writeInt(this.CALCULATED_FLOW_RATE_PERIOD);
					
					// int
				
		            	dos.writeInt(this.FLOW_RATE_CLAMPING_PERIOD);
					
					// java.util.Date
				
						writeDate(this.RT_CLAMPING_PERIOD_START,dos);
					
					// int
				
		            	dos.writeInt(this.VAPOR_CORRECTION_METHOD);
					
					// double
				
		            	dos.writeDouble(this.VAPOR_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.VAPOR_LIQUID_VOLUME_RATIO);
					
					// int
				
		            	dos.writeInt(this.TARGET_LEVEL);
					
					// int
				
		            	dos.writeInt(this.ORIGINAL_STARTING_LEVEL);
					
					// int
				
		            	dos.writeInt(this.TIME_TO_TARGET_LEVEL);
					
					// int
				
		            	dos.writeInt(this.AUTO_VAPOR_TEMPERATURE_ENABLE);
					
					// String
				
						writeString(this.DDE_PRESSURE_DSN,dos);
					
					// String
				
						writeString(this.DDE_PRESSURE_ITEM,dos);
					
					// String
				
						writeString(this.DDE_VAPOR_TEMPERATURE_DSN,dos);
					
					// String
				
						writeString(this.DDE_VAPOR_TEMPERATURE_ITEM,dos);
					
					// double
				
		            	dos.writeDouble(this.RT_AUTO_VAPOR_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.RT_VAPOR_TEMPERATURE);
					
					// int
				
		            	dos.writeInt(this.INVENTORY_ENABLE);
					
					// int
				
		            	dos.writeInt(this.MANUAL_TO_AUTO_FOLIO_LIMIT);
					
					// int
				
		            	dos.writeInt(this.RT_MANUAL_TO_AUTO_FOLIO_COUNT);
					
					// int
				
		            	dos.writeInt(this.RT_LEVEL_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.RT_TOV_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.RT_TEMPERATURE_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.RT_DENSITY_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.RT_NSV_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.RT_VAPOR_TEMPERATURE_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.RT_PRESSURE_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.RT_FREE_WATER_LEVEL_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.RT_WATER_QUANTITY_ORIGIN);
					
					// String
				
						writeString(this.DDE_SNAPSHOT_REQ_DSN,dos);
					
					// String
				
						writeString(this.DDE_SNAPSHOT_REQ_ITEM,dos);
					
					// String
				
						writeString(this.DDE_SNAPSHOT_RSP_DSN,dos);
					
					// String
				
						writeString(this.DDE_SNAPSHOT_RSP_ITEM,dos);
					
					// int
				
		            	dos.writeInt(this.AUTO_PRODUCT_LEVEL_UNIT);
					
					// int
				
		            	dos.writeInt(this.AUTO_FREE_WATER_LEVEL_UNIT);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.TANK_CODE,dos);
					
					// String
				
						writeString(this.NAME,dos);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_OWNER_ID,dos);
					
					// Integer
				
						writeInteger(this.MAJORITY_SHAREHOLDER,dos);
					
					// String
				
						writeString(this.COMPARTMENT_CONTAINER_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.RT_GROSS_QUANTITY);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_CONTAINER_TYPE,dos);
					
					// int
				
		            	dos.writeInt(this.TERMINAL_PRODUCT_NUMBER);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.RT_NET_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.ENABLE);
					
					// Integer
				
						writeInteger(this.SCHED_PROD_CHANGE_PRODUCT,dos);
					
					// double
				
		            	dos.writeDouble(this.RVP);
					
					// double
				
		            	dos.writeDouble(this.OXYGEN);
					
					// double
				
		            	dos.writeDouble(this.RT_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.RT_DENSITY);
					
					// int
				
		            	dos.writeInt(this.SHELL_CAPACITY);
					
					// int
				
		            	dos.writeInt(this.WORK_CAPACITY);
					
					// String
				
						writeString(this.DEPTH,dos);
					
					// String
				
						writeString(this.LOW_LOW_SETPOINT,dos);
					
					// String
				
						writeString(this.LOW_SETPOINT,dos);
					
					// String
				
						writeString(this.GENERAL_SETPOINT,dos);
					
					// String
				
						writeString(this.CUTOFF_SETPOINT,dos);
					
					// int
				
		            	dos.writeInt(this.AUTO_ENABLE);
					
					// String
				
						writeString(this.HIGH_SETPOINT,dos);
					
					// String
				
						writeString(this.HIGH_HIGH_SETPOINT,dos);
					
					// int
				
		            	dos.writeInt(this.DEADBAND);
					
					// int
				
		            	dos.writeInt(this.AUTO_LEVEL_ENABLE);
					
					// String
				
						writeString(this.DDE_LEVEL_DSN,dos);
					
					// int
				
		            	dos.writeInt(this.AUTO_DENSITY_ENABLE);
					
					// int
				
		            	dos.writeInt(this.AUTO_TEMPERATURE_ENABLE);
					
					// String
				
						writeString(this.DDE_LEVEL_ITEM,dos);
					
					// int
				
		            	dos.writeInt(this.AUTO_QUANTITY_ENABLE);
					
					// String
				
						writeString(this.DDE_DENSITY_DSN,dos);
					
					// int
				
		            	dos.writeInt(this.ACTIVITY_STATUS);
					
					// String
				
						writeString(this.DDE_DENSITY_ITEM,dos);
					
					// String
				
						writeString(this.DDE_TEMPERATURE_DSN,dos);
					
					// int
				
		            	dos.writeInt(this.RECEIPT_INDICATOR);
					
					// String
				
						writeString(this.DDE_TEMPERATURE_ITEM,dos);
					
					// java.util.Date
				
						writeDate(this.LAST_RECEIPT_DATE,dos);
					
					// String
				
						writeString(this.DDE_QUANTITY_DSN,dos);
					
					// String
				
						writeString(this.DDE_QUANTITY_ITEM,dos);
					
					// int
				
		            	dos.writeInt(this.SEND_TO_HOST_AT_EOD);
					
					// String
				
						writeString(this.MANUAL_LEVEL,dos);
					
					// String
				
						writeString(this.RT_AUTO_LEVEL,dos);
					
					// String
				
						writeString(this.EOM_MANUAL_LEVEL,dos);
					
					// int
				
		            	dos.writeInt(this.RT_EOM_GROSS_QUANTITY);
					
					// double
				
		            	dos.writeDouble(this.RT_AUTO_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.EOM_MANUAL_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.EOM_MANUAL_DENSITY);
					
					// int
				
		            	dos.writeInt(this.EOM_MANUAL_BSW_QUANTITY);
					
					// String
				
						writeString(this.EOM_MANUAL_BSW_LEVEL,dos);
					
					// double
				
		            	dos.writeDouble(this.MANUAL_TEMPERATURE);
					
					// int
				
		            	dos.writeInt(this.RT_EOM_NET_QUANTITY);
					
					// double
				
		            	dos.writeDouble(this.EOM_MANUAL_COE);
					
					// int
				
		            	dos.writeInt(this.RT_EOM_BSW_QUANTITY);
					
					// java.util.Date
				
						writeDate(this.MANUAL_DATE,dos);
					
					// String
				
						writeString(this.BASE_SEDIMENT_WATER_LEVEL,dos);
					
					// double
				
		            	dos.writeDouble(this.MANUAL_DENSITY);
					
					// int
				
		            	dos.writeInt(this.RT_BSW_QUANTITY);
					
					// double
				
		            	dos.writeDouble(this.MANUAL_SPECIFIC_GRAVITY);
					
					// int
				
		            	dos.writeInt(this.PIPE_FILL);
					
					// double
				
		            	dos.writeDouble(this.MANUAL_COEFFICIENT_EXPANSION);
					
					// int
				
		            	dos.writeInt(this.PROTOCOL_TYPE);
					
					// double
				
		            	dos.writeDouble(this.RT_AUTO_TEMPERATURE);
					
					// String
				
						writeString(this.PORT_NAME,dos);
					
					// int
				
		            	dos.writeInt(this.RT_AUTO_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.ADDRESS);
					
					// String
				
						writeString(this.REMARKS,dos);
					
					// int
				
		            	dos.writeInt(this.FAST_SCAN);
					
					// String
				
						writeString(this.RT_LEVEL,dos);
					
					// int
				
		            	dos.writeInt(this.RT_METER_COUNT);
					
					// int
				
		            	dos.writeInt(this.RT_GROSS_SNAPSHOT);
					
					// int
				
		            	dos.writeInt(this.RT_SNAPSHOT_ACTIVE);
					
					// String
				
						writeString(this.RT_LEVEL_SNAPSHOT,dos);
					
					// int
				
		            	dos.writeInt(this.RT_NET_SNAPSHOT);
					
					// java.util.Date
				
						writeDate(this.RT_SNAPSHOT_DATE,dos);
					
					// int
				
		            	dos.writeInt(this.RT_GROSS_SNAPSHOT_DELTA);
					
					// int
				
		            	dos.writeInt(this.RT_NET_SNAPSHOT_DELTA);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_MANUAL_DELTA);
					
					// String
				
						writeString(this.RT_END_LEVEL_SNAPSHOT,dos);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_OPENING_PHYSICAL);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_BULK_RECEIPTS);
					
					// int
				
		            	dos.writeInt(this.RT_END_GROSS_SNAPSHOT);
					
					// int
				
		            	dos.writeInt(this.RT_AVAILABLE_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.RT_END_NET_SNAPSHOT);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_BULK_DISPOSALS);
					
					// java.util.Date
				
						writeDate(this.RT_END_SNAPSHOT_DATE,dos);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_TRANSFERS_IN);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_RACK_RECEIPTS);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_TRANSFERS_OUT);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_RACK_DISPOSALS);
					
					// String
				
						writeString(this.LAST_USER_NAME,dos);
					
					// java.util.Date
				
						writeDate(this.LAST_MODIFIED,dos);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_BOOK_INVENTORY);
					
					// String
				
						writeString(this.USER_DLL,dos);
					
					// String
				
						writeString(this.USER_ROUTINE,dos);
					
					// int
				
		            	dos.writeInt(this.ROOF_CORRECTION_TYPE);
					
					// String
				
						writeString(this.ROOF_TAKE_OFF_LEVEL,dos);
					
					// String
				
						writeString(this.ROOF_SUPPORT_LEVEL,dos);
					
					// double
				
		            	dos.writeDouble(this.ROOF_REFERENCE_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.ROOF_ABOVE_ADJUSTMENT);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_MANUAL_CLOSING_ENABLE);
					
					// double
				
		            	dos.writeDouble(this.ROOF_BELOW_ADJUSTMENT);
					
					// String
				
						writeString(this.RT_EOD_MANUAL_LEVEL,dos);
					
					// int
				
		            	dos.writeInt(this.STRAPPING_INVERTED);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_MANUAL_GROSS_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_MANUAL_NET_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_RACK_FRAC_DISPOSALS);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_RACK_FRAC_RECEIPTS);
					
					// String
				
						writeString(this.DDE_HIGH_ALARM_DSN,dos);
					
					// String
				
						writeString(this.DDE_HIGH_ALARM_ITEM,dos);
					
					// String
				
						writeString(this.DDE_HIGH_HIGH_ALARM_DSN,dos);
					
					// String
				
						writeString(this.DDE_HIGH_HIGH_ALARM_ITEM,dos);
					
					// String
				
						writeString(this.DDE_LOW_ALARM_DSN,dos);
					
					// String
				
						writeString(this.DDE_LOW_ALARM_ITEM,dos);
					
					// String
				
						writeString(this.DDE_LOW_LOW_ALARM_DSN,dos);
					
					// String
				
						writeString(this.DDE_LOW_LOW_ALARM_ITEM,dos);
					
					// String
				
						writeString(this.DDE_CUTOFF_ALARM_DSN,dos);
					
					// String
				
						writeString(this.DDE_CUTOFF_ALARM_ITEM,dos);
					
					// String
				
						writeString(this.DDE_STATUS_DSN,dos);
					
					// String
				
						writeString(this.DDE_STATUS_ITEM,dos);
					
					// double
				
		            	dos.writeDouble(this.RT_AUTO_PRESSURE);
					
					// int
				
		            	dos.writeInt(this.RT_AUTO_MASS);
					
					// double
				
		            	dos.writeDouble(this.MANUAL_PRESSURE);
					
					// int
				
		            	dos.writeInt(this.MANUAL_MASS);
					
					// double
				
		            	dos.writeDouble(this.RT_PRESSURE);
					
					// int
				
		            	dos.writeInt(this.RT_MASS);
					
					// int
				
		            	dos.writeInt(this.AUTO_PRESSURE_ENABLE);
					
					// int
				
		            	dos.writeInt(this.AUTO_MASS_ENABLE);
					
					// int
				
		            	dos.writeInt(this.DOWNLOAD_ENABLE);
					
					// int
				
		            	dos.writeInt(this.DOWNLOAD_LEVEL_ENABLE);
					
					// int
				
		            	dos.writeInt(this.DOWNLOAD_QUANTITY_ENABLE);
					
					// int
				
		            	dos.writeInt(this.DOWNLOAD_TEMPERATURE_ENABLE);
					
					// int
				
		            	dos.writeInt(this.DOWNLOAD_PRESSURE_ENABLE);
					
					// int
				
		            	dos.writeInt(this.DOWNLOAD_MASS_ENABLE);
					
					// int
				
		            	dos.writeInt(this.RT_USER_QUEUE_ENABLE);
					
					// int
				
		            	dos.writeInt(this.RT_USER_CONTEXT_VALUE);
					
					// int
				
		            	dos.writeInt(this.RT_FRAC_GROSS_SNAPSHOT_DELTA);
					
					// int
				
		            	dos.writeInt(this.RT_FRAC_NET_SNAPSHOT_DELTA);
					
					// int
				
		            	dos.writeInt(this.RT_FRAC_EOD_MANUAL_DELTA);
					
					// double
				
		            	dos.writeDouble(this.RT_TEMPERATURE_SNAPSHOT);
					
					// double
				
		            	dos.writeDouble(this.RT_DENSITY_SNAPSHOT);
					
					// double
				
		            	dos.writeDouble(this.RT_END_TEMPERATURE_SNAPSHOT);
					
					// double
				
		            	dos.writeDouble(this.RT_END_DENSITY_SNAPSHOT);
					
					// int
				
		            	dos.writeInt(this.RT_FRAC_EOD_TRANSFERS_IN);
					
					// int
				
		            	dos.writeInt(this.RT_FRAC_EOD_TRANSFERS_OUT);
					
					// int
				
		            	dos.writeInt(this.MANUAL_QUANTITY_ENABLE);
					
					// int
				
		            	dos.writeInt(this.MANUAL_BSW_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.EOM_MANUAL_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.MANUAL_GROSS_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.MANUAL_LOW_LOW_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.MANUAL_LOW_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.MANUAL_GENERAL_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.MANUAL_CUTOFF_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.MANUAL_HIGH_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.MANUAL_HIGH_HIGH_QUANTITY);
					
					// double
				
		            	dos.writeDouble(this.MANUAL_OBSERVED_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.RT_OBSERVED_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.RT_OBS_DENSITY_SNAPSHOT);
					
					// double
				
		            	dos.writeDouble(this.RT_END_OBS_DENSITY_SNAPSHOT);
					
					// int
				
		            	dos.writeInt(this.AUTO_BSW_LEVEL_ENABLE);
					
					// int
				
		            	dos.writeInt(this.AUTO_BSW_QUANTITY_ENABLE);
					
					// String
				
						writeString(this.RT_AUTO_BSW_LEVEL,dos);
					
					// int
				
		            	dos.writeInt(this.RT_AUTO_BSW_QUANTITY);
					
					// String
				
						writeString(this.RT_BSW_LEVEL,dos);
					
					// String
				
						writeString(this.DDE_BSW_LEVEL_DSN,dos);
					
					// String
				
						writeString(this.DDE_BSW_LEVEL_ITEM,dos);
					
					// String
				
						writeString(this.DDE_BSW_QUANTITY_DSN,dos);
					
					// String
				
						writeString(this.DDE_BSW_QUANTITY_ITEM,dos);
					
					// int
				
		            	dos.writeInt(this.DOWNLOAD_DENSITY_ENABLE);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_ADD_MANUAL_DELTA);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_ADD_BULK_RECEIPTS);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_ADD_RACK_RECEIPTS);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_ADD_TRANSFERS_IN);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_ADD_BULK_DISPOSALS);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_ADD_RACK_DISPOSALS);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_ADD_TRANSFERS_OUT);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_ADD_BOOK_INVENTORY);
					
					// int
				
		            	dos.writeInt(this.RT_IN_SERVICE);
					
					// int
				
		            	dos.writeInt(this.VIRTUAL_TANK);
					
					// String
				
						writeString(this.DDE_IN_SERVICE_ITEM,dos);
					
					// String
				
						writeString(this.TANK_GROUP,dos);
					
					// String
				
						writeString(this.DDE_IN_SERVICE_DSN,dos);
					
					// int
				
		            	dos.writeInt(this.RT_CUTOFF_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.AUTO_NET_QUANTITY_ENABLE);
					
					// String
				
						writeString(this.DDE_NET_QUANTITY_ITEM,dos);
					
					// int
				
		            	dos.writeInt(this.RT_AUTO_NET_QUANTITY);
					
					// String
				
						writeString(this.DDE_NET_QUANTITY_DSN,dos);
					
					// int
				
		            	dos.writeInt(this.MANUAL_NET_QUANTITY_ENABLE);
					
					// int
				
		            	dos.writeInt(this.MANUAL_NET_QUANTITY);
					
					// String
				
						writeString(this.HIGH_BSW_SETPOINT,dos);
					
					// int
				
		            	dos.writeInt(this.HIGH_BSW_QUANTITY);
					
					// String
				
						writeString(this.DDE_BSW_HIGH_ALARM_DSN,dos);
					
					// String
				
						writeString(this.DDE_BSW_HIGH_ALARM_ITEM,dos);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_BULK_FRAC_DISPOSALS);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_BULK_FRAC_RECEIPTS);
					
					// String
				
						writeString(this.RT_EOD_OPEN_BSW_LEVEL,dos);
					
					// double
				
		            	dos.writeDouble(this.RT_EOD_OPEN_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.RT_EOD_OPEN_TEMPERATURE);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_OPEN_BSW_QUANTITY);
					
					// String
				
						writeString(this.RT_EOD_OPEN_LEVEL,dos);
					
					// double
				
		            	dos.writeDouble(this.RT_EOD_OPEN_OBSERVED_DENSITY);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_OPEN_PHYS_GROSS_QTY);
					
					// String
				
						writeString(this.PREV_EOD_LEVEL,dos);
					
					// int
				
		            	dos.writeInt(this.PREV_EOD_GROSS_QUANTITY);
					
					// double
				
		            	dos.writeDouble(this.PREV_EOD_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.PREV_EOD_DENSITY);
					
					// int
				
		            	dos.writeInt(this.PREV_EOD_BSW_QUANTITY);
					
					// String
				
						writeString(this.PREV_EOD_BSW_LEVEL,dos);
					
					// int
				
		            	dos.writeInt(this.RT_PREV_EOD_NET_QUANTITY);
					
					// double
				
		            	dos.writeDouble(this.PREV_EOD_COE);
					
					// int
				
		            	dos.writeInt(this.RT_PREV_EOD_BSW_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.PREV_EOD_QUANTITY);
					
					// double
				
		            	dos.writeDouble(this.OPENING_COE);
					
					// int
				
		            	dos.writeInt(this.RT_TOV);
					
					// int
				
		            	dos.writeInt(this.RT_GOV);
					
					// int
				
		            	dos.writeInt(this.RT_GSV);
					
					// int
				
		            	dos.writeInt(this.RT_TCV);
					
					// double
				
		            	dos.writeDouble(this.RT_SHELL_CORRECTION_FACTOR);
					
					// int
				
		            	dos.writeInt(this.RT_FLOATING_ROOF_ADJUSTMENT);
					
					// double
				
		            	dos.writeDouble(this.RT_CTL);
					
					// double
				
		            	dos.writeDouble(this.SUSPENDED_BSW_PERCENT);
					
					// int
				
		            	dos.writeInt(this.MANUAL_STRAP_TYPE);
					
					// int
				
		            	dos.writeInt(this.ROOF_TAKE_OFF_STRAP_TYPE);
					
					// int
				
		            	dos.writeInt(this.ROOF_SUPPORT_STRAP_TYPE);
					
					// int
				
		            	dos.writeInt(this.HIGH_BSW_STRAP_TYPE);
					
					// int
				
		            	dos.writeInt(this.BASE_SEDIMENT_WATER_STRAP_TYPE);
					
					// String
				
						writeString(this.GAUGER_INITIALS,dos);
					
					// java.util.Date
				
						writeDate(this.GAUGE_TIMESTAMP,dos);
					
					// int
				
		            	dos.writeInt(this.LEVEL_UNITS);
					
					// double
				
		            	dos.writeDouble(this.SHELL_BASE_TEMPERATURE);
					
					// int
				
		            	dos.writeInt(this.SHELL_MATERIAL_TYPE);
					
					// double
				
		            	dos.writeDouble(this.MANUAL_AMBIENT_TEMPERATURE);
					
					// int
				
		            	dos.writeInt(this.INSULATED);
					
					// int
				
		            	dos.writeInt(this.LINE_SEGMENT_NSV);
					
					// int
				
		            	dos.writeInt(this.RT_CALCULATION_POINT);
					
					// int
				
		            	dos.writeInt(this.ROOF_TAKE_OFF_TOV);
					
					// int
				
		            	dos.writeInt(this.RT_NSV);
					
					// int
				
		            	dos.writeInt(this.RT_GSW);
					
					// int
				
		            	dos.writeInt(this.RT_NSW);
					
					// double
				
		            	dos.writeDouble(this.RT_WCF);
					
					// int
				
		            	dos.writeInt(this.LINE_SEGMENT_NSW);
					
					// double
				
		            	dos.writeDouble(this.ROOF_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.VOL_IN_ALARM);
					
					// int
				
		            	dos.writeInt(this.INACTIVITY_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.INACTIVITY_ALARM_STATE);
					
					// int
				
		            	dos.writeInt(this.USER_LEVEL);
					
					// java.util.Date
				
						writeDate(this.SCHED_PROD_CHANGE_DATE_TIME,dos);
					
					// int
				
		            	dos.writeInt(this.SCHED_PROD_CHANGE_TIMEOUT);
					
					// String
				
						writeString(this.SCHED_PROD_CHANGE_EMAIL,dos);
					
					// int
				
		            	dos.writeInt(this.SETPOINT_QUANTITY_ENABLE);
					
					// double
				
		            	dos.writeDouble(this.MANUAL_MEASURED_DENSITY);
					
					// int
				
		            	dos.writeInt(this.WEIGHT_IN_AIR);
					
					// int
				
		            	dos.writeInt(this.TOPS_MONITORING_ACTIVE);
					
					// int
				
		            	dos.writeInt(this.SHAPE);
					
					// int
				
		            	dos.writeInt(this.ACTUAL_FLOW_RATE_PERIOD);
					
					// int
				
		            	dos.writeInt(this.CALCULATED_FLOW_RATE_PERIOD);
					
					// int
				
		            	dos.writeInt(this.FLOW_RATE_CLAMPING_PERIOD);
					
					// java.util.Date
				
						writeDate(this.RT_CLAMPING_PERIOD_START,dos);
					
					// int
				
		            	dos.writeInt(this.VAPOR_CORRECTION_METHOD);
					
					// double
				
		            	dos.writeDouble(this.VAPOR_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.VAPOR_LIQUID_VOLUME_RATIO);
					
					// int
				
		            	dos.writeInt(this.TARGET_LEVEL);
					
					// int
				
		            	dos.writeInt(this.ORIGINAL_STARTING_LEVEL);
					
					// int
				
		            	dos.writeInt(this.TIME_TO_TARGET_LEVEL);
					
					// int
				
		            	dos.writeInt(this.AUTO_VAPOR_TEMPERATURE_ENABLE);
					
					// String
				
						writeString(this.DDE_PRESSURE_DSN,dos);
					
					// String
				
						writeString(this.DDE_PRESSURE_ITEM,dos);
					
					// String
				
						writeString(this.DDE_VAPOR_TEMPERATURE_DSN,dos);
					
					// String
				
						writeString(this.DDE_VAPOR_TEMPERATURE_ITEM,dos);
					
					// double
				
		            	dos.writeDouble(this.RT_AUTO_VAPOR_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.RT_VAPOR_TEMPERATURE);
					
					// int
				
		            	dos.writeInt(this.INVENTORY_ENABLE);
					
					// int
				
		            	dos.writeInt(this.MANUAL_TO_AUTO_FOLIO_LIMIT);
					
					// int
				
		            	dos.writeInt(this.RT_MANUAL_TO_AUTO_FOLIO_COUNT);
					
					// int
				
		            	dos.writeInt(this.RT_LEVEL_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.RT_TOV_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.RT_TEMPERATURE_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.RT_DENSITY_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.RT_NSV_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.RT_VAPOR_TEMPERATURE_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.RT_PRESSURE_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.RT_FREE_WATER_LEVEL_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.RT_WATER_QUANTITY_ORIGIN);
					
					// String
				
						writeString(this.DDE_SNAPSHOT_REQ_DSN,dos);
					
					// String
				
						writeString(this.DDE_SNAPSHOT_REQ_ITEM,dos);
					
					// String
				
						writeString(this.DDE_SNAPSHOT_RSP_DSN,dos);
					
					// String
				
						writeString(this.DDE_SNAPSHOT_RSP_ITEM,dos);
					
					// int
				
		            	dos.writeInt(this.AUTO_PRODUCT_LEVEL_UNIT);
					
					// int
				
		            	dos.writeInt(this.AUTO_FREE_WATER_LEVEL_UNIT);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("TANK_CODE="+TANK_CODE);
		sb.append(",NAME="+NAME);
		sb.append(",COMPARTMENT_OWNER_ID="+String.valueOf(COMPARTMENT_OWNER_ID));
		sb.append(",MAJORITY_SHAREHOLDER="+String.valueOf(MAJORITY_SHAREHOLDER));
		sb.append(",COMPARTMENT_CONTAINER_CODE="+COMPARTMENT_CONTAINER_CODE);
		sb.append(",RT_GROSS_QUANTITY="+String.valueOf(RT_GROSS_QUANTITY));
		sb.append(",COMPARTMENT_CONTAINER_TYPE="+String.valueOf(COMPARTMENT_CONTAINER_TYPE));
		sb.append(",TERMINAL_PRODUCT_NUMBER="+String.valueOf(TERMINAL_PRODUCT_NUMBER));
		sb.append(",COMPARTMENT_NUMBER="+String.valueOf(COMPARTMENT_NUMBER));
		sb.append(",RT_NET_QUANTITY="+String.valueOf(RT_NET_QUANTITY));
		sb.append(",ENABLE="+String.valueOf(ENABLE));
		sb.append(",SCHED_PROD_CHANGE_PRODUCT="+String.valueOf(SCHED_PROD_CHANGE_PRODUCT));
		sb.append(",RVP="+String.valueOf(RVP));
		sb.append(",OXYGEN="+String.valueOf(OXYGEN));
		sb.append(",RT_TEMPERATURE="+String.valueOf(RT_TEMPERATURE));
		sb.append(",RT_DENSITY="+String.valueOf(RT_DENSITY));
		sb.append(",SHELL_CAPACITY="+String.valueOf(SHELL_CAPACITY));
		sb.append(",WORK_CAPACITY="+String.valueOf(WORK_CAPACITY));
		sb.append(",DEPTH="+DEPTH);
		sb.append(",LOW_LOW_SETPOINT="+LOW_LOW_SETPOINT);
		sb.append(",LOW_SETPOINT="+LOW_SETPOINT);
		sb.append(",GENERAL_SETPOINT="+GENERAL_SETPOINT);
		sb.append(",CUTOFF_SETPOINT="+CUTOFF_SETPOINT);
		sb.append(",AUTO_ENABLE="+String.valueOf(AUTO_ENABLE));
		sb.append(",HIGH_SETPOINT="+HIGH_SETPOINT);
		sb.append(",HIGH_HIGH_SETPOINT="+HIGH_HIGH_SETPOINT);
		sb.append(",DEADBAND="+String.valueOf(DEADBAND));
		sb.append(",AUTO_LEVEL_ENABLE="+String.valueOf(AUTO_LEVEL_ENABLE));
		sb.append(",DDE_LEVEL_DSN="+DDE_LEVEL_DSN);
		sb.append(",AUTO_DENSITY_ENABLE="+String.valueOf(AUTO_DENSITY_ENABLE));
		sb.append(",AUTO_TEMPERATURE_ENABLE="+String.valueOf(AUTO_TEMPERATURE_ENABLE));
		sb.append(",DDE_LEVEL_ITEM="+DDE_LEVEL_ITEM);
		sb.append(",AUTO_QUANTITY_ENABLE="+String.valueOf(AUTO_QUANTITY_ENABLE));
		sb.append(",DDE_DENSITY_DSN="+DDE_DENSITY_DSN);
		sb.append(",ACTIVITY_STATUS="+String.valueOf(ACTIVITY_STATUS));
		sb.append(",DDE_DENSITY_ITEM="+DDE_DENSITY_ITEM);
		sb.append(",DDE_TEMPERATURE_DSN="+DDE_TEMPERATURE_DSN);
		sb.append(",RECEIPT_INDICATOR="+String.valueOf(RECEIPT_INDICATOR));
		sb.append(",DDE_TEMPERATURE_ITEM="+DDE_TEMPERATURE_ITEM);
		sb.append(",LAST_RECEIPT_DATE="+String.valueOf(LAST_RECEIPT_DATE));
		sb.append(",DDE_QUANTITY_DSN="+DDE_QUANTITY_DSN);
		sb.append(",DDE_QUANTITY_ITEM="+DDE_QUANTITY_ITEM);
		sb.append(",SEND_TO_HOST_AT_EOD="+String.valueOf(SEND_TO_HOST_AT_EOD));
		sb.append(",MANUAL_LEVEL="+MANUAL_LEVEL);
		sb.append(",RT_AUTO_LEVEL="+RT_AUTO_LEVEL);
		sb.append(",EOM_MANUAL_LEVEL="+EOM_MANUAL_LEVEL);
		sb.append(",RT_EOM_GROSS_QUANTITY="+String.valueOf(RT_EOM_GROSS_QUANTITY));
		sb.append(",RT_AUTO_DENSITY="+String.valueOf(RT_AUTO_DENSITY));
		sb.append(",EOM_MANUAL_TEMPERATURE="+String.valueOf(EOM_MANUAL_TEMPERATURE));
		sb.append(",EOM_MANUAL_DENSITY="+String.valueOf(EOM_MANUAL_DENSITY));
		sb.append(",EOM_MANUAL_BSW_QUANTITY="+String.valueOf(EOM_MANUAL_BSW_QUANTITY));
		sb.append(",EOM_MANUAL_BSW_LEVEL="+EOM_MANUAL_BSW_LEVEL);
		sb.append(",MANUAL_TEMPERATURE="+String.valueOf(MANUAL_TEMPERATURE));
		sb.append(",RT_EOM_NET_QUANTITY="+String.valueOf(RT_EOM_NET_QUANTITY));
		sb.append(",EOM_MANUAL_COE="+String.valueOf(EOM_MANUAL_COE));
		sb.append(",RT_EOM_BSW_QUANTITY="+String.valueOf(RT_EOM_BSW_QUANTITY));
		sb.append(",MANUAL_DATE="+String.valueOf(MANUAL_DATE));
		sb.append(",BASE_SEDIMENT_WATER_LEVEL="+BASE_SEDIMENT_WATER_LEVEL);
		sb.append(",MANUAL_DENSITY="+String.valueOf(MANUAL_DENSITY));
		sb.append(",RT_BSW_QUANTITY="+String.valueOf(RT_BSW_QUANTITY));
		sb.append(",MANUAL_SPECIFIC_GRAVITY="+String.valueOf(MANUAL_SPECIFIC_GRAVITY));
		sb.append(",PIPE_FILL="+String.valueOf(PIPE_FILL));
		sb.append(",MANUAL_COEFFICIENT_EXPANSION="+String.valueOf(MANUAL_COEFFICIENT_EXPANSION));
		sb.append(",PROTOCOL_TYPE="+String.valueOf(PROTOCOL_TYPE));
		sb.append(",RT_AUTO_TEMPERATURE="+String.valueOf(RT_AUTO_TEMPERATURE));
		sb.append(",PORT_NAME="+PORT_NAME);
		sb.append(",RT_AUTO_QUANTITY="+String.valueOf(RT_AUTO_QUANTITY));
		sb.append(",ADDRESS="+String.valueOf(ADDRESS));
		sb.append(",REMARKS="+REMARKS);
		sb.append(",FAST_SCAN="+String.valueOf(FAST_SCAN));
		sb.append(",RT_LEVEL="+RT_LEVEL);
		sb.append(",RT_METER_COUNT="+String.valueOf(RT_METER_COUNT));
		sb.append(",RT_GROSS_SNAPSHOT="+String.valueOf(RT_GROSS_SNAPSHOT));
		sb.append(",RT_SNAPSHOT_ACTIVE="+String.valueOf(RT_SNAPSHOT_ACTIVE));
		sb.append(",RT_LEVEL_SNAPSHOT="+RT_LEVEL_SNAPSHOT);
		sb.append(",RT_NET_SNAPSHOT="+String.valueOf(RT_NET_SNAPSHOT));
		sb.append(",RT_SNAPSHOT_DATE="+String.valueOf(RT_SNAPSHOT_DATE));
		sb.append(",RT_GROSS_SNAPSHOT_DELTA="+String.valueOf(RT_GROSS_SNAPSHOT_DELTA));
		sb.append(",RT_NET_SNAPSHOT_DELTA="+String.valueOf(RT_NET_SNAPSHOT_DELTA));
		sb.append(",RT_EOD_MANUAL_DELTA="+String.valueOf(RT_EOD_MANUAL_DELTA));
		sb.append(",RT_END_LEVEL_SNAPSHOT="+RT_END_LEVEL_SNAPSHOT);
		sb.append(",RT_EOD_OPENING_PHYSICAL="+String.valueOf(RT_EOD_OPENING_PHYSICAL));
		sb.append(",RT_EOD_BULK_RECEIPTS="+String.valueOf(RT_EOD_BULK_RECEIPTS));
		sb.append(",RT_END_GROSS_SNAPSHOT="+String.valueOf(RT_END_GROSS_SNAPSHOT));
		sb.append(",RT_AVAILABLE_QUANTITY="+String.valueOf(RT_AVAILABLE_QUANTITY));
		sb.append(",RT_END_NET_SNAPSHOT="+String.valueOf(RT_END_NET_SNAPSHOT));
		sb.append(",RT_EOD_BULK_DISPOSALS="+String.valueOf(RT_EOD_BULK_DISPOSALS));
		sb.append(",RT_END_SNAPSHOT_DATE="+String.valueOf(RT_END_SNAPSHOT_DATE));
		sb.append(",RT_EOD_TRANSFERS_IN="+String.valueOf(RT_EOD_TRANSFERS_IN));
		sb.append(",RT_EOD_RACK_RECEIPTS="+String.valueOf(RT_EOD_RACK_RECEIPTS));
		sb.append(",RT_EOD_TRANSFERS_OUT="+String.valueOf(RT_EOD_TRANSFERS_OUT));
		sb.append(",RT_EOD_RACK_DISPOSALS="+String.valueOf(RT_EOD_RACK_DISPOSALS));
		sb.append(",LAST_USER_NAME="+LAST_USER_NAME);
		sb.append(",LAST_MODIFIED="+String.valueOf(LAST_MODIFIED));
		sb.append(",RT_EOD_BOOK_INVENTORY="+String.valueOf(RT_EOD_BOOK_INVENTORY));
		sb.append(",USER_DLL="+USER_DLL);
		sb.append(",USER_ROUTINE="+USER_ROUTINE);
		sb.append(",ROOF_CORRECTION_TYPE="+String.valueOf(ROOF_CORRECTION_TYPE));
		sb.append(",ROOF_TAKE_OFF_LEVEL="+ROOF_TAKE_OFF_LEVEL);
		sb.append(",ROOF_SUPPORT_LEVEL="+ROOF_SUPPORT_LEVEL);
		sb.append(",ROOF_REFERENCE_DENSITY="+String.valueOf(ROOF_REFERENCE_DENSITY));
		sb.append(",ROOF_ABOVE_ADJUSTMENT="+String.valueOf(ROOF_ABOVE_ADJUSTMENT));
		sb.append(",RT_EOD_MANUAL_CLOSING_ENABLE="+String.valueOf(RT_EOD_MANUAL_CLOSING_ENABLE));
		sb.append(",ROOF_BELOW_ADJUSTMENT="+String.valueOf(ROOF_BELOW_ADJUSTMENT));
		sb.append(",RT_EOD_MANUAL_LEVEL="+RT_EOD_MANUAL_LEVEL);
		sb.append(",STRAPPING_INVERTED="+String.valueOf(STRAPPING_INVERTED));
		sb.append(",RT_EOD_MANUAL_GROSS_QUANTITY="+String.valueOf(RT_EOD_MANUAL_GROSS_QUANTITY));
		sb.append(",RT_EOD_MANUAL_NET_QUANTITY="+String.valueOf(RT_EOD_MANUAL_NET_QUANTITY));
		sb.append(",RT_EOD_RACK_FRAC_DISPOSALS="+String.valueOf(RT_EOD_RACK_FRAC_DISPOSALS));
		sb.append(",RT_EOD_RACK_FRAC_RECEIPTS="+String.valueOf(RT_EOD_RACK_FRAC_RECEIPTS));
		sb.append(",DDE_HIGH_ALARM_DSN="+DDE_HIGH_ALARM_DSN);
		sb.append(",DDE_HIGH_ALARM_ITEM="+DDE_HIGH_ALARM_ITEM);
		sb.append(",DDE_HIGH_HIGH_ALARM_DSN="+DDE_HIGH_HIGH_ALARM_DSN);
		sb.append(",DDE_HIGH_HIGH_ALARM_ITEM="+DDE_HIGH_HIGH_ALARM_ITEM);
		sb.append(",DDE_LOW_ALARM_DSN="+DDE_LOW_ALARM_DSN);
		sb.append(",DDE_LOW_ALARM_ITEM="+DDE_LOW_ALARM_ITEM);
		sb.append(",DDE_LOW_LOW_ALARM_DSN="+DDE_LOW_LOW_ALARM_DSN);
		sb.append(",DDE_LOW_LOW_ALARM_ITEM="+DDE_LOW_LOW_ALARM_ITEM);
		sb.append(",DDE_CUTOFF_ALARM_DSN="+DDE_CUTOFF_ALARM_DSN);
		sb.append(",DDE_CUTOFF_ALARM_ITEM="+DDE_CUTOFF_ALARM_ITEM);
		sb.append(",DDE_STATUS_DSN="+DDE_STATUS_DSN);
		sb.append(",DDE_STATUS_ITEM="+DDE_STATUS_ITEM);
		sb.append(",RT_AUTO_PRESSURE="+String.valueOf(RT_AUTO_PRESSURE));
		sb.append(",RT_AUTO_MASS="+String.valueOf(RT_AUTO_MASS));
		sb.append(",MANUAL_PRESSURE="+String.valueOf(MANUAL_PRESSURE));
		sb.append(",MANUAL_MASS="+String.valueOf(MANUAL_MASS));
		sb.append(",RT_PRESSURE="+String.valueOf(RT_PRESSURE));
		sb.append(",RT_MASS="+String.valueOf(RT_MASS));
		sb.append(",AUTO_PRESSURE_ENABLE="+String.valueOf(AUTO_PRESSURE_ENABLE));
		sb.append(",AUTO_MASS_ENABLE="+String.valueOf(AUTO_MASS_ENABLE));
		sb.append(",DOWNLOAD_ENABLE="+String.valueOf(DOWNLOAD_ENABLE));
		sb.append(",DOWNLOAD_LEVEL_ENABLE="+String.valueOf(DOWNLOAD_LEVEL_ENABLE));
		sb.append(",DOWNLOAD_QUANTITY_ENABLE="+String.valueOf(DOWNLOAD_QUANTITY_ENABLE));
		sb.append(",DOWNLOAD_TEMPERATURE_ENABLE="+String.valueOf(DOWNLOAD_TEMPERATURE_ENABLE));
		sb.append(",DOWNLOAD_PRESSURE_ENABLE="+String.valueOf(DOWNLOAD_PRESSURE_ENABLE));
		sb.append(",DOWNLOAD_MASS_ENABLE="+String.valueOf(DOWNLOAD_MASS_ENABLE));
		sb.append(",RT_USER_QUEUE_ENABLE="+String.valueOf(RT_USER_QUEUE_ENABLE));
		sb.append(",RT_USER_CONTEXT_VALUE="+String.valueOf(RT_USER_CONTEXT_VALUE));
		sb.append(",RT_FRAC_GROSS_SNAPSHOT_DELTA="+String.valueOf(RT_FRAC_GROSS_SNAPSHOT_DELTA));
		sb.append(",RT_FRAC_NET_SNAPSHOT_DELTA="+String.valueOf(RT_FRAC_NET_SNAPSHOT_DELTA));
		sb.append(",RT_FRAC_EOD_MANUAL_DELTA="+String.valueOf(RT_FRAC_EOD_MANUAL_DELTA));
		sb.append(",RT_TEMPERATURE_SNAPSHOT="+String.valueOf(RT_TEMPERATURE_SNAPSHOT));
		sb.append(",RT_DENSITY_SNAPSHOT="+String.valueOf(RT_DENSITY_SNAPSHOT));
		sb.append(",RT_END_TEMPERATURE_SNAPSHOT="+String.valueOf(RT_END_TEMPERATURE_SNAPSHOT));
		sb.append(",RT_END_DENSITY_SNAPSHOT="+String.valueOf(RT_END_DENSITY_SNAPSHOT));
		sb.append(",RT_FRAC_EOD_TRANSFERS_IN="+String.valueOf(RT_FRAC_EOD_TRANSFERS_IN));
		sb.append(",RT_FRAC_EOD_TRANSFERS_OUT="+String.valueOf(RT_FRAC_EOD_TRANSFERS_OUT));
		sb.append(",MANUAL_QUANTITY_ENABLE="+String.valueOf(MANUAL_QUANTITY_ENABLE));
		sb.append(",MANUAL_BSW_QUANTITY="+String.valueOf(MANUAL_BSW_QUANTITY));
		sb.append(",EOM_MANUAL_QUANTITY="+String.valueOf(EOM_MANUAL_QUANTITY));
		sb.append(",MANUAL_GROSS_QUANTITY="+String.valueOf(MANUAL_GROSS_QUANTITY));
		sb.append(",MANUAL_LOW_LOW_QUANTITY="+String.valueOf(MANUAL_LOW_LOW_QUANTITY));
		sb.append(",MANUAL_LOW_QUANTITY="+String.valueOf(MANUAL_LOW_QUANTITY));
		sb.append(",MANUAL_GENERAL_QUANTITY="+String.valueOf(MANUAL_GENERAL_QUANTITY));
		sb.append(",MANUAL_CUTOFF_QUANTITY="+String.valueOf(MANUAL_CUTOFF_QUANTITY));
		sb.append(",MANUAL_HIGH_QUANTITY="+String.valueOf(MANUAL_HIGH_QUANTITY));
		sb.append(",MANUAL_HIGH_HIGH_QUANTITY="+String.valueOf(MANUAL_HIGH_HIGH_QUANTITY));
		sb.append(",MANUAL_OBSERVED_DENSITY="+String.valueOf(MANUAL_OBSERVED_DENSITY));
		sb.append(",RT_OBSERVED_DENSITY="+String.valueOf(RT_OBSERVED_DENSITY));
		sb.append(",RT_OBS_DENSITY_SNAPSHOT="+String.valueOf(RT_OBS_DENSITY_SNAPSHOT));
		sb.append(",RT_END_OBS_DENSITY_SNAPSHOT="+String.valueOf(RT_END_OBS_DENSITY_SNAPSHOT));
		sb.append(",AUTO_BSW_LEVEL_ENABLE="+String.valueOf(AUTO_BSW_LEVEL_ENABLE));
		sb.append(",AUTO_BSW_QUANTITY_ENABLE="+String.valueOf(AUTO_BSW_QUANTITY_ENABLE));
		sb.append(",RT_AUTO_BSW_LEVEL="+RT_AUTO_BSW_LEVEL);
		sb.append(",RT_AUTO_BSW_QUANTITY="+String.valueOf(RT_AUTO_BSW_QUANTITY));
		sb.append(",RT_BSW_LEVEL="+RT_BSW_LEVEL);
		sb.append(",DDE_BSW_LEVEL_DSN="+DDE_BSW_LEVEL_DSN);
		sb.append(",DDE_BSW_LEVEL_ITEM="+DDE_BSW_LEVEL_ITEM);
		sb.append(",DDE_BSW_QUANTITY_DSN="+DDE_BSW_QUANTITY_DSN);
		sb.append(",DDE_BSW_QUANTITY_ITEM="+DDE_BSW_QUANTITY_ITEM);
		sb.append(",DOWNLOAD_DENSITY_ENABLE="+String.valueOf(DOWNLOAD_DENSITY_ENABLE));
		sb.append(",RT_EOD_ADD_MANUAL_DELTA="+String.valueOf(RT_EOD_ADD_MANUAL_DELTA));
		sb.append(",RT_EOD_ADD_BULK_RECEIPTS="+String.valueOf(RT_EOD_ADD_BULK_RECEIPTS));
		sb.append(",RT_EOD_ADD_RACK_RECEIPTS="+String.valueOf(RT_EOD_ADD_RACK_RECEIPTS));
		sb.append(",RT_EOD_ADD_TRANSFERS_IN="+String.valueOf(RT_EOD_ADD_TRANSFERS_IN));
		sb.append(",RT_EOD_ADD_BULK_DISPOSALS="+String.valueOf(RT_EOD_ADD_BULK_DISPOSALS));
		sb.append(",RT_EOD_ADD_RACK_DISPOSALS="+String.valueOf(RT_EOD_ADD_RACK_DISPOSALS));
		sb.append(",RT_EOD_ADD_TRANSFERS_OUT="+String.valueOf(RT_EOD_ADD_TRANSFERS_OUT));
		sb.append(",RT_EOD_ADD_BOOK_INVENTORY="+String.valueOf(RT_EOD_ADD_BOOK_INVENTORY));
		sb.append(",RT_IN_SERVICE="+String.valueOf(RT_IN_SERVICE));
		sb.append(",VIRTUAL_TANK="+String.valueOf(VIRTUAL_TANK));
		sb.append(",DDE_IN_SERVICE_ITEM="+DDE_IN_SERVICE_ITEM);
		sb.append(",TANK_GROUP="+TANK_GROUP);
		sb.append(",DDE_IN_SERVICE_DSN="+DDE_IN_SERVICE_DSN);
		sb.append(",RT_CUTOFF_QUANTITY="+String.valueOf(RT_CUTOFF_QUANTITY));
		sb.append(",AUTO_NET_QUANTITY_ENABLE="+String.valueOf(AUTO_NET_QUANTITY_ENABLE));
		sb.append(",DDE_NET_QUANTITY_ITEM="+DDE_NET_QUANTITY_ITEM);
		sb.append(",RT_AUTO_NET_QUANTITY="+String.valueOf(RT_AUTO_NET_QUANTITY));
		sb.append(",DDE_NET_QUANTITY_DSN="+DDE_NET_QUANTITY_DSN);
		sb.append(",MANUAL_NET_QUANTITY_ENABLE="+String.valueOf(MANUAL_NET_QUANTITY_ENABLE));
		sb.append(",MANUAL_NET_QUANTITY="+String.valueOf(MANUAL_NET_QUANTITY));
		sb.append(",HIGH_BSW_SETPOINT="+HIGH_BSW_SETPOINT);
		sb.append(",HIGH_BSW_QUANTITY="+String.valueOf(HIGH_BSW_QUANTITY));
		sb.append(",DDE_BSW_HIGH_ALARM_DSN="+DDE_BSW_HIGH_ALARM_DSN);
		sb.append(",DDE_BSW_HIGH_ALARM_ITEM="+DDE_BSW_HIGH_ALARM_ITEM);
		sb.append(",RT_EOD_BULK_FRAC_DISPOSALS="+String.valueOf(RT_EOD_BULK_FRAC_DISPOSALS));
		sb.append(",RT_EOD_BULK_FRAC_RECEIPTS="+String.valueOf(RT_EOD_BULK_FRAC_RECEIPTS));
		sb.append(",RT_EOD_OPEN_BSW_LEVEL="+RT_EOD_OPEN_BSW_LEVEL);
		sb.append(",RT_EOD_OPEN_DENSITY="+String.valueOf(RT_EOD_OPEN_DENSITY));
		sb.append(",RT_EOD_OPEN_TEMPERATURE="+String.valueOf(RT_EOD_OPEN_TEMPERATURE));
		sb.append(",RT_EOD_OPEN_BSW_QUANTITY="+String.valueOf(RT_EOD_OPEN_BSW_QUANTITY));
		sb.append(",RT_EOD_OPEN_LEVEL="+RT_EOD_OPEN_LEVEL);
		sb.append(",RT_EOD_OPEN_OBSERVED_DENSITY="+String.valueOf(RT_EOD_OPEN_OBSERVED_DENSITY));
		sb.append(",RT_EOD_OPEN_PHYS_GROSS_QTY="+String.valueOf(RT_EOD_OPEN_PHYS_GROSS_QTY));
		sb.append(",PREV_EOD_LEVEL="+PREV_EOD_LEVEL);
		sb.append(",PREV_EOD_GROSS_QUANTITY="+String.valueOf(PREV_EOD_GROSS_QUANTITY));
		sb.append(",PREV_EOD_TEMPERATURE="+String.valueOf(PREV_EOD_TEMPERATURE));
		sb.append(",PREV_EOD_DENSITY="+String.valueOf(PREV_EOD_DENSITY));
		sb.append(",PREV_EOD_BSW_QUANTITY="+String.valueOf(PREV_EOD_BSW_QUANTITY));
		sb.append(",PREV_EOD_BSW_LEVEL="+PREV_EOD_BSW_LEVEL);
		sb.append(",RT_PREV_EOD_NET_QUANTITY="+String.valueOf(RT_PREV_EOD_NET_QUANTITY));
		sb.append(",PREV_EOD_COE="+String.valueOf(PREV_EOD_COE));
		sb.append(",RT_PREV_EOD_BSW_QUANTITY="+String.valueOf(RT_PREV_EOD_BSW_QUANTITY));
		sb.append(",PREV_EOD_QUANTITY="+String.valueOf(PREV_EOD_QUANTITY));
		sb.append(",OPENING_COE="+String.valueOf(OPENING_COE));
		sb.append(",RT_TOV="+String.valueOf(RT_TOV));
		sb.append(",RT_GOV="+String.valueOf(RT_GOV));
		sb.append(",RT_GSV="+String.valueOf(RT_GSV));
		sb.append(",RT_TCV="+String.valueOf(RT_TCV));
		sb.append(",RT_SHELL_CORRECTION_FACTOR="+String.valueOf(RT_SHELL_CORRECTION_FACTOR));
		sb.append(",RT_FLOATING_ROOF_ADJUSTMENT="+String.valueOf(RT_FLOATING_ROOF_ADJUSTMENT));
		sb.append(",RT_CTL="+String.valueOf(RT_CTL));
		sb.append(",SUSPENDED_BSW_PERCENT="+String.valueOf(SUSPENDED_BSW_PERCENT));
		sb.append(",MANUAL_STRAP_TYPE="+String.valueOf(MANUAL_STRAP_TYPE));
		sb.append(",ROOF_TAKE_OFF_STRAP_TYPE="+String.valueOf(ROOF_TAKE_OFF_STRAP_TYPE));
		sb.append(",ROOF_SUPPORT_STRAP_TYPE="+String.valueOf(ROOF_SUPPORT_STRAP_TYPE));
		sb.append(",HIGH_BSW_STRAP_TYPE="+String.valueOf(HIGH_BSW_STRAP_TYPE));
		sb.append(",BASE_SEDIMENT_WATER_STRAP_TYPE="+String.valueOf(BASE_SEDIMENT_WATER_STRAP_TYPE));
		sb.append(",GAUGER_INITIALS="+GAUGER_INITIALS);
		sb.append(",GAUGE_TIMESTAMP="+String.valueOf(GAUGE_TIMESTAMP));
		sb.append(",LEVEL_UNITS="+String.valueOf(LEVEL_UNITS));
		sb.append(",SHELL_BASE_TEMPERATURE="+String.valueOf(SHELL_BASE_TEMPERATURE));
		sb.append(",SHELL_MATERIAL_TYPE="+String.valueOf(SHELL_MATERIAL_TYPE));
		sb.append(",MANUAL_AMBIENT_TEMPERATURE="+String.valueOf(MANUAL_AMBIENT_TEMPERATURE));
		sb.append(",INSULATED="+String.valueOf(INSULATED));
		sb.append(",LINE_SEGMENT_NSV="+String.valueOf(LINE_SEGMENT_NSV));
		sb.append(",RT_CALCULATION_POINT="+String.valueOf(RT_CALCULATION_POINT));
		sb.append(",ROOF_TAKE_OFF_TOV="+String.valueOf(ROOF_TAKE_OFF_TOV));
		sb.append(",RT_NSV="+String.valueOf(RT_NSV));
		sb.append(",RT_GSW="+String.valueOf(RT_GSW));
		sb.append(",RT_NSW="+String.valueOf(RT_NSW));
		sb.append(",RT_WCF="+String.valueOf(RT_WCF));
		sb.append(",LINE_SEGMENT_NSW="+String.valueOf(LINE_SEGMENT_NSW));
		sb.append(",ROOF_WEIGHT="+String.valueOf(ROOF_WEIGHT));
		sb.append(",VOL_IN_ALARM="+String.valueOf(VOL_IN_ALARM));
		sb.append(",INACTIVITY_QUANTITY="+String.valueOf(INACTIVITY_QUANTITY));
		sb.append(",INACTIVITY_ALARM_STATE="+String.valueOf(INACTIVITY_ALARM_STATE));
		sb.append(",USER_LEVEL="+String.valueOf(USER_LEVEL));
		sb.append(",SCHED_PROD_CHANGE_DATE_TIME="+String.valueOf(SCHED_PROD_CHANGE_DATE_TIME));
		sb.append(",SCHED_PROD_CHANGE_TIMEOUT="+String.valueOf(SCHED_PROD_CHANGE_TIMEOUT));
		sb.append(",SCHED_PROD_CHANGE_EMAIL="+SCHED_PROD_CHANGE_EMAIL);
		sb.append(",SETPOINT_QUANTITY_ENABLE="+String.valueOf(SETPOINT_QUANTITY_ENABLE));
		sb.append(",MANUAL_MEASURED_DENSITY="+String.valueOf(MANUAL_MEASURED_DENSITY));
		sb.append(",WEIGHT_IN_AIR="+String.valueOf(WEIGHT_IN_AIR));
		sb.append(",TOPS_MONITORING_ACTIVE="+String.valueOf(TOPS_MONITORING_ACTIVE));
		sb.append(",SHAPE="+String.valueOf(SHAPE));
		sb.append(",ACTUAL_FLOW_RATE_PERIOD="+String.valueOf(ACTUAL_FLOW_RATE_PERIOD));
		sb.append(",CALCULATED_FLOW_RATE_PERIOD="+String.valueOf(CALCULATED_FLOW_RATE_PERIOD));
		sb.append(",FLOW_RATE_CLAMPING_PERIOD="+String.valueOf(FLOW_RATE_CLAMPING_PERIOD));
		sb.append(",RT_CLAMPING_PERIOD_START="+String.valueOf(RT_CLAMPING_PERIOD_START));
		sb.append(",VAPOR_CORRECTION_METHOD="+String.valueOf(VAPOR_CORRECTION_METHOD));
		sb.append(",VAPOR_TEMPERATURE="+String.valueOf(VAPOR_TEMPERATURE));
		sb.append(",VAPOR_LIQUID_VOLUME_RATIO="+String.valueOf(VAPOR_LIQUID_VOLUME_RATIO));
		sb.append(",TARGET_LEVEL="+String.valueOf(TARGET_LEVEL));
		sb.append(",ORIGINAL_STARTING_LEVEL="+String.valueOf(ORIGINAL_STARTING_LEVEL));
		sb.append(",TIME_TO_TARGET_LEVEL="+String.valueOf(TIME_TO_TARGET_LEVEL));
		sb.append(",AUTO_VAPOR_TEMPERATURE_ENABLE="+String.valueOf(AUTO_VAPOR_TEMPERATURE_ENABLE));
		sb.append(",DDE_PRESSURE_DSN="+DDE_PRESSURE_DSN);
		sb.append(",DDE_PRESSURE_ITEM="+DDE_PRESSURE_ITEM);
		sb.append(",DDE_VAPOR_TEMPERATURE_DSN="+DDE_VAPOR_TEMPERATURE_DSN);
		sb.append(",DDE_VAPOR_TEMPERATURE_ITEM="+DDE_VAPOR_TEMPERATURE_ITEM);
		sb.append(",RT_AUTO_VAPOR_TEMPERATURE="+String.valueOf(RT_AUTO_VAPOR_TEMPERATURE));
		sb.append(",RT_VAPOR_TEMPERATURE="+String.valueOf(RT_VAPOR_TEMPERATURE));
		sb.append(",INVENTORY_ENABLE="+String.valueOf(INVENTORY_ENABLE));
		sb.append(",MANUAL_TO_AUTO_FOLIO_LIMIT="+String.valueOf(MANUAL_TO_AUTO_FOLIO_LIMIT));
		sb.append(",RT_MANUAL_TO_AUTO_FOLIO_COUNT="+String.valueOf(RT_MANUAL_TO_AUTO_FOLIO_COUNT));
		sb.append(",RT_LEVEL_ORIGIN="+String.valueOf(RT_LEVEL_ORIGIN));
		sb.append(",RT_TOV_ORIGIN="+String.valueOf(RT_TOV_ORIGIN));
		sb.append(",RT_TEMPERATURE_ORIGIN="+String.valueOf(RT_TEMPERATURE_ORIGIN));
		sb.append(",RT_DENSITY_ORIGIN="+String.valueOf(RT_DENSITY_ORIGIN));
		sb.append(",RT_NSV_ORIGIN="+String.valueOf(RT_NSV_ORIGIN));
		sb.append(",RT_VAPOR_TEMPERATURE_ORIGIN="+String.valueOf(RT_VAPOR_TEMPERATURE_ORIGIN));
		sb.append(",RT_PRESSURE_ORIGIN="+String.valueOf(RT_PRESSURE_ORIGIN));
		sb.append(",RT_FREE_WATER_LEVEL_ORIGIN="+String.valueOf(RT_FREE_WATER_LEVEL_ORIGIN));
		sb.append(",RT_WATER_QUANTITY_ORIGIN="+String.valueOf(RT_WATER_QUANTITY_ORIGIN));
		sb.append(",DDE_SNAPSHOT_REQ_DSN="+DDE_SNAPSHOT_REQ_DSN);
		sb.append(",DDE_SNAPSHOT_REQ_ITEM="+DDE_SNAPSHOT_REQ_ITEM);
		sb.append(",DDE_SNAPSHOT_RSP_DSN="+DDE_SNAPSHOT_RSP_DSN);
		sb.append(",DDE_SNAPSHOT_RSP_ITEM="+DDE_SNAPSHOT_RSP_ITEM);
		sb.append(",AUTO_PRODUCT_LEVEL_UNIT="+String.valueOf(AUTO_PRODUCT_LEVEL_UNIT));
		sb.append(",AUTO_FREE_WATER_LEVEL_UNIT="+String.valueOf(AUTO_FREE_WATER_LEVEL_UNIT));
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
    final static byte[] commonByteArrayLock_PGS_STAGE_DIM_TANK = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_DIM_TANK = new byte[0];

	
			    public String TANK_CODE;

				public String getTANK_CODE () {
					return this.TANK_CODE;
				}
				
			    public String NAME;

				public String getNAME () {
					return this.NAME;
				}
				
			    public Integer COMPARTMENT_OWNER_ID;

				public Integer getCOMPARTMENT_OWNER_ID () {
					return this.COMPARTMENT_OWNER_ID;
				}
				
			    public Integer MAJORITY_SHAREHOLDER;

				public Integer getMAJORITY_SHAREHOLDER () {
					return this.MAJORITY_SHAREHOLDER;
				}
				
			    public String COMPARTMENT_CONTAINER_CODE;

				public String getCOMPARTMENT_CONTAINER_CODE () {
					return this.COMPARTMENT_CONTAINER_CODE;
				}
				
			    public int RT_GROSS_QUANTITY;

				public int getRT_GROSS_QUANTITY () {
					return this.RT_GROSS_QUANTITY;
				}
				
			    public Integer COMPARTMENT_CONTAINER_TYPE;

				public Integer getCOMPARTMENT_CONTAINER_TYPE () {
					return this.COMPARTMENT_CONTAINER_TYPE;
				}
				
			    public int TERMINAL_PRODUCT_NUMBER;

				public int getTERMINAL_PRODUCT_NUMBER () {
					return this.TERMINAL_PRODUCT_NUMBER;
				}
				
			    public Integer COMPARTMENT_NUMBER;

				public Integer getCOMPARTMENT_NUMBER () {
					return this.COMPARTMENT_NUMBER;
				}
				
			    public int RT_NET_QUANTITY;

				public int getRT_NET_QUANTITY () {
					return this.RT_NET_QUANTITY;
				}
				
			    public int ENABLE;

				public int getENABLE () {
					return this.ENABLE;
				}
				
			    public Integer SCHED_PROD_CHANGE_PRODUCT;

				public Integer getSCHED_PROD_CHANGE_PRODUCT () {
					return this.SCHED_PROD_CHANGE_PRODUCT;
				}
				
			    public double RVP;

				public double getRVP () {
					return this.RVP;
				}
				
			    public double OXYGEN;

				public double getOXYGEN () {
					return this.OXYGEN;
				}
				
			    public double RT_TEMPERATURE;

				public double getRT_TEMPERATURE () {
					return this.RT_TEMPERATURE;
				}
				
			    public double RT_DENSITY;

				public double getRT_DENSITY () {
					return this.RT_DENSITY;
				}
				
			    public int SHELL_CAPACITY;

				public int getSHELL_CAPACITY () {
					return this.SHELL_CAPACITY;
				}
				
			    public int WORK_CAPACITY;

				public int getWORK_CAPACITY () {
					return this.WORK_CAPACITY;
				}
				
			    public String DEPTH;

				public String getDEPTH () {
					return this.DEPTH;
				}
				
			    public String LOW_LOW_SETPOINT;

				public String getLOW_LOW_SETPOINT () {
					return this.LOW_LOW_SETPOINT;
				}
				
			    public String LOW_SETPOINT;

				public String getLOW_SETPOINT () {
					return this.LOW_SETPOINT;
				}
				
			    public String GENERAL_SETPOINT;

				public String getGENERAL_SETPOINT () {
					return this.GENERAL_SETPOINT;
				}
				
			    public String CUTOFF_SETPOINT;

				public String getCUTOFF_SETPOINT () {
					return this.CUTOFF_SETPOINT;
				}
				
			    public int AUTO_ENABLE;

				public int getAUTO_ENABLE () {
					return this.AUTO_ENABLE;
				}
				
			    public String HIGH_SETPOINT;

				public String getHIGH_SETPOINT () {
					return this.HIGH_SETPOINT;
				}
				
			    public String HIGH_HIGH_SETPOINT;

				public String getHIGH_HIGH_SETPOINT () {
					return this.HIGH_HIGH_SETPOINT;
				}
				
			    public int DEADBAND;

				public int getDEADBAND () {
					return this.DEADBAND;
				}
				
			    public int AUTO_LEVEL_ENABLE;

				public int getAUTO_LEVEL_ENABLE () {
					return this.AUTO_LEVEL_ENABLE;
				}
				
			    public String DDE_LEVEL_DSN;

				public String getDDE_LEVEL_DSN () {
					return this.DDE_LEVEL_DSN;
				}
				
			    public int AUTO_DENSITY_ENABLE;

				public int getAUTO_DENSITY_ENABLE () {
					return this.AUTO_DENSITY_ENABLE;
				}
				
			    public int AUTO_TEMPERATURE_ENABLE;

				public int getAUTO_TEMPERATURE_ENABLE () {
					return this.AUTO_TEMPERATURE_ENABLE;
				}
				
			    public String DDE_LEVEL_ITEM;

				public String getDDE_LEVEL_ITEM () {
					return this.DDE_LEVEL_ITEM;
				}
				
			    public int AUTO_QUANTITY_ENABLE;

				public int getAUTO_QUANTITY_ENABLE () {
					return this.AUTO_QUANTITY_ENABLE;
				}
				
			    public String DDE_DENSITY_DSN;

				public String getDDE_DENSITY_DSN () {
					return this.DDE_DENSITY_DSN;
				}
				
			    public int ACTIVITY_STATUS;

				public int getACTIVITY_STATUS () {
					return this.ACTIVITY_STATUS;
				}
				
			    public String DDE_DENSITY_ITEM;

				public String getDDE_DENSITY_ITEM () {
					return this.DDE_DENSITY_ITEM;
				}
				
			    public String DDE_TEMPERATURE_DSN;

				public String getDDE_TEMPERATURE_DSN () {
					return this.DDE_TEMPERATURE_DSN;
				}
				
			    public int RECEIPT_INDICATOR;

				public int getRECEIPT_INDICATOR () {
					return this.RECEIPT_INDICATOR;
				}
				
			    public String DDE_TEMPERATURE_ITEM;

				public String getDDE_TEMPERATURE_ITEM () {
					return this.DDE_TEMPERATURE_ITEM;
				}
				
			    public java.util.Date LAST_RECEIPT_DATE;

				public java.util.Date getLAST_RECEIPT_DATE () {
					return this.LAST_RECEIPT_DATE;
				}
				
			    public String DDE_QUANTITY_DSN;

				public String getDDE_QUANTITY_DSN () {
					return this.DDE_QUANTITY_DSN;
				}
				
			    public String DDE_QUANTITY_ITEM;

				public String getDDE_QUANTITY_ITEM () {
					return this.DDE_QUANTITY_ITEM;
				}
				
			    public int SEND_TO_HOST_AT_EOD;

				public int getSEND_TO_HOST_AT_EOD () {
					return this.SEND_TO_HOST_AT_EOD;
				}
				
			    public String MANUAL_LEVEL;

				public String getMANUAL_LEVEL () {
					return this.MANUAL_LEVEL;
				}
				
			    public String RT_AUTO_LEVEL;

				public String getRT_AUTO_LEVEL () {
					return this.RT_AUTO_LEVEL;
				}
				
			    public String EOM_MANUAL_LEVEL;

				public String getEOM_MANUAL_LEVEL () {
					return this.EOM_MANUAL_LEVEL;
				}
				
			    public int RT_EOM_GROSS_QUANTITY;

				public int getRT_EOM_GROSS_QUANTITY () {
					return this.RT_EOM_GROSS_QUANTITY;
				}
				
			    public double RT_AUTO_DENSITY;

				public double getRT_AUTO_DENSITY () {
					return this.RT_AUTO_DENSITY;
				}
				
			    public double EOM_MANUAL_TEMPERATURE;

				public double getEOM_MANUAL_TEMPERATURE () {
					return this.EOM_MANUAL_TEMPERATURE;
				}
				
			    public double EOM_MANUAL_DENSITY;

				public double getEOM_MANUAL_DENSITY () {
					return this.EOM_MANUAL_DENSITY;
				}
				
			    public int EOM_MANUAL_BSW_QUANTITY;

				public int getEOM_MANUAL_BSW_QUANTITY () {
					return this.EOM_MANUAL_BSW_QUANTITY;
				}
				
			    public String EOM_MANUAL_BSW_LEVEL;

				public String getEOM_MANUAL_BSW_LEVEL () {
					return this.EOM_MANUAL_BSW_LEVEL;
				}
				
			    public double MANUAL_TEMPERATURE;

				public double getMANUAL_TEMPERATURE () {
					return this.MANUAL_TEMPERATURE;
				}
				
			    public int RT_EOM_NET_QUANTITY;

				public int getRT_EOM_NET_QUANTITY () {
					return this.RT_EOM_NET_QUANTITY;
				}
				
			    public double EOM_MANUAL_COE;

				public double getEOM_MANUAL_COE () {
					return this.EOM_MANUAL_COE;
				}
				
			    public int RT_EOM_BSW_QUANTITY;

				public int getRT_EOM_BSW_QUANTITY () {
					return this.RT_EOM_BSW_QUANTITY;
				}
				
			    public java.util.Date MANUAL_DATE;

				public java.util.Date getMANUAL_DATE () {
					return this.MANUAL_DATE;
				}
				
			    public String BASE_SEDIMENT_WATER_LEVEL;

				public String getBASE_SEDIMENT_WATER_LEVEL () {
					return this.BASE_SEDIMENT_WATER_LEVEL;
				}
				
			    public double MANUAL_DENSITY;

				public double getMANUAL_DENSITY () {
					return this.MANUAL_DENSITY;
				}
				
			    public int RT_BSW_QUANTITY;

				public int getRT_BSW_QUANTITY () {
					return this.RT_BSW_QUANTITY;
				}
				
			    public double MANUAL_SPECIFIC_GRAVITY;

				public double getMANUAL_SPECIFIC_GRAVITY () {
					return this.MANUAL_SPECIFIC_GRAVITY;
				}
				
			    public int PIPE_FILL;

				public int getPIPE_FILL () {
					return this.PIPE_FILL;
				}
				
			    public double MANUAL_COEFFICIENT_EXPANSION;

				public double getMANUAL_COEFFICIENT_EXPANSION () {
					return this.MANUAL_COEFFICIENT_EXPANSION;
				}
				
			    public int PROTOCOL_TYPE;

				public int getPROTOCOL_TYPE () {
					return this.PROTOCOL_TYPE;
				}
				
			    public double RT_AUTO_TEMPERATURE;

				public double getRT_AUTO_TEMPERATURE () {
					return this.RT_AUTO_TEMPERATURE;
				}
				
			    public String PORT_NAME;

				public String getPORT_NAME () {
					return this.PORT_NAME;
				}
				
			    public int RT_AUTO_QUANTITY;

				public int getRT_AUTO_QUANTITY () {
					return this.RT_AUTO_QUANTITY;
				}
				
			    public int ADDRESS;

				public int getADDRESS () {
					return this.ADDRESS;
				}
				
			    public String REMARKS;

				public String getREMARKS () {
					return this.REMARKS;
				}
				
			    public int FAST_SCAN;

				public int getFAST_SCAN () {
					return this.FAST_SCAN;
				}
				
			    public String RT_LEVEL;

				public String getRT_LEVEL () {
					return this.RT_LEVEL;
				}
				
			    public int RT_METER_COUNT;

				public int getRT_METER_COUNT () {
					return this.RT_METER_COUNT;
				}
				
			    public int RT_GROSS_SNAPSHOT;

				public int getRT_GROSS_SNAPSHOT () {
					return this.RT_GROSS_SNAPSHOT;
				}
				
			    public int RT_SNAPSHOT_ACTIVE;

				public int getRT_SNAPSHOT_ACTIVE () {
					return this.RT_SNAPSHOT_ACTIVE;
				}
				
			    public String RT_LEVEL_SNAPSHOT;

				public String getRT_LEVEL_SNAPSHOT () {
					return this.RT_LEVEL_SNAPSHOT;
				}
				
			    public int RT_NET_SNAPSHOT;

				public int getRT_NET_SNAPSHOT () {
					return this.RT_NET_SNAPSHOT;
				}
				
			    public java.util.Date RT_SNAPSHOT_DATE;

				public java.util.Date getRT_SNAPSHOT_DATE () {
					return this.RT_SNAPSHOT_DATE;
				}
				
			    public int RT_GROSS_SNAPSHOT_DELTA;

				public int getRT_GROSS_SNAPSHOT_DELTA () {
					return this.RT_GROSS_SNAPSHOT_DELTA;
				}
				
			    public int RT_NET_SNAPSHOT_DELTA;

				public int getRT_NET_SNAPSHOT_DELTA () {
					return this.RT_NET_SNAPSHOT_DELTA;
				}
				
			    public int RT_EOD_MANUAL_DELTA;

				public int getRT_EOD_MANUAL_DELTA () {
					return this.RT_EOD_MANUAL_DELTA;
				}
				
			    public String RT_END_LEVEL_SNAPSHOT;

				public String getRT_END_LEVEL_SNAPSHOT () {
					return this.RT_END_LEVEL_SNAPSHOT;
				}
				
			    public int RT_EOD_OPENING_PHYSICAL;

				public int getRT_EOD_OPENING_PHYSICAL () {
					return this.RT_EOD_OPENING_PHYSICAL;
				}
				
			    public int RT_EOD_BULK_RECEIPTS;

				public int getRT_EOD_BULK_RECEIPTS () {
					return this.RT_EOD_BULK_RECEIPTS;
				}
				
			    public int RT_END_GROSS_SNAPSHOT;

				public int getRT_END_GROSS_SNAPSHOT () {
					return this.RT_END_GROSS_SNAPSHOT;
				}
				
			    public int RT_AVAILABLE_QUANTITY;

				public int getRT_AVAILABLE_QUANTITY () {
					return this.RT_AVAILABLE_QUANTITY;
				}
				
			    public int RT_END_NET_SNAPSHOT;

				public int getRT_END_NET_SNAPSHOT () {
					return this.RT_END_NET_SNAPSHOT;
				}
				
			    public int RT_EOD_BULK_DISPOSALS;

				public int getRT_EOD_BULK_DISPOSALS () {
					return this.RT_EOD_BULK_DISPOSALS;
				}
				
			    public java.util.Date RT_END_SNAPSHOT_DATE;

				public java.util.Date getRT_END_SNAPSHOT_DATE () {
					return this.RT_END_SNAPSHOT_DATE;
				}
				
			    public int RT_EOD_TRANSFERS_IN;

				public int getRT_EOD_TRANSFERS_IN () {
					return this.RT_EOD_TRANSFERS_IN;
				}
				
			    public int RT_EOD_RACK_RECEIPTS;

				public int getRT_EOD_RACK_RECEIPTS () {
					return this.RT_EOD_RACK_RECEIPTS;
				}
				
			    public int RT_EOD_TRANSFERS_OUT;

				public int getRT_EOD_TRANSFERS_OUT () {
					return this.RT_EOD_TRANSFERS_OUT;
				}
				
			    public int RT_EOD_RACK_DISPOSALS;

				public int getRT_EOD_RACK_DISPOSALS () {
					return this.RT_EOD_RACK_DISPOSALS;
				}
				
			    public String LAST_USER_NAME;

				public String getLAST_USER_NAME () {
					return this.LAST_USER_NAME;
				}
				
			    public java.util.Date LAST_MODIFIED;

				public java.util.Date getLAST_MODIFIED () {
					return this.LAST_MODIFIED;
				}
				
			    public int RT_EOD_BOOK_INVENTORY;

				public int getRT_EOD_BOOK_INVENTORY () {
					return this.RT_EOD_BOOK_INVENTORY;
				}
				
			    public String USER_DLL;

				public String getUSER_DLL () {
					return this.USER_DLL;
				}
				
			    public String USER_ROUTINE;

				public String getUSER_ROUTINE () {
					return this.USER_ROUTINE;
				}
				
			    public int ROOF_CORRECTION_TYPE;

				public int getROOF_CORRECTION_TYPE () {
					return this.ROOF_CORRECTION_TYPE;
				}
				
			    public String ROOF_TAKE_OFF_LEVEL;

				public String getROOF_TAKE_OFF_LEVEL () {
					return this.ROOF_TAKE_OFF_LEVEL;
				}
				
			    public String ROOF_SUPPORT_LEVEL;

				public String getROOF_SUPPORT_LEVEL () {
					return this.ROOF_SUPPORT_LEVEL;
				}
				
			    public double ROOF_REFERENCE_DENSITY;

				public double getROOF_REFERENCE_DENSITY () {
					return this.ROOF_REFERENCE_DENSITY;
				}
				
			    public double ROOF_ABOVE_ADJUSTMENT;

				public double getROOF_ABOVE_ADJUSTMENT () {
					return this.ROOF_ABOVE_ADJUSTMENT;
				}
				
			    public int RT_EOD_MANUAL_CLOSING_ENABLE;

				public int getRT_EOD_MANUAL_CLOSING_ENABLE () {
					return this.RT_EOD_MANUAL_CLOSING_ENABLE;
				}
				
			    public double ROOF_BELOW_ADJUSTMENT;

				public double getROOF_BELOW_ADJUSTMENT () {
					return this.ROOF_BELOW_ADJUSTMENT;
				}
				
			    public String RT_EOD_MANUAL_LEVEL;

				public String getRT_EOD_MANUAL_LEVEL () {
					return this.RT_EOD_MANUAL_LEVEL;
				}
				
			    public int STRAPPING_INVERTED;

				public int getSTRAPPING_INVERTED () {
					return this.STRAPPING_INVERTED;
				}
				
			    public int RT_EOD_MANUAL_GROSS_QUANTITY;

				public int getRT_EOD_MANUAL_GROSS_QUANTITY () {
					return this.RT_EOD_MANUAL_GROSS_QUANTITY;
				}
				
			    public int RT_EOD_MANUAL_NET_QUANTITY;

				public int getRT_EOD_MANUAL_NET_QUANTITY () {
					return this.RT_EOD_MANUAL_NET_QUANTITY;
				}
				
			    public int RT_EOD_RACK_FRAC_DISPOSALS;

				public int getRT_EOD_RACK_FRAC_DISPOSALS () {
					return this.RT_EOD_RACK_FRAC_DISPOSALS;
				}
				
			    public int RT_EOD_RACK_FRAC_RECEIPTS;

				public int getRT_EOD_RACK_FRAC_RECEIPTS () {
					return this.RT_EOD_RACK_FRAC_RECEIPTS;
				}
				
			    public String DDE_HIGH_ALARM_DSN;

				public String getDDE_HIGH_ALARM_DSN () {
					return this.DDE_HIGH_ALARM_DSN;
				}
				
			    public String DDE_HIGH_ALARM_ITEM;

				public String getDDE_HIGH_ALARM_ITEM () {
					return this.DDE_HIGH_ALARM_ITEM;
				}
				
			    public String DDE_HIGH_HIGH_ALARM_DSN;

				public String getDDE_HIGH_HIGH_ALARM_DSN () {
					return this.DDE_HIGH_HIGH_ALARM_DSN;
				}
				
			    public String DDE_HIGH_HIGH_ALARM_ITEM;

				public String getDDE_HIGH_HIGH_ALARM_ITEM () {
					return this.DDE_HIGH_HIGH_ALARM_ITEM;
				}
				
			    public String DDE_LOW_ALARM_DSN;

				public String getDDE_LOW_ALARM_DSN () {
					return this.DDE_LOW_ALARM_DSN;
				}
				
			    public String DDE_LOW_ALARM_ITEM;

				public String getDDE_LOW_ALARM_ITEM () {
					return this.DDE_LOW_ALARM_ITEM;
				}
				
			    public String DDE_LOW_LOW_ALARM_DSN;

				public String getDDE_LOW_LOW_ALARM_DSN () {
					return this.DDE_LOW_LOW_ALARM_DSN;
				}
				
			    public String DDE_LOW_LOW_ALARM_ITEM;

				public String getDDE_LOW_LOW_ALARM_ITEM () {
					return this.DDE_LOW_LOW_ALARM_ITEM;
				}
				
			    public String DDE_CUTOFF_ALARM_DSN;

				public String getDDE_CUTOFF_ALARM_DSN () {
					return this.DDE_CUTOFF_ALARM_DSN;
				}
				
			    public String DDE_CUTOFF_ALARM_ITEM;

				public String getDDE_CUTOFF_ALARM_ITEM () {
					return this.DDE_CUTOFF_ALARM_ITEM;
				}
				
			    public String DDE_STATUS_DSN;

				public String getDDE_STATUS_DSN () {
					return this.DDE_STATUS_DSN;
				}
				
			    public String DDE_STATUS_ITEM;

				public String getDDE_STATUS_ITEM () {
					return this.DDE_STATUS_ITEM;
				}
				
			    public double RT_AUTO_PRESSURE;

				public double getRT_AUTO_PRESSURE () {
					return this.RT_AUTO_PRESSURE;
				}
				
			    public int RT_AUTO_MASS;

				public int getRT_AUTO_MASS () {
					return this.RT_AUTO_MASS;
				}
				
			    public double MANUAL_PRESSURE;

				public double getMANUAL_PRESSURE () {
					return this.MANUAL_PRESSURE;
				}
				
			    public int MANUAL_MASS;

				public int getMANUAL_MASS () {
					return this.MANUAL_MASS;
				}
				
			    public double RT_PRESSURE;

				public double getRT_PRESSURE () {
					return this.RT_PRESSURE;
				}
				
			    public int RT_MASS;

				public int getRT_MASS () {
					return this.RT_MASS;
				}
				
			    public int AUTO_PRESSURE_ENABLE;

				public int getAUTO_PRESSURE_ENABLE () {
					return this.AUTO_PRESSURE_ENABLE;
				}
				
			    public int AUTO_MASS_ENABLE;

				public int getAUTO_MASS_ENABLE () {
					return this.AUTO_MASS_ENABLE;
				}
				
			    public int DOWNLOAD_ENABLE;

				public int getDOWNLOAD_ENABLE () {
					return this.DOWNLOAD_ENABLE;
				}
				
			    public int DOWNLOAD_LEVEL_ENABLE;

				public int getDOWNLOAD_LEVEL_ENABLE () {
					return this.DOWNLOAD_LEVEL_ENABLE;
				}
				
			    public int DOWNLOAD_QUANTITY_ENABLE;

				public int getDOWNLOAD_QUANTITY_ENABLE () {
					return this.DOWNLOAD_QUANTITY_ENABLE;
				}
				
			    public int DOWNLOAD_TEMPERATURE_ENABLE;

				public int getDOWNLOAD_TEMPERATURE_ENABLE () {
					return this.DOWNLOAD_TEMPERATURE_ENABLE;
				}
				
			    public int DOWNLOAD_PRESSURE_ENABLE;

				public int getDOWNLOAD_PRESSURE_ENABLE () {
					return this.DOWNLOAD_PRESSURE_ENABLE;
				}
				
			    public int DOWNLOAD_MASS_ENABLE;

				public int getDOWNLOAD_MASS_ENABLE () {
					return this.DOWNLOAD_MASS_ENABLE;
				}
				
			    public int RT_USER_QUEUE_ENABLE;

				public int getRT_USER_QUEUE_ENABLE () {
					return this.RT_USER_QUEUE_ENABLE;
				}
				
			    public int RT_USER_CONTEXT_VALUE;

				public int getRT_USER_CONTEXT_VALUE () {
					return this.RT_USER_CONTEXT_VALUE;
				}
				
			    public int RT_FRAC_GROSS_SNAPSHOT_DELTA;

				public int getRT_FRAC_GROSS_SNAPSHOT_DELTA () {
					return this.RT_FRAC_GROSS_SNAPSHOT_DELTA;
				}
				
			    public int RT_FRAC_NET_SNAPSHOT_DELTA;

				public int getRT_FRAC_NET_SNAPSHOT_DELTA () {
					return this.RT_FRAC_NET_SNAPSHOT_DELTA;
				}
				
			    public int RT_FRAC_EOD_MANUAL_DELTA;

				public int getRT_FRAC_EOD_MANUAL_DELTA () {
					return this.RT_FRAC_EOD_MANUAL_DELTA;
				}
				
			    public double RT_TEMPERATURE_SNAPSHOT;

				public double getRT_TEMPERATURE_SNAPSHOT () {
					return this.RT_TEMPERATURE_SNAPSHOT;
				}
				
			    public double RT_DENSITY_SNAPSHOT;

				public double getRT_DENSITY_SNAPSHOT () {
					return this.RT_DENSITY_SNAPSHOT;
				}
				
			    public double RT_END_TEMPERATURE_SNAPSHOT;

				public double getRT_END_TEMPERATURE_SNAPSHOT () {
					return this.RT_END_TEMPERATURE_SNAPSHOT;
				}
				
			    public double RT_END_DENSITY_SNAPSHOT;

				public double getRT_END_DENSITY_SNAPSHOT () {
					return this.RT_END_DENSITY_SNAPSHOT;
				}
				
			    public int RT_FRAC_EOD_TRANSFERS_IN;

				public int getRT_FRAC_EOD_TRANSFERS_IN () {
					return this.RT_FRAC_EOD_TRANSFERS_IN;
				}
				
			    public int RT_FRAC_EOD_TRANSFERS_OUT;

				public int getRT_FRAC_EOD_TRANSFERS_OUT () {
					return this.RT_FRAC_EOD_TRANSFERS_OUT;
				}
				
			    public int MANUAL_QUANTITY_ENABLE;

				public int getMANUAL_QUANTITY_ENABLE () {
					return this.MANUAL_QUANTITY_ENABLE;
				}
				
			    public int MANUAL_BSW_QUANTITY;

				public int getMANUAL_BSW_QUANTITY () {
					return this.MANUAL_BSW_QUANTITY;
				}
				
			    public int EOM_MANUAL_QUANTITY;

				public int getEOM_MANUAL_QUANTITY () {
					return this.EOM_MANUAL_QUANTITY;
				}
				
			    public int MANUAL_GROSS_QUANTITY;

				public int getMANUAL_GROSS_QUANTITY () {
					return this.MANUAL_GROSS_QUANTITY;
				}
				
			    public int MANUAL_LOW_LOW_QUANTITY;

				public int getMANUAL_LOW_LOW_QUANTITY () {
					return this.MANUAL_LOW_LOW_QUANTITY;
				}
				
			    public int MANUAL_LOW_QUANTITY;

				public int getMANUAL_LOW_QUANTITY () {
					return this.MANUAL_LOW_QUANTITY;
				}
				
			    public int MANUAL_GENERAL_QUANTITY;

				public int getMANUAL_GENERAL_QUANTITY () {
					return this.MANUAL_GENERAL_QUANTITY;
				}
				
			    public int MANUAL_CUTOFF_QUANTITY;

				public int getMANUAL_CUTOFF_QUANTITY () {
					return this.MANUAL_CUTOFF_QUANTITY;
				}
				
			    public int MANUAL_HIGH_QUANTITY;

				public int getMANUAL_HIGH_QUANTITY () {
					return this.MANUAL_HIGH_QUANTITY;
				}
				
			    public int MANUAL_HIGH_HIGH_QUANTITY;

				public int getMANUAL_HIGH_HIGH_QUANTITY () {
					return this.MANUAL_HIGH_HIGH_QUANTITY;
				}
				
			    public double MANUAL_OBSERVED_DENSITY;

				public double getMANUAL_OBSERVED_DENSITY () {
					return this.MANUAL_OBSERVED_DENSITY;
				}
				
			    public double RT_OBSERVED_DENSITY;

				public double getRT_OBSERVED_DENSITY () {
					return this.RT_OBSERVED_DENSITY;
				}
				
			    public double RT_OBS_DENSITY_SNAPSHOT;

				public double getRT_OBS_DENSITY_SNAPSHOT () {
					return this.RT_OBS_DENSITY_SNAPSHOT;
				}
				
			    public double RT_END_OBS_DENSITY_SNAPSHOT;

				public double getRT_END_OBS_DENSITY_SNAPSHOT () {
					return this.RT_END_OBS_DENSITY_SNAPSHOT;
				}
				
			    public int AUTO_BSW_LEVEL_ENABLE;

				public int getAUTO_BSW_LEVEL_ENABLE () {
					return this.AUTO_BSW_LEVEL_ENABLE;
				}
				
			    public int AUTO_BSW_QUANTITY_ENABLE;

				public int getAUTO_BSW_QUANTITY_ENABLE () {
					return this.AUTO_BSW_QUANTITY_ENABLE;
				}
				
			    public String RT_AUTO_BSW_LEVEL;

				public String getRT_AUTO_BSW_LEVEL () {
					return this.RT_AUTO_BSW_LEVEL;
				}
				
			    public int RT_AUTO_BSW_QUANTITY;

				public int getRT_AUTO_BSW_QUANTITY () {
					return this.RT_AUTO_BSW_QUANTITY;
				}
				
			    public String RT_BSW_LEVEL;

				public String getRT_BSW_LEVEL () {
					return this.RT_BSW_LEVEL;
				}
				
			    public String DDE_BSW_LEVEL_DSN;

				public String getDDE_BSW_LEVEL_DSN () {
					return this.DDE_BSW_LEVEL_DSN;
				}
				
			    public String DDE_BSW_LEVEL_ITEM;

				public String getDDE_BSW_LEVEL_ITEM () {
					return this.DDE_BSW_LEVEL_ITEM;
				}
				
			    public String DDE_BSW_QUANTITY_DSN;

				public String getDDE_BSW_QUANTITY_DSN () {
					return this.DDE_BSW_QUANTITY_DSN;
				}
				
			    public String DDE_BSW_QUANTITY_ITEM;

				public String getDDE_BSW_QUANTITY_ITEM () {
					return this.DDE_BSW_QUANTITY_ITEM;
				}
				
			    public int DOWNLOAD_DENSITY_ENABLE;

				public int getDOWNLOAD_DENSITY_ENABLE () {
					return this.DOWNLOAD_DENSITY_ENABLE;
				}
				
			    public int RT_EOD_ADD_MANUAL_DELTA;

				public int getRT_EOD_ADD_MANUAL_DELTA () {
					return this.RT_EOD_ADD_MANUAL_DELTA;
				}
				
			    public int RT_EOD_ADD_BULK_RECEIPTS;

				public int getRT_EOD_ADD_BULK_RECEIPTS () {
					return this.RT_EOD_ADD_BULK_RECEIPTS;
				}
				
			    public int RT_EOD_ADD_RACK_RECEIPTS;

				public int getRT_EOD_ADD_RACK_RECEIPTS () {
					return this.RT_EOD_ADD_RACK_RECEIPTS;
				}
				
			    public int RT_EOD_ADD_TRANSFERS_IN;

				public int getRT_EOD_ADD_TRANSFERS_IN () {
					return this.RT_EOD_ADD_TRANSFERS_IN;
				}
				
			    public int RT_EOD_ADD_BULK_DISPOSALS;

				public int getRT_EOD_ADD_BULK_DISPOSALS () {
					return this.RT_EOD_ADD_BULK_DISPOSALS;
				}
				
			    public int RT_EOD_ADD_RACK_DISPOSALS;

				public int getRT_EOD_ADD_RACK_DISPOSALS () {
					return this.RT_EOD_ADD_RACK_DISPOSALS;
				}
				
			    public int RT_EOD_ADD_TRANSFERS_OUT;

				public int getRT_EOD_ADD_TRANSFERS_OUT () {
					return this.RT_EOD_ADD_TRANSFERS_OUT;
				}
				
			    public int RT_EOD_ADD_BOOK_INVENTORY;

				public int getRT_EOD_ADD_BOOK_INVENTORY () {
					return this.RT_EOD_ADD_BOOK_INVENTORY;
				}
				
			    public int RT_IN_SERVICE;

				public int getRT_IN_SERVICE () {
					return this.RT_IN_SERVICE;
				}
				
			    public int VIRTUAL_TANK;

				public int getVIRTUAL_TANK () {
					return this.VIRTUAL_TANK;
				}
				
			    public String DDE_IN_SERVICE_ITEM;

				public String getDDE_IN_SERVICE_ITEM () {
					return this.DDE_IN_SERVICE_ITEM;
				}
				
			    public String TANK_GROUP;

				public String getTANK_GROUP () {
					return this.TANK_GROUP;
				}
				
			    public String DDE_IN_SERVICE_DSN;

				public String getDDE_IN_SERVICE_DSN () {
					return this.DDE_IN_SERVICE_DSN;
				}
				
			    public int RT_CUTOFF_QUANTITY;

				public int getRT_CUTOFF_QUANTITY () {
					return this.RT_CUTOFF_QUANTITY;
				}
				
			    public int AUTO_NET_QUANTITY_ENABLE;

				public int getAUTO_NET_QUANTITY_ENABLE () {
					return this.AUTO_NET_QUANTITY_ENABLE;
				}
				
			    public String DDE_NET_QUANTITY_ITEM;

				public String getDDE_NET_QUANTITY_ITEM () {
					return this.DDE_NET_QUANTITY_ITEM;
				}
				
			    public int RT_AUTO_NET_QUANTITY;

				public int getRT_AUTO_NET_QUANTITY () {
					return this.RT_AUTO_NET_QUANTITY;
				}
				
			    public String DDE_NET_QUANTITY_DSN;

				public String getDDE_NET_QUANTITY_DSN () {
					return this.DDE_NET_QUANTITY_DSN;
				}
				
			    public int MANUAL_NET_QUANTITY_ENABLE;

				public int getMANUAL_NET_QUANTITY_ENABLE () {
					return this.MANUAL_NET_QUANTITY_ENABLE;
				}
				
			    public int MANUAL_NET_QUANTITY;

				public int getMANUAL_NET_QUANTITY () {
					return this.MANUAL_NET_QUANTITY;
				}
				
			    public String HIGH_BSW_SETPOINT;

				public String getHIGH_BSW_SETPOINT () {
					return this.HIGH_BSW_SETPOINT;
				}
				
			    public int HIGH_BSW_QUANTITY;

				public int getHIGH_BSW_QUANTITY () {
					return this.HIGH_BSW_QUANTITY;
				}
				
			    public String DDE_BSW_HIGH_ALARM_DSN;

				public String getDDE_BSW_HIGH_ALARM_DSN () {
					return this.DDE_BSW_HIGH_ALARM_DSN;
				}
				
			    public String DDE_BSW_HIGH_ALARM_ITEM;

				public String getDDE_BSW_HIGH_ALARM_ITEM () {
					return this.DDE_BSW_HIGH_ALARM_ITEM;
				}
				
			    public int RT_EOD_BULK_FRAC_DISPOSALS;

				public int getRT_EOD_BULK_FRAC_DISPOSALS () {
					return this.RT_EOD_BULK_FRAC_DISPOSALS;
				}
				
			    public int RT_EOD_BULK_FRAC_RECEIPTS;

				public int getRT_EOD_BULK_FRAC_RECEIPTS () {
					return this.RT_EOD_BULK_FRAC_RECEIPTS;
				}
				
			    public String RT_EOD_OPEN_BSW_LEVEL;

				public String getRT_EOD_OPEN_BSW_LEVEL () {
					return this.RT_EOD_OPEN_BSW_LEVEL;
				}
				
			    public double RT_EOD_OPEN_DENSITY;

				public double getRT_EOD_OPEN_DENSITY () {
					return this.RT_EOD_OPEN_DENSITY;
				}
				
			    public double RT_EOD_OPEN_TEMPERATURE;

				public double getRT_EOD_OPEN_TEMPERATURE () {
					return this.RT_EOD_OPEN_TEMPERATURE;
				}
				
			    public int RT_EOD_OPEN_BSW_QUANTITY;

				public int getRT_EOD_OPEN_BSW_QUANTITY () {
					return this.RT_EOD_OPEN_BSW_QUANTITY;
				}
				
			    public String RT_EOD_OPEN_LEVEL;

				public String getRT_EOD_OPEN_LEVEL () {
					return this.RT_EOD_OPEN_LEVEL;
				}
				
			    public double RT_EOD_OPEN_OBSERVED_DENSITY;

				public double getRT_EOD_OPEN_OBSERVED_DENSITY () {
					return this.RT_EOD_OPEN_OBSERVED_DENSITY;
				}
				
			    public int RT_EOD_OPEN_PHYS_GROSS_QTY;

				public int getRT_EOD_OPEN_PHYS_GROSS_QTY () {
					return this.RT_EOD_OPEN_PHYS_GROSS_QTY;
				}
				
			    public String PREV_EOD_LEVEL;

				public String getPREV_EOD_LEVEL () {
					return this.PREV_EOD_LEVEL;
				}
				
			    public int PREV_EOD_GROSS_QUANTITY;

				public int getPREV_EOD_GROSS_QUANTITY () {
					return this.PREV_EOD_GROSS_QUANTITY;
				}
				
			    public double PREV_EOD_TEMPERATURE;

				public double getPREV_EOD_TEMPERATURE () {
					return this.PREV_EOD_TEMPERATURE;
				}
				
			    public double PREV_EOD_DENSITY;

				public double getPREV_EOD_DENSITY () {
					return this.PREV_EOD_DENSITY;
				}
				
			    public int PREV_EOD_BSW_QUANTITY;

				public int getPREV_EOD_BSW_QUANTITY () {
					return this.PREV_EOD_BSW_QUANTITY;
				}
				
			    public String PREV_EOD_BSW_LEVEL;

				public String getPREV_EOD_BSW_LEVEL () {
					return this.PREV_EOD_BSW_LEVEL;
				}
				
			    public int RT_PREV_EOD_NET_QUANTITY;

				public int getRT_PREV_EOD_NET_QUANTITY () {
					return this.RT_PREV_EOD_NET_QUANTITY;
				}
				
			    public double PREV_EOD_COE;

				public double getPREV_EOD_COE () {
					return this.PREV_EOD_COE;
				}
				
			    public int RT_PREV_EOD_BSW_QUANTITY;

				public int getRT_PREV_EOD_BSW_QUANTITY () {
					return this.RT_PREV_EOD_BSW_QUANTITY;
				}
				
			    public int PREV_EOD_QUANTITY;

				public int getPREV_EOD_QUANTITY () {
					return this.PREV_EOD_QUANTITY;
				}
				
			    public double OPENING_COE;

				public double getOPENING_COE () {
					return this.OPENING_COE;
				}
				
			    public int RT_TOV;

				public int getRT_TOV () {
					return this.RT_TOV;
				}
				
			    public int RT_GOV;

				public int getRT_GOV () {
					return this.RT_GOV;
				}
				
			    public int RT_GSV;

				public int getRT_GSV () {
					return this.RT_GSV;
				}
				
			    public int RT_TCV;

				public int getRT_TCV () {
					return this.RT_TCV;
				}
				
			    public double RT_SHELL_CORRECTION_FACTOR;

				public double getRT_SHELL_CORRECTION_FACTOR () {
					return this.RT_SHELL_CORRECTION_FACTOR;
				}
				
			    public int RT_FLOATING_ROOF_ADJUSTMENT;

				public int getRT_FLOATING_ROOF_ADJUSTMENT () {
					return this.RT_FLOATING_ROOF_ADJUSTMENT;
				}
				
			    public double RT_CTL;

				public double getRT_CTL () {
					return this.RT_CTL;
				}
				
			    public double SUSPENDED_BSW_PERCENT;

				public double getSUSPENDED_BSW_PERCENT () {
					return this.SUSPENDED_BSW_PERCENT;
				}
				
			    public int MANUAL_STRAP_TYPE;

				public int getMANUAL_STRAP_TYPE () {
					return this.MANUAL_STRAP_TYPE;
				}
				
			    public int ROOF_TAKE_OFF_STRAP_TYPE;

				public int getROOF_TAKE_OFF_STRAP_TYPE () {
					return this.ROOF_TAKE_OFF_STRAP_TYPE;
				}
				
			    public int ROOF_SUPPORT_STRAP_TYPE;

				public int getROOF_SUPPORT_STRAP_TYPE () {
					return this.ROOF_SUPPORT_STRAP_TYPE;
				}
				
			    public int HIGH_BSW_STRAP_TYPE;

				public int getHIGH_BSW_STRAP_TYPE () {
					return this.HIGH_BSW_STRAP_TYPE;
				}
				
			    public int BASE_SEDIMENT_WATER_STRAP_TYPE;

				public int getBASE_SEDIMENT_WATER_STRAP_TYPE () {
					return this.BASE_SEDIMENT_WATER_STRAP_TYPE;
				}
				
			    public String GAUGER_INITIALS;

				public String getGAUGER_INITIALS () {
					return this.GAUGER_INITIALS;
				}
				
			    public java.util.Date GAUGE_TIMESTAMP;

				public java.util.Date getGAUGE_TIMESTAMP () {
					return this.GAUGE_TIMESTAMP;
				}
				
			    public int LEVEL_UNITS;

				public int getLEVEL_UNITS () {
					return this.LEVEL_UNITS;
				}
				
			    public double SHELL_BASE_TEMPERATURE;

				public double getSHELL_BASE_TEMPERATURE () {
					return this.SHELL_BASE_TEMPERATURE;
				}
				
			    public int SHELL_MATERIAL_TYPE;

				public int getSHELL_MATERIAL_TYPE () {
					return this.SHELL_MATERIAL_TYPE;
				}
				
			    public double MANUAL_AMBIENT_TEMPERATURE;

				public double getMANUAL_AMBIENT_TEMPERATURE () {
					return this.MANUAL_AMBIENT_TEMPERATURE;
				}
				
			    public int INSULATED;

				public int getINSULATED () {
					return this.INSULATED;
				}
				
			    public int LINE_SEGMENT_NSV;

				public int getLINE_SEGMENT_NSV () {
					return this.LINE_SEGMENT_NSV;
				}
				
			    public int RT_CALCULATION_POINT;

				public int getRT_CALCULATION_POINT () {
					return this.RT_CALCULATION_POINT;
				}
				
			    public int ROOF_TAKE_OFF_TOV;

				public int getROOF_TAKE_OFF_TOV () {
					return this.ROOF_TAKE_OFF_TOV;
				}
				
			    public int RT_NSV;

				public int getRT_NSV () {
					return this.RT_NSV;
				}
				
			    public int RT_GSW;

				public int getRT_GSW () {
					return this.RT_GSW;
				}
				
			    public int RT_NSW;

				public int getRT_NSW () {
					return this.RT_NSW;
				}
				
			    public double RT_WCF;

				public double getRT_WCF () {
					return this.RT_WCF;
				}
				
			    public int LINE_SEGMENT_NSW;

				public int getLINE_SEGMENT_NSW () {
					return this.LINE_SEGMENT_NSW;
				}
				
			    public double ROOF_WEIGHT;

				public double getROOF_WEIGHT () {
					return this.ROOF_WEIGHT;
				}
				
			    public int VOL_IN_ALARM;

				public int getVOL_IN_ALARM () {
					return this.VOL_IN_ALARM;
				}
				
			    public int INACTIVITY_QUANTITY;

				public int getINACTIVITY_QUANTITY () {
					return this.INACTIVITY_QUANTITY;
				}
				
			    public int INACTIVITY_ALARM_STATE;

				public int getINACTIVITY_ALARM_STATE () {
					return this.INACTIVITY_ALARM_STATE;
				}
				
			    public int USER_LEVEL;

				public int getUSER_LEVEL () {
					return this.USER_LEVEL;
				}
				
			    public java.util.Date SCHED_PROD_CHANGE_DATE_TIME;

				public java.util.Date getSCHED_PROD_CHANGE_DATE_TIME () {
					return this.SCHED_PROD_CHANGE_DATE_TIME;
				}
				
			    public int SCHED_PROD_CHANGE_TIMEOUT;

				public int getSCHED_PROD_CHANGE_TIMEOUT () {
					return this.SCHED_PROD_CHANGE_TIMEOUT;
				}
				
			    public String SCHED_PROD_CHANGE_EMAIL;

				public String getSCHED_PROD_CHANGE_EMAIL () {
					return this.SCHED_PROD_CHANGE_EMAIL;
				}
				
			    public int SETPOINT_QUANTITY_ENABLE;

				public int getSETPOINT_QUANTITY_ENABLE () {
					return this.SETPOINT_QUANTITY_ENABLE;
				}
				
			    public double MANUAL_MEASURED_DENSITY;

				public double getMANUAL_MEASURED_DENSITY () {
					return this.MANUAL_MEASURED_DENSITY;
				}
				
			    public int WEIGHT_IN_AIR;

				public int getWEIGHT_IN_AIR () {
					return this.WEIGHT_IN_AIR;
				}
				
			    public int TOPS_MONITORING_ACTIVE;

				public int getTOPS_MONITORING_ACTIVE () {
					return this.TOPS_MONITORING_ACTIVE;
				}
				
			    public int SHAPE;

				public int getSHAPE () {
					return this.SHAPE;
				}
				
			    public int ACTUAL_FLOW_RATE_PERIOD;

				public int getACTUAL_FLOW_RATE_PERIOD () {
					return this.ACTUAL_FLOW_RATE_PERIOD;
				}
				
			    public int CALCULATED_FLOW_RATE_PERIOD;

				public int getCALCULATED_FLOW_RATE_PERIOD () {
					return this.CALCULATED_FLOW_RATE_PERIOD;
				}
				
			    public int FLOW_RATE_CLAMPING_PERIOD;

				public int getFLOW_RATE_CLAMPING_PERIOD () {
					return this.FLOW_RATE_CLAMPING_PERIOD;
				}
				
			    public java.util.Date RT_CLAMPING_PERIOD_START;

				public java.util.Date getRT_CLAMPING_PERIOD_START () {
					return this.RT_CLAMPING_PERIOD_START;
				}
				
			    public int VAPOR_CORRECTION_METHOD;

				public int getVAPOR_CORRECTION_METHOD () {
					return this.VAPOR_CORRECTION_METHOD;
				}
				
			    public double VAPOR_TEMPERATURE;

				public double getVAPOR_TEMPERATURE () {
					return this.VAPOR_TEMPERATURE;
				}
				
			    public double VAPOR_LIQUID_VOLUME_RATIO;

				public double getVAPOR_LIQUID_VOLUME_RATIO () {
					return this.VAPOR_LIQUID_VOLUME_RATIO;
				}
				
			    public int TARGET_LEVEL;

				public int getTARGET_LEVEL () {
					return this.TARGET_LEVEL;
				}
				
			    public int ORIGINAL_STARTING_LEVEL;

				public int getORIGINAL_STARTING_LEVEL () {
					return this.ORIGINAL_STARTING_LEVEL;
				}
				
			    public int TIME_TO_TARGET_LEVEL;

				public int getTIME_TO_TARGET_LEVEL () {
					return this.TIME_TO_TARGET_LEVEL;
				}
				
			    public int AUTO_VAPOR_TEMPERATURE_ENABLE;

				public int getAUTO_VAPOR_TEMPERATURE_ENABLE () {
					return this.AUTO_VAPOR_TEMPERATURE_ENABLE;
				}
				
			    public String DDE_PRESSURE_DSN;

				public String getDDE_PRESSURE_DSN () {
					return this.DDE_PRESSURE_DSN;
				}
				
			    public String DDE_PRESSURE_ITEM;

				public String getDDE_PRESSURE_ITEM () {
					return this.DDE_PRESSURE_ITEM;
				}
				
			    public String DDE_VAPOR_TEMPERATURE_DSN;

				public String getDDE_VAPOR_TEMPERATURE_DSN () {
					return this.DDE_VAPOR_TEMPERATURE_DSN;
				}
				
			    public String DDE_VAPOR_TEMPERATURE_ITEM;

				public String getDDE_VAPOR_TEMPERATURE_ITEM () {
					return this.DDE_VAPOR_TEMPERATURE_ITEM;
				}
				
			    public double RT_AUTO_VAPOR_TEMPERATURE;

				public double getRT_AUTO_VAPOR_TEMPERATURE () {
					return this.RT_AUTO_VAPOR_TEMPERATURE;
				}
				
			    public double RT_VAPOR_TEMPERATURE;

				public double getRT_VAPOR_TEMPERATURE () {
					return this.RT_VAPOR_TEMPERATURE;
				}
				
			    public int INVENTORY_ENABLE;

				public int getINVENTORY_ENABLE () {
					return this.INVENTORY_ENABLE;
				}
				
			    public int MANUAL_TO_AUTO_FOLIO_LIMIT;

				public int getMANUAL_TO_AUTO_FOLIO_LIMIT () {
					return this.MANUAL_TO_AUTO_FOLIO_LIMIT;
				}
				
			    public int RT_MANUAL_TO_AUTO_FOLIO_COUNT;

				public int getRT_MANUAL_TO_AUTO_FOLIO_COUNT () {
					return this.RT_MANUAL_TO_AUTO_FOLIO_COUNT;
				}
				
			    public int RT_LEVEL_ORIGIN;

				public int getRT_LEVEL_ORIGIN () {
					return this.RT_LEVEL_ORIGIN;
				}
				
			    public int RT_TOV_ORIGIN;

				public int getRT_TOV_ORIGIN () {
					return this.RT_TOV_ORIGIN;
				}
				
			    public int RT_TEMPERATURE_ORIGIN;

				public int getRT_TEMPERATURE_ORIGIN () {
					return this.RT_TEMPERATURE_ORIGIN;
				}
				
			    public int RT_DENSITY_ORIGIN;

				public int getRT_DENSITY_ORIGIN () {
					return this.RT_DENSITY_ORIGIN;
				}
				
			    public int RT_NSV_ORIGIN;

				public int getRT_NSV_ORIGIN () {
					return this.RT_NSV_ORIGIN;
				}
				
			    public int RT_VAPOR_TEMPERATURE_ORIGIN;

				public int getRT_VAPOR_TEMPERATURE_ORIGIN () {
					return this.RT_VAPOR_TEMPERATURE_ORIGIN;
				}
				
			    public int RT_PRESSURE_ORIGIN;

				public int getRT_PRESSURE_ORIGIN () {
					return this.RT_PRESSURE_ORIGIN;
				}
				
			    public int RT_FREE_WATER_LEVEL_ORIGIN;

				public int getRT_FREE_WATER_LEVEL_ORIGIN () {
					return this.RT_FREE_WATER_LEVEL_ORIGIN;
				}
				
			    public int RT_WATER_QUANTITY_ORIGIN;

				public int getRT_WATER_QUANTITY_ORIGIN () {
					return this.RT_WATER_QUANTITY_ORIGIN;
				}
				
			    public String DDE_SNAPSHOT_REQ_DSN;

				public String getDDE_SNAPSHOT_REQ_DSN () {
					return this.DDE_SNAPSHOT_REQ_DSN;
				}
				
			    public String DDE_SNAPSHOT_REQ_ITEM;

				public String getDDE_SNAPSHOT_REQ_ITEM () {
					return this.DDE_SNAPSHOT_REQ_ITEM;
				}
				
			    public String DDE_SNAPSHOT_RSP_DSN;

				public String getDDE_SNAPSHOT_RSP_DSN () {
					return this.DDE_SNAPSHOT_RSP_DSN;
				}
				
			    public String DDE_SNAPSHOT_RSP_ITEM;

				public String getDDE_SNAPSHOT_RSP_ITEM () {
					return this.DDE_SNAPSHOT_RSP_ITEM;
				}
				
			    public int AUTO_PRODUCT_LEVEL_UNIT;

				public int getAUTO_PRODUCT_LEVEL_UNIT () {
					return this.AUTO_PRODUCT_LEVEL_UNIT;
				}
				
			    public int AUTO_FREE_WATER_LEVEL_UNIT;

				public int getAUTO_FREE_WATER_LEVEL_UNIT () {
					return this.AUTO_FREE_WATER_LEVEL_UNIT;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PGS_STAGE_DIM_TANK.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_TANK.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_TANK = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_TANK = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PGS_STAGE_DIM_TANK, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_TANK, 0, length, utf8Charset);
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
			if(length > commonByteArray_PGS_STAGE_DIM_TANK.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_TANK.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_TANK = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_TANK = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PGS_STAGE_DIM_TANK, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_TANK, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_TANK) {

        	try {

        		int length = 0;
		
					this.TANK_CODE = readString(dis);
					
					this.NAME = readString(dis);
					
						this.COMPARTMENT_OWNER_ID = readInteger(dis);
					
						this.MAJORITY_SHAREHOLDER = readInteger(dis);
					
					this.COMPARTMENT_CONTAINER_CODE = readString(dis);
					
			        this.RT_GROSS_QUANTITY = dis.readInt();
					
						this.COMPARTMENT_CONTAINER_TYPE = readInteger(dis);
					
			        this.TERMINAL_PRODUCT_NUMBER = dis.readInt();
					
						this.COMPARTMENT_NUMBER = readInteger(dis);
					
			        this.RT_NET_QUANTITY = dis.readInt();
					
			        this.ENABLE = dis.readInt();
					
						this.SCHED_PROD_CHANGE_PRODUCT = readInteger(dis);
					
			        this.RVP = dis.readDouble();
					
			        this.OXYGEN = dis.readDouble();
					
			        this.RT_TEMPERATURE = dis.readDouble();
					
			        this.RT_DENSITY = dis.readDouble();
					
			        this.SHELL_CAPACITY = dis.readInt();
					
			        this.WORK_CAPACITY = dis.readInt();
					
					this.DEPTH = readString(dis);
					
					this.LOW_LOW_SETPOINT = readString(dis);
					
					this.LOW_SETPOINT = readString(dis);
					
					this.GENERAL_SETPOINT = readString(dis);
					
					this.CUTOFF_SETPOINT = readString(dis);
					
			        this.AUTO_ENABLE = dis.readInt();
					
					this.HIGH_SETPOINT = readString(dis);
					
					this.HIGH_HIGH_SETPOINT = readString(dis);
					
			        this.DEADBAND = dis.readInt();
					
			        this.AUTO_LEVEL_ENABLE = dis.readInt();
					
					this.DDE_LEVEL_DSN = readString(dis);
					
			        this.AUTO_DENSITY_ENABLE = dis.readInt();
					
			        this.AUTO_TEMPERATURE_ENABLE = dis.readInt();
					
					this.DDE_LEVEL_ITEM = readString(dis);
					
			        this.AUTO_QUANTITY_ENABLE = dis.readInt();
					
					this.DDE_DENSITY_DSN = readString(dis);
					
			        this.ACTIVITY_STATUS = dis.readInt();
					
					this.DDE_DENSITY_ITEM = readString(dis);
					
					this.DDE_TEMPERATURE_DSN = readString(dis);
					
			        this.RECEIPT_INDICATOR = dis.readInt();
					
					this.DDE_TEMPERATURE_ITEM = readString(dis);
					
					this.LAST_RECEIPT_DATE = readDate(dis);
					
					this.DDE_QUANTITY_DSN = readString(dis);
					
					this.DDE_QUANTITY_ITEM = readString(dis);
					
			        this.SEND_TO_HOST_AT_EOD = dis.readInt();
					
					this.MANUAL_LEVEL = readString(dis);
					
					this.RT_AUTO_LEVEL = readString(dis);
					
					this.EOM_MANUAL_LEVEL = readString(dis);
					
			        this.RT_EOM_GROSS_QUANTITY = dis.readInt();
					
			        this.RT_AUTO_DENSITY = dis.readDouble();
					
			        this.EOM_MANUAL_TEMPERATURE = dis.readDouble();
					
			        this.EOM_MANUAL_DENSITY = dis.readDouble();
					
			        this.EOM_MANUAL_BSW_QUANTITY = dis.readInt();
					
					this.EOM_MANUAL_BSW_LEVEL = readString(dis);
					
			        this.MANUAL_TEMPERATURE = dis.readDouble();
					
			        this.RT_EOM_NET_QUANTITY = dis.readInt();
					
			        this.EOM_MANUAL_COE = dis.readDouble();
					
			        this.RT_EOM_BSW_QUANTITY = dis.readInt();
					
					this.MANUAL_DATE = readDate(dis);
					
					this.BASE_SEDIMENT_WATER_LEVEL = readString(dis);
					
			        this.MANUAL_DENSITY = dis.readDouble();
					
			        this.RT_BSW_QUANTITY = dis.readInt();
					
			        this.MANUAL_SPECIFIC_GRAVITY = dis.readDouble();
					
			        this.PIPE_FILL = dis.readInt();
					
			        this.MANUAL_COEFFICIENT_EXPANSION = dis.readDouble();
					
			        this.PROTOCOL_TYPE = dis.readInt();
					
			        this.RT_AUTO_TEMPERATURE = dis.readDouble();
					
					this.PORT_NAME = readString(dis);
					
			        this.RT_AUTO_QUANTITY = dis.readInt();
					
			        this.ADDRESS = dis.readInt();
					
					this.REMARKS = readString(dis);
					
			        this.FAST_SCAN = dis.readInt();
					
					this.RT_LEVEL = readString(dis);
					
			        this.RT_METER_COUNT = dis.readInt();
					
			        this.RT_GROSS_SNAPSHOT = dis.readInt();
					
			        this.RT_SNAPSHOT_ACTIVE = dis.readInt();
					
					this.RT_LEVEL_SNAPSHOT = readString(dis);
					
			        this.RT_NET_SNAPSHOT = dis.readInt();
					
					this.RT_SNAPSHOT_DATE = readDate(dis);
					
			        this.RT_GROSS_SNAPSHOT_DELTA = dis.readInt();
					
			        this.RT_NET_SNAPSHOT_DELTA = dis.readInt();
					
			        this.RT_EOD_MANUAL_DELTA = dis.readInt();
					
					this.RT_END_LEVEL_SNAPSHOT = readString(dis);
					
			        this.RT_EOD_OPENING_PHYSICAL = dis.readInt();
					
			        this.RT_EOD_BULK_RECEIPTS = dis.readInt();
					
			        this.RT_END_GROSS_SNAPSHOT = dis.readInt();
					
			        this.RT_AVAILABLE_QUANTITY = dis.readInt();
					
			        this.RT_END_NET_SNAPSHOT = dis.readInt();
					
			        this.RT_EOD_BULK_DISPOSALS = dis.readInt();
					
					this.RT_END_SNAPSHOT_DATE = readDate(dis);
					
			        this.RT_EOD_TRANSFERS_IN = dis.readInt();
					
			        this.RT_EOD_RACK_RECEIPTS = dis.readInt();
					
			        this.RT_EOD_TRANSFERS_OUT = dis.readInt();
					
			        this.RT_EOD_RACK_DISPOSALS = dis.readInt();
					
					this.LAST_USER_NAME = readString(dis);
					
					this.LAST_MODIFIED = readDate(dis);
					
			        this.RT_EOD_BOOK_INVENTORY = dis.readInt();
					
					this.USER_DLL = readString(dis);
					
					this.USER_ROUTINE = readString(dis);
					
			        this.ROOF_CORRECTION_TYPE = dis.readInt();
					
					this.ROOF_TAKE_OFF_LEVEL = readString(dis);
					
					this.ROOF_SUPPORT_LEVEL = readString(dis);
					
			        this.ROOF_REFERENCE_DENSITY = dis.readDouble();
					
			        this.ROOF_ABOVE_ADJUSTMENT = dis.readDouble();
					
			        this.RT_EOD_MANUAL_CLOSING_ENABLE = dis.readInt();
					
			        this.ROOF_BELOW_ADJUSTMENT = dis.readDouble();
					
					this.RT_EOD_MANUAL_LEVEL = readString(dis);
					
			        this.STRAPPING_INVERTED = dis.readInt();
					
			        this.RT_EOD_MANUAL_GROSS_QUANTITY = dis.readInt();
					
			        this.RT_EOD_MANUAL_NET_QUANTITY = dis.readInt();
					
			        this.RT_EOD_RACK_FRAC_DISPOSALS = dis.readInt();
					
			        this.RT_EOD_RACK_FRAC_RECEIPTS = dis.readInt();
					
					this.DDE_HIGH_ALARM_DSN = readString(dis);
					
					this.DDE_HIGH_ALARM_ITEM = readString(dis);
					
					this.DDE_HIGH_HIGH_ALARM_DSN = readString(dis);
					
					this.DDE_HIGH_HIGH_ALARM_ITEM = readString(dis);
					
					this.DDE_LOW_ALARM_DSN = readString(dis);
					
					this.DDE_LOW_ALARM_ITEM = readString(dis);
					
					this.DDE_LOW_LOW_ALARM_DSN = readString(dis);
					
					this.DDE_LOW_LOW_ALARM_ITEM = readString(dis);
					
					this.DDE_CUTOFF_ALARM_DSN = readString(dis);
					
					this.DDE_CUTOFF_ALARM_ITEM = readString(dis);
					
					this.DDE_STATUS_DSN = readString(dis);
					
					this.DDE_STATUS_ITEM = readString(dis);
					
			        this.RT_AUTO_PRESSURE = dis.readDouble();
					
			        this.RT_AUTO_MASS = dis.readInt();
					
			        this.MANUAL_PRESSURE = dis.readDouble();
					
			        this.MANUAL_MASS = dis.readInt();
					
			        this.RT_PRESSURE = dis.readDouble();
					
			        this.RT_MASS = dis.readInt();
					
			        this.AUTO_PRESSURE_ENABLE = dis.readInt();
					
			        this.AUTO_MASS_ENABLE = dis.readInt();
					
			        this.DOWNLOAD_ENABLE = dis.readInt();
					
			        this.DOWNLOAD_LEVEL_ENABLE = dis.readInt();
					
			        this.DOWNLOAD_QUANTITY_ENABLE = dis.readInt();
					
			        this.DOWNLOAD_TEMPERATURE_ENABLE = dis.readInt();
					
			        this.DOWNLOAD_PRESSURE_ENABLE = dis.readInt();
					
			        this.DOWNLOAD_MASS_ENABLE = dis.readInt();
					
			        this.RT_USER_QUEUE_ENABLE = dis.readInt();
					
			        this.RT_USER_CONTEXT_VALUE = dis.readInt();
					
			        this.RT_FRAC_GROSS_SNAPSHOT_DELTA = dis.readInt();
					
			        this.RT_FRAC_NET_SNAPSHOT_DELTA = dis.readInt();
					
			        this.RT_FRAC_EOD_MANUAL_DELTA = dis.readInt();
					
			        this.RT_TEMPERATURE_SNAPSHOT = dis.readDouble();
					
			        this.RT_DENSITY_SNAPSHOT = dis.readDouble();
					
			        this.RT_END_TEMPERATURE_SNAPSHOT = dis.readDouble();
					
			        this.RT_END_DENSITY_SNAPSHOT = dis.readDouble();
					
			        this.RT_FRAC_EOD_TRANSFERS_IN = dis.readInt();
					
			        this.RT_FRAC_EOD_TRANSFERS_OUT = dis.readInt();
					
			        this.MANUAL_QUANTITY_ENABLE = dis.readInt();
					
			        this.MANUAL_BSW_QUANTITY = dis.readInt();
					
			        this.EOM_MANUAL_QUANTITY = dis.readInt();
					
			        this.MANUAL_GROSS_QUANTITY = dis.readInt();
					
			        this.MANUAL_LOW_LOW_QUANTITY = dis.readInt();
					
			        this.MANUAL_LOW_QUANTITY = dis.readInt();
					
			        this.MANUAL_GENERAL_QUANTITY = dis.readInt();
					
			        this.MANUAL_CUTOFF_QUANTITY = dis.readInt();
					
			        this.MANUAL_HIGH_QUANTITY = dis.readInt();
					
			        this.MANUAL_HIGH_HIGH_QUANTITY = dis.readInt();
					
			        this.MANUAL_OBSERVED_DENSITY = dis.readDouble();
					
			        this.RT_OBSERVED_DENSITY = dis.readDouble();
					
			        this.RT_OBS_DENSITY_SNAPSHOT = dis.readDouble();
					
			        this.RT_END_OBS_DENSITY_SNAPSHOT = dis.readDouble();
					
			        this.AUTO_BSW_LEVEL_ENABLE = dis.readInt();
					
			        this.AUTO_BSW_QUANTITY_ENABLE = dis.readInt();
					
					this.RT_AUTO_BSW_LEVEL = readString(dis);
					
			        this.RT_AUTO_BSW_QUANTITY = dis.readInt();
					
					this.RT_BSW_LEVEL = readString(dis);
					
					this.DDE_BSW_LEVEL_DSN = readString(dis);
					
					this.DDE_BSW_LEVEL_ITEM = readString(dis);
					
					this.DDE_BSW_QUANTITY_DSN = readString(dis);
					
					this.DDE_BSW_QUANTITY_ITEM = readString(dis);
					
			        this.DOWNLOAD_DENSITY_ENABLE = dis.readInt();
					
			        this.RT_EOD_ADD_MANUAL_DELTA = dis.readInt();
					
			        this.RT_EOD_ADD_BULK_RECEIPTS = dis.readInt();
					
			        this.RT_EOD_ADD_RACK_RECEIPTS = dis.readInt();
					
			        this.RT_EOD_ADD_TRANSFERS_IN = dis.readInt();
					
			        this.RT_EOD_ADD_BULK_DISPOSALS = dis.readInt();
					
			        this.RT_EOD_ADD_RACK_DISPOSALS = dis.readInt();
					
			        this.RT_EOD_ADD_TRANSFERS_OUT = dis.readInt();
					
			        this.RT_EOD_ADD_BOOK_INVENTORY = dis.readInt();
					
			        this.RT_IN_SERVICE = dis.readInt();
					
			        this.VIRTUAL_TANK = dis.readInt();
					
					this.DDE_IN_SERVICE_ITEM = readString(dis);
					
					this.TANK_GROUP = readString(dis);
					
					this.DDE_IN_SERVICE_DSN = readString(dis);
					
			        this.RT_CUTOFF_QUANTITY = dis.readInt();
					
			        this.AUTO_NET_QUANTITY_ENABLE = dis.readInt();
					
					this.DDE_NET_QUANTITY_ITEM = readString(dis);
					
			        this.RT_AUTO_NET_QUANTITY = dis.readInt();
					
					this.DDE_NET_QUANTITY_DSN = readString(dis);
					
			        this.MANUAL_NET_QUANTITY_ENABLE = dis.readInt();
					
			        this.MANUAL_NET_QUANTITY = dis.readInt();
					
					this.HIGH_BSW_SETPOINT = readString(dis);
					
			        this.HIGH_BSW_QUANTITY = dis.readInt();
					
					this.DDE_BSW_HIGH_ALARM_DSN = readString(dis);
					
					this.DDE_BSW_HIGH_ALARM_ITEM = readString(dis);
					
			        this.RT_EOD_BULK_FRAC_DISPOSALS = dis.readInt();
					
			        this.RT_EOD_BULK_FRAC_RECEIPTS = dis.readInt();
					
					this.RT_EOD_OPEN_BSW_LEVEL = readString(dis);
					
			        this.RT_EOD_OPEN_DENSITY = dis.readDouble();
					
			        this.RT_EOD_OPEN_TEMPERATURE = dis.readDouble();
					
			        this.RT_EOD_OPEN_BSW_QUANTITY = dis.readInt();
					
					this.RT_EOD_OPEN_LEVEL = readString(dis);
					
			        this.RT_EOD_OPEN_OBSERVED_DENSITY = dis.readDouble();
					
			        this.RT_EOD_OPEN_PHYS_GROSS_QTY = dis.readInt();
					
					this.PREV_EOD_LEVEL = readString(dis);
					
			        this.PREV_EOD_GROSS_QUANTITY = dis.readInt();
					
			        this.PREV_EOD_TEMPERATURE = dis.readDouble();
					
			        this.PREV_EOD_DENSITY = dis.readDouble();
					
			        this.PREV_EOD_BSW_QUANTITY = dis.readInt();
					
					this.PREV_EOD_BSW_LEVEL = readString(dis);
					
			        this.RT_PREV_EOD_NET_QUANTITY = dis.readInt();
					
			        this.PREV_EOD_COE = dis.readDouble();
					
			        this.RT_PREV_EOD_BSW_QUANTITY = dis.readInt();
					
			        this.PREV_EOD_QUANTITY = dis.readInt();
					
			        this.OPENING_COE = dis.readDouble();
					
			        this.RT_TOV = dis.readInt();
					
			        this.RT_GOV = dis.readInt();
					
			        this.RT_GSV = dis.readInt();
					
			        this.RT_TCV = dis.readInt();
					
			        this.RT_SHELL_CORRECTION_FACTOR = dis.readDouble();
					
			        this.RT_FLOATING_ROOF_ADJUSTMENT = dis.readInt();
					
			        this.RT_CTL = dis.readDouble();
					
			        this.SUSPENDED_BSW_PERCENT = dis.readDouble();
					
			        this.MANUAL_STRAP_TYPE = dis.readInt();
					
			        this.ROOF_TAKE_OFF_STRAP_TYPE = dis.readInt();
					
			        this.ROOF_SUPPORT_STRAP_TYPE = dis.readInt();
					
			        this.HIGH_BSW_STRAP_TYPE = dis.readInt();
					
			        this.BASE_SEDIMENT_WATER_STRAP_TYPE = dis.readInt();
					
					this.GAUGER_INITIALS = readString(dis);
					
					this.GAUGE_TIMESTAMP = readDate(dis);
					
			        this.LEVEL_UNITS = dis.readInt();
					
			        this.SHELL_BASE_TEMPERATURE = dis.readDouble();
					
			        this.SHELL_MATERIAL_TYPE = dis.readInt();
					
			        this.MANUAL_AMBIENT_TEMPERATURE = dis.readDouble();
					
			        this.INSULATED = dis.readInt();
					
			        this.LINE_SEGMENT_NSV = dis.readInt();
					
			        this.RT_CALCULATION_POINT = dis.readInt();
					
			        this.ROOF_TAKE_OFF_TOV = dis.readInt();
					
			        this.RT_NSV = dis.readInt();
					
			        this.RT_GSW = dis.readInt();
					
			        this.RT_NSW = dis.readInt();
					
			        this.RT_WCF = dis.readDouble();
					
			        this.LINE_SEGMENT_NSW = dis.readInt();
					
			        this.ROOF_WEIGHT = dis.readDouble();
					
			        this.VOL_IN_ALARM = dis.readInt();
					
			        this.INACTIVITY_QUANTITY = dis.readInt();
					
			        this.INACTIVITY_ALARM_STATE = dis.readInt();
					
			        this.USER_LEVEL = dis.readInt();
					
					this.SCHED_PROD_CHANGE_DATE_TIME = readDate(dis);
					
			        this.SCHED_PROD_CHANGE_TIMEOUT = dis.readInt();
					
					this.SCHED_PROD_CHANGE_EMAIL = readString(dis);
					
			        this.SETPOINT_QUANTITY_ENABLE = dis.readInt();
					
			        this.MANUAL_MEASURED_DENSITY = dis.readDouble();
					
			        this.WEIGHT_IN_AIR = dis.readInt();
					
			        this.TOPS_MONITORING_ACTIVE = dis.readInt();
					
			        this.SHAPE = dis.readInt();
					
			        this.ACTUAL_FLOW_RATE_PERIOD = dis.readInt();
					
			        this.CALCULATED_FLOW_RATE_PERIOD = dis.readInt();
					
			        this.FLOW_RATE_CLAMPING_PERIOD = dis.readInt();
					
					this.RT_CLAMPING_PERIOD_START = readDate(dis);
					
			        this.VAPOR_CORRECTION_METHOD = dis.readInt();
					
			        this.VAPOR_TEMPERATURE = dis.readDouble();
					
			        this.VAPOR_LIQUID_VOLUME_RATIO = dis.readDouble();
					
			        this.TARGET_LEVEL = dis.readInt();
					
			        this.ORIGINAL_STARTING_LEVEL = dis.readInt();
					
			        this.TIME_TO_TARGET_LEVEL = dis.readInt();
					
			        this.AUTO_VAPOR_TEMPERATURE_ENABLE = dis.readInt();
					
					this.DDE_PRESSURE_DSN = readString(dis);
					
					this.DDE_PRESSURE_ITEM = readString(dis);
					
					this.DDE_VAPOR_TEMPERATURE_DSN = readString(dis);
					
					this.DDE_VAPOR_TEMPERATURE_ITEM = readString(dis);
					
			        this.RT_AUTO_VAPOR_TEMPERATURE = dis.readDouble();
					
			        this.RT_VAPOR_TEMPERATURE = dis.readDouble();
					
			        this.INVENTORY_ENABLE = dis.readInt();
					
			        this.MANUAL_TO_AUTO_FOLIO_LIMIT = dis.readInt();
					
			        this.RT_MANUAL_TO_AUTO_FOLIO_COUNT = dis.readInt();
					
			        this.RT_LEVEL_ORIGIN = dis.readInt();
					
			        this.RT_TOV_ORIGIN = dis.readInt();
					
			        this.RT_TEMPERATURE_ORIGIN = dis.readInt();
					
			        this.RT_DENSITY_ORIGIN = dis.readInt();
					
			        this.RT_NSV_ORIGIN = dis.readInt();
					
			        this.RT_VAPOR_TEMPERATURE_ORIGIN = dis.readInt();
					
			        this.RT_PRESSURE_ORIGIN = dis.readInt();
					
			        this.RT_FREE_WATER_LEVEL_ORIGIN = dis.readInt();
					
			        this.RT_WATER_QUANTITY_ORIGIN = dis.readInt();
					
					this.DDE_SNAPSHOT_REQ_DSN = readString(dis);
					
					this.DDE_SNAPSHOT_REQ_ITEM = readString(dis);
					
					this.DDE_SNAPSHOT_RSP_DSN = readString(dis);
					
					this.DDE_SNAPSHOT_RSP_ITEM = readString(dis);
					
			        this.AUTO_PRODUCT_LEVEL_UNIT = dis.readInt();
					
			        this.AUTO_FREE_WATER_LEVEL_UNIT = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_TANK) {

        	try {

        		int length = 0;
		
					this.TANK_CODE = readString(dis);
					
					this.NAME = readString(dis);
					
						this.COMPARTMENT_OWNER_ID = readInteger(dis);
					
						this.MAJORITY_SHAREHOLDER = readInteger(dis);
					
					this.COMPARTMENT_CONTAINER_CODE = readString(dis);
					
			        this.RT_GROSS_QUANTITY = dis.readInt();
					
						this.COMPARTMENT_CONTAINER_TYPE = readInteger(dis);
					
			        this.TERMINAL_PRODUCT_NUMBER = dis.readInt();
					
						this.COMPARTMENT_NUMBER = readInteger(dis);
					
			        this.RT_NET_QUANTITY = dis.readInt();
					
			        this.ENABLE = dis.readInt();
					
						this.SCHED_PROD_CHANGE_PRODUCT = readInteger(dis);
					
			        this.RVP = dis.readDouble();
					
			        this.OXYGEN = dis.readDouble();
					
			        this.RT_TEMPERATURE = dis.readDouble();
					
			        this.RT_DENSITY = dis.readDouble();
					
			        this.SHELL_CAPACITY = dis.readInt();
					
			        this.WORK_CAPACITY = dis.readInt();
					
					this.DEPTH = readString(dis);
					
					this.LOW_LOW_SETPOINT = readString(dis);
					
					this.LOW_SETPOINT = readString(dis);
					
					this.GENERAL_SETPOINT = readString(dis);
					
					this.CUTOFF_SETPOINT = readString(dis);
					
			        this.AUTO_ENABLE = dis.readInt();
					
					this.HIGH_SETPOINT = readString(dis);
					
					this.HIGH_HIGH_SETPOINT = readString(dis);
					
			        this.DEADBAND = dis.readInt();
					
			        this.AUTO_LEVEL_ENABLE = dis.readInt();
					
					this.DDE_LEVEL_DSN = readString(dis);
					
			        this.AUTO_DENSITY_ENABLE = dis.readInt();
					
			        this.AUTO_TEMPERATURE_ENABLE = dis.readInt();
					
					this.DDE_LEVEL_ITEM = readString(dis);
					
			        this.AUTO_QUANTITY_ENABLE = dis.readInt();
					
					this.DDE_DENSITY_DSN = readString(dis);
					
			        this.ACTIVITY_STATUS = dis.readInt();
					
					this.DDE_DENSITY_ITEM = readString(dis);
					
					this.DDE_TEMPERATURE_DSN = readString(dis);
					
			        this.RECEIPT_INDICATOR = dis.readInt();
					
					this.DDE_TEMPERATURE_ITEM = readString(dis);
					
					this.LAST_RECEIPT_DATE = readDate(dis);
					
					this.DDE_QUANTITY_DSN = readString(dis);
					
					this.DDE_QUANTITY_ITEM = readString(dis);
					
			        this.SEND_TO_HOST_AT_EOD = dis.readInt();
					
					this.MANUAL_LEVEL = readString(dis);
					
					this.RT_AUTO_LEVEL = readString(dis);
					
					this.EOM_MANUAL_LEVEL = readString(dis);
					
			        this.RT_EOM_GROSS_QUANTITY = dis.readInt();
					
			        this.RT_AUTO_DENSITY = dis.readDouble();
					
			        this.EOM_MANUAL_TEMPERATURE = dis.readDouble();
					
			        this.EOM_MANUAL_DENSITY = dis.readDouble();
					
			        this.EOM_MANUAL_BSW_QUANTITY = dis.readInt();
					
					this.EOM_MANUAL_BSW_LEVEL = readString(dis);
					
			        this.MANUAL_TEMPERATURE = dis.readDouble();
					
			        this.RT_EOM_NET_QUANTITY = dis.readInt();
					
			        this.EOM_MANUAL_COE = dis.readDouble();
					
			        this.RT_EOM_BSW_QUANTITY = dis.readInt();
					
					this.MANUAL_DATE = readDate(dis);
					
					this.BASE_SEDIMENT_WATER_LEVEL = readString(dis);
					
			        this.MANUAL_DENSITY = dis.readDouble();
					
			        this.RT_BSW_QUANTITY = dis.readInt();
					
			        this.MANUAL_SPECIFIC_GRAVITY = dis.readDouble();
					
			        this.PIPE_FILL = dis.readInt();
					
			        this.MANUAL_COEFFICIENT_EXPANSION = dis.readDouble();
					
			        this.PROTOCOL_TYPE = dis.readInt();
					
			        this.RT_AUTO_TEMPERATURE = dis.readDouble();
					
					this.PORT_NAME = readString(dis);
					
			        this.RT_AUTO_QUANTITY = dis.readInt();
					
			        this.ADDRESS = dis.readInt();
					
					this.REMARKS = readString(dis);
					
			        this.FAST_SCAN = dis.readInt();
					
					this.RT_LEVEL = readString(dis);
					
			        this.RT_METER_COUNT = dis.readInt();
					
			        this.RT_GROSS_SNAPSHOT = dis.readInt();
					
			        this.RT_SNAPSHOT_ACTIVE = dis.readInt();
					
					this.RT_LEVEL_SNAPSHOT = readString(dis);
					
			        this.RT_NET_SNAPSHOT = dis.readInt();
					
					this.RT_SNAPSHOT_DATE = readDate(dis);
					
			        this.RT_GROSS_SNAPSHOT_DELTA = dis.readInt();
					
			        this.RT_NET_SNAPSHOT_DELTA = dis.readInt();
					
			        this.RT_EOD_MANUAL_DELTA = dis.readInt();
					
					this.RT_END_LEVEL_SNAPSHOT = readString(dis);
					
			        this.RT_EOD_OPENING_PHYSICAL = dis.readInt();
					
			        this.RT_EOD_BULK_RECEIPTS = dis.readInt();
					
			        this.RT_END_GROSS_SNAPSHOT = dis.readInt();
					
			        this.RT_AVAILABLE_QUANTITY = dis.readInt();
					
			        this.RT_END_NET_SNAPSHOT = dis.readInt();
					
			        this.RT_EOD_BULK_DISPOSALS = dis.readInt();
					
					this.RT_END_SNAPSHOT_DATE = readDate(dis);
					
			        this.RT_EOD_TRANSFERS_IN = dis.readInt();
					
			        this.RT_EOD_RACK_RECEIPTS = dis.readInt();
					
			        this.RT_EOD_TRANSFERS_OUT = dis.readInt();
					
			        this.RT_EOD_RACK_DISPOSALS = dis.readInt();
					
					this.LAST_USER_NAME = readString(dis);
					
					this.LAST_MODIFIED = readDate(dis);
					
			        this.RT_EOD_BOOK_INVENTORY = dis.readInt();
					
					this.USER_DLL = readString(dis);
					
					this.USER_ROUTINE = readString(dis);
					
			        this.ROOF_CORRECTION_TYPE = dis.readInt();
					
					this.ROOF_TAKE_OFF_LEVEL = readString(dis);
					
					this.ROOF_SUPPORT_LEVEL = readString(dis);
					
			        this.ROOF_REFERENCE_DENSITY = dis.readDouble();
					
			        this.ROOF_ABOVE_ADJUSTMENT = dis.readDouble();
					
			        this.RT_EOD_MANUAL_CLOSING_ENABLE = dis.readInt();
					
			        this.ROOF_BELOW_ADJUSTMENT = dis.readDouble();
					
					this.RT_EOD_MANUAL_LEVEL = readString(dis);
					
			        this.STRAPPING_INVERTED = dis.readInt();
					
			        this.RT_EOD_MANUAL_GROSS_QUANTITY = dis.readInt();
					
			        this.RT_EOD_MANUAL_NET_QUANTITY = dis.readInt();
					
			        this.RT_EOD_RACK_FRAC_DISPOSALS = dis.readInt();
					
			        this.RT_EOD_RACK_FRAC_RECEIPTS = dis.readInt();
					
					this.DDE_HIGH_ALARM_DSN = readString(dis);
					
					this.DDE_HIGH_ALARM_ITEM = readString(dis);
					
					this.DDE_HIGH_HIGH_ALARM_DSN = readString(dis);
					
					this.DDE_HIGH_HIGH_ALARM_ITEM = readString(dis);
					
					this.DDE_LOW_ALARM_DSN = readString(dis);
					
					this.DDE_LOW_ALARM_ITEM = readString(dis);
					
					this.DDE_LOW_LOW_ALARM_DSN = readString(dis);
					
					this.DDE_LOW_LOW_ALARM_ITEM = readString(dis);
					
					this.DDE_CUTOFF_ALARM_DSN = readString(dis);
					
					this.DDE_CUTOFF_ALARM_ITEM = readString(dis);
					
					this.DDE_STATUS_DSN = readString(dis);
					
					this.DDE_STATUS_ITEM = readString(dis);
					
			        this.RT_AUTO_PRESSURE = dis.readDouble();
					
			        this.RT_AUTO_MASS = dis.readInt();
					
			        this.MANUAL_PRESSURE = dis.readDouble();
					
			        this.MANUAL_MASS = dis.readInt();
					
			        this.RT_PRESSURE = dis.readDouble();
					
			        this.RT_MASS = dis.readInt();
					
			        this.AUTO_PRESSURE_ENABLE = dis.readInt();
					
			        this.AUTO_MASS_ENABLE = dis.readInt();
					
			        this.DOWNLOAD_ENABLE = dis.readInt();
					
			        this.DOWNLOAD_LEVEL_ENABLE = dis.readInt();
					
			        this.DOWNLOAD_QUANTITY_ENABLE = dis.readInt();
					
			        this.DOWNLOAD_TEMPERATURE_ENABLE = dis.readInt();
					
			        this.DOWNLOAD_PRESSURE_ENABLE = dis.readInt();
					
			        this.DOWNLOAD_MASS_ENABLE = dis.readInt();
					
			        this.RT_USER_QUEUE_ENABLE = dis.readInt();
					
			        this.RT_USER_CONTEXT_VALUE = dis.readInt();
					
			        this.RT_FRAC_GROSS_SNAPSHOT_DELTA = dis.readInt();
					
			        this.RT_FRAC_NET_SNAPSHOT_DELTA = dis.readInt();
					
			        this.RT_FRAC_EOD_MANUAL_DELTA = dis.readInt();
					
			        this.RT_TEMPERATURE_SNAPSHOT = dis.readDouble();
					
			        this.RT_DENSITY_SNAPSHOT = dis.readDouble();
					
			        this.RT_END_TEMPERATURE_SNAPSHOT = dis.readDouble();
					
			        this.RT_END_DENSITY_SNAPSHOT = dis.readDouble();
					
			        this.RT_FRAC_EOD_TRANSFERS_IN = dis.readInt();
					
			        this.RT_FRAC_EOD_TRANSFERS_OUT = dis.readInt();
					
			        this.MANUAL_QUANTITY_ENABLE = dis.readInt();
					
			        this.MANUAL_BSW_QUANTITY = dis.readInt();
					
			        this.EOM_MANUAL_QUANTITY = dis.readInt();
					
			        this.MANUAL_GROSS_QUANTITY = dis.readInt();
					
			        this.MANUAL_LOW_LOW_QUANTITY = dis.readInt();
					
			        this.MANUAL_LOW_QUANTITY = dis.readInt();
					
			        this.MANUAL_GENERAL_QUANTITY = dis.readInt();
					
			        this.MANUAL_CUTOFF_QUANTITY = dis.readInt();
					
			        this.MANUAL_HIGH_QUANTITY = dis.readInt();
					
			        this.MANUAL_HIGH_HIGH_QUANTITY = dis.readInt();
					
			        this.MANUAL_OBSERVED_DENSITY = dis.readDouble();
					
			        this.RT_OBSERVED_DENSITY = dis.readDouble();
					
			        this.RT_OBS_DENSITY_SNAPSHOT = dis.readDouble();
					
			        this.RT_END_OBS_DENSITY_SNAPSHOT = dis.readDouble();
					
			        this.AUTO_BSW_LEVEL_ENABLE = dis.readInt();
					
			        this.AUTO_BSW_QUANTITY_ENABLE = dis.readInt();
					
					this.RT_AUTO_BSW_LEVEL = readString(dis);
					
			        this.RT_AUTO_BSW_QUANTITY = dis.readInt();
					
					this.RT_BSW_LEVEL = readString(dis);
					
					this.DDE_BSW_LEVEL_DSN = readString(dis);
					
					this.DDE_BSW_LEVEL_ITEM = readString(dis);
					
					this.DDE_BSW_QUANTITY_DSN = readString(dis);
					
					this.DDE_BSW_QUANTITY_ITEM = readString(dis);
					
			        this.DOWNLOAD_DENSITY_ENABLE = dis.readInt();
					
			        this.RT_EOD_ADD_MANUAL_DELTA = dis.readInt();
					
			        this.RT_EOD_ADD_BULK_RECEIPTS = dis.readInt();
					
			        this.RT_EOD_ADD_RACK_RECEIPTS = dis.readInt();
					
			        this.RT_EOD_ADD_TRANSFERS_IN = dis.readInt();
					
			        this.RT_EOD_ADD_BULK_DISPOSALS = dis.readInt();
					
			        this.RT_EOD_ADD_RACK_DISPOSALS = dis.readInt();
					
			        this.RT_EOD_ADD_TRANSFERS_OUT = dis.readInt();
					
			        this.RT_EOD_ADD_BOOK_INVENTORY = dis.readInt();
					
			        this.RT_IN_SERVICE = dis.readInt();
					
			        this.VIRTUAL_TANK = dis.readInt();
					
					this.DDE_IN_SERVICE_ITEM = readString(dis);
					
					this.TANK_GROUP = readString(dis);
					
					this.DDE_IN_SERVICE_DSN = readString(dis);
					
			        this.RT_CUTOFF_QUANTITY = dis.readInt();
					
			        this.AUTO_NET_QUANTITY_ENABLE = dis.readInt();
					
					this.DDE_NET_QUANTITY_ITEM = readString(dis);
					
			        this.RT_AUTO_NET_QUANTITY = dis.readInt();
					
					this.DDE_NET_QUANTITY_DSN = readString(dis);
					
			        this.MANUAL_NET_QUANTITY_ENABLE = dis.readInt();
					
			        this.MANUAL_NET_QUANTITY = dis.readInt();
					
					this.HIGH_BSW_SETPOINT = readString(dis);
					
			        this.HIGH_BSW_QUANTITY = dis.readInt();
					
					this.DDE_BSW_HIGH_ALARM_DSN = readString(dis);
					
					this.DDE_BSW_HIGH_ALARM_ITEM = readString(dis);
					
			        this.RT_EOD_BULK_FRAC_DISPOSALS = dis.readInt();
					
			        this.RT_EOD_BULK_FRAC_RECEIPTS = dis.readInt();
					
					this.RT_EOD_OPEN_BSW_LEVEL = readString(dis);
					
			        this.RT_EOD_OPEN_DENSITY = dis.readDouble();
					
			        this.RT_EOD_OPEN_TEMPERATURE = dis.readDouble();
					
			        this.RT_EOD_OPEN_BSW_QUANTITY = dis.readInt();
					
					this.RT_EOD_OPEN_LEVEL = readString(dis);
					
			        this.RT_EOD_OPEN_OBSERVED_DENSITY = dis.readDouble();
					
			        this.RT_EOD_OPEN_PHYS_GROSS_QTY = dis.readInt();
					
					this.PREV_EOD_LEVEL = readString(dis);
					
			        this.PREV_EOD_GROSS_QUANTITY = dis.readInt();
					
			        this.PREV_EOD_TEMPERATURE = dis.readDouble();
					
			        this.PREV_EOD_DENSITY = dis.readDouble();
					
			        this.PREV_EOD_BSW_QUANTITY = dis.readInt();
					
					this.PREV_EOD_BSW_LEVEL = readString(dis);
					
			        this.RT_PREV_EOD_NET_QUANTITY = dis.readInt();
					
			        this.PREV_EOD_COE = dis.readDouble();
					
			        this.RT_PREV_EOD_BSW_QUANTITY = dis.readInt();
					
			        this.PREV_EOD_QUANTITY = dis.readInt();
					
			        this.OPENING_COE = dis.readDouble();
					
			        this.RT_TOV = dis.readInt();
					
			        this.RT_GOV = dis.readInt();
					
			        this.RT_GSV = dis.readInt();
					
			        this.RT_TCV = dis.readInt();
					
			        this.RT_SHELL_CORRECTION_FACTOR = dis.readDouble();
					
			        this.RT_FLOATING_ROOF_ADJUSTMENT = dis.readInt();
					
			        this.RT_CTL = dis.readDouble();
					
			        this.SUSPENDED_BSW_PERCENT = dis.readDouble();
					
			        this.MANUAL_STRAP_TYPE = dis.readInt();
					
			        this.ROOF_TAKE_OFF_STRAP_TYPE = dis.readInt();
					
			        this.ROOF_SUPPORT_STRAP_TYPE = dis.readInt();
					
			        this.HIGH_BSW_STRAP_TYPE = dis.readInt();
					
			        this.BASE_SEDIMENT_WATER_STRAP_TYPE = dis.readInt();
					
					this.GAUGER_INITIALS = readString(dis);
					
					this.GAUGE_TIMESTAMP = readDate(dis);
					
			        this.LEVEL_UNITS = dis.readInt();
					
			        this.SHELL_BASE_TEMPERATURE = dis.readDouble();
					
			        this.SHELL_MATERIAL_TYPE = dis.readInt();
					
			        this.MANUAL_AMBIENT_TEMPERATURE = dis.readDouble();
					
			        this.INSULATED = dis.readInt();
					
			        this.LINE_SEGMENT_NSV = dis.readInt();
					
			        this.RT_CALCULATION_POINT = dis.readInt();
					
			        this.ROOF_TAKE_OFF_TOV = dis.readInt();
					
			        this.RT_NSV = dis.readInt();
					
			        this.RT_GSW = dis.readInt();
					
			        this.RT_NSW = dis.readInt();
					
			        this.RT_WCF = dis.readDouble();
					
			        this.LINE_SEGMENT_NSW = dis.readInt();
					
			        this.ROOF_WEIGHT = dis.readDouble();
					
			        this.VOL_IN_ALARM = dis.readInt();
					
			        this.INACTIVITY_QUANTITY = dis.readInt();
					
			        this.INACTIVITY_ALARM_STATE = dis.readInt();
					
			        this.USER_LEVEL = dis.readInt();
					
					this.SCHED_PROD_CHANGE_DATE_TIME = readDate(dis);
					
			        this.SCHED_PROD_CHANGE_TIMEOUT = dis.readInt();
					
					this.SCHED_PROD_CHANGE_EMAIL = readString(dis);
					
			        this.SETPOINT_QUANTITY_ENABLE = dis.readInt();
					
			        this.MANUAL_MEASURED_DENSITY = dis.readDouble();
					
			        this.WEIGHT_IN_AIR = dis.readInt();
					
			        this.TOPS_MONITORING_ACTIVE = dis.readInt();
					
			        this.SHAPE = dis.readInt();
					
			        this.ACTUAL_FLOW_RATE_PERIOD = dis.readInt();
					
			        this.CALCULATED_FLOW_RATE_PERIOD = dis.readInt();
					
			        this.FLOW_RATE_CLAMPING_PERIOD = dis.readInt();
					
					this.RT_CLAMPING_PERIOD_START = readDate(dis);
					
			        this.VAPOR_CORRECTION_METHOD = dis.readInt();
					
			        this.VAPOR_TEMPERATURE = dis.readDouble();
					
			        this.VAPOR_LIQUID_VOLUME_RATIO = dis.readDouble();
					
			        this.TARGET_LEVEL = dis.readInt();
					
			        this.ORIGINAL_STARTING_LEVEL = dis.readInt();
					
			        this.TIME_TO_TARGET_LEVEL = dis.readInt();
					
			        this.AUTO_VAPOR_TEMPERATURE_ENABLE = dis.readInt();
					
					this.DDE_PRESSURE_DSN = readString(dis);
					
					this.DDE_PRESSURE_ITEM = readString(dis);
					
					this.DDE_VAPOR_TEMPERATURE_DSN = readString(dis);
					
					this.DDE_VAPOR_TEMPERATURE_ITEM = readString(dis);
					
			        this.RT_AUTO_VAPOR_TEMPERATURE = dis.readDouble();
					
			        this.RT_VAPOR_TEMPERATURE = dis.readDouble();
					
			        this.INVENTORY_ENABLE = dis.readInt();
					
			        this.MANUAL_TO_AUTO_FOLIO_LIMIT = dis.readInt();
					
			        this.RT_MANUAL_TO_AUTO_FOLIO_COUNT = dis.readInt();
					
			        this.RT_LEVEL_ORIGIN = dis.readInt();
					
			        this.RT_TOV_ORIGIN = dis.readInt();
					
			        this.RT_TEMPERATURE_ORIGIN = dis.readInt();
					
			        this.RT_DENSITY_ORIGIN = dis.readInt();
					
			        this.RT_NSV_ORIGIN = dis.readInt();
					
			        this.RT_VAPOR_TEMPERATURE_ORIGIN = dis.readInt();
					
			        this.RT_PRESSURE_ORIGIN = dis.readInt();
					
			        this.RT_FREE_WATER_LEVEL_ORIGIN = dis.readInt();
					
			        this.RT_WATER_QUANTITY_ORIGIN = dis.readInt();
					
					this.DDE_SNAPSHOT_REQ_DSN = readString(dis);
					
					this.DDE_SNAPSHOT_REQ_ITEM = readString(dis);
					
					this.DDE_SNAPSHOT_RSP_DSN = readString(dis);
					
					this.DDE_SNAPSHOT_RSP_ITEM = readString(dis);
					
			        this.AUTO_PRODUCT_LEVEL_UNIT = dis.readInt();
					
			        this.AUTO_FREE_WATER_LEVEL_UNIT = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.TANK_CODE,dos);
					
					// String
				
						writeString(this.NAME,dos);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_OWNER_ID,dos);
					
					// Integer
				
						writeInteger(this.MAJORITY_SHAREHOLDER,dos);
					
					// String
				
						writeString(this.COMPARTMENT_CONTAINER_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.RT_GROSS_QUANTITY);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_CONTAINER_TYPE,dos);
					
					// int
				
		            	dos.writeInt(this.TERMINAL_PRODUCT_NUMBER);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.RT_NET_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.ENABLE);
					
					// Integer
				
						writeInteger(this.SCHED_PROD_CHANGE_PRODUCT,dos);
					
					// double
				
		            	dos.writeDouble(this.RVP);
					
					// double
				
		            	dos.writeDouble(this.OXYGEN);
					
					// double
				
		            	dos.writeDouble(this.RT_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.RT_DENSITY);
					
					// int
				
		            	dos.writeInt(this.SHELL_CAPACITY);
					
					// int
				
		            	dos.writeInt(this.WORK_CAPACITY);
					
					// String
				
						writeString(this.DEPTH,dos);
					
					// String
				
						writeString(this.LOW_LOW_SETPOINT,dos);
					
					// String
				
						writeString(this.LOW_SETPOINT,dos);
					
					// String
				
						writeString(this.GENERAL_SETPOINT,dos);
					
					// String
				
						writeString(this.CUTOFF_SETPOINT,dos);
					
					// int
				
		            	dos.writeInt(this.AUTO_ENABLE);
					
					// String
				
						writeString(this.HIGH_SETPOINT,dos);
					
					// String
				
						writeString(this.HIGH_HIGH_SETPOINT,dos);
					
					// int
				
		            	dos.writeInt(this.DEADBAND);
					
					// int
				
		            	dos.writeInt(this.AUTO_LEVEL_ENABLE);
					
					// String
				
						writeString(this.DDE_LEVEL_DSN,dos);
					
					// int
				
		            	dos.writeInt(this.AUTO_DENSITY_ENABLE);
					
					// int
				
		            	dos.writeInt(this.AUTO_TEMPERATURE_ENABLE);
					
					// String
				
						writeString(this.DDE_LEVEL_ITEM,dos);
					
					// int
				
		            	dos.writeInt(this.AUTO_QUANTITY_ENABLE);
					
					// String
				
						writeString(this.DDE_DENSITY_DSN,dos);
					
					// int
				
		            	dos.writeInt(this.ACTIVITY_STATUS);
					
					// String
				
						writeString(this.DDE_DENSITY_ITEM,dos);
					
					// String
				
						writeString(this.DDE_TEMPERATURE_DSN,dos);
					
					// int
				
		            	dos.writeInt(this.RECEIPT_INDICATOR);
					
					// String
				
						writeString(this.DDE_TEMPERATURE_ITEM,dos);
					
					// java.util.Date
				
						writeDate(this.LAST_RECEIPT_DATE,dos);
					
					// String
				
						writeString(this.DDE_QUANTITY_DSN,dos);
					
					// String
				
						writeString(this.DDE_QUANTITY_ITEM,dos);
					
					// int
				
		            	dos.writeInt(this.SEND_TO_HOST_AT_EOD);
					
					// String
				
						writeString(this.MANUAL_LEVEL,dos);
					
					// String
				
						writeString(this.RT_AUTO_LEVEL,dos);
					
					// String
				
						writeString(this.EOM_MANUAL_LEVEL,dos);
					
					// int
				
		            	dos.writeInt(this.RT_EOM_GROSS_QUANTITY);
					
					// double
				
		            	dos.writeDouble(this.RT_AUTO_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.EOM_MANUAL_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.EOM_MANUAL_DENSITY);
					
					// int
				
		            	dos.writeInt(this.EOM_MANUAL_BSW_QUANTITY);
					
					// String
				
						writeString(this.EOM_MANUAL_BSW_LEVEL,dos);
					
					// double
				
		            	dos.writeDouble(this.MANUAL_TEMPERATURE);
					
					// int
				
		            	dos.writeInt(this.RT_EOM_NET_QUANTITY);
					
					// double
				
		            	dos.writeDouble(this.EOM_MANUAL_COE);
					
					// int
				
		            	dos.writeInt(this.RT_EOM_BSW_QUANTITY);
					
					// java.util.Date
				
						writeDate(this.MANUAL_DATE,dos);
					
					// String
				
						writeString(this.BASE_SEDIMENT_WATER_LEVEL,dos);
					
					// double
				
		            	dos.writeDouble(this.MANUAL_DENSITY);
					
					// int
				
		            	dos.writeInt(this.RT_BSW_QUANTITY);
					
					// double
				
		            	dos.writeDouble(this.MANUAL_SPECIFIC_GRAVITY);
					
					// int
				
		            	dos.writeInt(this.PIPE_FILL);
					
					// double
				
		            	dos.writeDouble(this.MANUAL_COEFFICIENT_EXPANSION);
					
					// int
				
		            	dos.writeInt(this.PROTOCOL_TYPE);
					
					// double
				
		            	dos.writeDouble(this.RT_AUTO_TEMPERATURE);
					
					// String
				
						writeString(this.PORT_NAME,dos);
					
					// int
				
		            	dos.writeInt(this.RT_AUTO_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.ADDRESS);
					
					// String
				
						writeString(this.REMARKS,dos);
					
					// int
				
		            	dos.writeInt(this.FAST_SCAN);
					
					// String
				
						writeString(this.RT_LEVEL,dos);
					
					// int
				
		            	dos.writeInt(this.RT_METER_COUNT);
					
					// int
				
		            	dos.writeInt(this.RT_GROSS_SNAPSHOT);
					
					// int
				
		            	dos.writeInt(this.RT_SNAPSHOT_ACTIVE);
					
					// String
				
						writeString(this.RT_LEVEL_SNAPSHOT,dos);
					
					// int
				
		            	dos.writeInt(this.RT_NET_SNAPSHOT);
					
					// java.util.Date
				
						writeDate(this.RT_SNAPSHOT_DATE,dos);
					
					// int
				
		            	dos.writeInt(this.RT_GROSS_SNAPSHOT_DELTA);
					
					// int
				
		            	dos.writeInt(this.RT_NET_SNAPSHOT_DELTA);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_MANUAL_DELTA);
					
					// String
				
						writeString(this.RT_END_LEVEL_SNAPSHOT,dos);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_OPENING_PHYSICAL);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_BULK_RECEIPTS);
					
					// int
				
		            	dos.writeInt(this.RT_END_GROSS_SNAPSHOT);
					
					// int
				
		            	dos.writeInt(this.RT_AVAILABLE_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.RT_END_NET_SNAPSHOT);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_BULK_DISPOSALS);
					
					// java.util.Date
				
						writeDate(this.RT_END_SNAPSHOT_DATE,dos);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_TRANSFERS_IN);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_RACK_RECEIPTS);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_TRANSFERS_OUT);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_RACK_DISPOSALS);
					
					// String
				
						writeString(this.LAST_USER_NAME,dos);
					
					// java.util.Date
				
						writeDate(this.LAST_MODIFIED,dos);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_BOOK_INVENTORY);
					
					// String
				
						writeString(this.USER_DLL,dos);
					
					// String
				
						writeString(this.USER_ROUTINE,dos);
					
					// int
				
		            	dos.writeInt(this.ROOF_CORRECTION_TYPE);
					
					// String
				
						writeString(this.ROOF_TAKE_OFF_LEVEL,dos);
					
					// String
				
						writeString(this.ROOF_SUPPORT_LEVEL,dos);
					
					// double
				
		            	dos.writeDouble(this.ROOF_REFERENCE_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.ROOF_ABOVE_ADJUSTMENT);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_MANUAL_CLOSING_ENABLE);
					
					// double
				
		            	dos.writeDouble(this.ROOF_BELOW_ADJUSTMENT);
					
					// String
				
						writeString(this.RT_EOD_MANUAL_LEVEL,dos);
					
					// int
				
		            	dos.writeInt(this.STRAPPING_INVERTED);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_MANUAL_GROSS_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_MANUAL_NET_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_RACK_FRAC_DISPOSALS);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_RACK_FRAC_RECEIPTS);
					
					// String
				
						writeString(this.DDE_HIGH_ALARM_DSN,dos);
					
					// String
				
						writeString(this.DDE_HIGH_ALARM_ITEM,dos);
					
					// String
				
						writeString(this.DDE_HIGH_HIGH_ALARM_DSN,dos);
					
					// String
				
						writeString(this.DDE_HIGH_HIGH_ALARM_ITEM,dos);
					
					// String
				
						writeString(this.DDE_LOW_ALARM_DSN,dos);
					
					// String
				
						writeString(this.DDE_LOW_ALARM_ITEM,dos);
					
					// String
				
						writeString(this.DDE_LOW_LOW_ALARM_DSN,dos);
					
					// String
				
						writeString(this.DDE_LOW_LOW_ALARM_ITEM,dos);
					
					// String
				
						writeString(this.DDE_CUTOFF_ALARM_DSN,dos);
					
					// String
				
						writeString(this.DDE_CUTOFF_ALARM_ITEM,dos);
					
					// String
				
						writeString(this.DDE_STATUS_DSN,dos);
					
					// String
				
						writeString(this.DDE_STATUS_ITEM,dos);
					
					// double
				
		            	dos.writeDouble(this.RT_AUTO_PRESSURE);
					
					// int
				
		            	dos.writeInt(this.RT_AUTO_MASS);
					
					// double
				
		            	dos.writeDouble(this.MANUAL_PRESSURE);
					
					// int
				
		            	dos.writeInt(this.MANUAL_MASS);
					
					// double
				
		            	dos.writeDouble(this.RT_PRESSURE);
					
					// int
				
		            	dos.writeInt(this.RT_MASS);
					
					// int
				
		            	dos.writeInt(this.AUTO_PRESSURE_ENABLE);
					
					// int
				
		            	dos.writeInt(this.AUTO_MASS_ENABLE);
					
					// int
				
		            	dos.writeInt(this.DOWNLOAD_ENABLE);
					
					// int
				
		            	dos.writeInt(this.DOWNLOAD_LEVEL_ENABLE);
					
					// int
				
		            	dos.writeInt(this.DOWNLOAD_QUANTITY_ENABLE);
					
					// int
				
		            	dos.writeInt(this.DOWNLOAD_TEMPERATURE_ENABLE);
					
					// int
				
		            	dos.writeInt(this.DOWNLOAD_PRESSURE_ENABLE);
					
					// int
				
		            	dos.writeInt(this.DOWNLOAD_MASS_ENABLE);
					
					// int
				
		            	dos.writeInt(this.RT_USER_QUEUE_ENABLE);
					
					// int
				
		            	dos.writeInt(this.RT_USER_CONTEXT_VALUE);
					
					// int
				
		            	dos.writeInt(this.RT_FRAC_GROSS_SNAPSHOT_DELTA);
					
					// int
				
		            	dos.writeInt(this.RT_FRAC_NET_SNAPSHOT_DELTA);
					
					// int
				
		            	dos.writeInt(this.RT_FRAC_EOD_MANUAL_DELTA);
					
					// double
				
		            	dos.writeDouble(this.RT_TEMPERATURE_SNAPSHOT);
					
					// double
				
		            	dos.writeDouble(this.RT_DENSITY_SNAPSHOT);
					
					// double
				
		            	dos.writeDouble(this.RT_END_TEMPERATURE_SNAPSHOT);
					
					// double
				
		            	dos.writeDouble(this.RT_END_DENSITY_SNAPSHOT);
					
					// int
				
		            	dos.writeInt(this.RT_FRAC_EOD_TRANSFERS_IN);
					
					// int
				
		            	dos.writeInt(this.RT_FRAC_EOD_TRANSFERS_OUT);
					
					// int
				
		            	dos.writeInt(this.MANUAL_QUANTITY_ENABLE);
					
					// int
				
		            	dos.writeInt(this.MANUAL_BSW_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.EOM_MANUAL_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.MANUAL_GROSS_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.MANUAL_LOW_LOW_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.MANUAL_LOW_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.MANUAL_GENERAL_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.MANUAL_CUTOFF_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.MANUAL_HIGH_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.MANUAL_HIGH_HIGH_QUANTITY);
					
					// double
				
		            	dos.writeDouble(this.MANUAL_OBSERVED_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.RT_OBSERVED_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.RT_OBS_DENSITY_SNAPSHOT);
					
					// double
				
		            	dos.writeDouble(this.RT_END_OBS_DENSITY_SNAPSHOT);
					
					// int
				
		            	dos.writeInt(this.AUTO_BSW_LEVEL_ENABLE);
					
					// int
				
		            	dos.writeInt(this.AUTO_BSW_QUANTITY_ENABLE);
					
					// String
				
						writeString(this.RT_AUTO_BSW_LEVEL,dos);
					
					// int
				
		            	dos.writeInt(this.RT_AUTO_BSW_QUANTITY);
					
					// String
				
						writeString(this.RT_BSW_LEVEL,dos);
					
					// String
				
						writeString(this.DDE_BSW_LEVEL_DSN,dos);
					
					// String
				
						writeString(this.DDE_BSW_LEVEL_ITEM,dos);
					
					// String
				
						writeString(this.DDE_BSW_QUANTITY_DSN,dos);
					
					// String
				
						writeString(this.DDE_BSW_QUANTITY_ITEM,dos);
					
					// int
				
		            	dos.writeInt(this.DOWNLOAD_DENSITY_ENABLE);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_ADD_MANUAL_DELTA);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_ADD_BULK_RECEIPTS);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_ADD_RACK_RECEIPTS);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_ADD_TRANSFERS_IN);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_ADD_BULK_DISPOSALS);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_ADD_RACK_DISPOSALS);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_ADD_TRANSFERS_OUT);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_ADD_BOOK_INVENTORY);
					
					// int
				
		            	dos.writeInt(this.RT_IN_SERVICE);
					
					// int
				
		            	dos.writeInt(this.VIRTUAL_TANK);
					
					// String
				
						writeString(this.DDE_IN_SERVICE_ITEM,dos);
					
					// String
				
						writeString(this.TANK_GROUP,dos);
					
					// String
				
						writeString(this.DDE_IN_SERVICE_DSN,dos);
					
					// int
				
		            	dos.writeInt(this.RT_CUTOFF_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.AUTO_NET_QUANTITY_ENABLE);
					
					// String
				
						writeString(this.DDE_NET_QUANTITY_ITEM,dos);
					
					// int
				
		            	dos.writeInt(this.RT_AUTO_NET_QUANTITY);
					
					// String
				
						writeString(this.DDE_NET_QUANTITY_DSN,dos);
					
					// int
				
		            	dos.writeInt(this.MANUAL_NET_QUANTITY_ENABLE);
					
					// int
				
		            	dos.writeInt(this.MANUAL_NET_QUANTITY);
					
					// String
				
						writeString(this.HIGH_BSW_SETPOINT,dos);
					
					// int
				
		            	dos.writeInt(this.HIGH_BSW_QUANTITY);
					
					// String
				
						writeString(this.DDE_BSW_HIGH_ALARM_DSN,dos);
					
					// String
				
						writeString(this.DDE_BSW_HIGH_ALARM_ITEM,dos);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_BULK_FRAC_DISPOSALS);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_BULK_FRAC_RECEIPTS);
					
					// String
				
						writeString(this.RT_EOD_OPEN_BSW_LEVEL,dos);
					
					// double
				
		            	dos.writeDouble(this.RT_EOD_OPEN_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.RT_EOD_OPEN_TEMPERATURE);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_OPEN_BSW_QUANTITY);
					
					// String
				
						writeString(this.RT_EOD_OPEN_LEVEL,dos);
					
					// double
				
		            	dos.writeDouble(this.RT_EOD_OPEN_OBSERVED_DENSITY);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_OPEN_PHYS_GROSS_QTY);
					
					// String
				
						writeString(this.PREV_EOD_LEVEL,dos);
					
					// int
				
		            	dos.writeInt(this.PREV_EOD_GROSS_QUANTITY);
					
					// double
				
		            	dos.writeDouble(this.PREV_EOD_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.PREV_EOD_DENSITY);
					
					// int
				
		            	dos.writeInt(this.PREV_EOD_BSW_QUANTITY);
					
					// String
				
						writeString(this.PREV_EOD_BSW_LEVEL,dos);
					
					// int
				
		            	dos.writeInt(this.RT_PREV_EOD_NET_QUANTITY);
					
					// double
				
		            	dos.writeDouble(this.PREV_EOD_COE);
					
					// int
				
		            	dos.writeInt(this.RT_PREV_EOD_BSW_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.PREV_EOD_QUANTITY);
					
					// double
				
		            	dos.writeDouble(this.OPENING_COE);
					
					// int
				
		            	dos.writeInt(this.RT_TOV);
					
					// int
				
		            	dos.writeInt(this.RT_GOV);
					
					// int
				
		            	dos.writeInt(this.RT_GSV);
					
					// int
				
		            	dos.writeInt(this.RT_TCV);
					
					// double
				
		            	dos.writeDouble(this.RT_SHELL_CORRECTION_FACTOR);
					
					// int
				
		            	dos.writeInt(this.RT_FLOATING_ROOF_ADJUSTMENT);
					
					// double
				
		            	dos.writeDouble(this.RT_CTL);
					
					// double
				
		            	dos.writeDouble(this.SUSPENDED_BSW_PERCENT);
					
					// int
				
		            	dos.writeInt(this.MANUAL_STRAP_TYPE);
					
					// int
				
		            	dos.writeInt(this.ROOF_TAKE_OFF_STRAP_TYPE);
					
					// int
				
		            	dos.writeInt(this.ROOF_SUPPORT_STRAP_TYPE);
					
					// int
				
		            	dos.writeInt(this.HIGH_BSW_STRAP_TYPE);
					
					// int
				
		            	dos.writeInt(this.BASE_SEDIMENT_WATER_STRAP_TYPE);
					
					// String
				
						writeString(this.GAUGER_INITIALS,dos);
					
					// java.util.Date
				
						writeDate(this.GAUGE_TIMESTAMP,dos);
					
					// int
				
		            	dos.writeInt(this.LEVEL_UNITS);
					
					// double
				
		            	dos.writeDouble(this.SHELL_BASE_TEMPERATURE);
					
					// int
				
		            	dos.writeInt(this.SHELL_MATERIAL_TYPE);
					
					// double
				
		            	dos.writeDouble(this.MANUAL_AMBIENT_TEMPERATURE);
					
					// int
				
		            	dos.writeInt(this.INSULATED);
					
					// int
				
		            	dos.writeInt(this.LINE_SEGMENT_NSV);
					
					// int
				
		            	dos.writeInt(this.RT_CALCULATION_POINT);
					
					// int
				
		            	dos.writeInt(this.ROOF_TAKE_OFF_TOV);
					
					// int
				
		            	dos.writeInt(this.RT_NSV);
					
					// int
				
		            	dos.writeInt(this.RT_GSW);
					
					// int
				
		            	dos.writeInt(this.RT_NSW);
					
					// double
				
		            	dos.writeDouble(this.RT_WCF);
					
					// int
				
		            	dos.writeInt(this.LINE_SEGMENT_NSW);
					
					// double
				
		            	dos.writeDouble(this.ROOF_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.VOL_IN_ALARM);
					
					// int
				
		            	dos.writeInt(this.INACTIVITY_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.INACTIVITY_ALARM_STATE);
					
					// int
				
		            	dos.writeInt(this.USER_LEVEL);
					
					// java.util.Date
				
						writeDate(this.SCHED_PROD_CHANGE_DATE_TIME,dos);
					
					// int
				
		            	dos.writeInt(this.SCHED_PROD_CHANGE_TIMEOUT);
					
					// String
				
						writeString(this.SCHED_PROD_CHANGE_EMAIL,dos);
					
					// int
				
		            	dos.writeInt(this.SETPOINT_QUANTITY_ENABLE);
					
					// double
				
		            	dos.writeDouble(this.MANUAL_MEASURED_DENSITY);
					
					// int
				
		            	dos.writeInt(this.WEIGHT_IN_AIR);
					
					// int
				
		            	dos.writeInt(this.TOPS_MONITORING_ACTIVE);
					
					// int
				
		            	dos.writeInt(this.SHAPE);
					
					// int
				
		            	dos.writeInt(this.ACTUAL_FLOW_RATE_PERIOD);
					
					// int
				
		            	dos.writeInt(this.CALCULATED_FLOW_RATE_PERIOD);
					
					// int
				
		            	dos.writeInt(this.FLOW_RATE_CLAMPING_PERIOD);
					
					// java.util.Date
				
						writeDate(this.RT_CLAMPING_PERIOD_START,dos);
					
					// int
				
		            	dos.writeInt(this.VAPOR_CORRECTION_METHOD);
					
					// double
				
		            	dos.writeDouble(this.VAPOR_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.VAPOR_LIQUID_VOLUME_RATIO);
					
					// int
				
		            	dos.writeInt(this.TARGET_LEVEL);
					
					// int
				
		            	dos.writeInt(this.ORIGINAL_STARTING_LEVEL);
					
					// int
				
		            	dos.writeInt(this.TIME_TO_TARGET_LEVEL);
					
					// int
				
		            	dos.writeInt(this.AUTO_VAPOR_TEMPERATURE_ENABLE);
					
					// String
				
						writeString(this.DDE_PRESSURE_DSN,dos);
					
					// String
				
						writeString(this.DDE_PRESSURE_ITEM,dos);
					
					// String
				
						writeString(this.DDE_VAPOR_TEMPERATURE_DSN,dos);
					
					// String
				
						writeString(this.DDE_VAPOR_TEMPERATURE_ITEM,dos);
					
					// double
				
		            	dos.writeDouble(this.RT_AUTO_VAPOR_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.RT_VAPOR_TEMPERATURE);
					
					// int
				
		            	dos.writeInt(this.INVENTORY_ENABLE);
					
					// int
				
		            	dos.writeInt(this.MANUAL_TO_AUTO_FOLIO_LIMIT);
					
					// int
				
		            	dos.writeInt(this.RT_MANUAL_TO_AUTO_FOLIO_COUNT);
					
					// int
				
		            	dos.writeInt(this.RT_LEVEL_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.RT_TOV_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.RT_TEMPERATURE_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.RT_DENSITY_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.RT_NSV_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.RT_VAPOR_TEMPERATURE_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.RT_PRESSURE_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.RT_FREE_WATER_LEVEL_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.RT_WATER_QUANTITY_ORIGIN);
					
					// String
				
						writeString(this.DDE_SNAPSHOT_REQ_DSN,dos);
					
					// String
				
						writeString(this.DDE_SNAPSHOT_REQ_ITEM,dos);
					
					// String
				
						writeString(this.DDE_SNAPSHOT_RSP_DSN,dos);
					
					// String
				
						writeString(this.DDE_SNAPSHOT_RSP_ITEM,dos);
					
					// int
				
		            	dos.writeInt(this.AUTO_PRODUCT_LEVEL_UNIT);
					
					// int
				
		            	dos.writeInt(this.AUTO_FREE_WATER_LEVEL_UNIT);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.TANK_CODE,dos);
					
					// String
				
						writeString(this.NAME,dos);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_OWNER_ID,dos);
					
					// Integer
				
						writeInteger(this.MAJORITY_SHAREHOLDER,dos);
					
					// String
				
						writeString(this.COMPARTMENT_CONTAINER_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.RT_GROSS_QUANTITY);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_CONTAINER_TYPE,dos);
					
					// int
				
		            	dos.writeInt(this.TERMINAL_PRODUCT_NUMBER);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.RT_NET_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.ENABLE);
					
					// Integer
				
						writeInteger(this.SCHED_PROD_CHANGE_PRODUCT,dos);
					
					// double
				
		            	dos.writeDouble(this.RVP);
					
					// double
				
		            	dos.writeDouble(this.OXYGEN);
					
					// double
				
		            	dos.writeDouble(this.RT_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.RT_DENSITY);
					
					// int
				
		            	dos.writeInt(this.SHELL_CAPACITY);
					
					// int
				
		            	dos.writeInt(this.WORK_CAPACITY);
					
					// String
				
						writeString(this.DEPTH,dos);
					
					// String
				
						writeString(this.LOW_LOW_SETPOINT,dos);
					
					// String
				
						writeString(this.LOW_SETPOINT,dos);
					
					// String
				
						writeString(this.GENERAL_SETPOINT,dos);
					
					// String
				
						writeString(this.CUTOFF_SETPOINT,dos);
					
					// int
				
		            	dos.writeInt(this.AUTO_ENABLE);
					
					// String
				
						writeString(this.HIGH_SETPOINT,dos);
					
					// String
				
						writeString(this.HIGH_HIGH_SETPOINT,dos);
					
					// int
				
		            	dos.writeInt(this.DEADBAND);
					
					// int
				
		            	dos.writeInt(this.AUTO_LEVEL_ENABLE);
					
					// String
				
						writeString(this.DDE_LEVEL_DSN,dos);
					
					// int
				
		            	dos.writeInt(this.AUTO_DENSITY_ENABLE);
					
					// int
				
		            	dos.writeInt(this.AUTO_TEMPERATURE_ENABLE);
					
					// String
				
						writeString(this.DDE_LEVEL_ITEM,dos);
					
					// int
				
		            	dos.writeInt(this.AUTO_QUANTITY_ENABLE);
					
					// String
				
						writeString(this.DDE_DENSITY_DSN,dos);
					
					// int
				
		            	dos.writeInt(this.ACTIVITY_STATUS);
					
					// String
				
						writeString(this.DDE_DENSITY_ITEM,dos);
					
					// String
				
						writeString(this.DDE_TEMPERATURE_DSN,dos);
					
					// int
				
		            	dos.writeInt(this.RECEIPT_INDICATOR);
					
					// String
				
						writeString(this.DDE_TEMPERATURE_ITEM,dos);
					
					// java.util.Date
				
						writeDate(this.LAST_RECEIPT_DATE,dos);
					
					// String
				
						writeString(this.DDE_QUANTITY_DSN,dos);
					
					// String
				
						writeString(this.DDE_QUANTITY_ITEM,dos);
					
					// int
				
		            	dos.writeInt(this.SEND_TO_HOST_AT_EOD);
					
					// String
				
						writeString(this.MANUAL_LEVEL,dos);
					
					// String
				
						writeString(this.RT_AUTO_LEVEL,dos);
					
					// String
				
						writeString(this.EOM_MANUAL_LEVEL,dos);
					
					// int
				
		            	dos.writeInt(this.RT_EOM_GROSS_QUANTITY);
					
					// double
				
		            	dos.writeDouble(this.RT_AUTO_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.EOM_MANUAL_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.EOM_MANUAL_DENSITY);
					
					// int
				
		            	dos.writeInt(this.EOM_MANUAL_BSW_QUANTITY);
					
					// String
				
						writeString(this.EOM_MANUAL_BSW_LEVEL,dos);
					
					// double
				
		            	dos.writeDouble(this.MANUAL_TEMPERATURE);
					
					// int
				
		            	dos.writeInt(this.RT_EOM_NET_QUANTITY);
					
					// double
				
		            	dos.writeDouble(this.EOM_MANUAL_COE);
					
					// int
				
		            	dos.writeInt(this.RT_EOM_BSW_QUANTITY);
					
					// java.util.Date
				
						writeDate(this.MANUAL_DATE,dos);
					
					// String
				
						writeString(this.BASE_SEDIMENT_WATER_LEVEL,dos);
					
					// double
				
		            	dos.writeDouble(this.MANUAL_DENSITY);
					
					// int
				
		            	dos.writeInt(this.RT_BSW_QUANTITY);
					
					// double
				
		            	dos.writeDouble(this.MANUAL_SPECIFIC_GRAVITY);
					
					// int
				
		            	dos.writeInt(this.PIPE_FILL);
					
					// double
				
		            	dos.writeDouble(this.MANUAL_COEFFICIENT_EXPANSION);
					
					// int
				
		            	dos.writeInt(this.PROTOCOL_TYPE);
					
					// double
				
		            	dos.writeDouble(this.RT_AUTO_TEMPERATURE);
					
					// String
				
						writeString(this.PORT_NAME,dos);
					
					// int
				
		            	dos.writeInt(this.RT_AUTO_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.ADDRESS);
					
					// String
				
						writeString(this.REMARKS,dos);
					
					// int
				
		            	dos.writeInt(this.FAST_SCAN);
					
					// String
				
						writeString(this.RT_LEVEL,dos);
					
					// int
				
		            	dos.writeInt(this.RT_METER_COUNT);
					
					// int
				
		            	dos.writeInt(this.RT_GROSS_SNAPSHOT);
					
					// int
				
		            	dos.writeInt(this.RT_SNAPSHOT_ACTIVE);
					
					// String
				
						writeString(this.RT_LEVEL_SNAPSHOT,dos);
					
					// int
				
		            	dos.writeInt(this.RT_NET_SNAPSHOT);
					
					// java.util.Date
				
						writeDate(this.RT_SNAPSHOT_DATE,dos);
					
					// int
				
		            	dos.writeInt(this.RT_GROSS_SNAPSHOT_DELTA);
					
					// int
				
		            	dos.writeInt(this.RT_NET_SNAPSHOT_DELTA);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_MANUAL_DELTA);
					
					// String
				
						writeString(this.RT_END_LEVEL_SNAPSHOT,dos);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_OPENING_PHYSICAL);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_BULK_RECEIPTS);
					
					// int
				
		            	dos.writeInt(this.RT_END_GROSS_SNAPSHOT);
					
					// int
				
		            	dos.writeInt(this.RT_AVAILABLE_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.RT_END_NET_SNAPSHOT);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_BULK_DISPOSALS);
					
					// java.util.Date
				
						writeDate(this.RT_END_SNAPSHOT_DATE,dos);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_TRANSFERS_IN);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_RACK_RECEIPTS);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_TRANSFERS_OUT);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_RACK_DISPOSALS);
					
					// String
				
						writeString(this.LAST_USER_NAME,dos);
					
					// java.util.Date
				
						writeDate(this.LAST_MODIFIED,dos);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_BOOK_INVENTORY);
					
					// String
				
						writeString(this.USER_DLL,dos);
					
					// String
				
						writeString(this.USER_ROUTINE,dos);
					
					// int
				
		            	dos.writeInt(this.ROOF_CORRECTION_TYPE);
					
					// String
				
						writeString(this.ROOF_TAKE_OFF_LEVEL,dos);
					
					// String
				
						writeString(this.ROOF_SUPPORT_LEVEL,dos);
					
					// double
				
		            	dos.writeDouble(this.ROOF_REFERENCE_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.ROOF_ABOVE_ADJUSTMENT);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_MANUAL_CLOSING_ENABLE);
					
					// double
				
		            	dos.writeDouble(this.ROOF_BELOW_ADJUSTMENT);
					
					// String
				
						writeString(this.RT_EOD_MANUAL_LEVEL,dos);
					
					// int
				
		            	dos.writeInt(this.STRAPPING_INVERTED);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_MANUAL_GROSS_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_MANUAL_NET_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_RACK_FRAC_DISPOSALS);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_RACK_FRAC_RECEIPTS);
					
					// String
				
						writeString(this.DDE_HIGH_ALARM_DSN,dos);
					
					// String
				
						writeString(this.DDE_HIGH_ALARM_ITEM,dos);
					
					// String
				
						writeString(this.DDE_HIGH_HIGH_ALARM_DSN,dos);
					
					// String
				
						writeString(this.DDE_HIGH_HIGH_ALARM_ITEM,dos);
					
					// String
				
						writeString(this.DDE_LOW_ALARM_DSN,dos);
					
					// String
				
						writeString(this.DDE_LOW_ALARM_ITEM,dos);
					
					// String
				
						writeString(this.DDE_LOW_LOW_ALARM_DSN,dos);
					
					// String
				
						writeString(this.DDE_LOW_LOW_ALARM_ITEM,dos);
					
					// String
				
						writeString(this.DDE_CUTOFF_ALARM_DSN,dos);
					
					// String
				
						writeString(this.DDE_CUTOFF_ALARM_ITEM,dos);
					
					// String
				
						writeString(this.DDE_STATUS_DSN,dos);
					
					// String
				
						writeString(this.DDE_STATUS_ITEM,dos);
					
					// double
				
		            	dos.writeDouble(this.RT_AUTO_PRESSURE);
					
					// int
				
		            	dos.writeInt(this.RT_AUTO_MASS);
					
					// double
				
		            	dos.writeDouble(this.MANUAL_PRESSURE);
					
					// int
				
		            	dos.writeInt(this.MANUAL_MASS);
					
					// double
				
		            	dos.writeDouble(this.RT_PRESSURE);
					
					// int
				
		            	dos.writeInt(this.RT_MASS);
					
					// int
				
		            	dos.writeInt(this.AUTO_PRESSURE_ENABLE);
					
					// int
				
		            	dos.writeInt(this.AUTO_MASS_ENABLE);
					
					// int
				
		            	dos.writeInt(this.DOWNLOAD_ENABLE);
					
					// int
				
		            	dos.writeInt(this.DOWNLOAD_LEVEL_ENABLE);
					
					// int
				
		            	dos.writeInt(this.DOWNLOAD_QUANTITY_ENABLE);
					
					// int
				
		            	dos.writeInt(this.DOWNLOAD_TEMPERATURE_ENABLE);
					
					// int
				
		            	dos.writeInt(this.DOWNLOAD_PRESSURE_ENABLE);
					
					// int
				
		            	dos.writeInt(this.DOWNLOAD_MASS_ENABLE);
					
					// int
				
		            	dos.writeInt(this.RT_USER_QUEUE_ENABLE);
					
					// int
				
		            	dos.writeInt(this.RT_USER_CONTEXT_VALUE);
					
					// int
				
		            	dos.writeInt(this.RT_FRAC_GROSS_SNAPSHOT_DELTA);
					
					// int
				
		            	dos.writeInt(this.RT_FRAC_NET_SNAPSHOT_DELTA);
					
					// int
				
		            	dos.writeInt(this.RT_FRAC_EOD_MANUAL_DELTA);
					
					// double
				
		            	dos.writeDouble(this.RT_TEMPERATURE_SNAPSHOT);
					
					// double
				
		            	dos.writeDouble(this.RT_DENSITY_SNAPSHOT);
					
					// double
				
		            	dos.writeDouble(this.RT_END_TEMPERATURE_SNAPSHOT);
					
					// double
				
		            	dos.writeDouble(this.RT_END_DENSITY_SNAPSHOT);
					
					// int
				
		            	dos.writeInt(this.RT_FRAC_EOD_TRANSFERS_IN);
					
					// int
				
		            	dos.writeInt(this.RT_FRAC_EOD_TRANSFERS_OUT);
					
					// int
				
		            	dos.writeInt(this.MANUAL_QUANTITY_ENABLE);
					
					// int
				
		            	dos.writeInt(this.MANUAL_BSW_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.EOM_MANUAL_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.MANUAL_GROSS_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.MANUAL_LOW_LOW_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.MANUAL_LOW_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.MANUAL_GENERAL_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.MANUAL_CUTOFF_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.MANUAL_HIGH_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.MANUAL_HIGH_HIGH_QUANTITY);
					
					// double
				
		            	dos.writeDouble(this.MANUAL_OBSERVED_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.RT_OBSERVED_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.RT_OBS_DENSITY_SNAPSHOT);
					
					// double
				
		            	dos.writeDouble(this.RT_END_OBS_DENSITY_SNAPSHOT);
					
					// int
				
		            	dos.writeInt(this.AUTO_BSW_LEVEL_ENABLE);
					
					// int
				
		            	dos.writeInt(this.AUTO_BSW_QUANTITY_ENABLE);
					
					// String
				
						writeString(this.RT_AUTO_BSW_LEVEL,dos);
					
					// int
				
		            	dos.writeInt(this.RT_AUTO_BSW_QUANTITY);
					
					// String
				
						writeString(this.RT_BSW_LEVEL,dos);
					
					// String
				
						writeString(this.DDE_BSW_LEVEL_DSN,dos);
					
					// String
				
						writeString(this.DDE_BSW_LEVEL_ITEM,dos);
					
					// String
				
						writeString(this.DDE_BSW_QUANTITY_DSN,dos);
					
					// String
				
						writeString(this.DDE_BSW_QUANTITY_ITEM,dos);
					
					// int
				
		            	dos.writeInt(this.DOWNLOAD_DENSITY_ENABLE);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_ADD_MANUAL_DELTA);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_ADD_BULK_RECEIPTS);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_ADD_RACK_RECEIPTS);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_ADD_TRANSFERS_IN);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_ADD_BULK_DISPOSALS);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_ADD_RACK_DISPOSALS);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_ADD_TRANSFERS_OUT);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_ADD_BOOK_INVENTORY);
					
					// int
				
		            	dos.writeInt(this.RT_IN_SERVICE);
					
					// int
				
		            	dos.writeInt(this.VIRTUAL_TANK);
					
					// String
				
						writeString(this.DDE_IN_SERVICE_ITEM,dos);
					
					// String
				
						writeString(this.TANK_GROUP,dos);
					
					// String
				
						writeString(this.DDE_IN_SERVICE_DSN,dos);
					
					// int
				
		            	dos.writeInt(this.RT_CUTOFF_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.AUTO_NET_QUANTITY_ENABLE);
					
					// String
				
						writeString(this.DDE_NET_QUANTITY_ITEM,dos);
					
					// int
				
		            	dos.writeInt(this.RT_AUTO_NET_QUANTITY);
					
					// String
				
						writeString(this.DDE_NET_QUANTITY_DSN,dos);
					
					// int
				
		            	dos.writeInt(this.MANUAL_NET_QUANTITY_ENABLE);
					
					// int
				
		            	dos.writeInt(this.MANUAL_NET_QUANTITY);
					
					// String
				
						writeString(this.HIGH_BSW_SETPOINT,dos);
					
					// int
				
		            	dos.writeInt(this.HIGH_BSW_QUANTITY);
					
					// String
				
						writeString(this.DDE_BSW_HIGH_ALARM_DSN,dos);
					
					// String
				
						writeString(this.DDE_BSW_HIGH_ALARM_ITEM,dos);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_BULK_FRAC_DISPOSALS);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_BULK_FRAC_RECEIPTS);
					
					// String
				
						writeString(this.RT_EOD_OPEN_BSW_LEVEL,dos);
					
					// double
				
		            	dos.writeDouble(this.RT_EOD_OPEN_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.RT_EOD_OPEN_TEMPERATURE);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_OPEN_BSW_QUANTITY);
					
					// String
				
						writeString(this.RT_EOD_OPEN_LEVEL,dos);
					
					// double
				
		            	dos.writeDouble(this.RT_EOD_OPEN_OBSERVED_DENSITY);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_OPEN_PHYS_GROSS_QTY);
					
					// String
				
						writeString(this.PREV_EOD_LEVEL,dos);
					
					// int
				
		            	dos.writeInt(this.PREV_EOD_GROSS_QUANTITY);
					
					// double
				
		            	dos.writeDouble(this.PREV_EOD_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.PREV_EOD_DENSITY);
					
					// int
				
		            	dos.writeInt(this.PREV_EOD_BSW_QUANTITY);
					
					// String
				
						writeString(this.PREV_EOD_BSW_LEVEL,dos);
					
					// int
				
		            	dos.writeInt(this.RT_PREV_EOD_NET_QUANTITY);
					
					// double
				
		            	dos.writeDouble(this.PREV_EOD_COE);
					
					// int
				
		            	dos.writeInt(this.RT_PREV_EOD_BSW_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.PREV_EOD_QUANTITY);
					
					// double
				
		            	dos.writeDouble(this.OPENING_COE);
					
					// int
				
		            	dos.writeInt(this.RT_TOV);
					
					// int
				
		            	dos.writeInt(this.RT_GOV);
					
					// int
				
		            	dos.writeInt(this.RT_GSV);
					
					// int
				
		            	dos.writeInt(this.RT_TCV);
					
					// double
				
		            	dos.writeDouble(this.RT_SHELL_CORRECTION_FACTOR);
					
					// int
				
		            	dos.writeInt(this.RT_FLOATING_ROOF_ADJUSTMENT);
					
					// double
				
		            	dos.writeDouble(this.RT_CTL);
					
					// double
				
		            	dos.writeDouble(this.SUSPENDED_BSW_PERCENT);
					
					// int
				
		            	dos.writeInt(this.MANUAL_STRAP_TYPE);
					
					// int
				
		            	dos.writeInt(this.ROOF_TAKE_OFF_STRAP_TYPE);
					
					// int
				
		            	dos.writeInt(this.ROOF_SUPPORT_STRAP_TYPE);
					
					// int
				
		            	dos.writeInt(this.HIGH_BSW_STRAP_TYPE);
					
					// int
				
		            	dos.writeInt(this.BASE_SEDIMENT_WATER_STRAP_TYPE);
					
					// String
				
						writeString(this.GAUGER_INITIALS,dos);
					
					// java.util.Date
				
						writeDate(this.GAUGE_TIMESTAMP,dos);
					
					// int
				
		            	dos.writeInt(this.LEVEL_UNITS);
					
					// double
				
		            	dos.writeDouble(this.SHELL_BASE_TEMPERATURE);
					
					// int
				
		            	dos.writeInt(this.SHELL_MATERIAL_TYPE);
					
					// double
				
		            	dos.writeDouble(this.MANUAL_AMBIENT_TEMPERATURE);
					
					// int
				
		            	dos.writeInt(this.INSULATED);
					
					// int
				
		            	dos.writeInt(this.LINE_SEGMENT_NSV);
					
					// int
				
		            	dos.writeInt(this.RT_CALCULATION_POINT);
					
					// int
				
		            	dos.writeInt(this.ROOF_TAKE_OFF_TOV);
					
					// int
				
		            	dos.writeInt(this.RT_NSV);
					
					// int
				
		            	dos.writeInt(this.RT_GSW);
					
					// int
				
		            	dos.writeInt(this.RT_NSW);
					
					// double
				
		            	dos.writeDouble(this.RT_WCF);
					
					// int
				
		            	dos.writeInt(this.LINE_SEGMENT_NSW);
					
					// double
				
		            	dos.writeDouble(this.ROOF_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.VOL_IN_ALARM);
					
					// int
				
		            	dos.writeInt(this.INACTIVITY_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.INACTIVITY_ALARM_STATE);
					
					// int
				
		            	dos.writeInt(this.USER_LEVEL);
					
					// java.util.Date
				
						writeDate(this.SCHED_PROD_CHANGE_DATE_TIME,dos);
					
					// int
				
		            	dos.writeInt(this.SCHED_PROD_CHANGE_TIMEOUT);
					
					// String
				
						writeString(this.SCHED_PROD_CHANGE_EMAIL,dos);
					
					// int
				
		            	dos.writeInt(this.SETPOINT_QUANTITY_ENABLE);
					
					// double
				
		            	dos.writeDouble(this.MANUAL_MEASURED_DENSITY);
					
					// int
				
		            	dos.writeInt(this.WEIGHT_IN_AIR);
					
					// int
				
		            	dos.writeInt(this.TOPS_MONITORING_ACTIVE);
					
					// int
				
		            	dos.writeInt(this.SHAPE);
					
					// int
				
		            	dos.writeInt(this.ACTUAL_FLOW_RATE_PERIOD);
					
					// int
				
		            	dos.writeInt(this.CALCULATED_FLOW_RATE_PERIOD);
					
					// int
				
		            	dos.writeInt(this.FLOW_RATE_CLAMPING_PERIOD);
					
					// java.util.Date
				
						writeDate(this.RT_CLAMPING_PERIOD_START,dos);
					
					// int
				
		            	dos.writeInt(this.VAPOR_CORRECTION_METHOD);
					
					// double
				
		            	dos.writeDouble(this.VAPOR_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.VAPOR_LIQUID_VOLUME_RATIO);
					
					// int
				
		            	dos.writeInt(this.TARGET_LEVEL);
					
					// int
				
		            	dos.writeInt(this.ORIGINAL_STARTING_LEVEL);
					
					// int
				
		            	dos.writeInt(this.TIME_TO_TARGET_LEVEL);
					
					// int
				
		            	dos.writeInt(this.AUTO_VAPOR_TEMPERATURE_ENABLE);
					
					// String
				
						writeString(this.DDE_PRESSURE_DSN,dos);
					
					// String
				
						writeString(this.DDE_PRESSURE_ITEM,dos);
					
					// String
				
						writeString(this.DDE_VAPOR_TEMPERATURE_DSN,dos);
					
					// String
				
						writeString(this.DDE_VAPOR_TEMPERATURE_ITEM,dos);
					
					// double
				
		            	dos.writeDouble(this.RT_AUTO_VAPOR_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.RT_VAPOR_TEMPERATURE);
					
					// int
				
		            	dos.writeInt(this.INVENTORY_ENABLE);
					
					// int
				
		            	dos.writeInt(this.MANUAL_TO_AUTO_FOLIO_LIMIT);
					
					// int
				
		            	dos.writeInt(this.RT_MANUAL_TO_AUTO_FOLIO_COUNT);
					
					// int
				
		            	dos.writeInt(this.RT_LEVEL_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.RT_TOV_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.RT_TEMPERATURE_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.RT_DENSITY_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.RT_NSV_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.RT_VAPOR_TEMPERATURE_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.RT_PRESSURE_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.RT_FREE_WATER_LEVEL_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.RT_WATER_QUANTITY_ORIGIN);
					
					// String
				
						writeString(this.DDE_SNAPSHOT_REQ_DSN,dos);
					
					// String
				
						writeString(this.DDE_SNAPSHOT_REQ_ITEM,dos);
					
					// String
				
						writeString(this.DDE_SNAPSHOT_RSP_DSN,dos);
					
					// String
				
						writeString(this.DDE_SNAPSHOT_RSP_ITEM,dos);
					
					// int
				
		            	dos.writeInt(this.AUTO_PRODUCT_LEVEL_UNIT);
					
					// int
				
		            	dos.writeInt(this.AUTO_FREE_WATER_LEVEL_UNIT);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("TANK_CODE="+TANK_CODE);
		sb.append(",NAME="+NAME);
		sb.append(",COMPARTMENT_OWNER_ID="+String.valueOf(COMPARTMENT_OWNER_ID));
		sb.append(",MAJORITY_SHAREHOLDER="+String.valueOf(MAJORITY_SHAREHOLDER));
		sb.append(",COMPARTMENT_CONTAINER_CODE="+COMPARTMENT_CONTAINER_CODE);
		sb.append(",RT_GROSS_QUANTITY="+String.valueOf(RT_GROSS_QUANTITY));
		sb.append(",COMPARTMENT_CONTAINER_TYPE="+String.valueOf(COMPARTMENT_CONTAINER_TYPE));
		sb.append(",TERMINAL_PRODUCT_NUMBER="+String.valueOf(TERMINAL_PRODUCT_NUMBER));
		sb.append(",COMPARTMENT_NUMBER="+String.valueOf(COMPARTMENT_NUMBER));
		sb.append(",RT_NET_QUANTITY="+String.valueOf(RT_NET_QUANTITY));
		sb.append(",ENABLE="+String.valueOf(ENABLE));
		sb.append(",SCHED_PROD_CHANGE_PRODUCT="+String.valueOf(SCHED_PROD_CHANGE_PRODUCT));
		sb.append(",RVP="+String.valueOf(RVP));
		sb.append(",OXYGEN="+String.valueOf(OXYGEN));
		sb.append(",RT_TEMPERATURE="+String.valueOf(RT_TEMPERATURE));
		sb.append(",RT_DENSITY="+String.valueOf(RT_DENSITY));
		sb.append(",SHELL_CAPACITY="+String.valueOf(SHELL_CAPACITY));
		sb.append(",WORK_CAPACITY="+String.valueOf(WORK_CAPACITY));
		sb.append(",DEPTH="+DEPTH);
		sb.append(",LOW_LOW_SETPOINT="+LOW_LOW_SETPOINT);
		sb.append(",LOW_SETPOINT="+LOW_SETPOINT);
		sb.append(",GENERAL_SETPOINT="+GENERAL_SETPOINT);
		sb.append(",CUTOFF_SETPOINT="+CUTOFF_SETPOINT);
		sb.append(",AUTO_ENABLE="+String.valueOf(AUTO_ENABLE));
		sb.append(",HIGH_SETPOINT="+HIGH_SETPOINT);
		sb.append(",HIGH_HIGH_SETPOINT="+HIGH_HIGH_SETPOINT);
		sb.append(",DEADBAND="+String.valueOf(DEADBAND));
		sb.append(",AUTO_LEVEL_ENABLE="+String.valueOf(AUTO_LEVEL_ENABLE));
		sb.append(",DDE_LEVEL_DSN="+DDE_LEVEL_DSN);
		sb.append(",AUTO_DENSITY_ENABLE="+String.valueOf(AUTO_DENSITY_ENABLE));
		sb.append(",AUTO_TEMPERATURE_ENABLE="+String.valueOf(AUTO_TEMPERATURE_ENABLE));
		sb.append(",DDE_LEVEL_ITEM="+DDE_LEVEL_ITEM);
		sb.append(",AUTO_QUANTITY_ENABLE="+String.valueOf(AUTO_QUANTITY_ENABLE));
		sb.append(",DDE_DENSITY_DSN="+DDE_DENSITY_DSN);
		sb.append(",ACTIVITY_STATUS="+String.valueOf(ACTIVITY_STATUS));
		sb.append(",DDE_DENSITY_ITEM="+DDE_DENSITY_ITEM);
		sb.append(",DDE_TEMPERATURE_DSN="+DDE_TEMPERATURE_DSN);
		sb.append(",RECEIPT_INDICATOR="+String.valueOf(RECEIPT_INDICATOR));
		sb.append(",DDE_TEMPERATURE_ITEM="+DDE_TEMPERATURE_ITEM);
		sb.append(",LAST_RECEIPT_DATE="+String.valueOf(LAST_RECEIPT_DATE));
		sb.append(",DDE_QUANTITY_DSN="+DDE_QUANTITY_DSN);
		sb.append(",DDE_QUANTITY_ITEM="+DDE_QUANTITY_ITEM);
		sb.append(",SEND_TO_HOST_AT_EOD="+String.valueOf(SEND_TO_HOST_AT_EOD));
		sb.append(",MANUAL_LEVEL="+MANUAL_LEVEL);
		sb.append(",RT_AUTO_LEVEL="+RT_AUTO_LEVEL);
		sb.append(",EOM_MANUAL_LEVEL="+EOM_MANUAL_LEVEL);
		sb.append(",RT_EOM_GROSS_QUANTITY="+String.valueOf(RT_EOM_GROSS_QUANTITY));
		sb.append(",RT_AUTO_DENSITY="+String.valueOf(RT_AUTO_DENSITY));
		sb.append(",EOM_MANUAL_TEMPERATURE="+String.valueOf(EOM_MANUAL_TEMPERATURE));
		sb.append(",EOM_MANUAL_DENSITY="+String.valueOf(EOM_MANUAL_DENSITY));
		sb.append(",EOM_MANUAL_BSW_QUANTITY="+String.valueOf(EOM_MANUAL_BSW_QUANTITY));
		sb.append(",EOM_MANUAL_BSW_LEVEL="+EOM_MANUAL_BSW_LEVEL);
		sb.append(",MANUAL_TEMPERATURE="+String.valueOf(MANUAL_TEMPERATURE));
		sb.append(",RT_EOM_NET_QUANTITY="+String.valueOf(RT_EOM_NET_QUANTITY));
		sb.append(",EOM_MANUAL_COE="+String.valueOf(EOM_MANUAL_COE));
		sb.append(",RT_EOM_BSW_QUANTITY="+String.valueOf(RT_EOM_BSW_QUANTITY));
		sb.append(",MANUAL_DATE="+String.valueOf(MANUAL_DATE));
		sb.append(",BASE_SEDIMENT_WATER_LEVEL="+BASE_SEDIMENT_WATER_LEVEL);
		sb.append(",MANUAL_DENSITY="+String.valueOf(MANUAL_DENSITY));
		sb.append(",RT_BSW_QUANTITY="+String.valueOf(RT_BSW_QUANTITY));
		sb.append(",MANUAL_SPECIFIC_GRAVITY="+String.valueOf(MANUAL_SPECIFIC_GRAVITY));
		sb.append(",PIPE_FILL="+String.valueOf(PIPE_FILL));
		sb.append(",MANUAL_COEFFICIENT_EXPANSION="+String.valueOf(MANUAL_COEFFICIENT_EXPANSION));
		sb.append(",PROTOCOL_TYPE="+String.valueOf(PROTOCOL_TYPE));
		sb.append(",RT_AUTO_TEMPERATURE="+String.valueOf(RT_AUTO_TEMPERATURE));
		sb.append(",PORT_NAME="+PORT_NAME);
		sb.append(",RT_AUTO_QUANTITY="+String.valueOf(RT_AUTO_QUANTITY));
		sb.append(",ADDRESS="+String.valueOf(ADDRESS));
		sb.append(",REMARKS="+REMARKS);
		sb.append(",FAST_SCAN="+String.valueOf(FAST_SCAN));
		sb.append(",RT_LEVEL="+RT_LEVEL);
		sb.append(",RT_METER_COUNT="+String.valueOf(RT_METER_COUNT));
		sb.append(",RT_GROSS_SNAPSHOT="+String.valueOf(RT_GROSS_SNAPSHOT));
		sb.append(",RT_SNAPSHOT_ACTIVE="+String.valueOf(RT_SNAPSHOT_ACTIVE));
		sb.append(",RT_LEVEL_SNAPSHOT="+RT_LEVEL_SNAPSHOT);
		sb.append(",RT_NET_SNAPSHOT="+String.valueOf(RT_NET_SNAPSHOT));
		sb.append(",RT_SNAPSHOT_DATE="+String.valueOf(RT_SNAPSHOT_DATE));
		sb.append(",RT_GROSS_SNAPSHOT_DELTA="+String.valueOf(RT_GROSS_SNAPSHOT_DELTA));
		sb.append(",RT_NET_SNAPSHOT_DELTA="+String.valueOf(RT_NET_SNAPSHOT_DELTA));
		sb.append(",RT_EOD_MANUAL_DELTA="+String.valueOf(RT_EOD_MANUAL_DELTA));
		sb.append(",RT_END_LEVEL_SNAPSHOT="+RT_END_LEVEL_SNAPSHOT);
		sb.append(",RT_EOD_OPENING_PHYSICAL="+String.valueOf(RT_EOD_OPENING_PHYSICAL));
		sb.append(",RT_EOD_BULK_RECEIPTS="+String.valueOf(RT_EOD_BULK_RECEIPTS));
		sb.append(",RT_END_GROSS_SNAPSHOT="+String.valueOf(RT_END_GROSS_SNAPSHOT));
		sb.append(",RT_AVAILABLE_QUANTITY="+String.valueOf(RT_AVAILABLE_QUANTITY));
		sb.append(",RT_END_NET_SNAPSHOT="+String.valueOf(RT_END_NET_SNAPSHOT));
		sb.append(",RT_EOD_BULK_DISPOSALS="+String.valueOf(RT_EOD_BULK_DISPOSALS));
		sb.append(",RT_END_SNAPSHOT_DATE="+String.valueOf(RT_END_SNAPSHOT_DATE));
		sb.append(",RT_EOD_TRANSFERS_IN="+String.valueOf(RT_EOD_TRANSFERS_IN));
		sb.append(",RT_EOD_RACK_RECEIPTS="+String.valueOf(RT_EOD_RACK_RECEIPTS));
		sb.append(",RT_EOD_TRANSFERS_OUT="+String.valueOf(RT_EOD_TRANSFERS_OUT));
		sb.append(",RT_EOD_RACK_DISPOSALS="+String.valueOf(RT_EOD_RACK_DISPOSALS));
		sb.append(",LAST_USER_NAME="+LAST_USER_NAME);
		sb.append(",LAST_MODIFIED="+String.valueOf(LAST_MODIFIED));
		sb.append(",RT_EOD_BOOK_INVENTORY="+String.valueOf(RT_EOD_BOOK_INVENTORY));
		sb.append(",USER_DLL="+USER_DLL);
		sb.append(",USER_ROUTINE="+USER_ROUTINE);
		sb.append(",ROOF_CORRECTION_TYPE="+String.valueOf(ROOF_CORRECTION_TYPE));
		sb.append(",ROOF_TAKE_OFF_LEVEL="+ROOF_TAKE_OFF_LEVEL);
		sb.append(",ROOF_SUPPORT_LEVEL="+ROOF_SUPPORT_LEVEL);
		sb.append(",ROOF_REFERENCE_DENSITY="+String.valueOf(ROOF_REFERENCE_DENSITY));
		sb.append(",ROOF_ABOVE_ADJUSTMENT="+String.valueOf(ROOF_ABOVE_ADJUSTMENT));
		sb.append(",RT_EOD_MANUAL_CLOSING_ENABLE="+String.valueOf(RT_EOD_MANUAL_CLOSING_ENABLE));
		sb.append(",ROOF_BELOW_ADJUSTMENT="+String.valueOf(ROOF_BELOW_ADJUSTMENT));
		sb.append(",RT_EOD_MANUAL_LEVEL="+RT_EOD_MANUAL_LEVEL);
		sb.append(",STRAPPING_INVERTED="+String.valueOf(STRAPPING_INVERTED));
		sb.append(",RT_EOD_MANUAL_GROSS_QUANTITY="+String.valueOf(RT_EOD_MANUAL_GROSS_QUANTITY));
		sb.append(",RT_EOD_MANUAL_NET_QUANTITY="+String.valueOf(RT_EOD_MANUAL_NET_QUANTITY));
		sb.append(",RT_EOD_RACK_FRAC_DISPOSALS="+String.valueOf(RT_EOD_RACK_FRAC_DISPOSALS));
		sb.append(",RT_EOD_RACK_FRAC_RECEIPTS="+String.valueOf(RT_EOD_RACK_FRAC_RECEIPTS));
		sb.append(",DDE_HIGH_ALARM_DSN="+DDE_HIGH_ALARM_DSN);
		sb.append(",DDE_HIGH_ALARM_ITEM="+DDE_HIGH_ALARM_ITEM);
		sb.append(",DDE_HIGH_HIGH_ALARM_DSN="+DDE_HIGH_HIGH_ALARM_DSN);
		sb.append(",DDE_HIGH_HIGH_ALARM_ITEM="+DDE_HIGH_HIGH_ALARM_ITEM);
		sb.append(",DDE_LOW_ALARM_DSN="+DDE_LOW_ALARM_DSN);
		sb.append(",DDE_LOW_ALARM_ITEM="+DDE_LOW_ALARM_ITEM);
		sb.append(",DDE_LOW_LOW_ALARM_DSN="+DDE_LOW_LOW_ALARM_DSN);
		sb.append(",DDE_LOW_LOW_ALARM_ITEM="+DDE_LOW_LOW_ALARM_ITEM);
		sb.append(",DDE_CUTOFF_ALARM_DSN="+DDE_CUTOFF_ALARM_DSN);
		sb.append(",DDE_CUTOFF_ALARM_ITEM="+DDE_CUTOFF_ALARM_ITEM);
		sb.append(",DDE_STATUS_DSN="+DDE_STATUS_DSN);
		sb.append(",DDE_STATUS_ITEM="+DDE_STATUS_ITEM);
		sb.append(",RT_AUTO_PRESSURE="+String.valueOf(RT_AUTO_PRESSURE));
		sb.append(",RT_AUTO_MASS="+String.valueOf(RT_AUTO_MASS));
		sb.append(",MANUAL_PRESSURE="+String.valueOf(MANUAL_PRESSURE));
		sb.append(",MANUAL_MASS="+String.valueOf(MANUAL_MASS));
		sb.append(",RT_PRESSURE="+String.valueOf(RT_PRESSURE));
		sb.append(",RT_MASS="+String.valueOf(RT_MASS));
		sb.append(",AUTO_PRESSURE_ENABLE="+String.valueOf(AUTO_PRESSURE_ENABLE));
		sb.append(",AUTO_MASS_ENABLE="+String.valueOf(AUTO_MASS_ENABLE));
		sb.append(",DOWNLOAD_ENABLE="+String.valueOf(DOWNLOAD_ENABLE));
		sb.append(",DOWNLOAD_LEVEL_ENABLE="+String.valueOf(DOWNLOAD_LEVEL_ENABLE));
		sb.append(",DOWNLOAD_QUANTITY_ENABLE="+String.valueOf(DOWNLOAD_QUANTITY_ENABLE));
		sb.append(",DOWNLOAD_TEMPERATURE_ENABLE="+String.valueOf(DOWNLOAD_TEMPERATURE_ENABLE));
		sb.append(",DOWNLOAD_PRESSURE_ENABLE="+String.valueOf(DOWNLOAD_PRESSURE_ENABLE));
		sb.append(",DOWNLOAD_MASS_ENABLE="+String.valueOf(DOWNLOAD_MASS_ENABLE));
		sb.append(",RT_USER_QUEUE_ENABLE="+String.valueOf(RT_USER_QUEUE_ENABLE));
		sb.append(",RT_USER_CONTEXT_VALUE="+String.valueOf(RT_USER_CONTEXT_VALUE));
		sb.append(",RT_FRAC_GROSS_SNAPSHOT_DELTA="+String.valueOf(RT_FRAC_GROSS_SNAPSHOT_DELTA));
		sb.append(",RT_FRAC_NET_SNAPSHOT_DELTA="+String.valueOf(RT_FRAC_NET_SNAPSHOT_DELTA));
		sb.append(",RT_FRAC_EOD_MANUAL_DELTA="+String.valueOf(RT_FRAC_EOD_MANUAL_DELTA));
		sb.append(",RT_TEMPERATURE_SNAPSHOT="+String.valueOf(RT_TEMPERATURE_SNAPSHOT));
		sb.append(",RT_DENSITY_SNAPSHOT="+String.valueOf(RT_DENSITY_SNAPSHOT));
		sb.append(",RT_END_TEMPERATURE_SNAPSHOT="+String.valueOf(RT_END_TEMPERATURE_SNAPSHOT));
		sb.append(",RT_END_DENSITY_SNAPSHOT="+String.valueOf(RT_END_DENSITY_SNAPSHOT));
		sb.append(",RT_FRAC_EOD_TRANSFERS_IN="+String.valueOf(RT_FRAC_EOD_TRANSFERS_IN));
		sb.append(",RT_FRAC_EOD_TRANSFERS_OUT="+String.valueOf(RT_FRAC_EOD_TRANSFERS_OUT));
		sb.append(",MANUAL_QUANTITY_ENABLE="+String.valueOf(MANUAL_QUANTITY_ENABLE));
		sb.append(",MANUAL_BSW_QUANTITY="+String.valueOf(MANUAL_BSW_QUANTITY));
		sb.append(",EOM_MANUAL_QUANTITY="+String.valueOf(EOM_MANUAL_QUANTITY));
		sb.append(",MANUAL_GROSS_QUANTITY="+String.valueOf(MANUAL_GROSS_QUANTITY));
		sb.append(",MANUAL_LOW_LOW_QUANTITY="+String.valueOf(MANUAL_LOW_LOW_QUANTITY));
		sb.append(",MANUAL_LOW_QUANTITY="+String.valueOf(MANUAL_LOW_QUANTITY));
		sb.append(",MANUAL_GENERAL_QUANTITY="+String.valueOf(MANUAL_GENERAL_QUANTITY));
		sb.append(",MANUAL_CUTOFF_QUANTITY="+String.valueOf(MANUAL_CUTOFF_QUANTITY));
		sb.append(",MANUAL_HIGH_QUANTITY="+String.valueOf(MANUAL_HIGH_QUANTITY));
		sb.append(",MANUAL_HIGH_HIGH_QUANTITY="+String.valueOf(MANUAL_HIGH_HIGH_QUANTITY));
		sb.append(",MANUAL_OBSERVED_DENSITY="+String.valueOf(MANUAL_OBSERVED_DENSITY));
		sb.append(",RT_OBSERVED_DENSITY="+String.valueOf(RT_OBSERVED_DENSITY));
		sb.append(",RT_OBS_DENSITY_SNAPSHOT="+String.valueOf(RT_OBS_DENSITY_SNAPSHOT));
		sb.append(",RT_END_OBS_DENSITY_SNAPSHOT="+String.valueOf(RT_END_OBS_DENSITY_SNAPSHOT));
		sb.append(",AUTO_BSW_LEVEL_ENABLE="+String.valueOf(AUTO_BSW_LEVEL_ENABLE));
		sb.append(",AUTO_BSW_QUANTITY_ENABLE="+String.valueOf(AUTO_BSW_QUANTITY_ENABLE));
		sb.append(",RT_AUTO_BSW_LEVEL="+RT_AUTO_BSW_LEVEL);
		sb.append(",RT_AUTO_BSW_QUANTITY="+String.valueOf(RT_AUTO_BSW_QUANTITY));
		sb.append(",RT_BSW_LEVEL="+RT_BSW_LEVEL);
		sb.append(",DDE_BSW_LEVEL_DSN="+DDE_BSW_LEVEL_DSN);
		sb.append(",DDE_BSW_LEVEL_ITEM="+DDE_BSW_LEVEL_ITEM);
		sb.append(",DDE_BSW_QUANTITY_DSN="+DDE_BSW_QUANTITY_DSN);
		sb.append(",DDE_BSW_QUANTITY_ITEM="+DDE_BSW_QUANTITY_ITEM);
		sb.append(",DOWNLOAD_DENSITY_ENABLE="+String.valueOf(DOWNLOAD_DENSITY_ENABLE));
		sb.append(",RT_EOD_ADD_MANUAL_DELTA="+String.valueOf(RT_EOD_ADD_MANUAL_DELTA));
		sb.append(",RT_EOD_ADD_BULK_RECEIPTS="+String.valueOf(RT_EOD_ADD_BULK_RECEIPTS));
		sb.append(",RT_EOD_ADD_RACK_RECEIPTS="+String.valueOf(RT_EOD_ADD_RACK_RECEIPTS));
		sb.append(",RT_EOD_ADD_TRANSFERS_IN="+String.valueOf(RT_EOD_ADD_TRANSFERS_IN));
		sb.append(",RT_EOD_ADD_BULK_DISPOSALS="+String.valueOf(RT_EOD_ADD_BULK_DISPOSALS));
		sb.append(",RT_EOD_ADD_RACK_DISPOSALS="+String.valueOf(RT_EOD_ADD_RACK_DISPOSALS));
		sb.append(",RT_EOD_ADD_TRANSFERS_OUT="+String.valueOf(RT_EOD_ADD_TRANSFERS_OUT));
		sb.append(",RT_EOD_ADD_BOOK_INVENTORY="+String.valueOf(RT_EOD_ADD_BOOK_INVENTORY));
		sb.append(",RT_IN_SERVICE="+String.valueOf(RT_IN_SERVICE));
		sb.append(",VIRTUAL_TANK="+String.valueOf(VIRTUAL_TANK));
		sb.append(",DDE_IN_SERVICE_ITEM="+DDE_IN_SERVICE_ITEM);
		sb.append(",TANK_GROUP="+TANK_GROUP);
		sb.append(",DDE_IN_SERVICE_DSN="+DDE_IN_SERVICE_DSN);
		sb.append(",RT_CUTOFF_QUANTITY="+String.valueOf(RT_CUTOFF_QUANTITY));
		sb.append(",AUTO_NET_QUANTITY_ENABLE="+String.valueOf(AUTO_NET_QUANTITY_ENABLE));
		sb.append(",DDE_NET_QUANTITY_ITEM="+DDE_NET_QUANTITY_ITEM);
		sb.append(",RT_AUTO_NET_QUANTITY="+String.valueOf(RT_AUTO_NET_QUANTITY));
		sb.append(",DDE_NET_QUANTITY_DSN="+DDE_NET_QUANTITY_DSN);
		sb.append(",MANUAL_NET_QUANTITY_ENABLE="+String.valueOf(MANUAL_NET_QUANTITY_ENABLE));
		sb.append(",MANUAL_NET_QUANTITY="+String.valueOf(MANUAL_NET_QUANTITY));
		sb.append(",HIGH_BSW_SETPOINT="+HIGH_BSW_SETPOINT);
		sb.append(",HIGH_BSW_QUANTITY="+String.valueOf(HIGH_BSW_QUANTITY));
		sb.append(",DDE_BSW_HIGH_ALARM_DSN="+DDE_BSW_HIGH_ALARM_DSN);
		sb.append(",DDE_BSW_HIGH_ALARM_ITEM="+DDE_BSW_HIGH_ALARM_ITEM);
		sb.append(",RT_EOD_BULK_FRAC_DISPOSALS="+String.valueOf(RT_EOD_BULK_FRAC_DISPOSALS));
		sb.append(",RT_EOD_BULK_FRAC_RECEIPTS="+String.valueOf(RT_EOD_BULK_FRAC_RECEIPTS));
		sb.append(",RT_EOD_OPEN_BSW_LEVEL="+RT_EOD_OPEN_BSW_LEVEL);
		sb.append(",RT_EOD_OPEN_DENSITY="+String.valueOf(RT_EOD_OPEN_DENSITY));
		sb.append(",RT_EOD_OPEN_TEMPERATURE="+String.valueOf(RT_EOD_OPEN_TEMPERATURE));
		sb.append(",RT_EOD_OPEN_BSW_QUANTITY="+String.valueOf(RT_EOD_OPEN_BSW_QUANTITY));
		sb.append(",RT_EOD_OPEN_LEVEL="+RT_EOD_OPEN_LEVEL);
		sb.append(",RT_EOD_OPEN_OBSERVED_DENSITY="+String.valueOf(RT_EOD_OPEN_OBSERVED_DENSITY));
		sb.append(",RT_EOD_OPEN_PHYS_GROSS_QTY="+String.valueOf(RT_EOD_OPEN_PHYS_GROSS_QTY));
		sb.append(",PREV_EOD_LEVEL="+PREV_EOD_LEVEL);
		sb.append(",PREV_EOD_GROSS_QUANTITY="+String.valueOf(PREV_EOD_GROSS_QUANTITY));
		sb.append(",PREV_EOD_TEMPERATURE="+String.valueOf(PREV_EOD_TEMPERATURE));
		sb.append(",PREV_EOD_DENSITY="+String.valueOf(PREV_EOD_DENSITY));
		sb.append(",PREV_EOD_BSW_QUANTITY="+String.valueOf(PREV_EOD_BSW_QUANTITY));
		sb.append(",PREV_EOD_BSW_LEVEL="+PREV_EOD_BSW_LEVEL);
		sb.append(",RT_PREV_EOD_NET_QUANTITY="+String.valueOf(RT_PREV_EOD_NET_QUANTITY));
		sb.append(",PREV_EOD_COE="+String.valueOf(PREV_EOD_COE));
		sb.append(",RT_PREV_EOD_BSW_QUANTITY="+String.valueOf(RT_PREV_EOD_BSW_QUANTITY));
		sb.append(",PREV_EOD_QUANTITY="+String.valueOf(PREV_EOD_QUANTITY));
		sb.append(",OPENING_COE="+String.valueOf(OPENING_COE));
		sb.append(",RT_TOV="+String.valueOf(RT_TOV));
		sb.append(",RT_GOV="+String.valueOf(RT_GOV));
		sb.append(",RT_GSV="+String.valueOf(RT_GSV));
		sb.append(",RT_TCV="+String.valueOf(RT_TCV));
		sb.append(",RT_SHELL_CORRECTION_FACTOR="+String.valueOf(RT_SHELL_CORRECTION_FACTOR));
		sb.append(",RT_FLOATING_ROOF_ADJUSTMENT="+String.valueOf(RT_FLOATING_ROOF_ADJUSTMENT));
		sb.append(",RT_CTL="+String.valueOf(RT_CTL));
		sb.append(",SUSPENDED_BSW_PERCENT="+String.valueOf(SUSPENDED_BSW_PERCENT));
		sb.append(",MANUAL_STRAP_TYPE="+String.valueOf(MANUAL_STRAP_TYPE));
		sb.append(",ROOF_TAKE_OFF_STRAP_TYPE="+String.valueOf(ROOF_TAKE_OFF_STRAP_TYPE));
		sb.append(",ROOF_SUPPORT_STRAP_TYPE="+String.valueOf(ROOF_SUPPORT_STRAP_TYPE));
		sb.append(",HIGH_BSW_STRAP_TYPE="+String.valueOf(HIGH_BSW_STRAP_TYPE));
		sb.append(",BASE_SEDIMENT_WATER_STRAP_TYPE="+String.valueOf(BASE_SEDIMENT_WATER_STRAP_TYPE));
		sb.append(",GAUGER_INITIALS="+GAUGER_INITIALS);
		sb.append(",GAUGE_TIMESTAMP="+String.valueOf(GAUGE_TIMESTAMP));
		sb.append(",LEVEL_UNITS="+String.valueOf(LEVEL_UNITS));
		sb.append(",SHELL_BASE_TEMPERATURE="+String.valueOf(SHELL_BASE_TEMPERATURE));
		sb.append(",SHELL_MATERIAL_TYPE="+String.valueOf(SHELL_MATERIAL_TYPE));
		sb.append(",MANUAL_AMBIENT_TEMPERATURE="+String.valueOf(MANUAL_AMBIENT_TEMPERATURE));
		sb.append(",INSULATED="+String.valueOf(INSULATED));
		sb.append(",LINE_SEGMENT_NSV="+String.valueOf(LINE_SEGMENT_NSV));
		sb.append(",RT_CALCULATION_POINT="+String.valueOf(RT_CALCULATION_POINT));
		sb.append(",ROOF_TAKE_OFF_TOV="+String.valueOf(ROOF_TAKE_OFF_TOV));
		sb.append(",RT_NSV="+String.valueOf(RT_NSV));
		sb.append(",RT_GSW="+String.valueOf(RT_GSW));
		sb.append(",RT_NSW="+String.valueOf(RT_NSW));
		sb.append(",RT_WCF="+String.valueOf(RT_WCF));
		sb.append(",LINE_SEGMENT_NSW="+String.valueOf(LINE_SEGMENT_NSW));
		sb.append(",ROOF_WEIGHT="+String.valueOf(ROOF_WEIGHT));
		sb.append(",VOL_IN_ALARM="+String.valueOf(VOL_IN_ALARM));
		sb.append(",INACTIVITY_QUANTITY="+String.valueOf(INACTIVITY_QUANTITY));
		sb.append(",INACTIVITY_ALARM_STATE="+String.valueOf(INACTIVITY_ALARM_STATE));
		sb.append(",USER_LEVEL="+String.valueOf(USER_LEVEL));
		sb.append(",SCHED_PROD_CHANGE_DATE_TIME="+String.valueOf(SCHED_PROD_CHANGE_DATE_TIME));
		sb.append(",SCHED_PROD_CHANGE_TIMEOUT="+String.valueOf(SCHED_PROD_CHANGE_TIMEOUT));
		sb.append(",SCHED_PROD_CHANGE_EMAIL="+SCHED_PROD_CHANGE_EMAIL);
		sb.append(",SETPOINT_QUANTITY_ENABLE="+String.valueOf(SETPOINT_QUANTITY_ENABLE));
		sb.append(",MANUAL_MEASURED_DENSITY="+String.valueOf(MANUAL_MEASURED_DENSITY));
		sb.append(",WEIGHT_IN_AIR="+String.valueOf(WEIGHT_IN_AIR));
		sb.append(",TOPS_MONITORING_ACTIVE="+String.valueOf(TOPS_MONITORING_ACTIVE));
		sb.append(",SHAPE="+String.valueOf(SHAPE));
		sb.append(",ACTUAL_FLOW_RATE_PERIOD="+String.valueOf(ACTUAL_FLOW_RATE_PERIOD));
		sb.append(",CALCULATED_FLOW_RATE_PERIOD="+String.valueOf(CALCULATED_FLOW_RATE_PERIOD));
		sb.append(",FLOW_RATE_CLAMPING_PERIOD="+String.valueOf(FLOW_RATE_CLAMPING_PERIOD));
		sb.append(",RT_CLAMPING_PERIOD_START="+String.valueOf(RT_CLAMPING_PERIOD_START));
		sb.append(",VAPOR_CORRECTION_METHOD="+String.valueOf(VAPOR_CORRECTION_METHOD));
		sb.append(",VAPOR_TEMPERATURE="+String.valueOf(VAPOR_TEMPERATURE));
		sb.append(",VAPOR_LIQUID_VOLUME_RATIO="+String.valueOf(VAPOR_LIQUID_VOLUME_RATIO));
		sb.append(",TARGET_LEVEL="+String.valueOf(TARGET_LEVEL));
		sb.append(",ORIGINAL_STARTING_LEVEL="+String.valueOf(ORIGINAL_STARTING_LEVEL));
		sb.append(",TIME_TO_TARGET_LEVEL="+String.valueOf(TIME_TO_TARGET_LEVEL));
		sb.append(",AUTO_VAPOR_TEMPERATURE_ENABLE="+String.valueOf(AUTO_VAPOR_TEMPERATURE_ENABLE));
		sb.append(",DDE_PRESSURE_DSN="+DDE_PRESSURE_DSN);
		sb.append(",DDE_PRESSURE_ITEM="+DDE_PRESSURE_ITEM);
		sb.append(",DDE_VAPOR_TEMPERATURE_DSN="+DDE_VAPOR_TEMPERATURE_DSN);
		sb.append(",DDE_VAPOR_TEMPERATURE_ITEM="+DDE_VAPOR_TEMPERATURE_ITEM);
		sb.append(",RT_AUTO_VAPOR_TEMPERATURE="+String.valueOf(RT_AUTO_VAPOR_TEMPERATURE));
		sb.append(",RT_VAPOR_TEMPERATURE="+String.valueOf(RT_VAPOR_TEMPERATURE));
		sb.append(",INVENTORY_ENABLE="+String.valueOf(INVENTORY_ENABLE));
		sb.append(",MANUAL_TO_AUTO_FOLIO_LIMIT="+String.valueOf(MANUAL_TO_AUTO_FOLIO_LIMIT));
		sb.append(",RT_MANUAL_TO_AUTO_FOLIO_COUNT="+String.valueOf(RT_MANUAL_TO_AUTO_FOLIO_COUNT));
		sb.append(",RT_LEVEL_ORIGIN="+String.valueOf(RT_LEVEL_ORIGIN));
		sb.append(",RT_TOV_ORIGIN="+String.valueOf(RT_TOV_ORIGIN));
		sb.append(",RT_TEMPERATURE_ORIGIN="+String.valueOf(RT_TEMPERATURE_ORIGIN));
		sb.append(",RT_DENSITY_ORIGIN="+String.valueOf(RT_DENSITY_ORIGIN));
		sb.append(",RT_NSV_ORIGIN="+String.valueOf(RT_NSV_ORIGIN));
		sb.append(",RT_VAPOR_TEMPERATURE_ORIGIN="+String.valueOf(RT_VAPOR_TEMPERATURE_ORIGIN));
		sb.append(",RT_PRESSURE_ORIGIN="+String.valueOf(RT_PRESSURE_ORIGIN));
		sb.append(",RT_FREE_WATER_LEVEL_ORIGIN="+String.valueOf(RT_FREE_WATER_LEVEL_ORIGIN));
		sb.append(",RT_WATER_QUANTITY_ORIGIN="+String.valueOf(RT_WATER_QUANTITY_ORIGIN));
		sb.append(",DDE_SNAPSHOT_REQ_DSN="+DDE_SNAPSHOT_REQ_DSN);
		sb.append(",DDE_SNAPSHOT_REQ_ITEM="+DDE_SNAPSHOT_REQ_ITEM);
		sb.append(",DDE_SNAPSHOT_RSP_DSN="+DDE_SNAPSHOT_RSP_DSN);
		sb.append(",DDE_SNAPSHOT_RSP_ITEM="+DDE_SNAPSHOT_RSP_ITEM);
		sb.append(",AUTO_PRODUCT_LEVEL_UNIT="+String.valueOf(AUTO_PRODUCT_LEVEL_UNIT));
		sb.append(",AUTO_FREE_WATER_LEVEL_UNIT="+String.valueOf(AUTO_FREE_WATER_LEVEL_UNIT));
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
    final static byte[] commonByteArrayLock_PGS_STAGE_DIM_TANK = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_DIM_TANK = new byte[0];

	
			    public String TANK_CODE;

				public String getTANK_CODE () {
					return this.TANK_CODE;
				}
				
			    public String NAME;

				public String getNAME () {
					return this.NAME;
				}
				
			    public Integer COMPARTMENT_OWNER_ID;

				public Integer getCOMPARTMENT_OWNER_ID () {
					return this.COMPARTMENT_OWNER_ID;
				}
				
			    public Integer MAJORITY_SHAREHOLDER;

				public Integer getMAJORITY_SHAREHOLDER () {
					return this.MAJORITY_SHAREHOLDER;
				}
				
			    public String COMPARTMENT_CONTAINER_CODE;

				public String getCOMPARTMENT_CONTAINER_CODE () {
					return this.COMPARTMENT_CONTAINER_CODE;
				}
				
			    public int RT_GROSS_QUANTITY;

				public int getRT_GROSS_QUANTITY () {
					return this.RT_GROSS_QUANTITY;
				}
				
			    public Integer COMPARTMENT_CONTAINER_TYPE;

				public Integer getCOMPARTMENT_CONTAINER_TYPE () {
					return this.COMPARTMENT_CONTAINER_TYPE;
				}
				
			    public int TERMINAL_PRODUCT_NUMBER;

				public int getTERMINAL_PRODUCT_NUMBER () {
					return this.TERMINAL_PRODUCT_NUMBER;
				}
				
			    public Integer COMPARTMENT_NUMBER;

				public Integer getCOMPARTMENT_NUMBER () {
					return this.COMPARTMENT_NUMBER;
				}
				
			    public int RT_NET_QUANTITY;

				public int getRT_NET_QUANTITY () {
					return this.RT_NET_QUANTITY;
				}
				
			    public int ENABLE;

				public int getENABLE () {
					return this.ENABLE;
				}
				
			    public Integer SCHED_PROD_CHANGE_PRODUCT;

				public Integer getSCHED_PROD_CHANGE_PRODUCT () {
					return this.SCHED_PROD_CHANGE_PRODUCT;
				}
				
			    public double RVP;

				public double getRVP () {
					return this.RVP;
				}
				
			    public double OXYGEN;

				public double getOXYGEN () {
					return this.OXYGEN;
				}
				
			    public double RT_TEMPERATURE;

				public double getRT_TEMPERATURE () {
					return this.RT_TEMPERATURE;
				}
				
			    public double RT_DENSITY;

				public double getRT_DENSITY () {
					return this.RT_DENSITY;
				}
				
			    public int SHELL_CAPACITY;

				public int getSHELL_CAPACITY () {
					return this.SHELL_CAPACITY;
				}
				
			    public int WORK_CAPACITY;

				public int getWORK_CAPACITY () {
					return this.WORK_CAPACITY;
				}
				
			    public String DEPTH;

				public String getDEPTH () {
					return this.DEPTH;
				}
				
			    public String LOW_LOW_SETPOINT;

				public String getLOW_LOW_SETPOINT () {
					return this.LOW_LOW_SETPOINT;
				}
				
			    public String LOW_SETPOINT;

				public String getLOW_SETPOINT () {
					return this.LOW_SETPOINT;
				}
				
			    public String GENERAL_SETPOINT;

				public String getGENERAL_SETPOINT () {
					return this.GENERAL_SETPOINT;
				}
				
			    public String CUTOFF_SETPOINT;

				public String getCUTOFF_SETPOINT () {
					return this.CUTOFF_SETPOINT;
				}
				
			    public int AUTO_ENABLE;

				public int getAUTO_ENABLE () {
					return this.AUTO_ENABLE;
				}
				
			    public String HIGH_SETPOINT;

				public String getHIGH_SETPOINT () {
					return this.HIGH_SETPOINT;
				}
				
			    public String HIGH_HIGH_SETPOINT;

				public String getHIGH_HIGH_SETPOINT () {
					return this.HIGH_HIGH_SETPOINT;
				}
				
			    public int DEADBAND;

				public int getDEADBAND () {
					return this.DEADBAND;
				}
				
			    public int AUTO_LEVEL_ENABLE;

				public int getAUTO_LEVEL_ENABLE () {
					return this.AUTO_LEVEL_ENABLE;
				}
				
			    public String DDE_LEVEL_DSN;

				public String getDDE_LEVEL_DSN () {
					return this.DDE_LEVEL_DSN;
				}
				
			    public int AUTO_DENSITY_ENABLE;

				public int getAUTO_DENSITY_ENABLE () {
					return this.AUTO_DENSITY_ENABLE;
				}
				
			    public int AUTO_TEMPERATURE_ENABLE;

				public int getAUTO_TEMPERATURE_ENABLE () {
					return this.AUTO_TEMPERATURE_ENABLE;
				}
				
			    public String DDE_LEVEL_ITEM;

				public String getDDE_LEVEL_ITEM () {
					return this.DDE_LEVEL_ITEM;
				}
				
			    public int AUTO_QUANTITY_ENABLE;

				public int getAUTO_QUANTITY_ENABLE () {
					return this.AUTO_QUANTITY_ENABLE;
				}
				
			    public String DDE_DENSITY_DSN;

				public String getDDE_DENSITY_DSN () {
					return this.DDE_DENSITY_DSN;
				}
				
			    public int ACTIVITY_STATUS;

				public int getACTIVITY_STATUS () {
					return this.ACTIVITY_STATUS;
				}
				
			    public String DDE_DENSITY_ITEM;

				public String getDDE_DENSITY_ITEM () {
					return this.DDE_DENSITY_ITEM;
				}
				
			    public String DDE_TEMPERATURE_DSN;

				public String getDDE_TEMPERATURE_DSN () {
					return this.DDE_TEMPERATURE_DSN;
				}
				
			    public int RECEIPT_INDICATOR;

				public int getRECEIPT_INDICATOR () {
					return this.RECEIPT_INDICATOR;
				}
				
			    public String DDE_TEMPERATURE_ITEM;

				public String getDDE_TEMPERATURE_ITEM () {
					return this.DDE_TEMPERATURE_ITEM;
				}
				
			    public java.util.Date LAST_RECEIPT_DATE;

				public java.util.Date getLAST_RECEIPT_DATE () {
					return this.LAST_RECEIPT_DATE;
				}
				
			    public String DDE_QUANTITY_DSN;

				public String getDDE_QUANTITY_DSN () {
					return this.DDE_QUANTITY_DSN;
				}
				
			    public String DDE_QUANTITY_ITEM;

				public String getDDE_QUANTITY_ITEM () {
					return this.DDE_QUANTITY_ITEM;
				}
				
			    public int SEND_TO_HOST_AT_EOD;

				public int getSEND_TO_HOST_AT_EOD () {
					return this.SEND_TO_HOST_AT_EOD;
				}
				
			    public String MANUAL_LEVEL;

				public String getMANUAL_LEVEL () {
					return this.MANUAL_LEVEL;
				}
				
			    public String RT_AUTO_LEVEL;

				public String getRT_AUTO_LEVEL () {
					return this.RT_AUTO_LEVEL;
				}
				
			    public String EOM_MANUAL_LEVEL;

				public String getEOM_MANUAL_LEVEL () {
					return this.EOM_MANUAL_LEVEL;
				}
				
			    public int RT_EOM_GROSS_QUANTITY;

				public int getRT_EOM_GROSS_QUANTITY () {
					return this.RT_EOM_GROSS_QUANTITY;
				}
				
			    public double RT_AUTO_DENSITY;

				public double getRT_AUTO_DENSITY () {
					return this.RT_AUTO_DENSITY;
				}
				
			    public double EOM_MANUAL_TEMPERATURE;

				public double getEOM_MANUAL_TEMPERATURE () {
					return this.EOM_MANUAL_TEMPERATURE;
				}
				
			    public double EOM_MANUAL_DENSITY;

				public double getEOM_MANUAL_DENSITY () {
					return this.EOM_MANUAL_DENSITY;
				}
				
			    public int EOM_MANUAL_BSW_QUANTITY;

				public int getEOM_MANUAL_BSW_QUANTITY () {
					return this.EOM_MANUAL_BSW_QUANTITY;
				}
				
			    public String EOM_MANUAL_BSW_LEVEL;

				public String getEOM_MANUAL_BSW_LEVEL () {
					return this.EOM_MANUAL_BSW_LEVEL;
				}
				
			    public double MANUAL_TEMPERATURE;

				public double getMANUAL_TEMPERATURE () {
					return this.MANUAL_TEMPERATURE;
				}
				
			    public int RT_EOM_NET_QUANTITY;

				public int getRT_EOM_NET_QUANTITY () {
					return this.RT_EOM_NET_QUANTITY;
				}
				
			    public double EOM_MANUAL_COE;

				public double getEOM_MANUAL_COE () {
					return this.EOM_MANUAL_COE;
				}
				
			    public int RT_EOM_BSW_QUANTITY;

				public int getRT_EOM_BSW_QUANTITY () {
					return this.RT_EOM_BSW_QUANTITY;
				}
				
			    public java.util.Date MANUAL_DATE;

				public java.util.Date getMANUAL_DATE () {
					return this.MANUAL_DATE;
				}
				
			    public String BASE_SEDIMENT_WATER_LEVEL;

				public String getBASE_SEDIMENT_WATER_LEVEL () {
					return this.BASE_SEDIMENT_WATER_LEVEL;
				}
				
			    public double MANUAL_DENSITY;

				public double getMANUAL_DENSITY () {
					return this.MANUAL_DENSITY;
				}
				
			    public int RT_BSW_QUANTITY;

				public int getRT_BSW_QUANTITY () {
					return this.RT_BSW_QUANTITY;
				}
				
			    public double MANUAL_SPECIFIC_GRAVITY;

				public double getMANUAL_SPECIFIC_GRAVITY () {
					return this.MANUAL_SPECIFIC_GRAVITY;
				}
				
			    public int PIPE_FILL;

				public int getPIPE_FILL () {
					return this.PIPE_FILL;
				}
				
			    public double MANUAL_COEFFICIENT_EXPANSION;

				public double getMANUAL_COEFFICIENT_EXPANSION () {
					return this.MANUAL_COEFFICIENT_EXPANSION;
				}
				
			    public int PROTOCOL_TYPE;

				public int getPROTOCOL_TYPE () {
					return this.PROTOCOL_TYPE;
				}
				
			    public double RT_AUTO_TEMPERATURE;

				public double getRT_AUTO_TEMPERATURE () {
					return this.RT_AUTO_TEMPERATURE;
				}
				
			    public String PORT_NAME;

				public String getPORT_NAME () {
					return this.PORT_NAME;
				}
				
			    public int RT_AUTO_QUANTITY;

				public int getRT_AUTO_QUANTITY () {
					return this.RT_AUTO_QUANTITY;
				}
				
			    public int ADDRESS;

				public int getADDRESS () {
					return this.ADDRESS;
				}
				
			    public String REMARKS;

				public String getREMARKS () {
					return this.REMARKS;
				}
				
			    public int FAST_SCAN;

				public int getFAST_SCAN () {
					return this.FAST_SCAN;
				}
				
			    public String RT_LEVEL;

				public String getRT_LEVEL () {
					return this.RT_LEVEL;
				}
				
			    public int RT_METER_COUNT;

				public int getRT_METER_COUNT () {
					return this.RT_METER_COUNT;
				}
				
			    public int RT_GROSS_SNAPSHOT;

				public int getRT_GROSS_SNAPSHOT () {
					return this.RT_GROSS_SNAPSHOT;
				}
				
			    public int RT_SNAPSHOT_ACTIVE;

				public int getRT_SNAPSHOT_ACTIVE () {
					return this.RT_SNAPSHOT_ACTIVE;
				}
				
			    public String RT_LEVEL_SNAPSHOT;

				public String getRT_LEVEL_SNAPSHOT () {
					return this.RT_LEVEL_SNAPSHOT;
				}
				
			    public int RT_NET_SNAPSHOT;

				public int getRT_NET_SNAPSHOT () {
					return this.RT_NET_SNAPSHOT;
				}
				
			    public java.util.Date RT_SNAPSHOT_DATE;

				public java.util.Date getRT_SNAPSHOT_DATE () {
					return this.RT_SNAPSHOT_DATE;
				}
				
			    public int RT_GROSS_SNAPSHOT_DELTA;

				public int getRT_GROSS_SNAPSHOT_DELTA () {
					return this.RT_GROSS_SNAPSHOT_DELTA;
				}
				
			    public int RT_NET_SNAPSHOT_DELTA;

				public int getRT_NET_SNAPSHOT_DELTA () {
					return this.RT_NET_SNAPSHOT_DELTA;
				}
				
			    public int RT_EOD_MANUAL_DELTA;

				public int getRT_EOD_MANUAL_DELTA () {
					return this.RT_EOD_MANUAL_DELTA;
				}
				
			    public String RT_END_LEVEL_SNAPSHOT;

				public String getRT_END_LEVEL_SNAPSHOT () {
					return this.RT_END_LEVEL_SNAPSHOT;
				}
				
			    public int RT_EOD_OPENING_PHYSICAL;

				public int getRT_EOD_OPENING_PHYSICAL () {
					return this.RT_EOD_OPENING_PHYSICAL;
				}
				
			    public int RT_EOD_BULK_RECEIPTS;

				public int getRT_EOD_BULK_RECEIPTS () {
					return this.RT_EOD_BULK_RECEIPTS;
				}
				
			    public int RT_END_GROSS_SNAPSHOT;

				public int getRT_END_GROSS_SNAPSHOT () {
					return this.RT_END_GROSS_SNAPSHOT;
				}
				
			    public int RT_AVAILABLE_QUANTITY;

				public int getRT_AVAILABLE_QUANTITY () {
					return this.RT_AVAILABLE_QUANTITY;
				}
				
			    public int RT_END_NET_SNAPSHOT;

				public int getRT_END_NET_SNAPSHOT () {
					return this.RT_END_NET_SNAPSHOT;
				}
				
			    public int RT_EOD_BULK_DISPOSALS;

				public int getRT_EOD_BULK_DISPOSALS () {
					return this.RT_EOD_BULK_DISPOSALS;
				}
				
			    public java.util.Date RT_END_SNAPSHOT_DATE;

				public java.util.Date getRT_END_SNAPSHOT_DATE () {
					return this.RT_END_SNAPSHOT_DATE;
				}
				
			    public int RT_EOD_TRANSFERS_IN;

				public int getRT_EOD_TRANSFERS_IN () {
					return this.RT_EOD_TRANSFERS_IN;
				}
				
			    public int RT_EOD_RACK_RECEIPTS;

				public int getRT_EOD_RACK_RECEIPTS () {
					return this.RT_EOD_RACK_RECEIPTS;
				}
				
			    public int RT_EOD_TRANSFERS_OUT;

				public int getRT_EOD_TRANSFERS_OUT () {
					return this.RT_EOD_TRANSFERS_OUT;
				}
				
			    public int RT_EOD_RACK_DISPOSALS;

				public int getRT_EOD_RACK_DISPOSALS () {
					return this.RT_EOD_RACK_DISPOSALS;
				}
				
			    public String LAST_USER_NAME;

				public String getLAST_USER_NAME () {
					return this.LAST_USER_NAME;
				}
				
			    public java.util.Date LAST_MODIFIED;

				public java.util.Date getLAST_MODIFIED () {
					return this.LAST_MODIFIED;
				}
				
			    public int RT_EOD_BOOK_INVENTORY;

				public int getRT_EOD_BOOK_INVENTORY () {
					return this.RT_EOD_BOOK_INVENTORY;
				}
				
			    public String USER_DLL;

				public String getUSER_DLL () {
					return this.USER_DLL;
				}
				
			    public String USER_ROUTINE;

				public String getUSER_ROUTINE () {
					return this.USER_ROUTINE;
				}
				
			    public int ROOF_CORRECTION_TYPE;

				public int getROOF_CORRECTION_TYPE () {
					return this.ROOF_CORRECTION_TYPE;
				}
				
			    public String ROOF_TAKE_OFF_LEVEL;

				public String getROOF_TAKE_OFF_LEVEL () {
					return this.ROOF_TAKE_OFF_LEVEL;
				}
				
			    public String ROOF_SUPPORT_LEVEL;

				public String getROOF_SUPPORT_LEVEL () {
					return this.ROOF_SUPPORT_LEVEL;
				}
				
			    public double ROOF_REFERENCE_DENSITY;

				public double getROOF_REFERENCE_DENSITY () {
					return this.ROOF_REFERENCE_DENSITY;
				}
				
			    public double ROOF_ABOVE_ADJUSTMENT;

				public double getROOF_ABOVE_ADJUSTMENT () {
					return this.ROOF_ABOVE_ADJUSTMENT;
				}
				
			    public int RT_EOD_MANUAL_CLOSING_ENABLE;

				public int getRT_EOD_MANUAL_CLOSING_ENABLE () {
					return this.RT_EOD_MANUAL_CLOSING_ENABLE;
				}
				
			    public double ROOF_BELOW_ADJUSTMENT;

				public double getROOF_BELOW_ADJUSTMENT () {
					return this.ROOF_BELOW_ADJUSTMENT;
				}
				
			    public String RT_EOD_MANUAL_LEVEL;

				public String getRT_EOD_MANUAL_LEVEL () {
					return this.RT_EOD_MANUAL_LEVEL;
				}
				
			    public int STRAPPING_INVERTED;

				public int getSTRAPPING_INVERTED () {
					return this.STRAPPING_INVERTED;
				}
				
			    public int RT_EOD_MANUAL_GROSS_QUANTITY;

				public int getRT_EOD_MANUAL_GROSS_QUANTITY () {
					return this.RT_EOD_MANUAL_GROSS_QUANTITY;
				}
				
			    public int RT_EOD_MANUAL_NET_QUANTITY;

				public int getRT_EOD_MANUAL_NET_QUANTITY () {
					return this.RT_EOD_MANUAL_NET_QUANTITY;
				}
				
			    public int RT_EOD_RACK_FRAC_DISPOSALS;

				public int getRT_EOD_RACK_FRAC_DISPOSALS () {
					return this.RT_EOD_RACK_FRAC_DISPOSALS;
				}
				
			    public int RT_EOD_RACK_FRAC_RECEIPTS;

				public int getRT_EOD_RACK_FRAC_RECEIPTS () {
					return this.RT_EOD_RACK_FRAC_RECEIPTS;
				}
				
			    public String DDE_HIGH_ALARM_DSN;

				public String getDDE_HIGH_ALARM_DSN () {
					return this.DDE_HIGH_ALARM_DSN;
				}
				
			    public String DDE_HIGH_ALARM_ITEM;

				public String getDDE_HIGH_ALARM_ITEM () {
					return this.DDE_HIGH_ALARM_ITEM;
				}
				
			    public String DDE_HIGH_HIGH_ALARM_DSN;

				public String getDDE_HIGH_HIGH_ALARM_DSN () {
					return this.DDE_HIGH_HIGH_ALARM_DSN;
				}
				
			    public String DDE_HIGH_HIGH_ALARM_ITEM;

				public String getDDE_HIGH_HIGH_ALARM_ITEM () {
					return this.DDE_HIGH_HIGH_ALARM_ITEM;
				}
				
			    public String DDE_LOW_ALARM_DSN;

				public String getDDE_LOW_ALARM_DSN () {
					return this.DDE_LOW_ALARM_DSN;
				}
				
			    public String DDE_LOW_ALARM_ITEM;

				public String getDDE_LOW_ALARM_ITEM () {
					return this.DDE_LOW_ALARM_ITEM;
				}
				
			    public String DDE_LOW_LOW_ALARM_DSN;

				public String getDDE_LOW_LOW_ALARM_DSN () {
					return this.DDE_LOW_LOW_ALARM_DSN;
				}
				
			    public String DDE_LOW_LOW_ALARM_ITEM;

				public String getDDE_LOW_LOW_ALARM_ITEM () {
					return this.DDE_LOW_LOW_ALARM_ITEM;
				}
				
			    public String DDE_CUTOFF_ALARM_DSN;

				public String getDDE_CUTOFF_ALARM_DSN () {
					return this.DDE_CUTOFF_ALARM_DSN;
				}
				
			    public String DDE_CUTOFF_ALARM_ITEM;

				public String getDDE_CUTOFF_ALARM_ITEM () {
					return this.DDE_CUTOFF_ALARM_ITEM;
				}
				
			    public String DDE_STATUS_DSN;

				public String getDDE_STATUS_DSN () {
					return this.DDE_STATUS_DSN;
				}
				
			    public String DDE_STATUS_ITEM;

				public String getDDE_STATUS_ITEM () {
					return this.DDE_STATUS_ITEM;
				}
				
			    public double RT_AUTO_PRESSURE;

				public double getRT_AUTO_PRESSURE () {
					return this.RT_AUTO_PRESSURE;
				}
				
			    public int RT_AUTO_MASS;

				public int getRT_AUTO_MASS () {
					return this.RT_AUTO_MASS;
				}
				
			    public double MANUAL_PRESSURE;

				public double getMANUAL_PRESSURE () {
					return this.MANUAL_PRESSURE;
				}
				
			    public int MANUAL_MASS;

				public int getMANUAL_MASS () {
					return this.MANUAL_MASS;
				}
				
			    public double RT_PRESSURE;

				public double getRT_PRESSURE () {
					return this.RT_PRESSURE;
				}
				
			    public int RT_MASS;

				public int getRT_MASS () {
					return this.RT_MASS;
				}
				
			    public int AUTO_PRESSURE_ENABLE;

				public int getAUTO_PRESSURE_ENABLE () {
					return this.AUTO_PRESSURE_ENABLE;
				}
				
			    public int AUTO_MASS_ENABLE;

				public int getAUTO_MASS_ENABLE () {
					return this.AUTO_MASS_ENABLE;
				}
				
			    public int DOWNLOAD_ENABLE;

				public int getDOWNLOAD_ENABLE () {
					return this.DOWNLOAD_ENABLE;
				}
				
			    public int DOWNLOAD_LEVEL_ENABLE;

				public int getDOWNLOAD_LEVEL_ENABLE () {
					return this.DOWNLOAD_LEVEL_ENABLE;
				}
				
			    public int DOWNLOAD_QUANTITY_ENABLE;

				public int getDOWNLOAD_QUANTITY_ENABLE () {
					return this.DOWNLOAD_QUANTITY_ENABLE;
				}
				
			    public int DOWNLOAD_TEMPERATURE_ENABLE;

				public int getDOWNLOAD_TEMPERATURE_ENABLE () {
					return this.DOWNLOAD_TEMPERATURE_ENABLE;
				}
				
			    public int DOWNLOAD_PRESSURE_ENABLE;

				public int getDOWNLOAD_PRESSURE_ENABLE () {
					return this.DOWNLOAD_PRESSURE_ENABLE;
				}
				
			    public int DOWNLOAD_MASS_ENABLE;

				public int getDOWNLOAD_MASS_ENABLE () {
					return this.DOWNLOAD_MASS_ENABLE;
				}
				
			    public int RT_USER_QUEUE_ENABLE;

				public int getRT_USER_QUEUE_ENABLE () {
					return this.RT_USER_QUEUE_ENABLE;
				}
				
			    public int RT_USER_CONTEXT_VALUE;

				public int getRT_USER_CONTEXT_VALUE () {
					return this.RT_USER_CONTEXT_VALUE;
				}
				
			    public int RT_FRAC_GROSS_SNAPSHOT_DELTA;

				public int getRT_FRAC_GROSS_SNAPSHOT_DELTA () {
					return this.RT_FRAC_GROSS_SNAPSHOT_DELTA;
				}
				
			    public int RT_FRAC_NET_SNAPSHOT_DELTA;

				public int getRT_FRAC_NET_SNAPSHOT_DELTA () {
					return this.RT_FRAC_NET_SNAPSHOT_DELTA;
				}
				
			    public int RT_FRAC_EOD_MANUAL_DELTA;

				public int getRT_FRAC_EOD_MANUAL_DELTA () {
					return this.RT_FRAC_EOD_MANUAL_DELTA;
				}
				
			    public double RT_TEMPERATURE_SNAPSHOT;

				public double getRT_TEMPERATURE_SNAPSHOT () {
					return this.RT_TEMPERATURE_SNAPSHOT;
				}
				
			    public double RT_DENSITY_SNAPSHOT;

				public double getRT_DENSITY_SNAPSHOT () {
					return this.RT_DENSITY_SNAPSHOT;
				}
				
			    public double RT_END_TEMPERATURE_SNAPSHOT;

				public double getRT_END_TEMPERATURE_SNAPSHOT () {
					return this.RT_END_TEMPERATURE_SNAPSHOT;
				}
				
			    public double RT_END_DENSITY_SNAPSHOT;

				public double getRT_END_DENSITY_SNAPSHOT () {
					return this.RT_END_DENSITY_SNAPSHOT;
				}
				
			    public int RT_FRAC_EOD_TRANSFERS_IN;

				public int getRT_FRAC_EOD_TRANSFERS_IN () {
					return this.RT_FRAC_EOD_TRANSFERS_IN;
				}
				
			    public int RT_FRAC_EOD_TRANSFERS_OUT;

				public int getRT_FRAC_EOD_TRANSFERS_OUT () {
					return this.RT_FRAC_EOD_TRANSFERS_OUT;
				}
				
			    public int MANUAL_QUANTITY_ENABLE;

				public int getMANUAL_QUANTITY_ENABLE () {
					return this.MANUAL_QUANTITY_ENABLE;
				}
				
			    public int MANUAL_BSW_QUANTITY;

				public int getMANUAL_BSW_QUANTITY () {
					return this.MANUAL_BSW_QUANTITY;
				}
				
			    public int EOM_MANUAL_QUANTITY;

				public int getEOM_MANUAL_QUANTITY () {
					return this.EOM_MANUAL_QUANTITY;
				}
				
			    public int MANUAL_GROSS_QUANTITY;

				public int getMANUAL_GROSS_QUANTITY () {
					return this.MANUAL_GROSS_QUANTITY;
				}
				
			    public int MANUAL_LOW_LOW_QUANTITY;

				public int getMANUAL_LOW_LOW_QUANTITY () {
					return this.MANUAL_LOW_LOW_QUANTITY;
				}
				
			    public int MANUAL_LOW_QUANTITY;

				public int getMANUAL_LOW_QUANTITY () {
					return this.MANUAL_LOW_QUANTITY;
				}
				
			    public int MANUAL_GENERAL_QUANTITY;

				public int getMANUAL_GENERAL_QUANTITY () {
					return this.MANUAL_GENERAL_QUANTITY;
				}
				
			    public int MANUAL_CUTOFF_QUANTITY;

				public int getMANUAL_CUTOFF_QUANTITY () {
					return this.MANUAL_CUTOFF_QUANTITY;
				}
				
			    public int MANUAL_HIGH_QUANTITY;

				public int getMANUAL_HIGH_QUANTITY () {
					return this.MANUAL_HIGH_QUANTITY;
				}
				
			    public int MANUAL_HIGH_HIGH_QUANTITY;

				public int getMANUAL_HIGH_HIGH_QUANTITY () {
					return this.MANUAL_HIGH_HIGH_QUANTITY;
				}
				
			    public double MANUAL_OBSERVED_DENSITY;

				public double getMANUAL_OBSERVED_DENSITY () {
					return this.MANUAL_OBSERVED_DENSITY;
				}
				
			    public double RT_OBSERVED_DENSITY;

				public double getRT_OBSERVED_DENSITY () {
					return this.RT_OBSERVED_DENSITY;
				}
				
			    public double RT_OBS_DENSITY_SNAPSHOT;

				public double getRT_OBS_DENSITY_SNAPSHOT () {
					return this.RT_OBS_DENSITY_SNAPSHOT;
				}
				
			    public double RT_END_OBS_DENSITY_SNAPSHOT;

				public double getRT_END_OBS_DENSITY_SNAPSHOT () {
					return this.RT_END_OBS_DENSITY_SNAPSHOT;
				}
				
			    public int AUTO_BSW_LEVEL_ENABLE;

				public int getAUTO_BSW_LEVEL_ENABLE () {
					return this.AUTO_BSW_LEVEL_ENABLE;
				}
				
			    public int AUTO_BSW_QUANTITY_ENABLE;

				public int getAUTO_BSW_QUANTITY_ENABLE () {
					return this.AUTO_BSW_QUANTITY_ENABLE;
				}
				
			    public String RT_AUTO_BSW_LEVEL;

				public String getRT_AUTO_BSW_LEVEL () {
					return this.RT_AUTO_BSW_LEVEL;
				}
				
			    public int RT_AUTO_BSW_QUANTITY;

				public int getRT_AUTO_BSW_QUANTITY () {
					return this.RT_AUTO_BSW_QUANTITY;
				}
				
			    public String RT_BSW_LEVEL;

				public String getRT_BSW_LEVEL () {
					return this.RT_BSW_LEVEL;
				}
				
			    public String DDE_BSW_LEVEL_DSN;

				public String getDDE_BSW_LEVEL_DSN () {
					return this.DDE_BSW_LEVEL_DSN;
				}
				
			    public String DDE_BSW_LEVEL_ITEM;

				public String getDDE_BSW_LEVEL_ITEM () {
					return this.DDE_BSW_LEVEL_ITEM;
				}
				
			    public String DDE_BSW_QUANTITY_DSN;

				public String getDDE_BSW_QUANTITY_DSN () {
					return this.DDE_BSW_QUANTITY_DSN;
				}
				
			    public String DDE_BSW_QUANTITY_ITEM;

				public String getDDE_BSW_QUANTITY_ITEM () {
					return this.DDE_BSW_QUANTITY_ITEM;
				}
				
			    public int DOWNLOAD_DENSITY_ENABLE;

				public int getDOWNLOAD_DENSITY_ENABLE () {
					return this.DOWNLOAD_DENSITY_ENABLE;
				}
				
			    public int RT_EOD_ADD_MANUAL_DELTA;

				public int getRT_EOD_ADD_MANUAL_DELTA () {
					return this.RT_EOD_ADD_MANUAL_DELTA;
				}
				
			    public int RT_EOD_ADD_BULK_RECEIPTS;

				public int getRT_EOD_ADD_BULK_RECEIPTS () {
					return this.RT_EOD_ADD_BULK_RECEIPTS;
				}
				
			    public int RT_EOD_ADD_RACK_RECEIPTS;

				public int getRT_EOD_ADD_RACK_RECEIPTS () {
					return this.RT_EOD_ADD_RACK_RECEIPTS;
				}
				
			    public int RT_EOD_ADD_TRANSFERS_IN;

				public int getRT_EOD_ADD_TRANSFERS_IN () {
					return this.RT_EOD_ADD_TRANSFERS_IN;
				}
				
			    public int RT_EOD_ADD_BULK_DISPOSALS;

				public int getRT_EOD_ADD_BULK_DISPOSALS () {
					return this.RT_EOD_ADD_BULK_DISPOSALS;
				}
				
			    public int RT_EOD_ADD_RACK_DISPOSALS;

				public int getRT_EOD_ADD_RACK_DISPOSALS () {
					return this.RT_EOD_ADD_RACK_DISPOSALS;
				}
				
			    public int RT_EOD_ADD_TRANSFERS_OUT;

				public int getRT_EOD_ADD_TRANSFERS_OUT () {
					return this.RT_EOD_ADD_TRANSFERS_OUT;
				}
				
			    public int RT_EOD_ADD_BOOK_INVENTORY;

				public int getRT_EOD_ADD_BOOK_INVENTORY () {
					return this.RT_EOD_ADD_BOOK_INVENTORY;
				}
				
			    public int RT_IN_SERVICE;

				public int getRT_IN_SERVICE () {
					return this.RT_IN_SERVICE;
				}
				
			    public int VIRTUAL_TANK;

				public int getVIRTUAL_TANK () {
					return this.VIRTUAL_TANK;
				}
				
			    public String DDE_IN_SERVICE_ITEM;

				public String getDDE_IN_SERVICE_ITEM () {
					return this.DDE_IN_SERVICE_ITEM;
				}
				
			    public String TANK_GROUP;

				public String getTANK_GROUP () {
					return this.TANK_GROUP;
				}
				
			    public String DDE_IN_SERVICE_DSN;

				public String getDDE_IN_SERVICE_DSN () {
					return this.DDE_IN_SERVICE_DSN;
				}
				
			    public int RT_CUTOFF_QUANTITY;

				public int getRT_CUTOFF_QUANTITY () {
					return this.RT_CUTOFF_QUANTITY;
				}
				
			    public int AUTO_NET_QUANTITY_ENABLE;

				public int getAUTO_NET_QUANTITY_ENABLE () {
					return this.AUTO_NET_QUANTITY_ENABLE;
				}
				
			    public String DDE_NET_QUANTITY_ITEM;

				public String getDDE_NET_QUANTITY_ITEM () {
					return this.DDE_NET_QUANTITY_ITEM;
				}
				
			    public int RT_AUTO_NET_QUANTITY;

				public int getRT_AUTO_NET_QUANTITY () {
					return this.RT_AUTO_NET_QUANTITY;
				}
				
			    public String DDE_NET_QUANTITY_DSN;

				public String getDDE_NET_QUANTITY_DSN () {
					return this.DDE_NET_QUANTITY_DSN;
				}
				
			    public int MANUAL_NET_QUANTITY_ENABLE;

				public int getMANUAL_NET_QUANTITY_ENABLE () {
					return this.MANUAL_NET_QUANTITY_ENABLE;
				}
				
			    public int MANUAL_NET_QUANTITY;

				public int getMANUAL_NET_QUANTITY () {
					return this.MANUAL_NET_QUANTITY;
				}
				
			    public String HIGH_BSW_SETPOINT;

				public String getHIGH_BSW_SETPOINT () {
					return this.HIGH_BSW_SETPOINT;
				}
				
			    public int HIGH_BSW_QUANTITY;

				public int getHIGH_BSW_QUANTITY () {
					return this.HIGH_BSW_QUANTITY;
				}
				
			    public String DDE_BSW_HIGH_ALARM_DSN;

				public String getDDE_BSW_HIGH_ALARM_DSN () {
					return this.DDE_BSW_HIGH_ALARM_DSN;
				}
				
			    public String DDE_BSW_HIGH_ALARM_ITEM;

				public String getDDE_BSW_HIGH_ALARM_ITEM () {
					return this.DDE_BSW_HIGH_ALARM_ITEM;
				}
				
			    public int RT_EOD_BULK_FRAC_DISPOSALS;

				public int getRT_EOD_BULK_FRAC_DISPOSALS () {
					return this.RT_EOD_BULK_FRAC_DISPOSALS;
				}
				
			    public int RT_EOD_BULK_FRAC_RECEIPTS;

				public int getRT_EOD_BULK_FRAC_RECEIPTS () {
					return this.RT_EOD_BULK_FRAC_RECEIPTS;
				}
				
			    public String RT_EOD_OPEN_BSW_LEVEL;

				public String getRT_EOD_OPEN_BSW_LEVEL () {
					return this.RT_EOD_OPEN_BSW_LEVEL;
				}
				
			    public double RT_EOD_OPEN_DENSITY;

				public double getRT_EOD_OPEN_DENSITY () {
					return this.RT_EOD_OPEN_DENSITY;
				}
				
			    public double RT_EOD_OPEN_TEMPERATURE;

				public double getRT_EOD_OPEN_TEMPERATURE () {
					return this.RT_EOD_OPEN_TEMPERATURE;
				}
				
			    public int RT_EOD_OPEN_BSW_QUANTITY;

				public int getRT_EOD_OPEN_BSW_QUANTITY () {
					return this.RT_EOD_OPEN_BSW_QUANTITY;
				}
				
			    public String RT_EOD_OPEN_LEVEL;

				public String getRT_EOD_OPEN_LEVEL () {
					return this.RT_EOD_OPEN_LEVEL;
				}
				
			    public double RT_EOD_OPEN_OBSERVED_DENSITY;

				public double getRT_EOD_OPEN_OBSERVED_DENSITY () {
					return this.RT_EOD_OPEN_OBSERVED_DENSITY;
				}
				
			    public int RT_EOD_OPEN_PHYS_GROSS_QTY;

				public int getRT_EOD_OPEN_PHYS_GROSS_QTY () {
					return this.RT_EOD_OPEN_PHYS_GROSS_QTY;
				}
				
			    public String PREV_EOD_LEVEL;

				public String getPREV_EOD_LEVEL () {
					return this.PREV_EOD_LEVEL;
				}
				
			    public int PREV_EOD_GROSS_QUANTITY;

				public int getPREV_EOD_GROSS_QUANTITY () {
					return this.PREV_EOD_GROSS_QUANTITY;
				}
				
			    public double PREV_EOD_TEMPERATURE;

				public double getPREV_EOD_TEMPERATURE () {
					return this.PREV_EOD_TEMPERATURE;
				}
				
			    public double PREV_EOD_DENSITY;

				public double getPREV_EOD_DENSITY () {
					return this.PREV_EOD_DENSITY;
				}
				
			    public int PREV_EOD_BSW_QUANTITY;

				public int getPREV_EOD_BSW_QUANTITY () {
					return this.PREV_EOD_BSW_QUANTITY;
				}
				
			    public String PREV_EOD_BSW_LEVEL;

				public String getPREV_EOD_BSW_LEVEL () {
					return this.PREV_EOD_BSW_LEVEL;
				}
				
			    public int RT_PREV_EOD_NET_QUANTITY;

				public int getRT_PREV_EOD_NET_QUANTITY () {
					return this.RT_PREV_EOD_NET_QUANTITY;
				}
				
			    public double PREV_EOD_COE;

				public double getPREV_EOD_COE () {
					return this.PREV_EOD_COE;
				}
				
			    public int RT_PREV_EOD_BSW_QUANTITY;

				public int getRT_PREV_EOD_BSW_QUANTITY () {
					return this.RT_PREV_EOD_BSW_QUANTITY;
				}
				
			    public int PREV_EOD_QUANTITY;

				public int getPREV_EOD_QUANTITY () {
					return this.PREV_EOD_QUANTITY;
				}
				
			    public double OPENING_COE;

				public double getOPENING_COE () {
					return this.OPENING_COE;
				}
				
			    public int RT_TOV;

				public int getRT_TOV () {
					return this.RT_TOV;
				}
				
			    public int RT_GOV;

				public int getRT_GOV () {
					return this.RT_GOV;
				}
				
			    public int RT_GSV;

				public int getRT_GSV () {
					return this.RT_GSV;
				}
				
			    public int RT_TCV;

				public int getRT_TCV () {
					return this.RT_TCV;
				}
				
			    public double RT_SHELL_CORRECTION_FACTOR;

				public double getRT_SHELL_CORRECTION_FACTOR () {
					return this.RT_SHELL_CORRECTION_FACTOR;
				}
				
			    public int RT_FLOATING_ROOF_ADJUSTMENT;

				public int getRT_FLOATING_ROOF_ADJUSTMENT () {
					return this.RT_FLOATING_ROOF_ADJUSTMENT;
				}
				
			    public double RT_CTL;

				public double getRT_CTL () {
					return this.RT_CTL;
				}
				
			    public double SUSPENDED_BSW_PERCENT;

				public double getSUSPENDED_BSW_PERCENT () {
					return this.SUSPENDED_BSW_PERCENT;
				}
				
			    public int MANUAL_STRAP_TYPE;

				public int getMANUAL_STRAP_TYPE () {
					return this.MANUAL_STRAP_TYPE;
				}
				
			    public int ROOF_TAKE_OFF_STRAP_TYPE;

				public int getROOF_TAKE_OFF_STRAP_TYPE () {
					return this.ROOF_TAKE_OFF_STRAP_TYPE;
				}
				
			    public int ROOF_SUPPORT_STRAP_TYPE;

				public int getROOF_SUPPORT_STRAP_TYPE () {
					return this.ROOF_SUPPORT_STRAP_TYPE;
				}
				
			    public int HIGH_BSW_STRAP_TYPE;

				public int getHIGH_BSW_STRAP_TYPE () {
					return this.HIGH_BSW_STRAP_TYPE;
				}
				
			    public int BASE_SEDIMENT_WATER_STRAP_TYPE;

				public int getBASE_SEDIMENT_WATER_STRAP_TYPE () {
					return this.BASE_SEDIMENT_WATER_STRAP_TYPE;
				}
				
			    public String GAUGER_INITIALS;

				public String getGAUGER_INITIALS () {
					return this.GAUGER_INITIALS;
				}
				
			    public java.util.Date GAUGE_TIMESTAMP;

				public java.util.Date getGAUGE_TIMESTAMP () {
					return this.GAUGE_TIMESTAMP;
				}
				
			    public int LEVEL_UNITS;

				public int getLEVEL_UNITS () {
					return this.LEVEL_UNITS;
				}
				
			    public double SHELL_BASE_TEMPERATURE;

				public double getSHELL_BASE_TEMPERATURE () {
					return this.SHELL_BASE_TEMPERATURE;
				}
				
			    public int SHELL_MATERIAL_TYPE;

				public int getSHELL_MATERIAL_TYPE () {
					return this.SHELL_MATERIAL_TYPE;
				}
				
			    public double MANUAL_AMBIENT_TEMPERATURE;

				public double getMANUAL_AMBIENT_TEMPERATURE () {
					return this.MANUAL_AMBIENT_TEMPERATURE;
				}
				
			    public int INSULATED;

				public int getINSULATED () {
					return this.INSULATED;
				}
				
			    public int LINE_SEGMENT_NSV;

				public int getLINE_SEGMENT_NSV () {
					return this.LINE_SEGMENT_NSV;
				}
				
			    public int RT_CALCULATION_POINT;

				public int getRT_CALCULATION_POINT () {
					return this.RT_CALCULATION_POINT;
				}
				
			    public int ROOF_TAKE_OFF_TOV;

				public int getROOF_TAKE_OFF_TOV () {
					return this.ROOF_TAKE_OFF_TOV;
				}
				
			    public int RT_NSV;

				public int getRT_NSV () {
					return this.RT_NSV;
				}
				
			    public int RT_GSW;

				public int getRT_GSW () {
					return this.RT_GSW;
				}
				
			    public int RT_NSW;

				public int getRT_NSW () {
					return this.RT_NSW;
				}
				
			    public double RT_WCF;

				public double getRT_WCF () {
					return this.RT_WCF;
				}
				
			    public int LINE_SEGMENT_NSW;

				public int getLINE_SEGMENT_NSW () {
					return this.LINE_SEGMENT_NSW;
				}
				
			    public double ROOF_WEIGHT;

				public double getROOF_WEIGHT () {
					return this.ROOF_WEIGHT;
				}
				
			    public int VOL_IN_ALARM;

				public int getVOL_IN_ALARM () {
					return this.VOL_IN_ALARM;
				}
				
			    public int INACTIVITY_QUANTITY;

				public int getINACTIVITY_QUANTITY () {
					return this.INACTIVITY_QUANTITY;
				}
				
			    public int INACTIVITY_ALARM_STATE;

				public int getINACTIVITY_ALARM_STATE () {
					return this.INACTIVITY_ALARM_STATE;
				}
				
			    public int USER_LEVEL;

				public int getUSER_LEVEL () {
					return this.USER_LEVEL;
				}
				
			    public java.util.Date SCHED_PROD_CHANGE_DATE_TIME;

				public java.util.Date getSCHED_PROD_CHANGE_DATE_TIME () {
					return this.SCHED_PROD_CHANGE_DATE_TIME;
				}
				
			    public int SCHED_PROD_CHANGE_TIMEOUT;

				public int getSCHED_PROD_CHANGE_TIMEOUT () {
					return this.SCHED_PROD_CHANGE_TIMEOUT;
				}
				
			    public String SCHED_PROD_CHANGE_EMAIL;

				public String getSCHED_PROD_CHANGE_EMAIL () {
					return this.SCHED_PROD_CHANGE_EMAIL;
				}
				
			    public int SETPOINT_QUANTITY_ENABLE;

				public int getSETPOINT_QUANTITY_ENABLE () {
					return this.SETPOINT_QUANTITY_ENABLE;
				}
				
			    public double MANUAL_MEASURED_DENSITY;

				public double getMANUAL_MEASURED_DENSITY () {
					return this.MANUAL_MEASURED_DENSITY;
				}
				
			    public int WEIGHT_IN_AIR;

				public int getWEIGHT_IN_AIR () {
					return this.WEIGHT_IN_AIR;
				}
				
			    public int TOPS_MONITORING_ACTIVE;

				public int getTOPS_MONITORING_ACTIVE () {
					return this.TOPS_MONITORING_ACTIVE;
				}
				
			    public int SHAPE;

				public int getSHAPE () {
					return this.SHAPE;
				}
				
			    public int ACTUAL_FLOW_RATE_PERIOD;

				public int getACTUAL_FLOW_RATE_PERIOD () {
					return this.ACTUAL_FLOW_RATE_PERIOD;
				}
				
			    public int CALCULATED_FLOW_RATE_PERIOD;

				public int getCALCULATED_FLOW_RATE_PERIOD () {
					return this.CALCULATED_FLOW_RATE_PERIOD;
				}
				
			    public int FLOW_RATE_CLAMPING_PERIOD;

				public int getFLOW_RATE_CLAMPING_PERIOD () {
					return this.FLOW_RATE_CLAMPING_PERIOD;
				}
				
			    public java.util.Date RT_CLAMPING_PERIOD_START;

				public java.util.Date getRT_CLAMPING_PERIOD_START () {
					return this.RT_CLAMPING_PERIOD_START;
				}
				
			    public int VAPOR_CORRECTION_METHOD;

				public int getVAPOR_CORRECTION_METHOD () {
					return this.VAPOR_CORRECTION_METHOD;
				}
				
			    public double VAPOR_TEMPERATURE;

				public double getVAPOR_TEMPERATURE () {
					return this.VAPOR_TEMPERATURE;
				}
				
			    public double VAPOR_LIQUID_VOLUME_RATIO;

				public double getVAPOR_LIQUID_VOLUME_RATIO () {
					return this.VAPOR_LIQUID_VOLUME_RATIO;
				}
				
			    public int TARGET_LEVEL;

				public int getTARGET_LEVEL () {
					return this.TARGET_LEVEL;
				}
				
			    public int ORIGINAL_STARTING_LEVEL;

				public int getORIGINAL_STARTING_LEVEL () {
					return this.ORIGINAL_STARTING_LEVEL;
				}
				
			    public int TIME_TO_TARGET_LEVEL;

				public int getTIME_TO_TARGET_LEVEL () {
					return this.TIME_TO_TARGET_LEVEL;
				}
				
			    public int AUTO_VAPOR_TEMPERATURE_ENABLE;

				public int getAUTO_VAPOR_TEMPERATURE_ENABLE () {
					return this.AUTO_VAPOR_TEMPERATURE_ENABLE;
				}
				
			    public String DDE_PRESSURE_DSN;

				public String getDDE_PRESSURE_DSN () {
					return this.DDE_PRESSURE_DSN;
				}
				
			    public String DDE_PRESSURE_ITEM;

				public String getDDE_PRESSURE_ITEM () {
					return this.DDE_PRESSURE_ITEM;
				}
				
			    public String DDE_VAPOR_TEMPERATURE_DSN;

				public String getDDE_VAPOR_TEMPERATURE_DSN () {
					return this.DDE_VAPOR_TEMPERATURE_DSN;
				}
				
			    public String DDE_VAPOR_TEMPERATURE_ITEM;

				public String getDDE_VAPOR_TEMPERATURE_ITEM () {
					return this.DDE_VAPOR_TEMPERATURE_ITEM;
				}
				
			    public double RT_AUTO_VAPOR_TEMPERATURE;

				public double getRT_AUTO_VAPOR_TEMPERATURE () {
					return this.RT_AUTO_VAPOR_TEMPERATURE;
				}
				
			    public double RT_VAPOR_TEMPERATURE;

				public double getRT_VAPOR_TEMPERATURE () {
					return this.RT_VAPOR_TEMPERATURE;
				}
				
			    public int INVENTORY_ENABLE;

				public int getINVENTORY_ENABLE () {
					return this.INVENTORY_ENABLE;
				}
				
			    public int MANUAL_TO_AUTO_FOLIO_LIMIT;

				public int getMANUAL_TO_AUTO_FOLIO_LIMIT () {
					return this.MANUAL_TO_AUTO_FOLIO_LIMIT;
				}
				
			    public int RT_MANUAL_TO_AUTO_FOLIO_COUNT;

				public int getRT_MANUAL_TO_AUTO_FOLIO_COUNT () {
					return this.RT_MANUAL_TO_AUTO_FOLIO_COUNT;
				}
				
			    public int RT_LEVEL_ORIGIN;

				public int getRT_LEVEL_ORIGIN () {
					return this.RT_LEVEL_ORIGIN;
				}
				
			    public int RT_TOV_ORIGIN;

				public int getRT_TOV_ORIGIN () {
					return this.RT_TOV_ORIGIN;
				}
				
			    public int RT_TEMPERATURE_ORIGIN;

				public int getRT_TEMPERATURE_ORIGIN () {
					return this.RT_TEMPERATURE_ORIGIN;
				}
				
			    public int RT_DENSITY_ORIGIN;

				public int getRT_DENSITY_ORIGIN () {
					return this.RT_DENSITY_ORIGIN;
				}
				
			    public int RT_NSV_ORIGIN;

				public int getRT_NSV_ORIGIN () {
					return this.RT_NSV_ORIGIN;
				}
				
			    public int RT_VAPOR_TEMPERATURE_ORIGIN;

				public int getRT_VAPOR_TEMPERATURE_ORIGIN () {
					return this.RT_VAPOR_TEMPERATURE_ORIGIN;
				}
				
			    public int RT_PRESSURE_ORIGIN;

				public int getRT_PRESSURE_ORIGIN () {
					return this.RT_PRESSURE_ORIGIN;
				}
				
			    public int RT_FREE_WATER_LEVEL_ORIGIN;

				public int getRT_FREE_WATER_LEVEL_ORIGIN () {
					return this.RT_FREE_WATER_LEVEL_ORIGIN;
				}
				
			    public int RT_WATER_QUANTITY_ORIGIN;

				public int getRT_WATER_QUANTITY_ORIGIN () {
					return this.RT_WATER_QUANTITY_ORIGIN;
				}
				
			    public String DDE_SNAPSHOT_REQ_DSN;

				public String getDDE_SNAPSHOT_REQ_DSN () {
					return this.DDE_SNAPSHOT_REQ_DSN;
				}
				
			    public String DDE_SNAPSHOT_REQ_ITEM;

				public String getDDE_SNAPSHOT_REQ_ITEM () {
					return this.DDE_SNAPSHOT_REQ_ITEM;
				}
				
			    public String DDE_SNAPSHOT_RSP_DSN;

				public String getDDE_SNAPSHOT_RSP_DSN () {
					return this.DDE_SNAPSHOT_RSP_DSN;
				}
				
			    public String DDE_SNAPSHOT_RSP_ITEM;

				public String getDDE_SNAPSHOT_RSP_ITEM () {
					return this.DDE_SNAPSHOT_RSP_ITEM;
				}
				
			    public int AUTO_PRODUCT_LEVEL_UNIT;

				public int getAUTO_PRODUCT_LEVEL_UNIT () {
					return this.AUTO_PRODUCT_LEVEL_UNIT;
				}
				
			    public int AUTO_FREE_WATER_LEVEL_UNIT;

				public int getAUTO_FREE_WATER_LEVEL_UNIT () {
					return this.AUTO_FREE_WATER_LEVEL_UNIT;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PGS_STAGE_DIM_TANK.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_TANK.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_TANK = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_TANK = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PGS_STAGE_DIM_TANK, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_TANK, 0, length, utf8Charset);
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
			if(length > commonByteArray_PGS_STAGE_DIM_TANK.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_TANK.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_TANK = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_TANK = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PGS_STAGE_DIM_TANK, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_TANK, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_TANK) {

        	try {

        		int length = 0;
		
					this.TANK_CODE = readString(dis);
					
					this.NAME = readString(dis);
					
						this.COMPARTMENT_OWNER_ID = readInteger(dis);
					
						this.MAJORITY_SHAREHOLDER = readInteger(dis);
					
					this.COMPARTMENT_CONTAINER_CODE = readString(dis);
					
			        this.RT_GROSS_QUANTITY = dis.readInt();
					
						this.COMPARTMENT_CONTAINER_TYPE = readInteger(dis);
					
			        this.TERMINAL_PRODUCT_NUMBER = dis.readInt();
					
						this.COMPARTMENT_NUMBER = readInteger(dis);
					
			        this.RT_NET_QUANTITY = dis.readInt();
					
			        this.ENABLE = dis.readInt();
					
						this.SCHED_PROD_CHANGE_PRODUCT = readInteger(dis);
					
			        this.RVP = dis.readDouble();
					
			        this.OXYGEN = dis.readDouble();
					
			        this.RT_TEMPERATURE = dis.readDouble();
					
			        this.RT_DENSITY = dis.readDouble();
					
			        this.SHELL_CAPACITY = dis.readInt();
					
			        this.WORK_CAPACITY = dis.readInt();
					
					this.DEPTH = readString(dis);
					
					this.LOW_LOW_SETPOINT = readString(dis);
					
					this.LOW_SETPOINT = readString(dis);
					
					this.GENERAL_SETPOINT = readString(dis);
					
					this.CUTOFF_SETPOINT = readString(dis);
					
			        this.AUTO_ENABLE = dis.readInt();
					
					this.HIGH_SETPOINT = readString(dis);
					
					this.HIGH_HIGH_SETPOINT = readString(dis);
					
			        this.DEADBAND = dis.readInt();
					
			        this.AUTO_LEVEL_ENABLE = dis.readInt();
					
					this.DDE_LEVEL_DSN = readString(dis);
					
			        this.AUTO_DENSITY_ENABLE = dis.readInt();
					
			        this.AUTO_TEMPERATURE_ENABLE = dis.readInt();
					
					this.DDE_LEVEL_ITEM = readString(dis);
					
			        this.AUTO_QUANTITY_ENABLE = dis.readInt();
					
					this.DDE_DENSITY_DSN = readString(dis);
					
			        this.ACTIVITY_STATUS = dis.readInt();
					
					this.DDE_DENSITY_ITEM = readString(dis);
					
					this.DDE_TEMPERATURE_DSN = readString(dis);
					
			        this.RECEIPT_INDICATOR = dis.readInt();
					
					this.DDE_TEMPERATURE_ITEM = readString(dis);
					
					this.LAST_RECEIPT_DATE = readDate(dis);
					
					this.DDE_QUANTITY_DSN = readString(dis);
					
					this.DDE_QUANTITY_ITEM = readString(dis);
					
			        this.SEND_TO_HOST_AT_EOD = dis.readInt();
					
					this.MANUAL_LEVEL = readString(dis);
					
					this.RT_AUTO_LEVEL = readString(dis);
					
					this.EOM_MANUAL_LEVEL = readString(dis);
					
			        this.RT_EOM_GROSS_QUANTITY = dis.readInt();
					
			        this.RT_AUTO_DENSITY = dis.readDouble();
					
			        this.EOM_MANUAL_TEMPERATURE = dis.readDouble();
					
			        this.EOM_MANUAL_DENSITY = dis.readDouble();
					
			        this.EOM_MANUAL_BSW_QUANTITY = dis.readInt();
					
					this.EOM_MANUAL_BSW_LEVEL = readString(dis);
					
			        this.MANUAL_TEMPERATURE = dis.readDouble();
					
			        this.RT_EOM_NET_QUANTITY = dis.readInt();
					
			        this.EOM_MANUAL_COE = dis.readDouble();
					
			        this.RT_EOM_BSW_QUANTITY = dis.readInt();
					
					this.MANUAL_DATE = readDate(dis);
					
					this.BASE_SEDIMENT_WATER_LEVEL = readString(dis);
					
			        this.MANUAL_DENSITY = dis.readDouble();
					
			        this.RT_BSW_QUANTITY = dis.readInt();
					
			        this.MANUAL_SPECIFIC_GRAVITY = dis.readDouble();
					
			        this.PIPE_FILL = dis.readInt();
					
			        this.MANUAL_COEFFICIENT_EXPANSION = dis.readDouble();
					
			        this.PROTOCOL_TYPE = dis.readInt();
					
			        this.RT_AUTO_TEMPERATURE = dis.readDouble();
					
					this.PORT_NAME = readString(dis);
					
			        this.RT_AUTO_QUANTITY = dis.readInt();
					
			        this.ADDRESS = dis.readInt();
					
					this.REMARKS = readString(dis);
					
			        this.FAST_SCAN = dis.readInt();
					
					this.RT_LEVEL = readString(dis);
					
			        this.RT_METER_COUNT = dis.readInt();
					
			        this.RT_GROSS_SNAPSHOT = dis.readInt();
					
			        this.RT_SNAPSHOT_ACTIVE = dis.readInt();
					
					this.RT_LEVEL_SNAPSHOT = readString(dis);
					
			        this.RT_NET_SNAPSHOT = dis.readInt();
					
					this.RT_SNAPSHOT_DATE = readDate(dis);
					
			        this.RT_GROSS_SNAPSHOT_DELTA = dis.readInt();
					
			        this.RT_NET_SNAPSHOT_DELTA = dis.readInt();
					
			        this.RT_EOD_MANUAL_DELTA = dis.readInt();
					
					this.RT_END_LEVEL_SNAPSHOT = readString(dis);
					
			        this.RT_EOD_OPENING_PHYSICAL = dis.readInt();
					
			        this.RT_EOD_BULK_RECEIPTS = dis.readInt();
					
			        this.RT_END_GROSS_SNAPSHOT = dis.readInt();
					
			        this.RT_AVAILABLE_QUANTITY = dis.readInt();
					
			        this.RT_END_NET_SNAPSHOT = dis.readInt();
					
			        this.RT_EOD_BULK_DISPOSALS = dis.readInt();
					
					this.RT_END_SNAPSHOT_DATE = readDate(dis);
					
			        this.RT_EOD_TRANSFERS_IN = dis.readInt();
					
			        this.RT_EOD_RACK_RECEIPTS = dis.readInt();
					
			        this.RT_EOD_TRANSFERS_OUT = dis.readInt();
					
			        this.RT_EOD_RACK_DISPOSALS = dis.readInt();
					
					this.LAST_USER_NAME = readString(dis);
					
					this.LAST_MODIFIED = readDate(dis);
					
			        this.RT_EOD_BOOK_INVENTORY = dis.readInt();
					
					this.USER_DLL = readString(dis);
					
					this.USER_ROUTINE = readString(dis);
					
			        this.ROOF_CORRECTION_TYPE = dis.readInt();
					
					this.ROOF_TAKE_OFF_LEVEL = readString(dis);
					
					this.ROOF_SUPPORT_LEVEL = readString(dis);
					
			        this.ROOF_REFERENCE_DENSITY = dis.readDouble();
					
			        this.ROOF_ABOVE_ADJUSTMENT = dis.readDouble();
					
			        this.RT_EOD_MANUAL_CLOSING_ENABLE = dis.readInt();
					
			        this.ROOF_BELOW_ADJUSTMENT = dis.readDouble();
					
					this.RT_EOD_MANUAL_LEVEL = readString(dis);
					
			        this.STRAPPING_INVERTED = dis.readInt();
					
			        this.RT_EOD_MANUAL_GROSS_QUANTITY = dis.readInt();
					
			        this.RT_EOD_MANUAL_NET_QUANTITY = dis.readInt();
					
			        this.RT_EOD_RACK_FRAC_DISPOSALS = dis.readInt();
					
			        this.RT_EOD_RACK_FRAC_RECEIPTS = dis.readInt();
					
					this.DDE_HIGH_ALARM_DSN = readString(dis);
					
					this.DDE_HIGH_ALARM_ITEM = readString(dis);
					
					this.DDE_HIGH_HIGH_ALARM_DSN = readString(dis);
					
					this.DDE_HIGH_HIGH_ALARM_ITEM = readString(dis);
					
					this.DDE_LOW_ALARM_DSN = readString(dis);
					
					this.DDE_LOW_ALARM_ITEM = readString(dis);
					
					this.DDE_LOW_LOW_ALARM_DSN = readString(dis);
					
					this.DDE_LOW_LOW_ALARM_ITEM = readString(dis);
					
					this.DDE_CUTOFF_ALARM_DSN = readString(dis);
					
					this.DDE_CUTOFF_ALARM_ITEM = readString(dis);
					
					this.DDE_STATUS_DSN = readString(dis);
					
					this.DDE_STATUS_ITEM = readString(dis);
					
			        this.RT_AUTO_PRESSURE = dis.readDouble();
					
			        this.RT_AUTO_MASS = dis.readInt();
					
			        this.MANUAL_PRESSURE = dis.readDouble();
					
			        this.MANUAL_MASS = dis.readInt();
					
			        this.RT_PRESSURE = dis.readDouble();
					
			        this.RT_MASS = dis.readInt();
					
			        this.AUTO_PRESSURE_ENABLE = dis.readInt();
					
			        this.AUTO_MASS_ENABLE = dis.readInt();
					
			        this.DOWNLOAD_ENABLE = dis.readInt();
					
			        this.DOWNLOAD_LEVEL_ENABLE = dis.readInt();
					
			        this.DOWNLOAD_QUANTITY_ENABLE = dis.readInt();
					
			        this.DOWNLOAD_TEMPERATURE_ENABLE = dis.readInt();
					
			        this.DOWNLOAD_PRESSURE_ENABLE = dis.readInt();
					
			        this.DOWNLOAD_MASS_ENABLE = dis.readInt();
					
			        this.RT_USER_QUEUE_ENABLE = dis.readInt();
					
			        this.RT_USER_CONTEXT_VALUE = dis.readInt();
					
			        this.RT_FRAC_GROSS_SNAPSHOT_DELTA = dis.readInt();
					
			        this.RT_FRAC_NET_SNAPSHOT_DELTA = dis.readInt();
					
			        this.RT_FRAC_EOD_MANUAL_DELTA = dis.readInt();
					
			        this.RT_TEMPERATURE_SNAPSHOT = dis.readDouble();
					
			        this.RT_DENSITY_SNAPSHOT = dis.readDouble();
					
			        this.RT_END_TEMPERATURE_SNAPSHOT = dis.readDouble();
					
			        this.RT_END_DENSITY_SNAPSHOT = dis.readDouble();
					
			        this.RT_FRAC_EOD_TRANSFERS_IN = dis.readInt();
					
			        this.RT_FRAC_EOD_TRANSFERS_OUT = dis.readInt();
					
			        this.MANUAL_QUANTITY_ENABLE = dis.readInt();
					
			        this.MANUAL_BSW_QUANTITY = dis.readInt();
					
			        this.EOM_MANUAL_QUANTITY = dis.readInt();
					
			        this.MANUAL_GROSS_QUANTITY = dis.readInt();
					
			        this.MANUAL_LOW_LOW_QUANTITY = dis.readInt();
					
			        this.MANUAL_LOW_QUANTITY = dis.readInt();
					
			        this.MANUAL_GENERAL_QUANTITY = dis.readInt();
					
			        this.MANUAL_CUTOFF_QUANTITY = dis.readInt();
					
			        this.MANUAL_HIGH_QUANTITY = dis.readInt();
					
			        this.MANUAL_HIGH_HIGH_QUANTITY = dis.readInt();
					
			        this.MANUAL_OBSERVED_DENSITY = dis.readDouble();
					
			        this.RT_OBSERVED_DENSITY = dis.readDouble();
					
			        this.RT_OBS_DENSITY_SNAPSHOT = dis.readDouble();
					
			        this.RT_END_OBS_DENSITY_SNAPSHOT = dis.readDouble();
					
			        this.AUTO_BSW_LEVEL_ENABLE = dis.readInt();
					
			        this.AUTO_BSW_QUANTITY_ENABLE = dis.readInt();
					
					this.RT_AUTO_BSW_LEVEL = readString(dis);
					
			        this.RT_AUTO_BSW_QUANTITY = dis.readInt();
					
					this.RT_BSW_LEVEL = readString(dis);
					
					this.DDE_BSW_LEVEL_DSN = readString(dis);
					
					this.DDE_BSW_LEVEL_ITEM = readString(dis);
					
					this.DDE_BSW_QUANTITY_DSN = readString(dis);
					
					this.DDE_BSW_QUANTITY_ITEM = readString(dis);
					
			        this.DOWNLOAD_DENSITY_ENABLE = dis.readInt();
					
			        this.RT_EOD_ADD_MANUAL_DELTA = dis.readInt();
					
			        this.RT_EOD_ADD_BULK_RECEIPTS = dis.readInt();
					
			        this.RT_EOD_ADD_RACK_RECEIPTS = dis.readInt();
					
			        this.RT_EOD_ADD_TRANSFERS_IN = dis.readInt();
					
			        this.RT_EOD_ADD_BULK_DISPOSALS = dis.readInt();
					
			        this.RT_EOD_ADD_RACK_DISPOSALS = dis.readInt();
					
			        this.RT_EOD_ADD_TRANSFERS_OUT = dis.readInt();
					
			        this.RT_EOD_ADD_BOOK_INVENTORY = dis.readInt();
					
			        this.RT_IN_SERVICE = dis.readInt();
					
			        this.VIRTUAL_TANK = dis.readInt();
					
					this.DDE_IN_SERVICE_ITEM = readString(dis);
					
					this.TANK_GROUP = readString(dis);
					
					this.DDE_IN_SERVICE_DSN = readString(dis);
					
			        this.RT_CUTOFF_QUANTITY = dis.readInt();
					
			        this.AUTO_NET_QUANTITY_ENABLE = dis.readInt();
					
					this.DDE_NET_QUANTITY_ITEM = readString(dis);
					
			        this.RT_AUTO_NET_QUANTITY = dis.readInt();
					
					this.DDE_NET_QUANTITY_DSN = readString(dis);
					
			        this.MANUAL_NET_QUANTITY_ENABLE = dis.readInt();
					
			        this.MANUAL_NET_QUANTITY = dis.readInt();
					
					this.HIGH_BSW_SETPOINT = readString(dis);
					
			        this.HIGH_BSW_QUANTITY = dis.readInt();
					
					this.DDE_BSW_HIGH_ALARM_DSN = readString(dis);
					
					this.DDE_BSW_HIGH_ALARM_ITEM = readString(dis);
					
			        this.RT_EOD_BULK_FRAC_DISPOSALS = dis.readInt();
					
			        this.RT_EOD_BULK_FRAC_RECEIPTS = dis.readInt();
					
					this.RT_EOD_OPEN_BSW_LEVEL = readString(dis);
					
			        this.RT_EOD_OPEN_DENSITY = dis.readDouble();
					
			        this.RT_EOD_OPEN_TEMPERATURE = dis.readDouble();
					
			        this.RT_EOD_OPEN_BSW_QUANTITY = dis.readInt();
					
					this.RT_EOD_OPEN_LEVEL = readString(dis);
					
			        this.RT_EOD_OPEN_OBSERVED_DENSITY = dis.readDouble();
					
			        this.RT_EOD_OPEN_PHYS_GROSS_QTY = dis.readInt();
					
					this.PREV_EOD_LEVEL = readString(dis);
					
			        this.PREV_EOD_GROSS_QUANTITY = dis.readInt();
					
			        this.PREV_EOD_TEMPERATURE = dis.readDouble();
					
			        this.PREV_EOD_DENSITY = dis.readDouble();
					
			        this.PREV_EOD_BSW_QUANTITY = dis.readInt();
					
					this.PREV_EOD_BSW_LEVEL = readString(dis);
					
			        this.RT_PREV_EOD_NET_QUANTITY = dis.readInt();
					
			        this.PREV_EOD_COE = dis.readDouble();
					
			        this.RT_PREV_EOD_BSW_QUANTITY = dis.readInt();
					
			        this.PREV_EOD_QUANTITY = dis.readInt();
					
			        this.OPENING_COE = dis.readDouble();
					
			        this.RT_TOV = dis.readInt();
					
			        this.RT_GOV = dis.readInt();
					
			        this.RT_GSV = dis.readInt();
					
			        this.RT_TCV = dis.readInt();
					
			        this.RT_SHELL_CORRECTION_FACTOR = dis.readDouble();
					
			        this.RT_FLOATING_ROOF_ADJUSTMENT = dis.readInt();
					
			        this.RT_CTL = dis.readDouble();
					
			        this.SUSPENDED_BSW_PERCENT = dis.readDouble();
					
			        this.MANUAL_STRAP_TYPE = dis.readInt();
					
			        this.ROOF_TAKE_OFF_STRAP_TYPE = dis.readInt();
					
			        this.ROOF_SUPPORT_STRAP_TYPE = dis.readInt();
					
			        this.HIGH_BSW_STRAP_TYPE = dis.readInt();
					
			        this.BASE_SEDIMENT_WATER_STRAP_TYPE = dis.readInt();
					
					this.GAUGER_INITIALS = readString(dis);
					
					this.GAUGE_TIMESTAMP = readDate(dis);
					
			        this.LEVEL_UNITS = dis.readInt();
					
			        this.SHELL_BASE_TEMPERATURE = dis.readDouble();
					
			        this.SHELL_MATERIAL_TYPE = dis.readInt();
					
			        this.MANUAL_AMBIENT_TEMPERATURE = dis.readDouble();
					
			        this.INSULATED = dis.readInt();
					
			        this.LINE_SEGMENT_NSV = dis.readInt();
					
			        this.RT_CALCULATION_POINT = dis.readInt();
					
			        this.ROOF_TAKE_OFF_TOV = dis.readInt();
					
			        this.RT_NSV = dis.readInt();
					
			        this.RT_GSW = dis.readInt();
					
			        this.RT_NSW = dis.readInt();
					
			        this.RT_WCF = dis.readDouble();
					
			        this.LINE_SEGMENT_NSW = dis.readInt();
					
			        this.ROOF_WEIGHT = dis.readDouble();
					
			        this.VOL_IN_ALARM = dis.readInt();
					
			        this.INACTIVITY_QUANTITY = dis.readInt();
					
			        this.INACTIVITY_ALARM_STATE = dis.readInt();
					
			        this.USER_LEVEL = dis.readInt();
					
					this.SCHED_PROD_CHANGE_DATE_TIME = readDate(dis);
					
			        this.SCHED_PROD_CHANGE_TIMEOUT = dis.readInt();
					
					this.SCHED_PROD_CHANGE_EMAIL = readString(dis);
					
			        this.SETPOINT_QUANTITY_ENABLE = dis.readInt();
					
			        this.MANUAL_MEASURED_DENSITY = dis.readDouble();
					
			        this.WEIGHT_IN_AIR = dis.readInt();
					
			        this.TOPS_MONITORING_ACTIVE = dis.readInt();
					
			        this.SHAPE = dis.readInt();
					
			        this.ACTUAL_FLOW_RATE_PERIOD = dis.readInt();
					
			        this.CALCULATED_FLOW_RATE_PERIOD = dis.readInt();
					
			        this.FLOW_RATE_CLAMPING_PERIOD = dis.readInt();
					
					this.RT_CLAMPING_PERIOD_START = readDate(dis);
					
			        this.VAPOR_CORRECTION_METHOD = dis.readInt();
					
			        this.VAPOR_TEMPERATURE = dis.readDouble();
					
			        this.VAPOR_LIQUID_VOLUME_RATIO = dis.readDouble();
					
			        this.TARGET_LEVEL = dis.readInt();
					
			        this.ORIGINAL_STARTING_LEVEL = dis.readInt();
					
			        this.TIME_TO_TARGET_LEVEL = dis.readInt();
					
			        this.AUTO_VAPOR_TEMPERATURE_ENABLE = dis.readInt();
					
					this.DDE_PRESSURE_DSN = readString(dis);
					
					this.DDE_PRESSURE_ITEM = readString(dis);
					
					this.DDE_VAPOR_TEMPERATURE_DSN = readString(dis);
					
					this.DDE_VAPOR_TEMPERATURE_ITEM = readString(dis);
					
			        this.RT_AUTO_VAPOR_TEMPERATURE = dis.readDouble();
					
			        this.RT_VAPOR_TEMPERATURE = dis.readDouble();
					
			        this.INVENTORY_ENABLE = dis.readInt();
					
			        this.MANUAL_TO_AUTO_FOLIO_LIMIT = dis.readInt();
					
			        this.RT_MANUAL_TO_AUTO_FOLIO_COUNT = dis.readInt();
					
			        this.RT_LEVEL_ORIGIN = dis.readInt();
					
			        this.RT_TOV_ORIGIN = dis.readInt();
					
			        this.RT_TEMPERATURE_ORIGIN = dis.readInt();
					
			        this.RT_DENSITY_ORIGIN = dis.readInt();
					
			        this.RT_NSV_ORIGIN = dis.readInt();
					
			        this.RT_VAPOR_TEMPERATURE_ORIGIN = dis.readInt();
					
			        this.RT_PRESSURE_ORIGIN = dis.readInt();
					
			        this.RT_FREE_WATER_LEVEL_ORIGIN = dis.readInt();
					
			        this.RT_WATER_QUANTITY_ORIGIN = dis.readInt();
					
					this.DDE_SNAPSHOT_REQ_DSN = readString(dis);
					
					this.DDE_SNAPSHOT_REQ_ITEM = readString(dis);
					
					this.DDE_SNAPSHOT_RSP_DSN = readString(dis);
					
					this.DDE_SNAPSHOT_RSP_ITEM = readString(dis);
					
			        this.AUTO_PRODUCT_LEVEL_UNIT = dis.readInt();
					
			        this.AUTO_FREE_WATER_LEVEL_UNIT = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_TANK) {

        	try {

        		int length = 0;
		
					this.TANK_CODE = readString(dis);
					
					this.NAME = readString(dis);
					
						this.COMPARTMENT_OWNER_ID = readInteger(dis);
					
						this.MAJORITY_SHAREHOLDER = readInteger(dis);
					
					this.COMPARTMENT_CONTAINER_CODE = readString(dis);
					
			        this.RT_GROSS_QUANTITY = dis.readInt();
					
						this.COMPARTMENT_CONTAINER_TYPE = readInteger(dis);
					
			        this.TERMINAL_PRODUCT_NUMBER = dis.readInt();
					
						this.COMPARTMENT_NUMBER = readInteger(dis);
					
			        this.RT_NET_QUANTITY = dis.readInt();
					
			        this.ENABLE = dis.readInt();
					
						this.SCHED_PROD_CHANGE_PRODUCT = readInteger(dis);
					
			        this.RVP = dis.readDouble();
					
			        this.OXYGEN = dis.readDouble();
					
			        this.RT_TEMPERATURE = dis.readDouble();
					
			        this.RT_DENSITY = dis.readDouble();
					
			        this.SHELL_CAPACITY = dis.readInt();
					
			        this.WORK_CAPACITY = dis.readInt();
					
					this.DEPTH = readString(dis);
					
					this.LOW_LOW_SETPOINT = readString(dis);
					
					this.LOW_SETPOINT = readString(dis);
					
					this.GENERAL_SETPOINT = readString(dis);
					
					this.CUTOFF_SETPOINT = readString(dis);
					
			        this.AUTO_ENABLE = dis.readInt();
					
					this.HIGH_SETPOINT = readString(dis);
					
					this.HIGH_HIGH_SETPOINT = readString(dis);
					
			        this.DEADBAND = dis.readInt();
					
			        this.AUTO_LEVEL_ENABLE = dis.readInt();
					
					this.DDE_LEVEL_DSN = readString(dis);
					
			        this.AUTO_DENSITY_ENABLE = dis.readInt();
					
			        this.AUTO_TEMPERATURE_ENABLE = dis.readInt();
					
					this.DDE_LEVEL_ITEM = readString(dis);
					
			        this.AUTO_QUANTITY_ENABLE = dis.readInt();
					
					this.DDE_DENSITY_DSN = readString(dis);
					
			        this.ACTIVITY_STATUS = dis.readInt();
					
					this.DDE_DENSITY_ITEM = readString(dis);
					
					this.DDE_TEMPERATURE_DSN = readString(dis);
					
			        this.RECEIPT_INDICATOR = dis.readInt();
					
					this.DDE_TEMPERATURE_ITEM = readString(dis);
					
					this.LAST_RECEIPT_DATE = readDate(dis);
					
					this.DDE_QUANTITY_DSN = readString(dis);
					
					this.DDE_QUANTITY_ITEM = readString(dis);
					
			        this.SEND_TO_HOST_AT_EOD = dis.readInt();
					
					this.MANUAL_LEVEL = readString(dis);
					
					this.RT_AUTO_LEVEL = readString(dis);
					
					this.EOM_MANUAL_LEVEL = readString(dis);
					
			        this.RT_EOM_GROSS_QUANTITY = dis.readInt();
					
			        this.RT_AUTO_DENSITY = dis.readDouble();
					
			        this.EOM_MANUAL_TEMPERATURE = dis.readDouble();
					
			        this.EOM_MANUAL_DENSITY = dis.readDouble();
					
			        this.EOM_MANUAL_BSW_QUANTITY = dis.readInt();
					
					this.EOM_MANUAL_BSW_LEVEL = readString(dis);
					
			        this.MANUAL_TEMPERATURE = dis.readDouble();
					
			        this.RT_EOM_NET_QUANTITY = dis.readInt();
					
			        this.EOM_MANUAL_COE = dis.readDouble();
					
			        this.RT_EOM_BSW_QUANTITY = dis.readInt();
					
					this.MANUAL_DATE = readDate(dis);
					
					this.BASE_SEDIMENT_WATER_LEVEL = readString(dis);
					
			        this.MANUAL_DENSITY = dis.readDouble();
					
			        this.RT_BSW_QUANTITY = dis.readInt();
					
			        this.MANUAL_SPECIFIC_GRAVITY = dis.readDouble();
					
			        this.PIPE_FILL = dis.readInt();
					
			        this.MANUAL_COEFFICIENT_EXPANSION = dis.readDouble();
					
			        this.PROTOCOL_TYPE = dis.readInt();
					
			        this.RT_AUTO_TEMPERATURE = dis.readDouble();
					
					this.PORT_NAME = readString(dis);
					
			        this.RT_AUTO_QUANTITY = dis.readInt();
					
			        this.ADDRESS = dis.readInt();
					
					this.REMARKS = readString(dis);
					
			        this.FAST_SCAN = dis.readInt();
					
					this.RT_LEVEL = readString(dis);
					
			        this.RT_METER_COUNT = dis.readInt();
					
			        this.RT_GROSS_SNAPSHOT = dis.readInt();
					
			        this.RT_SNAPSHOT_ACTIVE = dis.readInt();
					
					this.RT_LEVEL_SNAPSHOT = readString(dis);
					
			        this.RT_NET_SNAPSHOT = dis.readInt();
					
					this.RT_SNAPSHOT_DATE = readDate(dis);
					
			        this.RT_GROSS_SNAPSHOT_DELTA = dis.readInt();
					
			        this.RT_NET_SNAPSHOT_DELTA = dis.readInt();
					
			        this.RT_EOD_MANUAL_DELTA = dis.readInt();
					
					this.RT_END_LEVEL_SNAPSHOT = readString(dis);
					
			        this.RT_EOD_OPENING_PHYSICAL = dis.readInt();
					
			        this.RT_EOD_BULK_RECEIPTS = dis.readInt();
					
			        this.RT_END_GROSS_SNAPSHOT = dis.readInt();
					
			        this.RT_AVAILABLE_QUANTITY = dis.readInt();
					
			        this.RT_END_NET_SNAPSHOT = dis.readInt();
					
			        this.RT_EOD_BULK_DISPOSALS = dis.readInt();
					
					this.RT_END_SNAPSHOT_DATE = readDate(dis);
					
			        this.RT_EOD_TRANSFERS_IN = dis.readInt();
					
			        this.RT_EOD_RACK_RECEIPTS = dis.readInt();
					
			        this.RT_EOD_TRANSFERS_OUT = dis.readInt();
					
			        this.RT_EOD_RACK_DISPOSALS = dis.readInt();
					
					this.LAST_USER_NAME = readString(dis);
					
					this.LAST_MODIFIED = readDate(dis);
					
			        this.RT_EOD_BOOK_INVENTORY = dis.readInt();
					
					this.USER_DLL = readString(dis);
					
					this.USER_ROUTINE = readString(dis);
					
			        this.ROOF_CORRECTION_TYPE = dis.readInt();
					
					this.ROOF_TAKE_OFF_LEVEL = readString(dis);
					
					this.ROOF_SUPPORT_LEVEL = readString(dis);
					
			        this.ROOF_REFERENCE_DENSITY = dis.readDouble();
					
			        this.ROOF_ABOVE_ADJUSTMENT = dis.readDouble();
					
			        this.RT_EOD_MANUAL_CLOSING_ENABLE = dis.readInt();
					
			        this.ROOF_BELOW_ADJUSTMENT = dis.readDouble();
					
					this.RT_EOD_MANUAL_LEVEL = readString(dis);
					
			        this.STRAPPING_INVERTED = dis.readInt();
					
			        this.RT_EOD_MANUAL_GROSS_QUANTITY = dis.readInt();
					
			        this.RT_EOD_MANUAL_NET_QUANTITY = dis.readInt();
					
			        this.RT_EOD_RACK_FRAC_DISPOSALS = dis.readInt();
					
			        this.RT_EOD_RACK_FRAC_RECEIPTS = dis.readInt();
					
					this.DDE_HIGH_ALARM_DSN = readString(dis);
					
					this.DDE_HIGH_ALARM_ITEM = readString(dis);
					
					this.DDE_HIGH_HIGH_ALARM_DSN = readString(dis);
					
					this.DDE_HIGH_HIGH_ALARM_ITEM = readString(dis);
					
					this.DDE_LOW_ALARM_DSN = readString(dis);
					
					this.DDE_LOW_ALARM_ITEM = readString(dis);
					
					this.DDE_LOW_LOW_ALARM_DSN = readString(dis);
					
					this.DDE_LOW_LOW_ALARM_ITEM = readString(dis);
					
					this.DDE_CUTOFF_ALARM_DSN = readString(dis);
					
					this.DDE_CUTOFF_ALARM_ITEM = readString(dis);
					
					this.DDE_STATUS_DSN = readString(dis);
					
					this.DDE_STATUS_ITEM = readString(dis);
					
			        this.RT_AUTO_PRESSURE = dis.readDouble();
					
			        this.RT_AUTO_MASS = dis.readInt();
					
			        this.MANUAL_PRESSURE = dis.readDouble();
					
			        this.MANUAL_MASS = dis.readInt();
					
			        this.RT_PRESSURE = dis.readDouble();
					
			        this.RT_MASS = dis.readInt();
					
			        this.AUTO_PRESSURE_ENABLE = dis.readInt();
					
			        this.AUTO_MASS_ENABLE = dis.readInt();
					
			        this.DOWNLOAD_ENABLE = dis.readInt();
					
			        this.DOWNLOAD_LEVEL_ENABLE = dis.readInt();
					
			        this.DOWNLOAD_QUANTITY_ENABLE = dis.readInt();
					
			        this.DOWNLOAD_TEMPERATURE_ENABLE = dis.readInt();
					
			        this.DOWNLOAD_PRESSURE_ENABLE = dis.readInt();
					
			        this.DOWNLOAD_MASS_ENABLE = dis.readInt();
					
			        this.RT_USER_QUEUE_ENABLE = dis.readInt();
					
			        this.RT_USER_CONTEXT_VALUE = dis.readInt();
					
			        this.RT_FRAC_GROSS_SNAPSHOT_DELTA = dis.readInt();
					
			        this.RT_FRAC_NET_SNAPSHOT_DELTA = dis.readInt();
					
			        this.RT_FRAC_EOD_MANUAL_DELTA = dis.readInt();
					
			        this.RT_TEMPERATURE_SNAPSHOT = dis.readDouble();
					
			        this.RT_DENSITY_SNAPSHOT = dis.readDouble();
					
			        this.RT_END_TEMPERATURE_SNAPSHOT = dis.readDouble();
					
			        this.RT_END_DENSITY_SNAPSHOT = dis.readDouble();
					
			        this.RT_FRAC_EOD_TRANSFERS_IN = dis.readInt();
					
			        this.RT_FRAC_EOD_TRANSFERS_OUT = dis.readInt();
					
			        this.MANUAL_QUANTITY_ENABLE = dis.readInt();
					
			        this.MANUAL_BSW_QUANTITY = dis.readInt();
					
			        this.EOM_MANUAL_QUANTITY = dis.readInt();
					
			        this.MANUAL_GROSS_QUANTITY = dis.readInt();
					
			        this.MANUAL_LOW_LOW_QUANTITY = dis.readInt();
					
			        this.MANUAL_LOW_QUANTITY = dis.readInt();
					
			        this.MANUAL_GENERAL_QUANTITY = dis.readInt();
					
			        this.MANUAL_CUTOFF_QUANTITY = dis.readInt();
					
			        this.MANUAL_HIGH_QUANTITY = dis.readInt();
					
			        this.MANUAL_HIGH_HIGH_QUANTITY = dis.readInt();
					
			        this.MANUAL_OBSERVED_DENSITY = dis.readDouble();
					
			        this.RT_OBSERVED_DENSITY = dis.readDouble();
					
			        this.RT_OBS_DENSITY_SNAPSHOT = dis.readDouble();
					
			        this.RT_END_OBS_DENSITY_SNAPSHOT = dis.readDouble();
					
			        this.AUTO_BSW_LEVEL_ENABLE = dis.readInt();
					
			        this.AUTO_BSW_QUANTITY_ENABLE = dis.readInt();
					
					this.RT_AUTO_BSW_LEVEL = readString(dis);
					
			        this.RT_AUTO_BSW_QUANTITY = dis.readInt();
					
					this.RT_BSW_LEVEL = readString(dis);
					
					this.DDE_BSW_LEVEL_DSN = readString(dis);
					
					this.DDE_BSW_LEVEL_ITEM = readString(dis);
					
					this.DDE_BSW_QUANTITY_DSN = readString(dis);
					
					this.DDE_BSW_QUANTITY_ITEM = readString(dis);
					
			        this.DOWNLOAD_DENSITY_ENABLE = dis.readInt();
					
			        this.RT_EOD_ADD_MANUAL_DELTA = dis.readInt();
					
			        this.RT_EOD_ADD_BULK_RECEIPTS = dis.readInt();
					
			        this.RT_EOD_ADD_RACK_RECEIPTS = dis.readInt();
					
			        this.RT_EOD_ADD_TRANSFERS_IN = dis.readInt();
					
			        this.RT_EOD_ADD_BULK_DISPOSALS = dis.readInt();
					
			        this.RT_EOD_ADD_RACK_DISPOSALS = dis.readInt();
					
			        this.RT_EOD_ADD_TRANSFERS_OUT = dis.readInt();
					
			        this.RT_EOD_ADD_BOOK_INVENTORY = dis.readInt();
					
			        this.RT_IN_SERVICE = dis.readInt();
					
			        this.VIRTUAL_TANK = dis.readInt();
					
					this.DDE_IN_SERVICE_ITEM = readString(dis);
					
					this.TANK_GROUP = readString(dis);
					
					this.DDE_IN_SERVICE_DSN = readString(dis);
					
			        this.RT_CUTOFF_QUANTITY = dis.readInt();
					
			        this.AUTO_NET_QUANTITY_ENABLE = dis.readInt();
					
					this.DDE_NET_QUANTITY_ITEM = readString(dis);
					
			        this.RT_AUTO_NET_QUANTITY = dis.readInt();
					
					this.DDE_NET_QUANTITY_DSN = readString(dis);
					
			        this.MANUAL_NET_QUANTITY_ENABLE = dis.readInt();
					
			        this.MANUAL_NET_QUANTITY = dis.readInt();
					
					this.HIGH_BSW_SETPOINT = readString(dis);
					
			        this.HIGH_BSW_QUANTITY = dis.readInt();
					
					this.DDE_BSW_HIGH_ALARM_DSN = readString(dis);
					
					this.DDE_BSW_HIGH_ALARM_ITEM = readString(dis);
					
			        this.RT_EOD_BULK_FRAC_DISPOSALS = dis.readInt();
					
			        this.RT_EOD_BULK_FRAC_RECEIPTS = dis.readInt();
					
					this.RT_EOD_OPEN_BSW_LEVEL = readString(dis);
					
			        this.RT_EOD_OPEN_DENSITY = dis.readDouble();
					
			        this.RT_EOD_OPEN_TEMPERATURE = dis.readDouble();
					
			        this.RT_EOD_OPEN_BSW_QUANTITY = dis.readInt();
					
					this.RT_EOD_OPEN_LEVEL = readString(dis);
					
			        this.RT_EOD_OPEN_OBSERVED_DENSITY = dis.readDouble();
					
			        this.RT_EOD_OPEN_PHYS_GROSS_QTY = dis.readInt();
					
					this.PREV_EOD_LEVEL = readString(dis);
					
			        this.PREV_EOD_GROSS_QUANTITY = dis.readInt();
					
			        this.PREV_EOD_TEMPERATURE = dis.readDouble();
					
			        this.PREV_EOD_DENSITY = dis.readDouble();
					
			        this.PREV_EOD_BSW_QUANTITY = dis.readInt();
					
					this.PREV_EOD_BSW_LEVEL = readString(dis);
					
			        this.RT_PREV_EOD_NET_QUANTITY = dis.readInt();
					
			        this.PREV_EOD_COE = dis.readDouble();
					
			        this.RT_PREV_EOD_BSW_QUANTITY = dis.readInt();
					
			        this.PREV_EOD_QUANTITY = dis.readInt();
					
			        this.OPENING_COE = dis.readDouble();
					
			        this.RT_TOV = dis.readInt();
					
			        this.RT_GOV = dis.readInt();
					
			        this.RT_GSV = dis.readInt();
					
			        this.RT_TCV = dis.readInt();
					
			        this.RT_SHELL_CORRECTION_FACTOR = dis.readDouble();
					
			        this.RT_FLOATING_ROOF_ADJUSTMENT = dis.readInt();
					
			        this.RT_CTL = dis.readDouble();
					
			        this.SUSPENDED_BSW_PERCENT = dis.readDouble();
					
			        this.MANUAL_STRAP_TYPE = dis.readInt();
					
			        this.ROOF_TAKE_OFF_STRAP_TYPE = dis.readInt();
					
			        this.ROOF_SUPPORT_STRAP_TYPE = dis.readInt();
					
			        this.HIGH_BSW_STRAP_TYPE = dis.readInt();
					
			        this.BASE_SEDIMENT_WATER_STRAP_TYPE = dis.readInt();
					
					this.GAUGER_INITIALS = readString(dis);
					
					this.GAUGE_TIMESTAMP = readDate(dis);
					
			        this.LEVEL_UNITS = dis.readInt();
					
			        this.SHELL_BASE_TEMPERATURE = dis.readDouble();
					
			        this.SHELL_MATERIAL_TYPE = dis.readInt();
					
			        this.MANUAL_AMBIENT_TEMPERATURE = dis.readDouble();
					
			        this.INSULATED = dis.readInt();
					
			        this.LINE_SEGMENT_NSV = dis.readInt();
					
			        this.RT_CALCULATION_POINT = dis.readInt();
					
			        this.ROOF_TAKE_OFF_TOV = dis.readInt();
					
			        this.RT_NSV = dis.readInt();
					
			        this.RT_GSW = dis.readInt();
					
			        this.RT_NSW = dis.readInt();
					
			        this.RT_WCF = dis.readDouble();
					
			        this.LINE_SEGMENT_NSW = dis.readInt();
					
			        this.ROOF_WEIGHT = dis.readDouble();
					
			        this.VOL_IN_ALARM = dis.readInt();
					
			        this.INACTIVITY_QUANTITY = dis.readInt();
					
			        this.INACTIVITY_ALARM_STATE = dis.readInt();
					
			        this.USER_LEVEL = dis.readInt();
					
					this.SCHED_PROD_CHANGE_DATE_TIME = readDate(dis);
					
			        this.SCHED_PROD_CHANGE_TIMEOUT = dis.readInt();
					
					this.SCHED_PROD_CHANGE_EMAIL = readString(dis);
					
			        this.SETPOINT_QUANTITY_ENABLE = dis.readInt();
					
			        this.MANUAL_MEASURED_DENSITY = dis.readDouble();
					
			        this.WEIGHT_IN_AIR = dis.readInt();
					
			        this.TOPS_MONITORING_ACTIVE = dis.readInt();
					
			        this.SHAPE = dis.readInt();
					
			        this.ACTUAL_FLOW_RATE_PERIOD = dis.readInt();
					
			        this.CALCULATED_FLOW_RATE_PERIOD = dis.readInt();
					
			        this.FLOW_RATE_CLAMPING_PERIOD = dis.readInt();
					
					this.RT_CLAMPING_PERIOD_START = readDate(dis);
					
			        this.VAPOR_CORRECTION_METHOD = dis.readInt();
					
			        this.VAPOR_TEMPERATURE = dis.readDouble();
					
			        this.VAPOR_LIQUID_VOLUME_RATIO = dis.readDouble();
					
			        this.TARGET_LEVEL = dis.readInt();
					
			        this.ORIGINAL_STARTING_LEVEL = dis.readInt();
					
			        this.TIME_TO_TARGET_LEVEL = dis.readInt();
					
			        this.AUTO_VAPOR_TEMPERATURE_ENABLE = dis.readInt();
					
					this.DDE_PRESSURE_DSN = readString(dis);
					
					this.DDE_PRESSURE_ITEM = readString(dis);
					
					this.DDE_VAPOR_TEMPERATURE_DSN = readString(dis);
					
					this.DDE_VAPOR_TEMPERATURE_ITEM = readString(dis);
					
			        this.RT_AUTO_VAPOR_TEMPERATURE = dis.readDouble();
					
			        this.RT_VAPOR_TEMPERATURE = dis.readDouble();
					
			        this.INVENTORY_ENABLE = dis.readInt();
					
			        this.MANUAL_TO_AUTO_FOLIO_LIMIT = dis.readInt();
					
			        this.RT_MANUAL_TO_AUTO_FOLIO_COUNT = dis.readInt();
					
			        this.RT_LEVEL_ORIGIN = dis.readInt();
					
			        this.RT_TOV_ORIGIN = dis.readInt();
					
			        this.RT_TEMPERATURE_ORIGIN = dis.readInt();
					
			        this.RT_DENSITY_ORIGIN = dis.readInt();
					
			        this.RT_NSV_ORIGIN = dis.readInt();
					
			        this.RT_VAPOR_TEMPERATURE_ORIGIN = dis.readInt();
					
			        this.RT_PRESSURE_ORIGIN = dis.readInt();
					
			        this.RT_FREE_WATER_LEVEL_ORIGIN = dis.readInt();
					
			        this.RT_WATER_QUANTITY_ORIGIN = dis.readInt();
					
					this.DDE_SNAPSHOT_REQ_DSN = readString(dis);
					
					this.DDE_SNAPSHOT_REQ_ITEM = readString(dis);
					
					this.DDE_SNAPSHOT_RSP_DSN = readString(dis);
					
					this.DDE_SNAPSHOT_RSP_ITEM = readString(dis);
					
			        this.AUTO_PRODUCT_LEVEL_UNIT = dis.readInt();
					
			        this.AUTO_FREE_WATER_LEVEL_UNIT = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.TANK_CODE,dos);
					
					// String
				
						writeString(this.NAME,dos);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_OWNER_ID,dos);
					
					// Integer
				
						writeInteger(this.MAJORITY_SHAREHOLDER,dos);
					
					// String
				
						writeString(this.COMPARTMENT_CONTAINER_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.RT_GROSS_QUANTITY);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_CONTAINER_TYPE,dos);
					
					// int
				
		            	dos.writeInt(this.TERMINAL_PRODUCT_NUMBER);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.RT_NET_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.ENABLE);
					
					// Integer
				
						writeInteger(this.SCHED_PROD_CHANGE_PRODUCT,dos);
					
					// double
				
		            	dos.writeDouble(this.RVP);
					
					// double
				
		            	dos.writeDouble(this.OXYGEN);
					
					// double
				
		            	dos.writeDouble(this.RT_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.RT_DENSITY);
					
					// int
				
		            	dos.writeInt(this.SHELL_CAPACITY);
					
					// int
				
		            	dos.writeInt(this.WORK_CAPACITY);
					
					// String
				
						writeString(this.DEPTH,dos);
					
					// String
				
						writeString(this.LOW_LOW_SETPOINT,dos);
					
					// String
				
						writeString(this.LOW_SETPOINT,dos);
					
					// String
				
						writeString(this.GENERAL_SETPOINT,dos);
					
					// String
				
						writeString(this.CUTOFF_SETPOINT,dos);
					
					// int
				
		            	dos.writeInt(this.AUTO_ENABLE);
					
					// String
				
						writeString(this.HIGH_SETPOINT,dos);
					
					// String
				
						writeString(this.HIGH_HIGH_SETPOINT,dos);
					
					// int
				
		            	dos.writeInt(this.DEADBAND);
					
					// int
				
		            	dos.writeInt(this.AUTO_LEVEL_ENABLE);
					
					// String
				
						writeString(this.DDE_LEVEL_DSN,dos);
					
					// int
				
		            	dos.writeInt(this.AUTO_DENSITY_ENABLE);
					
					// int
				
		            	dos.writeInt(this.AUTO_TEMPERATURE_ENABLE);
					
					// String
				
						writeString(this.DDE_LEVEL_ITEM,dos);
					
					// int
				
		            	dos.writeInt(this.AUTO_QUANTITY_ENABLE);
					
					// String
				
						writeString(this.DDE_DENSITY_DSN,dos);
					
					// int
				
		            	dos.writeInt(this.ACTIVITY_STATUS);
					
					// String
				
						writeString(this.DDE_DENSITY_ITEM,dos);
					
					// String
				
						writeString(this.DDE_TEMPERATURE_DSN,dos);
					
					// int
				
		            	dos.writeInt(this.RECEIPT_INDICATOR);
					
					// String
				
						writeString(this.DDE_TEMPERATURE_ITEM,dos);
					
					// java.util.Date
				
						writeDate(this.LAST_RECEIPT_DATE,dos);
					
					// String
				
						writeString(this.DDE_QUANTITY_DSN,dos);
					
					// String
				
						writeString(this.DDE_QUANTITY_ITEM,dos);
					
					// int
				
		            	dos.writeInt(this.SEND_TO_HOST_AT_EOD);
					
					// String
				
						writeString(this.MANUAL_LEVEL,dos);
					
					// String
				
						writeString(this.RT_AUTO_LEVEL,dos);
					
					// String
				
						writeString(this.EOM_MANUAL_LEVEL,dos);
					
					// int
				
		            	dos.writeInt(this.RT_EOM_GROSS_QUANTITY);
					
					// double
				
		            	dos.writeDouble(this.RT_AUTO_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.EOM_MANUAL_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.EOM_MANUAL_DENSITY);
					
					// int
				
		            	dos.writeInt(this.EOM_MANUAL_BSW_QUANTITY);
					
					// String
				
						writeString(this.EOM_MANUAL_BSW_LEVEL,dos);
					
					// double
				
		            	dos.writeDouble(this.MANUAL_TEMPERATURE);
					
					// int
				
		            	dos.writeInt(this.RT_EOM_NET_QUANTITY);
					
					// double
				
		            	dos.writeDouble(this.EOM_MANUAL_COE);
					
					// int
				
		            	dos.writeInt(this.RT_EOM_BSW_QUANTITY);
					
					// java.util.Date
				
						writeDate(this.MANUAL_DATE,dos);
					
					// String
				
						writeString(this.BASE_SEDIMENT_WATER_LEVEL,dos);
					
					// double
				
		            	dos.writeDouble(this.MANUAL_DENSITY);
					
					// int
				
		            	dos.writeInt(this.RT_BSW_QUANTITY);
					
					// double
				
		            	dos.writeDouble(this.MANUAL_SPECIFIC_GRAVITY);
					
					// int
				
		            	dos.writeInt(this.PIPE_FILL);
					
					// double
				
		            	dos.writeDouble(this.MANUAL_COEFFICIENT_EXPANSION);
					
					// int
				
		            	dos.writeInt(this.PROTOCOL_TYPE);
					
					// double
				
		            	dos.writeDouble(this.RT_AUTO_TEMPERATURE);
					
					// String
				
						writeString(this.PORT_NAME,dos);
					
					// int
				
		            	dos.writeInt(this.RT_AUTO_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.ADDRESS);
					
					// String
				
						writeString(this.REMARKS,dos);
					
					// int
				
		            	dos.writeInt(this.FAST_SCAN);
					
					// String
				
						writeString(this.RT_LEVEL,dos);
					
					// int
				
		            	dos.writeInt(this.RT_METER_COUNT);
					
					// int
				
		            	dos.writeInt(this.RT_GROSS_SNAPSHOT);
					
					// int
				
		            	dos.writeInt(this.RT_SNAPSHOT_ACTIVE);
					
					// String
				
						writeString(this.RT_LEVEL_SNAPSHOT,dos);
					
					// int
				
		            	dos.writeInt(this.RT_NET_SNAPSHOT);
					
					// java.util.Date
				
						writeDate(this.RT_SNAPSHOT_DATE,dos);
					
					// int
				
		            	dos.writeInt(this.RT_GROSS_SNAPSHOT_DELTA);
					
					// int
				
		            	dos.writeInt(this.RT_NET_SNAPSHOT_DELTA);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_MANUAL_DELTA);
					
					// String
				
						writeString(this.RT_END_LEVEL_SNAPSHOT,dos);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_OPENING_PHYSICAL);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_BULK_RECEIPTS);
					
					// int
				
		            	dos.writeInt(this.RT_END_GROSS_SNAPSHOT);
					
					// int
				
		            	dos.writeInt(this.RT_AVAILABLE_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.RT_END_NET_SNAPSHOT);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_BULK_DISPOSALS);
					
					// java.util.Date
				
						writeDate(this.RT_END_SNAPSHOT_DATE,dos);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_TRANSFERS_IN);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_RACK_RECEIPTS);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_TRANSFERS_OUT);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_RACK_DISPOSALS);
					
					// String
				
						writeString(this.LAST_USER_NAME,dos);
					
					// java.util.Date
				
						writeDate(this.LAST_MODIFIED,dos);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_BOOK_INVENTORY);
					
					// String
				
						writeString(this.USER_DLL,dos);
					
					// String
				
						writeString(this.USER_ROUTINE,dos);
					
					// int
				
		            	dos.writeInt(this.ROOF_CORRECTION_TYPE);
					
					// String
				
						writeString(this.ROOF_TAKE_OFF_LEVEL,dos);
					
					// String
				
						writeString(this.ROOF_SUPPORT_LEVEL,dos);
					
					// double
				
		            	dos.writeDouble(this.ROOF_REFERENCE_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.ROOF_ABOVE_ADJUSTMENT);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_MANUAL_CLOSING_ENABLE);
					
					// double
				
		            	dos.writeDouble(this.ROOF_BELOW_ADJUSTMENT);
					
					// String
				
						writeString(this.RT_EOD_MANUAL_LEVEL,dos);
					
					// int
				
		            	dos.writeInt(this.STRAPPING_INVERTED);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_MANUAL_GROSS_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_MANUAL_NET_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_RACK_FRAC_DISPOSALS);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_RACK_FRAC_RECEIPTS);
					
					// String
				
						writeString(this.DDE_HIGH_ALARM_DSN,dos);
					
					// String
				
						writeString(this.DDE_HIGH_ALARM_ITEM,dos);
					
					// String
				
						writeString(this.DDE_HIGH_HIGH_ALARM_DSN,dos);
					
					// String
				
						writeString(this.DDE_HIGH_HIGH_ALARM_ITEM,dos);
					
					// String
				
						writeString(this.DDE_LOW_ALARM_DSN,dos);
					
					// String
				
						writeString(this.DDE_LOW_ALARM_ITEM,dos);
					
					// String
				
						writeString(this.DDE_LOW_LOW_ALARM_DSN,dos);
					
					// String
				
						writeString(this.DDE_LOW_LOW_ALARM_ITEM,dos);
					
					// String
				
						writeString(this.DDE_CUTOFF_ALARM_DSN,dos);
					
					// String
				
						writeString(this.DDE_CUTOFF_ALARM_ITEM,dos);
					
					// String
				
						writeString(this.DDE_STATUS_DSN,dos);
					
					// String
				
						writeString(this.DDE_STATUS_ITEM,dos);
					
					// double
				
		            	dos.writeDouble(this.RT_AUTO_PRESSURE);
					
					// int
				
		            	dos.writeInt(this.RT_AUTO_MASS);
					
					// double
				
		            	dos.writeDouble(this.MANUAL_PRESSURE);
					
					// int
				
		            	dos.writeInt(this.MANUAL_MASS);
					
					// double
				
		            	dos.writeDouble(this.RT_PRESSURE);
					
					// int
				
		            	dos.writeInt(this.RT_MASS);
					
					// int
				
		            	dos.writeInt(this.AUTO_PRESSURE_ENABLE);
					
					// int
				
		            	dos.writeInt(this.AUTO_MASS_ENABLE);
					
					// int
				
		            	dos.writeInt(this.DOWNLOAD_ENABLE);
					
					// int
				
		            	dos.writeInt(this.DOWNLOAD_LEVEL_ENABLE);
					
					// int
				
		            	dos.writeInt(this.DOWNLOAD_QUANTITY_ENABLE);
					
					// int
				
		            	dos.writeInt(this.DOWNLOAD_TEMPERATURE_ENABLE);
					
					// int
				
		            	dos.writeInt(this.DOWNLOAD_PRESSURE_ENABLE);
					
					// int
				
		            	dos.writeInt(this.DOWNLOAD_MASS_ENABLE);
					
					// int
				
		            	dos.writeInt(this.RT_USER_QUEUE_ENABLE);
					
					// int
				
		            	dos.writeInt(this.RT_USER_CONTEXT_VALUE);
					
					// int
				
		            	dos.writeInt(this.RT_FRAC_GROSS_SNAPSHOT_DELTA);
					
					// int
				
		            	dos.writeInt(this.RT_FRAC_NET_SNAPSHOT_DELTA);
					
					// int
				
		            	dos.writeInt(this.RT_FRAC_EOD_MANUAL_DELTA);
					
					// double
				
		            	dos.writeDouble(this.RT_TEMPERATURE_SNAPSHOT);
					
					// double
				
		            	dos.writeDouble(this.RT_DENSITY_SNAPSHOT);
					
					// double
				
		            	dos.writeDouble(this.RT_END_TEMPERATURE_SNAPSHOT);
					
					// double
				
		            	dos.writeDouble(this.RT_END_DENSITY_SNAPSHOT);
					
					// int
				
		            	dos.writeInt(this.RT_FRAC_EOD_TRANSFERS_IN);
					
					// int
				
		            	dos.writeInt(this.RT_FRAC_EOD_TRANSFERS_OUT);
					
					// int
				
		            	dos.writeInt(this.MANUAL_QUANTITY_ENABLE);
					
					// int
				
		            	dos.writeInt(this.MANUAL_BSW_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.EOM_MANUAL_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.MANUAL_GROSS_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.MANUAL_LOW_LOW_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.MANUAL_LOW_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.MANUAL_GENERAL_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.MANUAL_CUTOFF_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.MANUAL_HIGH_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.MANUAL_HIGH_HIGH_QUANTITY);
					
					// double
				
		            	dos.writeDouble(this.MANUAL_OBSERVED_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.RT_OBSERVED_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.RT_OBS_DENSITY_SNAPSHOT);
					
					// double
				
		            	dos.writeDouble(this.RT_END_OBS_DENSITY_SNAPSHOT);
					
					// int
				
		            	dos.writeInt(this.AUTO_BSW_LEVEL_ENABLE);
					
					// int
				
		            	dos.writeInt(this.AUTO_BSW_QUANTITY_ENABLE);
					
					// String
				
						writeString(this.RT_AUTO_BSW_LEVEL,dos);
					
					// int
				
		            	dos.writeInt(this.RT_AUTO_BSW_QUANTITY);
					
					// String
				
						writeString(this.RT_BSW_LEVEL,dos);
					
					// String
				
						writeString(this.DDE_BSW_LEVEL_DSN,dos);
					
					// String
				
						writeString(this.DDE_BSW_LEVEL_ITEM,dos);
					
					// String
				
						writeString(this.DDE_BSW_QUANTITY_DSN,dos);
					
					// String
				
						writeString(this.DDE_BSW_QUANTITY_ITEM,dos);
					
					// int
				
		            	dos.writeInt(this.DOWNLOAD_DENSITY_ENABLE);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_ADD_MANUAL_DELTA);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_ADD_BULK_RECEIPTS);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_ADD_RACK_RECEIPTS);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_ADD_TRANSFERS_IN);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_ADD_BULK_DISPOSALS);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_ADD_RACK_DISPOSALS);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_ADD_TRANSFERS_OUT);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_ADD_BOOK_INVENTORY);
					
					// int
				
		            	dos.writeInt(this.RT_IN_SERVICE);
					
					// int
				
		            	dos.writeInt(this.VIRTUAL_TANK);
					
					// String
				
						writeString(this.DDE_IN_SERVICE_ITEM,dos);
					
					// String
				
						writeString(this.TANK_GROUP,dos);
					
					// String
				
						writeString(this.DDE_IN_SERVICE_DSN,dos);
					
					// int
				
		            	dos.writeInt(this.RT_CUTOFF_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.AUTO_NET_QUANTITY_ENABLE);
					
					// String
				
						writeString(this.DDE_NET_QUANTITY_ITEM,dos);
					
					// int
				
		            	dos.writeInt(this.RT_AUTO_NET_QUANTITY);
					
					// String
				
						writeString(this.DDE_NET_QUANTITY_DSN,dos);
					
					// int
				
		            	dos.writeInt(this.MANUAL_NET_QUANTITY_ENABLE);
					
					// int
				
		            	dos.writeInt(this.MANUAL_NET_QUANTITY);
					
					// String
				
						writeString(this.HIGH_BSW_SETPOINT,dos);
					
					// int
				
		            	dos.writeInt(this.HIGH_BSW_QUANTITY);
					
					// String
				
						writeString(this.DDE_BSW_HIGH_ALARM_DSN,dos);
					
					// String
				
						writeString(this.DDE_BSW_HIGH_ALARM_ITEM,dos);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_BULK_FRAC_DISPOSALS);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_BULK_FRAC_RECEIPTS);
					
					// String
				
						writeString(this.RT_EOD_OPEN_BSW_LEVEL,dos);
					
					// double
				
		            	dos.writeDouble(this.RT_EOD_OPEN_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.RT_EOD_OPEN_TEMPERATURE);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_OPEN_BSW_QUANTITY);
					
					// String
				
						writeString(this.RT_EOD_OPEN_LEVEL,dos);
					
					// double
				
		            	dos.writeDouble(this.RT_EOD_OPEN_OBSERVED_DENSITY);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_OPEN_PHYS_GROSS_QTY);
					
					// String
				
						writeString(this.PREV_EOD_LEVEL,dos);
					
					// int
				
		            	dos.writeInt(this.PREV_EOD_GROSS_QUANTITY);
					
					// double
				
		            	dos.writeDouble(this.PREV_EOD_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.PREV_EOD_DENSITY);
					
					// int
				
		            	dos.writeInt(this.PREV_EOD_BSW_QUANTITY);
					
					// String
				
						writeString(this.PREV_EOD_BSW_LEVEL,dos);
					
					// int
				
		            	dos.writeInt(this.RT_PREV_EOD_NET_QUANTITY);
					
					// double
				
		            	dos.writeDouble(this.PREV_EOD_COE);
					
					// int
				
		            	dos.writeInt(this.RT_PREV_EOD_BSW_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.PREV_EOD_QUANTITY);
					
					// double
				
		            	dos.writeDouble(this.OPENING_COE);
					
					// int
				
		            	dos.writeInt(this.RT_TOV);
					
					// int
				
		            	dos.writeInt(this.RT_GOV);
					
					// int
				
		            	dos.writeInt(this.RT_GSV);
					
					// int
				
		            	dos.writeInt(this.RT_TCV);
					
					// double
				
		            	dos.writeDouble(this.RT_SHELL_CORRECTION_FACTOR);
					
					// int
				
		            	dos.writeInt(this.RT_FLOATING_ROOF_ADJUSTMENT);
					
					// double
				
		            	dos.writeDouble(this.RT_CTL);
					
					// double
				
		            	dos.writeDouble(this.SUSPENDED_BSW_PERCENT);
					
					// int
				
		            	dos.writeInt(this.MANUAL_STRAP_TYPE);
					
					// int
				
		            	dos.writeInt(this.ROOF_TAKE_OFF_STRAP_TYPE);
					
					// int
				
		            	dos.writeInt(this.ROOF_SUPPORT_STRAP_TYPE);
					
					// int
				
		            	dos.writeInt(this.HIGH_BSW_STRAP_TYPE);
					
					// int
				
		            	dos.writeInt(this.BASE_SEDIMENT_WATER_STRAP_TYPE);
					
					// String
				
						writeString(this.GAUGER_INITIALS,dos);
					
					// java.util.Date
				
						writeDate(this.GAUGE_TIMESTAMP,dos);
					
					// int
				
		            	dos.writeInt(this.LEVEL_UNITS);
					
					// double
				
		            	dos.writeDouble(this.SHELL_BASE_TEMPERATURE);
					
					// int
				
		            	dos.writeInt(this.SHELL_MATERIAL_TYPE);
					
					// double
				
		            	dos.writeDouble(this.MANUAL_AMBIENT_TEMPERATURE);
					
					// int
				
		            	dos.writeInt(this.INSULATED);
					
					// int
				
		            	dos.writeInt(this.LINE_SEGMENT_NSV);
					
					// int
				
		            	dos.writeInt(this.RT_CALCULATION_POINT);
					
					// int
				
		            	dos.writeInt(this.ROOF_TAKE_OFF_TOV);
					
					// int
				
		            	dos.writeInt(this.RT_NSV);
					
					// int
				
		            	dos.writeInt(this.RT_GSW);
					
					// int
				
		            	dos.writeInt(this.RT_NSW);
					
					// double
				
		            	dos.writeDouble(this.RT_WCF);
					
					// int
				
		            	dos.writeInt(this.LINE_SEGMENT_NSW);
					
					// double
				
		            	dos.writeDouble(this.ROOF_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.VOL_IN_ALARM);
					
					// int
				
		            	dos.writeInt(this.INACTIVITY_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.INACTIVITY_ALARM_STATE);
					
					// int
				
		            	dos.writeInt(this.USER_LEVEL);
					
					// java.util.Date
				
						writeDate(this.SCHED_PROD_CHANGE_DATE_TIME,dos);
					
					// int
				
		            	dos.writeInt(this.SCHED_PROD_CHANGE_TIMEOUT);
					
					// String
				
						writeString(this.SCHED_PROD_CHANGE_EMAIL,dos);
					
					// int
				
		            	dos.writeInt(this.SETPOINT_QUANTITY_ENABLE);
					
					// double
				
		            	dos.writeDouble(this.MANUAL_MEASURED_DENSITY);
					
					// int
				
		            	dos.writeInt(this.WEIGHT_IN_AIR);
					
					// int
				
		            	dos.writeInt(this.TOPS_MONITORING_ACTIVE);
					
					// int
				
		            	dos.writeInt(this.SHAPE);
					
					// int
				
		            	dos.writeInt(this.ACTUAL_FLOW_RATE_PERIOD);
					
					// int
				
		            	dos.writeInt(this.CALCULATED_FLOW_RATE_PERIOD);
					
					// int
				
		            	dos.writeInt(this.FLOW_RATE_CLAMPING_PERIOD);
					
					// java.util.Date
				
						writeDate(this.RT_CLAMPING_PERIOD_START,dos);
					
					// int
				
		            	dos.writeInt(this.VAPOR_CORRECTION_METHOD);
					
					// double
				
		            	dos.writeDouble(this.VAPOR_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.VAPOR_LIQUID_VOLUME_RATIO);
					
					// int
				
		            	dos.writeInt(this.TARGET_LEVEL);
					
					// int
				
		            	dos.writeInt(this.ORIGINAL_STARTING_LEVEL);
					
					// int
				
		            	dos.writeInt(this.TIME_TO_TARGET_LEVEL);
					
					// int
				
		            	dos.writeInt(this.AUTO_VAPOR_TEMPERATURE_ENABLE);
					
					// String
				
						writeString(this.DDE_PRESSURE_DSN,dos);
					
					// String
				
						writeString(this.DDE_PRESSURE_ITEM,dos);
					
					// String
				
						writeString(this.DDE_VAPOR_TEMPERATURE_DSN,dos);
					
					// String
				
						writeString(this.DDE_VAPOR_TEMPERATURE_ITEM,dos);
					
					// double
				
		            	dos.writeDouble(this.RT_AUTO_VAPOR_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.RT_VAPOR_TEMPERATURE);
					
					// int
				
		            	dos.writeInt(this.INVENTORY_ENABLE);
					
					// int
				
		            	dos.writeInt(this.MANUAL_TO_AUTO_FOLIO_LIMIT);
					
					// int
				
		            	dos.writeInt(this.RT_MANUAL_TO_AUTO_FOLIO_COUNT);
					
					// int
				
		            	dos.writeInt(this.RT_LEVEL_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.RT_TOV_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.RT_TEMPERATURE_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.RT_DENSITY_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.RT_NSV_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.RT_VAPOR_TEMPERATURE_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.RT_PRESSURE_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.RT_FREE_WATER_LEVEL_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.RT_WATER_QUANTITY_ORIGIN);
					
					// String
				
						writeString(this.DDE_SNAPSHOT_REQ_DSN,dos);
					
					// String
				
						writeString(this.DDE_SNAPSHOT_REQ_ITEM,dos);
					
					// String
				
						writeString(this.DDE_SNAPSHOT_RSP_DSN,dos);
					
					// String
				
						writeString(this.DDE_SNAPSHOT_RSP_ITEM,dos);
					
					// int
				
		            	dos.writeInt(this.AUTO_PRODUCT_LEVEL_UNIT);
					
					// int
				
		            	dos.writeInt(this.AUTO_FREE_WATER_LEVEL_UNIT);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.TANK_CODE,dos);
					
					// String
				
						writeString(this.NAME,dos);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_OWNER_ID,dos);
					
					// Integer
				
						writeInteger(this.MAJORITY_SHAREHOLDER,dos);
					
					// String
				
						writeString(this.COMPARTMENT_CONTAINER_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.RT_GROSS_QUANTITY);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_CONTAINER_TYPE,dos);
					
					// int
				
		            	dos.writeInt(this.TERMINAL_PRODUCT_NUMBER);
					
					// Integer
				
						writeInteger(this.COMPARTMENT_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.RT_NET_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.ENABLE);
					
					// Integer
				
						writeInteger(this.SCHED_PROD_CHANGE_PRODUCT,dos);
					
					// double
				
		            	dos.writeDouble(this.RVP);
					
					// double
				
		            	dos.writeDouble(this.OXYGEN);
					
					// double
				
		            	dos.writeDouble(this.RT_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.RT_DENSITY);
					
					// int
				
		            	dos.writeInt(this.SHELL_CAPACITY);
					
					// int
				
		            	dos.writeInt(this.WORK_CAPACITY);
					
					// String
				
						writeString(this.DEPTH,dos);
					
					// String
				
						writeString(this.LOW_LOW_SETPOINT,dos);
					
					// String
				
						writeString(this.LOW_SETPOINT,dos);
					
					// String
				
						writeString(this.GENERAL_SETPOINT,dos);
					
					// String
				
						writeString(this.CUTOFF_SETPOINT,dos);
					
					// int
				
		            	dos.writeInt(this.AUTO_ENABLE);
					
					// String
				
						writeString(this.HIGH_SETPOINT,dos);
					
					// String
				
						writeString(this.HIGH_HIGH_SETPOINT,dos);
					
					// int
				
		            	dos.writeInt(this.DEADBAND);
					
					// int
				
		            	dos.writeInt(this.AUTO_LEVEL_ENABLE);
					
					// String
				
						writeString(this.DDE_LEVEL_DSN,dos);
					
					// int
				
		            	dos.writeInt(this.AUTO_DENSITY_ENABLE);
					
					// int
				
		            	dos.writeInt(this.AUTO_TEMPERATURE_ENABLE);
					
					// String
				
						writeString(this.DDE_LEVEL_ITEM,dos);
					
					// int
				
		            	dos.writeInt(this.AUTO_QUANTITY_ENABLE);
					
					// String
				
						writeString(this.DDE_DENSITY_DSN,dos);
					
					// int
				
		            	dos.writeInt(this.ACTIVITY_STATUS);
					
					// String
				
						writeString(this.DDE_DENSITY_ITEM,dos);
					
					// String
				
						writeString(this.DDE_TEMPERATURE_DSN,dos);
					
					// int
				
		            	dos.writeInt(this.RECEIPT_INDICATOR);
					
					// String
				
						writeString(this.DDE_TEMPERATURE_ITEM,dos);
					
					// java.util.Date
				
						writeDate(this.LAST_RECEIPT_DATE,dos);
					
					// String
				
						writeString(this.DDE_QUANTITY_DSN,dos);
					
					// String
				
						writeString(this.DDE_QUANTITY_ITEM,dos);
					
					// int
				
		            	dos.writeInt(this.SEND_TO_HOST_AT_EOD);
					
					// String
				
						writeString(this.MANUAL_LEVEL,dos);
					
					// String
				
						writeString(this.RT_AUTO_LEVEL,dos);
					
					// String
				
						writeString(this.EOM_MANUAL_LEVEL,dos);
					
					// int
				
		            	dos.writeInt(this.RT_EOM_GROSS_QUANTITY);
					
					// double
				
		            	dos.writeDouble(this.RT_AUTO_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.EOM_MANUAL_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.EOM_MANUAL_DENSITY);
					
					// int
				
		            	dos.writeInt(this.EOM_MANUAL_BSW_QUANTITY);
					
					// String
				
						writeString(this.EOM_MANUAL_BSW_LEVEL,dos);
					
					// double
				
		            	dos.writeDouble(this.MANUAL_TEMPERATURE);
					
					// int
				
		            	dos.writeInt(this.RT_EOM_NET_QUANTITY);
					
					// double
				
		            	dos.writeDouble(this.EOM_MANUAL_COE);
					
					// int
				
		            	dos.writeInt(this.RT_EOM_BSW_QUANTITY);
					
					// java.util.Date
				
						writeDate(this.MANUAL_DATE,dos);
					
					// String
				
						writeString(this.BASE_SEDIMENT_WATER_LEVEL,dos);
					
					// double
				
		            	dos.writeDouble(this.MANUAL_DENSITY);
					
					// int
				
		            	dos.writeInt(this.RT_BSW_QUANTITY);
					
					// double
				
		            	dos.writeDouble(this.MANUAL_SPECIFIC_GRAVITY);
					
					// int
				
		            	dos.writeInt(this.PIPE_FILL);
					
					// double
				
		            	dos.writeDouble(this.MANUAL_COEFFICIENT_EXPANSION);
					
					// int
				
		            	dos.writeInt(this.PROTOCOL_TYPE);
					
					// double
				
		            	dos.writeDouble(this.RT_AUTO_TEMPERATURE);
					
					// String
				
						writeString(this.PORT_NAME,dos);
					
					// int
				
		            	dos.writeInt(this.RT_AUTO_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.ADDRESS);
					
					// String
				
						writeString(this.REMARKS,dos);
					
					// int
				
		            	dos.writeInt(this.FAST_SCAN);
					
					// String
				
						writeString(this.RT_LEVEL,dos);
					
					// int
				
		            	dos.writeInt(this.RT_METER_COUNT);
					
					// int
				
		            	dos.writeInt(this.RT_GROSS_SNAPSHOT);
					
					// int
				
		            	dos.writeInt(this.RT_SNAPSHOT_ACTIVE);
					
					// String
				
						writeString(this.RT_LEVEL_SNAPSHOT,dos);
					
					// int
				
		            	dos.writeInt(this.RT_NET_SNAPSHOT);
					
					// java.util.Date
				
						writeDate(this.RT_SNAPSHOT_DATE,dos);
					
					// int
				
		            	dos.writeInt(this.RT_GROSS_SNAPSHOT_DELTA);
					
					// int
				
		            	dos.writeInt(this.RT_NET_SNAPSHOT_DELTA);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_MANUAL_DELTA);
					
					// String
				
						writeString(this.RT_END_LEVEL_SNAPSHOT,dos);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_OPENING_PHYSICAL);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_BULK_RECEIPTS);
					
					// int
				
		            	dos.writeInt(this.RT_END_GROSS_SNAPSHOT);
					
					// int
				
		            	dos.writeInt(this.RT_AVAILABLE_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.RT_END_NET_SNAPSHOT);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_BULK_DISPOSALS);
					
					// java.util.Date
				
						writeDate(this.RT_END_SNAPSHOT_DATE,dos);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_TRANSFERS_IN);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_RACK_RECEIPTS);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_TRANSFERS_OUT);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_RACK_DISPOSALS);
					
					// String
				
						writeString(this.LAST_USER_NAME,dos);
					
					// java.util.Date
				
						writeDate(this.LAST_MODIFIED,dos);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_BOOK_INVENTORY);
					
					// String
				
						writeString(this.USER_DLL,dos);
					
					// String
				
						writeString(this.USER_ROUTINE,dos);
					
					// int
				
		            	dos.writeInt(this.ROOF_CORRECTION_TYPE);
					
					// String
				
						writeString(this.ROOF_TAKE_OFF_LEVEL,dos);
					
					// String
				
						writeString(this.ROOF_SUPPORT_LEVEL,dos);
					
					// double
				
		            	dos.writeDouble(this.ROOF_REFERENCE_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.ROOF_ABOVE_ADJUSTMENT);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_MANUAL_CLOSING_ENABLE);
					
					// double
				
		            	dos.writeDouble(this.ROOF_BELOW_ADJUSTMENT);
					
					// String
				
						writeString(this.RT_EOD_MANUAL_LEVEL,dos);
					
					// int
				
		            	dos.writeInt(this.STRAPPING_INVERTED);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_MANUAL_GROSS_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_MANUAL_NET_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_RACK_FRAC_DISPOSALS);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_RACK_FRAC_RECEIPTS);
					
					// String
				
						writeString(this.DDE_HIGH_ALARM_DSN,dos);
					
					// String
				
						writeString(this.DDE_HIGH_ALARM_ITEM,dos);
					
					// String
				
						writeString(this.DDE_HIGH_HIGH_ALARM_DSN,dos);
					
					// String
				
						writeString(this.DDE_HIGH_HIGH_ALARM_ITEM,dos);
					
					// String
				
						writeString(this.DDE_LOW_ALARM_DSN,dos);
					
					// String
				
						writeString(this.DDE_LOW_ALARM_ITEM,dos);
					
					// String
				
						writeString(this.DDE_LOW_LOW_ALARM_DSN,dos);
					
					// String
				
						writeString(this.DDE_LOW_LOW_ALARM_ITEM,dos);
					
					// String
				
						writeString(this.DDE_CUTOFF_ALARM_DSN,dos);
					
					// String
				
						writeString(this.DDE_CUTOFF_ALARM_ITEM,dos);
					
					// String
				
						writeString(this.DDE_STATUS_DSN,dos);
					
					// String
				
						writeString(this.DDE_STATUS_ITEM,dos);
					
					// double
				
		            	dos.writeDouble(this.RT_AUTO_PRESSURE);
					
					// int
				
		            	dos.writeInt(this.RT_AUTO_MASS);
					
					// double
				
		            	dos.writeDouble(this.MANUAL_PRESSURE);
					
					// int
				
		            	dos.writeInt(this.MANUAL_MASS);
					
					// double
				
		            	dos.writeDouble(this.RT_PRESSURE);
					
					// int
				
		            	dos.writeInt(this.RT_MASS);
					
					// int
				
		            	dos.writeInt(this.AUTO_PRESSURE_ENABLE);
					
					// int
				
		            	dos.writeInt(this.AUTO_MASS_ENABLE);
					
					// int
				
		            	dos.writeInt(this.DOWNLOAD_ENABLE);
					
					// int
				
		            	dos.writeInt(this.DOWNLOAD_LEVEL_ENABLE);
					
					// int
				
		            	dos.writeInt(this.DOWNLOAD_QUANTITY_ENABLE);
					
					// int
				
		            	dos.writeInt(this.DOWNLOAD_TEMPERATURE_ENABLE);
					
					// int
				
		            	dos.writeInt(this.DOWNLOAD_PRESSURE_ENABLE);
					
					// int
				
		            	dos.writeInt(this.DOWNLOAD_MASS_ENABLE);
					
					// int
				
		            	dos.writeInt(this.RT_USER_QUEUE_ENABLE);
					
					// int
				
		            	dos.writeInt(this.RT_USER_CONTEXT_VALUE);
					
					// int
				
		            	dos.writeInt(this.RT_FRAC_GROSS_SNAPSHOT_DELTA);
					
					// int
				
		            	dos.writeInt(this.RT_FRAC_NET_SNAPSHOT_DELTA);
					
					// int
				
		            	dos.writeInt(this.RT_FRAC_EOD_MANUAL_DELTA);
					
					// double
				
		            	dos.writeDouble(this.RT_TEMPERATURE_SNAPSHOT);
					
					// double
				
		            	dos.writeDouble(this.RT_DENSITY_SNAPSHOT);
					
					// double
				
		            	dos.writeDouble(this.RT_END_TEMPERATURE_SNAPSHOT);
					
					// double
				
		            	dos.writeDouble(this.RT_END_DENSITY_SNAPSHOT);
					
					// int
				
		            	dos.writeInt(this.RT_FRAC_EOD_TRANSFERS_IN);
					
					// int
				
		            	dos.writeInt(this.RT_FRAC_EOD_TRANSFERS_OUT);
					
					// int
				
		            	dos.writeInt(this.MANUAL_QUANTITY_ENABLE);
					
					// int
				
		            	dos.writeInt(this.MANUAL_BSW_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.EOM_MANUAL_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.MANUAL_GROSS_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.MANUAL_LOW_LOW_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.MANUAL_LOW_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.MANUAL_GENERAL_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.MANUAL_CUTOFF_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.MANUAL_HIGH_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.MANUAL_HIGH_HIGH_QUANTITY);
					
					// double
				
		            	dos.writeDouble(this.MANUAL_OBSERVED_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.RT_OBSERVED_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.RT_OBS_DENSITY_SNAPSHOT);
					
					// double
				
		            	dos.writeDouble(this.RT_END_OBS_DENSITY_SNAPSHOT);
					
					// int
				
		            	dos.writeInt(this.AUTO_BSW_LEVEL_ENABLE);
					
					// int
				
		            	dos.writeInt(this.AUTO_BSW_QUANTITY_ENABLE);
					
					// String
				
						writeString(this.RT_AUTO_BSW_LEVEL,dos);
					
					// int
				
		            	dos.writeInt(this.RT_AUTO_BSW_QUANTITY);
					
					// String
				
						writeString(this.RT_BSW_LEVEL,dos);
					
					// String
				
						writeString(this.DDE_BSW_LEVEL_DSN,dos);
					
					// String
				
						writeString(this.DDE_BSW_LEVEL_ITEM,dos);
					
					// String
				
						writeString(this.DDE_BSW_QUANTITY_DSN,dos);
					
					// String
				
						writeString(this.DDE_BSW_QUANTITY_ITEM,dos);
					
					// int
				
		            	dos.writeInt(this.DOWNLOAD_DENSITY_ENABLE);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_ADD_MANUAL_DELTA);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_ADD_BULK_RECEIPTS);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_ADD_RACK_RECEIPTS);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_ADD_TRANSFERS_IN);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_ADD_BULK_DISPOSALS);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_ADD_RACK_DISPOSALS);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_ADD_TRANSFERS_OUT);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_ADD_BOOK_INVENTORY);
					
					// int
				
		            	dos.writeInt(this.RT_IN_SERVICE);
					
					// int
				
		            	dos.writeInt(this.VIRTUAL_TANK);
					
					// String
				
						writeString(this.DDE_IN_SERVICE_ITEM,dos);
					
					// String
				
						writeString(this.TANK_GROUP,dos);
					
					// String
				
						writeString(this.DDE_IN_SERVICE_DSN,dos);
					
					// int
				
		            	dos.writeInt(this.RT_CUTOFF_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.AUTO_NET_QUANTITY_ENABLE);
					
					// String
				
						writeString(this.DDE_NET_QUANTITY_ITEM,dos);
					
					// int
				
		            	dos.writeInt(this.RT_AUTO_NET_QUANTITY);
					
					// String
				
						writeString(this.DDE_NET_QUANTITY_DSN,dos);
					
					// int
				
		            	dos.writeInt(this.MANUAL_NET_QUANTITY_ENABLE);
					
					// int
				
		            	dos.writeInt(this.MANUAL_NET_QUANTITY);
					
					// String
				
						writeString(this.HIGH_BSW_SETPOINT,dos);
					
					// int
				
		            	dos.writeInt(this.HIGH_BSW_QUANTITY);
					
					// String
				
						writeString(this.DDE_BSW_HIGH_ALARM_DSN,dos);
					
					// String
				
						writeString(this.DDE_BSW_HIGH_ALARM_ITEM,dos);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_BULK_FRAC_DISPOSALS);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_BULK_FRAC_RECEIPTS);
					
					// String
				
						writeString(this.RT_EOD_OPEN_BSW_LEVEL,dos);
					
					// double
				
		            	dos.writeDouble(this.RT_EOD_OPEN_DENSITY);
					
					// double
				
		            	dos.writeDouble(this.RT_EOD_OPEN_TEMPERATURE);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_OPEN_BSW_QUANTITY);
					
					// String
				
						writeString(this.RT_EOD_OPEN_LEVEL,dos);
					
					// double
				
		            	dos.writeDouble(this.RT_EOD_OPEN_OBSERVED_DENSITY);
					
					// int
				
		            	dos.writeInt(this.RT_EOD_OPEN_PHYS_GROSS_QTY);
					
					// String
				
						writeString(this.PREV_EOD_LEVEL,dos);
					
					// int
				
		            	dos.writeInt(this.PREV_EOD_GROSS_QUANTITY);
					
					// double
				
		            	dos.writeDouble(this.PREV_EOD_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.PREV_EOD_DENSITY);
					
					// int
				
		            	dos.writeInt(this.PREV_EOD_BSW_QUANTITY);
					
					// String
				
						writeString(this.PREV_EOD_BSW_LEVEL,dos);
					
					// int
				
		            	dos.writeInt(this.RT_PREV_EOD_NET_QUANTITY);
					
					// double
				
		            	dos.writeDouble(this.PREV_EOD_COE);
					
					// int
				
		            	dos.writeInt(this.RT_PREV_EOD_BSW_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.PREV_EOD_QUANTITY);
					
					// double
				
		            	dos.writeDouble(this.OPENING_COE);
					
					// int
				
		            	dos.writeInt(this.RT_TOV);
					
					// int
				
		            	dos.writeInt(this.RT_GOV);
					
					// int
				
		            	dos.writeInt(this.RT_GSV);
					
					// int
				
		            	dos.writeInt(this.RT_TCV);
					
					// double
				
		            	dos.writeDouble(this.RT_SHELL_CORRECTION_FACTOR);
					
					// int
				
		            	dos.writeInt(this.RT_FLOATING_ROOF_ADJUSTMENT);
					
					// double
				
		            	dos.writeDouble(this.RT_CTL);
					
					// double
				
		            	dos.writeDouble(this.SUSPENDED_BSW_PERCENT);
					
					// int
				
		            	dos.writeInt(this.MANUAL_STRAP_TYPE);
					
					// int
				
		            	dos.writeInt(this.ROOF_TAKE_OFF_STRAP_TYPE);
					
					// int
				
		            	dos.writeInt(this.ROOF_SUPPORT_STRAP_TYPE);
					
					// int
				
		            	dos.writeInt(this.HIGH_BSW_STRAP_TYPE);
					
					// int
				
		            	dos.writeInt(this.BASE_SEDIMENT_WATER_STRAP_TYPE);
					
					// String
				
						writeString(this.GAUGER_INITIALS,dos);
					
					// java.util.Date
				
						writeDate(this.GAUGE_TIMESTAMP,dos);
					
					// int
				
		            	dos.writeInt(this.LEVEL_UNITS);
					
					// double
				
		            	dos.writeDouble(this.SHELL_BASE_TEMPERATURE);
					
					// int
				
		            	dos.writeInt(this.SHELL_MATERIAL_TYPE);
					
					// double
				
		            	dos.writeDouble(this.MANUAL_AMBIENT_TEMPERATURE);
					
					// int
				
		            	dos.writeInt(this.INSULATED);
					
					// int
				
		            	dos.writeInt(this.LINE_SEGMENT_NSV);
					
					// int
				
		            	dos.writeInt(this.RT_CALCULATION_POINT);
					
					// int
				
		            	dos.writeInt(this.ROOF_TAKE_OFF_TOV);
					
					// int
				
		            	dos.writeInt(this.RT_NSV);
					
					// int
				
		            	dos.writeInt(this.RT_GSW);
					
					// int
				
		            	dos.writeInt(this.RT_NSW);
					
					// double
				
		            	dos.writeDouble(this.RT_WCF);
					
					// int
				
		            	dos.writeInt(this.LINE_SEGMENT_NSW);
					
					// double
				
		            	dos.writeDouble(this.ROOF_WEIGHT);
					
					// int
				
		            	dos.writeInt(this.VOL_IN_ALARM);
					
					// int
				
		            	dos.writeInt(this.INACTIVITY_QUANTITY);
					
					// int
				
		            	dos.writeInt(this.INACTIVITY_ALARM_STATE);
					
					// int
				
		            	dos.writeInt(this.USER_LEVEL);
					
					// java.util.Date
				
						writeDate(this.SCHED_PROD_CHANGE_DATE_TIME,dos);
					
					// int
				
		            	dos.writeInt(this.SCHED_PROD_CHANGE_TIMEOUT);
					
					// String
				
						writeString(this.SCHED_PROD_CHANGE_EMAIL,dos);
					
					// int
				
		            	dos.writeInt(this.SETPOINT_QUANTITY_ENABLE);
					
					// double
				
		            	dos.writeDouble(this.MANUAL_MEASURED_DENSITY);
					
					// int
				
		            	dos.writeInt(this.WEIGHT_IN_AIR);
					
					// int
				
		            	dos.writeInt(this.TOPS_MONITORING_ACTIVE);
					
					// int
				
		            	dos.writeInt(this.SHAPE);
					
					// int
				
		            	dos.writeInt(this.ACTUAL_FLOW_RATE_PERIOD);
					
					// int
				
		            	dos.writeInt(this.CALCULATED_FLOW_RATE_PERIOD);
					
					// int
				
		            	dos.writeInt(this.FLOW_RATE_CLAMPING_PERIOD);
					
					// java.util.Date
				
						writeDate(this.RT_CLAMPING_PERIOD_START,dos);
					
					// int
				
		            	dos.writeInt(this.VAPOR_CORRECTION_METHOD);
					
					// double
				
		            	dos.writeDouble(this.VAPOR_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.VAPOR_LIQUID_VOLUME_RATIO);
					
					// int
				
		            	dos.writeInt(this.TARGET_LEVEL);
					
					// int
				
		            	dos.writeInt(this.ORIGINAL_STARTING_LEVEL);
					
					// int
				
		            	dos.writeInt(this.TIME_TO_TARGET_LEVEL);
					
					// int
				
		            	dos.writeInt(this.AUTO_VAPOR_TEMPERATURE_ENABLE);
					
					// String
				
						writeString(this.DDE_PRESSURE_DSN,dos);
					
					// String
				
						writeString(this.DDE_PRESSURE_ITEM,dos);
					
					// String
				
						writeString(this.DDE_VAPOR_TEMPERATURE_DSN,dos);
					
					// String
				
						writeString(this.DDE_VAPOR_TEMPERATURE_ITEM,dos);
					
					// double
				
		            	dos.writeDouble(this.RT_AUTO_VAPOR_TEMPERATURE);
					
					// double
				
		            	dos.writeDouble(this.RT_VAPOR_TEMPERATURE);
					
					// int
				
		            	dos.writeInt(this.INVENTORY_ENABLE);
					
					// int
				
		            	dos.writeInt(this.MANUAL_TO_AUTO_FOLIO_LIMIT);
					
					// int
				
		            	dos.writeInt(this.RT_MANUAL_TO_AUTO_FOLIO_COUNT);
					
					// int
				
		            	dos.writeInt(this.RT_LEVEL_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.RT_TOV_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.RT_TEMPERATURE_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.RT_DENSITY_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.RT_NSV_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.RT_VAPOR_TEMPERATURE_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.RT_PRESSURE_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.RT_FREE_WATER_LEVEL_ORIGIN);
					
					// int
				
		            	dos.writeInt(this.RT_WATER_QUANTITY_ORIGIN);
					
					// String
				
						writeString(this.DDE_SNAPSHOT_REQ_DSN,dos);
					
					// String
				
						writeString(this.DDE_SNAPSHOT_REQ_ITEM,dos);
					
					// String
				
						writeString(this.DDE_SNAPSHOT_RSP_DSN,dos);
					
					// String
				
						writeString(this.DDE_SNAPSHOT_RSP_ITEM,dos);
					
					// int
				
		            	dos.writeInt(this.AUTO_PRODUCT_LEVEL_UNIT);
					
					// int
				
		            	dos.writeInt(this.AUTO_FREE_WATER_LEVEL_UNIT);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("TANK_CODE="+TANK_CODE);
		sb.append(",NAME="+NAME);
		sb.append(",COMPARTMENT_OWNER_ID="+String.valueOf(COMPARTMENT_OWNER_ID));
		sb.append(",MAJORITY_SHAREHOLDER="+String.valueOf(MAJORITY_SHAREHOLDER));
		sb.append(",COMPARTMENT_CONTAINER_CODE="+COMPARTMENT_CONTAINER_CODE);
		sb.append(",RT_GROSS_QUANTITY="+String.valueOf(RT_GROSS_QUANTITY));
		sb.append(",COMPARTMENT_CONTAINER_TYPE="+String.valueOf(COMPARTMENT_CONTAINER_TYPE));
		sb.append(",TERMINAL_PRODUCT_NUMBER="+String.valueOf(TERMINAL_PRODUCT_NUMBER));
		sb.append(",COMPARTMENT_NUMBER="+String.valueOf(COMPARTMENT_NUMBER));
		sb.append(",RT_NET_QUANTITY="+String.valueOf(RT_NET_QUANTITY));
		sb.append(",ENABLE="+String.valueOf(ENABLE));
		sb.append(",SCHED_PROD_CHANGE_PRODUCT="+String.valueOf(SCHED_PROD_CHANGE_PRODUCT));
		sb.append(",RVP="+String.valueOf(RVP));
		sb.append(",OXYGEN="+String.valueOf(OXYGEN));
		sb.append(",RT_TEMPERATURE="+String.valueOf(RT_TEMPERATURE));
		sb.append(",RT_DENSITY="+String.valueOf(RT_DENSITY));
		sb.append(",SHELL_CAPACITY="+String.valueOf(SHELL_CAPACITY));
		sb.append(",WORK_CAPACITY="+String.valueOf(WORK_CAPACITY));
		sb.append(",DEPTH="+DEPTH);
		sb.append(",LOW_LOW_SETPOINT="+LOW_LOW_SETPOINT);
		sb.append(",LOW_SETPOINT="+LOW_SETPOINT);
		sb.append(",GENERAL_SETPOINT="+GENERAL_SETPOINT);
		sb.append(",CUTOFF_SETPOINT="+CUTOFF_SETPOINT);
		sb.append(",AUTO_ENABLE="+String.valueOf(AUTO_ENABLE));
		sb.append(",HIGH_SETPOINT="+HIGH_SETPOINT);
		sb.append(",HIGH_HIGH_SETPOINT="+HIGH_HIGH_SETPOINT);
		sb.append(",DEADBAND="+String.valueOf(DEADBAND));
		sb.append(",AUTO_LEVEL_ENABLE="+String.valueOf(AUTO_LEVEL_ENABLE));
		sb.append(",DDE_LEVEL_DSN="+DDE_LEVEL_DSN);
		sb.append(",AUTO_DENSITY_ENABLE="+String.valueOf(AUTO_DENSITY_ENABLE));
		sb.append(",AUTO_TEMPERATURE_ENABLE="+String.valueOf(AUTO_TEMPERATURE_ENABLE));
		sb.append(",DDE_LEVEL_ITEM="+DDE_LEVEL_ITEM);
		sb.append(",AUTO_QUANTITY_ENABLE="+String.valueOf(AUTO_QUANTITY_ENABLE));
		sb.append(",DDE_DENSITY_DSN="+DDE_DENSITY_DSN);
		sb.append(",ACTIVITY_STATUS="+String.valueOf(ACTIVITY_STATUS));
		sb.append(",DDE_DENSITY_ITEM="+DDE_DENSITY_ITEM);
		sb.append(",DDE_TEMPERATURE_DSN="+DDE_TEMPERATURE_DSN);
		sb.append(",RECEIPT_INDICATOR="+String.valueOf(RECEIPT_INDICATOR));
		sb.append(",DDE_TEMPERATURE_ITEM="+DDE_TEMPERATURE_ITEM);
		sb.append(",LAST_RECEIPT_DATE="+String.valueOf(LAST_RECEIPT_DATE));
		sb.append(",DDE_QUANTITY_DSN="+DDE_QUANTITY_DSN);
		sb.append(",DDE_QUANTITY_ITEM="+DDE_QUANTITY_ITEM);
		sb.append(",SEND_TO_HOST_AT_EOD="+String.valueOf(SEND_TO_HOST_AT_EOD));
		sb.append(",MANUAL_LEVEL="+MANUAL_LEVEL);
		sb.append(",RT_AUTO_LEVEL="+RT_AUTO_LEVEL);
		sb.append(",EOM_MANUAL_LEVEL="+EOM_MANUAL_LEVEL);
		sb.append(",RT_EOM_GROSS_QUANTITY="+String.valueOf(RT_EOM_GROSS_QUANTITY));
		sb.append(",RT_AUTO_DENSITY="+String.valueOf(RT_AUTO_DENSITY));
		sb.append(",EOM_MANUAL_TEMPERATURE="+String.valueOf(EOM_MANUAL_TEMPERATURE));
		sb.append(",EOM_MANUAL_DENSITY="+String.valueOf(EOM_MANUAL_DENSITY));
		sb.append(",EOM_MANUAL_BSW_QUANTITY="+String.valueOf(EOM_MANUAL_BSW_QUANTITY));
		sb.append(",EOM_MANUAL_BSW_LEVEL="+EOM_MANUAL_BSW_LEVEL);
		sb.append(",MANUAL_TEMPERATURE="+String.valueOf(MANUAL_TEMPERATURE));
		sb.append(",RT_EOM_NET_QUANTITY="+String.valueOf(RT_EOM_NET_QUANTITY));
		sb.append(",EOM_MANUAL_COE="+String.valueOf(EOM_MANUAL_COE));
		sb.append(",RT_EOM_BSW_QUANTITY="+String.valueOf(RT_EOM_BSW_QUANTITY));
		sb.append(",MANUAL_DATE="+String.valueOf(MANUAL_DATE));
		sb.append(",BASE_SEDIMENT_WATER_LEVEL="+BASE_SEDIMENT_WATER_LEVEL);
		sb.append(",MANUAL_DENSITY="+String.valueOf(MANUAL_DENSITY));
		sb.append(",RT_BSW_QUANTITY="+String.valueOf(RT_BSW_QUANTITY));
		sb.append(",MANUAL_SPECIFIC_GRAVITY="+String.valueOf(MANUAL_SPECIFIC_GRAVITY));
		sb.append(",PIPE_FILL="+String.valueOf(PIPE_FILL));
		sb.append(",MANUAL_COEFFICIENT_EXPANSION="+String.valueOf(MANUAL_COEFFICIENT_EXPANSION));
		sb.append(",PROTOCOL_TYPE="+String.valueOf(PROTOCOL_TYPE));
		sb.append(",RT_AUTO_TEMPERATURE="+String.valueOf(RT_AUTO_TEMPERATURE));
		sb.append(",PORT_NAME="+PORT_NAME);
		sb.append(",RT_AUTO_QUANTITY="+String.valueOf(RT_AUTO_QUANTITY));
		sb.append(",ADDRESS="+String.valueOf(ADDRESS));
		sb.append(",REMARKS="+REMARKS);
		sb.append(",FAST_SCAN="+String.valueOf(FAST_SCAN));
		sb.append(",RT_LEVEL="+RT_LEVEL);
		sb.append(",RT_METER_COUNT="+String.valueOf(RT_METER_COUNT));
		sb.append(",RT_GROSS_SNAPSHOT="+String.valueOf(RT_GROSS_SNAPSHOT));
		sb.append(",RT_SNAPSHOT_ACTIVE="+String.valueOf(RT_SNAPSHOT_ACTIVE));
		sb.append(",RT_LEVEL_SNAPSHOT="+RT_LEVEL_SNAPSHOT);
		sb.append(",RT_NET_SNAPSHOT="+String.valueOf(RT_NET_SNAPSHOT));
		sb.append(",RT_SNAPSHOT_DATE="+String.valueOf(RT_SNAPSHOT_DATE));
		sb.append(",RT_GROSS_SNAPSHOT_DELTA="+String.valueOf(RT_GROSS_SNAPSHOT_DELTA));
		sb.append(",RT_NET_SNAPSHOT_DELTA="+String.valueOf(RT_NET_SNAPSHOT_DELTA));
		sb.append(",RT_EOD_MANUAL_DELTA="+String.valueOf(RT_EOD_MANUAL_DELTA));
		sb.append(",RT_END_LEVEL_SNAPSHOT="+RT_END_LEVEL_SNAPSHOT);
		sb.append(",RT_EOD_OPENING_PHYSICAL="+String.valueOf(RT_EOD_OPENING_PHYSICAL));
		sb.append(",RT_EOD_BULK_RECEIPTS="+String.valueOf(RT_EOD_BULK_RECEIPTS));
		sb.append(",RT_END_GROSS_SNAPSHOT="+String.valueOf(RT_END_GROSS_SNAPSHOT));
		sb.append(",RT_AVAILABLE_QUANTITY="+String.valueOf(RT_AVAILABLE_QUANTITY));
		sb.append(",RT_END_NET_SNAPSHOT="+String.valueOf(RT_END_NET_SNAPSHOT));
		sb.append(",RT_EOD_BULK_DISPOSALS="+String.valueOf(RT_EOD_BULK_DISPOSALS));
		sb.append(",RT_END_SNAPSHOT_DATE="+String.valueOf(RT_END_SNAPSHOT_DATE));
		sb.append(",RT_EOD_TRANSFERS_IN="+String.valueOf(RT_EOD_TRANSFERS_IN));
		sb.append(",RT_EOD_RACK_RECEIPTS="+String.valueOf(RT_EOD_RACK_RECEIPTS));
		sb.append(",RT_EOD_TRANSFERS_OUT="+String.valueOf(RT_EOD_TRANSFERS_OUT));
		sb.append(",RT_EOD_RACK_DISPOSALS="+String.valueOf(RT_EOD_RACK_DISPOSALS));
		sb.append(",LAST_USER_NAME="+LAST_USER_NAME);
		sb.append(",LAST_MODIFIED="+String.valueOf(LAST_MODIFIED));
		sb.append(",RT_EOD_BOOK_INVENTORY="+String.valueOf(RT_EOD_BOOK_INVENTORY));
		sb.append(",USER_DLL="+USER_DLL);
		sb.append(",USER_ROUTINE="+USER_ROUTINE);
		sb.append(",ROOF_CORRECTION_TYPE="+String.valueOf(ROOF_CORRECTION_TYPE));
		sb.append(",ROOF_TAKE_OFF_LEVEL="+ROOF_TAKE_OFF_LEVEL);
		sb.append(",ROOF_SUPPORT_LEVEL="+ROOF_SUPPORT_LEVEL);
		sb.append(",ROOF_REFERENCE_DENSITY="+String.valueOf(ROOF_REFERENCE_DENSITY));
		sb.append(",ROOF_ABOVE_ADJUSTMENT="+String.valueOf(ROOF_ABOVE_ADJUSTMENT));
		sb.append(",RT_EOD_MANUAL_CLOSING_ENABLE="+String.valueOf(RT_EOD_MANUAL_CLOSING_ENABLE));
		sb.append(",ROOF_BELOW_ADJUSTMENT="+String.valueOf(ROOF_BELOW_ADJUSTMENT));
		sb.append(",RT_EOD_MANUAL_LEVEL="+RT_EOD_MANUAL_LEVEL);
		sb.append(",STRAPPING_INVERTED="+String.valueOf(STRAPPING_INVERTED));
		sb.append(",RT_EOD_MANUAL_GROSS_QUANTITY="+String.valueOf(RT_EOD_MANUAL_GROSS_QUANTITY));
		sb.append(",RT_EOD_MANUAL_NET_QUANTITY="+String.valueOf(RT_EOD_MANUAL_NET_QUANTITY));
		sb.append(",RT_EOD_RACK_FRAC_DISPOSALS="+String.valueOf(RT_EOD_RACK_FRAC_DISPOSALS));
		sb.append(",RT_EOD_RACK_FRAC_RECEIPTS="+String.valueOf(RT_EOD_RACK_FRAC_RECEIPTS));
		sb.append(",DDE_HIGH_ALARM_DSN="+DDE_HIGH_ALARM_DSN);
		sb.append(",DDE_HIGH_ALARM_ITEM="+DDE_HIGH_ALARM_ITEM);
		sb.append(",DDE_HIGH_HIGH_ALARM_DSN="+DDE_HIGH_HIGH_ALARM_DSN);
		sb.append(",DDE_HIGH_HIGH_ALARM_ITEM="+DDE_HIGH_HIGH_ALARM_ITEM);
		sb.append(",DDE_LOW_ALARM_DSN="+DDE_LOW_ALARM_DSN);
		sb.append(",DDE_LOW_ALARM_ITEM="+DDE_LOW_ALARM_ITEM);
		sb.append(",DDE_LOW_LOW_ALARM_DSN="+DDE_LOW_LOW_ALARM_DSN);
		sb.append(",DDE_LOW_LOW_ALARM_ITEM="+DDE_LOW_LOW_ALARM_ITEM);
		sb.append(",DDE_CUTOFF_ALARM_DSN="+DDE_CUTOFF_ALARM_DSN);
		sb.append(",DDE_CUTOFF_ALARM_ITEM="+DDE_CUTOFF_ALARM_ITEM);
		sb.append(",DDE_STATUS_DSN="+DDE_STATUS_DSN);
		sb.append(",DDE_STATUS_ITEM="+DDE_STATUS_ITEM);
		sb.append(",RT_AUTO_PRESSURE="+String.valueOf(RT_AUTO_PRESSURE));
		sb.append(",RT_AUTO_MASS="+String.valueOf(RT_AUTO_MASS));
		sb.append(",MANUAL_PRESSURE="+String.valueOf(MANUAL_PRESSURE));
		sb.append(",MANUAL_MASS="+String.valueOf(MANUAL_MASS));
		sb.append(",RT_PRESSURE="+String.valueOf(RT_PRESSURE));
		sb.append(",RT_MASS="+String.valueOf(RT_MASS));
		sb.append(",AUTO_PRESSURE_ENABLE="+String.valueOf(AUTO_PRESSURE_ENABLE));
		sb.append(",AUTO_MASS_ENABLE="+String.valueOf(AUTO_MASS_ENABLE));
		sb.append(",DOWNLOAD_ENABLE="+String.valueOf(DOWNLOAD_ENABLE));
		sb.append(",DOWNLOAD_LEVEL_ENABLE="+String.valueOf(DOWNLOAD_LEVEL_ENABLE));
		sb.append(",DOWNLOAD_QUANTITY_ENABLE="+String.valueOf(DOWNLOAD_QUANTITY_ENABLE));
		sb.append(",DOWNLOAD_TEMPERATURE_ENABLE="+String.valueOf(DOWNLOAD_TEMPERATURE_ENABLE));
		sb.append(",DOWNLOAD_PRESSURE_ENABLE="+String.valueOf(DOWNLOAD_PRESSURE_ENABLE));
		sb.append(",DOWNLOAD_MASS_ENABLE="+String.valueOf(DOWNLOAD_MASS_ENABLE));
		sb.append(",RT_USER_QUEUE_ENABLE="+String.valueOf(RT_USER_QUEUE_ENABLE));
		sb.append(",RT_USER_CONTEXT_VALUE="+String.valueOf(RT_USER_CONTEXT_VALUE));
		sb.append(",RT_FRAC_GROSS_SNAPSHOT_DELTA="+String.valueOf(RT_FRAC_GROSS_SNAPSHOT_DELTA));
		sb.append(",RT_FRAC_NET_SNAPSHOT_DELTA="+String.valueOf(RT_FRAC_NET_SNAPSHOT_DELTA));
		sb.append(",RT_FRAC_EOD_MANUAL_DELTA="+String.valueOf(RT_FRAC_EOD_MANUAL_DELTA));
		sb.append(",RT_TEMPERATURE_SNAPSHOT="+String.valueOf(RT_TEMPERATURE_SNAPSHOT));
		sb.append(",RT_DENSITY_SNAPSHOT="+String.valueOf(RT_DENSITY_SNAPSHOT));
		sb.append(",RT_END_TEMPERATURE_SNAPSHOT="+String.valueOf(RT_END_TEMPERATURE_SNAPSHOT));
		sb.append(",RT_END_DENSITY_SNAPSHOT="+String.valueOf(RT_END_DENSITY_SNAPSHOT));
		sb.append(",RT_FRAC_EOD_TRANSFERS_IN="+String.valueOf(RT_FRAC_EOD_TRANSFERS_IN));
		sb.append(",RT_FRAC_EOD_TRANSFERS_OUT="+String.valueOf(RT_FRAC_EOD_TRANSFERS_OUT));
		sb.append(",MANUAL_QUANTITY_ENABLE="+String.valueOf(MANUAL_QUANTITY_ENABLE));
		sb.append(",MANUAL_BSW_QUANTITY="+String.valueOf(MANUAL_BSW_QUANTITY));
		sb.append(",EOM_MANUAL_QUANTITY="+String.valueOf(EOM_MANUAL_QUANTITY));
		sb.append(",MANUAL_GROSS_QUANTITY="+String.valueOf(MANUAL_GROSS_QUANTITY));
		sb.append(",MANUAL_LOW_LOW_QUANTITY="+String.valueOf(MANUAL_LOW_LOW_QUANTITY));
		sb.append(",MANUAL_LOW_QUANTITY="+String.valueOf(MANUAL_LOW_QUANTITY));
		sb.append(",MANUAL_GENERAL_QUANTITY="+String.valueOf(MANUAL_GENERAL_QUANTITY));
		sb.append(",MANUAL_CUTOFF_QUANTITY="+String.valueOf(MANUAL_CUTOFF_QUANTITY));
		sb.append(",MANUAL_HIGH_QUANTITY="+String.valueOf(MANUAL_HIGH_QUANTITY));
		sb.append(",MANUAL_HIGH_HIGH_QUANTITY="+String.valueOf(MANUAL_HIGH_HIGH_QUANTITY));
		sb.append(",MANUAL_OBSERVED_DENSITY="+String.valueOf(MANUAL_OBSERVED_DENSITY));
		sb.append(",RT_OBSERVED_DENSITY="+String.valueOf(RT_OBSERVED_DENSITY));
		sb.append(",RT_OBS_DENSITY_SNAPSHOT="+String.valueOf(RT_OBS_DENSITY_SNAPSHOT));
		sb.append(",RT_END_OBS_DENSITY_SNAPSHOT="+String.valueOf(RT_END_OBS_DENSITY_SNAPSHOT));
		sb.append(",AUTO_BSW_LEVEL_ENABLE="+String.valueOf(AUTO_BSW_LEVEL_ENABLE));
		sb.append(",AUTO_BSW_QUANTITY_ENABLE="+String.valueOf(AUTO_BSW_QUANTITY_ENABLE));
		sb.append(",RT_AUTO_BSW_LEVEL="+RT_AUTO_BSW_LEVEL);
		sb.append(",RT_AUTO_BSW_QUANTITY="+String.valueOf(RT_AUTO_BSW_QUANTITY));
		sb.append(",RT_BSW_LEVEL="+RT_BSW_LEVEL);
		sb.append(",DDE_BSW_LEVEL_DSN="+DDE_BSW_LEVEL_DSN);
		sb.append(",DDE_BSW_LEVEL_ITEM="+DDE_BSW_LEVEL_ITEM);
		sb.append(",DDE_BSW_QUANTITY_DSN="+DDE_BSW_QUANTITY_DSN);
		sb.append(",DDE_BSW_QUANTITY_ITEM="+DDE_BSW_QUANTITY_ITEM);
		sb.append(",DOWNLOAD_DENSITY_ENABLE="+String.valueOf(DOWNLOAD_DENSITY_ENABLE));
		sb.append(",RT_EOD_ADD_MANUAL_DELTA="+String.valueOf(RT_EOD_ADD_MANUAL_DELTA));
		sb.append(",RT_EOD_ADD_BULK_RECEIPTS="+String.valueOf(RT_EOD_ADD_BULK_RECEIPTS));
		sb.append(",RT_EOD_ADD_RACK_RECEIPTS="+String.valueOf(RT_EOD_ADD_RACK_RECEIPTS));
		sb.append(",RT_EOD_ADD_TRANSFERS_IN="+String.valueOf(RT_EOD_ADD_TRANSFERS_IN));
		sb.append(",RT_EOD_ADD_BULK_DISPOSALS="+String.valueOf(RT_EOD_ADD_BULK_DISPOSALS));
		sb.append(",RT_EOD_ADD_RACK_DISPOSALS="+String.valueOf(RT_EOD_ADD_RACK_DISPOSALS));
		sb.append(",RT_EOD_ADD_TRANSFERS_OUT="+String.valueOf(RT_EOD_ADD_TRANSFERS_OUT));
		sb.append(",RT_EOD_ADD_BOOK_INVENTORY="+String.valueOf(RT_EOD_ADD_BOOK_INVENTORY));
		sb.append(",RT_IN_SERVICE="+String.valueOf(RT_IN_SERVICE));
		sb.append(",VIRTUAL_TANK="+String.valueOf(VIRTUAL_TANK));
		sb.append(",DDE_IN_SERVICE_ITEM="+DDE_IN_SERVICE_ITEM);
		sb.append(",TANK_GROUP="+TANK_GROUP);
		sb.append(",DDE_IN_SERVICE_DSN="+DDE_IN_SERVICE_DSN);
		sb.append(",RT_CUTOFF_QUANTITY="+String.valueOf(RT_CUTOFF_QUANTITY));
		sb.append(",AUTO_NET_QUANTITY_ENABLE="+String.valueOf(AUTO_NET_QUANTITY_ENABLE));
		sb.append(",DDE_NET_QUANTITY_ITEM="+DDE_NET_QUANTITY_ITEM);
		sb.append(",RT_AUTO_NET_QUANTITY="+String.valueOf(RT_AUTO_NET_QUANTITY));
		sb.append(",DDE_NET_QUANTITY_DSN="+DDE_NET_QUANTITY_DSN);
		sb.append(",MANUAL_NET_QUANTITY_ENABLE="+String.valueOf(MANUAL_NET_QUANTITY_ENABLE));
		sb.append(",MANUAL_NET_QUANTITY="+String.valueOf(MANUAL_NET_QUANTITY));
		sb.append(",HIGH_BSW_SETPOINT="+HIGH_BSW_SETPOINT);
		sb.append(",HIGH_BSW_QUANTITY="+String.valueOf(HIGH_BSW_QUANTITY));
		sb.append(",DDE_BSW_HIGH_ALARM_DSN="+DDE_BSW_HIGH_ALARM_DSN);
		sb.append(",DDE_BSW_HIGH_ALARM_ITEM="+DDE_BSW_HIGH_ALARM_ITEM);
		sb.append(",RT_EOD_BULK_FRAC_DISPOSALS="+String.valueOf(RT_EOD_BULK_FRAC_DISPOSALS));
		sb.append(",RT_EOD_BULK_FRAC_RECEIPTS="+String.valueOf(RT_EOD_BULK_FRAC_RECEIPTS));
		sb.append(",RT_EOD_OPEN_BSW_LEVEL="+RT_EOD_OPEN_BSW_LEVEL);
		sb.append(",RT_EOD_OPEN_DENSITY="+String.valueOf(RT_EOD_OPEN_DENSITY));
		sb.append(",RT_EOD_OPEN_TEMPERATURE="+String.valueOf(RT_EOD_OPEN_TEMPERATURE));
		sb.append(",RT_EOD_OPEN_BSW_QUANTITY="+String.valueOf(RT_EOD_OPEN_BSW_QUANTITY));
		sb.append(",RT_EOD_OPEN_LEVEL="+RT_EOD_OPEN_LEVEL);
		sb.append(",RT_EOD_OPEN_OBSERVED_DENSITY="+String.valueOf(RT_EOD_OPEN_OBSERVED_DENSITY));
		sb.append(",RT_EOD_OPEN_PHYS_GROSS_QTY="+String.valueOf(RT_EOD_OPEN_PHYS_GROSS_QTY));
		sb.append(",PREV_EOD_LEVEL="+PREV_EOD_LEVEL);
		sb.append(",PREV_EOD_GROSS_QUANTITY="+String.valueOf(PREV_EOD_GROSS_QUANTITY));
		sb.append(",PREV_EOD_TEMPERATURE="+String.valueOf(PREV_EOD_TEMPERATURE));
		sb.append(",PREV_EOD_DENSITY="+String.valueOf(PREV_EOD_DENSITY));
		sb.append(",PREV_EOD_BSW_QUANTITY="+String.valueOf(PREV_EOD_BSW_QUANTITY));
		sb.append(",PREV_EOD_BSW_LEVEL="+PREV_EOD_BSW_LEVEL);
		sb.append(",RT_PREV_EOD_NET_QUANTITY="+String.valueOf(RT_PREV_EOD_NET_QUANTITY));
		sb.append(",PREV_EOD_COE="+String.valueOf(PREV_EOD_COE));
		sb.append(",RT_PREV_EOD_BSW_QUANTITY="+String.valueOf(RT_PREV_EOD_BSW_QUANTITY));
		sb.append(",PREV_EOD_QUANTITY="+String.valueOf(PREV_EOD_QUANTITY));
		sb.append(",OPENING_COE="+String.valueOf(OPENING_COE));
		sb.append(",RT_TOV="+String.valueOf(RT_TOV));
		sb.append(",RT_GOV="+String.valueOf(RT_GOV));
		sb.append(",RT_GSV="+String.valueOf(RT_GSV));
		sb.append(",RT_TCV="+String.valueOf(RT_TCV));
		sb.append(",RT_SHELL_CORRECTION_FACTOR="+String.valueOf(RT_SHELL_CORRECTION_FACTOR));
		sb.append(",RT_FLOATING_ROOF_ADJUSTMENT="+String.valueOf(RT_FLOATING_ROOF_ADJUSTMENT));
		sb.append(",RT_CTL="+String.valueOf(RT_CTL));
		sb.append(",SUSPENDED_BSW_PERCENT="+String.valueOf(SUSPENDED_BSW_PERCENT));
		sb.append(",MANUAL_STRAP_TYPE="+String.valueOf(MANUAL_STRAP_TYPE));
		sb.append(",ROOF_TAKE_OFF_STRAP_TYPE="+String.valueOf(ROOF_TAKE_OFF_STRAP_TYPE));
		sb.append(",ROOF_SUPPORT_STRAP_TYPE="+String.valueOf(ROOF_SUPPORT_STRAP_TYPE));
		sb.append(",HIGH_BSW_STRAP_TYPE="+String.valueOf(HIGH_BSW_STRAP_TYPE));
		sb.append(",BASE_SEDIMENT_WATER_STRAP_TYPE="+String.valueOf(BASE_SEDIMENT_WATER_STRAP_TYPE));
		sb.append(",GAUGER_INITIALS="+GAUGER_INITIALS);
		sb.append(",GAUGE_TIMESTAMP="+String.valueOf(GAUGE_TIMESTAMP));
		sb.append(",LEVEL_UNITS="+String.valueOf(LEVEL_UNITS));
		sb.append(",SHELL_BASE_TEMPERATURE="+String.valueOf(SHELL_BASE_TEMPERATURE));
		sb.append(",SHELL_MATERIAL_TYPE="+String.valueOf(SHELL_MATERIAL_TYPE));
		sb.append(",MANUAL_AMBIENT_TEMPERATURE="+String.valueOf(MANUAL_AMBIENT_TEMPERATURE));
		sb.append(",INSULATED="+String.valueOf(INSULATED));
		sb.append(",LINE_SEGMENT_NSV="+String.valueOf(LINE_SEGMENT_NSV));
		sb.append(",RT_CALCULATION_POINT="+String.valueOf(RT_CALCULATION_POINT));
		sb.append(",ROOF_TAKE_OFF_TOV="+String.valueOf(ROOF_TAKE_OFF_TOV));
		sb.append(",RT_NSV="+String.valueOf(RT_NSV));
		sb.append(",RT_GSW="+String.valueOf(RT_GSW));
		sb.append(",RT_NSW="+String.valueOf(RT_NSW));
		sb.append(",RT_WCF="+String.valueOf(RT_WCF));
		sb.append(",LINE_SEGMENT_NSW="+String.valueOf(LINE_SEGMENT_NSW));
		sb.append(",ROOF_WEIGHT="+String.valueOf(ROOF_WEIGHT));
		sb.append(",VOL_IN_ALARM="+String.valueOf(VOL_IN_ALARM));
		sb.append(",INACTIVITY_QUANTITY="+String.valueOf(INACTIVITY_QUANTITY));
		sb.append(",INACTIVITY_ALARM_STATE="+String.valueOf(INACTIVITY_ALARM_STATE));
		sb.append(",USER_LEVEL="+String.valueOf(USER_LEVEL));
		sb.append(",SCHED_PROD_CHANGE_DATE_TIME="+String.valueOf(SCHED_PROD_CHANGE_DATE_TIME));
		sb.append(",SCHED_PROD_CHANGE_TIMEOUT="+String.valueOf(SCHED_PROD_CHANGE_TIMEOUT));
		sb.append(",SCHED_PROD_CHANGE_EMAIL="+SCHED_PROD_CHANGE_EMAIL);
		sb.append(",SETPOINT_QUANTITY_ENABLE="+String.valueOf(SETPOINT_QUANTITY_ENABLE));
		sb.append(",MANUAL_MEASURED_DENSITY="+String.valueOf(MANUAL_MEASURED_DENSITY));
		sb.append(",WEIGHT_IN_AIR="+String.valueOf(WEIGHT_IN_AIR));
		sb.append(",TOPS_MONITORING_ACTIVE="+String.valueOf(TOPS_MONITORING_ACTIVE));
		sb.append(",SHAPE="+String.valueOf(SHAPE));
		sb.append(",ACTUAL_FLOW_RATE_PERIOD="+String.valueOf(ACTUAL_FLOW_RATE_PERIOD));
		sb.append(",CALCULATED_FLOW_RATE_PERIOD="+String.valueOf(CALCULATED_FLOW_RATE_PERIOD));
		sb.append(",FLOW_RATE_CLAMPING_PERIOD="+String.valueOf(FLOW_RATE_CLAMPING_PERIOD));
		sb.append(",RT_CLAMPING_PERIOD_START="+String.valueOf(RT_CLAMPING_PERIOD_START));
		sb.append(",VAPOR_CORRECTION_METHOD="+String.valueOf(VAPOR_CORRECTION_METHOD));
		sb.append(",VAPOR_TEMPERATURE="+String.valueOf(VAPOR_TEMPERATURE));
		sb.append(",VAPOR_LIQUID_VOLUME_RATIO="+String.valueOf(VAPOR_LIQUID_VOLUME_RATIO));
		sb.append(",TARGET_LEVEL="+String.valueOf(TARGET_LEVEL));
		sb.append(",ORIGINAL_STARTING_LEVEL="+String.valueOf(ORIGINAL_STARTING_LEVEL));
		sb.append(",TIME_TO_TARGET_LEVEL="+String.valueOf(TIME_TO_TARGET_LEVEL));
		sb.append(",AUTO_VAPOR_TEMPERATURE_ENABLE="+String.valueOf(AUTO_VAPOR_TEMPERATURE_ENABLE));
		sb.append(",DDE_PRESSURE_DSN="+DDE_PRESSURE_DSN);
		sb.append(",DDE_PRESSURE_ITEM="+DDE_PRESSURE_ITEM);
		sb.append(",DDE_VAPOR_TEMPERATURE_DSN="+DDE_VAPOR_TEMPERATURE_DSN);
		sb.append(",DDE_VAPOR_TEMPERATURE_ITEM="+DDE_VAPOR_TEMPERATURE_ITEM);
		sb.append(",RT_AUTO_VAPOR_TEMPERATURE="+String.valueOf(RT_AUTO_VAPOR_TEMPERATURE));
		sb.append(",RT_VAPOR_TEMPERATURE="+String.valueOf(RT_VAPOR_TEMPERATURE));
		sb.append(",INVENTORY_ENABLE="+String.valueOf(INVENTORY_ENABLE));
		sb.append(",MANUAL_TO_AUTO_FOLIO_LIMIT="+String.valueOf(MANUAL_TO_AUTO_FOLIO_LIMIT));
		sb.append(",RT_MANUAL_TO_AUTO_FOLIO_COUNT="+String.valueOf(RT_MANUAL_TO_AUTO_FOLIO_COUNT));
		sb.append(",RT_LEVEL_ORIGIN="+String.valueOf(RT_LEVEL_ORIGIN));
		sb.append(",RT_TOV_ORIGIN="+String.valueOf(RT_TOV_ORIGIN));
		sb.append(",RT_TEMPERATURE_ORIGIN="+String.valueOf(RT_TEMPERATURE_ORIGIN));
		sb.append(",RT_DENSITY_ORIGIN="+String.valueOf(RT_DENSITY_ORIGIN));
		sb.append(",RT_NSV_ORIGIN="+String.valueOf(RT_NSV_ORIGIN));
		sb.append(",RT_VAPOR_TEMPERATURE_ORIGIN="+String.valueOf(RT_VAPOR_TEMPERATURE_ORIGIN));
		sb.append(",RT_PRESSURE_ORIGIN="+String.valueOf(RT_PRESSURE_ORIGIN));
		sb.append(",RT_FREE_WATER_LEVEL_ORIGIN="+String.valueOf(RT_FREE_WATER_LEVEL_ORIGIN));
		sb.append(",RT_WATER_QUANTITY_ORIGIN="+String.valueOf(RT_WATER_QUANTITY_ORIGIN));
		sb.append(",DDE_SNAPSHOT_REQ_DSN="+DDE_SNAPSHOT_REQ_DSN);
		sb.append(",DDE_SNAPSHOT_REQ_ITEM="+DDE_SNAPSHOT_REQ_ITEM);
		sb.append(",DDE_SNAPSHOT_RSP_DSN="+DDE_SNAPSHOT_RSP_DSN);
		sb.append(",DDE_SNAPSHOT_RSP_ITEM="+DDE_SNAPSHOT_RSP_ITEM);
		sb.append(",AUTO_PRODUCT_LEVEL_UNIT="+String.valueOf(AUTO_PRODUCT_LEVEL_UNIT));
		sb.append(",AUTO_FREE_WATER_LEVEL_UNIT="+String.valueOf(AUTO_FREE_WATER_LEVEL_UNIT));
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
        } else if (updateKeyCount_tDBOutput_1 == 58 && true) {
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

 
	final String decryptedPassword_tDBOutput_1 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:1kokqmKxYIiEVqL7y9hJpaM1px4V5I5fhfWCbPtNju71Mq5i0Oo=");

    String dbPwd_tDBOutput_1 = decryptedPassword_tDBOutput_1;	
    conn_tDBOutput_1 = java.sql.DriverManager.getConnection(url_tDBOutput_1,dbUser_tDBOutput_1,dbPwd_tDBOutput_1);
	
		resourceMap.put("conn_tDBOutput_1", conn_tDBOutput_1);
	
        conn_tDBOutput_1.setAutoCommit(false);
        int commitEvery_tDBOutput_1 = 10000;
        int commitCounter_tDBOutput_1 = 0;


if(dbschema_tDBOutput_1 == null || dbschema_tDBOutput_1.trim().length() == 0) {
    tableName_tDBOutput_1 = "DIM_TANK";
} else {
    tableName_tDBOutput_1 = dbschema_tDBOutput_1 + "].[" + "DIM_TANK";
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
                                        stmtCreate_tDBOutput_1.execute("CREATE TABLE [" + tableName_tDBOutput_1 + "]([PK_TANK] INT ,[TANK_CODE] VARCHAR(20)  ,[NAME] VARCHAR(20)  ,[RT_GROSS_QUANTITY] INT  not null ,[TERMINAL_PRODUCT_NUMBER] INT  not null ,[RT_NET_QUANTITY] INT  not null ,[RT_TEMPERATURE] FLOAT(53)   not null ,[RT_DENSITY] FLOAT(53)   not null ,[SHELL_CAPACITY] INT  not null ,[WORK_CAPACITY] INT  not null ,[DEPTH] VARCHAR(7)   not null ,[AUTO_ENABLE] INT  not null ,[AUTO_LEVEL_ENABLE] INT  not null ,[AUTO_TEMPERATURE_ENABLE] INT  not null ,[DDE_LEVEL_ITEM] VARCHAR(128)  ,[MANUAL_LEVEL] VARCHAR(7)   not null ,[RT_AUTO_LEVEL] VARCHAR(7)   not null ,[MANUAL_TEMPERATURE] FLOAT(53)   not null ,[MANUAL_DENSITY] FLOAT(53)   not null ,[PROTOCOL_TYPE] INT  not null ,[RT_AUTO_TEMPERATURE] FLOAT(53)   not null ,[PORT_NAME] VARCHAR(40)  ,[RT_LEVEL] VARCHAR(7)   not null ,[RT_EOD_OPENING_PHYSICAL] INT  not null ,[RT_AVAILABLE_QUANTITY] INT  not null ,[LAST_USER_NAME] VARCHAR(10)  ,[LAST_MODIFIED] DATETIME ,[RT_EOD_BOOK_INVENTORY] INT  not null ,[USER_DLL] VARCHAR(60)  ,[USER_ROUTINE] VARCHAR(40)  ,[MANUAL_GROSS_QUANTITY] INT  not null ,[MANUAL_OBSERVED_DENSITY] FLOAT(53)   not null ,[RT_OBSERVED_DENSITY] FLOAT(53)   not null ,[AUTO_BSW_LEVEL_ENABLE] INT  not null ,[DDE_BSW_LEVEL_ITEM] VARCHAR(128)  ,[RT_EOD_OPEN_DENSITY] FLOAT(53)   not null ,[RT_EOD_OPEN_TEMPERATURE] FLOAT(53)   not null ,[RT_EOD_OPEN_LEVEL] VARCHAR(7)   not null ,[RT_EOD_OPEN_OBSERVED_DENSITY] FLOAT(53)   not null ,[RT_EOD_OPEN_PHYS_GROSS_QTY] INT  not null ,[RT_GOV] INT  not null ,[RT_GSV] INT  not null ,[RT_TCV] INT  not null ,[RT_CTL] FLOAT(53)   not null ,[MANUAL_STRAP_TYPE] INT  not null ,[RT_CALCULATION_POINT] INT  not null ,[RT_NSV] INT  not null ,[RT_GSW] INT  not null ,[RT_NSW] INT  not null ,[RT_WCF] FLOAT(53)   not null ,[WEIGHT_IN_AIR] INT  not null ,[SHAPE] INT  not null ,[RT_LEVEL_ORIGIN] INT  not null ,[RT_TOV_ORIGIN] INT  not null ,[RT_TEMPERATURE_ORIGIN] INT  not null ,[RT_FREE_WATER_LEVEL_ORIGIN] INT  not null ,[RT_WATER_QUANTITY_ORIGIN] INT  not null ,[RT_TOV] INT  not null ,primary key([PK_TANK]))");
                                    }
                                }
        java.sql.PreparedStatement pstmt_tDBOutput_1 = conn_tDBOutput_1.prepareStatement("SELECT COUNT(1) FROM [" + tableName_tDBOutput_1 + "] WHERE [PK_TANK] = ?");
        resourceMap.put("pstmt_tDBOutput_1", pstmt_tDBOutput_1);
        String insert_tDBOutput_1 = "INSERT INTO [" + tableName_tDBOutput_1 + "] ([PK_TANK],[TANK_CODE],[NAME],[RT_GROSS_QUANTITY],[TERMINAL_PRODUCT_NUMBER],[RT_NET_QUANTITY],[RT_TEMPERATURE],[RT_DENSITY],[SHELL_CAPACITY],[WORK_CAPACITY],[DEPTH],[AUTO_ENABLE],[AUTO_LEVEL_ENABLE],[AUTO_TEMPERATURE_ENABLE],[DDE_LEVEL_ITEM],[MANUAL_LEVEL],[RT_AUTO_LEVEL],[MANUAL_TEMPERATURE],[MANUAL_DENSITY],[PROTOCOL_TYPE],[RT_AUTO_TEMPERATURE],[PORT_NAME],[RT_LEVEL],[RT_EOD_OPENING_PHYSICAL],[RT_AVAILABLE_QUANTITY],[LAST_USER_NAME],[LAST_MODIFIED],[RT_EOD_BOOK_INVENTORY],[USER_DLL],[USER_ROUTINE],[MANUAL_GROSS_QUANTITY],[MANUAL_OBSERVED_DENSITY],[RT_OBSERVED_DENSITY],[AUTO_BSW_LEVEL_ENABLE],[DDE_BSW_LEVEL_ITEM],[RT_EOD_OPEN_DENSITY],[RT_EOD_OPEN_TEMPERATURE],[RT_EOD_OPEN_LEVEL],[RT_EOD_OPEN_OBSERVED_DENSITY],[RT_EOD_OPEN_PHYS_GROSS_QTY],[RT_GOV],[RT_GSV],[RT_TCV],[RT_CTL],[MANUAL_STRAP_TYPE],[RT_CALCULATION_POINT],[RT_NSV],[RT_GSW],[RT_NSW],[RT_WCF],[WEIGHT_IN_AIR],[SHAPE],[RT_LEVEL_ORIGIN],[RT_TOV_ORIGIN],[RT_TEMPERATURE_ORIGIN],[RT_FREE_WATER_LEVEL_ORIGIN],[RT_WATER_QUANTITY_ORIGIN],[RT_TOV]) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        java.sql.PreparedStatement pstmtInsert_tDBOutput_1 = conn_tDBOutput_1.prepareStatement(insert_tDBOutput_1);
        resourceMap.put("pstmtInsert_tDBOutput_1", pstmtInsert_tDBOutput_1);
        String update_tDBOutput_1 = "UPDATE [" + tableName_tDBOutput_1 + "] SET [TANK_CODE] = ?,[NAME] = ?,[RT_GROSS_QUANTITY] = ?,[TERMINAL_PRODUCT_NUMBER] = ?,[RT_NET_QUANTITY] = ?,[RT_TEMPERATURE] = ?,[RT_DENSITY] = ?,[SHELL_CAPACITY] = ?,[WORK_CAPACITY] = ?,[DEPTH] = ?,[AUTO_ENABLE] = ?,[AUTO_LEVEL_ENABLE] = ?,[AUTO_TEMPERATURE_ENABLE] = ?,[DDE_LEVEL_ITEM] = ?,[MANUAL_LEVEL] = ?,[RT_AUTO_LEVEL] = ?,[MANUAL_TEMPERATURE] = ?,[MANUAL_DENSITY] = ?,[PROTOCOL_TYPE] = ?,[RT_AUTO_TEMPERATURE] = ?,[PORT_NAME] = ?,[RT_LEVEL] = ?,[RT_EOD_OPENING_PHYSICAL] = ?,[RT_AVAILABLE_QUANTITY] = ?,[LAST_USER_NAME] = ?,[LAST_MODIFIED] = ?,[RT_EOD_BOOK_INVENTORY] = ?,[USER_DLL] = ?,[USER_ROUTINE] = ?,[MANUAL_GROSS_QUANTITY] = ?,[MANUAL_OBSERVED_DENSITY] = ?,[RT_OBSERVED_DENSITY] = ?,[AUTO_BSW_LEVEL_ENABLE] = ?,[DDE_BSW_LEVEL_ITEM] = ?,[RT_EOD_OPEN_DENSITY] = ?,[RT_EOD_OPEN_TEMPERATURE] = ?,[RT_EOD_OPEN_LEVEL] = ?,[RT_EOD_OPEN_OBSERVED_DENSITY] = ?,[RT_EOD_OPEN_PHYS_GROSS_QTY] = ?,[RT_GOV] = ?,[RT_GSV] = ?,[RT_TCV] = ?,[RT_CTL] = ?,[MANUAL_STRAP_TYPE] = ?,[RT_CALCULATION_POINT] = ?,[RT_NSV] = ?,[RT_GSW] = ?,[RT_NSW] = ?,[RT_WCF] = ?,[WEIGHT_IN_AIR] = ?,[SHAPE] = ?,[RT_LEVEL_ORIGIN] = ?,[RT_TOV_ORIGIN] = ?,[RT_TEMPERATURE_ORIGIN] = ?,[RT_FREE_WATER_LEVEL_ORIGIN] = ?,[RT_WATER_QUANTITY_ORIGIN] = ?,[RT_TOV] = ? WHERE [PK_TANK] = ?";
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
	int PK_TANK;
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
	
	        
					String TANK_CODE;
					String NAME;        
	        
		    @Override
			public int hashCode() {
				if (this.hashCodeDirty) {
					final int prime = PRIME;
					int result = DEFAULT_HASHCODE;
			
								result = prime * result + ((this.TANK_CODE == null) ? 0 : this.TANK_CODE.hashCode());
								
								result = prime * result + ((this.NAME == null) ? 0 : this.NAME.hashCode());
								
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
				
									if (this.TANK_CODE == null) {
										if (other.TANK_CODE != null) 
											return false;
								
									} else if (!this.TANK_CODE.equals(other.TANK_CODE))
								 
										return false;
								
									if (this.NAME == null) {
										if (other.NAME != null) 
											return false;
								
									} else if (!this.NAME.equals(other.NAME))
								 
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
				
				 
	final String decryptedPassword_tDBInput_1 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:Vh2soDD/54F2aFzBYxd7RsjNu4B9VqUUdJmRtsmbgXPH6+E0QXg=");
				
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

		    String dbquery_tDBInput_1 = "SELECT dbo.TANK.TANK_CODE,\n		dbo.TANK.NAME,\n		dbo.TANK.COMPARTMENT_OWNER_ID,\n		dbo.TANK.MAJORITY_SHAREHOLDER,\n		dbo.TAN"
+"K.COMPARTMENT_CONTAINER_CODE,\n		dbo.TANK.RT_GROSS_QUANTITY,\n		dbo.TANK.COMPARTMENT_CONTAINER_TYPE,\n		dbo.TANK.TERMINAL_P"
+"RODUCT_NUMBER,\n		dbo.TANK.COMPARTMENT_NUMBER,\n		dbo.TANK.RT_NET_QUANTITY,\n		dbo.TANK.ENABLE,\n		dbo.TANK.SCHED_PROD_CHANG"
+"E_PRODUCT,\n		dbo.TANK.RVP,\n		dbo.TANK.OXYGEN,\n		dbo.TANK.RT_TEMPERATURE,\n		dbo.TANK.RT_DENSITY,\n		dbo.TANK.SHELL_CAPACIT"
+"Y,\n		dbo.TANK.WORK_CAPACITY,\n		dbo.TANK.DEPTH,\n		dbo.TANK.LOW_LOW_SETPOINT,\n		dbo.TANK.LOW_SETPOINT,\n		dbo.TANK.GENERAL_"
+"SETPOINT,\n		dbo.TANK.CUTOFF_SETPOINT,\n		dbo.TANK.AUTO_ENABLE,\n		dbo.TANK.HIGH_SETPOINT,\n		dbo.TANK.HIGH_HIGH_SETPOINT,\n	"
+"	dbo.TANK.DEADBAND,\n		dbo.TANK.AUTO_LEVEL_ENABLE,\n		dbo.TANK.DDE_LEVEL_DSN,\n		dbo.TANK.AUTO_DENSITY_ENABLE,\n		dbo.TANK.A"
+"UTO_TEMPERATURE_ENABLE,\n		dbo.TANK.DDE_LEVEL_ITEM,\n		dbo.TANK.AUTO_QUANTITY_ENABLE,\n		dbo.TANK.DDE_DENSITY_DSN,\n		dbo.TA"
+"NK.ACTIVITY_STATUS,\n		dbo.TANK.DDE_DENSITY_ITEM,\n		dbo.TANK.DDE_TEMPERATURE_DSN,\n		dbo.TANK.RECEIPT_INDICATOR,\n		dbo.TAN"
+"K.DDE_TEMPERATURE_ITEM,\n		dbo.TANK.LAST_RECEIPT_DATE,\n		dbo.TANK.DDE_QUANTITY_DSN,\n		dbo.TANK.DDE_QUANTITY_ITEM,\n		dbo.T"
+"ANK.SEND_TO_HOST_AT_EOD,\n		dbo.TANK.MANUAL_LEVEL,\n		dbo.TANK.RT_AUTO_LEVEL,\n		dbo.TANK.EOM_MANUAL_LEVEL,\n		dbo.TANK.RT_E"
+"OM_GROSS_QUANTITY,\n		dbo.TANK.RT_AUTO_DENSITY,\n		dbo.TANK.EOM_MANUAL_TEMPERATURE,\n		dbo.TANK.EOM_MANUAL_DENSITY,\n		dbo.T"
+"ANK.EOM_MANUAL_BSW_QUANTITY,\n		dbo.TANK.EOM_MANUAL_BSW_LEVEL,\n		dbo.TANK.MANUAL_TEMPERATURE,\n		dbo.TANK.RT_EOM_NET_QUANT"
+"ITY,\n		dbo.TANK.EOM_MANUAL_COE,\n		dbo.TANK.RT_EOM_BSW_QUANTITY,\n		dbo.TANK.MANUAL_DATE,\n		dbo.TANK.BASE_SEDIMENT_WATER_L"
+"EVEL,\n		dbo.TANK.MANUAL_DENSITY,\n		dbo.TANK.RT_BSW_QUANTITY,\n		dbo.TANK.MANUAL_SPECIFIC_GRAVITY,\n		dbo.TANK.PIPE_FILL,\n	"
+"	dbo.TANK.MANUAL_COEFFICIENT_EXPANSION,\n		dbo.TANK.PROTOCOL_TYPE,\n		dbo.TANK.RT_AUTO_TEMPERATURE,\n		dbo.TANK.PORT_NAME,\n"
+"		dbo.TANK.RT_AUTO_QUANTITY,\n		dbo.TANK.ADDRESS,\n		dbo.TANK.REMARKS,\n		dbo.TANK.FAST_SCAN,\n		dbo.TANK.RT_LEVEL,\n		dbo.TA"
+"NK.RT_METER_COUNT,\n		dbo.TANK.RT_GROSS_SNAPSHOT,\n		dbo.TANK.RT_SNAPSHOT_ACTIVE,\n		dbo.TANK.RT_LEVEL_SNAPSHOT,\n		dbo.TANK"
+".RT_NET_SNAPSHOT,\n		dbo.TANK.RT_SNAPSHOT_DATE,\n		dbo.TANK.RT_GROSS_SNAPSHOT_DELTA,\n		dbo.TANK.RT_NET_SNAPSHOT_DELTA,\n		d"
+"bo.TANK.RT_EOD_MANUAL_DELTA,\n		dbo.TANK.RT_END_LEVEL_SNAPSHOT,\n		dbo.TANK.RT_EOD_OPENING_PHYSICAL,\n		dbo.TANK.RT_EOD_BUL"
+"K_RECEIPTS,\n		dbo.TANK.RT_END_GROSS_SNAPSHOT,\n		dbo.TANK.RT_AVAILABLE_QUANTITY,\n		dbo.TANK.RT_END_NET_SNAPSHOT,\n		dbo.TA"
+"NK.RT_EOD_BULK_DISPOSALS,\n		dbo.TANK.RT_END_SNAPSHOT_DATE,\n		dbo.TANK.RT_EOD_TRANSFERS_IN,\n		dbo.TANK.RT_EOD_RACK_RECEIP"
+"TS,\n		dbo.TANK.RT_EOD_TRANSFERS_OUT,\n		dbo.TANK.RT_EOD_RACK_DISPOSALS,\n		dbo.TANK.LAST_USER_NAME,\n		dbo.TANK.LAST_MODIFI"
+"ED,\n		dbo.TANK.RT_EOD_BOOK_INVENTORY,\n		dbo.TANK.USER_DLL,\n		dbo.TANK.USER_ROUTINE,\n		dbo.TANK.ROOF_CORRECTION_TYPE,\n		d"
+"bo.TANK.ROOF_TAKE_OFF_LEVEL,\n		dbo.TANK.ROOF_SUPPORT_LEVEL,\n		dbo.TANK.ROOF_REFERENCE_DENSITY,\n		dbo.TANK.ROOF_ABOVE_ADJ"
+"USTMENT,\n		dbo.TANK.RT_EOD_MANUAL_CLOSING_ENABLE,\n		dbo.TANK.ROOF_BELOW_ADJUSTMENT,\n		dbo.TANK.RT_EOD_MANUAL_LEVEL,\n		db"
+"o.TANK.STRAPPING_INVERTED,\n		dbo.TANK.RT_EOD_MANUAL_GROSS_QUANTITY,\n		dbo.TANK.RT_EOD_MANUAL_NET_QUANTITY,\n		dbo.TANK.RT"
+"_EOD_RACK_FRAC_DISPOSALS,\n		dbo.TANK.RT_EOD_RACK_FRAC_RECEIPTS,\n		dbo.TANK.DDE_HIGH_ALARM_DSN,\n		dbo.TANK.DDE_HIGH_ALARM"
+"_ITEM,\n		dbo.TANK.DDE_HIGH_HIGH_ALARM_DSN,\n		dbo.TANK.DDE_HIGH_HIGH_ALARM_ITEM,\n		dbo.TANK.DDE_LOW_ALARM_DSN,\n		dbo.TANK"
+".DDE_LOW_ALARM_ITEM,\n		dbo.TANK.DDE_LOW_LOW_ALARM_DSN,\n		dbo.TANK.DDE_LOW_LOW_ALARM_ITEM,\n		dbo.TANK.DDE_CUTOFF_ALARM_DS"
+"N,\n		dbo.TANK.DDE_CUTOFF_ALARM_ITEM,\n		dbo.TANK.DDE_STATUS_DSN,\n		dbo.TANK.DDE_STATUS_ITEM,\n		dbo.TANK.RT_AUTO_PRESSURE,"
+"\n		dbo.TANK.RT_AUTO_MASS,\n		dbo.TANK.MANUAL_PRESSURE,\n		dbo.TANK.MANUAL_MASS,\n		dbo.TANK.RT_PRESSURE,\n		dbo.TANK.RT_MASS"
+",\n		dbo.TANK.AUTO_PRESSURE_ENABLE,\n		dbo.TANK.AUTO_MASS_ENABLE,\n		dbo.TANK.DOWNLOAD_ENABLE,\n		dbo.TANK.DOWNLOAD_LEVEL_EN"
+"ABLE,\n		dbo.TANK.DOWNLOAD_QUANTITY_ENABLE,\n		dbo.TANK.DOWNLOAD_TEMPERATURE_ENABLE,\n		dbo.TANK.DOWNLOAD_PRESSURE_ENABLE,\n"
+"		dbo.TANK.DOWNLOAD_MASS_ENABLE,\n		dbo.TANK.RT_USER_QUEUE_ENABLE,\n		dbo.TANK.RT_USER_CONTEXT_VALUE,\n		dbo.TANK.RT_FRAC_G"
+"ROSS_SNAPSHOT_DELTA,\n		dbo.TANK.RT_FRAC_NET_SNAPSHOT_DELTA,\n		dbo.TANK.RT_FRAC_EOD_MANUAL_DELTA,\n		dbo.TANK.RT_TEMPERATU"
+"RE_SNAPSHOT,\n		dbo.TANK.RT_DENSITY_SNAPSHOT,\n		dbo.TANK.RT_END_TEMPERATURE_SNAPSHOT,\n		dbo.TANK.RT_END_DENSITY_SNAPSHOT,"
+"\n		dbo.TANK.RT_FRAC_EOD_TRANSFERS_IN,\n		dbo.TANK.RT_FRAC_EOD_TRANSFERS_OUT,\n		dbo.TANK.MANUAL_QUANTITY_ENABLE,\n		dbo.TAN"
+"K.MANUAL_BSW_QUANTITY,\n		dbo.TANK.EOM_MANUAL_QUANTITY,\n		dbo.TANK.MANUAL_GROSS_QUANTITY,\n		dbo.TANK.MANUAL_LOW_LOW_QUANT"
+"ITY,\n		dbo.TANK.MANUAL_LOW_QUANTITY,\n		dbo.TANK.MANUAL_GENERAL_QUANTITY,\n		dbo.TANK.MANUAL_CUTOFF_QUANTITY,\n		dbo.TANK.M"
+"ANUAL_HIGH_QUANTITY,\n		dbo.TANK.MANUAL_HIGH_HIGH_QUANTITY,\n		dbo.TANK.MANUAL_OBSERVED_DENSITY,\n		dbo.TANK.RT_OBSERVED_DE"
+"NSITY,\n		dbo.TANK.RT_OBS_DENSITY_SNAPSHOT,\n		dbo.TANK.RT_END_OBS_DENSITY_SNAPSHOT,\n		dbo.TANK.AUTO_BSW_LEVEL_ENABLE,\n		d"
+"bo.TANK.AUTO_BSW_QUANTITY_ENABLE,\n		dbo.TANK.RT_AUTO_BSW_LEVEL,\n		dbo.TANK.RT_AUTO_BSW_QUANTITY,\n		dbo.TANK.RT_BSW_LEVEL"
+",\n		dbo.TANK.DDE_BSW_LEVEL_DSN,\n		dbo.TANK.DDE_BSW_LEVEL_ITEM,\n		dbo.TANK.DDE_BSW_QUANTITY_DSN,\n		dbo.TANK.DDE_BSW_QUANT"
+"ITY_ITEM,\n		dbo.TANK.DOWNLOAD_DENSITY_ENABLE,\n		dbo.TANK.RT_EOD_ADD_MANUAL_DELTA,\n		dbo.TANK.RT_EOD_ADD_BULK_RECEIPTS,\n	"
+"	dbo.TANK.RT_EOD_ADD_RACK_RECEIPTS,\n		dbo.TANK.RT_EOD_ADD_TRANSFERS_IN,\n		dbo.TANK.RT_EOD_ADD_BULK_DISPOSALS,\n		dbo.TANK"
+".RT_EOD_ADD_RACK_DISPOSALS,\n		dbo.TANK.RT_EOD_ADD_TRANSFERS_OUT,\n		dbo.TANK.RT_EOD_ADD_BOOK_INVENTORY,\n		dbo.TANK.RT_IN_"
+"SERVICE,\n		dbo.TANK.VIRTUAL_TANK,\n		dbo.TANK.DDE_IN_SERVICE_ITEM,\n		dbo.TANK.TANK_GROUP,\n		dbo.TANK.DDE_IN_SERVICE_DSN,\n"
+"		dbo.TANK.RT_CUTOFF_QUANTITY,\n		dbo.TANK.AUTO_NET_QUANTITY_ENABLE,\n		dbo.TANK.DDE_NET_QUANTITY_ITEM,\n		dbo.TANK.RT_AUTO"
+"_NET_QUANTITY,\n		dbo.TANK.DDE_NET_QUANTITY_DSN,\n		dbo.TANK.MANUAL_NET_QUANTITY_ENABLE,\n		dbo.TANK.MANUAL_NET_QUANTITY,\n	"
+"	dbo.TANK.HIGH_BSW_SETPOINT,\n		dbo.TANK.HIGH_BSW_QUANTITY,\n		dbo.TANK.DDE_BSW_HIGH_ALARM_DSN,\n		dbo.TANK.DDE_BSW_HIGH_AL"
+"ARM_ITEM,\n		dbo.TANK.RT_EOD_BULK_FRAC_DISPOSALS,\n		dbo.TANK.RT_EOD_BULK_FRAC_RECEIPTS,\n		dbo.TANK.RT_EOD_OPEN_BSW_LEVEL,"
+"\n		dbo.TANK.RT_EOD_OPEN_DENSITY,\n		dbo.TANK.RT_EOD_OPEN_TEMPERATURE,\n		dbo.TANK.RT_EOD_OPEN_BSW_QUANTITY,\n		dbo.TANK.RT_"
+"EOD_OPEN_LEVEL,\n		dbo.TANK.RT_EOD_OPEN_OBSERVED_DENSITY,\n		dbo.TANK.RT_EOD_OPEN_PHYS_GROSS_QTY,\n		dbo.TANK.PREV_EOD_LEVE"
+"L,\n		dbo.TANK.PREV_EOD_GROSS_QUANTITY,\n		dbo.TANK.PREV_EOD_TEMPERATURE,\n		dbo.TANK.PREV_EOD_DENSITY,\n		dbo.TANK.PREV_EOD"
+"_BSW_QUANTITY,\n		dbo.TANK.PREV_EOD_BSW_LEVEL,\n		dbo.TANK.RT_PREV_EOD_NET_QUANTITY,\n		dbo.TANK.PREV_EOD_COE,\n		dbo.TANK.R"
+"T_PREV_EOD_BSW_QUANTITY,\n		dbo.TANK.PREV_EOD_QUANTITY,\n		dbo.TANK.OPENING_COE,\n		dbo.TANK.RT_TOV,\n		dbo.TANK.RT_GOV,\n		d"
+"bo.TANK.RT_GSV,\n		dbo.TANK.RT_TCV,\n		dbo.TANK.RT_SHELL_CORRECTION_FACTOR,\n		dbo.TANK.RT_FLOATING_ROOF_ADJUSTMENT,\n		dbo."
+"TANK.RT_CTL,\n		dbo.TANK.SUSPENDED_BSW_PERCENT,\n		dbo.TANK.MANUAL_STRAP_TYPE,\n		dbo.TANK.ROOF_TAKE_OFF_STRAP_TYPE,\n		dbo."
+"TANK.ROOF_SUPPORT_STRAP_TYPE,\n		dbo.TANK.HIGH_BSW_STRAP_TYPE,\n		dbo.TANK.BASE_SEDIMENT_WATER_STRAP_TYPE,\n		dbo.TANK.GAUG"
+"ER_INITIALS,\n		dbo.TANK.GAUGE_TIMESTAMP,\n		dbo.TANK.LEVEL_UNITS,\n		dbo.TANK.SHELL_BASE_TEMPERATURE,\n		dbo.TANK.SHELL_MAT"
+"ERIAL_TYPE,\n		dbo.TANK.MANUAL_AMBIENT_TEMPERATURE,\n		dbo.TANK.INSULATED,\n		dbo.TANK.LINE_SEGMENT_NSV,\n		dbo.TANK.RT_CALC"
+"ULATION_POINT,\n		dbo.TANK.ROOF_TAKE_OFF_TOV,\n		dbo.TANK.RT_NSV,\n		dbo.TANK.RT_GSW,\n		dbo.TANK.RT_NSW,\n		dbo.TANK.RT_WCF,"
+"\n		dbo.TANK.LINE_SEGMENT_NSW,\n		dbo.TANK.ROOF_WEIGHT,\n		dbo.TANK.VOL_IN_ALARM,\n		dbo.TANK.INACTIVITY_QUANTITY,\n		dbo.TAN"
+"K.INACTIVITY_ALARM_STATE,\n		dbo.TANK.USER_LEVEL,\n		dbo.TANK.SCHED_PROD_CHANGE_DATE_TIME,\n		dbo.TANK.SCHED_PROD_CHANGE_TI"
+"MEOUT,\n		dbo.TANK.SCHED_PROD_CHANGE_EMAIL,\n		dbo.TANK.SETPOINT_QUANTITY_ENABLE,\n		dbo.TANK.MANUAL_MEASURED_DENSITY,\n		db"
+"o.TANK.WEIGHT_IN_AIR,\n		dbo.TANK.TOPS_MONITORING_ACTIVE,\n		dbo.TANK.SHAPE,\n		dbo.TANK.ACTUAL_FLOW_RATE_PERIOD,\n		dbo.TAN"
+"K.CALCULATED_FLOW_RATE_PERIOD,\n		dbo.TANK.FLOW_RATE_CLAMPING_PERIOD,\n		dbo.TANK.RT_CLAMPING_PERIOD_START,\n		dbo.TANK.VAP"
+"OR_CORRECTION_METHOD,\n		dbo.TANK.VAPOR_TEMPERATURE,\n		dbo.TANK.VAPOR_LIQUID_VOLUME_RATIO,\n		dbo.TANK.TARGET_LEVEL,\n		dbo"
+".TANK.ORIGINAL_STARTING_LEVEL,\n		dbo.TANK.TIME_TO_TARGET_LEVEL,\n		dbo.TANK.AUTO_VAPOR_TEMPERATURE_ENABLE,\n		dbo.TANK.DDE"
+"_PRESSURE_DSN,\n		dbo.TANK.DDE_PRESSURE_ITEM,\n		dbo.TANK.DDE_VAPOR_TEMPERATURE_DSN,\n		dbo.TANK.DDE_VAPOR_TEMPERATURE_ITEM"
+",\n		dbo.TANK.RT_AUTO_VAPOR_TEMPERATURE,\n		dbo.TANK.RT_VAPOR_TEMPERATURE,\n		dbo.TANK.INVENTORY_ENABLE,\n		dbo.TANK.MANUAL_"
+"TO_AUTO_FOLIO_LIMIT,\n		dbo.TANK.RT_MANUAL_TO_AUTO_FOLIO_COUNT,\n		dbo.TANK.RT_LEVEL_ORIGIN,\n		dbo.TANK.RT_TOV_ORIGIN,\n		d"
+"bo.TANK.RT_TEMPERATURE_ORIGIN,\n		dbo.TANK.RT_DENSITY_ORIGIN,\n		dbo.TANK.RT_NSV_ORIGIN,\n		dbo.TANK.RT_VAPOR_TEMPERATURE_O"
+"RIGIN,\n		dbo.TANK.RT_PRESSURE_ORIGIN,\n		dbo.TANK.RT_FREE_WATER_LEVEL_ORIGIN,\n		dbo.TANK.RT_WATER_QUANTITY_ORIGIN,\n		dbo."
+"TANK.DDE_SNAPSHOT_REQ_DSN,\n		dbo.TANK.DDE_SNAPSHOT_REQ_ITEM,\n		dbo.TANK.DDE_SNAPSHOT_RSP_DSN,\n		dbo.TANK.DDE_SNAPSHOT_RS"
+"P_ITEM,\n		dbo.TANK.AUTO_PRODUCT_LEVEL_UNIT,\n		dbo.TANK.AUTO_FREE_WATER_LEVEL_UNIT\nFROM	dbo.TANK";
		    

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
								row1.TANK_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(1);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(1).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.TANK_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.TANK_CODE = tmpContent_tDBInput_1;
                }
            } else {
                row1.TANK_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 2) {
								row1.NAME = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(2);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(2).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.NAME = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.NAME = tmpContent_tDBInput_1;
                }
            } else {
                row1.NAME = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 3) {
								row1.COMPARTMENT_OWNER_ID = null;
							} else {
		                          
            row1.COMPARTMENT_OWNER_ID = rs_tDBInput_1.getInt(3);
            if(rs_tDBInput_1.wasNull()){
                    row1.COMPARTMENT_OWNER_ID = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 4) {
								row1.MAJORITY_SHAREHOLDER = null;
							} else {
		                          
            row1.MAJORITY_SHAREHOLDER = rs_tDBInput_1.getInt(4);
            if(rs_tDBInput_1.wasNull()){
                    row1.MAJORITY_SHAREHOLDER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 5) {
								row1.COMPARTMENT_CONTAINER_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(5);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(5).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.COMPARTMENT_CONTAINER_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.COMPARTMENT_CONTAINER_CODE = tmpContent_tDBInput_1;
                }
            } else {
                row1.COMPARTMENT_CONTAINER_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 6) {
								row1.RT_GROSS_QUANTITY = 0;
							} else {
		                          
            row1.RT_GROSS_QUANTITY = rs_tDBInput_1.getInt(6);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 7) {
								row1.COMPARTMENT_CONTAINER_TYPE = null;
							} else {
		                          
            row1.COMPARTMENT_CONTAINER_TYPE = rs_tDBInput_1.getInt(7);
            if(rs_tDBInput_1.wasNull()){
                    row1.COMPARTMENT_CONTAINER_TYPE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 8) {
								row1.TERMINAL_PRODUCT_NUMBER = 0;
							} else {
		                          
            row1.TERMINAL_PRODUCT_NUMBER = rs_tDBInput_1.getInt(8);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 9) {
								row1.COMPARTMENT_NUMBER = null;
							} else {
		                          
            row1.COMPARTMENT_NUMBER = rs_tDBInput_1.getInt(9);
            if(rs_tDBInput_1.wasNull()){
                    row1.COMPARTMENT_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 10) {
								row1.RT_NET_QUANTITY = 0;
							} else {
		                          
            row1.RT_NET_QUANTITY = rs_tDBInput_1.getInt(10);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 11) {
								row1.ENABLE = 0;
							} else {
		                          
            row1.ENABLE = rs_tDBInput_1.getInt(11);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 12) {
								row1.SCHED_PROD_CHANGE_PRODUCT = null;
							} else {
		                          
            row1.SCHED_PROD_CHANGE_PRODUCT = rs_tDBInput_1.getInt(12);
            if(rs_tDBInput_1.wasNull()){
                    row1.SCHED_PROD_CHANGE_PRODUCT = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 13) {
								row1.RVP = 0;
							} else {
	                         		
            row1.RVP = rs_tDBInput_1.getDouble(13);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 14) {
								row1.OXYGEN = 0;
							} else {
	                         		
            row1.OXYGEN = rs_tDBInput_1.getDouble(14);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 15) {
								row1.RT_TEMPERATURE = 0;
							} else {
	                         		
            row1.RT_TEMPERATURE = rs_tDBInput_1.getDouble(15);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 16) {
								row1.RT_DENSITY = 0;
							} else {
	                         		
            row1.RT_DENSITY = rs_tDBInput_1.getDouble(16);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 17) {
								row1.SHELL_CAPACITY = 0;
							} else {
		                          
            row1.SHELL_CAPACITY = rs_tDBInput_1.getInt(17);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 18) {
								row1.WORK_CAPACITY = 0;
							} else {
		                          
            row1.WORK_CAPACITY = rs_tDBInput_1.getInt(18);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 19) {
								row1.DEPTH = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(19);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(19).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.DEPTH = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.DEPTH = tmpContent_tDBInput_1;
                }
            } else {
                row1.DEPTH = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 20) {
								row1.LOW_LOW_SETPOINT = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(20);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(20).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.LOW_LOW_SETPOINT = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.LOW_LOW_SETPOINT = tmpContent_tDBInput_1;
                }
            } else {
                row1.LOW_LOW_SETPOINT = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 21) {
								row1.LOW_SETPOINT = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(21);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(21).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.LOW_SETPOINT = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.LOW_SETPOINT = tmpContent_tDBInput_1;
                }
            } else {
                row1.LOW_SETPOINT = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 22) {
								row1.GENERAL_SETPOINT = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(22);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(22).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.GENERAL_SETPOINT = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.GENERAL_SETPOINT = tmpContent_tDBInput_1;
                }
            } else {
                row1.GENERAL_SETPOINT = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 23) {
								row1.CUTOFF_SETPOINT = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(23);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(23).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.CUTOFF_SETPOINT = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.CUTOFF_SETPOINT = tmpContent_tDBInput_1;
                }
            } else {
                row1.CUTOFF_SETPOINT = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 24) {
								row1.AUTO_ENABLE = 0;
							} else {
		                          
            row1.AUTO_ENABLE = rs_tDBInput_1.getInt(24);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 25) {
								row1.HIGH_SETPOINT = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(25);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(25).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.HIGH_SETPOINT = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.HIGH_SETPOINT = tmpContent_tDBInput_1;
                }
            } else {
                row1.HIGH_SETPOINT = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 26) {
								row1.HIGH_HIGH_SETPOINT = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(26);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(26).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.HIGH_HIGH_SETPOINT = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.HIGH_HIGH_SETPOINT = tmpContent_tDBInput_1;
                }
            } else {
                row1.HIGH_HIGH_SETPOINT = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 27) {
								row1.DEADBAND = 0;
							} else {
		                          
            row1.DEADBAND = rs_tDBInput_1.getInt(27);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 28) {
								row1.AUTO_LEVEL_ENABLE = 0;
							} else {
		                          
            row1.AUTO_LEVEL_ENABLE = rs_tDBInput_1.getInt(28);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 29) {
								row1.DDE_LEVEL_DSN = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(29);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(29).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.DDE_LEVEL_DSN = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.DDE_LEVEL_DSN = tmpContent_tDBInput_1;
                }
            } else {
                row1.DDE_LEVEL_DSN = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 30) {
								row1.AUTO_DENSITY_ENABLE = 0;
							} else {
		                          
            row1.AUTO_DENSITY_ENABLE = rs_tDBInput_1.getInt(30);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 31) {
								row1.AUTO_TEMPERATURE_ENABLE = 0;
							} else {
		                          
            row1.AUTO_TEMPERATURE_ENABLE = rs_tDBInput_1.getInt(31);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 32) {
								row1.DDE_LEVEL_ITEM = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(32);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(32).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.DDE_LEVEL_ITEM = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.DDE_LEVEL_ITEM = tmpContent_tDBInput_1;
                }
            } else {
                row1.DDE_LEVEL_ITEM = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 33) {
								row1.AUTO_QUANTITY_ENABLE = 0;
							} else {
		                          
            row1.AUTO_QUANTITY_ENABLE = rs_tDBInput_1.getInt(33);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 34) {
								row1.DDE_DENSITY_DSN = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(34);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(34).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.DDE_DENSITY_DSN = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.DDE_DENSITY_DSN = tmpContent_tDBInput_1;
                }
            } else {
                row1.DDE_DENSITY_DSN = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 35) {
								row1.ACTIVITY_STATUS = 0;
							} else {
		                          
            row1.ACTIVITY_STATUS = rs_tDBInput_1.getInt(35);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 36) {
								row1.DDE_DENSITY_ITEM = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(36);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(36).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.DDE_DENSITY_ITEM = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.DDE_DENSITY_ITEM = tmpContent_tDBInput_1;
                }
            } else {
                row1.DDE_DENSITY_ITEM = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 37) {
								row1.DDE_TEMPERATURE_DSN = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(37);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(37).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.DDE_TEMPERATURE_DSN = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.DDE_TEMPERATURE_DSN = tmpContent_tDBInput_1;
                }
            } else {
                row1.DDE_TEMPERATURE_DSN = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 38) {
								row1.RECEIPT_INDICATOR = 0;
							} else {
		                          
            row1.RECEIPT_INDICATOR = rs_tDBInput_1.getInt(38);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 39) {
								row1.DDE_TEMPERATURE_ITEM = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(39);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(39).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.DDE_TEMPERATURE_ITEM = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.DDE_TEMPERATURE_ITEM = tmpContent_tDBInput_1;
                }
            } else {
                row1.DDE_TEMPERATURE_ITEM = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 40) {
								row1.LAST_RECEIPT_DATE = null;
							} else {
										
			row1.LAST_RECEIPT_DATE = mssqlGTU_tDBInput_1.getDate(rsmd_tDBInput_1, rs_tDBInput_1, 40);
			
		                    }
							if(colQtyInRs_tDBInput_1 < 41) {
								row1.DDE_QUANTITY_DSN = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(41);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(41).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.DDE_QUANTITY_DSN = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.DDE_QUANTITY_DSN = tmpContent_tDBInput_1;
                }
            } else {
                row1.DDE_QUANTITY_DSN = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 42) {
								row1.DDE_QUANTITY_ITEM = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(42);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(42).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.DDE_QUANTITY_ITEM = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.DDE_QUANTITY_ITEM = tmpContent_tDBInput_1;
                }
            } else {
                row1.DDE_QUANTITY_ITEM = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 43) {
								row1.SEND_TO_HOST_AT_EOD = 0;
							} else {
		                          
            row1.SEND_TO_HOST_AT_EOD = rs_tDBInput_1.getInt(43);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 44) {
								row1.MANUAL_LEVEL = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(44);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(44).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.MANUAL_LEVEL = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.MANUAL_LEVEL = tmpContent_tDBInput_1;
                }
            } else {
                row1.MANUAL_LEVEL = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 45) {
								row1.RT_AUTO_LEVEL = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(45);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(45).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.RT_AUTO_LEVEL = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.RT_AUTO_LEVEL = tmpContent_tDBInput_1;
                }
            } else {
                row1.RT_AUTO_LEVEL = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 46) {
								row1.EOM_MANUAL_LEVEL = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(46);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(46).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.EOM_MANUAL_LEVEL = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.EOM_MANUAL_LEVEL = tmpContent_tDBInput_1;
                }
            } else {
                row1.EOM_MANUAL_LEVEL = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 47) {
								row1.RT_EOM_GROSS_QUANTITY = 0;
							} else {
		                          
            row1.RT_EOM_GROSS_QUANTITY = rs_tDBInput_1.getInt(47);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 48) {
								row1.RT_AUTO_DENSITY = 0;
							} else {
	                         		
            row1.RT_AUTO_DENSITY = rs_tDBInput_1.getDouble(48);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 49) {
								row1.EOM_MANUAL_TEMPERATURE = 0;
							} else {
	                         		
            row1.EOM_MANUAL_TEMPERATURE = rs_tDBInput_1.getDouble(49);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 50) {
								row1.EOM_MANUAL_DENSITY = 0;
							} else {
	                         		
            row1.EOM_MANUAL_DENSITY = rs_tDBInput_1.getDouble(50);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 51) {
								row1.EOM_MANUAL_BSW_QUANTITY = 0;
							} else {
		                          
            row1.EOM_MANUAL_BSW_QUANTITY = rs_tDBInput_1.getInt(51);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 52) {
								row1.EOM_MANUAL_BSW_LEVEL = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(52);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(52).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.EOM_MANUAL_BSW_LEVEL = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.EOM_MANUAL_BSW_LEVEL = tmpContent_tDBInput_1;
                }
            } else {
                row1.EOM_MANUAL_BSW_LEVEL = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 53) {
								row1.MANUAL_TEMPERATURE = 0;
							} else {
	                         		
            row1.MANUAL_TEMPERATURE = rs_tDBInput_1.getDouble(53);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 54) {
								row1.RT_EOM_NET_QUANTITY = 0;
							} else {
		                          
            row1.RT_EOM_NET_QUANTITY = rs_tDBInput_1.getInt(54);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 55) {
								row1.EOM_MANUAL_COE = 0;
							} else {
	                         		
            row1.EOM_MANUAL_COE = rs_tDBInput_1.getDouble(55);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 56) {
								row1.RT_EOM_BSW_QUANTITY = 0;
							} else {
		                          
            row1.RT_EOM_BSW_QUANTITY = rs_tDBInput_1.getInt(56);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 57) {
								row1.MANUAL_DATE = null;
							} else {
										
			row1.MANUAL_DATE = mssqlGTU_tDBInput_1.getDate(rsmd_tDBInput_1, rs_tDBInput_1, 57);
			
		                    }
							if(colQtyInRs_tDBInput_1 < 58) {
								row1.BASE_SEDIMENT_WATER_LEVEL = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(58);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(58).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.BASE_SEDIMENT_WATER_LEVEL = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.BASE_SEDIMENT_WATER_LEVEL = tmpContent_tDBInput_1;
                }
            } else {
                row1.BASE_SEDIMENT_WATER_LEVEL = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 59) {
								row1.MANUAL_DENSITY = 0;
							} else {
	                         		
            row1.MANUAL_DENSITY = rs_tDBInput_1.getDouble(59);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 60) {
								row1.RT_BSW_QUANTITY = 0;
							} else {
		                          
            row1.RT_BSW_QUANTITY = rs_tDBInput_1.getInt(60);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 61) {
								row1.MANUAL_SPECIFIC_GRAVITY = 0;
							} else {
	                         		
            row1.MANUAL_SPECIFIC_GRAVITY = rs_tDBInput_1.getDouble(61);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 62) {
								row1.PIPE_FILL = 0;
							} else {
		                          
            row1.PIPE_FILL = rs_tDBInput_1.getInt(62);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 63) {
								row1.MANUAL_COEFFICIENT_EXPANSION = 0;
							} else {
	                         		
            row1.MANUAL_COEFFICIENT_EXPANSION = rs_tDBInput_1.getDouble(63);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 64) {
								row1.PROTOCOL_TYPE = 0;
							} else {
		                          
            row1.PROTOCOL_TYPE = rs_tDBInput_1.getInt(64);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 65) {
								row1.RT_AUTO_TEMPERATURE = 0;
							} else {
	                         		
            row1.RT_AUTO_TEMPERATURE = rs_tDBInput_1.getDouble(65);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 66) {
								row1.PORT_NAME = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(66);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(66).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.PORT_NAME = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.PORT_NAME = tmpContent_tDBInput_1;
                }
            } else {
                row1.PORT_NAME = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 67) {
								row1.RT_AUTO_QUANTITY = 0;
							} else {
		                          
            row1.RT_AUTO_QUANTITY = rs_tDBInput_1.getInt(67);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 68) {
								row1.ADDRESS = 0;
							} else {
		                          
            row1.ADDRESS = rs_tDBInput_1.getInt(68);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 69) {
								row1.REMARKS = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(69);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(69).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.REMARKS = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.REMARKS = tmpContent_tDBInput_1;
                }
            } else {
                row1.REMARKS = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 70) {
								row1.FAST_SCAN = 0;
							} else {
		                          
            row1.FAST_SCAN = rs_tDBInput_1.getInt(70);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 71) {
								row1.RT_LEVEL = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(71);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(71).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.RT_LEVEL = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.RT_LEVEL = tmpContent_tDBInput_1;
                }
            } else {
                row1.RT_LEVEL = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 72) {
								row1.RT_METER_COUNT = 0;
							} else {
		                          
            row1.RT_METER_COUNT = rs_tDBInput_1.getInt(72);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 73) {
								row1.RT_GROSS_SNAPSHOT = 0;
							} else {
		                          
            row1.RT_GROSS_SNAPSHOT = rs_tDBInput_1.getInt(73);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 74) {
								row1.RT_SNAPSHOT_ACTIVE = 0;
							} else {
		                          
            row1.RT_SNAPSHOT_ACTIVE = rs_tDBInput_1.getInt(74);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 75) {
								row1.RT_LEVEL_SNAPSHOT = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(75);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(75).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.RT_LEVEL_SNAPSHOT = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.RT_LEVEL_SNAPSHOT = tmpContent_tDBInput_1;
                }
            } else {
                row1.RT_LEVEL_SNAPSHOT = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 76) {
								row1.RT_NET_SNAPSHOT = 0;
							} else {
		                          
            row1.RT_NET_SNAPSHOT = rs_tDBInput_1.getInt(76);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 77) {
								row1.RT_SNAPSHOT_DATE = null;
							} else {
										
			row1.RT_SNAPSHOT_DATE = mssqlGTU_tDBInput_1.getDate(rsmd_tDBInput_1, rs_tDBInput_1, 77);
			
		                    }
							if(colQtyInRs_tDBInput_1 < 78) {
								row1.RT_GROSS_SNAPSHOT_DELTA = 0;
							} else {
		                          
            row1.RT_GROSS_SNAPSHOT_DELTA = rs_tDBInput_1.getInt(78);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 79) {
								row1.RT_NET_SNAPSHOT_DELTA = 0;
							} else {
		                          
            row1.RT_NET_SNAPSHOT_DELTA = rs_tDBInput_1.getInt(79);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 80) {
								row1.RT_EOD_MANUAL_DELTA = 0;
							} else {
		                          
            row1.RT_EOD_MANUAL_DELTA = rs_tDBInput_1.getInt(80);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 81) {
								row1.RT_END_LEVEL_SNAPSHOT = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(81);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(81).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.RT_END_LEVEL_SNAPSHOT = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.RT_END_LEVEL_SNAPSHOT = tmpContent_tDBInput_1;
                }
            } else {
                row1.RT_END_LEVEL_SNAPSHOT = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 82) {
								row1.RT_EOD_OPENING_PHYSICAL = 0;
							} else {
		                          
            row1.RT_EOD_OPENING_PHYSICAL = rs_tDBInput_1.getInt(82);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 83) {
								row1.RT_EOD_BULK_RECEIPTS = 0;
							} else {
		                          
            row1.RT_EOD_BULK_RECEIPTS = rs_tDBInput_1.getInt(83);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 84) {
								row1.RT_END_GROSS_SNAPSHOT = 0;
							} else {
		                          
            row1.RT_END_GROSS_SNAPSHOT = rs_tDBInput_1.getInt(84);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 85) {
								row1.RT_AVAILABLE_QUANTITY = 0;
							} else {
		                          
            row1.RT_AVAILABLE_QUANTITY = rs_tDBInput_1.getInt(85);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 86) {
								row1.RT_END_NET_SNAPSHOT = 0;
							} else {
		                          
            row1.RT_END_NET_SNAPSHOT = rs_tDBInput_1.getInt(86);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 87) {
								row1.RT_EOD_BULK_DISPOSALS = 0;
							} else {
		                          
            row1.RT_EOD_BULK_DISPOSALS = rs_tDBInput_1.getInt(87);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 88) {
								row1.RT_END_SNAPSHOT_DATE = null;
							} else {
										
			row1.RT_END_SNAPSHOT_DATE = mssqlGTU_tDBInput_1.getDate(rsmd_tDBInput_1, rs_tDBInput_1, 88);
			
		                    }
							if(colQtyInRs_tDBInput_1 < 89) {
								row1.RT_EOD_TRANSFERS_IN = 0;
							} else {
		                          
            row1.RT_EOD_TRANSFERS_IN = rs_tDBInput_1.getInt(89);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 90) {
								row1.RT_EOD_RACK_RECEIPTS = 0;
							} else {
		                          
            row1.RT_EOD_RACK_RECEIPTS = rs_tDBInput_1.getInt(90);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 91) {
								row1.RT_EOD_TRANSFERS_OUT = 0;
							} else {
		                          
            row1.RT_EOD_TRANSFERS_OUT = rs_tDBInput_1.getInt(91);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 92) {
								row1.RT_EOD_RACK_DISPOSALS = 0;
							} else {
		                          
            row1.RT_EOD_RACK_DISPOSALS = rs_tDBInput_1.getInt(92);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 93) {
								row1.LAST_USER_NAME = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(93);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(93).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.LAST_USER_NAME = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.LAST_USER_NAME = tmpContent_tDBInput_1;
                }
            } else {
                row1.LAST_USER_NAME = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 94) {
								row1.LAST_MODIFIED = null;
							} else {
										
			row1.LAST_MODIFIED = mssqlGTU_tDBInput_1.getDate(rsmd_tDBInput_1, rs_tDBInput_1, 94);
			
		                    }
							if(colQtyInRs_tDBInput_1 < 95) {
								row1.RT_EOD_BOOK_INVENTORY = 0;
							} else {
		                          
            row1.RT_EOD_BOOK_INVENTORY = rs_tDBInput_1.getInt(95);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 96) {
								row1.USER_DLL = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(96);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(96).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.USER_DLL = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.USER_DLL = tmpContent_tDBInput_1;
                }
            } else {
                row1.USER_DLL = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 97) {
								row1.USER_ROUTINE = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(97);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(97).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.USER_ROUTINE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.USER_ROUTINE = tmpContent_tDBInput_1;
                }
            } else {
                row1.USER_ROUTINE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 98) {
								row1.ROOF_CORRECTION_TYPE = 0;
							} else {
		                          
            row1.ROOF_CORRECTION_TYPE = rs_tDBInput_1.getInt(98);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 99) {
								row1.ROOF_TAKE_OFF_LEVEL = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(99);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(99).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.ROOF_TAKE_OFF_LEVEL = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.ROOF_TAKE_OFF_LEVEL = tmpContent_tDBInput_1;
                }
            } else {
                row1.ROOF_TAKE_OFF_LEVEL = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 100) {
								row1.ROOF_SUPPORT_LEVEL = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(100);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(100).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.ROOF_SUPPORT_LEVEL = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.ROOF_SUPPORT_LEVEL = tmpContent_tDBInput_1;
                }
            } else {
                row1.ROOF_SUPPORT_LEVEL = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 101) {
								row1.ROOF_REFERENCE_DENSITY = 0;
							} else {
	                         		
            row1.ROOF_REFERENCE_DENSITY = rs_tDBInput_1.getDouble(101);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 102) {
								row1.ROOF_ABOVE_ADJUSTMENT = 0;
							} else {
	                         		
            row1.ROOF_ABOVE_ADJUSTMENT = rs_tDBInput_1.getDouble(102);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 103) {
								row1.RT_EOD_MANUAL_CLOSING_ENABLE = 0;
							} else {
		                          
            row1.RT_EOD_MANUAL_CLOSING_ENABLE = rs_tDBInput_1.getInt(103);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 104) {
								row1.ROOF_BELOW_ADJUSTMENT = 0;
							} else {
	                         		
            row1.ROOF_BELOW_ADJUSTMENT = rs_tDBInput_1.getDouble(104);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 105) {
								row1.RT_EOD_MANUAL_LEVEL = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(105);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(105).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.RT_EOD_MANUAL_LEVEL = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.RT_EOD_MANUAL_LEVEL = tmpContent_tDBInput_1;
                }
            } else {
                row1.RT_EOD_MANUAL_LEVEL = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 106) {
								row1.STRAPPING_INVERTED = 0;
							} else {
		                          
            row1.STRAPPING_INVERTED = rs_tDBInput_1.getInt(106);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 107) {
								row1.RT_EOD_MANUAL_GROSS_QUANTITY = 0;
							} else {
		                          
            row1.RT_EOD_MANUAL_GROSS_QUANTITY = rs_tDBInput_1.getInt(107);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 108) {
								row1.RT_EOD_MANUAL_NET_QUANTITY = 0;
							} else {
		                          
            row1.RT_EOD_MANUAL_NET_QUANTITY = rs_tDBInput_1.getInt(108);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 109) {
								row1.RT_EOD_RACK_FRAC_DISPOSALS = 0;
							} else {
		                          
            row1.RT_EOD_RACK_FRAC_DISPOSALS = rs_tDBInput_1.getInt(109);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 110) {
								row1.RT_EOD_RACK_FRAC_RECEIPTS = 0;
							} else {
		                          
            row1.RT_EOD_RACK_FRAC_RECEIPTS = rs_tDBInput_1.getInt(110);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 111) {
								row1.DDE_HIGH_ALARM_DSN = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(111);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(111).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.DDE_HIGH_ALARM_DSN = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.DDE_HIGH_ALARM_DSN = tmpContent_tDBInput_1;
                }
            } else {
                row1.DDE_HIGH_ALARM_DSN = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 112) {
								row1.DDE_HIGH_ALARM_ITEM = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(112);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(112).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.DDE_HIGH_ALARM_ITEM = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.DDE_HIGH_ALARM_ITEM = tmpContent_tDBInput_1;
                }
            } else {
                row1.DDE_HIGH_ALARM_ITEM = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 113) {
								row1.DDE_HIGH_HIGH_ALARM_DSN = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(113);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(113).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.DDE_HIGH_HIGH_ALARM_DSN = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.DDE_HIGH_HIGH_ALARM_DSN = tmpContent_tDBInput_1;
                }
            } else {
                row1.DDE_HIGH_HIGH_ALARM_DSN = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 114) {
								row1.DDE_HIGH_HIGH_ALARM_ITEM = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(114);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(114).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.DDE_HIGH_HIGH_ALARM_ITEM = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.DDE_HIGH_HIGH_ALARM_ITEM = tmpContent_tDBInput_1;
                }
            } else {
                row1.DDE_HIGH_HIGH_ALARM_ITEM = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 115) {
								row1.DDE_LOW_ALARM_DSN = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(115);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(115).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.DDE_LOW_ALARM_DSN = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.DDE_LOW_ALARM_DSN = tmpContent_tDBInput_1;
                }
            } else {
                row1.DDE_LOW_ALARM_DSN = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 116) {
								row1.DDE_LOW_ALARM_ITEM = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(116);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(116).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.DDE_LOW_ALARM_ITEM = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.DDE_LOW_ALARM_ITEM = tmpContent_tDBInput_1;
                }
            } else {
                row1.DDE_LOW_ALARM_ITEM = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 117) {
								row1.DDE_LOW_LOW_ALARM_DSN = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(117);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(117).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.DDE_LOW_LOW_ALARM_DSN = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.DDE_LOW_LOW_ALARM_DSN = tmpContent_tDBInput_1;
                }
            } else {
                row1.DDE_LOW_LOW_ALARM_DSN = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 118) {
								row1.DDE_LOW_LOW_ALARM_ITEM = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(118);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(118).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.DDE_LOW_LOW_ALARM_ITEM = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.DDE_LOW_LOW_ALARM_ITEM = tmpContent_tDBInput_1;
                }
            } else {
                row1.DDE_LOW_LOW_ALARM_ITEM = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 119) {
								row1.DDE_CUTOFF_ALARM_DSN = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(119);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(119).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.DDE_CUTOFF_ALARM_DSN = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.DDE_CUTOFF_ALARM_DSN = tmpContent_tDBInput_1;
                }
            } else {
                row1.DDE_CUTOFF_ALARM_DSN = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 120) {
								row1.DDE_CUTOFF_ALARM_ITEM = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(120);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(120).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.DDE_CUTOFF_ALARM_ITEM = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.DDE_CUTOFF_ALARM_ITEM = tmpContent_tDBInput_1;
                }
            } else {
                row1.DDE_CUTOFF_ALARM_ITEM = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 121) {
								row1.DDE_STATUS_DSN = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(121);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(121).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.DDE_STATUS_DSN = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.DDE_STATUS_DSN = tmpContent_tDBInput_1;
                }
            } else {
                row1.DDE_STATUS_DSN = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 122) {
								row1.DDE_STATUS_ITEM = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(122);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(122).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.DDE_STATUS_ITEM = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.DDE_STATUS_ITEM = tmpContent_tDBInput_1;
                }
            } else {
                row1.DDE_STATUS_ITEM = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 123) {
								row1.RT_AUTO_PRESSURE = 0;
							} else {
	                         		
            row1.RT_AUTO_PRESSURE = rs_tDBInput_1.getDouble(123);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 124) {
								row1.RT_AUTO_MASS = 0;
							} else {
		                          
            row1.RT_AUTO_MASS = rs_tDBInput_1.getInt(124);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 125) {
								row1.MANUAL_PRESSURE = 0;
							} else {
	                         		
            row1.MANUAL_PRESSURE = rs_tDBInput_1.getDouble(125);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 126) {
								row1.MANUAL_MASS = 0;
							} else {
		                          
            row1.MANUAL_MASS = rs_tDBInput_1.getInt(126);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 127) {
								row1.RT_PRESSURE = 0;
							} else {
	                         		
            row1.RT_PRESSURE = rs_tDBInput_1.getDouble(127);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 128) {
								row1.RT_MASS = 0;
							} else {
		                          
            row1.RT_MASS = rs_tDBInput_1.getInt(128);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 129) {
								row1.AUTO_PRESSURE_ENABLE = 0;
							} else {
		                          
            row1.AUTO_PRESSURE_ENABLE = rs_tDBInput_1.getInt(129);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 130) {
								row1.AUTO_MASS_ENABLE = 0;
							} else {
		                          
            row1.AUTO_MASS_ENABLE = rs_tDBInput_1.getInt(130);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 131) {
								row1.DOWNLOAD_ENABLE = 0;
							} else {
		                          
            row1.DOWNLOAD_ENABLE = rs_tDBInput_1.getInt(131);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 132) {
								row1.DOWNLOAD_LEVEL_ENABLE = 0;
							} else {
		                          
            row1.DOWNLOAD_LEVEL_ENABLE = rs_tDBInput_1.getInt(132);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 133) {
								row1.DOWNLOAD_QUANTITY_ENABLE = 0;
							} else {
		                          
            row1.DOWNLOAD_QUANTITY_ENABLE = rs_tDBInput_1.getInt(133);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 134) {
								row1.DOWNLOAD_TEMPERATURE_ENABLE = 0;
							} else {
		                          
            row1.DOWNLOAD_TEMPERATURE_ENABLE = rs_tDBInput_1.getInt(134);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 135) {
								row1.DOWNLOAD_PRESSURE_ENABLE = 0;
							} else {
		                          
            row1.DOWNLOAD_PRESSURE_ENABLE = rs_tDBInput_1.getInt(135);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 136) {
								row1.DOWNLOAD_MASS_ENABLE = 0;
							} else {
		                          
            row1.DOWNLOAD_MASS_ENABLE = rs_tDBInput_1.getInt(136);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 137) {
								row1.RT_USER_QUEUE_ENABLE = 0;
							} else {
		                          
            row1.RT_USER_QUEUE_ENABLE = rs_tDBInput_1.getInt(137);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 138) {
								row1.RT_USER_CONTEXT_VALUE = 0;
							} else {
		                          
            row1.RT_USER_CONTEXT_VALUE = rs_tDBInput_1.getInt(138);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 139) {
								row1.RT_FRAC_GROSS_SNAPSHOT_DELTA = 0;
							} else {
		                          
            row1.RT_FRAC_GROSS_SNAPSHOT_DELTA = rs_tDBInput_1.getInt(139);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 140) {
								row1.RT_FRAC_NET_SNAPSHOT_DELTA = 0;
							} else {
		                          
            row1.RT_FRAC_NET_SNAPSHOT_DELTA = rs_tDBInput_1.getInt(140);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 141) {
								row1.RT_FRAC_EOD_MANUAL_DELTA = 0;
							} else {
		                          
            row1.RT_FRAC_EOD_MANUAL_DELTA = rs_tDBInput_1.getInt(141);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 142) {
								row1.RT_TEMPERATURE_SNAPSHOT = 0;
							} else {
	                         		
            row1.RT_TEMPERATURE_SNAPSHOT = rs_tDBInput_1.getDouble(142);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 143) {
								row1.RT_DENSITY_SNAPSHOT = 0;
							} else {
	                         		
            row1.RT_DENSITY_SNAPSHOT = rs_tDBInput_1.getDouble(143);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 144) {
								row1.RT_END_TEMPERATURE_SNAPSHOT = 0;
							} else {
	                         		
            row1.RT_END_TEMPERATURE_SNAPSHOT = rs_tDBInput_1.getDouble(144);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 145) {
								row1.RT_END_DENSITY_SNAPSHOT = 0;
							} else {
	                         		
            row1.RT_END_DENSITY_SNAPSHOT = rs_tDBInput_1.getDouble(145);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 146) {
								row1.RT_FRAC_EOD_TRANSFERS_IN = 0;
							} else {
		                          
            row1.RT_FRAC_EOD_TRANSFERS_IN = rs_tDBInput_1.getInt(146);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 147) {
								row1.RT_FRAC_EOD_TRANSFERS_OUT = 0;
							} else {
		                          
            row1.RT_FRAC_EOD_TRANSFERS_OUT = rs_tDBInput_1.getInt(147);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 148) {
								row1.MANUAL_QUANTITY_ENABLE = 0;
							} else {
		                          
            row1.MANUAL_QUANTITY_ENABLE = rs_tDBInput_1.getInt(148);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 149) {
								row1.MANUAL_BSW_QUANTITY = 0;
							} else {
		                          
            row1.MANUAL_BSW_QUANTITY = rs_tDBInput_1.getInt(149);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 150) {
								row1.EOM_MANUAL_QUANTITY = 0;
							} else {
		                          
            row1.EOM_MANUAL_QUANTITY = rs_tDBInput_1.getInt(150);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 151) {
								row1.MANUAL_GROSS_QUANTITY = 0;
							} else {
		                          
            row1.MANUAL_GROSS_QUANTITY = rs_tDBInput_1.getInt(151);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 152) {
								row1.MANUAL_LOW_LOW_QUANTITY = 0;
							} else {
		                          
            row1.MANUAL_LOW_LOW_QUANTITY = rs_tDBInput_1.getInt(152);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 153) {
								row1.MANUAL_LOW_QUANTITY = 0;
							} else {
		                          
            row1.MANUAL_LOW_QUANTITY = rs_tDBInput_1.getInt(153);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 154) {
								row1.MANUAL_GENERAL_QUANTITY = 0;
							} else {
		                          
            row1.MANUAL_GENERAL_QUANTITY = rs_tDBInput_1.getInt(154);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 155) {
								row1.MANUAL_CUTOFF_QUANTITY = 0;
							} else {
		                          
            row1.MANUAL_CUTOFF_QUANTITY = rs_tDBInput_1.getInt(155);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 156) {
								row1.MANUAL_HIGH_QUANTITY = 0;
							} else {
		                          
            row1.MANUAL_HIGH_QUANTITY = rs_tDBInput_1.getInt(156);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 157) {
								row1.MANUAL_HIGH_HIGH_QUANTITY = 0;
							} else {
		                          
            row1.MANUAL_HIGH_HIGH_QUANTITY = rs_tDBInput_1.getInt(157);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 158) {
								row1.MANUAL_OBSERVED_DENSITY = 0;
							} else {
	                         		
            row1.MANUAL_OBSERVED_DENSITY = rs_tDBInput_1.getDouble(158);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 159) {
								row1.RT_OBSERVED_DENSITY = 0;
							} else {
	                         		
            row1.RT_OBSERVED_DENSITY = rs_tDBInput_1.getDouble(159);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 160) {
								row1.RT_OBS_DENSITY_SNAPSHOT = 0;
							} else {
	                         		
            row1.RT_OBS_DENSITY_SNAPSHOT = rs_tDBInput_1.getDouble(160);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 161) {
								row1.RT_END_OBS_DENSITY_SNAPSHOT = 0;
							} else {
	                         		
            row1.RT_END_OBS_DENSITY_SNAPSHOT = rs_tDBInput_1.getDouble(161);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 162) {
								row1.AUTO_BSW_LEVEL_ENABLE = 0;
							} else {
		                          
            row1.AUTO_BSW_LEVEL_ENABLE = rs_tDBInput_1.getInt(162);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 163) {
								row1.AUTO_BSW_QUANTITY_ENABLE = 0;
							} else {
		                          
            row1.AUTO_BSW_QUANTITY_ENABLE = rs_tDBInput_1.getInt(163);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 164) {
								row1.RT_AUTO_BSW_LEVEL = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(164);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(164).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.RT_AUTO_BSW_LEVEL = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.RT_AUTO_BSW_LEVEL = tmpContent_tDBInput_1;
                }
            } else {
                row1.RT_AUTO_BSW_LEVEL = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 165) {
								row1.RT_AUTO_BSW_QUANTITY = 0;
							} else {
		                          
            row1.RT_AUTO_BSW_QUANTITY = rs_tDBInput_1.getInt(165);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 166) {
								row1.RT_BSW_LEVEL = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(166);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(166).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.RT_BSW_LEVEL = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.RT_BSW_LEVEL = tmpContent_tDBInput_1;
                }
            } else {
                row1.RT_BSW_LEVEL = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 167) {
								row1.DDE_BSW_LEVEL_DSN = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(167);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(167).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.DDE_BSW_LEVEL_DSN = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.DDE_BSW_LEVEL_DSN = tmpContent_tDBInput_1;
                }
            } else {
                row1.DDE_BSW_LEVEL_DSN = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 168) {
								row1.DDE_BSW_LEVEL_ITEM = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(168);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(168).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.DDE_BSW_LEVEL_ITEM = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.DDE_BSW_LEVEL_ITEM = tmpContent_tDBInput_1;
                }
            } else {
                row1.DDE_BSW_LEVEL_ITEM = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 169) {
								row1.DDE_BSW_QUANTITY_DSN = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(169);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(169).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.DDE_BSW_QUANTITY_DSN = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.DDE_BSW_QUANTITY_DSN = tmpContent_tDBInput_1;
                }
            } else {
                row1.DDE_BSW_QUANTITY_DSN = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 170) {
								row1.DDE_BSW_QUANTITY_ITEM = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(170);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(170).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.DDE_BSW_QUANTITY_ITEM = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.DDE_BSW_QUANTITY_ITEM = tmpContent_tDBInput_1;
                }
            } else {
                row1.DDE_BSW_QUANTITY_ITEM = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 171) {
								row1.DOWNLOAD_DENSITY_ENABLE = 0;
							} else {
		                          
            row1.DOWNLOAD_DENSITY_ENABLE = rs_tDBInput_1.getInt(171);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 172) {
								row1.RT_EOD_ADD_MANUAL_DELTA = 0;
							} else {
		                          
            row1.RT_EOD_ADD_MANUAL_DELTA = rs_tDBInput_1.getInt(172);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 173) {
								row1.RT_EOD_ADD_BULK_RECEIPTS = 0;
							} else {
		                          
            row1.RT_EOD_ADD_BULK_RECEIPTS = rs_tDBInput_1.getInt(173);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 174) {
								row1.RT_EOD_ADD_RACK_RECEIPTS = 0;
							} else {
		                          
            row1.RT_EOD_ADD_RACK_RECEIPTS = rs_tDBInput_1.getInt(174);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 175) {
								row1.RT_EOD_ADD_TRANSFERS_IN = 0;
							} else {
		                          
            row1.RT_EOD_ADD_TRANSFERS_IN = rs_tDBInput_1.getInt(175);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 176) {
								row1.RT_EOD_ADD_BULK_DISPOSALS = 0;
							} else {
		                          
            row1.RT_EOD_ADD_BULK_DISPOSALS = rs_tDBInput_1.getInt(176);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 177) {
								row1.RT_EOD_ADD_RACK_DISPOSALS = 0;
							} else {
		                          
            row1.RT_EOD_ADD_RACK_DISPOSALS = rs_tDBInput_1.getInt(177);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 178) {
								row1.RT_EOD_ADD_TRANSFERS_OUT = 0;
							} else {
		                          
            row1.RT_EOD_ADD_TRANSFERS_OUT = rs_tDBInput_1.getInt(178);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 179) {
								row1.RT_EOD_ADD_BOOK_INVENTORY = 0;
							} else {
		                          
            row1.RT_EOD_ADD_BOOK_INVENTORY = rs_tDBInput_1.getInt(179);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 180) {
								row1.RT_IN_SERVICE = 0;
							} else {
		                          
            row1.RT_IN_SERVICE = rs_tDBInput_1.getInt(180);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 181) {
								row1.VIRTUAL_TANK = 0;
							} else {
		                          
            row1.VIRTUAL_TANK = rs_tDBInput_1.getInt(181);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 182) {
								row1.DDE_IN_SERVICE_ITEM = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(182);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(182).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.DDE_IN_SERVICE_ITEM = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.DDE_IN_SERVICE_ITEM = tmpContent_tDBInput_1;
                }
            } else {
                row1.DDE_IN_SERVICE_ITEM = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 183) {
								row1.TANK_GROUP = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(183);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(183).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.TANK_GROUP = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.TANK_GROUP = tmpContent_tDBInput_1;
                }
            } else {
                row1.TANK_GROUP = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 184) {
								row1.DDE_IN_SERVICE_DSN = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(184);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(184).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.DDE_IN_SERVICE_DSN = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.DDE_IN_SERVICE_DSN = tmpContent_tDBInput_1;
                }
            } else {
                row1.DDE_IN_SERVICE_DSN = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 185) {
								row1.RT_CUTOFF_QUANTITY = 0;
							} else {
		                          
            row1.RT_CUTOFF_QUANTITY = rs_tDBInput_1.getInt(185);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 186) {
								row1.AUTO_NET_QUANTITY_ENABLE = 0;
							} else {
		                          
            row1.AUTO_NET_QUANTITY_ENABLE = rs_tDBInput_1.getInt(186);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 187) {
								row1.DDE_NET_QUANTITY_ITEM = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(187);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(187).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.DDE_NET_QUANTITY_ITEM = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.DDE_NET_QUANTITY_ITEM = tmpContent_tDBInput_1;
                }
            } else {
                row1.DDE_NET_QUANTITY_ITEM = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 188) {
								row1.RT_AUTO_NET_QUANTITY = 0;
							} else {
		                          
            row1.RT_AUTO_NET_QUANTITY = rs_tDBInput_1.getInt(188);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 189) {
								row1.DDE_NET_QUANTITY_DSN = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(189);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(189).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.DDE_NET_QUANTITY_DSN = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.DDE_NET_QUANTITY_DSN = tmpContent_tDBInput_1;
                }
            } else {
                row1.DDE_NET_QUANTITY_DSN = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 190) {
								row1.MANUAL_NET_QUANTITY_ENABLE = 0;
							} else {
		                          
            row1.MANUAL_NET_QUANTITY_ENABLE = rs_tDBInput_1.getInt(190);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 191) {
								row1.MANUAL_NET_QUANTITY = 0;
							} else {
		                          
            row1.MANUAL_NET_QUANTITY = rs_tDBInput_1.getInt(191);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 192) {
								row1.HIGH_BSW_SETPOINT = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(192);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(192).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.HIGH_BSW_SETPOINT = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.HIGH_BSW_SETPOINT = tmpContent_tDBInput_1;
                }
            } else {
                row1.HIGH_BSW_SETPOINT = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 193) {
								row1.HIGH_BSW_QUANTITY = 0;
							} else {
		                          
            row1.HIGH_BSW_QUANTITY = rs_tDBInput_1.getInt(193);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 194) {
								row1.DDE_BSW_HIGH_ALARM_DSN = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(194);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(194).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.DDE_BSW_HIGH_ALARM_DSN = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.DDE_BSW_HIGH_ALARM_DSN = tmpContent_tDBInput_1;
                }
            } else {
                row1.DDE_BSW_HIGH_ALARM_DSN = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 195) {
								row1.DDE_BSW_HIGH_ALARM_ITEM = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(195);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(195).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.DDE_BSW_HIGH_ALARM_ITEM = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.DDE_BSW_HIGH_ALARM_ITEM = tmpContent_tDBInput_1;
                }
            } else {
                row1.DDE_BSW_HIGH_ALARM_ITEM = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 196) {
								row1.RT_EOD_BULK_FRAC_DISPOSALS = 0;
							} else {
		                          
            row1.RT_EOD_BULK_FRAC_DISPOSALS = rs_tDBInput_1.getInt(196);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 197) {
								row1.RT_EOD_BULK_FRAC_RECEIPTS = 0;
							} else {
		                          
            row1.RT_EOD_BULK_FRAC_RECEIPTS = rs_tDBInput_1.getInt(197);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 198) {
								row1.RT_EOD_OPEN_BSW_LEVEL = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(198);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(198).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.RT_EOD_OPEN_BSW_LEVEL = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.RT_EOD_OPEN_BSW_LEVEL = tmpContent_tDBInput_1;
                }
            } else {
                row1.RT_EOD_OPEN_BSW_LEVEL = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 199) {
								row1.RT_EOD_OPEN_DENSITY = 0;
							} else {
	                         		
            row1.RT_EOD_OPEN_DENSITY = rs_tDBInput_1.getDouble(199);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 200) {
								row1.RT_EOD_OPEN_TEMPERATURE = 0;
							} else {
	                         		
            row1.RT_EOD_OPEN_TEMPERATURE = rs_tDBInput_1.getDouble(200);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 201) {
								row1.RT_EOD_OPEN_BSW_QUANTITY = 0;
							} else {
		                          
            row1.RT_EOD_OPEN_BSW_QUANTITY = rs_tDBInput_1.getInt(201);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 202) {
								row1.RT_EOD_OPEN_LEVEL = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(202);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(202).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.RT_EOD_OPEN_LEVEL = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.RT_EOD_OPEN_LEVEL = tmpContent_tDBInput_1;
                }
            } else {
                row1.RT_EOD_OPEN_LEVEL = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 203) {
								row1.RT_EOD_OPEN_OBSERVED_DENSITY = 0;
							} else {
	                         		
            row1.RT_EOD_OPEN_OBSERVED_DENSITY = rs_tDBInput_1.getDouble(203);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 204) {
								row1.RT_EOD_OPEN_PHYS_GROSS_QTY = 0;
							} else {
		                          
            row1.RT_EOD_OPEN_PHYS_GROSS_QTY = rs_tDBInput_1.getInt(204);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 205) {
								row1.PREV_EOD_LEVEL = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(205);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(205).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.PREV_EOD_LEVEL = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.PREV_EOD_LEVEL = tmpContent_tDBInput_1;
                }
            } else {
                row1.PREV_EOD_LEVEL = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 206) {
								row1.PREV_EOD_GROSS_QUANTITY = 0;
							} else {
		                          
            row1.PREV_EOD_GROSS_QUANTITY = rs_tDBInput_1.getInt(206);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 207) {
								row1.PREV_EOD_TEMPERATURE = 0;
							} else {
	                         		
            row1.PREV_EOD_TEMPERATURE = rs_tDBInput_1.getDouble(207);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 208) {
								row1.PREV_EOD_DENSITY = 0;
							} else {
	                         		
            row1.PREV_EOD_DENSITY = rs_tDBInput_1.getDouble(208);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 209) {
								row1.PREV_EOD_BSW_QUANTITY = 0;
							} else {
		                          
            row1.PREV_EOD_BSW_QUANTITY = rs_tDBInput_1.getInt(209);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 210) {
								row1.PREV_EOD_BSW_LEVEL = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(210);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(210).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.PREV_EOD_BSW_LEVEL = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.PREV_EOD_BSW_LEVEL = tmpContent_tDBInput_1;
                }
            } else {
                row1.PREV_EOD_BSW_LEVEL = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 211) {
								row1.RT_PREV_EOD_NET_QUANTITY = 0;
							} else {
		                          
            row1.RT_PREV_EOD_NET_QUANTITY = rs_tDBInput_1.getInt(211);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 212) {
								row1.PREV_EOD_COE = 0;
							} else {
	                         		
            row1.PREV_EOD_COE = rs_tDBInput_1.getDouble(212);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 213) {
								row1.RT_PREV_EOD_BSW_QUANTITY = 0;
							} else {
		                          
            row1.RT_PREV_EOD_BSW_QUANTITY = rs_tDBInput_1.getInt(213);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 214) {
								row1.PREV_EOD_QUANTITY = 0;
							} else {
		                          
            row1.PREV_EOD_QUANTITY = rs_tDBInput_1.getInt(214);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 215) {
								row1.OPENING_COE = 0;
							} else {
	                         		
            row1.OPENING_COE = rs_tDBInput_1.getDouble(215);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 216) {
								row1.RT_TOV = 0;
							} else {
		                          
            row1.RT_TOV = rs_tDBInput_1.getInt(216);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 217) {
								row1.RT_GOV = 0;
							} else {
		                          
            row1.RT_GOV = rs_tDBInput_1.getInt(217);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 218) {
								row1.RT_GSV = 0;
							} else {
		                          
            row1.RT_GSV = rs_tDBInput_1.getInt(218);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 219) {
								row1.RT_TCV = 0;
							} else {
		                          
            row1.RT_TCV = rs_tDBInput_1.getInt(219);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 220) {
								row1.RT_SHELL_CORRECTION_FACTOR = 0;
							} else {
	                         		
            row1.RT_SHELL_CORRECTION_FACTOR = rs_tDBInput_1.getDouble(220);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 221) {
								row1.RT_FLOATING_ROOF_ADJUSTMENT = 0;
							} else {
		                          
            row1.RT_FLOATING_ROOF_ADJUSTMENT = rs_tDBInput_1.getInt(221);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 222) {
								row1.RT_CTL = 0;
							} else {
	                         		
            row1.RT_CTL = rs_tDBInput_1.getDouble(222);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 223) {
								row1.SUSPENDED_BSW_PERCENT = 0;
							} else {
	                         		
            row1.SUSPENDED_BSW_PERCENT = rs_tDBInput_1.getDouble(223);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 224) {
								row1.MANUAL_STRAP_TYPE = 0;
							} else {
		                          
            row1.MANUAL_STRAP_TYPE = rs_tDBInput_1.getInt(224);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 225) {
								row1.ROOF_TAKE_OFF_STRAP_TYPE = 0;
							} else {
		                          
            row1.ROOF_TAKE_OFF_STRAP_TYPE = rs_tDBInput_1.getInt(225);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 226) {
								row1.ROOF_SUPPORT_STRAP_TYPE = 0;
							} else {
		                          
            row1.ROOF_SUPPORT_STRAP_TYPE = rs_tDBInput_1.getInt(226);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 227) {
								row1.HIGH_BSW_STRAP_TYPE = 0;
							} else {
		                          
            row1.HIGH_BSW_STRAP_TYPE = rs_tDBInput_1.getInt(227);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 228) {
								row1.BASE_SEDIMENT_WATER_STRAP_TYPE = 0;
							} else {
		                          
            row1.BASE_SEDIMENT_WATER_STRAP_TYPE = rs_tDBInput_1.getInt(228);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 229) {
								row1.GAUGER_INITIALS = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(229);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(229).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.GAUGER_INITIALS = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.GAUGER_INITIALS = tmpContent_tDBInput_1;
                }
            } else {
                row1.GAUGER_INITIALS = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 230) {
								row1.GAUGE_TIMESTAMP = null;
							} else {
										
			row1.GAUGE_TIMESTAMP = mssqlGTU_tDBInput_1.getDate(rsmd_tDBInput_1, rs_tDBInput_1, 230);
			
		                    }
							if(colQtyInRs_tDBInput_1 < 231) {
								row1.LEVEL_UNITS = 0;
							} else {
		                          
            row1.LEVEL_UNITS = rs_tDBInput_1.getInt(231);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 232) {
								row1.SHELL_BASE_TEMPERATURE = 0;
							} else {
	                         		
            row1.SHELL_BASE_TEMPERATURE = rs_tDBInput_1.getDouble(232);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 233) {
								row1.SHELL_MATERIAL_TYPE = 0;
							} else {
		                          
            row1.SHELL_MATERIAL_TYPE = rs_tDBInput_1.getInt(233);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 234) {
								row1.MANUAL_AMBIENT_TEMPERATURE = 0;
							} else {
	                         		
            row1.MANUAL_AMBIENT_TEMPERATURE = rs_tDBInput_1.getDouble(234);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 235) {
								row1.INSULATED = 0;
							} else {
		                          
            row1.INSULATED = rs_tDBInput_1.getInt(235);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 236) {
								row1.LINE_SEGMENT_NSV = 0;
							} else {
		                          
            row1.LINE_SEGMENT_NSV = rs_tDBInput_1.getInt(236);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 237) {
								row1.RT_CALCULATION_POINT = 0;
							} else {
		                          
            row1.RT_CALCULATION_POINT = rs_tDBInput_1.getInt(237);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 238) {
								row1.ROOF_TAKE_OFF_TOV = 0;
							} else {
		                          
            row1.ROOF_TAKE_OFF_TOV = rs_tDBInput_1.getInt(238);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 239) {
								row1.RT_NSV = 0;
							} else {
		                          
            row1.RT_NSV = rs_tDBInput_1.getInt(239);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 240) {
								row1.RT_GSW = 0;
							} else {
		                          
            row1.RT_GSW = rs_tDBInput_1.getInt(240);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 241) {
								row1.RT_NSW = 0;
							} else {
		                          
            row1.RT_NSW = rs_tDBInput_1.getInt(241);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 242) {
								row1.RT_WCF = 0;
							} else {
	                         		
            row1.RT_WCF = rs_tDBInput_1.getDouble(242);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 243) {
								row1.LINE_SEGMENT_NSW = 0;
							} else {
		                          
            row1.LINE_SEGMENT_NSW = rs_tDBInput_1.getInt(243);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 244) {
								row1.ROOF_WEIGHT = 0;
							} else {
	                         		
            row1.ROOF_WEIGHT = rs_tDBInput_1.getDouble(244);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 245) {
								row1.VOL_IN_ALARM = 0;
							} else {
		                          
            row1.VOL_IN_ALARM = rs_tDBInput_1.getInt(245);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 246) {
								row1.INACTIVITY_QUANTITY = 0;
							} else {
		                          
            row1.INACTIVITY_QUANTITY = rs_tDBInput_1.getInt(246);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 247) {
								row1.INACTIVITY_ALARM_STATE = 0;
							} else {
		                          
            row1.INACTIVITY_ALARM_STATE = rs_tDBInput_1.getInt(247);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 248) {
								row1.USER_LEVEL = 0;
							} else {
		                          
            row1.USER_LEVEL = rs_tDBInput_1.getInt(248);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 249) {
								row1.SCHED_PROD_CHANGE_DATE_TIME = null;
							} else {
										
			row1.SCHED_PROD_CHANGE_DATE_TIME = mssqlGTU_tDBInput_1.getDate(rsmd_tDBInput_1, rs_tDBInput_1, 249);
			
		                    }
							if(colQtyInRs_tDBInput_1 < 250) {
								row1.SCHED_PROD_CHANGE_TIMEOUT = 0;
							} else {
		                          
            row1.SCHED_PROD_CHANGE_TIMEOUT = rs_tDBInput_1.getInt(250);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 251) {
								row1.SCHED_PROD_CHANGE_EMAIL = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(251);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(251).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.SCHED_PROD_CHANGE_EMAIL = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.SCHED_PROD_CHANGE_EMAIL = tmpContent_tDBInput_1;
                }
            } else {
                row1.SCHED_PROD_CHANGE_EMAIL = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 252) {
								row1.SETPOINT_QUANTITY_ENABLE = 0;
							} else {
		                          
            row1.SETPOINT_QUANTITY_ENABLE = rs_tDBInput_1.getInt(252);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 253) {
								row1.MANUAL_MEASURED_DENSITY = 0;
							} else {
	                         		
            row1.MANUAL_MEASURED_DENSITY = rs_tDBInput_1.getDouble(253);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 254) {
								row1.WEIGHT_IN_AIR = 0;
							} else {
		                          
            row1.WEIGHT_IN_AIR = rs_tDBInput_1.getInt(254);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 255) {
								row1.TOPS_MONITORING_ACTIVE = 0;
							} else {
		                          
            row1.TOPS_MONITORING_ACTIVE = rs_tDBInput_1.getInt(255);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 256) {
								row1.SHAPE = 0;
							} else {
		                          
            row1.SHAPE = rs_tDBInput_1.getInt(256);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 257) {
								row1.ACTUAL_FLOW_RATE_PERIOD = 0;
							} else {
		                          
            row1.ACTUAL_FLOW_RATE_PERIOD = rs_tDBInput_1.getInt(257);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 258) {
								row1.CALCULATED_FLOW_RATE_PERIOD = 0;
							} else {
		                          
            row1.CALCULATED_FLOW_RATE_PERIOD = rs_tDBInput_1.getInt(258);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 259) {
								row1.FLOW_RATE_CLAMPING_PERIOD = 0;
							} else {
		                          
            row1.FLOW_RATE_CLAMPING_PERIOD = rs_tDBInput_1.getInt(259);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 260) {
								row1.RT_CLAMPING_PERIOD_START = null;
							} else {
										
			row1.RT_CLAMPING_PERIOD_START = mssqlGTU_tDBInput_1.getDate(rsmd_tDBInput_1, rs_tDBInput_1, 260);
			
		                    }
							if(colQtyInRs_tDBInput_1 < 261) {
								row1.VAPOR_CORRECTION_METHOD = 0;
							} else {
		                          
            row1.VAPOR_CORRECTION_METHOD = rs_tDBInput_1.getInt(261);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 262) {
								row1.VAPOR_TEMPERATURE = 0;
							} else {
	                         		
            row1.VAPOR_TEMPERATURE = rs_tDBInput_1.getDouble(262);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 263) {
								row1.VAPOR_LIQUID_VOLUME_RATIO = 0;
							} else {
	                         		
            row1.VAPOR_LIQUID_VOLUME_RATIO = rs_tDBInput_1.getDouble(263);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 264) {
								row1.TARGET_LEVEL = 0;
							} else {
		                          
            row1.TARGET_LEVEL = rs_tDBInput_1.getInt(264);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 265) {
								row1.ORIGINAL_STARTING_LEVEL = 0;
							} else {
		                          
            row1.ORIGINAL_STARTING_LEVEL = rs_tDBInput_1.getInt(265);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 266) {
								row1.TIME_TO_TARGET_LEVEL = 0;
							} else {
		                          
            row1.TIME_TO_TARGET_LEVEL = rs_tDBInput_1.getInt(266);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 267) {
								row1.AUTO_VAPOR_TEMPERATURE_ENABLE = 0;
							} else {
		                          
            row1.AUTO_VAPOR_TEMPERATURE_ENABLE = rs_tDBInput_1.getInt(267);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 268) {
								row1.DDE_PRESSURE_DSN = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(268);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(268).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.DDE_PRESSURE_DSN = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.DDE_PRESSURE_DSN = tmpContent_tDBInput_1;
                }
            } else {
                row1.DDE_PRESSURE_DSN = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 269) {
								row1.DDE_PRESSURE_ITEM = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(269);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(269).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.DDE_PRESSURE_ITEM = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.DDE_PRESSURE_ITEM = tmpContent_tDBInput_1;
                }
            } else {
                row1.DDE_PRESSURE_ITEM = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 270) {
								row1.DDE_VAPOR_TEMPERATURE_DSN = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(270);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(270).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.DDE_VAPOR_TEMPERATURE_DSN = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.DDE_VAPOR_TEMPERATURE_DSN = tmpContent_tDBInput_1;
                }
            } else {
                row1.DDE_VAPOR_TEMPERATURE_DSN = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 271) {
								row1.DDE_VAPOR_TEMPERATURE_ITEM = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(271);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(271).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.DDE_VAPOR_TEMPERATURE_ITEM = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.DDE_VAPOR_TEMPERATURE_ITEM = tmpContent_tDBInput_1;
                }
            } else {
                row1.DDE_VAPOR_TEMPERATURE_ITEM = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 272) {
								row1.RT_AUTO_VAPOR_TEMPERATURE = 0;
							} else {
	                         		
            row1.RT_AUTO_VAPOR_TEMPERATURE = rs_tDBInput_1.getDouble(272);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 273) {
								row1.RT_VAPOR_TEMPERATURE = 0;
							} else {
	                         		
            row1.RT_VAPOR_TEMPERATURE = rs_tDBInput_1.getDouble(273);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 274) {
								row1.INVENTORY_ENABLE = 0;
							} else {
		                          
            row1.INVENTORY_ENABLE = rs_tDBInput_1.getInt(274);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 275) {
								row1.MANUAL_TO_AUTO_FOLIO_LIMIT = 0;
							} else {
		                          
            row1.MANUAL_TO_AUTO_FOLIO_LIMIT = rs_tDBInput_1.getInt(275);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 276) {
								row1.RT_MANUAL_TO_AUTO_FOLIO_COUNT = 0;
							} else {
		                          
            row1.RT_MANUAL_TO_AUTO_FOLIO_COUNT = rs_tDBInput_1.getInt(276);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 277) {
								row1.RT_LEVEL_ORIGIN = 0;
							} else {
		                          
            row1.RT_LEVEL_ORIGIN = rs_tDBInput_1.getInt(277);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 278) {
								row1.RT_TOV_ORIGIN = 0;
							} else {
		                          
            row1.RT_TOV_ORIGIN = rs_tDBInput_1.getInt(278);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 279) {
								row1.RT_TEMPERATURE_ORIGIN = 0;
							} else {
		                          
            row1.RT_TEMPERATURE_ORIGIN = rs_tDBInput_1.getInt(279);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 280) {
								row1.RT_DENSITY_ORIGIN = 0;
							} else {
		                          
            row1.RT_DENSITY_ORIGIN = rs_tDBInput_1.getInt(280);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 281) {
								row1.RT_NSV_ORIGIN = 0;
							} else {
		                          
            row1.RT_NSV_ORIGIN = rs_tDBInput_1.getInt(281);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 282) {
								row1.RT_VAPOR_TEMPERATURE_ORIGIN = 0;
							} else {
		                          
            row1.RT_VAPOR_TEMPERATURE_ORIGIN = rs_tDBInput_1.getInt(282);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 283) {
								row1.RT_PRESSURE_ORIGIN = 0;
							} else {
		                          
            row1.RT_PRESSURE_ORIGIN = rs_tDBInput_1.getInt(283);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 284) {
								row1.RT_FREE_WATER_LEVEL_ORIGIN = 0;
							} else {
		                          
            row1.RT_FREE_WATER_LEVEL_ORIGIN = rs_tDBInput_1.getInt(284);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 285) {
								row1.RT_WATER_QUANTITY_ORIGIN = 0;
							} else {
		                          
            row1.RT_WATER_QUANTITY_ORIGIN = rs_tDBInput_1.getInt(285);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 286) {
								row1.DDE_SNAPSHOT_REQ_DSN = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(286);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(286).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.DDE_SNAPSHOT_REQ_DSN = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.DDE_SNAPSHOT_REQ_DSN = tmpContent_tDBInput_1;
                }
            } else {
                row1.DDE_SNAPSHOT_REQ_DSN = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 287) {
								row1.DDE_SNAPSHOT_REQ_ITEM = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(287);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(287).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.DDE_SNAPSHOT_REQ_ITEM = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.DDE_SNAPSHOT_REQ_ITEM = tmpContent_tDBInput_1;
                }
            } else {
                row1.DDE_SNAPSHOT_REQ_ITEM = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 288) {
								row1.DDE_SNAPSHOT_RSP_DSN = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(288);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(288).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.DDE_SNAPSHOT_RSP_DSN = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.DDE_SNAPSHOT_RSP_DSN = tmpContent_tDBInput_1;
                }
            } else {
                row1.DDE_SNAPSHOT_RSP_DSN = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 289) {
								row1.DDE_SNAPSHOT_RSP_ITEM = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(289);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(289).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.DDE_SNAPSHOT_RSP_ITEM = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.DDE_SNAPSHOT_RSP_ITEM = tmpContent_tDBInput_1;
                }
            } else {
                row1.DDE_SNAPSHOT_RSP_ITEM = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 290) {
								row1.AUTO_PRODUCT_LEVEL_UNIT = 0;
							} else {
		                          
            row1.AUTO_PRODUCT_LEVEL_UNIT = rs_tDBInput_1.getInt(290);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 291) {
								row1.AUTO_FREE_WATER_LEVEL_UNIT = 0;
							} else {
		                          
            row1.AUTO_FREE_WATER_LEVEL_UNIT = rs_tDBInput_1.getInt(291);
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
if(row1.TANK_CODE == null){
	finder_tUniqRow_1.TANK_CODE = null;
}else{
	finder_tUniqRow_1.TANK_CODE = row1.TANK_CODE.toLowerCase();
}
if(row1.NAME == null){
	finder_tUniqRow_1.NAME = null;
}else{
	finder_tUniqRow_1.NAME = row1.NAME.toLowerCase();
}	
finder_tUniqRow_1.hashCodeDirty = true;
if (!keystUniqRow_1.contains(finder_tUniqRow_1)) {
		KeyStruct_tUniqRow_1 new_tUniqRow_1 = new KeyStruct_tUniqRow_1();

		
if(row1.TANK_CODE == null){
	new_tUniqRow_1.TANK_CODE = null;
}else{
	new_tUniqRow_1.TANK_CODE = row1.TANK_CODE.toLowerCase();
}
if(row1.NAME == null){
	new_tUniqRow_1.NAME = null;
}else{
	new_tUniqRow_1.NAME = row1.NAME.toLowerCase();
}
		
		keystUniqRow_1.add(new_tUniqRow_1);if(row2 == null){ 
	
	row2 = new row2Struct();
}row2.TANK_CODE = row1.TANK_CODE;			row2.NAME = row1.NAME;			row2.COMPARTMENT_OWNER_ID = row1.COMPARTMENT_OWNER_ID;			row2.MAJORITY_SHAREHOLDER = row1.MAJORITY_SHAREHOLDER;			row2.COMPARTMENT_CONTAINER_CODE = row1.COMPARTMENT_CONTAINER_CODE;			row2.RT_GROSS_QUANTITY = row1.RT_GROSS_QUANTITY;			row2.COMPARTMENT_CONTAINER_TYPE = row1.COMPARTMENT_CONTAINER_TYPE;			row2.TERMINAL_PRODUCT_NUMBER = row1.TERMINAL_PRODUCT_NUMBER;			row2.COMPARTMENT_NUMBER = row1.COMPARTMENT_NUMBER;			row2.RT_NET_QUANTITY = row1.RT_NET_QUANTITY;			row2.ENABLE = row1.ENABLE;			row2.SCHED_PROD_CHANGE_PRODUCT = row1.SCHED_PROD_CHANGE_PRODUCT;			row2.RVP = row1.RVP;			row2.OXYGEN = row1.OXYGEN;			row2.RT_TEMPERATURE = row1.RT_TEMPERATURE;			row2.RT_DENSITY = row1.RT_DENSITY;			row2.SHELL_CAPACITY = row1.SHELL_CAPACITY;			row2.WORK_CAPACITY = row1.WORK_CAPACITY;			row2.DEPTH = row1.DEPTH;			row2.LOW_LOW_SETPOINT = row1.LOW_LOW_SETPOINT;			row2.LOW_SETPOINT = row1.LOW_SETPOINT;			row2.GENERAL_SETPOINT = row1.GENERAL_SETPOINT;			row2.CUTOFF_SETPOINT = row1.CUTOFF_SETPOINT;			row2.AUTO_ENABLE = row1.AUTO_ENABLE;			row2.HIGH_SETPOINT = row1.HIGH_SETPOINT;			row2.HIGH_HIGH_SETPOINT = row1.HIGH_HIGH_SETPOINT;			row2.DEADBAND = row1.DEADBAND;			row2.AUTO_LEVEL_ENABLE = row1.AUTO_LEVEL_ENABLE;			row2.DDE_LEVEL_DSN = row1.DDE_LEVEL_DSN;			row2.AUTO_DENSITY_ENABLE = row1.AUTO_DENSITY_ENABLE;			row2.AUTO_TEMPERATURE_ENABLE = row1.AUTO_TEMPERATURE_ENABLE;			row2.DDE_LEVEL_ITEM = row1.DDE_LEVEL_ITEM;			row2.AUTO_QUANTITY_ENABLE = row1.AUTO_QUANTITY_ENABLE;			row2.DDE_DENSITY_DSN = row1.DDE_DENSITY_DSN;			row2.ACTIVITY_STATUS = row1.ACTIVITY_STATUS;			row2.DDE_DENSITY_ITEM = row1.DDE_DENSITY_ITEM;			row2.DDE_TEMPERATURE_DSN = row1.DDE_TEMPERATURE_DSN;			row2.RECEIPT_INDICATOR = row1.RECEIPT_INDICATOR;			row2.DDE_TEMPERATURE_ITEM = row1.DDE_TEMPERATURE_ITEM;			row2.LAST_RECEIPT_DATE = row1.LAST_RECEIPT_DATE;			row2.DDE_QUANTITY_DSN = row1.DDE_QUANTITY_DSN;			row2.DDE_QUANTITY_ITEM = row1.DDE_QUANTITY_ITEM;			row2.SEND_TO_HOST_AT_EOD = row1.SEND_TO_HOST_AT_EOD;			row2.MANUAL_LEVEL = row1.MANUAL_LEVEL;			row2.RT_AUTO_LEVEL = row1.RT_AUTO_LEVEL;			row2.EOM_MANUAL_LEVEL = row1.EOM_MANUAL_LEVEL;			row2.RT_EOM_GROSS_QUANTITY = row1.RT_EOM_GROSS_QUANTITY;			row2.RT_AUTO_DENSITY = row1.RT_AUTO_DENSITY;			row2.EOM_MANUAL_TEMPERATURE = row1.EOM_MANUAL_TEMPERATURE;			row2.EOM_MANUAL_DENSITY = row1.EOM_MANUAL_DENSITY;			row2.EOM_MANUAL_BSW_QUANTITY = row1.EOM_MANUAL_BSW_QUANTITY;			row2.EOM_MANUAL_BSW_LEVEL = row1.EOM_MANUAL_BSW_LEVEL;			row2.MANUAL_TEMPERATURE = row1.MANUAL_TEMPERATURE;			row2.RT_EOM_NET_QUANTITY = row1.RT_EOM_NET_QUANTITY;			row2.EOM_MANUAL_COE = row1.EOM_MANUAL_COE;			row2.RT_EOM_BSW_QUANTITY = row1.RT_EOM_BSW_QUANTITY;			row2.MANUAL_DATE = row1.MANUAL_DATE;			row2.BASE_SEDIMENT_WATER_LEVEL = row1.BASE_SEDIMENT_WATER_LEVEL;			row2.MANUAL_DENSITY = row1.MANUAL_DENSITY;			row2.RT_BSW_QUANTITY = row1.RT_BSW_QUANTITY;			row2.MANUAL_SPECIFIC_GRAVITY = row1.MANUAL_SPECIFIC_GRAVITY;			row2.PIPE_FILL = row1.PIPE_FILL;			row2.MANUAL_COEFFICIENT_EXPANSION = row1.MANUAL_COEFFICIENT_EXPANSION;			row2.PROTOCOL_TYPE = row1.PROTOCOL_TYPE;			row2.RT_AUTO_TEMPERATURE = row1.RT_AUTO_TEMPERATURE;			row2.PORT_NAME = row1.PORT_NAME;			row2.RT_AUTO_QUANTITY = row1.RT_AUTO_QUANTITY;			row2.ADDRESS = row1.ADDRESS;			row2.REMARKS = row1.REMARKS;			row2.FAST_SCAN = row1.FAST_SCAN;			row2.RT_LEVEL = row1.RT_LEVEL;			row2.RT_METER_COUNT = row1.RT_METER_COUNT;			row2.RT_GROSS_SNAPSHOT = row1.RT_GROSS_SNAPSHOT;			row2.RT_SNAPSHOT_ACTIVE = row1.RT_SNAPSHOT_ACTIVE;			row2.RT_LEVEL_SNAPSHOT = row1.RT_LEVEL_SNAPSHOT;			row2.RT_NET_SNAPSHOT = row1.RT_NET_SNAPSHOT;			row2.RT_SNAPSHOT_DATE = row1.RT_SNAPSHOT_DATE;			row2.RT_GROSS_SNAPSHOT_DELTA = row1.RT_GROSS_SNAPSHOT_DELTA;			row2.RT_NET_SNAPSHOT_DELTA = row1.RT_NET_SNAPSHOT_DELTA;			row2.RT_EOD_MANUAL_DELTA = row1.RT_EOD_MANUAL_DELTA;			row2.RT_END_LEVEL_SNAPSHOT = row1.RT_END_LEVEL_SNAPSHOT;			row2.RT_EOD_OPENING_PHYSICAL = row1.RT_EOD_OPENING_PHYSICAL;			row2.RT_EOD_BULK_RECEIPTS = row1.RT_EOD_BULK_RECEIPTS;			row2.RT_END_GROSS_SNAPSHOT = row1.RT_END_GROSS_SNAPSHOT;			row2.RT_AVAILABLE_QUANTITY = row1.RT_AVAILABLE_QUANTITY;			row2.RT_END_NET_SNAPSHOT = row1.RT_END_NET_SNAPSHOT;			row2.RT_EOD_BULK_DISPOSALS = row1.RT_EOD_BULK_DISPOSALS;			row2.RT_END_SNAPSHOT_DATE = row1.RT_END_SNAPSHOT_DATE;			row2.RT_EOD_TRANSFERS_IN = row1.RT_EOD_TRANSFERS_IN;			row2.RT_EOD_RACK_RECEIPTS = row1.RT_EOD_RACK_RECEIPTS;			row2.RT_EOD_TRANSFERS_OUT = row1.RT_EOD_TRANSFERS_OUT;			row2.RT_EOD_RACK_DISPOSALS = row1.RT_EOD_RACK_DISPOSALS;			row2.LAST_USER_NAME = row1.LAST_USER_NAME;			row2.LAST_MODIFIED = row1.LAST_MODIFIED;			row2.RT_EOD_BOOK_INVENTORY = row1.RT_EOD_BOOK_INVENTORY;			row2.USER_DLL = row1.USER_DLL;			row2.USER_ROUTINE = row1.USER_ROUTINE;			row2.ROOF_CORRECTION_TYPE = row1.ROOF_CORRECTION_TYPE;			row2.ROOF_TAKE_OFF_LEVEL = row1.ROOF_TAKE_OFF_LEVEL;			row2.ROOF_SUPPORT_LEVEL = row1.ROOF_SUPPORT_LEVEL;			row2.ROOF_REFERENCE_DENSITY = row1.ROOF_REFERENCE_DENSITY;			row2.ROOF_ABOVE_ADJUSTMENT = row1.ROOF_ABOVE_ADJUSTMENT;			row2.RT_EOD_MANUAL_CLOSING_ENABLE = row1.RT_EOD_MANUAL_CLOSING_ENABLE;			row2.ROOF_BELOW_ADJUSTMENT = row1.ROOF_BELOW_ADJUSTMENT;			row2.RT_EOD_MANUAL_LEVEL = row1.RT_EOD_MANUAL_LEVEL;			row2.STRAPPING_INVERTED = row1.STRAPPING_INVERTED;			row2.RT_EOD_MANUAL_GROSS_QUANTITY = row1.RT_EOD_MANUAL_GROSS_QUANTITY;			row2.RT_EOD_MANUAL_NET_QUANTITY = row1.RT_EOD_MANUAL_NET_QUANTITY;			row2.RT_EOD_RACK_FRAC_DISPOSALS = row1.RT_EOD_RACK_FRAC_DISPOSALS;			row2.RT_EOD_RACK_FRAC_RECEIPTS = row1.RT_EOD_RACK_FRAC_RECEIPTS;			row2.DDE_HIGH_ALARM_DSN = row1.DDE_HIGH_ALARM_DSN;			row2.DDE_HIGH_ALARM_ITEM = row1.DDE_HIGH_ALARM_ITEM;			row2.DDE_HIGH_HIGH_ALARM_DSN = row1.DDE_HIGH_HIGH_ALARM_DSN;			row2.DDE_HIGH_HIGH_ALARM_ITEM = row1.DDE_HIGH_HIGH_ALARM_ITEM;			row2.DDE_LOW_ALARM_DSN = row1.DDE_LOW_ALARM_DSN;			row2.DDE_LOW_ALARM_ITEM = row1.DDE_LOW_ALARM_ITEM;			row2.DDE_LOW_LOW_ALARM_DSN = row1.DDE_LOW_LOW_ALARM_DSN;			row2.DDE_LOW_LOW_ALARM_ITEM = row1.DDE_LOW_LOW_ALARM_ITEM;			row2.DDE_CUTOFF_ALARM_DSN = row1.DDE_CUTOFF_ALARM_DSN;			row2.DDE_CUTOFF_ALARM_ITEM = row1.DDE_CUTOFF_ALARM_ITEM;			row2.DDE_STATUS_DSN = row1.DDE_STATUS_DSN;			row2.DDE_STATUS_ITEM = row1.DDE_STATUS_ITEM;			row2.RT_AUTO_PRESSURE = row1.RT_AUTO_PRESSURE;			row2.RT_AUTO_MASS = row1.RT_AUTO_MASS;			row2.MANUAL_PRESSURE = row1.MANUAL_PRESSURE;			row2.MANUAL_MASS = row1.MANUAL_MASS;			row2.RT_PRESSURE = row1.RT_PRESSURE;			row2.RT_MASS = row1.RT_MASS;			row2.AUTO_PRESSURE_ENABLE = row1.AUTO_PRESSURE_ENABLE;			row2.AUTO_MASS_ENABLE = row1.AUTO_MASS_ENABLE;			row2.DOWNLOAD_ENABLE = row1.DOWNLOAD_ENABLE;			row2.DOWNLOAD_LEVEL_ENABLE = row1.DOWNLOAD_LEVEL_ENABLE;			row2.DOWNLOAD_QUANTITY_ENABLE = row1.DOWNLOAD_QUANTITY_ENABLE;			row2.DOWNLOAD_TEMPERATURE_ENABLE = row1.DOWNLOAD_TEMPERATURE_ENABLE;			row2.DOWNLOAD_PRESSURE_ENABLE = row1.DOWNLOAD_PRESSURE_ENABLE;			row2.DOWNLOAD_MASS_ENABLE = row1.DOWNLOAD_MASS_ENABLE;			row2.RT_USER_QUEUE_ENABLE = row1.RT_USER_QUEUE_ENABLE;			row2.RT_USER_CONTEXT_VALUE = row1.RT_USER_CONTEXT_VALUE;			row2.RT_FRAC_GROSS_SNAPSHOT_DELTA = row1.RT_FRAC_GROSS_SNAPSHOT_DELTA;			row2.RT_FRAC_NET_SNAPSHOT_DELTA = row1.RT_FRAC_NET_SNAPSHOT_DELTA;			row2.RT_FRAC_EOD_MANUAL_DELTA = row1.RT_FRAC_EOD_MANUAL_DELTA;			row2.RT_TEMPERATURE_SNAPSHOT = row1.RT_TEMPERATURE_SNAPSHOT;			row2.RT_DENSITY_SNAPSHOT = row1.RT_DENSITY_SNAPSHOT;			row2.RT_END_TEMPERATURE_SNAPSHOT = row1.RT_END_TEMPERATURE_SNAPSHOT;			row2.RT_END_DENSITY_SNAPSHOT = row1.RT_END_DENSITY_SNAPSHOT;			row2.RT_FRAC_EOD_TRANSFERS_IN = row1.RT_FRAC_EOD_TRANSFERS_IN;			row2.RT_FRAC_EOD_TRANSFERS_OUT = row1.RT_FRAC_EOD_TRANSFERS_OUT;			row2.MANUAL_QUANTITY_ENABLE = row1.MANUAL_QUANTITY_ENABLE;			row2.MANUAL_BSW_QUANTITY = row1.MANUAL_BSW_QUANTITY;			row2.EOM_MANUAL_QUANTITY = row1.EOM_MANUAL_QUANTITY;			row2.MANUAL_GROSS_QUANTITY = row1.MANUAL_GROSS_QUANTITY;			row2.MANUAL_LOW_LOW_QUANTITY = row1.MANUAL_LOW_LOW_QUANTITY;			row2.MANUAL_LOW_QUANTITY = row1.MANUAL_LOW_QUANTITY;			row2.MANUAL_GENERAL_QUANTITY = row1.MANUAL_GENERAL_QUANTITY;			row2.MANUAL_CUTOFF_QUANTITY = row1.MANUAL_CUTOFF_QUANTITY;			row2.MANUAL_HIGH_QUANTITY = row1.MANUAL_HIGH_QUANTITY;			row2.MANUAL_HIGH_HIGH_QUANTITY = row1.MANUAL_HIGH_HIGH_QUANTITY;			row2.MANUAL_OBSERVED_DENSITY = row1.MANUAL_OBSERVED_DENSITY;			row2.RT_OBSERVED_DENSITY = row1.RT_OBSERVED_DENSITY;			row2.RT_OBS_DENSITY_SNAPSHOT = row1.RT_OBS_DENSITY_SNAPSHOT;			row2.RT_END_OBS_DENSITY_SNAPSHOT = row1.RT_END_OBS_DENSITY_SNAPSHOT;			row2.AUTO_BSW_LEVEL_ENABLE = row1.AUTO_BSW_LEVEL_ENABLE;			row2.AUTO_BSW_QUANTITY_ENABLE = row1.AUTO_BSW_QUANTITY_ENABLE;			row2.RT_AUTO_BSW_LEVEL = row1.RT_AUTO_BSW_LEVEL;			row2.RT_AUTO_BSW_QUANTITY = row1.RT_AUTO_BSW_QUANTITY;			row2.RT_BSW_LEVEL = row1.RT_BSW_LEVEL;			row2.DDE_BSW_LEVEL_DSN = row1.DDE_BSW_LEVEL_DSN;			row2.DDE_BSW_LEVEL_ITEM = row1.DDE_BSW_LEVEL_ITEM;			row2.DDE_BSW_QUANTITY_DSN = row1.DDE_BSW_QUANTITY_DSN;			row2.DDE_BSW_QUANTITY_ITEM = row1.DDE_BSW_QUANTITY_ITEM;			row2.DOWNLOAD_DENSITY_ENABLE = row1.DOWNLOAD_DENSITY_ENABLE;			row2.RT_EOD_ADD_MANUAL_DELTA = row1.RT_EOD_ADD_MANUAL_DELTA;			row2.RT_EOD_ADD_BULK_RECEIPTS = row1.RT_EOD_ADD_BULK_RECEIPTS;			row2.RT_EOD_ADD_RACK_RECEIPTS = row1.RT_EOD_ADD_RACK_RECEIPTS;			row2.RT_EOD_ADD_TRANSFERS_IN = row1.RT_EOD_ADD_TRANSFERS_IN;			row2.RT_EOD_ADD_BULK_DISPOSALS = row1.RT_EOD_ADD_BULK_DISPOSALS;			row2.RT_EOD_ADD_RACK_DISPOSALS = row1.RT_EOD_ADD_RACK_DISPOSALS;			row2.RT_EOD_ADD_TRANSFERS_OUT = row1.RT_EOD_ADD_TRANSFERS_OUT;			row2.RT_EOD_ADD_BOOK_INVENTORY = row1.RT_EOD_ADD_BOOK_INVENTORY;			row2.RT_IN_SERVICE = row1.RT_IN_SERVICE;			row2.VIRTUAL_TANK = row1.VIRTUAL_TANK;			row2.DDE_IN_SERVICE_ITEM = row1.DDE_IN_SERVICE_ITEM;			row2.TANK_GROUP = row1.TANK_GROUP;			row2.DDE_IN_SERVICE_DSN = row1.DDE_IN_SERVICE_DSN;			row2.RT_CUTOFF_QUANTITY = row1.RT_CUTOFF_QUANTITY;			row2.AUTO_NET_QUANTITY_ENABLE = row1.AUTO_NET_QUANTITY_ENABLE;			row2.DDE_NET_QUANTITY_ITEM = row1.DDE_NET_QUANTITY_ITEM;			row2.RT_AUTO_NET_QUANTITY = row1.RT_AUTO_NET_QUANTITY;			row2.DDE_NET_QUANTITY_DSN = row1.DDE_NET_QUANTITY_DSN;			row2.MANUAL_NET_QUANTITY_ENABLE = row1.MANUAL_NET_QUANTITY_ENABLE;			row2.MANUAL_NET_QUANTITY = row1.MANUAL_NET_QUANTITY;			row2.HIGH_BSW_SETPOINT = row1.HIGH_BSW_SETPOINT;			row2.HIGH_BSW_QUANTITY = row1.HIGH_BSW_QUANTITY;			row2.DDE_BSW_HIGH_ALARM_DSN = row1.DDE_BSW_HIGH_ALARM_DSN;			row2.DDE_BSW_HIGH_ALARM_ITEM = row1.DDE_BSW_HIGH_ALARM_ITEM;			row2.RT_EOD_BULK_FRAC_DISPOSALS = row1.RT_EOD_BULK_FRAC_DISPOSALS;			row2.RT_EOD_BULK_FRAC_RECEIPTS = row1.RT_EOD_BULK_FRAC_RECEIPTS;			row2.RT_EOD_OPEN_BSW_LEVEL = row1.RT_EOD_OPEN_BSW_LEVEL;			row2.RT_EOD_OPEN_DENSITY = row1.RT_EOD_OPEN_DENSITY;			row2.RT_EOD_OPEN_TEMPERATURE = row1.RT_EOD_OPEN_TEMPERATURE;			row2.RT_EOD_OPEN_BSW_QUANTITY = row1.RT_EOD_OPEN_BSW_QUANTITY;			row2.RT_EOD_OPEN_LEVEL = row1.RT_EOD_OPEN_LEVEL;			row2.RT_EOD_OPEN_OBSERVED_DENSITY = row1.RT_EOD_OPEN_OBSERVED_DENSITY;			row2.RT_EOD_OPEN_PHYS_GROSS_QTY = row1.RT_EOD_OPEN_PHYS_GROSS_QTY;			row2.PREV_EOD_LEVEL = row1.PREV_EOD_LEVEL;			row2.PREV_EOD_GROSS_QUANTITY = row1.PREV_EOD_GROSS_QUANTITY;			row2.PREV_EOD_TEMPERATURE = row1.PREV_EOD_TEMPERATURE;			row2.PREV_EOD_DENSITY = row1.PREV_EOD_DENSITY;			row2.PREV_EOD_BSW_QUANTITY = row1.PREV_EOD_BSW_QUANTITY;			row2.PREV_EOD_BSW_LEVEL = row1.PREV_EOD_BSW_LEVEL;			row2.RT_PREV_EOD_NET_QUANTITY = row1.RT_PREV_EOD_NET_QUANTITY;			row2.PREV_EOD_COE = row1.PREV_EOD_COE;			row2.RT_PREV_EOD_BSW_QUANTITY = row1.RT_PREV_EOD_BSW_QUANTITY;			row2.PREV_EOD_QUANTITY = row1.PREV_EOD_QUANTITY;			row2.OPENING_COE = row1.OPENING_COE;			row2.RT_TOV = row1.RT_TOV;			row2.RT_GOV = row1.RT_GOV;			row2.RT_GSV = row1.RT_GSV;			row2.RT_TCV = row1.RT_TCV;			row2.RT_SHELL_CORRECTION_FACTOR = row1.RT_SHELL_CORRECTION_FACTOR;			row2.RT_FLOATING_ROOF_ADJUSTMENT = row1.RT_FLOATING_ROOF_ADJUSTMENT;			row2.RT_CTL = row1.RT_CTL;			row2.SUSPENDED_BSW_PERCENT = row1.SUSPENDED_BSW_PERCENT;			row2.MANUAL_STRAP_TYPE = row1.MANUAL_STRAP_TYPE;			row2.ROOF_TAKE_OFF_STRAP_TYPE = row1.ROOF_TAKE_OFF_STRAP_TYPE;			row2.ROOF_SUPPORT_STRAP_TYPE = row1.ROOF_SUPPORT_STRAP_TYPE;			row2.HIGH_BSW_STRAP_TYPE = row1.HIGH_BSW_STRAP_TYPE;			row2.BASE_SEDIMENT_WATER_STRAP_TYPE = row1.BASE_SEDIMENT_WATER_STRAP_TYPE;			row2.GAUGER_INITIALS = row1.GAUGER_INITIALS;			row2.GAUGE_TIMESTAMP = row1.GAUGE_TIMESTAMP;			row2.LEVEL_UNITS = row1.LEVEL_UNITS;			row2.SHELL_BASE_TEMPERATURE = row1.SHELL_BASE_TEMPERATURE;			row2.SHELL_MATERIAL_TYPE = row1.SHELL_MATERIAL_TYPE;			row2.MANUAL_AMBIENT_TEMPERATURE = row1.MANUAL_AMBIENT_TEMPERATURE;			row2.INSULATED = row1.INSULATED;			row2.LINE_SEGMENT_NSV = row1.LINE_SEGMENT_NSV;			row2.RT_CALCULATION_POINT = row1.RT_CALCULATION_POINT;			row2.ROOF_TAKE_OFF_TOV = row1.ROOF_TAKE_OFF_TOV;			row2.RT_NSV = row1.RT_NSV;			row2.RT_GSW = row1.RT_GSW;			row2.RT_NSW = row1.RT_NSW;			row2.RT_WCF = row1.RT_WCF;			row2.LINE_SEGMENT_NSW = row1.LINE_SEGMENT_NSW;			row2.ROOF_WEIGHT = row1.ROOF_WEIGHT;			row2.VOL_IN_ALARM = row1.VOL_IN_ALARM;			row2.INACTIVITY_QUANTITY = row1.INACTIVITY_QUANTITY;			row2.INACTIVITY_ALARM_STATE = row1.INACTIVITY_ALARM_STATE;			row2.USER_LEVEL = row1.USER_LEVEL;			row2.SCHED_PROD_CHANGE_DATE_TIME = row1.SCHED_PROD_CHANGE_DATE_TIME;			row2.SCHED_PROD_CHANGE_TIMEOUT = row1.SCHED_PROD_CHANGE_TIMEOUT;			row2.SCHED_PROD_CHANGE_EMAIL = row1.SCHED_PROD_CHANGE_EMAIL;			row2.SETPOINT_QUANTITY_ENABLE = row1.SETPOINT_QUANTITY_ENABLE;			row2.MANUAL_MEASURED_DENSITY = row1.MANUAL_MEASURED_DENSITY;			row2.WEIGHT_IN_AIR = row1.WEIGHT_IN_AIR;			row2.TOPS_MONITORING_ACTIVE = row1.TOPS_MONITORING_ACTIVE;			row2.SHAPE = row1.SHAPE;			row2.ACTUAL_FLOW_RATE_PERIOD = row1.ACTUAL_FLOW_RATE_PERIOD;			row2.CALCULATED_FLOW_RATE_PERIOD = row1.CALCULATED_FLOW_RATE_PERIOD;			row2.FLOW_RATE_CLAMPING_PERIOD = row1.FLOW_RATE_CLAMPING_PERIOD;			row2.RT_CLAMPING_PERIOD_START = row1.RT_CLAMPING_PERIOD_START;			row2.VAPOR_CORRECTION_METHOD = row1.VAPOR_CORRECTION_METHOD;			row2.VAPOR_TEMPERATURE = row1.VAPOR_TEMPERATURE;			row2.VAPOR_LIQUID_VOLUME_RATIO = row1.VAPOR_LIQUID_VOLUME_RATIO;			row2.TARGET_LEVEL = row1.TARGET_LEVEL;			row2.ORIGINAL_STARTING_LEVEL = row1.ORIGINAL_STARTING_LEVEL;			row2.TIME_TO_TARGET_LEVEL = row1.TIME_TO_TARGET_LEVEL;			row2.AUTO_VAPOR_TEMPERATURE_ENABLE = row1.AUTO_VAPOR_TEMPERATURE_ENABLE;			row2.DDE_PRESSURE_DSN = row1.DDE_PRESSURE_DSN;			row2.DDE_PRESSURE_ITEM = row1.DDE_PRESSURE_ITEM;			row2.DDE_VAPOR_TEMPERATURE_DSN = row1.DDE_VAPOR_TEMPERATURE_DSN;			row2.DDE_VAPOR_TEMPERATURE_ITEM = row1.DDE_VAPOR_TEMPERATURE_ITEM;			row2.RT_AUTO_VAPOR_TEMPERATURE = row1.RT_AUTO_VAPOR_TEMPERATURE;			row2.RT_VAPOR_TEMPERATURE = row1.RT_VAPOR_TEMPERATURE;			row2.INVENTORY_ENABLE = row1.INVENTORY_ENABLE;			row2.MANUAL_TO_AUTO_FOLIO_LIMIT = row1.MANUAL_TO_AUTO_FOLIO_LIMIT;			row2.RT_MANUAL_TO_AUTO_FOLIO_COUNT = row1.RT_MANUAL_TO_AUTO_FOLIO_COUNT;			row2.RT_LEVEL_ORIGIN = row1.RT_LEVEL_ORIGIN;			row2.RT_TOV_ORIGIN = row1.RT_TOV_ORIGIN;			row2.RT_TEMPERATURE_ORIGIN = row1.RT_TEMPERATURE_ORIGIN;			row2.RT_DENSITY_ORIGIN = row1.RT_DENSITY_ORIGIN;			row2.RT_NSV_ORIGIN = row1.RT_NSV_ORIGIN;			row2.RT_VAPOR_TEMPERATURE_ORIGIN = row1.RT_VAPOR_TEMPERATURE_ORIGIN;			row2.RT_PRESSURE_ORIGIN = row1.RT_PRESSURE_ORIGIN;			row2.RT_FREE_WATER_LEVEL_ORIGIN = row1.RT_FREE_WATER_LEVEL_ORIGIN;			row2.RT_WATER_QUANTITY_ORIGIN = row1.RT_WATER_QUANTITY_ORIGIN;			row2.DDE_SNAPSHOT_REQ_DSN = row1.DDE_SNAPSHOT_REQ_DSN;			row2.DDE_SNAPSHOT_REQ_ITEM = row1.DDE_SNAPSHOT_REQ_ITEM;			row2.DDE_SNAPSHOT_RSP_DSN = row1.DDE_SNAPSHOT_RSP_DSN;			row2.DDE_SNAPSHOT_RSP_ITEM = row1.DDE_SNAPSHOT_RSP_ITEM;			row2.AUTO_PRODUCT_LEVEL_UNIT = row1.AUTO_PRODUCT_LEVEL_UNIT;			row2.AUTO_FREE_WATER_LEVEL_UNIT = row1.AUTO_FREE_WATER_LEVEL_UNIT;					
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
								
                        		    		    row3HashKey.TANK_CODE = row2.TANK_CODE;
                        		    		
                        		    		    row3HashKey.NAME = row2.NAME;
                        		    		

								
		                        	row3HashKey.hashCodeDirty = true;
                        		
	  					
	  							
			  					
			  					
	  					
		  							tHash_Lookup_row3.lookup( row3HashKey );

	  							

	  							

 								
		  				
	  								
						
									
  									  		
 								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_row3 != null && tHash_Lookup_row3.getCount(row3HashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row3' and it contains more one result from keys :  row3.TANK_CODE = '" + row3HashKey.TANK_CODE + "', row3.NAME = '" + row3HashKey.NAME + "'");
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
Var.PK_TANK = Numeric.sequence("s6",1,1) ;// ###############################
        // ###############################
        // # Output tables

out1 = null;

boolean rejected_tMap_1 = true;
// ###### START REJECTS ##### 

// # Output reject table : 'out1'
// # Filter conditions 
if( rejected_tMap_1 ) {
out1_tmp.PK_TANK = Var.PK_TANK ;
out1_tmp.TANK_CODE = row2.TANK_CODE ;
out1_tmp.NAME = row2.NAME ;
out1_tmp.RT_GROSS_QUANTITY = row2.RT_GROSS_QUANTITY ;
out1_tmp.TERMINAL_PRODUCT_NUMBER = row2.TERMINAL_PRODUCT_NUMBER ;
out1_tmp.RT_NET_QUANTITY = row2.RT_NET_QUANTITY ;
out1_tmp.RT_TEMPERATURE = row2.RT_TEMPERATURE ;
out1_tmp.RT_DENSITY = row2.RT_DENSITY ;
out1_tmp.SHELL_CAPACITY = row2.SHELL_CAPACITY ;
out1_tmp.WORK_CAPACITY = row2.WORK_CAPACITY ;
out1_tmp.DEPTH = row2.DEPTH ;
out1_tmp.AUTO_ENABLE = row2.AUTO_ENABLE ;
out1_tmp.AUTO_LEVEL_ENABLE = row2.AUTO_LEVEL_ENABLE ;
out1_tmp.AUTO_TEMPERATURE_ENABLE = row2.AUTO_TEMPERATURE_ENABLE ;
out1_tmp.DDE_LEVEL_ITEM = row2.DDE_LEVEL_ITEM ;
out1_tmp.MANUAL_LEVEL = row2.MANUAL_LEVEL ;
out1_tmp.RT_AUTO_LEVEL = row2.RT_AUTO_LEVEL ;
out1_tmp.MANUAL_TEMPERATURE = row2.MANUAL_TEMPERATURE ;
out1_tmp.MANUAL_DENSITY = row2.MANUAL_DENSITY ;
out1_tmp.PROTOCOL_TYPE = row2.PROTOCOL_TYPE ;
out1_tmp.RT_AUTO_TEMPERATURE = row2.RT_AUTO_TEMPERATURE ;
out1_tmp.PORT_NAME = row2.PORT_NAME ;
out1_tmp.RT_LEVEL = row2.RT_LEVEL ;
out1_tmp.RT_EOD_OPENING_PHYSICAL = row2.RT_EOD_OPENING_PHYSICAL ;
out1_tmp.RT_AVAILABLE_QUANTITY = row2.RT_AVAILABLE_QUANTITY ;
out1_tmp.LAST_USER_NAME = row2.LAST_USER_NAME ;
out1_tmp.LAST_MODIFIED = row2.LAST_MODIFIED ;
out1_tmp.RT_EOD_BOOK_INVENTORY = row2.RT_EOD_BOOK_INVENTORY ;
out1_tmp.USER_DLL = row2.USER_DLL ;
out1_tmp.USER_ROUTINE = row2.USER_ROUTINE ;
out1_tmp.MANUAL_GROSS_QUANTITY = row2.MANUAL_GROSS_QUANTITY ;
out1_tmp.MANUAL_OBSERVED_DENSITY = row2.MANUAL_OBSERVED_DENSITY ;
out1_tmp.RT_OBSERVED_DENSITY = row2.RT_OBSERVED_DENSITY ;
out1_tmp.AUTO_BSW_LEVEL_ENABLE = row2.AUTO_BSW_LEVEL_ENABLE ;
out1_tmp.DDE_BSW_LEVEL_ITEM = row2.DDE_BSW_LEVEL_ITEM ;
out1_tmp.RT_EOD_OPEN_DENSITY = row2.RT_EOD_OPEN_DENSITY ;
out1_tmp.RT_EOD_OPEN_TEMPERATURE = row2.RT_EOD_OPEN_TEMPERATURE ;
out1_tmp.RT_EOD_OPEN_LEVEL = row2.RT_EOD_OPEN_LEVEL ;
out1_tmp.RT_EOD_OPEN_OBSERVED_DENSITY = row2.RT_EOD_OPEN_OBSERVED_DENSITY ;
out1_tmp.RT_EOD_OPEN_PHYS_GROSS_QTY = row2.RT_EOD_OPEN_PHYS_GROSS_QTY  ;
out1_tmp.RT_GOV = row2.RT_GOV ;
out1_tmp.RT_GSV = row2.RT_GSV ;
out1_tmp.RT_TCV = row2.RT_TCV ;
out1_tmp.RT_CTL = row2.RT_CTL ;
out1_tmp.MANUAL_STRAP_TYPE = row2.MANUAL_STRAP_TYPE ;
out1_tmp.RT_CALCULATION_POINT = row2.RT_CALCULATION_POINT ;
out1_tmp.RT_NSV = row2.RT_NSV ;
out1_tmp.RT_GSW = row2.RT_GSW ;
out1_tmp.RT_NSW = row2.RT_NSW ;
out1_tmp.RT_WCF = row2.RT_WCF ;
out1_tmp.WEIGHT_IN_AIR = row2.WEIGHT_IN_AIR ;
out1_tmp.SHAPE = row2.SHAPE ;
out1_tmp.RT_LEVEL_ORIGIN = row2.RT_LEVEL_ORIGIN ;
out1_tmp.RT_TOV_ORIGIN = row2.RT_TOV_ORIGIN ;
out1_tmp.RT_TEMPERATURE_ORIGIN = row2.RT_TEMPERATURE_ORIGIN ;
out1_tmp.RT_FREE_WATER_LEVEL_ORIGIN = row2.RT_FREE_WATER_LEVEL_ORIGIN ;
out1_tmp.RT_WATER_QUANTITY_ORIGIN = row2.RT_WATER_QUANTITY_ORIGIN ;
out1_tmp.RT_TOV = row2.RT_TOV ;
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


                    if(out1.PK_TANK == null) {
pstmt_tDBOutput_1.setNull(1, java.sql.Types.INTEGER);
} else {pstmt_tDBOutput_1.setInt(1, out1.PK_TANK);
}

            int checkCount_tDBOutput_1 = -1;
            try (java.sql.ResultSet rs_tDBOutput_1 = pstmt_tDBOutput_1.executeQuery()) {
                while(rs_tDBOutput_1.next()) {
                    checkCount_tDBOutput_1 = rs_tDBOutput_1.getInt(1);
                }
            }
            if(checkCount_tDBOutput_1 > 0) {
                        if(out1.TANK_CODE == null) {
pstmtUpdate_tDBOutput_1.setNull(1, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(1, out1.TANK_CODE);
}

                        if(out1.NAME == null) {
pstmtUpdate_tDBOutput_1.setNull(2, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(2, out1.NAME);
}

                        pstmtUpdate_tDBOutput_1.setInt(3, out1.RT_GROSS_QUANTITY);

                        pstmtUpdate_tDBOutput_1.setInt(4, out1.TERMINAL_PRODUCT_NUMBER);

                        pstmtUpdate_tDBOutput_1.setInt(5, out1.RT_NET_QUANTITY);

                        pstmtUpdate_tDBOutput_1.setDouble(6, out1.RT_TEMPERATURE);

                        pstmtUpdate_tDBOutput_1.setDouble(7, out1.RT_DENSITY);

                        pstmtUpdate_tDBOutput_1.setInt(8, out1.SHELL_CAPACITY);

                        pstmtUpdate_tDBOutput_1.setInt(9, out1.WORK_CAPACITY);

                        if(out1.DEPTH == null) {
pstmtUpdate_tDBOutput_1.setNull(10, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(10, out1.DEPTH);
}

                        pstmtUpdate_tDBOutput_1.setInt(11, out1.AUTO_ENABLE);

                        pstmtUpdate_tDBOutput_1.setInt(12, out1.AUTO_LEVEL_ENABLE);

                        pstmtUpdate_tDBOutput_1.setInt(13, out1.AUTO_TEMPERATURE_ENABLE);

                        if(out1.DDE_LEVEL_ITEM == null) {
pstmtUpdate_tDBOutput_1.setNull(14, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(14, out1.DDE_LEVEL_ITEM);
}

                        if(out1.MANUAL_LEVEL == null) {
pstmtUpdate_tDBOutput_1.setNull(15, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(15, out1.MANUAL_LEVEL);
}

                        if(out1.RT_AUTO_LEVEL == null) {
pstmtUpdate_tDBOutput_1.setNull(16, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(16, out1.RT_AUTO_LEVEL);
}

                        pstmtUpdate_tDBOutput_1.setDouble(17, out1.MANUAL_TEMPERATURE);

                        pstmtUpdate_tDBOutput_1.setDouble(18, out1.MANUAL_DENSITY);

                        pstmtUpdate_tDBOutput_1.setInt(19, out1.PROTOCOL_TYPE);

                        pstmtUpdate_tDBOutput_1.setDouble(20, out1.RT_AUTO_TEMPERATURE);

                        if(out1.PORT_NAME == null) {
pstmtUpdate_tDBOutput_1.setNull(21, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(21, out1.PORT_NAME);
}

                        if(out1.RT_LEVEL == null) {
pstmtUpdate_tDBOutput_1.setNull(22, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(22, out1.RT_LEVEL);
}

                        pstmtUpdate_tDBOutput_1.setInt(23, out1.RT_EOD_OPENING_PHYSICAL);

                        pstmtUpdate_tDBOutput_1.setInt(24, out1.RT_AVAILABLE_QUANTITY);

                        if(out1.LAST_USER_NAME == null) {
pstmtUpdate_tDBOutput_1.setNull(25, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(25, out1.LAST_USER_NAME);
}

                        if(out1.LAST_MODIFIED != null) {
pstmtUpdate_tDBOutput_1.setTimestamp(26, new java.sql.Timestamp(out1.LAST_MODIFIED.getTime()));
} else {
pstmtUpdate_tDBOutput_1.setNull(26, java.sql.Types.TIMESTAMP);
}

                        pstmtUpdate_tDBOutput_1.setInt(27, out1.RT_EOD_BOOK_INVENTORY);

                        if(out1.USER_DLL == null) {
pstmtUpdate_tDBOutput_1.setNull(28, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(28, out1.USER_DLL);
}

                        if(out1.USER_ROUTINE == null) {
pstmtUpdate_tDBOutput_1.setNull(29, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(29, out1.USER_ROUTINE);
}

                        pstmtUpdate_tDBOutput_1.setInt(30, out1.MANUAL_GROSS_QUANTITY);

                        pstmtUpdate_tDBOutput_1.setDouble(31, out1.MANUAL_OBSERVED_DENSITY);

                        pstmtUpdate_tDBOutput_1.setDouble(32, out1.RT_OBSERVED_DENSITY);

                        pstmtUpdate_tDBOutput_1.setInt(33, out1.AUTO_BSW_LEVEL_ENABLE);

                        if(out1.DDE_BSW_LEVEL_ITEM == null) {
pstmtUpdate_tDBOutput_1.setNull(34, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(34, out1.DDE_BSW_LEVEL_ITEM);
}

                        pstmtUpdate_tDBOutput_1.setDouble(35, out1.RT_EOD_OPEN_DENSITY);

                        pstmtUpdate_tDBOutput_1.setDouble(36, out1.RT_EOD_OPEN_TEMPERATURE);

                        if(out1.RT_EOD_OPEN_LEVEL == null) {
pstmtUpdate_tDBOutput_1.setNull(37, java.sql.Types.VARCHAR);
} else {pstmtUpdate_tDBOutput_1.setString(37, out1.RT_EOD_OPEN_LEVEL);
}

                        pstmtUpdate_tDBOutput_1.setDouble(38, out1.RT_EOD_OPEN_OBSERVED_DENSITY);

                        pstmtUpdate_tDBOutput_1.setInt(39, out1.RT_EOD_OPEN_PHYS_GROSS_QTY);

                        pstmtUpdate_tDBOutput_1.setInt(40, out1.RT_GOV);

                        pstmtUpdate_tDBOutput_1.setInt(41, out1.RT_GSV);

                        pstmtUpdate_tDBOutput_1.setInt(42, out1.RT_TCV);

                        pstmtUpdate_tDBOutput_1.setDouble(43, out1.RT_CTL);

                        pstmtUpdate_tDBOutput_1.setInt(44, out1.MANUAL_STRAP_TYPE);

                        pstmtUpdate_tDBOutput_1.setInt(45, out1.RT_CALCULATION_POINT);

                        pstmtUpdate_tDBOutput_1.setInt(46, out1.RT_NSV);

                        pstmtUpdate_tDBOutput_1.setInt(47, out1.RT_GSW);

                        pstmtUpdate_tDBOutput_1.setInt(48, out1.RT_NSW);

                        pstmtUpdate_tDBOutput_1.setDouble(49, out1.RT_WCF);

                        pstmtUpdate_tDBOutput_1.setInt(50, out1.WEIGHT_IN_AIR);

                        pstmtUpdate_tDBOutput_1.setInt(51, out1.SHAPE);

                        pstmtUpdate_tDBOutput_1.setInt(52, out1.RT_LEVEL_ORIGIN);

                        pstmtUpdate_tDBOutput_1.setInt(53, out1.RT_TOV_ORIGIN);

                        pstmtUpdate_tDBOutput_1.setInt(54, out1.RT_TEMPERATURE_ORIGIN);

                        pstmtUpdate_tDBOutput_1.setInt(55, out1.RT_FREE_WATER_LEVEL_ORIGIN);

                        pstmtUpdate_tDBOutput_1.setInt(56, out1.RT_WATER_QUANTITY_ORIGIN);

                        pstmtUpdate_tDBOutput_1.setInt(57, out1.RT_TOV);


	                    

                        if(out1.PK_TANK == null) {
pstmtUpdate_tDBOutput_1.setNull(58 + count_tDBOutput_1, java.sql.Types.INTEGER);
} else {pstmtUpdate_tDBOutput_1.setInt(58 + count_tDBOutput_1, out1.PK_TANK);
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
                        if(out1.PK_TANK == null) {
pstmtInsert_tDBOutput_1.setNull(1, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_1.setInt(1, out1.PK_TANK);
}

                        if(out1.TANK_CODE == null) {
pstmtInsert_tDBOutput_1.setNull(2, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(2, out1.TANK_CODE);
}

                        if(out1.NAME == null) {
pstmtInsert_tDBOutput_1.setNull(3, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(3, out1.NAME);
}

                        pstmtInsert_tDBOutput_1.setInt(4, out1.RT_GROSS_QUANTITY);

                        pstmtInsert_tDBOutput_1.setInt(5, out1.TERMINAL_PRODUCT_NUMBER);

                        pstmtInsert_tDBOutput_1.setInt(6, out1.RT_NET_QUANTITY);

                        pstmtInsert_tDBOutput_1.setDouble(7, out1.RT_TEMPERATURE);

                        pstmtInsert_tDBOutput_1.setDouble(8, out1.RT_DENSITY);

                        pstmtInsert_tDBOutput_1.setInt(9, out1.SHELL_CAPACITY);

                        pstmtInsert_tDBOutput_1.setInt(10, out1.WORK_CAPACITY);

                        if(out1.DEPTH == null) {
pstmtInsert_tDBOutput_1.setNull(11, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(11, out1.DEPTH);
}

                        pstmtInsert_tDBOutput_1.setInt(12, out1.AUTO_ENABLE);

                        pstmtInsert_tDBOutput_1.setInt(13, out1.AUTO_LEVEL_ENABLE);

                        pstmtInsert_tDBOutput_1.setInt(14, out1.AUTO_TEMPERATURE_ENABLE);

                        if(out1.DDE_LEVEL_ITEM == null) {
pstmtInsert_tDBOutput_1.setNull(15, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(15, out1.DDE_LEVEL_ITEM);
}

                        if(out1.MANUAL_LEVEL == null) {
pstmtInsert_tDBOutput_1.setNull(16, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(16, out1.MANUAL_LEVEL);
}

                        if(out1.RT_AUTO_LEVEL == null) {
pstmtInsert_tDBOutput_1.setNull(17, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(17, out1.RT_AUTO_LEVEL);
}

                        pstmtInsert_tDBOutput_1.setDouble(18, out1.MANUAL_TEMPERATURE);

                        pstmtInsert_tDBOutput_1.setDouble(19, out1.MANUAL_DENSITY);

                        pstmtInsert_tDBOutput_1.setInt(20, out1.PROTOCOL_TYPE);

                        pstmtInsert_tDBOutput_1.setDouble(21, out1.RT_AUTO_TEMPERATURE);

                        if(out1.PORT_NAME == null) {
pstmtInsert_tDBOutput_1.setNull(22, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(22, out1.PORT_NAME);
}

                        if(out1.RT_LEVEL == null) {
pstmtInsert_tDBOutput_1.setNull(23, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(23, out1.RT_LEVEL);
}

                        pstmtInsert_tDBOutput_1.setInt(24, out1.RT_EOD_OPENING_PHYSICAL);

                        pstmtInsert_tDBOutput_1.setInt(25, out1.RT_AVAILABLE_QUANTITY);

                        if(out1.LAST_USER_NAME == null) {
pstmtInsert_tDBOutput_1.setNull(26, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(26, out1.LAST_USER_NAME);
}

                        if(out1.LAST_MODIFIED != null) {
pstmtInsert_tDBOutput_1.setTimestamp(27, new java.sql.Timestamp(out1.LAST_MODIFIED.getTime()));
} else {
pstmtInsert_tDBOutput_1.setNull(27, java.sql.Types.TIMESTAMP);
}

                        pstmtInsert_tDBOutput_1.setInt(28, out1.RT_EOD_BOOK_INVENTORY);

                        if(out1.USER_DLL == null) {
pstmtInsert_tDBOutput_1.setNull(29, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(29, out1.USER_DLL);
}

                        if(out1.USER_ROUTINE == null) {
pstmtInsert_tDBOutput_1.setNull(30, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(30, out1.USER_ROUTINE);
}

                        pstmtInsert_tDBOutput_1.setInt(31, out1.MANUAL_GROSS_QUANTITY);

                        pstmtInsert_tDBOutput_1.setDouble(32, out1.MANUAL_OBSERVED_DENSITY);

                        pstmtInsert_tDBOutput_1.setDouble(33, out1.RT_OBSERVED_DENSITY);

                        pstmtInsert_tDBOutput_1.setInt(34, out1.AUTO_BSW_LEVEL_ENABLE);

                        if(out1.DDE_BSW_LEVEL_ITEM == null) {
pstmtInsert_tDBOutput_1.setNull(35, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(35, out1.DDE_BSW_LEVEL_ITEM);
}

                        pstmtInsert_tDBOutput_1.setDouble(36, out1.RT_EOD_OPEN_DENSITY);

                        pstmtInsert_tDBOutput_1.setDouble(37, out1.RT_EOD_OPEN_TEMPERATURE);

                        if(out1.RT_EOD_OPEN_LEVEL == null) {
pstmtInsert_tDBOutput_1.setNull(38, java.sql.Types.VARCHAR);
} else {pstmtInsert_tDBOutput_1.setString(38, out1.RT_EOD_OPEN_LEVEL);
}

                        pstmtInsert_tDBOutput_1.setDouble(39, out1.RT_EOD_OPEN_OBSERVED_DENSITY);

                        pstmtInsert_tDBOutput_1.setInt(40, out1.RT_EOD_OPEN_PHYS_GROSS_QTY);

                        pstmtInsert_tDBOutput_1.setInt(41, out1.RT_GOV);

                        pstmtInsert_tDBOutput_1.setInt(42, out1.RT_GSV);

                        pstmtInsert_tDBOutput_1.setInt(43, out1.RT_TCV);

                        pstmtInsert_tDBOutput_1.setDouble(44, out1.RT_CTL);

                        pstmtInsert_tDBOutput_1.setInt(45, out1.MANUAL_STRAP_TYPE);

                        pstmtInsert_tDBOutput_1.setInt(46, out1.RT_CALCULATION_POINT);

                        pstmtInsert_tDBOutput_1.setInt(47, out1.RT_NSV);

                        pstmtInsert_tDBOutput_1.setInt(48, out1.RT_GSW);

                        pstmtInsert_tDBOutput_1.setInt(49, out1.RT_NSW);

                        pstmtInsert_tDBOutput_1.setDouble(50, out1.RT_WCF);

                        pstmtInsert_tDBOutput_1.setInt(51, out1.WEIGHT_IN_AIR);

                        pstmtInsert_tDBOutput_1.setInt(52, out1.SHAPE);

                        pstmtInsert_tDBOutput_1.setInt(53, out1.RT_LEVEL_ORIGIN);

                        pstmtInsert_tDBOutput_1.setInt(54, out1.RT_TOV_ORIGIN);

                        pstmtInsert_tDBOutput_1.setInt(55, out1.RT_TEMPERATURE_ORIGIN);

                        pstmtInsert_tDBOutput_1.setInt(56, out1.RT_FREE_WATER_LEVEL_ORIGIN);

                        pstmtInsert_tDBOutput_1.setInt(57, out1.RT_WATER_QUANTITY_ORIGIN);

                        pstmtInsert_tDBOutput_1.setInt(58, out1.RT_TOV);

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
    final static byte[] commonByteArrayLock_PGS_STAGE_DIM_TANK = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_DIM_TANK = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public int PK_TANK;

				public int getPK_TANK () {
					return this.PK_TANK;
				}
				
			    public String TANK_CODE;

				public String getTANK_CODE () {
					return this.TANK_CODE;
				}
				
			    public String NAME;

				public String getNAME () {
					return this.NAME;
				}
				
			    public int RT_GROSS_QUANTITY;

				public int getRT_GROSS_QUANTITY () {
					return this.RT_GROSS_QUANTITY;
				}
				
			    public int TERMINAL_PRODUCT_NUMBER;

				public int getTERMINAL_PRODUCT_NUMBER () {
					return this.TERMINAL_PRODUCT_NUMBER;
				}
				
			    public int RT_NET_QUANTITY;

				public int getRT_NET_QUANTITY () {
					return this.RT_NET_QUANTITY;
				}
				
			    public double RT_TEMPERATURE;

				public double getRT_TEMPERATURE () {
					return this.RT_TEMPERATURE;
				}
				
			    public double RT_DENSITY;

				public double getRT_DENSITY () {
					return this.RT_DENSITY;
				}
				
			    public int SHELL_CAPACITY;

				public int getSHELL_CAPACITY () {
					return this.SHELL_CAPACITY;
				}
				
			    public int WORK_CAPACITY;

				public int getWORK_CAPACITY () {
					return this.WORK_CAPACITY;
				}
				
			    public String DEPTH;

				public String getDEPTH () {
					return this.DEPTH;
				}
				
			    public int AUTO_ENABLE;

				public int getAUTO_ENABLE () {
					return this.AUTO_ENABLE;
				}
				
			    public int AUTO_LEVEL_ENABLE;

				public int getAUTO_LEVEL_ENABLE () {
					return this.AUTO_LEVEL_ENABLE;
				}
				
			    public int AUTO_TEMPERATURE_ENABLE;

				public int getAUTO_TEMPERATURE_ENABLE () {
					return this.AUTO_TEMPERATURE_ENABLE;
				}
				
			    public String DDE_LEVEL_ITEM;

				public String getDDE_LEVEL_ITEM () {
					return this.DDE_LEVEL_ITEM;
				}
				
			    public String MANUAL_LEVEL;

				public String getMANUAL_LEVEL () {
					return this.MANUAL_LEVEL;
				}
				
			    public String RT_AUTO_LEVEL;

				public String getRT_AUTO_LEVEL () {
					return this.RT_AUTO_LEVEL;
				}
				
			    public double MANUAL_TEMPERATURE;

				public double getMANUAL_TEMPERATURE () {
					return this.MANUAL_TEMPERATURE;
				}
				
			    public double MANUAL_DENSITY;

				public double getMANUAL_DENSITY () {
					return this.MANUAL_DENSITY;
				}
				
			    public int PROTOCOL_TYPE;

				public int getPROTOCOL_TYPE () {
					return this.PROTOCOL_TYPE;
				}
				
			    public double RT_AUTO_TEMPERATURE;

				public double getRT_AUTO_TEMPERATURE () {
					return this.RT_AUTO_TEMPERATURE;
				}
				
			    public String PORT_NAME;

				public String getPORT_NAME () {
					return this.PORT_NAME;
				}
				
			    public String RT_LEVEL;

				public String getRT_LEVEL () {
					return this.RT_LEVEL;
				}
				
			    public int RT_EOD_OPENING_PHYSICAL;

				public int getRT_EOD_OPENING_PHYSICAL () {
					return this.RT_EOD_OPENING_PHYSICAL;
				}
				
			    public int RT_AVAILABLE_QUANTITY;

				public int getRT_AVAILABLE_QUANTITY () {
					return this.RT_AVAILABLE_QUANTITY;
				}
				
			    public String LAST_USER_NAME;

				public String getLAST_USER_NAME () {
					return this.LAST_USER_NAME;
				}
				
			    public java.util.Date LAST_MODIFIED;

				public java.util.Date getLAST_MODIFIED () {
					return this.LAST_MODIFIED;
				}
				
			    public int RT_EOD_BOOK_INVENTORY;

				public int getRT_EOD_BOOK_INVENTORY () {
					return this.RT_EOD_BOOK_INVENTORY;
				}
				
			    public String USER_DLL;

				public String getUSER_DLL () {
					return this.USER_DLL;
				}
				
			    public String USER_ROUTINE;

				public String getUSER_ROUTINE () {
					return this.USER_ROUTINE;
				}
				
			    public int MANUAL_GROSS_QUANTITY;

				public int getMANUAL_GROSS_QUANTITY () {
					return this.MANUAL_GROSS_QUANTITY;
				}
				
			    public double MANUAL_OBSERVED_DENSITY;

				public double getMANUAL_OBSERVED_DENSITY () {
					return this.MANUAL_OBSERVED_DENSITY;
				}
				
			    public double RT_OBSERVED_DENSITY;

				public double getRT_OBSERVED_DENSITY () {
					return this.RT_OBSERVED_DENSITY;
				}
				
			    public int AUTO_BSW_LEVEL_ENABLE;

				public int getAUTO_BSW_LEVEL_ENABLE () {
					return this.AUTO_BSW_LEVEL_ENABLE;
				}
				
			    public String DDE_BSW_LEVEL_ITEM;

				public String getDDE_BSW_LEVEL_ITEM () {
					return this.DDE_BSW_LEVEL_ITEM;
				}
				
			    public double RT_EOD_OPEN_DENSITY;

				public double getRT_EOD_OPEN_DENSITY () {
					return this.RT_EOD_OPEN_DENSITY;
				}
				
			    public double RT_EOD_OPEN_TEMPERATURE;

				public double getRT_EOD_OPEN_TEMPERATURE () {
					return this.RT_EOD_OPEN_TEMPERATURE;
				}
				
			    public String RT_EOD_OPEN_LEVEL;

				public String getRT_EOD_OPEN_LEVEL () {
					return this.RT_EOD_OPEN_LEVEL;
				}
				
			    public double RT_EOD_OPEN_OBSERVED_DENSITY;

				public double getRT_EOD_OPEN_OBSERVED_DENSITY () {
					return this.RT_EOD_OPEN_OBSERVED_DENSITY;
				}
				
			    public int RT_EOD_OPEN_PHYS_GROSS_QTY;

				public int getRT_EOD_OPEN_PHYS_GROSS_QTY () {
					return this.RT_EOD_OPEN_PHYS_GROSS_QTY;
				}
				
			    public int RT_GOV;

				public int getRT_GOV () {
					return this.RT_GOV;
				}
				
			    public int RT_GSV;

				public int getRT_GSV () {
					return this.RT_GSV;
				}
				
			    public int RT_TCV;

				public int getRT_TCV () {
					return this.RT_TCV;
				}
				
			    public double RT_CTL;

				public double getRT_CTL () {
					return this.RT_CTL;
				}
				
			    public int MANUAL_STRAP_TYPE;

				public int getMANUAL_STRAP_TYPE () {
					return this.MANUAL_STRAP_TYPE;
				}
				
			    public int RT_CALCULATION_POINT;

				public int getRT_CALCULATION_POINT () {
					return this.RT_CALCULATION_POINT;
				}
				
			    public int RT_NSV;

				public int getRT_NSV () {
					return this.RT_NSV;
				}
				
			    public int RT_GSW;

				public int getRT_GSW () {
					return this.RT_GSW;
				}
				
			    public int RT_NSW;

				public int getRT_NSW () {
					return this.RT_NSW;
				}
				
			    public double RT_WCF;

				public double getRT_WCF () {
					return this.RT_WCF;
				}
				
			    public int WEIGHT_IN_AIR;

				public int getWEIGHT_IN_AIR () {
					return this.WEIGHT_IN_AIR;
				}
				
			    public int SHAPE;

				public int getSHAPE () {
					return this.SHAPE;
				}
				
			    public int RT_LEVEL_ORIGIN;

				public int getRT_LEVEL_ORIGIN () {
					return this.RT_LEVEL_ORIGIN;
				}
				
			    public int RT_TOV_ORIGIN;

				public int getRT_TOV_ORIGIN () {
					return this.RT_TOV_ORIGIN;
				}
				
			    public int RT_TEMPERATURE_ORIGIN;

				public int getRT_TEMPERATURE_ORIGIN () {
					return this.RT_TEMPERATURE_ORIGIN;
				}
				
			    public int RT_FREE_WATER_LEVEL_ORIGIN;

				public int getRT_FREE_WATER_LEVEL_ORIGIN () {
					return this.RT_FREE_WATER_LEVEL_ORIGIN;
				}
				
			    public int RT_WATER_QUANTITY_ORIGIN;

				public int getRT_WATER_QUANTITY_ORIGIN () {
					return this.RT_WATER_QUANTITY_ORIGIN;
				}
				
			    public int RT_TOV;

				public int getRT_TOV () {
					return this.RT_TOV;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.TANK_CODE == null) ? 0 : this.TANK_CODE.hashCode());
					
						result = prime * result + ((this.NAME == null) ? 0 : this.NAME.hashCode());
					
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
		
						if (this.TANK_CODE == null) {
							if (other.TANK_CODE != null)
								return false;
						
						} else if (!this.TANK_CODE.equals(other.TANK_CODE))
						
							return false;
					
						if (this.NAME == null) {
							if (other.NAME != null)
								return false;
						
						} else if (!this.NAME.equals(other.NAME))
						
							return false;
					

		return true;
    }

	public void copyDataTo(row3Struct other) {

		other.PK_TANK = this.PK_TANK;
	            other.TANK_CODE = this.TANK_CODE;
	            other.NAME = this.NAME;
	            other.RT_GROSS_QUANTITY = this.RT_GROSS_QUANTITY;
	            other.TERMINAL_PRODUCT_NUMBER = this.TERMINAL_PRODUCT_NUMBER;
	            other.RT_NET_QUANTITY = this.RT_NET_QUANTITY;
	            other.RT_TEMPERATURE = this.RT_TEMPERATURE;
	            other.RT_DENSITY = this.RT_DENSITY;
	            other.SHELL_CAPACITY = this.SHELL_CAPACITY;
	            other.WORK_CAPACITY = this.WORK_CAPACITY;
	            other.DEPTH = this.DEPTH;
	            other.AUTO_ENABLE = this.AUTO_ENABLE;
	            other.AUTO_LEVEL_ENABLE = this.AUTO_LEVEL_ENABLE;
	            other.AUTO_TEMPERATURE_ENABLE = this.AUTO_TEMPERATURE_ENABLE;
	            other.DDE_LEVEL_ITEM = this.DDE_LEVEL_ITEM;
	            other.MANUAL_LEVEL = this.MANUAL_LEVEL;
	            other.RT_AUTO_LEVEL = this.RT_AUTO_LEVEL;
	            other.MANUAL_TEMPERATURE = this.MANUAL_TEMPERATURE;
	            other.MANUAL_DENSITY = this.MANUAL_DENSITY;
	            other.PROTOCOL_TYPE = this.PROTOCOL_TYPE;
	            other.RT_AUTO_TEMPERATURE = this.RT_AUTO_TEMPERATURE;
	            other.PORT_NAME = this.PORT_NAME;
	            other.RT_LEVEL = this.RT_LEVEL;
	            other.RT_EOD_OPENING_PHYSICAL = this.RT_EOD_OPENING_PHYSICAL;
	            other.RT_AVAILABLE_QUANTITY = this.RT_AVAILABLE_QUANTITY;
	            other.LAST_USER_NAME = this.LAST_USER_NAME;
	            other.LAST_MODIFIED = this.LAST_MODIFIED;
	            other.RT_EOD_BOOK_INVENTORY = this.RT_EOD_BOOK_INVENTORY;
	            other.USER_DLL = this.USER_DLL;
	            other.USER_ROUTINE = this.USER_ROUTINE;
	            other.MANUAL_GROSS_QUANTITY = this.MANUAL_GROSS_QUANTITY;
	            other.MANUAL_OBSERVED_DENSITY = this.MANUAL_OBSERVED_DENSITY;
	            other.RT_OBSERVED_DENSITY = this.RT_OBSERVED_DENSITY;
	            other.AUTO_BSW_LEVEL_ENABLE = this.AUTO_BSW_LEVEL_ENABLE;
	            other.DDE_BSW_LEVEL_ITEM = this.DDE_BSW_LEVEL_ITEM;
	            other.RT_EOD_OPEN_DENSITY = this.RT_EOD_OPEN_DENSITY;
	            other.RT_EOD_OPEN_TEMPERATURE = this.RT_EOD_OPEN_TEMPERATURE;
	            other.RT_EOD_OPEN_LEVEL = this.RT_EOD_OPEN_LEVEL;
	            other.RT_EOD_OPEN_OBSERVED_DENSITY = this.RT_EOD_OPEN_OBSERVED_DENSITY;
	            other.RT_EOD_OPEN_PHYS_GROSS_QTY = this.RT_EOD_OPEN_PHYS_GROSS_QTY;
	            other.RT_GOV = this.RT_GOV;
	            other.RT_GSV = this.RT_GSV;
	            other.RT_TCV = this.RT_TCV;
	            other.RT_CTL = this.RT_CTL;
	            other.MANUAL_STRAP_TYPE = this.MANUAL_STRAP_TYPE;
	            other.RT_CALCULATION_POINT = this.RT_CALCULATION_POINT;
	            other.RT_NSV = this.RT_NSV;
	            other.RT_GSW = this.RT_GSW;
	            other.RT_NSW = this.RT_NSW;
	            other.RT_WCF = this.RT_WCF;
	            other.WEIGHT_IN_AIR = this.WEIGHT_IN_AIR;
	            other.SHAPE = this.SHAPE;
	            other.RT_LEVEL_ORIGIN = this.RT_LEVEL_ORIGIN;
	            other.RT_TOV_ORIGIN = this.RT_TOV_ORIGIN;
	            other.RT_TEMPERATURE_ORIGIN = this.RT_TEMPERATURE_ORIGIN;
	            other.RT_FREE_WATER_LEVEL_ORIGIN = this.RT_FREE_WATER_LEVEL_ORIGIN;
	            other.RT_WATER_QUANTITY_ORIGIN = this.RT_WATER_QUANTITY_ORIGIN;
	            other.RT_TOV = this.RT_TOV;
	            
	}

	public void copyKeysDataTo(row3Struct other) {

		other.TANK_CODE = this.TANK_CODE;
	            	other.NAME = this.NAME;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PGS_STAGE_DIM_TANK.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_TANK.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_TANK = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_TANK = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PGS_STAGE_DIM_TANK, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_TANK, 0, length, utf8Charset);
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
			if(length > commonByteArray_PGS_STAGE_DIM_TANK.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_DIM_TANK.length == 0) {
   					commonByteArray_PGS_STAGE_DIM_TANK = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_DIM_TANK = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PGS_STAGE_DIM_TANK, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_DIM_TANK, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_TANK) {

        	try {

        		int length = 0;
		
					this.TANK_CODE = readString(dis);
					
					this.NAME = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_DIM_TANK) {

        	try {

        		int length = 0;
		
					this.TANK_CODE = readString(dis);
					
					this.NAME = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.TANK_CODE,dos);
					
					// String
				
						writeString(this.NAME,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.TANK_CODE,dos);
					
					// String
				
						writeString(this.NAME,dos);
					
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
		
			            this.PK_TANK = dis.readInt();
					
			            this.RT_GROSS_QUANTITY = dis.readInt();
					
			            this.TERMINAL_PRODUCT_NUMBER = dis.readInt();
					
			            this.RT_NET_QUANTITY = dis.readInt();
					
			            this.RT_TEMPERATURE = dis.readDouble();
					
			            this.RT_DENSITY = dis.readDouble();
					
			            this.SHELL_CAPACITY = dis.readInt();
					
			            this.WORK_CAPACITY = dis.readInt();
					
						this.DEPTH = readString(dis,ois);
					
			            this.AUTO_ENABLE = dis.readInt();
					
			            this.AUTO_LEVEL_ENABLE = dis.readInt();
					
			            this.AUTO_TEMPERATURE_ENABLE = dis.readInt();
					
						this.DDE_LEVEL_ITEM = readString(dis,ois);
					
						this.MANUAL_LEVEL = readString(dis,ois);
					
						this.RT_AUTO_LEVEL = readString(dis,ois);
					
			            this.MANUAL_TEMPERATURE = dis.readDouble();
					
			            this.MANUAL_DENSITY = dis.readDouble();
					
			            this.PROTOCOL_TYPE = dis.readInt();
					
			            this.RT_AUTO_TEMPERATURE = dis.readDouble();
					
						this.PORT_NAME = readString(dis,ois);
					
						this.RT_LEVEL = readString(dis,ois);
					
			            this.RT_EOD_OPENING_PHYSICAL = dis.readInt();
					
			            this.RT_AVAILABLE_QUANTITY = dis.readInt();
					
						this.LAST_USER_NAME = readString(dis,ois);
					
						this.LAST_MODIFIED = readDate(dis,ois);
					
			            this.RT_EOD_BOOK_INVENTORY = dis.readInt();
					
						this.USER_DLL = readString(dis,ois);
					
						this.USER_ROUTINE = readString(dis,ois);
					
			            this.MANUAL_GROSS_QUANTITY = dis.readInt();
					
			            this.MANUAL_OBSERVED_DENSITY = dis.readDouble();
					
			            this.RT_OBSERVED_DENSITY = dis.readDouble();
					
			            this.AUTO_BSW_LEVEL_ENABLE = dis.readInt();
					
						this.DDE_BSW_LEVEL_ITEM = readString(dis,ois);
					
			            this.RT_EOD_OPEN_DENSITY = dis.readDouble();
					
			            this.RT_EOD_OPEN_TEMPERATURE = dis.readDouble();
					
						this.RT_EOD_OPEN_LEVEL = readString(dis,ois);
					
			            this.RT_EOD_OPEN_OBSERVED_DENSITY = dis.readDouble();
					
			            this.RT_EOD_OPEN_PHYS_GROSS_QTY = dis.readInt();
					
			            this.RT_GOV = dis.readInt();
					
			            this.RT_GSV = dis.readInt();
					
			            this.RT_TCV = dis.readInt();
					
			            this.RT_CTL = dis.readDouble();
					
			            this.MANUAL_STRAP_TYPE = dis.readInt();
					
			            this.RT_CALCULATION_POINT = dis.readInt();
					
			            this.RT_NSV = dis.readInt();
					
			            this.RT_GSW = dis.readInt();
					
			            this.RT_NSW = dis.readInt();
					
			            this.RT_WCF = dis.readDouble();
					
			            this.WEIGHT_IN_AIR = dis.readInt();
					
			            this.SHAPE = dis.readInt();
					
			            this.RT_LEVEL_ORIGIN = dis.readInt();
					
			            this.RT_TOV_ORIGIN = dis.readInt();
					
			            this.RT_TEMPERATURE_ORIGIN = dis.readInt();
					
			            this.RT_FREE_WATER_LEVEL_ORIGIN = dis.readInt();
					
			            this.RT_WATER_QUANTITY_ORIGIN = dis.readInt();
					
			            this.RT_TOV = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
			            this.PK_TANK = objectIn.readInt();
					
			            this.RT_GROSS_QUANTITY = objectIn.readInt();
					
			            this.TERMINAL_PRODUCT_NUMBER = objectIn.readInt();
					
			            this.RT_NET_QUANTITY = objectIn.readInt();
					
			            this.RT_TEMPERATURE = objectIn.readDouble();
					
			            this.RT_DENSITY = objectIn.readDouble();
					
			            this.SHELL_CAPACITY = objectIn.readInt();
					
			            this.WORK_CAPACITY = objectIn.readInt();
					
						this.DEPTH = readString(dis,objectIn);
					
			            this.AUTO_ENABLE = objectIn.readInt();
					
			            this.AUTO_LEVEL_ENABLE = objectIn.readInt();
					
			            this.AUTO_TEMPERATURE_ENABLE = objectIn.readInt();
					
						this.DDE_LEVEL_ITEM = readString(dis,objectIn);
					
						this.MANUAL_LEVEL = readString(dis,objectIn);
					
						this.RT_AUTO_LEVEL = readString(dis,objectIn);
					
			            this.MANUAL_TEMPERATURE = objectIn.readDouble();
					
			            this.MANUAL_DENSITY = objectIn.readDouble();
					
			            this.PROTOCOL_TYPE = objectIn.readInt();
					
			            this.RT_AUTO_TEMPERATURE = objectIn.readDouble();
					
						this.PORT_NAME = readString(dis,objectIn);
					
						this.RT_LEVEL = readString(dis,objectIn);
					
			            this.RT_EOD_OPENING_PHYSICAL = objectIn.readInt();
					
			            this.RT_AVAILABLE_QUANTITY = objectIn.readInt();
					
						this.LAST_USER_NAME = readString(dis,objectIn);
					
						this.LAST_MODIFIED = readDate(dis,objectIn);
					
			            this.RT_EOD_BOOK_INVENTORY = objectIn.readInt();
					
						this.USER_DLL = readString(dis,objectIn);
					
						this.USER_ROUTINE = readString(dis,objectIn);
					
			            this.MANUAL_GROSS_QUANTITY = objectIn.readInt();
					
			            this.MANUAL_OBSERVED_DENSITY = objectIn.readDouble();
					
			            this.RT_OBSERVED_DENSITY = objectIn.readDouble();
					
			            this.AUTO_BSW_LEVEL_ENABLE = objectIn.readInt();
					
						this.DDE_BSW_LEVEL_ITEM = readString(dis,objectIn);
					
			            this.RT_EOD_OPEN_DENSITY = objectIn.readDouble();
					
			            this.RT_EOD_OPEN_TEMPERATURE = objectIn.readDouble();
					
						this.RT_EOD_OPEN_LEVEL = readString(dis,objectIn);
					
			            this.RT_EOD_OPEN_OBSERVED_DENSITY = objectIn.readDouble();
					
			            this.RT_EOD_OPEN_PHYS_GROSS_QTY = objectIn.readInt();
					
			            this.RT_GOV = objectIn.readInt();
					
			            this.RT_GSV = objectIn.readInt();
					
			            this.RT_TCV = objectIn.readInt();
					
			            this.RT_CTL = objectIn.readDouble();
					
			            this.MANUAL_STRAP_TYPE = objectIn.readInt();
					
			            this.RT_CALCULATION_POINT = objectIn.readInt();
					
			            this.RT_NSV = objectIn.readInt();
					
			            this.RT_GSW = objectIn.readInt();
					
			            this.RT_NSW = objectIn.readInt();
					
			            this.RT_WCF = objectIn.readDouble();
					
			            this.WEIGHT_IN_AIR = objectIn.readInt();
					
			            this.SHAPE = objectIn.readInt();
					
			            this.RT_LEVEL_ORIGIN = objectIn.readInt();
					
			            this.RT_TOV_ORIGIN = objectIn.readInt();
					
			            this.RT_TEMPERATURE_ORIGIN = objectIn.readInt();
					
			            this.RT_FREE_WATER_LEVEL_ORIGIN = objectIn.readInt();
					
			            this.RT_WATER_QUANTITY_ORIGIN = objectIn.readInt();
					
			            this.RT_TOV = objectIn.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
		            	dos.writeInt(this.PK_TANK);
					
		            	dos.writeInt(this.RT_GROSS_QUANTITY);
					
		            	dos.writeInt(this.TERMINAL_PRODUCT_NUMBER);
					
		            	dos.writeInt(this.RT_NET_QUANTITY);
					
		            	dos.writeDouble(this.RT_TEMPERATURE);
					
		            	dos.writeDouble(this.RT_DENSITY);
					
		            	dos.writeInt(this.SHELL_CAPACITY);
					
		            	dos.writeInt(this.WORK_CAPACITY);
					
						writeString(this.DEPTH, dos, oos);
					
		            	dos.writeInt(this.AUTO_ENABLE);
					
		            	dos.writeInt(this.AUTO_LEVEL_ENABLE);
					
		            	dos.writeInt(this.AUTO_TEMPERATURE_ENABLE);
					
						writeString(this.DDE_LEVEL_ITEM, dos, oos);
					
						writeString(this.MANUAL_LEVEL, dos, oos);
					
						writeString(this.RT_AUTO_LEVEL, dos, oos);
					
		            	dos.writeDouble(this.MANUAL_TEMPERATURE);
					
		            	dos.writeDouble(this.MANUAL_DENSITY);
					
		            	dos.writeInt(this.PROTOCOL_TYPE);
					
		            	dos.writeDouble(this.RT_AUTO_TEMPERATURE);
					
						writeString(this.PORT_NAME, dos, oos);
					
						writeString(this.RT_LEVEL, dos, oos);
					
		            	dos.writeInt(this.RT_EOD_OPENING_PHYSICAL);
					
		            	dos.writeInt(this.RT_AVAILABLE_QUANTITY);
					
						writeString(this.LAST_USER_NAME, dos, oos);
					
						writeDate(this.LAST_MODIFIED, dos, oos);
					
		            	dos.writeInt(this.RT_EOD_BOOK_INVENTORY);
					
						writeString(this.USER_DLL, dos, oos);
					
						writeString(this.USER_ROUTINE, dos, oos);
					
		            	dos.writeInt(this.MANUAL_GROSS_QUANTITY);
					
		            	dos.writeDouble(this.MANUAL_OBSERVED_DENSITY);
					
		            	dos.writeDouble(this.RT_OBSERVED_DENSITY);
					
		            	dos.writeInt(this.AUTO_BSW_LEVEL_ENABLE);
					
						writeString(this.DDE_BSW_LEVEL_ITEM, dos, oos);
					
		            	dos.writeDouble(this.RT_EOD_OPEN_DENSITY);
					
		            	dos.writeDouble(this.RT_EOD_OPEN_TEMPERATURE);
					
						writeString(this.RT_EOD_OPEN_LEVEL, dos, oos);
					
		            	dos.writeDouble(this.RT_EOD_OPEN_OBSERVED_DENSITY);
					
		            	dos.writeInt(this.RT_EOD_OPEN_PHYS_GROSS_QTY);
					
		            	dos.writeInt(this.RT_GOV);
					
		            	dos.writeInt(this.RT_GSV);
					
		            	dos.writeInt(this.RT_TCV);
					
		            	dos.writeDouble(this.RT_CTL);
					
		            	dos.writeInt(this.MANUAL_STRAP_TYPE);
					
		            	dos.writeInt(this.RT_CALCULATION_POINT);
					
		            	dos.writeInt(this.RT_NSV);
					
		            	dos.writeInt(this.RT_GSW);
					
		            	dos.writeInt(this.RT_NSW);
					
		            	dos.writeDouble(this.RT_WCF);
					
		            	dos.writeInt(this.WEIGHT_IN_AIR);
					
		            	dos.writeInt(this.SHAPE);
					
		            	dos.writeInt(this.RT_LEVEL_ORIGIN);
					
		            	dos.writeInt(this.RT_TOV_ORIGIN);
					
		            	dos.writeInt(this.RT_TEMPERATURE_ORIGIN);
					
		            	dos.writeInt(this.RT_FREE_WATER_LEVEL_ORIGIN);
					
		            	dos.writeInt(this.RT_WATER_QUANTITY_ORIGIN);
					
		            	dos.writeInt(this.RT_TOV);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
					objectOut.writeInt(this.PK_TANK);
					
					objectOut.writeInt(this.RT_GROSS_QUANTITY);
					
					objectOut.writeInt(this.TERMINAL_PRODUCT_NUMBER);
					
					objectOut.writeInt(this.RT_NET_QUANTITY);
					
					objectOut.writeDouble(this.RT_TEMPERATURE);
					
					objectOut.writeDouble(this.RT_DENSITY);
					
					objectOut.writeInt(this.SHELL_CAPACITY);
					
					objectOut.writeInt(this.WORK_CAPACITY);
					
						writeString(this.DEPTH, dos, objectOut);
					
					objectOut.writeInt(this.AUTO_ENABLE);
					
					objectOut.writeInt(this.AUTO_LEVEL_ENABLE);
					
					objectOut.writeInt(this.AUTO_TEMPERATURE_ENABLE);
					
						writeString(this.DDE_LEVEL_ITEM, dos, objectOut);
					
						writeString(this.MANUAL_LEVEL, dos, objectOut);
					
						writeString(this.RT_AUTO_LEVEL, dos, objectOut);
					
					objectOut.writeDouble(this.MANUAL_TEMPERATURE);
					
					objectOut.writeDouble(this.MANUAL_DENSITY);
					
					objectOut.writeInt(this.PROTOCOL_TYPE);
					
					objectOut.writeDouble(this.RT_AUTO_TEMPERATURE);
					
						writeString(this.PORT_NAME, dos, objectOut);
					
						writeString(this.RT_LEVEL, dos, objectOut);
					
					objectOut.writeInt(this.RT_EOD_OPENING_PHYSICAL);
					
					objectOut.writeInt(this.RT_AVAILABLE_QUANTITY);
					
						writeString(this.LAST_USER_NAME, dos, objectOut);
					
						writeDate(this.LAST_MODIFIED, dos, objectOut);
					
					objectOut.writeInt(this.RT_EOD_BOOK_INVENTORY);
					
						writeString(this.USER_DLL, dos, objectOut);
					
						writeString(this.USER_ROUTINE, dos, objectOut);
					
					objectOut.writeInt(this.MANUAL_GROSS_QUANTITY);
					
					objectOut.writeDouble(this.MANUAL_OBSERVED_DENSITY);
					
					objectOut.writeDouble(this.RT_OBSERVED_DENSITY);
					
					objectOut.writeInt(this.AUTO_BSW_LEVEL_ENABLE);
					
						writeString(this.DDE_BSW_LEVEL_ITEM, dos, objectOut);
					
					objectOut.writeDouble(this.RT_EOD_OPEN_DENSITY);
					
					objectOut.writeDouble(this.RT_EOD_OPEN_TEMPERATURE);
					
						writeString(this.RT_EOD_OPEN_LEVEL, dos, objectOut);
					
					objectOut.writeDouble(this.RT_EOD_OPEN_OBSERVED_DENSITY);
					
					objectOut.writeInt(this.RT_EOD_OPEN_PHYS_GROSS_QTY);
					
					objectOut.writeInt(this.RT_GOV);
					
					objectOut.writeInt(this.RT_GSV);
					
					objectOut.writeInt(this.RT_TCV);
					
					objectOut.writeDouble(this.RT_CTL);
					
					objectOut.writeInt(this.MANUAL_STRAP_TYPE);
					
					objectOut.writeInt(this.RT_CALCULATION_POINT);
					
					objectOut.writeInt(this.RT_NSV);
					
					objectOut.writeInt(this.RT_GSW);
					
					objectOut.writeInt(this.RT_NSW);
					
					objectOut.writeDouble(this.RT_WCF);
					
					objectOut.writeInt(this.WEIGHT_IN_AIR);
					
					objectOut.writeInt(this.SHAPE);
					
					objectOut.writeInt(this.RT_LEVEL_ORIGIN);
					
					objectOut.writeInt(this.RT_TOV_ORIGIN);
					
					objectOut.writeInt(this.RT_TEMPERATURE_ORIGIN);
					
					objectOut.writeInt(this.RT_FREE_WATER_LEVEL_ORIGIN);
					
					objectOut.writeInt(this.RT_WATER_QUANTITY_ORIGIN);
					
					objectOut.writeInt(this.RT_TOV);
					
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
		sb.append("PK_TANK="+String.valueOf(PK_TANK));
		sb.append(",TANK_CODE="+TANK_CODE);
		sb.append(",NAME="+NAME);
		sb.append(",RT_GROSS_QUANTITY="+String.valueOf(RT_GROSS_QUANTITY));
		sb.append(",TERMINAL_PRODUCT_NUMBER="+String.valueOf(TERMINAL_PRODUCT_NUMBER));
		sb.append(",RT_NET_QUANTITY="+String.valueOf(RT_NET_QUANTITY));
		sb.append(",RT_TEMPERATURE="+String.valueOf(RT_TEMPERATURE));
		sb.append(",RT_DENSITY="+String.valueOf(RT_DENSITY));
		sb.append(",SHELL_CAPACITY="+String.valueOf(SHELL_CAPACITY));
		sb.append(",WORK_CAPACITY="+String.valueOf(WORK_CAPACITY));
		sb.append(",DEPTH="+DEPTH);
		sb.append(",AUTO_ENABLE="+String.valueOf(AUTO_ENABLE));
		sb.append(",AUTO_LEVEL_ENABLE="+String.valueOf(AUTO_LEVEL_ENABLE));
		sb.append(",AUTO_TEMPERATURE_ENABLE="+String.valueOf(AUTO_TEMPERATURE_ENABLE));
		sb.append(",DDE_LEVEL_ITEM="+DDE_LEVEL_ITEM);
		sb.append(",MANUAL_LEVEL="+MANUAL_LEVEL);
		sb.append(",RT_AUTO_LEVEL="+RT_AUTO_LEVEL);
		sb.append(",MANUAL_TEMPERATURE="+String.valueOf(MANUAL_TEMPERATURE));
		sb.append(",MANUAL_DENSITY="+String.valueOf(MANUAL_DENSITY));
		sb.append(",PROTOCOL_TYPE="+String.valueOf(PROTOCOL_TYPE));
		sb.append(",RT_AUTO_TEMPERATURE="+String.valueOf(RT_AUTO_TEMPERATURE));
		sb.append(",PORT_NAME="+PORT_NAME);
		sb.append(",RT_LEVEL="+RT_LEVEL);
		sb.append(",RT_EOD_OPENING_PHYSICAL="+String.valueOf(RT_EOD_OPENING_PHYSICAL));
		sb.append(",RT_AVAILABLE_QUANTITY="+String.valueOf(RT_AVAILABLE_QUANTITY));
		sb.append(",LAST_USER_NAME="+LAST_USER_NAME);
		sb.append(",LAST_MODIFIED="+String.valueOf(LAST_MODIFIED));
		sb.append(",RT_EOD_BOOK_INVENTORY="+String.valueOf(RT_EOD_BOOK_INVENTORY));
		sb.append(",USER_DLL="+USER_DLL);
		sb.append(",USER_ROUTINE="+USER_ROUTINE);
		sb.append(",MANUAL_GROSS_QUANTITY="+String.valueOf(MANUAL_GROSS_QUANTITY));
		sb.append(",MANUAL_OBSERVED_DENSITY="+String.valueOf(MANUAL_OBSERVED_DENSITY));
		sb.append(",RT_OBSERVED_DENSITY="+String.valueOf(RT_OBSERVED_DENSITY));
		sb.append(",AUTO_BSW_LEVEL_ENABLE="+String.valueOf(AUTO_BSW_LEVEL_ENABLE));
		sb.append(",DDE_BSW_LEVEL_ITEM="+DDE_BSW_LEVEL_ITEM);
		sb.append(",RT_EOD_OPEN_DENSITY="+String.valueOf(RT_EOD_OPEN_DENSITY));
		sb.append(",RT_EOD_OPEN_TEMPERATURE="+String.valueOf(RT_EOD_OPEN_TEMPERATURE));
		sb.append(",RT_EOD_OPEN_LEVEL="+RT_EOD_OPEN_LEVEL);
		sb.append(",RT_EOD_OPEN_OBSERVED_DENSITY="+String.valueOf(RT_EOD_OPEN_OBSERVED_DENSITY));
		sb.append(",RT_EOD_OPEN_PHYS_GROSS_QTY="+String.valueOf(RT_EOD_OPEN_PHYS_GROSS_QTY));
		sb.append(",RT_GOV="+String.valueOf(RT_GOV));
		sb.append(",RT_GSV="+String.valueOf(RT_GSV));
		sb.append(",RT_TCV="+String.valueOf(RT_TCV));
		sb.append(",RT_CTL="+String.valueOf(RT_CTL));
		sb.append(",MANUAL_STRAP_TYPE="+String.valueOf(MANUAL_STRAP_TYPE));
		sb.append(",RT_CALCULATION_POINT="+String.valueOf(RT_CALCULATION_POINT));
		sb.append(",RT_NSV="+String.valueOf(RT_NSV));
		sb.append(",RT_GSW="+String.valueOf(RT_GSW));
		sb.append(",RT_NSW="+String.valueOf(RT_NSW));
		sb.append(",RT_WCF="+String.valueOf(RT_WCF));
		sb.append(",WEIGHT_IN_AIR="+String.valueOf(WEIGHT_IN_AIR));
		sb.append(",SHAPE="+String.valueOf(SHAPE));
		sb.append(",RT_LEVEL_ORIGIN="+String.valueOf(RT_LEVEL_ORIGIN));
		sb.append(",RT_TOV_ORIGIN="+String.valueOf(RT_TOV_ORIGIN));
		sb.append(",RT_TEMPERATURE_ORIGIN="+String.valueOf(RT_TEMPERATURE_ORIGIN));
		sb.append(",RT_FREE_WATER_LEVEL_ORIGIN="+String.valueOf(RT_FREE_WATER_LEVEL_ORIGIN));
		sb.append(",RT_WATER_QUANTITY_ORIGIN="+String.valueOf(RT_WATER_QUANTITY_ORIGIN));
		sb.append(",RT_TOV="+String.valueOf(RT_TOV));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row3Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.TANK_CODE, other.TANK_CODE);
						if(returnValue != 0) {
							return returnValue;
						}

					
						returnValue = checkNullsAndCompare(this.NAME, other.NAME);
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
				
				 
	final String decryptedPassword_tDBInput_2 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:bgv/0CCv7s77kon7xNCBFSMQdy6J8mRbdAA+/nxMK+20NtRbhD0=");
				
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

		    String dbquery_tDBInput_2 = "SELECT dbo.DIM_TANK.PK_TANK,\n		dbo.DIM_TANK.TANK_CODE,\n		dbo.DIM_TANK.NAME,\n		dbo.DIM_TANK.RT_GROSS_QUANTITY,\n		dbo.DIM"
+"_TANK.TERMINAL_PRODUCT_NUMBER,\n		dbo.DIM_TANK.RT_NET_QUANTITY,\n		dbo.DIM_TANK.RT_TEMPERATURE,\n		dbo.DIM_TANK.RT_DENSITY,"
+"\n		dbo.DIM_TANK.SHELL_CAPACITY,\n		dbo.DIM_TANK.WORK_CAPACITY,\n		dbo.DIM_TANK.DEPTH,\n		dbo.DIM_TANK.AUTO_ENABLE,\n		dbo.DI"
+"M_TANK.AUTO_LEVEL_ENABLE,\n		dbo.DIM_TANK.AUTO_TEMPERATURE_ENABLE,\n		dbo.DIM_TANK.DDE_LEVEL_ITEM,\n		dbo.DIM_TANK.MANUAL_L"
+"EVEL,\n		dbo.DIM_TANK.RT_AUTO_LEVEL,\n		dbo.DIM_TANK.MANUAL_TEMPERATURE,\n		dbo.DIM_TANK.MANUAL_DENSITY,\n		dbo.DIM_TANK.PRO"
+"TOCOL_TYPE,\n		dbo.DIM_TANK.RT_AUTO_TEMPERATURE,\n		dbo.DIM_TANK.PORT_NAME,\n		dbo.DIM_TANK.RT_LEVEL,\n		dbo.DIM_TANK.RT_EOD"
+"_OPENING_PHYSICAL,\n		dbo.DIM_TANK.RT_AVAILABLE_QUANTITY,\n		dbo.DIM_TANK.LAST_USER_NAME,\n		dbo.DIM_TANK.LAST_MODIFIED,\n		"
+"dbo.DIM_TANK.RT_EOD_BOOK_INVENTORY,\n		dbo.DIM_TANK.USER_DLL,\n		dbo.DIM_TANK.USER_ROUTINE,\n		dbo.DIM_TANK.MANUAL_GROSS_QU"
+"ANTITY,\n		dbo.DIM_TANK.MANUAL_OBSERVED_DENSITY,\n		dbo.DIM_TANK.RT_OBSERVED_DENSITY,\n		dbo.DIM_TANK.AUTO_BSW_LEVEL_ENABLE"
+",\n		dbo.DIM_TANK.DDE_BSW_LEVEL_ITEM,\n		dbo.DIM_TANK.RT_EOD_OPEN_DENSITY,\n		dbo.DIM_TANK.RT_EOD_OPEN_TEMPERATURE,\n		dbo.D"
+"IM_TANK.RT_EOD_OPEN_LEVEL,\n		dbo.DIM_TANK.RT_EOD_OPEN_OBSERVED_DENSITY,\n		dbo.DIM_TANK.RT_EOD_OPEN_PHYS_GROSS_QTY,\n		dbo"
+".DIM_TANK.RT_GOV,\n		dbo.DIM_TANK.RT_GSV,\n		dbo.DIM_TANK.RT_TCV,\n		dbo.DIM_TANK.RT_CTL,\n		dbo.DIM_TANK.MANUAL_STRAP_TYPE,"
+"\n		dbo.DIM_TANK.RT_CALCULATION_POINT,\n		dbo.DIM_TANK.RT_NSV,\n		dbo.DIM_TANK.RT_GSW,\n		dbo.DIM_TANK.RT_NSW,\n		dbo.DIM_TAN"
+"K.RT_WCF,\n		dbo.DIM_TANK.WEIGHT_IN_AIR,\n		dbo.DIM_TANK.SHAPE,\n		dbo.DIM_TANK.RT_LEVEL_ORIGIN,\n		dbo.DIM_TANK.RT_TOV_ORIG"
+"IN,\n		dbo.DIM_TANK.RT_TEMPERATURE_ORIGIN,\n		dbo.DIM_TANK.RT_FREE_WATER_LEVEL_ORIGIN,\n		dbo.DIM_TANK.RT_WATER_QUANTITY_OR"
+"IGIN,\n		dbo.DIM_TANK.RT_TOV\nFROM	dbo.DIM_TANK";
		    

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
								row3.PK_TANK = 0;
							} else {
		                          
            row3.PK_TANK = rs_tDBInput_2.getInt(1);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 2) {
								row3.TANK_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(2);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(2).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.TANK_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row3.TANK_CODE = tmpContent_tDBInput_2;
                }
            } else {
                row3.TANK_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 3) {
								row3.NAME = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(3);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(3).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.NAME = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row3.NAME = tmpContent_tDBInput_2;
                }
            } else {
                row3.NAME = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 4) {
								row3.RT_GROSS_QUANTITY = 0;
							} else {
		                          
            row3.RT_GROSS_QUANTITY = rs_tDBInput_2.getInt(4);
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
								row3.RT_NET_QUANTITY = 0;
							} else {
		                          
            row3.RT_NET_QUANTITY = rs_tDBInput_2.getInt(6);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 7) {
								row3.RT_TEMPERATURE = 0;
							} else {
	                         		
            row3.RT_TEMPERATURE = rs_tDBInput_2.getDouble(7);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 8) {
								row3.RT_DENSITY = 0;
							} else {
	                         		
            row3.RT_DENSITY = rs_tDBInput_2.getDouble(8);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 9) {
								row3.SHELL_CAPACITY = 0;
							} else {
		                          
            row3.SHELL_CAPACITY = rs_tDBInput_2.getInt(9);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 10) {
								row3.WORK_CAPACITY = 0;
							} else {
		                          
            row3.WORK_CAPACITY = rs_tDBInput_2.getInt(10);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 11) {
								row3.DEPTH = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(11);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(11).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.DEPTH = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row3.DEPTH = tmpContent_tDBInput_2;
                }
            } else {
                row3.DEPTH = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 12) {
								row3.AUTO_ENABLE = 0;
							} else {
		                          
            row3.AUTO_ENABLE = rs_tDBInput_2.getInt(12);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 13) {
								row3.AUTO_LEVEL_ENABLE = 0;
							} else {
		                          
            row3.AUTO_LEVEL_ENABLE = rs_tDBInput_2.getInt(13);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 14) {
								row3.AUTO_TEMPERATURE_ENABLE = 0;
							} else {
		                          
            row3.AUTO_TEMPERATURE_ENABLE = rs_tDBInput_2.getInt(14);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 15) {
								row3.DDE_LEVEL_ITEM = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(15);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(15).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.DDE_LEVEL_ITEM = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row3.DDE_LEVEL_ITEM = tmpContent_tDBInput_2;
                }
            } else {
                row3.DDE_LEVEL_ITEM = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 16) {
								row3.MANUAL_LEVEL = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(16);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(16).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.MANUAL_LEVEL = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row3.MANUAL_LEVEL = tmpContent_tDBInput_2;
                }
            } else {
                row3.MANUAL_LEVEL = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 17) {
								row3.RT_AUTO_LEVEL = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(17);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(17).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.RT_AUTO_LEVEL = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row3.RT_AUTO_LEVEL = tmpContent_tDBInput_2;
                }
            } else {
                row3.RT_AUTO_LEVEL = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 18) {
								row3.MANUAL_TEMPERATURE = 0;
							} else {
	                         		
            row3.MANUAL_TEMPERATURE = rs_tDBInput_2.getDouble(18);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 19) {
								row3.MANUAL_DENSITY = 0;
							} else {
	                         		
            row3.MANUAL_DENSITY = rs_tDBInput_2.getDouble(19);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 20) {
								row3.PROTOCOL_TYPE = 0;
							} else {
		                          
            row3.PROTOCOL_TYPE = rs_tDBInput_2.getInt(20);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 21) {
								row3.RT_AUTO_TEMPERATURE = 0;
							} else {
	                         		
            row3.RT_AUTO_TEMPERATURE = rs_tDBInput_2.getDouble(21);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 22) {
								row3.PORT_NAME = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(22);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(22).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.PORT_NAME = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row3.PORT_NAME = tmpContent_tDBInput_2;
                }
            } else {
                row3.PORT_NAME = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 23) {
								row3.RT_LEVEL = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(23);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(23).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.RT_LEVEL = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row3.RT_LEVEL = tmpContent_tDBInput_2;
                }
            } else {
                row3.RT_LEVEL = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 24) {
								row3.RT_EOD_OPENING_PHYSICAL = 0;
							} else {
		                          
            row3.RT_EOD_OPENING_PHYSICAL = rs_tDBInput_2.getInt(24);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 25) {
								row3.RT_AVAILABLE_QUANTITY = 0;
							} else {
		                          
            row3.RT_AVAILABLE_QUANTITY = rs_tDBInput_2.getInt(25);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 26) {
								row3.LAST_USER_NAME = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(26);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(26).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.LAST_USER_NAME = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row3.LAST_USER_NAME = tmpContent_tDBInput_2;
                }
            } else {
                row3.LAST_USER_NAME = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 27) {
								row3.LAST_MODIFIED = null;
							} else {
										
			row3.LAST_MODIFIED = mssqlGTU_tDBInput_2.getDate(rsmd_tDBInput_2, rs_tDBInput_2, 27);
			
		                    }
							if(colQtyInRs_tDBInput_2 < 28) {
								row3.RT_EOD_BOOK_INVENTORY = 0;
							} else {
		                          
            row3.RT_EOD_BOOK_INVENTORY = rs_tDBInput_2.getInt(28);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 29) {
								row3.USER_DLL = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(29);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(29).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.USER_DLL = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row3.USER_DLL = tmpContent_tDBInput_2;
                }
            } else {
                row3.USER_DLL = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 30) {
								row3.USER_ROUTINE = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(30);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(30).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.USER_ROUTINE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row3.USER_ROUTINE = tmpContent_tDBInput_2;
                }
            } else {
                row3.USER_ROUTINE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 31) {
								row3.MANUAL_GROSS_QUANTITY = 0;
							} else {
		                          
            row3.MANUAL_GROSS_QUANTITY = rs_tDBInput_2.getInt(31);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 32) {
								row3.MANUAL_OBSERVED_DENSITY = 0;
							} else {
	                         		
            row3.MANUAL_OBSERVED_DENSITY = rs_tDBInput_2.getDouble(32);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 33) {
								row3.RT_OBSERVED_DENSITY = 0;
							} else {
	                         		
            row3.RT_OBSERVED_DENSITY = rs_tDBInput_2.getDouble(33);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 34) {
								row3.AUTO_BSW_LEVEL_ENABLE = 0;
							} else {
		                          
            row3.AUTO_BSW_LEVEL_ENABLE = rs_tDBInput_2.getInt(34);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 35) {
								row3.DDE_BSW_LEVEL_ITEM = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(35);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(35).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.DDE_BSW_LEVEL_ITEM = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row3.DDE_BSW_LEVEL_ITEM = tmpContent_tDBInput_2;
                }
            } else {
                row3.DDE_BSW_LEVEL_ITEM = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 36) {
								row3.RT_EOD_OPEN_DENSITY = 0;
							} else {
	                         		
            row3.RT_EOD_OPEN_DENSITY = rs_tDBInput_2.getDouble(36);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 37) {
								row3.RT_EOD_OPEN_TEMPERATURE = 0;
							} else {
	                         		
            row3.RT_EOD_OPEN_TEMPERATURE = rs_tDBInput_2.getDouble(37);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 38) {
								row3.RT_EOD_OPEN_LEVEL = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(38);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(38).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.RT_EOD_OPEN_LEVEL = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row3.RT_EOD_OPEN_LEVEL = tmpContent_tDBInput_2;
                }
            } else {
                row3.RT_EOD_OPEN_LEVEL = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 39) {
								row3.RT_EOD_OPEN_OBSERVED_DENSITY = 0;
							} else {
	                         		
            row3.RT_EOD_OPEN_OBSERVED_DENSITY = rs_tDBInput_2.getDouble(39);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 40) {
								row3.RT_EOD_OPEN_PHYS_GROSS_QTY = 0;
							} else {
		                          
            row3.RT_EOD_OPEN_PHYS_GROSS_QTY = rs_tDBInput_2.getInt(40);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 41) {
								row3.RT_GOV = 0;
							} else {
		                          
            row3.RT_GOV = rs_tDBInput_2.getInt(41);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 42) {
								row3.RT_GSV = 0;
							} else {
		                          
            row3.RT_GSV = rs_tDBInput_2.getInt(42);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 43) {
								row3.RT_TCV = 0;
							} else {
		                          
            row3.RT_TCV = rs_tDBInput_2.getInt(43);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 44) {
								row3.RT_CTL = 0;
							} else {
	                         		
            row3.RT_CTL = rs_tDBInput_2.getDouble(44);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 45) {
								row3.MANUAL_STRAP_TYPE = 0;
							} else {
		                          
            row3.MANUAL_STRAP_TYPE = rs_tDBInput_2.getInt(45);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 46) {
								row3.RT_CALCULATION_POINT = 0;
							} else {
		                          
            row3.RT_CALCULATION_POINT = rs_tDBInput_2.getInt(46);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 47) {
								row3.RT_NSV = 0;
							} else {
		                          
            row3.RT_NSV = rs_tDBInput_2.getInt(47);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 48) {
								row3.RT_GSW = 0;
							} else {
		                          
            row3.RT_GSW = rs_tDBInput_2.getInt(48);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 49) {
								row3.RT_NSW = 0;
							} else {
		                          
            row3.RT_NSW = rs_tDBInput_2.getInt(49);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 50) {
								row3.RT_WCF = 0;
							} else {
	                         		
            row3.RT_WCF = rs_tDBInput_2.getDouble(50);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 51) {
								row3.WEIGHT_IN_AIR = 0;
							} else {
		                          
            row3.WEIGHT_IN_AIR = rs_tDBInput_2.getInt(51);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 52) {
								row3.SHAPE = 0;
							} else {
		                          
            row3.SHAPE = rs_tDBInput_2.getInt(52);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 53) {
								row3.RT_LEVEL_ORIGIN = 0;
							} else {
		                          
            row3.RT_LEVEL_ORIGIN = rs_tDBInput_2.getInt(53);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 54) {
								row3.RT_TOV_ORIGIN = 0;
							} else {
		                          
            row3.RT_TOV_ORIGIN = rs_tDBInput_2.getInt(54);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 55) {
								row3.RT_TEMPERATURE_ORIGIN = 0;
							} else {
		                          
            row3.RT_TEMPERATURE_ORIGIN = rs_tDBInput_2.getInt(55);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 56) {
								row3.RT_FREE_WATER_LEVEL_ORIGIN = 0;
							} else {
		                          
            row3.RT_FREE_WATER_LEVEL_ORIGIN = rs_tDBInput_2.getInt(56);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 57) {
								row3.RT_WATER_QUANTITY_ORIGIN = 0;
							} else {
		                          
            row3.RT_WATER_QUANTITY_ORIGIN = rs_tDBInput_2.getInt(57);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 58) {
								row3.RT_TOV = 0;
							} else {
		                          
            row3.RT_TOV = rs_tDBInput_2.getInt(58);
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
		   	   	   
				
				row3_HashRow.PK_TANK = row3.PK_TANK;
				
				row3_HashRow.TANK_CODE = row3.TANK_CODE;
				
				row3_HashRow.NAME = row3.NAME;
				
				row3_HashRow.RT_GROSS_QUANTITY = row3.RT_GROSS_QUANTITY;
				
				row3_HashRow.TERMINAL_PRODUCT_NUMBER = row3.TERMINAL_PRODUCT_NUMBER;
				
				row3_HashRow.RT_NET_QUANTITY = row3.RT_NET_QUANTITY;
				
				row3_HashRow.RT_TEMPERATURE = row3.RT_TEMPERATURE;
				
				row3_HashRow.RT_DENSITY = row3.RT_DENSITY;
				
				row3_HashRow.SHELL_CAPACITY = row3.SHELL_CAPACITY;
				
				row3_HashRow.WORK_CAPACITY = row3.WORK_CAPACITY;
				
				row3_HashRow.DEPTH = row3.DEPTH;
				
				row3_HashRow.AUTO_ENABLE = row3.AUTO_ENABLE;
				
				row3_HashRow.AUTO_LEVEL_ENABLE = row3.AUTO_LEVEL_ENABLE;
				
				row3_HashRow.AUTO_TEMPERATURE_ENABLE = row3.AUTO_TEMPERATURE_ENABLE;
				
				row3_HashRow.DDE_LEVEL_ITEM = row3.DDE_LEVEL_ITEM;
				
				row3_HashRow.MANUAL_LEVEL = row3.MANUAL_LEVEL;
				
				row3_HashRow.RT_AUTO_LEVEL = row3.RT_AUTO_LEVEL;
				
				row3_HashRow.MANUAL_TEMPERATURE = row3.MANUAL_TEMPERATURE;
				
				row3_HashRow.MANUAL_DENSITY = row3.MANUAL_DENSITY;
				
				row3_HashRow.PROTOCOL_TYPE = row3.PROTOCOL_TYPE;
				
				row3_HashRow.RT_AUTO_TEMPERATURE = row3.RT_AUTO_TEMPERATURE;
				
				row3_HashRow.PORT_NAME = row3.PORT_NAME;
				
				row3_HashRow.RT_LEVEL = row3.RT_LEVEL;
				
				row3_HashRow.RT_EOD_OPENING_PHYSICAL = row3.RT_EOD_OPENING_PHYSICAL;
				
				row3_HashRow.RT_AVAILABLE_QUANTITY = row3.RT_AVAILABLE_QUANTITY;
				
				row3_HashRow.LAST_USER_NAME = row3.LAST_USER_NAME;
				
				row3_HashRow.LAST_MODIFIED = row3.LAST_MODIFIED;
				
				row3_HashRow.RT_EOD_BOOK_INVENTORY = row3.RT_EOD_BOOK_INVENTORY;
				
				row3_HashRow.USER_DLL = row3.USER_DLL;
				
				row3_HashRow.USER_ROUTINE = row3.USER_ROUTINE;
				
				row3_HashRow.MANUAL_GROSS_QUANTITY = row3.MANUAL_GROSS_QUANTITY;
				
				row3_HashRow.MANUAL_OBSERVED_DENSITY = row3.MANUAL_OBSERVED_DENSITY;
				
				row3_HashRow.RT_OBSERVED_DENSITY = row3.RT_OBSERVED_DENSITY;
				
				row3_HashRow.AUTO_BSW_LEVEL_ENABLE = row3.AUTO_BSW_LEVEL_ENABLE;
				
				row3_HashRow.DDE_BSW_LEVEL_ITEM = row3.DDE_BSW_LEVEL_ITEM;
				
				row3_HashRow.RT_EOD_OPEN_DENSITY = row3.RT_EOD_OPEN_DENSITY;
				
				row3_HashRow.RT_EOD_OPEN_TEMPERATURE = row3.RT_EOD_OPEN_TEMPERATURE;
				
				row3_HashRow.RT_EOD_OPEN_LEVEL = row3.RT_EOD_OPEN_LEVEL;
				
				row3_HashRow.RT_EOD_OPEN_OBSERVED_DENSITY = row3.RT_EOD_OPEN_OBSERVED_DENSITY;
				
				row3_HashRow.RT_EOD_OPEN_PHYS_GROSS_QTY = row3.RT_EOD_OPEN_PHYS_GROSS_QTY;
				
				row3_HashRow.RT_GOV = row3.RT_GOV;
				
				row3_HashRow.RT_GSV = row3.RT_GSV;
				
				row3_HashRow.RT_TCV = row3.RT_TCV;
				
				row3_HashRow.RT_CTL = row3.RT_CTL;
				
				row3_HashRow.MANUAL_STRAP_TYPE = row3.MANUAL_STRAP_TYPE;
				
				row3_HashRow.RT_CALCULATION_POINT = row3.RT_CALCULATION_POINT;
				
				row3_HashRow.RT_NSV = row3.RT_NSV;
				
				row3_HashRow.RT_GSW = row3.RT_GSW;
				
				row3_HashRow.RT_NSW = row3.RT_NSW;
				
				row3_HashRow.RT_WCF = row3.RT_WCF;
				
				row3_HashRow.WEIGHT_IN_AIR = row3.WEIGHT_IN_AIR;
				
				row3_HashRow.SHAPE = row3.SHAPE;
				
				row3_HashRow.RT_LEVEL_ORIGIN = row3.RT_LEVEL_ORIGIN;
				
				row3_HashRow.RT_TOV_ORIGIN = row3.RT_TOV_ORIGIN;
				
				row3_HashRow.RT_TEMPERATURE_ORIGIN = row3.RT_TEMPERATURE_ORIGIN;
				
				row3_HashRow.RT_FREE_WATER_LEVEL_ORIGIN = row3.RT_FREE_WATER_LEVEL_ORIGIN;
				
				row3_HashRow.RT_WATER_QUANTITY_ORIGIN = row3.RT_WATER_QUANTITY_ORIGIN;
				
				row3_HashRow.RT_TOV = row3.RT_TOV;
				
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
        final DIM_TANK DIM_TANKClass = new DIM_TANK();

        int exitCode = DIM_TANKClass.runJobInTOS(args);

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
            java.io.InputStream inContext = DIM_TANK.class.getClassLoader().getResourceAsStream("pgs_stage/dim_tank_0_1/contexts/" + contextStr + ".properties");
            if (inContext == null) {
                inContext = DIM_TANK.class.getClassLoader().getResourceAsStream("config/contexts/" + contextStr + ".properties");
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
            System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : DIM_TANK");
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
 *     795787 characters generated by Talend Open Studio for Data Integration 
 *     on the 3 août 2024 à 14:42:25 GMT+01:00
 ************************************************************************************************/