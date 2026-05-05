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


package pgs_stage.fact_resources_0_1;

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
 * Job: FACT_RESOURCES Purpose: <br>
 * Description:  <br>
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status 
 */
public class FACT_RESOURCES implements TalendJob {

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
	private final String jobName = "FACT_RESOURCES";
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
				FACT_RESOURCES.this.exception = e;
			}
		}
		if (!(e instanceof TalendException)) {
		try {
			for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
				if (m.getName().compareTo(currentComponent + "_error") == 0) {
					m.invoke(FACT_RESOURCES.this, new Object[] { e , currentComponent, globalMap});
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
			
			public void tDBInput_3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_4_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_5_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
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
			
			public void tDBInput_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
	






public static class out1Struct implements routines.system.IPersistableRow<out1Struct> {
    final static byte[] commonByteArrayLock_PGS_STAGE_FACT_RESOURCES = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_FACT_RESOURCES = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public int FK_BULK_MOVEMENT;

				public int getFK_BULK_MOVEMENT () {
					return this.FK_BULK_MOVEMENT;
				}
				
			    public int FK_BULK_PRODUCT;

				public int getFK_BULK_PRODUCT () {
					return this.FK_BULK_PRODUCT;
				}
				
			    public int FK_CONTAINER;

				public int getFK_CONTAINER () {
					return this.FK_CONTAINER;
				}
				
			    public int FK_COMPARTMENT;

				public int getFK_COMPARTMENT () {
					return this.FK_COMPARTMENT;
				}
				
			    public Integer GROSS_QUANTITY;

				public Integer getGROSS_QUANTITY () {
					return this.GROSS_QUANTITY;
				}
				
			    public Integer NET_QUANTITY;

				public Integer getNET_QUANTITY () {
					return this.NET_QUANTITY;
				}
				
			    public Double DENSITY;

				public Double getDENSITY () {
					return this.DENSITY;
				}
				
			    public Double TEMPERATURE;

				public Double getTEMPERATURE () {
					return this.TEMPERATURE;
				}
				
			    public Integer WEIGHT;

				public Integer getWEIGHT () {
					return this.WEIGHT;
				}
				
			    public Integer WEIGHT_IN_VAC;

				public Integer getWEIGHT_IN_VAC () {
					return this.WEIGHT_IN_VAC;
				}
				
			    public Integer GROSS_FRAC_QUANTITY;

				public Integer getGROSS_FRAC_QUANTITY () {
					return this.GROSS_FRAC_QUANTITY;
				}
				
			    public Integer NET_FRAC_QUANTITY;

				public Integer getNET_FRAC_QUANTITY () {
					return this.NET_FRAC_QUANTITY;
				}
				
			    public Integer FRAC_WEIGHT;

				public Integer getFRAC_WEIGHT () {
					return this.FRAC_WEIGHT;
				}
				
			    public Integer FRAC_WEIGHT_IN_VAC;

				public Integer getFRAC_WEIGHT_IN_VAC () {
					return this.FRAC_WEIGHT_IN_VAC;
				}
				
			    public Integer DECLARED_GROSS_QUANTITY;

				public Integer getDECLARED_GROSS_QUANTITY () {
					return this.DECLARED_GROSS_QUANTITY;
				}
				
			    public Integer DECLARED_GROSS_FRAC_QUANTITY;

				public Integer getDECLARED_GROSS_FRAC_QUANTITY () {
					return this.DECLARED_GROSS_FRAC_QUANTITY;
				}
				
			    public Integer DECLARED_NET_QUANTITY;

				public Integer getDECLARED_NET_QUANTITY () {
					return this.DECLARED_NET_QUANTITY;
				}
				
			    public Integer DECLARED_WEIGHT;

				public Integer getDECLARED_WEIGHT () {
					return this.DECLARED_WEIGHT;
				}
				
			    public Integer DECLARED_FRAC_WEIGHT;

				public Integer getDECLARED_FRAC_WEIGHT () {
					return this.DECLARED_FRAC_WEIGHT;
				}
				
			    public Integer DECLARED_WEIGHT_IN_VAC;

				public Integer getDECLARED_WEIGHT_IN_VAC () {
					return this.DECLARED_WEIGHT_IN_VAC;
				}
				
			    public Integer DECLARED_FRAC_WEIGHT_IN_VAC;

				public Integer getDECLARED_FRAC_WEIGHT_IN_VAC () {
					return this.DECLARED_FRAC_WEIGHT_IN_VAC;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
							result = prime * result + (int) this.FK_BULK_MOVEMENT;
						
							result = prime * result + (int) this.FK_BULK_PRODUCT;
						
							result = prime * result + (int) this.FK_CONTAINER;
						
							result = prime * result + (int) this.FK_COMPARTMENT;
						
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
		
						if (this.FK_BULK_MOVEMENT != other.FK_BULK_MOVEMENT)
							return false;
					
						if (this.FK_BULK_PRODUCT != other.FK_BULK_PRODUCT)
							return false;
					
						if (this.FK_CONTAINER != other.FK_CONTAINER)
							return false;
					
						if (this.FK_COMPARTMENT != other.FK_COMPARTMENT)
							return false;
					

		return true;
    }

	public void copyDataTo(out1Struct other) {

		other.FK_BULK_MOVEMENT = this.FK_BULK_MOVEMENT;
	            other.FK_BULK_PRODUCT = this.FK_BULK_PRODUCT;
	            other.FK_CONTAINER = this.FK_CONTAINER;
	            other.FK_COMPARTMENT = this.FK_COMPARTMENT;
	            other.GROSS_QUANTITY = this.GROSS_QUANTITY;
	            other.NET_QUANTITY = this.NET_QUANTITY;
	            other.DENSITY = this.DENSITY;
	            other.TEMPERATURE = this.TEMPERATURE;
	            other.WEIGHT = this.WEIGHT;
	            other.WEIGHT_IN_VAC = this.WEIGHT_IN_VAC;
	            other.GROSS_FRAC_QUANTITY = this.GROSS_FRAC_QUANTITY;
	            other.NET_FRAC_QUANTITY = this.NET_FRAC_QUANTITY;
	            other.FRAC_WEIGHT = this.FRAC_WEIGHT;
	            other.FRAC_WEIGHT_IN_VAC = this.FRAC_WEIGHT_IN_VAC;
	            other.DECLARED_GROSS_QUANTITY = this.DECLARED_GROSS_QUANTITY;
	            other.DECLARED_GROSS_FRAC_QUANTITY = this.DECLARED_GROSS_FRAC_QUANTITY;
	            other.DECLARED_NET_QUANTITY = this.DECLARED_NET_QUANTITY;
	            other.DECLARED_WEIGHT = this.DECLARED_WEIGHT;
	            other.DECLARED_FRAC_WEIGHT = this.DECLARED_FRAC_WEIGHT;
	            other.DECLARED_WEIGHT_IN_VAC = this.DECLARED_WEIGHT_IN_VAC;
	            other.DECLARED_FRAC_WEIGHT_IN_VAC = this.DECLARED_FRAC_WEIGHT_IN_VAC;
	            
	}

	public void copyKeysDataTo(out1Struct other) {

		other.FK_BULK_MOVEMENT = this.FK_BULK_MOVEMENT;
	            	other.FK_BULK_PRODUCT = this.FK_BULK_PRODUCT;
	            	other.FK_CONTAINER = this.FK_CONTAINER;
	            	other.FK_COMPARTMENT = this.FK_COMPARTMENT;
	            	
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

		synchronized(commonByteArrayLock_PGS_STAGE_FACT_RESOURCES) {

        	try {

        		int length = 0;
		
			        this.FK_BULK_MOVEMENT = dis.readInt();
					
			        this.FK_BULK_PRODUCT = dis.readInt();
					
			        this.FK_CONTAINER = dis.readInt();
					
			        this.FK_COMPARTMENT = dis.readInt();
					
						this.GROSS_QUANTITY = readInteger(dis);
					
						this.NET_QUANTITY = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.DENSITY = null;
           				} else {
           			    	this.DENSITY = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.TEMPERATURE = null;
           				} else {
           			    	this.TEMPERATURE = dis.readDouble();
           				}
					
						this.WEIGHT = readInteger(dis);
					
						this.WEIGHT_IN_VAC = readInteger(dis);
					
						this.GROSS_FRAC_QUANTITY = readInteger(dis);
					
						this.NET_FRAC_QUANTITY = readInteger(dis);
					
						this.FRAC_WEIGHT = readInteger(dis);
					
						this.FRAC_WEIGHT_IN_VAC = readInteger(dis);
					
						this.DECLARED_GROSS_QUANTITY = readInteger(dis);
					
						this.DECLARED_GROSS_FRAC_QUANTITY = readInteger(dis);
					
						this.DECLARED_NET_QUANTITY = readInteger(dis);
					
						this.DECLARED_WEIGHT = readInteger(dis);
					
						this.DECLARED_FRAC_WEIGHT = readInteger(dis);
					
						this.DECLARED_WEIGHT_IN_VAC = readInteger(dis);
					
						this.DECLARED_FRAC_WEIGHT_IN_VAC = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_FACT_RESOURCES) {

        	try {

        		int length = 0;
		
			        this.FK_BULK_MOVEMENT = dis.readInt();
					
			        this.FK_BULK_PRODUCT = dis.readInt();
					
			        this.FK_CONTAINER = dis.readInt();
					
			        this.FK_COMPARTMENT = dis.readInt();
					
						this.GROSS_QUANTITY = readInteger(dis);
					
						this.NET_QUANTITY = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.DENSITY = null;
           				} else {
           			    	this.DENSITY = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.TEMPERATURE = null;
           				} else {
           			    	this.TEMPERATURE = dis.readDouble();
           				}
					
						this.WEIGHT = readInteger(dis);
					
						this.WEIGHT_IN_VAC = readInteger(dis);
					
						this.GROSS_FRAC_QUANTITY = readInteger(dis);
					
						this.NET_FRAC_QUANTITY = readInteger(dis);
					
						this.FRAC_WEIGHT = readInteger(dis);
					
						this.FRAC_WEIGHT_IN_VAC = readInteger(dis);
					
						this.DECLARED_GROSS_QUANTITY = readInteger(dis);
					
						this.DECLARED_GROSS_FRAC_QUANTITY = readInteger(dis);
					
						this.DECLARED_NET_QUANTITY = readInteger(dis);
					
						this.DECLARED_WEIGHT = readInteger(dis);
					
						this.DECLARED_FRAC_WEIGHT = readInteger(dis);
					
						this.DECLARED_WEIGHT_IN_VAC = readInteger(dis);
					
						this.DECLARED_FRAC_WEIGHT_IN_VAC = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.FK_BULK_MOVEMENT);
					
					// int
				
		            	dos.writeInt(this.FK_BULK_PRODUCT);
					
					// int
				
		            	dos.writeInt(this.FK_CONTAINER);
					
					// int
				
		            	dos.writeInt(this.FK_COMPARTMENT);
					
					// Integer
				
						writeInteger(this.GROSS_QUANTITY,dos);
					
					// Integer
				
						writeInteger(this.NET_QUANTITY,dos);
					
					// Double
				
						if(this.DENSITY == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.DENSITY);
		            	}
					
					// Double
				
						if(this.TEMPERATURE == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.TEMPERATURE);
		            	}
					
					// Integer
				
						writeInteger(this.WEIGHT,dos);
					
					// Integer
				
						writeInteger(this.WEIGHT_IN_VAC,dos);
					
					// Integer
				
						writeInteger(this.GROSS_FRAC_QUANTITY,dos);
					
					// Integer
				
						writeInteger(this.NET_FRAC_QUANTITY,dos);
					
					// Integer
				
						writeInteger(this.FRAC_WEIGHT,dos);
					
					// Integer
				
						writeInteger(this.FRAC_WEIGHT_IN_VAC,dos);
					
					// Integer
				
						writeInteger(this.DECLARED_GROSS_QUANTITY,dos);
					
					// Integer
				
						writeInteger(this.DECLARED_GROSS_FRAC_QUANTITY,dos);
					
					// Integer
				
						writeInteger(this.DECLARED_NET_QUANTITY,dos);
					
					// Integer
				
						writeInteger(this.DECLARED_WEIGHT,dos);
					
					// Integer
				
						writeInteger(this.DECLARED_FRAC_WEIGHT,dos);
					
					// Integer
				
						writeInteger(this.DECLARED_WEIGHT_IN_VAC,dos);
					
					// Integer
				
						writeInteger(this.DECLARED_FRAC_WEIGHT_IN_VAC,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.FK_BULK_MOVEMENT);
					
					// int
				
		            	dos.writeInt(this.FK_BULK_PRODUCT);
					
					// int
				
		            	dos.writeInt(this.FK_CONTAINER);
					
					// int
				
		            	dos.writeInt(this.FK_COMPARTMENT);
					
					// Integer
				
						writeInteger(this.GROSS_QUANTITY,dos);
					
					// Integer
				
						writeInteger(this.NET_QUANTITY,dos);
					
					// Double
				
						if(this.DENSITY == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.DENSITY);
		            	}
					
					// Double
				
						if(this.TEMPERATURE == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.TEMPERATURE);
		            	}
					
					// Integer
				
						writeInteger(this.WEIGHT,dos);
					
					// Integer
				
						writeInteger(this.WEIGHT_IN_VAC,dos);
					
					// Integer
				
						writeInteger(this.GROSS_FRAC_QUANTITY,dos);
					
					// Integer
				
						writeInteger(this.NET_FRAC_QUANTITY,dos);
					
					// Integer
				
						writeInteger(this.FRAC_WEIGHT,dos);
					
					// Integer
				
						writeInteger(this.FRAC_WEIGHT_IN_VAC,dos);
					
					// Integer
				
						writeInteger(this.DECLARED_GROSS_QUANTITY,dos);
					
					// Integer
				
						writeInteger(this.DECLARED_GROSS_FRAC_QUANTITY,dos);
					
					// Integer
				
						writeInteger(this.DECLARED_NET_QUANTITY,dos);
					
					// Integer
				
						writeInteger(this.DECLARED_WEIGHT,dos);
					
					// Integer
				
						writeInteger(this.DECLARED_FRAC_WEIGHT,dos);
					
					// Integer
				
						writeInteger(this.DECLARED_WEIGHT_IN_VAC,dos);
					
					// Integer
				
						writeInteger(this.DECLARED_FRAC_WEIGHT_IN_VAC,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("FK_BULK_MOVEMENT="+String.valueOf(FK_BULK_MOVEMENT));
		sb.append(",FK_BULK_PRODUCT="+String.valueOf(FK_BULK_PRODUCT));
		sb.append(",FK_CONTAINER="+String.valueOf(FK_CONTAINER));
		sb.append(",FK_COMPARTMENT="+String.valueOf(FK_COMPARTMENT));
		sb.append(",GROSS_QUANTITY="+String.valueOf(GROSS_QUANTITY));
		sb.append(",NET_QUANTITY="+String.valueOf(NET_QUANTITY));
		sb.append(",DENSITY="+String.valueOf(DENSITY));
		sb.append(",TEMPERATURE="+String.valueOf(TEMPERATURE));
		sb.append(",WEIGHT="+String.valueOf(WEIGHT));
		sb.append(",WEIGHT_IN_VAC="+String.valueOf(WEIGHT_IN_VAC));
		sb.append(",GROSS_FRAC_QUANTITY="+String.valueOf(GROSS_FRAC_QUANTITY));
		sb.append(",NET_FRAC_QUANTITY="+String.valueOf(NET_FRAC_QUANTITY));
		sb.append(",FRAC_WEIGHT="+String.valueOf(FRAC_WEIGHT));
		sb.append(",FRAC_WEIGHT_IN_VAC="+String.valueOf(FRAC_WEIGHT_IN_VAC));
		sb.append(",DECLARED_GROSS_QUANTITY="+String.valueOf(DECLARED_GROSS_QUANTITY));
		sb.append(",DECLARED_GROSS_FRAC_QUANTITY="+String.valueOf(DECLARED_GROSS_FRAC_QUANTITY));
		sb.append(",DECLARED_NET_QUANTITY="+String.valueOf(DECLARED_NET_QUANTITY));
		sb.append(",DECLARED_WEIGHT="+String.valueOf(DECLARED_WEIGHT));
		sb.append(",DECLARED_FRAC_WEIGHT="+String.valueOf(DECLARED_FRAC_WEIGHT));
		sb.append(",DECLARED_WEIGHT_IN_VAC="+String.valueOf(DECLARED_WEIGHT_IN_VAC));
		sb.append(",DECLARED_FRAC_WEIGHT_IN_VAC="+String.valueOf(DECLARED_FRAC_WEIGHT_IN_VAC));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(out1Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.FK_BULK_MOVEMENT, other.FK_BULK_MOVEMENT);
						if(returnValue != 0) {
							return returnValue;
						}

					
						returnValue = checkNullsAndCompare(this.FK_BULK_PRODUCT, other.FK_BULK_PRODUCT);
						if(returnValue != 0) {
							return returnValue;
						}

					
						returnValue = checkNullsAndCompare(this.FK_CONTAINER, other.FK_CONTAINER);
						if(returnValue != 0) {
							return returnValue;
						}

					
						returnValue = checkNullsAndCompare(this.FK_COMPARTMENT, other.FK_COMPARTMENT);
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
    final static byte[] commonByteArrayLock_PGS_STAGE_FACT_RESOURCES = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_FACT_RESOURCES = new byte[0];

	
			    public int PK_BULK_MOVEMENT;

				public int getPK_BULK_MOVEMENT () {
					return this.PK_BULK_MOVEMENT;
				}
				
			    public int BULK_MOVEMENT_ID;

				public int getBULK_MOVEMENT_ID () {
					return this.BULK_MOVEMENT_ID;
				}
				
			    public String FOLIO_NUMBER;

				public String getFOLIO_NUMBER () {
					return this.FOLIO_NUMBER;
				}
				
			    public java.util.Date DATE;

				public java.util.Date getDATE () {
					return this.DATE;
				}
				
			    public Integer FROM_SUPPLIER_NUMBER;

				public Integer getFROM_SUPPLIER_NUMBER () {
					return this.FROM_SUPPLIER_NUMBER;
				}
				
			    public int TYPE;

				public int getTYPE () {
					return this.TYPE;
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
				
			    public String REMARKS;

				public String getREMARKS () {
					return this.REMARKS;
				}
				
			    public java.util.Date MOVEMENT_DATE;

				public java.util.Date getMOVEMENT_DATE () {
					return this.MOVEMENT_DATE;
				}
				
			    public String LAST_USER_NAME;

				public String getLAST_USER_NAME () {
					return this.LAST_USER_NAME;
				}
				
			    public java.util.Date LAST_MODIFIED;

				public java.util.Date getLAST_MODIFIED () {
					return this.LAST_MODIFIED;
				}
				
			    public int AIC_STATUS;

				public int getAIC_STATUS () {
					return this.AIC_STATUS;
				}
				
			    public Integer ORIG_BULK_MOVEMENT_ID;

				public Integer getORIG_BULK_MOVEMENT_ID () {
					return this.ORIG_BULK_MOVEMENT_ID;
				}
				
			    public Integer PREV_BULK_MOVEMENT_ID;

				public Integer getPREV_BULK_MOVEMENT_ID () {
					return this.PREV_BULK_MOVEMENT_ID;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PGS_STAGE_FACT_RESOURCES.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_FACT_RESOURCES.length == 0) {
   					commonByteArray_PGS_STAGE_FACT_RESOURCES = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_FACT_RESOURCES = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PGS_STAGE_FACT_RESOURCES, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_FACT_RESOURCES, 0, length, utf8Charset);
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
			if(length > commonByteArray_PGS_STAGE_FACT_RESOURCES.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_FACT_RESOURCES.length == 0) {
   					commonByteArray_PGS_STAGE_FACT_RESOURCES = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_FACT_RESOURCES = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PGS_STAGE_FACT_RESOURCES, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_FACT_RESOURCES, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PGS_STAGE_FACT_RESOURCES) {

        	try {

        		int length = 0;
		
			        this.PK_BULK_MOVEMENT = dis.readInt();
					
			        this.BULK_MOVEMENT_ID = dis.readInt();
					
					this.FOLIO_NUMBER = readString(dis);
					
					this.DATE = readDate(dis);
					
						this.FROM_SUPPLIER_NUMBER = readInteger(dis);
					
			        this.TYPE = dis.readInt();
					
			        this.MOVEMENT_NUMBER = dis.readInt();
					
			        this.REVISION_NUMBER = dis.readInt();
					
			        this.REVISED = dis.readInt();
					
			        this.STATUS = dis.readInt();
					
					this.STATUS_DATE = readDate(dis);
					
					this.REMARKS = readString(dis);
					
					this.MOVEMENT_DATE = readDate(dis);
					
					this.LAST_USER_NAME = readString(dis);
					
					this.LAST_MODIFIED = readDate(dis);
					
			        this.AIC_STATUS = dis.readInt();
					
						this.ORIG_BULK_MOVEMENT_ID = readInteger(dis);
					
						this.PREV_BULK_MOVEMENT_ID = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_FACT_RESOURCES) {

        	try {

        		int length = 0;
		
			        this.PK_BULK_MOVEMENT = dis.readInt();
					
			        this.BULK_MOVEMENT_ID = dis.readInt();
					
					this.FOLIO_NUMBER = readString(dis);
					
					this.DATE = readDate(dis);
					
						this.FROM_SUPPLIER_NUMBER = readInteger(dis);
					
			        this.TYPE = dis.readInt();
					
			        this.MOVEMENT_NUMBER = dis.readInt();
					
			        this.REVISION_NUMBER = dis.readInt();
					
			        this.REVISED = dis.readInt();
					
			        this.STATUS = dis.readInt();
					
					this.STATUS_DATE = readDate(dis);
					
					this.REMARKS = readString(dis);
					
					this.MOVEMENT_DATE = readDate(dis);
					
					this.LAST_USER_NAME = readString(dis);
					
					this.LAST_MODIFIED = readDate(dis);
					
			        this.AIC_STATUS = dis.readInt();
					
						this.ORIG_BULK_MOVEMENT_ID = readInteger(dis);
					
						this.PREV_BULK_MOVEMENT_ID = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.PK_BULK_MOVEMENT);
					
					// int
				
		            	dos.writeInt(this.BULK_MOVEMENT_ID);
					
					// String
				
						writeString(this.FOLIO_NUMBER,dos);
					
					// java.util.Date
				
						writeDate(this.DATE,dos);
					
					// Integer
				
						writeInteger(this.FROM_SUPPLIER_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.TYPE);
					
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
					
					// String
				
						writeString(this.REMARKS,dos);
					
					// java.util.Date
				
						writeDate(this.MOVEMENT_DATE,dos);
					
					// String
				
						writeString(this.LAST_USER_NAME,dos);
					
					// java.util.Date
				
						writeDate(this.LAST_MODIFIED,dos);
					
					// int
				
		            	dos.writeInt(this.AIC_STATUS);
					
					// Integer
				
						writeInteger(this.ORIG_BULK_MOVEMENT_ID,dos);
					
					// Integer
				
						writeInteger(this.PREV_BULK_MOVEMENT_ID,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.PK_BULK_MOVEMENT);
					
					// int
				
		            	dos.writeInt(this.BULK_MOVEMENT_ID);
					
					// String
				
						writeString(this.FOLIO_NUMBER,dos);
					
					// java.util.Date
				
						writeDate(this.DATE,dos);
					
					// Integer
				
						writeInteger(this.FROM_SUPPLIER_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.TYPE);
					
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
					
					// String
				
						writeString(this.REMARKS,dos);
					
					// java.util.Date
				
						writeDate(this.MOVEMENT_DATE,dos);
					
					// String
				
						writeString(this.LAST_USER_NAME,dos);
					
					// java.util.Date
				
						writeDate(this.LAST_MODIFIED,dos);
					
					// int
				
		            	dos.writeInt(this.AIC_STATUS);
					
					// Integer
				
						writeInteger(this.ORIG_BULK_MOVEMENT_ID,dos);
					
					// Integer
				
						writeInteger(this.PREV_BULK_MOVEMENT_ID,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("PK_BULK_MOVEMENT="+String.valueOf(PK_BULK_MOVEMENT));
		sb.append(",BULK_MOVEMENT_ID="+String.valueOf(BULK_MOVEMENT_ID));
		sb.append(",FOLIO_NUMBER="+FOLIO_NUMBER);
		sb.append(",DATE="+String.valueOf(DATE));
		sb.append(",FROM_SUPPLIER_NUMBER="+String.valueOf(FROM_SUPPLIER_NUMBER));
		sb.append(",TYPE="+String.valueOf(TYPE));
		sb.append(",MOVEMENT_NUMBER="+String.valueOf(MOVEMENT_NUMBER));
		sb.append(",REVISION_NUMBER="+String.valueOf(REVISION_NUMBER));
		sb.append(",REVISED="+String.valueOf(REVISED));
		sb.append(",STATUS="+String.valueOf(STATUS));
		sb.append(",STATUS_DATE="+String.valueOf(STATUS_DATE));
		sb.append(",REMARKS="+REMARKS);
		sb.append(",MOVEMENT_DATE="+String.valueOf(MOVEMENT_DATE));
		sb.append(",LAST_USER_NAME="+LAST_USER_NAME);
		sb.append(",LAST_MODIFIED="+String.valueOf(LAST_MODIFIED));
		sb.append(",AIC_STATUS="+String.valueOf(AIC_STATUS));
		sb.append(",ORIG_BULK_MOVEMENT_ID="+String.valueOf(ORIG_BULK_MOVEMENT_ID));
		sb.append(",PREV_BULK_MOVEMENT_ID="+String.valueOf(PREV_BULK_MOVEMENT_ID));
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
    final static byte[] commonByteArrayLock_PGS_STAGE_FACT_RESOURCES = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_FACT_RESOURCES = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public int PK_BULK_MOVEMENT;

				public int getPK_BULK_MOVEMENT () {
					return this.PK_BULK_MOVEMENT;
				}
				
			    public int BULK_MOVEMENT_ID;

				public int getBULK_MOVEMENT_ID () {
					return this.BULK_MOVEMENT_ID;
				}
				
			    public String FOLIO_NUMBER;

				public String getFOLIO_NUMBER () {
					return this.FOLIO_NUMBER;
				}
				
			    public java.util.Date DATE;

				public java.util.Date getDATE () {
					return this.DATE;
				}
				
			    public Integer FROM_SUPPLIER_NUMBER;

				public Integer getFROM_SUPPLIER_NUMBER () {
					return this.FROM_SUPPLIER_NUMBER;
				}
				
			    public int TYPE;

				public int getTYPE () {
					return this.TYPE;
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
				
			    public String REMARKS;

				public String getREMARKS () {
					return this.REMARKS;
				}
				
			    public java.util.Date MOVEMENT_DATE;

				public java.util.Date getMOVEMENT_DATE () {
					return this.MOVEMENT_DATE;
				}
				
			    public String LAST_USER_NAME;

				public String getLAST_USER_NAME () {
					return this.LAST_USER_NAME;
				}
				
			    public java.util.Date LAST_MODIFIED;

				public java.util.Date getLAST_MODIFIED () {
					return this.LAST_MODIFIED;
				}
				
			    public int AIC_STATUS;

				public int getAIC_STATUS () {
					return this.AIC_STATUS;
				}
				
			    public Integer ORIG_BULK_MOVEMENT_ID;

				public Integer getORIG_BULK_MOVEMENT_ID () {
					return this.ORIG_BULK_MOVEMENT_ID;
				}
				
			    public Integer PREV_BULK_MOVEMENT_ID;

				public Integer getPREV_BULK_MOVEMENT_ID () {
					return this.PREV_BULK_MOVEMENT_ID;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
							result = prime * result + (int) this.PK_BULK_MOVEMENT;
						
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
		
						if (this.PK_BULK_MOVEMENT != other.PK_BULK_MOVEMENT)
							return false;
					

		return true;
    }

	public void copyDataTo(after_tDBInput_1Struct other) {

		other.PK_BULK_MOVEMENT = this.PK_BULK_MOVEMENT;
	            other.BULK_MOVEMENT_ID = this.BULK_MOVEMENT_ID;
	            other.FOLIO_NUMBER = this.FOLIO_NUMBER;
	            other.DATE = this.DATE;
	            other.FROM_SUPPLIER_NUMBER = this.FROM_SUPPLIER_NUMBER;
	            other.TYPE = this.TYPE;
	            other.MOVEMENT_NUMBER = this.MOVEMENT_NUMBER;
	            other.REVISION_NUMBER = this.REVISION_NUMBER;
	            other.REVISED = this.REVISED;
	            other.STATUS = this.STATUS;
	            other.STATUS_DATE = this.STATUS_DATE;
	            other.REMARKS = this.REMARKS;
	            other.MOVEMENT_DATE = this.MOVEMENT_DATE;
	            other.LAST_USER_NAME = this.LAST_USER_NAME;
	            other.LAST_MODIFIED = this.LAST_MODIFIED;
	            other.AIC_STATUS = this.AIC_STATUS;
	            other.ORIG_BULK_MOVEMENT_ID = this.ORIG_BULK_MOVEMENT_ID;
	            other.PREV_BULK_MOVEMENT_ID = this.PREV_BULK_MOVEMENT_ID;
	            
	}

	public void copyKeysDataTo(after_tDBInput_1Struct other) {

		other.PK_BULK_MOVEMENT = this.PK_BULK_MOVEMENT;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PGS_STAGE_FACT_RESOURCES.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_FACT_RESOURCES.length == 0) {
   					commonByteArray_PGS_STAGE_FACT_RESOURCES = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_FACT_RESOURCES = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PGS_STAGE_FACT_RESOURCES, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_FACT_RESOURCES, 0, length, utf8Charset);
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
			if(length > commonByteArray_PGS_STAGE_FACT_RESOURCES.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_FACT_RESOURCES.length == 0) {
   					commonByteArray_PGS_STAGE_FACT_RESOURCES = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_FACT_RESOURCES = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PGS_STAGE_FACT_RESOURCES, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_FACT_RESOURCES, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PGS_STAGE_FACT_RESOURCES) {

        	try {

        		int length = 0;
		
			        this.PK_BULK_MOVEMENT = dis.readInt();
					
			        this.BULK_MOVEMENT_ID = dis.readInt();
					
					this.FOLIO_NUMBER = readString(dis);
					
					this.DATE = readDate(dis);
					
						this.FROM_SUPPLIER_NUMBER = readInteger(dis);
					
			        this.TYPE = dis.readInt();
					
			        this.MOVEMENT_NUMBER = dis.readInt();
					
			        this.REVISION_NUMBER = dis.readInt();
					
			        this.REVISED = dis.readInt();
					
			        this.STATUS = dis.readInt();
					
					this.STATUS_DATE = readDate(dis);
					
					this.REMARKS = readString(dis);
					
					this.MOVEMENT_DATE = readDate(dis);
					
					this.LAST_USER_NAME = readString(dis);
					
					this.LAST_MODIFIED = readDate(dis);
					
			        this.AIC_STATUS = dis.readInt();
					
						this.ORIG_BULK_MOVEMENT_ID = readInteger(dis);
					
						this.PREV_BULK_MOVEMENT_ID = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_FACT_RESOURCES) {

        	try {

        		int length = 0;
		
			        this.PK_BULK_MOVEMENT = dis.readInt();
					
			        this.BULK_MOVEMENT_ID = dis.readInt();
					
					this.FOLIO_NUMBER = readString(dis);
					
					this.DATE = readDate(dis);
					
						this.FROM_SUPPLIER_NUMBER = readInteger(dis);
					
			        this.TYPE = dis.readInt();
					
			        this.MOVEMENT_NUMBER = dis.readInt();
					
			        this.REVISION_NUMBER = dis.readInt();
					
			        this.REVISED = dis.readInt();
					
			        this.STATUS = dis.readInt();
					
					this.STATUS_DATE = readDate(dis);
					
					this.REMARKS = readString(dis);
					
					this.MOVEMENT_DATE = readDate(dis);
					
					this.LAST_USER_NAME = readString(dis);
					
					this.LAST_MODIFIED = readDate(dis);
					
			        this.AIC_STATUS = dis.readInt();
					
						this.ORIG_BULK_MOVEMENT_ID = readInteger(dis);
					
						this.PREV_BULK_MOVEMENT_ID = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.PK_BULK_MOVEMENT);
					
					// int
				
		            	dos.writeInt(this.BULK_MOVEMENT_ID);
					
					// String
				
						writeString(this.FOLIO_NUMBER,dos);
					
					// java.util.Date
				
						writeDate(this.DATE,dos);
					
					// Integer
				
						writeInteger(this.FROM_SUPPLIER_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.TYPE);
					
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
					
					// String
				
						writeString(this.REMARKS,dos);
					
					// java.util.Date
				
						writeDate(this.MOVEMENT_DATE,dos);
					
					// String
				
						writeString(this.LAST_USER_NAME,dos);
					
					// java.util.Date
				
						writeDate(this.LAST_MODIFIED,dos);
					
					// int
				
		            	dos.writeInt(this.AIC_STATUS);
					
					// Integer
				
						writeInteger(this.ORIG_BULK_MOVEMENT_ID,dos);
					
					// Integer
				
						writeInteger(this.PREV_BULK_MOVEMENT_ID,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.PK_BULK_MOVEMENT);
					
					// int
				
		            	dos.writeInt(this.BULK_MOVEMENT_ID);
					
					// String
				
						writeString(this.FOLIO_NUMBER,dos);
					
					// java.util.Date
				
						writeDate(this.DATE,dos);
					
					// Integer
				
						writeInteger(this.FROM_SUPPLIER_NUMBER,dos);
					
					// int
				
		            	dos.writeInt(this.TYPE);
					
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
					
					// String
				
						writeString(this.REMARKS,dos);
					
					// java.util.Date
				
						writeDate(this.MOVEMENT_DATE,dos);
					
					// String
				
						writeString(this.LAST_USER_NAME,dos);
					
					// java.util.Date
				
						writeDate(this.LAST_MODIFIED,dos);
					
					// int
				
		            	dos.writeInt(this.AIC_STATUS);
					
					// Integer
				
						writeInteger(this.ORIG_BULK_MOVEMENT_ID,dos);
					
					// Integer
				
						writeInteger(this.PREV_BULK_MOVEMENT_ID,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("PK_BULK_MOVEMENT="+String.valueOf(PK_BULK_MOVEMENT));
		sb.append(",BULK_MOVEMENT_ID="+String.valueOf(BULK_MOVEMENT_ID));
		sb.append(",FOLIO_NUMBER="+FOLIO_NUMBER);
		sb.append(",DATE="+String.valueOf(DATE));
		sb.append(",FROM_SUPPLIER_NUMBER="+String.valueOf(FROM_SUPPLIER_NUMBER));
		sb.append(",TYPE="+String.valueOf(TYPE));
		sb.append(",MOVEMENT_NUMBER="+String.valueOf(MOVEMENT_NUMBER));
		sb.append(",REVISION_NUMBER="+String.valueOf(REVISION_NUMBER));
		sb.append(",REVISED="+String.valueOf(REVISED));
		sb.append(",STATUS="+String.valueOf(STATUS));
		sb.append(",STATUS_DATE="+String.valueOf(STATUS_DATE));
		sb.append(",REMARKS="+REMARKS);
		sb.append(",MOVEMENT_DATE="+String.valueOf(MOVEMENT_DATE));
		sb.append(",LAST_USER_NAME="+LAST_USER_NAME);
		sb.append(",LAST_MODIFIED="+String.valueOf(LAST_MODIFIED));
		sb.append(",AIC_STATUS="+String.valueOf(AIC_STATUS));
		sb.append(",ORIG_BULK_MOVEMENT_ID="+String.valueOf(ORIG_BULK_MOVEMENT_ID));
		sb.append(",PREV_BULK_MOVEMENT_ID="+String.valueOf(PREV_BULK_MOVEMENT_ID));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(after_tDBInput_1Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.PK_BULK_MOVEMENT, other.PK_BULK_MOVEMENT);
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
		tDBInput_3Process(globalMap);
		tDBInput_4Process(globalMap);
		tDBInput_5Process(globalMap);

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



        int insertKeyCount_tDBOutput_1 = 4;
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

 
	final String decryptedPassword_tDBOutput_1 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:BKIsi7PF0/AH5hTIUSNDG84qPT+YWCO2MW9q05uGnTTwNANdsH8=");

    String dbPwd_tDBOutput_1 = decryptedPassword_tDBOutput_1;	
    conn_tDBOutput_1 = java.sql.DriverManager.getConnection(url_tDBOutput_1,dbUser_tDBOutput_1,dbPwd_tDBOutput_1);
	
		resourceMap.put("conn_tDBOutput_1", conn_tDBOutput_1);
	
        conn_tDBOutput_1.setAutoCommit(false);
        int commitEvery_tDBOutput_1 = 10000;
        int commitCounter_tDBOutput_1 = 0;


if(dbschema_tDBOutput_1 == null || dbschema_tDBOutput_1.trim().length() == 0) {
    tableName_tDBOutput_1 = "FACT_RESOURCES";
} else {
    tableName_tDBOutput_1 = dbschema_tDBOutput_1 + "].[" + "FACT_RESOURCES";
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
                                        stmtCreate_tDBOutput_1.execute("CREATE TABLE [" + tableName_tDBOutput_1 + "]([FK_BULK_MOVEMENT] INT  not null ,[FK_BULK_PRODUCT] INT  not null ,[FK_CONTAINER] INT  not null ,[FK_COMPARTMENT] INT  not null ,[GROSS_QUANTITY] INT ,[NET_QUANTITY] INT ,[DENSITY] FLOAT(53)  ,[TEMPERATURE] FLOAT(53)  ,[WEIGHT] INT ,[WEIGHT_IN_VAC] INT ,[GROSS_FRAC_QUANTITY] INT ,[NET_FRAC_QUANTITY] INT ,[FRAC_WEIGHT] INT ,[FRAC_WEIGHT_IN_VAC] INT ,[DECLARED_GROSS_QUANTITY] INT ,[DECLARED_GROSS_FRAC_QUANTITY] INT ,[DECLARED_NET_QUANTITY] INT ,[DECLARED_WEIGHT] INT ,[DECLARED_FRAC_WEIGHT] INT ,[DECLARED_WEIGHT_IN_VAC] INT ,[DECLARED_FRAC_WEIGHT_IN_VAC] INT ,primary key([FK_BULK_MOVEMENT],[FK_BULK_PRODUCT],[FK_CONTAINER],[FK_COMPARTMENT]))");
                                    }
                                }
        java.sql.PreparedStatement pstmt_tDBOutput_1 = conn_tDBOutput_1.prepareStatement("SELECT COUNT(1) FROM [" + tableName_tDBOutput_1 + "] WHERE [FK_BULK_MOVEMENT] = ? AND [FK_BULK_PRODUCT] = ? AND [FK_CONTAINER] = ? AND [FK_COMPARTMENT] = ?");
        resourceMap.put("pstmt_tDBOutput_1", pstmt_tDBOutput_1);
        String insert_tDBOutput_1 = "INSERT INTO [" + tableName_tDBOutput_1 + "] ([FK_BULK_MOVEMENT],[FK_BULK_PRODUCT],[FK_CONTAINER],[FK_COMPARTMENT],[GROSS_QUANTITY],[NET_QUANTITY],[DENSITY],[TEMPERATURE],[WEIGHT],[WEIGHT_IN_VAC],[GROSS_FRAC_QUANTITY],[NET_FRAC_QUANTITY],[FRAC_WEIGHT],[FRAC_WEIGHT_IN_VAC],[DECLARED_GROSS_QUANTITY],[DECLARED_GROSS_FRAC_QUANTITY],[DECLARED_NET_QUANTITY],[DECLARED_WEIGHT],[DECLARED_FRAC_WEIGHT],[DECLARED_WEIGHT_IN_VAC],[DECLARED_FRAC_WEIGHT_IN_VAC]) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
// ###############################        

// ###############################
// # Vars initialization
class  Var__tMap_1__Struct  {
	int PK_FACT_RESOURCES;
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
				
				 
	final String decryptedPassword_tDBInput_1 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:9aQ78y4fUIoYwmR9QsBBKhknbSTo+iRMvIQYS23BiV/967XBAWE=");
				
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

		    String dbquery_tDBInput_1 = "SELECT dbo.DIM_BULK_MOVEMENT.PK_BULK_MOVEMENT,\n		dbo.DIM_BULK_MOVEMENT.BULK_MOVEMENT_ID,\n		dbo.DIM_BULK_MOVEMENT.FOLIO_"
+"NUMBER,\n		dbo.DIM_BULK_MOVEMENT.DATE,\n		dbo.DIM_BULK_MOVEMENT.FROM_SUPPLIER_NUMBER,\n		dbo.DIM_BULK_MOVEMENT.TYPE,\n		dbo."
+"DIM_BULK_MOVEMENT.MOVEMENT_NUMBER,\n		dbo.DIM_BULK_MOVEMENT.REVISION_NUMBER,\n		dbo.DIM_BULK_MOVEMENT.REVISED,\n		dbo.DIM_B"
+"ULK_MOVEMENT.STATUS,\n		dbo.DIM_BULK_MOVEMENT.STATUS_DATE,\n		dbo.DIM_BULK_MOVEMENT.REMARKS,\n		dbo.DIM_BULK_MOVEMENT.MOVEM"
+"ENT_DATE,\n		dbo.DIM_BULK_MOVEMENT.LAST_USER_NAME,\n		dbo.DIM_BULK_MOVEMENT.LAST_MODIFIED,\n		dbo.DIM_BULK_MOVEMENT.AIC_STA"
+"TUS,\n		dbo.DIM_BULK_MOVEMENT.ORIG_BULK_MOVEMENT_ID,\n		dbo.DIM_BULK_MOVEMENT.PREV_BULK_MOVEMENT_ID\nFROM	dbo.DIM_BULK_MOVE"
+"MENT";
		    

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
								row1.PK_BULK_MOVEMENT = 0;
							} else {
		                          
            row1.PK_BULK_MOVEMENT = rs_tDBInput_1.getInt(1);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 2) {
								row1.BULK_MOVEMENT_ID = 0;
							} else {
		                          
            row1.BULK_MOVEMENT_ID = rs_tDBInput_1.getInt(2);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 3) {
								row1.FOLIO_NUMBER = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(3);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(3).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.FOLIO_NUMBER = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.FOLIO_NUMBER = tmpContent_tDBInput_1;
                }
            } else {
                row1.FOLIO_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 4) {
								row1.DATE = null;
							} else {
										
			row1.DATE = mssqlGTU_tDBInput_1.getDate(rsmd_tDBInput_1, rs_tDBInput_1, 4);
			
		                    }
							if(colQtyInRs_tDBInput_1 < 5) {
								row1.FROM_SUPPLIER_NUMBER = null;
							} else {
		                          
            row1.FROM_SUPPLIER_NUMBER = rs_tDBInput_1.getInt(5);
            if(rs_tDBInput_1.wasNull()){
                    row1.FROM_SUPPLIER_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 6) {
								row1.TYPE = 0;
							} else {
		                          
            row1.TYPE = rs_tDBInput_1.getInt(6);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 7) {
								row1.MOVEMENT_NUMBER = 0;
							} else {
		                          
            row1.MOVEMENT_NUMBER = rs_tDBInput_1.getInt(7);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 8) {
								row1.REVISION_NUMBER = 0;
							} else {
		                          
            row1.REVISION_NUMBER = rs_tDBInput_1.getInt(8);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 9) {
								row1.REVISED = 0;
							} else {
		                          
            row1.REVISED = rs_tDBInput_1.getInt(9);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 10) {
								row1.STATUS = 0;
							} else {
		                          
            row1.STATUS = rs_tDBInput_1.getInt(10);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 11) {
								row1.STATUS_DATE = null;
							} else {
										
			row1.STATUS_DATE = mssqlGTU_tDBInput_1.getDate(rsmd_tDBInput_1, rs_tDBInput_1, 11);
			
		                    }
							if(colQtyInRs_tDBInput_1 < 12) {
								row1.REMARKS = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(12);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(12).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.REMARKS = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.REMARKS = tmpContent_tDBInput_1;
                }
            } else {
                row1.REMARKS = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 13) {
								row1.MOVEMENT_DATE = null;
							} else {
										
			row1.MOVEMENT_DATE = mssqlGTU_tDBInput_1.getDate(rsmd_tDBInput_1, rs_tDBInput_1, 13);
			
		                    }
							if(colQtyInRs_tDBInput_1 < 14) {
								row1.LAST_USER_NAME = null;
							} else {
	                         		
           		tmpContent_tDBInput_1 = rs_tDBInput_1.getString(14);
            if(tmpContent_tDBInput_1 != null) {
            	if (talendToDBList_tDBInput_1 .contains(rsmd_tDBInput_1.getColumnTypeName(14).toUpperCase(java.util.Locale.ENGLISH))) {
            		row1.LAST_USER_NAME = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
            	} else {
                	row1.LAST_USER_NAME = tmpContent_tDBInput_1;
                }
            } else {
                row1.LAST_USER_NAME = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 15) {
								row1.LAST_MODIFIED = null;
							} else {
										
			row1.LAST_MODIFIED = mssqlGTU_tDBInput_1.getDate(rsmd_tDBInput_1, rs_tDBInput_1, 15);
			
		                    }
							if(colQtyInRs_tDBInput_1 < 16) {
								row1.AIC_STATUS = 0;
							} else {
		                          
            row1.AIC_STATUS = rs_tDBInput_1.getInt(16);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 17) {
								row1.ORIG_BULK_MOVEMENT_ID = null;
							} else {
		                          
            row1.ORIG_BULK_MOVEMENT_ID = rs_tDBInput_1.getInt(17);
            if(rs_tDBInput_1.wasNull()){
                    row1.ORIG_BULK_MOVEMENT_ID = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 18) {
								row1.PREV_BULK_MOVEMENT_ID = null;
							} else {
		                          
            row1.PREV_BULK_MOVEMENT_ID = rs_tDBInput_1.getInt(18);
            if(rs_tDBInput_1.wasNull()){
                    row1.PREV_BULK_MOVEMENT_ID = null;
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
								
	                        		    	Object exprKeyValue_row2__BULK_MOVEMENT_ID = row1.BULK_MOVEMENT_ID ;
	                        		    	if(exprKeyValue_row2__BULK_MOVEMENT_ID == null) {
	                        		    		hasCasePrimitiveKeyWithNull_tMap_1 = true;
	                        		    	} else {
                        		    			row2HashKey.BULK_MOVEMENT_ID = (int)(Integer) exprKeyValue_row2__BULK_MOVEMENT_ID;
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
								
	                        		    	Object exprKeyValue_row3__BULK_MOVEMENT_ID = row2.BULK_MOVEMENT_ID ;
	                        		    	if(exprKeyValue_row3__BULK_MOVEMENT_ID == null) {
	                        		    		hasCasePrimitiveKeyWithNull_tMap_1 = true;
	                        		    	} else {
                        		    			row3HashKey.BULK_MOVEMENT_ID = (int)(Integer) exprKeyValue_row3__BULK_MOVEMENT_ID;
                        		    		}
                        		    		
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
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row3' and it contains more one result from keys :  row3.BULK_MOVEMENT_ID = '" + row3HashKey.BULK_MOVEMENT_ID + "', row3.BULK_PRODUCT_ID = '" + row3HashKey.BULK_PRODUCT_ID + "'");
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
								
                        		    		    row4HashKey.CONTAINER_CODE = row2.CONTAINER_CODE ;
                        		    		

								
		                        	row4HashKey.hashCodeDirty = true;
                        		
	  					
	  							
			  					
			  					
	  					
		  							tHash_Lookup_row4.lookup( row4HashKey );

	  							

	  							

 								
								  
								  if(!tHash_Lookup_row4.hasNext()) { // G_TM_M_090

  								
		  				
	  								
			  							rejectedInnerJoin_tMap_1 = true;
	  								
						
									
	
		  								forceLooprow4 = true;
	  					
  									
  									  		
 								
								  
								  } // G_TM_M_090

  								



							} // G_TM_M_020
			           		  	  
							
								
								else { // G 20 - G 21
   									forceLooprow4 = true;
			           		  	} // G 21
                    		  	
                    		

							row4Struct row4 = null;
                    		  	 
							

								while ((tHash_Lookup_row4 != null && tHash_Lookup_row4.hasNext()) || forceLooprow4) { // G_TM_M_043

								
									 // CALL close loop of lookup 'row4'
									
                    		  	 
							   
                    		  	 
	       		  	    	row4Struct fromLookup_row4 = null;
							row4 = row4Default;
										 
							
								
								if(!forceLooprow4) { // G 46
								
							
								 
							
								
								fromLookup_row4 = tHash_Lookup_row4.next();

							

							if(fromLookup_row4 != null) {
								row4 = fromLookup_row4;
							}
							
							
							
			  							
								
	                    		  	
		                    
	                    	
	                    		} // G 46
	                    		  	
								forceLooprow4 = false;
									 	
							
	            	
	           	
	            	
	            	
	            

				///////////////////////////////////////////////
				// Starting Lookup Table "row5" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLooprow5 = false;
       		  	    	
       		  	    	
 							row5Struct row5ObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_1) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_1 = false;
								
                        		    		    row5HashKey.CONTAINER_CODE = row4.CONTAINER_CODE ;
                        		    		
	                        		    	Object exprKeyValue_row5__CONTAINER_TYPE = row4.CONTAINER_TYPE ;
	                        		    	if(exprKeyValue_row5__CONTAINER_TYPE == null) {
	                        		    		hasCasePrimitiveKeyWithNull_tMap_1 = true;
	                        		    	} else {
                        		    			row5HashKey.CONTAINER_TYPE = (int)(Integer) exprKeyValue_row5__CONTAINER_TYPE;
                        		    		}
                        		    		
	                        		    	Object exprKeyValue_row5__OWNER_ID = row4.OWNER_ID ;
	                        		    	if(exprKeyValue_row5__OWNER_ID == null) {
	                        		    		hasCasePrimitiveKeyWithNull_tMap_1 = true;
	                        		    	} else {
                        		    			row5HashKey.OWNER_ID = (int)(Integer) exprKeyValue_row5__OWNER_ID;
                        		    		}
                        		    		

								
		                        	row5HashKey.hashCodeDirty = true;
                        		
	  					
	  							
	
		  							if(!hasCasePrimitiveKeyWithNull_tMap_1) { // G_TM_M_091
		  							
			  					
			  					
			  					
	  					
		  							tHash_Lookup_row5.lookup( row5HashKey );

	  							

	  							

			  						} // G_TM_M_091
			  						
			  					

 								
								  
								  if(hasCasePrimitiveKeyWithNull_tMap_1 || !tHash_Lookup_row5.hasNext()) { // G_TM_M_090

  								
		  				
	  								
			  							rejectedInnerJoin_tMap_1 = true;
	  								
						
									
	
		  								forceLooprow5 = true;
	  					
  									
  									  		
 								
								  
								  } // G_TM_M_090

  								



							} // G_TM_M_020
			           		  	  
							
								
								else { // G 20 - G 21
   									forceLooprow5 = true;
			           		  	} // G 21
                    		  	
                    		

							row5Struct row5 = null;
                    		  	 
							

								while ((tHash_Lookup_row5 != null && tHash_Lookup_row5.hasNext()) || forceLooprow5) { // G_TM_M_043

								
									 // CALL close loop of lookup 'row5'
									
                    		  	 
							   
                    		  	 
	       		  	    	row5Struct fromLookup_row5 = null;
							row5 = row5Default;
										 
							
								
								if(!forceLooprow5) { // G 46
								
							
								 
							
								
								fromLookup_row5 = tHash_Lookup_row5.next();

							

							if(fromLookup_row5 != null) {
								row5 = fromLookup_row5;
							}
							
							
							
			  							
								
	                    		  	
		                    
	                    	
	                    		} // G 46
	                    		  	
								forceLooprow5 = false;
									 	
							
	            	
	            	
	            // ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_1__Struct Var = Var__tMap_1;
Var.PK_FACT_RESOURCES = Numeric.sequence("s11",1,1) ;// ###############################
        // ###############################
        // # Output tables

out1 = null;

if(!rejectedInnerJoin_tMap_1 ) {

// # Output table : 'out1'
out1_tmp.FK_BULK_MOVEMENT = row1.PK_BULK_MOVEMENT ;
out1_tmp.FK_BULK_PRODUCT = row2.PK_BULK_PRODUCT ;
out1_tmp.FK_CONTAINER = row4.PK_CONTAINER ;
out1_tmp.FK_COMPARTMENT = row5.PK_COMPARTMENT ;
out1_tmp.GROSS_QUANTITY = row3.GROSS_QUANTITY ;
out1_tmp.NET_QUANTITY = row3.NET_QUANTITY ;
out1_tmp.DENSITY = row3.DENSITY ;
out1_tmp.TEMPERATURE = row3.TEMPERATURE ;
out1_tmp.WEIGHT = row3.WEIGHT ;
out1_tmp.WEIGHT_IN_VAC = row3.WEIGHT_IN_VAC ;
out1_tmp.GROSS_FRAC_QUANTITY = row3.GROSS_FRAC_QUANTITY ;
out1_tmp.NET_FRAC_QUANTITY = row3.NET_FRAC_QUANTITY ;
out1_tmp.FRAC_WEIGHT = row3.FRAC_WEIGHT ;
out1_tmp.FRAC_WEIGHT_IN_VAC = row3.FRAC_WEIGHT_IN_VAC ;
out1_tmp.DECLARED_GROSS_QUANTITY = row3.DECLARED_GROSS_QUANTITY ;
out1_tmp.DECLARED_GROSS_FRAC_QUANTITY = row3.DECLARED_GROSS_FRAC_QUANTITY ;
out1_tmp.DECLARED_NET_QUANTITY = row3.DECLARED_NET_QUANTITY ;
out1_tmp.DECLARED_WEIGHT = row3.DECLARED_WEIGHT ;
out1_tmp.DECLARED_FRAC_WEIGHT = row3.DECLARED_FRAC_WEIGHT ;
out1_tmp.DECLARED_WEIGHT_IN_VAC = row3.DECLARED_WEIGHT_IN_VAC ;
out1_tmp.DECLARED_FRAC_WEIGHT_IN_VAC = row3.DECLARED_FRAC_WEIGHT_IN_VAC ;
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

                pstmt_tDBOutput_1.setInt(1, out1.FK_BULK_MOVEMENT);


                pstmt_tDBOutput_1.setInt(2, out1.FK_BULK_PRODUCT);


                pstmt_tDBOutput_1.setInt(3, out1.FK_CONTAINER);


                pstmt_tDBOutput_1.setInt(4, out1.FK_COMPARTMENT);


        java.sql.ResultSet rs_tDBOutput_1 = pstmt_tDBOutput_1.executeQuery();
        int checkCount_tDBOutput_1 = -1;
        while(rs_tDBOutput_1.next()) {
            checkCount_tDBOutput_1 = rs_tDBOutput_1.getInt(1);
        }

        if (checkCount_tDBOutput_1 < 1) {
                    pstmtInsert_tDBOutput_1.setInt(1, out1.FK_BULK_MOVEMENT);

                    pstmtInsert_tDBOutput_1.setInt(2, out1.FK_BULK_PRODUCT);

                    pstmtInsert_tDBOutput_1.setInt(3, out1.FK_CONTAINER);

                    pstmtInsert_tDBOutput_1.setInt(4, out1.FK_COMPARTMENT);

                    if(out1.GROSS_QUANTITY == null) {
pstmtInsert_tDBOutput_1.setNull(5, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_1.setInt(5, out1.GROSS_QUANTITY);
}

                    if(out1.NET_QUANTITY == null) {
pstmtInsert_tDBOutput_1.setNull(6, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_1.setInt(6, out1.NET_QUANTITY);
}

                    if(out1.DENSITY == null) {
pstmtInsert_tDBOutput_1.setNull(7, java.sql.Types.DOUBLE);
} else {pstmtInsert_tDBOutput_1.setDouble(7, out1.DENSITY);
}

                    if(out1.TEMPERATURE == null) {
pstmtInsert_tDBOutput_1.setNull(8, java.sql.Types.DOUBLE);
} else {pstmtInsert_tDBOutput_1.setDouble(8, out1.TEMPERATURE);
}

                    if(out1.WEIGHT == null) {
pstmtInsert_tDBOutput_1.setNull(9, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_1.setInt(9, out1.WEIGHT);
}

                    if(out1.WEIGHT_IN_VAC == null) {
pstmtInsert_tDBOutput_1.setNull(10, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_1.setInt(10, out1.WEIGHT_IN_VAC);
}

                    if(out1.GROSS_FRAC_QUANTITY == null) {
pstmtInsert_tDBOutput_1.setNull(11, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_1.setInt(11, out1.GROSS_FRAC_QUANTITY);
}

                    if(out1.NET_FRAC_QUANTITY == null) {
pstmtInsert_tDBOutput_1.setNull(12, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_1.setInt(12, out1.NET_FRAC_QUANTITY);
}

                    if(out1.FRAC_WEIGHT == null) {
pstmtInsert_tDBOutput_1.setNull(13, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_1.setInt(13, out1.FRAC_WEIGHT);
}

                    if(out1.FRAC_WEIGHT_IN_VAC == null) {
pstmtInsert_tDBOutput_1.setNull(14, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_1.setInt(14, out1.FRAC_WEIGHT_IN_VAC);
}

                    if(out1.DECLARED_GROSS_QUANTITY == null) {
pstmtInsert_tDBOutput_1.setNull(15, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_1.setInt(15, out1.DECLARED_GROSS_QUANTITY);
}

                    if(out1.DECLARED_GROSS_FRAC_QUANTITY == null) {
pstmtInsert_tDBOutput_1.setNull(16, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_1.setInt(16, out1.DECLARED_GROSS_FRAC_QUANTITY);
}

                    if(out1.DECLARED_NET_QUANTITY == null) {
pstmtInsert_tDBOutput_1.setNull(17, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_1.setInt(17, out1.DECLARED_NET_QUANTITY);
}

                    if(out1.DECLARED_WEIGHT == null) {
pstmtInsert_tDBOutput_1.setNull(18, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_1.setInt(18, out1.DECLARED_WEIGHT);
}

                    if(out1.DECLARED_FRAC_WEIGHT == null) {
pstmtInsert_tDBOutput_1.setNull(19, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_1.setInt(19, out1.DECLARED_FRAC_WEIGHT);
}

                    if(out1.DECLARED_WEIGHT_IN_VAC == null) {
pstmtInsert_tDBOutput_1.setNull(20, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_1.setInt(20, out1.DECLARED_WEIGHT_IN_VAC);
}

                    if(out1.DECLARED_FRAC_WEIGHT_IN_VAC == null) {
pstmtInsert_tDBOutput_1.setNull(21, java.sql.Types.INTEGER);
} else {pstmtInsert_tDBOutput_1.setInt(21, out1.DECLARED_FRAC_WEIGHT_IN_VAC);
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



	
		} // close loop of lookup 'row5' // G_TM_M_043
		
		} // close loop of lookup 'row4' // G_TM_M_043
		
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
    final static byte[] commonByteArrayLock_PGS_STAGE_FACT_RESOURCES = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_FACT_RESOURCES = new byte[0];
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
	
							result = prime * result + (int) this.BULK_MOVEMENT_ID;
						
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
		
						if (this.BULK_MOVEMENT_ID != other.BULK_MOVEMENT_ID)
							return false;
					

		return true;
    }

	public void copyDataTo(row2Struct other) {

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

	public void copyKeysDataTo(row2Struct other) {

		other.BULK_MOVEMENT_ID = this.BULK_MOVEMENT_ID;
	            	
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

		synchronized(commonByteArrayLock_PGS_STAGE_FACT_RESOURCES) {

        	try {

        		int length = 0;
		
			        this.BULK_MOVEMENT_ID = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_FACT_RESOURCES) {

        	try {

        		int length = 0;
		
			        this.BULK_MOVEMENT_ID = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.BULK_MOVEMENT_ID);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.BULK_MOVEMENT_ID);
					
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
					
			            this.BULK_PRODUCT_ID = dis.readInt();
					
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
					
			            this.BULK_PRODUCT_ID = objectIn.readInt();
					
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
					
		            	dos.writeInt(this.BULK_PRODUCT_ID);
					
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
					
					objectOut.writeInt(this.BULK_PRODUCT_ID);
					
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
    public int compareTo(row2Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.BULK_MOVEMENT_ID, other.BULK_MOVEMENT_ID);
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
			   		// linked node: tMap_1 - inputs:(row1,row2,row3,row4,row5) outputs:(out1)
			   
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
				
				 
	final String decryptedPassword_tDBInput_2 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:yTzlb57ylWeZgn+IrVsbV+ZYmcdGoHt8gemMYRdof1/YFqoPosg=");
				
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
								row2.PK_BULK_PRODUCT = 0;
							} else {
		                          
            row2.PK_BULK_PRODUCT = rs_tDBInput_2.getInt(1);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 2) {
								row2.BULK_MOVEMENT_ID = 0;
							} else {
		                          
            row2.BULK_MOVEMENT_ID = rs_tDBInput_2.getInt(2);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 3) {
								row2.BULK_PRODUCT_ID = 0;
							} else {
		                          
            row2.BULK_PRODUCT_ID = rs_tDBInput_2.getInt(3);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 4) {
								row2.TERMINAL_PRODUCT_NUMBER = 0;
							} else {
		                          
            row2.TERMINAL_PRODUCT_NUMBER = rs_tDBInput_2.getInt(4);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 5) {
								row2.CONTAINER_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(5);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(5).toUpperCase(java.util.Locale.ENGLISH))) {
            		row2.CONTAINER_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row2.CONTAINER_CODE = tmpContent_tDBInput_2;
                }
            } else {
                row2.CONTAINER_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 6) {
								row2.SNAPSHOT_TYPE = null;
							} else {
		                          
            row2.SNAPSHOT_TYPE = rs_tDBInput_2.getInt(6);
            if(rs_tDBInput_2.wasNull()){
                    row2.SNAPSHOT_TYPE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 7) {
								row2.FIGURES_TYPE = 0;
							} else {
		                          
            row2.FIGURES_TYPE = rs_tDBInput_2.getInt(7);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 8) {
								row2.LAST_USER_NAME = null;
							} else {
	                         		
           		tmpContent_tDBInput_2 = rs_tDBInput_2.getString(8);
            if(tmpContent_tDBInput_2 != null) {
            	if (talendToDBList_tDBInput_2 .contains(rsmd_tDBInput_2.getColumnTypeName(8).toUpperCase(java.util.Locale.ENGLISH))) {
            		row2.LAST_USER_NAME = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
            	} else {
                	row2.LAST_USER_NAME = tmpContent_tDBInput_2;
                }
            } else {
                row2.LAST_USER_NAME = null;
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 9) {
								row2.LAST_MODIFIED = null;
							} else {
										
			row2.LAST_MODIFIED = mssqlGTU_tDBInput_2.getDate(rsmd_tDBInput_2, rs_tDBInput_2, 9);
			
		                    }
							if(colQtyInRs_tDBInput_2 < 10) {
								row2.START_DATE = null;
							} else {
										
			row2.START_DATE = mssqlGTU_tDBInput_2.getDate(rsmd_tDBInput_2, rs_tDBInput_2, 10);
			
		                    }
							if(colQtyInRs_tDBInput_2 < 11) {
								row2.END_DATE = null;
							} else {
										
			row2.END_DATE = mssqlGTU_tDBInput_2.getDate(rsmd_tDBInput_2, rs_tDBInput_2, 11);
			
		                    }
							if(colQtyInRs_tDBInput_2 < 12) {
								row2.INVENTORY_QUANTITY_TYPE = 0;
							} else {
		                          
            row2.INVENTORY_QUANTITY_TYPE = rs_tDBInput_2.getInt(12);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 13) {
								row2.DIRECTION = 0;
							} else {
		                          
            row2.DIRECTION = rs_tDBInput_2.getInt(13);
            if(rs_tDBInput_2.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_2 < 14) {
								row2.MEASURED_QUANTITY_TYPE = 0;
							} else {
		                          
            row2.MEASURED_QUANTITY_TYPE = rs_tDBInput_2.getInt(14);
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
	 * [tAdvancedHash_row2 main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row2";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row2"
						
						);
					}
					


			   
			   

					row2Struct row2_HashRow = new row2Struct();
		   	   	   
				
				row2_HashRow.PK_BULK_PRODUCT = row2.PK_BULK_PRODUCT;
				
				row2_HashRow.BULK_MOVEMENT_ID = row2.BULK_MOVEMENT_ID;
				
				row2_HashRow.BULK_PRODUCT_ID = row2.BULK_PRODUCT_ID;
				
				row2_HashRow.TERMINAL_PRODUCT_NUMBER = row2.TERMINAL_PRODUCT_NUMBER;
				
				row2_HashRow.CONTAINER_CODE = row2.CONTAINER_CODE;
				
				row2_HashRow.SNAPSHOT_TYPE = row2.SNAPSHOT_TYPE;
				
				row2_HashRow.FIGURES_TYPE = row2.FIGURES_TYPE;
				
				row2_HashRow.LAST_USER_NAME = row2.LAST_USER_NAME;
				
				row2_HashRow.LAST_MODIFIED = row2.LAST_MODIFIED;
				
				row2_HashRow.START_DATE = row2.START_DATE;
				
				row2_HashRow.END_DATE = row2.END_DATE;
				
				row2_HashRow.INVENTORY_QUANTITY_TYPE = row2.INVENTORY_QUANTITY_TYPE;
				
				row2_HashRow.DIRECTION = row2.DIRECTION;
				
				row2_HashRow.MEASURED_QUANTITY_TYPE = row2.MEASURED_QUANTITY_TYPE;
				
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
    final static byte[] commonByteArrayLock_PGS_STAGE_FACT_RESOURCES = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_FACT_RESOURCES = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
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
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
							result = prime * result + (int) this.BULK_MOVEMENT_ID;
						
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
		
						if (this.BULK_MOVEMENT_ID != other.BULK_MOVEMENT_ID)
							return false;
					
						if (this.BULK_PRODUCT_ID != other.BULK_PRODUCT_ID)
							return false;
					

		return true;
    }

	public void copyDataTo(row3Struct other) {

		other.BULK_MOVEMENT_ID = this.BULK_MOVEMENT_ID;
	            other.BULK_PRODUCT_ID = this.BULK_PRODUCT_ID;
	            other.TERMINAL_PRODUCT_NUMBER = this.TERMINAL_PRODUCT_NUMBER;
	            other.MEASUREMENT_DEVICE_PARENT_CODE = this.MEASUREMENT_DEVICE_PARENT_CODE;
	            other.COMPARTMENT_NUMBER = this.COMPARTMENT_NUMBER;
	            other.MEASUREMENT_DEVICE_CODE = this.MEASUREMENT_DEVICE_CODE;
	            other.USER_INTERFACE_CODE = this.USER_INTERFACE_CODE;
	            other.MEASUREMENT_DEVICE_TYPE = this.MEASUREMENT_DEVICE_TYPE;
	            other.SNAPSHOT_TANK_CODE = this.SNAPSHOT_TANK_CODE;
	            other.CONTAINER_CODE = this.CONTAINER_CODE;
	            other.CONTAINER_TYPE = this.CONTAINER_TYPE;
	            other.COMPARTMENT_OWNER_ID = this.COMPARTMENT_OWNER_ID;
	            other.COMPARTMENT_CONTAINER_CODE = this.COMPARTMENT_CONTAINER_CODE;
	            other.SNAPSHOT_TYPE = this.SNAPSHOT_TYPE;
	            other.COMPARTMENT_CONTAINER_TYPE = this.COMPARTMENT_CONTAINER_TYPE;
	            other.FIGURES_TYPE = this.FIGURES_TYPE;
	            other.SNAPSHOT_FOLIO_NUMBER = this.SNAPSHOT_FOLIO_NUMBER;
	            other.SNAPSHOT_SEQUENCE_NUMBER = this.SNAPSHOT_SEQUENCE_NUMBER;
	            other.FSHOST_SI_PRODUCT_NUMBER = this.FSHOST_SI_PRODUCT_NUMBER;
	            other.TSHOST_SI_PRODUCT_NUMBER = this.TSHOST_SI_PRODUCT_NUMBER;
	            other.GROSS_QUANTITY = this.GROSS_QUANTITY;
	            other.NET_QUANTITY = this.NET_QUANTITY;
	            other.DENSITY = this.DENSITY;
	            other.TEMPERATURE = this.TEMPERATURE;
	            other.WEIGHT = this.WEIGHT;
	            other.OCTANE = this.OCTANE;
	            other.RVP = this.RVP;
	            other.COEFFICIENT_EXPANSION = this.COEFFICIENT_EXPANSION;
	            other.OXYGEN = this.OXYGEN;
	            other.SPECIFIC_GRAVITY = this.SPECIFIC_GRAVITY;
	            other.LAST_USER_NAME = this.LAST_USER_NAME;
	            other.LAST_MODIFIED = this.LAST_MODIFIED;
	            other.START_DATE = this.START_DATE;
	            other.END_DATE = this.END_DATE;
	            other.PRESSURE = this.PRESSURE;
	            other.FLOW_RATE = this.FLOW_RATE;
	            other.AVERAGE_METER_FACTOR = this.AVERAGE_METER_FACTOR;
	            other.VCF = this.VCF;
	            other.PCF = this.PCF;
	            other.OBSERVED_DENSITY = this.OBSERVED_DENSITY;
	            other.INVENTORY_QUANTITY_TYPE = this.INVENTORY_QUANTITY_TYPE;
	            other.MEASURED_DENSITY = this.MEASURED_DENSITY;
	            other.BSW_PERCENT = this.BSW_PERCENT;
	            other.WATER_VOLUME = this.WATER_VOLUME;
	            other.WEIGHT_IN_VAC = this.WEIGHT_IN_VAC;
	            other.GROSS_FRAC_QUANTITY = this.GROSS_FRAC_QUANTITY;
	            other.NET_FRAC_QUANTITY = this.NET_FRAC_QUANTITY;
	            other.LEVEL_CHANGE = this.LEVEL_CHANGE;
	            other.FRAC_WEIGHT = this.FRAC_WEIGHT;
	            other.FRAC_WEIGHT_IN_VAC = this.FRAC_WEIGHT_IN_VAC;
	            other.DIRECTION = this.DIRECTION;
	            other.DECLARED_GROSS_QUANTITY = this.DECLARED_GROSS_QUANTITY;
	            other.DECLARED_GROSS_FRAC_QUANTITY = this.DECLARED_GROSS_FRAC_QUANTITY;
	            other.DECLARED_NET_QUANTITY = this.DECLARED_NET_QUANTITY;
	            other.DECLARED_NET_FRAC_QUANTITY = this.DECLARED_NET_FRAC_QUANTITY;
	            other.DECLARED_WEIGHT = this.DECLARED_WEIGHT;
	            other.DECLARED_FRAC_WEIGHT = this.DECLARED_FRAC_WEIGHT;
	            other.DECLARED_WEIGHT_IN_VAC = this.DECLARED_WEIGHT_IN_VAC;
	            other.MEASURED_QUANTITY_TYPE = this.MEASURED_QUANTITY_TYPE;
	            other.DERIVED_VALUES_DIRECTIVE = this.DERIVED_VALUES_DIRECTIVE;
	            other.DECLARED_FRAC_WEIGHT_IN_VAC = this.DECLARED_FRAC_WEIGHT_IN_VAC;
	            other.CALCULATE_NET = this.CALCULATE_NET;
	            other.CONTAINER_OWNER_ID = this.CONTAINER_OWNER_ID;
	            other.AFFECT_ACCOUNTING = this.AFFECT_ACCOUNTING;
	            other.SUPPLIER_PRODUCT_SUPPLIER = this.SUPPLIER_PRODUCT_SUPPLIER;
	            other.SUPPLIER_PRODUCT_NUMBER = this.SUPPLIER_PRODUCT_NUMBER;
	            
	}

	public void copyKeysDataTo(row3Struct other) {

		other.BULK_MOVEMENT_ID = this.BULK_MOVEMENT_ID;
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

		synchronized(commonByteArrayLock_PGS_STAGE_FACT_RESOURCES) {

        	try {

        		int length = 0;
		
			        this.BULK_MOVEMENT_ID = dis.readInt();
					
			        this.BULK_PRODUCT_ID = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_FACT_RESOURCES) {

        	try {

        		int length = 0;
		
			        this.BULK_MOVEMENT_ID = dis.readInt();
					
			        this.BULK_PRODUCT_ID = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.BULK_MOVEMENT_ID);
					
					// int
				
		            	dos.writeInt(this.BULK_PRODUCT_ID);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.BULK_MOVEMENT_ID);
					
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
		
			            this.TERMINAL_PRODUCT_NUMBER = dis.readInt();
					
						this.MEASUREMENT_DEVICE_PARENT_CODE = readString(dis,ois);
					
						this.COMPARTMENT_NUMBER = readInteger(dis,ois);
					
						this.MEASUREMENT_DEVICE_CODE = readString(dis,ois);
					
						this.USER_INTERFACE_CODE = readString(dis,ois);
					
						this.MEASUREMENT_DEVICE_TYPE = readInteger(dis,ois);
					
						this.SNAPSHOT_TANK_CODE = readString(dis,ois);
					
						this.CONTAINER_CODE = readString(dis,ois);
					
						this.CONTAINER_TYPE = readInteger(dis,ois);
					
						this.COMPARTMENT_OWNER_ID = readInteger(dis,ois);
					
						this.COMPARTMENT_CONTAINER_CODE = readString(dis,ois);
					
						this.SNAPSHOT_TYPE = readInteger(dis,ois);
					
						this.COMPARTMENT_CONTAINER_TYPE = readInteger(dis,ois);
					
			            this.FIGURES_TYPE = dis.readInt();
					
						this.SNAPSHOT_FOLIO_NUMBER = readString(dis,ois);
					
						this.SNAPSHOT_SEQUENCE_NUMBER = readInteger(dis,ois);
					
						this.FSHOST_SI_PRODUCT_NUMBER = readString(dis,ois);
					
						this.TSHOST_SI_PRODUCT_NUMBER = readString(dis,ois);
					
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
					
						this.LAST_USER_NAME = readString(dis,ois);
					
						this.LAST_MODIFIED = readDate(dis,ois);
					
						this.START_DATE = readDate(dis,ois);
					
						this.END_DATE = readDate(dis,ois);
					
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
					
						this.CONTAINER_OWNER_ID = readInteger(dis,ois);
					
			            this.AFFECT_ACCOUNTING = dis.readInt();
					
						this.SUPPLIER_PRODUCT_SUPPLIER = readInteger(dis,ois);
					
						this.SUPPLIER_PRODUCT_NUMBER = readInteger(dis,ois);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
			            this.TERMINAL_PRODUCT_NUMBER = objectIn.readInt();
					
						this.MEASUREMENT_DEVICE_PARENT_CODE = readString(dis,objectIn);
					
						this.COMPARTMENT_NUMBER = readInteger(dis,objectIn);
					
						this.MEASUREMENT_DEVICE_CODE = readString(dis,objectIn);
					
						this.USER_INTERFACE_CODE = readString(dis,objectIn);
					
						this.MEASUREMENT_DEVICE_TYPE = readInteger(dis,objectIn);
					
						this.SNAPSHOT_TANK_CODE = readString(dis,objectIn);
					
						this.CONTAINER_CODE = readString(dis,objectIn);
					
						this.CONTAINER_TYPE = readInteger(dis,objectIn);
					
						this.COMPARTMENT_OWNER_ID = readInteger(dis,objectIn);
					
						this.COMPARTMENT_CONTAINER_CODE = readString(dis,objectIn);
					
						this.SNAPSHOT_TYPE = readInteger(dis,objectIn);
					
						this.COMPARTMENT_CONTAINER_TYPE = readInteger(dis,objectIn);
					
			            this.FIGURES_TYPE = objectIn.readInt();
					
						this.SNAPSHOT_FOLIO_NUMBER = readString(dis,objectIn);
					
						this.SNAPSHOT_SEQUENCE_NUMBER = readInteger(dis,objectIn);
					
						this.FSHOST_SI_PRODUCT_NUMBER = readString(dis,objectIn);
					
						this.TSHOST_SI_PRODUCT_NUMBER = readString(dis,objectIn);
					
			            this.GROSS_QUANTITY = objectIn.readInt();
					
			            this.NET_QUANTITY = objectIn.readInt();
					
			            this.DENSITY = objectIn.readDouble();
					
			            this.TEMPERATURE = objectIn.readDouble();
					
			            this.WEIGHT = objectIn.readInt();
					
			            this.OCTANE = objectIn.readDouble();
					
			            this.RVP = objectIn.readDouble();
					
			            this.COEFFICIENT_EXPANSION = objectIn.readDouble();
					
			            this.OXYGEN = objectIn.readDouble();
					
			            this.SPECIFIC_GRAVITY = objectIn.readDouble();
					
						this.LAST_USER_NAME = readString(dis,objectIn);
					
						this.LAST_MODIFIED = readDate(dis,objectIn);
					
						this.START_DATE = readDate(dis,objectIn);
					
						this.END_DATE = readDate(dis,objectIn);
					
			            this.PRESSURE = objectIn.readDouble();
					
			            this.FLOW_RATE = objectIn.readDouble();
					
			            this.AVERAGE_METER_FACTOR = objectIn.readDouble();
					
			            this.VCF = objectIn.readDouble();
					
			            this.PCF = objectIn.readDouble();
					
			            this.OBSERVED_DENSITY = objectIn.readDouble();
					
			            this.INVENTORY_QUANTITY_TYPE = objectIn.readInt();
					
			            this.MEASURED_DENSITY = objectIn.readDouble();
					
			            this.BSW_PERCENT = objectIn.readDouble();
					
			            this.WATER_VOLUME = objectIn.readInt();
					
			            this.WEIGHT_IN_VAC = objectIn.readInt();
					
			            this.GROSS_FRAC_QUANTITY = objectIn.readInt();
					
			            this.NET_FRAC_QUANTITY = objectIn.readInt();
					
			            this.LEVEL_CHANGE = objectIn.readInt();
					
			            this.FRAC_WEIGHT = objectIn.readInt();
					
			            this.FRAC_WEIGHT_IN_VAC = objectIn.readInt();
					
			            this.DIRECTION = objectIn.readInt();
					
			            this.DECLARED_GROSS_QUANTITY = objectIn.readInt();
					
			            this.DECLARED_GROSS_FRAC_QUANTITY = objectIn.readInt();
					
			            this.DECLARED_NET_QUANTITY = objectIn.readInt();
					
			            this.DECLARED_NET_FRAC_QUANTITY = objectIn.readInt();
					
			            this.DECLARED_WEIGHT = objectIn.readInt();
					
			            this.DECLARED_FRAC_WEIGHT = objectIn.readInt();
					
			            this.DECLARED_WEIGHT_IN_VAC = objectIn.readInt();
					
			            this.MEASURED_QUANTITY_TYPE = objectIn.readInt();
					
			            this.DERIVED_VALUES_DIRECTIVE = objectIn.readInt();
					
			            this.DECLARED_FRAC_WEIGHT_IN_VAC = objectIn.readInt();
					
			            this.CALCULATE_NET = objectIn.readInt();
					
						this.CONTAINER_OWNER_ID = readInteger(dis,objectIn);
					
			            this.AFFECT_ACCOUNTING = objectIn.readInt();
					
						this.SUPPLIER_PRODUCT_SUPPLIER = readInteger(dis,objectIn);
					
						this.SUPPLIER_PRODUCT_NUMBER = readInteger(dis,objectIn);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
		            	dos.writeInt(this.TERMINAL_PRODUCT_NUMBER);
					
						writeString(this.MEASUREMENT_DEVICE_PARENT_CODE, dos, oos);
					
					writeInteger(this.COMPARTMENT_NUMBER, dos, oos);
					
						writeString(this.MEASUREMENT_DEVICE_CODE, dos, oos);
					
						writeString(this.USER_INTERFACE_CODE, dos, oos);
					
					writeInteger(this.MEASUREMENT_DEVICE_TYPE, dos, oos);
					
						writeString(this.SNAPSHOT_TANK_CODE, dos, oos);
					
						writeString(this.CONTAINER_CODE, dos, oos);
					
					writeInteger(this.CONTAINER_TYPE, dos, oos);
					
					writeInteger(this.COMPARTMENT_OWNER_ID, dos, oos);
					
						writeString(this.COMPARTMENT_CONTAINER_CODE, dos, oos);
					
					writeInteger(this.SNAPSHOT_TYPE, dos, oos);
					
					writeInteger(this.COMPARTMENT_CONTAINER_TYPE, dos, oos);
					
		            	dos.writeInt(this.FIGURES_TYPE);
					
						writeString(this.SNAPSHOT_FOLIO_NUMBER, dos, oos);
					
					writeInteger(this.SNAPSHOT_SEQUENCE_NUMBER, dos, oos);
					
						writeString(this.FSHOST_SI_PRODUCT_NUMBER, dos, oos);
					
						writeString(this.TSHOST_SI_PRODUCT_NUMBER, dos, oos);
					
		            	dos.writeInt(this.GROSS_QUANTITY);
					
		            	dos.writeInt(this.NET_QUANTITY);
					
		            	dos.writeDouble(this.DENSITY);
					
		            	dos.writeDouble(this.TEMPERATURE);
					
		            	dos.writeInt(this.WEIGHT);
					
		            	dos.writeDouble(this.OCTANE);
					
		            	dos.writeDouble(this.RVP);
					
		            	dos.writeDouble(this.COEFFICIENT_EXPANSION);
					
		            	dos.writeDouble(this.OXYGEN);
					
		            	dos.writeDouble(this.SPECIFIC_GRAVITY);
					
						writeString(this.LAST_USER_NAME, dos, oos);
					
						writeDate(this.LAST_MODIFIED, dos, oos);
					
						writeDate(this.START_DATE, dos, oos);
					
						writeDate(this.END_DATE, dos, oos);
					
		            	dos.writeDouble(this.PRESSURE);
					
		            	dos.writeDouble(this.FLOW_RATE);
					
		            	dos.writeDouble(this.AVERAGE_METER_FACTOR);
					
		            	dos.writeDouble(this.VCF);
					
		            	dos.writeDouble(this.PCF);
					
		            	dos.writeDouble(this.OBSERVED_DENSITY);
					
		            	dos.writeInt(this.INVENTORY_QUANTITY_TYPE);
					
		            	dos.writeDouble(this.MEASURED_DENSITY);
					
		            	dos.writeDouble(this.BSW_PERCENT);
					
		            	dos.writeInt(this.WATER_VOLUME);
					
		            	dos.writeInt(this.WEIGHT_IN_VAC);
					
		            	dos.writeInt(this.GROSS_FRAC_QUANTITY);
					
		            	dos.writeInt(this.NET_FRAC_QUANTITY);
					
		            	dos.writeInt(this.LEVEL_CHANGE);
					
		            	dos.writeInt(this.FRAC_WEIGHT);
					
		            	dos.writeInt(this.FRAC_WEIGHT_IN_VAC);
					
		            	dos.writeInt(this.DIRECTION);
					
		            	dos.writeInt(this.DECLARED_GROSS_QUANTITY);
					
		            	dos.writeInt(this.DECLARED_GROSS_FRAC_QUANTITY);
					
		            	dos.writeInt(this.DECLARED_NET_QUANTITY);
					
		            	dos.writeInt(this.DECLARED_NET_FRAC_QUANTITY);
					
		            	dos.writeInt(this.DECLARED_WEIGHT);
					
		            	dos.writeInt(this.DECLARED_FRAC_WEIGHT);
					
		            	dos.writeInt(this.DECLARED_WEIGHT_IN_VAC);
					
		            	dos.writeInt(this.MEASURED_QUANTITY_TYPE);
					
		            	dos.writeInt(this.DERIVED_VALUES_DIRECTIVE);
					
		            	dos.writeInt(this.DECLARED_FRAC_WEIGHT_IN_VAC);
					
		            	dos.writeInt(this.CALCULATE_NET);
					
					writeInteger(this.CONTAINER_OWNER_ID, dos, oos);
					
		            	dos.writeInt(this.AFFECT_ACCOUNTING);
					
					writeInteger(this.SUPPLIER_PRODUCT_SUPPLIER, dos, oos);
					
					writeInteger(this.SUPPLIER_PRODUCT_NUMBER, dos, oos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
					objectOut.writeInt(this.TERMINAL_PRODUCT_NUMBER);
					
						writeString(this.MEASUREMENT_DEVICE_PARENT_CODE, dos, objectOut);
					
					writeInteger(this.COMPARTMENT_NUMBER, dos, objectOut);
					
						writeString(this.MEASUREMENT_DEVICE_CODE, dos, objectOut);
					
						writeString(this.USER_INTERFACE_CODE, dos, objectOut);
					
					writeInteger(this.MEASUREMENT_DEVICE_TYPE, dos, objectOut);
					
						writeString(this.SNAPSHOT_TANK_CODE, dos, objectOut);
					
						writeString(this.CONTAINER_CODE, dos, objectOut);
					
					writeInteger(this.CONTAINER_TYPE, dos, objectOut);
					
					writeInteger(this.COMPARTMENT_OWNER_ID, dos, objectOut);
					
						writeString(this.COMPARTMENT_CONTAINER_CODE, dos, objectOut);
					
					writeInteger(this.SNAPSHOT_TYPE, dos, objectOut);
					
					writeInteger(this.COMPARTMENT_CONTAINER_TYPE, dos, objectOut);
					
					objectOut.writeInt(this.FIGURES_TYPE);
					
						writeString(this.SNAPSHOT_FOLIO_NUMBER, dos, objectOut);
					
					writeInteger(this.SNAPSHOT_SEQUENCE_NUMBER, dos, objectOut);
					
						writeString(this.FSHOST_SI_PRODUCT_NUMBER, dos, objectOut);
					
						writeString(this.TSHOST_SI_PRODUCT_NUMBER, dos, objectOut);
					
					objectOut.writeInt(this.GROSS_QUANTITY);
					
					objectOut.writeInt(this.NET_QUANTITY);
					
					objectOut.writeDouble(this.DENSITY);
					
					objectOut.writeDouble(this.TEMPERATURE);
					
					objectOut.writeInt(this.WEIGHT);
					
					objectOut.writeDouble(this.OCTANE);
					
					objectOut.writeDouble(this.RVP);
					
					objectOut.writeDouble(this.COEFFICIENT_EXPANSION);
					
					objectOut.writeDouble(this.OXYGEN);
					
					objectOut.writeDouble(this.SPECIFIC_GRAVITY);
					
						writeString(this.LAST_USER_NAME, dos, objectOut);
					
						writeDate(this.LAST_MODIFIED, dos, objectOut);
					
						writeDate(this.START_DATE, dos, objectOut);
					
						writeDate(this.END_DATE, dos, objectOut);
					
					objectOut.writeDouble(this.PRESSURE);
					
					objectOut.writeDouble(this.FLOW_RATE);
					
					objectOut.writeDouble(this.AVERAGE_METER_FACTOR);
					
					objectOut.writeDouble(this.VCF);
					
					objectOut.writeDouble(this.PCF);
					
					objectOut.writeDouble(this.OBSERVED_DENSITY);
					
					objectOut.writeInt(this.INVENTORY_QUANTITY_TYPE);
					
					objectOut.writeDouble(this.MEASURED_DENSITY);
					
					objectOut.writeDouble(this.BSW_PERCENT);
					
					objectOut.writeInt(this.WATER_VOLUME);
					
					objectOut.writeInt(this.WEIGHT_IN_VAC);
					
					objectOut.writeInt(this.GROSS_FRAC_QUANTITY);
					
					objectOut.writeInt(this.NET_FRAC_QUANTITY);
					
					objectOut.writeInt(this.LEVEL_CHANGE);
					
					objectOut.writeInt(this.FRAC_WEIGHT);
					
					objectOut.writeInt(this.FRAC_WEIGHT_IN_VAC);
					
					objectOut.writeInt(this.DIRECTION);
					
					objectOut.writeInt(this.DECLARED_GROSS_QUANTITY);
					
					objectOut.writeInt(this.DECLARED_GROSS_FRAC_QUANTITY);
					
					objectOut.writeInt(this.DECLARED_NET_QUANTITY);
					
					objectOut.writeInt(this.DECLARED_NET_FRAC_QUANTITY);
					
					objectOut.writeInt(this.DECLARED_WEIGHT);
					
					objectOut.writeInt(this.DECLARED_FRAC_WEIGHT);
					
					objectOut.writeInt(this.DECLARED_WEIGHT_IN_VAC);
					
					objectOut.writeInt(this.MEASURED_QUANTITY_TYPE);
					
					objectOut.writeInt(this.DERIVED_VALUES_DIRECTIVE);
					
					objectOut.writeInt(this.DECLARED_FRAC_WEIGHT_IN_VAC);
					
					objectOut.writeInt(this.CALCULATE_NET);
					
					writeInteger(this.CONTAINER_OWNER_ID, dos, objectOut);
					
					objectOut.writeInt(this.AFFECT_ACCOUNTING);
					
					writeInteger(this.SUPPLIER_PRODUCT_SUPPLIER, dos, objectOut);
					
					writeInteger(this.SUPPLIER_PRODUCT_NUMBER, dos, objectOut);
					
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
    public int compareTo(row3Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.BULK_MOVEMENT_ID, other.BULK_MOVEMENT_ID);
						if(returnValue != 0) {
							return returnValue;
						}

					
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
			   		// source node:tDBInput_3 - inputs:(after_tDBInput_1) outputs:(row3,row3) | target node:tAdvancedHash_row3 - inputs:(row3) outputs:()
			   		// linked node: tMap_1 - inputs:(row1,row2,row3,row4,row5) outputs:(out1)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row3 = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct> tHash_Lookup_row3 =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<row3Struct>getLookup(matchingModeEnum_row3);
	   						   
		   	   	   globalMap.put("tHash_Lookup_row3", tHash_Lookup_row3);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_row3 begin ] stop
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
				
				 
	final String decryptedPassword_tDBInput_3 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:AB/ZWH+pawLimUNwXDoo1pQvNepFk68Pm75pHIF/9Fdl87huNuM=");
				
				String dbPwd_tDBInput_3 = decryptedPassword_tDBInput_3;
				
		    String port_tDBInput_3 = "1433";
		    String dbname_tDBInput_3 = "FF_TEST" ;
			String url_tDBInput_3 = "jdbc:jtds:sqlserver://" + "LAPTOP-HED7JE2F" ;
		    if (!"".equals(port_tDBInput_3)) {
		    	url_tDBInput_3 += ":" + "1433";
		    }
		    if (!"".equals(dbname_tDBInput_3)) {
				url_tDBInput_3 += "//" + "FF_TEST"; 
		    }
		    url_tDBInput_3 += ";appName=" + projectName + ";" + "";
		    String dbschema_tDBInput_3 = "dbo";
				
				conn_tDBInput_3 = java.sql.DriverManager.getConnection(url_tDBInput_3,dbUser_tDBInput_3,dbPwd_tDBInput_3);
		        
		    
			java.sql.Statement stmt_tDBInput_3 = conn_tDBInput_3.createStatement();

		    String dbquery_tDBInput_3 = "SELECT dbo.BULK_PRODUCT.BULK_MOVEMENT_ID,\n		dbo.BULK_PRODUCT.BULK_PRODUCT_ID,\n		dbo.BULK_PRODUCT.TERMINAL_PRODUCT_NUMBE"
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
								row3.BULK_MOVEMENT_ID = 0;
							} else {
		                          
            row3.BULK_MOVEMENT_ID = rs_tDBInput_3.getInt(1);
            if(rs_tDBInput_3.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 2) {
								row3.BULK_PRODUCT_ID = 0;
							} else {
		                          
            row3.BULK_PRODUCT_ID = rs_tDBInput_3.getInt(2);
            if(rs_tDBInput_3.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 3) {
								row3.TERMINAL_PRODUCT_NUMBER = 0;
							} else {
		                          
            row3.TERMINAL_PRODUCT_NUMBER = rs_tDBInput_3.getInt(3);
            if(rs_tDBInput_3.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 4) {
								row3.MEASUREMENT_DEVICE_PARENT_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_3 = rs_tDBInput_3.getString(4);
            if(tmpContent_tDBInput_3 != null) {
            	if (talendToDBList_tDBInput_3 .contains(rsmd_tDBInput_3.getColumnTypeName(4).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.MEASUREMENT_DEVICE_PARENT_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
            	} else {
                	row3.MEASUREMENT_DEVICE_PARENT_CODE = tmpContent_tDBInput_3;
                }
            } else {
                row3.MEASUREMENT_DEVICE_PARENT_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 5) {
								row3.COMPARTMENT_NUMBER = null;
							} else {
		                          
            row3.COMPARTMENT_NUMBER = rs_tDBInput_3.getInt(5);
            if(rs_tDBInput_3.wasNull()){
                    row3.COMPARTMENT_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 6) {
								row3.MEASUREMENT_DEVICE_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_3 = rs_tDBInput_3.getString(6);
            if(tmpContent_tDBInput_3 != null) {
            	if (talendToDBList_tDBInput_3 .contains(rsmd_tDBInput_3.getColumnTypeName(6).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.MEASUREMENT_DEVICE_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
            	} else {
                	row3.MEASUREMENT_DEVICE_CODE = tmpContent_tDBInput_3;
                }
            } else {
                row3.MEASUREMENT_DEVICE_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 7) {
								row3.USER_INTERFACE_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_3 = rs_tDBInput_3.getString(7);
            if(tmpContent_tDBInput_3 != null) {
            	if (talendToDBList_tDBInput_3 .contains(rsmd_tDBInput_3.getColumnTypeName(7).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.USER_INTERFACE_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
            	} else {
                	row3.USER_INTERFACE_CODE = tmpContent_tDBInput_3;
                }
            } else {
                row3.USER_INTERFACE_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 8) {
								row3.MEASUREMENT_DEVICE_TYPE = null;
							} else {
		                          
            row3.MEASUREMENT_DEVICE_TYPE = rs_tDBInput_3.getInt(8);
            if(rs_tDBInput_3.wasNull()){
                    row3.MEASUREMENT_DEVICE_TYPE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 9) {
								row3.SNAPSHOT_TANK_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_3 = rs_tDBInput_3.getString(9);
            if(tmpContent_tDBInput_3 != null) {
            	if (talendToDBList_tDBInput_3 .contains(rsmd_tDBInput_3.getColumnTypeName(9).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.SNAPSHOT_TANK_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
            	} else {
                	row3.SNAPSHOT_TANK_CODE = tmpContent_tDBInput_3;
                }
            } else {
                row3.SNAPSHOT_TANK_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 10) {
								row3.CONTAINER_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_3 = rs_tDBInput_3.getString(10);
            if(tmpContent_tDBInput_3 != null) {
            	if (talendToDBList_tDBInput_3 .contains(rsmd_tDBInput_3.getColumnTypeName(10).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.CONTAINER_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
            	} else {
                	row3.CONTAINER_CODE = tmpContent_tDBInput_3;
                }
            } else {
                row3.CONTAINER_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 11) {
								row3.CONTAINER_TYPE = null;
							} else {
		                          
            row3.CONTAINER_TYPE = rs_tDBInput_3.getInt(11);
            if(rs_tDBInput_3.wasNull()){
                    row3.CONTAINER_TYPE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 12) {
								row3.COMPARTMENT_OWNER_ID = null;
							} else {
		                          
            row3.COMPARTMENT_OWNER_ID = rs_tDBInput_3.getInt(12);
            if(rs_tDBInput_3.wasNull()){
                    row3.COMPARTMENT_OWNER_ID = null;
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 13) {
								row3.COMPARTMENT_CONTAINER_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_3 = rs_tDBInput_3.getString(13);
            if(tmpContent_tDBInput_3 != null) {
            	if (talendToDBList_tDBInput_3 .contains(rsmd_tDBInput_3.getColumnTypeName(13).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.COMPARTMENT_CONTAINER_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
            	} else {
                	row3.COMPARTMENT_CONTAINER_CODE = tmpContent_tDBInput_3;
                }
            } else {
                row3.COMPARTMENT_CONTAINER_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 14) {
								row3.SNAPSHOT_TYPE = null;
							} else {
		                          
            row3.SNAPSHOT_TYPE = rs_tDBInput_3.getInt(14);
            if(rs_tDBInput_3.wasNull()){
                    row3.SNAPSHOT_TYPE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 15) {
								row3.COMPARTMENT_CONTAINER_TYPE = null;
							} else {
		                          
            row3.COMPARTMENT_CONTAINER_TYPE = rs_tDBInput_3.getInt(15);
            if(rs_tDBInput_3.wasNull()){
                    row3.COMPARTMENT_CONTAINER_TYPE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 16) {
								row3.FIGURES_TYPE = 0;
							} else {
		                          
            row3.FIGURES_TYPE = rs_tDBInput_3.getInt(16);
            if(rs_tDBInput_3.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 17) {
								row3.SNAPSHOT_FOLIO_NUMBER = null;
							} else {
	                         		
           		tmpContent_tDBInput_3 = rs_tDBInput_3.getString(17);
            if(tmpContent_tDBInput_3 != null) {
            	if (talendToDBList_tDBInput_3 .contains(rsmd_tDBInput_3.getColumnTypeName(17).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.SNAPSHOT_FOLIO_NUMBER = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
            	} else {
                	row3.SNAPSHOT_FOLIO_NUMBER = tmpContent_tDBInput_3;
                }
            } else {
                row3.SNAPSHOT_FOLIO_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 18) {
								row3.SNAPSHOT_SEQUENCE_NUMBER = null;
							} else {
		                          
            row3.SNAPSHOT_SEQUENCE_NUMBER = rs_tDBInput_3.getInt(18);
            if(rs_tDBInput_3.wasNull()){
                    row3.SNAPSHOT_SEQUENCE_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 19) {
								row3.FSHOST_SI_PRODUCT_NUMBER = null;
							} else {
	                         		
           		tmpContent_tDBInput_3 = rs_tDBInput_3.getString(19);
            if(tmpContent_tDBInput_3 != null) {
            	if (talendToDBList_tDBInput_3 .contains(rsmd_tDBInput_3.getColumnTypeName(19).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.FSHOST_SI_PRODUCT_NUMBER = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
            	} else {
                	row3.FSHOST_SI_PRODUCT_NUMBER = tmpContent_tDBInput_3;
                }
            } else {
                row3.FSHOST_SI_PRODUCT_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 20) {
								row3.TSHOST_SI_PRODUCT_NUMBER = null;
							} else {
	                         		
           		tmpContent_tDBInput_3 = rs_tDBInput_3.getString(20);
            if(tmpContent_tDBInput_3 != null) {
            	if (talendToDBList_tDBInput_3 .contains(rsmd_tDBInput_3.getColumnTypeName(20).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.TSHOST_SI_PRODUCT_NUMBER = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
            	} else {
                	row3.TSHOST_SI_PRODUCT_NUMBER = tmpContent_tDBInput_3;
                }
            } else {
                row3.TSHOST_SI_PRODUCT_NUMBER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 21) {
								row3.GROSS_QUANTITY = 0;
							} else {
		                          
            row3.GROSS_QUANTITY = rs_tDBInput_3.getInt(21);
            if(rs_tDBInput_3.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 22) {
								row3.NET_QUANTITY = 0;
							} else {
		                          
            row3.NET_QUANTITY = rs_tDBInput_3.getInt(22);
            if(rs_tDBInput_3.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 23) {
								row3.DENSITY = 0;
							} else {
	                         		
            row3.DENSITY = rs_tDBInput_3.getDouble(23);
            if(rs_tDBInput_3.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 24) {
								row3.TEMPERATURE = 0;
							} else {
	                         		
            row3.TEMPERATURE = rs_tDBInput_3.getDouble(24);
            if(rs_tDBInput_3.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 25) {
								row3.WEIGHT = 0;
							} else {
		                          
            row3.WEIGHT = rs_tDBInput_3.getInt(25);
            if(rs_tDBInput_3.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 26) {
								row3.OCTANE = 0;
							} else {
	                         		
            row3.OCTANE = rs_tDBInput_3.getDouble(26);
            if(rs_tDBInput_3.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 27) {
								row3.RVP = 0;
							} else {
	                         		
            row3.RVP = rs_tDBInput_3.getDouble(27);
            if(rs_tDBInput_3.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 28) {
								row3.COEFFICIENT_EXPANSION = 0;
							} else {
	                         		
            row3.COEFFICIENT_EXPANSION = rs_tDBInput_3.getDouble(28);
            if(rs_tDBInput_3.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 29) {
								row3.OXYGEN = 0;
							} else {
	                         		
            row3.OXYGEN = rs_tDBInput_3.getDouble(29);
            if(rs_tDBInput_3.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 30) {
								row3.SPECIFIC_GRAVITY = 0;
							} else {
	                         		
            row3.SPECIFIC_GRAVITY = rs_tDBInput_3.getDouble(30);
            if(rs_tDBInput_3.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 31) {
								row3.LAST_USER_NAME = null;
							} else {
	                         		
           		tmpContent_tDBInput_3 = rs_tDBInput_3.getString(31);
            if(tmpContent_tDBInput_3 != null) {
            	if (talendToDBList_tDBInput_3 .contains(rsmd_tDBInput_3.getColumnTypeName(31).toUpperCase(java.util.Locale.ENGLISH))) {
            		row3.LAST_USER_NAME = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
            	} else {
                	row3.LAST_USER_NAME = tmpContent_tDBInput_3;
                }
            } else {
                row3.LAST_USER_NAME = null;
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 32) {
								row3.LAST_MODIFIED = null;
							} else {
										
			row3.LAST_MODIFIED = mssqlGTU_tDBInput_3.getDate(rsmd_tDBInput_3, rs_tDBInput_3, 32);
			
		                    }
							if(colQtyInRs_tDBInput_3 < 33) {
								row3.START_DATE = null;
							} else {
										
			row3.START_DATE = mssqlGTU_tDBInput_3.getDate(rsmd_tDBInput_3, rs_tDBInput_3, 33);
			
		                    }
							if(colQtyInRs_tDBInput_3 < 34) {
								row3.END_DATE = null;
							} else {
										
			row3.END_DATE = mssqlGTU_tDBInput_3.getDate(rsmd_tDBInput_3, rs_tDBInput_3, 34);
			
		                    }
							if(colQtyInRs_tDBInput_3 < 35) {
								row3.PRESSURE = 0;
							} else {
	                         		
            row3.PRESSURE = rs_tDBInput_3.getDouble(35);
            if(rs_tDBInput_3.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 36) {
								row3.FLOW_RATE = 0;
							} else {
	                         		
            row3.FLOW_RATE = rs_tDBInput_3.getDouble(36);
            if(rs_tDBInput_3.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 37) {
								row3.AVERAGE_METER_FACTOR = 0;
							} else {
	                         		
            row3.AVERAGE_METER_FACTOR = rs_tDBInput_3.getDouble(37);
            if(rs_tDBInput_3.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 38) {
								row3.VCF = 0;
							} else {
	                         		
            row3.VCF = rs_tDBInput_3.getDouble(38);
            if(rs_tDBInput_3.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 39) {
								row3.PCF = 0;
							} else {
	                         		
            row3.PCF = rs_tDBInput_3.getDouble(39);
            if(rs_tDBInput_3.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 40) {
								row3.OBSERVED_DENSITY = 0;
							} else {
	                         		
            row3.OBSERVED_DENSITY = rs_tDBInput_3.getDouble(40);
            if(rs_tDBInput_3.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 41) {
								row3.INVENTORY_QUANTITY_TYPE = 0;
							} else {
		                          
            row3.INVENTORY_QUANTITY_TYPE = rs_tDBInput_3.getInt(41);
            if(rs_tDBInput_3.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 42) {
								row3.MEASURED_DENSITY = 0;
							} else {
	                         		
            row3.MEASURED_DENSITY = rs_tDBInput_3.getDouble(42);
            if(rs_tDBInput_3.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 43) {
								row3.BSW_PERCENT = 0;
							} else {
	                         		
            row3.BSW_PERCENT = rs_tDBInput_3.getDouble(43);
            if(rs_tDBInput_3.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 44) {
								row3.WATER_VOLUME = 0;
							} else {
		                          
            row3.WATER_VOLUME = rs_tDBInput_3.getInt(44);
            if(rs_tDBInput_3.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 45) {
								row3.WEIGHT_IN_VAC = 0;
							} else {
		                          
            row3.WEIGHT_IN_VAC = rs_tDBInput_3.getInt(45);
            if(rs_tDBInput_3.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 46) {
								row3.GROSS_FRAC_QUANTITY = 0;
							} else {
		                          
            row3.GROSS_FRAC_QUANTITY = rs_tDBInput_3.getInt(46);
            if(rs_tDBInput_3.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 47) {
								row3.NET_FRAC_QUANTITY = 0;
							} else {
		                          
            row3.NET_FRAC_QUANTITY = rs_tDBInput_3.getInt(47);
            if(rs_tDBInput_3.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 48) {
								row3.LEVEL_CHANGE = 0;
							} else {
		                          
            row3.LEVEL_CHANGE = rs_tDBInput_3.getInt(48);
            if(rs_tDBInput_3.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 49) {
								row3.FRAC_WEIGHT = 0;
							} else {
		                          
            row3.FRAC_WEIGHT = rs_tDBInput_3.getInt(49);
            if(rs_tDBInput_3.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 50) {
								row3.FRAC_WEIGHT_IN_VAC = 0;
							} else {
		                          
            row3.FRAC_WEIGHT_IN_VAC = rs_tDBInput_3.getInt(50);
            if(rs_tDBInput_3.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 51) {
								row3.DIRECTION = 0;
							} else {
		                          
            row3.DIRECTION = rs_tDBInput_3.getInt(51);
            if(rs_tDBInput_3.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 52) {
								row3.DECLARED_GROSS_QUANTITY = 0;
							} else {
		                          
            row3.DECLARED_GROSS_QUANTITY = rs_tDBInput_3.getInt(52);
            if(rs_tDBInput_3.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 53) {
								row3.DECLARED_GROSS_FRAC_QUANTITY = 0;
							} else {
		                          
            row3.DECLARED_GROSS_FRAC_QUANTITY = rs_tDBInput_3.getInt(53);
            if(rs_tDBInput_3.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 54) {
								row3.DECLARED_NET_QUANTITY = 0;
							} else {
		                          
            row3.DECLARED_NET_QUANTITY = rs_tDBInput_3.getInt(54);
            if(rs_tDBInput_3.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 55) {
								row3.DECLARED_NET_FRAC_QUANTITY = 0;
							} else {
		                          
            row3.DECLARED_NET_FRAC_QUANTITY = rs_tDBInput_3.getInt(55);
            if(rs_tDBInput_3.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 56) {
								row3.DECLARED_WEIGHT = 0;
							} else {
		                          
            row3.DECLARED_WEIGHT = rs_tDBInput_3.getInt(56);
            if(rs_tDBInput_3.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 57) {
								row3.DECLARED_FRAC_WEIGHT = 0;
							} else {
		                          
            row3.DECLARED_FRAC_WEIGHT = rs_tDBInput_3.getInt(57);
            if(rs_tDBInput_3.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 58) {
								row3.DECLARED_WEIGHT_IN_VAC = 0;
							} else {
		                          
            row3.DECLARED_WEIGHT_IN_VAC = rs_tDBInput_3.getInt(58);
            if(rs_tDBInput_3.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 59) {
								row3.MEASURED_QUANTITY_TYPE = 0;
							} else {
		                          
            row3.MEASURED_QUANTITY_TYPE = rs_tDBInput_3.getInt(59);
            if(rs_tDBInput_3.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 60) {
								row3.DERIVED_VALUES_DIRECTIVE = 0;
							} else {
		                          
            row3.DERIVED_VALUES_DIRECTIVE = rs_tDBInput_3.getInt(60);
            if(rs_tDBInput_3.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 61) {
								row3.DECLARED_FRAC_WEIGHT_IN_VAC = 0;
							} else {
		                          
            row3.DECLARED_FRAC_WEIGHT_IN_VAC = rs_tDBInput_3.getInt(61);
            if(rs_tDBInput_3.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 62) {
								row3.CALCULATE_NET = 0;
							} else {
		                          
            row3.CALCULATE_NET = rs_tDBInput_3.getInt(62);
            if(rs_tDBInput_3.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 63) {
								row3.CONTAINER_OWNER_ID = null;
							} else {
		                          
            row3.CONTAINER_OWNER_ID = rs_tDBInput_3.getInt(63);
            if(rs_tDBInput_3.wasNull()){
                    row3.CONTAINER_OWNER_ID = null;
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 64) {
								row3.AFFECT_ACCOUNTING = 0;
							} else {
		                          
            row3.AFFECT_ACCOUNTING = rs_tDBInput_3.getInt(64);
            if(rs_tDBInput_3.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 65) {
								row3.SUPPLIER_PRODUCT_SUPPLIER = null;
							} else {
		                          
            row3.SUPPLIER_PRODUCT_SUPPLIER = rs_tDBInput_3.getInt(65);
            if(rs_tDBInput_3.wasNull()){
                    row3.SUPPLIER_PRODUCT_SUPPLIER = null;
            }
		                    }
							if(colQtyInRs_tDBInput_3 < 66) {
								row3.SUPPLIER_PRODUCT_NUMBER = null;
							} else {
		                          
            row3.SUPPLIER_PRODUCT_NUMBER = rs_tDBInput_3.getInt(66);
            if(rs_tDBInput_3.wasNull()){
                    row3.SUPPLIER_PRODUCT_NUMBER = null;
            }
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
	 * [tAdvancedHash_row3 main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row3";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row3"
						
						);
					}
					


			   
			   

					row3Struct row3_HashRow = new row3Struct();
		   	   	   
				
				row3_HashRow.BULK_MOVEMENT_ID = row3.BULK_MOVEMENT_ID;
				
				row3_HashRow.BULK_PRODUCT_ID = row3.BULK_PRODUCT_ID;
				
				row3_HashRow.TERMINAL_PRODUCT_NUMBER = row3.TERMINAL_PRODUCT_NUMBER;
				
				row3_HashRow.MEASUREMENT_DEVICE_PARENT_CODE = row3.MEASUREMENT_DEVICE_PARENT_CODE;
				
				row3_HashRow.COMPARTMENT_NUMBER = row3.COMPARTMENT_NUMBER;
				
				row3_HashRow.MEASUREMENT_DEVICE_CODE = row3.MEASUREMENT_DEVICE_CODE;
				
				row3_HashRow.USER_INTERFACE_CODE = row3.USER_INTERFACE_CODE;
				
				row3_HashRow.MEASUREMENT_DEVICE_TYPE = row3.MEASUREMENT_DEVICE_TYPE;
				
				row3_HashRow.SNAPSHOT_TANK_CODE = row3.SNAPSHOT_TANK_CODE;
				
				row3_HashRow.CONTAINER_CODE = row3.CONTAINER_CODE;
				
				row3_HashRow.CONTAINER_TYPE = row3.CONTAINER_TYPE;
				
				row3_HashRow.COMPARTMENT_OWNER_ID = row3.COMPARTMENT_OWNER_ID;
				
				row3_HashRow.COMPARTMENT_CONTAINER_CODE = row3.COMPARTMENT_CONTAINER_CODE;
				
				row3_HashRow.SNAPSHOT_TYPE = row3.SNAPSHOT_TYPE;
				
				row3_HashRow.COMPARTMENT_CONTAINER_TYPE = row3.COMPARTMENT_CONTAINER_TYPE;
				
				row3_HashRow.FIGURES_TYPE = row3.FIGURES_TYPE;
				
				row3_HashRow.SNAPSHOT_FOLIO_NUMBER = row3.SNAPSHOT_FOLIO_NUMBER;
				
				row3_HashRow.SNAPSHOT_SEQUENCE_NUMBER = row3.SNAPSHOT_SEQUENCE_NUMBER;
				
				row3_HashRow.FSHOST_SI_PRODUCT_NUMBER = row3.FSHOST_SI_PRODUCT_NUMBER;
				
				row3_HashRow.TSHOST_SI_PRODUCT_NUMBER = row3.TSHOST_SI_PRODUCT_NUMBER;
				
				row3_HashRow.GROSS_QUANTITY = row3.GROSS_QUANTITY;
				
				row3_HashRow.NET_QUANTITY = row3.NET_QUANTITY;
				
				row3_HashRow.DENSITY = row3.DENSITY;
				
				row3_HashRow.TEMPERATURE = row3.TEMPERATURE;
				
				row3_HashRow.WEIGHT = row3.WEIGHT;
				
				row3_HashRow.OCTANE = row3.OCTANE;
				
				row3_HashRow.RVP = row3.RVP;
				
				row3_HashRow.COEFFICIENT_EXPANSION = row3.COEFFICIENT_EXPANSION;
				
				row3_HashRow.OXYGEN = row3.OXYGEN;
				
				row3_HashRow.SPECIFIC_GRAVITY = row3.SPECIFIC_GRAVITY;
				
				row3_HashRow.LAST_USER_NAME = row3.LAST_USER_NAME;
				
				row3_HashRow.LAST_MODIFIED = row3.LAST_MODIFIED;
				
				row3_HashRow.START_DATE = row3.START_DATE;
				
				row3_HashRow.END_DATE = row3.END_DATE;
				
				row3_HashRow.PRESSURE = row3.PRESSURE;
				
				row3_HashRow.FLOW_RATE = row3.FLOW_RATE;
				
				row3_HashRow.AVERAGE_METER_FACTOR = row3.AVERAGE_METER_FACTOR;
				
				row3_HashRow.VCF = row3.VCF;
				
				row3_HashRow.PCF = row3.PCF;
				
				row3_HashRow.OBSERVED_DENSITY = row3.OBSERVED_DENSITY;
				
				row3_HashRow.INVENTORY_QUANTITY_TYPE = row3.INVENTORY_QUANTITY_TYPE;
				
				row3_HashRow.MEASURED_DENSITY = row3.MEASURED_DENSITY;
				
				row3_HashRow.BSW_PERCENT = row3.BSW_PERCENT;
				
				row3_HashRow.WATER_VOLUME = row3.WATER_VOLUME;
				
				row3_HashRow.WEIGHT_IN_VAC = row3.WEIGHT_IN_VAC;
				
				row3_HashRow.GROSS_FRAC_QUANTITY = row3.GROSS_FRAC_QUANTITY;
				
				row3_HashRow.NET_FRAC_QUANTITY = row3.NET_FRAC_QUANTITY;
				
				row3_HashRow.LEVEL_CHANGE = row3.LEVEL_CHANGE;
				
				row3_HashRow.FRAC_WEIGHT = row3.FRAC_WEIGHT;
				
				row3_HashRow.FRAC_WEIGHT_IN_VAC = row3.FRAC_WEIGHT_IN_VAC;
				
				row3_HashRow.DIRECTION = row3.DIRECTION;
				
				row3_HashRow.DECLARED_GROSS_QUANTITY = row3.DECLARED_GROSS_QUANTITY;
				
				row3_HashRow.DECLARED_GROSS_FRAC_QUANTITY = row3.DECLARED_GROSS_FRAC_QUANTITY;
				
				row3_HashRow.DECLARED_NET_QUANTITY = row3.DECLARED_NET_QUANTITY;
				
				row3_HashRow.DECLARED_NET_FRAC_QUANTITY = row3.DECLARED_NET_FRAC_QUANTITY;
				
				row3_HashRow.DECLARED_WEIGHT = row3.DECLARED_WEIGHT;
				
				row3_HashRow.DECLARED_FRAC_WEIGHT = row3.DECLARED_FRAC_WEIGHT;
				
				row3_HashRow.DECLARED_WEIGHT_IN_VAC = row3.DECLARED_WEIGHT_IN_VAC;
				
				row3_HashRow.MEASURED_QUANTITY_TYPE = row3.MEASURED_QUANTITY_TYPE;
				
				row3_HashRow.DERIVED_VALUES_DIRECTIVE = row3.DERIVED_VALUES_DIRECTIVE;
				
				row3_HashRow.DECLARED_FRAC_WEIGHT_IN_VAC = row3.DECLARED_FRAC_WEIGHT_IN_VAC;
				
				row3_HashRow.CALCULATE_NET = row3.CALCULATE_NET;
				
				row3_HashRow.CONTAINER_OWNER_ID = row3.CONTAINER_OWNER_ID;
				
				row3_HashRow.AFFECT_ACCOUNTING = row3.AFFECT_ACCOUNTING;
				
				row3_HashRow.SUPPLIER_PRODUCT_SUPPLIER = row3.SUPPLIER_PRODUCT_SUPPLIER;
				
				row3_HashRow.SUPPLIER_PRODUCT_NUMBER = row3.SUPPLIER_PRODUCT_NUMBER;
				
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
	 * [tDBInput_3 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_3";

	

 



/**
 * [tDBInput_3 finally ] stop
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
		

		globalMap.put("tDBInput_3_SUBPROCESS_STATE", 1);
	}
	


public static class row4Struct implements routines.system.IPersistableComparableLookupRow<row4Struct> {
    final static byte[] commonByteArrayLock_PGS_STAGE_FACT_RESOURCES = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_FACT_RESOURCES = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public int PK_CONTAINER;

				public int getPK_CONTAINER () {
					return this.PK_CONTAINER;
				}
				
			    public int OWNER_ID;

				public int getOWNER_ID () {
					return this.OWNER_ID;
				}
				
			    public String CONTAINER_CODE;

				public String getCONTAINER_CODE () {
					return this.CONTAINER_CODE;
				}
				
			    public int CONTAINER_TYPE;

				public int getCONTAINER_TYPE () {
					return this.CONTAINER_TYPE;
				}
				
			    public String NAME;

				public String getNAME () {
					return this.NAME;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.CONTAINER_CODE == null) ? 0 : this.CONTAINER_CODE.hashCode());
					
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
		
						if (this.CONTAINER_CODE == null) {
							if (other.CONTAINER_CODE != null)
								return false;
						
						} else if (!this.CONTAINER_CODE.equals(other.CONTAINER_CODE))
						
							return false;
					

		return true;
    }

	public void copyDataTo(row4Struct other) {

		other.PK_CONTAINER = this.PK_CONTAINER;
	            other.OWNER_ID = this.OWNER_ID;
	            other.CONTAINER_CODE = this.CONTAINER_CODE;
	            other.CONTAINER_TYPE = this.CONTAINER_TYPE;
	            other.NAME = this.NAME;
	            
	}

	public void copyKeysDataTo(row4Struct other) {

		other.CONTAINER_CODE = this.CONTAINER_CODE;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PGS_STAGE_FACT_RESOURCES.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_FACT_RESOURCES.length == 0) {
   					commonByteArray_PGS_STAGE_FACT_RESOURCES = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_FACT_RESOURCES = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PGS_STAGE_FACT_RESOURCES, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_FACT_RESOURCES, 0, length, utf8Charset);
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
			if(length > commonByteArray_PGS_STAGE_FACT_RESOURCES.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_FACT_RESOURCES.length == 0) {
   					commonByteArray_PGS_STAGE_FACT_RESOURCES = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_FACT_RESOURCES = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PGS_STAGE_FACT_RESOURCES, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_FACT_RESOURCES, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PGS_STAGE_FACT_RESOURCES) {

        	try {

        		int length = 0;
		
					this.CONTAINER_CODE = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_FACT_RESOURCES) {

        	try {

        		int length = 0;
		
					this.CONTAINER_CODE = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.CONTAINER_CODE,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.CONTAINER_CODE,dos);
					
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
		
			            this.PK_CONTAINER = dis.readInt();
					
			            this.OWNER_ID = dis.readInt();
					
			            this.CONTAINER_TYPE = dis.readInt();
					
						this.NAME = readString(dis,ois);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
			            this.PK_CONTAINER = objectIn.readInt();
					
			            this.OWNER_ID = objectIn.readInt();
					
			            this.CONTAINER_TYPE = objectIn.readInt();
					
						this.NAME = readString(dis,objectIn);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
		            	dos.writeInt(this.PK_CONTAINER);
					
		            	dos.writeInt(this.OWNER_ID);
					
		            	dos.writeInt(this.CONTAINER_TYPE);
					
						writeString(this.NAME, dos, oos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
					objectOut.writeInt(this.PK_CONTAINER);
					
					objectOut.writeInt(this.OWNER_ID);
					
					objectOut.writeInt(this.CONTAINER_TYPE);
					
						writeString(this.NAME, dos, objectOut);
					
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
		sb.append("PK_CONTAINER="+String.valueOf(PK_CONTAINER));
		sb.append(",OWNER_ID="+String.valueOf(OWNER_ID));
		sb.append(",CONTAINER_CODE="+CONTAINER_CODE);
		sb.append(",CONTAINER_TYPE="+String.valueOf(CONTAINER_TYPE));
		sb.append(",NAME="+NAME);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row4Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.CONTAINER_CODE, other.CONTAINER_CODE);
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
			   		// linked node: tMap_1 - inputs:(row1,row2,row3,row4,row5) outputs:(out1)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row4 = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.ALL_MATCHES;
			   			
			   
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
				
				 
	final String decryptedPassword_tDBInput_4 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:93FOc46POE8Bwbakn3UUR8fQK5JzTFjo8r+Wla/P6mSj1kd8d1A=");
				
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

		    String dbquery_tDBInput_4 = "SELECT dbo.DIM_CONTAINER.PK_CONTAINER,\n		dbo.DIM_CONTAINER.OWNER_ID,\n		dbo.DIM_CONTAINER.CONTAINER_CODE,\n		dbo.DIM_CONT"
+"AINER.CONTAINER_TYPE,\n		dbo.DIM_CONTAINER.NAME\nFROM	dbo.DIM_CONTAINER";
		    

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
								row4.PK_CONTAINER = 0;
							} else {
		                          
            row4.PK_CONTAINER = rs_tDBInput_4.getInt(1);
            if(rs_tDBInput_4.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_4 < 2) {
								row4.OWNER_ID = 0;
							} else {
		                          
            row4.OWNER_ID = rs_tDBInput_4.getInt(2);
            if(rs_tDBInput_4.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_4 < 3) {
								row4.CONTAINER_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_4 = rs_tDBInput_4.getString(3);
            if(tmpContent_tDBInput_4 != null) {
            	if (talendToDBList_tDBInput_4 .contains(rsmd_tDBInput_4.getColumnTypeName(3).toUpperCase(java.util.Locale.ENGLISH))) {
            		row4.CONTAINER_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_4);
            	} else {
                	row4.CONTAINER_CODE = tmpContent_tDBInput_4;
                }
            } else {
                row4.CONTAINER_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_4 < 4) {
								row4.CONTAINER_TYPE = 0;
							} else {
		                          
            row4.CONTAINER_TYPE = rs_tDBInput_4.getInt(4);
            if(rs_tDBInput_4.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_4 < 5) {
								row4.NAME = null;
							} else {
	                         		
           		tmpContent_tDBInput_4 = rs_tDBInput_4.getString(5);
            if(tmpContent_tDBInput_4 != null) {
            	if (talendToDBList_tDBInput_4 .contains(rsmd_tDBInput_4.getColumnTypeName(5).toUpperCase(java.util.Locale.ENGLISH))) {
            		row4.NAME = FormatterUtils.formatUnwithE(tmpContent_tDBInput_4);
            	} else {
                	row4.NAME = tmpContent_tDBInput_4;
                }
            } else {
                row4.NAME = null;
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
		   	   	   
				
				row4_HashRow.PK_CONTAINER = row4.PK_CONTAINER;
				
				row4_HashRow.OWNER_ID = row4.OWNER_ID;
				
				row4_HashRow.CONTAINER_CODE = row4.CONTAINER_CODE;
				
				row4_HashRow.CONTAINER_TYPE = row4.CONTAINER_TYPE;
				
				row4_HashRow.NAME = row4.NAME;
				
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
    final static byte[] commonByteArrayLock_PGS_STAGE_FACT_RESOURCES = new byte[0];
    static byte[] commonByteArray_PGS_STAGE_FACT_RESOURCES = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public int PK_COMPARTMENT;

				public int getPK_COMPARTMENT () {
					return this.PK_COMPARTMENT;
				}
				
			    public String CONTAINER_CODE;

				public String getCONTAINER_CODE () {
					return this.CONTAINER_CODE;
				}
				
			    public int COMPARTMENT_NUMBER;

				public int getCOMPARTMENT_NUMBER () {
					return this.COMPARTMENT_NUMBER;
				}
				
			    public int CONTAINER_TYPE;

				public int getCONTAINER_TYPE () {
					return this.CONTAINER_TYPE;
				}
				
			    public java.util.Date LAST_MODIFIED;

				public java.util.Date getLAST_MODIFIED () {
					return this.LAST_MODIFIED;
				}
				
			    public int OWNER_ID;

				public int getOWNER_ID () {
					return this.OWNER_ID;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.CONTAINER_CODE == null) ? 0 : this.CONTAINER_CODE.hashCode());
					
							result = prime * result + (int) this.CONTAINER_TYPE;
						
							result = prime * result + (int) this.OWNER_ID;
						
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
		
						if (this.CONTAINER_CODE == null) {
							if (other.CONTAINER_CODE != null)
								return false;
						
						} else if (!this.CONTAINER_CODE.equals(other.CONTAINER_CODE))
						
							return false;
					
						if (this.CONTAINER_TYPE != other.CONTAINER_TYPE)
							return false;
					
						if (this.OWNER_ID != other.OWNER_ID)
							return false;
					

		return true;
    }

	public void copyDataTo(row5Struct other) {

		other.PK_COMPARTMENT = this.PK_COMPARTMENT;
	            other.CONTAINER_CODE = this.CONTAINER_CODE;
	            other.COMPARTMENT_NUMBER = this.COMPARTMENT_NUMBER;
	            other.CONTAINER_TYPE = this.CONTAINER_TYPE;
	            other.LAST_MODIFIED = this.LAST_MODIFIED;
	            other.OWNER_ID = this.OWNER_ID;
	            
	}

	public void copyKeysDataTo(row5Struct other) {

		other.CONTAINER_CODE = this.CONTAINER_CODE;
	            	other.CONTAINER_TYPE = this.CONTAINER_TYPE;
	            	other.OWNER_ID = this.OWNER_ID;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_PGS_STAGE_FACT_RESOURCES.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_FACT_RESOURCES.length == 0) {
   					commonByteArray_PGS_STAGE_FACT_RESOURCES = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_FACT_RESOURCES = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_PGS_STAGE_FACT_RESOURCES, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_FACT_RESOURCES, 0, length, utf8Charset);
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
			if(length > commonByteArray_PGS_STAGE_FACT_RESOURCES.length) {
				if(length < 1024 && commonByteArray_PGS_STAGE_FACT_RESOURCES.length == 0) {
   					commonByteArray_PGS_STAGE_FACT_RESOURCES = new byte[1024];
				} else {
   					commonByteArray_PGS_STAGE_FACT_RESOURCES = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_PGS_STAGE_FACT_RESOURCES, 0, length);
			strReturn = new String(commonByteArray_PGS_STAGE_FACT_RESOURCES, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_PGS_STAGE_FACT_RESOURCES) {

        	try {

        		int length = 0;
		
					this.CONTAINER_CODE = readString(dis);
					
			        this.CONTAINER_TYPE = dis.readInt();
					
			        this.OWNER_ID = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_PGS_STAGE_FACT_RESOURCES) {

        	try {

        		int length = 0;
		
					this.CONTAINER_CODE = readString(dis);
					
			        this.CONTAINER_TYPE = dis.readInt();
					
			        this.OWNER_ID = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.CONTAINER_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.CONTAINER_TYPE);
					
					// int
				
		            	dos.writeInt(this.OWNER_ID);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.CONTAINER_CODE,dos);
					
					// int
				
		            	dos.writeInt(this.CONTAINER_TYPE);
					
					// int
				
		            	dos.writeInt(this.OWNER_ID);
					
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
		
			            this.PK_COMPARTMENT = dis.readInt();
					
			            this.COMPARTMENT_NUMBER = dis.readInt();
					
						this.LAST_MODIFIED = readDate(dis,ois);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
			            this.PK_COMPARTMENT = objectIn.readInt();
					
			            this.COMPARTMENT_NUMBER = objectIn.readInt();
					
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

		
		            	dos.writeInt(this.PK_COMPARTMENT);
					
		            	dos.writeInt(this.COMPARTMENT_NUMBER);
					
						writeDate(this.LAST_MODIFIED, dos, oos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
					objectOut.writeInt(this.PK_COMPARTMENT);
					
					objectOut.writeInt(this.COMPARTMENT_NUMBER);
					
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
		sb.append("PK_COMPARTMENT="+String.valueOf(PK_COMPARTMENT));
		sb.append(",CONTAINER_CODE="+CONTAINER_CODE);
		sb.append(",COMPARTMENT_NUMBER="+String.valueOf(COMPARTMENT_NUMBER));
		sb.append(",CONTAINER_TYPE="+String.valueOf(CONTAINER_TYPE));
		sb.append(",LAST_MODIFIED="+String.valueOf(LAST_MODIFIED));
		sb.append(",OWNER_ID="+String.valueOf(OWNER_ID));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row5Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.CONTAINER_CODE, other.CONTAINER_CODE);
						if(returnValue != 0) {
							return returnValue;
						}

					
						returnValue = checkNullsAndCompare(this.CONTAINER_TYPE, other.CONTAINER_TYPE);
						if(returnValue != 0) {
							return returnValue;
						}

					
						returnValue = checkNullsAndCompare(this.OWNER_ID, other.OWNER_ID);
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
			   		// source node:tDBInput_5 - inputs:(after_tDBInput_1) outputs:(row5,row5) | target node:tAdvancedHash_row5 - inputs:(row5) outputs:()
			   		// linked node: tMap_1 - inputs:(row1,row2,row3,row4,row5) outputs:(out1)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row5 = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.ALL_MATCHES;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row5Struct> tHash_Lookup_row5 =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<row5Struct>getLookup(matchingModeEnum_row5);
	   						   
		   	   	   globalMap.put("tHash_Lookup_row5", tHash_Lookup_row5);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_row5 begin ] stop
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
				
				 
	final String decryptedPassword_tDBInput_5 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:wPJbSXm9oJWOin1P6xHocS49m9lj0rIT7IITATBLiPKWSlNg8NY=");
				
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

		    String dbquery_tDBInput_5 = "SELECT dbo.DIM_COMPARTMENT.PK_COMPARTMENT,\n		dbo.DIM_COMPARTMENT.CONTAINER_CODE,\n		dbo.DIM_COMPARTMENT.COMPARTMENT_NUMB"
+"ER,\n		dbo.DIM_COMPARTMENT.CONTAINER_TYPE,\n		dbo.DIM_COMPARTMENT.LAST_MODIFIED,\n		dbo.DIM_COMPARTMENT.OWNER_ID\nFROM	dbo.D"
+"IM_COMPARTMENT";
		    

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
								row5.PK_COMPARTMENT = 0;
							} else {
		                          
            row5.PK_COMPARTMENT = rs_tDBInput_5.getInt(1);
            if(rs_tDBInput_5.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_5 < 2) {
								row5.CONTAINER_CODE = null;
							} else {
	                         		
           		tmpContent_tDBInput_5 = rs_tDBInput_5.getString(2);
            if(tmpContent_tDBInput_5 != null) {
            	if (talendToDBList_tDBInput_5 .contains(rsmd_tDBInput_5.getColumnTypeName(2).toUpperCase(java.util.Locale.ENGLISH))) {
            		row5.CONTAINER_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_5);
            	} else {
                	row5.CONTAINER_CODE = tmpContent_tDBInput_5;
                }
            } else {
                row5.CONTAINER_CODE = null;
            }
		                    }
							if(colQtyInRs_tDBInput_5 < 3) {
								row5.COMPARTMENT_NUMBER = 0;
							} else {
		                          
            row5.COMPARTMENT_NUMBER = rs_tDBInput_5.getInt(3);
            if(rs_tDBInput_5.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_5 < 4) {
								row5.CONTAINER_TYPE = 0;
							} else {
		                          
            row5.CONTAINER_TYPE = rs_tDBInput_5.getInt(4);
            if(rs_tDBInput_5.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_5 < 5) {
								row5.LAST_MODIFIED = null;
							} else {
										
			row5.LAST_MODIFIED = mssqlGTU_tDBInput_5.getDate(rsmd_tDBInput_5, rs_tDBInput_5, 5);
			
		                    }
							if(colQtyInRs_tDBInput_5 < 6) {
								row5.OWNER_ID = 0;
							} else {
		                          
            row5.OWNER_ID = rs_tDBInput_5.getInt(6);
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
	 * [tAdvancedHash_row5 main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row5";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row5"
						
						);
					}
					


			   
			   

					row5Struct row5_HashRow = new row5Struct();
		   	   	   
				
				row5_HashRow.PK_COMPARTMENT = row5.PK_COMPARTMENT;
				
				row5_HashRow.CONTAINER_CODE = row5.CONTAINER_CODE;
				
				row5_HashRow.COMPARTMENT_NUMBER = row5.COMPARTMENT_NUMBER;
				
				row5_HashRow.CONTAINER_TYPE = row5.CONTAINER_TYPE;
				
				row5_HashRow.LAST_MODIFIED = row5.LAST_MODIFIED;
				
				row5_HashRow.OWNER_ID = row5.OWNER_ID;
				
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
	 * [tDBInput_5 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_5";

	

 



/**
 * [tDBInput_5 finally ] stop
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
		

		globalMap.put("tDBInput_5_SUBPROCESS_STATE", 1);
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
        final FACT_RESOURCES FACT_RESOURCESClass = new FACT_RESOURCES();

        int exitCode = FACT_RESOURCESClass.runJobInTOS(args);

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
            java.io.InputStream inContext = FACT_RESOURCES.class.getClassLoader().getResourceAsStream("pgs_stage/fact_resources_0_1/contexts/" + contextStr + ".properties");
            if (inContext == null) {
                inContext = FACT_RESOURCES.class.getClassLoader().getResourceAsStream("config/contexts/" + contextStr + ".properties");
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
            System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : FACT_RESOURCES");
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
 *     286564 characters generated by Talend Open Studio for Data Integration 
 *     on the 3 août 2024 à 14:42:25 GMT+01:00
 ************************************************************************************************/