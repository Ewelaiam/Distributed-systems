// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: proto/petrol_station_new_data.proto

package ds.grpc;

/**
 * Protobuf type {@code petrolStationNewData.PetrolStationPredictionResponse}
 */
public final class PetrolStationPredictionResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:petrolStationNewData.PetrolStationPredictionResponse)
    PetrolStationPredictionResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use PetrolStationPredictionResponse.newBuilder() to construct.
  private PetrolStationPredictionResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private PetrolStationPredictionResponse() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new PetrolStationPredictionResponse();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private PetrolStationPredictionResponse(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 9: {

            prediction_ = input.readDouble();
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (com.google.protobuf.UninitializedMessageException e) {
      throw e.asInvalidProtocolBufferException().setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return ds.grpc.PetrolStationNewDataProto.internal_static_petrolStationNewData_PetrolStationPredictionResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return ds.grpc.PetrolStationNewDataProto.internal_static_petrolStationNewData_PetrolStationPredictionResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            ds.grpc.PetrolStationPredictionResponse.class, ds.grpc.PetrolStationPredictionResponse.Builder.class);
  }

  public static final int PREDICTION_FIELD_NUMBER = 1;
  private double prediction_;
  /**
   * <code>double prediction = 1;</code>
   * @return The prediction.
   */
  @java.lang.Override
  public double getPrediction() {
    return prediction_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (java.lang.Double.doubleToRawLongBits(prediction_) != 0) {
      output.writeDouble(1, prediction_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (java.lang.Double.doubleToRawLongBits(prediction_) != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(1, prediction_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof ds.grpc.PetrolStationPredictionResponse)) {
      return super.equals(obj);
    }
    ds.grpc.PetrolStationPredictionResponse other = (ds.grpc.PetrolStationPredictionResponse) obj;

    if (java.lang.Double.doubleToLongBits(getPrediction())
        != java.lang.Double.doubleToLongBits(
            other.getPrediction())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + PREDICTION_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getPrediction()));
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static ds.grpc.PetrolStationPredictionResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.grpc.PetrolStationPredictionResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.grpc.PetrolStationPredictionResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.grpc.PetrolStationPredictionResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.grpc.PetrolStationPredictionResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ds.grpc.PetrolStationPredictionResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ds.grpc.PetrolStationPredictionResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ds.grpc.PetrolStationPredictionResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static ds.grpc.PetrolStationPredictionResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static ds.grpc.PetrolStationPredictionResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static ds.grpc.PetrolStationPredictionResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ds.grpc.PetrolStationPredictionResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(ds.grpc.PetrolStationPredictionResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code petrolStationNewData.PetrolStationPredictionResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:petrolStationNewData.PetrolStationPredictionResponse)
      ds.grpc.PetrolStationPredictionResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ds.grpc.PetrolStationNewDataProto.internal_static_petrolStationNewData_PetrolStationPredictionResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ds.grpc.PetrolStationNewDataProto.internal_static_petrolStationNewData_PetrolStationPredictionResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ds.grpc.PetrolStationPredictionResponse.class, ds.grpc.PetrolStationPredictionResponse.Builder.class);
    }

    // Construct using ds.grpc.PetrolStationPredictionResponse.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      prediction_ = 0D;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return ds.grpc.PetrolStationNewDataProto.internal_static_petrolStationNewData_PetrolStationPredictionResponse_descriptor;
    }

    @java.lang.Override
    public ds.grpc.PetrolStationPredictionResponse getDefaultInstanceForType() {
      return ds.grpc.PetrolStationPredictionResponse.getDefaultInstance();
    }

    @java.lang.Override
    public ds.grpc.PetrolStationPredictionResponse build() {
      ds.grpc.PetrolStationPredictionResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public ds.grpc.PetrolStationPredictionResponse buildPartial() {
      ds.grpc.PetrolStationPredictionResponse result = new ds.grpc.PetrolStationPredictionResponse(this);
      result.prediction_ = prediction_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof ds.grpc.PetrolStationPredictionResponse) {
        return mergeFrom((ds.grpc.PetrolStationPredictionResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(ds.grpc.PetrolStationPredictionResponse other) {
      if (other == ds.grpc.PetrolStationPredictionResponse.getDefaultInstance()) return this;
      if (other.getPrediction() != 0D) {
        setPrediction(other.getPrediction());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      ds.grpc.PetrolStationPredictionResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (ds.grpc.PetrolStationPredictionResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private double prediction_ ;
    /**
     * <code>double prediction = 1;</code>
     * @return The prediction.
     */
    @java.lang.Override
    public double getPrediction() {
      return prediction_;
    }
    /**
     * <code>double prediction = 1;</code>
     * @param value The prediction to set.
     * @return This builder for chaining.
     */
    public Builder setPrediction(double value) {
      
      prediction_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>double prediction = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearPrediction() {
      
      prediction_ = 0D;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:petrolStationNewData.PetrolStationPredictionResponse)
  }

  // @@protoc_insertion_point(class_scope:petrolStationNewData.PetrolStationPredictionResponse)
  private static final ds.grpc.PetrolStationPredictionResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new ds.grpc.PetrolStationPredictionResponse();
  }

  public static ds.grpc.PetrolStationPredictionResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<PetrolStationPredictionResponse>
      PARSER = new com.google.protobuf.AbstractParser<PetrolStationPredictionResponse>() {
    @java.lang.Override
    public PetrolStationPredictionResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new PetrolStationPredictionResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<PetrolStationPredictionResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<PetrolStationPredictionResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public ds.grpc.PetrolStationPredictionResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

