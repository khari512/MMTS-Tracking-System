package com.mangocrab.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2013-03-31 22:50:25")
/** */
public final class SuggestionsMeta extends org.slim3.datastore.ModelMeta<com.mangocrab.model.Suggestions> {

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.mangocrab.model.Suggestions> catageory = new org.slim3.datastore.StringAttributeMeta<com.mangocrab.model.Suggestions>(this, "catageory", "catageory");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.mangocrab.model.Suggestions, java.util.Date> createdDate = new org.slim3.datastore.CoreAttributeMeta<com.mangocrab.model.Suggestions, java.util.Date>(this, "createdDate", "createdDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.mangocrab.model.Suggestions, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<com.mangocrab.model.Suggestions, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.mangocrab.model.Suggestions> name = new org.slim3.datastore.StringAttributeMeta<com.mangocrab.model.Suggestions>(this, "name", "name");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.mangocrab.model.Suggestions> subject = new org.slim3.datastore.StringAttributeMeta<com.mangocrab.model.Suggestions>(this, "subject", "subject");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.mangocrab.model.Suggestions> suggestionString = new org.slim3.datastore.StringAttributeMeta<com.mangocrab.model.Suggestions>(this, "suggestionString", "suggestionString");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.mangocrab.model.Suggestions, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<com.mangocrab.model.Suggestions, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final SuggestionsMeta slim3_singleton = new SuggestionsMeta();

    /**
     * @return the singleton
     */
    public static SuggestionsMeta get() {
       return slim3_singleton;
    }

    /** */
    public SuggestionsMeta() {
        super("Suggestions", com.mangocrab.model.Suggestions.class);
    }

    @Override
    public com.mangocrab.model.Suggestions entityToModel(com.google.appengine.api.datastore.Entity entity) {
        com.mangocrab.model.Suggestions model = new com.mangocrab.model.Suggestions();
        model.setCatageory((java.lang.String) entity.getProperty("catageory"));
        model.setCreatedDate((java.util.Date) entity.getProperty("createdDate"));
        model.setKey(entity.getKey());
        model.setName((java.lang.String) entity.getProperty("name"));
        model.setSubject((java.lang.String) entity.getProperty("subject"));
        model.setSuggestionString((java.lang.String) entity.getProperty("suggestionString"));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        com.mangocrab.model.Suggestions m = (com.mangocrab.model.Suggestions) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("catageory", m.getCatageory());
        entity.setProperty("createdDate", m.getCreatedDate());
        entity.setProperty("name", m.getName());
        entity.setProperty("subject", m.getSubject());
        entity.setProperty("suggestionString", m.getSuggestionString());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        com.mangocrab.model.Suggestions m = (com.mangocrab.model.Suggestions) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        com.mangocrab.model.Suggestions m = (com.mangocrab.model.Suggestions) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        com.mangocrab.model.Suggestions m = (com.mangocrab.model.Suggestions) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
    }

    @Override
    protected void incrementVersion(Object model) {
        com.mangocrab.model.Suggestions m = (com.mangocrab.model.Suggestions) model;
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
        com.mangocrab.model.Suggestions m = (com.mangocrab.model.Suggestions) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getCatageory() != null){
            writer.setNextPropertyName("catageory");
            encoder0.encode(writer, m.getCatageory());
        }
        if(m.getCreatedDate() != null){
            writer.setNextPropertyName("createdDate");
            encoder0.encode(writer, m.getCreatedDate());
        }
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        if(m.getName() != null){
            writer.setNextPropertyName("name");
            encoder0.encode(writer, m.getName());
        }
        if(m.getSubject() != null){
            writer.setNextPropertyName("subject");
            encoder0.encode(writer, m.getSubject());
        }
        if(m.getSuggestionString() != null){
            writer.setNextPropertyName("suggestionString");
            encoder0.encode(writer, m.getSuggestionString());
        }
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder0.encode(writer, m.getVersion());
        }
        writer.endObject();
    }

    @Override
    protected com.mangocrab.model.Suggestions jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        com.mangocrab.model.Suggestions m = new com.mangocrab.model.Suggestions();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("catageory");
        m.setCatageory(decoder0.decode(reader, m.getCatageory()));
        reader = rootReader.newObjectReader("createdDate");
        m.setCreatedDate(decoder0.decode(reader, m.getCreatedDate()));
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("name");
        m.setName(decoder0.decode(reader, m.getName()));
        reader = rootReader.newObjectReader("subject");
        m.setSubject(decoder0.decode(reader, m.getSubject()));
        reader = rootReader.newObjectReader("suggestionString");
        m.setSuggestionString(decoder0.decode(reader, m.getSuggestionString()));
        reader = rootReader.newObjectReader("version");
        m.setVersion(decoder0.decode(reader, m.getVersion()));
        return m;
    }
}