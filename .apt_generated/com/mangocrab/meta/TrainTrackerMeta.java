package com.mangocrab.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2013-03-31 22:50:25")
/** */
public final class TrainTrackerMeta extends org.slim3.datastore.ModelMeta<com.mangocrab.model.TrainTracker> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.mangocrab.model.TrainTracker, java.lang.Double> actualTime = new org.slim3.datastore.CoreAttributeMeta<com.mangocrab.model.TrainTracker, java.lang.Double>(this, "actualTime", "actualTime", double.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.mangocrab.model.TrainTracker, java.util.Date> createdDate = new org.slim3.datastore.CoreAttributeMeta<com.mangocrab.model.TrainTracker, java.util.Date>(this, "createdDate", "createdDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.mangocrab.model.TrainTracker> currentLocation = new org.slim3.datastore.StringAttributeMeta<com.mangocrab.model.TrainTracker>(this, "currentLocation", "currentLocation");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.mangocrab.model.TrainTracker, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<com.mangocrab.model.TrainTracker, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.mangocrab.model.TrainTracker, java.lang.Double> time = new org.slim3.datastore.CoreAttributeMeta<com.mangocrab.model.TrainTracker, java.lang.Double>(this, "time", "time", double.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.mangocrab.model.TrainTracker> trainName = new org.slim3.datastore.StringAttributeMeta<com.mangocrab.model.TrainTracker>(this, "trainName", "trainName");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.mangocrab.model.TrainTracker, java.lang.Integer> trainNo = new org.slim3.datastore.CoreAttributeMeta<com.mangocrab.model.TrainTracker, java.lang.Integer>(this, "trainNo", "trainNo", int.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.mangocrab.model.TrainTracker> trainStatus = new org.slim3.datastore.StringAttributeMeta<com.mangocrab.model.TrainTracker>(this, "trainStatus", "trainStatus");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.mangocrab.model.TrainTracker, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<com.mangocrab.model.TrainTracker, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final TrainTrackerMeta slim3_singleton = new TrainTrackerMeta();

    /**
     * @return the singleton
     */
    public static TrainTrackerMeta get() {
       return slim3_singleton;
    }

    /** */
    public TrainTrackerMeta() {
        super("TrainTracker", com.mangocrab.model.TrainTracker.class);
    }

    @Override
    public com.mangocrab.model.TrainTracker entityToModel(com.google.appengine.api.datastore.Entity entity) {
        com.mangocrab.model.TrainTracker model = new com.mangocrab.model.TrainTracker();
        model.setActualTime(doubleToPrimitiveDouble((java.lang.Double) entity.getProperty("actualTime")));
        model.setCreatedDate((java.util.Date) entity.getProperty("createdDate"));
        model.setCurrentLocation((java.lang.String) entity.getProperty("currentLocation"));
        model.setKey(entity.getKey());
        model.setTime(doubleToPrimitiveDouble((java.lang.Double) entity.getProperty("time")));
        model.setTrainName((java.lang.String) entity.getProperty("trainName"));
        model.setTrainNo(longToPrimitiveInt((java.lang.Long) entity.getProperty("trainNo")));
        model.setTrainStatus((java.lang.String) entity.getProperty("trainStatus"));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        com.mangocrab.model.TrainTracker m = (com.mangocrab.model.TrainTracker) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("actualTime", m.getActualTime());
        entity.setProperty("createdDate", m.getCreatedDate());
        entity.setProperty("currentLocation", m.getCurrentLocation());
        entity.setProperty("time", m.getTime());
        entity.setProperty("trainName", m.getTrainName());
        entity.setProperty("trainNo", m.getTrainNo());
        entity.setProperty("trainStatus", m.getTrainStatus());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        com.mangocrab.model.TrainTracker m = (com.mangocrab.model.TrainTracker) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        com.mangocrab.model.TrainTracker m = (com.mangocrab.model.TrainTracker) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        com.mangocrab.model.TrainTracker m = (com.mangocrab.model.TrainTracker) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
    }

    @Override
    protected void incrementVersion(Object model) {
        com.mangocrab.model.TrainTracker m = (com.mangocrab.model.TrainTracker) model;
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
        com.mangocrab.model.TrainTracker m = (com.mangocrab.model.TrainTracker) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        writer.setNextPropertyName("actualTime");
        encoder0.encode(writer, m.getActualTime());
        if(m.getCreatedDate() != null){
            writer.setNextPropertyName("createdDate");
            encoder0.encode(writer, m.getCreatedDate());
        }
        if(m.getCurrentLocation() != null){
            writer.setNextPropertyName("currentLocation");
            encoder0.encode(writer, m.getCurrentLocation());
        }
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        writer.setNextPropertyName("time");
        encoder0.encode(writer, m.getTime());
        if(m.getTrainName() != null){
            writer.setNextPropertyName("trainName");
            encoder0.encode(writer, m.getTrainName());
        }
        writer.setNextPropertyName("trainNo");
        encoder0.encode(writer, m.getTrainNo());
        if(m.getTrainStatus() != null){
            writer.setNextPropertyName("trainStatus");
            encoder0.encode(writer, m.getTrainStatus());
        }
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder0.encode(writer, m.getVersion());
        }
        writer.endObject();
    }

    @Override
    protected com.mangocrab.model.TrainTracker jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        com.mangocrab.model.TrainTracker m = new com.mangocrab.model.TrainTracker();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("actualTime");
        m.setActualTime(decoder0.decode(reader, m.getActualTime()));
        reader = rootReader.newObjectReader("createdDate");
        m.setCreatedDate(decoder0.decode(reader, m.getCreatedDate()));
        reader = rootReader.newObjectReader("currentLocation");
        m.setCurrentLocation(decoder0.decode(reader, m.getCurrentLocation()));
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("time");
        m.setTime(decoder0.decode(reader, m.getTime()));
        reader = rootReader.newObjectReader("trainName");
        m.setTrainName(decoder0.decode(reader, m.getTrainName()));
        reader = rootReader.newObjectReader("trainNo");
        m.setTrainNo(decoder0.decode(reader, m.getTrainNo()));
        reader = rootReader.newObjectReader("trainStatus");
        m.setTrainStatus(decoder0.decode(reader, m.getTrainStatus()));
        reader = rootReader.newObjectReader("version");
        m.setVersion(decoder0.decode(reader, m.getVersion()));
        return m;
    }
}