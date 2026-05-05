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

package pgs_stage.fact_inventory_0_1;

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
 * Job: FACT_INVENTORY Purpose: <br>
 * Description: <br>
 * 
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status
 */
public class FACT_INVENTORY implements TalendJob {

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

	// contains type for every context property
	public class PropertiesWithType extends java.util.Properties {
		private static final long serialVersionUID = 1L;
		private java.util.Map<String, String> propertyTypes = new java.util.HashMap<>();

		public PropertiesWithType(java.util.Properties properties) {
			super(properties);
		}

		public PropertiesWithType() {
			super();
		}

		public void setContextType(String key, String type) {
			propertyTypes.put(key, type);
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

		public ContextProperties(java.util.Properties properties) {
			super(properties);
		}

		public ContextProperties() {
			super();
		}

		public void synchronizeContext() {

		}

		// if the stored or passed value is "<TALEND_NULL>" string, it mean null
		public String getStringValue(String key) {
			String origin_value = this.getProperty(key);
			if (NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY.equals(origin_value)) {
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
	private final String jobName = "FACT_INVENTORY";
	private final String projectName = "PGS_STAGE";
	public Integer errorCode = null;
	private String currentComponent = "";

	private final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();
	private final static java.util.Map<String, Object> junitGlobalMap = new java.util.HashMap<String, Object>();

	private final java.util.Map<String, Long> start_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Long> end_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Boolean> ok_Hash = new java.util.HashMap<String, Boolean>();
	public final java.util.List<String[]> globalBuffer = new java.util.ArrayList<String[]>();

	private RunStat runStat = new RunStat();

	// OSGi DataSource
	private final static String KEY_DB_DATASOURCES = "KEY_DB_DATASOURCES";

	private final static String KEY_DB_DATASOURCES_RAW = "KEY_DB_DATASOURCES_RAW";

	public void setDataSources(java.util.Map<String, javax.sql.DataSource> dataSources) {
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		for (java.util.Map.Entry<String, javax.sql.DataSource> dataSourceEntry : dataSources.entrySet()) {
			talendDataSources.put(dataSourceEntry.getKey(),
					new routines.system.TalendDataSource(dataSourceEntry.getValue()));
		}
		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}

	public void setDataSourceReferences(List serviceReferences) throws Exception {

		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		java.util.Map<String, javax.sql.DataSource> dataSources = new java.util.HashMap<String, javax.sql.DataSource>();

		for (java.util.Map.Entry<String, javax.sql.DataSource> entry : BundleUtils
				.getServices(serviceReferences, javax.sql.DataSource.class).entrySet()) {
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

		public void setVirtualComponentName(String virtualComponentName) {
			this.virtualComponentName = virtualComponentName;
		}

		private TalendException(Exception e, String errorComponent, final java.util.Map<String, Object> globalMap) {
			this.currentComponent = errorComponent;
			this.globalMap = globalMap;
			this.e = e;
		}

		public Exception getException() {
			return this.e;
		}

		public String getCurrentComponent() {
			return this.currentComponent;
		}

		public String getExceptionCauseMessage(Exception e) {
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
				if (virtualComponentName != null && currentComponent.indexOf(virtualComponentName + "_") == 0) {
					globalMap.put(virtualComponentName + "_ERROR_MESSAGE", getExceptionCauseMessage(e));
				}
				globalMap.put(currentComponent + "_ERROR_MESSAGE", getExceptionCauseMessage(e));
				System.err.println("Exception in component " + currentComponent + " (" + jobName + ")");
			}
			if (!(e instanceof TDieException)) {
				if (e instanceof TalendException) {
					e.printStackTrace();
				} else {
					e.printStackTrace();
					e.printStackTrace(errorMessagePS);
					FACT_INVENTORY.this.exception = e;
				}
			}
			if (!(e instanceof TalendException)) {
				try {
					for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
						if (m.getName().compareTo(currentComponent + "_error") == 0) {
							m.invoke(FACT_INVENTORY.this, new Object[] { e, currentComponent, globalMap });
							break;
						}
					}

					if (!(e instanceof TDieException)) {
					}
				} catch (Exception e) {
					this.e.printStackTrace();
				}
			}
		}
	}

	public void tDBInput_7_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_7_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tMap_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_7_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBOutput_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_7_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_7_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_7_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_3_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_7_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tAdvancedHash_row4_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_7_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tAdvancedHash_row2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_7_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tAdvancedHash_row3_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_7_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_7_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public static class out1Struct implements routines.system.IPersistableRow<out1Struct> {
		final static byte[] commonByteArrayLock_PGS_STAGE_FACT_INVENTORY = new byte[0];
		static byte[] commonByteArray_PGS_STAGE_FACT_INVENTORY = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public String FOLIO_NUMBER;

		public String getFOLIO_NUMBER() {
			return this.FOLIO_NUMBER;
		}

		public int PK_GAIN_LOSS_HISTORY;

		public int getPK_GAIN_LOSS_HISTORY() {
			return this.PK_GAIN_LOSS_HISTORY;
		}

		public int PK_METER_HISTORY;

		public int getPK_METER_HISTORY() {
			return this.PK_METER_HISTORY;
		}

		public int PK_BOOK_INVENTORY_HISTORY;

		public int getPK_BOOK_INVENTORY_HISTORY() {
			return this.PK_BOOK_INVENTORY_HISTORY;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + (int) this.PK_GAIN_LOSS_HISTORY;

				result = prime * result + (int) this.PK_METER_HISTORY;

				result = prime * result + (int) this.PK_BOOK_INVENTORY_HISTORY;

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final out1Struct other = (out1Struct) obj;

			if (this.PK_GAIN_LOSS_HISTORY != other.PK_GAIN_LOSS_HISTORY)
				return false;

			if (this.PK_METER_HISTORY != other.PK_METER_HISTORY)
				return false;

			if (this.PK_BOOK_INVENTORY_HISTORY != other.PK_BOOK_INVENTORY_HISTORY)
				return false;

			return true;
		}

		public void copyDataTo(out1Struct other) {

			other.FOLIO_NUMBER = this.FOLIO_NUMBER;
			other.PK_GAIN_LOSS_HISTORY = this.PK_GAIN_LOSS_HISTORY;
			other.PK_METER_HISTORY = this.PK_METER_HISTORY;
			other.PK_BOOK_INVENTORY_HISTORY = this.PK_BOOK_INVENTORY_HISTORY;

		}

		public void copyKeysDataTo(out1Struct other) {

			other.PK_GAIN_LOSS_HISTORY = this.PK_GAIN_LOSS_HISTORY;
			other.PK_METER_HISTORY = this.PK_METER_HISTORY;
			other.PK_BOOK_INVENTORY_HISTORY = this.PK_BOOK_INVENTORY_HISTORY;

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_PGS_STAGE_FACT_INVENTORY.length) {
					if (length < 1024 && commonByteArray_PGS_STAGE_FACT_INVENTORY.length == 0) {
						commonByteArray_PGS_STAGE_FACT_INVENTORY = new byte[1024];
					} else {
						commonByteArray_PGS_STAGE_FACT_INVENTORY = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_PGS_STAGE_FACT_INVENTORY, 0, length);
				strReturn = new String(commonByteArray_PGS_STAGE_FACT_INVENTORY, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_PGS_STAGE_FACT_INVENTORY.length) {
					if (length < 1024 && commonByteArray_PGS_STAGE_FACT_INVENTORY.length == 0) {
						commonByteArray_PGS_STAGE_FACT_INVENTORY = new byte[1024];
					} else {
						commonByteArray_PGS_STAGE_FACT_INVENTORY = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_PGS_STAGE_FACT_INVENTORY, 0, length);
				strReturn = new String(commonByteArray_PGS_STAGE_FACT_INVENTORY, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_PGS_STAGE_FACT_INVENTORY) {

				try {

					int length = 0;

					this.FOLIO_NUMBER = readString(dis);

					this.PK_GAIN_LOSS_HISTORY = dis.readInt();

					this.PK_METER_HISTORY = dis.readInt();

					this.PK_BOOK_INVENTORY_HISTORY = dis.readInt();

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_PGS_STAGE_FACT_INVENTORY) {

				try {

					int length = 0;

					this.FOLIO_NUMBER = readString(dis);

					this.PK_GAIN_LOSS_HISTORY = dis.readInt();

					this.PK_METER_HISTORY = dis.readInt();

					this.PK_BOOK_INVENTORY_HISTORY = dis.readInt();

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.FOLIO_NUMBER, dos);

				// int

				dos.writeInt(this.PK_GAIN_LOSS_HISTORY);

				// int

				dos.writeInt(this.PK_METER_HISTORY);

				// int

				dos.writeInt(this.PK_BOOK_INVENTORY_HISTORY);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.FOLIO_NUMBER, dos);

				// int

				dos.writeInt(this.PK_GAIN_LOSS_HISTORY);

				// int

				dos.writeInt(this.PK_METER_HISTORY);

				// int

				dos.writeInt(this.PK_BOOK_INVENTORY_HISTORY);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("FOLIO_NUMBER=" + FOLIO_NUMBER);
			sb.append(",PK_GAIN_LOSS_HISTORY=" + String.valueOf(PK_GAIN_LOSS_HISTORY));
			sb.append(",PK_METER_HISTORY=" + String.valueOf(PK_METER_HISTORY));
			sb.append(",PK_BOOK_INVENTORY_HISTORY=" + String.valueOf(PK_BOOK_INVENTORY_HISTORY));
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(out1Struct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.PK_GAIN_LOSS_HISTORY, other.PK_GAIN_LOSS_HISTORY);
			if (returnValue != 0) {
				return returnValue;
			}

			returnValue = checkNullsAndCompare(this.PK_METER_HISTORY, other.PK_METER_HISTORY);
			if (returnValue != 0) {
				return returnValue;
			}

			returnValue = checkNullsAndCompare(this.PK_BOOK_INVENTORY_HISTORY, other.PK_BOOK_INVENTORY_HISTORY);
			if (returnValue != 0) {
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
		final static byte[] commonByteArrayLock_PGS_STAGE_FACT_INVENTORY = new byte[0];
		static byte[] commonByteArray_PGS_STAGE_FACT_INVENTORY = new byte[0];

		public String FOLIO_NUMBER;

		public String getFOLIO_NUMBER() {
			return this.FOLIO_NUMBER;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_PGS_STAGE_FACT_INVENTORY.length) {
					if (length < 1024 && commonByteArray_PGS_STAGE_FACT_INVENTORY.length == 0) {
						commonByteArray_PGS_STAGE_FACT_INVENTORY = new byte[1024];
					} else {
						commonByteArray_PGS_STAGE_FACT_INVENTORY = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_PGS_STAGE_FACT_INVENTORY, 0, length);
				strReturn = new String(commonByteArray_PGS_STAGE_FACT_INVENTORY, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_PGS_STAGE_FACT_INVENTORY.length) {
					if (length < 1024 && commonByteArray_PGS_STAGE_FACT_INVENTORY.length == 0) {
						commonByteArray_PGS_STAGE_FACT_INVENTORY = new byte[1024];
					} else {
						commonByteArray_PGS_STAGE_FACT_INVENTORY = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_PGS_STAGE_FACT_INVENTORY, 0, length);
				strReturn = new String(commonByteArray_PGS_STAGE_FACT_INVENTORY, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_PGS_STAGE_FACT_INVENTORY) {

				try {

					int length = 0;

					this.FOLIO_NUMBER = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_PGS_STAGE_FACT_INVENTORY) {

				try {

					int length = 0;

					this.FOLIO_NUMBER = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.FOLIO_NUMBER, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.FOLIO_NUMBER, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("FOLIO_NUMBER=" + FOLIO_NUMBER);
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

	public static class after_tDBInput_7Struct implements routines.system.IPersistableRow<after_tDBInput_7Struct> {
		final static byte[] commonByteArrayLock_PGS_STAGE_FACT_INVENTORY = new byte[0];
		static byte[] commonByteArray_PGS_STAGE_FACT_INVENTORY = new byte[0];

		public String FOLIO_NUMBER;

		public String getFOLIO_NUMBER() {
			return this.FOLIO_NUMBER;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_PGS_STAGE_FACT_INVENTORY.length) {
					if (length < 1024 && commonByteArray_PGS_STAGE_FACT_INVENTORY.length == 0) {
						commonByteArray_PGS_STAGE_FACT_INVENTORY = new byte[1024];
					} else {
						commonByteArray_PGS_STAGE_FACT_INVENTORY = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_PGS_STAGE_FACT_INVENTORY, 0, length);
				strReturn = new String(commonByteArray_PGS_STAGE_FACT_INVENTORY, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_PGS_STAGE_FACT_INVENTORY.length) {
					if (length < 1024 && commonByteArray_PGS_STAGE_FACT_INVENTORY.length == 0) {
						commonByteArray_PGS_STAGE_FACT_INVENTORY = new byte[1024];
					} else {
						commonByteArray_PGS_STAGE_FACT_INVENTORY = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_PGS_STAGE_FACT_INVENTORY, 0, length);
				strReturn = new String(commonByteArray_PGS_STAGE_FACT_INVENTORY, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_PGS_STAGE_FACT_INVENTORY) {

				try {

					int length = 0;

					this.FOLIO_NUMBER = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_PGS_STAGE_FACT_INVENTORY) {

				try {

					int length = 0;

					this.FOLIO_NUMBER = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.FOLIO_NUMBER, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.FOLIO_NUMBER, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("FOLIO_NUMBER=" + FOLIO_NUMBER);
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(after_tDBInput_7Struct other) {

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
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				tDBInput_1Process(globalMap);
				tDBInput_2Process(globalMap);
				tDBInput_3Process(globalMap);

				row1Struct row1 = new row1Struct();
				out1Struct out1 = new out1Struct();

				/**
				 * [tDBOutput_1 begin ] start
				 */

				ok_Hash.put("tDBOutput_1", false);
				start_Hash.put("tDBOutput_1", System.currentTimeMillis());

				currentComponent = "tDBOutput_1";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "out1");
				}

				int tos_count_tDBOutput_1 = 0;

				int nb_line_tDBOutput_1 = 0;
				int nb_line_update_tDBOutput_1 = 0;
				int nb_line_inserted_tDBOutput_1 = 0;
				int nb_line_deleted_tDBOutput_1 = 0;
				int nb_line_rejected_tDBOutput_1 = 0;

				int deletedCount_tDBOutput_1 = 0;
				int updatedCount_tDBOutput_1 = 0;
				int insertedCount_tDBOutput_1 = 0;
				int rowsToCommitCount_tDBOutput_1 = 0;
				int rejectedCount_tDBOutput_1 = 0;
				String dbschema_tDBOutput_1 = null;
				String tableName_tDBOutput_1 = null;
				boolean whetherReject_tDBOutput_1 = false;

				java.util.Calendar calendar_tDBOutput_1 = java.util.Calendar.getInstance();
				long year1_tDBOutput_1 = TalendDate.parseDate("yyyy-MM-dd", "0001-01-01").getTime();
				long year2_tDBOutput_1 = TalendDate.parseDate("yyyy-MM-dd", "1753-01-01").getTime();
				long year10000_tDBOutput_1 = TalendDate.parseDate("yyyy-MM-dd HH:mm:ss", "9999-12-31 24:00:00")
						.getTime();
				long date_tDBOutput_1;

				java.util.Calendar calendar_datetimeoffset_tDBOutput_1 = java.util.Calendar
						.getInstance(java.util.TimeZone.getTimeZone("UTC"));

				java.sql.Connection conn_tDBOutput_1 = null;
				String dbUser_tDBOutput_1 = null;
				dbschema_tDBOutput_1 = "dbo";
				String driverClass_tDBOutput_1 = "net.sourceforge.jtds.jdbc.Driver";

				java.lang.Class.forName(driverClass_tDBOutput_1);
				String port_tDBOutput_1 = "1433";
				String dbname_tDBOutput_1 = "PGS_STAGE_DW";
				String url_tDBOutput_1 = "jdbc:jtds:sqlserver://" + "LAPTOP-HED7JE2F";
				if (!"".equals(port_tDBOutput_1)) {
					url_tDBOutput_1 += ":" + "1433";
				}
				if (!"".equals(dbname_tDBOutput_1)) {
					url_tDBOutput_1 += "//" + "PGS_STAGE_DW";

				}
				url_tDBOutput_1 += ";appName=" + projectName + ";" + "";
				dbUser_tDBOutput_1 = "sa";

				final String decryptedPassword_tDBOutput_1 = routines.system.PasswordEncryptUtil.decryptPassword(
						"enc:routine.encryption.key.v1:5CQzA6m/b5aNiVut8XAAOgxriG+bfKdQPjcL3jqKCY/9egJQxyc=");

				String dbPwd_tDBOutput_1 = decryptedPassword_tDBOutput_1;
				conn_tDBOutput_1 = java.sql.DriverManager.getConnection(url_tDBOutput_1, dbUser_tDBOutput_1,
						dbPwd_tDBOutput_1);

				resourceMap.put("conn_tDBOutput_1", conn_tDBOutput_1);

				conn_tDBOutput_1.setAutoCommit(false);
				int commitEvery_tDBOutput_1 = 10000;
				int commitCounter_tDBOutput_1 = 0;

				int batchSize_tDBOutput_1 = 10000;
				int batchSizeCounter_tDBOutput_1 = 0;

				if (dbschema_tDBOutput_1 == null || dbschema_tDBOutput_1.trim().length() == 0) {
					tableName_tDBOutput_1 = "FACT_INVENTORY";
				} else {
					tableName_tDBOutput_1 = dbschema_tDBOutput_1 + "].[" + "FACT_INVENTORY";
				}
				int count_tDBOutput_1 = 0;

				boolean whetherExist_tDBOutput_1 = false;
				try (java.sql.Statement isExistStmt_tDBOutput_1 = conn_tDBOutput_1.createStatement()) {
					try {
						isExistStmt_tDBOutput_1.execute("SELECT TOP 1 1 FROM [" + tableName_tDBOutput_1 + "]");
						whetherExist_tDBOutput_1 = true;
					} catch (java.lang.Exception e) {
						globalMap.put("tDBOutput_1_ERROR_MESSAGE", e.getMessage());
						whetherExist_tDBOutput_1 = false;
					}
				}
				if (whetherExist_tDBOutput_1) {
					try (java.sql.Statement stmtDrop_tDBOutput_1 = conn_tDBOutput_1.createStatement()) {
						stmtDrop_tDBOutput_1.execute("DROP TABLE [" + tableName_tDBOutput_1 + "]");
					}
				}
				try (java.sql.Statement stmtCreate_tDBOutput_1 = conn_tDBOutput_1.createStatement()) {
					stmtCreate_tDBOutput_1.execute("CREATE TABLE [" + tableName_tDBOutput_1
							+ "]([FOLIO_NUMBER] VARCHAR(8)   not null ,[PK_GAIN_LOSS_HISTORY] INT  not null ,[PK_METER_HISTORY] INT  not null ,[PK_BOOK_INVENTORY_HISTORY] INT  not null ,primary key([PK_GAIN_LOSS_HISTORY],[PK_METER_HISTORY],[PK_BOOK_INVENTORY_HISTORY]))");
				}
				String insert_tDBOutput_1 = "INSERT INTO [" + tableName_tDBOutput_1
						+ "] ([FOLIO_NUMBER],[PK_GAIN_LOSS_HISTORY],[PK_METER_HISTORY],[PK_BOOK_INVENTORY_HISTORY]) VALUES (?,?,?,?)";
				java.sql.PreparedStatement pstmt_tDBOutput_1 = conn_tDBOutput_1.prepareStatement(insert_tDBOutput_1);
				resourceMap.put("pstmt_tDBOutput_1", pstmt_tDBOutput_1);

				/**
				 * [tDBOutput_1 begin ] stop
				 */

				/**
				 * [tMap_1 begin ] start
				 */

				ok_Hash.put("tMap_1", false);
				start_Hash.put("tMap_1", System.currentTimeMillis());

				currentComponent = "tMap_1";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row1");
				}

				int tos_count_tMap_1 = 0;

// ###############################
// # Lookup's keys initialization

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct> tHash_Lookup_row2 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct>) ((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct>) globalMap
						.get("tHash_Lookup_row2"));

				row2Struct row2HashKey = new row2Struct();
				row2Struct row2Default = new row2Struct();

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct> tHash_Lookup_row3 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct>) ((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct>) globalMap
						.get("tHash_Lookup_row3"));

				row3Struct row3HashKey = new row3Struct();
				row3Struct row3Default = new row3Struct();

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row4Struct> tHash_Lookup_row4 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row4Struct>) ((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row4Struct>) globalMap
						.get("tHash_Lookup_row4"));

				row4Struct row4HashKey = new row4Struct();
				row4Struct row4Default = new row4Struct();
// ###############################        

// ###############################
// # Vars initialization
				class Var__tMap_1__Struct {
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
				 * [tDBInput_7 begin ] start
				 */

				ok_Hash.put("tDBInput_7", false);
				start_Hash.put("tDBInput_7", System.currentTimeMillis());

				currentComponent = "tDBInput_7";

				int tos_count_tDBInput_7 = 0;

				org.talend.designer.components.util.mssql.MSSqlGenerateTimestampUtil mssqlGTU_tDBInput_7 = org.talend.designer.components.util.mssql.MSSqlUtilFactory
						.getMSSqlGenerateTimestampUtil();

				java.util.List<String> talendToDBList_tDBInput_7 = new java.util.ArrayList();
				String[] talendToDBArray_tDBInput_7 = new String[] { "FLOAT", "NUMERIC", "NUMERIC IDENTITY", "DECIMAL",
						"DECIMAL IDENTITY", "REAL" };
				java.util.Collections.addAll(talendToDBList_tDBInput_7, talendToDBArray_tDBInput_7);
				int nb_line_tDBInput_7 = 0;
				java.sql.Connection conn_tDBInput_7 = null;
				String driverClass_tDBInput_7 = "net.sourceforge.jtds.jdbc.Driver";
				java.lang.Class jdbcclazz_tDBInput_7 = java.lang.Class.forName(driverClass_tDBInput_7);
				String dbUser_tDBInput_7 = "sa";

				final String decryptedPassword_tDBInput_7 = routines.system.PasswordEncryptUtil.decryptPassword(
						"enc:routine.encryption.key.v1:xxhUdUZot2mBLSk/1bYGgIwc5Pxlgdlasuv2/k77CeDlnQvl4K4=");

				String dbPwd_tDBInput_7 = decryptedPassword_tDBInput_7;

				String port_tDBInput_7 = "1433";
				String dbname_tDBInput_7 = "PGS_STAGE_DW";
				String url_tDBInput_7 = "jdbc:jtds:sqlserver://" + "LAPTOP-HED7JE2F";
				if (!"".equals(port_tDBInput_7)) {
					url_tDBInput_7 += ":" + "1433";
				}
				if (!"".equals(dbname_tDBInput_7)) {
					url_tDBInput_7 += "//" + "PGS_STAGE_DW";
				}
				url_tDBInput_7 += ";appName=" + projectName + ";" + "";
				String dbschema_tDBInput_7 = "dbo";

				conn_tDBInput_7 = java.sql.DriverManager.getConnection(url_tDBInput_7, dbUser_tDBInput_7,
						dbPwd_tDBInput_7);

				java.sql.Statement stmt_tDBInput_7 = conn_tDBInput_7.createStatement();

				String dbquery_tDBInput_7 = "SELECT dbo.FOLIO.FOLIO_NUMBER \nFROM	 dbo.FOLIO";

				globalMap.put("tDBInput_7_QUERY", dbquery_tDBInput_7);
				java.sql.ResultSet rs_tDBInput_7 = null;

				try {
					rs_tDBInput_7 = stmt_tDBInput_7.executeQuery(dbquery_tDBInput_7);
					java.sql.ResultSetMetaData rsmd_tDBInput_7 = rs_tDBInput_7.getMetaData();
					int colQtyInRs_tDBInput_7 = rsmd_tDBInput_7.getColumnCount();

					String tmpContent_tDBInput_7 = null;

					while (rs_tDBInput_7.next()) {
						nb_line_tDBInput_7++;

						if (colQtyInRs_tDBInput_7 < 1) {
							row1.FOLIO_NUMBER = null;
						} else {

							tmpContent_tDBInput_7 = rs_tDBInput_7.getString(1);
							if (tmpContent_tDBInput_7 != null) {
								if (talendToDBList_tDBInput_7.contains(
										rsmd_tDBInput_7.getColumnTypeName(1).toUpperCase(java.util.Locale.ENGLISH))) {
									row1.FOLIO_NUMBER = FormatterUtils.formatUnwithE(tmpContent_tDBInput_7);
								} else {
									row1.FOLIO_NUMBER = tmpContent_tDBInput_7;
								}
							} else {
								row1.FOLIO_NUMBER = null;
							}
						}

						/**
						 * [tDBInput_7 begin ] stop
						 */

						/**
						 * [tDBInput_7 main ] start
						 */

						currentComponent = "tDBInput_7";

						tos_count_tDBInput_7++;

						/**
						 * [tDBInput_7 main ] stop
						 */

						/**
						 * [tDBInput_7 process_data_begin ] start
						 */

						currentComponent = "tDBInput_7";

						/**
						 * [tDBInput_7 process_data_begin ] stop
						 */

						/**
						 * [tMap_1 main ] start
						 */

						currentComponent = "tMap_1";

						if (execStat) {
							runStat.updateStatOnConnection(iterateId, 1, 1

									, "row1"

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

						if (!rejectedInnerJoin_tMap_1) { // G_TM_M_020

							hasCasePrimitiveKeyWithNull_tMap_1 = false;

							row2HashKey.FOLIO_NUMBER = row1.FOLIO_NUMBER;

							row2HashKey.hashCodeDirty = true;

							tHash_Lookup_row2.lookup(row2HashKey);

							if (!tHash_Lookup_row2.hasNext()) { // G_TM_M_090

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

							if (!forceLooprow2) { // G 46

								fromLookup_row2 = tHash_Lookup_row2.next();

								if (fromLookup_row2 != null) {
									row2 = fromLookup_row2;
								}

							} // G 46

							forceLooprow2 = false;

							///////////////////////////////////////////////
							// Starting Lookup Table "row3"
							///////////////////////////////////////////////

							boolean forceLooprow3 = false;

							row3Struct row3ObjectFromLookup = null;

							if (!rejectedInnerJoin_tMap_1) { // G_TM_M_020

								hasCasePrimitiveKeyWithNull_tMap_1 = false;

								row3HashKey.FOLIO_NUMBER = row1.FOLIO_NUMBER;

								row3HashKey.hashCodeDirty = true;

								tHash_Lookup_row3.lookup(row3HashKey);

								if (!tHash_Lookup_row3.hasNext()) { // G_TM_M_090

									forceLooprow3 = true;

								} // G_TM_M_090

							} // G_TM_M_020

							else { // G 20 - G 21
								forceLooprow3 = true;
							} // G 21

							row3Struct row3 = null;

							while ((tHash_Lookup_row3 != null && tHash_Lookup_row3.hasNext()) || forceLooprow3) { // G_TM_M_043

								// CALL close loop of lookup 'row3'

								row3Struct fromLookup_row3 = null;
								row3 = row3Default;

								if (!forceLooprow3) { // G 46

									fromLookup_row3 = tHash_Lookup_row3.next();

									if (fromLookup_row3 != null) {
										row3 = fromLookup_row3;
									}

								} // G 46

								forceLooprow3 = false;

								///////////////////////////////////////////////
								// Starting Lookup Table "row4"
								///////////////////////////////////////////////

								boolean forceLooprow4 = false;

								row4Struct row4ObjectFromLookup = null;

								if (!rejectedInnerJoin_tMap_1) { // G_TM_M_020

									hasCasePrimitiveKeyWithNull_tMap_1 = false;

									row4HashKey.FOLIO_NUMBER = row1.FOLIO_NUMBER;

									row4HashKey.hashCodeDirty = true;

									tHash_Lookup_row4.lookup(row4HashKey);

									if (!tHash_Lookup_row4.hasNext()) { // G_TM_M_090

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

									if (!forceLooprow4) { // G 46

										fromLookup_row4 = tHash_Lookup_row4.next();

										if (fromLookup_row4 != null) {
											row4 = fromLookup_row4;
										}

									} // G 46

									forceLooprow4 = false;

									// ###############################
									{ // start of Var scope

										// ###############################
										// # Vars tables

										Var__tMap_1__Struct Var = Var__tMap_1;// ###############################
										// ###############################
										// # Output tables

										out1 = null;

// # Output table : 'out1'
										out1_tmp.FOLIO_NUMBER = row1.FOLIO_NUMBER;
										out1_tmp.PK_GAIN_LOSS_HISTORY = row2.PK_GAIN_LOSS_HISTORY;
										out1_tmp.PK_METER_HISTORY = row3.PK_METER_HISTORY;
										out1_tmp.PK_BOOK_INVENTORY_HISTORY = row4.PK_BOOK_INVENTORY_HISTORY;
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

									currentComponent = "tMap_1";

									/**
									 * [tMap_1 process_data_begin ] stop
									 */
// Start of branch "out1"
									if (out1 != null) {

										/**
										 * [tDBOutput_1 main ] start
										 */

										currentComponent = "tDBOutput_1";

										if (execStat) {
											runStat.updateStatOnConnection(iterateId, 1, 1

													, "out1"

											);
										}

										whetherReject_tDBOutput_1 = false;
										if (out1.FOLIO_NUMBER == null) {
											pstmt_tDBOutput_1.setNull(1, java.sql.Types.VARCHAR);
										} else {
											pstmt_tDBOutput_1.setString(1, out1.FOLIO_NUMBER);
										}

										pstmt_tDBOutput_1.setInt(2, out1.PK_GAIN_LOSS_HISTORY);

										pstmt_tDBOutput_1.setInt(3, out1.PK_METER_HISTORY);

										pstmt_tDBOutput_1.setInt(4, out1.PK_BOOK_INVENTORY_HISTORY);

										pstmt_tDBOutput_1.addBatch();
										nb_line_tDBOutput_1++;

										batchSizeCounter_tDBOutput_1++;

										////////// batch execute by batch size///////
										class LimitBytesHelper_tDBOutput_1 {
											public int limitBytePart1(int counter,
													java.sql.PreparedStatement pstmt_tDBOutput_1) throws Exception {
												try {

													for (int countEach_tDBOutput_1 : pstmt_tDBOutput_1.executeBatch()) {
														if (countEach_tDBOutput_1 == -2
																|| countEach_tDBOutput_1 == -3) {
															break;
														}
														counter += countEach_tDBOutput_1;
													}

												} catch (java.sql.BatchUpdateException e) {
													globalMap.put("tDBOutput_1_ERROR_MESSAGE", e.getMessage());

													int countSum_tDBOutput_1 = 0;
													for (int countEach_tDBOutput_1 : e.getUpdateCounts()) {
														counter += (countEach_tDBOutput_1 < 0 ? 0
																: countEach_tDBOutput_1);
													}

													System.err.println(e.getMessage());

												}
												return counter;
											}

											public int limitBytePart2(int counter,
													java.sql.PreparedStatement pstmt_tDBOutput_1) throws Exception {
												try {

													for (int countEach_tDBOutput_1 : pstmt_tDBOutput_1.executeBatch()) {
														if (countEach_tDBOutput_1 == -2
																|| countEach_tDBOutput_1 == -3) {
															break;
														}
														counter += countEach_tDBOutput_1;
													}

												} catch (java.sql.BatchUpdateException e) {
													globalMap.put("tDBOutput_1_ERROR_MESSAGE", e.getMessage());

													for (int countEach_tDBOutput_1 : e.getUpdateCounts()) {
														counter += (countEach_tDBOutput_1 < 0 ? 0
																: countEach_tDBOutput_1);
													}

													System.err.println(e.getMessage());

												}
												return counter;
											}
										}
										if ((batchSize_tDBOutput_1 > 0)
												&& (batchSize_tDBOutput_1 <= batchSizeCounter_tDBOutput_1)) {

											insertedCount_tDBOutput_1 = new LimitBytesHelper_tDBOutput_1()
													.limitBytePart1(insertedCount_tDBOutput_1, pstmt_tDBOutput_1);
											rowsToCommitCount_tDBOutput_1 = insertedCount_tDBOutput_1;

											batchSizeCounter_tDBOutput_1 = 0;
										}

										//////////// commit every////////////

										commitCounter_tDBOutput_1++;
										if (commitEvery_tDBOutput_1 <= commitCounter_tDBOutput_1) {
											if ((batchSize_tDBOutput_1 > 0) && (batchSizeCounter_tDBOutput_1 > 0)) {

												insertedCount_tDBOutput_1 = new LimitBytesHelper_tDBOutput_1()
														.limitBytePart1(insertedCount_tDBOutput_1, pstmt_tDBOutput_1);

												batchSizeCounter_tDBOutput_1 = 0;
											}
											if (rowsToCommitCount_tDBOutput_1 != 0) {

											}
											conn_tDBOutput_1.commit();
											if (rowsToCommitCount_tDBOutput_1 != 0) {

												rowsToCommitCount_tDBOutput_1 = 0;
											}
											commitCounter_tDBOutput_1 = 0;
										}

										tos_count_tDBOutput_1++;

										/**
										 * [tDBOutput_1 main ] stop
										 */

										/**
										 * [tDBOutput_1 process_data_begin ] start
										 */

										currentComponent = "tDBOutput_1";

										/**
										 * [tDBOutput_1 process_data_begin ] stop
										 */

										/**
										 * [tDBOutput_1 process_data_end ] start
										 */

										currentComponent = "tDBOutput_1";

										/**
										 * [tDBOutput_1 process_data_end ] stop
										 */

									} // End of branch "out1"

								} // close loop of lookup 'row4' // G_TM_M_043

							} // close loop of lookup 'row3' // G_TM_M_043

						} // close loop of lookup 'row2' // G_TM_M_043

						/**
						 * [tMap_1 process_data_end ] start
						 */

						currentComponent = "tMap_1";

						/**
						 * [tMap_1 process_data_end ] stop
						 */

						/**
						 * [tDBInput_7 process_data_end ] start
						 */

						currentComponent = "tDBInput_7";

						/**
						 * [tDBInput_7 process_data_end ] stop
						 */

						/**
						 * [tDBInput_7 end ] start
						 */

						currentComponent = "tDBInput_7";

					}
				} finally {
					if (rs_tDBInput_7 != null) {
						rs_tDBInput_7.close();
					}
					if (stmt_tDBInput_7 != null) {
						stmt_tDBInput_7.close();
					}
					if (conn_tDBInput_7 != null && !conn_tDBInput_7.isClosed()) {

						conn_tDBInput_7.close();

						if ("com.mysql.cj.jdbc.Driver".equals((String) globalMap.get("driverClass_"))
								&& routines.system.BundleUtils.inOSGi()) {
							Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread")
									.getMethod("checkedShutdown").invoke(null, (Object[]) null);
						}

					}
				}
				globalMap.put("tDBInput_7_NB_LINE", nb_line_tDBInput_7);

				ok_Hash.put("tDBInput_7", true);
				end_Hash.put("tDBInput_7", System.currentTimeMillis());

				/**
				 * [tDBInput_7 end ] stop
				 */

				/**
				 * [tMap_1 end ] start
				 */

				currentComponent = "tMap_1";

// ###############################
// # Lookup hashes releasing
				if (tHash_Lookup_row2 != null) {
					tHash_Lookup_row2.endGet();
				}
				globalMap.remove("tHash_Lookup_row2");

				if (tHash_Lookup_row3 != null) {
					tHash_Lookup_row3.endGet();
				}
				globalMap.remove("tHash_Lookup_row3");

				if (tHash_Lookup_row4 != null) {
					tHash_Lookup_row4.endGet();
				}
				globalMap.remove("tHash_Lookup_row4");

// ###############################      

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row1");
				}

				ok_Hash.put("tMap_1", true);
				end_Hash.put("tMap_1", System.currentTimeMillis());

				/**
				 * [tMap_1 end ] stop
				 */

				/**
				 * [tDBOutput_1 end ] start
				 */

				currentComponent = "tDBOutput_1";

				try {
					int countSum_tDBOutput_1 = 0;
					if (pstmt_tDBOutput_1 != null && batchSizeCounter_tDBOutput_1 > 0) {

						for (int countEach_tDBOutput_1 : pstmt_tDBOutput_1.executeBatch()) {
							if (countEach_tDBOutput_1 == -2 || countEach_tDBOutput_1 == -3) {
								break;
							}
							countSum_tDBOutput_1 += countEach_tDBOutput_1;
						}
						rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;

					}

					insertedCount_tDBOutput_1 += countSum_tDBOutput_1;

				} catch (java.sql.BatchUpdateException e) {
					globalMap.put("tDBOutput_1_ERROR_MESSAGE", e.getMessage());

					int countSum_tDBOutput_1 = 0;
					for (int countEach_tDBOutput_1 : e.getUpdateCounts()) {
						countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
					}
					rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;

					insertedCount_tDBOutput_1 += countSum_tDBOutput_1;

					System.err.println(e.getMessage());

				}
				if (pstmt_tDBOutput_1 != null) {

					pstmt_tDBOutput_1.close();
					resourceMap.remove("pstmt_tDBOutput_1");

				}
				resourceMap.put("statementClosed_tDBOutput_1", true);
				if (rowsToCommitCount_tDBOutput_1 != 0) {

				}
				conn_tDBOutput_1.commit();
				if (rowsToCommitCount_tDBOutput_1 != 0) {

					rowsToCommitCount_tDBOutput_1 = 0;
				}
				commitCounter_tDBOutput_1 = 0;
				conn_tDBOutput_1.close();
				resourceMap.put("finish_tDBOutput_1", true);

				nb_line_deleted_tDBOutput_1 = nb_line_deleted_tDBOutput_1 + deletedCount_tDBOutput_1;
				nb_line_update_tDBOutput_1 = nb_line_update_tDBOutput_1 + updatedCount_tDBOutput_1;
				nb_line_inserted_tDBOutput_1 = nb_line_inserted_tDBOutput_1 + insertedCount_tDBOutput_1;
				nb_line_rejected_tDBOutput_1 = nb_line_rejected_tDBOutput_1 + rejectedCount_tDBOutput_1;

				globalMap.put("tDBOutput_1_NB_LINE", nb_line_tDBOutput_1);
				globalMap.put("tDBOutput_1_NB_LINE_UPDATED", nb_line_update_tDBOutput_1);
				globalMap.put("tDBOutput_1_NB_LINE_INSERTED", nb_line_inserted_tDBOutput_1);
				globalMap.put("tDBOutput_1_NB_LINE_DELETED", nb_line_deleted_tDBOutput_1);
				globalMap.put("tDBOutput_1_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_1);

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "out1");
				}

				ok_Hash.put("tDBOutput_1", true);
				end_Hash.put("tDBOutput_1", System.currentTimeMillis());

				/**
				 * [tDBOutput_1 end ] stop
				 */

			} // end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			// free memory for "tMap_1"
			globalMap.remove("tHash_Lookup_row4");

			// free memory for "tMap_1"
			globalMap.remove("tHash_Lookup_row2");

			// free memory for "tMap_1"
			globalMap.remove("tHash_Lookup_row3");

			try {

				/**
				 * [tDBInput_7 finally ] start
				 */

				currentComponent = "tDBInput_7";

				/**
				 * [tDBInput_7 finally ] stop
				 */

				/**
				 * [tMap_1 finally ] start
				 */

				currentComponent = "tMap_1";

				/**
				 * [tMap_1 finally ] stop
				 */

				/**
				 * [tDBOutput_1 finally ] start
				 */

				currentComponent = "tDBOutput_1";

				try {
					if (resourceMap.get("statementClosed_tDBOutput_1") == null) {
						java.sql.PreparedStatement pstmtToClose_tDBOutput_1 = null;
						if ((pstmtToClose_tDBOutput_1 = (java.sql.PreparedStatement) resourceMap
								.remove("pstmt_tDBOutput_1")) != null) {
							pstmtToClose_tDBOutput_1.close();
						}
					}
				} finally {
					if (resourceMap.get("finish_tDBOutput_1") == null) {
						java.sql.Connection ctn_tDBOutput_1 = null;
						if ((ctn_tDBOutput_1 = (java.sql.Connection) resourceMap.get("conn_tDBOutput_1")) != null) {
							try {
								ctn_tDBOutput_1.close();
							} catch (java.sql.SQLException sqlEx_tDBOutput_1) {
								String errorMessage_tDBOutput_1 = "failed to close the connection in tDBOutput_1 :"
										+ sqlEx_tDBOutput_1.getMessage();
								System.err.println(errorMessage_tDBOutput_1);
							}
						}
					}
				}

				/**
				 * [tDBOutput_1 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBInput_7_SUBPROCESS_STATE", 1);
	}

	public static class row4Struct implements routines.system.IPersistableComparableLookupRow<row4Struct> {
		final static byte[] commonByteArrayLock_PGS_STAGE_FACT_INVENTORY = new byte[0];
		static byte[] commonByteArray_PGS_STAGE_FACT_INVENTORY = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public int PK_BOOK_INVENTORY_HISTORY;

		public int getPK_BOOK_INVENTORY_HISTORY() {
			return this.PK_BOOK_INVENTORY_HISTORY;
		}

		public String FOLIO_NUMBER;

		public String getFOLIO_NUMBER() {
			return this.FOLIO_NUMBER;
		}

		public String DATE;

		public String getDATE() {
			return this.DATE;
		}

		public int BOOK_INVENTORY_ID;

		public int getBOOK_INVENTORY_ID() {
			return this.BOOK_INVENTORY_ID;
		}

		public Integer SI_SUPPLIER_NUMBER;

		public Integer getSI_SUPPLIER_NUMBER() {
			return this.SI_SUPPLIER_NUMBER;
		}

		public Integer SI_TERMINAL_PRODUCT_NUMBER;

		public Integer getSI_TERMINAL_PRODUCT_NUMBER() {
			return this.SI_TERMINAL_PRODUCT_NUMBER;
		}

		public int INVENTORY_QUANTITY_TYPE;

		public int getINVENTORY_QUANTITY_TYPE() {
			return this.INVENTORY_QUANTITY_TYPE;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + ((this.FOLIO_NUMBER == null) ? 0 : this.FOLIO_NUMBER.hashCode());

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final row4Struct other = (row4Struct) obj;

			if (this.FOLIO_NUMBER == null) {
				if (other.FOLIO_NUMBER != null)
					return false;

			} else if (!this.FOLIO_NUMBER.equals(other.FOLIO_NUMBER))

				return false;

			return true;
		}

		public void copyDataTo(row4Struct other) {

			other.PK_BOOK_INVENTORY_HISTORY = this.PK_BOOK_INVENTORY_HISTORY;
			other.FOLIO_NUMBER = this.FOLIO_NUMBER;
			other.DATE = this.DATE;
			other.BOOK_INVENTORY_ID = this.BOOK_INVENTORY_ID;
			other.SI_SUPPLIER_NUMBER = this.SI_SUPPLIER_NUMBER;
			other.SI_TERMINAL_PRODUCT_NUMBER = this.SI_TERMINAL_PRODUCT_NUMBER;
			other.INVENTORY_QUANTITY_TYPE = this.INVENTORY_QUANTITY_TYPE;

		}

		public void copyKeysDataTo(row4Struct other) {

			other.FOLIO_NUMBER = this.FOLIO_NUMBER;

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_PGS_STAGE_FACT_INVENTORY.length) {
					if (length < 1024 && commonByteArray_PGS_STAGE_FACT_INVENTORY.length == 0) {
						commonByteArray_PGS_STAGE_FACT_INVENTORY = new byte[1024];
					} else {
						commonByteArray_PGS_STAGE_FACT_INVENTORY = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_PGS_STAGE_FACT_INVENTORY, 0, length);
				strReturn = new String(commonByteArray_PGS_STAGE_FACT_INVENTORY, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_PGS_STAGE_FACT_INVENTORY.length) {
					if (length < 1024 && commonByteArray_PGS_STAGE_FACT_INVENTORY.length == 0) {
						commonByteArray_PGS_STAGE_FACT_INVENTORY = new byte[1024];
					} else {
						commonByteArray_PGS_STAGE_FACT_INVENTORY = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_PGS_STAGE_FACT_INVENTORY, 0, length);
				strReturn = new String(commonByteArray_PGS_STAGE_FACT_INVENTORY, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		private String readString(DataInputStream dis, ObjectInputStream ois) throws IOException {
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

		private String readString(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller)
				throws IOException {
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

		private void writeString(String str, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller)
				throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		private void writeString(String str, DataOutputStream dos, ObjectOutputStream oos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private Integer readInteger(DataInputStream dis, ObjectInputStream ois) throws IOException {
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

		private Integer readInteger(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller)
				throws IOException {
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

		private void writeInteger(Integer intNum, DataOutputStream dos, ObjectOutputStream oos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller)
				throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		public void readKeysData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_PGS_STAGE_FACT_INVENTORY) {

				try {

					int length = 0;

					this.FOLIO_NUMBER = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_PGS_STAGE_FACT_INVENTORY) {

				try {

					int length = 0;

					this.FOLIO_NUMBER = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeKeysData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.FOLIO_NUMBER, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.FOLIO_NUMBER, dos);

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

				this.PK_BOOK_INVENTORY_HISTORY = dis.readInt();

				this.DATE = readString(dis, ois);

				this.BOOK_INVENTORY_ID = dis.readInt();

				this.SI_SUPPLIER_NUMBER = readInteger(dis, ois);

				this.SI_TERMINAL_PRODUCT_NUMBER = readInteger(dis, ois);

				this.INVENTORY_QUANTITY_TYPE = dis.readInt();

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
			try {
				int length = 0;

				this.PK_BOOK_INVENTORY_HISTORY = objectIn.readInt();

				this.DATE = readString(dis, objectIn);

				this.BOOK_INVENTORY_ID = objectIn.readInt();

				this.SI_SUPPLIER_NUMBER = readInteger(dis, objectIn);

				this.SI_TERMINAL_PRODUCT_NUMBER = readInteger(dis, objectIn);

				this.INVENTORY_QUANTITY_TYPE = objectIn.readInt();

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		/**
		 * Return a byte array which represents Values data.
		 */
		public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
			try {

				dos.writeInt(this.PK_BOOK_INVENTORY_HISTORY);

				writeString(this.DATE, dos, oos);

				dos.writeInt(this.BOOK_INVENTORY_ID);

				writeInteger(this.SI_SUPPLIER_NUMBER, dos, oos);

				writeInteger(this.SI_TERMINAL_PRODUCT_NUMBER, dos, oos);

				dos.writeInt(this.INVENTORY_QUANTITY_TYPE);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut) {
			try {

				objectOut.writeInt(this.PK_BOOK_INVENTORY_HISTORY);

				writeString(this.DATE, dos, objectOut);

				objectOut.writeInt(this.BOOK_INVENTORY_ID);

				writeInteger(this.SI_SUPPLIER_NUMBER, dos, objectOut);

				writeInteger(this.SI_TERMINAL_PRODUCT_NUMBER, dos, objectOut);

				objectOut.writeInt(this.INVENTORY_QUANTITY_TYPE);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		public boolean supportMarshaller() {
			return true;
		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("PK_BOOK_INVENTORY_HISTORY=" + String.valueOf(PK_BOOK_INVENTORY_HISTORY));
			sb.append(",FOLIO_NUMBER=" + FOLIO_NUMBER);
			sb.append(",DATE=" + DATE);
			sb.append(",BOOK_INVENTORY_ID=" + String.valueOf(BOOK_INVENTORY_ID));
			sb.append(",SI_SUPPLIER_NUMBER=" + String.valueOf(SI_SUPPLIER_NUMBER));
			sb.append(",SI_TERMINAL_PRODUCT_NUMBER=" + String.valueOf(SI_TERMINAL_PRODUCT_NUMBER));
			sb.append(",INVENTORY_QUANTITY_TYPE=" + String.valueOf(INVENTORY_QUANTITY_TYPE));
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row4Struct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.FOLIO_NUMBER, other.FOLIO_NUMBER);
			if (returnValue != 0) {
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
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				row4Struct row4 = new row4Struct();

				/**
				 * [tAdvancedHash_row4 begin ] start
				 */

				ok_Hash.put("tAdvancedHash_row4", false);
				start_Hash.put("tAdvancedHash_row4", System.currentTimeMillis());

				currentComponent = "tAdvancedHash_row4";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row4");
				}

				int tos_count_tAdvancedHash_row4 = 0;

				// connection name:row4
				// source node:tDBInput_1 - inputs:(after_tDBInput_7) outputs:(row4,row4) |
				// target node:tAdvancedHash_row4 - inputs:(row4) outputs:()
				// linked node: tMap_1 - inputs:(row1,row4,row2,row3) outputs:(out1)

				org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row4 = org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.ALL_MATCHES;

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row4Struct> tHash_Lookup_row4 = org.talend.designer.components.lookup.memory.AdvancedMemoryLookup
						.<row4Struct>getLookup(matchingModeEnum_row4);

				globalMap.put("tHash_Lookup_row4", tHash_Lookup_row4);

				/**
				 * [tAdvancedHash_row4 begin ] stop
				 */

				/**
				 * [tDBInput_1 begin ] start
				 */

				ok_Hash.put("tDBInput_1", false);
				start_Hash.put("tDBInput_1", System.currentTimeMillis());

				currentComponent = "tDBInput_1";

				int tos_count_tDBInput_1 = 0;

				org.talend.designer.components.util.mssql.MSSqlGenerateTimestampUtil mssqlGTU_tDBInput_1 = org.talend.designer.components.util.mssql.MSSqlUtilFactory
						.getMSSqlGenerateTimestampUtil();

				java.util.List<String> talendToDBList_tDBInput_1 = new java.util.ArrayList();
				String[] talendToDBArray_tDBInput_1 = new String[] { "FLOAT", "NUMERIC", "NUMERIC IDENTITY", "DECIMAL",
						"DECIMAL IDENTITY", "REAL" };
				java.util.Collections.addAll(talendToDBList_tDBInput_1, talendToDBArray_tDBInput_1);
				int nb_line_tDBInput_1 = 0;
				java.sql.Connection conn_tDBInput_1 = null;
				String driverClass_tDBInput_1 = "net.sourceforge.jtds.jdbc.Driver";
				java.lang.Class jdbcclazz_tDBInput_1 = java.lang.Class.forName(driverClass_tDBInput_1);
				String dbUser_tDBInput_1 = "sa";

				final String decryptedPassword_tDBInput_1 = routines.system.PasswordEncryptUtil.decryptPassword(
						"enc:routine.encryption.key.v1:/KW21Xk5z6MFY+yjD4GdM3v6nS0ehhAszpt8atjjdv8iUp9IKHw=");

				String dbPwd_tDBInput_1 = decryptedPassword_tDBInput_1;

				String port_tDBInput_1 = "1433";
				String dbname_tDBInput_1 = "PGS_STAGE_DW";
				String url_tDBInput_1 = "jdbc:jtds:sqlserver://" + "LAPTOP-HED7JE2F";
				if (!"".equals(port_tDBInput_1)) {
					url_tDBInput_1 += ":" + "1433";
				}
				if (!"".equals(dbname_tDBInput_1)) {
					url_tDBInput_1 += "//" + "PGS_STAGE_DW";
				}
				url_tDBInput_1 += ";appName=" + projectName + ";" + "";
				String dbschema_tDBInput_1 = "dbo";

				conn_tDBInput_1 = java.sql.DriverManager.getConnection(url_tDBInput_1, dbUser_tDBInput_1,
						dbPwd_tDBInput_1);

				java.sql.Statement stmt_tDBInput_1 = conn_tDBInput_1.createStatement();

				String dbquery_tDBInput_1 = "SELECT dbo.DIM_BOOK_INVENTORY_HISTORY.PK_BOOK_INVENTORY_HISTORY,\n		dbo.DIM_BOOK_INVENTORY_HISTORY.FOLIO_NUMBER,\n		dbo.D"
						+ "IM_BOOK_INVENTORY_HISTORY.DATE,\n		dbo.DIM_BOOK_INVENTORY_HISTORY.BOOK_INVENTORY_ID,\n		dbo.DIM_BOOK_INVENTORY_HISTORY.SI_"
						+ "SUPPLIER_NUMBER,\n		dbo.DIM_BOOK_INVENTORY_HISTORY.SI_TERMINAL_PRODUCT_NUMBER,\n		dbo.DIM_BOOK_INVENTORY_HISTORY.INVENTORY"
						+ "_QUANTITY_TYPE\nFROM	dbo.DIM_BOOK_INVENTORY_HISTORY";

				globalMap.put("tDBInput_1_QUERY", dbquery_tDBInput_1);
				java.sql.ResultSet rs_tDBInput_1 = null;

				try {
					rs_tDBInput_1 = stmt_tDBInput_1.executeQuery(dbquery_tDBInput_1);
					java.sql.ResultSetMetaData rsmd_tDBInput_1 = rs_tDBInput_1.getMetaData();
					int colQtyInRs_tDBInput_1 = rsmd_tDBInput_1.getColumnCount();

					String tmpContent_tDBInput_1 = null;

					while (rs_tDBInput_1.next()) {
						nb_line_tDBInput_1++;

						if (colQtyInRs_tDBInput_1 < 1) {
							row4.PK_BOOK_INVENTORY_HISTORY = 0;
						} else {

							row4.PK_BOOK_INVENTORY_HISTORY = rs_tDBInput_1.getInt(1);
							if (rs_tDBInput_1.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_1 < 2) {
							row4.FOLIO_NUMBER = null;
						} else {

							tmpContent_tDBInput_1 = rs_tDBInput_1.getString(2);
							if (tmpContent_tDBInput_1 != null) {
								if (talendToDBList_tDBInput_1.contains(
										rsmd_tDBInput_1.getColumnTypeName(2).toUpperCase(java.util.Locale.ENGLISH))) {
									row4.FOLIO_NUMBER = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
								} else {
									row4.FOLIO_NUMBER = tmpContent_tDBInput_1;
								}
							} else {
								row4.FOLIO_NUMBER = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 3) {
							row4.DATE = null;
						} else {

							tmpContent_tDBInput_1 = rs_tDBInput_1.getString(3);
							if (tmpContent_tDBInput_1 != null) {
								if (talendToDBList_tDBInput_1.contains(
										rsmd_tDBInput_1.getColumnTypeName(3).toUpperCase(java.util.Locale.ENGLISH))) {
									row4.DATE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
								} else {
									row4.DATE = tmpContent_tDBInput_1;
								}
							} else {
								row4.DATE = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 4) {
							row4.BOOK_INVENTORY_ID = 0;
						} else {

							row4.BOOK_INVENTORY_ID = rs_tDBInput_1.getInt(4);
							if (rs_tDBInput_1.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_1 < 5) {
							row4.SI_SUPPLIER_NUMBER = null;
						} else {

							row4.SI_SUPPLIER_NUMBER = rs_tDBInput_1.getInt(5);
							if (rs_tDBInput_1.wasNull()) {
								row4.SI_SUPPLIER_NUMBER = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 6) {
							row4.SI_TERMINAL_PRODUCT_NUMBER = null;
						} else {

							row4.SI_TERMINAL_PRODUCT_NUMBER = rs_tDBInput_1.getInt(6);
							if (rs_tDBInput_1.wasNull()) {
								row4.SI_TERMINAL_PRODUCT_NUMBER = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 7) {
							row4.INVENTORY_QUANTITY_TYPE = 0;
						} else {

							row4.INVENTORY_QUANTITY_TYPE = rs_tDBInput_1.getInt(7);
							if (rs_tDBInput_1.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}

						/**
						 * [tDBInput_1 begin ] stop
						 */

						/**
						 * [tDBInput_1 main ] start
						 */

						currentComponent = "tDBInput_1";

						tos_count_tDBInput_1++;

						/**
						 * [tDBInput_1 main ] stop
						 */

						/**
						 * [tDBInput_1 process_data_begin ] start
						 */

						currentComponent = "tDBInput_1";

						/**
						 * [tDBInput_1 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row4 main ] start
						 */

						currentComponent = "tAdvancedHash_row4";

						if (execStat) {
							runStat.updateStatOnConnection(iterateId, 1, 1

									, "row4"

							);
						}

						row4Struct row4_HashRow = new row4Struct();

						row4_HashRow.PK_BOOK_INVENTORY_HISTORY = row4.PK_BOOK_INVENTORY_HISTORY;

						row4_HashRow.FOLIO_NUMBER = row4.FOLIO_NUMBER;

						row4_HashRow.DATE = row4.DATE;

						row4_HashRow.BOOK_INVENTORY_ID = row4.BOOK_INVENTORY_ID;

						row4_HashRow.SI_SUPPLIER_NUMBER = row4.SI_SUPPLIER_NUMBER;

						row4_HashRow.SI_TERMINAL_PRODUCT_NUMBER = row4.SI_TERMINAL_PRODUCT_NUMBER;

						row4_HashRow.INVENTORY_QUANTITY_TYPE = row4.INVENTORY_QUANTITY_TYPE;

						tHash_Lookup_row4.put(row4_HashRow);

						tos_count_tAdvancedHash_row4++;

						/**
						 * [tAdvancedHash_row4 main ] stop
						 */

						/**
						 * [tAdvancedHash_row4 process_data_begin ] start
						 */

						currentComponent = "tAdvancedHash_row4";

						/**
						 * [tAdvancedHash_row4 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row4 process_data_end ] start
						 */

						currentComponent = "tAdvancedHash_row4";

						/**
						 * [tAdvancedHash_row4 process_data_end ] stop
						 */

						/**
						 * [tDBInput_1 process_data_end ] start
						 */

						currentComponent = "tDBInput_1";

						/**
						 * [tDBInput_1 process_data_end ] stop
						 */

						/**
						 * [tDBInput_1 end ] start
						 */

						currentComponent = "tDBInput_1";

					}
				} finally {
					if (rs_tDBInput_1 != null) {
						rs_tDBInput_1.close();
					}
					if (stmt_tDBInput_1 != null) {
						stmt_tDBInput_1.close();
					}
					if (conn_tDBInput_1 != null && !conn_tDBInput_1.isClosed()) {

						conn_tDBInput_1.close();

						if ("com.mysql.cj.jdbc.Driver".equals((String) globalMap.get("driverClass_"))
								&& routines.system.BundleUtils.inOSGi()) {
							Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread")
									.getMethod("checkedShutdown").invoke(null, (Object[]) null);
						}

					}
				}
				globalMap.put("tDBInput_1_NB_LINE", nb_line_tDBInput_1);

				ok_Hash.put("tDBInput_1", true);
				end_Hash.put("tDBInput_1", System.currentTimeMillis());

				/**
				 * [tDBInput_1 end ] stop
				 */

				/**
				 * [tAdvancedHash_row4 end ] start
				 */

				currentComponent = "tAdvancedHash_row4";

				tHash_Lookup_row4.endPut();

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row4");
				}

				ok_Hash.put("tAdvancedHash_row4", true);
				end_Hash.put("tAdvancedHash_row4", System.currentTimeMillis());

				/**
				 * [tAdvancedHash_row4 end ] stop
				 */

			} // end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tDBInput_1 finally ] start
				 */

				currentComponent = "tDBInput_1";

				/**
				 * [tDBInput_1 finally ] stop
				 */

				/**
				 * [tAdvancedHash_row4 finally ] start
				 */

				currentComponent = "tAdvancedHash_row4";

				/**
				 * [tAdvancedHash_row4 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBInput_1_SUBPROCESS_STATE", 1);
	}

	public static class row2Struct implements routines.system.IPersistableComparableLookupRow<row2Struct> {
		final static byte[] commonByteArrayLock_PGS_STAGE_FACT_INVENTORY = new byte[0];
		static byte[] commonByteArray_PGS_STAGE_FACT_INVENTORY = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public int PK_GAIN_LOSS_HISTORY;

		public int getPK_GAIN_LOSS_HISTORY() {
			return this.PK_GAIN_LOSS_HISTORY;
		}

		public int TERMINAL_PRODUCT_NUMBER;

		public int getTERMINAL_PRODUCT_NUMBER() {
			return this.TERMINAL_PRODUCT_NUMBER;
		}

		public java.util.Date DATE;

		public java.util.Date getDATE() {
			return this.DATE;
		}

		public String FOLIO_NUMBER;

		public String getFOLIO_NUMBER() {
			return this.FOLIO_NUMBER;
		}

		public String TANK_CODE;

		public String getTANK_CODE() {
			return this.TANK_CODE;
		}

		public int GAIN_LOSS_ID;

		public int getGAIN_LOSS_ID() {
			return this.GAIN_LOSS_ID;
		}

		public String PRODUCT_GROUP_CODE;

		public String getPRODUCT_GROUP_CODE() {
			return this.PRODUCT_GROUP_CODE;
		}

		public int OPENING_CALCULATION_POINT;

		public int getOPENING_CALCULATION_POINT() {
			return this.OPENING_CALCULATION_POINT;
		}

		public int CLOSING_CALCULATION_POINT;

		public int getCLOSING_CALCULATION_POINT() {
			return this.CLOSING_CALCULATION_POINT;
		}

		public int OPENING_PRODUCT_STRAP_TYPE;

		public int getOPENING_PRODUCT_STRAP_TYPE() {
			return this.OPENING_PRODUCT_STRAP_TYPE;
		}

		public String OPENING_API_CODE;

		public String getOPENING_API_CODE() {
			return this.OPENING_API_CODE;
		}

		public int CLOSING_PRODUCT_STRAP_TYPE;

		public int getCLOSING_PRODUCT_STRAP_TYPE() {
			return this.CLOSING_PRODUCT_STRAP_TYPE;
		}

		public String CLOSING_API_CODE;

		public String getCLOSING_API_CODE() {
			return this.CLOSING_API_CODE;
		}

		public int OPENING_TEMPERATURE_ORIGIN;

		public int getOPENING_TEMPERATURE_ORIGIN() {
			return this.OPENING_TEMPERATURE_ORIGIN;
		}

		public int CLOSING_TEMPERATURE_ORIGIN;

		public int getCLOSING_TEMPERATURE_ORIGIN() {
			return this.CLOSING_TEMPERATURE_ORIGIN;
		}

		public int INVENTORY_QUANTITY_TYPE;

		public int getINVENTORY_QUANTITY_TYPE() {
			return this.INVENTORY_QUANTITY_TYPE;
		}

		public int COMPARTMENT_VISIT_NUMBER;

		public int getCOMPARTMENT_VISIT_NUMBER() {
			return this.COMPARTMENT_VISIT_NUMBER;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + ((this.FOLIO_NUMBER == null) ? 0 : this.FOLIO_NUMBER.hashCode());

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final row2Struct other = (row2Struct) obj;

			if (this.FOLIO_NUMBER == null) {
				if (other.FOLIO_NUMBER != null)
					return false;

			} else if (!this.FOLIO_NUMBER.equals(other.FOLIO_NUMBER))

				return false;

			return true;
		}

		public void copyDataTo(row2Struct other) {

			other.PK_GAIN_LOSS_HISTORY = this.PK_GAIN_LOSS_HISTORY;
			other.TERMINAL_PRODUCT_NUMBER = this.TERMINAL_PRODUCT_NUMBER;
			other.DATE = this.DATE;
			other.FOLIO_NUMBER = this.FOLIO_NUMBER;
			other.TANK_CODE = this.TANK_CODE;
			other.GAIN_LOSS_ID = this.GAIN_LOSS_ID;
			other.PRODUCT_GROUP_CODE = this.PRODUCT_GROUP_CODE;
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

		public void copyKeysDataTo(row2Struct other) {

			other.FOLIO_NUMBER = this.FOLIO_NUMBER;

		}

		private java.util.Date readDate(DataInputStream dis, ObjectInputStream ois) throws IOException {
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

		private java.util.Date readDate(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller)
				throws IOException {
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

		private void writeDate(java.util.Date date1, DataOutputStream dos, ObjectOutputStream oos) throws IOException {
			if (date1 == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeLong(date1.getTime());
			}
		}

		private void writeDate(java.util.Date date1, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller)
				throws IOException {
			if (date1 == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeLong(date1.getTime());
			}
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_PGS_STAGE_FACT_INVENTORY.length) {
					if (length < 1024 && commonByteArray_PGS_STAGE_FACT_INVENTORY.length == 0) {
						commonByteArray_PGS_STAGE_FACT_INVENTORY = new byte[1024];
					} else {
						commonByteArray_PGS_STAGE_FACT_INVENTORY = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_PGS_STAGE_FACT_INVENTORY, 0, length);
				strReturn = new String(commonByteArray_PGS_STAGE_FACT_INVENTORY, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_PGS_STAGE_FACT_INVENTORY.length) {
					if (length < 1024 && commonByteArray_PGS_STAGE_FACT_INVENTORY.length == 0) {
						commonByteArray_PGS_STAGE_FACT_INVENTORY = new byte[1024];
					} else {
						commonByteArray_PGS_STAGE_FACT_INVENTORY = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_PGS_STAGE_FACT_INVENTORY, 0, length);
				strReturn = new String(commonByteArray_PGS_STAGE_FACT_INVENTORY, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		private String readString(DataInputStream dis, ObjectInputStream ois) throws IOException {
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

		private String readString(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller)
				throws IOException {
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

		private void writeString(String str, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller)
				throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		private void writeString(String str, DataOutputStream dos, ObjectOutputStream oos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		public void readKeysData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_PGS_STAGE_FACT_INVENTORY) {

				try {

					int length = 0;

					this.FOLIO_NUMBER = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_PGS_STAGE_FACT_INVENTORY) {

				try {

					int length = 0;

					this.FOLIO_NUMBER = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeKeysData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.FOLIO_NUMBER, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.FOLIO_NUMBER, dos);

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

				this.TERMINAL_PRODUCT_NUMBER = dis.readInt();

				this.DATE = readDate(dis, ois);

				this.TANK_CODE = readString(dis, ois);

				this.GAIN_LOSS_ID = dis.readInt();

				this.PRODUCT_GROUP_CODE = readString(dis, ois);

				this.OPENING_CALCULATION_POINT = dis.readInt();

				this.CLOSING_CALCULATION_POINT = dis.readInt();

				this.OPENING_PRODUCT_STRAP_TYPE = dis.readInt();

				this.OPENING_API_CODE = readString(dis, ois);

				this.CLOSING_PRODUCT_STRAP_TYPE = dis.readInt();

				this.CLOSING_API_CODE = readString(dis, ois);

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

				this.TERMINAL_PRODUCT_NUMBER = objectIn.readInt();

				this.DATE = readDate(dis, objectIn);

				this.TANK_CODE = readString(dis, objectIn);

				this.GAIN_LOSS_ID = objectIn.readInt();

				this.PRODUCT_GROUP_CODE = readString(dis, objectIn);

				this.OPENING_CALCULATION_POINT = objectIn.readInt();

				this.CLOSING_CALCULATION_POINT = objectIn.readInt();

				this.OPENING_PRODUCT_STRAP_TYPE = objectIn.readInt();

				this.OPENING_API_CODE = readString(dis, objectIn);

				this.CLOSING_PRODUCT_STRAP_TYPE = objectIn.readInt();

				this.CLOSING_API_CODE = readString(dis, objectIn);

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

				dos.writeInt(this.TERMINAL_PRODUCT_NUMBER);

				writeDate(this.DATE, dos, oos);

				writeString(this.TANK_CODE, dos, oos);

				dos.writeInt(this.GAIN_LOSS_ID);

				writeString(this.PRODUCT_GROUP_CODE, dos, oos);

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

		public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut) {
			try {

				objectOut.writeInt(this.PK_GAIN_LOSS_HISTORY);

				objectOut.writeInt(this.TERMINAL_PRODUCT_NUMBER);

				writeDate(this.DATE, dos, objectOut);

				writeString(this.TANK_CODE, dos, objectOut);

				objectOut.writeInt(this.GAIN_LOSS_ID);

				writeString(this.PRODUCT_GROUP_CODE, dos, objectOut);

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

		public boolean supportMarshaller() {
			return true;
		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("PK_GAIN_LOSS_HISTORY=" + String.valueOf(PK_GAIN_LOSS_HISTORY));
			sb.append(",TERMINAL_PRODUCT_NUMBER=" + String.valueOf(TERMINAL_PRODUCT_NUMBER));
			sb.append(",DATE=" + String.valueOf(DATE));
			sb.append(",FOLIO_NUMBER=" + FOLIO_NUMBER);
			sb.append(",TANK_CODE=" + TANK_CODE);
			sb.append(",GAIN_LOSS_ID=" + String.valueOf(GAIN_LOSS_ID));
			sb.append(",PRODUCT_GROUP_CODE=" + PRODUCT_GROUP_CODE);
			sb.append(",OPENING_CALCULATION_POINT=" + String.valueOf(OPENING_CALCULATION_POINT));
			sb.append(",CLOSING_CALCULATION_POINT=" + String.valueOf(CLOSING_CALCULATION_POINT));
			sb.append(",OPENING_PRODUCT_STRAP_TYPE=" + String.valueOf(OPENING_PRODUCT_STRAP_TYPE));
			sb.append(",OPENING_API_CODE=" + OPENING_API_CODE);
			sb.append(",CLOSING_PRODUCT_STRAP_TYPE=" + String.valueOf(CLOSING_PRODUCT_STRAP_TYPE));
			sb.append(",CLOSING_API_CODE=" + CLOSING_API_CODE);
			sb.append(",OPENING_TEMPERATURE_ORIGIN=" + String.valueOf(OPENING_TEMPERATURE_ORIGIN));
			sb.append(",CLOSING_TEMPERATURE_ORIGIN=" + String.valueOf(CLOSING_TEMPERATURE_ORIGIN));
			sb.append(",INVENTORY_QUANTITY_TYPE=" + String.valueOf(INVENTORY_QUANTITY_TYPE));
			sb.append(",COMPARTMENT_VISIT_NUMBER=" + String.valueOf(COMPARTMENT_VISIT_NUMBER));
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row2Struct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.FOLIO_NUMBER, other.FOLIO_NUMBER);
			if (returnValue != 0) {
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
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				row2Struct row2 = new row2Struct();

				/**
				 * [tAdvancedHash_row2 begin ] start
				 */

				ok_Hash.put("tAdvancedHash_row2", false);
				start_Hash.put("tAdvancedHash_row2", System.currentTimeMillis());

				currentComponent = "tAdvancedHash_row2";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row2");
				}

				int tos_count_tAdvancedHash_row2 = 0;

				// connection name:row2
				// source node:tDBInput_2 - inputs:(after_tDBInput_7) outputs:(row2,row2) |
				// target node:tAdvancedHash_row2 - inputs:(row2) outputs:()
				// linked node: tMap_1 - inputs:(row1,row4,row2,row3) outputs:(out1)

				org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row2 = org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.ALL_MATCHES;

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct> tHash_Lookup_row2 = org.talend.designer.components.lookup.memory.AdvancedMemoryLookup
						.<row2Struct>getLookup(matchingModeEnum_row2);

				globalMap.put("tHash_Lookup_row2", tHash_Lookup_row2);

				/**
				 * [tAdvancedHash_row2 begin ] stop
				 */

				/**
				 * [tDBInput_2 begin ] start
				 */

				ok_Hash.put("tDBInput_2", false);
				start_Hash.put("tDBInput_2", System.currentTimeMillis());

				currentComponent = "tDBInput_2";

				int tos_count_tDBInput_2 = 0;

				org.talend.designer.components.util.mssql.MSSqlGenerateTimestampUtil mssqlGTU_tDBInput_2 = org.talend.designer.components.util.mssql.MSSqlUtilFactory
						.getMSSqlGenerateTimestampUtil();

				java.util.List<String> talendToDBList_tDBInput_2 = new java.util.ArrayList();
				String[] talendToDBArray_tDBInput_2 = new String[] { "FLOAT", "NUMERIC", "NUMERIC IDENTITY", "DECIMAL",
						"DECIMAL IDENTITY", "REAL" };
				java.util.Collections.addAll(talendToDBList_tDBInput_2, talendToDBArray_tDBInput_2);
				int nb_line_tDBInput_2 = 0;
				java.sql.Connection conn_tDBInput_2 = null;
				String driverClass_tDBInput_2 = "net.sourceforge.jtds.jdbc.Driver";
				java.lang.Class jdbcclazz_tDBInput_2 = java.lang.Class.forName(driverClass_tDBInput_2);
				String dbUser_tDBInput_2 = "sa";

				final String decryptedPassword_tDBInput_2 = routines.system.PasswordEncryptUtil.decryptPassword(
						"enc:routine.encryption.key.v1:Zwr4eKD3tDI+xo0NG9ubeoJnTSgtuWEUwonoulmlXIwrCEpK4dM=");

				String dbPwd_tDBInput_2 = decryptedPassword_tDBInput_2;

				String port_tDBInput_2 = "1433";
				String dbname_tDBInput_2 = "PGS_STAGE_DW";
				String url_tDBInput_2 = "jdbc:jtds:sqlserver://" + "LAPTOP-HED7JE2F";
				if (!"".equals(port_tDBInput_2)) {
					url_tDBInput_2 += ":" + "1433";
				}
				if (!"".equals(dbname_tDBInput_2)) {
					url_tDBInput_2 += "//" + "PGS_STAGE_DW";
				}
				url_tDBInput_2 += ";appName=" + projectName + ";" + "";
				String dbschema_tDBInput_2 = "dbo";

				conn_tDBInput_2 = java.sql.DriverManager.getConnection(url_tDBInput_2, dbUser_tDBInput_2,
						dbPwd_tDBInput_2);

				java.sql.Statement stmt_tDBInput_2 = conn_tDBInput_2.createStatement();

				String dbquery_tDBInput_2 = "SELECT dbo.DIM_GAIN_LOSS_HISTORY.PK_GAIN_LOSS_HISTORY,\n		dbo.DIM_GAIN_LOSS_HISTORY.TERMINAL_PRODUCT_NUMBER,\n		dbo.DIM_G"
						+ "AIN_LOSS_HISTORY.DATE,\n		dbo.DIM_GAIN_LOSS_HISTORY.FOLIO_NUMBER,\n		dbo.DIM_GAIN_LOSS_HISTORY.TANK_CODE,\n		dbo.DIM_GAIN_L"
						+ "OSS_HISTORY.GAIN_LOSS_ID,\n		dbo.DIM_GAIN_LOSS_HISTORY.PRODUCT_GROUP_CODE,\n		dbo.DIM_GAIN_LOSS_HISTORY.OPENING_CALCULATIO"
						+ "N_POINT,\n		dbo.DIM_GAIN_LOSS_HISTORY.CLOSING_CALCULATION_POINT,\n		dbo.DIM_GAIN_LOSS_HISTORY.OPENING_PRODUCT_STRAP_TYPE,\n"
						+ "		dbo.DIM_GAIN_LOSS_HISTORY.OPENING_API_CODE,\n		dbo.DIM_GAIN_LOSS_HISTORY.CLOSING_PRODUCT_STRAP_TYPE,\n		dbo.DIM_GAIN_LOS"
						+ "S_HISTORY.CLOSING_API_CODE,\n		dbo.DIM_GAIN_LOSS_HISTORY.OPENING_TEMPERATURE_ORIGIN,\n		dbo.DIM_GAIN_LOSS_HISTORY.CLOSING_"
						+ "TEMPERATURE_ORIGIN,\n		dbo.DIM_GAIN_LOSS_HISTORY.INVENTORY_QUANTITY_TYPE,\n		dbo.DIM_GAIN_LOSS_HISTORY.COMPARTMENT_VISIT_N"
						+ "UMBER\nFROM	dbo.DIM_GAIN_LOSS_HISTORY";

				globalMap.put("tDBInput_2_QUERY", dbquery_tDBInput_2);
				java.sql.ResultSet rs_tDBInput_2 = null;

				try {
					rs_tDBInput_2 = stmt_tDBInput_2.executeQuery(dbquery_tDBInput_2);
					java.sql.ResultSetMetaData rsmd_tDBInput_2 = rs_tDBInput_2.getMetaData();
					int colQtyInRs_tDBInput_2 = rsmd_tDBInput_2.getColumnCount();

					String tmpContent_tDBInput_2 = null;

					while (rs_tDBInput_2.next()) {
						nb_line_tDBInput_2++;

						if (colQtyInRs_tDBInput_2 < 1) {
							row2.PK_GAIN_LOSS_HISTORY = 0;
						} else {

							row2.PK_GAIN_LOSS_HISTORY = rs_tDBInput_2.getInt(1);
							if (rs_tDBInput_2.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_2 < 2) {
							row2.TERMINAL_PRODUCT_NUMBER = 0;
						} else {

							row2.TERMINAL_PRODUCT_NUMBER = rs_tDBInput_2.getInt(2);
							if (rs_tDBInput_2.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_2 < 3) {
							row2.DATE = null;
						} else {

							row2.DATE = mssqlGTU_tDBInput_2.getDate(rsmd_tDBInput_2, rs_tDBInput_2, 3);

						}
						if (colQtyInRs_tDBInput_2 < 4) {
							row2.FOLIO_NUMBER = null;
						} else {

							tmpContent_tDBInput_2 = rs_tDBInput_2.getString(4);
							if (tmpContent_tDBInput_2 != null) {
								if (talendToDBList_tDBInput_2.contains(
										rsmd_tDBInput_2.getColumnTypeName(4).toUpperCase(java.util.Locale.ENGLISH))) {
									row2.FOLIO_NUMBER = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
								} else {
									row2.FOLIO_NUMBER = tmpContent_tDBInput_2;
								}
							} else {
								row2.FOLIO_NUMBER = null;
							}
						}
						if (colQtyInRs_tDBInput_2 < 5) {
							row2.TANK_CODE = null;
						} else {

							tmpContent_tDBInput_2 = rs_tDBInput_2.getString(5);
							if (tmpContent_tDBInput_2 != null) {
								if (talendToDBList_tDBInput_2.contains(
										rsmd_tDBInput_2.getColumnTypeName(5).toUpperCase(java.util.Locale.ENGLISH))) {
									row2.TANK_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
								} else {
									row2.TANK_CODE = tmpContent_tDBInput_2;
								}
							} else {
								row2.TANK_CODE = null;
							}
						}
						if (colQtyInRs_tDBInput_2 < 6) {
							row2.GAIN_LOSS_ID = 0;
						} else {

							row2.GAIN_LOSS_ID = rs_tDBInput_2.getInt(6);
							if (rs_tDBInput_2.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_2 < 7) {
							row2.PRODUCT_GROUP_CODE = null;
						} else {

							tmpContent_tDBInput_2 = rs_tDBInput_2.getString(7);
							if (tmpContent_tDBInput_2 != null) {
								if (talendToDBList_tDBInput_2.contains(
										rsmd_tDBInput_2.getColumnTypeName(7).toUpperCase(java.util.Locale.ENGLISH))) {
									row2.PRODUCT_GROUP_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
								} else {
									row2.PRODUCT_GROUP_CODE = tmpContent_tDBInput_2;
								}
							} else {
								row2.PRODUCT_GROUP_CODE = null;
							}
						}
						if (colQtyInRs_tDBInput_2 < 8) {
							row2.OPENING_CALCULATION_POINT = 0;
						} else {

							row2.OPENING_CALCULATION_POINT = rs_tDBInput_2.getInt(8);
							if (rs_tDBInput_2.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_2 < 9) {
							row2.CLOSING_CALCULATION_POINT = 0;
						} else {

							row2.CLOSING_CALCULATION_POINT = rs_tDBInput_2.getInt(9);
							if (rs_tDBInput_2.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_2 < 10) {
							row2.OPENING_PRODUCT_STRAP_TYPE = 0;
						} else {

							row2.OPENING_PRODUCT_STRAP_TYPE = rs_tDBInput_2.getInt(10);
							if (rs_tDBInput_2.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_2 < 11) {
							row2.OPENING_API_CODE = null;
						} else {

							tmpContent_tDBInput_2 = rs_tDBInput_2.getString(11);
							if (tmpContent_tDBInput_2 != null) {
								if (talendToDBList_tDBInput_2.contains(
										rsmd_tDBInput_2.getColumnTypeName(11).toUpperCase(java.util.Locale.ENGLISH))) {
									row2.OPENING_API_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
								} else {
									row2.OPENING_API_CODE = tmpContent_tDBInput_2;
								}
							} else {
								row2.OPENING_API_CODE = null;
							}
						}
						if (colQtyInRs_tDBInput_2 < 12) {
							row2.CLOSING_PRODUCT_STRAP_TYPE = 0;
						} else {

							row2.CLOSING_PRODUCT_STRAP_TYPE = rs_tDBInput_2.getInt(12);
							if (rs_tDBInput_2.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_2 < 13) {
							row2.CLOSING_API_CODE = null;
						} else {

							tmpContent_tDBInput_2 = rs_tDBInput_2.getString(13);
							if (tmpContent_tDBInput_2 != null) {
								if (talendToDBList_tDBInput_2.contains(
										rsmd_tDBInput_2.getColumnTypeName(13).toUpperCase(java.util.Locale.ENGLISH))) {
									row2.CLOSING_API_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_2);
								} else {
									row2.CLOSING_API_CODE = tmpContent_tDBInput_2;
								}
							} else {
								row2.CLOSING_API_CODE = null;
							}
						}
						if (colQtyInRs_tDBInput_2 < 14) {
							row2.OPENING_TEMPERATURE_ORIGIN = 0;
						} else {

							row2.OPENING_TEMPERATURE_ORIGIN = rs_tDBInput_2.getInt(14);
							if (rs_tDBInput_2.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_2 < 15) {
							row2.CLOSING_TEMPERATURE_ORIGIN = 0;
						} else {

							row2.CLOSING_TEMPERATURE_ORIGIN = rs_tDBInput_2.getInt(15);
							if (rs_tDBInput_2.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_2 < 16) {
							row2.INVENTORY_QUANTITY_TYPE = 0;
						} else {

							row2.INVENTORY_QUANTITY_TYPE = rs_tDBInput_2.getInt(16);
							if (rs_tDBInput_2.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_2 < 17) {
							row2.COMPARTMENT_VISIT_NUMBER = 0;
						} else {

							row2.COMPARTMENT_VISIT_NUMBER = rs_tDBInput_2.getInt(17);
							if (rs_tDBInput_2.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}

						/**
						 * [tDBInput_2 begin ] stop
						 */

						/**
						 * [tDBInput_2 main ] start
						 */

						currentComponent = "tDBInput_2";

						tos_count_tDBInput_2++;

						/**
						 * [tDBInput_2 main ] stop
						 */

						/**
						 * [tDBInput_2 process_data_begin ] start
						 */

						currentComponent = "tDBInput_2";

						/**
						 * [tDBInput_2 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row2 main ] start
						 */

						currentComponent = "tAdvancedHash_row2";

						if (execStat) {
							runStat.updateStatOnConnection(iterateId, 1, 1

									, "row2"

							);
						}

						row2Struct row2_HashRow = new row2Struct();

						row2_HashRow.PK_GAIN_LOSS_HISTORY = row2.PK_GAIN_LOSS_HISTORY;

						row2_HashRow.TERMINAL_PRODUCT_NUMBER = row2.TERMINAL_PRODUCT_NUMBER;

						row2_HashRow.DATE = row2.DATE;

						row2_HashRow.FOLIO_NUMBER = row2.FOLIO_NUMBER;

						row2_HashRow.TANK_CODE = row2.TANK_CODE;

						row2_HashRow.GAIN_LOSS_ID = row2.GAIN_LOSS_ID;

						row2_HashRow.PRODUCT_GROUP_CODE = row2.PRODUCT_GROUP_CODE;

						row2_HashRow.OPENING_CALCULATION_POINT = row2.OPENING_CALCULATION_POINT;

						row2_HashRow.CLOSING_CALCULATION_POINT = row2.CLOSING_CALCULATION_POINT;

						row2_HashRow.OPENING_PRODUCT_STRAP_TYPE = row2.OPENING_PRODUCT_STRAP_TYPE;

						row2_HashRow.OPENING_API_CODE = row2.OPENING_API_CODE;

						row2_HashRow.CLOSING_PRODUCT_STRAP_TYPE = row2.CLOSING_PRODUCT_STRAP_TYPE;

						row2_HashRow.CLOSING_API_CODE = row2.CLOSING_API_CODE;

						row2_HashRow.OPENING_TEMPERATURE_ORIGIN = row2.OPENING_TEMPERATURE_ORIGIN;

						row2_HashRow.CLOSING_TEMPERATURE_ORIGIN = row2.CLOSING_TEMPERATURE_ORIGIN;

						row2_HashRow.INVENTORY_QUANTITY_TYPE = row2.INVENTORY_QUANTITY_TYPE;

						row2_HashRow.COMPARTMENT_VISIT_NUMBER = row2.COMPARTMENT_VISIT_NUMBER;

						tHash_Lookup_row2.put(row2_HashRow);

						tos_count_tAdvancedHash_row2++;

						/**
						 * [tAdvancedHash_row2 main ] stop
						 */

						/**
						 * [tAdvancedHash_row2 process_data_begin ] start
						 */

						currentComponent = "tAdvancedHash_row2";

						/**
						 * [tAdvancedHash_row2 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row2 process_data_end ] start
						 */

						currentComponent = "tAdvancedHash_row2";

						/**
						 * [tAdvancedHash_row2 process_data_end ] stop
						 */

						/**
						 * [tDBInput_2 process_data_end ] start
						 */

						currentComponent = "tDBInput_2";

						/**
						 * [tDBInput_2 process_data_end ] stop
						 */

						/**
						 * [tDBInput_2 end ] start
						 */

						currentComponent = "tDBInput_2";

					}
				} finally {
					if (rs_tDBInput_2 != null) {
						rs_tDBInput_2.close();
					}
					if (stmt_tDBInput_2 != null) {
						stmt_tDBInput_2.close();
					}
					if (conn_tDBInput_2 != null && !conn_tDBInput_2.isClosed()) {

						conn_tDBInput_2.close();

						if ("com.mysql.cj.jdbc.Driver".equals((String) globalMap.get("driverClass_"))
								&& routines.system.BundleUtils.inOSGi()) {
							Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread")
									.getMethod("checkedShutdown").invoke(null, (Object[]) null);
						}

					}
				}
				globalMap.put("tDBInput_2_NB_LINE", nb_line_tDBInput_2);

				ok_Hash.put("tDBInput_2", true);
				end_Hash.put("tDBInput_2", System.currentTimeMillis());

				/**
				 * [tDBInput_2 end ] stop
				 */

				/**
				 * [tAdvancedHash_row2 end ] start
				 */

				currentComponent = "tAdvancedHash_row2";

				tHash_Lookup_row2.endPut();

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row2");
				}

				ok_Hash.put("tAdvancedHash_row2", true);
				end_Hash.put("tAdvancedHash_row2", System.currentTimeMillis());

				/**
				 * [tAdvancedHash_row2 end ] stop
				 */

			} // end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tDBInput_2 finally ] start
				 */

				currentComponent = "tDBInput_2";

				/**
				 * [tDBInput_2 finally ] stop
				 */

				/**
				 * [tAdvancedHash_row2 finally ] start
				 */

				currentComponent = "tAdvancedHash_row2";

				/**
				 * [tAdvancedHash_row2 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBInput_2_SUBPROCESS_STATE", 1);
	}

	public static class row3Struct implements routines.system.IPersistableComparableLookupRow<row3Struct> {
		final static byte[] commonByteArrayLock_PGS_STAGE_FACT_INVENTORY = new byte[0];
		static byte[] commonByteArray_PGS_STAGE_FACT_INVENTORY = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public int PK_METER_HISTORY;

		public int getPK_METER_HISTORY() {
			return this.PK_METER_HISTORY;
		}

		public String PRESET_CODE;

		public String getPRESET_CODE() {
			return this.PRESET_CODE;
		}

		public String FOLIO_NUMBER;

		public String getFOLIO_NUMBER() {
			return this.FOLIO_NUMBER;
		}

		public java.util.Date DATE;

		public java.util.Date getDATE() {
			return this.DATE;
		}

		public String METER_CODE;

		public String getMETER_CODE() {
			return this.METER_CODE;
		}

		public Integer TERMINAL_PRODUCT_NUMBER;

		public Integer getTERMINAL_PRODUCT_NUMBER() {
			return this.TERMINAL_PRODUCT_NUMBER;
		}

		public int LOADING_QUANTITY_TYPE;

		public int getLOADING_QUANTITY_TYPE() {
			return this.LOADING_QUANTITY_TYPE;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + ((this.FOLIO_NUMBER == null) ? 0 : this.FOLIO_NUMBER.hashCode());

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final row3Struct other = (row3Struct) obj;

			if (this.FOLIO_NUMBER == null) {
				if (other.FOLIO_NUMBER != null)
					return false;

			} else if (!this.FOLIO_NUMBER.equals(other.FOLIO_NUMBER))

				return false;

			return true;
		}

		public void copyDataTo(row3Struct other) {

			other.PK_METER_HISTORY = this.PK_METER_HISTORY;
			other.PRESET_CODE = this.PRESET_CODE;
			other.FOLIO_NUMBER = this.FOLIO_NUMBER;
			other.DATE = this.DATE;
			other.METER_CODE = this.METER_CODE;
			other.TERMINAL_PRODUCT_NUMBER = this.TERMINAL_PRODUCT_NUMBER;
			other.LOADING_QUANTITY_TYPE = this.LOADING_QUANTITY_TYPE;

		}

		public void copyKeysDataTo(row3Struct other) {

			other.FOLIO_NUMBER = this.FOLIO_NUMBER;

		}

		private String readString(DataInputStream dis, ObjectInputStream ois) throws IOException {
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

		private String readString(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller)
				throws IOException {
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

		private void writeString(String str, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller)
				throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		private void writeString(String str, DataOutputStream dos, ObjectOutputStream oos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_PGS_STAGE_FACT_INVENTORY.length) {
					if (length < 1024 && commonByteArray_PGS_STAGE_FACT_INVENTORY.length == 0) {
						commonByteArray_PGS_STAGE_FACT_INVENTORY = new byte[1024];
					} else {
						commonByteArray_PGS_STAGE_FACT_INVENTORY = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_PGS_STAGE_FACT_INVENTORY, 0, length);
				strReturn = new String(commonByteArray_PGS_STAGE_FACT_INVENTORY, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_PGS_STAGE_FACT_INVENTORY.length) {
					if (length < 1024 && commonByteArray_PGS_STAGE_FACT_INVENTORY.length == 0) {
						commonByteArray_PGS_STAGE_FACT_INVENTORY = new byte[1024];
					} else {
						commonByteArray_PGS_STAGE_FACT_INVENTORY = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_PGS_STAGE_FACT_INVENTORY, 0, length);
				strReturn = new String(commonByteArray_PGS_STAGE_FACT_INVENTORY, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		private java.util.Date readDate(DataInputStream dis, ObjectInputStream ois) throws IOException {
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

		private java.util.Date readDate(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller)
				throws IOException {
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

		private void writeDate(java.util.Date date1, DataOutputStream dos, ObjectOutputStream oos) throws IOException {
			if (date1 == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeLong(date1.getTime());
			}
		}

		private void writeDate(java.util.Date date1, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller)
				throws IOException {
			if (date1 == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeLong(date1.getTime());
			}
		}

		private Integer readInteger(DataInputStream dis, ObjectInputStream ois) throws IOException {
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

		private Integer readInteger(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller)
				throws IOException {
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

		private void writeInteger(Integer intNum, DataOutputStream dos, ObjectOutputStream oos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller)
				throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		public void readKeysData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_PGS_STAGE_FACT_INVENTORY) {

				try {

					int length = 0;

					this.FOLIO_NUMBER = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_PGS_STAGE_FACT_INVENTORY) {

				try {

					int length = 0;

					this.FOLIO_NUMBER = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeKeysData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.FOLIO_NUMBER, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.FOLIO_NUMBER, dos);

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

				this.PK_METER_HISTORY = dis.readInt();

				this.PRESET_CODE = readString(dis, ois);

				this.DATE = readDate(dis, ois);

				this.METER_CODE = readString(dis, ois);

				this.TERMINAL_PRODUCT_NUMBER = readInteger(dis, ois);

				this.LOADING_QUANTITY_TYPE = dis.readInt();

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
			try {
				int length = 0;

				this.PK_METER_HISTORY = objectIn.readInt();

				this.PRESET_CODE = readString(dis, objectIn);

				this.DATE = readDate(dis, objectIn);

				this.METER_CODE = readString(dis, objectIn);

				this.TERMINAL_PRODUCT_NUMBER = readInteger(dis, objectIn);

				this.LOADING_QUANTITY_TYPE = objectIn.readInt();

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		/**
		 * Return a byte array which represents Values data.
		 */
		public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
			try {

				dos.writeInt(this.PK_METER_HISTORY);

				writeString(this.PRESET_CODE, dos, oos);

				writeDate(this.DATE, dos, oos);

				writeString(this.METER_CODE, dos, oos);

				writeInteger(this.TERMINAL_PRODUCT_NUMBER, dos, oos);

				dos.writeInt(this.LOADING_QUANTITY_TYPE);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut) {
			try {

				objectOut.writeInt(this.PK_METER_HISTORY);

				writeString(this.PRESET_CODE, dos, objectOut);

				writeDate(this.DATE, dos, objectOut);

				writeString(this.METER_CODE, dos, objectOut);

				writeInteger(this.TERMINAL_PRODUCT_NUMBER, dos, objectOut);

				objectOut.writeInt(this.LOADING_QUANTITY_TYPE);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		public boolean supportMarshaller() {
			return true;
		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("PK_METER_HISTORY=" + String.valueOf(PK_METER_HISTORY));
			sb.append(",PRESET_CODE=" + PRESET_CODE);
			sb.append(",FOLIO_NUMBER=" + FOLIO_NUMBER);
			sb.append(",DATE=" + String.valueOf(DATE));
			sb.append(",METER_CODE=" + METER_CODE);
			sb.append(",TERMINAL_PRODUCT_NUMBER=" + String.valueOf(TERMINAL_PRODUCT_NUMBER));
			sb.append(",LOADING_QUANTITY_TYPE=" + String.valueOf(LOADING_QUANTITY_TYPE));
			sb.append("]");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row3Struct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.FOLIO_NUMBER, other.FOLIO_NUMBER);
			if (returnValue != 0) {
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
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				row3Struct row3 = new row3Struct();

				/**
				 * [tAdvancedHash_row3 begin ] start
				 */

				ok_Hash.put("tAdvancedHash_row3", false);
				start_Hash.put("tAdvancedHash_row3", System.currentTimeMillis());

				currentComponent = "tAdvancedHash_row3";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row3");
				}

				int tos_count_tAdvancedHash_row3 = 0;

				// connection name:row3
				// source node:tDBInput_3 - inputs:(after_tDBInput_7) outputs:(row3,row3) |
				// target node:tAdvancedHash_row3 - inputs:(row3) outputs:()
				// linked node: tMap_1 - inputs:(row1,row4,row2,row3) outputs:(out1)

				org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row3 = org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.ALL_MATCHES;

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct> tHash_Lookup_row3 = org.talend.designer.components.lookup.memory.AdvancedMemoryLookup
						.<row3Struct>getLookup(matchingModeEnum_row3);

				globalMap.put("tHash_Lookup_row3", tHash_Lookup_row3);

				/**
				 * [tAdvancedHash_row3 begin ] stop
				 */

				/**
				 * [tDBInput_3 begin ] start
				 */

				ok_Hash.put("tDBInput_3", false);
				start_Hash.put("tDBInput_3", System.currentTimeMillis());

				currentComponent = "tDBInput_3";

				int tos_count_tDBInput_3 = 0;

				org.talend.designer.components.util.mssql.MSSqlGenerateTimestampUtil mssqlGTU_tDBInput_3 = org.talend.designer.components.util.mssql.MSSqlUtilFactory
						.getMSSqlGenerateTimestampUtil();

				java.util.List<String> talendToDBList_tDBInput_3 = new java.util.ArrayList();
				String[] talendToDBArray_tDBInput_3 = new String[] { "FLOAT", "NUMERIC", "NUMERIC IDENTITY", "DECIMAL",
						"DECIMAL IDENTITY", "REAL" };
				java.util.Collections.addAll(talendToDBList_tDBInput_3, talendToDBArray_tDBInput_3);
				int nb_line_tDBInput_3 = 0;
				java.sql.Connection conn_tDBInput_3 = null;
				String driverClass_tDBInput_3 = "net.sourceforge.jtds.jdbc.Driver";
				java.lang.Class jdbcclazz_tDBInput_3 = java.lang.Class.forName(driverClass_tDBInput_3);
				String dbUser_tDBInput_3 = "sa";

				final String decryptedPassword_tDBInput_3 = routines.system.PasswordEncryptUtil.decryptPassword(
						"enc:routine.encryption.key.v1:ceD/BUjrDdQXLKM7p5xURL3FW1ssz/JrRRUeiqPGiBQBT1kpjjA=");

				String dbPwd_tDBInput_3 = decryptedPassword_tDBInput_3;

				String port_tDBInput_3 = "1433";
				String dbname_tDBInput_3 = "PGS_STAGE_DW";
				String url_tDBInput_3 = "jdbc:jtds:sqlserver://" + "LAPTOP-HED7JE2F";
				if (!"".equals(port_tDBInput_3)) {
					url_tDBInput_3 += ":" + "1433";
				}
				if (!"".equals(dbname_tDBInput_3)) {
					url_tDBInput_3 += "//" + "PGS_STAGE_DW";
				}
				url_tDBInput_3 += ";appName=" + projectName + ";" + "";
				String dbschema_tDBInput_3 = "dbo";

				conn_tDBInput_3 = java.sql.DriverManager.getConnection(url_tDBInput_3, dbUser_tDBInput_3,
						dbPwd_tDBInput_3);

				java.sql.Statement stmt_tDBInput_3 = conn_tDBInput_3.createStatement();

				String dbquery_tDBInput_3 = "SELECT dbo.DIM_METER_HISTORY.PK_METER_HISTORY,\n		dbo.DIM_METER_HISTORY.PRESET_CODE,\n		dbo.DIM_METER_HISTORY.FOLIO_NUMBE"
						+ "R,\n		dbo.DIM_METER_HISTORY.DATE,\n		dbo.DIM_METER_HISTORY.METER_CODE,\n		dbo.DIM_METER_HISTORY.TERMINAL_PRODUCT_NUMBER,\n		"
						+ "dbo.DIM_METER_HISTORY.LOADING_QUANTITY_TYPE\nFROM	dbo.DIM_METER_HISTORY";

				globalMap.put("tDBInput_3_QUERY", dbquery_tDBInput_3);
				java.sql.ResultSet rs_tDBInput_3 = null;

				try {
					rs_tDBInput_3 = stmt_tDBInput_3.executeQuery(dbquery_tDBInput_3);
					java.sql.ResultSetMetaData rsmd_tDBInput_3 = rs_tDBInput_3.getMetaData();
					int colQtyInRs_tDBInput_3 = rsmd_tDBInput_3.getColumnCount();

					String tmpContent_tDBInput_3 = null;

					while (rs_tDBInput_3.next()) {
						nb_line_tDBInput_3++;

						if (colQtyInRs_tDBInput_3 < 1) {
							row3.PK_METER_HISTORY = 0;
						} else {

							row3.PK_METER_HISTORY = rs_tDBInput_3.getInt(1);
							if (rs_tDBInput_3.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_3 < 2) {
							row3.PRESET_CODE = null;
						} else {

							tmpContent_tDBInput_3 = rs_tDBInput_3.getString(2);
							if (tmpContent_tDBInput_3 != null) {
								if (talendToDBList_tDBInput_3.contains(
										rsmd_tDBInput_3.getColumnTypeName(2).toUpperCase(java.util.Locale.ENGLISH))) {
									row3.PRESET_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
								} else {
									row3.PRESET_CODE = tmpContent_tDBInput_3;
								}
							} else {
								row3.PRESET_CODE = null;
							}
						}
						if (colQtyInRs_tDBInput_3 < 3) {
							row3.FOLIO_NUMBER = null;
						} else {

							tmpContent_tDBInput_3 = rs_tDBInput_3.getString(3);
							if (tmpContent_tDBInput_3 != null) {
								if (talendToDBList_tDBInput_3.contains(
										rsmd_tDBInput_3.getColumnTypeName(3).toUpperCase(java.util.Locale.ENGLISH))) {
									row3.FOLIO_NUMBER = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
								} else {
									row3.FOLIO_NUMBER = tmpContent_tDBInput_3;
								}
							} else {
								row3.FOLIO_NUMBER = null;
							}
						}
						if (colQtyInRs_tDBInput_3 < 4) {
							row3.DATE = null;
						} else {

							row3.DATE = mssqlGTU_tDBInput_3.getDate(rsmd_tDBInput_3, rs_tDBInput_3, 4);

						}
						if (colQtyInRs_tDBInput_3 < 5) {
							row3.METER_CODE = null;
						} else {

							tmpContent_tDBInput_3 = rs_tDBInput_3.getString(5);
							if (tmpContent_tDBInput_3 != null) {
								if (talendToDBList_tDBInput_3.contains(
										rsmd_tDBInput_3.getColumnTypeName(5).toUpperCase(java.util.Locale.ENGLISH))) {
									row3.METER_CODE = FormatterUtils.formatUnwithE(tmpContent_tDBInput_3);
								} else {
									row3.METER_CODE = tmpContent_tDBInput_3;
								}
							} else {
								row3.METER_CODE = null;
							}
						}
						if (colQtyInRs_tDBInput_3 < 6) {
							row3.TERMINAL_PRODUCT_NUMBER = null;
						} else {

							row3.TERMINAL_PRODUCT_NUMBER = rs_tDBInput_3.getInt(6);
							if (rs_tDBInput_3.wasNull()) {
								row3.TERMINAL_PRODUCT_NUMBER = null;
							}
						}
						if (colQtyInRs_tDBInput_3 < 7) {
							row3.LOADING_QUANTITY_TYPE = 0;
						} else {

							row3.LOADING_QUANTITY_TYPE = rs_tDBInput_3.getInt(7);
							if (rs_tDBInput_3.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}

						/**
						 * [tDBInput_3 begin ] stop
						 */

						/**
						 * [tDBInput_3 main ] start
						 */

						currentComponent = "tDBInput_3";

						tos_count_tDBInput_3++;

						/**
						 * [tDBInput_3 main ] stop
						 */

						/**
						 * [tDBInput_3 process_data_begin ] start
						 */

						currentComponent = "tDBInput_3";

						/**
						 * [tDBInput_3 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row3 main ] start
						 */

						currentComponent = "tAdvancedHash_row3";

						if (execStat) {
							runStat.updateStatOnConnection(iterateId, 1, 1

									, "row3"

							);
						}

						row3Struct row3_HashRow = new row3Struct();

						row3_HashRow.PK_METER_HISTORY = row3.PK_METER_HISTORY;

						row3_HashRow.PRESET_CODE = row3.PRESET_CODE;

						row3_HashRow.FOLIO_NUMBER = row3.FOLIO_NUMBER;

						row3_HashRow.DATE = row3.DATE;

						row3_HashRow.METER_CODE = row3.METER_CODE;

						row3_HashRow.TERMINAL_PRODUCT_NUMBER = row3.TERMINAL_PRODUCT_NUMBER;

						row3_HashRow.LOADING_QUANTITY_TYPE = row3.LOADING_QUANTITY_TYPE;

						tHash_Lookup_row3.put(row3_HashRow);

						tos_count_tAdvancedHash_row3++;

						/**
						 * [tAdvancedHash_row3 main ] stop
						 */

						/**
						 * [tAdvancedHash_row3 process_data_begin ] start
						 */

						currentComponent = "tAdvancedHash_row3";

						/**
						 * [tAdvancedHash_row3 process_data_begin ] stop
						 */

						/**
						 * [tAdvancedHash_row3 process_data_end ] start
						 */

						currentComponent = "tAdvancedHash_row3";

						/**
						 * [tAdvancedHash_row3 process_data_end ] stop
						 */

						/**
						 * [tDBInput_3 process_data_end ] start
						 */

						currentComponent = "tDBInput_3";

						/**
						 * [tDBInput_3 process_data_end ] stop
						 */

						/**
						 * [tDBInput_3 end ] start
						 */

						currentComponent = "tDBInput_3";

					}
				} finally {
					if (rs_tDBInput_3 != null) {
						rs_tDBInput_3.close();
					}
					if (stmt_tDBInput_3 != null) {
						stmt_tDBInput_3.close();
					}
					if (conn_tDBInput_3 != null && !conn_tDBInput_3.isClosed()) {

						conn_tDBInput_3.close();

						if ("com.mysql.cj.jdbc.Driver".equals((String) globalMap.get("driverClass_"))
								&& routines.system.BundleUtils.inOSGi()) {
							Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread")
									.getMethod("checkedShutdown").invoke(null, (Object[]) null);
						}

					}
				}
				globalMap.put("tDBInput_3_NB_LINE", nb_line_tDBInput_3);

				ok_Hash.put("tDBInput_3", true);
				end_Hash.put("tDBInput_3", System.currentTimeMillis());

				/**
				 * [tDBInput_3 end ] stop
				 */

				/**
				 * [tAdvancedHash_row3 end ] start
				 */

				currentComponent = "tAdvancedHash_row3";

				tHash_Lookup_row3.endPut();

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row3");
				}

				ok_Hash.put("tAdvancedHash_row3", true);
				end_Hash.put("tAdvancedHash_row3", System.currentTimeMillis());

				/**
				 * [tAdvancedHash_row3 end ] stop
				 */

			} // end the resume

		} catch (java.lang.Exception e) {

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tDBInput_3 finally ] start
				 */

				currentComponent = "tDBInput_3";

				/**
				 * [tDBInput_3 finally ] stop
				 */

				/**
				 * [tAdvancedHash_row3 finally ] start
				 */

				currentComponent = "tAdvancedHash_row3";

				/**
				 * [tAdvancedHash_row3 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBInput_3_SUBPROCESS_STATE", 1);
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
			java.util.Map<String, String> threadRunResultMap = new java.util.HashMap<String, String>();
			threadRunResultMap.put("errorCode", null);
			threadRunResultMap.put("status", "");
			return threadRunResultMap;
		};
	};

	protected PropertiesWithType context_param = new PropertiesWithType();
	public java.util.Map<String, Object> parentContextMap = new java.util.HashMap<String, Object>();

	public String status = "";

	public static void main(String[] args) {
		final FACT_INVENTORY FACT_INVENTORYClass = new FACT_INVENTORY();

		int exitCode = FACT_INVENTORYClass.runJobInTOS(args);

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

		if (clientHost == null) {
			clientHost = defaultClientHost;
		}

		if (pid == null || "0".equals(pid)) {
			pid = TalendString.getAsciiRandomString(6);
		}

		if (rootPid == null) {
			rootPid = pid;
		}
		if (fatherPid == null) {
			fatherPid = pid;
		} else {
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
				contextStr = (String) jobProperties.get("context");
			}
		}

		try {
			// call job/subjob with an existing context, like: --context=production. if
			// without this parameter, there will use the default context instead.
			java.io.InputStream inContext = FACT_INVENTORY.class.getClassLoader()
					.getResourceAsStream("pgs_stage/fact_inventory_0_1/contexts/" + contextStr + ".properties");
			if (inContext == null) {
				inContext = FACT_INVENTORY.class.getClassLoader()
						.getResourceAsStream("config/contexts/" + contextStr + ".properties");
			}
			if (inContext != null) {
				try {
					// defaultProps is in order to keep the original context value
					if (context != null && context.isEmpty()) {
						defaultProps.load(inContext);
						context = new ContextProperties(defaultProps);
					}
				} finally {
					inContext.close();
				}
			} else if (!isDefaultContext) {
				// print info and job continue to run, for case: context_param is not empty.
				System.err.println("Could not find the context " + contextStr);
			}

			if (!context_param.isEmpty()) {
				context.putAll(context_param);
				// set types for params from parentJobs
				for (Object key : context_param.keySet()) {
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
			System.err.println("Could not load context " + contextStr);
			ie.printStackTrace();
		}

		// get context value from parent directly
		if (parentContextMap != null && !parentContextMap.isEmpty()) {
		}

		// Resume: init the resumeUtil
		resumeEntryMethodName = ResumeUtil.getResumeEntryMethodName(resuming_checkpoint_path);
		resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
		resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName, jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
		// Resume: jobStart
		resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "",
				"", "", "", "", resumeUtil.convertToJsonText(context, parametersToEncrypt));

		if (execStat) {
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

		this.globalResumeTicket = true;// to run tPreJob

		this.globalResumeTicket = false;// to run others jobs

		try {
			errorCode = null;
			tDBInput_7Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tDBInput_7) {
			globalMap.put("tDBInput_7_SUBPROCESS_STATE", -1);

			e_tDBInput_7.printStackTrace();

		}

		this.globalResumeTicket = true;// to run tPostJob

		end = System.currentTimeMillis();

		if (watch) {
			System.out.println((end - startTime) + " milliseconds");
		}

		endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		if (false) {
			System.out.println(
					(endUsedMemory - startUsedMemory) + " bytes memory increase when running : FACT_INVENTORY");
		}

		if (execStat) {
			runStat.updateStatOnJob(RunStat.JOBEND, fatherNode);
			runStat.stopThreadStat();
		}
		int returnCode = 0;

		if (errorCode == null) {
			returnCode = status != null && status.equals("failure") ? 1 : 0;
		} else {
			returnCode = errorCode.intValue();
		}
		resumeUtil.addLog("JOB_ENDED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "",
				"" + returnCode, "", "", "");

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
				if (fatherPid == null) {
					context_param.setContextType(keyValue.substring(0, index),
							replaceEscapeChars(keyValue.substring(index + 1)));
				} else { // the subjob won't escape the especial chars
					context_param.setContextType(keyValue.substring(0, index), keyValue.substring(index + 1));
				}

			}

		} else if (arg.startsWith("--context_param")) {
			String keyValue = arg.substring(16);
			int index = -1;
			if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
				if (fatherPid == null) {
					context_param.put(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
				} else { // the subjob won't escape the especial chars
					context_param.put(keyValue.substring(0, index), keyValue.substring(index + 1));
				}
			}
		} else if (arg.startsWith("--log4jLevel=")) {
			log4jLevel = arg.substring(13);
		} else if (arg.startsWith("--audit.enabled") && arg.contains("=")) {// for trunjob call
			final int equal = arg.indexOf('=');
			final String key = arg.substring("--".length(), equal);
			System.setProperty(key, arg.substring(equal + 1));
		}
	}

	private static final String NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY = "<TALEND_NULL>";

	private final String[][] escapeChars = { { "\\\\", "\\" }, { "\\n", "\n" }, { "\\'", "\'" }, { "\\r", "\r" },
			{ "\\f", "\f" }, { "\\b", "\b" }, { "\\t", "\t" } };

	private String replaceEscapeChars(String keyValue) {

		if (keyValue == null || ("").equals(keyValue.trim())) {
			return keyValue;
		}

		StringBuilder result = new StringBuilder();
		int currIndex = 0;
		while (currIndex < keyValue.length()) {
			int index = -1;
			// judege if the left string includes escape chars
			for (String[] strArray : escapeChars) {
				index = keyValue.indexOf(strArray[0], currIndex);
				if (index >= 0) {

					result.append(keyValue.substring(currIndex, index + strArray[0].length()).replace(strArray[0],
							strArray[1]));
					currIndex = index + strArray[0].length();
					break;
				}
			}
			// if the left string doesn't include escape chars, append the left into the
			// result
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
 * 166624 characters generated by Talend Open Studio for Data Integration on the
 * 23 juillet 2024 à 10:39:00 GMT+01:00
 ************************************************************************************************/