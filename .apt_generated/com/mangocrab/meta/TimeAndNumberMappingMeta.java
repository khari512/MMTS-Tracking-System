package com.mangocrab.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2013-03-31 22:50:25")
/** */
public final class TimeAndNumberMappingMeta extends org.slim3.datastore.ModelMeta<com.mangocrab.model.TimeAndNumberMapping> {

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.mangocrab.model.TimeAndNumberMapping> currentLocation = new org.slim3.datastore.StringAttributeMeta<com.mangocrab.model.TimeAndNumberMapping>(this, "currentLocation", "currentLocation");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.mangocrab.model.TimeAndNumberMapping, java.lang.Double> expTime = new org.slim3.datastore.CoreAttributeMeta<com.mangocrab.model.TimeAndNumberMapping, java.lang.Double>(this, "expTime", "expTime", double.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.mangocrab.model.TimeAndNumberMapping, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<com.mangocrab.model.TimeAndNumberMapping, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.mangocrab.model.TimeAndNumberMapping, java.lang.Boolean> notOnSundayFlag = new org.slim3.datastore.CoreAttributeMeta<com.mangocrab.model.TimeAndNumberMapping, java.lang.Boolean>(this, "notOnSundayFlag", "notOnSundayFlag", boolean.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.mangocrab.model.TimeAndNumberMapping, java.lang.Double> time = new org.slim3.datastore.CoreAttributeMeta<com.mangocrab.model.TimeAndNumberMapping, java.lang.Double>(this, "time", "time", double.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.mangocrab.model.TimeAndNumberMapping, java.lang.Integer> trainNumber = new org.slim3.datastore.CoreAttributeMeta<com.mangocrab.model.TimeAndNumberMapping, java.lang.Integer>(this, "trainNumber", "trainNumber", int.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.mangocrab.model.TimeAndNumberMapping, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<com.mangocrab.model.TimeAndNumberMapping, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final TimeAndNumberMappingMeta slim3_singleton = new TimeAndNumberMappingMeta();

    /**
     * @return the singleton
     */
    public static TimeAndNumberMappingMeta get() {
       return slim3_singleton;
    }

    /** */
    public TimeAndNumberMappingMeta() {
        super("TimeAndNumberMapping", com.mangocrab.model.TimeAndNumberMapping.class);
    }

    @Override
    public com.mangocrab.model.TimeAndNumberMapping entityToModel(com.google.appengine.api.datastore.Entity entity) {
        com.mangocrab.model.TimeAndNumberMapping model = new com.mangocrab.model.TimeAndNumberMapping();
        model.setCurrentLocation((java.lang.String) entity.getProperty("currentLocation"));
        model.setExpTime(doubleToPrimitiveDouble((java.lang.Double) entity.getProperty("expTime")));
        model.setKey(entity.getKey());
        model.setNotOnSundayFlag(booleanToPrimitiveBoolean((java.lang.Boolean) entity.getProperty("notOnSundayFlag")));
        model.setTime(doubleToPrimitiveDouble((java.lang.Double) entity.getProperty("time")));
        model.setTrainNumber(longToPrimitiveInt((java.lang.Long) entity.getProperty("trainNumber")));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        com.mangocrab.model.TimeAndNumberMapping m = (com.mangocrab.model.TimeAndNumberMapping) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("currentLocation", m.getCurrentLocation());
        entity.setProperty("expTime", m.getExpTime());
        entity.setProperty("notOnSundayFlag", m.isNotOnSundayFlag());
        entity.setProperty("time", m.getTime());
        entity.setProperty("trainNumber", m.getTrainNumber());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        com.mangocrab.model.TimeAndNumberMapping m = (com.mangocrab.model.TimeAndNumberMapping) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        com.mangocrab.model.TimeAndNumberMapping m = (com.mangocrab.model.TimeAndNumberMapping) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        com.mangocrab.model.TimeAndNumberMapping m = (com.mangocrab.model.TimeAndNumberMapping) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
    }

    @Override
    protected void incrementVersion(Object model) {
        com.mangocrab.model.TimeAndNumberMapping m = (com.mangocrab.model.TimeAndNumberMapping) model;
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
        com.mangocrab.model.TimeAndNumberMapping m = (com.mangocrab.model.TimeAndNumberMapping) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getCurrentLocation() != null){
            writer.setNextPropertyName("currentLocation");
            encoder0.encode(writer, m.getCurrentLocation());
        }
        writer.setNextPropertyName("expTime");
        encoder0.encode(writer, m.getExpTime());
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        writer.setNextPropertyName("notOnSundayFlag");
        encoder0.encode(writer, m.isNotOnSundayFlag());
        writer.setNextPropertyName("time");
        encoder0.encode(writer, m.getTime());
        writer.setNextPropertyName("trainNumber");
        encoder0.encode(writer, m.getTrainNumber());
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder0.encode(writer, m.getVersion());
        }
        writer.endObject();
    }

    @Override
    protected com.mangocrab.model.TimeAndNumberMapping jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        com.mangocrab.model.TimeAndNumberMapping m = new com.mangocrab.model.TimeAndNumberMapping();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("currentLocation");
        m.setCurrentLocation(decoder0.decode(reader, m.getCurrentLocation()));
        reader = rootReader.newObjectReader("expTime");
        m.setExpTime(decoder0.decode(reader, m.getExpTime()));
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("notOnSundayFlag");
        m.setNotOnSundayFlag(decoder0.decode(reader, m.isNotOnSundayFlag()));
        reader = rootReader.newObjectReader("time");
        m.setTime(decoder0.decode(reader, m.getTime()));
        reader = rootReader.newObjectReader("trainNumber");
        m.setTrainNumber(decoder0.decode(reader, m.getTrainNumber()));
        reader = rootReader.newObjectReader("version");
        m.setVersion(decoder0.decode(reader, m.getVersion()));
        return m;
    }
}