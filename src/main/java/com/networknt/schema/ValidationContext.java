package com.networknt.schema;

import com.fasterxml.jackson.databind.JsonNode;

public class ValidationContext {
    private final JsonMetaSchema metaSchema;
    private final JsonSchemaFactory jsonSchemaFactory;
    private ValidatorConfig config;
    
    public ValidationContext(JsonMetaSchema metaSchema, JsonSchemaFactory jsonSchemaFactory) {
        if (metaSchema == null) {
            throw new IllegalArgumentException("JsonMetaSchema must not be null");
        }
        if (jsonSchemaFactory == null) {
            throw new IllegalArgumentException("JsonSchemaFactory must not be null");
        }
        this.metaSchema = metaSchema;
        this.jsonSchemaFactory = jsonSchemaFactory;
    }
    
    public JsonValidator newValidator(String schemaPath, String keyword /* keyword */, JsonNode schemaNode,
                                      JsonSchema parentSchema) {
        return metaSchema.newValidator(this, schemaPath, keyword, schemaNode, parentSchema);
    }
    
    public JsonSchemaFactory getJsonSchemaFactory() {
        return jsonSchemaFactory;
    }

    public ValidatorConfig getConfig() {
        return config;
    }

    public void setConfig(ValidatorConfig config) {
        this.config = config;
    }
}
