package com.mangocrab.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2013-03-31 22:50:25")
/** */
public final class TimingsMeta extends org.slim3.datastore.ModelMeta<com.mangocrab.model.Timings> {

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.mangocrab.model.Timings> boardingAt = new org.slim3.datastore.StringAttributeMeta<com.mangocrab.model.Timings>(this, "boardingAt", "boardingAt");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.mangocrab.model.Timings, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<com.mangocrab.model.Timings, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.mangocrab.model.Timings, java.util.Date> lastUpdatedDate = new org.slim3.datastore.CoreAttributeMeta<com.mangocrab.model.Timings, java.util.Date>(this, "lastUpdatedDate", "lastUpdatedDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.mangocrab.model.Timings> sundayTrainDelimeter = new org.slim3.datastore.StringAttributeMeta<com.mangocrab.model.Timings>(this, "sundayTrainDelimeter", "sundayTrainDelimeter");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.mangocrab.model.Timings> timingsRawData = new org.slim3.datastore.StringAttributeMeta<com.mangocrab.model.Timings>(this, "timingsRawData", "timingsRawData");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.mangocrab.model.Timings> trainName = new org.slim3.datastore.StringAttributeMeta<com.mangocrab.model.Timings>(this, "trainName", "trainName");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.mangocrab.model.Timings> trainNumbersRawData = new org.slim3.datastore.StringAttributeMeta<com.mangocrab.model.Timings>(this, "trainNumbersRawData", "trainNumbersRawData");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.mangocrab.model.Timings, java.util.Date> validFromDate = new org.slim3.datastore.CoreAttributeMeta<com.mangocrab.model.Timings, java.util.Date>(this, "validFromDate", "validFromDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.mangocrab.model.Timings, java.util.Date> validToDate = new org.slim3.datastore.CoreAttributeMeta<com.mangocrab.model.Timings, java.util.Date>(this, "validToDate", "validToDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.mangocrab.model.Timings, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<com.mangocrab.model.Timings, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final TimingsMeta slim3_singleton = new TimingsMeta();

    /**
     * @return the singleton
     */
    public static TimingsMeta get() {
       return slim3_singleton;
    }

    /** */
    public TimingsMeta() {
        super("Timings", com.mangocrab.model.Timings.class);
    }

    @Override
    public com.mangocrab.model.Timings entityToModel(com.google.appengine.api.datastore.Entity entity) {
        com.mangocrab.model.Timings model = new com.mangocrab.model.Timings();
        model.setBoardingAt((java.lang.String) entity.getProperty("boardingAt"));
        model.setKey(entity.getKey());
        model.setLastUpdatedDate((java.util.Date) entity.getProperty("lastUpdatedDate"));
        model.setSundayTrainDelimeter((java.lang.String) entity.getProperty("sundayTrainDelimeter"));
        java.util.List<com.mangocrab.model.TimeAndNumberMapping> _timeAndNumberMappingList = blobToSerializable((com.google.appengine.api.datastore.Blob) entity.getProperty("timeAndNumberMappingList"));
        model.setTimeAndNumberMappingList(_timeAndNumberMappingList);
        model.setTimingsRawData((java.lang.String) entity.getProperty("timingsRawData"));
        model.setTrainName((java.lang.String) entity.getProperty("trainName"));
        model.setTrainNumbersRawData((java.lang.String) entity.getProperty("trainNumbersRawData"));
        java.util.List<java.lang.Number> _trainTimings = blobToSerializable((com.google.appengine.api.datastore.Blob) entity.getProperty("trainTimings"));
        model.setTrainTimings(_trainTimings);
        model.setValidFromDate((java.util.Date) entity.getProperty("validFromDate"));
        model.setValidToDate((java.util.Date) entity.getProperty("validToDate"));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        com.mangocrab.model.Timings m = (com.mangocrab.model.Timings) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("boardingAt", m.getBoardingAt());
        entity.setProperty("lastUpdatedDate", m.getLastUpdatedDate());
        entity.setProperty("sundayTrainDelimeter", m.getSundayTrainDelimeter());
        entity.setUnindexedProperty("timeAndNumberMappingList", serializableToBlob(m.getTimeAndNumberMappingList()));
        entity.setProperty("timingsRawData", m.getTimingsRawData());
        entity.setProperty("trainName", m.getTrainName());
        entity.setProperty("trainNumbersRawData", m.getTrainNumbersRawData());
        entity.setUnindexedProperty("trainTimings", serializableToBlob(m.getTrainTimings()));
        entity.setProperty("validFromDate", m.getValidFromDate());
        entity.setProperty("validToDate", m.getValidToDate());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        com.mangocrab.model.Timings m = (com.mangocrab.model.Timings) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        com.mangocrab.model.Timings m = (com.mangocrab.model.Timings) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        com.mangocrab.model.Timings m = (com.mangocrab.model.Timings) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
    }

    @Override
    protected void incrementVersion(Object model) {
        com.mangocrab.model.Timings m = (com.mangocrab.model.Timings) model;
        long version = m.getVersion() != null ? m.getVersion().longValue() : 0L;
        m.setVersion(Long.valueOf(version + 1L));
    }

    @Override
    protected void prePut(Object model) {
    }

    @Override
    protected void postGet(Object model) {
    }

    @Override
    public String getSchemaVersionName() {
        return "slim3.schemaVersion";
    }

    @Override
    public String getClassHierarchyListName() {
        return "slim3.classHierarchyList";
    }

    @Override
    protected boolean isCipherProperty(String propertyName) {
        return false;
    }

    @Override
    protected void modelToJson(org.slim3.datastore.json.JsonWriter writer, java.lang.Object model, int maxDepth, int currentDepth) {
        com.mangocrab.model.Timings m = (com.mangocrab.model.Timings) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getBoardingAt() != null){
            writer.setNextPropertyName("boardingAt");
            encoder0.encode(writer, m.getBoardingAt());
        }
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        if(m.getLastUpdatedDate() != null){
            writer.setNextPropertyName("lastUpdatedDate");
            encoder0.encode(writer, m.getLastUpdatedDate());
        }
        if(m.getNumbersDelimeter() != null){
            writer.setNextPropertyName("numbersDelimeter");
            encoder0.encode(writer, m.getNumbersDelimeter());
        }
        if(m.getSundayTrainDelimeter() != null){
            writer.setNextPropertyName("sundayTrainDelimeter");
            encoder0.encode(writer, m.getSundayTrainDelimeter());
        }
        if(m.getTimeAndNumberMappingList() != null){
            writer.setNextPropertyName("timeAndNumberMappingList");
            // com.mangocrab.model.TimeAndNumberMapping is not supported.
        }
        if(m.getTimingsDelimeter() != null){
            writer.setNextPropertyName("timingsDelimeter");
            encoder0.encode(writer, m.getTimingsDelimeter());
        }
        if(m.getTimingsRawData() != null){
            writer.setNextPropertyName("timingsRawData");
            encoder0.encode(writer, m.getTimingsRawData());
        }
        if(m.getTrainName() != null){
            writer.setNextPropertyName("trainName");
            encoder0.encode(writer, m.getTrainName());
        }
        if(m.getTrainNumbersRawData() != null){
            writer.setNextPropertyName("trainNumbersRawData");
            encoder0.encode(writer, m.getTrainNumbersRawData());
        }
        if(m.getTrainTimings() != null){
            writer.setNextPropertyName("trainTimings");
            // java.lang.Number is not supported.
        }
        if(m.getUserMessage() != null){
            writer.setNextPropertyName("userMessage");
            encoder0.encode(writer, m.getUserMessage());
        }
        if(m.getValidFromDate() != null){
            writer.setNextPropertyName("validFromDate");
            encoder0.encode(writer, m.getValidFromDate());
        }
        if(m.getValidToDate() != null){
            writer.setNextPropertyName("validToDate");
            encoder0.encode(writer, m.getValidToDate());
        }
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder0.encode(writer, m.getVersion());
        }
        writer.endObject();
    }

    @Override
    protected com.mangocrab.model.Timings jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        com.mangocrab.model.Timings m = new com.mangocrab.model.Timings();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("boardingAt");
        m.setBoardingAt(decoder0.decode(reader, m.getBoardingAt()));
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("lastUpdatedDate");
        m.setLastUpdatedDate(decoder0.decode(reader, m.getLastUpdatedDate()));
        reader = rootReader.newObjectReader("numbersDelimeter");
        m.setNumbersDelimeter(decoder0.decode(reader, m.getNumbersDelimeter()));
        reader = rootReader.newObjectReader("sundayTrainDelimeter");
        m.setSundayTrainDelimeter(decoder0.decode(reader, m.getSundayTrainDelimeter()));
        reader = rootReader.newObjectReader("timeAndNumberMappingList");
        reader = rootReader.newObjectReader("timingsDelimeter");
        m.setTimingsDelimeter(decoder0.decode(reader, m.getTimingsDelimeter()));
        reader = rootReader.newObjectReader("timingsRawData");
        m.setTimingsRawData(decoder0.decode(reader, m.getTimingsRawData()));
        reader = rootReader.newObjectReader("trackerService");
        reader = rootReader.newObjectReader("trainName");
        m.setTrainName(decoder0.decode(reader, m.getTrainName()));
        reader = rootReader.newObjectReader("trainNumbersRawData");
        m.setTrainNumbersRawData(decoder0.decode(reader, m.getTrainNumbersRawData()));
        reader = rootReader.newObjectReader("trainTimings");
        reader = rootReader.newObjectReader("twoDForm");
        reader = rootReader.newObjectReader("userMessage");
        m.setUserMessage(decoder0.decode(reader, m.getUserMessage()));
        reader = rootReader.newObjectReader("validFromDate");
        m.setValidFromDate(decoder0.decode(reader, m.getValidFromDate()));
        reader = rootReader.newObjectReader("validToDate");
        m.setValidToDate(decoder0.decode(reader, m.getValidToDate()));
        reader = rootReader.newObjectReader("version");
        m.setVersion(decoder0.decode(reader, m.getVersion()));
        return m;
    }
}